package Historia;

import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGraficasPyP_Res2465.class */
public class JPGraficasPyP_Res2465 extends JPanel {
    private int tipo;
    public JLabel JLTitulo;
    public JPanel JPGenericoCyD;
    public JPanel JPGraficaImage1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private Metodos xmt = new Metodos();
    private boolean render = false;

    public JPGraficasPyP_Res2465() {
        initComponents();
    }

    public boolean isRender() {
        return this.render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    private void initComponents() {
        this.JPGenericoCyD = new JPanel();
        this.JPGraficaImage1 = new JPanel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel1 = new JLabel();
        this.JLTitulo = new JLabel();
        setBackground(new Color(255, 255, 255));
        setName("GraficasCyDGenerico");
        this.JPGenericoCyD.setBackground(new Color(255, 255, 255));
        this.JPGenericoCyD.setPreferredSize(new Dimension(896, 570));
        this.JPGraficaImage1.setBackground(new Color(255, 255, 255));
        this.JPGraficaImage1.setBorder(BorderFactory.createEtchedBorder());
        this.JPGraficaImage1.setName("panelGraficaRender");
        this.JPGraficaImage1.setPreferredSize(new Dimension(896, 570));
        GroupLayout JPGraficaImage1Layout = new GroupLayout(this.JPGraficaImage1);
        this.JPGraficaImage1.setLayout(JPGraficaImage1Layout);
        JPGraficaImage1Layout.setHorizontalGroup(JPGraficaImage1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPGraficaImage1Layout.setVerticalGroup(JPGraficaImage1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 566, 32767));
        this.jLabel3.setBackground(new Color(255, 255, 255));
        this.jLabel3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logoOMS.PNG")));
        this.jLabel3.setOpaque(true);
        this.jLabel4.setBackground(new Color(255, 255, 255));
        this.jLabel4.setText("Patrones de crecimiento infantil de la OMS");
        this.jLabel4.setOpaque(true);
        this.jLabel2.setBackground(new Color(255, 255, 255));
        this.jLabel2.setText("publicada en el diario oficial numero 49926 el 06/07/2016.");
        this.jLabel2.setOpaque(true);
        this.jLabel1.setBackground(new Color(255, 255, 255));
        this.jLabel1.setText("Resolución MINSALUD 2465 del 14 de Junio de 2016");
        this.jLabel1.setOpaque(true);
        this.JLTitulo.setBackground(new Color(255, 255, 255));
        this.JLTitulo.setFont(new Font("Arial", 1, 12));
        this.JLTitulo.setHorizontalAlignment(0);
        this.JLTitulo.setText("TÍTULO");
        this.JLTitulo.setName("labelTitulo");
        this.JLTitulo.setOpaque(true);
        GroupLayout JPGenericoCyDLayout = new GroupLayout(this.JPGenericoCyD);
        this.JPGenericoCyD.setLayout(JPGenericoCyDLayout);
        JPGenericoCyDLayout.setHorizontalGroup(JPGenericoCyDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGenericoCyDLayout.createSequentialGroup().addGroup(JPGenericoCyDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGenericoCyDLayout.createSequentialGroup().addGroup(JPGenericoCyDLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLTitulo, GroupLayout.Alignment.LEADING, -1, 896, 32767).addComponent(this.JPGraficaImage1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(0, 0, 32767)).addGroup(JPGenericoCyDLayout.createSequentialGroup().addGroup(JPGenericoCyDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, -2, 387, -2).addComponent(this.jLabel1, -2, 387, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel4, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3))).addContainerGap(-1, 32767)));
        JPGenericoCyDLayout.setVerticalGroup(JPGenericoCyDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGenericoCyDLayout.createSequentialGroup().addComponent(this.JLTitulo, -2, 24, -2).addGap(0, 0, 0).addComponent(this.JPGraficaImage1, -2, -1, -2).addGap(2, 2, 2).addGroup(JPGenericoCyDLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGenericoCyDLayout.createSequentialGroup().addComponent(this.jLabel1).addGap(2, 2, 2).addComponent(this.jLabel2)).addGroup(JPGenericoCyDLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.jLabel4)).addComponent(this.jLabel3)).addContainerGap(20, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPGenericoCyD, -2, -1, -2).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.JPGenericoCyD, -2, 652, -2).addGap(0, 0, 0)));
    }
}
