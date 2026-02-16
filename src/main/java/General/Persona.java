package General;

import Acceso.Principal;
import AutorizacionMP.JIFAutorizaciones1;
import AutorizacionMP.JIFGenerarDescuento;
import AutorizacionMP.JIFMatriculaPE;
import Citas.CitaNP;
import Citas.CitaTerapia;
import Citas.CitasGral;
import Citas.JIFConsultarCitas;
import Enfermeria.Atencion;
import Enfermeria.JIFHistoria_UH;
import Facturacion.Facturac;
import Facturacion.Ingreso;
import Facturacion.JDActualizarCargoSO;
import Facturacion.JIFAutorizacion_Servicios;
import Facturacion.JIFLiqServicios;
import Facturacion.JIFRiesgoCardiovascular;
import Facturacion.JIFRiesgoObstetrico;
import GestionDoc.JIFCargarDocumentosHC;
import GestionDoc.JIFConsultarAyudasDx;
import GestionDoc.JIFGenerarExamenUsuario;
import GestionDoc.JIFSolicitudDocumentosHC;
import Historia.JIFConsultarExamenesxUsuario;
import Historia.JIFConsultarHistorial;
import Historia.JIFGenerarCertificado;
import Historia.JIFHistoriaFT;
import Historia.JIFIncapacidades;
import Historia.JIFPermisosMedicos;
import Historia.JIFRJuntaMedica;
import Historia.JIFRVisitasDomiciliarias;
import Historia.JIFRegistroAtencionesEsp;
import Historia.clasesHistoriaCE;
import ImagenesDx.JIFLecturaPlacaOit;
import Inventarios.Despachos;
import Odontologia.JIFDTratamientoOdontologico;
import Odontologia.JIFHistoriaOdontologica;
import ParametrizacionN.JIFFEmpresa;
import ParametrizacionN.JIFGAlertaxUsuario;
import ParametrizacionN.JIFGProfesional;
import ParametrizacionN.JIFGSupervisor;
import ParametrizacionN.JIFRHUsuarioCargo;
import ParametrizacionN.JIFUsuarioSistema;
import PyP.CACervixResultado;
import PyP.JIFCACervix;
import PyP.JIFRegistro4505;
import PyP.JIFUsuarioxPrograma;
import PyP.Vacunacion;
import Salud_Ocupacional.JIFPrueba_AyD;
import Salud_Ocupacional.JIFTest_Fatiga;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.controller.caja.JIFAsigancionReciboIngresos;
import com.genoma.plus.controller.citas.JIFCarneCitas;
import com.genoma.plus.controller.general.JD_EncuestaIngreso;
import com.genoma.plus.controller.imagenesdx.JIFFInformeLecturaUsuarios;
import com.genoma.plus.controller.pyp.JIF_EgresoPrograma;
import com.genoma.plus.dao.general.GConsultasSqlDAO;
import com.genoma.plus.dao.impl.general.GConsultasSqlDAOImpl;
import com.genoma.plus.jpa.entities.GSexo;
import com.genoma.plus.jpa.entities.GSexoIdentidadGenero;
import com.genoma.plus.jpa.entities.GTipoDiscapacidad;
import com.genoma.plus.jpa.service.GSexoIdentidadGeneroService;
import com.genoma.plus.jpa.service.IGTipoDiscapacidadService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:General/Persona.class */
public class Persona extends JPanel {
    File directorio;
    private String sql;
    private int rh;
    public String[] listaEstadoCivil;
    public String[] listaMunicipio;
    public String[] listaBarrio;
    public String[] listaMunicipioNac;
    public String[] xidSoporteDoc;
    public String[] listaSexo;
    public String[] listaTipoAfiliado;
    public String[] listaOcupacion;
    public String[] listacargo;
    public String[] listasegmento;
    public String[] listaArl;
    public String[] listagrupo;
    public String[] listalateralidad;
    public String[] listajornada;
    public String[] listapobEspecial;
    public String[][] listaRelacionLaboral;
    public String[][] listaEdad;
    public String[][] listaTipoIdentificacion;
    public String[][] listasupervisor;
    public String[][] listaEmpresa;
    public String[] listaTipoEmpresa;
    public String[] listaParentesco;
    public String[] xidunidadnegocio;
    public int edad;
    public int tipoEdad;
    public String frmllamador;
    public String idCotizante;
    public Facturac frmFacturac;
    private Vacunacion frmVacunacion;
    public CitasGral frmCita;
    public CitaNP frmCitaNp;
    private JIFRiesgoObstetrico frmJIFRiesgoObstetrico;
    public CrearPersona frmCrearPersona;
    private JIFCACervix frmTomaCACervix;
    private CACervixResultado frmResultadoCACervix;
    private JIFConsultarAyudasDx frmConsultarAyudasDx;
    private JIFCargarDocumentosHC frmCargarAtencionesMan;
    private JIFConsultarHistorial frmConsultarHistorial;
    private JIFRVisitasDomiciliarias frmVisitaDom;
    private JIFHistoriaFT frmHistoriaFt;
    private JIFPermisosMedicos frmPermisos;
    private JIFRJuntaMedica frmJuntaMed;
    private Atencion frmAtencion;
    private JIFGenerarCertificado xjifgeneracion;
    private JIFUsuarioSistema xjifusuarios;
    private JIFGProfesional xjifprofesional1;
    private JIFGSupervisor xjifsupervisor;
    private JIFConsultarCitas xjifconsultarc;
    private JIFMatriculaPE xjifmatriculapep;
    private JIFGAlertaxUsuario xjifalertausuario;
    private JIFRegistroAtencionesEsp xjifregistroesp;
    private JIFFEmpresa xjifempresa;
    private JIFAutorizaciones1 xjifautorizacionmp;
    private JIFRHUsuarioCargo xjifrhusuarioc;
    private JIFGenerarDescuento xjifgenerardesc;
    private JIFGenerarExamenUsuario xjifgenerarexusuario;
    private JIFHistoriaOdontologica xjifhcodontofica;
    private JIFSolicitudDocumentosHC xjifsolicituddoc;
    private JIFCrearPersona xjifcrearp;
    private JIFIncapacidades xjifincapcidad;
    private JIFDTratamientoOdontologico ttoodontologico;
    private JIFConsultarExamenesxUsuario xjifexamenxuser;
    private JIFLecturaPlacaOit xjiflecturao;
    private JIFPrueba_AyD xjifpayd;
    private Despachos xjifdespachos;
    private JIFTest_Fatiga xjiftestfatiga;
    public JIFLiqServicios xjifLiqServicios;
    private JIFHistoria_UH xjifhcuh;
    private JIFUsuarioxPrograma xJIFUsuarioxPrograma;
    private DefaultTableModel xmodeloSoporte;
    private Object[] xdatos;
    private File xfile;
    private JIFRegistro4505 xJIFRegistro4505;
    private JIFAutorizacion_Servicios xjif_autorizacionserv;
    private JIFRiesgoCardiovascular frmJIFRiesgoCardiovascular;
    private JIFFInformeLecturaUsuarios xjiffinformelecturausuarios;
    private JIFAsigancionReciboIngresos xJIFAsigancionReciboIngresos;
    private JIF_EgresoPrograma xJIFEgresoPrograma;
    private CitaTerapia xJIFCitaTerapia;
    private GConsultasSqlDAO xGConsultasSqlDAO;
    private Boolean estadoVisualizacion;
    private int idModulo;
    private int demanda;
    private Ingreso ingreso;
    public List<GSexoIdentidadGenero> listGSexoIdentidadGenero;
    public List<GTipoDiscapacidad> listGTipoDiscapacidad;
    private JButton JBSubirArchivo;
    private JButton JBTHuella;
    public JComboBox JCBArl;
    public JComboBox<String> JCBCEspecial;
    public JComboBox JCBCargo;
    public JComboBox JCBCategoriaDiscapacidad;
    public JComboBox JCBGrupo;
    public JComboBox JCBIdentidadGenero;
    public JComboBox JCBJornada;
    public JComboBox JCBLNacimiento;
    public JComboBox JCBLateralidad;
    public JComboBox JCBSegmento;
    public JComboBox JCBSupervisor;
    private JComboBox JCBTipoDocumentoSoporte;
    public JComboBox JCBUnidadN;
    private JCheckBox JCHBCorteConstitucional;
    public JDateChooser JDFechaIngreso;
    private JLabel JLBUnidadN;
    public JPanel JPDAdicionales;
    private JPanel JPDOcupacionales;
    public JPanel JPDPersonales;
    private JPanel JPDPersonales1;
    private JPanel JPDRLaboral;
    private JPanel JPDocAnexos;
    public JSpinner JSPNClaSE;
    public JSpinner JSPNHijos;
    public JSpinner JSPNHorasTrabajadas;
    private JTable JTDocumentos;
    public JTextField JTFFCodifoSap;
    private JTextField JTFRuta;
    public JCheckBox btnNegativo;
    public JCheckBox btnPositivo;
    private ButtonGroup buttonGroup1;
    public JComboBox cboBarrio;
    public JComboBox cboEps;
    public JComboBox cboEstadoCivil;
    public JComboBox cboEtnia;
    public JDateChooser cboFechaNacimiento;
    public JComboBox cboMunicipio;
    public JComboBox cboParentesco;
    public JComboBox cboPobEspecial;
    public JComboBox cboRelacionLaboral;
    public JComboBox cboSangre;
    public JComboBox cboSexo;
    public JComboBox cboTipoAfiliado;
    public JComboBox cboTipoEmpresa;
    public JComboBox cboTipoIdentificacion;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JLabel jLabel3;
    private JLabel jLabel30;
    private JLabel jLabel31;
    private JLabel jLabel32;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JLabel lblEstado;
    public JPanel panelGrupoSangre;
    public JTabbedPane panelPersona;
    private JTextField txtAfiliacion;
    public JTextFieldValidator txtApellido1;
    public JTextFieldValidator txtApellido2;
    public JTextField txtCorreo;
    public JTextField txtDireccion;
    public JTextField txtEdad;
    public JTextFieldValidator txtEdad1;
    public JTextFieldValidator txtHistoria;
    public JFormattedTextField txtHora;
    public JTextFieldValidator txtIdentificacion;
    public JTextField txtIdentificacionFuncionario;
    public JTextField txtNbreCotizante;
    public JTextFieldValidator txtNombre1;
    public JTextFieldValidator txtNombre2;
    public JTextField txtTelefono;
    public JTextField txtTelefono1;
    public ConsultasMySQL consultas = new ConsultasMySQL();
    public Metodos metodos = new Metodos();
    public int comboLleno = 0;
    private String hcAnterior = "";
    public int tipoGrabado = 0;
    public int contador = 0;
    private int encontrado = 0;
    public int grabado = 0;
    public boolean xAbrioDInducida = false;
    public boolean lleno = false;
    public String IdPersona = "0";
    public String xurlfoto = "";
    private List<String> barcode = new ArrayList();
    private Integer itemCombo = -1;
    public int limpiarCampos = 0;
    public boolean validarTipoDoc = true;
    private final GSexoIdentidadGeneroService gSexoIdentidadGeneroService = (GSexoIdentidadGeneroService) Principal.contexto.getBean(GSexoIdentidadGeneroService.class);
    private final IGTipoDiscapacidadService gTipoDiscapacidadService = (IGTipoDiscapacidadService) Principal.contexto.getBean(IGTipoDiscapacidadService.class);
    public boolean citaNp = false;

    public Persona(JInternalFrame nbreFrm) {
        initComponents();
        realizarcasting(nbreFrm);
        activarPestana();
        cargarCombos();
        nuevo();
        this.consultas.cerrarConexionBd();
        mSeleccionar_Datos();
        springStart();
    }

    public Persona(JDialog nbreDial) {
        initComponents();
        realizarcasting(nbreDial);
        activarPestana();
        cargarCombos();
        nuevo();
        this.consultas.cerrarConexionBd();
        mSeleccionar_Datos();
        springStart();
    }

    public Persona(JDialog nbreDial, String xid) {
        initComponents();
        realizarcasting(nbreDial);
        activarPestana();
        cargarCombos();
        nuevo();
        this.consultas.cerrarConexionBd();
        mSeleccionar_Datos();
        springStart();
    }

    public Persona(JInternalFrame nbreFrm, int idModuloCita) {
        this.idModulo = idModuloCita;
        initComponents();
        realizarcasting(nbreFrm);
        activarPestana();
        cargarCombos();
        nuevo();
        this.consultas.cerrarConexionBd();
        mSeleccionar_Datos();
        springStart();
    }

