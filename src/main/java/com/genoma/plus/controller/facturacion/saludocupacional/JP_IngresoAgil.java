package com.genoma.plus.controller.facturacion.saludocupacional;

import Acceso.Principal;
import Citas.CitaNP;
import Enfermeria.Atencion;
import Facturacion.JPEventoECat;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.jpa.projection.IConsultarNumeroAutorizacionIngreso;
import com.genoma.plus.jpa.service.IngresoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import lombok.Generated;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/saludocupacional/JP_IngresoAgil.class */
public class JP_IngresoAgil extends JPanel {
    public String[][] lisEmpresa;
    public String[][] xidestrato;
    public String[][] xidTipoAfiliado;
    public String[][] xidTipoContratacion;
    public String[][] xidTipoCobertura;
    private String sql;
    private String ambitoAtencion;
    private String idTipoPlanEmpresa;
    private String frmLlamador;
    private DefaultTableModel modcombos;
    private DefaultTableModel xcombop;
    private ResultSet rs;
    public JIF_FacturacionAgil frmFacturacionAgil;
    private CitaNP frmCitaNP1;
    private Atencion frmAtencion;
    public String[] xidingresos;
    public String[] xidescolaridad;
    public String[] xidocupaciones;
    public String[] xidTipoDocR;
    public String[] xidParAcomp;
    public String[] xidEspecialidad;
    public String[] xIdProfesional;
    public String[] xidTipoDocA;
    public String[] xidCondVict;
    private int xEsNuevaMuestra;
    private JPEventoECat xJPEventoECat;
    private PatologiaCie10DAO patologiaCie10DAO;
    private boolean lleno;
    private String idOrdenes;
    private Integer estadoFacturaOrdenes;
    private Long idFacturaEvento;
    private Long idFacturaCapita;
    private Long idLiquidacion;
    private Long idAtencion;
    private ButtonGroup JBGTipoEstrato;
    public JTableComboBox JCBEscolaridad;
    public JCheckBox JCH_AplicaFiltroConvenio;
    private JPanel JPIIngreso;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    public JRadioButton btnCModeradora;
    public JRadioButton btnCopago;
    public JTableComboBox cboContrato;
    public JComboBox cboEmpresa;
    public JComboBox cboEspecialidad;
    public JComboBox cboEstrato1;
    public JComboBox cboProfesional;
    public JTableComboBox cboTipoAtencion;
    private JPanel jPanel1;
    public JDateChooser txtFecha;
    public JFormattedTextField txtHora;
    public JFormattedTextField txtNoAutorizacion;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public int xcopago = 0;
    private String idIngreso = "";
    public int cboLleno = 0;
    public int xlimiteinf = 0;
    public int xlimitesup = 0;
    public int xmovi = 0;
    public int sw = 0;
    private boolean xlleno = false;
    private long xidatencion = 0;
    private int xCondiVict = 0;
    private boolean xlleno2 = false;
    public String xTratamiento = "0";
    private final IngresoService ingresoService = (IngresoService) Principal.contexto.getBean(IngresoService.class);

    @Generated
    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    @Generated
    public void setConsultas(ConsultasMySQL consultas) {
        this.consultas = consultas;
    }

    @Generated
    public void setXcopago(int xcopago) {
        this.xcopago = xcopago;
    }

    @Generated
    public void setLisEmpresa(String[][] lisEmpresa) {
        this.lisEmpresa = lisEmpresa;
    }

    @Generated
    public void setXidestrato(String[][] xidestrato) {
        this.xidestrato = xidestrato;
    }

    @Generated
    public void setXidTipoAfiliado(String[][] xidTipoAfiliado) {
        this.xidTipoAfiliado = xidTipoAfiliado;
    }

    @Generated
    public void setXidTipoContratacion(String[][] xidTipoContratacion) {
        this.xidTipoContratacion = xidTipoContratacion;
    }

    @Generated
    public void setXidTipoCobertura(String[][] xidTipoCobertura) {
        this.xidTipoCobertura = xidTipoCobertura;
    }

    @Generated
    public void setSql(String sql) {
        this.sql = sql;
    }

    @Generated
    public void setIdTipoPlanEmpresa(String idTipoPlanEmpresa) {
        this.idTipoPlanEmpresa = idTipoPlanEmpresa;
    }

    @Generated
    public void setFrmLlamador(String frmLlamador) {
        this.frmLlamador = frmLlamador;
    }

    @Generated
    public void setModcombos(DefaultTableModel modcombos) {
        this.modcombos = modcombos;
    }

    @Generated
    public void setXcombop(DefaultTableModel xcombop) {
        this.xcombop = xcombop;
    }

    @Generated
    public void setCboLleno(int cboLleno) {
        this.cboLleno = cboLleno;
    }

    @Generated
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    @Generated
    public void setFrmFacturacionAgil(JIF_FacturacionAgil frmFacturacionAgil) {
        this.frmFacturacionAgil = frmFacturacionAgil;
    }

    @Generated
    public void setFrmCitaNP1(CitaNP frmCitaNP1) {
        this.frmCitaNP1 = frmCitaNP1;
    }

    @Generated
    public void setFrmAtencion(Atencion frmAtencion) {
        this.frmAtencion = frmAtencion;
    }

    @Generated
    public void setXidingresos(String[] xidingresos) {
        this.xidingresos = xidingresos;
    }

    @Generated
    public void setXidescolaridad(String[] xidescolaridad) {
        this.xidescolaridad = xidescolaridad;
    }

    @Generated
    public void setXidocupaciones(String[] xidocupaciones) {
        this.xidocupaciones = xidocupaciones;
    }

    @Generated
    public void setXidTipoDocR(String[] xidTipoDocR) {
        this.xidTipoDocR = xidTipoDocR;
    }

    @Generated
    public void setXidParAcomp(String[] xidParAcomp) {
        this.xidParAcomp = xidParAcomp;
    }

    @Generated
    public void setXidEspecialidad(String[] xidEspecialidad) {
        this.xidEspecialidad = xidEspecialidad;
    }

    @Generated
    public void setXIdProfesional(String[] xIdProfesional) {
        this.xIdProfesional = xIdProfesional;
    }

    @Generated
    public void setXidTipoDocA(String[] xidTipoDocA) {
        this.xidTipoDocA = xidTipoDocA;
    }

    @Generated
    public void setXlimiteinf(int xlimiteinf) {
        this.xlimiteinf = xlimiteinf;
    }

    @Generated
    public void setXlimitesup(int xlimitesup) {
        this.xlimitesup = xlimitesup;
    }

    @Generated
    public void setXmovi(int xmovi) {
        this.xmovi = xmovi;
    }

    @Generated
    public void setSw(int sw) {
        this.sw = sw;
    }

    @Generated
    public void setXlleno(boolean xlleno) {
        this.xlleno = xlleno;
    }

    @Generated
    public void setXidCondVict(String[] xidCondVict) {
        this.xidCondVict = xidCondVict;
    }

    @Generated
    public void setXCondiVict(int xCondiVict) {
        this.xCondiVict = xCondiVict;
    }

    @Generated
    public void setXEsNuevaMuestra(int xEsNuevaMuestra) {
        this.xEsNuevaMuestra = xEsNuevaMuestra;
    }

    @Generated
    public void setXlleno2(boolean xlleno2) {
        this.xlleno2 = xlleno2;
    }

    @Generated
    public void setXJPEventoECat(JPEventoECat xJPEventoECat) {
        this.xJPEventoECat = xJPEventoECat;
    }

    @Generated
    public void setXTratamiento(String xTratamiento) {
        this.xTratamiento = xTratamiento;
    }

