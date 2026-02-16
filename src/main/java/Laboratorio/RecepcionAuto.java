package Laboratorio;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import PyP.clasePyP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.genoma.plus.controller.general.JDHistoricoTrazabilidad;
import com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos;
import com.genoma.plus.controller.laboratorio.dto.StickerPrintDto;
import com.genoma.plus.controller.sgc.JDConsentimientoInformado;
import com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaDAOImpl;
import com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl;
import com.genoma.plus.dao.impl.sgc.ConsentimientoInformadoDAOImpl;
import com.genoma.plus.dao.integracion_simedis.IntegracionExternaDAO;
import com.genoma.plus.dao.integracion_simedis.LaboratorioDAO;
import com.genoma.plus.dao.sgc.ConsentimientoInformadoDAO;
import com.genoma.plus.dto.sgc.ConsentimientoInformadoDTO;
import com.genoma.plus.jpa.projection.StikerProjection;
import com.genoma.plus.jpa.service.RecepcionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/RecepcionAuto.class */
public class RecepcionAuto extends JInternalFrame {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    public Persona frmPersona;
    public DefaultTableModel modelo;
    private String xsql;
    private String id;
    private String xidProfesional;
    private String xidEspecialidad;
    private String xidempresacont;
    public String xidnrecepcion;
    public String xTipo;
    public int xUrgente;
    public int xBrigada;
    private Object[] fila;
    private String[][] parametros;
    private int filaGrid;
    private int xlproc;
    private int xIdTipoAtencion;
    private boolean xtipog;
    private double ximc;
    private long xId_Rechazo;
    private String idOrdenExterna;
    private String idOrdenAnterior;
    private Long idIngreso;
    private Long IdOrdenGenomaGIIS;
    private Boolean filtroProcedimientoCovid;
    private String codigoCups;
    private IntegracionExternaDAO integracionExternaDAO;
    private List<StikerProjection> listaStiker;
    private String Ng;
    private final RecepcionService recepcionService;
    private int envioCorreo;
    private int imprimirArea;
    private String xIdProcedimientos;
    private ConsentimientoInformadoDAO xConsentimientoInformadoDAO;
    private JButton JBTCargarPDF;
    private JButton JBTCerrar;
    private JButton JBTCerrar1;
    private JButton JBTCerrar2;
    private JButton JBTCerrar3;
    private JButton JBTConsultarHC;
    private JButton JBTEventoAdverso1;
    private JButton JBTVisualizacionCOvid;
    private JButton JBT_InfoTrazabilidad;
    private JCheckBox JCHAgrupar;
    private JCheckBox JCHBrigada;
    private JCheckBox JCHCitologia;
    private JCheckBox JCHCorreo;
    private JCheckBox JCHUrgente;
    public JDateChooser JDF_Fecha;
    public JDateChooser JDF_Fecha_Toma;
    private JTextField JTFConsecutivo;
    private JFormattedTextField JTFFNRecepcion;
    private JFormattedTextField JTFFSCorporal1;
    private JFormattedTextField JTFFSIMC1;
    private JFormattedTextField JTFFSPerimetroAbd1;
    private JFormattedTextField JTFFSPeso1;
    private JFormattedTextField JTFFSTalla1;
    private JTextField JTFIdRecepcion;
    private JTextField JTFMedicoTratante;
    public JTable grid;
    private JPanel jPanel1;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelPersona;
    public JTextField txtNoOrden;
    private JEditorPane txtObservaciones;
    private JTextField txtProfesional;

