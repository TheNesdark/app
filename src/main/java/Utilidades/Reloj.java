package Utilidades;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/* JADX INFO: loaded from: GenomaP.jar:Utilidades/Reloj.class */
public class Reloj extends JPanel implements ActionListener {
    private SimpleDateFormat sdfFecha;
    private Timer timer;
    private Thread runner;
    private JLabel[] lblNumero;
    private JLabel[] lblSeparador;
    private JLabel lblLogoHora;
    private JLabel lblFecha;
    private JPopupMenu popup;
    private JRadioButtonMenuItem rbLocal;
    private JRadioButtonMenuItem rbUTC;
    private ButtonGroup grpRBHORAS;
    private ImageIcon separador;
    private ImageIcon imgLogo_UTC;
    private ImageIcon imgLogo_HoraLocal;
    private ImageIcon[] imgNumeros;
    private int iHoraLocal;
    private int iMinutoLocal;
    private int iSegundoLocal;
    private int iDia;
    private int iMes;
    private int iAnno;
    private boolean booUTC;
    private Calendar cal;
    private TimeZone tz;

    static /* synthetic */ int access$308(Reloj x0) {
        int i = x0.iDia;
        x0.iDia = i + 1;
        return i;
    }

    public Reloj(boolean booUTC) {
        this(Calendar.getInstance().get(11), Calendar.getInstance().get(12), Calendar.getInstance().get(13), booUTC);
    }

