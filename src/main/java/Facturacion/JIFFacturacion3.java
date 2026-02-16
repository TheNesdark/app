package Facturacion;

import Utilidades.ConsultasMySQL;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFFacturacion3.class */
public class JIFFacturacion3 extends JInternalFrame {
    public String[] idEmpresa;
    public String[] idTipoDocumento;
    public String[] idLugarExpedicion;
    public String[] idEtnico;
    public String[] idSexo;
    public String[] idMunicipio;
    public String[] idMunicipioNac;
    public String[] idEstadoCivil;
    public String[] idArl;
    public String[] idEspecialidad;
    public String[] idProfesional;
    public String[][] listaEmpresa;
    public String[][] lisEmpresa;
    public String[][] idestrato;
    private DefaultTableModel modcombos;
    public JComboBox JCBArl;
    public JComboBox JCBArl1;
    public JComboBox JCBCargo;
    public JComboBox JCBCargo1;
    public JComboBox JCBConvenio;
    public JTableComboBox JCBEscolaridad;
    public JTableComboBox JCBEscolaridad1;
    public JComboBox JCBEstadoCivil;
    private JComboBox<String> JCBExamen;
    private JComboBox<String> JCBGrupoEtnico;
    public JComboBox JCBJornada;
    public JComboBox JCBJornada1;
    public JComboBox JCBLNacimiento;
    public JComboBox JCBLresiencia;
    private JComboBox<String> JCBLugarExpedicion;
    private JComboBox<String> JCBSexo;
    private JComboBox<String> JCBSexo3;
    private JComboBox<String> JCBTipoDocumento;
    private JScrollPane JSPDatosTabla;
    public JSpinner JSPNHijos;
    public JSpinner JSPNHorasTrabajadas;
    private JTextField JTFResponsable;
    private JTextField JTFResponsable1;
    private JTextField JTFResponsable10;
    private JTextField JTFResponsable11;
    private JTextField JTFResponsable2;
    private JTextField JTFResponsable3;
    private JTextField JTFResponsable4;
    private JTextField JTFResponsable5;
    private JTextField JTFResponsable6;
    private JTextField JTFResponsable7;
    private JTextField JTFResponsable8;
    private JTextField JTFResponsable9;
    private JButton btnAdicionar;
    public JCheckBox btnNegativo;
    public JCheckBox btnPositivo;
    public JComboBox cboBarrio;
    public JComboBox cboEps;
    public JComboBox cboEspecialidad;
    public JComboBox cboEstrato1;
    public JDateChooser cboFechaNacimiento;
    public JTableComboBox cboProcedSuministro;
    public JComboBox cboProfesional;
    public JComboBox cboSangre;
    public JComboBox cboTipoEmpresa;
    public JTable gridDetalle;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTextArea jTextArea1;
    public JPanel panelGrupoSangre;
    public JFormattedTextField txtCantidad;
    public JTextField txtCodigo;
    public JTextField txtEdad;
    public JDateChooser txtFecha;
    public JDateChooser txtFecha1;
    public JFormattedTextField txtHora;
    private JFormattedTextField txtVrTotal;
    private JFormattedTextField txtVrUnitario;
    private ConsultasMySQL consulta = new ConsultasMySQL();
    public String sql = "";

