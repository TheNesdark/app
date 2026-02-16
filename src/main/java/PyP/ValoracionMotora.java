package PyP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:PyP/ValoracionMotora.class */
public class ValoracionMotora extends JPanel {
    private String sql;
    private String IdAtencion;
    private String IdPaciente;
    private ResultSet rs;
    private JButton btnAnterior;
    private JButton btnEscala;
    private JButton btnGrabar;
    private JButton btnNuevo;
    private JButton btnPrimer;
    private JButton btnSiguiente;
    private JButton btnUltimo;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox10;
    private JCheckBox jCheckBox11;
    private JCheckBox jCheckBox12;
    private JCheckBox jCheckBox13;
    private JCheckBox jCheckBox14;
    private JCheckBox jCheckBox15;
    private JCheckBox jCheckBox16;
    private JCheckBox jCheckBox17;
    private JCheckBox jCheckBox18;
    private JCheckBox jCheckBox19;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox20;
    private JCheckBox jCheckBox21;
    private JCheckBox jCheckBox22;
    private JCheckBox jCheckBox23;
    private JCheckBox jCheckBox24;
    private JCheckBox jCheckBox25;
    private JCheckBox jCheckBox26;
    private JCheckBox jCheckBox27;
    private JCheckBox jCheckBox28;
    private JCheckBox jCheckBox29;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox30;
    private JCheckBox jCheckBox31;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox6;
    private JCheckBox jCheckBox7;
    private JCheckBox jCheckBox8;
    private JCheckBox jCheckBox9;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel4;
    private JLabel label;
    private JLabel label1;
    private JTabbedPane panel;
    private JPanel panelMG;
    private JTextField txtEdad;
    private JTextField txtEscala;
    private JFormattedTextField txtFecha;
    private JTextField txtTotal;
    private int puntajeMG = 0;
    private int encontrado = 0;
    private int tipoGrabado = 0;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();

