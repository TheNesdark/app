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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi11.class */
public class JPAiepi11 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private JRadioButton JRBNOP10;
    private JRadioButton JRBNOP11;
    private JRadioButton JRBNOP12;
    private JRadioButton JRBNOP13;
    private JRadioButton JRBNOP5;
    private JRadioButton JRBNOP6;
    private JRadioButton JRBNOP7;
    private JRadioButton JRBNOP8;
    private JRadioButton JRBNOP9;
    private JRadioButton JRBSIP5;
    private JRadioButton JRBSIP6;
    private JRadioButton JRBSIP7;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservaciones;
    private JTextArea JTAP1;
    private JTextArea JTAP2;
    private JTable JTDx;
    private JTextField JTFFenotipica;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel9;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xP3 = "";
    private String xP4 = "";
    private String xP5 = "";

    public JPAiepi11(int x) {
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
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi11.1
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
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.jScrollPane1 = new JScrollPane();
        this.JTAP1 = new JTextArea();
        this.jScrollPane2 = new JScrollPane();
        this.JTAP2 = new JTextArea();
        this.jLabel10 = new JLabel();
        this.JRBSIP5 = new JRadioButton();
        this.JRBNOP5 = new JRadioButton();
        this.JRBNOP6 = new JRadioButton();
        this.JRBNOP7 = new JRadioButton();
        this.jLabel11 = new JLabel();
        this.jLabel12 = new JLabel();
        this.JRBSIP6 = new JRadioButton();
        this.JRBNOP8 = new JRadioButton();
        this.JRBNOP9 = new JRadioButton();
        this.JRBNOP10 = new JRadioButton();
        this.jLabel13 = new JLabel();
        this.jLabel14 = new JLabel();
        this.JRBSIP7 = new JRadioButton();
        this.JRBNOP11 = new JRadioButton();
        this.JRBNOP12 = new JRadioButton();
        this.JRBNOP13 = new JRadioButton();
        this.jLabel15 = new JLabel();
        this.jLabel9 = new JLabel();
        this.JTFFenotipica = new JTextField();
        this.jScrollPane3 = new JScrollPane();
        this.JTAObservaciones = new JTextArea();
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        this.JTAP1.setColumns(1);
        this.JTAP1.setFont(new Font("Arial", 0, 12));
        this.JTAP1.setLineWrap(true);
        this.JTAP1.setRows(1);
        this.JTAP1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiene algún antecedente importante Para el desarrollo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAP1);
        this.JTAP2.setColumns(1);
        this.JTAP2.setFont(new Font("Arial", 0, 12));
        this.JTAP2.setLineWrap(true);
        this.JTAP2.setRows(1);
        this.JTAP2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiene algún factor de riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAP2);
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setText("Realiza");
        this.buttonGroup1.add(this.JRBSIP5);
        this.JRBSIP5.setFont(new Font("Arial", 1, 12));
        this.JRBSIP5.setForeground(Color.red);
        this.JRBSIP5.setText("1");
        this.JRBSIP5.setHorizontalTextPosition(2);
        this.JRBSIP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBSIP5ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBNOP5);
        this.JRBNOP5.setFont(new Font("Arial", 1, 12));
        this.JRBNOP5.setForeground(Color.red);
        this.JRBNOP5.setText("2");
        this.JRBNOP5.setHorizontalTextPosition(2);
        this.JRBNOP5.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP5ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBNOP6);
        this.JRBNOP6.setFont(new Font("Arial", 1, 12));
        this.JRBNOP6.setForeground(Color.red);
        this.JRBNOP6.setText("3");
        this.JRBNOP6.setHorizontalTextPosition(2);
        this.JRBNOP6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP6ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBNOP7);
        this.JRBNOP7.setFont(new Font("Arial", 1, 12));
        this.JRBNOP7.setForeground(Color.red);
        this.JRBNOP7.setText("4");
        this.JRBNOP7.setHorizontalTextPosition(2);
        this.JRBNOP7.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.5
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP7ActionPerformed(evt);
            }
        });
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setText("condiciones para la edad");
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setText("Ausencia de");
        this.buttonGroup2.add(this.JRBSIP6);
        this.JRBSIP6.setFont(new Font("Arial", 1, 12));
        this.JRBSIP6.setForeground(Color.red);
        this.JRBSIP6.setText("1");
        this.JRBSIP6.setHorizontalTextPosition(2);
        this.JRBSIP6.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBSIP6ActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.JRBNOP8);
        this.JRBNOP8.setFont(new Font("Arial", 1, 12));
        this.JRBNOP8.setForeground(Color.red);
        this.JRBNOP8.setText("2");
        this.JRBNOP8.setHorizontalTextPosition(2);
        this.JRBNOP8.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP8ActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.JRBNOP9);
        this.JRBNOP9.setFont(new Font("Arial", 1, 12));
        this.JRBNOP9.setForeground(Color.red);
        this.JRBNOP9.setText("3");
        this.JRBNOP9.setHorizontalTextPosition(2);
        this.JRBNOP9.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.8
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP9ActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.JRBNOP10);
        this.JRBNOP10.setFont(new Font("Arial", 1, 12));
        this.JRBNOP10.setForeground(Color.red);
        this.JRBNOP10.setText("4");
        this.JRBNOP10.setHorizontalTextPosition(2);
        this.JRBNOP10.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.9
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP10ActionPerformed(evt);
            }
        });
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setText("condiciones para la edad");
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setText("Ausencia de");
        this.buttonGroup3.add(this.JRBSIP7);
        this.JRBSIP7.setFont(new Font("Arial", 1, 12));
        this.JRBSIP7.setForeground(Color.red);
        this.JRBSIP7.setText("1");
        this.JRBSIP7.setHorizontalTextPosition(2);
        this.JRBSIP7.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.10
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBSIP7ActionPerformed(evt);
            }
        });
        this.buttonGroup3.add(this.JRBNOP11);
        this.JRBNOP11.setFont(new Font("Arial", 1, 12));
        this.JRBNOP11.setForeground(Color.red);
        this.JRBNOP11.setText("2");
        this.JRBNOP11.setHorizontalTextPosition(2);
        this.JRBNOP11.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.11
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP11ActionPerformed(evt);
            }
        });
        this.buttonGroup3.add(this.JRBNOP12);
        this.JRBNOP12.setFont(new Font("Arial", 1, 12));
        this.JRBNOP12.setForeground(Color.red);
        this.JRBNOP12.setText("3");
        this.JRBNOP12.setHorizontalTextPosition(2);
        this.JRBNOP12.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.12
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP12ActionPerformed(evt);
            }
        });
        this.buttonGroup3.add(this.JRBNOP13);
        this.JRBNOP13.setFont(new Font("Arial", 1, 12));
        this.JRBNOP13.setForeground(Color.red);
        this.JRBNOP13.setText("4");
        this.JRBNOP13.setHorizontalTextPosition(2);
        this.JRBNOP13.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi11.13
            public void actionPerformed(ActionEvent evt) {
                JPAiepi11.this.JRBNOP13ActionPerformed(evt);
            }
        });
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setText("condiciones del grupo anterior");
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("Alteraciones fenotípicas:");
        this.JTFFenotipica.setToolTipText("En número");
        this.JTAObservaciones.setColumns(1);
        this.JTAObservaciones.setFont(new Font("Arial", 0, 12));
        this.JTAObservaciones.setLineWrap(true);
        this.JTAObservaciones.setRows(1);
        this.JTAObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTAObservaciones);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 374, -2).addComponent(this.jScrollPane2, -2, 374, -2).addGroup(layout.createSequentialGroup().addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSIP5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel11)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSIP6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP8).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP9).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel13)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel9, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel14).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSIP7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP11))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JRBNOP12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNOP13).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel15)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTFFenotipica, -2, 227, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addComponent(this.JSPDiagnosticos, -2, 312, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 58, -2).addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP5, -2, 13, -2).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNOP5, -2, 13, -2).addComponent(this.JRBNOP6, -2, 13, -2).addComponent(this.JRBNOP7, -2, 13, -2).addComponent(this.jLabel11)))).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel12).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP6, -2, 13, -2).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNOP8, -2, 13, -2).addComponent(this.JRBNOP9, -2, 13, -2).addComponent(this.JRBNOP10, -2, 13, -2).addComponent(this.jLabel13)))).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel14).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JRBSIP7, -2, 13, -2).addGroup(GroupLayout.Alignment.LEADING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNOP11, -2, 13, -2).addComponent(this.JRBNOP12, -2, 13, -2).addComponent(this.JRBNOP13, -2, 13, -2).addComponent(this.jLabel15))))).addComponent(this.JSPDiagnosticos, -2, 188, -2)).addGap(4, 4, 4).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.JTFFenotipica, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 52, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP5ActionPerformed(ActionEvent evt) {
        this.xP3 = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP5ActionPerformed(ActionEvent evt) {
        this.xP3 = "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP6ActionPerformed(ActionEvent evt) {
        this.xP3 = "3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP7ActionPerformed(ActionEvent evt) {
        this.xP3 = "4";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP6ActionPerformed(ActionEvent evt) {
        this.xP4 = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP8ActionPerformed(ActionEvent evt) {
        this.xP4 = "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP9ActionPerformed(ActionEvent evt) {
        this.xP4 = "3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP10ActionPerformed(ActionEvent evt) {
        this.xP4 = "4";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIP7ActionPerformed(ActionEvent evt) {
        this.xP5 = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP11ActionPerformed(ActionEvent evt) {
        this.xP5 = "2";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP12ActionPerformed(ActionEvent evt) {
        this.xP5 = "3";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOP13ActionPerformed(ActionEvent evt) {
        this.xP5 = "4";
    }

    public void mGuardar(String xIdEva) {
        String sql = "INSERT INTO  `p_aiepi_pk` ( `IdEva_AIEPI`, `P1`, `P2`, `P3`, `P4`, `P5`, `P6`, `Observacion`, `UsuarioS`) VALUES ( '" + xIdEva + "', '" + this.JTAP1.getText() + "', '" + this.JTAP2.getText() + "', '" + this.xP3 + "', '" + this.xP4 + "', '" + this.xP5 + "', '" + this.JTFFenotipica.getText() + "', '" + this.JTAObservaciones.getText() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        for (int y = 0; y < this.JTDx.getRowCount(); y++) {
            if (Boolean.valueOf(this.xmodeloDx.getValueAt(y, 2).toString()).booleanValue()) {
                String sql2 = "INSERT INTO  `p_aiepi_dx_resultado` (`IdDx`, `IdEvaluacion`, `UsuarioS`) VALUES ('" + this.xmodeloDx.getValueAt(y, 0).toString() + "', '" + xIdEva + "', '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
            }
        }
    }
}
