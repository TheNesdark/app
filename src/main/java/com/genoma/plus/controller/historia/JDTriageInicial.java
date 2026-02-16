package com.genoma.plus.controller.historia;

import Historia.JPITriageP;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JDTriageInicial.class */
public class JDTriageInicial extends JDialog {
    private JPITriageP xjptriage;
    private JPBuscarPatologia patologia;
    public boolean triageLleno;
    private JIF_Historia_Clinica_v4 v4;
    private JButton JBTCerrar;
    private JButton JBTGrabarTriage;

    public JDTriageInicial(Frame parent, JPanel JPTriage) {
        super(parent, true);
        this.v4 = new JIF_Historia_Clinica_v4();
        initComponents();
        this.triageLleno = false;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjptriage = new JPITriageP();
        JPanel panelPrincipal = getContentPane();
        panelPrincipal.add(this.xjptriage);
        this.xjptriage.setBounds(0, 0, panelPrincipal.getWidth(), panelPrincipal.getHeight());
        nuevo();
    }

    private void initComponents() {
        this.JBTCerrar = new JButton();
        this.JBTGrabarTriage = new JButton();
        setDefaultCloseOperation(2);
        setTitle("MODULO HISTORIA CLÍNICA");
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("SALIR");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JDTriageInicial.1
            public void actionPerformed(ActionEvent evt) {
                JDTriageInicial.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JBTGrabarTriage.setFont(new Font("Arial", 1, 12));
        this.JBTGrabarTriage.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabarTriage.setText("GRABAR TRIAGE");
        this.JBTGrabarTriage.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JDTriageInicial.2
            public void actionPerformed(ActionEvent evt) {
                JDTriageInicial.this.JBTGrabarTriageActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBTGrabarTriage, -2, 429, -2).addGap(18, 18, 18).addComponent(this.JBTCerrar, -1, 496, 32767).addGap(22, 22, 22)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(654, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCerrar, -2, 61, -2).addComponent(this.JBTGrabarTriage, -2, 61, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        this.triageLleno = false;
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarTriageActionPerformed(ActionEvent evt) {
        this.xjptriage.mGrabar();
        nuevo();
    }

    private void nuevo() {
        this.JBTGrabarTriage.setEnabled(true);
        this.v4.JCH_PorClasificar.setSelected(true);
    }
}
