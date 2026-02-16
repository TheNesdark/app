package Mantenimiento;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/JIPconsultar.class */
public class JIPconsultar extends JInternalFrame {
    private String[] xidarea;
    public DefaultTableModel xmodelo;
    public String sql;
    public Object[] dato;
    public claseMantenimiento Cmantenimiento;
    private JButton JBactualiza;
    private JComboBox JCBArea;
    private JDateChooser JDCfecha2;
    private JDateChooser JFCfecha1;
    private JPanel JPFilAccion;
    private JRadioButton JRBarea;
    private JRadioButton JRBestado1;
    private JRadioButton JRBfecha;
    private JRadioButton JRBtipo;
    private JRadioButton JRBtodos;
    private ButtonGroup buttonGroup1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private Metodos Fecha = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public boolean lleno = false;

    public JIPconsultar(claseMantenimiento Cmantenimiento) {
        initComponents();
        this.Cmantenimiento = Cmantenimiento;
        this.JFCfecha1.setDate(this.Fecha.getFechaActual());
        this.JDCfecha2.setDate(this.Fecha.getFechaActual());
        crearGrid();
        llenarcombo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Area", "Tipo", "Fecha", "Evaluacion", "Estado", "Usuario", "Descriopcion"}) { // from class: Mantenimiento.JIPconsultar.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.jTable1.setModel(this.xmodelo);
        this.jTable1.getColumnModel().getColumn(0).setPreferredWidth(6);
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(90);
        this.jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.jTable1.getColumnModel().getColumn(4).setPreferredWidth(35);
        this.jTable1.getColumnModel().getColumn(5).setPreferredWidth(60);
        this.jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.jTable1.getColumnModel().getColumn(7).setPreferredWidth(200);
    }

