package General;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.Wacom;
import com.WacomGSS.STU.STUException;
import com.WacomGSS.STU.TlsDevice;
import com.WacomGSS.STU.UsbDevice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.RenderedImage;
import java.io.BufferedInputStream;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:General/JDFirmas.class */
public class JDFirmas extends JDialog {
    private Persona xjppersona;
    PreparedStatement guardarStmt;
    boolean xtableta;
    private String xnombre;
    private String xid;
    private Metodos xmt;
    public Image image;
    boolean xvalidado;
    JPDibujo lienzo;
    Wacom signatureDialog;
    private ConsultasMySQL xconsultas;
    private JButton JBTSalir1;
    public JButton JBT_GrabarFirma;
    private JButton JBT_Limpiar;
    private JLabel JLFirma;
    private JPanel JPImageFirma;
    public JPanel JPPaint;
    private JTabbedPane JTBFirma;

    public JDFirmas(Frame parent, boolean modal, String xnombre, String xid) {
        super(parent, modal);
        this.xnombre = "";
        this.xid = "";
        this.xmt = new Metodos();
        this.xvalidado = false;
        this.lienzo = new JPDibujo();
        this.signatureDialog = null;
        this.xconsultas = new ConsultasMySQL();
        initComponents();
        this.xnombre = xnombre;
        this.xid = xid;
        setLocationRelativeTo(null);
        setTitle("MODULO DE FIRMAS");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mInicarWacom();
        try {
            consultarBD(this.xid);
        } catch (IOException ex) {
            Logger.getLogger(JDFirmas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mInicarWacom() {
        if (!this.xmt.mExisteArchivo("C:\\Windows\\System32\\wgssSTU.dll")) {
            this.xtableta = false;
            this.lienzo.setBounds(0, 0, 495, 283);
            this.JPPaint.add(this.lienzo);
            this.JBT_GrabarFirma.setVisible(true);
            this.JBT_Limpiar.setVisible(true);
            return;
        }
        try {
            UsbDevice[] usbDevices = UsbDevice.getUsbDevices();
            TlsDevice[] tlsDevices = TlsDevice.getTlsDevices();
            UsbDevice usbDevice = null;
            TlsDevice tlsDevice = null;
            if (usbDevices != null && usbDevices.length > 0) {
                usbDevice = usbDevices[0];
            }
            if (tlsDevices != null && tlsDevices.length > 0) {
                tlsDevice = tlsDevices[0];
            }
            if (usbDevice == null && tlsDevice == null) {
                this.lienzo.setBounds(0, 0, 500, 321);
                this.JPPaint.add(this.lienzo);
                this.JBT_GrabarFirma.setVisible(true);
                this.JBT_Limpiar.setVisible(true);
            } else {
                this.xtableta = true;
                this.signatureDialog = new Wacom(this, this.JPPaint, usbDevice, tlsDevice, false);
                this.signatureDialog.setVisible(false);
                this.JPPaint.setVisible(false);
                this.signatureDialog.setBounds(0, 0, 500, 308);
                this.JPPaint.add(this.signatureDialog);
                this.JPPaint.setVisible(true);
                this.signatureDialog.setVisible(true);
            }
        } catch (RuntimeException e) {
            this.xtableta = false;
            JOptionPane.showMessageDialog((Component) null, e, "Error (RT)", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        } catch (Exception e2) {
            this.xtableta = false;
            JOptionPane.showMessageDialog((Component) null, e2, "Error", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        } catch (STUException e3) {
            this.xtableta = false;
            JOptionPane.showMessageDialog((Component) null, e3, "Error (STU)", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    public void mGrabarFirma() {
        if (!this.xtableta) {
            RenderedImage rend = this.lienzo.getImage();
            try {
                ImageIO.write(rend, "png", new File("Firma.png"));
            } catch (Exception e) {
            }
        }
        try {
            try {
                try {
                    Connection c = this.xconsultas.establecerConexionBd();
                    File archivo = new File("Firma.png");
                    int l = (int) archivo.length();
                    InputStream is = new BufferedInputStream(new FileInputStream(archivo));
                    if (this.xnombre.equals("xIngreso")) {
                        if (consultarBD(this.xid)) {
                            this.guardarStmt = c.prepareStatement("UPDATE `ingreso_biometria` SET `Firma` = (?) WHERE `Id_Ingreso` = '" + this.xid + "'");
                            this.guardarStmt.setBinaryStream(1, is, l);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                        } else {
                            this.guardarStmt = c.prepareStatement("INSERT INTO `ingreso_biometria`(`Id_Ingreso`,`Firma`) VALUES (?,?);");
                            this.guardarStmt.setString(1, this.xid);
                            this.guardarStmt.setBinaryStream(2, is, l);
                            this.guardarStmt.execute();
                            this.guardarStmt.close();
                        }
                        this.xmt.mEliminarArchivo(archivo);
                        JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                    } else if (this.xnombre.equals("xjpconceptolaboral") || this.xnombre.equals("xjpconceptolaborale")) {
                        this.guardarStmt = c.prepareStatement("UPDATE `h_so_concepto_laboral` SET `Firma` = (?) WHERE `Id` = '" + this.xid + "'");
                        this.guardarStmt.setBinaryStream(1, is, l);
                        this.guardarStmt.execute();
                        this.guardarStmt.close();
                        this.xmt.mEliminarArchivo(archivo);
                        JOptionPane.showMessageDialog((Component) null, "Firma Guardada Correctamente");
                        consultarBD(this.xid);
                    }
                    this.xconsultas.cerrarConexionBd();
                    this.xconsultas.cerrarConexionBd();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    this.xconsultas.cerrarConexionBd();
                } catch (SQLException ex2) {
                    System.err.println(ex2);
                    this.xconsultas.cerrarConexionBd();
                }
            } catch (IOException ex3) {
                Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                this.xconsultas.cerrarConexionBd();
            }
        } catch (Throwable th) {
            this.xconsultas.cerrarConexionBd();
            throw th;
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
    public void mSalir() {
        if (this.xtableta) {
            try {
                this.signatureDialog.pressClearButton();
                this.signatureDialog.dispose();
            } catch (STUException e) {
                Logger.getLogger(JDBiometrico.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
        dispose();
    }

    public boolean consultarBD(String xid) throws IOException {
        String sql = null;
        boolean xexiste = false;
        if (this.xnombre.equals("xIngreso")) {
            sql = "SELECT `Id_Ingreso`, `Firma` FROM `ingreso_biometria` WHERE (`Id_Ingreso` ='" + xid + "');";
        } else if (this.xnombre.equals("xjpconceptolaboral") || this.xnombre.equals("xjpconceptolaborale")) {
            sql = "SELECT `Id`, `Firma` FROM `h_so_concepto_laboral` WHERE (`Id` ='" + xid + "');";
        }
        if (sql != null) {
            ResultSet xrs = this.xconsultas.traerRs(sql);
            try {
                if (xrs.next()) {
                    xrs.first();
                    Blob Firma = xrs.getBlob("Firma");
                    if (Firma != null) {
                        ImageIcon image = new ImageIcon(ImageIO.read(Firma.getBinaryStream()));
                        ImageIcon image2 = new ImageIcon(image.getImage().getScaledInstance(this.JPPaint.getWidth(), this.JPPaint.getHeight(), 1));
                        JLabel jLabel = this.JLFirma;
                        JLabel jLabel2 = this.JLFirma;
                        jLabel.setHorizontalAlignment(0);
                        JLabel jLabel3 = this.JLFirma;
                        JLabel jLabel4 = this.JLFirma;
                        jLabel3.setVerticalAlignment(0);
                        this.JLFirma.setIcon(image2);
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

    private void initComponents() {
        this.JBT_GrabarFirma = new JButton();
        this.JBTSalir1 = new JButton();
        this.JBT_Limpiar = new JButton();
        this.JTBFirma = new JTabbedPane();
        this.JPPaint = new JPanel();
        this.JPImageFirma = new JPanel();
        this.JLFirma = new JLabel();
        setDefaultCloseOperation(2);
        setPreferredSize(new Dimension(524, 469));
        setResizable(false);
        addWindowListener(new WindowAdapter() { // from class: General.JDFirmas.1
            public void windowClosing(WindowEvent evt) {
                JDFirmas.this.formWindowClosing(evt);
            }
        });
        this.JBT_GrabarFirma.setFont(new Font("Arial", 1, 12));
        this.JBT_GrabarFirma.setForeground(new Color(0, 0, 153));
        this.JBT_GrabarFirma.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_GrabarFirma.setText("Grabar");
        this.JBT_GrabarFirma.addActionListener(new ActionListener() { // from class: General.JDFirmas.2
            public void actionPerformed(ActionEvent evt) {
                JDFirmas.this.JBT_GrabarFirmaActionPerformed(evt);
            }
        });
        this.JBTSalir1.setFont(new Font("Arial", 1, 12));
        this.JBTSalir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir1.setText("Salir");
        this.JBTSalir1.addActionListener(new ActionListener() { // from class: General.JDFirmas.3
            public void actionPerformed(ActionEvent evt) {
                JDFirmas.this.JBTSalir1ActionPerformed(evt);
            }
        });
        this.JBT_Limpiar.setFont(new Font("Arial", 1, 12));
        this.JBT_Limpiar.setForeground(new Color(0, 0, 153));
        this.JBT_Limpiar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBT_Limpiar.setText("Limpiar");
        this.JBT_Limpiar.addActionListener(new ActionListener() { // from class: General.JDFirmas.4
            public void actionPerformed(ActionEvent evt) {
                JDFirmas.this.JBT_LimpiarActionPerformed(evt);
            }
        });
        this.JTBFirma.setForeground(new Color(0, 103, 0));
        this.JTBFirma.setFont(new Font("Arial", 1, 14));
        this.JTBFirma.setPreferredSize(new Dimension(495, 283));
        this.JPPaint.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JPPaint.setName("neno");
        GroupLayout JPPaintLayout = new GroupLayout(this.JPPaint);
        this.JPPaint.setLayout(JPPaintLayout);
        JPPaintLayout.setHorizontalGroup(JPPaintLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 493, 32767));
        JPPaintLayout.setVerticalGroup(JPPaintLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 288, 32767));
        this.JTBFirma.addTab("CAPTURA DE FIRMA", this.JPPaint);
        GroupLayout JPImageFirmaLayout = new GroupLayout(this.JPImageFirma);
        this.JPImageFirma.setLayout(JPImageFirmaLayout);
        JPImageFirmaLayout.setHorizontalGroup(JPImageFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLFirma, GroupLayout.Alignment.TRAILING, -1, 495, 32767));
        JPImageFirmaLayout.setVerticalGroup(JPImageFirmaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLFirma, GroupLayout.Alignment.TRAILING, -1, 290, 32767));
        this.JTBFirma.addTab("IMAGEN", this.JPImageFirma);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTBFirma, -2, 500, -2).addComponent(this.JBTSalir1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBT_GrabarFirma, -2, 142, -2).addGap(215, 215, 215).addComponent(this.JBT_Limpiar, -2, 143, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTBFirma, -2, 321, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JBT_GrabarFirma, -2, 53, -2)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Limpiar, -2, 54, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTSalir1, -2, 50, -2).addGap(10, 10, 10)));
        this.JBT_GrabarFirma.setVisible(false);
        this.JBT_Limpiar.setVisible(false);
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarFirmaActionPerformed(ActionEvent evt) {
        mGrabarFirma();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalir1ActionPerformed(ActionEvent evt) {
        mSalir();
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
    public void formWindowClosing(WindowEvent evt) {
        mSalir();
    }
}
