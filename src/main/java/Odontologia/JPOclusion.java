package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOclusion.class */
public class JPOclusion extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo2;
    private Object[] xdato;
    private ButtonGroup JBGHorizontal;
    private ButtonGroup JBGLateralidadTasn;
    private ButtonGroup JBGRC;
    private ButtonGroup JBGRM;
    private ButtonGroup JBGVertical;
    private JButton JBGuardar;
    private JPanel JPEncabezado;
    private JPanel JPMayoral;
    private JPanel JPRCanina;
    private JPanel JPRCanina2;
    private JPanel JPRHorizontal;
    private JPanel JPRMolar;
    private JPanel JPRelacionTrasversal;
    private JRadioButton JRBAbierta;
    private JRadioButton JRBAumentada;
    private JRadioButton JRBBilateral;
    private JRadioButton JRBClase1RC;
    private JRadioButton JRBClase1RM;
    private JRadioButton JRBClase2RC;
    private JRadioButton JRBClase2RM;
    private JRadioButton JRBClase3RC;
    private JRadioButton JRBClase3RM;
    private JRadioButton JRBDisminuida;
    private JRadioButton JRBProfunda;
    private JRadioButton JRBUnilateral;
    private JScrollPane JSPDetalle;
    private JTextArea JTAObsTrasn;
    private JTable JTDetalle;
    private JFormattedTextField JTFFDistal;
    private JFormattedTextField JTFFMesial;
    private JFormattedTextField JTFFPterminal;
    private JFormattedTextField JTFFSobremordidaH;
    private JFormattedTextField JTFFSobremordidaV;
    private JScrollPane jScrollPane1;
    Metodos xmt = new Metodos();
    private long xrmolar = 0;
    private long xrcanino = 0;
    private long xconceptoh = 0;
    private long xconceptov = 0;
    private long xrtrasversal = 0;
    ConsultasMySQL xconsulta = new ConsultasMySQL();
    private String xexamen = "";

    public JPOclusion() {
        initComponents();
        mNuevo();
        mBuscarOclusion();
    }

    private void mNuevo() {
        this.JTFFSobremordidaH.setValue(0);
        this.JTFFDistal.setValue(0);
        this.JTFFMesial.setValue(0);
        this.JTFFPterminal.setValue(0);
        this.JTFFSobremordidaV.setValue(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "RMolar", "RCanina", "Escalon distal", "Escalon mesial", "Escalon PlanoTA", "Sobremordida H", "Concepto", "Sobremordida V", "Concepto", "Relación Trasnversal", "Observación"}) { // from class: Odontologia.JPOclusion.1
            Class[] types = {Integer.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "INSERT INTO o_oclusion (`IdAtencion`, IdUsuarioA , `RMolar` , `RCanino` , `EDistal` , `EMesial`  , `EPTRecto`  , `SMordidaH`,ConceptoH , `SMordidaV`,ConceptoV  , `RTrasversal` , `Observacion` , `UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xrmolar + "','" + this.xrcanino + "','" + this.JTFFDistal.getValue() + "','" + this.JTFFMesial.getValue() + "','" + this.JTFFPterminal.getValue() + "', '" + this.JTFFSobremordidaH.getValue() + "','" + this.xconceptoh + "','" + this.JTFFSobremordidaV.getValue() + "','" + this.xconceptov + "','" + this.xrtrasversal + "','" + this.JTAObsTrasn.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xconsulta.ejecutarSQL(sql);
            this.xconsulta.cerrarConexionBd();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            mBuscarOclusion();
        }
    }

    private void mBuscarOclusion() {
        mCrearModelo();
        String sql = "SELECT `Id` , IF(`RMolar`=1,'Clase I',IF(RMolar=2,'Clase II','Clase III')) AS RMolar , IF(`RCanino`=1,'Clase I',IF(RCanino=2,'Clase II','Clase III')) AS RCanino , `EDistal` , `EMesial`  , `EPTRecto`  , `SMordidaH` , IF(ConceptoH=0,'Aumentada','Disminuida') AS ConceptoH, `SMordidaV`,IF(ConceptoV=0,'Profunda','Abierta') AS ConceptoV  , IF(`RTrasversal`=0,'Unilateral','Bilateral') AS RTrasversal, `Observacion`  FROM `o_oclusion` WHERE (IdUsuarioA='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), 0, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), 0, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), 0, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), 0, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), 0, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), 0, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), 0, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), 0, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), 0, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), 0, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), 0, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), 0, 11);
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOclusion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGRM = new ButtonGroup();
        this.JBGRC = new ButtonGroup();
        this.JBGHorizontal = new ButtonGroup();
        this.JBGVertical = new ButtonGroup();
        this.JBGLateralidadTasn = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPEncabezado = new JPanel();
        this.JTFFSobremordidaH = new JFormattedTextField();
        this.JPMayoral = new JPanel();
        this.JTFFDistal = new JFormattedTextField();
        this.JTFFMesial = new JFormattedTextField();
        this.JTFFPterminal = new JFormattedTextField();
        this.JPRMolar = new JPanel();
        this.JRBClase1RM = new JRadioButton();
        this.JRBClase2RM = new JRadioButton();
        this.JRBClase3RM = new JRadioButton();
        this.JPRCanina = new JPanel();
        this.JRBClase1RC = new JRadioButton();
        this.JRBClase2RC = new JRadioButton();
        this.JRBClase3RC = new JRadioButton();
        this.JTFFSobremordidaV = new JFormattedTextField();
        this.JPRHorizontal = new JPanel();
        this.JRBAumentada = new JRadioButton();
        this.JRBDisminuida = new JRadioButton();
        this.JPRCanina2 = new JPanel();
        this.JRBProfunda = new JRadioButton();
        this.JRBAbierta = new JRadioButton();
        this.JPRelacionTrasversal = new JPanel();
        this.JRBUnilateral = new JRadioButton();
        this.JRBBilateral = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObsTrasn = new JTextArea();
        this.JBGuardar = new JButton();
        setName("jpoclusion");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "MEDIDA TRANSVERSAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.JTFFSobremordidaH.setBorder(BorderFactory.createTitledBorder((Border) null, "Sobremordida Horizontal (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSobremordidaH.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFSobremordidaH.setHorizontalAlignment(4);
        this.JTFFSobremordidaH.setFont(new Font("Arial", 1, 12));
        this.JPMayoral.setBorder(BorderFactory.createTitledBorder((Border) null, "Escalón", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFDistal.setBorder(BorderFactory.createTitledBorder((Border) null, "Distal (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFDistal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFDistal.setHorizontalAlignment(4);
        this.JTFFDistal.setFont(new Font("Arial", 1, 12));
        this.JTFFMesial.setBorder(BorderFactory.createTitledBorder((Border) null, "Mesial (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFMesial.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFMesial.setHorizontalAlignment(4);
        this.JTFFMesial.setFont(new Font("Arial", 1, 12));
        this.JTFFPterminal.setBorder(BorderFactory.createTitledBorder((Border) null, "Plano terminal recto (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPterminal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPterminal.setHorizontalAlignment(4);
        this.JTFFPterminal.setFont(new Font("Arial", 1, 12));
        GroupLayout JPMayoralLayout = new GroupLayout(this.JPMayoral);
        this.JPMayoral.setLayout(JPMayoralLayout);
        JPMayoralLayout.setHorizontalGroup(JPMayoralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMayoralLayout.createSequentialGroup().addComponent(this.JTFFDistal, -2, 173, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFMesial, -2, 173, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFPterminal, -2, 173, -2).addContainerGap()));
        JPMayoralLayout.setVerticalGroup(JPMayoralLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMayoralLayout.createSequentialGroup().addGroup(JPMayoralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFDistal, -2, 50, -2).addComponent(this.JTFFMesial, -2, 50, -2).addComponent(this.JTFFPterminal, -2, 50, -2)).addGap(3, 3, 3)));
        this.JPRMolar.setBorder(BorderFactory.createTitledBorder((Border) null, "Relación molar (clasificación de Angle)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGRM.add(this.JRBClase1RM);
        this.JRBClase1RM.setFont(new Font("Arial", 1, 12));
        this.JRBClase1RM.setSelected(true);
        this.JRBClase1RM.setText("Clase I");
        this.JRBClase1RM.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.2
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBClase1RMActionPerformed(evt);
            }
        });
        this.JBGRM.add(this.JRBClase2RM);
        this.JRBClase2RM.setFont(new Font("Arial", 1, 12));
        this.JRBClase2RM.setText("Clase II");
        this.JRBClase2RM.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.3
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBClase2RMActionPerformed(evt);
            }
        });
        this.JBGRM.add(this.JRBClase3RM);
        this.JRBClase3RM.setFont(new Font("Arial", 1, 12));
        this.JRBClase3RM.setText("Clase III");
        this.JRBClase3RM.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.4
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBClase3RMActionPerformed(evt);
            }
        });
        GroupLayout JPRMolarLayout = new GroupLayout(this.JPRMolar);
        this.JPRMolar.setLayout(JPRMolarLayout);
        JPRMolarLayout.setHorizontalGroup(JPRMolarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRMolarLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBClase1RM).addGap(18, 18, 18).addComponent(this.JRBClase2RM).addGap(18, 18, 18).addComponent(this.JRBClase3RM)));
        JPRMolarLayout.setVerticalGroup(JPRMolarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRMolarLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPRMolarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBClase1RM).addComponent(this.JRBClase2RM).addComponent(this.JRBClase3RM))));
        this.JPRCanina.setBorder(BorderFactory.createTitledBorder((Border) null, "Relación Canina (clasificación de Angle)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGRC.add(this.JRBClase1RC);
        this.JRBClase1RC.setFont(new Font("Arial", 1, 12));
        this.JRBClase1RC.setSelected(true);
        this.JRBClase1RC.setText("Clase I");
        this.JRBClase1RC.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.5
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBClase1RCActionPerformed(evt);
            }
        });
        this.JBGRC.add(this.JRBClase2RC);
        this.JRBClase2RC.setFont(new Font("Arial", 1, 12));
        this.JRBClase2RC.setText("Clase II");
        this.JRBClase2RC.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.6
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBClase2RCActionPerformed(evt);
            }
        });
        this.JBGRC.add(this.JRBClase3RC);
        this.JRBClase3RC.setFont(new Font("Arial", 1, 12));
        this.JRBClase3RC.setText("Clase III");
        this.JRBClase3RC.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.7
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBClase3RCActionPerformed(evt);
            }
        });
        GroupLayout JPRCaninaLayout = new GroupLayout(this.JPRCanina);
        this.JPRCanina.setLayout(JPRCaninaLayout);
        JPRCaninaLayout.setHorizontalGroup(JPRCaninaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRCaninaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBClase1RC).addGap(18, 18, 18).addComponent(this.JRBClase2RC).addGap(18, 18, 18).addComponent(this.JRBClase3RC)));
        JPRCaninaLayout.setVerticalGroup(JPRCaninaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRCaninaLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPRCaninaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBClase1RC).addComponent(this.JRBClase2RC).addComponent(this.JRBClase3RC))));
        this.JTFFSobremordidaV.setBorder(BorderFactory.createTitledBorder((Border) null, "Sobremordida Vertical (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSobremordidaV.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFSobremordidaV.setHorizontalAlignment(4);
        this.JTFFSobremordidaV.setFont(new Font("Arial", 1, 12));
        this.JPRHorizontal.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGHorizontal.add(this.JRBAumentada);
        this.JRBAumentada.setFont(new Font("Arial", 1, 12));
        this.JRBAumentada.setSelected(true);
        this.JRBAumentada.setText("Aumentada");
        this.JRBAumentada.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.8
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBAumentadaActionPerformed(evt);
            }
        });
        this.JBGHorizontal.add(this.JRBDisminuida);
        this.JRBDisminuida.setFont(new Font("Arial", 1, 12));
        this.JRBDisminuida.setText("Disminuida");
        this.JRBDisminuida.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.9
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBDisminuidaActionPerformed(evt);
            }
        });
        GroupLayout JPRHorizontalLayout = new GroupLayout(this.JPRHorizontal);
        this.JPRHorizontal.setLayout(JPRHorizontalLayout);
        JPRHorizontalLayout.setHorizontalGroup(JPRHorizontalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRHorizontalLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBAumentada).addGap(18, 18, 18).addComponent(this.JRBDisminuida).addGap(87, 87, 87)));
        JPRHorizontalLayout.setVerticalGroup(JPRHorizontalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRHorizontalLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPRHorizontalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAumentada).addComponent(this.JRBDisminuida)).addContainerGap(12, 32767)));
        this.JPRCanina2.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGVertical.add(this.JRBProfunda);
        this.JRBProfunda.setFont(new Font("Arial", 1, 12));
        this.JRBProfunda.setSelected(true);
        this.JRBProfunda.setText("Profunda");
        this.JRBProfunda.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.10
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBProfundaActionPerformed(evt);
            }
        });
        this.JBGVertical.add(this.JRBAbierta);
        this.JRBAbierta.setFont(new Font("Arial", 1, 12));
        this.JRBAbierta.setText("Abierta");
        this.JRBAbierta.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.11
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBAbiertaActionPerformed(evt);
            }
        });
        GroupLayout JPRCanina2Layout = new GroupLayout(this.JPRCanina2);
        this.JPRCanina2.setLayout(JPRCanina2Layout);
        JPRCanina2Layout.setHorizontalGroup(JPRCanina2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRCanina2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBProfunda).addGap(31, 31, 31).addComponent(this.JRBAbierta).addGap(74, 74, 74)));
        JPRCanina2Layout.setVerticalGroup(JPRCanina2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRCanina2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPRCanina2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBProfunda).addComponent(this.JRBAbierta)).addContainerGap(12, 32767)));
        this.JPRelacionTrasversal.setBorder(BorderFactory.createTitledBorder((Border) null, "Relación Transversal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGLateralidadTasn.add(this.JRBUnilateral);
        this.JRBUnilateral.setFont(new Font("Arial", 1, 12));
        this.JRBUnilateral.setSelected(true);
        this.JRBUnilateral.setText("Unilateral");
        this.JRBUnilateral.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.12
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBUnilateralActionPerformed(evt);
            }
        });
        this.JBGLateralidadTasn.add(this.JRBBilateral);
        this.JRBBilateral.setFont(new Font("Arial", 1, 12));
        this.JRBBilateral.setText("Bilateral");
        this.JRBBilateral.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.13
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JRBBilateralActionPerformed(evt);
            }
        });
        this.JTAObsTrasn.setColumns(1);
        this.JTAObsTrasn.setLineWrap(true);
        this.JTAObsTrasn.setRows(1);
        this.JTAObsTrasn.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAObsTrasn);
        GroupLayout JPRelacionTrasversalLayout = new GroupLayout(this.JPRelacionTrasversal);
        this.JPRelacionTrasversal.setLayout(JPRelacionTrasversalLayout);
        JPRelacionTrasversalLayout.setHorizontalGroup(JPRelacionTrasversalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRelacionTrasversalLayout.createSequentialGroup().addContainerGap().addGroup(JPRelacionTrasversalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBUnilateral).addComponent(this.JRBBilateral)).addGap(18, 18, 18).addComponent(this.jScrollPane1, -1, 246, 32767).addContainerGap()));
        JPRelacionTrasversalLayout.setVerticalGroup(JPRelacionTrasversalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRelacionTrasversalLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPRelacionTrasversalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRelacionTrasversalLayout.createSequentialGroup().addComponent(this.JRBUnilateral).addGap(18, 18, 18).addComponent(this.JRBBilateral).addGap(0, 0, 32767)).addComponent(this.jScrollPane1)).addContainerGap()));
        GroupLayout JPEncabezadoLayout = new GroupLayout(this.JPEncabezado);
        this.JPEncabezado.setLayout(JPEncabezadoLayout);
        JPEncabezadoLayout.setHorizontalGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEncabezadoLayout.createSequentialGroup().addComponent(this.JPRMolar, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPRCanina, -2, -1, -2)).addComponent(this.JPMayoral, -2, -1, -2).addGroup(JPEncabezadoLayout.createSequentialGroup().addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFSobremordidaH, -2, 201, -2).addComponent(this.JTFFSobremordidaV, -2, 201, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPRHorizontal, -2, 222, -2).addComponent(this.JPRCanina2, -2, 222, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPRelacionTrasversal, -2, -1, -2))).addContainerGap(80, 32767)));
        JPEncabezadoLayout.setVerticalGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEncabezadoLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPRMolar, -2, -1, -2).addComponent(this.JPRCanina, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPMayoral, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEncabezadoLayout.createSequentialGroup().addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPRHorizontal, -1, -1, 32767).addComponent(this.JTFFSobremordidaH)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFSobremordidaV).addComponent(this.JPRCanina2, -1, -1, 32767))).addComponent(this.JPRelacionTrasversal, -2, -1, -2))));
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Odontologia.JPOclusion.14
            public void actionPerformed(ActionEvent evt) {
                JPOclusion.this.JBGuardarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPEncabezado, -1, -1, 32767).addComponent(this.JBGuardar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 196, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGuardar, -2, 34, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBClase1RMActionPerformed(ActionEvent evt) {
        this.xrmolar = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBClase2RMActionPerformed(ActionEvent evt) {
        this.xrmolar = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBClase3RMActionPerformed(ActionEvent evt) {
        this.xrmolar = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBClase1RCActionPerformed(ActionEvent evt) {
        this.xrcanino = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBClase2RCActionPerformed(ActionEvent evt) {
        this.xrcanino = 2L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBClase3RCActionPerformed(ActionEvent evt) {
        this.xrcanino = 3L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAumentadaActionPerformed(ActionEvent evt) {
        this.xconceptoh = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDisminuidaActionPerformed(ActionEvent evt) {
        this.xconceptoh = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBProfundaActionPerformed(ActionEvent evt) {
        this.xconceptov = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAbiertaActionPerformed(ActionEvent evt) {
        this.xconceptov = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUnilateralActionPerformed(ActionEvent evt) {
        this.xrtrasversal = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBBilateralActionPerformed(ActionEvent evt) {
        this.xrtrasversal = 1L;
    }
}
