package Acceso;

import Activos.claseGActivos;
import Armado.claseGestionCuentas;
import AutorizacionMP.clasesAutorizacionMP;
import Autorizaciones.Autoriza;
import Caja.claseCaja;
import CajaMenor.claseCajaMenor;
import Cirugia.claseCirugia;
import Citas.clasesCita;
import ComprasBS.claseComprasBienesServicios;
import Contabilidad.JIFRadicacion;
import Contabilidad.claseContabilidad;
import Enfermeria.claseEnfermeria;
import Facturacion.TareaProgramacion;
import Facturacion.claseFacturacion;
import General.AccesoModulos;
import General.Acercade;
import General.claseGeneral;
import GestionDoc.clasesGestionDoc;
import Historia.JDPatologia;
import Historia.clasesHistoriaCE;
import ImagenesDx.claseImagenesDx;
import Informes.JFInformes_P;
import Informes.clasesInformes;
import Inventarios.claseInventario;
import Laboratorio.JIFRemisionLab;
import Laboratorio.JIFRemisionLab2;
import Laboratorio.claseLab;
import Mantenimiento.claseMantenimiento;
import Odontologia.claseOdonto;
import Parametrizacion.claseParametrizacion;
import ParametrizacionN.claseParametrizacionN;
import Presupuesto.clasePresupuesto;
import PyP.clasePyP;
import RecursosHumanos.clasesRecursosHumanos;
import Salud_Ocupacional.claseSo;
import Sgc.JDGenericoCb;
import Sgc.claseSgc;
import Sig.JDMapaProceso;
import Sig.claseSig;
import Triage.claseTriage;
import Utilidades.ConnectionManager;
import Utilidades.MDIDesktopPane;
import Utilidades.Metodos;
import Utilidades.MetodosAlertasGenerales;
import Utilidades.tree.PersistentRegionEditor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.config.PersistenceJPAConfig;
import com.genoma.plus.controller.auditoria_medica.claseAuditoriaMedica;
import com.genoma.plus.controller.digitalizacion_soporte.ClaseDigitalizacionSoporte;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.referencia.ClaseReferencia;
import com.genoma.plus.controller.tesoreria.ClaseTesoreriaController;
import com.genoma.plus.controller.transicion.ClaseTrancision;
import com.genoma.plus.dao.general.AlertasGeneralesDAO;
import com.genoma.plus.dao.general.SseClosableDAO;
import com.genoma.plus.dao.impl.general.AlertasGeneralesDAOImpl;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.dto.general.GeneralDTO;
import com.genoma.plus.dto.general.InformacionGeneralPrincipalDTO;
import com.genoma.plus.dto.general.InformacionIpsDTO;
import com.genoma.plus.dto.general.UsuarioSistemaDTO;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.l2fprod.common.swing.JCollapsiblePane;
import com.l2fprod.common.swing.JLinkButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import org.flexdock.demos.util.DemoUtility;
import org.flexdock.docking.DockingManager;
import org.flexdock.util.SwingUtility;
import org.flexdock.view.Titlebar;
import org.flexdock.view.View;
import org.flexdock.view.Viewport;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Acceso/Principal.class */
public class Principal extends JFrame {
    public static String endPointAnkara;
    private MetodosBotones xmetodoBotones;
    private static AlertasGeneralesDAO alertaGeneralesDAO;
    public Menus xMenus;
    public Menus1 xMenus1;
    public JIFRadicacion xjifradicacionfac;
    public static claseContabilidad xclasecont;
    public JPModulos jpModulos;
    private MetodosAlertasGenerales xMetodosAlertaG;
    public static ClaseTrancision claseTrancision;
    public static ClaseReferencia claseReferencia;
    public static ClaseDigitalizacionSoporte claseDigitalizacionSoporte;
    public static ClaseTesoreriaController tesoreriaController;
    public static claseSig xclasesig;
    public static claseCirugia xclaseCirugia;
    public static claseSgc xclasesgc;
    public static clasePresupuesto xclasePresupuesto;
    public JDMapaProceso xjdmapap;
    public Autoriza frmAutoriza;
    public JIFRemisionLab frmRemision2;
    public JIFRemisionLab2 frmRemision;
    private static String idUsuarioS;
    private String[] modulos;
    public static UsuarioSistemaDTO usuarioSistemaDTO;
    public static GeneralDTO sedeUsuarioSeleccionadaDTO;
    public static InformacionIpsDTO informacionIps;
    public static InformacionGeneralPrincipalDTO informacionGeneralPrincipalDTO;
    private static InetAddress localHost;
    public static IResolucionFacturaElectronica xIResolucionFacturaElectronica;
    public static String consultorio;
    public static String ubicacion;
    public List<RecursosMicroserviciosDomain> listMicroServiciosModulo;
    public static JPanel Contenedor;
    private JMenu MenuArchivo;
    public JPanel PanelCont;
    public static MDIDesktopPane PanelPpal;
    public static JToolBar barraBotones;
    public static JMenuBar barraMnuPrincipal;
    public JLabel JLBInformacionU;
    private JLabel JLBLogo;
    private JLabel JLBLogo1;
    public JLabel JLBPeridoC;
    public JLabel JLBUvt;
    public JLabel JLB_Sede;
    private JButton btnAnterior;
    private JButton btnAnular;
    private JButton btnBuscar;
    public static JButton btnCancelar;
    private JButton btnCerrar;
    private static JButton btnGrabar;
    private JButton btnImprimir;
    private static JButton btnNuevo;
    private JButton btnPrimer;
    private JButton btnSiguiente;
    private JButton btnUltimo;
    public static JLabel lblEstado;
    public static JLabel lblFecha;
    public static JLabel lblNo;
    private JScrollPane scroll;
    public static JLabel txtEstado;
    public static JLabel txtFecha;
    public static JLabel txtNo;
    public static AnnotationConfigApplicationContext contexto = new AnnotationConfigApplicationContext(new Class[]{PersistenceJPAConfig.class});
    public static claseGeneral clasegeneral = null;
    public static claseCaja clasecaja = null;
    public static claseInventario xClaseInventario = null;
    public static claseTriage clasetriage = null;
    public static claseFacturacion clasefacturacion = null;
    public static clasesCita clasescita = null;
    public static claseContabilidad xclase = null;
    public static clasePyP clasepyp = null;
    public static claseEnfermeria claseenfer = null;
    public static clasesInformes claseinformes = null;
    public static clasesAutorizacionMP claseautorizacionmp = null;
    public static clasesHistoriaCE clasehistoriace = null;
    public static clasesGestionDoc clasegestiondoc = null;
    public static claseGActivos xclasegactivo = null;
    public static claseOdonto xclaseodontologia = null;
    public static claseAuditoriaMedica xclaseAuditoriaMedica = null;
    public static claseLab claselab = null;
    public static claseMantenimiento clasemant = null;
    public static claseParametrizacion claseparametrizacion = null;
    public static claseParametrizacionN claseparametrizacionn = null;
    public static clasesRecursosHumanos claserecursoshumanos = null;
    public static claseCajaMenor clascajamenor = null;
    public static claseImagenesDx claseimagendx = null;
    public static claseComprasBienesServicios clasecomprabn = null;
    public static claseGestionCuentas xclasegc = null;
    public static clasesCita claseCita = null;
    public static claseSo xclaseso = null;
    public static claseOdonto xclaseodontolgia = null;
    private static String titulo = "G@noma Plus";
    public static PersistentRegionEditor xJtree = new PersistentRegionEditor();
    public static PersistentRegionEditor xJtreeCal = new PersistentRegionEditor();
    public JLinkButton btnAuditoriaFacturas = new JLinkButton();
    private Metodos metodos = new Metodos();
    public int activarMenu = 0;
    public int cajaAbierta = 1;
    public int utilCita = 0;

