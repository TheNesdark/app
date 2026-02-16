package Laboratorio;

import Acceso.Principal;
import Facturacion.JIFAgendaTaquilla;
import General.Anular;
import General.Persona;
import PyP.clasePyP;
import Utilidades.ConsultasMySQL;
import Utilidades.ConsultasSqlServer;
import Utilidades.Metodos;
import com.genoma.plus.controller.facturacion.JDIngresoInformacionPruebaCovid;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.genoma.plus.controller.laboratorio.JDCarguePDFResultadosExternos;
import com.genoma.plus.controller.sgc.JDConsentimientoInformado;
import com.genoma.plus.dao.impl.integracion_simedis.IntegracionExternaBienestarDAOImpl;
import com.genoma.plus.dao.impl.integracion_simedis.LaboratorioBienestarDAOImpl;
import com.genoma.plus.dao.integracion_simedis.IntegracionExternaBienestarDAO;
import com.genoma.plus.dao.integracion_simedis.LaboratorioBienestarDAO;
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
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
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

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/RecepcionAutoBienestarSalud.class */
public class RecepcionAutoBienestarSalud extends JInternalFrame {
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
    private Long idIngreso;
    private Long IdOrdenGenomaGIIS;
    private Boolean filtroProcedimientoCovid;
    private String codigoCups;
    private IntegracionExternaBienestarDAO integracionExternaDAO;
    private List<StikerProjection> listaStiker;
    private final RecepcionService recepcionService;
    private String idMedicoBS1;
    private String idConsultorioMedicoBS1;
    private JButton JBTCargarPDF;
    private JButton JBTCerrar;
    private JButton JBTCerrar1;
    private JButton JBTCerrar2;
    private JButton JBTCerrar3;
    private JButton JBTConsultarHC;
    private JButton JBTEventoAdverso1;
    private JButton JBTVisualizacionCOvid;
    private JCheckBox JCHAgrupar;
    private JCheckBox JCHBrigada;
    private JCheckBox JCHCitologia;
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
    public JTable grid;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelPersona;
    public JTextField txtNoOrden;
    private JEditorPane txtObservaciones;
    private JTextField txtProfesional;

