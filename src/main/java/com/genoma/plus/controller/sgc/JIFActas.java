package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import General.JDBiometrico;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sgc.SGC_ActasDAOImpl;
import com.genoma.plus.dao.sgc.SGC_ActasDAO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.sgc.SGC_ActasAccionConclusionDTO;
import com.genoma.plus.dto.sgc.SGC_ActasAsistentesDTO;
import com.genoma.plus.dto.sgc.SGC_ActasDTO;
import com.genoma.plus.dto.sgc.SGC_Ficha5w1hDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIFActas.class */
public class JIFActas extends JInternalFrame {
    private SGC_ActasDAO xSGC_ActasDAO;
    public DefaultTableModel xModelo;
    public DefaultTableModel xModeloConclusion;
    public DefaultTableModel xModeloAsistentes;
    private Object[] xDatoActa;
    private Object[] xDatoConclusion;
    private Object[] xDatoAsistentes;
    private String[] xIdProceso;
    private String[] xIdTipoProceso;
    private String[] xIdTipoProcesoC;
    private String[] xIdTipoProcesoA;
    private String[] xIdTipoProcesoB;
    private String[] xIdAccion;
    private String[] xIdTipoReunion;
    private String[] xidPesonaCC;
    private String[] xidOrigen;
    private String[][] xidPesonaCA;
    private List<Object[]> listComboUConclusion;
    private List<Object[]> listComboUAsistentes;
    private ButtonGroup JBGTipoPersona;
    private JButton JBTAddAsistentes;
    private JButton JBTConclusion;
    private JComboBox JCBAccion;
    private JComboBox JCBOrigen;
    private JComboBox JCBPersonaAsistentes;
    private JComboBox JCBPersonaConclusion;
    private JComboBox JCBProceso;
    private JComboBox JCBProceso1;
    private JComboBox JCBProcesoAsistentes;
    private JComboBox JCBProcesoConclusion;
    private JComboBox JCBTipoReunion;
    private JCheckBox JCHAplicaFicha;
    private JCheckBox JCHEstado;
    private JCheckBox JCHFiltrar;
    public JDateChooser JDCHFechaActa;
    public JDateChooser JDCHFechaEjecucion;
    public JDateChooser JDFechaF;
    public JDateChooser JDFechaI;
    public JFormattedTextField JFTFHoraActa;
    public JFormattedTextField JFTFHoraFinalActa;
    private JPanel JPAsistentes;
    private JPanel JPConclusiones;
    private JPanel JPDatos;
    private JPanel JPHistorico;
    private JPanel JPPrincipal;
    private JPanel JPTipoPersona;
    private JRadioButton JRBPersonaExterna;
    private JRadioButton JRBPersonaInterna;
    private JScrollPane JSPAclaraciones;
    private JScrollPane JSPDesarrollo;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleAsistentes;
    private JScrollPane JSPDetalleConclusion;
    private JScrollPane JSPObjetivo;
    private JTextPane JTAAclaraciones;
    private JTextPane JTADesarrollo;
    private JTextPane JTAObjetivo;
    private JTable JTDetalle;
    public JTable JTDetalleAsistentes;
    private JTable JTDetalleConclusion;
    private JTextField JTFCargo;
    private JTextArea JTFDetalleConclusion;
    private JTextField JTFFiltroObjetivos;
    private JTextField JTFLugar;
    private JTextField JTFNombre;
    private JTabbedPane JTPGeneral;
    private JScrollPane jScrollPane1;
    private int xEstado = 1;
    private int xGuardarC = 0;
    private int xGuardarA = 0;
    private int xTipoPersona = 0;
    private Boolean xLleno = false;
    private Boolean xLleno1 = false;
    private Boolean xLleno2 = false;
    private Metodos xmt = new Metodos();

