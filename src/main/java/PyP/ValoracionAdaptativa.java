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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/* JADX INFO: loaded from: GenomaP.jar:PyP/ValoracionAdaptativa.class */
public class ValoracionAdaptativa extends JPanel {
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
    private JCheckBox jCheckBox32;
    private JCheckBox jCheckBox33;
    private JCheckBox jCheckBox34;
    private JCheckBox jCheckBox35;
    private JCheckBox jCheckBox36;
    private JCheckBox jCheckBox37;
    private JCheckBox jCheckBox38;
    private JCheckBox jCheckBox39;
    private JCheckBox jCheckBox40;
    private JCheckBox jCheckBox41;
    private JCheckBox jCheckBox42;
    private JCheckBox jCheckBox43;
    private JCheckBox jCheckBox44;
    private JCheckBox jCheckBox45;
    private JCheckBox jCheckBox46;
    private JCheckBox jCheckBox47;
    private JCheckBox jCheckBox48;
    private JCheckBox jCheckBox49;
    private JCheckBox jCheckBox50;
    private JCheckBox jCheckBox51;
    private JCheckBox jCheckBox52;
    private JCheckBox jCheckBox53;
    private JCheckBox jCheckBox54;
    private JCheckBox jCheckBox55;
    private JCheckBox jCheckBox56;
    private JCheckBox jCheckBox57;
    private JCheckBox jCheckBox58;
    private JCheckBox jCheckBox59;
    private JCheckBox jCheckBox60;
    private JCheckBox jCheckBox61;
    private JCheckBox jCheckBox62;
    private JLabel jLabel1;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel23;
    private JLabel jLabel24;
    private JLabel jLabel25;
    private JLabel jLabel50;
    private JLabel jLabel51;
    private JPanel jPanel5;
    private JLabel label1;
    private JLabel label2;
    private JTabbedPane panel;
    private JPanel panelMF;
    private JTextField txtEdad;
    private JTextField txtEscala;
    private JTextField txtFecha;
    private JTextField txtTotal;
    private int puntajeMF = 0;
    private int tipoGrabado = 0;
    private int encontrado = 0;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();

