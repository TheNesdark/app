package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPPlanificacionFliar.class */
public class JPPlanificacionFliar extends JPanel {
    private Object[] xdatos;
    private DefaultTableModel xmodelo;
    private String[] xplanificacion;
    private String sql;
    private clasesHistoriaCE xclase;
    private JButton JBTGrabar;
    private JComboBox JCBAborto;
    private JComboBox JCBCesarea;
    private JComboBox JCBEdadMujer;
    private JComboBox JCBIntervaloE;
    private JComboBox JCBMetodoPlan;
    private JComboBox JCBMortinato;
    private JComboBox JCBParidadMujer;
    private JComboBox JCBPrematuro;
    private JCheckBox JCHAnemia;
    private JCheckBox JCHC1;
    private JCheckBox JCHC2;
    private JCheckBox JCHC3;
    private JCheckBox JCHCardiopatia;
    private JCheckBox JCHEnferRenal;
    private JCheckBox JCHHipertencionA;
    private JCheckBox JCHHipertension;
    private JCheckBox JCHOtraPatologia;
    private JCheckBox JCHOtraPatologiaA;
    private JCheckBox JCHToxemia;
    private JTextField JLParametro2;
    private JLabel JLTotal1;
    private JLabel JLTotal10;
    private JLabel JLTotal11;
    private JLabel JLTotal13;
    private JLabel JLTotal14;
    private JLabel JLTotal15;
    private JLabel JLTotal16;
    private JLabel JLTotal17;
    private JLabel JLTotal18;
    private JLabel JLTotal19;
    private JLabel JLTotal2;
    private JLabel JLTotal21;
    private JLabel JLTotal3;
    private JLabel JLTotal4;
    private JLabel JLTotal5;
    private JLabel JLTotal6;
    private JLabel JLTotal7;
    private JLabel JLTotal8;
    private JLabel JLTotal9;
    private JPanel JPHistorico;
    private JPanel JPIDatosIngreso;
    private JTable JTDetalle;
    private JTextField JTFNota;
    private JTabbedPane JTPDatos;
    private JCheckBox jCheckBox10;
    private JCheckBox jCheckBox8;
    private JCheckBox jCheckBox9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private int xTotal = 0;
    private int xTotalA = 0;
    private int xTotalB = 0;
    private int xTotalC = 0;
    private int xTotalD = 0;
    private int xTotalE = 0;
    private int xTotalF = 0;
    private int xTotalG = 0;
    private int xTotalH = 0;
    private int xTotalI = 0;
    private int xTotalJ = 0;
    private int xTotalK = 0;
    private int xTotalL = 0;
    private int xTotalM = 0;
    private int xTotalN = 0;
    private int xTotalO = 0;
    private int xTotalP = 0;
    private int xTotalQ = 0;
    private int xTotalR = 0;
    private int xTotalS = 0;
    private int xTotalT = 0;
    private int xEdad = 0;
    private int xEstado = 0;

    public JPPlanificacionFliar() {
        initComponents();
        mRecargarCombo();
        mCargarTabla();
        mInicialcompo();
    }

