package Utilidades;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDiscoveryEvent;
import com.github.sarxos.webcam.WebcamDiscoveryListener;
import com.github.sarxos.webcam.WebcamDiscoveryService;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamPicker;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/WebCam.class */
public class WebCam extends JPanel implements Runnable, WebcamListener, WindowListener, Thread.UncaughtExceptionHandler, ItemListener, WebcamDiscoveryListener {
    private static final long serialVersionUID = 1;
    public Webcam webcam = null;
    public WebcamPanel panel = null;
    public WebcamPicker picker = null;
    public WebcamDiscoveryService discovery = Webcam.getDiscoveryService();
    private JButton boton = new JButton("Tomar Foto");
    private Metodos xmt = new Metodos();
    int RX;
    int RY;

    public WebCam(int x, int y) {
        this.RX = x;
        this.RY = y;
        run();
    }

    public void CapturaFoto() {
        if (this.webcam != null) {
            BufferedImage image = this.webcam.getImage();
            try {
                ImageIO.write(image, "JPG", new File("Foto.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(WebCam.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Webcam.addDiscoveryListener(this);
            AWTEventMonitor.addWindowListener(this);
            List<Webcam> webcams = Webcam.getWebcams();
            if (webcams.isEmpty()) {
                System.out.println("No webcams found...");
                return;
            }
            this.picker = new WebcamPicker();
            this.picker.addItemListener(this);
            this.webcam = this.picker.getSelectedWebcam();
            if (this.webcam == null) {
                System.out.println("No webcams selected...");
                return;
            }
            this.webcam.setViewSize(new Dimension(this.RX, this.RY));
            this.webcam.addWebcamListener(this);
            this.panel = new WebcamPanel(this.webcam, false);
            this.panel.setFPSDisplayed(true);
            add(this.picker, "North");
            add(this.panel, "Center");
            setVisible(true);
            Thread t = new Thread(() -> {
                try {
                    this.panel.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t.setName("example-starter");
            t.setDaemon(true);
            t.setUncaughtExceptionHandler(this);
            t.start();
        } catch (Exception e) {
            System.err.println("Error initializing webcam: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void webcamOpen(WebcamEvent we) {
    }

    public void webcamClosed(WebcamEvent we) {
    }

    public void webcamDisposed(WebcamEvent we) {
        System.out.println("webcam disposed");
    }

    public void webcamImageObtained(WebcamEvent we) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
        this.webcam.close();
    }

    public void windowClosing(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
        System.out.println("webcam viewer resumed");
        this.panel.resume();
    }

    public void windowIconified(WindowEvent e) {
        System.out.println("webcam viewer paused");
        this.panel.pause();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        System.err.println(String.format("Exception in thread %s", t.getName()));
        e.printStackTrace();
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getItem() != this.webcam && this.webcam != null) {
            this.panel.stop();
            remove(this.panel);
            this.webcam.removeWebcamListener(this);
            this.webcam.close();
            this.webcam = (Webcam) e.getItem();
            this.webcam.setViewSize(new Dimension(320, 240));
            this.webcam.addWebcamListener(this);
            System.out.println("selected " + this.webcam.getName());
            this.panel = new WebcamPanel(this.webcam, false);
            this.panel.setFPSDisplayed(true);
            add(this.panel, "Center");
            Thread t = new Thread() { // from class: Utilidades.WebCam.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    WebCam.this.panel.start();
                }
            };
            t.setName("example-stoper");
            t.setDaemon(true);
            t.setUncaughtExceptionHandler(this);
            t.start();
        }
    }

    public void webcamFound(WebcamDiscoveryEvent event) {
        if (this.picker != null) {
            this.picker.addItem(event.getWebcam());
        }
    }

    public void webcamGone(WebcamDiscoveryEvent event) {
        if (this.picker != null) {
            this.picker.removeItem(event.getWebcam());
        }
    }
}
