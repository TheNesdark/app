package com.genoma.plus.controller.general;

import com.genoma.plus.controller.facturacion.JPI_IngresoSalidaAdministrativa;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDSalidaAdministrativa.class */
public class JDSalidaAdministrativa extends JDialog {
    private JPI_IngresoSalidaAdministrativa salidaAdministrativa;
    private Long idIngreso;
    private JButton JBT_Grabar;
    private JButton JBT_Salir1;

    public JDSalidaAdministrativa(Frame parent, boolean modal, Long idIngreso) {
        super(parent, modal);
        initComponents();
        this.idIngreso = idIngreso;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    private void initComponents() {
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        setDefaultCloseOperation(2);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSalidaAdministrativa.1
            public void actionPerformed(ActionEvent evt) {
                JDSalidaAdministrativa.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDSalidaAdministrativa.2
            public void actionPerformed(ActionEvent evt) {
                JDSalidaAdministrativa.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBT_Grabar, -2, 250, -2).addGap(151, 151, 151).addComponent(this.JBT_Salir1, -1, 269, 32767).addGap(14, 14, 14)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(360, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        this.salidaAdministrativa.grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Salir1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void nuevo() {
        this.salidaAdministrativa = new JPI_IngresoSalidaAdministrativa(this.idIngreso);
        this.salidaAdministrativa.setBounds(1, 1, 685, 319);
        add(this.salidaAdministrativa);
    }
}
