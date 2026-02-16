package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFHistoricoSalarioMinimo.class */
public class JIFFHistoricoSalarioMinimo extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private Double xVSDiario;
    private Double xVDia;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPComentario;
    private JScrollPane JSPDetalle;
    private JSpinner JSPorcentajeAumento;
    private JTextArea JTAComentario;
    private JTable JTDetalle;
    private JYearChooser JTFAnio;
    private JTextField JTFVSalarioDiario;
    private JTextField JTFVSalarioMensual;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private int xEstado = 1;

    public JIFFHistoricoSalarioMinimo() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        this.JSPorcentajeAumento.setValue(new Integer(0));
        this.JTFVSalarioMensual.setText("");
        this.JTFVSalarioDiario.setText("");
        this.JTAComentario.setText("");
        this.JCHEstado.setSelected(false);
        mCargarDatosTabla();
        this.xEstado = 1;
        Principal.txtNo.setText("");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Año", "VSMensual", "VSDiario", "PAumento", "Comentario", "Estado"}) { // from class: ParametrizacionN.JIFFHistoricoSalarioMinimo.1
            Class[] types = {Integer.class, String.class, Double.class, Double.class, Double.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs("SELECT `Id`,`Ano`,`VSMensual`,`VSDiario`,`PAumento`,`Comentario`,`Estado` FROM `g_historico_salario_minimo` ");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSSuministroxBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCHEstado = new JCheckBox();
        this.JSPorcentajeAumento = new JSpinner();
        this.JSPComentario = new JScrollPane();
        this.JTAComentario = new JTextArea();
        this.JTFVSalarioMensual = new JTextField();
        this.JTFVSalarioDiario = new JTextField();
        this.JTFAnio = new JYearChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("HISTORICO SALARIO MÍNIMO");
        setName("xJIFFHistoricoSalarioMinimo");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFHistoricoSalarioMinimo.2
            public void actionPerformed(ActionEvent evt) {
                JIFFHistoricoSalarioMinimo.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPorcentajeAumento.setFont(new Font("Arial", 1, 12));
        this.JSPorcentajeAumento.setModel(new SpinnerNumberModel(Double.valueOf(0.0d), (Comparable) null, (Comparable) null, Double.valueOf(1.0d)));
        this.JSPorcentajeAumento.setToolTipText("Porcentaje Aumento");
        this.JSPorcentajeAumento.setBorder(BorderFactory.createTitledBorder((Border) null, "PAumento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPComentario.setBorder(BorderFactory.createTitledBorder((Border) null, "Comentario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPComentario.setAutoscrolls(true);
        this.JTAComentario.setColumns(20);
        this.JTAComentario.setFont(new Font("Arial", 1, 12));
        this.JTAComentario.setLineWrap(true);
        this.JTAComentario.setRows(1);
        this.JTAComentario.setTabSize(1);
        this.JSPComentario.setViewportView(this.JTAComentario);
        this.JTFVSalarioMensual.setFont(new Font("Arial", 1, 12));
        this.JTFVSalarioMensual.setHorizontalAlignment(4);
        this.JTFVSalarioMensual.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Salario Mensual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFVSalarioMensual.addFocusListener(new FocusAdapter() { // from class: ParametrizacionN.JIFFHistoricoSalarioMinimo.3
            public void focusLost(FocusEvent evt) {
                JIFFHistoricoSalarioMinimo.this.JTFVSalarioMensualFocusLost(evt);
            }
        });
        this.JTFVSalarioMensual.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFFHistoricoSalarioMinimo.4
            public void keyTyped(KeyEvent evt) {
                JIFFHistoricoSalarioMinimo.this.JTFVSalarioMensualKeyTyped(evt);
            }
        });
        this.JTFVSalarioDiario.setFont(new Font("Arial", 1, 12));
        this.JTFVSalarioDiario.setHorizontalAlignment(4);
        this.JTFVSalarioDiario.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Salario Diario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAnio.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAnio.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JSPComentario, -2, 502, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado, -2, 91, -2)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFAnio, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFVSalarioMensual, -2, 174, -2).addGap(18, 18, 18).addComponent(this.JTFVSalarioDiario, -2, 174, -2).addGap(18, 18, 18).addComponent(this.JSPorcentajeAumento, -2, 100, -2))).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap(18, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFAnio, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFVSalarioMensual, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFVSalarioDiario).addComponent(this.JSPorcentajeAumento, -2, 50, -2))).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(41, 41, 41).addComponent(this.JCHEstado).addContainerGap(57, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.JSPComentario, -2, 79, -2).addGap(16, 16, 16)))));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFHistoricoSalarioMinimo.5
            public void mouseClicked(MouseEvent evt) {
                JIFFHistoricoSalarioMinimo.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPIDatos, -2, -1, -2).addGap(14, 14, 14).addComponent(this.JSPDetalle, -2, 276, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFAnio.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString()).intValue());
            this.JTFVSalarioMensual.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFVSalarioDiario.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JSPorcentajeAumento.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JTAComentario.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVSalarioMensualFocusLost(FocusEvent evt) {
        mCalcularSalDiario();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFVSalarioMensualKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFVSalarioMensual.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFVSalarioMensual.requestFocus();
        }
    }

    private void mCalcularSalDiario() {
        if (!this.JTFVSalarioMensual.getText().isEmpty()) {
            this.xVSDiario = Double.valueOf(Double.parseDouble(this.JTFVSalarioMensual.getText()));
            this.xVDia = Double.valueOf(this.xVSDiario.doubleValue() / 30.0d);
            this.JTFVSalarioDiario.setText("" + this.xVDia);
            return;
        }
        this.JTFVSalarioDiario.setText("0");
    }

    public void mGrabar() {
        String sql;
        if (!this.JTFVSalarioMensual.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    sql = "INSERT INTO  g_historico_salario_minimo (Ano, VSDiario, VSMensual, PAumento, Comentario, Estado, UsuarioS)  values ('" + this.JTFAnio.getValue() + "','" + this.JTFVSalarioDiario.getText() + "','" + this.JTFVSalarioMensual.getText() + "','" + this.JSPorcentajeAumento.getValue() + "','" + this.JTAComentario.getText() + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    sql = "UPDATE g_historico_salario_minimo SET VSDiario = '" + this.JTFVSalarioDiario.getText() + "', VSMensual = '" + this.JTFVSalarioMensual.getText() + "', PAumento = '" + this.JSPorcentajeAumento.getValue() + "', Comentario = '" + this.JTAComentario.getText() + "', Estado = '" + this.xEstado + "', UsuarioS = '" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE Id = '" + Principal.txtNo.getText() + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe Ingresar el Valor Salario Mensual", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFVSalarioMensual.requestFocus();
    }
}
