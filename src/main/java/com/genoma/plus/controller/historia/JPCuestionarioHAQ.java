package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.CuestionarioHaqDAO;
import com.genoma.plus.dao.impl.historia.CuestionadioHaqDAOImpl;
import com.genoma.plus.dto.historia.CuestionarioHaqDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPCuestionarioHAQ.class */
public class JPCuestionarioHAQ extends JPanel {
    private final clasesHistoriaCE xClaseHC;
    private CuestionarioHaqDAO xCuestionarioHaqDAO;
    public DefaultTableModel xmodelo;
    private Object[] xDato;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObserE;
    private JTextArea JTAObservacion;
    private JTable JTBDetalle;
    private JTabbedPane JTPClasificacionEular;
    private ButtonGroup btgPreg_1;
    private ButtonGroup btgPreg_10;
    private ButtonGroup btgPreg_11;
    private ButtonGroup btgPreg_12;
    private ButtonGroup btgPreg_13;
    private ButtonGroup btgPreg_14;
    private ButtonGroup btgPreg_15;
    private ButtonGroup btgPreg_16;
    private ButtonGroup btgPreg_17;
    private ButtonGroup btgPreg_18;
    private ButtonGroup btgPreg_19;
    private ButtonGroup btgPreg_2;
    private ButtonGroup btgPreg_20;
    private ButtonGroup btgPreg_3;
    private ButtonGroup btgPreg_4;
    private ButtonGroup btgPreg_5;
    private ButtonGroup btgPreg_6;
    private ButtonGroup btgPreg_7;
    private ButtonGroup btgPreg_8;
    private ButtonGroup btgPreg_9;
    private JButton btnCalcular;
    private JCheckBox jcbAct_1;
    private JCheckBox jcbAct_2;
    private JCheckBox jcbAct_3;
    private JCheckBox jcbAct_4;
    private JCheckBox jcbAct_5;
    private JCheckBox jcbAct_6;
    private JCheckBox jcbAct_7;
    private JCheckBox jcbAct_8;
    private JCheckBox jcbUten_1;
    private JCheckBox jcbUten_2;
    private JCheckBox jcbUten_3;
    private JCheckBox jcbUten_4;
    private JCheckBox jcbUten_5;
    private JPanel jpActividad;
    private JPanel jpAlcanzar;
    private JPanel jpCaminar;
    private JPanel jpComer;
    private JPanel jpCuestionario1;
    private JPanel jpCuestionario2;
    private JPanel jpCuestionario3;
    private JPanel jpCuestionario4;
    private JPanel jpHigiene;
    private JPanel jpHistorico;
    private JPanel jpLevantarse;
    private JPanel jpOtras;
    private JPanel jpPrension;
    private JPanel jpUtensilios;
    private JPanel jpVestirseAsearse;
    private JRadioButton jrbPreg_101;
    private JRadioButton jrbPreg_102;
    private JRadioButton jrbPreg_103;
    private JRadioButton jrbPreg_104;
    private JRadioButton jrbPreg_11;
    private JRadioButton jrbPreg_111;
    private JRadioButton jrbPreg_112;
    private JRadioButton jrbPreg_113;
    private JRadioButton jrbPreg_114;
    private JRadioButton jrbPreg_12;
    private JRadioButton jrbPreg_121;
    private JRadioButton jrbPreg_122;
    private JRadioButton jrbPreg_123;
    private JRadioButton jrbPreg_124;
    private JRadioButton jrbPreg_13;
    private JRadioButton jrbPreg_131;
    private JRadioButton jrbPreg_132;
    private JRadioButton jrbPreg_133;
    private JRadioButton jrbPreg_134;
    private JRadioButton jrbPreg_14;
    private JRadioButton jrbPreg_141;
    private JRadioButton jrbPreg_142;
    private JRadioButton jrbPreg_143;
    private JRadioButton jrbPreg_144;
    private JRadioButton jrbPreg_151;
    private JRadioButton jrbPreg_152;
    private JRadioButton jrbPreg_153;
    private JRadioButton jrbPreg_154;
    private JRadioButton jrbPreg_161;
    private JRadioButton jrbPreg_162;
    private JRadioButton jrbPreg_163;
    private JRadioButton jrbPreg_164;
    private JRadioButton jrbPreg_171;
    private JRadioButton jrbPreg_172;
    private JRadioButton jrbPreg_173;
    private JRadioButton jrbPreg_174;
    private JRadioButton jrbPreg_181;
    private JRadioButton jrbPreg_182;
    private JRadioButton jrbPreg_183;
    private JRadioButton jrbPreg_184;
    private JRadioButton jrbPreg_191;
    private JRadioButton jrbPreg_192;
    private JRadioButton jrbPreg_193;
    private JRadioButton jrbPreg_194;
    private JRadioButton jrbPreg_201;
    private JRadioButton jrbPreg_202;
    private JRadioButton jrbPreg_203;
    private JRadioButton jrbPreg_204;
    private JRadioButton jrbPreg_21;
    private JRadioButton jrbPreg_22;
    private JRadioButton jrbPreg_23;
    private JRadioButton jrbPreg_24;
    private JRadioButton jrbPreg_31;
    private JRadioButton jrbPreg_32;
    private JRadioButton jrbPreg_33;
    private JRadioButton jrbPreg_34;
    private JRadioButton jrbPreg_41;
    private JRadioButton jrbPreg_42;
    private JRadioButton jrbPreg_43;
    private JRadioButton jrbPreg_44;
    private JRadioButton jrbPreg_51;
    private JRadioButton jrbPreg_52;
    private JRadioButton jrbPreg_53;
    private JRadioButton jrbPreg_54;
    private JRadioButton jrbPreg_61;
    private JRadioButton jrbPreg_62;
    private JRadioButton jrbPreg_63;
    private JRadioButton jrbPreg_64;
    private JRadioButton jrbPreg_71;
    private JRadioButton jrbPreg_72;
    private JRadioButton jrbPreg_73;
    private JRadioButton jrbPreg_74;
    private JRadioButton jrbPreg_81;
    private JRadioButton jrbPreg_82;
    private JRadioButton jrbPreg_83;
    private JRadioButton jrbPreg_84;
    private JRadioButton jrbPreg_91;
    private JRadioButton jrbPreg_92;
    private JRadioButton jrbPreg_93;
    private JRadioButton jrbPreg_94;
    private JLabel lblClasificacion;
    private JLabel lblIdAtencion;
    private JLabel lblInicio;
    private JLabel lblInicio2;
    private JLabel lblItem1;
    private JLabel lblItem10;
    private JLabel lblItem11;
    private JLabel lblItem12;
    private JLabel lblItem2;
    private JLabel lblItem3;
    private JLabel lblItem4;
    private JLabel lblItem5;
    private JLabel lblItem6;
    private JLabel lblItem7;
    private JLabel lblItem8;
    private JLabel lblItem9;
    private JLabel lblPreg_1;
    private JLabel lblPreg_10;
    private JLabel lblPreg_11;
    private JLabel lblPreg_12;
    private JLabel lblPreg_13;
    private JLabel lblPreg_14;
    private JLabel lblPreg_15;
    private JLabel lblPreg_16;
    private JLabel lblPreg_17;
    private JLabel lblPreg_18;
    private JLabel lblPreg_19;
    private JLabel lblPreg_2;
    private JLabel lblPreg_20;
    private JLabel lblPreg_3;
    private JLabel lblPreg_4;
    private JLabel lblPreg_5;
    private JLabel lblPreg_6;
    private JLabel lblPreg_7;
    private JLabel lblPreg_8;
    private JLabel lblPreg_9;
    private int xOpc1 = -1;
    private int xOpc2 = -1;
    private int xOpc3 = -1;
    private int xOpc4 = -1;
    private int xOpc5 = -1;
    private int xOpc6 = -1;
    private int xOpc7 = -1;
    private int xOpc8 = -1;
    private int xOpc9 = -1;
    private int xOpc10 = -1;
    private int xOpc11 = -1;
    private int xOpc12 = -1;
    private int xOpc13 = -1;
    private int xOpc14 = -1;
    private int xOpc15 = -1;
    private int xOpc16 = -1;
    private int xOpc17 = -1;
    private int xOpc18 = -1;
    private int xOpc19 = -1;
    private int xOpc20 = -1;
    private int xGrupo1 = 0;
    private int xGrupo2 = 0;
    private int xGrupo3 = 0;
    private int xGrupo4 = 0;
    private int xGrupo5 = 0;
    private int xGrupo6 = 0;
    private int xGrupo7 = 0;
    private int xGrupo8 = 0;
    private int xAct1 = 0;
    private int xAct2 = 0;
    private int xAct3 = 0;
    private int xAct4 = 0;
    private int xAct5 = 0;
    private int xAct6 = 0;
    private int xAct7 = 0;
    private int xAct8 = 0;
    private int xUten1 = 0;
    private int xUten2 = 0;
    private int xUten3 = 0;
    private int xUten4 = 0;
    private int xUten5 = 0;
    private double xTotal = 0.0d;
    private boolean bandera1 = false;
    private boolean bandera2 = false;
    private boolean bandera3 = false;
    private boolean bandera4 = false;
    private boolean bandera5 = false;
    private boolean bandera6 = false;
    private boolean bandera7 = false;
    private boolean bandera8 = false;
    private final CuestionarioHaqDTO xCuestionarioHaqDTO = new CuestionarioHaqDTO();
    private final Metodos xmt = new Metodos();
    DecimalFormat formatoSalidaDecimal = new DecimalFormat("0.00");
    DecimalFormat redondear = new DecimalFormat("0.00");
    private int xSumaRespuestas = 0;

    public JPCuestionarioHAQ(clasesHistoriaCE xClaseHC) {
        initComponents();
        springStart();
        this.xClaseHC = xClaseHC;
        mNuevo();
    }

