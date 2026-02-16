package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import com.genoma.plus.jpa.entities.LProtocoloxprocedimiento;
import com.genoma.plus.jpa.projection.GenericoProjection;
import com.genoma.plus.jpa.service.LAreaService;
import com.genoma.plus.jpa.service.LProtocoloPorProcedimientoService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JDFormulaPorAnalito.class */
public class JDFormulaPorAnalito extends JDialog {
    private final LAreaService areaService;
    private final LProtocoloPorProcedimientoService protocoloPorProcedimientoService;
    private List<GenericoProjection> listAreas;
    private List<GenericoProjection> listProcedimientos;
    private List<LProtocoloxprocedimiento> listProtocolo;
    private LProtocoloxprocedimiento protocoloxprocedimiento;
    Stack<String> history;
    private JButton JBAdicionar;
    private JButton JBGrabar;
    private JButton JBLimpiar;
    private JButton JBSalir;
    private JComboBox<String> JCBArea;
    private JComboBox<String> JCBProcedimientos;
    private JComboBox<String> JCBProtocolos;
    private JFormattedTextField JFTFConstante;
    private JLabel JLEstructura;
    private JLabel JLTemp;
    private JRadioButton JRBEsAnalito;
    private JRadioButton JRBEsConstante;
    private ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JPanel jPanel3;

