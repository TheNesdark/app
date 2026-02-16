package com.genoma.plus.controller.integracion_simedis;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import com.genoma.plus.dto.integracion_simedis.DGLEnvioResultadosDTO;
import com.genoma.plus.dto.integracion_simedis.DGLResponseDTO;
import com.genoma.plus.dto.integracion_simedis.SifasOrdenDTO;
import com.genoma.plus.jpa.projection.RetransmisionProjection;
import com.genoma.plus.jpa.service.ILDetalleRecepcionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/JIFRetransmision.class */
public class JIFRetransmision extends JInternalFrame {
    private String[] xidSede;
    private LaboratorioDAO xImplLabotaorio;
    private DefaultTableModel xmodelo;
    private Object[] datos;
    private String urlResultados;
    private ButtonGroup JBGEstados;
    private JButton JBRetransmitir;
    private JComboBox<String> JCBSede;
    private JCheckBox JCHFiltroSede;
    private JCheckBox JCHSeleccionar;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLContRecepcion;
    private JRadioButton JRBPendientes;
    private JRadioButton JRBTodos;
    private JRadioButton JRBTransmitidos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFFiltro;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private HashMap<Long, Long> listaProcedimiento = new HashMap<>();
    private RestTemplate restTemplate = new RestTemplate();
    private ILDetalleRecepcionService xILDetalleRecepcionService = (ILDetalleRecepcionService) Principal.contexto.getBean(ILDetalleRecepcionService.class);
    private List<String> estadoEnviado = new ArrayList();
    HashSet hs = new HashSet();
    HashSet hs2 = new HashSet();

    public JIFRetransmision() {
        initComponents();
        springStart();
        this.urlResultados = Principal.informacionIps.getEndPointGenomaEnvioOrdenExamen() + "/rest/v1.0/ordenexamen/envia";
        this.estadoEnviado.add("0");
        nuevo();
    }

    private void springStart() {
        this.xImplLabotaorio = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    public void nuevo() {
        this.JLContRecepcion.setText("0");
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        crearModeloTabla();
    }

    public void buscar() {
        cargarModeloTabla();
    }

    private void llenarSede() {
        this.JCBSede.removeAllItems();
        this.xidSede = this.xconsulta.llenarCombo("SELECT gs.Id, gs.Nbre FROM g_sedes gs where gs.Estado=1", this.xidSede, this.JCBSede);
        this.JCBSede.setSelectedIndex(-1);
        if (this.xidSede != null && this.xidSede.length != 0) {
            this.JCBSede.setSelectedItem(Principal.sedeUsuarioSeleccionadaDTO.getNombre());
        }
        this.xconsulta.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "IdRecepcion", "OrdenExterna", "Fecha Recepcion", "Tipo Identificacion", "No. Documento", "Paciente", "IdProcedimiento", "Procedimiento", "Protocolo", "Resultado", "Unidad", "Valor Referencia1", "Valor Referencia2", "Profesiona Valida", "Sede", "Enviado?", "IdProtocoloxProcedimiento"}) { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.1
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
    }