    private void springStart() {
        this.xCuestionarioHaqDAO = (CuestionadioHaqDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("xCuestionarioHaq");
    }

    public void mIniciarComponentes() {
        this.lblItem1.setText("<html><body><p align='center'>Sin<br>dificultad</p></body></html>");
        this.lblItem2.setText("<html><body><p align='center'>Con alguna<br>dificultad</p></body></html>");
        this.lblItem3.setText("<html><body><p align='center'>Con mucha<br>dificultad</p></body></html>");
        this.lblItem4.setText("<html><body><p align='center'>Incapaz<br>de hacerlo</p></body></html>");
        this.lblItem5.setText("<html><body><p align='center'>Sin<br>dificultad</p></body></html>");
        this.lblItem6.setText("<html><body><p align='center'>Con alguna<br>dificultad</p></body></html>");
        this.lblItem7.setText("<html><body><p align='center'>Con mucha<br>dificultad</p></body></html>");
        this.lblItem8.setText("<html><body><p align='center'>Incapaz<br>de hacerlo</p></body></html>");
        this.lblItem9.setText("<html><body><p align='center'>Sin<br>dificultad</p></body></html>");
        this.lblItem10.setText("<html><body><p align='center'>Con alguna<br>dificultad</p></body></html>");
        this.lblItem11.setText("<html><body><p align='center'>Con mucha<br>dificultad</p></body></html>");
        this.lblItem12.setText("<html><body><p align='center'>Incapaz<br>de hacerlo</p></body></html>");
        this.lblInicio.setText("<html><body><p align='justify'>Durante la última semana, ¿ha sido usted capaz de...</p></body></html>");
        this.lblPreg_1.setText("<html><body><p align='justify'>1. Vestirse  solo,  incluyendo  abrocharse  los  botones  y  atarse los cordones de los zapatos?</p></body></html>");
        this.lblPreg_2.setText("<html><body><p align='justify'>2. Enjabonarse la cabeza?</p></body></html>");
        this.lblPreg_3.setText("<html><body><p align='justify'>3. Levantarse de una silla sin brazos?</p></body></html>");
        this.lblPreg_4.setText("<html><body><p align='justify'>4. Acostarse y levantarse de la cama?</p></body></html>");
        this.lblPreg_5.setText("<html><body><p align='justify'>5. Cortar un filete de carne?</p></body></html>");
        this.lblPreg_6.setText("<html><body><p align='justify'>6. Abrir un cartón de leche nuevo?</p></body></html>");
        this.lblPreg_7.setText("<html><body><p align='justify'>7. Servirse la bebida?</p></body></html>");
        this.lblPreg_8.setText("<html><body><p align='justify'>8. Caminar fuera de casa por un terreno llano?</p></body></html>");
        this.lblPreg_9.setText("<html><body><p align='justify'>9. Subir cinco escalones?</p></body></html>");
        this.lblPreg_10.setText("<html><body><p align='justify'>10. Lavarse y secarse todo el cuerpo?</p></body></html>");
        this.lblPreg_11.setText("<html><body><p align='justify'>11. Sentarse y levantarse del retrete?</p></body></html>");
        this.lblPreg_12.setText("<html><body><p align='justify'>12. Ducharse?</p></body></html>");
        this.lblPreg_13.setText("<html><body><p align='justify'>13. Coger un paquete de azúcar de 1 Kg de una estantería  colocada por encima de su cabeza?</p></body></html>");
        this.lblPreg_14.setText("<html><body><p align='justify'>14. Agacharse y recoger ropa del suelo?</p></body></html>");
        this.lblPreg_15.setText("<html><body><p align='justify'>15. Abrir la puerta de un coche?</p></body></html>");
        this.lblPreg_16.setText("<html><body><p align='justify'>16. Abrir tarros cerrados que ya antes habían sido abiertos?</p></body></html>");
        this.lblPreg_17.setText("<html><body><p align='justify'>17. Abrir y cerrar los grifos?</p></body></html>");
        this.lblPreg_18.setText("<html><body><p align='justify'>18. Hacer los recados y las compras?</p></body></html>");
        this.lblPreg_19.setText("<html><body><p align='justify'>19. Entrar y salir de un coche?</p></body></html>");
        this.lblPreg_20.setText("<html><body><p align='justify'>20. Hacer tareas de casa como barrer o lavar los platos?</p></body></html>");
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

    public void contarRespuestas(JPanel xjPanel, String name) {
        for (int x = 0; x < xjPanel.getComponentCount(); x++) {
            if (xjPanel.getComponent(x).getClass().toString().equals("class javax.swing.JRadioButton") && xjPanel.getComponent(x).isSelected()) {
                this.xSumaRespuestas++;
                switch (name) {
                    case "jpVestirseAsearse":
                        this.bandera1 = true;
                        break;
                    case "jpLevantarse":
                        this.bandera2 = true;
                        break;
                    case "jpComer":
                        this.bandera3 = true;
                        break;
                    case "jpCaminar":
                        this.bandera4 = true;
                        break;
                    case "jpHigiene":
                        this.bandera5 = true;
                        break;
                    case "jpAlcanzar":
                        this.bandera6 = true;
                        break;
                    case "jpPrension":
                        this.bandera7 = true;
                        break;
                    case "jpOtras":
                        this.bandera8 = true;
                        break;
                }
                return;
            }
        }
    }

    private void mCalculoPorPregunta() {
        if (this.xOpc1 >= this.xOpc2) {
            this.xGrupo1 = this.xOpc1;
        } else {
            this.xGrupo1 = this.xOpc2;
        }
        if (this.xOpc3 >= this.xOpc4) {
            this.xGrupo2 = this.xOpc3;
        } else {
            this.xGrupo2 = this.xOpc3;
        }
        if (this.xOpc5 >= this.xOpc6) {
            if (this.xOpc6 >= this.xOpc7) {
                this.xGrupo3 = this.xOpc5;
            } else {
                this.xGrupo3 = this.xOpc7;
            }
        } else if (this.xOpc6 >= this.xOpc7) {
            this.xGrupo3 = this.xOpc6;
        } else {
            this.xGrupo3 = this.xOpc7;
        }
        if (this.xOpc8 >= this.xOpc9) {
            this.xGrupo4 = this.xOpc8;
        } else {
            this.xGrupo4 = this.xOpc9;
        }
        if (this.xOpc10 >= this.xOpc11) {
            if (this.xOpc11 >= this.xOpc12) {
                this.xGrupo5 = this.xOpc10;
            } else {
                this.xGrupo5 = this.xOpc12;
            }
        } else if (this.xOpc11 >= this.xOpc12) {
            this.xGrupo5 = this.xOpc11;
        } else {
            this.xGrupo5 = this.xOpc12;
        }
        if (this.xOpc13 >= this.xOpc14) {
            this.xGrupo6 = this.xOpc13;
        } else {
            this.xGrupo6 = this.xOpc14;
        }
        if (this.xOpc15 >= this.xOpc16) {
            if (this.xOpc16 >= this.xOpc17) {
                this.xGrupo7 = this.xOpc15;
            } else {
                this.xGrupo7 = this.xOpc17;
            }
        } else if (this.xOpc16 >= this.xOpc17) {
            this.xGrupo7 = this.xOpc16;
        } else {
            this.xGrupo7 = this.xOpc17;
        }
        if (this.xOpc18 >= this.xOpc19) {
            if (this.xOpc19 >= this.xOpc20) {
                this.xGrupo8 = this.xOpc18;
                return;
            } else {
                this.xGrupo8 = this.xOpc20;
                return;
            }
        }
        if (this.xOpc19 >= this.xOpc20) {
            this.xGrupo8 = this.xOpc19;
        } else {
            this.xGrupo8 = this.xOpc20;
        }
    }

    private void mCalculaTotal() {
        this.xSumaRespuestas = 0;
        contarRespuestas(this.jpVestirseAsearse, "jpVestirseAsearse");
        contarRespuestas(this.jpLevantarse, "jpLevantarse");
        contarRespuestas(this.jpComer, "jpComer");
        contarRespuestas(this.jpCaminar, "jpCaminar");
        contarRespuestas(this.jpHigiene, "jpHigiene");
        contarRespuestas(this.jpAlcanzar, "jpAlcanzar");
        contarRespuestas(this.jpPrension, "jpPrension");
        contarRespuestas(this.jpOtras, "jpOtras");
        System.out.println("\nMOSTRANDO VALOR BADERAS\nbandera1: " + this.bandera1 + "\nbandera2: " + this.bandera2 + "\nbandera3: " + this.bandera3 + "\nbandera4: " + this.bandera4 + "\nbandera5: " + this.bandera5 + "\nbandera6: " + this.bandera6 + "\nbandera7: " + this.bandera7 + "\nbandera8: " + this.bandera8);
        if ((this.xGrupo1 == 0 || this.xGrupo1 == 1) && this.jcbAct_1.isSelected()) {
            this.xGrupo1 = 2;
        }
        if ((this.xGrupo2 == 0 || this.xGrupo2 == 1) && (this.jcbAct_2.isSelected() || this.jcbUten_2.isSelected())) {
            this.xGrupo2 = 2;
        }
        if ((this.xGrupo3 == 0 || this.xGrupo3 == 1) && (this.jcbAct_3.isSelected() || this.jcbUten_1.isSelected())) {
            this.xGrupo3 = 2;
        }
        if ((this.xGrupo4 == 0 || this.xGrupo4 == 1) && (this.jcbAct_4.isSelected() || this.jcbUten_4.isSelected())) {
            this.xGrupo4 = 2;
        }
        if ((this.xGrupo5 == 0 || this.xGrupo5 == 1) && (this.jcbAct_5.isSelected() || this.jcbUten_5.isSelected())) {
            this.xGrupo5 = 2;
        }
        if ((this.xGrupo6 == 0 || this.xGrupo6 == 1) && this.jcbAct_6.isSelected()) {
            this.xGrupo6 = 2;
        }
        if ((this.xGrupo7 == 0 || this.xGrupo7 == 1) && (this.jcbAct_7.isSelected() || this.jcbUten_3.isSelected())) {
            this.xGrupo7 = 2;
        }
        if ((this.xGrupo8 == 0 || this.xGrupo8 == 1) && this.jcbAct_8.isSelected()) {
            this.xGrupo8 = 2;
        }
        int suma = 0;
        if (this.xSumaRespuestas == 6) {
            if (!this.bandera1 && !this.bandera2) {
                this.xGrupo1 = -1;
                this.xGrupo2 = -1;
                suma = this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera1 && !this.bandera3) {
                this.xGrupo1 = -1;
                this.xGrupo3 = -1;
                suma = this.xGrupo2 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera1 && !this.bandera4) {
                this.xGrupo1 = -1;
                this.xGrupo4 = -1;
                suma = this.xGrupo2 + this.xGrupo3 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera1 && !this.bandera5) {
                this.xGrupo1 = -1;
                this.xGrupo5 = -1;
                suma = this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera1 && !this.bandera6) {
                this.xGrupo1 = -1;
                this.xGrupo6 = -1;
                suma = this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera1 && !this.bandera7) {
                this.xGrupo1 = -1;
                this.xGrupo7 = -1;
                suma = this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo8;
            } else if (!this.bandera1 && !this.bandera8) {
                this.xGrupo1 = -1;
                this.xGrupo8 = -1;
                suma = this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7;
            } else if (!this.bandera2 && !this.bandera3) {
                this.xGrupo2 = -1;
                this.xGrupo3 = -1;
                suma = this.xGrupo1 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera2 && !this.bandera4) {
                this.xGrupo2 = -1;
                this.xGrupo4 = -1;
                suma = this.xGrupo1 + this.xGrupo3 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera2 && !this.bandera5) {
                this.xGrupo2 = -1;
                this.xGrupo5 = -1;
                suma = this.xGrupo1 + this.xGrupo3 + this.xGrupo4 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera2 && !this.bandera6) {
                this.xGrupo2 = -1;
                this.xGrupo6 = -1;
                suma = this.xGrupo1 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera2 && !this.bandera7) {
                this.xGrupo2 = -1;
                this.xGrupo7 = -1;
                suma = this.xGrupo1 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo8;
            } else if (!this.bandera2 && !this.bandera8) {
                this.xGrupo2 = -1;
                this.xGrupo8 = -1;
                suma = this.xGrupo1 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7;
            } else if (!this.bandera3 && !this.bandera4) {
                this.xGrupo3 = -1;
                this.xGrupo4 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera3 && !this.bandera5) {
                this.xGrupo3 = -1;
                this.xGrupo5 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo4 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera3 && !this.bandera6) {
                this.xGrupo3 = -1;
                this.xGrupo6 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo4 + this.xGrupo5 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera3 && !this.bandera7) {
                this.xGrupo3 = -1;
                this.xGrupo7 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo8;
            } else if (!this.bandera3 && !this.bandera8) {
                this.xGrupo3 = -1;
                this.xGrupo8 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7;
            } else if (!this.bandera4 && !this.bandera5) {
                this.xGrupo4 = -1;
                this.xGrupo5 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera4 && !this.bandera6) {
                this.xGrupo4 = -1;
                this.xGrupo6 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo5 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera4 && !this.bandera7) {
                this.xGrupo4 = -1;
                this.xGrupo7 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo5 + this.xGrupo6 + this.xGrupo8;
            } else if (!this.bandera4 && !this.bandera8) {
                this.xGrupo4 = -1;
                this.xGrupo8 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7;
            } else if (!this.bandera5 && !this.bandera6) {
                this.xGrupo5 = -1;
                this.xGrupo6 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera5 && !this.bandera7) {
                this.xGrupo5 = -1;
                this.xGrupo7 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo6 + this.xGrupo8;
            } else if (!this.bandera5 && !this.bandera8) {
                this.xGrupo5 = -1;
                this.xGrupo8 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo6 + this.xGrupo7;
            } else if (!this.bandera6 && !this.bandera7) {
                this.xGrupo6 = -1;
                this.xGrupo7 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo8;
            } else if (!this.bandera6 && !this.bandera8) {
                this.xGrupo6 = -1;
                this.xGrupo8 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo7;
            } else if (!this.bandera7 && !this.bandera8) {
                this.xGrupo7 = -1;
                this.xGrupo8 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6;
            }
        } else if (this.xSumaRespuestas == 7) {
            if (!this.bandera1) {
                this.xGrupo1 = -1;
                suma = this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera2) {
                this.xGrupo2 = -1;
                suma = this.xGrupo1 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera3) {
                this.xGrupo3 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera4) {
                this.xGrupo4 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera5) {
                this.xGrupo5 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera6) {
                this.xGrupo6 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo7 + this.xGrupo8;
            } else if (!this.bandera7) {
                this.xGrupo7 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo8;
            } else if (!this.bandera8) {
                this.xGrupo8 = -1;
                suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7;
            }
        } else if (this.xSumaRespuestas == 8) {
            suma = this.xGrupo1 + this.xGrupo2 + this.xGrupo3 + this.xGrupo4 + this.xGrupo5 + this.xGrupo6 + this.xGrupo7 + this.xGrupo8;
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe diligenciar el test completo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
        System.out.println("Grupo1 : " + this.xGrupo1);
        System.out.println("Grupo2 : " + this.xGrupo2);
        System.out.println("Grupo3 : " + this.xGrupo3);
        System.out.println("Grupo4 : " + this.xGrupo4);
        System.out.println("Grupo5 : " + this.xGrupo5);
        System.out.println("Grupo6 : " + this.xGrupo6);
        System.out.println("Grupo7 : " + this.xGrupo7);
        System.out.println("Grupo8 : " + this.xGrupo8);
        System.out.println("------------------");
        this.xTotal = ((double) suma) / ((double) this.xSumaRespuestas);
        this.redondear.format(this.xTotal);
        this.lblClasificacion.setText("" + this.redondear.format(this.xTotal));
        System.out.println("\nsuma : " + suma + " promedio  : " + this.xTotal);
    }

    public void mNuevo() {
        mIniciarComponentes();
        this.btgPreg_1.clearSelection();
        this.btgPreg_2.clearSelection();
        this.btgPreg_3.clearSelection();
        this.btgPreg_4.clearSelection();
        this.btgPreg_5.clearSelection();
        this.btgPreg_6.clearSelection();
        this.btgPreg_7.clearSelection();
        this.btgPreg_8.clearSelection();
        this.btgPreg_9.clearSelection();
        this.btgPreg_10.clearSelection();
        this.btgPreg_11.clearSelection();
        this.btgPreg_12.clearSelection();
        this.btgPreg_13.clearSelection();
        this.btgPreg_14.clearSelection();
        this.btgPreg_15.clearSelection();
        this.btgPreg_16.clearSelection();
        this.btgPreg_17.clearSelection();
        this.btgPreg_18.clearSelection();
        this.btgPreg_19.clearSelection();
        this.btgPreg_20.clearSelection();
        this.xGrupo1 = 0;
        this.xGrupo2 = 0;
        this.xGrupo3 = 0;
        this.xGrupo4 = 0;
        this.xGrupo5 = 0;
        this.xGrupo6 = 0;
        this.xGrupo7 = 0;
        this.xGrupo8 = 0;
        this.xOpc1 = 0;
        this.xOpc2 = 0;
        this.xOpc3 = 0;
        this.xOpc4 = 0;
        this.xOpc5 = 0;
        this.xOpc6 = 0;
        this.xOpc7 = 0;
        this.xOpc8 = 0;
        this.xOpc9 = 0;
        this.xOpc10 = 0;
        this.xOpc11 = 0;
        this.xOpc12 = 0;
        this.xOpc13 = 0;
        this.xOpc14 = 0;
        this.xOpc15 = 0;
        this.xOpc16 = 0;
        this.xOpc17 = 0;
        this.xOpc18 = 0;
        this.xOpc19 = 0;
        this.xOpc20 = 0;
        this.jcbAct_1.setSelected(false);
        this.jcbAct_2.setSelected(false);
        this.jcbAct_3.setSelected(false);
        this.jcbAct_4.setSelected(false);
        this.jcbAct_5.setSelected(false);
        this.jcbAct_6.setSelected(false);
        this.jcbAct_7.setSelected(false);
        this.jcbAct_8.setSelected(false);
        this.jcbUten_1.setSelected(false);
        this.jcbUten_4.setSelected(false);
        this.jcbUten_2.setSelected(false);
        this.jcbUten_5.setSelected(false);
        this.jcbUten_3.setSelected(false);
        this.lblClasificacion.setText("");
        this.lblIdAtencion.setText("");
        this.JTAObservacion.setText("");
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!mVerificar(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion())) {
            if (!this.lblClasificacion.getText().isEmpty()) {
                if (JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                    this.xCuestionarioHaqDTO.setId_Atencion(Integer.parseInt(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
                    this.xCuestionarioHaqDTO.setId_Usuario(Integer.parseInt(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().toString()));
                    this.xCuestionarioHaqDTO.setId_Profesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                    this.xCuestionarioHaqDTO.setId_Especialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString());
                    this.xCuestionarioHaqDTO.setFecha_Registro(this.xmt.formatoAMD.format(this.xmt.getFechaActual()));
                    this.xCuestionarioHaqDTO.setPreg_1(this.xOpc1);
                    this.xCuestionarioHaqDTO.setPreg_2(this.xOpc2);
                    this.xCuestionarioHaqDTO.setPreg_3(this.xOpc3);
                    this.xCuestionarioHaqDTO.setPreg_4(this.xOpc4);
                    this.xCuestionarioHaqDTO.setPreg_5(this.xOpc5);
                    this.xCuestionarioHaqDTO.setPreg_6(this.xOpc6);
                    this.xCuestionarioHaqDTO.setPreg_7(this.xOpc7);
                    this.xCuestionarioHaqDTO.setPreg_8(this.xOpc8);
                    this.xCuestionarioHaqDTO.setPreg_9(this.xOpc9);
                    this.xCuestionarioHaqDTO.setPreg_10(this.xOpc10);
                    this.xCuestionarioHaqDTO.setPreg_11(this.xOpc11);
                    this.xCuestionarioHaqDTO.setPreg_12(this.xOpc12);
                    this.xCuestionarioHaqDTO.setPreg_13(this.xOpc13);
                    this.xCuestionarioHaqDTO.setPreg_14(this.xOpc14);
                    this.xCuestionarioHaqDTO.setPreg_15(this.xOpc15);
                    this.xCuestionarioHaqDTO.setPreg_16(this.xOpc16);
                    this.xCuestionarioHaqDTO.setPreg_17(this.xOpc17);
                    this.xCuestionarioHaqDTO.setPreg_18(this.xOpc18);
                    this.xCuestionarioHaqDTO.setPreg_19(this.xOpc19);
                    this.xCuestionarioHaqDTO.setPreg_20(this.xOpc20);
                    this.xCuestionarioHaqDTO.setGrup1_Vestirse_Asearse(this.xGrupo1);
                    this.xCuestionarioHaqDTO.setGrup2_Levantarse(this.xGrupo2);
                    this.xCuestionarioHaqDTO.setGrup3_Comer(this.xGrupo3);
                    this.xCuestionarioHaqDTO.setGrup4_Caminar(this.xGrupo4);
                    this.xCuestionarioHaqDTO.setGrup5_Higiene(this.xGrupo5);
                    this.xCuestionarioHaqDTO.setGrup6_Alcanzar(this.xGrupo6);
                    this.xCuestionarioHaqDTO.setGrup7_Prension(this.xGrupo7);
                    this.xCuestionarioHaqDTO.setGrup8_Otras(this.xGrupo8);
                    this.xCuestionarioHaqDTO.setAct_1(this.xAct1);
                    this.xCuestionarioHaqDTO.setAct_2(this.xAct2);
                    this.xCuestionarioHaqDTO.setAct_3(this.xAct3);
                    this.xCuestionarioHaqDTO.setAct_4(this.xAct4);
                    this.xCuestionarioHaqDTO.setAct_5(this.xAct5);
                    this.xCuestionarioHaqDTO.setAct_6(this.xAct6);
                    this.xCuestionarioHaqDTO.setAct_7(this.xAct7);
                    this.xCuestionarioHaqDTO.setAct_8(this.xAct8);
                    this.xCuestionarioHaqDTO.setUten_1(this.xUten1);
                    this.xCuestionarioHaqDTO.setUten_2(this.xUten2);
                    this.xCuestionarioHaqDTO.setUten_3(this.xUten3);
                    this.xCuestionarioHaqDTO.setUten_4(this.xUten4);
                    this.xCuestionarioHaqDTO.setUten_5(this.xUten5);
                    this.xCuestionarioHaqDTO.setClasificacion(this.xTotal);
                    this.xCuestionarioHaqDTO.setObservacion(this.JTAObservacion.getText());
                    this.xCuestionarioHaqDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    this.xCuestionarioHaqDAO.mCreate(this.xCuestionarioHaqDTO);
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                mCargarDatosTabla();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe diligenciar el test completo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ya existe un Test en ésta atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private boolean mVerificar(String xIdAtencion) {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTBDetalle.getRowCount()) {
                break;
            }
            if (!this.JTBDetalle.getValueAt(i, 1).toString().equals(xIdAtencion)) {
                i++;
            } else {
                xExiste = true;
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                break;
            }
        }
        return xExiste;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Id_Atencion", "Profesional", "Especialidad", "Fecha_Registro", "Preg_1", "Preg_2", "Preg_3", "Preg_4", "Preg_5", "Preg_6", "Preg_7", "Preg_8", "Preg_9", "Preg_10", "Preg_11", "Preg_12", "Preg_13", "Preg_14", "Preg_15", "Preg_16", "Preg_17", "Preg_18", "Preg_19", "Preg_20", "Grup1_Vestirse_Asearse", "Grup2_Levantarse", "Grup3_Comer", "Grup4_Caminar", "Grup5_Higiene", "Grup6_Alcanzar", "Grup7_Prension", "Grup8_Otras", "Act_1", "Act_2", "Act_3", "Act_4", "Act_5", "Act_6", "Act_7", "Act_8", "Uten_1", "Uten_2", "Uten_3", "Uten_4", "Uten_5", "Clasificacion", "Observacion"}) { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.1
            Class[] types = {Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Integer.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(18).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(20).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(22).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(25).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(26).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(27).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(28).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(29).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(30).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(31).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(32).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(33).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(34).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(35).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(36).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(37).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(38).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(39).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(40).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(41).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(42).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(43).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(44).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(45).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(46).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(47).setPreferredWidth(150);
    }

    private void mCargarDatosTabla() {
        CuestionarioHaqDAO cuestionarioHaqDAO = this.xCuestionarioHaqDAO;
        clasesHistoriaCE claseshistoriace = this.xClaseHC;
        List<CuestionarioHaqDTO> list = cuestionarioHaqDAO.listCuestionarioHAQ(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
        mCrearModelo();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId_Atencion()), x, 1);
            this.xmodelo.setValueAt(list.get(x).getId_Profesional(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getId_Especialidad(), x, 3);
            this.xmodelo.setValueAt(list.get(x).getFecha_Registro(), x, 4);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_1()), x, 5);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_2()), x, 6);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_3()), x, 7);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_4()), x, 8);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_5()), x, 9);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_6()), x, 10);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_7()), x, 11);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_8()), x, 12);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_9()), x, 13);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_10()), x, 14);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_11()), x, 15);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_12()), x, 16);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_13()), x, 17);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_14()), x, 18);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_15()), x, 19);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_16()), x, 20);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_17()), x, 21);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_18()), x, 22);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_19()), x, 23);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getPreg_20()), x, 24);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getGrup1_Vestirse_Asearse()), x, 25);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getGrup2_Levantarse()), x, 26);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getGrup3_Comer()), x, 27);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getGrup4_Caminar()), x, 28);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getGrup5_Higiene()), x, 29);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getGrup6_Alcanzar()), x, 30);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getGrup7_Prension()), x, 31);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getGrup8_Otras()), x, 32);
            if (list.get(x).getAct_1() == 1) {
                this.xmodelo.setValueAt(true, x, 33);
            } else {
                this.xmodelo.setValueAt(false, x, 33);
            }
            if (list.get(x).getAct_2() == 1) {
                this.xmodelo.setValueAt(true, x, 34);
            } else {
                this.xmodelo.setValueAt(false, x, 34);
            }
            if (list.get(x).getAct_3() == 1) {
                this.xmodelo.setValueAt(true, x, 35);
            } else {
                this.xmodelo.setValueAt(false, x, 35);
            }
            if (list.get(x).getAct_4() == 1) {
                this.xmodelo.setValueAt(true, x, 36);
            } else {
                this.xmodelo.setValueAt(false, x, 36);
            }
            if (list.get(x).getAct_5() == 1) {
                this.xmodelo.setValueAt(true, x, 37);
            } else {
                this.xmodelo.setValueAt(false, x, 37);
            }
            if (list.get(x).getAct_6() == 1) {
                this.xmodelo.setValueAt(true, x, 38);
            } else {
                this.xmodelo.setValueAt(false, x, 38);
            }
            if (list.get(x).getAct_7() == 1) {
                this.xmodelo.setValueAt(true, x, 39);
            } else {
                this.xmodelo.setValueAt(false, x, 39);
            }
            if (list.get(x).getAct_8() == 1) {
                this.xmodelo.setValueAt(true, x, 40);
            } else {
                this.xmodelo.setValueAt(false, x, 40);
            }
            if (list.get(x).getUten_1() == 1) {
                this.xmodelo.setValueAt(true, x, 41);
            } else {
                this.xmodelo.setValueAt(false, x, 41);
            }
            if (list.get(x).getUten_2() == 1) {
                this.xmodelo.setValueAt(true, x, 42);
            } else {
                this.xmodelo.setValueAt(false, x, 42);
            }
            if (list.get(x).getUten_3() == 1) {
                this.xmodelo.setValueAt(true, x, 43);
            } else {
                this.xmodelo.setValueAt(false, x, 43);
            }
            if (list.get(x).getUten_4() == 1) {
                this.xmodelo.setValueAt(true, x, 44);
            } else {
                this.xmodelo.setValueAt(false, x, 44);
            }
            if (list.get(x).getUten_5() == 1) {
                this.xmodelo.setValueAt(true, x, 45);
            } else {
                this.xmodelo.setValueAt(false, x, 45);
            }
            this.xmodelo.setValueAt(Double.valueOf(list.get(x).getClasificacion()), x, 46);
            this.xmodelo.setValueAt(list.get(x).getObservacion(), x, 47);
        }
    }

    /* JADX WARN: Type inference failed for: r3v581, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.btgPreg_1 = new ButtonGroup();
        this.btgPreg_2 = new ButtonGroup();
        this.btgPreg_3 = new ButtonGroup();
        this.btgPreg_4 = new ButtonGroup();
        this.btgPreg_5 = new ButtonGroup();
        this.btgPreg_6 = new ButtonGroup();
        this.btgPreg_7 = new ButtonGroup();
        this.btgPreg_8 = new ButtonGroup();
        this.btgPreg_9 = new ButtonGroup();
        this.btgPreg_10 = new ButtonGroup();
        this.btgPreg_11 = new ButtonGroup();
        this.btgPreg_12 = new ButtonGroup();
        this.btgPreg_13 = new ButtonGroup();
        this.btgPreg_14 = new ButtonGroup();
        this.btgPreg_15 = new ButtonGroup();
        this.btgPreg_16 = new ButtonGroup();
        this.btgPreg_17 = new ButtonGroup();
        this.btgPreg_18 = new ButtonGroup();
        this.btgPreg_19 = new ButtonGroup();
        this.btgPreg_20 = new ButtonGroup();
        this.JTPClasificacionEular = new JTabbedPane();
        this.jpCuestionario1 = new JPanel();
        this.jpVestirseAsearse = new JPanel();
        this.lblPreg_1 = new JLabel();
        this.jrbPreg_11 = new JRadioButton();
        this.jrbPreg_12 = new JRadioButton();
        this.jrbPreg_13 = new JRadioButton();
        this.jrbPreg_14 = new JRadioButton();
        this.lblPreg_2 = new JLabel();
        this.jrbPreg_21 = new JRadioButton();
        this.jrbPreg_22 = new JRadioButton();
        this.jrbPreg_23 = new JRadioButton();
        this.jrbPreg_24 = new JRadioButton();
        this.lblItem1 = new JLabel();
        this.lblItem2 = new JLabel();
        this.lblItem3 = new JLabel();
        this.lblItem4 = new JLabel();
        this.lblInicio = new JLabel();
        this.jpLevantarse = new JPanel();
        this.lblPreg_3 = new JLabel();
        this.jrbPreg_31 = new JRadioButton();
        this.jrbPreg_32 = new JRadioButton();
        this.jrbPreg_33 = new JRadioButton();
        this.jrbPreg_34 = new JRadioButton();
        this.lblPreg_4 = new JLabel();
        this.jrbPreg_41 = new JRadioButton();
        this.jrbPreg_42 = new JRadioButton();
        this.jrbPreg_43 = new JRadioButton();
        this.jrbPreg_44 = new JRadioButton();
        this.jpComer = new JPanel();
        this.lblPreg_5 = new JLabel();
        this.jrbPreg_51 = new JRadioButton();
        this.jrbPreg_52 = new JRadioButton();
        this.jrbPreg_53 = new JRadioButton();
        this.jrbPreg_54 = new JRadioButton();
        this.lblPreg_6 = new JLabel();
        this.jrbPreg_61 = new JRadioButton();
        this.jrbPreg_62 = new JRadioButton();
        this.jrbPreg_63 = new JRadioButton();
        this.jrbPreg_64 = new JRadioButton();
        this.lblPreg_7 = new JLabel();
        this.jrbPreg_71 = new JRadioButton();
        this.jrbPreg_72 = new JRadioButton();
        this.jrbPreg_73 = new JRadioButton();
        this.jrbPreg_74 = new JRadioButton();
        this.jpCuestionario2 = new JPanel();
        this.lblItem5 = new JLabel();
        this.lblItem6 = new JLabel();
        this.lblItem7 = new JLabel();
        this.lblItem8 = new JLabel();
        this.jpCaminar = new JPanel();
        this.lblPreg_8 = new JLabel();
        this.jrbPreg_81 = new JRadioButton();
        this.jrbPreg_82 = new JRadioButton();
        this.jrbPreg_83 = new JRadioButton();
        this.jrbPreg_84 = new JRadioButton();
        this.lblPreg_9 = new JLabel();
        this.jrbPreg_91 = new JRadioButton();
        this.jrbPreg_92 = new JRadioButton();
        this.jrbPreg_93 = new JRadioButton();
        this.jrbPreg_94 = new JRadioButton();
        this.jpHigiene = new JPanel();
        this.lblPreg_10 = new JLabel();
        this.jrbPreg_101 = new JRadioButton();
        this.jrbPreg_102 = new JRadioButton();
        this.jrbPreg_103 = new JRadioButton();
        this.jrbPreg_104 = new JRadioButton();
        this.lblPreg_11 = new JLabel();
        this.jrbPreg_111 = new JRadioButton();
        this.jrbPreg_112 = new JRadioButton();
        this.jrbPreg_113 = new JRadioButton();
        this.jrbPreg_114 = new JRadioButton();
        this.lblPreg_12 = new JLabel();
        this.jrbPreg_121 = new JRadioButton();
        this.jrbPreg_122 = new JRadioButton();
        this.jrbPreg_123 = new JRadioButton();
        this.jrbPreg_124 = new JRadioButton();
        this.jpAlcanzar = new JPanel();
        this.lblPreg_13 = new JLabel();
        this.jrbPreg_131 = new JRadioButton();
        this.jrbPreg_132 = new JRadioButton();
        this.jrbPreg_133 = new JRadioButton();
        this.jrbPreg_134 = new JRadioButton();
        this.lblPreg_14 = new JLabel();
        this.jrbPreg_141 = new JRadioButton();
        this.jrbPreg_142 = new JRadioButton();
        this.jrbPreg_143 = new JRadioButton();
        this.jrbPreg_144 = new JRadioButton();
        this.jpCuestionario3 = new JPanel();
        this.lblItem9 = new JLabel();
        this.lblItem10 = new JLabel();
        this.lblItem11 = new JLabel();
        this.lblItem12 = new JLabel();
        this.jpPrension = new JPanel();
        this.lblPreg_15 = new JLabel();
        this.jrbPreg_151 = new JRadioButton();
        this.jrbPreg_152 = new JRadioButton();
        this.jrbPreg_153 = new JRadioButton();
        this.jrbPreg_154 = new JRadioButton();
        this.lblPreg_16 = new JLabel();
        this.jrbPreg_161 = new JRadioButton();
        this.jrbPreg_162 = new JRadioButton();
        this.jrbPreg_163 = new JRadioButton();
        this.jrbPreg_164 = new JRadioButton();
        this.lblPreg_17 = new JLabel();
        this.jrbPreg_171 = new JRadioButton();
        this.jrbPreg_172 = new JRadioButton();
        this.jrbPreg_173 = new JRadioButton();
        this.jrbPreg_174 = new JRadioButton();
        this.jpOtras = new JPanel();
        this.lblPreg_18 = new JLabel();
        this.jrbPreg_181 = new JRadioButton();
        this.jrbPreg_182 = new JRadioButton();
        this.jrbPreg_183 = new JRadioButton();
        this.jrbPreg_184 = new JRadioButton();
        this.lblPreg_19 = new JLabel();
        this.jrbPreg_191 = new JRadioButton();
        this.jrbPreg_192 = new JRadioButton();
        this.jrbPreg_193 = new JRadioButton();
        this.jrbPreg_194 = new JRadioButton();
        this.lblPreg_20 = new JLabel();
        this.jrbPreg_201 = new JRadioButton();
        this.jrbPreg_202 = new JRadioButton();
        this.jrbPreg_203 = new JRadioButton();
        this.jrbPreg_204 = new JRadioButton();
        this.jpCuestionario4 = new JPanel();
        this.jpActividad = new JPanel();
        this.jcbAct_1 = new JCheckBox();
        this.jcbAct_2 = new JCheckBox();
        this.jcbAct_3 = new JCheckBox();
        this.jcbAct_4 = new JCheckBox();
        this.jcbAct_5 = new JCheckBox();
        this.jcbAct_6 = new JCheckBox();
        this.jcbAct_7 = new JCheckBox();
        this.jcbAct_8 = new JCheckBox();
        this.jpUtensilios = new JPanel();
        this.jcbUten_1 = new JCheckBox();
        this.jcbUten_2 = new JCheckBox();
        this.jcbUten_3 = new JCheckBox();
        this.jcbUten_4 = new JCheckBox();
        this.jcbUten_5 = new JCheckBox();
        this.JSPObserE = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.btnCalcular = new JButton();
        this.lblClasificacion = new JLabel();
        this.lblIdAtencion = new JLabel();
        this.jpHistorico = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.lblInicio2 = new JLabel();
        setName("xjpCuestionarioHAQ");
        setPreferredSize(new Dimension(800, 668));
        setRequestFocusEnabled(false);
        this.JTPClasificacionEular.setForeground(new Color(0, 102, 0));
        this.JTPClasificacionEular.setFont(new Font("Arial", 1, 14));
        this.JTPClasificacionEular.setName("");
        this.jpVestirseAsearse.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "VESTIRSE Y ASEARSE", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.lblPreg_1.setFont(new Font("Arial", 1, 12));
        this.lblPreg_1.setText("Pregunta 1");
        this.btgPreg_1.add(this.jrbPreg_11);
        this.jrbPreg_11.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_11.setName("0");
        this.jrbPreg_11.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.2
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_11ActionPerformed(evt);
            }
        });
        this.btgPreg_1.add(this.jrbPreg_12);
        this.jrbPreg_12.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_12.setName("1");
        this.jrbPreg_12.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.3
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_12ActionPerformed(evt);
            }
        });
        this.btgPreg_1.add(this.jrbPreg_13);
        this.jrbPreg_13.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_13.setName("2");
        this.jrbPreg_13.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.4
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_13ActionPerformed(evt);
            }
        });
        this.btgPreg_1.add(this.jrbPreg_14);
        this.jrbPreg_14.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_14.setName("3");
        this.jrbPreg_14.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.5
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_14ActionPerformed(evt);
            }
        });
        this.lblPreg_2.setFont(new Font("Arial", 1, 12));
        this.lblPreg_2.setText("Pregunta 1");
        this.btgPreg_2.add(this.jrbPreg_21);
        this.jrbPreg_21.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_21.setName("0");
        this.jrbPreg_21.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.6
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_21ActionPerformed(evt);
            }
        });
        this.btgPreg_2.add(this.jrbPreg_22);
        this.jrbPreg_22.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_22.setName("1");
        this.jrbPreg_22.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.7
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_22ActionPerformed(evt);
            }
        });
        this.btgPreg_2.add(this.jrbPreg_23);
        this.jrbPreg_23.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_23.setName("2");
        this.jrbPreg_23.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.8
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_23ActionPerformed(evt);
            }
        });
        this.btgPreg_2.add(this.jrbPreg_24);
        this.jrbPreg_24.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_24.setName("3");
        this.jrbPreg_24.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.9
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_24ActionPerformed(evt);
            }
        });
        GroupLayout jpVestirseAsearseLayout = new GroupLayout(this.jpVestirseAsearse);
        this.jpVestirseAsearse.setLayout(jpVestirseAsearseLayout);
        jpVestirseAsearseLayout.setHorizontalGroup(jpVestirseAsearseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpVestirseAsearseLayout.createSequentialGroup().addContainerGap().addGroup(jpVestirseAsearseLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblPreg_1, -2, 400, -2).addComponent(this.lblPreg_2, -2, 400, -2)).addGap(29, 29, 29).addGroup(jpVestirseAsearseLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jrbPreg_11, -2, 25, -2).addComponent(this.jrbPreg_21, -2, 25, -2)).addGap(60, 60, 60).addGroup(jpVestirseAsearseLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jpVestirseAsearseLayout.createSequentialGroup().addComponent(this.jrbPreg_12, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_13, -2, 25, -2)).addGroup(jpVestirseAsearseLayout.createSequentialGroup().addComponent(this.jrbPreg_22, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_23, -2, 25, -2))).addGap(60, 60, 60).addGroup(jpVestirseAsearseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_14, -2, 25, -2).addComponent(this.jrbPreg_24, -2, 25, -2)).addGap(21, 21, 21)));
        jpVestirseAsearseLayout.setVerticalGroup(jpVestirseAsearseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpVestirseAsearseLayout.createSequentialGroup().addComponent(this.lblPreg_1, -2, 40, -2).addGap(5, 5, 5).addComponent(this.lblPreg_2, -2, 40, -2)).addGroup(jpVestirseAsearseLayout.createSequentialGroup().addGroup(jpVestirseAsearseLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbPreg_14, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_11, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_12, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_13, GroupLayout.Alignment.TRAILING, -2, 40, -2)).addGap(5, 5, 5).addGroup(jpVestirseAsearseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_24, -2, 40, -2).addComponent(this.jrbPreg_21, -2, 40, -2).addComponent(this.jrbPreg_22, -2, 40, -2).addComponent(this.jrbPreg_23, -2, 40, -2))));
        this.lblItem1.setFont(new Font("Arial", 1, 12));
        this.lblItem1.setText("Sin Dificulta");
        this.lblItem2.setFont(new Font("Arial", 1, 12));
        this.lblItem2.setText("Sin Dificulta");
        this.lblItem3.setFont(new Font("Arial", 1, 12));
        this.lblItem3.setText("Sin Dificulta");
        this.lblItem4.setFont(new Font("Arial", 1, 12));
        this.lblItem4.setText("Sin Dificulta");
        this.lblInicio.setFont(new Font("Arial", 1, 12));
        this.lblInicio.setText("Pregunta 1");
        this.jpLevantarse.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "LEVANTARSE", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.lblPreg_3.setFont(new Font("Arial", 1, 12));
        this.lblPreg_3.setText("Pregunta 1");
        this.btgPreg_3.add(this.jrbPreg_31);
        this.jrbPreg_31.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_31.setName("0");
        this.jrbPreg_31.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.10
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_31ActionPerformed(evt);
            }
        });
        this.btgPreg_3.add(this.jrbPreg_32);
        this.jrbPreg_32.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_32.setName("1");
        this.jrbPreg_32.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.11
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_32ActionPerformed(evt);
            }
        });
        this.btgPreg_3.add(this.jrbPreg_33);
        this.jrbPreg_33.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_33.setName("2");
        this.jrbPreg_33.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.12
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_33ActionPerformed(evt);
            }
        });
        this.btgPreg_3.add(this.jrbPreg_34);
        this.jrbPreg_34.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_34.setName("3");
        this.jrbPreg_34.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.13
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_34ActionPerformed(evt);
            }
        });
        this.lblPreg_4.setFont(new Font("Arial", 1, 12));
        this.lblPreg_4.setText("Pregunta 1");
        this.btgPreg_4.add(this.jrbPreg_41);
        this.jrbPreg_41.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_41.setName("0");
        this.jrbPreg_41.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.14
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_41ActionPerformed(evt);
            }
        });
        this.btgPreg_4.add(this.jrbPreg_42);
        this.jrbPreg_42.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_42.setName("1");
        this.jrbPreg_42.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.15
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_42ActionPerformed(evt);
            }
        });
        this.btgPreg_4.add(this.jrbPreg_43);
        this.jrbPreg_43.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_43.setName("2");
        this.jrbPreg_43.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.16
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_43ActionPerformed(evt);
            }
        });
        this.btgPreg_4.add(this.jrbPreg_44);
        this.jrbPreg_44.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_44.setName("3");
        this.jrbPreg_44.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.17
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_44ActionPerformed(evt);
            }
        });
        GroupLayout jpLevantarseLayout = new GroupLayout(this.jpLevantarse);
        this.jpLevantarse.setLayout(jpLevantarseLayout);
        jpLevantarseLayout.setHorizontalGroup(jpLevantarseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpLevantarseLayout.createSequentialGroup().addContainerGap().addGroup(jpLevantarseLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblPreg_3, -2, 400, -2).addComponent(this.lblPreg_4, -2, 400, -2)).addGap(29, 29, 29).addGroup(jpLevantarseLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jrbPreg_31, -2, 25, -2).addComponent(this.jrbPreg_41, -2, 25, -2)).addGap(60, 60, 60).addGroup(jpLevantarseLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jpLevantarseLayout.createSequentialGroup().addComponent(this.jrbPreg_32, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_33, -2, 25, -2)).addGroup(jpLevantarseLayout.createSequentialGroup().addComponent(this.jrbPreg_42, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_43, -2, 25, -2))).addGap(60, 60, 60).addGroup(jpLevantarseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_34, -2, 25, -2).addComponent(this.jrbPreg_44, -2, 25, -2)).addGap(21, 21, 21)));
        jpLevantarseLayout.setVerticalGroup(jpLevantarseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpLevantarseLayout.createSequentialGroup().addComponent(this.lblPreg_3, -2, 40, -2).addGap(5, 5, 5).addComponent(this.lblPreg_4, -2, 40, -2)).addGroup(jpLevantarseLayout.createSequentialGroup().addGroup(jpLevantarseLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbPreg_34, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_31, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_32, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_33, GroupLayout.Alignment.TRAILING, -2, 40, -2)).addGap(5, 5, 5).addGroup(jpLevantarseLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_44, -2, 40, -2).addComponent(this.jrbPreg_41, -2, 40, -2).addComponent(this.jrbPreg_42, -2, 40, -2).addComponent(this.jrbPreg_43, -2, 40, -2))));
        this.jpComer.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "COMER", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.lblPreg_5.setFont(new Font("Arial", 1, 12));
        this.lblPreg_5.setText("Pregunta 1");
        this.btgPreg_5.add(this.jrbPreg_51);
        this.jrbPreg_51.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_51.setName("0");
        this.jrbPreg_51.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.18
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_51ActionPerformed(evt);
            }
        });
        this.btgPreg_5.add(this.jrbPreg_52);
        this.jrbPreg_52.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_52.setName("1");
        this.jrbPreg_52.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.19
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_52ActionPerformed(evt);
            }
        });
        this.btgPreg_5.add(this.jrbPreg_53);
        this.jrbPreg_53.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_53.setName("2");
        this.jrbPreg_53.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.20
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_53ActionPerformed(evt);
            }
        });
        this.btgPreg_5.add(this.jrbPreg_54);
        this.jrbPreg_54.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_54.setName("3");
        this.jrbPreg_54.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.21
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_54ActionPerformed(evt);
            }
        });
        this.lblPreg_6.setFont(new Font("Arial", 1, 12));
        this.lblPreg_6.setText("Pregunta 1");
        this.btgPreg_6.add(this.jrbPreg_61);
        this.jrbPreg_61.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_61.setName("0");
        this.jrbPreg_61.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.22
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_61ActionPerformed(evt);
            }
        });
        this.btgPreg_6.add(this.jrbPreg_62);
        this.jrbPreg_62.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_62.setName("1");
        this.jrbPreg_62.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.23
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_62ActionPerformed(evt);
            }
        });
        this.btgPreg_6.add(this.jrbPreg_63);
        this.jrbPreg_63.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_63.setName("2");
        this.jrbPreg_63.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.24
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_63ActionPerformed(evt);
            }
        });
        this.btgPreg_6.add(this.jrbPreg_64);
        this.jrbPreg_64.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_64.setName("3");
        this.jrbPreg_64.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.25
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_64ActionPerformed(evt);
            }
        });
        this.lblPreg_7.setFont(new Font("Arial", 1, 12));
        this.lblPreg_7.setText("Pregunta 1");
        this.btgPreg_7.add(this.jrbPreg_71);
        this.jrbPreg_71.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_71.setName("0");
        this.jrbPreg_71.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.26
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_71ActionPerformed(evt);
            }
        });
        this.btgPreg_7.add(this.jrbPreg_72);
        this.jrbPreg_72.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_72.setName("1");
        this.jrbPreg_72.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.27
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_72ActionPerformed(evt);
            }
        });
        this.btgPreg_7.add(this.jrbPreg_73);
        this.jrbPreg_73.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_73.setName("2");
        this.jrbPreg_73.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.28
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_73ActionPerformed(evt);
            }
        });
        this.btgPreg_7.add(this.jrbPreg_74);
        this.jrbPreg_74.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_74.setName("3");
        this.jrbPreg_74.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.29
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_74ActionPerformed(evt);
            }
        });
        GroupLayout jpComerLayout = new GroupLayout(this.jpComer);
        this.jpComer.setLayout(jpComerLayout);
        jpComerLayout.setHorizontalGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpComerLayout.createSequentialGroup().addContainerGap().addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblPreg_5, -2, 400, -2).addComponent(this.lblPreg_7, -2, 400, -2).addComponent(this.lblPreg_6, -2, 400, -2)).addGap(0, 0, 0).addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpComerLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jrbPreg_51, -2, 25, -2).addComponent(this.jrbPreg_61, -2, 25, -2)).addGap(60, 60, 60).addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jpComerLayout.createSequentialGroup().addComponent(this.jrbPreg_52, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_53, -2, 25, -2)).addGroup(jpComerLayout.createSequentialGroup().addComponent(this.jrbPreg_62, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_63, -2, 25, -2))).addGap(60, 60, 60).addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_54, -2, 25, -2).addComponent(this.jrbPreg_64, -2, 25, -2))).addGroup(GroupLayout.Alignment.TRAILING, jpComerLayout.createSequentialGroup().addComponent(this.jrbPreg_71, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_72, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_73, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_74, -2, 25, -2))).addGap(21, 21, 21)));
        jpComerLayout.setVerticalGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpComerLayout.createSequentialGroup().addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpComerLayout.createSequentialGroup().addComponent(this.lblPreg_5, -2, 40, -2).addGap(5, 5, 5).addComponent(this.lblPreg_6, -2, 40, -2)).addGroup(jpComerLayout.createSequentialGroup().addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbPreg_54, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_51, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_52, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_53, GroupLayout.Alignment.TRAILING, -2, 40, -2)).addGap(5, 5, 5).addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_64, -2, 40, -2).addComponent(this.jrbPreg_61, -2, 40, -2).addComponent(this.jrbPreg_62, -2, 40, -2).addComponent(this.jrbPreg_63, -2, 40, -2)))).addGap(1, 1, 1).addGroup(jpComerLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblPreg_7, -2, 40, -2).addComponent(this.jrbPreg_74, -2, 40, -2).addComponent(this.jrbPreg_71, -2, 40, -2).addComponent(this.jrbPreg_72, -2, 40, -2).addComponent(this.jrbPreg_73, -2, 40, -2)).addContainerGap()));
        GroupLayout jpCuestionario1Layout = new GroupLayout(this.jpCuestionario1);
        this.jpCuestionario1.setLayout(jpCuestionario1Layout);
        jpCuestionario1Layout.setHorizontalGroup(jpCuestionario1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario1Layout.createSequentialGroup().addGroup(jpCuestionario1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jpVestirseAsearse, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jpCuestionario1Layout.createSequentialGroup().addComponent(this.lblInicio, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.lblItem1, -2, 80, -2).addGap(7, 7, 7).addComponent(this.lblItem2, -2, 80, -2).addGap(7, 7, 7).addComponent(this.lblItem3, -2, 80, -2).addGap(7, 7, 7).addComponent(this.lblItem4, -2, 80, -2)).addComponent(this.jpLevantarse, -1, -1, 32767).addComponent(this.jpComer, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(20, 20, 20)));
        jpCuestionario1Layout.setVerticalGroup(jpCuestionario1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jpCuestionario1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblItem1, -2, 60, -2).addComponent(this.lblItem2, -2, 60, -2).addComponent(this.lblItem3, -2, 60, -2).addComponent(this.lblItem4, -2, 60, -2).addComponent(this.lblInicio, -2, 50, -2)).addGap(2, 2, 2).addComponent(this.jpVestirseAsearse, -2, -1, -2).addGap(2, 2, 2).addComponent(this.jpLevantarse, -2, -1, -2).addGap(2, 2, 2).addComponent(this.jpComer, -2, -1, -2).addGap(30, 30, 30)));
        this.JTPClasificacionEular.addTab("Parte 1", this.jpCuestionario1);
        this.lblItem5.setFont(new Font("Arial", 1, 12));
        this.lblItem5.setText("Sin Dificulta");
        this.lblItem6.setFont(new Font("Arial", 1, 12));
        this.lblItem6.setText("Sin Dificulta");
        this.lblItem7.setFont(new Font("Arial", 1, 12));
        this.lblItem7.setText("Sin Dificulta");
        this.lblItem8.setFont(new Font("Arial", 1, 12));
        this.lblItem8.setText("Sin Dificulta");
        this.jpCaminar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "CAMINAR", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.lblPreg_8.setFont(new Font("Arial", 1, 12));
        this.lblPreg_8.setText("Pregunta 1");
        this.btgPreg_8.add(this.jrbPreg_81);
        this.jrbPreg_81.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_81.setName("0");
        this.jrbPreg_81.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.30
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_81ActionPerformed(evt);
            }
        });
        this.btgPreg_8.add(this.jrbPreg_82);
        this.jrbPreg_82.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_82.setName("1");
        this.jrbPreg_82.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.31
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_82ActionPerformed(evt);
            }
        });
        this.btgPreg_8.add(this.jrbPreg_83);
        this.jrbPreg_83.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_83.setName("2");
        this.jrbPreg_83.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.32
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_83ActionPerformed(evt);
            }
        });
        this.btgPreg_8.add(this.jrbPreg_84);
        this.jrbPreg_84.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_84.setName("3");
        this.jrbPreg_84.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.33
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_84ActionPerformed(evt);
            }
        });
        this.lblPreg_9.setFont(new Font("Arial", 1, 12));
        this.lblPreg_9.setText("Pregunta 1");
        this.btgPreg_9.add(this.jrbPreg_91);
        this.jrbPreg_91.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_91.setName("0");
        this.jrbPreg_91.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.34
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_91ActionPerformed(evt);
            }
        });
        this.btgPreg_9.add(this.jrbPreg_92);
        this.jrbPreg_92.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_92.setName("1");
        this.jrbPreg_92.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.35
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_92ActionPerformed(evt);
            }
        });
        this.btgPreg_9.add(this.jrbPreg_93);
        this.jrbPreg_93.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_93.setName("2");
        this.jrbPreg_93.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.36
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_93ActionPerformed(evt);
            }
        });
        this.btgPreg_9.add(this.jrbPreg_94);
        this.jrbPreg_94.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_94.setName("3");
        this.jrbPreg_94.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.37
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_94ActionPerformed(evt);
            }
        });
        GroupLayout jpCaminarLayout = new GroupLayout(this.jpCaminar);
        this.jpCaminar.setLayout(jpCaminarLayout);
        jpCaminarLayout.setHorizontalGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCaminarLayout.createSequentialGroup().addContainerGap().addGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblPreg_8, -2, 400, -2).addComponent(this.lblPreg_9, -2, 400, -2)).addGap(29, 29, 29).addGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jrbPreg_81, -2, 25, -2).addComponent(this.jrbPreg_91, -2, 25, -2)).addGap(60, 60, 60).addGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jpCaminarLayout.createSequentialGroup().addComponent(this.jrbPreg_82, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_83, -2, 25, -2)).addGroup(jpCaminarLayout.createSequentialGroup().addComponent(this.jrbPreg_92, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_93, -2, 25, -2))).addGap(60, 60, 60).addGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_84, -2, 25, -2).addComponent(this.jrbPreg_94, -2, 25, -2)).addGap(21, 21, 21)));
        jpCaminarLayout.setVerticalGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCaminarLayout.createSequentialGroup().addGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCaminarLayout.createSequentialGroup().addComponent(this.lblPreg_8, -2, 40, -2).addGap(5, 5, 5).addComponent(this.lblPreg_9, -2, 40, -2)).addGroup(jpCaminarLayout.createSequentialGroup().addGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbPreg_84, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_81, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_82, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_83, GroupLayout.Alignment.TRAILING, -2, 40, -2)).addGap(5, 5, 5).addGroup(jpCaminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_94, -2, 40, -2).addComponent(this.jrbPreg_91, -2, 40, -2).addComponent(this.jrbPreg_92, -2, 40, -2).addComponent(this.jrbPreg_93, -2, 40, -2)))).addGap(0, 2, 32767)));
        this.jpHigiene.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "HIGIENE", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.lblPreg_10.setFont(new Font("Arial", 1, 12));
        this.lblPreg_10.setText("Pregunta 1");
        this.btgPreg_10.add(this.jrbPreg_101);
        this.jrbPreg_101.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_101.setName("0");
        this.jrbPreg_101.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.38
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_101ActionPerformed(evt);
            }
        });
        this.btgPreg_10.add(this.jrbPreg_102);
        this.jrbPreg_102.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_102.setName("1");
        this.jrbPreg_102.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.39
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_102ActionPerformed(evt);
            }
        });
        this.btgPreg_10.add(this.jrbPreg_103);
        this.jrbPreg_103.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_103.setName("2");
        this.jrbPreg_103.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.40
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_103ActionPerformed(evt);
            }
        });
        this.btgPreg_10.add(this.jrbPreg_104);
        this.jrbPreg_104.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_104.setName("3");
        this.jrbPreg_104.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.41
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_104ActionPerformed(evt);
            }
        });
        this.lblPreg_11.setFont(new Font("Arial", 1, 12));
        this.lblPreg_11.setText("Pregunta 1");
        this.btgPreg_11.add(this.jrbPreg_111);
        this.jrbPreg_111.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_111.setName("0");
        this.jrbPreg_111.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.42
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_111ActionPerformed(evt);
            }
        });
        this.btgPreg_11.add(this.jrbPreg_112);
        this.jrbPreg_112.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_112.setName("1");
        this.jrbPreg_112.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.43
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_112ActionPerformed(evt);
            }
        });
        this.btgPreg_11.add(this.jrbPreg_113);
        this.jrbPreg_113.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_113.setName("2");
        this.jrbPreg_113.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.44
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_113ActionPerformed(evt);
            }
        });
        this.btgPreg_11.add(this.jrbPreg_114);
        this.jrbPreg_114.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_114.setName("3");
        this.jrbPreg_114.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.45
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_114ActionPerformed(evt);
            }
        });
        this.lblPreg_12.setFont(new Font("Arial", 1, 12));
        this.lblPreg_12.setText("Pregunta 1");
        this.btgPreg_12.add(this.jrbPreg_121);
        this.jrbPreg_121.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_121.setName("0");
        this.jrbPreg_121.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.46
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_121ActionPerformed(evt);
            }
        });
        this.btgPreg_12.add(this.jrbPreg_122);
        this.jrbPreg_122.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_122.setName("1");
        this.jrbPreg_122.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.47
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_122ActionPerformed(evt);
            }
        });
        this.btgPreg_12.add(this.jrbPreg_123);
        this.jrbPreg_123.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_123.setName("2");
        this.jrbPreg_123.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.48
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_123ActionPerformed(evt);
            }
        });
        this.btgPreg_12.add(this.jrbPreg_124);
        this.jrbPreg_124.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_124.setName("3");
        this.jrbPreg_124.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.49
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_124ActionPerformed(evt);
            }
        });
        GroupLayout jpHigieneLayout = new GroupLayout(this.jpHigiene);
        this.jpHigiene.setLayout(jpHigieneLayout);
        jpHigieneLayout.setHorizontalGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHigieneLayout.createSequentialGroup().addContainerGap().addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblPreg_12, -2, 400, -2).addComponent(this.lblPreg_10, -2, 400, -2).addComponent(this.lblPreg_11, -2, 400, -2)).addGap(29, 29, 29).addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHigieneLayout.createSequentialGroup().addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jrbPreg_101, -2, 25, -2).addComponent(this.jrbPreg_111, -2, 25, -2)).addGap(60, 60, 60).addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jpHigieneLayout.createSequentialGroup().addComponent(this.jrbPreg_102, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_103, -2, 25, -2)).addGroup(jpHigieneLayout.createSequentialGroup().addComponent(this.jrbPreg_112, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_113, -2, 25, -2))).addGap(60, 60, 60).addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_104, -2, 25, -2).addComponent(this.jrbPreg_114, -2, 25, -2))).addGroup(jpHigieneLayout.createSequentialGroup().addComponent(this.jrbPreg_121, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_122, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_123, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_124, -2, 25, -2))).addGap(21, 21, 21)));
        jpHigieneLayout.setVerticalGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHigieneLayout.createSequentialGroup().addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHigieneLayout.createSequentialGroup().addComponent(this.lblPreg_10, -2, 40, -2).addGap(5, 5, 5).addComponent(this.lblPreg_11, -2, 40, -2)).addGroup(jpHigieneLayout.createSequentialGroup().addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbPreg_104, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_101, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_102, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_103, GroupLayout.Alignment.TRAILING, -2, 40, -2)).addGap(5, 5, 5).addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_114, -2, 40, -2).addComponent(this.jrbPreg_111, -2, 40, -2).addComponent(this.jrbPreg_112, -2, 40, -2).addComponent(this.jrbPreg_113, -2, 40, -2)))).addGap(1, 1, 1).addGroup(jpHigieneLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblPreg_12, -2, 40, -2).addComponent(this.jrbPreg_124, -2, 40, -2).addComponent(this.jrbPreg_121, -2, 40, -2).addComponent(this.jrbPreg_122, -2, 40, -2).addComponent(this.jrbPreg_123, -2, 40, -2)).addContainerGap()));
        this.jpAlcanzar.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "ALCANZAR", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.lblPreg_13.setFont(new Font("Arial", 1, 12));
        this.lblPreg_13.setText("Pregunta 1");
        this.btgPreg_13.add(this.jrbPreg_131);
        this.jrbPreg_131.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_131.setName("0");
        this.jrbPreg_131.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.50
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_131ActionPerformed(evt);
            }
        });
        this.btgPreg_13.add(this.jrbPreg_132);
        this.jrbPreg_132.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_132.setName("1");
        this.jrbPreg_132.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.51
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_132ActionPerformed(evt);
            }
        });
        this.btgPreg_13.add(this.jrbPreg_133);
        this.jrbPreg_133.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_133.setName("2");
        this.jrbPreg_133.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.52
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_133ActionPerformed(evt);
            }
        });
        this.btgPreg_13.add(this.jrbPreg_134);
        this.jrbPreg_134.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_134.setName("3");
        this.jrbPreg_134.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.53
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_134ActionPerformed(evt);
            }
        });
        this.lblPreg_14.setFont(new Font("Arial", 1, 12));
        this.lblPreg_14.setText("Pregunta 1");
        this.btgPreg_14.add(this.jrbPreg_141);
        this.jrbPreg_141.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_141.setName("0");
        this.jrbPreg_141.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.54
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_141ActionPerformed(evt);
            }
        });
        this.btgPreg_14.add(this.jrbPreg_142);
        this.jrbPreg_142.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_142.setName("1");
        this.jrbPreg_142.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.55
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_142ActionPerformed(evt);
            }
        });
        this.btgPreg_14.add(this.jrbPreg_143);
        this.jrbPreg_143.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_143.setName("2");
        this.jrbPreg_143.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.56
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_143ActionPerformed(evt);
            }
        });
        this.btgPreg_14.add(this.jrbPreg_144);
        this.jrbPreg_144.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_144.setName("3");
        this.jrbPreg_144.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.57
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_144ActionPerformed(evt);
            }
        });
        GroupLayout jpAlcanzarLayout = new GroupLayout(this.jpAlcanzar);
        this.jpAlcanzar.setLayout(jpAlcanzarLayout);
        jpAlcanzarLayout.setHorizontalGroup(jpAlcanzarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpAlcanzarLayout.createSequentialGroup().addContainerGap().addGroup(jpAlcanzarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpAlcanzarLayout.createSequentialGroup().addComponent(this.lblPreg_14, -2, 400, -2).addGap(29, 29, 29).addComponent(this.jrbPreg_141, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_142, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_143, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_144, -2, 25, -2)).addGroup(jpAlcanzarLayout.createSequentialGroup().addComponent(this.lblPreg_13, -2, 400, -2).addGap(29, 29, 29).addComponent(this.jrbPreg_131, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_132, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_133, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_134, -2, 25, -2))).addGap(21, 21, 21)));
        jpAlcanzarLayout.setVerticalGroup(jpAlcanzarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jpAlcanzarLayout.createSequentialGroup().addGroup(jpAlcanzarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblPreg_13, -2, 40, -2).addGroup(jpAlcanzarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbPreg_134, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_131, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_132, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_133, GroupLayout.Alignment.TRAILING, -2, 40, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jpAlcanzarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblPreg_14, -2, 40, -2).addComponent(this.jrbPreg_144, -2, 40, -2).addComponent(this.jrbPreg_141, -2, 40, -2).addComponent(this.jrbPreg_142, -2, 40, -2).addComponent(this.jrbPreg_143, -2, 40, -2)).addContainerGap()));
        GroupLayout jpCuestionario2Layout = new GroupLayout(this.jpCuestionario2);
        this.jpCuestionario2.setLayout(jpCuestionario2Layout);
        jpCuestionario2Layout.setHorizontalGroup(jpCuestionario2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario2Layout.createSequentialGroup().addGroup(jpCuestionario2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jpCuestionario2Layout.createSequentialGroup().addGap(18, 437, 32767).addComponent(this.lblItem5, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblItem6, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblItem7, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblItem8, -2, 80, -2)).addGroup(GroupLayout.Alignment.TRAILING, jpCuestionario2Layout.createSequentialGroup().addContainerGap().addGroup(jpCuestionario2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jpCaminar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jpHigiene, -1, -1, 32767).addComponent(this.jpAlcanzar, GroupLayout.Alignment.LEADING, -1, -1, 32767)))).addContainerGap()));
        jpCuestionario2Layout.setVerticalGroup(jpCuestionario2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario2Layout.createSequentialGroup().addGroup(jpCuestionario2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblItem5, -2, 60, -2).addComponent(this.lblItem6, -2, 60, -2).addComponent(this.lblItem7, -2, 60, -2).addComponent(this.lblItem8, -2, 60, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpCaminar, -2, -1, -2).addGap(2, 2, 2).addComponent(this.jpHigiene, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpAlcanzar, -2, -1, -2).addGap(39, 39, 39)));
        this.JTPClasificacionEular.addTab("Parte 2", this.jpCuestionario2);
        this.lblItem9.setFont(new Font("Arial", 1, 12));
        this.lblItem9.setText("Sin Dificulta");
        this.lblItem10.setFont(new Font("Arial", 1, 12));
        this.lblItem10.setText("Sin Dificulta");
        this.lblItem11.setFont(new Font("Arial", 1, 12));
        this.lblItem11.setText("Sin Dificulta");
        this.lblItem12.setFont(new Font("Arial", 1, 12));
        this.lblItem12.setText("Sin Dificulta");
        this.jpPrension.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PRENSIÓN", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.lblPreg_15.setFont(new Font("Arial", 1, 12));
        this.lblPreg_15.setText("Pregunta 1");
        this.btgPreg_15.add(this.jrbPreg_151);
        this.jrbPreg_151.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_151.setName("0");
        this.jrbPreg_151.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.58
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_151ActionPerformed(evt);
            }
        });
        this.btgPreg_15.add(this.jrbPreg_152);
        this.jrbPreg_152.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_152.setName("1");
        this.jrbPreg_152.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.59
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_152ActionPerformed(evt);
            }
        });
        this.btgPreg_15.add(this.jrbPreg_153);
        this.jrbPreg_153.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_153.setName("2");
        this.jrbPreg_153.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.60
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_153ActionPerformed(evt);
            }
        });
        this.btgPreg_15.add(this.jrbPreg_154);
        this.jrbPreg_154.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_154.setName("3");
        this.jrbPreg_154.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.61
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_154ActionPerformed(evt);
            }
        });
        this.lblPreg_16.setFont(new Font("Arial", 1, 12));
        this.lblPreg_16.setText("Pregunta 1");
        this.btgPreg_16.add(this.jrbPreg_161);
        this.jrbPreg_161.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_161.setName("0");
        this.jrbPreg_161.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.62
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_161ActionPerformed(evt);
            }
        });
        this.btgPreg_16.add(this.jrbPreg_162);
        this.jrbPreg_162.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_162.setName("1");
        this.jrbPreg_162.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.63
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_162ActionPerformed(evt);
            }
        });
        this.btgPreg_16.add(this.jrbPreg_163);
        this.jrbPreg_163.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_163.setName("2");
        this.jrbPreg_163.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.64
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_163ActionPerformed(evt);
            }
        });
        this.btgPreg_16.add(this.jrbPreg_164);
        this.jrbPreg_164.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_164.setName("3");
        this.jrbPreg_164.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.65
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_164ActionPerformed(evt);
            }
        });
        this.lblPreg_17.setFont(new Font("Arial", 1, 12));
        this.lblPreg_17.setText("Pregunta 1");
        this.btgPreg_17.add(this.jrbPreg_171);
        this.jrbPreg_171.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_171.setName("0");
        this.jrbPreg_171.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.66
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_171ActionPerformed(evt);
            }
        });
        this.btgPreg_17.add(this.jrbPreg_172);
        this.jrbPreg_172.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_172.setName("1");
        this.jrbPreg_172.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.67
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_172ActionPerformed(evt);
            }
        });
        this.btgPreg_17.add(this.jrbPreg_173);
        this.jrbPreg_173.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_173.setName("2");
        this.jrbPreg_173.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.68
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_173ActionPerformed(evt);
            }
        });
        this.btgPreg_17.add(this.jrbPreg_174);
        this.jrbPreg_174.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_174.setName("3");
        this.jrbPreg_174.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.69
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_174ActionPerformed(evt);
            }
        });
        GroupLayout jpPrensionLayout = new GroupLayout(this.jpPrension);
        this.jpPrension.setLayout(jpPrensionLayout);
        jpPrensionLayout.setHorizontalGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpPrensionLayout.createSequentialGroup().addContainerGap().addGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpPrensionLayout.createSequentialGroup().addComponent(this.lblPreg_15, -2, 400, -2).addGap(29, 29, 29).addComponent(this.jrbPreg_151, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_152, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_153, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_154, -2, 25, -2)).addGroup(jpPrensionLayout.createSequentialGroup().addGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblPreg_17, -2, 400, -2).addComponent(this.lblPreg_16, -2, 400, -2)).addGap(29, 29, 29).addGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpPrensionLayout.createSequentialGroup().addComponent(this.jrbPreg_161, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_162, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_163, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_164, -2, 25, -2)).addGroup(jpPrensionLayout.createSequentialGroup().addComponent(this.jrbPreg_171, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_172, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_173, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_174, -2, 25, -2))))).addContainerGap()));
        jpPrensionLayout.setVerticalGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpPrensionLayout.createSequentialGroup().addGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblPreg_15, -2, 40, -2).addGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbPreg_154, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_151, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_152, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_153, GroupLayout.Alignment.TRAILING, -2, 40, -2))).addGap(2, 2, 2).addGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblPreg_16, -2, 40, -2).addComponent(this.jrbPreg_164, -2, 40, -2).addComponent(this.jrbPreg_161, -2, 40, -2).addComponent(this.jrbPreg_162, -2, 40, -2).addComponent(this.jrbPreg_163, -2, 40, -2)).addGap(1, 1, 1).addGroup(jpPrensionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblPreg_17, -2, 40, -2).addComponent(this.jrbPreg_174, -2, 40, -2).addComponent(this.jrbPreg_171, -2, 40, -2).addComponent(this.jrbPreg_172, -2, 40, -2).addComponent(this.jrbPreg_173, -2, 40, -2)).addContainerGap()));
        this.jpOtras.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "PRENSIÓN", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.lblPreg_18.setFont(new Font("Arial", 1, 12));
        this.lblPreg_18.setText("Pregunta 1");
        this.btgPreg_18.add(this.jrbPreg_181);
        this.jrbPreg_181.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_181.setName("0");
        this.jrbPreg_181.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.70
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_181ActionPerformed(evt);
            }
        });
        this.btgPreg_18.add(this.jrbPreg_182);
        this.jrbPreg_182.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_182.setName("1");
        this.jrbPreg_182.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.71
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_182ActionPerformed(evt);
            }
        });
        this.btgPreg_18.add(this.jrbPreg_183);
        this.jrbPreg_183.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_183.setName("2");
        this.jrbPreg_183.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.72
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_183ActionPerformed(evt);
            }
        });
        this.btgPreg_18.add(this.jrbPreg_184);
        this.jrbPreg_184.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_184.setName("3");
        this.jrbPreg_184.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.73
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_184ActionPerformed(evt);
            }
        });
        this.lblPreg_19.setFont(new Font("Arial", 1, 12));
        this.lblPreg_19.setText("Pregunta 1");
        this.btgPreg_19.add(this.jrbPreg_191);
        this.jrbPreg_191.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_191.setName("0");
        this.jrbPreg_191.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.74
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_191ActionPerformed(evt);
            }
        });
        this.btgPreg_19.add(this.jrbPreg_192);
        this.jrbPreg_192.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_192.setName("1");
        this.jrbPreg_192.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.75
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_192ActionPerformed(evt);
            }
        });
        this.btgPreg_19.add(this.jrbPreg_193);
        this.jrbPreg_193.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_193.setName("2");
        this.jrbPreg_193.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.76
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_193ActionPerformed(evt);
            }
        });
        this.btgPreg_19.add(this.jrbPreg_194);
        this.jrbPreg_194.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_194.setName("3");
        this.jrbPreg_194.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.77
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_194ActionPerformed(evt);
            }
        });
        this.lblPreg_20.setFont(new Font("Arial", 1, 12));
        this.lblPreg_20.setText("Pregunta 1");
        this.btgPreg_20.add(this.jrbPreg_201);
        this.jrbPreg_201.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_201.setName("0");
        this.jrbPreg_201.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.78
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_201ActionPerformed(evt);
            }
        });
        this.btgPreg_20.add(this.jrbPreg_202);
        this.jrbPreg_202.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_202.setName("1");
        this.jrbPreg_202.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.79
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_202ActionPerformed(evt);
            }
        });
        this.btgPreg_20.add(this.jrbPreg_203);
        this.jrbPreg_203.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_203.setName("2");
        this.jrbPreg_203.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.80
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_203ActionPerformed(evt);
            }
        });
        this.btgPreg_20.add(this.jrbPreg_204);
        this.jrbPreg_204.setFont(new Font("Arial", 1, 12));
        this.jrbPreg_204.setName("3");
        this.jrbPreg_204.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.81
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jrbPreg_204ActionPerformed(evt);
            }
        });
        GroupLayout jpOtrasLayout = new GroupLayout(this.jpOtras);
        this.jpOtras.setLayout(jpOtrasLayout);
        jpOtrasLayout.setHorizontalGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpOtrasLayout.createSequentialGroup().addContainerGap().addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.lblPreg_20, -2, 400, -2).addComponent(this.lblPreg_18, -2, 400, -2).addComponent(this.lblPreg_19, -2, 400, -2)).addGap(29, 29, 29).addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpOtrasLayout.createSequentialGroup().addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jrbPreg_181, -2, 25, -2).addComponent(this.jrbPreg_191, -2, 25, -2)).addGap(60, 60, 60).addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jpOtrasLayout.createSequentialGroup().addComponent(this.jrbPreg_182, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_183, -2, 25, -2)).addGroup(jpOtrasLayout.createSequentialGroup().addComponent(this.jrbPreg_192, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_193, -2, 25, -2))).addGap(60, 60, 60).addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_184, -2, 25, -2).addComponent(this.jrbPreg_194, -2, 25, -2))).addGroup(jpOtrasLayout.createSequentialGroup().addComponent(this.jrbPreg_201, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_202, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_203, -2, 25, -2).addGap(60, 60, 60).addComponent(this.jrbPreg_204, -2, 25, -2))).addContainerGap(34, 32767)));
        jpOtrasLayout.setVerticalGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpOtrasLayout.createSequentialGroup().addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpOtrasLayout.createSequentialGroup().addComponent(this.lblPreg_18, -2, 40, -2).addGap(5, 5, 5).addComponent(this.lblPreg_19, -2, 40, -2)).addGroup(jpOtrasLayout.createSequentialGroup().addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jrbPreg_184, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_181, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_182, GroupLayout.Alignment.TRAILING, -2, 40, -2).addComponent(this.jrbPreg_183, GroupLayout.Alignment.TRAILING, -2, 40, -2)).addGap(5, 5, 5).addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jrbPreg_194, -2, 40, -2).addComponent(this.jrbPreg_191, -2, 40, -2).addComponent(this.jrbPreg_192, -2, 40, -2).addComponent(this.jrbPreg_193, -2, 40, -2)))).addGap(1, 1, 1).addGroup(jpOtrasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblPreg_20, -2, 40, -2).addComponent(this.jrbPreg_204, -2, 40, -2).addComponent(this.jrbPreg_201, -2, 40, -2).addComponent(this.jrbPreg_202, -2, 40, -2).addComponent(this.jrbPreg_203, -2, 40, -2)).addGap(2, 2, 2)));
        GroupLayout jpCuestionario3Layout = new GroupLayout(this.jpCuestionario3);
        this.jpCuestionario3.setLayout(jpCuestionario3Layout);
        jpCuestionario3Layout.setHorizontalGroup(jpCuestionario3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario3Layout.createSequentialGroup().addContainerGap().addGroup(jpCuestionario3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario3Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.lblItem9, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblItem10, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblItem11, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblItem12, -2, 80, -2).addGap(18, 18, 18)).addGroup(GroupLayout.Alignment.TRAILING, jpCuestionario3Layout.createSequentialGroup().addGroup(jpCuestionario3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jpOtras, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jpPrension, -1, -1, 32767)).addContainerGap()))));
        jpCuestionario3Layout.setVerticalGroup(jpCuestionario3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario3Layout.createSequentialGroup().addGroup(jpCuestionario3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.lblItem9, -2, 60, -2).addComponent(this.lblItem10, -2, 60, -2).addComponent(this.lblItem11, -2, 60, -2).addComponent(this.lblItem12, -2, 60, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpPrension, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jpOtras, -2, -1, -2).addGap(0, 105, 32767)));
        this.JTPClasificacionEular.addTab("Parte 3", this.jpCuestionario3);
        this.jpActividad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Señale para qué actividades necesita la ayuda de otra persona:  ", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.jcbAct_1.setFont(new Font("Arial", 1, 12));
        this.jcbAct_1.setText(" Vestirse, asearse");
        this.jcbAct_1.setName("2");
        this.jcbAct_1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.82
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbAct_1ActionPerformed(evt);
            }
        });
        this.jcbAct_2.setFont(new Font("Arial", 1, 12));
        this.jcbAct_2.setText("Levantarse");
        this.jcbAct_2.setName("2");
        this.jcbAct_2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.83
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbAct_2ActionPerformed(evt);
            }
        });
        this.jcbAct_3.setFont(new Font("Arial", 1, 12));
        this.jcbAct_3.setText("Comer");
        this.jcbAct_3.setName("2");
        this.jcbAct_3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.84
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbAct_3ActionPerformed(evt);
            }
        });
        this.jcbAct_4.setFont(new Font("Arial", 1, 12));
        this.jcbAct_4.setText("Caminar, pasear");
        this.jcbAct_4.setName("2");
        this.jcbAct_4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.85
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbAct_4ActionPerformed(evt);
            }
        });
        this.jcbAct_5.setFont(new Font("Arial", 1, 12));
        this.jcbAct_5.setText("Higiene personal");
        this.jcbAct_5.setName("2");
        this.jcbAct_5.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.86
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbAct_5ActionPerformed(evt);
            }
        });
        this.jcbAct_6.setFont(new Font("Arial", 1, 12));
        this.jcbAct_6.setText("Alcanzar");
        this.jcbAct_6.setName("2");
        this.jcbAct_6.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.87
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbAct_6ActionPerformed(evt);
            }
        });
        this.jcbAct_7.setFont(new Font("Arial", 1, 12));
        this.jcbAct_7.setText("Abrir y cerrar cosas (prensión)");
        this.jcbAct_7.setName("2");
        this.jcbAct_7.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.88
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbAct_7ActionPerformed(evt);
            }
        });
        this.jcbAct_8.setFont(new Font("Arial", 1, 12));
        this.jcbAct_8.setText("Recados  y  tareas  de  casa");
        this.jcbAct_8.setName("2");
        this.jcbAct_8.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.89
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbAct_8ActionPerformed(evt);
            }
        });
        GroupLayout jpActividadLayout = new GroupLayout(this.jpActividad);
        this.jpActividad.setLayout(jpActividadLayout);
        jpActividadLayout.setHorizontalGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpActividadLayout.createSequentialGroup().addContainerGap().addGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jcbAct_1).addComponent(this.jcbAct_2).addComponent(this.jcbAct_3)).addGap(18, 18, 18).addGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpActividadLayout.createSequentialGroup().addGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jcbAct_4, -1, 128, 32767).addComponent(this.jcbAct_5, -1, -1, 32767)).addGap(18, 18, 18).addGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jcbAct_8).addComponent(this.jcbAct_7, -2, 212, -2))).addComponent(this.jcbAct_6, -2, 120, -2)).addContainerGap(-1, 32767)));
        jpActividadLayout.setVerticalGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpActividadLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jcbAct_1).addComponent(this.jcbAct_4).addComponent(this.jcbAct_7)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jcbAct_2).addComponent(this.jcbAct_5).addComponent(this.jcbAct_8)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jpActividadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jcbAct_3).addComponent(this.jcbAct_6))));
        this.jpUtensilios.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Señale si utiliza alguno de estos utensilios habitualmente:", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.jcbUten_1.setFont(new Font("Arial", 1, 12));
        this.jcbUten_1.setText("Cubiertos de mango ancho");
        this.jcbUten_1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.90
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbUten_1ActionPerformed(evt);
            }
        });
        this.jcbUten_2.setFont(new Font("Arial", 1, 12));
        this.jcbUten_2.setText("Asiento o barra especial para el baño ");
        this.jcbUten_2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.91
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbUten_2ActionPerformed(evt);
            }
        });
        this.jcbUten_3.setFont(new Font("Arial", 1, 12));
        this.jcbUten_3.setText("Abridor  para  tarros  previamente  abiertos");
        this.jcbUten_3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.92
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbUten_3ActionPerformed(evt);
            }
        });
        this.jcbUten_4.setFont(new Font("Arial", 1, 12));
        this.jcbUten_4.setText("Bastón, muletas, andador o silla de ruedas");
        this.jcbUten_4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.93
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbUten_4ActionPerformed(evt);
            }
        });
        this.jcbUten_5.setFont(new Font("Arial", 1, 12));
        this.jcbUten_5.setText("Asiento alto para el retrete");
        this.jcbUten_5.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.94
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.jcbUten_5ActionPerformed(evt);
            }
        });
        GroupLayout jpUtensiliosLayout = new GroupLayout(this.jpUtensilios);
        this.jpUtensilios.setLayout(jpUtensiliosLayout);
        jpUtensiliosLayout.setHorizontalGroup(jpUtensiliosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpUtensiliosLayout.createSequentialGroup().addContainerGap().addGroup(jpUtensiliosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpUtensiliosLayout.createSequentialGroup().addGroup(jpUtensiliosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jcbUten_1).addComponent(this.jcbUten_2)).addGap(145, 145, 145).addGroup(jpUtensiliosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jcbUten_5).addComponent(this.jcbUten_4))).addComponent(this.jcbUten_3)).addContainerGap(108, 32767)));
        jpUtensiliosLayout.setVerticalGroup(jpUtensiliosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpUtensiliosLayout.createSequentialGroup().addContainerGap(13, 32767).addGroup(jpUtensiliosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jcbUten_1).addComponent(this.jcbUten_4, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jpUtensiliosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jcbUten_2).addComponent(this.jcbUten_5)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jcbUten_3).addGap(4, 4, 4)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setTabSize(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObserE.setViewportView(this.JTAObservacion);
        this.btnCalcular.setFont(new Font("Arial", 1, 12));
        this.btnCalcular.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Calcular.png")));
        this.btnCalcular.setText("Calcular");
        this.btnCalcular.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.95
            public void actionPerformed(ActionEvent evt) {
                JPCuestionarioHAQ.this.btnCalcularActionPerformed(evt);
            }
        });
        this.lblClasificacion.setFont(new Font("Arial", 1, 18));
        this.lblClasificacion.setForeground(Color.red);
        this.lblClasificacion.setHorizontalAlignment(0);
        this.lblClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.lblIdAtencion.setFont(new Font("Arial", 1, 14));
        this.lblIdAtencion.setForeground(Color.red);
        this.lblIdAtencion.setHorizontalAlignment(0);
        this.lblIdAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "No Atención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jpCuestionario4Layout = new GroupLayout(this.jpCuestionario4);
        this.jpCuestionario4.setLayout(jpCuestionario4Layout);
        jpCuestionario4Layout.setHorizontalGroup(jpCuestionario4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jpActividad, -1, -1, 32767).addComponent(this.jpUtensilios, -1, -1, 32767).addGroup(jpCuestionario4Layout.createSequentialGroup().addGroup(jpCuestionario4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario4Layout.createSequentialGroup().addComponent(this.btnCalcular, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.lblClasificacion, -2, 267, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblIdAtencion, -1, -1, 32767)).addComponent(this.JSPObserE, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        jpCuestionario4Layout.setVerticalGroup(jpCuestionario4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpCuestionario4Layout.createSequentialGroup().addComponent(this.jpActividad, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jpUtensilios, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jpCuestionario4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnCalcular, -1, -1, 32767).addComponent(this.lblClasificacion, -1, -1, 32767).addComponent(this.lblIdAtencion, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObserE, -2, 137, -2).addGap(100, 100, 100)));
        this.JTPClasificacionEular.addTab("Parte 4", this.jpCuestionario4);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setAutoResizeMode(0);
        this.JTBDetalle.setColumnSelectionAllowed(true);
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPCuestionarioHAQ.96
            public void mouseClicked(MouseEvent evt) {
                JPCuestionarioHAQ.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout jpHistoricoLayout = new GroupLayout(this.jpHistorico);
        this.jpHistorico.setLayout(jpHistoricoLayout);
        jpHistoricoLayout.setHorizontalGroup(jpHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 773, 32767)));
        jpHistoricoLayout.setVerticalGroup(jpHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jpHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 463, 32767).addContainerGap()));
        this.JTPClasificacionEular.addTab("HISTÓRICO", this.jpHistorico);
        this.lblInicio2.setFont(new Font("Arial", 1, 18));
        this.lblInicio2.setForeground(Color.red);
        this.lblInicio2.setHorizontalAlignment(0);
        this.lblInicio2.setText("CUESTIONARIO DE DISCAPACIDAD HAQ");
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPClasificacionEular, -2, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.lblInicio2, -2, 778, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.lblInicio2, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPClasificacionEular, -2, 520, -2).addGap(41, 41, 41)));
        this.JTPClasificacionEular.getAccessibleContext().setAccessibleName("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            this.lblIdAtencion.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(0)) {
                this.jrbPreg_11.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(1)) {
                this.jrbPreg_12.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(2)) {
                this.jrbPreg_13.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).equals(3)) {
                this.jrbPreg_14.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).equals(0)) {
                this.jrbPreg_21.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).equals(1)) {
                this.jrbPreg_22.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).equals(2)) {
                this.jrbPreg_23.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).equals(3)) {
                this.jrbPreg_24.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).equals(0)) {
                this.jrbPreg_31.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).equals(1)) {
                this.jrbPreg_32.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).equals(2)) {
                this.jrbPreg_33.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).equals(3)) {
                this.jrbPreg_34.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals(0)) {
                this.jrbPreg_41.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals(1)) {
                this.jrbPreg_42.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals(2)) {
                this.jrbPreg_43.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).equals(3)) {
                this.jrbPreg_44.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 9).equals(0)) {
                this.jrbPreg_51.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 9).equals(1)) {
                this.jrbPreg_52.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 9).equals(2)) {
                this.jrbPreg_53.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 9).equals(3)) {
                this.jrbPreg_54.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 10).equals(0)) {
                this.jrbPreg_61.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 10).equals(1)) {
                this.jrbPreg_62.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 10).equals(2)) {
                this.jrbPreg_63.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 10).equals(3)) {
                this.jrbPreg_64.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 11).equals(0)) {
                this.jrbPreg_71.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 11).equals(1)) {
                this.jrbPreg_72.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 11).equals(2)) {
                this.jrbPreg_73.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 11).equals(3)) {
                this.jrbPreg_74.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 12).equals(0)) {
                this.jrbPreg_81.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 12).equals(1)) {
                this.jrbPreg_82.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 12).equals(2)) {
                this.jrbPreg_83.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 12).equals(3)) {
                this.jrbPreg_84.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 13).equals(0)) {
                this.jrbPreg_91.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 13).equals(1)) {
                this.jrbPreg_92.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 13).equals(2)) {
                this.jrbPreg_93.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 13).equals(3)) {
                this.jrbPreg_94.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 14).equals(0)) {
                this.jrbPreg_101.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 14).equals(1)) {
                this.jrbPreg_102.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 14).equals(2)) {
                this.jrbPreg_103.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 14).equals(3)) {
                this.jrbPreg_104.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 15).equals(0)) {
                this.jrbPreg_111.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 15).equals(1)) {
                this.jrbPreg_112.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 15).equals(2)) {
                this.jrbPreg_113.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 15).equals(3)) {
                this.jrbPreg_114.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 16).equals(0)) {
                this.jrbPreg_121.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 16).equals(1)) {
                this.jrbPreg_122.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 16).equals(2)) {
                this.jrbPreg_123.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 16).equals(3)) {
                this.jrbPreg_124.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 17).equals(0)) {
                this.jrbPreg_131.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 17).equals(1)) {
                this.jrbPreg_132.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 17).equals(2)) {
                this.jrbPreg_133.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 17).equals(3)) {
                this.jrbPreg_134.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 18).equals(0)) {
                this.jrbPreg_141.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 18).equals(1)) {
                this.jrbPreg_142.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 18).equals(2)) {
                this.jrbPreg_143.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 18).equals(3)) {
                this.jrbPreg_144.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 19).equals(0)) {
                this.jrbPreg_151.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 19).equals(1)) {
                this.jrbPreg_152.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 19).equals(2)) {
                this.jrbPreg_153.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 19).equals(3)) {
                this.jrbPreg_154.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 20).equals(0)) {
                this.jrbPreg_161.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 20).equals(1)) {
                this.jrbPreg_162.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 20).equals(2)) {
                this.jrbPreg_163.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 20).equals(3)) {
                this.jrbPreg_164.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 21).equals(0)) {
                this.jrbPreg_171.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 21).equals(1)) {
                this.jrbPreg_172.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 21).equals(2)) {
                this.jrbPreg_173.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 21).equals(3)) {
                this.jrbPreg_174.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 22).equals(0)) {
                this.jrbPreg_181.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 22).equals(1)) {
                this.jrbPreg_182.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 22).equals(2)) {
                this.jrbPreg_183.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 22).equals(3)) {
                this.jrbPreg_184.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 23).equals(0)) {
                this.jrbPreg_191.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 23).equals(1)) {
                this.jrbPreg_192.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 23).equals(2)) {
                this.jrbPreg_193.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 23).equals(3)) {
                this.jrbPreg_194.setSelected(true);
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 24).equals(0)) {
                this.jrbPreg_201.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 24).equals(1)) {
                this.jrbPreg_202.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 24).equals(2)) {
                this.jrbPreg_203.setSelected(true);
            } else if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 24).equals(3)) {
                this.jrbPreg_204.setSelected(true);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 33).toString()).booleanValue()) {
                this.jcbAct_1.setSelected(true);
            } else {
                this.jcbAct_1.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 34).toString()).booleanValue()) {
                this.jcbAct_2.setSelected(true);
            } else {
                this.jcbAct_2.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 35).toString()).booleanValue()) {
                this.jcbAct_3.setSelected(true);
            } else {
                this.jcbAct_3.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 36).toString()).booleanValue()) {
                this.jcbAct_4.setSelected(true);
            } else {
                this.jcbAct_4.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 37).toString()).booleanValue()) {
                this.jcbAct_5.setSelected(true);
            } else {
                this.jcbAct_5.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 38).toString()).booleanValue()) {
                this.jcbAct_6.setSelected(true);
            } else {
                this.jcbAct_6.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 39).toString()).booleanValue()) {
                this.jcbAct_7.setSelected(true);
            } else {
                this.jcbAct_7.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 40).toString()).booleanValue()) {
                this.jcbAct_8.setSelected(true);
            } else {
                this.jcbAct_8.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 41).toString()).booleanValue()) {
                this.jcbUten_1.setSelected(true);
            } else {
                this.jcbUten_1.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 42).toString()).booleanValue()) {
                this.jcbUten_2.setSelected(true);
            } else {
                this.jcbUten_2.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 43).toString()).booleanValue()) {
                this.jcbUten_3.setSelected(true);
            } else {
                this.jcbUten_3.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 44).toString()).booleanValue()) {
                this.jcbUten_4.setSelected(true);
            } else {
                this.jcbUten_4.setSelected(false);
            }
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 45).toString()).booleanValue()) {
                this.jcbUten_5.setSelected(true);
            } else {
                this.jcbUten_5.setSelected(false);
            }
            this.lblClasificacion.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 46).toString());
            this.JTAObservacion.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 47).toString());
            this.JTPClasificacionEular.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_11ActionPerformed(ActionEvent evt) {
        this.xOpc1 = Integer.parseInt(getValueRadioButton(this.btgPreg_1));
        mCalculoPorPregunta();
        System.out.println("opc 1 " + this.xOpc1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_12ActionPerformed(ActionEvent evt) {
        this.xOpc1 = Integer.parseInt(getValueRadioButton(this.btgPreg_1));
        mCalculoPorPregunta();
        System.out.println("opc 1 " + this.xOpc1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_13ActionPerformed(ActionEvent evt) {
        this.xOpc1 = Integer.parseInt(getValueRadioButton(this.btgPreg_1));
        mCalculoPorPregunta();
        System.out.println("opc 1 " + this.xOpc1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_14ActionPerformed(ActionEvent evt) {
        this.xOpc1 = Integer.parseInt(getValueRadioButton(this.btgPreg_1));
        mCalculoPorPregunta();
        System.out.println("opc 1 " + this.xOpc1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_21ActionPerformed(ActionEvent evt) {
        this.xOpc2 = Integer.parseInt(getValueRadioButton(this.btgPreg_2));
        mCalculoPorPregunta();
        System.out.println("opc 2 " + this.xOpc2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_22ActionPerformed(ActionEvent evt) {
        this.xOpc2 = Integer.parseInt(getValueRadioButton(this.btgPreg_2));
        mCalculoPorPregunta();
        System.out.println("opc 2 " + this.xOpc2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_23ActionPerformed(ActionEvent evt) {
        this.xOpc2 = Integer.parseInt(getValueRadioButton(this.btgPreg_2));
        mCalculoPorPregunta();
        System.out.println("opc 2 " + this.xOpc2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_24ActionPerformed(ActionEvent evt) {
        this.xOpc2 = Integer.parseInt(getValueRadioButton(this.btgPreg_2));
        mCalculoPorPregunta();
        System.out.println("opc 2 " + this.xOpc2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_31ActionPerformed(ActionEvent evt) {
        this.xOpc3 = Integer.parseInt(getValueRadioButton(this.btgPreg_3));
        mCalculoPorPregunta();
        System.out.println("opc 3 " + this.xOpc3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_32ActionPerformed(ActionEvent evt) {
        this.xOpc3 = Integer.parseInt(getValueRadioButton(this.btgPreg_3));
        mCalculoPorPregunta();
        System.out.println("opc 3 " + this.xOpc3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_33ActionPerformed(ActionEvent evt) {
        this.xOpc3 = Integer.parseInt(getValueRadioButton(this.btgPreg_3));
        mCalculoPorPregunta();
        System.out.println("opc 3 " + this.xOpc3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_34ActionPerformed(ActionEvent evt) {
        this.xOpc3 = Integer.parseInt(getValueRadioButton(this.btgPreg_3));
        mCalculoPorPregunta();
        System.out.println("opc 3 " + this.xOpc3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_41ActionPerformed(ActionEvent evt) {
        this.xOpc4 = Integer.parseInt(getValueRadioButton(this.btgPreg_4));
        mCalculoPorPregunta();
        System.out.println("opc 4 " + this.xOpc4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_42ActionPerformed(ActionEvent evt) {
        this.xOpc4 = Integer.parseInt(getValueRadioButton(this.btgPreg_4));
        mCalculoPorPregunta();
        System.out.println("opc 4 " + this.xOpc4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_43ActionPerformed(ActionEvent evt) {
        this.xOpc4 = Integer.parseInt(getValueRadioButton(this.btgPreg_4));
        mCalculoPorPregunta();
        System.out.println("opc 4 " + this.xOpc4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_44ActionPerformed(ActionEvent evt) {
        this.xOpc4 = Integer.parseInt(getValueRadioButton(this.btgPreg_4));
        mCalculoPorPregunta();
        System.out.println("opc 4 " + this.xOpc4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_51ActionPerformed(ActionEvent evt) {
        this.xOpc5 = Integer.parseInt(getValueRadioButton(this.btgPreg_5));
        mCalculoPorPregunta();
        System.out.println("opc 5 " + this.xOpc5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_52ActionPerformed(ActionEvent evt) {
        this.xOpc5 = Integer.parseInt(getValueRadioButton(this.btgPreg_5));
        mCalculoPorPregunta();
        System.out.println("opc 5 " + this.xOpc5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_53ActionPerformed(ActionEvent evt) {
        this.xOpc5 = Integer.parseInt(getValueRadioButton(this.btgPreg_5));
        mCalculoPorPregunta();
        System.out.println("opc 5 " + this.xOpc5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_54ActionPerformed(ActionEvent evt) {
        this.xOpc5 = Integer.parseInt(getValueRadioButton(this.btgPreg_5));
        mCalculoPorPregunta();
        System.out.println("opc 5 " + this.xOpc5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_61ActionPerformed(ActionEvent evt) {
        this.xOpc6 = Integer.parseInt(getValueRadioButton(this.btgPreg_6));
        mCalculoPorPregunta();
        System.out.println("opc 6 " + this.xOpc6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_62ActionPerformed(ActionEvent evt) {
        this.xOpc6 = Integer.parseInt(getValueRadioButton(this.btgPreg_6));
        mCalculoPorPregunta();
        System.out.println("opc 6 " + this.xOpc6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_63ActionPerformed(ActionEvent evt) {
        this.xOpc6 = Integer.parseInt(getValueRadioButton(this.btgPreg_6));
        mCalculoPorPregunta();
        System.out.println("opc 6 " + this.xOpc6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_64ActionPerformed(ActionEvent evt) {
        this.xOpc6 = Integer.parseInt(getValueRadioButton(this.btgPreg_6));
        mCalculoPorPregunta();
        System.out.println("opc 6 " + this.xOpc6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_71ActionPerformed(ActionEvent evt) {
        this.xOpc7 = Integer.parseInt(getValueRadioButton(this.btgPreg_7));
        mCalculoPorPregunta();
        System.out.println("opc 7 " + this.xOpc7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_72ActionPerformed(ActionEvent evt) {
        this.xOpc7 = Integer.parseInt(getValueRadioButton(this.btgPreg_7));
        mCalculoPorPregunta();
        System.out.println("opc 7 " + this.xOpc7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_73ActionPerformed(ActionEvent evt) {
        this.xOpc7 = Integer.parseInt(getValueRadioButton(this.btgPreg_7));
        mCalculoPorPregunta();
        System.out.println("opc 7 " + this.xOpc7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_74ActionPerformed(ActionEvent evt) {
        this.xOpc7 = Integer.parseInt(getValueRadioButton(this.btgPreg_7));
        mCalculoPorPregunta();
        System.out.println("opc 7 " + this.xOpc7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_131ActionPerformed(ActionEvent evt) {
        this.xOpc13 = Integer.parseInt(getValueRadioButton(this.btgPreg_13));
        mCalculoPorPregunta();
        System.out.println("opc 13 " + this.xOpc13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_132ActionPerformed(ActionEvent evt) {
        this.xOpc13 = Integer.parseInt(getValueRadioButton(this.btgPreg_13));
        mCalculoPorPregunta();
        System.out.println("opc 13 " + this.xOpc13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_133ActionPerformed(ActionEvent evt) {
        this.xOpc13 = Integer.parseInt(getValueRadioButton(this.btgPreg_13));
        mCalculoPorPregunta();
        System.out.println("opc 13 " + this.xOpc13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_134ActionPerformed(ActionEvent evt) {
        this.xOpc13 = Integer.parseInt(getValueRadioButton(this.btgPreg_13));
        mCalculoPorPregunta();
        System.out.println("opc 13 " + this.xOpc13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_141ActionPerformed(ActionEvent evt) {
        this.xOpc14 = Integer.parseInt(getValueRadioButton(this.btgPreg_14));
        mCalculoPorPregunta();
        System.out.println("opc 14 " + this.xOpc14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_142ActionPerformed(ActionEvent evt) {
        this.xOpc14 = Integer.parseInt(getValueRadioButton(this.btgPreg_14));
        mCalculoPorPregunta();
        System.out.println("opc 14 " + this.xOpc14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_143ActionPerformed(ActionEvent evt) {
        this.xOpc14 = Integer.parseInt(getValueRadioButton(this.btgPreg_14));
        mCalculoPorPregunta();
        System.out.println("opc 14 " + this.xOpc14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_144ActionPerformed(ActionEvent evt) {
        this.xOpc14 = Integer.parseInt(getValueRadioButton(this.btgPreg_14));
        mCalculoPorPregunta();
        System.out.println("opc 14 " + this.xOpc14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_101ActionPerformed(ActionEvent evt) {
        this.xOpc10 = Integer.parseInt(getValueRadioButton(this.btgPreg_10));
        mCalculoPorPregunta();
        System.out.println("opc 10 " + this.xOpc10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_102ActionPerformed(ActionEvent evt) {
        this.xOpc10 = Integer.parseInt(getValueRadioButton(this.btgPreg_10));
        mCalculoPorPregunta();
        System.out.println("opc 10 " + this.xOpc10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_103ActionPerformed(ActionEvent evt) {
        this.xOpc10 = Integer.parseInt(getValueRadioButton(this.btgPreg_10));
        mCalculoPorPregunta();
        System.out.println("opc 10 " + this.xOpc10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_104ActionPerformed(ActionEvent evt) {
        this.xOpc10 = Integer.parseInt(getValueRadioButton(this.btgPreg_10));
        mCalculoPorPregunta();
        System.out.println("opc 10 " + this.xOpc10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_111ActionPerformed(ActionEvent evt) {
        this.xOpc11 = Integer.parseInt(getValueRadioButton(this.btgPreg_11));
        mCalculoPorPregunta();
        System.out.println("opc 11 " + this.xOpc11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_112ActionPerformed(ActionEvent evt) {
        this.xOpc11 = Integer.parseInt(getValueRadioButton(this.btgPreg_11));
        mCalculoPorPregunta();
        System.out.println("opc 11 " + this.xOpc11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_113ActionPerformed(ActionEvent evt) {
        this.xOpc11 = Integer.parseInt(getValueRadioButton(this.btgPreg_11));
        mCalculoPorPregunta();
        System.out.println("opc 11 " + this.xOpc11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_114ActionPerformed(ActionEvent evt) {
        this.xOpc11 = Integer.parseInt(getValueRadioButton(this.btgPreg_11));
        mCalculoPorPregunta();
        System.out.println("opc 11 " + this.xOpc11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_81ActionPerformed(ActionEvent evt) {
        this.xOpc8 = Integer.parseInt(getValueRadioButton(this.btgPreg_8));
        mCalculoPorPregunta();
        System.out.println("opc 8 " + this.xOpc8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_82ActionPerformed(ActionEvent evt) {
        this.xOpc8 = Integer.parseInt(getValueRadioButton(this.btgPreg_8));
        mCalculoPorPregunta();
        System.out.println("opc 8 " + this.xOpc8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_83ActionPerformed(ActionEvent evt) {
        this.xOpc8 = Integer.parseInt(getValueRadioButton(this.btgPreg_8));
        mCalculoPorPregunta();
        System.out.println("opc 8 " + this.xOpc8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_84ActionPerformed(ActionEvent evt) {
        this.xOpc8 = Integer.parseInt(getValueRadioButton(this.btgPreg_8));
        mCalculoPorPregunta();
        System.out.println("opc 8 " + this.xOpc8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_91ActionPerformed(ActionEvent evt) {
        this.xOpc9 = Integer.parseInt(getValueRadioButton(this.btgPreg_9));
        mCalculoPorPregunta();
        System.out.println("opc 9 " + this.xOpc9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_92ActionPerformed(ActionEvent evt) {
        this.xOpc9 = Integer.parseInt(getValueRadioButton(this.btgPreg_9));
        mCalculoPorPregunta();
        System.out.println("opc 9 " + this.xOpc9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_93ActionPerformed(ActionEvent evt) {
        this.xOpc9 = Integer.parseInt(getValueRadioButton(this.btgPreg_9));
        mCalculoPorPregunta();
        System.out.println("opc 9 " + this.xOpc9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_94ActionPerformed(ActionEvent evt) {
        this.xOpc9 = Integer.parseInt(getValueRadioButton(this.btgPreg_9));
        mCalculoPorPregunta();
        System.out.println("opc 9 " + this.xOpc9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_121ActionPerformed(ActionEvent evt) {
        this.xOpc12 = Integer.parseInt(getValueRadioButton(this.btgPreg_12));
        mCalculoPorPregunta();
        System.out.println("opc 12 " + this.xOpc12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_122ActionPerformed(ActionEvent evt) {
        this.xOpc12 = Integer.parseInt(getValueRadioButton(this.btgPreg_12));
        mCalculoPorPregunta();
        System.out.println("opc 12 " + this.xOpc12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_123ActionPerformed(ActionEvent evt) {
        this.xOpc12 = Integer.parseInt(getValueRadioButton(this.btgPreg_12));
        mCalculoPorPregunta();
        System.out.println("opc 12 " + this.xOpc12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_124ActionPerformed(ActionEvent evt) {
        this.xOpc12 = Integer.parseInt(getValueRadioButton(this.btgPreg_12));
        mCalculoPorPregunta();
        System.out.println("opc 12 " + this.xOpc12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_151ActionPerformed(ActionEvent evt) {
        this.xOpc15 = Integer.parseInt(getValueRadioButton(this.btgPreg_15));
        mCalculoPorPregunta();
        System.out.println("opc 15 " + this.xOpc15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_152ActionPerformed(ActionEvent evt) {
        this.xOpc15 = Integer.parseInt(getValueRadioButton(this.btgPreg_15));
        mCalculoPorPregunta();
        System.out.println("opc 15 " + this.xOpc15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_153ActionPerformed(ActionEvent evt) {
        this.xOpc15 = Integer.parseInt(getValueRadioButton(this.btgPreg_15));
        mCalculoPorPregunta();
        System.out.println("opc 15 " + this.xOpc15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_154ActionPerformed(ActionEvent evt) {
        this.xOpc15 = Integer.parseInt(getValueRadioButton(this.btgPreg_15));
        mCalculoPorPregunta();
        System.out.println("opc 15 " + this.xOpc15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_161ActionPerformed(ActionEvent evt) {
        this.xOpc16 = Integer.parseInt(getValueRadioButton(this.btgPreg_16));
        mCalculoPorPregunta();
        System.out.println("opc 16 " + this.xOpc16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_162ActionPerformed(ActionEvent evt) {
        this.xOpc16 = Integer.parseInt(getValueRadioButton(this.btgPreg_16));
        mCalculoPorPregunta();
        System.out.println("opc 16 " + this.xOpc16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_163ActionPerformed(ActionEvent evt) {
        this.xOpc16 = Integer.parseInt(getValueRadioButton(this.btgPreg_16));
        mCalculoPorPregunta();
        System.out.println("opc 16 " + this.xOpc16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_164ActionPerformed(ActionEvent evt) {
        this.xOpc16 = Integer.parseInt(getValueRadioButton(this.btgPreg_16));
        mCalculoPorPregunta();
        System.out.println("opc 16 " + this.xOpc16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_171ActionPerformed(ActionEvent evt) {
        this.xOpc17 = Integer.parseInt(getValueRadioButton(this.btgPreg_17));
        mCalculoPorPregunta();
        System.out.println("opc 17 " + this.xOpc17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_172ActionPerformed(ActionEvent evt) {
        this.xOpc17 = Integer.parseInt(getValueRadioButton(this.btgPreg_17));
        mCalculoPorPregunta();
        System.out.println("opc 17 " + this.xOpc17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_173ActionPerformed(ActionEvent evt) {
        this.xOpc17 = Integer.parseInt(getValueRadioButton(this.btgPreg_17));
        mCalculoPorPregunta();
        System.out.println("opc 17 " + this.xOpc17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_174ActionPerformed(ActionEvent evt) {
        this.xOpc17 = Integer.parseInt(getValueRadioButton(this.btgPreg_17));
        mCalculoPorPregunta();
        System.out.println("opc 17 " + this.xOpc17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_181ActionPerformed(ActionEvent evt) {
        this.xOpc18 = Integer.parseInt(getValueRadioButton(this.btgPreg_18));
        mCalculoPorPregunta();
        System.out.println("opc 18 " + this.xOpc18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_182ActionPerformed(ActionEvent evt) {
        this.xOpc18 = Integer.parseInt(getValueRadioButton(this.btgPreg_18));
        mCalculoPorPregunta();
        System.out.println("opc 18 " + this.xOpc18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_183ActionPerformed(ActionEvent evt) {
        this.xOpc18 = Integer.parseInt(getValueRadioButton(this.btgPreg_18));
        mCalculoPorPregunta();
        System.out.println("opc 18 " + this.xOpc18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_184ActionPerformed(ActionEvent evt) {
        this.xOpc18 = Integer.parseInt(getValueRadioButton(this.btgPreg_18));
        mCalculoPorPregunta();
        System.out.println("opc 18 " + this.xOpc18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_191ActionPerformed(ActionEvent evt) {
        this.xOpc19 = Integer.parseInt(getValueRadioButton(this.btgPreg_19));
        mCalculoPorPregunta();
        System.out.println("opc 19 " + this.xOpc19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_192ActionPerformed(ActionEvent evt) {
        this.xOpc19 = Integer.parseInt(getValueRadioButton(this.btgPreg_19));
        mCalculoPorPregunta();
        System.out.println("opc 19 " + this.xOpc19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_193ActionPerformed(ActionEvent evt) {
        this.xOpc19 = Integer.parseInt(getValueRadioButton(this.btgPreg_19));
        mCalculoPorPregunta();
        System.out.println("opc 19 " + this.xOpc19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_194ActionPerformed(ActionEvent evt) {
        this.xOpc19 = Integer.parseInt(getValueRadioButton(this.btgPreg_19));
        mCalculoPorPregunta();
        System.out.println("opc 19 " + this.xOpc19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_201ActionPerformed(ActionEvent evt) {
        this.xOpc20 = Integer.parseInt(getValueRadioButton(this.btgPreg_20));
        mCalculoPorPregunta();
        System.out.println("opc 20 " + this.xOpc20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_202ActionPerformed(ActionEvent evt) {
        this.xOpc20 = Integer.parseInt(getValueRadioButton(this.btgPreg_20));
        mCalculoPorPregunta();
        System.out.println("opc 20 " + this.xOpc20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_203ActionPerformed(ActionEvent evt) {
        this.xOpc20 = Integer.parseInt(getValueRadioButton(this.btgPreg_20));
        mCalculoPorPregunta();
        System.out.println("opc 20 " + this.xOpc20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jrbPreg_204ActionPerformed(ActionEvent evt) {
        this.xOpc20 = Integer.parseInt(getValueRadioButton(this.btgPreg_20));
        mCalculoPorPregunta();
        System.out.println("opc 20 " + this.xOpc20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbAct_1ActionPerformed(ActionEvent evt) {
        if (this.jcbAct_1.isSelected()) {
            this.xAct1 = 1;
        } else {
            this.xAct1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCalcularActionPerformed(ActionEvent evt) {
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbAct_2ActionPerformed(ActionEvent evt) {
        if (this.jcbAct_2.isSelected()) {
            this.xAct2 = 1;
        } else {
            this.xAct2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbAct_3ActionPerformed(ActionEvent evt) {
        if (this.jcbAct_3.isSelected()) {
            this.xAct3 = 1;
        } else {
            this.xAct3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbAct_4ActionPerformed(ActionEvent evt) {
        if (this.jcbAct_4.isSelected()) {
            this.xAct4 = 1;
        } else {
            this.xAct4 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbAct_5ActionPerformed(ActionEvent evt) {
        if (this.jcbAct_5.isSelected()) {
            this.xAct5 = 1;
        } else {
            this.xAct5 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbAct_6ActionPerformed(ActionEvent evt) {
        if (this.jcbAct_6.isSelected()) {
            this.xAct6 = 1;
        } else {
            this.xAct6 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbAct_7ActionPerformed(ActionEvent evt) {
        if (this.jcbAct_7.isSelected()) {
            this.xAct7 = 1;
        } else {
            this.xAct7 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbAct_8ActionPerformed(ActionEvent evt) {
        if (this.jcbAct_8.isSelected()) {
            this.xAct8 = 1;
        } else {
            this.xAct8 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbUten_1ActionPerformed(ActionEvent evt) {
        if (this.jcbUten_1.isSelected()) {
            this.xUten1 = 1;
        } else {
            this.xUten1 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbUten_4ActionPerformed(ActionEvent evt) {
        if (this.jcbUten_4.isSelected()) {
            this.xUten2 = 1;
        } else {
            this.xUten2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbUten_2ActionPerformed(ActionEvent evt) {
        if (this.jcbUten_2.isSelected()) {
            this.xUten3 = 1;
        } else {
            this.xUten3 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbUten_5ActionPerformed(ActionEvent evt) {
        if (this.jcbUten_5.isSelected()) {
            this.xUten4 = 1;
        } else {
            this.xUten4 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jcbUten_3ActionPerformed(ActionEvent evt) {
        if (this.jcbUten_3.isSelected()) {
            this.xUten5 = 1;
        } else {
            this.xUten5 = 0;
        }
    }
}