    public JDFormulaPorAnalito(Frame parent, boolean modal, Long idProtocoloxProcedimiento) {
        super(parent, modal);
        this.areaService = (LAreaService) Principal.contexto.getBean(LAreaService.class);
        this.protocoloPorProcedimientoService = (LProtocoloPorProcedimientoService) Principal.contexto.getBean(LProtocoloPorProcedimientoService.class);
        this.protocoloxprocedimiento = new LProtocoloxprocedimiento();
        this.history = new Stack<>();
        initComponents();
        setTitle("FORMULA POR ANALITO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.protocoloxprocedimiento = this.protocoloPorProcedimientoService.findById(idProtocoloxProcedimiento);
        if (this.protocoloxprocedimiento.getFormula() == null) {
            adicionarFormula("");
        } else {
            adicionarFormula(this.protocoloxprocedimiento.getFormula());
        }
        this.JLTemp.setText(this.protocoloxprocedimiento.getLProtocolos().getAbreviatura() + " =");
        nuevo();
    }

    private void nuevo() {
        this.JRBEsAnalito.setSelected(true);
        JRBEsAnalitoActionPerformed(null);
        this.listAreas = this.areaService.listAreasPorProcedimientosActivos();
        this.JCBArea.removeAllItems();
        this.listAreas.forEach(next -> {
            this.JCBArea.addItem(next.getNbre());
        });
        this.JCBArea.setSelectedIndex(-1);
    }

    private void grabar() {
        if (validarFormula(this.JLEstructura.getText())) {
            this.protocoloxprocedimiento.setFormula(this.JLEstructura.getText());
            this.protocoloPorProcedimientoService.save(this.protocoloxprocedimiento);
        }
    }

    public boolean validarFormula(String formula) {
        if (!m73parntesisBalanceados(formula)) {
            JOptionPane.showMessageDialog(this, "Paréntesis desbalanceados en la fórmula.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return false;
        }
        if (!formula.matches("[\\[\\]A-Z0-9+\\-*/().\\s]+")) {
            JOptionPane.showMessageDialog(this, "La fórmula contiene caracteres no permitidos.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return false;
        }
        if (!estructuraValida(formula)) {
            JOptionPane.showMessageDialog(this, "La fórmula tiene una estructura inválida.", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: paréntesisBalanceados, reason: contains not printable characters */
    private boolean m73parntesisBalanceados(String formula) {
        int contador = 0;
        for (char c : formula.toCharArray()) {
            if (c == '(') {
                contador++;
            } else if (c == ')') {
                contador--;
            }
            if (contador < 0) {
                return false;
            }
        }
        return contador == 0;
    }

    private boolean estructuraValida(String formula) {
        String sinVariables = formula.replaceAll("\\[.*?]", "1.0");
        return sinVariables.matches("^(\\s*[-+]?\\(?\\d+(\\.\\d+)?\\)?)([-+*/]\\(?\\d+(\\.\\d+)?\\)?)*$");
    }

    private void adicionarFormula(String texto) {
        this.JLEstructura.setText(this.JLEstructura.getText() + texto);
        this.history.push(this.JLEstructura.getText());
        for (int i = 0; i < this.history.size(); i++) {
            System.out.println(this.history.get(i));
        }
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel3 = new JPanel();
        this.JCBArea = new JComboBox<>();
        this.JCBProtocolos = new JComboBox<>();
        this.JBAdicionar = new JButton();
        this.JCBProcedimientos = new JComboBox<>();
        this.JFTFConstante = new JFormattedTextField();
        this.JRBEsAnalito = new JRadioButton();
        this.JRBEsConstante = new JRadioButton();
        this.JBLimpiar = new JButton();
        this.JBGrabar = new JButton();
        this.JBSalir = new JButton();
        this.jButton2 = new JButton();
        this.jButton1 = new JButton();
        this.jButton4 = new JButton();
        this.jButton3 = new JButton();
        this.jButton6 = new JButton();
        this.jButton5 = new JButton();
        this.JLEstructura = new JLabel();
        this.JLTemp = new JLabel();
        this.jButton7 = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCBArea.setFont(new Font("Arial", 1, 12));
        this.JCBArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Area", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArea.setName("");
        this.JCBArea.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.1
            public void itemStateChanged(ItemEvent evt) {
                JDFormulaPorAnalito.this.JCBAreaItemStateChanged(evt);
            }
        });
        this.JCBProtocolos.setFont(new Font("Arial", 1, 12));
        this.JCBProtocolos.setBorder(BorderFactory.createTitledBorder((Border) null, "Protocolos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gestion documental.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.2
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.JCBProcedimientos.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimientos.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimientos.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.3
            public void itemStateChanged(ItemEvent evt) {
                JDFormulaPorAnalito.this.JCBProcedimientosItemStateChanged(evt);
            }
        });
        this.JFTFConstante.setBorder(BorderFactory.createTitledBorder((Border) null, "Constante", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFConstante.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.buttonGroup1.add(this.JRBEsAnalito);
        this.JRBEsAnalito.setFont(new Font("Arial", 1, 12));
        this.JRBEsAnalito.setSelected(true);
        this.JRBEsAnalito.setText("Es Analito");
        this.JRBEsAnalito.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.4
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.JRBEsAnalitoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBEsConstante);
        this.JRBEsConstante.setFont(new Font("Arial", 1, 12));
        this.JRBEsConstante.setText("Es Constante");
        this.JRBEsConstante.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.5
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.JRBEsConstanteActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProtocolos, 0, -1, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JCBArea, -2, 172, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcedimientos, 0, -1, 32767)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JRBEsAnalito).addGap(0, 0, 32767)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JRBEsConstante).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFConstante, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBAdicionar, -2, 395, -2))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JRBEsAnalito).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArea, -1, -1, -2).addComponent(this.JCBProcedimientos, -1, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProtocolos, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBEsConstante).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFConstante, -2, 50, -2).addComponent(this.JBAdicionar, -2, 50, -2))).addContainerGap(-1, 32767)));
        this.JBLimpiar.setFont(new Font("Arial", 1, 12));
        this.JBLimpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBLimpiar.setText("Nuevo");
        this.JBLimpiar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.6
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.JBLimpiarActionPerformed(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Guardar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.7
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.8
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.JBSalirActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setText("(");
        this.jButton2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.9
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.jButton2ActionPerformed(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setText(")");
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.10
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton4.setFont(new Font("Arial", 1, 12));
        this.jButton4.setText("+");
        this.jButton4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.11
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.jButton4ActionPerformed(evt);
            }
        });
        this.jButton3.setFont(new Font("Arial", 1, 12));
        this.jButton3.setText("-");
        this.jButton3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.12
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.jButton3ActionPerformed(evt);
            }
        });
        this.jButton6.setFont(new Font("Arial", 1, 12));
        this.jButton6.setText("/");
        this.jButton6.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.13
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.jButton6ActionPerformed(evt);
            }
        });
        this.jButton5.setFont(new Font("Arial", 1, 12));
        this.jButton5.setText("x");
        this.jButton5.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.14
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.jButton5ActionPerformed(evt);
            }
        });
        this.JLEstructura.setFont(new Font("Arial", 1, 12));
        this.JLEstructura.setForeground(new Color(0, 103, 0));
        this.JLEstructura.setBorder(BorderFactory.createTitledBorder((Border) null, "Validador de Formato", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLTemp.setFont(new Font("Arial", 1, 12));
        this.JLTemp.setForeground(Color.red);
        this.JLTemp.setHorizontalAlignment(4);
        this.JLTemp.setText("jLabel1");
        this.jButton7.setFont(new Font("Arial", 1, 12));
        this.jButton7.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.jButton7.setToolTipText("Deshacer Ultimo Cmabio");
        this.jButton7.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDFormulaPorAnalito.15
            public void actionPerformed(ActionEvent evt) {
                JDFormulaPorAnalito.this.jButton7ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JBLimpiar, -2, 206, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabar, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -2, 196, -2).addGap(18, 18, 18).addComponent(this.jButton7, -2, 50, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JLTemp, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLEstructura, -2, 586, -2))).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jButton2, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.jButton4, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.jButton3, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.jButton6, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.jButton5, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLEstructura, -2, 42, -2).addComponent(this.JLTemp, -2, 36, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBLimpiar, -2, 50, -2).addComponent(this.JBGrabar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2))).addGroup(layout.createSequentialGroup().addComponent(this.jButton2, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton4, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton3, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton6, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton5, -2, 50, -2).addComponent(this.jButton7, -2, 50, -2)))).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAreaItemStateChanged(ItemEvent evt) {
        if (!this.listAreas.isEmpty() && this.JCBArea.getSelectedIndex() != -1) {
            this.listProcedimientos = this.areaService.ListProcedimientosUnificadosPorAreaYActivos(this.listAreas.get(this.JCBArea.getSelectedIndex()).getId());
            this.JCBProcedimientos.removeAllItems();
            this.listProcedimientos.forEach(next -> {
                this.JCBProcedimientos.addItem(next.getNbre());
            });
            this.JCBProcedimientos.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBLimpiarActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientosItemStateChanged(ItemEvent evt) {
        if (!this.listProcedimientos.isEmpty() && this.JCBProcedimientos.getSelectedIndex() != -1) {
            this.listProtocolo = this.protocoloPorProcedimientoService.ListProtocolosPorProcedimientos(Long.valueOf(this.listProcedimientos.get(this.JCBProcedimientos.getSelectedIndex()).getId().longValue()));
            this.JCBProtocolos.removeAllItems();
            this.listProtocolo.forEach(next -> {
                this.JCBProtocolos.addItem(next.getLProtocolos().getNbre());
            });
            this.JCBProtocolos.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        if (this.JRBEsAnalito.isSelected()) {
            if (this.JCBProtocolos.getSelectedIndex() != -1) {
                adicionarFormula("[" + this.listProtocolo.get(this.JCBProtocolos.getSelectedIndex()).getLProtocolos().getAbreviatura() + "]");
                return;
            }
            return;
        }
        adicionarFormula(this.JFTFConstante.getValue().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        adicionarFormula(this.jButton2.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        adicionarFormula(this.jButton1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton4ActionPerformed(ActionEvent evt) {
        adicionarFormula(this.jButton4.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        adicionarFormula(this.jButton3.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton6ActionPerformed(ActionEvent evt) {
        adicionarFormula(this.jButton6.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton5ActionPerformed(ActionEvent evt) {
        adicionarFormula("*");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEsAnalitoActionPerformed(ActionEvent evt) {
        this.JFTFConstante.setText("");
        this.JFTFConstante.setEnabled(false);
        this.JCBArea.setEnabled(true);
        this.JCBArea.setSelectedIndex(-1);
        this.JCBProcedimientos.setEnabled(true);
        this.JCBProcedimientos.setSelectedIndex(-1);
        this.JCBProtocolos.setEnabled(true);
        this.JCBProtocolos.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEsConstanteActionPerformed(ActionEvent evt) {
        this.JCBArea.setEnabled(false);
        this.JCBArea.setSelectedIndex(-1);
        this.JCBProcedimientos.setEnabled(false);
        this.JCBProcedimientos.setSelectedIndex(-1);
        this.JCBProtocolos.setEnabled(false);
        this.JCBProtocolos.setSelectedIndex(-1);
        this.JFTFConstante.setText("");
        this.JFTFConstante.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton7ActionPerformed(ActionEvent evt) {
        if (!this.history.isEmpty()) {
            this.history.pop();
            if (!this.history.isEmpty()) {
                this.JLEstructura.setText(this.history.peek());
            }
        }
    }
}
