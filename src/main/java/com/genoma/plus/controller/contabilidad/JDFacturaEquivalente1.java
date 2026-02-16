package com.genoma.plus.controller.contabilidad;

import Acceso.Principal;
import General.Anular;
import General.ClaseImpresionInformes;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.FacturaEquivalenteDTO;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.springframework.web.client.RestTemplate;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/contabilidad/JDFacturaEquivalente1.class */
public class JDFacturaEquivalente1 extends JDialog {
    private Metodos metodos;
    private final IResolucionDianDAO resolucionDian;
    private final IFacturaEquivalenteService facturaEquivalenteService;
    private FacturaEquivalenteDTO facturaEquivalenteDTO;
    private List<IResolucionFacturaElectronica> resoluciones;
    private String idFacturaInterna;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private JButton JBTCerrar;
    private JButton JBTGenerar;
    private JButton JBTImprimir;
    private JButton JBTImprimir1;
    private JComboBox<String> JCBResolucionDian;
    private JLabel JLBNFactInterna;
    private JLabel JLBNInterno;
    private JPanel JPIFacturaInterna;
    private JSpinner JSPCantidad;
    private JScrollPane JSPImpuestos;
    public JTextArea JTAConcepto;
    private JFormattedTextField JTFFVTotal;
    private JFormattedTextField JTFFVUnitario;
    public JTable JTImpuestos;
    private JButton jButton1;
    private JScrollPane jScrollPane1;

