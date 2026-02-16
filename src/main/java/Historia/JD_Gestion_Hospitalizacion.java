package Historia;

import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JD_Gestion_Hospitalizacion.class */
public class JD_Gestion_Hospitalizacion extends JDialog {
    private JPGestion_Hospitalizacion xjpgestion_h;
    private long xid_atencion;
    private String xcodigo;
    private String xnombre;
    private String xId_Ingreso;
    private int xtipoa;
    private JPanel JPIDatos;

    public JD_Gestion_Hospitalizacion(Frame parent, boolean modal, Long xidatencion, String xccie10, String xncie10, String xid_ingreso) {
        super(parent, modal);
        this.xtipoa = 0;
        initComponents();
        this.xtipoa = 0;
        this.xid_atencion = xidatencion.longValue();
        this.xcodigo = xccie10;
        this.xnombre = xncie10;
        this.xId_Ingreso = xid_ingreso;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarPanel();
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        setDefaultCloseOperation(2);
        setTitle("SOLICITUD DE HOSPITALIZACIÓN");
        setAlwaysOnTop(true);
        setName("xjdhistoria");
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 833, 32767));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 265, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(10, 10, 10)));
        pack();
    }

    private void mCargarPanel() {
        this.xjpgestion_h = new JPGestion_Hospitalizacion(String.valueOf(this.xid_atencion), this.xcodigo, this.xnombre, this.xtipoa, this.xId_Ingreso, getName(), true);
        this.xjpgestion_h.setBounds(5, 5, 833, 543);
        this.JPIDatos.add(this.xjpgestion_h);
        this.JPIDatos.setVisible(true);
    }
}
