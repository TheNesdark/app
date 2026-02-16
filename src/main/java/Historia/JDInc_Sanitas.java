package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDInc_Sanitas.class */
public class JDInc_Sanitas extends JDialog {
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String xidIncapacidad;
    private ButtonGroup ActDeportiva;
    private ButtonGroup ActividadJefe;
    private ButtonGroup Afiliado;
    private JButton JBGuardar;
    private JButton JBImprimir;
    private JRadioButton JRBDentroEmpr;
    private JRadioButton JRBDependiente;
    private JRadioButton JRBFueraEmpr;
    private JRadioButton JRBIndependiente;
    private JRadioButton JRBNoARL;
    private JRadioButton JRBNoDeportiva;
    private JRadioButton JRBNoEmpleador;
    private JRadioButton JRBNoOcurrencia;
    private JRadioButton JRBNoTrasporte;
    private JRadioButton JRBSiARL;
    private JRadioButton JRBSiDeportiva;
    private JRadioButton JRBSiEmpleador;
    private JRadioButton JRBSiOcurrencia;
    private JRadioButton JRBSiTrasporte;
    private JTextField JTFCualArl;
    private ButtonGroup LugarHechos;
    private ButtonGroup TipoAfiliacion;
    private ButtonGroup TraOcurrencia;
    private ButtonGroup Trasporte;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    public JDateChooser txtFecha;
    public JFormattedTextField txtHora;