    private void springStart() {
        this.xGConsultasSqlDAO = (GConsultasSqlDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("GConsultasSqlDAO");
    }

    public boolean validadEdad() {
        boolean validarEdad = false;
        int edad = Integer.parseInt(this.metodos.getEdad(this.metodos.formatoAMD1.format(this.cboFechaNacimiento.getDate()))[0][0]);
        String tipoEdad = this.metodos.getEdad(this.metodos.formatoAMD1.format(this.cboFechaNacimiento.getDate()))[0][2];
        if (tipoEdad.equals("1") && edad > 125) {
            validarEdad = true;
        }
        return validarEdad;
    }

    private void mSeleccionar_Datos() {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS")) {
            this.cboEstadoCivil.setSelectedItem("SOLTERO (A)");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("MEDELLIN  - ANTIOQUIA");
            this.cboBarrio.setSelectedItem("MEDELLIN");
            this.JCBLNacimiento.setSelectedItem("MEDELLIN  - ANTIOQUIA");
            this.cboTipoAfiliado.setSelectedItem("Cotizante");
            this.cboEps.setSelectedItem("PARTICULAR");
        } else if (Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
            this.cboEstadoCivil.setSelectedItem("SOLTERO (A)");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("SANTUARIO - ANTIOQUIA");
            this.cboBarrio.setSelectedItem("SANTUARIO");
            this.JCBLNacimiento.setSelectedItem("SABANETA - ANTIOQUIA");
            this.cboTipoAfiliado.setSelectedItem("Cotizante");
            this.cboEps.setSelectedItem("PARTICULAR");
        } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL")) {
            this.cboEstadoCivil.setSelectedItem("SOLTERO (A)");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("SANTUARIO - ANTIOQUIA");
            this.cboBarrio.setSelectedItem("SANTUARIO");
            this.JCBLNacimiento.setSelectedItem("SANTUARIO  - ANTIOQUIA");
            this.cboTipoAfiliado.setSelectedItem("Cotizante");
            this.cboEps.setSelectedItem("PARTICULAR");
        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS")) {
            this.cboSangre.setSelectedItem("-");
            this.panelPersona.setEnabledAt(2, false);
            this.panelPersona.setEnabledAt(3, false);
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.cboEstadoCivil.setSelectedItem("SOLTERO (A)");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("MONTELIBANO - CÓRDOBA");
            this.JCBLNacimiento.setSelectedItem("MONTELIBANO - CÓRDOBA");
            this.cboTipoAfiliado.setSelectedItem("Cotizante");
            this.cboParentesco.setSelectedItem("Otros");
            this.cboRelacionLaboral.setSelectedItem("NO APLICA");
        } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.cboEstadoCivil.setSelectedItem("SOLTERO (A)");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboTipoAfiliado.setSelectedItem("Beneficiario");
            this.cboParentesco.setSelectedItem("Otros");
            this.cboRelacionLaboral.setSelectedItem("NO APLICA");
        } else if (Principal.informacionIps.getNombreIps().equals("ASC EN SALUD TOTAL SAS")) {
            this.cboTipoIdentificacion.setSelectedItem("Cédula de Ciudadanía");
        } else if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
            this.cboParentesco.setSelectedItem("Otros");
            this.cboRelacionLaboral.setSelectedItem("NO APLICA");
            this.cboEstadoCivil.setSelectedItem("SIN DEFINIR");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("CAUCASIA - ANTIOQUIA");
            this.JCBLNacimiento.setSelectedItem("CAUCASIA - ANTIOQUIA");
            this.cboTipoAfiliado.setSelectedItem("Otro");
            this.cboSangre.setSelectedItem("-");
            this.cboPobEspecial.setSelectedItem("Otros");
        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            this.cboParentesco.setSelectedItem("Otros");
            this.cboRelacionLaboral.setSelectedItem("NO APLICA");
            this.cboEstadoCivil.setSelectedItem("SIN DEFINIR");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("TULUA - VALLE");
            this.JCBLNacimiento.setSelectedItem("TULUA - VALLE");
            this.cboEps.setSelectedItem("PARTICULAR");
            this.cboTipoAfiliado.setSelectedItem("Otro");
            this.cboSangre.setSelectedItem("-");
            this.cboPobEspecial.setSelectedItem("Otros");
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
            this.cboParentesco.setSelectedItem("Otros");
            this.cboRelacionLaboral.setSelectedItem("NO APLICA");
            this.cboEstadoCivil.setSelectedItem("SIN DEFINIR");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("PUERTO BERRIO - ANTIOQUIA");
            this.JCBLNacimiento.setSelectedItem("PUERTO BERRIO - ANTIOQUIA");
            this.cboTipoAfiliado.setSelectedItem("Otro");
            this.cboSangre.setSelectedItem("-");
            this.cboPobEspecial.setSelectedItem("Otros");
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
            this.cboParentesco.setSelectedItem("Otros");
            this.cboRelacionLaboral.setSelectedItem("NO APLICA");
            this.cboEstadoCivil.setSelectedItem("SIN DEFINIR");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("ANORI - ANTIOQUIA");
            this.JCBLNacimiento.setSelectedItem("ANORI - ANTIOQUIA");
            this.cboTipoAfiliado.setSelectedItem("Otro");
            this.cboSangre.setSelectedItem("-");
            this.cboPobEspecial.setSelectedItem("Otros");
        } else if (Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
            this.cboEstadoCivil.setSelectedItem("SOLTERO (A)");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("SANTAFE DE BOGOTA - BOGOTÁ");
            this.cboBarrio.setSelectedItem("MEDELLIN");
            this.JCBLNacimiento.setSelectedItem("MEDELLIN  - ANTIOQUIA");
            this.cboTipoAfiliado.setSelectedItem("Cotizante");
            this.cboEps.setSelectedItem("PARTICULAR");
        } else if (Principal.informacionIps.getIdentificacion().equals("98652160")) {
            this.cboParentesco.setSelectedItem("Otros");
            this.cboRelacionLaboral.setSelectedItem("NO APLICA");
            this.cboEstadoCivil.setSelectedItem("SIN DEFINIR");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
            this.cboMunicipio.setSelectedItem("CAUCASIA - ANTIOQUIA");
            this.JCBLNacimiento.setSelectedItem("CAUCASIA - ANTIOQUIA");
            this.cboTipoAfiliado.setSelectedItem("Otro");
            this.cboSangre.setSelectedItem("-");
            this.cboPobEspecial.setSelectedItem("Otros");
            this.JCBCEspecial.setSelectedItem("Normal");
            this.cboTipoAfiliado.setSelectedItem("Particular");
        }
        if (Principal.informacionIps.getIdentificacion().equals("8296850")) {
            this.JCBCEspecial.setSelectedItem("Normal");
            this.cboTipoAfiliado.setSelectedItem("Particular");
            this.cboEtnia.setSelectedItem("OTRAS ETNIAS ND NO DEFINIDO ");
        }
    }

    private void activarPestana() {
        this.panelPersona.setEnabledAt(2, true);
        this.panelPersona.setEnabledAt(3, true);
        this.listaParentesco = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_parentesco WHERE Estado = 0  ORDER BY Nbre ASC", this.listaParentesco, this.cboParentesco);
        this.listaTipoEmpresa = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_tipoempresa WHERE Estado = 0  ORDER BY Nbre ASC", this.listaTipoEmpresa, this.cboTipoEmpresa);
        this.cboTipoEmpresa.setSelectedItem("NO APLICA");
        this.consultas.cerrarConexionBd();
    }

    public String getIdPersona() {
        return this.IdPersona;
    }

    public String getIdSexo() {
        return this.listaSexo[this.cboSexo.getSelectedIndex()];
    }

    public String getHistoria() {
        return this.txtHistoria.getText();
    }

    public String getIdentificacion() {
        return this.txtIdentificacion.getText();
    }

    public String getApellido1() {
        return this.txtApellido1.getText();
    }

    public String getApellido2() {
        return this.txtApellido2.getText();
    }

    public int getEdad() {
        return this.edad;
    }

    public String getNombre1() {
        return this.txtNombre1.getText();
    }

    public String getNombre2() {
        return this.txtNombre2.getText();
    }

    public void setIdPersona(String id) {
        this.IdPersona = id;
    }

    public void setEdad(int xedad) {
        this.edad = xedad;
    }

    public String getXurlfoto() {
        return this.xurlfoto;
    }

    public void setXurlfoto(String xurlfoto) {
        this.xurlfoto = xurlfoto;
    }

    public Boolean getEstadoVisualizacion() {
        return this.estadoVisualizacion;
    }

    public void setEstadoVisualizacion(Boolean estadoVisualizacion) {
        this.estadoVisualizacion = estadoVisualizacion;
    }

    public JComboBox getJCBTipoDocumentoSoporte() {
        return this.JCBTipoDocumentoSoporte;
    }

    public void setJCBTipoDocumentoSoporte(JComboBox JCBTipoDocumentoSoporte) {
        this.JCBTipoDocumentoSoporte = JCBTipoDocumentoSoporte;
    }

    public JTextField getTxtCorreo() {
        return this.txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public String getDireccion() {
        return this.txtDireccion.getText();
    }

    public String getIdTipoIdentifiacion() {
        return this.listaTipoIdentificacion[this.cboTipoIdentificacion.getSelectedIndex()][0];
    }

    public String getIdMunicipio() {
        return this.listaMunicipio[this.cboMunicipio.getSelectedIndex()];
    }

    public String getTelefono() {
        return this.txtTelefono.getText();
    }

    public void buscar(int op) {
        switch (op) {
            case 1:
                mBuscarDatosPersonales(1);
                mBuscarDatosAdicionales(1);
                activarFormularioConsolidadoLiquidacion();
                if (Principal.informacionIps.getEsFpz().intValue() == 0 || Principal.informacionIps.getIdentificacion().equals("901420803")) {
                    cargarDatosFpz();
                    mBuscarDatosOcupacionales();
                }
                mBuscarSoportes();
                break;
            case 2:
                if (!this.txtHistoria.getText().equals(this.hcAnterior)) {
                    mBuscarDatosPersonales(2);
                    mBuscarDatosAdicionales(2);
                    activarFormularioConsolidadoLiquidacion();
                    if (Principal.informacionIps.getEsFpz().intValue() == 0 || Principal.informacionIps.getIdentificacion().equals("901420803")) {
                        cargarDatosFpz();
                        mBuscarDatosOcupacionales();
                    }
                    mBuscarSoportes();
                }
                break;
            case 3:
                BuscarPersona frmBuscar = new BuscarPersona(null, true, this);
                frmBuscar.setVisible(true);
                break;
        }
    }

    private void activarFormularioEncuesta() {
        if (Principal.informacionGeneralPrincipalDTO.getActivarEncuestaIngreso().booleanValue() && !"".equals(getIdPersona()) && Principal.clasefacturacion.frmFacturac != null && Principal.clasefacturacion.frmFacturac.isSelected()) {
            JD_EncuestaIngreso d_EncuestaIngreso = new JD_EncuestaIngreso(null, true, getIdPersona());
            d_EncuestaIngreso.setLocationRelativeTo(Principal.clasefacturacion.frmFacturac);
            d_EncuestaIngreso.setVisible(true);
        }
    }

    public void buscarCotizante() {
        this.sql = "SELECT Id_persona, NUsuario FROM w_persona WHERE (NoDocumento = '" + this.txtIdentificacionFuncionario.getText() + "')";
        ResultSet resultado = this.consultas.traerRs(this.sql);
        try {
            if (resultado.next()) {
                this.idCotizante = resultado.getString(1);
                this.txtNbreCotizante.setText(resultado.getString(2).toUpperCase());
            } else {
                this.idCotizante = "";
                this.txtNbreCotizante.setText("");
            }
            resultado.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void buscarPersona() {
        if (this.encontrado == 0) {
            this.tipoGrabado = 3;
            BuscarPersona frmBuscar = new BuscarPersona(null, true, this);
            frmBuscar.setVisible(true);
        }
    }

    private void buscarPaciente() {
        if (this.frmllamador != null) {
            if (this.frmllamador.equals("Facturac")) {
                this.frmFacturac.frmIngreso.nuevo();
                this.frmFacturac.frmOrdenes.nuevo();
                this.frmFacturac.frmOrdenes.mSeleccionar_Datos();
                this.frmFacturac.frmOrdenes.buscarCitasUsuario(this.IdPersona);
                if (this.frmFacturac.cajaAbierta == 0) {
                    this.frmFacturac.frmOrdenes.xJp_RCaja.mCargar_DatosHistorico();
                }
                this.frmFacturac.frmIngreso.mCargarDatosAdicionales();
                this.frmFacturac.frmIngreso.mEstablecerUltimoNivelEstudio(this.IdPersona);
                this.frmFacturac.buscarConsolidado();
            } else if (this.frmllamador.equals("Vacunacion")) {
                this.frmVacunacion.cargarCarnet();
            } else if (this.frmllamador.equals("CACervixToma")) {
                this.frmTomaCACervix.mBuscarHCitologia();
            } else if (this.frmllamador.equals("CitaTerapia")) {
                this.xJIFCitaTerapia.mCargarClaseCitas(1, this.metodos.formatoAMD1.format(this.cboFechaNacimiento.getDate()), getIdSexo());
                if (Principal.informacionIps.getAplicaHistoricoAnteciones().booleanValue() && !this.hcAnterior.equals(this.txtHistoria.getText())) {
                    JIFCarneCitas frmB = new JIFCarneCitas(null, true, this.IdPersona, "CitaTerapia", this.xJIFCitaTerapia);
                    frmB.setVisible(true);
                }
            } else if (this.frmllamador.equals("Citas")) {
                this.frmCita.mNuevo();
                this.frmCita.cargarClaseCita(1, this.metodos.formatoAMD1.format(this.cboFechaNacimiento.getDate()), getIdSexo());
                if (Principal.informacionIps.getAplicaHistoricoAnteciones().booleanValue() && !this.hcAnterior.equals(this.txtHistoria.getText())) {
                    JIFCarneCitas frmB2 = new JIFCarneCitas(null, true, this.IdPersona, "Citas", this.frmCita);
                    frmB2.setVisible(true);
                }
            } else if (this.frmllamador.equals("jifconsultarayudasdx")) {
                this.frmConsultarAyudasDx.mCargarDatosTabla();
                this.frmConsultarAyudasDx.listarAtenciones();
            } else if (this.frmllamador.equals("jifcargaratencionesmanuales")) {
                this.frmCargarAtencionesMan.mCargarDatosTabla();
                this.frmCargarAtencionesMan.listarIngresos();
            } else if (this.frmllamador.equals("jifconsultarhistoria")) {
                this.frmConsultarHistorial.xgestiodoc.mBuscarDatosHC();
            } else if (this.frmllamador.equals("jifpermisomedicos")) {
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.IdPersona));
            } else if (this.frmllamador.equals("Atencion")) {
                this.frmAtencion.frmIngreso.mBuscarIngresos(this.IdPersona);
                this.frmAtencion.frmIngreso.mCargarDatosAdicionales();
                this.frmAtencion.frmIngreso.mEstablecerUltimoNivelEstudio(this.IdPersona);
            } else if (this.frmllamador.equals("CitaNP")) {
                this.frmCitaNp.frmIngreso.mBuscarIngresos(this.IdPersona);
                this.frmCitaNp.frmIngreso.mCargarDatosAdicionales();
                this.frmCitaNp.frmIngreso.mEstablecerUltimoNivelEstudio(this.IdPersona);
                if (this.cboSexo.getSelectedItem().equals("MASCULINO")) {
                    this.frmCitaNp.JCH_SParto.setEnabled(false);
                } else {
                    this.frmCitaNp.JCH_SParto.setEnabled(true);
                }
                if (Principal.informacionIps.getAplicaHistoricoAnteciones().booleanValue() && !this.hcAnterior.equals(this.txtHistoria.getText())) {
                    JIFCarneCitas frmB3 = new JIFCarneCitas(null, true, this.IdPersona, "CitaNP", this.frmCitaNp);
                    frmB3.setVisible(true);
                }
            } else if (this.frmllamador.equals("jifvisitadomiciliaria") || this.frmllamador.equals("xjifnotasmedicas")) {
                this.frmVisitaDom.mBuscarAatenciones();
            } else if (this.frmllamador.equals("jifjuntamedica")) {
                this.frmJuntaMed.mCargarDatosTabla();
            } else if (this.frmllamador.equals("jifconstanciaservicio") || this.frmllamador.equals("jifconstanciaservicio1")) {
                this.xjifgeneracion.xjpcertificado.mCargarDatosTabla(this.IdPersona);
            } else if (this.frmllamador.equals("jifusuariosistemas")) {
                this.xjifusuarios.mBuscarUsuarioSistema(this.IdPersona);
                this.xjifusuarios.mCargarDatosTablaRH(this.IdPersona);
            } else if (this.frmllamador.equals("jifprofesional")) {
                this.xjifprofesional1.mBuscarProfesional(this.IdPersona);
            } else if (this.frmllamador.equals("jifsupervisor")) {
                this.xjifsupervisor.mCargarDatosTabla(this.IdPersona);
            } else if (this.frmllamador.equals("xJIFRiesgoCardiovascular")) {
                this.frmJIFRiesgoCardiovascular.mCargarHistorico(this.IdPersona);
            } else if (this.frmllamador.equals("xJIFRiesgoObstetrico")) {
                this.frmJIFRiesgoObstetrico.mCargarHistorico(this.IdPersona);
            } else if (this.frmllamador.equals("xjiffinformelecturausuarios") || this.frmllamador.equals("xjiffinformelecturausuarios1")) {
                this.xjiffinformelecturausuarios.mCargarDatosTabla(this.IdPersona);
            } else if (this.frmllamador.equals("jifconsultarcitas")) {
                this.xjifconsultarc.mCargarDatosTabla(this.IdPersona);
            } else if (this.frmllamador.equals("jifmatriculape")) {
                this.xjifmatriculapep.mCargarDatosTabla(this.IdPersona);
            } else if (this.frmllamador.equals("jifregistronota")) {
                this.frmVisitaDom.mBuscarAatenciones();
            } else if (this.frmllamador.equals("jifalertaxusuario1") || this.frmllamador.equals("jifalertaxusuario")) {
                this.xjifalertausuario.mCargarDatosTabla(this.IdPersona);
            } else if (this.frmllamador.equals("jifregistroatencionesp") || this.frmllamador.equals("jifregistroatencionesp1") || this.frmllamador.equals("jifregistroatencionesp2") || this.frmllamador.equals("jifregistroatencionesp3")) {
                this.xjifregistroesp.mNuevo_A();
            } else if (this.frmllamador.equals("jifconfempresa1")) {
                this.xjifempresa.xidpersona = Integer.valueOf(getIdPersona()).intValue();
            } else if (this.frmllamador.equals("jifautorizacion")) {
                this.xjifautorizacionmp.mBuscarUsuarioPEnvioMedicamento(this.IdPersona);
                this.xjifautorizacionmp.mVerificarAlergia(this.IdPersona);
            } else if (this.frmllamador.equals("jifusuariocargo")) {
                this.xjifrhusuarioc.mCargarDatosTabla(this.IdPersona);
                this.xjifrhusuarioc.traerDatosDePago();
            } else if (this.frmllamador.equals("jifgeneraciondescuento")) {
                this.xjifgenerardesc.mBuscarUsuarioFpz(this.IdPersona);
            } else if (this.frmllamador.equals("xjiflecturaoit")) {
                this.xjiflecturao.mCargarDatosTablaH(this.IdPersona);
            } else if (this.frmllamador.equals("xjifpuebaayd") || this.frmllamador.equals("xjifpuebaaydE")) {
                this.xjifpayd.xjpprueba.setIdPersona(Long.valueOf(this.IdPersona).longValue());
                this.xjifpayd.mBuscarDato();
            } else if (this.frmllamador.equals("xjiftestfatiga") || this.frmllamador.equals("xjiftestfatiga")) {
                this.xjiftestfatiga.xjpprueba.setXidpersona(this.IdPersona);
                this.xjiftestfatiga.mBuscarDato();
            } else if (this.frmllamador.equals("xjifingresohta")) {
                this.xJIFUsuarioxPrograma.xJP_PyP_HTA.setXidUsuarioPersona(this.IdPersona);
                this.xJIFUsuarioxPrograma.xJP_PyP_HTA.mConsultarUserProgram();
                this.xJIFUsuarioxPrograma.xJP_PyP_HTA.mBuscarDatosUserProgram();
                this.xJIFUsuarioxPrograma.xJP_PyP_HTA.mBuscarDatosUserProgramEgreso();
            } else if (this.frmllamador.equals("xjifingresodiabetes")) {
                this.xJIFUsuarioxPrograma.xJP_PyP_Diabetes.setXidUsuarioPersona(this.IdPersona);
                this.xJIFUsuarioxPrograma.xJP_PyP_Diabetes.mConsultarUserProgram();
                this.xJIFUsuarioxPrograma.xJP_PyP_Diabetes.mBuscarDatosUserProgram();
                this.xJIFUsuarioxPrograma.xJP_PyP_Diabetes.mBuscarDatosUserProgramEgreso();
            } else if (this.frmllamador.equals("jifgenerarreportexusuario")) {
                this.xjifgenerarexusuario.mCargarDatosTabla();
            } else if (this.frmllamador.equals("xjifnotas")) {
                this.frmVisitaDom.mBuscarAatenciones();
            } else if (this.frmllamador.equals("jifincapacidad")) {
                clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.IdPersona));
                this.xjifincapcidad.xjpincapacidad.mVerificarCruceIncapacidades();
            } else if (this.frmllamador.equals("xjifsolicituddochc") || this.frmllamador.equals("xjifsolicituddochc1")) {
                this.xjifsolicituddoc.mBuscarHistorico();
            } else if (this.frmllamador.equals("xjifcrearpersona")) {
                this.xjifcrearp.mCargarImagen(getXurlfoto());
            } else if (this.frmllamador.equals("xjifhcodontologia")) {
                this.xjifhcodontofica.mCargarDatosHCUsuario();
            } else if (this.frmllamador.equals("jifconsultarexamenesusuario2") || this.frmllamador.equals("jifconsultarexamenesusuario") || this.frmllamador.equals("jifconsultarexamenesusuario1") || this.frmllamador.equals("jifconsultarRemOrd") || this.frmllamador.equals("jifconsultarRemOrdEnfer") || this.frmllamador.equals("jifconsultarRemOrdHist") || this.frmllamador.equals("jiconsultarRemOrdFacturacion")) {
                this.xjifexamenxuser.mCargarDatos();
                this.xjifexamenxuser.mCargarDatos1();
                this.xjifexamenxuser.mCargarOrdenes();
                this.xjifexamenxuser.mCargarRemisiones();
                this.xjifexamenxuser.mCargarRx();
                this.xjifexamenxuser.mCargarDatosTablaAudiometria();
                this.xjifexamenxuser.mCargarDatoEspirometria();
                this.xjifexamenxuser.mCargarDatosVisio();
                this.xjifexamenxuser.mCargarDatosOMA();
            } else if (this.frmllamador.equals("Despachos")) {
                this.xjifdespachos.mVerificarAlergia(this.IdPersona);
            } else if (this.frmllamador.equals("xjifR4505")) {
                this.xJIFRegistro4505.mBuscaInfoPaciente();
            } else if (this.frmllamador.equals("xjifautorizacion_servicios")) {
                this.xjif_autorizacionserv.mCargarDatosT_Historico(this.IdPersona);
            } else if (this.frmllamador.equals("xjifasignacionreciboingresos")) {
                this.xJIFAsigancionReciboIngresos.mCargarCombo();
                this.xJIFAsigancionReciboIngresos.mCargarDatosTabla();
            } else if (this.frmllamador.equals("xjifegresoprograma")) {
                this.xJIFEgresoPrograma.mLimpiar();
                this.xJIFEgresoPrograma.cargarHistoricoProgramasPaciente(this.IdPersona);
            }
            mConsultarALerta();
            mConsultarValidacionxUsuario();
        }
    }

    public void mBuscarDatosPersonales(int op) {
        String sql = op == 1 ? "SELECT g_usuario.Id_persona, `g_usuario`.`NoHistoria` , `g_tipoidentificacion`.`Nbre` AS tipoDoc  , `g_persona`.`NoDocumento`, `g_persona`.`Apellido1`, `g_persona`.`Apellido2` , `g_persona`.`Nombre1`, `g_persona`.`Nombre2` , `g_persona`.`FechaNac`, `g_persona`.`Edad` , `g_sexo`.`Nbre` AS Sexo  , cc_terceros.RazonSocialCompleta AS empresa  , `g_usuario`.`Estado`, g_persona.GrupoSangre, g_persona.Rh, g_sexo.Id AS IdSexo, IF(g_persona.UrlFoto='', '',g_persona.UrlFoto) as UrlFoto, g_persona.esCorteConstitucional,  gsig.nombre identidadGenero, gtd.nombre categoriaDiscapacidad, g_persona.TipoPersona, `g_persona`.`HoraNac`  FROM `g_usuario` INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoidentificacion` ON (`g_persona`.`Id_TipoIdentificacion` = `g_tipoidentificacion`.`Id`) INNER JOIN `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)INNER JOIN `cc_terceros` ON (`g_usuario`.`Id_EmpresaCont` = `cc_terceros`.`Id`)  inner join g_sexo_identidad_genero gsig  on (gsig.id=g_persona.idIdentidadG)\n inner join g_tipo_discapacidad gtd on (gtd.id=g_persona.idTipoDiscapacidad) WHERE (g_persona.`Id`>0 AND g_persona.Id = '" + getIdPersona() + "')" : "SELECT g_usuario.Id_persona, `g_usuario`.`NoHistoria` , `g_tipoidentificacion`.`Nbre` AS tipoDoc  , `g_persona`.`NoDocumento`, `g_persona`.`Apellido1`, `g_persona`.`Apellido2` , `g_persona`.`Nombre1`, `g_persona`.`Nombre2` , `g_persona`.`FechaNac`, `g_persona`.`Edad` , `g_sexo`.`Nbre` AS Sexo  , cc_terceros.RazonSocialCompleta AS empresa  , `g_usuario`.`Estado`, g_persona.GrupoSangre, g_persona.Rh, g_sexo.Id AS IdSexo, IF(g_persona.UrlFoto='', '',g_persona.UrlFoto) as UrlFoto, g_persona.esCorteConstitucional,  gsig.nombre identidadGenero, gtd.nombre categoriaDiscapacidad, g_persona.TipoPersona, `g_persona`.`HoraNac`  FROM `g_usuario` INNER JOIN `g_persona` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN `g_tipoidentificacion` ON (`g_persona`.`Id_TipoIdentificacion` = `g_tipoidentificacion`.`Id`) INNER JOIN `g_sexo` ON (`g_persona`.`Id_Sexo` = `g_sexo`.`Id`)INNER JOIN `cc_terceros` ON (`g_usuario`.`Id_EmpresaCont` = `cc_terceros`.`Id`)  inner join g_sexo_identidad_genero gsig  on (gsig.id=g_persona.idIdentidadG)\n inner join g_tipo_discapacidad gtd on (gtd.id=g_persona.idTipoDiscapacidad) WHERE (g_persona.`Id`>0 AND g_usuario.NoHistoria = '" + this.txtHistoria.getText() + "')";
        System.out.println(sql);
        ResultSet rs = this.consultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                this.encontrado = 1;
                this.tipoGrabado = 1;
                setIdPersona(rs.getString("Id_persona"));
                this.txtHistoria.setText(rs.getString("NoHistoria"));
                this.cboTipoIdentificacion.setSelectedItem(rs.getString("tipoDoc"));
                this.txtIdentificacion.setText(rs.getString("NoDocumento"));
                this.txtApellido1.setText(rs.getString("Apellido1"));
                this.txtApellido2.setText(rs.getString("Apellido2"));
                this.txtNombre1.setText(rs.getString("Nombre1"));
                this.txtNombre2.setText(rs.getString("Nombre2"));
                if (rs.getString("FechaNac").equals("0000-00-00")) {
                    this.cboFechaNacimiento.setDate(this.metodos.getFechaActual());
                } else if (rs.getDate("FechaNac").getTime() > this.metodos.getFechaActual().getTime()) {
                    this.metodos.mostrarMensaje("La FEcha de Nacimiento es mayor a la Fecha Actual\nSe cambiará por la fecha de hoy.\nPor favor corrija este dato antes de Grabar");
                    this.cboFechaNacimiento.setDate(this.metodos.getFechaActual());
                    this.cboFechaNacimiento.requestFocus();
                } else {
                    this.cboFechaNacimiento.setDate(rs.getDate("FechaNac"));
                }
                this.txtHora.setText(rs.getString("HoraNac"));
                switch (rs.getInt("TipoPersona")) {
                    case 0:
                        this.JCBCEspecial.setSelectedItem("Normal");
                        break;
                    case 1:
                        this.JCBCEspecial.setSelectedItem("Discapacitado");
                        break;
                    case 2:
                        this.JCBCEspecial.setSelectedItem("Embarazada");
                        break;
                    case 3:
                        this.JCBCEspecial.setSelectedItem("Tercera edad");
                        break;
                    case 4:
                        this.JCBCEspecial.setSelectedItem("Niño");
                        break;
                }
                this.cboSexo.setSelectedItem(rs.getString("sexo"));
                this.JCBIdentidadGenero.setSelectedItem(rs.getString("identidadGenero"));
                this.JCBCategoriaDiscapacidad.setSelectedItem(rs.getString("categoriaDiscapacidad"));
                this.cboEps.setSelectedItem(rs.getString("empresa"));
                this.lblEstado.setText(rs.getString("Estado"));
                if (rs.getInt("esCorteConstitucional") == 0) {
                    this.JCHBCorteConstitucional.setSelected(false);
                } else {
                    this.JCHBCorteConstitucional.setSelected(true);
                }
                this.cboSangre.setSelectedItem(rs.getString("GrupoSangre"));
                if (rs.getString("Rh").equals("0")) {
                    this.btnNegativo.setSelected(true);
                    this.rh = 0;
                } else {
                    this.btnPositivo.setSelected(true);
                    this.rh = 1;
                }
                if (rs.getInt("Estado") == 0) {
                    marcarEstado(0);
                } else {
                    marcarEstado(1);
                }
                String xsexo = rs.getString("IdSexo");
                if (rs.getString("Sexo").equals("MASCULINO")) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL EliminarAntGinecologicosM(?)}");
                    Throwable th = null;
                    try {
                        try {
                            cs.setInt("mdatos", Integer.valueOf(this.IdPersona).intValue());
                            cs.execute();
                            if (cs != null) {
                                if (0 != 0) {
                                    try {
                                        cs.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                } else {
                                    cs.close();
                                }
                            }
                            xct.cerrarConexionBd();
                        } finally {
                        }
                    } finally {
                    }
                }
                if (!Principal.informacionIps.getIdentificacion().equals("8296850")) {
                    buscarPaciente();
                }
                mActualizarEdad();
                if (Principal.informacionGeneralPrincipalDTO.getActivarFormularioDemandaInducida().booleanValue() && !this.xAbrioDInducida) {
                    String sql2 = "SELECT `g_tipoprograma`.`Nbre` , UCASE(`f_tipoprocedimiento`.`Nbre`) AS `TipoServicio` , UCASE(`g_procedimiento`.`Nbre`) AS `Nprocedimiento`, `p_demanda_inducida`.`Peridiocidad` , INTERVAL((SELECT Calcula_Edad('" + this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()) + "')),`p_demanda_inducida`.`EdadI`, `p_demanda_inducida`.`EdadF`) AS `Esta` FROM  `p_demanda_inducida` INNER JOIN  `g_procedimiento`  ON (`p_demanda_inducida`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `f_tipoprocedimiento`  ON (`g_procedimiento`.`Id_tipoprocedimiento` = `f_tipoprocedimiento`.`Id`) INNER JOIN  `g_tipoprograma`  ON (`p_demanda_inducida`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) WHERE (`p_demanda_inducida`.`Id_Sexo` ='" + xsexo + "'  AND INTERVAL((SELECT Calcula_Edad('" + this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()) + "')),`p_demanda_inducida`.`EdadI`, `p_demanda_inducida`.`EdadF`) =1) GROUP BY `g_procedimiento`.`Id` ORDER BY `TipoServicio` ASC, `Nprocedimiento` ASC ";
                    ConsultasMySQL xct2 = new ConsultasMySQL();
                    ResultSet xrs = xct2.traerRs(sql2);
                    Throwable th3 = null;
                    try {
                        try {
                            if (xrs.next()) {
                                JDDemandaInducida xjdemanda = new JDDemandaInducida(null, true, xsexo, this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()), getIdPersona());
                                xjdemanda.setLocation((this.metodos.getAnchoPantalla() / 2) / 2, (this.metodos.getAltoPantalla() / 2) / 2);
                                xjdemanda.setVisible(true);
                            }
                            if (xrs != null) {
                                if (0 != 0) {
                                    try {
                                        xrs.close();
                                    } catch (Throwable th4) {
                                        th3.addSuppressed(th4);
                                    }
                                } else {
                                    xrs.close();
                                }
                            }
                            xct2.cerrarConexionBd();
                            this.xAbrioDInducida = true;
                        } finally {
                        }
                    } finally {
                    }
                }
                this.hcAnterior = this.txtHistoria.getText();
                activarFormularioEncuesta();
            } else if (!this.barcode.isEmpty()) {
                if (this.barcode.size() == 8) {
                    this.txtHistoria.setText(this.barcode.get(0));
                    this.cboTipoIdentificacion.setSelectedItem("Cédula de Ciudadanía");
                    this.txtIdentificacion.setText(this.barcode.get(0));
                    this.txtApellido1.setText(this.barcode.get(1));
                    this.txtApellido2.setText(this.barcode.get(2));
                    this.txtNombre1.setText(this.barcode.get(3));
                    this.txtNombre2.setText(this.barcode.get(4));
                    if (this.barcode.get(5).equals("M")) {
                        this.cboSexo.setSelectedItem("MASCULINO");
                    } else {
                        this.cboSexo.setSelectedItem("FEMENINO");
                    }
                    this.cboFechaNacimiento.setDate(getPasarTextoAFecha(this.barcode.get(6)));
                    this.cboSangre.setSelectedItem(this.barcode.get(7).replace("+", "").replace("-", ""));
                    if (this.barcode.get(7).contains("-")) {
                        this.btnNegativo.setSelected(true);
                        this.rh = 0;
                    } else {
                        this.btnPositivo.setSelected(true);
                        this.rh = 0;
                    }
                }
            } else if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
                String tmp = this.txtHistoria.getText();
                this.tipoGrabado = 3;
                this.encontrado = 0;
                nuevo();
                this.hcAnterior = tmp;
                this.txtHistoria.setText(tmp);
                this.txtIdentificacion.setText(tmp);
            } else if (!Principal.informacionIps.getIdentificacion().equals("8296850") || !Principal.informacionIps.getIdentificacion().equals("900895500")) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Desea utilizar herramienta;\npara creación automatica de N° de identificación?", "USUARIO NUEVO", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    JDCreacionNDocumento xjdcreacion = new JDCreacionNDocumento(null, true, this);
                    xjdcreacion.setVisible(true);
                } else {
                    String tmp2 = this.txtHistoria.getText();
                    this.tipoGrabado = 3;
                    this.encontrado = 0;
                    if (this.limpiarCampos == 0) {
                        nuevo();
                    } else {
                        nuevo1();
                    }
                    this.hcAnterior = tmp2;
                    this.txtHistoria.setText(tmp2);
                    this.txtIdentificacion.setText(tmp2);
                }
            } else {
                this.txtHistoria.getText();
                this.txtIdentificacion.setText(this.txtHistoria.getText());
                this.cboEps.setSelectedIndex(0);
                this.cboEtnia.setSelectedIndex(2);
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        this.barcode.clear();
    }

    public void mBuscarDatosAdicionales(int op) {
        String sql = op == 1 ? "SELECT `g_estadocivil`.`Nbre` AS EstadoCivi , UCASE(`g_tipo_etnia`.`Nbre`) AS Etnia, `g_municipio_departamento`.`NMunicipio` AS MunDptoR , `g_barrio`.`Nbre` AS Barrio, `g_municipio_departamento1`.`NMunicipio` AS MunDptoNac, `g_persona`.`Direccion`, `g_persona`.`Telefono` , `g_persona`.`Correo`, `g_tipoafiliado`.`Nbre` AS TipoAfiliado , `g_usuario`.`NAfiliacion`, `g_persona`.`Movil`, g_poblacion_especial.Nbre AS pobEspecial FROM `g_persona` INNER JOIN `g_estadocivil` ON (`g_persona`.`Id_EstadoCivil` = `g_estadocivil`.`Id`) INNER JOIN `g_tipo_etnia` ON (`g_persona`.`Id_Etnia` = `g_tipo_etnia`.`Id`) INNER JOIN `g_municipio_departamento` ON (`g_persona`.`Id_Municipio` = `g_municipio_departamento`.`Id`) INNER JOIN `g_barrio`ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`) INNER JOIN `g_municipio_departamento1` ON (`g_persona`.`Id_MunicipioNac` = `g_municipio_departamento1`.`Id`) INNER JOIN `g_usuario` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `g_poblacion_especial`  ON (`g_usuario`.`IdPoblacionEspecial` = `g_poblacion_especial`.`Id`) INNER JOIN `g_tipoafiliado` ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`) WHERE (g_persona.`Id`>0 AND g_persona.Id = '" + getIdPersona() + "')" : "SELECT `g_estadocivil`.`Nbre` AS EstadoCivi , UCASE(`g_tipo_etnia`.`Nbre`) AS Etnia, `g_municipio_departamento`.`NMunicipio` AS MunDptoR , `g_barrio`.`Nbre` AS Barrio, `g_municipio_departamento1`.`NMunicipio` AS MunDptoNac, `g_persona`.`Direccion`, `g_persona`.`Telefono` , `g_persona`.`Correo`, `g_tipoafiliado`.`Nbre` AS TipoAfiliado , `g_usuario`.`NAfiliacion`, `g_persona`.`Movil`, g_poblacion_especial.Nbre AS pobEspecial FROM `g_persona` INNER JOIN `g_estadocivil` ON (`g_persona`.`Id_EstadoCivil` = `g_estadocivil`.`Id`) INNER JOIN `g_tipo_etnia` ON (`g_persona`.`Id_Etnia` = `g_tipo_etnia`.`Id`) INNER JOIN `g_municipio_departamento` ON (`g_persona`.`Id_Municipio` = `g_municipio_departamento`.`Id`) INNER JOIN `g_barrio`ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`) INNER JOIN `g_municipio_departamento1` ON (`g_persona`.`Id_MunicipioNac` = `g_municipio_departamento1`.`Id`) INNER JOIN `g_usuario` ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `g_poblacion_especial`  ON (`g_usuario`.`IdPoblacionEspecial` = `g_poblacion_especial`.`Id`) INNER JOIN `g_tipoafiliado` ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`) WHERE (g_persona.`Id`>0 AND g_usuario.NoHistoria = '" + this.txtHistoria.getText() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet rs = xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                this.cboEstadoCivil.setSelectedItem(rs.getString("EstadoCivi"));
                this.cboEtnia.setSelectedItem(rs.getString("Etnia"));
                this.cboMunicipio.setSelectedItem(rs.getString("MunDptoR"));
                this.cboBarrio.setSelectedItem(rs.getString("Barrio"));
                this.JCBLNacimiento.setSelectedItem(rs.getString("MunDptoNac"));
                this.txtDireccion.setText(rs.getString("Direccion"));
                this.txtTelefono.setText(rs.getString("Telefono"));
                this.txtTelefono1.setText(rs.getString("Movil"));
                this.txtCorreo.setText(rs.getString("Correo"));
                this.cboTipoAfiliado.setSelectedItem(rs.getString("TipoAfiliado"));
                this.txtAfiliacion.setText(rs.getString("NAfiliacion"));
                this.cboPobEspecial.setSelectedItem(rs.getString("pobEspecial"));
            }
            rs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            xct.mostrarErrorSQL(ex);
        }
    }

    public void mBuscarDatosOcupacionales() {
        String sql = "SELECT   `g_cargos`.`Nbre` AS Cargo, CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) AS Supervisor, `so_tipo_segmento`.`Nbre` AS segmento , cc_terceros.RazonSocialCompleta AS empresa , `so_tipo_grupo`.`Nbre` AS grupo , `g_usuario`.`NHijo`, `g_usuario`.`CSEconomica` , `g_usuario`.`FechaIngreso` , g_so_lateralidad.Nbre AS Lateralidad, g_so_jornada.Nbre AS Jornada  FROM `g_usuario` INNER JOIN `so_tipo_grupo` ON (`g_usuario`.`Id_TipoGrupo` = `so_tipo_grupo`.`Id`) INNER JOIN `so_tipo_segmento` ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) INNER JOIN `g_persona` ON (`g_usuario`.`Id_Supervisor` = `g_persona`.`Id`) INNER JOIN `g_cargos` ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`) INNER JOIN `cc_terceros`  ON (`g_usuario`.`Id_Arl` = `cc_terceros`.`Id`)  INNER JOIN `g_so_lateralidad`  ON (`g_usuario`.`Id_Lateralidad` = `g_so_lateralidad`.`Id`)  INNER JOIN `g_so_jornada` ON (`g_usuario`.`Id_Horario` = `g_so_jornada`.`Id`) INNER JOIN `g_poblacion_especial`  ON (`g_usuario`.`IdPoblacionEspecial` = `g_poblacion_especial`.`Id`) WHERE (g_usuario.`Id_persona`='" + getIdPersona() + "')";
        ResultSet rs = this.consultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.first();
                this.JCBCargo.setSelectedItem(rs.getString("Cargo"));
                this.JCBSupervisor.setSelectedItem(rs.getString("Supervisor"));
                this.JCBSegmento.setSelectedItem(rs.getString("segmento"));
                this.JCBArl.setSelectedItem(rs.getString("empresa"));
                this.JCBGrupo.setSelectedItem(rs.getString("grupo"));
                this.JCBLateralidad.setSelectedItem(rs.getString("Lateralidad"));
                this.JCBJornada.setSelectedItem(rs.getString("Jornada"));
                this.JSPNHijos.setValue(Long.valueOf(rs.getLong("NHijo")));
                this.JSPNClaSE.setValue(Long.valueOf(rs.getLong("CSEconomica")));
                if (rs.getDate("FechaIngreso") == null) {
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date d = df.parse("01/01/1900");
                        this.JDFechaIngreso.setDate(d);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.JDFechaIngreso.setDate(rs.getDate("FechaIngreso"));
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarBarrio() {
        this.cboBarrio.removeAllItems();
        this.listaBarrio = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_barrio WHERE (Id_Municipio ='" + this.listaMunicipio[this.cboMunicipio.getSelectedIndex()] + "') ORDER BY Nbre ASC", this.listaBarrio, this.cboBarrio);
        this.consultas.cerrarConexionBd();
    }

    public final void cargarCombos() {
        this.listGSexoIdentidadGenero = new ArrayList();
        this.listGTipoDiscapacidad = new ArrayList();
        llenarComboIdentidadGenero(true);
        llenarComboIncapacidad();
        this.sql = "SELECT g_municipio.Id, UCASE(CONCAT(g_municipio.Nbre,' - ', g_departamento.Nbre)) AS NMunicipio   FROM g_municipio INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) WHERE (g_municipio.Estado =0) ORDER BY g_municipio.Nbre ASC, g_departamento.Nbre ASC ";
        this.listaTipoIdentificacion = this.consultas.llenarComboyLista("SELECT Id, Nbre, TamMin, TamMax, RMinEdad, RMaxEdad, ExpresionReg,idNum  \nFROM g_tipoidentificacion WHERE Estado = 0 ORDER BY Nbre ASC", this.listaTipoIdentificacion, this.cboTipoIdentificacion, 8);
        this.consultas.cerrarConexionBd();
        this.listaSexo = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_sexo WHERE Estado = 0 ORDER BY Nbre ASC", this.listaSexo, this.cboSexo);
        this.listaEmpresa = this.consultas.llenarComboyLista("SELECT cc_terceros.Id, cc_terceros.`RazonSocialCompleta`, f_empresacontxconvenio.Id FROM g_empresacont INNER JOIN cc_terceros  ON (g_empresacont.Id_empresa = cc_terceros.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  WHERE (cc_terceros.EsEps=1) GROUP BY cc_terceros.Id ORDER BY cc_terceros.RazonSocialCompleta ASC", this.listaEmpresa, this.cboEps, 3);
        this.consultas.cerrarConexionBd();
        this.listaEstadoCivil = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_estadocivil WHERE Estado = 0  ORDER BY Nbre ASC", this.listaEstadoCivil, this.cboEstadoCivil);
        this.listaMunicipio = this.consultas.llenarCombo(this.sql, this.listaMunicipio, this.cboMunicipio);
        this.listaMunicipioNac = this.consultas.llenarCombo(this.sql, this.listaMunicipioNac, this.JCBLNacimiento);
        this.listaTipoAfiliado = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_tipoafiliado WHERE Estado = 0  ORDER BY Nbre ASC", this.listaTipoAfiliado, this.cboTipoAfiliado);
        this.listaOcupacion = this.consultas.llenarCombo("SELECT `Id` , UCASE(`Nbre`) FROM `g_tipo_etnia` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.listaOcupacion, this.cboEtnia);
        this.listacargo = this.consultas.llenarCombo("SELECT `Id`, `Nbre` FROM `g_cargos` WHERE (`Estado` =1) ORDER BY Nbre ASC", this.listacargo, this.JCBCargo);
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.listaArl = this.consultas.llenarCombo("SELECT `Id`  , `RazonSocialCompleta` FROM `cc_terceros` WHERE (`Estado` =1 ) ORDER BY RazonSocialCompleta ASC", this.listaArl, this.JCBArl);
        } else {
            this.listaArl = this.consultas.llenarCombo("SELECT `Id`  , `RazonSocialCompleta` FROM `cc_terceros` WHERE (`Estado` =1 ) ORDER BY RazonSocialCompleta ASC", this.listaArl, this.JCBArl);
        }
        this.listagrupo = this.consultas.llenarCombo("SELECT `Id`, `Nbre`FROM `so_tipo_grupo` WHERE (`Estado` =1) ORDER BY Nbre ASC", this.listagrupo, this.JCBGrupo);
        this.listalateralidad = this.consultas.llenarCombo("SELECT `Id`, `Nbre`FROM `g_so_lateralidad` WHERE (`Estado` =1) ORDER BY Nbre ASC", this.listalateralidad, this.JCBLateralidad);
        this.listajornada = this.consultas.llenarCombo("SELECT `Id` , `Nbre` FROM `g_so_jornada` WHERE (`Estado` =1)", this.listajornada, this.JCBJornada);
        this.listapobEspecial = this.consultas.llenarCombo("SELECT  `Id` , `Nbre` FROM `g_poblacion_especial` WHERE (`Estado` =1) ORDER BY Nbre ASC", this.listapobEspecial, this.cboPobEspecial);
        this.cboPobEspecial.setSelectedItem("No definido");
        this.xidSoporteDoc = this.consultas.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipo_documento_soporte` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xidSoporteDoc, this.JCBTipoDocumentoSoporte);
        this.JCBTipoDocumentoSoporte.setSelectedIndex(-1);
        if (Principal.informacionIps.getEsFpz().intValue() == 1 || Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.cboRelacionLaboral.removeAllItems();
            this.listaRelacionLaboral = this.consultas.llenarComboyLista("SELECT Id, Nbre, TopeFormula, Vminimo, Pminimo, Pmaximo, Tope, CRecuperacion FROM g_relacionlaboral WHERE (Estado =0 AND TipoEmpresa = '" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "') ORDER BY Nbre ASC", this.listaRelacionLaboral, this.cboRelacionLaboral, 8);
            this.cboRelacionLaboral.setSelectedIndex(0);
            this.consultas.cerrarConexionBd();
            this.JCBUnidadN.removeAllItems();
            this.xidunidadnegocio = this.consultas.llenarCombo("SELECT Id, UCASE(Nbre) AS Nbre , Id_TipoEmpresa FROM g_tipounidadnegocio WHERE (Id_TipoEmpresa ='" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "' AND Estado =0) ORDER BY Nbre ASC", this.xidunidadnegocio, this.JCBUnidadN);
            this.JCBUnidadN.setSelectedIndex(0);
            this.JCBSegmento.removeAllItems();
            this.listasegmento = this.consultas.llenarCombo("SELECT  `Id`, `Nbre` FROM `so_tipo_segmento` WHERE (`Estado` =1 and IdTipoEmpresa='" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "' ) ORDER BY Nbre ASC", this.listasegmento, this.JCBSegmento);
            this.JCBSupervisor.removeAllItems();
            this.listasupervisor = this.consultas.llenarComboyLista("SELECT `g_supervisor`.`Id_persona`,CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) `NUsuario`,`g_persona`.Correo Corre  FROM `g_supervisor`  INNER JOIN `g_persona`  ON (`g_supervisor`.`Id_Persona` = `g_persona`.`Id`) WHERE (`g_supervisor`.`Id_TipoEmpresa`='" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "' AND `g_supervisor`.`Estado` =0) ORDER BY CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`, ' ', g_persona.`Nombre1`, ' ', g_persona.`Nombre2`) ASC", this.listasupervisor, this.JCBSupervisor, 3);
            if (this.listasupervisor.length > 0) {
                this.JCBSupervisor.setSelectedIndex(0);
            }
            this.consultas.cerrarConexionBd();
        }
        this.consultas.cerrarConexionBd();
        this.comboLleno = 1;
        limpiarCombos();
    }

    private void llenarComboIdentidadGenero(boolean filtro) {
        this.JCBIdentidadGenero.removeAllItems();
        this.listGSexoIdentidadGenero = new ArrayList();
        if (filtro) {
            this.listGSexoIdentidadGenero = this.gSexoIdentidadGeneroService.findByAll();
        } else {
            GSexo gSexo = new GSexo();
            gSexo.setId(this.listaSexo[this.cboSexo.getSelectedIndex()]);
            this.listGSexoIdentidadGenero = this.gSexoIdentidadGeneroService.findByIdSexo(gSexo);
        }
        if (!this.listGSexoIdentidadGenero.isEmpty()) {
            this.listGSexoIdentidadGenero.forEach(e -> {
                this.JCBIdentidadGenero.addItem(e.getNombre());
            });
        }
        if (this.listGSexoIdentidadGenero.size() > 1) {
            this.JCBIdentidadGenero.setSelectedIndex(-1);
        }
    }

    private void llenarComboIncapacidad() {
        this.JCBCategoriaDiscapacidad.removeAllItems();
        this.listGTipoDiscapacidad = new ArrayList();
        this.listGTipoDiscapacidad = this.gTipoDiscapacidadService.listarGTipoDiscapacidad();
        if (!this.listGTipoDiscapacidad.isEmpty()) {
            this.listGTipoDiscapacidad.forEach(e -> {
                this.JCBCategoriaDiscapacidad.addItem(e.getNombre());
            });
        }
        if (this.listGTipoDiscapacidad.size() > 1) {
            this.JCBCategoriaDiscapacidad.setSelectedIndex(-1);
        }
    }

    public void cargarDatosFpz() {
        this.panelPersona.setSelectedIndex(2);
        this.sql = "SELECT g_parentesco.Nbre, g_tipoempresa.Nbre, g_relacionlaboral.Nbre, g_persona.nodocumento, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2, g_persona.Id, ucase(g_tipounidadnegocio.Nbre),  g_persona.Codigo1Sap FROM g_parentesco INNER JOIN g_usuario_fpz ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN g_tipoempresa ON (g_tipoempresa.Id = g_usuario_fpz.Id_Empresa) INNER JOIN g_relacionlaboral ON (g_usuario_fpz.Id_RelacionLaboral=  g_relacionlaboral.Id) INNER JOIN g_persona  ON (g_usuario_fpz.Id_PersDescuento = g_persona.Id) INNER JOIN g_tipounidadnegocio ON (g_usuario_fpz.Id_UnidadN= g_tipounidadnegocio.Id)  WHERE (Id_Persona ='" + getIdPersona() + "')";
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet rsfpz = xct.traerRs(this.sql);
            Throwable th = null;
            try {
                try {
                    if (rsfpz.next()) {
                        String rl = rsfpz.getString(3);
                        String un = rsfpz.getString(10);
                        this.cboParentesco.setSelectedItem(rsfpz.getString(1));
                        this.txtIdentificacionFuncionario.setText(rsfpz.getString(4));
                        this.txtNbreCotizante.setText(rsfpz.getString(5) + " " + rsfpz.getString(6) + " " + rsfpz.getString(7) + " " + rsfpz.getString(8));
                        this.idCotizante = rsfpz.getString(9);
                        this.cboTipoEmpresa.setSelectedItem(rsfpz.getString(2));
                        this.cboRelacionLaboral.setSelectedItem(rl);
                        this.JCBUnidadN.setSelectedItem(un);
                        this.txtIdentificacionFuncionario.requestFocus();
                        this.txtIdentificacionFuncionario.transferFocus();
                        this.JTFFCodifoSap.setText(rsfpz.getString("Codigo1Sap"));
                    }
                    if (rsfpz != null) {
                        if (0 != 0) {
                            try {
                                rsfpz.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rsfpz.close();
                        }
                    }
                    xct.cerrarConexionBd();
                    this.panelPersona.setSelectedIndex(0);
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarRelacionLaboral() {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.JCBSupervisor.removeAllItems();
        this.JCBUnidadN.removeAllItems();
        this.cboRelacionLaboral.removeAllItems();
        this.listaRelacionLaboral = xct.llenarComboyLista("SELECT Id, Nbre, TopeFormula, Vminimo, Pminimo, Pmaximo, Tope, CRecuperacion FROM g_relacionlaboral WHERE (Estado =0 AND TipoEmpresa = '" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "') ORDER BY Nbre ASC", this.listaRelacionLaboral, this.cboRelacionLaboral, 8);
        if (this.listaRelacionLaboral.length > 0) {
            this.cboRelacionLaboral.setSelectedIndex(0);
        }
        this.consultas.cerrarConexionBd();
        this.xidunidadnegocio = xct.llenarCombo("SELECT Id, UCASE(Nbre) AS Nbre , Id_TipoEmpresa FROM g_tipounidadnegocio WHERE (Id_TipoEmpresa ='" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "' AND Estado =0) ORDER BY Nbre ASC", this.xidunidadnegocio, this.JCBUnidadN);
        if (this.xidunidadnegocio.length > 0) {
            this.JCBUnidadN.setSelectedIndex(0);
        }
        this.consultas.cerrarConexionBd();
        this.sql = "SELECT `g_supervisor`.`Id_persona`,`persona`.`NUsuario`,`persona`.`Corre` FROM `g_supervisor`  INNER JOIN `persona`  ON (`g_supervisor`.`Id_Persona` = `persona`.`Id_persona`) WHERE (`g_supervisor`.`Id_TipoEmpresa`='" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "' AND `g_supervisor`.`Estado` =0) ORDER BY `persona`.`NUsuario` ASC";
        this.listasupervisor = xct.llenarComboyLista(this.sql, this.listasupervisor, this.JCBSupervisor, 3);
        if (this.listasupervisor.length > 0) {
            this.JCBSupervisor.setSelectedIndex(0);
        }
        this.JCBSegmento.removeAllItems();
        this.listasegmento = this.consultas.llenarCombo("SELECT  `Id`, `Nbre` FROM `so_tipo_segmento` WHERE (`Estado` =1 and IdTipoEmpresa='" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "' ) ORDER BY Nbre ASC", this.listasegmento, this.JCBSegmento);
        this.consultas.cerrarConexionBd();
        xct.cerrarConexionBd();
    }

    public void crearPersona() {
        int xtipopersona = 0;
        if (Principal.informacionGeneralPrincipalDTO.getAplicaAtencionPreferencial().booleanValue()) {
            xtipopersona = Principal.informacionGeneralPrincipalDTO.getAtencionPreferencial().intValue();
        }
        this.sql = "INSERT IGNORE INTO g_persona (Id_TipoIdentificacion, NoDocumento, Nombre1, Nombre2, Apellido1, Apellido2, Id_Sexo,idTipoDiscapacidad, idIdentidadG,  FechaNac,HoraNac,Id_Municipio, Id_MunicipioNac, Direccion, Id_Barrio, Telefono, Movil, Correo,Codigo1Sap, UrlFoto, Id_EstadoCivil, TipoPersona, Id_Etnia, NAfiliacion, GrupoSangre, Rh,";
        this.sql += "Fecha, UsuarioS) VALUES('" + this.listaTipoIdentificacion[this.cboTipoIdentificacion.getSelectedIndex()][0] + "','" + this.txtIdentificacion.getText() + "','" + this.txtNombre1.getText().toUpperCase() + "','" + this.txtNombre2.getText().toUpperCase() + "','" + this.txtApellido1.getText().toUpperCase() + "','" + this.txtApellido2.getText().toUpperCase() + "','" + this.listaSexo[this.cboSexo.getSelectedIndex()] + "','" + this.listGTipoDiscapacidad.get(this.JCBCategoriaDiscapacidad.getSelectedIndex()).getId() + "','" + this.listGSexoIdentidadGenero.get(this.JCBIdentidadGenero.getSelectedIndex()).getId() + "','" + this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()) + "','" + this.metodos.formatoH24.format(this.txtHora.getValue()) + "','" + this.listaMunicipio[this.cboMunicipio.getSelectedIndex()] + "','" + this.listaMunicipioNac[this.JCBLNacimiento.getSelectedIndex()] + "','" + this.txtDireccion.getText() + "','" + this.listaBarrio[this.cboBarrio.getSelectedIndex()] + "','" + this.txtTelefono.getText() + "','" + this.txtTelefono1.getText() + "','" + this.txtCorreo.getText().toLowerCase() + "','" + this.JTFFCodifoSap.getText() + "','" + getXurlfoto() + "','" + this.listaEstadoCivil[this.cboEstadoCivil.getSelectedIndex()] + "','" + xtipopersona + "','" + this.listaOcupacion[this.cboEtnia.getSelectedIndex()] + "','" + this.txtAfiliacion.getText() + "','" + this.cboSangre.getSelectedItem().toString() + "','" + this.rh + "','";
        this.sql += this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        setIdPersona(this.consultas.ejecutarSQLId(this.sql));
        mActualizarEdad();
        this.consultas.cerrarConexionBd();
    }

    public void crearUsuario() {
        this.sql = "INSERT INTO g_usuario (Id_persona, NoHistoria, Id_Ocupacion, Id_TipoAfiliado, NAfiliacion, Id_EmpresaCont,`Id_Cargo`  , `Id_Supervisor` , `Id_Segmento`, `Id_TipoGrupo`, `Id_Arl`, Id_Lateralidad, Id_Horario ,HorasTrabajadas, `NHijo` , `CSEconomica`, `FechaIngreso`,IdPoblacionEspecial, Fecha, UsuarioS) VALUES ('" + getIdPersona() + "','" + this.txtHistoria.getText() + "','" + this.listaOcupacion[this.cboEtnia.getSelectedIndex()] + "','" + this.listaTipoAfiliado[this.cboTipoAfiliado.getSelectedIndex()] + "','" + this.txtAfiliacion.getText() + "','" + this.listaEmpresa[this.cboEps.getSelectedIndex()][0] + "','" + this.listacargo[this.JCBCargo.getSelectedIndex()] + "','" + this.listasupervisor[this.JCBSupervisor.getSelectedIndex()][0] + "','" + this.listasegmento[this.JCBSegmento.getSelectedIndex()] + "','" + this.listagrupo[this.JCBGrupo.getSelectedIndex()] + "','" + this.listaArl[this.JCBArl.getSelectedIndex()] + "','" + this.listalateralidad[this.JCBLateralidad.getSelectedIndex()] + "','" + this.listajornada[this.JCBJornada.getSelectedIndex()] + "','" + this.JSPNHorasTrabajadas.getValue() + "','" + this.JSPNHijos.getValue() + "','" + this.JSPNClaSE.getValue() + "','" + this.metodos.formatoAMD.format(this.JDFechaIngreso.getDate()) + "','" + this.listapobEspecial[this.cboPobEspecial.getSelectedIndex()] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void grabar() {
        int v = 0;
        if (this.frmllamador != null && this.frmllamador.equals("Facturac")) {
            v = Integer.valueOf(this.frmFacturac.frmIngreso.listConvenio.get(this.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString()).intValue();
        }
        if (validarDatos(v) == 1) {
            switch (this.tipoGrabado) {
                case 1:
                    modificarPersona();
                    modificarUsuario();
                    this.grabado = 2;
                    break;
                case 2:
                    modificarPersona();
                    crearUsuario();
                    this.grabado = 2;
                    break;
                case 3:
                    crearPersona();
                    crearUsuario();
                    this.grabado = 1;
                    break;
            }
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                grabarModificarFpz();
            }
            if (this.frmllamador.equals("xjifcrearpersona")) {
                JOptionPane.showMessageDialog(this, "Se grabo con éxito", "CONFIRMAr", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getIdentificacion().equals("900518561")) {
            this.sql = " SELECT If( DATEDIFF(NOW(),'" + this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()) + "')< `g_tipoidentificacion`.RMinEdad OR DATEDIFF(NOW(),'" + this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()) + "')>`g_tipoidentificacion`.RMaxEdad ,0,1)\n FROM baseserver.`g_persona` \n INNER JOIN baseserver.`g_tipoidentificacion` ON (`g_persona`.`Id_TipoIdentificacion` = `g_tipoidentificacion`.`Id`)\n WHERE (g_persona.`Id`>0 AND (g_persona.Id = '" + getIdPersona() + "' OR `g_persona`.NoDocumento = '" + this.txtHistoria.getText() + "'))";
            String res = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            if (res != null && !res.isEmpty()) {
                int val = Integer.parseInt(res);
                if (val == 0) {
                    this.validarTipoDoc = false;
                    return;
                } else {
                    this.validarTipoDoc = true;
                    return;
                }
            }
            this.validarTipoDoc = false;
        }
    }

    private void grabarModificarFpz() {
        this.sql = "SELECT Id_Persona FROM g_usuario_fpz WHERE Id_Persona = '" + getIdPersona() + "'";
        String dato = this.consultas.traerDato(this.sql);
        if (dato.isEmpty()) {
            if (this.idCotizante == null || this.idCotizante.isEmpty()) {
                this.idCotizante = getIdPersona();
            }
            this.sql = "INSERT INTO g_usuario_fpz (Id_Persona, Id_Parentesco, Id_Empresa, Id_RelacionLaboral, Id_PersDescuento, Id_UnidadN, Fecha, UsuarioS) VALUES ('" + getIdPersona() + "','" + this.listaParentesco[this.cboParentesco.getSelectedIndex()] + "','" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "','" + this.listaRelacionLaboral[this.cboRelacionLaboral.getSelectedIndex()][0] + "','" + this.idCotizante + "','" + this.xidunidadnegocio[this.JCBUnidadN.getSelectedIndex()] + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.consultas.ejecutarSQL(this.sql);
        } else {
            this.sql = "UPDATE g_usuario_fpz SET Id_Parentesco = '" + this.listaParentesco[this.cboParentesco.getSelectedIndex()] + "', Id_Empresa = '" + this.listaTipoEmpresa[this.cboTipoEmpresa.getSelectedIndex()] + "', Id_RelacionLaboral = '" + this.listaRelacionLaboral[this.cboRelacionLaboral.getSelectedIndex()][0] + "', Id_PersDescuento  = '" + this.idCotizante + "', Id_UnidadN  = '" + this.xidunidadnegocio[this.JCBUnidadN.getSelectedIndex()] + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS  ='" + Principal.usuarioSistemaDTO.getLogin() + "'WHERE (Id_Persona = '" + this.IdPersona + "')";
            this.consultas.ejecutarSQL(this.sql);
        }
        this.consultas.cerrarConexionBd();
    }

    public void limpiarCombos() {
        this.cboTipoIdentificacion.setSelectedIndex(-1);
        this.cboSexo.setSelectedIndex(-1);
        this.cboEps.setSelectedIndex(-1);
        this.cboEstadoCivil.setSelectedIndex(-1);
        this.cboEtnia.setSelectedItem("Otras etnias ND No definido");
        this.cboMunicipio.setSelectedIndex(-1);
        this.JCBLNacimiento.setSelectedItem("MONTELIBANO - CÒRDOBA");
        this.cboBarrio.setSelectedIndex(-1);
        this.cboTipoAfiliado.setSelectedIndex(-1);
        this.cboPobEspecial.setSelectedItem("No definido");
        this.JCBJornada.setSelectedItem("NO APLICA");
        AutoCompleteDecorator.decorate(this.cboMunicipio);
        AutoCompleteDecorator.decorate(this.JCBLNacimiento);
    }

    public void marcarEstado(int op) {
        if (op == 0) {
            this.lblEstado.setText("Activo");
            this.lblEstado.setForeground(new Color(0, 0, 102));
        } else {
            this.lblEstado.setText("Inactivo");
            this.lblEstado.setForeground(new Color(204, 0, 51));
            this.metodos.mostrarMensaje("Este Usuario se encuentra Desactivado");
        }
    }

    public void modificarPersona() {
        int xtipopersona = 0;
        if (Principal.informacionGeneralPrincipalDTO.getAtencionPreferencial().intValue() == 1) {
            xtipopersona = Principal.informacionGeneralPrincipalDTO.getAtencionPreferencial().intValue();
        }
        if (this.JCHBCorteConstitucional.isSelected()) {
            this.demanda = 1;
        } else {
            this.demanda = 0;
        }
        this.sql = "UPDATE g_persona SET  Nombre1 = '" + this.txtNombre1.getText().toUpperCase() + "', Nombre2 = '" + this.txtNombre2.getText().toUpperCase() + "', Apellido1 = '" + this.txtApellido1.getText().toUpperCase() + "', Apellido2 = '" + this.txtApellido2.getText().toUpperCase() + "', Id_Sexo = '" + this.listaSexo[this.cboSexo.getSelectedIndex()] + "', idIdentidadG = '" + this.listGSexoIdentidadGenero.get(this.JCBIdentidadGenero.getSelectedIndex()).getId() + "', idTipoDiscapacidad = '" + this.listGTipoDiscapacidad.get(this.JCBCategoriaDiscapacidad.getSelectedIndex()).getId() + "', FechaNac = '" + this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()) + "', HoraNac = '" + this.metodos.formatoH24.format(this.txtHora.getValue()) + "', Id_Municipio = '" + this.listaMunicipio[this.cboMunicipio.getSelectedIndex()] + "', Id_MunicipioNac = '" + this.listaMunicipioNac[this.JCBLNacimiento.getSelectedIndex()] + "', Direccion = '" + this.txtDireccion.getText() + "', Id_Barrio = '" + this.listaBarrio[this.cboBarrio.getSelectedIndex()] + "', Telefono = '" + this.txtTelefono.getText() + "', Movil = '" + this.txtTelefono1.getText() + "', Correo = '" + this.txtCorreo.getText().toLowerCase() + "', Codigo1Sap = '" + this.JTFFCodifoSap.getText() + "', UrlFoto = '" + getXurlfoto() + "', Id_Etnia = '" + this.listaOcupacion[this.cboEtnia.getSelectedIndex()] + "', TipoPersona = '" + xtipopersona + "', NAfiliacion = '" + this.txtAfiliacion.getText() + "', Id_EstadoCivil = '" + this.listaEstadoCivil[this.cboEstadoCivil.getSelectedIndex()] + "', GrupoSangre = '" + this.cboSangre.getSelectedItem().toString() + "', Rh ='" + this.rh + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', esCorteConstitucional = '" + this.demanda + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id = '" + getIdPersona() + "')";
        mActualizarEdad();
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void mActualizarEdad() {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            CallableStatement cs = xct.establecerConexionBd().prepareCall("{CALL `Actualizar_Datos_FechaNac`('" + getIdPersona() + "','" + this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()) + "')}");
            cs.execute();
            cs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mConsultarValidacionxUsuario() {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            if (this.JCHBCorteConstitucional.isSelected()) {
                this.JPDPersonales.setBackground(new Color(51, 193, 242));
            } else {
                this.sql = "SELECT Id_Usuario FROM g_usuario_validacion WHERE (Id_Usuario ='" + getIdPersona() + "' AND DATE_FORMAT(FechaV,'%m-%Y') ='" + this.metodos.formatoMesAno.format(this.metodos.getFechaActual()) + "')";
                ResultSet xrs = xct.traerRs(this.sql);
                if (xrs.next()) {
                    this.JPDPersonales.setBackground(new Color(177, 251, 177));
                } else {
                    this.JPDPersonales.setBackground(new Color(236, 233, 216));
                }
                xrs.close();
                xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizarEdadTipo() {
        this.sql = "UPDATE  g_persona  SET  g_persona.Edad=IF(TIMESTAMPDIFF(MONTH,g_persona.FechaNac,NOW())=0,TIMESTAMPDIFF(DAY,g_persona.FechaNac,NOW()), IF( TIMESTAMPDIFF(MONTH,g_persona.FechaNac,NOW())<12,  TIMESTAMPDIFF(MONTH,g_persona.FechaNac,NOW()), (ROUND((DATEDIFF(NOW(),g_persona.FechaNac)/365))-1) )) , g_persona.Id_TipoEdad=IF(TIMESTAMPDIFF(MONTH,g_persona.FechaNac,NOW())=0,3, IF( TIMESTAMPDIFF(MONTH,g_persona.FechaNac,NOW())<12, 2,1)) WHERE g_persona.Id='" + getIdPersona() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void modificarUsuario() {
        this.sql = "UPDATE g_usuario SET Id_TipoAfiliado = '" + this.listaTipoAfiliado[this.cboTipoAfiliado.getSelectedIndex()] + "', Id_Ocupacion = '" + this.listaOcupacion[this.cboEtnia.getSelectedIndex()] + "', Id_EmpresaCont = '" + this.listaEmpresa[this.cboEps.getSelectedIndex()][0] + "', NAfiliacion = '" + this.txtAfiliacion.getText() + "', Id_Cargo = '" + this.listacargo[this.JCBCargo.getSelectedIndex()] + "', Id_Supervisor = '" + this.listasupervisor[this.JCBSupervisor.getSelectedIndex()][0] + "', Id_Segmento = '" + this.listasegmento[this.JCBSegmento.getSelectedIndex()] + "', Id_TipoGrupo = '" + this.listagrupo[this.JCBGrupo.getSelectedIndex()] + "', Id_Arl = '" + this.listaArl[this.JCBArl.getSelectedIndex()] + "', Id_Lateralidad = '" + this.listalateralidad[this.JCBLateralidad.getSelectedIndex()] + "', Id_Horario = '" + this.listajornada[this.JCBJornada.getSelectedIndex()] + "', HorasTrabajadas = '" + this.JSPNHorasTrabajadas.getValue() + "', NHijo = '" + this.JSPNHijos.getValue() + "', CSEconomica = '" + this.JSPNClaSE.getValue() + "', IdPoblacionEspecial = '" + this.listapobEspecial[this.cboPobEspecial.getSelectedIndex()] + "', FechaIngreso = '" + this.metodos.formatoAMD.format(this.JDFechaIngreso.getDate()) + "', Fecha = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (Id_persona = '" + getIdPersona() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public final void nuevo() {
        setEstadoVisualizacion(false);
        this.JCBCategoriaDiscapacidad.setSelectedItem("Sin discapacidad");
        this.JCBIdentidadGenero.removeAllItems();
        this.JCBCEspecial.setSelectedIndex(-1);
        this.directorio = new File(this.metodos.mRutaSoporte("Persona"));
        setIdPersona("0");
        this.lleno = false;
        this.cboFechaNacimiento.setDate(this.metodos.getFechaActual());
        this.txtHora.setValue(this.metodos.getFechaActual());
        this.xAbrioDInducida = false;
        this.JPDPersonales.setBackground(new Color(236, 233, 216));
        setXurlfoto("");
        this.txtHistoria.setText("");
        this.txtIdentificacion.setText("");
        this.txtApellido1.setText("");
        this.txtApellido2.setText("");
        this.txtNombre1.setText("");
        this.txtNombre2.setText("");
        this.txtEdad1.setText("");
        this.txtEdad.setText("0 Dias");
        limpiarCombos();
        this.txtTelefono.setText("");
        this.txtTelefono1.setText("");
        this.JCHBCorteConstitucional.setSelected(false);
        this.txtDireccion.setText("");
        this.txtCorreo.setText("");
        this.txtAfiliacion.setText("");
        this.JTFFCodifoSap.setText("0");
        this.tipoGrabado = 3;
        this.encontrado = 0;
        this.hcAnterior = "";
        this.JCBCargo.setSelectedItem("NO APLICA");
        this.JCBSupervisor.setSelectedItem("APLICA NO");
        this.JCBSegmento.setSelectedItem("NO APLICA");
        this.JCBArl.setSelectedItem("NO APLICA");
        this.JCBLateralidad.setSelectedItem("DIESTRO");
        this.JCBGrupo.setSelectedItem("NO APLICA");
        this.cboSangre.setSelectedItem("-");
        this.JSPNHijos.setValue(0);
        this.JSPNClaSE.setValue(0);
        marcarEstado(0);
        this.grabado = 0;
        mCrearModeloSoporte();
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            this.JCBUnidadN.removeAllItems();
            this.cboParentesco.setSelectedIndex(-1);
            this.cboTipoEmpresa.setSelectedItem("ACTUALIZAR");
            this.cboRelacionLaboral.setSelectedIndex(-1);
            this.cboSangre.setSelectedItem("-");
            this.txtIdentificacionFuncionario.setText("");
            this.txtNbreCotizante.setText("");
        } else {
            this.JCHBCorteConstitucional.setVisible(false);
        }
        if (Principal.informacionIps.getIdentificacion().equals("901529577")) {
            this.jLabel6.setText("Especie");
            this.jLabel29.setText("Raza");
        }
        this.JDFechaIngreso.setDate(this.metodos.getPasarTextoaFecha("1900-01-01"));
        mSeleccionar_Datos();
        if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
            this.panelPersona.setEnabledAt(2, true);
            this.panelPersona.setEnabledAt(3, true);
        }
        this.panelPersona.setSelectedIndex(0);
        this.lleno = true;
    }

    public final void nuevo1() {
        setEstadoVisualizacion(false);
        this.JCBCEspecial.setSelectedIndex(-1);
        this.directorio = new File(this.metodos.mRutaSoporte("Persona"));
        this.JCBCategoriaDiscapacidad.setSelectedItem("Sin discapacidad");
        this.JCBIdentidadGenero.removeAllItems();
        setIdPersona("0");
        this.lleno = false;
        this.cboFechaNacimiento.setDate(this.metodos.getFechaActual());
        this.xAbrioDInducida = false;
        this.JPDPersonales.setBackground(new Color(236, 233, 216));
        setXurlfoto("");
        this.txtTelefono.setText("");
        this.txtTelefono1.setText("");
        this.txtDireccion.setText("");
        this.txtCorreo.setText("");
        this.txtAfiliacion.setText("");
        this.JTFFCodifoSap.setText("0");
        this.tipoGrabado = 3;
        this.encontrado = 0;
        this.hcAnterior = "";
        this.JCBCargo.setSelectedItem("NO APLICA");
        this.JCBSupervisor.setSelectedItem("APLICA NO");
        this.JCBSegmento.setSelectedItem("NO APLICA");
        this.JCBArl.setSelectedItem("NO APLICA");
        this.JCBLateralidad.setSelectedItem("DIESTRO");
        this.JCBGrupo.setSelectedItem("NO APLICA");
        this.cboSangre.setSelectedItem("-");
        this.JSPNHijos.setValue(0);
        this.JSPNClaSE.setValue(0);
        marcarEstado(0);
        this.grabado = 0;
        mCrearModeloSoporte();
        if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            this.JCBUnidadN.removeAllItems();
            this.cboParentesco.setSelectedIndex(-1);
            this.cboTipoEmpresa.setSelectedItem("ACTUALIZAR");
            this.cboRelacionLaboral.setSelectedIndex(-1);
            this.cboSangre.setSelectedItem("-");
            this.txtIdentificacionFuncionario.setText("");
            this.txtNbreCotizante.setText("");
        }
        if (Principal.informacionIps.getIdentificacion().equals("901529577")) {
            this.jLabel6.setText("Especie");
            this.jLabel29.setText("Raza");
        }
        this.JDFechaIngreso.setDate(this.metodos.getPasarTextoaFecha("1900-01-01"));
        mSeleccionar_Datos();
        if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
            this.panelPersona.setEnabledAt(2, false);
            this.panelPersona.setEnabledAt(3, false);
        }
        this.lleno = true;
    }

    private void mConsultarALerta() {
        this.consultas.mEjecutarProcedimientAlmacenadoUno("mdatos", Integer.valueOf(this.IdPersona).intValue());
        String xsql = "SELECT g_tipoalerta.Nbre, g_usuarioxtipoalerta.Detalle, g_usuarioxtipoalerta.Id FROM g_usuarioxtipoalerta INNER JOIN g_tipoalerta  ON (g_usuarioxtipoalerta.Id_TipoAlerta = g_tipoalerta.Id) WHERE (g_usuarioxtipoalerta.Estado =1 AND g_tipoalerta.EsHC =0 AND g_usuarioxtipoalerta.Id_Usuario='" + this.IdPersona + "') ORDER BY g_tipoalerta.Nbre ASC ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(xsql);
        try {
            if (xrs.next()) {
                String xmensaje = "";
                xrs.beforeFirst();
                while (xrs.next()) {
                    xmensaje = "<html><p ALIGN=center> <font face='Arial' color='red' size=4>  <b>TIPO DE MENSAJE: " + xrs.getString(1) + "<br>" + xrs.getString(2).toUpperCase() + "</p>";
                }
                if (!this.frmllamador.equals("Despachos")) {
                    JOptionPane.showMessageDialog((Component) null, xmensaje, "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void activarFormularioConsolidadoLiquidacion() {
        if (Principal.informacionIps.getAplicaVisualizacionSaldo().booleanValue()) {
            if (this.frmllamador.equals("Facturac")) {
                Principal.clasegeneral.activarFormularioConsolidadoPagoPendiente(Long.valueOf(this.IdPersona), this.frmFacturac);
            } else if (this.frmllamador.equals("Citas")) {
                Principal.clasegeneral.activarFormularioConsolidadoPagoPendiente(Long.valueOf(this.IdPersona), this.frmCita);
            }
        }
    }

    private void realizarcasting(JInternalFrame frm) {
        if (frm.getName().equals("Facturac")) {
            this.frmFacturac = (Facturac) frm;
            this.frmllamador = "Facturac";
            return;
        }
        if (frm.getName().equals("xjifsolicituddochc")) {
            this.xjifsolicituddoc = (JIFSolicitudDocumentosHC) frm;
            this.frmllamador = "xjifsolicituddochc";
            return;
        }
        if (frm.getName().equals("jifconsultarexamenesusuario2")) {
            this.xjifexamenxuser = (JIFConsultarExamenesxUsuario) frm;
            this.frmllamador = "jifconsultarexamenesusuario2";
            return;
        }
        if (frm.getName().equals("jifconsultarexamenesusuario1")) {
            this.xjifexamenxuser = (JIFConsultarExamenesxUsuario) frm;
            this.frmllamador = "jifconsultarexamenesusuario1";
            return;
        }
        if (frm.getName().equals("CitaTerapia")) {
            this.xJIFCitaTerapia = (CitaTerapia) frm;
            this.frmllamador = "CitaTerapia";
            return;
        }
        if (frm.getName().equals("CitaNP")) {
            this.frmCitaNp = (CitaNP) frm;
            this.frmllamador = "CitaNP";
            return;
        }
        if (frm.getName().equals("Citas")) {
            this.frmCita = (CitasGral) frm;
            this.frmllamador = "Citas";
            return;
        }
        if (frm.getName().equals("Vacunacion")) {
            this.frmVacunacion = (Vacunacion) frm;
            this.frmllamador = "Vacunacion";
            return;
        }
        if (frm.getName().equals("CACervixToma")) {
            this.frmTomaCACervix = (JIFCACervix) frm;
            this.frmllamador = "CACervixToma";
            return;
        }
        if (frm.getName().equals("CACervixResultado")) {
            this.frmResultadoCACervix = (CACervixResultado) frm;
            this.frmllamador = "CACervixResultado";
            return;
        }
        if (frm.getName().equals("jifconsultarayudasdx")) {
            this.frmConsultarAyudasDx = (JIFConsultarAyudasDx) frm;
            this.frmllamador = "jifconsultarayudasdx";
            return;
        }
        if (frm.getName().equals("jifcargaratencionesmanuales")) {
            this.frmCargarAtencionesMan = (JIFCargarDocumentosHC) frm;
            this.frmllamador = "jifcargaratencionesmanuales";
            return;
        }
        if (frm.getName().equals("jifconsultarhistorial") || frm.getName().equals("jifconsultarhistorial1")) {
            this.frmConsultarHistorial = (JIFConsultarHistorial) frm;
            this.frmllamador = "jifconsultarhistoria";
            return;
        }
        if (frm.getName().equals("jifcargaratencionesmanuales")) {
            this.frmHistoriaFt = (JIFHistoriaFT) frm;
            this.frmllamador = "jifhistoriaft";
            return;
        }
        if (frm.getName().equals("xJIFRiesgoObstetrico")) {
            this.frmJIFRiesgoObstetrico = (JIFRiesgoObstetrico) frm;
            this.frmllamador = "xJIFRiesgoObstetrico";
            return;
        }
        if (frm.getName().equals("xJIFRiesgoCardiovascular")) {
            this.frmJIFRiesgoCardiovascular = (JIFRiesgoCardiovascular) frm;
            this.frmllamador = "xJIFRiesgoCardiovascular";
            return;
        }
        if (frm.getName().equals("jifpermisomedicos")) {
            this.frmPermisos = (JIFPermisosMedicos) frm;
            this.frmllamador = "jifpermisomedicos";
            return;
        }
        if (frm.getName().equals("Atencion")) {
            this.frmAtencion = (Atencion) frm;
            this.frmllamador = "Atencion";
            return;
        }
        if (frm.getName().equals("jifvisitadomiciliaria")) {
            this.frmVisitaDom = (JIFRVisitasDomiciliarias) frm;
            this.frmllamador = "jifvisitadomiciliaria";
            return;
        }
        if (frm.getName().equals("jifjuntamedica")) {
            this.frmJuntaMed = (JIFRJuntaMedica) frm;
            this.frmllamador = "jifjuntamedica";
            return;
        }
        if (frm.getName().equals("jifconstanciaservicio")) {
            this.xjifgeneracion = (JIFGenerarCertificado) frm;
            this.frmllamador = "jifconstanciaservicio";
            return;
        }
        if (frm.getName().equals("jifconstanciaservicio1")) {
            this.xjifgeneracion = (JIFGenerarCertificado) frm;
            this.frmllamador = "jifconstanciaservicio1";
            return;
        }
        if (frm.getName().equals("jifusuariosistemas")) {
            this.xjifusuarios = (JIFUsuarioSistema) frm;
            this.frmllamador = "jifusuariosistemas";
            return;
        }
        if (frm.getName().equals("jifprofesional")) {
            this.xjifprofesional1 = (JIFGProfesional) frm;
            this.frmllamador = "jifprofesional";
            return;
        }
        if (frm.getName().equals("jifsupervisor")) {
            this.xjifsupervisor = (JIFGSupervisor) frm;
            this.frmllamador = "jifsupervisor";
            return;
        }
        if (frm.getName().equals("jifconsultarcitas")) {
            this.xjifconsultarc = (JIFConsultarCitas) frm;
            this.frmllamador = "jifconsultarcitas";
            return;
        }
        if (frm.getName().equals("jifmatriculape")) {
            this.xjifmatriculapep = (JIFMatriculaPE) frm;
            this.frmllamador = "jifmatriculape";
            return;
        }
        if (frm.getName().equals("jifregistronota") || frm.getName().equals("xjifnotas")) {
            this.frmVisitaDom = (JIFRVisitasDomiciliarias) frm;
            this.frmllamador = "jifregistronota";
            return;
        }
        if (frm.getName().equals("jifalertaxusuario1") || frm.getName().equals("jifalertaxusuario")) {
            this.xjifalertausuario = (JIFGAlertaxUsuario) frm;
            this.frmllamador = "jifalertaxusuario1";
            return;
        }
        if (frm.getName().equals("jifregistroatencionesp") || frm.getName().equals("jifregistroatencionesp1") || frm.getName().equals("jifregistroatencionesp2") || frm.getName().equals("jifregistroatencionesp3")) {
            this.xjifregistroesp = (JIFRegistroAtencionesEsp) frm;
            this.frmllamador = "jifregistroatencionesp";
            return;
        }
        if (frm.getName().equals("jifconfempresa1")) {
            this.xjifempresa = (JIFFEmpresa) frm;
            this.frmllamador = "jifconfempresa1";
            return;
        }
        if (frm.getName().equals("jifautorizacion")) {
            this.xjifautorizacionmp = (JIFAutorizaciones1) frm;
            this.frmllamador = "jifautorizacion";
            return;
        }
        if (frm.getName().equals("jifusuariocargo")) {
            this.xjifrhusuarioc = (JIFRHUsuarioCargo) frm;
            this.frmllamador = "jifusuariocargo";
            return;
        }
        if (frm.getName().equals("jifgeneraciondescuento")) {
            this.xjifgenerardesc = (JIFGenerarDescuento) frm;
            this.frmllamador = "jifgeneraciondescuento";
            return;
        }
        if (frm.getName().equals("jifgenerarreportexusuario")) {
            this.xjifgenerarexusuario = (JIFGenerarExamenUsuario) frm;
            this.frmllamador = "jifgenerarreportexusuario";
            return;
        }
        if (frm.getName().equals("xjifnotasmedicas") || frm.getName().equals("xjifnotasmedicas1")) {
            this.frmVisitaDom = (JIFRVisitasDomiciliarias) frm;
            this.frmllamador = "xjifnotasmedicas";
            return;
        }
        if (frm.getName().equals("xjifhcodontologia")) {
            this.xjifhcodontofica = (JIFHistoriaOdontologica) frm;
            this.frmllamador = "xjifhcodontologia";
            return;
        }
        if (frm.getName().equals("xjifcrearpersona")) {
            this.xjifcrearp = (JIFCrearPersona) frm;
            this.frmllamador = "xjifcrearpersona";
            return;
        }
        if (frm.getName().equals("jifincapacidad")) {
            this.xjifincapcidad = (JIFIncapacidades) frm;
            this.frmllamador = "jifincapacidad";
            return;
        }
        if (frm.getName().equals("xjiftratamientoodontologico")) {
            this.ttoodontologico = (JIFDTratamientoOdontologico) frm;
            this.frmllamador = "xjiftratamientoodontologico";
            return;
        }
        if (frm.getName().equals("Despachos")) {
            this.xjifdespachos = (Despachos) frm;
            this.frmllamador = "Despachos";
            return;
        }
        if (frm.getName().equals("jifconsultarRemOrd")) {
            this.xjifexamenxuser = (JIFConsultarExamenesxUsuario) frm;
            this.frmllamador = "jifconsultarRemOrd";
            return;
        }
        if (frm.getName().equals("jifconsultarRemOrdEnfer")) {
            this.xjifexamenxuser = (JIFConsultarExamenesxUsuario) frm;
            this.frmllamador = "jifconsultarRemOrdEnfer";
            return;
        }
        if (frm.getName().equals("jifconsultarRemOrdHist")) {
            this.xjifexamenxuser = (JIFConsultarExamenesxUsuario) frm;
            this.frmllamador = "jifconsultarRemOrdHist";
            return;
        }
        if (frm.getName().equals("jiconsultarRemOrdFacturacion")) {
            this.xjifexamenxuser = (JIFConsultarExamenesxUsuario) frm;
            this.frmllamador = "jiconsultarRemOrdFacturacion";
            return;
        }
        if (frm.getName().equals("xjifpuebaayd")) {
            this.xjifpayd = (JIFPrueba_AyD) frm;
            this.frmllamador = "xjifpuebaayd";
            return;
        }
        if (frm.getName().equals("xjifpuebaaydE")) {
            this.xjifpayd = (JIFPrueba_AyD) frm;
            this.frmllamador = "xjifpuebaaydE";
            return;
        }
        if (frm.getName().equals("jifLiqServicios")) {
            this.xjifLiqServicios = (JIFLiqServicios) frm;
            this.frmllamador = "jifLiqServicios";
            return;
        }
        if (frm.getName().equals("xjiftestfatiga")) {
            this.xjiftestfatiga = (JIFTest_Fatiga) frm;
            this.frmllamador = "xjiftestfatiga";
            return;
        }
        if (frm.getName().equals("xjifhistoriauh")) {
            this.xjifhcuh = (JIFHistoria_UH) frm;
            this.frmllamador = "xjifhistoriauh";
            return;
        }
        if (frm.getName().equals("xjiflecturaoit")) {
            this.xjiflecturao = (JIFLecturaPlacaOit) frm;
            this.frmllamador = "xjiflecturaoit";
            return;
        }
        if (frm.getName().equals("xjifingresohta")) {
            this.xJIFUsuarioxPrograma = (JIFUsuarioxPrograma) frm;
            this.frmllamador = "xjifingresohta";
            return;
        }
        if (frm.getName().equals("xjifingresodiabetes")) {
            this.xJIFUsuarioxPrograma = (JIFUsuarioxPrograma) frm;
            this.frmllamador = "xjifingresodiabetes";
            return;
        }
        if (frm.getName().equals("xjifR4505")) {
            this.xJIFRegistro4505 = (JIFRegistro4505) frm;
            this.frmllamador = "xjifR4505";
            return;
        }
        if (frm.getName().equals("xjifautorizacion_servicios")) {
            this.xjif_autorizacionserv = (JIFAutorizacion_Servicios) frm;
            this.frmllamador = "xjifautorizacion_servicios";
            return;
        }
        if (frm.getName().equals("xjiffinformelecturausuarios")) {
            this.xjiffinformelecturausuarios = (JIFFInformeLecturaUsuarios) frm;
            this.frmllamador = "xjiffinformelecturausuarios";
            return;
        }
        if (frm.getName().equals("xjiffinformelecturausuarios1")) {
            this.xjiffinformelecturausuarios = (JIFFInformeLecturaUsuarios) frm;
            this.frmllamador = "xjiffinformelecturausuarios1";
        } else if (frm.getName().equals("xjifasignacionreciboingresos")) {
            this.xJIFAsigancionReciboIngresos = (JIFAsigancionReciboIngresos) frm;
            this.frmllamador = "xjifasignacionreciboingresos";
        } else if (frm.getName().equals("xjifegresoprograma")) {
            this.xJIFEgresoPrograma = (JIF_EgresoPrograma) frm;
            this.frmllamador = "xjifegresoprograma";
        } else {
            this.frmllamador = "";
        }
    }

    private void realizarcasting(JDialog dial) {
        if (dial.getName().equals("CrearPersona")) {
            this.frmCrearPersona = (CrearPersona) dial;
            this.frmllamador = dial.getName();
        }
    }

    public int validarDatos(int validar) {
        int op = 0;
        if (this.txtHistoria.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor Digite un número de Historia Clínica.");
            this.txtHistoria.requestFocus();
        } else if (this.cboTipoIdentificacion.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Tipo de Identificación.");
            this.cboTipoIdentificacion.requestFocus();
        } else if (this.txtIdentificacion.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor digite un Número de Identificación para el Tipo de Documento.");
            this.txtIdentificacion.requestFocus();
        } else if (this.txtApellido1.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor digite el Primer Apellido.");
            this.txtApellido1.requestFocus();
        } else if (this.txtNombre1.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor digite el Primer Nombre.");
            this.txtNombre1.requestFocus();
        } else if (this.JCBIdentidadGenero.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la identidad de género.");
            this.JCBIdentidadGenero.requestFocus();
            this.panelPersona.setSelectedIndex(0);
        } else if (this.JCBCategoriaDiscapacidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el la caterois de la discapacidad.");
            this.JCBCategoriaDiscapacidad.requestFocus();
            this.panelPersona.setSelectedIndex(1);
        } else if (this.cboFechaNacimiento.getDate() == null) {
            this.metodos.mostrarMensaje("Por Favor escriba una Fecha de Nacimiento Válida");
            this.cboFechaNacimiento.requestFocus();
        } else if (this.cboEps.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la EPS o la Empresa a la que esta afiliado");
            this.cboEps.requestFocus();
        } else if (this.cboEstadoCivil.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Estado Civil.");
            this.cboEstadoCivil.requestFocus();
        } else if (this.cboEtnia.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione una Etnia.");
            this.cboEtnia.requestFocus();
        } else if (this.JCBLNacimiento.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un municipio de nacimiento");
            this.cboMunicipio.requestFocus();
        } else if (this.cboMunicipio.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Municipio.");
            this.cboMunicipio.requestFocus();
        } else if (this.cboBarrio.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Barrio del Municipio.");
            this.cboBarrio.requestFocus();
        } else if (this.cboTipoAfiliado.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Tipo de Afiliación al Régimen.");
            this.cboTipoAfiliado.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.cboParentesco.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Parentesco");
            this.cboParentesco.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.cboTipoEmpresa.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione la Empresa con la cual labora");
            this.cboTipoEmpresa.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.cboRelacionLaboral.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione la Relación Laboral");
            this.cboRelacionLaboral.requestFocus();
        } else if (this.cboSangre.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Grupo de Sangre");
            this.cboSangre.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.JCBCargo.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un cargo");
            this.JCBCargo.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.JCBSegmento.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el SEG");
            this.JCBSegmento.requestFocus();
        } else if (this.JCBArl.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione la ARL");
            this.JCBArl.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.JCBGrupo.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Grupo");
            this.JCBGrupo.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.JCBLateralidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione ela lateralidad");
            this.JCBLateralidad.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.JDFechaIngreso.getDate().equals("")) {
            this.metodos.mostrarMensaje("Por favor digite la fecha de ingreso");
            this.JDFechaIngreso.requestFocus();
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0 && this.JCBLateralidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por seleccione el supervisor");
            this.panelPersona.setSelectedIndex(3);
            this.JCBSupervisor.requestFocus();
        } else if (validar == 0) {
            int tdrMin = Integer.parseInt(this.listaTipoIdentificacion[this.cboTipoIdentificacion.getSelectedIndex()][1]);
            int tdrMax = Integer.parseInt(this.listaTipoIdentificacion[this.cboTipoIdentificacion.getSelectedIndex()][2]);
            long terMin = Long.parseLong(this.listaTipoIdentificacion[this.cboTipoIdentificacion.getSelectedIndex()][3]);
            long terMax = Long.parseLong(this.listaTipoIdentificacion[this.cboTipoIdentificacion.getSelectedIndex()][4]);
            this.sql = "SELECT DATEDIFF(NOW(),'" + this.metodos.formatoAMD.format(this.cboFechaNacimiento.getDate()) + "')";
            this.sql = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            if (!this.txtIdentificacion.isTextoValido()) {
                this.metodos.mostrarMensaje("Por Favor digite un Número de Identificación Válido para el Tipo de Documento.");
                this.txtIdentificacion.requestFocus();
            } else if (this.txtIdentificacion.getText().length() < tdrMin || this.txtIdentificacion.getText().length() > tdrMax) {
                this.metodos.mostrarMensaje("La cantidad de carácteres del Documento debe estar entre " + tdrMin + " y " + tdrMax);
                this.txtIdentificacion.requestFocus();
            } else if (Integer.parseInt(this.sql) < terMin || Integer.parseInt(this.sql) > terMax) {
                this.metodos.mostrarMensaje("La Edad no corresponde al Tipo de Documento " + this.sql);
                this.cboTipoIdentificacion.requestFocus();
            } else {
                op = 1;
            }
        } else {
            op = 1;
        }
        return op;
    }

    /* JADX WARN: Type inference failed for: r3v270, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.panelPersona = new JTabbedPane();
        this.JPDPersonales = new JPanel();
        this.jLabel9 = new JLabel();
        this.txtHistoria = new JTextFieldValidator();
        this.jLabel19 = new JLabel();
        this.cboSexo = new JComboBox();
        this.jLabel18 = new JLabel();
        this.txtEdad = new JTextField();
        this.jLabel17 = new JLabel();
        this.cboFechaNacimiento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.txtNombre2 = new JTextFieldValidator();
        this.jLabel16 = new JLabel();
        this.jLabel15 = new JLabel();
        this.txtNombre1 = new JTextFieldValidator();
        this.jLabel14 = new JLabel();
        this.txtApellido2 = new JTextFieldValidator();
        this.txtApellido1 = new JTextFieldValidator();
        this.jLabel13 = new JLabel();
        this.jLabel11 = new JLabel();
        this.txtIdentificacion = new JTextFieldValidator();
        this.jLabel10 = new JLabel();
        this.cboTipoIdentificacion = new JComboBox();
        this.jLabel30 = new JLabel();
        this.txtEdad1 = new JTextFieldValidator();
        this.jLabel31 = new JLabel();
        this.JCBIdentidadGenero = new JComboBox();
        this.txtHora = new JFormattedTextField();
        this.JPDPersonales1 = new JPanel();
        this.jLabel7 = new JLabel();
        this.cboEps = new JComboBox();
        this.jLabel12 = new JLabel();
        this.JCBCEspecial = new JComboBox<>();
        this.JCHBCorteConstitucional = new JCheckBox();
        this.JBTHuella = new JButton();
        this.lblEstado = new JLabel();
        this.jLabel32 = new JLabel();
        this.JCBCategoriaDiscapacidad = new JComboBox();
        this.JPDAdicionales = new JPanel();
        this.jLabel1 = new JLabel();
        this.cboTipoAfiliado = new JComboBox();
        this.jLabel25 = new JLabel();
        this.txtCorreo = new JTextField();
        this.txtTelefono = new JTextField();
        this.jLabel24 = new JLabel();
        this.jLabel23 = new JLabel();
        this.txtDireccion = new JTextField();
        this.jLabel22 = new JLabel();
        this.cboBarrio = new JComboBox();
        this.jLabel21 = new JLabel();
        this.cboMunicipio = new JComboBox();
        this.jLabel6 = new JLabel();
        this.cboEtnia = new JComboBox();
        this.jLabel20 = new JLabel();
        this.cboEstadoCivil = new JComboBox();
        this.jLabel26 = new JLabel();
        this.JCBLNacimiento = new JComboBox();
        this.jLabel27 = new JLabel();
        this.txtAfiliacion = new JTextField();
        this.jLabel28 = new JLabel();
        this.txtTelefono1 = new JTextField();
        this.jLabel29 = new JLabel();
        this.cboPobEspecial = new JComboBox();
        this.JPDRLaboral = new JPanel();
        this.panelGrupoSangre = new JPanel();
        this.cboSangre = new JComboBox();
        this.btnNegativo = new JCheckBox();
        this.btnPositivo = new JCheckBox();
        this.jLabel5 = new JLabel();
        this.txtNbreCotizante = new JTextField();
        this.txtIdentificacionFuncionario = new JTextField();
        this.jLabel4 = new JLabel();
        this.cboRelacionLaboral = new JComboBox();
        this.jLabel3 = new JLabel();
        this.cboTipoEmpresa = new JComboBox();
        this.jLabel2 = new JLabel();
        this.cboParentesco = new JComboBox();
        this.JTFFCodifoSap = new JTextField();
        this.jLabel8 = new JLabel();
        this.JLBUnidadN = new JLabel();
        this.JCBUnidadN = new JComboBox();
        this.JPDOcupacionales = new JPanel();
        this.JCBCargo = new JComboBox();
        this.JCBSupervisor = new JComboBox();
        this.JCBSegmento = new JComboBox();
        this.JCBArl = new JComboBox();
        this.JCBGrupo = new JComboBox();
        this.JSPNHijos = new JSpinner();
        this.JSPNClaSE = new JSpinner();
        this.JDFechaIngreso = new JDateChooser();
        this.JCBLateralidad = new JComboBox();
        this.JCBJornada = new JComboBox();
        this.JSPNHorasTrabajadas = new JSpinner();
        this.JPDocAnexos = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDocumentos = new JTable();
        this.JTFRuta = new JTextField();
        this.JCBTipoDocumentoSoporte = new JComboBox();
        this.JBSubirArchivo = new JButton();
        setMaximumSize(null);
        setName("Persona");
        this.panelPersona.setForeground(new Color(255, 0, 0));
        this.panelPersona.setFont(new Font("Arial", 1, 14));
        this.jLabel9.setDisplayedMnemonic('T');
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(new Color(0, 0, 204));
        this.jLabel9.setText("Historia Clínica");
        this.txtHistoria.setToolTipText("Número de Historia Clínica");
        this.txtHistoria.setExprecionRegular("^[a-zA-ZñÑ0-9]*$");
        this.txtHistoria.setFocusAccelerator('T');
        this.txtHistoria.setFont(new Font("Arial", 1, 12));
        this.txtHistoria.addFocusListener(new FocusAdapter() { // from class: General.Persona.1
            public void focusGained(FocusEvent evt) {
                Persona.this.txtHistoriaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtHistoriaFocusLost(evt);
            }
        });
        this.txtHistoria.addActionListener(new ActionListener() { // from class: General.Persona.2
            public void actionPerformed(ActionEvent evt) {
                Persona.this.txtHistoriaActionPerformed(evt);
            }
        });
        this.txtHistoria.addKeyListener(new KeyAdapter() { // from class: General.Persona.3
            public void keyPressed(KeyEvent evt) {
                Persona.this.txtHistoriaKeyPressed(evt);
            }
        });
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setForeground(new Color(0, 0, 204));
        this.jLabel19.setText("Sexo biológico");
        this.cboSexo.setFont(new Font("Arial", 1, 12));
        this.cboSexo.addItemListener(new ItemListener() { // from class: General.Persona.4
            public void itemStateChanged(ItemEvent evt) {
                Persona.this.cboSexoItemStateChanged(evt);
            }
        });
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setForeground(new Color(0, 0, 204));
        this.jLabel18.setText("Años");
        this.txtEdad.setEditable(false);
        this.txtEdad.setBackground(new Color(0, 0, 153));
        this.txtEdad.setFont(new Font("Arial", 1, 12));
        this.txtEdad.setForeground(new Color(255, 255, 255));
        this.txtEdad.setDisabledTextColor(new Color(255, 255, 255));
        this.txtEdad.setEnabled(false);
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setForeground(new Color(0, 0, 204));
        this.jLabel17.setText("Fecha y Hora de Nacimiento");
        this.cboFechaNacimiento.setDateFormatString("dd/MM/yyyy");
        this.cboFechaNacimiento.setFont(new Font("Arial", 1, 12));
        this.cboFechaNacimiento.setName("txtFecha");
        this.cboFechaNacimiento.addFocusListener(new FocusAdapter() { // from class: General.Persona.5
            public void focusGained(FocusEvent evt) {
                Persona.this.cboFechaNacimientoFocusGained(evt);
            }
        });
        this.cboFechaNacimiento.addPropertyChangeListener(new PropertyChangeListener() { // from class: General.Persona.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Persona.this.cboFechaNacimientoPropertyChange(evt);
            }
        });
        this.txtNombre2.setExprecionRegular("^[a-zA-ZñÑ ]*$");
        this.txtNombre2.setFont(new Font("Arial", 1, 12));
        this.txtNombre2.addFocusListener(new FocusAdapter() { // from class: General.Persona.7
            public void focusGained(FocusEvent evt) {
                Persona.this.txtNombre2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtNombre2FocusLost(evt);
            }
        });
        this.txtNombre2.addActionListener(new ActionListener() { // from class: General.Persona.8
            public void actionPerformed(ActionEvent evt) {
                Persona.this.txtNombre2ActionPerformed(evt);
            }
        });
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(new Color(0, 0, 204));
        this.jLabel16.setText("Segundo Nombre");
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(0, 0, 204));
        this.jLabel15.setText("Primer Nombre");
        this.txtNombre1.setExprecionRegular("^[a-zA-ZñÑ ]*$");
        this.txtNombre1.setFont(new Font("Arial", 1, 12));
        this.txtNombre1.addFocusListener(new FocusAdapter() { // from class: General.Persona.9
            public void focusGained(FocusEvent evt) {
                Persona.this.txtNombre1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtNombre1FocusLost(evt);
            }
        });
        this.txtNombre1.addActionListener(new ActionListener() { // from class: General.Persona.10
            public void actionPerformed(ActionEvent evt) {
                Persona.this.txtNombre1ActionPerformed(evt);
            }
        });
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(0, 0, 204));
        this.jLabel14.setText("Segundo Apellido");
        this.txtApellido2.setExprecionRegular("^[a-zA-ZñÑ ]*$");
        this.txtApellido2.setFont(new Font("Arial", 1, 12));
        this.txtApellido2.addFocusListener(new FocusAdapter() { // from class: General.Persona.11
            public void focusGained(FocusEvent evt) {
                Persona.this.txtApellido2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtApellido2FocusLost(evt);
            }
        });
        this.txtApellido2.addActionListener(new ActionListener() { // from class: General.Persona.12
            public void actionPerformed(ActionEvent evt) {
                Persona.this.txtApellido2ActionPerformed(evt);
            }
        });
        this.txtApellido1.setExprecionRegular("^[a-zA-ZñÑ ]*$");
        this.txtApellido1.setFont(new Font("Arial", 1, 12));
        this.txtApellido1.addFocusListener(new FocusAdapter() { // from class: General.Persona.13
            public void focusGained(FocusEvent evt) {
                Persona.this.txtApellido1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtApellido1FocusLost(evt);
            }
        });
        this.txtApellido1.addActionListener(new ActionListener() { // from class: General.Persona.14
            public void actionPerformed(ActionEvent evt) {
                Persona.this.txtApellido1ActionPerformed(evt);
            }
        });
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(0, 0, 204));
        this.jLabel13.setText("Primer Apellido");
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(0, 0, 204));
        this.jLabel11.setHorizontalAlignment(2);
        this.jLabel11.setText("No. Doc. Identidad");
        this.txtIdentificacion.setFont(new Font("Arial", 1, 12));
        this.txtIdentificacion.addFocusListener(new FocusAdapter() { // from class: General.Persona.15
            public void focusGained(FocusEvent evt) {
                Persona.this.txtIdentificacionFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtIdentificacionFocusLost(evt);
            }
        });
        this.txtIdentificacion.addActionListener(new ActionListener() { // from class: General.Persona.16
            public void actionPerformed(ActionEvent evt) {
                Persona.this.txtIdentificacionActionPerformed(evt);
            }
        });
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(0, 0, 204));
        this.jLabel10.setText("Tipo Documento");
        this.cboTipoIdentificacion.setFont(new Font("Arial", 1, 12));
        this.cboTipoIdentificacion.addItemListener(new ItemListener() { // from class: General.Persona.17
            public void itemStateChanged(ItemEvent evt) {
                Persona.this.cboTipoIdentificacionItemStateChanged(evt);
            }
        });
        this.jLabel30.setFont(new Font("Arial", 1, 12));
        this.jLabel30.setForeground(new Color(0, 0, 204));
        this.jLabel30.setText("Edad");
        this.txtEdad1.setExprecionRegular("^\\d*$");
        this.txtEdad1.setFont(new Font("Arial", 1, 12));
        this.txtEdad1.addFocusListener(new FocusAdapter() { // from class: General.Persona.18
            public void focusGained(FocusEvent evt) {
                Persona.this.txtEdad1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtEdad1FocusLost(evt);
            }
        });
        this.txtEdad1.addActionListener(new ActionListener() { // from class: General.Persona.19
            public void actionPerformed(ActionEvent evt) {
                Persona.this.txtEdad1ActionPerformed(evt);
            }
        });
        this.jLabel31.setFont(new Font("Arial", 1, 12));
        this.jLabel31.setForeground(new Color(0, 0, 204));
        this.jLabel31.setText("Identidad de género");
        this.JCBIdentidadGenero.setFont(new Font("Arial", 1, 12));
        this.txtHora.setBorder((Border) null);
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("h:mm"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: General.Persona.20
            public void keyPressed(KeyEvent evt) {
                Persona.this.txtHoraKeyPressed(evt);
            }
        });
        GroupLayout JPDPersonalesLayout = new GroupLayout(this.JPDPersonales);
        this.JPDPersonales.setLayout(JPDPersonalesLayout);
        JPDPersonalesLayout.setHorizontalGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel17, -2, 205, -2).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.cboFechaNacimiento, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtHora, -2, 86, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel18, -2, 40, -2).addComponent(this.txtEdad1, -2, 72, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtEdad, -2, 225, -2).addComponent(this.jLabel30, -2, 134, -2)).addGap(18, 18, 18).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel19).addComponent(this.cboSexo, -2, 104, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBIdentidadGenero, 0, -1, 32767).addComponent(this.jLabel31, -2, 212, -2))).addGroup(JPDPersonalesLayout.createSequentialGroup().addContainerGap().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtHistoria, -2, 104, -2).addComponent(this.jLabel9)).addGap(10, 10, 10).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.cboTipoIdentificacion, -2, 142, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtIdentificacion, -2, 126, -2).addComponent(this.jLabel11)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtApellido1, -2, 114, -2).addComponent(this.jLabel13)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtApellido2, -2, 114, -2).addComponent(this.jLabel14)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtNombre1, -2, 114, -2).addComponent(this.jLabel15)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel16).addComponent(this.txtNombre2, -2, 110, -2)))))).addGap(0, 134, 32767)));
        JPDPersonalesLayout.setVerticalGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addGap(12, 12, 12).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.jLabel18).addGap(6, 6, 6).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtEdad1, -2, 30, -2).addComponent(this.txtHora, -2, 30, -2))).addGroup(JPDPersonalesLayout.createSequentialGroup().addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.jLabel9)).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel13).addComponent(this.jLabel11)).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel15).addComponent(this.jLabel14).addComponent(this.jLabel16))).addGap(6, 6, 6).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtApellido1, -2, 30, -2).addComponent(this.txtApellido2, -2, 30, -2).addComponent(this.txtNombre1, -2, 30, -2).addComponent(this.txtNombre2, -2, 30, -2).addComponent(this.txtHistoria, -2, 30, -2).addComponent(this.cboTipoIdentificacion, -2, 30, -2).addComponent(this.txtIdentificacion, -2, 30, -2)).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonalesLayout.createSequentialGroup().addComponent(this.jLabel17, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboFechaNacimiento, -2, 30, -2)).addGroup(JPDPersonalesLayout.createSequentialGroup().addGap(2, 2, 2).addGroup(JPDPersonalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDPersonalesLayout.createSequentialGroup().addComponent(this.jLabel19).addGap(34, 34, 34)).addComponent(this.JCBIdentidadGenero, GroupLayout.Alignment.TRAILING, -2, 30, -2).addComponent(this.cboSexo, GroupLayout.Alignment.TRAILING, -2, 30, -2))).addComponent(this.jLabel31))).addGroup(JPDPersonalesLayout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.txtEdad, -2, 30, -2)).addGroup(JPDPersonalesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel30))))).addContainerGap()));
        this.txtHistoria.setFocusTraversalKeysEnabled(false);
        this.panelPersona.addTab("DATOS PERSONALES", this.JPDPersonales);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 204));
        this.jLabel7.setText("E.P.S.");
        this.cboEps.setFont(new Font("Arial", 1, 12));
        this.cboEps.addItemListener(new ItemListener() { // from class: General.Persona.21
            public void itemStateChanged(ItemEvent evt) {
                Persona.this.cboEpsItemStateChanged(evt);
            }
        });
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(0, 0, 204));
        this.jLabel12.setText("Capacidad especial");
        this.JCBCEspecial.setFont(new Font("Arial", 1, 12));
        this.JCBCEspecial.setModel(new DefaultComboBoxModel(new String[]{"Normal", "Discapacitado", "Embarazada", "Tercera edad", "Niño"}));
        this.JCBCEspecial.addActionListener(new ActionListener() { // from class: General.Persona.22
            public void actionPerformed(ActionEvent evt) {
                Persona.this.JCBCEspecialActionPerformed(evt);
            }
        });
        this.JCHBCorteConstitucional.setText("C. Corte?");
        this.JBTHuella.setFont(new Font("Arial", 1, 12));
        this.JBTHuella.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBTHuella.setToolTipText("Registro Biometrico");
        this.JBTHuella.addActionListener(new ActionListener() { // from class: General.Persona.23
            public void actionPerformed(ActionEvent evt) {
                Persona.this.JBTHuellaActionPerformed(evt);
            }
        });
        this.lblEstado.setFont(new Font("Arial", 1, 12));
        this.lblEstado.setForeground(new Color(0, 0, 255));
        this.lblEstado.setHorizontalAlignment(0);
        this.lblEstado.setText("Activo");
        this.lblEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.lblEstado.setOpaque(true);
        this.lblEstado.addPropertyChangeListener(new PropertyChangeListener() { // from class: General.Persona.24
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Persona.this.lblEstadoPropertyChange(evt);
            }
        });
        this.jLabel32.setFont(new Font("Arial", 1, 12));
        this.jLabel32.setForeground(new Color(0, 0, 204));
        this.jLabel32.setText("Categoría discapacidad");
        this.JCBCategoriaDiscapacidad.setFont(new Font("Arial", 1, 12));
        GroupLayout JPDPersonales1Layout = new GroupLayout(this.JPDPersonales1);
        this.JPDPersonales1.setLayout(JPDPersonales1Layout);
        JPDPersonales1Layout.setHorizontalGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDPersonales1Layout.createSequentialGroup().addContainerGap().addGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel32, -2, 212, -2).addComponent(this.JCBCategoriaDiscapacidad, -2, 246, -2)).addGap(18, 18, 18).addGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.cboEps, -2, 180, -2).addComponent(this.jLabel7, -2, 42, -2)).addGap(18, 18, 18).addGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCEspecial, 0, 199, 32767).addGroup(JPDPersonales1Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblEstado, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTHuella, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JCHBCorteConstitucional).addGap(118, 118, 118)));
        JPDPersonales1Layout.setVerticalGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonales1Layout.createSequentialGroup().addContainerGap().addGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDPersonales1Layout.createSequentialGroup().addGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jLabel12)).addGap(36, 36, 36)).addGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDPersonales1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblEstado).addComponent(this.JCBCEspecial, -2, 28, -2)).addComponent(this.JBTHuella, -2, 40, -2)).addComponent(this.JCHBCorteConstitucional).addComponent(this.cboEps, -2, 30, -2).addGroup(JPDPersonales1Layout.createSequentialGroup().addComponent(this.jLabel32).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCategoriaDiscapacidad, -2, 30, -2))).addGap(0, 98, 32767)));
        this.panelPersona.addTab("DATOS PERSONALES 1", this.JPDPersonales1);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(Color.blue);
        this.jLabel1.setText("Tipo de Afiliado");
        this.cboTipoAfiliado.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setForeground(Color.blue);
        this.jLabel25.setText("Correo Electrónico");
        this.txtCorreo.setFont(new Font("Arial", 1, 12));
        this.txtCorreo.addFocusListener(new FocusAdapter() { // from class: General.Persona.25
            public void focusGained(FocusEvent evt) {
                Persona.this.txtCorreoFocusGained(evt);
            }
        });
        this.txtCorreo.addKeyListener(new KeyAdapter() { // from class: General.Persona.26
            public void keyPressed(KeyEvent evt) {
                Persona.this.txtCorreoKeyPressed(evt);
            }
        });
        this.txtTelefono.setFont(new Font("Arial", 1, 12));
        this.txtTelefono.setHorizontalAlignment(4);
        this.txtTelefono.addFocusListener(new FocusAdapter() { // from class: General.Persona.27
            public void focusGained(FocusEvent evt) {
                Persona.this.txtTelefonoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtTelefonoFocusLost(evt);
            }
        });
        this.txtTelefono.addKeyListener(new KeyAdapter() { // from class: General.Persona.28
            public void keyPressed(KeyEvent evt) {
                Persona.this.txtTelefonoKeyPressed(evt);
            }
        });
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setForeground(Color.blue);
        this.jLabel24.setText("Teléfono Fijo");
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setForeground(Color.blue);
        this.jLabel23.setText("Dirección");
        this.txtDireccion.setFont(new Font("Arial", 1, 12));
        this.txtDireccion.addFocusListener(new FocusAdapter() { // from class: General.Persona.29
            public void focusGained(FocusEvent evt) {
                Persona.this.txtDireccionFocusGained(evt);
            }
        });
        this.txtDireccion.addKeyListener(new KeyAdapter() { // from class: General.Persona.30
            public void keyPressed(KeyEvent evt) {
                Persona.this.txtDireccionKeyPressed(evt);
            }
        });
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setForeground(Color.blue);
        this.jLabel22.setText("Barrio");
        this.cboBarrio.setFont(new Font("Arial", 1, 12));
        this.cboBarrio.setPreferredSize(new Dimension(20, 20));
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setForeground(Color.blue);
        this.jLabel21.setText("Lugar de Residencia - Municipio");
        this.cboMunicipio.setFont(new Font("Arial", 1, 10));
        this.cboMunicipio.addItemListener(new ItemListener() { // from class: General.Persona.31
            public void itemStateChanged(ItemEvent evt) {
                Persona.this.cboMunicipioItemStateChanged(evt);
            }
        });
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(Color.blue);
        this.jLabel6.setText("Etnia");
        this.cboEtnia.setFont(new Font("Arial", 1, 10));
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setForeground(Color.blue);
        this.jLabel20.setText("Estado Cívil");
        this.cboEstadoCivil.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setFont(new Font("Arial", 1, 12));
        this.jLabel26.setForeground(Color.blue);
        this.jLabel26.setText("Lugar Nacimiento");
        this.JCBLNacimiento.setFont(new Font("Arial", 1, 10));
        this.JCBLNacimiento.setPreferredSize(new Dimension(20, 20));
        this.jLabel27.setFont(new Font("Arial", 1, 12));
        this.jLabel27.setForeground(Color.blue);
        this.jLabel27.setText("N° Afiliacion/Carnet");
        this.txtAfiliacion.setFont(new Font("Arial", 1, 12));
        this.txtAfiliacion.addFocusListener(new FocusAdapter() { // from class: General.Persona.32
            public void focusGained(FocusEvent evt) {
                Persona.this.txtAfiliacionFocusGained(evt);
            }
        });
        this.txtAfiliacion.addKeyListener(new KeyAdapter() { // from class: General.Persona.33
            public void keyPressed(KeyEvent evt) {
                Persona.this.txtAfiliacionKeyPressed(evt);
            }
        });
        this.jLabel28.setFont(new Font("Arial", 1, 12));
        this.jLabel28.setForeground(Color.blue);
        this.jLabel28.setText("Celular");
        this.txtTelefono1.setFont(new Font("Arial", 1, 12));
        this.txtTelefono1.setHorizontalAlignment(4);
        this.txtTelefono1.addFocusListener(new FocusAdapter() { // from class: General.Persona.34
            public void focusGained(FocusEvent evt) {
                Persona.this.txtTelefono1FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtTelefono1FocusLost(evt);
            }
        });
        this.txtTelefono1.addKeyListener(new KeyAdapter() { // from class: General.Persona.35
            public void keyPressed(KeyEvent evt) {
                Persona.this.txtTelefono1KeyPressed(evt);
            }
        });
        this.jLabel29.setFont(new Font("Arial", 1, 12));
        this.jLabel29.setForeground(Color.blue);
        this.jLabel29.setText("Población Especial");
        this.cboPobEspecial.setFont(new Font("Arial", 1, 12));
        this.cboPobEspecial.addActionListener(new ActionListener() { // from class: General.Persona.36
            public void actionPerformed(ActionEvent evt) {
                Persona.this.cboPobEspecialActionPerformed(evt);
            }
        });
        GroupLayout JPDAdicionalesLayout = new GroupLayout(this.JPDAdicionales);
        this.JPDAdicionales.setLayout(JPDAdicionalesLayout);
        JPDAdicionalesLayout.setHorizontalGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDAdicionalesLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDAdicionalesLayout.createSequentialGroup().addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel20, -2, 80, -2).addComponent(this.cboEstadoCivil, -2, 99, -2)).addGap(6, 6, 6).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.cboEtnia, -2, 174, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel29, -1, -1, 32767).addComponent(this.cboPobEspecial, -2, 110, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel21).addComponent(this.cboMunicipio, -2, 176, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel22).addComponent(this.cboBarrio, -2, 146, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel26).addComponent(this.JCBLNacimiento, 0, -1, 32767))).addGroup(JPDAdicionalesLayout.createSequentialGroup().addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel23).addComponent(this.txtDireccion, -2, 158, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel24).addComponent(this.txtTelefono, -2, 105, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel28).addComponent(this.txtTelefono1, -2, 123, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtCorreo).addComponent(this.jLabel25, -2, 162, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboTipoAfiliado, -2, 159, -2).addComponent(this.jLabel1, -2, 100, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel27, -2, 140, -2).addComponent(this.txtAfiliacion, -2, 132, -2)))).addGap(75, 75, 75)));
        JPDAdicionalesLayout.setVerticalGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDAdicionalesLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDAdicionalesLayout.createSequentialGroup().addComponent(this.jLabel20).addGap(6, 6, 6).addComponent(this.cboEstadoCivil, -2, 30, -2)).addGroup(JPDAdicionalesLayout.createSequentialGroup().addComponent(this.jLabel6).addGap(6, 6, 6).addComponent(this.cboEtnia, -2, 30, -2)).addGroup(JPDAdicionalesLayout.createSequentialGroup().addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel22).addComponent(this.jLabel29)).addGap(6, 6, 6).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboBarrio, -2, 30, -2).addComponent(this.cboPobEspecial, -2, 30, -2))).addGroup(JPDAdicionalesLayout.createSequentialGroup().addComponent(this.jLabel21).addGap(6, 6, 6).addComponent(this.cboMunicipio, -2, 30, -2))).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDAdicionalesLayout.createSequentialGroup().addComponent(this.jLabel26).addGap(36, 36, 36)).addComponent(this.JCBLNacimiento, -2, 30, -2))).addGap(9, 9, 9).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDAdicionalesLayout.createSequentialGroup().addComponent(this.jLabel23).addGap(6, 6, 6).addComponent(this.txtDireccion, -2, 30, -2)).addGroup(JPDAdicionalesLayout.createSequentialGroup().addGroup(JPDAdicionalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel24).addComponent(this.jLabel1)).addGap(6, 6, 6).addComponent(this.txtTelefono, -2, 30, -2)).addGroup(JPDAdicionalesLayout.createSequentialGroup().addComponent(this.jLabel27).addGap(6, 6, 6).addComponent(this.txtAfiliacion, -2, 30, -2)).addComponent(this.cboTipoAfiliado, -2, 30, -2)).addGroup(JPDAdicionalesLayout.createSequentialGroup().addComponent(this.jLabel25).addGap(6, 6, 6).addComponent(this.txtCorreo, -2, 30, -2))).addGroup(JPDAdicionalesLayout.createSequentialGroup().addComponent(this.jLabel28).addGap(6, 6, 6).addComponent(this.txtTelefono1, -2, 30, -2))).addContainerGap()));
        this.panelPersona.addTab("DATOS ADICIONALES", this.JPDAdicionales);
        this.JPDRLaboral.setLayout(new AbsoluteLayout());
        this.panelGrupoSangre.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Sanguineo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.panelGrupoSangre.setForeground(new Color(0, 0, 204));
        this.cboSangre.setFont(new Font("Arial", 1, 12));
        this.cboSangre.setModel(new DefaultComboBoxModel(new String[]{"-", "A", "B", "O", "AB"}));
        this.cboSangre.addActionListener(new ActionListener() { // from class: General.Persona.37
            public void actionPerformed(ActionEvent evt) {
                Persona.this.cboSangreActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.btnNegativo);
        this.btnNegativo.setFont(new Font("Arial", 1, 12));
        this.btnNegativo.setForeground(Color.blue);
        this.btnNegativo.setText("Negativo");
        this.btnNegativo.addActionListener(new ActionListener() { // from class: General.Persona.38
            public void actionPerformed(ActionEvent evt) {
                Persona.this.btnNegativoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.btnPositivo);
        this.btnPositivo.setFont(new Font("Arial", 1, 12));
        this.btnPositivo.setForeground(Color.blue);
        this.btnPositivo.setText("Positivo");
        this.btnPositivo.addActionListener(new ActionListener() { // from class: General.Persona.39
            public void actionPerformed(ActionEvent evt) {
                Persona.this.btnPositivoActionPerformed(evt);
            }
        });
        GroupLayout panelGrupoSangreLayout = new GroupLayout(this.panelGrupoSangre);
        this.panelGrupoSangre.setLayout(panelGrupoSangreLayout);
        panelGrupoSangreLayout.setHorizontalGroup(panelGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelGrupoSangreLayout.createSequentialGroup().addComponent(this.cboSangre, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnNegativo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnPositivo)));
        panelGrupoSangreLayout.setVerticalGroup(panelGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboSangre, -2, 29, -2).addComponent(this.btnPositivo).addComponent(this.btnNegativo)));
        this.JPDRLaboral.add(this.panelGrupoSangre, new AbsoluteConstraints(650, 60, -1, -1));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(Color.blue);
        this.jLabel5.setText("Documento de Identidad del Trabajador o Cotizante a Quien se le Realiza el Descuento");
        this.JPDRLaboral.add(this.jLabel5, new AbsoluteConstraints(6, 66, -1, -1));
        this.txtNbreCotizante.setEditable(false);
        this.txtNbreCotizante.setBackground(new Color(0, 0, 153));
        this.txtNbreCotizante.setFont(new Font("Arial", 1, 12));
        this.txtNbreCotizante.setForeground(new Color(255, 255, 255));
        this.JPDRLaboral.add(this.txtNbreCotizante, new AbsoluteConstraints(172, 89, 306, 30));
        this.txtIdentificacionFuncionario.setFont(new Font("Arial", 1, 12));
        this.txtIdentificacionFuncionario.addFocusListener(new FocusAdapter() { // from class: General.Persona.40
            public void focusGained(FocusEvent evt) {
                Persona.this.txtIdentificacionFuncionarioFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.txtIdentificacionFuncionarioFocusLost(evt);
            }
        });
        this.txtIdentificacionFuncionario.addKeyListener(new KeyAdapter() { // from class: General.Persona.41
            public void keyPressed(KeyEvent evt) {
                Persona.this.txtIdentificacionFuncionarioKeyPressed(evt);
            }
        });
        this.JPDRLaboral.add(this.txtIdentificacionFuncionario, new AbsoluteConstraints(6, 89, 160, 30));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(Color.blue);
        this.jLabel4.setText("Código 1Sap (Si Aplica)");
        this.JPDRLaboral.add(this.jLabel4, new AbsoluteConstraints(507, 63, 151, 20));
        this.cboRelacionLaboral.setFont(new Font("Arial", 1, 12));
        this.JPDRLaboral.add(this.cboRelacionLaboral, new AbsoluteConstraints(425, 26, 163, 30));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(Color.blue);
        this.jLabel3.setText("Empresa");
        this.JPDRLaboral.add(this.jLabel3, new AbsoluteConstraints(226, 6, 80, -1));
        this.cboTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.cboTipoEmpresa.addItemListener(new ItemListener() { // from class: General.Persona.42
            public void itemStateChanged(ItemEvent evt) {
                Persona.this.cboTipoEmpresaItemStateChanged(evt);
            }
        });
        this.JPDRLaboral.add(this.cboTipoEmpresa, new AbsoluteConstraints(226, 26, 187, 30));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(Color.blue);
        this.jLabel2.setText("Parentesco");
        this.JPDRLaboral.add(this.jLabel2, new AbsoluteConstraints(6, 6, 90, -1));
        this.cboParentesco.setFont(new Font("Arial", 1, 12));
        this.JPDRLaboral.add(this.cboParentesco, new AbsoluteConstraints(6, 26, 210, 30));
        this.JTFFCodifoSap.setFont(new Font("Arial", 1, 12));
        this.JTFFCodifoSap.setText("0");
        this.JTFFCodifoSap.addFocusListener(new FocusAdapter() { // from class: General.Persona.43
            public void focusGained(FocusEvent evt) {
                Persona.this.JTFFCodifoSapFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Persona.this.JTFFCodifoSapFocusLost(evt);
            }
        });
        this.JTFFCodifoSap.addKeyListener(new KeyAdapter() { // from class: General.Persona.44
            public void keyPressed(KeyEvent evt) {
                Persona.this.JTFFCodifoSapKeyPressed(evt);
            }
        });
        this.JPDRLaboral.add(this.JTFFCodifoSap, new AbsoluteConstraints(507, 91, 110, 27));
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(Color.blue);
        this.jLabel8.setText("Relacion Laboral");
        this.JPDRLaboral.add(this.jLabel8, new AbsoluteConstraints(425, 0, -1, 20));
        this.JLBUnidadN.setFont(new Font("Arial", 1, 12));
        this.JLBUnidadN.setForeground(Color.blue);
        this.JLBUnidadN.setText("Unidad de Negocio");
        this.JPDRLaboral.add(this.JLBUnidadN, new AbsoluteConstraints(600, 0, -1, 20));
        this.JCBUnidadN.setFont(new Font("Arial", 1, 12));
        this.JPDRLaboral.add(this.JCBUnidadN, new AbsoluteConstraints(600, 26, 291, 30));
        this.panelPersona.addTab("RELACIÓN LABORAL", this.JPDRLaboral);
        this.JPDOcupacionales.setLayout(new AbsoluteLayout());
        this.JCBCargo.setFont(new Font("Arial", 1, 12));
        this.JCBCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JCBCargo, new AbsoluteConstraints(6, 6, 218, -1));
        this.JCBSupervisor.setFont(new Font("Arial", 1, 12));
        this.JCBSupervisor.setBorder(BorderFactory.createTitledBorder((Border) null, "Supervisor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSupervisor.addActionListener(new ActionListener() { // from class: General.Persona.45
            public void actionPerformed(ActionEvent evt) {
                Persona.this.JCBSupervisorActionPerformed(evt);
            }
        });
        this.JPDOcupacionales.add(this.JCBSupervisor, new AbsoluteConstraints(230, 6, 253, -1));
        this.JCBSegmento.setFont(new Font("Arial", 1, 12));
        this.JCBSegmento.setToolTipText("Grupo Similar de Exposicion");
        this.JCBSegmento.setBorder(BorderFactory.createTitledBorder((Border) null, "SEG", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JCBSegmento, new AbsoluteConstraints(489, 6, 145, -1));
        this.JCBArl.setFont(new Font("Arial", 1, 12));
        this.JCBArl.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JCBArl, new AbsoluteConstraints(6, 67, 195, -1));
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JCBGrupo, new AbsoluteConstraints(207, 67, 189, -1));
        this.JSPNHijos.setFont(new Font("Arial", 1, 12));
        this.JSPNHijos.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Hijos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JSPNHijos, new AbsoluteConstraints(597, 67, 78, -1));
        this.JSPNClaSE.setFont(new Font("Arial", 1, 12));
        this.JSPNClaSE.setToolTipText("CLasificacion Socio Economica");
        this.JSPNClaSE.setBorder(BorderFactory.createTitledBorder((Border) null, "Cla. SE", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JSPNClaSE, new AbsoluteConstraints(681, 67, 78, -1));
        this.JDFechaIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha de Ingreso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaIngreso.setDateFormatString("dd/MM/yyyy");
        this.JDFechaIngreso.setFont(new Font("Arial", 1, 11));
        this.JDFechaIngreso.setName("txtFecha");
        this.JDFechaIngreso.addFocusListener(new FocusAdapter() { // from class: General.Persona.46
            public void focusGained(FocusEvent evt) {
                Persona.this.JDFechaIngresoFocusGained(evt);
            }
        });
        this.JDFechaIngreso.addPropertyChangeListener(new PropertyChangeListener() { // from class: General.Persona.47
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Persona.this.JDFechaIngresoPropertyChange(evt);
            }
        });
        this.JPDOcupacionales.add(this.JDFechaIngreso, new AbsoluteConstraints(770, 60, -1, 49));
        this.JCBLateralidad.setFont(new Font("Arial", 1, 12));
        this.JCBLateralidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Lateralidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JCBLateralidad, new AbsoluteConstraints(402, 67, 189, -1));
        this.JCBJornada.setFont(new Font("Arial", 1, 12));
        this.JCBJornada.setToolTipText("");
        this.JCBJornada.setBorder(BorderFactory.createTitledBorder((Border) null, "Jornada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JCBJornada, new AbsoluteConstraints(640, 6, 160, -1));
        this.JSPNHorasTrabajadas.setFont(new Font("Arial", 1, 12));
        this.JSPNHorasTrabajadas.setToolTipText("Horas Trabajadas");
        this.JSPNHorasTrabajadas.setBorder(BorderFactory.createTitledBorder((Border) null, "Horas Trab.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPDOcupacionales.add(this.JSPNHorasTrabajadas, new AbsoluteConstraints(812, 6, 108, -1));
        this.panelPersona.addTab("DATOS OCUPACIONALES", this.JPDOcupacionales);
        this.jScrollPane1.setVerticalScrollBarPolicy(22);
        this.JTDocumentos.setFont(new Font("Arial", 1, 12));
        this.JTDocumentos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDocumentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDocumentos.setSelectionForeground(new Color(255, 0, 0));
        this.JTDocumentos.addMouseListener(new MouseAdapter() { // from class: General.Persona.48
            public void mouseClicked(MouseEvent evt) {
                Persona.this.JTDocumentosMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDocumentos);
        this.JTFRuta.setEditable(false);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Seleccione Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setMaximumSize(new Dimension(64, 35));
        this.JTFRuta.setRequestFocusEnabled(false);
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: General.Persona.49
            public void mouseClicked(MouseEvent evt) {
                Persona.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JCBTipoDocumentoSoporte.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumentoSoporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBSubirArchivo.setFont(new Font("Arial", 1, 12));
        this.JBSubirArchivo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBSubirArchivo.setText("ANEXAR ARCHIVO");
        this.JBSubirArchivo.addActionListener(new ActionListener() { // from class: General.Persona.50
            public void actionPerformed(ActionEvent evt) {
                Persona.this.JBSubirArchivoActionPerformed(evt);
            }
        });
        GroupLayout JPDocAnexosLayout = new GroupLayout(this.JPDocAnexos);
        this.JPDocAnexos.setLayout(JPDocAnexosLayout);
        JPDocAnexosLayout.setHorizontalGroup(JPDocAnexosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDocAnexosLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 398, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDocAnexosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDocumentoSoporte, -2, 304, -2).addComponent(this.JTFRuta, -2, 286, -2)).addGap(18, 18, 18).addComponent(this.JBSubirArchivo).addContainerGap(107, 32767)));
        JPDocAnexosLayout.setVerticalGroup(JPDocAnexosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDocAnexosLayout.createSequentialGroup().addGroup(JPDocAnexosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDocAnexosLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumentoSoporte, -2, 50, -2)).addComponent(this.jScrollPane1, -2, 116, -2)).addGap(0, 38, 32767)).addGroup(JPDocAnexosLayout.createSequentialGroup().addContainerGap().addComponent(this.JBSubirArchivo, -2, 106, -2).addContainerGap(-1, 32767)));
        this.panelPersona.addTab("ANEXOS", this.JPDocAnexos);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, 1005, -2).addGap(0, 12, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.panelPersona, -2, -1, -2).addGap(0, 12, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoIdentificacionItemStateChanged(ItemEvent evt) {
        if (this.cboTipoIdentificacion.getSelectedIndex() > -1 && this.comboLleno == 1) {
            this.txtIdentificacion.setExprecionRegular(this.listaTipoIdentificacion[this.cboTipoIdentificacion.getSelectedIndex()][5]);
            System.out.println("ID==" + this.listaTipoIdentificacion[this.cboTipoIdentificacion.getSelectedIndex()][6]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtIdentificacionFocusLost(FocusEvent evt) {
        this.txtIdentificacion.setText(this.metodos.validarTexto(getIdentificacion(), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtIdentificacionFocusGained(FocusEvent evt) {
        this.txtIdentificacion.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtIdentificacionActionPerformed(ActionEvent evt) {
        this.txtApellido1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido1FocusLost(FocusEvent evt) {
        this.txtApellido1.setText(this.metodos.validarTexto(getApellido1(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido1FocusGained(FocusEvent evt) {
        this.txtApellido1.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido1ActionPerformed(ActionEvent evt) {
        this.txtApellido2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido2FocusLost(FocusEvent evt) {
        this.txtApellido2.setText(this.metodos.validarTexto(getApellido2(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido2FocusGained(FocusEvent evt) {
        this.txtApellido2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtApellido2ActionPerformed(ActionEvent evt) {
        this.txtNombre1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre1FocusLost(FocusEvent evt) {
        this.txtNombre1.setText(this.metodos.validarTexto(getNombre1(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre1FocusGained(FocusEvent evt) {
        this.txtNombre1.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre1ActionPerformed(ActionEvent evt) {
        this.txtNombre2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre2FocusLost(FocusEvent evt) {
        this.txtNombre2.setText(this.metodos.validarTexto(getNombre2(), 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre2FocusGained(FocusEvent evt) {
        this.txtNombre2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNombre2ActionPerformed(ActionEvent evt) {
        this.cboSexo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFechaNacimientoPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno) {
            mCalculaEdad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFechaNacimientoFocusGained(FocusEvent evt) {
    }

    private void mCalculaEdad() {
        if (this.cboFechaNacimiento.getDate() != null) {
            this.txtEdad.setText("" + this.xGConsultasSqlDAO.devolverEdadDosFechas(this.metodos.formatoAMD1.format(this.cboFechaNacimiento.getDate()), this.metodos.formatoAMD1.format(this.metodos.getFechaActual())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lblEstadoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaFocusLost(FocusEvent evt) {
        this.txtHistoria.setText(this.metodos.validarTexto(getHistoria(), 2));
        buscar(2);
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") && this.idModulo == 7) {
            JIFCarneCitas carnet = new JIFCarneCitas(null, true, getIdPersona(), "CitasGral", this);
            carnet.setLocationRelativeTo(this);
            carnet.setVisible(true);
            return;
        }
        buscar(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaFocusGained(FocusEvent evt) {
        this.txtHistoria.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaActionPerformed(ActionEvent evt) {
        this.cboTipoIdentificacion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboMunicipioItemStateChanged(ItemEvent evt) {
        if (this.comboLleno == 1 && this.cboMunicipio.getSelectedIndex() > -1) {
            cargarBarrio();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDireccionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtCorreo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDireccionFocusGained(FocusEvent evt) {
        this.txtDireccion.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTelefonoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.cboMunicipio.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTelefonoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTelefonoFocusGained(FocusEvent evt) {
        this.txtTelefono.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCorreoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.cboTipoAfiliado.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCorreoFocusGained(FocusEvent evt) {
        this.txtCorreo.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoEmpresaItemStateChanged(ItemEvent evt) {
        if (this.comboLleno == 1 && this.cboTipoEmpresa.getSelectedIndex() > -1) {
            cargarRelacionLaboral();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtIdentificacionFuncionarioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 40 || evt.getKeyCode() == 10 || evt.getKeyCode() == 38) {
            this.cboParentesco.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtIdentificacionFuncionarioFocusLost(FocusEvent evt) {
        buscarCotizante();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtIdentificacionFuncionarioFocusGained(FocusEvent evt) {
        this.txtIdentificacionFuncionario.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPositivoActionPerformed(ActionEvent evt) {
        this.rh = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNegativoActionPerformed(ActionEvent evt) {
        this.rh = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboSangreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodifoSapFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodifoSapFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodifoSapKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtAfiliacionFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtAfiliacionKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIngresoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIngresoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTelefono1FocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTelefono1FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTelefono1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            FileNameExtensionFilter filtroPdf = new FileNameExtensionFilter("Archivos pdf", new String[]{"pdf"});
            xfilec.setFileFilter(filtroPdf);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.metodos.mTraerUrlBD(this.xfile.getAbsolutePath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSubirArchivoActionPerformed(ActionEvent evt) {
        mSubirArchivo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDocumentosMouseClicked(MouseEvent evt) {
        if (this.JTDocumentos.getSelectedRow() != -1) {
            this.metodos.getFilePdfPath(this.directorio.getPath(), this.xmodeloSoporte.getValueAt(this.JTDocumentos.getSelectedRow(), 2).toString(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHuellaActionPerformed(ActionEvent evt) {
        Object[] botones1 = {"Identificar Usuario", "Registrar Biometria", "Cerrar"};
        int v = JOptionPane.showOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, (Icon) null, botones1, "Cerrar");
        if (v == 0) {
            JDBiometrico xjdBiometrico = new JDBiometrico((Frame) null, true, this);
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
        } else if (v == 1) {
            if (!Principal.txtNo.getText().isEmpty()) {
                JDBiometrico xjdBiometrico2 = new JDBiometrico(null, true, "xIngreso", Principal.txtNo.getText());
                xjdBiometrico2.setTemplate(null);
                xjdBiometrico2.setVisible(true);
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe cargar un Ingreso", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtEdad1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtEdad1FocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtEdad1FocusLost(FocusEvent evt) {
        if (this.txtEdad1.isTextoValido() && !this.txtEdad1.getText().equals("")) {
            this.cboFechaNacimiento.setDate(this.metodos.mCalcularFechaNac(this.txtEdad1.getText()));
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            JOptionPane.showMessageDialog(this, "\tEstimado Usuario \nPor Favor Verificar el Tipo de Documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSupervisorActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEpsItemStateChanged(ItemEvent evt) {
        if (this.lleno && (Principal.informacionIps.getIdentificacion().equals("812000317") || (Principal.informacionIps.getIdentificacion().equals("812001579") && this.citaNp))) {
            this.frmCitaNp.frmIngreso.llenarComboConvenio(4);
        }
        if (this.frmFacturac != null && this.frmFacturac.clasefacturacion.idSalida.isEmpty() && this.frmFacturac.cargaInicial == 1) {
            this.frmFacturac.frmIngreso.llenarComboConvenio(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHistoriaKeyPressed(KeyEvent evt) {
        if (!Principal.informacionIps.getIdentificacion().equals("812000852")) {
            if (evt.getKeyCode() == 9) {
                this.barcode.add(this.txtHistoria.getText());
                if (this.txtHistoria.getText().isEmpty()) {
                    this.contador++;
                } else {
                    this.txtHistoria.setText("");
                }
                if (this.contador == 2) {
                    this.contador = 0;
                    System.out.println("--->" + this.barcode.get(0));
                    this.txtHistoria.setText(this.barcode.get(0));
                    this.txtHistoria.setText(this.metodos.validarTexto(getHistoria(), 2));
                    this.barcode.clear();
                    buscar(2);
                    this.cboTipoIdentificacion.requestFocus();
                    return;
                }
                return;
            }
            if (evt.getKeyCode() == 10 && !this.barcode.isEmpty()) {
                this.txtHistoria.setText(this.barcode.get(0));
                return;
            }
            return;
        }
        if (evt.getKeyCode() == 9) {
            buscar(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCEspecialActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboPobEspecialActionPerformed(ActionEvent evt) {
        if (this.cboPobEspecial.getSelectedItem().equals("Desplazados")) {
            this.JPDAdicionales.setBackground(new Color(51, 193, 242));
        } else {
            this.JPDAdicionales.setBackground(new Color(236, 233, 216));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboSexoItemStateChanged(ItemEvent evt) {
        if (this.comboLleno == 1 && this.cboSexo.getSelectedIndex() != -1) {
            llenarComboIdentidadGenero(false);
        }
    }

    private void JCBCargoActionPerformed(ActionEvent evt) {
    }

    private void JCBCargoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.metodos.esIPSMineros()) {
            actualizarCargoIngreso();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    public Date getPasarTextoAFecha(String texto) {
        GregorianCalendar fecha = new GregorianCalendar();
        new Date();
        String dia = texto.substring(0, 2);
        String mes = texto.substring(2, 4);
        String ano = texto.substring(4, 8);
        fecha.set(Integer.parseInt(ano), Integer.parseInt(mes) - 1, Integer.parseInt(dia));
        Date fecha1 = fecha.getTime();
        return fecha1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloSoporte() {
        this.xmodeloSoporte = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre Documento", "URL"}) { // from class: General.Persona.51
            Class[] types = {Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDocumentos.setModel(this.xmodeloSoporte);
        this.JTDocumentos.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTDocumentos.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDocumentos.getColumnModel().getColumn(2).setPreferredWidth(250);
    }

    private void mBuscarSoportes() {
        mCrearModeloSoporte();
        String sql2 = "SELECT `g_persona_documento`.`Id` , `g_tipo_documento_soporte`.`Nbre` , `g_persona_documento`.`Ruta`  FROM `g_persona_documento` INNER JOIN  `g_tipo_documento_soporte`   ON (`g_persona_documento`.`IdTipoDoc` = `g_tipo_documento_soporte`.`Id`)  WHERE (`g_persona_documento`.`Estado` =1 AND `g_persona_documento`.`IdPersona` ='" + this.IdPersona + "')";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql2);
        try {
            if (xrs1.next()) {
                xrs1.beforeFirst();
                int n = 0;
                while (xrs1.next()) {
                    this.xmodeloSoporte.addRow(this.xdatos);
                    this.xmodeloSoporte.setValueAt(xrs1.getString(1), n, 0);
                    this.xmodeloSoporte.setValueAt(xrs1.getString(2), n, 1);
                    this.xmodeloSoporte.setValueAt(xrs1.getString(3), n, 2);
                    n++;
                }
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mCopiarArchivo(String rutaOriginal, String rutaDestino) {
        try {
            File archivoOriginal = new File(rutaOriginal);
            File archivoCopia = new File(rutaDestino);
            InputStream inputStream = new FileInputStream(archivoOriginal);
            OutputStream outputStream = new FileOutputStream(archivoCopia);
            byte[] buffer = new byte[1024];
            while (true) {
                int length = inputStream.read(buffer);
                if (length > 0) {
                    outputStream.write(buffer, 0, length);
                } else {
                    inputStream.close();
                    outputStream.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void mSubirArchivo() {
        if (!this.IdPersona.equals("")) {
            if (!this.JTFRuta.getText().isEmpty()) {
                if (this.JCBTipoDocumentoSoporte.getSelectedIndex() != -1) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        new File(this.metodos.mRutaSoporte("Persona"));
                        String sql = "INSERT INTO `g_persona_documento` ( `IdPersona`,  `IdTipoDoc`, `UsuarioS`) VALUES (  '" + this.IdPersona + "',  '" + this.xidSoporteDoc[this.JCBTipoDocumentoSoporte.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        String xidDoc = this.consultas.ejecutarSQLId(sql);
                        String adjunto = xidDoc + "_" + this.IdPersona + "_" + this.JCBTipoDocumentoSoporte.getSelectedItem() + ".pdf";
                        String sql2 = "UPDATE g_persona_documento set Ruta='" + this.metodos.mTraerUrlBD(adjunto) + "' WHERE Id='" + xidDoc + "'";
                        this.consultas.ejecutarSQL(sql2);
                        this.consultas.cerrarConexionBd();
                        boolean seCopio = mCopiarArchivo(this.JTFRuta.getText(), this.metodos.mRutaSoporte("Persona") + this.metodos.getBarra() + adjunto);
                        if (seCopio) {
                            mBuscarSoportes();
                            this.JTFRuta.setText("");
                            this.JCBTipoDocumentoSoporte.setSelectedIndex(-1);
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Error al cargar el archivo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoDocumentoSoporte.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFRuta.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una persona", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void actualizarCargoIngreso() {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (verificarIngresoPersona()) {
                JDActualizarCargoSO actualizarCargo = new JDActualizarCargoSO(null, true, Principal.txtNo.getText(), this.txtHistoria.getText(), this.JCBCargo.getSelectedItem().toString());
                actualizarCargo.setLocationRelativeTo(this);
                actualizarCargo.setVisible(true);
                return;
            }
            JOptionPane.showMessageDialog(this, "Verifique persona o ingreso", "VERIFICAR", 1);
            return;
        }
        JOptionPane.showMessageDialog(this, "Seleccione un ingreso", "VERIFICAR", 1);
    }

    private boolean verificarIngresoPersona() {
        boolean x = false;
        String sql = "SELECT\n COUNT(*) x\nFROM\n  `g_persona` gp\n  INNER JOIN ingreso i\n    ON i.`Id_Usuario` = gp.`Id`\nWHERE i.`Id` = '" + Principal.txtNo.getText() + "'\n  AND gp.`NoDocumento` = '" + this.txtHistoria.getText() + "'";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet rs = xct1.traerRs(sql);
        try {
            if (rs.next() && !rs.getString("x").equals("0")) {
                x = true;
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
        return x;
    }
}
