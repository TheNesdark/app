package General;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/* JADX INFO: loaded from: GenomaP.jar:General/barraCargar.class */
public class barraCargar extends JFrame {
    Thread hilo;
    Object objeto = new Object();
    private String version = "v.1.0-20100409";
    int min = 0;
    int max = 100;
    private JProgressBar barra;
    private JLabel jLabel1;
    private JLabel jLabel4;
    private JLabel lblCargando;
    private JLabel lblVersion;

    public barraCargar(String msg) {
        initComponents();
        this.lblVersion.setText(this.version);
        this.lblCargando.setText("Cargando " + msg);
        iniciaCuenta();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.barra = new JProgressBar();
        this.lblVersion = new JLabel();
        this.lblCargando = new JLabel();
        this.jLabel4 = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("VOTASoft 1.0");
        setEnabled(false);
        setFocusable(false);
        setName("barraCargar");
        setUndecorated(true);
        getContentPane().setLayout((LayoutManager) null);
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/LogoGenoma1.jpg")));
        getContentPane().add(this.jLabel1);
        this.jLabel1.setBounds(10, 10, 190, 120);
        getContentPane().add(this.barra);
        this.barra.setBounds(10, 160, 190, 30);
        this.lblVersion.setForeground(new Color(0, 0, 204));
        this.lblVersion.setHorizontalAlignment(0);
        this.lblVersion.setText("v1.0-20100409");
        getContentPane().add(this.lblVersion);
        this.lblVersion.setBounds(30, 210, 140, 14);
        this.lblCargando.setHorizontalAlignment(2);
        this.lblCargando.setText("Cargando . . .");
        getContentPane().add(this.lblCargando);
        this.lblCargando.setBounds(10, 140, 190, 20);
        this.jLabel4.setForeground(new Color(0, 0, 204));
        this.jLabel4.setHorizontalAlignment(0);
        this.jLabel4.setText("G@noma Soft");
        getContentPane().add(this.jLabel4);
        this.jLabel4.setBounds(30, 190, 140, 14);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 212) / 2, (screenSize.height - 241) / 2, 212, 241);
    }

    public void iniciaCuenta() {
        if (this.hilo == null) {
            this.hilo = new ThreadCarga();
            this.hilo.start();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:General/barraCargar$ThreadCarga.class */
    class ThreadCarga extends Thread {
        ThreadCarga() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            barraCargar.this.barra.setValue(barraCargar.this.min);
            barraCargar.this.barra.setMinimum(barraCargar.this.min);
            barraCargar.this.barra.setMaximum(barraCargar.this.max);
            for (int i = barraCargar.this.min; i <= barraCargar.this.max; i++) {
                barraCargar.this.barra.setValue(i);
                synchronized (barraCargar.this.objeto) {
                    try {
                        barraCargar.this.objeto.wait(20L);
                    } catch (InterruptedException e) {
                    }
                }
                if (i == 100) {
                    barraCargar.this.dispose();
                }
            }
            barraCargar.this.hilo = null;
        }
    }
}
