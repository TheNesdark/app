package Facturacion;

import Acceso.Principal;
import Caja.claseCaja;
import General.Anular;
import General.BuscarPersona;
import General.JDAtencionesPreferenciales;
import General.JDBiometrico;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.BuscarIngresoAgil;
import com.genoma.plus.controller.facturacion.JDCarnerVacuna;
import com.genoma.plus.controller.facturacion.JDSoporte_Escaneado;
import com.genoma.plus.controller.facturacion.JD_ValidacionDerechoCovenio;
import com.genoma.plus.controller.general.JDHistoricoTrazabilidad;
import com.genoma.plus.controller.general.dto.EncuestaRegistroUsuario;
import com.genoma.plus.dao.facturacion.SalidaInventarioParaFacturacionDAO;
import com.genoma.plus.dao.impl.facturacion.SalidaInventarioParaFacturacionDAOImpl;
import com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaDAOImpl;
import com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl;
import com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO;
import com.genoma.plus.dao.integracion_simedis.LaboratorioDAO;
import com.genoma.plus.dto.integracion_simedis.LaboratoriosDTO;
import com.l2fprod.common.swing.JTaskPane;
import com.l2fprod.common.swing.JTaskPaneGroup;
import com.l2fprod.common.swing.PercentLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Facturac.class */
public class Facturac extends JInternalFrame {
    public claseFacturacion clasefacturacion;
    public claseCaja clasecaja;
    public int cajaAbierta;
    private String sql;
    private SalidaInventarioParaFacturacionDAO inventarioParaFacturacionDAO;
    public static Integer idModulo;
    private IntegracionExternaDAO integracionExternaDAO;
    private EncuestaRegistroUsuario encuestaRegistroUsuario;
    public int cargaInicial;
    private JButton JBTHuella;
    private JButton JBTHuella1;
    private JButton JBTRegistroHora;
    private JButton JBTRegistroHora1;
    private JTextField JTF_NRegistro;
    public JButton btnConsolidado;
    private JButton btnWanglabUser;
    private JButton btnWanglabUser1;
    private JScrollPane jScrollPane1;
    private JTaskPane jTaskPane2;
    private JTaskPaneGroup jtpIngreso;
    private JTaskPaneGroup jtpOrdenes;
    public JTaskPaneGroup jtpUsuario;
    private JPanel panelIngreso;
    public JPanel panelMvto;
    private JPanel panelPersona;
    private Metodos metodos = new Metodos();
    public Persona frmPersona = null;
    public Ingreso frmIngreso = null;
    public JIFAgendaTaquilla agendaTaquilla = null;
    public Ordenes frmOrdenes = null;
    public Ordenes frmOrdenes1 = null;
    public Consolidado frmc = null;
    public BuscarPersona frmBuscarP = null;
    public BuscarIngreso frmBuscarI = null;
    public BuscarOrdenes frmBuscarO = null;
    public JDConsolidadOrdenes frmConsolidado = null;
    public JDCarnerVacuna frmJDCarnerVacuna = null;
    public BuscarIngresoAgil agil = null;
    public Egreso frmEgreso = null;
    private int nbusqueda = -1;
    private Anular frm = null;
    public boolean xesconsulta = false;
    private boolean xhorallegado = false;
    public String xesso = "no";
    private String idSalidaInventario = "0";
    private String idOrdenSimedis = "";
    private String nombreConvenioInterface = "";
    public Facturac frmFacturac = null;

