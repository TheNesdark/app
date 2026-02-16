package Enfermeria;

import Acceso.Principal;
import Facturacion.Ingreso;
import General.Anular;
import General.BuscarPersona;
import General.ClaseImpresionInformes;
import General.JDAtencionesPreferenciales;
import General.Persona;
import Historia.JIFAgendaMedico_N;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenericoPanel;
import com.genoma.plus.controller.historia.JPTriageRespiratorio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/Atencion.class */
public class Atencion extends JInternalFrame {
    private String idAtencion;
    private String idCita;
    private String idHoraLlegada;
    private Long idTriage;
    private String[] listaClaseCita;
    private String sql;
    private claseEnfermeria claseEnf;
    public Persona frmPersona;
    public Ingreso frmIngreso;
    private JPTriageRespiratorio triageRespiratorio;
    private ButtonGroup JBGClasificacion;
    private JButton JBTEventoAdverso1;
    private JCheckBox JCHAplicaTestRespiratorio;
    private JCheckBox JCHEsAgendado;
    private JLabel JLBBAcostado;
    private JLabel JLBBPie;
    private JLabel JLBPBSentado;
    private JPanel JPIClasificacion;
    private JPanel JPIControl;
    private JPanel JPIFondo;
    private JPanel JPI_Triage;
    private JPanel JPI_TriageRespiratorio;
    private JPanel JPSignosVitales;
    private JScrollPane JSPMovitoConsulta;
    private JScrollPane JSPObservaciones;
    private JTabbedPane JTP_Triage;
    private JButton btnAgendaMedico;
    private JButton btnAmarillo;
    private JRadioButton btnControladoNo;
    private JRadioButton btnControladoSi;
    private JButton btnHistoriaE;
    private JButton btnNaranja;
    private JButton btnNegro;
    private JButton btnNotaCargo;
    private JButton btnRojo;
    private JButton btnVerde;
    public JComboBox cboClaseCita;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JSeparator jSeparator1;
    private JMenuItem mnAsignar;
    private JMenuItem mnDesistir;
    private JPopupMenu mnPopup;
    private JMenuItem mnSalir;
    private JPanel panelIngreso;
    private JPanel panelersona;
    public JFormattedTextField txtAtencion;
    public JFormattedTextField txtCita;
    public JTextFieldValidator txtFc;
    public JTextFieldValidator txtFr;
    public JFormattedTextField txtHorallegada;
    public JTextFieldValidator txtImc;
    public JFormattedTextField txtIngreso;
    private JTextPane txtMotivoConsulta;
    private JTextPane txtObservaciones;
    public JTextFieldValidator txtPeso;
    private JFormattedTextField txtPresionAcostadoD;
    private JFormattedTextField txtPresionAcostadoS;
    private JFormattedTextField txtPresionPieD;
    private JFormattedTextField txtPresionPieS;
    private JFormattedTextField txtPresionSentadoD;
    private JFormattedTextField txtPresionSentadoS;
    public JTextFieldValidator txtPs2;
    public JTextFieldValidator txtTalla;
    public JTextFieldValidator txtTemperatura;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int controlado = 0;
    private int clasificacion = -1;
    private int xesagendado = 0;
    private String idIngreso = "0";
    private String valorImc = "0.0";

    public Atencion(claseEnfermeria clase) {
        initComponents();
        this.claseEnf = clase;
        Principal.lblNo.setText("No. Triage");
        Principal.txtNo.setText("");
        cargarPanelUsuario();
        cargarPanelIngreso();
        cargarPanelTraigeRespiratorio();
        this.txtHorallegada.setValue(this.metodos.getFechaActual());
        this.txtHorallegada.setEnabled(true);
        this.JTP_Triage.setEnabledAt(1, false);
        if (Principal.informacionIps.getEsFpz().intValue() == 1) {
            this.frmIngreso.cboEmpresa.setEnabled(false);
            this.frmIngreso.cboContrato.setEnabled(false);
        }
        if (Principal.informacionIps.getAplicaTestRespiratorio().intValue() == -1) {
            this.JCHAplicaTestRespiratorio.setVisible(false);
            this.JTP_Triage.remove(1);
        }
    }

    private int getPresionSentadoS() {
        return Integer.parseInt(this.txtPresionSentadoS.getText());
    }

    private int getPresionSentadoD() {
        return Integer.parseInt(this.txtPresionSentadoD.getText());
    }

    private int getPresionPieS() {
        return Integer.parseInt(this.txtPresionPieS.getText());
    }

    private int getPresionPieD() {
        return Integer.parseInt(this.txtPresionPieD.getText());
    }

    private int getPresionAcostadoS() {
        return Integer.parseInt(this.txtPresionAcostadoS.getText());
    }

    private int getPresionAcostadoD() {
        return Integer.parseInt(this.txtPresionAcostadoD.getText());
    }

    private int getFc() {
        return Integer.parseInt(this.txtFc.getText());
    }

    private int getFr() {
        return Integer.parseInt(this.txtFr.getText());
    }

    private int getTemperatura() {
        return Integer.parseInt(this.txtTemperatura.getText());
    }

    private int getPs2() {
        return Integer.parseInt(this.txtPs2.getText());
    }

    private int getTalla() {
        int valor = 0;
        if (this.txtTalla.getText() != null && !this.txtTalla.getText().equals("") && Integer.parseInt(this.txtTalla.getText()) > 0) {
            valor = Integer.parseInt(this.txtTalla.getText());
        }
        return valor;
    }

    private double getPeso() {
        double valor = 0.0d;
        if (this.txtPeso.getText() != null && !this.txtPeso.getText().equals("") && Double.parseDouble(this.txtPeso.getText()) > 0.0d) {
            valor = Double.parseDouble(this.txtPeso.getText());
        }
        return valor;
    }

    public String getIdHoraLlegada() {
        return this.idHoraLlegada;
    }

    public String getNoAtencion() {
        return this.idAtencion;
    }

    public String getNoCita() {
        return this.idCita;
    }

    public String getNoIngreso() {
        return this.idIngreso;
    }

    public Long getNoTriage() {
        return this.idTriage;
    }

    public void setIdHoraLlegada(String id) {
        this.idHoraLlegada = id;
    }

    private void actualizarIngresoHoraLlegada() {
        if (getIdHoraLlegada() != null && !getIdHoraLlegada().isEmpty() && !getIdHoraLlegada().equals("0")) {
            this.sql = "UPDATE h_horallegada set Id_Ingreso='" + this.idIngreso + "', Atendido=1 WHERE id='" + this.idHoraLlegada + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            return;
        }
        String fecha = this.metodos.formatoAMD.format(this.frmIngreso.txtFecha.getDate()) + " " + this.metodos.pasarHora12a24(this.txtHorallegada.getText().toUpperCase());
        this.sql = "SELECT (MAX(Cardinal)+1) AS cardinal FROM h_horallegada WHERE (Id_Usuario ='" + this.frmPersona.getIdPersona() + "')";
        String cardinal = this.consultas.traerDato(this.sql);
        if (cardinal == null || cardinal.isEmpty()) {
            cardinal = "1";
        }
        this.consultas.cerrarConexionBd();
        this.sql = "INSERT INTO h_horallegada(Id_Usuario, Cardinal, Id_Empresa,  Id_Ingreso, Id_Estrato, Id_TipoAtencion, Fecha_Hora, Id_Sede, TipoAfiliacion, TipoContratacion, TipoCoberturaPlan, Atendido, UsuarioS, Fecha) VALUES('" + this.frmPersona.getIdPersona() + "','" + cardinal + "','" + this.frmIngreso.listConvenio.get(this.frmIngreso.cboEmpresa.getSelectedIndex()).getId() + "','" + this.idIngreso + "','" + this.frmIngreso.xidestrato[this.frmIngreso.cboEstrato1.getSelectedIndex()][0] + "','" + this.frmIngreso.cboTipoAtencion.getPopupTable().getValueAt(this.frmIngreso.cboTipoAtencion.getSelectedIndex(), 0).toString() + "','" + fecha.substring(0, 16) + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.frmIngreso.JCBTipoAfiliado.getSelectedItem().toString() + "','" + this.frmIngreso.JCB_TipoContratacion.getSelectedItem().toString() + "','" + this.frmIngreso.JCB_TipoCoberturaPlan.getSelectedItem().toString() + "','1','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void anular() {
        if (Principal.txtNo.getText() == null || Principal.txtNo.getText().equals("") || Principal.txtNo.getText().equals("0")) {
            this.metodos.mostrarMensaje("Por favor seleccione un número de Triage para Anular");
        } else {
            Anular frm = new Anular(null, true, "Atencion", 3);
            frm.setVisible(true);
        }
    }

    public void anularServicios(String motivo) {
        anularIngreso(motivo);
        anularCitaNP(motivo);
        anularTriage(motivo);
        anularAtencion(motivo);
        anularHoraLlegada();
        this.metodos.marcarEstado(1);
        this.metodos.mostrarMensaje("Triage Anulado");
    }

