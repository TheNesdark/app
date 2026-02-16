package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcOrdenCompra;
import com.genoma.plus.jpa.entities.CcOrdenCompraRegistroFactura;
import com.genoma.plus.jpa.service.ICcordenCompraRegistroFacturaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDRegistroFactura.class */
public class JDRegistroFactura extends JDialog {
    private CcOrdenCompraRegistroFactura modelo;
    private final Metodos metodos;
    private double subtotal;
    private double impuesto;
    private double flete;
    private double descuento;
    private double total;
    private ICcordenCompraRegistroFacturaService facturaService;
    private CcOrdenCompra ccOrdenCompra;
    private DefaultTableModel modelo_table;
    private List<CcOrdenCompraRegistroFactura> detallesHistorico;
    private final ICcordenCompraRegistroFacturaService registroFacturaService;
    private Object[] dato;
    private JButton JBTAdicionar;
    private JButton JBTNuevo;
    private JButton JBTSalir;
    private JDateChooser JDFFecha;
    private JFormattedTextField JFTDescuento;
    private JFormattedTextField JFTFlete;
    private JFormattedTextField JFTImpuesto;
    private JFormattedTextField JFTSubTotal;
    private JFormattedTextField JFTTotal;
    private JLabel JLBId;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPResultadoHi;
    private JTextPane JTAObservacion;
    private JTextField JTFNFactura;
    private JFormattedTextField JTFSaldo;
    private JTabbedPane JTPDatosFactura;
    public JTable JTResultadoHi;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;

