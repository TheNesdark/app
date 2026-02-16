package Armado;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIF_Consultar_DatosG.class */
public class JIF_Consultar_DatosG extends JInternalFrame {
    private String[] xidempresa;
    public DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private JButton JBTExportar;
    private JComboBox JCBEmpresa;
    private JCheckBox JCH_Filtro;
    private JDateChooser JDCFechaFin;
    private JDateChooser JDCFechaInicio;
    private JPanel JPIDatoP;
    private JPanel JPI_Estado;
    private JRadioButton JRB_EActivos;
    private JRadioButton JRB_EAnulados;
    private JRadioButton JRB_ETodos;
    private JScrollPane JSPResultado;
    private JTable JTBResultado;
    private JFormattedTextField JTFFTotalEps;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xEstado = "0";
    private boolean xlleno = false;

    public JIF_Consultar_DatosG(String xNombre, String xTitulo) {
        initComponents();
        setTitle(xTitulo);
        setName(xNombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v63, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatoP = new JPanel();
        this.JDCFechaInicio = new JDateChooser();
        this.JDCFechaFin = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JCH_Filtro = new JCheckBox();
        this.JPI_Estado = new JPanel();
        this.JRB_ETodos = new JRadioButton();
        this.JRB_EActivos = new JRadioButton();
        this.JRB_EAnulados = new JRadioButton();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTFFTotalEps = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN FACTURA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPIDatoP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFechaInicio.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDCFechaInicio.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIF_Consultar_DatosG.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Consultar_DatosG.this.JDCFechaInicioPropertyChange(evt);
            }
        });
        this.JDCFechaFin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaFin.setFont(new Font("Arial", 1, 12));
        this.JDCFechaFin.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIF_Consultar_DatosG.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIF_Consultar_DatosG.this.JDCFechaFinPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setSelected(true);
        this.JCH_Filtro.setText("Filtro");
        this.JCH_Filtro.addActionListener(new ActionListener() { // from class: Armado.JIF_Consultar_DatosG.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_DatosG.this.JCH_FiltroActionPerformed(evt);
            }
        });
        this.JPI_Estado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.JRB_ETodos);
        this.JRB_ETodos.setFont(new Font("Arial", 1, 12));
        this.JRB_ETodos.setText("Todos");
        this.JRB_ETodos.addActionListener(new ActionListener() { // from class: Armado.JIF_Consultar_DatosG.4
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_DatosG.this.JRB_ETodosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRB_EActivos);
        this.JRB_EActivos.setFont(new Font("Arial", 1, 12));
        this.JRB_EActivos.setSelected(true);
        this.JRB_EActivos.setText("Activos");
        this.JRB_EActivos.addActionListener(new ActionListener() { // from class: Armado.JIF_Consultar_DatosG.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_DatosG.this.JRB_EActivosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRB_EAnulados);
        this.JRB_EAnulados.setFont(new Font("Arial", 1, 12));
        this.JRB_EAnulados.setText("Anulados");
        this.JRB_EAnulados.addActionListener(new ActionListener() { // from class: Armado.JIF_Consultar_DatosG.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_DatosG.this.JRB_EAnuladosActionPerformed(evt);
            }
        });
        GroupLayout JPI_EstadoLayout = new GroupLayout(this.JPI_Estado);
        this.JPI_Estado.setLayout(JPI_EstadoLayout);
        JPI_EstadoLayout.setHorizontalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_ETodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EActivos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRB_EAnulados).addContainerGap(-1, 32767)));
        JPI_EstadoLayout.setVerticalGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_EstadoLayout.createSequentialGroup().addGap(0, 0, 0).addGroup(JPI_EstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_ETodos).addComponent(this.JRB_EActivos).addComponent(this.JRB_EAnulados)).addGap(0, 0, 0)));
        GroupLayout JPIDatoPLayout = new GroupLayout(this.JPIDatoP);
        this.JPIDatoP.setLayout(JPIDatoPLayout);
        JPIDatoPLayout.setHorizontalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatoPLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaInicio, -2, 120, -2).addGap(10, 10, 10).addComponent(this.JDCFechaFin, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBEmpresa, -2, 517, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Filtro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Estado, -1, -1, -2).addGap(10, 10, 10)));
        JPIDatoPLayout.setVerticalGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatoPLayout.createSequentialGroup().addGroup(JPIDatoPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatoPLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCH_Filtro)).addComponent(this.JDCFechaFin, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDCFechaInicio, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBEmpresa).addComponent(this.JPI_Estado, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap()));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setEditingColumn(1);
        this.JTBResultado.setEditingRow(1);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(Color.red);
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Armado.JIF_Consultar_DatosG.7
            public void mouseClicked(MouseEvent evt) {
                JIF_Consultar_DatosG.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Armado.JIF_Consultar_DatosG.8
            public void actionPerformed(ActionEvent evt) {
                JIF_Consultar_DatosG.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFFTotalEps.setEditable(false);
        this.JTFFTotalEps.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "TOTAL ENTIDAD", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFTotalEps.setHorizontalAlignment(4);
        this.JTFFTotalEps.setText("0");
        this.JTFFTotalEps.setFont(new Font("Arial", 1, 14));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 730, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotalEps)).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatoP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatoP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -1, 329, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalEps, -1, 50, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTExportar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING, -1, 43, 32767)).addGap(0, 0, 32767))).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaInicioPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFinPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarCEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTBResultado.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBResultado, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_FiltroActionPerformed(ActionEvent evt) {
        mLLenarCEmpresa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_ETodosActionPerformed(ActionEvent evt) {
        this.xEstado = "0,1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EActivosActionPerformed(ActionEvent evt) {
        this.xEstado = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_EAnuladosActionPerformed(ActionEvent evt) {
        this.xEstado = "1";
    }

    private void mLLenarCEmpresa() {
        this.JCBEmpresa.removeAllItems();
        this.xsql = "SELECT `f_empresacontxconvenio`.`Id` , `f_empresacontxconvenio`.`Nbre` FROM `ingreso` INNER JOIN  `f_liquidacion`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `f_empresacontxconvenio`   ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) WHERE (`f_liquidacion`.`Estado` =0 AND  ingreso.`FechaIngreso`>='" + this.xmt.formatoAMD1.format(this.JDCFechaInicio.getDate()) + "' AND  ingreso.`FechaIngreso` <='" + this.xmt.formatoAMD1.format(this.JDCFechaFin.getDate()) + "') GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
        this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDCFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDCFechaFin.setDate(this.xmt.getFechaActual());
        mLLenarCEmpresa();
        if (getName().equals("xjif_consultarDG")) {
            mCrear_Detalle_F1();
        } else if (getName().equals("xjif_consultarDG1")) {
            mCrear_Detalle_F2();
        }
        this.JTFFTotalEps.setValue(new Double(0.0d));
        this.xlleno = true;
    }

    private void mCrear_Detalle_F1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Empresa", "Grupo", "Subgrupo", "TServicio", "T/CModeradora", "T/CCopago", "T/Neto"}) { // from class: Armado.JIF_Consultar_DatosG.9
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    private void mCrear_Detalle_F2() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Facturador", "Empresa", "Grupo", "Subgrupo", "Cant.", "TServicio", "T/CModeradora", "T/CCopago", "T/Neto"}) { // from class: Armado.JIF_Consultar_DatosG.10
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, Double.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTBResultado.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    private void mCargarDatos_F1() {
        mCrear_Detalle_F1();
        if (this.JCH_Filtro.isSelected()) {
            this.xsql = "SELECT `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `f_gruposervicio`.`Nbre` AS `Grupo` , `f_subgruposervicio`.`Nbre` AS `Subgrupo` , SUM(`f_liquidacion`.`TotalServicio`) AS `TServicio` , SUM(`f_liquidacion`.`CuotaModeradora`) AS `TCModeradora` , SUM(`f_liquidacion`.`Copago`) AS `TCOpago` , SUM(`f_liquidacion`.`TotalEps`) AS `TotalEps`  FROM   `f_empresacontxconvenio` INNER JOIN   `f_liquidacion`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`) INNER JOIN   `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN   `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN   `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN   `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) WHERE (`f_empresacontxconvenio`.`Id`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' and  `f_liquidacion`.`Estado` IN(" + this.xEstado + ") AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "') GROUP BY `f_empresacontxconvenio`.`Id`, `Grupo`, `Subgrupo` ORDER BY `NEmpresa` ASC, `Grupo` ASC, `Subgrupo` ASC ";
        } else {
            this.xsql = "SELECT `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `f_gruposervicio`.`Nbre` AS `Grupo` , `f_subgruposervicio`.`Nbre` AS `Subgrupo` , SUM(`f_liquidacion`.`TotalServicio`) AS `TServicio` , SUM(`f_liquidacion`.`CuotaModeradora`) AS `TCModeradora` , SUM(`f_liquidacion`.`Copago`) AS `TCOpago` , SUM(`f_liquidacion`.`TotalEps`) AS `TotalEps`  FROM   `f_empresacontxconvenio` INNER JOIN   `f_liquidacion`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`) INNER JOIN   `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN   `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN   `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN   `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) WHERE (`f_liquidacion`.`Estado` IN(" + this.xEstado + ") AND `ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "') GROUP BY `f_empresacontxconvenio`.`Id`, `Grupo`, `Subgrupo` ORDER BY `NEmpresa` ASC, `Grupo` ASC, `Subgrupo` ASC ";
        }
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            double xvalor = 0.0d;
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    xvalor += rs.getDouble(7);
                    x++;
                }
            }
            this.JTFFTotalEps.setValue(Double.valueOf(xvalor));
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatos_F2() {
        mCrear_Detalle_F2();
        if (this.JCH_Filtro.isSelected()) {
            this.xsql = "SELECT `persona`.`NUsuario` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `f_gruposervicio`.`Nbre` AS `Grupo` , `f_subgruposervicio`.`Nbre` AS `Subgrupo` , COUNT(`f_liquidacion`.`Id`) AS `CantidadF`         , SUM(`f_liquidacion`.`TotalServicio`) AS `TServicio`     , SUM(`f_liquidacion`.`CuotaModeradora`) AS `TCModeradora` , SUM(`f_liquidacion`.`Copago`) AS `TCOpago` , SUM(`f_liquidacion`.`TotalEps`) AS `TotalEps` FROM  `f_empresacontxconvenio` INNER JOIN  `f_liquidacion`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`) INNER JOIN  `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `rh_tipo_persona_cargon`  ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `rh_tipo_persona_cargon`.`Id_Persona`) WHERE (`f_empresacontxconvenio`.`Id`='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' and `f_liquidacion`.`Estado` IN(" + this.xEstado + ") AND '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "') GROUP BY `persona`.`Id_persona`, `f_empresacontxconvenio`.`Id`, `Grupo`, `Subgrupo` ORDER BY `persona`.`NUsuario` ASC, `NEmpresa` ASC, `Grupo` ASC, `Subgrupo` ASC";
        } else {
            this.xsql = "SELECT `persona`.`NUsuario` , `f_empresacontxconvenio`.`Nbre` AS `NEmpresa` , `f_gruposervicio`.`Nbre` AS `Grupo` , `f_subgruposervicio`.`Nbre` AS `Subgrupo` , COUNT(`f_liquidacion`.`Id`) AS `CantidadF`         , SUM(`f_liquidacion`.`TotalServicio`) AS `TServicio`     , SUM(`f_liquidacion`.`CuotaModeradora`) AS `TCModeradora` , SUM(`f_liquidacion`.`Copago`) AS `TCOpago` , SUM(`f_liquidacion`.`TotalEps`) AS `TotalEps` FROM  `f_empresacontxconvenio` INNER JOIN  `f_liquidacion`  ON (`f_empresacontxconvenio`.`Id` = `f_liquidacion`.`IdEmpresaContxConv`) INNER JOIN  `f_subgrupo_empresa`  ON (`f_liquidacion`.`Id_SubGrupoServicio` = `f_subgrupo_empresa`.`Id`) INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_gruposervicio`  ON (`f_subgruposervicio`.`Id_GrupoServicio` = `f_gruposervicio`.`Id_GrupoServicio`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `rh_tipo_persona_cargon`  ON (`rh_tipo_persona_cargon`.`Id` = `f_liquidacion`.`Id_UsuarioRH`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `rh_tipo_persona_cargon`.`Id_Persona`) WHERE (`f_liquidacion`.`Estado` IN(" + this.xEstado + ") AND '" + this.xmt.formatoAMD.format(this.JDCFechaInicio.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDCFechaFin.getDate()) + "') GROUP BY `persona`.`Id_persona`, `f_empresacontxconvenio`.`Id`, `Grupo`, `Subgrupo` ORDER BY `persona`.`NUsuario` ASC, `NEmpresa` ASC, `Grupo` ASC, `Subgrupo` ASC";
        }
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(7)), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    xvalor += rs.getDouble(9);
                    x++;
                }
            }
            this.JTFFTotalEps.setValue(Double.valueOf(xvalor));
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultarCuentaxEmpresa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.JCH_Filtro.isSelected()) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                if (getName().equals("xjif_consultarDG")) {
                    mCargarDatos_F1();
                    return;
                } else {
                    if (getName().equals("xjif_consultarDG1")) {
                        mCargarDatos_F2();
                        return;
                    }
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCBEmpresa.requestFocus();
            return;
        }
        if (getName().equals("xjif_consultarDG")) {
            mCargarDatos_F1();
        } else if (getName().equals("xjif_consultarDG1")) {
            mCargarDatos_F2();
        }
    }
}
