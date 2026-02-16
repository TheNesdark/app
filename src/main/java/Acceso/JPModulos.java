package Acceso;

import ComprasBS.claseComprasBienesServicios;
import Contabilidad.JDSPeriodoContables;
import Contabilidad.claseContabilidad;
import General.AccesoModulos;
import General.CambioClave;
import Historia.TareaSeguimiento;
import ParametrizacionN.claseParametrizacionN;
import Presupuesto.JDPeriodoPpto;
import Presupuesto.clasePresupuesto;
import Sgc.claseSgc;
import Sig.JDMapaProceso;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.enfermeria.JD_AccesoInicial_Efermeria;
import com.genoma.plus.controller.historia.JD_AccesoInicial;
import com.genoma.plus.controller.tesoreria.ClaseTesoreriaController;
import com.l2fprod.common.swing.JCollapsiblePane;
import com.l2fprod.common.swing.JLinkButton;
import com.l2fprod.common.swing.JOutlookBar;
import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.PercentLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.jdesktop.swingx.border.DropShadowBorder;

/* JADX INFO: loaded from: GenomaP.jar:Acceso/JPModulos.class */
public class JPModulos extends JPanel {
    Principal xjp;
    public static JPanel ContModulos;
    public JButton JBCrear;
    public JButton JBCrearCal;
    public JButton JBTGestionC;
    public JButton JBTInformes;
    public JButton JBTMConsultarTerm;
    public JButton JBTMEncuesta;
    public JButton JBTMProceso;
    public JButton JBTMRporteNC;
    public JButton JBTOodontologia;
    private JCollapsiblePane JBTParametrizacion;
    public JCollapsiblePane JBTSgc;
    private JCollapsiblePane JBTSgc1;
    public JButton JBTSo;
    public JCollapsiblePane JBTUtilidades;
    private JScrollPane JSPModulos;
    private JScrollPane JSPSgc;
    public JScrollPane JSTree;
    public JScrollPane JSTreeCal;
    private JTaskPane JTPModulos;
    public JTaskPane JTPSgc;
    public static JOutlookBar barraOutlook;
    public JLinkButton btnAcronimos;
    public JLinkButton btnActivarPersona;
    public JLinkButton btnAdmNovedadesNomina;
    public JButton btnAuditoriaMedica;
    public JButton btnAutorizacion;
    public JLinkButton btnAutorizacionDoc;
    public JButton btnAutorizacionMP;
    public JLinkButton btnBitacoraRegistro;
    public JButton btnCaja;
    public JButton btnCajaM;
    public JLinkButton btnCambiarNHC;
    public JLinkButton btnCanvioClave;
    public JButton btnCirugia;
    public JButton btnCitas;
    public JButton btnCompras;
    public JButton btnContabilidad1;
    public JLinkButton btnControlRemisiones;
    public JLinkButton btnCrearPersona;
    public JButton btnCytologix;
    public JLinkButton btnDesactivarPersona;
    public JButton btnEnfermeria;
    public JButton btnFacturacion;
    public JButton btnGestionActivo;
    public JButton btnGestionDoc;
    public JButton btnHistoriaCE;
    public JButton btnImagenDx;
    public JLinkButton btnImportarInformacionUsuario;
    public JButton btnInformes;
    public JButton btnInventario;
    public JButton btnLab;
    public JLinkButton btnLlamar;
    public JButton btnMantenimiento;
    private JCollapsiblePane btnModulos;
    public JButton btnParametrizacion;
    public JLinkButton btnProgramadorReuniones;
    public JButton btnPyP;
    public JLinkButton btnRadiDocumento;
    public JButton btnReferencia;
    public JLinkButton btnRegistroActas;
    public JLinkButton btnRegistroFactura;
    public JLinkButton btnRegistroResiduos;
    public JLinkButton btnRequisicion;
    public JButton btnRrhh;
    public JLinkButton btnRutaSoportes;
    public JButton btnSgc;
    public JLinkButton btnSolicitud;
    public JLinkButton btnSolicitudPedidoInterno;
    public JButton btnSoportesDigitalizados;
    public JButton btnTesoreria;
    public JButton btnTransicionXenco;
    public JButton btnTriage;
    private JScrollPane jScrollPane1;
    public JTaskPane jTaskPane1;
    private ConsultasMySQL ConsultasMysql = new ConsultasMySQL();
    private Metodos metodos = new Metodos();

    public JPModulos(Principal xjp) {
        initComponents();
        this.xjp = xjp;
    }