    public Reloj(int iHoraLocal, int iMinutoLocal, int iSegundoLocal, boolean booUTC) {
        this.sdfFecha = new SimpleDateFormat("EEEE, dd MMMM yyyy");
        this.lblFecha = new JLabel();
        this.separador = new ImageIcon(getClass().getResource("/Imagenes/Reloj/separador.gif"));
        this.imgLogo_UTC = new ImageIcon(getClass().getResource("/Imagenes/Reloj/logo_hora_utc.gif"));
        this.imgLogo_HoraLocal = new ImageIcon(getClass().getResource("/Imagenes/Reloj/logo_hora_local.gif"));
        this.imgNumeros = new ImageIcon[]{new ImageIcon(getClass().getResource("/Imagenes/Reloj/0.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/1.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/2.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/3.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/4.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/5.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/6.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/7.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/8.gif")), new ImageIcon(getClass().getResource("/Imagenes/Reloj/9.gif"))};
        this.iHoraLocal = iHoraLocal;
        this.iMinutoLocal = iMinutoLocal;
        this.iSegundoLocal = iSegundoLocal;
        this.booUTC = booUTC;
        this.cal = Calendar.getInstance();
        this.tz = this.cal.getTimeZone();
        this.iAnno = this.cal.get(1);
        this.iMes = this.cal.get(2);
        this.iMes++;
        this.iDia = this.cal.get(5);
        this.lblLogoHora = new JLabel();
        if (booUTC) {
            this.lblLogoHora.setIcon(this.imgLogo_UTC);
        } else {
            this.lblLogoHora.setIcon(this.imgLogo_HoraLocal);
        }
        setLayout(new FlowLayout(2));
        this.lblNumero = new JLabel[6];
        this.lblSeparador = new JLabel[2];
        for (int i = 0; i < this.lblNumero.length; i++) {
            this.lblNumero[i] = new JLabel();
        }
        this.lblSeparador[0] = new JLabel(this.separador);
        this.lblSeparador[1] = new JLabel(this.separador);
        this.lblFecha.setForeground(new Color(152, 152, 200));
        if (this.iHoraLocal > 23) {
            setHora(0);
            this.iDia++;
        } else {
            setHora(this.iHoraLocal);
        }
        setMinuto(this.iMinutoLocal);
        setSegundo(this.iSegundoLocal);
        this.lblFecha.setText(getFechaFormatoLargo());
        CrearMenuPopup();
        addMouseListener(new MouseAdapter() { // from class: Utilidades.Reloj.1
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    Reloj.this.popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        add(this.lblNumero[0]);
        add(this.lblNumero[1]);
        add(this.lblSeparador[0]);
        add(this.lblNumero[2]);
        add(this.lblNumero[3]);
        add(this.lblSeparador[1]);
        add(this.lblNumero[4]);
        add(this.lblNumero[5]);
        add(this.lblLogoHora);
        add(this.lblFecha);
        this.timer = new Timer(1000, this);
        this.timer.start();
    }

    private void CrearMenuPopup() {
        this.popup = new JPopupMenu("Cambiar Vista Hora");
        this.rbLocal = new JRadioButtonMenuItem("HORA LOCAL");
        this.rbLocal.addItemListener(new ItemListener() { // from class: Utilidades.Reloj.2
            public void itemStateChanged(ItemEvent e) {
                Reloj.this.cal = Calendar.getInstance();
                Reloj reloj = Reloj.this;
                Calendar calendar = Reloj.this.cal;
                Calendar.getInstance();
                reloj.iHoraLocal = calendar.get(11);
                Reloj.this.iDia = Reloj.this.cal.get(5);
                Reloj.this.lblLogoHora.setIcon(Reloj.this.imgLogo_HoraLocal);
                Reloj.this.setHora(Reloj.this.iHoraLocal);
                Reloj.this.lblFecha.setText(Reloj.this.getFechaFormatoLargo());
            }
        });
        this.rbUTC = new JRadioButtonMenuItem("HORA UTC");
        this.rbUTC.addItemListener(new ItemListener() { // from class: Utilidades.Reloj.3
            public void itemStateChanged(ItemEvent e) {
                Reloj.this.cal = Calendar.getInstance();
                Reloj.this.AsignarNuevaHoraUTC();
                Reloj.this.lblLogoHora.setIcon(Reloj.this.imgLogo_UTC);
                if (Reloj.this.cal.get(11) + Math.abs(Reloj.this.getDiffHorasGMT()) > 23) {
                    Reloj.access$308(Reloj.this);
                }
                Reloj.this.setHora(Reloj.this.iHoraLocal);
                Reloj.this.lblFecha.setText(Reloj.this.getFechaFormatoLargo());
            }
        });
        if (this.booUTC) {
            this.rbUTC.setSelected(true);
        } else {
            this.rbLocal.setSelected(true);
        }
        this.grpRBHORAS = new ButtonGroup();
        this.grpRBHORAS.add(this.rbLocal);
        this.grpRBHORAS.add(this.rbUTC);
        this.popup.add(this.rbLocal);
        this.popup.add(this.rbUTC);
    }

    public String getFechaFormatoLargo() {
        DateFormat df = DateFormat.getDateInstance();
        Calendar calTemp = Calendar.getInstance();
        if (this.iDia > this.cal.getActualMaximum(5)) {
            this.iDia = 1;
            this.iMes++;
            if (this.iMes > 12) {
                this.iMes = 1;
                this.iAnno++;
            }
        }
        calTemp.set(this.iAnno, this.iMes - 1, this.iDia);
        String strFecha = df.format(calTemp.getTime());
        Date date = new Date();
        try {
            df.setLenient(true);
            date = df.parse(strFecha);
        } catch (ParseException parseEx) {
            System.out.println(parseEx.getMessage());
        }
        return this.sdfFecha.format(date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AsignarNuevaHoraUTC() {
        int iDiffHorasGMT = getDiffHorasGMT();
        if (iDiffHorasGMT < 0) {
            this.iHoraLocal += Math.abs(iDiffHorasGMT);
        } else {
            this.iHoraLocal -= iDiffHorasGMT;
        }
        if (this.iHoraLocal > 23) {
            this.iHoraLocal -= 24;
        }
    }

    public int getDiffHorasGMT() {
        int GMTmm = this.cal.get(15);
        int iHora = (GMTmm / 1000) / 3600;
        if (this.tz.inDaylightTime(this.cal.getTime())) {
            if (GMTmm < 0) {
                iHora += (this.tz.getDSTSavings() / 1000) / 3600;
            } else {
                iHora -= (this.tz.getDSTSavings() / 1000) / 3600;
            }
        }
        return iHora;
    }

    public void setHora(int iHora) {
        int iDecena = iHora / 10;
        int iUnidad = iHora % 10;
        this.lblNumero[0].setIcon(this.imgNumeros[iDecena]);
        this.lblNumero[1].setIcon(this.imgNumeros[iUnidad]);
    }

    public void setMinuto(int iMinuto) {
        int iDecena = iMinuto / 10;
        int iUnidad = iMinuto % 10;
        this.lblNumero[2].setIcon(this.imgNumeros[iDecena]);
        this.lblNumero[3].setIcon(this.imgNumeros[iUnidad]);
    }

    public void setSegundo(int iSegundo) {
        int iDecena = iSegundo / 10;
        int iUnidad = iSegundo % 10;
        this.lblNumero[4].setIcon(this.imgNumeros[iDecena]);
        this.lblNumero[5].setIcon(this.imgNumeros[iUnidad]);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
        if (Calendar.getInstance().get(13) > 0) {
            setSegundo(Calendar.getInstance().get(13));
        } else {
            setSegundo(0);
            if (this.iMinutoLocal < 59) {
                this.iMinutoLocal++;
                setMinuto(this.iMinutoLocal);
            } else {
                setMinuto(0);
                this.iMinutoLocal = 0;
                if (this.iHoraLocal < 23) {
                    this.iHoraLocal++;
                    setHora(this.iHoraLocal);
                } else {
                    setHora(0);
                    this.iHoraLocal = 0;
                    this.iDia++;
                    this.lblFecha.setText(getFechaFormatoLargo());
                }
            }
        }
        repaint();
    }
}
