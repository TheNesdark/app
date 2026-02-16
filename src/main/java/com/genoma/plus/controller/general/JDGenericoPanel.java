package com.genoma.plus.controller.general;

import com.genoma.plus.controller.sgc.JPEventoAdverso;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JDGenericoPanel.class */
public class JDGenericoPanel extends JDialog {
    public String jpllamar;
    public String xidIngreso;
    public int xmodulo;
    public JPEventoAdverso xJPEventoAdverso;
    private JButton JBT_Grabar;
    private JButton JBT_Grabar1;
    private JButton JBT_NUevo;
    private JButton JBT_Salir1;
    private JPanel JPArea;

    public JDGenericoPanel(Frame parent, boolean modal, String xllamar, String xidIngreso, int xmodulo) {
        super(parent, modal);
        this.jpllamar = xllamar;
        this.xidIngreso = xidIngreso;
        this.xmodulo = xmodulo;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarPanel();
        mNuevo();
    }

    public JDGenericoPanel(Frame parent, boolean modal, String xllamar) {
        super(parent, modal);
        this.jpllamar = xllamar;
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarPanel();
        mNuevo();
    }

    public void mCargarPanel() {
        if (this.jpllamar.equals("Evento Adverso")) {
            this.xJPEventoAdverso = new JPEventoAdverso(true, this.xidIngreso, this.xmodulo);
            mMostrarPanel(this.xJPEventoAdverso, "Evento Adverso");
        }
    }

    public void mMostrarPanel(JPanel formulario, String xTitulo) {
        formulario.setBounds(0, 0, 740, 430);
        this.JPArea.add(formulario);
        this.JPArea.setVisible(true);
        setTitle(xTitulo.toUpperCase());
    }

    public void mNuevo() {
        if (this.jpllamar.equals("Evento Adverso")) {
            this.xJPEventoAdverso.mNuevo();
        }
    }

    public void mGrabar() {
        if (this.jpllamar.equals("Evento Adverso")) {
            this.xJPEventoAdverso.mGrabar();
        }
    }

    public void mAnular() {
        if (this.jpllamar.equals("Evento Adverso")) {
            this.xJPEventoAdverso.mAnular();
        }
    }

    public void mImprimir() {
        if (this.jpllamar.equals("Evento Adverso")) {
            this.xJPEventoAdverso.mImprimir();
        }
    }

    private void initComponents() {
        this.JBT_NUevo = new JButton();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir1 = new JButton();
        this.JBT_Grabar1 = new JButton();
        this.JPArea = new JPanel();
        setDefaultCloseOperation(2);
        this.JBT_NUevo.setFont(new Font("Arial", 1, 12));
        this.JBT_NUevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_NUevo.setText("Nuevo");
        this.JBT_NUevo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDGenericoPanel.1
            public void actionPerformed(ActionEvent evt) {
                JDGenericoPanel.this.JBT_NUevoActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDGenericoPanel.2
            public void actionPerformed(ActionEvent evt) {
                JDGenericoPanel.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir1.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir1.setText("Salir");
        this.JBT_Salir1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDGenericoPanel.3
            public void actionPerformed(ActionEvent evt) {
                JDGenericoPanel.this.JBT_Salir1ActionPerformed(evt);
            }
        });
        this.JBT_Grabar1.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBT_Grabar1.setText("Imprimir");
        this.JBT_Grabar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JDGenericoPanel.4
            public void actionPerformed(ActionEvent evt) {
                JDGenericoPanel.this.JBT_Grabar1ActionPerformed(evt);
            }
        });
        GroupLayout JPAreaLayout = new GroupLayout(this.JPArea);
        this.JPArea.setLayout(JPAreaLayout);
        JPAreaLayout.setHorizontalGroup(JPAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPAreaLayout.setVerticalGroup(JPAreaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 426, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPArea, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBT_NUevo, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar, -1, 200, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Grabar1, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Salir1, -2, 180, -2))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPArea, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_NUevo, -2, 50, -2).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Grabar1, -2, 50, -2).addComponent(this.JBT_Salir1, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NUevoActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Salir1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Grabar1ActionPerformed(ActionEvent evt) {
        mImprimir();
    }
}
