package com.genoma.plus.controller.laboratorio;

import Laboratorio.JIFPlanillaTrabajo;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JDPatologias.class */
public class JDPatologias extends JDialog {
    private JIFPlanillaTrabajo xjifplanilla;
    private ConsultasMySQL xconsulta;
    private String[] xidTipoPatologia;
    private String[] xidTipoResultado;
    private Boolean xlleno;
    private String xidProcedimeinto;
    private JComboBox<String> JCBTipoPatologiasL;
    private JButton jButton1;
    private JPanel jPanel1;

    public JDPatologias(Frame parent, boolean modal, String idProcedimeinto, JIFPlanillaTrabajo xjifplanilla) {
        super(parent, modal);
        this.xconsulta = new ConsultasMySQL();
        this.xlleno = false;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xidProcedimeinto = idProcedimeinto;
        System.err.println("idProcedimeinto" + idProcedimeinto);
        mCargarCombo(this.xidProcedimeinto);
        this.xjifplanilla = xjifplanilla;
        setLocationRelativeTo(null);
    }

    private void mCargarCombo(String idProcedimeinto) {
        this.xlleno = false;
        this.JCBTipoPatologiasL.removeAllItems();
        this.xidTipoPatologia = this.xconsulta.llenarCombo("SELECT `id`, `nombre` FROM   `l_patologialaboratorios`WHERE `idProcedmiento`='" + idProcedimeinto + "'and  estado=1 ORDER BY `nombre` ASC;", this.xidTipoPatologia, this.JCBTipoPatologiasL);
        this.JCBTipoPatologiasL.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBTipoPatologiasL.setSelectedIndex(-1);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBTipoPatologiasL = new JComboBox<>();
        this.jButton1 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("PATOLOGIAS");
        this.JCBTipoPatologiasL.setFont(new Font("Arial", 1, 12));
        this.JCBTipoPatologiasL.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Patologias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoPatologiasL.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.laboratorio.JDPatologias.1
            public void itemStateChanged(ItemEvent evt) {
                JDPatologias.this.JCBTipoPatologiasLItemStateChanged(evt);
            }
        });
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDPatologias.2
            public void actionPerformed(ActionEvent evt) {
                JDPatologias.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoPatologiasL, -2, 349, -2).addGap(18, 18, 18).addComponent(this.jButton1, -2, 79, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoPatologiasL).addComponent(this.jButton1, -1, -1, 32767)).addContainerGap(15, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 8, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoPatologiasLItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        dispose();
        this.xjifplanilla.mAsignarResultaodReferencia(this.xidTipoPatologia[this.JCBTipoPatologiasL.getSelectedIndex()]);
    }
}