    private void initComponents() {
        ContModulos = new JPanel();
        barraOutlook = new JOutlookBar();
        this.btnModulos = new JCollapsiblePane();
        this.JSPModulos = new JScrollPane();
        this.JTPModulos = new JTaskPane();
        this.btnAuditoriaMedica = new JButton();
        this.btnAutorizacionMP = new JButton();
        this.btnAutorizacion = new JButton();
        this.btnCaja = new JButton();
        this.btnCajaM = new JButton();
        this.btnCompras = new JButton();
        this.btnContabilidad1 = new JButton();
        this.btnCirugia = new JButton();
        this.btnCitas = new JButton();
        this.btnEnfermeria = new JButton();
        this.btnFacturacion = new JButton();
        this.JBTGestionC = new JButton();
        this.btnGestionDoc = new JButton();
        this.btnGestionActivo = new JButton();
        this.btnInventario = new JButton();
        this.btnHistoriaCE = new JButton();
        this.btnImagenDx = new JButton();
        this.JBTInformes = new JButton();
        this.btnInformes = new JButton();
        this.btnMantenimiento = new JButton();
        this.btnLab = new JButton();
        this.JBTOodontologia = new JButton();
        this.btnParametrizacion = new JButton();
        this.btnPyP = new JButton();
        this.btnRrhh = new JButton();
        this.JBTSo = new JButton();
        this.btnSgc = new JButton();
        this.btnTriage = new JButton();
        this.btnTransicionXenco = new JButton();
        this.btnReferencia = new JButton();
        this.btnTesoreria = new JButton();
        this.btnSoportesDigitalizados = new JButton();
        this.btnCytologix = new JButton();
        this.JBTUtilidades = new JCollapsiblePane();
        this.jScrollPane1 = new JScrollPane();
        this.jTaskPane1 = new JTaskPane();
        this.btnActivarPersona = new JLinkButton();
        this.btnAcronimos = new JLinkButton();
        this.btnAutorizacionDoc = new JLinkButton();
        this.btnBitacoraRegistro = new JLinkButton();
        this.btnCanvioClave = new JLinkButton();
        this.btnCambiarNHC = new JLinkButton();
        this.btnCrearPersona = new JLinkButton();
        this.btnDesactivarPersona = new JLinkButton();
        this.btnAdmNovedadesNomina = new JLinkButton();
        this.btnProgramadorReuniones = new JLinkButton();
        this.btnRadiDocumento = new JLinkButton();
        this.btnLlamar = new JLinkButton();
        this.btnRegistroActas = new JLinkButton();
        this.btnRegistroResiduos = new JLinkButton();
        this.btnRequisicion = new JLinkButton();
        this.btnRutaSoportes = new JLinkButton();
        this.btnSolicitud = new JLinkButton();
        this.btnSolicitudPedidoInterno = new JLinkButton();
        this.btnImportarInformacionUsuario = new JLinkButton();
        this.btnRegistroFactura = new JLinkButton();
        this.btnControlRemisiones = new JLinkButton();
        this.JBTSgc = new JCollapsiblePane();
        this.JSPSgc = new JScrollPane();
        this.JTPSgc = new JTaskPane();
        this.JBTMProceso = new JButton();
        this.JBTMEncuesta = new JButton();
        this.JBTMRporteNC = new JButton();
        this.JBTMConsultarTerm = new JButton();
        this.JBTParametrizacion = new JCollapsiblePane();
        this.JBCrear = new JButton();
        this.JSTree = new JScrollPane();
        this.JBTSgc1 = new JCollapsiblePane();
        this.JBCrearCal = new JButton();
        this.JSTreeCal = new JScrollPane();
        ContModulos.setPreferredSize(new Dimension(300, 990));
        barraOutlook.setTabLayoutPolicy(1);
        barraOutlook.setAutoscrolls(true);
        barraOutlook.setFont(new Font("Arial", 1, 12));
        barraOutlook.setMaximumSize((Dimension) null);
        this.btnModulos.setBorder(new DropShadowBorder());
        this.JSPModulos.setHorizontalScrollBarPolicy(31);
        PercentLayout percentLayout1 = new PercentLayout();
        percentLayout1.setGap(20);
        percentLayout1.setOrientation(1);
        this.JTPModulos.setLayout(percentLayout1);
        this.btnAuditoriaMedica.setFont(new Font("Arial", 1, 12));
        this.btnAuditoriaMedica.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes29x27.png")));
        this.btnAuditoriaMedica.setMnemonic('T');
        this.btnAuditoriaMedica.setText("<html><P ALIGN=center>Auditoría Médica");
        this.btnAuditoriaMedica.setToolTipText("");
        this.btnAuditoriaMedica.setEnabled(false);
        this.btnAuditoriaMedica.setHorizontalTextPosition(10);
        this.btnAuditoriaMedica.setIconTextGap(0);
        this.btnAuditoriaMedica.setMaximumSize(new Dimension(190, 40));
        this.btnAuditoriaMedica.setMinimumSize(new Dimension(190, 40));
        this.btnAuditoriaMedica.setPreferredSize(new Dimension(190, 40));
        this.btnAuditoriaMedica.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.1
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnAuditoriaMedicaActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnAuditoriaMedica);
        this.btnAutorizacionMP.setFont(new Font("Arial", 1, 12));
        this.btnAutorizacionMP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Autorizacion.png")));
        this.btnAutorizacionMP.setMnemonic('T');
        this.btnAutorizacionMP.setText("<html><P ALIGN=center>Autorización Medicamentos MP");
        this.btnAutorizacionMP.setEnabled(false);
        this.btnAutorizacionMP.setHorizontalTextPosition(10);
        this.btnAutorizacionMP.setIconTextGap(0);
        this.btnAutorizacionMP.setMaximumSize(new Dimension(190, 40));
        this.btnAutorizacionMP.setMinimumSize(new Dimension(190, 40));
        this.btnAutorizacionMP.setPreferredSize(new Dimension(190, 40));
        this.btnAutorizacionMP.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.2
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnAutorizacionMPActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnAutorizacionMP);
        this.btnAutorizacion.setBackground(new Color(204, 204, 204));
        this.btnAutorizacion.setFont(new Font("Arial", 1, 12));
        this.btnAutorizacion.setForeground(new Color(0, 51, 153));
        this.btnAutorizacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.btnAutorizacion.setMnemonic('A');
        this.btnAutorizacion.setText("Autorizaciones");
        this.btnAutorizacion.setToolTipText("Módulo de Autorizaciones");
        this.btnAutorizacion.setAutoscrolls(true);
        this.btnAutorizacion.setEnabled(false);
        this.btnAutorizacion.setHideActionText(true);
        this.btnAutorizacion.setHorizontalTextPosition(10);
        this.btnAutorizacion.setIconTextGap(0);
        this.btnAutorizacion.setInheritsPopupMenu(true);
        this.btnAutorizacion.setMargin(new Insets(5, 20, 5, 20));
        this.btnAutorizacion.setMaximumSize(new Dimension(190, 40));
        this.btnAutorizacion.setMinimumSize(new Dimension(190, 40));
        this.btnAutorizacion.setPreferredSize(new Dimension(190, 40));
        this.btnAutorizacion.setVerifyInputWhenFocusTarget(false);
        this.btnAutorizacion.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.3
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnAutorizacionActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnAutorizacion);
        this.btnCaja.setFont(new Font("Arial", 1, 12));
        this.btnCaja.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.btnCaja.setMnemonic('J');
        this.btnCaja.setText("Caja de Ingreso");
        this.btnCaja.setToolTipText("Módulo de Caja de Ingreso");
        this.btnCaja.setEnabled(false);
        this.btnCaja.setHorizontalTextPosition(10);
        this.btnCaja.setInheritsPopupMenu(true);
        this.btnCaja.setMaximumSize(new Dimension(190, 40));
        this.btnCaja.setMinimumSize(new Dimension(190, 40));
        this.btnCaja.setPreferredSize(new Dimension(190, 40));
        this.btnCaja.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.4
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnCajaActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnCaja);
        this.btnCajaM.setFont(new Font("Arial", 1, 12));
        this.btnCajaM.setIcon(new ImageIcon(getClass().getResource("/Imagenes/caja.png")));
        this.btnCajaM.setMnemonic('J');
        this.btnCajaM.setText("Caja Menor");
        this.btnCajaM.setToolTipText("Módulo de Caja Menor");
        this.btnCajaM.setHorizontalTextPosition(10);
        this.btnCajaM.setInheritsPopupMenu(true);
        this.btnCajaM.setMaximumSize(new Dimension(190, 40));
        this.btnCajaM.setMinimumSize(new Dimension(190, 40));
        this.btnCajaM.setPreferredSize(new Dimension(190, 40));
        this.btnCajaM.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.5
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnCajaMActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnCajaM);
        this.btnCompras.setFont(new Font("Arial", 1, 12));
        this.btnCompras.setIcon(new ImageIcon(getClass().getResource("/Imagenes/compras.png")));
        this.btnCompras.setMnemonic('C');
        this.btnCompras.setText("<html><P ALIGN=center>Gestión de Compras (Bien, servicios y contratos)");
        this.btnCompras.setToolTipText("Módulo de Compras de Bienes y Servicios");
        this.btnCompras.setHorizontalTextPosition(10);
        this.btnCompras.setInheritsPopupMenu(true);
        this.btnCompras.setMaximumSize(new Dimension(190, 40));
        this.btnCompras.setMinimumSize(new Dimension(190, 40));
        this.btnCompras.setPreferredSize(new Dimension(190, 40));
        this.btnCompras.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.6
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnComprasActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnCompras);
        this.btnContabilidad1.setFont(new Font("Arial", 1, 12));
        this.btnContabilidad1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/contabilidad.png")));
        this.btnContabilidad1.setText("Contabilidad");
        this.btnContabilidad1.setEnabled(false);
        this.btnContabilidad1.setHideActionText(true);
        this.btnContabilidad1.setHorizontalTextPosition(10);
        this.btnContabilidad1.setIconTextGap(0);
        this.btnContabilidad1.setMaximumSize(new Dimension(190, 40));
        this.btnContabilidad1.setMinimumSize(new Dimension(190, 40));
        this.btnContabilidad1.setPreferredSize(new Dimension(190, 40));
        this.btnContabilidad1.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.7
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnContabilidad1ActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnContabilidad1);
        this.btnCirugia.setFont(new Font("Arial", 1, 12));
        this.btnCirugia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cirugia.png")));
        this.btnCirugia.setMnemonic('C');
        this.btnCirugia.setText("Cirugía");
        this.btnCirugia.setToolTipText("Módulo de Cirugía");
        this.btnCirugia.setHorizontalTextPosition(10);
        this.btnCirugia.setInheritsPopupMenu(true);
        this.btnCirugia.setMaximumSize(new Dimension(190, 40));
        this.btnCirugia.setMinimumSize(new Dimension(190, 40));
        this.btnCirugia.setPreferredSize(new Dimension(190, 40));
        this.btnCirugia.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.8
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnCirugiaActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnCirugia);
        this.btnCitas.setFont(new Font("Arial", 1, 12));
        this.btnCitas.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaNP.png")));
        this.btnCitas.setMnemonic('C');
        this.btnCitas.setText("Citas");
        this.btnCitas.setEnabled(false);
        this.btnCitas.setHorizontalTextPosition(10);
        this.btnCitas.setMaximumSize(new Dimension(190, 40));
        this.btnCitas.setMinimumSize(new Dimension(190, 40));
        this.btnCitas.setName("btnCitas");
        this.btnCitas.setPreferredSize(new Dimension(190, 40));
        this.btnCitas.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.9
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnCitasActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnCitas);
        this.btnEnfermeria.setFont(new Font("Arial", 1, 12));
        this.btnEnfermeria.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Enfermera23x24.png")));
        this.btnEnfermeria.setMnemonic('E');
        this.btnEnfermeria.setText("Enfermería");
        this.btnEnfermeria.setToolTipText("Atención de Enfermería");
        this.btnEnfermeria.setEnabled(false);
        this.btnEnfermeria.setHorizontalTextPosition(10);
        this.btnEnfermeria.setMaximumSize(new Dimension(190, 40));
        this.btnEnfermeria.setMinimumSize(new Dimension(190, 40));
        this.btnEnfermeria.setPreferredSize(new Dimension(190, 40));
        this.btnEnfermeria.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.10
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnEnfermeriaActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnEnfermeria);
        this.btnFacturacion.setFont(new Font("Arial", 1, 12));
        this.btnFacturacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        this.btnFacturacion.setMnemonic('F');
        this.btnFacturacion.setText("Facturación");
        this.btnFacturacion.setToolTipText("Módulo de Facturación");
        this.btnFacturacion.setEnabled(false);
        this.btnFacturacion.setHorizontalTextPosition(10);
        this.btnFacturacion.setMaximumSize(new Dimension(190, 40));
        this.btnFacturacion.setMinimumSize(new Dimension(190, 40));
        this.btnFacturacion.setPreferredSize(new Dimension(190, 40));
        this.btnFacturacion.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.11
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnFacturacionActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnFacturacion);
        this.JBTGestionC.setFont(new Font("Arial", 1, 12));
        this.JBTGestionC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/caja.png")));
        this.JBTGestionC.setMnemonic('G');
        this.JBTGestionC.setText("<html><P ALIGN=center>Gestión Cuentas Médicas");
        this.JBTGestionC.setToolTipText("Gestión de Cuentas Medicas");
        this.JBTGestionC.setHorizontalTextPosition(10);
        this.JBTGestionC.setIconTextGap(0);
        this.JBTGestionC.setInheritsPopupMenu(true);
        this.JBTGestionC.setMaximumSize(new Dimension(190, 40));
        this.JBTGestionC.setMinimumSize(new Dimension(190, 40));
        this.JBTGestionC.setPreferredSize(new Dimension(190, 40));
        this.JBTGestionC.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.12
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBTGestionCActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.JBTGestionC);
        this.btnGestionDoc.setFont(new Font("Arial", 1, 12));
        this.btnGestionDoc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gestion documental.png")));
        this.btnGestionDoc.setMnemonic('T');
        this.btnGestionDoc.setText("<html><P ALIGN=center>Gestion Documental");
        this.btnGestionDoc.setEnabled(false);
        this.btnGestionDoc.setHorizontalTextPosition(10);
        this.btnGestionDoc.setIconTextGap(0);
        this.btnGestionDoc.setMaximumSize(new Dimension(190, 40));
        this.btnGestionDoc.setMinimumSize(new Dimension(190, 40));
        this.btnGestionDoc.setPreferredSize(new Dimension(190, 40));
        this.btnGestionDoc.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.13
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnGestionDocActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnGestionDoc);
        this.btnGestionActivo.setFont(new Font("Arial", 1, 12));
        this.btnGestionActivo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/activosfijos.png")));
        this.btnGestionActivo.setMnemonic('T');
        this.btnGestionActivo.setText("<html><P ALIGN=center>Gestión de Activos");
        this.btnGestionActivo.setEnabled(false);
        this.btnGestionActivo.setHorizontalTextPosition(10);
        this.btnGestionActivo.setIconTextGap(0);
        this.btnGestionActivo.setMaximumSize(new Dimension(190, 40));
        this.btnGestionActivo.setMinimumSize(new Dimension(190, 40));
        this.btnGestionActivo.setPreferredSize(new Dimension(190, 40));
        this.btnGestionActivo.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.14
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnGestionActivoActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnGestionActivo);
        this.btnInventario.setFont(new Font("Arial", 1, 12));
        this.btnInventario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.btnInventario.setMnemonic('I');
        this.btnInventario.setText("<html><P ALIGN=center>Gestión Inventario");
        this.btnInventario.setEnabled(false);
        this.btnInventario.setHorizontalTextPosition(10);
        this.btnInventario.setIconTextGap(0);
        this.btnInventario.setMaximumSize(new Dimension(190, 40));
        this.btnInventario.setMinimumSize(new Dimension(190, 40));
        this.btnInventario.setPreferredSize(new Dimension(190, 40));
        this.btnInventario.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.15
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnInventarioActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnInventario);
        this.btnHistoriaCE.setFont(new Font("Arial", 1, 12));
        this.btnHistoriaCE.setIcon(new ImageIcon(getClass().getResource("/Imagenes/historia clinica.png")));
        this.btnHistoriaCE.setMnemonic('T');
        this.btnHistoriaCE.setText("<html><P ALIGN=center>Historia Clínica");
        this.btnHistoriaCE.setEnabled(false);
        this.btnHistoriaCE.setHorizontalTextPosition(10);
        this.btnHistoriaCE.setIconTextGap(0);
        this.btnHistoriaCE.setMaximumSize(new Dimension(190, 40));
        this.btnHistoriaCE.setMinimumSize(new Dimension(190, 40));
        this.btnHistoriaCE.setPreferredSize(new Dimension(190, 40));
        this.btnHistoriaCE.addItemListener(new ItemListener() { // from class: Acceso.JPModulos.16
            public void itemStateChanged(ItemEvent evt) {
                JPModulos.this.btnHistoriaCEItemStateChanged(evt);
            }
        });
        this.btnHistoriaCE.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.17
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnHistoriaCEActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnHistoriaCE);
        this.btnImagenDx.setFont(new Font("Arial", 1, 12));
        this.btnImagenDx.setIcon(new ImageIcon(getClass().getResource("/Imagenes/rx.png")));
        this.btnImagenDx.setMnemonic('J');
        this.btnImagenDx.setText("Imagen Dx");
        this.btnImagenDx.setToolTipText("Módulo de Imagen Dx");
        this.btnImagenDx.setHorizontalTextPosition(10);
        this.btnImagenDx.setInheritsPopupMenu(true);
        this.btnImagenDx.setMaximumSize(new Dimension(190, 40));
        this.btnImagenDx.setMinimumSize(new Dimension(190, 40));
        this.btnImagenDx.setPreferredSize(new Dimension(190, 40));
        this.btnImagenDx.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.18
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnImagenDxActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnImagenDx);
        this.JBTInformes.setFont(new Font("Arial", 1, 12));
        this.JBTInformes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTInformes.setMnemonic('T');
        this.JBTInformes.setText("<html><P ALIGN=center>Informes e Indicadores");
        this.JBTInformes.setEnabled(false);
        this.JBTInformes.setHorizontalTextPosition(10);
        this.JBTInformes.setMaximumSize(new Dimension(190, 40));
        this.JBTInformes.setMinimumSize(new Dimension(190, 40));
        this.JBTInformes.setPreferredSize(new Dimension(190, 40));
        this.JBTInformes.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.19
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBTInformesActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.JBTInformes);
        this.btnInformes.setFont(new Font("Arial", 1, 12));
        this.btnInformes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.btnInformes.setText("<html><P ALIGN=center>Consultar Concepto Salud Ocupacional");
        this.btnInformes.setEnabled(false);
        this.btnInformes.setHorizontalTextPosition(10);
        this.btnInformes.setIconTextGap(0);
        this.btnInformes.setMaximumSize(new Dimension(190, 40));
        this.btnInformes.setMinimumSize(new Dimension(190, 40));
        this.btnInformes.setPreferredSize(new Dimension(190, 40));
        this.btnInformes.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.20
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnInformesActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnInformes);
        this.btnMantenimiento.setFont(new Font("Arial", 1, 12));
        this.btnMantenimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Mantenimiento.jpg")));
        this.btnMantenimiento.setText("<html><P ALIGN=center>Inventario y Mantenimiento");
        this.btnMantenimiento.setToolTipText("Mantenimiento");
        this.btnMantenimiento.setHorizontalTextPosition(10);
        this.btnMantenimiento.setIconTextGap(0);
        this.btnMantenimiento.setMaximumSize(new Dimension(190, 40));
        this.btnMantenimiento.setMinimumSize(new Dimension(190, 40));
        this.btnMantenimiento.setPreferredSize(new Dimension(190, 40));
        this.btnMantenimiento.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.21
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnMantenimientoActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnMantenimiento);
        this.btnLab.setFont(new Font("Arial", 1, 12));
        this.btnLab.setIcon(new ImageIcon(getClass().getResource("/Imagenes/micro.png")));
        this.btnLab.setText("Laboratorio Clínico");
        this.btnLab.setToolTipText("Laboratorio");
        this.btnLab.setHorizontalTextPosition(10);
        this.btnLab.setMaximumSize(new Dimension(190, 40));
        this.btnLab.setMinimumSize(new Dimension(190, 40));
        this.btnLab.setPreferredSize(new Dimension(190, 40));
        this.btnLab.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.22
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnLabActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnLab);
        this.JBTOodontologia.setFont(new Font("Arial", 1, 12));
        this.JBTOodontologia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/diente.png")));
        this.JBTOodontologia.setMnemonic('G');
        this.JBTOodontologia.setText("Odontología");
        this.JBTOodontologia.setToolTipText("Odontología");
        this.JBTOodontologia.setHorizontalTextPosition(10);
        this.JBTOodontologia.setIconTextGap(0);
        this.JBTOodontologia.setInheritsPopupMenu(true);
        this.JBTOodontologia.setMaximumSize(new Dimension(190, 40));
        this.JBTOodontologia.setMinimumSize(new Dimension(190, 40));
        this.JBTOodontologia.setPreferredSize(new Dimension(190, 40));
        this.JBTOodontologia.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.23
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBTOodontologiaActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.JBTOodontologia);
        this.btnParametrizacion.setFont(new Font("Arial", 1, 12));
        this.btnParametrizacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Presupuesto2.png")));
        this.btnParametrizacion.setText("Presupuesto");
        this.btnParametrizacion.setToolTipText("Presupuesto");
        this.btnParametrizacion.setHorizontalTextPosition(10);
        this.btnParametrizacion.setIconTextGap(0);
        this.btnParametrizacion.setMaximumSize(new Dimension(190, 40));
        this.btnParametrizacion.setMinimumSize(new Dimension(190, 40));
        this.btnParametrizacion.setPreferredSize(new Dimension(190, 40));
        this.btnParametrizacion.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.24
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnParametrizacionActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnParametrizacion);
        this.btnPyP.setFont(new Font("Arial", 1, 12));
        this.btnPyP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CHistoria.png")));
        this.btnPyP.setMnemonic('P');
        this.btnPyP.setText("P y P");
        this.btnPyP.setToolTipText("Módulo de Promoción y Prevención");
        this.btnPyP.setEnabled(false);
        this.btnPyP.setHorizontalTextPosition(10);
        this.btnPyP.setMaximumSize(new Dimension(190, 40));
        this.btnPyP.setMinimumSize(new Dimension(190, 40));
        this.btnPyP.setPreferredSize(new Dimension(190, 40));
        this.btnPyP.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.25
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnPyPActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnPyP);
        this.btnRrhh.setFont(new Font("Arial", 1, 12));
        this.btnRrhh.setIcon(new ImageIcon(getClass().getResource("/Imagenes/recursos humanos.png")));
        this.btnRrhh.setText("<html><P ALIGN=center>Gestión del Talento Humano");
        this.btnRrhh.setToolTipText("Gestíon del Talento Humano");
        this.btnRrhh.setHorizontalTextPosition(10);
        this.btnRrhh.setIconTextGap(0);
        this.btnRrhh.setMaximumSize(new Dimension(190, 40));
        this.btnRrhh.setMinimumSize(new Dimension(190, 40));
        this.btnRrhh.setPreferredSize(new Dimension(190, 40));
        this.btnRrhh.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.26
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnRrhhActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnRrhh);
        this.JBTSo.setFont(new Font("Arial", 1, 12));
        this.JBTSo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Icono_So2.png")));
        this.JBTSo.setMnemonic('T');
        this.JBTSo.setText("<html><P ALIGN=center>Seguridad y Salud en el Trabajo(SST)");
        this.JBTSo.setToolTipText("");
        this.JBTSo.setEnabled(false);
        this.JBTSo.setHorizontalTextPosition(10);
        this.JBTSo.setIconTextGap(0);
        this.JBTSo.setMaximumSize(new Dimension(190, 40));
        this.JBTSo.setMinimumSize(new Dimension(190, 40));
        this.JBTSo.setPreferredSize(new Dimension(190, 40));
        this.JBTSo.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.27
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBTSoActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.JBTSo);
        this.btnSgc.setFont(new Font("Arial", 1, 12));
        this.btnSgc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Atomic29x25.png")));
        this.btnSgc.setMnemonic('T');
        this.btnSgc.setText("Sgc");
        this.btnSgc.setToolTipText("Sistema Gestión de Calidad");
        this.btnSgc.setEnabled(false);
        this.btnSgc.setHorizontalTextPosition(10);
        this.btnSgc.setIconTextGap(0);
        this.btnSgc.setMaximumSize(new Dimension(190, 40));
        this.btnSgc.setMinimumSize(new Dimension(190, 40));
        this.btnSgc.setPreferredSize(new Dimension(190, 40));
        this.btnSgc.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.28
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnSgcActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnSgc);
        this.btnTriage.setFont(new Font("Arial", 1, 12));
        this.btnTriage.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Hc29x27.png")));
        this.btnTriage.setMnemonic('T');
        this.btnTriage.setText("<html><P ALIGN=center>Triage Urgencias");
        this.btnTriage.setEnabled(false);
        this.btnTriage.setHorizontalTextPosition(10);
        this.btnTriage.setIconTextGap(0);
        this.btnTriage.setMaximumSize(new Dimension(190, 40));
        this.btnTriage.setMinimumSize(new Dimension(190, 40));
        this.btnTriage.setPreferredSize(new Dimension(190, 40));
        this.btnTriage.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.29
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnTriageActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnTriage);
        this.btnTransicionXenco.setFont(new Font("Arial", 1, 12));
        this.btnTransicionXenco.setMnemonic('T');
        this.btnTransicionXenco.setText("<html><P ALIGN=center>Transición Xenco");
        this.btnTransicionXenco.setEnabled(false);
        this.btnTransicionXenco.setHorizontalTextPosition(10);
        this.btnTransicionXenco.setIconTextGap(0);
        this.btnTransicionXenco.setMaximumSize(new Dimension(190, 40));
        this.btnTransicionXenco.setMinimumSize(new Dimension(190, 40));
        this.btnTransicionXenco.setPreferredSize(new Dimension(190, 40));
        this.btnTransicionXenco.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.30
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnTransicionXencoActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnTransicionXenco);
        this.btnReferencia.setFont(new Font("Arial", 1, 12));
        this.btnReferencia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/historia clinica.png")));
        this.btnReferencia.setText("<html><P ALIGN=center>Referencia y ContraReferencia");
        this.btnReferencia.setToolTipText("Gestíon del Talento Humano");
        this.btnReferencia.setHorizontalTextPosition(10);
        this.btnReferencia.setIconTextGap(0);
        this.btnReferencia.setMaximumSize(new Dimension(190, 40));
        this.btnReferencia.setMinimumSize(new Dimension(190, 40));
        this.btnReferencia.setPreferredSize(new Dimension(190, 40));
        this.btnReferencia.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.31
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnReferenciaActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnReferencia);
        this.btnTesoreria.setFont(new Font("Arial", 1, 12));
        this.btnTesoreria.setIcon(new ImageIcon(getClass().getResource("/Imagenes/outline_account_balance_black_24dp.png")));
        this.btnTesoreria.setText("<html><P ALIGN=center>Tesorería");
        this.btnTesoreria.setToolTipText("Modulo de Tesorería");
        this.btnTesoreria.setHorizontalTextPosition(10);
        this.btnTesoreria.setIconTextGap(0);
        this.btnTesoreria.setMaximumSize(new Dimension(190, 40));
        this.btnTesoreria.setMinimumSize(new Dimension(190, 40));
        this.btnTesoreria.setName("38");
        this.btnTesoreria.setPreferredSize(new Dimension(190, 40));
        this.btnTesoreria.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.32
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnTesoreriaActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnTesoreria);
        this.btnSoportesDigitalizados.setFont(new Font("Arial", 1, 12));
        this.btnSoportesDigitalizados.setIcon(new ImageIcon(getClass().getResource("/Imagenes/TXT_24px.png")));
        this.btnSoportesDigitalizados.setText("<html><P ALIGN=center>Soportes Digitalizados");
        this.btnSoportesDigitalizados.setToolTipText("Gestíon del Talento Humano");
        this.btnSoportesDigitalizados.setHorizontalTextPosition(10);
        this.btnSoportesDigitalizados.setIconTextGap(0);
        this.btnSoportesDigitalizados.setMaximumSize(new Dimension(190, 40));
        this.btnSoportesDigitalizados.setMinimumSize(new Dimension(190, 40));
        this.btnSoportesDigitalizados.setPreferredSize(new Dimension(190, 40));
        this.btnSoportesDigitalizados.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.33
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnSoportesDigitalizadosActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnSoportesDigitalizados);
        this.btnCytologix.setFont(new Font("Arial", 1, 12));
        this.btnCytologix.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cytologix.png")));
        this.btnCytologix.setText("<html><P ALIGN=center>Gestión de Citologias");
        this.btnCytologix.setToolTipText("Módulo de Citología");
        this.btnCytologix.setHorizontalTextPosition(10);
        this.btnCytologix.setIconTextGap(0);
        this.btnCytologix.setMaximumSize(new Dimension(190, 40));
        this.btnCytologix.setMinimumSize(new Dimension(190, 40));
        this.btnCytologix.setPreferredSize(new Dimension(190, 40));
        this.btnCytologix.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.34
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnCytologixActionPerformed(evt);
            }
        });
        this.JTPModulos.add(this.btnCytologix);
        this.JSPModulos.setViewportView(this.JTPModulos);
        GroupLayout btnModulosLayout = new GroupLayout(this.btnModulos.getContentPane());
        this.btnModulos.getContentPane().setLayout(btnModulosLayout);
        btnModulosLayout.setHorizontalGroup(btnModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(btnModulosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPModulos, -1, 346, 32767).addContainerGap()));
        btnModulosLayout.setVerticalGroup(btnModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(btnModulosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPModulos, -1, 396, 32767).addContainerGap()));
        barraOutlook.addTab("Módulos", new ImageIcon(getClass().getResource("/Imagenes/genomap.png")), this.btnModulos);
        this.jScrollPane1.setMaximumSize(new Dimension(366, 438));
        this.jScrollPane1.setMinimumSize(new Dimension(366, 438));
        this.jScrollPane1.setPreferredSize(new Dimension(366, 438));
        this.btnActivarPersona.setMnemonic('A');
        this.btnActivarPersona.setText("Activar Usuario");
        this.btnActivarPersona.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.35
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnActivarPersonaActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnActivarPersona);
        this.btnAcronimos.setText("Acrónimos");
        this.btnAcronimos.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.36
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnAcronimosActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnAcronimos);
        this.btnAutorizacionDoc.setText("Autorización Documentos");
        this.btnAutorizacionDoc.setMaximumSize(new Dimension(85, 22));
        this.btnAutorizacionDoc.setMinimumSize(new Dimension(85, 22));
        this.btnAutorizacionDoc.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.37
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnAutorizacionDocActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnAutorizacionDoc);
        this.btnBitacoraRegistro.setMnemonic('A');
        this.btnBitacoraRegistro.setText("Bitacora");
        this.btnBitacoraRegistro.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.38
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnBitacoraRegistroActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnBitacoraRegistro);
        this.btnCanvioClave.setMnemonic('C');
        this.btnCanvioClave.setText("Cambio de Clave");
        this.btnCanvioClave.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.39
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnCanvioClaveActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnCanvioClave);
        this.btnCambiarNHC.setMnemonic('D');
        this.btnCambiarNHC.setText("Cambiar N° HC");
        this.btnCambiarNHC.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.40
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnCambiarNHCActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnCambiarNHC);
        this.btnCrearPersona.setMnemonic('U');
        this.btnCrearPersona.setText("Crear Usuario");
        this.btnCrearPersona.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.41
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnCrearPersonaActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnCrearPersona);
        this.btnDesactivarPersona.setMnemonic('D');
        this.btnDesactivarPersona.setText("Desactivar Usuario");
        this.btnDesactivarPersona.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.42
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnDesactivarPersonaActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnDesactivarPersona);
        this.btnAdmNovedadesNomina.setText("<html><P ALIGN=center>Novedades de Nomina");
        this.btnAdmNovedadesNomina.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.43
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnAdmNovedadesNominaActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnAdmNovedadesNomina);
        this.btnProgramadorReuniones.setText("Programador de Reuniones");
        this.btnProgramadorReuniones.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.44
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnProgramadorReunionesActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnProgramadorReuniones);
        this.btnRadiDocumento.setMnemonic('L');
        this.btnRadiDocumento.setText("<html><P ALIGN=center>Radicación documentos </p>Clínicos");
        this.btnRadiDocumento.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.45
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnRadiDocumentoActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnRadiDocumento);
        this.btnLlamar.setMnemonic('L');
        this.btnLlamar.setText("<html><P ALIGN=center>Registro de Llamadas y Novedades a Usuarios");
        this.btnLlamar.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.46
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnLlamarActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnLlamar);
        this.btnRegistroActas.setText("Registro de Actas");
        this.btnRegistroActas.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.47
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnRegistroActasActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnRegistroActas);
        this.btnRegistroResiduos.setText("Registro de Disposicion de Residuos");
        this.btnRegistroResiduos.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.48
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnRegistroResiduosActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnRegistroResiduos);
        this.btnRequisicion.setText("Requisición");
        this.btnRequisicion.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.49
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnRequisicionActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnRequisicion);
        this.btnRutaSoportes.setText("Rutas de Soportes");
        this.btnRutaSoportes.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.50
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnRutaSoportesActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnRutaSoportes);
        this.btnSolicitud.setText("Solicitud");
        this.btnSolicitud.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.51
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnSolicitudActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnSolicitud);
        this.btnSolicitudPedidoInterno.setText("Solicitud Pedido Interno");
        this.btnSolicitudPedidoInterno.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.52
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnSolicitudPedidoInternoActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnSolicitudPedidoInterno);
        this.btnImportarInformacionUsuario.setText("Importar Información de Usuario");
        this.btnImportarInformacionUsuario.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.53
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnImportarInformacionUsuarioActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnImportarInformacionUsuario);
        this.btnRegistroFactura.setText("Registro Factura");
        this.btnRegistroFactura.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.54
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnRegistroFacturaActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnRegistroFactura);
        this.btnControlRemisiones.setText("Control de remisiones");
        this.btnControlRemisiones.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.55
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.btnControlRemisionesActionPerformed(evt);
            }
        });
        this.jTaskPane1.add(this.btnControlRemisiones);
        this.jScrollPane1.setViewportView(this.jTaskPane1);
        this.JBTUtilidades.getContentPane().add(this.jScrollPane1);
        barraOutlook.addTab("Utilidades", new ImageIcon(getClass().getResource("/Imagenes/Configurar29x27.png")), this.JBTUtilidades);
        this.JBTSgc.setBorder(new DropShadowBorder());
        this.JBTSgc.setMaximumSize(new Dimension(280, 480));
        this.JSPSgc.setMaximumSize(new Dimension(366, 438));
        this.JSPSgc.setMinimumSize(new Dimension(366, 438));
        this.JSPSgc.setPreferredSize(new Dimension(366, 438));
        this.JTPSgc.setMaximumSize((Dimension) null);
        this.JBTMProceso.setFont(new Font("Tahoma", 1, 12));
        this.JBTMProceso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/sgc.png")));
        this.JBTMProceso.setMnemonic('T');
        this.JBTMProceso.setText("Mapa de Procesos");
        this.JBTMProceso.setHorizontalTextPosition(10);
        this.JBTMProceso.setMaximumSize(new Dimension(190, 40));
        this.JBTMProceso.setMinimumSize(new Dimension(190, 40));
        this.JBTMProceso.setPreferredSize(new Dimension(190, 40));
        this.JBTMProceso.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.56
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBTMProcesoActionPerformed(evt);
            }
        });
        this.JTPSgc.add(this.JBTMProceso);
        this.JBTMEncuesta.setFont(new Font("Tahoma", 1, 12));
        this.JBTMEncuesta.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Encuesta.png")));
        this.JBTMEncuesta.setMnemonic('T');
        this.JBTMEncuesta.setText("Encuesta");
        this.JBTMEncuesta.setHorizontalTextPosition(10);
        this.JBTMEncuesta.setMaximumSize(new Dimension(190, 40));
        this.JBTMEncuesta.setMinimumSize(new Dimension(190, 40));
        this.JBTMEncuesta.setPreferredSize(new Dimension(190, 40));
        this.JBTMEncuesta.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.57
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBTMEncuestaActionPerformed(evt);
            }
        });
        this.JTPSgc.add(this.JBTMEncuesta);
        this.JBTMRporteNC.setFont(new Font("Tahoma", 1, 12));
        this.JBTMRporteNC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/SGC NC1.png")));
        this.JBTMRporteNC.setMnemonic('T');
        this.JBTMRporteNC.setText("Reporte NC");
        this.JBTMRporteNC.setHorizontalTextPosition(10);
        this.JBTMRporteNC.setMaximumSize(new Dimension(190, 40));
        this.JBTMRporteNC.setMinimumSize(new Dimension(190, 40));
        this.JBTMRporteNC.setPreferredSize(new Dimension(190, 40));
        this.JBTMRporteNC.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.58
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBTMRporteNCActionPerformed(evt);
            }
        });
        this.JTPSgc.add(this.JBTMRporteNC);
        this.JBTMConsultarTerm.setFont(new Font("Arial", 1, 12));
        this.JBTMConsultarTerm.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTMConsultarTerm.setText("Terminología SGC");
        this.JBTMConsultarTerm.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.59
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBTMConsultarTermActionPerformed(evt);
            }
        });
        this.JTPSgc.add(this.JBTMConsultarTerm);
        this.JSPSgc.setViewportView(this.JTPSgc);
        this.JBTSgc.getContentPane().add(this.JSPSgc);
        barraOutlook.addTab("SGC", new ImageIcon(getClass().getResource("/Imagenes/Atomic29x25.png")), this.JBTSgc);
        this.JBTParametrizacion.setBorder(new DropShadowBorder());
        this.JBTParametrizacion.setMaximumSize(new Dimension(366, 380));
        this.JBCrear.setFont(new Font("Arial", 1, 12));
        this.JBCrear.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBCrear.setText("Crear Menú");
        this.JBCrear.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.60
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBCrearActionPerformed(evt);
            }
        });
        this.JBTParametrizacion.getContentPane().add(this.JBCrear);
        this.JSTree.setFont(new Font("Arial", 1, 12));
        this.JSTree.setMaximumSize(new Dimension(366, 380));
        this.JSTree.setMinimumSize(new Dimension(366, 380));
        this.JSTree.setName("");
        this.JSTree.setPreferredSize(new Dimension(366, 380));
        this.JBTParametrizacion.getContentPane().add(this.JSTree);
        barraOutlook.addTab("Parametrización", new ImageIcon(getClass().getResource("/Imagenes/parametrizacion.jpg")), this.JBTParametrizacion);
        this.JBTSgc1.setBorder(new DropShadowBorder());
        this.JBTSgc1.setMaximumSize(new Dimension(366, 380));
        this.JBCrearCal.setFont(new Font("Arial", 1, 12));
        this.JBCrearCal.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBCrearCal.setText("Crear Menú");
        this.JBCrearCal.addActionListener(new ActionListener() { // from class: Acceso.JPModulos.61
            public void actionPerformed(ActionEvent evt) {
                JPModulos.this.JBCrearCalActionPerformed(evt);
            }
        });
        this.JBTSgc1.getContentPane().add(this.JBCrearCal);
        this.JSTreeCal.setMaximumSize(new Dimension(366, 380));
        this.JSTreeCal.setMinimumSize(new Dimension(366, 380));
        this.JSTreeCal.setName("");
        this.JSTreeCal.setPreferredSize(new Dimension(366, 380));
        this.JBTSgc1.getContentPane().add(this.JSTreeCal);
        barraOutlook.addTab("SGC", new ImageIcon(getClass().getResource("/Imagenes/jerarquia.png")), this.JBTSgc1);
        GroupLayout ContModulosLayout = new GroupLayout(ContModulos);
        ContModulos.setLayout(ContModulosLayout);
        ContModulosLayout.setHorizontalGroup(ContModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(ContModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(ContModulosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(barraOutlook, -2, -1, -2).addGap(0, 0, 32767))));
        ContModulosLayout.setVerticalGroup(ContModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767).addGroup(ContModulosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(ContModulosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(barraOutlook, -2, -1, -2).addGap(0, 0, 32767))));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 300, 32767));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAuditoriaMedicaActionPerformed(ActionEvent evt) {
        this.xjp.mActivarBarraMenu(this.xjp.xMenus.barraMnuAuditoriaMedica, 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAutorizacionMPActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuAutorizacionMP, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAutorizacionActionPerformed(ActionEvent evt) {
        this.xjp.mActivarBarraMenu(this.xjp.xMenus.barraMnuAutorizacion, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCajaActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        new AccesoModulos(null, true, "MODULO DE CAJA", "Caja", "k_caja", this.xjp);
        if (this.xjp.activarMenu == 1) {
            if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                Principal.xclase = new claseContabilidad(this.xjp);
                JDSPeriodoContables frmA1 = new JDSPeriodoContables(this.xjp, true, 4);
                frmA1.setLocationRelativeTo(this.xjp);
                frmA1.setVisible(true);
            }
            Principal principal = this.xjp;
            Menus menus = this.xjp.xMenus;
            principal.mActivarBarraMenu(Menus.barraMnuCaja, 12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCajaMActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        new AccesoModulos(null, true, "MODULO DE CAJA MENOR", "Caja Menor", "cajam", this.xjp);
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            JDPeriodoPpto frmAP = new JDPeriodoPpto(this.xjp, true, 1);
            frmAP.setLocationRelativeTo(this.xjp);
            frmAP.setVisible(true);
        }
        if (this.xjp.activarMenu == 1) {
            Principal principal = this.xjp;
            Menus menus = this.xjp.xMenus;
            principal.mActivarBarraMenu(Menus.barraMnuCajaM, 13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnComprasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuCompras, 30);
        this.xjp.verificarContratosPorVencer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnContabilidad1ActionPerformed(ActionEvent evt) {
        cargarParametrosModuloContable(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCirugiaActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        if (Principal.informacionIps.getAplicaVisualizarAgendasNuevas().booleanValue()) {
            JD_AccesoInicial accesoInicial = new JD_AccesoInicial(this.xjp, true, this.xjp, 1);
            accesoInicial.setLocationRelativeTo(this.xjp);
            accesoInicial.setVisible(true);
        } else {
            this.xjp.activarMenu = 0;
            AccesoModulos frmA = new AccesoModulos(null, true, "MODULO DE CIRUG�?A", "Especialidad", "h_historia", this.xjp);
            frmA.setVisible(true);
        }
        if (this.xjp.activarMenu == 1) {
            Principal principal = this.xjp;
            Menus menus = this.xjp.xMenus;
            principal.mActivarBarraMenu(Menus.barraMnuCirugia, 35);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCitasActionPerformed(ActionEvent evt) {
        this.xjp.mActivarBarraMenu(this.xjp.xMenus.barraMnuCita, 7);
        this.xjp.preguntarRealizacionDemandaInducida();
        this.xjp.activarFormularioAtencionPreferencial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEnfermeriaActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        if (Principal.informacionIps.getAplicaVisualizarAgendasNuevas().booleanValue()) {
            JD_AccesoInicial_Efermeria accesoInicial = new JD_AccesoInicial_Efermeria(this.xjp, true, this.xjp, 0);
            accesoInicial.setLocationRelativeTo(this.xjp);
            accesoInicial.setVisible(true);
        } else {
            AccesoModulos frmA = new AccesoModulos(null, true, "MODULO DE ENFERMERIA", "Especialidad", "h_enfermeria", this.xjp);
            frmA.setVisible(true);
        }
        if (this.xjp.activarMenu == 1) {
            Principal principal = this.xjp;
            Menus menus = this.xjp.xMenus;
            principal.mActivarBarraMenu(Menus.barraMnuEnfermeria, 3);
        }
        if (Principal.informacionIps.getAplicaVisualizarAgendasNuevas().booleanValue()) {
            this.xjp.xMenus.JMIPAgenda_UH.setVisible(false);
            this.xjp.xMenus.JMIPAgenda_UH1.setVisible(false);
            this.xjp.xMenus.mnuEnfAtencion.setVisible(false);
            if (Principal.informacionIps.getIdentificacion().equals("812000852") || Principal.informacionIps.getIdentificacion().equals("812000344")) {
                this.xjp.xMenus.JMIPAgenda_UH1.setVisible(true);
                this.xjp.xMenus.mnuEnfAtencion.setVisible(true);
            }
            if (Principal.informacionIps.getIdentificacion().equals("812007286") || Principal.informacionIps.getIdentificacion().equals("901440362")) {
                this.xjp.xMenus.JMIPAgenda_UH.setVisible(false);
            }
            this.xjp.xMenus.mnuEnfAgenda.setVisible(true);
            this.xjp.xMenus.mnuAtencionesEsp.setVisible(false);
            this.xjp.xMenus.mnuEnfAgenda1.setVisible(false);
        } else {
            this.xjp.xMenus.JMIPAgenda_UH.setVisible(false);
            this.xjp.xMenus.JMIPAgenda_UH1.setVisible(true);
            this.xjp.xMenus.mnuEnfAgenda.setVisible(true);
            this.xjp.xMenus.mnuAtencionesEsp.setVisible(true);
            this.xjp.xMenus.mnuEnfAtencion.setVisible(true);
            this.xjp.xMenus.mnuEnfAgenda1.setVisible(true);
        }
        this.xjp.activarFormularioAtencionPreferencial();
        if (Principal.informacionIps.getIdentificacion().equals("812000852") || Principal.informacionIps.getIdentificacion().equals("812000344")) {
            this.xjp.xMenus.JMIPAgenda_UH1.setVisible(true);
            this.xjp.xMenus.mnuEnfAtencion.setVisible(true);
        } else {
            this.xjp.xMenus.mnuEnfAtencion.setVisible(false);
        }
        if (Principal.informacionIps.getIdentificacion().equals("812000317") || Principal.informacionIps.getIdentificacion().equals("812001579")) {
            this.xjp.xMenus.mnuEnfAgenda.setVisible(false);
            this.xjp.xMenus.JMIPAgenda_UH.setVisible(false);
            this.xjp.xMenus.mnuEnfAgenda2.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnFacturacionActionPerformed(ActionEvent evt) {
        this.xjp.mQuitarBarraMenu();
        Principal.xclase = new claseContabilidad(this.xjp);
        Principal.btnCancelar.setVisible(true);
        this.xjp.JLBPeridoC.setVisible(false);
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1 && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            JDSPeriodoContables frmA = new JDSPeriodoContables(this.xjp, true, 4);
            frmA.setLocationRelativeTo(this.xjp);
            frmA.setVisible(true);
        }
        if (Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
            this.xjp.verificarUsuarioCaja();
            this.xjp.activarFormularioAtencionPreferencial();
            Principal.informacionGeneralPrincipalDTO.setActivarFormularioDemandaInducida(false);
        } else if (!Principal.informacionIps.getNombreIps().equals("MINEROS S.A") && !Principal.informacionIps.getNombreIps().equals("EXPLORADORA MINERA S.A.S") && !Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") && !Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A") && !Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") && !Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") && !Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") && !Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") && !Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S") && !Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getIdentificacion().equals("812003851") || Principal.informacionIps.getIdentificacion().equals("900895500")) {
                this.xjp.verificarUsuarioCaja();
                this.xjp.activarFormularioAtencionPreferencial();
                this.xjp.activarPreguntarEncuestaIngreso();
            } else {
                this.xjp.verificarUsuarioCaja();
                this.xjp.verificarManejoBodega();
                this.xjp.activarFormularioAtencionPreferencial();
                this.xjp.preguntarRealizacionDemandaInducida();
            }
        }
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuFacturacion, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGestionCActionPerformed(ActionEvent evt) {
        this.xjp.mQuitarBarraMenu();
        if (Principal.informacionIps.getManejaContabilidad().intValue() != 0) {
            Principal.xclase = new claseContabilidad(this.xjp);
            this.xjp.JLBPeridoC.setVisible(false);
            JDSPeriodoContables frmA = new JDSPeriodoContables(this.xjp, true, 1);
            frmA.setLocationRelativeTo(this.xjp);
            frmA.setVisible(true);
            return;
        }
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuGCuentas, 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGestionDocActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuGestionDoc, 14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGestionActivoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuGestionActivo, 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnInventarioActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        new AccesoModulos(null, true, "MODULO DE SUMINISTROS", "Bodega / Stock", "i_bodegas", this.xjp);
        System.out.println("modulo " + Principal.informacionGeneralPrincipalDTO.getActivarModulo());
        if (Principal.informacionGeneralPrincipalDTO.getActivarModulo().intValue() != 0 || Principal.informacionGeneralPrincipalDTO.getActivarModulo() == null) {
            if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
                Principal.xclase = new claseContabilidad(this.xjp);
                JDSPeriodoContables frmAI = new JDSPeriodoContables(this.xjp, true, 3);
                frmAI.setLocationRelativeTo(this.xjp);
                frmAI.setVisible(true);
            }
            if (this.xjp.activarMenu == 1) {
                Principal principal = this.xjp;
                Menus menus = this.xjp.xMenus;
                principal.mActivarBarraMenu(Menus.barraMnuInventario, 4);
                this.xjp.xMenus.JMIIKardex_P.setVisible(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnHistoriaCEItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnHistoriaCEActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        if (Principal.informacionIps.getAplicaVisualizarAgendasNuevas().booleanValue()) {
            JD_AccesoInicial accesoInicial = new JD_AccesoInicial(this.xjp, true, this.xjp, 0);
            accesoInicial.setLocationRelativeTo(this.xjp);
            accesoInicial.setVisible(true);
        } else {
            AccesoModulos frmA = new AccesoModulos(null, true, "MODULO DE HISTORIA", "Especialidad", "h_historia", this.xjp);
            frmA.setVisible(true);
        }
        if (this.xjp.activarMenu == 1) {
            Principal.btnCancelar.setVisible(true);
            this.xjp.mActivarBarraMenu(Menus.barraMnuHistoriaCE, 2);
            TareaSeguimiento xTareaSeguimiento = new TareaSeguimiento();
            xTareaSeguimiento.iniciarTarea();
        }
        if (Principal.informacionIps.getAplicaVisualizarAgendasNuevas().booleanValue()) {
            Menus menus = this.xjp.xMenus;
            Menus.JMAgendaSeparada.setVisible(true);
            Menus menus2 = this.xjp.xMenus;
            Menus.JMIAgendaN.setVisible(false);
            Menus menus3 = this.xjp.xMenus;
            Menus.JMIAgendaN1.setVisible(false);
            this.xjp.xMenus.JMIAgendaServiciosBeta.setVisible(false);
            if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                Menus menus4 = this.xjp.xMenus;
                Menus.JMIAgendaN.setVisible(true);
                Menus menus5 = this.xjp.xMenus;
                Menus.JMIAgendaN1.setVisible(false);
            }
        } else {
            Menus menus6 = this.xjp.xMenus;
            Menus.JMIAgendaN1.setVisible(false);
            Menus menus7 = this.xjp.xMenus;
            Menus.JMAgendaSeparada.setVisible(false);
            Menus menus8 = this.xjp.xMenus;
            Menus.JMIAgendaN.setVisible(true);
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("CAMBIA TU VIDA IPS SAS") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            Menus menus9 = this.xjp.xMenus;
            Menus.JMIAgendaN.setVisible(false);
            Menus menus10 = this.xjp.xMenus;
            Menus.JMIAgendaN1.setText("Agenda");
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU BUENAVISTA")) {
            this.xjp.xMenus.JMIPAgenda_UH.setVisible(false);
            Menus menus11 = this.xjp.xMenus;
            Menus.JMIAgendaServicios.setVisible(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImagenDxActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        AccesoModulos frmA = new AccesoModulos(null, true, "MODULO DE HISTORIA", "Especialidad", "h_historia", this.xjp);
        frmA.setVisible(true);
        if (this.xjp.activarMenu == 1) {
            Principal principal = this.xjp;
            Menus menus = this.xjp.xMenus;
            principal.mActivarBarraMenu(Menus.barraMnuImagenDx, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTInformesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.JMBInformesV, 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnInformesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.JMBInformesV, 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnMantenimientoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuMant, 25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLabActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        Principal.btnCancelar.setVisible(true);
        new AccesoModulos(null, true, "MODULO DE LABORATORIO", "Especialidad", "laboratorio", this.xjp);
        if (this.xjp.activarMenu == 1) {
            Principal principal = this.xjp;
            Menus menus = this.xjp.xMenus;
            principal.mActivarBarraMenu(Menus.barraMnuLab, 24);
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CL�?NICO LABVY S.A.S") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("GENOMA EMPESARIAL CONSULTORES SAS") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("HOSPITAL NUESTRA SEÑORA DEL CARMEN") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                int n = JOptionPane.showConfirmDialog(this.xjp, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Desea Habilitar la Comunicacion Serial?</p>", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    Principal principal2 = this.xjp;
                    Principal.claselab.cargarPantalla("Comunicacion Serial");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOodontologiaActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        AccesoModulos frmA = new AccesoModulos(null, true, "MODULO DE HISTORIA CL�?NICA ODONTOLOGICA", "Especialidad", "h_historia", this.xjp);
        frmA.setVisible(true);
        if (this.xjp.activarMenu == 1) {
            Principal principal = this.xjp;
            Menus menus = this.xjp.xMenus;
            principal.mActivarBarraMenu(Menus.JMBOdontologia, 31);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnParametrizacionActionPerformed(ActionEvent evt) {
        this.xjp.mQuitarBarraMenu();
        Principal.xclasePresupuesto = new clasePresupuesto(this.xjp);
        this.xjp.JLBPeridoC.setVisible(false);
        this.xjp.JLBUvt.setVisible(false);
        JDPeriodoPpto frmA = new JDPeriodoPpto(this.xjp, true, 0);
        frmA.setLocationRelativeTo(this.xjp);
        frmA.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPyPActionPerformed(ActionEvent evt) {
        this.xjp.mActivarBarraMenu(this.xjp.xMenus.barraMnuPyP, 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRrhhActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuRrhh, 27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSoActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        new AccesoModulos(null, true, "MODULO DE SALUD OCUPACIONAL", "Especialidad", "h_historia1", this.xjp);
        if (this.xjp.activarMenu == 1) {
            Principal principal = this.xjp;
            Menus menus = this.xjp.xMenus;
            principal.mActivarBarraMenu(Menus.JMBSo, 33);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSgcActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuSgc, 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTriageActionPerformed(ActionEvent evt) {
        JD_AccesoInicial_Efermeria accesoInicial = new JD_AccesoInicial_Efermeria(this.xjp, true, this.xjp, 0);
        accesoInicial.setLocationRelativeTo(this.xjp);
        accesoInicial.setVisible(true);
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuTriage, 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTransicionXencoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuTrancisionXenco, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnActivarPersonaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("ActivarPersona");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAcronimosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla(this.btnAcronimos.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAutorizacionDocActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclase = new claseContabilidad(this.xjp);
        Principal principal2 = this.xjp;
        Principal.xclase.cargarPantalla("Autorización Documentos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCanvioClaveActionPerformed(ActionEvent evt) {
        CambioClave frmCambio = new CambioClave(this.xjp, true, Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString(), 0);
        frmCambio.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCambiarNHCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("CambiarIdentificacion");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCrearPersonaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("CrearPersona");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDesactivarPersonaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("DesactivarPersona");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAdmNovedadesNominaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("NovedadesNomina");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnProgramadorReunionesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Reuniones");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRadiDocumentoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("Radicación documentos clínicos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnLlamarActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("Llamadas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRegistroActasActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc.cargarPantalla("Actas");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRegistroResiduosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseparametrizacionn.cargarPantalla("Registro de Disposicion de Residuos");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRequisicionActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasecomprabn = new claseComprasBienesServicios(this.xjp);
        Principal principal2 = this.xjp;
        Principal.clasecomprabn.cargarPantalla(this.btnRequisicion.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRutaSoportesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.claseparametrizacionn.cargarPantalla("Rutas de Soportes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSolicitudActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla(this.btnSolicitud.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTMProcesoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xclasesgc = new claseSgc();
        this.xjp.xjdmapap = new JDMapaProceso(this.xjp, true);
        this.xjp.xjdmapap.setLocationRelativeTo(this.xjp);
        this.xjp.xjdmapap.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTMEncuestaActionPerformed(ActionEvent evt) {
        this.xjp.verificarEncuestasPendientes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTMRporteNCActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("ReporteNC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTMConsultarTermActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla("Glosario");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCrearActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xJtree.addRegion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCrearCalActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.xJtreeCal.addRegionCal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnReferenciaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuReferencia, 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSoportesDigitalizadosActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Menus menus = this.xjp.xMenus;
        principal.mActivarBarraMenu(Menus.barraMnuSoportesDigitalizados, 37);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSolicitudPedidoInternoActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla(this.btnSolicitudPedidoInterno.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImportarInformacionUsuarioActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla(this.btnImportarInformacionUsuario.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRegistroFacturaActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla(this.btnRegistroFactura.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnBitacoraRegistroActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla(this.btnBitacoraRegistro.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnControlRemisionesActionPerformed(ActionEvent evt) {
        Principal principal = this.xjp;
        Principal.clasegeneral.cargarPantalla(this.btnControlRemisiones.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnTesoreriaActionPerformed(ActionEvent evt) {
        cargarParametrosModuloContable(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCytologixActionPerformed(ActionEvent evt) {
        this.xjp.activarMenu = 0;
        Principal.btnCancelar.setVisible(true);
        new AccesoModulos(null, true, "MODULO DE CITOLOGÍA", "Especialidad", "Citologia", this.xjp);
        if (this.xjp.activarMenu == 1) {
            Principal principal = this.xjp;
            Menus1 menus1 = this.xjp.xMenus1;
            principal.mActivarBarraMenu(Menus1.barraMnuCitologix, 38);
        }
    }

    private void cargarParametrosModuloContable(int modulo) {
        this.xjp.mQuitarBarraMenu();
        Principal.xclase = new claseContabilidad(this.xjp);
        Principal.tesoreriaController = new ClaseTesoreriaController(this.xjp);
        Principal.claseparametrizacionn = new claseParametrizacionN(this.xjp);
        this.xjp.JLBPeridoC.setVisible(false);
        this.xjp.JLBUvt.setVisible(false);
        this.xjp.xMenus.JMIInformeContraloria.setVisible(false);
        this.xjp.xMenus.JMIInformeFinancieros.setVisible(false);
        this.xjp.xMenus.JMICIEjecucionP.setVisible(false);
        JDSPeriodoContables frmA = new JDSPeriodoContables(this.xjp, true, modulo);
        frmA.setLocationRelativeTo(this.xjp);
        frmA.setVisible(true);
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            JDPeriodoPpto frmAP = new JDPeriodoPpto(this.xjp, true, 1);
            frmAP.setLocationRelativeTo(this.xjp);
            frmAP.setVisible(true);
        }
    }
}
