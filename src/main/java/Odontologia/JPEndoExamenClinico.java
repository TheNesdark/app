package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPEndoExamenClinico.class */
public class JPEndoExamenClinico extends JPanel {
    private String xsql;
    private String[] x1edolor;
    private String[] x2eintensidad;
    private String[] xefrecuencia;
    private String[] x3ecaries;
    private String[] x4etipocaries;
    private String[] xfistula;
    private String[] xpulpar;
    private String[] xvitalometro;
    private String[] x5eccolor;
    private String[] x6ecolor;
    private String[] x7fverticar;
    private String[] x8fradicular;
    private String[] x9ftipo1;
    private String[] x10fhorizontal;
    private String[] x11fcoronal;
    private String[] x12fipo2;
    private String[] x13aintraoral;
    private String[] x14atipo1;
    private String[] x15aextraoral;
    private String[] x16atipo2;
    private String[] x17aretauracion;
    private String[] x18atipo;
    private String[] x19aestado;
    private String[] x20abifurcacion;
    private String[] x21atipo;
    private String[] x22afisura;
    private String[] x23aexamenpulpar;
    private String[] x24pffrio;
    private String[] x25pfcalor;
    private String[] x26pfvitalometro;
    private String[] x27pfmovilidad;
    private String[] x28pfgrado;
    private String[] x29pftestcavitario;
    private String[] x30pvertical;
    private String[] x31ptipo;
    private String[] x32pgrado;
    private String[] x33phorizontal;
    private String[] x34ptipo;
    private String[] x35pgrado;
    private String[] x36ttraumasant;
    private String[] x37thgdolocabeza;
    private String[] x38thgconciencia;
    private String[] x39thgnauseas;
    private String[] x40thiespontaneo;
    private String[] x41thifrio;
    private String[] x42thipercusion;
    private String[] x43thiexposicionpulpar;
    private String[] x44thicolorocioncorona;
    private String[] x45thimovdentaria;
    private String[] x46thimbucal;
    private String[] x47thillabial;
    private String[] x48iddiagnostico;
    private String[] x49idrespuestadx;
    private String[] x50hrformacionrad;
    private String[] x51hrfracradicular;
    private String[] x52hrlesionapical;
    private String[] x53hrcavidadpulpar;
    private String[] x54hrreabsoricionrad;
    private String[] x55hrtiporeabsorcionrad;
    private String[] x56hrmembranaperio;
    private String[] x57hralveolooseo;
    private String[] x58rseco;
    private String[] x59ragua;
    private String[] x60rsaliva;
    private String[] x61rleche;
    private String[] x62ftipodx;
    private String[] xidtipodx;
    private String[] xidservicio;
    private String[] xidprocedimiento;
    private String[] xidtipodx1;
    private String[] xtipovertical;
    private String[] xtipohorizotal;
    private String[] xnodiente;
    private String[] xidtiponota;
    private boolean xlleno;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo0;
    private DefaultTableModel xmodeloHG;
    private DefaultTableModel xmodeloHDientes;
    private DefaultTableModel xmodeloevo;
    private DefaultTableModel xmodeloNotas;
    private Object[] xdatos;
    private JButton JBGrabarNota;
    private JButton JBLimpiar;
    private JButton JBTAdicionarAntCli;
    private JButton JBTAdicionarDx;
    private JButton JBTAdicionarEvo;
    private JButton JBTGrabaEvolucion;
    private JComboBox JCBAExtraoral;
    private JComboBox JCBAIntraoral;
    private JComboBox JCBATipo;
    private JComboBox JCBATipoExtra;
    private JComboBox JCBCColor;
    private JComboBox JCBCColoracionCorona;
    private JComboBox JCBCalorPC;
    private JComboBox JCBCaries;
    private JComboBox JCBCariesTipo;
    private JComboBox JCBColor;
    private JComboBox JCBDAAgua;
    private JComboBox JCBDALeche;
    private JComboBox JCBDASaliva;
    private JComboBox JCBDASeco;
    private JComboBox JCBDDiagnostico;
    private JComboBox JCBDEspontaneo;
    private JComboBox JCBDExposicionP;
    private JComboBox JCBDFrecuencia;
    private JComboBox JCBDFrio;
    private JComboBox JCBDIntensidad;
    private JComboBox JCBDPercusion;
    private JComboBox JCBDVP;
    private JComboBox JCBDiagnostico;
    private JComboBox JCBDolor;
    private JComboBox JCBDxRespuesta;
    private JComboBox JCBEPulpar;
    private JComboBox JCBFCoronal;
    private JComboBox JCBFHorizontal;
    private JComboBox JCBFRadicular;
    private JComboBox JCBFTipo;
    private JComboBox JCBFTipoH;
    private JComboBox JCBFVertical;
    private JComboBox JCBFisura;
    private JComboBox JCBFrio;
    private JComboBox JCBHRCavidadPul;
    private JComboBox JCBHREstMembranaPerio;
    private JComboBox JCBHRFracturaAlveolo;
    private JComboBox JCBHRFracturaRadicular;
    private JComboBox JCBHRFradicular;
    private JComboBox JCBHRLesionApical;
    private JComboBox JCBHRTipoReabsRadicular;
    private JComboBox JCBHRreabsRadicular;
    private JComboBox JCBLLabial;
    private JComboBox JCBLingual;
    private JComboBox JCBMBucal;
    private JComboBox JCBMVDV;
    private JComboBox JCBMovDentaria;
    private JComboBox JCBMovGrado;
    private JComboBox JCBMovTesCav;
    private JComboBox JCBMovilidad;
    private JComboBox JCBNoDiente;
    private JComboBox JCBPGradoH;
    private JComboBox JCBPGradoV;
    private JComboBox JCBPHorizontal;
    private JComboBox JCBPMV;
    private JComboBox JCBPTipoH;
    private JComboBox JCBPTipoV;
    private JComboBox JCBPVertical;
    private JComboBox JCBRestauracion;
    public JComboBox JCBRestauracionEstado;
    private JComboBox JCBRestauracionTipo;
    private JComboBox JCBTConciencia;
    private JComboBox JCBTDolorCabeza;
    private JComboBox JCBTNauseas;
    private JComboBox JCBTipoNota;
    private JComboBox JCBTraumasAnt;
    private JComboBox JCBVestibular;
    private JComboBox JCBVitalometro;
    private JDateChooser JDCFechaEvolucion;
    private JDateChooser JDCFechaNota;
    public JDateChooser JDFFechaTrauma;
    private JPanel JPBifurcacion;
    private JPanel JPEvolucion;
    private JPanel JPHistorico;
    private JPanel JPIAbsceso;
    private JPanel JPIDDAResguardado;
    private JPanel JPIDEPrimera;

    /* JADX INFO: renamed from: JPIDHIDaño, reason: contains not printable characters */
    private JPanel f16JPIDHIDao;
    private JPanel JPIDHIDientesInv;
    private JPanel JPIDHIDolor;
    private JPanel JPIDatosCDienteAvul;
    private JPanel JPIDatosHGenerales;
    private JPanel JPIDatosHIntrahorales;
    private JPanel JPIDatosHRadirograficos;
    private JPanel JPIDiagnostico;
    private JPanel JPIDiagnosticoT;
    private JPanel JPIESegunda;
    private JPanel JPIEndExamenC;
    private JPanel JPIExRadiografico;
    private JPanel JPIExamen;
    private JPanel JPIFractura;
    private JPanel JPIPClinicas;
    private JPanel JPIPercusion;
    private JPanel JPITDatos;
    private JPanel JPITrauma;
    private JPanel JPNotas;
    private JPanel JPTrifurcacion;
    private JScrollPane JSPHistorialDx;
    private JScrollPane JSPHistoricoG;
    private JScrollPane JSPNota;
    private JScrollPane JSPNotas;
    private JScrollPane JSPObsCarie;
    private JScrollPane JSPObsColor;
    private JScrollPane JSPTDiagnostico;
    private JScrollPane JSPTEvoluciones;
    private JTextArea JTACausas;
    private JTextArea JTADRadiografica;
    private JTextArea JTADRadiografica1;
    private JTextArea JTANota;
    private JTable JTBTDiagnostico;
    private JTable JTBTEvoluciones;
    private JTable JTBTHistoricoEsp;
    private JTextField JTFAislAB;
    private JTextField JTFAislRelat;
    private JTextField JTFCamaraPulpar;
    private JTextField JTFCondEvo;
    private JTextField JTFConductos;
    private JTextField JTFConoAP;
    private JTextField JTFConom;
    private JTextField JTFCorona;
    private JTextField JTFDAFCabidadB;
    private JTextField JTFDOtros;
    private JTextField JTFDPermanentes;
    private JTextField JTFDTemporales;
    private JTextField JTFDef;
    private JTextField JTFDientesInv;
    private JTextField JTFEPulparObserv;
    private JFormattedTextField JTFFHora;
    private JTextField JTFFisuraUbicacion;
    private JTextField JTFHRForamenApical;
    private JTextField JTFLMA;
    private JTextField JTFLaminaDura;
    private JTextField JTFLima;
    private JTextField JTFLugar;
    private JTextField JTFNoGrapas;
    private JTextField JTFPElectricaV;
    private JTextField JTFPeriapice;
    private JTextField JTFRaiz;
    private JTextField JTFRaizEvo;
    private JTextField JTFRef;
    private JTextField JTFTent;
    private JTable JTHistorialDx;
    private JTable JTNotasEndo;
    private JTabbedPane JTPDatos;
    private JTabbedPane JTPEndodoncia;
    private JTabbedPane JTPHallagoz;
    private JTextArea JTPObsCalorPC;
    private JTextPane JTPObsCarie;
    private JTextPane JTPObsColor;
    private JTextArea JTPObsFrio;
    private JTextArea JTPObsGeneral;
    private JTextArea JTPObsPClinica;
    private JTextArea JTPObsRadiografico;
    private JTextArea JTPObsVitalometro;
    private JTextArea JTPPlanTratamiento;
    private JLabel NoEndo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane10;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JScrollPane jScrollPane9;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xnfilamodelo1 = 0;
    private int xnfilamodelo0 = 0;
    private int xfilamodeloevo = 0;
    private String xendodoncia = "";
    private String xtratamiento = "";
    private int xControl = 0;

    public JPEndoExamenClinico() {
        initComponents();
        mBuscarHistoricoGeneral();
        mNuevo();
        this.JBTGrabaEvolucion.setVisible(false);
        this.JBGrabarNota.setVisible(false);
        this.jScrollPane7.setVisible(false);
        this.JPBifurcacion.setVisible(false);
        this.JPTrifurcacion.setVisible(false);
        this.jScrollPane8.setVisible(false);
    }

    private void mCargarCombosParametros() {
        this.x1edolor = mllenarCombos("18", this.JCBDolor);
        this.JCBDolor.setSelectedIndex(-1);
        this.x2eintensidad = mllenarCombos("116", this.JCBDIntensidad);
        this.JCBDIntensidad.setSelectedIndex(-1);
        this.x3ecaries = mllenarCombos("15", this.JCBCaries);
        this.JCBCaries.setSelectedIndex(-1);
        this.x4etipocaries = mllenarCombos("117", this.JCBCariesTipo);
        this.JCBCariesTipo.setSelectedIndex(-1);
        this.x5eccolor = mllenarCombos("162", this.JCBCColor);
        this.JCBCColor.setSelectedIndex(-1);
        this.x6ecolor = mllenarCombos("118", this.JCBColor);
        this.JCBColor.setSelectedIndex(-1);
        this.x7fverticar = mllenarCombos("120", this.JCBFVertical);
        this.JCBFVertical.setSelectedIndex(-1);
        this.x8fradicular = mllenarCombos("122", this.JCBFRadicular);
        this.JCBFRadicular.setSelectedIndex(-1);
        this.x9ftipo1 = mllenarCombos("170", this.JCBFTipo);
        this.JCBFTipo.setSelectedIndex(-1);
        this.x10fhorizontal = mllenarCombos("121", this.JCBFHorizontal);
        this.JCBFHorizontal.setSelectedIndex(-1);
        this.x11fcoronal = mllenarCombos("121", this.JCBFCoronal);
        this.JCBFCoronal.setSelectedIndex(-1);
        this.x12fipo2 = mllenarCombos("121", this.JCBFTipoH);
        this.JCBFTipoH.setSelectedIndex(-1);
        this.x13aintraoral = mllenarCombos("126", this.JCBAIntraoral);
        this.JCBAIntraoral.setSelectedIndex(-1);
        this.x14atipo1 = mllenarCombos("198", this.JCBATipo);
        this.JCBATipo.setSelectedIndex(-1);
        this.x15aextraoral = mllenarCombos("127", this.JCBAExtraoral);
        this.JCBAExtraoral.setSelectedIndex(-1);
        this.x16atipo2 = mllenarCombos("198", this.JCBATipoExtra);
        this.JCBATipoExtra.setSelectedIndex(-1);
        this.x17aretauracion = mllenarCombos("130", this.JCBRestauracion);
        this.JCBRestauracion.setSelectedIndex(-1);
        this.x18atipo = mllenarCombos("217", this.JCBRestauracionTipo);
        this.JCBRestauracionTipo.setSelectedIndex(-1);
        this.x19aestado = mllenarCombos("131", this.JCBRestauracionEstado);
        this.JCBRestauracionEstado.setSelectedIndex(-1);
        this.xefrecuencia = mllenarCombos("119", this.JCBDFrecuencia);
        this.JCBDFrecuencia.setSelectedIndex(-1);
        this.xfistula = mllenarCombos("124", this.JCBFisura);
        this.JCBFisura.setSelectedIndex(-1);
        this.xpulpar = mllenarCombos("129", this.JCBEPulpar);
        this.JCBEPulpar.setSelectedIndex(-1);
        this.x24pffrio = mllenarCombos("135", this.JCBFrio);
        this.JCBFrio.setSelectedIndex(-1);
        this.x25pfcalor = mllenarCombos("136", this.JCBCalorPC);
        this.JCBCalorPC.setSelectedIndex(-1);
        this.x27pfmovilidad = mllenarCombos("139", this.JCBMovilidad);
        this.JCBMovilidad.setSelectedIndex(-1);
        this.x28pfgrado = mllenarCombos("140", this.JCBMovGrado);
        this.JCBMovGrado.setSelectedIndex(-1);
        this.x29pftestcavitario = mllenarCombos("141", this.JCBMovTesCav);
        this.JCBMovTesCav.setSelectedIndex(-1);
        this.x30pvertical = mllenarCombos("120", this.JCBPVertical);
        this.JCBPVertical.setSelectedIndex(-1);
        this.x32pgrado = mllenarCombos("140", this.JCBPGradoV);
        this.JCBPGradoV.setSelectedIndex(-1);
        this.x33phorizontal = mllenarCombos("121", this.JCBPHorizontal);
        this.JCBPHorizontal.setSelectedIndex(-1);
        this.x35pgrado = mllenarCombos("140", this.JCBPGradoH);
        this.JCBPGradoH.setSelectedIndex(-1);
        this.x36ttraumasant = mllenarCombos("148", this.JCBTraumasAnt);
        this.JCBTraumasAnt.setSelectedIndex(-1);
        this.x37thgdolocabeza = mllenarCombos("154", this.JCBTDolorCabeza);
        this.JCBTDolorCabeza.setSelectedIndex(-1);
        this.x38thgconciencia = mllenarCombos("155", this.JCBTConciencia);
        this.JCBTConciencia.setSelectedIndex(-1);
        this.x39thgnauseas = mllenarCombos("156", this.JCBTNauseas);
        this.JCBTNauseas.setSelectedIndex(-1);
        this.x40thiespontaneo = mllenarCombos("159", this.JCBDEspontaneo);
        this.JCBDEspontaneo.setSelectedIndex(-1);
        this.x41thifrio = mllenarCombos("135", this.JCBDFrio);
        this.JCBDFrio.setSelectedIndex(-1);
        this.x42thipercusion = mllenarCombos("160", this.JCBDPercusion);
        this.JCBDPercusion.setSelectedIndex(-1);
        this.x43thiexposicionpulpar = mllenarCombos("161", this.JCBDExposicionP);
        this.JCBDExposicionP.setSelectedIndex(-1);
        this.x44thicolorocioncorona = mllenarCombos("162", this.JCBCColoracionCorona);
        this.JCBCColoracionCorona.setSelectedIndex(-1);
        this.x45thimovdentaria = mllenarCombos("103", this.JCBMovDentaria);
        this.JCBMovDentaria.setSelectedIndex(-1);
        this.x46thimbucal = mllenarCombos("163", this.JCBMBucal);
        this.JCBMBucal.setSelectedIndex(-1);
        this.x47thillabial = mllenarCombos("164", this.JCBLLabial);
        this.JCBLLabial.setSelectedIndex(-1);
        this.x50hrformacionrad = mllenarCombos("179", this.JCBHRFradicular);
        this.JCBHRFradicular.setSelectedIndex(-1);
        this.x51hrfracradicular = mllenarCombos("168", this.JCBHRFracturaRadicular);
        this.JCBHRFracturaRadicular.setSelectedIndex(-1);
        this.x52hrlesionapical = mllenarCombos("57", this.JCBHRLesionApical);
        this.JCBHRLesionApical.setSelectedIndex(-1);
        this.x53hrcavidadpulpar = mllenarCombos("185", this.JCBHRCavidadPul);
        this.JCBHRCavidadPul.setSelectedIndex(-1);
        this.x54hrreabsoricionrad = mllenarCombos("187", this.JCBHRreabsRadicular);
        this.JCBHRreabsRadicular.setSelectedIndex(-1);
        this.x55hrtiporeabsorcionrad = mllenarCombos("170", this.JCBHRTipoReabsRadicular);
        this.JCBHRTipoReabsRadicular.setSelectedIndex(-1);
        this.x56hrmembranaperio = mllenarCombos("171", this.JCBHREstMembranaPerio);
        this.JCBHREstMembranaPerio.setSelectedIndex(-1);
        this.x57hralveolooseo = mllenarCombos("172", this.JCBHRFracturaAlveolo);
        this.JCBHRFracturaAlveolo.setSelectedIndex(-1);
        this.x58rseco = mllenarCombos("174", this.JCBDASeco);
        this.JCBDASeco.setSelectedIndex(-1);
        this.x59ragua = mllenarCombos("175", this.JCBDAAgua);
        this.JCBDAAgua.setSelectedIndex(-1);
        this.x60rsaliva = mllenarCombos("176", this.JCBDASaliva);
        this.JCBDASaliva.setSelectedIndex(-1);
        this.x61rleche = mllenarCombos("176", this.JCBDALeche);
        this.JCBDALeche.setSelectedIndex(-1);
        this.xvitalometro = mllenarCombos("214", this.JCBVitalometro);
        this.JCBVitalometro.setSelectedIndex(-1);
        this.xtipovertical = mllenarCombos("137", this.JCBPTipoV);
        this.JCBPTipoV.setSelectedIndex(-1);
        this.xtipohorizotal = mllenarCombos("138", this.JCBPTipoH);
        this.JCBPTipoH.setSelectedIndex(-1);
        this.xsql = "SELECT `Id` , `Nbre` FROM `o_odontograma_diente` WHERE (`Adulto` =0) ORDER BY Nbre;";
        this.xnodiente = this.xct.llenarCombo(this.xsql, this.xnodiente, this.JCBNoDiente);
        this.JCBNoDiente.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
    }

