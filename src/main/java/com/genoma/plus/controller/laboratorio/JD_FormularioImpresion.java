package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JD_FormularioImpresion.class */
public class JD_FormularioImpresion extends JDialog {
    private Metodos metodos;
    private JButton JBImprimir;
    private JButton JBSalir;
    private JDateChooser JDFechaFin;
    private JDateChooser JDFechaInicial;
    private JPanel jPanel1;

    public JD_FormularioImpresion(Frame parent, boolean modal, String titulo) {
        super(parent, modal);
        this.metodos = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        nuevo();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaInicial = new JDateChooser();
        this.JDFechaFin = new JDateChooser();
        this.JBImprimir = new JButton();
        this.JBSalir = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaInicial.setDateFormatString("dd/MM/yyyy");
        this.JDFechaInicial.setFont(new Font("Arial", 1, 12));
        this.JDFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDFechaFin.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JDFechaInicial, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 95, 32767).addComponent(this.JDFechaFin, -2, 115, -2).addGap(19, 19, 19)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaInicial, -2, 50, -2).addComponent(this.JDFechaFin, -2, 50, -2)).addContainerGap(16, 32767)));
        this.JBImprimir.setFont(new Font("Arial", 1, 12));
        this.JBImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBImprimir.setText("Imprimir");
        this.JBImprimir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JD_FormularioImpresion.1
            public void actionPerformed(ActionEvent evt) {
                JD_FormularioImpresion.this.JBImprimirActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JD_FormularioImpresion.2
            public void actionPerformed(ActionEvent evt) {
                JD_FormularioImpresion.this.JBSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBImprimir, -2, 170, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBSalir, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBSalir, -1, -1, 32767).addComponent(this.JBImprimir, -2, 50, -2)).addContainerGap(12, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImprimirActionPerformed(ActionEvent evt) {
        imprimir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void nuevo() {
        this.JDFechaInicial.setDate(this.metodos.getFechaActual());
        this.JDFechaFin.setDate(this.metodos.getFechaActual());
    }

    private void imprimir() {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "fechaInicio";
        parametros[0][1] = this.metodos.formatoAMD1.format(this.JDFechaInicial.getDate());
        parametros[1][0] = "fechaFin";
        parametros[1][1] = this.metodos.formatoAMD1.format(this.JDFechaFin.getDate());
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        parametros[4][0] = "usuarioSistema";
        parametros[4][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_Registro_General_Llamadas", parametros);
    }
}