    public RecepcionAutoBienestarSalud(String xnombre, int xlproc, String idOrdenExterna) {
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
        this.filtroProcedimientoCovid = false;
        this.codigoCups = "";
        this.recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
        this.idMedicoBS1 = "";
        this.idConsultorioMedicoBS1 = "";
        initComponents();
        springStart();
        setName(xnombre);
        this.metodos = new Metodos(false);
        this.xlproc = xlproc;
        setIdOrdenExterna(idOrdenExterna);
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.JCHBrigada.setText("Llamar?");
        }
        if (!Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
            this.JTFConsecutivo.setVisible(false);
        }
        iniciar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.1
            public void mouseClicked(MouseEvent e) {
                RecepcionAutoBienestarSalud.this.filaGrid = RecepcionAutoBienestarSalud.this.grid.rowAtPoint(e.getPoint());
            }
        });
        this.idMedicoBS1 = ValidarIdMedicoBS1(Principal.usuarioSistemaDTO.getIdUsuarioBs1());
        this.idConsultorioMedicoBS1 = RecuperarConsultorioMedicoLogueadoBS1(Principal.usuarioSistemaDTO.getIdUsuarioBs1());
    }

    public RecepcionAutoBienestarSalud(String xnombre, int xlproc, String idOrdenExterna, Long idOrdenGenomaGIIS, String Obsevacion) {
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
        this.filtroProcedimientoCovid = false;
        this.codigoCups = "";
        this.recepcionService = (RecepcionService) Principal.contexto.getBean(RecepcionService.class);
        this.idMedicoBS1 = "";
        this.idConsultorioMedicoBS1 = "";
        initComponents();
        springStart();
        setName(xnombre);
        this.metodos = new Metodos(false);
        this.xlproc = xlproc;
        setIdOrdenExterna(idOrdenExterna);
        if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
            this.JCHBrigada.setText("Llamar?");
        }
        if (!Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
            this.JTFConsecutivo.setVisible(false);
        }
        this.IdOrdenGenomaGIIS = idOrdenGenomaGIIS;
        this.txtNoOrden.setText(Long.toString(this.IdOrdenGenomaGIIS.longValue()));
        this.txtObservaciones.setText(Obsevacion);
        iniciar();
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.2
            public void mouseClicked(MouseEvent e) {
                RecepcionAutoBienestarSalud.this.filaGrid = RecepcionAutoBienestarSalud.this.grid.rowAtPoint(e.getPoint());
            }
        });
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            mBuscarRecepcionGIIS(idOrdenExterna);
        }
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            System.out.println("buequeda Recepcion :");
            mBuscarRecepcionBs1(idOrdenExterna);
        }
        buscarOrden();
        System.out.println("id orden Recepcion : " + idOrdenExterna.substring(2, idOrdenExterna.length()));
    }

    private void springStart() {
        this.integracionExternaDAO = (IntegracionExternaBienestarDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("integracionExternaBienestarDAOImpl");
    }

    private void actualizarEstadoRecepOrden() {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
            this.xsql = "update f_ordenes set EstadoRecep=2, Id_OrdenRecep='" + this.xidnrecepcion + "' where Id='" + this.txtNoOrden.getText() + "'";
        } else {
            this.xsql = "update f_ordenes set EstadoRecep=1, Id_OrdenRecep='" + this.xidnrecepcion + "' where Id='" + this.txtNoOrden.getText() + "'";
        }
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
        this.metodos.marcarEstado(1);
        this.metodos.getInterceptor(Long.valueOf(Principal.claselab.getXid_ingreso()), "ANULAR RECEPCIÓN", "Se anula recepción".concat(" No. ").concat(this.JTFIdRecepcion.getText()), false);
        this.metodos.mostrarMensaje("Toma de Muestra Anulada");
    }

    public void buscar() {
        BuscarOrden frm = new BuscarOrden(null, true, this.frmPersona.getIdPersona(), this, "Recepcion");
        frm.setVisible(true);
    }

    public void buscarOrden() {
        String idPaciente = "0";
        crearGrid();
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
            this.xsql = "SELECT l_codigoprouni.Id_CodProcedUnif, g_procedimiento.Nbre, f_itemordenesproced.Cantidad, f_ordenes.Id, f_tipoprocedimiento.Id, \nf_ordenes.FechaOrden, profesional.NProfesional, profesional.Id_Persona, ingreso.Id_Usuario, f_ordenes.Id_Especialidad, ingreso.Id_EmpresaContxConv, f_ordenes.Id_OrdenRecep, g_procedimiento.Oportunidad, f_ordenes.LProcesamiento \n,IF((SELECT  `h_itemordenesproced`.`Descripcion` FROM `h_itemordenesproced` WHERE (h_itemordenesproced.`Id_Orden_Fac` =f_ordenes.Id AND h_itemordenesproced.`Estado` =0 AND h_itemordenesproced.`Id_Procedimiento`=f_itemordenesproced.`Id_Procedimiento`) GROUP BY f_ordenes.Id) IS NULL, '',(SELECT `h_itemordenesproced`.`Descripcion` , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento \nFROM `h_itemordenesproced` \nWHERE (h_itemordenesproced.`Id_Orden_Fac`=f_ordenes.Id  AND h_itemordenesproced.`Estado` =0 AND h_itemordenesproced.`Id_Procedimiento`=f_itemordenesproced.`Id_Procedimiento`) GROUP BY f_ordenes.Id)) AS Observacion, ingreso.Id_TipoAtencion, `l_tipo_tubo`.`Nbre` AS Tubo, IF(l_recepcion.`Observaciones` IS NULL, ingreso.`Observacion`, l_recepcion.`Observaciones`) DetObservacionC, IFNULL(l_detallerecepcion.`PMuestra`, 0) AS `PMuestra`,  ingreso.Id AS idIngreso, f_itemordenesproced.`codigoEnvioBs1`, f_itemordenesproced.`NAutorizacion` , ingreso.`NoAutorizacion` , codigoEncabezadoOrdenBs1, IFNULL(CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0)),'0') Consecutivo\n FROM f_ordenes INNER JOIN f_itemordenesproced ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id) INNER JOIN l_codigoprouni ON (f_itemordenesproced.Id_Procedimiento = l_codigoprouni.`Id_Procedimiento`) INNER JOIN g_procedimiento ON (l_codigoprouni.Id_CodProcedUnif = g_procedimiento.Id) INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) INNER JOIN profesional ON (profesional.Id_Persona = f_ordenes.Id_Profesional) INNER JOIN ingreso ON (f_ordenes.Id_Ingreso = ingreso.Id) LEFT JOIN `l_tipo_tubo` ON (l_tipo_tubo.`Id` = g_procedimiento.`Id_Tubo`)  \nleft JOIN `l_recepcion` ON (l_recepcion.`Id` = f_ordenes.Id_OrdenRecep)  \nLEFT JOIN `l_detallerecepcion`\n   ON (l_detallerecepcion.`Id_Recepcion`= f_ordenes.Id_OrdenRecep) AND (l_detallerecepcion.`Id_Procedim`=l_codigoprouni.Id_CodProcedUnif)\n-- LEFT JOIN `l_recepcion`    ON (`l_recepcion`.`Id`= l_detallerecepcion.`Id_Recepcion`)\n  left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \nWHERE (f_ordenes.Id ='" + this.txtNoOrden.getText() + "' AND l_codigoprouni.Estado=1) ORDER BY g_procedimiento.Nbre ASC";
        } else {
            this.xsql = "SELECT l_codigoprouni.Id_CodProcedUnif, g_procedimiento.Nbre, f_itemordenesproced.Cantidad, f_ordenes.Id, f_tipoprocedimiento.Id,   \n f_ordenes.FechaOrden, profesional.NProfesional, profesional.Id_Persona, ingreso.Id_Usuario, f_ordenes.Id_Especialidad, ingreso.Id_EmpresaContxConv, f_ordenes.Id_OrdenRecep, g_procedimiento.Oportunidad, f_ordenes.LProcesamiento   \n ,IF((SELECT  `h_itemordenesproced`.`Descripcion` FROM `h_itemordenesproced` WHERE (h_itemordenesproced.`Id_Orden_Fac` =f_ordenes.Id AND h_itemordenesproced.`Estado` =0 AND h_itemordenesproced.`Id_Procedimiento`=f_itemordenesproced.`Id_Procedimiento`) GROUP BY f_ordenes.Id) IS NULL, '',(SELECT `h_itemordenesproced`.`Descripcion`   \n FROM `h_itemordenesproced` WHERE (h_itemordenesproced.`Id_Orden_Fac` =f_ordenes.Id  AND h_itemordenesproced.`Estado` =0 AND h_itemordenesproced.`Id_Procedimiento`=f_itemordenesproced.`Id_Procedimiento`) GROUP BY f_ordenes.Id)) AS Observacion  \n , ingreso.Id_TipoAtencion, `l_tipo_tubo`.`Nbre` AS Tubo, IFNULL(d.Det,'') DetObservacionC, IFNULL(l_detallerecepcion.`PMuestra`, 0) AS `PMuestra`, ingreso.Id AS idIngreso  \n , f_itemordenesproced.`codigoEnvioBs1` , f_itemordenesproced.`NAutorizacion` , ingreso.`NoAutorizacion` , codigoEncabezadoOrdenBs1, IFNULL(CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0)),'0') Consecutivo , if(f.Id_Procedimiento is null, 0, 1) aplicaConsentimiento\n FROM f_ordenes   \n INNER JOIN f_itemordenesproced   \n     ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   \n INNER JOIN l_codigoprouni   \n     ON (f_itemordenesproced.Id_Procedimiento = l_codigoprouni.`Id_Procedimiento`)   \n INNER JOIN g_procedimiento   \n     ON (l_codigoprouni.Id_CodProcedUnif = g_procedimiento.Id)   \n INNER JOIN f_tipoprocedimiento   \n     ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)   \n INNER JOIN profesional   \n     ON (profesional.Id_Persona = f_ordenes.Id_Profesional)   \n INNER JOIN ingreso   \n     ON (f_ordenes.Id_Ingreso = ingreso.Id)   \n LEFT JOIN `l_tipo_tubo`   \n     ON (l_tipo_tubo.`Id` = g_procedimiento.`Id_Tubo`)   \n LEFT JOIN (SELECT  \n     GROUP_CONCAT(`h_itemordenesproced`.`Descripcion` SEPARATOR',') Det, `h_ordenes`.`IdOrdenFact`  \n FROM  \n      `h_itemordenesproced`  \n     INNER JOIN  `h_ordenes`   \n         ON (`h_itemordenesproced`.`Id_HOrdenes` = `h_ordenes`.`Id`)  \n WHERE (`h_itemordenesproced`.`Descripcion`<>'')  GROUP BY `h_ordenes`.`Id` ) d   \n    ON d.IdOrdenFact=f_ordenes.Id   \n LEFT JOIN `l_detallerecepcion`  \n    ON (l_detallerecepcion.`Id_Recepcion`= f_ordenes.Id_OrdenRecep) AND (l_detallerecepcion.`Id_Procedim`=l_codigoprouni.Id_CodProcedUnif)  \nLEFT JOIN `l_recepcion`\n    ON (`l_recepcion`.`Id`= l_detallerecepcion.`Id_Recepcion`)\n  left join ( select g_procedimientoxconsentimiento.Id_Procedimiento from g_procedimientoxconsentimiento \n \twhere g_procedimientoxconsentimiento.Estado =1 group by g_procedimientoxconsentimiento.Id_Procedimiento) f\n on (f.Id_Procedimiento=g_procedimiento.Id) \n WHERE (f_ordenes.Id ='" + this.txtNoOrden.getText() + "' AND l_codigoprouni.Estado=1) ORDER BY g_procedimiento.Nbre ASC";
        }
        System.out.println(this.xsql);
        ResultSet rs = this.consultas.traerRs(this.xsql);
        try {
            this.metodos.mEstablecerTextEditor(this.grid, 1);
            this.metodos.mEstablecerTextEditor(this.grid, 6);
            if (rs.next()) {
                rs.first();
                this.xlproc = rs.getInt("LProcesamiento");
                this.xIdTipoAtencion = rs.getInt("Id_TipoAtencion");
                this.txtObservaciones.setText(rs.getString("DetObservacionC"));
                this.idIngreso = Long.valueOf(rs.getLong("idIngreso"));
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
                    } else {
                        this.modelo.setValueAt(new JButton(""), this.filaGrid, 14);
                    }
                    this.JDF_Fecha.setDate(this.metodos.getFechaActual());
                    this.JDF_Fecha_Toma.setDate(this.metodos.getFechaActual());
                    this.txtProfesional.setText(rs.getString("NProfesional"));
                    this.xidProfesional = rs.getString("Id_Persona");
                    this.xidEspecialidad = rs.getString("Id_Especialidad");
                    this.xidempresacont = rs.getString("Id_EmpresaContxConv");
                    idPaciente = rs.getString("Id_Usuario");
                    if (rs.getLong(12) != 0) {
                        this.JTFIdRecepcion.setText(rs.getString("Id_OrdenRecep"));
                        if (Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                            this.JTFConsecutivo.setText(rs.getString("Consecutivo"));
                        } else {
                            this.JTFConsecutivo.setText(rs.getString("Id_OrdenRecep"));
                        }
                        this.xidnrecepcion = rs.getString("Id_OrdenRecep");
                    }
                    if (rs.getString("Id_CodProcedUnif").equals("898001") && !this.JCHCitologia.isSelected()) {
                        this.JCHCitologia.setSelected(true);
                        this.xTipo = "2^Citología";
                    }
                    if (rs.getString("Id_CodProcedUnif").equals("892901") && !this.JCHCitologia.isSelected()) {
                        this.JCHCitologia.setSelected(true);
                        this.xTipo = "2^Citología";
                    }
                    if (rs.getString("Id_CodProcedUnif").equals("906270") || rs.getString("Id_CodProcedUnif").equals("906340") || rs.getString("Id_CodProcedUnif").equals("1900000") || rs.getString("Id_CodProcedUnif").equals("908856") || rs.getString("Id_CodProcedUnif").equals("10027") || rs.getString("Id_CodProcedUnif").equals("30025")) {
                        this.filtroProcedimientoCovid = true;
                        this.codigoCups = rs.getString("Id_CodProcedUnif");
                    }
                    this.modelo.setValueAt(rs.getString("codigoEnvioBs1"), this.filaGrid, 10);
                    this.modelo.setValueAt(rs.getString("NAutorizacion"), this.filaGrid, 11);
                    this.modelo.setValueAt(rs.getString("NoAutorizacion"), this.filaGrid, 12);
                    this.modelo.setValueAt(rs.getString("codigoEncabezadoOrdenBs1"), this.filaGrid, 13);
                    this.filaGrid++;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            this.frmPersona.setIdPersona(idPaciente);
            this.frmPersona.buscar(1);
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public String getIdOrdenExterna() {
        return this.idOrdenExterna;
    }

    public void setIdOrdenExterna(String idOrdenExterna) {
        this.idOrdenExterna = idOrdenExterna;
    }

    private String mGenerar_CCitologia() {
        String xNoAtencion = null;
        String sql = "SELECT IF( MAX(`Id_Consecutivo`) IS NULL, 1, (MAX(`Id_Consecutivo`)+1)) AS NConsecutivo FROM `l_recepcion_citologia` WHERE (`Ano` ='" + this.metodos.formatoANO.format(this.JDF_Fecha.getDate()) + "' AND `Estado` =1)";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xNoAtencion = xrs.getString("NConsecutivo");
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xNoAtencion;
    }

    private void mGrabar_CCitologia() {
        if (this.JCHCitologia.isSelected()) {
            try {
                ConsultasMySQL xct = new ConsultasMySQL();
                String sql = "SELECT\n    `Id_Recepcion`\n    , `Ano`\n    , `Id_Consecutivo`\n    , `Estado`\nFROM\n    `l_recepcion_citologia`\nWHERE (`Id_Recepcion` ='" + this.xidnrecepcion + "'\n    AND `Estado` =1);";
                ResultSet xrs = xct.traerRs(sql);
                if (!xrs.next()) {
                    this.xsql = "insert into l_recepcion_citologia(`Id_Recepcion` , `Ano` , `Id_Consecutivo` , `Estado` , `Id_UsuarioS`) values ('" + this.xidnrecepcion + "','" + this.metodos.formatoANO.format(this.JDF_Fecha.getDate()) + "','" + mGenerar_CCitologia() + "','1','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                    this.consultas.ejecutarSQL(this.xsql);
                    this.consultas.cerrarConexionBd();
                }
                xrs.close();
                xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
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
        if (this.filtroProcedimientoCovid.booleanValue()) {
            JDIngresoInformacionPruebaCovid jd = new JDIngresoInformacionPruebaCovid(null, true, this.idIngreso, this.codigoCups);
            jd.setLocationRelativeTo(this);
            jd.setVisible(true);
        }
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Examen", "Cantidad", "Realizar", "Días de Entrega", "Pendiente(Muestra)", "Observación", "Id_Rechazo", "Tubo", "Stiker", "CodigoBs1", "CodigoExamenbs1", "NautoIngreso", "CodigoCabezeraOrdenBs1", "Consentimiento Informado"}) { // from class: Laboratorio.RecepcionAutoBienestarSalud.3
            Class[] types = {String.class, String.class, Integer.class, Boolean.class, String.class, Boolean.class, String.class, Integer.class, String.class, JButton.class, String.class, String.class, String.class, String.class, JButton.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        this.grid.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Laboratorio.RecepcionAutoBienestarSalud.4
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.grid.setModel(this.modelo);
        JTable jTable = this.grid;
        JTable jTable2 = this.grid;
        jTable.setAutoResizeMode(0);
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
        this.filaGrid = 0;
    }

    public void desplazar(int boton) {
        if (boton == 6) {
            this.xsql = "SELECT MIN(Id) FROM f_ordenes";
            this.id = this.consultas.traerDato(this.xsql);
            this.consultas.cerrarConexionBd();
            this.txtNoOrden.setText(this.id);
        } else if (boton == 7) {
            if (this.id != null && Integer.parseInt(this.id) > 1) {
                this.id = String.valueOf(Integer.parseInt(this.id) - 1);
                this.txtNoOrden.setText(this.id);
            }
        } else if (boton == 8) {
            if (this.id != null) {
                this.id = String.valueOf(Integer.parseInt(this.id) + 1);
                this.txtNoOrden.setText(this.id);
            }
        } else if (boton == 9) {
            this.xsql = "SELECT MAX(Id) FROM f_ordenes";
            this.id = this.consultas.traerDato(this.xsql);
            this.consultas.cerrarConexionBd();
            this.txtNoOrden.setText(this.id);
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
        if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
            System.out.println("Entra a esta condicion <-------");
            if (!getIdOrdenExterna().equals("0") && Principal.clasefacturacion != null) {
                if (Principal.clasefacturacion.frmFacturac != null) {
                    Principal.clasefacturacion.frmFacturac.dispose();
                }
                Principal.clasefacturacion.cargarPantalla("AgendaSimedisBienestar");
                dispose();
            }
        }
    }

    public void grabar() {
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
                        LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
                        if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS")) {
                            laboratorioDAO.actualizarDatosRecepcion(getIdOrdenExterna(), Long.valueOf(this.xidnrecepcion), this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                        } else if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                            laboratorioDAO.actualizarDatosRecepcionSifas(getIdOrdenExterna(), Long.valueOf(this.xidnrecepcion), this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                            this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "'  where Id='" + this.txtNoOrden.getText() + "'";
                            this.consultas.ejecutarSQL(this.xsql);
                            this.consultas.cerrarConexionBd();
                        } else if (Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) {
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
                    if (getName().equals("xjifrecepcionlab") && !Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") && !Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") && ((!Principal.informacionIps.getIdTipoIdentificacion().equals("NI") || !Principal.informacionIps.getIdentificacion().equals("891408918")) && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") && !Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && !Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") && !Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO"))) {
                        dispose();
                        Principal.clasefacturacion.frmFacturac.nuevo();
                        Principal.clasefacturacion.frmFacturac.frmPersona.txtHistoria.requestFocus();
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
            if (this.xUrgente == 1) {
                JOptionPane.showInternalMessageDialog(this, "ACTUALIZADA COMO URGENTE", "INFORMACION", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            mGrabar_CCitologia();
            return;
        }
        if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && validarDatos() == 1) {
            this.frmPersona.grabar();
            grabarDetalle();
            actualizarEstadoRecepOrden();
            if (!getIdOrdenExterna().equals("0")) {
                if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH")) {
                    new LaboratorioBienestarDAOImpl().actualizarDatosRecepcionSifas(getIdOrdenExterna(), Long.valueOf(this.xidnrecepcion), this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
                    dispose();
                    Principal.clasefacturacion.frmFacturac.dispose();
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
                    new LaboratorioBienestarDAOImpl();
                    this.consultas.ejecutarSQL(this.xsql);
                    this.consultas.cerrarConexionBd();
                    imprimirSticker();
                    dispose();
                }
            }
        }
    }

    private void grabarCabecera() {
        System.out.println(getIdOrdenExterna());
        if (getIdOrdenExterna().equals("0") || getIdOrdenExterna().isEmpty() || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
            this.xsql = "INSERT INTO l_recepcion(FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma , brigada , Fecha, UsuarioS  ) VALUES('" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        } else if (Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
            this.xsql = "INSERT INTO l_recepcion(Id, FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma , brigada , Fecha, UsuarioS) VALUES('" + getIdOrdenExterna() + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        } else if (Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || (Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918"))) {
            this.xsql = "INSERT INTO l_recepcion(FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma, brigada, Fecha, UsuarioS) VALUES('" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        } else {
            this.xsql = "INSERT INTO l_recepcion(Id, FechaRecep, Id_Paciente, Id_TipoA, Id_OrdenFacturac, Observaciones, Id_Profesional, Id_Especialidad, Id_EmpresaConv, Id_Sede, Peso , Talla , Imc, PAbdominal, SCorporal, LProcesamiento, Tipo ,Fecha_Toma , brigada , Fecha, UsuarioS) VALUES('" + getIdOrdenExterna().substring(2, getIdOrdenExterna().length()) + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + this.frmPersona.getIdPersona() + "','" + this.xIdTipoAtencion + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xidProfesional + "','" + this.xidEspecialidad + "','" + this.xidempresacont + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + mTraerValorDatosAntopometricos(this.JTFFSPeso1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSTalla1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSIMC1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSPerimetroAbd1) + "','" + mTraerValorDatosAntopometricos(this.JTFFSCorporal1) + "','" + this.xlproc + "','" + this.xUrgente + "','" + this.metodos.formatoAMD1.format(this.JDF_Fecha_Toma.getDate()) + "','" + this.xBrigada + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        }
        this.xidnrecepcion = this.consultas.ejecutarSQLId(this.xsql);
        consultarConsecutivo();
        this.JTFIdRecepcion.setText(this.xidnrecepcion);
        this.consultas.cerrarConexionBd();
        this.metodos.getInterceptor(Long.valueOf(Principal.claselab.getXid_ingreso()), "VALIDACIÓN RECEPCIÓN", "Se valida recepción".concat(" No. ").concat(this.JTFIdRecepcion.getText()), false);
    }

    private void consultarConsecutivo() {
        try {
            String xsql = "SELECT id, CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0)) consecutivo FROM `l_recepcion` WHERE (`id`=" + this.xidnrecepcion + ");";
            ResultSet rs = this.consultas.traerRs(xsql);
            System.err.println("resultado" + xsql);
            if (rs.next()) {
                rs.first();
                if (Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                    this.JTFConsecutivo.setText(rs.getString("Id"));
                } else {
                    this.JTFConsecutivo.setText(rs.getString("consecutivo"));
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void grabarDetalle() {
        for (int f = 0; f < this.grid.getRowCount(); f++) {
            if (Integer.parseInt(this.modelo.getValueAt(f, 2).toString()) > 0 && this.modelo.getValueAt(f, 3).equals(true)) {
                int xtipo = 0;
                if (this.modelo.getValueAt(f, 5).equals(true)) {
                    xtipo = 1;
                }
                String sqlValidarAgregado = "select count(Id_Procedim) as Registrado from l_detallerecepcion where Id_Recepcion='" + this.xidnrecepcion + "' and Id_Procedim ='" + this.modelo.getValueAt(f, 0) + "'";
                int resultado = Integer.valueOf(this.consultas.traerDato(sqlValidarAgregado)).intValue();
                if (resultado == 0) {
                    this.xsql = "INSERT INTO l_detallerecepcion(Id_Recepcion, Id_Procedim, Cantidad, PMuestra, RObservacion,codigoEnvioBs1,codigoExamenBs1) VALUES('" + this.xidnrecepcion + "','" + this.modelo.getValueAt(f, 0) + "','" + this.modelo.getValueAt(f, 2) + "','" + xtipo + "','" + this.modelo.getValueAt(f, 6) + "','" + this.modelo.getValueAt(f, 10) + "','" + this.modelo.getValueAt(f, 13) + "')";
                    this.consultas.ejecutarSQL(this.xsql);
                }
                this.consultas.cerrarConexionBd();
                if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                    LaboratorioBienestarDAO laboratorioDAO = new LaboratorioBienestarDAOImpl();
                    laboratorioDAO.insertCabezeraResultadosBS1(this.modelo.getValueAt(f, 10).toString(), this.modelo.getValueAt(f, 13).toString(), this.modelo.getValueAt(f, 12).toString());
                }
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

    public void imprimirSticker() {
        if (!this.xidnrecepcion.equals("0")) {
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
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                this.metodos.PresentacionImpresora("l_stiker_n_Fonnegra.jasper", parametros);
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.") || ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO"))) {
                switch (Principal.informacionIps.getNombreIps()) {
                    case "CLINICA PAJONAL S.A.S":
                    case "BIOMED VIDA IPS S.A.S":
                    case "ELKIN AICARDO CORDOBA JULIO":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionBiomed(this.xidnrecepcion);
                        break;
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionHCUP(this.xidnrecepcion);
                        break;
                    case "LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionChinu(this.xidnrecepcion);
                        break;
                    case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
                    case "SERVICIOS MEDICOS SAN IGNACIO SAS":
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA":
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE":
                    case "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH":
                    case "HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.":
                    case "BIEN ESTAR SALUD BS S.A.S.":
                    case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionGeneral(this.xidnrecepcion);
                        break;
                    case "CLINICA SAN FRANCISCO S.A.":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionTulua(this.xidnrecepcion);
                        break;
                    case "E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionSegovia(this.xidnrecepcion, Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio());
                        break;
                    case "FUNDACIÓN PANZENÚ":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionPanzenu(this.xidnrecepcion);
                        break;
                    case "COLGENES S.A.S":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionColgenes(this.xidnrecepcion);
                        break;
                    case "VALLE DEL SOL IPS S.A.S.":
                        this.listaStiker = this.recepcionService.listarStikerRecepcionValleDelSol(this.xidnrecepcion);
                        break;
                    default:
                        this.listaStiker = this.recepcionService.listarStikerRecepcionClasico(this.xidnrecepcion);
                        break;
                }
                if (!this.listaStiker.isEmpty()) {
                    if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        if (Principal.claselab.getxFormaStiker() == 1) {
                            this.listaStiker.forEach(e -> {
                                this.metodos.mImpirmir_CodBarraZebra(e.getIdRecepcion().trim(), e.getPacienteNombre(), e.getPacienteInformacion(), e.getExamen(), e.getTipoMuestra(), e.getFechaRecepcion(), e.getMunicipio(), this.metodos.getInfoSticker());
                            });
                            String sql = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                            xct1.ejecutarSQL(sql);
                            xct1.cerrarConexionBd();
                            return;
                        }
                        if (Principal.claselab.getxFormaStiker() == 0) {
                            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "l_stiker_n", parametros);
                            return;
                        }
                        return;
                    }
                    if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                        Object[] botones = {"Visualizacion", "Impresion", "Cerrar"};
                        for (int i = 0; i < this.listaStiker.size(); i++) {
                            int n = JOptionPane.showOptionDialog((Component) null, "Que desea hacer?", "FORMA DE GENERACIÓN DE STIKER", 0, 3, (Icon) null, botones, botones[2].toString());
                            if (n == 0) {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "l_stiker_n", parametros);
                            } else if (n == 1) {
                                this.metodos.mImpirmir_CodBarraZebra(this.listaStiker.get(i).getIdRecepcion().trim(), this.listaStiker.get(i).getPacienteNombre(), this.listaStiker.get(i).getPacienteInformacion(), this.listaStiker.get(i).getExamen(), this.listaStiker.get(i).getTipoMuestra(), this.listaStiker.get(i).getFechaRecepcion(), this.listaStiker.get(i).getMunicipio(), this.metodos.getInfoSticker());
                            }
                        }
                        String sql2 = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                        xct1.ejecutarSQL(sql2);
                        xct1.cerrarConexionBd();
                        return;
                    }
                    if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.") || ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO"))) {
                        this.listaStiker.forEach(e2 -> {
                            this.metodos.mImpirmir_CodBarraZebra(e2.getIdRecepcion().trim(), e2.getPacienteNombre(), e2.getPacienteInformacion(), e2.getExamen(), e2.getTipoMuestra(), e2.getFechaRecepcion(), e2.getMunicipio(), this.metodos.getInfoSticker());
                        });
                        String sql3 = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                        xct1.ejecutarSQL(sql3);
                        xct1.cerrarConexionBd();
                        return;
                    }
                    if (Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
                        try {
                            this.metodos.mImpirmir_CodBarraZebra(this.listaStiker);
                            String sql4 = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                            xct1.ejecutarSQL(sql4);
                            xct1.cerrarConexionBd();
                            return;
                        } catch (PrintException e3) {
                            return;
                        }
                    }
                    this.listaStiker.forEach(e4 -> {
                        this.metodos.mImpirmir_CodBarraZebra(this.xidnrecepcion, e4.getPacienteNombre(), e4.getPacienteInformacion(), e4.getExamen(), e4.getTipoMuestra(), e4.getFechaRecepcion(), e4.getMunicipio(), this.metodos.getInfoSticker());
                    });
                    String sql5 = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                    xct1.ejecutarSQL(sql5);
                    xct1.cerrarConexionBd();
                }
            }
        }
    }

    public void imprimirSticker2() {
        String xsql;
        if (!this.xidnrecepcion.equals("0")) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String[][] parametros = new String[3][2];
            parametros[0][0] = "id";
            parametros[0][1] = this.xidnrecepcion;
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            System.out.println(this.metodos.getRutaRep());
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
                this.metodos.PresentacionImpresora("l_stiker_n_Fonnegra.jasper", parametros);
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.") || ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO"))) {
                try {
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO")) {
                        xsql = "SELECT IF(`l_tipomuestra`.`Abreviatura`='Orina',CONCAT(`l_recepcion`.`Id`,'.',l_protocoloxprocedimiento.`NAdicional`), `l_recepcion`.`Id`) AS idRecepcion, persona.`NUsuario` AS Dato1, CONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2\n,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n,  IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),'') AS TipoMuestra\n,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\n-- , `l_protocolos`.`Nbre`\n-- , `l_protocolos`.`Id`\n-- , `l_tipomuestra`.`Id`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo`  ON (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`) \nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nLEFT JOIN `l_protocolos` ON (`l_protocolos`.`Id`=`l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nWHERE (`l_recepcion`.`Id` ='" + this.xidnrecepcion + "') GROUP BY idRecepcion,  l_tipo_tubo.`Id`, l_tipomuestra.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                        xsql = "SELECT IF(`l_tipomuestra`.`Abreviatura`='Orina',CONCAT(`l_recepcion`.`Id`,'.',l_protocoloxprocedimiento.`NAdicional`), `l_recepcion`.`Id`) AS idRecepcion\n, persona.`NUsuario` AS Dato1\n,CONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2\n,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n, CONCAT(IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),''),IF( MID(`g_tipoatencion`.`Nbre`, 1, 3)='A','', IF( ingreso.`CS_Parto`=1, CONCAT(' Servicio: ','SALA PARTO'), CONCAT(' Servicio: ', MID(`g_tipoatencion`.`Nbre`, 1, 3))))) AS TipoMuestra\n,GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\n-- , `l_protocolos`.`Nbre`\n-- , `l_protocolos`.`Id`\n-- , `l_tipomuestra`.`Id`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo`  ON (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`) \nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nLEFT JOIN `l_protocolos` ON (`l_protocolos`.`Id`=`l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nINNER JOIN   `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) \nINNER JOIN   `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  \nINNER JOIN   `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) \nWHERE (`l_recepcion`.`Id` ='" + this.xidnrecepcion + "') GROUP BY idRecepcion,  l_tipo_tubo.`Id`, l_tipomuestra.`Id`";
                        System.out.print("Entra Imprimir");
                    } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                        xsql = "SELECT IF(`l_tipomuestra`.`Abreviatura`='Urine',CONCAT(`l_recepcion`.`Id`,'.',l_protocoloxprocedimiento.`NAdicional`), `l_recepcion`.`Id`) AS idRecepcion, persona.`NUsuario` AS Dato1, CONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2\n,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n,  IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra\n,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\n-- , `l_protocolos`.`Nbre`\n-- , `l_protocolos`.`Id`\n-- , `l_tipomuestra`.`Id`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo`  ON (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`) \nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nLEFT JOIN `l_protocolos` ON (`l_protocolos`.`Id`=`l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nWHERE (`l_recepcion`.`Id` ='" + this.xidnrecepcion + "') GROUP BY idRecepcion,  l_areas.`Id`, l_tipomuestra.`Id`";
                        System.out.print("Entra Imprimir");
                    } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.") || ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO"))) {
                        xsql = "SELECT\n\tCONCAT(`l_recepcion`.`Id`, ifnull(UPPER(SUBSTRING(l_tipomuestra.Abreviatura, 1, 1)), ''), ifnull(l_protocoloxprocedimiento.`NAdicional`, '')) AS idRecepcion,\n\tpersona.`NUsuario` AS Dato1,\n\tCONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2 ,\n\tDATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y') AS Fecha ,\n\tIFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-',\n\t'',\n\tGROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n\t'') AS TipoMuestra ,\n\tGROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen ,\n\tpersona.`NMunicipio`\n\t-- , `l_protocolos`.`Nbre`\n\t-- , `l_protocolos`.`Id`\n\t-- , `l_tipomuestra`.`Id`\n\t-- ,`g_procedimiento`.`Nbre`\n\t-- , `l_areas`.Nbre as Areas\n\tFROM d_ips,\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n\t(`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n\t(`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n\t(`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n\t(`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n\t(l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n\t(`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`)\n\tAND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n\t(`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra` ON\n\t(`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nWHERE\n\t(`l_recepcion`.`Id` = '" + this.xidnrecepcion + "')\nGROUP BY\n\tidRecepcion,\n\tl_areas.`Id`,\n\tl_tipomuestra.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.")) {
                        xsql = "SELECT\n\tCONCAT(`l_recepcion`.`Id`, IFNULL(UPPER(SUBSTRING(l_tipomuestra.Abreviatura, 1, 1)), ''), IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')) AS idRecepcion,\n\tpersona.`NUsuario` AS Dato1,\n\tCONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2 ,\n\tDATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y') AS Fecha ,\n\tIFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-',\n\t'',\n\tGROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n\t'') AS TipoMuestra ,\n\tGROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen ,\n\tpersona.`NMunicipio`\n\t-- , `l_protocolos`.`Nbre`\n\t-- , `l_protocolos`.`Id`\n\t-- , `l_tipomuestra`.`Id`\n\t-- ,`g_procedimiento`.`Nbre`\n\t-- , `l_areas`.Nbre as Areas\n\tFROM d_ips,\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n\t(`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n\t(`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n\t(`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n\t(`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n\t(l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n\t(`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`)\n\tAND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n\t(`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra` ON\n\t(`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nWHERE\n\t(`l_recepcion`.`Id` = '" + this.xidnrecepcion + "')\nGROUP BY\n\tidRecepcion,\n\tl_areas.`Id`,\n\tl_tipomuestra.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                        xsql = "SELECT\nCASE WHEN " + Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio() + "=0 THEN \n\tIF(l_tipo_equipos.`Nbre`='COBAS U411',LPAD(CONCAT(`l_recepcion`.`Id`, UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')),6,'0'),CONCAT(`l_recepcion`.`Id`, UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')))\n\tWHEN " + Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio() + "=1 THEN\n\tIF(l_tipo_equipos.`Nbre`='COBAS U411',CONCAT(CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0)), UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')),CONCAT(CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0)), UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')))\n\tEND idRecepcion,\n        persona.`NUsuario` AS Dato1,\n        CONCAT('CC: ', persona.`NoHistoria`, ' - EDAD: ', persona.`Edad`, ' ', LEFT(persona.`NTipoEdad`, 1), ' - GENERO: ', `persona`.`IdSexo`, ' - SERVICIO: ', LEFT(`g_tipoatencion`.`Nbre`, 3)) AS Datos2 ,\n        DATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y %h:%i:%s %p') AS Fecha ,\n        CONCAT('MUESTRA: ',IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-', '', GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n        ''), ' - TIPO DE TUBO: ',`l_tipo_tubo`.`Nbre`) AS TipoMuestra ,\n        CONCAT('EXM: ',GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-')) AS Examen ,\n        persona.`NMunicipio`\n        -- , `l_protocolos`.`Nbre`\n        -- , `l_protocolos`.`Id`\n        -- , `l_tipomuestra`.`Id`\n        -- ,`g_procedimiento`.`Nbre`\n        -- , `l_areas`.Nbre as Areas,\n        -- ,l_tipo_tubo.`Id`\n,l_tipo_tubo.`Id`\n        FROM d_ips,\n        `l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n        (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n        (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n        (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n        (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n        (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n        (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n        (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n        (`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_procedimiento_equipo` ON\n        (`l_procedimiento_equipo`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nLEFT JOIN `l_tipo_equipos` ON\n        (`l_procedimiento_equipo`.`Id_Equipo` = `l_tipo_equipos`.`Id`)\nLEFT JOIN `l_tipomuestra` ON\n        (`l_tipomuestra`.`Id` = `g_procedimiento`.Id_TipoMuestra)\nINNER JOIN `f_ordenes` ON\n        (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON\n        (ingreso.`Id` = `f_ordenes`.`Id_Ingreso`)\nINNER JOIN `g_tipoatencion` ON\n        (`g_tipoatencion`.id = ingreso.`Id_TipoAtencion`)\nWHERE\n        (`l_recepcion`.`Id` = '" + this.xidnrecepcion + "' AND l_detallerecepcion.PMuestra=0)\n GROUP BY idRecepcion, l_tipo_tubo.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
                        xsql = "SELECT IF(`l_tipomuestra`.`Abreviatura`='Orina',CONCAT(`l_recepcion`.`Id`,'.',l_protocoloxprocedimiento.`NAdicional`), `l_recepcion`.`Id`) AS idRecepcion,        persona.`NUsuario` AS Dato1,\n        CONCAT('CC: ', persona.`NoHistoria`, ' - EDAD: ', persona.`Edad`, ' ', LEFT(persona.`NTipoEdad`, 1), ' - GENERO: ', `persona`.`IdSexo`, ' - SERVICIO: ', LEFT(`g_tipoatencion`.`Nbre`, 3)) AS Datos2 ,\n        DATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y %h:%i:%s %p') AS Fecha ,\n        CONCAT('MUESTRA: ',IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-', '', GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n        ''), ' - TIPO DE TUBO: ',`l_tipo_tubo`.`Nbre`) AS TipoMuestra ,\n        CONCAT('EXM: ',GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-')) AS Examen ,\n        persona.`NMunicipio`\n        -- , `l_protocolos`.`Nbre`\n        -- , `l_protocolos`.`Id`\n        -- , `l_tipomuestra`.`Id`\n        -- ,`g_procedimiento`.`Nbre`\n        -- , `l_areas`.Nbre as Areas,\n        -- ,l_tipo_tubo.`Id`\n,l_tipo_tubo.`Id`\n        FROM d_ips,\n        `l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n        (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n        (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n        (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n        (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n        (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n        (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n        (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n        (`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_procedimiento_equipo` ON\n        (`l_procedimiento_equipo`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nLEFT JOIN `l_tipo_equipos` ON\n        (`l_procedimiento_equipo`.`Id_Equipo` = `l_tipo_equipos`.`Id`)\nLEFT JOIN `l_tipomuestra` ON\n        (`l_tipomuestra`.`Id` = `g_procedimiento`.Id_TipoMuestra)\nINNER JOIN `f_ordenes` ON\n        (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON\n        (ingreso.`Id` = `f_ordenes`.`Id_Ingreso`)\nINNER JOIN `g_tipoatencion` ON\n        (`g_tipoatencion`.id = ingreso.`Id_TipoAtencion`)\nWHERE\n        (`l_recepcion`.`Id` = '" + this.xidnrecepcion + "' AND l_detallerecepcion.PMuestra=0)\n GROUP BY idRecepcion, l_tipo_tubo.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S")) {
                        xsql = "SELECT\n\t`l_recepcion`.`Id` AS idRecepcion,\n\tpersona.`NUsuario` AS Dato1,\n\tCONCAT(`persona`.`Id_TipoIdentificacion`,' ',persona.`NoHistoria`,' EDAD: ',persona.`Edad`,' ',persona.`NTipoEdad`,'(s) GENERO:', `persona`.`IdSexo`) AS Datos2 ,\n\tDATE_FORMAT(l_recepcion.`FechaRecep`,'%d/%m/%Y %h:%i:%s %p') AS Fecha ,\n\tIF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra ,\n\tGROUP_CONCAT(DISTINCT `g_procedimiento`.`REF` SEPARATOR '-') AS Examen\nFROM\n\td_ips,\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n\t(`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n\t(`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipomuestra` ON\n\t(`l_tipomuestra`.`Id` = `g_procedimiento`.`Id_TipoMuestra`)\nINNER JOIN `persona` ON\n\t(`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nLEFT JOIN `l_recepcion_citologia` ON\n\t(l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE\n\t(`l_recepcion`.`Id` = '" + this.xidnrecepcion + "')\nGROUP BY\n\t`l_recepcion`.`Id`,\n\t`l_tipomuestra`.`Id`";
                    } else if (Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                        xsql = "SELECT\n        CONCAT(`l_recepcion`.`Id`, UPPER(l_tipomuestra.Indicativo), '', IFNULL(l_protocoloxprocedimiento.`NAdicional`, ''), IF(`l_protocoloxprocedimiento`.`CNOrden_Recepcion`=1,`l_protocoloxprocedimiento`.`Orden`,'')) idRecepcion,\n        persona.`NUsuario` AS Dato1,\n        CONCAT('CC: ', persona.`NoHistoria`, ' - EDAD: ', persona.`Edad`, ' ', LEFT(persona.`NTipoEdad`, 1), ' - GENERO: ', `persona`.`IdSexo`, ' - SERVICIO: ', LEFT(`g_tipoatencion`.`Nbre`, 3)) AS Datos2 ,\n        DATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y %h:%i:%s %p') AS Fecha ,\n        CONCAT('MUESTRA: ',IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-', '', GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n        ''), ' - TIPO DE TUBO: ',`l_tipo_tubo`.`Nbre`) AS TipoMuestra ,\n        CONCAT('EXM: ',GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-')) AS Examen ,\n        persona.`NMunicipio`\n        -- , `l_protocolos`.`Nbre`\n        -- , `l_protocolos`.`Id`\n        -- , `l_tipomuestra`.`Id`\n        -- ,`g_procedimiento`.`Nbre`\n        -- , `l_areas`.Nbre as Areas,\n        -- ,l_tipo_tubo.`Id`\n,l_tipo_tubo.`Id`\n        FROM d_ips,\n        `l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n        (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n        (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n        (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n        (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n        (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n        (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n        (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n        (`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_procedimiento_equipo` ON\n        (`l_procedimiento_equipo`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nLEFT JOIN `l_tipo_equipos` ON\n        (`l_procedimiento_equipo`.`Id_Equipo` = `l_tipo_equipos`.`Id`)\nLEFT JOIN `l_tipomuestra` ON\n        (`l_tipomuestra`.`Id` = `g_procedimiento`.Id_TipoMuestra)\nINNER JOIN `f_ordenes` ON\n        (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON\n        (ingreso.`Id` = `f_ordenes`.`Id_Ingreso`)\nINNER JOIN `g_tipoatencion` ON\n        (`g_tipoatencion`.id = ingreso.`Id_TipoAtencion`)\nWHERE\n        (`l_recepcion`.`Id` = '" + this.xidnrecepcion + "' AND l_detallerecepcion.PMuestra=0)\n GROUP BY idRecepcion, l_tipo_tubo.`Id`";
                    } else {
                        xsql = "SELECT `l_recepcion`.`Id` AS idRecepcion, persona.`NUsuario` as Dato1, concat('No.HC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`,' ', persona.`NTipoEdad`, '(s)') as Datos2\n ,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n  ,  IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra\n    ,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `g_procedimiento`.`Id_TipoMuestra`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nWHERE (`l_recepcion`.`Id` ='" + this.xidnrecepcion + "') GROUP BY `l_recepcion`.`Id`, `l_tipomuestra`.`Id`";
                    }
                    ResultSet xrs = this.consultas.traerRs(xsql);
                    if (xrs.next()) {
                        xrs.beforeFirst();
                        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                            if (Principal.claselab.getxFormaStiker() == 1) {
                                while (xrs.next()) {
                                    this.metodos.mImpirmir_CodBarraZebra(xrs.getString("idRecepcion").trim(), xrs.getString("Dato1"), xrs.getString("Datos2"), xrs.getString("Examen"), xrs.getString("TipoMuestra"), xrs.getString("Fecha"), xrs.getString("NMunicipio"), this.metodos.getInfoSticker());
                                    String sql = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                                    xct1.ejecutarSQL(sql);
                                    xct1.cerrarConexionBd();
                                }
                            } else if (Principal.claselab.getxFormaStiker() == 0) {
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "l_stiker_n", parametros);
                            }
                        } else if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                            while (xrs.next()) {
                                Object[] botones = {"Visualizacion", "Impresion", "Cerrar"};
                                int n = JOptionPane.showOptionDialog((Component) null, "Que desea hacer?", "FORMA DE GENERACIÓN DE STIKER", 0, 3, (Icon) null, botones, "Cerrar");
                                if (n == 0) {
                                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "l_stiker_n", parametros);
                                } else if (n == 1) {
                                    this.metodos.mImpirmir_CodBarraZebra(xrs.getString("idRecepcion").trim(), xrs.getString("Dato1"), xrs.getString("Datos2"), xrs.getString("Examen"), xrs.getString("TipoMuestra"), xrs.getString("Fecha"), "", this.metodos.getInfoSticker());
                                    String sql2 = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                                    xct1.ejecutarSQL(sql2);
                                    xct1.cerrarConexionBd();
                                }
                            }
                        } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.") || ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getNombreIps().equals("COLGENES S.A.S") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO"))) {
                            while (xrs.next()) {
                                this.metodos.mImpirmir_CodBarraZebra(xrs.getString("idRecepcion").trim(), xrs.getString("Dato1"), xrs.getString("Datos2"), xrs.getString("Examen"), xrs.getString("TipoMuestra"), xrs.getString("Fecha"), "", this.metodos.getInfoSticker());
                                String sql3 = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                                xct1.ejecutarSQL(sql3);
                                xct1.cerrarConexionBd();
                            }
                        } else {
                            while (xrs.next()) {
                                this.metodos.mImpirmir_CodBarraZebra(this.xidnrecepcion.trim(), xrs.getString("Dato1"), xrs.getString("Datos2"), xrs.getString("Examen"), xrs.getString("TipoMuestra"), xrs.getString("Fecha"), "", this.metodos.getInfoSticker());
                                String sql4 = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                                xct1.ejecutarSQL(sql4);
                                xct1.cerrarConexionBd();
                            }
                        }
                    }
                    xrs.close();
                    this.consultas.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } else {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "l_stiker_n", parametros);
            }
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                imprimirRelacionRecepcion();
            }
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
        String xsql;
        ConsultasMySQL xct1 = new ConsultasMySQL();
        try {
            if (Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("ELKIN AICARDO CORDOBA JULIO")) {
                xsql = "SELECT `l_recepcion`.`Id` AS idRecepcion, persona.`NUsuario`, CONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2\n ,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n  ,  IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra\n    ,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `g_procedimiento`.`Id_TipoMuestra`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\n INNER JOIN `l_tipo_tubo`  ON (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`) \nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nWHERE (`l_recepcion`.`Id` ='" + this.xidnrecepcion + "' AND g_procedimiento.`Id`='" + xIdProcedimiento + "') GROUP BY `l_recepcion`.`Id`,  l_areas.`Id`";
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                xsql = "SELECT `l_recepcion`.`Id` AS idRecepcion, persona.`NUsuario`,CONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2\n,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n, CONCAT(IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),''),IF( MID(`g_tipoatencion`.`Nbre`, 1, 3)='A','', IF( ingreso.`CS_Parto`=1, CONCAT(' Servicio: ','SALA PARTO'), CONCAT(' Servicio: ', MID(`g_tipoatencion`.`Nbre`, 1, 3))))) AS TipoMuestra\n, GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\n-- , `l_protocolos`.`Nbre`\n-- , `l_protocolos`.`Id`\n-- , `l_tipomuestra`.`Id`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo`  ON (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`) \nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nLEFT JOIN `l_protocolos` ON (`l_protocolos`.`Id`=`l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nINNER JOIN   `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) \nINNER JOIN   `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  \nINNER JOIN   `g_tipoatencion`  ON (`ingreso`.`Id_TipoAtencion` = `g_tipoatencion`.`Id`) \nWHERE (`l_recepcion`.`Id` ='" + this.xidnrecepcion + "' AND g_procedimiento.`Id`='" + xIdProcedimiento + "') GROUP BY `l_recepcion`.`Id`,  l_areas.`Id`";
            } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                xsql = "SELECT `l_recepcion`.`Id` AS idRecepcion, persona.`NUsuario`, CONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2\n ,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n  ,  IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra\n    ,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen , persona.`NMunicipio`\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `g_procedimiento`.`Id_TipoMuestra`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\n INNER JOIN `l_tipo_tubo`  ON (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`) \nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nWHERE (`l_recepcion`.`Id` ='" + this.xidnrecepcion + "' AND g_procedimiento.`Id`='" + xIdProcedimiento + "') GROUP BY `l_recepcion`.`Id`,  l_areas.`Id`";
            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.") || ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO"))) {
                xsql = "SELECT\n\tCONCAT(`l_recepcion`.`Id`, ifnull(UPPER(SUBSTRING(l_tipomuestra.Abreviatura, 1, 1)), '')) AS idRecepcion,\n\tpersona.`NUsuario`,\n\tCONCAT('CC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`) AS Datos2 ,\n\tDATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y') AS Fecha ,\n\tIFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-',\n\t'',\n\tGROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n\t'') AS TipoMuestra ,\n\tGROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen ,\n\tpersona.`NMunicipio`\n\t-- , `l_protocolos`.`Nbre`\n\t-- , `l_protocolos`.`Id`\n\t-- , `l_tipomuestra`.`Id`\n\t-- ,`g_procedimiento`.`Nbre`\n\t-- , `l_areas`.Nbre as Areas\n\tFROM d_ips,\n\t`l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n\t(`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n\t(`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n\t(`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n\t(`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n\t(`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n\t(l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n\t(`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`)\n\tAND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n\t(`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_tipomuestra` ON\n\t(`l_tipomuestra`.`Id` = `l_protocolos`.`Id_Tipo_Muestra`)\nWHERE\n\t(`l_recepcion`.`Id` = '" + this.xidnrecepcion + "' AND g_procedimiento.`Id`='" + xIdProcedimiento + "')\nGROUP BY\n\tidRecepcion,\n\tl_areas.`Id`,\n\tl_tipomuestra.`Id`";
            } else if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                xsql = "SELECT\n        CASE WHEN " + Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio() + "=0 THEN \n\t      IF(l_tipo_equipos.`Nbre`='COBAS U411',LPAD(CONCAT(`l_recepcion`.`Id`, IF(" + cantidad + ">0,'-','')),6,'0'), CONCAT(`l_recepcion`.`Id`,UPPER(l_tipomuestra.Indicativo), IFNULL(l_protocoloxprocedimiento.`NAdicional`, '')))\n\t   WHEN " + Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio() + "=1 THEN\n\t      IF(l_tipo_equipos.`Nbre`='COBAS U411',CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0), IF(" + cantidad + ">0,'-','')),CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0), UPPER(l_tipomuestra.Indicativo), IFNULL(l_protocoloxprocedimiento.`NAdicional`, '')))\n\t   END idRecepcion,        persona.`NUsuario`,\n        CONCAT('CC: ', persona.`NoHistoria`, ' - EDAD: ', persona.`Edad`, ' ', LEFT(persona.`NTipoEdad`, 1), ' - GENERO: ', `persona`.`IdSexo`, ' - SERVICIO: ', LEFT(`g_tipoatencion`.`Nbre`, 3)) AS Datos2 ,\n        DATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y %h:%i:%s %p') AS Fecha ,\n        CONCAT('MUESTRA: ',IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-', '', GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n        ''), ' - TIPO DE TUBO: ',`l_tipo_tubo`.`Nbre`) AS TipoMuestra ,\n        CONCAT('EXM: ',GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-')) AS Examen ,\n        persona.`NMunicipio`\n        -- , `l_protocolos`.`Nbre`\n        -- , `l_protocolos`.`Id`\n        -- , `l_tipomuestra`.`Id`\n        -- ,`g_procedimiento`.`Nbre`\n        -- , `l_areas`.Nbre as Areas,\n        -- ,l_tipo_tubo.`Id`\n        FROM d_ips,\n        `l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n        (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n        (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n        (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n        (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n        (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n        (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n        (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n        (`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_procedimiento_equipo` ON\n        (`l_procedimiento_equipo`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nLEFT JOIN `l_tipo_equipos` ON\n        (`l_procedimiento_equipo`.`Id_Equipo` = `l_tipo_equipos`.`Id`)\nLEFT JOIN `l_tipomuestra` ON\n        (`l_tipomuestra`.`Id` = `g_procedimiento`.Id_TipoMuestra)\nINNER JOIN `f_ordenes` ON\n        (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON\n        (ingreso.`Id` = `f_ordenes`.`Id_Ingreso`)\nINNER JOIN `g_tipoatencion` ON\n        (`g_tipoatencion`.id = ingreso.`Id_TipoAtencion`)\nWHERE\n        (`l_recepcion`.`Id` = '" + this.xidnrecepcion + "' AND g_procedimiento.`Id`='" + xIdProcedimiento + "')\n GROUP BY idRecepcion, l_tipo_tubo.`Id`";
            } else if (Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.")) {
                xsql = "SELECT\n        CONCAT(`l_recepcion`.`Id`, UPPER(l_tipomuestra.Indicativo), '', " + cantidad + ") idRecepcion,\n        persona.`NUsuario`,\n        CONCAT('CC: ', persona.`NoHistoria`, ' - EDAD: ', persona.`Edad`, ' ', LEFT(persona.`NTipoEdad`, 1), ' - GENERO: ', `persona`.`IdSexo`, ' - SERVICIO: ', LEFT(`g_tipoatencion`.`Nbre`, 3)) AS Datos2 ,\n        DATE_FORMAT(l_recepcion.`FechaRecep`, '%d-%m-%Y %h:%i:%s %p') AS Fecha ,\n        CONCAT('MUESTRA: ',IFNULL(IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')= '-', '', GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')),\n        ''), ' - TIPO DE TUBO: ',`l_tipo_tubo`.`Nbre`) AS TipoMuestra ,\n        CONCAT('EXM: ',GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-')) AS Examen ,\n        persona.`NMunicipio`\n        -- , `l_protocolos`.`Nbre`\n        -- , `l_protocolos`.`Id`\n        -- , `l_tipomuestra`.`Id`\n        -- ,`g_procedimiento`.`Nbre`\n        -- , `l_areas`.Nbre as Areas,\n        -- ,l_tipo_tubo.`Id`\n,l_tipo_tubo.`Id`\n        FROM d_ips,\n        `l_detallerecepcion`\nINNER JOIN `l_recepcion` ON\n        (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `g_procedimiento` ON\n        (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN `l_areas` ON\n        (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `persona` ON\n        (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nINNER JOIN `l_tipo_tubo` ON\n        (`g_procedimiento`.`Id_Tubo` = `l_tipo_tubo`.`Id`)\nLEFT JOIN `l_recepcion_citologia` ON\n        (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN `l_protocoloxprocedimiento` ON\n        (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado` = 0)\nLEFT JOIN `l_protocolos` ON\n        (`l_protocolos`.`Id` = `l_protocoloxprocedimiento`.`Id_Protocolo`)\nLEFT JOIN `l_procedimiento_equipo` ON\n        (`l_procedimiento_equipo`.`Id_Procedimiento` = `g_procedimiento`.`Id`)\nLEFT JOIN `l_tipo_equipos` ON\n        (`l_procedimiento_equipo`.`Id_Equipo` = `l_tipo_equipos`.`Id`)\nLEFT JOIN `l_tipomuestra` ON\n        (`l_tipomuestra`.`Id` = `g_procedimiento`.Id_TipoMuestra)\nINNER JOIN `f_ordenes` ON\n        (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON\n        (ingreso.`Id` = `f_ordenes`.`Id_Ingreso`)\nINNER JOIN `g_tipoatencion` ON\n        (`g_tipoatencion`.id = ingreso.`Id_TipoAtencion`)\nWHERE\n        (`l_recepcion`.`Id` = '" + this.xidnrecepcion + "' AND g_procedimiento.`Id`='" + xIdProcedimiento + "')\n GROUP BY idRecepcion, l_tipo_tubo.`Id`";
            } else {
                xsql = "SELECT `l_recepcion`.`Id` AS idRecepcion, persona.`NUsuario`, concat('No.HC: ', persona.`NoHistoria`, '  EDAD: ', persona.`Edad`,' ', persona.`NTipoEdad`, '(s)') as Datos2\n ,DATE_FORMAT(l_recepcion.`FechaRecep`,'%d-%m-%Y') AS Fecha\n  ,  IF(GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')='-','',GROUP_CONCAT(DISTINCT `l_tipomuestra`.`Abreviatura` SEPARATOR '-')) AS TipoMuestra\n    ,   GROUP_CONCAT(DISTINCT `g_procedimiento`.`Ref` SEPARATOR '-') AS Examen\nFROM d_ips,`l_detallerecepcion`\nINNER JOIN `l_recepcion`  ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN  `g_procedimiento` ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas` ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`)\nINNER JOIN `l_tipomuestra`  ON (`l_tipomuestra`.`Id` = `g_procedimiento`.`Id_TipoMuestra`)\nINNER JOIN `persona`  ON (`persona`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\nLEFT JOIN `l_recepcion_citologia`  ON (l_recepcion_citologia.`Id_Recepcion` = `l_recepcion`.`Id`)\nLEFT JOIN  `l_protocoloxprocedimiento`  ON (`l_protocoloxprocedimiento`.`Id_Procedim` = `g_procedimiento`.`Id`) AND (l_protocoloxprocedimiento.`Estado`=0)\nWHERE (`l_recepcion`.`Id` ='" + this.xidnrecepcion + "' AND g_procedimiento.`Id`='" + xIdProcedimiento + "') GROUP BY `l_recepcion`.`Id`, `l_tipomuestra`.`Id`";
            }
            ResultSet xrs = this.consultas.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (cantidad == 0) {
                        this.metodos.mImpirmir_CodBarraZebra(xrs.getString("idRecepcion").trim(), xrs.getString("NUsuario"), xrs.getString("Datos2"), xrs.getString("Examen"), xrs.getString("TipoMuestra"), xrs.getString("Fecha"), "", this.metodos.getInfoSticker());
                    } else {
                        for (int i = 0; i < cantidad; i++) {
                            if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("SERVICIOS MEDICOS SAN IGNACIO SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE") || Principal.informacionIps.getNombreIps().equals("CLINICA SAN FRANCISCO S.A.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH") || Principal.informacionIps.getNombreIps().equals("HOSPITAL SAN VICENTE DE PAUL EMPRESA SOCIAL DEL ESTADO E.S.E.") || ((Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) || Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia") || Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO"))) {
                                this.metodos.mImpirmir_CodBarraZebra(xrs.getString("idRecepcion").trim() + (i + 1), xrs.getString("NUsuario"), xrs.getString("Datos2"), xrs.getString("Examen"), xrs.getString("TipoMuestra"), xrs.getString("Fecha"), "", this.metodos.getInfoSticker());
                            } else {
                                this.metodos.mImpirmir_CodBarraZebra(xrs.getString("idRecepcion").trim() + "-" + (i + 1), xrs.getString("NUsuario"), xrs.getString("Datos2"), xrs.getString("Examen"), xrs.getString("TipoMuestra"), xrs.getString("Fecha"), "", this.metodos.getInfoSticker());
                            }
                        }
                    }
                    String sql = "update l_recepcion set ImpresionStiker = 1 where Id = '" + this.xidnrecepcion + "'";
                    xct1.ejecutarSQL(sql);
                    xct1.cerrarConexionBd();
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
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

    /* JADX WARN: Type inference failed for: r3v104, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtNoOrden = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.txtProfesional = new JTextField();
        this.JBTConsultarHC = new JButton();
        this.JTFFSTalla1 = new JFormattedTextField();
        this.JTFFSPeso1 = new JFormattedTextField();
        this.JTFFSIMC1 = new JFormattedTextField();
        this.JTFFSPerimetroAbd1 = new JFormattedTextField();
        this.JTFFSCorporal1 = new JFormattedTextField();
        this.JDF_Fecha = new JDateChooser();
        this.JDF_Fecha_Toma = new JDateChooser();
        this.JCHCitologia = new JCheckBox();
        this.JBTEventoAdverso1 = new JButton();
        this.JCHUrgente = new JCheckBox();
        this.JBTCargarPDF = new JButton();
        this.JCHBrigada = new JCheckBox();
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
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        setClosable(true);
        setTitle("RECEPCIÓN AUTOMATICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(982, 577));
        setMinimumSize(new Dimension(982, 577));
        setName("RecepcionBienestarSalud");
        setNormalBounds(new Rectangle(0, 0, 106, 0));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.5
            public void internalFrameActivated(InternalFrameEvent evt) {
                RecepcionAutoBienestarSalud.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                RecepcionAutoBienestarSalud.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                RecepcionAutoBienestarSalud.this.formInternalFrameClosing(evt);
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
        this.txtNoOrden.setFont(new Font("Arial", 1, 12));
        this.txtNoOrden.setHorizontalAlignment(0);
        this.txtNoOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "N° de Orden / Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoOrden.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.6
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.txtNoOrdenActionPerformed(evt);
            }
        });
        this.txtNoOrden.addFocusListener(new FocusAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.7
            public void focusLost(FocusEvent evt) {
                RecepcionAutoBienestarSalud.this.txtNoOrdenFocusLost(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.setVerticalScrollBarPolicy(21);
        this.txtObservaciones.setBorder((Border) null);
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.txtProfesional.setFont(new Font("Arial", 1, 12));
        this.txtProfesional.setHorizontalAlignment(0);
        this.txtProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Ordena", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtProfesional.setDisabledTextColor(new Color(0, 0, 0));
        this.txtProfesional.setEnabled(false);
        this.JBTConsultarHC.setFont(new Font("Arial", 1, 12));
        this.JBTConsultarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBTConsultarHC.setText("Consultar Ordenes Médicas");
        this.JBTConsultarHC.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.8
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JBTConsultarHCActionPerformed(evt);
            }
        });
        this.JTFFSTalla1.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFSTalla1.setHorizontalAlignment(4);
        this.JTFFSTalla1.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.9
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFSTalla1ActionPerformed(evt);
            }
        });
        this.JTFFSTalla1.addFocusListener(new FocusAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.10
            public void focusLost(FocusEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFSTalla1FocusLost(evt);
            }
        });
        this.JTFFSTalla1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.11
            public void keyPressed(KeyEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFSTalla1KeyPressed(evt);
            }
        });
        this.JTFFSPeso1.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFSPeso1.setHorizontalAlignment(4);
        this.JTFFSPeso1.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso1.addFocusListener(new FocusAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.12
            public void focusLost(FocusEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFSPeso1FocusLost(evt);
            }
        });
        this.JTFFSPeso1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.13
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFSPeso1ActionPerformed(evt);
            }
        });
        this.JTFFSPeso1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.14
            public void keyPressed(KeyEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFSPeso1KeyPressed(evt);
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
        this.JTFFSPerimetroAbd1.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.15
            public void keyPressed(KeyEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFSPerimetroAbd1KeyPressed(evt);
            }
        });
        this.JTFFSCorporal1.setEditable(false);
        this.JTFFSCorporal1.setBorder(BorderFactory.createTitledBorder((Border) null, "S. Corporal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSCorporal1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFSCorporal1.setHorizontalAlignment(4);
        this.JTFFSCorporal1.setFont(new Font("Arial", 1, 12));
        this.JDF_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Recepción", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDF_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JDF_Fecha.setFont(new Font("Arial", 1, 12));
        this.JDF_Fecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                RecepcionAutoBienestarSalud.this.JDF_FechaPropertyChange(evt);
            }
        });
        this.JDF_Fecha_Toma.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Toma", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDF_Fecha_Toma.setDateFormatString("dd/MM/yyyy");
        this.JDF_Fecha_Toma.setFont(new Font("Arial", 1, 12));
        this.JDF_Fecha_Toma.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                RecepcionAutoBienestarSalud.this.JDF_Fecha_TomaPropertyChange(evt);
            }
        });
        this.JCHCitologia.setFont(new Font("Arial", 1, 12));
        this.JCHCitologia.setText("Es Citología?");
        this.JCHCitologia.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.18
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JCHCitologiaActionPerformed(evt);
            }
        });
        this.JBTEventoAdverso1.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso1.setText("Casos de Seguridad Clinica");
        this.JBTEventoAdverso1.setToolTipText("Evento Adverso");
        this.JBTEventoAdverso1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.19
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JBTEventoAdverso1ActionPerformed(evt);
            }
        });
        this.JCHUrgente.setFont(new Font("Arial", 1, 12));
        this.JCHUrgente.setForeground(Color.red);
        this.JCHUrgente.setText("Es Urgente?");
        this.JCHUrgente.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.20
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JCHUrgenteActionPerformed(evt);
            }
        });
        this.JBTCargarPDF.setFont(new Font("Arial", 1, 12));
        this.JBTCargarPDF.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBTCargarPDF.setText("Cargar Resultados Externos");
        this.JBTCargarPDF.setToolTipText("Evento Adverso");
        this.JBTCargarPDF.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.21
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JBTCargarPDFActionPerformed(evt);
            }
        });
        this.JCHBrigada.setFont(new Font("Arial", 1, 12));
        this.JCHBrigada.setText("Es Brigada?");
        this.JCHBrigada.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.22
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JCHBrigadaActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtNoOrden, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDF_Fecha, -2, 117, -2)).addComponent(this.txtProfesional, -2, 269, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JDF_Fecha_Toma, -2, 117, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSTalla1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPeso1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSIMC1, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPerimetroAbd1, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSCorporal1, -2, 132, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jScrollPane1)))).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCHCitologia).addGap(18, 18, 18).addComponent(this.JCHUrgente).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHBrigada))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTEventoAdverso1, -2, 228, -2).addComponent(this.JBTConsultarHC, -2, 228, -2).addComponent(this.JBTCargarPDF, -2, 228, -2))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBTConsultarHC, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEventoAdverso1, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHCitologia).addComponent(this.JCHUrgente).addComponent(this.JCHBrigada))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JBTCargarPDF, -1, 40, 32767).addContainerGap()))).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDF_Fecha, -1, -1, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING)).addComponent(this.txtNoOrden, GroupLayout.Alignment.TRAILING, -2, 46, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtProfesional, -2, 50, -2).addComponent(this.JTFFSPerimetroAbd1, -2, 55, -2).addComponent(this.JTFFSCorporal1, -2, 55, -2).addComponent(this.JTFFSTalla1, -2, 55, -2).addComponent(this.JTFFSPeso1, -2, 55, -2).addComponent(this.JTFFSIMC1, -2, 55, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JDF_Fecha_Toma, -2, 50, -2)))));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.23
            public void mouseClicked(MouseEvent evt) {
                RecepcionAutoBienestarSalud.this.gridMouseClicked(evt);
            }
        });
        this.grid.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.24
            public void keyPressed(KeyEvent evt) {
                RecepcionAutoBienestarSalud.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.grid);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.25
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JCHAgrupar.setFont(new Font("Arial", 1, 12));
        this.JCHAgrupar.setText("Agrupar?");
        this.JCHAgrupar.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.26
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JCHAgruparActionPerformed(evt);
            }
        });
        this.JTFFNRecepcion.setEditable(false);
        this.JTFFNRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Recepción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNRecepcion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNRecepcion.setHorizontalAlignment(4);
        this.JTFFNRecepcion.setFont(new Font("Arial", 1, 12));
        this.JTFFNRecepcion.addFocusListener(new FocusAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.27
            public void focusLost(FocusEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFNRecepcionFocusLost(evt);
            }
        });
        this.JTFFNRecepcion.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.28
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFNRecepcionActionPerformed(evt);
            }
        });
        this.JTFFNRecepcion.addKeyListener(new KeyAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.29
            public void keyPressed(KeyEvent evt) {
                RecepcionAutoBienestarSalud.this.JTFFNRecepcionKeyPressed(evt);
            }
        });
        this.JBTCerrar1.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCerrar1.setText("Validado");
        this.JBTCerrar1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.30
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JBTCerrar1ActionPerformed(evt);
            }
        });
        this.JBTCerrar2.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.JBTCerrar2.setText("Registro de Citología");
        this.JBTCerrar2.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.31
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JBTCerrar2ActionPerformed(evt);
            }
        });
        this.JBTCerrar3.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTCerrar3.setText("Generar");
        this.JBTCerrar3.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.32
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JBTCerrar3ActionPerformed(evt);
            }
        });
        this.JBTVisualizacionCOvid.setFont(new Font("Arial", 1, 12));
        this.JBTVisualizacionCOvid.setIcon(new ImageIcon(getClass().getResource("/Imagenes/TXT_24px.png")));
        this.JBTVisualizacionCOvid.setText("<html><P ALIGN=center>Visualización Ficha Covid");
        this.JBTVisualizacionCOvid.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.33
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.JBTVisualizacionCOvidActionPerformed(evt);
            }
        });
        this.JTFIdRecepcion.setEditable(false);
        this.JTFIdRecepcion.setFont(new Font("Arial", 1, 14));
        this.JTFIdRecepcion.setHorizontalAlignment(0);
        this.JTFIdRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Interno", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFConsecutivo.setEditable(false);
        this.JTFConsecutivo.setFont(new Font("Arial", 1, 14));
        this.JTFConsecutivo.setHorizontalAlignment(0);
        this.JTFConsecutivo.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Consecutivo", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jButton1.setBackground(new Color(0, 102, 255));
        this.jButton1.setFont(new Font("Arial", 1, 14));
        this.jButton1.setText("LLAMAR PACIENTE");
        this.jButton1.setBorder(BorderFactory.createLineBorder(new Color(51, 255, 102)));
        this.jButton1.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.34
            public void mouseClicked(MouseEvent evt) {
                RecepcionAutoBienestarSalud.this.jButton1MouseClicked(evt);
            }
        });
        this.jButton1.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.35
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setBackground(new Color(255, 0, 0));
        this.jButton2.setFont(new Font("Arial", 1, 14));
        this.jButton2.setText("Liberar x No Respuesta");
        this.jButton2.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
        this.jButton2.addMouseListener(new MouseAdapter() { // from class: Laboratorio.RecepcionAutoBienestarSalud.36
            public void mouseClicked(MouseEvent evt) {
                RecepcionAutoBienestarSalud.this.jButton2MouseClicked(evt);
            }
        });
        this.jButton2.addActionListener(new ActionListener() { // from class: Laboratorio.RecepcionAutoBienestarSalud.37
            public void actionPerformed(ActionEvent evt) {
                RecepcionAutoBienestarSalud.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCHAgrupar).addGap(23, 23, 23).addComponent(this.JTFFNRecepcion, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar1, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar3, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar2, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTVisualizacionCOvid, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTCerrar, -2, 170, -2)).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane2).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.panelPersona, -2, 961, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFConsecutivo, -1, 217, 32767).addComponent(this.JTFIdRecepcion, -1, 217, 32767).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addComponent(this.jButton2, GroupLayout.Alignment.TRAILING, -2, 217, -2)))).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.panelPersona, -2, 170, -2).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JTFIdRecepcion, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFConsecutivo, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 19, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton2).addGap(14, 14, 14))).addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 214, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCerrar1, -2, 50, -2).addComponent(this.JBTCerrar2, -2, 50, -2).addComponent(this.JBTCerrar3, -2, 50, -2).addComponent(this.JBTCerrar, -2, 50, -2)).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHAgrupar).addComponent(this.JTFFNRecepcion, -2, 50, -2)).addComponent(this.JBTVisualizacionCOvid, -2, 50, -2)).addGap(20, 20, 20)));
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
        if (getName().equals("Recepcion") && Principal.claselab.xjifagenda == null) {
            Principal.mLimpiarDatosP();
            Principal.claselab.cargarPantalla("Agenda");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrar1ActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            if (!this.xidnrecepcion.equals("0")) {
                grabarDetalle();
                EnviarTomaBS1(this.JTFIdRecepcion.getText());
                String idLaboratorio = RecuperarIdLaboratorioBS1(String.valueOf(this.idIngreso));
                liberarPacienteAgendaBS1(idLaboratorio);
                JOptionPane.showMessageDialog((Component) null, "Validado con exito");
                this.JBTCerrar1.setEnabled(false);
                claseLab claselab = Principal.claselab;
                if (claseLab.interaccionAgendas) {
                    inicializarDatosInterfazSimedis();
                }
                this.metodos.getInterceptor(Long.valueOf(Principal.claselab.getXid_ingreso()), "VALIDACIÓN RECEPCIÓN", "Se valida recepción".concat(" No. ").concat(this.JTFIdRecepcion.getText()), false);
            } else {
                JOptionPane.showMessageDialog((Component) null, "No hay un número de orden");
            }
        }
        if (!this.xidnrecepcion.equals("0")) {
            this.xsql = "update f_ordenes set EstadoRecep=2, FechaRAtencion='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Id_OrdenRecep='" + this.xidnrecepcion + "' where Id='" + this.txtNoOrden.getText() + "'";
            this.consultas.ejecutarSQL(this.xsql);
            this.consultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrar2ActionPerformed(ActionEvent evt) {
        if (!this.JTFIdRecepcion.getText().isEmpty()) {
            try {
                Principal.clasepyp = new clasePyP(Principal.claselab.frmPrincipal);
                Principal.clasepyp.setXidrecepcion(Long.valueOf(this.JTFIdRecepcion.getText()).longValue());
                Principal.clasepyp.setXid_tipof(Principal.claselab.getXtipo_empresa());
                Principal.clasepyp.setXid_ingreso(Principal.claselab.getXid_ingreso());
                Principal.clasepyp.cargarPantalla("Toma");
                Principal.clasepyp.frmToma.frmPersona.txtHistoria.setText(this.frmPersona.getHistoria());
                Principal.clasepyp.frmToma.frmPersona.buscar(2);
                Principal.clasepyp.frmToma.setSelected(true);
                dispose();
            } catch (PropertyVetoException e) {
                Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, e);
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
            if (!m.isEmpty() && isNumeric(m)) {
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
        if (this.grid.getSelectedRow() != -1 && this.grid.getSelectedColumn() == 3) {
            if (Boolean.valueOf(this.modelo.getValueAt(this.grid.getSelectedRow(), 3).toString()).booleanValue()) {
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
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", String.valueOf(Principal.claselab.getXid_ingreso()), 29);
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

    private String ValidarIdMedicoBS1(String idPersonaBs1) {
        ResultSet rs;
        Throwable th;
        String idMedico = "";
        String Query = "select top 1 Empresa_Empleado.Emp_ID,\n                Persona.Per_NombreFull,\n                Persona.Per_ID,\n                General_Usuario.Usr_Activo,\n                Asignados\n                from Empresa_Empleado \n                INNER JOIN HistoriasClinicas_Asignadas ON(HistoriasClinicas_Asignadas.Emp_ID = Empresa_Empleado.Emp_ID)\n                inner join Persona ON (Empresa_Empleado.zPer_ID = Persona.Per_ID)\n                inner join General_Usuario on (General_Usuario.zDPer_ID=Persona.Per_ID )\n                where Persona.Per_ID ='" + idPersonaBs1 + "'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    idMedico = rs.getString("Emp_ID");
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
                Cs.cerrarConexionBd();
                return idMedico;
            } finally {
            }
        } finally {
        }
    }

    private String RecuperarConsultorioMedicoLogueadoBS1(String idPersonaMedicoBs1) {
        ResultSet rs;
        Throwable th;
        String idConsultorio = "";
        String Query = "--RECUPERAR ID CONSULTORIO DEL MEDICO\nselect PE.Per_ID, PE.Per_NombreFull, PD.Doc_Numero,TC.CMed_ID,TC.CMed_Consultorio from Televisor_ConsultiriosXMedico EP\nINNER JOIN Persona PE ON ( PE.Per_ID= EP.zPer_ID_Medico)\nINNER JOIN Persona_Documento PD ON(PD.Doc_ID = PE.zDoc_ID)\nINNER JOIN Televisor_ConsultiriosXMedico TC ON(TC.zPer_ID_Medico = PE.Per_ID)\nWHERE TC.zPer_ID_Medico= '" + idPersonaMedicoBs1 + "'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    idConsultorio = rs.getString("CMed_ID");
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
                Cs.cerrarConexionBd();
                return idConsultorio;
            } finally {
            }
        } finally {
        }
    }

    private String RecuperarIdLaboratorioBS1(String idIngreso) {
        ResultSet rs;
        Throwable th;
        String idLaboratorioBS1 = "";
        String Query = "SELECT `NoAutorizacion` FROM `ingreso` WHERE `id` = '" + idIngreso + "'";
        ConsultasMySQL Cm = new ConsultasMySQL();
        try {
            rs = Cm.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    idLaboratorioBS1 = rs.getString("NoAutorizacion");
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
                Cm.cerrarConexionBd();
                return idLaboratorioBS1;
            } finally {
            }
        } finally {
        }
    }

    private String RecuperarIdPersonaPorAtenderBS1(String noDocumento) {
        ResultSet rs;
        Throwable th;
        String IdPersonaBS1 = "";
        String Query = "select PE.Per_ID, PE.Per_NombreFull, PD.Doc_Numero from Persona_Documento PD\nINNER JOIN Persona PE ON ( PE.zDoc_ID= PD.Doc_ID)\nWHERE PD.Doc_Numero = '" + noDocumento + "'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        try {
            rs = Cs.traerRs(Query);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (rs.next()) {
                    IdPersonaBS1 = rs.getString("Per_ID");
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
                Cs.cerrarConexionBd();
                return IdPersonaBS1;
            } finally {
            }
        } finally {
        }
    }

    private void HacerLlamadoTvBS1(String iDTvGuid, String idConsultorioMedicoBS1, String idPersonaLlamarBS1) {
        String QueryActualizar = "update Televisor set Tel_Fecha = getdate() where zCMed_ID = '" + idConsultorioMedicoBS1 + "' and zPer_ID ='" + idPersonaLlamarBS1 + "'";
        String QueryInsertar = "insert Televisor (Tel_ID ,Tel_Fecha,zCMed_ID,zPer_ID) values('" + iDTvGuid + "',GETDATE(),'" + idConsultorioMedicoBS1 + "','" + idPersonaLlamarBS1 + "')";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        int Actualizado = Cs.ejecutaSQLUpdate(QueryActualizar);
        if (Actualizado == 0) {
            Cs.ejecutarSQL(QueryInsertar);
        }
        Cs.cerrarConexionBd();
    }

    private Boolean liberarPacienteAgendaBS1(String idLaboratorio) {
        boolean Liberado = false;
        String QueryActualizar = "update Laboratorio set EstadoAtencion= '2', F_FinalAtencion= GETDATE() where Lab_ID='" + idLaboratorio + "'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        int Actualizado = Cs.ejecutaSQLUpdate(QueryActualizar);
        if (Actualizado > 0) {
            Liberado = true;
        }
        Cs.cerrarConexionBd();
        return Boolean.valueOf(Liberado);
    }

    private void EnviarTomaBS1(String idRecepcion) {
        UUID idToma = UUID.randomUUID();
        if (!this.JTFIdRecepcion.getText().equals("")) {
            String Query = "SELECT\n     \n     `ingreso`.`NumeroHcBs1`\n    , `g_procedimientoxcnt`.`codigocnt`\n    , 1 AS realizado\nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\n    INNER JOIN `l_detallerecepcion` \n        ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `g_procedimientoxcnt` \n        ON (`g_procedimientoxcnt`.`idprocedimiento` = `l_detallerecepcion`.`Id_Procedim`)\n        WHERE `l_recepcion`.`Id`='" + this.JTFIdRecepcion.getText() + "'";
            ConsultasMySQL Cm = new ConsultasMySQL();
            ConsultasSqlServer Cs = new ConsultasSqlServer();
            try {
                ResultSet rs = Cm.traerRs(Query);
                Throwable th = null;
                while (rs.next()) {
                    try {
                        try {
                            String SqlValidarSiExiste = "select COUNT(LT.zEpa_ID) from Laboratorio_TomaMuestra LT\nwhere LT.zEpa_ID='" + rs.getString("codigocnt") + "' and LT.zHcli_ID ='" + rs.getString("NumeroHcBs1") + "'";
                            int dato = Integer.valueOf(Cs.traerDato(SqlValidarSiExiste)).intValue();
                            if (dato == 0) {
                                String QueryInsertBS1 = "INSERT INTO Laboratorio_TomaMuestra (Toma_ID,Toma_Fecha,Toma_Realizado,Toma_Respon,zHcli_ID,zEpa_ID,Toma_Observ) \nVALUES('" + idToma + "', GETDATE(), '" + rs.getString("realizado") + "', '" + Principal.usuarioSistemaDTO.getNombreUsuario() + "','" + rs.getString("NumeroHcBs1") + "','" + rs.getString("codigocnt") + "','" + this.txtObservaciones.getText() + "')";
                                Cs.ejecutarSQL(QueryInsertBS1);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th2;
                        }
                    } finally {
                    }
                }
                if (rs != null) {
                    if (0 != 0) {
                        try {
                            rs.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    } else {
                        rs.close();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFAgendaTaquilla.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            Cm.cerrarConexionBd();
            Cs.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1MouseClicked(MouseEvent evt) {
        UUID uuid = UUID.randomUUID();
        System.out.println("UUID=" + uuid.toString());
        String idPersonaLLamarBS1 = RecuperarIdPersonaPorAtenderBS1(String.valueOf(this.frmPersona.txtIdentificacion.getText()));
        HacerLlamadoTvBS1(String.valueOf(uuid), this.idConsultorioMedicoBS1, idPersonaLLamarBS1);
    }

    private boolean LiberarPacienteNoRepuestaLlamado(String idLaboratorio) {
        boolean liberado = false;
        String liberarXnoLlamado = "update Laboratorio set EstadoAtencion = 0,F_InicioAtencion =NULL, F_FinalAtencion =null\nwhere Lab_ID = '" + idLaboratorio + "'";
        ConsultasSqlServer Cs = new ConsultasSqlServer();
        int Actualizado = Cs.ejecutaSQLUpdate(liberarXnoLlamado);
        if (Actualizado > 0) {
            liberado = true;
        }
        Cs.cerrarConexionBd();
        return liberado;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2MouseClicked(MouseEvent evt) {
        String idLaboratorio = RecuperarIdLaboratorioBS1(String.valueOf(this.idIngreso));
        boolean liberado = LiberarPacienteNoRepuestaLlamado(idLaboratorio);
        if (liberado) {
            JOptionPane.showMessageDialog((Component) null, "se ha liberado el usuario a la agenda\npor no respuesta al llamado");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
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
                rs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscarRecepcionBs1(String IdOrden) {
        if (this.frmPersona.getIdPersona() != null && Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.") && !IdOrden.equals("0")) {
            try {
                this.xsql = "SELECT\n  `l_recepcion`.`Id`\nFROM\n    `f_ordenes`\n    INNER JOIN `ingreso` \n        ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `l_recepcion` \n        ON (`l_recepcion`.`Id_OrdenFacturac` = `f_ordenes`.`Id`)\nWHERE (`ingreso`.`NumeroHcBs1` ='" + IdOrden + "'AND ingreso.`FechaIngreso`='" + this.metodos.formatoAMD1.format(this.metodos.getFechaActual()) + "');";
                ResultSet rs = this.consultas.traerRs(this.xsql);
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
                rs.close();
                this.consultas.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mBuscarNRecepcion() {
        if (this.frmPersona.getIdPersona() != null) {
            if (!this.JTFFNRecepcion.getText().isEmpty()) {
                try {
                    this.xsql = "SELECT Id , Id_Paciente, CONCAT(DATE_FORMAT(`FechaRecep`,'%Y%m%d'),LPAD(`consecutivo`,3,0)) consecutivo  FROM l_recepcion WHERE (Id ='" + this.JTFFNRecepcion.getText() + "' AND Id_Paciente ='" + this.frmPersona.getIdPersona() + "')";
                    ResultSet rs = this.consultas.traerRs(this.xsql);
                    if (rs.next()) {
                        rs.first();
                        this.xidnrecepcion = rs.getString(1);
                        this.xtipog = true;
                        if (getName().equals("Recepcion")) {
                            this.JTFIdRecepcion.setText(this.xidnrecepcion);
                            if (Principal.informacionIps.getAplicaConsecutivoDiarioLaboratorio().booleanValue()) {
                                this.JTFConsecutivo.setText(this.xidnrecepcion);
                            } else {
                                this.JTFConsecutivo.setText(rs.getString("consecutivo"));
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
                        this.JTFFNRecepcion.requestFocus();
                    }
                    rs.close();
                    this.consultas.cerrarConexionBd();
                    return;
                } catch (SQLException ex) {
                    Logger.getLogger(RecepcionAutoBienestarSalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "El N° Recepcion no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFNRecepcion.requestFocus();
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
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO CENTRAL DE REFERENCIA S.A.S.")) {
            crear_ArchivosPlanos xc = new crear_ArchivosPlanos();
            xc.mCrear_Planos("Z:\\", this.xidnrecepcion, this.xTipo);
        } else {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.")) {
                mGrabarInterfaz_Fix();
                return;
            }
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                mCargar_Interfaz();
            } else if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                crear_ArchivosPlanos xc2 = new crear_ArchivosPlanos();
                xc2.mCrear_Planos(this.metodos.mRutaSoporte("Infinity"), this.xidnrecepcion, this.xTipo);
            }
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
