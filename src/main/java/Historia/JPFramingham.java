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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPFramingham.class */
public class JPFramingham extends JPanel {
    private String xPaso1;
    private String xPaso2;
    private String xPaso3;
    private String xPaso4;
    private String xPaso5;
    private String xPaso6;
    private int xResultado;
    private long xEstadoHC;
    public DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xPorcentaje;
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
    private JTextField JTFBajo;
    private JTextField JTFModerado;
    private JTextField JTFSevero;
    private JRadioButton P2_1;
    private JRadioButton P2_2;
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
    private JRadioButton P5_5;
    private JRadioButton P6_1;
    private JRadioButton P6_2;
    private JRadioButton P6_3;
    private JRadioButton P6_4;
    private JRadioButton P6_5;
    private JRadioButton P_1;
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
    private ButtonGroup Paso6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private boolean xexiste = false;
    ConsultasMySQL xct = new ConsultasMySQL();
    Metodos xmt = new Metodos();
    public boolean framingham = false;
    public boolean fGrabado = false;

    public JPFramingham() {
        initComponents();
        mIniciaComponentes();
        mVerifica();
        mBuscaHistorico();
    }

    private void mIniciaComponentes() {
        try {
            this.JLPaso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso1_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso2_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso3_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso4_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso5_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
            this.JLPaso6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso6_" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo() + ".PNG")));
        } catch (Exception e) {
            System.err.println("Excepcion framingham cargar imagenes de los label");
        }
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
            this.P_1.setName("-1");
            this.P_2.setName("0");
            this.P_3.setName("1");
            this.P_4.setName("2");
            this.P_5.setName("3");
            this.P_6.setName("4");
            this.P_7.setName("5");
            this.P_8.setName("6");
            this.P_9.setName("7");
            this.P2_1.setName("0");
            this.P2_2.setName("2");
            this.P3_1.setName("0");
            this.P3_2.setName("2");
            this.P4_1.setName("-3");
            this.P4_2.setName("0");
            this.P4_3.setName("1");
            this.P4_4.setName("2");
            this.P4_5.setName("3");
            this.P5_1.setName("2");
            this.P5_2.setName("1");
            this.P5_3.setName("0");
            this.P5_4.setName("0");
            this.P5_5.setName("-2");
            this.P6_1.setName("0");
            this.P6_2.setName("0");
            this.P6_3.setName("1");
            this.P6_4.setName("2");
            this.P6_5.setName("3");
        } else {
            this.P_1.setName("-9");
            this.P_2.setName("-4");
            this.P_3.setName("0");
            this.P_4.setName("3");
            this.P_5.setName("6");
            this.P_6.setName("7");
            this.P_7.setName("8");
            this.P_8.setName("8");
            this.P_9.setName("8");
            this.P2_1.setName("0");
            this.P2_2.setName("4");
            this.P3_1.setName("0");
            this.P3_2.setName("2");
            this.P4_1.setName("-2");
            this.P4_2.setName("0");
            this.P4_3.setName("1");
            this.P4_4.setName("1");
            this.P4_5.setName("3");
            this.P5_1.setName("5");
            this.P5_2.setName("2");
            this.P5_3.setName("1");
            this.P5_4.setName("0");
            this.P5_5.setName("-3");
            this.P6_1.setName("-3");
            this.P6_2.setName("0");
            this.P6_3.setName("0");
            this.P6_4.setName("2");
            this.P6_5.setName("3");
        }
        this.JTFBajo.setBackground(Color.GRAY);
        this.JTFModerado.setBackground(Color.GRAY);
        this.JTFSevero.setBackground(Color.GRAY);
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

