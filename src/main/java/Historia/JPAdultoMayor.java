package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
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
import javax.swing.ButtonGroup;
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
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAdultoMayor.class */
public class JPAdultoMayor extends JPanel {
    private DefaultTableModel xmodeloFuncional;
    private DefaultTableModel xmodeloMental;
    private DefaultTableModel xModeloHF;
    private DefaultTableModel xModeloHM;
    private DefaultTableModel xmodeloAfectivo;
    private DefaultTableModel xmodeloFliar;
    private DefaultTableModel xmodeloEcon;
    private DefaultTableModel xmodeloVivie;
    private DefaultTableModel xmodeloRsociales;
    private DefaultTableModel xmodeloApoyo;
    private DefaultTableModel xmodeloHFliar;
    private DefaultTableModel xmodeloHAfectivo;
    private Object[] xdatos;
    private JComboBox[] xcomboBox1;
    private ButtonGroup JBGValoracion;
    private JButton JBGrabaSFliar;
    private JButton JBGrabar;
    private JButton JBGrabarEstAfectivo;
    private JButton JBGrabarMental;
    private JCheckBox JCHAnalfabeta;
    private JCheckBox JCHLeve;
    private JCheckBox JCHModerado;
    private JCheckBox JCHNormal;
    private JCheckBox JCHPIncompl;
    private JCheckBox JCHSevero;
    private JLabel JLCalEstAfec;
    private JLabel JLCalificacion;
    private JLabel JLDepP;
    private JLabel JLDepT;
    private JLabel JLInde;
    private JLabel JLRespEstAfec;
    private JLabel JLTotal;
    private JLabel JLTotalVal;
    private JTextArea JTAObservacion;
    private JTextArea JTAObservacionAfect;
    private JTextArea JTAObservacionMent;
    private JTable JTDetalle;
    private JTable JTEstadoAfectivo;
    private JTable JTHistoricoAfectivo;
    private JTable JTHistoricoFuncional;
    private JTable JTHistoricoMental;
    private JTable JTHistoricoSFliar;
    private JTabbedPane JTPFuncional;
    private JTabbedPane JTPGeneral;
    private JTabbedPane JTPMental;
    private JTable JTSApoyo;
    private JTable JTSEconomica;
    private JTable JTSFliar;
    private JTable JTSRSociales;
    private JTable JTSVivienda;
    private JTable JTValMental;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane10;
    private JScrollPane jScrollPane11;
    private JScrollPane jScrollPane12;
    private JScrollPane jScrollPane13;
    private JScrollPane jScrollPane14;
    private JScrollPane jScrollPane15;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;
    private JScrollPane jScrollPane9;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xValoracion = 0;
    private int xCont = 0;
    private int xContM = 0;
    private int xAnalf = 0;
    private int xPInc = 0;
    private int xContEst = 0;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private String xValorMental = "";
    private int xValorFliar = 0;
    private int x1 = 0;
    private int x2 = 0;
    private int x3 = 0;
    private int x4 = 0;
    private int x5 = 0;
    private int xValorEstAfec = 0;

