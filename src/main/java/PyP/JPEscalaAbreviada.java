package PyP;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:PyP/JPEscalaAbreviada.class */
public class JPEscalaAbreviada extends JPanel {
    private Object[] xdatos;
    private DefaultTableModel xmodeloA;
    private DefaultTableModel xmodeloB;
    private DefaultTableModel xmodeloC;
    private DefaultTableModel xmodeloD;
    private DefaultTableModel xmodeloH;
    String xedad;
    private long AI;
    private long AF;
    private long MI;
    private long MF;
    private long MAI;
    private long MAF;
    private long ALT;
    private JButton JBGrabar;
    private JDateChooser JDFecha;
    private JTextField JLParametro;
    private JLabel JLTotal;
    private JPanel JPAyB;
    private JPanel JPHistorico;
    private JScrollPane JSPDetalleA;
    private JScrollPane JSPDetalleB;
    private JScrollPane JSPDetalleC;
    private JScrollPane JSPDetalleD;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPRespiracion;
    private JTextArea JTAObservacion;
    private JTable JTDetalleA;
    private JTable JTDetalleB;
    private JTable JTDetalleC;
    private JTable JTDetalleD;
    private JTable JTHistorico;
    private JTabbedPane JTPDatos;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox5;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xTotal = 0;
    private int xTotalA = 0;
    private int xTotalB = 0;
    private int xTotalC = 0;
    private int xTotalD = 0;

