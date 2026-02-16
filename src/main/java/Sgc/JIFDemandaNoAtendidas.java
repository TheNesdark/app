package Sgc;

import Sig.JIFVigenciaPoliza;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFDemandaNoAtendidas.class */
public class JIFDemandaNoAtendidas extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo2;
    private String xnombre;
    private String xsql;
    private String[] xid;
    private Object[] xdato;
    private ButtonGroup JBGFiltros;
    private JButton JBTExportar;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JRadioButton JRBCitasNP;
    private JRadioButton JRBCitasP;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    public JTable JTConsolidado;
    public JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xencontro = "0";
    private boolean xcombo = false;
    private int xtipo = 0;

    public JIFDemandaNoAtendidas(String xnombre) {
        initComponents();
        this.xnombre = xnombre;
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltros = new ButtonGroup();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.jPanel1 = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JRBCitasP = new JRadioButton();
        this.JRBCitasNP = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR CITAS FACTURADAS-NO ATENDIDAS");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifnofacturadas");
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sgc.JIFDemandaNoAtendidas.1
            public void actionPerformed(ActionEvent evt) {
                JIFDemandaNoAtendidas.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFDemandaNoAtendidas.2
            public void mouseClicked(MouseEvent evt) {
                JIFDemandaNoAtendidas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setForeground(new Color(0, 102, 0));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JBGFiltros.add(this.JRBCitasP);
        this.JRBCitasP.setFont(new Font("Arial", 1, 12));
        this.JRBCitasP.setSelected(true);
        this.JRBCitasP.setText("Citas Programadas");
        this.JBGFiltros.add(this.JRBCitasNP);
        this.JRBCitasNP.setFont(new Font("Arial", 1, 12));
        this.JRBCitasNP.setText("Citas No Programadas");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 109, -2).addGap(29, 29, 29).addComponent(this.JDFFechaF, -2, 109, -2).addGap(67, 67, 67).addComponent(this.JRBCitasP).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBCitasNP).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2)).addGap(0, 22, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCitasP).addComponent(this.JRBCitasNP)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFDemandaNoAtendidas.3
            public void mouseClicked(MouseEvent evt) {
                JIFDemandaNoAtendidas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JSPConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTConsolidado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTConsolidado.setEditingColumn(1);
        this.JTConsolidado.setEditingRow(1);
        this.JTConsolidado.setRowHeight(25);
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(Color.red);
        this.JTConsolidado.addMouseListener(new MouseAdapter() { // from class: Sgc.JIFDemandaNoAtendidas.4
            public void mouseClicked(MouseEvent evt) {
                JIFDemandaNoAtendidas.this.JTConsolidadoMouseClicked(evt);
            }
        });
        this.JSPConsolidado.setViewportView(this.JTConsolidado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 577, -2).addGap(40, 40, 40).addComponent(this.JBTExportar, -1, 239, 32767)).addComponent(this.JSPConsolidado).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPConsolidado, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 231, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    private void mCrearTablaCitasP() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Cod_cita", "Fecha_Cita", "HoraInicial", "HoraFinal", "ClaseCita", "Profesional", "Especialidad", "NoDocumento", "Usuario", "Sexo", "FechaNac", "Edad", "TipoEdad", "Telefono", "Cel", "Direccion", "Municipio", "EPS"}) { // from class: Sgc.JIFDemandaNoAtendidas.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
    }

    private void mCargarDatosCitasP(String sql) {
        mCrearTablaCitasP();
        System.out.println("sql-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFDemandaNoAtendidas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearTablaConso() {
        this.xmodelo2 = new DefaultTableModel((Object[][]) null, new String[]{"Especialidad", "Cantidad"}) { // from class: Sgc.JIFDemandaNoAtendidas.6
            Class[] types = {String.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTConsolidado.setModel(this.xmodelo2);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(15);
    }

    private void mCargarDatosConso(String sql) {
        mCrearTablaConso();
        System.out.println("sql-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFDemandaNoAtendidas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportarInformacion();
    }

    public void mBuscar() {
        String sql2;
        String sql;
        if (this.JRBCitasP.isSelected()) {
            sql2 = "SELECT `g_especialidad`.`Nbre` AS `Especialidad`\n    , COUNT(`g_especialidad`.`Nbre`) AS Cantidad\nFROM `c_citas` \n    INNER JOIN  `g_persona`  ON (`c_citas`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN  `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `g_profesionalespecial` ON (`g_profesionalespecial`.`Id_Profesional`=`c_citas`.`Id_Profesional`) AND (`g_profesionalespecial`.`Id_Especialidad`=`c_citas`.`Id_Especialidad`)\n    INNER JOIN `g_persona` AS profesional ON (`profesional`.`Id`=`g_profesionalespecial`.`Id_Profesional`)\n    INNER JOIN `g_especialidad` ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\n    INNER JOIN  `ingreso`   ON (`c_citas`.`Id_ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `h_atencion` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_citas`.`Asistida` =1 AND `c_citas`.`Fecha_Cita`>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita`<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp`='')\nGROUP BY `g_especialidad`.`Id` ORDER BY `g_especialidad`.`Nbre` ASC ;";
            sql = "SELECT\n    `c_citas`.`Id` AS Cod_Cita\n    , `c_citas`.`Fecha_Cita`\n    , `c_citas`.`HoraInicial`\n    , `c_citas`.`HoraFinal`\n    , `c_clasecita`.`Nbre`\n    , CONCAT(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) AS `NProfesional`\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `g_persona`.`NoDocumento` \n    , CONCAT(`g_persona`.`Apellido1`,_latin1' ',`g_persona`.`Apellido2`,_latin1' ',`g_persona`.`Nombre1`,_latin1' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo` AS `IdSexo`\n    ,  g_persona.`FechaNac`\n    , `g_persona`.`Edad`\n    , `g_tipoedad`.`Nbre` AS `NTipoEdad`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Movil`\n    , `g_persona`.`Direccion`\n    , `g_municipio`.`Nbre` AS `NMunicipio`\n    , `g_empresa`.`Eps` AS `EPS`  \nFROM\n     `c_citas`\n    INNER JOIN  `g_persona` \n        ON (`c_citas`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN `g_tipoedad`\n        ON (`g_tipoedad`.`Id`=`g_persona`.`Id_TipoEdad`)\n    INNER JOIN `g_municipio`\n        ON (`g_municipio`.`Id` = `g_persona`.`Id_Municipio`)\n    INNER JOIN `g_usuario`\n        ON (`g_usuario`.`Id_persona`= `g_persona`.`Id`)\n    INNER JOIN `g_empresacont`\n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `g_empresa`\n        ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_profesionalespecial` \n        ON (`c_citas`.`Id_Profesional` = `g_profesionalespecial`.`Id_Profesional`) AND (`c_citas`.`Id_Especialidad` = `g_profesionalespecial`.`Id_Especialidad`)\n    INNER JOIN `g_persona` AS profesional\n        ON (profesional.Id=`g_profesionalespecial`.`Id_Profesional`)\n    INNER JOIN `g_especialidad`\n        ON (g_especialidad.Id=`g_profesionalespecial`.`Id_Especialidad`)\n    INNER JOIN  `ingreso` \n        ON (`c_citas`.`Id_ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_citas`.`Asistida` =1 AND `c_citas`.`Fecha_Cita`>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `c_citas`.`Fecha_Cita`<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp`='')\nORDER BY `c_citas`.`Fecha_Cita` DESC, `g_especialidad`.`Nbre` ASC";
        } else {
            sql2 = "SELECT `g_especialidad`.`Nbre` AS `Especialidad`\n    , COUNT(`g_especialidad`.`Nbre`) AS Cantidad\nFROM `c_citasnp` \n    INNER JOIN  `g_persona`  ON (`c_citasnp`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN  `c_clasecita`  ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `g_profesionalespecial` ON (`g_profesionalespecial`.`Id_Profesional`=`c_citasnp`.`Id_Profesional`) AND (`g_profesionalespecial`.`Id_Especialidad`=`c_citasnp`.`Id_Especialidad`)\n    INNER JOIN `g_persona` AS profesional ON (`profesional`.`Id`=`g_profesionalespecial`.`Id_Profesional`)\n    INNER JOIN `g_especialidad` ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\n    INNER JOIN  `ingreso`   ON (`c_citasnp`.`Id_ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `h_atencion` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_citasnp`.`Asistida` =0 AND `c_citasnp`.`Fecha_Cita`>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `c_citasnp`.`Fecha_Cita`<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp`='')\nGROUP BY `g_especialidad`.`Id` ORDER BY `g_especialidad`.`Nbre` ASC";
            sql = "SELECT\n    `c_citasnp`.`Id` AS Cod_Cita\n    , `c_citasnp`.`Fecha_Cita`\n    , `c_citasnp`.`HoraInicial`\n    , IFNULL(`c_citasnp`.`HoraFinal`,'') AS `HoraFinal`\n    , `c_clasecita`.`Nbre`\n    , CONCAT(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) AS `NProfesional`\n    , `g_especialidad`.`Nbre` AS `Especialidad`\n    , `g_persona`.`NoDocumento` \n    , CONCAT(`g_persona`.`Apellido1`,_latin1' ',`g_persona`.`Apellido2`,_latin1' ',`g_persona`.`Nombre1`,_latin1' ',`g_persona`.`Nombre2`) AS `NUsuario`\n    , `g_persona`.`Id_Sexo` AS `IdSexo`\n    ,  g_persona.`FechaNac`\n    , `g_persona`.`Edad`\n    , `g_tipoedad`.`Nbre` AS `NTipoEdad`\n    , `g_persona`.`Telefono`\n    , `g_persona`.`Movil`\n    , `g_persona`.`Direccion`\n    , `g_municipio`.`Nbre` AS `NMunicipio`\n    , `g_empresa`.`Eps` AS `EPS`  \nFROM\n     `c_citasnp`\n    INNER JOIN  `g_persona` \n        ON (`c_citasnp`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN `g_tipoedad`\n        ON (`g_tipoedad`.`Id`=`g_persona`.`Id_TipoEdad`)\n    INNER JOIN `g_municipio`\n        ON (`g_municipio`.`Id` = `g_persona`.`Id_Municipio`)\n    INNER JOIN `g_usuario`\n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_empresacont`\n        ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `g_empresa`\n        ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`c_citasnp`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `g_profesionalespecial` \n        ON (`c_citasnp`.`Id_Profesional` = `g_profesionalespecial`.`Id_Profesional`) AND (`c_citasnp`.`Id_Especialidad` = `g_profesionalespecial`.`Id_Especialidad`)\n    INNER JOIN `g_persona` AS profesional\n        ON (profesional.Id=`g_profesionalespecial`.`Id_Profesional`)\n    INNER JOIN `g_especialidad`\n        ON (g_especialidad.Id=`g_profesionalespecial`.`Id_Especialidad`)\n    INNER JOIN  `ingreso` \n        ON (`c_citasnp`.`Id_ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`c_citasnp`.`Asistida` =0 AND `c_citasnp`.`Fecha_Cita`>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `c_citasnp`.`Fecha_Cita`<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND `h_atencion`.`Codigo_Dxp`='')\nORDER BY `c_citasnp`.`Fecha_Cita` DESC, `g_especialidad`.`Nbre` ASC";
        }
        mCargarDatosConso(sql2);
        mCargarDatosCitasP(sql);
    }

    private void mExportarInformacion() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("Detalle", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodelo.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodelo.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodelo.getValueAt(x2, 6).toString()));
                        sheet.addCell(new Label(7, y, this.xmodelo.getValueAt(x2, 7).toString()));
                        sheet.addCell(new Label(8, y, this.xmodelo.getValueAt(x2, 8).toString()));
                        sheet.addCell(new Label(9, y, this.xmodelo.getValueAt(x2, 9).toString()));
                        sheet.addCell(new Label(10, y, this.xmodelo.getValueAt(x2, 10).toString()));
                        sheet.addCell(new Label(11, y, this.xmodelo.getValueAt(x2, 11).toString()));
                        sheet.addCell(new Label(12, y, this.xmodelo.getValueAt(x2, 12).toString()));
                        sheet.addCell(new Label(13, y, this.xmodelo.getValueAt(x2, 13).toString()));
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x2, 13).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x2, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x2, 17).toString()));
                        y++;
                    }
                    WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                    for (int x3 = 0; x3 < this.JTConsolidado.getColumnCount(); x3++) {
                        sheet2.addCell(new Label(x3, 0, this.JTConsolidado.getColumnName(x3)));
                    }
                    for (int x4 = 0; x4 < this.JTConsolidado.getRowCount(); x4++) {
                        sheet2.addCell(new Label(0, x4 + 1, this.xmodelo2.getValueAt(x4, 0).toString()));
                        sheet2.addCell(new Number(1, x4 + 1, Integer.valueOf(this.xmodelo2.getValueAt(x4, 1).toString()).intValue()));
                    }
                    workbook.write();
                    workbook.close();
                    this.xmt.mostrarPdf(this.JTFRuta.getText() + ".xls");
                } catch (IOException ex) {
                    Logger.getLogger(JIFVigenciaPoliza.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFVigenciaPoliza.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTConsolidadoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFDemandaNoAtendidas$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String dias_v = table.getValueAt(row, 6).toString();
            if (dias_v != null && dias_v.equals("1")) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.WHITE);
            } else if (dias_v != null && dias_v.equals("2")) {
                cell.setBackground(Color.yellow);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
