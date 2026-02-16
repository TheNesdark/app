package Salud_Ocupacional;

import Acceso.Principal;
import General.JDBiometrico;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.utilidades.GeneracionFichaTomaMuestraCovid19_Nueva;
import com.genoma.plus.dao.impl.salud_ocupacional.ControlRemisionesDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.ControlRemisionesDAO;
import com.genoma.plus.dto.salud_ocupacional.ControlDeRemisionDTO;
import com.genoma.plus.dto.salud_ocupacional.ControlDeRemisionesDetalleCitaDTO;
import com.genoma.plus.dto.salud_ocupacional.InformacionDeRemisionDTO;
import com.genoma.plus.dto.salud_ocupacional.TipoAtencionRemisionDTO;
import com.genoma.plus.jpa.projection.ICargarEspecializacionYCausa;
import com.genoma.plus.jpa.service.impl.ICargarCombosControlRemisionesDAO;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.toedter.calendar.JDateChooser;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFControlDeRemisiones.class */
public class JIFControlDeRemisiones extends JInternalFrame {
    private Object[] xdato;
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloCita;
    private DefaultTableModel xmodeloHistorico;
    private DefaultTableModel xmodeloExportar;
    private Object[] dato;
    private Object[] xdatosCita;
    private List<ControlDeRemisionesDetalleCitaDTO> listaDetalleCita;
    private String xnombre;
    private JTable tabla_combo;
    JTableComboBox[] xcomboBox;
    private List<ICargarEspecializacionYCausa> especilidad;
    private List<ICargarEspecializacionYCausa> causaExterna;
    private List<ICargarEspecializacionYCausa> profesiionalCOmbo;
    private List<ControlDeRemisionesDetalleCitaDTO> xDetalleCitaDto;
    private List<ControlDeRemisionesDetalleCitaDTO> xDetalleCitaDtoN;
    private List<Object[]> list;
    private Object[] xdatos;
    private Object[] xdatosHistorico;
    private Object[] xdatosExportar;
    private ControlRemisionesDAO xControlRemisionesServicioDAO;
    private final ICargarCombosControlRemisionesDAO xICargarComboControlRemisiones;
    private int clasificacionEmpleado;
    private int AcompananteTransporteAereo;
    private int acompanante;
    private int transporteAereo;
    private int idRCita;
    static PdfReader reader;
    static PdfStamper stamper;
    static BaseFont bf;
    static PdfContentByte over;
    private JButton JBAgregarCargoTablaBS1;
    private JButton JBEliminarR;
    private JButton JBTExportar;
    private JButton JBTHuella;
    private JComboBox<String> JCBCausaExterna;
    private JComboBox<String> JCBCiudad;
    private JComboBox<String> JCBEspecialidadRequerida;
    private JComboBox<String> JCBProfesionalQueAutoriza;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPIFDatosUsuario;
    private JPanel JPITipoAtencion;
    private JScrollPane JSPDDatosCitaMedica;
    private JScrollPane JSPDDatosCitaMedica1;
    private JSpinner JSPDiasPorFuera;
    private JScrollPane JSPExportarRemision;
    private JScrollPane JSPHistoricoRemisiones;
    private JTable JTBDatosCitaMedica;
    private JTable JTBExportarRemision;
    private JTable JTBHistoricoRemisiones;
    private JTable JTBTipoAtencion;
    private JTextField JTFBarrio;
    private JTextField JTFCodEmpleado;
    private JTextField JTFDireccion;
    private JTextField JTFDireccionHospedaje;
    private JTextField JTFEPS;
    private JTextField JTFHoraCita;
    private JTextField JTFNombreEspecialista;
    private JTextField JTFNombreInstitucion;
    private JTextField JTFRuta;
    private JTextField JTFTelefonoCita1;
    private JTabbedPane JTPDatos;
    private JLabel LblPasaporte;
    private JButton NUEVO;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private ButtonGroup buttonGroup4;
    private ButtonGroup buttonGroup5;
    private ButtonGroup buttonGroup6;
    private ButtonGroup buttonGroup7;
    private ButtonGroup buttonGroup8;
    private JButton jButton1;
    private JDateChooser jDateChooser1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JRadioButton jRCasaFamilia1;
    private JRadioButton jRHotel1;
    private JRadioButton jRIdaAcompanante;
    private JRadioButton jRIdaPaciente;
    private JRadioButton jRIdaYRegresoAcompanante;
    private JRadioButton jRIdaYRegresoPaciente;
    private JRadioButton jRNoAplica;

    /* JADX INFO: renamed from: jRNoAplicaAcompañante, reason: contains not printable characters */
    private JRadioButton f18jRNoAplicaAcompaante;
    private JRadioButton jRNoAplicaPaciente;
    private JRadioButton jRPasaporteNO;
    private JRadioButton jRPasaporteSI;
    private JRadioButton jRRegresoAcompanante;
    private JRadioButton jRRegresoPaciente;
    private JRadioButton jRTRequiereAcompananteNO;
    private JRadioButton jRTRequiereAcompananteSI;
    private JRadioButton jRTipoConvensionado;
    private JRadioButton jRTipoEmpleado;
    private JRadioButton jRTrasnporteAereoACno;
    private JRadioButton jRTrasnporteAereoACsi;
    private JRadioButton jRTrasnporteAereoPNO;
    private JRadioButton jRTrasnporteAereoPSi;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;

    /* JADX INFO: renamed from: jTMotivoDeAcompañante, reason: contains not printable characters */
    private JTextArea f19jTMotivoDeAcompaante;
    private JTextArea jTMotivoTransporteAereoAC;
    private JTextArea jTMotivoTransporteAereoP;

    /* JADX INFO: renamed from: jTNombreAcompañante, reason: contains not printable characters */
    private JTextField f20jTNombreAcompaante;
    private JTabbedPane jTabbedPane1;
    private JTextField jTextObservacion;
    private String direccionCita = "";
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private Integer idRemison = -1;
    private Integer idRemisionBiometrica = 0;
    ArrayList editors = new ArrayList();
    private boolean xestadog = false;
    private boolean xlleno = false;
    private String fechaI = "";
    private String fechaF = "";
    private List<Integer> idTipoA = new ArrayList();
    private List<Integer> idRemisionDetalleCita = new ArrayList();
    private boolean filtroCodEmpleado = false;

    public JIFControlDeRemisiones(String xnombre) {
        this.xnombre = "";
        initComponents();
        this.xnombre = xnombre;
        setName(xnombre);
        mCargasPanelUsuario();
        springStart();
        this.xICargarComboControlRemisiones = (ICargarCombosControlRemisionesDAO) Principal.contexto.getBean(ICargarCombosControlRemisionesDAO.class);
        this.f18jRNoAplicaAcompaante.setVisible(false);
        this.jRNoAplicaPaciente.setVisible(false);
        mCargarCombo();
        mCrearModeloDatosTipoAtencion();
        mCargarDatosTabla();
        this.xDetalleCitaDto = new ArrayList();
        this.xDetalleCitaDtoN = new ArrayList();
        if (Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("NEGOCIOS AGROFORESTALES S.A.S")) {
            mCrearModeloDetalleCita();
        } else {
            mCrearModeloDetalleCita();
            this.JCBCiudad.setEnabled(false);
        }
        mCrearModeloHistorico();
        mCargarDatosExportar();
        limitarCaracteres();
    }