    public JIFActas() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xSGC_ActasDAO = (SGC_ActasDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("sGCActasDAO");
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JDCHFechaActa.setDate(this.xmt.getFechaActual());
        this.JFTFHoraActa.setValue(this.xmt.getFechaActual());
        this.JFTFHoraFinalActa.setValue(this.xmt.getFechaActual());
        this.JTFLugar.setText("");
        this.JTAObjetivo.setText("");
        this.JTAAclaraciones.setText("");
        this.JTADesarrollo.setText("");
        this.JDCHFechaEjecucion.setDate(this.xmt.getFechaActual());
        this.JTFDetalleConclusion.setText("");
        this.JBTAddAsistentes.setEnabled(true);
        this.JBTConclusion.setEnabled(true);
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JCBProceso1.setEnabled(false);
        this.xLleno2 = true;
        mLLenaCombo();
        mModeloAsistentes();
        mModeloConclusion();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JDCHFechaActa.getDate().toString().isEmpty()) {
            if (!this.JFTFHoraActa.getText().isEmpty()) {
                if (!this.JFTFHoraFinalActa.getText().isEmpty()) {
                    if (this.JCBProceso.getSelectedIndex() != -1) {
                        if (this.JCBTipoReunion.getSelectedIndex() != -1) {
                            if (!this.JTFLugar.getText().isEmpty()) {
                                if (!this.JTAObjetivo.getText().isEmpty()) {
                                    if (!this.JTAAclaraciones.getText().isEmpty()) {
                                        if (!this.JTADesarrollo.getText().isEmpty()) {
                                            if (this.JTDetalleAsistentes.getRowCount() != 0) {
                                                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                                if (n == 0) {
                                                    if (Principal.txtNo.getText().isEmpty()) {
                                                        SGC_ActasDTO xActa = new SGC_ActasDTO();
                                                        xActa.setFechActa(this.xmt.formatoAMD.format(this.JDCHFechaActa.getDate()));
                                                        xActa.setHora(this.xmt.formatoH24.format(this.JFTFHoraActa.getValue()));
                                                        xActa.setIdProceso(this.xIdTipoProceso[this.JCBProceso.getSelectedIndex()]);
                                                        xActa.setIdActividad("0");
                                                        xActa.setLugar(this.JTFLugar.getText());
                                                        xActa.setIdTipo(this.xIdTipoReunion[this.JCBTipoReunion.getSelectedIndex()]);
                                                        xActa.setObjetivo(this.JTAObjetivo.getText());
                                                        xActa.setAclaraciones(this.JTAAclaraciones.getText());
                                                        xActa.setDesarrollo(this.JTADesarrollo.getText());
                                                        xActa.setEstado(this.xEstado);
                                                        xActa.setHoraFinal(this.xmt.formatoH24.format(this.JFTFHoraFinalActa.getValue()));
                                                        String xidActa = this.xSGC_ActasDAO.create_return_id(xActa);
                                                        Principal.txtNo.setText(xidActa);
                                                        SGC_ActasAsistentesDTO xasistentes = new SGC_ActasAsistentesDTO();
                                                        for (int x = 0; x < this.JTDetalleAsistentes.getRowCount(); x++) {
                                                            xasistentes.setIdActa(Integer.parseInt(xidActa));
                                                            xasistentes.setEsExterno(this.xTipoPersona);
                                                            xasistentes.setIdTipoProceso(this.xModeloAsistentes.getValueAt(x, 0).toString());
                                                            xasistentes.setProceso(this.xModeloAsistentes.getValueAt(x, 1).toString());
                                                            xasistentes.setIdRhPersonaC(this.xModeloAsistentes.getValueAt(x, 2).toString());
                                                            xasistentes.setNbreIntegrante(this.xModeloAsistentes.getValueAt(x, 3).toString());
                                                            xasistentes.setCargo(this.xModeloAsistentes.getValueAt(x, 4).toString());
                                                            this.xSGC_ActasDAO.mCreateActaAsistentes(xasistentes);
                                                        }
                                                        SGC_Ficha5w1hDTO xficha = new SGC_Ficha5w1hDTO();
                                                        for (int x2 = 0; x2 < this.JTDetalleConclusion.getRowCount(); x2++) {
                                                            if (Boolean.valueOf(this.xModeloConclusion.getValueAt(x2, 11).toString()).booleanValue()) {
                                                                xficha.setFechaRF(this.xmt.formatoAMD.format(this.xmt.getFechaActual()));
                                                                xficha.setIdTipoAccion(this.xModeloConclusion.getValueAt(x2, 2).toString());
                                                                xficha.setIdOrigen(this.xModeloConclusion.getValueAt(x2, 10).toString());
                                                                xficha.setIdTipoProceso(this.xModeloConclusion.getValueAt(x2, 4).toString());
                                                                xficha.setIdRhPersonaR(this.xModeloConclusion.getValueAt(x2, 6).toString());
                                                                xficha.setIdRhPersonaRP(String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()));
                                                                xficha.setQue(this.xModeloConclusion.getValueAt(x2, 8).toString());
                                                                xficha.setCuando(this.xModeloConclusion.getValueAt(x2, 1).toString());
                                                                String xidFicha = this.xSGC_ActasDAO.create_return_idFicha(xficha);
                                                                this.xModeloConclusion.setValueAt(xidFicha, x2, 9);
                                                            }
                                                        }
                                                        SGC_ActasAccionConclusionDTO xconclusion = new SGC_ActasAccionConclusionDTO();
                                                        for (int x3 = 0; x3 < this.JTDetalleConclusion.getRowCount(); x3++) {
                                                            xconclusion.setIdActas(Integer.parseInt(xidActa));
                                                            xconclusion.setFechaEjecucion(this.xModeloConclusion.getValueAt(x3, 1).toString());
                                                            xconclusion.setIdTipoAccion(this.xModeloConclusion.getValueAt(x3, 2).toString());
                                                            xconclusion.setIdTipoProceso(this.xModeloConclusion.getValueAt(x3, 4).toString());
                                                            xconclusion.setIdRhPersonaC(this.xModeloConclusion.getValueAt(x3, 6).toString());
                                                            xconclusion.setDetalle(this.xModeloConclusion.getValueAt(x3, 8).toString());
                                                            xconclusion.setIdFicha(Integer.valueOf(this.xModeloConclusion.getValueAt(x3, 9).toString()).intValue());
                                                            this.xSGC_ActasDAO.mCreateActaConcluson(xconclusion);
                                                        }
                                                    } else {
                                                        SGC_ActasDTO xActa2 = new SGC_ActasDTO();
                                                        xActa2.setFechActa(this.xmt.formatoAMD.format(this.JDCHFechaActa.getDate()));
                                                        xActa2.setHora(this.xmt.formatoH24.format(this.JFTFHoraActa.getValue()));
                                                        xActa2.setIdProceso(this.xIdTipoProceso[this.JCBProceso.getSelectedIndex()]);
                                                        xActa2.setIdActividad("0");
                                                        xActa2.setLugar(this.JTFLugar.getText());
                                                        xActa2.setIdTipo(this.xIdTipoReunion[this.JCBTipoReunion.getSelectedIndex()]);
                                                        xActa2.setObjetivo(this.JTAObjetivo.getText());
                                                        xActa2.setAclaraciones(this.JTAAclaraciones.getText());
                                                        xActa2.setDesarrollo(this.JTADesarrollo.getText());
                                                        xActa2.setEstado(this.xEstado);
                                                        xActa2.setHoraFinal(this.xmt.formatoH24.format(this.JFTFHoraFinalActa.getValue()));
                                                        xActa2.setIdActas(Integer.valueOf(Principal.txtNo.getText()).intValue());
                                                        this.xSGC_ActasDAO.mUpdate(xActa2);
                                                    }
                                                    mNuevo();
                                                    return;
                                                }
                                                return;
                                            }
                                            JOptionPane.showMessageDialog(this, "Debe existir al menos un asistente", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                            this.JTPGeneral.setSelectedIndex(1);
                                            return;
                                        }
                                        JOptionPane.showMessageDialog(this, "Debe digitar el desarrollo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                        this.JTADesarrollo.requestFocus();
                                        return;
                                    }
                                    JOptionPane.showMessageDialog(this, "Debe digitar una aclaracion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    this.JTAAclaraciones.requestFocus();
                                    return;
                                }
                                JOptionPane.showMessageDialog(this, "Debe digitar el objetivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                this.JTAObjetivo.requestFocus();
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Debe digitar un lugar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            this.JTFLugar.requestFocus();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de reunion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JCBTipoReunion.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBProceso.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe digitar una hora final", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JFTFHoraActa.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe digitar una hora", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JFTFHoraActa.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe digitar una fecha", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JDCHFechaActa.requestFocus();
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] parametros = new String[3][2];
            parametros[0][0] = "Id";
            parametros[0][1] = Principal.txtNo.getText();
            parametros[1][0] = "SUBREPORT_DIR";
            parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[2][0] = "SUBREPORTFIRMA_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + Principal.informacionIps.getPrefijoReportes() + "SGC_Actas", parametros);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    private void mLLenaCombo() {
        this.xLleno = false;
        this.JCBTipoReunion.removeAllItems();
        List<GCGenericoDTO> listiporeunion = this.xSGC_ActasDAO.listTipoReunion();
        this.xIdTipoReunion = new String[listiporeunion.size()];
        for (int x = 0; x < listiporeunion.size(); x++) {
            this.xIdTipoReunion[x] = String.valueOf(listiporeunion.get(x).getId());
            this.JCBTipoReunion.addItem(listiporeunion.get(x).getNombre());
        }
        this.JCBTipoReunion.setSelectedIndex(-1);
        this.JCBProceso.removeAllItems();
        List<GCGenericoDTO> listipoproceso = this.xSGC_ActasDAO.lisTipoProceso();
        this.xIdTipoProceso = new String[listipoproceso.size()];
        for (int x2 = 0; x2 < listipoproceso.size(); x2++) {
            this.xIdTipoProceso[x2] = String.valueOf(listipoproceso.get(x2).getId());
            this.JCBProceso.addItem(listipoproceso.get(x2).getNombre());
        }
        this.JCBProceso.setSelectedIndex(-1);
        this.JCBProcesoAsistentes.removeAllItems();
        List<GCGenericoDTO> listipoprocesoA = this.xSGC_ActasDAO.lisTipoProceso();
        this.xIdTipoProcesoA = new String[listipoprocesoA.size()];
        for (int x3 = 0; x3 < listipoprocesoA.size(); x3++) {
            this.xIdTipoProcesoA[x3] = String.valueOf(listipoprocesoA.get(x3).getId());
            this.JCBProcesoAsistentes.addItem(listipoprocesoA.get(x3).getNombre());
        }
        this.JCBProcesoAsistentes.setSelectedIndex(-1);
        this.JCBProcesoConclusion.removeAllItems();
        List<GCGenericoDTO> listipoprocesoC = this.xSGC_ActasDAO.lisTipoProceso();
        this.xIdTipoProcesoC = new String[listipoprocesoC.size()];
        for (int x4 = 0; x4 < listipoprocesoC.size(); x4++) {
            this.xIdTipoProcesoC[x4] = String.valueOf(listipoprocesoC.get(x4).getId());
            this.JCBProcesoConclusion.addItem(listipoprocesoC.get(x4).getNombre());
        }
        this.JCBProcesoConclusion.setSelectedIndex(-1);
        this.JCBAccion.removeAllItems();
        List<GCGenericoDTO> listAccion = this.xSGC_ActasDAO.listComboAccion();
        this.xIdAccion = new String[listAccion.size()];
        for (int x5 = 0; x5 < listAccion.size(); x5++) {
            this.xIdAccion[x5] = String.valueOf(listAccion.get(x5).getId());
            this.JCBAccion.addItem(listAccion.get(x5).getNombre());
        }
        this.JCBAccion.setSelectedIndex(-1);
        this.JCBOrigen.removeAllItems();
        List<GCGenericoDTO> listOrigen = this.xSGC_ActasDAO.listOrigen(0);
        this.xidOrigen = new String[listOrigen.size()];
        for (int x6 = 0; x6 < listOrigen.size(); x6++) {
            this.xidOrigen[x6] = String.valueOf(listOrigen.get(x6).getId());
            this.JCBOrigen.addItem(listOrigen.get(x6).getNombre());
        }
        this.JCBOrigen.setSelectedIndex(-1);
        this.JCBProceso1.removeAllItems();
        List<GCGenericoDTO> listipoprocesoB = this.xSGC_ActasDAO.lisTipoProceso();
        this.xIdTipoProcesoB = new String[listipoprocesoB.size()];
        for (int x7 = 0; x7 < listipoprocesoB.size(); x7++) {
            this.xIdTipoProcesoB[x7] = String.valueOf(listipoprocesoB.get(x7).getId());
            this.JCBProceso1.addItem(listipoprocesoB.get(x7).getNombre());
        }
        this.JCBProceso1.setSelectedIndex(-1);
        this.JCBPersonaAsistentes.removeAllItems();
        this.JCBPersonaConclusion.removeAllItems();
        this.xLleno = true;
    }

    private void mModeloAsistentes() {
        this.xModeloAsistentes = new DefaultTableModel((Object[][]) null, new String[]{"IdTipoProceso", "Tipo Proceso", "IdPersonaC", "Responsable", "Cargo", "Firmado?", "Accion", "EsExterno?", "Id"}) { // from class: com.genoma.plus.controller.sgc.JIFActas.1
            Class[] types = {Integer.class, String.class, Integer.class, String.class, String.class, Boolean.class, JButton.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleAsistentes.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: com.genoma.plus.controller.sgc.JIFActas.2
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        JTable jTable = this.JTDetalleAsistentes;
        JTable jTable2 = this.JTDetalleAsistentes;
        jTable.setAutoResizeMode(0);
        this.JTDetalleAsistentes.doLayout();
        this.JTDetalleAsistentes.setModel(this.xModeloAsistentes);
        this.JTDetalleAsistentes.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleAsistentes.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleAsistentes.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleAsistentes.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleAsistentes.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalleAsistentes.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalleAsistentes.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalleAsistentes.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleAsistentes.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleAsistentes.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalleAsistentes.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalleAsistentes.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalleAsistentes.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleAsistentes.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleAsistentes.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    private void mModeloConclusion() {
        this.xModeloConclusion = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "IdAccion", "Accion", "IdTipoProceso", "Tipo Proceso", "IdPersonaC", "Responsable", "Detalle", "IdFicha", "IdOrigen", "AplicaFicha"}) { // from class: com.genoma.plus.controller.sgc.JIFActas.3
            Class[] types = {Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleConclusion;
        JTable jTable2 = this.JTDetalleConclusion;
        jTable.setAutoResizeMode(0);
        this.JTDetalleConclusion.doLayout();
        this.JTDetalleConclusion.setModel(this.xModeloConclusion);
        this.JTDetalleConclusion.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleConclusion.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleConclusion.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(5).setPreferredWidth(400);
        this.JTDetalleConclusion.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalleConclusion.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalleConclusion.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleConclusion.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalleConclusion.getColumnModel().getColumn(11).setPreferredWidth(100);
    }

    private void mModelo() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Hora", "Hora Final", "Proceso", "Actividad", "Lugar", "Reunion", "Objetivo", "Aclaraciones", "Desarrollo", "Estado"}) { // from class: com.genoma.plus.controller.sgc.JIFActas.4
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        List<SGC_ActasDTO> list;
        mModelo();
        if (this.JCHFiltrar.isSelected()) {
            list = this.xSGC_ActasDAO.listActas(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), this.xIdTipoProcesoB[this.JCBProceso1.getSelectedIndex()], this.JTFFiltroObjetivos.getText());
        } else {
            list = this.xSGC_ActasDAO.listActas(this.xmt.formatoAMD.format(this.JDFechaI.getDate()), this.xmt.formatoAMD.format(this.JDFechaF.getDate()), "", this.JTFFiltroObjetivos.getText());
        }
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xModelo.addRow(this.xDatoActa);
                this.xModelo.setValueAt(Integer.valueOf(list.get(x).getIdActas()), x, 0);
                this.xModelo.setValueAt(list.get(x).getFechActa(), x, 1);
                this.xModelo.setValueAt(list.get(x).getHora(), x, 2);
                this.xModelo.setValueAt(list.get(x).getIdProceso(), x, 3);
                this.xModelo.setValueAt(list.get(x).getIdActividad(), x, 4);
                this.xModelo.setValueAt(list.get(x).getLugar(), x, 5);
                this.xModelo.setValueAt(list.get(x).getIdTipo(), x, 6);
                this.xModelo.setValueAt(list.get(x).getObjetivo(), x, 7);
                this.xModelo.setValueAt(list.get(x).getAclaraciones(), x, 8);
                this.xModelo.setValueAt(list.get(x).getDesarrollo(), x, 9);
                if (list.get(x).getEstado() == 1) {
                    this.xModelo.setValueAt(true, x, 10);
                } else {
                    this.xModelo.setValueAt(false, x, 10);
                }
            }
        }
    }

    public void mCargarDatosTablaAsistentes() {
        mModeloAsistentes();
        List<SGC_ActasAsistentesDTO> list = this.xSGC_ActasDAO.listAsistentes(Principal.txtNo.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xModeloAsistentes.addRow(this.xDatoAsistentes);
            this.xModeloAsistentes.setValueAt(list.get(x).getIdTipoProceso(), x, 0);
            this.xModeloAsistentes.setValueAt(list.get(x).getProceso(), x, 1);
            this.xModeloAsistentes.setValueAt(list.get(x).getIdRhPersonaC(), x, 2);
            this.xModeloAsistentes.setValueAt(list.get(x).getNbreIntegrante(), x, 3);
            this.xModeloAsistentes.setValueAt(list.get(x).getCargo(), x, 4);
            if (list.get(x).getFirmo() == 1) {
                this.xModeloAsistentes.setValueAt(true, x, 5);
            } else {
                this.xModeloAsistentes.setValueAt(false, x, 5);
            }
            this.xModeloAsistentes.setValueAt(new JButton("Firmar"), x, 6);
            if (list.get(x).getEsExterno() == 1) {
                this.xModeloAsistentes.setValueAt(true, x, 7);
            } else {
                this.xModeloAsistentes.setValueAt(false, x, 7);
            }
            this.xModeloAsistentes.setValueAt(list.get(x).getId(), x, 8);
        }
    }

    private void mCargarDatosTablaConclusiones() {
        mModeloConclusion();
        List<SGC_ActasAccionConclusionDTO> list = this.xSGC_ActasDAO.listConclusion(Principal.txtNo.getText());
        for (int x = 0; x < list.size(); x++) {
            this.xModeloConclusion.addRow(this.xDatoConclusion);
            this.xModeloConclusion.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xModeloConclusion.setValueAt(list.get(x).getFechaEjecucion(), x, 1);
            this.xModeloConclusion.setValueAt(list.get(x).getIdTipoAccion(), x, 3);
            this.xModeloConclusion.setValueAt(list.get(x).getIdTipoProceso(), x, 5);
            this.xModeloConclusion.setValueAt(list.get(x).getIdRhPersonaC(), x, 7);
            this.xModeloConclusion.setValueAt(list.get(x).getDetalle(), x, 8);
            this.xModeloConclusion.setValueAt(Integer.valueOf(list.get(x).getIdFicha()), x, 9);
        }
    }

    /* JADX WARN: Type inference failed for: r3v129, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v169, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v80, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipoPersona = new ButtonGroup();
        this.JTPGeneral = new JTabbedPane();
        this.JPPrincipal = new JPanel();
        this.JPDatos = new JPanel();
        this.JDCHFechaActa = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFLugar = new JTextField();
        this.JFTFHoraActa = new JFormattedTextField();
        this.JCBProceso = new JComboBox();
        this.JCBTipoReunion = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JSPAclaraciones = new JScrollPane();
        this.JTAAclaraciones = new JTextPane();
        this.JSPDesarrollo = new JScrollPane();
        this.JTADesarrollo = new JTextPane();
        this.JSPObjetivo = new JScrollPane();
        this.JTAObjetivo = new JTextPane();
        this.JPAsistentes = new JPanel();
        this.JCBProcesoAsistentes = new JComboBox();
        this.JCBPersonaAsistentes = new JComboBox();
        this.JBTAddAsistentes = new JButton();
        this.JSPDetalleAsistentes = new JScrollPane();
        this.JTDetalleAsistentes = new JTable();
        this.JPTipoPersona = new JPanel();
        this.JRBPersonaInterna = new JRadioButton();
        this.JRBPersonaExterna = new JRadioButton();
        this.JTFCargo = new JTextField();
        this.JTFNombre = new JTextField();
        this.JPConclusiones = new JPanel();
        this.JCBProcesoConclusion = new JComboBox();
        this.JCBPersonaConclusion = new JComboBox();
        this.JCBAccion = new JComboBox();
        this.JDCHFechaEjecucion = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JSPDetalleConclusion = new JScrollPane();
        this.JTDetalleConclusion = new JTable();
        this.JBTConclusion = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTFDetalleConclusion = new JTextArea();
        this.JCBOrigen = new JComboBox();
        this.JCHAplicaFicha = new JCheckBox();
        this.JFTFHoraFinalActa = new JFormattedTextField();
        this.JPHistorico = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JDFechaF = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JDFechaI = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JCBProceso1 = new JComboBox();
        this.JCHFiltrar = new JCheckBox();
        this.JTFFiltroObjetivos = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("ACTAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifactas");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.5
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFActas.this.formInternalFrameClosing(evt);
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
        this.JTPGeneral.setForeground(Color.red);
        this.JTPGeneral.setFont(new Font("Arial", 1, 14));
        this.JPPrincipal.setFont(new Font("Arial", 1, 14));
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCHFechaActa.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaActa.setDateFormatString("dd/MM/yyyy");
        this.JDCHFechaActa.setFont(new Font("Arial", 1, 12));
        this.JTFLugar.setFont(new Font("Arial", 1, 12));
        this.JTFLugar.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFHoraActa.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFHoraActa.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.JFTFHoraActa.setFont(new Font("Tahoma", 1, 12));
        this.JFTFHoraActa.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFActas.6
            public void keyPressed(KeyEvent evt) {
                JIFActas.this.JFTFHoraActaKeyPressed(evt);
            }
        });
        this.JCBProceso.setFont(new Font("Arial", 1, 12));
        this.JCBProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProceso.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.7
            public void itemStateChanged(ItemEvent evt) {
                JIFActas.this.JCBProcesoItemStateChanged(evt);
            }
        });
        this.JCBTipoReunion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoReunion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Reunion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoReunion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.8
            public void itemStateChanged(ItemEvent evt) {
                JIFActas.this.JCBTipoReunionItemStateChanged(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.9
            public void actionPerformed(ActionEvent evt) {
                JIFActas.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JDCHFechaActa, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFHoraActa, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProceso, -2, 380, -2).addGap(10, 10, 10)).addGroup(JPDatosLayout.createSequentialGroup().addComponent(this.JCBTipoReunion, -2, 318, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFLugar).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addContainerGap()))));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDCHFechaActa, -1, -1, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFHoraActa, -1, 50, 32767).addComponent(this.JCBProceso, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoReunion, -2, 50, -2).addComponent(this.JTFLugar, -2, 51, -2).addComponent(this.JCHEstado))));
        this.JSPAclaraciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPAclaraciones.setMinimumSize((Dimension) null);
        this.JTAAclaraciones.setFont(new Font("Arial", 1, 12));
        this.JSPAclaraciones.setViewportView(this.JTAAclaraciones);
        this.JSPDesarrollo.setBorder(BorderFactory.createTitledBorder((Border) null, "Desarrollo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDesarrollo.setMinimumSize((Dimension) null);
        this.JTADesarrollo.setFont(new Font("Arial", 1, 12));
        this.JSPDesarrollo.setViewportView(this.JTADesarrollo);
        this.JSPObjetivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Objetivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObjetivo.setMinimumSize((Dimension) null);
        this.JTAObjetivo.setFont(new Font("Arial", 1, 12));
        this.JSPObjetivo.setViewportView(this.JTAObjetivo);
        GroupLayout JPPrincipalLayout = new GroupLayout(this.JPPrincipal);
        this.JPPrincipal.setLayout(JPPrincipalLayout);
        JPPrincipalLayout.setHorizontalGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPrincipalLayout.createSequentialGroup().addContainerGap().addGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -2, -1, -2).addComponent(this.JSPObjetivo, -2, 674, -2).addComponent(this.JSPDesarrollo, -2, 674, -2).addComponent(this.JSPAclaraciones, -2, 674, -2)).addContainerGap(-1, 32767)));
        JPPrincipalLayout.setVerticalGroup(JPPrincipalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPrincipalLayout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObjetivo, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDesarrollo, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPAclaraciones, -2, 113, -2).addContainerGap(-1, 32767)));
        this.JTPGeneral.addTab("DATOS", this.JPPrincipal);
        this.JCBProcesoAsistentes.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoAsistentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoAsistentes.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.10
            public void itemStateChanged(ItemEvent evt) {
                JIFActas.this.JCBProcesoAsistentesItemStateChanged(evt);
            }
        });
        this.JCBPersonaAsistentes.setFont(new Font("Arial", 1, 12));
        this.JCBPersonaAsistentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPersonaAsistentes.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.11
            public void itemStateChanged(ItemEvent evt) {
                JIFActas.this.JCBPersonaAsistentesItemStateChanged(evt);
            }
        });
        this.JCBPersonaAsistentes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.12
            public void actionPerformed(ActionEvent evt) {
                JIFActas.this.JCBPersonaAsistentesActionPerformed(evt);
            }
        });
        this.JBTAddAsistentes.setFont(new Font("Arial", 1, 12));
        this.JBTAddAsistentes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAddAsistentes.setToolTipText("Buscar Evento Adverso");
        this.JBTAddAsistentes.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.13
            public void actionPerformed(ActionEvent evt) {
                JIFActas.this.JBTAddAsistentesActionPerformed(evt);
            }
        });
        this.JTDetalleAsistentes.setFont(new Font("Arial", 1, 12));
        this.JTDetalleAsistentes.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleAsistentes.setSelectionBackground(Color.white);
        this.JTDetalleAsistentes.setSelectionForeground(Color.red);
        this.JTDetalleAsistentes.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFActas.14
            public void mouseClicked(MouseEvent evt) {
                JIFActas.this.JTDetalleAsistentesMouseClicked(evt);
            }
        });
        this.JTDetalleAsistentes.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFActas.15
            public void keyPressed(KeyEvent evt) {
                JIFActas.this.JTDetalleAsistentesKeyPressed(evt);
            }
        });
        this.JSPDetalleAsistentes.setViewportView(this.JTDetalleAsistentes);
        this.JPTipoPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Persona", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipoPersona.add(this.JRBPersonaInterna);
        this.JRBPersonaInterna.setFont(new Font("Arial", 1, 12));
        this.JRBPersonaInterna.setSelected(true);
        this.JRBPersonaInterna.setText("Interna");
        this.JRBPersonaInterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.16
            public void actionPerformed(ActionEvent evt) {
                JIFActas.this.JRBPersonaInternaActionPerformed(evt);
            }
        });
        this.JBGTipoPersona.add(this.JRBPersonaExterna);
        this.JRBPersonaExterna.setFont(new Font("Arial", 1, 12));
        this.JRBPersonaExterna.setText("Externa");
        this.JRBPersonaExterna.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.17
            public void actionPerformed(ActionEvent evt) {
                JIFActas.this.JRBPersonaExternaActionPerformed(evt);
            }
        });
        GroupLayout JPTipoPersonaLayout = new GroupLayout(this.JPTipoPersona);
        this.JPTipoPersona.setLayout(JPTipoPersonaLayout);
        JPTipoPersonaLayout.setHorizontalGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoPersonaLayout.createSequentialGroup().addGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBPersonaInterna).addComponent(this.JRBPersonaExterna)).addGap(10, 10, 10)));
        JPTipoPersonaLayout.setVerticalGroup(JPTipoPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoPersonaLayout.createSequentialGroup().addComponent(this.JRBPersonaInterna).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBPersonaExterna).addContainerGap()));
        this.JTFCargo.setFont(new Font("Arial", 1, 12));
        this.JTFCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPAsistentesLayout = new GroupLayout(this.JPAsistentes);
        this.JPAsistentes.setLayout(JPAsistentesLayout);
        JPAsistentesLayout.setHorizontalGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAsistentesLayout.createSequentialGroup().addContainerGap().addGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleAsistentes, GroupLayout.Alignment.TRAILING, -1, 671, 32767).addComponent(this.JBTAddAsistentes, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPAsistentesLayout.createSequentialGroup().addGap(0, 18, 32767).addComponent(this.JPTipoPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBProcesoAsistentes, -2, 253, -2).addComponent(this.JTFCargo, -2, 253, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBPersonaAsistentes, -2, 300, -2).addComponent(this.JTFNombre, -2, 300, -2)).addGap(1, 1, 1))).addContainerGap()));
        JPAsistentesLayout.setVerticalGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAsistentesLayout.createSequentialGroup().addContainerGap().addGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAsistentesLayout.createSequentialGroup().addGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPersonaAsistentes, -2, 50, -2).addComponent(this.JCBProcesoAsistentes, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCargo, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2))).addComponent(this.JPTipoPersona, -1, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAddAsistentes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleAsistentes, -1, 294, 32767).addContainerGap()));
        this.JTFCargo.setVisible(false);
        this.JTFNombre.setVisible(false);
        this.JTPGeneral.addTab("ASISTENTES", this.JPAsistentes);
        this.JCBProcesoConclusion.setFont(new Font("Arial", 1, 12));
        this.JCBProcesoConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcesoConclusion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.18
            public void itemStateChanged(ItemEvent evt) {
                JIFActas.this.JCBProcesoConclusionItemStateChanged(evt);
            }
        });
        this.JCBPersonaConclusion.setFont(new Font("Arial", 1, 12));
        this.JCBPersonaConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPersonaConclusion.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.19
            public void itemStateChanged(ItemEvent evt) {
                JIFActas.this.JCBPersonaConclusionItemStateChanged(evt);
            }
        });
        this.JCBAccion.setFont(new Font("Arial", 1, 12));
        this.JCBAccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Accion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaEjecucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Acción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCHFechaEjecucion.setDateFormatString("dd/MM/yyyy");
        this.JDCHFechaEjecucion.setFont(new Font("Arial", 1, 12));
        this.JTDetalleConclusion.setFont(new Font("Arial", 1, 12));
        this.JTDetalleConclusion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleConclusion.setSelectionBackground(Color.white);
        this.JTDetalleConclusion.setSelectionForeground(Color.red);
        this.JTDetalleConclusion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFActas.20
            public void keyPressed(KeyEvent evt) {
                JIFActas.this.JTDetalleConclusionKeyPressed(evt);
            }
        });
        this.JSPDetalleConclusion.setViewportView(this.JTDetalleConclusion);
        this.JBTConclusion.setFont(new Font("Arial", 1, 12));
        this.JBTConclusion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTConclusion.setToolTipText("Buscar Evento Adverso");
        this.JBTConclusion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.21
            public void actionPerformed(ActionEvent evt) {
                JIFActas.this.JBTConclusionActionPerformed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDetalleConclusion.setColumns(20);
        this.JTFDetalleConclusion.setFont(new Font("Arial", 1, 12));
        this.JTFDetalleConclusion.setRows(5);
        this.jScrollPane1.setViewportView(this.JTFDetalleConclusion);
        this.JCBOrigen.setFont(new Font("Arial", 1, 12));
        this.JCBOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "Origen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAplicaFicha.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaFicha.setSelected(true);
        this.JCHAplicaFicha.setText("Aplica Ficha 5W1H");
        this.JFTFHoraFinalActa.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFHoraFinalActa.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.JFTFHoraFinalActa.setFont(new Font("Tahoma", 1, 12));
        this.JFTFHoraFinalActa.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFActas.22
            public void keyPressed(KeyEvent evt) {
                JIFActas.this.JFTFHoraFinalActaKeyPressed(evt);
            }
        });
        GroupLayout JPConclusionesLayout = new GroupLayout(this.JPConclusiones);
        this.JPConclusiones.setLayout(JPConclusionesLayout);
        JPConclusionesLayout.setHorizontalGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConclusionesLayout.createSequentialGroup().addContainerGap().addGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleConclusion).addGroup(JPConclusionesLayout.createSequentialGroup().addComponent(this.JCBProcesoConclusion, -2, 286, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPersonaConclusion, 0, -1, 32767)).addGroup(JPConclusionesLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 436, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHAplicaFicha).addComponent(this.JFTFHoraFinalActa, -2, 113, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTConclusion, -1, 98, 32767)).addGroup(JPConclusionesLayout.createSequentialGroup().addComponent(this.JDCHFechaEjecucion, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBOrigen, -2, 265, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBAccion, -2, 274, -2))).addContainerGap()));
        JPConclusionesLayout.setVerticalGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConclusionesLayout.createSequentialGroup().addContainerGap().addGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCHFechaEjecucion, -2, 52, -2).addGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBAccion, -2, 50, -2).addComponent(this.JCBOrigen, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProcesoConclusion, -2, 50, -2).addComponent(this.JCBPersonaConclusion, -2, 50, -2)).addGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPConclusionesLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane1, -2, 81, -2)).addGroup(JPConclusionesLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConclusionesLayout.createSequentialGroup().addComponent(this.JCHAplicaFicha).addGap(4, 4, 4).addComponent(this.JFTFHoraFinalActa)).addComponent(this.JBTConclusion, -2, 73, -2)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleConclusion, -1, 256, 32767).addContainerGap()));
        this.JTPGeneral.addTab("CONCLUSIONES", this.JPConclusiones);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIFActas.23
            public void mouseClicked(MouseEvent evt) {
                JIFActas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.24
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFActas.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.25
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFActas.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JCBProceso1.setFont(new Font("Arial", 1, 12));
        this.JCBProceso1.setBorder(BorderFactory.createTitledBorder((Border) null, "Proceso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProceso1.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.26
            public void itemStateChanged(ItemEvent evt) {
                JIFActas.this.JCBProceso1ItemStateChanged(evt);
            }
        });
        this.JCBProceso1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.27
            public void actionPerformed(ActionEvent evt) {
                JIFActas.this.JCBProceso1ActionPerformed(evt);
            }
        });
        this.JCHFiltrar.setText("Filtrar");
        this.JCHFiltrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JIFActas.28
            public void actionPerformed(ActionEvent evt) {
                JIFActas.this.JCHFiltrarActionPerformed(evt);
            }
        });
        this.JTFFiltroObjetivos.setFont(new Font("Arial", 1, 12));
        this.JTFFiltroObjetivos.setBorder(BorderFactory.createTitledBorder((Border) null, "Objetivos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltroObjetivos.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JIFActas.29
            public void keyPressed(KeyEvent evt) {
                JIFActas.this.JTFFiltroObjetivosKeyPressed(evt);
            }
        });
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addGroup(JPHistoricoLayout.createSequentialGroup().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFiltroObjetivos, -2, 671, -2).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProceso1, -2, 334, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltrar))).addGap(0, 17, 32767))).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 52, -2).addComponent(this.JDFechaF, -2, 52, -2)).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHFiltrar).addComponent(this.JCBProceso1, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFiltroObjetivos, -2, 50, -2).addGap(10, 10, 10).addComponent(this.JSPDetalle, -2, 323, -2).addContainerGap()));
        this.JTPGeneral.addTab("HISTÓRICO", this.JPHistorico);
        this.JPHistorico.getAccessibleContext().setAccessibleName("");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPGeneral, -2, 700, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPGeneral, -2, 498, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFHoraActaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JFTFHoraActa.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoReunionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoConclusionItemStateChanged(ItemEvent evt) {
        Boolean boolValueOf = Boolean.valueOf(this.JCBProcesoConclusion.getSelectedIndex() != -1);
        this.xLleno = boolValueOf;
        if (boolValueOf.booleanValue()) {
            this.xLleno1 = false;
            this.JCBPersonaConclusion.removeAllItems();
            List<SGC_ActasAsistentesDTO> list1 = this.xSGC_ActasDAO.listComboUsuario(this.xIdTipoProcesoC[this.JCBProcesoConclusion.getSelectedIndex()]);
            this.xidPesonaCC = new String[list1.size()];
            for (int x = 0; x < list1.size(); x++) {
                this.xidPesonaCC[x] = String.valueOf(list1.get(x).getIdRhPersonaC());
                this.JCBPersonaConclusion.addItem(list1.get(x).getNbreIntegrante());
            }
            this.JCBPersonaConclusion.setSelectedIndex(-1);
            this.xLleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPersonaConclusionItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConclusionActionPerformed(ActionEvent evt) {
        if (!this.JDCHFechaEjecucion.getDate().toString().isEmpty()) {
            if (this.JCBAccion.getSelectedIndex() != -1) {
                if (this.JCBProcesoConclusion.getSelectedIndex() != -1) {
                    if (this.JCBPersonaConclusion.getSelectedIndex() != -1) {
                        if (!this.JTFDetalleConclusion.getText().isEmpty()) {
                            this.xModeloConclusion.addRow(this.xDatoConclusion);
                            int xfila = this.xModeloConclusion.getRowCount() - 1;
                            this.xModeloConclusion.setValueAt(this.xmt.formatoAMD1.format(this.JDCHFechaEjecucion.getDate()), xfila, 1);
                            this.xModeloConclusion.setValueAt(this.xIdAccion[this.JCBAccion.getSelectedIndex()], xfila, 2);
                            this.xModeloConclusion.setValueAt(this.JCBAccion.getSelectedItem().toString().toUpperCase(), xfila, 3);
                            this.xModeloConclusion.setValueAt(this.xIdTipoProcesoC[this.JCBProcesoConclusion.getSelectedIndex()], xfila, 4);
                            this.xModeloConclusion.setValueAt(this.JCBProcesoConclusion.getSelectedItem(), xfila, 5);
                            this.xModeloConclusion.setValueAt(this.xidPesonaCC[this.JCBPersonaConclusion.getSelectedIndex()], xfila, 6);
                            this.xModeloConclusion.setValueAt(this.JCBPersonaConclusion.getSelectedItem(), xfila, 7);
                            this.xModeloConclusion.setValueAt(this.JTFDetalleConclusion.getText(), xfila, 8);
                            this.xModeloConclusion.setValueAt(this.xidOrigen[this.JCBOrigen.getSelectedIndex()], xfila, 10);
                            this.xModeloConclusion.setValueAt(Boolean.valueOf(this.JCHAplicaFicha.isSelected()), xfila, 11);
                            this.JDCHFechaEjecucion.setDate(this.xmt.getFechaActual());
                            this.JCBOrigen.setSelectedIndex(-1);
                            this.JCBAccion.setSelectedIndex(-1);
                            this.JCHAplicaFicha.setSelected(true);
                            this.JCBProcesoConclusion.setSelectedIndex(-1);
                            this.JCBPersonaConclusion.removeAllItems();
                            this.JTFDetalleConclusion.setText("");
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Debe digitar un detalle de la conclusion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        this.JTFDetalleConclusion.requestFocus();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un responsable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCBAccion.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un Proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCBProcesoConclusion.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una accion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBProcesoConclusion.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "El campo de fecha ejecucion no puede estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBProcesoConclusion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcesoAsistentesItemStateChanged(ItemEvent evt) {
        Boolean boolValueOf = Boolean.valueOf(this.JCBProcesoAsistentes.getSelectedIndex() != -1);
        this.xLleno = boolValueOf;
        if (boolValueOf.booleanValue()) {
            this.xLleno1 = false;
            this.JCBPersonaAsistentes.removeAllItems();
            List<SGC_ActasAsistentesDTO> list1 = this.xSGC_ActasDAO.listComboUsuario(this.xIdTipoProcesoA[this.JCBProcesoAsistentes.getSelectedIndex()]);
            this.xidPesonaCA = new String[list1.size()][3];
            for (int x = 0; x < list1.size(); x++) {
                this.xidPesonaCA[x][0] = String.valueOf(list1.get(x).getIdRhPersonaC());
                this.xidPesonaCA[x][1] = String.valueOf(list1.get(x).getNbreIntegrante());
                this.xidPesonaCA[x][2] = String.valueOf(list1.get(x).getCargo());
                this.JCBPersonaAsistentes.addItem(list1.get(x).getNbreIntegrante());
            }
            this.JCBPersonaAsistentes.setSelectedIndex(-1);
            this.xLleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPersonaAsistentesItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAddAsistentesActionPerformed(ActionEvent evt) {
        if (this.JCBProcesoAsistentes.getSelectedIndex() != -1 || this.xTipoPersona == 1) {
            if (this.JCBPersonaAsistentes.getSelectedIndex() != -1 || this.xTipoPersona == 1) {
                this.xModeloAsistentes.addRow(this.xDatoAsistentes);
                if (this.xTipoPersona == 0) {
                    this.xModeloAsistentes.setValueAt(this.xIdTipoProcesoA[this.JCBProcesoAsistentes.getSelectedIndex()], this.xModeloAsistentes.getRowCount() - 1, 0);
                    this.xModeloAsistentes.setValueAt(this.JCBProcesoAsistentes.getSelectedItem(), this.xModeloAsistentes.getRowCount() - 1, 1);
                    this.xModeloAsistentes.setValueAt(this.xidPesonaCA[this.JCBPersonaAsistentes.getSelectedIndex()][0], this.xModeloAsistentes.getRowCount() - 1, 2);
                    this.xModeloAsistentes.setValueAt(this.JCBPersonaAsistentes.getSelectedItem(), this.xModeloAsistentes.getRowCount() - 1, 3);
                    this.xModeloAsistentes.setValueAt(this.xidPesonaCA[this.JCBPersonaAsistentes.getSelectedIndex()][2].toUpperCase(), this.xModeloAsistentes.getRowCount() - 1, 4);
                } else {
                    this.xModeloAsistentes.setValueAt("0", this.xModeloAsistentes.getRowCount() - 1, 0);
                    this.xModeloAsistentes.setValueAt("NO APLICA", this.xModeloAsistentes.getRowCount() - 1, 1);
                    this.xModeloAsistentes.setValueAt("0", this.xModeloAsistentes.getRowCount() - 1, 2);
                    this.xModeloAsistentes.setValueAt(this.JTFNombre.getText().toUpperCase(), this.xModeloAsistentes.getRowCount() - 1, 3);
                    this.xModeloAsistentes.setValueAt(this.JTFCargo.getText().toUpperCase(), this.xModeloAsistentes.getRowCount() - 1, 4);
                }
                this.xModeloAsistentes.setValueAt(false, this.xModeloAsistentes.getRowCount() - 1, 5);
                this.xModeloAsistentes.setValueAt(new JButton("Firmar"), this.xModeloAsistentes.getRowCount() - 1, 6);
                if (this.xTipoPersona == 1) {
                    this.xModeloAsistentes.setValueAt(true, this.xModeloAsistentes.getRowCount() - 1, 7);
                } else {
                    this.xModeloAsistentes.setValueAt(false, this.xModeloAsistentes.getRowCount() - 1, 7);
                }
                this.JCBProcesoAsistentes.setSelectedIndex(-1);
                this.JCBPersonaAsistentes.removeAllItems();
                this.JTFNombre.setText("");
                this.JTFCargo.setText("");
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar a un responsable", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBPersonaAsistentes.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una proceso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBProcesoAsistentes.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPersonaAsistentesActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleAsistentesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleAsistentes.getSelectedRow() != -1 && Principal.txtNo.getText().isEmpty()) {
            this.xModeloAsistentes.removeRow(this.JTDetalleAsistentes.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleConclusionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleConclusion.getSelectedRow() != -1 && Principal.txtNo.getText().isEmpty()) {
            this.xModeloConclusion.removeRow(this.JTDetalleConclusion.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JDCHFechaActa.setDate(Date.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()));
            this.JFTFHoraActa.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBProceso.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFLugar.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCBTipoReunion.setSelectedItem(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JTAObjetivo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JTAAclaraciones.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JTADesarrollo.setText(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xEstado = 1;
            } else {
                this.xEstado = 0;
            }
            mCargarDatosTablaAsistentes();
            mCargarDatosTablaConclusiones();
            this.JTPGeneral.setSelectedIndex(0);
            this.JBTAddAsistentes.setEnabled(false);
            this.JBTConclusion.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleAsistentesMouseClicked(MouseEvent evt) {
        if (this.JTDetalleAsistentes.getSelectedRow() != -1 && this.JTDetalleAsistentes.getSelectedColumn() == 6 && !Principal.txtNo.getText().isEmpty()) {
            JDBiometrico xjdBiometrico = new JDBiometrico(null, true, "jifactas", this.xModeloAsistentes.getValueAt(this.JTDetalleAsistentes.getSelectedRow(), 8).toString());
            xjdBiometrico.setTemplate(null);
            xjdBiometrico.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPersonaInternaActionPerformed(ActionEvent evt) {
        this.xTipoPersona = 0;
        this.JTFNombre.setText("");
        this.JTFCargo.setText("");
        this.JTFNombre.setVisible(false);
        this.JTFCargo.setVisible(false);
        this.JCBPersonaAsistentes.setVisible(true);
        this.JCBProcesoAsistentes.setVisible(true);
        this.JCBPersonaAsistentes.setSelectedIndex(-1);
        this.JCBProcesoAsistentes.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPersonaExternaActionPerformed(ActionEvent evt) {
        this.xTipoPersona = 1;
        this.JTFNombre.setText("");
        this.JTFCargo.setText("");
        this.JTFNombre.setVisible(true);
        this.JTFCargo.setVisible(true);
        this.JCBProcesoAsistentes.setSelectedIndex(-1);
        this.JCBPersonaAsistentes.setSelectedIndex(-1);
        this.JCBPersonaAsistentes.setVisible(false);
        this.JCBProcesoAsistentes.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProceso1ItemStateChanged(ItemEvent evt) {
        if (this.xLleno2.booleanValue() && this.JCHFiltrar.isSelected()) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProceso1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xLleno2.booleanValue()) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xLleno2.booleanValue()) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroObjetivosKeyPressed(KeyEvent evt) {
        if (this.xLleno2.booleanValue()) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltrarActionPerformed(ActionEvent evt) {
        if (this.JCHFiltrar.isSelected()) {
            this.JCBProceso1.setEnabled(true);
        } else {
            this.JCBProceso1.setEnabled(false);
            this.JCBProceso1.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFHoraFinalActaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JFTFHoraFinalActa.transferFocus();
        }
    }
}