    public JIFFacturacion3() {
        initComponents();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBExamen = new JComboBox<>();
        this.JTFResponsable = new JTextField();
        this.txtFecha = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.txtHora = new JFormattedTextField();
        this.JCBConvenio = new JComboBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel4 = new JPanel();
        this.cboTipoEmpresa = new JComboBox();
        this.JCBCargo = new JComboBox();
        this.JCBJornada = new JComboBox();
        this.JSPNHorasTrabajadas = new JSpinner();
        this.JTFResponsable5 = new JTextField();
        this.JTFResponsable6 = new JTextField();
        this.JTFResponsable7 = new JTextField();
        this.JCBCargo1 = new JComboBox();
        this.JCBJornada1 = new JComboBox();
        this.jPanel5 = new JPanel();
        this.txtFecha1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.txtCodigo = new JTextField();
        try {
            this.cboProcedSuministro = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e1) {
            e1.printStackTrace();
        }
        this.txtCantidad = new JFormattedTextField();
        this.txtVrUnitario = new JFormattedTextField();
        this.txtVrTotal = new JFormattedTextField();
        this.btnAdicionar = new JButton();
        this.JSPDatosTabla = new JScrollPane();
        this.gridDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.cboEspecialidad = new JComboBox();
        this.cboProfesional = new JComboBox();
        this.JTFResponsable4 = new JTextField();
        this.JCBArl = new JComboBox();
        this.JTFResponsable3 = new JTextField();
        this.JTFResponsable2 = new JTextField();
        this.JSPNHijos = new JSpinner();
        this.cboEstrato1 = new JComboBox();
        try {
            this.JCBEscolaridad = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e12) {
            e12.printStackTrace();
        }
        this.cboEps = new JComboBox();
        this.JCBArl1 = new JComboBox();
        try {
            this.JCBEscolaridad1 = new JTableComboBox();
        } catch (IncompatibleLookAndFeelException e13) {
            e13.printStackTrace();
        }
        this.panelGrupoSangre = new JPanel();
        this.cboSangre = new JComboBox();
        this.btnNegativo = new JCheckBox();
        this.btnPositivo = new JCheckBox();
        this.JCBEstadoCivil = new JComboBox();
        this.JCBLNacimiento = new JComboBox();
        this.cboBarrio = new JComboBox();
        this.JCBLresiencia = new JComboBox();
        this.JCBSexo = new JComboBox<>();
        this.JCBTipoDocumento = new JComboBox<>();
        this.JTFResponsable1 = new JTextField();
        this.JCBLugarExpedicion = new JComboBox<>();
        this.JCBSexo3 = new JComboBox<>();
        this.JTFResponsable8 = new JTextField();
        this.JTFResponsable9 = new JTextField();
        this.JTFResponsable10 = new JTextField();
        this.JTFResponsable11 = new JTextField();
        this.cboFechaNacimiento = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.txtEdad = new JTextField();
        this.JCBGrupoEtnico = new JComboBox<>();
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(""));
        this.JCBExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Examen:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.1
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsableMouseClicked(evt);
            }
        });
        this.JTFResponsable.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.2
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsableActionPerformed(evt);
            }
        });
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFFacturacion3.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFacturacion3.this.txtFechaPropertyChange(evt);
            }
        });
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFFacturacion3.4
            public void keyPressed(KeyEvent evt) {
                JIFFacturacion3.this.txtFechaKeyPressed(evt);
            }
        });
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFFacturacion3.5
            public void keyPressed(KeyEvent evt) {
                JIFFacturacion3.this.txtHoraKeyPressed(evt);
            }
        });
        this.JCBConvenio.setFont(new Font("Arial", 1, 12));
        this.JCBConvenio.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenio a Facturar", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBConvenio.addItemListener(new ItemListener() { // from class: Facturacion.JIFFacturacion3.6
            public void itemStateChanged(ItemEvent evt) {
                JIFFacturacion3.this.JCBConvenioItemStateChanged(evt);
            }
        });
        this.JCBConvenio.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.7
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JCBConvenioMouseClicked(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBConvenio, -2, 287, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBExamen, -2, 214, -2).addGap(18, 18, 18).addComponent(this.JTFResponsable).addGap(18, 18, 18).addComponent(this.txtFecha, -2, 130, -2).addGap(28, 28, 28).addComponent(this.txtHora, -2, 110, -2).addGap(29, 29, 29)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.txtHora, -2, -1, -2)).addComponent(this.txtFecha, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConvenio).addComponent(this.JCBExamen, -2, 41, -2).addComponent(this.JTFResponsable, -2, -1, -2)))).addGap(10, 10, 10)));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.jPanel4.setFont(new Font("Arial", 1, 12));
        this.cboTipoEmpresa.setFont(new Font("Arial", 1, 12));
        this.cboTipoEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.cboTipoEmpresa.addItemListener(new ItemListener() { // from class: Facturacion.JIFFacturacion3.8
            public void itemStateChanged(ItemEvent evt) {
                JIFFacturacion3.this.cboTipoEmpresaItemStateChanged(evt);
            }
        });
        this.JCBCargo.setFont(new Font("Arial", 1, 12));
        this.JCBCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBJornada.setFont(new Font("Arial", 1, 12));
        this.JCBJornada.setToolTipText("");
        this.JCBJornada.setBorder(BorderFactory.createTitledBorder((Border) null, "Jornada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPNHorasTrabajadas.setFont(new Font("Arial", 1, 12));
        this.JSPNHorasTrabajadas.setToolTipText("Horas Trabajadas");
        this.JSPNHorasTrabajadas.setBorder(BorderFactory.createTitledBorder((Border) null, "Horas Trab.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFResponsable5.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable5.setBorder(BorderFactory.createTitledBorder((Border) null, "EPP?:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable5.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.9
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable5MouseClicked(evt);
            }
        });
        this.JTFResponsable5.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.10
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable5ActionPerformed(evt);
            }
        });
        this.JTFResponsable6.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable6.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividades  del Cargo Actual:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable6.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.11
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable6MouseClicked(evt);
            }
        });
        this.JTFResponsable6.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.12
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable6ActionPerformed(evt);
            }
        });
        this.JTFResponsable7.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable7.setBorder(BorderFactory.createTitledBorder((Border) null, "Antiguedad:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable7.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.13
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable7MouseClicked(evt);
            }
        });
        this.JTFResponsable7.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.14
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable7ActionPerformed(evt);
            }
        });
        this.JCBCargo1.setFont(new Font("Arial", 1, 12));
        this.JCBCargo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Calificacion:", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBJornada1.setFont(new Font("Arial", 1, 12));
        this.JCBJornada1.setToolTipText("");
        this.JCBJornada1.setBorder(BorderFactory.createTitledBorder((Border) null, "Riesgo::", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.cboTipoEmpresa, -2, 207, -2).addComponent(this.JTFResponsable7, -2, 205, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCBCargo, -2, 218, -2).addGap(18, 18, 18).addComponent(this.JCBJornada, -2, 160, -2)).addComponent(this.JTFResponsable6)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JSPNHorasTrabajadas, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFResponsable5)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCBCargo1, -2, 218, -2).addGap(18, 18, 18).addComponent(this.JCBJornada1, 0, 258, 32767))).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(43, 43, 43).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboTipoEmpresa, -2, -1, -2).addComponent(this.JCBCargo, -2, -1, -2).addComponent(this.JCBJornada, -2, -1, -2).addComponent(this.JSPNHorasTrabajadas, -2, -1, -2).addComponent(this.JTFResponsable5, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFResponsable6, -2, -1, -2).addComponent(this.JTFResponsable7, -2, -1, -2).addComponent(this.JCBCargo1, -2, -1, -2).addComponent(this.JCBJornada1, -2, -1, -2)).addContainerGap(92, 32767)));
        this.jTabbedPane1.addTab("Informacion Empleado", this.jPanel4);
        this.txtFecha1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha1.setDateFormatString("dd/MM/yyyy");
        this.txtFecha1.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setFont(new Font("Arial", 1, 12));
        this.txtCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCodigo.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFFacturacion3.15
            public void focusLost(FocusEvent evt) {
                JIFFacturacion3.this.txtCodigoFocusLost(evt);
            }
        });
        this.txtCodigo.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFFacturacion3.16
            public void keyPressed(KeyEvent evt) {
                JIFFacturacion3.this.txtCodigoKeyPressed(evt);
            }
        });
        this.cboProcedSuministro.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos y/o Suministro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboProcedSuministro.setFont(new Font("Arial", 1, 12));
        this.cboProcedSuministro.addItemListener(new ItemListener() { // from class: Facturacion.JIFFacturacion3.17
            public void itemStateChanged(ItemEvent evt) {
                JIFFacturacion3.this.cboProcedSuministroItemStateChanged(evt);
            }
        });
        this.cboProcedSuministro.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFFacturacion3.18
            public void focusLost(FocusEvent evt) {
                JIFFacturacion3.this.cboProcedSuministroFocusLost(evt);
            }
        });
        this.cboProcedSuministro.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.19
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.cboProcedSuministroMouseClicked(evt);
            }
        });
        this.cboProcedSuministro.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.20
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.cboProcedSuministroActionPerformed(evt);
            }
        });
        this.cboProcedSuministro.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFFacturacion3.21
            public void keyPressed(KeyEvent evt) {
                JIFFacturacion3.this.cboProcedSuministroKeyPressed(evt);
            }
        });
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.txtCantidad.setHorizontalAlignment(4);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFFacturacion3.22
            public void focusLost(FocusEvent evt) {
                JIFFacturacion3.this.txtCantidadFocusLost(evt);
            }
        });
        this.txtCantidad.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.23
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.txtCantidadActionPerformed(evt);
            }
        });
        this.txtCantidad.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFFacturacion3.24
            public void keyPressed(KeyEvent evt) {
                JIFFacturacion3.this.txtCantidadKeyPressed(evt);
            }
        });
        this.txtVrUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtVrUnitario.setForeground(Color.red);
        this.txtVrUnitario.setHorizontalAlignment(4);
        this.txtVrUnitario.setFont(new Font("Arial", 1, 12));
        this.txtVrUnitario.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFFacturacion3.25
            public void focusLost(FocusEvent evt) {
                JIFFacturacion3.this.txtVrUnitarioFocusLost(evt);
            }
        });
        this.txtVrUnitario.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFFacturacion3.26
            public void keyPressed(KeyEvent evt) {
                JIFFacturacion3.this.txtVrUnitarioKeyPressed(evt);
            }
        });
        this.txtVrTotal.setEditable(false);
        this.txtVrTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtVrTotal.setForeground(Color.red);
        this.txtVrTotal.setHorizontalAlignment(4);
        this.txtVrTotal.setFont(new Font("Arial", 1, 12));
        this.btnAdicionar.setFont(new Font("Arial", 1, 12));
        this.btnAdicionar.setForeground(Color.red);
        this.btnAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAdicionar.setText("Adicionar");
        this.btnAdicionar.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.27
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.btnAdicionarActionPerformed(evt);
            }
        });
        this.btnAdicionar.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFFacturacion3.28
            public void keyPressed(KeyEvent evt) {
                JIFFacturacion3.this.btnAdicionarKeyPressed(evt);
            }
        });
        this.JSPDatosTabla.setBorder(BorderFactory.createTitledBorder((Border) null, "PROCEDIMIENTO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.gridDetalle.setFont(new Font("Arial", 1, 12));
        this.gridDetalle.setRowHeight(25);
        this.gridDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.gridDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.gridDetalle.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.29
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.gridDetalleMouseClicked(evt);
            }
        });
        this.gridDetalle.addKeyListener(new KeyAdapter() { // from class: Facturacion.JIFFacturacion3.30
            public void keyPressed(KeyEvent evt) {
                JIFFacturacion3.this.gridDetalleKeyPressed(evt);
            }
        });
        this.JSPDatosTabla.setViewportView(this.gridDetalle);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(142, 142, 142).addComponent(this.txtCodigo, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboProcedSuministro, -2, 260, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCantidad, -2, 70, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtVrUnitario, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtVrTotal, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnAdicionar, -2, 170, -2)).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDatosTabla, -2, 1024, -2))).addContainerGap(100, 32767)).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.txtFecha1, -2, 120, -2).addContainerGap(1004, 32767))));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(31, 31, 31).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtCodigo, -2, 50, -2).addComponent(this.cboProcedSuministro, -2, 50, -2).addComponent(this.txtCantidad, -1, 51, 32767).addComponent(this.txtVrUnitario, -2, 50, -2).addComponent(this.txtVrTotal, -2, 50, -2).addComponent(this.btnAdicionar, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDatosTabla, -2, 121, -2).addContainerGap()).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.txtFecha1, -2, 50, -2).addGap(152, 152, 152))));
        this.jTabbedPane1.addTab("ParaClinicos", this.jPanel5);
        this.jTextArea1.setColumns(20);
        this.jTextArea1.setRows(5);
        this.jTextArea1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.jScrollPane1.setViewportView(this.jTextArea1);
        this.cboEspecialidad.setFont(new Font("Arial", 1, 12));
        this.cboEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad que Ordena", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.cboEspecialidad.addItemListener(new ItemListener() { // from class: Facturacion.JIFFacturacion3.31
            public void itemStateChanged(ItemEvent evt) {
                JIFFacturacion3.this.cboEspecialidadItemStateChanged(evt);
            }
        });
        this.cboEspecialidad.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.32
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.cboEspecialidadActionPerformed(evt);
            }
        });
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Ordena", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.cboProfesional.addItemListener(new ItemListener() { // from class: Facturacion.JIFFacturacion3.33
            public void itemStateChanged(ItemEvent evt) {
                JIFFacturacion3.this.cboProfesionalItemStateChanged(evt);
            }
        });
        this.JTFResponsable4.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable4.setBorder(BorderFactory.createTitledBorder((Border) null, "Correo Electronico:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable4.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.34
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable4MouseClicked(evt);
            }
        });
        this.JTFResponsable4.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.35
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable4ActionPerformed(evt);
            }
        });
        this.JCBArl.setFont(new Font("Arial", 1, 12));
        this.JCBArl.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFResponsable3.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable3.setBorder(BorderFactory.createTitledBorder((Border) null, "Telefono:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable3.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.36
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable3MouseClicked(evt);
            }
        });
        this.JTFResponsable3.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.37
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable3ActionPerformed(evt);
            }
        });
        this.JTFResponsable2.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable2.setBorder(BorderFactory.createTitledBorder((Border) null, "Dirrecion:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable2.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.38
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable2MouseClicked(evt);
            }
        });
        this.JTFResponsable2.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.39
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable2ActionPerformed(evt);
            }
        });
        this.JSPNHijos.setFont(new Font("Arial", 1, 12));
        this.JSPNHijos.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Hijos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboEstrato1.setFont(new Font("Arial", 1, 12));
        this.cboEstrato1.setBorder(BorderFactory.createTitledBorder((Border) null, "Estrato", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.cboEstrato1.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.40
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.cboEstrato1ActionPerformed(evt);
            }
        });
        this.JCBEscolaridad.setBorder(BorderFactory.createTitledBorder((Border) null, "Escolaridad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBEscolaridad.setFont(new Font("Arial", 1, 12));
        this.JCBEscolaridad.setShowTableGrid(true);
        this.JCBEscolaridad.setShowTableHeaders(true);
        this.JCBEscolaridad.addItemListener(new ItemListener() { // from class: Facturacion.JIFFacturacion3.41
            public void itemStateChanged(ItemEvent evt) {
                JIFFacturacion3.this.JCBEscolaridadItemStateChanged(evt);
            }
        });
        this.cboEps.setFont(new Font("Arial", 1, 12));
        this.cboEps.setBorder(BorderFactory.createTitledBorder((Border) null, "E.P.S.", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBArl1.setFont(new Font("Arial", 1, 12));
        this.JCBArl1.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBArl1.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.42
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JCBArl1ActionPerformed(evt);
            }
        });
        this.JCBEscolaridad1.setBorder(BorderFactory.createTitledBorder((Border) null, "Pensiones:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBEscolaridad1.setFont(new Font("Arial", 1, 12));
        this.JCBEscolaridad1.setShowTableGrid(true);
        this.JCBEscolaridad1.setShowTableHeaders(true);
        this.JCBEscolaridad1.addItemListener(new ItemListener() { // from class: Facturacion.JIFFacturacion3.43
            public void itemStateChanged(ItemEvent evt) {
                JIFFacturacion3.this.JCBEscolaridad1ItemStateChanged(evt);
            }
        });
        this.panelGrupoSangre.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Sanguineo", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.panelGrupoSangre.setForeground(new Color(0, 0, 204));
        this.cboSangre.setFont(new Font("Arial", 1, 12));
        this.cboSangre.setModel(new DefaultComboBoxModel(new String[]{"-", "A", "B", "O", "AB"}));
        this.cboSangre.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.44
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.cboSangreActionPerformed(evt);
            }
        });
        this.btnNegativo.setFont(new Font("Arial", 1, 12));
        this.btnNegativo.setForeground(new Color(0, 0, 204));
        this.btnNegativo.setText("Negativo");
        this.btnNegativo.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.45
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.btnNegativoActionPerformed(evt);
            }
        });
        this.btnPositivo.setFont(new Font("Arial", 1, 12));
        this.btnPositivo.setForeground(new Color(0, 0, 204));
        this.btnPositivo.setText("Positivo");
        this.btnPositivo.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.46
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.btnPositivoActionPerformed(evt);
            }
        });
        GroupLayout panelGrupoSangreLayout = new GroupLayout(this.panelGrupoSangre);
        this.panelGrupoSangre.setLayout(panelGrupoSangreLayout);
        panelGrupoSangreLayout.setHorizontalGroup(panelGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelGrupoSangreLayout.createSequentialGroup().addComponent(this.cboSangre, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnNegativo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnPositivo)));
        panelGrupoSangreLayout.setVerticalGroup(panelGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(panelGrupoSangreLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboSangre, -2, 29, -2).addComponent(this.btnPositivo).addComponent(this.btnNegativo)));
        this.JCBEstadoCivil.setFont(new Font("Arial", 1, 12));
        this.JCBEstadoCivil.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado Civil:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBLNacimiento.setFont(new Font("Arial", 1, 10));
        this.JCBLNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar de Nacimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.cboBarrio.setFont(new Font("Arial", 1, 12));
        this.cboBarrio.setBorder(BorderFactory.createTitledBorder((Border) null, "Barrio:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBLresiencia.setFont(new Font("Arial", 1, 10));
        this.JCBLresiencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar de Residencia:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBLresiencia.addItemListener(new ItemListener() { // from class: Facturacion.JIFFacturacion3.47
            public void itemStateChanged(ItemEvent evt) {
                JIFFacturacion3.this.JCBLresienciaItemStateChanged(evt);
            }
        });
        this.JCBSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable1.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable1.setBorder(BorderFactory.createTitledBorder((Border) null, "Numero Identificacion:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable1.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.48
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable1MouseClicked(evt);
            }
        });
        this.JTFResponsable1.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.49
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable1ActionPerformed(evt);
            }
        });
        this.JCBLugarExpedicion.setBorder(BorderFactory.createTitledBorder((Border) null, "Luegar de Expedicion:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JCBSexo3.setFont(new Font("Arial", 1, 12));
        this.JCBSexo3.setBorder(BorderFactory.createTitledBorder((Border) null, "Discapacidad:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable8.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable8.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable8.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.50
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable8MouseClicked(evt);
            }
        });
        this.JTFResponsable8.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.51
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable8ActionPerformed(evt);
            }
        });
        this.JTFResponsable9.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable9.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable9.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.52
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable9MouseClicked(evt);
            }
        });
        this.JTFResponsable9.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.53
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable9ActionPerformed(evt);
            }
        });
        this.JTFResponsable10.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable10.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable10.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.54
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable10MouseClicked(evt);
            }
        });
        this.JTFResponsable10.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.55
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable10ActionPerformed(evt);
            }
        });
        this.JTFResponsable11.setFont(new Font("Arial", 1, 12));
        this.JTFResponsable11.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.JTFResponsable11.addMouseListener(new MouseAdapter() { // from class: Facturacion.JIFFacturacion3.56
            public void mouseClicked(MouseEvent evt) {
                JIFFacturacion3.this.JTFResponsable11MouseClicked(evt);
            }
        });
        this.JTFResponsable11.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.57
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.JTFResponsable11ActionPerformed(evt);
            }
        });
        this.cboFechaNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Nacimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        this.cboFechaNacimiento.setDateFormatString("dd/MM/yyyy");
        this.cboFechaNacimiento.setFont(new Font("Arial", 1, 12));
        this.cboFechaNacimiento.setName("txtFecha");
        this.cboFechaNacimiento.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFFacturacion3.58
            public void focusGained(FocusEvent evt) {
                JIFFacturacion3.this.cboFechaNacimientoFocusGained(evt);
            }
        });
        this.cboFechaNacimiento.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JIFFacturacion3.59
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFacturacion3.this.cboFechaNacimientoPropertyChange(evt);
            }
        });
        this.txtEdad.setEditable(false);
        this.txtEdad.setBackground(new Color(0, 0, 153));
        this.txtEdad.setFont(new Font("Arial", 1, 12));
        this.txtEdad.setForeground(new Color(255, 255, 255));
        this.txtEdad.setDisabledTextColor(new Color(255, 255, 255));
        this.txtEdad.setEnabled(false);
        this.txtEdad.addActionListener(new ActionListener() { // from class: Facturacion.JIFFacturacion3.60
            public void actionPerformed(ActionEvent evt) {
                JIFFacturacion3.this.txtEdadActionPerformed(evt);
            }
        });
        this.JCBGrupoEtnico.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo Etnico:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 204)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.cboEspecialidad, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboProfesional, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFResponsable4, -2, 292, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBArl, -2, 180, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFResponsable8, GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDocumento, GroupLayout.Alignment.LEADING, 0, 205, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFResponsable1, -1, 177, 32767).addComponent(this.JTFResponsable9)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFResponsable11).addComponent(this.JCBLugarExpedicion, 0, 228, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBSexo3, -2, 225, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBGrupoEtnico, -2, 225, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFResponsable10, -2, 184, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cboFechaNacimiento, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtEdad)))).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBEscolaridad, -1, 287, 32767).addComponent(this.cboEps, 0, -1, 32767)).addGap(1, 1, 1).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.cboEstrato1, 0, -1, 32767).addComponent(this.JCBArl1, -2, 176, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBEscolaridad1, -2, 146, -2).addGap(33, 33, 33).addComponent(this.panelGrupoSangre, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.JSPNHijos, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFResponsable2, -2, 205, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFResponsable3, -2, 188, -2)))).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBSexo, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBLresiencia, -2, 167, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboBarrio, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBLNacimiento, -2, 194, -2).addGap(18, 18, 18).addComponent(this.JCBEstadoCivil, -2, 247, -2)).addComponent(this.jScrollPane1, -2, 1099, -2)).addGap(0, 0, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFResponsable1, -2, 48, -2).addContainerGap(-1, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBLugarExpedicion).addComponent(this.JCBSexo3, -2, -1, -2).addComponent(this.JCBGrupoEtnico, -2, -1, -2)).addGap(10, 10, 10)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCBTipoDocumento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFResponsable8, -2, -1, -2).addComponent(this.JTFResponsable9, -2, -1, -2).addComponent(this.JTFResponsable11, -2, -1, -2).addComponent(this.JTFResponsable10, -2, -1, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboFechaNacimiento, GroupLayout.Alignment.TRAILING, -2, 42, -2).addComponent(this.txtEdad, -2, 43, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBLNacimiento).addComponent(this.JCBSexo, -1, 51, 32767).addComponent(this.JCBLresiencia).addComponent(this.cboBarrio).addComponent(this.JCBEstadoCivil)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.panelGrupoSangre, -2, -1, -2).addComponent(this.JCBArl1, -2, -1, -2).addComponent(this.JCBEscolaridad1, -2, -1, -2).addComponent(this.cboEps, -2, -1, -2)).addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFResponsable2, -2, -1, -2).addComponent(this.JTFResponsable3, -2, -1, -2).addComponent(this.cboEstrato1, -2, -1, -2).addComponent(this.JCBEscolaridad, -2, -1, -2).addComponent(this.JSPNHijos, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFResponsable4, -2, -1, -2).addComponent(this.cboEspecialidad, -2, 40, -2).addComponent(this.cboProfesional, -2, 40, -2).addComponent(this.JCBArl, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 100, -2).addGap(8, 8, 8)))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jTabbedPane1, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 266, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsableMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsableActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioItemStateChanged(ItemEvent evt) {
        mLlenarComboEstrado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConvenioMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboTipoEmpresaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable5MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable5ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable6MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable6ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable7MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable7ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCodigoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProcedSuministroKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtVrUnitarioFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtVrUnitarioKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAdicionarActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAdicionarKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadItemStateChanged(ItemEvent evt) {
        cargarCboProfesional();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboProfesionalItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable4MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable4ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable3MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable3ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable2MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEstrato1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEscolaridadItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBArl1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEscolaridad1ItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboSangreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNegativoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPositivoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBLresienciaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable1MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable8MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable8ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable9MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable9ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable10MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable10ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable11MouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResponsable11ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFechaNacimientoFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFechaNacimientoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtEdadActionPerformed(ActionEvent evt) {
    }

    private void mCargarCombox() {
        this.idTipoDocumento = this.consulta.llenarCombo("SELECT Id, Nbre FROM g_tipoidentificacion WHERE Estado = 0 ORDER BY Nbre ASC", this.idTipoDocumento, this.JCBTipoDocumento);
        this.idLugarExpedicion = this.consulta.llenarCombo("SELECT g_municipio.Id, UCASE(CONCAT(g_municipio.Nbre,' - ', g_departamento.Nbre)) AS NMunicipio   \nFROM g_municipio INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) WHERE (g_municipio.Estado =0) ORDER BY g_municipio.Nbre ASC, g_departamento.Nbre ASC", this.idLugarExpedicion, this.JCBLugarExpedicion);
        this.idEtnico = this.consulta.llenarCombo("SELECT `Id` , UCASE(`Nbre`) FROM `g_tipo_etnia` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.idEtnico, this.JCBGrupoEtnico);
        this.idSexo = this.consulta.llenarCombo("SELECT Id, Nbre FROM g_sexo WHERE Estado = 0 ORDER BY Nbre ASC", this.idSexo, this.JCBSexo);
        this.sql = "SELECT g_municipio.Id, UCASE(CONCAT(g_municipio.Nbre,' - ', g_departamento.Nbre)) AS NMunicipio   FROM g_municipio INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) WHERE (g_municipio.Estado =0) ORDER BY g_municipio.Nbre ASC, g_departamento.Nbre ASC ";
        this.idMunicipio = this.consulta.llenarCombo(this.sql, this.idMunicipio, this.JCBLresiencia);
        this.idMunicipioNac = this.consulta.llenarCombo(this.sql, this.idMunicipioNac, this.JCBLNacimiento);
        this.idEstadoCivil = this.consulta.llenarCombo("SELECT Id, Nbre FROM g_estadocivil WHERE Estado = 0  ORDER BY Nbre ASC", this.idEstadoCivil, this.JCBEstadoCivil);
        this.listaEmpresa = this.consulta.llenarComboyLista("SELECT cc_terceros.Id, cc_terceros.`RazonSocialCompleta`, f_empresacontxconvenio.Id FROM g_empresacont INNER JOIN cc_terceros  ON (g_empresacont.Id_empresa = cc_terceros.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  WHERE (cc_terceros.EsEps=1) GROUP BY cc_terceros.Id ORDER BY cc_terceros.RazonSocialCompleta ASC", this.listaEmpresa, this.cboEps, 3);
        this.idArl = this.consulta.llenarCombo("SELECT `Id`  , `RazonSocialCompleta` FROM `cc_terceros` WHERE (`Estado` =1 ) ORDER BY RazonSocialCompleta ASC", this.idArl, this.JCBArl);
        this.consulta.llenarComboTabla("SELECT Id , UCASE(Nbre) FROM g_nivelestudio WHERE (Estado =0) ORDER BY Nbre ASC;", this.JCBEscolaridad, this.modcombos, 1);
        this.JCBEscolaridad.setSelectedItem("Ninguno");
        this.consulta.cerrarConexionBd();
        this.sql = "SELECT  g_especialidad.Id ,  g_especialidad.Nbre FROM g_profesionalespecial  INNER JOIN  g_especialidad ON ( g_profesionalespecial.Id_Especialidad = g_especialidad.Id) WHERE (g_especialidad.Estado =0 AND g_profesionalespecial.Estado =0) GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC";
        this.idEspecialidad = this.consulta.llenarCombo(this.sql, this.idEspecialidad, this.cboEspecialidad);
        this.cboEspecialidad.setSelectedIndex(-1);
        this.cboProfesional.removeAllItems();
        this.consulta.cerrarConexionBd();
    }

    private void cargarCboProfesional() {
        if (this.cboEspecialidad.getSelectedIndex() > -1) {
            ConsultasMySQL xctr = new ConsultasMySQL();
            this.cboProfesional.removeAllItems();
            this.sql = "SELECT w_profesional.Id_Persona, w_profesional.NProfesional FROM g_profesional INNER JOIN w_profesional   ON (g_profesional.Id_Persona = w_profesional.Id_Persona) WHERE (g_profesional.P_Ips =1 AND g_profesional.Estado =0 AND w_profesional.IdEspecialidad ='" + this.idEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "') ORDER BY w_profesional.NProfesional ASC ";
            this.idProfesional = this.consulta.llenarCombo(this.sql, this.idProfesional, this.cboProfesional);
            xctr.cerrarConexionBd();
        }
    }

    public void mLLenarConvenio() {
        this.sql = "SELECT f_empresacontxconvenio.Id AS Id, f_empresacontxconvenio.Nbre AS Empresa_Contratante, f_empresacontxconvenio.Id_Manual, f_empresacontxconvenio.EsCapitado, f_empresacontxconvenio.CualValor, g_empresacont.Id_TipoPlan, f_empresacontxconvenio.FiltroProcxEmp, f_empresacontxconvenio.ValidacionUsuario, f_empresacontxconvenio.ValidarDatos, f_empresacontxconvenio.Descuento, f_empresacontxconvenio.Id_EmpresaConvenio, f_empresacontxconvenio.Id_Contrato,  f_empresacontxconvenio.`Id_GIps`, f_empresacontxconvenio.Redondeo, f_empresacontxconvenio.`MetodoFact`, f_empresacontxconvenio.GMovimientoContable, g_empresacont.Id_empresa   , `f_empresacontxconvenio`.`validaCodigoAutorizacion`, g_tipo_contratacion.nombre idTipoContratacion, f_tipo_cobertura_plan.nombre idTipoCobertura FROM f_empresacontxconvenio INNER JOIN g_empresacont ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)\nINNER JOIN g_contratos  ON (g_contratos.Id_EmpresaContConvenio= f_empresacontxconvenio.Id) \nINNER JOIN g_tipo_contratacion ON (f_empresacontxconvenio.idTipoContratacion = g_tipo_contratacion.id)\nINNER JOIN f_tipo_cobertura_plan ON (f_empresacontxconvenio.idTipoCoberturaPlan = f_tipo_cobertura_plan.id)\nWHERE (f_empresacontxconvenio.Estado =0)  GROUP BY f_empresacontxconvenio.Id ORDER BY f_empresacontxconvenio.Nbre ASC  ";
        System.out.println(" Empresa : " + this.sql);
        this.JCBConvenio.removeAllItems();
        this.lisEmpresa = this.consulta.llenarComboyLista(this.sql, this.lisEmpresa, this.JCBConvenio, 20);
        this.consulta.cerrarConexionBd();
    }

    public void mLlenarComboEstrado() {
        if (this.JCBConvenio.getSelectedIndex() != -1) {
            this.cboEstrato1.removeAllItems();
            this.sql = "SELECT f_estrato.Id, f_estrato.Nbre as Estrato, f_estratoxemprcontconv.PorcSubsidio as Subsidio,f_estratoxemprcontconv.ValorMaximo as Valor_Maximo, f_estratoxemprcontconv.Editable FROM f_estratoxemprcontconv INNER JOIN f_estrato  ON (f_estratoxemprcontconv.Id_Estrato = f_estrato.Id) WHERE (f_estratoxemprcontconv.Estado =0  AND f_estratoxemprcontconv.Id_EmpresaContConv ='" + this.idEmpresa[this.JCBConvenio.getSelectedIndex()] + "') ORDER BY Estrato ASC ";
            this.idestrato = this.consulta.llenarComboyLista(this.sql, this.idestrato, this.cboEstrato1, 5);
            this.consulta.cerrarConexionBd();
        }
    }
}