    public JDRegistroFactura(Frame parent, boolean modal, Long idOrdenCompra, Double saldo) {
        super(parent, modal);
        this.modelo = new CcOrdenCompraRegistroFactura();
        this.metodos = new Metodos();
        this.facturaService = (ICcordenCompraRegistroFacturaService) Principal.contexto.getBean(ICcordenCompraRegistroFacturaService.class);
        this.registroFacturaService = (ICcordenCompraRegistroFacturaService) Principal.contexto.getBean(ICcordenCompraRegistroFacturaService.class);
        initComponents();
        this.JDFFecha.setDate(this.metodos.getFechaActual());
        this.ccOrdenCompra = new CcOrdenCompra();
        this.ccOrdenCompra.setId(idOrdenCompra);
        llenarDatosTablaHistorico();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.JTFSaldo.setValue(saldo);
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v84, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatosFactura = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JDFFecha = new JDateChooser();
        this.JTFNFactura = new JTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JLBId = new JLabel();
        this.jPanel3 = new JPanel();
        this.JFTSubTotal = new JFormattedTextField();
        this.JFTImpuesto = new JFormattedTextField();
        this.JFTFlete = new JFormattedTextField();
        this.JFTDescuento = new JFormattedTextField();
        this.JFTTotal = new JFormattedTextField();
        this.JTFSaldo = new JFormattedTextField();
        this.jPanel1 = new JPanel();
        this.JSPResultadoHi = new JScrollPane();
        this.JTResultadoHi = new JTable();
        this.JBTAdicionar = new JButton();
        this.JBTSalir = new JButton();
        this.JBTNuevo = new JButton();
        setDefaultCloseOperation(2);
        setTitle("REGISTRO DE FACTURA");
        this.JTPDatosFactura.setForeground(new Color(0, 103, 0));
        this.JTPDatosFactura.setFont(new Font("Arial", 1, 14));
        this.jPanel2.setForeground(new Color(0, 103, 0));
        this.jPanel2.setFont(new Font("Arial", 1, 14));
        this.JDFFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFFecha.setFont(new Font("Arial", 1, 12));
        this.JTFNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N°Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JLBId.setFont(new Font("Arial", 1, 12));
        this.JLBId.setHorizontalAlignment(0);
        this.JLBId.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Registro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTSubTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Subtotal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTSubTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JFTSubTotal.setHorizontalAlignment(4);
        this.JFTSubTotal.setToolTipText("");
        this.JFTSubTotal.setFont(new Font("Arial", 1, 14));
        this.JFTSubTotal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.1
            public void actionPerformed(ActionEvent evt) {
                JDRegistroFactura.this.JFTSubTotalActionPerformed(evt);
            }
        });
        this.JFTSubTotal.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDRegistroFactura.this.JFTSubTotalPropertyChange(evt);
            }
        });
        this.JFTSubTotal.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.3
            public void keyPressed(KeyEvent evt) {
                JDRegistroFactura.this.JFTSubTotalKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JDRegistroFactura.this.JFTSubTotalKeyReleased(evt);
            }
        });
        this.JFTImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTImpuesto.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JFTImpuesto.setHorizontalAlignment(4);
        this.JFTImpuesto.setFont(new Font("Arial", 1, 14));
        this.JFTImpuesto.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDRegistroFactura.this.JFTImpuestoPropertyChange(evt);
            }
        });
        this.JFTImpuesto.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.5
            public void keyPressed(KeyEvent evt) {
                JDRegistroFactura.this.JFTImpuestoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JDRegistroFactura.this.JFTImpuestoKeyReleased(evt);
            }
        });
        this.JFTFlete.setBorder(BorderFactory.createTitledBorder((Border) null, "Flete", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFlete.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JFTFlete.setHorizontalAlignment(4);
        this.JFTFlete.setFont(new Font("Arial", 1, 14));
        this.JFTFlete.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDRegistroFactura.this.JFTFletePropertyChange(evt);
            }
        });
        this.JFTFlete.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.7
            public void keyPressed(KeyEvent evt) {
                JDRegistroFactura.this.JFTFleteKeyPressed(evt);
            }
        });
        this.JFTDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descuento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JFTDescuento.setHorizontalAlignment(4);
        this.JFTDescuento.setFont(new Font("Arial", 1, 14));
        this.JFTDescuento.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDRegistroFactura.this.JFTDescuentoPropertyChange(evt);
            }
        });
        this.JFTDescuento.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.9
            public void keyPressed(KeyEvent evt) {
                JDRegistroFactura.this.JFTDescuentoKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JDRegistroFactura.this.JFTDescuentoKeyReleased(evt);
            }
        });
        this.JFTTotal.setEditable(false);
        this.JFTTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JFTTotal.setHorizontalAlignment(0);
        this.JFTTotal.setFont(new Font("Arial", 1, 14));
        this.JFTTotal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.10
            public void actionPerformed(ActionEvent evt) {
                JDRegistroFactura.this.JFTTotalActionPerformed(evt);
            }
        });
        this.JFTTotal.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.11
            public void keyPressed(KeyEvent evt) {
                JDRegistroFactura.this.JFTTotalKeyPressed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTTotal, -2, 248, -2).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTSubTotal, -2, 115, -2).addComponent(this.JFTFlete, -2, 115, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JFTImpuesto, -2, 115, -2).addComponent(this.JFTDescuento, -2, 115, -2)))).addContainerGap(19, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTSubTotal, -1, -1, -2).addComponent(this.JFTImpuesto, -2, -1, -2)).addGap(28, 28, 28).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFlete, -2, -1, -2).addComponent(this.JFTDescuento, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JFTTotal, -2, -1, -2).addContainerGap(21, 32767)));
        this.JTFSaldo.setEditable(false);
        this.JTFSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFSaldo.setHorizontalAlignment(0);
        this.JTFSaldo.setFont(new Font("Arial", 1, 14));
        this.JTFSaldo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.12
            public void actionPerformed(ActionEvent evt) {
                JDRegistroFactura.this.JTFSaldoActionPerformed(evt);
            }
        });
        this.JTFSaldo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.13
            public void keyPressed(KeyEvent evt) {
                JDRegistroFactura.this.JTFSaldoKeyPressed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JDFFecha, -2, 135, -2).addGap(18, 18, 18).addComponent(this.JTFNFactura, -2, 129, -2)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacion, -2, 294, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFSaldo, -2, 294, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.JLBId, -2, 125, -2).addGap(19, 19, 19)))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(13, 13, 13).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFFecha, -2, 50, -2).addComponent(this.JTFNFactura, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 146, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jPanel3, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBId, -2, 38, -2).addComponent(this.JTFSaldo, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JTFNFactura.getAccessibleContext().setAccessibleDescription("");
        this.JTPDatosFactura.addTab("DATO FACTURA", this.jPanel2);
        this.JSPResultadoHi.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultadoHi.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultadoHi.setFont(new Font("Arial", 1, 12));
        this.JTResultadoHi.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultadoHi.setEditingColumn(1);
        this.JTResultadoHi.setEditingRow(1);
        this.JTResultadoHi.setGridColor(new Color(204, 204, 204));
        this.JTResultadoHi.setRowHeight(25);
        this.JTResultadoHi.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultadoHi.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultadoHi.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.14
            public void mouseClicked(MouseEvent evt) {
                JDRegistroFactura.this.JTResultadoHiMouseClicked(evt);
            }
        });
        this.JSPResultadoHi.setViewportView(this.JTResultadoHi);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 577, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultadoHi).addContainerGap())));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 265, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultadoHi, -2, 248, -2).addContainerGap(11, 32767))));
        this.JTPDatosFactura.addTab("HISTÓRICO", this.jPanel1);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.15
            public void actionPerformed(ActionEvent evt) {
                JDRegistroFactura.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Cerrar");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.16
            public void actionPerformed(ActionEvent evt) {
                JDRegistroFactura.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JBTNuevo.setFont(new Font("Arial", 1, 12));
        this.JBTNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBTNuevo.setText("Nuevo");
        this.JBTNuevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDRegistroFactura.17
            public void actionPerformed(ActionEvent evt) {
                JDRegistroFactura.this.JBTNuevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JBTAdicionar, -2, 150, -2).addGap(59, 59, 59).addComponent(this.JBTNuevo, -2, 150, -2).addGap(75, 75, 75).addComponent(this.JBTSalir, -2, 150, -2).addGap(8, 8, 8)).addComponent(this.JTPDatosFactura, GroupLayout.Alignment.TRAILING, -2, 598, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTPDatosFactura, -2, 311, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTSalir, -2, 41, -2).addComponent(this.JBTAdicionar, -2, 41, -2).addComponent(this.JBTNuevo, -2, 41, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTSubTotalKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            calcularTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTImpuestoKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            calcularTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFleteKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            calcularTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTDescuentoKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 18) {
            calcularTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoHiMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            int seleccionar = this.JTResultadoHi.rowAtPoint(evt.getPoint());
            this.JLBId.setText(String.valueOf(this.JTResultadoHi.getValueAt(seleccionar, 0)));
            this.JTFNFactura.setText(String.valueOf(this.JTResultadoHi.getValueAt(seleccionar, 2)));
            this.JFTSubTotal.setText(String.valueOf(this.JTResultadoHi.getValueAt(seleccionar, 3)));
            this.JFTFlete.setText(String.valueOf(this.JTResultadoHi.getValueAt(seleccionar, 4)));
            this.JFTImpuesto.setText(String.valueOf(this.JTResultadoHi.getValueAt(seleccionar, 5)));
            this.JFTDescuento.setText(String.valueOf(this.JTResultadoHi.getValueAt(seleccionar, 6)));
            this.JTAObservacion.setText(String.valueOf(this.JTResultadoHi.getValueAt(seleccionar, 7)));
            calcularTotal();
            this.JTPDatosFactura.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTNuevoActionPerformed(ActionEvent evt) {
        this.modelo = new CcOrdenCompraRegistroFactura();
        limpiar(this.jPanel2);
        limpiar(this.jPanel3);
        this.JTAObservacion.setText("");
        calcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTSubTotalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTTotalKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTTotalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSaldoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFSaldoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTSubTotalPropertyChange(PropertyChangeEvent evt) {
        calcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTSubTotalKeyReleased(KeyEvent evt) {
        calcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTImpuestoKeyReleased(KeyEvent evt) {
        calcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFletePropertyChange(PropertyChangeEvent evt) {
        calcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTDescuentoKeyReleased(KeyEvent evt) {
        calcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTImpuestoPropertyChange(PropertyChangeEvent evt) {
        calcularTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTDescuentoPropertyChange(PropertyChangeEvent evt) {
        calcularTotal();
    }

    private void limpiar(JPanel panel) {
        for (Object j : panel.getComponents()) {
            if (j instanceof JFormattedTextField) {
                ((JFormattedTextField) j).setText("0");
            }
            if (j instanceof JLabel) {
                ((JLabel) j).setText("");
            }
            if (j instanceof JTextField) {
                ((JTextField) j).setText("0");
            }
        }
        this.JDFFecha.setDate(this.metodos.getFechaActual());
    }

    private void calcularTotal() {
        try {
            if (!this.JFTImpuesto.getText().isEmpty() && !this.JFTDescuento.getText().isEmpty() && !this.JFTFlete.getText().isEmpty() && !this.JFTSubTotal.getText().isEmpty() && (Double.valueOf(this.JFTSubTotal.getValue().toString()).doubleValue() >= 0.0d || Double.valueOf(this.JFTImpuesto.getValue().toString()).doubleValue() >= 0.0d || Double.valueOf(this.JFTDescuento.getValue().toString()).doubleValue() >= 0.0d || Double.valueOf(this.JFTFlete.getValue().toString()).doubleValue() >= 0.0d)) {
                this.subtotal = Double.valueOf(this.JFTSubTotal.getValue().toString()).doubleValue();
                this.impuesto = Double.valueOf(this.JFTImpuesto.getValue().toString()).doubleValue();
                this.flete = Double.valueOf(this.JFTFlete.getValue().toString()).doubleValue();
                this.descuento = Double.valueOf(this.JFTDescuento.getValue().toString()).doubleValue();
                this.total = ((this.subtotal + this.impuesto) + this.flete) - this.descuento;
                this.JFTTotal.setValue(Double.valueOf(this.total));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Caracteres no validos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloOrdenCompra() {
        this.modelo_table = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "numero Factura", "subtotal", "flete", "impuesto", "descuento", "observacion", "estado", "Motivo Anulacion", "fechaAnulacion", "usuarioAnulacion", "fechaRegistro", "idUsuarioRh"}) { // from class: com.genoma.plus.controller.general.JDRegistroFactura.18
            Class[] types = {Long.class, Date.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, Boolean.class, String.class, Date.class, String.class, Date.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTResultadoHi;
        JTable jTable2 = this.JTResultadoHi;
        jTable.setAutoResizeMode(0);
        this.JTResultadoHi.doLayout();
        this.JTResultadoHi.setModel(this.modelo_table);
        this.JTResultadoHi.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTResultadoHi.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTResultadoHi.getColumnModel().getColumn(11).setPreferredWidth(200);
        this.JTResultadoHi.getColumnModel().getColumn(12).setPreferredWidth(100);
    }

    private void llenarDatosTablaHistorico() {
        crearModeloOrdenCompra();
        this.detallesHistorico = this.registroFacturaService.ListaOrdenProduccionFactura(true, this.ccOrdenCompra);
        this.detallesHistorico.forEach(e -> {
            this.modelo_table.addRow(this.dato);
            this.modelo_table.setValueAt(e.getId(), this.JTResultadoHi.getRowCount() - 1, 0);
            this.modelo_table.setValueAt(e.getFecha(), this.JTResultadoHi.getRowCount() - 1, 1);
            this.modelo_table.setValueAt(e.getNumeroFactura(), this.JTResultadoHi.getRowCount() - 1, 2);
            this.modelo_table.setValueAt(e.getSubtotal(), this.JTResultadoHi.getRowCount() - 1, 3);
            this.modelo_table.setValueAt(e.getFlete(), this.JTResultadoHi.getRowCount() - 1, 4);
            this.modelo_table.setValueAt(e.getImpuesto(), this.JTResultadoHi.getRowCount() - 1, 5);
            this.modelo_table.setValueAt(e.getDescuento(), this.JTResultadoHi.getRowCount() - 1, 6);
            this.modelo_table.setValueAt(e.getObservacion(), this.JTResultadoHi.getRowCount() - 1, 7);
            this.modelo_table.setValueAt(e.getEstado(), this.JTResultadoHi.getRowCount() - 1, 8);
            this.modelo_table.setValueAt(e.getMotivoAnulacion(), this.JTResultadoHi.getRowCount() - 1, 9);
            this.modelo_table.setValueAt(e.getFechaAnulacion(), this.JTResultadoHi.getRowCount() - 1, 10);
            this.modelo_table.setValueAt(e.getUsuarioAnulacion(), this.JTResultadoHi.getRowCount() - 1, 11);
            this.modelo_table.setValueAt(e.getFechaRegistro(), this.JTResultadoHi.getRowCount() - 1, 12);
            this.modelo_table.setValueAt(e.getIdUsuarioRh(), this.JTResultadoHi.getRowCount() - 1, 13);
        });
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDRegistroFactura$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8) == null || table.getValueAt(row, 8).toString().equals("")) {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            } else if (table.getValueAt(row, 8) == null || table.getValueAt(row, 8).toString().equals("SUCCESS")) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void grabar() {
        try {
            if (this.JDFFecha.getDate() != null) {
                if (!this.JTFNFactura.getText().isEmpty()) {
                    System.out.println("" + this.JTFSaldo.getValue());
                    if (Double.valueOf(this.JTFSaldo.getValue().toString()).doubleValue() < 0.0d || this.JFTTotal.getText() == null) {
                        JOptionPane.showMessageDialog(this, "Verifique que el total tenga algo y que el valor sea positivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    } else if (Double.valueOf(this.JTFSaldo.getValue().toString()).doubleValue() >= Double.valueOf(this.JFTTotal.getValue().toString()).doubleValue()) {
                        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3);
                        if (n == 0) {
                            this.modelo.setCcOrdenCompra(this.ccOrdenCompra);
                            this.modelo.setFecha(this.JDFFecha.getDate());
                            this.modelo.setNumeroFactura(this.JTFNFactura.getText());
                            this.modelo.setSubtotal(Double.valueOf(this.JFTSubTotal.getValue().toString()));
                            this.modelo.setFlete(Double.valueOf(this.JFTFlete.getValue().toString()));
                            this.modelo.setImpuesto(Double.valueOf(this.JFTImpuesto.getValue().toString()));
                            this.modelo.setDescuento(Double.valueOf(this.JFTDescuento.getValue().toString()));
                            this.modelo.setObservacion(this.JTAObservacion.getText());
                            this.modelo.setEstado(true);
                            this.modelo.setFechaRegistro(this.metodos.getFechaActual());
                            this.modelo.setIdUsuarioRh(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                            this.facturaService.grabar(this.modelo);
                            System.out.println("ha grabado con en la BBDD");
                            this.JLBId.setText(Long.toString(this.modelo.getId().longValue()));
                            llenarDatosTablaHistorico();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Verifique que el total no sea superior al saldo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Falta registro del numero de la factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Falta registro de la fecha", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Caracteres no validos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    private void nuevo() {
        this.JFTDescuento.setValue(0);
        this.JFTSubTotal.setValue(0);
        this.JFTFlete.setValue(0);
        this.JFTImpuesto.setValue(0);
        this.JFTTotal.setValue(0);
    }
}
