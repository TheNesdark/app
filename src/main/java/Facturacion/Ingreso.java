package Facturacion;

import Acceso.Principal;
import Citas.CitaNP;
import Enfermeria.Atencion;
import General.JIFBuscarPatologia;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDBuscarOcupacion;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FEmpresacontxconvenioMision;
import com.genoma.plus.jpa.entities.GEntornoAtencion;
import com.genoma.plus.jpa.entities.GModalidadatencion;
import com.genoma.plus.jpa.projection.IConsultarNumeroAutorizacionIngreso;
import com.genoma.plus.jpa.projection.IEmpresaContratoConvenioDTO;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.IngresoService;
import com.genoma.plus.jpa.service.f_empresacontxconvenio_misionService;
import com.genoma.plus.utils.UtilidadesGenericas;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import lombok.Generated;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Ingreso.class */
public class Ingreso extends JPanel {
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
    private Facturac frmFacturac;
    private CitaNP frmCitaNP1;
    private Atencion frmAtencion;
    public String[] cEspecial;
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
    private int ingresse;
    private Persona person;
    private Facturac frmfacturac;
    private List<FEmpresacontxconvenioMision> listEmpresaMision;
    private final f_empresacontxconvenio_misionService empresaEnMisionService;
    private final IEmpresaContConvenioService iEmpresaContConvenioService;
    private final UtilidadesGenericas utilidadesGenericas;
    public List<GModalidadatencion> listGModalidadatencions;
    public List<GEntornoAtencion> listGEntornoAtencions;
    public List<IEmpresaContratoConvenioDTO> listConvenio;
    private ButtonGroup JBGTipoEstrato;
    private JButton JBTActualizarIngreso;
    public JComboBox JCBCondVict;
    private JComboBox JCBEmpresaMision;
    public JComboBox JCBEntornoAtencion;
    public JTableComboBox JCBEscolaridad;
    public JComboBox JCBModalidadAtencion;
    public JComboBox JCBOcupaciones;
    public JComboBox JCBParentescoAcompaniante;
    public JComboBox JCBTipoAfiliado;
    public JComboBox JCBTipoDocAcop;
    public JComboBox JCBTipoDocResp;
    public JComboBox JCB_TipoCoberturaPlan;
    public JComboBox JCB_TipoContratacion;
    private JCheckBox JCHEsNuevaMuestra;
    public JCheckBox JCH_AplicaFiltroConvenio;
    private JLabel JLBTDxRelacionados;
    private JPanel JPIAdicional;
    private JPanel JPIAdicional1;
    private JPanel JPIDiagnostico;
    private JPanel JPIIngreso;
    private JPanel JPIResponsable;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    private JTextField JTFCDxR1;
    private JTextField JTFCDxR2;
    private JTextField JTFCDxR3;
    public JTextField JTFCie10;
    private JTextField JTFNDxR1;
    private JTextField JTFNDxR2;
    private JTextField JTFNDxR3;
    public JTextField JTFNoDocu;
    public JTextField JTF_DNombre;
    public JTabbedPane JTPDatosIngreso;
    public JRadioButton btnCModeradora;
    public JRadioButton btnCopago;
    public JTableComboBox cboCamas;
    public JTableComboBox cboCausaExterna;
    public JTableComboBox cboContrato;
    public JComboBox cboEmpresa;
    public JComboBox cboEspecialidad;
    public JComboBox cboEstrato1;
    public JTableComboBox cboOrigenIngreso;
    public JTableComboBox cboParentescoR;
    public JComboBox cboProfesional;
    public JTableComboBox cboTipoAtencion;
    public JTableComboBox cboUnidadCamas;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    public JTextField txtCedulaA;
    public JDateChooser txtFecha;
    public JFormattedTextField txtHora;
    public JFormattedTextField txtNoAutorizacion;
    public JFormattedTextField txtNoPoliza;
    public JFormattedTextField txtNoPrescripcionMiPres;
    public JTextField txtNombreA;
    public JTextField txtNombreR;
    public JFormattedTextField txtSiras;
    public JTextField txtTelefonoA;
    public JTextField txtTelefonoR;
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
    public void setFrmFacturac(Facturac frmFacturac) {
        this.frmFacturac = frmFacturac;
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
    public void setCEspecial(String[] cEspecial) {
        this.cEspecial = cEspecial;
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
    public void setIngresse(int ingresse) {
        this.ingresse = ingresse;
    }

    @Generated
    public void setPerson(Persona person) {
        this.person = person;
    }

    @Generated
    public void setListEmpresaMision(List<FEmpresacontxconvenioMision> listEmpresaMision) {
        this.listEmpresaMision = listEmpresaMision;
    }

    @Generated
    public void setListGModalidadatencions(List<GModalidadatencion> listGModalidadatencions) {
        this.listGModalidadatencions = listGModalidadatencions;
    }

    @Generated
    public void setListGEntornoAtencions(List<GEntornoAtencion> listGEntornoAtencions) {
        this.listGEntornoAtencions = listGEntornoAtencions;
    }

    @Generated
    public void setListConvenio(List<IEmpresaContratoConvenioDTO> listConvenio) {
        this.listConvenio = listConvenio;
    }

    @Generated
    public void setJBGTipoEstrato(ButtonGroup JBGTipoEstrato) {
        this.JBGTipoEstrato = JBGTipoEstrato;
    }

    @Generated
    public void setJBTActualizarIngreso(JButton JBTActualizarIngreso) {
        this.JBTActualizarIngreso = JBTActualizarIngreso;
    }

    @Generated
    public void setJCBCondVict(JComboBox JCBCondVict) {
        this.JCBCondVict = JCBCondVict;
    }

    @Generated
    public void setJCBEmpresaMision(JComboBox JCBEmpresaMision) {
        this.JCBEmpresaMision = JCBEmpresaMision;
    }

    @Generated
    public void setJCBEntornoAtencion(JComboBox JCBEntornoAtencion) {
        this.JCBEntornoAtencion = JCBEntornoAtencion;
    }

    @Generated
    public void setJCBEscolaridad(JTableComboBox JCBEscolaridad) {
        this.JCBEscolaridad = JCBEscolaridad;
    }

    @Generated
    public void setJCBModalidadAtencion(JComboBox JCBModalidadAtencion) {
        this.JCBModalidadAtencion = JCBModalidadAtencion;
    }

    @Generated
    public void setJCBOcupaciones(JComboBox JCBOcupaciones) {
        this.JCBOcupaciones = JCBOcupaciones;
    }

    @Generated
    public void setJCBParentescoAcompaniante(JComboBox JCBParentescoAcompaniante) {
        this.JCBParentescoAcompaniante = JCBParentescoAcompaniante;
    }

    @Generated
    public void setJCBTipoAfiliado(JComboBox JCBTipoAfiliado) {
        this.JCBTipoAfiliado = JCBTipoAfiliado;
    }

    @Generated
    public void setJCBTipoDocAcop(JComboBox JCBTipoDocAcop) {
        this.JCBTipoDocAcop = JCBTipoDocAcop;
    }

    @Generated
    public void setJCBTipoDocResp(JComboBox JCBTipoDocResp) {
        this.JCBTipoDocResp = JCBTipoDocResp;
    }

    @Generated
    public void setJCB_TipoCoberturaPlan(JComboBox JCB_TipoCoberturaPlan) {
        this.JCB_TipoCoberturaPlan = JCB_TipoCoberturaPlan;
    }

    @Generated
    public void setJCB_TipoContratacion(JComboBox JCB_TipoContratacion) {
        this.JCB_TipoContratacion = JCB_TipoContratacion;
    }

    @Generated
    public void setJCHEsNuevaMuestra(JCheckBox JCHEsNuevaMuestra) {
        this.JCHEsNuevaMuestra = JCHEsNuevaMuestra;
    }

    @Generated
    public void setJCH_AplicaFiltroConvenio(JCheckBox JCH_AplicaFiltroConvenio) {
        this.JCH_AplicaFiltroConvenio = JCH_AplicaFiltroConvenio;
    }

    @Generated
    public void setJLBTDxRelacionados(JLabel JLBTDxRelacionados) {
        this.JLBTDxRelacionados = JLBTDxRelacionados;
    }

    @Generated
    public void setJPIAdicional(JPanel JPIAdicional) {
        this.JPIAdicional = JPIAdicional;
    }

    @Generated
    public void setJPIAdicional1(JPanel JPIAdicional1) {
        this.JPIAdicional1 = JPIAdicional1;
    }

    @Generated
    public void setJPIDiagnostico(JPanel JPIDiagnostico) {
        this.JPIDiagnostico = JPIDiagnostico;
    }

    @Generated
    public void setJPIIngreso(JPanel JPIIngreso) {
        this.JPIIngreso = JPIIngreso;
    }

    @Generated
    public void setJPIResponsable(JPanel JPIResponsable) {
        this.JPIResponsable = JPIResponsable;
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
    public void setJTFCDxR1(JTextField JTFCDxR1) {
        this.JTFCDxR1 = JTFCDxR1;
    }

    @Generated
    public void setJTFCDxR2(JTextField JTFCDxR2) {
        this.JTFCDxR2 = JTFCDxR2;
    }

    @Generated
    public void setJTFCDxR3(JTextField JTFCDxR3) {
        this.JTFCDxR3 = JTFCDxR3;
    }

    @Generated
    public void setJTFCie10(JTextField JTFCie10) {
        this.JTFCie10 = JTFCie10;
    }

    @Generated
    public void setJTFNDxR1(JTextField JTFNDxR1) {
        this.JTFNDxR1 = JTFNDxR1;
    }

    @Generated
    public void setJTFNDxR2(JTextField JTFNDxR2) {
        this.JTFNDxR2 = JTFNDxR2;
    }

    @Generated
    public void setJTFNDxR3(JTextField JTFNDxR3) {
        this.JTFNDxR3 = JTFNDxR3;
    }

    @Generated
    public void setJTFNoDocu(JTextField JTFNoDocu) {
        this.JTFNoDocu = JTFNoDocu;
    }

    @Generated
    public void setJTF_DNombre(JTextField JTF_DNombre) {
        this.JTF_DNombre = JTF_DNombre;
    }

    @Generated
    public void setJTPDatosIngreso(JTabbedPane JTPDatosIngreso) {
        this.JTPDatosIngreso = JTPDatosIngreso;
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
    public void setCboCamas(JTableComboBox cboCamas) {
        this.cboCamas = cboCamas;
    }

    @Generated
    public void setCboCausaExterna(JTableComboBox cboCausaExterna) {
        this.cboCausaExterna = cboCausaExterna;
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
    public void setCboOrigenIngreso(JTableComboBox cboOrigenIngreso) {
        this.cboOrigenIngreso = cboOrigenIngreso;
    }

    @Generated
    public void setCboParentescoR(JTableComboBox cboParentescoR) {
        this.cboParentescoR = cboParentescoR;
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
    public void setCboUnidadCamas(JTableComboBox cboUnidadCamas) {
        this.cboUnidadCamas = cboUnidadCamas;
    }

    @Generated
    public void setJPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    @Generated
    public void setJPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    @Generated
    public void setJPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    @Generated
    public void setTxtCedulaA(JTextField txtCedulaA) {
        this.txtCedulaA = txtCedulaA;
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
    public void setTxtNoPoliza(JFormattedTextField txtNoPoliza) {
        this.txtNoPoliza = txtNoPoliza;
    }

    @Generated
    public void setTxtNoPrescripcionMiPres(JFormattedTextField txtNoPrescripcionMiPres) {
        this.txtNoPrescripcionMiPres = txtNoPrescripcionMiPres;
    }

    @Generated
    public void setTxtNombreA(JTextField txtNombreA) {
        this.txtNombreA = txtNombreA;
    }

    @Generated
    public void setTxtNombreR(JTextField txtNombreR) {
        this.txtNombreR = txtNombreR;
    }

    @Generated
    public void setTxtSiras(JFormattedTextField txtSiras) {
        this.txtSiras = txtSiras;
    }

    @Generated
    public void setTxtTelefonoA(JTextField txtTelefonoA) {
        this.txtTelefonoA = txtTelefonoA;
    }

    @Generated
    public void setTxtTelefonoR(JTextField txtTelefonoR) {
        this.txtTelefonoR = txtTelefonoR;
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
    public Facturac getFrmFacturac() {
        return this.frmFacturac;
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
    public String[] getCEspecial() {
        return this.cEspecial;
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
    public int getIngresse() {
        return this.ingresse;
    }

    @Generated
    public Persona getPerson() {
        return this.person;
    }

    @Generated
    public List<FEmpresacontxconvenioMision> getListEmpresaMision() {
        return this.listEmpresaMision;
    }

    @Generated
    public f_empresacontxconvenio_misionService getEmpresaEnMisionService() {
        return this.empresaEnMisionService;
    }

    @Generated
    public IEmpresaContConvenioService getIEmpresaContConvenioService() {
        return this.iEmpresaContConvenioService;
    }

    @Generated
    public UtilidadesGenericas getUtilidadesGenericas() {
        return this.utilidadesGenericas;
    }

    @Generated
    public IngresoService getIngresoService() {
        return this.ingresoService;
    }

    @Generated
    public List<GModalidadatencion> getListGModalidadatencions() {
        return this.listGModalidadatencions;
    }

    @Generated
    public List<GEntornoAtencion> getListGEntornoAtencions() {
        return this.listGEntornoAtencions;
    }

    @Generated
    public List<IEmpresaContratoConvenioDTO> getListConvenio() {
        return this.listConvenio;
    }

    public Ingreso(JInternalFrame frmI, String llamador, String ambitoAtencion) {
        initComponents();
        realizarCasting(frmI);
        springStart();
        this.frmLlamador = llamador;
        this.ambitoAtencion = ambitoAtencion;
        this.empresaEnMisionService = (f_empresacontxconvenio_misionService) Principal.contexto.getBean(f_empresacontxconvenio_misionService.class);
        this.iEmpresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        this.utilidadesGenericas = new UtilidadesGenericas();
        this.listConvenio = new ArrayList();
        nuevo();
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.JBTActualizarIngreso.setEnabled(true);
            this.JBTActualizarIngreso.setVisible(true);
        } else {
            this.JBTActualizarIngreso.setEnabled(false);
            this.JBTActualizarIngreso.setVisible(false);
        }
    }

    private void springStart() {
        this.patologiaCie10DAO = (PatologiaCie10DAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("patologiaCie10DAOImpl");
    }

    public String getIdEmpresa() {
        return !this.listConvenio.isEmpty() ? this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId().toString() : "0";
    }

    public String getIdCama() {
        return this.cboCamas.getPopupTable().getValueAt(this.cboCamas.getSelectedIndex(), 0).toString();
    }

    public String getIdUnidadCama() {
        return this.cboUnidadCamas.getPopupTable().getValueAt(this.cboUnidadCamas.getSelectedIndex(), 0).toString();
    }

    public String getIdTipoPlanEmpresa() {
        return this.idTipoPlanEmpresa;
    }

    public String getIdIngreso() {
        return this.idIngreso;
    }

    public String getTipoContratacion() {
        return !this.listConvenio.isEmpty() ? this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getTipoContratacion() : "0";
    }

    public String getTipoCobertura() {
        return !this.listConvenio.isEmpty() ? this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getTipoCobertura() : "0";
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

    public String getIdProceCama() {
        return this.cboCamas.getPopupTable().getValueAt(this.cboCamas.getSelectedIndex(), 3).toString();
    }

    public String getAmbitoAtencion() {
        return this.ambitoAtencion;
    }

    private void getValidacionConvenio() {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            this.JCH_AplicaFiltroConvenio.setEnabled(false);
            this.JCH_AplicaFiltroConvenio.setSelected(true);
        }
    }

    public int getValidarComponentes() {
        int retorno = 0;
        if (this.txtFecha.getDate() == null) {
            this.metodos.mostrarMensaje("Por Favor seleccione una Fecha.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.txtFecha.requestFocus();
        } else if (this.txtHora.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Hora de Ingreso.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.txtHora.requestFocus();
        } else if (this.cboEmpresa.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la Empresa a quien se Facturará.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.cboEmpresa.requestFocus();
        } else if (this.cboEstrato1.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Estrato.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.cboEstrato1.requestFocus();
        } else if (this.cboEspecialidad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione una Especialidad.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.cboEspecialidad.requestFocus();
        } else if (this.cboProfesional.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Profesional.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.cboProfesional.requestFocus();
        } else if (this.cboContrato.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Contrato para la Empresa a Facturar.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.cboContrato.requestFocus();
        } else if (this.cboOrigenIngreso.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el Origen del Ingreso.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.cboOrigenIngreso.requestFocus();
        } else if (this.cboCausaExterna.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione la causa externa del Ingreso.");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.cboCausaExterna.requestFocus();
        } else if (this.JCBEscolaridad.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Debe de seleccionar el nivel de estudio");
            this.JTPDatosIngreso.setSelectedIndex(0);
            this.JCBEscolaridad.requestFocus();
        } else if (this.JCBOcupaciones.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Debe de seleccionar la ocupacion");
            this.JTPDatosIngreso.setSelectedIndex(1);
            this.JCBOcupaciones.requestFocus();
        } else if (this.JCBTipoAfiliado.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el tipo de Afiliacion.");
            this.JTPDatosIngreso.setSelectedIndex(1);
            this.JCBTipoAfiliado.requestFocus();
        } else if (this.JCB_TipoContratacion.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el tipo de Contratacion.");
            this.JTPDatosIngreso.setSelectedIndex(1);
            this.JCB_TipoContratacion.requestFocus();
        } else if (this.JCB_TipoCoberturaPlan.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por Favor seleccione el tipo de Cobertura.");
            this.JTPDatosIngreso.setSelectedIndex(1);
            this.JCB_TipoCoberturaPlan.requestFocus();
        } else if (this.JTFCie10.getText().equals("0000") || this.JTFCie10.getText().isEmpty()) {
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getIdentificacion().equals("900595873")) {
                if (this.frmFacturac != null && this.frmFacturac.frmOrdenes.getIdCita().equals("null")) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Diagnóstico no valido: Desea digitarlo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        this.JTPDatosIngreso.setSelectedIndex(1);
                        this.JTFCie10.requestFocus();
                    } else {
                        retorno = 0;
                    }
                } else {
                    retorno = 1;
                }
            } else if (!Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || !Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
                retorno = 1;
            } else {
                int n2 = JOptionPane.showInternalConfirmDialog(this, "Diagnóstico no valido: Desea digitarlo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n2 == 0) {
                    this.JTPDatosIngreso.setSelectedIndex(1);
                    this.JTFCie10.requestFocus();
                } else {
                    retorno = 1;
                }
            }
        } else if (this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getValidaCodigoAutorizacion().booleanValue()) {
            if (this.txtNoAutorizacion.getText().isEmpty()) {
                this.metodos.mostrarMensaje("Debe digitar numero de autorización");
                this.JTPDatosIngreso.setSelectedIndex(1);
                this.txtNoAutorizacion.requestFocus();
            } else {
                retorno = 1;
            }
        } else if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            if (this.frmLlamador.equals("Facturac")) {
                if (this.frmFacturac.clasefacturacion.getXrecepcionalaboratorio() == 1) {
                    if (this.txtNombreA.getText().isEmpty()) {
                        this.metodos.mostrarMensaje("Debe registrar los datos del acompañante");
                        this.JTPDatosIngreso.setSelectedIndex(3);
                        this.txtNombreA.requestFocus();
                    } else if (this.txtNombreR.getText().isEmpty()) {
                        this.metodos.mostrarMensaje("Debe registrar los datos del responsable");
                        this.JTPDatosIngreso.setSelectedIndex(3);
                        this.txtNombreR.requestFocus();
                    } else if (this.cboParentescoR.getSelectedIndex() < 0) {
                        this.metodos.mostrarMensaje("Debe seleccionar el parentesco");
                        this.JTPDatosIngreso.setSelectedIndex(3);
                        this.cboParentescoR.requestFocus();
                    } else {
                        retorno = 1;
                    }
                } else {
                    retorno = 1;
                }
            } else if (this.txtNombreA.getText().trim().isEmpty()) {
                this.metodos.mostrarMensaje("Debe registrar los datos del acompañante");
                this.JTPDatosIngreso.setSelectedIndex(3);
                this.txtNombreA.requestFocus();
            } else if (this.txtNombreR.getText().trim().isEmpty()) {
                this.metodos.mostrarMensaje("Debe registrar los datos del responsable");
                this.JTPDatosIngreso.setSelectedIndex(3);
                this.txtNombreR.requestFocus();
            } else if (this.cboParentescoR.getSelectedIndex() < 0) {
                this.metodos.mostrarMensaje("Debe seleccionar el parentesco");
                this.JTPDatosIngreso.setSelectedIndex(3);
                this.cboParentescoR.requestFocus();
            } else if (this.JCBOcupaciones.getSelectedIndex() < 0) {
                this.metodos.mostrarMensaje("Debe seleccionar el la ocupacion");
                this.JTPDatosIngreso.setSelectedIndex(1);
                this.JCBOcupaciones.requestFocus();
            } else {
                retorno = 1;
            }
            if (this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getValidaCodigoAutorizacion().booleanValue()) {
                if (this.txtNoAutorizacion.getText().isEmpty()) {
                    this.metodos.mostrarMensaje("Debe digitar numero de autorización");
                    this.JTPDatosIngreso.setSelectedIndex(1);
                    this.txtNoAutorizacion.requestFocus();
                } else {
                    retorno = 1;
                }
            }
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL CIA LTDA") || Principal.informacionIps.getNombreIps().equals("IPS SU SALUD INTEGRAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            if (this.txtNombreA.getText().isEmpty()) {
                this.metodos.mostrarMensaje("Debe registrar los datos del acompañante");
                this.JTPDatosIngreso.setSelectedIndex(3);
                this.txtNombreA.requestFocus();
            } else if (this.txtNombreR.getText().isEmpty()) {
                this.metodos.mostrarMensaje("Debe registrar los datos del responsable");
                this.JTPDatosIngreso.setSelectedIndex(3);
                this.txtNombreR.requestFocus();
            } else if (this.cboParentescoR.getSelectedIndex() < 0) {
                this.metodos.mostrarMensaje("Debe seleccionar el parentesco");
                this.JTPDatosIngreso.setSelectedIndex(3);
                this.cboParentescoR.requestFocus();
            } else if (this.JCBOcupaciones.getSelectedIndex() < 0) {
                this.metodos.mostrarMensaje("Debe seleccionar el la ocupacion");
                this.JTPDatosIngreso.setSelectedIndex(1);
                this.JCBOcupaciones.requestFocus();
            } else if (this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getValidaCodigoAutorizacion().booleanValue() && this.txtNoAutorizacion.getText().isEmpty()) {
                this.metodos.mostrarMensaje("Debe digitar numero de autorización");
                this.JTPDatosIngreso.setSelectedIndex(1);
                this.txtNoAutorizacion.requestFocus();
            } else {
                retorno = 1;
            }
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
            if (this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getValidaCodigoAutorizacion().booleanValue()) {
                new ArrayList();
                List<IConsultarNumeroAutorizacionIngreso> autorizacionIngresos = this.ingresoService.consultarNumeroAutorizacionPorIngreso(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId(), this.txtNoAutorizacion.getText(), Long.valueOf(this.idIngreso));
                if (!autorizacionIngresos.isEmpty()) {
                    String xmensaje = "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Nº de autorización ya asaignado al ingreso Nº : " + autorizacionIngresos.get(0).getIdIngreso() + ",  con fecha : " + autorizacionIngresos.get(0).getFechaIngreso() + ",  usuario : " + autorizacionIngresos.get(0).getNombreUsuario() + " ;</p><font face='Arial' color='red' size=4>Favor verificar.";
                    JOptionPane.showInternalMessageDialog(this, xmensaje, "CONTROL NÚMERO DE AUTORIZACIONES", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    this.txtNoAutorizacion.setText("");
                }
            }
        }
    }

    public void actualizarIngresoCama(String idProceCama) {
        this.sql = "UPDATE ingreso SET cama ='" + getIdCama() + "' WHERE Id='" + getIdIngreso() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.frmFacturac.clasefacturacion.grabarOrdenCama(this.metodos.formatoAMD.format(this.txtFecha.getDate()), this.txtHora.getText(), getIdProfesional(), getIdEspecialidad(), idProceCama);
        this.frmFacturac.clasefacturacion.setCamaDisponible(1);
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
            this.metodos.getInterceptor(Long.valueOf(Principal.txtNo.getText()), "ANULACIÓN INGRESO", Observacion, false);
            Principal.txtEstado.setText("ANULADO");
        }
    }

    public void modificar(String idIngreso) {
        this.sql = "UPDATE ingreso SET HoraIngreso='" + this.txtHora.getText() + "',Id_EmpresaContxConv='" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId() + "',esCapitado='" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getEsCapitado() + "',SiCopago=" + this.xcopago + ",Id_Sede=" + Principal.sedeUsuarioSeleccionadaDTO.getId() + ",Id_Estrato=" + this.xidestrato[this.cboEstrato1.getSelectedIndex()][0] + ",Id_OrigenAdmision=" + this.cboOrigenIngreso.getPopupTable().getValueAt(this.cboOrigenIngreso.getSelectedIndex(), 0) + ",Id_CausaExterna=" + this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0) + ",Id_Especialidad=" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + ",Id_Profesional=" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + ",Id_TipoAtencion=" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + ",DxIngreso='0000'Id_Contrato=" + this.cboContrato.getPopupTable().getValueAt(this.cboContrato.getSelectedIndex(), 0) + ",NoPoliza='" + this.txtNoPoliza.getText() + "',NoAutorizacion='" + this.txtNoAutorizacion.getText() + "',EsAtencion='1'NAcompanante='" + this.txtNombreA.getText() + "',TelefonoAcomp='" + this.txtTelefonoA.getText() + "',NPersonaResp='" + this.txtNombreR.getText() + "',TelefonoPResp='" + this.txtTelefonoR.getText() + "',Id_Parentesco='" + this.cboParentescoR.getPopupTable().getValueAt(this.cboParentescoR.getSelectedIndex(), 0) + "',Observacion='" + this.JTAObservacion.getText() + "',idTipoAfiliacion='" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "',idTipoContratacion='" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "',idTipoCoberturaPlan='" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "',Fecha='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "',UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.getInterceptor(Long.valueOf(Principal.txtNo.getText()), "ACTUALIZACIÓN DATOS INGRESO", this.sql, false);
    }

    private void cambioEmpresa() {
        if (this.cboEmpresa.getSelectedIndex() > -1 && this.cboLleno == 1) {
            llenarCboDEmpresa();
            mLlenarComboEstrado();
            mLlenarComboTipoAfiliado();
            this.JCB_TipoContratacion.setSelectedItem(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getidTipoContratacion());
            this.JCB_TipoCoberturaPlan.setSelectedItem(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getidTipoCobertura());
            if (this.frmLlamador.equals("Facturac") && this.frmFacturac.panelMvto.getComponentCount() > 0 && this.frmFacturac.panelMvto.getComponent(0).getName().equals("Ordenes")) {
                this.frmFacturac.frmOrdenes.setidEmpresaCont(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId().toString());
                this.frmFacturac.frmOrdenes.setCualValor(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getCualValor());
                this.frmFacturac.frmOrdenes.setidPlanEmpresaCont(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getidTipoPlan());
                this.frmFacturac.frmOrdenes.setFiltroProcxEmp(String.valueOf(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getFiltroProcxEmp()));
                this.frmFacturac.frmOrdenes.setxRedondeo(String.valueOf(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getRedondeo()));
                this.frmFacturac.frmOrdenes.setxId_MetodoFac(String.valueOf(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getRedondeo()));
                this.idTipoPlanEmpresa = this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getidTipoPlan();
                this.frmFacturac.frmOrdenes.cargarCboservicio(String.valueOf(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId()));
                if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
                    this.frmFacturac.frmOrdenes.cboServicio.setSelectedIndex(0);
                } else if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                    this.frmFacturac.frmOrdenes.cboServicio.setSelectedItem("LABORATORIO");
                }
                llenarComboEmpresaMision(this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId().toString());
            }
            if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                this.cboEstrato1.setSelectedItem("ESPECIAL");
            }
        }
    }

    public void llenarComboEmpresaMision(String idConvenio) {
        this.listEmpresaMision = new ArrayList();
        this.JCBEmpresaMision.removeAllItems();
        EmpresaContConvenioEntity entity = new EmpresaContConvenioEntity();
        entity.setId(Integer.valueOf(idConvenio));
        this.listEmpresaMision = this.empresaEnMisionService.listaEmpresaEnMisionporIdConvenio(entity);
        if (!this.listEmpresaMision.isEmpty()) {
            this.utilidadesGenericas.llenarCombo(this.JCBEmpresaMision, this.listEmpresaMision);
        } else {
            this.JCBEmpresaMision.addItem("");
            this.JCBEmpresaMision.setSelectedIndex(0);
        }
    }

    public void llenarComboConvenio(int forma) {
        this.cboContrato.setModel(new DefaultComboBoxModel());
        this.cboEmpresa.setModel(new DefaultComboBoxModel());
        this.listConvenio = new ArrayList();
        if (this.JCH_AplicaFiltroConvenio.isSelected()) {
            if (this.frmCitaNP1 != null) {
                if (this.frmCitaNP1.frmPersona1.cboEps.getSelectedIndex() != -1) {
                    this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(Long.valueOf(this.frmCitaNP1.frmPersona1.listaEmpresa[this.frmCitaNP1.frmPersona1.cboEps.getSelectedIndex()][0]));
                } else {
                    this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(new Long(0L));
                }
            } else if (this.frmFacturac != null) {
                if (this.frmFacturac.frmPersona.cboEps.getSelectedIndex() != -1) {
                    this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(Long.valueOf(this.frmFacturac.frmPersona.listaEmpresa[this.frmFacturac.frmPersona.cboEps.getSelectedIndex()][0]));
                } else {
                    this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(new Long(0L));
                }
            } else if (this.frmAtencion != null) {
                if (this.frmAtencion.frmPersona.cboEps.getSelectedIndex() != -1) {
                    this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(Long.valueOf(this.frmAtencion.frmPersona.listaEmpresa[this.frmAtencion.frmPersona.cboEps.getSelectedIndex()][0]));
                } else {
                    this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(new Long(0L));
                }
            }
        } else {
            this.listConvenio = this.iEmpresaContConvenioService.getListEmpresaConvenio(new Long(0L));
        }
        this.listConvenio.forEach(e -> {
            this.cboEmpresa.addItem(e.getEmpresaContratante());
        });
        if (this.listConvenio.size() > 1) {
            this.cboEmpresa.setSelectedIndex(-1);
        }
        this.cboEmpresa.addPopupMenuListener(new CustomPopupMenuListener(true, false));
    }

    public final void cargarCombos() {
        this.cboLleno = 0;
        llenarComboConvenio(1);
        ConsultasMySQL xctx = new ConsultasMySQL();
        this.cboEspecialidad.removeAllItems();
        this.sql = "SELECT  g_especialidad.Id ,  g_especialidad.Nbre FROM g_profesionalespecial  INNER JOIN  g_especialidad ON ( g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE (g_especialidad.Estado =0 AND g_profesionalespecial.Estado =0) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC";
        this.xidEspecialidad = xctx.llenarCombo(this.sql, this.xidEspecialidad, this.cboEspecialidad);
        this.cboEspecialidad.setSelectedIndex(-1);
        this.cboProfesional.removeAllItems();
        xctx.cerrarConexionBd();
        this.consultas.llenarComboTabla("SELECT Id, Nbre as Origen_Ingreso FROM g_origenadmision where estado=1 ORDER BY Nbre ASC", this.cboOrigenIngreso, this.modcombos, 1);
        this.cboOrigenIngreso.setSelectedIndex(0);
        this.consultas.cerrarConexionBd();
        this.consultas.llenarComboTabla("SELECT Id, Nbre as Causa_Externa, Activar_Modulo FROM g_causaexterna WHERE Estado =0 ORDER BY Nbre ASC", this.cboCausaExterna, this.modcombos, 1);
        this.cboCausaExterna.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.consultas.llenarComboTabla("SELECT Id, Nbre as Parentesco FROM g_parentesco WHERE Estado =0 ORDER BY Nbre ASC", this.cboParentescoR, this.modcombos, 1);
        this.cboParentescoR.setSelectedItem("Otros");
        this.cboLleno = 1;
        this.cboEmpresa.setSelectedIndex(-1);
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
        this.xidocupaciones = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_ocupacion where Nivel=5 ORDER BY Nbre ASC", this.xidocupaciones, this.JCBOcupaciones);
        this.JCBOcupaciones.setSelectedIndex(-1);
        this.JCB_TipoContratacion.removeAllItems();
        this.sql = "SELECT id, nombre, estado FROM g_tipo_contratacion where estado =1 ORDER BY  nombre ASC";
        this.xidTipoContratacion = this.consultas.llenarComboyLista(this.sql, this.xidTipoContratacion, this.JCB_TipoContratacion, 3);
        this.JCB_TipoContratacion.setSelectedIndex(-1);
        this.JCB_TipoCoberturaPlan.removeAllItems();
        this.sql = "SELECT id, nombre, estado FROM f_tipo_cobertura_plan where estado =1 ORDER BY  nombre ASC";
        this.xidTipoCobertura = this.consultas.llenarComboyLista(this.sql, this.xidTipoCobertura, this.JCB_TipoCoberturaPlan, 3);
        this.JCB_TipoCoberturaPlan.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.xlleno = true;
        this.listGModalidadatencions = new ArrayList();
        LlenarCombosGenericos<GModalidadatencion> combosGenericos = new LlenarCombosGenericos<>();
        this.listGModalidadatencions = combosGenericos.getListComboLleno(this.JCBModalidadAtencion.getName());
        this.listGModalidadatencions.forEach(e -> {
            this.JCBModalidadAtencion.addItem(e.getNombre());
        });
        if (!this.listGModalidadatencions.isEmpty()) {
            this.JCBModalidadAtencion.setSelectedItem("Intramural");
        }
        this.listGEntornoAtencions = new ArrayList();
        LlenarCombosGenericos<GEntornoAtencion> combosGenericos1 = new LlenarCombosGenericos<>();
        this.listGEntornoAtencions = combosGenericos1.getListComboLleno(this.JCBEntornoAtencion.getName());
        this.listGEntornoAtencions.forEach(e2 -> {
            this.JCBEntornoAtencion.addItem(e2.getNombre());
        });
        if (!this.listGEntornoAtencions.isEmpty()) {
            this.JCBEntornoAtencion.setSelectedItem("Institucional");
        }
    }

    private void mLlenaCombo(String nombre) {
        this.JCBOcupaciones.removeAllItems();
        String sql = "SELECT Id,CONCAT(Id,' | ',`Nbre`) Nbre FROM g_ocupacion WHERE ((`Id` LIKE '%" + nombre + "%' or Nbre LIKE'%" + nombre + "%') and Estado = 0  and Nivel=4) ORDER BY Nbre ASC ";
        this.xidocupaciones = this.consultas.llenarCombo(sql, this.xidocupaciones, this.JCBOcupaciones);
        this.consultas.cerrarConexionBd();
    }

    private void cargarCboPablellon() {
        this.cboUnidadCamas.setEnabled(true);
        this.consultas.llenarComboTabla("SELECT Id , Nbre as Pabellon FROM f_unidadcama WHERE (Estado =0) order by Pabellon ", this.cboUnidadCamas, this.modcombos, 1);
        this.consultas.cerrarConexionBd();
    }

    private void cargarCboCama() {
        if (this.cboUnidadCamas.getSelectedIndex() > -1) {
            this.sql = "SELECT f_camas.Id , f_camas.Nbre AS Cama , IF(f_camas.TipoHab=1,'UniPersonal',IF(f_camas.TipoHab=2,'BiPersonal',IF(f_camas.TipoHab=3,'Tres Camas','Cuatro ó Mas Camas'))) AS Tipo_Hab, f_camas.Id_Procedimiento AS IdProc, IF(f_camas.Disponible=0,'Disponible','Ocupada') as Disponible FROM f_camas INNER JOIN f_unidadcama ON (f_camas.Id_UnidadCamas = f_unidadcama.Id) WHERE (f_camas.Estado =0  AND f_camas.Id_UnidadCamas = " + getIdUnidadCama() + ") order by Cama";
            this.cboCamas.setEnabled(true);
            this.consultas.llenarComboTabla(this.sql, this.cboCamas, this.modcombos, 1);
            this.consultas.cerrarConexionBd();
        }
    }

    private void cargarCboProfesional() {
        if (this.cboEspecialidad.getSelectedIndex() > -1 && this.xlleno) {
            ConsultasMySQL xctr = new ConsultasMySQL();
            this.cboProfesional.removeAllItems();
            this.sql = "select gp.Id_Persona , concat(gp2.Apellido1,' ', gp2.Apellido2,' ', gp2.Nombre1 ,' ', gp2.Nombre2) as NProfesional\nfrom g_profesional gp \ninner join g_persona gp2  on (gp2.Id=gp.Id_Persona)\ninner join g_profesionalespecial gp3 on (gp3.Id_Profesional=gp.Id_Persona)\nwhere gp.P_Ips =1 and gp.Estado =0 and gp3.Id_Especialidad ='" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "'\norder by NProfesional asc";
            this.xIdProfesional = xctr.llenarCombo(this.sql, this.xIdProfesional, this.cboProfesional);
            xctr.cerrarConexionBd();
            if (Principal.informacionIps.getIdentificacion().equals("8296850")) {
                this.cboProfesional.setSelectedIndex(0);
            } else if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
                this.cboProfesional.setSelectedItem("NO ASIGNADO");
            }
        }
    }

    private void cambioCboEspecialidad() {
        switch (this.frmLlamador) {
            case "Facturac":
                if ((getAmbitoAtencion().equals("0") || getAmbitoAtencion().equals("1")) && this.frmFacturac.panelMvto.getComponentCount() > 0 && this.frmFacturac.panelMvto.getComponent(0).getName().equals("Ordenes")) {
                    this.cboProfesional.removeAllItems();
                    cargarCboProfesional();
                    break;
                }
                break;
            case "CitaNP":
                if (this.cboTipoAtencion.getSelectedIndex() != -1 && this.cboEspecialidad.getSelectedIndex() != -1 && this.xlleno) {
                    if (this.frmCitaNP1.frmPersona1.getIdPersona().equals("0")) {
                        this.frmCitaNP1.cargarClaseCita(0, "", "");
                    } else {
                        this.frmCitaNP1.cargarClaseCita(1, this.metodos.formatoAMD1.format(this.frmCitaNP1.frmPersona1.cboFechaNacimiento.getDate()), this.frmCitaNP1.frmPersona1.getIdSexo());
                    }
                    this.frmCitaNP1.cargarPacientesAgendados();
                    break;
                }
                break;
            case "Atencion":
                if (this.cboTipoAtencion.getSelectedIndex() != -1 && this.cboEspecialidad.getSelectedIndex() != -1 && this.xlleno) {
                    this.frmAtencion.cargarClaseCita(getIdEspecialidad());
                    break;
                }
                break;
        }
    }

    private void cambioCboProfesional() {
    }

    public void mCargarDatosAdicionales() {
        String xidusuario;
        try {
            xidusuario = null;
            ConsultasMySQL xct = new ConsultasMySQL();
            switch (this.frmLlamador) {
                case "Facturac":
                    xidusuario = this.frmFacturac.frmPersona.getIdPersona();
                    break;
                case "CitaNP":
                    xidusuario = this.frmCitaNP1.frmPersona1.getIdPersona();
                    break;
                case "Atencion":
                    xidusuario = this.frmAtencion.frmPersona.getIdPersona();
                    break;
            }
            this.sql = "SELECT \n`ingreso`.NAcompanante nombreAcompanante,  \n`ingreso`.TelefonoAcomp  telefonoAcompanante, \ningreso.ParentezcoAcomp nombreParentescoAcompanante, \ningreso.TipoDocA  tipoDocumentoAcompanante,\ningreso.NoDocA  numeroDocumentoAcompanante,\n`g_ocupacion`.`Nbre` ocupacion, \n`g_nivelestudio`.`Nbre` nivelEstudio, \ningreso.Observacion,\ningreso.NPersonaResp nombreResponable, \ningreso.TelefonoPResp telefonoResponable ,\ningreso.TipDoc tipoDocumentoResponable,\ningreso.NoDocumento as numeroDocumentoResponable ,  \n`g_parentesco`.`Nbre` nombreParentescoResposable\nFROM ingreso INNER JOIN  `g_ocupacion` ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)\nINNER JOIN  `g_parentesco`  ON (`ingreso`.`Id_Parentesco` = `g_parentesco`.`Id`) \nINNER JOIN `g_nivelestudio` ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`) \nWHERE (`ingreso`.`Id_Usuario` =" + xidusuario + ") ORDER BY `ingreso`.`Id` DESC ";
            ResultSet xrs = xct.traerRs(this.sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        xrs.first();
                        this.txtNombreR.setText(xrs.getString("nombreResponable"));
                        this.txtTelefonoR.setText(xrs.getString("telefonoResponable"));
                        this.cboParentescoR.setSelectedItem(xrs.getString("nombreParentescoResposable"));
                        this.JCBTipoDocResp.setSelectedItem(xrs.getString("tipoDocumentoResponable"));
                        this.JTFNoDocu.setText(xrs.getString("numeroDocumentoResponable"));
                        this.txtNombreA.setText(xrs.getString("nombreAcompanante"));
                        this.JCBTipoDocAcop.setSelectedItem(xrs.getString("tipoDocumentoAcompanante"));
                        this.txtCedulaA.setText(xrs.getString("numeroDocumentoAcompanante"));
                        this.JCBParentescoAcompaniante.setSelectedItem(xrs.getString("nombreParentescoAcompanante"));
                        this.txtTelefonoA.setText(xrs.getString("telefonoAcompanante"));
                        this.JCBOcupaciones.setSelectedItem(xrs.getString("ocupacion"));
                        this.JCBEscolaridad.setSelectedItem(xrs.getString("nivelEstudio"));
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void cargarIngreso(String idIngreso) {
        this.JCH_AplicaFiltroConvenio.setSelected(false);
        llenarComboConvenio(2);
        this.sql = "SELECT ingreso.Id, ingreso.FechaIngreso, ingreso.HoraIngreso, f_empresacontxconvenio.Nbre AS Empresa, ingreso.SiCopago, f_estrato.Nbre AS Estrato, g_origenadmision.Nbre AS OrigenAdmision, g_especialidad.Nbre AS Especialidad, w_profesional.NProfesional AS Profesional, g_tipoatencion.Nbre AS TipoAtencion, f_unidadcama.Nbre AS Pabellon, f_camas.Nbre AS Cama, ingreso.NoPoliza AS Poliza, ingreso.NoAutorizacion AS Autorizacion, g_contratos.Nbre_Contrato AS Contrato, ingreso.NAcompanante, ingreso.TelefonoAcomp, ingreso.NPersonaResp, ingreso.TelefonoPResp, g_parentesco.Nbre AS Parestesco, ingreso.Estado , UCASE(g_nivelestudio.Nbre), g_ocupacion.Nbre Ocupaciones, `g_causaexterna`.`Nbre` AS causa , `a_condvictima`.`Nbre` AS CondVict, ingreso.ParentezcoAcomp, ingreso.TipDoc, ingreso.NoDocumento, ingreso.DxIngreso, ingreso.TipoDocA , ingreso.NoDocA, ingreso.Observacion, ingreso.NMuestra,  ifnull(f_liquidacion.Id,0) idLiquidacion,\nifnull(f_factura_capita.No_FacturaCapita,0) numeroFacturaCapita,\nifnull(IF ( `cc_resolucion_dian`.`trasmision`= 0 ,f_factura_evento.No_FacturaEvento,f_factura_evento.`No_FacturaEvento_M`),0) numeroFacturaEvento, \n(ifnull(f_factura_capita.EstaArmada,0)+ifnull(f_factura_evento.EstaArmada,0)) estadoArmado,\nGROUP_CONCAT(f_ordenes.Id SEPARATOR ',') idOrdenes, \n-- ifnull(h_atencion.Id,0) idAtencion\n IF(IFNULL(h_atencion.Id,0)<>0,IF(h_atencion.Codigo_Dxp=''||h_atencion.Codigo_Dxp IS NULL,0,h_atencion.Id),h_atencion.Id) idAtencion, g_tipoafiliado.Nbre TipoAfiliado, g_tipo_contratacion.nombre idTipoContratacion, f_tipo_cobertura_plan.nombre idTipoCobertura\n, ingreso.`siras`, gma.nombre  modalidadAtencion, gea.nombre entornoAtencion, gsig.nombre identidadGenero, gtd.nombre categoriaDiscapacidad \n, ifnull(gp.Nbre, '') nombrePatologiaPrincipal\n, ifnull(gp1.Id ,'') codigoPatologiaR1\n, ifnull(gp1.Nbre,'') nombrePatologiaR1\n, ifnull(gp2.Id ,'') codigoPatologiaR2\n, ifnull(gp2.Nbre,'') nombrePatologiaR2\n, ifnull(gp3.Id ,'') codigoPatologiaR3\n, ifnull(gp3.Nbre,'') nombrePatologiaR3\nFROM ingreso \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nINNER JOIN f_estrato ON (ingreso.Id_Estrato = f_estrato.Id) \nINNER JOIN g_causaexterna ON (ingreso.Id_CausaExterna = g_causaexterna.Id) \nINNER JOIN g_contratos ON (ingreso.Id_Contrato = g_contratos.Id) \nINNER JOIN g_origenadmision ON (ingreso.Id_OrigenAdmision = g_origenadmision.Id)\nINNER JOIN w_profesional ON (ingreso.Id_Profesional = w_profesional.Id_Persona)  AND (w_profesional.`IdEspecialidad`=ingreso.`Id_Especialidad`) \nINNER JOIN g_especialidad ON (ingreso.Id_Especialidad = g_especialidad.Id) \nINNER JOIN g_ocupacion ON (ingreso.Id_Ocupacion = g_ocupacion.Id) \nINNER JOIN g_nivelestudio ON (ingreso.Id_NivelEstudio = g_nivelestudio.Id)\nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nINNER JOIN g_parentesco ON (ingreso.Id_Parentesco = g_parentesco.Id)\nINNER JOIN g_tipoafiliado ON (g_tipoafiliado.Id = ingreso.idTipoAfiliacion)\nINNER JOIN g_tipo_contratacion ON (ingreso.idTipoContratacion = g_tipo_contratacion.id)\nINNER JOIN f_tipo_cobertura_plan ON (ingreso.idTipoCoberturaPlan = f_tipo_cobertura_plan.id)\n inner join g_modalidad_atencion gma on (ingreso.idModalidad=gma.id)\ninner join g_entorno_atencion gea on (ingreso.idEntornoAtencion=gea.id)\ninner join g_sexo_identidad_genero gsig on (ingreso.idIdentidadG=gsig.id)\ninner join g_tipo_discapacidad gtd on (ingreso.idTipoDiscapacidad=gtd.id)\nLEFT JOIN f_camas ON (ingreso.Cama = f_camas.Id) \nLEFT JOIN f_unidadcama ON (f_camas.Id_UnidadCamas = f_unidadcama.Id)\nLEFT JOIN `a_condvictima`  ON (`ingreso`.`Id_CondVict` = `a_condvictima`.`Id`)  \nleft join f_liquidacion on (f_liquidacion.Id_Ingreso=ingreso.Id) and (f_liquidacion.Estado=0)\nleft join f_factura_capita on (f_liquidacion.Id=f_factura_capita.Id_Liquidacion) and (f_factura_capita.Estado=0)\nleft join f_factura_evento on (f_liquidacion.Id=f_factura_evento.Id_Liquidacion) and (f_factura_evento.Estado=0)\nleft join f_ordenes on (f_ordenes.Id_Ingreso=ingreso.Id) and (f_ordenes.Estado=0) \n left join h_atencion on (h_atencion.Id_Ingreso=ingreso.Id) and (h_atencion.Codigo_Dxp<>'' || h_atencion.Codigo_Dxp<>'0000')\n left JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`)\nleft join g_patologia gp on (gp.Id = ingreso.DxIngreso )\nleft join g_patologia gp1 on (gp1.Id = ingreso.CodigoDx1 )\nleft join g_patologia gp2 on (gp2.Id = ingreso.CodigoDx2 )\nleft join g_patologia gp3 on (gp3.Id = ingreso.CodigoDx3 )\nWHERE (ingreso.Id =" + idIngreso + ")";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(this.sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.txtFecha.setDate(xrs.getDate("FechaIngreso"));
                this.txtHora.setText(xrs.getString("HoraIngreso"));
                this.cboEmpresa.setSelectedItem(xrs.getString("Empresa"));
                if (xrs.getInt("SiCopago") == 0) {
                    this.btnCModeradora.setSelected(true);
                    btnCModeradoraActionPerformed(null);
                } else {
                    this.btnCopago.setSelected(true);
                    btnCopagoActionPerformed(null);
                }
                this.JCBModalidadAtencion.setSelectedItem(xrs.getString("modalidadAtencion"));
                this.JCBEntornoAtencion.setSelectedItem(xrs.getString("entornoAtencion"));
                this.cboEstrato1.setSelectedItem(xrs.getString(6));
                this.cboOrigenIngreso.setSelectedItem(xrs.getString(7));
                this.cboTipoAtencion.setSelectedItem(xrs.getString(10));
                this.cboLleno = 0;
                this.cboEspecialidad.setSelectedItem(xrs.getString(8));
                this.cboLleno = 1;
                this.cboProfesional.setSelectedItem(xrs.getString(9));
                this.txtNoPoliza.setText(xrs.getString(13));
                this.txtNoAutorizacion.setText(xrs.getString(14));
                this.cboContrato.setSelectedItem(xrs.getString(15));
                this.txtNombreA.setText(xrs.getString(16));
                this.txtTelefonoA.setText(xrs.getString(17));
                this.txtNombreR.setText(xrs.getString(18));
                this.txtTelefonoR.setText(xrs.getString(19));
                this.cboParentescoR.setSelectedItem(xrs.getString(20));
                this.cboCausaExterna.setSelectedItem(xrs.getString(24));
                this.JCBCondVict.setSelectedItem(xrs.getString(25));
                this.JTFCie10.setText(xrs.getString("DxIngreso"));
                this.JTF_DNombre.setText(xrs.getString("nombrePatologiaPrincipal"));
                this.JTFCDxR1.setText(xrs.getString("codigoPatologiaR1"));
                this.JTFNDxR1.setText(xrs.getString("nombrePatologiaR1"));
                this.JTFCDxR2.setText(xrs.getString("codigoPatologiaR2"));
                this.JTFNDxR2.setText(xrs.getString("nombrePatologiaR2"));
                this.JTFCDxR3.setText(xrs.getString("codigoPatologiaR3"));
                this.JTFNDxR3.setText(xrs.getString("nombrePatologiaR3"));
                setIdIngreso(idIngreso);
                this.JCBEscolaridad.setSelectedItem(xrs.getString(22));
                this.JCBOcupaciones.setSelectedItem(xrs.getString(23));
                switch (this.frmLlamador) {
                    case "Facturac":
                        this.frmFacturac.btnConsolidado.setEnabled(true);
                        setCargarTitulos(idIngreso, this.metodos.formatoDMA.format((Date) xrs.getDate(2)), xrs.getInt(21));
                        break;
                    case "CitaNP":
                        setCargarTitulos(idIngreso, this.metodos.formatoDMA.format((Date) xrs.getDate(2)), xrs.getInt(21));
                        break;
                    default:
                        this.frmAtencion.cargarTriage(Long.valueOf(idIngreso));
                        break;
                }
                this.JCHEsNuevaMuestra.setSelected(xrs.getBoolean("NMuestra"));
                this.xEsNuevaMuestra = xrs.getInt("NMuestra");
                setCargarTitulos(idIngreso, this.metodos.formatoDMA.format((Date) xrs.getDate(2)), xrs.getInt(21));
                this.JCBParentescoAcompaniante.setSelectedItem(xrs.getString("ParentezcoAcomp"));
                this.JCBTipoDocResp.setSelectedItem(xrs.getString("TipDoc"));
                this.JTFNoDocu.setText(xrs.getString("NoDocumento"));
                this.JCBTipoDocAcop.setSelectedItem(xrs.getString("TipoDocA"));
                this.txtCedulaA.setText(xrs.getString("NoDocA"));
                this.JTAObservacion.setText(xrs.getString("Observacion"));
                this.xlleno2 = true;
                setIdLiquidacion(Long.valueOf(xrs.getLong("idLiquidacion")));
                setIdFacturaCapita(Long.valueOf(xrs.getLong("numeroFacturaCapita")));
                setIdFacturaEvento(Long.valueOf(xrs.getLong("numeroFacturaEvento")));
                setEstadoFacturaOrdenes(Integer.valueOf(xrs.getInt("estadoArmado")));
                setIdOrdenes(xrs.getString("idOrdenes"));
                setIdAtencion(Long.valueOf(xrs.getLong("idAtencion")));
                this.JCBTipoAfiliado.setSelectedItem(xrs.getString("TipoAfiliado"));
                this.JCB_TipoContratacion.setSelectedItem(xrs.getString("idTipoContratacion"));
                this.JCB_TipoCoberturaPlan.setSelectedItem(xrs.getString("idTipoCobertura"));
                this.txtSiras.setText(xrs.getString("siras"));
                switch (this.frmLlamador) {
                    case "Facturac":
                        this.frmFacturac.frmPersona.JCBIdentidadGenero.setSelectedItem(xrs.getString("identidadGenero"));
                        this.frmFacturac.frmPersona.JCBCategoriaDiscapacidad.setSelectedItem(xrs.getString("categoriaDiscapacidad"));
                        break;
                    case "Atencion":
                        this.frmAtencion.frmPersona.JCBIdentidadGenero.setSelectedItem(xrs.getString("identidadGenero"));
                        this.frmAtencion.frmPersona.JCBCategoriaDiscapacidad.setSelectedItem(xrs.getString("categoriaDiscapacidad"));
                        break;
                    case "CitaNP":
                        this.frmCitaNP1.frmPersona1.JCBIdentidadGenero.setSelectedItem(xrs.getString("identidadGenero"));
                        this.frmCitaNP1.frmPersona1.JCBCategoriaDiscapacidad.setSelectedItem(xrs.getString("categoriaDiscapacidad"));
                        break;
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void evaluarTipoAtencion() {
        if ((this.frmLlamador.equals("Facturac") || this.frmLlamador.equals("CitaNP") || this.frmLlamador.equals("Atencion")) && this.cboTipoAtencion.getSelectedIndex() > -1) {
            if (this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString().equals("5") || this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString().equals("6")) {
                setAmbitoAtencion("2");
            } else {
                setAmbitoAtencion(this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString());
            }
            switch (getAmbitoAtencion()) {
                case "1":
                case "4":
                    this.cboUnidadCamas.setEnabled(false);
                    this.cboCamas.setEnabled(false);
                    this.cboOrigenIngreso.setSelectedIndex(0);
                    break;
                case "3":
                    this.cboUnidadCamas.setEnabled(false);
                    this.cboCamas.setEnabled(false);
                    this.cboOrigenIngreso.setSelectedItem("Urgencias");
                    break;
                case "2":
                    if (this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 3).toString().equals("true")) {
                        cargarCboPablellon();
                        break;
                    } else {
                        this.cboUnidadCamas.setEnabled(false);
                        this.cboCamas.setEnabled(false);
                        this.cboOrigenIngreso.setSelectedIndex(0);
                        break;
                    }
                    break;
            }
            cambioCboEspecialidad();
        }
    }

    public void grabar(String idPersona) {
        this.sql = "INSERT INTO ingreso (Id_Usuario, FechaIngreso, HoraIngreso, Id_EmpresaContxConv ,esCapitado,Id_Sede, SiCopago,NMuestra, siras,Id_Estrato, Id_OrigenAdmision, Id_CausaExterna, Id_Especialidad, Id_Profesional, Id_TipoAtencion, DxIngreso, CodigoDx1, CodigoDx2, CodigoDx3, CEspecial, Id_Contrato, NoPoliza, NoAutorizacion, EsAtencion, NAcompanante, TelefonoAcomp,ParentezcoAcomp, NPersonaResp, TelefonoPResp,TipDoc,NoDocumento, Id_NivelEstudio, Id_Parentesco, Id_Ocupacion, subEmpresa, SO_Cargo, SO_Supervisor, SO_SEG, SO_Jornada,  HorasTrabajadas , SO_Arl, SO_Grupo, SO_Lateralidad , NoHijos, ClaseSE , SO_FechaIngreso,SO_UNegocio, Tipo_Empresa, Fecha, Id_CondVict,TipoDocA,NoDocA, NEntidad, Observacion, idTipoAfiliacion, idTipoContratacion, idTipoCoberturaPlan, UsuarioS, idIdentidadG, idTipoDiscapacidad, idModalidad, idEntornoAtencion, idTipoDoc, numeroDocumento) VALUES('" + idPersona + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.txtHora.getValue()) + "','" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId() + "','" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getEsCapitado() + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.xcopago + "','" + this.xEsNuevaMuestra + "','" + this.txtSiras.getText() + "','" + this.xidestrato[this.cboEstrato1.getSelectedIndex()][0] + "','" + this.cboOrigenIngreso.getPopupTable().getValueAt(this.cboOrigenIngreso.getSelectedIndex(), 0) + "','" + this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0) + "','" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "','" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + "','" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + "','" + this.JTFCie10.getText().toUpperCase() + "','" + this.JTFCDxR1.getText().toUpperCase() + "','" + this.JTFCDxR2.getText().toUpperCase() + "','" + this.JTFCDxR3.getText().toUpperCase() + "','" + Principal.informacionGeneralPrincipalDTO.getAtencionPreferencial() + "','" + this.cboContrato.getPopupTable().getValueAt(this.cboContrato.getSelectedIndex(), 0) + "','" + this.txtNoPoliza.getText() + "','" + this.txtNoAutorizacion.getText() + "','1','" + this.txtNombreA.getText() + "','" + this.txtTelefonoA.getText() + "','" + this.JCBParentescoAcompaniante.getSelectedItem() + "','" + this.txtNombreR.getText() + "','" + this.txtTelefonoR.getText() + "','" + this.JCBTipoDocResp.getSelectedItem() + "','" + this.JTFNoDocu.getText() + "','" + this.JCBEscolaridad.getPopupTable().getValueAt(this.JCBEscolaridad.getSelectedIndex(), 0) + "','" + this.cboParentescoR.getPopupTable().getValueAt(this.cboParentescoR.getSelectedIndex(), 0) + "','" + this.xidocupaciones[this.JCBOcupaciones.getSelectedIndex()] + "','" + this.JCBEmpresaMision.getSelectedItem();
        switch (this.frmLlamador) {
            case "Facturac":
                this.sql += "','" + this.frmFacturac.frmPersona.JCBCargo.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBSupervisor.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBSegmento.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBJornada.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JSPNHorasTrabajadas.getValue() + "','" + this.frmFacturac.frmPersona.JCBArl.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBGrupo.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBLateralidad.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JSPNHijos.getValue() + "','" + this.frmFacturac.frmPersona.JSPNClaSE.getValue() + "','" + this.metodos.formatoAMD.format(this.frmFacturac.frmPersona.JDFechaIngreso.getDate()) + "','" + this.frmFacturac.frmPersona.JCBUnidadN.getSelectedItem() + "','" + this.frmFacturac.frmPersona.cboTipoEmpresa.getSelectedItem() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.xCondiVict + "','" + this.JCBTipoDocAcop.getSelectedItem() + "','" + this.txtCedulaA.getText() + "','" + this.frmFacturac.frmPersona.cboEps.getSelectedItem() + "','" + this.JTAObservacion.getText() + "','" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "','" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "','" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.frmFacturac.frmPersona.listGSexoIdentidadGenero.get(this.frmFacturac.frmPersona.JCBIdentidadGenero.getSelectedIndex()).getId() + "','" + this.frmFacturac.frmPersona.listGTipoDiscapacidad.get(this.frmFacturac.frmPersona.JCBCategoriaDiscapacidad.getSelectedIndex()).getId() + "','" + this.listGModalidadatencions.get(this.JCBModalidadAtencion.getSelectedIndex()).getId() + "','" + this.listGEntornoAtencions.get(this.JCBEntornoAtencion.getSelectedIndex()).getId() + "','" + this.frmFacturac.frmPersona.getIdTipoIdentifiacion() + "','" + this.frmFacturac.frmPersona.txtIdentificacion.getText() + "')";
                mActualizarCamposUsuario(this.frmFacturac.frmPersona.cboEtnia.getSelectedItem().toString(), this.frmFacturac.frmIngreso.JCBEscolaridad.getSelectedItem().toString(), this.frmFacturac.frmIngreso.JCBOcupaciones.getSelectedItem().toString(), this.frmFacturac.frmPersona.txtCorreo.getText(), idPersona);
                break;
            case "Atencion":
                this.sql += "','" + this.frmAtencion.frmPersona.JCBCargo.getSelectedItem() + "','" + this.frmAtencion.frmPersona.JCBSupervisor.getSelectedItem() + "','" + this.frmAtencion.frmPersona.JCBSegmento.getSelectedItem() + "','" + this.frmAtencion.frmPersona.JCBJornada.getSelectedItem() + "','" + this.frmAtencion.frmPersona.JSPNHorasTrabajadas.getValue() + "','" + this.frmAtencion.frmPersona.JCBArl.getSelectedItem() + "','" + this.frmAtencion.frmPersona.JCBGrupo.getSelectedItem() + "','" + this.frmAtencion.frmPersona.JCBLateralidad.getSelectedItem() + "','" + this.frmAtencion.frmPersona.JSPNHijos.getValue() + "','" + this.frmAtencion.frmPersona.JSPNClaSE.getValue() + "','" + this.metodos.formatoAMD.format(this.frmAtencion.frmPersona.JDFechaIngreso.getDate()) + "','" + this.frmAtencion.frmPersona.JCBUnidadN.getSelectedItem() + "','" + this.frmAtencion.frmPersona.cboTipoEmpresa.getSelectedItem() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.xCondiVict + "','" + this.JCBTipoDocAcop.getSelectedItem() + "','" + this.txtCedulaA.getText() + "','" + this.frmAtencion.frmPersona.cboEps.getSelectedItem() + "','" + this.JTAObservacion.getText() + "','" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "','" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "','" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.frmAtencion.frmPersona.listGSexoIdentidadGenero.get(this.frmAtencion.frmPersona.JCBIdentidadGenero.getSelectedIndex()).getId() + "','" + this.frmAtencion.frmPersona.listGTipoDiscapacidad.get(this.frmAtencion.frmPersona.JCBCategoriaDiscapacidad.getSelectedIndex()).getId() + "','" + this.listGModalidadatencions.get(this.JCBModalidadAtencion.getSelectedIndex()).getId() + "','" + this.listGEntornoAtencions.get(this.JCBEntornoAtencion.getSelectedIndex()).getId() + "','" + this.frmAtencion.frmPersona.getIdTipoIdentifiacion() + "','" + this.frmAtencion.frmPersona.txtIdentificacion.getText() + "')";
                mActualizarCamposUsuario(this.frmAtencion.frmPersona.cboEtnia.getSelectedItem().toString(), this.frmAtencion.frmIngreso.JCBEscolaridad.getSelectedItem().toString(), this.frmAtencion.frmIngreso.JCBOcupaciones.getSelectedItem().toString(), this.frmAtencion.frmPersona.txtCorreo.getText(), idPersona);
                break;
            case "CitaNP":
                this.sql += "','" + this.frmCitaNP1.frmPersona1.JCBCargo.getSelectedItem() + "','" + this.frmCitaNP1.frmPersona1.JCBSupervisor.getSelectedItem() + "','" + this.frmCitaNP1.frmPersona1.JCBSegmento.getSelectedItem() + "','" + this.frmCitaNP1.frmPersona1.JCBJornada.getSelectedItem() + "','" + this.frmCitaNP1.frmPersona1.JSPNHorasTrabajadas.getValue() + "','" + this.frmCitaNP1.frmPersona1.JCBArl.getSelectedItem() + "','" + this.frmCitaNP1.frmPersona1.JCBGrupo.getSelectedItem() + "','" + this.frmCitaNP1.frmPersona1.JCBLateralidad.getSelectedItem() + "','" + this.frmCitaNP1.frmPersona1.JSPNHijos.getValue() + "','" + this.frmCitaNP1.frmPersona1.JSPNClaSE.getValue() + "','" + this.metodos.formatoAMD.format(this.frmCitaNP1.frmPersona1.JDFechaIngreso.getDate()) + "','" + this.frmCitaNP1.frmPersona1.JCBUnidadN.getSelectedItem() + "','" + this.frmCitaNP1.frmPersona1.cboTipoEmpresa.getSelectedItem() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.xCondiVict + "','" + this.JCBTipoDocAcop.getSelectedItem() + "','" + this.txtCedulaA.getText() + "','" + this.frmCitaNP1.frmPersona1.cboEps.getSelectedItem() + "','" + this.JTAObservacion.getText() + "','" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "','" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "','" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.frmCitaNP1.frmPersona1.listGSexoIdentidadGenero.get(this.frmCitaNP1.frmPersona1.JCBIdentidadGenero.getSelectedIndex()).getId() + "','" + this.frmCitaNP1.frmPersona1.listGTipoDiscapacidad.get(this.frmCitaNP1.frmPersona1.JCBCategoriaDiscapacidad.getSelectedIndex()).getId() + "','" + this.listGModalidadatencions.get(this.JCBModalidadAtencion.getSelectedIndex()).getId() + "','" + this.listGEntornoAtencions.get(this.JCBEntornoAtencion.getSelectedIndex()).getId() + "','" + this.frmCitaNP1.frmPersona1.getIdTipoIdentifiacion() + "','" + this.frmCitaNP1.frmPersona1.txtIdentificacion.getText() + "')";
                mActualizarCamposUsuario(this.frmCitaNP1.frmPersona1.cboEtnia.getSelectedItem().toString(), this.frmCitaNP1.frmIngreso.JCBEscolaridad.getSelectedItem().toString(), this.frmCitaNP1.frmIngreso.JCBOcupaciones.getSelectedItem().toString(), this.frmCitaNP1.frmPersona1.txtCorreo.getText(), idPersona);
                break;
        }
        setIdIngreso(this.consultas.ejecutarSQLId(this.sql));
        this.metodos.getInterceptor(Long.valueOf(getIdIngreso()), "GRABAR INGRESO", "Se graba información del ingreso", false);
        this.consultas.cerrarConexionBd();
        if (this.frmLlamador.equals("Facturac")) {
            mActualizaIngresoenVacunas();
            if (!this.frmFacturac.frmOrdenes.getXidclasecita().equals("0") && Principal.txtNo.getText().isEmpty()) {
                if (this.xTratamiento.equals("0")) {
                    mGrabarAtencion();
                } else {
                    mActualizaIngresoenCitas();
                }
            }
            if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") && Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") && Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") && !Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") && !Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
                mGrabarValidacion();
            }
        }
    }

    public void mActualizaIngresoenVacunas() {
        ConsultasMySQL xct = new ConsultasMySQL();
        String sql2 = "UPDATE `p_vacunacion_carnet`  SET   `IdIngreso` = '" + getIdIngreso() + "' WHERE  `IdPaciente` = '" + this.frmFacturac.frmPersona.getIdPersona() + "' AND IdIngreso='0'";
        xct.ejecutarSQL(sql2);
        xct.cerrarConexionBd();
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
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void grabar1(String idPersona) {
        this.sql = "INSERT INTO ingreso (Id_Usuario, FechaIngreso, HoraIngreso, Id_EmpresaContxConv ,esCapitado,Id_Sede, SiCopago,NMuestra, siras Id_Estrato, Id_OrigenAdmision, Id_CausaExterna, Id_Especialidad, Id_Profesional, Id_TipoAtencion, DxIngreso, CodigoDx1, CodigoDx2, CodigoDx3 Id_Contrato, NoPoliza, NoAutorizacion, EsAtencion, NAcompanante, TelefonoAcomp,ParentezcoAcomp, NPersonaResp, TelefonoPResp,TipDoc,NoDocumento, Id_NivelEstudio, Id_Parentesco, Id_Ocupacion,`SO_Cargo`, `SO_Supervisor`, `SO_SEG`, `SO_Jornada`, `HorasTrabajadas` , `SO_Arl`, `SO_Grupo`, `SO_Lateralidad` , `NoHijos`, `ClaseSE` , `SO_FechaIngreso`, SO_UNegocio,Tipo_Empresa, Fecha,Id_CondVict,TipoDocA,NoDocA, Observacion, idTipoAfiliacion, idTipoContratacion, idTipoCoberturaPlan, UsuarioS) VALUES('" + idPersona + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.txtHora.getValue()) + "','" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId() + "','" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getEsCapitado() + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.xcopago + "','" + this.xEsNuevaMuestra + "','" + this.txtSiras.getText() + "','11','" + this.cboOrigenIngreso.getPopupTable().getValueAt(this.cboOrigenIngreso.getSelectedIndex(), 0) + "','" + this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0) + "','" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "','" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + "','" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + "','" + this.JTFCie10.getText().toUpperCase() + "','" + this.JTFCDxR1.getText().toUpperCase() + "','" + this.JTFCDxR2.getText().toUpperCase() + "','" + this.JTFCDxR3.getText().toUpperCase() + "','" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getidContrato() + "','" + this.txtNoPoliza.getText() + "','" + this.txtNoAutorizacion.getText() + "','1','" + this.txtNombreA.getText() + "','" + this.txtTelefonoA.getText() + "','" + this.JCBParentescoAcompaniante.getSelectedItem() + "','" + this.txtNombreR.getText() + "','" + this.txtTelefonoR.getText() + "','" + this.JCBTipoDocResp.getSelectedItem() + "','" + this.JTFNoDocu.getText() + "','" + this.JCBEscolaridad.getPopupTable().getValueAt(this.JCBEscolaridad.getSelectedIndex(), 0) + "','" + this.cboParentescoR.getPopupTable().getValueAt(this.cboParentescoR.getSelectedIndex(), 0) + "','" + this.xidocupaciones[this.JCBOcupaciones.getSelectedIndex()] + "','" + this.frmFacturac.frmPersona.JCBCargo.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBSupervisor.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBSegmento.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBJornada.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JSPNHorasTrabajadas.getValue() + "','" + this.frmFacturac.frmPersona.JCBArl.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBGrupo.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JCBLateralidad.getSelectedItem() + "','" + this.frmFacturac.frmPersona.JSPNHijos.getValue() + "','" + this.frmFacturac.frmPersona.JSPNClaSE.getValue() + "','" + this.metodos.formatoAMD.format(this.frmFacturac.frmPersona.JDFechaIngreso.getDate()) + "','" + this.frmFacturac.frmPersona.JCBUnidadN.getSelectedItem() + "','" + this.frmFacturac.frmPersona.cboTipoEmpresa.getSelectedItem() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.xCondiVict + "','" + this.JCBTipoDocAcop.getSelectedItem() + "','" + this.txtCedulaA.getText() + "','" + this.JTAObservacion.getText() + "','" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "','" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "','" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        setIdIngreso(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        if (this.frmLlamador.equals("Facturac")) {
            if (!this.frmFacturac.frmOrdenes.getXidclasecita().equals("0") && Principal.txtNo.getText().isEmpty()) {
                mGrabarAtencion();
            }
            mGrabarValidacion();
        }
    }

    public void mActualizarIngreso() {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.sql = "update ingreso set Id_EmpresaContxConv='" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId() + "', esCapitado='" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getEsCapitado() + "', SiCopago='" + this.xcopago + "', Id_Estrato='" + this.xidestrato[this.cboEstrato1.getSelectedIndex()][0] + "', Id_OrigenAdmision='" + this.cboOrigenIngreso.getPopupTable().getValueAt(this.cboOrigenIngreso.getSelectedIndex(), 0) + "', Id_CausaExterna='" + this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0) + "', Id_Especialidad='" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "', Id_Profesional='" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + "', Id_TipoAtencion ='" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + "', Id_NivelEstudio ='" + this.JCBEscolaridad.getPopupTable().getValueAt(this.JCBEscolaridad.getSelectedIndex(), 0).toString() + "', NoPoliza ='" + this.txtNoPoliza.getText() + "', NoAutorizacion ='" + this.txtNoAutorizacion.getText() + "', NMuestra ='" + this.xEsNuevaMuestra + "', Id_Contrato='" + this.cboContrato.getPopupTable().getValueAt(this.cboContrato.getSelectedIndex(), 0) + "', Id_Ocupacion='" + this.xidocupaciones[this.JCBOcupaciones.getSelectedIndex()] + "', SO_Cargo='" + this.frmFacturac.frmPersona.JCBCargo.getSelectedItem() + "', SO_Supervisor='" + this.frmFacturac.frmPersona.JCBSupervisor.getSelectedItem() + "', SO_SEG='" + this.frmFacturac.frmPersona.JCBSegmento.getSelectedItem() + "', SO_Jornada='" + this.frmFacturac.frmPersona.JCBJornada.getSelectedItem() + "', HorasTrabajadas='" + this.frmFacturac.frmPersona.JSPNHorasTrabajadas.getValue() + "', SO_Arl='" + this.frmFacturac.frmPersona.JCBArl.getSelectedItem() + "', SO_Grupo='" + this.frmFacturac.frmPersona.JCBGrupo.getSelectedItem() + "', SO_Lateralidad='" + this.frmFacturac.frmPersona.JCBLateralidad.getSelectedItem() + "', NoHijos='" + this.frmFacturac.frmPersona.JSPNHijos.getValue() + "', ClaseSE='" + this.frmFacturac.frmPersona.JSPNClaSE.getValue() + "', SO_UNegocio='" + this.frmFacturac.frmPersona.JCBUnidadN.getSelectedItem() + "', SO_FechaIngreso='" + this.metodos.formatoAMD.format(this.frmFacturac.frmPersona.JDFechaIngreso.getDate()) + "', DxIngreso='" + this.JTFCie10.getText().toUpperCase() + "', CodigoDx1='" + this.JTFCDxR1.getText().toUpperCase() + "', CodigoDx2='" + this.JTFCDxR2.getText().toUpperCase() + "', CodigoDx3='" + this.JTFCDxR3.getText().toUpperCase() + "', Id_CondVict='" + this.xCondiVict + "', TipoDocA='" + this.JCBTipoDocAcop.getSelectedItem() + "', NoDocA='" + this.txtCedulaA.getText() + "', Observacion='" + this.JTAObservacion.getText() + "', idTipoAfiliacion='" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "', idTipoContratacion='" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "', idTipoCoberturaPlan='" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "', siras='" + this.txtSiras.getText() + "' where Id='" + Principal.txtNo.getText() + "'";
        xct.ejecutarSQL(this.sql);
        xct.cerrarConexionBd();
        this.sql = "UPDATE `a_eventoecat_paciente` SET a_eventoecat_paciente.`Id_condvictima`='" + this.xCondiVict + "' WHERE a_eventoecat_paciente.`Id_Ingreso`='" + Principal.txtNo.getText() + "'";
        xct.ejecutarSQL(this.sql);
        xct.cerrarConexionBd();
    }

    public void mActualizarIngreso1() {
        ConsultasMySQL xct = new ConsultasMySQL();
        this.sql = "update ingreso set Id_OrigenAdmision='" + this.cboOrigenIngreso.getPopupTable().getValueAt(this.cboOrigenIngreso.getSelectedIndex(), 0) + "', Id_CausaExterna='" + this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0) + "', Id_TipoAtencion ='" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + "', Id_NivelEstudio ='" + this.JCBEscolaridad.getPopupTable().getValueAt(this.JCBEscolaridad.getSelectedIndex(), 0).toString() + "', SiCopago ='" + this.xcopago + "', DxIngreso ='" + this.JTFCie10.getText().toUpperCase() + "', Id_Estrato ='" + this.xidestrato[this.cboEstrato1.getSelectedIndex()][0] + "', NoPoliza ='" + this.txtNoPoliza.getText() + "', NoAutorizacion ='" + this.txtNoAutorizacion.getText() + "', Id_Contrato='" + this.cboContrato.getPopupTable().getValueAt(this.cboContrato.getSelectedIndex(), 0) + "', Id_Ocupacion='" + this.xidocupaciones[this.JCBOcupaciones.getSelectedIndex()] + "', SO_Cargo='" + this.frmFacturac.frmPersona.JCBCargo.getSelectedItem() + "', SO_Supervisor='" + this.frmFacturac.frmPersona.JCBSupervisor.getSelectedItem() + "', SO_SEG='" + this.frmFacturac.frmPersona.JCBSegmento.getSelectedItem() + "', SO_Jornada='" + this.frmFacturac.frmPersona.JCBJornada.getSelectedItem() + "', HorasTrabajadas='" + this.frmFacturac.frmPersona.JSPNHorasTrabajadas.getValue() + "', SO_Arl='" + this.frmFacturac.frmPersona.JCBArl.getSelectedItem() + "', SO_Grupo='" + this.frmFacturac.frmPersona.JCBGrupo.getSelectedItem() + "', SO_Lateralidad='" + this.frmFacturac.frmPersona.JCBLateralidad.getSelectedItem() + "', SO_UNegocio='" + this.frmFacturac.frmPersona.JCBUnidadN.getSelectedItem() + "', NoHijos='" + this.frmFacturac.frmPersona.JSPNHijos.getValue() + "', ClaseSE='" + this.frmFacturac.frmPersona.JSPNClaSE.getValue() + "', Id_CondVict='" + this.xCondiVict + "', TipoDocA='" + this.JCBTipoDocAcop.getSelectedItem() + "', NoDocA='" + this.txtCedulaA.getText() + "', SO_FechaIngreso='" + this.metodos.formatoAMD.format(this.frmFacturac.frmPersona.JDFechaIngreso.getDate()) + "', Observacion='" + this.JTAObservacion.getText() + "', idTipoAfiliacion='" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "', idTipoContratacion='" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "', idTipoCoberturaPlan='" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "' where Id='" + Principal.txtNo.getText() + "'";
        xct.ejecutarSQL(this.sql);
        xct.cerrarConexionBd();
    }