    public JPEscalaAbreviada() {
        this.xedad = "";
        this.AI = 0L;
        this.AF = 0L;
        this.MI = 0L;
        this.MF = 0L;
        this.MAI = 0L;
        this.MAF = 0L;
        this.ALT = 0L;
        initComponents();
        ResultSet xrs = this.xct.traerRs("SELECT `FechaNac` FROM `persona` WHERE (`Id_persona` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "');");
        try {
            if (xrs.next()) {
                System.out.println("Edad--->" + xrs.getString(1));
                this.xedad = this.xmt.entregarEdadEnMeses(xrs.getString(1));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEscalaAbreviada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        String sql = "SELECT `AlertaI` , `AlertaF` , `MedioI`  , `MedioF` , `MAltoI`  , `MAltoF`  , `Alto` FROM `p_escala_parametros` WHERE ( '" + this.xedad + "'>=`RangoI`  AND  '" + this.xedad + "'<=RangoF);";
        ResultSet xrs2 = this.xct.traerRs(sql);
        System.out.println("Consulta-->" + sql);
        try {
            if (xrs2.next()) {
                xrs2.first();
                this.AI = xrs2.getLong("AlertaI");
                this.AF = xrs2.getLong("AlertaF");
                this.MI = xrs2.getLong("MedioI");
                this.MF = xrs2.getLong("MedioF");
                this.MAI = xrs2.getLong("MAltoI");
                this.MAF = xrs2.getLong("MAltoF");
                this.ALT = xrs2.getLong("Alto");
            }
            System.out.println("Edad-->" + this.xedad);
            System.out.println("AI->" + this.AI + " AF->" + this.AF + " MI->" + this.MI + " MF->" + this.MF + " MAI->" + this.MAI + " MAF->" + this.MAF + " ALT->" + this.ALT);
            xrs2.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex2) {
            Logger.getLogger(JPEscalaAbreviada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
        System.out.println("Edad--->" + this.xedad);
        this.JDFecha.setDate(this.xmt.getFechaActual());
        mCrearModelos(1L, this.xedad, this.xmodeloA, this.JTDetalleA);
        mCrearModelos(2L, this.xedad, this.xmodeloB, this.JTDetalleB);
        mCrearModelos(3L, this.xedad, this.xmodeloC, this.JTDetalleC);
        mCrearModelos(4L, this.xedad, this.xmodeloD, this.JTDetalleD);
        mBuscaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v32, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JDFecha = new JDateChooser();
        this.JTPDatos = new JTabbedPane();
        this.JPAyB = new JPanel();
        this.JSPDetalleA = new JScrollPane();
        this.JTDetalleA = new JTable();
        this.JSPDetalleB = new JScrollPane();
        this.JTDetalleB = new JTable();
        this.jPanel1 = new JPanel();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JSPDetalleD = new JScrollPane();
        this.JTDetalleD = new JTable();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox5 = new JCheckBox();
        this.JLTotal = new JLabel();
        this.JBGrabar = new JButton();
        this.JSPRespiracion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLParametro = new JTextField();
        setName("jpescalaabreviada");
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleA.setBorder(BorderFactory.createTitledBorder((Border) null, "A MOTRICIDAD GRUESA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleA.setFont(new Font("Arial", 1, 12));
        this.JTDetalleA.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleA.setRowHeight(25);
        this.JTDetalleA.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleA.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleA.setSelectionMode(0);
        this.JTDetalleA.addMouseListener(new MouseAdapter() { // from class: PyP.JPEscalaAbreviada.1
            public void mouseClicked(MouseEvent evt) {
                JPEscalaAbreviada.this.JTDetalleAMouseClicked(evt);
            }
        });
        this.JSPDetalleA.setViewportView(this.JTDetalleA);
        this.JSPDetalleB.setBorder(BorderFactory.createTitledBorder((Border) null, "B MOTRIZ-FINO ADAPTATIVA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleB.setFont(new Font("Arial", 1, 12));
        this.JTDetalleB.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleB.setRowHeight(25);
        this.JTDetalleB.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleB.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleB.setSelectionMode(0);
        this.JTDetalleB.addMouseListener(new MouseAdapter() { // from class: PyP.JPEscalaAbreviada.2
            public void mouseClicked(MouseEvent evt) {
                JPEscalaAbreviada.this.JTDetalleBMouseClicked(evt);
            }
        });
        this.JSPDetalleB.setViewportView(this.JTDetalleB);
        GroupLayout JPAyBLayout = new GroupLayout(this.JPAyB);
        this.JPAyB.setLayout(JPAyBLayout);
        JPAyBLayout.setHorizontalGroup(JPAyBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAyBLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JSPDetalleA, -2, 415, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleB, -2, 415, -2).addContainerGap(22, 32767)));
        JPAyBLayout.setVerticalGroup(JPAyBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAyBLayout.createSequentialGroup().addContainerGap().addGroup(JPAyBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleA, -1, 466, 32767).addComponent(this.JSPDetalleB))));
        this.JTPDatos.addTab("A y B", this.JPAyB);
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "C ADICIÓN LENGUAJE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleC.setSelectionMode(0);
        this.JTDetalleC.addMouseListener(new MouseAdapter() { // from class: PyP.JPEscalaAbreviada.3
            public void mouseClicked(MouseEvent evt) {
                JPEscalaAbreviada.this.JTDetalleCMouseClicked(evt);
            }
        });
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JSPDetalleD.setBorder(BorderFactory.createTitledBorder((Border) null, "D PERSONAL SOCIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleD.setFont(new Font("Arial", 1, 12));
        this.JTDetalleD.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleD.setRowHeight(25);
        this.JTDetalleD.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleD.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleD.setSelectionMode(0);
        this.JTDetalleD.addMouseListener(new MouseAdapter() { // from class: PyP.JPEscalaAbreviada.4
            public void mouseClicked(MouseEvent evt) {
                JPEscalaAbreviada.this.JTDetalleDMouseClicked(evt);
            }
        });
        this.JSPDetalleD.setViewportView(this.JTDetalleD);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JSPDetalleC, -2, 415, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleD, -2, 415, -2).addContainerGap(22, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleC, -1, 466, 32767).addComponent(this.JSPDetalleD))));
        this.JTPDatos.addTab("C y D", this.jPanel1);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setRowHeight(25);
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.setSelectionMode(0);
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: PyP.JPEscalaAbreviada.5
            public void mouseClicked(MouseEvent evt) {
                JPEscalaAbreviada.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.jCheckBox1.setBackground(new Color(255, 0, 0));
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setForeground(new Color(255, 255, 255));
        this.jCheckBox1.setText("ALERTA");
        this.jCheckBox2.setBackground(Color.orange);
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setText("MEDIO");
        this.jCheckBox3.setBackground(Color.yellow);
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setText("MEDIO ALTO");
        this.jCheckBox5.setBackground(new Color(40, 120, 52));
        this.jCheckBox5.setFont(new Font("Arial", 1, 12));
        this.jCheckBox5.setForeground(new Color(255, 255, 255));
        this.jCheckBox5.setText("ALTO");
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addComponent(this.jCheckBox1, -2, 100, -2).addGap(10, 10, 10).addComponent(this.jCheckBox2, -2, 100, -2).addGap(10, 10, 10).addComponent(this.jCheckBox3, -2, 100, -2).addGap(18, 18, 18).addComponent(this.jCheckBox5, -2, 100, -2).addGap(0, 0, 32767)).addComponent(this.JSPHistorico, -1, 843, 32767)).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 355, -2).addGap(18, 18, 18).addGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2).addComponent(this.jCheckBox3).addComponent(this.jCheckBox5)).addContainerGap(70, 32767)));
        this.JTPDatos.addTab("HISTÓRICO", this.JPHistorico);
        this.JLTotal.setFont(new Font("Arial", 1, 18));
        this.JLTotal.setForeground(new Color(255, 0, 0));
        this.JLTotal.setHorizontalAlignment(0);
        this.JLTotal.setText("0");
        this.JLTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: PyP.JPEscalaAbreviada.6
            public void actionPerformed(ActionEvent evt) {
                JPEscalaAbreviada.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setToolTipText("");
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRespiracion.setViewportView(this.JTAObservacion);
        this.JLParametro.setEditable(false);
        this.JLParametro.setFont(new Font("Arial", 1, 12));
        this.JLParametro.setHorizontalAlignment(0);
        this.JLParametro.setBorder(BorderFactory.createEtchedBorder());
        this.JLParametro.setFocusable(false);
        this.JLParametro.setInheritsPopupMenu(true);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addGroup(layout.createSequentialGroup().addComponent(this.JDFecha, -2, 119, -2).addGap(10, 10, 10).addComponent(this.JLTotal, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLParametro, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPRespiracion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBGrabar, -2, 120, -2).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLTotal).addComponent(this.JBGrabar, -2, 45, -2).addComponent(this.JDFecha, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLParametro, GroupLayout.Alignment.LEADING).addComponent(this.JSPRespiracion, GroupLayout.Alignment.LEADING, -1, 45, 32767))).addGap(4, 4, 4).addComponent(this.JTPDatos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleAMouseClicked(MouseEvent evt) {
        if (this.JTDetalleA.getRowCount() > 0 && this.JTDetalleA.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            this.JTDetalleA.setValueAt(true, this.JTDetalleA.getSelectedRow(), 4);
            System.out.println("colum 4 " + this.JTDetalleA.getValueAt(this.JTDetalleA.getSelectedRow(), 4).toString());
            int x = 0;
            if (Boolean.valueOf(this.JTDetalleA.getValueAt(this.JTDetalleA.getSelectedRow(), 4).toString()).booleanValue()) {
                for (int i = 0; i < this.JTDetalleA.getRowCount(); i++) {
                    x++;
                    this.JTDetalleA.setValueAt(false, i, 4);
                }
                this.JTDetalleA.setValueAt(true, this.JTDetalleA.getSelectedRow(), 4);
                this.xTotalA = Integer.parseInt(this.JTDetalleA.getValueAt(this.JTDetalleA.getSelectedRow(), 2).toString());
                this.xTotal = this.xTotalA + this.xTotalB + this.xTotalC + this.xTotalD;
                this.JLTotal.setText("" + this.xTotal);
                System.out.println("hay " + x + " con el mismo rango");
            } else {
                this.xTotal -= Integer.parseInt(this.JTDetalleA.getValueAt(this.JTDetalleA.getSelectedRow(), 2).toString());
                this.JLTotal.setText("" + this.xTotal);
                this.xTotalA = 0;
            }
            mParametros();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleBMouseClicked(MouseEvent evt) {
        if (this.JTDetalleB.getRowCount() > 0 && this.JTDetalleB.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            this.JTDetalleB.setValueAt(true, this.JTDetalleB.getSelectedRow(), 4);
            System.out.println("colum 4 " + this.JTDetalleB.getValueAt(this.JTDetalleB.getSelectedRow(), 4).toString());
            int x = 0;
            if (Boolean.valueOf(this.JTDetalleB.getValueAt(this.JTDetalleB.getSelectedRow(), 4).toString()).booleanValue()) {
                for (int i = 0; i < this.JTDetalleB.getRowCount(); i++) {
                    x++;
                    this.JTDetalleB.setValueAt(false, i, 4);
                }
                this.JTDetalleB.setValueAt(true, this.JTDetalleB.getSelectedRow(), 4);
                this.xTotalB = Integer.parseInt(this.JTDetalleB.getValueAt(this.JTDetalleB.getSelectedRow(), 2).toString());
                this.xTotal = this.xTotalA + this.xTotalB + this.xTotalC + this.xTotalD;
                this.JLTotal.setText("" + this.xTotal);
                System.out.println("hay " + x + " con el mismo rango");
            } else {
                this.xTotal -= Integer.parseInt(this.JTDetalleB.getValueAt(this.JTDetalleB.getSelectedRow(), 2).toString());
                this.JLTotal.setText("" + this.xTotal);
                this.xTotalB = 0;
            }
            mParametros();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCMouseClicked(MouseEvent evt) {
        if (this.JTDetalleC.getRowCount() > 0 && this.JTDetalleC.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            this.JTDetalleC.setValueAt(true, this.JTDetalleC.getSelectedRow(), 4);
            System.out.println("colum 4 " + this.JTDetalleC.getValueAt(this.JTDetalleC.getSelectedRow(), 4).toString());
            int x = 0;
            if (Boolean.valueOf(this.JTDetalleC.getValueAt(this.JTDetalleC.getSelectedRow(), 4).toString()).booleanValue()) {
                for (int i = 0; i < this.JTDetalleC.getRowCount(); i++) {
                    x++;
                    this.JTDetalleC.setValueAt(false, i, 4);
                }
                this.JTDetalleC.setValueAt(true, this.JTDetalleC.getSelectedRow(), 4);
                this.xTotalC = Integer.parseInt(this.JTDetalleC.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString());
                this.xTotal = this.xTotalA + this.xTotalB + this.xTotalC + this.xTotalD;
                this.JLTotal.setText("" + this.xTotal);
                System.out.println("hay " + x + " con el mismo rango");
            } else {
                this.xTotal -= Integer.parseInt(this.JTDetalleC.getValueAt(this.JTDetalleC.getSelectedRow(), 2).toString());
                this.JLTotal.setText("" + this.xTotal);
                this.xTotalC = 0;
            }
            mParametros();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleDMouseClicked(MouseEvent evt) {
        if (this.JTDetalleD.getRowCount() > 0 && this.JTDetalleD.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            this.JTDetalleD.setValueAt(true, this.JTDetalleD.getSelectedRow(), 4);
            System.out.println("colum 4 " + this.JTDetalleD.getValueAt(this.JTDetalleD.getSelectedRow(), 4).toString());
            int x = 0;
            if (Boolean.valueOf(this.JTDetalleD.getValueAt(this.JTDetalleD.getSelectedRow(), 4).toString()).booleanValue()) {
                for (int i = 0; i < this.JTDetalleD.getRowCount(); i++) {
                    x++;
                    this.JTDetalleD.setValueAt(false, i, 4);
                }
                this.JTDetalleD.setValueAt(true, this.JTDetalleD.getSelectedRow(), 4);
                this.xTotalD = Integer.parseInt(this.JTDetalleD.getValueAt(this.JTDetalleD.getSelectedRow(), 2).toString());
                this.xTotal = this.xTotalA + this.xTotalB + this.xTotalC + this.xTotalD;
                this.JLTotal.setText("" + this.xTotal);
                System.out.println("hay " + x + " con el mismo rango");
            } else {
                this.xTotal -= Integer.parseInt(this.JTDetalleD.getValueAt(this.JTDetalleD.getSelectedRow(), 2).toString());
                this.JLTotal.setText("" + this.xTotal);
                this.xTotalD = 0;
            }
            mParametros();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    private void mParametros() {
        if (Integer.parseInt(this.JLTotal.getText()) >= this.AI && Integer.parseInt(this.JLTotal.getText()) <= this.AF) {
            this.JLParametro.setBackground(Color.red);
            this.JLParametro.setForeground(Color.WHITE);
            this.JLParametro.setText("ALERTA");
            return;
        }
        if (Integer.parseInt(this.JLTotal.getText()) >= this.MI && Integer.parseInt(this.JLTotal.getText()) <= this.MF) {
            this.JLParametro.setBackground(Color.ORANGE);
            this.JLParametro.setForeground(Color.BLACK);
            this.JLParametro.setText("MEDIA");
        } else if (Integer.parseInt(this.JLTotal.getText()) >= this.MAI && Integer.parseInt(this.JLTotal.getText()) <= this.MAF) {
            this.JLParametro.setBackground(Color.YELLOW);
            this.JLParametro.setForeground(Color.BLACK);
            this.JLParametro.setText("MEDIO ALTO");
        } else if (Integer.parseInt(this.JLTotal.getText()) >= this.ALT) {
            this.JLParametro.setBackground(Color.GREEN);
            this.JLParametro.setForeground(Color.BLACK);
            this.JLParametro.setText("ALTO");
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelos(long xCat, String edad, DefaultTableModel xmodelo, JTable xtabla) {
        DefaultTableModel xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Rango", "#", "Pregunta", "Aplica?"}) { // from class: PyP.JPEscalaAbreviada.7
            Class[] types = {Long.class, Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        xtabla.setModel(xmodelo2);
        xtabla.getColumnModel().getColumn(0).setPreferredWidth(0);
        xtabla.getColumnModel().getColumn(0).setMinWidth(0);
        xtabla.getColumnModel().getColumn(0).setMaxWidth(0);
        xtabla.getColumnModel().getColumn(1).setPreferredWidth(25);
        xtabla.getColumnModel().getColumn(2).setPreferredWidth(5);
        xtabla.getColumnModel().getColumn(3).setPreferredWidth(250);
        xtabla.getColumnModel().getColumn(4).setPreferredWidth(10);
        System.out.println("Cat " + xCat + " Edad " + edad + " Modelo " + xmodelo2 + " Tabla " + xtabla);
        String sql = "SELECT `p_escala_preg_categ`.`Id` , CONCAT(`p_escala_preg_categ`.`RangoMin`,' a ',`p_escala_preg_categ`.`RangoMax`)AS Rango, `p_escala_preg_categ`.`Orden`,`p_escala_preguntas`.`Nbre` AS pregunta   FROM `p_escala_preg_categ` INNER JOIN `p_escala_preguntas` ON (`p_escala_preg_categ`.`IdPregunta` = `p_escala_preguntas`.`Id`)  WHERE (`p_escala_preg_categ`.`IdCategoria` ='" + xCat + "'  AND `p_escala_preg_categ`.`Estado` =1) ORDER BY `p_escala_preg_categ`.`Orden` ASC";
        try {
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    xmodelo2.addRow(this.xdatos);
                    xmodelo2.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    xmodelo2.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    xmodelo2.setValueAt(xrs.getString(4), n, 3);
                    xmodelo2.setValueAt(false, n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPEscalaAbreviada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int y = 0;
            while (true) {
                if (y >= this.JTDetalleA.getRowCount()) {
                    break;
                }
                if (!Boolean.valueOf(this.JTDetalleA.getValueAt(y, 4).toString()).booleanValue()) {
                    y++;
                } else {
                    a = Integer.parseInt(this.JTDetalleA.getValueAt(y, 2).toString());
                    break;
                }
            }
            int y2 = 0;
            while (true) {
                if (y2 >= this.JTDetalleB.getRowCount()) {
                    break;
                }
                if (!Boolean.valueOf(this.JTDetalleB.getValueAt(y2, 4).toString()).booleanValue()) {
                    y2++;
                } else {
                    b = Integer.parseInt(this.JTDetalleB.getValueAt(y2, 2).toString());
                    break;
                }
            }
            int y3 = 0;
            while (true) {
                if (y3 >= this.JTDetalleC.getRowCount()) {
                    break;
                }
                if (!Boolean.valueOf(this.JTDetalleC.getValueAt(y3, 4).toString()).booleanValue()) {
                    y3++;
                } else {
                    c = Integer.parseInt(this.JTDetalleC.getValueAt(y3, 2).toString());
                    break;
                }
            }
            int y4 = 0;
            while (true) {
                if (y4 >= this.JTDetalleD.getRowCount()) {
                    break;
                }
                if (!Boolean.valueOf(this.JTDetalleD.getValueAt(y4, 4).toString()).booleanValue()) {
                    y4++;
                } else {
                    d = Integer.parseInt(this.JTDetalleD.getValueAt(y4, 2).toString());
                    break;
                }
            }
            String sql = "INSERT INTO  `p_escala_resultado_examen` ( `IdAtencion`, `IdUsuarioA`, `IdProfesional`, `IdEspecialidad`,  `FechaR`, `EdadM`, `A`,`B`, `C`, `D`, `Total`, Observacion,   `UsuarioS`)  VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + this.xmt.formatoAMDH24.format(this.JDFecha.getDate()) + "', '" + this.xedad + "',  '" + a + "', '" + b + "', '" + c + "', '" + d + "', '" + this.JLTotal.getText() + "',  '" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            mBuscaHistorico();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:PyP/JPEscalaAbreviada$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xtotal = Long.valueOf(table.getValueAt(row, 7).toString()).longValue();
            if (xtotal >= JPEscalaAbreviada.this.AI && xtotal <= JPEscalaAbreviada.this.AF) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            } else if (xtotal >= JPEscalaAbreviada.this.MI && xtotal <= JPEscalaAbreviada.this.MF) {
                cell.setBackground(Color.ORANGE);
                cell.setForeground(Color.BLACK);
            } else if (xtotal >= JPEscalaAbreviada.this.MAI && xtotal <= JPEscalaAbreviada.this.MAF) {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            } else if (xtotal >= JPEscalaAbreviada.this.ALT) {
                cell.setBackground(new Color(97, 185, 91));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloHistorico() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Edad (Meses)", "A (M.G.)", "B (M.F.A)", "C (A.L.)", "D (P.S.)", "TOTAL", "Profesional", "Especialidad"}) { // from class: PyP.JPEscalaAbreviada.8
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodeloH);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(28);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(8);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(8);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(150);
    }

    private void mBuscaHistorico() {
        mCreaModeloHistorico();
        String sql = "SELECT `p_escala_resultado_examen`.`Id` , DATE_FORMAT(`p_escala_resultado_examen`.`FechaR`,'%d-%m-%Y') AS FechaR, `p_escala_resultado_examen`.`EdadM`  , `p_escala_resultado_examen`.`A` , `p_escala_resultado_examen`.`B` , `p_escala_resultado_examen`.`C` , `p_escala_resultado_examen`.`D`  , `p_escala_resultado_examen`.`Total` , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`  FROM `p_escala_resultado_examen` INNER JOIN  `profesional1`   ON (`p_escala_resultado_examen`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`p_escala_resultado_examen`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)  WHERE (`p_escala_resultado_examen`.`IdUsuarioA` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND p_escala_resultado_examen.Estado=1)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloH.addRow(this.xdatos);
                    this.xmodeloH.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodeloH.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloH.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloH.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloH.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloH.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloH.setValueAt(xrs.getString(7), n, 6);
                    this.JTHistorico.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodeloH.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloH.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloH.setValueAt(xrs.getString(10), n, 9);
                    n++;
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPEscalaAbreviada.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