    public JDInc_Sanitas(Frame parent, boolean modal, String xidIncapacidad) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("INVESTIGACIÓN DEL ORIGEN DE LA INCAPACIDAD");
        setLocationRelativeTo(null);
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.txtHora.setValue(this.xmt.getFechaActual());
        this.xidIncapacidad = xidIncapacidad;
        mBuscar();
    }

    private void initComponents() {
        this.TipoAfiliacion = new ButtonGroup();
        this.Afiliado = new ButtonGroup();
        this.TraOcurrencia = new ButtonGroup();
        this.LugarHechos = new ButtonGroup();
        this.ActividadJefe = new ButtonGroup();
        this.Trasporte = new ButtonGroup();
        this.ActDeportiva = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JRBDependiente = new JRadioButton();
        this.JRBIndependiente = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.JRBSiARL = new JRadioButton();
        this.JRBNoARL = new JRadioButton();
        this.JTFCualArl = new JTextField();
        this.jPanel3 = new JPanel();
        this.jLabel1 = new JLabel();
        this.JRBSiOcurrencia = new JRadioButton();
        this.JRBNoOcurrencia = new JRadioButton();
        this.jPanel4 = new JPanel();
        this.txtHora = new JFormattedTextField();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.jLabel2 = new JLabel();
        this.JRBDentroEmpr = new JRadioButton();
        this.JRBFueraEmpr = new JRadioButton();
        this.jLabel3 = new JLabel();
        this.JRBSiEmpleador = new JRadioButton();
        this.JRBNoEmpleador = new JRadioButton();
        this.jLabel4 = new JLabel();
        this.JRBSiTrasporte = new JRadioButton();
        this.JRBNoTrasporte = new JRadioButton();
        this.jLabel5 = new JLabel();
        this.JRBSiDeportiva = new JRadioButton();
        this.JRBNoDeportiva = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.JBGuardar = new JButton();
        this.JBImprimir = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Afiliación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.TipoAfiliacion.add(this.JRBDependiente);
        this.JRBDependiente.setFont(new Font("Arial", 1, 12));
        this.JRBDependiente.setSelected(true);
        this.JRBDependiente.setText("Dependiente");
        this.JRBDependiente.setName("0");
        this.TipoAfiliacion.add(this.JRBIndependiente);
        this.JRBIndependiente.setFont(new Font("Arial", 1, 12));
        this.JRBIndependiente.setText("independiente");
        this.JRBIndependiente.setName("1");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBDependiente).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBIndependiente).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDependiente).addComponent(this.JRBIndependiente)).addGap(3, 3, 3)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Esta Afiliado a una ARL?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.Afiliado.add(this.JRBSiARL);
        this.JRBSiARL.setFont(new Font("Arial", 1, 12));
        this.JRBSiARL.setSelected(true);
        this.JRBSiARL.setText("Sí");
        this.JRBSiARL.setName("1");
        this.Afiliado.add(this.JRBNoARL);
        this.JRBNoARL.setFont(new Font("Arial", 1, 12));
        this.JRBNoARL.setText("No");
        this.JRBNoARL.setName("0");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBSiARL).addGap(18, 18, 18).addComponent(this.JRBNoARL).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiARL).addComponent(this.JRBNoARL)).addGap(3, 3, 3)));
        this.JTFCualArl.setFont(new Font("Arial", 1, 12));
        this.JTFCualArl.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuál?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "CUESTIONARIO DE INVESTIGACIÓN", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Estaba trabajando en el momento de la ocurrencia de los hechos?");
        this.TraOcurrencia.add(this.JRBSiOcurrencia);
        this.JRBSiOcurrencia.setFont(new Font("Arial", 1, 12));
        this.JRBSiOcurrencia.setSelected(true);
        this.JRBSiOcurrencia.setText("Sí");
        this.JRBSiOcurrencia.setName("1");
        this.TraOcurrencia.add(this.JRBNoOcurrencia);
        this.JRBNoOcurrencia.setFont(new Font("Arial", 1, 12));
        this.JRBNoOcurrencia.setText("No");
        this.JRBNoOcurrencia.setName("0");
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha y Hora de los hechos", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Historia.JDInc_Sanitas.1
            public void keyPressed(KeyEvent evt) {
                JDInc_Sanitas.this.txtHoraKeyPressed(evt);
            }
        });
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Historia.JDInc_Sanitas.2
            public void keyPressed(KeyEvent evt) {
                JDInc_Sanitas.this.txtFechaKeyPressed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtHora, -2, 110, -2).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 50, -2).addGap(0, 0, 32767)).addComponent(this.txtHora));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Lugar en que se presentaron los hechos:");
        this.LugarHechos.add(this.JRBDentroEmpr);
        this.JRBDentroEmpr.setFont(new Font("Arial", 1, 12));
        this.JRBDentroEmpr.setSelected(true);
        this.JRBDentroEmpr.setText("Dentro de la empresa");
        this.JRBDentroEmpr.setName("0");
        this.LugarHechos.add(this.JRBFueraEmpr);
        this.JRBFueraEmpr.setFont(new Font("Arial", 1, 12));
        this.JRBFueraEmpr.setText("Fuera de la empresa");
        this.JRBFueraEmpr.setName("1");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Desarrollaba una actividad ordenada por su empleador o jefe inmediato?");
        this.ActividadJefe.add(this.JRBSiEmpleador);
        this.JRBSiEmpleador.setFont(new Font("Arial", 1, 12));
        this.JRBSiEmpleador.setSelected(true);
        this.JRBSiEmpleador.setText("Sí");
        this.JRBSiEmpleador.setName("1");
        this.ActividadJefe.add(this.JRBNoEmpleador);
        this.JRBNoEmpleador.setFont(new Font("Arial", 1, 12));
        this.JRBNoEmpleador.setText("No");
        this.JRBNoEmpleador.setName("0");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("Se trasladaba en medio de transporte costeado o asumido por su empresa?");
        this.Trasporte.add(this.JRBSiTrasporte);
        this.JRBSiTrasporte.setFont(new Font("Arial", 1, 12));
        this.JRBSiTrasporte.setText("Sí");
        this.JRBSiTrasporte.setName("1");
        this.Trasporte.add(this.JRBNoTrasporte);
        this.JRBNoTrasporte.setFont(new Font("Arial", 1, 12));
        this.JRBNoTrasporte.setSelected(true);
        this.JRBNoTrasporte.setText("No");
        this.JRBNoTrasporte.setName("0");
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setText("Participaba en actividad deportiva representando a su empresa ?");
        this.ActDeportiva.add(this.JRBSiDeportiva);
        this.JRBSiDeportiva.setFont(new Font("Arial", 1, 12));
        this.JRBSiDeportiva.setText("Sí");
        this.JRBSiDeportiva.setName("1");
        this.ActDeportiva.add(this.JRBNoDeportiva);
        this.JRBNoDeportiva.setFont(new Font("Arial", 1, 12));
        this.JRBNoDeportiva.setSelected(true);
        this.JRBNoDeportiva.setText("No");
        this.JRBNoDeportiva.setName("0");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.JRBSiOcurrencia).addGap(18, 18, 18).addComponent(this.JRBNoOcurrencia))).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDentroEmpr).addGap(5, 5, 5).addComponent(this.JRBFueraEmpr)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSiEmpleador).addGap(5, 5, 5).addComponent(this.JRBNoEmpleador)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSiTrasporte).addGap(5, 5, 5).addComponent(this.JRBNoTrasporte)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSiDeportiva).addGap(5, 5, 5).addComponent(this.JRBNoDeportiva))).addGap(0, 0, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.JRBSiOcurrencia).addComponent(this.JRBNoOcurrencia)).addGap(5, 5, 5).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.JRBDentroEmpr).addComponent(this.JRBFueraEmpr)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JRBSiEmpleador).addComponent(this.JRBNoEmpleador)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.JRBSiTrasporte).addComponent(this.JRBNoTrasporte)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiDeportiva).addComponent(this.JRBNoDeportiva)).addComponent(this.jLabel5)).addContainerGap(-1, 32767)));
        this.jTextArea1.setColumns(1);
        this.jTextArea1.setFont(new Font("Arial", 1, 12));
        this.jTextArea1.setLineWrap(true);
        this.jTextArea1.setRows(1);
        this.jTextArea1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación Médica", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.jTextArea1);
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Historia.JDInc_Sanitas.3
            public void actionPerformed(ActionEvent evt) {
                JDInc_Sanitas.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JBImprimir.setFont(new Font("Arial", 1, 12));
        this.JBImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBImprimir.setText("Imprimir");
        this.JBImprimir.addActionListener(new ActionListener() { // from class: Historia.JDInc_Sanitas.4
            public void actionPerformed(ActionEvent evt) {
                JDInc_Sanitas.this.JBImprimirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCualArl)).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.JBGuardar, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBImprimir, -2, 261, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCualArl).addComponent(this.jPanel2, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 61, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBImprimir, -1, -1, 32767).addComponent(this.JBGuardar, -1, -1, 32767)).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mActualizar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImprimirActionPerformed(ActionEvent evt) {
        mImprimir();
    }

    private void mActualizar() {
        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "UPDATE `h_incapacidad`  SET  `TipoAfiliacion` = '" + OptionButton(this.TipoAfiliacion) + "',`AfiARL` = '" + OptionButton(this.Afiliado) + "',`CualARL` = '" + this.JTFCualArl.getText() + "',`P1` = '" + OptionButton(this.TraOcurrencia) + "',   `P2` = '" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "',`P3` = '" + this.xmt.formatoH24.format(this.txtHora.getValue()) + "',`P4` = '" + OptionButton(this.LugarHechos) + "',`P5` = '" + OptionButton(this.ActividadJefe) + "',`P6` = '" + OptionButton(this.Trasporte) + "',`P7` = '" + OptionButton(this.ActDeportiva) + "',`ObservacionMed` = '" + this.jTextArea1.getText() + "',FechaRegistroSanitas= '" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' WHERE `Id` = '" + this.xidIncapacidad + "' ";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
        }
    }

    private String OptionButton(ButtonGroup buttonGroup1) {
        String xValor = "0";
        Enumeration e = buttonGroup1.getElements();
        while (e.hasMoreElements()) {
            JRadioButton r = (JRadioButton) e.nextElement();
            if (r.isSelected()) {
                xValor = r.getName();
            }
        }
        return xValor;
    }

    private void mBuscar() {
        String sql = "SELECT `TipoAfiliacion`, `AfiARL`, `CualARL`,`P1`,`P2`,`P3`,`P4`,`P5`,`P6`,`P7`,   `ObservacionMed` FROM `h_incapacidad` WHERE (Id='" + this.xidIncapacidad + "')";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getInt(1) == 0) {
                    this.JRBDependiente.setSelected(true);
                } else {
                    this.JRBIndependiente.setSelected(true);
                }
                if (xrs.getInt("AfiARL") == 0) {
                    this.JRBNoARL.setSelected(true);
                } else {
                    this.JRBSiARL.setSelected(true);
                }
                this.JTFCualArl.setText(xrs.getString("CualARL"));
                if (xrs.getInt("P1") == 0) {
                    this.JRBNoOcurrencia.setSelected(true);
                } else {
                    this.JRBSiOcurrencia.setSelected(true);
                }
                if (xrs.getDate("P2") == null) {
                    this.txtFecha.setDate(this.xmt.getFechaActual());
                } else {
                    this.txtFecha.setDate(xrs.getDate("P2"));
                }
                if (xrs.getDate("P3") == null) {
                    this.txtHora.setValue(this.xmt.getFechaActual());
                } else {
                    this.txtHora.setText(xrs.getString("P3"));
                }
                if (xrs.getInt("P4") == 0) {
                    this.JRBDentroEmpr.setSelected(true);
                } else {
                    this.JRBFueraEmpr.setSelected(true);
                }
                if (xrs.getInt("P5") == 0) {
                    this.JRBNoEmpleador.setSelected(true);
                } else {
                    this.JRBSiEmpleador.setSelected(true);
                }
                if (xrs.getInt("P6") == 0) {
                    this.JRBNoTrasporte.setSelected(true);
                } else {
                    this.JRBSiTrasporte.setSelected(true);
                }
                if (xrs.getInt("P7") == 0) {
                    this.JRBNoDeportiva.setSelected(true);
                } else {
                    this.JRBSiDeportiva.setSelected(true);
                }
                this.jTextArea1.setText(xrs.getString("ObservacionMed"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDInc_Sanitas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "IdIncapacidad";
        mparametros[0][1] = this.xidIncapacidad;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_IncapacidadSanitas", mparametros);
    }
}
