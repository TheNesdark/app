package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPTestFindrisk.class */
public class JPTestFindrisk extends JPanel {
    private int xEdad;
    public DefaultTableModel xmodelo;
    private Object[] xdatos;
    private ButtonGroup IMC;
    private JLabel JLClasificacion;
    private JLabel JLIMC;
    private JLabel JLPerCintura;
    private JLabel JLTotalPuntos;
    private JPanel JPEdad;
    private JPanel JPIMC;
    private JPanel JPIMC1;
    private JPanel JPIMC2;
    private JPanel JPIMC3;
    private JPanel JPIMC4;
    private JPanel JPIMC5;
    private JPanel JPIMC6;
    private JPanel JPTest;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private ButtonGroup actividad_fisica;
    private ButtonGroup cintura;
    private ButtonGroup diabetes;
    private ButtonGroup edad;
    private JRadioButton edad_0;
    private JRadioButton edad_10;
    private JRadioButton edad_11;
    private JRadioButton edad_12;
    private JRadioButton edad_13;
    private JRadioButton edad_14;
    private JRadioButton edad_15;
    private JRadioButton edad_16;
    private JRadioButton edad_17;
    private JRadioButton edad_18;
    private JRadioButton edad_19;
    private JRadioButton edad_2;
    private JRadioButton edad_20;
    private JRadioButton edad_21;
    private JRadioButton edad_22;
    private JRadioButton edad_23;
    private JRadioButton edad_24;
    private JRadioButton edad_3;
    private JRadioButton edad_4;
    private JRadioButton edad_8;
    private JRadioButton edad_9;
    private ButtonGroup glucosa;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private ButtonGroup medicamentos;
    private ButtonGroup verduras;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xOpcion1 = "";
    private String xOpcion2 = "";
    private String xOpcion3 = "";
    private String xOpcion4 = "";
    private String xOpcion5 = "";
    private String xOpcion6 = "";
    private String xOpcion7 = "";
    private String xOpcion8 = "";

