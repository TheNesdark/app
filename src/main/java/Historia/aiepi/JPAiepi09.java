package Historia.aiepi;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi09.class */
public class JPAiepi09 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private JCheckBox JCH1;
    private JCheckBox JCH2;
    private JCheckBox JCH5;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservacion;
    private JTable JTDx;
    private JTextField JTFCuando;
    private JTextField JTFTiempo;
    private ButtonGroup buttonGroup1;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xP3 = "";
    private String xP4 = "";

    public JPAiepi09(int x) {
        initComponents();
        mBuscarTablaDx(x);
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
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi09.1
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
        this.buttonGroup1 = new ButtonGroup();
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.jLabel3 = new JLabel();
        this.JTFCuando = new JTextField();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.JTFTiempo = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.jLabel6 = new JLabel();
        this.JCH1 = new JCheckBox();
        this.JCH5 = new JCheckBox();
        this.jLabel7 = new JLabel();
        this.JCH2 = new JCheckBox();
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Ha recibido hierro en los últimos 6 meses:");
        this.JTFCuando.setToolTipText("En número");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("¿Cuándo?");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("¿Cuánto tiempo?");
        this.JTFTiempo.setToolTipText("En número");
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setText("Palidez palmar:");
        this.buttonGroup1.add(this.JCH1);
        this.JCH1.setFont(new Font("Arial", 1, 12));
        this.JCH1.setText("Intensa");
        this.JCH1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi09.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi09.this.JCH1ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JCH5);
        this.JCH5.setFont(new Font("Arial", 1, 12));
        this.JCH5.setText("Leve");
        this.JCH5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi09.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi09.this.JCH5ActionPerformed(evt);
            }
        });
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("Palidez conjuntival:");
        this.JCH2.setFont(new Font("Arial", 1, 12));
        this.JCH2.setText("Intensa");
        this.JCH2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi09.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi09.this.JCH2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.jLabel4, -2, 61, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCuando)).addComponent(this.jLabel3, -2, 252, -2).addGroup(layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTiempo, -2, 170, -2))).addGroup(layout.createSequentialGroup().addComponent(this.jLabel6).addGap(18, 18, 18).addComponent(this.JCH1).addGap(31, 31, 31).addComponent(this.JCH5)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2))).addGap(0, 123, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDiagnosticos, -2, 312, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel3).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.JTFCuando, -2, -1, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.JTFTiempo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH1).addComponent(this.JCH5))).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.JCH2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 70, -2)).addComponent(this.JSPDiagnosticos, -2, 188, -2)).addContainerGap(106, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH1ActionPerformed(ActionEvent evt) {
        this.xP3 = this.JCH1.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH5ActionPerformed(ActionEvent evt) {
        this.xP3 = this.JCH5.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH2ActionPerformed(ActionEvent evt) {
        if (this.JCH2.isSelected()) {
            this.xP4 = this.JCH2.getText();
        } else {
            this.xP4 = "";
        }
    }

    public void mGuardar(String xidExamen) {
        String sql = "INSERT INTO  `p_aiepi_pi` ( `IdEva_AIEPI`, `P1`, `P2`, `P3`, `P4`, `Observaciones`, `UsuarioS`) VALUES ( '" + xidExamen + "', '" + this.JTFCuando.getText() + "', '" + this.JTFTiempo.getText() + "', '" + this.xP3 + "', '" + this.xP4 + "', '" + this.JTAObservacion.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "') ";
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
