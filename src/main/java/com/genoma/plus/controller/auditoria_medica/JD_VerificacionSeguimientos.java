package com.genoma.plus.controller.auditoria_medica;

import com.genoma.plus.controller.facturacion.JPIngresoSeguimientos;
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
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/auditoria_medica/JD_VerificacionSeguimientos.class */
public class JD_VerificacionSeguimientos extends JDialog {
    public JPIngresoSeguimientos xJPIngresoSeguimientos;
    private long xIdIngreso;
    private JButton JBT_Salir;
    private JPanel JPI_Seguimiento;

    public JD_VerificacionSeguimientos(Frame parent, boolean modal, Long xIdIngreso) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xIdIngreso = xIdIngreso.longValue();
        mNuevo();
    }

    private void initComponents() {
        this.JPI_Seguimiento = new JPanel();
        this.JBT_Salir = new JButton();
        setDefaultCloseOperation(2);
        GroupLayout JPI_SeguimientoLayout = new GroupLayout(this.JPI_Seguimiento);
        this.JPI_Seguimiento.setLayout(JPI_SeguimientoLayout);
        JPI_SeguimientoLayout.setHorizontalGroup(JPI_SeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPI_SeguimientoLayout.setVerticalGroup(JPI_SeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 572, 32767));
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.auditoria_medica.JD_VerificacionSeguimientos.1
            public void actionPerformed(ActionEvent evt) {
                JD_VerificacionSeguimientos.this.JBT_SalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Salir, -1, 857, 32767).addComponent(this.JPI_Seguimiento, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Seguimiento, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Salir, -2, 49, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void mNuevo() {
        this.xJPIngresoSeguimientos = new JPIngresoSeguimientos(Long.valueOf(this.xIdIngreso), 0);
        this.xJPIngresoSeguimientos.setBounds(5, 10, 850, 560);
        this.JPI_Seguimiento.add(this.xJPIngresoSeguimientos);
        this.JPI_Seguimiento.setVisible(true);
    }
}