    @Generated
    public void setPatologiaCie10DAO(PatologiaCie10DAO patologiaCie10DAO) {
        this.patologiaCie10DAO = patologiaCie10DAO;
    }

    @Generated
    public void setLleno(boolean lleno) {
        this.lleno = lleno;
    }

    @Generated
    public void setIdOrdenes(String idOrdenes) {
        this.idOrdenes = idOrdenes;
    }

    @Generated
    public void setEstadoFacturaOrdenes(Integer estadoFacturaOrdenes) {
        this.estadoFacturaOrdenes = estadoFacturaOrdenes;
    }

    @Generated
    public void setIdFacturaEvento(Long idFacturaEvento) {
        this.idFacturaEvento = idFacturaEvento;
    }

    @Generated
    public void setIdFacturaCapita(Long idFacturaCapita) {
        this.idFacturaCapita = idFacturaCapita;
    }

    @Generated
    public void setIdLiquidacion(Long idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
    }

    @Generated
    public void setIdAtencion(Long idAtencion) {
        this.idAtencion = idAtencion;
    }

    @Generated
    public void setJBGTipoEstrato(ButtonGroup JBGTipoEstrato) {
        this.JBGTipoEstrato = JBGTipoEstrato;
    }

    @Generated
    public void setJCBEscolaridad(JTableComboBox JCBEscolaridad) {
        this.JCBEscolaridad = JCBEscolaridad;
    }

    @Generated
    public void setJCH_AplicaFiltroConvenio(JCheckBox JCH_AplicaFiltroConvenio) {
        this.JCH_AplicaFiltroConvenio = JCH_AplicaFiltroConvenio;
    }

    @Generated
    public void setJPIIngreso(JPanel JPIIngreso) {
        this.JPIIngreso = JPIIngreso;
    }

    @Generated
    public void setJSPObservacion(JScrollPane JSPObservacion) {
        this.JSPObservacion = JSPObservacion;
    }

    @Generated
    public void setJTAObservacion(JTextArea JTAObservacion) {
        this.JTAObservacion = JTAObservacion;
    }

    @Generated
    public void setBtnCModeradora(JRadioButton btnCModeradora) {
        this.btnCModeradora = btnCModeradora;
    }

    @Generated
    public void setBtnCopago(JRadioButton btnCopago) {
        this.btnCopago = btnCopago;
    }

    @Generated
    public void setCboContrato(JTableComboBox cboContrato) {
        this.cboContrato = cboContrato;
    }

    @Generated
    public void setCboEmpresa(JComboBox cboEmpresa) {
        this.cboEmpresa = cboEmpresa;
    }

    @Generated
    public void setCboEspecialidad(JComboBox cboEspecialidad) {
        this.cboEspecialidad = cboEspecialidad;
    }

    @Generated
    public void setCboEstrato1(JComboBox cboEstrato1) {
        this.cboEstrato1 = cboEstrato1;
    }

    @Generated
    public void setCboProfesional(JComboBox cboProfesional) {
        this.cboProfesional = cboProfesional;
    }

    @Generated
    public void setCboTipoAtencion(JTableComboBox cboTipoAtencion) {
        this.cboTipoAtencion = cboTipoAtencion;
    }

    @Generated
    public void setJPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    @Generated
    public void setTxtFecha(JDateChooser txtFecha) {
        this.txtFecha = txtFecha;
    }

    @Generated
    public void setTxtHora(JFormattedTextField txtHora) {
        this.txtHora = txtHora;
    }

    @Generated
    public void setTxtNoAutorizacion(JFormattedTextField txtNoAutorizacion) {
        this.txtNoAutorizacion = txtNoAutorizacion;
    }

    @Generated
    public Metodos getMetodos() {
        return this.metodos;
    }

    @Generated
    public ConsultasMySQL getConsultas() {
        return this.consultas;
    }

    @Generated
    public int getXcopago() {
        return this.xcopago;
    }

    @Generated
    public String[][] getLisEmpresa() {
        return this.lisEmpresa;
    }

    @Generated
    public String[][] getXidestrato() {
        return this.xidestrato;
    }

    @Generated
    public String[][] getXidTipoAfiliado() {
        return this.xidTipoAfiliado;
    }

    @Generated
    public String[][] getXidTipoContratacion() {
        return this.xidTipoContratacion;
    }

    @Generated
    public String[][] getXidTipoCobertura() {
        return this.xidTipoCobertura;
    }

    @Generated
    public String getSql() {
        return this.sql;
    }

    @Generated
    public String getFrmLlamador() {
        return this.frmLlamador;
    }

    @Generated
    public DefaultTableModel getModcombos() {
        return this.modcombos;
    }

    @Generated
    public DefaultTableModel getXcombop() {
        return this.xcombop;
    }

    @Generated
    public int getCboLleno() {
        return this.cboLleno;
    }

    @Generated
    public ResultSet getRs() {
        return this.rs;
    }

    @Generated
    public JIF_FacturacionAgil getFrmFacturacionAgil() {
        return this.frmFacturacionAgil;
    }

    @Generated
    public CitaNP getFrmCitaNP1() {
        return this.frmCitaNP1;
    }

    @Generated
    public Atencion getFrmAtencion() {
        return this.frmAtencion;
    }

    @Generated
    public String[] getXidingresos() {
        return this.xidingresos;
    }

    @Generated
    public String[] getXidescolaridad() {
        return this.xidescolaridad;
    }

    @Generated
    public String[] getXidocupaciones() {
        return this.xidocupaciones;
    }

    @Generated
    public String[] getXidTipoDocR() {
        return this.xidTipoDocR;
    }

    @Generated
    public String[] getXidParAcomp() {
        return this.xidParAcomp;
    }

    @Generated
    public String[] getXidEspecialidad() {
        return this.xidEspecialidad;
    }

    @Generated
    public String[] getXIdProfesional() {
        return this.xIdProfesional;
    }

    @Generated
    public String[] getXidTipoDocA() {
        return this.xidTipoDocA;
    }

    @Generated
    public int getXlimiteinf() {
        return this.xlimiteinf;
    }

    @Generated
    public int getXlimitesup() {
        return this.xlimitesup;
    }

    @Generated
    public int getXmovi() {
        return this.xmovi;
    }

    @Generated
    public int getSw() {
        return this.sw;
    }

    @Generated
    public boolean isXlleno() {
        return this.xlleno;
    }

    @Generated
    public String[] getXidCondVict() {
        return this.xidCondVict;
    }

    @Generated
    public int getXCondiVict() {
        return this.xCondiVict;
    }

    @Generated
    public int getXEsNuevaMuestra() {
        return this.xEsNuevaMuestra;
    }

    @Generated
    public boolean isXlleno2() {
        return this.xlleno2;
    }

    @Generated
    public JPEventoECat getXJPEventoECat() {
        return this.xJPEventoECat;
    }

    @Generated
    public String getXTratamiento() {
        return this.xTratamiento;
    }

    @Generated
    public PatologiaCie10DAO getPatologiaCie10DAO() {
        return this.patologiaCie10DAO;
    }

    @Generated
    public boolean isLleno() {
        return this.lleno;
    }

    @Generated
    public String getIdOrdenes() {
        return this.idOrdenes;
    }

    @Generated
    public Integer getEstadoFacturaOrdenes() {
        return this.estadoFacturaOrdenes;
    }

    @Generated
    public Long getIdFacturaEvento() {
        return this.idFacturaEvento;
    }

    @Generated
    public Long getIdFacturaCapita() {
        return this.idFacturaCapita;
    }

    @Generated
    public Long getIdLiquidacion() {
        return this.idLiquidacion;
    }

    @Generated
    public Long getIdAtencion() {
        return this.idAtencion;
    }

