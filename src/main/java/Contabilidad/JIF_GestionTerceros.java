package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIF_GestionTerceros.class */
public class JIF_GestionTerceros extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private String xsql;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPI_DConsulta;
    private JScrollPane JSP_Activos;
    private JScrollPane JSP_InActivos;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Datos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIF_GestionTerceros() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_DConsulta = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JTP_Datos = new JTabbedPane();
        this.JSP_Activos = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSP_InActivos = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE TERCEROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifgestionterceros");
        this.JPI_DConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 13));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 13));
        GroupLayout JPI_DConsultaLayout = new GroupLayout(this.JPI_DConsulta);
        this.JPI_DConsulta.setLayout(JPI_DConsultaLayout);
        JPI_DConsultaLayout.setHorizontalGroup(JPI_DConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addContainerGap(-1, 32767)));
        JPI_DConsultaLayout.setVerticalGroup(JPI_DConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DConsultaLayout.createSequentialGroup().addGroup(JPI_DConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 50, -2).addComponent(this.JDFFechaF, -2, 50, -2)).addGap(0, 10, 32767)));
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSP_Activos.setViewportView(this.JTDetalle);
        this.JTP_Datos.addTab("ACTIVOS", this.JSP_Activos);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JSP_InActivos.setViewportView(this.JTDetalle1);
        this.JTP_Datos.addTab("INACTIVOS", this.JSP_InActivos);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIF_GestionTerceros.1
            public void mouseClicked(MouseEvent evt) {
                JIF_GestionTerceros.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIF_GestionTerceros.2
            public void actionPerformed(ActionEvent evt) {
                JIF_GestionTerceros.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DConsulta, -1, -1, 32767).addComponent(this.JTP_Datos).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -1, 537, 32767).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 298, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DConsulta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos, -1, 383, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 52, -2)).addContainerGap()));
        pack();
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
        if (this.JTDetalle.getRowCount() != -1) {
            if (this.JTP_Datos.getSelectedIndex() == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), "TERCEROS ACTIVOS");
            } else {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle1, this.JTFRuta.getText(), "TERCEROS INACTIVOS");
            }
        }
    }

    public void mBuscar() {
        mActualizar_Estado();
        mCargar_Datos();
        mCargar_Datos1();
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearTabla();
        mCrearTabla1();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Documento", "Razón Social", "Departamento", "Municipio", "Dirección", "Teléfono", "Email", "Concepto"}) { // from class: Contabilidad.JIF_GestionTerceros.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    private void mCrearTabla1() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Documento", "Razón Social", "Departamento", "Municipio", "Dirección", "Teléfono", "Email", "Concepto"}) { // from class: Contabilidad.JIF_GestionTerceros.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle1.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTDetalle1.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTDetalle1.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    private void mCargar_Datos() {
        try {
            mCrearTabla();
            int xnfila = 0;
            this.xsql = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, `cc_terceros`.`NDepartamento`  , `cc_terceros`.`NMunicipio` , `cc_terceros`.`Direccion` , `cc_terceros`.`Tel_Numero` , `cc_terceros`.correo,  GROUP_CONCAT(DISTINCT `cc_conceptocmsa`.`Nbre` SEPARATOR '\\n' ) AS `Concepto` \n FROM  `cc_radicacion`  INNER JOIN  `cc_terceros`   ON (`cc_radicacion`.`Id_Proveedor`= `cc_terceros`.`Id`) INNER JOIN  `cc_conceptocmsa`  ON (`cc_radicacion`.`Id_Concepto` = `cc_conceptocmsa`.`Id`) \n WHERE (`cc_terceros`.`ActivoC`=1   AND `cc_radicacion`.`Estado` =1) \n GROUP BY `cc_terceros`.`Id` \n ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), xnfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), xnfila, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), xnfila, 7);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_GestionTerceros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargar_Datos1() {
        try {
            mCrearTabla1();
            int xnfila = 0;
            this.xsql = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, `cc_terceros`.`NDepartamento`  , `cc_terceros`.`NMunicipio` , `cc_terceros`.`Direccion` , `cc_terceros`.`Tel_Numero` , `cc_terceros`.correo,  GROUP_CONCAT(DISTINCT `cc_conceptocmsa`.`Nbre` SEPARATOR '\\n' ) AS `Concepto` \n FROM   `cc_terceros`   INNER JOIN `cc_radicacion`  ON (`cc_radicacion`.`Id_Proveedor`= `cc_terceros`.`Id`) INNER JOIN  `cc_conceptocmsa`  ON (`cc_radicacion`.`Id_Concepto` = `cc_conceptocmsa`.`Id`) \n WHERE (`cc_terceros`.`ActivoC`=0   AND `cc_radicacion`.`Estado` =1) \n GROUP BY `cc_terceros`.`Id` \n ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(xrs.getString(1), xnfila, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), xnfila, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), xnfila, 6);
                    this.xmodelo1.setValueAt(xrs.getString(8), xnfila, 7);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_GestionTerceros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "FechaI";
        mparametros[0][1] = this.xmt.formatoAMD1.format(this.JDFFechaI.getDate());
        mparametros[1][0] = "FechaF";
        mparametros[1][1] = this.xmt.formatoAMD1.format(this.JDFFechaF.getDate());
        mparametros[2][0] = "UsuarioS";
        mparametros[2][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.JTP_Datos.getSelectedIndex() == 0) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Relacion_Tercero_Activos", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Relacion_Tercero_InActivos", mparametros);
        }
    }

    private void mActualizar_Estado() {
        if (Principal.informacionIps.getIdentificacion().equals("812000852")) {
            this.xsql = "update g_empresa set ActivoC=0";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "DROP VIEW IF EXISTS cc_v_tmp";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT `cc_terceros`.`Id` FROM  `cc_radicacion`  \nINNER JOIN  `cc_terceros`   ON (`cc_radicacion`.`Id_Proveedor`= `cc_terceros`.`Id`) \nINNER JOIN  `cc_conceptocmsa`  ON (`cc_radicacion`.`Id_Concepto` = `cc_conceptocmsa`.`Id`)\nWHERE (`cc_radicacion`.`Fecha` >='" + this.xmt.formatoAMD1.format(this.JDFFechaI.getDate()) + "'  AND `cc_radicacion`.`Fecha` <='" + this.xmt.formatoAMD1.format(this.JDFFechaF.getDate()) + "' \nAND `cc_radicacion`.`Estado` =1) GROUP BY `cc_terceros`.`Id` ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
            this.xsql = "CREATE VIEW cc_v_tmp AS " + this.xsql;
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update g_empresa, cc_v_tmp set g_empresa.ActivoC=1 where g_empresa.Id=cc_v_tmp.Id";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }
}
