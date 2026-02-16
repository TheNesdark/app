package Mantenimiento;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/JIFTiemporeporte.class */
public class JIFTiemporeporte extends JInternalFrame {
    public claseMantenimiento Cmantenimiento;
    public Object[] dato;
    public String sql;
    public String sql2;
    public int total;
    public int n;
    public int n1;
    private JDateChooser JDCFechaF;
    private JDateChooser JDCFechaI;
    private JPanel JPIConsolidado;
    private JPanel JPIConsolidado1;
    private JPanel JPIDatosC;
    private JScrollPane JSPDetalleResultado;
    private JScrollPane JSPDetalleResultado1;
    private JTable JTResultado;
    private JTable JTResultado1;
    private JFormattedTextField Nreportes;
    private JFormattedTextField Pdias;
    private JFormattedTextField Rabierto;
    private JFormattedTextField Rcerrado;
    private JFormattedTextField Tdias;
    private JRadioButton betanci;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JButton jButton1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JRadioButton mina;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public DefaultTableModel xmodelo = new DefaultTableModel();
    public DefaultTableModel xmodelo1 = new DefaultTableModel();
    public DefaultTableModel xmodelo2 = new DefaultTableModel();
    public boolean lleno = false;
    public int xtodo1 = 0;
    public int xtodo = 0;
    public int tdias = 0;
    public int tdias2 = 0;
    public int promedio = 0;
    public int promediod = 0;
    public int sede = 0;

