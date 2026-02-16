package PyP;

import General.Persona;
import Historia.JP_PyP_Diabetes;
import Historia.JP_PyP_HTA;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:PyP/JIFUsuarioxPrograma.class */
public class JIFUsuarioxPrograma extends JInternalFrame {
    private String xnombre;
    private Persona frmPersona;
    public JP_PyP_HTA xJP_PyP_HTA;
    public JP_PyP_Diabetes xJP_PyP_Diabetes;
    private JPanel JPPersona;
    private JPanel JPVentanas;

    public JIFUsuarioxPrograma(String xnombre, String xtitulo) {
        initComponents();
        setName(xnombre);
        setTitle(xtitulo.toUpperCase());
        this.xnombre = xnombre;
        cargarPanelPersona();
        cargarPanelVentana();
    }

    private void cargarPanelPersona() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setBounds(15, 10, 980, 160);
        this.JPPersona.add(this.frmPersona);
        this.JPPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    private void cargarPanelVentana() {
        System.out.println("pantalla " + this.xnombre);
        if (this.xnombre.equals("xjifingresohta")) {
            this.xJP_PyP_HTA = new JP_PyP_HTA("xjifHTA_PyP", 1L);
            this.xJP_PyP_HTA.setBounds(15, 10, 879, 457);
            this.JPVentanas.add(this.xJP_PyP_HTA);
            this.JPVentanas.setVisible(true);
            this.xJP_PyP_HTA.setVisible(true);
            return;
        }
        this.xJP_PyP_Diabetes = new JP_PyP_Diabetes("xjifDiabetes_pyp", 1L);
        this.xJP_PyP_Diabetes.setBounds(5, 5, 872, 520);
        this.JPVentanas.add(this.xJP_PyP_Diabetes);
        this.JPVentanas.setVisible(true);
        this.xJP_PyP_Diabetes.setVisible(true);
    }

    public void mNuevo() {
        this.frmPersona.nuevo();
        if (this.xnombre.equals("xjifingresohta")) {
            this.xJP_PyP_HTA.mNuevo();
        } else {
            this.xJP_PyP_Diabetes.mNuevo();
        }
    }

    public void mGrabar() {
        if (!this.xnombre.equals("xjifingresohta")) {
            this.xJP_PyP_Diabetes.mGrabarBd();
        }
    }

    private void initComponents() {
        this.JPPersona = new JPanel();
        this.JPVentanas = new JPanel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiUsuarioxProgramapyp");
        GroupLayout JPPersonaLayout = new GroupLayout(this.JPPersona);
        this.JPPersona.setLayout(JPPersonaLayout);
        JPPersonaLayout.setHorizontalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1006, 32767));
        JPPersonaLayout.setVerticalGroup(JPPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 180, 32767));
        this.JPVentanas.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPVentanasLayout = new GroupLayout(this.JPVentanas);
        this.JPVentanas.setLayout(JPVentanasLayout);
        JPVentanasLayout.setHorizontalGroup(JPVentanasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1006, 32767));
        JPVentanasLayout.setVerticalGroup(JPVentanasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 560, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPPersona, -2, -1, -2).addComponent(this.JPVentanas, -2, -1, -2)).addContainerGap(11, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPVentanas, -1, -1, 32767).addContainerGap()));
        this.JPPersona.getAccessibleContext().setAccessibleName("");
        pack();
    }
}