    private void anularAtencion(String motivo) {
        this.sql = "UPDATE h_atencion SET Estado='" + motivo + "' WHERE id='" + getNoAtencion() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void anularCitaNP(String motivo) {
        this.sql = "UPDATE c_citasnp SET Id_Anulada ='" + motivo + "' WHERE id='" + getNoCita() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void anularHoraLlegada() {
        this.sql = "UPDATE h_horallegada SET Id_Ingreso=0 AND Atendido=0 WHERE id='" + this.idHoraLlegada + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void anularTriage(String motivo) {
        this.sql = "UPDATE h_triage SET Estado='" + motivo + "' WHERE id='" + getNoTriage() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void anularIngreso(String motivo) {
        this.sql = "UPDATE ingreso SET Estado='" + motivo + "' WHERE id='" + getNoIngreso() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void buscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.frmPersona);
        frmBuscar.setVisible(true);
    }

    public void buscarIdHoraLLegadaIdIngreso(String id) {
        try {
            String xsql = "SELECT TIME(Fecha_Hora) AS Hora FROM baseserver.h_horallegada WHERE (Id_Ingreso='" + id + "')";
            ResultSet rs = this.consultas.traerRs(xsql);
            Throwable th = null;
            try {
                try {
                    if (rs.next()) {
                        this.txtHorallegada.setBackground(new Color(204, 0, 102));
                        this.txtHorallegada.setText(rs.getString(1));
                        this.txtHorallegada.setEnabled(false);
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
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void botonTriage() {
        this.btnRojo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnVerde.setIcon(new ImageIcon(getClass().getResource("")));
        this.btnNegro.setIcon(new ImageIcon(getClass().getResource("")));
        switch (this.clasificacion) {
            case 1:
                this.btnRojo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 2:
                this.btnNaranja.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 3:
                this.btnAmarillo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 4:
                this.btnVerde.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
            case 5:
                this.btnNegro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                break;
        }
    }

    private void cargarPanelUsuario() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(true);
        this.panelersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 980, 160);
        this.panelersona.add(this.frmPersona);
        this.panelersona.setVisible(true);
    }

    private void cargarPanelTraigeRespiratorio() {
        this.triageRespiratorio = new JPTriageRespiratorio(getNoTriage(), Long.valueOf(getNoIngreso()), "");
        this.triageRespiratorio.setBounds(1, 1, 1190, 310);
        this.JPI_TriageRespiratorio.add(this.triageRespiratorio);
        this.JPI_TriageRespiratorio.repaint();
    }

    private void cargarPanelIngreso() {
        this.frmIngreso = new Ingreso(this, "Atencion", "1");
        this.frmIngreso.setVisible(true);
        this.panelIngreso.setVisible(false);
        this.frmIngreso.setBounds(1, 1, 1190, 220);
        this.panelIngreso.add(this.frmIngreso);
        this.panelIngreso.setVisible(true);
        this.frmIngreso.cboTipoAtencion.setSelectedItem("AMBULATORIO");
        this.frmIngreso.cboEspecialidad.setSelectedItem("MEDICINA GENERAL");
        this.frmIngreso.cboOrigenIngreso.setSelectedItem("Consulta Externa o Programada");
        this.frmIngreso.xcopago = 0;
        this.frmIngreso.btnCModeradora.setSelected(true);
    }

    private void calcularImc() {
        if (this.txtTalla.getText() != null && this.txtPeso.getText() != null) {
            DecimalFormat formato = new DecimalFormat("00");
            double imc = (getPeso() / Math.pow(getTalla(), 2.0d)) * 10000.0d;
            this.txtImc.setText(String.valueOf(formato.format(imc)));
            return;
        }
        this.txtImc.setText("0.0");
    }

    public void cargarClaseCita(String idEspecial) {
        this.cboClaseCita.removeAllItems();
        this.listaClaseCita = this.consultas.llenarCombo("SELECT c_clasecita.Id, c_clasecita.Nbre FROM c_clasecita \nINNER JOIN `c_clasecita_tipoatencion` ON (`c_clasecita`.`Id`=c_clasecita_tipoatencion.`idClaseCita`)\nWHERE (Id_Especialidad ='" + idEspecial + "' AND c_clasecita_tipoatencion.`idTipoAtencion`='" + this.frmIngreso.cboTipoAtencion.getPopupTable().getValueAt(this.frmIngreso.cboTipoAtencion.getSelectedIndex(), 0).toString() + "' AND c_clasecita_tipoatencion.`Estado`=1 AND c_clasecita.Estado = 0) ORDER BY c_clasecita.Nbre ASC", this.listaClaseCita, this.cboClaseCita);
        this.consultas.cerrarConexionBd();
        if (this.cboClaseCita.getItemCount() > 0) {
            this.cboClaseCita.setSelectedIndex(-1);
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x03b4: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:54:0x03b4 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x03b8: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:56:0x03b8 */
    public void cargarTriage(Long id) {
        this.idTriage = id;
        try {
            try {
                this.sql = "SELECT g_usuario.NoHistoria, ingreso.Id AS Ingreso, h_triage.Id AS Triage, h_triage.TArtSentadoD, h_triage.TArtSentadoS, h_triage.TArtAcostadoD, h_triage.TArtAcostadoS, h_triage.TArtPieD, h_triage.TartPieS, h_triage.Clasificacion, h_triage.FechaTriage, h_triage.HoraTriage, h_triage.MotivoConsulta, h_triage.Observacion, h_triage.Estado, c_citasnp.Id AS Cita, c_clasecita.Nbre AS ClaseCita, h_horallegada.Fecha_Hora, h_atencion.Id AS Atencion, h_examenfisico.ControlTA, h_examenfisico.FCardiaca, h_examenfisico.FRespiratoria, h_examenfisico.Talla, h_examenfisico.Peso, h_examenfisico.IMC, h_examenfisico.Temperatura, h_examenfisico.Ps2, h_triage.Es_Agendado , ifnull(h_triage_respiratorio.id,0) as idTriageRespiratorio, h_triage.Id  as  idTriage  FROM ingreso INNER JOIN g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN h_triage ON (h_triage.IdIngreso = ingreso.Id) INNER JOIN c_citasnp ON (c_citasnp.Id_Usuario = g_usuario.Id_persona) INNER JOIN c_clasecita ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN baseserver.h_horallegada ON (h_horallegada.Id_Usuario = g_usuario.Id_persona) INNER JOIN h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN h_examenfisico ON (h_examenfisico.Id_Atencion = h_atencion.Id)  left join h_triage_respiratorio on (h_triage.Id=h_triage_respiratorio.idTriage) and (h_triage_respiratorio.estado=1) WHERE (ingreso.Id =" + this.idTriage + ")";
                ResultSet rs = this.consultas.traerRs(this.sql);
                Throwable th = null;
                if (rs.next()) {
                    this.txtPresionSentadoS.setText(rs.getString("TArtSentadoS"));
                    this.txtPresionSentadoD.setText(rs.getString("TArtSentadoD"));
                    this.txtPresionPieS.setText(rs.getString("TartPieS"));
                    this.txtPresionPieD.setText(rs.getString("TartPieD"));
                    this.txtPresionAcostadoS.setText(rs.getString("TArtAcostadoS"));
                    this.txtPresionAcostadoD.setText(rs.getString("TArtAcostadoD"));
                    this.txtFc.setText(rs.getString("FCardiaca"));
                    this.txtFr.setText(rs.getString("FRespiratoria"));
                    this.txtTemperatura.setText(rs.getString("Temperatura"));
                    this.txtPs2.setText(rs.getString("Ps2"));
                    this.txtTalla.setText(rs.getString("Talla"));
                    this.txtPeso.setText(rs.getString("Peso"));
                    this.txtImc.setText(rs.getString("IMC"));
                    this.cboClaseCita.setSelectedItem(rs.getString("ClaseCita"));
                    this.txtIngreso.setText(rs.getString(3));
                    if (rs.getInt("ControlTA") == 0) {
                        this.btnControladoSi.setSelected(true);
                    } else {
                        this.btnControladoNo.setSelected(true);
                    }
                    this.controlado = rs.getInt("ControlTA");
                    if (rs.getInt("Es_Agendado") == 0) {
                        this.JCHEsAgendado.setSelected(true);
                    } else {
                        this.JCHEsAgendado.setSelected(true);
                    }
                    this.xesagendado = rs.getInt("Es_Agendado");
                    this.txtMotivoConsulta.setText(rs.getString("MotivoConsulta"));
                    this.txtObservaciones.setText(rs.getString("Observacion"));
                    if (rs.getInt("Clasificacion") == 1) {
                        this.clasificacion = 1;
                        botonTriage();
                    } else if (rs.getInt("Clasificacion") == 2) {
                        this.clasificacion = 2;
                        botonTriage();
                    } else if (rs.getInt("Clasificacion") == 3) {
                        this.clasificacion = 3;
                        botonTriage();
                    } else if (rs.getInt("Clasificacion") == 4) {
                        this.clasificacion = 4;
                        botonTriage();
                    } else if (rs.getInt("Clasificacion") == 5) {
                        this.clasificacion = 5;
                        botonTriage();
                    }
                    if (rs.getString("Estado").equals("0")) {
                        this.metodos.marcarEstado(0);
                    } else {
                        this.metodos.marcarEstado(1);
                    }
                    this.idIngreso = rs.getString("Ingreso");
                    this.idAtencion = rs.getString("Atencion");
                    Principal.txtFecha.setText(rs.getString("FechaTriage"));
                    this.txtAtencion.setText(this.idAtencion);
                    this.txtIngreso.setText(this.idIngreso);
                    this.txtCita.setText(rs.getString("Cita"));
                    this.txtHorallegada.setText(this.metodos.formatoH12.format((Date) rs.getTime("Fecha_Hora")));
                    this.txtHorallegada.setEnabled(false);
                    if (rs.getLong("idTriageRespiratorio") != 0) {
                        this.triageRespiratorio.setIdTriage(Long.valueOf(rs.getLong("idTriage")));
                        this.triageRespiratorio.nuevo();
                        this.JCHAplicaTestRespiratorio.setSelected(true);
                        this.JTP_Triage.setEnabledAt(1, true);
                    }
                    cargarCitaNP();
                    cargarClaseCita();
                } else {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    this.sql = "SELECT  `Id` FROM `h_atencion` WHERE (`Id_Ingreso` ='" + this.idTriage + "') ";
                    ResultSet xrs = xct.traerRs(this.sql);
                    if (xrs.next()) {
                        xrs.first();
                        this.idAtencion = xrs.getString("Id");
                        this.txtAtencion.setText(this.idAtencion);
                        this.txtIngreso.setText("" + this.idTriage);
                    } else {
                        nuevoTriage();
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
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
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarCitaNP() {
        this.sql = "SELECT Id FROM c_citasnp WHERE (Id_ingreso ='" + getNoIngreso() + "')";
        this.idCita = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void cargarClaseCita() {
        this.sql = "SELECT c_clasecita.Nbre FROM c_citasnp INNER JOIN c_clasecita ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) WHERE (c_citasnp.Id_ingreso ='" + this.idIngreso + "')";
        String dato = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        this.cboClaseCita.setSelectedItem(dato);
    }

    public void consultarNAtencion() {
        if (!Principal.txtNo.getText().isEmpty()) {
            this.sql = "SELECT Id FROM h_atencion WHERE (Id_Ingreso='" + getNoIngreso() + "'AND Estado =0) ";
            this.txtAtencion.setText(this.consultas.traerDato(this.sql));
        } else {
            this.txtAtencion.setText((String) null);
        }
        this.consultas.cerrarConexionBd();
    }

    public void cargarCitaNp() {
        try {
            this.sql = "SELECT c_citasnp.Id, c_clasecita.Nbre FROM baseserver.c_citasnp INNER JOIN baseserver.c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) WHERE (c_citasnp.Id_ingreso ='" + getNoIngreso() + "')";
            ResultSet rs = this.consultas.traerRs(this.sql);
            Throwable th = null;
            try {
                if (rs.next()) {
                    this.txtCita.setText(rs.getString(1));
                    this.cboClaseCita.setSelectedItem(rs.getString(2));
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
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void grabar() {
        if (Principal.txtNo.getText().isEmpty() && this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && validarDatos() == 1 && this.frmPersona.validarDatos(0) == 1 && this.frmIngreso.getValidarComponentes() == 1 && validarCompHoraLlegada()) {
            if (Principal.informacionGeneralPrincipalDTO.getAplicaAtencionPreferencial().booleanValue()) {
                JDAtencionesPreferenciales xjdatencion = new JDAtencionesPreferenciales(null, true, this);
                xjdatencion.setVisible(true);
            }
            this.frmPersona.grabar();
            this.frmIngreso.grabar(this.frmPersona.IdPersona);
            this.idIngreso = this.frmIngreso.getIdIngreso();
            this.txtIngreso.setText(this.idIngreso);
            grabarTriage();
            if (this.JCHAplicaTestRespiratorio.isSelected()) {
                this.triageRespiratorio.setIdTriage(this.idTriage);
                this.triageRespiratorio.setIdIngreso(Long.valueOf(this.idIngreso));
                this.triageRespiratorio.grabar();
            }
            grabarCita();
            grabarAtencionHc();
            grabarExamenFisico();
            actualizarIngresoHoraLlegada();
            this.frmIngreso.mVerificaCausaExterna();
            imprimirTriage();
            this.metodos.mostrarMensaje("Ok Triage Grabado");
        }
    }

    private void grabarCita() {
        this.sql = "INSERT INTO c_citasnp (Id_Profesional, Id_Especialidad, Id_Usuario, Id_EmpresaCont, Id_ClaseCita, Fecha_Cita, HoraInicial, Id_ingreso, Fecha, UsuarioS, Id_Sede) VALUES ('" + this.frmIngreso.getIdProfesional() + "','" + this.frmIngreso.getIdEspecialidad() + "','" + this.frmPersona.getIdPersona() + "','" + this.frmIngreso.getIdEmpresa() + "','" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()] + "','" + this.metodos.formatoAMD.format(this.frmIngreso.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.frmIngreso.txtHora.getValue()) + "','" + this.idIngreso + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "')";
        this.idCita = this.consultas.ejecutarSQLId(this.sql);
        this.txtCita.setText(this.idCita);
        this.consultas.cerrarConexionBd();
        mGrabar_Facturacion();
    }

    private void mGrabar_Facturacion() {
        this.sql = "SELECT MetodoFact \n FROM c_citasnp   \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n WHERE (c_citasnp.Id ='" + this.idCita + "')";
        String MetodoFact = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        switch (MetodoFact) {
            case "0":
                this.sql = "INSERT INTO f_ordenes( Id_Ingreso , Id_TipoServicio , FechaOrden , HoraOrden , Id_Profesional , Id_Especialidad , Id_CentroCosto , TotalOrdenes , TotalEPS , TotalPaciente , Estado , Fecha , UsuarioS) \nSELECT Id_ingreso  ,\n Idtiposervicio ,\n Fecha_Cita ,\n HoraInicial , \n Id_Profesional ,\n Id_Especialidad ,\n Id_CentroCosto ,\n Valor AS TotalOrdenes,\n IF(Id_TipoPlanEmp=Id_TipoPlanProc,Valor,0) AS TotalEPS,\n IF(Id_TipoPlanEmp<>Id_TipoPlanProc,Valor,0) AS TotalPaciente,\n 0 AS Estado,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \nFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n IF(f.CualValor=0,(((t.VrMinimo*g_procedimiento.porcentajeImpuesto)/100)+t.VrMinimo),(((t.VrMaximo*g_procedimiento.porcentajeImpuesto)/100)+t.VrMaximo) ) AS Valor,\n t.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n LEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id\n WHERE (c_citasnp.Id ='" + this.idCita + "')  group by g_procedimiento.Id ) TAB";
                String xN_Orden = this.consultas.ejecutarSQLId(this.sql);
                this.consultas.cerrarConexionBd();
                this.sql = "INSERT INTO f_itemordenesproced( Id_Ordenes , Id_Procedimiento , Id_TipofinProc , Cantidad , ValorUnitario, porcentajeImpuesto, valorImpuesto, Id_CentroCosto , Plan, Fecha , UsuarioS)\n SELECT '" + xN_Orden + "', \n\t Id,\n\t Id_Finalidad,\n\t Cantidad,\n\t Valor,\n\t porcentajeImpuesto,\n\t valorImpuesto,\n\t Id_CentroCosto ,\n\t Id_TipoPlanProc,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \n\tFROM (\n\tSELECT c_citasnp.Id_ingreso  ,\n\t f_tiposervtipoproced.Idtiposervicio ,\n\t c_citasnp.Fecha_Cita ,\n\t c_citasnp.HoraInicial , \n\t c_citasnp.Id_Profesional ,\n\t c_citasnp.Id_Especialidad ,\n\t IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n\t g_procedimiento.Id,\n\t c_clasecita.Id_Finalidad,\n\t 1 AS Cantidad,\n\t f.Id_TipoPlan AS Id_TipoPlanEmp,\n\t f.MetodoFact,\n\t f.Redondeo,\n\t IF(f.CualValor=0, t.VrMinimo,t.VrMaximo) AS Valor,\n\t t.Id_TipoPlan AS Id_TipoPlanProc, \n\t g_procedimiento.porcentajeImpuesto, \n\t IF(f.CualValor=0, ((t.VrMinimo*g_procedimiento.porcentajeImpuesto)/100),((t.VrMaximo*g_procedimiento.porcentajeImpuesto)/100)) AS valorImpuesto \n\t FROM c_citasnp   \n\t INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n\t INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n\t INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n\t INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n\t AND (t.Id_Manual = f.Id_Manual) \n\t INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t INNER JOIN f_tiposervtipoproced  ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n\t LEFT JOIN \n\t\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t\t  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n\t ON \t aux.Id_Procedimiento=g_procedimiento.Id\n\t WHERE (c_citasnp.Id ='" + this.idCita + "')\t  group by g_procedimiento.Id ) TAB";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                break;
            case "1":
                this.sql = "INSERT INTO f_ordenes( Id_Ingreso , Id_TipoServicio , FechaOrden , HoraOrden , Id_Profesional , Id_Especialidad , Id_CentroCosto , TotalOrdenes , TotalEPS , TotalPaciente , Estado , Fecha , UsuarioS) \nSELECT Id_ingreso  ,\n Idtiposervicio ,\n Fecha_Cita ,\n HoraInicial , \n Id_Profesional ,\n Id_Especialidad ,\n Id_CentroCosto ,\n VTotal AS TotalOrdenes,\n IF(Id_TipoPlanEmp=Id_TipoPlanProc,VTotal,0) AS TotalEPS,\n IF(Id_TipoPlanEmp<>Id_TipoPlanProc,VTotal,0) AS TotalPaciente,\n 0 AS Estado,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \nFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n c_clasecita.Id_Finalidad,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n f.MetodoFact,\n f.Redondeo,\n IF(f.CualValor=0, \n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN (t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND,\n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN (t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND) AS Valor,\n((((SELECT Valor)*`g_procedimiento`.`porcentajeImpuesto`)/100)+(SELECT Valor)) AS VTotal,\nt.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n INNER JOIN f_servicioempresaconv ON (f_servicioempresaconv.Id_EmpresaConvenio=f.Id) \n             AND (f_tiposervtipoproced.Idtiposervicio= f_servicioempresaconv.Id_TipoServicio)\nLEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id WHERE (c_citasnp.Id ='" + this.idCita + "')  group by g_procedimiento.Id ) TAB";
                String xN_Orden2 = this.consultas.ejecutarSQLId(this.sql);
                this.consultas.cerrarConexionBd();
                this.sql = "INSERT INTO f_itemordenesproced( Id_Ordenes , Id_Procedimiento , Id_TipofinProc , Cantidad , ValorUnitario, porcentajeImpuesto, valorImpuesto, Id_CentroCosto , Plan, Fecha , UsuarioS)\n SELECT '" + xN_Orden2 + "', \n\t Id,\n\t Id_Finalidad,\n\t Cantidad,\n\t Valor,\n  porcentajeImpuesto,\n\t valorImpuesto,\n\t Id_CentroCosto ,\n\t Id_TipoPlanProc,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \n\tFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n c_clasecita.Id_Finalidad,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n f.MetodoFact,\n f.Redondeo,\n IF(f.CualValor=0, \n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN (t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND,\n\t\tCASE (f.Redondeo)\n\t\t\tWHEN 0 THEN (t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND) AS Valor,\n`g_procedimiento`.`porcentajeImpuesto`,\n(((SELECT Valor)*`g_procedimiento`.`porcentajeImpuesto`)/100) AS valorImpuesto,\nt.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON (t.Id_Procedimiento = g_procedimiento.Id) \n AND (t.Id_Manual = f.Id_Manual) \n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n INNER JOIN f_servicioempresaconv ON (f_servicioempresaconv.Id_EmpresaConvenio=f.Id) \n             AND (f_tiposervtipoproced.Idtiposervicio= f_servicioempresaconv.Id_TipoServicio)\nLEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id WHERE (c_citasnp.Id ='" + this.idCita + "')\t  group by g_procedimiento.Id ) TAB";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                break;
            case "2":
                this.sql = "INSERT INTO f_ordenes( Id_Ingreso , Id_TipoServicio , FechaOrden , HoraOrden , Id_Profesional , Id_Especialidad , Id_CentroCosto , TotalOrdenes , TotalEPS , TotalPaciente , Estado , Fecha , UsuarioS) \nSELECT Id_ingreso  ,\n Idtiposervicio ,\n Fecha_Cita ,\n HoraInicial , \n Id_Profesional ,\n Id_Especialidad ,\n Id_CentroCosto ,\n VTotal AS TotalOrdenes,\n IF(Id_TipoPlanEmp=Id_TipoPlanProc,VTotal,0) AS TotalEPS,\n IF(Id_TipoPlanEmp<>Id_TipoPlanProc,VTotal,0) AS TotalPaciente,\n 0 AS Estado,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \nFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n g_procedimiento.Id_TipoFinProced,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n f.MetodoFact,\n f.Redondeo,\n IF(f.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN (t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN (t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN (t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN (t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n((((SELECT Valor)*`g_procedimiento`.`porcentajeImpuesto`)/100)+(SELECT Valor)) AS VTotal,\nt.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN f_servicioempresaconv   ON (f_servicioempresaconv.Id_EmpresaConvenio = f.Id) \n INNER JOIN f_manual ON f_servicioempresaconv.Id_Manual_n=f_manual.Id\n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON g_procedimiento.Id=t.Id_Procedimiento AND t.Id_Manual=f_manual.Id\n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t\tAND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t    LEFT JOIN g_historico_salario_minimo ON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n LEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id WHERE (c_citasnp.Id ='" + this.idCita + "')  group by g_procedimiento.Id ) TAB";
                String xN_Orden3 = this.consultas.ejecutarSQLId(this.sql);
                this.consultas.cerrarConexionBd();
                this.sql = "INSERT INTO f_itemordenesproced( Id_Ordenes , Id_Procedimiento , Id_TipofinProc , Cantidad , ValorUnitario, porcentajeImpuesto, valorImpuesto , Id_CentroCosto , Plan, Fecha , UsuarioS)\n SELECT '" + xN_Orden3 + "', \n\t Id,\n\t Id_Finalidad,\n\t Cantidad,\n\t Valor,\n  porcentajeImpuesto,\n\t valorImpuesto,\n\t Id_CentroCosto ,\n\t Id_TipoPlanProc,\n NOW(),'" + Principal.usuarioSistemaDTO.getLogin() + "' \n\tFROM (\nSELECT c_citasnp.Id_ingreso  ,\n f_tiposervtipoproced.Idtiposervicio ,\n c_citasnp.Fecha_Cita ,\n c_citasnp.HoraInicial , \n c_citasnp.Id_Profesional ,\n c_citasnp.Id_Especialidad ,\n IF (aux.Id_CentroCosto IS NULL,(SELECT Id FROM f_centrocosto LIMIT 1),aux.Id_CentroCosto) AS Id_CentroCosto,\n g_procedimiento.Id,\n c_clasecita.Id_Finalidad,\n 1 AS Cantidad,\n f.Id_TipoPlan AS Id_TipoPlanEmp,\n f.MetodoFact,\n f.Redondeo,\n IF(f.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN (t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN (t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((t.VrMinimo+((t.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN (t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 1 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN (t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((t.VrMaximo+((t.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((t.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n`g_procedimiento`.`porcentajeImpuesto`,\n(((SELECT Valor)*`g_procedimiento`.`porcentajeImpuesto`)/100) AS valorImpuesto,\nt.Id_TipoPlan AS Id_TipoPlanProc \n FROM c_citasnp   \n INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) \n INNER JOIN f_empresacontxconvenio f ON (c_citasnp.Id_EmpresaCont = f.Id) \n INNER JOIN f_servicioempresaconv   ON (f_servicioempresaconv.Id_EmpresaConvenio = f.Id) \n INNER JOIN f_manual ON f_servicioempresaconv.Id_Manual_n=f_manual.Id\n INNER JOIN g_procedimiento  ON (c_clasecita.Id_Procedimiento = g_procedimiento.Id) \n INNER JOIN f_tarifaprocedimiento t ON g_procedimiento.Id=t.Id_Procedimiento AND t.Id_Manual=f_manual.Id\n INNER JOIN f_tipoprocedimiento  ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t\tAND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t    LEFT JOIN g_historico_salario_minimo ON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n LEFT JOIN \n\t(SELECT f_procedimcentrocosto.Id_Procedimiento,MIN(f_procedimcentrocosto.Id_CentroCosto) AS Id_CentroCosto FROM  f_procedimcentrocosto\n\t  GROUP BY f_procedimcentrocosto.Id_Procedimiento) aux\n ON \t aux.Id_Procedimiento=g_procedimiento.Id WHERE (c_citasnp.Id ='" + this.idCita + "')  group by g_procedimiento.Id) TAB";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                break;
        }
        mActualizar_Estado_citas();
    }

    public void mActualizar_Estado_citas() {
        this.sql = "Update c_citasnp set  EstaFacturada = 1, Id_ingreso='" + this.frmIngreso.getIdIngreso() + "' where id='" + this.idCita + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void grabarTriage() {
        this.sql = "INSERT INTO h_triage (IdIngreso, TArtSentadoD, TArtSentadoS, TArtAcostadoD, TArtAcostadoS, TArtPieD, TArtPieS, Clasificacion, FechaTriage, HoraTriage, MotivoConsulta, Observacion, Es_Agendado, Id_Profesional, Id_Especialidad, FCardiaca, FRespiratoria, Talla, Peso, IMC, Temperatura, Ps2, Estado, Fecha, UsuarioS) VALUES('" + this.idIngreso + "','" + obtenerValorNumerico(this.txtPresionSentadoD.getText()) + "','" + obtenerValorNumerico(this.txtPresionSentadoS.getText()) + "','" + obtenerValorNumerico(this.txtPresionAcostadoD.getText()) + "','" + obtenerValorNumerico(this.txtPresionAcostadoS.getText()) + "','" + obtenerValorNumerico(this.txtPresionPieD.getText()) + "','" + obtenerValorNumerico(this.txtPresionPieS.getText()) + "','" + this.clasificacion + "','" + this.metodos.formatoAMD.format(this.frmIngreso.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.frmIngreso.txtHora.getValue()) + "','" + this.txtMotivoConsulta.getText() + "','" + this.txtObservaciones.getText() + "','" + this.xesagendado + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + obtenerValorNumerico(this.txtFc.getText()) + "','" + obtenerValorNumerico(this.txtFr.getText()) + "','" + obtenerValorNumerico(this.txtTalla.getText()) + "','" + obtenerValorNumerico(this.txtPeso.getText()) + "','" + obtenerValorNumerico(this.txtImc.getText()) + "','" + obtenerValorNumerico(this.txtTemperatura.getText()) + "','" + obtenerValorNumerico(this.txtPs2.getText()) + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.idTriage = Long.valueOf(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        Principal.txtNo.setText("" + this.idTriage);
        Principal.txtEstado.setText("ACTIVA");
        Principal.txtFecha.setText(this.metodos.formatoDMA.format(this.frmIngreso.txtFecha.getDate()));
    }

    public Double obtenerValorNumerico(Object campo) {
        if (campo instanceof JTextFieldValidator) {
            JTextFieldValidator textField = (JTextFieldValidator) campo;
            String texto = textField.getText();
            if (texto != null && !texto.trim().isEmpty()) {
                try {
                    return Double.valueOf(texto.trim());
                } catch (NumberFormatException e) {
                    System.err.println("⚠️ Error al convertir a número: " + e.getMessage());
                }
            }
        } else if (campo instanceof JFormattedTextField) {
            JFormattedTextField formattedField = (JFormattedTextField) campo;
            Object valor = formattedField.getValue();
            if (valor != null) {
                try {
                    return Double.valueOf(valor.toString().trim());
                } catch (NumberFormatException e2) {
                    System.err.println("⚠️ Error al convertir a número: " + e2.getMessage());
                }
            }
        }
        return new Double(0.0d);
    }

    private void grabarAtencionHc() {
        this.sql = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + this.idIngreso + "','" + this.listaClaseCita[this.cboClaseCita.getSelectedIndex()] + "','" + this.metodos.formatoAMD.format(this.frmIngreso.txtFecha.getDate()) + "','" + this.metodos.formatoH24.format(this.frmIngreso.txtHora.getValue()) + "','','','1','','','','','" + this.frmIngreso.getIdProfesional() + "','" + this.frmIngreso.getIdEspecialidad() + "','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.idAtencion = this.consultas.traerDato("SELECT max(Id) FROM baseserver.h_atencion WHERE (Id_Ingreso ='" + this.idIngreso + "')");
        this.txtAtencion.setText(this.idAtencion);
        this.consultas.cerrarConexionBd();
    }

    private void grabarExamenFisico() {
        this.sql = "INSERT INTO h_examenfisico(Id_Atencion, TArtSentadoD, TArtSentadoS, TArtAcostadoD, TArtAcostadoS, TArtPieD, TArtPieS, ControlTA, FCardiaca, FRespiratoria, Talla, Peso, IMC, Observacion, Temperatura, Ps2, ControlDm, ValorGlicemia, Fecha, UsuarioS) VALUES ( '" + this.idAtencion + "','" + this.txtPresionSentadoD.getText() + "','" + this.txtPresionSentadoS.getText() + "','" + this.txtPresionAcostadoS.getText() + "','" + this.txtPresionAcostadoD.getText() + "','" + this.txtPresionPieD.getText() + "','" + this.txtPresionPieS.getText() + "','" + this.controlado + "','" + this.txtFc.getText() + "','" + this.txtFr.getText() + "','" + this.txtTalla.getText() + "','" + this.txtPeso.getText() + "','" + this.valorImc + "','','" + this.txtTemperatura.getText().replace(',', '.') + "','" + this.txtPs2.getText() + "','0','0','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void imprimirTriage() {
        if (getNoTriage() != null) {
            ClaseImpresionInformes claseImpresionInformes = new ClaseImpresionInformes();
            claseImpresionInformes.mImprimirTriage(this.txtAtencion.getText(), this.txtIngreso.getText());
        }
    }

    private void nuevoTriage() {
        this.txtPresionAcostadoD.setText("0");
        this.txtPresionAcostadoS.setText("0");
        this.txtPresionPieD.setText("0");
        this.txtPresionPieS.setText("0");
        this.txtPresionSentadoD.setText("0");
        this.txtPresionSentadoS.setText("0");
        this.btnControladoSi.setSelected(true);
        this.controlado = 0;
        this.txtFc.setText("0");
        this.txtFr.setText("0");
        this.txtTemperatura.setText("0");
        this.txtPs2.setText("0");
        this.txtTalla.setText("0");
        this.txtPeso.setText("0");
        this.txtImc.setText("0");
        this.txtMotivoConsulta.setText((String) null);
        this.txtObservaciones.setText((String) null);
        this.txtIngreso.setText((String) null);
        this.cboClaseCita.removeAllItems();
        this.txtCita.setText((String) null);
        this.clasificacion = 0;
        this.xesagendado = 0;
        this.JCHEsAgendado.setSelected(false);
        setIdHoraLlegada(null);
        botonTriage();
    }

    public void nuevo() {
        Object[] botones = {"Usuario", "Ingreso", "Triage", "Nota Cargo", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Por favor seleccione la opción que desea realizar", "NUEVO SERVICIO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.txtAtencion.setText("");
            this.txtIngreso.setText("");
            this.txtCita.setText("");
            this.txtHorallegada.setText("");
            this.frmPersona.nuevo();
            this.frmIngreso.nuevo();
            nuevoTriage();
            this.metodos.limpiarDatosPrincipal();
            this.frmPersona.txtHistoria.requestFocus();
            return;
        }
        if (n == 1) {
            this.txtIngreso.setText("");
            this.txtCita.setText("");
            this.txtHorallegada.setText("");
            this.frmIngreso.nuevo();
            nuevoTriage();
            return;
        }
        if (n == 2) {
            this.txtCita.setText("");
            this.txtHorallegada.setText("");
            nuevoTriage();
        }
    }

    private void validarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                this.metodos.mostrarMensaje("La Presión Sistólica esta Baja");
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    this.metodos.mostrarMensaje("La Presión Sistólica esta Alta");
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            this.metodos.mostrarMensaje("La Presion Diastólica esta Baja");
        } else if (valor > 0 && valor > 90) {
            this.metodos.mostrarMensaje("La Presión Diastólica esta Alta");
        }
    }

    private boolean validarCompHoraLlegada() {
        boolean estado = false;
        if (this.txtHorallegada.getText() != null) {
            estado = true;
        }
        return estado;
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.clasificacion < 1) {
            this.metodos.mostrarMensaje("Por favor presione un Botón de Color para clasificar el Triage");
            this.btnAmarillo.requestFocus();
        } else if (this.txtMotivoConsulta.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite el Motivo de Consulta");
            this.txtMotivoConsulta.requestFocus();
        } else if (this.txtObservaciones.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite las Observaciones");
            this.txtObservaciones.requestFocus();
        } else if (this.cboClaseCita.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Clase de Cita");
            this.cboClaseCita.requestFocus();
        } else if (this.txtHorallegada.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite la Hora de LLegada del Usuario");
            this.txtHorallegada.requestFocus();
        } else if (this.txtHorallegada.getText().length() < 8) {
            this.metodos.mostrarMensaje("Por favor digite la Hora de LLegada del Usuario en formato hh:mm AM ó hh:mm PM");
            this.txtHorallegada.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private void initComponents() {
        this.JBGClasificacion = new ButtonGroup();
        this.mnPopup = new JPopupMenu();
        this.mnAsignar = new JMenuItem();
        this.mnDesistir = new JMenuItem();
        this.jSeparator1 = new JSeparator();
        this.mnSalir = new JMenuItem();
        this.JPIFondo = new JPanel();
        this.jLabel8 = new JLabel();
        this.btnHistoriaE = new JButton();
        this.btnNotaCargo = new JButton();
        this.btnAgendaMedico = new JButton();
        this.txtHorallegada = new JFormattedTextField();
        this.JBTEventoAdverso1 = new JButton();
        this.panelersona = new JPanel();
        this.txtAtencion = new JFormattedTextField();
        this.panelIngreso = new JPanel();
        this.txtIngreso = new JFormattedTextField();
        this.txtCita = new JFormattedTextField();
        this.JTP_Triage = new JTabbedPane();
        this.JPI_Triage = new JPanel();
        this.jPanel4 = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtPresionSentadoS = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.txtPresionSentadoD = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.txtPresionPieS = new JFormattedTextField();
        this.JLBBPie = new JLabel();
        this.txtPresionPieD = new JFormattedTextField();
        this.jPanel3 = new JPanel();
        this.txtPresionAcostadoS = new JFormattedTextField();
        this.JLBBAcostado = new JLabel();
        this.txtPresionAcostadoD = new JFormattedTextField();
        this.JPIControl = new JPanel();
        this.btnControladoSi = new JRadioButton();
        this.btnControladoNo = new JRadioButton();
        this.JPSignosVitales = new JPanel();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.txtFc = new JTextFieldValidator();
        this.txtFr = new JTextFieldValidator();
        this.txtTemperatura = new JTextFieldValidator();
        this.txtPs2 = new JTextFieldValidator();
        this.txtTalla = new JTextFieldValidator();
        this.txtPeso = new JTextFieldValidator();
        this.txtImc = new JTextFieldValidator();
        this.JSPMovitoConsulta = new JScrollPane();
        this.txtMotivoConsulta = new JTextPane();
        this.JSPObservaciones = new JScrollPane();
        this.txtObservaciones = new JTextPane();
        this.JPIClasificacion = new JPanel();
        this.btnNegro = new JButton();
        this.btnVerde = new JButton();
        this.btnAmarillo = new JButton();
        this.btnNaranja = new JButton();
        this.btnRojo = new JButton();
        this.cboClaseCita = new JComboBox();
        this.JCHEsAgendado = new JCheckBox();
        this.JCHAplicaTestRespiratorio = new JCheckBox();
        this.JPI_TriageRespiratorio = new JPanel();
        this.mnAsignar.setText("Asignar");
        this.mnAsignar.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.1
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.mnAsignarActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnAsignar);
        this.mnDesistir.setText("Desistir");
        this.mnDesistir.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.2
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.mnDesistirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnDesistir);
        this.mnPopup.add(this.jSeparator1);
        this.mnSalir.setText("Salir");
        this.mnSalir.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.3
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.mnSalirActionPerformed(evt);
            }
        });
        this.mnPopup.add(this.mnSalir);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CLASIFICACIÓN DE ENFERMERIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1200, 821));
        setMinimumSize(new Dimension(1200, 821));
        setName("Atencion");
        addInternalFrameListener(new InternalFrameListener() { // from class: Enfermeria.Atencion.4
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                Atencion.this.formInternalFrameClosed(evt);
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(new Color(0, 0, 153));
        this.jLabel8.setHorizontalAlignment(0);
        this.jLabel8.setText("formato hh:mm de 12 ejemplo 08:24 AM");
        this.jLabel8.setBorder(new SoftBevelBorder(0));
        this.btnHistoriaE.setFont(new Font("Arial", 1, 12));
        this.btnHistoriaE.setForeground(new Color(0, 0, 255));
        this.btnHistoriaE.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Enfermera23x24.png")));
        this.btnHistoriaE.setText("Historia Clínica");
        this.btnHistoriaE.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.5
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnHistoriaEActionPerformed(evt);
            }
        });
        this.btnNotaCargo.setFont(new Font("Arial", 1, 12));
        this.btnNotaCargo.setForeground(new Color(0, 0, 255));
        this.btnNotaCargo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Paciente.png")));
        this.btnNotaCargo.setText("Notas de Cargo");
        this.btnNotaCargo.setEnabled(false);
        this.btnNotaCargo.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.6
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnNotaCargoActionPerformed(evt);
            }
        });
        this.btnAgendaMedico.setFont(new Font("Tahoma", 1, 12));
        this.btnAgendaMedico.setForeground(new Color(0, 0, 255));
        this.btnAgendaMedico.setIcon(new ImageIcon(getClass().getResource("/Imagenes/AgendaMedica.png")));
        this.btnAgendaMedico.setText("Agenda Profesional");
        this.btnAgendaMedico.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.7
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnAgendaMedicoActionPerformed(evt);
            }
        });
        this.txtHorallegada.setBackground(new Color(0, 0, 102));
        this.txtHorallegada.setBorder(BorderFactory.createTitledBorder("Hora de Llegada"));
        this.txtHorallegada.setForeground(new Color(255, 255, 255));
        this.txtHorallegada.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHorallegada.setHorizontalAlignment(0);
        this.txtHorallegada.setDisabledTextColor(new Color(0, 0, 102));
        this.txtHorallegada.setEnabled(false);
        this.txtHorallegada.setFont(new Font("Arial", 1, 18));
        this.JBTEventoAdverso1.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso1.setForeground(new Color(0, 0, 255));
        this.JBTEventoAdverso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso1.setText("<html><P ALIGN=center>Caso de Seguridad del Paciente\n\n");
        this.JBTEventoAdverso1.setToolTipText("");
        this.JBTEventoAdverso1.setActionCommand("gg");
        this.JBTEventoAdverso1.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.8
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.JBTEventoAdverso1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFondoLayout = new GroupLayout(this.JPIFondo);
        this.JPIFondo.setLayout(JPIFondoLayout);
        JPIFondoLayout.setHorizontalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFondoLayout.createSequentialGroup().addContainerGap().addComponent(this.txtHorallegada, -2, 152, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel8, -2, 289, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnHistoriaE, -2, 184, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNotaCargo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEventoAdverso1, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAgendaMedico).addContainerGap(-1, 32767)));
        JPIFondoLayout.setVerticalGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFondoLayout.createSequentialGroup().addContainerGap().addGroup(JPIFondoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtHorallegada).addGroup(JPIFondoLayout.createSequentialGroup().addComponent(this.jLabel8).addGap(0, 0, 32767)).addComponent(this.btnHistoriaE, -1, -1, 32767).addComponent(this.btnNotaCargo, -1, -1, 32767).addComponent(this.btnAgendaMedico, -1, -1, 32767).addComponent(this.JBTEventoAdverso1, GroupLayout.Alignment.TRAILING, -1, 49, 32767)).addContainerGap()));
        this.panelersona.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout panelersonaLayout = new GroupLayout(this.panelersona);
        this.panelersona.setLayout(panelersonaLayout);
        panelersonaLayout.setHorizontalGroup(panelersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1002, 32767));
        panelersonaLayout.setVerticalGroup(panelersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 162, 32767));
        this.txtAtencion.setBackground(new Color(0, 0, 102));
        this.txtAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Atención No.", 0, 0, new Font("Tahoma", 1, 12), new Color(204, 255, 255)));
        this.txtAtencion.setForeground(new Color(255, 255, 255));
        this.txtAtencion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtAtencion.setHorizontalAlignment(0);
        this.txtAtencion.setDisabledTextColor(new Color(255, 255, 255));
        this.txtAtencion.setEnabled(false);
        this.txtAtencion.setFont(new Font("Arial", 1, 20));
        this.panelIngreso.setPreferredSize(new Dimension(1199, 185));
        GroupLayout panelIngresoLayout = new GroupLayout(this.panelIngreso);
        this.panelIngreso.setLayout(panelIngresoLayout);
        panelIngresoLayout.setHorizontalGroup(panelIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1234, 32767));
        panelIngresoLayout.setVerticalGroup(panelIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 230, 32767));
        this.txtIngreso.setEditable(false);
        this.txtIngreso.setBackground(new Color(0, 0, 102));
        this.txtIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Triage", 1, 0, new Font("Tahoma", 1, 12), new Color(204, 255, 255)));
        this.txtIngreso.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtIngreso.setHorizontalAlignment(0);
        this.txtIngreso.setDisabledTextColor(new Color(255, 255, 255));
        this.txtIngreso.setEnabled(false);
        this.txtIngreso.setFont(new Font("Arial", 1, 20));
        this.txtCita.setEditable(false);
        this.txtCita.setBackground(new Color(0, 0, 102));
        this.txtCita.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cita", 1, 0, new Font("Tahoma", 1, 12), new Color(204, 255, 255)));
        this.txtCita.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtCita.setHorizontalAlignment(0);
        this.txtCita.setDisabledTextColor(new Color(255, 255, 255));
        this.txtCita.setEnabled(false);
        this.txtCita.setFont(new Font("Arial", 1, 20));
        this.JTP_Triage.setForeground(Color.red);
        this.JTP_Triage.setFont(new Font("Arial", 1, 14));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Presión Sistólica / Diastólica", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel4.setLayout((LayoutManager) null);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Sentado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel1.setLayout((LayoutManager) null);
        this.txtPresionSentadoS.setHorizontalAlignment(4);
        this.txtPresionSentadoS.setFont(new Font("Arial", 1, 12));
        this.txtPresionSentadoS.setName("fechanaciemiento");
        this.txtPresionSentadoS.setValue(new Integer(0));
        this.txtPresionSentadoS.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.9
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtPresionSentadoSActionPerformed(evt);
            }
        });
        this.txtPresionSentadoS.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.10
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtPresionSentadoSFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtPresionSentadoSFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtPresionSentadoS);
        this.txtPresionSentadoS.setBounds(10, 20, 43, 25);
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.jPanel1.add(this.JLBPBSentado);
        this.JLBPBSentado.setBounds(60, 20, 5, 23);
        this.txtPresionSentadoD.setHorizontalAlignment(4);
        this.txtPresionSentadoD.setFont(new Font("Arial", 1, 12));
        this.txtPresionSentadoD.setName("fechanaciemiento");
        this.txtPresionSentadoD.setValue(new Integer(0));
        this.txtPresionSentadoD.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.11
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtPresionSentadoDActionPerformed(evt);
            }
        });
        this.txtPresionSentadoD.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.12
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtPresionSentadoDFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtPresionSentadoDFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtPresionSentadoD);
        this.txtPresionSentadoD.setBounds(70, 20, 50, 25);
        this.jPanel4.add(this.jPanel1);
        this.jPanel1.setBounds(10, 20, 134, 60);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "De Pie", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtPresionPieS.setHorizontalAlignment(4);
        this.txtPresionPieS.setFont(new Font("Arial", 1, 12));
        this.txtPresionPieS.setName("fechanaciemiento");
        this.txtPresionPieS.setValue(new Integer(0));
        this.txtPresionPieS.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.13
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtPresionPieSActionPerformed(evt);
            }
        });
        this.txtPresionPieS.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.14
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtPresionPieSFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtPresionPieSFocusLost(evt);
            }
        });
        this.jPanel2.add(this.txtPresionPieS);
        this.txtPresionPieS.setBounds(10, 20, 50, 25);
        this.JLBBPie.setFont(new Font("Arial", 1, 18));
        this.JLBBPie.setForeground(Color.blue);
        this.JLBBPie.setHorizontalAlignment(0);
        this.JLBBPie.setText("/");
        this.jPanel2.add(this.JLBBPie);
        this.JLBBPie.setBounds(60, 20, 5, 23);
        this.txtPresionPieD.setHorizontalAlignment(4);
        this.txtPresionPieD.setFont(new Font("Arial", 1, 12));
        this.txtPresionPieD.setName("fechanaciemiento");
        this.txtPresionPieD.setValue(new Integer(0));
        this.txtPresionPieD.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.15
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtPresionPieDActionPerformed(evt);
            }
        });
        this.txtPresionPieD.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.16
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtPresionPieDFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtPresionPieDFocusLost(evt);
            }
        });
        this.jPanel2.add(this.txtPresionPieD);
        this.txtPresionPieD.setBounds(70, 20, 50, 25);
        this.jPanel4.add(this.jPanel2);
        this.jPanel2.setBounds(150, 20, 133, 57);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Acostado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.txtPresionAcostadoS.setHorizontalAlignment(4);
        this.txtPresionAcostadoS.setFont(new Font("Arial", 1, 12));
        this.txtPresionAcostadoS.setName("fechanaciemiento");
        this.txtPresionAcostadoS.setValue(new Integer(0));
        this.txtPresionAcostadoS.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.17
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtPresionAcostadoSActionPerformed(evt);
            }
        });
        this.txtPresionAcostadoS.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.18
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtPresionAcostadoSFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtPresionAcostadoSFocusLost(evt);
            }
        });
        this.jPanel3.add(this.txtPresionAcostadoS);
        this.txtPresionAcostadoS.setBounds(10, 20, 50, 25);
        this.JLBBAcostado.setFont(new Font("Arial", 1, 18));
        this.JLBBAcostado.setForeground(Color.blue);
        this.JLBBAcostado.setHorizontalAlignment(0);
        this.JLBBAcostado.setText("/");
        this.jPanel3.add(this.JLBBAcostado);
        this.JLBBAcostado.setBounds(70, 20, 5, 23);
        this.txtPresionAcostadoD.setHorizontalAlignment(4);
        this.txtPresionAcostadoD.setFont(new Font("Arial", 1, 12));
        this.txtPresionAcostadoD.setName("fechanaciemiento");
        this.txtPresionAcostadoD.setValue(new Integer(0));
        this.txtPresionAcostadoD.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.19
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtPresionAcostadoDActionPerformed(evt);
            }
        });
        this.txtPresionAcostadoD.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.20
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtPresionAcostadoDFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtPresionAcostadoDFocusLost(evt);
            }
        });
        this.jPanel3.add(this.txtPresionAcostadoD);
        this.txtPresionAcostadoD.setBounds(80, 20, 50, 25);
        this.jPanel4.add(this.jPanel3);
        this.jPanel3.setBounds(290, 20, 148, 57);
        this.JPIControl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Controlado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.btnControladoSi.setFont(new Font("Arial", 1, 12));
        this.btnControladoSi.setForeground(new Color(0, 0, 255));
        this.btnControladoSi.setSelected(true);
        this.btnControladoSi.setText("Si");
        this.btnControladoSi.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.21
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnControladoSiActionPerformed(evt);
            }
        });
        this.btnControladoSi.addKeyListener(new KeyAdapter() { // from class: Enfermeria.Atencion.22
            public void keyPressed(KeyEvent evt) {
                Atencion.this.btnControladoSiKeyPressed(evt);
            }
        });
        this.btnControladoNo.setFont(new Font("Arial", 1, 12));
        this.btnControladoNo.setForeground(new Color(0, 0, 255));
        this.btnControladoNo.setText("No");
        this.btnControladoNo.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.23
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnControladoNoActionPerformed(evt);
            }
        });
        this.btnControladoNo.addKeyListener(new KeyAdapter() { // from class: Enfermeria.Atencion.24
            public void keyPressed(KeyEvent evt) {
                Atencion.this.btnControladoNoKeyPressed(evt);
            }
        });
        GroupLayout JPIControlLayout = new GroupLayout(this.JPIControl);
        this.JPIControl.setLayout(JPIControlLayout);
        JPIControlLayout.setHorizontalGroup(JPIControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIControlLayout.createSequentialGroup().addComponent(this.btnControladoSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnControladoNo).addContainerGap()));
        JPIControlLayout.setVerticalGroup(JPIControlLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIControlLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnControladoNo).addComponent(this.btnControladoSi)));
        this.jPanel4.add(this.JPIControl);
        this.JPIControl.setBounds(450, 20, 115, 60);
        this.JPSignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS VITALES", 1, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPSignosVitales.setLayout(new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 204));
        this.jLabel1.setText("Fc (p/m)");
        this.JPSignosVitales.add(this.jLabel1, new AbsoluteConstraints(8, 24, -1, -1));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 204));
        this.jLabel2.setText("Fr (r/m)");
        this.JPSignosVitales.add(this.jLabel2, new AbsoluteConstraints(71, 24, -1, -1));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 204));
        this.jLabel3.setText("T (ªC)");
        this.JPSignosVitales.add(this.jLabel3, new AbsoluteConstraints(134, 24, -1, -1));
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 204));
        this.jLabel4.setText("Ps2");
        this.JPSignosVitales.add(this.jLabel4, new AbsoluteConstraints(197, 24, -1, -1));
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 204));
        this.jLabel5.setText("Talla (cm)");
        this.JPSignosVitales.add(this.jLabel5, new AbsoluteConstraints(250, 20, -1, -1));
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 0, 204));
        this.jLabel6.setText("Peso (Kg)");
        this.JPSignosVitales.add(this.jLabel6, new AbsoluteConstraints(310, 20, -1, -1));
        this.jLabel7.setFont(new Font("Arial", 1, 24));
        this.jLabel7.setForeground(new Color(0, 0, 204));
        this.jLabel7.setText("IMC");
        this.JPSignosVitales.add(this.jLabel7, new AbsoluteConstraints(410, 30, 50, -1));
        this.txtFc.setHorizontalAlignment(0);
        this.txtFc.setText("0");
        this.txtFc.setToolTipText("Frecuencia Cardiáca");
        this.txtFc.setExprecionRegular("^[0-9]*$");
        this.txtFc.setFocusAccelerator('C');
        this.txtFc.setFont(new Font("Arial", 1, 12));
        this.txtFc.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.25
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtFcActionPerformed(evt);
            }
        });
        this.txtFc.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.26
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtFcFocusLost(evt);
            }
        });
        this.JPSignosVitales.add(this.txtFc, new AbsoluteConstraints(10, 40, 57, 27));
        this.txtFr.setHorizontalAlignment(0);
        this.txtFr.setText("0");
        this.txtFr.setToolTipText("Frecuencia Respiratoria");
        this.txtFr.setExprecionRegular("^[0-9]*$");
        this.txtFr.setFocusAccelerator('C');
        this.txtFr.setFont(new Font("Arial", 1, 12));
        this.txtFr.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.27
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtFrActionPerformed(evt);
            }
        });
        this.txtFr.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.28
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtFrFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtFrFocusLost(evt);
            }
        });
        this.JPSignosVitales.add(this.txtFr, new AbsoluteConstraints(70, 40, 57, 27));
        this.txtTemperatura.setHorizontalAlignment(0);
        this.txtTemperatura.setText("0");
        this.txtTemperatura.setToolTipText("Temperatura");
        this.txtTemperatura.setExprecionRegular("^[0-9.]*$");
        this.txtTemperatura.setFocusAccelerator('C');
        this.txtTemperatura.setFont(new Font("Arial", 1, 12));
        this.txtTemperatura.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.29
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtTemperaturaActionPerformed(evt);
            }
        });
        this.txtTemperatura.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.30
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtTemperaturaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtTemperaturaFocusLost(evt);
            }
        });
        this.JPSignosVitales.add(this.txtTemperatura, new AbsoluteConstraints(130, 40, 57, 27));
        this.txtPs2.setHorizontalAlignment(0);
        this.txtPs2.setText("0");
        this.txtPs2.setToolTipText("Ps2");
        this.txtPs2.setExprecionRegular("^[0-9]*$");
        this.txtPs2.setFocusAccelerator('C');
        this.txtPs2.setFont(new Font("Arial", 1, 12));
        this.txtPs2.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.31
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtPs2ActionPerformed(evt);
            }
        });
        this.txtPs2.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.32
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtPs2FocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtPs2FocusLost(evt);
            }
        });
        this.JPSignosVitales.add(this.txtPs2, new AbsoluteConstraints(190, 40, 57, 27));
        this.txtTalla.setHorizontalAlignment(0);
        this.txtTalla.setText("0");
        this.txtTalla.setToolTipText("Talla en Centimetros");
        this.txtTalla.setExprecionRegular("^[0.0-9]*$");
        this.txtTalla.setFocusAccelerator('C');
        this.txtTalla.setFont(new Font("Arial", 1, 12));
        this.txtTalla.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.33
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtTallaActionPerformed(evt);
            }
        });
        this.txtTalla.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.34
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtTallaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtTallaFocusLost(evt);
            }
        });
        this.JPSignosVitales.add(this.txtTalla, new AbsoluteConstraints(250, 40, 57, 27));
        this.txtPeso.setHorizontalAlignment(0);
        this.txtPeso.setText("0");
        this.txtPeso.setToolTipText("Peso en Kilogramos");
        this.txtPeso.setExprecionRegular("^[0.0-9]*$");
        this.txtPeso.setFocusAccelerator('C');
        this.txtPeso.setFont(new Font("Arial", 1, 12));
        this.txtPeso.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.35
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtPesoActionPerformed(evt);
            }
        });
        this.txtPeso.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.36
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtPesoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtPesoFocusLost(evt);
            }
        });
        this.JPSignosVitales.add(this.txtPeso, new AbsoluteConstraints(310, 40, 57, 27));
        this.txtImc.setEditable(false);
        this.txtImc.setBackground(new Color(0, 0, 102));
        this.txtImc.setHorizontalAlignment(0);
        this.txtImc.setToolTipText("Indice de Masa Corporal");
        this.txtImc.setDisabledTextColor(new Color(255, 255, 255));
        this.txtImc.setEnabled(false);
        this.txtImc.setExprecionRegular("^[0.0-9]*$");
        this.txtImc.setFocusable(false);
        this.txtImc.setFont(new Font("Arial", 1, 24));
        this.txtImc.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.37
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.txtImcActionPerformed(evt);
            }
        });
        this.txtImc.addFocusListener(new FocusAdapter() { // from class: Enfermeria.Atencion.38
            public void focusGained(FocusEvent evt) {
                Atencion.this.txtImcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Atencion.this.txtImcFocusLost(evt);
            }
        });
        this.JPSignosVitales.add(this.txtImc, new AbsoluteConstraints(470, 20, 100, 50));
        this.JSPMovitoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "MOTIVO CONSULTA", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.txtMotivoConsulta.addKeyListener(new KeyAdapter() { // from class: Enfermeria.Atencion.39
            public void keyPressed(KeyEvent evt) {
                Atencion.this.txtMotivoConsultaKeyPressed(evt);
            }
        });
        this.JSPMovitoConsulta.setViewportView(this.txtMotivoConsulta);
        this.JSPObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "ENFERMEDAD ACTUAL", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.txtObservaciones.addKeyListener(new KeyAdapter() { // from class: Enfermeria.Atencion.40
            public void keyPressed(KeyEvent evt) {
                Atencion.this.txtObservacionesKeyPressed(evt);
            }
        });
        this.JSPObservaciones.setViewportView(this.txtObservaciones);
        this.JPIClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "CLASIFICACIÓN", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.btnNegro.setFont(new Font("Arial", 1, 14));
        this.btnNegro.setText("5");
        this.btnNegro.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.41
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnNegroActionPerformed(evt);
            }
        });
        this.btnVerde.setBackground(Color.green);
        this.btnVerde.setFont(new Font("Arial", 1, 14));
        this.btnVerde.setForeground(new Color(0, 0, 204));
        this.btnVerde.setText("4");
        this.btnVerde.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.42
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnVerdeActionPerformed(evt);
            }
        });
        this.btnAmarillo.setBackground(new Color(255, 255, 0));
        this.btnAmarillo.setFont(new Font("Arial", 1, 14));
        this.btnAmarillo.setForeground(new Color(0, 0, 204));
        this.btnAmarillo.setText("3");
        this.btnAmarillo.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.43
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnAmarilloActionPerformed(evt);
            }
        });
        this.btnNaranja.setBackground(Color.orange);
        this.btnNaranja.setFont(new Font("Arial", 1, 14));
        this.btnNaranja.setForeground(new Color(0, 0, 204));
        this.btnNaranja.setText("2");
        this.btnNaranja.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.44
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnNaranjaActionPerformed(evt);
            }
        });
        this.btnRojo.setBackground(Color.red);
        this.btnRojo.setFont(new Font("Arial", 1, 14));
        this.btnRojo.setForeground(new Color(0, 0, 204));
        this.btnRojo.setText("1");
        this.btnRojo.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.45
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.btnRojoActionPerformed(evt);
            }
        });
        GroupLayout JPIClasificacionLayout = new GroupLayout(this.JPIClasificacion);
        this.JPIClasificacion.setLayout(JPIClasificacionLayout);
        JPIClasificacionLayout.setHorizontalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addContainerGap().addComponent(this.btnRojo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNaranja, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnAmarillo, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnVerde, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnNegro, -1, 126, 32767).addContainerGap()));
        JPIClasificacionLayout.setVerticalGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIClasificacionLayout.createSequentialGroup().addGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.btnVerde, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPIClasificacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnRojo, -2, 60, -2).addComponent(this.btnNaranja, -2, 60, -2).addComponent(this.btnAmarillo, -2, 60, -2)).addComponent(this.btnNegro, -1, -1, 32767)).addContainerGap()));
        this.cboClaseCita.setFont(new Font("Arial", 1, 12));
        this.cboClaseCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Cita", 0, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JCHEsAgendado.setFont(new Font("Arial", 1, 12));
        this.JCHEsAgendado.setText("Es Agendado?");
        this.JCHEsAgendado.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.46
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.JCHEsAgendadoActionPerformed(evt);
            }
        });
        this.JCHAplicaTestRespiratorio.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaTestRespiratorio.setForeground(Color.red);
        this.JCHAplicaTestRespiratorio.setText("Aplica Test Respiratorio?");
        this.JCHAplicaTestRespiratorio.setToolTipText("Aplica triage respiratorio (SARS-Cov-2)");
        this.JCHAplicaTestRespiratorio.addActionListener(new ActionListener() { // from class: Enfermeria.Atencion.47
            public void actionPerformed(ActionEvent evt) {
                Atencion.this.JCHAplicaTestRespiratorioActionPerformed(evt);
            }
        });
        GroupLayout JPI_TriageLayout = new GroupLayout(this.JPI_Triage);
        this.JPI_Triage.setLayout(JPI_TriageLayout);
        JPI_TriageLayout.setHorizontalGroup(JPI_TriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TriageLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPI_TriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel4, -2, 580, -2).addComponent(this.JPSignosVitales, -2, 580, -2).addComponent(this.JPIClasificacion, -2, -1, -2)).addGap(10, 10, 10).addGroup(JPI_TriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TriageLayout.createSequentialGroup().addComponent(this.cboClaseCita, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_TriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAplicaTestRespiratorio, -1, -1, 32767).addGroup(JPI_TriageLayout.createSequentialGroup().addComponent(this.JCHEsAgendado, -2, 120, -2).addGap(0, 0, 32767)))).addComponent(this.JSPObservaciones, -2, 540, -2).addComponent(this.JSPMovitoConsulta, -2, 540, -2)).addContainerGap()));
        JPI_TriageLayout.setVerticalGroup(JPI_TriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TriageLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel4, -2, 87, -2).addGap(3, 3, 3).addComponent(this.JPSignosVitales, -2, 80, -2).addGap(4, 4, 4).addComponent(this.JPIClasificacion, -2, -1, -2)).addGroup(JPI_TriageLayout.createSequentialGroup().addGroup(JPI_TriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TriageLayout.createSequentialGroup().addGap(100, 100, 100).addComponent(this.JSPObservaciones, -2, 110, -2)).addComponent(this.JSPMovitoConsulta, -2, 101, -2)).addGap(10, 10, 10).addGroup(JPI_TriageLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboClaseCita, -2, 60, -2).addGroup(JPI_TriageLayout.createSequentialGroup().addComponent(this.JCHAplicaTestRespiratorio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEsAgendado)))));
        this.JTP_Triage.addTab("TRIAGE", this.JPI_Triage);
        GroupLayout JPI_TriageRespiratorioLayout = new GroupLayout(this.JPI_TriageRespiratorio);
        this.JPI_TriageRespiratorio.setLayout(JPI_TriageRespiratorioLayout);
        JPI_TriageRespiratorioLayout.setHorizontalGroup(JPI_TriageRespiratorioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1217, 32767));
        JPI_TriageRespiratorioLayout.setVerticalGroup(JPI_TriageRespiratorioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 289, 32767));
        this.JTP_Triage.addTab("TEST RESPIRATORIO (SARS-CoV-2)", this.JPI_TriageRespiratorio);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFondo, -1, -1, -2).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelIngreso, GroupLayout.Alignment.TRAILING, -2, 1234, -2).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Triage, -1, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.panelersona, -2, -1, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtIngreso, GroupLayout.Alignment.LEADING, -1, 216, 32767).addComponent(this.txtAtencion, GroupLayout.Alignment.LEADING).addComponent(this.txtCita)))).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelersona, -2, -1, -2).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.txtAtencion, -2, 50, -2).addGap(0, 0, 0).addComponent(this.txtIngreso, -2, 50, -2).addGap(0, 0, 0).addComponent(this.txtCita, -2, 50, -2))).addGap(6, 6, 6).addComponent(this.panelIngreso, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Triage, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFondo, -2, -1, -2)));
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnHistoriaEActionPerformed(ActionEvent evt) {
        if (!this.frmPersona.getIdPersona().isEmpty()) {
            if (!this.txtAtencion.getText().isEmpty()) {
                if (!this.txtIngreso.getText().isEmpty()) {
                    Principal.clasehistoriace = new clasesHistoriaCE();
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(6);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(this.frmPersona.getIdSexo());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(this.frmPersona.getHistoria());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(this.frmPersona.getIdPersona()));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(this.frmPersona.txtEdad.getText());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdAtencion(this.txtAtencion.getText());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(this.txtIngreso.getText()));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(this.frmPersona.getApellido1() + " " + this.frmPersona.getApellido2() + " " + this.frmPersona.getNombre1() + " " + this.frmPersona.getNombre2());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(new Long(0L));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(new Long(0L));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdManPower(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEsPeriodico(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCargo(new Long(0L));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(0);
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setFormaHistoria(0);
                    Principal.clasehistoriace.cargarPantalla("Historia", this.claseEnf.xjp, "Historia_Enf1");
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe tener un ingreso valido", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe tener una atencion valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe buscar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnAsignarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnDesistirActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnSalirActionPerformed(ActionEvent evt) {
        this.mnPopup.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNegroActionPerformed(ActionEvent evt) {
        this.clasificacion = 5;
        botonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnRojoActionPerformed(ActionEvent evt) {
        this.clasificacion = 1;
        botonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNaranjaActionPerformed(ActionEvent evt) {
        this.clasificacion = 2;
        botonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAmarilloActionPerformed(ActionEvent evt) {
        this.clasificacion = 3;
        botonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnVerdeActionPerformed(ActionEvent evt) {
        this.clasificacion = 4;
        botonTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnControladoSiActionPerformed(ActionEvent evt) {
        this.controlado = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnControladoSiKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.btnControladoSi.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnControladoNoActionPerformed(ActionEvent evt) {
        this.controlado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnControladoNoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.btnControladoNo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSentadoSActionPerformed(ActionEvent evt) {
        this.txtPresionSentadoD.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSentadoSFocusLost(FocusEvent evt) {
        if (!this.txtPresionSentadoS.getText().isEmpty() && !this.txtPresionSentadoS.getText().equals("0")) {
            validarPresion(Integer.valueOf(this.txtPresionSentadoS.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSentadoDActionPerformed(ActionEvent evt) {
        this.txtPresionPieS.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSentadoDFocusLost(FocusEvent evt) {
        if (!this.txtPresionSentadoD.getText().isEmpty()) {
            validarPresion(Integer.valueOf(this.txtPresionSentadoD.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionPieSActionPerformed(ActionEvent evt) {
        this.txtPresionPieD.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionPieSFocusLost(FocusEvent evt) {
        if (!this.txtPresionPieS.getText().isEmpty()) {
            validarPresion(Integer.valueOf(this.txtPresionPieS.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionPieDActionPerformed(ActionEvent evt) {
        this.txtPresionAcostadoS.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionPieDFocusLost(FocusEvent evt) {
        if (!this.txtPresionPieD.getText().isEmpty()) {
            validarPresion(Integer.valueOf(this.txtPresionPieD.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionAcostadoSActionPerformed(ActionEvent evt) {
        this.txtPresionAcostadoD.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionAcostadoSFocusLost(FocusEvent evt) {
        if (!this.txtPresionAcostadoS.getText().isEmpty()) {
            validarPresion(Integer.valueOf(this.txtPresionAcostadoS.getText()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionAcostadoDActionPerformed(ActionEvent evt) {
        this.btnControladoSi.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionAcostadoDFocusLost(FocusEvent evt) {
        if (!this.txtPresionAcostadoD.getText().isEmpty()) {
            validarPresion(Integer.valueOf(this.txtPresionAcostadoD.getText()).intValue(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNotaCargoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAgendaMedicoActionPerformed(ActionEvent evt) {
        JIFAgendaMedico_N JIFAgendaMedico = new JIFAgendaMedico_N(this.frmIngreso.getIdProfesional(), this.frmIngreso.getIdEspecialidad(), 1);
        Principal.informacionGeneralPrincipalDTO.setAsignacionCitaAgenda(false);
        Principal.cargarPantalla(JIFAgendaMedico);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSentadoSFocusGained(FocusEvent evt) {
        this.txtPresionSentadoS.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionSentadoDFocusGained(FocusEvent evt) {
        this.txtPresionSentadoD.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionPieSFocusGained(FocusEvent evt) {
        this.txtPresionPieS.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionPieDFocusGained(FocusEvent evt) {
        this.txtPresionPieD.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionAcostadoSFocusGained(FocusEvent evt) {
        this.txtPresionAcostadoS.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPresionAcostadoDFocusGained(FocusEvent evt) {
        this.txtPresionAcostadoD.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFcActionPerformed(ActionEvent evt) {
        this.txtFr.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFcFocusGained(FocusEvent evt) {
        this.txtFc.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFcFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTallaActionPerformed(ActionEvent evt) {
        this.txtPeso.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTallaFocusGained(FocusEvent evt) {
        this.txtTalla.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTallaFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPesoActionPerformed(ActionEvent evt) {
        this.btnRojo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPesoFocusGained(FocusEvent evt) {
        this.txtPeso.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPesoFocusLost(FocusEvent evt) {
        calcularImc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFrActionPerformed(ActionEvent evt) {
        this.txtTemperatura.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFrFocusGained(FocusEvent evt) {
        this.txtFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFrFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTemperaturaActionPerformed(ActionEvent evt) {
        this.txtPs2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTemperaturaFocusGained(FocusEvent evt) {
        this.txtTemperatura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtTemperaturaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPs2ActionPerformed(ActionEvent evt) {
        this.txtTalla.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPs2FocusGained(FocusEvent evt) {
        this.txtPs2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPs2FocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtImcActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtImcFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtImcFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
        if (Principal.claseenfer.xjifagenda == null) {
            this.claseEnf.cargarPantalla("Agenda");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsAgendadoActionPerformed(ActionEvent evt) {
        if (this.JCHEsAgendado.isSelected()) {
            this.xesagendado = 1;
        } else {
            this.xesagendado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdverso1ActionPerformed(ActionEvent evt) {
        if (!this.txtAtencion.getText().isEmpty()) {
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", this.txtAtencion.getText(), 3);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe cargar una atencion", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaTestRespiratorioActionPerformed(ActionEvent evt) {
        this.JTP_Triage.setEnabledAt(1, true);
        this.JTP_Triage.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtMotivoConsultaKeyPressed(KeyEvent evt) {
        this.metodos.valiacionCaracterComillaSimpleTextPane(evt, this.txtMotivoConsulta);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtObservacionesKeyPressed(KeyEvent evt) {
        this.metodos.valiacionCaracterComillaSimpleTextPane(evt, this.txtObservaciones);
    }
}
