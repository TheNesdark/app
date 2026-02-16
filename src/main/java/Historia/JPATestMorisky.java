package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPATestMorisky.class */
public class JPATestMorisky extends JPanel {
    private DefaultTableModel xmodelou;
    private clasesHistoriaCE xclase;
    private Object[] xdato;
    private ButtonGroup JBGP1;
    private ButtonGroup JBGP2;
    private ButtonGroup JBGP3;
    private ButtonGroup JBGP4;
    private JButton JBTUAdicionarElementoP;
    private JLabel JLBP1;
    private JLabel JLBP2;
    private JLabel JLBP3;
    private JLabel JLBP4;
    private JLabel JLBResultado;
    private JPanel JPIDatosElementosPP;
    private JRadioButton JRBPNo;
    private JRadioButton JRBPNo1;
    private JRadioButton JRBPNo2;
    private JRadioButton JRBPNo3;
    private JRadioButton JRBPSi;
    private JRadioButton JRBPSi1;
    private JRadioButton JRBPSi2;
    private JRadioButton JRBPSi3;
    private JScrollPane JSPHistorialU;
    private JTable JTPHistorialU;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xp1 = 0;
    private int xp2 = 1;
    private int xp3 = 0;
    private int xp4 = 0;
    private int xcumple = 1;
    private String xid = "0";

