package Historia;

import Acceso.Principal;
import Laboratorio.CapturarResultado;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JP_CP_ResultadoExamenes1.class */
public class JP_CP_ResultadoExamenes1 extends JPanel {
    private String[][] xidexamen;
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private JButton JBTAdicionar;
    private JComboBox JCBExamen;
    private JCheckBox JCHIngreso;
    private JDateChooser JDFecha;
    private JEditorPane JEPObservacion;
    private JPanel JPIInicioC;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTable JTBHistorico;
    public JTextField JTFFResultado;
    private GregorianCalendar xfecha_defecto = new GregorianCalendar(1800, 0, 1);
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private long xEsIngreso = 0;

    public JP_CP_ResultadoExamenes1() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIInicioC = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JCBExamen = new JComboBox();
        this.JTFFResultado = new JTextField();
        this.JSPObservacion = new JScrollPane();
        this.JEPObservacion = new JEditorPane();
        this.JBTAdicionar = new JButton();
        this.JCHIngreso = new JCheckBox();
        this.JSPHistorico = new JScrollPane();
        this.JTBHistorico = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO DE EXÁMENES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpcpresultadoexamenes1");
        this.JPIInicioC.setBorder(BorderFactory.createTitledBorder((Border) null, "TAMIZAJE CLÍNICO Y DE LABORATORIO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JCBExamen.setFont(new Font("Arial", 1, 12));
        this.JCBExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Exámen", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFResultado.setFont(new Font("Arial", 1, 12));
        this.JTFFResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFResultado.addMouseListener(new MouseAdapter() { // from class: Historia.JP_CP_ResultadoExamenes1.1
            public void mouseClicked(MouseEvent evt) {
                JP_CP_ResultadoExamenes1.this.JTFFResultadoMouseClicked(evt);
            }
        });
        this.JTFFResultado.addKeyListener(new KeyAdapter() { // from class: Historia.JP_CP_ResultadoExamenes1.2
            public void keyTyped(KeyEvent evt) {
                JP_CP_ResultadoExamenes1.this.JTFFResultadoKeyTyped(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setHorizontalScrollBarPolicy(31);
        this.JSPObservacion.setVerticalScrollBarPolicy(21);
        this.JEPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JEPObservacion);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JP_CP_ResultadoExamenes1.3
            public void actionPerformed(ActionEvent evt) {
                JP_CP_ResultadoExamenes1.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JCHIngreso.setFont(new Font("Arial", 1, 12));
        this.JCHIngreso.setText("Es Ingreso?");
        this.JCHIngreso.addActionListener(new ActionListener() { // from class: Historia.JP_CP_ResultadoExamenes1.4
            public void actionPerformed(ActionEvent evt) {
                JP_CP_ResultadoExamenes1.this.JCHIngresoActionPerformed(evt);
            }
        });
        GroupLayout JPIInicioCLayout = new GroupLayout(this.JPIInicioC);
        this.JPIInicioC.setLayout(JPIInicioCLayout);
        JPIInicioCLayout.setHorizontalGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addContainerGap().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPObservacion, -2, 666, -2).addGroup(JPIInicioCLayout.createSequentialGroup().addComponent(this.JDFecha, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBExamen, -2, 370, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFResultado, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHIngreso))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar, -1, -1, 32767).addContainerGap()));
        JPIInicioCLayout.setVerticalGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addContainerGap().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIInicioCLayout.createSequentialGroup().addGroup(JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFecha, GroupLayout.Alignment.TRAILING, -2, 45, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIInicioCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBExamen, -2, 43, -2).addComponent(this.JTFFResultado))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)).addGroup(JPIInicioCLayout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.JCHIngreso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addComponent(this.JSPObservacion, -2, 52, -2)).addComponent(this.JBTAdicionar, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBHistorico.setRowHeight(25);
        this.JTBHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBHistorico.setSelectionMode(0);
        this.JTBHistorico.addKeyListener(new KeyAdapter() { // from class: Historia.JP_CP_ResultadoExamenes1.5
            public void keyPressed(KeyEvent evt) {
                JP_CP_ResultadoExamenes1.this.JTBHistoricoKeyPressed(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTBHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIInicioC, -1, -1, 32767).addComponent(this.JSPHistorico)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIInicioC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPHistorico, -1, 461, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFResultadoMouseClicked(MouseEvent evt) {
        if (this.JCBExamen.getSelectedIndex() != -1) {
            mCargarTipoResultado();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHIngresoActionPerformed(ActionEvent evt) {
        if (this.JCHIngreso.isSelected()) {
            this.xEsIngreso = 1L;
        } else {
            this.xEsIngreso = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBHistoricoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTBHistorico.getRowCount() != 0 && this.JTBHistorico.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "update p_resultado_examenes set Estado=0 where Id='" + this.xmodelo.getValueAt(this.JTBHistorico.getSelectedRow(), 0).toString() + "'";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                mCargarDatos();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFResultadoKeyTyped(KeyEvent evt) {
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            if (this.JCBExamen.getSelectedIndex() != -1) {
                if ("0".equals(this.xidexamen[this.JCBExamen.getSelectedIndex()][2])) {
                    char car = evt.getKeyChar();
                    if ((car < '0' || car > '9') && car != '\b' && car != '.') {
                        evt.consume();
                    }
                    if (car == '.' && this.JTFFResultado.getText().contains(".")) {
                        evt.consume();
                        return;
                    }
                    return;
                }
                return;
            }
            evt.consume();
        }
    }

    private void mCargarTipoResultado() {
        CapturarResultado frmCR = new CapturarResultado(null, true, this.xidexamen[this.JCBExamen.getSelectedIndex()][1], Principal.clasehistoriace.xjifhistoriaclinica);
        frmCR.setVisible(true);
    }

    private void mNuevo() {
        if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
            this.JDFecha.setDate((Date) null);
        } else {
            this.JDFecha.setDate(this.xmt.getFechaActual());
        }
        this.JCBExamen.removeAllItems();
        this.xidexamen = this.xct.llenarComboyLista("SELECT `Id`, `Nbre`, `Id_Procedimiento`, TipoDatoR FROM `p_demanda_inducida` WHERE (`Nbre` <>'' AND `Id_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdPrograma() + "' AND `Estado` =1) ORDER BY `Nbre` ASC", this.xidexamen, this.JCBExamen, 4);
        this.JCBExamen.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFFResultado.setText("");
        this.JEPObservacion.setText("");
        this.xEsIngreso = 0L;
        this.JCHIngreso.setSelected(false);
        mCargarDatos();
    }

    public void mGrabar() {
        if (this.JCBExamen.getSelectedIndex() != -1) {
            if (this.JDFecha.getDate() != null && Color.RED != this.JDFecha.getDateEditor().getUiComponent().getForeground()) {
                if (!this.JTFFResultado.getText().isEmpty()) {
                    if (!this.JEPObservacion.getText().isEmpty() && this.JEPObservacion.getText() != null) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            this.xsql = "insert into `p_resultado_examenes` (`Id_Atencion`, `Id_Usuario_Programa`, `Id_pdemanda_inducida`, `Id_Profesional`, `Id_Especialidad`, `FechaRes`, `Resultado`, `Observacion`,EsIngreso, `UsuarioS`) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xidexamen[this.JCBExamen.getSelectedIndex()][0] + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMD1.format(this.JDFecha.getDate()) + "','" + this.JTFFResultado.getText() + "','" + this.JEPObservacion.getText() + "','" + this.xEsIngreso + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            mCargarDatos();
                            this.JCBExamen.setSelectedIndex(-1);
                            this.JTFFResultado.setText("");
                            this.JEPObservacion.setText("");
                            this.JCBExamen.requestFocus();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "La observación no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JEPObservacion.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Resultado no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFResultado.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBExamen.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un exámen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBExamen.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Exámen", "Resultado", "Observación", "Especialidad", "Profesional", "Es Ingreso"}) { // from class: Historia.JP_CP_ResultadoExamenes1.6
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBHistorico.setModel(this.xmodelo);
        this.JTBHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBHistorico.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTBHistorico.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBHistorico.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTBHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBHistorico.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTBHistorico.getColumnModel().getColumn(7).setPreferredWidth(5);
    }

    private void mCargarDatos() {
        try {
            this.xsql = "SELECT `p_resultado_examenes`.`Id`, date_format(`p_resultado_examenes`.`FechaRes`,'%d-%m-%Y') as Fecha, `p_demanda_inducida`.`Nbre`, `p_resultado_examenes`.`Resultado`, IF(`p_resultado_examenes`.`Observacion`IS NULL, ' ',`p_resultado_examenes`.`Observacion`) AS Observacion, profesional1.`Especialidad`, profesional1.`NProfesional`,EsIngreso  FROM `p_resultado_examenes` INNER JOIN `p_demanda_inducida`  ON (`p_resultado_examenes`.`Id_pdemanda_inducida` = `p_demanda_inducida`.`Id`) INNER JOIN `profesional1`  ON (`p_resultado_examenes`.`Id_Profesional`= `profesional1`.`Id_Persona`) AND (`p_resultado_examenes`.`Id_Especialidad`= `profesional1`.`IdEspecialidad`) WHERE (`p_resultado_examenes`.`Id_Usuario_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `p_resultado_examenes`.`Estado` =1) ORDER BY `p_demanda_inducida`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearTabla();
            int x = 0;
            while (xrs.next()) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), x, 0);
                this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                this.xmodelo.setValueAt(xrs.getString(4), x, 3);
                this.xmodelo.setValueAt(xrs.getString(5), x, 4);
                this.xmodelo.setValueAt(xrs.getString(6), x, 5);
                this.xmodelo.setValueAt(xrs.getString(7), x, 6);
                this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), x, 7);
                x++;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_CP_ResultadoExamenes1.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