    public JPAdultoMayor() {
        initComponents();
        xExisteEvaluacion();
        mBuscarFuncional();
        mllenaModeloMental();
        mBuscaHistoricoFunc();
        mBuscaHistoricoMent();
        mBuscarAfectiva();
        mBuscarFliar();
        mBuscarEconomico();
        mBuscarVivienda();
        mBuscarSocial();
        mBuscarApoyo();
        mBuscarHfliar();
        mBuscarHAfectivo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodeloFuncional = new DefaultTableModel(new Object[0], new String[]{"Id", "KATZ", "Dependiente", "Independiente"}) { // from class: Historia.JPAdultoMayor.1
            Class[] types = {Integer.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloFuncional);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setCellRenderer(new RadioButtonRenderer());
        this.JTDetalle.getColumnModel().getColumn(2).setCellEditor(new RadioButtonEditor(new JCheckBox(), "0"));
        this.JTDetalle.getColumnModel().getColumn(3).setCellRenderer(new RadioButtonRenderer());
        this.JTDetalle.getColumnModel().getColumn(3).setCellEditor(new RadioButtonEditor(new JCheckBox(), "1"));
    }

    private void mBuscarFuncional() {
        mCrearModeloDatos();
        ResultSet xrs = this.xct.traerRs("SELECT `Id` , `Nbre` FROM `h_am_val_funcional` WHERE (`Estado` =1) ORDER BY Nbre ASC;");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloFuncional.addRow(this.xdatos);
                    this.xmodeloFuncional.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloFuncional.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloFuncional.setValueAt(false, n, 2);
                    this.xmodeloFuncional.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v124, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v143, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v159, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v200, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v205, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v210, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v215, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v220, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v266, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v40, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v87, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGValoracion = new ButtonGroup();
        this.JTPGeneral = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JTPFuncional = new JTabbedPane();
        this.jPanel4 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBGrabar = new JButton();
        this.jLabel2 = new JLabel();
        this.JLInde = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JLDepP = new JLabel();
        this.JLDepT = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jPanel5 = new JPanel();
        this.jScrollPane5 = new JScrollPane();
        this.JTHistoricoFuncional = new JTable();
        this.jPanel2 = new JPanel();
        this.JTPMental = new JTabbedPane();
        this.jPanel6 = new JPanel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.jPanel3 = new JPanel();
        this.JCHNormal = new JCheckBox();
        this.JCHLeve = new JCheckBox();
        this.JCHModerado = new JCheckBox();
        this.JCHSevero = new JCheckBox();
        this.JLTotal = new JLabel();
        this.JCHAnalfabeta = new JCheckBox();
        this.JCHPIncompl = new JCheckBox();
        this.jScrollPane3 = new JScrollPane();
        this.JTValMental = new JTable();
        this.jScrollPane4 = new JScrollPane();
        this.JTAObservacionMent = new JTextArea();
        this.JBGrabarMental = new JButton();
        this.jPanel7 = new JPanel();
        this.jScrollPane6 = new JScrollPane();
        this.JTHistoricoMental = new JTable();
        this.jPanel8 = new JPanel();
        this.jScrollPane7 = new JScrollPane();
        this.JTEstadoAfectivo = new JTable();
        this.JLRespEstAfec = new JLabel();
        this.JLCalEstAfec = new JLabel();
        this.JBGrabarEstAfectivo = new JButton();
        this.jLabel1 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jScrollPane14 = new JScrollPane();
        this.JTHistoricoAfectivo = new JTable();
        this.jScrollPane15 = new JScrollPane();
        this.JTAObservacionAfect = new JTextArea();
        this.jPanel9 = new JPanel();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel10 = new JPanel();
        this.jScrollPane8 = new JScrollPane();
        this.JTSFliar = new JTable();
        this.jScrollPane9 = new JScrollPane();
        this.JTSEconomica = new JTable();
        this.jScrollPane10 = new JScrollPane();
        this.JTSVivienda = new JTable();
        this.jScrollPane11 = new JScrollPane();
        this.JTSRSociales = new JTable();
        this.jScrollPane12 = new JScrollPane();
        this.JTSApoyo = new JTable();
        this.JBGrabaSFliar = new JButton();
        this.JLTotalVal = new JLabel();
        this.JLCalificacion = new JLabel();
        this.jPanel11 = new JPanel();
        this.jScrollPane13 = new JScrollPane();
        this.JTHistoricoSFliar = new JTable();
        setName("Evaluación Riesgo Psicosocial");
        this.JTPGeneral.setForeground(new Color(0, 102, 0));
        this.JTPGeneral.setFont(new Font("Arial", 1, 14));
        this.JTPGeneral.setName("Evaluación Riesgo Psicosocial");
        this.JTPFuncional.setForeground(Color.red);
        this.JTPFuncional.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividades Básicas de la Vida Diaria (ABVD)", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.2
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Historia.JPAdultoMayor.3
            public void actionPerformed(ActionEvent evt) {
                JPAdultoMayor.this.JBGrabarActionPerformed(evt);
            }
        });
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("DIAGNÓSTICO FUNCIONAL");
        this.JLInde.setFont(new Font("Arial", 1, 12));
        this.JLInde.setText("(1) INDEPENDIENTE");
        this.JLInde.setOpaque(true);
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAObservacion);
        this.JLDepP.setFont(new Font("Arial", 1, 12));
        this.JLDepP.setText("(2) DEPENDIENTE PARCIAL");
        this.JLDepP.setOpaque(true);
        this.JLDepT.setFont(new Font("Arial", 1, 12));
        this.JLDepT.setText("(3) DEPENDIENTE TOTAL");
        this.JLDepT.setOpaque(true);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("(1) Ningún item positivo de dependencia");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("(2) De 1 a 5 items positivos de dependencia");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("(3) 6 items positivos de dependencia");
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGrabar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5)).addGap(0, 0, 32767)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLDepP).addComponent(this.JLInde).addComponent(this.JLDepT)).addGap(18, 18, 18).addComponent(this.jScrollPane2)))));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane1, -2, 229, -2).addGap(10, 10, 10).addComponent(this.JBGrabar, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -2, 171, -2).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.JLInde)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLDepP).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLDepT).addGap(20, 20, 20).addComponent(this.jLabel3).addGap(10, 10, 10).addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel5))).addContainerGap()));
        this.JTPFuncional.addTab("VALORACIÓN CLÍNICA ADULTO MAYOR - VACAM", this.jPanel4);
        this.jScrollPane5.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTHistoricoFuncional.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoFuncional.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoFuncional.setSelectionBackground(Color.white);
        this.JTHistoricoFuncional.setSelectionForeground(Color.red);
        this.JTHistoricoFuncional.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.4
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTHistoricoFuncionalMouseClicked(evt);
            }
        });
        this.jScrollPane5.setViewportView(this.JTHistoricoFuncional);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane5).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jScrollPane5, -1, 454, 32767).addContainerGap()));
        this.JTPFuncional.addTab("HISTÓRICO", this.jPanel5);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTPFuncional).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTPFuncional, -2, 494, -2).addContainerGap(-1, 32767)));
        this.JTPGeneral.addTab("VALORACIÓN FUNCIONAL", this.jPanel1);
        this.JTPMental.setForeground(Color.red);
        this.JTPMental.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("<html><p alingn=\"justify\">El cuestionario abreviado de Pfeiffer consta de 10 preguntas, y se debe marcar con “1” punto por cada pregunta errada (E), y “0” por cada pregunta totalmente acertada. Se suman el número total de preguntas erradas, y luego realizamos la valoración cognitiva de la siguiente manera:</p>");
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("- No Deterioro Cognitivo : ≤ 2 E");
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("- Deterioro Cognitivo Leve : 3 a 4 E");
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("- Deterioro Cognitivo Moderado : 5 a 7 E");
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("- Deterioro Cognitivo Severo : 8 a 10 E");
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "VALORACION COGNITIVA", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JBGValoracion.add(this.JCHNormal);
        this.JCHNormal.setFont(new Font("Arial", 1, 12));
        this.JCHNormal.setText("NORMAL");
        this.JCHNormal.setEnabled(false);
        this.JBGValoracion.add(this.JCHLeve);
        this.JCHLeve.setFont(new Font("Arial", 1, 12));
        this.JCHLeve.setText("DC LEVE");
        this.JCHLeve.setEnabled(false);
        this.JBGValoracion.add(this.JCHModerado);
        this.JCHModerado.setFont(new Font("Arial", 1, 12));
        this.JCHModerado.setText("DC MODERADO");
        this.JCHModerado.setEnabled(false);
        this.JBGValoracion.add(this.JCHSevero);
        this.JCHSevero.setFont(new Font("Arial", 1, 12));
        this.JCHSevero.setText("DC SEVERO");
        this.JCHSevero.setEnabled(false);
        this.JLTotal.setFont(new Font("Arial", 1, 14));
        this.JLTotal.setForeground(Color.red);
        this.JLTotal.setHorizontalAlignment(0);
        this.JLTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Puntaje", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAnalfabeta.setFont(new Font("Arial", 1, 12));
        this.JCHAnalfabeta.setText("Analfabeta");
        this.JCHAnalfabeta.addActionListener(new ActionListener() { // from class: Historia.JPAdultoMayor.5
            public void actionPerformed(ActionEvent evt) {
                JPAdultoMayor.this.JCHAnalfabetaActionPerformed(evt);
            }
        });
        this.JCHPIncompl.setFont(new Font("Arial", 1, 12));
        this.JCHPIncompl.setText("Primaria Incompleta");
        this.JCHPIncompl.addActionListener(new ActionListener() { // from class: Historia.JPAdultoMayor.6
            public void actionPerformed(ActionEvent evt) {
                JPAdultoMayor.this.JCHPIncomplActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHNormal).addComponent(this.JCHLeve)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLTotal, -2, 129, -2)).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHModerado).addComponent(this.JCHSevero)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 21, 32767).addComponent(this.JCHPIncompl).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHAnalfabeta))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JCHNormal).addGap(0, 0, 0).addComponent(this.JCHLeve)).addComponent(this.JLTotal, -2, 46, -2)).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.JCHModerado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addComponent(this.JCHSevero)).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAnalfabeta).addComponent(this.JCHPIncompl)).addContainerGap()))));
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTValMental.setFont(new Font("Arial", 1, 12));
        this.JTValMental.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTValMental.setSelectionBackground(new Color(255, 255, 255));
        this.JTValMental.setSelectionForeground(Color.red);
        this.JTValMental.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.7
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTValMentalMouseClicked(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTValMental);
        this.JTAObservacionMent.setColumns(1);
        this.JTAObservacionMent.setFont(new Font("Arial", 0, 12));
        this.JTAObservacionMent.setLineWrap(true);
        this.JTAObservacionMent.setRows(1);
        this.JTAObservacionMent.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane4.setViewportView(this.JTAObservacionMent);
        this.JBGrabarMental.setFont(new Font("Arial", 1, 12));
        this.JBGrabarMental.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarMental.setText("Grabar");
        this.JBGrabarMental.addActionListener(new ActionListener() { // from class: Historia.JPAdultoMayor.8
            public void actionPerformed(ActionEvent evt) {
                JPAdultoMayor.this.JBGrabarMentalActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane3).addComponent(this.jLabel8, GroupLayout.Alignment.LEADING, -2, 0, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel9, GroupLayout.Alignment.LEADING, -2, 177, -2).addComponent(this.jLabel11, GroupLayout.Alignment.LEADING, -2, 233, -2).addComponent(this.jLabel12, GroupLayout.Alignment.LEADING, -2, 233, -2).addComponent(this.jLabel10, GroupLayout.Alignment.LEADING, -2, 233, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel3, -2, -1, -2)).addComponent(this.JBGrabarMental, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane4, GroupLayout.Alignment.LEADING)).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jLabel8, -2, 57, -2).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel3, -2, -1, -2)).addGroup(jPanel6Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel11).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel12))).addGap(3, 3, 3).addComponent(this.jScrollPane3, -2, 197, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 70, -2).addGap(3, 3, 3).addComponent(this.JBGrabarMental, -2, 30, -2).addContainerGap(-1, 32767)));
        this.JTPMental.addTab("ESTADO COGNITIVO (Pfeiffer)", this.jPanel6);
        this.jScrollPane6.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTHistoricoMental.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoMental.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoMental.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoMental.setSelectionForeground(Color.red);
        this.JTHistoricoMental.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.9
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTHistoricoMentalMouseClicked(evt);
            }
        });
        this.jScrollPane6.setViewportView(this.JTHistoricoMental);
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane6).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane6, -1, 591, 32767).addContainerGap()));
        this.JTPMental.addTab("HISTÓRICO", this.jPanel7);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTPMental).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTPMental).addContainerGap()));
        this.JTPGeneral.addTab("VALORACIÓN MENTAL", this.jPanel2);
        this.jScrollPane7.setBorder(BorderFactory.createTitledBorder((Border) null, "Escala abreviada de Yesavage", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTEstadoAfectivo.setFont(new Font("Arial", 1, 12));
        this.JTEstadoAfectivo.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTEstadoAfectivo.setSelectionBackground(Color.white);
        this.JTEstadoAfectivo.setSelectionForeground(Color.red);
        this.JTEstadoAfectivo.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.10
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTEstadoAfectivoMouseClicked(evt);
            }
        });
        this.jScrollPane7.setViewportView(this.JTEstadoAfectivo);
        this.JLRespEstAfec.setFont(new Font("Arial", 1, 14));
        this.JLRespEstAfec.setForeground(Color.red);
        this.JLRespEstAfec.setHorizontalAlignment(0);
        this.JLRespEstAfec.setBorder(BorderFactory.createTitledBorder((Border) null, "Respuestas Coincidentes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLCalEstAfec.setFont(new Font("Arial", 1, 14));
        this.JLCalEstAfec.setForeground(Color.red);
        this.JLCalEstAfec.setHorizontalAlignment(0);
        this.JLCalEstAfec.setBorder(BorderFactory.createTitledBorder((Border) null, "Valoración", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGrabarEstAfectivo.setFont(new Font("Arial", 1, 12));
        this.JBGrabarEstAfectivo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabarEstAfectivo.setText("Grabar");
        this.JBGrabarEstAfectivo.addActionListener(new ActionListener() { // from class: Historia.JPAdultoMayor.11
            public void actionPerformed(ActionEvent evt) {
                JPAdultoMayor.this.JBGrabarEstAfectivoActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("<html><p align=\"justify\">Escala Abreviada de Yesavage.- Esta escala determina si la persona adulta mayor presenta o no manifestaciones depresivas. La valoración del estado afectivo se determinará marcando con una “X” si la respuesta de la escala coincide con la del entrevistado. No se marcará sí la respuesta no es coincidente. Se cuentan las “X” coincidentes y determinamos la valoración afectiva de la siguiente manera:</p></html>");
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("<html><p align=\"justify\">0 a 1 “X” : Sin manifestaciones depresivas<br>2 a más “X” : Con manifestaciones depresivas</p></html>");
        this.jScrollPane14.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTHistoricoAfectivo.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoAfectivo.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoAfectivo.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoAfectivo.setSelectionForeground(Color.red);
        this.JTHistoricoAfectivo.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.12
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTHistoricoAfectivoMouseClicked(evt);
            }
        });
        this.jScrollPane14.setViewportView(this.JTHistoricoAfectivo);
        this.JTAObservacionAfect.setColumns(1);
        this.JTAObservacionAfect.setFont(new Font("Arial", 0, 12));
        this.JTAObservacionAfect.setLineWrap(true);
        this.JTAObservacionAfect.setRows(1);
        this.JTAObservacionAfect.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane15.setViewportView(this.JTAObservacionAfect);
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane7, -1, 783, 32767).addComponent(this.JBGrabarEstAfectivo, -1, -1, 32767).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.JLRespEstAfec, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCalEstAfec, -2, 472, -2).addGap(0, 0, 32767)).addComponent(this.jLabel1, -2, 0, 32767).addComponent(this.jLabel6, -2, 0, 32767).addComponent(this.jScrollPane14).addComponent(this.jScrollPane15)).addContainerGap()));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jScrollPane7, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel6, -2, -1, -2).addGap(5, 5, 5).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLRespEstAfec, -2, 43, -2).addComponent(this.JLCalEstAfec, -2, 43, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane15, -1, 71, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabarEstAfectivo, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane14, -2, 222, -2).addContainerGap()));
        this.JTPGeneral.addTab("ESTADO AFECTIVO", this.jPanel8);
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jScrollPane8.setBorder(BorderFactory.createTitledBorder((Border) null, "1. SITUACIÓN FAMILIAR", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTSFliar.setFont(new Font("Arial", 1, 12));
        this.JTSFliar.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSFliar.setSelectionBackground(Color.white);
        this.JTSFliar.setSelectionForeground(Color.red);
        this.JTSFliar.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.13
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTSFliarMouseClicked(evt);
            }
        });
        this.jScrollPane8.setViewportView(this.JTSFliar);
        this.jScrollPane9.setBorder(BorderFactory.createTitledBorder((Border) null, "2. SITUACIÓN ECONÓMICA", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTSEconomica.setFont(new Font("Arial", 1, 12));
        this.JTSEconomica.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSEconomica.setSelectionBackground(Color.white);
        this.JTSEconomica.setSelectionForeground(Color.red);
        this.JTSEconomica.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.14
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTSEconomicaMouseClicked(evt);
            }
        });
        this.jScrollPane9.setViewportView(this.JTSEconomica);
        this.jScrollPane10.setBorder(BorderFactory.createTitledBorder((Border) null, "3. VIVIENDA", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTSVivienda.setFont(new Font("Arial", 1, 12));
        this.JTSVivienda.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSVivienda.setSelectionBackground(Color.white);
        this.JTSVivienda.setSelectionForeground(Color.red);
        this.JTSVivienda.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.15
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTSViviendaMouseClicked(evt);
            }
        });
        this.jScrollPane10.setViewportView(this.JTSVivienda);
        this.jScrollPane11.setBorder(BorderFactory.createTitledBorder((Border) null, "4. RELACIONES SOCIALES", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTSRSociales.setFont(new Font("Arial", 1, 12));
        this.JTSRSociales.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSRSociales.setSelectionBackground(Color.white);
        this.JTSRSociales.setSelectionForeground(Color.red);
        this.JTSRSociales.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.16
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTSRSocialesMouseClicked(evt);
            }
        });
        this.jScrollPane11.setViewportView(this.JTSRSociales);
        this.jScrollPane12.setBorder(BorderFactory.createTitledBorder((Border) null, "5. APOYO DE LA RED SOCIAL (MUNICIPIO, CLUBES, ONG, SEGURO SOCIAL, VIVIENDA)", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTSApoyo.setFont(new Font("Arial", 1, 12));
        this.JTSApoyo.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTSApoyo.setSelectionBackground(Color.white);
        this.JTSApoyo.setSelectionForeground(Color.red);
        this.JTSApoyo.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.17
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTSApoyoMouseClicked(evt);
            }
        });
        this.jScrollPane12.setViewportView(this.JTSApoyo);
        this.JBGrabaSFliar.setFont(new Font("Arial", 1, 12));
        this.JBGrabaSFliar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabaSFliar.setText("Grabar");
        this.JBGrabaSFliar.addActionListener(new ActionListener() { // from class: Historia.JPAdultoMayor.18
            public void actionPerformed(ActionEvent evt) {
                JPAdultoMayor.this.JBGrabaSFliarActionPerformed(evt);
            }
        });
        this.JLTotalVal.setFont(new Font("Arial", 1, 12));
        this.JLTotalVal.setForeground(Color.red);
        this.JLTotalVal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Punt.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JLCalificacion.setFont(new Font("Arial", 1, 14));
        this.JLCalificacion.setForeground(Color.red);
        this.JLCalificacion.setHorizontalAlignment(0);
        this.JLCalificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(1, 1, 1).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane12, -1, 787, 32767).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane10, -1, 398, 32767).addComponent(this.jScrollPane8, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane11, -2, 0, 32767).addComponent(this.jScrollPane9, -2, 0, 32767))))).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.JBGrabaSFliar, -2, 251, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLTotalVal, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCalificacion, -1, -1, 32767)));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jScrollPane8, -2, 174, -2)).addComponent(this.jScrollPane9, -2, 174, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane10, -2, 174, -2).addComponent(this.jScrollPane11, -2, 174, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane12, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBGrabaSFliar, -1, 43, 32767).addComponent(this.JLTotalVal, -1, -1, 32767).addComponent(this.JLCalificacion, -1, -1, 32767)).addGap(10, 10, 10)));
        this.jTabbedPane1.addTab("VALORACIÓN", this.jPanel10);
        this.jScrollPane13.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTHistoricoSFliar.setFont(new Font("Arial", 1, 12));
        this.JTHistoricoSFliar.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistoricoSFliar.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistoricoSFliar.setSelectionForeground(Color.red);
        this.JTHistoricoSFliar.addMouseListener(new MouseAdapter() { // from class: Historia.JPAdultoMayor.19
            public void mouseClicked(MouseEvent evt) {
                JPAdultoMayor.this.JTHistoricoSFliarMouseClicked(evt);
            }
        });
        this.jScrollPane13.setViewportView(this.JTHistoricoSFliar);
        GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
        this.jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane13).addContainerGap()));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane13, -2, 514, -2).addGap(75, 75, 75)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.jPanel11);
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.jTabbedPane1, -2, 623, -2).addGap(3, 3, 3)));
        this.JTPGeneral.addTab("VALORACIÓN SOCIO-FAMILIAR", this.jPanel9);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGeneral));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPGeneral));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedColumn() == 2) {
            this.xmodeloFuncional.setValueAt(false, this.JTDetalle.getSelectedRow(), 3);
            this.xmodeloFuncional.setValueAt(true, this.JTDetalle.getSelectedRow(), 2);
            mContar();
            mValoracion();
            return;
        }
        if (this.JTDetalle.getSelectedColumn() == 3) {
            this.xmodeloFuncional.setValueAt(true, this.JTDetalle.getSelectedRow(), 3);
            this.xmodeloFuncional.setValueAt(false, this.JTDetalle.getSelectedRow(), 2);
            mContar();
            mValoracion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        if (this.xValoracion != 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "INSERT INTO  `h_am_val_funcional_h` ( `FechaR`, `IdAtencion`, `Valoracion`, `IdProfesional`, `IdEspecialista`, `Observacion`, `UsuarioS`)\n VALUES ( '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + this.xValoracion + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + this.JTAObservacion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String xVal = this.xct.ejecutarSQLId(sql);
                this.xct.cerrarConexionBd();
                this.JBGrabar.setEnabled(false);
                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                    if (Boolean.valueOf(this.xmodeloFuncional.getValueAt(i, 2).toString()).booleanValue()) {
                        String sql2 = "INSERT INTO  `h_am_val_funcional_h_detalle` (`IdValoracion`, `IdItem`, `Dependencia`, `UsuarioS`)\nVALUES ('" + xVal + "', '" + this.xmodeloFuncional.getValueAt(i, 0) + "', '0', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                    } else {
                        String sql22 = "INSERT INTO  `h_am_val_funcional_h_detalle` (`IdValoracion`, `IdItem`, `Dependencia`, `UsuarioS`)\nVALUES ('" + xVal + "', '" + this.xmodeloFuncional.getValueAt(i, 0) + "', '1', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql22);
                        this.xct.cerrarConexionBd();
                    }
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe realizar la Valoración", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarMentalActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "insert into  `h_am_val_mental_h` ( `FechaR`, `IdAtencion`, `IdProfesional`, `IdEspecialidad`, `Puntaje`, `Valoracion`, `PrimIncom`,\n             `Analfabeta`, `Observacion`, `UsuarioS`)\n values ( '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + this.JLTotal.getText() + "',\n        '" + this.xValorMental + "', '" + this.xPInc + "', '" + this.xAnalf + "', '" + this.JTAObservacionMent.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
            String xValoracionMental = this.xct.ejecutarSQLId(sql);
            this.xct.cerrarConexionBd();
            for (int i = 0; i < this.JTValMental.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodeloMental.getValueAt(i, 2).toString()).booleanValue()) {
                    String sql2 = "INSERT INTO  `h_am_val_mental_h_detalle` (`IdPregunta`, `IdValoracion`, `Respuesta`, `UsuarioS`)\n VALUES ('" + this.xmodeloMental.getValueAt(i, 0) + "', '" + xValoracionMental + "',  '1',  '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xct.ejecutarSQL(sql2);
                    this.xct.cerrarConexionBd();
                } else {
                    String sql22 = "INSERT INTO  `h_am_val_mental_h_detalle` (`IdPregunta`, `IdValoracion`, `Respuesta`, `UsuarioS`)\n VALUES ('" + this.xmodeloMental.getValueAt(i, 0) + "', '" + xValoracionMental + "',  '0',  '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.xct.ejecutarSQL(sql22);
                    this.xct.cerrarConexionBd();
                }
            }
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            this.JBGrabarMental.setEnabled(false);
            mBuscaHistoricoMent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTValMentalMouseClicked(MouseEvent evt) {
        if (this.JTValMental.getSelectedColumn() == 2) {
            this.xmodeloMental.setValueAt(false, this.JTValMental.getSelectedRow(), 3);
            this.xmodeloMental.setValueAt(true, this.JTValMental.getSelectedRow(), 2);
            mContarMental();
        } else if (this.JTValMental.getSelectedColumn() == 3) {
            this.xmodeloMental.setValueAt(true, this.JTValMental.getSelectedRow(), 3);
            this.xmodeloMental.setValueAt(false, this.JTValMental.getSelectedRow(), 2);
            mContarMental();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPIncomplActionPerformed(ActionEvent evt) {
        if (this.JCHPIncompl.isSelected()) {
            this.xPInc = 1;
        } else {
            this.xPInc = 0;
        }
        mContarMental();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAnalfabetaActionPerformed(ActionEvent evt) {
        if (this.JCHAnalfabeta.isSelected()) {
            this.xAnalf = 1;
        } else {
            this.xAnalf = 0;
        }
        mContarMental();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoFuncionalMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMentalMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTEstadoAfectivoMouseClicked(MouseEvent evt) {
        if (this.JTEstadoAfectivo.getSelectedColumn() == 3) {
            this.xmodeloAfectivo.setValueAt(false, this.JTEstadoAfectivo.getSelectedRow(), 4);
            this.xmodeloAfectivo.setValueAt(true, this.JTEstadoAfectivo.getSelectedRow(), 3);
            mCuentaEstadoMental();
        } else if (this.JTEstadoAfectivo.getSelectedColumn() == 4) {
            this.xmodeloAfectivo.setValueAt(true, this.JTEstadoAfectivo.getSelectedRow(), 4);
            this.xmodeloAfectivo.setValueAt(false, this.JTEstadoAfectivo.getSelectedRow(), 3);
            mCuentaEstadoMental();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSFliarMouseClicked(MouseEvent evt) {
        if (this.JTSFliar.getSelectedRow() > -1 && this.JTSFliar.getSelectedColumn() == 3) {
            this.x1 = Integer.parseInt(this.xmodeloFliar.getValueAt(this.JTSFliar.getSelectedRow(), 2).toString());
            mValorFliar(this.x1, this.x2, this.x3, this.x4, this.x5);
            for (int i = 0; i < this.JTSFliar.getRowCount(); i++) {
                if (i != this.JTSFliar.getSelectedRow()) {
                    this.xmodeloFliar.setValueAt(false, i, 3);
                } else {
                    this.xmodeloFliar.setValueAt(true, i, 3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSEconomicaMouseClicked(MouseEvent evt) {
        if (this.JTSEconomica.getSelectedRow() > -1 && this.JTSEconomica.getSelectedColumn() == 3) {
            this.x2 = Integer.parseInt(this.xmodeloEcon.getValueAt(this.JTSEconomica.getSelectedRow(), 2).toString());
            mValorFliar(this.x1, this.x2, this.x3, this.x4, this.x5);
            for (int i = 0; i < this.JTSEconomica.getRowCount(); i++) {
                if (i != this.JTSEconomica.getSelectedRow()) {
                    this.xmodeloEcon.setValueAt(false, i, 3);
                } else {
                    this.xmodeloEcon.setValueAt(true, i, 3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSViviendaMouseClicked(MouseEvent evt) {
        if (this.JTSVivienda.getSelectedRow() > -1 && this.JTSVivienda.getSelectedColumn() == 3) {
            this.x3 = Integer.parseInt(this.xmodeloVivie.getValueAt(this.JTSVivienda.getSelectedRow(), 2).toString());
            mValorFliar(this.x1, this.x2, this.x3, this.x4, this.x5);
            for (int i = 0; i < this.JTSVivienda.getRowCount(); i++) {
                if (i != this.JTSVivienda.getSelectedRow()) {
                    this.xmodeloVivie.setValueAt(false, i, 3);
                } else {
                    this.xmodeloVivie.setValueAt(true, i, 3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSRSocialesMouseClicked(MouseEvent evt) {
        if (this.JTSRSociales.getSelectedRow() > -1 && this.JTSRSociales.getSelectedColumn() == 3) {
            this.x4 = Integer.parseInt(this.xmodeloRsociales.getValueAt(this.JTSRSociales.getSelectedRow(), 2).toString());
            mValorFliar(this.x1, this.x2, this.x3, this.x4, this.x5);
            for (int i = 0; i < this.JTSRSociales.getRowCount(); i++) {
                if (i != this.JTSRSociales.getSelectedRow()) {
                    this.xmodeloRsociales.setValueAt(false, i, 3);
                } else {
                    this.xmodeloRsociales.setValueAt(true, i, 3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTSApoyoMouseClicked(MouseEvent evt) {
        if (this.JTSApoyo.getSelectedRow() > -1 && this.JTSApoyo.getSelectedColumn() == 3) {
            this.x5 = Integer.parseInt(this.xmodeloApoyo.getValueAt(this.JTSApoyo.getSelectedRow(), 2).toString());
            mValorFliar(this.x1, this.x2, this.x3, this.x4, this.x5);
            for (int i = 0; i < this.JTSApoyo.getRowCount(); i++) {
                if (i != this.JTSApoyo.getSelectedRow()) {
                    this.xmodeloApoyo.setValueAt(false, i, 3);
                } else {
                    this.xmodeloApoyo.setValueAt(true, i, 3);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabaSFliarActionPerformed(ActionEvent evt) {
        if (this.x1 > 0 && this.x2 > 0 && this.x3 > 0 && this.x4 > 0 && this.x5 > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "INSERT INTO  `h_am_sfamiliar_h` (`IdAtencion`,`FechaR`,`IdUsuario`,`IdProfesional`,`IdEspecialidad`,`IdFliar`,`IdEconomica`,`IdVivienda`,`IdSociales`,\n             `IdApoyo`,`TValoracion`,`Calificacion`, `UsuarioS`)\n VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmodeloFliar.getValueAt(this.JTSFliar.getSelectedRow(), 0) + "','" + this.xmodeloEcon.getValueAt(this.JTSEconomica.getSelectedRow(), 0) + "','" + this.xmodeloVivie.getValueAt(this.JTSVivienda.getSelectedRow(), 0) + "','" + this.xmodeloRsociales.getValueAt(this.JTSRSociales.getSelectedRow(), 0) + "','" + this.xmodeloApoyo.getValueAt(this.JTSApoyo.getSelectedRow(), 0) + "',\n        '" + this.JLTotalVal.getText() + "','" + this.JLCalificacion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                this.JBGrabaSFliar.setEnabled(false);
                mBuscarHfliar();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe completar la evaluación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoSFliarMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarEstAfectivoActionPerformed(ActionEvent evt) {
        if (!this.JLRespEstAfec.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "INSERT INTO  `h_am_estado_afectivo_h` ( `IdAtencion`, `IdProfesional`, `IdEspecialidad`, `IdUsuario`, `FechaR`,  `NRespuestas`, `Valoracion`,Observacion, `UsuarioS`)  VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', '" + this.JLRespEstAfec.getText() + "', '" + this.JLCalEstAfec.getText() + "','" + this.JTAObservacionAfect.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "') ";
                String xEval = this.xct.ejecutarSQLId(sql);
                this.xct.cerrarConexionBd();
                for (int i = 0; i < this.JTEstadoAfectivo.getRowCount(); i++) {
                    if (Boolean.valueOf(this.xmodeloAfectivo.getValueAt(i, 3).toString()).booleanValue()) {
                        String sql2 = " INSERT INTO `h_am_estado_afectivo_h_detalle` (`IdEst`,  `IdPregunta`, `Respuesta`, `UsuarioS`)  VALUES ('" + xEval + "', '" + this.xmodeloAfectivo.getValueAt(i, 0) + "', '" + this.JTEstadoAfectivo.getColumnName(3) + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                    } else if (Boolean.valueOf(this.xmodeloAfectivo.getValueAt(i, 4).toString()).booleanValue()) {
                        String sql22 = " INSERT INTO `h_am_estado_afectivo_h_detalle` (`IdEst`,  `IdPregunta`, `Respuesta`, `UsuarioS`)  VALUES ('" + xEval + "', '" + this.xmodeloAfectivo.getValueAt(i, 0) + "', '" + this.JTEstadoAfectivo.getColumnName(4) + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(sql22);
                        this.xct.cerrarConexionBd();
                    }
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                this.JBGrabarEstAfectivo.setEnabled(false);
                mBuscarHAfectivo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe completar la evaluación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoAfectivoMouseClicked(MouseEvent evt) {
    }

    private void xExisteEvaluacion() {
        String sql = "SELECT  `Valoracion`  FROM  `h_am_val_funcional_h` WHERE (`IdAtencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'  AND `Estado`=1)";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JBGrabar.setEnabled(false);
                if (xrs.getInt(1) <= 0) {
                    this.JLInde.setForeground(Color.WHITE);
                    this.JLInde.setBackground(Color.RED);
                    this.JLDepP.setForeground(Color.black);
                    this.JLDepP.setBackground(new Color(240, 240, 240));
                    this.JLDepT.setForeground(Color.black);
                    this.JLDepT.setBackground(new Color(240, 240, 240));
                } else if (xrs.getInt(1) >= 1 && xrs.getInt(1) <= 5) {
                    this.JLInde.setForeground(Color.black);
                    this.JLInde.setBackground(new Color(240, 240, 240));
                    this.JLDepP.setForeground(Color.WHITE);
                    this.JLDepP.setBackground(Color.RED);
                    this.JLDepT.setForeground(Color.black);
                    this.JLDepT.setBackground(new Color(240, 240, 240));
                } else if (xrs.getInt(1) == 6) {
                    this.JLInde.setForeground(Color.black);
                    this.JLInde.setBackground(new Color(240, 240, 240));
                    this.JLDepP.setForeground(Color.black);
                    this.JLDepP.setBackground(new Color(240, 240, 240));
                    this.JLDepT.setForeground(Color.WHITE);
                    this.JLDepT.setBackground(Color.RED);
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            String sql2 = "SELECT `Id`,`Puntaje`,  `Observacion` FROM  `h_am_val_mental_h` WHERE `IdAtencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado=1;";
            ResultSet xrs2 = this.xct.traerRs(sql2);
            if (xrs2.next()) {
                xrs2.first();
                this.JBGrabarMental.setEnabled(false);
                this.JTAObservacionMent.setText(xrs2.getString("Observacion"));
                this.JLTotal.setText(xrs2.getString("Puntaje"));
                mValoracionMental(xrs2.getInt("Puntaje"));
            }
            String sql3 = "SELECT `Id`,`TValoracion`, Calificacion FROM  `h_am_sfamiliar_h` WHERE `IdAtencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado=1;";
            ResultSet xrs3 = this.xct.traerRs(sql3);
            if (xrs3.next()) {
                xrs3.first();
                this.JBGrabaSFliar.setEnabled(false);
                this.JLTotalVal.setText(xrs3.getString("TValoracion"));
                this.JLCalificacion.setText(xrs3.getString("Calificacion"));
            }
            String sql4 = "SELECT `Id`,`NRespuestas`, Valoracion FROM  `h_am_estado_afectivo_h` WHERE `IdAtencion`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado=1;";
            ResultSet xrs4 = this.xct.traerRs(sql4);
            if (xrs4.next()) {
                xrs4.first();
                this.JBGrabarEstAfectivo.setEnabled(false);
                this.JLRespEstAfec.setText(xrs4.getString("NRespuestas"));
                this.JLCalEstAfec.setText(xrs4.getString("Valoracion"));
            }
            xrs.close();
            xrs2.close();
            xrs3.close();
            xrs4.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValoracion() {
        if (this.xCont <= 0) {
            this.JLInde.setForeground(Color.WHITE);
            this.JLInde.setBackground(Color.RED);
            this.JLDepP.setForeground(Color.black);
            this.JLDepP.setBackground(new Color(240, 240, 240));
            this.JLDepT.setForeground(Color.black);
            this.JLDepT.setBackground(new Color(240, 240, 240));
            this.xValoracion = 1;
            return;
        }
        if (this.xCont >= 1 && this.xCont <= 5) {
            this.JLInde.setForeground(Color.black);
            this.JLInde.setBackground(new Color(240, 240, 240));
            this.JLDepP.setForeground(Color.WHITE);
            this.JLDepP.setBackground(Color.RED);
            this.JLDepT.setForeground(Color.black);
            this.JLDepT.setBackground(new Color(240, 240, 240));
            this.xValoracion = 2;
            return;
        }
        if (this.xCont == 6) {
            this.JLInde.setForeground(Color.black);
            this.JLInde.setBackground(new Color(240, 240, 240));
            this.JLDepP.setForeground(Color.black);
            this.JLDepP.setBackground(new Color(240, 240, 240));
            this.JLDepT.setForeground(Color.WHITE);
            this.JLDepT.setBackground(Color.RED);
            this.xValoracion = 3;
        }
    }

    private int mContar() {
        this.xCont = 0;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodeloFuncional.getValueAt(i, 2).toString()).booleanValue()) {
                this.xCont++;
            }
        }
        return this.xCont;
    }

    private int mContarMental() {
        this.xContM = 0;
        for (int i = 0; i < this.JTValMental.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodeloMental.getValueAt(i, 2).toString()).booleanValue()) {
                this.xContM++;
            }
        }
        int suma = (this.xContM - this.xAnalf) - this.xPInc;
        this.JLTotal.setText("" + suma);
        mValoracionMental(Integer.parseInt(this.JLTotal.getText()));
        return (this.xContM - this.xAnalf) - this.xPInc;
    }

    private void mValoracionMental(int x) {
        if (x <= 2) {
            this.JCHNormal.setSelected(true);
            this.JCHNormal.setBackground(Color.red);
            this.JCHNormal.setForeground(Color.WHITE);
            this.xValorMental = this.JCHNormal.getText();
            this.JCHLeve.setForeground(Color.black);
            this.JCHLeve.setBackground(new Color(240, 240, 240));
            this.JCHModerado.setForeground(Color.black);
            this.JCHModerado.setBackground(new Color(240, 240, 240));
            this.JCHSevero.setForeground(Color.black);
            this.JCHSevero.setBackground(new Color(240, 240, 240));
            return;
        }
        if (x >= 3 && x <= 4) {
            this.JCHLeve.setSelected(true);
            this.JCHLeve.setBackground(Color.red);
            this.JCHLeve.setForeground(Color.WHITE);
            this.xValorMental = this.JCHLeve.getText();
            this.JCHNormal.setForeground(Color.black);
            this.JCHNormal.setBackground(new Color(240, 240, 240));
            this.JCHModerado.setForeground(Color.black);
            this.JCHModerado.setBackground(new Color(240, 240, 240));
            this.JCHSevero.setForeground(Color.black);
            this.JCHSevero.setBackground(new Color(240, 240, 240));
            return;
        }
        if (x >= 5 && x <= 7) {
            this.JCHModerado.setSelected(true);
            this.JCHModerado.setBackground(Color.red);
            this.JCHModerado.setForeground(Color.WHITE);
            this.xValorMental = this.JCHModerado.getText();
            this.JCHNormal.setForeground(Color.black);
            this.JCHNormal.setBackground(new Color(240, 240, 240));
            this.JCHLeve.setForeground(Color.black);
            this.JCHLeve.setBackground(new Color(240, 240, 240));
            this.JCHSevero.setForeground(Color.black);
            this.JCHSevero.setBackground(new Color(240, 240, 240));
            return;
        }
        if (x >= 8 && x <= 10) {
            this.JCHSevero.setSelected(true);
            this.JCHSevero.setBackground(Color.red);
            this.JCHSevero.setForeground(Color.WHITE);
            this.xValorMental = this.JCHSevero.getText();
            this.JCHNormal.setForeground(Color.black);
            this.JCHNormal.setBackground(new Color(240, 240, 240));
            this.JCHLeve.setForeground(Color.black);
            this.JCHLeve.setBackground(new Color(240, 240, 240));
            this.JCHModerado.setForeground(Color.black);
            this.JCHModerado.setBackground(new Color(240, 240, 240));
        }
    }

    private void mCuentaEstadoMental() {
        this.xValorEstAfec = 0;
        if (this.JTEstadoAfectivo.getSelectedColumn() == 3 || this.JTEstadoAfectivo.getSelectedColumn() == 4) {
            for (int i = 0; i < this.JTEstadoAfectivo.getRowCount(); i++) {
                if (Boolean.valueOf(this.xmodeloAfectivo.getValueAt(i, 3).toString()).booleanValue() && this.JTEstadoAfectivo.getColumnName(3).equals(this.xmodeloAfectivo.getValueAt(i, 2))) {
                    this.xValorEstAfec++;
                }
                if (Boolean.valueOf(this.xmodeloAfectivo.getValueAt(i, 4).toString()).booleanValue() && this.JTEstadoAfectivo.getColumnName(4).equals(this.xmodeloAfectivo.getValueAt(i, 2))) {
                    this.xValorEstAfec++;
                }
            }
        }
        this.JLRespEstAfec.setText("" + this.xValorEstAfec);
        if (this.xValorEstAfec >= 0 && this.xValorEstAfec <= 1) {
            this.JLCalEstAfec.setText("Sin manifestaciones depresivas");
        } else {
            this.JLCalEstAfec.setText("Con manifestaciones depresivas");
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloMental() {
        this.xmodeloMental = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Errado", "Acertado"}) { // from class: Historia.JPAdultoMayor.20
            Class[] types = {Integer.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTValMental.setModel(this.xmodeloMental);
        this.JTValMental.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTValMental.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTValMental.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTValMental.getColumnModel().getColumn(1).setPreferredWidth(350);
        this.JTValMental.getColumnModel().getColumn(2).setCellRenderer(new RadioButtonRenderer2());
        this.JTValMental.getColumnModel().getColumn(2).setCellEditor(new RadioButtonEditor2(new JCheckBox(), "1"));
        this.JTValMental.getColumnModel().getColumn(3).setCellRenderer(new RadioButtonRenderer2());
        this.JTValMental.getColumnModel().getColumn(3).setCellEditor(new RadioButtonEditor2(new JCheckBox(), "0"));
    }

    private void mllenaModeloMental() {
        mCrearModeloMental();
        ResultSet xrs = this.xct.traerRs("SELECT `Id`, `Nbre`, `Estado`, `Fecha`, `UsuarioS` FROM  `h_am_val_mental` WHERE Estado=1");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloMental.addRow(this.xdatos);
                    this.xmodeloMental.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloMental.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloMental.setValueAt(false, n, 2);
                    this.xmodeloMental.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHF() {
        this.xModeloHF = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Valoración", "Detalle", "Observación", "Profesional", "Especialidad"}) { // from class: Historia.JPAdultoMayor.21
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoFuncional.setModel(this.xModeloHF);
        this.JTHistoricoFuncional.getColumnModel().getColumn(0).setPreferredWidth(7);
        this.JTHistoricoFuncional.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTHistoricoFuncional.getColumnModel().getColumn(2).setPreferredWidth(350);
        this.JTHistoricoFuncional.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTHistoricoFuncional.getColumnModel().getColumn(4).setPreferredWidth(70);
        this.JTHistoricoFuncional.getColumnModel().getColumn(5).setPreferredWidth(70);
    }

    private void mBuscaHistoricoFunc() {
        mCrearModeloHF();
        String sql = "SELECT `h_am_val_funcional_h`.`FechaR` , IF(`h_am_val_funcional_h`.`Valoracion`=1,'INDEPENDIENTE',IF(`h_am_val_funcional_h`.`Valoracion`=2,'DEPENDIENTE','DEPENDIENTE TOTAL')) AS Valoracion\n    , GROUP_CONCAT(CONCAT(`h_am_val_funcional`.`Nbre`,':',IF(`h_am_val_funcional_h_detalle`.`Dependencia`=0,'Dependiente','Independiente')) SEPARATOR '\n') AS Detalle, `h_am_val_funcional_h`.`Observacion` \n    , `profesional1`.`NProfesional` , `profesional1`.`Especialidad` \n FROM `h_am_val_funcional_h`\n    INNER JOIN `profesional1`  ON (`h_am_val_funcional_h`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_am_val_funcional_h`.`IdEspecialista` = `profesional1`.`IdEspecialidad`)\n    INNER JOIN `h_am_val_funcional_h_detalle`  ON (`h_am_val_funcional_h_detalle`.`IdValoracion` = `h_am_val_funcional_h`.`Id`)\n    INNER JOIN `h_am_val_funcional`  ON (`h_am_val_funcional_h_detalle`.`IdItem` = `h_am_val_funcional`.`Id`)\n    INNER JOIN `h_atencion`  ON (`h_am_val_funcional_h`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`h_am_val_funcional_h`.`Estado` =1 AND  ingreso.`Id_Usuario`='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') GROUP BY  h_am_val_funcional_h.`Id` ORDER BY `h_am_val_funcional_h`.`FechaR` DESC;";
        ResultSet xrs = this.xct.traerRs(sql);
        this.xmt.mEstablecerTextEditor(this.JTHistoricoFuncional, 2);
        this.xmt.mEstablecerTextEditor(this.JTHistoricoFuncional, 3);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModeloHF.addRow(this.xdatos);
                    this.xModeloHF.setValueAt(xrs.getString(1), n, 0);
                    this.xModeloHF.setValueAt(xrs.getString(2), n, 1);
                    this.xModeloHF.setValueAt(xrs.getString(3), n, 2);
                    this.xModeloHF.setValueAt(xrs.getString(4), n, 3);
                    this.xModeloHF.setValueAt(xrs.getString(5), n, 4);
                    this.xModeloHF.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHM() {
        this.xModeloHM = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Puntaje", "Valoración", "PrimariaIncompleta", "Analfabeta", "Observacion", "Profesional", "Especialidad"}) { // from class: Historia.JPAdultoMayor.22
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoMental.setModel(this.xModeloHM);
        this.JTHistoricoMental.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTHistoricoMental.getColumnModel().getColumn(1).setPreferredWidth(8);
        this.JTHistoricoMental.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistoricoMental.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistoricoMental.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTHistoricoMental.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTHistoricoMental.getColumnModel().getColumn(6).setPreferredWidth(70);
        this.JTHistoricoMental.getColumnModel().getColumn(6).setPreferredWidth(70);
    }

    private void mBuscaHistoricoMent() {
        mCrearModeloHM();
        String sql = "SELECT `h_am_val_mental_h`.`FechaR`, `h_am_val_mental_h`.`Puntaje`, `h_am_val_mental_h`.`Valoracion`, IF(`h_am_val_mental_h`.`PrimIncom`=0,'NO','SI') AS PrimIncom, IF(`h_am_val_mental_h`.`Analfabeta`=0,'NO','SI') AS Analfabeta\n    , `h_am_val_mental_h`.`Observacion`, `profesional1`.`NProfesional`, `profesional1`.`Especialidad`\nFROM `baseserver`.`h_am_val_mental_h`INNER JOIN `baseserver`.`profesional1` ON (`h_am_val_mental_h`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_am_val_mental_h`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)\n    INNER JOIN `baseserver`.`h_atencion` ON (`h_am_val_mental_h`.`IdAtencion` = `h_atencion`.`Id`)\n    INNER JOIN `baseserver`.`ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nWHERE (`ingreso`.`Id_Usuario` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `h_am_val_mental_h`.`Estado` =1) ORDER BY `h_am_val_mental_h`.`FechaR`";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModeloHM.addRow(this.xdatos);
                    this.xModeloHM.setValueAt(xrs.getString(1), n, 0);
                    this.xModeloHM.setValueAt(xrs.getString(2), n, 1);
                    this.xModeloHM.setValueAt(xrs.getString(3), n, 2);
                    this.xModeloHM.setValueAt(xrs.getString(4), n, 3);
                    this.xModeloHM.setValueAt(xrs.getString(5), n, 4);
                    this.xModeloHM.setValueAt(xrs.getString(6), n, 5);
                    this.xModeloHM.setValueAt(xrs.getString(7), n, 6);
                    this.xModeloHM.setValueAt(xrs.getString(8), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloEstadoAfectivo() {
        this.xmodeloAfectivo = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Opción", "SI", "NO"}) { // from class: Historia.JPAdultoMayor.23
            Class[] types = {Integer.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTEstadoAfectivo.setModel(this.xmodeloAfectivo);
        this.JTEstadoAfectivo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTEstadoAfectivo.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTEstadoAfectivo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTEstadoAfectivo.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTEstadoAfectivo.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTEstadoAfectivo.getColumnModel().getColumn(3).setCellRenderer(new RadioButtonRenderer());
        this.JTEstadoAfectivo.getColumnModel().getColumn(3).setCellEditor(new RadioButtonEditor(new JCheckBox(), "1"));
        this.JTEstadoAfectivo.getColumnModel().getColumn(4).setCellRenderer(new RadioButtonRenderer());
        this.JTEstadoAfectivo.getColumnModel().getColumn(4).setCellEditor(new RadioButtonEditor(new JCheckBox(), "0"));
    }

    private void mBuscarAfectiva() {
        mCrearModeloEstadoAfectivo();
        ResultSet xrs = this.xct.traerRs("SELECT `Id` , `Nbre`, Opcion FROM `h_am_estado_afectivo` WHERE (`Estado` =1) ORDER BY Nbre ASC;");
        this.xmt.mEstablecerTextEditor(this.JTEstadoAfectivo, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloAfectivo.addRow(this.xdatos);
                    this.xmodeloAfectivo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloAfectivo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloAfectivo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloAfectivo.setValueAt(false, n, 3);
                    this.xmodeloAfectivo.setValueAt(false, n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloFliar() {
        this.xmodeloFliar = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Punt.", "Opción"}) { // from class: Historia.JPAdultoMayor.24
            Class[] types = {Integer.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSFliar.setModel(this.xmodeloFliar);
        this.JTSFliar.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTSFliar.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTSFliar.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTSFliar.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTSFliar.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTSFliar.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void mBuscarFliar() {
        mModeloFliar();
        ResultSet xrs = this.xct.traerRs("SELECT  `Id`  , `Nbre` , `Puntaje` FROM `h_am_sfamiliar_preguntas` WHERE (`IdGrupo` =1 AND `Estado` =1);");
        this.xmt.mEstablecerTextEditor(this.JTSFliar, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloFliar.addRow(this.xdatos);
                    this.xmodeloFliar.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloFliar.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloFliar.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodeloFliar.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloEconomico() {
        this.xmodeloEcon = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Punt.", "Opción"}) { // from class: Historia.JPAdultoMayor.25
            Class[] types = {Integer.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSEconomica.setModel(this.xmodeloEcon);
        this.JTSEconomica.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTSEconomica.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTSEconomica.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTSEconomica.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTSEconomica.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTSEconomica.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void mBuscarEconomico() {
        mModeloEconomico();
        ResultSet xrs = this.xct.traerRs("SELECT  `Id`  , `Nbre` , `Puntaje` FROM `h_am_sfamiliar_preguntas` WHERE (`IdGrupo` =2 AND `Estado` =1);");
        this.xmt.mEstablecerTextEditor(this.JTSEconomica, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloEcon.addRow(this.xdatos);
                    this.xmodeloEcon.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloEcon.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloEcon.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodeloEcon.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloVivienda() {
        this.xmodeloVivie = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Punt.", "Opción"}) { // from class: Historia.JPAdultoMayor.26
            Class[] types = {Integer.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSVivienda.setModel(this.xmodeloVivie);
        this.JTSVivienda.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTSVivienda.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTSVivienda.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTSVivienda.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTSVivienda.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTSVivienda.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void mBuscarVivienda() {
        mModeloVivienda();
        ResultSet xrs = this.xct.traerRs("SELECT  `Id`  , `Nbre` , `Puntaje` FROM `h_am_sfamiliar_preguntas` WHERE (`IdGrupo` =3 AND `Estado` =1);");
        this.xmt.mEstablecerTextEditor(this.JTSVivienda, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloVivie.addRow(this.xdatos);
                    this.xmodeloVivie.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloVivie.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloVivie.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodeloVivie.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloSocial() {
        this.xmodeloRsociales = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Punt.", "Opción"}) { // from class: Historia.JPAdultoMayor.27
            Class[] types = {Integer.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSRSociales.setModel(this.xmodeloRsociales);
        this.JTSRSociales.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTSRSociales.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTSRSociales.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTSRSociales.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTSRSociales.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTSRSociales.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void mBuscarSocial() {
        mModeloSocial();
        ResultSet xrs = this.xct.traerRs("SELECT  `Id`  , `Nbre` , `Puntaje` FROM `h_am_sfamiliar_preguntas` WHERE (`IdGrupo` =4 AND `Estado` =1);");
        this.xmt.mEstablecerTextEditor(this.JTSRSociales, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloRsociales.addRow(this.xdatos);
                    this.xmodeloRsociales.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloRsociales.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloRsociales.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodeloRsociales.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloApoyo() {
        this.xmodeloApoyo = new DefaultTableModel(new Object[0], new String[]{"Id", "Pregunta", "Punt.", "Opción"}) { // from class: Historia.JPAdultoMayor.28
            Class[] types = {Integer.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTSApoyo.setModel(this.xmodeloApoyo);
        this.JTSApoyo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTSApoyo.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTSApoyo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTSApoyo.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTSApoyo.getColumnModel().getColumn(2).setPreferredWidth(5);
        this.JTSApoyo.getColumnModel().getColumn(3).setPreferredWidth(15);
    }

    private void mBuscarApoyo() {
        mModeloApoyo();
        ResultSet xrs = this.xct.traerRs("SELECT  `Id`  , `Nbre` , `Puntaje` FROM `h_am_sfamiliar_preguntas` WHERE (`IdGrupo` =5 AND `Estado` =1);");
        this.xmt.mEstablecerTextEditor(this.JTSApoyo, 1);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloApoyo.addRow(this.xdatos);
                    this.xmodeloApoyo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloApoyo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloApoyo.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodeloApoyo.setValueAt(false, n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValorFliar(int x1, int x2, int x3, int x4, int x5) {
        this.xValorFliar = x1 + x2 + x3 + x4 + x5;
        this.JLTotalVal.setText("" + this.xValorFliar);
        if (this.xValorFliar >= 5 && this.xValorFliar <= 9) {
            this.JLCalificacion.setText("Buena/aceptable situación familiar");
            return;
        }
        if (this.xValorFliar >= 10 && this.xValorFliar <= 14) {
            this.JLCalificacion.setText("Existe riesgo familiar");
        } else if (this.xValorFliar >= 15) {
            this.JLCalificacion.setText("Existe problema social");
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHFliar() {
        this.xmodeloHFliar = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "Puntaje", "Calificación", "Profesional", "Especialidad"}) { // from class: Historia.JPAdultoMayor.29
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoSFliar.setModel(this.xmodeloHFliar);
        this.JTHistoricoSFliar.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistoricoSFliar.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistoricoSFliar.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistoricoSFliar.getColumnModel().getColumn(1).setPreferredWidth(8);
        this.JTHistoricoSFliar.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistoricoSFliar.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistoricoSFliar.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTHistoricoSFliar.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    private void mBuscarHfliar() {
        mCrearModeloHFliar();
        String sql = "SELECT `h_am_sfamiliar_h`.`IdAtencion`, `h_am_sfamiliar_h`.`FechaR`, `h_am_sfamiliar_h`.`TValoracion`, `h_am_sfamiliar_h`.`Calificacion`, `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\nFROM `h_am_sfamiliar_h`INNER JOIN `profesional1` ON (`h_am_sfamiliar_h`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_am_sfamiliar_h`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)\nWHERE (`h_am_sfamiliar_h`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `h_am_sfamiliar_h`.`Estado` =1) ORDER BY `h_am_sfamiliar_h`.`FechaR` DESC;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloHFliar.addRow(this.xdatos);
                    this.xmodeloHFliar.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloHFliar.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloHFliar.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloHFliar.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloHFliar.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloHFliar.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHAfectivo() {
        this.xmodeloHAfectivo = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "Puntaje", "Calificación", "Profesional", "Especialidad"}) { // from class: Historia.JPAdultoMayor.30
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoAfectivo.setModel(this.xmodeloHAfectivo);
        this.JTHistoricoAfectivo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistoricoAfectivo.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistoricoAfectivo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistoricoAfectivo.getColumnModel().getColumn(1).setPreferredWidth(8);
        this.JTHistoricoAfectivo.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistoricoAfectivo.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTHistoricoAfectivo.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTHistoricoAfectivo.getColumnModel().getColumn(5).setPreferredWidth(150);
    }

    private void mBuscarHAfectivo() {
        mCrearModeloHAfectivo();
        String sql = "SELECT `h_am_estado_afectivo_h`.`IdAtencion`, `h_am_estado_afectivo_h`.`FechaR`, `h_am_estado_afectivo_h`.`NRespuestas`, `h_am_estado_afectivo_h`.`Valoracion`, `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`\nFROM `h_am_estado_afectivo_h` INNER JOIN `profesional1` ON (`h_am_estado_afectivo_h`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_am_estado_afectivo_h`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)\nWHERE (`h_am_estado_afectivo_h`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `h_am_estado_afectivo_h`.`Estado` =1) ORDER BY `h_am_estado_afectivo_h`.`FechaR` DESC;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloHAfectivo.addRow(this.xdatos);
                    this.xmodeloHAfectivo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloHAfectivo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloHAfectivo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloHAfectivo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloHAfectivo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloHAfectivo.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAdultoMayor.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
