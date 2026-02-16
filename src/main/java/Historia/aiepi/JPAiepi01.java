package Historia.aiepi;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/aiepi/JPAiepi01.class */
public class JPAiepi01 extends JPanel {
    private DefaultTableModel xmodeloDx;
    private Object[] xdatos;
    private int x;
    private ButtonGroup JBGP0;
    private JCheckBox JCH1;
    private JCheckBox JCH2;
    private JCheckBox JCH3;
    private JCheckBox JCH4;
    private JPanel JPPreguntas;
    private JRadioButton JRBNO;
    private JRadioButton JRBSI;
    private JScrollPane JSPDiagnosticos;
    private JTextArea JTAObservacion;
    private JTable JTDx;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xP0 = "NO";
    private String xP1 = "";
    public Vector xSeleccion = new Vector();

    public JPAiepi01(int x) {
        initComponents();
        this.x = x;
        mBuscarTablaDx(x);
        this.JCH1.setEnabled(false);
        this.JCH2.setEnabled(false);
        this.JCH3.setEnabled(false);
        this.JCH4.setEnabled(false);
        this.JSPDiagnosticos.setEnabled(false);
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
        this.xmodeloDx = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Aplica?"}) { // from class: Historia.aiepi.JPAiepi01.1
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
        this.JSPDiagnosticos = new JScrollPane();
        this.JTDx = new JTable();
        this.jLabel1 = new JLabel();
        this.JRBSI = new JRadioButton();
        this.JRBNO = new JRadioButton();
        this.jLabel2 = new JLabel();
        this.JPPreguntas = new JPanel();
        this.JCH1 = new JCheckBox();
        this.JCH2 = new JCheckBox();
        this.JCH3 = new JCheckBox();
        this.JCH4 = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTDx.setFont(new Font("Arial", 1, 12));
        this.JTDx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDx.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnosticos.setViewportView(this.JTDx);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("VERIFICAR SI EXISTEN SIGNOS DE PELIGRO EN GENERAL");
        this.JBGP0.add(this.JRBSI);
        this.JRBSI.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi01.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepi01.this.JRBSIActionPerformed(evt);
            }
        });
        this.JBGP0.add(this.JRBNO);
        this.JRBNO.setSelected(true);
        this.JRBNO.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi01.3
            public void actionPerformed(ActionEvent evt) {
                JPAiepi01.this.JRBNOActionPerformed(evt);
            }
        });
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText(" SI       NO");
        this.JPPreguntas.setBorder(BorderFactory.createTitledBorder(""));
        this.JCH1.setFont(new Font("Arial", 1, 12));
        this.JCH1.setText("No puede beber o tomar del pecho");
        this.JCH1.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi01.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepi01.this.JCH1ActionPerformed(evt);
            }
        });
        this.JCH2.setFont(new Font("Arial", 1, 12));
        this.JCH2.setText("Vomita todo");
        this.JCH2.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi01.5
            public void actionPerformed(ActionEvent evt) {
                JPAiepi01.this.JCH2ActionPerformed(evt);
            }
        });
        this.JCH3.setFont(new Font("Arial", 1, 12));
        this.JCH3.setText("Esta letárgico o inconsciente");
        this.JCH3.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi01.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepi01.this.JCH3ActionPerformed(evt);
            }
        });
        this.JCH4.setFont(new Font("Arial", 1, 12));
        this.JCH4.setText("Presenta convulsiones");
        this.JCH4.addActionListener(new ActionListener() { // from class: Historia.aiepi.JPAiepi01.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepi01.this.JCH4ActionPerformed(evt);
            }
        });
        GroupLayout JPPreguntasLayout = new GroupLayout(this.JPPreguntas);
        this.JPPreguntas.setLayout(JPPreguntasLayout);
        JPPreguntasLayout.setHorizontalGroup(JPPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPreguntasLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH1).addComponent(this.JCH2).addComponent(this.JCH3).addComponent(this.JCH4)).addContainerGap(-1, 32767)));
        JPPreguntasLayout.setVerticalGroup(JPPreguntasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPreguntasLayout.createSequentialGroup().addComponent(this.JCH1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH4).addGap(0, 0, 32767)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 316, -2).addGap(8, 8, 8).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.JRBSI).addGap(10, 10, 10).addComponent(this.JRBNO)).addComponent(this.jLabel2, -1, -1, 32767)).addGap(0, 9, 32767)).addComponent(this.JPPreguntas, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JSPDiagnosticos, -2, 312, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDiagnosticos, -2, 188, -2)).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSI).addComponent(this.JRBNO))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPreguntas, -1, -1, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 85, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOActionPerformed(ActionEvent evt) {
        this.xP0 = "NO";
        this.xP1 = "";
        this.JPPreguntas.setEnabled(false);
        this.JCH1.setEnabled(false);
        this.JCH2.setEnabled(false);
        this.JCH3.setEnabled(false);
        this.JCH4.setEnabled(false);
        this.JCH1.setSelected(false);
        this.JCH2.setSelected(false);
        this.JCH3.setSelected(false);
        this.JCH4.setSelected(false);
        mBuscarTablaDx(this.x);
        this.JSPDiagnosticos.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSIActionPerformed(ActionEvent evt) {
        this.xP0 = "SI";
        this.JPPreguntas.setEnabled(true);
        this.JCH1.setEnabled(true);
        this.JCH2.setEnabled(true);
        this.JCH3.setEnabled(true);
        this.JCH4.setEnabled(true);
        this.JSPDiagnosticos.setEnabled(true);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH4ActionPerformed(ActionEvent evt) {
        if (this.JCH4.isSelected()) {
            mAddElement(this.JCH4.getText());
        } else {
            mRemoveElement(this.JCH4.getText());
        }
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
        this.xP1 = resultado;
    }

    public void mGuardar(String xidExamen) {
        String sql = "insert into  `p_aiepi_pa` (`IdEva_AIEPI`, `P0`, `P1`, `Observacion`,  `UsuarioS`) values ('" + xidExamen + "', '" + this.xP0 + "', '" + this.xP1 + "',  '" + this.JTAObservacion.getText() + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "')";
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
