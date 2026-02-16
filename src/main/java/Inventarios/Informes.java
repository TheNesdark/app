package Inventarios;

import Acceso.Principal;
import Utilidades.Autocomplete;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformacionInventario;
import com.genoma.plus.jpa.service.IBodegaDAO;
import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/Informes.class */
public class Informes extends JInternalFrame {
    private String[] listaCombo;
    private String[] listaUsuario;
    private String[][] parametros;
    private String titulo;
    private String nbreArchivo;
    private JButton JBTExportar;
    private JCheckBox JCH_VisualizacionDetalle;
    private JTextField JTFRuta;
    private JButton btnAceptar;
    private JButton btnSalir;
    private ButtonGroup buttonGroup2;
    private JComboBox cboBodega;
    private JComboBox cboDespacho;
    private JComboBox cboSalida;
    private JComboBox cboTraslado;
    private JComboBox cboUsuario;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JLabel lblTitulo;
    private JSpinner txtEntrada;
    private JSpinner txtFaltante;
    private JCalendar txtFechaFin;
    private JCalendar txtFechaIni;
    private JTextField txtNoFinal;
    private JTextField txtNoInicial;
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private IBodegaDAO iBodegaDAO = (IBodegaDAO) Principal.contexto.getBean(IBodegaDAO.class);