    public RecepcionAuto(String xnombre, int xlproc, String idOrdenExterna) {
        this.consultas = new ConsultasMySQL();
        this.id = "";
        this.xidProfesional = "0";
        this.xidEspecialidad = "0";
        this.xidempresacont = "0";
        this.xidnrecepcion = "0";
        this.xTipo = "1^General";
        this.xUrgente = 0;
        this.xBrigada = 0;
        this.xlproc = 0;
        this.xIdTipoAtencion = 1;
        this.xtipog = false;
        this.ximc = 0.0d;
        this.xId_Rechazo = 0L;
        this.idOrdenExterna = "0";
        this.idOrdenAnterior = null;
        this.filtroProcedimientoCovid = false;
        this.codigoCups = "";
        this.Ng = "";
        this.recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
        this.envioCorreo = 0;
        this.imprimirArea = 0;
        this.xIdProcedimientos = "";
        initComponents();
        springStart();
        setName(xnombre);
        this.metodos = new Metodos(false);
        activarBotonInfoTrazabilidad();
        this.xlproc = xlproc;
        setIdOrdenExterna(idOrdenExterna);
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.JCHBrigada.setText("Llamar?");
        }
        if (!Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
            if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                this.JTFConsecutivo.setVisible(false);
            } else {
                this.JTFConsecutivo.setVisible(true);
            }
        }
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            mBuscarRecepcionGIIS(idOrdenExterna);
        }
        iniciar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionAuto.1
            public void mouseClicked(MouseEvent e) {
                RecepcionAuto.this.filaGrid = RecepcionAuto.this.grid.rowAtPoint(e.getPoint());
            }
        });
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            this.metodos.getInfoSticker();
        }
    }

    public RecepcionAuto(String xnombre, int xlproc, String idOrdenExterna, Long idOrdenGenomaGIIS, String Obsevacion, String numeroG) {
        this.consultas = new ConsultasMySQL();
        this.id = "";
        this.xidProfesional = "0";
        this.xidEspecialidad = "0";
        this.xidempresacont = "0";
        this.xidnrecepcion = "0";
        this.xTipo = "1^General";
        this.xUrgente = 0;
        this.xBrigada = 0;
        this.xlproc = 0;
        this.xIdTipoAtencion = 1;
        this.xtipog = false;
        this.ximc = 0.0d;
        this.xId_Rechazo = 0L;
        this.idOrdenExterna = "0";
        this.idOrdenAnterior = null;
        this.filtroProcedimientoCovid = false;
        this.codigoCups = "";
        this.Ng = "";
        this.recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
        this.envioCorreo = 0;
        this.imprimirArea = 0;
        this.xIdProcedimientos = "";
        initComponents();
        springStart();
        setName(xnombre);
        activarBotonInfoTrazabilidad();
        this.Ng = numeroG;
        this.metodos = new Metodos(false);
        this.xlproc = xlproc;
        setIdOrdenExterna(idOrdenExterna);
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.JCHBrigada.setText("Llamar?");
        }
        if (!Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
            if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                this.JTFConsecutivo.setVisible(true);
            } else {
                this.JTFConsecutivo.setVisible(false);
            }
        }
        this.IdOrdenGenomaGIIS = idOrdenGenomaGIIS;
        this.txtNoOrden.setText(Long.toString(this.IdOrdenGenomaGIIS.longValue()));
        this.txtObservaciones.setText(Obsevacion);
        iniciar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionAuto.2
            public void mouseClicked(MouseEvent e) {
                RecepcionAuto.this.filaGrid = RecepcionAuto.this.grid.rowAtPoint(e.getPoint());
            }
        });
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            mBuscarRecepcionGIIS(idOrdenExterna);
        }
        if (Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            this.metodos.getInfoSticker();
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.integracionExternaDAO = (IntegracionExternaDAOImpl) classPathXmlApplicationContext.getBean("integracionExternaDAOImpl");
        this.xConsentimientoInformadoDAO = (ConsentimientoInformadoDAOImpl) classPathXmlApplicationContext.getBean("consentimientoInformadoDAO");
    }

    public void activarNumeracionCitologia() {
        if (this.JCHCitologia.isSelected()) {
            System.out.println(" enttrooooo  : ");
            this.JTFConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo - Placa", 2, 0, new Font("Arial", 1, 14), Color.red));
            this.JTFConsecutivo.setVisible(true);
        }
    }

    private void activarBotonInfoTrazabilidad() {
        if (!Principal.informacionIps.getAplicaMicroservicios().booleanValue()) {
            this.JBT_InfoTrazabilidad.setVisible(false);
        }
    }

    private void actualizarEstadoRecepOrden() {
        this.xsql = "update f_ordenes set EstadoRecep=1, Id_OrdenRecep='" + this.xidnrecepcion + "' where Id='" + this.txtNoOrden.getText() + "'";
        this.consultas.ejecutarSQL(this.xsql);
        this.consultas.cerrarConexionBd();
    }

    public void anular() {
        if (this.xidnrecepcion.equals("0")) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Número de Toma para Anular");
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("La Toma de Muestra ya se encuentra Anulada.");
        } else {
            Anular frm = new Anular(null, true, "Recepcion", 24);
            frm.setVisible(true);
        }
    }

    public void anularOrden(String razon) {
        this.xsql = "UPDATE l_recepcion SET Estado ='" + razon + "' WHERE Id='" + this.JTFIdRecepcion.getText() + "'";
        this.consultas.ejecutarSQL(this.xsql);
        this.consultas.cerrarConexionBd();
        this.xsql = "UPDATE f_ordenes SET Id_OrdenRecep =0, EstadoRecep=0  WHERE Id_OrdenRecep='" + this.JTFIdRecepcion.getText() + "'";
        this.consultas.ejecutarSQL(this.xsql);
        this.consultas.cerrarConexionBd();
        this.xsql = "UPDATE l_recepcion_citologia SET Estado =0  WHERE Id_Recepcion='" + this.JTFIdRecepcion.getText() + "'";
        this.consultas.ejecutarSQL(this.xsql);
        this.consultas.cerrarConexionBd();
        this.metodos.getInterceptor(this.idIngreso, "ANULAR RECEPCIÓN", "Se anula recepción".concat(" No. ").concat(this.JTFIdRecepcion.getText()), false);
        this.metodos.marcarEstado(1);
        this.metodos.mostrarMensaje("Toma de Muestra Anulada");
    }

    public void buscar() {
        BuscarOrden frm = new BuscarOrden(null, true, this.frmPersona.getIdPersona(), this, "Recepcion");
        frm.setVisible(true);
    }

    public void buscarOrden() {
        String idPaciente = "0";
        crearGrid();
        switch (Principal.informacionIps.getNombreIps()) {
            case "LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.":
                this.xsql = "select\n\tl_codigoprouni.Id_CodProcedUnif,\n\tg_procedimiento.Nbre,\n\tf_itemordenesproced.Cantidad,\n\tf_ordenes.Id,\n\tf_tipoprocedimiento.Id,\n\tf_ordenes.FechaOrden,\n\tprofesional.NProfesional,\n\tprofesional.Id_Persona,\n\tingreso.Id_Usuario,\n\tf_ordenes.Id_Especialidad,\n\tingreso.Id_EmpresaContxConv,\n\tf_ordenes.Id_OrdenRecep,\n\tg_procedimiento.Oportunidad,\n\tf_ordenes.LProcesamiento ,\n\t\tIFNULL((\n\tSELECT\n\t`h_itemordenesproced`.`Descripcion`\n\tFROM\n\t`h_itemordenesproced`\n\tWHERE\n\t(h_itemordenesproced.`Id_Orden_Fac` = f_ordenes.Id\n\tAND h_itemordenesproced.`Estado` = 0\n\tAND h_itemordenesproced.`Id_Procedimiento` = f_itemordenesproced.`Id_Procedimiento`)\n\tGROUP BY f_ordenes.Id),\t'') AS Observacion,\n\tingreso.Id_TipoAtencion,\n\t`l_tipo_tubo`.`Nbre` as Tubo,\n\tif(l_recepcion.`Observaciones` is null,\n\tingreso.`Observacion`,\n\tl_recepcion.`Observaciones`) DetObservacionC,\n\tIFNULL(l_detallerecepcion.`PMuestra`, 0) as `PMuestra`,\n\tingreso.Id as idIngreso,\n\tf_itemordenesproced.`codigoEnvioBs1`,\n\tf_itemordenesproced.`NAutorizacion` ,\n\tingreso.`NoAutorizacion` ,\n\tcodigoEncabezadoOrdenBs1,\n\tl_recepcion.consecutivo,\n\tl_recepcion.Fecha_Toma ,\n date_format(l_recepcion.FechaRecep, '%Y%m%d') as fechaRecepcionConcatenado,\n\tif(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento, g_procedimiento.`Id_Area`, g_procedimiento.EsRemitido, concat(lrc.Ano , lrc.Id_Consecutivo )consecutivoCitologia\nfrom\n\tf_ordenes\ninner join f_itemordenesproced on\n\t(f_itemordenesproced.Id_Ordenes = f_ordenes.Id)\ninner join l_codigoprouni on\n\t(f_itemordenesproced.Id_Procedimiento = l_codigoprouni.`Id_Procedimiento`)\ninner join g_procedimiento on\n\t(l_codigoprouni.Id_CodProcedUnif = g_procedimiento.Id)\ninner join f_tipoprocedimiento on\n\t(g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\ninner join profesional on\n\t(profesional.Id_Persona = f_ordenes.Id_Profesional)\ninner join ingreso on\n\t(f_ordenes.Id_Ingreso = ingreso.Id)\nleft join `l_tipo_tubo` on\n\t(l_tipo_tubo.`Id` = g_procedimiento.`Id_Tubo`)\nleft join `l_recepcion` on\n\t(l_recepcion.`Id` = f_ordenes.Id_OrdenRecep)\nleft join `l_detallerecepcion`\n   on\n\t(l_detallerecepcion.`Id_Recepcion` = f_ordenes.Id_OrdenRecep)\n\tand (l_detallerecepcion.`Id_Procedim` = l_codigoprouni.Id_CodProcedUnif)\nLEFT JOIN ( SELECT g_procedimientoxconsentimiento.Id_Procedimiento FROM g_procedimientoxconsentimiento \n \tWHERE g_procedimientoxconsentimiento.Estado =1 GROUP BY g_procedimientoxconsentimiento.Id_Procedimiento) f\n \tON (f.Id_Procedimiento=g_procedimiento.Id) \nleft join l_recepcion_citologia lrc on (lrc.Id_Recepcion=l_recepcion.Id) and (lrc.Estado=1)\nwhere\n\t(f_ordenes.Id = '" + this.txtNoOrden.getText() + "'\n\t\tand l_codigoprouni.Estado = 1)\norder by\n\tg_procedimiento.Nbre asc";
                break;
            case "LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.":
            case "LABORATORIO CLINICO CENTRAL":
            case "CENTRO MÉDICO SERVIFARMA IPS S.A.S.":
                this.xsql = "SELECT l_codigoprouni.Id_CodProcedUnif, g_procedimiento.Nbre, f_itemordenesproced.Cantidad, f_ordenes.Id, f_tipoprocedimiento.Id,   \n f_ordenes.FechaOrden, profesional.NProfesional, profesional.Id_Persona, ingreso.Id_Usuario, f_ordenes.Id_Especialidad, ingreso.Id_EmpresaContxConv, f_ordenes.Id_OrdenRecep, g_procedimiento.Oportunidad, f_ordenes.LProcesamiento   \n ,IF((SELECT  `h_itemordenesproced`.`Descripcion` FROM `h_itemordenesproced` WHERE (h_itemordenesproced.`Id_Orden_Fac` =f_ordenes.Id AND h_itemordenesproced.`Estado` =0 AND h_itemordenesproced.`Id_Procedimiento`=f_itemordenesproced.`Id_Procedimiento`) GROUP BY f_ordenes.Id) IS NULL, '',(SELECT `h_itemordenesproced`.`Descripcion`   \n FROM `h_itemordenesproced` WHERE (h_itemordenesproced.`Id_Orden_Fac` =f_ordenes.Id  AND h_itemordenesproced.`Estado` =0 AND h_itemordenesproced.`Id_Procedimiento`=f_itemordenesproced.`Id_Procedimiento`) GROUP BY f_ordenes.Id)) AS Observacion  \n , ingreso.Id_TipoAtencion, `l_tipo_tubo`.`Nbre` AS Tubo, IFNULL(d.Det,'') DetObservacionC, IFNULL(l_detallerecepcion.`PMuestra`, 0) AS `PMuestra`, ingreso.Id AS idIngreso  \n , f_itemordenesproced.`codigoEnvioBs1` , f_itemordenesproced.`NAutorizacion` , ingreso.`NoAutorizacion` , codigoEncabezadoOrdenBs1, l_recepcion.consecutivo, l_recepcion.Fecha_Toma , date_format(l_recepcion.FechaRecep, '%Y%m%d') as fechaRecepcionConcatenado , IF(f.Id_Procedimiento IS NULL, 0, 1) aplicaConsentimiento\n, g_procedimiento.`Id_Area`, g_procedimiento.EsRemitido , concat(lrc.Ano , lrc.Id_Consecutivo )consecutivoCitologia\n FROM f_ordenes   \n INNER JOIN f_itemordenesproced   \n     ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   \n INNER JOIN l_codigoprouni   \n     ON (f_itemordenesproced.Id_Procedimiento = l_codigoprouni.`Id_Procedimiento`)   \n INNER JOIN g_procedimiento   \n     ON (l_codigoprouni.Id_CodProcedUnif = g_procedimiento.Id)   \n INNER JOIN f_tipoprocedimiento   \n     ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)   \n INNER JOIN profesional   \n     ON (profesional.Id_Persona = f_ordenes.Id_Profesional)   \n INNER JOIN ingreso   \n     ON (f_ordenes.Id_Ingreso = ingreso.Id)   \n LEFT JOIN `l_tipo_tubo`   \n     ON (l_tipo_tubo.`Id` = g_procedimiento.`Id_Tubo`)   \n LEFT JOIN (SELECT  \n     GROUP_CONCAT(`h_itemordenesproced`.`Descripcion` SEPARATOR',') Det, `h_ordenes`.`IdOrdenFact`  \n FROM  \n      `h_itemordenesproced`  \n     INNER JOIN  `h_ordenes`   \n         ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)  \n WHERE (`h_itemordenesproced`.`Descripcion`<>'')  GROUP BY `h_ordenes`.`Id` ) d   \n    ON d.IdOrdenFact=f_ordenes.Id   \n LEFT JOIN `l_recepcion`\n    ON (`l_recepcion`.Id_OrdenFacturac = f_ordenes.Id )\n LEFT JOIN `l_detallerecepcion`  \n    ON (l_detallerecepcion.`Id_Recepcion`= l_recepcion.Id ) AND (l_detallerecepcion.`Id_Procedim`=l_codigoprouni.Id_CodProcedUnif)  \n  LEFT JOIN ( SELECT g_procedimientoxconsentimiento.Id_Procedimiento FROM g_procedimientoxconsentimiento \n \tWHERE g_procedimientoxconsentimiento.Estado =1 GROUP BY g_procedimientoxconsentimiento.Id_Procedimiento) f\n ON (f.Id_Procedimiento=g_procedimiento.Id) \nleft join l_recepcion_citologia lrc on (lrc.Id_Recepcion=l_recepcion.Id) and (lrc.Estado=1)\n WHERE (f_ordenes.Id ='" + this.txtNoOrden.getText() + "' AND l_codigoprouni.Estado=1) ORDER BY g_procedimiento.Nbre ASC";
                break;
            default:
                this.xsql = "SELECT l_codigoprouni.Id_CodProcedUnif, g_procedimiento.Nbre, f_itemordenesproced.Cantidad, f_ordenes.Id, f_tipoprocedimiento.Id,   \n f_ordenes.FechaOrden, profesional.NProfesional, profesional.Id_Persona, ingreso.Id_Usuario, f_ordenes.Id_Especialidad, ingreso.Id_EmpresaContxConv, f_ordenes.Id_OrdenRecep, g_procedimiento.Oportunidad, f_ordenes.LProcesamiento   \n ,IF((SELECT  `h_itemordenesproced`.`Descripcion` FROM `h_itemordenesproced` WHERE (h_itemordenesproced.`Id_Orden_Fac` =f_ordenes.Id AND h_itemordenesproced.`Estado` =0 AND h_itemordenesproced.`Id_Procedimiento`=f_itemordenesproced.`Id_Procedimiento`) GROUP BY f_ordenes.Id) IS NULL, '',(SELECT `h_itemordenesproced`.`Descripcion`   \n FROM `h_itemordenesproced` WHERE (h_itemordenesproced.`Id_Orden_Fac` =f_ordenes.Id  AND h_itemordenesproced.`Estado` =0 AND h_itemordenesproced.`Id_Procedimiento`=f_itemordenesproced.`Id_Procedimiento`) GROUP BY f_ordenes.Id)) AS Observacion  \n , ingreso.Id_TipoAtencion, `l_tipo_tubo`.`Nbre` AS Tubo, IFNULL(d.Det,'') DetObservacionC, IFNULL(l_detallerecepcion.`PMuestra`, 0) AS `PMuestra`, ingreso.Id AS idIngreso  \n , f_itemordenesproced.`codigoEnvioBs1` , f_itemordenesproced.`NAutorizacion` , ingreso.`NoAutorizacion` , codigoEncabezadoOrdenBs1, l_recepcion.consecutivo,l_recepcion.Fecha_Toma , date_format(l_recepcion.FechaRecep, '%Y%m%d') as fechaRecepcionConcatenado , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento\n , g_procedimiento.`Id_Area`, g_procedimiento.EsRemitido , concat(lrc.Ano , lrc.Id_Consecutivo )consecutivoCitologia \nFROM f_ordenes   \n INNER JOIN f_itemordenesproced   \n     ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   \n INNER JOIN l_codigoprouni   \n     ON (f_itemordenesproced.Id_Procedimiento = l_codigoprouni.`Id_Procedimiento`)   \n INNER JOIN g_procedimiento   \n     ON (l_codigoprouni.Id_CodProcedUnif = g_procedimiento.Id)   \n INNER JOIN f_tipoprocedimiento   \n     ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)   \n INNER JOIN profesional   \n     ON (profesional.Id_Persona = f_ordenes.Id_Profesional)   \n INNER JOIN ingreso   \n     ON (f_ordenes.Id_Ingreso = ingreso.Id)   \n LEFT JOIN `l_tipo_tubo`   \n     ON (l_tipo_tubo.`Id` = g_procedimiento.`Id_Tubo`)   \n LEFT JOIN (SELECT  \n     GROUP_CONCAT(`h_itemordenesproced`.`Descripcion` SEPARATOR',') Det, `h_ordenes`.`IdOrdenFact`  \n FROM  \n      `h_itemordenesproced`  \n     INNER JOIN  `h_ordenes`   \n         ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)  \n WHERE (`h_itemordenesproced`.`Descripcion`<>'')  GROUP BY `h_ordenes`.`Id` ) d   \n    ON d.IdOrdenFact=f_ordenes.Id   \n LEFT JOIN `l_recepcion`\n    ON (`l_recepcion`.Id_OrdenFacturac = f_ordenes.Id )\n LEFT JOIN `l_detallerecepcion`  \n    ON (l_detallerecepcion.`Id_Recepcion`= l_recepcion.Id ) AND (l_detallerecepcion.`Id_Procedim`=l_codigoprouni.Id_CodProcedUnif)  \n  left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id)  left join l_recepcion_citologia lrc on (lrc.Id_Recepcion=l_recepcion.Id) and (lrc.Estado=1)\n WHERE (f_ordenes.Id ='" + this.txtNoOrden.getText() + "' AND l_codigoprouni.Estado=1) ORDER BY g_procedimiento.Nbre ASC";
                break;
        }
        ResultSet rs = this.consultas.traerRs(this.xsql);
        try {
            this.metodos.mEstablecerTextEditor(this.grid, 1);
            this.metodos.mEstablecerTextEditor(this.grid, 6);
            this.JDF_Fecha.setDate(this.metodos.getFechaActual());
            this.JDF_Fecha_Toma.setDate(this.metodos.getFechaActual());
            if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                this.JDF_Fecha_Toma.setEnabled(false);
            }
            if (rs.next()) {
                rs.first();
                this.xlproc = rs.getInt("LProcesamiento");
                this.xIdTipoAtencion = rs.getInt("Id_TipoAtencion");
                this.txtObservaciones.setText(rs.getString("DetObservacionC"));
                this.idIngreso = Long.valueOf(rs.getLong("idIngreso"));
                try {
                    this.JDF_Fecha.setDate(this.metodos.formatoAMDG.parse(rs.getString("FechaOrden")));
                } catch (Exception e) {
                    System.out.println("Error formateando la fecha>>>>> " + e.getMessage());
                }
                try {
                    this.JDF_Fecha_Toma.setDate(this.metodos.formatoAMDG.parse(rs.getString("Fecha_Toma")));
                } catch (Exception e2) {
                    System.out.println("Error formateando la fecha>>>>> " + e2.getMessage());
                }
                System.out.println("" + rs.getString("consecutivoCitologia"));
                String consecutivo = rs.getString("consecutivoCitologia");
                if (consecutivo != null) {
                    this.JTFConsecutivo.setText(consecutivo);
                }
                List<ConsentimientoInformadoDTO> listConsentimientos = this.xConsentimientoInformadoDAO.listConcentimientoInf(this.idIngreso.toString());
                String pendientesPorConsentimiento = "";
                rs.beforeFirst();
                while (rs.next()) {
                    this.modelo.addRow(this.fila);
                    this.modelo.setValueAt(rs.getString("Id_CodProcedUnif"), this.filaGrid, 0);
                    this.modelo.setValueAt(rs.getString("Nbre"), this.filaGrid, 1);
                    this.modelo.setValueAt(rs.getString("Cantidad"), this.filaGrid, 2);
                    this.modelo.setValueAt(rs.getString("Oportunidad"), this.filaGrid, 4);
                    this.modelo.setValueAt(Boolean.valueOf(rs.getBoolean("PMuestra")), this.filaGrid, 5);
                    this.modelo.setValueAt(rs.getString("Observacion"), this.filaGrid, 6);
                    this.modelo.setValueAt(1, this.filaGrid, 7);
                    this.modelo.setValueAt(true, this.filaGrid, 3);
                    this.modelo.setValueAt(rs.getString("Tubo"), this.filaGrid, 8);
                    this.modelo.setValueAt(new JButton("Imprimir"), this.filaGrid, 9);
                    if (rs.getString("aplicaConsentimiento").equals("1")) {
                        this.modelo.setValueAt(new JButton("Generación"), this.filaGrid, 14);
                        if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
                            try {
                                AtomicBoolean pendienteConsentimiento = new AtomicBoolean(true);
                                listConsentimientos.forEach(obj -> {
                                    try {
                                        if (obj.getIdProcedimiento().equals(rs.getString("Id_CodProcedUnif"))) {
                                            pendienteConsentimiento.set(false);
                                        }
                                    } catch (Exception ex) {
                                        Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                                    }
                                });
                                if (pendienteConsentimiento.get()) {
                                    pendientesPorConsentimiento = "\n- " + pendientesPorConsentimiento + rs.getString("Nbre");
                                }
                            } catch (Exception e3) {
                            }
                        }
                    } else {
                        this.modelo.setValueAt(new JButton(""), this.filaGrid, 14);
                    }
                    this.txtProfesional.setText(rs.getString("NProfesional"));
                    this.xidProfesional = rs.getString("Id_Persona");
                    this.xidEspecialidad = rs.getString("Id_Especialidad");
                    this.xidempresacont = rs.getString("Id_EmpresaContxConv");
                    idPaciente = rs.getString("Id_Usuario");
                    if (rs.getLong(12) != 0) {
                        this.JTFIdRecepcion.setText(rs.getString("Id_OrdenRecep"));
                        if (!Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                            this.JTFConsecutivo.setText(rs.getString("Id"));
                        } else {
                            String fechaActualConcatenada = this.metodos.formatoAMD_Unida.format(this.metodos.getFechaActual());
                            if (!rs.getString("fechaRecepcionConcatenado").equals(fechaActualConcatenada)) {
                                String formatted = String.format("%03d", Integer.valueOf(rs.getInt("consecutivo")));
                                this.JTFConsecutivo.setText(rs.getString("fechaRecepcionConcatenado") + "" + formatted);
                            } else {
                                this.JTFConsecutivo.setText(rs.getString("consecutivo"));
                            }
                        }
                        this.xidnrecepcion = rs.getString("Id_OrdenRecep");
                    }
                    switch (rs.getString("Id_CodProcedUnif")) {
                        case "898001":
                        case "892901":
                        case "898002":
                            if (!this.JCHCitologia.isSelected()) {
                                this.JCHCitologia.setSelected(true);
                                this.xTipo = "2^Citología";
                                break;
                            }
                        case "906270":
                        case "906340":
                        case "1900000":
                        case "908856":
                        case "10027":
                        case "30025":
                            this.filtroProcedimientoCovid = true;
                            this.codigoCups = rs.getString("Id_CodProcedUnif");
                            break;
                    }
                    if (this.JCHCitologia.isSelected()) {
                        this.JTFConsecutivo.setText(rs.getString("consecutivoCitologia"));
                    }
                    this.modelo.setValueAt(rs.getString("codigoEnvioBs1"), this.filaGrid, 10);
                    this.modelo.setValueAt(rs.getString("NAutorizacion"), this.filaGrid, 11);
                    this.modelo.setValueAt(rs.getString("NoAutorizacion"), this.filaGrid, 12);
                    this.modelo.setValueAt(rs.getString("codigoEncabezadoOrdenBs1"), this.filaGrid, 13);
                    this.modelo.setValueAt(rs.getString("Id_Area"), this.filaGrid, 15);
                    this.modelo.setValueAt(false, this.filaGrid, 16);
                    this.modelo.setValueAt(Boolean.valueOf(rs.getBoolean("EsRemitido")), this.filaGrid, 17);
                    this.filaGrid++;
                }
                if (!pendientesPorConsentimiento.isEmpty()) {
                    String mensaje = "<html><body style='width: 300px;'>" + pendientesPorConsentimiento + "</body></html>";
                    JOptionPane.showMessageDialog((Component) null, mensaje, "Procedimientos pendientes por autorización (Consentimiento informado)", 1);
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            this.frmPersona.setIdPersona(idPaciente);
            this.frmPersona.buscar(1);
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String getIdOrdenExterna() {
        return this.idOrdenExterna;
    }

    public void setIdOrdenExterna(String idOrdenExterna) {
        this.idOrdenExterna = idOrdenExterna;
    }

    private String mGenerar_CCitologia() {
        String sql;
        String xNoAtencion = null;
        if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
            sql = "SELECT IF( MAX(l_recepcion_citologia.`Id_Consecutivo`) IS NULL, 1, (MAX(l_recepcion_citologia.`Id_Consecutivo`)+1)) AS NConsecutivo FROM `l_recepcion_citologia`  inner join l_recepcion on (l_recepcion.Id=l_recepcion_citologia.Id_Recepcion)WHERE (l_recepcion_citologia.`Ano` ='" + this.metodos.formatoANO.format(this.JDF_Fecha.getDate()) + "' and l_recepcion.Id_Sede = '" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND l_recepcion_citologia.`Estado` =1)";
        } else {
            sql = "SELECT IF( MAX(`Id_Consecutivo`) IS NULL, 1, (MAX(`Id_Consecutivo`)+1)) AS NConsecutivo FROM `l_recepcion_citologia` WHERE (`Ano` ='" + this.metodos.formatoANO.format(this.JDF_Fecha.getDate()) + "' AND `Estado` =1)";
        }
        System.out.println("es : " + sql);
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xNoAtencion = xrs.getString("NConsecutivo");
                this.JTFConsecutivo.setText(this.metodos.formatoANO.format(this.JDF_Fecha.getDate()) + this.metodos.numeroCerosIzquierda(Long.valueOf(xrs.getLong("NConsecutivo")), 8));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xNoAtencion;
    }

    private void mGrabar_CCitologia() {
        if (this.JCHCitologia.isSelected()) {
            try {
                ConsultasMySQL xct = new ConsultasMySQL();
                String sql = "SELECT\n    `Id_Recepcion`\n    , `Ano`\n    , `Id_Consecutivo`\n    , `Estado`\nFROM\n    `l_recepcion_citologia`\nWHERE (`Id_Recepcion` ='" + this.xidnrecepcion + "'\n    AND `Estado` =1);";
                ResultSet xrs = xct.traerRs(sql);
                Throwable th = null;
                try {
                    try {
                        if (!xrs.next()) {
                            this.xsql = "insert into l_recepcion_citologia(`Id_Recepcion` , `Ano` , `Id_Consecutivo` , `Estado` , `Id_UsuarioS`) values ('" + this.xidnrecepcion + "','" + this.metodos.formatoANO.format(this.JDF_Fecha.getDate()) + "','" + mGenerar_CCitologia() + "','1','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
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
                Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void ActualizaMuestraPendiente(int fila) {
        this.xsql = "UPDATE l_detallerecepcion SET PMuestra=" + Boolean.valueOf(this.modelo.getValueAt(fila, 5).toString()) + " where Id_Recepcion=" + this.JTFIdRecepcion.getText() + " AND Id_Procedim=" + this.modelo.getValueAt(fila, 0);
        this.consultas.ejecutarSQL(this.xsql);
        this.consultas.cerrarConexionBd();
    }

    private void cargarPanelPersonas() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(false);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 950, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    private void cargarFichaCovid() {
        if (!this.filtroProcedimientoCovid.booleanValue() || Principal.informacionIps.getIdentificacion().equals("900895500")) {
            return;
        }
        JDIngresoInformacionPruebaCovid jd = new JDIngresoInformacionPruebaCovid(null, true, this.idIngreso, this.codigoCups);
        jd.setLocationRelativeTo(this);
        jd.setVisible(true);
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Examen", "Cantidad", "Realizar", "Días de Entrega", "Pendiente(Muestra)", "Observación", "Id_Rechazo", "Tubo", "Stiker", "CodigoBs1", "CodigoExamenbs1", "NautoIngreso", "CodigoCabezeraOrdenBs1", "Consentimiento Informado", "area", "Areas", "esRemitido"}) { // from class: Laboratorio.RecepcionAuto.3
            Class[] types = {String.class, String.class, Integer.class, Boolean.class, String.class, Boolean.class, String.class, Integer.class, String.class, JButton.class, String.class, String.class, String.class, String.class, JButton.class, String.class, Boolean.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        this.grid.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Laboratorio.RecepcionAuto.4
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.grid.setModel(this.modelo);
        this.grid.setAutoResizeMode(0);
        this.grid.doLayout();
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(2).setMinWidth(0);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(110);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(7).setMinWidth(0);
        this.grid.getColumnModel().getColumn(7).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(10).setMinWidth(0);
        this.grid.getColumnModel().getColumn(10).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(11).setMinWidth(0);
        this.grid.getColumnModel().getColumn(11).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(12).setMinWidth(0);
        this.grid.getColumnModel().getColumn(12).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(13).setMinWidth(0);
        this.grid.getColumnModel().getColumn(13).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(15).setMinWidth(0);
        this.grid.getColumnModel().getColumn(15).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(16).setMinWidth(50);
        this.grid.getColumnModel().getColumn(16).setMaxWidth(50);
        this.grid.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(17).setMinWidth(50);
        this.grid.getColumnModel().getColumn(17).setMaxWidth(50);
        this.filaGrid = 0;
    }

    public void desplazar(int boton) {
        switch (boton) {
            case 6:
                this.xsql = "SELECT MIN(Id) FROM f_ordenes";
                this.id = this.consultas.traerDato(this.xsql);
                this.consultas.cerrarConexionBd();
                this.txtNoOrden.setText(this.id);
                break;
            case 7:
                if (this.id != null && Integer.parseInt(this.id) > 1) {
                    this.id = String.valueOf(Integer.parseInt(this.id) - 1);
                    this.txtNoOrden.setText(this.id);
                }
                break;
            case 8:
                if (this.id != null) {
                    this.id = String.valueOf(Integer.parseInt(this.id) + 1);
                    this.txtNoOrden.setText(this.id);
                }
                break;
            case 9:
                this.xsql = "SELECT MAX(Id) FROM f_ordenes";
                this.id = this.consultas.traerDato(this.xsql);
                this.consultas.cerrarConexionBd();
                this.txtNoOrden.setText(this.id);
                break;
        }
        buscarOrden();
    }

    private void eliminarFilaGrid() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar El Examen?") == 0) {
            if (!this.xidnrecepcion.equals("0")) {
                this.xsql = "DELETE FROM l_detallerecepcion WHERE Id_Recepcion ='" + this.xidnrecepcion + "'  AND Id_Procedim='" + this.modelo.getValueAt(this.grid.getSelectedRow(), 0) + "'";
                this.consultas.ejecutarSQL(this.xsql);
                this.consultas.cerrarConexionBd();
            }
            this.modelo.removeRow(this.filaGrid);
        }
    }

    private void inicializarDatosInterfazSimedis() {
        if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
            System.out.println("Entra a esta condicion <-------");
            if (!getIdOrdenExterna().equals("0") && Principal.clasefacturacion != null) {
                if (Principal.clasefacturacion.frmFacturac != null) {
                    Principal.clasefacturacion.frmFacturac.dispose();
                }
                Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
                dispose();
            }
        }
    }

    private void validaRecepcionUnificada() {
        if (this.frmPersona.getIdPersona() != null) {
            try {
                this.xsql = "SELECT  l_recepcion.`Id` as IdRecepcion , l_detallerecepcion.`Id_Procedim`, DATE_FORMAT(l_recepcion.`FechaRecep`,'%Y-%m-%d')  FROM `l_recepcion`\nINNER JOIN `l_detallerecepcion` ON l_recepcion.`Id`=l_detallerecepcion.`Id_Recepcion`\nWHERE l_recepcion.`Id_Paciente`='" + this.frmPersona.getIdPersona() + "' --  AND date_format(`FechaRecep`,'%Y-%m-%d')='2023-10-02'";
                ResultSet rs = this.consultas.traerRs(this.xsql);
                Throwable th = null;
                try {
                    System.err.println("resultado" + this.xsql);
                    if (rs.next()) {
                        rs.first();
                        if (this.xidnrecepcion == null) {
                            if (rs.getString("IdRecepcion") == null) {
                                this.xidnrecepcion = rs.getString(1);
                                this.xtipog = true;
                                this.JCHAgrupar.setSelected(true);
                                this.JTFIdRecepcion.setText(this.xidnrecepcion);
                                this.JTFFNRecepcion.setEditable(true);
                                this.JTFFNRecepcion.setText(this.xidnrecepcion);
                            }
                        } else if (this.xidnrecepcion.equals(rs.getString("IdRecepcion"))) {
                            this.xidnrecepcion = rs.getString(1);
                            this.xtipog = true;
                            this.JCHAgrupar.setSelected(true);
                            this.JTFIdRecepcion.setText(this.xidnrecepcion);
                            this.JTFFNRecepcion.setEditable(true);
                            this.JTFFNRecepcion.setText(this.xidnrecepcion);
                        }
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
                } finally {
                }
            } catch (SQLException ex) {
                Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void grabar() {
        if (Principal.informacionIps.getNombreIps().equals("E. S. E HOSPITAL SAN JUAN DE DIOS") && Principal.informacionIps.getIdentificacion().equals("890980326")) {
            validaRecepcionUnificada();
            if (!this.xtipog) {
                if (this.xidnrecepcion.equals("0")) {
                    if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && validarDatos() == 1) {
                        this.frmPersona.grabar();
                        grabarCabecera();
                        grabarDetalle();
                        mGrabar_CCitologia();
                        actualizarEstadoRecepOrden();
                        mGrabar_Rechazo();
                        mCrear_Plano();
                        if (getxId_Rechazo() != 0) {
                            this.metodos.mImprimir_Pendiente_Laboratorio(String.valueOf(getxId_Rechazo()));
                        }
                        imprimirSticker();
                        if (getName().equals("xjifrecepcionlab")) {
                            this.xsql = "UPDATE `i_interfaz_xenco_orden` SET EstadoGenoma=1 WHERE  NumeroDocumentoGestion='" + this.Ng + "'";
                            System.out.println("-->" + this.xsql);
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
                            Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
                            dispose();
                        }
                        cargarFichaCovid();
                        return;
                    }
                    return;
                }
                String sql = " UPDATE `l_recepcion` SET `Tipo` = '" + this.xUrgente + "'\n , `peso` = '" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "'\n , `Talla` = '" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "'\n , `PAbdominal` = '" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "'\n , `Imc` = '" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "'\n , `SCorporal` = '" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "'\n , `Observaciones` = '" + this.txtObservaciones.getText() + "'\n WHERE Id='" + this.JTFIdRecepcion.getText() + "'";
                System.out.print("Actualiza  ");
                this.consultas.ejecutarSQL(sql);
                this.consultas.cerrarConexionBd();
                this.metodos.getInterceptor(this.idIngreso, "VALIDACIÓN RECEPCIÓN", "Se valida recepción".concat(" No. ").concat(this.JTFIdRecepcion.getText()), false);
                if (this.xUrgente == 1) {
                    JOptionPane.showInternalMessageDialog(this, "ACTUALIZADA COMO URGENTE", "INFORMACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
                mGrabar_CCitologia();
                return;
            }
            return;
        }
        if (!this.xtipog) {
            if (this.xidnrecepcion.equals("0")) {
                if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && validarDatos() == 1) {
                    this.frmPersona.grabar();
                    grabarCabecera();
                    grabarDetalle();
                    mGrabar_CCitologia();
                    actualizarEstadoRecepOrden();
                    mGrabar_Rechazo();
                    mCrear_Plano();
                    if (!getIdOrdenExterna().equals("0")) {
                        LaboratorioDAO laboratorioDAO = new LaboratorioDAOImpl();
                        if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
                            laboratorioDAO.actualizarDatosRecepcion(getIdOrdenExterna(), Long.valueOf(this.xidnrecepcion), this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                        } else if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS")) {
                            laboratorioDAO.actualizarDatosRecepcionSifas(getIdOrdenExterna(), Long.valueOf(this.xidnrecepcion), this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()), Principal.clasefacturacion.getIdCodigoInternoInterface());
                            Principal.clasefacturacion.setIdCodigoInternoInterface("");
                        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                            this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "'  where Id='" + this.txtNoOrden.getText() + "'";
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
                        } else if ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA")) {
                            laboratorioDAO.actualizarDatosRecepcionCNT(getIdOrdenExterna(), "1", "LABOBIOSYSTEM");
                            this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "'  where Id='" + this.txtNoOrden.getText() + "'";
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
                        }
                        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                            laboratorioDAO.actualizarDatosRecepcionCNT(getIdOrdenExterna(), "1", "LABOROCHE");
                            this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "'  where Id='" + this.txtNoOrden.getText() + "'";
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
                        } else if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                            this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "'  where Id='" + this.txtNoOrden.getText() + "'";
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
                            this.xsql = " update `il_interfaz` SET estadoRecepcion = '1' where factura= '" + getIdOrdenExterna() + "'";
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
                        }
                    }
                    if (getxId_Rechazo() != 0) {
                        this.metodos.mImprimir_Pendiente_Laboratorio(String.valueOf(getxId_Rechazo()));
                    }
                    imprimirSticker();
                    if (getName().equals("xjifrecepcionlab") && !Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") && !Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") && ((!Principal.informacionIps.getIdTipoIdentificacion().equals("NI") || !Principal.informacionIps.getIdentificacion().equals("891408918")) && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") && !Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") && !Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA") && !Principal.informacionIps.getNombreIps().equals("UNILAB LABORATORIO CLÍNICO Y CITOLOGICO SAS"))) {
                        if (Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS")) {
                            inicializarDatosInterfazSimedis();
                        } else if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL")) {
                            this.xsql = "UPDATE `i_interfaz_xenco_orden` SET EstadoGenoma=1 WHERE  NumeroDocumentoGestion='" + this.Ng + "'";
                            System.out.println("-->" + this.xsql);
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
                            Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
                            dispose();
                        } else {
                            dispose();
                            if (!Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || !Principal.informacionIps.getIdentificacion().equals("900895500")) {
                                Principal.clasefacturacion.frmFacturac.nuevo();
                                Principal.clasefacturacion.frmFacturac.frmPersona.txtHistoria.requestFocus();
                            }
                        }
                    }
                    cargarFichaCovid();
                    return;
                }
                return;
            }
            String sql2 = " UPDATE `l_recepcion` SET `Tipo` = '" + this.xUrgente + "'\n , `peso` = '" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "'\n , `Talla` = '" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "'\n , `PAbdominal` = '" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "'\n , `Imc` = '" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "'\n , `SCorporal` = '" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "'\n , `Observaciones` = '" + this.txtObservaciones.getText() + "'\n WHERE Id='" + this.JTFIdRecepcion.getText() + "'";
            System.out.print("Actualiza  ");
            this.consultas.ejecutarSQL(sql2);
            this.consultas.cerrarConexionBd();
            if (this.xUrgente == 1) {
                JOptionPane.showInternalMessageDialog(this, "ACTUALIZADA COMO URGENTE", "INFORMACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            mGrabar_CCitologia();
            imprimirSticker();
            return;
        }
        if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && validarDatos() == 1) {
            this.frmPersona.grabar();
            grabarDetalle();
            actualizarEstadoRecepOrden();
            if (!getIdOrdenExterna().equals("0")) {
                if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS")) {
                    LaboratorioDAO laboratorioDAO2 = new LaboratorioDAOImpl();
                    laboratorioDAO2.actualizarDatosRecepcionSifas(getIdOrdenExterna(), Long.valueOf(this.xidnrecepcion), this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()), Principal.clasefacturacion.getIdCodigoInternoInterface());
                    dispose();
                    Principal.clasefacturacion.frmFacturac.dispose();
                    Principal.clasefacturacion.setIdCodigoInternoInterface("");
                    Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
                    imprimirSticker();
                }
                if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                    this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "' where Id='" + this.txtNoOrden.getText() + "'";
                    this.consultas.ejecutarSQL(this.xsql);
                    this.consultas.cerrarConexionBd();
                    imprimirSticker();
                    dispose();
                    Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
                }
                if ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                    LaboratorioDAO laboratorioDAO3 = new LaboratorioDAOImpl();
                    laboratorioDAO3.actualizarDatosRecepcionCNT(getIdOrdenExterna(), "1", "LABOBIOSYSTEM");
                    this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "'  where Id='" + this.txtNoOrden.getText() + "'";
                    this.consultas.ejecutarSQL(this.xsql);
                    this.consultas.cerrarConexionBd();
                    dispose();
                }
                if (Principal.informacionIps.getNombreIps().equals("E.S.E HOSPITAL HECTOR ABAD GOMEZ") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN RAFAEL") || Principal.informacionIps.getNombreIps().equals("E. S. E. HOSPITAL SAN RAFAEL")) {
                    this.xsql = "UPDATE `i_interfaz_xenco_orden` SET EstadoGenoma=1 WHERE  NumeroDocumentoGestion='" + this.Ng + "'";
                    System.out.println("-->" + this.xsql);
                    this.consultas.ejecutarSQL(this.xsql);
                    this.consultas.cerrarConexionBd();
                    Principal.clasefacturacion.cargarPantalla("AgendaSimedis");
                    dispose();
                }
            }
        }
    }

    private void getIdRechazo(String idRecepcion) {
        String sql = "SELECT x.Id FROM l_rechazo x\nWHERE Id_Recepcion ='" + idRecepcion + "' and Estado =1";
        String idRechazo = this.consultas.traerDato(sql);
        System.out.println("" + sql);
        System.out.println("" + idRechazo);
        if (idRechazo != null && !idRechazo.equals("")) {
            setxId_Rechazo(Long.valueOf(idRechazo).longValue());
        } else {
            setxId_Rechazo(0L);
        }
        this.consultas.cerrarConexionBd();
    }

    private void grabarCabecera() {
        System.out.println(getIdOrdenExterna());
        if (getIdOrdenExterna().equals("0") || getIdOrdenExterna().isEmpty() || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
            this.xsql = "INSERT INTO l_recepcion(FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma , brigada ,medicoTratante , Fecha, UsuarioS, envioCorreo  ) VALUES('" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.JTFMedicoTratante.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.envioCorreo + "')";
        } else if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("ZONAMEDICA MR S.A.S")) {
            this.xsql = "INSERT INTO l_recepcion(Id, FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma , brigada , medicoTratante, Fecha, UsuarioS, envioCorreo) VALUES('" + getIdOrdenExterna() + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.JTFMedicoTratante.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.envioCorreo + "')";
        } else if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("ESE HOSPITAL JOSE MARIA CORDOBA"))) {
            this.xsql = "INSERT INTO l_recepcion(FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma, brigada,medicoTratante, Fecha, UsuarioS, envioCorreo) VALUES('" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.JTFMedicoTratante.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.envioCorreo + "')";
        } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
            this.xsql = "INSERT INTO l_recepcion(Id, FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma , brigada , medicoTratante, Fecha, UsuarioS, envioCorreo) VALUES('" + getIdOrdenExterna().substring(2, getIdOrdenExterna().length()) + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.JTFMedicoTratante.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.envioCorreo + "')";
        } else {
            this.xsql = "INSERT INTO l_recepcion(FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma , brigada , medicoTratante,  Fecha, UsuarioS, envioCorreo) VALUES('" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.JTFMedicoTratante.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.envioCorreo + "')";
        }
        System.out.println(this.xsql);
        this.xidnrecepcion = this.consultas.ejecutarSQLId(this.xsql);
        System.out.println("---> " + this.xidnrecepcion);
        consultarConsecutivo();
        this.JTFIdRecepcion.setText(this.xidnrecepcion);
        this.consultas.cerrarConexionBd();
        this.metodos.getInterceptor(this.idIngreso, "GRABAR RECEPCIÓN", "Se graba recepción".concat(" No. ").concat(this.JTFIdRecepcion.getText()), false);
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0118: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:26:0x0118 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0114: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r9 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:24:0x0114 */
    private void consultarConsecutivo() {
        try {
            try {
                String xsql = "SELECT id, consecutivo, date_format(l_recepcion.FechaRecep, '%Y%m%d') as fechaRecepcionConcatenado FROM `l_recepcion` WHERE (`id`=" + this.xidnrecepcion + ");";
                ResultSet rs = this.consultas.traerRs(xsql);
                Throwable th = null;
                System.err.println("resultado" + xsql);
                if (rs.next()) {
                    rs.first();
                    if (!Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                        this.JTFConsecutivo.setText(rs.getString("Id"));
                    } else {
                        String fechaActualConcatenada = this.metodos.formatoAMD_Unida.format(this.metodos.getFechaActual());
                        if (!rs.getString("fechaRecepcionConcatenado").equals(fechaActualConcatenada)) {
                            String formatted = String.format("%03d", Integer.valueOf(rs.getInt("consecutivo")));
                            this.JTFConsecutivo.setText(rs.getString("fechaRecepcionConcatenado") + "" + formatted);
                        } else {
                            this.JTFConsecutivo.setText(rs.getString("consecutivo"));
                        }
                    }
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
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void grabarDetalle() {
        for (int f = 0; f < this.grid.getRowCount(); f++) {
            if (Integer.parseInt(this.modelo.getValueAt(f, 2).toString()) > 0 && this.modelo.getValueAt(f, 3).equals(true)) {
                int xtipo = 0;
                if (this.modelo.getValueAt(f, 5).equals(true)) {
                    xtipo = 1;
                }
                int esRemitido = this.modelo.getValueAt(f, 17).equals(true) ? 1 : 0;
                this.xsql = "INSERT IGNORE INTO l_detallerecepcion(Id_Recepcion, Id_Procedim, Cantidad, PMuestra, RObservacion,codigoEnvioBs1,fechaMuestra,codigoExamenBs1, esRemitido) VALUES('" + this.xidnrecepcion + "','" + this.modelo.getValueAt(f, 0) + "','" + this.modelo.getValueAt(f, 2) + "','" + xtipo + "','" + this.modelo.getValueAt(f, 6) + "','" + this.modelo.getValueAt(f, 10) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.modelo.getValueAt(f, 13) + "','" + esRemitido + "')";
                this.consultas.ejecutarSQL(this.xsql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    private void mGrabar_Rechazo() {
        if (this.metodos.mVerificarDatosTablaTrue(this.grid, 3, "false")) {
            this.xsql = "insert into l_rechazo (`FechaR`, `Id_Usuario`, `Id_Recepcion`,`Id_UsuarioS`    , `UsuarioS` ) Values('" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.JTFIdRecepcion.getText() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            String xid_rechazo = this.consultas.ejecutarSQLId(this.xsql);
            setxId_Rechazo(Long.valueOf(xid_rechazo).longValue());
            this.consultas.cerrarConexionBd();
            for (int f = 0; f < this.grid.getRowCount(); f++) {
                if (this.modelo.getValueAt(f, 3).equals(false)) {
                    this.xsql = "insert into l_rechazo_detalle(`Id_Rechazo`, `Id_Procedimiento`, `Cantidad`, `Id_TipoRechazo`, `Observacion`, `UsuarioS` ) values('" + xid_rechazo + "','" + this.modelo.getValueAt(f, 0) + "','" + this.modelo.getValueAt(f, 2) + "','" + this.modelo.getValueAt(f, 7) + "','" + this.modelo.getValueAt(f, 6) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.consultas.ejecutarSQL(this.xsql);
                    this.consultas.cerrarConexionBd();
                }
            }
        }
    }

    public void imprimir() {
        if (!this.JTFIdRecepcion.getText().isEmpty() || !this.JTFConsecutivo.getText().isEmpty()) {
            getIdRechazo(this.JTFIdRecepcion.getText());
            if (getxId_Rechazo() != 0) {
                Object[] botones = {"Sticker", "Muestras Pendientes", "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n == 0) {
                    imprimirSticker();
                    return;
                } else {
                    if (n == 1) {
                        this.metodos.mImprimir_Pendiente_Laboratorio(String.valueOf(getxId_Rechazo()));
                        return;
                    }
                    return;
                }
            }
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL") || Principal.informacionIps.getNombreIps().equals("CENTRO MÉDICO SERVIFARMA IPS S.A.S.")) {
                Object[] botone = {"Sticker", "Stiker Por Area", "Cerrar"};
                int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botone, "Cerrar");
                if (n2 == 0) {
                    this.imprimirArea = 0;
                    imprimirSticker();
                    return;
                } else {
                    if (n2 == 1) {
                        this.imprimirArea = 1;
                        imprimirSticker();
                        return;
                    }
                    return;
                }
            }
            imprimirSticker();
        }
    }

    private void imprimirSticker() {
        if (!this.xidnrecepcion.equals("0")) {
            if (this.JCHCitologia.isSelected()) {
                detalleImprimirStiker();
            } else {
                detalleImprimirStiker();
            }
        }
        this.xIdProcedimientos = "";
    }

    private void detalleImprimirStiker() {
        for (int i = 0; i < this.grid.getRowCount(); i++) {
            String procedimiento = this.grid.getValueAt(i, 0).toString();
            if (!procedimiento.isEmpty()) {
                if (!this.xIdProcedimientos.isEmpty()) {
                    this.xIdProcedimientos += ",";
                }
                this.xIdProcedimientos += procedimiento;
            }
        }
        System.out.println("xidprocedimientos -> " + this.xIdProcedimientos);
        this.listaStiker = null;
        ConsultasMySQL xct1 = new ConsultasMySQL();
        String[][] parametros = new String[3][2];
        parametros[0][0] = "id";
        parametros[0][1] = this.xidnrecepcion;
        parametros[1][0] = "SUBREPORT_DIR";
        parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[2][0] = "SUBREPORTFIRMA_DIR";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        System.out.println(this.metodos.getRutaRep());
        System.out.println("ips -> " + Principal.informacionIps.getNombreIps());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idRecepcion", Long.valueOf(this.xidnrecepcion));
        if (this.JCHCitologia.isSelected()) {
            this.metodos.mImprimir_CodBarraZebraV2(this.metodos.getInfoStickerV2("RecepcionAutoCitologia", parameters));
        } else {
            this.metodos.mImprimir_CodBarraZebraV2(this.metodos.getInfoStickerV2("RecepcionAuto", parameters));
        }
        String sql = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
        xct1.ejecutarSQL(sql);
        xct1.cerrarConexionBd();
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            imprimirRelacionRecepcion();
        }
    }

    private void imprimirRelacionRecepcion() {
        if (!this.JTFIdRecepcion.getText().isEmpty()) {
            String[][] parametros = new String[1][2];
            parametros[0][0] = "idRecepcion";
            parametros[0][1] = this.xidnrecepcion;
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "F_ListadoProcedimientosFacturados", parametros, "F_ListadoProcedimientosFacturados");
        }
    }

    private void iniciar() {
        cargarPanelPersonas();
        this.frmPersona.panelPersona.setEnabledAt(0, true);
        this.frmPersona.panelPersona.setSelectedIndex(0);
        this.frmPersona.txtHistoria.requestFocus();
    }

    public void nuevo() {
        this.frmPersona.nuevo();
        this.txtNoOrden.setText("");
        this.JTFFSCorporal1.setValue(new Integer(0));
        this.JDF_Fecha.setDate(this.metodos.getFechaActual());
        this.txtProfesional.setText("");
        System.err.println("entro metodo limpiar obsevacion");
        this.txtObservaciones.setText("");
        this.id = "";
        this.xUrgente = 0;
        this.xId_Rechazo = 0L;
        crearGrid();
        this.frmPersona.txtHistoria.requestFocus();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtNoOrden.getText() == null || this.txtNoOrden.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite un Número de Orden / Factura");
        } else if (this.JDF_Fecha.getDate() == null || this.txtProfesional.getText() == null || this.txtProfesional.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite una Orden que contenga datos");
        } else if (this.grid.getRowCount() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione los Exámenes que desea cargar");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private void mCalcularImc() {
        if (this.JTFFSTalla1.getValue() != null && this.JTFFSPeso1.getValue() != null) {
            this.JTFFSIMC1.setValue(Double.valueOf(mTraerValorDatosAntopometricos(this.JTFFSPeso1) / Math.pow(mTraerValorDatosAntopometricos(this.JTFFSTalla1) / 100.0d, 2.0d)));
        }
    }

    private void mCalcularSCorporal() {
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            if (this.JTFFSPeso1.getValue() != null && this.JTFFSTalla1.getValue() != null) {
                double xv1 = (mTraerValorDatosAntopometricos(this.JTFFSTalla1) * mTraerValorDatosAntopometricos(this.JTFFSPeso1)) / 3600.0d;
                double raiz = Math.sqrt(xv1);
                new DecimalFormat("#.00");
                this.JTFFSCorporal1.setValue(Double.valueOf(raiz));
                return;
            }
            return;
        }
        if (this.JTFFSPeso1.getValue() != null) {
            double xv12 = (mTraerValorDatosAntopometricos(this.JTFFSPeso1) * 4.0d) + 7.0d;
            double xv2 = mTraerValorDatosAntopometricos(this.JTFFSPeso1) + 90.0d;
            this.JTFFSCorporal1.setValue(Double.valueOf(xv12 / xv2));
        }
    }

    private double mTraerValorDatosAntopometricos(JFormattedTextField xjtf) {
        double xvalor;
        if (xjtf.getText().isEmpty()) {
            xvalor = 0.0d;
        } else {
            xvalor = Double.valueOf(xjtf.getText().replaceAll(",", ".")).doubleValue();
        }
        return xvalor;
    }

    private void mImprimirStikerProd(int cantidad, String xIdProcedimiento) {
        StickerPrintDto stickerPrintDto;
        ConsultasMySQL xct1 = new ConsultasMySQL();
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("idRecepcion", Long.valueOf(this.xidnrecepcion));
        if (this.JCHCitologia.isSelected()) {
            parameters.put("idProcedimiento", Long.valueOf(xIdProcedimiento));
            stickerPrintDto = this.metodos.getInfoStickerV2("RecepcionAutoProcedimientoCitologia", parameters);
        } else {
            parameters.put("idProcedimiento", Long.valueOf(xIdProcedimiento));
            stickerPrintDto = this.metodos.getInfoStickerV2("RecepcionAutoProcedimiento", parameters);
        }
        this.metodos.mImprimir_CodBarraZebraV2(stickerPrintDto);
        String sql = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
        xct1.ejecutarSQL(sql);
        xct1.cerrarConexionBd();
    }

    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showInternalMessageDialog(this, "Valor Digitado Invalido", "ERROR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r3v108, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.JBTConsultarHC = new JButton();
        this.JTFFSTalla1 = new JFormattedTextField();
        this.JTFFSPeso1 = new JFormattedTextField();
        this.JTFFSIMC1 = new JFormattedTextField();
        this.JTFFSPerimetroAbd1 = new JFormattedTextField();
        this.JTFFSCorporal1 = new JFormattedTextField();
        this.JDF_Fecha_Toma = new JDateChooser();
        this.JCHCitologia = new JCheckBox();
        this.JBTEventoAdverso1 = new JButton();
        this.JCHUrgente = new JCheckBox();
        this.JBTCargarPDF = new JButton();
        this.JCHBrigada = new JCheckBox();
        this.JTFMedicoTratante = new JTextField();
        this.txtProfesional = new JTextField();
        this.JDF_Fecha = new JDateChooser();
        this.txtNoOrden = new JTextField();
        this.JCHCorreo = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.grid = new JTable();
        this.JBTCerrar = new JButton();
        this.JCHAgrupar = new JCheckBox();
        this.JTFFNRecepcion = new JFormattedTextField();
        this.JBTCerrar1 = new JButton();
        this.JBTCerrar2 = new JButton();
        this.JBTCerrar3 = new JButton();
        this.JBTVisualizacionCOvid = new JButton();
        this.JTFIdRecepcion = new JTextField();
        this.JTFConsecutivo = new JTextField();
        this.JBT_InfoTrazabilidad = new JButton();
        setClosable(true);
        setTitle("RECEPCIÓN AUTOMATICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(982, 577));
        setMinimumSize(new Dimension(982, 577));
        setName("Recepcion");
        setNormalBounds(new Rectangle(0, 0, 106, 0));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.RecepcionAuto.5
            public void internalFrameActivated(InternalFrameEvent evt) {
                RecepcionAuto.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                RecepcionAuto.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                RecepcionAuto.this.formInternalFrameClosing(evt);
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
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.panelPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.panelPersona.setMaximumSize(new Dimension(1000, 160));
        this.panelPersona.setMinimumSize(new Dimension(1000, 160));
        this.panelPersona.setPreferredSize(new Dimension(1000, 160));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 146, 32767));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA ORDEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.setVerticalScrollBarPolicy(21);
        this.txtObservaciones.setBorder((Border) null);
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.JBTConsultarHC.setFont(new Font("Arial", 1, 12));
        this.JBTConsultarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBTConsultarHC.setText("<html><P ALIGN=center>Consultar Ordenes Médicas");
        this.JBTConsultarHC.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.6
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBTConsultarHCActionPerformed(evt);
            }
        });
        this.JTFFSTalla1.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFSTalla1.setHorizontalAlignment(4);
        this.JTFFSTalla1.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.7
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JTFFSTalla1ActionPerformed(evt);
            }
        });
        this.JTFFSTalla1.addFocusListener(new FocusAdapter() { // from class: Laboratorio.RecepcionAuto.8
            public void focusLost(FocusEvent evt) {
                RecepcionAuto.this.JTFFSTalla1FocusLost(evt);
            }
        });
        this.JTFFSTalla1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAuto.9
            public void keyPressed(KeyEvent evt) {
                RecepcionAuto.this.JTFFSTalla1KeyPressed(evt);
            }
        });
        this.JTFFSPeso1.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFSPeso1.setHorizontalAlignment(4);
        this.JTFFSPeso1.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso1.addFocusListener(new FocusAdapter() { // from class: Laboratorio.RecepcionAuto.10
            public void focusLost(FocusEvent evt) {
                RecepcionAuto.this.JTFFSPeso1FocusLost(evt);
            }
        });
        this.JTFFSPeso1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.11
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JTFFSPeso1ActionPerformed(evt);
            }
        });
        this.JTFFSPeso1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAuto.12
            public void keyPressed(KeyEvent evt) {
                RecepcionAuto.this.JTFFSPeso1KeyPressed(evt);
            }
        });
        this.JTFFSIMC1.setEditable(false);
        this.JTFFSIMC1.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSIMC1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFSIMC1.setHorizontalAlignment(4);
        this.JTFFSIMC1.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroAbd1.setBorder(BorderFactory.createTitledBorder((Border) null, "P. Abdominal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPerimetroAbd1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFSPerimetroAbd1.setHorizontalAlignment(4);
        this.JTFFSPerimetroAbd1.setFont(new Font("Arial", 1, 12));
        this.JTFFSPerimetroAbd1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAuto.13
            public void keyPressed(KeyEvent evt) {
                RecepcionAuto.this.JTFFSPerimetroAbd1KeyPressed(evt);
            }
        });
        this.JTFFSCorporal1.setEditable(false);
        this.JTFFSCorporal1.setBorder(BorderFactory.createTitledBorder((Border) null, "S. Corporal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSCorporal1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFSCorporal1.setHorizontalAlignment(4);
        this.JTFFSCorporal1.setFont(new Font("Arial", 1, 12));
        this.JDF_Fecha_Toma.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Toma", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDF_Fecha_Toma.setDateFormatString("dd/MM/yyyy");
        this.JDF_Fecha_Toma.setFont(new Font("Arial", 1, 12));
        this.JDF_Fecha_Toma.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.RecepcionAuto.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                RecepcionAuto.this.JDF_Fecha_TomaPropertyChange(evt);
            }
        });
        this.JCHCitologia.setFont(new Font("Arial", 1, 12));
        this.JCHCitologia.setText("Es Citología?");
        this.JCHCitologia.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.15
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JCHCitologiaActionPerformed(evt);
            }
        });
        this.JBTEventoAdverso1.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso1.setText("<html><P ALIGN=center>Casos de Seguridad Clinica");
        this.JBTEventoAdverso1.setToolTipText("Evento Adverso");
        this.JBTEventoAdverso1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.16
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBTEventoAdverso1ActionPerformed(evt);
            }
        });
        this.JCHUrgente.setFont(new Font("Arial", 1, 12));
        this.JCHUrgente.setForeground(Color.red);
        this.JCHUrgente.setText("Es Urgente?");
        this.JCHUrgente.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.17
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JCHUrgenteActionPerformed(evt);
            }
        });
        this.JBTCargarPDF.setFont(new Font("Arial", 1, 12));
        this.JBTCargarPDF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTCargarPDF.setText("<html><P ALIGN=center>Cargar Resultados Externos");
        this.JBTCargarPDF.setToolTipText("Evento Adverso");
        this.JBTCargarPDF.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.18
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBTCargarPDFActionPerformed(evt);
            }
        });
        this.JCHBrigada.setFont(new Font("Arial", 1, 12));
        this.JCHBrigada.setText("Es Brigada?");
        this.JCHBrigada.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.19
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JCHBrigadaActionPerformed(evt);
            }
        });
        this.JTFMedicoTratante.setBorder(BorderFactory.createTitledBorder((Border) null, "Medico Tratante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtProfesional.setFont(new Font("Arial", 1, 12));
        this.txtProfesional.setHorizontalAlignment(0);
        this.txtProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Ordena", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtProfesional.setDisabledTextColor(new Color(0, 0, 0));
        this.txtProfesional.setEnabled(false);
        this.JDF_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Recepción", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDF_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JDF_Fecha.setFont(new Font("Arial", 1, 12));
        this.JDF_Fecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.RecepcionAuto.20
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                RecepcionAuto.this.JDF_FechaPropertyChange(evt);
            }
        });
        this.txtNoOrden.setFont(new Font("Arial", 1, 12));
        this.txtNoOrden.setHorizontalAlignment(0);
        this.txtNoOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "N° de Orden / Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoOrden.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.21
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.txtNoOrdenActionPerformed(evt);
            }
        });
        this.txtNoOrden.addFocusListener(new FocusAdapter() { // from class: Laboratorio.RecepcionAuto.22
            public void focusLost(FocusEvent evt) {
                RecepcionAuto.this.txtNoOrdenFocusLost(evt);
            }
        });
        this.JCHCorreo.setFont(new Font("Arial", 1, 12));
        this.JCHCorreo.setText("Envío Correo");
        this.JCHCorreo.setToolTipText("Permite enviar correo al paciente desde la planilla");
        this.JCHCorreo.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.23
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JCHCorreoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtNoOrden, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDF_Fecha, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JDF_Fecha_Toma, -2, 117, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHCitologia).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHUrgente).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBrigada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHCorreo))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 397, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtProfesional, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFMedicoTratante, -2, 277, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSTalla1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPeso1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSIMC1, -2, 81, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFSPerimetroAbd1, -2, 123, -2).addComponent(this.JTFFSCorporal1, -2, 132, -2)).addGap(32, 32, 32).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTEventoAdverso1, -2, 228, -2).addComponent(this.JBTConsultarHC, -2, 228, -2).addComponent(this.JBTCargarPDF, -2, 228, -2))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBTConsultarHC, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEventoAdverso1, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCargarPDF).addGap(5, 5, 5)).addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(58, 58, 58).addComponent(this.jScrollPane1)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 66, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDF_Fecha_Toma, -2, 50, -2).addComponent(this.JDF_Fecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtProfesional, -2, 50, -2).addComponent(this.JTFFSTalla1, -2, 50, -2).addComponent(this.JTFFSPeso1, -2, 50, -2).addComponent(this.JTFFSIMC1, -2, 50, -2).addComponent(this.JTFFSPerimetroAbd1, -2, 50, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JTFMedicoTratante, -2, 50, -2))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txtNoOrden, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTFFSCorporal1, -2, 55, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHCitologia).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHBrigada).addComponent(this.JCHUrgente).addComponent(this.JCHCorreo))).addContainerGap()))));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionAuto.24
            public void mouseClicked(MouseEvent evt) {
                RecepcionAuto.this.gridMouseClicked(evt);
            }
        });
        this.grid.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAuto.25
            public void keyPressed(KeyEvent evt) {
                RecepcionAuto.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.grid);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.26
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JCHAgrupar.setFont(new Font("Arial", 1, 12));
        this.JCHAgrupar.setText("Agrupar?");
        this.JCHAgrupar.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.27
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JCHAgruparActionPerformed(evt);
            }
        });
        this.JTFFNRecepcion.setEditable(false);
        this.JTFFNRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Recepción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNRecepcion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNRecepcion.setHorizontalAlignment(4);
        this.JTFFNRecepcion.setFont(new Font("Arial", 1, 12));
        this.JTFFNRecepcion.addFocusListener(new FocusAdapter() { // from class: Laboratorio.RecepcionAuto.28
            public void focusLost(FocusEvent evt) {
                RecepcionAuto.this.JTFFNRecepcionFocusLost(evt);
            }
        });
        this.JTFFNRecepcion.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.29
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JTFFNRecepcionActionPerformed(evt);
            }
        });
        this.JTFFNRecepcion.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAuto.30
            public void keyPressed(KeyEvent evt) {
                RecepcionAuto.this.JTFFNRecepcionKeyPressed(evt);
            }
        });
        this.JBTCerrar1.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCerrar1.setText("Validado");
        this.JBTCerrar1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.31
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBTCerrar1ActionPerformed(evt);
            }
        });
        this.JBTCerrar2.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.JBTCerrar2.setText("<html><P ALIGN=center>Registro de Citología");
        this.JBTCerrar2.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.32
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBTCerrar2ActionPerformed(evt);
            }
        });
        this.JBTCerrar3.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTCerrar3.setText("Generar");
        this.JBTCerrar3.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.33
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBTCerrar3ActionPerformed(evt);
            }
        });
        this.JBTVisualizacionCOvid.setFont(new Font("Arial", 1, 12));
        this.JBTVisualizacionCOvid.setIcon(new ImageIcon(getClass().getResource("/Imagenes/TXT_24px.png")));
        this.JBTVisualizacionCOvid.setText("<html><P ALIGN=center>Visualización Ficha Covid");
        this.JBTVisualizacionCOvid.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.34
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBTVisualizacionCOvidActionPerformed(evt);
            }
        });
        this.JTFIdRecepcion.setEditable(false);
        this.JTFIdRecepcion.setFont(new Font("Arial", 1, 14));
        this.JTFIdRecepcion.setHorizontalAlignment(0);
        this.JTFIdRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Recepción", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFConsecutivo.setEditable(false);
        this.JTFConsecutivo.setFont(new Font("Arial", 1, 14));
        this.JTFConsecutivo.setHorizontalAlignment(0);
        this.JTFConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBT_InfoTrazabilidad.setFont(new Font("Arial", 1, 14));
        this.JBT_InfoTrazabilidad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/info_FILL0_wght400_GRAD0_opsz24.png")));
        this.JBT_InfoTrazabilidad.setText("Info");
        this.JBT_InfoTrazabilidad.setToolTipText("Información de trazabilidad de ingreso");
        this.JBT_InfoTrazabilidad.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAuto.35
            public void actionPerformed(ActionEvent evt) {
                RecepcionAuto.this.JBT_InfoTrazabilidadActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCHAgrupar).addGap(23, 23, 23).addComponent(this.JTFFNRecepcion, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar1, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar3, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar2, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTVisualizacionCOvid, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTCerrar, -2, 170, -2)).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.panelPersona, -2, 961, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFConsecutivo, -2, 217, -2).addComponent(this.JTFIdRecepcion, -2, 217, -2).addComponent(this.JBT_InfoTrazabilidad, GroupLayout.Alignment.TRAILING)))).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelPersona, -2, 170, -2).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTFIdRecepcion, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFConsecutivo, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JBT_InfoTrazabilidad))).addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 194, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCerrar1, -2, 50, -2).addComponent(this.JBTCerrar3, -2, 50, -2).addComponent(this.JBTCerrar, -2, 50, -2)).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHAgrupar).addComponent(this.JTFFNRecepcion, -2, 50, -2)).addComponent(this.JBTCerrar2, -2, 50, -2).addComponent(this.JBTVisualizacionCOvid, -2, 50, -2)).addGap(17, 17, 17)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -1, -1, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -1, -1, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenFocusLost(FocusEvent evt) {
        this.id = this.txtNoOrden.getText();
        buscarOrden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenActionPerformed(ActionEvent evt) {
        this.JDF_Fecha.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        if (getName().equals("Recepcion")) {
            if (Principal.claselab.xjifagenda == null) {
                Principal.mLimpiarDatosP();
                Principal.claselab.cargarPantalla("Agenda");
                dispose();
            }
            inicializarDatosInterfazSimedis();
            return;
        }
        inicializarDatosInterfazSimedis();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAgruparActionPerformed(ActionEvent evt) {
        if (this.JCHAgrupar.isSelected()) {
            this.JTFFNRecepcion.setEditable(true);
            this.JTFFNRecepcion.requestFocus();
        } else {
            this.JTFFNRecepcion.setEditable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNRecepcionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNRecepcionFocusLost(FocusEvent evt) {
        mBuscarNRecepcion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNRecepcionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFNRecepcion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConsultarHCActionPerformed(ActionEvent evt) {
        if (!this.frmPersona.txtHistoria.getText().isEmpty()) {
            Principal.claselab.cargarPantalla("Consultar Resultado de Exámenes x Usuario", this.frmPersona.txtHistoria.getText(), this.txtNoOrden.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (getName().equals("Recepcion")) {
            if (Principal.claselab.xjifagenda == null) {
                Principal.mLimpiarDatosP();
                Principal.claselab.cargarPantalla("Agenda");
                return;
            }
            return;
        }
        inicializarDatosInterfazSimedis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrar1ActionPerformed(ActionEvent evt) {
        if (!this.xidnrecepcion.equals("0") && !this.xidnrecepcion.isEmpty()) {
            this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "' where Id='" + this.txtNoOrden.getText() + "'";
            this.consultas.ejecutarSQL(this.xsql);
            this.consultas.cerrarConexionBd();
            this.metodos.getInterceptor(this.idIngreso, "VALIDACIÓN RECEPCIÓN", "Se valida recepción".concat(" No. ").concat(this.JTFIdRecepcion.getText()), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrar2ActionPerformed(ActionEvent evt) {
        if (!this.JTFIdRecepcion.getText().isEmpty()) {
            try {
                Principal.clasepyp = new clasePyP(Principal.claselab.frmPrincipal);
                Principal.clasepyp.setXidrecepcion(Long.valueOf(this.JTFIdRecepcion.getText()).longValue());
                Principal.clasepyp.setXid_tipof(Principal.claselab.getXtipo_empresa());
                Principal.clasepyp.setXid_ingreso(this.idIngreso.longValue());
                Principal.clasepyp.cargarPantalla("Toma");
                Principal.clasepyp.frmToma.frmPersona.txtHistoria.setText(this.frmPersona.getHistoria());
                Principal.clasepyp.frmToma.frmPersona.buscar(2);
                Principal.clasepyp.frmToma.setSelected(true);
                dispose();
            } catch (PropertyVetoException e) {
                Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTalla1ActionPerformed(ActionEvent evt) {
        mCalcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTalla1FocusLost(FocusEvent evt) {
        mCalcularImc();
        mCalcularSCorporal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTalla1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFSTalla1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso1ActionPerformed(ActionEvent evt) {
        mCalcularImc();
        mCalcularSCorporal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso1FocusLost(FocusEvent evt) {
        mCalcularImc();
        mCalcularSCorporal();
        this.JTFFSPerimetroAbd1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPeso1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCalcularImc();
            mCalcularSCorporal();
            this.JTFFSPeso1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPerimetroAbd1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getModel().getColumnClass(9).equals(JButton.class) && this.grid.getSelectedColumn() == 9 && this.grid.getSelectedRow() != -1) {
            String m = JOptionPane.showInputDialog((Component) null, "Digite el numero de Stiker(s) a imprimir", "IMPRESION DE STIKER", 1);
            if (!m.isEmpty()) {
                if (isNumeric(m)) {
                    if (Integer.valueOf(m).intValue() > 6) {
                        int n = JOptionPane.showInternalOptionDialog(this, "Esta a punto de imprimir " + m + " stikers esta seguro de querer seguir?", "VERIFICAR", 0, 3, (Icon) null, (Object[]) null, 0);
                        if (n == 0) {
                            mImprimirStikerProd(Integer.valueOf(m).intValue(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                            return;
                        }
                        return;
                    }
                    mImprimirStikerProd(Integer.valueOf(m).intValue(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
                    return;
                }
                return;
            }
            mImprimirStikerProd(1, this.xidProfesional);
            return;
        }
        if (this.grid.getSelectedRow() != -1 && this.grid.getSelectedColumn() == 3) {
            if (Boolean.parseBoolean(this.modelo.getValueAt(this.grid.getSelectedRow(), 3).toString())) {
                this.modelo.setValueAt(1, this.grid.getSelectedRow(), 7);
                return;
            } else {
                JD_TipoRechazo frmCR = new JD_TipoRechazo(null, true, this, 1);
                frmCR.setVisible(true);
                return;
            }
        }
        if (this.grid.getSelectedRow() != -1 && this.grid.getSelectedColumn() == 5 && !this.JTFIdRecepcion.getText().isEmpty()) {
            ActualizaMuestraPendiente(this.grid.getSelectedRow());
            return;
        }
        if (this.grid.getModel().getColumnClass(14).equals(JButton.class) && this.grid.getSelectedColumn() == 14 && this.grid.getSelectedRow() != -1) {
            JDConsentimientoInformado consentimientoInformado = new JDConsentimientoInformado(null, true, this.idIngreso.toString(), this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString(), this, Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
            consentimientoInformado.setLocationRelativeTo(this);
            consentimientoInformado.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDF_FechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrar3ActionPerformed(ActionEvent evt) {
        if (!this.JTFIdRecepcion.getText().isEmpty()) {
            mCrear_Plano();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCitologiaActionPerformed(ActionEvent evt) {
        if (this.JCHCitologia.isSelected()) {
            this.xTipo = "2^Citología";
        } else {
            this.xTipo = "1^General";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDF_Fecha_TomaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdverso1ActionPerformed(ActionEvent evt) {
        if (!this.JTFIdRecepcion.getText().isEmpty()) {
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", String.valueOf(this.idIngreso), 29);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Se debe cargar un registro", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHUrgenteActionPerformed(ActionEvent evt) {
        if (this.JCHUrgente.isSelected()) {
            this.xUrgente = 1;
        } else {
            this.xUrgente = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTVisualizacionCOvidActionPerformed(ActionEvent evt) {
        cargarFichaCovid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCargarPDFActionPerformed(ActionEvent evt) {
        JDCarguePDFResultadosExternos xjd = new JDCarguePDFResultadosExternos(null, true, this.JTFIdRecepcion.getText());
        xjd.setLocationRelativeTo(this);
        xjd.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBrigadaActionPerformed(ActionEvent evt) {
        if (this.JCHBrigada.isSelected()) {
            this.xBrigada = 1;
        } else {
            this.xBrigada = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCorreoActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS")) {
            if (this.JCHCorreo.isSelected()) {
                this.envioCorreo = 1;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Utilidad No Utorizada, contaca a Genoma Empresarial para activarlo", "ALERTA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_InfoTrazabilidadActionPerformed(ActionEvent evt) {
        if (!this.JTFIdRecepcion.getText().isEmpty()) {
            JDHistoricoTrazabilidad trazabilidad = new JDHistoricoTrazabilidad(null, true, this.idIngreso);
            trazabilidad.setLocationRelativeTo(this);
            trazabilidad.setVisible(true);
        }
    }

    public long getxId_Rechazo() {
        return this.xId_Rechazo;
    }

    public void setxId_Rechazo(long xId_Rechazo) {
        this.xId_Rechazo = xId_Rechazo;
    }

    private void mBuscarRecepcionGIIS(String IdOrden) {
        if (this.frmPersona.getIdPersona() != null && Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") && !IdOrden.equals("0")) {
            try {
                this.xsql = "SELECT Id , Id_Paciente FROM l_recepcion WHERE (Id ='" + IdOrden + "')";
                ResultSet rs = this.consultas.traerRs(this.xsql);
                Throwable th = null;
                try {
                    try {
                        if (rs.next()) {
                            rs.first();
                            this.xidnrecepcion = rs.getString(1);
                            this.xtipog = true;
                            this.JCHAgrupar.setSelected(true);
                            this.JTFIdRecepcion.setText(this.xidnrecepcion);
                            this.JTFFNRecepcion.setEditable(true);
                            this.JTFFNRecepcion.setText(this.xidnrecepcion);
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
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscarRecepcionBs1(String IdOrden) {
        if (this.frmPersona.getIdPersona() != null && Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && !IdOrden.equals("0")) {
            try {
                this.xsql = "SELECT\n  `l_recepcion`.`Id`\nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\nWHERE (`ingreso`.`NumeroHcBs1` ='" + IdOrden + "'AND ingreso.`FechaIngreso`='" + this.metodos.formatoAMD1.format(this.metodos.getFechaActual()) + "');";
                ResultSet rs = this.consultas.traerRs(this.xsql);
                Throwable th = null;
                try {
                    try {
                        System.err.println("resultado" + this.xsql);
                        if (rs.next()) {
                            rs.first();
                            this.xidnrecepcion = rs.getString(1);
                            this.xtipog = true;
                            this.JCHAgrupar.setSelected(true);
                            this.JTFIdRecepcion.setText(this.xidnrecepcion);
                            this.JTFFNRecepcion.setEditable(true);
                            this.JTFFNRecepcion.setText(this.xidnrecepcion);
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
                    } finally {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th3;
                }
            } catch (SQLException ex) {
                Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    private void mBuscarNRecepcionSantuario() {
        if (this.frmPersona.getIdPersona() != null) {
            try {
                this.xsql = "SELECT Id as Recepcion  , Id_Paciente   FROM l_recepcion WHERE ( Id_Paciente ='" + this.frmPersona.getIdPersona() + "');";
                System.err.println("xql" + this.xsql);
                ResultSet rs = this.consultas.traerRs(this.xsql);
                Throwable th = null;
                try {
                    if (rs.next()) {
                        rs.first();
                        this.xidnrecepcion = rs.getString(1);
                        this.xtipog = true;
                        this.JCHAgrupar.setSelected(true);
                        this.JTFIdRecepcion.setText(this.xidnrecepcion);
                        this.JTFFNRecepcion.setEditable(true);
                        this.JTFFNRecepcion.setText(this.xidnrecepcion);
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
                Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuarios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x01a1: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:34:0x01a1 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x01a5: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r12 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:36:0x01a5 */
    private void mBuscarNRecepcion() {
        if (this.frmPersona.getIdPersona() != null) {
            if (!this.JTFFNRecepcion.getText().isEmpty()) {
                try {
                    try {
                        this.xsql = "SELECT Id , Id_Paciente, consecutivo, date_format(l_recepcion.FechaRecep, '%Y%m%d') as fechaRecepcionConcatenado  FROM l_recepcion WHERE (Id ='" + this.JTFFNRecepcion.getText() + "' AND Id_Paciente ='" + this.frmPersona.getIdPersona() + "')";
                        ResultSet rs = this.consultas.traerRs(this.xsql);
                        Throwable th = null;
                        if (rs.next()) {
                            rs.first();
                            this.xidnrecepcion = rs.getString(1);
                            this.xtipog = true;
                            if (getName().equals("Recepcion")) {
                                this.JTFIdRecepcion.setText(this.xidnrecepcion);
                                if (!Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                                    this.JTFConsecutivo.setText(this.xidnrecepcion);
                                } else {
                                    String fechaActualConcatenada = this.metodos.formatoAMD_Unida.format(this.metodos.getFechaActual());
                                    if (!rs.getString("fechaRecepcionConcatenado").equals(fechaActualConcatenada)) {
                                        String formatted = String.format("%03d", Integer.valueOf(rs.getInt("consecutivo")));
                                        this.JTFConsecutivo.setText(rs.getString("fechaRecepcionConcatenado") + "" + formatted);
                                    } else {
                                        this.JTFConsecutivo.setText(rs.getString("consecutivo"));
                                    }
                                }
                            }
                            if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                                this.JTFIdRecepcion.setText(this.xidnrecepcion);
                                this.JTFConsecutivo.setText(this.xidnrecepcion);
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "N° de recepción no corresponde a este usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTFFNRecepcion.setText("");
                            this.JTFConsecutivo.setText("");
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
                        return;
                    } finally {
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(RecepcionAuto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "El N° Recepcion no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuarios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGrabarInterfaz_Fix() {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.xsql = "CALL Insertar_Recepcion_Interfaz_Annar(" + this.JTFIdRecepcion.getText() + ")";
            this.consultas.ejecutarSQL(this.xsql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void mCrear_Plano() {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            mGrabarInterfaz_Fix();
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            mCargar_Interfaz();
        } else if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            crear_ArchivosPlanos xc = new crear_ArchivosPlanos();
            xc.mCrear_Planos(this.metodos.mRutaSoporte("Infinity"), this.xidnrecepcion, this.xTipo);
        }
    }

    private void mCargar_Interfaz() {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            this.xsql = "INSERT INTO l_orden_analizador(Analizador,`Id_Orden`, `Id_Historia`, `Id_Examen`, `Id_Sexo`, `Nombres`, `Apellidos`, `Estado`, `FNacimiento`, `FOrden`)\nSELECT  l_tipo_equipos.`Nbre`, IF(l_protocoloxprocedimiento.`NAdicional`='', `l_recepcion`.`Id`, CONCAT(`l_recepcion`.`Id`,l_protocoloxprocedimiento.`NAdicional`)) AS Id , `g_persona`.`NoDocumento` , `l_protocolos`.`Abreviatura` ,  IF(`g_persona`.`Id_Sexo`='F', 1, 2)   , `g_persona`.`Nombre1` , `g_persona`.`Nombre2` , 0 , `g_persona`.`FechaNac`, DATE_FORMAT(l_recepcion.`FechaRecep`,'%Y-%m-%d')\nFROM `l_detallerecepcion` INNER JOIN   `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)  INNER JOIN   `g_procedimiento`   ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN   `l_procedimiento_equipo`  ON (`l_procedimiento_equipo`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nINNER JOIN   `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) INNER JOIN   `l_protocolos`  ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`) INNER JOIN   `g_persona`  ON (`g_persona`.`Id` = `l_recepcion`.`Id_Paciente`) INNER JOIN   `l_tipo_equipos`  ON (`l_tipo_equipos`.`Id` = `l_procedimiento_equipo`.`Id_Equipo`) \nWHERE (`l_recepcion`.`Id` ='" + this.JTFIdRecepcion.getText() + "'  AND `l_protocolos`.`Abreviatura` <>''  AND `l_procedimiento_equipo`.`Id_Equipo` in(4,5,6) and l_protocolos.Exportable=1)\nGROUP BY `l_protocolos`.`Abreviatura`";
            this.consultas.ejecutarSQL(this.xsql);
            this.consultas.cerrarConexionBd();
        }
    }
}