    public JIFTiemporeporte(claseMantenimiento Cmantenimiento) {
        initComponents();
        this.Cmantenimiento = Cmantenimiento;
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JPIDatosC = new JPanel();
        this.JSPDetalleResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.jPanel2 = new JPanel();
        this.JSPDetalleResultado1 = new JScrollPane();
        this.JTResultado1 = new JTable();
        this.JPIConsolidado = new JPanel();
        this.Nreportes = new JFormattedTextField();
        this.Tdias = new JFormattedTextField();
        this.Pdias = new JFormattedTextField();
        this.JPIConsolidado1 = new JPanel();
        this.Rcerrado = new JFormattedTextField();
        this.Rabierto = new JFormattedTextField();
        this.jPanel1 = new JPanel();
        this.JDCFechaF = new JDateChooser();
        this.JDCFechaI = new JDateChooser();
        this.jButton1 = new JButton();
        this.mina = new JRadioButton();
        this.betanci = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TIEMPO REPORTES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1182, 661));
        setMinimumSize(new Dimension(1182, 661));
        setName("JIFTiemporeporte");
        setPreferredSize(new Dimension(1182, 661));
        getContentPane().setLayout(new AbsoluteLayout());
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "REPORTES CERRADOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFTiemporeporte.1
            public void mouseClicked(MouseEvent evt) {
                JIFTiemporeporte.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalleResultado.setViewportView(this.JTResultado);
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleResultado, -1, 568, 32767));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleResultado, -1, 474, 32767));
        getContentPane().add(this.JPIDatosC, new AbsoluteConstraints(10, 100, 580, 500));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "REPORTES POR CERRAR", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDetalleResultado1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTResultado1.setFont(new Font("Arial", 1, 12));
        this.JTResultado1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTResultado1.setRowHeight(25);
        this.JTResultado1.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado1.setSelectionForeground(Color.red);
        this.JTResultado1.setSelectionMode(0);
        this.JTResultado1.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.JIFTiemporeporte.2
            public void mouseClicked(MouseEvent evt) {
                JIFTiemporeporte.this.JTResultado1MouseClicked(evt);
            }
        });
        this.JSPDetalleResultado1.setViewportView(this.JTResultado1);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleResultado1, GroupLayout.Alignment.TRAILING, -1, 518, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleResultado1, -1, 474, 32767));
        getContentPane().add(this.jPanel2, new AbsoluteConstraints(600, 100, 530, 500));
        this.JPIConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPIConsolidado.setLayout(new AbsoluteLayout());
        this.Nreportes.setBackground(new Color(51, 153, 255));
        this.Nreportes.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Reportes", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.Nreportes.setForeground(new Color(255, 255, 255));
        this.Nreportes.setHorizontalAlignment(4);
        this.Nreportes.setFont(new Font("Arial", 1, 14));
        this.JPIConsolidado.add(this.Nreportes, new AbsoluteConstraints(16, 23, 114, -1));
        this.Tdias.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Dias", 0, 0, new Font("Arial", 1, 12)));
        this.Tdias.setHorizontalAlignment(4);
        this.Tdias.setFont(new Font("Arial", 1, 14));
        this.JPIConsolidado.add(this.Tdias, new AbsoluteConstraints(140, 23, 89, -1));
        this.Pdias.setBorder(BorderFactory.createTitledBorder((Border) null, "Prom (Dias)", 0, 0, new Font("Arial", 1, 12)));
        this.Pdias.setHorizontalAlignment(4);
        this.Pdias.setFont(new Font("Arial", 1, 14));
        this.JPIConsolidado.add(this.Pdias, new AbsoluteConstraints(247, 23, 92, -1));
        getContentPane().add(this.JPIConsolidado, new AbsoluteConstraints(570, 0, 347, 90));
        this.JPIConsolidado1.setBorder(BorderFactory.createTitledBorder((Border) null, "REPORTES", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIConsolidado1.setLayout(new AbsoluteLayout());
        this.Rcerrado.setBackground(new Color(255, 51, 51));
        this.Rcerrado.setBorder(BorderFactory.createTitledBorder((Border) null, "Cerrados", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.Rcerrado.setForeground(new Color(255, 255, 255));
        this.Rcerrado.setHorizontalAlignment(4);
        this.Rcerrado.setFont(new Font("Arial", 1, 14));
        this.JPIConsolidado1.add(this.Rcerrado, new AbsoluteConstraints(16, 23, 85, -1));
        this.Rabierto.setBackground(new Color(255, 51, 51));
        this.Rabierto.setBorder(BorderFactory.createTitledBorder((Border) null, "Por Cerrar", 0, 0, new Font("Arial", 1, 12), new Color(255, 255, 255)));
        this.Rabierto.setForeground(new Color(255, 255, 255));
        this.Rabierto.setHorizontalAlignment(4);
        this.Rabierto.setFont(new Font("Arial", 1, 14));
        this.JPIConsolidado1.add(this.Rabierto, new AbsoluteConstraints(111, 23, 86, -1));
        getContentPane().add(this.JPIConsolidado1, new AbsoluteConstraints(920, 0, 213, 90));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "RANGO DE FECHAS", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.JDCFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaF.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.JDCFechaF, new AbsoluteConstraints(153, 23, 145, 56));
        this.JDCFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaI.setFont(new Font("Arial", 1, 12));
        this.JDCFechaI.addAncestorListener(new AncestorListener() { // from class: Mantenimiento.JIFTiemporeporte.3
            public void ancestorAdded(AncestorEvent evt) {
                JIFTiemporeporte.this.JDCFechaIAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }
        });
        this.jPanel1.add(this.JDCFechaI, new AbsoluteConstraints(8, 23, 135, 56));
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.jButton1.setText("Ver ");
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.JIFTiemporeporte.4
            public void actionPerformed(ActionEvent evt) {
                JIFTiemporeporte.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(424, 30, 110, 47));
        this.buttonGroup2.add(this.mina);
        this.mina.setFont(new Font("Arial", 1, 12));
        this.mina.setText("Clínica Mina");
        this.jPanel1.add(this.mina, new AbsoluteConstraints(320, 50, -1, -1));
        this.buttonGroup2.add(this.betanci);
        this.betanci.setFont(new Font("Arial", 1, 12));
        this.betanci.setSelected(true);
        this.betanci.setText("Betancí");
        this.jPanel1.add(this.betanci, new AbsoluteConstraints(320, 20, -1, -1));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(10, 0, 550, 90));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridtiempo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Descripcion", "Area", "Fecha Inicial", "Fecha Final", "Dias"}) { // from class: Mantenimiento.JIFTiemporeporte.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(3);
    }

    public final void cargarDatostiempo(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        try {
            this.n = 0;
            while (rs.next()) {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), this.n, 0);
                this.xmodelo.setValueAt(rs.getString(2), this.n, 1);
                this.xmodelo.setValueAt(rs.getString(3), this.n, 2);
                this.xmodelo.setValueAt(rs.getString(4), this.n, 3);
                this.xmodelo.setValueAt(rs.getString(5), this.n, 4);
                int dia = Integer.valueOf(rs.getString(5)).intValue();
                this.n++;
                this.tdias += dia;
            }
            this.Tdias.setValue(Integer.valueOf(this.tdias));
            this.Rcerrado.setValue(Integer.valueOf(this.n));
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsulta.mostrarErrorSQL(ex);
        }
    }

    private void llenatablatiempo() {
        if (this.betanci.isSelected()) {
            crearGridtiempo();
            this.sql = "SELECT m_reporte.DescripcionR , f_centrocosto.Nbre,m_reporte.FechaR AS inicio , MAX(m_seguimiento.FechaSeguimiento) AS final ,DATEDIFF(  MAX(m_seguimiento.FechaSeguimiento),(m_reporte.FechaR) )AS dias FROM m_seguimiento INNER JOIN m_reporte ON (m_seguimiento.Id_reporte = m_reporte.Id)INNER JOIN baseserver.m_tipoestadoreporte ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)INNER JOIN baseserver.f_centrocosto ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.g_sedes ON (m_reporte.Id_sede = g_sedes.Id)WHERE m_reporte.FechaR BETWEEN '" + this.metodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND '" + this.metodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND  (m_reporte.Id_EstadoReporte =4) AND g_sedes.Id=1 GROUP BY m_reporte.Id";
            cargarDatostiempo(this.sql);
        }
        if (this.mina.isSelected()) {
            crearGridtiempo();
            this.sql = "SELECT m_reporte.DescripcionR , f_centrocosto.Nbre,m_reporte.FechaR AS inicio , MAX(m_seguimiento.FechaSeguimiento) AS final ,DATEDIFF(  MAX(m_seguimiento.FechaSeguimiento),(m_reporte.FechaR) )AS dias FROM m_seguimiento INNER JOIN m_reporte ON (m_seguimiento.Id_reporte = m_reporte.Id)INNER JOIN baseserver.m_tipoestadoreporte ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)INNER JOIN baseserver.f_centrocosto ON (m_reporte.Id_Area = f_centrocosto.Id) INNER JOIN baseserver.g_sedes ON (m_reporte.Id_sede = g_sedes.Id)WHERE m_reporte.FechaR BETWEEN '" + this.metodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND '" + this.metodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND  (m_reporte.Id_EstadoReporte =4) AND g_sedes.Id=2 GROUP BY m_reporte.Id";
            cargarDatostiempo(this.sql);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridtiempo2() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Descripcion", "Area", "Fecha Inicial", "Dias"}) { // from class: Mantenimiento.JIFTiemporeporte.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado1.setModel(this.xmodelo1);
        this.JTResultado1.getColumnModel().getColumn(0).setPreferredWidth(3);
        this.JTResultado1.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTResultado1.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTResultado1.getColumnModel().getColumn(3).setPreferredWidth(25);
        this.JTResultado1.getColumnModel().getColumn(4).setPreferredWidth(3);
    }

    public final void cargarDatostiempo2(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        try {
            System.out.println(dat);
            this.n1 = 0;
            while (rs.next()) {
                this.xmodelo1.addRow(this.dato);
                this.xmodelo1.setValueAt(rs.getString(1), this.n1, 0);
                this.xmodelo1.setValueAt(rs.getString(2), this.n1, 1);
                this.xmodelo1.setValueAt(rs.getString(3), this.n1, 2);
                this.xmodelo1.setValueAt(rs.getString(4), this.n1, 3);
                this.xmodelo1.setValueAt(rs.getString(5), this.n1, 4);
                int dia2 = Integer.valueOf(rs.getString(5)).intValue();
                this.n1++;
                this.tdias2 += dia2;
                this.Rabierto.setValue(Integer.valueOf(this.n1));
                this.xtodo1 = rs.getInt(5);
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsulta.mostrarErrorSQL(ex);
        }
    }

    private void llenatablatiempo2() {
        if (this.betanci.isSelected()) {
            crearGridtiempo2();
            this.sql2 = "SELECT m_reporte.Id , m_reporte.DescripcionR , f_centrocosto.Nbre,m_reporte.FechaR AS inicio ,DATEDIFF(  NOW(),(m_reporte.FechaR) )AS dias FROM m_seguimiento INNER JOIN m_reporte ON (m_seguimiento.Id_reporte = m_reporte.Id)INNER JOIN baseserver.m_tipoestadoreporte ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)INNER JOIN baseserver.f_centrocosto ON (m_reporte.Id_Area = f_centrocosto.Id)INNER JOIN baseserver.g_sedes ON (m_reporte.Id_sede = g_sedes.Id)WHERE m_reporte.FechaR BETWEEN '" + this.metodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND '" + this.metodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND  (m_reporte.Id_EstadoReporte <>4) AND g_sedes.Id=1 GROUP BY m_reporte.Id";
            cargarDatostiempo2(this.sql2);
            System.out.println(this.sql2);
        }
        if (this.mina.isSelected()) {
            crearGridtiempo2();
            this.sql2 = "SELECT m_reporte.Id , m_reporte.DescripcionR , f_centrocosto.Nbre,m_reporte.FechaR AS inicio ,DATEDIFF(  NOW(),(m_reporte.FechaR) )AS dias FROM m_seguimiento INNER JOIN m_reporte ON (m_seguimiento.Id_reporte = m_reporte.Id)INNER JOIN baseserver.m_tipoestadoreporte ON (m_reporte.Id_EstadoReporte = m_tipoestadoreporte.Id)INNER JOIN baseserver.f_centrocosto ON (m_reporte.Id_Area = f_centrocosto.Id)INNER JOIN baseserver.g_sedes ON (m_reporte.Id_sede = g_sedes.Id)WHERE m_reporte.FechaR BETWEEN '" + this.metodos.formatoAMD.format(this.JDCFechaI.getDate()) + "' AND '" + this.metodos.formatoAMD.format(this.JDCFechaF.getDate()) + "' AND  (m_reporte.Id_EstadoReporte <>4) AND g_sedes.Id=2 GROUP BY m_reporte.Id";
            cargarDatostiempo2(this.sql2);
            System.out.println(this.sql2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaIAncestorAdded(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        llenatablatiempo2();
        llenatablatiempo();
        calculo();
    }

    public void calculo() {
        this.promedio = this.n1 + this.n;
        this.promediod = this.tdias + this.tdias2;
        this.Tdias.setValue(Integer.valueOf(this.promediod));
        this.Nreportes.setValue(Integer.valueOf(this.promedio));
        this.Pdias.setValue(Integer.valueOf(this.promediod / this.promedio));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultado1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.Cmantenimiento.cargarPantalla("Seguimiento", this.xmodelo1.getValueAt(this.JTResultado1.getSelectedRow(), 0).toString());
        }
    }
}
