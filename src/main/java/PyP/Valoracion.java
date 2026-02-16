package PyP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:PyP/Valoracion.class */
public class Valoracion extends JPanel {
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
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JToolBar.Separator jSeparator1;
    private JToolBar.Separator jSeparator2;
    private JToolBar.Separator jSeparator3;
    private JToolBar.Separator jSeparator4;
    private JToolBar.Separator jSeparator5;
    private JToolBar.Separator jSeparator6;
    private JToolBar jToolBar1;
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

    public Valoracion(String IdAtencion, String IdPaciente) {
        initComponents();
        this.IdAtencion = "11";
        this.IdPaciente = IdPaciente;
        traerEdad();
        cargarAtenciones();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.panel = new JTabbedPane();
        this.jPanel4 = new JPanel();
        this.panelMG = new JPanel();
        this.jCheckBox29 = new JCheckBox();
        this.jCheckBox30 = new JCheckBox();
        this.jCheckBox31 = new JCheckBox();
        this.jCheckBox1 = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.jCheckBox5 = new JCheckBox();
        this.jCheckBox6 = new JCheckBox();
        this.jCheckBox7 = new JCheckBox();
        this.jPanel3 = new JPanel();
        this.jCheckBox8 = new JCheckBox();
        this.jCheckBox9 = new JCheckBox();
        this.jCheckBox10 = new JCheckBox();
        this.jPanel5 = new JPanel();
        this.jCheckBox11 = new JCheckBox();
        this.jCheckBox12 = new JCheckBox();
        this.jCheckBox13 = new JCheckBox();
        this.jPanel6 = new JPanel();
        this.jCheckBox14 = new JCheckBox();
        this.jCheckBox15 = new JCheckBox();
        this.jCheckBox16 = new JCheckBox();
        this.jPanel8 = new JPanel();
        this.jCheckBox17 = new JCheckBox();
        this.jCheckBox18 = new JCheckBox();
        this.jCheckBox19 = new JCheckBox();
        this.jPanel9 = new JPanel();
        this.jCheckBox20 = new JCheckBox();
        this.jCheckBox21 = new JCheckBox();
        this.jCheckBox22 = new JCheckBox();
        this.jPanel10 = new JPanel();
        this.jCheckBox23 = new JCheckBox();
        this.jCheckBox24 = new JCheckBox();
        this.jCheckBox25 = new JCheckBox();
        this.jPanel7 = new JPanel();
        this.jCheckBox26 = new JCheckBox();
        this.jCheckBox27 = new JCheckBox();
        this.jCheckBox28 = new JCheckBox();
        this.txtEscala = new JTextField();
        this.txtTotal = new JTextField();
        this.txtFecha = new JFormattedTextField();
        this.txtEdad = new JTextField();
        this.jToolBar1 = new JToolBar();
        this.btnNuevo = new JButton();
        this.jSeparator1 = new JToolBar.Separator();
        this.btnGrabar = new JButton();
        this.jSeparator2 = new JToolBar.Separator();
        this.btnEscala = new JButton();
        this.jSeparator3 = new JToolBar.Separator();
        this.btnPrimer = new JButton();
        this.jSeparator4 = new JToolBar.Separator();
        this.btnAnterior = new JButton();
        this.jSeparator5 = new JToolBar.Separator();
        this.btnSiguiente = new JButton();
        this.jSeparator6 = new JToolBar.Separator();
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
        this.jLabel1.setBounds(10, 0, 760, 30);
        this.panel.setForeground(new Color(0, 102, 102));
        this.panel.setFont(new Font("Arial", 1, 14));
        this.jPanel4.setLayout((LayoutManager) null);
        this.panelMG.setBorder(BorderFactory.createTitledBorder((Border) null, "61 a 72 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.panelMG.setLayout((LayoutManager) null);
        this.jCheckBox29.setFont(new Font("Arial", 1, 12));
        this.jCheckBox29.setForeground(new Color(0, 0, 153));
        this.jCheckBox29.setText("Salta a pies juntillas cuerda a 25 cms");
        this.jCheckBox29.addActionListener(new ActionListener() { // from class: PyP.Valoracion.1
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox29ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox29);
        this.jCheckBox29.setBounds(10, 20, 260, 20);
        this.jCheckBox30.setFont(new Font("Arial", 1, 12));
        this.jCheckBox30.setForeground(new Color(0, 0, 153));
        this.jCheckBox30.setText("Hace \"Caballitos\" alternando los pies");
        this.jCheckBox30.addActionListener(new ActionListener() { // from class: PyP.Valoracion.2
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox30ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox30);
        this.jCheckBox30.setBounds(10, 40, 260, 20);
        this.jCheckBox31.setFont(new Font("Arial", 1, 12));
        this.jCheckBox31.setForeground(new Color(0, 0, 153));
        this.jCheckBox31.setText("Salta desde 60 cms de altura");
        this.jCheckBox31.addActionListener(new ActionListener() { // from class: PyP.Valoracion.3
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox31ActionPerformed(evt);
            }
        });
        this.panelMG.add(this.jCheckBox31);
        this.jCheckBox31.setBounds(10, 60, 220, 20);
        this.jPanel4.add(this.panelMG);
        this.panelMG.setBounds(330, 410, 280, 90);
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setForeground(new Color(0, 0, 153));
        this.jCheckBox1.setText("Patea Vigorosamente");
        this.jCheckBox1.setBorder((Border) null);
        this.jCheckBox1.addActionListener(new ActionListener() { // from class: PyP.Valoracion.4
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox1ActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.jCheckBox1);
        this.jCheckBox1.setBounds(20, 10, 230, 20);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "1 a 3 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel1.setFont(new Font("Arial", 1, 12));
        this.jPanel1.setLayout((LayoutManager) null);
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setForeground(new Color(0, 0, 153));
        this.jCheckBox2.setText("Levanta la cabeza en prona");
        this.jCheckBox2.addActionListener(new ActionListener() { // from class: PyP.Valoracion.5
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox2ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jCheckBox2);
        this.jCheckBox2.setBounds(10, 20, 270, 23);
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setForeground(new Color(0, 0, 153));
        this.jCheckBox3.setText("Levanta la cabeza y pecho en prona");
        this.jCheckBox3.addActionListener(new ActionListener() { // from class: PyP.Valoracion.6
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox3ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jCheckBox3);
        this.jCheckBox3.setBounds(10, 40, 280, 23);
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setForeground(new Color(0, 0, 153));
        this.jCheckBox4.setText("Sostiene la cabeza al levantarlo de los brazos");
        this.jCheckBox4.addActionListener(new ActionListener() { // from class: PyP.Valoracion.7
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox4ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jCheckBox4);
        this.jCheckBox4.setBounds(10, 60, 300, 23);
        this.jPanel4.add(this.jPanel1);
        this.jPanel1.setBounds(10, 30, 320, 90);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "4 a 6 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.jCheckBox5.setFont(new Font("Arial", 1, 12));
        this.jCheckBox5.setForeground(new Color(0, 0, 153));
        this.jCheckBox5.setText("Control de cabeza sentado");
        this.jCheckBox5.addActionListener(new ActionListener() { // from class: PyP.Valoracion.8
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox5ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jCheckBox5);
        this.jCheckBox5.setBounds(10, 20, 240, 23);
        this.jCheckBox6.setFont(new Font("Arial", 1, 12));
        this.jCheckBox6.setForeground(new Color(0, 0, 153));
        this.jCheckBox6.setText("Se voltea de un lado a otro");
        this.jCheckBox6.addActionListener(new ActionListener() { // from class: PyP.Valoracion.9
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox6ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jCheckBox6);
        this.jCheckBox6.setBounds(10, 40, 210, 23);
        this.jCheckBox7.setFont(new Font("Arial", 1, 12));
        this.jCheckBox7.setForeground(new Color(0, 0, 153));
        this.jCheckBox7.setText("Intenta sentarse solo");
        this.jCheckBox7.addActionListener(new ActionListener() { // from class: PyP.Valoracion.10
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox7ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jCheckBox7);
        this.jCheckBox7.setBounds(10, 60, 230, 23);
        this.jPanel4.add(this.jPanel2);
        this.jPanel2.setBounds(10, 120, 320, 90);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "7 a 9 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.jCheckBox8.setFont(new Font("Arial", 1, 12));
        this.jCheckBox8.setForeground(new Color(0, 0, 153));
        this.jCheckBox8.setText("Se sostiene sentado con ayuda");
        this.jCheckBox8.addActionListener(new ActionListener() { // from class: PyP.Valoracion.11
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox8ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jCheckBox8);
        this.jCheckBox8.setBounds(10, 20, 260, 23);
        this.jCheckBox9.setFont(new Font("Arial", 1, 12));
        this.jCheckBox9.setForeground(new Color(0, 0, 153));
        this.jCheckBox9.setText("Se arrastra en posición prona");
        this.jCheckBox9.addActionListener(new ActionListener() { // from class: PyP.Valoracion.12
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox9ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jCheckBox9);
        this.jCheckBox9.setBounds(10, 40, 240, 23);
        this.jCheckBox10.setFont(new Font("Arial", 1, 12));
        this.jCheckBox10.setForeground(new Color(0, 0, 153));
        this.jCheckBox10.setText("Se sienta por si solo");
        this.jCheckBox10.addActionListener(new ActionListener() { // from class: PyP.Valoracion.13
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox10ActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.jCheckBox10);
        this.jCheckBox10.setBounds(10, 60, 190, 23);
        this.jPanel4.add(this.jPanel3);
        this.jPanel3.setBounds(10, 220, 320, 90);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "10 a 12 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel5.setLayout((LayoutManager) null);
        this.jCheckBox11.setFont(new Font("Arial", 1, 12));
        this.jCheckBox11.setForeground(new Color(0, 0, 153));
        this.jCheckBox11.setText("Gatea bien");
        this.jCheckBox11.addActionListener(new ActionListener() { // from class: PyP.Valoracion.14
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox11ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jCheckBox11);
        this.jCheckBox11.setBounds(10, 20, 110, 23);
        this.jCheckBox12.setFont(new Font("Arial", 1, 12));
        this.jCheckBox12.setForeground(new Color(0, 0, 153));
        this.jCheckBox12.setText("Se agarra y sostiene de pie");
        this.jCheckBox12.addActionListener(new ActionListener() { // from class: PyP.Valoracion.15
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox12ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jCheckBox12);
        this.jCheckBox12.setBounds(10, 40, 200, 23);
        this.jCheckBox13.setFont(new Font("Arial", 1, 12));
        this.jCheckBox13.setForeground(new Color(0, 0, 153));
        this.jCheckBox13.setText("Se para solo");
        this.jCheckBox13.addActionListener(new ActionListener() { // from class: PyP.Valoracion.16
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox13ActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.jCheckBox13);
        this.jCheckBox13.setBounds(10, 60, 160, 23);
        this.jPanel4.add(this.jPanel5);
        this.jPanel5.setBounds(10, 320, 320, 90);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "13 a 18 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel6.setLayout((LayoutManager) null);
        this.jCheckBox14.setFont(new Font("Arial", 1, 12));
        this.jCheckBox14.setForeground(new Color(0, 0, 153));
        this.jCheckBox14.setText("Da pasito solo");
        this.jCheckBox14.addActionListener(new ActionListener() { // from class: PyP.Valoracion.17
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox14ActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.jCheckBox14);
        this.jCheckBox14.setBounds(10, 20, 140, 23);
        this.jCheckBox15.setFont(new Font("Arial", 1, 12));
        this.jCheckBox15.setForeground(new Color(0, 0, 153));
        this.jCheckBox15.setText("Camina solo bien");
        this.jCheckBox15.addActionListener(new ActionListener() { // from class: PyP.Valoracion.18
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox15ActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.jCheckBox15);
        this.jCheckBox15.setBounds(10, 40, 170, 23);
        this.jCheckBox16.setFont(new Font("Arial", 1, 12));
        this.jCheckBox16.setForeground(new Color(0, 0, 153));
        this.jCheckBox16.setText("Correo");
        this.jCheckBox16.addActionListener(new ActionListener() { // from class: PyP.Valoracion.19
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox16ActionPerformed(evt);
            }
        });
        this.jPanel6.add(this.jCheckBox16);
        this.jCheckBox16.setBounds(10, 60, 110, 23);
        this.jPanel4.add(this.jPanel6);
        this.jPanel6.setBounds(10, 410, 320, 90);
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "19 a 24 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel8.setLayout((LayoutManager) null);
        this.jCheckBox17.setFont(new Font("Arial", 1, 12));
        this.jCheckBox17.setForeground(new Color(0, 0, 153));
        this.jCheckBox17.setText("Patea la pelota");
        this.jCheckBox17.addActionListener(new ActionListener() { // from class: PyP.Valoracion.20
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox17ActionPerformed(evt);
            }
        });
        this.jPanel8.add(this.jCheckBox17);
        this.jCheckBox17.setBounds(10, 20, 130, 23);
        this.jCheckBox18.setFont(new Font("Arial", 1, 12));
        this.jCheckBox18.setForeground(new Color(0, 0, 153));
        this.jCheckBox18.setText("Lanza la pelota con las manos");
        this.jCheckBox18.addActionListener(new ActionListener() { // from class: PyP.Valoracion.21
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox18ActionPerformed(evt);
            }
        });
        this.jPanel8.add(this.jCheckBox18);
        this.jCheckBox18.setBounds(10, 40, 220, 23);
        this.jCheckBox19.setFont(new Font("Arial", 1, 12));
        this.jCheckBox19.setForeground(new Color(0, 0, 153));
        this.jCheckBox19.setText("Salta en los 2 pies");
        this.jCheckBox19.addActionListener(new ActionListener() { // from class: PyP.Valoracion.22
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox19ActionPerformed(evt);
            }
        });
        this.jPanel8.add(this.jCheckBox19);
        this.jCheckBox19.setBounds(10, 60, 180, 23);
        this.jPanel4.add(this.jPanel8);
        this.jPanel8.setBounds(330, 30, 280, 90);
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "25 a 36 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel9.setLayout((LayoutManager) null);
        this.jCheckBox20.setFont(new Font("Arial", 1, 12));
        this.jCheckBox20.setForeground(new Color(0, 0, 153));
        this.jCheckBox20.setText("Se empina en ambos pies");
        this.jCheckBox20.addActionListener(new ActionListener() { // from class: PyP.Valoracion.23
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox20ActionPerformed(evt);
            }
        });
        this.jPanel9.add(this.jCheckBox20);
        this.jCheckBox20.setBounds(10, 20, 230, 23);
        this.jCheckBox21.setFont(new Font("Arial", 1, 12));
        this.jCheckBox21.setForeground(new Color(0, 0, 153));
        this.jCheckBox21.setText("Se levanta sin usar las manos");
        this.jCheckBox21.addActionListener(new ActionListener() { // from class: PyP.Valoracion.24
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox21ActionPerformed(evt);
            }
        });
        this.jPanel9.add(this.jCheckBox21);
        this.jCheckBox21.setBounds(10, 40, 240, 23);
        this.jCheckBox22.setFont(new Font("Arial", 1, 12));
        this.jCheckBox22.setForeground(new Color(0, 0, 153));
        this.jCheckBox22.setText("Camina hacia atrás");
        this.jCheckBox22.addActionListener(new ActionListener() { // from class: PyP.Valoracion.25
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox22ActionPerformed(evt);
            }
        });
        this.jPanel9.add(this.jCheckBox22);
        this.jCheckBox22.setBounds(10, 60, 180, 23);
        this.jPanel4.add(this.jPanel9);
        this.jPanel9.setBounds(330, 120, 280, 90);
        this.jPanel10.setBorder(BorderFactory.createTitledBorder((Border) null, "37 a 48 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel10.setLayout((LayoutManager) null);
        this.jCheckBox23.setFont(new Font("Arial", 1, 12));
        this.jCheckBox23.setForeground(new Color(0, 0, 153));
        this.jCheckBox23.setText("Camina en punta de pies");
        this.jCheckBox23.addActionListener(new ActionListener() { // from class: PyP.Valoracion.26
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox23ActionPerformed(evt);
            }
        });
        this.jPanel10.add(this.jCheckBox23);
        this.jCheckBox23.setBounds(10, 20, 180, 23);
        this.jCheckBox24.setFont(new Font("Arial", 1, 12));
        this.jCheckBox24.setForeground(new Color(0, 0, 153));
        this.jCheckBox24.setText("Se para en un solo pie");
        this.jCheckBox24.addActionListener(new ActionListener() { // from class: PyP.Valoracion.27
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox24ActionPerformed(evt);
            }
        });
        this.jPanel10.add(this.jCheckBox24);
        this.jCheckBox24.setBounds(10, 40, 220, 23);
        this.jCheckBox25.setFont(new Font("Arial", 1, 12));
        this.jCheckBox25.setForeground(new Color(0, 0, 153));
        this.jCheckBox25.setText("Lanza y agrarra la pelota");
        this.jCheckBox25.addActionListener(new ActionListener() { // from class: PyP.Valoracion.28
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox25ActionPerformed(evt);
            }
        });
        this.jPanel10.add(this.jCheckBox25);
        this.jCheckBox25.setBounds(10, 60, 230, 23);
        this.jPanel4.add(this.jPanel10);
        this.jPanel10.setBounds(330, 220, 280, 90);
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "49 a 60 Meses", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 102)));
        this.jPanel7.setLayout((LayoutManager) null);
        this.jCheckBox26.setFont(new Font("Arial", 1, 12));
        this.jCheckBox26.setForeground(new Color(0, 0, 153));
        this.jCheckBox26.setText("Camina en línea recta");
        this.jCheckBox26.addActionListener(new ActionListener() { // from class: PyP.Valoracion.29
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox26ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jCheckBox26);
        this.jCheckBox26.setBounds(10, 20, 230, 23);
        this.jCheckBox27.setFont(new Font("Arial", 1, 12));
        this.jCheckBox27.setForeground(new Color(0, 0, 153));
        this.jCheckBox27.setText("Tres o mas pasos en un pie");
        this.jCheckBox27.addActionListener(new ActionListener() { // from class: PyP.Valoracion.30
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox27ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jCheckBox27);
        this.jCheckBox27.setBounds(10, 40, 250, 23);
        this.jCheckBox28.setFont(new Font("Arial", 1, 12));
        this.jCheckBox28.setForeground(new Color(0, 0, 153));
        this.jCheckBox28.setText("Hace rebotar y agarra la pelota");
        this.jCheckBox28.addActionListener(new ActionListener() { // from class: PyP.Valoracion.31
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.jCheckBox28ActionPerformed(evt);
            }
        });
        this.jPanel7.add(this.jCheckBox28);
        this.jCheckBox28.setBounds(10, 60, 230, 23);
        this.jPanel4.add(this.jPanel7);
        this.jPanel7.setBounds(330, 320, 280, 90);
        this.txtEscala.setBackground(new Color(0, 0, 153));
        this.txtEscala.setFont(new Font("Arial", 1, 20));
        this.txtEscala.setForeground(new Color(255, 255, 255));
        this.txtEscala.setHorizontalAlignment(0);
        this.txtEscala.setBorder(BorderFactory.createTitledBorder((Border) null, "Escala", 0, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.txtEscala.setDisabledTextColor(new Color(0, 204, 204));
        this.txtEscala.setEnabled(false);
        this.jPanel4.add(this.txtEscala);
        this.txtEscala.setBounds(610, 330, 140, 80);
        this.txtTotal.setBackground(new Color(0, 0, 153));
        this.txtTotal.setFont(new Font("Arial", 1, 20));
        this.txtTotal.setForeground(new Color(255, 255, 255));
        this.txtTotal.setHorizontalAlignment(0);
        this.txtTotal.setText("0");
        this.txtTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Sumatoria Total", 0, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.txtTotal.setDisabledTextColor(new Color(0, 204, 204));
        this.txtTotal.setEnabled(false);
        this.jPanel4.add(this.txtTotal);
        this.txtTotal.setBounds(610, 230, 140, 80);
        this.txtFecha.setBackground(new Color(0, 0, 153));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Atención", 0, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.txtFecha.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("dd/MM/yyyy"))));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setDisabledTextColor(new Color(255, 255, 255));
        this.txtFecha.setEnabled(false);
        this.txtFecha.setFont(new Font("Arial", 1, 20));
        this.jPanel4.add(this.txtFecha);
        this.txtFecha.setBounds(610, 40, 140, 80);
        this.txtEdad.setEditable(false);
        this.txtEdad.setBackground(new Color(0, 0, 153));
        this.txtEdad.setFont(new Font("Arial", 1, 12));
        this.txtEdad.setForeground(new Color(0, 0, 153));
        this.txtEdad.setHorizontalAlignment(0);
        this.txtEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Meses Edad", 0, 0, new Font("Arial", 1, 12), new Color(204, 255, 255)));
        this.txtEdad.setEnabled(false);
        this.jPanel4.add(this.txtEdad);
        this.txtEdad.setBounds(610, 130, 140, 80);
        this.panel.addTab("Motricidad Gruesa", this.jPanel4);
        add(this.panel);
        this.panel.setBounds(10, 30, 760, 540);
        this.jToolBar1.setRollover(true);
        this.btnNuevo.setFont(new Font("Arial", 1, 12));
        this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.btnNuevo.setText("Nuevo");
        this.btnNuevo.setBorder((Border) null);
        this.btnNuevo.setFocusable(false);
        this.btnNuevo.setHorizontalAlignment(11);
        this.btnNuevo.addActionListener(new ActionListener() { // from class: PyP.Valoracion.32
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.btnNuevoActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnNuevo);
        this.jToolBar1.add(this.jSeparator1);
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.setBorder((Border) null);
        this.btnGrabar.setFocusable(false);
        this.btnGrabar.setHorizontalAlignment(11);
        this.btnGrabar.addActionListener(new ActionListener() { // from class: PyP.Valoracion.33
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.btnGrabarActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnGrabar);
        this.jToolBar1.add(this.jSeparator2);
        this.btnEscala.setFont(new Font("Arial", 1, 12));
        this.btnEscala.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.btnEscala.setText("Calcular Escala");
        this.btnEscala.setBorder((Border) null);
        this.btnEscala.addActionListener(new ActionListener() { // from class: PyP.Valoracion.34
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.btnEscalaActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnEscala);
        this.jToolBar1.add(this.jSeparator3);
        this.btnPrimer.setFont(new Font("Arial", 1, 12));
        this.btnPrimer.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_primer.png")));
        this.btnPrimer.setText("Primer");
        this.btnPrimer.setBorder((Border) null);
        this.btnPrimer.setFocusable(false);
        this.btnPrimer.setHorizontalAlignment(11);
        this.btnPrimer.setVerticalTextPosition(3);
        this.btnPrimer.addActionListener(new ActionListener() { // from class: PyP.Valoracion.35
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.btnPrimerActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnPrimer);
        this.jToolBar1.add(this.jSeparator4);
        this.btnAnterior.setFont(new Font("Arial", 1, 12));
        this.btnAnterior.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_anterior.png")));
        this.btnAnterior.setText("Anterior");
        this.btnAnterior.setBorder((Border) null);
        this.btnAnterior.setFocusable(false);
        this.btnAnterior.setHorizontalAlignment(11);
        this.btnAnterior.setVerticalTextPosition(3);
        this.btnAnterior.addActionListener(new ActionListener() { // from class: PyP.Valoracion.36
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.btnAnteriorActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnAnterior);
        this.jToolBar1.add(this.jSeparator5);
        this.btnSiguiente.setFont(new Font("Arial", 1, 12));
        this.btnSiguiente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_siguiente.png")));
        this.btnSiguiente.setText("Siguiente");
        this.btnSiguiente.setBorder((Border) null);
        this.btnSiguiente.setFocusable(false);
        this.btnSiguiente.setHorizontalAlignment(11);
        this.btnSiguiente.setVerticalTextPosition(3);
        this.btnSiguiente.addActionListener(new ActionListener() { // from class: PyP.Valoracion.37
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.btnSiguienteActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnSiguiente);
        this.jToolBar1.add(this.jSeparator6);
        this.btnUltimo.setFont(new Font("Arial", 1, 12));
        this.btnUltimo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_ultimo.png")));
        this.btnUltimo.setText("Ultimo");
        this.btnUltimo.setBorder((Border) null);
        this.btnUltimo.setFocusable(false);
        this.btnUltimo.setHorizontalAlignment(11);
        this.btnUltimo.setVerticalTextPosition(3);
        this.btnUltimo.addActionListener(new ActionListener() { // from class: PyP.Valoracion.38
            public void actionPerformed(ActionEvent evt) {
                Valoracion.this.btnUltimoActionPerformed(evt);
            }
        });
        this.jToolBar1.add(this.btnUltimo);
        add(this.jToolBar1);
        this.jToolBar1.setBounds(10, 580, 760, 40);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox2ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox3ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox4ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox5ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox6ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox7ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox8ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox9ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox10ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox11ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox12ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox13ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox14ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox15ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox16ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox17ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox18ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox19ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox20ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox21ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox22ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox23ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox24ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox25ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox26ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox27ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox28ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox29ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox30ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox31ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox31);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        puntuacionMG(this.jCheckBox1);
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
        this.sql = "SELECT Id, EdadIni, EdadFin, MGBajaIni, MGBajaFin, MGMediaIni, MGMediaFin, MGMedioAltoIni, MGMedioAltoFin, MGAltaIni FROM baseserver.p_parametrosdesarrolloconducta";
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
                this.txtEscala.setText("");
                this.tipoGrabado = 1;
            } catch (SQLException ex) {
                Logger.getLogger(ValoracionMotora.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void nuevo() {
        navegar(4);
        this.txtFecha.setText(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
        this.tipoGrabado = 0;
    }

    private void puntuacionMG(JCheckBox p) {
        if (p.isSelected()) {
            this.puntajeMG++;
        } else {
            this.puntajeMG--;
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
    }
}