    public JDFacturaEquivalente1(Frame parent, boolean modal, FacturaEquivalenteDTO facturaEquivalenteDTO) {
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

    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIFacturaInterna = new JPanel();
        this.JSPCantidad = new JSpinner();
        this.JTFFVUnitario = new JFormattedTextField();
        this.JTFFVTotal = new JFormattedTextField();
        this.JCBResolucionDian = new JComboBox<>();
        this.jScrollPane1 = new JScrollPane();
        this.JTAConcepto = new JTextArea();
        this.JLBNFactInterna = new JLabel();
        this.JSPImpuestos = new JScrollPane();
        this.JTImpuestos = new JTable();
        this.jButton1 = new JButton();
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
        this.JSPCantidad.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.1
            public void stateChanged(ChangeEvent evt) {
                JDFacturaEquivalente1.this.JSPCantidadStateChanged(evt);
            }
        });
        this.JTFFVUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVUnitario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVUnitario.setHorizontalAlignment(4);
        this.JTFFVUnitario.setText("0");
        this.JTFFVUnitario.setFont(new Font("Arial", 1, 13));
        this.JTFFVUnitario.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.2
            public void focusLost(FocusEvent evt) {
                JDFacturaEquivalente1.this.JTFFVUnitarioFocusLost(evt);
            }
        });
        this.JTFFVUnitario.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.3
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente1.this.JTFFVUnitarioActionPerformed(evt);
            }
        });
        this.JTFFVTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVTotal.setHorizontalAlignment(4);
        this.JTFFVTotal.setText("0");
        this.JTFFVTotal.setFont(new Font("Arial", 1, 13));
        this.JCBResolucionDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Resolucion DIan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAConcepto.setColumns(1);
        this.JTAConcepto.setFont(new Font("Arial", 1, 12));
        this.JTAConcepto.setLineWrap(true);
        this.JTAConcepto.setRows(1);
        this.JTAConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAConcepto);
        this.JLBNFactInterna.setFont(new Font("Arial", 1, 18));
        this.JLBNFactInterna.setHorizontalAlignment(0);
        this.JLBNFactInterna.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPImpuestos.setBorder(BorderFactory.createTitledBorder((Border) null, "D impuestos", 1, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTImpuestos.setBorder(BorderFactory.createBevelBorder(0));
        this.JTImpuestos.setFont(new Font("Arial", 1, 12));
        this.JTImpuestos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTImpuestos.setEditingColumn(1);
        this.JTImpuestos.setEditingRow(1);
        this.JTImpuestos.setRowHeight(25);
        this.JTImpuestos.setSelectionBackground(new Color(255, 255, 255));
        this.JTImpuestos.setSelectionForeground(Color.red);
        this.JTImpuestos.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.4
            public void mouseClicked(MouseEvent evt) {
                JDFacturaEquivalente1.this.JTImpuestosMouseClicked(evt);
            }
        });
        this.JSPImpuestos.setViewportView(this.JTImpuestos);
        this.jButton1.setText("jButton1");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.5
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente1.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout JPIFacturaInternaLayout = new GroupLayout(this.JPIFacturaInterna);
        this.JPIFacturaInterna.setLayout(JPIFacturaInternaLayout);
        JPIFacturaInternaLayout.setHorizontalGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFacturaInternaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPImpuestos).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 360, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCantidad, -2, 68, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVUnitario, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addComponent(this.JCBResolucionDian, -2, 548, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFVTotal, -1, 114, 32767).addComponent(this.JLBNFactInterna, -1, -1, 32767)))).addGap(9, 9, 9)).addGroup(GroupLayout.Alignment.TRAILING, JPIFacturaInternaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jButton1).addGap(73, 73, 73)));
        JPIFacturaInternaLayout.setVerticalGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFacturaInternaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPCantidad).addComponent(this.JTFFVUnitario).addComponent(this.JTFFVTotal, -2, -1, -2).addComponent(this.jScrollPane1, -1, 41, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPImpuestos, -2, 77, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIFacturaInternaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBResolucionDian).addComponent(this.JLBNFactInterna, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.jButton1).addContainerGap()));
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGenerar.setText("Grabar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.6
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente1.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JLBNInterno.setFont(new Font("Arial", 1, 18));
        this.JLBNInterno.setHorizontalAlignment(0);
        this.JLBNInterno.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Interno", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBTCerrar.setFont(new Font("Arial", 1, 14));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.7
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente1.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JBTImprimir.setFont(new Font("Arial", 1, 14));
        this.JBTImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBTImprimir.setText("Imprimir");
        this.JBTImprimir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.8
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente1.this.JBTImprimirActionPerformed(evt);
            }
        });
        this.JBTImprimir1.setFont(new Font("Arial", 1, 14));
        this.JBTImprimir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.JBTImprimir1.setText("Anular");
        this.JBTImprimir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.9
            public void actionPerformed(ActionEvent evt) {
                JDFacturaEquivalente1.this.JBTImprimir1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFacturaInterna, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBTGenerar, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTImprimir1, -2, 124, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTImprimir).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar, -2, 170, -2).addGap(18, 18, 18).addComponent(this.JLBNInterno, -2, 131, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JPIFacturaInterna, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTImprimir1, -2, 37, -2).addComponent(this.JLBNInterno, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTImprimir, -1, -1, 32767).addComponent(this.JBTCerrar, -1, -1, 32767))).addComponent(this.JBTGenerar, GroupLayout.Alignment.LEADING, -2, 37, -2)).addContainerGap(-1, 32767)));
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimirActionPerformed(ActionEvent evt) {
        if (!this.JLBNFactInterna.getText().isEmpty()) {
            ClaseImpresionInformes informes = new ClaseImpresionInformes();
            informes.imprimirFacturaInternas(this.JLBNInterno.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTImprimir1ActionPerformed(ActionEvent evt) {
        anular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTImpuestosMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        mCargasTiposDeImpuestos();
    }

    private void mCreadModelImpuestos() {
        this.xmodelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.contabilidad.JDFacturaEquivalente1.10
            Class[] types = {Integer.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xmodelo.addColumn("idTipoImpuesto");
        this.xmodelo.addColumn("nombreImpuesto");
        this.xmodelo.addColumn("PValor");
        JTable jTable = this.JTImpuestos;
        JTable jTable2 = this.JTImpuestos;
        jTable.setAutoResizeMode(0);
        this.JTImpuestos.doLayout();
        this.JTImpuestos.setModel(this.xmodelo);
        this.JTImpuestos.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTImpuestos.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTImpuestos.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void mCargasTiposDeImpuestos() {
        new RestTemplate();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    private void nuevo() {
        this.JTAConcepto.setText("");
        this.JSPCantidad.setValue(new Integer(1));
        this.JTFFVUnitario.setValue(new Integer(0));
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
        this.facturaEquivalenteDTO.setFechaAnulacion(new Date());
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
        if (e != null) {
            this.facturaEquivalenteDTO = e;
            this.JLBNInterno.setText("" + this.facturaEquivalenteDTO.getId());
            this.JLBNFactInterna.setText("" + this.facturaEquivalenteDTO.getNumeroConsecutivo());
        }
    }
}