    public Principal(String[] Modulos, UsuarioSistemaDTO usuarioSistemaDTO2, GeneralDTO sedeUsuarioSeleccionadaDTO2, InformacionIpsDTO informacionIps2, InformacionGeneralPrincipalDTO informacionGeneralPrincipalDTO2) {
        initComponents();
        usuarioSistemaDTO = usuarioSistemaDTO2;
        sedeUsuarioSeleccionadaDTO = sedeUsuarioSeleccionadaDTO2;
        informacionIps = informacionIps2;
        informacionGeneralPrincipalDTO = informacionGeneralPrincipalDTO2;
        springStart();
        this.modulos = Modulos;
        informacionGeneralPrincipalDTO.setActivarFormularioDemandaInducida(false);
        informacionGeneralPrincipalDTO.setAtencionPreferencial(0);
        informacionGeneralPrincipalDTO.setAplicaAtencionPreferencial(false);
        informacionGeneralPrincipalDTO.setActivarEncuestaIngreso(false);
        String urlRecusosAnkara = this.metodos.mRutaSoporte("urlRecursosAnkara");
        if (!urlRecusosAnkara.isEmpty() && urlRecusosAnkara != null) {
            informacionIps.setUrlRecursosAnkara(urlRecusosAnkara);
        }
        this.xMenus = new Menus(this);
        this.xMenus1 = new Menus1(this);
        this.jpModulos = new JPModulos(this);
        this.xMetodosAlertaG = new MetodosAlertasGenerales();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/iconogenomaplus.png")));
        this.JLB_Sede.setText("SEDE : " + sedeUsuarioSeleccionadaDTO2.getNombre());
        this.JLBInformacionU.setText("<html><P ALIGN=left><font color=#0000FF> USUARIO : " + usuarioSistemaDTO2.getNombreUsuario() + "</font></p> <font color=#0000FF>CARGO : " + usuarioSistemaDTO2.getNombreCargoUsuario() + "</font> <P><P> UF : " + usuarioSistemaDTO2.getUnidadFuncional() + "<P>LIDER :  " + usuarioSistemaDTO2.getNombreLider());
        setContentPane(createContentPane());
        clasegeneral = new claseGeneral();
        claseparametrizacionn = new claseParametrizacionN(this);
        claseparametrizacion = new claseParametrizacion();
        xclasesgc = new claseSgc();
        colocarTitulo();
        mOcultarBotonesModulos();
        activarBotonesModulos();
        organizarPantalla();
        mCambiarUbicacionLogos();
        iniciarLocalHost();
        mDesactivarBotonesConsulta();
        this.JLBPeridoC.setVisible(false);
        this.JLBUvt.setVisible(false);
        this.jpModulos.JSTree.getViewport().add(xJtree.buildUi());
        this.jpModulos.JSTreeCal.getViewport().add(xJtreeCal.buildUiCal());
        if (!informacionIps2.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            JPModulos jPModulos = this.jpModulos;
            JPModulos.barraOutlook.remove(2);
        }
        consultarIdEspecialidadUsuarioSistema();
        if (!informacionIps2.getNombreIps().equals("MINEROS S.A") || !informacionIps2.getNombreIps().equals("MINEROS ALUVIAL S.A.S") || !informacionIps2.getNombreIps().equals("FUNDACION MINERO S.A.S") || !informacionIps2.getNombreIps().equals("OPERADORA MINERA S.A.S") || !informacionIps2.getNombreIps().equals("NEGOCIOS AGROFORESTALES S.A.S")) {
            verificarSeguimientosFicha5w1h();
            verificarEncuestasPendientes();
            verificarSolicitudes_Autorizar();
            verificarUsuarioCaja();
            this.jpModulos.btnInformes.setText("<html><P ALIGN=center>Informes");
        } else {
            this.jpModulos.btnInformes.setText("<html><P ALIGN=center>Consultar Concepto Salud Ocupacional");
        }
        this.xMetodosAlertaG.mNUsuarioPendienteSeguimiento();
        this.xMetodosAlertaG = new MetodosAlertasGenerales(this);
        this.xmetodoBotones = new MetodosBotones(this);
        ocultarComponenteUtilidades();
        this.jpModulos.btnCirugia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cirugia.png")));
        this.btnAuditoriaFacturas.setText("Auditoría Facturas Contables");
        this.btnAuditoriaFacturas.addActionListener(new ActionListener() { // from class: Acceso.Principal.1
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnAuditoriaFacturasActionPerformed(evt);
            }
        });
        this.jpModulos.jTaskPane1.add(this.btnAuditoriaFacturas, 3);
        if (informacionIps.getAplicaMicroservicios().booleanValue()) {
            getCargarListUrlModulo("100", "General");
        }
    }

    public static String getEndPointAnkara() {
        return endPointAnkara;
    }

    public AnnotationConfigApplicationContext getContexto() {
        return contexto;
    }

    public JCollapsiblePane getJBTUtilidades() {
        return this.jpModulos.JBTUtilidades;
    }

    private void ocultarComponenteUtilidades() {
        if (informacionIps.getNombreIps().equals("MINEROS S.A") || informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S") || informacionIps.getNombreIps().equals("FUNDACION MINERO S.A.S") || informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || informacionIps.getNombreIps().equals("NEGOCIOS AGROFORESTALES S.A.S")) {
            this.jpModulos.btnAcronimos.setVisible(false);
            this.jpModulos.btnAutorizacionDoc.setVisible(false);
            this.jpModulos.btnAdmNovedadesNomina.setVisible(false);
            this.jpModulos.btnProgramadorReuniones.setVisible(false);
            this.jpModulos.btnRadiDocumento.setVisible(false);
            this.jpModulos.btnRegistroResiduos.setVisible(false);
            this.jpModulos.btnRequisicion.setVisible(false);
            this.jpModulos.btnRutaSoportes.setVisible(false);
            this.jpModulos.btnSolicitud.setVisible(false);
            this.jpModulos.btnRegistroActas.setVisible(false);
        }
    }

    public void cerrar() throws SQLException {
        confirmarSalida();
    }

    public void confirmarSalida() throws SQLException {
        setDefaultCloseOperation(0);
        Object[] opciones = {"Si", "No"};
        int eleccion = JOptionPane.showOptionDialog(this.rootPane, "Esta seguro de cerrar la aplicación", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), opciones, "Aceptar");
        if (eleccion == 0) {
            ConnectionManager.cerrarConexionBaseDatos();
            System.exit(0);
        }
    }

    private void mCambiarUbicacionLogos() {
        this.JLBLogo1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logotipo Genoma Plus.png")));
        this.JLBLogo.setIcon(new ImageIcon(this.metodos.getRutaRep() + informacionIps.getUrlLogoIps()));
    }

    private void consultarIdEspecialidadUsuarioSistema() {
        informacionGeneralPrincipalDTO.setIdEspecialidad(alertaGeneralesDAO.consultarIdEspecialidadUsuarioSistema(usuarioSistemaDTO.getIdUsuarioSistema()));
    }

    private void preguntarActivacionFAutorizacion() {
        if (informacionIps.getEsFpz().intValue() == 0) {
            clasefacturacion.setxCargarAutorizacion(0);
            return;
        }
        int x = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea activar formulario para realizar autorizaciones?.</p>", "FORMULARIO DE AUTORIZACIONES", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            clasefacturacion.setxCargarAutorizacion(1);
        }
    }

    public void mDesactivarBotonesConsulta() {
        if (usuarioSistemaDTO.getEsConsulta().intValue() == 1) {
            this.btnAnular.setEnabled(false);
            btnCancelar.setEnabled(false);
            btnGrabar.setEnabled(false);
        } else {
            this.btnAnular.setEnabled(true);
            btnCancelar.setEnabled(true);
            btnGrabar.setEnabled(true);
        }
    }

    private void springStart() {
        alertaGeneralesDAO = (AlertasGeneralesDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("alertasGeneralesDAO");
    }

    private void verificarSeguimientosFicha5w1h() {
        Integer numeroAcciones = alertaGeneralesDAO.numeroAccionesFicha5w1h(usuarioSistemaDTO.getIdPersonaCargo());
        if (numeroAcciones.intValue() != 0) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Usted tiene " + numeroAcciones + " accion(es) pendientes en la Ficha5W1H por registrar seguimiento;<br>Desea verificar?</p>";
            int x = JOptionPane.showConfirmDialog(this, xmensaje, "CONTROL DE SEGUIMIENTO EN FICHA 5W1H", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Seguimiento_5W1H_64.png"))));
            if (x == 0) {
                clasegeneral.cargarPantalla("Ficha 5w1H");
            }
        }
    }

    public void preguntarRealizacionDemandaInducida() {
        if (informacionIps.getEsFpz().intValue() == 0) {
            informacionGeneralPrincipalDTO.setActivarFormularioDemandaInducida(true);
            return;
        }
        int x = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea activar formulario;<br>para realizar demanda inducida?.</p>", "DEMANDA INDUCIDA", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            informacionGeneralPrincipalDTO.setActivarFormularioDemandaInducida(true);
        } else {
            informacionGeneralPrincipalDTO.setActivarFormularioDemandaInducida(false);
        }
    }

    public void activarPreguntarEncuestaIngreso() {
        if (informacionIps.getEsFpz().intValue() == 0) {
            informacionGeneralPrincipalDTO.setActivarEncuestaIngreso(true);
            return;
        }
        int x = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea activar encuesta de ingreso(Laboratorio);<br></p>", "DEMANDA INDUCIDA", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            informacionGeneralPrincipalDTO.setActivarEncuestaIngreso(true);
        } else {
            informacionGeneralPrincipalDTO.setActivarEncuestaIngreso(false);
        }
    }

    public void verificarEncuestasPendientes() {
        Integer numeroEncuesta = alertaGeneralesDAO.numeroEncuestasPendientes(usuarioSistemaDTO.getIdUsuarioSistema());
        if (numeroEncuesta.intValue() != 0) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Usted tiene " + numeroEncuesta + " encuenta(s) por responder;<br>Favor seleccionar la encuesta y diligenciar</p>";
            JOptionPane.showMessageDialog(this, xmensaje, "ENCUESTA DE SATISFACCIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            buscarEncuesta();
        }
    }

    public void activarFormularioAtencionPreferencial() {
        if (informacionIps.getIdentificacion().equals("812000852")) {
            informacionGeneralPrincipalDTO.setAplicaAtencionPreferencial(true);
            return;
        }
        if (!informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            int x = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea realizar clasificación de atención preferencial?</p>", "MANEJO DE ATENCIÓN PREFERENCIAL", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                informacionGeneralPrincipalDTO.setAplicaAtencionPreferencial(true);
            } else {
                informacionGeneralPrincipalDTO.setAplicaAtencionPreferencial(false);
            }
        }
    }

    public void verificarUsuarioCaja() {
        informacionGeneralPrincipalDTO.setEsCajero(alertaGeneralesDAO.verificarUsuarioCajero(usuarioSistemaDTO.getIdUsuarioSistema()));
    }

    public void verificarManejoBodega() {
        informacionGeneralPrincipalDTO.setManejaBodega(alertaGeneralesDAO.verificarUsuarioBodega(usuarioSistemaDTO.getIdUsuarioSistema()));
    }

    private void verificarSolicitudes_Autorizar() {
        Integer numeroSolicitudes = alertaGeneralesDAO.numeroSolicitudesPorAutorizar(usuarioSistemaDTO.getIdUsuarioSistema());
        if (numeroSolicitudes.intValue() != 0) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Usted tiene " + numeroSolicitudes + " Solicitud(es) pendientes por autorizar;<br>Desea verificar?</p>";
            int x = JOptionPane.showConfirmDialog(this, xmensaje, "AUTORIZACIÓN DE SOLICITUDES", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            if (x == 0) {
                try {
                    clasegeneral.cargarPantalla("Autorizar Solicitudes");
                    clasegeneral.jifgestionsol.setSelected(true);
                } catch (PropertyVetoException e) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void preguntarActivacionDemanda() {
        if (informacionIps.getEsFpz().intValue() == 0) {
            informacionGeneralPrincipalDTO.setActivarFormularioDemandaInducida(true);
            return;
        }
        int x = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea activar formulario;<br>para realizar demanda inducida?.</p>", "DEMANDA INDUCIDA", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            informacionGeneralPrincipalDTO.setActivarFormularioDemandaInducida(true);
        }
    }

    private void preguntaActivacionFormaAutorizacion() {
        if (informacionIps.getEsFpz().intValue() == 0) {
            clasefacturacion.setxCargarAutorizacion(0);
            return;
        }
        int x = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea activar formulario;<br>para realizar autorizaciones?.</p>", "ACTIVACION DE FORMULARIO DE AUTORIZACIONES", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            clasefacturacion.setxCargarAutorizacion(1);
        }
    }

    public static void consultar_Datos_Uvt(String xano, String xid, double xvalor, Integer forma) {
        List<Object[]> informacionUvt = alertaGeneralesDAO.mensajeInformacionTopeUvtTercero(xano, Long.valueOf(xid), Double.valueOf(xvalor), forma);
        if (!informacionUvt.isEmpty()) {
            DecimalFormat formatea = new DecimalFormat("###,###.##");
            if (forma.intValue() == 0) {
                informacionGeneralPrincipalDTO.setMensanjeContable("<html><P ALIGN=center> <font face='Arial' color='red' size=4> <b>ESTE PROVEEDOR SUPERO EL TOPE DE LOS " + informacionUvt.get(0)[2] + "<br>UVT DE ACUERDO AL ARTICULO 177 DEL ESTATUTO TRIBUTARIO VALOR ACUMULADO DE  $" + formatea.format(informacionUvt.get(0)[4]) + "</p>");
                return;
            } else {
                informacionGeneralPrincipalDTO.setMensanjeContable("<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>ESTE PROVEEDOR TIENE ACUMULADO A LA FECHA LA SUMA DE $" + formatea.format(informacionUvt.get(0)[4]) + "</p>");
                return;
            }
        }
        informacionGeneralPrincipalDTO.setMensanjeContable("");
    }

    public void verificarContratosPorVencer() {
        List<Object[]> verificacionContratos = alertaGeneralesDAO.verificarListaContratosPorSeguimiento();
        if (!verificacionContratos.isEmpty()) {
            String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4> <b>Tiene " + verificacionContratos.get(0)[0] + " contratos por vencer;<br>Desea verificar</p>";
            int x = JOptionPane.showConfirmDialog(this, xmensaje, "CONTROL DE SEGUIMIENTO DE CONTRATOS", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            if (x == 0) {
                clasecomprabn.cargarPantalla("Registro De Contrato");
            }
        }
    }

    public static void iniciarLocalHost() {
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public static InetAddress getLocalHost() {
        return localHost;
    }

    public static void mGrabarLogAtenciones(String xtipodoc, String xidatencion, String xidusuario) {
        try {
            localHost = InetAddress.getLocalHost();
            alertaGeneralesDAO.grabarLogDocumentosHistoria(xtipodoc, xidatencion, xidusuario, localHost.getHostName(), localHost.getHostAddress());
        } catch (UnknownHostException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void colocarTitulo() {
        if (informacionIps.getIdentificacion().equals("800004808")) {
            setTitle(titulo + "    -    Licenciado a la " + informacionIps.getNombreIps() + " - " + informacionIps.getVersion());
        } else {
            setTitle(titulo + "    -    Licenciado a la " + informacionIps.getNombreIps() + " - " + informacionIps.getVersion() + "    -    Usuario del Sistema : " + usuarioSistemaDTO.getNombreUsuario() + "    Fecha Actual : " + this.metodos.formatoFecha.format(this.metodos.getFechaActual()));
        }
    }

    public void organizarPantalla() {
        try {
            setExtendedState(6);
            SwingUtility.centerOnScreen(this);
            DemoUtility.setCloseOperation(this);
            DockingManager.setFloatingEnabled(true);
            this.metodos.cargarDecoracion();
            setSize(this.metodos.getAnchoPantalla() - 10, this.metodos.getAltoPantalla() - 28);
            setLocationRelativeTo(null);
            barraBotones.setMinimumSize(new Dimension(this.metodos.getAnchoPantalla() - 34, 60));
            barraBotones.setMaximumSize(new Dimension(this.metodos.getAnchoPantalla() - 34, 60));
            barraBotones.setPreferredSize(new Dimension(this.metodos.getAnchoPantalla() - 34, 60));
            Contenedor.setMinimumSize(new Dimension(this.metodos.getAnchoPantalla() - 500, this.metodos.getAltoPantalla() - 50));
            Contenedor.setMaximumSize(new Dimension(this.metodos.getAnchoPantalla() - 500, this.metodos.getAltoPantalla() - 50));
            Contenedor.setPreferredSize(new Dimension(this.metodos.getAnchoPantalla() - 500, this.metodos.getAltoPantalla() - 50));
            this.scroll.setMinimumSize(new Dimension(this.metodos.getAnchoPantalla() - 60, this.metodos.getAltoPantalla() - 200));
            this.scroll.setMaximumSize(new Dimension(this.metodos.getAnchoPantalla() - 60, this.metodos.getAltoPantalla() - 200));
            this.scroll.setPreferredSize(new Dimension(this.metodos.getAnchoPantalla() - 60, this.metodos.getAltoPantalla() - 200));
            this.PanelCont.setMinimumSize(new Dimension(this.metodos.getAnchoPantalla(), this.metodos.getAltoPantalla()));
            this.PanelCont.setMaximumSize(new Dimension(this.metodos.getAnchoPantalla(), this.metodos.getAltoPantalla()));
            this.PanelCont.setPreferredSize(new Dimension(this.metodos.getAnchoPantalla() - 50, this.metodos.getAltoPantalla() - 180));
            btnCancelar.setVisible(false);
            if (usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
                this.jpModulos.JBCrear.setVisible(true);
                this.jpModulos.JBCrearCal.setVisible(true);
            } else {
                this.jpModulos.JBCrear.setVisible(false);
                this.jpModulos.JBCrearCal.setVisible(false);
            }
        } catch (Exception ex) {
            this.metodos.mostrarErrorE(ex);
        }
    }

    private JPanel createContentPane() {
        JPanel p = new JPanel(new BorderLayout(0, 0));
        p.setBorder(new EmptyBorder(5, 5, 5, 5));
        Viewport viewport = new Viewport();
        p.add(viewport, "North");
        View startPage = createStartPage();
        JPModulos jPModulos = this.jpModulos;
        View view2 = createView2("Modulos.mod", "Módulos", JPModulos.ContModulos);
        view2.setActive(false);
        viewport.dock(startPage);
        startPage.dock(view2, "WEST", 0.1f);
        return p;
    }

    private View createView2(String id, String text, JPanel p) {
        View view = new View(id, text);
        view.addAction("pin");
        view.setPreferredSize(new Dimension(384, this.metodos.getAltoPantalla() - 15));
        view.setMaximumSize(new Dimension(384, this.metodos.getAltoPantalla() - 15));
        view.setMinimumSize(new Dimension(384, this.metodos.getAltoPantalla() - 15));
        view.setActionBlocked("pin", true);
        view.setContentPane(p);
        view.setVisible(true);
        view.setActive(true);
        return view;
    }

    private View createStartPage() {
        View view = new View("startPage", (String) null, (String) null);
        view.setTerritoryBlocked("TOP", true);
        view.setTitlebar((Titlebar) null);
        view.setContentPane(Contenedor);
        return view;
    }

    public void acercade() {
        Acercade frmAD = new Acercade(this, true);
        frmAD.setVisible(true);
    }

    public void mActivarBarraMenu(JMenuBar barra, int xmodulo) {
        int y;
        informacionGeneralPrincipalDTO.setIdModulo(Integer.valueOf(xmodulo));
        this.metodos.limpiarDatosPrincipal();
        mQuitarBarraMenu();
        setJMenuBar(barra);
        barra.setEnabled(true);
        barra.setVisible(true);
        this.JLBPeridoC.setVisible(true);
        this.JLBUvt.setVisible(true);
        if (barra == Menus.barraMnuEnfermeria || barra == Menus.barraMnuTriage) {
            if (claseenfer == null) {
                claseenfer = new claseEnfermeria(this);
            }
            if (clasescita == null) {
                clasescita = new clasesCita(this);
                return;
            }
            return;
        }
        if (barra == this.xMenus.barraMnuCita) {
            TareaProgramacion xTareaProgramacionFact = new TareaProgramacion();
            xTareaProgramacionFact.iniciarTarea("formularioCitas");
            if (clasescita == null) {
                clasescita = new clasesCita(this);
            }
            if (clasehistoriace == null) {
                clasehistoriace = new clasesHistoriaCE();
            }
            if (clasefacturacion == null) {
                clasefacturacion = new claseFacturacion();
            }
            btnCancelar.setVisible(true);
            return;
        }
        if (barra == Menus.barraMnuReferencia) {
            if (claseReferencia == null) {
                claseReferencia = new ClaseReferencia(this);
                return;
            }
            return;
        }
        if (barra == Menus.barraMnuSoportesDigitalizados) {
            if (claseDigitalizacionSoporte == null) {
                claseDigitalizacionSoporte = new ClaseDigitalizacionSoporte();
                return;
            }
            return;
        }
        if (barra != Menus.barraMnuCaja) {
            if (barra == Menus.barraMnuGCuentas) {
                if (xclase == null) {
                    xclase = new claseContabilidad(this);
                }
                if (xclasegc == null) {
                    xclasegc = new claseGestionCuentas(this);
                    return;
                }
                return;
            }
            if (barra == Menus.barraMnuFacturacion) {
                TareaProgramacion xTareaProgramacionFact2 = new TareaProgramacion();
                xTareaProgramacionFact2.iniciarTarea("TareaBuscarLiquidaciones");
                if (informacionGeneralPrincipalDTO.getEsCajero().booleanValue()) {
                    this.cajaAbierta = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea cargar la caja?</p>", "CAJA DE INGRESOS", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (this.cajaAbierta == 0) {
                        AccesoModulos frmA = new AccesoModulos(null, true, "MODULO DE CAJA", "Caja", "k_caja", this);
                        frmA.setVisible(true);
                        frmA.setEnabled(true);
                        if (clasecaja == null) {
                            clasecaja = new claseCaja(this, 12);
                        }
                        if (clasecaja.verificarCajaAbierta() == null || clasecaja.verificarCajaAbierta().equals("")) {
                            clasecaja.abrirCierre();
                        }
                        clasecaja.setFechaCierreActual(clasecaja.verificarCajaAbierta());
                    }
                }
                clasefacturacion = new claseFacturacion(this, 1, this.cajaAbierta, clasecaja);
                if (informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                    int xaplica = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea aplicar encuesta?</p>", "ENCUESTA", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    clasefacturacion.setXaplicaencuesta(xaplica);
                }
                if (informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || informacionIps.getIdentificacion().equals("891408918") || informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || informacionIps.getNombreIps().equals("COLGENES S.A.S") || informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
                    clasefacturacion.setXrecepcionalaboratorio(1);
                } else if (informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    claselab = new claseLab();
                } else {
                    preguntarActivacionFAutorizacion();
                }
                if (informacionIps.getAplicaFacturacionDeRecepcion().booleanValue() && (y = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea activar formulario de recepción?</p>", "RECEPCIÓN MUESTRAS DE LABORATORIO", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))))) == 0) {
                    clasefacturacion.setXrecepcionalaboratorio(y);
                    if (informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        claselab = new claseLab();
                        claseLab claselab2 = claselab;
                        claseLab.interaccionAgendas = true;
                    } else {
                        claselab = new claseLab();
                        claseLab claselab3 = claselab;
                        claseLab.interaccionAgendas = false;
                    }
                }
                if (informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || informacionIps.getIdentificacion().equals("891408918") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || informacionIps.getNombreIps().equals("GENOMA EMPRESARIAL CONSULTORES SAS") || informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL") || informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS") || informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S") || informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                    clasefacturacion.setXrecepcionalaboratorio(0);
                    clasefacturacion.cargarPantalla("AgendaSimedis");
                    claselab = new claseLab();
                } else if (informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    clasefacturacion.cargarPantalla("AgendaSimedisBienestar");
                } else if (informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S") || informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
                    clasefacturacion.cargarPantalla("AgendaTaquilla");
                } else {
                    clasefacturacion.cargarPantalla("Facturac");
                }
                if (informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
                    Menus.mnuAgendaSimedis.setText("Agenda Simedis");
                    Menus.mnuAgendaSimedis.setToolTipText("Agenda de usuarios admisionados en simedis");
                } else if (informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS")) {
                    Menus.mnuAgendaSimedis.setText("Agenda Sifas");
                    Menus.mnuAgendaSimedis.setToolTipText("Agenda de usuarios admisionados en sifas");
                } else if (informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL") || informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS") || informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                    Menus.mnuAgendaSimedis.setText("Agenda Ordenes Laboratorio");
                    Menus.mnuAgendaSimedis.setToolTipText("Agenda de usuarios admisionados en Dinamica Gerencial");
                } else if (informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || informacionIps.getIdentificacion().equals("891408918") || informacionIps.getIdentificacion().equals("COLGENES S.A.S")) {
                    Menus.mnuAgendaSimedis.setText("Agenda Ordenes Laboratorio");
                } else {
                    Menus.mnuAgendaSimedis.setVisible(false);
                }
                btnCancelar.setVisible(true);
                return;
            }
            Menus menus = this.xMenus;
            if (barra == Menus.barraMnuInventario) {
                if (informacionIps.getAplicaFacturacionDespacho().booleanValue()) {
                    int x = JOptionPane.showConfirmDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea desactivar formulario para facturación?.</p>", "FORMULARIO DE AUTORIZACIONES", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        informacionIps.setAplicaFacturacionDespacho(false);
                        return;
                    }
                    return;
                }
                return;
            }
            if (barra == this.xMenus.barraMnuPyP) {
                if (clasepyp == null) {
                    clasepyp = new clasePyP(this);
                    return;
                }
                return;
            }
            if (barra == JFInformes_P.barraMnuInformes || barra == Menus.JMBInformesV) {
                if (claseinformes == null) {
                    claseinformes = new clasesInformes();
                    claseinformes.cargarPantalla("Consultar Concepto Salud Ocupacional");
                    return;
                } else {
                    claseinformes.cargarPantalla("Consultar Concepto Salud Ocupacional");
                    return;
                }
            }
            if (barra == Menus.barraMnuAutorizacionMP) {
                if (claseautorizacionmp == null) {
                    claseautorizacionmp = new clasesAutorizacionMP();
                    return;
                }
                return;
            }
            if (barra == Menus1.barraMnuCitologix) {
                claselab = new claseLab();
                claselab.setFitroCitologias(1);
                return;
            }
            if (barra == Menus1.barraMnuTesoreria) {
                tesoreriaController = new ClaseTesoreriaController(this);
                return;
            }
            if (barra == Menus.barraMnuSgc || barra == Menus1.JMBSgcP6 || barra == Menus1.JMBSgcP5) {
                xclasesgc = new claseSgc();
                return;
            }
            if (barra == Menus.barraMnuGestionDoc) {
                if (clasegestiondoc == null) {
                    clasegestiondoc = new clasesGestionDoc();
                }
                if (clasehistoriace == null) {
                    clasehistoriace = new clasesHistoriaCE();
                }
                if (claselab == null) {
                    claselab = new claseLab();
                    return;
                }
                return;
            }
            Menus menus2 = this.xMenus;
            if (barra == Menus.barraMnuLab) {
                TareaProgramacion xTareaProgramacionFact3 = new TareaProgramacion();
                xTareaProgramacionFact3.iniciarTarea("formularioLaboratorio");
                claselab = new claseLab();
                if (informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                    Object[] botones = {"Laboratorios", "Citologias", "Ambas"};
                    claselab.setFitroCitologias(JOptionPane.showOptionDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Que desea recepcionar?</p>", "RECEPCIÓN MUESTRAS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Ambas"));
                }
                btnCancelar.setVisible(true);
                return;
            }
            Menus menus3 = this.xMenus;
            if (barra == Menus.barraMnuMant) {
                if (clasemant == null) {
                    clasemant = new claseMantenimiento();
                    return;
                }
                return;
            }
            Menus menus4 = this.xMenus;
            if (barra != Menus.barraMnuRrhh) {
                Menus menus5 = this.xMenus;
                if (barra != Menus.JMBAdministracionNomina) {
                    Menus menus6 = this.xMenus;
                    if (barra != Menus.JMBAdministracionNomina) {
                        Menus menus7 = this.xMenus;
                        if (barra == Menus.barraMnuParametrizacion) {
                            if (claseparametrizacion == null) {
                                claseparametrizacion = new claseParametrizacion();
                            }
                            if (claseparametrizacionn == null) {
                                claseparametrizacionn = new claseParametrizacionN(this);
                            }
                            if (usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
                                this.jpModulos.JBCrear.setVisible(true);
                                return;
                            }
                            return;
                        }
                        Menus menus8 = this.xMenus;
                        if (barra == Menus.barraMnuCajaM) {
                            if (clascajamenor == null) {
                                clascajamenor = new claseCajaMenor(this);
                                return;
                            }
                            return;
                        }
                        Menus menus9 = this.xMenus;
                        if (barra == Menus.barraMnuImagenDx) {
                            if (claseimagendx == null) {
                                claseimagendx = new claseImagenesDx(this);
                                return;
                            }
                            return;
                        }
                        Menus menus10 = this.xMenus;
                        if (barra == Menus.barraMnuCompras) {
                            if (clasecomprabn == null) {
                                clasecomprabn = new claseComprasBienesServicios(this);
                                return;
                            }
                            return;
                        }
                        Menus menus11 = this.xMenus;
                        if (barra == Menus.barraMnuGCuentas) {
                            xclasegc = new claseGestionCuentas(this);
                            return;
                        }
                        Menus menus12 = this.xMenus;
                        if (barra == Menus.JMBOdontologia) {
                            if (xclaseodontolgia == null) {
                                xclaseodontolgia = new claseOdonto(this);
                            }
                            if (clasehistoriace == null) {
                                clasehistoriace = new clasesHistoriaCE();
                                return;
                            }
                            return;
                        }
                        Menus menus13 = this.xMenus;
                        if (barra == Menus.JMBSo) {
                            if (clasehistoriace == null) {
                                clasehistoriace = new clasesHistoriaCE();
                            }
                            if (xclaseso == null) {
                                xclaseso = new claseSo(this);
                                clasescita = new clasesCita(this);
                                return;
                            }
                            return;
                        }
                        Menus menus14 = this.xMenus;
                        if (barra == Menus.barraMnuGestionActivo) {
                            if (xclasegactivo == null) {
                                xclasegactivo = new claseGActivos(this);
                            }
                            if (clasemant == null) {
                                clasemant = new claseMantenimiento();
                                return;
                            }
                            return;
                        }
                        Menus menus15 = this.xMenus;
                        if (barra == Menus.barraMnuCirugia) {
                            if (xclaseCirugia == null) {
                                xclaseCirugia = new claseCirugia(this);
                            }
                            if (clasefacturacion == null) {
                                clasefacturacion = new claseFacturacion(this, 1, this.cajaAbierta, clasecaja);
                            }
                            if (clasehistoriace == null) {
                                clasehistoriace = new clasesHistoriaCE();
                            }
                            if (informacionIps.getAplicaVisualizarAgendasNuevas().booleanValue()) {
                                if (informacionIps.getIdentificacion().equals("812007286") || informacionIps.getIdentificacion().equals("901440362")) {
                                    Menus.JMIP_AgendaN.setVisible(false);
                                    Menus.JMIAgendaN1.setVisible(false);
                                    Menus.JMIAgendaServicios.setVisible(false);
                                    return;
                                }
                                Menus.JMIP_AgendaN.setVisible(false);
                                return;
                            }
                            return;
                        }
                        if (barra == this.xMenus.barraMnuAuditoriaMedica) {
                            if (xclaseAuditoriaMedica == null) {
                                xclaseAuditoriaMedica = new claseAuditoriaMedica(this);
                                clasefacturacion = new claseFacturacion(this, 1, this.cajaAbierta, clasecaja);
                                return;
                            }
                            return;
                        }
                        if (barra == Menus.barraMnuTrancisionXenco && claseTrancision == null) {
                            claseTrancision = new ClaseTrancision();
                            return;
                        }
                        return;
                    }
                }
            }
            if (claserecursoshumanos == null) {
                claserecursoshumanos = new clasesRecursosHumanos();
            }
            if (xclase == null) {
                xclase = new claseContabilidad(this);
            }
        }
    }

    public void mIniciarDatosFacturacion() {
        if (informacionGeneralPrincipalDTO.getEsCajero().booleanValue()) {
            this.cajaAbierta = this.metodos.getPregunta("<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea cargar la Caja?</p>");
            if (this.cajaAbierta == 0) {
                AccesoModulos frmA = new AccesoModulos(null, true, "MODULO DE CAJA", "Caja", "k_caja", this);
                frmA.setVisible(true);
                frmA.setEnabled(true);
                if (clasecaja == null) {
                    clasecaja = new claseCaja(this, 12);
                }
                if (clasecaja.verificarCajaAbierta() == null || clasecaja.verificarCajaAbierta().equals("")) {
                    clasecaja.abrirCierre();
                }
                clasecaja.setFechaCierreActual(clasecaja.verificarCajaAbierta());
            }
        }
        clasefacturacion = new claseFacturacion(this, 1, this.cajaAbierta, clasecaja);
        clasefacturacion.cargarPantalla("Facturac");
    }

    public void mIniciarDatosFacturacionInventario(String idSalida, String numeroDocumento) {
        if (informacionGeneralPrincipalDTO.getEsCajero().booleanValue()) {
            verificarUsuarioCaja();
        }
        clasefacturacion = new claseFacturacion(this, 1, this.cajaAbierta, clasecaja);
        clasefacturacion.cargarPantalla("Facturac");
        clasefacturacion.frmFacturac.frmIngreso.JCH_AplicaFiltroConvenio.setEnabled(false);
        clasefacturacion.frmFacturac.frmPersona.txtHistoria.setText(numeroDocumento);
        clasefacturacion.frmFacturac.frmPersona.buscar(2);
        clasefacturacion.idSalida = idSalida;
        clasefacturacion.frmFacturac.cargarInformacionSalidaInventario(idSalida);
    }

    private void activarBotonesModulos() {
        if (this.modulos != null) {
            for (String modulo : this.modulos) {
                if (modulo.equals("100")) {
                    this.jpModulos.btnEnfermeria.setEnabled(true);
                    this.jpModulos.btnEnfermeria.setVisible(true);
                    this.jpModulos.btnInventario.setEnabled(true);
                    this.jpModulos.btnCaja.setEnabled(true);
                    this.jpModulos.btnCitas.setEnabled(true);
                    this.jpModulos.btnFacturacion.setEnabled(true);
                    this.jpModulos.btnPyP.setEnabled(true);
                    this.jpModulos.btnTriage.setEnabled(true);
                    this.jpModulos.btnInventario.setVisible(true);
                    this.jpModulos.btnCaja.setVisible(true);
                    this.jpModulos.btnCitas.setVisible(true);
                    this.jpModulos.btnFacturacion.setVisible(true);
                    this.jpModulos.btnPyP.setVisible(true);
                    this.jpModulos.btnTriage.setVisible(true);
                    this.jpModulos.btnInformes.setEnabled(true);
                    this.jpModulos.btnInformes.setVisible(true);
                    this.jpModulos.btnInformes.setEnabled(true);
                    this.jpModulos.btnInformes.setVisible(true);
                    this.jpModulos.btnAutorizacionMP.setEnabled(true);
                    this.jpModulos.btnAutorizacionMP.setVisible(true);
                    this.jpModulos.btnHistoriaCE.setEnabled(true);
                    this.jpModulos.btnHistoriaCE.setVisible(true);
                    this.jpModulos.btnGestionDoc.setEnabled(true);
                    this.jpModulos.btnGestionDoc.setVisible(true);
                    this.jpModulos.btnGestionActivo.setEnabled(true);
                    this.jpModulos.btnGestionActivo.setVisible(true);
                    this.jpModulos.btnSgc.setEnabled(true);
                    this.jpModulos.btnSgc.setVisible(true);
                    this.jpModulos.JBTSo.setEnabled(true);
                    this.jpModulos.JBTSo.setVisible(true);
                    this.jpModulos.btnLab.setEnabled(true);
                    this.jpModulos.btnLab.setVisible(true);
                    this.jpModulos.btnCirugia.setEnabled(true);
                    this.jpModulos.btnCirugia.setVisible(true);
                    this.jpModulos.btnContabilidad1.setEnabled(true);
                    this.jpModulos.btnContabilidad1.setVisible(true);
                    this.jpModulos.btnMantenimiento.setEnabled(true);
                    this.jpModulos.btnMantenimiento.setVisible(true);
                    this.jpModulos.btnParametrizacion.setEnabled(true);
                    this.jpModulos.btnParametrizacion.setVisible(true);
                    this.jpModulos.btnRrhh.setVisible(true);
                    this.jpModulos.btnCajaM.setVisible(true);
                    this.jpModulos.btnImagenDx.setVisible(true);
                    this.jpModulos.btnCompras.setVisible(true);
                    this.jpModulos.JBTGestionC.setEnabled(true);
                    this.jpModulos.JBTGestionC.setVisible(true);
                    this.jpModulos.JBTOodontologia.setEnabled(true);
                    this.jpModulos.JBTOodontologia.setVisible(true);
                    this.jpModulos.JBTInformes.setEnabled(true);
                    this.jpModulos.JBTInformes.setVisible(true);
                    this.jpModulos.btnAuditoriaMedica.setEnabled(true);
                    this.jpModulos.btnAuditoriaMedica.setVisible(true);
                    this.jpModulos.btnTransicionXenco.setEnabled(true);
                    this.jpModulos.btnTransicionXenco.setVisible(true);
                    this.jpModulos.btnReferencia.setEnabled(true);
                    this.jpModulos.btnReferencia.setVisible(true);
                    this.jpModulos.btnSoportesDigitalizados.setEnabled(true);
                    this.jpModulos.btnSoportesDigitalizados.setVisible(true);
                    this.jpModulos.btnTesoreria.setEnabled(true);
                    this.jpModulos.btnTesoreria.setVisible(true);
                    this.jpModulos.btnTesoreria.setEnabled(true);
                    this.jpModulos.btnTesoreria.setVisible(true);
                    this.jpModulos.btnCytologix.setEnabled(true);
                    this.jpModulos.btnCytologix.setVisible(true);
                    this.utilCita = 1;
                    return;
                }
                switch (modulo) {
                    case "3":
                        this.jpModulos.btnEnfermeria.setEnabled(true);
                        this.jpModulos.btnEnfermeria.setVisible(true);
                        break;
                    case "4":
                        this.jpModulos.btnInventario.setEnabled(true);
                        this.jpModulos.btnInventario.setVisible(true);
                        break;
                    case "5":
                        this.jpModulos.btnFacturacion.setEnabled(true);
                        this.jpModulos.btnFacturacion.setVisible(true);
                        break;
                    case "7":
                        this.jpModulos.btnCitas.setEnabled(true);
                        this.jpModulos.btnCitas.setVisible(true);
                        break;
                    case "8":
                        this.jpModulos.btnInformes.setEnabled(true);
                        this.jpModulos.btnInformes.setVisible(true);
                        break;
                    case "9":
                        this.jpModulos.JBTGestionC.setEnabled(true);
                        this.jpModulos.JBTGestionC.setVisible(true);
                        break;
                    case "12":
                        this.jpModulos.btnCaja.setEnabled(true);
                        this.jpModulos.btnCaja.setVisible(true);
                        break;
                    case "13":
                        this.jpModulos.btnTriage.setEnabled(true);
                        this.jpModulos.btnTriage.setVisible(true);
                        break;
                    case "15":
                        this.jpModulos.btnPyP.setEnabled(true);
                        this.jpModulos.btnPyP.setVisible(true);
                        break;
                    case "10":
                        this.jpModulos.btnAutorizacionMP.setEnabled(true);
                        this.jpModulos.btnAutorizacionMP.setVisible(true);
                        break;
                    case "21":
                        this.utilCita = 1;
                        break;
                    case "2":
                        this.jpModulos.btnHistoriaCE.setEnabled(true);
                        this.jpModulos.btnHistoriaCE.setVisible(true);
                        break;
                    case "14":
                        this.jpModulos.btnGestionDoc.setEnabled(true);
                        this.jpModulos.btnGestionDoc.setVisible(true);
                        break;
                    case "23":
                        this.jpModulos.btnSgc.setEnabled(true);
                        this.jpModulos.btnSgc.setVisible(true);
                        break;
                    case "24":
                        this.jpModulos.btnLab.setEnabled(true);
                        this.jpModulos.btnLab.setVisible(true);
                        break;
                    case "25":
                        this.jpModulos.btnMantenimiento.setEnabled(true);
                        this.jpModulos.btnMantenimiento.setVisible(true);
                        break;
                    case "26":
                        this.jpModulos.btnParametrizacion.setEnabled(true);
                        this.jpModulos.btnParametrizacion.setVisible(true);
                        break;
                    case "6":
                        this.jpModulos.btnContabilidad1.setEnabled(true);
                        this.jpModulos.btnContabilidad1.setVisible(true);
                        break;
                    case "27":
                        this.jpModulos.btnRrhh.setEnabled(true);
                        this.jpModulos.btnRrhh.setVisible(true);
                        break;
                    case "28":
                        this.jpModulos.btnCajaM.setEnabled(true);
                        this.jpModulos.btnCajaM.setVisible(true);
                        break;
                    case "29":
                        this.jpModulos.btnImagenDx.setEnabled(true);
                        this.jpModulos.btnImagenDx.setVisible(true);
                        break;
                    case "30":
                        this.jpModulos.btnCompras.setEnabled(true);
                        this.jpModulos.btnCompras.setVisible(true);
                        break;
                    case "31":
                        this.jpModulos.JBTOodontologia.setEnabled(true);
                        this.jpModulos.JBTOodontologia.setVisible(true);
                        break;
                    case "32":
                        this.jpModulos.btnReferencia.setEnabled(true);
                        this.jpModulos.btnReferencia.setVisible(true);
                        break;
                    case "33":
                        this.jpModulos.JBTSo.setEnabled(true);
                        this.jpModulos.JBTSo.setVisible(true);
                        break;
                    case "34":
                        this.jpModulos.btnGestionActivo.setEnabled(true);
                        this.jpModulos.btnGestionActivo.setVisible(true);
                        break;
                    case "35":
                        this.jpModulos.btnCirugia.setEnabled(true);
                        this.jpModulos.btnCirugia.setVisible(true);
                        break;
                    case "16":
                        this.jpModulos.btnAuditoriaMedica.setEnabled(true);
                        this.jpModulos.btnAuditoriaMedica.setVisible(true);
                        break;
                    case "36":
                        this.jpModulos.btnTransicionXenco.setEnabled(true);
                        this.jpModulos.btnTransicionXenco.setVisible(true);
                        break;
                    case "37":
                        this.jpModulos.btnSoportesDigitalizados.setEnabled(true);
                        this.jpModulos.btnSoportesDigitalizados.setVisible(true);
                        break;
                    case "38":
                        this.jpModulos.btnTesoreria.setEnabled(true);
                        this.jpModulos.btnTesoreria.setVisible(true);
                        break;
                    case "39":
                        this.jpModulos.btnCytologix.setEnabled(true);
                        this.jpModulos.btnCytologix.setVisible(true);
                        break;
                }
            }
        }
    }

    public List<RecursosMicroserviciosDomain> getCargarListUrlModulo(String idModulo, String nombre) {
        if (informacionIps.getAplicaMicroservicios().booleanValue()) {
            this.listMicroServiciosModulo = new ArrayList();
            String json1 = idModulo + "_" + nombre;
            String parameter = Base64.getEncoder().encodeToString(json1.getBytes());
            String urlMicroservicio = (String) Optional.ofNullable(sedeUsuarioSeleccionadaDTO.getUrlMicroServicios()).filter(url -> {
                return !url.isEmpty();
            }).orElse(informacionIps.getUrlMicroServicios());
            String fullUrl = urlMicroservicio + "/list-recursos-microservicios/" + parameter;
            try {
                Response response = this.metodos.getResteasyClient().target(fullUrl).request().get();
                int statusCode = response.getStatus();
                if (statusCode == 200) {
                    try {
                        new CustomPresenter();
                        CustomPresenter presenter = (CustomPresenter) this.metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                        this.listMicroServiciosModulo = (List) this.metodos.getMapper().readValue(this.metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<RecursosMicroserviciosDomain>>() { // from class: Acceso.Principal.2
                        });
                        return this.listMicroServiciosModulo;
                    } catch (JsonProcessingException e) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String) null, e);
                        return this.listMicroServiciosModulo;
                    }
                }
            } catch (ProcessingException e2) {
                if (e2.getCause() instanceof ConnectException) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Connection refused: " + fullUrl, e2);
                } else {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, "Error connecting to microservice: " + fullUrl, e2);
                }
            }
        }
        return this.listMicroServiciosModulo;
    }

    private void mAnular() {
        this.xmetodoBotones.mAnular();
    }

    private void mBuscar() {
        this.xmetodoBotones.mBuscar();
    }

    public static void cargarPanel(JPanel panel) {
        PanelPpal.setVisible(false);
        panel.setBounds(1, 1, 1190, 500);
        PanelPpal.add((Component) panel);
        PanelPpal.setVisible(true);
    }

    public static void cargarPantalla(JInternalFrame pantalla) {
        try {
            PanelPpal.add(pantalla);
            PanelPpal.setVisible(true);
            pantalla.repaint();
            pantalla.setVisible(true);
            pantalla.setEnabled(true);
            pantalla.setSelected(true);
        } catch (PropertyVetoException e) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    private void mCancelar() {
        if (null != informacionGeneralPrincipalDTO.getIdModulo()) {
            switch (informacionGeneralPrincipalDTO.getIdModulo().intValue()) {
                case 2:
                    clasegeneral.cargarPantalla("SeguimientoFiltradoUsuario", 1);
                    break;
                case 5:
                    JDPatologia x = new JDPatologia(this, informacionGeneralPrincipalDTO.getEsCajero().booleanValue(), this);
                    x.setLocationRelativeTo(this);
                    x.setVisible(true);
                    break;
                case 7:
                    JDPatologia x2 = new JDPatologia((Frame) this, informacionGeneralPrincipalDTO.getEsCajero().booleanValue(), (Object) this, "7");
                    x2.setLocationRelativeTo(this);
                    x2.setVisible(true);
                    break;
                case 24:
                    JDPatologia x3 = new JDPatologia((Frame) this, informacionGeneralPrincipalDTO.getEsCajero().booleanValue(), (Object) this, "24");
                    x3.setLocationRelativeTo(this);
                    x3.setVisible(true);
                    break;
            }
        }
    }

    public static void desactivarBotonesGuardar() {
        for (int i = 0; i < barraBotones.getComponentCount() - 1; i++) {
            barraBotones.getComponent(i).setEnabled(true);
        }
        btnGrabar.setEnabled(false);
    }

    public static void activarBotones() {
        for (int i = 0; i < barraBotones.getComponentCount() - 1; i++) {
            barraBotones.getComponent(i).setEnabled(true);
        }
    }

    private void mOcultarBotonesModulos() {
        this.jpModulos.btnTriage.setVisible(false);
        this.jpModulos.btnPyP.setVisible(false);
        this.jpModulos.btnAutorizacion.setVisible(false);
        this.jpModulos.btnCaja.setVisible(false);
        this.jpModulos.btnCitas.setVisible(false);
        this.jpModulos.btnFacturacion.setVisible(false);
        this.jpModulos.btnInventario.setVisible(false);
        this.jpModulos.btnContabilidad1.setVisible(false);
        this.jpModulos.btnEnfermeria.setVisible(false);
        this.jpModulos.btnAutorizacionMP.setVisible(false);
        this.jpModulos.btnHistoriaCE.setVisible(false);
        this.jpModulos.btnInformes.setVisible(false);
        this.jpModulos.btnGestionDoc.setVisible(false);
        this.jpModulos.btnGestionActivo.setVisible(false);
        this.jpModulos.btnSgc.setVisible(false);
        this.jpModulos.btnLab.setVisible(false);
        this.jpModulos.btnCirugia.setVisible(false);
        this.jpModulos.btnCirugia.setVisible(false);
        this.jpModulos.btnMantenimiento.setVisible(false);
        this.jpModulos.btnParametrizacion.setVisible(false);
        this.jpModulos.btnRrhh.setVisible(false);
        this.jpModulos.btnCajaM.setVisible(false);
        this.jpModulos.btnImagenDx.setVisible(false);
        this.jpModulos.btnCompras.setVisible(false);
        this.jpModulos.JBTGestionC.setVisible(false);
        this.jpModulos.JBTOodontologia.setVisible(false);
        this.jpModulos.JBTInformes.setVisible(false);
        this.jpModulos.JBTSo.setVisible(false);
        this.jpModulos.btnAuditoriaMedica.setVisible(false);
        this.jpModulos.btnTransicionXenco.setVisible(false);
        this.jpModulos.btnReferencia.setVisible(false);
        this.jpModulos.btnSoportesDigitalizados.setVisible(false);
        this.jpModulos.btnTesoreria.setVisible(false);
        this.jpModulos.btnCytologix.setVisible(false);
    }

    private void mGrabar() {
        this.xmetodoBotones.mGrabar();
    }

    private void mImprimir() {
        this.xmetodoBotones.mImprimir();
    }

    public void mLimpiarPanel() {
        PanelPpal.setVisible(false);
        int x = 0;
        while (x < PanelPpal.getComponentCount()) {
            SseClosableDAO component = PanelPpal.getComponent(x);
            if (component instanceof SseClosableDAO) {
                component.closeSseListeners();
            }
            if (!component.getClass().getName().equals("javax.swing.JLabel") && !component.getName().equals("xjifserialcom")) {
                PanelPpal.remove(x);
                x--;
            }
            x++;
        }
        PanelPpal.setVisible(true);
        this.metodos.limpiarDatosPrincipal();
    }

    private void mNuevo() {
        this.xmetodoBotones.Nuevo();
    }

    private void irAlRegistro(int boton) {
        switch (PanelPpal.getComponent(0).getName()) {
            case "Agendar":
                clasetriage.botones(boton, "Agendar");
                break;
            case "Autoriza":
                this.frmAutoriza.navegar(4);
                break;
            case "Atencion":
                claseenfer.desplazarPuntero(boton, "Atencion");
                break;
            case "jifhistoriaclinica":
                clasehistoriace.mover("jifhistoriaclinica", boton);
                break;
            case "CyD":
                clasepyp.irAlRegistro(1, "CyD");
                break;
            case "Recepcion":
                claselab.desplazar("Recepcion", boton);
                break;
            case "TomaManual":
                claselab.desplazar("TomaManual", boton);
                break;
        }
    }

    public void mQuitarBarraMenu() {
        barraMnuPrincipal.setVisible(false);
        this.xMenus.barraMnuAutorizacion.setVisible(false);
        Menus menus = this.xMenus;
        Menus.barraMnuAutorizacionMP.setVisible(false);
        Menus menus2 = this.xMenus;
        Menus.barraMnuCaja.setVisible(false);
        Menus menus3 = this.xMenus;
        Menus.barraMnuTriage.setVisible(false);
        Menus menus4 = this.xMenus;
        Menus.barraMnuAutorizacionMP.setVisible(false);
        Menus menus5 = this.xMenus;
        Menus.barraMnuHistoriaCE.setVisible(false);
        Menus menus6 = this.xMenus;
        Menus.barraMnuGestionDoc.setVisible(false);
        Menus menus7 = this.xMenus;
        Menus.barraMnuLab.setVisible(false);
        Menus menus8 = this.xMenus;
        Menus.barraMnuCajaM.setVisible(false);
        Menus menus9 = this.xMenus;
        Menus.barraMnuInventario.setVisible(false);
        Menus menus10 = this.xMenus;
        Menus.barraMnuParametrizacion.setVisible(false);
        Menus menus11 = this.xMenus;
        Menus.barraMnuContabilidad.setVisible(false);
        Menus menus12 = this.xMenus;
        Menus.barraMnuEnfermeria.setVisible(false);
        Menus menus13 = this.xMenus;
        Menus.barraMnuImagenDx.setVisible(false);
        Menus menus14 = this.xMenus;
        Menus.barraMnuPresupuesto.setVisible(false);
        Menus1 menus1 = this.xMenus1;
        Menus1.JMBSigPyP.setVisible(false);
        Menus1 menus15 = this.xMenus1;
        Menus1.JMBSgcP5.setVisible(false);
        Menus1 menus16 = this.xMenus1;
        Menus1.JMBSgcP1.setVisible(false);
        Menus1 menus17 = this.xMenus1;
        Menus1.JMBSgcP2.setVisible(false);
        Menus1 menus18 = this.xMenus1;
        Menus1.JMBSgcP3.setVisible(false);
        Menus1 menus19 = this.xMenus1;
        Menus1.JMBSgcP4.setVisible(false);
        Menus1 menus110 = this.xMenus1;
        Menus1.JMBSgcP5.setVisible(false);
        Menus1 menus111 = this.xMenus1;
        Menus1.JMBSgcP6.setVisible(false);
        Menus1 menus112 = this.xMenus1;
        Menus1.JMBSgcP7.setVisible(false);
        Menus1 menus113 = this.xMenus1;
        Menus1.JMBSgcP8.setVisible(false);
        Menus1 menus114 = this.xMenus1;
        Menus1.JMBSgcP9.setVisible(false);
        Menus1 menus115 = this.xMenus1;
        Menus1.JMBSgcP10.setVisible(false);
        Menus1 menus116 = this.xMenus1;
        Menus1.JMBSgcP11.setVisible(false);
        Menus1 menus117 = this.xMenus1;
        Menus1.JMBSgcP12.setVisible(false);
        Menus1 menus118 = this.xMenus1;
        Menus1.JMBSgcP14.setVisible(false);
        Menus1 menus119 = this.xMenus1;
        Menus1.JMBSgcP15.setVisible(false);
        Menus1 menus120 = this.xMenus1;
        Menus1.JMBSgcP16.setVisible(false);
        Menus1.JMBSgcP17.setVisible(false);
        Menus1.JMBSgcP18.setVisible(false);
        Menus1.JMBSgcP19.setVisible(false);
        Menus1 menus121 = this.xMenus1;
        Menus1.JMBSgcP20.setVisible(false);
        Menus1 menus122 = this.xMenus1;
        Menus1.JMBSgcP22.setVisible(false);
        Menus menus20 = this.xMenus;
        Menus.JMBOdontologia.setVisible(false);
        Menus1 menus123 = this.xMenus1;
        Menus1.barraMnuTesoreria.setVisible(false);
        Menus menus21 = this.xMenus;
        Menus.JMBSo.setVisible(false);
        Menus menus22 = this.xMenus;
        Menus.barraMnuGestionActivo.setVisible(false);
        Menus menus23 = this.xMenus;
        Menus.barraMnuReferencia.setVisible(false);
        Menus menus24 = this.xMenus;
        Menus.barraMnuSoportesDigitalizados.setVisible(false);
    }

    public static String getIdUsuarioS() {
        return idUsuarioS;
    }

    public static String getTitulo() {
        return titulo;
    }

    public static void mLimpiarDatosP() {
        Metodos xmt = new Metodos();
        txtEstado.setText("");
        txtNo.setText("");
        txtFecha.setText(xmt.formatoDMA.format(xmt.getFechaActual()));
    }

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/icono.png"));
        return retValue;
    }

    public void setAsignarDatosBodega(String id, String nbre, int tipoBodega, int unidadEmpaque) {
        xClaseInventario = new claseInventario(this);
        xClaseInventario.setIdBodega(id);
        xClaseInventario.setNbreBodega(nbre);
        xClaseInventario.setTipoBodega(tipoBodega);
        xClaseInventario.setUnidadEmpaque(unidadEmpaque);
    }

    public void setAsignarDatosCaja(int idCaja, String nbreCaja, String cDebito, String cCredito) {
        clasecaja = new claseCaja(this, 12);
        clasecaja.setCaja(idCaja);
        clasecaja.setNbreCaja(nbreCaja);
        clasecaja.setCDebito(cDebito);
        clasecaja.setCCredito(cCredito);
    }

    public void setAsignarDatosTriage(String idEspecial, String nbreEspecial) {
        if (clasetriage == null) {
            clasetriage = new claseTriage(this, 13);
        }
        clasetriage.setIdEspecial(idEspecial);
        clasetriage.setNbreEspecial(nbreEspecial);
    }

    public void setAsignarDatosHistoriaCE(String idEspecial, String nbreEspecial, String xidasignarcita, int xFiltroA, int xforma) {
        if (clasehistoriace == null) {
            clasehistoriace = new clasesHistoriaCE();
            clasescita = new clasesCita(this);
            if (informacionIps.getIdentificacion().equals("812007286") || informacionIps.getIdentificacion().equals("901440362")) {
                Menus.JMIP_AgendaN.setVisible(false);
                Menus.JMIAgendaN1.setVisible(false);
                Menus.JMIAgendaServicios.setVisible(false);
            }
        }
        if (xforma == 0 && claselab == null) {
            claselab = new claseLab();
        }
        clasesHistoriaCE.informacionAgendaMedicaDTO.setFiltradoAgenda(Integer.valueOf(xFiltroA));
    }

    private void initComponents() {
        Contenedor = new JPanel();
        barraBotones = new JToolBar();
        btnNuevo = new JButton();
        btnGrabar = new JButton();
        this.btnAnular = new JButton();
        this.btnImprimir = new JButton();
        this.btnBuscar = new JButton();
        this.btnPrimer = new JButton();
        this.btnAnterior = new JButton();
        this.btnSiguiente = new JButton();
        this.btnUltimo = new JButton();
        btnCancelar = new JButton();
        this.btnCerrar = new JButton();
        lblNo = new JLabel();
        txtNo = new JLabel();
        lblFecha = new JLabel();
        txtFecha = new JLabel();
        lblEstado = new JLabel();
        txtEstado = new JLabel();
        this.PanelCont = new JPanel();
        this.scroll = new JScrollPane();
        this.JLBLogo = new JLabel();
        this.JLBPeridoC = new JLabel();
        this.JLBInformacionU = new JLabel();
        this.JLBUvt = new JLabel();
        this.JLBLogo1 = new JLabel();
        this.JLB_Sede = new JLabel();
        PanelPpal = new MDIDesktopPane();
        barraMnuPrincipal = new JMenuBar();
        this.MenuArchivo = new JMenu();
        Contenedor.setBorder(BorderFactory.createEtchedBorder(new Color(204, 204, 204), (Color) null));
        Contenedor.setAutoscrolls(true);
        Contenedor.setMinimumSize(new Dimension(1200, 800));
        Contenedor.setOpaque(false);
        Contenedor.setPreferredSize(new Dimension(1200, 800));
        Contenedor.addKeyListener(new KeyAdapter() { // from class: Acceso.Principal.3
            public void keyPressed(KeyEvent evt) {
                Principal.this.ContenedorKeyPressed(evt);
            }
        });
        Contenedor.setLayout(new AbsoluteLayout());
        barraBotones.setFloatable(false);
        barraBotones.setRollover(true);
        barraBotones.setMaximumSize(new Dimension(1200, 62));
        barraBotones.setMinimumSize(new Dimension(1200, 62));
        barraBotones.setPreferredSize(new Dimension(1200, 62));
        btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        btnNuevo.setMnemonic('N');
        btnNuevo.setText("Nuevo");
        btnNuevo.setAlignmentX(0.5f);
        btnNuevo.setAutoscrolls(true);
        btnNuevo.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(0);
        btnNuevo.setMaximumSize(new Dimension(70, 60));
        btnNuevo.setMinimumSize(new Dimension(70, 60));
        btnNuevo.setPreferredSize(new Dimension(70, 60));
        btnNuevo.setVerticalTextPosition(3);
        btnNuevo.addActionListener(new ActionListener() { // from class: Acceso.Principal.4
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnNuevoActionPerformed(evt);
            }
        });
        barraBotones.add(btnNuevo);
        btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        btnGrabar.setMnemonic('G');
        btnGrabar.setText("Grabar");
        btnGrabar.setAlignmentX(0.5f);
        btnGrabar.setAutoscrolls(true);
        btnGrabar.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        btnGrabar.setFocusPainted(false);
        btnGrabar.setFocusable(false);
        btnGrabar.setHorizontalTextPosition(0);
        btnGrabar.setMaximumSize(new Dimension(70, 60));
        btnGrabar.setMinimumSize(new Dimension(70, 60));
        btnGrabar.setPreferredSize(new Dimension(70, 60));
        btnGrabar.setVerticalTextPosition(3);
        btnGrabar.addActionListener(new ActionListener() { // from class: Acceso.Principal.5
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnGrabarActionPerformed(evt);
            }
        });
        barraBotones.add(btnGrabar);
        this.btnAnular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.btnAnular.setMnemonic('A');
        this.btnAnular.setText("Anular");
        this.btnAnular.setAutoscrolls(true);
        this.btnAnular.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Refrescar29x27.png")));
        this.btnAnular.setFocusPainted(false);
        this.btnAnular.setHorizontalTextPosition(0);
        this.btnAnular.setMaximumSize(new Dimension(70, 60));
        this.btnAnular.setMinimumSize(new Dimension(70, 60));
        this.btnAnular.setPreferredSize(new Dimension(70, 60));
        this.btnAnular.setVerticalTextPosition(3);
        this.btnAnular.addActionListener(new ActionListener() { // from class: Acceso.Principal.6
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnAnularActionPerformed(evt);
            }
        });
        barraBotones.add(this.btnAnular);
        this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.btnImprimir.setMnemonic('I');
        this.btnImprimir.setText("Imprimir");
        this.btnImprimir.setAlignmentX(0.5f);
        this.btnImprimir.setAutoscrolls(true);
        this.btnImprimir.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.btnImprimir.setFocusPainted(false);
        this.btnImprimir.setFocusable(false);
        this.btnImprimir.setHorizontalTextPosition(0);
        this.btnImprimir.setMaximumSize(new Dimension(70, 60));
        this.btnImprimir.setMinimumSize(new Dimension(70, 60));
        this.btnImprimir.setPreferredSize(new Dimension(70, 60));
        this.btnImprimir.setVerticalTextPosition(3);
        this.btnImprimir.addActionListener(new ActionListener() { // from class: Acceso.Principal.7
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnImprimirActionPerformed(evt);
            }
        });
        barraBotones.add(this.btnImprimir);
        this.btnBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setMnemonic('B');
        this.btnBuscar.setText("Buscar");
        this.btnBuscar.setAlignmentX(0.5f);
        this.btnBuscar.setAutoscrolls(true);
        this.btnBuscar.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.btnBuscar.setFocusPainted(false);
        this.btnBuscar.setFocusable(false);
        this.btnBuscar.setHorizontalTextPosition(0);
        this.btnBuscar.setMaximumSize(new Dimension(70, 60));
        this.btnBuscar.setMinimumSize(new Dimension(70, 60));
        this.btnBuscar.setPreferredSize(new Dimension(70, 60));
        this.btnBuscar.setVerticalTextPosition(3);
        this.btnBuscar.addActionListener(new ActionListener() { // from class: Acceso.Principal.8
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnBuscarActionPerformed(evt);
            }
        });
        barraBotones.add(this.btnBuscar);
        this.btnPrimer.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_primer.png")));
        this.btnPrimer.setMnemonic('P');
        this.btnPrimer.setText("Primer");
        this.btnPrimer.setAlignmentX(0.5f);
        this.btnPrimer.setAutoscrolls(true);
        this.btnPrimer.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/b_primer.png")));
        this.btnPrimer.setFocusPainted(false);
        this.btnPrimer.setFocusable(false);
        this.btnPrimer.setHorizontalTextPosition(0);
        this.btnPrimer.setMaximumSize(new Dimension(70, 60));
        this.btnPrimer.setMinimumSize(new Dimension(70, 60));
        this.btnPrimer.setPreferredSize(new Dimension(70, 60));
        this.btnPrimer.setVerticalTextPosition(3);
        this.btnPrimer.addActionListener(new ActionListener() { // from class: Acceso.Principal.9
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnPrimerActionPerformed(evt);
            }
        });
        barraBotones.add(this.btnPrimer);
        this.btnAnterior.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_anterior.png")));
        this.btnAnterior.setMnemonic('T');
        this.btnAnterior.setText("Anterior");
        this.btnAnterior.setAlignmentX(0.5f);
        this.btnAnterior.setAutoscrolls(true);
        this.btnAnterior.setFocusPainted(false);
        this.btnAnterior.setFocusable(false);
        this.btnAnterior.setHorizontalTextPosition(0);
        this.btnAnterior.setMaximumSize(new Dimension(70, 60));
        this.btnAnterior.setMinimumSize(new Dimension(70, 60));
        this.btnAnterior.setPreferredSize(new Dimension(70, 60));
        this.btnAnterior.setVerticalTextPosition(3);
        this.btnAnterior.addActionListener(new ActionListener() { // from class: Acceso.Principal.10
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnAnteriorActionPerformed(evt);
            }
        });
        barraBotones.add(this.btnAnterior);
        this.btnSiguiente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_siguiente.png")));
        this.btnSiguiente.setMnemonic('U');
        this.btnSiguiente.setText("Siguiente");
        this.btnSiguiente.setAlignmentX(0.5f);
        this.btnSiguiente.setAutoscrolls(true);
        this.btnSiguiente.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/b_siguiente.png")));
        this.btnSiguiente.setFocusPainted(false);
        this.btnSiguiente.setFocusable(false);
        this.btnSiguiente.setHorizontalTextPosition(0);
        this.btnSiguiente.setMaximumSize(new Dimension(70, 60));
        this.btnSiguiente.setMinimumSize(new Dimension(70, 60));
        this.btnSiguiente.setPreferredSize(new Dimension(70, 60));
        this.btnSiguiente.setVerticalTextPosition(3);
        this.btnSiguiente.addActionListener(new ActionListener() { // from class: Acceso.Principal.11
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnSiguienteActionPerformed(evt);
            }
        });
        barraBotones.add(this.btnSiguiente);
        this.btnUltimo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_ultimo.png")));
        this.btnUltimo.setMnemonic('O');
        this.btnUltimo.setText("Ultimo");
        this.btnUltimo.setAlignmentX(0.5f);
        this.btnUltimo.setAutoscrolls(true);
        this.btnUltimo.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/b_ultimo.png")));
        this.btnUltimo.setFocusPainted(false);
        this.btnUltimo.setFocusable(false);
        this.btnUltimo.setHorizontalTextPosition(0);
        this.btnUltimo.setMaximumSize(new Dimension(70, 60));
        this.btnUltimo.setMinimumSize(new Dimension(70, 60));
        this.btnUltimo.setPreferredSize(new Dimension(70, 60));
        this.btnUltimo.setVerticalTextPosition(3);
        this.btnUltimo.addActionListener(new ActionListener() { // from class: Acceso.Principal.12
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnUltimoActionPerformed(evt);
            }
        });
        barraBotones.add(this.btnUltimo);
        btnCancelar.setFont(new Font("Arial", 1, 12));
        btnCancelar.setForeground(Color.red);
        btnCancelar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/campana.png")));
        btnCancelar.setMnemonic('C');
        btnCancelar.setText("0");
        btnCancelar.setToolTipText("Liquidaciones Pendientes");
        btnCancelar.setAlignmentX(0.5f);
        btnCancelar.setAutoscrolls(true);
        btnCancelar.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(0);
        btnCancelar.setMaximumSize(new Dimension(70, 60));
        btnCancelar.setMinimumSize(new Dimension(70, 60));
        btnCancelar.setName("xBtnAlertaLiq");
        btnCancelar.setPreferredSize(new Dimension(70, 60));
        btnCancelar.setVerticalTextPosition(3);
        btnCancelar.addActionListener(new ActionListener() { // from class: Acceso.Principal.13
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnCancelarActionPerformed(evt);
            }
        });
        barraBotones.add(btnCancelar);
        this.btnCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnCerrar.setMnemonic('R');
        this.btnCerrar.setText("Cerrar");
        this.btnCerrar.setAlignmentX(0.5f);
        this.btnCerrar.setAutoscrolls(true);
        this.btnCerrar.setDisabledIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.btnCerrar.setFocusPainted(false);
        this.btnCerrar.setFocusable(false);
        this.btnCerrar.setHorizontalTextPosition(0);
        this.btnCerrar.setMaximumSize(new Dimension(70, 60));
        this.btnCerrar.setMinimumSize(new Dimension(70, 60));
        this.btnCerrar.setPreferredSize(new Dimension(70, 60));
        this.btnCerrar.setVerticalTextPosition(3);
        this.btnCerrar.addActionListener(new ActionListener() { // from class: Acceso.Principal.14
            public void actionPerformed(ActionEvent evt) {
                Principal.this.btnCerrarActionPerformed(evt);
            }
        });
        barraBotones.add(this.btnCerrar);
        lblNo.setFont(new Font("Tahoma", 1, 18));
        lblNo.setForeground(new Color(0, 0, 102));
        lblNo.setHorizontalAlignment(2);
        lblNo.setText("No.");
        lblNo.setMaximumSize(new Dimension(50, 30));
        lblNo.setMinimumSize(new Dimension(50, 30));
        lblNo.setOpaque(true);
        lblNo.setPreferredSize(new Dimension(50, 30));
        barraBotones.add(lblNo);
        txtNo.setFont(new Font("Arial", 1, 24));
        txtNo.setForeground(new Color(0, 0, 102));
        txtNo.setHorizontalAlignment(0);
        txtNo.setBorder(BorderFactory.createBevelBorder(0));
        txtNo.setMaximumSize(new Dimension(100, 30));
        txtNo.setMinimumSize(new Dimension(100, 30));
        txtNo.setOpaque(true);
        txtNo.setPreferredSize(new Dimension(100, 30));
        barraBotones.add(txtNo);
        lblFecha.setFont(new Font("Tahoma", 1, 12));
        lblFecha.setForeground(new Color(0, 0, 102));
        lblFecha.setHorizontalAlignment(4);
        lblFecha.setText("FECHA");
        lblFecha.setMaximumSize(new Dimension(50, 30));
        lblFecha.setMinimumSize(new Dimension(50, 30));
        lblFecha.setOpaque(true);
        lblFecha.setPreferredSize(new Dimension(50, 30));
        barraBotones.add(lblFecha);
        txtFecha.setFont(new Font("Tahoma", 1, 14));
        txtFecha.setForeground(new Color(0, 0, 102));
        txtFecha.setHorizontalAlignment(0);
        txtFecha.setBorder(new SoftBevelBorder(0));
        txtFecha.setMaximumSize(new Dimension(100, 30));
        txtFecha.setMinimumSize(new Dimension(100, 30));
        txtFecha.setOpaque(true);
        txtFecha.setPreferredSize(new Dimension(100, 30));
        barraBotones.add(txtFecha);
        lblEstado.setFont(new Font("Tahoma", 1, 12));
        lblEstado.setForeground(new Color(0, 0, 102));
        lblEstado.setHorizontalAlignment(4);
        lblEstado.setText("ESTADO");
        lblEstado.setMaximumSize(new Dimension(50, 30));
        lblEstado.setMinimumSize(new Dimension(50, 30));
        lblEstado.setOpaque(true);
        lblEstado.setPreferredSize(new Dimension(50, 30));
        barraBotones.add(lblEstado);
        txtEstado.setFont(new Font("Tahoma", 1, 14));
        txtEstado.setForeground(new Color(0, 0, 102));
        txtEstado.setHorizontalAlignment(0);
        txtEstado.setBorder(BorderFactory.createBevelBorder(0));
        txtEstado.setMaximumSize(new Dimension(100, 30));
        txtEstado.setMinimumSize(new Dimension(100, 30));
        txtEstado.setOpaque(true);
        txtEstado.setPreferredSize(new Dimension(100, 30));
        barraBotones.add(txtEstado);
        Contenedor.add(barraBotones, new AbsoluteConstraints(0, 0, 1240, -1));
        this.PanelCont.setMinimumSize(new Dimension(1200, 800));
        this.PanelCont.setPreferredSize(new Dimension(1213, 873));
        this.scroll.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.scroll.setMinimumSize(new Dimension(1200, 800));
        this.scroll.setPreferredSize(new Dimension(1200, 800));
        this.JLBLogo.setForeground(new Color(255, 255, 255));
        this.JLBLogo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logotipo Genoma Plus.png")));
        this.JLBPeridoC.setFont(new Font("Arial", 1, 16));
        this.JLBPeridoC.setForeground(Color.blue);
        this.JLBPeridoC.setHorizontalAlignment(0);
        this.JLBPeridoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo Contable", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLBInformacionU.setFont(new Font("Arial", 1, 13));
        this.JLBInformacionU.setForeground(new Color(0, 102, 0));
        this.JLBInformacionU.setHorizontalAlignment(0);
        this.JLBInformacionU.setBorder(BorderFactory.createEtchedBorder(new Color(0, 102, 0), (Color) null));
        this.JLBUvt.setFont(new Font("Arial", 1, 16));
        this.JLBUvt.setForeground(Color.blue);
        this.JLBUvt.setHorizontalAlignment(0);
        this.JLBUvt.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor UVT", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLBLogo1.setForeground(new Color(255, 255, 255));
        this.JLBLogo1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logotipo Genoma Plus.png")));
        this.JLB_Sede.setFont(new Font("Arial", 1, 13));
        this.JLB_Sede.setForeground(Color.red);
        this.JLB_Sede.setHorizontalAlignment(0);
        this.JLB_Sede.setBorder(BorderFactory.createBevelBorder(0));
        PanelPpal.setLayer(this.JLBLogo, JLayeredPane.DEFAULT_LAYER.intValue());
        PanelPpal.setLayer(this.JLBPeridoC, JLayeredPane.DEFAULT_LAYER.intValue());
        PanelPpal.setLayer(this.JLBInformacionU, JLayeredPane.DEFAULT_LAYER.intValue());
        PanelPpal.setLayer(this.JLBUvt, JLayeredPane.DEFAULT_LAYER.intValue());
        PanelPpal.setLayer(this.JLBLogo1, JLayeredPane.DEFAULT_LAYER.intValue());
        PanelPpal.setLayer(this.JLB_Sede, JLayeredPane.DEFAULT_LAYER.intValue());
        LayoutManager groupLayout = new GroupLayout(PanelPpal);
        PanelPpal.setLayout(groupLayout);
        groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLB_Sede, -2, 313, -2)).addGroup(groupLayout.createSequentialGroup().addComponent(this.JLBUvt, -2, 168, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 180, 32767).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBPeridoC, -2, 380, -2).addComponent(this.JLBInformacionU, -2, 380, -2).addGroup(groupLayout.createSequentialGroup().addGap(67, 67, 67).addComponent(this.JLBLogo))))).addGap(60, 60, 60)).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JLBLogo1).addContainerGap(478, 32767))));
        groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBUvt, -2, 60, -2).addComponent(this.JLBLogo, -2, 270, -2)).addGap(18, 18, 18).addComponent(this.JLB_Sede, -2, 50, -2).addGap(97, 97, 97).addComponent(this.JLBPeridoC, -2, 60, -2).addGap(10, 10, 10).addComponent(this.JLBInformacionU, -2, 100, -2).addGap(40, 40, 40)).addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(387, 32767).addComponent(this.JLBLogo1, -2, 270, -2).addGap(10, 10, 10))));
        this.scroll.setViewportView(PanelPpal);
        GroupLayout PanelContLayout = new GroupLayout(this.PanelCont);
        this.PanelCont.setLayout(PanelContLayout);
        PanelContLayout.setHorizontalGroup(PanelContLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1213, 32767).addGroup(PanelContLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(PanelContLayout.createSequentialGroup().addComponent(this.scroll, -1, -1, -2).addGap(0, 413, 32767))));
        PanelContLayout.setVerticalGroup(PanelContLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 873, 32767).addGroup(PanelContLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(PanelContLayout.createSequentialGroup().addComponent(this.scroll, -1, -1, 32767).addGap(0, 0, 32767))));
        Contenedor.add(this.PanelCont, new AbsoluteConstraints(1, 68, -1, -1));
        setDefaultCloseOperation(0);
        setTitle("G@noma Plus");
        setAutoRequestFocus(false);
        setFont(new Font("Arial", 1, 12));
        setForeground(Color.orange);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png")));
        setMinimumSize(null);
        setName("Principal");
        addWindowListener(new WindowAdapter() { // from class: Acceso.Principal.15
            public void windowClosing(WindowEvent evt) {
                Principal.this.formWindowClosing(evt);
            }
        });
        addKeyListener(new KeyAdapter() { // from class: Acceso.Principal.16
            public void keyPressed(KeyEvent evt) {
                Principal.this.formKeyPressed(evt);
            }
        });
        this.MenuArchivo.setForeground(new Color(0, 0, 153));
        this.MenuArchivo.setMnemonic('A');
        this.MenuArchivo.setText("G@noma Plus - ");
        this.MenuArchivo.setFont(new Font("Tahoma", 1, 14));
        barraMnuPrincipal.add(this.MenuArchivo);
        setJMenuBar(barraMnuPrincipal);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1413, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1328, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCancelarActionPerformed(ActionEvent evt) {
        mCancelar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimirActionPerformed(ActionEvent evt) {
        mImprimir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPrimerActionPerformed(ActionEvent evt) {
        irAlRegistro(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAnteriorActionPerformed(ActionEvent evt) {
        irAlRegistro(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSiguienteActionPerformed(ActionEvent evt) {
        irAlRegistro(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnUltimoActionPerformed(ActionEvent evt) {
        irAlRegistro(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCerrarActionPerformed(ActionEvent evt) {
        mLimpiarPanel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAnularActionPerformed(ActionEvent evt) {
        mAnular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBuscarActionPerformed(ActionEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void mnuListadoProductosActionPerformed(ActionEvent evt) {
        xClaseInventario.cargarPantalla("Informes1.3");
    }

    private void mnuListadogeneralxTipoActionPerformed(ActionEvent evt) {
        xClaseInventario.cargarPantalla("Informes1.6");
    }

    private void mnuMaxyMinActionPerformed(ActionEvent evt) {
        xClaseInventario.cargarPantalla("Informes1.7");
    }

    private void JMICCronicosActionPerformed1(ActionEvent evt) {
    }

    private void JMIAutorizacionesActionPerformed(ActionEvent evt) {
    }

    private void JMIUConsultaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNuevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    private void JIMIGOcupacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAuditoriaFacturasActionPerformed(ActionEvent evt) {
        clasegeneral.cargarPantalla(this.btnAuditoriaFacturas.getText());
    }

    private void JMIIConciliacionInventarioActionPerformed(ActionEvent evt) {
        xclase.cargarPantalla("Conciliacion Inventario");
    }

    private void JMIAsignacionCNP1ActionPerformed(ActionEvent evt) {
        clasescita.cargarPantalla(this, "CitasNP");
    }

    private void JMISalaCirugiaActionPerformed(ActionEvent evt) {
        claseparametrizacionn.cargarPantalla("Sala de Cirugia");
    }

    private void JMIMovimientoxFechaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formWindowClosing(WindowEvent evt) {
        try {
            cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formKeyPressed(KeyEvent evt) {
    }

    private void PanelPpalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ContenedorKeyPressed(KeyEvent evt) {
    }

    private void buscarEncuesta() {
        List<Object[]> listEncuesta = alertaGeneralesDAO.listaEncuestaporUsuario(usuarioSistemaDTO.getIdUsuarioSistema());
        if (!listEncuesta.isEmpty()) {
            if (listEncuesta.size() == 1) {
                informacionGeneralPrincipalDTO.setIdSolicitudEncuesta(Long.valueOf(listEncuesta.get(0)[4].toString()));
                informacionGeneralPrincipalDTO.setIdTipoEncuesta(Long.valueOf(listEncuesta.get(0)[0].toString()));
                clasegeneral.cargarPantalla("Encuesta");
                return;
            } else {
                JDGenericoCb dialog = new JDGenericoCb((Frame) this, true, "xjfprincipal");
                dialog.setLocation((this.metodos.getAnchoPantalla() / 2) / 2, (this.metodos.getAltoPantalla() / 2) / 2);
                dialog.setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "No existe encuesta asignada", "ENCUESTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
