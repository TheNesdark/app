package General;

import Acceso.Principal;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.media.Buffer;
import javax.media.CaptureDeviceInfo;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import javax.media.cdm.CaptureDeviceManager;
import javax.media.control.FrameGrabbingControl;
import javax.media.format.VideoFormat;
import javax.media.util.BufferToImage;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/* JADX INFO: loaded from: GenomaP.jar:General/JDCapturarFotografia.class */
public class JDCapturarFotografia extends JDialog {
    CaptureDeviceInfo di;
    MediaLocator ml;
    Buffer buf;
    Image img;
    VideoFormat vf;
    BufferToImage btoi;
    File nueva_foto;
    File xfile;
    String foto_nombre;
    String fecha;
    JIFCrearPersona xjdcpersona;
    private Metodos xmt;
    private JButton JBTCaptura;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JPanel JPICamara;
    private JPanel JPIFoto;
    private JTextField JTFRuta;
    static Player player = null;
    static ImagePanel imgpanel = null;
    public static String direccion_imagen = "";

    public JDCapturarFotografia(Frame parent, boolean modal, JIFCrearPersona xjdcpersona) {
        super(parent, modal);
        this.di = null;
        this.ml = null;
        this.buf = null;
        this.img = null;
        this.vf = null;
        this.btoi = null;
        this.nueva_foto = null;
        this.foto_nombre = "nueva_imagenm";
        this.fecha = "";
        this.xmt = new Metodos();
        initComponents();
        imgpanel = new ImagePanel();
        this.xjdcpersona = xjdcpersona;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mIniciarComponentes();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.JTFRuta.setText("S:\\GestionDocumental\\Fotografias\\");
        } else {
            this.JTFRuta.setText("Y:\\Fotos Genoma\\");
        }
    }

    private void initComponents() {
        this.JPICamara = new JPanel();
        this.JPIFoto = new JPanel();
        this.JBTCaptura = new JButton();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        this.JTFRuta = new JTextField();
        setDefaultCloseOperation(2);
        this.JPICamara.setBorder(BorderFactory.createTitledBorder((Border) null, "CAMARA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPICamaraLayout = new GroupLayout(this.JPICamara);
        this.JPICamara.setLayout(JPICamaraLayout);
        JPICamaraLayout.setHorizontalGroup(JPICamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 417, 32767));
        JPICamaraLayout.setVerticalGroup(JPICamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 426, 32767));
        this.JPIFoto.setBorder(BorderFactory.createTitledBorder((Border) null, "FOTOGRAFÍA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFotoLayout = new GroupLayout(this.JPIFoto);
        this.JPIFoto.setLayout(JPIFotoLayout);
        JPIFotoLayout.setHorizontalGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 393, 32767));
        JPIFotoLayout.setVerticalGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 426, 32767));
        this.JBTCaptura.setFont(new Font("Arial", 1, 12));
        this.JBTCaptura.setText("Capturar");
        this.JBTCaptura.addActionListener(new ActionListener() { // from class: General.JDCapturarFotografia.1
            public void actionPerformed(ActionEvent evt) {
                JDCapturarFotografia.this.JBTCapturaActionPerformed(evt);
            }
        });
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: General.JDCapturarFotografia.2
            public void actionPerformed(ActionEvent evt) {
                JDCapturarFotografia.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: General.JDCapturarFotografia.3
            public void actionPerformed(ActionEvent evt) {
                JDCapturarFotografia.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("S:\\\\GestionDocumental\\\\Fotografias\\\\");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: General.JDCapturarFotografia.4
            public void mouseClicked(MouseEvent evt) {
                JDCapturarFotografia.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPICamara, -2, -1, -2).addGap(19, 19, 19)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JTFRuta, -1, 436, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFoto, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBTCaptura, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrabar, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTSalir, -2, 131, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIFoto, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPICamara, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCaptura, -1, 53, 32767).addComponent(this.JBTGrabar, -1, 53, 32767).addComponent(this.JBTSalir, -1, 53, 32767)).addContainerGap(44, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, -1, -2).addContainerGap()))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        direccion_imagen = "no";
        dispose();
        playerclose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCapturaActionPerformed(ActionEvent evt) {
        FrameGrabbingControl fgc = player.getControl("javax.media.control.FrameGrabbingControl");
        this.buf = fgc.grabFrame();
        this.btoi = new BufferToImage(this.buf.getFormat());
        this.img = this.btoi.createImage(this.buf);
        imgpanel.setImage(this.img);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        try {
            BufferedImage bi = new BufferedImage(this.img.getWidth((ImageObserver) null), this.img.getHeight((ImageObserver) null), 4);
            Graphics2D g2 = bi.createGraphics();
            g2.drawImage(this.img, (AffineTransform) null, (ImageObserver) null);
            g2.dispose();
            File almacen = new File(this.xmt.getSO() + "/Fotos");
            if (almacen.mkdir()) {
            }
            try {
                this.xmt.mEliminarArchivo(new File(this.JTFRuta.getText() + this.xjdcpersona.frmPersona.getIdPersona() + ".jpg"));
                String dir = this.JTFRuta.getText() + this.xjdcpersona.frmPersona.getIdPersona() + ".jpg";
                direccion_imagen = dir;
                this.nueva_foto = new File(dir);
                this.xjdcpersona.frmPersona.setXurlfoto(this.xmt.mTraerUrlBD(dir));
                try {
                    if (this.nueva_foto.createNewFile()) {
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            } catch (Exception e) {
            }
            try {
                ImageIO.write(bi, "jpg", this.nueva_foto);
            } catch (IOException e2) {
            }
        } catch (Exception e3) {
        }
        playerclose();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    private void mIniciarComponentes() {
        for (int i = 0; i < CaptureDeviceManager.getDeviceList().size(); i++) {
        }
        this.di = CaptureDeviceManager.getDevice("vfw:Microsoft WDM Image Capture (Win32):0");
        this.ml = new MediaLocator("vfw://0");
        try {
            player = Manager.createRealizedPlayer(this.ml);
            player.start();
            Component comp = player.getVisualComponent();
            if (comp != null) {
                comp.setLocation(15, 30);
                comp.setSize(400, 400);
                this.JPICamara.add(comp);
            }
            this.JPIFoto.add(imgpanel);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:General/JDCapturarFotografia$ImagePanel.class */
    public class ImagePanel extends JPanel {
        Image myimg = null;

        public ImagePanel() {
            setLayout(null);
            setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
            setLocation(15, 30);
            setSize(400, 400);
        }

        public void setImage(Image img) {
            this.myimg = img;
            repaint();
        }

        public void paint(Graphics g) {
            if (this.myimg != null) {
                g.drawImage(this.myimg, 0, 0, 400, 400, (ImageObserver) null);
            }
        }
    }

    public static JPanel getPanel_Imagen() {
        return imgpanel;
    }

    public static void playerclose() {
        player.close();
        player.deallocate();
    }
}