    public ValoracionMotora(String IdAtencion, String IdPaciente) {
        initComponents();
        this.IdAtencion = IdAtencion;
        this.IdPaciente = IdPaciente;
        traerEdad();
        cargarAtenciones();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.panel = new JTabbedPane();
        this.jPanel4 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.panelMG = new JPanel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jCheckBox5 = new JCheckBox();
        this.jCheckBox6 = new JCheckBox();
        this.jCheckBox7 = new JCheckBox();
        this.jCheckBox8 = new JCheckBox();
        this.jCheckBox9 = new JCheckBox();
        this.jCheckBox10 = new JCheckBox();
        this.jCheckBox11 = new JCheckBox();
        this.jCheckBox12 = new JCheckBox();
        this.jCheckBox13 = new JCheckBox();
        this.jCheckBox14 = new JCheckBox();
        this.jCheckBox15 = new JCheckBox();
        this.jCheckBox16 = new JCheckBox();
        this.jCheckBox17 = new JCheckBox();
        this.jCheckBox18 = new JCheckBox();
        this.jCheckBox19 = new JCheckBox();
        this.jCheckBox20 = new JCheckBox();
        this.jCheckBox21 = new JCheckBox();
        this.jCheckBox22 = new JCheckBox();
        this.jCheckBox23 = new JCheckBox();
        this.jCheckBox24 = new JCheckBox();
        this.jCheckBox25 = new JCheckBox();
        this.jCheckBox26 = new JCheckBox();
        this.jCheckBox27 = new JCheckBox();
        this.jCheckBox28 = new JCheckBox();
        this.jCheckBox29 = new JCheckBox();
        this.jCheckBox30 = new JCheckBox();
        this.jCheckBox31 = new JCheckBox();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.jLabel50 = new JLabel();
        this.txtEdad = new JTextField();
        this.jLabel51 = new JLabel();
        this.jLabel14 = new JLabel();
        this.txtFecha = new JFormattedTextField();
        this.label = new JLabel();
        this.txtTotal = new JTextField();
        this.label1 = new JLabel();
        this.txtEscala = new JTextField();
        this.btnEscala = new JButton();
        this.btnNuevo = new JButton();
        this.btnGrabar = new JButton();
        this.btnPrimer = new JButton();
        this.btnAnterior = new JButton();
        this.btnSiguiente = new JButton();
        this.btnUltimo = new JButton();
        setName("P_ValoracionMotora");
        setLayout(null);
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("VALORACIÓN DEL DESARROLLO POR CONDUCTA");
        this.jLabel1.setOpaque(true);
        add(this.jLabel1);
        this.jLabel1.setBounds(10, 0, 800, 30);
        this.panel.setForeground(new Color(0, 102, 102));
        this.panel.setFont(new Font("Arial", 1, 14));
        this.jPanel4.setLayout((LayoutManager) null);
        this.jLabel2.setBackground(new Color(0, 51, 153));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 255, 255));
        this.jLabel2.setHorizontalAlignment(2);
        this.jLabel2.setText("EDAD EN MESES    CONCEPTO                                                                       CONCEPTO                                                        EDAD EN MESES");
        this.jLabel2.setOpaque(true);
        this.jPanel4.add(this.jLabel2);
        this.jLabel2.setBounds(10, 10, 780, 20);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 153));
        this.jLabel3.setText("< 1");
        this.jPanel4.add(this.jLabel3);
        this.jLabel3.setBounds(10, 40, 50, 15);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 102, 102));
        this.jLabel4.setText("1 a 3");
        this.jPanel4.add(this.jLabel4);
        this.jLabel4.setBounds(10, 60, 50, 15);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(new Color(0, 0, 153));
        this.jLabel5.setText("4 a 6");
        this.jPanel4.add(this.jLabel5);
        this.jLabel5.setBounds(10, 130, 50, 15);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 102, 102));
        this.jLabel6.setText("7 a 9");
        this.jPanel4.add(this.jLabel6);
        this.jLabel6.setBounds(10, 200, 50, 15);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 153));
        this.jLabel7.setText("10 a 12");
        this.jPanel4.add(this.jLabel7);
        this.jLabel7.setBounds(10, 280, 50, 15);
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(new Color(0, 102, 102));
        this.jLabel8.setText("13 a 18");
        this.jPanel4.add(this.jLabel8);
        this.jLabel8.setBounds(10, 340, 50, 15);
        this.panelMG.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.panelMG.setLayout((LayoutManager) null);
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setForeground(new Color(0, 0, 153));
        this.jCheckBox1.setText("Patea Vigorosamente");
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.1
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox1);
        this.jCheckBox1.setBounds(10, 0, 230, 23);
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setForeground(new Color(0, 102, 102));
        this.jCheckBox2.setText("Levanta la cabeza en prona");
        this.jCheckBox2.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.2
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox2ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox2);
        this.jCheckBox2.setBounds(10, 20, 270, 23);
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setForeground(new Color(0, 102, 102));
        this.jCheckBox3.setText("Levanta la cabeza y pecho en prona");
        this.jCheckBox3.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.3
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox3ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox3);
        this.jCheckBox3.setBounds(10, 40, 280, 23);
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setForeground(new Color(0, 102, 102));
        this.jCheckBox4.setText("Sostiene la cabeza al levantarlo de los brazos");
        this.jCheckBox4.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.4
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox4ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox4);
        this.jCheckBox4.setBounds(10, 60, 300, 23);
        this.jCheckBox5.setFont(new Font("Arial", 1, 12));
        this.jCheckBox5.setForeground(new Color(0, 0, 153));
        this.jCheckBox5.setText("Control de cabeza sentado");
        this.jCheckBox5.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.5
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox5ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox5);
        this.jCheckBox5.setBounds(10, 90, 240, 23);
        this.jCheckBox6.setFont(new Font("Arial", 1, 12));
        this.jCheckBox6.setForeground(new Color(0, 0, 153));
        this.jCheckBox6.setText("Se voltea de un lado a otro");
        this.jCheckBox6.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.6
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox6ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox6);
        this.jCheckBox6.setBounds(10, 110, 210, 23);
        this.jCheckBox7.setFont(new Font("Arial", 1, 12));
        this.jCheckBox7.setForeground(new Color(0, 0, 153));
        this.jCheckBox7.setText("Intenta sentarse solo");
        this.jCheckBox7.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.7
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox7ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox7);
        this.jCheckBox7.setBounds(10, 130, 230, 23);
        this.jCheckBox8.setFont(new Font("Arial", 1, 12));
        this.jCheckBox8.setForeground(new Color(0, 102, 102));
        this.jCheckBox8.setText("Se sostiene sentado con ayuda");
        this.jCheckBox8.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.8
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox8ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox8);
        this.jCheckBox8.setBounds(10, 160, 260, 23);
        this.jCheckBox9.setFont(new Font("Arial", 1, 12));
        this.jCheckBox9.setForeground(new Color(0, 102, 102));
        this.jCheckBox9.setText("Se arrastra en posición prona");
        this.jCheckBox9.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.9
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox9ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox9);
        this.jCheckBox9.setBounds(10, 180, 240, 23);
        this.jCheckBox10.setFont(new Font("Arial", 1, 12));
        this.jCheckBox10.setForeground(new Color(0, 102, 102));
        this.jCheckBox10.setText("Se sienta por si solo");
        this.jCheckBox10.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.10
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox10ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox10);
        this.jCheckBox10.setBounds(10, 200, 190, 23);
        this.jCheckBox11.setFont(new Font("Arial", 1, 12));
        this.jCheckBox11.setForeground(new Color(0, 0, 153));
        this.jCheckBox11.setText("Gatea bien");
        this.jCheckBox11.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.11
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox11ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox11);
        this.jCheckBox11.setBounds(10, 230, 110, 23);
        this.jCheckBox12.setFont(new Font("Arial", 1, 12));
        this.jCheckBox12.setForeground(new Color(0, 0, 153));
        this.jCheckBox12.setText("Se agarra y sostiene de pie");
        this.jCheckBox12.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.12
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox12ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox12);
        this.jCheckBox12.setBounds(10, 250, 200, 23);
        this.jCheckBox13.setFont(new Font("Arial", 1, 12));
        this.jCheckBox13.setForeground(new Color(0, 0, 153));
        this.jCheckBox13.setText("Se para solo");
        this.jCheckBox13.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.13
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox13ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox13);
        this.jCheckBox13.setBounds(10, 270, 160, 23);
        this.jCheckBox14.setFont(new Font("Arial", 1, 12));
        this.jCheckBox14.setForeground(new Color(0, 102, 102));
        this.jCheckBox14.setText("Da pasito solo");
        this.jCheckBox14.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.14
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox14ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox14);
        this.jCheckBox14.setBounds(10, 300, 140, 23);
        this.jCheckBox15.setFont(new Font("Arial", 1, 12));
        this.jCheckBox15.setForeground(new Color(0, 102, 102));
        this.jCheckBox15.setText("Camina solo bien");
        this.jCheckBox15.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.15
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox15ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox15);
        this.jCheckBox15.setBounds(10, 320, 170, 23);
        this.jCheckBox16.setFont(new Font("Arial", 1, 12));
        this.jCheckBox16.setForeground(new Color(0, 102, 102));
        this.jCheckBox16.setText("Corre");
        this.jCheckBox16.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.16
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox16ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox16);
        this.jCheckBox16.setBounds(10, 340, 110, 23);
        this.jCheckBox17.setFont(new Font("Arial", 1, 12));
        this.jCheckBox17.setForeground(new Color(0, 0, 153));
        this.jCheckBox17.setText("Patea la pelota");
        this.jCheckBox17.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.17
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox17ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox17);
        this.jCheckBox17.setBounds(310, 20, 130, 23);
        this.jCheckBox18.setFont(new Font("Arial", 1, 12));
        this.jCheckBox18.setForeground(new Color(0, 0, 153));
        this.jCheckBox18.setText("Lanza la pelota con las manos");
        this.jCheckBox18.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.18
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox18ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox18);
        this.jCheckBox18.setBounds(310, 40, 220, 23);
        this.jCheckBox19.setFont(new Font("Arial", 1, 12));
        this.jCheckBox19.setForeground(new Color(0, 0, 153));
        this.jCheckBox19.setText("Salta en los 2 pies");
        this.jCheckBox19.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.19
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox19ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox19);
        this.jCheckBox19.setBounds(310, 60, 180, 23);
        this.jCheckBox20.setFont(new Font("Arial", 1, 12));
        this.jCheckBox20.setForeground(new Color(0, 102, 102));
        this.jCheckBox20.setText("Se empina en ambos pies");
        this.jCheckBox20.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.20
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox20ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox20);
        this.jCheckBox20.setBounds(310, 90, 230, 23);
        this.jCheckBox21.setFont(new Font("Arial", 1, 12));
        this.jCheckBox21.setForeground(new Color(0, 102, 102));
        this.jCheckBox21.setText("Se levanta sin usar las manos");
        this.jCheckBox21.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.21
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox21ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox21);
        this.jCheckBox21.setBounds(310, 110, 240, 23);
        this.jCheckBox22.setFont(new Font("Arial", 1, 12));
        this.jCheckBox22.setForeground(new Color(0, 102, 102));
        this.jCheckBox22.setText("Camina hacia atrás");
        this.jCheckBox22.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.22
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox22ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox22);
        this.jCheckBox22.setBounds(310, 130, 180, 23);
        this.jCheckBox23.setFont(new Font("Arial", 1, 12));
        this.jCheckBox23.setForeground(new Color(0, 0, 153));
        this.jCheckBox23.setText("Camina en punta de pies");
        this.jCheckBox23.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.23
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox23ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox23);
        this.jCheckBox23.setBounds(310, 160, 180, 23);
        this.jCheckBox24.setFont(new Font("Arial", 1, 12));
        this.jCheckBox24.setForeground(new Color(0, 0, 153));
        this.jCheckBox24.setText("Se para en un solo pie");
        this.jCheckBox24.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.24
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox24ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox24);
        this.jCheckBox24.setBounds(310, 180, 220, 23);
        this.jCheckBox25.setFont(new Font("Arial", 1, 12));
        this.jCheckBox25.setForeground(new Color(0, 0, 153));
        this.jCheckBox25.setText("Lanza y agarra la pelota");
        this.jCheckBox25.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.25
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox25ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox25);
        this.jCheckBox25.setBounds(310, 200, 230, 23);
        this.jCheckBox26.setFont(new Font("Arial", 1, 12));
        this.jCheckBox26.setForeground(new Color(0, 102, 102));
        this.jCheckBox26.setText("Camina en línea recta");
        this.jCheckBox26.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.26
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox26ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox26);
        this.jCheckBox26.setBounds(310, 230, 230, 23);
        this.jCheckBox27.setFont(new Font("Arial", 1, 12));
        this.jCheckBox27.setForeground(new Color(0, 102, 102));
        this.jCheckBox27.setText("Tres o mas pasos en un pie");
        this.jCheckBox27.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.27
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox27ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox27);
        this.jCheckBox27.setBounds(310, 250, 250, 23);
        this.jCheckBox28.setFont(new Font("Arial", 1, 12));
        this.jCheckBox28.setForeground(new Color(0, 102, 102));
        this.jCheckBox28.setText("Hace rebotar y agarra la pelota");
        this.jCheckBox28.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.28
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox28ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox28);
        this.jCheckBox28.setBounds(310, 270, 230, 23);
        this.jCheckBox29.setFont(new Font("Arial", 1, 12));
        this.jCheckBox29.setForeground(new Color(0, 0, 153));
        this.jCheckBox29.setText("Salta a pies juntillas cuerda a 25 cms");
        this.jCheckBox29.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.29
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox29ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox29);
        this.jCheckBox29.setBounds(310, 300, 260, 23);
        this.jCheckBox30.setFont(new Font("Arial", 1, 12));
        this.jCheckBox30.setForeground(new Color(0, 0, 153));
        this.jCheckBox30.setText("Hace \"Caballitos\" alternando los pies");
        this.jCheckBox30.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.30
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox30ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox30);
        this.jCheckBox30.setBounds(310, 320, 260, 23);
        this.jCheckBox31.setFont(new Font("Arial", 1, 12));
        this.jCheckBox31.setForeground(new Color(0, 0, 153));
        this.jCheckBox31.setText("Salta desde 60 cms de altura");
        this.jCheckBox31.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.31
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.jCheckBox31ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox31);
        this.jCheckBox31.setBounds(310, 340, 220, 23);
        this.jPanel4.add(this.panelMG);
        this.panelMG.setBounds(60, 40, 570, 370);
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(new Color(0, 0, 153));
        this.jLabel9.setText("19 a 24");
        this.jLabel9.setFocusable(false);
        this.jPanel4.add(this.jLabel9);
        this.jLabel9.setBounds(650, 60, 50, 15);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(0, 102, 102));
        this.jLabel10.setText("25 a 36");
        this.jPanel4.add(this.jLabel10);
        this.jLabel10.setBounds(650, 130, 50, 15);
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(0, 0, 153));
        this.jLabel11.setText("37 a 48");
        this.jPanel4.add(this.jLabel11);
        this.jLabel11.setBounds(650, 200, 50, 15);
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(0, 102, 102));
        this.jLabel12.setText("49 a 60");
        this.jPanel4.add(this.jLabel12);
        this.jLabel12.setBounds(650, 270, 50, 15);
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(0, 0, 153));
        this.jLabel13.setText("61 a 72");
        this.jPanel4.add(this.jLabel13);
        this.jLabel13.setBounds(650, 340, 50, 15);
        this.panel.addTab("Motricidad Gruesa", this.jPanel4);
        add(this.panel);
        this.panel.setBounds(10, 50, 798, 440);
        this.jLabel50.setFont(new Font("Arial", 1, 14));
        this.jLabel50.setForeground(new Color(0, 0, 204));
        this.jLabel50.setText("Meses");
        add(this.jLabel50);
        this.jLabel50.setBounds(750, 40, 60, 30);
        this.txtEdad.setEditable(false);
        this.txtEdad.setFont(new Font("Arial", 1, 12));
        this.txtEdad.setForeground(new Color(0, 0, 153));
        this.txtEdad.setHorizontalAlignment(0);
        add(this.txtEdad);
        this.txtEdad.setBounds(660, 40, 80, 30);
        this.jLabel51.setFont(new Font("Arial", 1, 14));
        this.jLabel51.setForeground(new Color(0, 0, 204));
        this.jLabel51.setText("Edad Actual");
        add(this.jLabel51);
        this.jLabel51.setBounds(560, 40, 100, 30);
        this.jLabel14.setFont(new Font("Arial", 1, 14));
        this.jLabel14.setForeground(new Color(0, 0, 153));
        this.jLabel14.setText("Fecha de la Atención");
        add(this.jLabel14);
        this.jLabel14.setBounds(210, 40, 160, 30);
        this.txtFecha.setBackground(new Color(0, 51, 153));
        this.txtFecha.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getDateInstance(2))));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setDisabledTextColor(new Color(255, 255, 255));
        this.txtFecha.setEnabled(false);
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        add(this.txtFecha);
        this.txtFecha.setBounds(360, 40, 110, 30);
        this.label.setBackground(new Color(0, 51, 153));
        this.label.setFont(new Font("Arial", 1, 18));
        this.label.setForeground(new Color(255, 255, 204));
        this.label.setHorizontalAlignment(2);
        this.label.setText("Sumatoria Total");
        this.label.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.label.setOpaque(true);
        add(this.label);
        this.label.setBounds(10, 490, 160, 30);
        this.txtTotal.setBackground(new Color(0, 51, 153));
        this.txtTotal.setFont(new Font("Arial", 1, 18));
        this.txtTotal.setForeground(new Color(255, 255, 255));
        this.txtTotal.setHorizontalAlignment(0);
        this.txtTotal.setText("0");
        this.txtTotal.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtTotal.setDisabledTextColor(new Color(0, 204, 204));
        this.txtTotal.setEnabled(false);
        add(this.txtTotal);
        this.txtTotal.setBounds(170, 490, 140, 30);
        this.label1.setBackground(new Color(0, 51, 153));
        this.label1.setFont(new Font("Arial", 1, 18));
        this.label1.setForeground(new Color(255, 255, 204));
        this.label1.setHorizontalAlignment(2);
        this.label1.setText("Escala");
        this.label1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.label1.setOpaque(true);
        this.label1.addAncestorListener(new AncestorListener() { // from class: PyP.ValoracionMotora.32
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
                ValoracionMotora.this.label1AncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
            }
        });
        add(this.label1);
        this.label1.setBounds(310, 490, 120, 30);
        this.txtEscala.setBackground(new Color(0, 51, 153));
        this.txtEscala.setFont(new Font("Tahoma", 1, 18));
        this.txtEscala.setForeground(new Color(255, 255, 255));
        this.txtEscala.setHorizontalAlignment(0);
        this.txtEscala.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtEscala.setDisabledTextColor(new Color(0, 204, 204));
        this.txtEscala.setEnabled(false);
        add(this.txtEscala);
        this.txtEscala.setBounds(430, 490, 170, 30);
        this.btnEscala.setFont(new Font("Arial", 1, 12));
        this.btnEscala.setForeground(new Color(0, 0, 153));
        this.btnEscala.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.btnEscala.setText("Calcular Escala");
        this.btnEscala.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.33
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.btnEscalaActionPerformed(evt);
            }
        });
        add(this.btnEscala);
        this.btnEscala.setBounds(610, 490, 200, 35);
        this.btnNuevo.setFont(new Font("Arial", 1, 12));
        this.btnNuevo.setForeground(new Color(0, 0, 153));
        this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.btnNuevo.setText("Nuevo");
        this.btnNuevo.setFocusable(false);
        this.btnNuevo.setHorizontalAlignment(11);
        this.btnNuevo.setMaximumSize(new Dimension(111, 33));
        this.btnNuevo.setMinimumSize(new Dimension(111, 33));
        this.btnNuevo.setPreferredSize(new Dimension(111, 33));
        this.btnNuevo.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.34
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.btnNuevoActionPerformed(evt);
            }
        });
        add(this.btnNuevo);
        this.btnNuevo.setBounds(10, 530, 110, 33);
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setForeground(new Color(0, 0, 153));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.setFocusable(false);
        this.btnGrabar.setHorizontalAlignment(11);
        this.btnGrabar.setMaximumSize(new Dimension(111, 33));
        this.btnGrabar.setMinimumSize(new Dimension(111, 33));
        this.btnGrabar.setPreferredSize(new Dimension(111, 33));
        this.btnGrabar.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.35
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.btnGrabarActionPerformed(evt);
            }
        });
        add(this.btnGrabar);
        this.btnGrabar.setBounds(130, 530, 110, 33);
        this.btnPrimer.setBackground(new Color(255, 255, 255));
        this.btnPrimer.setFont(new Font("Arial", 1, 12));
        this.btnPrimer.setForeground(new Color(0, 0, 153));
        this.btnPrimer.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_primer.png")));
        this.btnPrimer.setText("Primer");
        this.btnPrimer.setFocusable(false);
        this.btnPrimer.setHorizontalAlignment(11);
        this.btnPrimer.setMaximumSize(new Dimension(90, 33));
        this.btnPrimer.setMinimumSize(new Dimension(90, 33));
        this.btnPrimer.setPreferredSize(new Dimension(59, 33));
        this.btnPrimer.setVerticalTextPosition(3);
        this.btnPrimer.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.36
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.btnPrimerActionPerformed(evt);
            }
        });
        add(this.btnPrimer);
        this.btnPrimer.setBounds(260, 530, 110, 33);
        this.btnAnterior.setBackground(new Color(255, 255, 255));
        this.btnAnterior.setFont(new Font("Arial", 1, 12));
        this.btnAnterior.setForeground(new Color(0, 0, 153));
        this.btnAnterior.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_anterior.png")));
        this.btnAnterior.setText("Anterior");
        this.btnAnterior.setFocusable(false);
        this.btnAnterior.setHorizontalAlignment(11);
        this.btnAnterior.setMaximumSize(new Dimension(90, 33));
        this.btnAnterior.setMinimumSize(new Dimension(90, 33));
        this.btnAnterior.setVerticalTextPosition(3);
        this.btnAnterior.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.37
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.btnAnteriorActionPerformed(evt);
            }
        });
        add(this.btnAnterior);
        this.btnAnterior.setBounds(370, 530, 120, 33);
        this.btnSiguiente.setBackground(new Color(255, 255, 255));
        this.btnSiguiente.setFont(new Font("Arial", 1, 12));
        this.btnSiguiente.setForeground(new Color(0, 0, 153));
        this.btnSiguiente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_siguiente.png")));
        this.btnSiguiente.setText("Siguiente");
        this.btnSiguiente.setFocusable(false);
        this.btnSiguiente.setHorizontalAlignment(11);
        this.btnSiguiente.setMaximumSize(new Dimension(90, 33));
        this.btnSiguiente.setMinimumSize(new Dimension(90, 33));
        this.btnSiguiente.setVerticalTextPosition(3);
        this.btnSiguiente.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.38
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.btnSiguienteActionPerformed(evt);
            }
        });
        add(this.btnSiguiente);
        this.btnSiguiente.setBounds(490, 530, 120, 33);
        this.btnUltimo.setBackground(new Color(255, 255, 255));
        this.btnUltimo.setFont(new Font("Arial", 1, 12));
        this.btnUltimo.setForeground(new Color(0, 0, 153));
        this.btnUltimo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_ultimo.png")));
        this.btnUltimo.setText("Ultimo");
        this.btnUltimo.setFocusable(false);
        this.btnUltimo.setHorizontalAlignment(11);
        this.btnUltimo.setMaximumSize(new Dimension(90, 33));
        this.btnUltimo.setMinimumSize(new Dimension(90, 33));
        this.btnUltimo.setVerticalTextPosition(3);
        this.btnUltimo.addActionListener(new ActionListener() { // from class: PyP.ValoracionMotora.39
            public void actionPerformed(ActionEvent evt) {
                ValoracionMotora.this.btnUltimoActionPerformed(evt);
            }
        });
        add(this.btnUltimo);
        this.btnUltimo.setBounds(610, 530, 110, 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox2ActionPerformed(ActionEvent evt) {
        puntuacionMG(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox3ActionPerformed(ActionEvent evt) {
        puntuacionMG(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox4ActionPerformed(ActionEvent evt) {
        puntuacionMG(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox5ActionPerformed(ActionEvent evt) {
        puntuacionMG(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox6ActionPerformed(ActionEvent evt) {
        puntuacionMG(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox7ActionPerformed(ActionEvent evt) {
        puntuacionMG(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox8ActionPerformed(ActionEvent evt) {
        puntuacionMG(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox9ActionPerformed(ActionEvent evt) {
        puntuacionMG(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox10ActionPerformed(ActionEvent evt) {
        puntuacionMG(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox11ActionPerformed(ActionEvent evt) {
        puntuacionMG(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox12ActionPerformed(ActionEvent evt) {
        puntuacionMG(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox13ActionPerformed(ActionEvent evt) {
        puntuacionMG(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox14ActionPerformed(ActionEvent evt) {
        puntuacionMG(13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox15ActionPerformed(ActionEvent evt) {
        puntuacionMG(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox16ActionPerformed(ActionEvent evt) {
        puntuacionMG(15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox17ActionPerformed(ActionEvent evt) {
        puntuacionMG(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox18ActionPerformed(ActionEvent evt) {
        puntuacionMG(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox19ActionPerformed(ActionEvent evt) {
        puntuacionMG(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox20ActionPerformed(ActionEvent evt) {
        puntuacionMG(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox21ActionPerformed(ActionEvent evt) {
        puntuacionMG(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox22ActionPerformed(ActionEvent evt) {
        puntuacionMG(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox23ActionPerformed(ActionEvent evt) {
        puntuacionMG(22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox24ActionPerformed(ActionEvent evt) {
        puntuacionMG(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox25ActionPerformed(ActionEvent evt) {
        puntuacionMG(24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox26ActionPerformed(ActionEvent evt) {
        puntuacionMG(25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox27ActionPerformed(ActionEvent evt) {
        puntuacionMG(26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox28ActionPerformed(ActionEvent evt) {
        puntuacionMG(27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox29ActionPerformed(ActionEvent evt) {
        puntuacionMG(28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox30ActionPerformed(ActionEvent evt) {
        puntuacionMG(29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox31ActionPerformed(ActionEvent evt) {
        puntuacionMG(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        puntuacionMG(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void label1AncestorAdded(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEscalaActionPerformed(ActionEvent evt) {
        calcularEscala();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPrimerActionPerformed(ActionEvent evt) {
        navegar(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAnteriorActionPerformed(ActionEvent evt) {
        navegar(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSiguienteActionPerformed(ActionEvent evt) {
        navegar(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnUltimoActionPerformed(ActionEvent evt) {
        navegar(4);
    }

    private void cargarAtenciones() {
        this.metodos = new Metodos();
        this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Motora FROM baseserver.p_atencioninfantilprescolar WHERE (IdPersona ='" + this.IdPaciente + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.last();
            if (this.rs.getRow() > 0) {
                this.encontrado = 1;
                navegar(4);
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(ValoracionLenguaje.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void calcularEscala() {
        this.sql = "SELECT Id, EdadIni, EdadFin, MGBajaIni, MGBajaFin, MGMediaIni, MGMediaFin, MGMedioAltoIni, MGMedioAltoFin, MGAltaIni FROM baseserver.p_param_crec_desarrollo";
        this.rs = this.consultas.traerRs(this.sql);
        int i = 0;
        while (true) {
            try {
                if (!this.rs.next()) {
                    break;
                }
                if (Integer.parseInt(this.txtEdad.getText()) >= this.rs.getInt(2) && Integer.parseInt(this.txtEdad.getText()) <= this.rs.getInt(3)) {
                    for (int col = 4; col < 11; col++) {
                        if (Integer.parseInt(this.txtTotal.getText()) >= this.rs.getInt(col)) {
                            if (this.rs.getMetaData().getColumnName(col).equals("MGBajaIni") || this.rs.getMetaData().getColumnName(col).equals("MGBajaFin")) {
                                this.txtEscala.setForeground(new Color(204, 0, 51));
                                this.txtEscala.setText("Alerta");
                            } else if (this.rs.getMetaData().getColumnName(col).equals("MGMediaIni") || this.rs.getMetaData().getColumnName(col).equals("MGMediaFin")) {
                                this.txtEscala.setForeground(new Color(204, 255, 255));
                                this.txtEscala.setText("Media");
                            } else if (this.rs.getMetaData().getColumnName(col).equals("MGMedioAltoIni") || this.rs.getMetaData().getColumnName(col).equals("MGMedioAltoFin")) {
                                this.txtEscala.setForeground(new Color(0, 0, 204));
                                this.txtEscala.setText("Medio Alto");
                            } else {
                                this.txtEscala.setForeground(new Color(255, 255, 255));
                                this.txtEscala.setText("ALTO");
                            }
                        }
                    }
                } else {
                    i++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ValoracionMotora.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void grabar() {
        if (Integer.parseInt(this.txtTotal.getText()) < 1) {
            this.metodos.mostrarMensaje("Por favor evalue la Motricidad Gruesa");
            return;
        }
        if (this.tipoGrabado == 0) {
            this.sql = "INSERT INTO p_atencioninfantilprescolar (IdAtencion, IdPersona, FechaAtencion, Motora, Fecha, UsuarioS) VALUES ('" + this.IdAtencion + "','" + this.IdPaciente + "','" + this.txtFecha.getText() + "','" + this.txtTotal.getText() + "','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.metodos.mostrarMensaje("Valoración Motora Gruesa Grabada");
        } else {
            this.sql = "UPDATE p_atencioninfantilprescolar SET FechaAtencion ='" + this.txtFecha.getText() + "', Motora ='" + this.txtTotal.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (IdAtencion = '" + this.IdAtencion + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.metodos.mostrarMensaje("Valoración Motora Gruesa Modificada");
        }
        cargarAtenciones();
    }

    private void navegar(int op) {
        if (this.encontrado == 1) {
            try {
                if (op == 1) {
                    this.rs.first();
                } else if (op == 2) {
                    if (!this.rs.first()) {
                        this.rs.previous();
                    }
                } else if (op == 3) {
                    if (!this.rs.last()) {
                        this.rs.next();
                    }
                } else if (op == 4) {
                    this.rs.last();
                }
                this.txtFecha.setText(this.rs.getString(3));
                puntuacionMG(this.rs.getInt(4));
                this.txtEscala.setText("");
                this.tipoGrabado = 1;
            } catch (SQLException ex) {
                Logger.getLogger(ValoracionMotora.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void nuevo() {
        navegar(4);
        this.txtFecha.setText(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()));
        this.tipoGrabado = 0;
    }

    private void puntuacionMG(int p) {
        this.puntajeMG = 0;
        for (int i = 0; i < this.panelMG.getComponentCount(); i++) {
            if (this.panelMG.getComponent(i).getClass().toString().equals("class javax.swing.JCheckBox")) {
                JCheckBox chk = this.panelMG.getComponent(i);
                if (i <= p) {
                    chk.setSelected(true);
                    this.puntajeMG++;
                } else {
                    chk.setSelected(false);
                }
            }
        }
        this.txtTotal.setText(String.valueOf(this.puntajeMG));
    }

    private void traerEdad() {
        this.sql = "SELECT FechaNac FROM baseserver.g_persona WHERE (Id ='" + this.IdPaciente + "')";
        String fechaNacimiento = this.consultas.traerDato(this.sql);
        if (fechaNacimiento.isEmpty()) {
            this.txtEdad.setText("0");
        } else {
            this.txtEdad.setText(this.metodos.entregarEdadEnMeses(fechaNacimiento));
        }
        this.consultas.cerrarConexionBd();
    }
}
