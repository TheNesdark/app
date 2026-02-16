package ParametrizacionN;

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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFEmpresaEstrato.class */
public class JIFFEmpresaEstrato extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidestrato;
    private claseParametrizacionN xclase;
    private ButtonGroup JBGTipo;
    private JComboBox JCBEstrato;
    private JCheckBox JCHEsDescontable;
    private JCheckBox JCHEsEditable;
    private JCheckBox JCHEstado;
    private JCheckBox JCHValidarDatos;
    private JPanel JPITipo;
    private JRadioButton JRBCModeradora;
    private JRadioButton JRBCopago;
    private JScrollPane JSPDetalle;
    private JSpinner JSPSubsidio;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValorC;
    private JFormattedTextField JTFFValorT;
    private JFormattedTextField JTFFValorTA;
    private JPanel jPanel1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int xestados = 0;
    private int xcuota = 0;
    private int xid = 0;
    private int xesdescontable = 0;
    private int xeseditable = 1;
    private int xvalidar = 1;
    private boolean xestadog = false;

    public JIFFEmpresaEstrato(claseParametrizacionN xclase) {
        initComponents();
        this.xclase = xclase;
        this.xidestrato = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM  f_estrato WHERE (Estado =1)", this.xidestrato, this.JCBEstrato);
        this.JCBEstrato.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JCBEstrato = new JComboBox();
        this.JPITipo = new JPanel();
        this.JRBCModeradora = new JRadioButton();
        this.JRBCopago = new JRadioButton();
        this.JSPSubsidio = new JSpinner();
        this.JTFFValorC = new JFormattedTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFFValorTA = new JFormattedTextField();
        this.JTFFValorT = new JFormattedTextField();
        this.JCHEsDescontable = new JCheckBox();
        this.JCHEsEditable = new JCheckBox();
        this.JCHValidarDatos = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("ESTRATO POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifestratoempresa");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFEmpresaEstrato.1
            public void mouseClicked(MouseEvent evt) {
                JIFFEmpresaEstrato.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBEstrato.setFont(new Font("Arial", 1, 12));
        this.JCBEstrato.setBorder(BorderFactory.createTitledBorder((Border) null, "Estrato", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipo.add(this.JRBCModeradora);
        this.JRBCModeradora.setFont(new Font("Arial", 1, 12));
        this.JRBCModeradora.setSelected(true);
        this.JRBCModeradora.setText("C.Moderadora");
        this.JRBCModeradora.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaEstrato.2
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaEstrato.this.JRBCModeradoraActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBCopago);
        this.JRBCopago.setFont(new Font("Arial", 1, 12));
        this.JRBCopago.setText("Copago");
        this.JRBCopago.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaEstrato.3
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaEstrato.this.JRBCopagoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBCModeradora).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBCopago).addContainerGap(-1, 32767)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCModeradora).addComponent(this.JRBCopago)).addContainerGap(-1, 32767)));
        this.JSPSubsidio.setFont(new Font("Arial", 1, 12));
        this.JSPSubsidio.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.01f)));
        this.JSPSubsidio.setBorder(BorderFactory.createTitledBorder((Border) null, "% Subsidio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPSubsidio.setEnabled(false);
        this.JTFFValorC.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Cuota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorC.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorC.setHorizontalAlignment(0);
        this.JTFFValorC.setFont(new Font("Arial", 1, 12));
        this.JTFFValorC.setValue(new Integer(0));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaEstrato.4
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaEstrato.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFFValorTA.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Tope Atención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorTA.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorTA.setHorizontalAlignment(0);
        this.JTFFValorTA.setToolTipText("Valor tope por atención");
        this.JTFFValorTA.setFont(new Font("Arial", 1, 12));
        this.JTFFValorTA.setValue(new Integer(0));
        this.JTFFValorT.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Tope Anual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorT.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorT.setHorizontalAlignment(0);
        this.JTFFValorT.setToolTipText("Valor tope anual");
        this.JTFFValorT.setFont(new Font("Arial", 1, 12));
        this.JTFFValorT.setValue(new Integer(0));
        this.JCHEsDescontable.setFont(new Font("Arial", 1, 12));
        this.JCHEsDescontable.setForeground(Color.blue);
        this.JCHEsDescontable.setText("Es Descontable?");
        this.JCHEsDescontable.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaEstrato.5
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaEstrato.this.JCHEsDescontableActionPerformed(evt);
            }
        });
        this.JCHEsEditable.setFont(new Font("Arial", 1, 12));
        this.JCHEsEditable.setForeground(Color.blue);
        this.JCHEsEditable.setText("Es Editable?");
        this.JCHEsEditable.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaEstrato.6
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaEstrato.this.JCHEsEditableActionPerformed(evt);
            }
        });
        this.JCHValidarDatos.setFont(new Font("Arial", 1, 12));
        this.JCHValidarDatos.setForeground(Color.blue);
        this.JCHValidarDatos.setText("Validar?");
        this.JCHValidarDatos.setToolTipText("<html><P>Control para no reflejar la cuota moderadora</p> <html><P> al momento de liquidar el servicio");
        this.JCHValidarDatos.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFEmpresaEstrato.7
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaEstrato.this.JCHValidarDatosActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBEstrato, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JPITipo, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPSubsidio, -2, 101, -2).addGap(18, 18, 18).addComponent(this.JTFFValorC, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JTFFValorTA, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JTFFValorT, -2, 136, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHEsEditable)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHValidarDatos).addComponent(this.JCHEsDescontable)))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPITipo, GroupLayout.Alignment.LEADING, 0, 50, 32767).addComponent(this.JCBEstrato, GroupLayout.Alignment.LEADING)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPSubsidio, -2, -1, -2).addComponent(this.JTFFValorC, -2, 50, -2).addComponent(this.JTFFValorTA, -2, 50, -2).addComponent(this.JTFFValorT, -2, 50, -2))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JCHEsDescontable)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEsEditable).addComponent(this.JCHValidarDatos)).addGap(0, 0, 32767))).addContainerGap()));
        this.JCHEsDescontable.setVisible(false);
        this.JCHValidarDatos.setVisible(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 356, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.xid = Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()).intValue();
            this.JCBEstrato.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSPSubsidio.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
            this.JTFFValorC.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            this.JTFFValorTA.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()));
            this.JTFFValorT.setValue(Double.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
                this.JRBCopago.setSelected(true);
                this.xcuota = 1;
                this.JTFFValorC.setEnabled(false);
                this.JSPSubsidio.setEnabled(true);
            } else {
                this.JRBCModeradora.setSelected(true);
                this.xcuota = 0;
                this.JTFFValorC.setEnabled(true);
                this.JSPSubsidio.setEnabled(false);
            }
            this.JCHValidarDatos.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString()).booleanValue());
            if (this.JCHValidarDatos.isSelected()) {
                this.xvalidar = 1;
            } else {
                this.xvalidar = 0;
            }
            this.JCHEsDescontable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString()).booleanValue());
            if (this.JCHEsDescontable.isSelected()) {
                this.xesdescontable = 1;
            } else {
                this.xesdescontable = 0;
            }
            this.JCHEsEditable.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString()).booleanValue());
            if (this.JCHEsEditable.isSelected()) {
                this.xeseditable = 1;
            } else {
                this.xeseditable = 0;
            }
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestados = 0;
            } else {
                this.xestados = 1;
            }
            this.xestadog = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestados = 0;
        } else {
            this.xestados = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCModeradoraActionPerformed(ActionEvent evt) {
        this.xcuota = 0;
        this.JSPSubsidio.setValue(0);
        this.JTFFValorC.setEnabled(true);
        this.JSPSubsidio.setEnabled(false);
        this.JTFFValorC.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCopagoActionPerformed(ActionEvent evt) {
        this.xcuota = 1;
        this.JTFFValorC.setValue(0);
        this.JTFFValorC.setEnabled(false);
        this.JSPSubsidio.setEnabled(true);
        this.JSPSubsidio.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsDescontableActionPerformed(ActionEvent evt) {
        if (this.JCHEsDescontable.isSelected()) {
            this.xesdescontable = 1;
        } else {
            this.xesdescontable = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsEditableActionPerformed(ActionEvent evt) {
        if (this.JCHEsEditable.isSelected()) {
            this.xeseditable = 1;
        } else {
            this.xeseditable = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHValidarDatosActionPerformed(ActionEvent evt) {
        if (this.JCHValidarDatos.isSelected()) {
            this.xvalidar = 1;
        } else {
            this.xvalidar = 0;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Estrato", "Tipo", "% Subsidio", "Valor", "Tope_Atencion", "Tope Anual", "Validar?", "Descontable?", "Editable?", "Estado"}) { // from class: ParametrizacionN.JIFFEmpresaEstrato.8
            Class[] types = {Integer.class, String.class, Boolean.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        int xidempresacont;
        try {
            if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                xidempresacont = this.xclase.xjifempresaBienestar.xidempresacont;
            } else {
                xidempresacont = this.xclase.xjifempresa.xidempresacont;
            }
            mCrearModeloDatos();
            String sql = "SELECT f_estrato.id, f_estrato.Nbre, f_estratoxemprcontconv.Copago, f_estratoxemprcontconv.PorcSubsidio , f_estratoxemprcontconv.ValorMaximo,  `f_estratoxemprcontconv`.`TopeAtencion` , `f_estratoxemprcontconv`.`ToPeAnual`,`f_estratoxemprcontconv`.`ValidarDatos`, `f_estratoxemprcontconv`.`Descontable`, `f_estratoxemprcontconv`.`Editable`, f_estratoxemprcontconv.Estado FROM  f_estratoxemprcontconv INNER JOIN  f_estrato  ON (f_estratoxemprcontconv.Id_Estrato = f_estrato.Id) WHERE (f_estratoxemprcontconv.Id_EmpresaContConv ='" + xidempresacont + "') ";
            ResultSet xrs = this.xconsulta.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), n, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), n, 7);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), n, 8);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.xmodelo.setValueAt(Boolean.valueOf(!xrs.getBoolean(11)), n, 10);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFEmpresaEstrato.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mNuevo() {
        this.JCBEstrato.setSelectedIndex(-1);
        this.JRBCModeradora.setSelected(true);
        this.JSPSubsidio.setValue(new Integer(0));
        this.JTFFValorC.setValue(new Integer(0));
        this.JTFFValorT.setValue(new Double(0.0d));
        this.JTFFValorTA.setValue(new Double(0.0d));
        this.JCHEsEditable.setSelected(false);
        this.xeseditable = 0;
        this.JCHEsDescontable.setSelected(false);
        this.xesdescontable = 0;
        this.JCHValidarDatos.setSelected(false);
        this.xvalidar = 0;
        this.xcuota = 0;
        this.JCHEstado.setSelected(true);
        this.xestados = 0;
        this.xestadog = false;
    }

    public void mGrabar() {
        int xidempresacont;
        String sql;
        int xidempresacont2;
        if (this.JCBEstrato.getSelectedIndex() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (!this.xestadog) {
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        xidempresacont2 = this.xclase.xjifempresaBienestar.xidempresacont;
                    } else {
                        xidempresacont2 = this.xclase.xjifempresa.xidempresacont;
                    }
                    sql = "insert into f_estratoxemprcontconv (Id_Estrato, Id_EmpresaContConv, Copago, PorcSubsidio, ValorMaximo, `TopeAtencion` , `ToPeAnual`, ValidarDatos, Descontable, Editable, Estado, Fecha, UsuarioS) values ('" + this.xidestrato[this.JCBEstrato.getSelectedIndex()] + "','" + xidempresacont2 + "','" + this.xcuota + "','" + this.JSPSubsidio.getValue() + "','" + this.JTFFValorC.getValue() + "','" + this.JTFFValorTA.getValue() + "','" + this.JTFFValorT.getValue() + "','" + this.xvalidar + "','" + this.xesdescontable + "','" + this.xeseditable + "','" + this.xestados + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                } else {
                    if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
                        xidempresacont = this.xclase.xjifempresaBienestar.xidempresacont;
                    } else {
                        xidempresacont = this.xclase.xjifempresa.xidempresacont;
                    }
                    sql = "update f_estratoxemprcontconv set PorcSubsidio='" + this.JSPSubsidio.getValue() + "', ValorMaximo='" + this.JTFFValorC.getValue() + "', `TopeAtencion`='" + this.JTFFValorTA.getValue() + "', `ToPeAnual`='" + this.JTFFValorT.getValue() + "', ValidarDatos='" + this.xvalidar + "', Descontable='" + this.xesdescontable + "', Editable='" + this.xeseditable + "', Estado='" + this.xestados + "' where Id_Estrato='" + this.xidestrato[this.JCBEstrato.getSelectedIndex()] + "' and Id_EmpresaContConv='" + xidempresacont + "' and Copago='" + this.xcuota + "'";
                }
                this.xconsulta.ejecutarSQL(sql);
                this.xconsulta.cerrarConexionBd();
                mCargarDatosTabla();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un estrato", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBEstrato.requestFocus();
    }
}
