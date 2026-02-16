package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPFramingham_M.class */
public class JPFramingham_M extends JPanel {
    private String xPaso1;
    private String xPaso2;
    private String xPaso3;
    private String xPaso4;
    private String xPaso5;
    private String xPaso6;
    private int xResultado;
    private int xCalculoEdadCoresterol;
    private int xResultado2;
    private int xCalculoEdadFumador;
    private int xCalculoEdadNoFumador;
    private int xCalculoHDL;
    private int xCalculoRiesgo;
    private int xCalculoPresion;
    private long xEstadoHC;
    private String xidTest;
    public DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xPorcentaje;
    private String xedad;
    private String valorEdad;
    private String xValorHdl;
    private String xRiesgoCardio;
    private String xResultadoColesterol;
    private String xResultadoFumador;
    private String totalPuntaje;
    private String xResultadoPresion;
    private String xRangoEdad;
    private String xRangoRiesgo;
    private String xRangoColesterol;
    private String xRangoHdl;
    private String xPuntajeHdl;
    private String xPuntajeColesterol;
    private String xPuntajePresion;
    private String xRangoPresion;
    private ByteArrayOutputStream baos;
    private long xGrafica;
    private JLabel JLBEdad;
    private JLabel JLBEdadCoresterol;
    private JLabel JLBEdadCoresterol1;
    private JLabel JLBEdadCoresterol2;
    private JLabel JLBEdadCoresterol3;
    private JLabel JLBEdadCoresterol4;
    private JLabel JLBEdadFumador;
    private JLabel JLBEdadFumador1;
    private JLabel JLBEdadFumador2;
    private JLabel JLBEdadFumador3;
    private JLabel JLBEdadFumador4;
    private JLabel JLBEdadNoFumador;
    private JLabel JLBPresionSistolica;
    private JLabel JLBPuntajeHdl;
    private JLabel JLBRiesgoC;
    private JLabel JLPaso1;
    private JLabel JLPaso2;
    private JLabel JLPaso3;
    private JLabel JLPaso4;
    private JLabel JLPaso5;
    private JLabel JLPaso6;
    private JLabel JLPuntaje;
    private JPanel JPForm;
    private JPanel JPPaso1;
    private JPanel JPPaso2;
    private JPanel JPPaso3;
    private JPanel JPPaso4;
    private JPanel JPPaso5;
    private JPanel JPPaso6;
    private JPanel JPResultado;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JRadioButton P2_1;
    private JRadioButton P2_2;
    private JRadioButton P2_3;
    private JRadioButton P3_1;
    private JRadioButton P3_2;
    private JRadioButton P4_1;
    private JRadioButton P4_2;
    private JRadioButton P4_3;
    private JRadioButton P4_4;
    private JRadioButton P4_5;
    private JRadioButton P5_1;
    private JRadioButton P5_2;
    private JRadioButton P5_3;
    private JRadioButton P5_4;
    private JRadioButton P6_1;
    private JRadioButton P6_10;
    private JRadioButton P6_2;
    private JRadioButton P6_3;
    private JRadioButton P6_4;
    private JRadioButton P6_5;
    private JRadioButton P6_6;
    private JRadioButton P6_7;
    private JRadioButton P6_8;
    private JRadioButton P6_9;
    private JRadioButton P_1;
    private JRadioButton P_10;
    private JRadioButton P_2;
    private JRadioButton P_3;
    private JRadioButton P_4;
    private JRadioButton P_5;
    private JRadioButton P_6;
    private JRadioButton P_7;
    private JRadioButton P_8;
    private JRadioButton P_9;
    private ButtonGroup Paso1;
    private ButtonGroup Paso2;
    private ButtonGroup Paso3;
    private ButtonGroup Paso4;
    private ButtonGroup Paso5;
    private ButtonGroup Paso6Presion1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JTabbedPane jTabbedPane1;
    private boolean xexiste = false;
    ConsultasMySQL xct = new ConsultasMySQL();
    Metodos xmt = new Metodos();
    private Metodos metodos = new Metodos();

    public JPFramingham_M() {
        initComponents();
        mIniciaComponentes();
        mVerifica();
        mBuscaHistorico();
    }

    private void mIniciaComponentes() {
        try {
            this.JLPaso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso_1M" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso_2M" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso_3M" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso_4M" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso_5M" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso_6M" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
        } catch (Exception e) {
            System.err.println("Excepcion framingham cargar imagenes de los label");
        }
    }

    public void takeSnapShot() throws IOException {
        BufferedImage img = new BufferedImage(this.JPForm.getWidth(), this.JPForm.getHeight(), 1);
        this.JPForm.paint(img.getGraphics());
        String nombreFichero = System.getProperty("user.home") + File.separatorChar + "caputura.jpg";
        File outputfile = new File(nombreFichero);
        System.out.println("Generando el fichero: " + outputfile);
        ImageIO.write(img, "jpg", outputfile);
    }

