package Historia;

import General.BuscarPersona;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFConsultarHistorial.class */
public class JIFConsultarHistorial extends JInternalFrame {
    public String xidusuario;
    public JPGestionHC xgestiodoc;
    private clasesHistoriaCE xclase;
    private int xid;

    public JIFConsultarHistorial(int xid) {
        this.xid = -1;
        initComponents();
        setName("jifconsultarhistorial1");
        this.xid = xid;
        mCargarPanel();
    }

    public JIFConsultarHistorial(int xid, String xnombre) {
        this.xid = -1;
        initComponents();
        setName(xnombre);
        this.xid = xid;
        mCargarPanel();
    }

    private void initComponents() {
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR HISTORICO DE ATENCIONES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconsultarhistorial");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 964, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 791, 32767));
        pack();
    }

    private void mCargarPanel() {
        this.xgestiodoc = new JPGestionHC(this, this.xid);
        this.xgestiodoc.setVisible(true);
        this.xgestiodoc.setBounds(1, 1, 959, 800);
        add(this.xgestiodoc);
        setVisible(true);
    }

    public void nuevo() {
        this.xgestiodoc.nuevo();
    }

    public void buscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xgestiodoc.xjppersona);
        frmBuscar.setVisible(true);
    }

    public void imprimir() {
        this.xgestiodoc.Inprimir();
    }
}