    public Informes(String xTitulo) {
        this.titulo = xTitulo;
        initComponents();
        this.cboBodega.setEditable(true);
        JTextComponent editor = this.cboBodega.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboBodega));
        validar();
    }

    public void activarCalendarios(int opcion) {
        if (opcion == 1) {
            this.txtFechaIni.setEnabled(true);
            this.txtFechaFin.setEnabled(true);
        } else if (opcion == 2) {
            this.txtFechaIni.setEnabled(true);
        }
    }

    private void activarCampos() {
        this.txtNoInicial.setEnabled(true);
        this.txtNoFinal.setEnabled(true);
    }

    private void cargarInforme() {
        List<IInformacionInventario> informacionInventarios;
        if (this.lblTitulo.getText().equals("INVENTARIO GENERAL POR AREA")) {
            List<Integer> listIdBodega = new ArrayList<>();
            listIdBodega.add(Integer.valueOf(this.listaCombo[this.cboBodega.getSelectedIndex()]));
            if (this.JCH_VisualizacionDetalle.isSelected()) {
                informacionInventarios = this.iBodegaDAO.listaInventarioAgrupadoPorIbodegaIdSuministroLote(this.txtFechaFin.getDate(), listIdBodega, 0);
            } else {
                informacionInventarios = this.iBodegaDAO.listaInventarioAgrupadoPorIdbodegaIdSuministro(this.txtFechaFin.getDate(), listIdBodega, 1, "");
            }
            ImpresionInfomes inventarioGeneral = new ImpresionInfomes();
            inventarioGeneral.inventarioGeneral(informacionInventarios, true, this.txtFechaFin.getDate(), this.cboBodega.getSelectedItem().toString(), Boolean.valueOf(this.JCH_VisualizacionDetalle.isSelected()));
        } else if (this.lblTitulo.getText().equals("PROXIMOS A VENCER")) {
            this.parametros = new String[8][2];
            this.parametros[0][0] = "fechaInicial";
            this.parametros[0][1] = this.xmt.formatoAMD.format(this.txtFechaIni.getDate());
            this.parametros[1][0] = "fechaFinal";
            this.parametros[1][1] = this.xmt.formatoAMD.format(this.txtFechaFin.getDate());
            this.parametros[2][0] = "idBodega";
            this.parametros[2][1] = this.listaCombo[this.cboBodega.getSelectedIndex()].toString();
            this.parametros[3][0] = "nbreBodega";
            this.parametros[3][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[4][0] = "ruta";
            this.parametros[4][1] = this.xmt.getRutaRep();
            this.parametros[5][0] = "SUBREPORT_DIR";
            this.parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[6][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.parametros[7][0] = "nbreUsuario";
            this.parametros[7][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.nbreArchivo = Principal.informacionIps.getPrefijoReportes() + "I_ProximosaVencer";
        } else if (this.lblTitulo.getText().equals("ENTRADA A INVENTARIO")) {
            this.parametros = new String[5][2];
            this.parametros[0][0] = "numero";
            this.parametros[0][1] = this.txtEntrada.getValue().toString();
            this.parametros[1][0] = "nbreUsuario";
            this.parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_EntradaAInventario";
        } else if (this.lblTitulo.getText().equals("PENDIENTE POR DESPACHO")) {
            this.parametros = new String[5][2];
            this.parametros[0][0] = "faltante";
            this.parametros[0][1] = this.txtFaltante.getValue().toString();
            this.parametros[1][0] = "NbreUsuario";
            this.parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getDirectorioExportacion() + "Reportes" + this.xmt.getBarra();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getDirectorioExportacion() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getDirectorioExportacion() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_PendientesPorDespacho";
        } else if (this.lblTitulo.getText().equals("LISTADO GENERAL DE PENDIENTES POR FECHA")) {
            this.parametros = new String[7][2];
            this.parametros[0][0] = "idBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[1][0] = "nbreBodega";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "fechaIni";
            this.parametros[2][1] = this.xmt.formatoAMD.format(this.txtFechaIni.getDate());
            this.parametros[3][0] = "fechaFin";
            this.parametros[3][1] = this.xmt.formatoAMD.format(this.txtFechaFin.getDate());
            this.parametros[4][0] = "ruta";
            this.parametros[4][1] = this.xmt.getRutaRep();
            this.parametros[5][0] = "SUBREPORT_DIR";
            this.parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[6][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_ListadoGeneralDePendientesPorFecha";
        } else if (this.lblTitulo.getText().equals("LISTADO DE PENDIENTES SIN ENTREGAR POR FECHA")) {
            this.parametros = new String[7][2];
            this.parametros[0][0] = "idBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[1][0] = "nbreBodega";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "fechaIni";
            this.parametros[2][1] = this.xmt.formatoAMD.format(this.txtFechaIni.getDate());
            this.parametros[3][0] = "fechaFin";
            this.parametros[3][1] = this.xmt.formatoAMD.format(this.txtFechaFin.getDate());
            this.parametros[4][0] = "ruta";
            this.parametros[4][1] = this.xmt.getRutaRep();
            this.parametros[5][0] = "SUBREPORT_DIR";
            this.parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[6][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_ListadoDePendientesSinEntregarPorFecha";
        } else if (this.lblTitulo.getText().equals("TRASLADOS")) {
            this.parametros = new String[5][2];
            this.parametros[0][0] = "numero";
            this.parametros[0][1] = this.listaCombo[this.cboTraslado.getSelectedIndex()];
            this.parametros[1][0] = "nbreUsuario";
            this.parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_Traslados";
        } else if (this.lblTitulo.getText().equals("SALIDAS")) {
            this.parametros = new String[5][2];
            this.parametros[0][0] = "IdSalida";
            this.parametros[0][1] = this.cboSalida.getSelectedItem().toString();
            this.parametros[1][0] = "BodegaOrigen";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.listaCombo[this.cboSalida.getSelectedIndex()].toString().equals("1")) {
                this.nbreArchivo = "I_SalidasABodega";
            } else {
                this.nbreArchivo = "I_SalidasProveedores";
            }
        } else if (this.lblTitulo.getText().equals("LISTADO DE PRODUCTOS")) {
            this.parametros = new String[5][2];
            this.parametros[0][0] = "IdBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()].toString();
            this.parametros[1][0] = "NbreBodega";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_ListadoProductos";
        } else if (this.lblTitulo.getText().equals("LISTADO DE PRODUCTOS CON CANTIDAD.") && (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES"))) {
            this.parametros = new String[7][2];
            this.parametros[0][0] = "IdBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[1][0] = "NbreBodega";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.parametros[5][0] = "nbreUsuario";
            this.parametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.parametros[6][0] = "fechaFinal";
            this.parametros[6][1] = this.xmt.formatoAMD1.format(this.txtFechaFin.getDate());
            this.nbreArchivo = "I_ListadoProductosConCantidad_1";
        } else if (this.lblTitulo.getText().equals("LISTADO BASICO DE MEDICAMENTOS") || this.lblTitulo.getText().equals("LISTADO BASICO DE MEDICAMENTOS PSIQUIATRA")) {
            this.parametros = new String[7][2];
            this.parametros[0][0] = "IdBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[1][0] = "NbreBodega";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.parametros[5][0] = "nbreUsuario";
            this.parametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.parametros[6][0] = "fechaFinal";
            this.parametros[6][1] = this.xmt.formatoAMD1.format(this.txtFechaFin.getDate());
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.nbreArchivo = "I_ListadoProductosConCantidad";
            } else {
                this.nbreArchivo = Principal.informacionIps.getPrefijoReportes() + "I_Listado_Basico_Medicamento";
            }
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_Listado_Basico_Medicamento_Farmacologicos", this.parametros);
        } else if (this.lblTitulo.getText().equals("MAXIMOS Y MINIMOS")) {
            this.parametros = new String[5][2];
            this.parametros[0][0] = "IdBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[1][0] = "NbreBodega";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_MaximosMinimos";
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_MaximosMinimos_Por_Stock", this.parametros);
        } else if (this.lblTitulo.getText().equals("LISTADO GENERAL DE PRODUCTOS POR TIPO")) {
            this.parametros = new String[3][0];
            this.parametros[0][0] = "ruta";
            this.parametros[0][1] = this.xmt.getRutaRep();
            this.parametros[1][0] = "SUBREPORT_DIR";
            this.parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[2][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_ListadoGeneralDeProductosPorTipo";
        } else if (this.lblTitulo.getText().equals("DESPACHOS POR FECHA POR PACIENTE")) {
            this.parametros = new String[8][2];
            this.parametros[0][0] = "idBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[1][0] = "nbreBodega";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "fechaInicial";
            this.parametros[2][1] = this.xmt.formatoAMD.format(this.txtFechaIni.getDate());
            this.parametros[3][0] = "fechaFinal";
            this.parametros[3][1] = this.xmt.formatoAMD.format(this.txtFechaFin.getDate());
            this.parametros[4][0] = "login";
            this.parametros[4][1] = this.listaUsuario[this.cboUsuario.getSelectedIndex()];
            this.parametros[5][0] = "ruta";
            this.parametros[5][1] = this.xmt.getRutaRep();
            this.parametros[6][0] = "SUBREPORT_DIR";
            this.parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[7][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_DespachosxFechaxPaciente";
        } else if (this.lblTitulo.getText().equals("DESPACHOS POR FECHA POR PACIENTE PARA AUDITORIA")) {
            this.parametros = new String[7][2];
            this.parametros[0][0] = "idBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[1][0] = "fechaInicial";
            this.parametros[1][1] = this.xmt.formatoAMD.format(this.txtFechaIni.getDate());
            this.parametros[2][0] = "fechaFinal";
            this.parametros[2][1] = this.xmt.formatoAMD.format(this.txtFechaFin.getDate());
            this.parametros[3][0] = "login";
            this.parametros[3][1] = this.listaUsuario[this.cboUsuario.getSelectedIndex()];
            this.parametros[4][0] = "ruta";
            this.parametros[4][1] = this.xmt.getRutaRep();
            this.parametros[5][0] = "SUBREPORT_DIR";
            this.parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[6][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_DespachosxFechaxPaciente_Auditoria";
        } else if (this.lblTitulo.getText().equals("DESPACHOS POR FECHA POR PRODUCTO")) {
            this.parametros = new String[8][2];
            this.parametros[0][0] = "nbreBodega";
            this.parametros[0][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[1][0] = "idBodega";
            this.parametros[1][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[2][0] = "usuario";
            this.parametros[2][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.parametros[3][0] = "fechaInicial";
            this.parametros[3][1] = this.xmt.formatoAMD.format(this.txtFechaIni.getDate());
            this.parametros[4][0] = "fechaFinal";
            this.parametros[4][1] = this.xmt.formatoAMD.format(this.txtFechaFin.getDate());
            this.parametros[5][0] = "ruta";
            this.parametros[5][1] = this.xmt.getRutaRep();
            this.parametros[6][0] = "SUBREPORT_DIR";
            this.parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[7][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[7][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_DespachosxFechaxProducto1";
        } else if (this.lblTitulo.getText().equals("DESPACHOS POR EMPRESA")) {
            this.parametros = new String[7][2];
            this.parametros[0][0] = "fechaIni";
            this.parametros[0][1] = this.xmt.formatoAMD.format(this.txtFechaIni.getDate());
            this.parametros[1][0] = "fechaFin";
            this.parametros[1][1] = this.xmt.formatoAMD.format(this.txtFechaFin.getDate());
            this.parametros[2][0] = "IdBodega";
            this.parametros[2][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[3][0] = "NbreBodega";
            this.parametros[3][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[4][0] = "ruta";
            this.parametros[4][1] = this.xmt.getRutaRep();
            this.parametros[5][0] = "SUBREPORT_DIR";
            this.parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[6][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[6][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.nbreArchivo = "I_DespachosxEmpresa";
        } else if (this.lblTitulo.getText().equals("LISTADO DE DISPOSITIVOS MEDICOS")) {
            this.parametros = new String[7][2];
            this.parametros[0][0] = "IdBodega";
            this.parametros[0][1] = this.listaCombo[this.cboBodega.getSelectedIndex()];
            this.parametros[1][0] = "NbreBodega";
            this.parametros[1][1] = this.cboBodega.getSelectedItem().toString();
            this.parametros[2][0] = "ruta";
            this.parametros[2][1] = this.xmt.getRutaRep();
            this.parametros[3][0] = "SUBREPORT_DIR";
            this.parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            this.parametros[4][0] = "SUBREPORTFIRMA_DIR";
            this.parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.parametros[5][0] = "nbreUsuario";
            this.parametros[5][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
            this.parametros[6][0] = "fechaFin";
            this.parametros[6][1] = this.xmt.formatoAMD.format(this.txtFechaFin.getDate());
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                this.nbreArchivo = "I_ListadoProductosConCantidad1";
            } else {
                this.nbreArchivo = Principal.informacionIps.getPrefijoReportes() + "I_Listado_Dispositivos_Medicos";
            }
        }
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.nbreArchivo, this.parametros);
    }

    public void llenarCombos() {
        this.xmt = new Metodos();
        this.cboBodega.setEnabled(true);
        this.listaCombo = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_bodegas WHERE (Estado =0) ORDER BY Nbre ASC", this.listaCombo, this.cboBodega);
        this.listaUsuario = this.consultas.llenarCombo("SELECT g_usuario_sist.Login, w_persona.NUsuario FROM w_persona INNER JOIN g_usuario_sist ON (w_persona.Id_persona = g_usuario_sist.Id_Persona) ORDER BY w_persona.NUsuario ASC", this.listaUsuario, this.cboUsuario);
        this.cboBodega.setSelectedIndex(0);
        JTextComponent editor = this.cboBodega.getEditor().getEditorComponent();
        editor.setDocument(new Autocomplete(this.cboBodega));
    }

    public void validar() {
        this.lblTitulo.setText(this.titulo);
        if (this.titulo.equals("INVENTARIO GENERAL POR AREA") || this.titulo.equals("LISTADO BASICO DE MEDICAMENTOS PSIQUIATRA")) {
            llenarCombos();
            activarCalendarios(1);
            return;
        }
        if (this.titulo.equals("LISTADO GENERAL DE PRODUCTOS POR TIPO")) {
            llenarCombos();
            return;
        }
        if (this.titulo.equals("PROXIMOS A VENCER")) {
            activarCalendarios(1);
            llenarCombos();
            return;
        }
        if (this.titulo.equals("ENTRADA A INVENTARIO")) {
            this.txtEntrada.setEnabled(true);
            return;
        }
        if (this.titulo.equals("PENDIENTE POR DESPACHO")) {
            this.txtFaltante.setEnabled(true);
            return;
        }
        if (this.titulo.equals("LISTADO GENERAL DE PENDIENTES POR FECHA")) {
            this.cboBodega.setEnabled(true);
            activarCalendarios(1);
            llenarCombos();
            return;
        }
        if (this.titulo.equals("LISTADO DE PENDIENTES SIN ENTREGAR POR FECHA")) {
            this.cboBodega.setEnabled(true);
            activarCalendarios(1);
            llenarCombos();
            return;
        }
        if (this.titulo.equals("LISTADO DE PRODUCTOS")) {
            llenarCombos();
            return;
        }
        if (this.titulo.equals("LISTADO DE PRODUCTOS CON CANTIDAD.") && (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES"))) {
            llenarCombos();
            return;
        }
        if (this.titulo.equals("MAXIMOS Y MINIMOS")) {
            llenarCombos();
            return;
        }
        if (this.titulo.equals("LISTADO BASICO DE MEDICAMENTOS") || this.titulo.equals("LISTADO DE DISPOSITIVOS MEDICOS")) {
            llenarCombos();
            return;
        }
        if (this.titulo.equals("DESPACHOS POR FECHA POR PACIENTE") || this.titulo.equals("DESPACHOS POR FECHA POR PACIENTE PARA AUDITORIA")) {
            activarCalendarios(1);
            this.cboUsuario.setEnabled(true);
            llenarCombos();
            return;
        }
        if (this.titulo.equals("DESPACHOS POR FECHA POR PRODUCTO")) {
            activarCalendarios(1);
            activarCampos();
            llenarCombos();
            return;
        }
        if (this.titulo.equals("DESPACHOS POR EMPRESA")) {
            activarCalendarios(1);
            llenarCombos();
            return;
        }
        if (this.titulo.equals("TRASLADOS")) {
            this.xmt = new Metodos();
            this.cboTraslado.setEnabled(true);
            this.listaCombo = this.consultas.llenarCombo("SELECT i_salidas.Id, i_salidas.Id FROM i_salidas INNER JOIN i_tiposmovimientos ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) WHERE (i_tiposmovimientos.Traslado =1 AND i_salidas.Destino =2) ORDER BY i_salidas.Id ASC", this.listaCombo, this.cboTraslado);
        } else if (this.titulo.equals("SALIDAS")) {
            this.xmt = new Metodos();
            this.cboSalida.setEnabled(true);
            llenarCombos();
            this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
            this.listaCombo = this.consultas.llenarCombo("SELECT Destino, Id FROM i_salidas WHERE (Destino <>0) ORDER BY Id ASC", this.listaCombo, this.cboSalida);
        }
    }

    private void initComponents() {
        this.buttonGroup2 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.txtFechaIni = new JCalendar();
        this.txtFechaFin = new JCalendar();
        this.btnAceptar = new JButton();
        this.jPanel2 = new JPanel();
        this.txtFaltante = new JSpinner();
        this.txtEntrada = new JSpinner();
        this.cboTraslado = new JComboBox();
        this.cboSalida = new JComboBox();
        this.cboDespacho = new JComboBox();
        this.cboBodega = new JComboBox();
        this.txtNoFinal = new JTextField();
        this.txtNoInicial = new JTextField();
        this.lblTitulo = new JLabel();
        this.btnSalir = new JButton();
        this.cboUsuario = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCH_VisualizacionDetalle = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("Informes");
        setNormalBounds(new Rectangle(0, 0, 604, 460));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder(0));
        this.jPanel1.setLayout((LayoutManager) null);
        this.txtFechaIni.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 102, 102)));
        this.txtFechaIni.setFont(new Font("Arial", 1, 12));
        this.txtFechaIni.setWeekOfYearVisible(false);
        this.jPanel1.add(this.txtFechaIni);
        this.txtFechaIni.setBounds(10, 10, 320, 240);
        this.txtFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Tahoma", 1, 12), new Color(0, 102, 102)));
        this.txtFechaFin.setFont(new Font("Arial", 1, 12));
        this.txtFechaFin.setWeekOfYearVisible(false);
        this.jPanel1.add(this.txtFechaFin);
        this.txtFechaFin.setBounds(330, 10, 330, 240);
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Inventarios.Informes.1
            public void actionPerformed(ActionEvent evt) {
                Informes.this.btnAceptarActionPerformed(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel2.setLayout((LayoutManager) null);
        this.txtFaltante.setFont(new Font("Arial", 1, 12));
        this.txtFaltante.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtFaltante.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Faltante", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.txtFaltante.setEnabled(false);
        this.jPanel2.add(this.txtFaltante);
        this.txtFaltante.setBounds(210, 140, 190, 50);
        this.txtEntrada.setFont(new Font("Arial", 1, 12));
        this.txtEntrada.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.txtEntrada.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "No. Entrada", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)), "", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.txtEntrada.setEnabled(false);
        this.jPanel2.add(this.txtEntrada);
        this.txtEntrada.setBounds(210, 20, 190, 50);
        this.cboTraslado.setFont(new Font("Arial", 1, 12));
        this.cboTraslado.setBorder(BorderFactory.createTitledBorder((Border) null, "Traslado", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.cboTraslado.setEnabled(false);
        this.jPanel2.add(this.cboTraslado);
        this.cboTraslado.setBounds(210, 80, 190, 50);
        this.cboSalida.setFont(new Font("Arial", 1, 12));
        this.cboSalida.setBorder(BorderFactory.createTitledBorder((Border) null, "Salida", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.cboSalida.setEnabled(false);
        this.jPanel2.add(this.cboSalida);
        this.cboSalida.setBounds(10, 140, 190, 50);
        this.cboDespacho.setFont(new Font("Arial", 1, 12));
        this.cboDespacho.setBorder(BorderFactory.createTitledBorder((Border) null, "Despacho", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboDespacho.setEnabled(false);
        this.jPanel2.add(this.cboDespacho);
        this.cboDespacho.setBounds(10, 80, 190, 50);
        this.cboBodega.setEditable(true);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.cboBodega.setEnabled(false);
        this.jPanel2.add(this.cboBodega);
        this.cboBodega.setBounds(10, 20, 190, 50);
        this.txtNoFinal.setFont(new Font("Arial", 1, 12));
        this.txtNoFinal.setHorizontalAlignment(4);
        this.txtNoFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Final", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoFinal.setEnabled(false);
        this.txtNoFinal.addActionListener(new ActionListener() { // from class: Inventarios.Informes.2
            public void actionPerformed(ActionEvent evt) {
                Informes.this.txtNoFinalActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.txtNoFinal);
        this.txtNoFinal.setBounds(210, 200, 190, 50);
        this.txtNoInicial.setFont(new Font("Arial", 1, 12));
        this.txtNoInicial.setHorizontalAlignment(4);
        this.txtNoInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Inicial", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoInicial.setEnabled(false);
        this.txtNoInicial.addActionListener(new ActionListener() { // from class: Inventarios.Informes.3
            public void actionPerformed(ActionEvent evt) {
                Informes.this.txtNoInicialActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.txtNoInicial);
        this.txtNoInicial.setBounds(10, 200, 190, 50);
        this.lblTitulo.setFont(new Font("Arial", 1, 14));
        this.lblTitulo.setForeground(new Color(0, 102, 0));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("INFORMES");
        this.lblTitulo.setOpaque(true);
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: Inventarios.Informes.4
            public void actionPerformed(ActionEvent evt) {
                Informes.this.btnSalirActionPerformed(evt);
            }
        });
        this.cboUsuario.setFont(new Font("Arial", 1, 12));
        this.cboUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUsuario.setEnabled(false);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.Informes.5
            public void mouseClicked(MouseEvent evt) {
                Informes.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.Informes.6
            public void actionPerformed(ActionEvent evt) {
                Informes.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCH_VisualizacionDetalle.setFont(new Font("Arial", 1, 12));
        this.JCH_VisualizacionDetalle.setForeground(Color.red);
        this.JCH_VisualizacionDetalle.setText("Visualización detalla por lote");
        this.JCH_VisualizacionDetalle.addActionListener(new ActionListener() { // from class: Inventarios.Informes.7
            public void actionPerformed(ActionEvent evt) {
                Informes.this.JCH_VisualizacionDetalleActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblTitulo, -2, 1110, -2).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(layout.createSequentialGroup().addComponent(this.cboUsuario, -2, 263, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 243, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAceptar, -2, 180, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnSalir, -1, -1, 32767)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jPanel1, -2, 670, -2).addGap(10, 10, 10).addComponent(this.jPanel2, -2, 410, -2))).addComponent(this.JCH_VisualizacionDetalle)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblTitulo, -2, 40, -2).addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, 270, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_VisualizacionDetalle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBTExportar, -2, 50, -2).addContainerGap(1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnSalir, -1, 50, 32767).addComponent(this.btnAceptar, -1, 50, 32767)).addGap(1, 1, 1)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboUsuario, -1, 50, 32767).addComponent(this.JTFRuta, -2, 50, -2))))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        cargarInforme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoInicialActionPerformed(ActionEvent evt) {
        this.txtNoFinal.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoFinalActionPerformed(ActionEvent evt) {
        this.btnAceptar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.lblTitulo.getText().equals("LISTADO DE PRODUCTOS CON CANTIDAD") || this.lblTitulo.getText().equals("LISTADO BASICO DE MEDICAMENTOS")) {
                mExportar();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_VisualizacionDetalleActionPerformed(ActionEvent evt) {
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                String xsql = "SELECT i_tipoproducto.Nbre AS NTipoProducto,i_categoria.Nbre AS Categoria,i_suministro.Nbre AS Producto, i_principioactivo.Nbre AS P_Activo, i_concentracion.Nbre AS Concentracion , i_presentacioncomercial.Nbre AS PComercial,date_format(i_suministro.FechaVInvima,'%d-%m-%Y') as FechaInvima, i_laboratorio.Nbre AS Laboratorio, i_suministro.RegistroInvima , i_suministroxlotexbodega.Lote, i_suministroxlotexbodega.Cantidad , date_format(i_suministroxlotexbodega.FechaVencimiento,'%d-%m-%Y') as FechaVencimiento, i_clasificacion.Nbre AS NClasificacion, `i_suministroxbodega`.`Costo`, `i_suministroxbodega`.`VVenta`, i_suministro.Id      FROM i_suministro INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_concentracion  ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_suministroxbodega  ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega  ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) INNER JOIN i_categoria  ON (i_suministro.IdCategoria = i_categoria.Id) INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN i_clasificacion ON (i_suministro.IdClasificacion= i_clasificacion.Id) INNER JOIN i_presentacionfarmaceutica  ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio= i_laboratorio.Id) INNER JOIN i_formafarmaceutica  ON (i_presentacionfarmaceutica.IdFormaFarmaceutica = i_formafarmaceutica.Id) WHERE (i_suministroxlotexbodega.Cantidad >0 AND i_suministroxbodega.IdBodega ='" + this.listaCombo[this.cboBodega.getSelectedIndex()] + "') ORDER BY i_tipoproducto.Nbre ASC, i_categoria.Nbre ASC, Producto ASC ";
                ResultSet xrs = this.consultas.traerRs(xsql);
                try {
                    if (xrs.next()) {
                        xrs.first();
                        for (int x = 0; x < xrs.getMetaData().getColumnCount(); x++) {
                            sheet.addCell(new Label(x, 0, xrs.getMetaData().getColumnName(x + 1)));
                        }
                        xrs.beforeFirst();
                        int x2 = 0;
                        while (xrs.next()) {
                            sheet.addCell(new Label(0, x2 + 1, xrs.getString(1)));
                            sheet.addCell(new Label(1, x2 + 1, xrs.getString(2)));
                            sheet.addCell(new Label(2, x2 + 1, xrs.getString(3)));
                            sheet.addCell(new Label(3, x2 + 1, xrs.getString(4)));
                            sheet.addCell(new Label(4, x2 + 1, xrs.getString(5)));
                            sheet.addCell(new Label(5, x2 + 1, xrs.getString(6)));
                            sheet.addCell(new Label(6, x2 + 1, xrs.getString(7)));
                            sheet.addCell(new Label(7, x2 + 1, xrs.getString(8)));
                            sheet.addCell(new Label(8, x2 + 1, xrs.getString(9)));
                            sheet.addCell(new Label(9, x2 + 1, xrs.getString(10)));
                            sheet.addCell(new Number(10, x2 + 1, xrs.getInt(11)));
                            sheet.addCell(new Label(11, x2 + 1, xrs.getString(12)));
                            sheet.addCell(new Label(12, x2 + 1, xrs.getString(13)));
                            sheet.addCell(new Number(13, x2 + 1, xrs.getDouble(14)));
                            sheet.addCell(new Number(14, x2 + 1, xrs.getDouble(15)));
                            sheet.addCell(new Number(15, x2 + 1, xrs.getLong(16)));
                            x2++;
                        }
                    }
                    xrs.close();
                    this.consultas.cerrarConexionBd();
                } catch (SQLException ex) {
                    Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
                workbook.write();
                workbook.close();
                Desktop.getDesktop().open(new File(this.JTFRuta.getText() + ".xls"));
            } catch (WriteException e) {
                Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex2) {
                Logger.getLogger(Informes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }
}