    public String getValueRadioButton(ButtonGroup buttonGroup) {
        Enumeration<AbstractButton> buttons = buttonGroup.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getName();
            }
        }
        return null;
    }

    public String getValueRadioButton1(JPanel panel) {
        for (int x = 0; x < panel.getComponentCount(); x++) {
            if (panel.getComponent(x) instanceof JRadioButton) {
                JRadioButton jb = panel.getComponent(x);
                if (jb.isSelected()) {
                    String valor = jb.getName();
                    return valor;
                }
            }
        }
        return "";
    }

    public void mCalcularEdadFumador() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        this.valorEdad = String.valueOf(periodo.getYears());
        if (this.xPaso3 != null) {
            this.xCalculoEdadFumador = Integer.valueOf(this.xPaso3).intValue();
            if (Integer.valueOf(this.valorEdad).intValue() >= 20 && Integer.valueOf(this.valorEdad).intValue() <= 39) {
                this.JLBEdadFumador.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                System.out.println("fumador -> " + this.xCalculoEdadFumador);
                switch (this.xCalculoEdadFumador) {
                    case 0:
                        this.JLBEdadFumador.setBounds(80, 67, 69, 21);
                        this.xResultadoFumador = "0";
                        break;
                    case 1:
                        this.JLBEdadFumador.setBounds(80, 89, 69, 21);
                        this.xResultadoFumador = "9";
                        break;
                }
            }
            if (Integer.valueOf(this.valorEdad).intValue() >= 40 && Integer.valueOf(this.valorEdad).intValue() <= 49) {
                this.JLBEdadFumador1.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadFumador) {
                    case 0:
                        this.JLBEdadFumador1.setBounds(148, 67, 69, 21);
                        this.xResultadoFumador = "0";
                        break;
                    case 1:
                        this.JLBEdadFumador1.setBounds(148, 89, 69, 21);
                        this.xResultadoFumador = "7";
                        break;
                }
            }
            if (Integer.valueOf(this.valorEdad).intValue() >= 50 && Integer.valueOf(this.valorEdad).intValue() <= 59) {
                this.JLBEdadFumador2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadFumador) {
                    case 0:
                        this.JLBEdadFumador2.setBounds(217, 67, 69, 21);
                        this.xResultadoFumador = "0";
                        break;
                    case 1:
                        this.JLBEdadFumador2.setBounds(217, 89, 69, 21);
                        this.xResultadoFumador = "4";
                        break;
                }
            }
            if (Integer.valueOf(this.valorEdad).intValue() >= 60 && Integer.valueOf(this.valorEdad).intValue() <= 69) {
                this.JLBEdadFumador3.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadFumador) {
                    case 0:
                        this.JLBEdadFumador3.setBounds(284, 67, 69, 21);
                        this.xResultadoFumador = "0";
                        break;
                    case 1:
                        this.JLBEdadFumador3.setBounds(284, 89, 69, 21);
                        this.xResultadoFumador = "2";
                        break;
                }
            }
            if (Integer.valueOf(this.valorEdad).intValue() >= 70 && Integer.valueOf(this.valorEdad).intValue() <= 79) {
                this.JLBEdadFumador4.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadFumador) {
                    case 0:
                        this.JLBEdadFumador4.setBounds(353, 67, 69, 21);
                        this.xResultadoFumador = "0";
                        break;
                    case 1:
                        this.JLBEdadFumador4.setBounds(353, 89, 69, 21);
                        this.xResultadoFumador = "1";
                        break;
                }
            }
        }
    }

    public void mCalcularEdadColesterol() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNac = LocalDate.parse(clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), fmt);
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNac, ahora);
        this.valorEdad = String.valueOf(periodo.getYears());
        if (this.xPaso4 != null) {
            this.xCalculoEdadCoresterol = Integer.valueOf(this.xPaso4).intValue();
            if (Integer.valueOf(this.valorEdad).intValue() <= 39) {
                this.JLBEdadCoresterol.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadCoresterol) {
                    case 0:
                        this.JLBEdadCoresterol.setBounds(133, 55, 112, 20);
                        this.xResultadoColesterol = "0";
                        this.xRangoColesterol = "<160";
                        this.xPuntajeColesterol = "0";
                        break;
                    case 1:
                        this.JLBEdadCoresterol.setBounds(133, 73, 112, 20);
                        this.xResultadoColesterol = "1";
                        this.xRangoColesterol = "160-199";
                        this.xPuntajeColesterol = "4";
                        break;
                    case 2:
                        this.JLBEdadCoresterol.setBounds(133, 91, 112, 20);
                        this.xResultadoColesterol = "2";
                        this.xRangoColesterol = "200-239";
                        this.xPuntajeColesterol = "8";
                        break;
                    case 3:
                        this.JLBEdadCoresterol.setBounds(133, 109, 112, 20);
                        this.xResultadoColesterol = "3";
                        this.xRangoColesterol = "240-279";
                        this.xPuntajeColesterol = "11";
                        break;
                    case 4:
                        this.JLBEdadCoresterol.setBounds(133, 126, 112, 20);
                        this.xResultadoColesterol = "4";
                        this.xRangoColesterol = ">280";
                        this.xPuntajeColesterol = "13";
                        break;
                }
            }
            if (Integer.valueOf(this.valorEdad).intValue() >= 40 && Integer.valueOf(this.valorEdad).intValue() <= 49) {
                this.JLBEdadCoresterol1.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadCoresterol) {
                    case 0:
                        this.JLBEdadCoresterol1.setBounds(248, 55, 113, 20);
                        this.xResultadoColesterol = "0";
                        this.xRangoColesterol = "<160";
                        this.xPuntajeColesterol = "3";
                        break;
                    case 1:
                        this.JLBEdadCoresterol1.setBounds(248, 73, 113, 20);
                        this.xResultadoColesterol = "3";
                        this.xRangoColesterol = "160-199";
                        this.xPuntajeColesterol = "3";
                        break;
                    case 2:
                        this.JLBEdadCoresterol1.setBounds(248, 91, 113, 20);
                        this.xResultadoColesterol = "6";
                        this.xRangoColesterol = "200-239";
                        this.xPuntajeColesterol = "5";
                        break;
                    case 3:
                        this.JLBEdadCoresterol1.setBounds(248, 109, 113, 20);
                        this.xResultadoColesterol = "3";
                        this.xRangoColesterol = "240-279";
                        this.xPuntajeColesterol = "8";
                        break;
                    case 4:
                        this.JLBEdadCoresterol1.setBounds(248, 126, 113, 20);
                        this.xResultadoColesterol = "4";
                        this.xRangoColesterol = ">280";
                        this.xPuntajeColesterol = "10";
                        break;
                }
            }
            if (Integer.valueOf(this.valorEdad).intValue() >= 50 && Integer.valueOf(this.valorEdad).intValue() <= 59) {
                this.JLBEdadCoresterol2.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadCoresterol) {
                    case 0:
                        this.JLBEdadCoresterol2.setBounds(358, 55, 51, 20);
                        this.xResultadoColesterol = "0";
                        this.xRangoColesterol = "<160";
                        this.xPuntajeColesterol = "0";
                        break;
                    case 1:
                        this.JLBEdadCoresterol2.setBounds(358, 73, 51, 20);
                        this.xResultadoColesterol = "1";
                        this.xRangoColesterol = "160-199";
                        this.xPuntajeColesterol = "2";
                        break;
                    case 2:
                        this.JLBEdadCoresterol2.setBounds(358, 91, 51, 20);
                        this.xResultadoColesterol = "2";
                        this.xRangoColesterol = "200-239";
                        this.xPuntajeColesterol = "4";
                        break;
                    case 3:
                        this.JLBEdadCoresterol2.setBounds(358, 109, 51, 20);
                        this.xResultadoColesterol = "5";
                        this.xRangoColesterol = "240-279";
                        this.xPuntajeColesterol = "4";
                        break;
                    case 4:
                        this.JLBEdadCoresterol2.setBounds(358, 126, 51, 20);
                        this.xResultadoColesterol = "4";
                        this.xRangoColesterol = ">280";
                        this.xPuntajeColesterol = "7";
                        break;
                }
            }
            if (Integer.valueOf(this.valorEdad).intValue() >= 60 && Integer.valueOf(this.valorEdad).intValue() <= 69) {
                this.JLBEdadCoresterol3.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadCoresterol) {
                    case 0:
                        this.JLBEdadCoresterol3.setBounds(410, 55, 82, 20);
                        this.xResultadoColesterol = "0";
                        this.xRangoColesterol = "<160";
                        this.xPuntajeColesterol = "0";
                        break;
                    case 1:
                        this.JLBEdadCoresterol3.setBounds(410, 73, 82, 20);
                        this.xResultadoColesterol = "1";
                        this.xRangoColesterol = "160-199";
                        this.xPuntajeColesterol = "1";
                        break;
                    case 2:
                        this.JLBEdadCoresterol3.setBounds(410, 91, 82, 20);
                        this.xResultadoColesterol = "2";
                        this.xRangoColesterol = "200-239";
                        this.xPuntajeColesterol = "2";
                        break;
                    case 3:
                        this.JLBEdadCoresterol3.setBounds(410, 109, 82, 20);
                        this.xResultadoColesterol = "3";
                        this.xRangoColesterol = "240-279";
                        this.xPuntajeColesterol = "3";
                        break;
                    case 4:
                        this.JLBEdadCoresterol3.setBounds(410, 126, 82, 20);
                        this.xResultadoColesterol = "4";
                        this.xRangoColesterol = ">280";
                        this.xPuntajeColesterol = "4";
                        break;
                }
            }
            if (Integer.valueOf(this.valorEdad).intValue() >= 70 && Integer.valueOf(this.valorEdad).intValue() <= 79) {
                this.JLBEdadCoresterol4.setBorder(BorderFactory.createLineBorder(Color.red, 2));
                switch (this.xCalculoEdadCoresterol) {
                    case 0:
                        this.JLBEdadCoresterol4.setBounds(490, 55, 112, 20);
                        this.xResultadoColesterol = "0";
                        this.xRangoColesterol = "<160";
                        this.xPuntajeColesterol = "0";
                        break;
                    case 1:
                        this.JLBEdadCoresterol4.setBounds(490, 73, 112, 20);
                        this.xResultadoColesterol = "1";
                        this.xRangoColesterol = "160-199";
                        this.xPuntajeColesterol = "1";
                        break;
                    case 2:
                        this.JLBEdadCoresterol4.setBounds(490, 91, 112, 20);
                        this.xResultadoColesterol = "2";
                        this.xRangoColesterol = "200-239";
                        this.xPuntajeColesterol = "1";
                        break;
                    case 3:
                        this.JLBEdadCoresterol4.setBounds(490, 109, 112, 20);
                        this.xResultadoColesterol = "3";
                        this.xRangoColesterol = "240-279";
                        this.xPuntajeColesterol = "2";
                        break;
                    case 4:
                        this.JLBEdadCoresterol4.setBounds(490, 126, 112, 20);
                        this.xResultadoColesterol = "4";
                        this.xRangoColesterol = ">280";
                        this.xPuntajeColesterol = "2";
                        break;
                }
            }
        }
    }

    public void mCalcularHdl() {
        if (this.xPaso5 != null) {
            this.xCalculoHDL = Integer.valueOf(this.xPaso5).intValue();
            this.JLBPuntajeHdl.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            switch (this.xCalculoHDL) {
                case 0:
                    this.JLBPuntajeHdl.setBounds(90, 35, 82, 20);
                    this.xRangoHdl = "60";
                    this.xValorHdl = "0";
                    this.xPuntajeHdl = "1";
                    break;
                case 1:
                    this.JLBPuntajeHdl.setBounds(90, 53, 82, 20);
                    this.xRangoHdl = "50-59";
                    this.xValorHdl = "1";
                    this.xPuntajeHdl = "0";
                    break;
                case 2:
                    this.JLBPuntajeHdl.setBounds(90, 71, 82, 20);
                    this.xRangoHdl = "40-49";
                    this.xValorHdl = "2";
                    this.xPuntajeHdl = "1";
                    break;
                case 3:
                    this.JLBPuntajeHdl.setBounds(90, 90, 82, 20);
                    this.xRangoHdl = "<40";
                    this.xValorHdl = "3";
                    this.xPuntajeHdl = "2";
                    break;
            }
        }
    }

    public void mCalcularReisgoCardio() {
        if (this.xPaso2 != null) {
            this.xCalculoRiesgo = Integer.valueOf(this.xPaso2).intValue();
            this.JLBRiesgoC.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            switch (this.xCalculoRiesgo) {
                case 0:
                    this.JLBRiesgoC.setBounds(150, 50, 150, 18);
                    this.xRiesgoCardio = "0";
                    this.xRangoRiesgo = "<10";
                    break;
                case 1:
                    this.JLBRiesgoC.setBounds(150, 68, 150, 18);
                    this.xRiesgoCardio = "1";
                    this.xRangoRiesgo = "10-20";
                    break;
                case 2:
                    this.JLBRiesgoC.setBounds(150, 83, 150, 18);
                    this.xRiesgoCardio = "2";
                    this.xRangoRiesgo = ">20";
                    break;
            }
        }
    }

    public void mCalcularEdad() {
        if (this.xPaso1 != null) {
            this.xResultado2 = Integer.valueOf(this.xPaso1).intValue();
            this.JLBEdad.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            switch (this.xResultado2) {
                case 0:
                    this.JLBEdad.setBounds(20, 50, 65, 20);
                    if (this.P_1.isSelected()) {
                        this.xedad = "-7";
                        this.xRangoEdad = "20-34";
                    }
                    break;
                case 1:
                    this.JLBEdad.setBounds(20, 70, 65, 20);
                    if (this.P_2.isSelected()) {
                        this.xedad = "-3";
                        this.xRangoEdad = "35-39";
                    }
                    break;
                case 2:
                    this.JLBEdad.setBounds(20, 90, 65, 20);
                    if (this.P_3.isSelected()) {
                        this.xedad = "0";
                        this.xRangoEdad = "40-44";
                    }
                    break;
                case 3:
                    this.JLBEdad.setBounds(20, 110, 65, 20);
                    if (this.P_4.isSelected()) {
                        this.xedad = "3";
                        this.xRangoEdad = "45-49";
                    }
                    break;
                case 4:
                    this.JLBEdad.setBounds(20, 130, 65, 20);
                    if (this.P_5.isSelected()) {
                        this.xedad = "6";
                        this.xRangoEdad = "50-54";
                    }
                    break;
                case 5:
                    this.JLBEdad.setBounds(20, 150, 65, 20);
                    if (this.P_6.isSelected()) {
                        this.xedad = "8";
                        this.xRangoEdad = "55-59";
                    }
                    break;
                case 6:
                    this.JLBEdad.setBounds(20, 170, 65, 20);
                    if (this.P_7.isSelected()) {
                        this.xedad = "10";
                        this.xRangoEdad = "60-64";
                    }
                    break;
                case 7:
                    this.JLBEdad.setBounds(20, 190, 65, 20);
                    if (this.P_8.isSelected()) {
                        this.xedad = "12";
                        this.xRangoEdad = "65-69";
                    }
                    break;
                case 8:
                    this.JLBEdad.setBounds(20, 210, 65, 20);
                    if (this.P_9.isSelected()) {
                        this.xedad = "14";
                        this.xRangoEdad = "70-74";
                    }
                    break;
                case 9:
                    this.JLBEdad.setBounds(20, 230, 65, 20);
                    if (this.P_10.isSelected()) {
                        this.xedad = "16";
                        this.xRangoEdad = "75-79";
                    }
                    break;
            }
        }
    }

    public void mPresionSistolica() {
        if (this.xPaso6 != null) {
            this.xCalculoPresion = Integer.valueOf(this.xPaso6).intValue();
            this.JLBPresionSistolica.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            switch (this.xCalculoPresion) {
                case 0:
                    this.JLBPresionSistolica.setBounds(10, 35, 137, 20);
                    if (this.P6_1.isSelected()) {
                        this.xRangoPresion = "<120";
                        this.xResultadoPresion = "0";
                        this.xPuntajePresion = "0";
                    } else if (this.P6_2.isSelected()) {
                        this.xRangoPresion = "<120";
                        this.xResultadoPresion = "0";
                        this.xPuntajePresion = "0";
                    }
                    break;
                case 1:
                    this.JLBPresionSistolica.setBounds(10, 52, 137, 20);
                    if (this.P6_3.isSelected()) {
                        this.xRangoPresion = "120-129";
                        this.xResultadoPresion = "1";
                        this.xPuntajePresion = "1";
                    } else if (this.P6_4.isSelected()) {
                        this.xRangoPresion = "120-129";
                        this.xResultadoPresion = "1";
                        this.xPuntajePresion = "3";
                    }
                    break;
                case 2:
                    this.JLBPresionSistolica.setBounds(10, 70, 137, 20);
                    if (this.P6_5.isSelected()) {
                        this.xRangoPresion = "130-139";
                        this.xResultadoPresion = "2";
                        this.xPuntajePresion = "2";
                    } else if (this.P6_6.isSelected()) {
                        this.xRangoPresion = "130-139";
                        this.xResultadoPresion = "2";
                        this.xPuntajePresion = "4";
                    }
                    break;
                case 3:
                    this.JLBPresionSistolica.setBounds(10, 86, 137, 20);
                    if (this.P6_7.isSelected()) {
                        this.xRangoPresion = "140-159";
                        this.xResultadoPresion = "3";
                        this.xPuntajePresion = "3";
                    } else if (this.P6_8.isSelected()) {
                        this.xRangoPresion = "140-159";
                        this.xResultadoPresion = "3";
                        this.xPuntajePresion = "5";
                    }
                    break;
                case 4:
                    this.JLBPresionSistolica.setBounds(10, 103, 137, 20);
                    if (this.P6_9.isSelected()) {
                        this.xRangoPresion = ">160";
                        this.xResultadoPresion = "4";
                        this.xPuntajePresion = "4";
                    } else if (this.P6_10.isSelected()) {
                        this.xRangoPresion = ">160";
                        this.xResultadoPresion = "4";
                        this.xPuntajePresion = "6";
                    }
                    break;
            }
        }
    }

    private void mResultado() {
        if (this.xPaso1 != null && this.xPaso3 != null && this.xPaso4 != null && this.xPaso5 != null && this.xPaso6 != null) {
            this.xResultado = Integer.valueOf(this.xedad).intValue() + Integer.valueOf(this.xPuntajeColesterol).intValue() + Integer.valueOf(this.xResultadoFumador).intValue() + Integer.valueOf(this.xPuntajeHdl).intValue() + Integer.valueOf(this.xPuntajePresion).intValue();
            System.out.println("resultado -> " + this.xResultado);
            if (this.xResultado < 0) {
                this.xResultado = 0;
            } else if (this.xResultado > 17) {
                this.xResultado = 17;
            }
            this.JLPuntaje.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            switch (this.xResultado) {
                case 0:
                    this.JLPuntaje.setBounds(10, 39, 196, 20);
                    this.totalPuntaje = "<9";
                    this.xPorcentaje = "<1";
                    break;
                case 1:
                    this.JLPuntaje.setBounds(10, 57, 196, 20);
                    this.totalPuntaje = "9";
                    this.xPorcentaje = "1%";
                    break;
                case 2:
                    this.JLPuntaje.setBounds(10, 74, 196, 20);
                    this.totalPuntaje = "10";
                    this.xPorcentaje = "1%";
                    break;
                case 3:
                    this.JLPuntaje.setBounds(10, 92, 196, 20);
                    this.totalPuntaje = "11";
                    this.xPorcentaje = "1%";
                    break;
                case 4:
                    this.JLPuntaje.setBounds(10, 109, 196, 20);
                    this.totalPuntaje = "12";
                    this.xPorcentaje = "1%";
                    break;
                case 5:
                    this.JLPuntaje.setBounds(10, 128, 196, 20);
                    this.totalPuntaje = "13";
                    this.xPorcentaje = "2%";
                    break;
                case 6:
                    this.JLPuntaje.setBounds(10, 146, 196, 20);
                    this.totalPuntaje = "14";
                    this.xPorcentaje = "2%";
                    break;
                case 7:
                    this.JLPuntaje.setBounds(10, 164, 196, 20);
                    this.totalPuntaje = "15";
                    this.xPorcentaje = "3%";
                    break;
                case 8:
                    this.JLPuntaje.setBounds(10, 180, 196, 20);
                    this.totalPuntaje = "16";
                    this.xPorcentaje = "4%";
                    break;
                case 9:
                    this.JLPuntaje.setBounds(205, 39, 196, 20);
                    this.totalPuntaje = "17";
                    this.xPorcentaje = "5%";
                    break;
                case 10:
                    this.JLPuntaje.setBounds(205, 57, 238, 20);
                    this.totalPuntaje = "18";
                    this.xPorcentaje = "6&";
                    break;
                case 11:
                    this.JLPuntaje.setBounds(205, 74, 238, 20);
                    this.totalPuntaje = "19";
                    this.xPorcentaje = "8%";
                    break;
                case 12:
                    this.JLPuntaje.setBounds(205, 92, 238, 20);
                    this.totalPuntaje = "20";
                    this.xPorcentaje = "11%";
                    break;
                case 13:
                    this.JLPuntaje.setBounds(205, 109, 238, 20);
                    this.totalPuntaje = "21";
                    this.xPorcentaje = "14%";
                    break;
                case 14:
                    this.JLPuntaje.setBounds(205, 128, 238, 20);
                    this.totalPuntaje = "22";
                    this.xPorcentaje = "17%";
                    break;
                case 15:
                    this.JLPuntaje.setBounds(205, 146, 238, 20);
                    this.totalPuntaje = "23";
                    this.xPorcentaje = "22%";
                    break;
                case 16:
                    this.JLPuntaje.setBounds(205, 164, 238, 20);
                    this.totalPuntaje = "24";
                    this.xPorcentaje = "27%";
                    break;
                case 17:
                    this.JLPuntaje.setBounds(205, 180, 238, 20);
                    this.totalPuntaje = ">25";
                    this.xPorcentaje = ">30%";
                    break;
            }
        }
    }

    public void mGuardar() {
        String sql;
        if (!this.xmt.esIPSMineros()) {
            if (!this.xexiste) {
                if (this.xPaso1 != null && this.xPaso2 != null && this.xPaso3 != null && this.xPaso4 != null && this.xPaso5 != null && this.xPaso6 != null) {
                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y == 0) {
                        String sql2 = "INSERT INTO `h_framigan`\n            (`idAtencion`,\n             `idUsuario`,\n             `fechaR`,\n             `rangosEdad`,\n             `edad`,\n             `fumador`,\n             `rangoColesterol`,\n             `colesterol`,\n             `rangoHdl`,\n             `hdl`,\n             `rangoPresion`,\n             `presion`,\n             `rangoRiesgoCardiovascular`,\n             `riesgoCardiovascular`,\n             `resultadoPuntos`,\n             `resultadoPorcentaje`,\n             `UsuarioS`)\nVALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',\n        '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',\n            '" + this.xRangoEdad + "',\n            '" + this.xPaso1 + "',\n        '" + this.xResultadoFumador + "',\n        '" + this.xRangoColesterol + "',\n        '" + this.xResultadoColesterol + "',\n        '" + this.xRangoHdl + "',\n        '" + this.xValorHdl + "',\n        '" + this.xRangoPresion + "',\n        '" + this.xResultadoPresion + "',\n        '" + this.xRangoRiesgo + "',\n        '" + this.xRiesgoCardio + "',\n        '" + this.totalPuntaje + "',\n        '" + this.xPorcentaje + "', \n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xidTest = this.xct.ejecutarSQLId(sql2);
                        System.out.println("id test --------->" + this.xidTest);
                        this.xct.cerrarConexionBd();
                        this.xexiste = true;
                        mGuardaImagen1();
                        mBuscaHistorico();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe terminar el test", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Este test ya fué diligenciado en la atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.xEstadoHC == 0) {
            if (this.xPaso1 != null && this.xPaso2 != null && this.xPaso3 != null && this.xPaso4 != null && this.xPaso5 != null && this.xPaso6 != null) {
                int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y2 == 0) {
                    if (!this.xexiste) {
                        sql = "INSERT INTO `h_framigan`\n            (`idAtencion`,\n             `idUsuario`,\n             `fechaR`,\n             `rangosEdad`,\n             `edad`,\n             `fumador`,\n             `rangoColesterol`,\n             `colesterol`,\n             `rangoHdl`,\n             `hdl`,\n             `rangoPresion`,\n             `presion`,\n             `rangoRiesgoCardiovascular`,\n             `riesgoCardiovascular`,\n             `resultadoPuntos`,\n             `resultadoPorcentaje`,\n             `UsuarioS`)\nVALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',\n        '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',\n            '" + this.xRangoEdad + "',\n            '" + this.xPaso1 + "',\n        '" + this.xResultadoFumador + "',\n        '" + this.xRangoColesterol + "',\n        '" + this.xResultadoColesterol + "',\n        '" + this.xRangoHdl + "',\n        '" + this.xValorHdl + "',\n        '" + this.xRangoPresion + "',\n        '" + this.xResultadoPresion + "',\n        '" + this.xRangoRiesgo + "',\n        '" + this.xRiesgoCardio + "',\n        '" + this.totalPuntaje + "',\n        '" + this.xPorcentaje + "', \n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xidTest = this.xct.ejecutarSQLId(sql);
                        mGuardaImagen1();
                    } else {
                        sql = "UPDATE `h_framigan` SET `rangosEdad`='" + this.xRangoEdad + "`edad`='" + this.xPaso1 + "',`rangoRiesgoCardiovascular`='" + this.xRangoRiesgo + "',`riesgoCardiovascular`='" + this.xRiesgoCardio + "',`fumador`='" + this.xResultadoFumador + "',`rangoColesterol`='" + this.xRangoColesterol + "',`colesterol`='" + this.xResultadoColesterol + "',`rangoHdl`='" + this.xRangoHdl + "',`hdl`='" + this.xValorHdl + "',`rangoPresion`='" + this.xRangoPresion + "',`presion`='" + this.xResultadoPresion + "',`resultadoPuntos`='" + this.totalPuntaje + "',`resultadoPorcentaje`='" + this.xPorcentaje + "',`UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE idAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mBuscaHistorico();
                    this.xexiste = true;
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe terminar el test", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Esta historia clinica ya se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mGuardaImagen1() {
        this.metodos.traerImagenGraficasPanel(this.JPForm, "framingham");
        try {
            this.metodos.guardarImagenBlobFramingham(this.xidTest);
        } catch (SQLException ex) {
            Logger.getLogger(JPReuConteoArticulaciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerifica() {
        String sql = "select\n\t`edad`,\n\triesgoCardiovascular,\n\tif(`fumador`>=1,1,0)as fumador,\n\t`colesterol`,\n\t`hdl`,\n\t`presion`,\n\t`resultadoPuntos`,\n\t`h_atencion`.`TipoGuardado`\nfrom\n\t`h_framigan`\ninner join `h_atencion` on\n\t(h_framigan.`idAtencion` = `h_atencion`.`Id`)\nwhere\n\t(h_framigan.`idAtencion` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'\n\tand h_framigan.`Estado` = 1)";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xexiste = true;
                setButtonGroup(xrs.getString("edad"), this.Paso1.getElements());
                setButtonGroup(xrs.getString("riesgoCardiovascular"), this.Paso2.getElements());
                setButtonGroup(xrs.getString("fumador"), this.Paso3.getElements());
                setButtonGroup(xrs.getString("colesterol"), this.Paso4.getElements());
                setButtonGroup(xrs.getString("hdl"), this.Paso5.getElements());
                setButtonGroup(xrs.getString("presion"), this.Paso6Presion1.getElements());
                this.xEstadoHC = Long.parseLong(xrs.getString("TipoGuardado"));
                mResultado();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFramingham_M.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Punt. Edad", "Riesgo Cardiovascular", "Punt. Fumador", "Punt. Colesterol total", "Punt. HDL", "Punt. Presión Art.", "Total Puntos", "Porcentaje"}) { // from class: Historia.JPFramingham_M.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(8);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    private void mBuscaHistorico() {
        mCrearModelo();
        try {
            String sql = "select\n\tId,\n\t`fechaR`,\n\t`edad`,\n\t riesgoCardiovascular,\n\tif(`fumador`>=1,1,0)as fumador,\n\t`colesterol`,\n\t`hdl`,\n\t`presion`,\n\t`resultadoPuntos`,\n\t`resultadoPorcentaje`\nfrom\n\t`baseserver`.`h_framigan`\nwhere\n\th_framigan.`Estado` = 1\n\tand h_framigan.`idUsuario` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "'\norder by\n\tfechaR desc";
            ResultSet xrs = this.xct.traerRs(sql);
            int x = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), x, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), x, 9);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFramingham_M.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v181, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Paso1 = new ButtonGroup();
        this.Paso2 = new ButtonGroup();
        this.Paso3 = new ButtonGroup();
        this.Paso4 = new ButtonGroup();
        this.Paso5 = new ButtonGroup();
        this.Paso6Presion1 = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPForm = new JPanel();
        this.JPPaso1 = new JPanel();
        this.P_1 = new JRadioButton();
        this.P_2 = new JRadioButton();
        this.P_3 = new JRadioButton();
        this.P_4 = new JRadioButton();
        this.P_5 = new JRadioButton();
        this.P_6 = new JRadioButton();
        this.P_7 = new JRadioButton();
        this.P_8 = new JRadioButton();
        this.P_9 = new JRadioButton();
        this.P_10 = new JRadioButton();
        this.JLBEdad = new JLabel();
        this.JLPaso1 = new JLabel();
        this.JPPaso2 = new JPanel();
        this.P2_1 = new JRadioButton();
        this.P2_2 = new JRadioButton();
        this.P2_3 = new JRadioButton();
        this.JLBRiesgoC = new JLabel();
        this.JLPaso2 = new JLabel();
        this.JPPaso3 = new JPanel();
        this.P3_1 = new JRadioButton();
        this.P3_2 = new JRadioButton();
        this.JLBEdadNoFumador = new JLabel();
        this.JLBEdadFumador = new JLabel();
        this.JLBEdadFumador1 = new JLabel();
        this.JLBEdadFumador2 = new JLabel();
        this.JLBEdadFumador3 = new JLabel();
        this.JLBEdadFumador4 = new JLabel();
        this.JLPaso3 = new JLabel();
        this.JPPaso4 = new JPanel();
        this.P4_1 = new JRadioButton();
        this.P4_2 = new JRadioButton();
        this.P4_3 = new JRadioButton();
        this.P4_4 = new JRadioButton();
        this.P4_5 = new JRadioButton();
        this.JLBEdadCoresterol = new JLabel();
        this.JLBEdadCoresterol1 = new JLabel();
        this.JLBEdadCoresterol2 = new JLabel();
        this.JLBEdadCoresterol3 = new JLabel();
        this.JLBEdadCoresterol4 = new JLabel();
        this.JLPaso4 = new JLabel();
        this.JPPaso5 = new JPanel();
        this.P5_1 = new JRadioButton();
        this.P5_2 = new JRadioButton();
        this.P5_3 = new JRadioButton();
        this.P5_4 = new JRadioButton();
        this.JLBPuntajeHdl = new JLabel();
        this.JLPaso5 = new JLabel();
        this.JPPaso6 = new JPanel();
        this.P6_1 = new JRadioButton();
        this.P6_2 = new JRadioButton();
        this.P6_3 = new JRadioButton();
        this.P6_4 = new JRadioButton();
        this.P6_5 = new JRadioButton();
        this.P6_6 = new JRadioButton();
        this.P6_7 = new JRadioButton();
        this.P6_8 = new JRadioButton();
        this.P6_9 = new JRadioButton();
        this.P6_10 = new JRadioButton();
        this.JLBPresionSistolica = new JLabel();
        this.JLPaso6 = new JLabel();
        this.JPResultado = new JPanel();
        this.JLPuntaje = new JLabel();
        this.jLabel2 = new JLabel();
        this.jPanel1 = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setName("jpFramiganM");
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JPForm.setBackground(new Color(255, 255, 255));
        this.JPPaso1.setBorder(BorderFactory.createTitledBorder((Border) null, "PUNTAJE EDAD", 2, 0, new Font("Arial", 1, 12)));
        this.JPPaso1.setMaximumSize(new Dimension(150, 207));
        this.JPPaso1.setMinimumSize(new Dimension(150, 207));
        this.JPPaso1.setPreferredSize(new Dimension(150, 207));
        this.JPPaso1.setLayout((LayoutManager) null);
        this.Paso1.add(this.P_1);
        this.P_1.setName("0");
        this.P_1.setOpaque(false);
        this.P_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.2
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_1ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_1);
        this.P_1.setBounds(130, 50, 30, 16);
        this.Paso1.add(this.P_2);
        this.P_2.setName("1");
        this.P_2.setOpaque(false);
        this.P_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.3
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_2ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_2);
        this.P_2.setBounds(130, 70, 30, 16);
        this.Paso1.add(this.P_3);
        this.P_3.setName("2");
        this.P_3.setOpaque(false);
        this.P_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.4
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_3ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_3);
        this.P_3.setBounds(130, 90, 30, 16);
        this.Paso1.add(this.P_4);
        this.P_4.setIconTextGap(3);
        this.P_4.setName("3");
        this.P_4.setOpaque(false);
        this.P_4.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.5
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_4ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_4);
        this.P_4.setBounds(130, 110, 30, 16);
        this.Paso1.add(this.P_5);
        this.P_5.setName("4");
        this.P_5.setOpaque(false);
        this.P_5.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.6
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_5ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_5);
        this.P_5.setBounds(130, 130, 30, 16);
        this.Paso1.add(this.P_6);
        this.P_6.setName("5");
        this.P_6.setOpaque(false);
        this.P_6.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.7
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_6ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_6);
        this.P_6.setBounds(130, 150, 30, 16);
        this.Paso1.add(this.P_7);
        this.P_7.setName("6");
        this.P_7.setOpaque(false);
        this.P_7.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.8
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_7ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_7);
        this.P_7.setBounds(130, 170, 30, 16);
        this.Paso1.add(this.P_8);
        this.P_8.setName("7");
        this.P_8.setOpaque(false);
        this.P_8.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.9
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_8ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_8);
        this.P_8.setBounds(130, 190, 30, 16);
        this.Paso1.add(this.P_9);
        this.P_9.setName("8");
        this.P_9.setOpaque(false);
        this.P_9.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.10
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_9ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_9);
        this.P_9.setBounds(130, 210, 30, 16);
        this.Paso1.add(this.P_10);
        this.P_10.setName("9");
        this.P_10.setOpaque(false);
        this.P_10.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.11
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P_10ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_10);
        this.P_10.setBounds(130, 230, 30, 16);
        this.JPPaso1.add(this.JLBEdad);
        this.JLBEdad.setBounds(20, 30, 70, 20);
        this.JLPaso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/paso_1M.png")));
        this.JLPaso1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JLPaso1.setMaximumSize(new Dimension(150, 207));
        this.JLPaso1.setMinimumSize(new Dimension(150, 207));
        this.JLPaso1.setPreferredSize(new Dimension(150, 207));
        this.JPPaso1.add(this.JLPaso1);
        this.JLPaso1.setBounds(20, 30, 137, 221);
        this.JPPaso2.setBorder(BorderFactory.createTitledBorder((Border) null, "RIESGO CARDIOVASCULAR", 2, 0, new Font("Arial", 1, 12)));
        this.JPPaso2.setMaximumSize(new Dimension(150, 98));
        this.JPPaso2.setMinimumSize(new Dimension(150, 98));
        this.JPPaso2.setPreferredSize(new Dimension(150, 98));
        this.JPPaso2.setLayout((LayoutManager) null);
        this.Paso2.add(this.P2_1);
        this.P2_1.setName("0");
        this.P2_1.setOpaque(false);
        this.P2_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.12
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P2_1ActionPerformed(evt);
            }
        });
        this.JPPaso2.add(this.P2_1);
        this.P2_1.setBounds(110, 50, 25, 20);
        this.Paso2.add(this.P2_2);
        this.P2_2.setName("1");
        this.P2_2.setOpaque(false);
        this.P2_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.13
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P2_2ActionPerformed(evt);
            }
        });
        this.JPPaso2.add(this.P2_2);
        this.P2_2.setBounds(110, 70, 25, 10);
        this.Paso2.add(this.P2_3);
        this.P2_3.setName("2");
        this.P2_3.setOpaque(false);
        this.P2_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.14
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P2_3ActionPerformed(evt);
            }
        });
        this.JPPaso2.add(this.P2_3);
        this.P2_3.setBounds(110, 80, 20, 20);
        this.JPPaso2.add(this.JLBRiesgoC);
        this.JLBRiesgoC.setBounds(150, 30, 150, 20);
        this.JLPaso2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/paso_2M.png")));
        this.JLPaso2.setText("jLabel1");
        this.JLPaso2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JLPaso2.setMaximumSize(new Dimension(150, 98));
        this.JLPaso2.setMinimumSize(new Dimension(150, 98));
        this.JLPaso2.setPreferredSize(new Dimension(150, 98));
        this.JPPaso2.add(this.JLPaso2);
        this.JLPaso2.setBounds(10, 30, 290, 73);
        this.JPPaso3.setBorder(BorderFactory.createTitledBorder((Border) null, "FUMADOR", 2, 0, new Font("Arial", 1, 12)));
        this.JPPaso3.setMaximumSize(new Dimension(150, 97));
        this.JPPaso3.setMinimumSize(new Dimension(150, 97));
        this.JPPaso3.setLayout((LayoutManager) null);
        this.Paso3.add(this.P3_1);
        this.P3_1.setName("0");
        this.P3_1.setOpaque(false);
        this.P3_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.15
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P3_1ActionPerformed(evt);
            }
        });
        this.JPPaso3.add(this.P3_1);
        this.P3_1.setBounds(60, 40, 20, 30);
        this.Paso3.add(this.P3_2);
        this.P3_2.setName("1");
        this.P3_2.setOpaque(false);
        this.P3_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.16
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P3_2ActionPerformed(evt);
            }
        });
        this.JPPaso3.add(this.P3_2);
        this.P3_2.setBounds(60, 90, 20, 20);
        this.JPPaso3.add(this.JLBEdadNoFumador);
        this.JLBEdadNoFumador.setBounds(80, 60, 70, 20);
        this.JPPaso3.add(this.JLBEdadFumador);
        this.JLBEdadFumador.setBounds(90, 40, 60, 20);
        this.JPPaso3.add(this.JLBEdadFumador1);
        this.JLBEdadFumador1.setBounds(150, 50, 70, 20);
        this.JPPaso3.add(this.JLBEdadFumador2);
        this.JLBEdadFumador2.setBounds(220, 50, 70, 20);
        this.JPPaso3.add(this.JLBEdadFumador3);
        this.JLBEdadFumador3.setBounds(290, 50, 60, 20);
        this.JPPaso3.add(this.JLBEdadFumador4);
        this.JLBEdadFumador4.setBounds(360, 40, 60, 20);
        this.JLPaso3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/paso_3M.png")));
        this.JLPaso3.setText("jLabel1");
        this.JLPaso3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JLPaso3.setMaximumSize(new Dimension(150, 97));
        this.JLPaso3.setMinimumSize(new Dimension(150, 97));
        this.JLPaso3.setPreferredSize(new Dimension(150, 97));
        this.JPPaso3.add(this.JLPaso3);
        this.JLPaso3.setBounds(10, 20, 412, 92);
        this.JPPaso4.setBorder(BorderFactory.createTitledBorder((Border) null, "COLESTEROL TOTAL", 2, 0, new Font("Arial", 1, 12)));
        this.JPPaso4.setMaximumSize(new Dimension(150, 153));
        this.JPPaso4.setMinimumSize(new Dimension(150, 153));
        this.JPPaso4.setLayout((LayoutManager) null);
        this.Paso4.add(this.P4_1);
        this.P4_1.setName("0");
        this.P4_1.setOpaque(false);
        this.P4_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.17
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P4_1ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_1);
        this.P4_1.setBounds(110, 50, 20, 30);
        this.Paso4.add(this.P4_2);
        this.P4_2.setName("1");
        this.P4_2.setOpaque(false);
        this.P4_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.18
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P4_2ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_2);
        this.P4_2.setBounds(110, 70, 25, 25);
        this.Paso4.add(this.P4_3);
        this.P4_3.setName("2");
        this.P4_3.setOpaque(false);
        this.P4_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.19
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P4_3ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_3);
        this.P4_3.setBounds(110, 90, 20, 25);
        this.Paso4.add(this.P4_4);
        this.P4_4.setName("3");
        this.P4_4.setOpaque(false);
        this.P4_4.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.20
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P4_4ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_4);
        this.P4_4.setBounds(110, 110, 20, 20);
        this.Paso4.add(this.P4_5);
        this.P4_5.setName("4");
        this.P4_5.setOpaque(false);
        this.P4_5.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.21
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P4_5ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_5);
        this.P4_5.setBounds(110, 130, 20, 20);
        this.JPPaso4.add(this.JLBEdadCoresterol);
        this.JLBEdadCoresterol.setBounds(160, 40, 90, 20);
        this.JPPaso4.add(this.JLBEdadCoresterol1);
        this.JLBEdadCoresterol1.setBounds(250, 40, 80, 20);
        this.JPPaso4.add(this.JLBEdadCoresterol2);
        this.JLBEdadCoresterol2.setBounds(340, 40, 90, 20);
        this.JPPaso4.add(this.JLBEdadCoresterol3);
        this.JLBEdadCoresterol3.setBounds(430, 40, 90, 20);
        this.JPPaso4.add(this.JLBEdadCoresterol4);
        this.JLBEdadCoresterol4.setBounds(520, 40, 80, 20);
        this.JLPaso4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/paso_4M.png")));
        this.JLPaso4.setText("jLabel1");
        this.JLPaso4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JLPaso4.setMaximumSize(new Dimension(150, 153));
        this.JLPaso4.setMinimumSize(new Dimension(150, 153));
        this.JLPaso4.setPreferredSize(new Dimension(150, 153));
        this.JPPaso4.add(this.JLPaso4);
        this.JLPaso4.setBounds(20, 20, 583, 127);
        this.JPPaso5.setBorder(BorderFactory.createTitledBorder((Border) null, "HDL COLESTEROL", 2, 0, new Font("Arial", 1, 12)));
        this.JPPaso5.setMaximumSize(new Dimension(150, 155));
        this.JPPaso5.setMinimumSize(new Dimension(150, 155));
        this.JPPaso5.setLayout((LayoutManager) null);
        this.Paso5.add(this.P5_1);
        this.P5_1.setName("1");
        this.P5_1.setOpaque(false);
        this.P5_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.22
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P5_1ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_1);
        this.P5_1.setBounds(70, 50, 20, 30);
        this.Paso5.add(this.P5_2);
        this.P5_2.setName("0");
        this.P5_2.setOpaque(false);
        this.P5_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.23
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P5_2ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_2);
        this.P5_2.setBounds(70, 30, 25, 30);
        this.Paso5.add(this.P5_3);
        this.P5_3.setName("2");
        this.P5_3.setOpaque(false);
        this.P5_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.24
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P5_3ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_3);
        this.P5_3.setBounds(70, 70, 25, 25);
        this.Paso5.add(this.P5_4);
        this.P5_4.setName("3");
        this.P5_4.setOpaque(false);
        this.P5_4.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.25
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P5_4ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_4);
        this.P5_4.setBounds(70, 90, 20, 20);
        this.JPPaso5.add(this.JLBPuntajeHdl);
        this.JLBPuntajeHdl.setBounds(100, 20, 70, 20);
        this.JLPaso5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/paso_5M.png")));
        this.JLPaso5.setText("jLabel1");
        this.JLPaso5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JLPaso5.setMaximumSize(new Dimension(150, 155));
        this.JLPaso5.setMinimumSize(new Dimension(150, 155));
        this.JLPaso5.setPreferredSize(new Dimension(150, 155));
        this.JPPaso5.add(this.JLPaso5);
        this.JLPaso5.setBounds(10, 20, 162, 93);
        this.JPPaso6.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN SISTÓLICA", 2, 0, new Font("Arial", 1, 12)));
        this.JPPaso6.setMaximumSize(new Dimension(247, 212));
        this.JPPaso6.setMinimumSize(new Dimension(247, 212));
        this.JPPaso6.setLayout((LayoutManager) null);
        this.Paso6Presion1.add(this.P6_1);
        this.P6_1.setName("0");
        this.P6_1.setOpaque(false);
        this.P6_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.26
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_1ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_1);
        this.P6_1.setBounds(160, 30, 20, 30);
        this.Paso6Presion1.add(this.P6_2);
        this.P6_2.setName("0");
        this.P6_2.setOpaque(false);
        this.P6_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.27
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_2ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_2);
        this.P6_2.setBounds(230, 30, 20, 30);
        this.Paso6Presion1.add(this.P6_3);
        this.P6_3.setName("1");
        this.P6_3.setOpaque(false);
        this.P6_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.28
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_3ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_3);
        this.P6_3.setBounds(160, 50, 20, 25);
        this.Paso6Presion1.add(this.P6_4);
        this.P6_4.setName("1");
        this.P6_4.setOpaque(false);
        this.P6_4.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.29
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_4ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_4);
        this.P6_4.setBounds(230, 50, 25, 20);
        this.Paso6Presion1.add(this.P6_5);
        this.P6_5.setName("2");
        this.P6_5.setOpaque(false);
        this.P6_5.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.30
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_5ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_5);
        this.P6_5.setBounds(160, 70, 20, 20);
        this.Paso6Presion1.add(this.P6_6);
        this.P6_6.setName("2");
        this.P6_6.setOpaque(false);
        this.P6_6.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.31
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_6ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_6);
        this.P6_6.setBounds(230, 70, 20, 20);
        this.Paso6Presion1.add(this.P6_7);
        this.P6_7.setName("3");
        this.P6_7.setOpaque(false);
        this.P6_7.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.32
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_7ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_7);
        this.P6_7.setBounds(160, 90, 20, 10);
        this.Paso6Presion1.add(this.P6_8);
        this.P6_8.setName("3");
        this.P6_8.setOpaque(false);
        this.P6_8.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.33
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_8ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_8);
        this.P6_8.setBounds(230, 90, 20, 10);
        this.Paso6Presion1.add(this.P6_9);
        this.P6_9.setName("4");
        this.P6_9.setOpaque(false);
        this.P6_9.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.34
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_9ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_9);
        this.P6_9.setBounds(160, 100, 20, 20);
        this.Paso6Presion1.add(this.P6_10);
        this.P6_10.setName("4");
        this.P6_10.setOpaque(false);
        this.P6_10.addActionListener(new ActionListener() { // from class: Historia.JPFramingham_M.35
            public void actionPerformed(ActionEvent evt) {
                JPFramingham_M.this.P6_10ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_10);
        this.P6_10.setBounds(230, 100, 20, 20);
        this.JPPaso6.add(this.JLBPresionSistolica);
        this.JLBPresionSistolica.setBounds(10, 20, 160, 20);
        this.JLPaso6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/paso_6M.png")));
        this.JLPaso6.setText("jLabel1");
        this.JLPaso6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JLPaso6.setMaximumSize(new Dimension(247, 212));
        this.JLPaso6.setMinimumSize(new Dimension(247, 212));
        this.JLPaso6.setPreferredSize(new Dimension(247, 212));
        this.JPPaso6.add(this.JLPaso6);
        this.JLPaso6.setBounds(10, 20, 287, 101);
        this.JPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 12)));
        this.JPResultado.setMaximumSize(new Dimension(242, 562));
        this.JPResultado.setMinimumSize(new Dimension(242, 562));
        this.JPResultado.setPreferredSize(new Dimension(242, 562));
        this.JPResultado.setLayout((LayoutManager) null);
        this.JPResultado.add(this.JLPuntaje);
        this.JLPuntaje.setBounds(10, 20, 430, 20);
        this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/resultadoM.png")));
        this.jLabel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JPResultado.add(this.jLabel2);
        this.jLabel2.setBounds(10, 20, 432, 182);
        GroupLayout JPFormLayout = new GroupLayout(this.JPForm);
        this.JPForm.setLayout(JPFormLayout);
        JPFormLayout.setHorizontalGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addContainerGap().addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addComponent(this.JPPaso1, -2, 177, -2).addGap(18, 18, 18).addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addComponent(this.JPPaso3, -2, 440, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPaso5, -2, 177, -2)).addComponent(this.JPPaso4, -2, 622, -2))).addGroup(JPFormLayout.createSequentialGroup().addComponent(this.JPPaso6, -2, 306, -2).addGap(18, 18, 18).addComponent(this.JPPaso2, -2, 310, -2)).addComponent(this.JPResultado, -2, 456, -2)).addContainerGap(84, 32767)));
        JPFormLayout.setVerticalGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFormLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPFormLayout.createSequentialGroup().addComponent(this.JPPaso4, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPPaso5, -2, 127, -2).addComponent(this.JPPaso3, -2, 127, -2))).addComponent(this.JPPaso1, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPPaso2, -2, 128, -2).addComponent(this.JPPaso6, -2, 128, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPResultado, -2, 211, -2).addContainerGap(128, 32767)));
        this.jTabbedPane1.addTab("FRAMINGHAM", this.JPForm);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPFramingham_M.36
            public void mouseClicked(MouseEvent evt) {
                JPFramingham_M.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JPFramingham_M.37
            public void keyPressed(KeyEvent evt) {
                JPFramingham_M.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle, -2, 788, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 786, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_1ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_2ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_3ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_4ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_5ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_6ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_7ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_8ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_9ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2_1ActionPerformed(ActionEvent evt) {
        this.xPaso2 = getValueRadioButton1(this.JPPaso2);
        mCalcularReisgoCardio();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2_2ActionPerformed(ActionEvent evt) {
        this.xPaso2 = getValueRadioButton1(this.JPPaso2);
        mCalcularReisgoCardio();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3_1ActionPerformed(ActionEvent evt) {
        this.xPaso3 = getValueRadioButton1(this.JPPaso3);
        mCalcularEdadFumador();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3_2ActionPerformed(ActionEvent evt) {
        this.xPaso3 = getValueRadioButton1(this.JPPaso3);
        mCalcularEdadFumador();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_1ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton1(this.JPPaso4);
        mCalcularEdadColesterol();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_2ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton1(this.JPPaso4);
        mCalcularEdadColesterol();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_3ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton1(this.JPPaso4);
        mCalcularEdadColesterol();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_4ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton1(this.JPPaso4);
        mCalcularEdadColesterol();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_5ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton1(this.JPPaso4);
        mCalcularEdadColesterol();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_1ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton1(this.JPPaso5);
        mCalcularHdl();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_2ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton1(this.JPPaso5);
        mCalcularHdl();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_3ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton1(this.JPPaso5);
        mCalcularHdl();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_4ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton1(this.JPPaso5);
        mCalcularHdl();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_1ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_2ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_3ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_4ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_5ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            setButtonGroup(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString(), this.Paso1.getElements());
            setButtonGroup(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString(), this.Paso2.getElements());
            setButtonGroup(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString(), this.Paso3.getElements());
            setButtonGroup(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString(), this.Paso4.getElements());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString()).equals(0)) {
                this.P5_1.setSelected(true);
            }
            setButtonGroup(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).toString(), this.Paso6Presion1.getElements());
            mResultado();
            this.jTabbedPane1.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_10ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton1(this.JPPaso1);
        mCalcularEdad();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2_3ActionPerformed(ActionEvent evt) {
        this.xPaso2 = getValueRadioButton1(this.JPPaso2);
        mCalcularReisgoCardio();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_6ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_7ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_8ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_9ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_10ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6Presion1);
        mPresionSistolica();
        mResultado();
    }

    public void setButtonGroup(String rdValue, Enumeration elements) {
        while (elements.hasMoreElements()) {
            AbstractButton button = (AbstractButton) elements.nextElement();
            if (button.getName().equals(rdValue)) {
                button.setSelected(true);
                button.doClick();
            }
        }
    }
}