    private void mGrabarValidacion() {
        this.sql = "SELECT COUNT(Id) FROM g_usuario_validacion WHERE (Id_Usuario ='" + this.frmFacturac.frmPersona.getIdPersona() + "' AND DATE_FORMAT(FechaV,'%m-%Y') ='" + this.metodos.formatoMesAno.format(this.metodos.getFechaActual()) + "') GROUP BY Id_Usuario ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet rs1 = xct.traerRs(this.sql);
        int xn = 0;
        try {
            if (rs1.next()) {
                xn = rs1.getInt(1);
            }
            rs1.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        if (xn < 2) {
            int x = JOptionPane.showConfirmDialog(this, "Desea grabar validación?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.sql = "insert into g_usuario_validacion(Id_Usuario, FechaV, Id_Empresa_Conv, UsuarioS) values('" + this.frmFacturac.frmPersona.getIdPersona() + "','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + getIdEmpresa() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    private void mActualizarCamposUsuario(String xetnia, String xneducativo, String xocupacion, String xemail, String xpersona) {
        String xsql = "update `g_usuario` set `Etnia`='" + xetnia + "', `NEducativo`='" + xneducativo + "', `Ocupacion`='" + xocupacion + "', `Email`='" + xemail + "' where `Id_persona`='" + xpersona + "'";
        ConsultasMySQL xct = new ConsultasMySQL();
        xct.ejecutarSQL(xsql);
        xct.cerrarConexionBd();
    }

    public void mGrabarAtencion() {
        this.sql = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + getIdIngreso() + "','" + this.frmFacturac.frmOrdenes.getXidclasecita() + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.txtHora.getValue()) + "','','','1','','','','','" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + "','" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
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
            this.sql = "SELECT f_estrato.Id, f_estrato.Nbre as Estrato, f_estratoxemprcontconv.PorcSubsidio as Subsidio,f_estratoxemprcontconv.ValorMaximo as Valor_Maximo, f_estratoxemprcontconv.Editable FROM f_estratoxemprcontconv INNER JOIN f_estrato  ON (f_estratoxemprcontconv.Id_Estrato = f_estrato.Id) WHERE (f_estratoxemprcontconv.Estado =0 AND f_estratoxemprcontconv.Copago ='" + this.xcopago + "' AND f_estratoxemprcontconv.Id_EmpresaContConv ='" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId() + "') ORDER BY Estrato ASC ";
            System.out.println(this.sql);
            this.xidestrato = this.consultas.llenarComboyLista(this.sql, this.xidestrato, this.cboEstrato1, 5);
            this.consultas.cerrarConexionBd();
            if (!Principal.informacionIps.getIdentificacion().equals("8296850")) {
                if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getIdentificacion().equals("900304530") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
                    this.cboEstrato1.setSelectedIndex(0);
                } else {
                    this.cboEstrato1.setSelectedIndex(-1);
                }
            } else {
                this.cboEstrato1.setSelectedIndex(0);
                this.cboEspecialidad.setSelectedIndex(0);
                this.cboCausaExterna.setSelectedIndex(4);
            }
            if (this.xidestrato.length == 1) {
                this.cboEstrato1.setSelectedIndex(0);
            }
        }
    }

    public void mLlenarComboTipoAfiliado() {
        if (this.cboEmpresa.getSelectedIndex() > -1 && this.cboLleno == 1 && !this.listConvenio.isEmpty()) {
            this.JCBTipoAfiliado.removeAllItems();
            this.sql = "SELECT\n    `f_empresacontxconvenio_tipoafiliado`.`idtipoAfiliado`\n    , `g_tipoafiliado`.`Nbre` AS `TipoAfiliado`\n    , `f_empresacontxconvenio_tipoafiliado`.`estado`\nFROM\n    `f_empresacontxconvenio_tipoafiliado`\n    INNER JOIN `g_tipoafiliado` \n        ON (`f_empresacontxconvenio_tipoafiliado`.`idtipoAfiliado` = `g_tipoafiliado`.`Id`)\nWHERE (`f_empresacontxconvenio_tipoafiliado`.`estado` =1\n    AND `f_empresacontxconvenio_tipoafiliado`.`idEmpresaConvenio` =" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId() + ")\nORDER BY `TipoAfiliado` ASC;";
            this.xidTipoAfiliado = this.consultas.llenarComboyLista(this.sql, this.xidTipoAfiliado, this.JCBTipoAfiliado, 3);
            this.consultas.cerrarConexionBd();
            if (Principal.informacionIps.getIdentificacion().equals("8296850")) {
                this.JCBTipoAfiliado.setSelectedIndex(0);
                return;
            }
            if (this.xidTipoAfiliado.length > 0) {
                if (this.xidTipoAfiliado.length > 1) {
                    this.JCBTipoAfiliado.setSelectedIndex(-1);
                } else {
                    this.JCBTipoAfiliado.setSelectedIndex(0);
                }
            }
            if (this.frmAtencion != null && this.frmAtencion.frmPersona.cboTipoAfiliado.getSelectedIndex() != -1) {
                this.JCBTipoAfiliado.setSelectedItem(this.frmAtencion.frmPersona.cboTipoAfiliado.getSelectedItem());
            }
            if (this.frmCitaNP1 != null && this.frmCitaNP1.frmPersona1.cboTipoAfiliado.getSelectedIndex() != -1) {
                this.JCBTipoAfiliado.setSelectedItem(this.frmCitaNP1.frmPersona1.cboTipoAfiliado.getSelectedItem());
            }
            if (this.frmFacturac != null && this.frmFacturac.frmPersona.cboTipoAfiliado.getSelectedIndex() != -1) {
                this.JCBTipoAfiliado.setSelectedItem(this.frmFacturac.frmPersona.cboTipoAfiliado.getSelectedItem());
            }
        }
    }

    public void nuevo() {
        this.lleno = false;
        this.JCH_AplicaFiltroConvenio.setSelected(Principal.informacionIps.getAplicaFiltroConvenio().booleanValue());
        this.txtFecha.setDate(this.metodos.getFechaActualPC());
        this.txtHora.setValue(this.metodos.getFechaActual());
        setIdLiquidacion(0L);
        setIdFacturaCapita(0L);
        setIdFacturaEvento(0L);
        setEstadoFacturaOrdenes(0);
        setIdOrdenes("");
        this.idIngreso = "0";
        this.xTratamiento = "0";
        cargarCboProfesional();
        cargarCombos();
        this.xcopago = 0;
        this.btnCModeradora.setSelected(true);
        this.cboEstrato1.removeAllItems();
        this.JCHEsNuevaMuestra.setSelected(false);
        this.JCBTipoAfiliado.removeAllItems();
        this.xEsNuevaMuestra = 0;
        this.txtFecha.setDate(this.metodos.getFechaActualPC());
        this.txtHora.setValue(this.metodos.getFechaActual());
        this.txtNoAutorizacion.setText("");
        this.txtNoPoliza.setText("");
        this.txtNombreA.setText("");
        this.txtTelefonoA.setText("");
        this.txtNombreR.setText("");
        this.txtTelefonoR.setText("");
        this.JTFCie10.setText("0000");
        this.JTFCDxR1.setText("");
        this.JTFCDxR2.setText("");
        this.JTFCDxR3.setText("");
        this.JCBTipoDocResp.removeAllItems();
        this.consultas.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` ORDER BY Nbre ASC", this.xidTipoDocR, this.JCBTipoDocResp);
        this.JCBTipoDocResp.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.JTFNoDocu.setText("");
        this.JCBTipoDocAcop.removeAllItems();
        this.consultas.llenarCombo("SELECT `Id` , `Nbre` FROM `g_tipoidentificacion` ORDER BY Nbre ASC", this.xidTipoDocA, this.JCBTipoDocAcop);
        this.JCBTipoDocAcop.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
        this.txtCedulaA.setText("");
        this.JCBParentescoAcompaniante.removeAllItems();
        this.consultas.llenarCombo("SELECT Id, Nbre as Parentesco FROM g_parentesco WHERE Estado =0 ORDER BY Nbre ASC", this.xidParAcomp, this.JCBParentescoAcompaniante);
        this.JCBParentescoAcompaniante.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.consultas.cerrarConexionBd();
        this.txtNoPrescripcionMiPres.setText("");
        mSeleccionar_Datos();
        this.JTPDatosIngreso.setSelectedIndex(0);
        this.lleno = true;
    }

    public void mBuscar_Patologia(JTextField codigo, JTextField nombre) {
        String fechaNacimiento;
        String idSexo;
        if (!codigo.getText().isEmpty()) {
            fechaNacimiento = null;
            idSexo = null;
            switch (this.frmLlamador) {
                case "Facturac":
                    fechaNacimiento = this.metodos.formatoAMD1.format(this.frmFacturac.frmPersona.cboFechaNacimiento.getDate());
                    idSexo = this.frmFacturac.frmPersona.listaSexo[this.frmFacturac.frmPersona.cboSexo.getSelectedIndex()];
                    break;
                case "CitaNP":
                    fechaNacimiento = this.metodos.formatoAMD1.format(this.frmCitaNP1.frmPersona1.cboFechaNacimiento.getDate());
                    idSexo = this.frmCitaNP1.frmPersona1.listaSexo[this.frmCitaNP1.frmPersona1.cboSexo.getSelectedIndex()];
                    break;
                case "Atencion":
                    fechaNacimiento = this.metodos.formatoAMD1.format(this.frmAtencion.frmPersona.cboFechaNacimiento.getDate());
                    idSexo = this.frmAtencion.frmPersona.listaSexo[this.frmAtencion.frmPersona.cboSexo.getSelectedIndex()];
                    break;
            }
            Integer verficacion = this.patologiaCie10DAO.patologiaFiltradaEdad(fechaNacimiento, idSexo, this.JTFCie10.getText());
            if (verficacion.intValue() == 1 || verficacion.intValue() == 0) {
                if (verficacion.intValue() != 0) {
                    PatologiaCie10DTO patologia = this.patologiaCie10DAO.patologiaFiltrada(codigo.getText(), -1);
                    codigo.setText(patologia.getId());
                    nombre.setText(patologia.getNombre());
                    return;
                } else {
                    this.metodos.mostrarMensaje("El Dx no aplica para Sexo y/o Edad");
                    codigo.setText("0000");
                    nombre.setText("");
                    nombre.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Código de diagnóstico no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            codigo.setText("0000");
            nombre.requestFocus();
        }
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

    /* JADX WARN: Finally extract failed */
    public void mEstablecerUltimoNivelEstudio(String xidusuario) {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            this.sql = "SELECT ucase(`g_nivelestudio`.`Nbre`) FROM `g_nivelestudio` INNER JOIN `ingreso`  ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`) WHERE (`ingreso`.`Id_Usuario` ='" + xidusuario + "') ORDER BY `ingreso`.`Id` DESC ";
            ResultSet xrs = xct.traerRs(this.sql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.JCBEscolaridad.setSelectedItem(xrs.getString(1));
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                xct.cerrarConexionBd();
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
        if (this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getEsCapitado().equals("2")) {
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
        switch (frmI.getName()) {
            case "Facturac":
                this.frmFacturac = (Facturac) frmI;
                break;
            case "CitaNP":
                this.frmCitaNP1 = (CitaNP) frmI;
                break;
            case "Atencion":
                this.frmAtencion = (Atencion) frmI;
                break;
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00b8: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs1' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:23:0x00b8 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x00bc: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:25:0x00bc */
    public void mBuscarIngresos(String nusuario) {
        try {
            try {
                String xsql = "SELECT ingreso.Id, ingreso.FechaIngreso, ingreso.HoraIngreso, f_empresacontxconvenio.Nbre, ingreso.SiCopago, f_estrato.Nbre, g_origenadmision.Nbre, g_causaexterna.Nbre , g_especialidad.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, g_patologia.Id, g_patologia.Nbre, ingreso.NoPoliza, ingreso.NoAutorizacion, g_contratos.Nbre_Contrato, ingreso.Estado  FROM ingreso INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_estrato  ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN g_causaexterna  ON (ingreso.Id_CausaExterna = g_causaexterna.Id) INNER JOIN g_origenadmision  ON (ingreso.Id_OrigenAdmision = g_origenadmision.Id) INNER JOIN g_especialidad  ON (ingreso.Id_Especialidad = g_especialidad.Id) INNER JOIN g_profesional  ON (ingreso.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_contratos  ON (ingreso.Id_Contrato = g_contratos.Id) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN g_patologia  ON (g_patologia.Id = ingreso.DxIngreso) WHERE (ingreso.Id_Usuario ='" + nusuario + "') ORDER BY ingreso.FechaIngreso asc, ingreso.HoraIngreso DESC ";
                ResultSet rs1 = this.consultas.traerRs(xsql);
                Throwable th = null;
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
                if (rs1 != null) {
                    if (0 != 0) {
                        try {
                            rs1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        rs1.close();
                    }
                }
                this.consultas.cerrarConexionBd();
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void mMovimientoResultSet(int pos, boolean xtipo) {
        String xsql;
        try {
            if (xtipo) {
                xsql = "SELECT ingreso.Id, ingreso.FechaIngreso, ingreso.HoraIngreso, f_empresacontxconvenio.Nbre, ingreso.SiCopago, f_estrato.Nbre, g_origenadmision.Nbre, g_causaexterna.Nbre , g_especialidad.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, g_patologia.Id, g_patologia.Nbre, ingreso.NoPoliza, ingreso.NoAutorizacion, g_contratos.Nbre_Contrato, ingreso.Estado FROM ingreso INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_estrato  ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN g_causaexterna  ON (ingreso.Id_CausaExterna = g_causaexterna.Id) INNER JOIN g_origenadmision  ON (ingreso.Id_OrigenAdmision = g_origenadmision.Id) INNER JOIN g_especialidad  ON (ingreso.Id_Especialidad = g_especialidad.Id) INNER JOIN g_profesional  ON (ingreso.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_contratos  ON (ingreso.Id_Contrato = g_contratos.Id) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN g_patologia  ON (g_patologia.Id = ingreso.DxIngreso) WHERE (ingreso.Id ='" + this.xidingresos[pos] + "') ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso DESC ";
            } else {
                xsql = "SELECT ingreso.Id, ingreso.FechaIngreso, ingreso.HoraIngreso, f_empresacontxconvenio.Nbre, ingreso.SiCopago, f_estrato.Nbre, g_origenadmision.Nbre, g_causaexterna.Nbre , g_especialidad.Nbre, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NOMBREPROFSIONAL, g_patologia.Id, g_patologia.Nbre, ingreso.NoPoliza, ingreso.NoAutorizacion, g_contratos.Nbre_Contrato, ingreso.Estado FROM ingreso INNER JOIN f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_estrato  ON (ingreso.Id_Estrato = f_estrato.Id) INNER JOIN g_causaexterna  ON (ingreso.Id_CausaExterna = g_causaexterna.Id) INNER JOIN g_origenadmision  ON (ingreso.Id_OrigenAdmision = g_origenadmision.Id) INNER JOIN g_especialidad  ON (ingreso.Id_Especialidad = g_especialidad.Id) INNER JOIN g_profesional  ON (ingreso.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_contratos  ON (ingreso.Id_Contrato = g_contratos.Id) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN g_patologia  ON (g_patologia.Id = ingreso.DxIngreso) WHERE (ingreso.Id ='" + pos + "') ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso DESC ";
            }
            ResultSet rs = this.consultas.traerRs(xsql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    rs.first();
                    cargarIngreso(rs.getString(1));
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
                this.consultas.cerrarConexionBd();
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
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
        this.JTPDatosIngreso = new JTabbedPane();
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
            this.cboOrigenIngreso = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        try {
            this.cboTipoAtencion = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        try {
            this.cboUnidadCamas = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e14) {
            e14.printStackTrace();
        }
        try {
            this.cboCamas = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e15) {
            e15.printStackTrace();
        }
        this.cboEstrato1 = new JComboBox();
        try {
            this.JCBEscolaridad = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e16) {
            e16.printStackTrace();
        }
        this.JCBCondVict = new JComboBox();
        this.cboEspecialidad = new JComboBox();
        this.cboProfesional = new JComboBox();
        this.JCH_AplicaFiltroConvenio = new JCheckBox();
        try {
            this.cboCausaExterna = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e17) {
            e17.printStackTrace();
        }
        this.JBTActualizarIngreso = new JButton();
        this.JPIAdicional = new JPanel();
        this.txtNoPoliza = new JFormattedTextField();
        this.txtNoAutorizacion = new JFormattedTextField();
        this.JCBOcupaciones = new JComboBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCHEsNuevaMuestra = new JCheckBox();
        this.JCBTipoAfiliado = new JComboBox();
        this.JCB_TipoContratacion = new JComboBox();
        this.JCB_TipoCoberturaPlan = new JComboBox();
        this.txtNoPrescripcionMiPres = new JFormattedTextField();
        this.txtSiras = new JFormattedTextField();
        this.JPIDiagnostico = new JPanel();
        this.JTFCie10 = new JTextField();
        this.JTF_DNombre = new JTextField();
        this.JTFCDxR1 = new JTextField();
        this.JLBTDxRelacionados = new JLabel();
        this.JTFNDxR1 = new JTextField();
        this.JTFCDxR2 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.JTFCDxR3 = new JTextField();
        this.JTFNDxR3 = new JTextField();
        this.JPIResponsable = new JPanel();
        this.jPanel2 = new JPanel();
        this.txtNombreR = new JTextField();
        this.txtTelefonoR = new JTextField();
        this.JTFNoDocu = new JTextField();
        try {
            this.cboParentescoR = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e18) {
            e18.printStackTrace();
        }
        this.JCBTipoDocResp = new JComboBox();
        this.jPanel4 = new JPanel();
        this.txtNombreA = new JTextField();
        this.txtTelefonoA = new JTextField();
        this.JCBParentescoAcompaniante = new JComboBox();
        this.txtCedulaA = new JTextField();
        this.JCBTipoDocAcop = new JComboBox();
        this.JPIAdicional1 = new JPanel();
        this.JCBModalidadAtencion = new JComboBox();
        this.JCBEntornoAtencion = new JComboBox();
        this.JCBEmpresaMision = new JComboBox();
        setName("Ingreso");
        setPreferredSize(new Dimension(1190, 222));
        this.JTPDatosIngreso.setForeground(new Color(255, 0, 0));
        this.JTPDatosIngreso.setFont(new Font("Arial", 1, 14));
        this.JTPDatosIngreso.setName("Ingreso");
        this.JPIIngreso.setForeground(new Color(0, 0, 102));
        this.JPIIngreso.setFont(new Font("Tahoma", 1, 11));
        this.JPIIngreso.setLayout((LayoutManager) null);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.Ingreso.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                Ingreso.this.txtFechaPropertyChange(evt);
            }
        });
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.2
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.txtFechaKeyPressed(evt);
            }
        });
        this.JPIIngreso.add(this.txtFecha);
        this.txtFecha.setBounds(10, 0, 130, 50);
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.3
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.txtHoraKeyPressed(evt);
            }
        });
        this.JPIIngreso.add(this.txtHora);
        this.txtHora.setBounds(150, 10, 110, 40);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Cobro", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel1.setLayout((LayoutManager) null);
        this.JBGTipoEstrato.add(this.btnCModeradora);
        this.btnCModeradora.setFont(new Font("Arial", 1, 12));
        this.btnCModeradora.setForeground(new Color(0, 0, 255));
        this.btnCModeradora.setSelected(true);
        this.btnCModeradora.setText("C. Moderadora");
        this.btnCModeradora.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.4
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.btnCModeradoraMouseClicked(evt);
            }
        });
        this.btnCModeradora.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.5
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.btnCModeradoraActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnCModeradora);
        this.btnCModeradora.setBounds(10, 20, 110, 20);
        this.JBGTipoEstrato.add(this.btnCopago);
        this.btnCopago.setFont(new Font("Arial", 1, 12));
        this.btnCopago.setForeground(new Color(0, 0, 255));
        this.btnCopago.setText("Copago");
        this.btnCopago.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.6
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.btnCopagoActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnCopago);
        this.btnCopago.setBounds(10, 40, 110, 20);
        this.JPIIngreso.add(this.jPanel1);
        this.jPanel1.setBounds(10, 50, 136, 67);
        this.cboEmpresa.setFont(new Font("Arial", 1, 12));
        this.cboEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio a Facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEmpresa.addItemListener(new ItemListener() { // from class: Facturacion.Ingreso.7
            public void itemStateChanged(ItemEvent evt) {
                Ingreso.this.cboEmpresaItemStateChanged(evt);
            }
        });
        this.cboEmpresa.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.8
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.cboEmpresaMouseClicked(evt);
            }
        });
        this.JPIIngreso.add(this.cboEmpresa);
        this.cboEmpresa.setBounds(270, 10, 360, 40);
        this.cboContrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Contrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboContrato.setFont(new Font("Arial", 1, 12));
        this.cboContrato.setShowTableGrid(true);
        this.cboContrato.setShowTableHeaders(true);
        this.JPIIngreso.add(this.cboContrato);
        this.cboContrato.setBounds(320, 70, 180, 40);
        this.cboOrigenIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Origen de Ingreso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboOrigenIngreso.setFont(new Font("Arial", 1, 12));
        this.cboOrigenIngreso.setShowTableGrid(true);
        this.cboOrigenIngreso.setShowTableHeaders(true);
        this.cboOrigenIngreso.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.9
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.cboOrigenIngresoActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.cboOrigenIngreso);
        this.cboOrigenIngreso.setBounds(10, 127, 290, 40);
        this.cboTipoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de atención y/o Servicios", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.cboTipoAtencion.setShowTableGrid(true);
        this.cboTipoAtencion.setShowTableHeaders(true);
        this.cboTipoAtencion.addItemListener(new ItemListener() { // from class: Facturacion.Ingreso.10
            public void itemStateChanged(ItemEvent evt) {
                Ingreso.this.cboTipoAtencionItemStateChanged(evt);
            }
        });
        this.cboTipoAtencion.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.11
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.cboTipoAtencionActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.cboTipoAtencion);
        this.cboTipoAtencion.setBounds(760, 10, 200, 40);
        this.cboUnidadCamas.setBorder(BorderFactory.createTitledBorder((Border) null, "Pabellones de Camas", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboUnidadCamas.setEnabled(false);
        this.cboUnidadCamas.setFont(new Font("Arial", 1, 12));
        this.cboUnidadCamas.setShowTableGrid(true);
        this.cboUnidadCamas.setShowTableHeaders(true);
        this.cboUnidadCamas.addItemListener(new ItemListener() { // from class: Facturacion.Ingreso.12
            public void itemStateChanged(ItemEvent evt) {
                Ingreso.this.cboUnidadCamasItemStateChanged(evt);
            }
        });
        this.JPIIngreso.add(this.cboUnidadCamas);
        this.cboUnidadCamas.setBounds(770, 130, 180, 40);
        this.cboCamas.setBorder(BorderFactory.createTitledBorder((Border) null, "Cama", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboCamas.setEnabled(false);
        this.cboCamas.setFont(new Font("Arial", 1, 12));
        this.cboCamas.setShowTableGrid(true);
        this.cboCamas.setShowTableHeaders(true);
        this.JPIIngreso.add(this.cboCamas);
        this.cboCamas.setBounds(960, 130, 170, 40);
        this.cboEstrato1.setFont(new Font("Arial", 1, 12));
        this.cboEstrato1.setBorder(BorderFactory.createTitledBorder((Border) null, "Estrato", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPIIngreso.add(this.cboEstrato1);
        this.cboEstrato1.setBounds(150, 70, 160, 40);
        this.JCBEscolaridad.setBorder(BorderFactory.createTitledBorder((Border) null, "Escolaridad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEscolaridad.setFont(new Font("Arial", 1, 12));
        this.JCBEscolaridad.setShowTableGrid(true);
        this.JCBEscolaridad.setShowTableHeaders(true);
        this.JCBEscolaridad.addItemListener(new ItemListener() { // from class: Facturacion.Ingreso.13
            public void itemStateChanged(ItemEvent evt) {
                Ingreso.this.JCBEscolaridadItemStateChanged(evt);
            }
        });
        this.JPIIngreso.add(this.JCBEscolaridad);
        this.JCBEscolaridad.setBounds(960, 10, 190, 40);
        this.JCBCondVict.setFont(new Font("Arial", 1, 12));
        this.JCBCondVict.setBorder(BorderFactory.createTitledBorder((Border) null, "Condición Victima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCondVict.setEnabled(false);
        this.JCBCondVict.addItemListener(new ItemListener() { // from class: Facturacion.Ingreso.14
            public void itemStateChanged(ItemEvent evt) {
                Ingreso.this.JCBCondVictItemStateChanged(evt);
            }
        });
        this.JPIIngreso.add(this.JCBCondVict);
        this.JCBCondVict.setBounds(600, 130, 160, 40);
        this.cboEspecialidad.setFont(new Font("Arial", 1, 12));
        this.cboEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad que Ordena", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.Ingreso.15
            public void itemStateChanged(ItemEvent evt) {
                Ingreso.this.cboEspecialidadItemStateChanged(evt);
            }
        });
        this.cboEspecialidad.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.16
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.cboEspecialidadActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.cboEspecialidad);
        this.cboEspecialidad.setBounds(510, 70, 300, 40);
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Ordena", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboProfesional.addItemListener(new ItemListener() { // from class: Facturacion.Ingreso.17
            public void itemStateChanged(ItemEvent evt) {
                Ingreso.this.cboProfesionalItemStateChanged(evt);
            }
        });
        this.JPIIngreso.add(this.cboProfesional);
        this.cboProfesional.setBounds(820, 70, 320, 40);
        this.JCH_AplicaFiltroConvenio.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaFiltroConvenio.setText("Filtro");
        this.JCH_AplicaFiltroConvenio.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.18
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.JCH_AplicaFiltroConvenioActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.JCH_AplicaFiltroConvenio);
        this.JCH_AplicaFiltroConvenio.setBounds(630, 20, 60, 19);
        this.cboCausaExterna.setBorder(BorderFactory.createTitledBorder((Border) null, "Causa Externa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboCausaExterna.setFont(new Font("Arial", 1, 12));
        this.cboCausaExterna.setShowTableGrid(true);
        this.cboCausaExterna.setShowTableHeaders(true);
        this.cboCausaExterna.addItemListener(new ItemListener() { // from class: Facturacion.Ingreso.19
            public void itemStateChanged(ItemEvent evt) {
                Ingreso.this.cboCausaExternaItemStateChanged(evt);
            }
        });
        this.cboCausaExterna.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.20
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.cboCausaExternaMouseClicked(evt);
            }
        });
        this.cboCausaExterna.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.21
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.cboCausaExternaActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.cboCausaExterna);
        this.cboCausaExterna.setBounds(310, 130, 280, 40);
        this.JBTActualizarIngreso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTActualizarIngreso.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.22
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.JBTActualizarIngresoActionPerformed(evt);
            }
        });
        this.JPIIngreso.add(this.JBTActualizarIngreso);
        this.JBTActualizarIngreso.setBounds(690, 10, 60, 36);
        this.JTPDatosIngreso.addTab("BÁSICOS", this.JPIIngreso);
        this.JPIAdicional.setForeground(new Color(0, 0, 102));
        this.JPIAdicional.setFont(new Font("Tahoma", 1, 11));
        this.txtNoPoliza.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Poliza", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoPoliza.setFont(new Font("Arial", 1, 12));
        this.txtNoAutorizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Autorización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoAutorizacion.setFont(new Font("Arial", 1, 12));
        this.txtNoAutorizacion.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ingreso.23
            public void focusLost(FocusEvent evt) {
                Ingreso.this.txtNoAutorizacionFocusLost(evt);
            }
        });
        this.txtNoAutorizacion.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.24
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.txtNoAutorizacionActionPerformed(evt);
            }
        });
        this.txtNoAutorizacion.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.25
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.txtNoAutorizacionKeyPressed(evt);
            }
        });
        this.JCBOcupaciones.setFont(new Font("Arial", 1, 12));
        this.JCBOcupaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Ocupaciones (CIUO)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBOcupaciones.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.26
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.JCBOcupacionesMouseClicked(evt);
            }
        });
        this.JCBOcupaciones.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.27
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.JCBOcupacionesActionPerformed(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCHEsNuevaMuestra.setFont(new Font("Arial", 1, 12));
        this.JCHEsNuevaMuestra.setText("Es nueva muestra");
        this.JCHEsNuevaMuestra.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.28
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.JCHEsNuevaMuestraActionPerformed(evt);
            }
        });
        this.JCBTipoAfiliado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAfiliado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Afiliacion", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoAfiliado.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.29
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.JCBTipoAfiliadoMouseClicked(evt);
            }
        });
        this.JCBTipoAfiliado.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.30
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.JCBTipoAfiliadoActionPerformed(evt);
            }
        });
        this.JCB_TipoContratacion.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoContratacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Contratación (Res014-FT025)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_TipoCoberturaPlan.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoCoberturaPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Plan de Cobertura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoPrescripcionMiPres.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Prescripción Mipres", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoPrescripcionMiPres.setFont(new Font("Arial", 1, 12));
        this.txtNoPrescripcionMiPres.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ingreso.31
            public void focusLost(FocusEvent evt) {
                Ingreso.this.txtNoPrescripcionMiPresFocusLost(evt);
            }
        });
        this.txtNoPrescripcionMiPres.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.32
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.txtNoPrescripcionMiPresActionPerformed(evt);
            }
        });
        this.txtNoPrescripcionMiPres.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.33
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.txtNoPrescripcionMiPresKeyPressed(evt);
            }
        });
        this.txtSiras.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Siras", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtSiras.setFont(new Font("Arial", 1, 12));
        this.txtSiras.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ingreso.34
            public void focusLost(FocusEvent evt) {
                Ingreso.this.txtSirasFocusLost(evt);
            }
        });
        this.txtSiras.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.35
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.txtSirasActionPerformed(evt);
            }
        });
        this.txtSiras.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.36
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.txtSirasKeyPressed(evt);
            }
        });
        GroupLayout JPIAdicionalLayout = new GroupLayout(this.JPIAdicional);
        this.JPIAdicional.setLayout(JPIAdicionalLayout);
        JPIAdicionalLayout.setHorizontalGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createSequentialGroup().addComponent(this.JCBTipoAfiliado, -2, 263, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_TipoContratacion, -2, 320, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_TipoCoberturaPlan, -2, 220, -2)).addGroup(JPIAdicionalLayout.createSequentialGroup().addComponent(this.txtNoPoliza, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBOcupaciones, -2, 700, -2)).addGroup(JPIAdicionalLayout.createSequentialGroup().addComponent(this.txtNoAutorizacion, -2, 245, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtSiras, -2, 234, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNoPrescripcionMiPres, -2, 227, -2).addGap(18, 18, 18).addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEsNuevaMuestra).addComponent(this.JSPObservacion, -2, 227, -2)))).addContainerGap()));
        JPIAdicionalLayout.setVerticalGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createSequentialGroup().addContainerGap().addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicionalLayout.createSequentialGroup().addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtNoPoliza, -2, 50, -2).addComponent(this.JCBOcupaciones, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtNoAutorizacion, -2, 50, -2).addComponent(this.txtSiras, -2, 50, -2).addComponent(this.txtNoPrescripcionMiPres, -2, 50, -2))).addGroup(JPIAdicionalLayout.createSequentialGroup().addComponent(this.JCHEsNuevaMuestra).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion))).addGap(10, 10, 10).addGroup(JPIAdicionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoAfiliado, -2, 50, -2).addComponent(this.JCB_TipoContratacion, -2, 50, -2).addComponent(this.JCB_TipoCoberturaPlan, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JTPDatosIngreso.addTab("ADICIONAL", this.JPIAdicional);
        this.JTFCie10.setFont(new Font("Arial", 1, 12));
        this.JTFCie10.setHorizontalAlignment(4);
        this.JTFCie10.setText("Z000");
        this.JTFCie10.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie 10", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCie10.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ingreso.37
            public void focusLost(FocusEvent evt) {
                Ingreso.this.JTFCie10FocusLost(evt);
            }
        });
        this.JTFCie10.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.38
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.JTFCie10ActionPerformed(evt);
            }
        });
        this.JTFCie10.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.39
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.JTFCie10KeyPressed(evt);
            }
        });
        this.JTF_DNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_DNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_DNombre.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.40
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.JTF_DNombreMouseClicked(evt);
            }
        });
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ingreso.41
            public void focusLost(FocusEvent evt) {
                Ingreso.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.42
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JLBTDxRelacionados.setBackground(new Color(0, 0, 153));
        this.JLBTDxRelacionados.setFont(new Font("Bell MT", 1, 14));
        this.JLBTDxRelacionados.setForeground(new Color(204, 255, 255));
        this.JLBTDxRelacionados.setHorizontalAlignment(0);
        this.JLBTDxRelacionados.setText("Diagnosticos Relacionados");
        this.JLBTDxRelacionados.setBorder(new SoftBevelBorder(0));
        this.JLBTDxRelacionados.setOpaque(true);
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.43
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.44
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ingreso.45
            public void focusLost(FocusEvent evt) {
                Ingreso.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.46
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.47
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.48
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JTFCDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR3.addFocusListener(new FocusAdapter() { // from class: Facturacion.Ingreso.49
            public void focusLost(FocusEvent evt) {
                Ingreso.this.JTFCDxR3FocusLost(evt);
            }
        });
        this.JTFCDxR3.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.50
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.JTFCDxR3KeyPressed(evt);
            }
        });
        this.JTFNDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR3.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.51
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.JTFNDxR3MouseClicked(evt);
            }
        });
        this.JTFNDxR3.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.52
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.JTFNDxR3KeyPressed(evt);
            }
        });
        GroupLayout JPIDiagnosticoLayout = new GroupLayout(this.JPIDiagnostico);
        this.JPIDiagnostico.setLayout(JPIDiagnosticoLayout);
        JPIDiagnosticoLayout.setHorizontalGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCDxR3, -2, 64, -2).addComponent(this.JTFCDxR2, -2, 64, -2).addComponent(this.JTFCDxR1, -2, 64, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNDxR2, -1, 902, 32767).addComponent(this.JTFNDxR1, GroupLayout.Alignment.TRAILING).addComponent(this.JTFNDxR3))).addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBTDxRelacionados, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addComponent(this.JTFCie10, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTF_DNombre, -2, 884, -2)))).addContainerGap(170, 32767)));
        JPIDiagnosticoLayout.setVerticalGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTF_DNombre, -2, -1, -2).addComponent(this.JTFCie10, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JLBTDxRelacionados, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR1, -2, -1, -2).addComponent(this.JTFCDxR1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR2, -2, -1, -2).addComponent(this.JTFCDxR2, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR3, -2, -1, -2).addComponent(this.JTFCDxR3, -2, -1, -2)).addContainerGap(20, 32767)));
        this.JTPDatosIngreso.addTab("DIAGNÓSTICO", this.JPIDiagnostico);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos del Responsable", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.txtNombreR.setFont(new Font("Arial", 1, 12));
        this.txtNombreR.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTelefonoR.setFont(new Font("Arial", 1, 12));
        this.txtTelefonoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTelefonoR.addActionListener(new ActionListener() { // from class: Facturacion.Ingreso.53
            public void actionPerformed(ActionEvent evt) {
                Ingreso.this.txtTelefonoRActionPerformed(evt);
            }
        });
        this.JTFNoDocu.setFont(new Font("Arial", 1, 12));
        this.JTFNoDocu.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboParentescoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Parentesco", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboParentescoR.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocResp.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocResp.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.txtNombreR, -2, 322, -2).addGap(3, 3, 3).addComponent(this.JCBTipoDocResp, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNoDocu, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboParentescoR, -2, 217, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtTelefonoR, -2, 190, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtNombreR, -2, 50, -2).addComponent(this.txtTelefonoR, -2, 50, -2).addComponent(this.JTFNoDocu, -2, 50, -2).addComponent(this.cboParentescoR, -2, 50, -2).addComponent(this.JCBTipoDocResp, -2, 50, -2)).addGap(3, 3, 3)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos Acompañante", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.txtNombreA.setFont(new Font("Arial", 1, 12));
        this.txtNombreA.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTelefonoA.setFont(new Font("Arial", 1, 12));
        this.txtTelefonoA.setBorder(BorderFactory.createTitledBorder((Border) null, "Teléfono", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBParentescoAcompaniante.setFont(new Font("Arial", 1, 12));
        this.JCBParentescoAcompaniante.setBorder(BorderFactory.createTitledBorder((Border) null, "Parentesco", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCedulaA.setFont(new Font("Arial", 1, 12));
        this.txtCedulaA.setBorder(BorderFactory.createTitledBorder((Border) null, "No.Documento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocAcop.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocAcop.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.txtNombreA, -2, 319, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocAcop, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCedulaA, -2, 192, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBParentescoAcompaniante, -2, 213, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtTelefonoA).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBParentescoAcompaniante, -2, 50, -2).addComponent(this.txtCedulaA, -2, 50, -2).addComponent(this.JCBTipoDocAcop, -2, 50, -2)).addComponent(this.txtNombreA, -2, 50, -2).addComponent(this.txtTelefonoA, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPIResponsableLayout = new GroupLayout(this.JPIResponsable);
        this.JPIResponsable.setLayout(JPIResponsableLayout);
        JPIResponsableLayout.setHorizontalGroup(JPIResponsableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResponsableLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIResponsableLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPIResponsableLayout.setVerticalGroup(JPIResponsableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIResponsableLayout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(4, 4, 4).addComponent(this.jPanel4, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JTPDatosIngreso.addTab("RESPONSABLE Y ACOMPAÑANTE", this.JPIResponsable);
        this.JCBModalidadAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBModalidadAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Modalidad Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBModalidadAtencion.setName("modalidadAtencion");
        this.JCBEntornoAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBEntornoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Entorno Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEntornoAtencion.setName("entornoAtencion");
        this.JCBEmpresaMision.setFont(new Font("Arial", 1, 10));
        this.JCBEmpresaMision.setToolTipText("");
        this.JCBEmpresaMision.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa en misión / Subempresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresaMision.setName("empresaMision");
        this.JCBEmpresaMision.addMouseListener(new MouseAdapter() { // from class: Facturacion.Ingreso.54
            public void mouseClicked(MouseEvent evt) {
                Ingreso.this.JCBEmpresaMisionMouseClicked(evt);
            }
        });
        this.JCBEmpresaMision.addKeyListener(new KeyAdapter() { // from class: Facturacion.Ingreso.55
            public void keyPressed(KeyEvent evt) {
                Ingreso.this.JCBEmpresaMisionKeyPressed(evt);
            }
        });
        GroupLayout JPIAdicional1Layout = new GroupLayout(this.JPIAdicional1);
        this.JPIAdicional1.setLayout(JPIAdicional1Layout);
        JPIAdicional1Layout.setHorizontalGroup(JPIAdicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicional1Layout.createSequentialGroup().addContainerGap().addGroup(JPIAdicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicional1Layout.createSequentialGroup().addComponent(this.JCBModalidadAtencion, -2, 388, -2).addGap(18, 18, 18).addComponent(this.JCBEntornoAtencion, -2, 388, -2)).addComponent(this.JCBEmpresaMision, -2, 330, -2)).addContainerGap(357, 32767)));
        JPIAdicional1Layout.setVerticalGroup(JPIAdicional1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAdicional1Layout.createSequentialGroup().addContainerGap().addGroup(JPIAdicional1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBModalidadAtencion, -2, 50, -2).addComponent(this.JCBEntornoAtencion, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.JCBEmpresaMision, -2, 50, -2).addContainerGap(54, 32767)));
        this.JTPDatosIngreso.addTab("ADICIONAL 1", this.JPIAdicional1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatosIngreso, -2, 1157, -2).addGap(0, 33, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatosIngreso, -2, -1, -2).addContainerGap(-1, 32767)));
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
        evaluarTipoAtencion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUnidadCamasItemStateChanged(ItemEvent evt) {
        cargarCboCama();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEscolaridadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCModeradoraMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCausaExternaItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1) {
            if (Integer.parseInt(this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 2).toString()) == 2) {
                this.JCBCondVict.setEnabled(true);
                this.sql = "SELECT `Id`  , `Nbre` FROM `a_condvictima` WHERE (`Estado` =0) order by Nbre";
                this.JCBCondVict.removeAllItems();
                this.xidCondVict = this.consultas.llenarCombo(this.sql, this.xidCondVict, this.JCBCondVict);
                this.JCBCondVict.setSelectedIndex(-1);
                this.consultas.cerrarConexionBd();
                this.xlleno2 = true;
                return;
            }
            this.JCBCondVict.setEnabled(false);
            this.xCondiVict = 0;
            this.JCBCondVict.removeAllItems();
            this.xlleno2 = false;
        }
    }

    private void mSeleccionar_Datos() {
        switch (Principal.informacionIps.getNombreIps()) {
            case "LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.":
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Otra");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                this.cboEspecialidad.setSelectedItem("ACTUALIZAR");
                this.JCBTipoAfiliado.setSelectedItem("Particular");
                this.cboProfesional.setSelectedIndex(-1);
                break;
            case "LABORATORIO CLINICO CENTRAL":
            case "CENTRO MÉDICO SERVIFARMA IPS S.A.S.":
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Otra");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                this.cboEspecialidad.setSelectedItem("BACTERIOLOGIA");
                this.JCBTipoAfiliado.setSelectedItem("Particular");
                this.cboProfesional.setSelectedIndex(-1);
                break;
            case "LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.":
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Enfermedad General");
                this.JTFCie10.setText("Z017");
                this.JTF_DNombre.setText("EXAMEN DE LABORATORIO ");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                break;
            case "BIEN ESTAR SALUD BS S.A.S.":
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Enfermedad General");
                this.JTFCie10.setText("Z100");
                this.JTF_DNombre.setText("EXAMEN DE SALUD OCUPACIONAL");
                this.cboTipoAtencion.setSelectedItem("AMBULATORIO");
                this.JCBTipoAfiliado.setSelectedItem("Particular");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                this.txtNombreR.setText("No Aplica");
                this.txtNombreA.setText("No Aplica");
                break;
            case "SERVICIOS MEDICOS SAN IGNACIO SAS":
            case "HOSPITAL SAN VICENTE DE PAUL":
            case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH":
            case "CLINICA SANTA CLARA SAS":
            case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
            case "ZONAMEDICA MR S.A.S":
                this.cboEmpresa.setSelectedItem("PARTICULAR");
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Otra");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                this.cboEspecialidad.setSelectedItem("ACTUALIZAR");
                break;
            case "BIOMED VIDA IPS S.A.S":
                this.cboEmpresa.setSelectedItem("PARTICULAR");
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Enfermedad General");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                this.cboEspecialidad.setSelectedItem("MEDICINA GENERAL");
                this.cboTipoAtencion.setSelectedItem("AMBULATORIO");
                break;
            case "CLINICA SAN FRANCISCO S.A.":
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Enfermedad General");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                this.cboEspecialidad.setSelectedItem("MEDICINA GENERAL");
                this.cboTipoAtencion.setSelectedItem("CONSULTA EXTERNA");
                this.JCBTipoAfiliado.setSelectedItem("Particular");
                break;
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA":
                this.cboEmpresa.setSelectedItem("PARTICULAR");
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Enfermedad General");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                this.cboEspecialidad.setSelectedItem("ACTUALIZAR");
                this.cboTipoAtencion.setSelectedItem("AMBULATORIO");
                this.JCBTipoAfiliado.setSelectedItem("Particular");
                break;
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS":
                this.cboEmpresa.setSelectedItem("PARTICULARES");
                this.JCBEscolaridad.setSelectedItem("NO APLICA");
                this.cboCausaExterna.setSelectedItem("Enfermedad General");
                this.JCBOcupaciones.setSelectedItem("NO APLICA (MENORES DE EDAD Y AMAS DE CASA)");
                this.cboEspecialidad.setSelectedItem("BACTERIOLOGIA");
                this.cboTipoAtencion.setSelectedItem("AMBULATORIO");
                this.JCBTipoAfiliado.setSelectedItem("Particular");
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCondVictItemStateChanged(ItemEvent evt) {
        if (this.xlleno2 && this.JCBCondVict.getSelectedIndex() != -1) {
            this.xCondiVict = Integer.parseInt(this.xidCondVict[this.JCBCondVict.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCausaExternaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            mVerificaCausaExterna();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_DNombreMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCie10, this.JTF_DNombre);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10KeyPressed(KeyEvent evt) {
        if (this.JTFCie10.getText().isEmpty() && evt.getKeyCode() == 10) {
            mBuscar_Patologia(this.JTFCie10, this.JTF_DNombre);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10ActionPerformed(ActionEvent evt) {
        this.JTFCie10.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCie10FocusLost(FocusEvent evt) {
        if (this.JTFCie10.getText().isEmpty()) {
            this.JTFCie10.setText("0000");
            this.JTF_DNombre.setText("---");
        }
        mBuscar_Patologia(this.JTFCie10, this.JTF_DNombre);
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
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") && !this.txtNoAutorizacion.getText().isEmpty() && this.cboEmpresa.getSelectedIndex() != -1) {
            mConsultarNAutorizacion();
        }
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
    public void JCHEsNuevaMuestraActionPerformed(ActionEvent evt) {
        if (this.JCHEsNuevaMuestra.isSelected()) {
            this.xEsNuevaMuestra = 1;
        } else {
            this.xEsNuevaMuestra = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTelefonoRActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEmpresaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDBuscarConvenio detalle = new JDBuscarConvenio(null, true, this);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno && Principal.clasefacturacion != null && Principal.clasefacturacion.frmFacturac != null && Principal.clasefacturacion.frmFacturac.frmOrdenes != null) {
            Principal.clasefacturacion.frmFacturac.frmOrdenes.txtFecha.setDate(this.txtFecha.getDate());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBOcupacionesMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDBuscarOcupacion detalle = new JDBuscarOcupacion(null, true, this);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBOcupacionesActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AplicaFiltroConvenioActionPerformed(ActionEvent evt) {
        llenarComboConvenio(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoAfiliadoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoAfiliadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoPrescripcionMiPresKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarIngresoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty() && Principal.txtNo.getText() != null) {
            validateIngress();
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un Ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboCausaExternaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtSirasFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtSirasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtSirasKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboOrigenIngresoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaMisionMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaMisionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 113) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        mBuscar_Patologia(this.JTFCDxR1, this.JTFNDxR1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mBuscar_Patologia(this.JTFCDxR1, this.JTFNDxR1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxR1, this.JTFNDxR1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        mBuscar_Patologia(this.JTFCDxR2, this.JTFNDxR2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mBuscar_Patologia(this.JTFCDxR2, this.JTFNDxR2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxR2, this.JTFNDxR2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mBuscar_Patologia(this.JTFCDxR3, this.JTFNDxR3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3FocusLost(FocusEvent evt) {
        mBuscar_Patologia(this.JTFCDxR3, this.JTFNDxR3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3MouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxR3, this.JTFNDxR3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR3.transferFocus();
        }
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "cirugia", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    public void mVerificaCausaExterna() {
        if (Integer.parseInt(this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 2).toString()) == 2) {
            System.out.println("" + this.frmLlamador);
            switch (this.frmLlamador) {
                case "Facturac":
                    this.xJPEventoECat = new JPEventoECat(null, true, this.frmFacturac.frmPersona.IdPersona, Long.parseLong(this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0).toString()), Long.parseLong(this.xidCondVict[this.JCBCondVict.getSelectedIndex()]), getIdIngreso());
                    this.xJPEventoECat.setVisible(true);
                    break;
                case "CitaNP":
                    this.xJPEventoECat = new JPEventoECat(null, true, this.frmCitaNP1.frmPersona1.IdPersona, Long.parseLong(this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0).toString()), Long.parseLong(this.xidCondVict[this.JCBCondVict.getSelectedIndex()]), getIdIngreso());
                    this.xJPEventoECat.setVisible(true);
                    break;
                case "Atencion":
                    System.out.println("entro aca a generar");
                    this.xJPEventoECat = new JPEventoECat(null, true, this.frmAtencion.frmPersona.IdPersona, Long.parseLong(this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0).toString()), Long.parseLong(this.xidCondVict[this.JCBCondVict.getSelectedIndex()]), getIdIngreso());
                    this.xJPEventoECat.setVisible(true);
                    break;
            }
        }
    }

    @Generated
    public ButtonGroup getJBGTipoEstrato() {
        return this.JBGTipoEstrato;
    }

    @Generated
    public JButton getJBTActualizarIngreso() {
        return this.JBTActualizarIngreso;
    }

    @Generated
    public JComboBox getJCBCondVict() {
        return this.JCBCondVict;
    }

    @Generated
    public JComboBox getJCBEmpresaMision() {
        return this.JCBEmpresaMision;
    }

    @Generated
    public JComboBox getJCBEntornoAtencion() {
        return this.JCBEntornoAtencion;
    }

    @Generated
    public JTableComboBox getJCBEscolaridad() {
        return this.JCBEscolaridad;
    }

    @Generated
    public JComboBox getJCBModalidadAtencion() {
        return this.JCBModalidadAtencion;
    }

    @Generated
    public JComboBox getJCBOcupaciones() {
        return this.JCBOcupaciones;
    }

    @Generated
    public JComboBox getJCBParentescoAcompaniante() {
        return this.JCBParentescoAcompaniante;
    }

    @Generated
    public JComboBox getJCBTipoAfiliado() {
        return this.JCBTipoAfiliado;
    }

    @Generated
    public JComboBox getJCBTipoDocAcop() {
        return this.JCBTipoDocAcop;
    }

    @Generated
    public JComboBox getJCBTipoDocResp() {
        return this.JCBTipoDocResp;
    }

    @Generated
    public JComboBox getJCB_TipoCoberturaPlan() {
        return this.JCB_TipoCoberturaPlan;
    }

    @Generated
    public JComboBox getJCB_TipoContratacion() {
        return this.JCB_TipoContratacion;
    }

    @Generated
    public JCheckBox getJCHEsNuevaMuestra() {
        return this.JCHEsNuevaMuestra;
    }

    @Generated
    public JCheckBox getJCH_AplicaFiltroConvenio() {
        return this.JCH_AplicaFiltroConvenio;
    }

    @Generated
    public JLabel getJLBTDxRelacionados() {
        return this.JLBTDxRelacionados;
    }

    @Generated
    public JPanel getJPIAdicional() {
        return this.JPIAdicional;
    }

    @Generated
    public JPanel getJPIAdicional1() {
        return this.JPIAdicional1;
    }

    @Generated
    public JPanel getJPIDiagnostico() {
        return this.JPIDiagnostico;
    }

    @Generated
    public JPanel getJPIIngreso() {
        return this.JPIIngreso;
    }

    @Generated
    public JPanel getJPIResponsable() {
        return this.JPIResponsable;
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
    public JTextField getJTFCDxR1() {
        return this.JTFCDxR1;
    }

    @Generated
    public JTextField getJTFCDxR2() {
        return this.JTFCDxR2;
    }

    @Generated
    public JTextField getJTFCDxR3() {
        return this.JTFCDxR3;
    }

    @Generated
    public JTextField getJTFCie10() {
        return this.JTFCie10;
    }

    @Generated
    public JTextField getJTFNDxR1() {
        return this.JTFNDxR1;
    }

    @Generated
    public JTextField getJTFNDxR2() {
        return this.JTFNDxR2;
    }

    @Generated
    public JTextField getJTFNDxR3() {
        return this.JTFNDxR3;
    }

    @Generated
    public JTextField getJTFNoDocu() {
        return this.JTFNoDocu;
    }

    @Generated
    public JTextField getJTF_DNombre() {
        return this.JTF_DNombre;
    }

    @Generated
    public JTabbedPane getJTPDatosIngreso() {
        return this.JTPDatosIngreso;
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
    public JTableComboBox getCboCamas() {
        return this.cboCamas;
    }

    @Generated
    public JTableComboBox getCboCausaExterna() {
        return this.cboCausaExterna;
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
    public JTableComboBox getCboOrigenIngreso() {
        return this.cboOrigenIngreso;
    }

    @Generated
    public JTableComboBox getCboParentescoR() {
        return this.cboParentescoR;
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
    public JTableComboBox getCboUnidadCamas() {
        return this.cboUnidadCamas;
    }

    @Generated
    public JPanel getJPanel1() {
        return this.jPanel1;
    }

    @Generated
    public JPanel getJPanel2() {
        return this.jPanel2;
    }

    @Generated
    public JPanel getJPanel4() {
        return this.jPanel4;
    }

    @Generated
    public JTextField getTxtCedulaA() {
        return this.txtCedulaA;
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

    @Generated
    public JFormattedTextField getTxtNoPoliza() {
        return this.txtNoPoliza;
    }

    @Generated
    public JFormattedTextField getTxtNoPrescripcionMiPres() {
        return this.txtNoPrescripcionMiPres;
    }

    @Generated
    public JTextField getTxtNombreA() {
        return this.txtNombreA;
    }

    @Generated
    public JTextField getTxtNombreR() {
        return this.txtNombreR;
    }

    @Generated
    public JFormattedTextField getTxtSiras() {
        return this.txtSiras;
    }

    @Generated
    public JTextField getTxtTelefonoA() {
        return this.txtTelefonoA;
    }

    @Generated
    public JTextField getTxtTelefonoR() {
        return this.txtTelefonoR;
    }

    private void validateIngress() {
        try {
            this.ingresse = Integer.parseInt(Principal.txtNo.getText());
            int resultLiqu = 0;
            int resultOrden = 0;
            ConsultasMySQL xct = new ConsultasMySQL();
            if (this.ingresse > 0) {
                String sqlLiquidacion = "SELECT COUNT(Id) nRegistros FROM `f_liquidacion` WHERE Id_Ingreso=" + this.ingresse + "";
                ResultSet xrs = xct.traerRs(sqlLiquidacion);
                Throwable th = null;
                try {
                    try {
                        if (xrs.next()) {
                            resultLiqu = xrs.getInt("nRegistros");
                        }
                        String sqlOrdenes = "SELECT COUNT(Id) nRegistros FROM `f_ordenes` WHERE Id_Ingreso=" + this.ingresse + "";
                        ResultSet xrs1 = xct.traerRs(sqlOrdenes);
                        if (xrs1.next()) {
                            resultOrden = xrs1.getInt("nRegistros");
                        }
                        if (xrs != null) {
                            if (0 != 0) {
                                try {
                                    xrs.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                xrs.close();
                            }
                        }
                        xct.cerrarConexionBd();
                        if (resultLiqu == 0 && resultOrden == 0) {
                            updateIngress();
                        } else {
                            if (resultLiqu > 0) {
                                JOptionPane.showMessageDialog(this, "No es posible actualizar el ingreso ya que existe(n) " + resultLiqu + " registro(s) en la liquidacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                            if (resultOrden > 0) {
                                JOptionPane.showMessageDialog(this, "No es posible actualizar el ingreso ya que existe(n) " + resultOrden + " registro(s) en la orden", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                        }
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
        }
    }

    private void updateIngress() {
        int n = JOptionPane.showInternalConfirmDialog(this, "¿Esta seguro de actualizar el ingreso?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                this.sql = "UPDATE `ingreso` SET `Id_EmpresaContxConv`='" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getId() + "', `esCapitado`='" + this.listConvenio.get(this.cboEmpresa.getSelectedIndex()).getEsCapitado() + "', `SiCopago`='" + this.xcopago + "', `FechaIngreso`='" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "', `HoraIngreso`='" + this.metodos.formatoH24.format(this.txtHora.getValue()) + "', `Id_Estrato`='" + this.xidestrato[this.cboEstrato1.getSelectedIndex()][0] + "', `Id_OrigenAdmision`='" + this.cboOrigenIngreso.getPopupTable().getValueAt(this.cboOrigenIngreso.getSelectedIndex(), 0) + "', `Id_CausaExterna`='" + this.cboCausaExterna.getPopupTable().getValueAt(this.cboCausaExterna.getSelectedIndex(), 0) + "', `Id_Especialidad`='" + this.xidEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "', `Id_Profesional`='" + this.xIdProfesional[this.cboProfesional.getSelectedIndex()] + "', `Id_TipoAtencion`='" + this.cboTipoAtencion.getPopupTable().getValueAt(this.cboTipoAtencion.getSelectedIndex(), 0).toString() + "', `Id_Contrato`='" + this.cboContrato.getPopupTable().getValueAt(this.cboContrato.getSelectedIndex(), 0) + "',  NoPoliza='" + this.txtNoPoliza.getText() + "',  NoAutorizacion='" + this.txtNoAutorizacion.getText() + "',  `NAcompanante`='" + this.txtNombreA.getText() + "' , `TelefonoAcomp`='" + this.txtTelefonoA.getText() + "' , `TipoDocA`='" + this.JCBTipoDocAcop.getSelectedItem() + "' , `NoDocA`='" + this.txtCedulaA.getText() + "' , `NPersonaResp`='" + this.txtNombreR.getText() + "' , `TelefonoPResp`='" + this.txtTelefonoR.getText() + "' , `TipDoc`='" + this.JCBTipoDocResp.getSelectedItem() + "' , `Id_Sede`='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' , `NoDocumento`='" + this.JTFNoDocu.getText() + "' , `Id_NivelEstudio`='" + this.JCBEscolaridad.getPopupTable().getValueAt(this.JCBEscolaridad.getSelectedIndex(), 0) + "' , `Id_Parentesco`='" + this.cboParentescoR.getPopupTable().getValueAt(this.cboParentescoR.getSelectedIndex(), 0) + "' , `Id_Ocupacion`='" + this.xidocupaciones[this.JCBOcupaciones.getSelectedIndex()] + "' , `Id_CondVict`='" + this.xCondiVict + "' , `DxIngreso`='" + this.JTFCie10.getText().toUpperCase() + "' , `idTipoAfiliacion`='" + this.xidTipoAfiliado[this.JCBTipoAfiliado.getSelectedIndex()][0] + "' , idTipoContratacion='" + this.xidTipoContratacion[this.JCB_TipoContratacion.getSelectedIndex()][0] + "' , idTipoCoberturaPlan='" + this.xidTipoCobertura[this.JCB_TipoCoberturaPlan.getSelectedIndex()][0] + "' , fechaActualizacion = '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' , usuarioSistemaActualizacion = '" + Principal.usuarioSistemaDTO.getLogin() + "' Where Id='" + this.ingresse + "'";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                if (this.JCBCondVict.getSelectedIndex() != -1) {
                    String sql2 = "UPDATE `a_eventoecat_paciente` SET `Id_condvictima`='" + this.xidCondVict[this.JCBCondVict.getSelectedIndex()] + "' WHERE Id_Ingreso='" + this.ingresse + "'";
                    this.consultas.ejecutarSQL(sql2);
                    this.consultas.cerrarConexionBd();
                }
                JOptionPane.showInternalMessageDialog(this, "REGISTRO GUARDADO", "OK", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            } catch (Exception e) {
                JOptionPane.showInternalMessageDialog(this, "ERROR AL ACTUALIZAR", "ERROR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            }
            this.ingresse = 0;
        }
    }
}