    private void springStart() {
        this.xControlRemisionesServicioDAO = (ControlRemisionesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("ControlRemisionesServicioDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalleCita() {
        this.xmodeloCita = new DefaultTableModel(new Object[0], new String[]{"id", "idRemision", "idEspecialidad", "Especialidad", "nombreProfesional", "Fecha Cita", "Hora Cita", "Estado", "TelefonoCita", "DireccionCita", "Institución"}) { // from class: Salud_Ocupacional.JIFControlDeRemisiones.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDatosCitaMedica.setModel(this.xmodeloCita);
        JTable jTable = this.JTBDatosCitaMedica;
        JTable jTable2 = this.JTBDatosCitaMedica;
        jTable.setAutoResizeMode(0);
        this.JTBDatosCitaMedica.doLayout();
        this.JTBDatosCitaMedica.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(0).setMaxWidth(50);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(0).setMinWidth(50);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(2).setMaxWidth(50);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(2).setMinWidth(50);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDatosCitaMedica.getColumnModel().getColumn(10).setPreferredWidth(80);
    }

    private void mCargarDatosHistorico() {
        String xsql;
        if (this.JTFCodEmpleado.getText().isEmpty() || this.JTFCodEmpleado.getText() == null) {
            this.filtroCodEmpleado = false;
        }
        if (this.filtroCodEmpleado) {
            xsql = "SELECT sr.Id AS idRemision,CONCAT(gp.Nombre1,' ',gp.Nombre2,' ',gp.Apellido1,' ',gp.Apellido2) Empleado, gp.NoDocumento , ' - ' EspecializacionRequerida\n, ' - ' '--'\n,sr.fechaRegistro Fecha,  sr.`codigoEmpleado` FROM so_control_remisiones sr\n\nLEFT JOIN g_persona gp ON gp.Id = sr.idPersona\nLEFT JOIN g_causaexterna gc ON gc.Id=sr.idCausaExterna\nWHERE sr.estado =1\n and (sr.codigoEmpleado = '" + this.JTFCodEmpleado.getText() + "' or gp.NoDocumento = '" + this.JTFCodEmpleado.getText() + "')order by sr.fechaRegistro desc";
        } else {
            xsql = "SELECT sr.Id AS idRemision,CONCAT(gp.Nombre1,' ',gp.Nombre2,' ',gp.Apellido1,' ',gp.Apellido2) Empleado, gp.NoDocumento , ' - ' EspecializacionRequerida\n, ' - ' '--'\n,sr.fechaRegistro Fecha FROM so_control_remisiones sr\n\nLEFT JOIN g_persona gp ON gp.Id = sr.idPersona\nLEFT JOIN g_causaexterna gc ON gc.Id=sr.idCausaExterna\nWHERE sr.estado =1\norder by sr.fechaRegistro desc";
        }
        System.out.println("consulta que trae el historico -> " + xsql);
        mCrearModeloHistorico();
        ResultSet rs = this.xct.traerRs(xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodeloHistorico.addRow(this.xdatosHistorico);
                    this.xmodeloHistorico.setValueAt(rs.getString(1), x, 0);
                    this.xmodeloHistorico.setValueAt(rs.getString(2), x, 1);
                    this.xmodeloHistorico.setValueAt(rs.getString(3), x, 2);
                    this.xmodeloHistorico.setValueAt(rs.getString(4), x, 3);
                    this.xmodeloHistorico.setValueAt(rs.getString(5), x, 4);
                    this.xmodeloHistorico.setValueAt(rs.getString(6), x, 5);
                    this.xmodeloHistorico.setValueAt("> Imprimir <", x, 6);
                    this.xmodeloHistorico.setValueAt("> Biometría <", x, 7);
                    this.xmodeloHistorico.setValueAt("> Eliminar <", x, 8);
                    this.xmodeloHistorico.setValueAt("> Editar <", x, 9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloHistorico = new DefaultTableModel(new Object[0], new String[]{"idRemision", "Empleado", "No. Documento", "Especialidad", "Profesional", "Fecha", "Imprimir", "Biometria", "Eliminar", "Editar"}) { // from class: Salud_Ocupacional.JIFControlDeRemisiones.2
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, JButton.class, JButton.class, JButton.class, JButton.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistoricoRemisiones.setModel(this.xmodeloHistorico);
        JTable jTable = this.JTBHistoricoRemisiones;
        JTable jTable2 = this.JTBHistoricoRemisiones;
        jTable.setAutoResizeMode(0);
        this.JTBHistoricoRemisiones.doLayout();
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(0).setMaxWidth(90);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(0).setMinWidth(90);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(6).setPreferredWidth(130);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(7).setPreferredWidth(130);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(8).setPreferredWidth(130);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(9).setPreferredWidth(130);
        MyTableCellRenderer renderer = new MyTableCellRenderer();
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(6).setCellRenderer(renderer);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(7).setCellRenderer(renderer);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(8).setCellRenderer(renderer);
        this.JTBHistoricoRemisiones.getColumnModel().getColumn(9).setCellRenderer(renderer);
    }

    private void cargarDatosA() {
        String sql = "SELECT\n                   gp.NoDocumento ,cr.`id` idRemision,\n                   cr.`fecha` fechaRemision,\n  d.`idControlRemisiones`,\n             d.id idRemisionDetalleCita,                   cr.`idPersona` idPersona,\n                   cr.`hospedaje`,\n                   cr.`direccion` direccionR,\n                   cr.`idCausaExterna`,\n                   ce.`Nbre` nbreCausaExterna,                    cr.`barrioHospedaje`,\n                   cr.`transporteAereo`,\n                   cr.`motivoTransporteAereo`,\n                   cr.`acompanante`,\n                   cr.`motivoAcompanante`,\n                   cr.`AcompananteTransporteAereo`,\n                   cr.`nombreAcompanante`,\n                   cr.`motivoTransporteAereoAcomp`,\n                   cr.`idProfesiona` idProfesionalRemision,\n                   cr.`clasificacionEmpleado`,\n                   cr.`codigoEmpleado`,\n                   cr.`observacion`,\n                   cr.`corberturaViajePaciente`,\n                   cr.`corbeturaViajeAcompanante`,\n                   d.`id` idDetalleCita,\n                   d.`idEspecialidad`,\n                   d.`nombreProfesional`,\n                   ge.`Nbre` AS especialidad,\n                   d.`fechaCita`,\n                   d.`horaCita`,\n                   d.`telefonoCita`,\n                   d.`direcionCita`,\n                   d.`nombreInstitucion`\n ,\n    p.profesional, cr.diasPorFueraPaciente                    \n ,cr.epsRemision                  FROM `so_control_remisiones` cr \n                 INNER JOIN `so_control_remisiones_detalle_cita` d ON cr.`id` = d.`idControlRemisiones` \n                 \n                  INNER JOIN `g_causaexterna` ce ON (ce.`Id`=cr.`idCausaExterna`)                  INNER JOIN `g_especialidad` ge ON ge.`Id` = d.`idEspecialidad` \n                 INNER JOIN `g_persona` gp ON gp.`Id` = cr.`idPersona` \n LEFT JOIN (\n    SELECT CONCAT(gp1.`Nombre1`, ' ', gp1.`Nombre2`, ' ', gp1.`Apellido1`, ' ', gp1.`Apellido2`) AS profesional,\n    gpr.id\n    FROM g_profesional gpr\n    INNER JOIN g_persona gp1 ON (gp1.`Id`=gpr.`Id_Persona`)\n    INNER JOIN `so_control_remisiones` scr ON (gpr.`id`=scr.idProfesiona)\n    WHERE scr.Id = '" + Principal.txtNo.getText() + "'\n) AS p ON p.id = cr.idProfesiona                 \n                 WHERE cr.`id` =  '" + Principal.txtNo.getText() + "' AND d.estado=1 \n                  GROUP BY d.`id`;";
        ResultSet rs = this.xct.traerRs(sql);
        System.out.println("Consulta editar ------------------------------ " + sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xjppersona.txtHistoria.setText(rs.getString("NoDocumento"));
                    this.xjppersona.txtHistoria.requestFocus();
                    try {
                        Robot robot = new Robot();
                        robot.keyPress(10);
                        robot.keyRelease(10);
                    } catch (AWTException e) {
                        e.printStackTrace();
                    }
                    this.JTFCodEmpleado.setText(rs.getString("codigoEmpleado"));
                    if (rs.getInt("clasificacionEmpleado") == 0) {
                        this.jRTipoEmpleado.setSelected(true);
                    } else {
                        this.jRTipoConvensionado.setSelected(true);
                    }
                    this.JCBCausaExterna.setSelectedItem(rs.getString("nbreCausaExterna"));
                    if (rs.getInt("hospedaje") == 0) {
                        this.jRCasaFamilia1.setSelected(true);
                    } else if (rs.getInt("hospedaje") == 1) {
                        this.jRHotel1.setSelected(true);
                    } else {
                        this.jRNoAplica.setSelected(true);
                    }
                    this.JTFBarrio.setText(rs.getString("barrioHospedaje"));
                    this.JTFDireccionHospedaje.setText(rs.getString("direccionR"));
                    this.JCBProfesionalQueAutoriza.setSelectedItem(rs.getString("profesional"));
                    if (rs.getInt("transporteAereo") == 0) {
                        this.jRTrasnporteAereoPNO.setSelected(true);
                    } else {
                        this.jRTrasnporteAereoPSi.setSelected(true);
                    }
                    if (rs.getInt("corberturaViajePaciente") == 0) {
                        this.jRIdaPaciente.setSelected(true);
                    } else if (rs.getInt("corberturaViajePaciente") == 1) {
                        this.jRIdaYRegresoPaciente.setSelected(true);
                    } else if (rs.getInt("corberturaViajePaciente") == 2) {
                        this.jRRegresoPaciente.setSelected(true);
                    } else {
                        this.jRIdaPaciente.setSelected(false);
                        this.jRIdaYRegresoPaciente.setSelected(false);
                        this.jRRegresoPaciente.setSelected(false);
                    }
                    System.out.println("AcompananteTransporteAereo -> " + rs.getInt("AcompananteTransporteAereo"));
                    if (rs.getInt("AcompananteTransporteAereo") == 0) {
                        this.jRTrasnporteAereoACno.setSelected(true);
                    } else {
                        this.jRTrasnporteAereoACsi.setSelected(true);
                    }
                    if (rs.getInt("corbeturaViajeAcompanante") == 0) {
                        this.jRIdaAcompanante.setSelected(true);
                    } else if (rs.getInt("corbeturaViajeAcompanante") == 1) {
                        this.jRIdaYRegresoAcompanante.setSelected(true);
                    } else if (rs.getInt("corbeturaViajeAcompanante") == 2) {
                        this.jRRegresoAcompanante.setSelected(true);
                    } else {
                        this.jRIdaAcompanante.setSelected(false);
                        this.jRIdaYRegresoAcompanante.setSelected(false);
                        this.jRRegresoAcompanante.setSelected(false);
                    }
                    if (rs.getInt("acompanante") == 0) {
                        this.jRTRequiereAcompananteNO.setSelected(true);
                    } else {
                        this.jRTRequiereAcompananteSI.setSelected(true);
                    }
                    this.f20jTNombreAcompaante.setText(rs.getString("nombreAcompanante"));
                    this.jTMotivoTransporteAereoP.setText(rs.getString("motivoTransporteAereo"));
                    this.f19jTMotivoDeAcompaante.setText(rs.getString("motivoAcompanante"));
                    this.jTMotivoTransporteAereoAC.setText(rs.getString("motivoTransporteAereoAcomp"));
                    this.jTextObservacion.setText(rs.getString("observacion"));
                    this.JSPDiasPorFuera.setValue(Integer.valueOf(rs.getInt("diasPorFueraPaciente")));
                    this.JTFEPS.setText(rs.getString("epsRemision"));
                    ControlDeRemisionesDetalleCitaDTO detalleCitaDto = new ControlDeRemisionesDetalleCitaDTO();
                    detalleCitaDto.setId(Long.valueOf(rs.getLong("idRemisionDetalleCita")));
                    detalleCitaDto.setIdControlRemisiones(Long.valueOf(rs.getLong("idControlRemisiones")));
                    detalleCitaDto.setIdEspecialidad(Integer.valueOf(rs.getInt("idEspecialidad")));
                    detalleCitaDto.setNombreProfesional(rs.getString("nombreProfesional"));
                    detalleCitaDto.setFechaCita(rs.getString("fechaCita"));
                    String horaCita = rs.getString("horaCita");
                    detalleCitaDto.setHoraCita(horaCita.substring(0, horaCita.length() - 3));
                    detalleCitaDto.setTelefonoCita(rs.getString("telefonoCita"));
                    detalleCitaDto.setDireccionCita(rs.getString("direcionCita"));
                    detalleCitaDto.setInstitucion(rs.getString("nombreInstitucion"));
                    this.xmodeloCita.addRow(new Object[]{detalleCitaDto.getId(), detalleCitaDto.getIdControlRemisiones(), detalleCitaDto.getIdEspecialidad(), rs.getString("especialidad"), detalleCitaDto.getNombreProfesional(), detalleCitaDto.getFechaCita(), detalleCitaDto.getHoraCita(), detalleCitaDto.getEstado(), detalleCitaDto.getTelefonoCita(), detalleCitaDto.getDireccionCita(), detalleCitaDto.getInstitucion()});
                    int idRDT = rs.getInt("idRemisionDetalleCita");
                    this.idRemisionDetalleCita.add(Integer.valueOf(idRDT));
                    x++;
                }
            }
            String sql1 = "SELECT ta.`Nbre` AS tipoAtencion, crta.id FROM `so_control_remisiones` cr\nINNER JOIN `so_control_remisiones_detalle_tipo_atencion` crta ON (cr.`id`=crta.`idControlRemision`)\nINNER JOIN `so_tipo_atencion` ta ON (crta.`idTipoAtencion`=ta.`id`)\nWHERE cr.`id`='" + Principal.txtNo.getText() + "' and crta.estado=1";
            ResultSet rs1 = this.xct.traerRs(sql1);
            System.out.println("rs1+" + sql1);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x2 = 0;
                while (rs1.next()) {
                    for (int i = 0; i < this.tabla_combo.getRowCount(); i++) {
                        if (rs1.getString("tipoAtencion").equals(this.tabla_combo.getValueAt(i, 1).toString())) {
                            this.tabla_combo.setValueAt(true, i, 2);
                            int idTipoA = rs1.getInt("id");
                            this.idTipoA.add(Integer.valueOf(idTipoA));
                        }
                    }
                    x2++;
                }
            }
            rs1.close();
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void subirRegistroDetalleCita() {
        String fechaCitaStr = this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 5).toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaCita = null;
        try {
            fechaCita = dateFormat.parse(fechaCitaStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.JCBCiudad.setSelectedItem(this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 9));
        this.JTFDireccion.setText(this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 9).toString());
        this.JTFNombreInstitucion.setText(this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 10).toString());
        this.JTFNombreEspecialista.setText(this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 4).toString());
        this.JCBEspecialidadRequerida.setSelectedItem(this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 3).toString());
        this.JTFTelefonoCita1.setText(this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 8).toString());
        this.JTFHoraCita.setText(this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 6).toString());
        this.jDateChooser1.setDate(fechaCita);
    }

    private void actualizarTipoAtencion(String idR, List<Integer> idTipoA) {
        if (this.tabla_combo.getRowCount() > 0) {
            Integer[] idTipoAt = (Integer[]) idTipoA.toArray(new Integer[idTipoA.size()]);
            int tamanoArreglo = idTipoAt.length;
            for (int i = 0; i < this.tabla_combo.getRowCount() && i < tamanoArreglo; i++) {
                String idTipoAtencion = this.tabla_combo.getValueAt(i, 0).toString();
                boolean seleccionado = this.tabla_combo.getValueAt(i, 2).toString().equals("true");
                Integer idTipoAA = idTipoAt[i];
                String queryExistencia = "SELECT * FROM `so_control_remisiones_detalle_tipo_atencion` WHERE `idControlRemision` = '" + idR + "' AND `id` = '" + idTipoAA + "'  AND `idTipoAtencion` = '" + idTipoAtencion + "'";
                System.out.println("verificar primero - " + queryExistencia);
                ResultSet rs = this.xct.traerRs(queryExistencia);
                try {
                    if (rs.next()) {
                        int estadoActual = rs.getInt("estado");
                        if (!seleccionado && estadoActual == 1) {
                            String queryActualizar = "UPDATE `so_control_remisiones_detalle_tipo_atencion` SET `estado` = 0 WHERE `idControlRemision` = '" + idR + "' AND `idTipoAtencion` = '" + idTipoAtencion + "'";
                            System.out.println("Actualizar estado en so_control_remisiones_detalle_tipo_atencion -> " + queryActualizar);
                            System.out.println("");
                            this.xct.ejecutarSQL(queryActualizar);
                        } else if (seleccionado && estadoActual == 0) {
                            String queryActualizar2 = "UPDATE `so_control_remisiones_detalle_tipo_atencion` SET `estado` = 1 WHERE `idControlRemision` = '" + idR + "' AND `idTipoAtencion` = '" + idTipoAtencion + "'";
                            System.out.println("Actualizar estado en so_control_remisiones_detalle_tipo_atencion -> " + queryActualizar2);
                            this.xct.ejecutarSQL(queryActualizar2);
                        }
                    } else if (seleccionado) {
                        String queryExistenciaTipoAtencion = "SELECT * FROM `so_control_remisiones_detalle_tipo_atencion` WHERE `idControlRemision` = '" + idR + "' AND `idTipoAtencion` = '" + idTipoAtencion + "'";
                        ResultSet rsTipoAtencion = this.xct.traerRs(queryExistenciaTipoAtencion);
                        if (!rsTipoAtencion.next()) {
                            String queryInsertar = "INSERT INTO `so_control_remisiones_detalle_tipo_atencion` (`idControlRemision`,  `idTipoAtencion`, `estado`) VALUES ('" + idR + "', '" + idTipoAtencion + "', 1)";
                            System.out.println("Insertar en so_control_remisiones_detalle_tipo_atencion -> " + queryInsertar);
                            this.xct.ejecutarSQL(queryInsertar);
                        }
                        rsTipoAtencion.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                this.xct.cerrarConexionBd();
            }
        }
        new TipoAtencionRemisionDTO();
    }

    private void retirarDetalle() {
        int idRemision = Integer.parseInt(Principal.txtNo.getText());
        int idDetalleC = Integer.parseInt(this.xmodeloCita.getValueAt(this.JTBDatosCitaMedica.getSelectedRow(), 0).toString());
        System.out.println("idRemision -> " + idRemision);
        System.out.println("idDetalleC -> " + idDetalleC);
        if (!Principal.txtNo.getText().isEmpty() && idDetalleC > 0) {
            String sql = "UPDATE so_control_remisiones_detalle_cita SET estado = 0 WHERE id = '" + idDetalleC + "' AND idControlRemisiones = '" + idRemision + "'";
            System.out.println("Actualizar estado en so_control_remisiones_detalle_cita -> " + sql);
            this.xct.ejecutarSQL(sql);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFControlDeRemisiones$MyTableCellRenderer.class */
    class MyTableCellRenderer extends DefaultTableCellRenderer {
        MyTableCellRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Font font = new Font("Dialog", 2, 12);
            if (column == 6 || column == 7 || column == 8 || column == 9) {
                c.setForeground(Color.blue);
                c.setFont(font);
            }
            return c;
        }
    }

    private void grabarDetalleDeCita(String idRemisionx) {
        if (this.JTBDatosCitaMedica.getRowCount() > 0) {
            this.xDetalleCitaDto.clear();
            for (int i = 0; i < this.JTBDatosCitaMedica.getRowCount(); i++) {
                System.out.println(this.JTBDatosCitaMedica.getValueAt(i, 2).toString() + "-" + this.JTBDatosCitaMedica.getValueAt(i, 4).toString() + "--" + this.JTBDatosCitaMedica.getValueAt(i, 5).toString() + "--" + this.JTBDatosCitaMedica.getValueAt(i, 6).toString());
                ControlDeRemisionesDetalleCitaDTO Detalle = new ControlDeRemisionesDetalleCitaDTO();
                Detalle.setIdControlRemisiones(Long.valueOf(idRemisionx));
                Detalle.setIdEspecialidad(Integer.valueOf(this.JTBDatosCitaMedica.getValueAt(i, 2).toString()));
                Detalle.setInstitucion(this.JTBDatosCitaMedica.getValueAt(i, 10).toString());
                Detalle.setNombreProfesional(this.JTBDatosCitaMedica.getValueAt(i, 4).toString());
                Detalle.setFechaCita(this.JTBDatosCitaMedica.getValueAt(i, 5).toString());
                Detalle.setHoraCita(this.JTBDatosCitaMedica.getValueAt(i, 6).toString());
                Detalle.setEstado(true);
                Detalle.setTelefonoCita(this.JTBDatosCitaMedica.getValueAt(i, 8).toString());
                Detalle.setDireccionCita(this.JTBDatosCitaMedica.getValueAt(i, 9).toString());
                this.xDetalleCitaDto.add(Detalle);
            }
            this.xControlRemisionesServicioDAO.grabarControlRemisionDetalleCita(this.xDetalleCitaDto);
        }
    }

    private void actualizarDetalleDeCita(String idRemisionx, List<Integer> idDetalleCita) {
        if (this.JTBDatosCitaMedica.getRowCount() > 0) {
            this.xDetalleCitaDto.clear();
            this.xDetalleCitaDtoN.clear();
            for (int i = 0; i < this.JTBDatosCitaMedica.getRowCount(); i++) {
                System.out.println(this.JTBDatosCitaMedica.getValueAt(i, 2).toString() + "-" + this.JTBDatosCitaMedica.getValueAt(i, 4).toString() + "--" + this.JTBDatosCitaMedica.getValueAt(i, 5).toString() + "--" + this.JTBDatosCitaMedica.getValueAt(i, 6).toString());
                ControlDeRemisionesDetalleCitaDTO Detalle = new ControlDeRemisionesDetalleCitaDTO();
                ControlDeRemisionesDetalleCitaDTO DetalleN = new ControlDeRemisionesDetalleCitaDTO();
                System.out.println("idRemision - -  " + this.xmodeloCita.getValueAt(i, 0).toString());
                if (this.xmodeloCita.getValueAt(i, 0).toString().equals("0")) {
                    DetalleN.setIdControlRemisiones(Long.valueOf(idRemisionx));
                    DetalleN.setIdEspecialidad(Integer.valueOf(this.JTBDatosCitaMedica.getValueAt(i, 2).toString()));
                    DetalleN.setInstitucion(this.JTBDatosCitaMedica.getValueAt(i, 10).toString());
                    DetalleN.setNombreProfesional(this.JTBDatosCitaMedica.getValueAt(i, 4).toString());
                    DetalleN.setFechaCita(this.JTBDatosCitaMedica.getValueAt(i, 5).toString());
                    DetalleN.setHoraCita(this.JTBDatosCitaMedica.getValueAt(i, 6).toString());
                    DetalleN.setTelefonoCita(this.JTBDatosCitaMedica.getValueAt(i, 8).toString());
                    DetalleN.setDireccionCita(this.JTBDatosCitaMedica.getValueAt(i, 9).toString());
                    DetalleN.setEstado(true);
                    this.xDetalleCitaDtoN.add(DetalleN);
                } else {
                    Detalle.setIdListRemision(idDetalleCita);
                    Detalle.setIdControlRemisiones(Long.valueOf(idRemisionx));
                    Detalle.setIdEspecialidad(Integer.valueOf(this.JTBDatosCitaMedica.getValueAt(i, 2).toString()));
                    Detalle.setInstitucion(this.JTBDatosCitaMedica.getValueAt(i, 10).toString());
                    Detalle.setNombreProfesional(this.JTBDatosCitaMedica.getValueAt(i, 4).toString());
                    Detalle.setFechaCita(this.JTBDatosCitaMedica.getValueAt(i, 5).toString());
                    Detalle.setHoraCita(this.JTBDatosCitaMedica.getValueAt(i, 6).toString());
                    Detalle.setTelefonoCita(this.JTBDatosCitaMedica.getValueAt(i, 8).toString());
                    Detalle.setDireccionCita(this.JTBDatosCitaMedica.getValueAt(i, 9).toString());
                    Detalle.setEstado(true);
                    this.xDetalleCitaDto.add(Detalle);
                }
            }
            if (!this.xDetalleCitaDtoN.isEmpty()) {
                this.xControlRemisionesServicioDAO.grabarControlRemisionDetalleCita(this.xDetalleCitaDtoN);
            }
            if (!this.xDetalleCitaDto.isEmpty()) {
                this.xControlRemisionesServicioDAO.actualizarControlRemisionDetalleCitaMineros(this.xDetalleCitaDto, idDetalleCita);
            }
        }
    }

    private void AgregarDetalle() {
        ControlDeRemisionesDetalleCitaDTO DetalleCitaDtox = new ControlDeRemisionesDetalleCitaDTO();
        if (!Principal.txtNo.getText().isEmpty()) {
            Object[] options = {"Nuevo", "Actualizar", "Cerrar"};
            int n = JOptionPane.showOptionDialog((Component) null, "¿Desea agregar un nuevo detalle o actualizar uno anterior?", "Elija una opción", 1, 3, (Icon) null, options, options[2]);
            if (n == 0) {
                DetalleCitaDtox.setId(0L);
            } else if (n == 1) {
                DetalleCitaDtox.setId(Long.valueOf(this.idRCita));
            }
            DetalleCitaDtox.setIdControlRemisiones(Long.valueOf(Principal.txtNo.getText()));
        } else {
            DetalleCitaDtox.setId(1L);
            DetalleCitaDtox.setIdControlRemisiones(Long.valueOf(this.idRemison.intValue()));
        }
        DetalleCitaDtox.setIdEspecialidad(this.especilidad.get(this.JCBEspecialidadRequerida.getSelectedIndex()).getId());
        DetalleCitaDtox.setNombreProfesional(this.JTFNombreEspecialista.getText());
        DetalleCitaDtox.setInstitucion(this.JTFNombreInstitucion.getText());
        DetalleCitaDtox.setFechaCita(this.xmt.formatoAMD.format(this.jDateChooser1.getDate()));
        DetalleCitaDtox.setHoraCita(this.JTFHoraCita.getText());
        DetalleCitaDtox.setEstado(true);
        DetalleCitaDtox.setTelefonoCita(this.JTFTelefonoCita1.getText());
        DetalleCitaDtox.setDireccionCita(this.JTFDireccion.getText());
        if (!this.JTFDireccion.getText().isEmpty()) {
            this.direccionCita = this.JTFDireccion.getText();
        }
        System.out.println("->>>>>>>>>>> " + String.valueOf(DetalleCitaDtox.getId()) + "\n" + String.valueOf(DetalleCitaDtox.getIdControlRemisiones()) + "\n" + String.valueOf(DetalleCitaDtox.getIdEspecialidad()) + "\n" + this.JCBEspecialidadRequerida.getSelectedItem() + "\n" + DetalleCitaDtox.getNombreProfesional() + "\n" + DetalleCitaDtox.getInstitucion() + "\n" + String.valueOf(DetalleCitaDtox.getFechaCita()) + "\n" + String.valueOf(DetalleCitaDtox.getHoraCita()) + "\n" + DetalleCitaDtox.getEstado() + "\n" + DetalleCitaDtox.getTelefonoCita() + "\n" + DetalleCitaDtox.getDireccionCita());
        this.xmodeloCita.addRow(new Object[]{String.valueOf(DetalleCitaDtox.getId()), String.valueOf(DetalleCitaDtox.getIdControlRemisiones()), String.valueOf(DetalleCitaDtox.getIdEspecialidad()), this.JCBEspecialidadRequerida.getSelectedItem(), DetalleCitaDtox.getNombreProfesional(), String.valueOf(DetalleCitaDtox.getFechaCita()), String.valueOf(DetalleCitaDtox.getHoraCita()), DetalleCitaDtox.getEstado(), DetalleCitaDtox.getTelefonoCita(), DetalleCitaDtox.getDireccionCita(), DetalleCitaDtox.getInstitucion()});
        limpiarDatosCitaMedica();
    }

    private void mGrabarRemision() {
        String texto = this.JTFCodEmpleado.getText();
        this.JTFCodEmpleado.setText(texto.replaceAll(" ", ""));
        if (this.jRTipoEmpleado.isSelected() || this.jRTipoConvensionado.isSelected()) {
            if (this.JTFCodEmpleado.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Indique el codigo del trabajador", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            if (Long.valueOf(this.xjppersona.getIdPersona()).longValue() > 0) {
                if (this.JTBDatosCitaMedica.getRowCount() > 0) {
                    if (this.JCBCausaExterna.getSelectedIndex() > -1) {
                        if (this.jRCasaFamilia1.isSelected() || this.jRHotel1.isSelected() || this.jRNoAplica.isSelected()) {
                            int tipoAtencion = 0;
                            if (this.tabla_combo.getRowCount() > 0) {
                                for (int i = 0; i < this.tabla_combo.getRowCount(); i++) {
                                    if (this.tabla_combo.getValueAt(i, 2).toString().equals("true")) {
                                        tipoAtencion++;
                                    }
                                }
                            }
                            if (tipoAtencion > 0) {
                                ControlDeRemisionDTO e = new ControlDeRemisionDTO();
                                e.setDiasPorFueraPaciente(Integer.valueOf(Integer.parseInt(this.JSPDiasPorFuera.getValue().toString())));
                                e.setFecha(this.xmt.formatoAMD.format(this.xmt.getFechaActual()));
                                e.setIdPersona(Long.valueOf(this.xjppersona.getIdPersona()));
                                if (this.jRCasaFamilia1.isSelected()) {
                                    e.setHospedaje(0);
                                } else if (this.jRHotel1.isSelected()) {
                                    e.setHospedaje(1);
                                } else if (this.jRNoAplica.isSelected()) {
                                    e.setHospedaje(-1);
                                }
                                e.setBarrioHospedaje(this.JTFBarrio.getText());
                                String direccionCita = "";
                                for (int i2 = 0; i2 < this.JTBDatosCitaMedica.getRowCount(); i2++) {
                                    direccionCita = this.JTBDatosCitaMedica.getValueAt(i2, 9).toString();
                                }
                                e.setDireccion(direccionCita);
                                e.setIdCausaExterna(this.causaExterna.get(this.JCBCausaExterna.getSelectedIndex()).getId().toString());
                                if (this.jRTrasnporteAereoPSi.isSelected()) {
                                    e.setTransporteAereo(true);
                                    this.transporteAereo = 1;
                                } else {
                                    e.setTransporteAereo(false);
                                    this.transporteAereo = 0;
                                }
                                e.setMotivoTrasnporteAereo(this.jTMotivoTransporteAereoP.getText());
                                if (this.jRTRequiereAcompananteSI.isSelected()) {
                                    e.setAcompanante(true);
                                    this.acompanante = 1;
                                } else {
                                    e.setAcompanante(false);
                                    this.acompanante = 0;
                                }
                                e.setMotivoAcompanante(this.f19jTMotivoDeAcompaante.getText());
                                e.setNombreAcompanante(this.f20jTNombreAcompaante.getText());
                                if (this.jRTrasnporteAereoACsi.isSelected()) {
                                    e.setTransporteAereoAcompananate(true);
                                    this.AcompananteTransporteAereo = 1;
                                } else {
                                    e.setTransporteAereoAcompananate(false);
                                    this.AcompananteTransporteAereo = 0;
                                }
                                e.setMotivoTrasnporteAereoAcompanante(this.jTMotivoTransporteAereoAC.getText());
                                e.setIdPersonaRh(Long.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo().longValue()));
                                e.setEstado(true);
                                e.setFechaRegistro(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
                                e.setIdProfesional(this.profesiionalCOmbo.get(this.JCBProfesionalQueAutoriza.getSelectedIndex()).getId().toString());
                                if (this.jRTipoEmpleado.isSelected()) {
                                    e.setClasificacionEmpleado(false);
                                    this.clasificacionEmpleado = 0;
                                } else {
                                    e.setClasificacionEmpleado(true);
                                    this.clasificacionEmpleado = 1;
                                }
                                e.setCodigoEmpleado(this.JTFCodEmpleado.getText());
                                if (this.jRPasaporteSI.isSelected()) {
                                    e.setPasaporte("1");
                                } else {
                                    e.setPasaporte("0");
                                }
                                e.setObservacion(this.jTextObservacion.getText());
                                if (this.jRIdaPaciente.isSelected()) {
                                    e.setCorbeturaViajeEmpleado("0");
                                } else if (this.jRIdaYRegresoPaciente.isSelected()) {
                                    e.setCorbeturaViajeEmpleado("1");
                                } else if (this.jRRegresoPaciente.isSelected()) {
                                    e.setCorbeturaViajeEmpleado("2");
                                } else {
                                    e.setCorbeturaViajeEmpleado("-1");
                                }
                                if (this.jRIdaAcompanante.isSelected()) {
                                    e.setCorbeturaViajeAcompanante("0");
                                } else if (this.jRIdaYRegresoAcompanante.isSelected()) {
                                    e.setCorbeturaViajeAcompanante("1");
                                } else if (this.jRRegresoAcompanante.isSelected()) {
                                    e.setCorbeturaViajeAcompanante("2");
                                } else {
                                    e.setCorbeturaViajeAcompanante("-1");
                                }
                                e.setEpsRemision(this.JTFEPS.getText());
                                try {
                                    if (Principal.txtNo.getText().isEmpty()) {
                                        this.idRemison = Integer.valueOf(this.xControlRemisionesServicioDAO.grabarControlREmision(e));
                                        this.idRemisionBiometrica = this.idRemison;
                                        grabarDetalleDeCita(String.valueOf(this.idRemison));
                                        mGrabarTipoAtencion(String.valueOf(this.idRemison));
                                    } else if (Integer.parseInt(Principal.txtNo.getText().toString()) > 0) {
                                        this.xControlRemisionesServicioDAO.actualizarControlRemision(e, Integer.valueOf(this.acompanante), Integer.valueOf(this.clasificacionEmpleado), Integer.valueOf(this.AcompananteTransporteAereo), Integer.valueOf(this.transporteAereo));
                                        actualizarDetalleDeCita(Principal.txtNo.getText(), this.idRemisionDetalleCita);
                                        actualizarTipoAtencion(Principal.txtNo.getText(), this.idTipoA);
                                    }
                                    if (this.idRemison.intValue() > 0) {
                                        this.idRemison = -1;
                                        JOptionPane.showMessageDialog(this, "Se ha grabado la remisión", "GRABADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Aceptar30x30.png"))));
                                        mNuevo();
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Hubo un error al grabar la remisión", "ERROR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/equiz rojo.png"))));
                                    }
                                    return;
                                } catch (Exception e2) {
                                    JOptionPane.showMessageDialog(this, "Hubo un error al grabar la remisión", "ERROR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/equiz rojo.png"))));
                                    return;
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Debe seleccionar el menos un tipo de atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de hospedaje", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una causa de remisión", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe agregar almenos un detalle de cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Seleccione la clasificación del empleado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGrabarDetalleCita() {
        LocalTime.parse(this.JTFHoraCita.getText());
        ControlDeRemisionesDetalleCitaDTO Detalle = new ControlDeRemisionesDetalleCitaDTO();
        Detalle.setIdControlRemisiones(Long.valueOf(this.idRemison.intValue()));
        Detalle.setIdEspecialidad(this.especilidad.get(this.JCBEspecialidadRequerida.getSelectedIndex()).getId());
        Detalle.setNombreProfesional(this.JTFNombreEspecialista.getText());
        Detalle.setInstitucion(this.JTFNombreInstitucion.getText());
        Detalle.setFechaCita(this.xmt.formatoAMD.format(this.jDateChooser1.getDate()));
        Detalle.setHoraCita(this.JTFHoraCita.getText());
        Detalle.setEstado(true);
        this.xDetalleCitaDto.add(Detalle);
        this.xControlRemisionesServicioDAO.grabarControlRemisionDetalleCita(this.xDetalleCitaDto);
    }

    private void mGrabarTipoAtencion(String idRemision) {
        if (this.tabla_combo.getRowCount() > 0) {
            for (int i = 0; i < this.tabla_combo.getRowCount(); i++) {
                if (this.tabla_combo.getValueAt(i, 2).toString().equals("true")) {
                    String Query = "INSERT INTO baseserver.so_control_remisiones_detalle_tipo_atencion\n(idControlRemision, idTipoAtencion)\nVALUES('" + idRemision + "', '" + this.tabla_combo.getValueAt(i, 0).toString() + "');";
                    System.out.println("graba en so_control_remisiones_detalle_tipo_atencion -> " + Query);
                    this.xct.ejecutarSQL(Query);
                    this.xct.cerrarConexionBd();
                }
            }
        }
        new TipoAtencionRemisionDTO();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    private void mCargarDatosImpresion(String idRemisions) throws DocumentException {
        InformacionDeRemisionDTO impresionRemision = new InformacionDeRemisionDTO();
        String Query = "select sr.fechaRegistro Fecha ,concat(gp.Nombre1,' ',gp.Nombre2,' ',gp.Apellido1,' ',gp.Apellido2) NombreColaborador\n,gp.NoDocumento Cedula, gp.Direccion,gp.Telefono,sr.id NoConsecutivo\n,sr.direccion DireccionCita,srdc.telefonoCita \t, sr.fecha FechaCita, srdc.nombreProfesional NombreEspecialista , GROUP_CONCAT(DISTINCT ge.Nbre SEPARATOR ' - ') EspecializacionRequerida\n, sr.hospedaje Hospedaje , sr.direccion DireccionHospedaje, gc.Id CausaDeLaRemision\n, sr.transporteAereo PacienteTransporteAereo, sr.motivoTransporteAereo MotivoTransporteAreoPaciente\n, sr.acompanante RequiereAcompanante,sr.motivoAcompanante MotivoAcompanante, AcompananteTransporteAereo TransporteAereoAcompanante\n, sr.motivoTransporteAereoAcomp MotivoTransporteAereoAcompanante, sr.nombreAcompanante NombreAcompanante\n, group_concat(DISTINCT srdc.fechaCita separator ', ') as FechaCitas  , group_concat(distinct srdc.horaCita separator ', ' )  as HoraCitas,sr.barrioHospedaje,sr.firmaColaborador , gp.FechaNac FechaNacColaborador,sr.clasificacionEmpleado ,sr.codigoEmpleado ,sr.pasaporte,gp.Correo,sr.corberturaViajePaciente,sr.corbeturaViajeAcompanante, sr.observacion  \n  from so_control_remisiones sr\nleft join so_control_remisiones_detalle_cita srdc on srdc.idControlRemisiones =  sr.id\nleft join so_control_remisiones_detalle_tipo_atencion controlTipoAtencion on controlTipoAtencion.idControlRemision = sr.id\nleft join so_tipo_atencion tipoAtencion on tipoAtencion.id = controlTipoAtencion.idTipoAtencion\nleft join g_especialidad ge on ge.Id = srdc.idEspecialidad\nleft join g_persona gp on gp.Id = sr.idPersona\nleft join g_causaexterna gc on gc.Id=sr.idCausaExterna\nwhere sr.id ='" + idRemisions + "' and srdc.estado=1";
        ResultSet rs = this.xct.traerRs(Query);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    impresionRemision.setFecha(rs.getString(1));
                    impresionRemision.setNombreColaborador(rs.getString(2));
                    impresionRemision.setCedula(rs.getString(3));
                    impresionRemision.setDireccion(rs.getString(4));
                    impresionRemision.setTelefono(rs.getString(5));
                    impresionRemision.setNoConsecutivo(rs.getString(6));
                    impresionRemision.setDireccionCita(rs.getString(7));
                    impresionRemision.setTelefonoCita(rs.getString(8));
                    impresionRemision.setFechaCita(rs.getString(9));
                    impresionRemision.setNombreEspecialista(rs.getString(10));
                    impresionRemision.setEspecialidadRequerida(rs.getString(11));
                    impresionRemision.setHospedaje(rs.getString(12));
                    impresionRemision.setDireccionHospedaje(rs.getString(13));
                    impresionRemision.setCausaDeLaRemision(rs.getString(14));
                    impresionRemision.setPacienteTrasnporteAereo(rs.getString(15));
                    impresionRemision.setMotivoTransporteAereoPaciente(rs.getString(16));
                    impresionRemision.setRequiereAcompanante(rs.getString(17));
                    impresionRemision.setMotivoAcompanante(rs.getString(18));
                    impresionRemision.setTransporteAeroAcompanante(rs.getString(19));
                    impresionRemision.setMotivoTranspoteAereoAcompanante(rs.getString(20));
                    impresionRemision.setNombreAcompanante(rs.getString(21));
                    impresionRemision.setFechaCitas(rs.getString(22));
                    impresionRemision.setHoraCitas(rs.getString(23));
                    impresionRemision.setBarrioHospedaje(rs.getString(24));
                    impresionRemision.setFechaNacimientoColaborador(rs.getString(26));
                    impresionRemision.setClasificacionEmpleado(rs.getString(27));
                    impresionRemision.setCodigoEmpleado(rs.getString(28));
                    impresionRemision.setPasaporte(rs.getString(29));
                    impresionRemision.setCorreoElectronicoEmpl(rs.getString(30));
                    impresionRemision.setCorbeturaViajeEmpleado(rs.getString(31));
                    impresionRemision.setCorbeturaViajeAcompanante(rs.getString(32));
                    impresionRemision.setObservacion(rs.getString(33));
                    System.out.println(impresionRemision.getNombreColaborador());
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
        generarPdf(impresionRemision, idRemisions);
    }

    private void mCargarCombo() {
        this.especilidad = this.xICargarComboControlRemisiones.cargarComboEspecializacionRequerida();
        this.JCBEspecialidadRequerida.removeAllItems();
        for (int i = 0; i < this.especilidad.size(); i++) {
            this.JCBEspecialidadRequerida.addItem(this.especilidad.get(i).getNombre());
        }
        this.causaExterna = this.xICargarComboControlRemisiones.cargarComboCausaExterna();
        this.JCBCausaExterna.removeAllItems();
        for (int i2 = 0; i2 < this.causaExterna.size(); i2++) {
            this.JCBCausaExterna.addItem(this.causaExterna.get(i2).getNombre());
        }
        this.JCBCausaExterna.setSelectedIndex(-1);
        this.JCBEspecialidadRequerida.setSelectedIndex(-1);
        this.profesiionalCOmbo = this.xICargarComboControlRemisiones.cargarComboProfesional();
        this.JCBProfesionalQueAutoriza.removeAllItems();
        for (int i3 = 0; i3 < this.profesiionalCOmbo.size(); i3++) {
            this.JCBProfesionalQueAutoriza.addItem(this.profesiionalCOmbo.get(i3).getNombre());
        }
        this.JCBProfesionalQueAutoriza.setSelectedIndex(-1);
        this.JCBEspecialidadRequerida.setSelectedIndex(-1);
    }

    private void limpiarDatosCitaMedica() {
        this.JTFDireccion.setText("");
        this.JTFTelefonoCita1.setText("");
        this.JTFNombreEspecialista.setText("");
        this.JCBEspecialidadRequerida.setSelectedIndex(-1);
        this.JTFHoraCita.setText("12:00");
        this.JTFNombreInstitucion.setText("");
        this.JCBCiudad.setSelectedIndex(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTipoAtencion() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"ID", "Tipo Atención", "Estado"}) { // from class: Salud_Ocupacional.JIFControlDeRemisiones.3
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla_combo = new JTable(this.xmodelo) { // from class: Salud_Ocupacional.JIFControlDeRemisiones.4
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 3 && row < JIFControlDeRemisiones.this.tabla_combo.getRowCount()) {
                    return (TableCellEditor) JIFControlDeRemisiones.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        this.tabla_combo.setFont(new Font("Arial", 1, 12));
        this.tabla_combo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JSPDDatosCitaMedica1.getViewport().add(this.tabla_combo);
    }

    private void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFDireccion.setText("");
        this.JTFTelefonoCita1.setText("");
        this.JTFNombreEspecialista.setText("");
        this.JCBEspecialidadRequerida.setSelectedIndex(-1);
        this.JTFHoraCita.setText("");
        mCrearModeloDetalleCita();
        this.JCBCausaExterna.setSelectedIndex(-1);
        this.jRCasaFamilia1.setSelected(false);
        this.jRHotel1.setSelected(false);
        this.JTFBarrio.setText("");
        mCrearModeloDatosTipoAtencion();
        this.JCBProfesionalQueAutoriza.setSelectedIndex(-1);
        this.jRTrasnporteAereoPNO.setSelected(true);
        this.jRTRequiereAcompananteNO.setSelected(true);
        this.jRTrasnporteAereoACno.setSelected(true);
        this.f20jTNombreAcompaante.setText("");
        this.jTMotivoTransporteAereoP.setText("");
        this.f19jTMotivoDeAcompaante.setText("");
        this.jTMotivoTransporteAereoAC.setText("");
        mCargarDatosTabla();
        this.xjppersona.nuevo();
        this.idRemisionBiometrica = 0;
        this.JTFCodEmpleado.setText("");
        this.buttonGroup1.clearSelection();
        this.buttonGroup6.clearSelection();
        this.buttonGroup7.clearSelection();
        this.jTextObservacion.setText("");
        this.JTFBarrio.setText("");
        this.JTFDireccionHospedaje.setText("");
        this.jRTipoEmpleado.setSelected(false);
        this.jRTipoConvensionado.setSelected(false);
        this.direccionCita = "";
        this.filtroCodEmpleado = false;
        this.JTFEPS.setText("");
    }

    private void datosBase(String nArchivo, String rutaOrigen, int pagina, InformacionDeRemisionDTO impresionRemision) throws DocumentException {
        try {
            reader = new PdfReader(rutaOrigen);
            stamper = new PdfStamper(reader, new FileOutputStream(this.xmt.getRutaRep() + nArchivo + ".pdf"));
            bf = BaseFont.createFont("Helvetica-Bold", "Cp1252", false);
            over = stamper.getOverContent(pagina);
            over.beginText();
            over.setFontAndSize(bf, 8.0f);
            campo("X", 610, 780);
            campo(impresionRemision.getFecha(), 20, 78);
            campo(impresionRemision.getNombreColaborador(), 130, 81);
            campo(impresionRemision.getFechaNacimientoColaborador(), 367, 81);
            campo(impresionRemision.getCodigoEmpleado(), 535, 81);
            campo(impresionRemision.getCedula(), 20, 103);
            campo(impresionRemision.getDireccion(), 130, 103);
            campo(impresionRemision.getTelefono(), 349, 103);
            campo("N° " + impresionRemision.getNoConsecutivo(), 540, 97);
            if (impresionRemision.getClasificacionEmpleado().equals("0")) {
                campo("X", 85, 115);
            } else if (impresionRemision.getClasificacionEmpleado().equals("1")) {
                campo("X", 85, 125);
            }
            campo(impresionRemision.getCorreoElectronicoEmpl(), 217, 119);
            campo(impresionRemision.getDireccionCita(), 19, 157);
            campo(impresionRemision.getTelefonoCita(), 235, 157);
            campo(impresionRemision.getNombreEspecialista(), 350, 157);
            campo(impresionRemision.getEspecialidadRequerida(), 20, 195);
            if (impresionRemision.getHospedaje().equals("0")) {
                campo("X", 150, 231);
            } else if (impresionRemision.getHospedaje().equals("1")) {
                campo("X", 507, 231);
            }
            campo(impresionRemision.getBarrioHospedaje(), 262, 232);
            if (impresionRemision.getCausaDeLaRemision().equals("13")) {
                campo("X", 106, 266);
            }
            if (impresionRemision.getCausaDeLaRemision().equals("2")) {
                campo("X", 291, 266);
            }
            if (impresionRemision.getCausaDeLaRemision().equals("1")) {
                campo("X", 539, 266);
            }
            if (impresionRemision.getPacienteTrasnporteAereo().equals("1")) {
                campo("X", 145, 335);
            } else if (impresionRemision.getPacienteTrasnporteAereo().equals("0")) {
                campo("X", 145, 349);
            }
            if (impresionRemision.getCorbeturaViajeEmpleado().equals("0")) {
                campo("Ida", 161, 340);
            } else if (impresionRemision.getCorbeturaViajeEmpleado().equals("1")) {
                campo("Ida-Regreso", 161, 335);
            } else if (impresionRemision.getCorbeturaViajeEmpleado().equals("2")) {
                campo("Regreso", 161, 335);
            }
            if (impresionRemision.getRequiereAcompanante().equals("1")) {
                campo("X", 145, 358);
            } else if (impresionRemision.getRequiereAcompanante().equals("0")) {
                campo("X", 144, 371);
            }
            campo(impresionRemision.getMotivoTransporteAereoPaciente(), 235, 347);
            campo(impresionRemision.getMotivoAcompanante(), 235, 371);
            if (impresionRemision.getTransporteAeroAcompanante().equals("1")) {
                campo("X", 214, 388);
            } else if (impresionRemision.getTransporteAeroAcompanante().equals("0")) {
                campo("X", 261, 388);
            }
            if (impresionRemision.getCorbeturaViajeAcompanante().equals("0")) {
                campo("Ida", 274, 388);
            } else if (impresionRemision.getCorbeturaViajeAcompanante().equals("1")) {
                campo("Ida-Regreso", 274, 388);
            } else if (impresionRemision.getCorbeturaViajeAcompanante().equals("2")) {
                campo("Regreso", 274, 388);
            }
            campo(impresionRemision.getFechaCitas(), 19, 411);
            campo(impresionRemision.getHoraCitas(), 19, 431);
            campo(impresionRemision.getObservacion(), 20, 664);
            campo(impresionRemision.getNombreAcompanante(), 447, 388);
            try {
                String Queryx = "select scrdta.idTipoAtencion  from so_control_remisiones scr \ninner join so_control_remisiones_detalle_tipo_atencion scrdta on scrdta.idControlRemision = scr.id\nwhere  scr.id ='" + impresionRemision.getNoConsecutivo() + "'";
                ResultSet rs = this.xct.traerRs(Queryx);
                try {
                    if (rs.next()) {
                        rs.beforeFirst();
                        while (rs.next()) {
                            String idTipoDeAtencion = rs.getString(1);
                            switch (idTipoDeAtencion) {
                                case "1":
                                    campo("X", 112, 299);
                                    break;
                                case "2":
                                    campo("X", 291, 298);
                                    break;
                                case "3":
                                    campo("X", 441, 299);
                                    break;
                                case "4":
                                    campo("X", 573, 298);
                                    break;
                                case "5":
                                    campo("X", 111, 321);
                                    break;
                                case "6":
                                    campo("X", 308, 319);
                                    break;
                            }
                        }
                    }
                    rs.close();
                    this.xct.cerrarConexionBd();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
            }
            String Query = "select sr.firmaColaborador,gp.DireccionF  from so_control_remisiones sr \ninner join g_profesional gp on gp.id = sr.idProfesiona \nwhere sr.id ='" + impresionRemision.getNoConsecutivo() + "'";
            String firmaNombre = "";
            ResultSet rs2 = this.xct.traerRs(Query);
            try {
                if (rs2.next()) {
                    rs2.beforeFirst();
                    while (rs2.next()) {
                        try {
                            rs2.getBlob(1);
                        } catch (Exception e3) {
                            System.out.println("Error al recupear firma profesional");
                        }
                        try {
                            firmaNombre = rs2.getString(2);
                        } catch (Exception e4) {
                            System.out.println("Error al recupear la firma del profesional");
                        }
                        System.out.println(impresionRemision.getNombreColaborador());
                    }
                }
                rs2.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e5) {
                System.out.println(e5);
            }
            try {
                String rutaFirma = this.xct.traerDato("SELECT pst.Ubiacion FROM `p_s_rutas_soportes` pst\nWHERE pst.NFormulario='SUBREPORTFIRMA_DIR'");
                Image image = Image.getInstance(rutaFirma + firmaNombre);
                image.scaleAbsolute(165.0f, 29.0f);
                image.setAbsolutePosition(390.0f, 353.0f);
                over.addImage(image);
            } catch (Exception e6) {
                System.out.println("ERROR: " + e6);
            }
            over.endText();
        } catch (IOException ex) {
            Logger.getLogger(GeneracionFichaTomaMuestraCovid19_Nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void datosBasicos1(String idRemisionz) throws DocumentException, IOException {
        over = stamper.getOverContent(2);
        over.beginText();
        over.setFontAndSize(bf, 8.0f);
        String Query = "select sr.firmaColaborador  from so_control_remisiones sr \ninner join g_profesional gp on gp.id = sr.idProfesiona \nwhere sr.id ='" + idRemisionz + "'";
        Blob aBlob = null;
        ResultSet rs = this.xct.traerRs(Query);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    aBlob = rs.getBlob(1);
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
        try {
            System.out.println(aBlob.getBinaryStream());
            InputStream is = aBlob.getBinaryStream(1L, aBlob.length());
            BufferedImage image = ImageIO.read(is);
            Image Image = Image.getInstance(image, (Color) null);
            System.out.println("x");
            Image.setAbsolutePosition(20.0f, 403.0f);
            Image.scaleAbsolute(165.0f, 24.0f);
            over.addImage(Image);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    private void LlenarCasillas(String xtexto, int cont, int x, int y) {
    }

    private static void campo(String xtexto, int x, int y) {
        int valY = 780 - y;
        over.setTextMatrix(x, valY);
        over.showText(xtexto);
    }

    private static void mostrarPdf(String rutaa) {
        File archivo = new File(rutaa);
        if (archivo.exists()) {
            try {
                Desktop d = Desktop.getDesktop();
                d.open(archivo);
            } catch (IOException ex) {
                Logger.getLogger(GeneracionFichaTomaMuestraCovid19_Nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    public void generarPdf(InformacionDeRemisionDTO impresionRemision, String xidRemision) throws DocumentException {
        File archivo = new File(this.xmt.getRutaRep() + "Formato_Remisiones_Medicas_Mineros.pdf");
        if (impresionRemision != null && archivo != null) {
            try {
                datosBase("new_RemisionesMedicas", this.xmt.getRutaRep() + "Formato_Remisiones_Medicas_Mineros.pdf", 1, impresionRemision);
                datosBasicos1(xidRemision);
                stamper.close();
                mostrarPdf(this.xmt.getRutaRep() + "new_RemisionesMedicas.pdf");
            } catch (DocumentException | IOException e) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v275, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v289, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v94, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.buttonGroup4 = new ButtonGroup();
        this.buttonGroup5 = new ButtonGroup();
        this.buttonGroup6 = new ButtonGroup();
        this.buttonGroup7 = new ButtonGroup();
        this.jRPasaporteNO = new JRadioButton();
        this.LblPasaporte = new JLabel();
        this.jRPasaporteSI = new JRadioButton();
        this.buttonGroup8 = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.jPanel1 = new JPanel();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel7 = new JPanel();
        this.jPanel2 = new JPanel();
        this.JTFDireccion = new JTextField();
        this.JTFTelefonoCita1 = new JTextField();
        this.JTFNombreEspecialista = new JTextField();
        this.JCBEspecialidadRequerida = new JComboBox<>();
        this.JSPDDatosCitaMedica = new JScrollPane();
        this.JTBDatosCitaMedica = new JTable();
        this.JBAgregarCargoTablaBS1 = new JButton();
        this.JTFHoraCita = new JTextField();
        this.jDateChooser1 = new JDateChooser();
        this.JBEliminarR = new JButton();
        this.JCBCiudad = new JComboBox<>();
        this.JTFNombreInstitucion = new JTextField();
        this.JTFEPS = new JTextField();
        this.jPanel4 = new JPanel();
        this.jRCasaFamilia1 = new JRadioButton();
        this.jRHotel1 = new JRadioButton();
        this.JTFBarrio = new JTextField();
        this.JTFDireccionHospedaje = new JTextField();
        this.jRNoAplica = new JRadioButton();
        this.JTPDatos = new JTabbedPane();
        this.JPITipoAtencion = new JPanel();
        this.JSPDDatosCitaMedica1 = new JScrollPane();
        this.JTBTipoAtencion = new JTable();
        this.jPanel3 = new JPanel();
        this.jPanel6 = new JPanel();
        this.jRTrasnporteAereoPSi = new JRadioButton();
        this.jRTrasnporteAereoPNO = new JRadioButton();
        this.jPanel16 = new JPanel();
        this.jRIdaPaciente = new JRadioButton();
        this.jRIdaYRegresoPaciente = new JRadioButton();
        this.jRRegresoPaciente = new JRadioButton();
        this.jPanel8 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTMotivoTransporteAereoP = new JTextArea();
        this.jPanel9 = new JPanel();
        this.jRTRequiereAcompananteSI = new JRadioButton();
        this.jRTRequiereAcompananteNO = new JRadioButton();
        this.jLabel1 = new JLabel();
        this.f20jTNombreAcompaante = new JTextField();
        this.jPanel10 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.f19jTMotivoDeAcompaante = new JTextArea();
        this.jPanel11 = new JPanel();
        this.jRTrasnporteAereoACsi = new JRadioButton();
        this.jRTrasnporteAereoACno = new JRadioButton();
        this.jPanel15 = new JPanel();
        this.jRIdaAcompanante = new JRadioButton();
        this.jRIdaYRegresoAcompanante = new JRadioButton();
        this.jRRegresoAcompanante = new JRadioButton();
        this.jPanel12 = new JPanel();
        this.jScrollPane3 = new JScrollPane();
        this.jTMotivoTransporteAereoAC = new JTextArea();
        this.jRNoAplicaPaciente = new JRadioButton();
        this.f18jRNoAplicaAcompaante = new JRadioButton();
        this.jPanel14 = new JPanel();
        this.jTextObservacion = new JTextField();
        this.jPanel5 = new JPanel();
        this.JCBCausaExterna = new JComboBox<>();
        this.JCBProfesionalQueAutoriza = new JComboBox<>();
        this.JSPDiasPorFuera = new JSpinner();
        this.jPanel13 = new JPanel();
        this.JSPHistoricoRemisiones = new JScrollPane();
        this.JTBHistoricoRemisiones = new JTable();
        this.jPanel17 = new JPanel();
        this.JSPExportarRemision = new JScrollPane();
        this.JTBExportarRemision = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JDFFechaF = new JDateChooser();
        this.JDFFechaI = new JDateChooser();
        this.JTFCodEmpleado = new JTextField();
        this.jRTipoEmpleado = new JRadioButton();
        this.jRTipoConvensionado = new JRadioButton();
        this.jButton1 = new JButton();
        this.JBTHuella = new JButton();
        this.NUEVO = new JButton();
        this.jRPasaporteNO.setText("NO");
        this.LblPasaporte.setFont(new Font("Segoe UI", 1, 12));
        this.LblPasaporte.setForeground(new Color(255, 51, 51));
        this.LblPasaporte.setText("PASAPORTE");
        this.jRPasaporteSI.setText("SI");
        setClosable(true);
        setIconifiable(true);
        setTitle("CONTROL DE REMISIONES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifcontrolderemisiones");
        addInternalFrameListener(new InternalFrameListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.5
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFControlDeRemisiones.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 172, 32767));
        this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.jTabbedPane1.setForeground(new Color(0, 51, 255));
        this.jTabbedPane1.setFont(new Font("Segoe UI", 1, 12));
        this.jTabbedPane1.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.6
            public void mouseClicked(MouseEvent evt) {
                JIFControlDeRemisiones.this.jTabbedPane1MouseClicked(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CITA MEDICA", 2, 0, new Font("Segoe UI", 1, 12), new Color(255, 0, 51)));
        this.JTFDireccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Segoe UI", 1, 12), Color.blue));
        this.JTFDireccion.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.7
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JTFDireccionActionPerformed(evt);
            }
        });
        this.JTFTelefonoCita1.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 0, 0, new Font("Segoe UI", 1, 12), Color.blue));
        this.JTFNombreEspecialista.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Especialista", 0, 0, new Font("Segoe UI", 1, 12), Color.blue));
        this.JCBEspecialidadRequerida.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialización Med Requerida", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidadRequerida.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.8
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JCBEspecialidadRequeridaActionPerformed(evt);
            }
        });
        this.JSPDDatosCitaMedica.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPDDatosCitaMedica.setFont(new Font("Arial", 1, 12));
        this.JTBDatosCitaMedica.setFont(new Font("Arial", 1, 12));
        this.JTBDatosCitaMedica.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDatosCitaMedica.setRowHeight(25);
        this.JTBDatosCitaMedica.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDatosCitaMedica.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDatosCitaMedica.setSelectionMode(0);
        this.JTBDatosCitaMedica.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.9
            public void mouseClicked(MouseEvent evt) {
                JIFControlDeRemisiones.this.JTBDatosCitaMedicaMouseClicked(evt);
            }
        });
        this.JTBDatosCitaMedica.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.10
            public void keyReleased(KeyEvent evt) {
                JIFControlDeRemisiones.this.JTBDatosCitaMedicaKeyReleased(evt);
            }
        });
        this.JSPDDatosCitaMedica.setViewportView(this.JTBDatosCitaMedica);
        this.JBAgregarCargoTablaBS1.setFont(new Font("Arial", 1, 12));
        this.JBAgregarCargoTablaBS1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBAgregarCargoTablaBS1.setToolTipText("Grabar");
        this.JBAgregarCargoTablaBS1.setLabel("Agregar");
        this.JBAgregarCargoTablaBS1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.11
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JBAgregarCargoTablaBS1ActionPerformed(evt);
            }
        });
        this.JTFHoraCita.setText("12:00");
        this.JTFHoraCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Segoe UI", 1, 12), Color.blue));
        this.JTFHoraCita.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.12
            public void keyPressed(KeyEvent evt) {
                JIFControlDeRemisiones.this.JTFHoraCitaKeyPressed(evt);
            }
        });
        this.jDateChooser1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.jDateChooser1.setDateFormatString("dd/MM/yyyy");
        this.JBEliminarR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/equiz rojo.png")));
        this.JBEliminarR.setText("Eliminar");
        this.JBEliminarR.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.13
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JBEliminarRActionPerformed(evt);
            }
        });
        this.JCBCiudad.setModel(new DefaultComboBoxModel(new String[]{"Seleccione...", "MEDELLIN", "CAUCASIA", "MONTERÍA", "OTRO"}));
        this.JCBCiudad.addItemListener(new ItemListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.14
            public void itemStateChanged(ItemEvent evt) {
                JIFControlDeRemisiones.this.JCBCiudadItemStateChanged(evt);
            }
        });
        this.JCBCiudad.addPropertyChangeListener(new PropertyChangeListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFControlDeRemisiones.this.JCBCiudadPropertyChange(evt);
            }
        });
        this.JTFNombreInstitucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Institución", 0, 0, new Font("Segoe UI", 1, 12), Color.blue));
        this.JTFEPS.setBorder(BorderFactory.createTitledBorder((Border) null, "E.P.S", 0, 0, new Font("Segoe UI", 1, 12), Color.blue));
        this.JTFEPS.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.16
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JTFEPSActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDDatosCitaMedica).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFDireccion).addComponent(this.JCBCiudad, -2, 219, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombreInstitucion, -1, 227, 32767).addComponent(this.JTFTelefonoCita1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFHoraCita, -2, 134, -2).addGap(18, 18, 18).addComponent(this.jDateChooser1, -2, 208, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAgregarCargoTablaBS1, -1, 275, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFNombreEspecialista, -2, 252, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidadRequerida, -2, 226, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEPS)))))).addGroup(jPanel2Layout.createSequentialGroup().addGap(478, 478, 478).addComponent(this.JBEliminarR, -2, 117, -2))).addContainerGap(34, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.JCBCiudad).addGap(15, 15, 15).addComponent(this.JTFDireccion, -2, 42, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidadRequerida, -2, 42, -2).addComponent(this.JTFNombreEspecialista, -2, 42, -2).addComponent(this.JTFNombreInstitucion, -2, 42, -2).addComponent(this.JTFEPS, -2, 42, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTFTelefonoCita1, -2, 42, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JTFHoraCita, -2, 42, -2)).addComponent(this.jDateChooser1, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JBAgregarCargoTablaBS1, -2, 49, -2)))))).addGap(16, 16, 16).addComponent(this.JSPDDatosCitaMedica, -2, 188, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBEliminarR).addContainerGap(-1, 32767)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "HOSPEDAJE", 2, 0, new Font("Segoe UI", 1, 12), new Color(255, 0, 51)));
        this.buttonGroup1.add(this.jRCasaFamilia1);
        this.jRCasaFamilia1.setText("Casa de Familia");
        this.jRCasaFamilia1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.17
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRCasaFamilia1ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.jRHotel1);
        this.jRHotel1.setText("Hotel");
        this.jRHotel1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.18
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRHotel1ActionPerformed(evt);
            }
        });
        this.JTFBarrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Barrio", 0, 0, new Font("Segoe UI", 1, 12), Color.blue));
        this.JTFDireccionHospedaje.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirección", 0, 0, new Font("Segoe UI", 1, 12), Color.blue));
        this.JTFDireccionHospedaje.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.19
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JTFDireccionHospedajeActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.jRNoAplica);
        this.jRNoAplica.setText("No Aplica");
        this.jRNoAplica.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.20
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRNoAplicaActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRCasaFamilia1).addComponent(this.jRNoAplica).addComponent(this.jRHotel1)).addGap(34, 34, 34).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFDireccionHospedaje, -1, 229, 32767).addComponent(this.JTFBarrio)).addGap(18, 29, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JTFDireccionHospedaje, -2, 39, -2).addGap(7, 7, 7).addComponent(this.JTFBarrio, -2, 39, -2).addContainerGap(-1, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jRCasaFamilia1).addGap(0, 3, 32767).addComponent(this.jRHotel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRNoAplica).addGap(12, 12, 12)))));
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDDatosCitaMedica1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPDDatosCitaMedica1.setFont(new Font("Arial", 1, 12));
        this.JTBTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JTBTipoAtencion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBTipoAtencion.setRowHeight(25);
        this.JTBTipoAtencion.setSelectionBackground(new Color(255, 255, 255));
        this.JTBTipoAtencion.setSelectionForeground(new Color(255, 0, 0));
        this.JTBTipoAtencion.setSelectionMode(0);
        this.JTBTipoAtencion.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.21
            public void mouseClicked(MouseEvent evt) {
                JIFControlDeRemisiones.this.JTBTipoAtencionMouseClicked(evt);
            }
        });
        this.JSPDDatosCitaMedica1.setViewportView(this.JTBTipoAtencion);
        GroupLayout JPITipoAtencionLayout = new GroupLayout(this.JPITipoAtencion);
        this.JPITipoAtencion.setLayout(JPITipoAtencionLayout);
        JPITipoAtencionLayout.setHorizontalGroup(JPITipoAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDDatosCitaMedica1, -2, 1206, -2).addContainerGap(-1, 32767)));
        JPITipoAtencionLayout.setVerticalGroup(JPITipoAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDDatosCitaMedica1, -2, 145, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("TIPO ATENCIÓN", this.JPITipoAtencion);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "El paciente requiere de transporte aéreo?", 0, 0, new Font("Arial", 1, 13), new Color(0, 0, 255)));
        this.buttonGroup2.add(this.jRTrasnporteAereoPSi);
        this.jRTrasnporteAereoPSi.setText("Sí");
        this.jRTrasnporteAereoPSi.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.22
            public void mouseClicked(MouseEvent evt) {
                JIFControlDeRemisiones.this.jRTrasnporteAereoPSiMouseClicked(evt);
            }
        });
        this.jRTrasnporteAereoPSi.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.23
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRTrasnporteAereoPSiActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.jRTrasnporteAereoPNO);
        this.jRTrasnporteAereoPNO.setSelected(true);
        this.jRTrasnporteAereoPNO.setText("NO");
        this.jRTrasnporteAereoPNO.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.24
            public void mouseClicked(MouseEvent evt) {
                JIFControlDeRemisiones.this.jRTrasnporteAereoPNOMouseClicked(evt);
            }
        });
        this.jRTrasnporteAereoPNO.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.25
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRTrasnporteAereoPNOActionPerformed(evt);
            }
        });
        this.jPanel16.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        this.buttonGroup6.add(this.jRIdaPaciente);
        this.jRIdaPaciente.setText("Ida");
        this.jRIdaPaciente.setEnabled(false);
        this.buttonGroup6.add(this.jRIdaYRegresoPaciente);
        this.jRIdaYRegresoPaciente.setText("Ida y regreso");
        this.jRIdaYRegresoPaciente.setEnabled(false);
        this.buttonGroup6.add(this.jRRegresoPaciente);
        this.jRRegresoPaciente.setText("Regreso");
        this.jRRegresoPaciente.setEnabled(false);
        GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
        this.jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jRIdaPaciente).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRIdaYRegresoPaciente).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRRegresoPaciente).addContainerGap()));
        jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRRegresoPaciente).addComponent(this.jRIdaYRegresoPaciente).addComponent(this.jRIdaPaciente)).addGap(0, 12, 32767)));
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jRTrasnporteAereoPSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRTrasnporteAereoPNO).addContainerGap(-1, 32767)).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addContainerGap(103, 32767).addComponent(this.jPanel16, -2, -1, -2).addContainerGap())));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRTrasnporteAereoPSi).addComponent(this.jRTrasnporteAereoPNO)).addContainerGap(-1, 32767)).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel16, -2, -1, -2).addContainerGap(-1, 32767))));
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "Cual es el motivo para que el transporte sea aéreo:", 0, 0, new Font("Arial", 1, 13), new Color(0, 0, 255)));
        this.jTMotivoTransporteAereoP.setColumns(20);
        this.jTMotivoTransporteAereoP.setRows(5);
        this.jTMotivoTransporteAereoP.setEnabled(false);
        this.jScrollPane1.setViewportView(this.jTMotivoTransporteAereoP);
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 370, 32767));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, -1, -2).addGap(0, 0, 32767)));
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "El paciente requiere de acompañante?", 0, 0, new Font("Arial", 1, 13), new Color(0, 0, 255)));
        this.buttonGroup3.add(this.jRTRequiereAcompananteSI);
        this.jRTRequiereAcompananteSI.setText("Sí");
        this.jRTRequiereAcompananteSI.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.26
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRTRequiereAcompananteSIActionPerformed(evt);
            }
        });
        this.buttonGroup3.add(this.jRTRequiereAcompananteNO);
        this.jRTRequiereAcompananteNO.setSelected(true);
        this.jRTRequiereAcompananteNO.setText("NO");
        this.jRTRequiereAcompananteNO.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.27
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRTRequiereAcompananteNOActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(Color.red);
        this.jLabel1.setText("Nombres:");
        this.f20jTNombreAcompaante.setEnabled(false);
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(this.jRTRequiereAcompananteSI).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRTRequiereAcompananteNO).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.f20jTNombreAcompaante, -2, 226, -2).addContainerGap(-1, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.f20jTNombreAcompaante, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRTRequiereAcompananteSI).addComponent(this.jRTRequiereAcompananteNO)).addGap(0, 0, 32767)).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        this.jPanel10.setBorder(BorderFactory.createTitledBorder((Border) null, "Cual es el motivo para necesitar acompañante", 0, 0, new Font("Arial", 1, 13), new Color(0, 0, 255)));
        this.f19jTMotivoDeAcompaante.setColumns(20);
        this.f19jTMotivoDeAcompaante.setRows(5);
        this.f19jTMotivoDeAcompaante.setEnabled(false);
        this.jScrollPane2.setViewportView(this.f19jTMotivoDeAcompaante);
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jScrollPane2).addContainerGap()));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, -1, -2).addGap(0, 0, 32767)));
        this.jPanel11.setBorder(BorderFactory.createTitledBorder((Border) null, "El acompañante requiere de transporte aéreo?", 0, 0, new Font("Arial", 1, 13), new Color(0, 0, 255)));
        this.buttonGroup4.add(this.jRTrasnporteAereoACsi);
        this.jRTrasnporteAereoACsi.setText("Sí");
        this.jRTrasnporteAereoACsi.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.28
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRTrasnporteAereoACsiActionPerformed(evt);
            }
        });
        this.buttonGroup4.add(this.jRTrasnporteAereoACno);
        this.jRTrasnporteAereoACno.setSelected(true);
        this.jRTrasnporteAereoACno.setText("NO");
        this.jRTrasnporteAereoACno.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.29
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jRTrasnporteAereoACnoActionPerformed(evt);
            }
        });
        this.jPanel15.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        this.jPanel15.setEnabled(false);
        this.buttonGroup7.add(this.jRIdaAcompanante);
        this.jRIdaAcompanante.setText("Ida");
        this.jRIdaAcompanante.setEnabled(false);
        this.buttonGroup7.add(this.jRIdaYRegresoAcompanante);
        this.jRIdaYRegresoAcompanante.setText("Ida y regreso");
        this.jRIdaYRegresoAcompanante.setEnabled(false);
        this.buttonGroup7.add(this.jRRegresoAcompanante);
        this.jRRegresoAcompanante.setText("Regreso");
        this.jRRegresoAcompanante.setEnabled(false);
        GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
        this.jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jRIdaAcompanante).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRIdaYRegresoAcompanante).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRRegresoAcompanante).addContainerGap()));
        jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRRegresoAcompanante).addComponent(this.jRIdaYRegresoAcompanante).addComponent(this.jRIdaAcompanante)).addGap(0, 0, 32767)));
        GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
        this.jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addComponent(this.jRTrasnporteAereoACsi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRTrasnporteAereoACno).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel15, -2, -1, -2).addGap(31, 31, 31)));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel15, -2, -1, -2).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRTrasnporteAereoACsi).addComponent(this.jRTrasnporteAereoACno))).addContainerGap()));
        this.jPanel12.setBorder(BorderFactory.createTitledBorder((Border) null, "Cual es el motivo para que el transporte sea aéreo:", 0, 0, new Font("Arial", 1, 13), new Color(0, 0, 255)));
        this.jTMotivoTransporteAereoAC.setColumns(20);
        this.jTMotivoTransporteAereoAC.setRows(5);
        this.jTMotivoTransporteAereoAC.setEnabled(false);
        this.jScrollPane3.setViewportView(this.jTMotivoTransporteAereoAC);
        GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
        this.jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, GroupLayout.Alignment.TRAILING));
        jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3));
        this.buttonGroup6.add(this.jRNoAplicaPaciente);
        this.jRNoAplicaPaciente.setEnabled(false);
        this.buttonGroup7.add(this.f18jRNoAplicaAcompaante);
        this.f18jRNoAplicaAcompaante.setText("Regreso");
        this.f18jRNoAplicaAcompaante.setEnabled(false);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel8, -1, -1, 32767).addComponent(this.jPanel6, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel9, -1, -1, 32767).addComponent(this.jPanel10, -1, -1, 32767))).addComponent(this.jRNoAplicaPaciente)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.f18jRNoAplicaAcompaante)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel11, -2, 393, -2).addComponent(this.jPanel12, -1, -1, 32767))).addGap(31, 31, 31)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -2, 0, 32767).addComponent(this.jPanel9, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel11, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel10, -1, -1, 32767).addComponent(this.jPanel8, -1, -1, 32767).addComponent(this.jPanel12, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRNoAplicaPaciente).addComponent(this.f18jRNoAplicaAcompaante)).addGap(152, 152, 152)));
        this.jPanel10.getAccessibleContext().setAccessibleName("Cual es el motivo para necesitar acompañante?");
        this.jPanel10.getAccessibleContext().setAccessibleDescription("");
        this.JTPDatos.addTab("TIPO DE TRANSPORTE Y ACOMPAÑAMIENTO", this.jPanel3);
        this.jTextObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Segoe UI", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
        this.jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addContainerGap().addComponent(this.jTextObservacion, -2, 1183, -2).addContainerGap(-1, 32767)));
        jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.jTextObservacion, -2, 57, -2).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("OBSERVACIÓN", this.jPanel14);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "CAUSA DE LA REMISIÓN", 2, 0, new Font("Segoe UI", 1, 12), new Color(255, 0, 51)));
        this.JCBCausaExterna.setBorder(BorderFactory.createTitledBorder((Border) null, "---", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCausaExterna.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.30
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JCBCausaExternaActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBCausaExterna, 0, 568, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBCausaExterna, -1, 36, 32767).addGap(4, 4, 4)));
        this.JCBProfesionalQueAutoriza.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Autoriza", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProfesionalQueAutoriza.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.31
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JCBProfesionalQueAutorizaActionPerformed(evt);
            }
        });
        this.JSPDiasPorFuera.setFont(new Font("Segoe UI", 1, 12));
        this.JSPDiasPorFuera.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAS POR FUERA", 0, 0, new Font("Segoe UI", 1, 12), Color.red));
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -2, -1, -2).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.JCBProfesionalQueAutoriza, -2, 299, -2).addGap(18, 18, 18).addComponent(this.JSPDiasPorFuera, -2, 121, -2)))).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2)).addComponent(this.JTPDatos, -2, 1258, -2)).addContainerGap(-1, 32767)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -2, -1, -2).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.jPanel5, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProfesionalQueAutoriza, -2, 45, -2).addComponent(this.JSPDiasPorFuera, -2, -1, -2)))).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("REMISIÓN", this.jPanel7);
        this.JSPHistoricoRemisiones.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPHistoricoRemisiones.setFont(new Font("Arial", 1, 12));
        this.JTBHistoricoRemisiones.setFont(new Font("Arial", 1, 12));
        this.JTBHistoricoRemisiones.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistoricoRemisiones.setRowHeight(25);
        this.JTBHistoricoRemisiones.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistoricoRemisiones.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistoricoRemisiones.setSelectionMode(0);
        this.JTBHistoricoRemisiones.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.32
            /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
            public void mouseClicked(MouseEvent evt) throws DocumentException {
                JIFControlDeRemisiones.this.JTBHistoricoRemisionesMouseClicked(evt);
            }
        });
        this.JSPHistoricoRemisiones.setViewportView(this.JTBHistoricoRemisiones);
        GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
        this.jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JSPHistoricoRemisiones, -1, 1240, 32767).addGap(12, 12, 12)));
        jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoRemisiones, -1, 780, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel13);
        this.JSPExportarRemision.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPExportarRemision.setFont(new Font("Arial", 1, 12));
        this.JTBExportarRemision.setFont(new Font("Arial", 1, 12));
        this.JTBExportarRemision.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBExportarRemision.setRowHeight(25);
        this.JTBExportarRemision.setSelectionBackground(new Color(255, 255, 255));
        this.JTBExportarRemision.setSelectionForeground(new Color(255, 0, 0));
        this.JTBExportarRemision.setSelectionMode(0);
        this.JTBExportarRemision.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.33
            public void mouseClicked(MouseEvent evt) {
                JIFControlDeRemisiones.this.JTBExportarRemisionMouseClicked(evt);
            }
        });
        this.JSPExportarRemision.setViewportView(this.JTBExportarRemision);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.34
            public void mouseClicked(MouseEvent evt) {
                JIFControlDeRemisiones.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.35
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.36
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFControlDeRemisiones.this.JDFFechaFPropertyChange(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.37
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFControlDeRemisiones.this.JDFFechaIPropertyChange(evt);
            }
        });
        GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
        this.jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 660, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaI, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JDFFechaF, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 238, -2).addContainerGap(70, 32767)).addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JSPExportarRemision, -2, 1203, -2).addContainerGap(-1, 32767))));
        jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addContainerGap().addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 47, -2).addComponent(this.JDFFechaF, -2, 47, -2)).addComponent(this.JTFRuta, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup().addComponent(this.JBTExportar, -2, 52, -2).addGap(2, 2, 2))).addContainerGap(732, 32767)).addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup().addGap(69, 69, 69).addComponent(this.JSPExportarRemision, -1, 717, 32767).addContainerGap())));
        this.jTabbedPane1.addTab("EXPORTAR", this.jPanel17);
        this.JTFCodEmpleado.setBorder(BorderFactory.createTitledBorder((Border) null, "CÓDIGO EMP", 0, 0, new Font("Segoe UI", 1, 12), new Color(255, 51, 51)));
        this.JTFCodEmpleado.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.38
            public void keyPressed(KeyEvent evt) {
                JIFControlDeRemisiones.this.JTFCodEmpleadoKeyPressed(evt);
            }
        });
        this.buttonGroup8.add(this.jRTipoEmpleado);
        this.jRTipoEmpleado.setText("Empleado");
        this.buttonGroup8.add(this.jRTipoConvensionado);
        this.jRTipoConvensionado.setText("Convencionado");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFCodEmpleado, -2, 180, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jRTipoEmpleado).addComponent(this.jRTipoConvensionado)))).addContainerGap(12, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jRTipoEmpleado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRTipoConvensionado)).addComponent(this.JTFCodEmpleado)).addGap(7, 7, 7).addComponent(this.jTabbedPane1).addGap(18, 18, 18)));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton1.setText("GUARDAR REMISIÓN");
        this.jButton1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.39
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.jButton1ActionPerformed(evt);
            }
        });
        this.JBTHuella.setFont(new Font("Arial", 1, 12));
        this.JBTHuella.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBTHuella.setToolTipText("Registro Biometrico");
        this.JBTHuella.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.40
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.JBTHuellaActionPerformed(evt);
            }
        });
        this.NUEVO.setIcon(new ImageIcon(getClass().getResource("/Imagenes/devolver.png")));
        this.NUEVO.setText("NUEVO");
        this.NUEVO.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.41
            public void actionPerformed(ActionEvent evt) {
                JIFControlDeRemisiones.this.NUEVOActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIFDatosUsuario, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton1, -2, 327, -2).addGap(18, 18, 18).addComponent(this.NUEVO, -2, 264, -2).addGap(18, 18, 18).addComponent(this.JBTHuella, -2, 106, -2).addGap(498, 498, 498))).addContainerGap(-1, 32767)).addComponent(this.jPanel1, -1, -1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTHuella, -2, 75, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 77, -2).addComponent(this.NUEVO, -2, 75, -2))).addContainerGap(-1, 32767)));
        pack();
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.42
            public void mouseClicked(MouseEvent e) {
                JIFControlDeRemisiones.this.JTDetalleMouseClicked(e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadRequeridaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosCitaMedicaMouseClicked(MouseEvent evt) {
        Object idRemision;
        if (evt.getClickCount() == 2) {
            this.idRCita = 0;
            int filaSeleccionada = this.JTBDatosCitaMedica.getSelectedRow();
            if (filaSeleccionada != -1 && (idRemision = this.JTBDatosCitaMedica.getValueAt(filaSeleccionada, 0)) != null) {
                Integer.valueOf(Integer.parseInt(idRemision.toString()));
                DefaultTableModel miTableModel = this.JTBDatosCitaMedica.getModel();
                subirRegistroDetalleCita();
                if (filaSeleccionada >= 0) {
                    this.idRCita = Integer.parseInt(this.JTBDatosCitaMedica.getValueAt(filaSeleccionada, 0).toString());
                    System.out.println("id r cita - " + this.idRCita);
                    miTableModel.removeRow(filaSeleccionada);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAgregarCargoTablaBS1ActionPerformed(ActionEvent evt) {
        if (!this.JTFDireccion.getText().isEmpty() && this.JTFDireccion.getText() != null) {
            if (!this.JTFNombreInstitucion.getText().isEmpty() && this.JTFNombreInstitucion.getText() != null) {
                if (this.JCBEspecialidadRequerida.getSelectedIndex() > -1) {
                    if (this.jDateChooser1.getDate() != null) {
                        if (!this.JTFHoraCita.getText().isEmpty() && this.JTFHoraCita.getText() != null && validarFormatoHora(this.JTFHoraCita.getText())) {
                            AgregarDetalle();
                            return;
                        } else {
                            JOptionPane.showMessageDialog(this, "La hora de la cita no puede estar vacia o tiene un formato incorrecto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFHoraCita.requestFocus();
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Seleccione una fecha", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.jDateChooser1.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Seleccione una especialización medica", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEspecialidadRequerida.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "La Institución de destino no puede estar vacia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombreInstitucion.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "La dirección de destino no puede estar vacia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFDireccion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCausaExternaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTipoAtencionMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRTrasnporteAereoPSiActionPerformed(ActionEvent evt) {
        if (this.jRTrasnporteAereoPSi.isSelected()) {
            this.jTMotivoTransporteAereoP.setEnabled(false);
            this.jPanel16.setEnabled(true);
            this.jRIdaPaciente.setEnabled(true);
            this.jRIdaYRegresoPaciente.setEnabled(true);
            this.jRRegresoPaciente.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRTrasnporteAereoPNOActionPerformed(ActionEvent evt) {
        if (this.jRTrasnporteAereoPNO.isSelected()) {
            this.jRNoAplicaPaciente.setSelected(true);
            this.jPanel16.setEnabled(false);
            this.jRIdaPaciente.setEnabled(false);
            this.jRIdaYRegresoPaciente.setEnabled(false);
            this.jRRegresoPaciente.setEnabled(false);
            this.jTMotivoTransporteAereoP.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRTRequiereAcompananteSIActionPerformed(ActionEvent evt) {
        if (this.jRTRequiereAcompananteSI.isSelected()) {
            this.f19jTMotivoDeAcompaante.setEnabled(true);
            this.f20jTNombreAcompaante.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRTRequiereAcompananteNOActionPerformed(ActionEvent evt) {
        if (this.jRTRequiereAcompananteNO.isSelected()) {
            this.f19jTMotivoDeAcompaante.setEnabled(false);
            this.f20jTNombreAcompaante.setEnabled(false);
            this.f20jTNombreAcompaante.setText("");
            this.f19jTMotivoDeAcompaante.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRTrasnporteAereoACsiActionPerformed(ActionEvent evt) {
        if (this.jRTrasnporteAereoACsi.isSelected()) {
            this.jTMotivoTransporteAereoAC.setEnabled(true);
            this.jPanel15.setEnabled(true);
            this.jRIdaAcompanante.setEnabled(true);
            this.jRIdaYRegresoAcompanante.setEnabled(true);
            this.jRRegresoAcompanante.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRTrasnporteAereoACnoActionPerformed(ActionEvent evt) {
        if (this.jRTrasnporteAereoACno.isSelected()) {
            this.jTMotivoTransporteAereoAC.setEnabled(false);
            this.jPanel15.setEnabled(false);
            this.f18jRNoAplicaAcompaante.setSelected(true);
            this.jRIdaAcompanante.setEnabled(false);
            this.jRIdaYRegresoAcompanante.setEnabled(false);
            this.jRRegresoAcompanante.setEnabled(false);
            this.jTMotivoTransporteAereoAC.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRTrasnporteAereoPSiMouseClicked(MouseEvent evt) {
        if (this.jRTrasnporteAereoPSi.isSelected()) {
            this.jTMotivoTransporteAereoP.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRTrasnporteAereoPNOMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        int x = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea guardar la remisión? ", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            mGrabarRemision();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBEliminarRActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            retirarDetalle();
        }
        DefaultTableModel miTableModel = this.JTBDatosCitaMedica.getModel();
        if (miTableModel.getRowCount() > 0) {
            miTableModel.removeRow(this.JTBDatosCitaMedica.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDatosCitaMedicaKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRCasaFamilia1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRHotel1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProfesionalQueAutorizaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.itextpdf.text.DocumentException */
    public void JTBHistoricoRemisionesMouseClicked(MouseEvent evt) throws DocumentException {
        if (this.JTBHistoricoRemisiones.getSelectedColumn() == 6) {
            String idRemisionx = this.xmodeloHistorico.getValueAt(this.JTBHistoricoRemisiones.getSelectedRow(), 0).toString();
            System.out.println("");
            mCargarDatosImpresion(idRemisionx);
        }
        if (this.JTBHistoricoRemisiones.getSelectedColumn() == 7) {
            getName();
            int idRemision1 = Integer.valueOf(this.xmodeloHistorico.getValueAt(this.JTBHistoricoRemisiones.getSelectedRow(), 0).toString()).intValue();
            if (idRemision1 > 0) {
                JDBiometrico xjdBiometrico = new JDBiometrico(null, true, getName(), String.valueOf(idRemision1));
                xjdBiometrico.setTemplate(null);
                xjdBiometrico.setVisible(true);
            }
        }
        if (this.JTBHistoricoRemisiones.getSelectedColumn() == 8) {
            int idRemisionn = Integer.valueOf(this.xmodeloHistorico.getValueAt(this.JTBHistoricoRemisiones.getSelectedRow(), 0).toString()).intValue();
            System.out.println("id remision -> " + idRemisionn);
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro que desea eliminar la remisión? ", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                inabilitarRemision(Integer.valueOf(idRemisionn));
            }
        }
        if (this.JTBHistoricoRemisiones.getSelectedColumn() == 9) {
            mNuevo();
            Principal.txtNo.setText(this.xmodeloHistorico.getValueAt(this.JTBHistoricoRemisiones.getSelectedRow(), 0).toString());
            this.jTabbedPane1.setSelectedIndex(0);
            cargarDatosA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jTabbedPane1MouseClicked(MouseEvent evt) {
        mCargarDatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NUEVOActionPerformed(ActionEvent evt) {
        int x = JOptionPane.showConfirmDialog(this, "Esta seguro que desea crear una nueva remisión? ", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            mNuevo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHuellaActionPerformed(ActionEvent evt) {
        getName();
        if (this.idRemisionBiometrica.intValue() > 0) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, getName(), String.valueOf(this.idRemisionBiometrica));
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
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
            if (this.JTBExportarRemision.getRowCount() > -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    DefaultTableModel model = this.JTBExportarRemision.getModel();
                    DefaultTableModel newModel = new DefaultTableModel();
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        newModel.addColumn(model.getColumnName(i));
                    }
                    for (int i2 = 0; i2 < model.getRowCount(); i2++) {
                        Object[] row = new Object[model.getColumnCount()];
                        for (int j = 0; j < model.getColumnCount(); j++) {
                            row[j] = model.getValueAt(i2, j);
                        }
                        newModel.addRow(row);
                    }
                    JTable exportTable = new JTable(newModel);
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(exportTable, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBExportarRemisionMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaFPropertyChange(PropertyChangeEvent evt) {
        Date fechaFinal = this.JDFFechaF.getDate();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        if (this.JDFFechaF.getDate() != null) {
            String fechaFormateada = formatoFecha.format(fechaFinal);
            this.fechaF = fechaFormateada;
            try {
                mCargarDatosExportar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFFechaIPropertyChange(PropertyChangeEvent evt) {
        Date fechaInicial = this.JDFFechaI.getDate();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        if (this.JDFFechaI.getDate() != null) {
            String fechaFormateada = formatoFecha.format(fechaInicial);
            this.fechaI = fechaFormateada;
            try {
                mCargarDatosExportar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDireccionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCiudadPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCiudadItemStateChanged(ItemEvent evt) {
        if (this.JCBCiudad.getSelectedIndex() > 0) {
            this.JTFDireccion.setText(this.JCBCiudad.getSelectedItem().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFHoraCitaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRNoAplicaActionPerformed(ActionEvent evt) {
        this.jTextObservacion.setText("No requiere hospedaje. ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodEmpleadoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.filtroCodEmpleado = true;
            mCargarDatosHistorico();
            this.jTabbedPane1.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFDireccionHospedajeActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFEPSActionPerformed(ActionEvent evt) {
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    private void mCargarDatosTabla() {
        this.list = null;
        this.list = this.xControlRemisionesServicioDAO.listarTipoAtencionServicio();
        mCrearModeloDatosTipoAtencion();
        if (this.list.size() > 0) {
            for (int x = 0; x < this.list.size(); x++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.list.get(x)[0], x, 0);
                this.xmodelo.setValueAt(this.list.get(x)[1], x, 1);
                this.xmodelo.setValueAt(this.list.get(x)[2], x, 2);
            }
        }
    }

    private void mCargarDatosExportar() {
        System.out.println("fechaInicial -> " + this.fechaI);
        System.out.println("fechaFinal -> " + this.fechaF);
        String xsql = "SELECT\n  sr.Id AS idRemision,\n  CONCAT(gp.Nombre1, ' ', gp.Nombre2, ' ',  gp.Apellido1,  ' ',  gp.Apellido2 ) Empleado,\n  gp.NoDocumento,\n    gps.`Nbre` especialidad,\n  crdc.`nombreInstitucion` nombreInstitucion, \n  sr.fechaRegistro Fecha,\n  sr.`direccion` ciudadDestino,\n  gc.`Nbre` causaExterna,\n  ta.`Nbre` tipoDeAtencion,\n  if(sr.`transporteAereo` = 1,'SI','NO') trasporteAereo,\n  sr.`motivoTransporteAereo` motivoTrasporteAereo,\n  if(sr.`acompanante` = 1, 'SI', 'NO') acompanante,\n  sr.`nombreAcompanante` nombreAcompanante,\n  sr.`motivoAcompanante` motivoAcompanate,\n  if(sr.`AcompananteTransporteAereo` = 1, 'SI', 'NO') acompananteTransporteAereo,\n  sr.`motivoTransporteAereoAcomp` motivoTransporteAereoAcompañante\n    ,crdc.`id` idDetalle     ,crdc.`fechaCita`,\n  crdc.`horaCita`, sr.diasPorFueraPaciente, sr.EpsRemision   \nFROM\n  so_control_remisiones sr\n  LEFT JOIN g_persona gp\n    ON gp.Id = sr.idPersona\n  LEFT JOIN g_causaexterna gc\n    ON gc.Id = sr.idCausaExterna\n  INNER JOIN `baseserver`.`so_control_remisiones_detalle_cita` crdc\n    ON (\n      crdc.`idControlRemisiones` = sr.`id`\n    )\n  INNER JOIN `baseserver`.`so_control_remisiones_detalle_tipo_atencion` crdta\n    ON (\n      crdta.`idControlRemision` = sr.`id`\n    )\n    inner join `g_especialidad` gps\n    on(gps.`Id`=crdc.`idEspecialidad`)\n    inner join `so_tipo_atencion` ta\n    on(ta.`id`=crdta.`idTipoAtencion`)\n\nWHERE sr.estado = 1 AND sr.`fecha`>= '" + this.fechaI + "' AND sr.`fecha` <= '" + this.fechaF + "' and sr.estado=1\n  GROUP BY idDetalle order by sr.fechaRegistro desc";
        System.out.println("consulta que trae el historico a exportar -> " + xsql);
        mCrearModeloExportar();
        ResultSet rs = this.xct.traerRs(xsql);
        if ((this.fechaI.isEmpty() || this.fechaI == null) && (this.fechaF.isEmpty() || this.fechaF == null)) {
            System.out.println("inicial ");
            return;
        }
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodeloExportar.addRow(this.xdatosExportar);
                    this.xmodeloExportar.setValueAt(rs.getString(1), x, 0);
                    this.xmodeloExportar.setValueAt(rs.getString(2), x, 1);
                    this.xmodeloExportar.setValueAt(rs.getString(3), x, 2);
                    this.xmodeloExportar.setValueAt(rs.getString(4), x, 3);
                    this.xmodeloExportar.setValueAt(rs.getString(5), x, 4);
                    this.xmodeloExportar.setValueAt(rs.getString(6), x, 5);
                    this.xmodeloExportar.setValueAt(rs.getString(7), x, 6);
                    this.xmodeloExportar.setValueAt(rs.getString(8), x, 7);
                    this.xmodeloExportar.setValueAt(rs.getString(9), x, 8);
                    this.xmodeloExportar.setValueAt(rs.getString(10), x, 9);
                    this.xmodeloExportar.setValueAt(rs.getString(11), x, 10);
                    this.xmodeloExportar.setValueAt(rs.getString(12), x, 11);
                    this.xmodeloExportar.setValueAt(rs.getString(13), x, 12);
                    this.xmodeloExportar.setValueAt(rs.getString(14), x, 13);
                    this.xmodeloExportar.setValueAt(rs.getString(15), x, 14);
                    this.xmodeloExportar.setValueAt(rs.getString(16), x, 15);
                    this.xmodeloExportar.setValueAt(rs.getString(17), x, 16);
                    this.xmodeloExportar.setValueAt(rs.getString(18), x, 17);
                    this.xmodeloExportar.setValueAt(rs.getString(19), x, 18);
                    this.xmodeloExportar.setValueAt(rs.getString(20), x, 19);
                    this.xmodeloExportar.setValueAt(rs.getString(21), x, 20);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloExportar() {
        this.xmodeloExportar = new DefaultTableModel(new Object[0], new String[]{"No. Remisión", "Empleado", "No. Documento", "Especialidad", "Institución", "Fecha", "Ciudad de destino", "Causa externa", "Tipo de atención", "Transporte aereo", "Motivo", "¿Requiere acompañante?", "Nombre del acompañante", "Motivo", "¿Requiere transporte aereo?", "Motivo del transporte aereo", "idDetalle", "Fecha Cita", "Hora Cita", "Dias por fuera", "EPS"}) { // from class: Salud_Ocupacional.JIFControlDeRemisiones.43
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBExportarRemision.setModel(this.xmodeloExportar);
        JTable jTable = this.JTBExportarRemision;
        JTable jTable2 = this.JTBExportarRemision;
        jTable.setAutoResizeMode(0);
        this.JTBExportarRemision.doLayout();
        this.JTBExportarRemision.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBExportarRemision.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBExportarRemision.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBExportarRemision.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBExportarRemision.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBExportarRemision.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTBExportarRemision.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTBExportarRemision.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTBExportarRemision.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTBExportarRemision.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTBExportarRemision.getColumnModel().getColumn(10).setPreferredWidth(150);
        this.JTBExportarRemision.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTBExportarRemision.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTBExportarRemision.getColumnModel().getColumn(13).setPreferredWidth(200);
        this.JTBExportarRemision.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTBExportarRemision.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTBExportarRemision.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBExportarRemision.getColumnModel().getColumn(17).setPreferredWidth(80);
        this.JTBExportarRemision.getColumnModel().getColumn(18).setPreferredWidth(80);
        this.JTBExportarRemision.getColumnModel().getColumn(19).setPreferredWidth(80);
        this.JTBExportarRemision.getColumnModel().getColumn(20).setPreferredWidth(80);
    }

    private void limitarCaracteres() {
        this.JTFHoraCita.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFControlDeRemisiones.44
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c) || c == ':') {
                    if (JIFControlDeRemisiones.this.JTFHoraCita.getText().length() == 2) {
                        JIFControlDeRemisiones.this.JTFHoraCita.setText(JIFControlDeRemisiones.this.JTFHoraCita.getText() + ":");
                        return;
                    } else {
                        if (JIFControlDeRemisiones.this.JTFHoraCita.getText().length() >= 5 || (JIFControlDeRemisiones.this.JTFHoraCita.getText().length() == 3 && c == ':')) {
                            e.consume();
                            return;
                        }
                        return;
                    }
                }
                e.consume();
            }
        });
    }

    private boolean validarFormatoHora(String hora) {
        return hora.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

    private void inabilitarRemision(Integer idRemision) {
        String sql = "SELECT \ncrdc.`id` idDetalleCita\n,`crdta`.`id` idTipoAtencion\nFROM `so_control_remisiones` cr \nINNER JOIN `so_control_remisiones_detalle_cita`  crdc ON (cr.`id`=crdc.idControlRemisiones)\nINNER JOIN `so_control_remisiones_detalle_tipo_atencion` crdta ON (cr.`id`=crdta.`idControlRemision`)\nWHERE cr.`id`= '" + idRemision + "'";
        System.out.println("consultar detalle cita y tipo de atencion -> " + sql);
        ResultSet rs = this.xct.traerRs(sql);
        while (rs.next()) {
            try {
                int idDetalleCita = rs.getInt("idDetalleCita");
                int idTipoAtencion = rs.getInt("idTipoAtencion");
                String sqlInhabilitarDetalleCita = "UPDATE so_control_remisiones_detalle_cita SET estado = 0 WHERE id = " + idDetalleCita + " AND idControlRemisiones = " + idRemision;
                System.out.println("inhabilitar detalle cita -> " + sqlInhabilitarDetalleCita);
                this.xct.ejecutarSQL(sqlInhabilitarDetalleCita);
                String sqlInhabilitarTipoAtencion = "UPDATE so_control_remisiones_detalle_tipo_atencion SET estado = 0 WHERE id = " + idTipoAtencion + " AND idControlRemision = " + idRemision;
                System.out.println("inhabilitar tipo atencion -> " + sqlInhabilitarTipoAtencion);
                this.xct.ejecutarSQL(sqlInhabilitarTipoAtencion);
            } catch (SQLException ex) {
                this.xct.mostrarErrorSQL(ex);
                return;
            }
        }
        String sqlInhabilitarRemision = "UPDATE so_control_remisiones SET estado = 0 WHERE id = " + idRemision;
        System.out.println("inhabilitar remision -> " + sqlInhabilitarRemision);
        this.xct.ejecutarSQL(sqlInhabilitarRemision);
        mCargarDatosHistorico();
        rs.close();
        this.xct.cerrarConexionBd();
    }
}
