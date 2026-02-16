package com.genoma.plus.controller.facturacion;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JDSoporte_Escaneado.class */
public class JDSoporte_Escaneado extends JDialog {
    private JPIngresoDocumento documento;
    private JPanel JPI_Datos;
    private JButton btnSalir;

    public JDSoporte_Escaneado(Frame parent, boolean modal, Long idIngreso) {
        super(parent, modal);
        initComponents();
        cargarPanel(idIngreso);
    }

    private void initComponents() {
        this.JPI_Datos = new JPanel();
        this.btnSalir = new JButton();
        setDefaultCloseOperation(2);
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 341, 32767));
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JDSoporte_Escaneado.1
            public void actionPerformed(ActionEvent evt) {
                JDSoporte_Escaneado.this.btnSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.btnSalir, -1, 954, 32767).addComponent(this.JPI_Datos, -1, -1, 32767)).addGap(15, 15, 15)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JPI_Datos, -2, -1, -2).addGap(22, 22, 22).addComponent(this.btnSalir, -2, 50, -2).addContainerGap(16, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void cargarPanel(Long idIngreso) {
        this.documento = new JPIngresoDocumento(idIngreso);
        this.documento.setVisible(true);
        this.JPI_Datos.setVisible(false);
        this.documento.setBounds(1, 1, 850, 342);
        this.JPI_Datos.add(this.documento);
        this.JPI_Datos.setVisible(true);
    }
}