    public void cargarDatos(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(rs.getString(1), n, 0);
                    this.xmodelo.setValueAt(rs.getString(2), n, 1);
                    this.xmodelo.setValueAt(rs.getString(3), n, 2);
                    this.xmodelo.setValueAt(rs.getString(4), n, 3);
                    this.xmodelo.setValueAt(rs.getString(5), n, 4);
                    this.xmodelo.setValueAt(rs.getString(6), n, 5);
                    this.xmodelo.setValueAt(rs.getString(7), n, 6);
                    this.xmodelo.setValueAt(rs.getString(8), n, 7);
                    n++;
                }
                rs.close();
                this.xconsulta.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            this.xconsulta.mostrarErrorSQL(ex);
        }
    }

    private void llenarcombo() {
        this.xidarea = null;
        this.JCBArea.removeAllItems();
        if (this.JRBarea.isSelected()) {
            this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.f_centrocosto WHERE (Estado =0) ORDER BY Nbre ASC", this.xidarea, this.JCBArea);
            this.JCBArea.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.lleno = true;
            return;
        }
        if (this.JRBtipo.isSelected()) {
            this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tiporeporte WHERE (Estado =1) ORDER BY Nbre ASC", this.xidarea, this.JCBArea);
            this.JCBArea.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.lleno = true;
            return;
        }
        if (this.JRBestado1.isSelected()) {
            this.xidarea = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.m_tipoestadoreporte WHERE (Estado =1) ORDER BY Nbre ASC", this.xidarea, this.JCBArea);
            this.JCBArea.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.lleno = true;
            return;
        }
        if (this.JRBtodos.isSelected()) {
            this.JCBArea.setSelectedIndex(-1);
            this.sql = "SELECT    m_reporte.Id    , f_centrocosto.Nbre    , m_tiporeporte.Nbre    , date_format( m_reporte.FechaR,'%d/%m/%y')    , m_reporte.TipoEvaluacion    , m_tipoestadoreporte.Nbre    , persona.NUsuario    , m_reporte.DescripcionR FROM     baseserver.m_reporte    INNER JOIN baseserver.m_tipoestadoreporte         ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)    INNER JOIN baseserver.m_tiporeporte         ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id)    INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.persona  ON (m_reporte.Id_UsuarioS = persona.Id_persona)order by m_reporte.FechaR desc";
            crearGrid();
            cargarDatos(this.sql);
            this.lleno = false;
            return;
        }
        if (this.JRBfecha.isSelected()) {
            this.JCBArea.setSelectedIndex(-1);
            this.sql = "SELECT    m_reporte.Id    , f_centrocosto.Nbre    , m_tiporeporte.Nbre    , date_format( m_reporte.FechaR,'%d/%m/%y'), m_reporte.TipoEvaluacion    , m_tipoestadoreporte.Nbre    , persona.NUsuario    , m_reporte.DescripcionR FROM     baseserver.m_reporte    INNER JOIN baseserver.m_tipoestadoreporte         ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)    INNER JOIN baseserver.m_tiporeporte         ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id)    INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.persona  ON (m_reporte.Id_UsuarioS = persona.Id_persona) order by m_reporte.FechaR desc";
            crearGrid();
            cargarDatos(this.sql);
            this.lleno = false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JPFilAccion = new JPanel();
        this.JRBtipo = new JRadioButton();
        this.JRBarea = new JRadioButton();
        this.JRBestado1 = new JRadioButton();
        this.JCBArea = new JComboBox();
        this.jPanel2 = new JPanel();
        this.JRBfecha = new JRadioButton();
        this.JFCfecha1 = new JDateChooser();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.JDCfecha2 = new JDateChooser();
        this.JBactualiza = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jTable1 = new JTable();
        this.JRBtodos = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSULTAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1013, 451));
        setMinimumSize(new Dimension(1013, 451));
        setPreferredSize(new Dimension(1013, 451));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder(0));
        this.JPFilAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO POR ACCIÓN", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.buttonGroup1.add(this.JRBtipo);
        this.JRBtipo.setFont(new Font("Arial", 1, 12));
        this.JRBtipo.setForeground(new Color(0, 0, 255));
        this.JRBtipo.setText("Tipo");
        this.JRBtipo.addActionListener(new ActionListener() { // from class: Mantenimiento.JIPconsultar.2
            public void actionPerformed(ActionEvent evt) {
                JIPconsultar.this.JRBtipoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBarea);
        this.JRBarea.setFont(new Font("Arial", 1, 12));
        this.JRBarea.setForeground(new Color(0, 0, 255));
        this.JRBarea.setText("Area");
        this.JRBarea.addActionListener(new ActionListener() { // from class: Mantenimiento.JIPconsultar.3
            public void actionPerformed(ActionEvent evt) {
                JIPconsultar.this.JRBareaActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBestado1);
        this.JRBestado1.setFont(new Font("Arial", 1, 12));
        this.JRBestado1.setForeground(new Color(0, 0, 255));
        this.JRBestado1.setText("Estado");
        this.JRBestado1.addActionListener(new ActionListener() { // from class: Mantenimiento.JIPconsultar.4
            public void actionPerformed(ActionEvent evt) {
                JIPconsultar.this.JRBestado1ActionPerformed(evt);
            }
        });
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createBevelBorder(0));
        this.JCBArea.addItemListener(new ItemListener() { // from class: Mantenimiento.JIPconsultar.5
            public void itemStateChanged(ItemEvent evt) {
                JIPconsultar.this.JCBAreaItemStateChanged(evt);
            }
        });
        GroupLayout JPFilAccionLayout = new GroupLayout(this.JPFilAccion);
        this.JPFilAccion.setLayout(JPFilAccionLayout);
        JPFilAccionLayout.setHorizontalGroup(JPFilAccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFilAccionLayout.createSequentialGroup().addContainerGap().addGroup(JPFilAccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFilAccionLayout.createSequentialGroup().addComponent(this.JRBtipo).addGap(18, 18, 18).addComponent(this.JRBarea).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1, 32767).addComponent(this.JRBestado1)).addComponent(this.JCBArea, -2, 179, -2)).addContainerGap()));
        JPFilAccionLayout.setVerticalGroup(JPFilAccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFilAccionLayout.createSequentialGroup().addGroup(JPFilAccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBtipo).addComponent(this.JRBarea).addComponent(this.JRBestado1)).addGap(3, 3, 3).addComponent(this.JCBArea, -2, 22, -2).addContainerGap()));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO ENTRE FECHAS", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.buttonGroup1.add(this.JRBfecha);
        this.JRBfecha.setFont(new Font("Arial", 1, 12));
        this.JRBfecha.setForeground(new Color(0, 0, 255));
        this.JRBfecha.setText("Fecha");
        this.JRBfecha.addActionListener(new ActionListener() { // from class: Mantenimiento.JIPconsultar.6
            public void actionPerformed(ActionEvent evt) {
                JIPconsultar.this.JRBfechaActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.JRBfecha);
        this.JRBfecha.setBounds(14, 23, 59, 28);
        this.JFCfecha1.setDateFormatString("dd/MM/yyyy");
        this.JFCfecha1.setFont(new Font("Arial", 1, 12));
        this.jPanel2.add(this.JFCfecha1);
        this.JFCfecha1.setBounds(131, 31, 143, 20);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 255));
        this.jLabel2.setText("Desde");
        this.jPanel2.add(this.jLabel2);
        this.jLabel2.setBounds(91, 36, 36, 15);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 255));
        this.jLabel3.setText("Hasta");
        this.jPanel2.add(this.jLabel3);
        this.jLabel3.setBounds(284, 36, 33, 15);
        this.JDCfecha2.setDateFormatString("dd/MM/yyyy");
        this.JDCfecha2.setFont(new Font("Arial", 1, 12));
        this.jPanel2.add(this.JDCfecha2);
        this.JDCfecha2.setBounds(327, 31, 122, 20);
        this.JBactualiza.setFont(new Font("Arial", 1, 12));
        this.JBactualiza.setBorder((Border) null);
        this.JBactualiza.setCursor(new Cursor(0));
        this.JBactualiza.setEnabled(false);
        this.JBactualiza.setOpaque(false);
        this.JBactualiza.addActionListener(new ActionListener() { // from class: Mantenimiento.JIPconsultar.7
            public void actionPerformed(ActionEvent evt) {
                JIPconsultar.this.JBactualizaActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.JBactualiza);
        this.JBactualiza.setBounds(460, 20, 50, 40);
        this.jTable1.setFont(new Font("Arial", 1, 12));
        this.jTable1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jTable1.setRowHeight(25);
        this.jTable1.setSelectionBackground(new Color(255, 255, 255));
        this.jTable1.setSelectionForeground(Color.red);
        this.jTable1.setSelectionMode(0);
        this.jTable1.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIPconsultar.8
            public void mouseClicked(MouseEvent evt) {
                JIPconsultar.this.jTable1MouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.jTable1);
        this.buttonGroup1.add(this.JRBtodos);
        this.JRBtodos.setFont(new Font("Arial", 1, 12));
        this.JRBtodos.setForeground(new Color(0, 0, 255));
        this.JRBtodos.setSelected(true);
        this.JRBtodos.setText("Mostrar Todos");
        this.JRBtodos.addActionListener(new ActionListener() { // from class: Mantenimiento.JIPconsultar.9
            public void actionPerformed(ActionEvent evt) {
                JIPconsultar.this.JRBtodosActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPFilAccion, -2, -1, -2).addGap(10, 10, 10).addComponent(this.jPanel2, -2, 560, -2).addGap(10, 10, 10).addComponent(this.JRBtodos, -2, 140, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.jScrollPane1, -2, 959, -2))).addContainerGap(16, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPFilAccion, -2, 80, -2)).addComponent(this.jPanel2, -2, 70, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JRBtodos, -2, 60, -2))).addGap(7, 7, 7).addComponent(this.jScrollPane1, -1, 284, 32767).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBtipoActionPerformed(ActionEvent evt) {
        llenarcombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBestado1ActionPerformed(ActionEvent evt) {
        llenarcombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBareaActionPerformed(ActionEvent evt) {
        llenarcombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBtodosActionPerformed(ActionEvent evt) {
        llenarcombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAreaItemStateChanged(ItemEvent evt) {
        if (this.lleno) {
            if (this.JRBtipo.isSelected()) {
                this.sql = "SELECT    m_reporte.Id    , f_centrocosto.Nbre    , m_tiporeporte.Nbre    , date_format( m_reporte.FechaR,'%d/%m/%y')    , m_reporte.TipoEvaluacion    , m_tipoestadoreporte.Nbre    , persona.NUsuario    , m_reporte.DescripcionR FROM     baseserver.m_reporte    INNER JOIN baseserver.m_tipoestadoreporte         ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)    INNER JOIN baseserver.m_tiporeporte         ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id)    INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.persona  ON (m_reporte.Id_UsuarioS = persona.Id_persona) where m_reporte.Id_tiporeporte= '" + this.xidarea[this.JCBArea.getSelectedIndex()] + "' order by m_reporte.FechaR desc";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.JRBarea.isSelected()) {
                this.sql = "SELECT    m_reporte.Id    , f_centrocosto.Nbre    , m_tiporeporte.Nbre    , date_format( m_reporte.FechaR,'%d/%m/%y')    , m_reporte.TipoEvaluacion    , m_tipoestadoreporte.Nbre    , persona.NUsuario    , m_reporte.DescripcionR FROM     baseserver.m_reporte    INNER JOIN baseserver.m_tipoestadoreporte         ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)    INNER JOIN baseserver.m_tiporeporte         ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id)    INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.persona  ON (m_reporte.Id_UsuarioS = persona.Id_persona) where m_reporte.Id_Area= '" + this.xidarea[this.JCBArea.getSelectedIndex()] + "' order by m_reporte.FechaR desc";
                crearGrid();
                cargarDatos(this.sql);
            }
            if (this.JRBestado1.isSelected()) {
                this.sql = "SELECT    m_reporte.Id    , f_centrocosto.Nbre    , m_tiporeporte.Nbre    , date_format( m_reporte.FechaR,'%d/%m/%y')    , m_reporte.TipoEvaluacion    , m_tipoestadoreporte.Nbre    , persona.NUsuario    , m_reporte.DescripcionR FROM     baseserver.m_reporte    INNER JOIN baseserver.m_tipoestadoreporte         ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)    INNER JOIN baseserver.m_tiporeporte         ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id)    INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.persona  ON (m_reporte.Id_UsuarioS = persona.Id_persona) where m_reporte.Id_EstadoReporte= '" + this.xidarea[this.JCBArea.getSelectedIndex()] + "' order by m_reporte.FechaR desc";
                crearGrid();
                cargarDatos(this.sql);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBfechaActionPerformed(ActionEvent evt) {
        llenarcombo();
        this.JBactualiza.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBactualizaActionPerformed(ActionEvent evt) {
        this.sql = "SELECT    m_reporte.Id    , f_centrocosto.Nbre    , m_tiporeporte.Nbre    , m_reporte.FechaR    , m_reporte.TipoEvaluacion    , m_tipoestadoreporte.Nbre    , persona.NUsuario    , m_reporte.DescripcionR FROM     baseserver.m_reporte    INNER JOIN baseserver.m_tipoestadoreporte         ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)    INNER JOIN baseserver.m_tiporeporte         ON (m_reporte.Id_TipoReporte = m_tiporeporte.Id)    INNER JOIN baseserver.f_centrocosto  ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.persona  ON (m_reporte.Id_UsuarioS = persona.Id_persona) where date_format( m_reporte.FechaR,'%d/%m/%y') >= '" + this.Fecha.formatoDMA.format(this.JFCfecha1.getDate()) + "' and date_format( m_reporte.FechaR,'%d/%m/%y') <= '" + this.Fecha.formatoDMA.format(this.JDCfecha2.getDate()) + "' ";
        crearGrid();
        cargarDatos(this.sql);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTable1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.Cmantenimiento.cargarPantalla("Seguimiento", this.xmodelo.getValueAt(this.jTable1.getSelectedRow(), 0).toString());
        }
    }
}
