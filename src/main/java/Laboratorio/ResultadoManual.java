package Laboratorio;

import Acceso.Principal;
import General.Anular;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/ResultadoManual.class */
public class ResultadoManual extends JInternalFrame {
    public Persona frmPersona;
    private DefaultTableModel modeloE;
    private DefaultTableModel modeloP;
    private String sql;
    private Object[] fila;
    private String[][] parametros;
    private int filaGridE;
    private int filaGridP;
    private String[] listaBact;
    private CapturarResultado frmCR;
    private JTable gridE;
    private JTable gridP;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JPanel panelPersona;
    public JTextField txtFecha;
    private JDateChooser txtFechaResult;
    public JTextField txtNoOrden;
    private JTextArea txtObservaResult;
    private JEditorPane txtObservaciones;
    public JTextField txtRecepcion;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String noOrden = "";
    private String noRecep = "";
    private String noResult = "";
    private int cboLleno = 0;

    public ResultadoManual() {
        initComponents();
        iniciar();
        this.gridE.addMouseListener(new MouseAdapter() { // from class: Laboratorio.ResultadoManual.1
            public void mouseClicked(MouseEvent e) {
                ResultadoManual.this.filaGridE = ResultadoManual.this.gridE.rowAtPoint(e.getPoint());
                ResultadoManual.this.cargarProtocolos();
            }
        });
        this.gridP.addMouseListener(new MouseAdapter() { // from class: Laboratorio.ResultadoManual.2
            public void mouseClicked(MouseEvent e) {
                ResultadoManual.this.filaGridP = ResultadoManual.this.gridP.rowAtPoint(e.getPoint());
                if (e.getClickCount() > 1) {
                    ResultadoManual.this.cargarPantallaResultado();
                }
            }
        });
    }

    public void asignarResultado(String nbreResul, String codigo, String VrNum) {
        this.gridP.setValueAt(nbreResul, this.filaGridP, 3);
        this.gridP.setValueAt(codigo, this.filaGridP, 4);
        this.gridP.setValueAt(VrNum, this.filaGridP, 6);
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
        if (this.frmPersona.txtHistoria.getText() != null && !this.frmPersona.txtHistoria.getText().equals("")) {
            BuscarResultado frm = new BuscarResultado(null, true, this.frmPersona.getIdPersona(), "ResultadoManual", this);
            frm.setVisible(true);
        } else {
            this.metodos.mostrarMensaje("Por favor seleccione el Usuario a quien se consultará");
        }
    }

