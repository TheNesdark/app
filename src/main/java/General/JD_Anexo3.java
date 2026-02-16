package General;

import Citas.CitaNP;
import Facturacion.JPEncabezado_Ordenes;
import Facturacion.JPProcedimientos;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:General/JD_Anexo3.class */
public class JD_Anexo3 extends JDialog {
    private JPProcedimientos xJPProcedimientos;
    private CitaNP xCitaNP;
    public JPEncabezado_Ordenes xjpencabezado;
    private JPanel JPnVentana;

    public JD_Anexo3(Frame parent, boolean modal, CitaNP xGenerico) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        System.err.println(xGenerico);
        this.xCitaNP = xGenerico;
        this.xJPProcedimientos = new JPProcedimientos(this.xCitaNP);
        mMostrarPanel1(this.xJPProcedimientos);
    }

    private void initComponents() {
        this.JPnVentana = new JPanel();
        setDefaultCloseOperation(2);
        setTitle("IDENTIFICADOR BIOMETRICO");
        addWindowListener(new WindowAdapter() { // from class: General.JD_Anexo3.1
            public void windowClosing(WindowEvent evt) {
                JD_Anexo3.this.formWindowClosing(evt);
            }

            public void windowOpened(WindowEvent evt) {
                JD_Anexo3.this.formWindowOpened(evt);
            }
        });
        this.JPnVentana.setBorder(BorderFactory.createTitledBorder(""));
        GroupLayout JPnVentanaLayout = new GroupLayout(this.JPnVentana);
        this.JPnVentana.setLayout(JPnVentanaLayout);
        JPnVentanaLayout.setHorizontalGroup(JPnVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 895, 32767));
        JPnVentanaLayout.setVerticalGroup(JPnVentanaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 525, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPnVentana, -2, -1, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPnVentana, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formWindowOpened(WindowEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formWindowClosing(WindowEvent evt) {
    }

    private void mCasting(JInternalFrame xGenerico) {
    }

    public void mMostrarPanelEncabezado(JPanel formulario, JPanel xjpmostar) {
        mLimpiarPanel(xjpmostar);
        formulario.setBounds(5, 5, 780, 225);
        xjpmostar.add(formulario);
        xjpmostar.setVisible(true);
    }

    public void mMostrarPanel1(JPanel formulario) {
        mLimpiarPanel(this.JPnVentana);
        formulario.setBounds(5, 10, 850, 560);
        this.JPnVentana.add(formulario);
        this.JPnVentana.setVisible(true);
    }

    public void mLimpiarPanel(JPanel xjplimpiar) {
        xjplimpiar.setVisible(false);
        xjplimpiar.removeAll();
        xjplimpiar.setVisible(true);
    }
}