    private String[] mllenarCombos(String xv, JComboBox xcombo) {
        this.xsql = "SELECT o_tipo_contenido_descripcion.Id, o_tipo_parametros.Nbre FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_contenido_descripcion.Id ='" + xv + "' AND o_tipo_descripcionxparametro.Estado =1) ORDER BY o_tipo_parametros.Nbre ASC, o_tipo_descripcionxparametro.NOrden ASC ";
        String[] xvalor = this.xct.llenarCombo(this.xsql, null, xcombo);
        this.xct.cerrarConexionBd();
        return xvalor;
    }

    private void mCargarCombos() {
        this.xlleno = false;
        this.JCBDxRespuesta.removeAllItems();
        this.JCBDiagnostico.removeAllItems();
        this.xsql = "SELECT o_tipo_contenido_descripcion.Id, o_tipo_contenido_descripcion.Nbre FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_contenido_descripcion  ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_contenido_descripcion.EsDx =1 AND o_tipo_descripcionxparametro.Estado =1) GROUP BY o_tipo_contenido_descripcion.Id ORDER BY o_tipo_contenido_descripcion.Nbre ASC ";
        this.x48iddiagnostico = this.xct.llenarCombo(this.xsql, this.x48iddiagnostico, this.JCBDiagnostico);
        this.JCBDiagnostico.setSelectedIndex(-1);
        this.xsql = "SELECT Id, Nbre FROM o_tipo_diagnostico WHERE (EsFractura =1 AND Estado =1) ORDER BY Nbre ASC";
        this.x62ftipodx = this.xct.llenarCombo(this.xsql, this.x62ftipodx, this.JCBDDiagnostico);
        this.JCBDDiagnostico.setSelectedIndex(-1);
        this.xsql = "SELECT `h_tiponota`.`Id` , `h_tiponota`.`Nbre` FROM `h_tiponota_especialidad` INNER JOIN  `h_tiponota`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_tiponota_especialidad`.`Id_Especialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `h_tiponota_especialidad`.`Estado` =1) ORDER BY `h_tiponota`.`Nbre` ASC ";
        this.xidtiponota = this.xct.llenarCombo(this.xsql, this.xidtiponota, this.JCBTipoNota);
        this.JCBTipoNota.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    public void mNuevo() {
        mCargarCombosParametros();
        mCargarCombos();
        mCrearTablaDiagnostico();
        mCrearTablaDxTrauma();
        mCrearTablaEvoluciones();
        this.JDFFechaTrauma.setDate(this.xmt.getFechaActual());
        this.JDCFechaNota.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setValue(this.xmt.getFechaActual());
        this.JDCFechaEvolucion.setDate(this.xmt.getFechaActual());
    }

    private long mVerificaDienteGuardado() {
        long existe = 0;
        String sql = "SELECT `o_endodoncia`.`Id` , `o_endodoncia`.`NoDiente` FROM `o_endodoncia`  INNER JOIN `baseserver`.`o_hc_tratamiento`   ON (`o_endodoncia`.`IdTratamiento` = `o_hc_tratamiento`.`Id`)  WHERE (`o_endodoncia`.`Id` ='" + this.NoEndo.getText() + "' AND `o_endodoncia`.`NoDiente`='" + this.JCBNoDiente.getSelectedItem() + "');";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                existe = 1;
                this.JBTGrabaEvolucion.setVisible(true);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEndoExamenClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existe;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaEvoluciones() {
        this.xmodeloevo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "No.Diente", "Raiz", "COND", "C. TENT", "1° LIMA", "C.DEF", "REF", "LMA", "CONOM", "CONO AP", "AISL. ABSOL", "AISL. RELAT", "Est"}) { // from class: Odontologia.JPEndoExamenClinico.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBTEvoluciones.setModel(this.xmodeloevo);
        this.JTBTEvoluciones.getColumnModel().getColumn(0).setPreferredWidth(35);
        this.JTBTEvoluciones.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(11).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTBTEvoluciones.getColumnModel().getColumn(13).setPreferredWidth(2);
        this.xfilamodeloevo = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDiagnostico() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Diagnóstico", "Respuesta", "IdResp", "E"}) { // from class: Odontologia.JPEndoExamenClinico.2
            Class[] types = {Long.class, String.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorialDx.setModel(this.xmodelo1);
        this.JTHistorialDx.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTHistorialDx.getColumnModel().getColumn(1).setPreferredWidth(280);
        this.JTHistorialDx.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTHistorialDx.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTHistorialDx.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTHistorialDx.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTHistorialDx.getColumnModel().getColumn(4).setPreferredWidth(1);
        this.xnfilamodelo1 = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDxTrauma() {
        this.xmodelo0 = new DefaultTableModel(new Object[0], new String[]{"Id", "Diagnóstico", "E"}) { // from class: Odontologia.JPEndoExamenClinico.3
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBTDiagnostico.setModel(this.xmodelo0);
        this.JTBTDiagnostico.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBTDiagnostico.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTBTDiagnostico.getColumnModel().getColumn(2).setPreferredWidth(2);
        this.xnfilamodelo0 = 0;
    }

    /* JADX WARN: Type inference failed for: r3v351, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v601, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v670, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v713, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v743, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPEndodoncia = new JTabbedPane();
        this.JPIEndExamenC = new JPanel();
        this.JTPDatos = new JTabbedPane();
        this.JPIDEPrimera = new JPanel();
        this.JPIExamen = new JPanel();
        this.JCBDolor = new JComboBox();
        this.JCBDIntensidad = new JComboBox();
        this.JCBDFrecuencia = new JComboBox();
        this.JCBCaries = new JComboBox();
        this.JCBCariesTipo = new JComboBox();
        this.JSPObsCarie = new JScrollPane();
        this.JTPObsCarie = new JTextPane();
        this.JCBCColor = new JComboBox();
        this.JCBColor = new JComboBox();
        this.JSPObsColor = new JScrollPane();
        this.JTPObsColor = new JTextPane();
        this.JPIFractura = new JPanel();
        this.JCBFVertical = new JComboBox();
        this.JCBFRadicular = new JComboBox();
        this.JCBFTipo = new JComboBox();
        this.JCBFHorizontal = new JComboBox();
        this.JCBFCoronal = new JComboBox();
        this.JCBFTipoH = new JComboBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTPObsGeneral = new JTextArea();
        this.JPIESegunda = new JPanel();
        this.JPIAbsceso = new JPanel();
        this.JCBAIntraoral = new JComboBox();
        this.JCBATipo = new JComboBox();
        this.JCBAExtraoral = new JComboBox();
        this.JCBATipoExtra = new JComboBox();
        this.JCBRestauracion = new JComboBox();
        this.JCBRestauracionTipo = new JComboBox();
        this.JCBRestauracionEstado = new JComboBox();
        this.JCBFisura = new JComboBox();
        this.JTFFisuraUbicacion = new JTextField();
        this.JCBEPulpar = new JComboBox();
        this.JTFEPulparObserv = new JTextField();
        this.JPBifurcacion = new JPanel();
        this.JCBLingual = new JComboBox();
        this.JCBVestibular = new JComboBox();
        this.jLabel1 = new JLabel();
        this.JPTrifurcacion = new JPanel();
        this.JCBMVDV = new JComboBox();
        this.JCBDVP = new JComboBox();
        this.jLabel2 = new JLabel();
        this.JCBPMV = new JComboBox();
        this.jScrollPane7 = new JScrollPane();
        this.JTADRadiografica = new JTextArea();
        this.jScrollPane8 = new JScrollPane();
        this.JTADRadiografica1 = new JTextArea();
        this.JPIPClinicas = new JPanel();
        this.JCBFrio = new JComboBox();
        this.JCBCalorPC = new JComboBox();
        this.JPIPercusion = new JPanel();
        this.JCBPVertical = new JComboBox();
        this.JCBPTipoV = new JComboBox();
        this.JCBPGradoV = new JComboBox();
        this.JCBPHorizontal = new JComboBox();
        this.JCBPTipoH = new JComboBox();
        this.JCBPGradoH = new JComboBox();
        this.JCBMovilidad = new JComboBox();
        this.JCBMovGrado = new JComboBox();
        this.JCBMovTesCav = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.JTPObsFrio = new JTextArea();
        this.jScrollPane3 = new JScrollPane();
        this.JTPObsCalorPC = new JTextArea();
        this.JCBVitalometro = new JComboBox();
        this.jScrollPane9 = new JScrollPane();
        this.JTPObsVitalometro = new JTextArea();
        this.jScrollPane4 = new JScrollPane();
        this.JTPObsPClinica = new JTextArea();
        this.JPIExRadiografico = new JPanel();
        this.JTFCorona = new JTextField();
        this.JTFConductos = new JTextField();
        this.JTFCamaraPulpar = new JTextField();
        this.JTFLaminaDura = new JTextField();
        this.JTFRaiz = new JTextField();
        this.JTFPeriapice = new JTextField();
        this.jScrollPane5 = new JScrollPane();
        this.JTPObsRadiografico = new JTextArea();
        this.JPIDiagnostico = new JPanel();
        this.JSPHistorialDx = new JScrollPane();
        this.JTHistorialDx = new JTable();
        this.JCBDiagnostico = new JComboBox();
        this.JCBDxRespuesta = new JComboBox();
        this.JBTAdicionarAntCli = new JButton();
        this.JPITrauma = new JPanel();
        this.JPITDatos = new JPanel();
        this.JDFFechaTrauma = new JDateChooser();
        this.JCBTraumasAnt = new JComboBox();
        this.JTFDientesInv = new JTextField();
        this.JTFLugar = new JTextField();
        this.jScrollPane10 = new JScrollPane();
        this.JTACausas = new JTextArea();
        this.JTPHallagoz = new JTabbedPane();
        this.JPIDatosHGenerales = new JPanel();
        this.JCBTDolorCabeza = new JComboBox();
        this.JCBTConciencia = new JComboBox();
        this.JCBTNauseas = new JComboBox();
        this.JPIDatosHIntrahorales = new JPanel();
        this.JPIDHIDientesInv = new JPanel();
        this.JTFDTemporales = new JTextField();
        this.JTFDPermanentes = new JTextField();
        this.JPIDHIDolor = new JPanel();
        this.JCBDEspontaneo = new JComboBox();
        this.JCBDFrio = new JComboBox();
        this.JCBDPercusion = new JComboBox();
        this.JCBDExposicionP = new JComboBox();
        this.JTFPElectricaV = new JTextField();
        this.JCBCColoracionCorona = new JComboBox();
        this.JCBMovDentaria = new JComboBox();
        this.f16JPIDHIDao = new JPanel();
        this.JCBMBucal = new JComboBox();
        this.JCBLLabial = new JComboBox();
        this.JTFDOtros = new JTextField();
        this.JPIDatosHRadirograficos = new JPanel();
        this.JCBHRFradicular = new JComboBox();
        this.JTFHRForamenApical = new JTextField();
        this.JCBHRFracturaRadicular = new JComboBox();
        this.JCBHRLesionApical = new JComboBox();
        this.JCBHRCavidadPul = new JComboBox();
        this.JCBHRreabsRadicular = new JComboBox();
        this.JCBHRTipoReabsRadicular = new JComboBox();
        this.JCBHREstMembranaPerio = new JComboBox();
        this.JCBHRFracturaAlveolo = new JComboBox();
        this.JPIDatosCDienteAvul = new JPanel();
        this.JPIDDAResguardado = new JPanel();
        this.JCBDASeco = new JComboBox();
        this.JCBDAAgua = new JComboBox();
        this.JCBDASaliva = new JComboBox();
        this.JCBDALeche = new JComboBox();
        this.JTFDAFCabidadB = new JTextField();
        this.JPIDiagnosticoT = new JPanel();
        this.JCBDDiagnostico = new JComboBox();
        this.JBTAdicionarDx = new JButton();
        this.JSPTDiagnostico = new JScrollPane();
        this.JTBTDiagnostico = new JTable();
        this.jScrollPane6 = new JScrollPane();
        this.JTPPlanTratamiento = new JTextArea();
        this.JPEvolucion = new JPanel();
        this.JDCFechaEvolucion = new JDateChooser();
        this.JTFRaizEvo = new JTextField();
        this.JTFCondEvo = new JTextField();
        this.JTFTent = new JTextField();
        this.JTFLima = new JTextField();
        this.JTFDef = new JTextField();
        this.JTFRef = new JTextField();
        this.JTFLMA = new JTextField();
        this.JTFConom = new JTextField();
        this.JTFConoAP = new JTextField();
        this.JTFAislAB = new JTextField();
        this.JTFAislRelat = new JTextField();
        this.JSPTEvoluciones = new JScrollPane();
        this.JTBTEvoluciones = new JTable();
        this.JBTAdicionarEvo = new JButton();
        this.JBTGrabaEvolucion = new JButton();
        this.JPNotas = new JPanel();
        this.JDCFechaNota = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBTipoNota = new JComboBox();
        this.JSPNota = new JScrollPane();
        this.JTANota = new JTextArea();
        this.JSPNotas = new JScrollPane();
        this.JTNotasEndo = new JTable();
        this.JBGrabarNota = new JButton();
        this.JPHistorico = new JPanel();
        this.JSPHistoricoG = new JScrollPane();
        this.JTBTHistoricoEsp = new JTable();
        this.jPanel2 = new JPanel();
        this.JCBNoDiente = new JComboBox();
        this.JTFNoGrapas = new JTextField();
        this.NoEndo = new JLabel();
        this.JBLimpiar = new JButton();
        setName("xJPEndodoncia");
        this.JTPEndodoncia.setForeground(new Color(0, 103, 0));
        this.JTPEndodoncia.setToolTipText("");
        this.JTPEndodoncia.setFont(new Font("Arial", 1, 14));
        this.JTPDatos.setForeground(Color.blue);
        this.JTPDatos.setFont(new Font("Arial", 1, 12));
        this.JPIExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBDolor.setFont(new Font("Arial", 1, 12));
        this.JCBDolor.setBorder(BorderFactory.createTitledBorder((Border) null, "Dolor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDIntensidad.setFont(new Font("Arial", 1, 12));
        this.JCBDIntensidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Intensidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDFrecuencia.setFont(new Font("Arial", 1, 12));
        this.JCBDFrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Frecuencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCaries.setFont(new Font("Arial", 1, 12));
        this.JCBCaries.setBorder(BorderFactory.createTitledBorder((Border) null, "Caries", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCariesTipo.setFont(new Font("Arial", 1, 12));
        this.JCBCariesTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Caries", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsCarie.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación Carie", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsCarie.setFont(new Font("Arial", 1, 12));
        this.JTPObsCarie.setFont(new Font("Arial", 1, 12));
        this.JSPObsCarie.setViewportView(this.JTPObsCarie);
        this.JCBCColor.setFont(new Font("Arial", 1, 12));
        this.JCBCColor.setBorder(BorderFactory.createTitledBorder((Border) null, "C. Color", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBColor.setFont(new Font("Arial", 1, 12));
        this.JCBColor.setBorder(BorderFactory.createTitledBorder((Border) null, "Color", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsColor.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación Color", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsColor.setFont(new Font("Arial", 1, 12));
        this.JSPObsColor.setViewportView(this.JTPObsColor);
        GroupLayout JPIExamenLayout = new GroupLayout(this.JPIExamen);
        this.JPIExamen.setLayout(JPIExamenLayout);
        JPIExamenLayout.setHorizontalGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBDolor, 0, 230, 32767).addComponent(this.JCBCaries, 0, -1, 32767).addComponent(this.JCBCColor, 0, -1, 32767)).addGap(10, 10, 10).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBCariesTipo, GroupLayout.Alignment.LEADING, 0, 204, 32767).addComponent(this.JCBDIntensidad, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBColor, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPObsCarie, GroupLayout.Alignment.LEADING).addComponent(this.JCBDFrecuencia, GroupLayout.Alignment.LEADING, 0, 255, 32767).addComponent(this.JSPObsColor))));
        JPIExamenLayout.setVerticalGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExamenLayout.createSequentialGroup().addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDolor, -2, 50, -2).addComponent(this.JCBDIntensidad, -2, 50, -2).addComponent(this.JCBDFrecuencia, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsCarie, 0, 0, 32767).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCaries, -2, 50, -2).addComponent(this.JCBCariesTipo, -2, 50, -2))).addGap(13, 13, 13).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObsColor, 0, 0, 32767).addGroup(JPIExamenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCColor, -2, 50, -2).addComponent(this.JCBColor, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JPIFractura.setBorder(BorderFactory.createTitledBorder((Border) null, "FRACTURA", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBFVertical.setFont(new Font("Arial", 1, 12));
        this.JCBFVertical.setBorder(BorderFactory.createTitledBorder((Border) null, "Vertical", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFRadicular.setFont(new Font("Arial", 1, 12));
        this.JCBFRadicular.setBorder(BorderFactory.createTitledBorder((Border) null, "Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFTipo.setFont(new Font("Arial", 1, 12));
        this.JCBFTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFHorizontal.setFont(new Font("Arial", 1, 12));
        this.JCBFHorizontal.setBorder(BorderFactory.createTitledBorder((Border) null, "Horizontal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFCoronal.setFont(new Font("Arial", 1, 12));
        this.JCBFCoronal.setBorder(BorderFactory.createTitledBorder((Border) null, "Coronal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFTipoH.setFont(new Font("Arial", 1, 12));
        this.JCBFTipoH.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIFracturaLayout = new GroupLayout(this.JPIFractura);
        this.JPIFractura.setLayout(JPIFracturaLayout);
        JPIFracturaLayout.setHorizontalGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFracturaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIFracturaLayout.createSequentialGroup().addComponent(this.JCBFVertical, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFRadicular, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFTipo, -2, 413, -2)).addGroup(JPIFracturaLayout.createSequentialGroup().addComponent(this.JCBFHorizontal, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFCoronal, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBFTipoH, 0, -1, 32767))).addContainerGap(-1, 32767)));
        JPIFracturaLayout.setVerticalGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFracturaLayout.createSequentialGroup().addGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFVertical, -2, -1, -2).addComponent(this.JCBFRadicular, -2, -1, -2).addComponent(this.JCBFTipo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIFracturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBFHorizontal).addComponent(this.JCBFCoronal).addComponent(this.JCBFTipoH)).addContainerGap(26, 32767)));
        this.JTPObsGeneral.setColumns(1);
        this.JTPObsGeneral.setLineWrap(true);
        this.JTPObsGeneral.setRows(1);
        this.JTPObsGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTPObsGeneral);
        GroupLayout JPIDEPrimeraLayout = new GroupLayout(this.JPIDEPrimera);
        this.JPIDEPrimera.setLayout(JPIDEPrimeraLayout);
        JPIDEPrimeraLayout.setHorizontalGroup(JPIDEPrimeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEPrimeraLayout.createSequentialGroup().addContainerGap().addGroup(JPIDEPrimeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 705, -2).addComponent(this.JPIFractura, -2, -1, -2).addComponent(this.JPIExamen, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPIDEPrimeraLayout.setVerticalGroup(JPIDEPrimeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEPrimeraLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIExamen, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFractura, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 77, -2).addGap(19, 19, 19)));
        this.JTPDatos.addTab("PRIMERA", this.JPIDEPrimera);
        this.JPIAbsceso.setBorder(BorderFactory.createTitledBorder((Border) null, "ABSCESO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBAIntraoral.setFont(new Font("Arial", 1, 12));
        this.JCBAIntraoral.setBorder(BorderFactory.createTitledBorder((Border) null, "Intraoral", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBATipo.setFont(new Font("Arial", 1, 12));
        this.JCBATipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAExtraoral.setFont(new Font("Arial", 1, 12));
        this.JCBAExtraoral.setBorder(BorderFactory.createTitledBorder((Border) null, "Extraoral", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBATipoExtra.setFont(new Font("Arial", 1, 12));
        this.JCBATipoExtra.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIAbscesoLayout = new GroupLayout(this.JPIAbsceso);
        this.JPIAbsceso.setLayout(JPIAbscesoLayout);
        JPIAbscesoLayout.setHorizontalGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAbscesoLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBAExtraoral, 0, 151, 32767).addComponent(this.JCBAIntraoral, 0, -1, 32767)).addGap(5, 5, 5).addGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBATipo, 0, -1, 32767).addComponent(this.JCBATipoExtra, -2, 166, -2)).addGap(5, 5, 5)));
        JPIAbscesoLayout.setVerticalGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAbscesoLayout.createSequentialGroup().addGroup(JPIAbscesoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIAbscesoLayout.createSequentialGroup().addComponent(this.JCBATipo, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBATipoExtra)).addGroup(GroupLayout.Alignment.LEADING, JPIAbscesoLayout.createSequentialGroup().addComponent(this.JCBAIntraoral, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBAExtraoral, -2, 50, -2))).addGap(2, 2, 2)));
        this.JCBRestauracion.setFont(new Font("Arial", 1, 12));
        this.JCBRestauracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Restauración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRestauracionTipo.setFont(new Font("Arial", 1, 12));
        this.JCBRestauracionTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRestauracionEstado.setFont(new Font("Arial", 1, 12));
        this.JCBRestauracionEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFisura.setFont(new Font("Arial", 1, 12));
        this.JCBFisura.setBorder(BorderFactory.createTitledBorder((Border) null, "Fistula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFisuraUbicacion.setFont(new Font("Arial", 1, 12));
        this.JTFFisuraUbicacion.setToolTipText("");
        this.JTFFisuraUbicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEPulpar.setFont(new Font("Arial", 1, 12));
        this.JCBEPulpar.setBorder(BorderFactory.createTitledBorder((Border) null, "Exámen Pulpar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEPulparObserv.setFont(new Font("Arial", 1, 12));
        this.JTFEPulparObserv.setToolTipText("");
        this.JTFEPulparObserv.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPBifurcacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Bifurcación", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBLingual.setFont(new Font("Arial", 1, 12));
        this.JCBLingual.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        this.JCBLingual.setSelectedIndex(-1);
        this.JCBLingual.setBorder(BorderFactory.createTitledBorder((Border) null, "Lingual", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBVestibular.setFont(new Font("Arial", 1, 12));
        this.JCBVestibular.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        this.JCBVestibular.setSelectedIndex(-1);
        this.JCBVestibular.setBorder(BorderFactory.createTitledBorder((Border) null, "Vestibular", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 255));
        this.jLabel1.setText("Grado");
        GroupLayout JPBifurcacionLayout = new GroupLayout(this.JPBifurcacion);
        this.JPBifurcacion.setLayout(JPBifurcacionLayout);
        JPBifurcacionLayout.setHorizontalGroup(JPBifurcacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPBifurcacionLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addGap(29, 29, 29).addComponent(this.JCBLingual, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBVestibular, -2, 83, -2).addContainerGap(-1, 32767)));
        JPBifurcacionLayout.setVerticalGroup(JPBifurcacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBifurcacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBLingual, -2, 50, -2).addComponent(this.JCBVestibular, -2, 50, -2)).addGroup(JPBifurcacionLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1)));
        this.JPTrifurcacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Trifurcación", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBMVDV.setFont(new Font("Arial", 1, 12));
        this.JCBMVDV.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        this.JCBMVDV.setSelectedIndex(-1);
        this.JCBMVDV.setBorder(BorderFactory.createTitledBorder((Border) null, "MV / DV", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBDVP.setFont(new Font("Arial", 1, 12));
        this.JCBDVP.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        this.JCBDVP.setSelectedIndex(-1);
        this.JCBDVP.setBorder(BorderFactory.createTitledBorder((Border) null, "DV / P", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 255));
        this.jLabel2.setText("Grado");
        this.JCBPMV.setFont(new Font("Arial", 1, 12));
        this.JCBPMV.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        this.JCBPMV.setSelectedIndex(-1);
        this.JCBPMV.setBorder(BorderFactory.createTitledBorder((Border) null, "P / MV", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPTrifurcacionLayout = new GroupLayout(this.JPTrifurcacion);
        this.JPTrifurcacion.setLayout(JPTrifurcacionLayout);
        JPTrifurcacionLayout.setHorizontalGroup(JPTrifurcacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPTrifurcacionLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addGap(29, 29, 29).addComponent(this.JCBMVDV, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDVP, -2, 83, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPMV, -2, 78, -2).addContainerGap(14, 32767)));
        JPTrifurcacionLayout.setVerticalGroup(JPTrifurcacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTrifurcacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMVDV, -2, 50, -2).addComponent(this.JCBDVP, -2, 50, -2).addComponent(this.JCBPMV, -2, 50, -2)).addGroup(JPTrifurcacionLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2)));
        this.JTADRadiografica.setColumns(1);
        this.JTADRadiografica.setLineWrap(true);
        this.JTADRadiografica.setRows(1);
        this.JTADRadiografica.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción Radiográfica", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane7.setViewportView(this.JTADRadiografica);
        this.JTADRadiografica1.setColumns(1);
        this.JTADRadiografica1.setLineWrap(true);
        this.JTADRadiografica1.setRows(1);
        this.JTADRadiografica1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane8.setViewportView(this.JTADRadiografica1);
        GroupLayout JPIESegundaLayout = new GroupLayout(this.JPIESegunda);
        this.JPIESegunda.setLayout(JPIESegundaLayout);
        JPIESegundaLayout.setHorizontalGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addContainerGap().addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addComponent(this.JPIAbsceso, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JCBRestauracion, -2, 105, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRestauracionTipo, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRestauracionEstado, -2, 121, -2)).addGroup(JPIESegundaLayout.createSequentialGroup().addComponent(this.JPBifurcacion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPTrifurcacion, -2, -1, -2)).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIESegundaLayout.createSequentialGroup().addComponent(this.jScrollPane7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane8)).addGroup(JPIESegundaLayout.createSequentialGroup().addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBEPulpar, 0, -1, 32767).addComponent(this.JCBFisura, -2, 153, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFisuraUbicacion, -1, 559, 32767).addComponent(this.JTFEPulparObserv))))).addContainerGap(-1, 32767)));
        JPIESegundaLayout.setVerticalGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIESegundaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIAbsceso, -2, -1, -2)).addGroup(JPIESegundaLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBRestauracion, -2, 50, -2).addComponent(this.JCBRestauracionTipo, -2, 50, -2).addComponent(this.JCBRestauracionEstado, -2, 50, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFisura, -1, 50, 32767).addComponent(this.JTFFisuraUbicacion, -2, 50, -2)).addGap(5, 5, 5).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEPulpar, -1, 50, 32767).addComponent(this.JTFEPulparObserv, -2, 50, -2)).addGap(3, 3, 3).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPBifurcacion, -2, -1, -2).addComponent(this.JPTrifurcacion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIESegundaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane7, -2, 112, -2).addComponent(this.jScrollPane8, -2, 112, -2)).addGap(40, 40, 40)));
        this.JTPDatos.addTab("SEGUNDA", this.JPIESegunda);
        GroupLayout JPIEndExamenCLayout = new GroupLayout(this.JPIEndExamenC);
        this.JPIEndExamenC.setLayout(JPIEndExamenCLayout);
        JPIEndExamenCLayout.setHorizontalGroup(JPIEndExamenCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEndExamenCLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 750, -2).addContainerGap(41, 32767)));
        JPIEndExamenCLayout.setVerticalGroup(JPIEndExamenCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEndExamenCLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, 501, -2).addContainerGap(-1, 32767)));
        this.JTPEndodoncia.addTab("Ex. CLÍNICO", this.JPIEndExamenC);
        this.JCBFrio.setFont(new Font("Arial", 1, 12));
        this.JCBFrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Frio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCalorPC.setFont(new Font("Arial", 1, 12));
        this.JCBCalorPC.setBorder(BorderFactory.createTitledBorder((Border) null, "Calor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIPercusion.setBorder(BorderFactory.createTitledBorder((Border) null, "PERCUSIÓN", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBPVertical.setFont(new Font("Arial", 1, 12));
        this.JCBPVertical.setBorder(BorderFactory.createTitledBorder((Border) null, "Vertical", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPTipoV.setFont(new Font("Arial", 1, 12));
        this.JCBPTipoV.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPGradoV.setFont(new Font("Arial", 1, 12));
        this.JCBPGradoV.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPHorizontal.setFont(new Font("Arial", 1, 12));
        this.JCBPHorizontal.setBorder(BorderFactory.createTitledBorder((Border) null, "Horizontal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPTipoH.setFont(new Font("Arial", 1, 12));
        this.JCBPTipoH.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPGradoH.setFont(new Font("Arial", 1, 12));
        this.JCBPGradoH.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIPercusionLayout = new GroupLayout(this.JPIPercusion);
        this.JPIPercusion.setLayout(JPIPercusionLayout);
        JPIPercusionLayout.setHorizontalGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPercusionLayout.createSequentialGroup().addContainerGap().addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIPercusionLayout.createSequentialGroup().addComponent(this.JCBPHorizontal, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPTipoH, 0, -1, 32767)).addGroup(JPIPercusionLayout.createSequentialGroup().addComponent(this.JCBPVertical, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPTipoV, -2, 233, -2))).addGap(10, 10, 10).addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPGradoV, 0, 209, 32767).addComponent(this.JCBPGradoH, 0, -1, 32767)).addContainerGap()));
        JPIPercusionLayout.setVerticalGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPercusionLayout.createSequentialGroup().addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPercusionLayout.createSequentialGroup().addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPVertical, -2, 50, -2).addComponent(this.JCBPTipoV, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIPercusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPHorizontal, -2, 50, -2).addComponent(this.JCBPTipoH, -2, 50, -2))).addGroup(JPIPercusionLayout.createSequentialGroup().addComponent(this.JCBPGradoV, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPGradoH, -2, 50, -2))).addGap(5, 5, 5)));
        this.JCBMovilidad.setFont(new Font("Arial", 1, 12));
        this.JCBMovilidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Movilidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMovGrado.setFont(new Font("Arial", 1, 12));
        this.JCBMovGrado.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMovTesCav.setFont(new Font("Arial", 1, 12));
        this.JCBMovTesCav.setBorder(BorderFactory.createTitledBorder((Border) null, "Test Cavitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsFrio.setColumns(1);
        this.JTPObsFrio.setLineWrap(true);
        this.JTPObsFrio.setRows(1);
        this.JTPObsFrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTPObsFrio);
        this.JTPObsCalorPC.setColumns(1);
        this.JTPObsCalorPC.setLineWrap(true);
        this.JTPObsCalorPC.setRows(1);
        this.JTPObsCalorPC.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setViewportView(this.JTPObsCalorPC);
        this.JCBVitalometro.setFont(new Font("Arial", 1, 12));
        this.JCBVitalometro.setBorder(BorderFactory.createTitledBorder((Border) null, "Vitalómetro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsVitalometro.setColumns(1);
        this.JTPObsVitalometro.setLineWrap(true);
        this.JTPObsVitalometro.setRows(1);
        this.JTPObsVitalometro.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane9.setViewportView(this.JTPObsVitalometro);
        this.JTPObsPClinica.setColumns(1);
        this.JTPObsPClinica.setLineWrap(true);
        this.JTPObsPClinica.setRows(1);
        this.JTPObsPClinica.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane4.setViewportView(this.JTPObsPClinica);
        GroupLayout JPIPClinicasLayout = new GroupLayout(this.JPIPClinicas);
        this.JPIPClinicas.setLayout(JPIPClinicasLayout);
        JPIPClinicasLayout.setHorizontalGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPClinicasLayout.createSequentialGroup().addContainerGap().addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIPClinicasLayout.createSequentialGroup().addComponent(this.JCBVitalometro, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane9)).addComponent(this.JPIPercusion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIPClinicasLayout.createSequentialGroup().addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCalorPC, -2, 110, -2).addComponent(this.JCBFrio, -2, 110, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane2, -1, 496, 32767).addComponent(this.jScrollPane3))).addGroup(GroupLayout.Alignment.LEADING, JPIPClinicasLayout.createSequentialGroup().addComponent(this.JCBMovilidad, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMovGrado, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMovTesCav, -2, 214, -2))).addContainerGap(175, 32767)));
        JPIPClinicasLayout.setVerticalGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIPClinicasLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBFrio, -1, 50, 32767).addComponent(this.jScrollPane2)).addGap(5, 5, 5).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBCalorPC, -1, 50, 32767).addComponent(this.jScrollPane3)).addGap(5, 5, 5).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBVitalometro).addComponent(this.jScrollPane9, -2, 50, -2)).addGap(10, 10, 10).addComponent(this.JPIPercusion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIPClinicasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBMovilidad, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JCBMovGrado, GroupLayout.Alignment.LEADING).addComponent(this.JCBMovTesCav, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 63, -2).addContainerGap(82, 32767)));
        this.JTPEndodoncia.addTab("PRUEBA CLÍNICA", this.JPIPClinicas);
        this.JTFCorona.setFont(new Font("Arial", 1, 12));
        this.JTFCorona.setToolTipText("");
        this.JTFCorona.setBorder(BorderFactory.createTitledBorder((Border) null, "Corona", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFConductos.setFont(new Font("Arial", 1, 12));
        this.JTFConductos.setToolTipText("");
        this.JTFConductos.setBorder(BorderFactory.createTitledBorder((Border) null, "Conductos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCamaraPulpar.setFont(new Font("Arial", 1, 12));
        this.JTFCamaraPulpar.setToolTipText("");
        this.JTFCamaraPulpar.setBorder(BorderFactory.createTitledBorder((Border) null, "Camara Pulpar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLaminaDura.setFont(new Font("Arial", 1, 12));
        this.JTFLaminaDura.setToolTipText("");
        this.JTFLaminaDura.setBorder(BorderFactory.createTitledBorder((Border) null, "Lamina Dura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRaiz.setFont(new Font("Arial", 1, 12));
        this.JTFRaiz.setToolTipText("");
        this.JTFRaiz.setBorder(BorderFactory.createTitledBorder((Border) null, "Raiz", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPeriapice.setFont(new Font("Arial", 1, 12));
        this.JTFPeriapice.setToolTipText("");
        this.JTFPeriapice.setBorder(BorderFactory.createTitledBorder((Border) null, "Periapice", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObsRadiografico.setColumns(1);
        this.JTPObsRadiografico.setLineWrap(true);
        this.JTPObsRadiografico.setRows(1);
        this.JTPObsRadiografico.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane5.setViewportView(this.JTPObsRadiografico);
        GroupLayout JPIExRadiograficoLayout = new GroupLayout(this.JPIExRadiografico);
        this.JPIExRadiografico.setLayout(JPIExRadiograficoLayout);
        JPIExRadiograficoLayout.setHorizontalGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExRadiograficoLayout.createSequentialGroup().addContainerGap().addGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFPeriapice, -1, 495, 32767).addComponent(this.JTFRaiz, GroupLayout.Alignment.LEADING).addComponent(this.JTFLaminaDura, GroupLayout.Alignment.LEADING).addComponent(this.JTFCamaraPulpar, GroupLayout.Alignment.LEADING).addComponent(this.JTFConductos).addComponent(this.JTFCorona)).addComponent(this.jScrollPane5, -2, 581, -2)).addContainerGap(210, 32767)));
        JPIExRadiograficoLayout.setVerticalGroup(JPIExRadiograficoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIExRadiograficoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCorona, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCamaraPulpar, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFConductos, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFLaminaDura, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRaiz, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPeriapice, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane5, -2, 99, -2).addGap(159, 159, 159)));
        this.JTPEndodoncia.addTab("Ex. RADIOGRÁFICO", this.JPIExRadiografico);
        this.JSPHistorialDx.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTHistorialDx.setFont(new Font("Arial", 1, 12));
        this.JTHistorialDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorialDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorialDx.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorialDx.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPEndoExamenClinico.4
            public void keyPressed(KeyEvent evt) {
                JPEndoExamenClinico.this.JTHistorialDxKeyPressed(evt);
            }
        });
        this.JSPHistorialDx.setViewportView(this.JTHistorialDx);
        this.JCBDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JCBDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDiagnostico.addItemListener(new ItemListener() { // from class: Odontologia.JPEndoExamenClinico.5
            public void itemStateChanged(ItemEvent evt) {
                JPEndoExamenClinico.this.JCBDiagnosticoItemStateChanged(evt);
            }
        });
        this.JCBDiagnostico.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPEndoExamenClinico.6
            public void keyPressed(KeyEvent evt) {
                JPEndoExamenClinico.this.JCBDiagnosticoKeyPressed(evt);
            }
        });
        this.JCBDxRespuesta.setFont(new Font("Arial", 1, 12));
        this.JCBDxRespuesta.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuesta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDxRespuesta.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPEndoExamenClinico.7
            public void keyPressed(KeyEvent evt) {
                JPEndoExamenClinico.this.JCBDxRespuestaKeyPressed(evt);
            }
        });
        this.JBTAdicionarAntCli.setFont(new Font("Arial", 1, 14));
        this.JBTAdicionarAntCli.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarAntCli.addActionListener(new ActionListener() { // from class: Odontologia.JPEndoExamenClinico.8
            public void actionPerformed(ActionEvent evt) {
                JPEndoExamenClinico.this.JBTAdicionarAntCliActionPerformed(evt);
            }
        });
        GroupLayout JPIDiagnosticoLayout = new GroupLayout(this.JPIDiagnostico);
        this.JPIDiagnostico.setLayout(JPIDiagnosticoLayout);
        JPIDiagnosticoLayout.setHorizontalGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addComponent(this.JCBDiagnostico, -2, 346, -2).addGap(18, 18, 18).addComponent(this.JCBDxRespuesta, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionarAntCli, -2, 90, -2)).addComponent(this.JSPHistorialDx, -2, 713, -2)).addContainerGap(78, 32767)));
        JPIDiagnosticoLayout.setVerticalGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionarAntCli, -1, -1, 32767).addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDiagnostico, -1, 50, 32767).addComponent(this.JCBDxRespuesta, -1, 50, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistorialDx, -2, 369, -2).addContainerGap(86, 32767)));
        this.JTPEndodoncia.addTab("DX", (Icon) null, this.JPIDiagnostico, "Diagnóstico");
        this.JPITDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Trauma", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFFechaTrauma.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaTrauma.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaTrauma.setFont(new Font("Arial", 1, 12));
        this.JCBTraumasAnt.setFont(new Font("Arial", 1, 12));
        this.JCBTraumasAnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Traumas Anteriores", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDientesInv.setFont(new Font("Arial", 1, 12));
        this.JTFDientesInv.setToolTipText("");
        this.JTFDientesInv.setBorder(BorderFactory.createTitledBorder((Border) null, "Dientes Involucrados", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLugar.setFont(new Font("Arial", 1, 12));
        this.JTFLugar.setToolTipText("");
        this.JTFLugar.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTACausas.setColumns(1);
        this.JTACausas.setLineWrap(true);
        this.JTACausas.setRows(1);
        this.JTACausas.setBorder(BorderFactory.createTitledBorder((Border) null, "Causas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane10.setViewportView(this.JTACausas);
        GroupLayout JPITDatosLayout = new GroupLayout(this.JPITDatos);
        this.JPITDatos.setLayout(JPITDatosLayout);
        JPITDatosLayout.setHorizontalGroup(JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosLayout.createSequentialGroup().addGroup(JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane10, GroupLayout.Alignment.LEADING).addGroup(JPITDatosLayout.createSequentialGroup().addComponent(this.JDFFechaTrauma, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTraumasAnt, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDientesInv, -2, 168, -2).addGap(6, 6, 6).addComponent(this.JTFLugar, -2, 183, -2))).addContainerGap(-1, 32767)));
        JPITDatosLayout.setVerticalGroup(JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITDatosLayout.createSequentialGroup().addGroup(JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTraumasAnt, -2, 51, -2).addComponent(this.JDFFechaTrauma, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPITDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFLugar, GroupLayout.Alignment.TRAILING, -1, 52, 32767).addComponent(this.JTFDientesInv, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane10, -2, 46, -2).addGap(5, 5, 5)));
        this.JTPHallagoz.setForeground(Color.red);
        this.JTPHallagoz.setFont(new Font("Arial", 1, 12));
        this.JCBTDolorCabeza.setFont(new Font("Arial", 1, 12));
        this.JCBTDolorCabeza.setBorder(BorderFactory.createTitledBorder((Border) null, "Dolor de Cabeza", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTConciencia.setFont(new Font("Arial", 1, 12));
        this.JCBTConciencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Conciencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTNauseas.setFont(new Font("Arial", 1, 12));
        this.JCBTNauseas.setBorder(BorderFactory.createTitledBorder((Border) null, "Náuseas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosHGeneralesLayout = new GroupLayout(this.JPIDatosHGenerales);
        this.JPIDatosHGenerales.setLayout(JPIDatosHGeneralesLayout);
        JPIDatosHGeneralesLayout.setHorizontalGroup(JPIDatosHGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHGeneralesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTDolorCabeza, -2, 199, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTConciencia, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTNauseas, -2, 209, -2).addContainerGap(126, 32767)));
        JPIDatosHGeneralesLayout.setVerticalGroup(JPIDatosHGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHGeneralesLayout.createSequentialGroup().addGap(24, 24, 24).addGroup(JPIDatosHGeneralesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTDolorCabeza, -2, 50, -2).addComponent(this.JCBTConciencia, -2, 50, -2).addComponent(this.JCBTNauseas, -2, 50, -2)).addContainerGap(270, 32767)));
        this.JTPHallagoz.addTab("H.Generales", this.JPIDatosHGenerales);
        this.JPIDHIDientesInv.setBorder(BorderFactory.createTitledBorder((Border) null, "Dientes Involucrados", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFDTemporales.setFont(new Font("Arial", 1, 12));
        this.JTFDTemporales.setToolTipText("");
        this.JTFDTemporales.setBorder(BorderFactory.createTitledBorder((Border) null, "Temporales", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDPermanentes.setFont(new Font("Arial", 1, 12));
        this.JTFDPermanentes.setToolTipText("");
        this.JTFDPermanentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Permanentes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDHIDientesInvLayout = new GroupLayout(this.JPIDHIDientesInv);
        this.JPIDHIDientesInv.setLayout(JPIDHIDientesInvLayout);
        JPIDHIDientesInvLayout.setHorizontalGroup(JPIDHIDientesInvLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDientesInvLayout.createSequentialGroup().addContainerGap().addGroup(JPIDHIDientesInvLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFDPermanentes, -2, 108, -2).addComponent(this.JTFDTemporales, -2, 106, -2)).addContainerGap(-1, 32767)));
        JPIDHIDientesInvLayout.setVerticalGroup(JPIDHIDientesInvLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDHIDientesInvLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTFDTemporales, -2, 50, -2).addGap(3, 3, 3).addComponent(this.JTFDPermanentes, -2, 50, -2).addGap(3, 3, 3)));
        this.JPIDHIDolor.setBorder(BorderFactory.createTitledBorder((Border) null, "Dolor", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBDEspontaneo.setFont(new Font("Arial", 1, 12));
        this.JCBDEspontaneo.setBorder(BorderFactory.createTitledBorder((Border) null, "Espontáneo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDFrio.setFont(new Font("Arial", 1, 12));
        this.JCBDFrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Frio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDPercusion.setFont(new Font("Arial", 1, 12));
        this.JCBDPercusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Percusión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDExposicionP.setFont(new Font("Arial", 1, 12));
        this.JCBDExposicionP.setBorder(BorderFactory.createTitledBorder((Border) null, "Exposición Pulpar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDHIDolorLayout = new GroupLayout(this.JPIDHIDolor);
        this.JPIDHIDolor.setLayout(JPIDHIDolorLayout);
        JPIDHIDolorLayout.setHorizontalGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDolorLayout.createSequentialGroup().addContainerGap().addGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDolorLayout.createSequentialGroup().addComponent(this.JCBDEspontaneo, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDFrio, -2, 122, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDHIDolorLayout.createSequentialGroup().addComponent(this.JCBDPercusion, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBDExposicionP, -2, 122, -2))).addContainerGap()));
        JPIDHIDolorLayout.setVerticalGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDHIDolorLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBDFrio, -2, 50, -2).addComponent(this.JCBDEspontaneo, -2, 50, -2)).addGap(3, 3, 3).addGroup(JPIDHIDolorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDExposicionP, -2, 50, -2).addComponent(this.JCBDPercusion, -2, 50, -2)).addGap(3, 3, 3)));
        this.JTFPElectricaV.setFont(new Font("Arial", 1, 12));
        this.JTFPElectricaV.setToolTipText("");
        this.JTFPElectricaV.setBorder(BorderFactory.createTitledBorder((Border) null, "Prueba Eléctrica Vítalidad (EPT)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCColoracionCorona.setFont(new Font("Arial", 1, 12));
        this.JCBCColoracionCorona.setBorder(BorderFactory.createTitledBorder((Border) null, "C. Coloración Corona", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMovDentaria.setFont(new Font("Arial", 1, 12));
        this.JCBMovDentaria.setBorder(BorderFactory.createTitledBorder((Border) null, "Movilidad Dentaria", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.f16JPIDHIDao.setBorder(BorderFactory.createTitledBorder((Border) null, "Daño", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBMBucal.setFont(new Font("Arial", 1, 12));
        this.JCBMBucal.setBorder(BorderFactory.createTitledBorder((Border) null, "M. Bucal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBLLabial.setFont(new Font("Arial", 1, 12));
        this.JCBLLabial.setBorder(BorderFactory.createTitledBorder((Border) null, "L. Labial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDOtros.setFont(new Font("Arial", 1, 12));
        this.JTFDOtros.setToolTipText("");
        this.JTFDOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout groupLayout = new GroupLayout(this.f16JPIDHIDao);
        this.f16JPIDHIDao.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(this.JCBMBucal, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBLLabial, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDOtros).addContainerGap()));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMBucal, -2, 50, -2).addComponent(this.JCBLLabial, -2, 50, -2)).addComponent(this.JTFDOtros, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosHIntrahoralesLayout = new GroupLayout(this.JPIDatosHIntrahorales);
        this.JPIDatosHIntrahorales.setLayout(JPIDatosHIntrahoralesLayout);
        JPIDatosHIntrahoralesLayout.setHorizontalGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosHIntrahoralesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosHIntrahoralesLayout.createSequentialGroup().addComponent(this.JCBCColoracionCorona, -2, 194, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBMovDentaria, 0, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosHIntrahoralesLayout.createSequentialGroup().addGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosHIntrahoralesLayout.createSequentialGroup().addComponent(this.JPIDHIDientesInv, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDHIDolor, -2, -1, -2)).addComponent(this.JTFPElectricaV)).addGap(0, 0, 32767)).addComponent(this.f16JPIDHIDao, -1, -1, 32767)).addGap(458, 458, 458)));
        JPIDatosHIntrahoralesLayout.setVerticalGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosHIntrahoralesLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDHIDolor, -2, -1, -2).addComponent(this.JPIDHIDientesInv, -2, -1, -2)).addGap(3, 3, 3).addComponent(this.JTFPElectricaV, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosHIntrahoralesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCColoracionCorona, -2, 50, -2).addComponent(this.JCBMovDentaria, -2, 50, -2)).addGap(3, 3, 3).addComponent(this.f16JPIDHIDao, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPHallagoz.addTab("H. Intraorales", this.JPIDatosHIntrahorales);
        this.JCBHRFradicular.setFont(new Font("Arial", 1, 12));
        this.JCBHRFradicular.setBorder(BorderFactory.createTitledBorder((Border) null, "S.Formación Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFHRForamenApical.setFont(new Font("Arial", 1, 12));
        this.JTFHRForamenApical.setToolTipText("");
        this.JTFHRForamenApical.setBorder(BorderFactory.createTitledBorder((Border) null, "Foramen Apical (mm)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRFracturaRadicular.setFont(new Font("Arial", 1, 12));
        this.JCBHRFracturaRadicular.setBorder(BorderFactory.createTitledBorder((Border) null, "Fractura Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRLesionApical.setFont(new Font("Arial", 1, 12));
        this.JCBHRLesionApical.setBorder(BorderFactory.createTitledBorder((Border) null, "Lesión Apical", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRCavidadPul.setFont(new Font("Arial", 1, 12));
        this.JCBHRCavidadPul.setBorder(BorderFactory.createTitledBorder((Border) null, "Obli. Cavidad Pulpar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRreabsRadicular.setFont(new Font("Arial", 1, 12));
        this.JCBHRreabsRadicular.setBorder(BorderFactory.createTitledBorder((Border) null, "Reabsorción Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRTipoReabsRadicular.setFont(new Font("Arial", 1, 12));
        this.JCBHRTipoReabsRadicular.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Reabsorción Radicular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHREstMembranaPerio.setFont(new Font("Arial", 1, 12));
        this.JCBHREstMembranaPerio.setBorder(BorderFactory.createTitledBorder((Border) null, "Ensan. Membrana Perio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBHRFracturaAlveolo.setFont(new Font("Arial", 1, 12));
        this.JCBHRFracturaAlveolo.setBorder(BorderFactory.createTitledBorder((Border) null, "Fractura Alvéolo Oseo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosHRadirograficosLayout = new GroupLayout(this.JPIDatosHRadirograficos);
        this.JPIDatosHRadirograficos.setLayout(JPIDatosHRadirograficosLayout);
        JPIDatosHRadirograficosLayout.setHorizontalGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBHRTipoReabsRadicular, 0, -1, 32767).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBHRCavidadPul, 0, 256, 32767).addComponent(this.JCBHRFracturaRadicular, 0, -1, 32767).addComponent(this.JCBHRFradicular, 0, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBHRLesionApical, 0, 245, 32767).addComponent(this.JTFHRForamenApical).addComponent(this.JCBHRreabsRadicular, 0, -1, 32767))).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addComponent(this.JCBHREstMembranaPerio, -2, 259, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBHRFracturaAlveolo, 0, 242, 32767))).addContainerGap(228, 32767)));
        JPIDatosHRadirograficosLayout.setVerticalGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBHRFradicular, -1, 50, 32767).addComponent(this.JTFHRForamenApical, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBHRFracturaRadicular).addGroup(JPIDatosHRadirograficosLayout.createSequentialGroup().addComponent(this.JCBHRLesionApical, -2, 50, -2).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBHRCavidadPul).addComponent(this.JCBHRreabsRadicular)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBHRTipoReabsRadicular).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosHRadirograficosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBHREstMembranaPerio, -1, 50, 32767).addComponent(this.JCBHRFracturaAlveolo, -1, 50, 32767)).addGap(96, 96, 96)));
        this.JTPHallagoz.addTab("H.Radiográficos", this.JPIDatosHRadirograficos);
        this.JPIDDAResguardado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resguardado en:", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBDASeco.setFont(new Font("Arial", 1, 12));
        this.JCBDASeco.setBorder(BorderFactory.createTitledBorder((Border) null, "Seco", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDAAgua.setFont(new Font("Arial", 1, 12));
        this.JCBDAAgua.setBorder(BorderFactory.createTitledBorder((Border) null, "Agua", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDASaliva.setFont(new Font("Arial", 1, 12));
        this.JCBDASaliva.setBorder(BorderFactory.createTitledBorder((Border) null, "Saliva", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDALeche.setFont(new Font("Arial", 1, 12));
        this.JCBDALeche.setBorder(BorderFactory.createTitledBorder((Border) null, "Leche", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDDAResguardadoLayout = new GroupLayout(this.JPIDDAResguardado);
        this.JPIDDAResguardado.setLayout(JPIDDAResguardadoLayout);
        JPIDDAResguardadoLayout.setHorizontalGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDAResguardadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBDASeco, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDAAgua, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDASaliva, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDALeche, -2, 94, -2).addContainerGap(-1, 32767)));
        JPIDDAResguardadoLayout.setVerticalGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDAResguardadoLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDDAResguardadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDASeco, -2, 50, -2).addComponent(this.JCBDAAgua, -2, 50, -2).addComponent(this.JCBDASaliva, -2, 50, -2).addComponent(this.JCBDALeche, -2, 50, -2)).addGap(3, 3, 3)));
        this.JTFDAFCabidadB.setFont(new Font("Arial", 1, 12));
        this.JTFDAFCabidadB.setToolTipText("Tiempo Permanencia Fuera Cavidad Bucal(min)");
        this.JTFDAFCabidadB.setBorder(BorderFactory.createTitledBorder((Border) null, "T. P. Fuera C.Bucal(min)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIDiagnosticoT.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnóstico", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBDDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JCBDDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionarDx.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarDx.addActionListener(new ActionListener() { // from class: Odontologia.JPEndoExamenClinico.9
            public void actionPerformed(ActionEvent evt) {
                JPEndoExamenClinico.this.JBTAdicionarDxActionPerformed(evt);
            }
        });
        this.JSPTDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPTDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JTBTDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JTBTDiagnostico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBTDiagnostico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBTDiagnostico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBTDiagnostico.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPEndoExamenClinico.10
            public void keyPressed(KeyEvent evt) {
                JPEndoExamenClinico.this.JTBTDiagnosticoKeyPressed(evt);
            }
        });
        this.JSPTDiagnostico.setViewportView(this.JTBTDiagnostico);
        GroupLayout JPIDiagnosticoTLayout = new GroupLayout(this.JPIDiagnosticoT);
        this.JPIDiagnosticoT.setLayout(JPIDiagnosticoTLayout);
        JPIDiagnosticoTLayout.setHorizontalGroup(JPIDiagnosticoTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDiagnosticoTLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPTDiagnostico, -1, 508, 32767).addGroup(JPIDiagnosticoTLayout.createSequentialGroup().addComponent(this.JCBDDiagnostico, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarDx, -2, 61, -2))).addContainerGap()));
        JPIDiagnosticoTLayout.setVerticalGroup(JPIDiagnosticoTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoTLayout.createSequentialGroup().addGroup(JPIDiagnosticoTLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionarDx, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBDDiagnostico, GroupLayout.Alignment.LEADING)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTDiagnostico, -1, 91, 32767)));
        this.JTPPlanTratamiento.setColumns(1);
        this.JTPPlanTratamiento.setLineWrap(true);
        this.JTPPlanTratamiento.setRows(1);
        this.JTPPlanTratamiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Plan Tratamiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane6.setViewportView(this.JTPPlanTratamiento);
        GroupLayout JPIDatosCDienteAvulLayout = new GroupLayout(this.JPIDatosCDienteAvul);
        this.JPIDatosCDienteAvul.setLayout(JPIDatosCDienteAvulLayout);
        JPIDatosCDienteAvulLayout.setHorizontalGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCDienteAvulLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane6).addComponent(this.JPIDiagnosticoT, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGroup(JPIDatosCDienteAvulLayout.createSequentialGroup().addComponent(this.JTFDAFCabidadB, -2, 282, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDDAResguardado, -2, -1, -2))).addContainerGap(35, 32767)));
        JPIDatosCDienteAvulLayout.setVerticalGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCDienteAvulLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDatosCDienteAvulLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDDAResguardado, -2, -1, -2).addComponent(this.JTFDAFCabidadB, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDiagnosticoT, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane6, -2, 62, -2).addGap(59, 59, 59)));
        this.JTPHallagoz.addTab("C.Diente Avulsionado", this.JPIDatosCDienteAvul);
        GroupLayout JPITraumaLayout = new GroupLayout(this.JPITrauma);
        this.JPITrauma.setLayout(JPITraumaLayout);
        JPITraumaLayout.setHorizontalGroup(JPITraumaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITraumaLayout.createSequentialGroup().addContainerGap().addGroup(JPITraumaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPITDatos, -1, -1, 32767).addComponent(this.JTPHallagoz, -2, 754, -2)).addContainerGap(37, 32767)));
        JPITraumaLayout.setVerticalGroup(JPITraumaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITraumaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPITDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPHallagoz, -2, 373, -2).addContainerGap(-1, 32767)));
        this.JTPEndodoncia.addTab("TRAUMA", this.JPITrauma);
        this.JDCFechaEvolucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaEvolucion.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaEvolucion.setFont(new Font("Arial", 1, 12));
        this.JTFRaizEvo.setFont(new Font("Arial", 1, 12));
        this.JTFRaizEvo.setToolTipText("");
        this.JTFRaizEvo.setBorder(BorderFactory.createTitledBorder((Border) null, "Raiz", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCondEvo.setFont(new Font("Arial", 1, 12));
        this.JTFCondEvo.setToolTipText("");
        this.JTFCondEvo.setBorder(BorderFactory.createTitledBorder((Border) null, "COND", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTent.setFont(new Font("Arial", 1, 12));
        this.JTFTent.setToolTipText("");
        this.JTFTent.setBorder(BorderFactory.createTitledBorder((Border) null, "TENT", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLima.setFont(new Font("Arial", 1, 12));
        this.JTFLima.setToolTipText("");
        this.JTFLima.setBorder(BorderFactory.createTitledBorder((Border) null, "1. LIMA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDef.setFont(new Font("Arial", 1, 12));
        this.JTFDef.setToolTipText("");
        this.JTFDef.setBorder(BorderFactory.createTitledBorder((Border) null, "C. DEF", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRef.setFont(new Font("Arial", 1, 12));
        this.JTFRef.setToolTipText("");
        this.JTFRef.setBorder(BorderFactory.createTitledBorder((Border) null, "REF", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLMA.setFont(new Font("Arial", 1, 12));
        this.JTFLMA.setToolTipText("");
        this.JTFLMA.setBorder(BorderFactory.createTitledBorder((Border) null, "LMA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFConom.setFont(new Font("Arial", 1, 12));
        this.JTFConom.setToolTipText("");
        this.JTFConom.setBorder(BorderFactory.createTitledBorder((Border) null, "CONOM", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFConoAP.setFont(new Font("Arial", 1, 12));
        this.JTFConoAP.setToolTipText("");
        this.JTFConoAP.setBorder(BorderFactory.createTitledBorder((Border) null, "CONO AP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAislAB.setFont(new Font("Arial", 1, 12));
        this.JTFAislAB.setToolTipText("");
        this.JTFAislAB.setBorder(BorderFactory.createTitledBorder((Border) null, "AISL. ABSOL", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAislRelat.setFont(new Font("Arial", 1, 12));
        this.JTFAislRelat.setToolTipText("");
        this.JTFAislRelat.setBorder(BorderFactory.createTitledBorder((Border) null, "AISL. RELAT", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPTEvoluciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Histórico Evoluciones", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPTEvoluciones.setFont(new Font("Arial", 1, 12));
        this.JTBTEvoluciones.setFont(new Font("Arial", 1, 12));
        this.JTBTEvoluciones.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBTEvoluciones.setSelectionBackground(new Color(255, 255, 255));
        this.JTBTEvoluciones.setSelectionForeground(new Color(255, 0, 0));
        this.JTBTEvoluciones.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPEndoExamenClinico.11
            public void keyPressed(KeyEvent evt) {
                JPEndoExamenClinico.this.JTBTEvolucionesKeyPressed(evt);
            }
        });
        this.JSPTEvoluciones.setViewportView(this.JTBTEvoluciones);
        this.JBTAdicionarEvo.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarEvo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarEvo.setText("Adicionar");
        this.JBTAdicionarEvo.setToolTipText("Adicionar");
        this.JBTAdicionarEvo.addActionListener(new ActionListener() { // from class: Odontologia.JPEndoExamenClinico.12
            public void actionPerformed(ActionEvent evt) {
                JPEndoExamenClinico.this.JBTAdicionarEvoActionPerformed(evt);
            }
        });
        this.JBTGrabaEvolucion.setFont(new Font("Arial", 1, 12));
        this.JBTGrabaEvolucion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabaEvolucion.setText("Grabar Evolución");
        this.JBTGrabaEvolucion.setToolTipText("Grabar Evolución");
        this.JBTGrabaEvolucion.addActionListener(new ActionListener() { // from class: Odontologia.JPEndoExamenClinico.13
            public void actionPerformed(ActionEvent evt) {
                JPEndoExamenClinico.this.JBTGrabaEvolucionActionPerformed(evt);
            }
        });
        GroupLayout JPEvolucionLayout = new GroupLayout(this.JPEvolucion);
        this.JPEvolucion.setLayout(JPEvolucionLayout);
        JPEvolucionLayout.setHorizontalGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvolucionLayout.createSequentialGroup().addContainerGap().addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPEvolucionLayout.createSequentialGroup().addComponent(this.JDCFechaEvolucion, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRaizEvo, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCondEvo, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTent, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFLima, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDef)).addComponent(this.JSPTEvoluciones).addGroup(GroupLayout.Alignment.LEADING, JPEvolucionLayout.createSequentialGroup().addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionarEvo, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPEvolucionLayout.createSequentialGroup().addComponent(this.JTFRef, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFLMA, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFConom, -2, 119, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPEvolucionLayout.createSequentialGroup().addComponent(this.JTFConoAP, -2, 119, -2).addGap(6, 6, 6).addComponent(this.JTFAislAB, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAislRelat, -2, 119, -2)).addComponent(this.JBTGrabaEvolucion, -1, -1, 32767)))).addContainerGap(47, 32767)));
        JPEvolucionLayout.setVerticalGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEvolucionLayout.createSequentialGroup().addContainerGap().addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRaizEvo, -2, 50, -2).addComponent(this.JTFCondEvo, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFTent, -2, 50, -2).addComponent(this.JTFLima, -2, 50, -2).addComponent(this.JTFDef, -2, 50, -2))).addComponent(this.JDCFechaEvolucion, GroupLayout.Alignment.TRAILING, -2, 53, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFAislAB, -2, 50, -2).addComponent(this.JTFAislRelat, -2, 50, -2)).addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRef, -2, 50, -2).addComponent(this.JTFLMA, -2, 50, -2).addComponent(this.JTFConom, -2, 50, -2).addComponent(this.JTFConoAP, -2, 50, -2))).addGap(10, 10, 10).addGroup(JPEvolucionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTAdicionarEvo, -2, 36, -2).addComponent(this.JBTGrabaEvolucion, -2, 36, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPTEvoluciones, -2, 197, -2).addGap(176, 176, 176)));
        this.JTPEndodoncia.addTab("EVOLUCIÓN", this.JPEvolucion);
        this.JDCFechaNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaNota.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaNota.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm:ss"))));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNota.setBorder(BorderFactory.createTitledBorder((Border) null, "NOTA CLÍNICA", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTANota.setColumns(20);
        this.JTANota.setFont(new Font("Arial", 1, 12));
        this.JTANota.setLineWrap(true);
        this.JTANota.setRows(1);
        this.JTANota.setTabSize(1);
        this.JTANota.setBorder((Border) null);
        this.JSPNota.setViewportView(this.JTANota);
        this.JSPNotas.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTNotasEndo.setFont(new Font("Arial", 1, 12));
        this.JTNotasEndo.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTNotasEndo.setSelectionBackground(new Color(255, 255, 255));
        this.JTNotasEndo.setSelectionForeground(new Color(255, 0, 0));
        this.JTNotasEndo.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPEndoExamenClinico.14
            public void mouseClicked(MouseEvent evt) {
                JPEndoExamenClinico.this.JTNotasEndoMouseClicked(evt);
            }
        });
        this.JSPNotas.setViewportView(this.JTNotasEndo);
        this.JBGrabarNota.setFont(new Font("Arial", 1, 12));
        this.JBGrabarNota.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarNota.setText("Grabar Nota");
        this.JBGrabarNota.addActionListener(new ActionListener() { // from class: Odontologia.JPEndoExamenClinico.15
            public void actionPerformed(ActionEvent evt) {
                JPEndoExamenClinico.this.JBGrabarNotaActionPerformed(evt);
            }
        });
        GroupLayout JPNotasLayout = new GroupLayout(this.JPNotas);
        this.JPNotas.setLayout(JPNotasLayout);
        JPNotasLayout.setHorizontalGroup(JPNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNotasLayout.createSequentialGroup().addContainerGap().addGroup(JPNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPNotas, -2, 734, -2).addGroup(JPNotasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPNotasLayout.createSequentialGroup().addComponent(this.JDCFechaNota, -2, 128, -2).addGap(18, 18, 18).addComponent(this.JTFFHora, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoNota, -2, 332, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabarNota, -1, -1, 32767)).addComponent(this.JSPNota, -2, 725, -2))).addContainerGap(57, 32767)));
        JPNotasLayout.setVerticalGroup(JPNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNotasLayout.createSequentialGroup().addContainerGap().addGroup(JPNotasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPNotasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBTipoNota, GroupLayout.Alignment.LEADING, -2, 50, -2).addComponent(this.JDCFechaNota, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTFFHora, GroupLayout.Alignment.LEADING, -2, 53, -2)).addComponent(this.JBGrabarNota, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNota, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNotas, -1, 180, 32767).addContainerGap()));
        this.JTPEndodoncia.addTab("NOTAS", (Icon) null, this.JPNotas, "Notas Clínicas");
        this.JSPHistoricoG.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE GENERAL", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPHistoricoG.setFont(new Font("Arial", 1, 12));
        this.JTBTHistoricoEsp.setFont(new Font("Arial", 1, 12));
        this.JTBTHistoricoEsp.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBTHistoricoEsp.setSelectionBackground(new Color(255, 255, 255));
        this.JTBTHistoricoEsp.setSelectionForeground(new Color(255, 0, 0));
        this.JTBTHistoricoEsp.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPEndoExamenClinico.16
            public void mouseClicked(MouseEvent evt) {
                JPEndoExamenClinico.this.JTBTHistoricoEspMouseClicked(evt);
            }
        });
        this.JSPHistoricoG.setViewportView(this.JTBTHistoricoEsp);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoG, -2, 723, -2).addContainerGap(68, 32767)));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistoricoG, -2, 466, -2).addContainerGap(50, 32767)));
        this.JTPEndodoncia.addTab("HISTÓRICO", this.JPHistorico);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JCBNoDiente.setFont(new Font("Arial", 1, 12));
        this.JCBNoDiente.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Diente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoGrapas.setFont(new Font("Arial", 1, 12));
        this.JTFNoGrapas.setToolTipText("");
        this.JTFNoGrapas.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Grapa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.NoEndo.setFont(new Font("Arial", 1, 14));
        this.NoEndo.setHorizontalAlignment(0);
        this.NoEndo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Endodoncia", 0, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JBLimpiar.setFont(new Font("Arial", 1, 12));
        this.JBLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBLimpiar.setText("Limpiar");
        this.JBLimpiar.addActionListener(new ActionListener() { // from class: Odontologia.JPEndoExamenClinico.17
            public void actionPerformed(ActionEvent evt) {
                JPEndoExamenClinico.this.JBLimpiarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBNoDiente, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNoGrapas, -2, 113, -2).addGap(18, 18, 18).addComponent(this.NoEndo, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBLimpiar, -2, 113, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBLimpiar, -2, 50, -2).addComponent(this.NoEndo, -2, 50, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNoDiente, -2, 50, -2).addComponent(this.JTFNoGrapas, -2, 50, -2))).addContainerGap(14, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JTPEndodoncia)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPEndodoncia, -2, 558, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiagnosticoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBDiagnostico.getSelectedIndex() != -1) {
            this.JCBDxRespuesta.removeAllItems();
            this.xsql = "SELECT o_tipo_parametros.Id, o_tipo_parametros.Nbre FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id) WHERE (o_tipo_descripcionxparametro.Id_cdescipcion ='" + this.x48iddiagnostico[this.JCBDiagnostico.getSelectedIndex()] + "' AND o_tipo_descripcionxparametro.Estado =1) ORDER BY o_tipo_descripcionxparametro.NOrden ASC ";
            this.x49idrespuestadx = this.xct.llenarCombo(this.xsql, this.x49idrespuestadx, this.JCBDxRespuesta);
            this.JCBDxRespuesta.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDiagnosticoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBDiagnostico.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDxRespuestaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAntCliActionPerformed(ActionEvent evt) {
        if (this.JCBDiagnostico.getSelectedIndex() != -1 && this.JCBDxRespuesta.getSelectedIndex() != -1) {
            this.xmodelo1.addRow(this.xdatos);
            this.xmodelo1.setValueAt(this.x48iddiagnostico[this.JCBDiagnostico.getSelectedIndex()], this.xnfilamodelo1, 0);
            this.xmodelo1.setValueAt(this.JCBDiagnostico.getSelectedItem(), this.xnfilamodelo1, 1);
            this.xmodelo1.setValueAt(this.JCBDxRespuesta.getSelectedItem(), this.xnfilamodelo1, 2);
            this.xmodelo1.setValueAt(this.x49idrespuestadx[this.JCBDxRespuesta.getSelectedIndex()], this.xnfilamodelo1, 3);
            this.xmodelo1.setValueAt(false, this.xnfilamodelo1, 4);
            this.xnfilamodelo1++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarDxActionPerformed(ActionEvent evt) {
        if (this.JCBDDiagnostico.getSelectedIndex() != -1 && !this.xmt.mVerificarDatosDoblesTabla(this.JTBTDiagnostico, 0, this.x62ftipodx[this.JCBDDiagnostico.getSelectedIndex()])) {
            this.xmodelo0.addRow(this.xdatos);
            this.xmodelo0.setValueAt(this.x62ftipodx[this.JCBDDiagnostico.getSelectedIndex()], this.xnfilamodelo0, 0);
            this.xmodelo0.setValueAt(this.JCBDDiagnostico.getSelectedItem().toString(), this.xnfilamodelo0, 1);
            this.xmodelo0.setValueAt(false, this.xnfilamodelo0, 2);
            this.xnfilamodelo0++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTHistoricoEspMouseClicked(MouseEvent evt) {
        if (this.JTBTHistoricoEsp.getSelectedRow() > -1) {
            this.NoEndo.setText(this.xmodeloHG.getValueAt(this.JTBTHistoricoEsp.getSelectedRow(), 2).toString());
            this.xtratamiento = this.xmodeloHG.getValueAt(this.JTBTHistoricoEsp.getSelectedRow(), 1).toString();
            this.JTPEndodoncia.setSelectedIndex(0);
            mTraerDatos();
            mCargarDatosNotas();
            mBuscaEvolucion();
            this.JBTGrabaEvolucion.setVisible(true);
            this.JBGrabarNota.setVisible(true);
            this.JCBTipoNota.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistorialDxKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            mEliminarFilaGrid(this.xmodelo1, this.JTHistorialDx);
            this.xnfilamodelo1--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTDiagnosticoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            mEliminarFilaGrid(this.xmodelo0, this.JTBTDiagnostico);
            this.xnfilamodelo0--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTEvolucionesKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarEvoActionPerformed(ActionEvent evt) {
        this.xmodeloevo.addRow(this.xdatos);
        this.xmodeloevo.setValueAt(this.xmt.formatoAMD.format(this.JDCFechaEvolucion.getDate()), this.xfilamodeloevo, 0);
        this.xmodeloevo.setValueAt(this.JCBNoDiente.getSelectedItem(), this.xfilamodeloevo, 1);
        this.xmodeloevo.setValueAt(this.JTFRaizEvo.getText(), this.xfilamodeloevo, 2);
        this.xmodeloevo.setValueAt(this.JTFCondEvo.getText(), this.xfilamodeloevo, 3);
        this.xmodeloevo.setValueAt(this.JTFTent.getText(), this.xfilamodeloevo, 4);
        this.xmodeloevo.setValueAt(this.JTFLima.getText(), this.xfilamodeloevo, 5);
        this.xmodeloevo.setValueAt(this.JTFDef.getText(), this.xfilamodeloevo, 6);
        this.xmodeloevo.setValueAt(this.JTFRef.getText(), this.xfilamodeloevo, 7);
        this.xmodeloevo.setValueAt(this.JTFLMA.getText(), this.xfilamodeloevo, 8);
        this.xmodeloevo.setValueAt(this.JTFConom.getText(), this.xfilamodeloevo, 9);
        this.xmodeloevo.setValueAt(this.JTFConoAP.getText(), this.xfilamodeloevo, 10);
        this.xmodeloevo.setValueAt(this.JTFAislAB.getText(), this.xfilamodeloevo, 11);
        this.xmodeloevo.setValueAt(this.JTFAislRelat.getText(), this.xfilamodeloevo, 12);
        this.xmodeloevo.setValueAt(false, this.xfilamodeloevo, 13);
        this.xfilamodeloevo++;
        this.JTFRaizEvo.setText("");
        this.JTFCondEvo.setText("");
        this.JTFTent.setText("");
        this.JTFLima.setText("");
        this.JTFDef.setText("");
        this.JTFRef.setText("");
        this.JTFLMA.setText("");
        this.JTFConom.setText("");
        this.JTFConoAP.setText("");
        this.JTFAislAB.setText("");
        this.JTFAislRelat.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabaEvolucionActionPerformed(ActionEvent evt) {
        mGuardaEvolucion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBLimpiarActionPerformed(ActionEvent evt) {
        this.xControl = 0;
        if (this.JTPEndodoncia.getSelectedIndex() == 6) {
            this.JTANota.setText("");
            this.JCBTipoNota.setSelectedIndex(-1);
            this.JTFFHora.setValue(this.xmt.getFechaActual());
            this.JDCFechaNota.setDate(this.xmt.getFechaActual());
            return;
        }
        Principal.clasehistoriace.xjifhistoriaclinica.xJPEndoExamenClinico = new JPEndoExamenClinico();
        Principal.clasehistoriace.xjifhistoriaclinica.mMostrarPanel1(Principal.clasehistoriace.xjifhistoriaclinica.xJPEndoExamenClinico);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTNotasEndoMouseClicked(MouseEvent evt) {
        this.xControl = Integer.valueOf(this.xmodeloNotas.getValueAt(this.JTNotasEndo.getSelectedRow(), 0).toString()).intValue();
        mTraerNotas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarNotaActionPerformed(ActionEvent evt) {
        if (this.xControl == 0) {
            if (!this.NoEndo.getText().isEmpty()) {
                if (this.JCBTipoNota.getSelectedIndex() != -1) {
                    if (!this.JTANota.getText().isEmpty()) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            String sql = "INSERT INTO h_notasclinicas (Id_Atencion,`Id_TipoNota`  , `FechaNota` , `HoraNota` , `Descripcion`  , `Id_Profesional` , `Id_Especialidad` ,IdEndodoncia, `Fecha`  , `UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDCFechaNota.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTANota.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.NoEndo.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xControl = Integer.valueOf(this.xct.ejecutarSQLId(sql)).intValue();
                            this.xct.cerrarConexionBd();
                            mCargarDatosNotas();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe hacer la descripción de la Nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoNota.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe cargar una Endodoncia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe limpiar antes de continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mEliminarFilaGrid(DefaultTableModel xmod, JTable xtabla) {
        if (this.xmt.getPregunta("Esta seguro de Eliminar la fila seleccionada?") == 0) {
            xmod.removeRow(xtabla.getSelectedRow());
            this.xmt.mostrarMensaje("Fila Eliminada");
        }
    }

    public void mGrabar() {
        if (this.JCBNoDiente.getSelectedIndex() != -1) {
            if (this.JCBTipoNota.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.NoEndo.getText().isEmpty()) {
                        String sql = "INSERT INTO o_endodoncia (`IdTratamiento` ,FechaEndo, `NoDiente` , NoGrapa , Dolor, `Intensidad` , `Frecuencia` , `Caries` , `TipoCaries`  , `ObservacionCaries`  , `CColor` , `Color` , `ObservacionColor` ,`FractVertical` , `FractRadicular`  , `TipoFractV`   , `FracHorizontal` , `CoronalFract` , `TipoFractH` , `ObservacionFract` ,  `Fistula` , `ObservacionFist`  ,`ExamenPulpar`  , `ObsExamenPulpar` , `IntraOral` , `TipoIntra`  , `ExtraOral` , `TipoExtra`  ,`Restauracion` , `TipoRestauracion`  , `EstadoRest`, `Lingual` , `Vestibular` , `MV_DV` , `DV_P` , `P_MV`  , `ObsRadiografica` , `ObsExaClinico` , `Frio`  , `ObsFrio` , `Calor` , `ObsCalor` , `Vitalometro`  , `ObsVitalometro` , `Vertical`  , `TipoVertical` , `GradoVertical`  , `Horizontal`  , `TipoHorizontal` , `GradoHorizontal`  , `Movilidad` , `GradoMov`  , `TestCavitario` , `ObsPruebaClin` , `Corona`  , `CamaraPulpar`  , `Conductos`  , `LaminaDura`  , `Raiz` , `Periapice`   , `ObsExaRadiografico` , `TraumasAnt`  , `FechaTrauma` , `DientesInv` , `Lugar`  , `Causas`  , `DolorCabeza` , `Conciencia`  , `Nauseas` , `DITemp`  , `DIPermanente`  , `DEspontaneo`  , `FrioEsp` , `Percucion`   , `EPulpar` , `PruebaElectrica`  , `ColorCorona`  , `MovDentaria` , `DBucal` , `DLabial`  , `OtrosDanios` , `FormRadicular`  , `FApical` , `FracRadicularTrauma` , `LesionApical` , `CavidadPulpal` , `ReabRadicular`  , `TipoReabRadicular` , `MembPerio` , `FractAlveolo` , `TiemFuera` , `Seco` , `Agua` , `Saliva` , `Leche` ,PlanTratamiento, IdProfesional, IdEspecialidad, IdUsuarioAtendido,`UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JCBNoDiente.getSelectedItem() + "','" + this.JTFNoGrapas.getText() + "','" + this.JCBDolor.getSelectedItem() + "','" + this.JCBDIntensidad.getSelectedItem() + "','" + this.JCBDFrecuencia.getSelectedItem() + "','" + this.JCBCaries.getSelectedItem() + "','" + this.JCBCariesTipo.getSelectedItem() + "','" + this.JTPObsCarie.getText() + "','" + this.JCBCColor.getSelectedItem() + "','" + this.JCBColor.getSelectedItem() + "','" + this.JTPObsColor.getText() + "','" + this.JCBFVertical.getSelectedItem() + "','" + this.JCBFRadicular.getSelectedItem() + "','" + this.JCBFTipo.getSelectedItem() + "','" + this.JCBFHorizontal.getSelectedItem() + "','" + this.JCBFCoronal.getSelectedItem() + "','" + this.JCBFTipoH.getSelectedItem() + "','" + this.JTPObsGeneral.getText() + "','" + this.JCBFisura.getSelectedItem() + "','" + this.JTFFisuraUbicacion.getText() + "','" + this.JCBEPulpar.getSelectedItem() + "','" + this.JTFEPulparObserv.getText() + "','" + this.JCBAIntraoral.getSelectedItem() + "','" + this.JCBATipo.getSelectedItem() + "','" + this.JCBAExtraoral.getSelectedItem() + "','" + this.JCBATipoExtra.getSelectedItem() + "','" + this.JCBRestauracion.getSelectedItem() + "','" + this.JCBRestauracionTipo.getSelectedItem() + "','" + this.JCBRestauracionEstado.getSelectedItem() + "','" + this.JCBLingual.getSelectedItem() + "','" + this.JCBVestibular.getSelectedItem() + "','" + this.JCBMVDV.getSelectedItem() + "','" + this.JCBDVP.getSelectedItem() + "','" + this.JCBPMV.getSelectedItem() + "','" + this.JTADRadiografica.getText() + "','" + this.JTADRadiografica1.getText() + "','" + this.JCBFrio.getSelectedItem() + "','" + this.JTPObsFrio.getText() + "','" + this.JCBCalorPC.getSelectedItem() + "','" + this.JTPObsCalorPC.getText() + "','" + this.JCBVitalometro.getSelectedItem() + "','" + this.JTPObsVitalometro.getText() + "','" + this.JCBPVertical.getSelectedItem() + "','" + this.JCBPTipoV.getSelectedItem() + "','" + this.JCBPGradoV.getSelectedItem() + "','" + this.JCBPHorizontal.getSelectedItem() + "','" + this.JCBPTipoH.getSelectedItem() + "','" + this.JCBPGradoH.getSelectedItem() + "','" + this.JCBMovilidad.getSelectedItem() + "','" + this.JCBMovGrado.getSelectedItem() + "','" + this.JCBMovTesCav.getSelectedItem() + "','" + this.JTPObsPClinica.getText() + "','" + this.JTFCorona.getText() + "','" + this.JTFCamaraPulpar.getText() + "','" + this.JTFConductos.getText() + "','" + this.JTFLaminaDura.getText() + "','" + this.JTFRaiz.getText() + "','" + this.JTFPeriapice.getText() + "','" + this.JTPObsRadiografico.getText() + "','" + this.JCBTraumasAnt.getSelectedItem() + "','" + this.xmt.formatoAMD.format(this.JDFFechaTrauma.getDate()) + "','" + this.JTFDientesInv.getText() + "','" + this.JTFLugar.getText() + "','" + this.JTACausas.getText() + "','" + this.JCBTDolorCabeza.getSelectedItem() + "','" + this.JCBTConciencia.getSelectedItem() + "','" + this.JCBTNauseas.getSelectedItem() + "','" + this.JTFDTemporales.getText() + "','" + this.JTFDPermanentes.getText() + "','" + this.JCBDEspontaneo.getSelectedItem() + "','" + this.JCBDFrio.getSelectedItem() + "','" + this.JCBDPercusion.getSelectedItem() + "','" + this.JCBDExposicionP.getSelectedItem() + "','" + this.JTFPElectricaV.getText() + "','" + this.JCBCColoracionCorona.getSelectedItem() + "','" + this.JCBMovDentaria.getSelectedItem() + "','" + this.JCBMBucal.getSelectedItem() + "','" + this.JCBLLabial.getSelectedItem() + "','" + this.JTFDOtros.getText() + "','" + this.JCBHRFradicular.getSelectedItem() + "','" + this.JTFHRForamenApical.getText() + "','" + this.JCBHRFracturaRadicular.getSelectedItem() + "','" + this.JCBHRLesionApical.getSelectedItem() + "','" + this.JCBHRCavidadPul.getSelectedItem() + "','" + this.JCBHRreabsRadicular.getSelectedItem() + "','" + this.JCBHRTipoReabsRadicular.getSelectedItem() + "','" + this.JCBHREstMembranaPerio.getSelectedItem() + "','" + this.JCBHRFracturaAlveolo.getSelectedItem() + "','" + this.JTFDAFCabidadB.getText() + "','" + this.JCBDASeco.getSelectedItem() + "','" + this.JCBDAAgua.getSelectedItem() + "','" + this.JCBDASaliva.getSelectedItem() + "','" + this.JCBDALeche.getSelectedItem() + "','" + this.JTPPlanTratamiento.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        System.out.println("Datos que entran " + sql);
                        this.xendodoncia = this.xct.ejecutarSQLId(sql);
                        this.xct.cerrarConexionBd();
                        if (this.JTHistorialDx.getRowCount() > -1) {
                            for (int i = 0; i < this.JTHistorialDx.getRowCount(); i++) {
                                if (!Boolean.valueOf(this.xmodelo1.getValueAt(i, 4).toString()).booleanValue()) {
                                    String sql2 = "INSERT INTO o_endodoncia_dx_general (`IdEndodoncia` , `IdDx` , `IdRespuestaDx` , `UsuarioS`) VALUES ('" + this.xendodoncia + "','" + this.xmodelo1.getValueAt(i, 0) + "','" + this.xmodelo1.getValueAt(i, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQL(sql2);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        }
                        if (this.JTBTDiagnostico.getRowCount() > -1) {
                            for (int i2 = 0; i2 < this.JTBTDiagnostico.getRowCount(); i2++) {
                                if (!Boolean.valueOf(this.xmodelo0.getValueAt(i2, 2).toString()).booleanValue()) {
                                    String sql3 = "INSERT INTO  `o_endodoncia_dx_trauma` (`IdEndodoncia`, `IdTipoDx`, `UsuarioS`) VALUES ('" + this.xendodoncia + "', '" + this.xmodelo0.getValueAt(i2, 0) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQL(sql3);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        }
                        String sql4 = "INSERT INTO h_notasclinicas (Id_Atencion,`Id_TipoNota`  , `FechaNota` , `HoraNota` , `Descripcion`  , `Id_Profesional` , `Id_Especialidad` ,IdEndodoncia, `Fecha`  , `UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()] + "','" + this.xmt.formatoAMD.format(this.JDCFechaNota.getDate()) + "','" + this.xmt.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.JTANota.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xendodoncia + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xControl = Integer.valueOf(this.xct.ejecutarSQLId(sql4)).intValue();
                        this.xct.cerrarConexionBd();
                        this.NoEndo.setText(this.xendodoncia);
                        mBuscarHistoricoGeneral();
                        mGuardaEvolucion();
                    } else {
                        this.xct.ejecutarSQL("UPDATE  `o_endodoncia`SET  `FechaEndo` = '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',  `NoDiente` = '" + this.JCBNoDiente.getSelectedItem() + "',  `NoGrapa` = '" + this.JTFNoGrapas.getText() + "',  `Dolor` = '" + this.JCBDolor.getSelectedItem() + "',  `Intensidad` = '" + this.JCBDIntensidad.getSelectedItem() + "',  `Frecuencia` = '" + this.JCBDFrecuencia.getSelectedItem() + "',  `Caries` = '" + this.JCBCaries.getSelectedItem() + "',  `TipoCaries` = '" + this.JCBCariesTipo.getSelectedItem() + "',  `ObservacionCaries` = '" + this.JTPObsCarie.getText() + "',  `CColor` = '" + this.JCBCColor.getSelectedItem() + "',  `Color` = '" + this.JCBColor.getSelectedItem() + "',  `ObservacionColor` = '" + this.JTPObsColor.getText() + "',  `FractVertical` = '" + this.JCBFVertical.getSelectedItem() + "',  `FractRadicular` = '" + this.JCBFRadicular.getSelectedItem() + "',  `TipoFractV` = '" + this.JCBFTipo.getSelectedItem() + "',  `FracHorizontal` = '" + this.JCBFHorizontal.getSelectedItem() + "',  `CoronalFract` = '" + this.JCBFCoronal.getSelectedItem() + "',  `TipoFractH` = '" + this.JCBFTipoH.getSelectedItem() + "',  `ObservacionFract` = '" + this.JTPObsGeneral.getText() + "',  `Fistula` = '" + this.JCBFisura.getSelectedItem() + "',  `ObservacionFist` = '" + this.JTFFisuraUbicacion.getText() + "',  `ExamenPulpar` = '" + this.JCBEPulpar.getSelectedItem() + "',  `ObsExamenPulpar` = '" + this.JTFEPulparObserv.getText() + "',  `IntraOral` = '" + this.JCBAIntraoral.getSelectedItem() + "',  `TipoIntra` = '" + this.JCBATipo.getSelectedItem() + "',  `ExtraOral` = '" + this.JCBAExtraoral.getSelectedItem() + "',  `TipoExtra` = '" + this.JCBATipoExtra.getSelectedItem() + "',  `Restauracion` = '" + this.JCBRestauracion.getSelectedItem() + "',  `TipoRestauracion` = '" + this.JCBRestauracionTipo.getSelectedItem() + "',  `EstadoRest` = '" + this.JCBRestauracionEstado.getSelectedItem() + "',  `Lingual` = '" + this.JCBLingual.getSelectedItem() + "',\n  `Vestibular` = '" + this.JCBVestibular.getSelectedItem() + "',  `MV_DV` = '" + this.JCBMVDV.getSelectedItem() + "',  `DV_P` = '" + this.JCBDVP.getSelectedItem() + "',  `P_MV` = '" + this.JCBPMV.getSelectedItem() + "',  `ObsRadiografica` = '" + this.JTADRadiografica.getText() + "',  `ObsExaClinico` = '" + this.JTADRadiografica1.getText() + "',  `Frio` = '" + this.JCBFrio.getSelectedItem() + "',  `ObsFrio` = '" + this.JTPObsFrio.getText() + "',  `Calor` = '" + this.JCBCalorPC.getSelectedItem() + "',  `ObsCalor` = '" + this.JTPObsCalorPC.getText() + "',  `Vitalometro` = '" + this.JCBVitalometro.getSelectedItem() + "',  `ObsVitalometro` = '" + this.JTPObsVitalometro.getText() + "',  `Vertical` = '" + this.JCBPVertical.getSelectedIndex() + "',  `TipoVertical` = '" + this.JCBPTipoV.getSelectedItem() + "',  `GradoVertical` = '" + this.JCBPGradoV.getSelectedItem() + "',  `Horizontal` = '" + this.JCBPHorizontal.getSelectedItem() + "',  `TipoHorizontal` = '" + this.JCBPTipoH.getSelectedItem() + "',  `GradoHorizontal` = '" + this.JCBPGradoH.getSelectedItem() + "',  `Movilidad` = '" + this.JCBMovilidad.getSelectedItem() + "',  `GradoMov` = '" + this.JCBMovGrado.getSelectedItem() + "',  `TestCavitario` = '" + this.JCBMovTesCav.getSelectedItem() + "',  `ObsPruebaClin` = '" + this.JTPObsPClinica.getText() + "',  `Corona` = '" + this.JTFCorona.getText() + "',  `CamaraPulpar` = '" + this.JTFCamaraPulpar.getText() + "',  `Conductos` = '" + this.JTFConductos.getText() + "',  `LaminaDura` = '" + this.JTFLaminaDura.getText() + "',  `Raiz` = '" + this.JTFRaiz.getText() + "',  `Periapice` = '" + this.JTFPeriapice.getText() + "',  `ObsExaRadiografico` = '" + this.JTPObsRadiografico.getText() + "',  `TraumasAnt` = '" + this.JCBTraumasAnt.getSelectedItem() + "',  `FechaTrauma` = '" + this.xmt.formatoAMD.format(this.JDFFechaTrauma.getDate()) + "',  `DientesInv` = '" + this.JTFDientesInv.getText() + "',  `Lugar` = '" + this.JTFLugar.getText() + "',  `Causas` = '" + this.JTACausas.getText() + "',  `DolorCabeza` = '" + this.JCBTDolorCabeza.getSelectedItem() + "',  `Conciencia` = '" + this.JCBTConciencia.getSelectedItem() + "',  `Nauseas` = '" + this.JCBTNauseas.getSelectedItem() + "',  `DITemp` = '" + this.JTFDTemporales.getText() + "',  `DIPermanente` = '" + this.JTFDPermanentes.getText() + "',  `DEspontaneo` = '" + this.JCBDEspontaneo.getActionCommand() + "',  `FrioEsp` = '" + this.JCBDFrio.getSelectedItem() + "',  `Percucion` = '" + this.JCBDPercusion.getSelectedItem() + "',  `EPulpar` = '" + this.JCBDExposicionP.getSelectedItem() + "',  `PruebaElectrica` = '" + this.JTFPElectricaV.getText() + "',  `ColorCorona` = '" + this.JCBCColoracionCorona.getSelectedItem() + "',  `MovDentaria` = '" + this.JCBMovDentaria.getSelectedItem() + "',  `DBucal` = '" + this.JCBMBucal.getSelectedItem() + "',  `DLabial` = '" + this.JCBLLabial.getSelectedItem() + "',  `OtrosDanios` = '" + this.JTFDOtros.getText() + "',  `FormRadicular` = '" + this.JCBHRFradicular.getSelectedItem() + "',  `FApical` = '" + this.JTFHRForamenApical.getText() + "',  `FracRadicularTrauma` = '" + this.JCBHRFracturaRadicular.getSelectedItem() + "',  `LesionApical` = '" + this.JCBHRLesionApical.getSelectedItem() + "',  `CavidadPulpal` = '" + this.JCBHRCavidadPul.getSelectedItem() + "',  `ReabRadicular` = '" + this.JCBHRreabsRadicular.getSelectedItem() + "',  `TipoReabRadicular` = '" + this.JCBHRTipoReabsRadicular.getSelectedItem() + "',  `MembPerio` = '" + this.JCBHREstMembranaPerio.getSelectedItem() + "',  `FractAlveolo` = '" + this.JCBHRFracturaAlveolo.getSelectedItem() + "',  `TiemFuera` = '" + this.JTFDAFCabidadB.getText() + "',  `Seco` = '" + this.JCBDASeco.getSelectedItem() + "',  `Agua` = '" + this.JCBDAAgua.getSelectedItem() + "',  `Saliva` = '" + this.JCBDASaliva.getSelectedItem() + "',  `Leche` = '" + this.JCBDALeche.getSelectedItem() + "',  `PlanTratamiento` = '" + this.JTPPlanTratamiento.getText() + "',  `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'WHERE `Id` = '" + this.NoEndo.getText() + "' ");
                        if (this.JTHistorialDx.getRowCount() > -1) {
                            for (int i3 = 0; i3 < this.JTHistorialDx.getRowCount(); i3++) {
                                if (!Boolean.valueOf(this.xmodelo1.getValueAt(i3, 4).toString()).booleanValue()) {
                                    String sql22 = "INSERT INTO o_endodoncia_dx_general (`IdEndodoncia` , `IdDx` , `IdRespuestaDx` , `UsuarioS`) VALUES ('" + this.NoEndo.getText() + "','" + this.xmodelo1.getValueAt(i3, 0) + "','" + this.xmodelo1.getValueAt(i3, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQL(sql22);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        }
                        if (this.JTBTDiagnostico.getRowCount() > -1) {
                            for (int i4 = 0; i4 < this.JTBTDiagnostico.getRowCount(); i4++) {
                                if (!Boolean.valueOf(this.xmodelo0.getValueAt(i4, 2).toString()).booleanValue()) {
                                    String sql32 = "INSERT INTO  `o_endodoncia_dx_trauma` (`IdEndodoncia`, `IdTipoDx`, `UsuarioS`) VALUES ('" + this.NoEndo.getText() + "', '" + this.xmodelo0.getValueAt(i4, 0) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQL(sql32);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        }
                    }
                    mTraerDatos();
                    mCargarDatosNotas();
                    mBuscaEvolucion();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPEndodoncia.setSelectedIndex(6);
            this.JCBTipoNota.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un diente", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBNoDiente.requestFocus();
    }

    private void mTraerNotas() {
        String sql = "SELECT  `FechaNota` , `HoraNota` , `Descripcion` FROM `h_notasclinicas` WHERE (`Id` ='" + this.xmodeloNotas.getValueAt(this.JTNotasEndo.getSelectedRow(), 0) + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        String xparte1 = "";
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    xparte1 = xparte1 + xrs.getString("FechaNota") + " " + xrs.getString("HoraNota") + " " + xrs.getString("Descripcion") + "\n\n";
                }
            }
            this.JTANota.setText(xparte1);
            this.JTANota.setCaretPosition(0);
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEndoExamenClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistoricoG() {
        this.xmodeloHG = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "IdTratamiento", "Id Endodoncia", "Fecha", "No. Diente", "No. Grapa", "Profesional", "Especialidad"}) { // from class: Odontologia.JPEndoExamenClinico.18
            Class[] types = {Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBTHistoricoEsp.setModel(this.xmodeloHG);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTBTHistoricoEsp.getColumnModel().getColumn(7).setPreferredWidth(150);
    }

    private void mBuscarHistoricoGeneral() {
        String sql = "SELECT   o_hc_tratamiento.Id_Atencion ,`o_endodoncia`.`IdTratamiento` , `o_endodoncia`.`Id` , `o_endodoncia`.`FechaEndo`,`o_endodoncia`.`NoDiente`,`o_endodoncia`.`NoGrapa`  , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`  FROM `o_endodoncia` INNER JOIN `baseserver`.`profesional1`   ON (`o_endodoncia`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`o_endodoncia`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)  INNER JOIN  `o_hc_tratamiento` ON (`o_endodoncia`.`IdTratamiento` = `o_hc_tratamiento`.`Id`)  WHERE (`o_endodoncia`.`IdUsuarioAtendido` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND o_endodoncia.Estado=1)";
        mCrearTablaHistoricoG();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloHG.addRow(this.xdatos);
                    this.xmodeloHG.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloHG.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    this.xmodeloHG.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodeloHG.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloHG.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloHG.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloHG.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloHG.setValueAt(xrs.getString(8), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEndoExamenClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mTraerDatos() {
        String sql = "SELECT  `NoDiente`, `NoGrapa`, `Dolor`,  `Intensidad`, `Frecuencia`,  `Caries`,  `TipoCaries`,  `ObservacionCaries`,  `CColor`,  `Color`, `ObservacionColor`, `FractVertical`, `FractRadicular`, `TipoFractV`, `FracHorizontal`, `CoronalFract`, TipoFractH, `ObservacionFract`,  `Fistula`, `ObservacionFist`,ExamenPulpar, ObsExamenPulpar, `IntraOral`,  `TipoIntra`, `ExtraOral`, `TipoExtra`, Restauracion,TipoRestauracion,EstadoRest,  `Lingual`, `Vestibular`, `MV_DV`, `DV_P`,  `P_MV`, `ObsRadiografica`, `ObsExaClinico`,  `Frio`,  `ObsFrio`, `Calor`, `ObsCalor`, `Vitalometro`,  `ObsVitalometro`, `Vertical`,  `TipoVertical`, `GradoVertical`, `Horizontal`, `TipoHorizontal`, `GradoHorizontal`, `Movilidad`, `GradoMov`, `TestCavitario`,  `ObsPruebaClin`,  `Corona`, `CamaraPulpar`, `Conductos`, `LaminaDura`, `Raiz`, `Periapice`, `ObsExaRadiografico`, `TraumasAnt`,  `FechaTrauma`, `DientesInv`, `Lugar`, `Causas`, `DolorCabeza`, `Conciencia`, `Nauseas`, `DITemp`, `DIPermanente`, `DEspontaneo`,  `FrioEsp`, `Percucion`, `EPulpar`,  `PruebaElectrica`, `ColorCorona`,  `MovDentaria`,  `DBucal`, `DLabial`, `OtrosDanios`,  `FormRadicular`, `FApical`, `FracRadicularTrauma`, `LesionApical`, `CavidadPulpal`, `ReabRadicular`, `TipoReabRadicular`,  `MembPerio`, `FractAlveolo`, `TiemFuera`,  `Seco`, `Agua`, `Saliva`,  `Leche`, `PlanTratamiento`  FROM `o_endodoncia` WHERE (`Id`='" + this.NoEndo.getText() + "' AND  `IdTratamiento`= '" + this.xtratamiento + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JCBNoDiente.setSelectedItem(xrs.getString("NoDiente"));
                this.JTFNoGrapas.setText(xrs.getString("NoGrapa"));
                this.JCBDolor.setSelectedItem(xrs.getString("Dolor"));
                this.JCBDIntensidad.setSelectedItem(xrs.getString("Intensidad"));
                this.JCBDFrecuencia.setSelectedItem(xrs.getString("Frecuencia"));
                this.JCBCaries.setSelectedItem(xrs.getString("Caries"));
                this.JCBCariesTipo.setSelectedItem(xrs.getString("TipoCaries"));
                this.JTPObsCarie.setText(xrs.getString("ObservacionCaries"));
                this.JCBCColor.setSelectedItem(xrs.getString("CColor"));
                this.JCBColor.setSelectedItem(xrs.getString("Color"));
                this.JTPObsColor.setText(xrs.getString("ObservacionColor"));
                this.JCBFVertical.setSelectedItem(xrs.getString("FractVertical"));
                this.JCBFRadicular.setSelectedItem(xrs.getString("FractRadicular"));
                this.JCBFTipo.setSelectedItem(xrs.getString("TipoFractV"));
                this.JCBFHorizontal.setSelectedItem(xrs.getString("FracHorizontal"));
                this.JCBFCoronal.setSelectedItem(xrs.getString("CoronalFract"));
                this.JCBFTipoH.setSelectedItem(xrs.getString("TipoFractH"));
                this.JTPObsGeneral.setText(xrs.getString("ObservacionFract"));
                this.JCBFisura.setSelectedItem(xrs.getString("Fistula"));
                this.JTFFisuraUbicacion.setText(xrs.getString("ObservacionFist"));
                this.JCBEPulpar.setSelectedItem(xrs.getString("ExamenPulpar"));
                this.JTFEPulparObserv.setText(xrs.getString("ObsExamenPulpar"));
                this.JCBAIntraoral.setSelectedItem(xrs.getString("IntraOral"));
                this.JCBATipo.setSelectedItem(xrs.getString("TipoIntra"));
                this.JCBAExtraoral.setSelectedItem(xrs.getString("ExtraOral"));
                this.JCBATipoExtra.setSelectedItem(xrs.getString("TipoExtra"));
                this.JCBRestauracion.setSelectedItem(xrs.getString("Restauracion"));
                this.JCBRestauracionTipo.setSelectedItem(xrs.getString("TipoRestauracion"));
                this.JCBRestauracionEstado.setSelectedItem(xrs.getString("EstadoRest"));
                this.JCBLingual.setSelectedItem(xrs.getString("Lingual"));
                this.JCBVestibular.setSelectedItem(xrs.getString("Vestibular"));
                this.JCBMVDV.setSelectedItem(xrs.getString("MV_DV"));
                this.JCBDVP.setSelectedItem(xrs.getString("DV_P"));
                this.JCBPMV.setSelectedItem(xrs.getString("P_MV"));
                this.JTADRadiografica.setText(xrs.getString("ObsRadiografica"));
                this.JTADRadiografica1.setText(xrs.getString("ObsExaClinico"));
                this.JCBFrio.setSelectedItem(xrs.getString("Frio"));
                this.JTPObsFrio.setText(xrs.getString("ObsFrio"));
                this.JCBCalorPC.setSelectedItem(xrs.getString("Calor"));
                this.JTPObsCalorPC.setText(xrs.getString("ObsCalor"));
                this.JCBVitalometro.setSelectedItem(xrs.getString("Vitalometro"));
                this.JTPObsVitalometro.setText(xrs.getString("ObsVitalometro"));
                this.JCBPVertical.setSelectedItem(xrs.getString("Vertical"));
                this.JCBPTipoV.setSelectedItem(xrs.getString("TipoVertical"));
                this.JCBPGradoV.setSelectedItem(xrs.getString("GradoVertical"));
                this.JCBPHorizontal.setSelectedItem(xrs.getString("Horizontal"));
                this.JCBPTipoH.setSelectedItem(xrs.getString("TipoHorizontal"));
                this.JCBPGradoH.setSelectedItem(xrs.getString("GradoHorizontal"));
                this.JCBMovilidad.setSelectedItem(xrs.getString("Movilidad"));
                this.JCBMovGrado.setSelectedItem(xrs.getString("GradoMov"));
                this.JCBMovTesCav.setSelectedItem(xrs.getString("TestCavitario"));
                this.JTPObsPClinica.setText(xrs.getString("ObsPruebaClin"));
                this.JTFCorona.setText(xrs.getString("Corona"));
                this.JTFCamaraPulpar.setText(xrs.getString("CamaraPulpar"));
                this.JTFConductos.setText(xrs.getString("Conductos"));
                this.JTFLaminaDura.setText(xrs.getString("LaminaDura"));
                this.JTFRaiz.setText(xrs.getString("Raiz"));
                this.JTFPeriapice.setText(xrs.getString("Periapice"));
                this.JTPObsRadiografico.setText(xrs.getString("ObsExaRadiografico"));
                this.JCBTraumasAnt.setSelectedItem(xrs.getString("TraumasAnt"));
                this.JDFFechaTrauma.setDate(xrs.getDate("FechaTrauma"));
                this.JTFDientesInv.setText(xrs.getString("DientesInv"));
                this.JTFLugar.setText(xrs.getString("Lugar"));
                this.JTACausas.setText(xrs.getString("Causas"));
                this.JCBTDolorCabeza.setSelectedItem(xrs.getString("DolorCabeza"));
                this.JCBTConciencia.setSelectedItem(xrs.getString("Conciencia"));
                this.JCBTNauseas.setSelectedItem(xrs.getString("Nauseas"));
                this.JTFDTemporales.setText(xrs.getString("DITemp"));
                this.JTFDPermanentes.setText(xrs.getString("DIPermanente"));
                this.JCBDEspontaneo.setSelectedItem(xrs.getString("DEspontaneo"));
                this.JCBDFrio.setSelectedItem(xrs.getString("FrioEsp"));
                this.JCBDPercusion.setSelectedItem(xrs.getString("Percucion"));
                this.JCBDExposicionP.setSelectedItem(xrs.getString("EPulpar"));
                this.JTFPElectricaV.setText(xrs.getString("PruebaElectrica"));
                this.JCBCColoracionCorona.setSelectedItem(xrs.getString("ColorCorona"));
                this.JCBMovDentaria.setSelectedItem(xrs.getString("MovDentaria"));
                this.JCBMBucal.setSelectedItem(xrs.getString("DBucal"));
                this.JCBLLabial.setSelectedItem(xrs.getString("DLabial"));
                this.JTFDOtros.setText(xrs.getString("OtrosDanios"));
                this.JCBHRFradicular.setSelectedItem(xrs.getString("FormRadicular"));
                this.JTFHRForamenApical.setText(xrs.getString("FApical"));
                this.JCBHRFracturaRadicular.setSelectedItem(xrs.getString("FracRadicularTrauma"));
                this.JCBHRLesionApical.setSelectedItem(xrs.getString("LesionApical"));
                this.JCBHRCavidadPul.setSelectedItem(xrs.getString("CavidadPulpal"));
                this.JCBHRreabsRadicular.setSelectedItem(xrs.getString("ReabRadicular"));
                this.JCBHRTipoReabsRadicular.setSelectedItem(xrs.getString("TipoReabRadicular"));
                this.JCBHREstMembranaPerio.setSelectedItem(xrs.getString("MembPerio"));
                this.JCBHRFracturaAlveolo.setSelectedItem(xrs.getString("FractAlveolo"));
                this.JTFDAFCabidadB.setText(xrs.getString("TiemFuera"));
                this.JCBDASeco.setSelectedItem(xrs.getString("Seco"));
                this.JCBDAAgua.setSelectedItem(xrs.getString("Agua"));
                this.JCBDASaliva.setSelectedItem(xrs.getString("Saliva"));
                this.JCBDALeche.setSelectedItem(xrs.getString("Leche"));
                this.JTPPlanTratamiento.setText(xrs.getString("PlanTratamiento"));
                String sql2 = "SELECT  `o_endodoncia_dx_general`.`IdDx`  , `o_tipo_contenido_descripcion`.`Nbre` , `o_tipo_parametros`.`Nbre`  , `o_endodoncia_dx_general`.`IdRespuestaDx`, o_endodoncia_dx_general.Estado  FROM  `o_endodoncia_dx_general`  INNER JOIN `o_tipo_contenido_descripcion`   ON (`o_endodoncia_dx_general`.`IdDx` = `o_tipo_contenido_descripcion`.`Id`)  INNER JOIN `o_tipo_parametros`   ON (`o_endodoncia_dx_general`.`IdRespuestaDx` = `o_tipo_parametros`.`Id`) WHERE (`o_endodoncia_dx_general`.`IdEndodoncia` = '" + this.NoEndo.getText() + "')";
                System.out.println("Dx Gen::::::::::: " + sql2);
                ConsultasMySQL xct1 = new ConsultasMySQL();
                mCrearTablaDiagnostico();
                ResultSet xrs2 = xct1.traerRs(sql2);
                if (xrs2.next()) {
                    xrs2.beforeFirst();
                    while (xrs2.next()) {
                        this.xmodelo1.addRow(this.xdatos);
                        this.xmodelo1.setValueAt(Integer.valueOf(xrs2.getInt(1)), this.xnfilamodelo1, 0);
                        this.xmodelo1.setValueAt(xrs2.getString(2), this.xnfilamodelo1, 1);
                        this.xmodelo1.setValueAt(xrs2.getString(3), this.xnfilamodelo1, 2);
                        this.xmodelo1.setValueAt(Integer.valueOf(xrs2.getInt(4)), this.xnfilamodelo1, 3);
                        this.xmodelo1.setValueAt(Boolean.valueOf(xrs2.getBoolean(5)), this.xnfilamodelo1, 4);
                        this.xnfilamodelo1++;
                    }
                }
                xrs2.close();
                xct1.cerrarConexionBd();
                String sql3 = "SELECT `o_endodoncia_dx_trauma`.`IdTipoDx` , `o_tipo_diagnostico`.`Nbre`,o_endodoncia_dx_trauma.Estado  FROM `o_endodoncia_dx_trauma`  INNER JOIN `baseserver`.`o_tipo_diagnostico`   ON (`o_endodoncia_dx_trauma`.`IdTipoDx` = `o_tipo_diagnostico`.`Id`) WHERE (`o_endodoncia_dx_trauma`.`IdEndodoncia` ='" + this.NoEndo.getText() + "')";
                System.out.println("Dx Trauma::::::::::: " + sql3);
                ConsultasMySQL xct2 = new ConsultasMySQL();
                ResultSet xrs3 = xct2.traerRs(sql3);
                mCrearTablaDxTrauma();
                if (xrs3.next()) {
                    xrs3.beforeFirst();
                    while (xrs3.next()) {
                        this.xmodelo0.addRow(this.xdatos);
                        this.xmodelo0.setValueAt(Integer.valueOf(xrs3.getInt(1)), this.xnfilamodelo0, 0);
                        this.xmodelo0.setValueAt(xrs3.getString(2), this.xnfilamodelo0, 1);
                        this.xmodelo0.setValueAt(Boolean.valueOf(xrs3.getBoolean(3)), this.xnfilamodelo0, 2);
                        this.xnfilamodelo0++;
                    }
                }
                xrs3.close();
                xct2.cerrarConexionBd();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEndoExamenClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGuardaEvolucion() {
        if (this.JTBTEvoluciones.getRowCount() > -1) {
            for (int y = 0; y < this.JTBTEvoluciones.getRowCount(); y++) {
                if (!Boolean.valueOf(this.xmodeloevo.getValueAt(y, 13).toString()).booleanValue()) {
                    String sql = "INSERT INTO  `o_endodoncia_evolucion` (IdTratamiento,IdEndodoncia, `NoDiente`, `FechaEvolucion`, `Raiz`, `COND`, `TENT`, `LIMA`,  `DEF`, `REF`, `LMA`, `CONOM`, `CONO_AP`, `ABSOL`, `RELAT`, `UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.NoEndo.getText() + "','" + this.xmodeloevo.getValueAt(y, 1) + "', '" + this.xmt.formatoAMD.format(this.JDCFechaEvolucion.getDate()) + "', '" + this.xmodeloevo.getValueAt(y, 2) + "', '" + this.xmodeloevo.getValueAt(y, 3) + "', '" + this.xmodeloevo.getValueAt(y, 4) + "', '" + this.xmodeloevo.getValueAt(y, 5) + "',  '" + this.xmodeloevo.getValueAt(y, 6) + "', '" + this.xmodeloevo.getValueAt(y, 7) + "',  '" + this.xmodeloevo.getValueAt(y, 8) + "', '" + this.xmodeloevo.getValueAt(y, 9) + "', '" + this.xmodeloevo.getValueAt(y, 10) + "', '" + this.xmodeloevo.getValueAt(y, 11) + "', '" + this.xmodeloevo.getValueAt(y, 12) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    System.out.println("Inserto evolucion " + sql);
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                }
            }
            mBuscaEvolucion();
        }
    }

    private void mBuscaEvolucion() {
        String sql = "SELECT o_endodoncia_evolucion.`FechaEvolucion`,o_endodoncia_evolucion.NoDiente, o_endodoncia_evolucion.`Raiz`,  o_endodoncia_evolucion.`COND`, o_endodoncia_evolucion.`TENT`, o_endodoncia_evolucion.`LIMA`, o_endodoncia_evolucion.`DEF`,  o_endodoncia_evolucion.`REF`, o_endodoncia_evolucion.`LMA`, o_endodoncia_evolucion.`CONOM`, o_endodoncia_evolucion.`CONO_AP`,  o_endodoncia_evolucion.`ABSOL`, o_endodoncia_evolucion.`RELAT`, o_endodoncia_evolucion.`Estado` FROM `o_endodoncia_evolucion`  INNER JOIN `o_hc_tratamiento`  ON (`o_endodoncia_evolucion`.`IdTratamiento` = `o_hc_tratamiento`.`Id`) WHERE o_endodoncia_evolucion.IdEndodoncia='" + this.NoEndo.getText() + "' ORDER BY o_endodoncia_evolucion.`FechaEvolucion` desc";
        System.out.println("Evolucion Endo:   " + sql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        mCrearTablaEvoluciones();
        this.xfilamodeloevo = 0;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodeloevo.addRow(this.xdatos);
                    this.xmodeloevo.setValueAt(xrs.getDate("FechaEvolucion"), this.xfilamodeloevo, 0);
                    this.xmodeloevo.setValueAt(xrs.getString("NoDiente"), this.xfilamodeloevo, 1);
                    this.xmodeloevo.setValueAt(xrs.getString("Raiz"), this.xfilamodeloevo, 2);
                    this.xmodeloevo.setValueAt(xrs.getString("COND"), this.xfilamodeloevo, 3);
                    this.xmodeloevo.setValueAt(xrs.getString("TENT"), this.xfilamodeloevo, 4);
                    this.xmodeloevo.setValueAt(xrs.getString("LIMA"), this.xfilamodeloevo, 5);
                    this.xmodeloevo.setValueAt(xrs.getString("DEF"), this.xfilamodeloevo, 6);
                    this.xmodeloevo.setValueAt(xrs.getString("REF"), this.xfilamodeloevo, 7);
                    this.xmodeloevo.setValueAt(xrs.getString("LMA"), this.xfilamodeloevo, 8);
                    this.xmodeloevo.setValueAt(xrs.getString("CONOM"), this.xfilamodeloevo, 9);
                    this.xmodeloevo.setValueAt(xrs.getString("CONO_AP"), this.xfilamodeloevo, 10);
                    this.xmodeloevo.setValueAt(xrs.getString("ABSOL"), this.xfilamodeloevo, 11);
                    this.xmodeloevo.setValueAt(xrs.getString("RELAT"), this.xfilamodeloevo, 12);
                    this.xmodeloevo.setValueAt(Boolean.valueOf(xrs.getBoolean("Estado")), this.xfilamodeloevo, 13);
                    this.xfilamodeloevo++;
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEndoExamenClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistoricoNotas() {
        this.xmodeloNotas = new DefaultTableModel(new Object[0], new String[]{"Cod. Nota", "Fecha y Hora", "Descripción", "Especialidad", "Profesional"}) { // from class: Odontologia.JPEndoExamenClinico.19
            Class[] types = {Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTNotasEndo.setModel(this.xmodeloNotas);
        this.JTNotasEndo.getColumnModel().getColumn(0).setPreferredWidth(25);
        this.JTNotasEndo.getColumnModel().getColumn(1).setPreferredWidth(85);
        this.JTNotasEndo.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTNotasEndo.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTNotasEndo.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void mCargarDatosNotas() {
        try {
            String sql = "SELECT h_notasclinicas.Id, DATE_FORMAT(h_notasclinicas.FechaNota, '%d-%m-%Y') AS fecha, h_notasclinicas.HoraNota, h_notasclinicas.Descripcion, profesional1.Especialidad, profesional1.NProfesional FROM baseserver.profesional1 INNER JOIN baseserver.h_notasclinicas ON (profesional1.Id_Persona = h_notasclinicas.Id_Profesional) AND (h_notasclinicas.Id_Especialidad = profesional1.IdEspecialidad) WHERE (h_notasclinicas.IdEndodoncia ='" + this.NoEndo.getText() + "' and h_notasclinicas.Estado=1) ORDER BY profesional1.Especialidad ASC, h_notasclinicas.FechaNota DESC, h_notasclinicas.HoraNota DESC ";
            mCrearTablaHistoricoNotas();
            ResultSet rs = this.xct.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodeloNotas.addRow(this.xdatos);
                    this.xmodeloNotas.setValueAt(Integer.valueOf(rs.getInt(1)), i, 0);
                    this.xmodeloNotas.setValueAt(rs.getString(2) + " " + rs.getString(3), i, 1);
                    this.xmodeloNotas.setValueAt(rs.getString(4), i, 2);
                    this.xmodeloNotas.setValueAt(rs.getString(5), i, 3);
                    this.xmodeloNotas.setValueAt(rs.getString(6), i, 4);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEndoExamenClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        if (this.JTPEndodoncia.getSelectedIndex() == 6) {
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = String.valueOf(this.xControl);
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinica_Evoluciones", mparametros);
            return;
        }
        String[][] mparametros2 = new String[1][2];
        mparametros2[0][0] = "idatencion1";
        mparametros2[0][1] = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        mparametros2[1][0] = "SUBREPORT_DIR";
        mparametros2[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros2[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros2[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaOdontologia", mparametros2);
    }
}