    private void cargarModeloTabla() {
        List<RetransmisionProjection> lista;
        crearModeloTabla();
        if (this.JCHFiltroSede.isSelected() && this.JCBSede.getSelectedIndex() != -1) {
            lista = this.xILDetalleRecepcionService.listarResultadosParaRestransmitir(this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()), this.estadoEnviado, Long.valueOf(this.xidSede[this.JCBSede.getSelectedIndex()].toString()), this.JTFFiltro.getText());
        } else {
            lista = this.xILDetalleRecepcionService.listarResultadosParaRestransmitir(this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()), this.estadoEnviado, 0L, this.JTFFiltro.getText());
        }
        this.hs.clear();
        lista.forEach(e -> {
            this.xmodelo.addRow(this.datos);
            this.xmodelo.setValueAt(false, this.JTDetalle.getRowCount() - 1, 0);
            this.xmodelo.setValueAt(e.getIdRecepcion(), this.JTDetalle.getRowCount() - 1, 1);
            this.xmodelo.setValueAt(e.getOrdenExterna(), this.JTDetalle.getRowCount() - 1, 2);
            this.xmodelo.setValueAt(e.getFechaRecep(), this.JTDetalle.getRowCount() - 1, 3);
            this.xmodelo.setValueAt(e.getTipoIdentificacion(), this.JTDetalle.getRowCount() - 1, 4);
            this.xmodelo.setValueAt(e.getNoDocumento(), this.JTDetalle.getRowCount() - 1, 5);
            this.xmodelo.setValueAt(e.getUsuario(), this.JTDetalle.getRowCount() - 1, 6);
            this.xmodelo.setValueAt(e.getCup(), this.JTDetalle.getRowCount() - 1, 7);
            this.xmodelo.setValueAt(e.getProcedimiento(), this.JTDetalle.getRowCount() - 1, 8);
            this.xmodelo.setValueAt(e.getProtocolo(), this.JTDetalle.getRowCount() - 1, 9);
            this.xmodelo.setValueAt(e.getVrNumerico(), this.JTDetalle.getRowCount() - 1, 10);
            this.xmodelo.setValueAt(e.getUnidad(), this.JTDetalle.getRowCount() - 1, 11);
            this.xmodelo.setValueAt(e.getVReferencia1(), this.JTDetalle.getRowCount() - 1, 12);
            this.xmodelo.setValueAt(e.getVReferencia2(), this.JTDetalle.getRowCount() - 1, 13);
            this.xmodelo.setValueAt(e.getProfesionaV(), this.JTDetalle.getRowCount() - 1, 14);
            this.xmodelo.setValueAt(e.getSede(), this.JTDetalle.getRowCount() - 1, 15);
            this.xmodelo.setValueAt(Boolean.valueOf(e.getEnviado()), this.JTDetalle.getRowCount() - 1, 16);
            this.xmodelo.setValueAt(e.getIdProtocolProcedim(), this.JTDetalle.getRowCount() - 1, 17);
            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            this.hs.add(e.getIdRecepcion());
        });
        this.JLContRecepcion.setText(this.hs.size() + "");
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/integracion_simedis/JIFRetransmision$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (!Boolean.valueOf(table.getValueAt(row, 16).toString()).booleanValue()) {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(102, 255, 102));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void transmitirResultado() {
        this.hs2.clear();
        switch (Principal.informacionIps.getNombreIps()) {
            case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
            case "CLINICA SAN FRANCISCO S.A.":
            case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
            case "CLINICA SANTA CLARA SAS":
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH":
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 0).toString()).booleanValue()) {
                        this.hs2.add(this.xmodelo.getValueAt(x, 1).toString());
                    }
                }
                this.hs2.forEach(e -> {
                    this.listaProcedimiento = new HashMap<>();
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        if (e.equals(this.xmodelo.getValueAt(x2, 1).toString()) && Boolean.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).booleanValue()) {
                            Long procedimientoId = Long.valueOf(this.xmodelo.getValueAt(x2, 7).toString());
                            System.out.println("CODIGO PROCEDIMIENTO: " + procedimientoId);
                            if (!this.listaProcedimiento.containsKey(procedimientoId)) {
                                System.out.println("AGREGA EL CODIGO AL MAP: " + procedimientoId + " VALUE: " + Long.valueOf(this.xmodelo.getValueAt(x2, 1).toString()));
                                this.listaProcedimiento.put(procedimientoId, Long.valueOf(this.xmodelo.getValueAt(x2, 1).toString()));
                            }
                        }
                    }
                    switch (Principal.informacionIps.getNombreIps()) {
                        case "HOSPITAL SAN VICENTE DE PAUL":
                        case "EMPRESA SOCIAL DEL ESTADO HOSPITAL NAZARETH":
                        case "CLINICA SANTA CLARA SAS":
                            mEjecutaTrasferenciaSIFAS(this.listaProcedimiento);
                            break;
                        case "E.S.E. HOSPITAL SAN VICENTE DE PAUL":
                        case "CLINICA SAN FRANCISCO S.A.":
                        case "EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO":
                            TransmisionXML(this.listaProcedimiento);
                            break;
                    }
                });
                cargarModeloTabla();
                break;
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS":
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA":
            case "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE":
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x2, 0).toString()).booleanValue()) {
                        mEjecutaTrasferenciaCNT(Long.valueOf(this.xmodelo.getValueAt(x2, 1).toString()), Long.valueOf(this.xmodelo.getValueAt(x2, 17).toString()));
                    }
                }
                cargarModeloTabla();
                break;
            default:
                JOptionPane.showInternalMessageDialog(this, "Esta funcion no aplica para esta institucion", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                break;
        }
    }

    private void mEjecutaTrasferenciaCNT(Long idOrden, Long idProtocolo) {
        String sql;
        try {
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE")) {
                sql = "SELECT\n   ingreso.`NoAutorizacion`\n , l_resultados.`FechaResult`\n , g_persona.`NoDocumento`\n , `f_itemordenesproced`.`NAutorizacion`\n , `l_protocolos`.`Nbre` AS protocolo \n , l_protocoloxprocedimiento.`Id` AS idprotocoloxprocedimiento \n , `l_detalleresultado`.`VrNumerico`\n , l_detalleresultado.`VReferencia1` AS VrMin\n , l_detalleresultado.`VReferencia2` AS VrMax\n , `l_detalleresultado`.`Unidad`\n , `l_detalleresultado`.`Observacion` \n , g_usuario_sist.`Login`\n , IF(`l_detalleresultado`.`Alterado`='0','N', 'S') AS Alterado  , `l_resultados`.`Id` AS idR  \n , l_detalleresultado.`Enviado`\n , f_itemordenesproced.`codigoEncabezadoOrdenBs1`\n , `f_itemordenesproced`.`codigoEnvioBs1`\n , `l_detalleresultado`.`Id_Procedimiento`\n , `l_protocolos`.`Id` AS idProtocolo \n  FROM \n `f_itemordenesproced`\n INNER JOIN `f_ordenes` \n     ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n      INNER JOIN `ingreso` \n     ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`)\n INNER JOIN `l_recepcion` \n     ON (`l_recepcion`.`Id` = `f_ordenes`.`Id_OrdenRecep`)\n INNER JOIN `l_resultados` \n     ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n INNER JOIN `g_persona` \n     ON (`l_recepcion`.`Id_Paciente` = `g_persona`.`Id`)\n INNER JOIN `l_detalleresultado` \n     ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n INNER JOIN `profesional1` \n     ON (`l_resultados`.`Id_Profesional` = `profesional1`.`Id_Persona`)\n     INNER JOIN `g_usuario_sist`\n     ON (  profesional1.`Id_Persona`=g_usuario_sist.`Id_Persona`)\n INNER JOIN `l_protocoloxprocedimiento` \n     ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n AND f_itemordenesproced.`Id_Procedimiento`=l_protocoloxprocedimiento.`Id_Procedim`\n INNER JOIN `l_protocolos` \n     ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n     WHERE (`f_ordenes`.`Estado` =0\n  AND `l_recepcion`.`Estado` =0\n  AND `l_recepcion`.`Id` =" + idOrden + " \n  AND `l_detalleresultado`.`Enviado` = 0 \n  AND `l_protocoloxprocedimiento`.`Id` =" + idProtocolo + " )\n  GROUP BY l_protocolos.`Id`";
            } else {
                sql = "SELECT\n   ingreso.`NoAutorizacion`\n , l_resultados.`FechaResult`\n , g_persona.`NoDocumento`\n , `f_itemordenesproced`.`NAutorizacion`\n , `l_protocolos`.`Nbre` AS protocolo \n , l_protocoloxprocedimiento.`Id` AS idprotocoloxprocedimiento \n , `l_detalleresultado`.`VrNumerico`\n , l_detalleresultado.`VReferencia1` AS VrMin\n , l_detalleresultado.`VReferencia2` AS VrMax\n , `l_detalleresultado`.`Unidad`\n , `l_detalleresultado`.`Observacion` \n , g_usuario_sist.`Login`\n , IF(`l_detalleresultado`.`Alterado`='0','N', 'S') AS Alterado  , `l_resultados`.`Id` AS idR  \n , l_detalleresultado.`Enviado`\n , f_itemordenesproced.`codigoEncabezadoOrdenBs1`\n , `f_itemordenesproced`.`codigoEnvioBs1`\n , `l_detalleresultado`.`Id_Procedimiento`\n , `l_protocolos`.`Id` AS idProtocolo \n `f_itemordenesproced`\n INNER JOIN `f_ordenes` \n     ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`)\n      INNER JOIN `ingreso` \n     ON (`ingreso`.`Id` = `f_ordenes`.`Id_Ingreso`)\n INNER JOIN `l_recepcion` \n     ON (`l_recepcion`.`Id` = `f_ordenes`.`Id_OrdenRecep`)\n INNER JOIN `l_resultados` \n     ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n INNER JOIN `g_persona` \n     ON (`l_recepcion`.`Id_Paciente` = `g_persona`.`Id`)\n INNER JOIN `l_detalleresultado` \n     ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n INNER JOIN `profesional1` \n     ON (`l_resultados`.`Id_Profesional` = `profesional1`.`Id_Persona`)\n     INNER JOIN `g_usuario_sist`\n     ON (  profesional1.`Id_Persona`=g_usuario_sist.`Id_Persona`)\n INNER JOIN `l_protocoloxprocedimiento` \n     ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n AND f_itemordenesproced.`Id_Procedimiento`=l_protocoloxprocedimiento.`Id_Procedim`\n INNER JOIN `l_protocolos` \n     ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n     WHERE (`f_ordenes`.`Estado` =0\n  AND `l_recepcion`.`Estado` =0\n  AND `l_recepcion`.`Id` =" + idOrden + " \n  AND `l_detalleresultado`.`Enviado` = 0 \n  AND `l_protocoloxprocedimiento`.`Id` =" + idProtocolo + " )\n  GROUP BY l_protocolos.`Id`";
            }
            System.out.println("RCNT" + sql);
            ResultSet rs = this.xconsulta.getResultSet(sql);
            if (rs.next()) {
                rs.first();
                if (Principal.informacionIps.getIdTipoIdentificacion().equals("NI") && Principal.informacionIps.getIdentificacion().equals("891408918")) {
                    com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                    laboratorioDAOI.actualizarResultadoCNT2(rs.getString("codigoEncabezadoOrdenBs1"), rs.getString("NoDocumento"), rs.getString("NAutorizacion"), rs.getString("protocolo"), rs.getString("idProtocolo"), rs.getString("VrNumerico"), rs.getString("VrMin"), rs.getString("VrMax"), rs.getString("Unidad"), rs.getString("Observacion"), rs.getString("Enviado"), rs.getString("Login"), rs.getString("idR"), rs.getString("Alterado"), idProtocolo, "LABO_INTER_BIOSYSTEM");
                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LA MISERICORDIA DE CALARCA")) {
                    com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI2 = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                    laboratorioDAOI2.actualizarResultadoCNT2(rs.getString("codigoEncabezadoOrdenBs1"), rs.getString("NoDocumento"), rs.getString("NAutorizacion"), rs.getString("protocolo"), rs.getString("idprotocoloxprocedimiento"), rs.getString("VrNumerico"), rs.getString("VrMin"), rs.getString("VrMax"), rs.getString("Unidad"), rs.getString("Observacion"), rs.getString("Enviado"), rs.getString("Login"), rs.getString("idR"), rs.getString("Alterado"), idProtocolo, "LABO_INTER_BIOSYSTEM");
                } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL CESAR URIBE PIEDRAHITA")) {
                    com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI3 = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
                    laboratorioDAOI3.actualizarResultadoCNTBiomed(rs.getString("NoAutorizacion"), rs.getString("NoDocumento"), rs.getString("NAutorizacion"), rs.getString("protocolo"), rs.getString("idprotocoloxprocedimiento"), rs.getString("VrNumerico"), rs.getString("VrMin"), rs.getString("VrMax"), rs.getString("Unidad"), rs.getString("Observacion"), rs.getString("Enviado"), rs.getString("Login"), rs.getString("Alterado"), rs.getString("idR"), idProtocolo, "LABO_INTER_ROCHE");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFRetransmision.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mEjecutaTrasferenciaSIFAS(Map<Long, Long> listaProcedimiento) {
        try {
            System.out.println("Ejecuta transferencia resultado SIFAS");
            System.out.println("this.urlResultados-->" + this.urlResultados);
            for (Map.Entry<Long, Long> entrada : listaProcedimiento.entrySet()) {
                SifasOrdenDTO e = new SifasOrdenDTO();
                e.setIdRecepcion(entrada.getValue());
                e.setIdProcedimiento(entrada.getKey());
                String result = (String) this.restTemplate.postForObject(this.urlResultados, e, String.class, new Object[0]);
                System.out.println("result sifas-->" + result);
                if (result.equals("202 ACCEPTED")) {
                    this.xImplLabotaorio.updateDatelleResultadoEnviado(Integer.valueOf(e.getIdRecepcion().toString()).intValue(), e.getIdProcedimiento().longValue());
                }
            }
        } catch (ResourceAccessException e2) {
            JOptionPane.showInternalMessageDialog(this, e2, "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void TransmisionXML(Map<Long, Long> listaProcedimiento) {
        for (Map.Entry<Long, Long> entrada : listaProcedimiento.entrySet()) {
            System.out.println("Entra al for: clave: " + entrada.getKey() + " Valor: " + entrada.getValue());
            String url = Principal.informacionIps.getEndPointGenomaEnvioOrdenExamen();
            System.out.println("Url: " + url);
            new ArrayList();
            com.genoma.plus.dao.integracion_simedis.LaboratorioDAO laboratorioDAOI = new com.genoma.plus.dao.impl.integracion_simedis.LaboratorioDAOImpl();
            List<DGLEnvioResultadosDTO> e = laboratorioDAOI.enviarDetalleResultadoDinamica(entrada.getKey(), entrada.getValue());
            System.out.println("tamaño de la lista: " + e.size());
            DGLResponseDTO response = (DGLResponseDTO) this.restTemplate.postForObject(url, e, DGLResponseDTO.class, new Object[0]);
            System.out.println("Mensaje: " + response.getMensaje() + " Exito: " + response.getExito() + " Error: " + response.getMensajeInterno());
            if (Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN VICENTE DE PAUL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO UNIVERSITARIA DEL ATLANTICO")) {
                if (response.getExito().booleanValue()) {
                    if (!e.isEmpty()) {
                        for (int i = 0; i < e.size(); i++) {
                            laboratorioDAOI.validacionResultadosDinamica(e.get(i).getConsecutivoOrden(), e.get(i).getExamenCodigo());
                        }
                    }
                    this.xImplLabotaorio.updateDatelleResultadoEnviado(Integer.valueOf(entrada.getValue().toString()).intValue(), entrada.getKey().longValue());
                    JOptionPane.showInternalMessageDialog(this, response.getMensaje(), "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } else {
                    JOptionPane.showInternalMessageDialog(this, response.getMensajeInterno(), "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                }
            }
        }
    }

    private void mSeleccionar(String xRecepcion, Boolean xestado) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (this.xmodelo.getValueAt(x, 1).toString().equals(xRecepcion)) {
                this.xmodelo.setValueAt(xestado, x, 0);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEstados = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBSede = new JComboBox<>();
        this.JCHFiltroSede = new JCheckBox();
        this.JCHSeleccionar = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBRetransmitir = new JButton();
        this.JRBPendientes = new JRadioButton();
        this.JRBTransmitidos = new JRadioButton();
        this.JRBTodos = new JRadioButton();
        this.JLContRecepcion = new JLabel();
        this.JTFFiltro = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("RETRANSMISION DE RESULTADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifretransmision");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACÍON", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.setEnabled(false);
        this.JCBSede.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.2
            public void actionPerformed(ActionEvent evt) {
                JIFRetransmision.this.JCBSedeActionPerformed(evt);
            }
        });
        this.JCHFiltroSede.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroSede.setForeground(Color.blue);
        this.JCHFiltroSede.setText("Filtro por Sede");
        this.JCHFiltroSede.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.3
            public void actionPerformed(ActionEvent evt) {
                JIFRetransmision.this.JCHFiltroSedeActionPerformed(evt);
            }
        });
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setForeground(Color.blue);
        this.JCHSeleccionar.setText("Seleccionar Todo");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.4
            public void actionPerformed(ActionEvent evt) {
                JIFRetransmision.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 114, -2).addGap(18, 18, 18).addComponent(this.JDFechaF, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSede, -2, 277, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroSede).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addComponent(this.JCHSeleccionar).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 0).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltroSede).addComponent(this.JCHSeleccionar)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2)).addComponent(this.JCBSede, -2, 50, -2))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.5
            public void mouseClicked(MouseEvent evt) {
                JIFRetransmision.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBRetransmitir.setFont(new Font("Arial", 1, 14));
        this.JBRetransmitir.setForeground(Color.black);
        this.JBRetransmitir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Copiar.png")));
        this.JBRetransmitir.setText("Retransmitir");
        this.JBRetransmitir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.6
            public void actionPerformed(ActionEvent evt) {
                JIFRetransmision.this.JBRetransmitirActionPerformed(evt);
            }
        });
        this.JBGEstados.add(this.JRBPendientes);
        this.JRBPendientes.setFont(new Font("Arial", 1, 12));
        this.JRBPendientes.setSelected(true);
        this.JRBPendientes.setText("Pendientes");
        this.JRBPendientes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.7
            public void actionPerformed(ActionEvent evt) {
                JIFRetransmision.this.JRBPendientesActionPerformed(evt);
            }
        });
        this.JBGEstados.add(this.JRBTransmitidos);
        this.JRBTransmitidos.setFont(new Font("Arial", 1, 12));
        this.JRBTransmitidos.setText("Transmitidos");
        this.JRBTransmitidos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.8
            public void actionPerformed(ActionEvent evt) {
                JIFRetransmision.this.JRBTransmitidosActionPerformed(evt);
            }
        });
        this.JBGEstados.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.9
            public void actionPerformed(ActionEvent evt) {
                JIFRetransmision.this.JRBTodosActionPerformed(evt);
            }
        });
        this.JLContRecepcion.setFont(new Font("Arial", 1, 12));
        this.JLContRecepcion.setForeground(Color.blue);
        this.JLContRecepcion.setHorizontalAlignment(4);
        this.JLContRecepcion.setText("0");
        this.JLContRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant. Recepciones", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFiltro.setFont(new Font("Arial", 1, 12));
        this.JTFFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Recepcion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.integracion_simedis.JIFRetransmision.10
            public void keyPressed(KeyEvent evt) {
                JIFRetransmision.this.JTFFiltroKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JRBPendientes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBTransmitidos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBTodos)).addGroup(layout.createSequentialGroup().addComponent(this.JTFFiltro, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBRetransmitir, -2, 510, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLContRecepcion, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 282, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPendientes).addComponent(this.JRBTodos).addComponent(this.JRBTransmitidos)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLContRecepcion, -1, -1, 32767).addComponent(this.JBRetransmitir, -1, 50, 32767).addComponent(this.JTFFiltro)).addGap(16, 16, 16)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroSedeActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroSede.isSelected()) {
            this.JCBSede.setEnabled(true);
            llenarSede();
        } else {
            this.JCBSede.setEnabled(false);
            this.JCBSede.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBRetransmitirActionPerformed(ActionEvent evt) {
        transmitirResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            this.xmodelo.setValueAt(Boolean.valueOf(this.JCHSeleccionar.isSelected()), i, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPendientesActionPerformed(ActionEvent evt) {
        this.estadoEnviado.clear();
        this.estadoEnviado.add("0");
        cargarModeloTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTransmitidosActionPerformed(ActionEvent evt) {
        this.estadoEnviado.clear();
        this.estadoEnviado.add("1");
        cargarModeloTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.estadoEnviado.clear();
        this.estadoEnviado.add("0");
        this.estadoEnviado.add("1");
        cargarModeloTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getRowCount() != 0 && this.JTDetalle.getSelectedColumn() == 0) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).booleanValue()) {
                mSeleccionar(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString(), true);
            } else {
                mSeleccionar(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            cargarModeloTabla();
        }
    }
}