    public JPTestFindrisk() {
        initComponents();
        mIniciaComponentes();
        mBuscaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v219, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.edad = new ButtonGroup();
        this.IMC = new ButtonGroup();
        this.cintura = new ButtonGroup();
        this.actividad_fisica = new ButtonGroup();
        this.verduras = new ButtonGroup();
        this.medicamentos = new ButtonGroup();
        this.glucosa = new ButtonGroup();
        this.diabetes = new ButtonGroup();
        this.jTabbedPane1 = new JTabbedPane();
        this.JPTest = new JPanel();
        this.JPEdad = new JPanel();
        this.edad_0 = new JRadioButton();
        this.edad_2 = new JRadioButton();
        this.edad_3 = new JRadioButton();
        this.edad_4 = new JRadioButton();
        this.JPIMC = new JPanel();
        this.edad_8 = new JRadioButton();
        this.edad_9 = new JRadioButton();
        this.edad_10 = new JRadioButton();
        this.JLIMC = new JLabel();
        this.JPIMC1 = new JPanel();
        this.edad_11 = new JRadioButton();
        this.edad_12 = new JRadioButton();
        this.edad_13 = new JRadioButton();
        this.JPIMC2 = new JPanel();
        this.edad_14 = new JRadioButton();
        this.edad_15 = new JRadioButton();
        this.JPIMC3 = new JPanel();
        this.edad_16 = new JRadioButton();
        this.edad_17 = new JRadioButton();
        this.JPIMC4 = new JPanel();
        this.edad_18 = new JRadioButton();
        this.edad_19 = new JRadioButton();
        this.JPIMC5 = new JPanel();
        this.edad_20 = new JRadioButton();
        this.edad_21 = new JRadioButton();
        this.JPIMC6 = new JPanel();
        this.edad_22 = new JRadioButton();
        this.edad_23 = new JRadioButton();
        this.edad_24 = new JRadioButton();
        this.JLTotalPuntos = new JLabel();
        this.JLClasificacion = new JLabel();
        this.JLPerCintura = new JLabel();
        this.jPanel2 = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        setName("jpFindrisk");
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.JPEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "1. Edad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.edad.add(this.edad_0);
        this.edad_0.setFont(new Font("Arial", 1, 12));
        this.edad_0.setText("Menos de 45 años");
        this.edad_0.setName("0");
        this.edad_0.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.1
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_0ActionPerformed(evt);
            }
        });
        this.edad.add(this.edad_2);
        this.edad_2.setFont(new Font("Arial", 1, 12));
        this.edad_2.setText("45-54 años");
        this.edad_2.setName("2");
        this.edad_2.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.2
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_2ActionPerformed(evt);
            }
        });
        this.edad.add(this.edad_3);
        this.edad_3.setFont(new Font("Arial", 1, 12));
        this.edad_3.setText("55-64 años");
        this.edad_3.setName("3");
        this.edad_3.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.3
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_3ActionPerformed(evt);
            }
        });
        this.edad.add(this.edad_4);
        this.edad_4.setFont(new Font("Arial", 1, 12));
        this.edad_4.setText("Más de 64 años");
        this.edad_4.setName("4");
        this.edad_4.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.4
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_4ActionPerformed(evt);
            }
        });
        GroupLayout JPEdadLayout = new GroupLayout(this.JPEdad);
        this.JPEdad.setLayout(JPEdadLayout);
        JPEdadLayout.setHorizontalGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEdadLayout.createSequentialGroup().addContainerGap().addComponent(this.edad_0).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.edad_2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.edad_3).addGap(10, 10, 10).addComponent(this.edad_4).addContainerGap(-1, 32767)));
        JPEdadLayout.setVerticalGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.edad_0).addComponent(this.edad_2).addComponent(this.edad_3).addComponent(this.edad_4)));
        this.JPIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "2. IMC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.IMC.add(this.edad_8);
        this.edad_8.setFont(new Font("Arial", 1, 12));
        this.edad_8.setText("Menor de 25 kg/m2");
        this.edad_8.setName("0");
        this.edad_8.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.5
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_8ActionPerformed(evt);
            }
        });
        this.IMC.add(this.edad_9);
        this.edad_9.setFont(new Font("Arial", 1, 12));
        this.edad_9.setText("Entre 25-30 kg/m2");
        this.edad_9.setName("1");
        this.edad_9.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.6
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_9ActionPerformed(evt);
            }
        });
        this.IMC.add(this.edad_10);
        this.edad_10.setFont(new Font("Arial", 1, 12));
        this.edad_10.setText("Mayor de 30 kg/m2 ");
        this.edad_10.setName("3");
        this.edad_10.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.7
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_10ActionPerformed(evt);
            }
        });
        GroupLayout JPIMCLayout = new GroupLayout(this.JPIMC);
        this.JPIMC.setLayout(JPIMCLayout);
        JPIMCLayout.setHorizontalGroup(JPIMCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMCLayout.createSequentialGroup().addContainerGap().addComponent(this.edad_8).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.edad_9).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.edad_10).addContainerGap(211, 32767)));
        JPIMCLayout.setVerticalGroup(JPIMCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.edad_8).addComponent(this.edad_9).addComponent(this.edad_10)));
        this.JLIMC.setFont(new Font("Arial", 1, 14));
        this.JLIMC.setForeground(Color.red);
        this.JLIMC.setHorizontalAlignment(0);
        this.JLIMC.setText("0");
        this.JLIMC.setBorder(BorderFactory.createTitledBorder((Border) null, "IMC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIMC1.setBorder(BorderFactory.createTitledBorder((Border) null, "3. Perímetro de cintura medido por debajo de las costillas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cintura.add(this.edad_11);
        this.edad_11.setFont(new Font("Arial", 1, 12));
        this.edad_11.setText("Menos de 94 cm");
        this.edad_11.setName("0");
        this.edad_11.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.8
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_11ActionPerformed(evt);
            }
        });
        this.cintura.add(this.edad_12);
        this.edad_12.setFont(new Font("Arial", 1, 12));
        this.edad_12.setText("Entre 94-102 cm");
        this.edad_12.setName("3");
        this.edad_12.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.9
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_12ActionPerformed(evt);
            }
        });
        this.cintura.add(this.edad_13);
        this.edad_13.setFont(new Font("Arial", 1, 12));
        this.edad_13.setText("Más de 102 cm");
        this.edad_13.setName("4");
        this.edad_13.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.10
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_13ActionPerformed(evt);
            }
        });
        GroupLayout JPIMC1Layout = new GroupLayout(this.JPIMC1);
        this.JPIMC1.setLayout(JPIMC1Layout);
        JPIMC1Layout.setHorizontalGroup(JPIMC1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC1Layout.createSequentialGroup().addContainerGap().addComponent(this.edad_11).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.edad_12).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.edad_13).addContainerGap(-1, 32767)));
        JPIMC1Layout.setVerticalGroup(JPIMC1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.edad_11).addComponent(this.edad_12).addComponent(this.edad_13)));
        this.JPIMC2.setBorder(BorderFactory.createTitledBorder((Border) null, "4. ¿Realiza habitualmente al menos 30 minutos de actividad física, en el trabajo y/o en el tiempo libre?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.actividad_fisica.add(this.edad_14);
        this.edad_14.setFont(new Font("Arial", 1, 12));
        this.edad_14.setText("SI");
        this.edad_14.setName("0");
        this.edad_14.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.11
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_14ActionPerformed(evt);
            }
        });
        this.actividad_fisica.add(this.edad_15);
        this.edad_15.setFont(new Font("Arial", 1, 12));
        this.edad_15.setText("NO");
        this.edad_15.setName("2");
        this.edad_15.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.12
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_15ActionPerformed(evt);
            }
        });
        GroupLayout JPIMC2Layout = new GroupLayout(this.JPIMC2);
        this.JPIMC2.setLayout(JPIMC2Layout);
        JPIMC2Layout.setHorizontalGroup(JPIMC2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC2Layout.createSequentialGroup().addContainerGap().addComponent(this.edad_14).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.edad_15).addContainerGap(-1, 32767)));
        JPIMC2Layout.setVerticalGroup(JPIMC2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.edad_14).addComponent(this.edad_15)));
        this.JPIMC3.setBorder(BorderFactory.createTitledBorder((Border) null, "5. ¿Con qué frecuencia come verduras o frutas?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.verduras.add(this.edad_16);
        this.edad_16.setFont(new Font("Arial", 1, 12));
        this.edad_16.setText("Todos los días");
        this.edad_16.setName("0");
        this.edad_16.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.13
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_16ActionPerformed(evt);
            }
        });
        this.verduras.add(this.edad_17);
        this.edad_17.setFont(new Font("Arial", 1, 12));
        this.edad_17.setText("No todos los días");
        this.edad_17.setName("1");
        this.edad_17.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.14
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_17ActionPerformed(evt);
            }
        });
        GroupLayout JPIMC3Layout = new GroupLayout(this.JPIMC3);
        this.JPIMC3.setLayout(JPIMC3Layout);
        JPIMC3Layout.setHorizontalGroup(JPIMC3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC3Layout.createSequentialGroup().addContainerGap().addComponent(this.edad_16).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.edad_17).addContainerGap(-1, 32767)));
        JPIMC3Layout.setVerticalGroup(JPIMC3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.edad_16).addComponent(this.edad_17)));
        this.JPIMC4.setBorder(BorderFactory.createTitledBorder((Border) null, "6. ¿Toma medicación para la hipertensión regularmente?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.medicamentos.add(this.edad_18);
        this.edad_18.setFont(new Font("Arial", 1, 12));
        this.edad_18.setText("SI");
        this.edad_18.setName("2");
        this.edad_18.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.15
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_18ActionPerformed(evt);
            }
        });
        this.medicamentos.add(this.edad_19);
        this.edad_19.setFont(new Font("Arial", 1, 12));
        this.edad_19.setText("NO");
        this.edad_19.setName("0");
        this.edad_19.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.16
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_19ActionPerformed(evt);
            }
        });
        GroupLayout JPIMC4Layout = new GroupLayout(this.JPIMC4);
        this.JPIMC4.setLayout(JPIMC4Layout);
        JPIMC4Layout.setHorizontalGroup(JPIMC4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC4Layout.createSequentialGroup().addContainerGap().addComponent(this.edad_19).addGap(18, 18, 18).addComponent(this.edad_18).addContainerGap(-1, 32767)));
        JPIMC4Layout.setVerticalGroup(JPIMC4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.edad_18).addComponent(this.edad_19)));
        this.JPIMC5.setBorder(BorderFactory.createTitledBorder((Border) null, "7. ¿Le han encontrado alguna vez valores de glucosa altos (Ej. en un control médico, durante una enfermedad, durante el embarazo)?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.glucosa.add(this.edad_20);
        this.edad_20.setFont(new Font("Arial", 1, 12));
        this.edad_20.setText("SI");
        this.edad_20.setName("5");
        this.edad_20.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.17
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_20ActionPerformed(evt);
            }
        });
        this.glucosa.add(this.edad_21);
        this.edad_21.setFont(new Font("Arial", 1, 12));
        this.edad_21.setText("NO");
        this.edad_21.setName("0");
        this.edad_21.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.18
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_21ActionPerformed(evt);
            }
        });
        GroupLayout JPIMC5Layout = new GroupLayout(this.JPIMC5);
        this.JPIMC5.setLayout(JPIMC5Layout);
        JPIMC5Layout.setHorizontalGroup(JPIMC5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC5Layout.createSequentialGroup().addContainerGap().addComponent(this.edad_21).addGap(18, 18, 18).addComponent(this.edad_20).addContainerGap(-1, 32767)));
        JPIMC5Layout.setVerticalGroup(JPIMC5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.edad_20).addComponent(this.edad_21)));
        this.JPIMC6.setBorder(BorderFactory.createTitledBorder((Border) null, "8. ¿Se le ha diagnosticado diabetes (tipo 1 o tipo 2) a alguno de sus familiares allegados u otros parientes?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.diabetes.add(this.edad_22);
        this.edad_22.setFont(new Font("Arial", 1, 12));
        this.edad_22.setText("Sí: abuelos, tía, tío, primo hermano");
        this.edad_22.setName("3");
        this.edad_22.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.19
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_22ActionPerformed(evt);
            }
        });
        this.diabetes.add(this.edad_23);
        this.edad_23.setFont(new Font("Arial", 1, 12));
        this.edad_23.setText("NO");
        this.edad_23.setName("0");
        this.edad_23.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.20
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_23ActionPerformed(evt);
            }
        });
        this.diabetes.add(this.edad_24);
        this.edad_24.setFont(new Font("Arial", 1, 12));
        this.edad_24.setText("Sí: padres, hermanos o hijo");
        this.edad_24.setName("5");
        this.edad_24.addActionListener(new ActionListener() { // from class: Historia.JPTestFindrisk.21
            public void actionPerformed(ActionEvent evt) {
                JPTestFindrisk.this.edad_24ActionPerformed(evt);
            }
        });
        GroupLayout JPIMC6Layout = new GroupLayout(this.JPIMC6);
        this.JPIMC6.setLayout(JPIMC6Layout);
        JPIMC6Layout.setHorizontalGroup(JPIMC6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC6Layout.createSequentialGroup().addContainerGap().addComponent(this.edad_23).addGap(18, 18, 18).addComponent(this.edad_22).addGap(18, 18, 18).addComponent(this.edad_24).addContainerGap(274, 32767)));
        JPIMC6Layout.setVerticalGroup(JPIMC6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMC6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.edad_22).addComponent(this.edad_23).addComponent(this.edad_24)));
        this.JLTotalPuntos.setFont(new Font("Arial", 1, 14));
        this.JLTotalPuntos.setForeground(Color.red);
        this.JLTotalPuntos.setHorizontalAlignment(0);
        this.JLTotalPuntos.setText("0");
        this.JLTotalPuntos.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Puntos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLClasificacion.setFont(new Font("Arial", 1, 14));
        this.JLClasificacion.setForeground(Color.red);
        this.JLClasificacion.setHorizontalAlignment(2);
        this.JLClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLPerCintura.setFont(new Font("Arial", 1, 14));
        this.JLPerCintura.setForeground(Color.red);
        this.JLPerCintura.setHorizontalAlignment(0);
        this.JLPerCintura.setText("0");
        this.JLPerCintura.setBorder(BorderFactory.createTitledBorder((Border) null, "Perímetro Cintura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPTestLayout = new GroupLayout(this.JPTest);
        this.JPTest.setLayout(JPTestLayout);
        JPTestLayout.setHorizontalGroup(JPTestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTestLayout.createSequentialGroup().addContainerGap().addGroup(JPTestLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIMC6, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPIMC5, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPIMC4, -1, -1, 32767).addComponent(this.JPIMC3, -1, -1, 32767).addComponent(this.JPIMC2, -1, -1, 32767).addComponent(this.JPEdad, -1, -1, 32767).addGroup(JPTestLayout.createSequentialGroup().addComponent(this.JLTotalPuntos, -2, 159, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLClasificacion, -1, -1, 32767)).addGroup(JPTestLayout.createSequentialGroup().addGroup(JPTestLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIMC, -1, -1, 32767).addComponent(this.JPIMC1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPTestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLIMC, -1, -1, 32767).addComponent(this.JLPerCintura, -1, -1, 32767)))).addContainerGap(27, 32767)));
        JPTestLayout.setVerticalGroup(JPTestLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTestLayout.createSequentialGroup().addContainerGap().addComponent(this.JPEdad, -2, -1, -2).addGap(8, 8, 8).addGroup(JPTestLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLIMC, -1, -1, 32767).addComponent(this.JPIMC, -1, -1, 32767)).addGap(8, 8, 8).addGroup(JPTestLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIMC1, -1, -1, 32767).addComponent(this.JLPerCintura, -1, -1, 32767)).addGap(8, 8, 8).addComponent(this.JPIMC2, -2, -1, -2).addGap(8, 8, 8).addComponent(this.JPIMC3, -2, -1, -2).addGap(8, 8, 8).addComponent(this.JPIMC4, -2, -1, -2).addGap(8, 8, 8).addComponent(this.JPIMC5, -2, -1, -2).addGap(8, 8, 8).addComponent(this.JPIMC6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPTestLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLTotalPuntos).addComponent(this.JLClasificacion, -2, 41, -2)).addContainerGap(74, 32767)));
        this.jTabbedPane1.addTab("TEST FINDRISK", this.JPTest);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: Historia.JPTestFindrisk.22
            public void keyPressed(KeyEvent evt) {
                JPTestFindrisk.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle, -2, 788, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JSPDetalle, -2, 280, -2).addGap(0, 289, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 600, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_0ActionPerformed(ActionEvent evt) {
        this.xOpcion1 = getValueRadioButton(this.edad);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_2ActionPerformed(ActionEvent evt) {
        this.xOpcion1 = getValueRadioButton(this.edad);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_3ActionPerformed(ActionEvent evt) {
        this.xOpcion1 = getValueRadioButton(this.edad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_4ActionPerformed(ActionEvent evt) {
        this.xOpcion1 = getValueRadioButton(this.edad);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_8ActionPerformed(ActionEvent evt) {
        this.xOpcion2 = getValueRadioButton(this.IMC);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_9ActionPerformed(ActionEvent evt) {
        this.xOpcion2 = getValueRadioButton(this.IMC);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_10ActionPerformed(ActionEvent evt) {
        this.xOpcion2 = getValueRadioButton(this.IMC);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_11ActionPerformed(ActionEvent evt) {
        this.xOpcion3 = getValueRadioButton(this.cintura);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_12ActionPerformed(ActionEvent evt) {
        this.xOpcion3 = getValueRadioButton(this.cintura);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_13ActionPerformed(ActionEvent evt) {
        this.xOpcion3 = getValueRadioButton(this.cintura);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_14ActionPerformed(ActionEvent evt) {
        this.xOpcion4 = getValueRadioButton(this.actividad_fisica);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_15ActionPerformed(ActionEvent evt) {
        this.xOpcion4 = getValueRadioButton(this.actividad_fisica);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_16ActionPerformed(ActionEvent evt) {
        this.xOpcion5 = getValueRadioButton(this.verduras);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_17ActionPerformed(ActionEvent evt) {
        this.xOpcion5 = getValueRadioButton(this.verduras);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_19ActionPerformed(ActionEvent evt) {
        this.xOpcion6 = getValueRadioButton(this.medicamentos);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_18ActionPerformed(ActionEvent evt) {
        this.xOpcion6 = getValueRadioButton(this.medicamentos);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_21ActionPerformed(ActionEvent evt) {
        this.xOpcion7 = getValueRadioButton(this.glucosa);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_20ActionPerformed(ActionEvent evt) {
        this.xOpcion7 = getValueRadioButton(this.glucosa);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_23ActionPerformed(ActionEvent evt) {
        this.xOpcion8 = getValueRadioButton(this.diabetes);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_22ActionPerformed(ActionEvent evt) {
        this.xOpcion8 = getValueRadioButton(this.diabetes);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edad_24ActionPerformed(ActionEvent evt) {
        this.xOpcion8 = getValueRadioButton(this.diabetes);
        mCalculaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
    }

    private void mIniciaComponentes() {
        try {
            String sql = "SELECT PerimetroAbdominal, IMC FROM h_examenfisico WHERE Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JLIMC.setText(xrs.getString("IMC"));
                this.JLPerCintura.setText(xrs.getString("PerimetroAbdominal"));
                if (xrs.getDouble("IMC") < 25.0d) {
                    this.edad_8.setSelected(true);
                } else if (xrs.getDouble("IMC") >= 25.0d && xrs.getDouble("IMC") <= 30.0d) {
                    this.edad_9.setSelected(true);
                } else if (xrs.getDouble("IMC") > 30.0d) {
                    this.edad_10.setSelected(true);
                }
                this.xOpcion2 = getValueRadioButton(this.IMC);
                if (clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreSexo().equals("M")) {
                    if (xrs.getInt("PerimetroAbdominal") < 94) {
                        this.edad_11.setSelected(true);
                    } else if (xrs.getInt("PerimetroAbdominal") >= 94 && xrs.getInt("PerimetroAbdominal") <= 102) {
                        this.edad_12.setSelected(true);
                    } else if (xrs.getInt("PerimetroAbdominal") > 102) {
                        this.edad_13.setSelected(true);
                    }
                } else {
                    this.edad_11.setText("Menos de 80 cm");
                    this.edad_12.setText("Entre 80-88 cm");
                    this.edad_13.setText("Más de 88 cm");
                    if (xrs.getInt("PerimetroAbdominal") < 80) {
                        this.edad_11.setSelected(true);
                    } else if (xrs.getInt("PerimetroAbdominal") >= 80 && xrs.getInt("PerimetroAbdominal") <= 88) {
                        this.edad_12.setSelected(true);
                    } else if (xrs.getInt("PerimetroAbdominal") > 88) {
                        this.edad_13.setSelected(true);
                    }
                }
                this.xOpcion3 = getValueRadioButton(this.cintura);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTestFindrisk.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        mCalculaTotal();
    }

    private void mCalculaTotal() {
        if (!this.xOpcion1.equals("") && !this.xOpcion2.equals("") && !this.xOpcion3.equals("") && !this.xOpcion4.equals("") && !this.xOpcion5.equals("") && !this.xOpcion6.equals("") && !this.xOpcion7.equals("") && !this.xOpcion8.equals("")) {
            int suma = Integer.valueOf(this.xOpcion1).intValue() + Integer.valueOf(this.xOpcion2).intValue() + Integer.valueOf(this.xOpcion3).intValue() + Integer.valueOf(this.xOpcion4).intValue() + Integer.valueOf(this.xOpcion5).intValue() + Integer.valueOf(this.xOpcion6).intValue() + Integer.valueOf(this.xOpcion7).intValue() + Integer.valueOf(this.xOpcion8).intValue();
            this.JLTotalPuntos.setText("" + suma);
            if (suma < 7) {
                this.JLClasificacion.setText("BAJO – riesgo del 1%. Se estima que 1 de cada 100 pacientes desarrollará la enfermedad");
                return;
            }
            if (suma >= 7 && suma <= 11) {
                this.JLClasificacion.setText("LIGERAMENTE ELEVADO – riesgo del 4%. Se estima que 1 de cada 25 desarrollará la enfermedad");
                return;
            }
            if (suma >= 12 && suma <= 14) {
                this.JLClasificacion.setText("MODERADO – riesgo del 16,6%. Se estima que 1 de cada 6 pacientes desarrollará la enfermedad");
                return;
            }
            if (suma >= 15 && suma <= 20) {
                this.JLClasificacion.setText("ALTO – Riesgo del 33%. Se estima que 1 de cada 3 pacientes desarrollará la enfermedad");
            } else if (suma > 20) {
                this.JLClasificacion.setText("MUY ALTO – Riesgo del 50%. Se estima que 1 de cada 2 pacientes desarrollará la enfermedad");
            }
        }
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

    public void mGuardar() {
        if (!mVerificaExisteTest()) {
            if (!this.xOpcion1.equals("") && !this.xOpcion2.equals("") && !this.xOpcion3.equals("") && !this.xOpcion4.equals("") && !this.xOpcion5.equals("") && !this.xOpcion6.equals("") && !this.xOpcion7.equals("") && !this.xOpcion8.equals("")) {
                int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y == 0) {
                    String sql = "INSERT INTO `h_test_findrisk`\n            (`idAtencion`,\n             `idUsuario`,\n             `fechaR`,\n             `edad`,\n             `1_edad`,\n             `2_imc`,\n             `3_perimetro_cintura`,\n             `4_actividad_fisica`,\n             `5_verduras_frutas`,\n             `6_medicina`,\n             `7_glucosa`,\n             `8_diabetes`,\n             `total_puntos`,\n             `clasificacion`,\n             `usuarioS`)\nVALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',\n        '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "',\n        '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getEdad() + "',\n        '" + this.xOpcion1 + "',\n        '" + this.xOpcion2 + "',\n        '" + this.xOpcion3 + "',\n        '" + this.xOpcion4 + "',\n        '" + this.xOpcion5 + "',\n        '" + this.xOpcion6 + "',\n        '" + this.xOpcion7 + "',\n        '" + this.xOpcion8 + "',\n        '" + this.JLTotalPuntos.getText() + "',\n        '" + this.JLClasificacion.getText() + "',\n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mBuscaHistorico();
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe diligenciar el test completo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Ya existe un Test en ésta atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Punt. Edad", "Punt. IMC", "Punt. PCintura", "Punt. Ejercicio", "Punt. VerdurasFrutas", "Punt. MedicacionHTA", "Punt. Glucosa", "Punt. Diabetes", "Puntaje Total", "Clasificación"}) { // from class: Historia.JPTestFindrisk.23
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    private void mBuscaHistorico() {
        mCrearModelo();
        try {
            String sql = "SELECT\n  `id`,\n  `fechaR`,\n  `1_edad`,\n  `2_imc`,\n  `3_perimetro_cintura`,\n  `4_actividad_fisica`,\n  `5_verduras_frutas`,\n  `6_medicina`,\n  `7_glucosa`,\n  `8_diabetes`,\n  `total_puntos`,\n  `clasificacion`\nFROM `h_test_findrisk`\nWHERE estado=1 AND `idUsuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' ORDER BY fechaR DESC";
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
                    this.xmodelo.setValueAt(xrs.getString(11), x, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), x, 11);
                    x++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPFramingham.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaExisteTest() {
        boolean xExiste = false;
        try {
            String sql = "SELECT id FROM h_test_findrisk WHERE idAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND estado=1";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTestFindrisk.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }
}
