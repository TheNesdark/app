package Utilidades;

import General.JDBiometrico;
import General.JDFirmas;
import com.WacomGSS.STU.ITabletHandler;
import com.WacomGSS.STU.Protocol.Capability;
import com.WacomGSS.STU.Protocol.DevicePublicKey;
import com.WacomGSS.STU.Protocol.EncodingMode;
import com.WacomGSS.STU.Protocol.EncryptionStatus;
import com.WacomGSS.STU.Protocol.EventDataKeyPad;
import com.WacomGSS.STU.Protocol.EventDataKeyPadEncrypted;
import com.WacomGSS.STU.Protocol.EventDataPinPad;
import com.WacomGSS.STU.Protocol.EventDataPinPadEncrypted;
import com.WacomGSS.STU.Protocol.EventDataSignature;
import com.WacomGSS.STU.Protocol.EventDataSignatureEncrypted;
import com.WacomGSS.STU.Protocol.Information;
import com.WacomGSS.STU.Protocol.InkingMode;
import com.WacomGSS.STU.Protocol.OperationMode;
import com.WacomGSS.STU.Protocol.OperationMode_Signature;
import com.WacomGSS.STU.Protocol.PenData;
import com.WacomGSS.STU.Protocol.PenDataEncrypted;
import com.WacomGSS.STU.Protocol.PenDataEncryptedOption;
import com.WacomGSS.STU.Protocol.PenDataOption;
import com.WacomGSS.STU.Protocol.PenDataTimeCountSequence;
import com.WacomGSS.STU.Protocol.PenDataTimeCountSequenceEncrypted;
import com.WacomGSS.STU.Protocol.ProtocolHelper;
import com.WacomGSS.STU.Protocol.RomImageHash;
import com.WacomGSS.STU.Protocol.RomStartImageData;
import com.WacomGSS.STU.STUException;
import com.WacomGSS.STU.Tablet;
import com.WacomGSS.STU.TlsDevice;
import com.WacomGSS.STU.UsbDevice;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Wacom.class */
public class Wacom extends JPanel implements ITabletHandler {
    private Tablet tablet;
    private Capability capability;
    private Information information;
    private JDBiometrico xJDBiometrico;
    private JDFirmas xJDFirmas;
    private int Count = 0;
    private int isDown;
    private List<PenData> penData;
    private Button[] btns;
    public JPanel panel;
    private boolean useSigMode;
    private BufferedImage bitmap;
    private EncodingMode encodingMode;
    private byte[] bitmapData;
    private boolean encrypted;
    private static final byte sigScreenImageNum = 2;

