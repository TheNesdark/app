package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import General.Anular;
import Utilidades.Metodos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.jpa.entities.FacturaEquivalenteDTO;
import com.genoma.plus.jpa.entities.FacturacionElectronicaDTO;
import com.genoma.plus.jpa.projection.IResolucionFacturaElectronica;
import com.genoma.plus.jpa.service.IFacturaEquivalenteService;
import com.genoma.plus.jpa.service.IResolucionDianDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JDFacturaEquivalente.class */
public class JDFacturaEquivalente extends JDialog {
    private Metodos metodos;
    private final IResolucionDianDAO resolucionDian;
    private final IFacturaEquivalenteService facturaEquivalenteService;
    private FacturaEquivalenteDTO facturaEquivalenteDTO;
    private List<IResolucionFacturaElectronica> resoluciones;
    private String idFacturaInterna;
    private JButton JBTCerrar;
    private JButton JBTGenerar;
    private JButton JBTImprimir;
    private JButton JBTImprimir1;
    private JComboBox<String> JCBResolucionDian;
    private JLabel JLBNFactInterna;
    private JLabel JLBNInterno;
    private JPanel JPIFacturaInterna;
    private JSpinner JSPCantidad;
    public JTextArea JTAConcepto;
    private JFormattedTextField JTFFPRetFuente;
    private JFormattedTextField JTFFVTotal;
    private JFormattedTextField JTFFVUnitario;
    private JScrollPane jScrollPane1;