    public Facturac(claseFacturacion xclasefacturacion, int cajaabierta, claseCaja claseC) {
        this.clasefacturacion = null;
        this.clasecaja = null;
        initComponents();
        springStart();
        this.cargaInicial = 0;
        System.out.println("mdulo 1" + xclasefacturacion.idSalida);
        this.clasefacturacion = xclasefacturacion;
        this.encuestaRegistroUsuario = EncuestaRegistroUsuario.builder().build();
        this.clasecaja = claseC;
        this.cajaAbierta = cajaabierta;
        this.title = "FACTURACIÓN DE SERVICIOS";
        cargarPanelPersona();
        cargarPanelIngreso();
        cargarPanelOrdenes();
        Principal.lblNo.setText("No. Ingreso");
        Principal.mLimpiarDatosP();
        this.frmPersona.txtHistoria.requestFocus();
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getIdentificacion().equals("812000317")) {
            this.btnWanglabUser.setVisible(true);
        } else {
            this.btnWanglabUser.setVisible(false);
        }
        this.cargaInicial = 1;
    }

    public Facturac(claseFacturacion xclasefacturacion, int cajaabierta, claseCaja claseC, String idOrdenSimedis, String t) {
        this.clasefacturacion = null;
        this.clasecaja = null;
        initComponents();
        this.cargaInicial = 0;
        springStart();
        setIdOrdenSimedis(idOrdenSimedis);
        setnombreConvenioInterface(t);
        System.out.println("mdulo 2" + xclasefacturacion.idSalida);
        this.encuestaRegistroUsuario = EncuestaRegistroUsuario.builder().build();
        this.clasefacturacion = xclasefacturacion;
        this.clasecaja = claseC;
        this.cajaAbierta = cajaabierta;
        this.title = "FACTURACIÓN DE SERVICIOS";
        cargarPanelPersona();
        cargarPanelIngreso();
        cargarPanelOrdenes();
        Principal.lblNo.setText("No. Ingreso");
        Principal.mLimpiarDatosP();
        this.frmPersona.txtHistoria.requestFocus();
        cargarDatosIntegracionSimedis();
        this.cargaInicial = 1;
    }

    public Facturac(claseFacturacion xclasefacturacion, int cajaabierta, claseCaja claseC, String xnhc) {
        this.clasefacturacion = null;
        this.clasecaja = null;
        idModulo = 0;
        this.cargaInicial = 0;
        initComponents();
        System.out.println("mdulo 3" + xclasefacturacion.idSalida);
        this.clasefacturacion = xclasefacturacion;
        this.clasecaja = claseC;
        this.cajaAbierta = cajaabierta;
        this.encuestaRegistroUsuario = EncuestaRegistroUsuario.builder().build();
        this.title = "FACTURACIÓN DE SERVICIOS";
        cargarPanelPersona();
        cargarPanelIngreso();
        cargarPanelOrdenes();
        Principal.lblNo.setText("No. Ingreso");
        Principal.mLimpiarDatosP();
        this.frmPersona.txtHistoria.setText(xnhc);
        this.frmPersona.buscar(2);
        this.frmIngreso.mBuscarIngresos(this.frmPersona.getIdPersona());
        this.frmPersona.txtHistoria.requestFocus();
        this.cargaInicial = 1;
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.inventarioParaFacturacionDAO = (SalidaInventarioParaFacturacionDAOImpl) classPathXmlApplicationContext.getBean("salidaInventarioParaFacturacionDAOImpl");
        this.integracionExternaDAO = (IntegracionExternaDAOImpl) classPathXmlApplicationContext.getBean("integracionExternaDAOImpl");
    }

    public int getNbusqueda() {
        return this.nbusqueda;
    }

    public void setNbusqueda(int nbusqueda) {
        this.nbusqueda = nbusqueda;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo2) {
        idModulo = idModulo2;
    }

    public String getIdOrdenSimedis() {
        return this.idOrdenSimedis;
    }

    public void setIdOrdenSimedis(String idOrdenSimedis) {
        this.idOrdenSimedis = idOrdenSimedis;
    }

    public String getnombreConvenioInterface() {
        return this.nombreConvenioInterface;
    }

    public void setnombreConvenioInterface(String nombreConvenioInterface) {
        this.nombreConvenioInterface = nombreConvenioInterface;
    }

    public void setEncuestaRegistroUsuario(EncuestaRegistroUsuario encuestaRegistroUsuario) {
        this.encuestaRegistroUsuario = encuestaRegistroUsuario;
    }

    public EncuestaRegistroUsuario getEncuestaRegistroUsuario() {
        return this.encuestaRegistroUsuario;
    }

    public void buscar() {
        Buscar buscar = new Buscar((Frame) new JFrame(), true, this);
        buscar.setLocationRelativeTo(this);
        buscar.setVisible(true);
        switch (getNbusqueda()) {
            case 0:
                if (this.metodos.getValidarDatosPersona(this.frmPersona) == 1) {
                    this.frmBuscarP = new BuscarPersona(null, true, this.frmPersona);
                    this.frmBuscarP.setLocationRelativeTo(this);
                    this.frmBuscarP.setVisible(true);
                    this.frmBuscarP.buscar();
                }
                break;
            case 1:
                if (this.frmPersona.getIdPersona() == null || this.frmPersona.getIdPersona().equals("")) {
                    this.metodos.mostrarMensaje("Debe estar seleccionado un Usuario");
                } else {
                    this.frmBuscarI = new BuscarIngreso((Frame) null, true, this);
                    this.frmBuscarI.setLocationRelativeTo(this);
                    this.frmBuscarI.setVisible(true);
                }
                break;
            case 2:
                if (this.frmIngreso.getIdIngreso() == null || this.frmIngreso.getIdIngreso().equals("0")) {
                    this.metodos.mostrarMensaje("Debe estar seleccionado un Ingreso");
                } else {
                    this.frmBuscarO = new BuscarOrdenes((Frame) null, true, this);
                    this.frmBuscarO.setLocationRelativeTo(this);
                    this.frmBuscarO.setVisible(true);
                }
                break;
            case 3:
                if (this.frmPersona.getIdPersona() == null || this.frmPersona.getIdPersona().equals("")) {
                    this.metodos.mostrarMensaje("Debe estar seleccionado un Usuario");
                } else {
                    this.frmConsolidado = new JDConsolidadOrdenes((Frame) null, true, this);
                    this.frmConsolidado.setLocationRelativeTo(this);
                    this.frmConsolidado.setVisible(true);
                }
                break;
            case 4:
                if (this.frmPersona.getIdPersona() == null || this.frmPersona.getIdPersona().equals("")) {
                    this.metodos.mostrarMensaje("Debe estar seleccionado un Usuario");
                } else {
                    this.frmJDCarnerVacuna = new JDCarnerVacuna((Frame) null, true, this, "12");
                    this.frmJDCarnerVacuna.setLocationRelativeTo(this);
                    this.frmJDCarnerVacuna.setVisible(true);
                }
                break;
        }
    }

    public void buscarConsolidado() {
        if (Principal.informacionIps.getAplicaHistoricoAnteciones().booleanValue()) {
            this.frmConsolidado = new JDConsolidadOrdenes((Frame) null, true, this);
            this.frmConsolidado.setLocationRelativeTo(this);
            this.frmConsolidado.setVisible(true);
        }
    }

    public void anular() {
        AnularFact anular = new AnularFact((Frame) new JFrame(), true, this);
        anular.setLocationRelativeTo(this);
        anular.setVisible(true);
        switch (getNbusqueda()) {
            case 1:
                if (!this.frmIngreso.getIdIngreso().equals("0") || !this.frmIngreso.getIdIngreso().equals("")) {
                    if (this.frmIngreso.verificarEstadoFacturaIngreso(this.frmIngreso.getIdIngreso()) != 0) {
                        if (this.frmIngreso.verificarEstadoOrdenesIngreso(this.frmIngreso.getIdIngreso()) != 0) {
                            this.frm = new Anular(null, true, "Ingreso", 5);
                            this.frm.setVisible(true);
                            return;
                        } else {
                            this.metodos.mostrarMensaje("Existen Ordenes Activas Asociadas a éste Ingreso");
                            return;
                        }
                    }
                    this.metodos.mostrarMensaje("Existen Facturas Activas Asociadas a éste Ingreso");
                    return;
                }
                this.metodos.mostrarMensaje("Por favor Seleccione un Ingreso");
                return;
            case 2:
                if (!this.frmIngreso.getIdIngreso().equals("0")) {
                    if (this.frmIngreso.verificarEstadoFacturaIngreso(this.frmIngreso.getIdIngreso()) != 0) {
                        if (this.frmOrdenes.gridTotales.getRowCount() > 0) {
                            if (this.frmOrdenes.gridTotales.getSelectedRow() > -1) {
                                this.frm = new Anular(null, true, "Ordenes", 5);
                                this.frm.setVisible(true);
                                return;
                            } else {
                                this.metodos.mostrarMensaje("Por Favor Seleccione la orden a Anular");
                                return;
                            }
                        }
                        this.metodos.mostrarMensaje("No Tiene Ordenes Cargadas para Anular");
                        return;
                    }
                    this.metodos.mostrarMensaje("Existe Factura Activa para ésta Orden");
                    return;
                }
                break;
            case 3:
                break;
            default:
                return;
        }
        this.frm = new Anular((Frame) null, true, "Ingreso", 5, 1);
        this.frm.setVisible(true);
    }

    private void cargarPanelIngreso() {
        if (this.frmIngreso == null) {
            this.frmIngreso = new Ingreso(this, "Facturac", "1");
        }
        this.frmIngreso.setVisible(true);
        this.panelIngreso.setVisible(false);
        this.frmIngreso.setBounds(1, 1, 1190, 500);
        this.panelIngreso.add(this.frmIngreso);
        this.panelIngreso.setVisible(true);
    }

    private void cargarPanelOrdenes() {
        if (this.frmOrdenes == null) {
            this.frmOrdenes = new Ordenes(this, 0);
        }
        this.frmOrdenes.setVisible(true);
        this.panelMvto.setVisible(false);
        this.frmOrdenes.setBounds(1, 1, 1190, 500);
        this.panelMvto.add(this.frmOrdenes);
        this.panelMvto.setVisible(true);
    }

    private void cargarPanelPersona() {
        if (this.frmPersona == null) {
            this.frmPersona = new Persona(this);
        }
        this.frmPersona.setVisible(true);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 1006, 226);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.txtHistoria.requestFocus();
    }

    private void cargarPanel(JPanel frm, String titulo) {
        this.jtpOrdenes.setEnabled(true);
        this.jtpOrdenes.setExpanded(true);
        this.jtpOrdenes.setTitle(titulo);
        this.panelMvto.setVisible(false);
        frm.setBounds(1, 1, 1190, 500);
        this.panelMvto.add(frm);
        this.panelMvto.setVisible(true);
        frm.setVisible(true);
    }

    private void expansionUsuario() {
        String Usuario = this.frmPersona.getApellido1().trim() + " " + this.frmPersona.getApellido2().trim() + " " + this.frmPersona.getNombre1().trim() + " " + this.frmPersona.getNombre2().trim();
        if (!this.jtpUsuario.isExpanded()) {
            this.jtpUsuario.setTitle("Usuario: " + Usuario);
        } else {
            this.jtpUsuario.setTitle("Datos del Usuario");
        }
    }

    private void expansionIngreso() {
        String Mensaje;
        String Mensaje2;
        String Mensaje3;
        String Mensaje4;
        String Mensaje5 = this.frmIngreso.txtFecha.getDate() == null ? "" : "Fecha: " + this.metodos.formatoDMA.format(this.frmIngreso.txtFecha.getDate()).toString() + " - ";
        if (this.frmIngreso.cboEmpresa.getSelectedIndex() < 0) {
            Mensaje = Mensaje5 + "";
        } else {
            Mensaje = Mensaje5 + "Empresa: " + this.frmIngreso.cboEmpresa.getSelectedItem().toString() + " - ";
        }
        if (this.frmIngreso.cboEstrato1.getSelectedIndex() < 0) {
            Mensaje2 = Mensaje + "";
        } else {
            Mensaje2 = Mensaje + "Estrato: " + this.frmIngreso.cboEstrato1.getSelectedItem().toString() + " - ";
        }
        if (this.frmIngreso.cboEspecialidad.getSelectedIndex() < 0) {
            Mensaje3 = Mensaje2 + "";
        } else {
            Mensaje3 = Mensaje2 + "Especialidad: " + this.frmIngreso.cboEspecialidad.getSelectedItem().toString() + " - ";
        }
        if (this.frmIngreso.cboProfesional.getSelectedIndex() < 0) {
            Mensaje4 = Mensaje3 + "";
        } else {
            Mensaje4 = Mensaje3 + "Profesional: " + this.frmIngreso.cboProfesional.getSelectedItem().toString();
        }
        if (!this.jtpIngreso.isExpanded()) {
            this.jtpIngreso.setTitle(Mensaje4);
        } else {
            this.jtpIngreso.setTitle("Datos del Ingreso");
        }
    }

    public void limpiarPanelMvto() {
        this.panelMvto.removeAll();
        this.jtpOrdenes.setExpanded(false);
        this.jtpOrdenes.setEnabled(false);
        this.jtpOrdenes.setTitle("");
    }

    public void nuevo() {
        Principal.mLimpiarDatosP();
        Principal.informacionGeneralPrincipalDTO.setAtencionPreferencial(0);
        this.JTF_NRegistro.setText("");
        this.frmPersona.nuevo();
        this.frmOrdenes.nuevo();
        this.frmIngreso.nuevo();
        this.clasefacturacion.setXgrabadofact(false);
        this.btnConsolidado.setEnabled(false);
        this.xhorallegado = false;
        this.xesso = "no";
        this.clasefacturacion.setxId_Rechazo(0L);
        if (this.cajaAbierta == 0) {
            this.frmOrdenes.xJp_RCaja.mNuevo();
        }
        this.frmPersona.txtHistoria.requestFocus();
        setIdSalidaInventario("0");
    }

    public void cargarInformacionSalidaInventario(String idSalida) {
        if (Principal.informacionIps.getAplicaFacturacionDespacho().booleanValue()) {
            this.frmOrdenes.cargarSalida(idSalida);
        }
    }

    private void cargarDatosIntegracionSimedis() {
        LaboratorioDAO laboratorioDAO;
        LaboratoriosDTO e;
        List<Object[]> listaDetalle;
        System.out.println("Codigo Orden Externa: " + this.idOrdenSimedis);
        if (!this.idOrdenSimedis.equals("0")) {
            laboratorioDAO = new LaboratorioDAOImpl();
            e = null;
            switch (Principal.informacionIps.getNombreIps()) {
                case "SERVICIOS MEDICOS SAN IGNACIO SAS":
                case "ZONAMEDICA MR S.A.S":
                    e = laboratorioDAO.recepcionIdOrde(this.idOrdenSimedis);
                    break;
                case "HOSPITAL SAN VICENTE DE PAUL":
                case "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH":
                case "CLINICA SANTA CLARA SAS":
                    e = laboratorioDAO.recepcionIdOrden(this.idOrdenSimedis);
                    break;
                case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
                case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
                case "LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.":
                    e = laboratorioDAO.recepcionIdOrdenDinamica(this.idOrdenSimedis);
                    break;
                case "EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA":
                case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS":
                    e = laboratorioDAO.recepcionIdOrdenCNTBiomed(this.idOrdenSimedis);
                    break;
                case "COLGENES S.A.S":
                    e = laboratorioDAO.recepcionIdOrdenColgenes(this.idOrdenSimedis);
                    break;
            }
            if (e != null) {
                System.err.println("si entra a cargar de interface " + e.getDocumento());
                this.frmPersona.txtHistoria.setText(e.getDocumento());
                this.frmPersona.txtHistoria.transferFocus();
                this.frmPersona.buscar(2);
                if (this.frmPersona.getIdPersona().equals("0")) {
                    System.err.println("no entra a cargar de interface1 ");
                    System.err.println("tipo documento  :" + e.getTipoDocumento());
                    this.frmPersona.txtIdentificacion.setText(e.getDocumento());
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                        this.frmPersona.cboTipoIdentificacion.setSelectedItem("Cédula de Ciudadanía");
                    } else {
                        switch (e.getTipoDocumento()) {
                            case "CC":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Cédula de Ciudadanía");
                                break;
                            case "CE":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Cedula Extranjeria");
                                break;
                            case "PA":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Pasaporte");
                                break;
                            case "TI":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Tarjeta Identidad");
                                break;
                            case "CN":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Certificado Nacido Vivo");
                                break;
                            case "NU":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Numero Unico Identificación");
                                break;
                            case "RC":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Registro Civil");
                                break;
                            case "AS":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Adulto sin Identificación");
                                break;
                            case "MS":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Menor sin Identificación");
                                break;
                            case "PT":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Permiso por proteccion temporal");
                                break;
                            case "PE":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Permiso Especial");
                                break;
                            case "SC":
                                this.frmPersona.cboTipoIdentificacion.setSelectedItem("Salvoconducto");
                                break;
                        }
                    }
                    this.frmPersona.txtApellido1.setText(e.getApellido1());
                    this.frmPersona.txtApellido2.setText(e.getApellido2());
                    this.frmPersona.txtNombre1.setText(e.getNombre1());
                    this.frmPersona.txtNombre2.setText(e.getNombre2());
                    System.out.println("Fecha Nacimineto " + e.getFechaNacimiento());
                    this.frmPersona.cboFechaNacimiento.setDate(Date.valueOf(e.getFechaNacimiento()));
                    this.frmPersona.cboSexo.setSelectedItem(e.getIdSexo().toUpperCase());
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                        this.frmPersona.cboEps.setSelectedItem(e.getNombreEmpresa());
                    } else {
                        this.frmPersona.cboEps.setSelectedItem("PARTICULARES");
                    }
                    this.frmPersona.txtDireccion.setText(e.getDireccion());
                    this.frmPersona.txtTelefono1.setText(e.getMovil());
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                        System.err.println("SEXO" + e.getIdSexo());
                        if (e.getIdSexo().equals("M")) {
                            this.frmPersona.cboSexo.setSelectedItem("MASCULINO");
                        } else if (e.getIdSexo().equals("F")) {
                            this.frmPersona.cboSexo.setSelectedItem("FEMENINO");
                        }
                    } else {
                        this.frmPersona.cboSexo.setSelectedItem(e.getIdSexo().toUpperCase());
                    }
                }
                if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                    System.err.println("Servicio Interface " + e.getTipoServicio());
                    this.frmIngreso.cboTipoAtencion.setSelectedItem(e.getTipoServicio().toUpperCase());
                }
                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                    this.frmIngreso.cboEmpresa.setSelectedItem(getnombreConvenioInterface());
                    this.frmIngreso.cboEspecialidad.setSelectedIndex(3);
                } else {
                    this.frmIngreso.cboEmpresa.setSelectedItem("PARTICULARES");
                }
                this.frmIngreso.cboEstrato1.setSelectedItem("NO APLICA");
                this.frmIngreso.JCBEscolaridad.setSelectedItem("NINGUNO");
                this.frmIngreso.txtNoPoliza.setText(e.getNumeroAdmision());
                this.frmOrdenes.JCBGrupoSevicio.setSelectedItem(this.frmIngreso.cboEspecialidad.getSelectedItem());
                listaDetalle = null;
                switch (Principal.informacionIps.getNombreIps()) {
                    case "SERVICIOS MEDICOS SAN IGNACIO SAS":
                    case "ZONAMEDICA MR S.A.S":
                        listaDetalle = this.integracionExternaDAO.listadoProcedimientoItems(e.getCodigoServicio(), 0);
                        break;
                    case "HOSPITAL SAN VICENTE DE PAUL":
                        listaDetalle = this.integracionExternaDAO.listadoProcedimientoItems(e.getNumeroOrden(), 1);
                        break;
                    case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
                    case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
                    case "LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.":
                        listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsDinamica(String.valueOf(e.getNumeroOrden()));
                        break;
                    case "CLINICA SAN FRANCISCO S.A.":
                        listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsDinamica(String.valueOf(e.getNumeroOrden()));
                        break;
                    case "CLINICA SANTA CLARA SAS":
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH":
                        listaDetalle = this.integracionExternaDAO.listadoProcedimientoItemsSifas(String.valueOf(e.getNumeroOrden()), this.clasefacturacion.getIdCodigoInternoInterface());
                        break;
                }
                if (!listaDetalle.isEmpty()) {
                    this.frmOrdenes.cboServicio.setSelectedItem("LABORATORIO");
                    for (int i = 0; i < listaDetalle.size(); i++) {
                        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                            this.frmIngreso.txtNoAutorizacion.setText(listaDetalle.get(i)[0].toString());
                        }
                        List<Object[]> listaCNT = this.integracionExternaDAO.listadoProcedimientoHomologadosCNT(String.valueOf(listaDetalle.get(i)[0].toString()));
                        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                            if (!listaCNT.isEmpty()) {
                                System.err.println("codigo  consulta homologa " + listaCNT.get(0)[0].toString());
                                this.frmOrdenes.txtCodigo.setText(listaCNT.get(0)[0].toString());
                            } else {
                                System.err.println("codigo  consulta directo " + listaDetalle.get(i)[0].toString());
                                this.frmOrdenes.txtCodigo.setText(listaDetalle.get(i)[0].toString());
                            }
                        } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                            this.frmOrdenes.txtCodigo.setText(listaCNT.get(0)[0].toString());
                        } else {
                            this.frmOrdenes.txtCodigo.setText(listaDetalle.get(i)[0].toString());
                        }
                        switch (Principal.informacionIps.getNombreIps()) {
                            case "SERVICIOS MEDICOS SAN IGNACIO SAS":
                            case "ZONAMEDICA MR S.A.S":
                                this.frmOrdenes.cboProcedSuministro.setSelectedItem(listaDetalle.get(i)[1].toString());
                                this.frmOrdenes.bajarTabla("");
                                break;
                            case "HOSPITAL SAN VICENTE DE PAUL":
                            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH":
                            case "CLINICA SANTA CLARA SAS":
                                this.frmOrdenes.cboProcedSuministro.setSelectedItem(listaDetalle.get(i)[1].toString());
                                this.frmOrdenes.bajarTabla(listaDetalle.get(i)[2].toString());
                                break;
                            case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
                            case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
                            case "LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.":
                                this.frmOrdenes.txtCodigo.transferFocus();
                                this.frmOrdenes.verificarCodProcSum();
                                this.frmOrdenes.bajarTabla("");
                                break;
                            case "CLINICA SAN FRANCISCO S.A.":
                            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA":
                            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS":
                                this.frmOrdenes.txtCodigo.transferFocus();
                                this.frmOrdenes.verificarCodProcSum();
                                this.frmOrdenes.bajarTablaInterfaceGIIS(listaDetalle.get(i)[2].toString());
                                break;
                        }
                    }
                }
                this.frmIngreso.txtNoAutorizacion.setText(String.valueOf(e.getNumeroOrden()));
            }
            System.err.println("no entra a cargar de interface ");
        }
    }

    private void initComponents() {
        this.jTaskPane2 = new JTaskPane();
        this.jScrollPane1 = new JScrollPane();
        this.jtpUsuario = new JTaskPaneGroup();
        this.panelPersona = new JPanel();
        this.JBTRegistroHora = new JButton();
        this.btnConsolidado = new JButton();
        this.JBTRegistroHora1 = new JButton();
        this.btnWanglabUser = new JButton();
        this.btnWanglabUser1 = new JButton();
        this.JBTHuella = new JButton();
        this.jtpIngreso = new JTaskPaneGroup();
        this.panelIngreso = new JPanel();
        this.jtpOrdenes = new JTaskPaneGroup();
        this.panelMvto = new JPanel();
        this.JTF_NRegistro = new JTextField();
        this.JBTHuella1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setAutoscrolls(true);
        setFont(new Font("Agency FB", 3, 10));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        setName("Facturac");
        addInternalFrameListener(new InternalFrameListener() { // from class: Facturacion.Facturac.1
            public void internalFrameActivated(InternalFrameEvent evt) {
                Facturac.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                Facturac.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
                Facturac.this.formInternalFrameOpened(evt);
            }
        });
        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.setVerticalScrollBarPolicy(21);
        this.jtpUsuario.setBackground(new Color(0, 153, 153));
        this.jtpUsuario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Paciente.png")));
        this.jtpUsuario.setScrollOnExpand(true);
        this.jtpUsuario.setTitle("Datos del Usuario");
        this.jtpUsuario.setToolTipText("Datos del Usuario");
        this.jtpUsuario.setFont(new Font("Arial", 1, 12));
        this.jtpUsuario.addMouseListener(new MouseAdapter() { // from class: Facturacion.Facturac.2
            public void mouseClicked(MouseEvent evt) {
                Facturac.this.jtpUsuarioMouseClicked(evt);
            }
        });
        this.panelPersona.setFont(new Font("Arial", 1, 12));
        this.panelPersona.setPreferredSize(new Dimension(920, 165));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1043, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JBTRegistroHora.setFont(new Font("Arial", 1, 12));
        this.JBTRegistroHora.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaExcepcion.png")));
        this.JBTRegistroHora.setText("<html><P ALIGN=center>Registrar Hora de Llegada");
        this.JBTRegistroHora.addActionListener(new ActionListener() { // from class: Facturacion.Facturac.3
            public void actionPerformed(ActionEvent evt) {
                Facturac.this.JBTRegistroHoraActionPerformed(evt);
            }
        });
        this.btnConsolidado.setFont(new Font("Arial", 1, 12));
        this.btnConsolidado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/caja.png")));
        this.btnConsolidado.setText("<html><P ALIGN=center>Consolidado Servicios");
        this.btnConsolidado.setToolTipText("");
        this.btnConsolidado.setEnabled(false);
        this.btnConsolidado.setIconTextGap(0);
        this.btnConsolidado.addActionListener(new ActionListener() { // from class: Facturacion.Facturac.4
            public void actionPerformed(ActionEvent evt) {
                Facturac.this.btnConsolidadoActionPerformed(evt);
            }
        });
        this.JBTRegistroHora1.setFont(new Font("Arial", 1, 12));
        this.JBTRegistroHora1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/CitaNP.png")));
        this.JBTRegistroHora1.setText("<html><P ALIGN=center>Consultar Validación");
        this.JBTRegistroHora1.addActionListener(new ActionListener() { // from class: Facturacion.Facturac.5
            public void actionPerformed(ActionEvent evt) {
                Facturac.this.JBTRegistroHora1ActionPerformed(evt);
            }
        });
        this.btnWanglabUser.setFont(new Font("Arial", 1, 12));
        this.btnWanglabUser.setText("<html><P ALIGN=center> Registro Wanglab");
        this.btnWanglabUser.addActionListener(new ActionListener() { // from class: Facturacion.Facturac.6
            public void actionPerformed(ActionEvent evt) {
                Facturac.this.btnWanglabUserActionPerformed(evt);
            }
        });
        this.btnWanglabUser1.setFont(new Font("Arial", 1, 12));
        this.btnWanglabUser1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/info_FILL0_wght400_GRAD0_opsz24.png")));
        this.btnWanglabUser1.setText("Info Trazabilidad");
        this.btnWanglabUser1.setToolTipText("Información de trazabilidad de ingreso");
        this.btnWanglabUser1.addActionListener(new ActionListener() { // from class: Facturacion.Facturac.7
            public void actionPerformed(ActionEvent evt) {
                Facturac.this.btnWanglabUser1ActionPerformed(evt);
            }
        });
        this.JBTHuella.setFont(new Font("Arial", 1, 12));
        this.JBTHuella.setIcon(new ImageIcon(getClass().getResource("/Imagenes/huella1 (1).png")));
        this.JBTHuella.setText("<html><P ALIGN=center>Firma Ingreso");
        this.JBTHuella.setToolTipText("Firma de Ingreso");
        this.JBTHuella.addActionListener(new ActionListener() { // from class: Facturacion.Facturac.8
            public void actionPerformed(ActionEvent evt) {
                Facturac.this.JBTHuellaActionPerformed(evt);
            }
        });
        this.jtpIngreso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.jtpIngreso.setTitle("Datos del Ingreso");
        this.jtpIngreso.setFont(new Font("Arial", 1, 12));
        this.jtpIngreso.addMouseListener(new MouseAdapter() { // from class: Facturacion.Facturac.9
            public void mouseClicked(MouseEvent evt) {
                Facturac.this.jtpIngresoMouseClicked(evt);
            }
        });
        this.panelIngreso.setFont(new Font("Arial", 1, 12));
        this.panelIngreso.setPreferredSize(new Dimension(1168, 226));
        GroupLayout panelIngresoLayout = new GroupLayout(this.panelIngreso);
        this.panelIngreso.setLayout(panelIngresoLayout);
        panelIngresoLayout.setHorizontalGroup(panelIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1174, 32767));
        panelIngresoLayout.setVerticalGroup(panelIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 226, 32767));
        this.jtpIngreso.getContentPane().add(this.panelIngreso);
        this.jtpOrdenes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cartera29x27.png")));
        this.jtpOrdenes.setScrollOnExpand(true);
        this.jtpOrdenes.setTitle("Datos de Ordenes");
        this.jtpOrdenes.setFont(new Font("Arial", 1, 12));
        this.jtpOrdenes.getContentPane().setLayout(new PercentLayout());
        this.panelMvto.setAutoscrolls(true);
        this.panelMvto.setFont(new Font("Arial", 1, 12));
        this.panelMvto.setPreferredSize(new Dimension(1168, 500));
        GroupLayout panelMvtoLayout = new GroupLayout(this.panelMvto);
        this.panelMvto.setLayout(panelMvtoLayout);
        panelMvtoLayout.setHorizontalGroup(panelMvtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1168, 32767));
        panelMvtoLayout.setVerticalGroup(panelMvtoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 490, 32767));
        this.jtpOrdenes.getContentPane().add(this.panelMvto);
        this.JTF_NRegistro.setFont(new Font("Arial", 1, 12));
        this.JTF_NRegistro.setForeground(Color.red);
        this.JTF_NRegistro.setHorizontalAlignment(0);
        this.JTF_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JBTHuella1.setFont(new Font("Arial", 1, 12));
        this.JBTHuella1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTHuella1.setText("<html><P ALIGN=center>Escaneo Documentos");
        this.JBTHuella1.setToolTipText("Firma de Ingreso");
        this.JBTHuella1.addActionListener(new ActionListener() { // from class: Facturacion.Facturac.10
            public void actionPerformed(ActionEvent evt) {
                Facturac.this.JBTHuella1ActionPerformed(evt);
            }
        });
        GroupLayout jtpUsuarioLayout = new GroupLayout(this.jtpUsuario.getContentPane());
        this.jtpUsuario.getContentPane().setLayout(jtpUsuarioLayout);
        jtpUsuarioLayout.setHorizontalGroup(jtpUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jtpUsuarioLayout.createSequentialGroup().addContainerGap().addComponent(this.JBTRegistroHora, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTRegistroHora1, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnWanglabUser, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnWanglabUser1, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JBTHuella, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnConsolidado, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JBTHuella1, -2, 140, -2).addContainerGap(-1, 32767)).addGroup(jtpUsuarioLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jtpUsuarioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jtpOrdenes, -2, 1196, -2).addComponent(this.jtpIngreso, -2, 1196, -2).addGroup(jtpUsuarioLayout.createSequentialGroup().addComponent(this.panelPersona, -2, 1043, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_NRegistro, -2, 130, -2).addGap(17, 17, 17))).addContainerGap(1135, 32767)));
        jtpUsuarioLayout.setVerticalGroup(jtpUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jtpUsuarioLayout.createSequentialGroup().addContainerGap().addGroup(jtpUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelPersona, -2, 168, -2).addComponent(this.JTF_NRegistro, -2, 57, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jtpUsuarioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jtpUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.btnWanglabUser1, -1, -1, 32767).addComponent(this.btnWanglabUser).addGroup(GroupLayout.Alignment.TRAILING, jtpUsuarioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTRegistroHora1, -2, -1, -2).addComponent(this.JBTRegistroHora, -2, -1, -2)).addComponent(this.JBTHuella, -2, 0, 32767)).addGroup(jtpUsuarioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnConsolidado, -2, -1, -2).addComponent(this.JBTHuella1, -2, 0, 32767))).addGap(18, 18, 18).addComponent(this.jtpIngreso, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jtpOrdenes, -2, 536, 32767).addContainerGap()));
        this.jScrollPane1.setViewportView(this.jtpUsuario);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 1220, -2).addGap(9, 9, 9)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 1119, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtpUsuarioMouseClicked(MouseEvent evt) {
        expansionUsuario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnConsolidadoActionPerformed(ActionEvent evt) {
        this.frmc = new Consolidado((Frame) null, true, this.frmIngreso.getIdIngreso(), Principal.clasefacturacion.frmFacturac.frmIngreso.listConvenio.get(Principal.clasefacturacion.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId().toString(), this, this.frmIngreso.listConvenio.get(this.frmIngreso.cboEmpresa.getSelectedIndex()).getDescuento(), 0, this.frmIngreso.cboEmpresa.getSelectedItem());
        this.frmc.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jtpIngresoMouseClicked(MouseEvent evt) {
        expansionIngreso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (Principal.clasescita != null) {
            if (Principal.clasescita.frmCitaTerapia != null) {
                Principal.clasescita.frmCitaTerapia.setVisible(true);
                Principal.clasescita.frmCitaTerapia.cargarHorarioGrid();
            } else if (Principal.clasescita.frmCita != null) {
                Principal.clasescita.frmCita.setVisible(true);
                Principal.clasescita.frmCita.cargarHorarioGrid();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistroHoraActionPerformed(ActionEvent evt) {
        if (!this.frmPersona.getIdPersona().equals("")) {
            if (this.frmIngreso.cboEmpresa.getSelectedIndex() != -1) {
                if (this.frmIngreso.cboEstrato1.getSelectedIndex() != -1) {
                    if (!this.frmIngreso.txtNombreA.getText().trim().isEmpty()) {
                        if (!this.frmIngreso.txtNombreR.getText().trim().isEmpty()) {
                            if (this.frmIngreso.cboCausaExterna.getSelectedIndex() != -1) {
                                if (this.frmIngreso.JCBEscolaridad.getSelectedIndex() != -1) {
                                    if (this.frmIngreso.JCBOcupaciones.getSelectedIndex() != -1) {
                                        if (this.frmIngreso.JCB_TipoCoberturaPlan.getSelectedIndex() != -1) {
                                            if (this.frmIngreso.JCB_TipoContratacion.getSelectedIndex() != -1) {
                                                if (this.frmIngreso.JCBTipoAfiliado.getSelectedIndex() != -1) {
                                                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                                                        grabado();
                                                        return;
                                                    } else {
                                                        if (this.frmIngreso.cboTipoAtencion.getSelectedIndex() > 0) {
                                                            grabado();
                                                            return;
                                                        }
                                                        JOptionPane.showInternalMessageDialog(this, "El tipo de atención debe ser ugencias", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                        this.frmIngreso.JTPDatosIngreso.setSelectedIndex(0);
                                                        this.frmIngreso.cboTipoAtencion.requestFocus();
                                                        return;
                                                    }
                                                }
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de afiliación", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                                this.frmIngreso.JTPDatosIngreso.setSelectedIndex(1);
                                                this.frmIngreso.JCBTipoAfiliado.requestFocus();
                                                return;
                                            }
                                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de contratación", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                            this.frmIngreso.JTPDatosIngreso.setSelectedIndex(1);
                                            this.frmIngreso.JCB_TipoContratacion.requestFocus();
                                            return;
                                        }
                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de cobeftura", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                        this.frmIngreso.JTPDatosIngreso.setSelectedIndex(1);
                                        this.frmIngreso.JCB_TipoCoberturaPlan.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la ocupación", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                    this.frmIngreso.JTPDatosIngreso.setSelectedIndex(1);
                                    this.frmIngreso.JCBOcupaciones.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la escolaridad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.frmIngreso.JTPDatosIngreso.setSelectedIndex(0);
                                this.frmIngreso.JCBEscolaridad.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la causa externa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.frmIngreso.JTPDatosIngreso.setSelectedIndex(0);
                            this.frmIngreso.cboCausaExterna.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe registrar nombre persona responsable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.frmIngreso.JTPDatosIngreso.setSelectedIndex(2);
                        this.frmIngreso.txtNombreR.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe registrar nombre del acompañante", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.frmIngreso.JTPDatosIngreso.setSelectedIndex(2);
                    this.frmIngreso.txtNombreA.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un estrato", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.frmIngreso.JTPDatosIngreso.setSelectedIndex(0);
                this.frmIngreso.cboEstrato1.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.frmIngreso.JTPDatosIngreso.setSelectedIndex(0);
            this.frmIngreso.cboEmpresa.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.frmPersona.txtHistoria.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameOpened(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistroHora1ActionPerformed(ActionEvent evt) {
        JD_ValidacionDerechoCovenio frmc1 = new JD_ValidacionDerechoCovenio(null, true, this.frmPersona.listaTipoIdentificacion[this.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0], this.frmPersona.txtIdentificacion.getText());
        frmc1.setLocationRelativeTo(this);
        frmc1.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnWanglabUserActionPerformed(ActionEvent evt) {
        grabadoUserWanglab();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnWanglabUser1ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDHistoricoTrazabilidad trazabilidad = new JDHistoricoTrazabilidad(null, true, Long.valueOf(Principal.txtNo.getText()));
            trazabilidad.setLocationRelativeTo(this);
            trazabilidad.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHuellaActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, "xIngreso", Principal.txtNo.getText());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe cargar un Ingreso", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTHuella1ActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            JDSoporte_Escaneado escaneado = new JDSoporte_Escaneado(null, true, Long.valueOf(Principal.txtNo.getText()));
            escaneado.setLocationRelativeTo(this);
            escaneado.setVisible(true);
        }
    }

    private void grabadoUserWanglab() {
        String queryValidation = "SELECT COUNT(`numeroDocumento`) AS Existe FROM `wanglab`.`w_ttercero`\nWHERE(`numeroDocumento`='" + this.frmPersona.getIdentificacion() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        int existe = 0;
        try {
            ResultSet rs = xct.traerRs(queryValidation);
            if (rs.next()) {
                existe = rs.getInt(1);
            }
            rs.close();
            xct.cerrarConexionBd();
            if (existe == 0) {
                System.err.println("" + this.frmPersona.listaTipoIdentificacion[this.frmPersona.cboTipoIdentificacion.getSelectedIndex()][6]);
                int tipoIdentificacion = Integer.parseInt(this.frmPersona.listaTipoIdentificacion[this.frmPersona.cboTipoIdentificacion.getSelectedIndex()][6]);
                String sqlGTercero = "INSERT INTO wanglab.`w_ttercero` (`esActivo`,`fechaActualizacion`,`fechaCreacion`,`usuarioSistema`,`digitoVerificacion`,`email`,`fechaNacimiento`,\n`movil`,`numeroDocumento`,`primerApellido`,`segundoApellido`,`primerNombre`,`segundoNombre`,`razonSocial`,`telefono`,`tipoIdentificacion_id`,`usuarioActualizacion`,\n`usuarioCreacion`,`updatePass`)\nVALUES('1','" + this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdentificacion() + "',NULL,'" + this.frmPersona.txtCorreo.getText() + "','" + this.metodos.formatoAMD1.format(this.frmPersona.cboFechaNacimiento.getDate()) + "','" + this.frmPersona.txtTelefono1.getText() + "','" + this.frmPersona.getIdentificacion() + "',\n'" + this.frmPersona.getApellido1() + "','" + this.frmPersona.getApellido2() + "','" + this.frmPersona.getNombre1() + "','" + this.frmPersona.getNombre2() + "',NULL,'" + this.frmPersona.getTelefono() + "','" + tipoIdentificacion + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','1')";
                String idTercero = xct.ejecutarSQLId(sqlGTercero);
                String sqlGUsuario = "INSERT INTO `wanglab`.`w_tusuario` (`esActivo`,`fechaActualizacion`,`fechaCreacion`,`usuarioSistema`,`contrasena`,`esAdmin`,`esProtegido`,`usuario`,`tercero_id`,\n`usuarioActualizacion`,`usuarioCreacion`,`estado`)\nVALUES('1','" + this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()) + "','" + this.metodos.formatoAMDH24_1.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdentificacion() + "','" + this.metodos.getEncryptedPassword(new String(this.frmPersona.getIdentificacion())) + "',\n'0','0','" + this.frmPersona.getIdentificacion() + "','" + idTercero + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getLogin() + "', 'A')";
                String idUsuario = xct.ejecutarSQLId(sqlGUsuario);
                String sqlGUsuarioGrupo = "INSERT INTO `wanglab`.`w_tusuario_tgrupo`(grupo_id,`usuario_id`)\nVALUES('5','" + idUsuario + "')";
                xct.ejecutarSQL(sqlGUsuarioGrupo);
                xct.cerrarConexionBd();
                JOptionPane.showMessageDialog((Component) null, "Usuario registrado exitosamente en WangLab");
            } else if (existe > 0) {
                JOptionPane.showMessageDialog((Component) null, "Usuario existente en wanglab");
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    /* JADX WARN: Finally extract failed */
    private void grabado() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta Seguro de Guardar", "CONFIRMAR", 0, 1);
        if (n == 0 && !this.xhorallegado) {
            if (this.JTF_NRegistro.getText().isEmpty()) {
                try {
                    if (Principal.informacionGeneralPrincipalDTO.getAplicaAtencionPreferencial().booleanValue()) {
                        JDAtencionesPreferenciales xjdatencion = new JDAtencionesPreferenciales(null, true, this.frmFacturac);
                        xjdatencion.setVisible(true);
                    }
                    ConsultasMySQL xct = new ConsultasMySQL();
                    int xcardinal = 0;
                    ResultSet rs = xct.traerRs("SELECT (MAX(Cardinal)+1) AS cardinal FROM  h_horallegada WHERE (Id_Usuario ='" + this.frmPersona.getIdPersona() + "')");
                    Throwable th = null;
                    try {
                        if (rs.next()) {
                            xcardinal = rs.getInt(1);
                        }
                        if (rs != null) {
                            if (0 != 0) {
                                try {
                                    rs.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                rs.close();
                            }
                        }
                        if (this.frmPersona.getIdPersona().equals("0") || this.frmPersona.getIdPersona() == null) {
                            this.frmPersona.grabar();
                        }
                        xct.cerrarConexionBd();
                        ConsultasMySQL xmt1 = new ConsultasMySQL();
                        String sql1 = "Insert into h_horallegada(Id_Usuario, Cardinal, Fecha_Hora, Id_Empresa,  Id_Estrato, Id_TipoAtencion,  NAcompananate, TelefonoAcomp, NPersonaResp, TelefonoPResp, Id_Parentesco,`Escolaridad` , `CausaExterna` ,`CEspecial` ,`Ocupacion`, Id_Sede, TipoAfiliacion, TipoContratacion, TipoCoberturaPlan, UsuarioS, Fecha) Values('" + this.frmPersona.getIdPersona() + "','" + xcardinal + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.frmIngreso.listConvenio.get(this.frmIngreso.cboEmpresa.getSelectedIndex()).getId() + "','" + this.frmIngreso.xidestrato[this.frmIngreso.cboEstrato1.getSelectedIndex()][0] + "','" + this.frmIngreso.cboTipoAtencion.getPopupTable().getValueAt(this.frmIngreso.cboTipoAtencion.getSelectedIndex(), 0).toString() + "','" + this.frmIngreso.txtNombreA.getText() + "','" + this.frmIngreso.txtTelefonoA.getText() + "','" + this.frmIngreso.txtNombreR.getText() + "','" + this.frmIngreso.txtTelefonoR.getText() + "','" + this.frmIngreso.cboParentescoR.getPopupTable().getValueAt(this.frmIngreso.cboParentescoR.getSelectedIndex(), 0) + "','" + this.frmIngreso.JCBEscolaridad.getSelectedItem().toString() + "','" + this.frmIngreso.cboCausaExterna.getSelectedItem().toString() + "','" + this.frmPersona.JCBCEspecial.getSelectedIndex() + "','" + this.frmIngreso.JCBOcupaciones.getSelectedItem().toString() + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.frmIngreso.JCBTipoAfiliado.getSelectedItem().toString() + "','" + this.frmIngreso.JCB_TipoContratacion.getSelectedItem().toString() + "','" + this.frmIngreso.JCB_TipoCoberturaPlan.getSelectedItem().toString() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "')";
                        System.out.println("consulta ->-> " + sql1);
                        this.JTF_NRegistro.setText(xmt1.ejecutarSQLId(sql1));
                        xmt1.cerrarConexionBd();
                        this.xhorallegado = true;
                        grabadoUserWanglab();
                        return;
                    } catch (Throwable th3) {
                        if (rs != null) {
                            if (0 != 0) {
                                try {
                                    rs.close();
                                } catch (Throwable th4) {
                                    th.addSuppressed(th4);
                                }
                            } else {
                                rs.close();
                            }
                        }
                        throw th3;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Facturac.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Registro ya grabado!!!");
        }
    }

    public String getIdSalidaInventario() {
        return this.idSalidaInventario;
    }

    public void setIdSalidaInventario(String idSalidaInventario) {
        this.idSalidaInventario = idSalidaInventario;
    }
}
