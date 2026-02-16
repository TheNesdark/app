package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Facturacion.claseFacturacion;
import General.ClaseImpresionInformes;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.genoma.plus.controller.facturacion.ProcesosValidacionRipsApi;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.IFacturaElectronica;
import com.genoma.plus.jpa.projection.NotasElectronicas;
import com.genoma.plus.jpa.service.FacturaNotasService;
import com.genoma.plus.jpa.service.IFacturaElectronicaDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFFacturaElectronica.class */
public class JIFFacturaElectronica extends JInternalFrame {
    private DefaultTableModel xModelo;
    private DefaultTableModel xModelo1;
    private DefaultTableModel modeloNota;
    private Object[] xDato;
    private List<IFacturaElectronica> listaFacturas;
    private List<IFacturaElectronica> listaFacturasConepto;
    private List<NotasElectronicas> listadoDeNotas;
    private String xvalor;
    private List<ICargarCombo> comboGenerico;
    private File file;
    private List<co.com.genomaempresarial.ankara.dto.Adjunto> adjunto;
    private JButton JBTExportar;
    private JButton JBT_Enviar;
    private JComboBox<String> JCBGenerico;
    private JCheckBox JCHAplicaFiltro;
    private JCheckBox JCHReenviar;
    private JCheckBox JCHSeleccion;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JLabel JLBLCont;
    private JPanel JPDatos;
    private JPanel JPExportar;
    private JPanel JPIUtilidades;
    private JRadioButton JRBConvenios;
    private JRadioButton JRBError;
    private JRadioButton JRBPorEnviar;
    private JRadioButton JRBSuccess;
    private JRadioButton JRBTerceros;
    private JRadioButton JRBTodo;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleConceptos;
    private JTable JTDetalle;
    private JTable JTDetalleConceptos;
    private JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JTable JTNotas;
    private JTabbedPane JTPFacturas;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private ButtonGroup buttonGroup4;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTextField jTextField1;
    private Metodos xmt = new Metodos();
    private IFacturaElectronicaDAO xIFacturaElectronicaDAO = (IFacturaElectronicaDAO) Principal.contexto.getBean(IFacturaElectronicaDAO.class);
    private FacturaNotasService notaFactura = (FacturaNotasService) Principal.contexto.getBean(FacturaNotasService.class);
    private claseFacturacion xClaseFacturacion = new claseFacturacion();
    private boolean xlleno = false;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public JIFFacturaElectronica() {
        initComponents();
        mNuevo();
        this.adjunto = new ArrayList();
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCHReenviar.setVisible(false);
        this.listaFacturas = new ArrayList();
        this.listaFacturasConepto = new ArrayList();
        this.listadoDeNotas = new ArrayList();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCHReenviar.setSelected(false);
        this.xlleno = true;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFRuta1.setText("");
        mCrearModelo();
        mCrearModeloConceptos();
        mCargarCombo();
        crearModeloNotas();
    }

    public void mBuscar() {
        if (this.JTPFacturas.getSelectedIndex() == 0) {
            mCargarDatos();
        }
        if (this.JTPFacturas.getSelectedIndex() == 1) {
            mCargarDatosConceptos();
        }
        if (this.JTPFacturas.getSelectedIndex() == 2) {
            cargarDatosNotas();
        }
        cantidadregistros();
    }

