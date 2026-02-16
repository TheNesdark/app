package Laboratorio;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import java.beans.VetoableChangeListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFResultadoxExamen.class */
public class JIFResultadoxExamen extends JInternalFrame {
    public Persona frmPersona;
    public DefaultTableModel modeloE;
    public DefaultTableModel xmodeloprotocolo;
    private String sql;
    private Object[] fila;
    private String[][] parametros;
    private int filaGridP;
    private String[] xidbacteriologo;
    private String[] xidprocedimiento;
    private CapturarResultado frmCR;
    private File xfile;
    private JButton JBTCalcular;
    private JButton JBTCalcular1;
    private JButton JBTValidado;
    private JButton JBTValidado1;
    private JComboBox JCBProcedimiento;
    private JCheckBox JCHAlterado;
    private JCheckBox JCHRem;
    private JCheckBox JCHSoporte;
    private JDateChooser JDFecha;
    private JScrollPane JSPObservacion;
    public JTextField JTFEdad;
    public JTextField JTFFEcha;
    public JTextField JTFNRecepcion;
    private JTextField JTFRuta;
    public JTextField JTFSexo;
    public JTextField JTFUsuario;
    private JTextPane JTPObservacion;
    private JTable JTProtocolo;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel5;
    private JScrollPane jScrollPane3;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String noRecep = "";
    private String noResult = "";
    public int xedad = 0;
    public int xalterado = 0;
    public int xsoporte = 0;
    public int xremitido = 0;
    public String xsexo = "";
    private String idPaciente = "0";
    private long xidorden = 0;
    private boolean xestadog = true;

    public JIFResultadoxExamen() {
        initComponents();
        this.JDFecha.setDate(this.metodos.getFechaActual());
        iniciar();
    }

    public void mAsignarResultado(String nbreResul, String codigo, String VrNum) {
        this.xmodeloprotocolo.setValueAt(nbreResul, this.JTProtocolo.getSelectedRow(), 3);
        this.xmodeloprotocolo.setValueAt(codigo, this.JTProtocolo.getSelectedRow(), 4);
        this.xmodeloprotocolo.setValueAt(VrNum, this.JTProtocolo.getSelectedRow(), 6);
        grabar(2);
    }

    public void anular() {
        if (Principal.txtNo.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por Favor seleccione un Número de Resultado para Anular");
        } else if (Principal.txtEstado.getText().equals("ANULADA")) {
            this.metodos.mostrarMensaje("El Resultado ya se encuentra Anulado");
        } else {
            Anular frm = new Anular(null, true, "ResultadoManual", 24);
            frm.setVisible(true);
        }
    }

    public void anularRegistro(String razon) {
        this.sql = "UPDATE l_resultados SET Estado ='" + razon + "' WHERE Id='" + this.noResult + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.marcarEstado(1);
        this.metodos.mostrarMensaje("Resultado Manual Anulado");
    }

    public void buscar() {
    }