    @Generated
    public IngresoService getIngresoService() {
        return this.ingresoService;
    }

    public JP_IngresoAgil(JInternalFrame frmI, String llamador, String ambitoAtencion) {
        initComponents();
        realizarCasting(frmI);
        springStart();
        this.frmLlamador = llamador;
        this.ambitoAtencion = ambitoAtencion;
        nuevo();
    }

    private void springStart() {
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("patologiaCie10DAOImpl");
    }

    public String getIdEmpresa() {
        return this.lisEmpresa.length > 0 ? this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][0] : "0";
    }

    public String getIdTipoPlanEmpresa() {
        return this.idTipoPlanEmpresa;
    }

    public String getIdIngreso() {
        return this.idIngreso;
    }

    public String getTipoContratacion() {
        return this.lisEmpresa.length > 0 ? this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][17] : "0";
    }

    public String getTipoCobertura() {
        return this.lisEmpresa.length > 0 ? this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][18] : "0";
    }

    public String getIdProfesional() {
        if (this.cboProfesional.getSelectedIndex() > -1) {
            return this.xIdProfesional[this.cboProfesional.getSelectedIndex()];
        }
        return "0";
    }

    public String getNbreProfesional() {
        if (this.cboProfesional.getSelectedIndex() > -1) {
            return this.cboProfesional.getSelectedItem().toString();
        }
        return "";
    }

    public String getIdEspecialidad() {
        if (this.cboEspecialidad.getSelectedIndex() > -1) {
            return this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()];
        }
        return "0";
    }

    public String getAmbitoAtencion() {
        return this.ambitoAtencion;
    }

    public int getValidarComponentes() {
        int retorno = 0;
        if (this.txtFecha.getDate() == null) {
            this.metodos.mostrarMensaje("Por Favor seleccione una Fecha.");
            this.txtFecha.requestFocus();
        } else if (this.txtHora.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Hora de Ingreso.");
            this.txtHora.requestFocus();
        } else if (this.cboEmpresa.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Empresa a quien se Facturará.");
            this.cboEmpresa.requestFocus();
        } else if (this.cboEstrato1.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Estrato.");
            this.cboEstrato1.requestFocus();
        } else if (this.cboEspecialidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione una Especialidad.");
            this.cboEspecialidad.requestFocus();
        } else if (this.cboProfesional.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Profesional.");
            this.cboProfesional.requestFocus();
        } else if (this.cboContrato.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Contrato para la Empresa a Facturar.");
            this.cboContrato.requestFocus();
        } else if (this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][16].equals("1")) {
            if (this.txtNoAutorizacion.getText().isEmpty()) {
                this.metodos.mostrarMensaje("Debe digitar numero de autorización");
                this.txtNoAutorizacion.requestFocus();
            } else {
                retorno = 1;
            }
        }
        if (this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][16].equals("1")) {
            if (this.txtNoAutorizacion.getText().isEmpty()) {
                this.metodos.mostrarMensaje("Debe digitar numero de autorización");
                this.txtNoAutorizacion.requestFocus();
            } else {
                retorno = 1;
            }
        } else if (!Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") && !Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") && !Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") && Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            retorno = 1;
        } else {
            retorno = 1;
        }
        return retorno;
    }

    public void setIdIngreso(String IdIngreso) {
        this.idIngreso = IdIngreso;
    }

    public void setAmbitoAtencion(String id) {
        this.ambitoAtencion = id;
    }

    public void setCargarTitulos(String idIngreso, String Fecha, int Estado) {
        Principal.lblNo.setText("No.");
        Principal.txtNo.setText(idIngreso);
        Principal.lblFecha.setText("Fecha");
        Principal.txtFecha.setText(Fecha);
        if (Estado == 0) {
            Principal.txtEstado.setText("ACTIVO");
        } else {
            Principal.txtEstado.setText("ANULADO");
        }
    }

    public long getXidatencion() {
        return this.xidatencion;
    }

    public void setXidatencion(long xidatencion) {
        this.xidatencion = xidatencion;
    }

    private void mConsultarNAutorizacion() {
        if (this.cboEmpresa.getSelectedIndex() != -1) {
            this.txtNoAutorizacion.setText(this.txtNoAutorizacion.getText().trim());
            if (this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][16].equals("1")) {
                new ArrayList();
                List<IConsultarNumeroAutorizacionIngreso> autorizacionIngresos = this.ingresoService.consultarNumeroAutorizacionPorIngreso(Long.valueOf(this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][0]), this.txtNoAutorizacion.getText(), Long.valueOf(this.idIngreso));
                if (!autorizacionIngresos.isEmpty()) {
                    String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Nº de autorización ya asaignado al ingreso Nº : " + autorizacionIngresos.get(0).getIdIngreso() + ",  con fecha : " + autorizacionIngresos.get(0).getFechaIngreso() + ",  usuario : " + autorizacionIngresos.get(0).getNombreUsuario() + " ;</p><font face='Arial' color='red' size=4>Favor verificar.";
                    JOptionPane.showInternalMessageDialog(this, xmensaje, "CONTROL NÚMERO DE AUTORIZACIONES", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    this.txtNoAutorizacion.setText("");
                }
            }
        }
    }

    public void anular(String idMotivo, String Observacion) {
        if (getIdAtencion().longValue() == 0) {
            this.sql = "UPDATE ingreso SET  Estado =1, `Id_MotivoAnulacion`='" + idMotivo + "' , `Fecha_Anulacion`=now() , `Detalle_Anulacion`='" + Observacion + "' , `Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "'  WHERE (Id='" + Principal.txtNo.getText() + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE o_hc_tratamiento_procedimiento  SET Id_Ingreso=0 WHERE (Id_Ingreso='" + Principal.txtNo.getText() + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.sql = "UPDATE c_citas SET `Asistida`=0, `Id_ingreso`=0 WHERE `Id_ingreso`='" + Principal.txtNo.getText() + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            Principal.txtEstado.setText("ANULADO");
        }
    }

    public void modificar(String idIngreso) {
        this.sql = "UPDATE ingreso SET HoraIngreso='" + this.txtHora.getText() + "',Id_EmpresaContxConv='" + this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][0] + "',esCapitado='" + this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][2] + "',SiCopago=" + this.xcopago + ",Id_Sede=" + Principal.sedeUsuarioSeleccionadaDTO.getId() + ",Id_Estrato=" + this.xidestrato[this.cboEstrato1.getSelectedIndex()][0] + ",Id_Profesional=" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + ",Id_TipoAtencion=" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + ",DxIngreso='0000'Id_Contrato=" + this.cboContrato.getPopupTable().getValueAt(this.cboContrato.getSelectedIndex(), 0) + ",NoAutorizacion='" + this.txtNoAutorizacion.getText() + "',EsAtencion='1'Observacion='" + this.JTAObservacion.getText() + "',Fecha='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void cambioEmpresa() {
        if (this.cboEmpresa.getSelectedIndex() > -1 && this.cboLleno == 1) {
            llenarCboDEmpresa();
            mLlenarComboEstrado();
            mLlenarComboTipoAfiliado();
            if (this.frmLlamador.equals("FacturaA")) {
                this.cboEmpresa.getSelectedIndex();
                System.out.println("nFIla" + this.lisEmpresa.length);
            }
            if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                this.cboEstrato1.setSelectedItem("ESPECIAL");
            }
        }
    }

    public void llevarComboConvenio() {
    }

    public final void cargarCombos() {
        this.cboLleno = 0;
        llevarComboConvenio();
        ConsultasMySQL xctx = new ConsultasMySQL();
        this.cboEspecialidad.removeAllItems();
        this.sql = "SELECT  g_especialidad.Id ,  g_especialidad.Nbre FROM g_profesionalespecial  INNER JOIN  g_especialidad ON ( g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE (g_especialidad.Estado =0 AND g_profesionalespecial.Estado =0) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC";
        this.xidEspecialidad = xctx.llenarCombo(this.sql, this.xidEspecialidad, this.cboEspecialidad);
        this.cboEspecialidad.setSelectedIndex(-1);
        this.cboProfesional.removeAllItems();
        xctx.cerrarConexionBd();
        this.consultas.cerrarConexionBd();
        this.sql = "SELECT g_tipoatencion.Id, g_tipoatencion.Nbre as Tipo_Atencion, g_tipoambito.Nbre as Ambito, g_tipoatencion.GenHosp as T FROM g_tipoatencion INNER JOIN g_tipoambito ON (g_tipoatencion.Id_TipoAmbito = g_tipoambito.Id) where Estado=0 order by Tipo_Atencion";
        this.consultas.llenarComboTabla(this.sql, this.cboTipoAtencion, this.modcombos, 1);
        this.cboTipoAtencion.setSelectedIndex(0);
        this.consultas.cerrarConexionBd();
        this.consultas.llenarComboTabla("SELECT Id , UCASE(Nbre) FROM g_nivelestudio WHERE (Estado =0) ORDER BY Nbre ASC;", this.JCBEscolaridad, this.modcombos, 1);
        this.JCBEscolaridad.setSelectedItem("Ninguno");
        this.consultas.cerrarConexionBd();
        this.cboLleno = 1;
        this.cboEmpresa.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.xlleno = true;
    }

    private void cargarCboProfesional() {
        if (this.cboEspecialidad.getSelectedIndex() > -1 && this.xlleno) {
            ConsultasMySQL xctr = new ConsultasMySQL();
            this.cboProfesional.removeAllItems();
            this.sql = "SELECT w_profesional.Id_Persona, w_profesional.NProfesional FROM g_profesional INNER JOIN w_profesional   ON (g_profesional.Id_Persona = w_profesional.Id_Persona) WHERE (g_profesional.P_Ips =1 AND g_profesional.Estado =0 AND w_profesional.IdEspecialidad ='" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "') ORDER BY w_profesional.NProfesional ASC ";
            this.xIdProfesional = xctr.llenarCombo(this.sql, this.xIdProfesional, this.cboProfesional);
            xctr.cerrarConexionBd();
            if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                this.cboProfesional.setSelectedItem("NO ASIGNADO");
            }
        }
    }

    private void cambioCboEspecialidad() {
        if (this.frmLlamador.equals("FacturaA")) {
            this.cboProfesional.removeAllItems();
            cargarCboProfesional();
        }
    }

    private void cambioCboProfesional() {
        if (!this.frmLlamador.equals("FacturaA") || this.cboProfesional.getSelectedIndex() > -1) {
        }
    }

    public void mCargarDatosAdicionales() {
    }

    public void cargarIngreso(String idIngreso) {
        this.sql = "SELECT ingreso.Id, ingreso.FechaIngreso, ingreso.HoraIngreso, f_empresacontxconvenio.Nbre AS Empresa, ingreso.SiCopago, f_estrato.Nbre AS Estrato, g_origenadmision.Nbre AS OrigenAdmision, g_especialidad.Nbre AS Especialidad, w_profesional.NProfesional AS Profesional, g_tipoatencion.Nbre AS TipoAtencion, f_unidadcama.Nbre AS Pabellon, f_camas.Nbre AS Cama, ingreso.NoPoliza AS Poliza, ingreso.NoAutorizacion AS Autorizacion, g_contratos.Nbre_Contrato AS Contrato, ingreso.NAcompanante, ingreso.TelefonoAcomp, ingreso.NPersonaResp, ingreso.TelefonoPResp, g_parentesco.Nbre AS Parestesco, ingreso.Estado , UCASE(g_nivelestudio.Nbre), g_ocupacion.Nbre Ocupaciones, `g_causaexterna`.`Nbre` AS causa , `a_condvictima`.`Nbre` AS CondVict, ingreso.ParentezcoAcomp, ingreso.TipDoc, ingreso.NoDocumento, ingreso.DxIngreso, ingreso.TipoDocA , ingreso.NoDocA, ingreso.Observacion, ingreso.NMuestra,  ifnull(f_liquidacion.Id,0) idLiquidacion,\nifnull(f_factura_capita.No_FacturaCapita,0) numeroFacturaCapita,\nifnull(IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`),0) numeroFacturaEvento, \n(ifnull(f_factura_capita.EstaArmada,0)+ifnull(f_factura_evento.EstaArmada,0)) estadoArmado,\nGROUP_CONCAT(f_ordenes.Id SEPARATOR ',') idOrdenes, \n-- ifnull(h_atencion.Id,0) idAtencion\n IF(IFNULL(h_atencion.Id,0)<>0,IF(h_atencion.Codigo_Dxp=''||h_atencion.Codigo_Dxp IS NULL,0,h_atencion.Id),h_atencion.Id) idAtencion, g_tipoafiliado.Nbre TipoAfiliado, g_tipo_contratacion.nombre idTipoContratacion, f_tipo_cobertura_plan.nombre idTipoCobertura\nFROM ingreso INNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_estrato ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN g_causaexterna ON (ingreso.Id_CausaExterna = g_causaexterna.Id) INNER JOIN g_contratos ON (ingreso.Id_Contrato = g_contratos.Id) INNER JOIN g_origenadmision ON (ingreso.Id_OrigenAdmision = g_origenadmision.Id) INNER JOIN w_profesional ON (ingreso.Id_Profesional = w_profesional.Id_Persona)  AND (w_profesional.`IdEspecialidad`=ingreso.`Id_Especialidad`) INNER JOIN g_especialidad ON (ingreso.Id_Especialidad = g_especialidad.Id)  INNER JOIN g_ocupacion ON (ingreso.Id_Ocupacion = g_ocupacion.Id) INNER JOIN g_nivelestudio ON (ingreso.Id_NivelEstudio = g_nivelestudio.Id) INNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) LEFT JOIN f_camas ON (ingreso.Cama = f_camas.Id) INNER JOIN g_parentesco ON (ingreso.Id_Parentesco = g_parentesco.Id) LEFT JOIN f_unidadcama ON (f_camas.Id_UnidadCamas = f_unidadcama.Id) LEFT JOIN `a_condvictima`  ON (`ingreso`.`Id_CondVict` = `a_condvictima`.`Id`)  left join f_liquidacion on (f_liquidacion.Id_Ingreso=ingreso.Id) and (f_liquidacion.Estado=0)\nleft join f_factura_capita on (f_liquidacion.Id=f_factura_capita.Id_Liquidacion) and (f_factura_capita.Estado=0)\nleft join f_factura_evento on (f_liquidacion.Id=f_factura_evento.Id_Liquidacion) and (f_factura_evento.Estado=0)\nleft join f_ordenes on (f_ordenes.Id_Ingreso=ingreso.Id) and (f_ordenes.Estado=0) \n left join h_atencion on (h_atencion.Id_Ingreso=ingreso.Id) and (h_atencion.Codigo_Dxp<>'' || h_atencion.Codigo_Dxp<>'0000')\n left JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`)\nINNER JOIN g_tipoafiliado ON (g_tipoafiliado.Id = ingreso.idTipoAfiliacion)\nINNER JOIN g_tipo_contratacion ON (ingreso.idTipoContratacion = g_tipo_contratacion.id)\nINNER JOIN f_tipo_cobertura_plan ON (ingreso.idTipoCoberturaPlan = f_tipo_cobertura_plan.id)\nWHERE (ingreso.Id =" + idIngreso + ")";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(this.sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.txtFecha.setDate(xrs.getDate(2));
                this.txtHora.setText(xrs.getString(3));
                this.cboEmpresa.setSelectedItem(xrs.getString(4));
                if (xrs.getInt(5) == 0) {
                    this.btnCModeradora.setSelected(true);
                    btnCModeradoraActionPerformed(null);
                } else {
                    this.btnCopago.setSelected(true);
                    btnCopagoActionPerformed(null);
                }
                this.cboEstrato1.setSelectedItem(xrs.getString(6));
                this.cboTipoAtencion.setSelectedItem(xrs.getString(10));
                this.cboLleno = 0;
                this.cboEspecialidad.setSelectedItem(xrs.getString(8));
                this.cboLleno = 1;
                this.cboProfesional.setSelectedItem(xrs.getString(9));
                this.txtNoAutorizacion.setText(xrs.getString(14));
                this.cboContrato.setSelectedItem(xrs.getString(15));
                setIdIngreso(idIngreso);
                this.JCBEscolaridad.setSelectedItem(xrs.getString(22));
                this.xEsNuevaMuestra = xrs.getInt("NMuestra");
                setCargarTitulos(idIngreso, this.metodos.formatoDMA.format((Date) xrs.getDate(2)), xrs.getInt(21));
                this.JTAObservacion.setText(xrs.getString("Observacion"));
                this.xlleno2 = true;
                setIdLiquidacion(Long.valueOf(xrs.getLong("idLiquidacion")));
                setIdFacturaCapita(Long.valueOf(xrs.getLong("numeroFacturaCapita")));
                setIdFacturaEvento(Long.valueOf(xrs.getLong("numeroFacturaEvento")));
                setEstadoFacturaOrdenes(Integer.valueOf(xrs.getInt("estadoArmado")));
                setIdOrdenes(xrs.getString("idOrdenes"));
                setIdAtencion(Long.valueOf(xrs.getLong("idAtencion")));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_IngresoAgil.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar(String idPersona) {
    }

    public void mActualizaIngresoenVacunas() {
    }

    public void mActualizaIngresoenCitas() {
        String sql = "SELECT `h_atencion`.`Id_Ingreso`, h_atencion.`Id`  FROM `o_hc_tratamiento` INNER JOIN `h_atencion`  ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`o_hc_tratamiento`.`Id` ='" + this.xTratamiento + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                String xIngreso = xrs.getString("Id_Ingreso");
                String sql2 = "UPDATE c_citas SET Id_ingreso='" + xIngreso + "' , Id_ingresoReal='" + getIdIngreso() + "' WHERE Id_ingreso='" + getIdIngreso() + "'";
                xct.ejecutarSQL(sql2);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_IngresoAgil.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mActualizarIngreso() {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.sql = "update ingreso set Id_EmpresaContxConv='" + this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][0] + "', esCapitado='" + this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][2] + "', SiCopago='" + this.xcopago + "', Id_Estrato='" + this.xidestrato[this.cboEstrato1.getSelectedIndex()][0] + "', Id_OrigenAdmision='2', Id_CausaExterna='15', Id_Especialidad='" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "', Id_Profesional='" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + "', Id_TipoAtencion ='" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + "', Id_NivelEstudio ='" + this.JCBEscolaridad.getPopupTable().getValueAt(this.JCBEscolaridad.getSelectedIndex(), 0).toString() + "', NoPoliza =' ', NoAutorizacion ='" + this.txtNoAutorizacion.getText() + "', NMuestra ='" + this.xEsNuevaMuestra + "', Id_Contrato='" + this.cboContrato.getPopupTable().getValueAt(this.cboContrato.getSelectedIndex(), 0) + "', Id_Ocupacion='9998', SO_Cargo='', SO_Supervisor='', SO_SEG='', SO_Jornada='', HorasTrabajadas='', SO_Arl='', SO_Grupo='', SO_Lateralidad='', NoHijos='', ClaseSE='', SO_UNegocio='', SO_FechaIngreso='" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "', DxIngreso='', Id_CondVict='" + this.xCondiVict + "', TipoDocA=1'', NoDocA='', Observacion='" + this.JTAObservacion.getText() + "', idTipoAfiliacion='1', idTipoContratacion='1', idTipoCoberturaPlan='1' where Id='" + Principal.txtNo.getText() + "'";
        xct.ejecutarSQL(this.sql);
        xct.cerrarConexionBd();
        this.sql = "UPDATE `a_eventoecat_paciente` SET a_eventoecat_paciente.`Id_condvictima`='" + this.xCondiVict + "' WHERE a_eventoecat_paciente.`Id_Ingreso`='" + Principal.txtNo.getText() + "'";
        xct.ejecutarSQL(this.sql);
        xct.cerrarConexionBd();
    }

    public void mActualizarIngreso1() {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.sql = "update ingreso set Id_OrigenAdmision='2', Id_CausaExterna='15', Id_TipoAtencion ='" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + "', Id_NivelEstudio ='" + this.JCBEscolaridad.getPopupTable().getValueAt(this.JCBEscolaridad.getSelectedIndex(), 0).toString() + "', SiCopago ='" + this.xcopago + "', DxIngreso ='', Id_Estrato ='" + this.xidestrato[this.cboEstrato1.getSelectedIndex()][0] + "', NoPoliza ='', NoAutorizacion ='" + this.txtNoAutorizacion.getText() + "', Id_Contrato='" + this.cboContrato.getPopupTable().getValueAt(this.cboContrato.getSelectedIndex(), 0) + "', Id_Ocupacion='9998', SO_Cargo='', SO_Supervisor='', SO_SEG='', SO_Jornada='', HorasTrabajadas='', SO_Arl='', SO_Grupo='', SO_Lateralidad='', SO_UNegocio='', NoHijos='', ClaseSE='', Id_CondVict='" + this.xCondiVict + "', TipoDocA= 1'', NoDocA='', SO_FechaIngreso='" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "', Observacion='" + this.JTAObservacion.getText() + "', idTipoAfiliacion='1', idTipoContratacion='1', idTipoCoberturaPlan='1' where Id='" + Principal.txtNo.getText() + "'";
        xct.ejecutarSQL(this.sql);
        xct.cerrarConexionBd();
    }

    private void mGrabarValidacion() {
    }

    private void mActualizarCamposUsuario(String xetnia, String xneducativo, String xocupacion, String xemail, String xpersona) {
        String xsql = "update `g_usuario` set `Etnia`='" + xetnia + "', `NEducativo`='" + xneducativo + "', `Ocupacion`='" + xocupacion + "', `Email`='" + xemail + "' where `Id_persona`='" + xpersona + "'";
        ConsultasMySQL xct = new ConsultasMySQL();
        xct.ejecutarSQL(xsql);
        xct.cerrarConexionBd();
    }

    public void mGrabarAtencion() {
        this.sql = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + getIdIngreso() + "','1','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.txtHora.getValue()) + "','','','1','','','','','" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + "','" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        setXidatencion(Long.valueOf(this.consultas.ejecutarSQLId(this.sql)).longValue());
        this.consultas.cerrarConexionBd();
        this.sql = "update ingreso set Id_Atencion='" + getXidatencion() + "' where Id='" + getIdIngreso() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void llenarCboDEmpresa() {
        if (this.cboEmpresa.getSelectedIndex() > -1 && this.cboLleno == 1) {
            this.sql = "SELECT Id, Nbre_Contrato as Contrato, No_Contrato, FechaInicio, FechaFin, ValorActual, UsuariosAtendidos FROM g_contratos WHERE (Estado =0 AND Id_EmpresaContConvenio ='" + getIdEmpresa() + "') order by Nbre_Contrato";
            this.consultas.llenarComboTabla(this.sql, this.cboContrato, this.modcombos, 1);
            this.consultas.cerrarConexionBd();
            if (this.cboContrato.getPopupTable().getRowCount() == 1) {
                this.cboContrato.setSelectedIndex(0);
            }
        }
    }

    public void mLlenarComboEstrado() {
        if (this.cboEmpresa.getSelectedIndex() != -1 && this.cboLleno == 1) {
            this.cboEstrato1.removeAllItems();
            this.sql = "SELECT f_estrato.Id, f_estrato.Nbre as Estrato, f_estratoxemprcontconv.PorcSubsidio as Subsidio,f_estratoxemprcontconv.ValorMaximo as Valor_Maximo, f_estratoxemprcontconv.Editable FROM f_estratoxemprcontconv INNER JOIN f_estrato  ON (f_estratoxemprcontconv.Id_Estrato = f_estrato.Id) WHERE (f_estratoxemprcontconv.Estado =0 AND f_estratoxemprcontconv.Copago ='" + this.xcopago + "' AND f_estratoxemprcontconv.Id_EmpresaContConv ='" + getIdEmpresa() + "') ORDER BY Estrato ASC ";
            this.xidestrato = this.consultas.llenarComboyLista(this.sql, this.xidestrato, this.cboEstrato1, 5);
            this.consultas.cerrarConexionBd();
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getIdentificacion().equals("900304530")) {
                this.cboEstrato1.setSelectedIndex(0);
            } else {
                this.cboEstrato1.setSelectedIndex(-1);
            }
        }
    }

    public void mLlenarComboTipoAfiliado() {
    }

    public void nuevo() {
        this.lleno = false;
        if (Principal.informacionIps.getAplicaFiltroConvenio().booleanValue()) {
            this.JCH_AplicaFiltroConvenio.setSelected(true);
        } else {
            this.JCH_AplicaFiltroConvenio.setSelected(false);
        }
        this.txtFecha.setDate(this.metodos.getFechaActualPC());
        this.txtHora.setValue(this.metodos.getFechaActual());
        setIdLiquidacion(new Long(0L));
        setIdFacturaCapita(new Long(0L));
        setIdFacturaEvento(new Long(0L));
        setEstadoFacturaOrdenes(new Integer(0));
        setIdOrdenes("");
        this.idIngreso = "0";
        this.xTratamiento = "0";
        cargarCboProfesional();
        cargarCombos();
        this.xcopago = 0;
        this.btnCModeradora.setSelected(true);
        this.cboEstrato1.removeAllItems();
        this.xEsNuevaMuestra = 0;
        this.txtFecha.setDate(this.metodos.getFechaActualPC());
        this.txtHora.setValue(this.metodos.getFechaActual());
        this.txtNoAutorizacion.setText("");
        this.consultas.cerrarConexionBd();
        this.JTAObservacion.setText("");
        this.consultas.cerrarConexionBd();
        mSeleccionar_Datos();
        this.lleno = true;
    }

    private int verificarEstadoIngreso(String idIngreso) {
        int retorno;
        this.sql = "SELECT Estado FROMingreso WHERE (Id =" + idIngreso + ")";
        this.sql = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (this.sql.equals("0")) {
            retorno = 0;
        } else {
            retorno = 1;
        }
        return retorno;
    }

    public int verificarEstadoOrdenesIngreso(String idIngreso) {
        int retorno = 0;
        this.sql = "SELECT Estado FROM f_ordenes WHERE (Estado= 0 AND Id_Ingreso =" + idIngreso + ")";
        this.sql = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (this.sql.equals("")) {
            retorno = 1;
        }
        return retorno;
    }

    public void mEstablecerUltimoNivelEstudio(String xidusuario) {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.sql = "SELECT ucase(`g_nivelestudio`.`Nbre`) FROM `g_nivelestudio` INNER JOIN `ingreso`  ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`) WHERE (`ingreso`.`Id_Usuario` ='" + xidusuario + "') ORDER BY `ingreso`.`Id` DESC ";
            ResultSet xrs = xct.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                this.JCBEscolaridad.setSelectedItem(xrs.getString(1));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_IngresoAgil.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int verificarEstadoFacturaIngreso(String idIngreso, int esCapitado) {
        int retorno = 0;
        if (esCapitado == 0 || esCapitado == 1) {
            this.sql = "SELECT f_factura_capita.Estado FROM f_factura_capita INNER JOIN f_liquidacion ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) WHERE (f_factura_capita.Estado =0 AND f_liquidacion.Id_Ingreso ='" + idIngreso + "')";
        } else {
            this.sql = "SELECT f_factura_evento.Estado FROM f_factura_evento INNER JOIN f_liquidacion ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) WHERE (f_factura_evento.Estado =0 AND f_liquidacion.Id_Ingreso ='" + idIngreso + "')";
        }
        this.sql = this.consultas.traerDato(this.sql);
        if (this.sql.equals("")) {
            retorno = 1;
        }
        return retorno;
    }

    public int verificarEstadoFacturaIngreso(String idIngreso) {
        int retorno = 0;
        if (this.lisEmpresa[this.cboEmpresa.getSelectedIndex()][2].equals("2")) {
            this.sql = "SELECT f_factura_evento.Estado FROM f_factura_evento INNER JOIN f_liquidacion ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) WHERE (f_factura_evento.Estado =0 AND f_liquidacion.Id_Ingreso ='" + idIngreso + "')";
            this.sql = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            if (!this.sql.equals("0")) {
                retorno = 1;
            }
        } else {
            this.sql = "SELECT f_factura_capita.Estado FROM f_factura_capita INNER JOIN f_liquidacion ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) WHERE (f_factura_capita.Estado =0 AND f_liquidacion.Id_Ingreso ='" + idIngreso + "')";
            this.sql = this.consultas.traerDato(this.sql);
            this.consultas.cerrarConexionBd();
            if (!this.sql.equals("0")) {
                retorno = 1;
            }
        }
        return retorno;
    }

    private void realizarCasting(JInternalFrame frmI) {
        if (frmI.getName().equals("FacturaA")) {
            this.frmFacturacionAgil = (JIF_FacturacionAgil) frmI;
        }
    }

    public void mBuscarIngresos(String nusuario) {
        try {
            String xsql = "SELECT ingreso.Id, ingreso.FechaIngreso, ingreso.HoraIngreso, f_empresacontxconvenio.Nbre, ingreso.SiCopago, f_estrato.Nbre, g_origenadmision.Nbre, g_causaexterna.Nbre , g_especialidad.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, g_patologia.Id, g_patologia.Nbre, ingreso.NoPoliza, ingreso.NoAutorizacion, g_contratos.Nbre_Contrato, ingreso.Estado FROM ingreso INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_estrato  ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN g_causaexterna  ON (ingreso.Id_CausaExterna = g_causaexterna.Id) INNER JOIN g_origenadmision  ON (ingreso.Id_OrigenAdmision = g_origenadmision.Id) INNER JOIN g_especialidad  ON (ingreso.Id_Especialidad = g_especialidad.Id) INNER JOIN g_profesional  ON (ingreso.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_contratos  ON (ingreso.Id_Contrato = g_contratos.Id) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN g_patologia  ON (g_patologia.Id = ingreso.DxIngreso) WHERE (ingreso.Id_Usuario ='" + nusuario + "') ORDER BY ingreso.FechaIngreso asc, ingreso.HoraIngreso DESC ";
            ResultSet rs1 = this.consultas.traerRs(xsql);
            if (rs1.next()) {
                this.sw = 1;
                rs1.last();
                int ningresos = rs1.getRow();
                this.xlimiteinf = 0;
                this.xlimitesup = ningresos;
                this.xidingresos = new String[ningresos];
                rs1.beforeFirst();
                int i = 0;
                while (rs1.next()) {
                    this.xidingresos[i] = rs1.getString(1);
                    i++;
                }
            } else {
                this.sw = 0;
            }
            rs1.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_IngresoAgil.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mMovimientoResultSet(int pos, boolean xtipo) {
        String xsql;
        try {
            if (xtipo) {
                xsql = "SELECT ingreso.Id, ingreso.FechaIngreso, ingreso.HoraIngreso, f_empresacontxconvenio.Nbre, ingreso.SiCopago, f_estrato.Nbre, g_origenadmision.Nbre, g_causaexterna.Nbre , g_especialidad.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, g_patologia.Id, g_patologia.Nbre, ingreso.NoPoliza, ingreso.NoAutorizacion, g_contratos.Nbre_Contrato, ingreso.Estado FROM ingreso INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_estrato  ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN g_causaexterna  ON (ingreso.Id_CausaExterna = g_causaexterna.Id) INNER JOIN g_origenadmision  ON (ingreso.Id_OrigenAdmision = g_origenadmision.Id) INNER JOIN g_especialidad  ON (ingreso.Id_Especialidad = g_especialidad.Id) INNER JOIN g_profesional  ON (ingreso.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_contratos  ON (ingreso.Id_Contrato = g_contratos.Id) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN g_patologia  ON (g_patologia.Id = ingreso.DxIngreso) WHERE (ingreso.Id ='" + this.xidingresos[pos] + "') ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso DESC ";
            } else {
                xsql = "SELECT ingreso.Id, ingreso.FechaIngreso, ingreso.HoraIngreso, f_empresacontxconvenio.Nbre, ingreso.SiCopago, f_estrato.Nbre, g_origenadmision.Nbre, g_causaexterna.Nbre , g_especialidad.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, g_patologia.Id, g_patologia.Nbre, ingreso.NoPoliza, ingreso.NoAutorizacion, g_contratos.Nbre_Contrato, ingreso.Estado FROM ingreso INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_estrato  ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN g_causaexterna  ON (ingreso.Id_CausaExterna = g_causaexterna.Id) INNER JOIN g_origenadmision  ON (ingreso.Id_OrigenAdmision = g_origenadmision.Id) INNER JOIN g_especialidad  ON (ingreso.Id_Especialidad = g_especialidad.Id) INNER JOIN g_profesional  ON (ingreso.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_contratos  ON (ingreso.Id_Contrato = g_contratos.Id) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN g_patologia  ON (g_patologia.Id = ingreso.DxIngreso) WHERE (ingreso.Id ='" + pos + "') ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso DESC ";
            }
            ResultSet rs = this.consultas.traerRs(xsql);
            if (rs.next()) {
                rs.first();
                cargarIngreso(rs.getString(1));
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_IngresoAgil.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mUltimoIngreso() {
        if (this.sw == 1) {
            this.xmovi = this.xlimitesup - 1;
            mMovimientoResultSet(this.xlimitesup - 1, true);
        }
    }

    public void mPrimerIngreso() {
        if (this.sw == 1) {
            this.xmovi = this.xlimiteinf;
            mMovimientoResultSet(this.xlimiteinf, true);
        }
    }

    public void mAnteriorIngreso() {
        if (this.sw == 1) {
            this.xmovi--;
            if (this.xmovi >= this.xlimiteinf) {
                mMovimientoResultSet(this.xmovi, true);
            } else {
                this.xmovi = this.xlimiteinf;
            }
        }
    }

    public void mSiguienteIngreso() {
        if (this.sw == 1) {
            this.xmovi++;
            if (this.xmovi <= this.xlimitesup - 1) {
                mMovimientoResultSet(this.xmovi, true);
            } else {
                this.xmovi = this.xlimitesup;
            }
        }
    }

    private void initComponents() {
        this.JBGTipoEstrato = new ButtonGroup();
        this.JPIIngreso = new JPanel();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.txtHora = new JFormattedTextField();
        this.jPanel1 = new JPanel();
        this.btnCModeradora = new JRadioButton();
        this.btnCopago = new JRadioButton();
        this.cboEmpresa = new JComboBox();
        try {
            this.cboContrato = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        try {
            this.cboTipoAtencion = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        this.cboEstrato1 = new JComboBox();
        try {
            this.JCBEscolaridad = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        this.cboEspecialidad = new JComboBox();
        this.cboProfesional = new JComboBox();
        this.JCH_AplicaFiltroConvenio = new JCheckBox();
        this.txtNoAutorizacion = new JFormattedTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        setName("Ingreso");
        setPreferredSize(new Dimension(1000, 260));
        this.JPIIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOSINGRESO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JPIIngreso.setForeground(new Color(0, 0, 102));
        this.JPIIngreso.setFont(new Font("Tahoma", 1, 11));
        this.JPIIngreso.setLayout((LayoutManager) null);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_IngresoAgil.this.txtFechaPropertyChange(evt);
            }
        });
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.2
            public void keyPressed(KeyEvent evt) {
                JP_IngresoAgil.this.txtFechaKeyPressed(evt);
            }
        });
        this.JPIIngreso.add(this.txtFecha);
        this.txtFecha.setBounds(10, 0, 130, 50);
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.3
            public void keyPressed(KeyEvent evt) {
                JP_IngresoAgil.this.txtHoraKeyPressed(evt);
            }
        });
        this.JPIIngreso.add(this.txtHora);
        this.txtHora.setBounds(160, 20, 110, 40);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Cobro", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.JBGTipoEstrato.add(this.btnCModeradora);
        this.btnCModeradora.setFont(new Font("Arial", 1, 12));
        this.btnCModeradora.setForeground(new Color(0, 0, 255));
        this.btnCModeradora.setSelected(true);
        this.btnCModeradora.setText("C. Moderadora");
        this.btnCModeradora.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.4
            public void mouseClicked(MouseEvent evt) {
                JP_IngresoAgil.this.btnCModeradoraMouseClicked(evt);
            }
        });
        this.btnCModeradora.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.5
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoAgil.this.btnCModeradoraActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnCModeradora);
        this.btnCModeradora.setBounds(10, 20, 110, 23);
        this.JBGTipoEstrato.add(this.btnCopago);
        this.btnCopago.setFont(new Font("Arial", 1, 12));
        this.btnCopago.setForeground(new Color(0, 0, 255));
        this.btnCopago.setText("Copago");
        this.btnCopago.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.6
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoAgil.this.btnCopagoActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnCopago);
        this.btnCopago.setBounds(10, 50, 110, 23);
        this.JPIIngreso.add(this.jPanel1);
        this.jPanel1.setBounds(10, 50, 136, 90);
        this.cboEmpresa.setFont(new Font("Arial", 1, 12));
        this.cboEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio a Facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEmpresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.7
            public void itemStateChanged(ItemEvent evt) {
                JP_IngresoAgil.this.cboEmpresaItemStateChanged(evt);
            }
        });
        this.cboEmpresa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.8
            public void mouseClicked(MouseEvent evt) {
                JP_IngresoAgil.this.cboEmpresaMouseClicked(evt);
            }
        });
        this.cboEmpresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.9
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoAgil.this.cboEmpresaActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.cboEmpresa);
        this.cboEmpresa.setBounds(270, 20, 350, 49);
        this.cboContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Contrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboContrato.setFont(new Font("Arial", 1, 12));
        this.cboContrato.setShowTableGrid(true);
        this.cboContrato.setShowTableHeaders(true);
        this.JPIIngreso.add(this.cboContrato);
        this.cboContrato.setBounds(320, 70, 180, 40);
        this.cboTipoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de atención y/o Servicios", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.cboTipoAtencion.setShowTableGrid(true);
        this.cboTipoAtencion.setShowTableHeaders(true);
        this.cboTipoAtencion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.10
            public void itemStateChanged(ItemEvent evt) {
                JP_IngresoAgil.this.cboTipoAtencionItemStateChanged(evt);
            }
        });
        this.cboTipoAtencion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.11
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoAgil.this.cboTipoAtencionActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.cboTipoAtencion);
        this.cboTipoAtencion.setBounds(690, 20, 260, 49);
        this.cboEstrato1.setFont(new Font("Arial", 1, 12));
        this.cboEstrato1.setBorder(BorderFactory.createTitledBorder((Border) null, "Estrato", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPIIngreso.add(this.cboEstrato1);
        this.cboEstrato1.setBounds(150, 70, 160, 40);
        this.JCBEscolaridad.setBorder(BorderFactory.createTitledBorder((Border) null, "Escolaridad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEscolaridad.setFont(new Font("Arial", 1, 12));
        this.JCBEscolaridad.setShowTableGrid(true);
        this.JCBEscolaridad.setShowTableHeaders(true);
        this.JCBEscolaridad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.12
            public void itemStateChanged(ItemEvent evt) {
                JP_IngresoAgil.this.JCBEscolaridadItemStateChanged(evt);
            }
        });
        this.JPIIngreso.add(this.JCBEscolaridad);
        this.JCBEscolaridad.setBounds(320, 130, 180, 49);
        this.cboEspecialidad.setFont(new Font("Arial", 1, 12));
        this.cboEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad que Ordena", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboEspecialidad.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.13
            public void itemStateChanged(ItemEvent evt) {
                JP_IngresoAgil.this.cboEspecialidadItemStateChanged(evt);
            }
        });
        this.cboEspecialidad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.14
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoAgil.this.cboEspecialidadActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.cboEspecialidad);
        this.cboEspecialidad.setBounds(510, 70, 270, 40);
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Ordena", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboProfesional.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.15
            public void itemStateChanged(ItemEvent evt) {
                JP_IngresoAgil.this.cboProfesionalItemStateChanged(evt);
            }
        });
        this.JPIIngreso.add(this.cboProfesional);
        this.cboProfesional.setBounds(780, 70, 180, 40);
        this.JCH_AplicaFiltroConvenio.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaFiltroConvenio.setText("Filtro");
        this.JCH_AplicaFiltroConvenio.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.16
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoAgil.this.JCH_AplicaFiltroConvenioActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.JCH_AplicaFiltroConvenio);
        this.JCH_AplicaFiltroConvenio.setBounds(620, 30, 65, 23);
        this.txtNoAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Autorización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoAutorizacion.setFont(new Font("Arial", 1, 12));
        this.txtNoAutorizacion.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.17
            public void focusLost(FocusEvent evt) {
                JP_IngresoAgil.this.txtNoAutorizacionFocusLost(evt);
            }
        });
        this.txtNoAutorizacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.18
            public void actionPerformed(ActionEvent evt) {
                JP_IngresoAgil.this.txtNoAutorizacionActionPerformed(evt);
            }
        });
        this.txtNoAutorizacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.facturacion.saludocupacional.JP_IngresoAgil.19
            public void keyPressed(KeyEvent evt) {
                JP_IngresoAgil.this.txtNoAutorizacionKeyPressed(evt);
            }
        });
        this.JPIIngreso.add(this.txtNoAutorizacion);
        this.txtNoAutorizacion.setBounds(150, 130, 160, 40);
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JPIIngreso.add(this.JSPObservacion);
        this.JSPObservacion.setBounds(510, 120, 450, 62);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JPIIngreso, -2, 974, -2).addContainerGap(24, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIIngreso, -2, 199, -2).addContainerGap(50, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCopagoActionPerformed(ActionEvent evt) {
        this.xcopago = 1;
        mLlenarComboEstrado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCModeradoraActionPerformed(ActionEvent evt) {
        this.xcopago = 0;
        mLlenarComboEstrado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEmpresaItemStateChanged(ItemEvent evt) {
        cambioEmpresa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoAtencionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEscolaridadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCModeradoraMouseClicked(MouseEvent evt) {
    }

    private void mSeleccionar_Datos() {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.JCBEscolaridad.setSelectedItem("NO APLICA");
            this.cboEspecialidad.setSelectedItem("ACTUALIZAR");
            this.cboProfesional.setSelectedIndex(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadActionPerformed(ActionEvent evt) {
        if (this.xlleno) {
            cargarCboProfesional();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno) {
            cambioCboEspecialidad();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalItemStateChanged(ItemEvent evt) {
        if (this.cboEspecialidad.getSelectedIndex() != -1) {
            cambioCboProfesional();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoAutorizacionActionPerformed(ActionEvent evt) {
        this.txtNoAutorizacion.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoAutorizacionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtNoAutorizacion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoAutorizacionFocusLost(FocusEvent evt) {
        if (!this.txtNoAutorizacion.getText().isEmpty() && this.cboEmpresa.getSelectedIndex() != -1) {
            mConsultarNAutorizacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoAtencionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEmpresaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno && Principal.clasefacturacion != null && Principal.clasefacturacion.frmFacturac != null && Principal.clasefacturacion.frmFacturac.frmOrdenes != null) {
            Principal.clasefacturacion.frmFacturac.frmOrdenes.txtFecha.setDate(this.txtFecha.getDate());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AplicaFiltroConvenioActionPerformed(ActionEvent evt) {
        llevarComboConvenio();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEmpresaActionPerformed(ActionEvent evt) {
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "cirugia", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    @Generated
    public ButtonGroup getJBGTipoEstrato() {
        return this.JBGTipoEstrato;
    }

    @Generated
    public JTableComboBox getJCBEscolaridad() {
        return this.JCBEscolaridad;
    }

    @Generated
    public JCheckBox getJCH_AplicaFiltroConvenio() {
        return this.JCH_AplicaFiltroConvenio;
    }

    @Generated
    public JPanel getJPIIngreso() {
        return this.JPIIngreso;
    }

    @Generated
    public JScrollPane getJSPObservacion() {
        return this.JSPObservacion;
    }

    @Generated
    public JTextArea getJTAObservacion() {
        return this.JTAObservacion;
    }

    @Generated
    public JRadioButton getBtnCModeradora() {
        return this.btnCModeradora;
    }

    @Generated
    public JRadioButton getBtnCopago() {
        return this.btnCopago;
    }

    @Generated
    public JTableComboBox getCboContrato() {
        return this.cboContrato;
    }

    @Generated
    public JComboBox getCboEmpresa() {
        return this.cboEmpresa;
    }

    @Generated
    public JComboBox getCboEspecialidad() {
        return this.cboEspecialidad;
    }

    @Generated
    public JComboBox getCboEstrato1() {
        return this.cboEstrato1;
    }

    @Generated
    public JComboBox getCboProfesional() {
        return this.cboProfesional;
    }

    @Generated
    public JTableComboBox getCboTipoAtencion() {
        return this.cboTipoAtencion;
    }

    @Generated
    public JPanel getJPanel1() {
        return this.jPanel1;
    }

    @Generated
    public JDateChooser getTxtFecha() {
        return this.txtFecha;
    }

    @Generated
    public JFormattedTextField getTxtHora() {
        return this.txtHora;
    }

    @Generated
    public JFormattedTextField getTxtNoAutorizacion() {
        return this.txtNoAutorizacion;
    }
}
