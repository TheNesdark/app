package Informes;

import Sig.JIFInformesPyP;
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
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFInformesVarios.class */
public class JIFInformesVarios extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelocons;
    private String xnombre;
    private String xsql;
    private String[] xid;
    private Object[] xdato;
    private JButton JBTExportar;
    private JComboBox JCBUno;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    public JTable JTConsolidado;
    public JTable JTDetalle;
    private JFormattedTextField JTFFNRegistro;
    private JTextField JTFRuta;
    private JTabbedPane JTPInformes;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xencontro = "0";
    private int xtipo = 0;

    public JIFInformesVarios(String xnombre, String xnbre) {
        initComponents();
        setName(xnbre);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombre;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBUno = new JComboBox();
        this.JTFFNRegistro = new JFormattedTextField();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JTPInformes = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES PROMOCIÓN  Y PREVENCIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifinformesvarios");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JCBUno, -2, 403, -2).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(0, 11, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGap(13, 13, 13)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBUno).addContainerGap()));
        this.JTFFNRegistro.setEditable(false);
        this.JTFFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFFNRegistro.setHorizontalAlignment(0);
        this.JTFFNRegistro.setFont(new Font("Arial", 1, 18));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Informes.JIFInformesVarios.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformesVarios.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Informes.JIFInformesVarios.2
            public void mouseClicked(MouseEvent evt) {
                JIFInformesVarios.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTPInformes.setForeground(new Color(0, 103, 0));
        this.JTPInformes.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setForeground(new Color(0, 0, 204));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPInformes.addTab("DETALLE", this.JSPDetalle);
        this.JSPConsolidado.setBorder((Border) null);
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setForeground(new Color(0, 0, 204));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTConsolidado.setEditingColumn(1);
        this.JTConsolidado.setEditingRow(1);
        this.JTConsolidado.setRowHeight(25);
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(Color.red);
        this.JSPConsolidado.setViewportView(this.JTConsolidado);
        this.JTPInformes.addTab("CONSOLIDADO", this.JSPConsolidado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFFNRegistro, -2, 152, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -1, 373, 32767).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 195, -2).addGap(423, 423, 423)).addComponent(this.JTPInformes)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPInformes, -2, 482, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFNRegistro).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -1, -1, 32767)).addContainerGap(35, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTPInformes.getSelectedIndex() == 0) {
            if (this.JTDetalle.getRowCount() != -1) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + ": " + this.JTPInformes.getTitleAt(0));
            }
        } else if (this.JTPInformes.getSelectedIndex() == 1 && this.JTConsolidado.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTConsolidado, this.JTFRuta.getText(), getTitle() + ": " + this.JTPInformes.getTitleAt(1));
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

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCBUno.removeAllItems();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        if (this.xnombre.equals("CONSOLIDADO DE ATENCIONES")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT `f_empresacontxconvenio`.`Id` , `f_empresacontxconvenio`.`Nbre` FROM `ingreso` INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) GROUP BY `f_empresacontxconvenio`.`Id` ORDER BY `f_empresacontxconvenio`.`Nbre` ASC ";
            this.xid = this.xct.llenarCombo(this.xsql, this.xid, this.JCBUno);
            mCrearTablaDetalle();
            this.JTPInformes.remove(1);
        } else if (this.xnombre.equals("consulta de oportunidad en atención de urgencias")) {
            this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.xsql = "SELECT `Id` , `Nbre` FROM `g_sedes` WHERE (`Estado` =1) ORDER BY `Nbre` ASC";
            this.xid = this.xct.llenarCombo(this.xsql, this.xid, this.JCBUno);
            mCrearTablaDetalleUrgencias();
            mCrearTablaConsolidadoUrgencias();
        }
        this.JCBUno.setSelectedIndex(-1);
        this.JTFFNRegistro.setValue(new Integer(0));
        this.xct.cerrarConexionBd();
    }

    public void mBuscar() {
        if (this.xnombre.equals("CONSOLIDADO DE ATENCIONES")) {
            mCargarDatos1();
        } else if (this.xnombre.equals("consulta de oportunidad en atención de urgencias")) {
            mCargarDatosUrgenciaDetalle();
            mCargarDatosUrgenciaConsilidado();
        }
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Dia", "EPS", "TD", "Documento", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "FechaNac", "Edad", "Sexo", "Municipio", "Dirección", "Telefono", "Cie10", "Patología", "Especialidad", "Profesional"}) { // from class: Informes.JIFInformesVarios.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(10);
    }

    private void mCrearTablaDetalleUrgencias() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Fecha Ingreso", "Hora Ingreso", "Tipo Identificación", "No.Historia", "Apellidos Completos", "Nombres Completos", "Edad", "Sexo", "Cod. DX Princiapal", "Cod. DX R1", "Cod. DX R2", "Cod. DX R3", "Clase Cita", "Empresa", "Facturada?", "IdAtencion", "FechaAtencion", "Hora Atencion", "Fecha Cita", "Hora Inicial", "NFecha", "Fecha Consulta", "Diferencia de Tiempo", "Hora", "Minutos", "Segundos", "Tiempo Atencion", "Especialidad", "Profecional", "Fecha/Hora Egreso", "Clasificacion"}) { // from class: Informes.JIFInformesVarios.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
    }

    private void mCargarDatos1() {
        if (this.JCBUno.getSelectedIndex() != -1) {
            this.xsql = "SELECT DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d') AS `Dia`, g_empresacont.Codigo, `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Apellido1`, `g_persona`.`Apellido2` , `g_persona`.`FechaNac`, `g_persona`.`Edad`, `g_persona`.`Id_Sexo`, `persona`.`NMunicipio`, `persona`.`Direccion`, `persona`.`Telefono`, `g_patologia`.`Id`, `g_patologia`.`Nbre`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` FROM  `ingreso` INNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `g_empresacont`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `f_ordenes`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `f_itemordenesproced` ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `f_itemripsconsulta`  ON (`f_itemripsconsulta`.`Id_Ordenes` = `f_itemordenesproced`.`Id_Ordenes`) AND (`f_itemripsconsulta`.`Id_Procedimiento` = `f_itemordenesproced`.`Id_Procedimiento`) INNER JOIN  `g_patologia`  ON (`f_itemripsconsulta`.`Id_DxPrincipal` = `g_patologia`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`IdEspecialidad` = `ingreso`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `ingreso`.`Id_Profesional`) WHERE (`ingreso`.`FechaIngreso` >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`FechaIngreso` <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND `ingreso`.`Estado` =0 AND `f_ordenes`.`Estado` =0 AND `ingreso`.`Id_EmpresaContxConv` ='" + this.xid[this.JCBUno.getSelectedIndex()] + "') ORDER BY `ingreso`.`FechaIngreso` ASC, `g_persona`.`Apellido1` ASC, `g_persona`.`Nombre1` ASC ";
            ResultSet rs = this.xct.traerRs(this.xsql);
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
                        this.xmodelo.setValueAt(rs.getString(5), x, 4);
                        this.xmodelo.setValueAt(rs.getString(6), x, 5);
                        this.xmodelo.setValueAt(rs.getString(7), x, 6);
                        this.xmodelo.setValueAt(rs.getString(8), x, 7);
                        this.xmodelo.setValueAt(rs.getString(9), x, 8);
                        this.xmodelo.setValueAt(Integer.valueOf(rs.getInt(10)), x, 9);
                        this.xmodelo.setValueAt(rs.getString(11), x, 10);
                        this.xmodelo.setValueAt(rs.getString(12), x, 11);
                        this.xmodelo.setValueAt(rs.getString(13), x, 12);
                        this.xmodelo.setValueAt(rs.getString(14), x, 13);
                        this.xmodelo.setValueAt(rs.getString(15), x, 14);
                        this.xmodelo.setValueAt(rs.getString(16), x, 15);
                        this.xmodelo.setValueAt(rs.getString(17), x, 16);
                        this.xmodelo.setValueAt(rs.getString(18), x, 17);
                        x++;
                    }
                    this.JTFFNRegistro.setValue(Integer.valueOf(x));
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
        }
    }

    private void mCargarDatosUrgenciaDetalle() {
        if (this.JCBUno.getSelectedIndex() != -1) {
            this.xsql = "SELECT  \n DATE_FORMAT(ingreso.FechaIngreso,'%d-%m-%Y') AS FechaIngreso, \n ingreso.HoraIngreso AS HoraIngreso,\n g_persona.Id_TipoIdentificacion AS TipoIdentificacion,\n g_persona.NoDocumento, \n CONCAT(g_persona.Apellido1, ' ',  g_persona.Apellido2) AS ApellidosCompletos,\n CONCAT(g_persona.Nombre1, ' ',g_persona.Nombre2) AS NombresCompletos,\n CONCAT(g_persona.Edad ,' ' ,  IF(g_persona.Id_TipoEdad=1,'AÑO(S)',IF(g_persona.Id_TipoEdad=2,'MES(ES)','DIA(S)'))) AS Edad,   \n g_persona.Id_Sexo,  \n h_atencion.Codigo_Dxp, \n h_atencion.Codigo_DxR1, \n h_atencion.Codigo_DxR2, \n h_atencion.Codigo_DxR3, \n c_clasecita.Nbre AS NClaseCita,  \n f_empresacontxconvenio.Nbre AS NEmpresa,\n c_citasnp.EstaFacturada, \n h_atencion.Id,  \n h_atencion.Fecha_Atencion, \n h_atencion.Hora_Atencion, \n c_citasnp.Fecha_Cita, \n c_citasnp.HoraInicial,  \n TIMESTAMP(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.Hora_Atencion)) AS NFecha,  \n TIMESTAMP(CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.HoraInicial)) AS NFechaC, \n TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ',  h_atencion.Hora_Atencion), CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.HoraInicial)) AS DT,  \n HOUR(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.Hora_Atencion),  CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.HoraInicial) )) AS Hora,\n MINUTE(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.Hora_Atencion),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.HoraInicial) )) AS Minuto,  \n SECOND(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.Hora_Atencion),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.HoraInicial) )) AS segundos,\n ((HOUR(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.Hora_Atencion),CONCAT(c_citasnp.Fecha_Cita,' ',  c_citasnp.HoraInicial) ))*60)  + (MINUTE(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.Hora_Atencion),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.HoraInicial) )))  + (ROUND( (SECOND(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ',  h_atencion.Hora_Atencion),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.HoraInicial) ))/60)))) AS TAencion,\n profesional1.Especialidad, \n profesional1.NProfesional, \n IF(h_egreso_atencion.FechaSO IS NULL, '', CONCAT(DATE_FORMAT(h_egreso_atencion.FechaSO,'%d-%m-%Y'), ' ', h_egreso_atencion.HoraSO) ) AS fechaEgreso, \n IFNULL(h_triage.Clasificacion,'NO LLENADO') AS ClasificacionTriage, \n IF(h_egreso_atencion.Id IS NULL, 0, 1) estadoEgreso\n FROM h_atencion  \nINNER JOIN c_citasnp               ON (h_atencion.Id_Ingreso = c_citasnp.Id_ingreso)  \nINNER JOIN profesional1            ON (profesional1.Id_Persona = h_atencion.Id_Profesional)    AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad)   \nINNER JOIN g_usuario_sist          ON (profesional1.Id_Persona = g_usuario_sist.Id_Persona)  \nINNER JOIN ingreso                 ON (h_atencion.Id_Ingreso = ingreso.Id)   \nINNER JOIN g_persona               ON (g_persona.Id = ingreso.Id_Usuario)  \nINNER JOIN c_clasecita             ON (h_atencion.Id_ClaseCita = c_clasecita.Id) \nINNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)    \nLEFT JOIN h_egreso_atencion        ON (h_egreso_atencion.Id_Ingreso=ingreso.Id) AND (h_egreso_atencion.Estado=1) AND (h_egreso_atencion.Id_Tipo=ingreso.Id_TipoAtencion) \nLEFT JOIN h_triage                 ON (h_triage.IdIngreso=ingreso.Id)                        \nWHERE (c_citasnp.Fecha_Cita >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' \n    AND c_citasnp.Fecha_Cita <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' \n    AND h_atencion.Codigo_Dxp <> '' \n    AND ingreso.Id_Sede = '" + this.xid[this.JCBUno.getSelectedIndex()] + "' \n    AND TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,   ' ',  h_atencion.Hora_Atencion  ),  CONCAT( c_citasnp.Fecha_Cita,  ' ',  c_citasnp.HoraInicial)) > - 1) \n  HAVING estadoEgreso=1\nORDER BY c_citasnp.Fecha_Cita ASC";
            System.out.println("CONSULTAS DE URGENCIAS " + this.xsql);
            ResultSet rs = this.xct.traerRs(this.xsql);
            mCrearTablaDetalleUrgencias();
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
                        this.xmodelo.setValueAt(rs.getString(5), x, 4);
                        this.xmodelo.setValueAt(rs.getString(6), x, 5);
                        this.xmodelo.setValueAt(rs.getString(7), x, 6);
                        this.xmodelo.setValueAt(rs.getString(8), x, 7);
                        this.xmodelo.setValueAt(rs.getString(9), x, 8);
                        this.xmodelo.setValueAt(rs.getString(10), x, 9);
                        this.xmodelo.setValueAt(rs.getString(11), x, 10);
                        this.xmodelo.setValueAt(rs.getString(12), x, 11);
                        this.xmodelo.setValueAt(rs.getString(13), x, 12);
                        this.xmodelo.setValueAt(rs.getString(14), x, 13);
                        this.xmodelo.setValueAt(rs.getString(15), x, 14);
                        this.xmodelo.setValueAt(rs.getString(16), x, 15);
                        this.xmodelo.setValueAt(rs.getString(17), x, 16);
                        this.xmodelo.setValueAt(rs.getString(18), x, 17);
                        this.xmodelo.setValueAt(rs.getString(19), x, 18);
                        this.xmodelo.setValueAt(rs.getString(20), x, 19);
                        this.xmodelo.setValueAt(rs.getString(21), x, 20);
                        this.xmodelo.setValueAt(rs.getString(22), x, 21);
                        this.xmodelo.setValueAt(rs.getString(23), x, 22);
                        this.xmodelo.setValueAt(rs.getString(24), x, 23);
                        this.xmodelo.setValueAt(rs.getString(25), x, 24);
                        this.xmodelo.setValueAt(rs.getString(26), x, 25);
                        this.xmodelo.setValueAt(rs.getString(27), x, 26);
                        this.xmodelo.setValueAt(rs.getString(28), x, 27);
                        this.xmodelo.setValueAt(rs.getString(29), x, 28);
                        this.xmodelo.setValueAt(rs.getString("fechaEgreso"), x, 29);
                        this.xmodelo.setValueAt(rs.getString("ClasificacionTriage"), x, 30);
                        x++;
                    }
                    this.JTFFNRegistro.setValue(Integer.valueOf(x));
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
        }
    }

    private void mCrearTablaConsolidadoUrgencias() {
        this.xmodelocons = new DefaultTableModel((Object[][]) null, new String[]{"Empresa", "Cantidad", "Tiempo Atencion", "Promedio"}) { // from class: Informes.JIFInformesVarios.5
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTConsolidado.setModel(this.xmodelocons);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosUrgenciaConsilidado() {
        if (this.JCBUno.getSelectedIndex() != -1) {
            this.xsql = "SELECT  f_empresacontxconvenio.Nbre AS NEmpresa, COUNT(h_atencion.`Id`) AS Cantidad  ,SUM((HOUR(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.`Hora_Atencion`),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.`HoraInicial`) ))*60)  + (MINUTE(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.`Hora_Atencion`),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.`HoraInicial`) )))  + (ROUND( (SECOND(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.`Hora_Atencion`),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.`HoraInicial`) ))/60)))   )AS TAencion,   ROUND(((SUM((HOUR(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.`Hora_Atencion`),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.`HoraInicial`) ))*60)  + (MINUTE(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.`Hora_Atencion`),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.`HoraInicial`) )))  + (ROUND( (SECOND(TIMEDIFF(CONCAT(h_atencion.Fecha_Atencion,' ', h_atencion.`Hora_Atencion`),CONCAT(c_citasnp.Fecha_Cita,' ', c_citasnp.`HoraInicial`) ))/60)))   ))/COUNT(h_atencion.`Id`)),2) AS Promedio  FROM h_atencion  INNER JOIN c_citasnp  ON (h_atencion.Id_Ingreso = c_citasnp.Id_ingreso)  INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencion.Id_Profesional)    AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad)   INNER JOIN g_usuario_sist ON (profesional1.Id_Persona = g_usuario_sist.Id_Persona)  INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id)   INNER JOIN persona  ON (persona.Id_Persona = ingreso.Id_Usuario) INNER JOIN c_clasecita  ON (h_atencion.Id_ClaseCita = c_clasecita.Id)  INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)   WHERE (c_citasnp.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `ingreso`.`Egreso`=1 AND c_citasnp.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'  AND  h_atencion.Codigo_Dxp <>'' AND ingreso.Id_Sede ='" + this.xid[this.JCBUno.getSelectedIndex()] + "' )     GROUP BY f_empresacontxconvenio.`Id`  ORDER BY c_citasnp.Fecha_Cita ASC, persona.NUsuario ASC ";
            ResultSet rs = this.xct.traerRs(this.xsql);
            mCrearTablaConsolidadoUrgencias();
            try {
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 0;
                    while (rs.next()) {
                        this.xmodelocons.addRow(this.xdato);
                        this.xmodelocons.setValueAt(rs.getString(1), x, 0);
                        this.xmodelocons.setValueAt(rs.getString(2), x, 1);
                        this.xmodelocons.setValueAt(rs.getString(3), x, 2);
                        this.xmodelocons.setValueAt(rs.getString(4), x, 3);
                        x++;
                    }
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
            }
        }
    }

    private Double mBuscarDatosExamen(String xprocedimiento, String xprotocolo, String xidusuario) {
        double xdatox = 0.0d;
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT l_detalleresultado.VrNumerico FROM l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_procedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.Id ='" + xprocedimiento + "' AND l_protocolos.Id ='" + xprotocolo + "' AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_recepcion.Id, l_protocolos.Id ORDER BY l_resultados.FechaResult DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getDouble(1);
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return Double.valueOf(xdatox);
    }

    private String mBuscarDatosExamenEvaluarR(String xprocedimiento, String xprotocolo, String xidusuario) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT l_detalleresultado.VrNumerico FROM l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_procedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.Id ='" + xprocedimiento + "' AND l_protocolos.Id ='" + xprotocolo + "' AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_recepcion.Id, l_protocolos.Id ORDER BY l_resultados.FechaResult DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                if (xrs1.getString(1).equals("Neg")) {
                    xdatox = "0";
                } else {
                    xdatox = "1";
                }
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosExamenFecha(String xprocedimiento, String xprotocolo, String xidusuario) {
        String xdatox = "";
        this.xencontro = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT date_format(l_resultados.FechaResult,'%d-%m-%Y') FROM l_resultados INNER JOIN l_recepcion  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_procedimiento  ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.Id ='" + xprocedimiento + "' AND l_protocolos.Id ='" + xprotocolo + "' AND l_recepcion.Id_Paciente ='" + xidusuario + "' ) GROUP BY l_recepcion.Id, l_protocolos.Id ORDER BY l_resultados.FechaResult DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getString(1);
                this.xencontro = "1";
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosPrograma(String xidusuario, String xidprograma) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT Id_Programa FROM g_usuarioxprograma WHERE (Id_Usuario ='" + xidusuario + "' AND Id_Programa ='" + xidprograma + "');";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = "1";
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private String mBuscarDatosExamenFisicoPeso(String xidusuario) {
        String xdatox = "0";
        ConsultasMySQL xct2 = new ConsultasMySQL();
        this.xsql = "SELECT h_examenfisico.Peso FROM h_atencion INNER JOIN h_examenfisico  ON (h_atencion.Id = h_examenfisico.Id_Atencion) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + xidusuario + "' AND h_examenfisico.Peso <>0) ORDER BY h_atencion.Fecha_Atencion DESC ";
        ResultSet xrs1 = xct2.traerRs(this.xsql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                xdatox = xrs1.getString(1);
            }
            xrs1.close();
            xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xdatox;
    }

    private void mExportarInformacion() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, this.xnombre.toUpperCase()));
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x + 1, 0, this.JTDetalle.getColumnName(x)));
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
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x2, 14).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x2, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x2, 17).toString()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void mExportarInformacionUrgencias() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("Detallado", 0);
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
                        sheet.addCell(new Label(14, y, this.xmodelo.getValueAt(x2, 14).toString()));
                        sheet.addCell(new Label(15, y, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, y, this.xmodelo.getValueAt(x2, 16).toString()));
                        sheet.addCell(new Label(17, y, this.xmodelo.getValueAt(x2, 17).toString()));
                        sheet.addCell(new Label(18, y, this.xmodelo.getValueAt(x2, 18).toString()));
                        sheet.addCell(new Label(19, y, this.xmodelo.getValueAt(x2, 19).toString()));
                        sheet.addCell(new Label(20, y, this.xmodelo.getValueAt(x2, 20).toString()));
                        sheet.addCell(new Label(21, y, this.xmodelo.getValueAt(x2, 21).toString()));
                        sheet.addCell(new Label(22, y, this.xmodelo.getValueAt(x2, 22).toString()));
                        sheet.addCell(new Label(23, y, this.xmodelo.getValueAt(x2, 23).toString()));
                        y++;
                    }
                    WritableSheet sheet2 = workbook.createSheet("Consolidado", 0);
                    for (int x3 = 0; x3 < this.JTConsolidado.getColumnCount(); x3++) {
                        sheet2.addCell(new Label(x3, 0, this.JTConsolidado.getColumnName(x3)));
                    }
                    int z = 1;
                    for (int x4 = 0; x4 < this.JTConsolidado.getRowCount(); x4++) {
                        sheet2.addCell(new Label(0, z, this.xmodelocons.getValueAt(x4, 0).toString()));
                        sheet2.addCell(new Label(1, z, this.xmodelocons.getValueAt(x4, 1).toString()));
                        sheet2.addCell(new Label(2, z, this.xmodelocons.getValueAt(x4, 2).toString()));
                        sheet2.addCell(new Label(3, z, this.xmodelocons.getValueAt(x4, 3).toString()));
                        z++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }
}