    public ValoracionAdaptativa(String IdAtencion, String IdPaciente) {
        initComponents();
        this.IdAtencion = IdAtencion;
        this.IdPaciente = IdPaciente;
        traerEdad();
        cargarAtenciones();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.panel = new JTabbedPane();
        this.jPanel5 = new JPanel();
        this.jLabel14 = new JLabel();
        this.jLabel15 = new JLabel();
        this.jLabel16 = new JLabel();
        this.jLabel17 = new JLabel();
        this.jLabel20 = new JLabel();
        this.jLabel22 = new JLabel();
        this.jLabel24 = new JLabel();
        this.panelMF = new JPanel();
        this.jCheckBox32 = new JCheckBox();
        this.jCheckBox33 = new JCheckBox();
        this.jCheckBox34 = new JCheckBox();
        this.jCheckBox35 = new JCheckBox();
        this.jCheckBox36 = new JCheckBox();
        this.jCheckBox37 = new JCheckBox();
        this.jCheckBox38 = new JCheckBox();
        this.jCheckBox39 = new JCheckBox();
        this.jCheckBox40 = new JCheckBox();
        this.jCheckBox41 = new JCheckBox();
        this.jCheckBox42 = new JCheckBox();
        this.jCheckBox43 = new JCheckBox();
        this.jCheckBox44 = new JCheckBox();
        this.jCheckBox45 = new JCheckBox();
        this.jCheckBox46 = new JCheckBox();
        this.jCheckBox47 = new JCheckBox();
        this.jCheckBox48 = new JCheckBox();
        this.jCheckBox49 = new JCheckBox();
        this.jCheckBox50 = new JCheckBox();
        this.jCheckBox51 = new JCheckBox();
        this.jCheckBox52 = new JCheckBox();
        this.jCheckBox53 = new JCheckBox();
        this.jCheckBox54 = new JCheckBox();
        this.jCheckBox55 = new JCheckBox();
        this.jCheckBox56 = new JCheckBox();
        this.jCheckBox57 = new JCheckBox();
        this.jCheckBox58 = new JCheckBox();
        this.jCheckBox59 = new JCheckBox();
        this.jCheckBox60 = new JCheckBox();
        this.jCheckBox61 = new JCheckBox();
        this.jCheckBox62 = new JCheckBox();
        this.jLabel18 = new JLabel();
        this.jLabel19 = new JLabel();
        this.jLabel21 = new JLabel();
        this.jLabel23 = new JLabel();
        this.jLabel25 = new JLabel();
        this.jLabel51 = new JLabel();
        this.txtEdad = new JTextField();
        this.jLabel50 = new JLabel();
        this.jLabel2 = new JLabel();
        this.txtFecha = new JTextField();
        this.label1 = new JLabel();
        this.txtTotal = new JTextField();
        this.label2 = new JLabel();
        this.txtEscala = new JTextField();
        this.btnEscala = new JButton();
        this.btnNuevo = new JButton();
        this.btnGrabar = new JButton();
        this.btnPrimer = new JButton();
        this.btnAnterior = new JButton();
        this.btnSiguiente = new JButton();
        this.btnUltimo = new JButton();
        setName("P_ValoracionAdaptativa");
        setLayout(null);
        this.jLabel1.setBackground(new Color(0, 51, 153));
        this.jLabel1.setFont(new Font("Tahoma", 1, 14));
        this.jLabel1.setForeground(new Color(204, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("VALORACIÓN DEL DESARROLO POR CONDUCTAS");
        this.jLabel1.setOpaque(true);
        add(this.jLabel1);
        this.jLabel1.setBounds(10, 0, 800, 30);
        this.panel.setForeground(new Color(0, 102, 102));
        this.panel.setFont(new Font("Tahoma", 1, 12));
        this.jPanel5.setLayout((LayoutManager) null);
        this.jLabel14.setBackground(new Color(0, 51, 153));
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(0, 255, 255));
        this.jLabel14.setHorizontalAlignment(2);
        this.jLabel14.setText("EDAD EN MESES   CONCEPTO                                                                                CONCEPTO                                                   EDAD EN MESES");
        this.jLabel14.setOpaque(true);
        this.jPanel5.add(this.jLabel14);
        this.jLabel14.setBounds(20, 10, 720, 20);
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(0, 0, 153));
        this.jLabel15.setText("< 1");
        this.jPanel5.add(this.jLabel15);
        this.jLabel15.setBounds(10, 50, 50, 15);
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(new Color(0, 102, 102));
        this.jLabel16.setText("1 a 3");
        this.jPanel5.add(this.jLabel16);
        this.jLabel16.setBounds(10, 90, 50, 15);
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setForeground(new Color(0, 0, 153));
        this.jLabel17.setText("4 a 6");
        this.jPanel5.add(this.jLabel17);
        this.jLabel17.setBounds(10, 160, 50, 15);
        this.jLabel20.setFont(new Font("Arial", 1, 12));
        this.jLabel20.setForeground(new Color(0, 102, 102));
        this.jLabel20.setText("7 a 9");
        this.jPanel5.add(this.jLabel20);
        this.jLabel20.setBounds(10, 230, 50, 15);
        this.jLabel22.setFont(new Font("Arial", 1, 12));
        this.jLabel22.setForeground(new Color(0, 0, 153));
        this.jLabel22.setText("10 a 12");
        this.jPanel5.add(this.jLabel22);
        this.jLabel22.setBounds(10, 300, 50, 15);
        this.jLabel24.setFont(new Font("Arial", 1, 12));
        this.jLabel24.setForeground(new Color(0, 102, 102));
        this.jLabel24.setText("13 a 18");
        this.jPanel5.add(this.jLabel24);
        this.jLabel24.setBounds(10, 370, 50, 15);
        this.panelMF.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.panelMF.setLayout((LayoutManager) null);
        this.jCheckBox32.setFont(new Font("Arial", 1, 12));
        this.jCheckBox32.setForeground(new Color(0, 0, 153));
        this.jCheckBox32.setText("Sigue movimiento horizontal y vertical del objeto");
        this.jCheckBox32.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.1
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox32ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox32);
        this.jCheckBox32.setBounds(10, 10, 410, 23);
        this.jCheckBox33.setFont(new Font("Arial", 1, 12));
        this.jCheckBox33.setForeground(new Color(0, 102, 102));
        this.jCheckBox33.setText("Abre y mira sus manos");
        this.jCheckBox33.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.2
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox33ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox33);
        this.jCheckBox33.setBounds(10, 40, 190, 23);
        this.jCheckBox34.setFont(new Font("Arial", 1, 12));
        this.jCheckBox34.setForeground(new Color(0, 102, 102));
        this.jCheckBox34.setText("Sostiene objeto en la mano");
        this.jCheckBox34.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.3
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox34ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox34);
        this.jCheckBox34.setBounds(10, 60, 220, 23);
        this.jCheckBox35.setFont(new Font("Arial", 1, 12));
        this.jCheckBox35.setForeground(new Color(0, 102, 102));
        this.jCheckBox35.setText("Se lleva objeto a la boca");
        this.jCheckBox35.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.4
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox35ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox35);
        this.jCheckBox35.setBounds(10, 80, 270, 23);
        this.jCheckBox36.setFont(new Font("Arial", 1, 12));
        this.jCheckBox36.setForeground(new Color(0, 0, 153));
        this.jCheckBox36.setText("Agarra objeto voluntariamente");
        this.jCheckBox36.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.5
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox36ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox36);
        this.jCheckBox36.setBounds(10, 110, 270, 23);
        this.jCheckBox37.setFont(new Font("Arial", 1, 12));
        this.jCheckBox37.setForeground(new Color(0, 0, 153));
        this.jCheckBox37.setText("Sostiene un objeto en cada mano");
        this.jCheckBox37.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.6
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox37ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox37);
        this.jCheckBox37.setBounds(10, 130, 270, 23);
        this.jCheckBox38.setFont(new Font("Arial", 1, 12));
        this.jCheckBox38.setForeground(new Color(0, 0, 153));
        this.jCheckBox38.setText("Pasa objeto de una mano a otra");
        this.jCheckBox38.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.7
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox38ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox38);
        this.jCheckBox38.setBounds(10, 150, 270, 23);
        this.jCheckBox39.setFont(new Font("Arial", 1, 12));
        this.jCheckBox39.setForeground(new Color(0, 102, 102));
        this.jCheckBox39.setText("Manipula varios objetos a la vez");
        this.jCheckBox39.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.8
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox39ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox39);
        this.jCheckBox39.setBounds(10, 180, 270, 23);
        this.jCheckBox40.setFont(new Font("Arial", 1, 12));
        this.jCheckBox40.setForeground(new Color(0, 102, 102));
        this.jCheckBox40.setText("Agarra objeto pequeño con los dedos");
        this.jCheckBox40.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.9
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox40ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox40);
        this.jCheckBox40.setBounds(10, 200, 270, 23);
        this.jCheckBox41.setFont(new Font("Arial", 1, 12));
        this.jCheckBox41.setForeground(new Color(0, 102, 102));
        this.jCheckBox41.setText("Agarra cubo con pulgar e indice");
        this.jCheckBox41.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.10
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox41ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox41);
        this.jCheckBox41.setBounds(10, 220, 270, 23);
        this.jCheckBox42.setFont(new Font("Arial", 1, 12));
        this.jCheckBox42.setForeground(new Color(0, 0, 153));
        this.jCheckBox42.setText("Mete y saca objetos en caja");
        this.jCheckBox42.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.11
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox42ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox42);
        this.jCheckBox42.setBounds(10, 250, 270, 23);
        this.jCheckBox43.setFont(new Font("Arial", 1, 12));
        this.jCheckBox43.setForeground(new Color(0, 0, 153));
        this.jCheckBox43.setText("Agarra tercer objeto sin soltar otros");
        this.jCheckBox43.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.12
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox43ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox43);
        this.jCheckBox43.setBounds(10, 270, 270, 23);
        this.jCheckBox44.setFont(new Font("Arial", 1, 12));
        this.jCheckBox44.setForeground(new Color(0, 0, 153));
        this.jCheckBox44.setText("Busca objetos escondidos");
        this.jCheckBox44.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.13
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox44ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox44);
        this.jCheckBox44.setBounds(10, 290, 270, 23);
        this.jCheckBox45.setFont(new Font("Arial", 1, 12));
        this.jCheckBox45.setForeground(new Color(0, 102, 102));
        this.jCheckBox45.setText("Hace torre de tres cubos");
        this.jCheckBox45.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.14
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox45ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox45);
        this.jCheckBox45.setBounds(10, 320, 270, 23);
        this.jCheckBox46.setFont(new Font("Arial", 1, 12));
        this.jCheckBox46.setForeground(new Color(0, 102, 102));
        this.jCheckBox46.setText("Pasa hojas de un libro");
        this.jCheckBox46.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.15
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox46ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox46);
        this.jCheckBox46.setBounds(10, 340, 270, 23);
        this.jCheckBox47.setFont(new Font("Arial", 1, 12));
        this.jCheckBox47.setForeground(new Color(0, 102, 102));
        this.jCheckBox47.setText("Anticipa salida del objeto");
        this.jCheckBox47.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.16
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox47ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox47);
        this.jCheckBox47.setBounds(10, 360, 270, 23);
        this.jCheckBox48.setFont(new Font("Arial", 1, 12));
        this.jCheckBox48.setForeground(new Color(0, 0, 153));
        this.jCheckBox48.setText("Tapa bien la caja");
        this.jCheckBox48.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.17
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox48ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox48);
        this.jCheckBox48.setBounds(320, 40, 240, 23);
        this.jCheckBox49.setFont(new Font("Arial", 1, 12));
        this.jCheckBox49.setForeground(new Color(0, 0, 153));
        this.jCheckBox49.setText("Hace garabatos circulares");
        this.jCheckBox49.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.18
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox49ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox49);
        this.jCheckBox49.setBounds(320, 60, 260, 23);
        this.jCheckBox50.setFont(new Font("Arial", 1, 12));
        this.jCheckBox50.setForeground(new Color(0, 0, 153));
        this.jCheckBox50.setText("Hace torre de 5 o mas cubos");
        this.jCheckBox50.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.19
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox50ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox50);
        this.jCheckBox50.setBounds(320, 80, 260, 23);
        this.jCheckBox51.setFont(new Font("Arial", 1, 12));
        this.jCheckBox51.setForeground(new Color(0, 102, 102));
        this.jCheckBox51.setText("Ensarta 6 o mas cuentas");
        this.jCheckBox51.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.20
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox51ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox51);
        this.jCheckBox51.setBounds(320, 110, 210, 23);
        this.jCheckBox52.setFont(new Font("Arial", 1, 12));
        this.jCheckBox52.setForeground(new Color(0, 102, 102));
        this.jCheckBox52.setText("Copia línea horizontal y vertical");
        this.jCheckBox52.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.21
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox52ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox52);
        this.jCheckBox52.setBounds(320, 130, 220, 23);
        this.jCheckBox53.setFont(new Font("Arial", 1, 12));
        this.jCheckBox53.setForeground(new Color(0, 102, 102));
        this.jCheckBox53.setText("Separa objetos grandes y pequeños");
        this.jCheckBox53.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.22
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox53ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox53);
        this.jCheckBox53.setBounds(320, 150, 260, 23);
        this.jCheckBox54.setFont(new Font("Arial", 1, 12));
        this.jCheckBox54.setForeground(new Color(0, 0, 153));
        this.jCheckBox54.setText("Figura humana rudimentaria I");
        this.jCheckBox54.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.23
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox54ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox54);
        this.jCheckBox54.setBounds(320, 180, 210, 23);
        this.jCheckBox55.setFont(new Font("Arial", 1, 12));
        this.jCheckBox55.setForeground(new Color(0, 0, 153));
        this.jCheckBox55.setText("Corta papel con las tijeras");
        this.jCheckBox55.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.24
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox55ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox55);
        this.jCheckBox55.setBounds(320, 200, 220, 23);
        this.jCheckBox56.setFont(new Font("Arial", 1, 12));
        this.jCheckBox56.setForeground(new Color(0, 0, 153));
        this.jCheckBox56.setText("Copia cuadrado y círculo");
        this.jCheckBox56.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.25
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox56ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox56);
        this.jCheckBox56.setBounds(320, 220, 220, 23);
        this.jCheckBox57.setFont(new Font("Arial", 1, 12));
        this.jCheckBox57.setForeground(new Color(0, 102, 102));
        this.jCheckBox57.setText("Dibuja figura humana II");
        this.jCheckBox57.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.26
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox57ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox57);
        this.jCheckBox57.setBounds(320, 250, 220, 20);
        this.jCheckBox58.setFont(new Font("Arial", 1, 12));
        this.jCheckBox58.setForeground(new Color(0, 102, 102));
        this.jCheckBox58.setText("Agrupa por color y forma");
        this.jCheckBox58.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.27
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox58ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox58);
        this.jCheckBox58.setBounds(320, 270, 220, 23);
        this.jCheckBox59.setFont(new Font("Arial", 1, 12));
        this.jCheckBox59.setForeground(new Color(0, 102, 102));
        this.jCheckBox59.setText("Dibuja escalera (imita)");
        this.jCheckBox59.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.28
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox59ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox59);
        this.jCheckBox59.setBounds(320, 290, 230, 23);
        this.jCheckBox60.setFont(new Font("Arial", 1, 12));
        this.jCheckBox60.setForeground(new Color(0, 0, 153));
        this.jCheckBox60.setText("Agrupa por color, forma y tamaño");
        this.jCheckBox60.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.29
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox60ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox60);
        this.jCheckBox60.setBounds(320, 320, 250, 23);
        this.jCheckBox61.setFont(new Font("Arial", 1, 12));
        this.jCheckBox61.setForeground(new Color(0, 0, 153));
        this.jCheckBox61.setText("Recosntruye escalera de 10 cubos");
        this.jCheckBox61.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.30
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox61ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox61);
        this.jCheckBox61.setBounds(320, 340, 250, 23);
        this.jCheckBox62.setFont(new Font("Arial", 1, 12));
        this.jCheckBox62.setForeground(new Color(0, 0, 153));
        this.jCheckBox62.setText("Dibuja casa");
        this.jCheckBox62.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.31
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.jCheckBox62ActionPerformed(evt);
            }
        });
        this.panelMF.add(this.jCheckBox62);
        this.jCheckBox62.setBounds(320, 360, 220, 23);
        this.jPanel5.add(this.panelMF);
        this.panelMF.setBounds(70, 40, 580, 400);
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setForeground(new Color(0, 0, 153));
        this.jLabel18.setText("19 a 24");
        this.jLabel18.setFocusable(false);
        this.jPanel5.add(this.jLabel18);
        this.jLabel18.setBounds(680, 80, 50, 15);
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setForeground(new Color(0, 102, 102));
        this.jLabel19.setText("25 a 36");
        this.jPanel5.add(this.jLabel19);
        this.jLabel19.setBounds(680, 150, 50, 15);
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setForeground(new Color(0, 0, 153));
        this.jLabel21.setText("37 a 48");
        this.jPanel5.add(this.jLabel21);
        this.jLabel21.setBounds(680, 230, 50, 15);
        this.jLabel23.setFont(new Font("Arial", 1, 12));
        this.jLabel23.setForeground(new Color(0, 102, 102));
        this.jLabel23.setText("49 a 60");
        this.jPanel5.add(this.jLabel23);
        this.jLabel23.setBounds(680, 290, 50, 15);
        this.jLabel25.setFont(new Font("Arial", 1, 12));
        this.jLabel25.setForeground(new Color(0, 0, 153));
        this.jLabel25.setText("61 a 72");
        this.jPanel5.add(this.jLabel25);
        this.jLabel25.setBounds(680, 360, 50, 15);
        this.panel.addTab("Motricidad Fina o Adaptativa", this.jPanel5);
        add(this.panel);
        this.panel.setBounds(10, 50, 798, 460);
        this.jLabel51.setFont(new Font("Arial", 1, 14));
        this.jLabel51.setForeground(new Color(0, 0, 204));
        this.jLabel51.setText("Edad Actual");
        add(this.jLabel51);
        this.jLabel51.setBounds(550, 36, 100, 30);
        this.txtEdad.setEditable(false);
        this.txtEdad.setFont(new Font("Arial", 1, 12));
        this.txtEdad.setForeground(new Color(0, 0, 153));
        this.txtEdad.setHorizontalAlignment(0);
        add(this.txtEdad);
        this.txtEdad.setBounds(660, 40, 80, 30);
        this.jLabel50.setFont(new Font("Arial", 1, 14));
        this.jLabel50.setForeground(new Color(0, 0, 204));
        this.jLabel50.setText("Meses");
        add(this.jLabel50);
        this.jLabel50.setBounds(750, 36, 60, 30);
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(0, 0, 204));
        this.jLabel2.setText("Fecha de la Atención");
        add(this.jLabel2);
        this.jLabel2.setBounds(230, 30, 150, 30);
        this.txtFecha.setBackground(new Color(0, 0, 153));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setDisabledTextColor(new Color(255, 255, 255));
        this.txtFecha.setEnabled(false);
        add(this.txtFecha);
        this.txtFecha.setBounds(380, 40, 150, 30);
        this.label1.setBackground(new Color(0, 51, 153));
        this.label1.setFont(new Font("Arial", 1, 18));
        this.label1.setForeground(new Color(255, 255, 255));
        this.label1.setHorizontalAlignment(0);
        this.label1.setText("Sumatoria Total");
        this.label1.setOpaque(true);
        add(this.label1);
        this.label1.setBounds(10, 520, 180, 30);
        this.txtTotal.setBackground(new Color(0, 51, 153));
        this.txtTotal.setFont(new Font("Arial", 1, 18));
        this.txtTotal.setForeground(new Color(255, 255, 255));
        this.txtTotal.setHorizontalAlignment(0);
        this.txtTotal.setText("0");
        this.txtTotal.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtTotal.setDisabledTextColor(new Color(0, 204, 204));
        this.txtTotal.setEnabled(false);
        add(this.txtTotal);
        this.txtTotal.setBounds(190, 520, 140, 30);
        this.label2.setBackground(new Color(0, 51, 153));
        this.label2.setFont(new Font("Arial", 1, 18));
        this.label2.setForeground(new Color(255, 255, 204));
        this.label2.setHorizontalAlignment(2);
        this.label2.setText("Escala");
        this.label2.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.label2.setOpaque(true);
        add(this.label2);
        this.label2.setBounds(330, 520, 110, 30);
        this.txtEscala.setBackground(new Color(0, 51, 153));
        this.txtEscala.setFont(new Font("Tahoma", 1, 18));
        this.txtEscala.setForeground(new Color(255, 255, 255));
        this.txtEscala.setHorizontalAlignment(0);
        this.txtEscala.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.txtEscala.setDisabledTextColor(new Color(0, 204, 204));
        this.txtEscala.setEnabled(false);
        add(this.txtEscala);
        this.txtEscala.setBounds(440, 520, 170, 30);
        this.btnEscala.setFont(new Font("Arial", 1, 12));
        this.btnEscala.setForeground(new Color(0, 0, 204));
        this.btnEscala.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.btnEscala.setText("Calcular Escala");
        this.btnEscala.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.32
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.btnEscalaActionPerformed(evt);
            }
        });
        add(this.btnEscala);
        this.btnEscala.setBounds(617, 520, 190, 35);
        this.btnNuevo.setFont(new Font("Arial", 1, 12));
        this.btnNuevo.setForeground(new Color(0, 0, 204));
        this.btnNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.btnNuevo.setText("Nuevo");
        this.btnNuevo.setMaximumSize(new Dimension(111, 33));
        this.btnNuevo.setMinimumSize(new Dimension(111, 33));
        this.btnNuevo.setPreferredSize(new Dimension(111, 33));
        this.btnNuevo.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.33
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.btnNuevoActionPerformed(evt);
            }
        });
        add(this.btnNuevo);
        this.btnNuevo.setBounds(10, 560, 110, 33);
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setForeground(new Color(0, 0, 204));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.setMaximumSize(new Dimension(111, 33));
        this.btnGrabar.setMinimumSize(new Dimension(111, 33));
        this.btnGrabar.setPreferredSize(new Dimension(111, 33));
        this.btnGrabar.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.34
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.btnGrabarActionPerformed(evt);
            }
        });
        add(this.btnGrabar);
        this.btnGrabar.setBounds(120, 560, 110, 33);
        this.btnPrimer.setFont(new Font("Arial", 1, 12));
        this.btnPrimer.setForeground(new Color(0, 0, 204));
        this.btnPrimer.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_primer.png")));
        this.btnPrimer.setText("Primer");
        this.btnPrimer.setFocusable(false);
        this.btnPrimer.setHorizontalAlignment(11);
        this.btnPrimer.setMaximumSize(new Dimension(111, 33));
        this.btnPrimer.setMinimumSize(new Dimension(111, 33));
        this.btnPrimer.setPreferredSize(new Dimension(111, 33));
        this.btnPrimer.setVerticalTextPosition(3);
        this.btnPrimer.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.35
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.btnPrimerActionPerformed(evt);
            }
        });
        add(this.btnPrimer);
        this.btnPrimer.setBounds(240, 560, 110, 33);
        this.btnAnterior.setFont(new Font("Arial", 1, 12));
        this.btnAnterior.setForeground(new Color(0, 0, 204));
        this.btnAnterior.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_anterior.png")));
        this.btnAnterior.setText("Anterior");
        this.btnAnterior.setFocusable(false);
        this.btnAnterior.setHorizontalAlignment(11);
        this.btnAnterior.setMaximumSize(new Dimension(111, 33));
        this.btnAnterior.setMinimumSize(new Dimension(111, 33));
        this.btnAnterior.setPreferredSize(new Dimension(111, 33));
        this.btnAnterior.setVerticalTextPosition(3);
        this.btnAnterior.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.36
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.btnAnteriorActionPerformed(evt);
            }
        });
        add(this.btnAnterior);
        this.btnAnterior.setBounds(350, 560, 120, 33);
        this.btnSiguiente.setFont(new Font("Arial", 1, 12));
        this.btnSiguiente.setForeground(new Color(0, 0, 204));
        this.btnSiguiente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_siguiente.png")));
        this.btnSiguiente.setText("Siguiente");
        this.btnSiguiente.setFocusable(false);
        this.btnSiguiente.setHorizontalAlignment(11);
        this.btnSiguiente.setMaximumSize(new Dimension(111, 33));
        this.btnSiguiente.setMinimumSize(new Dimension(111, 33));
        this.btnSiguiente.setPreferredSize(new Dimension(111, 33));
        this.btnSiguiente.setVerticalTextPosition(3);
        this.btnSiguiente.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.37
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.btnSiguienteActionPerformed(evt);
            }
        });
        add(this.btnSiguiente);
        this.btnSiguiente.setBounds(470, 560, 120, 33);
        this.btnUltimo.setFont(new Font("Arial", 1, 12));
        this.btnUltimo.setForeground(new Color(0, 0, 204));
        this.btnUltimo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/b_ultimo.png")));
        this.btnUltimo.setText("Ultimo");
        this.btnUltimo.setFocusable(false);
        this.btnUltimo.setHorizontalAlignment(11);
        this.btnUltimo.setMaximumSize(new Dimension(111, 33));
        this.btnUltimo.setMinimumSize(new Dimension(111, 33));
        this.btnUltimo.setPreferredSize(new Dimension(111, 33));
        this.btnUltimo.setVerticalTextPosition(3);
        this.btnUltimo.addActionListener(new ActionListener() { // from class: PyP.ValoracionAdaptativa.38
            public void actionPerformed(ActionEvent evt) {
                ValoracionAdaptativa.this.btnUltimoActionPerformed(evt);
            }
        });
        add(this.btnUltimo);
        this.btnUltimo.setBounds(590, 560, 110, 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox32ActionPerformed(ActionEvent evt) {
        puntuacionMF(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox33ActionPerformed(ActionEvent evt) {
        puntuacionMF(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox34ActionPerformed(ActionEvent evt) {
        puntuacionMF(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox35ActionPerformed(ActionEvent evt) {
        puntuacionMF(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox36ActionPerformed(ActionEvent evt) {
        puntuacionMF(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox37ActionPerformed(ActionEvent evt) {
        puntuacionMF(5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox38ActionPerformed(ActionEvent evt) {
        puntuacionMF(6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox39ActionPerformed(ActionEvent evt) {
        puntuacionMF(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox40ActionPerformed(ActionEvent evt) {
        puntuacionMF(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox41ActionPerformed(ActionEvent evt) {
        puntuacionMF(9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox42ActionPerformed(ActionEvent evt) {
        puntuacionMF(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox43ActionPerformed(ActionEvent evt) {
        puntuacionMF(11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox44ActionPerformed(ActionEvent evt) {
        puntuacionMF(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox45ActionPerformed(ActionEvent evt) {
        puntuacionMF(13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox46ActionPerformed(ActionEvent evt) {
        puntuacionMF(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox47ActionPerformed(ActionEvent evt) {
        puntuacionMF(15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox48ActionPerformed(ActionEvent evt) {
        puntuacionMF(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox49ActionPerformed(ActionEvent evt) {
        puntuacionMF(17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox50ActionPerformed(ActionEvent evt) {
        puntuacionMF(18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox51ActionPerformed(ActionEvent evt) {
        puntuacionMF(19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox52ActionPerformed(ActionEvent evt) {
        puntuacionMF(20);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox53ActionPerformed(ActionEvent evt) {
        puntuacionMF(21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox54ActionPerformed(ActionEvent evt) {
        puntuacionMF(22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox55ActionPerformed(ActionEvent evt) {
        puntuacionMF(23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox56ActionPerformed(ActionEvent evt) {
        puntuacionMF(24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox57ActionPerformed(ActionEvent evt) {
        puntuacionMF(25);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox58ActionPerformed(ActionEvent evt) {
        puntuacionMF(26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox59ActionPerformed(ActionEvent evt) {
        puntuacionMF(27);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox60ActionPerformed(ActionEvent evt) {
        puntuacionMF(28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox61ActionPerformed(ActionEvent evt) {
        puntuacionMF(29);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jCheckBox62ActionPerformed(ActionEvent evt) {
        puntuacionMF(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEscalaActionPerformed(ActionEvent evt) {
        calcularEscala();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNuevoActionPerformed(ActionEvent evt) {
        nuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    private void cargarAtenciones() {
        this.metodos = new Metodos();
        this.sql = "SELECT IdAtencion, IdPersona, FechaAtencion, Adaptativa FROM baseserver.p_atencioninfantilprescolar WHERE (IdPersona ='" + this.IdPaciente + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            this.rs.last();
            if (this.rs.getRow() > 0) {
                this.encontrado = 1;
                navegar(4);
            }
            this.rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ValoracionLenguaje.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void calcularEscala() {
        this.sql = "SELECT Id, EdadIni, EdadFin, MFBajaIni, MFBajaFin, MFMediaIni, MFMediaFin, MFMedioAltoIni, MFMedioAltoFin, MFAltaIni FROM baseserver.p_param_crec_desarrollo";
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
                            if (this.rs.getMetaData().getColumnName(col).equals("MFBajaIni") || this.rs.getMetaData().getColumnName(col).equals("MFBajaFin")) {
                                this.txtEscala.setForeground(new Color(204, 0, 51));
                                this.txtEscala.setText("Alerta");
                            } else if (this.rs.getMetaData().getColumnName(col).equals("MFMediaIni") || this.rs.getMetaData().getColumnName(col).equals("MFMediaFin")) {
                                this.txtEscala.setForeground(new Color(204, 255, 255));
                                this.txtEscala.setText("Media");
                            } else if (this.rs.getMetaData().getColumnName(col).equals("MFMedioAltoIni") || this.rs.getMetaData().getColumnName(col).equals("MFMedioAltoFin")) {
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
                Logger.getLogger(ValoracionAdaptativa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    private void grabar() {
        if (Integer.parseInt(this.txtTotal.getText()) < 1) {
            this.metodos.mostrarMensaje("Por favor evalue la Motricidad Fina o Adaptativa");
            return;
        }
        if (this.tipoGrabado == 0) {
            this.sql = "INSERT INTO p_atencioninfantilprescolar (IdAtencion, IdPersona, FechaAtencion, Adaptativa, Fecha, UsuarioS) VALUES ('" + this.IdAtencion + "','" + this.IdPaciente + "','" + this.txtFecha.getText() + "','" + this.txtTotal.getText() + "','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.metodos.mostrarMensaje("Valoración Adaptativa Grabada");
        } else {
            this.sql = "UPDATE p_atencioninfantilprescolar SET FechaAtencion ='" + this.txtFecha.getText() + "', Adaptativa ='" + this.txtTotal.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', UsuarioS ='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE (IdAtencion = '" + this.IdAtencion + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
            this.metodos.mostrarMensaje("Valoración Adaptativa Modificada");
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
                puntuacionMF(this.rs.getInt(4));
                this.txtEscala.setText("");
                this.tipoGrabado = 1;
            } catch (SQLException ex) {
                Logger.getLogger(ValoracionAdaptativa.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void nuevo() {
        navegar(4);
        this.txtFecha.setText(this.metodos.formatoAMD.format(this.metodos.getFechaActual()));
        this.tipoGrabado = 0;
    }

    private void puntuacionMF(int p) {
        this.puntajeMF = 0;
        for (int i = 0; i < this.panelMF.getComponentCount(); i++) {
            if (this.panelMF.getComponent(i).getClass().toString().equals("class javax.swing.JCheckBox")) {
                JCheckBox chk = this.panelMF.getComponent(i);
                if (i <= p) {
                    chk.setSelected(true);
                    this.puntajeMF++;
                } else {
                    chk.setSelected(false);
                }
            }
        }
        this.txtTotal.setText(String.valueOf(this.puntajeMF));
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