    public JPATestMorisky(clasesHistoriaCE xclase, int xmod) {
        initComponents();
        this.xclase = xclase;
        mBuscarDatosBd();
        this.JLBResultado.setText("CUMPLE");
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGP1 = new ButtonGroup();
        this.JBGP2 = new ButtonGroup();
        this.JBGP3 = new ButtonGroup();
        this.JBGP4 = new ButtonGroup();
        this.JPIDatosElementosPP = new JPanel();
        this.JBTUAdicionarElementoP = new JButton();
        this.JLBP1 = new JLabel();
        this.JRBPSi = new JRadioButton();
        this.JRBPNo = new JRadioButton();
        this.JLBP2 = new JLabel();
        this.JRBPSi1 = new JRadioButton();
        this.JRBPNo1 = new JRadioButton();
        this.JLBP3 = new JLabel();
        this.JRBPSi2 = new JRadioButton();
        this.JRBPNo2 = new JRadioButton();
        this.JLBP4 = new JLabel();
        this.JRBPSi3 = new JRadioButton();
        this.JRBPNo3 = new JRadioButton();
        this.JLBResultado = new JLabel();
        this.JSPHistorialU = new JScrollPane();
        this.JTPHistorialU = new JTable();
        setMaximumSize(null);
        setName("jpatestmorisky");
        this.JPIDatosElementosPP.setBorder(BorderFactory.createTitledBorder((Border) null, "PREGUNTAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBTUAdicionarElementoP.setFont(new Font("Arial", 1, 14));
        this.JBTUAdicionarElementoP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTUAdicionarElementoP.setText("Grabar");
        this.JBTUAdicionarElementoP.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.1
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JBTUAdicionarElementoPActionPerformed(evt);
            }
        });
        this.JLBP1.setFont(new Font("Arial", 1, 14));
        this.JLBP1.setForeground(new Color(0, 0, 255));
        this.JLBP1.setText("1. ¿Se olvida alguna vez de tomar los medicamentos? ");
        this.JBGP1.add(this.JRBPSi);
        this.JRBPSi.setFont(new Font("Arial", 1, 14));
        this.JRBPSi.setForeground(Color.red);
        this.JRBPSi.setText("Si");
        this.JRBPSi.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.2
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JRBPSiActionPerformed(evt);
            }
        });
        this.JBGP1.add(this.JRBPNo);
        this.JRBPNo.setFont(new Font("Arial", 1, 14));
        this.JRBPNo.setForeground(Color.red);
        this.JRBPNo.setSelected(true);
        this.JRBPNo.setText("No");
        this.JRBPNo.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.3
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JRBPNoActionPerformed(evt);
            }
        });
        this.JLBP2.setFont(new Font("Arial", 1, 14));
        this.JLBP2.setForeground(new Color(0, 0, 255));
        this.JLBP2.setText("2. ¿Toma todos los medicamentos indicados? ");
        this.JBGP2.add(this.JRBPSi1);
        this.JRBPSi1.setFont(new Font("Arial", 1, 14));
        this.JRBPSi1.setForeground(Color.red);
        this.JRBPSi1.setSelected(true);
        this.JRBPSi1.setText("Si");
        this.JRBPSi1.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.4
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JRBPSi1ActionPerformed(evt);
            }
        });
        this.JBGP2.add(this.JRBPNo1);
        this.JRBPNo1.setFont(new Font("Arial", 1, 14));
        this.JRBPNo1.setForeground(Color.red);
        this.JRBPNo1.setText("No");
        this.JRBPNo1.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.5
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JRBPNo1ActionPerformed(evt);
            }
        });
        this.JLBP3.setFont(new Font("Arial", 1, 14));
        this.JLBP3.setForeground(new Color(0, 0, 255));
        this.JLBP3.setText("3. Cuando se encuentra mejor, ¿Deja de tomar los medicamentos? ");
        this.JBGP3.add(this.JRBPSi2);
        this.JRBPSi2.setFont(new Font("Arial", 1, 14));
        this.JRBPSi2.setForeground(Color.red);
        this.JRBPSi2.setText("Si");
        this.JRBPSi2.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.6
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JRBPSi2ActionPerformed(evt);
            }
        });
        this.JBGP3.add(this.JRBPNo2);
        this.JRBPNo2.setFont(new Font("Arial", 1, 14));
        this.JRBPNo2.setForeground(Color.red);
        this.JRBPNo2.setSelected(true);
        this.JRBPNo2.setText("No");
        this.JRBPNo2.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.7
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JRBPNo2ActionPerformed(evt);
            }
        });
        this.JLBP4.setFont(new Font("Arial", 1, 14));
        this.JLBP4.setForeground(new Color(0, 0, 255));
        this.JLBP4.setText("4. Si alguna vez se siente mal, ¿Deja de tomarlos? ");
        this.JBGP4.add(this.JRBPSi3);
        this.JRBPSi3.setFont(new Font("Arial", 1, 14));
        this.JRBPSi3.setForeground(Color.red);
        this.JRBPSi3.setText("Si");
        this.JRBPSi3.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.8
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JRBPSi3ActionPerformed(evt);
            }
        });
        this.JBGP4.add(this.JRBPNo3);
        this.JRBPNo3.setFont(new Font("Arial", 1, 14));
        this.JRBPNo3.setForeground(Color.red);
        this.JRBPNo3.setSelected(true);
        this.JRBPNo3.setText("No");
        this.JRBPNo3.addActionListener(new ActionListener() { // from class: Historia.JPATestMorisky.9
            public void actionPerformed(ActionEvent evt) {
                JPATestMorisky.this.JRBPNo3ActionPerformed(evt);
            }
        });
        this.JLBResultado.setFont(new Font("Arial", 1, 18));
        this.JLBResultado.setForeground(new Color(0, 103, 0));
        this.JLBResultado.setHorizontalAlignment(0);
        GroupLayout JPIDatosElementosPPLayout = new GroupLayout(this.JPIDatosElementosPP);
        this.JPIDatosElementosPP.setLayout(JPIDatosElementosPPLayout);
        JPIDatosElementosPPLayout.setHorizontalGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JLBP1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBPSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPNo)).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBP2).addComponent(this.JLBP3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, 32767).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JRBPSi2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPNo2)).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JRBPSi1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPNo1)).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JRBPSi3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPNo3))))).addComponent(this.JLBP4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 6, 32767).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTUAdicionarElementoP, -1, -1, 32767).addComponent(this.JLBResultado, -1, 131, 32767)).addContainerGap()));
        JPIDatosElementosPPLayout.setVerticalGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosElementosPPLayout.createSequentialGroup().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JLBP1)).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPSi).addComponent(this.JRBPNo))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPSi1).addComponent(this.JRBPNo1).addComponent(this.JLBP2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBP3).addComponent(this.JRBPSi2).addComponent(this.JRBPNo2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBP4).addComponent(this.JRBPSi3).addComponent(this.JRBPNo3))).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addComponent(this.JLBResultado, -1, 81, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTUAdicionarElementoP, -2, 43, -2))).addContainerGap()));
        this.JSPHistorialU.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPHistorialU.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialU.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialU.setRowHeight(25);
        this.JTPHistorialU.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialU.setSelectionForeground(Color.red);
        this.JTPHistorialU.setSelectionMode(0);
        this.JSPHistorialU.setViewportView(this.JTPHistorialU);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPHistorialU, GroupLayout.Alignment.LEADING, -1, 816, 32767).addComponent(this.JPIDatosElementosPP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosElementosPP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorialU, -2, 206, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTUAdicionarElementoPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPSiActionPerformed(ActionEvent evt) {
        this.xp1 = 1;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNoActionPerformed(ActionEvent evt) {
        this.xp1 = 0;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPSi1ActionPerformed(ActionEvent evt) {
        this.xp2 = 1;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNo1ActionPerformed(ActionEvent evt) {
        this.xp2 = 0;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPSi2ActionPerformed(ActionEvent evt) {
        this.xp3 = 1;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNo2ActionPerformed(ActionEvent evt) {
        this.xp3 = 0;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPSi3ActionPerformed(ActionEvent evt) {
        this.xp4 = 1;
        mEvaluarCumplimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNo3ActionPerformed(ActionEvent evt) {
        this.xp4 = 0;
        mEvaluarCumplimiento();
    }

    public void mGrabar() {
        if (this.xid.equals("0")) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String xsql = "insert  into p_test_morisky(Id_Usuario, Id_Atencion, FechaT, Id_Especialidad, Id_Profesional, P1, P2, P3, P4, UsuarioS) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xp1 + "','" + this.xp2 + "','" + this.xp3 + "','" + this.xp4 + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xid = this.xct.ejecutarSQLId(xsql);
                this.xct.cerrarConexionBd();
                String xsql2 = "update g_usuarioxprograma set CumpleTesMorisky='" + this.xcumple + "' where Id_Usuario='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' and Id_Programa=11";
                this.xct.ejecutarSQL(xsql2);
                this.xct.cerrarConexionBd();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                mBuscarDatosBd();
            }
        }
    }

    private void mEvaluarCumplimiento() {
        if (this.xp1 == 0 && this.xp2 == 1 && this.xp3 == 0 && this.xp4 == 0) {
            this.JLBResultado.setText("CUMPLE");
            this.xcumple = 1;
        } else {
            this.JLBResultado.setText("INCUMPLE");
            this.xcumple = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelou = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Especialidad", "Profesional", "P1", "P2", "P3", "P4", "Resultado"}) { // from class: Historia.JPATestMorisky.10
            Class[] types = {Integer.class, String.class, String.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPHistorialU.setModel(this.xmodelou);
        this.JTPHistorialU.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTPHistorialU.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTPHistorialU.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTPHistorialU.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTPHistorialU.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTPHistorialU.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTPHistorialU.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTPHistorialU.getColumnModel().getColumn(8).setPreferredWidth(20);
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT p_test_morisky.Id, p_test_morisky.FechaT, profesional1.Especialidad, profesional1.NProfesional, p_test_morisky.P1, p_test_morisky.P2, p_test_morisky.P3, p_test_morisky.P4, if(p_test_morisky.P1=0 and p_test_morisky.P2=1 and p_test_morisky.P3=0 AND p_test_morisky.P4=0,'CUMPLE','INCUMPLE') AS Tipo FROM profesional1 INNER JOIN p_test_morisky  ON (profesional1.IdEspecialidad = p_test_morisky.Id_Especialidad) AND (profesional1.Id_Persona = p_test_morisky.Id_Profesional) WHERE (p_test_morisky.Estado =1 AND p_test_morisky.Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "') ORDER BY p_test_morisky.FechaT DESC ";
            mCrearTabla();
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelou.addRow(this.xdato);
                    this.xmodelou.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelou.setValueAt(rs.getString(2), x, 1);
                    this.xmodelou.setValueAt(rs.getString(3), x, 2);
                    this.xmodelou.setValueAt(rs.getString(4), x, 3);
                    this.xmodelou.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                    this.xmodelou.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    this.xmodelou.setValueAt(Boolean.valueOf(rs.getBoolean(7)), x, 6);
                    this.xmodelou.setValueAt(Boolean.valueOf(rs.getBoolean(8)), x, 7);
                    this.xmodelou.setValueAt(rs.getString(9), x, 8);
                    this.JTPHistorialU.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesFamiliares.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPATestMorisky$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8).toString().equals("INCUMPLE")) {
                cell.setBackground(new Color(97, 228, 183));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
