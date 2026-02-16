package Historia.aiepi;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi06.class */
public class JPAiepi06 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private int x;
    private ButtonGroup JBGP0;
    private ButtonGroup JBGP1;
    private JCheckBox JCH1;
    private JCheckBox JCH2;
    private JCheckBox JCH3;
    private JRadioButton JRBNO;
    private JRadioButton JRBNOP1;
    private JRadioButton JRBSI;
    private JRadioButton JRBSIP1;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservacion;
    private JTable JTDx;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xP0 = "NO";
    private String xP1 = "NO";
    private String xP2 = "";
    public Vector xSeleccion = new Vector();

    public JPAiepi06(int x) {
        initComponents();
        this.x = x;
        mBuscarTablaDx(x);
        mIniciaComponentes();
    }

    private void mBuscarTablaDx(int x) {
        String sql = "SELECT  `Id`, `Nbre`  FROM `p_aiepi_dx` WHERE IdPregunta=('" + x + "') order by Id ASC";
        mCreaModelodx();
        try {
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloDx.addRow(this.xdatos);
                    this.xmodeloDx.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloDx.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloDx.setValueAt(false, n, 2);
                    n++;
                }
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAiepi01.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelodx() {
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi06.1
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDx.setModel(this.xmodeloDx);
        this.JTDx.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDx.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDx.getColumnModel().getColumn(2).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGP0 = new ButtonGroup();
        this.JBGP1 = new ButtonGroup();
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.jLabel1 = new JLabel();
        this.JRBSI = new JRadioButton();
        this.JRBNO = new JRadioButton();
        this.jLabel2 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel9 = new JLabel();
        this.JRBSIP1 = new JRadioButton();
        this.JRBNOP1 = new JRadioButton();
        this.JCH1 = new JCheckBox();
        this.JCH2 = new JCheckBox();
        this.JCH3 = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("¿TIENE UN PROBLEMA DE GARGANTA?");
        this.JBGP0.add(this.JRBSI);
        this.JRBSI.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi06.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi06.this.JRBSIActionPerformed(evt);
            }
        });
        this.JBGP0.add(this.JRBNO);
        this.JRBNO.setSelected(true);
        this.JRBNO.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi06.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi06.this.JRBNOActionPerformed(evt);
            }
        });
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText(" SI       NO");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("¿Tiene dolor de garganta?");
        this.JBGP1.add(this.JRBSIP1);
        this.JRBSIP1.setFont(new Font("Arial", 1, 12));
        this.JRBSIP1.setForeground(Color.red);
        this.JRBSIP1.setText("SI");
        this.JRBSIP1.setHorizontalTextPosition(2);
        this.JRBSIP1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi06.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi06.this.JRBSIP1ActionPerformed(evt);
            }
        });
        this.JBGP1.add(this.JRBNOP1);
        this.JRBNOP1.setFont(new Font("Arial", 1, 12));
        this.JRBNOP1.setForeground(Color.red);
        this.JRBNOP1.setSelected(true);
        this.JRBNOP1.setText("NO");
        this.JRBNOP1.setHorizontalTextPosition(2);
        this.JRBNOP1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi06.5
            public void actionPerformed(ActionEvent evt) {
                JPAiepi06.this.JRBNOP1ActionPerformed(evt);
            }
        });
        this.JCH1.setFont(new Font("Arial", 1, 12));
        this.JCH1.setText("Ganglios del cuello crecidos y dolorosos");
        this.JCH1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi06.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepi06.this.JCH1ActionPerformed(evt);
            }
        });
        this.JCH2.setFont(new Font("Arial", 1, 12));
        this.JCH2.setText("Amígdalas eritematosas");
        this.JCH2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi06.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepi06.this.JCH2ActionPerformed(evt);
            }
        });
        this.JCH3.setFont(new Font("Arial", 1, 12));
        this.JCH3.setText("Exudado blanquecino-amarillento en amígdalas");
        this.JCH3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi06.8
            public void actionPerformed(ActionEvent evt) {
                JPAiepi06.this.JCH3ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH3).addComponent(this.JCH2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSIP1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP1)).addComponent(this.JCH1)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel9).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP1, -2, 13, -2).addComponent(this.JRBNOP1, GroupLayout.Alignment.LEADING, -2, 13, -2))).addGap(10, 10, 10).addComponent(this.JCH1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3).addContainerGap(-1, 32767)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 316, -2).addGap(8, 8, 8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JRBSI).addGap(10, 10, 10).addComponent(this.JRBNO)).addComponent(this.jLabel2)).addGap(0, 17, 32767)).addComponent(this.jPanel1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDiagnosticos, -2, 312, -2)).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSI).addComponent(this.JRBNO))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDiagnosticos, -2, 188, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 73, -2).addContainerGap(19, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIActionPerformed(ActionEvent evt) {
        this.xP0 = "SI";
        mIniciaComponentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOActionPerformed(ActionEvent evt) {
        this.xP0 = "NO";
        mIniciaComponentes();
        mBuscarTablaDx(this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP1ActionPerformed(ActionEvent evt) {
        this.xP1 = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP1ActionPerformed(ActionEvent evt) {
        this.xP1 = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1ActionPerformed(ActionEvent evt) {
        if (this.JCH1.isSelected()) {
            mAddElement(this.JCH1.getText());
        } else {
            mRemoveElement(this.JCH1.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2ActionPerformed(ActionEvent evt) {
        if (this.JCH2.isSelected()) {
            mAddElement(this.JCH2.getText());
        } else {
            mRemoveElement(this.JCH2.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH3ActionPerformed(ActionEvent evt) {
        if (this.JCH3.isSelected()) {
            mAddElement(this.JCH3.getText());
        } else {
            mRemoveElement(this.JCH3.getText());
        }
    }

    private void mIniciaComponentes() {
        if (this.JRBSI.isSelected()) {
            this.xmt.mEnableComponetes(this.jPanel1, true);
            return;
        }
        this.xmt.mEnableComponetes(this.jPanel1, false);
        this.xmt.clearPanel(this.jPanel1);
        this.xP1 = "NO";
        this.xP2 = "";
        this.JBGP1.clearSelection();
    }

    private void mAddElement(String x) {
        this.xSeleccion.addElement(x);
        mViewElements();
    }

    private void mRemoveElement(String x) {
        int i = 0;
        while (true) {
            if (i >= this.xSeleccion.size()) {
                break;
            }
            if (!x.equals(this.xSeleccion.elementAt(i))) {
                i++;
            } else {
                this.xSeleccion.removeElementAt(i);
                break;
            }
        }
        mViewElements();
    }

    private void mViewElements() {
        String string;
        String resultado = "";
        for (int i = 0; i < this.xSeleccion.size(); i++) {
            if (resultado.equals("")) {
                string = this.xSeleccion.elementAt(i).toString();
            } else {
                string = resultado + " , " + this.xSeleccion.elementAt(i);
            }
            resultado = string;
        }
        this.xP2 = resultado;
    }

    public void mGuardar(String xidExamen) {
        String sql = "INSERT INTO  `p_aiepi_pf` ( `IdEva_AIEPI`, `P0`, `P1`,  `P2`, `Observacion`, `UsuarioS`) VALUES ( '" + xidExamen + "', '" + this.xP0 + "', '" + this.xP1 + "', '" + this.xP2 + "', '" + this.JTAObservacion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        for (int y = 0; y < this.JTDx.getRowCount(); y++) {
            if (Boolean.valueOf(this.xmodeloDx.getValueAt(y, 2).toString()).booleanValue()) {
                String sql2 = "INSERT INTO  `p_aiepi_dx_resultado` (`IdDx`, `IdEvaluacion`, `UsuarioS`) VALUES ('" + this.xmodeloDx.getValueAt(y, 0).toString() + "', '" + xidExamen + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
        }
    }
}