    public void buscarOrden() {
        String idPaciente = "0";
        this.sql = "SELECT f_ordenes.Id AS Orden, l_recepcion.Id AS Recep, f_ordenes.FechaOrden, l_recepcion.Observaciones, l_recepcion.Id_Paciente FROM l_recepcion INNER JOIN f_ordenes ON (l_recepcion.Id_OrdenFacturac = f_ordenes.Id) WHERE (  l_recepcion.Estado=0 AND f_ordenes.Id ='" + this.txtNoOrden.getText() + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.txtNoOrden.setText(rs.getString("Orden"));
                this.txtRecepcion.setText(rs.getString("Recep"));
                this.txtFecha.setText(this.metodos.formatoDMA.format((Date) rs.getDate("FechaOrden")));
                this.txtObservaciones.setText(rs.getString("Observaciones"));
                idPaciente = rs.getString("Id_Paciente");
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            cargarDetalleOrden();
            this.frmPersona.setIdPersona(idPaciente);
            this.frmPersona.buscar(1);
            traerNoResultado();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void traerNoResultado() {
        this.sql = "SELECT Id, FechaResult, Estado FROM l_resultados WHERE (Id_Recepcion ='" + this.txtRecepcion.getText() + "')";
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

    public void buscarRecep() {
        String idPaciente = "0";
        this.sql = "SELECT Id, FechaRecep, Observaciones, Id_Paciente, Id_OrdenFacturac FROM l_recepcion WHERE (Id ='" + this.txtRecepcion.getText() + "')";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.txtNoOrden.setText(rs.getString("Id_OrdenFacturac"));
                this.txtRecepcion.setText(rs.getString("Id"));
                this.txtFecha.setText(this.metodos.formatoDMA.format((Date) rs.getDate("FechaRecep")));
                this.txtObservaciones.setText(rs.getString("Observaciones"));
                idPaciente = rs.getString("Id_Paciente");
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            cargarDetalleOrden();
            this.frmPersona.setIdPersona(idPaciente);
            this.frmPersona.buscar(1);
            traerNoResultado();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarCombos() {
    }

    public void cargarDetalleOrden() {
        crearGridE();
        this.sql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre FROM l_detallerecepcion  INNER JOIN `l_recepcion` ON (l_detallerecepcion.`Id_Recepcion`= l_recepcion.Id)  INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id)  WHERE (l_recepcion.Estado =0 AND  l_detallerecepcion.Id_Recepcion ='" + this.txtRecepcion.getText() + "') ORDER BY g_procedimiento.Nbre ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modeloE.addRow(this.fila);
                this.modeloE.setValueAt(rs.getString(1), this.filaGridE, 0);
                this.modeloE.setValueAt(rs.getString(2), this.filaGridE, 1);
                String xsql = "SELECT l_resultados.Id FROM l_resultados INNER JOIN l_detalleresultado  ON (l_resultados.Id = l_detalleresultado.Id_Resultado)  INNER JOIN l_protocoloxprocedimiento  ON (l_protocoloxprocedimiento.Id = l_detalleresultado.Id_ProtocolProcedim) WHERE (l_resultados.Id_Recepcion ='" + this.txtRecepcion.getText() + "'  AND l_protocoloxprocedimiento.Id_Procedim ='" + rs.getString(1) + "') GROUP BY l_resultados.Id";
                ConsultasMySQL xc = new ConsultasMySQL();
                ResultSet xrs = xc.traerRs(xsql);
                String xidresultado = "";
                if (xrs.next()) {
                    xrs.first();
                    xidresultado = xrs.getString(1);
                }
                xrs.close();
                xc.cerrarConexionBd();
                this.modeloE.setValueAt(xidresultado, this.filaGridE, 2);
                this.filaGridE++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cargarPantallaResultado() {
        this.frmCR = new CapturarResultado(null, true, this.modeloP.getValueAt(this.filaGridP, 0).toString(), this);
        this.frmCR.setVisible(true);
    }

    public void cargarProtocolos() {
        crearGridP();
        this.sql = "SELECT l_protocolos.Id, l_protocolos.Nbre, l_detallerecepcion.Cantidad, l_protocoloxprocedimiento.Id as pxp, l_protocolos.`VrMinM`, l_protocolos.`VrMaxM`, l_protocolos.`VrMinF`, l_protocolos.`VrMaxF`  FROM l_detallerecepcion INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id)  INNER JOIN l_protocoloxprocedimiento ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) INNER JOIN l_protocolos ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) WHERE ( l_detallerecepcion.Id_Procedim ='" + this.modeloE.getValueAt(this.filaGridE, 0) + "' AND l_protocolos.EdadIni <='" + this.frmPersona.getEdad() + "' AND l_protocolos.EdadFin >='" + this.frmPersona.getEdad() + "') GROUP BY l_protocolos.Id ORDER BY l_protocolos.Nbre ASC";
        ResultSet rs = this.consultas.traerRs(this.sql);
        while (rs.next()) {
            try {
                this.modeloP.addRow(this.fila);
                this.modeloP.setValueAt(rs.getString("Id"), this.filaGridP, 0);
                this.modeloP.setValueAt(rs.getString("Nbre"), this.filaGridP, 1);
                this.modeloP.setValueAt(rs.getString("Cantidad"), this.filaGridP, 2);
                this.modeloP.setValueAt(rs.getString("pxp"), this.filaGridP, 5);
                this.modeloP.setValueAt(rs.getString("VrMinM"), this.filaGridP, 7);
                this.modeloP.setValueAt(rs.getString("VrMaxM"), this.filaGridP, 8);
                this.modeloP.setValueAt(rs.getString("VrMinF"), this.filaGridP, 9);
                this.modeloP.setValueAt(rs.getString("VrMaxF"), this.filaGridP, 10);
                this.filaGridP++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.consultas.cerrarConexionBd();
        cargarResultados();
    }

    private void cargarResultados() {
        for (int f = 0; f < this.modeloP.getRowCount(); f++) {
            if (this.modeloP.getValueAt(f, 5) != null) {
                String idProtxProc = this.modeloP.getValueAt(f, 5).toString();
                this.sql = "SELECT l_detalleresultado.Resultado, l_tiporesultado.Nbre, l_detalleresultado.VrNumerico  FROM l_detalleresultado INNER JOIN l_protocoloxprocedimiento  ON (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocoloxtiporesultado ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocoloxtiporesultado.Id_Protocolo) INNER JOIN l_tiporesultado ON (l_protocoloxtiporesultado.Id_TipoResultado = l_tiporesultado.Id) WHERE (l_protocoloxprocedimiento.Id ='" + idProtxProc + "' AND l_detalleresultado.Id_Resultado ='" + this.modeloE.getValueAt(this.gridE.getSelectedRow(), 2) + "' AND l_tiporesultado.Id  = l_detalleresultado.Resultado) GROUP BY l_protocoloxprocedimiento.Id";
                System.out.println("datos " + this.sql);
                ResultSet rs = this.consultas.traerRs(this.sql);
                try {
                    if (rs.next() && rs.getString(2) != null && !rs.getString(2).equals("")) {
                        this.modeloP.setValueAt(rs.getString("Resultado"), f, 4);
                        this.modeloP.setValueAt(rs.getString("Nbre"), f, 3);
                        this.modeloP.setValueAt(rs.getString("VrNumerico"), f, 6);
                    }
                    this.consultas.cerrarConexionBd();
                } catch (SQLException ex) {
                    this.consultas.mostrarErrorSQL(ex);
                }
            }
        }
    }

    private void cargarPanelPersonas() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(false);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 930, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    private void crearGridE() {
        this.modeloE = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", ""}) { // from class: Laboratorio.ResultadoManual.3
            Class[] types = {String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.gridE.setModel(this.modeloE);
        this.gridE.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridE.getColumnModel().getColumn(1).setPreferredWidth(550);
        this.gridE.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.gridE.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridE.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridE.getColumnModel().getColumn(1).setMinWidth(550);
        this.gridE.getColumnModel().getColumn(1).setMaxWidth(550);
        this.gridE.getColumnModel().getColumn(2).setMinWidth(0);
        this.gridE.getColumnModel().getColumn(2).setMaxWidth(0);
        this.filaGridE = 0;
    }

    private void crearGridP() {
        this.modeloP = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Protocolo", "Cantidad", "Resultado", "", "", "VrNumerico", "VRefM", "VRef1M", "VRefF", "VRef1F"}) { // from class: Laboratorio.ResultadoManual.4
            Class[] types = {String.class, String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.gridP.setModel(this.modeloP);
        this.gridP.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.gridP.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.gridP.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.gridP.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.gridP.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.gridP.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.gridP.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.gridP.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.gridP.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.gridP.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.gridP.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.gridP.getColumnModel().getColumn(0).setMinWidth(0);
        this.gridP.getColumnModel().getColumn(0).setMaxWidth(0);
        this.gridP.getColumnModel().getColumn(1).setMinWidth(200);
        this.gridP.getColumnModel().getColumn(1).setMaxWidth(200);
        this.gridP.getColumnModel().getColumn(2).setMinWidth(0);
        this.gridP.getColumnModel().getColumn(2).setMaxWidth(0);
        this.gridP.getColumnModel().getColumn(3).setMinWidth(0);
        this.gridP.getColumnModel().getColumn(3).setMaxWidth(0);
        this.gridP.getColumnModel().getColumn(4).setMinWidth(0);
        this.gridP.getColumnModel().getColumn(4).setMaxWidth(0);
        this.gridP.getColumnModel().getColumn(5).setMinWidth(0);
        this.gridP.getColumnModel().getColumn(5).setMaxWidth(0);
        this.gridP.getColumnModel().getColumn(6).setMinWidth(100);
        this.gridP.getColumnModel().getColumn(6).setMaxWidth(100);
        this.gridP.getColumnModel().getColumn(7).setMaxWidth(50);
        this.gridP.getColumnModel().getColumn(7).setMinWidth(50);
        this.gridP.getColumnModel().getColumn(8).setMaxWidth(50);
        this.gridP.getColumnModel().getColumn(8).setMinWidth(50);
        this.gridP.getColumnModel().getColumn(9).setMaxWidth(50);
        this.gridP.getColumnModel().getColumn(9).setMinWidth(50);
        this.gridP.getColumnModel().getColumn(10).setMaxWidth(50);
        this.gridP.getColumnModel().getColumn(10).setMinWidth(50);
        this.filaGridP = 0;
    }

    public void grabar(int op) {
        if (op == 1) {
            if (this.metodos.getPregunta("Esta seguro de Grabar el Resultado?") == 0 && validarDatos() == 1) {
                grabarCabecera();
                grabarDetalle();
                this.metodos.mostrarMensaje("Resultado Grabado");
                return;
            }
            return;
        }
        if (validarDatos() == 1) {
            grabarCabecera();
            grabarDetalle();
            this.metodos.mostrarMensaje("Resultado Grabado");
        }
    }

    private void grabarCabecera() {
        if (Principal.txtNo.getText() == null || Principal.txtNo.getText().equals("")) {
            this.metodos.marcarEstado(2);
            this.sql = "INSERT INTO l_resultados(Id_Recepcion, FechaResult, Id_Profesional, Observacion, fecha, UsuarioS) VALUES('" + this.txtRecepcion.getText() + "','" + this.metodos.formatoAMDH24.format(this.txtFechaResult.getDate()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.txtObservaResult.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.noResult = this.consultas.ejecutarSQLId(this.sql);
            Principal.txtNo.setText(this.noResult);
            this.consultas.cerrarConexionBd();
            mActualizarNResultadoItemsFacturacion();
            return;
        }
        mActualizarObservacionResultado();
    }

    private void grabarDetalle() {
        String xv1;
        String xv2;
        if (this.modeloP.getValueAt(this.gridP.getSelectedRow(), 4) != null) {
            if (this.frmPersona.cboSexo.getSelectedItem().equals("MASCULINO")) {
                xv1 = this.modeloP.getValueAt(this.gridP.getSelectedRow(), 7).toString();
                xv2 = this.modeloP.getValueAt(this.gridP.getSelectedRow(), 8).toString();
            } else {
                xv1 = this.modeloP.getValueAt(this.gridP.getSelectedRow(), 9).toString();
                xv2 = this.modeloP.getValueAt(this.gridP.getSelectedRow(), 10).toString();
            }
            this.sql = "INSERT INTO l_detalleresultado(Id_Resultado, Fecha, Bacteriologo, Id_ProtocolProcedim, Resultado, VrNumerico, VReferencia1, VReferencia2) VALUES('" + Principal.txtNo.getText() + "','" + this.metodos.formatoAMDH24.format(this.txtFechaResult.getDate()) + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.modeloP.getValueAt(this.gridP.getSelectedRow(), 5).toString() + "','" + this.modeloP.getValueAt(this.gridP.getSelectedRow(), 4).toString() + "','" + this.modeloP.getValueAt(this.gridP.getSelectedRow(), 6).toString() + "','" + xv1 + "','" + xv2 + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void mActualizarNResultadoItemsFacturacion() {
    }

    private void mActualizarObservacionResultado() {
        this.sql = "UPDATE l_detallerecepcion SET ObservacionResultado = '" + this.txtObservaResult.getText() + "' WHERE Id_Recepcion ='" + Principal.txtNo.getText() + "' and Id_Procedim='" + this.modeloE.getValueAt(this.gridE.getSelectedRow(), 0) + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void iniciar() {
        cargarCombos();
        cargarPanelPersonas();
        this.frmPersona.panelPersona.setEnabledAt(0, true);
        this.frmPersona.panelPersona.setSelectedIndex(0);
        nuevo();
    }

    public void imprimir() {
        String[][] parametros1 = new String[3][2];
        parametros1[0][0] = "id";
        parametros1[0][1] = this.txtRecepcion.getText();
        parametros1[1][0] = "SUBREPORT_DIR";
        parametros1[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros1[2][0] = "SUBREPORTFIRMA_DIR";
        parametros1[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Resultados", parametros1);
        } else {
            this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Resultados1", parametros1);
        }
        this.consultas.cerrarConexionBd();
    }

    public void nuevo() {
        this.metodos.limpiarDatosPrincipal();
        this.frmPersona.nuevo();
        this.txtNoOrden.setText("");
        this.txtRecepcion.setText("");
        this.txtFecha.setText("");
        this.txtObservaciones.setText("");
        this.noOrden = "";
        this.noRecep = "";
        this.txtFechaResult.setDate(this.metodos.getFechaActual());
        this.txtObservaResult.setText("");
        crearGridE();
        crearGridP();
        this.txtNoOrden.requestFocus();
    }

    private int validarDatos() {
        int retorno = 0;
        if (this.txtNoOrden.getText() == null || this.txtNoOrden.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite un Número de Orden / Factura");
            this.txtNoOrden.requestFocus();
        } else if (this.txtRecepcion.getText() == null || this.txtRecepcion.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione un Número de Recepción");
            this.txtRecepcion.requestFocus();
        } else if (this.txtFechaResult.getDate() == null) {
            this.metodos.mostrarMensaje("Por favor digite una Fecha válida");
            this.txtFechaResult.requestFocus();
        } else if (this.gridE.getRowCount() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione los Exámenes que desea cargar");
        } else if (this.gridP.getRowCount() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione los Protocolos");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtNoOrden = new JTextField();
        this.txtRecepcion = new JTextField();
        this.txtFecha = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.gridE = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.gridP = new JTable();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.jPanel2 = new JPanel();
        this.txtFechaResult = new JDateChooser();
        this.jScrollPane4 = new JScrollPane();
        this.txtObservaResult = new JTextArea();
        setClosable(true);
        setIconifiable(true);
        setTitle("RESULTADO MANUAL");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1200, 717));
        setMinimumSize(new Dimension(1200, 717));
        setName("ResultadoManual");
        setPreferredSize(new Dimension(1200, 717));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.ResultadoManual.5
            public void internalFrameActivated(InternalFrameEvent evt) {
                ResultadoManual.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                ResultadoManual.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout((LayoutManager) null);
        this.jPanel5.setBorder(BorderFactory.createBevelBorder(0));
        this.jPanel5.setLayout((LayoutManager) null);
        this.panelPersona.setBorder(BorderFactory.createBevelBorder(0));
        this.panelPersona.setMaximumSize(new Dimension(1000, 160));
        this.panelPersona.setMinimumSize(new Dimension(1000, 160));
        this.panelPersona.setPreferredSize(new Dimension(1000, 160));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 996, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 166, 32767));
        this.jPanel5.add(this.panelPersona);
        this.panelPersona.setBounds(10, 10, 940, 170);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE TOMA DE MUESTRAS", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.txtNoOrden.setFont(new Font("Arial", 1, 12));
        this.txtNoOrden.setForeground(new Color(0, 0, 153));
        this.txtNoOrden.setHorizontalAlignment(0);
        this.txtNoOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Orden / Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoOrden.addActionListener(new ActionListener() { // from class: Laboratorio.ResultadoManual.6
            public void actionPerformed(ActionEvent evt) {
                ResultadoManual.this.txtNoOrdenActionPerformed(evt);
            }
        });
        this.txtNoOrden.addFocusListener(new FocusAdapter() { // from class: Laboratorio.ResultadoManual.7
            public void focusLost(FocusEvent evt) {
                ResultadoManual.this.txtNoOrdenFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtNoOrden, new AbsoluteConstraints(10, 20, 140, 50));
        this.txtRecepcion.setFont(new Font("Arial", 1, 12));
        this.txtRecepcion.setForeground(new Color(0, 0, 153));
        this.txtRecepcion.setHorizontalAlignment(0);
        this.txtRecepcion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Recepción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtRecepcion.addActionListener(new ActionListener() { // from class: Laboratorio.ResultadoManual.8
            public void actionPerformed(ActionEvent evt) {
                ResultadoManual.this.txtRecepcionActionPerformed(evt);
            }
        });
        this.txtRecepcion.addFocusListener(new FocusAdapter() { // from class: Laboratorio.ResultadoManual.9
            public void focusLost(FocusEvent evt) {
                ResultadoManual.this.txtRecepcionFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtRecepcion, new AbsoluteConstraints(160, 20, 130, 50));
        this.txtFecha.setBackground((Color) null);
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setDisabledTextColor(new Color(0, 0, 0));
        this.txtFecha.setEnabled(false);
        this.txtFecha.addActionListener(new ActionListener() { // from class: Laboratorio.ResultadoManual.10
            public void actionPerformed(ActionEvent evt) {
                ResultadoManual.this.txtFechaActionPerformed(evt);
            }
        });
        this.txtFecha.addFocusListener(new FocusAdapter() { // from class: Laboratorio.ResultadoManual.11
            public void focusLost(FocusEvent evt) {
                ResultadoManual.this.txtFechaFocusLost(evt);
            }
        });
        this.jPanel1.add(this.txtFecha, new AbsoluteConstraints(300, 20, 120, 50));
        this.jPanel5.add(this.jPanel1);
        this.jPanel1.setBounds(10, 190, 430, 80);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "EXAMEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.gridE.setFont(new Font("Arial", 1, 12));
        this.gridE.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridE.setRowHeight(25);
        this.gridE.setSelectionBackground(new Color(255, 255, 255));
        this.gridE.setSelectionForeground(new Color(255, 0, 0));
        this.gridE.setSelectionMode(0);
        this.gridE.addKeyListener(new KeyAdapter() { // from class: Laboratorio.ResultadoManual.12
            public void keyPressed(KeyEvent evt) {
                ResultadoManual.this.gridEKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.gridE);
        this.jPanel5.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(10, 280, 510, 370);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "PROTOCOLO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.gridP.setFont(new Font("Arial", 1, 12));
        this.gridP.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.gridP.setRowHeight(25);
        this.gridP.setSelectionBackground(new Color(255, 255, 255));
        this.gridP.setSelectionForeground(new Color(255, 0, 0));
        this.gridP.setSelectionMode(0);
        this.gridP.addKeyListener(new KeyAdapter() { // from class: Laboratorio.ResultadoManual.13
            public void keyPressed(KeyEvent evt) {
                ResultadoManual.this.gridPKeyPressed(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.gridP);
        this.jPanel5.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(530, 280, 650, 370);
        this.txtObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.txtObservaciones.setForeground(new Color(0, 0, 153));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.jPanel5.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(960, 10, 220, 170);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL RESULTADO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtFechaResult.setDateFormatString("dd/MM/yyyy");
        this.txtFechaResult.setFont(new Font("Arial", 1, 12));
        this.jPanel2.add(this.txtFechaResult);
        this.txtFechaResult.setBounds(18, 22, 114, 40);
        this.txtObservaResult.setColumns(20);
        this.txtObservaResult.setFont(new Font("Arial", 1, 12));
        this.txtObservaResult.setRows(5);
        this.txtObservaResult.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane4.setViewportView(this.txtObservaResult);
        this.jPanel2.add(this.jScrollPane4);
        this.jScrollPane4.setBounds(180, 10, 550, 60);
        this.jPanel5.add(this.jPanel2);
        this.jPanel2.setBounds(440, 190, 740, 80);
        getContentPane().add(this.jPanel5);
        this.jPanel5.setBounds(0, 0, 1190, 670);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenFocusLost(FocusEvent evt) {
        this.noOrden = this.txtNoOrden.getText();
        buscarOrden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenActionPerformed(ActionEvent evt) {
        this.txtRecepcion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridEKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtRecepcionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtRecepcionFocusLost(FocusEvent evt) {
        this.noRecep = this.txtRecepcion.getText();
        buscarRecep();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridPKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }
}
