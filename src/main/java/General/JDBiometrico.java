package General;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.Wacom;
import Utilidades.WebCam;
import com.WacomGSS.STU.STUException;
import com.WacomGSS.STU.TlsDevice;
import com.WacomGSS.STU.UsbDevice;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.processing.DPFPTemplateStatus;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import com.genoma.plus.controller.general.JD_EncuestaIngreso;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:General/JDBiometrico.class */
public class JDBiometrico extends JDialog {
    private Persona xjppersona;
    private ConsultasMySQL xconsultas;
    private PreparedStatement guardarStmt;
    boolean mensaje;
    boolean xtableta;
    private String xnombre;
    private String xid;
    private Metodos xmt;
    public Image image;
    boolean xvalidado;
    private File nueva_foto;
    private File xfile;
    private JPDibujo lienzo;
    private WebCam pnlCamara;
    private Wacom signatureDialog;
    private DPFPCapture Lector;
    private DPFPEnrollment Reclutador;
    private DPFPVerification Verificador;
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";
    private JDialog jdDialogo;
    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;
    ConsultasMySQL conexion;
    private JButton JBTCaptura;
    private JButton JBTSalir;
    private JButton JBTSalir1;
    private JButton JBT_Grabar;
    public JButton JBT_GrabarFirma;
    private JButton JBT_GrabarFoto;
    private JButton JBT_Identificar;
    private JButton JBT_Limpiar;
    private JButton JBT_Salir;
    private JLabel JLFirma;
    private JLabel JLFotografia;
    private JPanel JPBiometrico;
    private JPanel JPFOTO;
    private JPanel JPFirma;
    private JPanel JPICamara;
    private JPanel JPIFoto;
    private JPanel JPImageFirma;
    public JPanel JPPaint;
    private JTabbedPane JTBCamara;
    private JTabbedPane JTBFirma;
    public JTabbedPane JTPOpciones;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JLabel lblImagenHuella;
    private JPanel panBtns;
    private JPanel panHuellas;

    public JDBiometrico(Frame parent, boolean modal, Persona xjppersona) {
        super(parent, modal);
        this.xconsultas = new ConsultasMySQL();
        this.mensaje = false;
        this.xnombre = "";
        this.xid = "";
        this.xmt = new Metodos();
        this.xvalidado = false;
        this.nueva_foto = null;
        this.lienzo = new JPDibujo();
        this.pnlCamara = null;
        this.signatureDialog = null;
        this.Lector = null;
        this.Reclutador = null;
        this.Verificador = null;
        this.conexion = new ConsultasMySQL();
        initComponents();
        m10ajustarTamaoSegunCondicion();
        this.jdDialogo = null;
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjppersona = xjppersona;
        mInicarWacom();
        Cargar();
        if (!Principal.informacionIps.getIdentificacion().equals("900895500")) {
            this.pnlCamara = new WebCam(320, 240);
            this.pnlCamara.setSize(495, 261);
            this.JPICamara.add(this.pnlCamara);
            if (this.pnlCamara.webcam == null) {
                this.JBTCaptura.setEnabled(false);
                this.JBT_GrabarFoto.setEnabled(false);
                this.pnlCamara.discovery.stop();
                return;
            }
            return;
        }
        this.JTPOpciones.setSelectedIndex(1);
    }

    public JDBiometrico(Frame parent, boolean modal, JDialog jDialog) {
        super(parent, modal);
        this.xconsultas = new ConsultasMySQL();
        this.mensaje = false;
        this.xnombre = "";
        this.xid = "";
        this.xmt = new Metodos();
        this.xvalidado = false;
        this.nueva_foto = null;
        this.lienzo = new JPDibujo();
        this.pnlCamara = null;
        this.signatureDialog = null;
        this.Lector = null;
        this.Reclutador = null;
        this.Verificador = null;
        this.conexion = new ConsultasMySQL();
        initComponents();
        m10ajustarTamaoSegunCondicion();
        this.jdDialogo = jDialog;
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mInicarWacom();
        Cargar();
        if (!Principal.informacionIps.getIdentificacion().equals("900895500")) {
            this.pnlCamara = new WebCam(320, 240);
            this.pnlCamara.setSize(495, 261);
            this.JPICamara.add(this.pnlCamara);
            if (this.pnlCamara.webcam == null) {
                this.JBTCaptura.setEnabled(false);
                this.JBT_GrabarFoto.setEnabled(false);
                this.pnlCamara.discovery.stop();
            }
        } else {
            this.JTPOpciones.setSelectedIndex(1);
        }
        this.JTPOpciones.setSelectedIndex(1);
    }