    static /* synthetic */ int access$508(Wacom x0) {
        int i = x0.Count;
        x0.Count = i + 1;
        return i;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Utilidades/Wacom$Button.class */
    private static class Button {
        Rectangle bounds;
        String text;
        ActionListener click;

        private Button() {
        }

        void performClick() {
            this.click.actionPerformed((ActionEvent) null);
        }
    }

    private Point2D.Float tabletToClient(PenData penData) {
        return new Point2D.Float((penData.getX() * this.panel.getWidth()) / this.capability.getTabletMaxX(), (penData.getY() * this.panel.getHeight()) / this.capability.getTabletMaxY());
    }

    private Point2D.Float tabletToScreen(PenData penData) {
        return new Point2D.Float((penData.getX() * this.capability.getScreenWidth()) / this.capability.getTabletMaxX(), (penData.getY() * this.capability.getScreenHeight()) / this.capability.getTabletMaxY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point clientToScreen(Point pt) {
        return new Point(Math.round((((float) pt.getX()) * this.capability.getScreenWidth()) / this.panel.getWidth()), Math.round((((float) pt.getY()) * this.capability.getScreenHeight()) / this.panel.getHeight()));
    }

    private void pressOkButton() throws STUException {
        setVisible(false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
    public void pressClearButton() throws STUException {
        clearScreen();
    }

    private void pressCancelButton() throws STUException {
        setVisible(false);
        this.penData = null;
    }

    public void PrintImage() throws STUException {
        RenderedImage rend = getImage();
        try {
            ImageIO.write(rend, "png", new File("Firma.png"));
        } catch (IOException e) {
        }
    }

    public RenderedImage getImage() {
        int width = getWidth();
        int height = getHeight();
        BufferedImage backingImage = new BufferedImage(width, height, 1);
        Graphics2D graphics2DCreateGraphics = backingImage.createGraphics();
        graphics2DCreateGraphics.setColor(Color.white);
        graphics2DCreateGraphics.fillRect(0, 0, width, height);
        drawInk(graphics2DCreateGraphics);
        graphics2DCreateGraphics.dispose();
        return backingImage;
    }

    private void clearScreen() throws STUException {
        if (!this.useSigMode) {
            this.tablet.writeImage(this.encodingMode, this.bitmapData);
        }
        this.penData.clear();
        this.isDown = 0;
        this.panel.repaint();
    }

    public void dispose() {
        if (this.tablet != null) {
            try {
                this.tablet.setInkingMode(InkingMode.Off);
                if (this.encrypted) {
                    this.tablet.endCapture();
                    this.encrypted = false;
                }
                this.tablet.setOperationMode(OperationMode.initializeNormal());
                this.tablet.setClearScreen();
            } catch (Throwable th) {
            }
            this.tablet.disconnect();
            this.tablet = null;
        }
    }

    private void drawCenteredString(Graphics2D gfx, String text, int x, int y, int width, int height) {
        FontMetrics fm = gfx.getFontMetrics(gfx.getFont());
        int textHeight = fm.getHeight();
        int textWidth = fm.stringWidth(text);
        int textX = x + ((width - textWidth) / sigScreenImageNum);
        int textY = y + ((height - textHeight) / sigScreenImageNum) + fm.getAscent();
        gfx.drawString(text, textX, textY);
    }

    private void drawInk(Graphics2D gfx, PenData pd0, PenData pd1) {
        gfx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gfx.setColor(new Color(0, 0, 64, 255));
        gfx.setStroke(new BasicStroke(3.0f, 1, 1));
        Point2D.Float pt0 = tabletToClient(pd0);
        Point2D.Float pt1 = tabletToClient(pd1);
        gfx.draw(new Line2D.Float(pt0, pt1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawInk(Graphics2D gfx) {
        PenData[] pd = (PenData[]) this.penData.toArray(new PenData[0]);
        for (int i = 1; i < pd.length; i++) {
            if (pd[i - 1].getSw() != 0 && pd[i].getSw() != 0) {
                drawInk(gfx, pd[i - 1], pd[i]);
            }
        }
    }

    public JPanel panel() {
        this.panel = new JPanel() { // from class: Utilidades.Wacom.1
            public void paintComponent(Graphics gfx) {
                super.paintComponent(gfx);
                if (Wacom.this.bitmap != null) {
                    Image rescaled = Wacom.this.bitmap.getScaledInstance(Wacom.this.panel.getWidth(), Wacom.this.panel.getHeight(), 4);
                    gfx.drawImage(rescaled, 0, 0, (ImageObserver) null);
                    Wacom.this.drawInk((Graphics2D) gfx);
                }
            }
        };
        return this.panel;
    }

    public Wacom(final JDBiometrico xJDBiometrico, JPanel frame, UsbDevice usbDevice, TlsDevice tlsDevice, boolean useSigMode) throws STUException {
        int e;
        this.encrypted = false;
        System.out.println("Entro a la Clase Wacom");
        this.xJDBiometrico = xJDBiometrico;
        setLocation(new Point(0, 0));
        panel();
        frame.add(this.panel);
        frame.repaint();
        this.panel.addMouseListener(new MouseAdapter() { // from class: Utilidades.Wacom.2
            public void mouseClicked(MouseEvent e2) {
                Point pt = Wacom.this.clientToScreen(e2.getPoint());
                for (Button btn : Wacom.this.btns) {
                    if (btn.bounds.contains(pt)) {
                        btn.performClick();
                        return;
                    }
                }
            }
        });
        this.penData = new ArrayList();
        try {
            this.tablet = new Tablet();
            if (usbDevice != null) {
                e = this.tablet.usbConnect(usbDevice, true);
            } else {
                e = this.tablet.tlsConnect(tlsDevice);
            }
            if (e == 0) {
                this.capability = this.tablet.getCapability();
                this.information = this.tablet.getInformation();
                if (useSigMode && !this.tablet.isSupported((byte) -109)) {
                    JOptionPane.showMessageDialog(this, this.information.getModelName() + " does not support Signature Mode operation, reverting to normal operation", "Warning", sigScreenImageNum);
                    useSigMode = false;
                }
                this.useSigMode = useSigMode;
                int screenResolution = getToolkit().getScreenResolution();
                Dimension d = new Dimension((this.capability.getTabletMaxX() * screenResolution) / 2540, (this.capability.getTabletMaxY() * screenResolution) / 2540);
                this.panel.setPreferredSize(d);
                setLayout(new BorderLayout());
                add(this.panel);
                this.btns = new Button[sigScreenImageNum];
                this.btns[0] = new Button();
                this.btns[1] = new Button();
                if (useSigMode) {
                    this.btns[0].bounds = new Rectangle(266, 431, 265, 48);
                    this.btns[1].bounds = new Rectangle(532, 431, 265, 48);
                } else if (this.tablet.getProductId() != 162) {
                    int w2 = this.capability.getScreenWidth() / 3;
                    int w3 = this.capability.getScreenWidth() / 3;
                    int w1 = (this.capability.getScreenWidth() - w2) - w3;
                    int y = (this.capability.getScreenHeight() * 6) / 7;
                    int h = this.capability.getScreenHeight() - y;
                    this.btns[0].bounds = new Rectangle(0, y, w1, h);
                    this.btns[1].bounds = new Rectangle(w1 + w2, y, w3, h);
                } else {
                    int x = (this.capability.getScreenWidth() * 3) / 4;
                    int w = this.capability.getScreenWidth() - x;
                    int h2 = this.capability.getScreenHeight() / 3;
                    int h3 = this.capability.getScreenHeight() / 3;
                    int h1 = (this.capability.getScreenHeight() - h2) - h3;
                    this.btns[0].bounds = new Rectangle(x, 0, w, h1);
                    this.btns[1].bounds = new Rectangle(x, h1, w, h2);
                }
                this.btns[0].text = "GRABAR ֍";
                this.btns[0].click = new ActionListener() { // from class: Utilidades.Wacom.3
                    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            Wacom.access$508(Wacom.this);
                            if (Wacom.this.Count == 1) {
                                Wacom.this.PrintImage();
                                if (xJDBiometrico != null) {
                                    xJDBiometrico.mGrabarFirma();
                                }
                                Wacom.this.Count = 0;
                            }
                        } catch (STUException e2) {
                        }
                    }
                };
                this.btns[1].text = "LIMPIAR ▒";
                this.btns[1].click = new ActionListener() { // from class: Utilidades.Wacom.4
                    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            Wacom.this.pressClearButton();
                        } catch (STUException e2) {
                        }
                    }
                };
                byte encodingFlag = ProtocolHelper.simulateEncodingFlag(this.tablet.getProductId(), this.capability.getEncodingFlag());
                if ((encodingFlag & 8) != 0) {
                    this.encodingMode = this.tablet.supportsWrite() ? EncodingMode.EncodingMode_24bit_Bulk : EncodingMode.EncodingMode_24bit;
                } else if ((encodingFlag & 4) != 0) {
                    this.encodingMode = this.tablet.supportsWrite() ? EncodingMode.EncodingMode_16bit_Bulk : EncodingMode.EncodingMode_16bit;
                } else {
                    this.encodingMode = EncodingMode.EncodingMode_1bit;
                }
                if (useSigMode && !initializeSigMode()) {
                    JOptionPane.showMessageDialog(this, "Exception initializing Signature Mode, reverting to normal operation", "Error", 0);
                    useSigMode = false;
                }
                if (!useSigMode) {
                    Color btnColor = this.encodingMode == EncodingMode.EncodingMode_1bit ? Color.WHITE : Color.LIGHT_GRAY;
                    this.bitmap = createScreenImage(new Color[]{btnColor, btnColor, btnColor}, Color.BLACK, null);
                    this.bitmapData = ProtocolHelper.flatten(this.bitmap, this.bitmap.getWidth(), this.bitmap.getHeight(), this.encodingMode);
                }
                if (this.encodingMode != EncodingMode.EncodingMode_1bit || 0 != 0) {
                }
                this.tablet.addTabletHandler(this);
                clearScreen();
                if (ProtocolHelper.supportsEncryption(this.tablet.getProtocol())) {
                    this.tablet.startCapture(12648430);
                    this.encrypted = true;
                }
                this.tablet.setInkingMode(InkingMode.On);
                return;
            }
            throw new RuntimeException("Failed to connect to USB tablet, error " + e);
        } catch (Throwable t) {
            if (this.tablet != null) {
                this.tablet.disconnect();
                this.tablet = null;
            }
            throw t;
        }
    }

    public Wacom(final JDFirmas xJDFirmas, JPanel frame, UsbDevice usbDevice, TlsDevice tlsDevice, boolean useSigMode) throws STUException {
        int e;
        this.encrypted = false;
        System.out.println("Entro a la Clase Wacom");
        this.xJDFirmas = xJDFirmas;
        setLocation(new Point(0, 0));
        panel();
        frame.add(this.panel);
        frame.repaint();
        this.panel.addMouseListener(new MouseAdapter() { // from class: Utilidades.Wacom.5
            public void mouseClicked(MouseEvent e2) {
                Point pt = Wacom.this.clientToScreen(e2.getPoint());
                for (Button btn : Wacom.this.btns) {
                    if (btn.bounds.contains(pt)) {
                        btn.performClick();
                        return;
                    }
                }
            }
        });
        this.penData = new ArrayList();
        try {
            this.tablet = new Tablet();
            if (usbDevice != null) {
                e = this.tablet.usbConnect(usbDevice, true);
            } else {
                e = this.tablet.tlsConnect(tlsDevice);
            }
            if (e == 0) {
                this.capability = this.tablet.getCapability();
                this.information = this.tablet.getInformation();
                if (useSigMode && !this.tablet.isSupported((byte) -109)) {
                    JOptionPane.showMessageDialog(this, this.information.getModelName() + " does not support Signature Mode operation, reverting to normal operation", "Warning", sigScreenImageNum);
                    useSigMode = false;
                }
                this.useSigMode = useSigMode;
                int screenResolution = getToolkit().getScreenResolution();
                Dimension d = new Dimension((this.capability.getTabletMaxX() * screenResolution) / 2540, (this.capability.getTabletMaxY() * screenResolution) / 2540);
                this.panel.setPreferredSize(d);
                setLayout(new BorderLayout());
                add(this.panel);
                this.btns = new Button[sigScreenImageNum];
                this.btns[0] = new Button();
                this.btns[1] = new Button();
                if (useSigMode) {
                    this.btns[0].bounds = new Rectangle(266, 431, 265, 48);
                    this.btns[1].bounds = new Rectangle(532, 431, 265, 48);
                } else if (this.tablet.getProductId() != 162) {
                    int w2 = this.capability.getScreenWidth() / 3;
                    int w3 = this.capability.getScreenWidth() / 3;
                    int w1 = (this.capability.getScreenWidth() - w2) - w3;
                    int y = (this.capability.getScreenHeight() * 6) / 7;
                    int h = this.capability.getScreenHeight() - y;
                    this.btns[0].bounds = new Rectangle(0, y, w1, h);
                    this.btns[1].bounds = new Rectangle(w1 + w2, y, w3, h);
                } else {
                    int x = (this.capability.getScreenWidth() * 3) / 4;
                    int w = this.capability.getScreenWidth() - x;
                    int h2 = this.capability.getScreenHeight() / 3;
                    int h3 = this.capability.getScreenHeight() / 3;
                    int h1 = (this.capability.getScreenHeight() - h2) - h3;
                    this.btns[0].bounds = new Rectangle(x, 0, w, h1);
                    this.btns[1].bounds = new Rectangle(x, h1, w, h2);
                }
                this.btns[0].text = "GRABAR ֍";
                this.btns[0].click = new ActionListener() { // from class: Utilidades.Wacom.6
                    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            Wacom.access$508(Wacom.this);
                            if (Wacom.this.Count == 1) {
                                Wacom.this.PrintImage();
                                if (xJDFirmas != null) {
                                    xJDFirmas.mGrabarFirma();
                                }
                                Wacom.this.Count = 0;
                            }
                        } catch (STUException e2) {
                        }
                    }
                };
                this.btns[1].text = "LIMPIAR ▒";
                this.btns[1].click = new ActionListener() { // from class: Utilidades.Wacom.7
                    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            Wacom.this.pressClearButton();
                        } catch (STUException e2) {
                        }
                    }
                };
                byte encodingFlag = ProtocolHelper.simulateEncodingFlag(this.tablet.getProductId(), this.capability.getEncodingFlag());
                if ((encodingFlag & 8) != 0) {
                    this.encodingMode = this.tablet.supportsWrite() ? EncodingMode.EncodingMode_24bit_Bulk : EncodingMode.EncodingMode_24bit;
                } else if ((encodingFlag & 4) != 0) {
                    this.encodingMode = this.tablet.supportsWrite() ? EncodingMode.EncodingMode_16bit_Bulk : EncodingMode.EncodingMode_16bit;
                } else {
                    this.encodingMode = EncodingMode.EncodingMode_1bit;
                }
                if (useSigMode && !initializeSigMode()) {
                    JOptionPane.showMessageDialog(this, "Exception initializing Signature Mode, reverting to normal operation", "Error", 0);
                    useSigMode = false;
                }
                if (!useSigMode) {
                    Color btnColor = this.encodingMode == EncodingMode.EncodingMode_1bit ? Color.WHITE : Color.LIGHT_GRAY;
                    this.bitmap = createScreenImage(new Color[]{btnColor, btnColor, btnColor}, Color.BLACK, null);
                    this.bitmapData = ProtocolHelper.flatten(this.bitmap, this.bitmap.getWidth(), this.bitmap.getHeight(), this.encodingMode);
                }
                if (this.encodingMode != EncodingMode.EncodingMode_1bit || 0 != 0) {
                }
                this.tablet.addTabletHandler(this);
                clearScreen();
                if (ProtocolHelper.supportsEncryption(this.tablet.getProtocol())) {
                    this.tablet.startCapture(12648430);
                    this.encrypted = true;
                }
                this.tablet.setInkingMode(InkingMode.On);
                return;
            }
            throw new RuntimeException("Failed to connect to USB tablet, error " + e);
        } catch (Throwable t) {
            if (this.tablet != null) {
                this.tablet.disconnect();
                this.tablet = null;
            }
            throw t;
        }
    }