    /* JADX WARN: Type inference failed for: r3v306, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIDatosIngreso = new JPanel();
        this.jPanel2 = new JPanel();
        this.JCBMetodoPlan = new JComboBox();
        this.JTFNota = new JTextField();
        this.jPanel4 = new JPanel();
        this.JCBParidadMujer = new JComboBox();
        this.JLTotal2 = new JLabel();
        this.jPanel8 = new JPanel();
        this.JCHC1 = new JCheckBox();
        this.JCHC2 = new JCheckBox();
        this.JCHC3 = new JCheckBox();
        this.JLTotal13 = new JLabel();
        this.JLTotal14 = new JLabel();
        this.JLTotal15 = new JLabel();
        this.jPanel7 = new JPanel();
        this.JCBIntervaloE = new JComboBox();
        this.JLTotal3 = new JLabel();
        this.jPanel9 = new JPanel();
        this.JCBAborto = new JComboBox();
        this.JCBCesarea = new JComboBox();
        this.JCBMortinato = new JComboBox();
        this.JCBPrematuro = new JComboBox();
        this.jPanel3 = new JPanel();
        this.JCHHipertension = new JCheckBox();
        this.JCHToxemia = new JCheckBox();
        this.JCHCardiopatia = new JCheckBox();
        this.JCHOtraPatologia = new JCheckBox();
        this.JLTotal10 = new JLabel();
        this.JLTotal11 = new JLabel();
        this.JLTotal8 = new JLabel();
        this.JLTotal9 = new JLabel();
        this.JLTotal4 = new JLabel();
        this.JLTotal5 = new JLabel();
        this.JLTotal6 = new JLabel();
        this.JLTotal7 = new JLabel();
        this.jPanel10 = new JPanel();
        this.JCHAnemia = new JCheckBox();
        this.JCHEnferRenal = new JCheckBox();
        this.JCHHipertencionA = new JCheckBox();
        this.JCHOtraPatologiaA = new JCheckBox();
        this.JLTotal16 = new JLabel();
        this.JLTotal17 = new JLabel();
        this.JLTotal18 = new JLabel();
        this.JLTotal19 = new JLabel();
        this.jPanel6 = new JPanel();
        this.JCBEdadMujer = new JComboBox();
        this.JLTotal1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.JLParametro2 = new JTextField();
        this.JLTotal21 = new JLabel();
        this.JBTGrabar = new JButton();
        this.JPHistorico = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jCheckBox8 = new JCheckBox();
        this.jCheckBox9 = new JCheckBox();
        this.jCheckBox10 = new JCheckBox();
        setMaximumSize(new Dimension(327607, 32767));
        setName("xJPPlanificacionFliar");
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPIDatosIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "METODO PRESCRITO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBMetodoPlan.setFont(new Font("Arial", 1, 12));
        this.JCBMetodoPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Metodo de Planificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNota.setFont(new Font("Arial", 1, 12));
        this.JTFNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripcion", 0, 0, new Font("Tahoma", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JCBMetodoPlan, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNota).addGap(10, 10, 10)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNota, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JCBMetodoPlan, GroupLayout.Alignment.TRAILING, -2, 48, -2)).addGap(2, 2, 2)));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "B", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBParidadMujer.setFont(new Font("Arial", 1, 12));
        this.JCBParidadMujer.setModel(new DefaultComboBoxModel(new String[]{"        ", "Nulipara", "1 a 3 Partos", "4 Partos o Mas"}));
        this.JCBParidadMujer.setToolTipText("");
        this.JCBParidadMujer.setBorder(BorderFactory.createTitledBorder((Border) null, "Paridad De la mujer", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBParidadMujer.addItemListener(new ItemListener() { // from class: Historia.JPPlanificacionFliar.1
            public void itemStateChanged(ItemEvent evt) {
                JPPlanificacionFliar.this.JCBParidadMujerItemStateChanged(evt);
            }
        });
        this.JCBParidadMujer.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.2
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCBParidadMujerActionPerformed(evt);
            }
        });
        this.JLTotal2.setFont(new Font("Arial", 1, 18));
        this.JLTotal2.setForeground(new Color(255, 0, 0));
        this.JLTotal2.setHorizontalAlignment(0);
        this.JLTotal2.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JCBParidadMujer, -2, 290, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLTotal2, -2, 29, -2).addGap(8, 8, 8)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLTotal2, -2, 29, -2).addComponent(this.JCBParidadMujer, -2, -1, -2)).addGap(0, 10, 32767)));
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "C", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHC1.setFont(new Font("Arial", 1, 12));
        this.JCHC1.setText("Tugurio ?");
        this.JCHC1.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.3
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHC1ActionPerformed(evt);
            }
        });
        this.JCHC2.setFont(new Font("Arial", 1, 12));
        this.JCHC2.setText("Niños Menores De 2 Años Desnutrido");
        this.JCHC2.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.4
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHC2ActionPerformed(evt);
            }
        });
        this.JCHC3.setFont(new Font("Arial", 1, 12));
        this.JCHC3.setText("Muerte De Niños Menores 2 años ");
        this.JCHC3.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.5
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHC3ActionPerformed(evt);
            }
        });
        this.JLTotal13.setFont(new Font("Arial", 1, 18));
        this.JLTotal13.setForeground(new Color(255, 0, 0));
        this.JLTotal13.setHorizontalAlignment(0);
        this.JLTotal13.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal14.setFont(new Font("Arial", 1, 18));
        this.JLTotal14.setForeground(new Color(255, 0, 0));
        this.JLTotal14.setHorizontalAlignment(0);
        this.JLTotal14.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal15.setFont(new Font("Arial", 1, 18));
        this.JLTotal15.setForeground(new Color(255, 0, 0));
        this.JLTotal15.setHorizontalAlignment(0);
        this.JLTotal15.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHC1).addComponent(this.JCHC2).addComponent(this.JCHC3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTotal15, GroupLayout.Alignment.TRAILING, -2, 29, -2).addComponent(this.JLTotal14, GroupLayout.Alignment.TRAILING, -2, 29, -2).addComponent(this.JLTotal13, GroupLayout.Alignment.TRAILING, -2, 29, -2)).addGap(10, 10, 10)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.JLTotal13, -2, 29, -2).addGap(5, 5, 5).addComponent(this.JLTotal14, -2, 29, -2)).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.JCHC1, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHC2, -2, 29, -2))).addGap(1, 1, 1).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHC3, -2, 29, -2).addComponent(this.JLTotal15, -2, 29, -2)).addContainerGap(-1, 32767)));
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "D", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBIntervaloE.setFont(new Font("Arial", 1, 12));
        this.JCBIntervaloE.setModel(new DefaultComboBoxModel(new String[]{"     ", "Menos de 12 Meses", "1 a 2 Años", "Mas de 2 Años"}));
        this.JCBIntervaloE.setToolTipText("");
        this.JCBIntervaloE.setBorder(BorderFactory.createTitledBorder((Border) null, "Intervalo  Entre Embarazo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBIntervaloE.addItemListener(new ItemListener() { // from class: Historia.JPPlanificacionFliar.6
            public void itemStateChanged(ItemEvent evt) {
                JPPlanificacionFliar.this.JCBIntervaloEItemStateChanged(evt);
            }
        });
        this.JLTotal3.setFont(new Font("Arial", 1, 18));
        this.JLTotal3.setForeground(new Color(255, 0, 0));
        this.JLTotal3.setHorizontalAlignment(0);
        this.JLTotal3.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JCBIntervaloE, -2, 290, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLTotal3, -2, 29, -2).addGap(9, 9, 9)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLTotal3, -2, 29, -2).addComponent(this.JCBIntervaloE, -2, -1, -2)).addGap(0, 8, 32767)));
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "E", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBAborto.setFont(new Font("Arial", 1, 12));
        this.JCBAborto.setModel(new DefaultComboBoxModel(new String[]{"    ", "1 o 2", "3 o Mas"}));
        this.JCBAborto.setBorder(BorderFactory.createTitledBorder((Border) null, "Aborto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBAborto.addItemListener(new ItemListener() { // from class: Historia.JPPlanificacionFliar.7
            public void itemStateChanged(ItemEvent evt) {
                JPPlanificacionFliar.this.JCBAbortoItemStateChanged(evt);
            }
        });
        this.JCBCesarea.setFont(new Font("Arial", 1, 12));
        this.JCBCesarea.setModel(new DefaultComboBoxModel(new String[]{"", "1 o 2", "3 o Mas"}));
        this.JCBCesarea.setBorder(BorderFactory.createTitledBorder((Border) null, "Cesarea", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCesarea.addItemListener(new ItemListener() { // from class: Historia.JPPlanificacionFliar.8
            public void itemStateChanged(ItemEvent evt) {
                JPPlanificacionFliar.this.JCBCesareaItemStateChanged(evt);
            }
        });
        this.JCBMortinato.setFont(new Font("Arial", 1, 12));
        this.JCBMortinato.setModel(new DefaultComboBoxModel(new String[]{"", "1 o 2", "3 o Mas"}));
        this.JCBMortinato.setBorder(BorderFactory.createTitledBorder((Border) null, "Mortinato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMortinato.addItemListener(new ItemListener() { // from class: Historia.JPPlanificacionFliar.9
            public void itemStateChanged(ItemEvent evt) {
                JPPlanificacionFliar.this.JCBMortinatoItemStateChanged(evt);
            }
        });
        this.JCBPrematuro.setFont(new Font("Arial", 1, 12));
        this.JCBPrematuro.setModel(new DefaultComboBoxModel(new String[]{"  ", "1 o 2", "3 o Mas"}));
        this.JCBPrematuro.setToolTipText("");
        this.JCBPrematuro.setBorder(BorderFactory.createTitledBorder((Border) null, "Prematuro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPrematuro.addItemListener(new ItemListener() { // from class: Historia.JPPlanificacionFliar.10
            public void itemStateChanged(ItemEvent evt) {
                JPPlanificacionFliar.this.JCBPrematuroItemStateChanged(evt);
            }
        });
        this.jPanel3.setBorder(BorderFactory.createTitledBorder(""));
        this.JCHHipertension.setFont(new Font("Arial", 1, 12));
        this.JCHHipertension.setText("Hipertension");
        this.JCHHipertension.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.11
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHHipertensionActionPerformed(evt);
            }
        });
        this.JCHToxemia.setFont(new Font("Arial", 1, 12));
        this.JCHToxemia.setText("Toxemia");
        this.JCHToxemia.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.12
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHToxemiaActionPerformed(evt);
            }
        });
        this.JCHCardiopatia.setFont(new Font("Arial", 1, 12));
        this.JCHCardiopatia.setText("Cardiopatia");
        this.JCHCardiopatia.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.13
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHCardiopatiaActionPerformed(evt);
            }
        });
        this.JCHOtraPatologia.setFont(new Font("Arial", 1, 12));
        this.JCHOtraPatologia.setText("Otra Patologia");
        this.JCHOtraPatologia.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.14
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHOtraPatologiaActionPerformed(evt);
            }
        });
        this.JLTotal10.setFont(new Font("Arial", 1, 18));
        this.JLTotal10.setForeground(new Color(255, 0, 0));
        this.JLTotal10.setHorizontalAlignment(0);
        this.JLTotal10.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal11.setFont(new Font("Arial", 1, 18));
        this.JLTotal11.setForeground(new Color(255, 0, 0));
        this.JLTotal11.setHorizontalAlignment(0);
        this.JLTotal11.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal8.setFont(new Font("Arial", 1, 18));
        this.JLTotal8.setForeground(new Color(255, 0, 0));
        this.JLTotal8.setHorizontalAlignment(0);
        this.JLTotal8.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal9.setFont(new Font("Arial", 1, 18));
        this.JLTotal9.setForeground(new Color(255, 0, 0));
        this.JLTotal9.setHorizontalAlignment(0);
        this.JLTotal9.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCHHipertension)).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JCHToxemia)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHCardiopatia)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHOtraPatologia))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTotal11, GroupLayout.Alignment.TRAILING, -2, 29, -2).addComponent(this.JLTotal10, GroupLayout.Alignment.TRAILING, -2, 29, -2).addComponent(this.JLTotal8, GroupLayout.Alignment.TRAILING, -2, 29, -2).addComponent(this.JLTotal9, GroupLayout.Alignment.TRAILING, -2, 29, -2)).addGap(10, 10, 10)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHHipertension, -2, 29, -2).addComponent(this.JLTotal8, -2, 29, -2)).addGap(1, 1, 1).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JLTotal9, -2, 29, -2).addGap(1, 1, 1).addComponent(this.JLTotal10, -2, 29, -2).addGap(1, 1, 1).addComponent(this.JLTotal11, -2, 29, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JCHToxemia, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHCardiopatia, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHOtraPatologia, -2, 29, -2))).addGap(50, 50, 50)));
        this.JLTotal4.setFont(new Font("Arial", 1, 18));
        this.JLTotal4.setForeground(new Color(255, 0, 0));
        this.JLTotal4.setHorizontalAlignment(0);
        this.JLTotal4.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal5.setFont(new Font("Arial", 1, 18));
        this.JLTotal5.setForeground(new Color(255, 0, 0));
        this.JLTotal5.setHorizontalAlignment(0);
        this.JLTotal5.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal6.setFont(new Font("Arial", 1, 18));
        this.JLTotal6.setForeground(new Color(255, 0, 0));
        this.JLTotal6.setHorizontalAlignment(0);
        this.JLTotal6.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal7.setBackground(new Color(255, 255, 255));
        this.JLTotal7.setFont(new Font("Arial", 1, 18));
        this.JLTotal7.setForeground(new Color(255, 0, 0));
        this.JLTotal7.setHorizontalAlignment(0);
        this.JLTotal7.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(8, 8, 8).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCBPrematuro, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLTotal6, -2, 29, -2)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCBMortinato, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLTotal5, -2, 29, -2)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCBCesarea, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLTotal4, -2, 29, -2)).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCBAborto, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, 32767).addComponent(this.JLTotal7, -2, 29, -2))).addGap(10, 10, 10)))));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBAborto, -2, 48, -2).addGroup(jPanel9Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLTotal7, -2, 29, -2))).addGap(5, 5, 5).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCesarea, -2, 48, -2).addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup().addComponent(this.JLTotal4, -2, 29, -2).addGap(10, 10, 10))).addGap(5, 5, 5).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMortinato, -2, 48, -2).addGroup(jPanel9Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JLTotal5, -2, 29, -2))).addGap(5, 5, 5).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JCBPrematuro, -2, 48, -2).addGap(5, 5, 5)).addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup().addComponent(this.JLTotal6, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addComponent(this.jPanel3, -2, 141, 32767).addGap(5, 5, 5)));
        this.jPanel10.setBorder(BorderFactory.createTitledBorder((Border) null, "F", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHAnemia.setFont(new Font("Arial", 1, 12));
        this.JCHAnemia.setText("Anemia Severa (Menos 7gms de Hb)");
        this.JCHAnemia.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.15
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHAnemiaActionPerformed(evt);
            }
        });
        this.JCHEnferRenal.setFont(new Font("Arial", 1, 12));
        this.JCHEnferRenal.setText("Enfermedad Renal");
        this.JCHEnferRenal.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.16
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHEnferRenalActionPerformed(evt);
            }
        });
        this.JCHHipertencionA.setFont(new Font("Arial", 1, 12));
        this.JCHHipertencionA.setText("Hipertension");
        this.JCHHipertencionA.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.17
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHHipertencionAActionPerformed(evt);
            }
        });
        this.JCHOtraPatologiaA.setFont(new Font("Arial", 1, 12));
        this.JCHOtraPatologiaA.setText("Otra Patologia");
        this.JCHOtraPatologiaA.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.18
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCHOtraPatologiaAActionPerformed(evt);
            }
        });
        this.JLTotal16.setFont(new Font("Arial", 1, 18));
        this.JLTotal16.setForeground(new Color(255, 0, 0));
        this.JLTotal16.setHorizontalAlignment(0);
        this.JLTotal16.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal17.setFont(new Font("Arial", 1, 18));
        this.JLTotal17.setForeground(new Color(255, 0, 0));
        this.JLTotal17.setHorizontalAlignment(0);
        this.JLTotal17.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal18.setFont(new Font("Arial", 1, 18));
        this.JLTotal18.setForeground(new Color(255, 0, 0));
        this.JLTotal18.setHorizontalAlignment(0);
        this.JLTotal18.setBorder(BorderFactory.createEtchedBorder());
        this.JLTotal19.setFont(new Font("Arial", 1, 18));
        this.JLTotal19.setForeground(new Color(255, 0, 0));
        this.JLTotal19.setHorizontalAlignment(0);
        this.JLTotal19.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEnferRenal).addComponent(this.JCHAnemia).addComponent(this.JCHHipertencionA).addComponent(this.JCHOtraPatologiaA)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTotal19, GroupLayout.Alignment.TRAILING, -2, 29, -2).addComponent(this.JLTotal18, GroupLayout.Alignment.TRAILING, -2, 29, -2).addComponent(this.JLTotal17, GroupLayout.Alignment.TRAILING, -2, 29, -2).addComponent(this.JLTotal16, GroupLayout.Alignment.TRAILING, -2, 29, -2)).addGap(10, 10, 10)));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.JCHAnemia, -2, 29, -2).addGap(1, 1, 1).addComponent(this.JCHEnferRenal, -2, 29, -2).addGap(1, 1, 1).addComponent(this.JCHHipertencionA, -2, 31, -2)).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.JLTotal16, -2, 29, -2).addGap(1, 1, 1).addComponent(this.JLTotal17, -2, 29, -2).addGap(2, 2, 2).addComponent(this.JLTotal18, -2, 29, -2))).addGap(1, 1, 1).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTotal19, -2, 29, -2).addComponent(this.JCHOtraPatologiaA)).addContainerGap(-1, 32767)));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "A", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEdadMujer.setFont(new Font("Arial", 1, 12));
        this.JCBEdadMujer.setModel(new DefaultComboBoxModel(new String[]{"                   ", "17 Años o Menor", "18 a 34 Años", "35 Años o Mas"}));
        this.JCBEdadMujer.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad De La Mujer", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEdadMujer.addItemListener(new ItemListener() { // from class: Historia.JPPlanificacionFliar.19
            public void itemStateChanged(ItemEvent evt) {
                JPPlanificacionFliar.this.JCBEdadMujerItemStateChanged(evt);
            }
        });
        this.JCBEdadMujer.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.20
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JCBEdadMujerActionPerformed(evt);
            }
        });
        this.JLTotal1.setFont(new Font("Arial", 1, 18));
        this.JLTotal1.setForeground(new Color(255, 0, 0));
        this.JLTotal1.setHorizontalAlignment(0);
        this.JLTotal1.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JCBEdadMujer, -2, 301, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addComponent(this.JLTotal1, -2, 29, -2).addGap(8, 8, 8)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JCBEdadMujer, -2, 48, -2).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JLTotal1, -2, 29, -2).addContainerGap()));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.JLParametro2.setEditable(false);
        this.JLParametro2.setFont(new Font("Arial", 1, 18));
        this.JLParametro2.setHorizontalAlignment(0);
        this.JLParametro2.setBorder(BorderFactory.createEtchedBorder());
        this.JLParametro2.setFocusable(false);
        this.JLParametro2.setInheritsPopupMenu(true);
        this.JLParametro2.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.21
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JLParametro2ActionPerformed(evt);
            }
        });
        this.JLTotal21.setFont(new Font("Arial", 1, 18));
        this.JLTotal21.setForeground(new Color(255, 0, 0));
        this.JLTotal21.setHorizontalAlignment(0);
        this.JLTotal21.setText("0");
        this.JLTotal21.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLTotal21.addKeyListener(new KeyAdapter() { // from class: Historia.JPPlanificacionFliar.22
            public void keyTyped(KeyEvent evt) {
                JPPlanificacionFliar.this.JLTotal21KeyTyped(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JLParametro2).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGap(103, 103, 103).addComponent(this.JLTotal21, -2, 113, -2).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JLTotal21).addGap(5, 5, 5).addComponent(this.JLParametro2, -2, 50, -2).addGap(10, 10, 10)));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPPlanificacionFliar.23
            public void actionPerformed(ActionEvent evt) {
                JPPlanificacionFliar.this.JBTGrabarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosIngresoLayout = new GroupLayout(this.JPIDatosIngreso);
        this.JPIDatosIngreso.setLayout(JPIDatosIngresoLayout);
        JPIDatosIngresoLayout.setHorizontalGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIngresoLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGrabar, -1, 820, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosIngresoLayout.createSequentialGroup().addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel8, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel6, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addGap(38, 38, 38).addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel9, -1, -1, 32767).addComponent(this.jPanel10, -1, -1, 32767)))).addGap(1, 1, 1)));
        JPIDatosIngresoLayout.setVerticalGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIngresoLayout.createSequentialGroup().addGroup(JPIDatosIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosIngresoLayout.createSequentialGroup().addComponent(this.jPanel6, -2, -1, -2).addGap(1, 1, 1).addComponent(this.jPanel4, -2, -1, -2).addGap(1, 1, 1).addComponent(this.jPanel8, -2, 131, -2).addGap(5, 5, 5).addComponent(this.jPanel7, -2, -1, -2).addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2)).addGroup(JPIDatosIngresoLayout.createSequentialGroup().addComponent(this.jPanel9, -2, -1, -2).addGap(0, 0, 0).addComponent(this.jPanel10, -2, 146, -2))).addGap(3, 3, 3).addComponent(this.jPanel2, -2, 75, -2).addGap(1, 1, 1).addComponent(this.JBTGrabar, -1, -1, 32767).addGap(1, 1, 1)));
        this.JTPDatos.addTab("INDICE DE RIESGO", this.JPIDatosIngreso);
        this.JPHistorico.setBorder(BorderFactory.createTitledBorder(""));
        this.JTDetalle.setFont(new Font("Arial", 0, 14));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPPlanificacionFliar.24
            public void mouseClicked(MouseEvent evt) {
                JPPlanificacionFliar.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jCheckBox8.setBackground(new Color(255, 0, 0));
        this.jCheckBox8.setFont(new Font("Arial", 1, 12));
        this.jCheckBox8.setForeground(new Color(255, 255, 255));
        this.jCheckBox8.setText("ALTO");
        this.jCheckBox9.setBackground(Color.orange);
        this.jCheckBox9.setFont(new Font("Arial", 1, 12));
        this.jCheckBox9.setForeground(new Color(255, 255, 255));
        this.jCheckBox9.setText("MEDIO");
        this.jCheckBox10.setBackground(new Color(40, 120, 52));
        this.jCheckBox10.setFont(new Font("Arial", 1, 12));
        this.jCheckBox10.setForeground(new Color(255, 255, 255));
        this.jCheckBox10.setText("BAJO");
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 823, 32767).addGap(10, 10, 10)).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.jCheckBox8, -2, 100, -2).addGap(32, 32, 32).addComponent(this.jCheckBox10, -2, 93, -2).addGap(33, 33, 33).addComponent(this.jCheckBox9, -2, 90, -2).addContainerGap(-1, 32767)));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 576, -2).addGap(18, 18, 18).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox8).addComponent(this.jCheckBox9).addComponent(this.jCheckBox10)).addGap(0, 40, 32767)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JTPDatos, -2, 842, -2).addGap(4, 4, 4)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos, GroupLayout.Alignment.TRAILING));
        this.JTPDatos.getAccessibleContext().setAccessibleName("HISTÓRICO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCardiopatiaActionPerformed(ActionEvent evt) {
        if (this.JCHCardiopatia.isSelected()) {
            this.xTotalN = 2;
        } else {
            this.xTotalN = 0;
        }
        this.JLTotal10.setText("" + this.xTotalN);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHHipertencionAActionPerformed(ActionEvent evt) {
        if (this.JCHHipertencionA.isSelected()) {
            this.xTotalR = 4;
        } else {
            this.xTotalR = 0;
        }
        this.JLTotal18.setText("" + this.xTotalR);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEdadMujerItemStateChanged(ItemEvent evt) {
        if (this.JCBEdadMujer.getSelectedIndex() == 0 || this.JCBEdadMujer.getSelectedIndex() == 2) {
            this.xTotalA = 0;
            this.JLTotal1.setText("" + this.xTotalA);
        } else if (this.JCBEdadMujer.getSelectedIndex() == 1 || this.JCBEdadMujer.getSelectedIndex() == 3) {
            this.xTotalA = 2;
            this.JLTotal1.setText("" + this.xTotalA);
        }
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBParidadMujerItemStateChanged(ItemEvent evt) {
        if (this.JCBParidadMujer.getSelectedIndex() == 0 || this.JCBParidadMujer.getSelectedIndex() == 1) {
            this.xTotalB = 0;
            this.JLTotal2.setText("" + this.xTotalB);
        } else if (this.JCBParidadMujer.getSelectedIndex() == 2) {
            this.xTotalB = 1;
            this.JLTotal2.setText("" + this.xTotalB);
        } else if (this.JCBParidadMujer.getSelectedIndex() == 3) {
            this.xTotalB = 4;
            this.JLTotal2.setText("" + this.xTotalB);
        }
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBIntervaloEItemStateChanged(ItemEvent evt) {
        if (this.JCBIntervaloE.getSelectedIndex() == 0) {
            this.xTotalC = 0;
            this.JLTotal3.setText("" + this.xTotalC);
        } else {
            this.xTotalC = 2;
            this.JLTotal3.setText("" + this.xTotalC);
        }
        mSumaTotal();
    }

    public void mInicialcompo() {
        try {
            this.sql = "SELECT\n    `h_planificacion_fliar`.`EdadOpcion`\n    , `h_planificacion_fliar`.`Paridad`\n    , `h_planificacion_fliar`.`IntEmbarazo`\n    , `h_planificacion_fliar`.`Aborto`\n    , `h_planificacion_fliar`.`Cesarea`\n    , `h_planificacion_fliar`.`Mortinato`\n    , `h_planificacion_fliar`.`Prematuro`\n    , `h_planificacion_fliar`.`OpC1`\n    , `h_planificacion_fliar`.`OpC2`\n    , `h_planificacion_fliar`.`OpC3`\n    , `h_planificacion_fliar`.`Hipertencion`\n    , `h_planificacion_fliar`.`Toxemia`\n    , `h_planificacion_fliar`.`Cardiopatia`\n    , `h_planificacion_fliar`.`OtraPat`\n    , `h_planificacion_fliar`.`Anemia`\n    , `h_planificacion_fliar`.`Erenal`\n    , `h_planificacion_fliar`.`2Cardiopati`\n    , `h_planificacion_fliar`.`Opatologia`\n    , `h_tipometplanifica`.`Nbre`\n    , `h_planificacion_fliar`.`Observacion`\nFROM\n    `h_tipometplanifica`\n    INNER JOIN `h_planificacion_fliar` \n        ON (`h_tipometplanifica`.`Id` = `h_planificacion_fliar`.`IdMetodo`)\nWHERE (`h_planificacion_fliar`.`IdAtencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "');";
            ResultSet xrs = this.xconsulta.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                this.xEdad = xrs.getInt(1);
                this.JCBParidadMujer.setSelectedItem(xrs.getString(2));
                this.JCBIntervaloE.setSelectedItem(xrs.getString(3));
                this.JCBAborto.setSelectedItem(xrs.getString(4));
                this.JCBCesarea.setSelectedItem(xrs.getString(5));
                this.JCBMortinato.setSelectedItem(xrs.getString(6));
                this.JCBPrematuro.setSelectedItem(xrs.getString(7));
                if (this.xTotalH == xrs.getInt(8)) {
                    this.JCHC1.setSelected(false);
                } else {
                    this.JCHC1.setSelected(true);
                    this.JLTotal13.setText("2");
                    this.xTotalH = xrs.getInt(8);
                }
                if (this.xTotalJ == xrs.getInt(9)) {
                    this.JCHC2.setSelected(false);
                } else {
                    this.JCHC2.setSelected(true);
                    this.JLTotal14.setText("2");
                    this.xTotalJ = xrs.getInt(9);
                }
                if (this.xTotalK == xrs.getInt(10)) {
                    this.JCHC3.setSelected(false);
                } else {
                    this.JCHC3.setSelected(true);
                    this.JLTotal15.setText("2");
                    this.xTotalK = xrs.getInt(10);
                }
                if (this.xTotalL == xrs.getInt(11)) {
                    this.JCHHipertension.setSelected(false);
                } else {
                    this.JCHHipertension.setSelected(true);
                    this.JLTotal8.setText("2");
                    this.xTotalL = xrs.getInt(11);
                }
                if (this.xTotalM == xrs.getInt(12)) {
                    this.JCHToxemia.setSelected(false);
                } else {
                    this.JCHToxemia.setSelected(true);
                    this.JLTotal9.setText("2");
                    this.xTotalM = xrs.getInt(12);
                }
                if (this.xTotalN == xrs.getInt(13)) {
                    this.JCHCardiopatia.setSelected(false);
                } else {
                    this.JCHCardiopatia.setSelected(true);
                    this.JLTotal10.setText("2");
                    this.xTotalN = xrs.getInt(13);
                }
                if (this.xTotalO == xrs.getInt(14)) {
                    this.JCHOtraPatologia.setSelected(false);
                } else {
                    this.JCHOtraPatologia.setSelected(true);
                    this.JLTotal11.setText("2");
                    this.xTotalO = xrs.getInt(14);
                }
                if (this.xTotalP == xrs.getInt(15)) {
                    this.JCHAnemia.setSelected(false);
                } else {
                    this.JCHAnemia.setSelected(true);
                    this.JLTotal16.setText("4");
                    this.xTotalP = xrs.getInt(15);
                }
                if (this.xTotalQ == xrs.getInt(16)) {
                    this.JCHEnferRenal.setSelected(false);
                } else {
                    this.JCHEnferRenal.setSelected(true);
                    this.JLTotal17.setText("4");
                    this.xTotalQ = xrs.getInt(16);
                }
                if (this.xTotalR == xrs.getInt(17)) {
                    this.JCHHipertencionA.setSelected(false);
                } else {
                    this.JCHHipertencionA.setSelected(true);
                    this.JLTotal18.setText("4");
                    this.xTotalR = xrs.getInt(17);
                }
                if (this.xTotalS == xrs.getInt(18)) {
                    this.JCHOtraPatologiaA.setSelected(false);
                } else {
                    this.JCHOtraPatologiaA.setSelected(true);
                    this.JLTotal19.setText("4");
                    this.xTotalS = xrs.getInt(18);
                }
                this.JCBMetodoPlan.setSelectedItem(xrs.getString(19));
                this.JTFNota.setText(xrs.getString(20));
                mCalculoEdad();
                mValidarCF();
            } else {
                mNuevo();
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public static void setEnableContainer(Container c, boolean band) {
        Container[] components = c.getComponents();
        c.setEnabled(band);
        for (int i = 0; i < components.length; i++) {
            components[i].setEnabled(band);
            if (components[i] instanceof Container) {
                setEnableContainer(components[i], band);
            }
        }
    }

    private void mValidarCF() {
        setEnableContainer(this.JPIDatosIngreso, false);
        setEnableContainer(this.JLTotal1, true);
        setEnableContainer(this.JLTotal2, true);
        setEnableContainer(this.JLTotal3, true);
        setEnableContainer(this.JLTotal4, true);
        setEnableContainer(this.JLTotal5, true);
        setEnableContainer(this.JLTotal6, true);
        setEnableContainer(this.JLTotal7, true);
        setEnableContainer(this.JLTotal8, true);
        setEnableContainer(this.JLTotal9, true);
        setEnableContainer(this.JLTotal10, true);
        setEnableContainer(this.JLTotal11, true);
        setEnableContainer(this.JLTotal2, true);
        setEnableContainer(this.JLTotal13, true);
        setEnableContainer(this.JLTotal14, true);
        setEnableContainer(this.JLTotal15, true);
        setEnableContainer(this.JLTotal16, true);
        setEnableContainer(this.JLTotal17, true);
        setEnableContainer(this.JLTotal18, true);
        setEnableContainer(this.JLTotal19, true);
        setEnableContainer(this.JLTotal21, true);
        setEnableContainer(this.jPanel1, true);
    }

    public void mNuevo() {
        JCBEdadMujerItemStateChanged(null);
        JCBIntervaloEItemStateChanged(null);
        JCBIntervaloEItemStateChanged(null);
        JCBAbortoItemStateChanged(null);
        JCBCesareaItemStateChanged(null);
        JCBMortinatoItemStateChanged(null);
        JCBPrematuroItemStateChanged(null);
        JCBParidadMujerItemStateChanged(null);
        JCHC1ActionPerformed(null);
        JCHC2ActionPerformed(null);
        JCHC3ActionPerformed(null);
        JCHHipertensionActionPerformed(null);
        JCHToxemiaActionPerformed(null);
        JCHCardiopatiaActionPerformed(null);
        JCHOtraPatologiaActionPerformed(null);
        JCHAnemiaActionPerformed(null);
        JCHEnferRenalActionPerformed(null);
        JCHHipertencionAActionPerformed(null);
        JCHOtraPatologiaAActionPerformed(null);
        this.JLTotal21.setText("0");
        this.xTotal = 0;
        this.JTFNota.setText("");
        this.JCBMetodoPlan.setSelectedIndex(-1);
        mCalculoEdad();
    }

    public void mGrabar() {
        if (this.JCBMetodoPlan.getSelectedIndex() != -1) {
            if (!this.JTFNota.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.sql = null;
                    this.sql = "INSERT INTO `h_planificacion_fliar` (`IdAtencion`, `IdProfesional`,`IdEspecialidad`,`IdUsuario`,`FechaR`,`EdadAct`,`EdadOpcion`,             `OpA`,`Paridad`,`OpB`,`OpC1`,`OpC2`,`OpC3`,`IntEmbarazo`,`OpD`,`Aborto`,`ValAborto`,`Cesarea`,             `ValCesarea`,`Mortinato`,`ValMortinato`,`Prematuro`,`ValPrematuro`,`Hipertencion`,`Toxemia`,`Cardiopatia`,             `OtraPat`,`ValOtraPat`,`ValTotal`,`CalTotal`,`IdMetodo`,`Observacion`,`Fecha`,`Estado`,`UsuarioS`,Anemia,Erenal,2Cardiopati,Opatologia)VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xEdad + "','" + this.xEdad + "','" + this.xTotalA + "','" + this.JCBParidadMujer.getSelectedItem() + "','" + this.xTotalB + "','" + this.xTotalH + "','" + this.xTotalJ + "','" + this.xTotalK + "','" + this.JCBIntervaloE.getSelectedItem() + "','" + this.xTotalC + "','" + this.JCBAborto.getSelectedItem() + "','" + this.xTotalD + "','" + this.JCBCesarea.getSelectedItem() + "','" + this.xTotalE + "','" + this.JCBMortinato.getSelectedItem() + "','" + this.xTotalF + "','" + this.JCBPrematuro.getSelectedItem() + "','" + this.xTotalG + "','" + this.xTotalL + "','" + this.xTotalM + "','" + this.xTotalN + "','" + this.xTotalO + "','" + this.xEstado + "','" + this.xTotal + "','" + this.JLParametro2.getText() + "','" + this.xplanificacion[this.JCBMetodoPlan.getSelectedIndex()] + "','" + this.JTFNota.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xTotalP + "','" + this.xTotalQ + "','" + this.xTotalR + "','" + this.xTotalS + "')";
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                }
                this.xconsulta.ejecutarSQL(this.sql);
                this.xconsulta.cerrarConexionBd();
                mCargarTabla();
                setEnableContainer(this.JBTGrabar, false);
                JOptionPane.showMessageDialog(this, "Guardado Exitoso", "Información", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "el Metodo escrito no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNota.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Metodo De planificación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBMetodoPlan.requestFocus();
    }

    private void mCalculoEdad() {
        try {
            String sql = "SELECT`Edad`FROM`persona`WHERE (`Id_persona` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "');";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.xEdad = xrs.getInt(1);
                if (this.xEdad <= 17) {
                    this.JCBEdadMujer.setSelectedIndex(1);
                } else if (this.xEdad >= 18 && this.xEdad <= 34) {
                    this.JCBEdadMujer.setSelectedIndex(2);
                } else {
                    this.JCBEdadMujer.setSelectedIndex(3);
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPPlanificacionFliar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mSumaTotal() {
        this.xTotal = this.xTotalA + this.xTotalB + this.xTotalC + this.xTotalD + this.xTotalE + this.xTotalF + this.xTotalG + this.xTotalH + this.xTotalI + this.xTotalJ + this.xTotalK + this.xTotalL + this.xTotalM + this.xTotalN + this.xTotalO + this.xTotalP + this.xTotalQ + this.xTotalR + this.xTotalS;
        this.JLTotal21.setText("" + this.xTotal);
        if (Integer.parseInt(this.JLTotal21.getText()) >= 0 && Integer.parseInt(this.JLTotal21.getText()) <= 4) {
            this.JLParametro2.setBackground(Color.GREEN);
            this.JLParametro2.setForeground(Color.BLACK);
            this.JLParametro2.setText("BAJO");
        } else if (Integer.parseInt(this.JLTotal21.getText()) >= 5 && Integer.parseInt(this.JLTotal21.getText()) <= 9) {
            this.JLParametro2.setBackground(Color.YELLOW);
            this.JLParametro2.setForeground(Color.BLACK);
            this.JLParametro2.setText("MEDIO");
        } else if (Integer.parseInt(this.JLTotal21.getText()) >= 10) {
            this.JLParametro2.setBackground(Color.red);
            this.JLParametro2.setForeground(Color.BLACK);
            this.JLParametro2.setText("ALTO");
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Clasificacion", "Total", "Meto Planificación", "Observación", "Profesional", "Especialidad"}) { // from class: Historia.JPPlanificacionFliar.25
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mCargarTabla() {
        mCrearModeloDatos();
        String sql = "SELECT\n  `h_planificacion_fliar`.`CalTotal`\n ,`h_planificacion_fliar`.`ValTotal`\n , `h_tipometplanifica`.`Nbre`\n , `h_planificacion_fliar`.`Observacion`\n , `profesional1`.`NProfesional`\n , `profesional1`.`Especialidad`\n , `h_planificacion_fliar`.`FechaR`\nFROM\n `profesional1`\n INNER JOIN `h_planificacion_fliar` \n  ON (`profesional1`.`Id_Persona` = `h_planificacion_fliar`.`IdProfesional`) AND (`h_planificacion_fliar`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)\n INNER JOIN `h_tipometplanifica` \n  ON (`h_tipometplanifica`.`Id` = `h_planificacion_fliar`.`IdMetodo`)\nWHERE (`h_planificacion_fliar`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')\nORDER BY `h_planificacion_fliar`.`FechaR` ASC;";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    n++;
                }
                xrs.close();
                this.xconsulta.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPPlanificacionFliar.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPPlanificacionFliar$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xtotal = Long.valueOf(table.getValueAt(row, 1).toString()).longValue();
            if (xtotal >= 0 && xtotal <= 4) {
                cell.setBackground(new Color(40, 120, 52));
                cell.setForeground(Color.BLACK);
            } else if (xtotal >= 5 && xtotal <= 9) {
                cell.setBackground(Color.ORANGE);
                cell.setForeground(Color.BLACK);
            } else if (xtotal >= 10) {
                cell.setBackground(new Color(255, 0, 0));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEdadMujerActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLTotal21KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBAbortoItemStateChanged(ItemEvent evt) {
        if (this.JCBAborto.getSelectedIndex() == 0) {
            this.xTotalD = 0;
            this.JLTotal7.setText("" + this.xTotalD);
        } else if (this.JCBAborto.getSelectedIndex() == 1) {
            this.xTotalD = 2;
            this.JLTotal7.setText("" + this.xTotalD);
        } else if (this.JCBAborto.getSelectedIndex() == 2) {
            this.xTotalD = 4;
            this.JLTotal7.setText("" + this.xTotalD);
        }
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCesareaItemStateChanged(ItemEvent evt) {
        if (this.JCBCesarea.getSelectedIndex() == 0) {
            this.xTotalE = 0;
            this.JLTotal4.setText("" + this.xTotalE);
        } else if (this.JCBCesarea.getSelectedIndex() == 1) {
            this.xTotalE = 2;
            this.JLTotal4.setText("" + this.xTotalE);
        } else if (this.JCBCesarea.getSelectedIndex() == 2) {
            this.xTotalE = 4;
            this.JLTotal4.setText("" + this.xTotalE);
        }
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMortinatoItemStateChanged(ItemEvent evt) {
        if (this.JCBMortinato.getSelectedIndex() == 0) {
            this.xTotalF = 0;
            this.JLTotal5.setText("" + this.xTotalF);
        } else if (this.JCBMortinato.getSelectedIndex() == 1) {
            this.xTotalF = 2;
            this.JLTotal5.setText("" + this.xTotalF);
        } else if (this.JCBMortinato.getSelectedIndex() == 2) {
            this.xTotalF = 4;
            this.JLTotal5.setText("" + this.xTotalF);
        }
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPrematuroItemStateChanged(ItemEvent evt) {
        if (this.JCBPrematuro.getSelectedIndex() == 0) {
            this.xTotalG = 0;
            this.JLTotal6.setText("" + this.xTotalG);
        } else if (this.JCBPrematuro.getSelectedIndex() == 1) {
            this.xTotalG = 2;
            this.JLTotal6.setText("" + this.xTotalG);
        } else if (this.JCBPrematuro.getSelectedIndex() == 2) {
            this.xTotalG = 4;
            this.JLTotal6.setText("" + this.xTotalG);
        }
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHC1ActionPerformed(ActionEvent evt) {
        if (this.JCHC1.isSelected()) {
            this.xTotalH = 2;
        } else {
            this.xTotalH = 0;
        }
        mSumaTotal();
        this.JLTotal13.setText("" + this.xTotalH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHC2ActionPerformed(ActionEvent evt) {
        if (this.JCHC2.isSelected()) {
            this.xTotalJ = 2;
        } else {
            this.xTotalJ = 0;
        }
        mSumaTotal();
        this.JLTotal14.setText("" + this.xTotalJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHC3ActionPerformed(ActionEvent evt) {
        if (this.JCHC3.isSelected()) {
            this.xTotalK = 2;
        } else {
            this.xTotalK = 0;
        }
        this.JLTotal15.setText("" + this.xTotalK);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHHipertensionActionPerformed(ActionEvent evt) {
        if (this.JCHHipertension.isSelected()) {
            this.xTotalL = 2;
        } else {
            this.xTotalL = 0;
        }
        this.JLTotal8.setText("" + this.xTotalL);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHToxemiaActionPerformed(ActionEvent evt) {
        if (this.JCHToxemia.isSelected()) {
            this.xTotalM = 2;
        } else {
            this.xTotalM = 0;
        }
        this.JLTotal9.setText("" + this.xTotalM);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHOtraPatologiaActionPerformed(ActionEvent evt) {
        if (this.JCHOtraPatologia.isSelected()) {
            this.xTotalO = 2;
        } else {
            this.xTotalO = 0;
        }
        this.JLTotal11.setText("" + this.xTotalO);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAnemiaActionPerformed(ActionEvent evt) {
        if (this.JCHAnemia.isSelected()) {
            this.xTotalP = 4;
        } else {
            this.xTotalP = 0;
        }
        this.JLTotal16.setText("" + this.xTotalP);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEnferRenalActionPerformed(ActionEvent evt) {
        if (this.JCHEnferRenal.isSelected()) {
            this.xTotalQ = 4;
        } else {
            this.xTotalQ = 0;
        }
        this.JLTotal17.setText("" + this.xTotalQ);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHOtraPatologiaAActionPerformed(ActionEvent evt) {
        if (this.JCHOtraPatologiaA.isSelected()) {
            this.xTotalS = 4;
        } else {
            this.xTotalS = 0;
        }
        this.JLTotal19.setText("" + this.xTotalS);
        mSumaTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLParametro2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBParidadMujerActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void mRecargarCombo() {
        this.JCBMetodoPlan.removeAllItems();
        this.xplanificacion = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM h_tipometplanifica  WHERE (Estado =0) ORDER BY Nbre ASC", this.xplanificacion, this.JCBMetodoPlan);
        this.JCBMetodoPlan.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }
}