    public JDBiometrico(Frame parent, boolean modal, String xnombre, String xid) {
        super(parent, modal);
        this.xconsultas = new ConsultasMySQL();
        this.mensaje = false;
        this.xnombre = "";
        this.xid = "";
        this.xmt = new Metodos();
        this.xvalidado = false;
        this.nueva_foto = null;
        this.lienzo = new JPDibujo();
        this.pnlCamara = null;
        this.signatureDialog = null;
        this.Lector = null;
        this.Reclutador = null;
        this.Verificador = null;
        this.conexion = new ConsultasMySQL();
        initComponents();
        m10ajustarTamaoSegunCondicion();
        this.jdDialogo = null;
        this.xnombre = xnombre;
        this.xid = xid;
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mInicarWacom();
        Cargar();
        this.JBT_Identificar.setEnabled(false);
        this.JBT_Identificar.setText("Firmar");
        if (!Principal.informacionIps.getIdentificacion().equals("900895500") || !Principal.informacionIps.getIdentificacion().equals("900754259")) {
            this.pnlCamara = new WebCam(320, 240);
            this.pnlCamara.setSize(495, 261);
            this.JPICamara.add(this.pnlCamara);
            if (this.pnlCamara.webcam == null) {
                this.JBTCaptura.setEnabled(false);
                this.JBT_GrabarFoto.setEnabled(false);
                this.pnlCamara.discovery.stop();
            }
        } else {
            this.JTPOpciones.setSelectedIndex(1);
        }
        try {
            consultarBD(this.xid);
        } catch (IOException ex) {
            Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: renamed from: ajustarTamañoSegunCondicion, reason: contains not printable characters */
    private void m10ajustarTamaoSegunCondicion() {
        if (Principal.informacionIps.getIdentificacion().equals("900895500")) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;
            int dialogHeight = (int) (((double) screenHeight) * 0.9d);
            setSize(screenWidth, dialogHeight);
            setLocation(0, 0);
        }
    }

    private void mInicarWacom() {
        if (!this.xmt.mExisteArchivo("C:\\Windows\\System32\\wgssSTU.dll")) {
            System.out.println("No Encontró el Archivo .dll");
            this.xtableta = false;
            this.lienzo.setBounds(0, 0, 495, 283);
            this.JPPaint.add(this.lienzo);
            this.JBT_GrabarFirma.setVisible(true);
            this.JBT_Limpiar.setVisible(true);
            return;
        }
        System.out.println("Encontró el Archivo .dll");
        try {
            UsbDevice[] usbDevices = UsbDevice.getUsbDevices();
            TlsDevice[] tlsDevices = TlsDevice.getTlsDevices();
            System.out.println("Dispositivos USB detectados: " + (usbDevices != null ? usbDevices.length : 0));
            System.out.println("Dispositivos TLS detectados: " + (tlsDevices != null ? tlsDevices.length : 0));
            UsbDevice usbDevice = null;
            TlsDevice tlsDevice = null;
            if (usbDevices != null && usbDevices.length > 0) {
                usbDevice = usbDevices[0];
            }
            if (tlsDevices != null && tlsDevices.length > 0) {
                tlsDevice = tlsDevices[0];
            }
            if (usbDevice == null && tlsDevice == null) {
                System.out.println("La Tableta no se Encuentra Conectada");
                this.lienzo.setBounds(0, 0, 495, 283);
                this.JPPaint.add(this.lienzo);
                this.JBT_GrabarFirma.setVisible(true);
                this.JBT_Limpiar.setVisible(true);
            } else {
                this.xtableta = true;
                this.signatureDialog = new Wacom(this, this.JPPaint, usbDevice, tlsDevice, false);
                System.out.println("Configurando el diálogo de firma...");
                this.signatureDialog.setVisible(false);
                this.JPPaint.setVisible(false);
                this.lienzo.setBounds(0, 0, 495, 283);
                this.JPPaint.add(this.signatureDialog);
                this.JPPaint.setVisible(true);
                this.signatureDialog.setVisible(true);
            }
        } catch (STUException e) {
            this.xtableta = false;
            System.out.println("Error STU: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, e, "Error (STU)", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        } catch (RuntimeException e2) {
            this.xtableta = false;
            System.out.println("Error en tiempo de ejecución: " + e2.getMessage());
            e2.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, e2, "Error (RT)", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        } catch (Exception e3) {
            this.xtableta = false;
            System.out.println("Error general: " + e3.getMessage());
            e3.printStackTrace();
            JOptionPane.showMessageDialog((Component) null, e3, "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    private void initComponents() {
        this.JTPOpciones = new JTabbedPane();
        this.JPFOTO = new JPanel();
        this.JTBCamara = new JTabbedPane();
        this.JPICamara = new JPanel();
        this.JPIFoto = new JPanel();
        this.JLFotografia = new JLabel();
        this.jPanel3 = new JPanel();
        this.JBT_GrabarFoto = new JButton();
        this.JBTCaptura = new JButton();
        this.JBTSalir = new JButton();
        this.JPFirma = new JPanel();
        this.JBT_GrabarFirma = new JButton();
        this.JBT_Limpiar = new JButton();
        this.JBTSalir1 = new JButton();
        this.JTBFirma = new JTabbedPane();
        this.JPPaint = new JPanel();
        this.JPImageFirma = new JPanel();
        this.JLFirma = new JLabel();
        this.JPBiometrico = new JPanel();
        this.panHuellas = new JPanel();
        this.jPanel1 = new JPanel();
        this.lblImagenHuella = new JLabel();
        this.panBtns = new JPanel();
        this.jPanel2 = new JPanel();
        this.JBT_Salir = new JButton();
        this.JBT_Identificar = new JButton();
        this.JBT_Grabar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("IDENTIFICADOR BIOMETRICO");
        addWindowListener(new WindowAdapter() { // from class: General.JDBiometrico.1
            public void windowOpened(WindowEvent evt) {
                JDBiometrico.this.formWindowOpened(evt);
            }

            public void windowClosing(WindowEvent evt) {
                JDBiometrico.this.formWindowClosing(evt);
            }
        });
        this.JTPOpciones.setForeground(Color.red);
        this.JTPOpciones.setFont(new Font("Arial", 1, 14));
        this.JTPOpciones.addMouseListener(new MouseAdapter() { // from class: General.JDBiometrico.2
            public void mouseClicked(MouseEvent evt) {
                JDBiometrico.this.JTPOpcionesMouseClicked(evt);
            }
        });
        this.JTBCamara.setForeground(new Color(0, 103, 0));
        this.JTBCamara.setFont(new Font("Arial", 1, 14));
        GroupLayout JPICamaraLayout = new GroupLayout(this.JPICamara);
        this.JPICamara.setLayout(JPICamaraLayout);
        JPICamaraLayout.setHorizontalGroup(JPICamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 481, 32767));
        JPICamaraLayout.setVerticalGroup(JPICamaraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 288, 32767));
        this.JTBCamara.addTab("CAMARA", this.JPICamara);
        GroupLayout JPIFotoLayout = new GroupLayout(this.JPIFoto);
        this.JPIFoto.setLayout(JPIFotoLayout);
        JPIFotoLayout.setHorizontalGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLFotografia, GroupLayout.Alignment.TRAILING, -1, 481, 32767));
        JPIFotoLayout.setVerticalGroup(JPIFotoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLFotografia, GroupLayout.Alignment.TRAILING, -1, 288, 32767));
        this.JTBCamara.addTab("FOTOGRAFIA", this.JPIFoto);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "ACCIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBT_GrabarFoto.setFont(new Font("Arial", 1, 12));
        this.JBT_GrabarFoto.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_GrabarFoto.setText("Grabar");
        this.JBT_GrabarFoto.addActionListener(new ActionListener() { // from class: General.JDBiometrico.3
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBT_GrabarFotoActionPerformed(evt);
            }
        });
        this.JBTCaptura.setFont(new Font("Arial", 1, 12));
        this.JBTCaptura.setIcon(new ImageIcon(getClass().getResource("/Imagenes/camara.png")));
        this.JBTCaptura.setText("Capturar");
        this.JBTCaptura.addActionListener(new ActionListener() { // from class: General.JDBiometrico.4
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBTCapturaActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: General.JDBiometrico.5
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JBTCaptura, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_GrabarFoto, -2, 151, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSalir, -1, -1, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_GrabarFoto, -2, 50, -2).addComponent(this.JBTCaptura, -2, 50, -2).addComponent(this.JBTSalir, -2, 50, -2)).addGap(10, 10, 10)));
        GroupLayout JPFOTOLayout = new GroupLayout(this.JPFOTO);
        this.JPFOTO.setLayout(JPFOTOLayout);
        JPFOTOLayout.setHorizontalGroup(JPFOTOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFOTOLayout.createSequentialGroup().addContainerGap().addGroup(JPFOTOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTBCamara, -1, 481, 32767).addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        JPFOTOLayout.setVerticalGroup(JPFOTOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFOTOLayout.createSequentialGroup().addContainerGap().addComponent(this.JTBCamara, -2, 319, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2).addContainerGap()));
        this.JTPOpciones.addTab("FOTOGRAFIA", this.JPFOTO);
        this.JBT_GrabarFirma.setFont(new Font("Arial", 1, 12));
        this.JBT_GrabarFirma.setForeground(new Color(0, 0, 153));
        this.JBT_GrabarFirma.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_GrabarFirma.setText("Grabar");
        this.JBT_GrabarFirma.addActionListener(new ActionListener() { // from class: General.JDBiometrico.6
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBT_GrabarFirmaActionPerformed(evt);
            }
        });
        this.JBT_Limpiar.setFont(new Font("Arial", 1, 12));
        this.JBT_Limpiar.setForeground(new Color(0, 0, 153));
        this.JBT_Limpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBT_Limpiar.setText("Limpiar");
        this.JBT_Limpiar.addActionListener(new ActionListener() { // from class: General.JDBiometrico.7
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBT_LimpiarActionPerformed(evt);
            }
        });
        this.JBTSalir1.setFont(new Font("Arial", 1, 12));
        this.JBTSalir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir1.setText("Salir");
        this.JBTSalir1.addActionListener(new ActionListener() { // from class: General.JDBiometrico.8
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBTSalir1ActionPerformed(evt);
            }
        });
        this.JTBFirma.setForeground(new Color(0, 103, 0));
        this.JTBFirma.setFont(new Font("Arial", 1, 14));
        this.JTBFirma.setPreferredSize(new Dimension(495, 283));
        this.JPPaint.setBackground(new Color(210, 231, 252));
        this.JPPaint.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JPPaint.setName("neno");
        GroupLayout JPPaintLayout = new GroupLayout(this.JPPaint);
        this.JPPaint.setLayout(JPPaintLayout);
        JPPaintLayout.setHorizontalGroup(JPPaintLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 471, 32767));
        JPPaintLayout.setVerticalGroup(JPPaintLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 250, 32767));
        this.JTBFirma.addTab("CAPTURA DE FIRMA", this.JPPaint);
        GroupLayout JPImageFirmaLayout = new GroupLayout(this.JPImageFirma);
        this.JPImageFirma.setLayout(JPImageFirmaLayout);
        JPImageFirmaLayout.setHorizontalGroup(JPImageFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLFirma, GroupLayout.Alignment.TRAILING, -1, 473, 32767));
        JPImageFirmaLayout.setVerticalGroup(JPImageFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLFirma, GroupLayout.Alignment.TRAILING, -1, 252, 32767));
        this.JTBFirma.addTab("IMAGEN", this.JPImageFirma);
        GroupLayout JPFirmaLayout = new GroupLayout(this.JPFirma);
        this.JPFirma.setLayout(JPFirmaLayout);
        JPFirmaLayout.setHorizontalGroup(JPFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFirmaLayout.createSequentialGroup().addGroup(JPFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFirmaLayout.createSequentialGroup().addContainerGap().addGroup(JPFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTSalir1, -1, -1, 32767).addGroup(JPFirmaLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JBT_Limpiar, -2, 143, -2)))).addGroup(JPFirmaLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFirmaLayout.createSequentialGroup().addComponent(this.JBT_GrabarFirma, -2, 142, -2).addGap(0, 0, 32767)).addComponent(this.JTBFirma, -1, 473, 32767)))).addContainerGap()));
        JPFirmaLayout.setVerticalGroup(JPFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFirmaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTBFirma, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPFirmaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Limpiar, -2, 54, -2).addComponent(this.JBT_GrabarFirma, -2, 53, -2)).addGap(18, 18, 18).addComponent(this.JBTSalir1, -2, 50, -2).addContainerGap()));
        this.JBT_GrabarFirma.setVisible(false);
        this.JBT_Limpiar.setVisible(false);
        this.JTPOpciones.addTab("FIRMA", this.JPFirma);
        this.panHuellas.setBorder(BorderFactory.createTitledBorder((Border) null, "Huella Digital Capturada", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.panHuellas.setPreferredSize(new Dimension(400, 270));
        this.panHuellas.setLayout(new BorderLayout());
        this.jPanel1.setBorder(BorderFactory.createBevelBorder(1));
        this.jPanel1.setLayout(new BorderLayout());
        this.jPanel1.add(this.lblImagenHuella, "Center");
        this.panHuellas.add(this.jPanel1, "Center");
        this.panBtns.setBorder(BorderFactory.createTitledBorder((Border) null, "Acciones", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.panBtns.setPreferredSize(new Dimension(400, 190));
        this.panBtns.setLayout(new AbsoluteLayout());
        this.jPanel2.setPreferredSize(new Dimension(366, 90));
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setForeground(new Color(0, 0, 153));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: General.JDBiometrico.9
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBT_Identificar.setFont(new Font("Arial", 1, 12));
        this.JBT_Identificar.setForeground(new Color(0, 0, 153));
        this.JBT_Identificar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBT_Identificar.setText("Identificar");
        this.JBT_Identificar.setPreferredSize(new Dimension(71, 23));
        this.JBT_Identificar.addActionListener(new ActionListener() { // from class: General.JDBiometrico.10
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBT_IdentificarActionPerformed(evt);
            }
        });
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setForeground(new Color(0, 0, 153));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: General.JDBiometrico.11
            public void actionPerformed(ActionEvent evt) {
                JDBiometrico.this.JBT_GrabarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JBT_Identificar, -2, 139, -2).addGap(18, 18, 18).addComponent(this.JBT_Grabar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_Salir, -2, 128, -2).addGap(27, 27, 27)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Identificar, -2, 40, -2).addComponent(this.JBT_Grabar, -2, 41, -2).addComponent(this.JBT_Salir, -2, 41, -2)).addGap(10, 10, 10)));
        this.panBtns.add(this.jPanel2, new AbsoluteConstraints(6, 19, 475, 50));
        GroupLayout JPBiometricoLayout = new GroupLayout(this.JPBiometrico);
        this.JPBiometrico.setLayout(JPBiometricoLayout);
        JPBiometricoLayout.setHorizontalGroup(JPBiometricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBiometricoLayout.createSequentialGroup().addContainerGap().addComponent(this.panBtns, -1, 481, 32767).addContainerGap()).addComponent(this.panHuellas, -1, -1, 32767));
        JPBiometricoLayout.setVerticalGroup(JPBiometricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPBiometricoLayout.createSequentialGroup().addContainerGap().addComponent(this.panHuellas, -2, 307, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.panBtns, -2, 73, -2).addContainerGap()));
        this.JTPOpciones.addTab("BIOMETRIA", this.JPBiometrico);
        this.JPBiometrico.getAccessibleContext().setAccessibleName("");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPOpciones));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTPOpciones).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        mSalir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_IdentificarActionPerformed(ActionEvent evt) {
        try {
            if (this.xnombre.equals("xjp_pruebaayd") || this.xnombre.equals("xIngreso") || this.xnombre.equals("xjdconcentimientoinformado") || this.xnombre.equals("jifgeneraciondescuento") || this.xnombre.equals("jifactas")) {
                guardarHuella();
            } else {
                identificarHuella();
            }
            this.Reclutador.clear();
        } catch (IOException ex) {
            Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        guardarHuella();
        this.Reclutador.clear();
        JBT_SalirActionPerformed(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formWindowOpened(WindowEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formWindowClosing(WindowEvent evt) {
        mSalir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarFirmaActionPerformed(ActionEvent evt) {
        mGrabarFirma();
    }

    public void mGrabarFirma() {
        Connection c;
        int l;
        InputStream is;
        if (!this.xtableta) {
            mCapturarFirma();
        }
        try {
            if (this.jdDialogo != null) {
                JD_EncuestaIngreso jd = (JD_EncuestaIngreso) this.jdDialogo;
                jd.setArchivo(new File(this.xmt.getDirectorioExportacion() + "Firma.png"));
                dispose();
                return;
            }
            try {
                try {
                    c = this.conexion.establecerConexionBd();
                    File archivo = new File("Firma.png");
                    l = (int) archivo.length();
                    is = new BufferedInputStream(new FileInputStream(archivo));
                    switch (this.xnombre) {
                        case "xIngreso":
                            if (consultarBD(this.xid)) {
                                this.guardarStmt = c.prepareStatement("UPDATE `ingreso_biometria` SET `Firma` = (?) WHERE `Id_Ingreso` = '" + this.xid + "'");
                                this.guardarStmt.setBinaryStream(1, is, l);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            } else {
                                this.guardarStmt = c.prepareStatement("INSERT INTO `ingreso_biometria`(`Id_Ingreso`,`Firma`) VALUES (?,?);");
                                this.guardarStmt.setString(1, this.xid);
                                this.guardarStmt.setBinaryStream(2, is, l);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            }
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "xjpconceptolaboral":
                            this.guardarStmt = c.prepareStatement("UPDATE `h_so_concepto_laboral` SET `Firma` = (?) WHERE `Id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is, l);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "xjdconcentimientoinformado":
                            this.guardarStmt = c.prepareStatement("UPDATE `ingreso_consentimiento_informado` SET `Firma` = (?) WHERE `Id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is, l);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "jifautorizacion":
                        case "jifgeneraciondescuento":
                            this.guardarStmt = c.prepareStatement("UPDATE `d_descuento` SET `Firma` = (?) WHERE `Id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is, l);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "jifactas":
                            this.guardarStmt = c.prepareStatement("UPDATE `s_sgc_actas_asistentes` SET `Firma` = (?), FechaFirma = (?) WHERE `Id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is, l);
                            this.guardarStmt.setString(2, this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "xjpordensalidaingreso":
                            this.guardarStmt = c.prepareStatement("UPDATE `ingreso_orden_salida` SET `Firma` = (?) WHERE `Id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is, l);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "jifdocumentoc":
                            if (consultarBD(this.xid)) {
                                this.guardarStmt = c.prepareStatement("UPDATE `cc_documentoc_biometria` SET `Firma` = (?) WHERE `IdDocumentoC` = '" + this.xid + "'");
                                this.guardarStmt.setBinaryStream(1, is, l);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            } else {
                                this.guardarStmt = c.prepareStatement("INSERT INTO `cc_documentoc_biometria`(`IdDocumentoC`,`Firma`) VALUES (?,?);");
                                this.guardarStmt.setString(1, this.xid);
                                this.guardarStmt.setBinaryStream(2, is, l);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            }
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "xjifrecibosegresos":
                            if (consultarBD(this.xid)) {
                                this.guardarStmt = c.prepareStatement("UPDATE `k_recibos_egresos_biometria` SET `Firma` = (?) WHERE `IdRecibo` = '" + this.xid + "'");
                                this.guardarStmt.setBinaryStream(1, is, l);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            } else {
                                this.guardarStmt = c.prepareStatement("INSERT INTO `k_recibos_egresos_biometria`(`IdRecibo`,`Firma`) VALUES (?,?);");
                                this.guardarStmt.setString(1, this.xid);
                                this.guardarStmt.setBinaryStream(2, is, l);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            }
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "Recibos":
                            if (consultarBD(this.xid)) {
                                this.guardarStmt = c.prepareStatement("UPDATE `k_recibos_biometria` SET `Firma` = (?) WHERE `IdRecibo` = '" + this.xid + "'");
                                this.guardarStmt.setBinaryStream(1, is, l);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            } else {
                                this.guardarStmt = c.prepareStatement("INSERT INTO `k_recibos_biometria`(`IdRecibo`,`Firma`) VALUES (?,?);");
                                this.guardarStmt.setString(1, this.xid);
                                this.guardarStmt.setBinaryStream(2, is, l);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            }
                            JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                            break;
                        case "xjifcontrolderemisiones":
                            this.guardarStmt = c.prepareStatement("UPDATE `so_control_remisiones` SET `firmaColaborador` = (?) WHERE `id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is, l);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            break;
                    }
                    ImageIcon firma = new ImageIcon("Firma.png");
                    this.JLFirma.setIcon(new ImageIcon(firma.getImage().getScaledInstance(this.JPPaint.getWidth(), this.JPPaint.getHeight(), 1)));
                    JLabel jLabel = this.JLFirma;
                    JLabel jLabel2 = this.JLFirma;
                    jLabel.setHorizontalAlignment(0);
                    JLabel jLabel3 = this.JLFirma;
                    JLabel jLabel4 = this.JLFirma;
                    jLabel3.setVerticalAlignment(0);
                    this.JLFirma.repaint();
                    this.JTBFirma.setSelectedIndex(1);
                    this.xmt.mEliminarArchivo(archivo);
                    this.conexion.cerrarConexionBd();
                    this.conexion.cerrarConexionBd();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    this.conexion.cerrarConexionBd();
                } catch (SQLException ex2) {
                    System.err.println(ex2);
                    this.conexion.cerrarConexionBd();
                }
            } catch (IOException ex3) {
                Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                this.conexion.cerrarConexionBd();
            }
        } catch (Throwable th) {
            this.conexion.cerrarConexionBd();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_LimpiarActionPerformed(ActionEvent evt) {
        if (!this.xtableta) {
            this.lienzo.lapiz = 0;
            this.lienzo.limpiar();
            this.lienzo.lapiz = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        mSalir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarFotoActionPerformed(ActionEvent evt) {
        try {
            try {
                File archivo = new File("Foto.jpg");
                Connection c = this.conexion.establecerConexionBd();
                BufferedImage image = this.pnlCamara.webcam.getImage();
                ImageIO.write(image, "jpg", archivo);
                int l = (int) archivo.length();
                InputStream is = new BufferedInputStream(new FileInputStream(archivo));
                if (this.xnombre.equals("xIngreso")) {
                    if (consultarBD(this.xid)) {
                        this.guardarStmt = c.prepareStatement("UPDATE `ingreso_biometria` SET `Foto` = (?) WHERE `Id_Ingreso` = '" + this.xid + "'");
                        this.guardarStmt.setBinaryStream(1, is, l);
                        this.guardarStmt.execute();
                        this.guardarStmt.close();
                        this.JBT_Grabar.setEnabled(false);
                    } else {
                        this.guardarStmt = c.prepareStatement("INSERT INTO `ingreso_biometria`(`Id_Ingreso`,`Foto`) VALUES (?,?);");
                        this.guardarStmt.setString(1, this.xid);
                        this.guardarStmt.setBinaryStream(2, is, l);
                        this.guardarStmt.execute();
                        this.guardarStmt.close();
                        this.JBT_Grabar.setEnabled(false);
                    }
                    this.xmt.mEliminarArchivo(archivo);
                }
                JOptionPane.showMessageDialog((Component) null, "Fotografia Guardada Correctamente");
                this.conexion.cerrarConexionBd();
                this.conexion.cerrarConexionBd();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                this.conexion.cerrarConexionBd();
            } catch (IOException ex2) {
                Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                this.conexion.cerrarConexionBd();
            } catch (SQLException e) {
                System.err.println("Error al guardar los datos de la Fotografia.");
                this.conexion.cerrarConexionBd();
            }
        } catch (Throwable th) {
            this.conexion.cerrarConexionBd();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCapturaActionPerformed(ActionEvent evt) {
        this.pnlCamara.CapturaFoto();
        ImageIcon fot = new ImageIcon("Foto.jpg");
        this.JLFotografia.setIcon(new ImageIcon(fot.getImage().getScaledInstance(320, 240, 1)));
        JLabel jLabel = this.JLFotografia;
        JLabel jLabel2 = this.JLFotografia;
        jLabel.setHorizontalAlignment(0);
        JLabel jLabel3 = this.JLFotografia;
        JLabel jLabel4 = this.JLFotografia;
        jLabel3.setVerticalAlignment(0);
        this.JLFotografia.repaint();
        this.JTBCamara.setSelectedIndex(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalir1ActionPerformed(ActionEvent evt) {
        mSalir();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPOpcionesMouseClicked(MouseEvent evt) {
        Integer.valueOf(this.JPPaint.getHeight());
        Integer.valueOf(this.JPPaint.getWidth());
        this.lienzo.setBounds(0, 0, this.JPPaint.getWidth(), this.JPPaint.getHeight());
    }

    protected void Iniciar() {
        this.Lector.addDataListener(new DPFPDataAdapter() { // from class: General.JDBiometrico.12
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() { // from class: General.JDBiometrico.12.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JDBiometrico.this.ProcesarCaptura(e.getSample());
                    }
                });
            }
        });
        this.Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() { // from class: General.JDBiometrico.13
            public void readerConnected(DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() { // from class: General.JDBiometrico.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }

            public void readerDisconnected(DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() { // from class: General.JDBiometrico.13.2
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        });
        this.Lector.addSensorListener(new DPFPSensorAdapter() { // from class: General.JDBiometrico.14
            public void fingerTouched(DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() { // from class: General.JDBiometrico.14.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }

            public void fingerGone(DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() { // from class: General.JDBiometrico.14.2
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        });
        this.Lector.addErrorListener(new DPFPErrorAdapter() { // from class: General.JDBiometrico.15
            public void errorReader(DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() { // from class: General.JDBiometrico.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                });
            }
        });
    }

    public void ProcesarCaptura(DPFPSample sample) {
        this.featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        this.featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        if (this.featuresinscripcion != null) {
            try {
                try {
                    this.Reclutador.addFeatures(this.featuresinscripcion);
                    this.image = CrearImagenHuella(sample);
                    DibujarHuella(this.image);
                    if (!this.xnombre.equals("xjp_pruebaayd")) {
                        this.JBT_Identificar.setEnabled(true);
                    }
                    EstadoHuellas();
                    switch (AnonymousClass16.$SwitchMap$com$digitalpersona$onetouch$processing$DPFPTemplateStatus[this.Reclutador.getTemplateStatus().ordinal()]) {
                        case 1:
                            stop();
                            setTemplate(this.Reclutador.getTemplate());
                            this.JBT_Identificar.setEnabled(false);
                            this.JBT_Grabar.setEnabled(true);
                            this.JBT_Grabar.grabFocus();
                            if ("".equals(this.xnombre) && "0" == this.xjppersona.getIdPersona()) {
                                this.JBT_Grabar.setEnabled(false);
                                JOptionPane.showMessageDialog((Component) null, "Debe Cargar Un Usuario Para Grabar su Huella", "Verificar", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.xjppersona.txtHistoria.requestFocus();
                                JBT_SalirActionPerformed(null);
                                return;
                            }
                            return;
                        case 2:
                            this.Reclutador.clear();
                            stop();
                            setTemplate(null);
                            JOptionPane.showMessageDialog(this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            JBT_SalirActionPerformed(null);
                            return;
                        default:
                            return;
                    }
                } catch (DPFPImageQualityException ex) {
                    System.err.println("Error: " + ex.getMessage());
                    EstadoHuellas();
                    switch (AnonymousClass16.$SwitchMap$com$digitalpersona$onetouch$processing$DPFPTemplateStatus[this.Reclutador.getTemplateStatus().ordinal()]) {
                        case 1:
                            stop();
                            setTemplate(this.Reclutador.getTemplate());
                            this.JBT_Identificar.setEnabled(false);
                            this.JBT_Grabar.setEnabled(true);
                            this.JBT_Grabar.grabFocus();
                            if ("".equals(this.xnombre) && "0" == this.xjppersona.getIdPersona()) {
                                this.JBT_Grabar.setEnabled(false);
                                JOptionPane.showMessageDialog((Component) null, "Debe Cargar Un Usuario Para Grabar su Huella", "Verificar", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                                this.xjppersona.txtHistoria.requestFocus();
                                JBT_SalirActionPerformed(null);
                                return;
                            }
                            return;
                        case 2:
                            this.Reclutador.clear();
                            stop();
                            setTemplate(null);
                            JOptionPane.showMessageDialog(this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            JBT_SalirActionPerformed(null);
                            return;
                        default:
                            return;
                    }
                }
            } catch (Throwable th) {
                EstadoHuellas();
                switch (AnonymousClass16.$SwitchMap$com$digitalpersona$onetouch$processing$DPFPTemplateStatus[this.Reclutador.getTemplateStatus().ordinal()]) {
                    case 1:
                        stop();
                        setTemplate(this.Reclutador.getTemplate());
                        this.JBT_Identificar.setEnabled(false);
                        this.JBT_Grabar.setEnabled(true);
                        this.JBT_Grabar.grabFocus();
                        if ("".equals(this.xnombre) && "0" == this.xjppersona.getIdPersona()) {
                            this.JBT_Grabar.setEnabled(false);
                            JOptionPane.showMessageDialog((Component) null, "Debe Cargar Un Usuario Para Grabar su Huella", "Verificar", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.xjppersona.txtHistoria.requestFocus();
                            JBT_SalirActionPerformed(null);
                        }
                        break;
                    case 2:
                        this.Reclutador.clear();
                        stop();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        JBT_SalirActionPerformed(null);
                        break;
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: General.JDBiometrico$16, reason: invalid class name */
    /* JADX INFO: loaded from: GenomaP.jar:General/JDBiometrico$16.class */
    static /* synthetic */ class AnonymousClass16 {
        static final /* synthetic */ int[] $SwitchMap$com$digitalpersona$onetouch$processing$DPFPTemplateStatus = new int[DPFPTemplateStatus.values().length];

        static {
            try {
                $SwitchMap$com$digitalpersona$onetouch$processing$DPFPTemplateStatus[DPFPTemplateStatus.TEMPLATE_STATUS_READY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$digitalpersona$onetouch$processing$DPFPTemplateStatus[DPFPTemplateStatus.TEMPLATE_STATUS_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (DPFPImageQualityException e) {
            return null;
        }
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        this.lblImagenHuella.setIcon(new ImageIcon(image.getScaledInstance(this.lblImagenHuella.getWidth(), this.lblImagenHuella.getHeight(), 1)));
        repaint();
    }

    public void EstadoHuellas() {
        this.Reclutador.getFeaturesNeeded();
    }

    public void start() {
        this.Lector.startCapture();
    }

    public void stop() {
        this.Lector.stopCapture();
    }

    public DPFPTemplate getTemplate() {
        return this.template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    public void guardarHuella() {
        Connection c;
        try {
            try {
                if (this.jdDialogo == null) {
                    c = this.conexion.establecerConexionBd();
                    switch (this.xnombre) {
                        case "xjp_pruebaayd":
                        case "xjptest_prespiratorio":
                            ByteArrayInputStream datosHuella = new ByteArrayInputStream(this.template.serialize());
                            Integer numValueOf = Integer.valueOf(this.template.serialize().length);
                            ImageIO.write(this.image, "jpg", new File("huella.jpg"));
                            File archivo = new File("huella.jpg");
                            int l = (int) archivo.length();
                            InputStream is = new BufferedInputStream(new FileInputStream(archivo));
                            if (this.xnombre.equals("xjp_pruebaayd")) {
                                this.guardarStmt = c.prepareStatement("UPDATE h_so_alcohol_drogas set Huella=(?), Fecha_Huella=(?), Huella_Imagen=(?) where Id='" + this.xid + "'");
                            } else if (this.xnombre.equals("xjptest_prespiratorio")) {
                                this.guardarStmt = c.prepareStatement("UPDATE h_so_test_auditivo set Huella=(?), Fecha_Huella=(?), Huella_Imagen=(?) where Id='" + Principal.clasehistoriace.xjifhistoriaclinica.xjiftest_prespiratorio.xgrabado + "'");
                            }
                            this.guardarStmt.setBinaryStream(1, (InputStream) datosHuella, numValueOf.intValue());
                            this.guardarStmt.setString(2, this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
                            this.guardarStmt.setBinaryStream(3, is, l);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            is.close();
                            this.xmt.mEliminarArchivo(archivo);
                            break;
                        case "jifautorizacion":
                        case "jifgeneraciondescuento":
                            ImageIO.write(this.image, "jpg", new File("huella.jpg"));
                            File archivo2 = new File("huella.jpg");
                            int l2 = (int) archivo2.length();
                            InputStream is2 = new BufferedInputStream(new FileInputStream(archivo2));
                            this.guardarStmt = c.prepareStatement("UPDATE d_descuento set Fecha_Huella=(?), Huella_Imagen=(?) where Id='" + this.xid + "'");
                            this.guardarStmt.setString(1, this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
                            this.guardarStmt.setBinaryStream(2, is2, l2);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            is2.close();
                            this.xmt.mEliminarArchivo(archivo2);
                            break;
                        case "xjdconcentimientoinformado":
                            File archivo3 = new File("huella.jpg");
                            ImageIO.write(this.image, "jpg", archivo3);
                            int l3 = (int) archivo3.length();
                            InputStream is3 = new BufferedInputStream(new FileInputStream(archivo3));
                            this.guardarStmt = c.prepareStatement("UPDATE `ingreso_consentimiento_informado` SET `Huella` = (?) WHERE `Id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is3, l3);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            this.xmt.mEliminarArchivo(archivo3);
                            break;
                        case "jifactas":
                            File archivo4 = new File("huella.jpg");
                            ImageIO.write(this.image, "jpg", archivo4);
                            int l4 = (int) archivo4.length();
                            InputStream is4 = new BufferedInputStream(new FileInputStream(archivo4));
                            this.guardarStmt = c.prepareStatement("UPDATE `s_sgc_actas_asistentes` SET `Huella` = (?) WHERE `Id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is4, l4);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            this.xmt.mEliminarArchivo(archivo4);
                            break;
                        case "xjpordensalidaingreso":
                            File archivo5 = new File("huella.jpg");
                            ImageIO.write(this.image, "jpg", archivo5);
                            int l5 = (int) archivo5.length();
                            InputStream is5 = new BufferedInputStream(new FileInputStream(archivo5));
                            this.guardarStmt = c.prepareStatement("UPDATE `ingreso_orden_salida` SET `Huella` = (?) WHERE `Id` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is5, l5);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            this.xmt.mEliminarArchivo(archivo5);
                            break;
                        case "xIngreso":
                            File archivo6 = new File("huella.jpg");
                            ImageIO.write(this.image, "jpg", archivo6);
                            int l6 = (int) archivo6.length();
                            InputStream is6 = new BufferedInputStream(new FileInputStream(archivo6));
                            if (consultarBD(this.xid)) {
                                this.guardarStmt = c.prepareStatement("UPDATE `ingreso_biometria` SET `Huella` = (?) WHERE `Id_Ingreso` = '" + this.xid + "'");
                                this.guardarStmt.setBinaryStream(1, is6, l6);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            } else {
                                this.guardarStmt = c.prepareStatement("INSERT INTO `ingreso_biometria`(`Id_Ingreso`,`Huella`) VALUES (?,?);");
                                this.guardarStmt.setString(1, this.xid);
                                this.guardarStmt.setBinaryStream(2, is6, l6);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            }
                            this.xmt.mEliminarArchivo(archivo6);
                            break;
                        case "jifdocumentoc":
                            File archivo7 = new File("huella.jpg");
                            ImageIO.write(this.image, "jpg", archivo7);
                            int l7 = (int) archivo7.length();
                            InputStream is7 = new BufferedInputStream(new FileInputStream(archivo7));
                            if (consultarBD(this.xid)) {
                                this.guardarStmt = c.prepareStatement("UPDATE `cc_documentoc_biometria` SET `Huella` = (?) WHERE `IdDocumentoC` = '" + this.xid + "'");
                                this.guardarStmt.setBinaryStream(1, is7, l7);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            } else {
                                this.guardarStmt = c.prepareStatement("INSERT INTO `cc_documentoc_biometria`(`IdDocumentoC`,`Huella`) VALUES (?,?);");
                                this.guardarStmt.setString(1, this.xid);
                                this.guardarStmt.setBinaryStream(2, is7, l7);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            }
                            this.xmt.mEliminarArchivo(archivo7);
                            break;
                        case "xjifrecibosegresos":
                            File archivo8 = new File("huella.jpg");
                            ImageIO.write(this.image, "jpg", archivo8);
                            int l8 = (int) archivo8.length();
                            InputStream is8 = new BufferedInputStream(new FileInputStream(archivo8));
                            if (consultarBD(this.xid)) {
                                this.guardarStmt = c.prepareStatement("UPDATE `k_recibos_egresos_biometria` SET `Huella` = (?) WHERE `IdRecibo` = '" + this.xid + "'");
                                this.guardarStmt.setBinaryStream(1, is8, l8);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            } else {
                                this.guardarStmt = c.prepareStatement("INSERT INTO `k_recibos_egresos_biometria`(`IdRecibo`,`Huella`) VALUES (?,?);");
                                this.guardarStmt.setString(1, this.xid);
                                this.guardarStmt.setBinaryStream(2, is8, l8);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            }
                            this.xmt.mEliminarArchivo(archivo8);
                            break;
                        case "Recibos":
                            File archivo9 = new File("huella.jpg");
                            ImageIO.write(this.image, "jpg", archivo9);
                            int l9 = (int) archivo9.length();
                            InputStream is9 = new BufferedInputStream(new FileInputStream(archivo9));
                            if (consultarBD(this.xid)) {
                                this.guardarStmt = c.prepareStatement("UPDATE `k_recibos_biometria` SET `Huella` = (?) WHERE `IdRecibo` = '" + this.xid + "'");
                                this.guardarStmt.setBinaryStream(1, is9, l9);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            } else {
                                this.guardarStmt = c.prepareStatement("INSERT INTO `k_recibos_biometria`(`IdRecibo`,`Huella`) VALUES (?,?);");
                                this.guardarStmt.setString(1, this.xid);
                                this.guardarStmt.setBinaryStream(2, is9, l9);
                                this.guardarStmt.execute();
                                this.guardarStmt.close();
                                this.JBT_Grabar.setEnabled(false);
                            }
                            this.xmt.mEliminarArchivo(archivo9);
                            break;
                        default:
                            ByteArrayInputStream datosHuella2 = new ByteArrayInputStream(this.template.serialize());
                            Integer numValueOf2 = Integer.valueOf(this.template.serialize().length);
                            this.guardarStmt = c.prepareStatement("UPDATE g_persona set Huella=(?) where ID='" + this.xjppersona.getIdPersona() + "'");
                            this.guardarStmt.setBinaryStream(1, (InputStream) datosHuella2, numValueOf2.intValue());
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                            this.JBT_Grabar.setEnabled(false);
                            break;
                    }
                } else {
                    JD_EncuestaIngreso jd = (JD_EncuestaIngreso) this.jdDialogo;
                    jd.setArchivoHuella(new File(this.xmt.getDirectorioExportacion() + "huella.jpg"));
                    dispose();
                }
                JOptionPane.showMessageDialog((Component) null, "Huella Guardada Correctamente");
                this.conexion.cerrarConexionBd();
                this.conexion.cerrarConexionBd();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                this.conexion.cerrarConexionBd();
            } catch (IOException ex2) {
                Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                this.conexion.cerrarConexionBd();
            } catch (SQLException e) {
                System.err.println("Error al guardar los datos de la huella.");
                this.conexion.cerrarConexionBd();
            }
        } catch (Throwable th) {
            this.conexion.cerrarConexionBd();
            throw th;
        }
    }

    public void identificarHuella() throws IOException {
        try {
            Connection c = this.conexion.establecerConexionBd();
            PreparedStatement identificarStmt = c.prepareStatement("SELECT Id,CONCAT(Apellido1,' ',Apellido2,' ',Nombre1,' ',Nombre2) AS Nombre,Huella FROM g_persona where huella is not null");
            ResultSet rs = identificarStmt.executeQuery();
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    byte[] templateBuffer = rs.getBytes("Huella");
                    rs.getString("Nombre");
                    DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                    setTemplate(referenceTemplate);
                    DPFPVerificationResult result = this.Verificador.verify(this.featuresverificacion, getTemplate());
                    if (result.isVerified()) {
                        this.xjppersona.setIdPersona(rs.getString("Id"));
                        this.xjppersona.buscar(1);
                        this.xvalidado = true;
                        dispose();
                        mSalir();
                        this.conexion.cerrarConexionBd();
                        return;
                    }
                    this.xvalidado = false;
                    setTemplate(null);
                }
                if (!this.xvalidado) {
                    JOptionPane.showMessageDialog((Component) null, "No existe ningún registro que coincida con la huella", "Verificacion de Huella", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.lblImagenHuella.setIcon((Icon) null);
                }
            } else if (!this.xjppersona.getIdPersona().equals("0")) {
                this.JBT_Grabar.setEnabled(true);
            }
            this.conexion.cerrarConexionBd();
        } catch (SQLException e) {
            this.conexion.cerrarConexionBd();
        } catch (Throwable th) {
            this.conexion.cerrarConexionBd();
            throw th;
        }
    }

    public void Cargar() {
        if (this.xmt.mExisteArchivo("C:\\Program Files (x86)\\DigitalPersona") || this.xmt.mExisteArchivo("C:\\Program Files\\DigitalPersona")) {
            this.Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
            this.Verificador = DPFPGlobal.getVerificationFactory().createVerification();
            this.Lector = DPFPGlobal.getCaptureFactory().createCapture();
            Iniciar();
            start();
            EstadoHuellas();
        }
        this.JBT_Grabar.setEnabled(false);
        this.JBT_Identificar.setEnabled(false);
        this.JBT_Salir.grabFocus();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
    public void mSalir() {
        if (this.xmt.mExisteArchivo("C:\\Program Files (x86)\\DigitalPersona") || this.xmt.mExisteArchivo("C:\\Program Files\\DigitalPersona")) {
            stop();
            this.Reclutador.clear();
            this.lblImagenHuella.setIcon((Icon) null);
            this.Lector.stopCapture();
        }
        if (this.xtableta) {
            try {
                this.signatureDialog.pressClearButton();
                this.signatureDialog.dispose();
            } catch (STUException e) {
                Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
        if (!Principal.informacionIps.getIdentificacion().equals("900895500")) {
            this.pnlCamara.discovery.stop();
            if (this.pnlCamara.webcam != null) {
                this.pnlCamara.webcam.close();
            }
        }
        if (this.xnombre.equals("jifactas")) {
            Principal.xclasesgc.xJIFActas.mCargarDatosTablaAsistentes();
        }
        dispose();
    }

    public boolean consultarBD(String xid) throws IOException {
        String sql;
        boolean xhuella;
        boolean xfoto;
        boolean xfirma;
        Blob Firma;
        Blob Foto;
        Blob Huella;
        sql = null;
        boolean xexiste = false;
        xhuella = false;
        xfoto = false;
        xfirma = false;
        switch (this.xnombre) {
            case "xIngreso":
                sql = "SELECT `Id_Ingreso`, `Huella`, `Foto`, `Firma` FROM `ingreso_biometria` WHERE (`Id_Ingreso` ='" + xid + "');";
                xhuella = true;
                xfoto = true;
                xfirma = true;
                break;
            case "xjdconcentimientoinformado":
                sql = "SELECT `Id`, `Huella`, `Firma` FROM `ingreso_consentimiento_informado` WHERE (`Id` ='" + xid + "');";
                xhuella = true;
                xfirma = true;
                break;
            case "jifautorizacion":
            case "jifgeneraciondescuento":
                sql = "SELECT `Id`, `Huella_Imagen` as Huella, `Firma` FROM `d_descuento` WHERE (`Id` ='" + xid + "');";
                xhuella = true;
                xfirma = true;
                break;
            case "jifactas":
                sql = "SELECT `Id`, Huella, `Firma` FROM `s_sgc_actas_asistentes` WHERE (`Id` ='" + xid + "');";
                xhuella = true;
                xfirma = true;
                break;
            case "xjpordensalidaingreso":
                sql = "SELECT `Id`, Huella, `Firma` FROM `ingreso_orden_salida` WHERE (`Id` ='" + xid + "');";
                xhuella = true;
                xfirma = true;
                break;
            case "jifdocumentoc":
                sql = "SELECT `IdDocumentoC`, Huella, `Firma` FROM `cc_documentoc_biometria` WHERE (`IdDocumentoC` ='" + xid + "' AND Estado=1);";
                xhuella = true;
                xfirma = true;
                break;
            case "xjifrecibosegresos":
                sql = "SELECT `IdRecibo`, Huella, `Firma` FROM `k_recibos_egresos_biometria` WHERE (`IdRecibo` ='" + xid + "' AND Estado=1);";
                xhuella = true;
                xfirma = true;
                break;
            case "Recibos":
                sql = "SELECT `IdRecibo`, Huella, `Firma` FROM `k_recibos_biometria` WHERE (`IdRecibo` ='" + xid + "' AND Estado=1);";
                xhuella = true;
                xfirma = true;
                break;
        }
        if (sql != null) {
            ResultSet xrs = this.xconsultas.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    if (xhuella && (Huella = xrs.getBlob("Huella")) != null) {
                        ImageIcon image = new ImageIcon(ImageIO.read(Huella.getBinaryStream()));
                        this.lblImagenHuella.setIcon(new ImageIcon(image.getImage().getScaledInstance(this.lblImagenHuella.getWidth(), this.lblImagenHuella.getHeight(), 1)));
                    }
                    if (xfoto && (Foto = xrs.getBlob("Foto")) != null) {
                        ImageIcon image2 = new ImageIcon(ImageIO.read(Foto.getBinaryStream()));
                        ImageIcon image3 = new ImageIcon(image2.getImage().getScaledInstance(320, 240, 1));
                        JLabel jLabel = this.JLFotografia;
                        JLabel jLabel2 = this.JLFotografia;
                        jLabel.setHorizontalAlignment(0);
                        JLabel jLabel3 = this.JLFotografia;
                        JLabel jLabel4 = this.JLFotografia;
                        jLabel3.setVerticalAlignment(0);
                        this.JLFotografia.setIcon(image3);
                        this.JTBCamara.setSelectedIndex(1);
                    }
                    if (xfirma && (Firma = xrs.getBlob("Firma")) != null) {
                        ImageIcon image4 = new ImageIcon(ImageIO.read(Firma.getBinaryStream()));
                        ImageIcon image5 = new ImageIcon(image4.getImage().getScaledInstance(this.JPPaint.getWidth(), this.JPPaint.getHeight(), 1));
                        JLabel jLabel5 = this.JLFirma;
                        JLabel jLabel6 = this.JLFirma;
                        jLabel5.setHorizontalAlignment(0);
                        JLabel jLabel7 = this.JLFirma;
                        JLabel jLabel8 = this.JLFirma;
                        jLabel7.setVerticalAlignment(0);
                        this.JLFirma.setIcon(image5);
                        this.JTBFirma.setSelectedIndex(1);
                    }
                    xexiste = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return xexiste;
    }

    private void mCapturarFirma() {
        RenderedImage rend = this.lienzo.getImage();
        try {
            ImageIO.write(rend, "png", new File("Firma.png"));
        } catch (Exception e) {
        }
    }
}