    private void traerNoResultado() {
        this.sql = "SELECT Id, FechaResult, Estado FROM l_resultados WHERE (Id_Recepcion ='" + this.JTFNRecepcion.getText() + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                Principal.txtNo.setText(rs.getString("Id"));
                Principal.txtFecha.setText(this.metodos.formatoDMA.format((Date) rs.getDate("FechaResult")));
                if (rs.getInt("Estado") == 0) {
                    this.metodos.marcarEstado(2);
                } else {
                    this.metodos.marcarEstado(1);
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void mBuscarDatosRecepcion() {
        if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            if (!this.JTFNRecepcion.getText().isEmpty()) {
                this.sql = "SELECT persona.NUsuario, persona.Edad, persona.NTipoEdad, persona.NSexo, DATE_FORMAT(l_recepcion.FechaRecep,'%d/%m/%Y') AS fecha, persona.Id_persona, persona.IdSexo, if(l_detallerecepcion.ObservacionResultado is null,'',l_detallerecepcion.ObservacionResultado) as ObsResult FROM l_recepcion INNER JOIN persona ON (l_recepcion.Id_Paciente = persona.Id_persona)INNER JOIN l_detallerecepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) WHERE (l_recepcion.Id ='" + this.JTFNRecepcion.getText() + "' AND l_recepcion.Estado in(0,1) AND l_detallerecepcion.Id_Procedim ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "')";
                ResultSet rs = this.consultas.traerRs(this.sql);
                try {
                    if (rs.next()) {
                        this.JTFUsuario.setText(rs.getString(1));
                        this.JTFEdad.setText(rs.getString(2) + " " + rs.getString(3) + "S");
                        this.JTFSexo.setText(rs.getString(4));
                        this.JTFFEcha.setText(rs.getString(5));
                        this.xedad = rs.getInt(2);
                        this.idPaciente = rs.getString(6);
                        this.xsexo = rs.getString(7);
                        this.JTPObservacion.setText(rs.getString(8));
                        mCargarProtocolos();
                        mCargarNoOrdenFact();
                        String xsql = "SELECT max(l_resultados.Id) AS IdResultado FROM l_detallerecepcion INNER JOIN l_recepcion ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN l_resultados ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (g_procedimiento.ValidarLab =1 AND l_recepcion.Id_Paciente ='" + this.idPaciente + "' AND l_recepcion.Estado in(0,1) AND g_procedimiento.Id ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "') GROUP BY g_procedimiento.Id";
                        ConsultasMySQL xct = new ConsultasMySQL();
                        ResultSet xrs = xct.traerRs(xsql);
                        if (xrs.next()) {
                            xrs.first();
                            int x = JOptionPane.showInternalConfirmDialog(this, "Usuario con examén anterior; \nDesea visualizar resultado?", "Visualizar Resultado", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                this.parametros = new String[4][2];
                                this.parametros[0][0] = "id";
                                this.parametros[0][1] = xrs.getString(1);
                                this.parametros[1][0] = "profesional";
                                this.parametros[1][1] = "";
                                this.parametros[2][0] = "SUBREPORT_DIR";
                                this.parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                                this.parametros[3][0] = "SUBREPORTFIRMA_DIR";
                                this.parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Resultados_Id", this.parametros);
                            }
                        }
                        xrs.close();
                        xct.cerrarConexionBd();
                    }
                    rs.close();
                    this.consultas.cerrarConexionBd();
                    return;
                } catch (SQLException ex) {
                    this.consultas.mostrarErrorSQL(ex);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar un N° Recepción", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNRecepcion.requestFocus();
        }
    }

    private void mCargarNoOrdenFact() {
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs("SELECT Id FROM f_ordenes WHERE (Id_OrdenRecep ='" + this.JTFNRecepcion.getText() + "' AND Estado =0)");
            if (xrs.next()) {
                xrs.first();
                this.xidorden = xrs.getLong(1);
                setXidorden(xrs.getLong(1));
            } else {
                setXidorden(new Long(0L).longValue());
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoxExamen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarCombos() {
        this.JCBProcedimiento.removeAllItems();
        this.xidprocedimiento = this.consultas.llenarCombo("SELECT g_procedimiento.Id, g_procedimiento.Nbre FROM l_detallerecepcion INNER JOIN l_recepcion   ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (DATE_FORMAT(FechaRecep,'%Y/%m/%d') ='" + this.metodos.formatoAMD.format(this.JDFecha.getDate()) + "' and g_procedimiento.EsRemitido='" + this.xremitido + "') GROUP BY g_procedimiento.Id ORDER BY g_procedimiento.Nbre ASC ", this.xidprocedimiento, this.JCBProcedimiento);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.consultas.cerrarConexionBd();
    }

    public void mCargarProtocolos() {
        crearGridP();
        this.sql = "SELECT l_protocolos.Id, l_protocolos.Nbre, l_detallerecepcion.Cantidad, l_protocoloxprocedimiento.Id as pxp, l_protocolos.VrMinM, l_protocolos.VrMaxM, l_protocolos.VrMinF, l_protocolos.VrMaxF, l_protocolos.AplicaFormula, l_protocolos.Id_Sql, l_protocoloxprocedimiento.CExamen FROM l_detallerecepcion INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN l_protocoloxprocedimiento ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) INNER JOIN l_protocolos ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) WHERE (l_detallerecepcion.Id_Procedim ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "'  AND l_protocolos.EdadIni <='" + this.xedad + "' AND l_protocolos.EdadFin >='" + this.xedad + "') GROUP BY l_protocolos.Id ORDER BY l_protocolos.Nbre ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    this.xmodeloprotocolo.addRow(this.fila);
                    this.xmodeloprotocolo.setValueAt(rs.getString("Id"), this.filaGridP, 0);
                    this.xmodeloprotocolo.setValueAt(rs.getString("Nbre"), this.filaGridP, 1);
                    this.xmodeloprotocolo.setValueAt(rs.getString("Cantidad"), this.filaGridP, 2);
                    this.xmodeloprotocolo.setValueAt(rs.getString("pxp"), this.filaGridP, 5);
                    this.xmodeloprotocolo.setValueAt(rs.getString("VrMinM"), this.filaGridP, 7);
                    this.xmodeloprotocolo.setValueAt(rs.getString("VrMaxM"), this.filaGridP, 8);
                    this.xmodeloprotocolo.setValueAt(rs.getString("VrMinF"), this.filaGridP, 9);
                    this.xmodeloprotocolo.setValueAt(rs.getString("VrMaxF"), this.filaGridP, 10);
                    this.xmodeloprotocolo.setValueAt(Boolean.valueOf(rs.getBoolean("AplicaFormula")), this.filaGridP, 12);
                    this.xmodeloprotocolo.setValueAt(rs.getString("Id_Sql"), this.filaGridP, 13);
                    this.xmodeloprotocolo.setValueAt(rs.getString("CExamen"), this.filaGridP, 15);
                    this.sql = "SELECT l_detalleresultado.Resultado, l_detalleresultado.VrNumerico, l_tiporesultado.Nbre, l_detalleresultado.Id_Resultado, l_resultados.Observacion, l_detalleresultado.Alterado  FROM l_detalleresultado INNER JOIN l_resultados  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_tiporesultado  ON (l_detalleresultado.Resultado = l_tiporesultado.Id) WHERE (l_resultados.Id_Recepcion ='" + this.JTFNRecepcion.getText() + "'  AND l_protocoloxprocedimiento.Id_Procedim ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "' AND l_protocoloxprocedimiento.Id_Protocolo ='" + rs.getString("Id") + "') ";
                    ConsultasMySQL xct = new ConsultasMySQL();
                    ResultSet xrs = xct.traerRs(this.sql);
                    if (xrs.next()) {
                        this.xmodeloprotocolo.setValueAt(xrs.getString(3), this.filaGridP, 3);
                        this.xmodeloprotocolo.setValueAt(xrs.getString(1), this.filaGridP, 4);
                        this.xmodeloprotocolo.setValueAt(xrs.getString(2), this.filaGridP, 6);
                        this.xmodeloprotocolo.setValueAt(Long.valueOf(xrs.getLong(4)), this.filaGridP, 11);
                        this.xmodeloprotocolo.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), this.filaGridP, 14);
                        Principal.txtNo.setText(xrs.getString(4));
                        this.xestadog = true;
                    } else {
                        this.xestadog = false;
                        this.xmodeloprotocolo.setValueAt(new Long(0L), this.filaGridP, 11);
                        this.xmodeloprotocolo.setValueAt("", this.filaGridP, 4);
                        this.xmodeloprotocolo.setValueAt("", this.filaGridP, 6);
                        this.xmodeloprotocolo.setValueAt(false, this.filaGridP, 14);
                    }
                    this.JTProtocolo.setDefaultRenderer(Object.class, new MiRender());
                    xrs.close();
                    xct.cerrarConexionBd();
                    this.filaGridP++;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            this.sql = "SELECT l_resultados.Id FROM l_detalleresultado INNER JOIN l_resultados  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_recepcion ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detallerecepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) WHERE (l_detallerecepcion.Id_Recepcion ='" + this.JTFNRecepcion.getText() + "' AND l_recepcion.Id_Paciente ='" + this.idPaciente + "' AND l_detallerecepcion.Id_Procedim ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "') GROUP BY l_detallerecepcion.Id_Procedim ";
            ResultSet xrs1 = this.consultas.traerRs(this.sql);
            System.out.println("Result " + this.sql);
            if (xrs1.next()) {
                Principal.txtNo.setText(xrs1.getString(1));
                this.noResult = xrs1.getString(1);
            } else {
                Principal.txtNo.setText("");
            }
            xrs1.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void mBuscar() {
        mCargarCombos();
    }

    private void cargarPantallaResultado() {
        this.frmCR = new CapturarResultado(null, true, this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 0).toString(), this);
        this.frmCR.setVisible(true);
    }

    public void mCalcularDato() {
        if (this.JTProtocolo.getRowCount() != -1) {
            for (int x = 0; x < this.JTProtocolo.getRowCount(); x++) {
                if (Long.valueOf(this.xmodeloprotocolo.getValueAt(x, 11).toString()).longValue() == 0 && Boolean.valueOf(this.xmodeloprotocolo.getValueAt(x, 12).toString()).booleanValue()) {
                    if (this.xmodeloprotocolo.getValueAt(x, 13).toString().equals("28")) {
                        if (!this.xmodeloprotocolo.getValueAt(x - 1, 6).toString().equals("") && !this.xmodeloprotocolo.getValueAt(x + 1, 6).toString().equals("")) {
                            this.xmodeloprotocolo.setValueAt(Principal.claselab.mFormula1RestaDosValores(Double.valueOf(this.xmodeloprotocolo.getValueAt(x + 1, 6).toString()).doubleValue(), Double.valueOf(this.xmodeloprotocolo.getValueAt(x - 1, 6).toString()).doubleValue()), x, 6);
                            this.xmodeloprotocolo.setValueAt("82", x, 4);
                            this.xmodeloprotocolo.setValueAt("Numerico", x, 3);
                        }
                    } else if (this.xmodeloprotocolo.getValueAt(x, 13).toString().equals("29")) {
                        if (!this.xmodeloprotocolo.getValueAt(x - 2, 6).toString().equals("") && !this.xmodeloprotocolo.getValueAt(x + 2, 6).toString().equals("") && !this.xmodeloprotocolo.getValueAt(x - 1, 6).toString().equals("")) {
                            this.xmodeloprotocolo.setValueAt(Principal.claselab.mFormula14(Double.valueOf(this.xmodeloprotocolo.getValueAt(x - 2, 6).toString()).doubleValue(), Double.valueOf(this.xmodeloprotocolo.getValueAt(x + 2, 6).toString()).doubleValue(), Double.valueOf(this.xmodeloprotocolo.getValueAt(x - 1, 6).toString()).doubleValue(), 1400.0d), x, 6);
                            this.xmodeloprotocolo.setValueAt("82", x, 4);
                            this.xmodeloprotocolo.setValueAt("Numerico", x, 3);
                        }
                    } else if (this.xmodeloprotocolo.getValueAt(x, 13).toString().equals("32") && !this.xmodeloprotocolo.getValueAt(x - 3, 6).toString().equals("") && !this.xmodeloprotocolo.getValueAt(x + 1, 6).toString().equals("")) {
                        this.xmodeloprotocolo.setValueAt(Principal.claselab.mFormula15(Double.valueOf(this.xmodeloprotocolo.getValueAt(x - 3, 6).toString()).doubleValue(), Double.valueOf(this.xmodeloprotocolo.getValueAt(x + 1, 6).toString()).doubleValue()), x, 6);
                        this.xmodeloprotocolo.setValueAt("82", x, 4);
                        this.xmodeloprotocolo.setValueAt("Numerico", x, 3);
                    }
                }
            }
        }
    }

    private void crearGridP() {
        this.xmodeloprotocolo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Protocolo", "Cantidad", "Resultado", "", "", "VrNumerico", "VrMinM", "VrMaxM", "VrMinF", "VrMaxF", "IdResultado", "AplicaFormula", "IdFormula", "Alterado", "NExamen"}) { // from class: Laboratorio.JIFResultadoxExamen.1
            Class[] types = {String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Boolean.class, Long.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTProtocolo.setModel(this.xmodeloprotocolo);
        this.JTProtocolo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTProtocolo.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTProtocolo.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTProtocolo.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.JTProtocolo.getColumnModel().getColumn(8).setPreferredWidth(40);
        this.JTProtocolo.getColumnModel().getColumn(9).setPreferredWidth(40);
        this.JTProtocolo.getColumnModel().getColumn(10).setPreferredWidth(40);
        this.JTProtocolo.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTProtocolo.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTProtocolo.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTProtocolo.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.JTProtocolo.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.filaGridP = 0;
    }

    public void grabar(int op) {
        if (op == 1) {
            if (validarDatos() == 1) {
                mActualizarEstadoProcedimiento();
                grabarCabecera();
                grabarDetalle();
                mBuscarDatosRecepcion();
                return;
            }
            return;
        }
        if (op == 2) {
            if (validarDatos() == 1) {
                mActualizarEstadoProcedimiento();
                grabarCabecera();
                grabarDetalle();
                mBuscarDatosRecepcion();
                return;
            }
            return;
        }
        if (op == 3 && validarDatos() == 1) {
            this.xestadog = true;
            mActualizarEstadoProcedimiento();
            grabarCabecera();
            this.xestadog = false;
            grabarDetalle1();
            mBuscarDatosRecepcion();
        }
    }

    private void grabarCabecera() {
        if (this.xestadog) {
            if (Principal.txtNo.getText() == null || Principal.txtNo.getText().equals("")) {
                this.metodos.marcarEstado(2);
                this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Observacion, Id_Profesional, Id_Especialidad, Soporte, Url, fecha, UsuarioS) VALUES('" + this.JTFNRecepcion.getText() + "','" + this.metodos.formatoAMDH24.format(this.JDFecha.getDate()) + "','" + this.JTPObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xsoporte + "','" + this.JTFRuta.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.noResult = this.consultas.ejecutarSQLId(this.sql);
                Principal.txtNo.setText(this.noResult);
                this.consultas.cerrarConexionBd();
                mActualizarNResultadoItemsFacturacion();
                mActualizarObservacionResultado();
                return;
            }
            mActualizarObservacionResultado();
        }
    }

    private void mActualizarObservacionResultado() {
        this.sql = "UPDATE l_detallerecepcion SET ObservacionResultado = '" + this.JTPObservacion.getText() + "' WHERE Id_Recepcion ='" + Principal.txtNo.getText() + "' and Id_Procedim='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void mVisualizarResultado() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Desea visualizar el resultado en PDF", "VISUALIZAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        if (x == 0) {
            String[][] parametros1 = new String[3][2];
            parametros1[0][0] = "id";
            parametros1[0][1] = this.JTFNRecepcion.getText();
            parametros1[1][0] = "SUBREPORT_DIR";
            parametros1[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
            parametros1[2][0] = "SUBREPORTFIRMA_DIR";
            parametros1[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Resultados", parametros1);
            } else {
                this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Resultados1", parametros1);
            }
        }
    }

    public void mImprimir() {
        mVisualizarResultado();
    }

    private void grabarDetalle() {
        String xv1;
        String xv2;
        int xalterado1 = 0;
        if (Boolean.valueOf(this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 14).toString()).booleanValue()) {
            xalterado1 = 1;
        }
        if (this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 4) != null) {
            if (this.xestadog) {
                if (this.JTFSexo.getText().equals("MASCULINO")) {
                    xv1 = this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 7).toString();
                    xv2 = this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 8).toString();
                } else {
                    xv1 = this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 9).toString();
                    xv2 = this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 10).toString();
                }
                this.sql = "INSERT IGNORE INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo, Id_Especialidad, Id_ProtocolProcedim, Resultado, VrNumerico, Alterado, VReferencia1, VReferencia2) VALUES('" + Principal.txtNo.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 5).toString() + "','" + this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 4).toString() + "','" + this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 6).toString() + "','" + xalterado1 + "','" + xv1 + "','" + xv2 + "')";
            } else {
                this.sql = "update l_detalleresultado set Fecha='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Bacteriologo='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Resultado='" + this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 4).toString() + "', VrNumerico='" + this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 6).toString() + "', Alterado='" + xalterado1 + "', VReferencia1='', VReferencia2='' where Id_Resultado='" + this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 11).toString() + "' and l_detalleresultado.Id_ProtocolProcedim='" + this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 5).toString() + "'";
            }
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            if (Integer.valueOf(this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 15).toString()).intValue() != 0) {
                Principal.claselab.mGrabarHistorico(this.JTFNRecepcion.getText(), this.idPaciente, this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 5).toString(), Integer.valueOf(this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 15).toString()).intValue());
            }
        }
    }

    private void grabarDetalle1() {
        String xvalor1;
        String xvalor2;
        for (int f = 0; f < this.xmodeloprotocolo.getRowCount(); f++) {
            if (!this.xestadog && Long.valueOf(this.xmodeloprotocolo.getValueAt(f, 11).toString()).longValue() == 0 && !this.xmodeloprotocolo.getValueAt(f, 4).toString().equals("")) {
                int xalterado1 = 0;
                if (Boolean.valueOf(this.xmodeloprotocolo.getValueAt(f, 14).toString()).booleanValue()) {
                    xalterado1 = 1;
                }
                if (this.JTFSexo.getText().equals("MASCULINO")) {
                    xvalor1 = this.xmodeloprotocolo.getValueAt(f, 7).toString();
                    xvalor2 = this.xmodeloprotocolo.getValueAt(f, 8).toString();
                } else {
                    xvalor1 = this.xmodeloprotocolo.getValueAt(f, 9).toString();
                    xvalor2 = this.xmodeloprotocolo.getValueAt(f, 10).toString();
                }
                this.sql = "INSERT  IGNORE INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo,Id_Especialidad, Id_ProtocolProcedim, Resultado, VrNumerico, VReferencia1, VReferencia2, ALterado ) VALUES('" + Principal.txtNo.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmodeloprotocolo.getValueAt(f, 5).toString() + "','" + this.xmodeloprotocolo.getValueAt(f, 4).toString() + "','" + this.xmodeloprotocolo.getValueAt(f, 6).toString() + "','" + xvalor1 + "','" + xvalor2 + "','" + xalterado1 + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    private void iniciar() {
        nuevo();
        mCargarCombos();
    }

    public void nuevo() {
        this.xestadog = false;
        this.metodos.limpiarDatosPrincipal();
        this.JTFUsuario.setText("");
        this.JTFNRecepcion.setText("");
        this.JTFFEcha.setText("");
        this.JCHAlterado.setSelected(false);
        this.JTFEdad.setText("");
        this.JTFSexo.setText("");
        this.JTPObservacion.setText("");
        this.xalterado = 0;
        this.xsoporte = 0;
        this.JTFRuta.setText("");
        this.idPaciente = "0";
        crearGridP();
        this.JTFNRecepcion.requestFocus();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.JTFNRecepcion.getText() == null || this.JTFNRecepcion.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite un Número de Orden / Factura");
            this.JTFNRecepcion.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private void mActualizarEstadoProcedimiento() {
        String xsql = "update l_detallerecepcion set Resultado=1, Alterado='" + this.xalterado + "', ObservacionResultado='" + this.JTPObservacion.getText() + "', FechaResultado='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "' where Id_Recepcion='" + this.JTFNRecepcion.getText() + "' and Id_Procedim='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "'";
        this.consultas.ejecutarSQL(xsql);
        this.consultas.cerrarConexionBd();
    }

    public long getXidorden() {
        return this.xidorden;
    }

    public void setXidorden(long xidorden) {
        this.xidorden = xidorden;
    }

    private void mActualizarNResultadoItemsFacturacion() {
        if (getXidorden() > 0) {
            this.sql = "update f_itemordenesproced set Id_ResultadoLab='" + Principal.txtNo.getText() + "' where Id_Ordenes='" + this.xidorden + "' and Id_Procedimiento='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "'";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JTFUsuario = new JTextField();
        this.JTFNRecepcion = new JTextField();
        this.JTFFEcha = new JTextField();
        this.JCBProcedimiento = new JComboBox();
        this.JTFEdad = new JTextField();
        this.JTFSexo = new JTextField();
        this.JDFecha = new JDateChooser();
        this.JCHRem = new JCheckBox();
        this.jScrollPane3 = new JScrollPane();
        this.JTProtocolo = new JTable();
        this.jPanel2 = new JPanel();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JBTCalcular = new JButton();
        this.JCHAlterado = new JCheckBox();
        this.JBTCalcular1 = new JButton();
        this.JTFRuta = new JTextField();
        this.JCHSoporte = new JCheckBox();
        this.JBTValidado = new JButton();
        this.JBTValidado1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("RESULTADO POR EXAMEN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifresultadoxexamen");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.JIFResultadoxExamen.2
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFResultadoxExamen.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }
        });
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.jPanel1.setFont(new Font("Arial", 0, 12));
        this.JTFUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFUsuario.setForeground(new Color(0, 0, 153));
        this.JTFUsuario.setHorizontalAlignment(0);
        this.JTFUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUsuario.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFUsuario.setEnabled(false);
        this.JTFNRecepcion.setFont(new Font("Arial", 1, 12));
        this.JTFNRecepcion.setForeground(new Color(0, 0, 153));
        this.JTFNRecepcion.setHorizontalAlignment(0);
        this.JTFNRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Recepción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNRecepcion.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.3
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JTFNRecepcionActionPerformed(evt);
            }
        });
        this.JTFNRecepcion.addFocusListener(new FocusAdapter() { // from class: Laboratorio.JIFResultadoxExamen.4
            public void focusLost(FocusEvent evt) {
                JIFResultadoxExamen.this.JTFNRecepcionFocusLost(evt);
            }
        });
        this.JTFFEcha.setFont(new Font("Arial", 1, 12));
        this.JTFFEcha.setHorizontalAlignment(0);
        this.JTFFEcha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFEcha.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFFEcha.setEnabled(false);
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEdad.setFont(new Font("Arial", 1, 12));
        this.JTFEdad.setForeground(new Color(0, 0, 153));
        this.JTFEdad.setHorizontalAlignment(0);
        this.JTFEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEdad.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFEdad.setEnabled(false);
        this.JTFSexo.setFont(new Font("Arial", 1, 12));
        this.JTFSexo.setForeground(new Color(0, 0, 153));
        this.JTFSexo.setHorizontalAlignment(0);
        this.JTFSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSexo.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFSexo.setEnabled(false);
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Tahoma", 0, 14));
        this.JDFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFResultadoxExamen.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFResultadoxExamen.this.JDFechaPropertyChange(evt);
            }
        });
        this.JCHRem.setFont(new Font("Arial", 1, 12));
        this.JCHRem.setText("Rem?");
        this.JCHRem.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.6
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JCHRemActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHRem).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFecha, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcedimiento, -2, 663, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNRecepcion, -2, 130, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFUsuario, -2, 514, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFEdad, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFSexo, -1, 217, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFEcha, -2, 129, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBProcedimiento, -2, 48, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFecha, -2, 51, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNRecepcion, -2, 50, -2).addComponent(this.JCHRem)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFEcha, -2, 50, -2).addComponent(this.JTFSexo, -2, 50, -2)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUsuario, -2, 50, -2).addComponent(this.JTFEdad, -2, 50, -2))).addContainerGap()));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "PROTOCOLO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTProtocolo.setFont(new Font("Arial", 1, 12));
        this.JTProtocolo.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTProtocolo.setRowHeight(25);
        this.JTProtocolo.setSelectionBackground(new Color(255, 255, 255));
        this.JTProtocolo.setSelectionForeground(new Color(255, 0, 0));
        this.JTProtocolo.setSelectionMode(0);
        this.JTProtocolo.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFResultadoxExamen.7
            public void mouseClicked(MouseEvent evt) {
                JIFResultadoxExamen.this.JTProtocoloMouseClicked(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                JIFResultadoxExamen.this.JTProtocoloMouseReleased(evt);
            }
        });
        this.JTProtocolo.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JIFResultadoxExamen.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFResultadoxExamen.this.JTProtocoloPropertyChange(evt);
            }
        });
        this.JTProtocolo.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFResultadoxExamen.9
            public void keyPressed(KeyEvent evt) {
                JIFResultadoxExamen.this.JTProtocoloKeyPressed(evt);
            }
        });
        this.JTProtocolo.addVetoableChangeListener(new VetoableChangeListener() { // from class: Laboratorio.JIFResultadoxExamen.10
            /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.PropertyVetoException */
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                JIFResultadoxExamen.this.JTProtocoloVetoableChange(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTProtocolo);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE RESULTADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacion).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -2, -1, -2));
        this.JBTCalcular.setFont(new Font("Arial", 1, 12));
        this.JBTCalcular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/calculadora.png")));
        this.JBTCalcular.setText("Calcular");
        this.JBTCalcular.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.11
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JBTCalcularActionPerformed(evt);
            }
        });
        this.JCHAlterado.setFont(new Font("Arial", 1, 12));
        this.JCHAlterado.setText("Exámen Alterado?");
        this.JCHAlterado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.12
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JCHAlteradoActionPerformed(evt);
            }
        });
        this.JBTCalcular1.setFont(new Font("Arial", 1, 12));
        this.JBTCalcular1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Inventario29x27.png")));
        this.JBTCalcular1.setText("Plantilla");
        this.JBTCalcular1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.13
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JBTCalcular1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setEnabled(false);
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFResultadoxExamen.14
            public void mouseClicked(MouseEvent evt) {
                JIFResultadoxExamen.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.15
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JCHSoporte.setFont(new Font("Arial", 1, 12));
        this.JCHSoporte.setText("Soporte?");
        this.JCHSoporte.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.16
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JCHSoporteActionPerformed(evt);
            }
        });
        this.JBTValidado.setFont(new Font("Arial", 1, 12));
        this.JBTValidado.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTValidado.setText("Validar");
        this.JBTValidado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.17
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JBTValidadoActionPerformed(evt);
            }
        });
        this.JBTValidado1.setFont(new Font("Arial", 1, 12));
        this.JBTValidado1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBTValidado1.setText("V/Recepción");
        this.JBTValidado1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFResultadoxExamen.18
            public void actionPerformed(ActionEvent evt) {
                JIFResultadoxExamen.this.JBTValidado1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 1027, 32767).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JBTCalcular, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCalcular1, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTValidado, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, 32767).addComponent(this.JBTValidado1, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHSoporte).addComponent(this.JCHAlterado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 288, -2))).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 305, -2).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTCalcular1, -2, 50, -2).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCalcular, -2, 50, -2).addComponent(this.JBTValidado, -2, 50, -2).addComponent(this.JBTValidado1, -2, 50, -2)).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFRuta, GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JCHSoporte).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHAlterado)))).addGap(14, 14, 14)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel5, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel5, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNRecepcionActionPerformed(ActionEvent evt) {
        this.JTFNRecepcion.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNRecepcionFocusLost(FocusEvent evt) {
        this.noRecep = this.JTFNRecepcion.getText();
        mBuscarDatosRecepcion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProtocoloMouseClicked(MouseEvent evt) {
        if (this.JTProtocolo.getSelectedRow() != -1) {
            System.out.println("numero  " + this.JTProtocolo.getSelectedColumn());
            if (this.JTProtocolo.getSelectedColumn() == 3) {
                mEntrarDato(evt.getClickCount());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCalcularActionPerformed(ActionEvent evt) {
        if (this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()].equals("903816") && !this.JTFNRecepcion.getText().isEmpty()) {
            try {
                Double ct = null;
                Double hdl = null;
                Double vldl = null;
                DecimalFormat xformato = new DecimalFormat("#,##0.00");
                ResultSet rs = this.consultas.traerRs("SELECT Valor, Resultado FROM l_calculoVLDL WHERE (Id_Recepcion ='" + this.JTFNRecepcion.getText() + "')");
                if (rs.next()) {
                    vldl = Double.valueOf(rs.getDouble(1));
                    this.xmodeloprotocolo.setValueAt("Numerico", 1, 3);
                    this.xmodeloprotocolo.setValueAt(rs.getString(2), 1, 4);
                    this.xmodeloprotocolo.setValueAt(rs.getString(1), 1, 6);
                }
                rs.close();
                this.consultas.cerrarConexionBd();
                ResultSet rs2 = this.consultas.traerRs("SELECT VrNumerico, Resultado FROM l_valorColesterolT WHERE (Id_Recepcion ='" + this.JTFNRecepcion.getText() + "')");
                if (rs2.next()) {
                    ct = Double.valueOf(rs2.getDouble(1));
                }
                rs2.close();
                this.consultas.cerrarConexionBd();
                ResultSet rs3 = this.consultas.traerRs("SELECT VrNumerico , Resultado FROM l_valorColesterolHDL WHERE (Id_Recepcion ='" + this.JTFNRecepcion.getText() + "')");
                if (rs3.next()) {
                    hdl = Double.valueOf(rs3.getDouble(1));
                }
                rs3.close();
                this.consultas.cerrarConexionBd();
                System.out.println("" + ct + " " + hdl + " " + vldl);
                this.xmodeloprotocolo.setValueAt("Numerico", 2, 3);
                this.xmodeloprotocolo.setValueAt(82, 2, 4);
                this.xmodeloprotocolo.setValueAt(xformato.format(ct.doubleValue() / hdl.doubleValue()).replaceAll(",", "."), 2, 6);
                this.xmodeloprotocolo.setValueAt("Numerico", 0, 3);
                this.xmodeloprotocolo.setValueAt(82, 0, 4);
                this.xmodeloprotocolo.setValueAt(xformato.format(ct.doubleValue() - (hdl.doubleValue() + vldl.doubleValue())).replaceAll(",", "."), 0, 6);
            } catch (SQLException ex) {
                Logger.getLogger(JIFResultadoxExamen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAlteradoActionPerformed(ActionEvent evt) {
        if (this.JCHAlterado.isSelected()) {
            this.xalterado = 1;
        } else {
            this.xalterado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProtocoloMouseReleased(MouseEvent evt) {
        if (this.JTProtocolo.getSelectedRow() != -1) {
            System.out.println("numero  " + this.JTProtocolo.getSelectedColumn());
            if (this.JTProtocolo.getSelectedColumn() == 3) {
                mEntrarDato(evt.getClickCount());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCalcular1ActionPerformed(ActionEvent evt) {
        if (this.JCBProcedimiento.getSelectedIndex() != -1 && this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()].equals("907106")) {
            this.xmodeloprotocolo.setValueAt("Negativo", 2, 3);
            this.xmodeloprotocolo.setValueAt("12", 2, 4);
            this.xmodeloprotocolo.setValueAt("12", 2, 6);
            this.xmodeloprotocolo.setValueAt("Negativo", 5, 3);
            this.xmodeloprotocolo.setValueAt("12", 5, 4);
            this.xmodeloprotocolo.setValueAt("12", 5, 6);
            this.xmodeloprotocolo.setValueAt("Negativo", 22, 3);
            this.xmodeloprotocolo.setValueAt("12", 22, 4);
            this.xmodeloprotocolo.setValueAt("12", 22, 6);
            this.xmodeloprotocolo.setValueAt("Negativo", 25, 3);
            this.xmodeloprotocolo.setValueAt("12", 25, 4);
            this.xmodeloprotocolo.setValueAt("12", 25, 6);
            this.xmodeloprotocolo.setValueAt("Negativo", 27, 3);
            this.xmodeloprotocolo.setValueAt("12", 27, 4);
            this.xmodeloprotocolo.setValueAt("12", 27, 6);
            this.xmodeloprotocolo.setValueAt("Negativo", 28, 3);
            this.xmodeloprotocolo.setValueAt("12", 28, 4);
            this.xmodeloprotocolo.setValueAt("12", 28, 6);
            this.xmodeloprotocolo.setValueAt("Negativo", 19, 3);
            this.xmodeloprotocolo.setValueAt("12", 19, 4);
            this.xmodeloprotocolo.setValueAt("12", 19, 6);
            this.xmodeloprotocolo.setValueAt("", 18, 3);
            this.xmodeloprotocolo.setValueAt("82", 18, 4);
            this.xmodeloprotocolo.setValueAt("", 18, 6);
            this.xmodeloprotocolo.setValueAt("0.2", 29, 3);
            this.xmodeloprotocolo.setValueAt("82", 29, 4);
            this.xmodeloprotocolo.setValueAt("82", 29, 6);
            System.out.println(this.xmodeloprotocolo.getValueAt(2, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.JCHSoporte.setSelected(true);
            this.xsoporte = 1;
            JFileChooser xfilec = new JFileChooser("S:\\");
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getPath());
                this.JTFRuta.setText(this.metodos.mTraerUrlBD(this.xfile.getPath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSoporteActionPerformed(ActionEvent evt) {
        if (this.JCHSoporte.isSelected()) {
            this.JTFRuta.setEnabled(true);
            this.xsoporte = 1;
        } else {
            this.JTFRuta.setEnabled(false);
            this.JTFRuta.setText("");
            this.xsoporte = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRemActionPerformed(ActionEvent evt) {
        if (this.JCHRem.isSelected()) {
            this.xremitido = 1;
            mBuscar();
        } else {
            this.xremitido = 0;
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProtocoloKeyPressed(KeyEvent evt) {
        if (this.JTProtocolo.getSelectedRow() != -1) {
            if (evt.getKeyCode() == 127) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar el resultado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    String xsql = "delete from l_detalleresultado WHERE (Id_Resultado ='" + Principal.txtNo.getText() + "' AND Id_ProtocolProcedim ='" + this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 5) + "')";
                    this.consultas.ejecutarSQL(xsql);
                    this.consultas.cerrarConexionBd();
                    mBuscarDatosRecepcion();
                    return;
                }
                return;
            }
            if (evt.getKeyCode() == 10 && this.JTProtocolo.getSelectedColumn() == 3) {
                mEntrarDato(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValidadoActionPerformed(ActionEvent evt) {
        try {
            this.sql = "SELECT ValidadoLab FROM l_detallerecepcion WHERE (Id_Recepcion ='" + this.JTFNRecepcion.getText() + "' AND Id_Procedim ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "') ";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                if (xrs.getBoolean(1)) {
                    JOptionPane.showInternalMessageDialog(this, "Examen ya validado", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } else {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Desea validar el resultado?", "VISUALIZAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        ConsultasMySQL xct = new ConsultasMySQL();
                        this.sql = "update l_detallerecepcion set ValidadoLab=1 WHERE (Id_Recepcion ='" + this.JTFNRecepcion.getText() + "' AND Id_Procedim ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "') ";
                        xct.ejecutarSQL(this.sql);
                        xct.cerrarConexionBd();
                    }
                }
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFResultadoxExamen.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTValidado1ActionPerformed(ActionEvent evt) {
        if (!this.JTFNRecepcion.getText().isEmpty()) {
            Principal.claselab.cargarPantalla("ResultadoManual");
            Principal.claselab.frmResultManual.txtRecepcion.setText(this.JTFNRecepcion.getText());
            Principal.claselab.frmResultManual.buscarRecep();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaPropertyChange(PropertyChangeEvent evt) {
        mBuscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProtocoloPropertyChange(PropertyChangeEvent evt) {
        mCalcularDato();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProtocoloVetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        mCalcularDato();
    }

    private void mEntrarDato(int x) {
        if (x >= 1) {
            System.out.println(this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 3));
            if (this.xmodeloprotocolo.getValueAt(this.JTProtocolo.getSelectedRow(), 3) != null) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Resultado grabado, \nDesea modificarlo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xestadog = false;
                    cargarPantallaResultado();
                    return;
                }
                return;
            }
            this.xestadog = true;
            cargarPantallaResultado();
            this.xestadog = false;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFResultadoxExamen$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            boolean xvalor = Boolean.valueOf(table.getValueAt(row, 14).toString()).booleanValue();
            if (xvalor) {
                cell.setBackground(new Color(204, 255, 204));
                cell.setForeground(new Color(0, 0, 0));
            } else {
                cell.setBackground(new Color(255, 255, 255));
                cell.setForeground(new Color(0, 0, 0));
            }
            return cell;
        }
    }
}