    public void onGetReportException(STUException e) {
        JOptionPane.showMessageDialog(this, "Error:" + e, "Error (onGetReportException)", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.tablet.disconnect();
        this.tablet = null;
        this.penData = null;
        setVisible(false);
    }

    public void onUnhandledReportData(byte[] data) {
    }

    public void onPenData(PenData penData) {
        Point2D.Float floatTabletToScreen = tabletToScreen(penData);
        int btn = 0;
        int i = 0;
        while (true) {
            if (i >= this.btns.length) {
                break;
            }
            if (!this.btns[i].bounds.contains(floatTabletToScreen)) {
                i++;
            } else {
                btn = i + 1;
                break;
            }
        }
        boolean isDown = penData.getSw() != 0;
        if (isDown) {
            if (this.isDown == 0) {
                if (btn > 0) {
                    this.isDown = btn;
                } else {
                    this.isDown = -1;
                }
            } else if (!this.penData.isEmpty() && this.isDown == -1) {
                Graphics2D gfx = (Graphics2D) this.panel.getGraphics();
                drawInk(gfx, this.penData.get(this.penData.size() - 1), penData);
                gfx.dispose();
            }
            if (this.isDown == -1) {
                this.penData.add(penData);
                return;
            }
            return;
        }
        if (this.isDown != 0) {
            if (btn > 0 && btn == this.isDown && !this.useSigMode) {
                this.btns[btn - 1].performClick();
            }
            this.isDown = 0;
        }
        if (!this.penData.isEmpty()) {
            this.penData.add(penData);
        }
    }

    public void onPenDataOption(PenDataOption penDataOption) {
        onPenData(penDataOption);
    }

    public void onPenDataEncrypted(PenDataEncrypted penDataEncrypted) {
        onPenData(penDataEncrypted.getPenData1());
        onPenData(penDataEncrypted.getPenData2());
    }

    public void onPenDataEncryptedOption(PenDataEncryptedOption penDataEncryptedOption) {
        onPenData(penDataEncryptedOption.getPenDataOption1());
        onPenData(penDataEncryptedOption.getPenDataOption2());
    }

    public void onPenDataTimeCountSequence(PenDataTimeCountSequence penDataTimeCountSequence) {
        onPenData(penDataTimeCountSequence);
    }

    public void onPenDataTimeCountSequenceEncrypted(PenDataTimeCountSequenceEncrypted penDataTimeCountSequenceEncrypted) {
        onPenData(penDataTimeCountSequenceEncrypted);
    }

    public void onEncryptionStatus(EncryptionStatus encryptionStatus) {
    }

    public void onDevicePublicKey(DevicePublicKey devicePublicKey) {
    }

    public void onEventDataPinPad(EventDataPinPad eventData) {
    }

    public void onEventDataKeyPad(EventDataKeyPad eventData) {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
    public void onEventDataSignature(EventDataSignature eventData) throws STUException {
        onSignatureEvent(eventData.getKeyValue());
    }

    public void onEventDataPinPadEncrypted(EventDataPinPadEncrypted eventData) {
    }

    public void onEventDataKeyPadEncrypted(EventDataKeyPadEncrypted eventData) {
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
    public void onEventDataSignatureEncrypted(EventDataSignatureEncrypted eventData) throws STUException {
        onSignatureEvent(eventData.getKeyValue());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
    private void onSignatureEvent(byte keyValue) throws STUException {
        try {
            switch (keyValue) {
                case 0:
                    pressCancelButton();
                    break;
                case 1:
                    pressOkButton();
                    break;
                case sigScreenImageNum /* 2 */:
                    pressClearButton();
                    break;
            }
        } catch (Exception e) {
        }
    }

    public PenData[] getPenData() {
        if (this.penData != null) {
            PenData[] arrayPenData = new PenData[0];
            return (PenData[]) this.penData.toArray(arrayPenData);
        }
        return null;
    }

    public Information getInformation() {
        if (this.penData != null) {
            return this.information;
        }
        return null;
    }

    public Capability getCapability() {
        if (this.penData != null) {
            return this.capability;
        }
        return null;
    }

    private void checkSigModeImage(boolean pushed, byte[] imageData) throws STUException, NoSuchAlgorithmException {
        boolean[] sigKeyEnabled = {true, true, true};
        RomStartImageData romStartImageData = RomStartImageData.initializeSignature(this.encodingMode, pushed, (byte) 2, sigKeyEnabled);
        this.tablet.setRomImageHash((byte) 4, pushed, (byte) 2);
        RomImageHash romImgHash = this.tablet.getRomImageHash();
        boolean writeImage = true;
        if (romImgHash.getResult() == 0) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(imageData);
            if (Arrays.equals(hash, romImgHash.getHash())) {
                writeImage = false;
            }
        }
        if (writeImage) {
            this.tablet.writeRomImage(romStartImageData, imageData);
        }
    }

    private BufferedImage createScreenImage(Color[] colorArr, Color color, byte[] bArr) {
        BufferedImage bufferedImage = new BufferedImage(this.capability.getScreenWidth(), this.capability.getScreenHeight(), 1);
        Graphics2D graphics2DCreateGraphics = bufferedImage.createGraphics();
        graphics2DCreateGraphics.setColor(Color.WHITE);
        graphics2DCreateGraphics.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
        graphics2DCreateGraphics.setFont(new Font("Arial", 0, (int) (this.btns[0].bounds.getHeight() / 2.0d)));
        for (int i = 0; i < this.btns.length; i++) {
            Button button = this.btns[i];
            Rectangle rectangle = this.btns[bArr == null ? i : bArr[i]].bounds;
            if (this.encodingMode != EncodingMode.EncodingMode_1bit) {
                graphics2DCreateGraphics.setColor(colorArr[i]);
                graphics2DCreateGraphics.fillRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
            }
            graphics2DCreateGraphics.setColor(color);
            graphics2DCreateGraphics.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
            drawCenteredString(graphics2DCreateGraphics, button.text, (int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        }
        graphics2DCreateGraphics.dispose();
        return bufferedImage;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.WacomGSS.STU.STUException */
    private boolean initializeSigMode() throws STUException {
        try {
            byte[] btnOrder = {sigScreenImageNum, 0, 1};
            Color[] btnsUpColors = {new Color(0, 96, 255), Color.RED, Color.GREEN.darker()};
            Color[] btnsDownColors = {btnsUpColors[0].darker(), btnsUpColors[1].darker(), btnsUpColors[sigScreenImageNum].darker()};
            BufferedImage btnsUp = createScreenImage(btnsUpColors, Color.BLACK, btnOrder);
            byte[] bitmapData = ProtocolHelper.flatten(btnsUp, btnsUp.getWidth(), btnsUp.getHeight(), this.encodingMode);
            checkSigModeImage(false, bitmapData);
            BufferedImage btnsPushed = createScreenImage(btnsDownColors, Color.WHITE, btnOrder);
            byte[] bitmapData2 = ProtocolHelper.flatten(btnsPushed, btnsPushed.getWidth(), btnsPushed.getHeight(), this.encodingMode);
            checkSigModeImage(true, bitmapData2);
            OperationMode_Signature sigMode = new OperationMode_Signature((byte) 2, btnOrder, (byte) 0, (byte) 0);
            this.tablet.setOperationMode(OperationMode.initializeSignature(sigMode));
            this.bitmap = createScreenImage(btnsUpColors, Color.BLACK, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