    public void mCargarCombo() {
        if (this.JCHAplicaFiltro.isSelected() && this.xlleno) {
            if (this.JRBConvenios.isSelected()) {
                if (Principal.informacionIps.getIdentificacion().equals("812002613")) {
                    this.comboGenerico = this.xIFacturaElectronicaDAO.consultarConveniosSaludIntegral(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                } else {
                    this.comboGenerico = this.xIFacturaElectronicaDAO.consultarConvenios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
                }
                this.JCBGenerico.removeAllItems();
                this.comboGenerico.forEach(next -> {
                    this.JCBGenerico.addItem(next.getNombre());
                });
                return;
            }
            if (Principal.informacionIps.getIdentificacion().equals("812002613")) {
                this.comboGenerico = this.xIFacturaElectronicaDAO.consultarTercerosSaludIntegral(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            } else {
                this.comboGenerico = this.xIFacturaElectronicaDAO.consultarTerceros(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            }
            this.JCBGenerico.removeAllItems();
            this.comboGenerico.forEach(next2 -> {
                this.JCBGenerico.addItem(next2.getNombre());
            });
        }
    }

    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"S", "No_FacturaEvento", "Fecha_FacturaEvento", "Nombre Entidad", "Nombre Servicio", "Valor Servicio", "ValorDescuento", "Total Factura", "ResponseMensaje", "ResponseEstado", "Persona Responsable", "Correo", "No. Documento", "Nombre Usuario", "idFactura"}) { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.1
            Class[] types = {Boolean.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
    }

    private void mCargarDatos() {
        mCrearModelo();
        if (this.JCHAplicaFiltro.isSelected()) {
            if (this.JRBConvenios.isSelected()) {
                if (this.JRBTodo.isSelected()) {
                    this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaTodoConvenios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else if (this.JRBSuccess.isSelected()) {
                    this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaSuccessConvenios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else if (this.JRBError.isSelected()) {
                    this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaErrorConvenios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else {
                    this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaPorEnviarConvenios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                }
            } else if (this.JRBTerceros.isSelected()) {
                if (this.JRBTodo.isSelected()) {
                    this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaTodoTerceros(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else if (this.JRBSuccess.isSelected()) {
                    this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaSuccessTerceros(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else if (this.JRBError.isSelected()) {
                    this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaErrorTerceros(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else {
                    this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaPorEnviarTerceros(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                }
            }
        } else if (this.JRBTodo.isSelected()) {
            this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaTodo(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        } else if (this.JRBSuccess.isSelected()) {
            this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaSuccess(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        } else if (this.JRBError.isSelected()) {
            this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaError(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        } else {
            this.listaFacturas = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaPorEnviar(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        }
        if (!this.listaFacturas.isEmpty()) {
            for (int x = 0; x < this.listaFacturas.size(); x++) {
                this.xModelo.addRow(this.xDato);
                this.xModelo.setValueAt(false, x, 0);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getPrefijo() + this.listaFacturas.get(x).getNo_FacturaEvento_M(), x, 1);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getFecha_FacturaEvento(), x, 2);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getNombreEmpresaConvenio(), x, 3);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getNombreGrupoFactura(), x, 4);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getTotalServicio(), x, 5);
                this.xModelo.setValueAt(Double.valueOf(this.listaFacturas.get(x).getCopago().doubleValue() + this.listaFacturas.get(x).getCuotaModeradora().doubleValue()), x, 6);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getTotalEps(), x, 7);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getResponseMensaje(), x, 8);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getResponseEstado(), x, 9);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getPersonaResponsable(), x, 10);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getCorreoFactura(), x, 11);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getDocumentoUsuario(), x, 12);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getNombreUsuario(), x, 13);
                this.xModelo.setValueAt(this.listaFacturas.get(x).getNo_FacturaEvento(), x, 14);
            }
        }
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 8);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 9);
    }

    private void mCrearModeloConceptos() {
        this.xModelo1 = new DefaultTableModel((Object[][]) null, new String[]{"IdIngreso", "No_FacturaEvento", "Prefijo", "No_FacturaEvento_M", "Fecha_CuentaCobro", "IdServicio", "IdEmpresa", "NombreCentroCosto", "NombreConcepto", "Empresa", "IdLiquidacion", "CantidaD", "ValorUnitario", "ValorDescuento", "PorcentajeImpuesto", "ValorImpuesto", "Plan", "ValorTotal", "EsConjunto", "ValorC", "Dat", "ValorCx", "CuotaModeradora", "Copago", "TotalPlan", "TotalPaciente", "TotalEps", "TotalServicio", "FechaI", "Id_DocumentoC", "EsCapitado", "ResponseMensaje", "ResponseEstado", "S", "RutaAbjunto"}) { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.2
            Class[] types = {Long.class, Long.class, String.class, Long.class, String.class, Long.class, Long.class, String.class, String.class, String.class, Long.class, Long.class, Double.class, Double.class, Double.class, Double.class, Long.class, Double.class, Long.class, Double.class, Long.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, Long.class, Long.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleConceptos.setModel(this.xModelo1);
        this.JTDetalleConceptos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleConceptos.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleConceptos.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleConceptos.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalleConceptos.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.JTDetalleConceptos.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalleConceptos.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(24).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(25).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(25).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(25).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(28).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(28).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(28).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(29).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(29).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(29).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(30).setPreferredWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(30).setMinWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(30).setMaxWidth(0);
        this.JTDetalleConceptos.getColumnModel().getColumn(31).setPreferredWidth(250);
        this.JTDetalleConceptos.getColumnModel().getColumn(32).setPreferredWidth(80);
        this.JTDetalleConceptos.getColumnModel().getColumn(33).setPreferredWidth(50);
        this.JTDetalleConceptos.getColumnModel().getColumn(34).setPreferredWidth(100);
    }

    private void mCargarDatosConceptos() {
        mCrearModeloConceptos();
        if (this.JCHAplicaFiltro.isSelected()) {
            if (this.JRBConvenios.isSelected()) {
                if (this.JRBTodo.isSelected()) {
                    this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoTodoConvenio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else if (this.JRBSuccess.isSelected()) {
                    this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoSuccessConvenio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else if (this.JRBError.isSelected()) {
                    this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoErrorConvenio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else {
                    this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoPorEnviarConvenio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                }
            } else if (this.JRBTerceros.isSelected()) {
                if (this.JRBTodo.isSelected()) {
                    this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoTodoTercero(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else if (this.JRBSuccess.isSelected()) {
                    this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoSuccessTercero(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else if (this.JRBError.isSelected()) {
                    this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoErrorTercero(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                } else {
                    this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoPorEnviarTercero(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.comboGenerico.get(this.JCBGenerico.getSelectedIndex()).getId());
                }
            }
        } else if (this.JRBTodo.isSelected()) {
            this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoTodo(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        } else if (this.JRBSuccess.isSelected()) {
            this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoSuccess(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        } else if (this.JRBError.isSelected()) {
            this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoError(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        } else {
            this.listaFacturasConepto = this.xIFacturaElectronicaDAO.ConsultarfacturaElectronicaConceptoPorEnviar(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        }
        for (int x = 0; x < this.listaFacturasConepto.size(); x++) {
            this.xModelo1.addRow(this.xDato);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getIdIngreso(), x, 0);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getNo_FacturaEvento(), x, 1);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getPrefijo(), x, 2);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getNo_FacturaEvento_M(), x, 3);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getFecha_FacturaEvento(), x, 4);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getIdServicio(), x, 5);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getIdEmpresa(), x, 6);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getNombreCentroCosto(), x, 7);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getNombreServicio(), x, 8);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getEmpresa(), x, 9);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getIdLiquidacion(), x, 10);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getCantidaD(), x, 11);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getValorUnitario(), x, 12);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getValorDescuento(), x, 13);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getPorcentajeImpuesto(), x, 14);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getValorImpuesto(), x, 15);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getPlan(), x, 16);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getValorTotal(), x, 17);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getEsConjunto(), x, 18);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getValorC(), x, 19);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getDat(), x, 20);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getValorCx(), x, 21);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getCuotaModeradora(), x, 22);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getCopago(), x, 23);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getTotalPlan(), x, 24);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getTotalPaciente(), x, 25);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getTotalEps(), x, 26);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getTotalServicio(), x, 27);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getFechaI(), x, 28);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getId_DocumentoC(), x, 29);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getEsCapitado(), x, 30);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getResponseMensaje(), x, 31);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getResponseEstado(), x, 32);
            this.xModelo1.setValueAt(false, x, 33);
            this.xModelo1.setValueAt(this.listaFacturasConepto.get(x).getArchivoAbjunto(), x, 34);
        }
        this.xmt.mEstablecerTextEditor(this.JTDetalleConceptos, 8);
        this.xmt.mEstablecerTextEditor(this.JTDetalleConceptos, 9);
        this.xmt.mEstablecerTextEditor(this.JTDetalleConceptos, 30);
    }

    private void cantidadregistros() {
        if (this.JTPFacturas.getSelectedIndex() == 0) {
            if (this.listaFacturas != null) {
                this.JLBLCont.setText(this.listaFacturas.size() + "");
            }
        } else if (this.listaFacturasConepto != null) {
            this.JLBLCont.setText(this.listaFacturasConepto.size() + "");
        }
    }

    public void mImprimir() {
        if (this.JTPFacturas.getSelectedIndex() == 2) {
            ClaseImpresionInformes impresionInforme = new ClaseImpresionInformes();
            impresionInforme.visualizarNota(this.listadoDeNotas.get(this.JTNotas.getSelectedRow()).getConsecutivoNota());
        } else if (this.listaFacturas.size() > 0) {
            if (this.JTDetalle.getSelectedRow() >= 0) {
                ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
                impresionInformes.visualizarFacturasEventoMetodoPrinicpal(this.listaFacturas.get(this.JTDetalle.getSelectedRow()).getIdIngreso().toString(), this.listaFacturas.get(this.JTDetalle.getSelectedRow()).getTotalServicio().toString(), this.listaFacturas.get(this.JTDetalle.getSelectedRow()).getTotalPlan().toString(), this.listaFacturas.get(this.JTDetalle.getSelectedRow()).getValorDescuento().toString(), this.listaFacturas.get(this.JTDetalle.getSelectedRow()).getCuotaModeradora().toString(), this.listaFacturas.get(this.JTDetalle.getSelectedRow()).getTotalPaciente().toString(), this.listaFacturas.get(this.JTDetalle.getSelectedRow()).getTotalEps().toString(), 1, 0);
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v88, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v93, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v96, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.buttonGroup4 = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.jPanel1 = new JPanel();
        this.JRBSuccess = new JRadioButton();
        this.JRBError = new JRadioButton();
        this.JRBTodo = new JRadioButton();
        this.JRBPorEnviar = new JRadioButton();
        this.JBT_Enviar = new JButton();
        this.JCHSeleccion = new JCheckBox();
        this.jTextField1 = new JTextField();
        this.JCBGenerico = new JComboBox<>();
        this.jPanel4 = new JPanel();
        this.JRBConvenios = new JRadioButton();
        this.JRBTerceros = new JRadioButton();
        this.JCHAplicaFiltro = new JCheckBox();
        this.JCHReenviar = new JCheckBox();
        this.JTPFacturas = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalleConceptos = new JScrollPane();
        this.JTDetalleConceptos = new JTable();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTNotas = new JTable();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLBLCont = new JLabel();
        this.JPIUtilidades = new JPanel();
        this.JTFRuta1 = new JTextField();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("TRASMISIÓN FACTURA ELECTRÓNICA");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifFacturaElectronica");
        setVerifyInputWhenFocusTarget(false);
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFacturaElectronica.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFacturaElectronica.this.JDFechaFPropertyChange(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtrar por estado", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.JRBSuccess);
        this.JRBSuccess.setFont(new Font("Arial", 1, 12));
        this.JRBSuccess.setText("SUCCESS");
        this.buttonGroup1.add(this.JRBError);
        this.JRBError.setFont(new Font("Arial", 1, 12));
        this.JRBError.setText("ERROR");
        this.buttonGroup1.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("TODO");
        this.JRBTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.5
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JRBTodoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBPorEnviar);
        this.JRBPorEnviar.setFont(new Font("Arial", 1, 12));
        this.JRBPorEnviar.setSelected(true);
        this.JRBPorEnviar.setText("POR ENVIAR");
        this.JRBPorEnviar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.6
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JRBPorEnviarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBSuccess).addGap(18, 18, 18).addComponent(this.JRBError).addGap(0, 0, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addComponent(this.JRBPorEnviar).addGap(19, 19, 19)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBPorEnviar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSuccess).addComponent(this.JRBError))));
        this.JBT_Enviar.setFont(new Font("Arial", 1, 12));
        this.JBT_Enviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Enviar.setText("Enviar Factura");
        this.JBT_Enviar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.7
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JBT_EnviarActionPerformed(evt);
            }
        });
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setForeground(Color.blue);
        this.JCHSeleccion.setText("Seleccionar Todo");
        this.JCHSeleccion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.8
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JCHSeleccionActionPerformed(evt);
            }
        });
        this.jTextField1.setToolTipText("");
        this.jTextField1.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Factura", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JCBGenerico.setFont(new Font("Arial", 1, 12));
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtros", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.buttonGroup4.add(this.JRBConvenios);
        this.JRBConvenios.setFont(new Font("Arial", 1, 12));
        this.JRBConvenios.setSelected(true);
        this.JRBConvenios.setText("Convenios");
        this.JRBConvenios.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.9
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JRBConveniosActionPerformed(evt);
            }
        });
        this.buttonGroup4.add(this.JRBTerceros);
        this.JRBTerceros.setFont(new Font("Arial", 1, 12));
        this.JRBTerceros.setText("Terceros");
        this.JRBTerceros.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.10
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JRBTercerosActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JRBConvenios).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBTerceros).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBConvenios).addComponent(this.JRBTerceros)).addContainerGap(-1, 32767)));
        this.JCHAplicaFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaFiltro.setForeground(Color.blue);
        this.JCHAplicaFiltro.setText("Aplicar Filtro?");
        this.JCHAplicaFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.11
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JCHAplicaFiltroActionPerformed(evt);
            }
        });
        this.JCHReenviar.setFont(new Font("Arial", 1, 12));
        this.JCHReenviar.setForeground(Color.red);
        this.JCHReenviar.setText("Reenviar");
        this.JCHReenviar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.12
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JCHReenviarActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBGenerico, -2, 714, -2).addGap(26, 26, 26).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel4, -1, -1, 32767).addComponent(this.jTextField1))).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 115, -2).addGap(26, 26, 26).addComponent(this.JDFechaF, -2, 115, -2).addGap(28, 28, 28).addComponent(this.jPanel1, -2, -1, -2).addGap(37, 37, 37).addComponent(this.JBT_Enviar, -2, 155, -2))).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAplicaFiltro).addComponent(this.JCHSeleccion))).addGroup(JPDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHReenviar))).addGap(40, 40, 40)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, -1, 32767).addComponent(this.JDFechaI, -2, -1, -2)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCHReenviar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBT_Enviar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField1, -1, 45, 32767).addComponent(this.JCHSeleccion)))).addComponent(this.jPanel1, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBGenerico).addComponent(this.jPanel4, -1, -1, 32767)).addComponent(this.JCHAplicaFiltro)).addGap(10, 10, 10)));
        this.JTPFacturas.setForeground(Color.red);
        this.JTPFacturas.setFont(new Font("Arial", 1, 14));
        this.JTPFacturas.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.13
            public void stateChanged(ChangeEvent evt) {
                JIFFacturaElectronica.this.JTPFacturasStateChanged(evt);
            }
        });
        this.JSPDetalle.setForeground(Color.red);
        this.JSPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setAutoResizeMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPFacturas.addTab("USUARIOS", this.JSPDetalle);
        this.JSPDetalleConceptos.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleConceptos.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalleConceptos.setFont(new Font("Arial", 1, 12));
        this.JTDetalleConceptos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleConceptos.setAutoResizeMode(0);
        this.JSPDetalleConceptos.setViewportView(this.JTDetalleConceptos);
        this.JTPFacturas.addTab("CONCEPTOS", this.JSPDetalleConceptos);
        this.JTNotas.setFont(new Font("Arial", 1, 12));
        this.JTNotas.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane1.setViewportView(this.JTNotas);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 1112, 32767).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 247, 32767).addContainerGap()));
        this.JTPFacturas.addTab("NOTAS", this.jPanel2);
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.14
            public void mouseClicked(MouseEvent evt) {
                JIFFacturaElectronica.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.15
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.16
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JLBLCont.setFont(new Font("Arial", 1, 36));
        this.JLBLCont.setHorizontalAlignment(0);
        this.JLBLCont.setText("0");
        this.JLBLCont.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Registro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPExportarLayout = new GroupLayout(this.JPExportar);
        this.JPExportar.setLayout(JPExportarLayout);
        JPExportarLayout.setHorizontalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 558, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 208, 32767).addComponent(this.JLBLCont, -2, 197, -2).addContainerGap()));
        JPExportarLayout.setVerticalGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportarLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPExportarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 48, -2).addComponent(this.JLBLCont)).addComponent(this.JTFRuta, -2, 48, -2)).addGap(66, 66, 66)));
        this.jTabbedPane1.addTab("EXPORTAR", this.JPExportar);
        this.JTFRuta1.setFont(new Font("Arial", 1, 12));
        this.JTFRuta1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Adjunto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.17
            public void mouseClicked(MouseEvent evt) {
                JIFFacturaElectronica.this.JTFRuta1MouseClicked(evt);
            }
        });
        this.JTFRuta1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.18
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.JTFRuta1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton2.setText("Gestión Rips");
        this.jButton2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.19
            /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.core.JsonProcessingException */
            public void actionPerformed(ActionEvent evt) throws JsonProcessingException {
                JIFFacturaElectronica.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton3.setFont(new Font("Arial", 1, 12));
        this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.jButton3.setText("Actualizar(Fecha y hora factura)");
        this.jButton3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.20
            public void actionPerformed(ActionEvent evt) {
                JIFFacturaElectronica.this.jButton3ActionPerformed(evt);
            }
        });
        GroupLayout JPIUtilidadesLayout = new GroupLayout(this.JPIUtilidades);
        this.JPIUtilidades.setLayout(JPIUtilidadesLayout);
        JPIUtilidadesLayout.setHorizontalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta1, -2, 635, -2).addGap(27, 27, 27).addComponent(this.jButton2, -2, 163, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, 32767).addComponent(this.jButton3).addContainerGap()));
        JPIUtilidadesLayout.setVerticalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addGap(34, 34, 34).addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2, -2, 50, -2).addComponent(this.jButton3, -2, 50, -2)).addComponent(this.JTFRuta1, -2, 50, -2)).addContainerGap(39, 32767)));
        this.jTabbedPane1.addTab("UTILIDADES", this.JPIUtilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, 1132, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTPFacturas, -2, 1124, -2).addGap(0, 0, 32767)).addComponent(this.jTabbedPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, 172, -2).addGap(4, 4, 4).addComponent(this.JTPFacturas, -2, 286, -2).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -2, 154, -2).addContainerGap()));
        getAccessibleContext().setAccessibleName("jifFacturaElectronica");
        pack();
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
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorEnviarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_EnviarActionPerformed(ActionEvent evt) {
        System.out.println("select " + this.JTPFacturas.getSelectedIndex());
        switch (this.JTPFacturas.getSelectedIndex()) {
            case 0:
                if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 0)) {
                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                        if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue()) {
                            GeneracionFacturaElectronica facturaElectronica = new GeneracionFacturaElectronica();
                            List<Adjunto> adjuntos = new ArrayList<>();
                            facturaElectronica.generacionFacturaEventoSalud(this.listaFacturas.get(i).getNo_FacturaEvento().toString(), Integer.valueOf(this.JTPFacturas.getSelectedIndex()), Boolean.valueOf(this.JCHReenviar.isSelected()), adjuntos);
                        }
                    }
                    mBuscar();
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una Factura", "VERIFICAR", 1);
                }
                break;
            case 1:
                System.out.println("capita " + this.xModelo1.getValueAt(this.JTDetalleConceptos.getSelectedRow(), 30) + this.JTDetalleConceptos.getColumnName(30));
                if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleConceptos, 33)) {
                    for (int i2 = 0; i2 < this.JTDetalleConceptos.getRowCount(); i2++) {
                        if (Boolean.valueOf(this.JTDetalleConceptos.getValueAt(i2, 33).toString()).booleanValue()) {
                            if (!Principal.informacionIps.getIdentificacion().equals(900304530)) {
                                if (this.listaFacturasConepto.get(i2).getArchivoAbjunto() != null && !this.listaFacturasConepto.get(i2).getArchivoAbjunto().isEmpty()) {
                                    crearAbjuntoEnBaseAruta(this.listaFacturasConepto.get(i2).getArchivoAbjunto());
                                    this.JTFRuta1.setText("");
                                } else if (!this.JTFRuta1.getText().isEmpty()) {
                                    crearAbjuntoEnBaseAruta(this.JTFRuta1.getText());
                                } else {
                                    this.adjunto = new ArrayList();
                                }
                            } else if (!this.listaFacturasConepto.get(i2).getArchivoAbjunto().isEmpty()) {
                                crearAbjuntoEnBaseAruta(this.listaFacturasConepto.get(i2).getArchivoAbjunto());
                                this.JTFRuta1.setText("");
                            } else if (!this.JTFRuta1.getText().isEmpty()) {
                                crearAbjuntoEnBaseAruta(this.JTFRuta1.getText());
                            } else {
                                this.adjunto = new ArrayList();
                            }
                            this.xIFacturaElectronicaDAO.mGenerarFacturaElectronica(this.listaFacturasConepto.get(i2).getNo_FacturaEvento().toString(), Integer.valueOf(this.JTPFacturas.getSelectedIndex()), Boolean.valueOf(this.JCHReenviar.isSelected()), this.adjunto);
                            this.adjunto = new ArrayList();
                        }
                    }
                    mBuscar();
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una Factura", "VERIFICAR", 1);
                }
                break;
            default:
                System.out.println("panel notas");
                if (this.xmt.mVerificarDatosTablaTrue(this.JTNotas, 8)) {
                    System.out.println("va enviar nota");
                    for (int j = 0; j < this.JTNotas.getRowCount(); j++) {
                        if (Boolean.valueOf(this.JTNotas.getValueAt(j, 8).toString()).booleanValue()) {
                            if (Boolean.valueOf(this.JTNotas.getValueAt(j, 10).toString()).booleanValue()) {
                                this.notaFactura.generarNotasDebitoCredito(Integer.valueOf(Integer.parseInt(this.JTNotas.getValueAt(j, 0).toString())), this.JTNotas.getValueAt(j, 5).toString(), "CREDIT_NOTE_WBR");
                            } else {
                                this.notaFactura.generarNotasDebitoCredito(Integer.valueOf(Integer.parseInt(this.JTNotas.getValueAt(j, 0).toString())), this.JTNotas.getValueAt(j, 5).toString(), "CREDIT_NOTE");
                            }
                            this.adjunto = new ArrayList();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una Nota", "VERIFICAR", 1);
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPFacturasStateChanged(ChangeEvent evt) {
        cantidadregistros();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccion.isSelected()) {
            this.JCHSeleccion.setText("Quitar Selección");
            seleccionarDeseleccionar(Boolean.valueOf(this.JCHSeleccion.isSelected()));
        } else {
            this.JCHSeleccion.setText("Seleccionar Todo");
            seleccionarDeseleccionar(Boolean.valueOf(this.JCHSeleccion.isSelected()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaFiltro.isSelected()) {
            mCargarCombo();
        } else {
            this.JCBGenerico.removeAllItems();
            this.JCBGenerico.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConveniosActionPerformed(ActionEvent evt) {
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenios", 0, 0, new Font("Arial", 1, 12), Color.blue));
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTercerosActionPerformed(ActionEvent evt) {
        this.JCBGenerico.setBorder(BorderFactory.createTitledBorder((Border) null, "Terceros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHReenviarActionPerformed(ActionEvent evt) {
    }

    private void crearAbjuntoEnBaseAruta(String url) {
        try {
            this.file = new File(url);
            co.com.genomaempresarial.ankara.dto.Adjunto a = new co.com.genomaempresarial.ankara.dto.Adjunto();
            a.setFileName(this.file.getName());
            Metodos metodos = this.xmt;
            a.setBase64(Metodos.encodeFileToBase64Binary(this.file.getAbsolutePath()));
            this.adjunto.add(a);
            this.adjunto.forEach(e -> {
                System.out.println("nombre : " + e.getFileName());
                System.out.println("Base64 : " + e.getBase64());
            });
        } catch (IOException ex) {
            Logger.getLogger(JIFFacturaElectronica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta1.getText());
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                try {
                    this.file = xfilec.getSelectedFile();
                    this.JTFRuta1.setText(this.file.getAbsolutePath());
                    co.com.genomaempresarial.ankara.dto.Adjunto a = new co.com.genomaempresarial.ankara.dto.Adjunto();
                    a.setFileName(this.file.getName());
                    Metodos metodos = this.xmt;
                    a.setBase64(Metodos.encodeFileToBase64Binary(this.file.getAbsolutePath()));
                    this.adjunto.add(a);
                    this.adjunto.forEach(e -> {
                        System.out.println("nombre : " + e.getFileName());
                        System.out.println("Base64 : " + e.getBase64());
                    });
                } catch (IOException ex) {
                    Logger.getLogger(JIFFacturaElectronica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: Thrown type has an unknown type hierarchy: com.fasterxml.jackson.core.JsonProcessingException */
    public void jButton2ActionPerformed(ActionEvent evt) throws JsonProcessingException {
        switch (this.JTPFacturas.getSelectedIndex()) {
            case 0:
                if (this.JTDetalle.getSelectedRow() != -1) {
                    ProcesosValidacionRipsApi ripsApi = new ProcesosValidacionRipsApi();
                    Long idFacturaEvento = Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString());
                    String numeroFactura = this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString();
                    System.err.println("idFacturaEvento" + idFacturaEvento);
                    System.err.println("numeroFactura" + numeroFactura);
                    Integer modalidadContrato = 1;
                    ripsApi.acciones(idFacturaEvento, numeroFactura, modalidadContrato.intValue(), this, this.JTFRuta.getText());
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                }
                break;
            case 1:
                if (this.JTDetalleConceptos.getSelectedRow() != -1) {
                    ProcesosValidacionRipsApi ripsApi2 = new ProcesosValidacionRipsApi();
                    Long idFacturaCapita = Long.valueOf(this.JTDetalleConceptos.getValueAt(this.JTDetalleConceptos.getSelectedRow(), 1).toString());
                    String numeroFacturaCapita = this.JTDetalleConceptos.getValueAt(this.JTDetalleConceptos.getSelectedRow(), 2).toString().concat(this.JTDetalleConceptos.getValueAt(this.JTDetalleConceptos.getSelectedRow(), 3).toString());
                    System.err.println("idFacturaCapita-->" + idFacturaCapita);
                    System.err.println("numeroFacturaCapita-->" + numeroFacturaCapita);
                    Integer modalidadContrato2 = 0;
                    ripsApi2.acciones(idFacturaCapita, numeroFacturaCapita, modalidadContrato2.intValue(), this, this.JTFRuta.getText());
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0 && this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 0)) {
            List<Long> idFacturas = new ArrayList<>();
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.parseBoolean(this.JTDetalle.getValueAt(i, 0).toString())) {
                    idFacturas.add(Long.valueOf(this.JTDetalle.getValueAt(i, 14).toString()));
                }
            }
            if (!idFacturas.isEmpty()) {
                this.xIFacturaElectronicaDAO.actualizarFechaHoraFacturaEvento(idFacturas);
            }
        }
    }

    private void mExportar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            switch (this.JTPFacturas.getSelectedIndex()) {
                case 0:
                    if (this.JTDetalle.getRowCount() != -1) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                        if (n == 0) {
                            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                    }
                    break;
                case 1:
                    if (this.JTDetalle.getRowCount() != -1) {
                        int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                        if (n2 == 0) {
                            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleConceptos, this.JTFRuta.getText(), getTitle());
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                    }
                    break;
                case 2:
                    if (this.JTDetalle.getRowCount() != -1) {
                        int n3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon("src/Imagenes/Question2.png"));
                        if (n3 == 0) {
                            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTNotas, this.JTFRuta.getText(), getTitle());
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
                    }
                    break;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information2.png"));
        this.JTFRuta.requestFocus();
    }

    private void crearModeloNotas() {
        this.modeloNota = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Razon Social", "No Nota", "Descripcion", "Valor Nota", "No Factura", "ResponseMensaje", "ResponseEstado", "S", "esCapita", "Sin Factura"}) { // from class: com.genoma.plus.controller.gcuenta.JIFFacturaElectronica.21
            Class[] types = {Integer.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class, Boolean.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTNotas.setModel(this.modeloNota);
        JTable jTable = this.JTNotas;
        JTable jTable2 = this.JTNotas;
        jTable.setAutoResizeMode(0);
        this.JTNotas.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTNotas.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTNotas.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTNotas.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTNotas.getColumnModel().getColumn(4).setPreferredWidth(90);
        this.JTNotas.getColumnModel().getColumn(5).setPreferredWidth(90);
        this.JTNotas.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTNotas.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTNotas.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTNotas.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTNotas.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.xmt.mEstablecerTextEditor(this.JTNotas, 2);
        this.xmt.mEstablecerTextEditor(this.JTNotas, 3);
        this.xmt.mEstablecerTextEditor(this.JTNotas, 6);
    }

    private void cargarDatosNotas() {
        try {
            String dateI = this.formatoFecha.format(this.JDFechaI.getDate());
            String dateF = this.formatoFecha.format(this.JDFechaF.getDate());
            System.out.println("factura -> " + this.jTextField1.getText());
            System.out.println("fecha i -> " + dateI);
            System.out.println("fecha f -> " + dateF);
            if (this.JRBTodo.isSelected()) {
                this.listadoDeNotas = this.notaFactura.listadoNotasAll(this.jTextField1.getText(), dateI, dateF);
            } else if (this.JRBSuccess.isSelected()) {
                this.listadoDeNotas = this.notaFactura.listadoNotasErrorSuccess(this.jTextField1.getText(), dateI, dateF, "SUCCESS");
                System.out.println("lista de notas -> " + this.listadoDeNotas);
            } else if (this.JRBError.isSelected()) {
                this.listadoDeNotas = this.notaFactura.listadoNotasErrorSuccess(this.jTextField1.getText(), dateI, dateF, "ERROR");
            } else if (this.JRBPorEnviar.isSelected()) {
                this.listadoDeNotas = this.notaFactura.listadoNotasPorEnviar(0, this.jTextField1.getText(), dateI, dateF);
            }
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
        crearModeloNotas();
        if (!this.listadoDeNotas.isEmpty()) {
            for (int j = 0; j < this.listadoDeNotas.size(); j++) {
                this.modeloNota.addRow(this.xDato);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getId(), j, 0);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getRazonSocial(), j, 1);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getConsecutivoNota(), j, 2);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getDescripcionGeneral(), j, 3);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getValorNota(), j, 4);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getNoFactura(), j, 5);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getResponse(), j, 6);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getResponseEstado(), j, 7);
                this.modeloNota.setValueAt(false, j, 8);
                this.modeloNota.setValueAt(this.listadoDeNotas.get(j).getEsCapita(), j, 9);
                this.modeloNota.setValueAt(Boolean.valueOf(this.listadoDeNotas.get(j).getNotaSinFactura()), j, 10);
            }
        }
    }

    private void seleccionarDeseleccionar(Boolean estado) {
        if (this.JTPFacturas.getSelectedIndex() == 0) {
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                this.xModelo.setValueAt(estado, i, 0);
            }
            return;
        }
        if (this.JTPFacturas.getSelectedIndex() == 1) {
            for (int i2 = 0; i2 < this.JTDetalleConceptos.getRowCount(); i2++) {
                this.xModelo1.setValueAt(estado, i2, 33);
            }
        }
    }
}
