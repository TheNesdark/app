package com.genoma.plus.controller.general;

import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDHistoricoTrazabilidad.class */
public class JDHistoricoTrazabilidad extends JDialog {
    Metodos metodos;
    private JScrollPane JSPHistorico;
    private JTextPane JTAHistorico;

    public JDHistoricoTrazabilidad(Frame parent, boolean modal, Long idIngreso) {
        super(parent, modal);
        initComponents();
        this.metodos = new Metodos();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        buscar(idIngreso);
    }

    private void initComponents() {
        this.JSPHistorico = new JScrollPane();
        this.JTAHistorico = new JTextPane();
        setDefaultCloseOperation(2);
        setTitle("HISTÓRICO TRAZABILIDAD");
        setFont(new Font("Arial", 1, 14));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTAHistorico.setFont(new Font("Arial", 1, 12));
        this.JSPHistorico.setViewportView(this.JTAHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 708, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 412, 32767).addContainerGap()));
        pack();
    }

    private void buscar(Long idIngreso) {
        this.metodos.getBuscarTrazabilidad(idIngreso, this.JTAHistorico, null);
    }
}