    public JDFacturaEquivalente(Frame parent, boolean modal, FacturaEquivalenteDTO facturaEquivalenteDTO) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.resolucionDian = (IResolucionDianDAO) Principal.contexto.getBean(IResolucionDianDAO.class);
        this.facturaEquivalenteService = (IFacturaEquivalenteService) Principal.contexto.getBean(IFacturaEquivalenteService.class);
        this.facturaEquivalenteDTO = new FacturaEquivalenteDTO();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.facturaEquivalenteDTO = facturaEquivalenteDTO;
        nuevo();
    }

    private void initComponents() {
        this.JPIFacturaInterna = new JPanel();
        this.JSPCantidad = new JSpinner();
        this.JTFFVUnitario = new JFormattedTextField();
        this.JTFFVTotal = new JFormattedTextField();
        this.JCBResolucionDian = new JComboBox<>();
        this.JTFFPRetFuente = new JFormattedTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAConcepto = new JTextArea();
        this.JLBNFactInterna = new JLabel();
        this.JBTGenerar = new JButton();
        this.JLBNInterno = new JLabel();
        this.JBTCerrar = new JButton();
        this.JBTImprimir = new JButton();
        this.JBTImprimir1 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("GENERACIÓN FACTURA EQUIVALENTE / DOCUMENTO SOPORTE");
        this.JPIFacturaInterna.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE FACTURA", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPCantidad.setFont(new Font("Arial", 1, 13));
        this.JSPCantidad.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPCantidad.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente.1
            public void stateChanged(ChangeEvent evt) {
                JDFacturaEquivalente.this.JSPCantidadStateChanged(evt);
            }
        });
        this.JTFFVUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVUnitario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVUnitario.setHorizontalAlignment(4);
        this.JTFFVUnitario.setText("0");
        this.JTFFVUnitario.setFont(new Font("Arial", 1, 13));
        this.JTFFVUnitario.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente.2
            public void focusLost(FocusEvent evt) {
                JDFacturaEquivalente.this.JTFFVUnitarioFocusLost(evt);
            }
        });
        this.JTFFVUnitario.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente.3
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente.this.JTFFVUnitarioActionPerformed(evt);
            }
        });
        this.JTFFVTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVTotal.setHorizontalAlignment(4);
        this.JTFFVTotal.setText("0");
        this.JTFFVTotal.setFont(new Font("Arial", 1, 13));
        this.JCBResolucionDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Resolucion DIan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPRetFuente.setBorder(BorderFactory.createTitledBorder((Border) null, "% ReteFuente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPRetFuente.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.0"))));
        this.JTFFPRetFuente.setHorizontalAlignment(4);
        this.JTFFPRetFuente.setFont(new Font("Arial", 1, 13));
        this.JTAConcepto.setColumns(1);
        this.JTAConcepto.setFont(new Font("Arial", 1, 12));
        this.JTAConcepto.setLineWrap(true);
        this.JTAConcepto.setRows(1);
        this.JTAConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAConcepto);
        this.JLBNFactInterna.setFont(new Font("Arial", 1, 18));
        this.JLBNFactInterna.setHorizontalAlignment(0);
        this.JLBNFactInterna.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout JPIFacturaInternaLayout = new GroupLayout(this.JPIFacturaInterna);
        this.JPIFacturaInterna.setLayout(JPIFacturaInternaLayout);
        JPIFacturaInternaLayout.setHorizontalGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addComponent(this.JCBResolucionDian, -2, 661, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNFactInterna, -2, 124, -2)).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 537, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPRetFuente, -2, 112, -2).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addComponent(this.JSPCantidad, -2, 68, -2).addGap(17, 17, 17).addComponent(this.JTFFVUnitario, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVTotal, -2, 114, -2))).addGap(0, 0, 32767))).addContainerGap(-1, 32767)));
        JPIFacturaInternaLayout.setVerticalGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFVTotal, GroupLayout.Alignment.LEADING).addComponent(this.JTFFVUnitario, GroupLayout.Alignment.LEADING).addComponent(this.JSPCantidad, GroupLayout.Alignment.LEADING, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFPRetFuente, -1, 50, 32767).addGap(11, 11, 11)).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 117, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBResolucionDian, -2, 55, -2).addComponent(this.JLBNFactInterna, -1, -1, 32767)).addContainerGap()));
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGenerar.setText("Grabar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente.4
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JLBNInterno.setFont(new Font("Arial", 1, 18));
        this.JLBNInterno.setHorizontalAlignment(0);
        this.JLBNInterno.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Interno", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente.5
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JBTImprimir.setFont(new Font("Arial", 1, 12));
        this.JBTImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTImprimir.setText("Imprimir");
        this.JBTImprimir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente.6
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente.this.JBTImprimirActionPerformed(evt);
            }
        });
        this.JBTImprimir1.setFont(new Font("Arial", 1, 12));
        this.JBTImprimir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBTImprimir1.setText("Anular");
        this.JBTImprimir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente.7
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente.this.JBTImprimir1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFacturaInterna, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBTGenerar, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTImprimir1, -2, 170, -2).addGap(12, 12, 12).addComponent(this.JBTImprimir, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTCerrar, -2, 170, -2).addGap(51, 51, 51).addComponent(this.JLBNInterno, -2, 124, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JPIFacturaInterna, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBNInterno, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBTGenerar, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JBTCerrar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBTImprimir, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JBTImprimir1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPCantidadStateChanged(ChangeEvent evt) {
        totalizarFactura();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVUnitarioFocusLost(FocusEvent evt) {
        totalizarFactura();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVUnitarioActionPerformed(ActionEvent evt) {
        this.JTFFVUnitario.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.JLBNInterno.getText().isEmpty()) {
            if (this.JTAConcepto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Concepto no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTAConcepto.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFVUnitario.getValue().toString()).doubleValue() != 0.0d) {
                if (Double.valueOf(this.JTFFVUnitario.getValue().toString()).equals(this.facturaEquivalenteDTO.getValorUnitario())) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.facturaEquivalenteDTO.setCantidad(Integer.valueOf(this.JSPCantidad.getValue().toString()));
                        this.facturaEquivalenteDTO.setConcepto(this.JTAConcepto.getText().toUpperCase());
                        this.facturaEquivalenteDTO.setEstado(true);
                        this.facturaEquivalenteDTO.setFecha(this.metodos.getFechaActual());
                        this.facturaEquivalenteDTO.setIdResolucion(this.resoluciones.get(this.JCBResolucionDian.getSelectedIndex()).getId());
                        this.facturaEquivalenteDTO.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                        this.facturaEquivalenteDTO.setReteFuente(Double.valueOf(this.JTFFPRetFuente.getValue().toString()));
                        this.facturaEquivalenteDTO.setUsuarioSistema(Principal.usuarioSistemaDTO.getLogin());
                        this.facturaEquivalenteDTO.setValorUnitario(Double.valueOf(this.JTFFVUnitario.getValue().toString()));
                        this.facturaEquivalenteDTO = this.facturaEquivalenteService.grabar(this.facturaEquivalenteDTO);
                        this.JLBNInterno.setText("" + this.facturaEquivalenteDTO.getId());
                        nuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Valor de factura diferente a factura interna;Favor Revisar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFVUnitario.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Falta valor unitario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFVUnitario.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimirActionPerformed(ActionEvent evt) {
        try {
            FacturacionElectronicaDTO factura = this.facturaEquivalenteService.generarDocumentoSoporte(Long.valueOf(this.JLBNInterno.getText()));
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("entra a imprimir objetMapper");
            System.out.println(mapper.writeValueAsString(factura));
        } catch (JsonProcessingException e) {
            Logger.getLogger(JDFacturaEquivalente.class.getName()).log(Level.SEVERE, (String) null, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimir1ActionPerformed(ActionEvent evt) {
        anular();
    }

    private void nuevo() {
        this.JTAConcepto.setText("");
        this.JSPCantidad.setValue(new Integer(1));
        this.JTFFVUnitario.setValue(new Integer(0));
        this.JTFFPRetFuente.setValue(new Double(0.0d));
        this.JTFFVTotal.setValue(new Integer(0));
        this.JLBNInterno.setText("");
        this.JLBNFactInterna.setText("");
        llenarComboResoluciones();
        buscarDatosIdEmpresaNumeroFactura();
    }

    private void anular() {
        if (!this.JLBNInterno.getText().isEmpty()) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular((Frame) null, true, "Factura Interna Nueva", 6, (JDialog) this);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    public void anularDocumento(String id, String movitoAnulacion) {
        this.facturaEquivalenteDTO.setIdAnulado(Integer.valueOf(id));
        this.facturaEquivalenteDTO.setMotivoAnulacion(movitoAnulacion);
        this.facturaEquivalenteDTO.setUsuarioAnulacion(Principal.usuarioSistemaDTO.getNombreUsuario());
        this.facturaEquivalenteDTO.setFechaAnulacion(this.metodos.getFechaActual());
        this.facturaEquivalenteDTO.setEstado(false);
        this.facturaEquivalenteService.grabar(this.facturaEquivalenteDTO);
        nuevo();
    }

    private void llenarComboResoluciones() {
        this.resoluciones = this.resolucionDian.consultarResolucionPorSede(Principal.sedeUsuarioSeleccionadaDTO.getId(), 5);
        for (int j = 0; j < this.resoluciones.size(); j++) {
            this.JCBResolucionDian.addItem(this.resoluciones.get(j).getId() + " " + this.resoluciones.get(j).getDescripcion());
        }
    }

    private void totalizarFactura() {
        this.JTFFVTotal.setValue(Double.valueOf(Double.valueOf(this.JTFFVUnitario.getValue().toString()).doubleValue() * Double.valueOf(this.JSPCantidad.getValue().toString()).doubleValue()));
    }

    private void buscarDatosIdEmpresaNumeroFactura() {
        System.out.println("" + this.facturaEquivalenteDTO.getIdEmpresa());
        System.out.println("" + this.facturaEquivalenteDTO.getNumeroFactura());
        FacturaEquivalenteDTO e = this.facturaEquivalenteService.buscarPorIdEmpresaAndNumeroFacturaAndEstado(this.facturaEquivalenteDTO.getIdEmpresa(), this.facturaEquivalenteDTO.getNumeroFactura(), true);
        if (e == null) {
            this.JTAConcepto.setText(this.facturaEquivalenteDTO.getConcepto());
            this.JSPCantidad.setValue(this.facturaEquivalenteDTO.getCantidad());
            this.JTFFVUnitario.setValue(this.facturaEquivalenteDTO.getValorUnitario());
            this.JTFFVTotal.setValue(Double.valueOf(((double) this.facturaEquivalenteDTO.getCantidad().intValue()) * this.facturaEquivalenteDTO.getValorUnitario().doubleValue()));
            return;
        }
        this.facturaEquivalenteDTO = e;
        this.JTAConcepto.setText(this.facturaEquivalenteDTO.getConcepto());
        this.JSPCantidad.setValue(this.facturaEquivalenteDTO.getCantidad());
        this.JTFFVUnitario.setValue(this.facturaEquivalenteDTO.getValorUnitario());
        this.JTFFPRetFuente.setValue(this.facturaEquivalenteDTO.getReteFuente());
        this.JTFFVTotal.setValue(Double.valueOf(((double) this.facturaEquivalenteDTO.getCantidad().intValue()) * this.facturaEquivalenteDTO.getValorUnitario().doubleValue()));
        this.JLBNInterno.setText("" + this.facturaEquivalenteDTO.getId());
        this.JLBNFactInterna.setText("" + this.facturaEquivalenteDTO.getNumeroConsecutivo());
    }
}
