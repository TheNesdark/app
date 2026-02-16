package com.genoma.plus.controller.utilidades;

import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/utilidades/JDRegistroTrazabilidad.class */
public class JDRegistroTrazabilidad extends JDialog {
    private Long idIngreso;
    private Metodos metodos;
    private JButton JBGuardar;
    private JButton JBT_Salir;
    private JCheckBox JCH_Alerta;
    private JPanel JPIDatos1;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTextPane JTAHistorico;
    private JTextArea JTAObservacion;
    private JTextField JTFAsunto;
    private JTabbedPane JTP_Datos;

    public JDRegistroTrazabilidad(Frame parent, boolean modal, Long idIngreso, String titulo) {
        super(parent, modal);
        initComponents();
        this.JTFAsunto.setText(titulo);
        this.idIngreso = idIngreso;
        this.metodos = new Metodos();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.metodos.getBuscarTrazabilidad(idIngreso, this.JTAHistorico, this.JBGuardar);
    }

    private void initComponents() {
        this.JBGuardar = new JButton();
        this.JBT_Salir = new JButton();
        this.JTP_Datos = new JTabbedPane();
        this.JPIDatos1 = new JPanel();
        this.JTFAsunto = new JTextField();
        this.JCH_Alerta = new JCheckBox();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPHistorico = new JScrollPane();
        this.JTAHistorico = new JTextPane();
        setDefaultCloseOperation(2);
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.utilidades.JDRegistroTrazabilidad.1
            public void actionPerformed(ActionEvent evt) {
                JDRegistroTrazabilidad.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.utilidades.JDRegistroTrazabilidad.2
            public void actionPerformed(ActionEvent evt) {
                JDRegistroTrazabilidad.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JTFAsunto.setFont(new Font("Arial", 1, 12));
        this.JTFAsunto.setBorder(BorderFactory.createTitledBorder((Border) null, "Asunto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Alerta.setFont(new Font("Arial", 1, 12));
        this.JCH_Alerta.setForeground(Color.red);
        this.JCH_Alerta.setSelected(true);
        this.JCH_Alerta.setText("Genera Alerta!!");
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPIDatos1Layout = new GroupLayout(this.JPIDatos1);
        this.JPIDatos1.setLayout(JPIDatos1Layout);
        JPIDatos1Layout.setHorizontalGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatos1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatos1Layout.createSequentialGroup().addComponent(this.JSPObservacion).addContainerGap()).addGroup(JPIDatos1Layout.createSequentialGroup().addComponent(this.JTFAsunto, -2, 269, -2).addGap(175, 175, 175).addComponent(this.JCH_Alerta).addGap(108, 108, 108)))));
        JPIDatos1Layout.setVerticalGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatos1Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPIDatos1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFAsunto, -2, 50, -2).addComponent(this.JCH_Alerta)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacion, -1, 237, 32767).addContainerGap()));
        this.JTP_Datos.addTab("REGISTRO", this.JPIDatos1);
        this.JSPHistorico.setBorder((Border) null);
        this.JTAHistorico.setFont(new Font("Arial", 1, 12));
        this.JSPHistorico.setViewportView(this.JTAHistorico);
        this.JTP_Datos.addTab("HISTÓRICO", this.JSPHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JBGuardar, -2, 240, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 240, -2)).addComponent(this.JTP_Datos, -2, 669, -2)).addContainerGap(14, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JTP_Datos, -2, 352, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGuardar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        if (!this.JTFAsunto.getText().isEmpty()) {
            if (!this.JTAObservacion.getText().isEmpty()) {
                int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.metodos.getInterceptor(this.idIngreso, this.JTFAsunto.getText(), this.JTAObservacion.getText(), Boolean.valueOf(this.JCH_Alerta.isSelected()));
                    dispose();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El asunto no puede ser vacio", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFAsunto.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La observación no puede ser nula", " VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTAObservacion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }
}