    private void mResultado() {
        System.out.println("Valor 1 ----->" + this.xPaso1);
        System.out.println("Valor 2 ----->" + this.xPaso2);
        System.out.println("Valor 3 ----->" + this.xPaso3);
        System.out.println("Valor 4 ----->" + this.xPaso4);
        System.out.println("Valor 5 ----->" + this.xPaso5);
        System.out.println("Valor 6 ----->" + this.xPaso6);
        if (this.xPaso1 != null && this.xPaso2 != null && this.xPaso3 != null && this.xPaso4 != null && this.xPaso5 != null && this.xPaso6 != null) {
            this.xResultado = Integer.valueOf(this.xPaso1).intValue() + Integer.valueOf(this.xPaso2).intValue() + Integer.valueOf(this.xPaso3).intValue() + Integer.valueOf(this.xPaso4).intValue() + Integer.valueOf(this.xPaso5).intValue() + Integer.valueOf(this.xPaso6).intValue();
            this.JLPuntaje.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            switch (this.xResultado) {
                case 0:
                    this.JLPuntaje.setBounds(5, 166, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "2%";
                    } else {
                        this.xPorcentaje = "1%";
                    }
                    break;
                case 1:
                    this.JLPuntaje.setBounds(5, 187, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "2%";
                    } else {
                        this.xPorcentaje = "1%";
                    }
                    break;
                case 2:
                    this.JLPuntaje.setBounds(5, 209, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "3%";
                    } else {
                        this.xPorcentaje = "2%";
                    }
                    break;
                case 3:
                    this.JLPuntaje.setBounds(5, 230, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "4%";
                    } else {
                        this.xPorcentaje = "2%";
                    }
                    break;
                case 4:
                    this.JLPuntaje.setBounds(5, 252, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "5%";
                    } else {
                        this.xPorcentaje = "2%";
                    }
                    break;
                case 5:
                    this.JLPuntaje.setBounds(5, 272, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "6%";
                    } else {
                        this.xPorcentaje = "2%";
                    }
                    break;
                case 6:
                    this.JLPuntaje.setBounds(5, 295, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "7%";
                    } else {
                        this.xPorcentaje = "2%";
                    }
                    break;
                case 7:
                    this.JLPuntaje.setBounds(5, 317, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "9%";
                    } else {
                        this.xPorcentaje = "3%";
                    }
                    break;
                case 8:
                    this.JLPuntaje.setBounds(5, 338, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "13%";
                    } else {
                        this.xPorcentaje = "3%";
                    }
                    break;
                case 9:
                    this.JLPuntaje.setBounds(5, 358, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "16%";
                    } else {
                        this.xPorcentaje = "3%";
                    }
                    break;
                case 10:
                    this.JLPuntaje.setBounds(5, 380, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "20%";
                    } else {
                        this.xPorcentaje = "4%";
                    }
                    break;
                case 11:
                    this.JLPuntaje.setBounds(5, 402, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "25%";
                    } else {
                        this.xPorcentaje = "7%";
                    }
                    break;
                case 12:
                    this.JLPuntaje.setBounds(5, 423, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "30%";
                    } else {
                        this.xPorcentaje = "8%";
                    }
                    break;
                case 13:
                    this.JLPuntaje.setBounds(5, 444, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = "45%";
                    } else {
                        this.xPorcentaje = "11%";
                    }
                    break;
                case 14:
                    this.JLPuntaje.setBounds(5, 465, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = ">45%";
                    } else {
                        this.xPorcentaje = "13%";
                    }
                    break;
                case 15:
                    this.JLPuntaje.setBounds(5, 486, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = ">45%";
                    } else {
                        this.xPorcentaje = "15%";
                    }
                    break;
                case 16:
                    this.JLPuntaje.setBounds(5, 509, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = ">45%";
                    } else {
                        this.xPorcentaje = "18%";
                    }
                    break;
                case 17:
                    this.JLPuntaje.setBounds(5, 529, 230, 21);
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                        this.xPorcentaje = ">45%";
                    } else {
                        this.xPorcentaje = ">20%";
                    }
                    break;
                default:
                    if (this.xResultado > 17) {
                        this.JLPuntaje.setBounds(5, 529, 230, 21);
                        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                            this.xPorcentaje = ">45%";
                        } else {
                            this.xPorcentaje = ">20%";
                        }
                    } else if (this.xResultado < 0) {
                        this.JLPuntaje.setBounds(5, 166, 230, 21);
                        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                            this.xPorcentaje = "2%";
                        } else {
                            this.xPorcentaje = "1%";
                        }
                    }
                    break;
            }
            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                if (this.xResultado <= 7) {
                    this.JTFBajo.setBackground(Color.GREEN);
                    this.JTFModerado.setBackground(Color.GRAY);
                    this.JTFSevero.setBackground(Color.GRAY);
                    this.fGrabado = true;
                    return;
                }
                if (this.xResultado >= 8 && this.xResultado <= 10) {
                    this.JTFModerado.setBackground(Color.YELLOW);
                    this.JTFBajo.setBackground(Color.GRAY);
                    this.JTFSevero.setBackground(Color.GRAY);
                    this.fGrabado = true;
                    return;
                }
                if (this.xResultado > 10) {
                    this.JTFSevero.setBackground(Color.red);
                    this.JTFModerado.setBackground(Color.GRAY);
                    this.JTFBajo.setBackground(Color.GRAY);
                    this.fGrabado = true;
                    return;
                }
                return;
            }
            if (this.xResultado <= 12) {
                this.JTFBajo.setBackground(Color.GREEN);
                this.JTFModerado.setBackground(Color.GRAY);
                this.JTFSevero.setBackground(Color.GRAY);
                this.fGrabado = true;
                return;
            }
            if (this.xResultado >= 13 && this.xResultado < 17) {
                this.JTFModerado.setBackground(Color.YELLOW);
                this.JTFBajo.setBackground(Color.GRAY);
                this.JTFSevero.setBackground(Color.GRAY);
                this.fGrabado = true;
                return;
            }
            if (this.xResultado >= 17) {
                this.JTFSevero.setBackground(Color.red);
                this.JTFModerado.setBackground(Color.GRAY);
                this.JTFBajo.setBackground(Color.GRAY);
                this.fGrabado = true;
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
                        String sql2 = "INSERT INTO `h_framigan`\n            (`idAtencion`,\n             `idUsuario`,\n             `fechaR`,\n             `edad`,\n             `diabetes`,\n             `fumador`,\n             `colesterol`,\n             `hdl`,\n             `presion`,\n             `resultadoPuntos`,\n             `resultadoPorcentaje`,\n             `UsuarioS`)\nVALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',\n        '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',\n        '" + this.xPaso1 + "',\n        '" + this.xPaso2 + "',\n        '" + this.xPaso3 + "',\n        '" + this.xPaso4 + "',\n        '" + this.xPaso5 + "',\n        '" + this.xPaso6 + "',\n        '" + this.xResultado + "',\n        '" + this.xPorcentaje + "', \n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql2);
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
            JOptionPane.showInternalMessageDialog(this, "Este test ya fué diligenciado en la atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.xEstadoHC == 0) {
            if (this.xPaso1 != null && this.xPaso2 != null && this.xPaso3 != null && this.xPaso4 != null && this.xPaso5 != null && this.xPaso6 != null) {
                int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y2 == 0) {
                    if (!this.xexiste) {
                        sql = "INSERT INTO `h_framigan`\n            (`idAtencion`,\n             `idUsuario`,\n             `fechaR`,\n             `edad`,\n             `diabetes`,\n             `fumador`,\n             `colesterol`,\n             `hdl`,\n             `presion`,\n             `resultadoPuntos`,\n             `resultadoPorcentaje`,\n             `UsuarioS`)\nVALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',\n        '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',\n        '" + this.xPaso1 + "',\n        '" + this.xPaso2 + "',\n        '" + this.xPaso3 + "',\n        '" + this.xPaso4 + "',\n        '" + this.xPaso5 + "',\n        '" + this.xPaso6 + "',\n        '" + this.xResultado + "',\n        '" + this.xPorcentaje + "', \n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql);
                        this.framingham = true;
                    } else {
                        sql = "UPDATE `h_framigan` SET `edad`='" + this.xPaso1 + "',`diabetes`='" + this.xPaso2 + "',`fumador`='" + this.xPaso3 + "',`colesterol`='" + this.xPaso4 + "',`hdl`='" + this.xPaso5 + "',`presion`='" + this.xPaso6 + "',`resultadoPuntos`='" + this.xResultado + "',`resultadoPorcentaje`='" + this.xPorcentaje + "',`UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE idAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                        this.framingham = true;
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mBuscaHistorico();
                    this.xexiste = true;
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe terminar el test", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Esta historia clinica ya se encuentra cerrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mVerifica() {
        String sql = "SELECT `edad`, `diabetes`, `fumador`, `colesterol`, `hdl`, `presion`, `resultadoPuntos`, `h_atencion`.`TipoGuardado` FROM `h_framigan` INNER JOIN `h_atencion` ON (h_framigan.`idAtencion` = `h_atencion`.`Id`) WHERE (h_framigan.`idAtencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND h_framigan.`Estado`=1)";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xexiste = true;
                setButtonGroup(xrs.getString("edad"), this.Paso1.getElements());
                setButtonGroup(xrs.getString("diabetes"), this.Paso2.getElements());
                setButtonGroup(xrs.getString("fumador"), this.Paso3.getElements());
                setButtonGroup(xrs.getString("colesterol"), this.Paso4.getElements());
                setButtonGroup(xrs.getString("hdl"), this.Paso5.getElements());
                setButtonGroup(xrs.getString("presion"), this.Paso6.getElements());
                this.xEstadoHC = Long.parseLong(xrs.getString("TipoGuardado"));
                mResultado();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFramingham.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Punt. Edad", "Punt. Diabetes", "Punt. Fumador", "Punt. Colesterol total", "Punt. HDL", "Punt. Presión Art.", "Total Puntos", "Porcentaje"}) { // from class: Historia.JPFramingham.1
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
            String sql = "SELECT Id, `fechaR`, `edad`, `diabetes`, `fumador`, `colesterol`, `hdl`, `presion`, `resultadoPuntos`, h_framigan.`resultadoPorcentaje`\nFROM `baseserver`.`h_framigan`\nWHERE h_framigan.`Estado`=1 AND h_framigan.`idUsuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' ORDER BY fechaR DESC";
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
            Logger.getLogger(JPFramingham.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v165, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.Paso1 = new ButtonGroup();
        this.Paso2 = new ButtonGroup();
        this.Paso3 = new ButtonGroup();
        this.Paso4 = new ButtonGroup();
        this.Paso5 = new ButtonGroup();
        this.Paso6 = new ButtonGroup();
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
        this.JLPaso1 = new JLabel();
        this.JPPaso2 = new JPanel();
        this.P2_1 = new JRadioButton();
        this.P2_2 = new JRadioButton();
        this.JLPaso2 = new JLabel();
        this.JPPaso3 = new JPanel();
        this.P3_1 = new JRadioButton();
        this.P3_2 = new JRadioButton();
        this.JLPaso3 = new JLabel();
        this.JPPaso4 = new JPanel();
        this.P4_1 = new JRadioButton();
        this.P4_2 = new JRadioButton();
        this.P4_3 = new JRadioButton();
        this.P4_4 = new JRadioButton();
        this.P4_5 = new JRadioButton();
        this.JLPaso4 = new JLabel();
        this.JPPaso5 = new JPanel();
        this.P5_1 = new JRadioButton();
        this.P5_2 = new JRadioButton();
        this.P5_3 = new JRadioButton();
        this.P5_4 = new JRadioButton();
        this.P5_5 = new JRadioButton();
        this.JLPaso5 = new JLabel();
        this.JPPaso6 = new JPanel();
        this.P6_1 = new JRadioButton();
        this.P6_2 = new JRadioButton();
        this.P6_3 = new JRadioButton();
        this.P6_4 = new JRadioButton();
        this.P6_5 = new JRadioButton();
        this.JLPaso6 = new JLabel();
        this.JPResultado = new JPanel();
        this.JLPuntaje = new JLabel();
        this.jLabel2 = new JLabel();
        this.jLabel1 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel3 = new JLabel();
        this.JTFBajo = new JTextField();
        this.JTFModerado = new JTextField();
        this.JTFSevero = new JTextField();
        this.jPanel1 = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setName("jpFramigan");
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JPForm.setBackground(new Color(255, 255, 255));
        this.JPPaso1.setMaximumSize(new Dimension(150, 207));
        this.JPPaso1.setMinimumSize(new Dimension(150, 207));
        this.JPPaso1.setPreferredSize(new Dimension(150, 207));
        this.JPPaso1.setLayout((LayoutManager) null);
        this.Paso1.add(this.P_1);
        this.P_1.setName("-1");
        this.P_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.2
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_1ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_1);
        this.P_1.setBounds(110, 62, 18, 16);
        this.Paso1.add(this.P_2);
        this.P_2.setName("0");
        this.P_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.3
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_2ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_2);
        this.P_2.setBounds(110, 78, 18, 16);
        this.Paso1.add(this.P_3);
        this.P_3.setName("1");
        this.P_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.4
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_3ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_3);
        this.P_3.setBounds(110, 93, 18, 16);
        this.Paso1.add(this.P_4);
        this.P_4.setName("2");
        this.P_4.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.5
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_4ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_4);
        this.P_4.setBounds(110, 108, 18, 16);
        this.Paso1.add(this.P_5);
        this.P_5.setName("3");
        this.P_5.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.6
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_5ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_5);
        this.P_5.setBounds(110, 124, 18, 16);
        this.Paso1.add(this.P_6);
        this.P_6.setName("4");
        this.P_6.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.7
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_6ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_6);
        this.P_6.setBounds(110, 139, 18, 16);
        this.Paso1.add(this.P_7);
        this.P_7.setName("5");
        this.P_7.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.8
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_7ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_7);
        this.P_7.setBounds(110, 155, 18, 16);
        this.Paso1.add(this.P_8);
        this.P_8.setName("6");
        this.P_8.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.9
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_8ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_8);
        this.P_8.setBounds(110, 170, 18, 16);
        this.Paso1.add(this.P_9);
        this.P_9.setName("7");
        this.P_9.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.10
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P_9ActionPerformed(evt);
            }
        });
        this.JPPaso1.add(this.P_9);
        this.P_9.setBounds(110, 186, 18, 16);
        this.JLPaso1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso1_M.PNG")));
        this.JLPaso1.setText("jLabel1");
        this.JLPaso1.setMaximumSize(new Dimension(150, 207));
        this.JLPaso1.setMinimumSize(new Dimension(150, 207));
        this.JLPaso1.setPreferredSize(new Dimension(150, 207));
        this.JPPaso1.add(this.JLPaso1);
        this.JLPaso1.setBounds(0, 0, 150, 207);
        this.JPPaso2.setMaximumSize(new Dimension(150, 98));
        this.JPPaso2.setMinimumSize(new Dimension(150, 98));
        this.JPPaso2.setPreferredSize(new Dimension(150, 98));
        this.JPPaso2.setLayout((LayoutManager) null);
        this.Paso2.add(this.P2_1);
        this.P2_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.11
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P2_1ActionPerformed(evt);
            }
        });
        this.JPPaso2.add(this.P2_1);
        this.P2_1.setBounds(110, 58, 20, 28);
        this.Paso2.add(this.P2_2);
        this.P2_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.12
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P2_2ActionPerformed(evt);
            }
        });
        this.JPPaso2.add(this.P2_2);
        this.P2_2.setBounds(110, 75, 20, 28);
        this.JLPaso2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso2_M.PNG")));
        this.JLPaso2.setText("jLabel1");
        this.JLPaso2.setMaximumSize(new Dimension(150, 98));
        this.JLPaso2.setMinimumSize(new Dimension(150, 98));
        this.JLPaso2.setPreferredSize(new Dimension(150, 98));
        this.JPPaso2.add(this.JLPaso2);
        this.JLPaso2.setBounds(0, 0, 150, 98);
        this.JPPaso3.setMaximumSize(new Dimension(150, 97));
        this.JPPaso3.setMinimumSize(new Dimension(150, 97));
        this.JPPaso3.setLayout((LayoutManager) null);
        this.Paso3.add(this.P3_1);
        this.P3_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.13
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P3_1ActionPerformed(evt);
            }
        });
        this.JPPaso3.add(this.P3_1);
        this.P3_1.setBounds(110, 58, 20, 28);
        this.Paso3.add(this.P3_2);
        this.P3_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.14
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P3_2ActionPerformed(evt);
            }
        });
        this.JPPaso3.add(this.P3_2);
        this.P3_2.setBounds(110, 75, 20, 28);
        this.JLPaso3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso3_M.PNG")));
        this.JLPaso3.setText("jLabel1");
        this.JLPaso3.setMaximumSize(new Dimension(150, 97));
        this.JLPaso3.setMinimumSize(new Dimension(150, 97));
        this.JLPaso3.setPreferredSize(new Dimension(150, 97));
        this.JPPaso3.add(this.JLPaso3);
        this.JLPaso3.setBounds(0, 0, 150, 97);
        this.JPPaso4.setMaximumSize(new Dimension(150, 153));
        this.JPPaso4.setMinimumSize(new Dimension(150, 153));
        this.JPPaso4.setLayout((LayoutManager) null);
        this.Paso4.add(this.P4_1);
        this.P4_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.15
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P4_1ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_1);
        this.P4_1.setBounds(110, 67, 20, 28);
        this.Paso4.add(this.P4_2);
        this.P4_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.16
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P4_2ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_2);
        this.P4_2.setBounds(110, 83, 20, 28);
        this.Paso4.add(this.P4_3);
        this.P4_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.17
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P4_3ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_3);
        this.P4_3.setBounds(110, 98, 20, 28);
        this.Paso4.add(this.P4_4);
        this.P4_4.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.18
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P4_4ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_4);
        this.P4_4.setBounds(110, 114, 20, 28);
        this.Paso4.add(this.P4_5);
        this.P4_5.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.19
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P4_5ActionPerformed(evt);
            }
        });
        this.JPPaso4.add(this.P4_5);
        this.P4_5.setBounds(110, 129, 20, 28);
        this.JLPaso4.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso4_M.PNG")));
        this.JLPaso4.setText("jLabel1");
        this.JLPaso4.setMaximumSize(new Dimension(150, 153));
        this.JLPaso4.setMinimumSize(new Dimension(150, 153));
        this.JLPaso4.setPreferredSize(new Dimension(150, 153));
        this.JPPaso4.add(this.JLPaso4);
        this.JLPaso4.setBounds(0, 0, 150, 153);
        this.JPPaso5.setMaximumSize(new Dimension(150, 155));
        this.JPPaso5.setMinimumSize(new Dimension(150, 155));
        this.JPPaso5.setLayout((LayoutManager) null);
        this.Paso5.add(this.P5_1);
        this.P5_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.20
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P5_1ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_1);
        this.P5_1.setBounds(110, 69, 20, 28);
        this.Paso5.add(this.P5_2);
        this.P5_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.21
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P5_2ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_2);
        this.P5_2.setBounds(110, 85, 20, 28);
        this.Paso5.add(this.P5_3);
        this.P5_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.22
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P5_3ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_3);
        this.P5_3.setBounds(110, 100, 20, 28);
        this.Paso5.add(this.P5_4);
        this.P5_4.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.23
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P5_4ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_4);
        this.P5_4.setBounds(110, 115, 20, 28);
        this.Paso5.add(this.P5_5);
        this.P5_5.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.24
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P5_5ActionPerformed(evt);
            }
        });
        this.JPPaso5.add(this.P5_5);
        this.P5_5.setBounds(110, 131, 20, 28);
        this.JLPaso5.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso5_M.PNG")));
        this.JLPaso5.setText("jLabel1");
        this.JLPaso5.setMaximumSize(new Dimension(150, 155));
        this.JLPaso5.setMinimumSize(new Dimension(150, 155));
        this.JLPaso5.setPreferredSize(new Dimension(150, 155));
        this.JPPaso5.add(this.JLPaso5);
        this.JLPaso5.setBounds(0, 0, 150, 155);
        this.JPPaso6.setMaximumSize(new Dimension(247, 212));
        this.JPPaso6.setMinimumSize(new Dimension(247, 212));
        this.JPPaso6.setLayout((LayoutManager) null);
        this.Paso6.add(this.P6_1);
        this.P6_1.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.25
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P6_1ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_1);
        this.P6_1.setBounds(60, 86, 20, 28);
        this.Paso6.add(this.P6_2);
        this.P6_2.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.26
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P6_2ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_2);
        this.P6_2.setBounds(97, 86, 20, 28);
        this.Paso6.add(this.P6_3);
        this.P6_3.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.27
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P6_3ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_3);
        this.P6_3.setBounds(130, 86, 20, 28);
        this.Paso6.add(this.P6_4);
        this.P6_4.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.28
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P6_4ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_4);
        this.P6_4.setBounds(170, 86, 20, 28);
        this.Paso6.add(this.P6_5);
        this.P6_5.addActionListener(new ActionListener() { // from class: Historia.JPFramingham.29
            public void actionPerformed(ActionEvent evt) {
                JPFramingham.this.P6_5ActionPerformed(evt);
            }
        });
        this.JPPaso6.add(this.P6_5);
        this.P6_5.setBounds(210, 86, 20, 28);
        this.JLPaso6.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/Paso6_M.PNG")));
        this.JLPaso6.setText("jLabel1");
        this.JLPaso6.setMaximumSize(new Dimension(247, 212));
        this.JLPaso6.setMinimumSize(new Dimension(247, 212));
        this.JLPaso6.setPreferredSize(new Dimension(247, 212));
        this.JPPaso6.add(this.JLPaso6);
        this.JLPaso6.setBounds(0, 0, 250, 212);
        this.JPResultado.setMaximumSize(new Dimension(242, 562));
        this.JPResultado.setMinimumSize(new Dimension(242, 562));
        this.JPResultado.setPreferredSize(new Dimension(242, 562));
        this.JPResultado.setLayout((LayoutManager) null);
        this.JPResultado.add(this.JLPuntaje);
        this.JLPuntaje.setBounds(0, 0, 230, 20);
        this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Framinghan/resultados.PNG")));
        this.JPResultado.add(this.jLabel2);
        this.jLabel2.setBounds(0, 0, 242, 560);
        this.jLabel1.setText("<html><p>Cuando la P.A. sistólica y diastólica aportan\ndistinta puntuación se utiliza el mayor de los\nvalores.</p></html>");
        this.jLabel3.setFont(new Font("Arial", 1, 14));
        this.jLabel3.setText("INTERPRETACION DEL RIESGO");
        this.JTFBajo.setFont(new Font("Arial", 1, 14));
        this.JTFBajo.setText("BAJO");
        this.JTFModerado.setFont(new Font("Arial", 1, 14));
        this.JTFModerado.setText("MODERADO");
        this.JTFSevero.setFont(new Font("Arial", 1, 14));
        this.JTFSevero.setText("SEVERO");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFBajo, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTFModerado, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTFSevero, -2, -1, -2).addGap(0, 0, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3, -1, -1, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFBajo, -2, -1, -2).addComponent(this.JTFModerado, -2, -1, -2).addComponent(this.JTFSevero, -2, -1, -2)).addContainerGap(20, 32767)));
        GroupLayout JPFormLayout = new GroupLayout(this.JPForm);
        this.JPForm.setLayout(JPFormLayout);
        JPFormLayout.setHorizontalGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addContainerGap().addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPPaso4, -1, -1, 32767).addComponent(this.JPPaso3, -1, -1, 32767).addComponent(this.JPPaso1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPPaso2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPPaso5, -2, 150, -2).addComponent(this.jLabel1, -2, 0, 32767).addComponent(this.JPPaso6, -2, 243, 32767)).addGap(100, 100, 100).addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JPResultado, -1, -1, 32767)).addContainerGap(53, 32767)));
        JPFormLayout.setVerticalGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addContainerGap().addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormLayout.createSequentialGroup().addComponent(this.JPPaso1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPaso2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPaso3, -2, 97, -2)).addGroup(JPFormLayout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JPPaso5, -2, 155, -2).addGap(18, 18, 18).addComponent(this.JPPaso6, -2, 212, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPFormLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPPaso4, -2, 153, -2).addComponent(this.jLabel1, -2, 74, -2))).addGroup(JPFormLayout.createSequentialGroup().addComponent(this.JPResultado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2))).addContainerGap(32, 32767)));
        this.jTabbedPane1.addTab("FRAMINGHAM", this.JPForm);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPFramingham.30
            public void mouseClicked(MouseEvent evt) {
                JPFramingham.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JPFramingham.31
            public void keyPressed(KeyEvent evt) {
                JPFramingham.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle, -2, 788, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 668, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel1);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_1ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_2ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_3ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_4ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_5ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_6ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_7ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_8ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P_9ActionPerformed(ActionEvent evt) {
        this.xPaso1 = getValueRadioButton(this.Paso1);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2_1ActionPerformed(ActionEvent evt) {
        this.xPaso2 = getValueRadioButton(this.Paso2);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P2_2ActionPerformed(ActionEvent evt) {
        this.xPaso2 = getValueRadioButton(this.Paso2);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3_1ActionPerformed(ActionEvent evt) {
        this.xPaso3 = getValueRadioButton(this.Paso3);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3_2ActionPerformed(ActionEvent evt) {
        this.xPaso3 = getValueRadioButton(this.Paso3);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_1ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton(this.Paso4);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_2ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton(this.Paso4);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_3ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton(this.Paso4);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_4ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton(this.Paso4);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P4_5ActionPerformed(ActionEvent evt) {
        this.xPaso4 = getValueRadioButton(this.Paso4);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_1ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton(this.Paso5);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_2ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton(this.Paso5);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_3ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton(this.Paso5);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_4ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton(this.Paso5);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P5_5ActionPerformed(ActionEvent evt) {
        this.xPaso5 = getValueRadioButton(this.Paso5);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_1ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_2ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_3ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_4ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6);
        mResultado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P6_5ActionPerformed(ActionEvent evt) {
        this.xPaso6 = getValueRadioButton(this.Paso6);
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
            setButtonGroup(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString(), this.Paso5.getElements());
            setButtonGroup(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).toString(), this.Paso6.getElements());
            mResultado();
            this.jTabbedPane1.setSelectedIndex(0);
        }
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
