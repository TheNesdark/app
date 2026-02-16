package AutorizacionMP;

import Acceso.Principal;
import ComprasBS.JIFBuscarProducto;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:AutorizacionMP/JIFRProductosNAutorizados.class */
public class JIFRProductosNAutorizados extends JInternalFrame {
    private JIFBuscarProducto xjibuscarproducto;
    private String xsql;
    private String xnorden;
    public String[] xidtipop;
    private DefaultTableModel xmodelodetallet;
    private Object[] xdato;
    private ButtonGroup JBGOpciones;
    private JButton JBTAdicionar;
    public JComboBox JCBTipoProducto;
    private JPanel JPIDatosP;
    private JPanel JPPosologia;
    private JPanel JPTipo;
    private JRadioButton JRBAutomatico;
    private JRadioButton JRBManual;
    private JScrollPane JSPDatosDetMedicamentos;
    private JScrollPane JSPObservaciones;
    private JTextArea JTAObservaciones;
    private JTable JTDatosDetMedicamentos;
    private JTextField JTFDosisFrecuencia;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFDuracion;
    public JFormattedTextField JTFFValor;
    public JTextField JTFNombreP;
    private int xtipoc = 0;
    private int xnfila = -1;
    public long xidproducto = 1;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private boolean xestadog = false;

    public JIFRProductosNAutorizados(String xnorden) {
        initComponents();
        if (xnorden.isEmpty() || xnorden.equals("")) {
            this.xnorden = "0";
        } else {
            this.xnorden = xnorden;
        }
        mNuevo(false);
    }

    /* JADX WARN: Type inference failed for: r3v78, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatosP = new JPanel();
        this.JPTipo = new JPanel();
        this.JRBManual = new JRadioButton();
        this.JRBAutomatico = new JRadioButton();
        this.JCBTipoProducto = new JComboBox();
        this.JTFNombreP = new JTextField();
        this.JTFFValor = new JFormattedTextField();
        this.JPPosologia = new JPanel();
        this.JSPObservaciones = new JScrollPane();
        this.JTAObservaciones = new JTextArea();
        this.JTFDosisFrecuencia = new JTextField();
        this.JTFFDuracion = new JFormattedTextField();
        this.JTFFCantidad = new JFormattedTextField();
        this.JBTAdicionar = new JButton();
        this.JSPDatosDetMedicamentos = new JScrollPane();
        this.JTDatosDetMedicamentos = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE PRODUCTOS NO AUTORIZADOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifpnoautorizados");
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGOpciones.add(this.JRBManual);
        this.JRBManual.setFont(new Font("Arial", 1, 12));
        this.JRBManual.setSelected(true);
        this.JRBManual.setText("M");
        this.JRBManual.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFRProductosNAutorizados.1
            public void actionPerformed(ActionEvent evt) {
                JIFRProductosNAutorizados.this.JRBManualActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBAutomatico);
        this.JRBAutomatico.setFont(new Font("Arial", 1, 12));
        this.JRBAutomatico.setText("A");
        this.JRBAutomatico.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFRProductosNAutorizados.2
            public void actionPerformed(ActionEvent evt) {
                JIFRProductosNAutorizados.this.JRBAutomaticoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBManual).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAutomatico)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAutomatico).addComponent(this.JRBManual)).addContainerGap(-1, 32767)));
        this.JCBTipoProducto.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.setFont(new Font("Arial", 1, 12));
        this.JTFNombreP.setHorizontalAlignment(2);
        this.JTFNombreP.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreP.addMouseListener(new MouseAdapter() { // from class: AutorizacionMP.JIFRProductosNAutorizados.3
            public void mouseClicked(MouseEvent evt) {
                JIFRProductosNAutorizados.this.JTFNombrePMouseClicked(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Unitario", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(0);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JPPosologia.setBorder(BorderFactory.createTitledBorder((Border) null, "POSOLOGÍA", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JSPObservaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones/Justificacion", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservaciones.setColumns(20);
        this.JTAObservaciones.setFont(new Font("Arial", 1, 12));
        this.JTAObservaciones.setRows(5);
        this.JTAObservaciones.addKeyListener(new KeyAdapter() { // from class: AutorizacionMP.JIFRProductosNAutorizados.4
            public void keyPressed(KeyEvent evt) {
                JIFRProductosNAutorizados.this.JTAObservacionesKeyPressed(evt);
            }
        });
        this.JSPObservaciones.setViewportView(this.JTAObservaciones);
        this.JTFDosisFrecuencia.setFont(new Font("Arial", 1, 12));
        this.JTFDosisFrecuencia.setHorizontalAlignment(0);
        this.JTFDosisFrecuencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Dosis - Frecuencia", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDuracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Durac.", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDuracion.setHorizontalAlignment(0);
        this.JTFFDuracion.setFont(new Font("Arial", 1, 12));
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setHorizontalAlignment(0);
        this.JTFFCantidad.setFont(new Font("Arial", 1, 12));
        GroupLayout JPPosologiaLayout = new GroupLayout(this.JPPosologia);
        this.JPPosologia.setLayout(JPPosologiaLayout);
        JPPosologiaLayout.setHorizontalGroup(JPPosologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPosologiaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFDosisFrecuencia, -2, 209, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFDuracion, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCantidad, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservaciones, -1, 444, 32767).addContainerGap()));
        JPPosologiaLayout.setVerticalGroup(JPPosologiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPPosologiaLayout.createSequentialGroup().addGroup(JPPosologiaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservaciones, GroupLayout.Alignment.LEADING, 0, 60, 32767).addGroup(JPPosologiaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFCantidad, GroupLayout.Alignment.LEADING, -1, 59, 32767).addComponent(this.JTFFDuracion, GroupLayout.Alignment.LEADING).addComponent(this.JTFDosisFrecuencia, GroupLayout.Alignment.LEADING, -1, 59, 32767))).addContainerGap()));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: AutorizacionMP.JIFRProductosNAutorizados.5
            public void actionPerformed(ActionEvent evt) {
                JIFRProductosNAutorizados.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTAdicionar, GroupLayout.Alignment.LEADING, -1, 817, 32767).addComponent(this.JPPosologia, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoProducto, -2, 179, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNombreP, -1, 420, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValor, -2, 102, -2))).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombreP).addComponent(this.JTFFValor, -1, 50, 32767).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBTipoProducto, GroupLayout.Alignment.LEADING).addComponent(this.JPTipo, GroupLayout.Alignment.LEADING, -2, 50, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPosologia, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -2, 38, -2).addContainerGap()));
        this.JSPDatosDetMedicamentos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPDatosDetMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTDatosDetMedicamentos.setFont(new Font("Arial", 1, 12));
        this.JTDatosDetMedicamentos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDatosDetMedicamentos.setRowHeight(25);
        this.JTDatosDetMedicamentos.setSelectionBackground(new Color(255, 255, 255));
        this.JTDatosDetMedicamentos.setSelectionForeground(new Color(255, 0, 0));
        this.JTDatosDetMedicamentos.setSelectionMode(0);
        this.JTDatosDetMedicamentos.addKeyListener(new KeyAdapter() { // from class: AutorizacionMP.JIFRProductosNAutorizados.6
            public void keyPressed(KeyEvent evt) {
                JIFRProductosNAutorizados.this.JTDatosDetMedicamentosKeyPressed(evt);
            }
        });
        this.JSPDatosDetMedicamentos.setViewportView(this.JTDatosDetMedicamentos);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDatosDetMedicamentos, GroupLayout.Alignment.LEADING, -1, 853, 32767).addComponent(this.JPIDatosP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDatosDetMedicamentos, -1, 186, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBManualActionPerformed(ActionEvent evt) {
        this.xtipoc = 0;
        this.xidproducto = 1L;
        this.JCBTipoProducto.setEnabled(false);
        this.JTFNombreP.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAutomaticoActionPerformed(ActionEvent evt) {
        this.xtipoc = 1;
        this.JCBTipoProducto.setEnabled(true);
        this.JCBTipoProducto.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombrePMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JRBAutomatico.isSelected()) {
            if (this.JCBTipoProducto.getSelectedIndex() != -1) {
                this.xjibuscarproducto = new JIFBuscarProducto(this);
                Principal.cargarPantalla(this.xjibuscarproducto);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debes seleccionar un tipo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoProducto.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAObservacionesKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTAObservaciones.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDatosDetMedicamentosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDatosDetMedicamentos.getRowCount() != 0 && this.JTDatosDetMedicamentos.getSelectedRow() != -1) {
            this.xmodelodetallet.removeRow(this.JTDatosDetMedicamentos.getSelectedRow());
            this.xnfila--;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mAdicionar();
    }

    private void mNuevo(boolean xtipo) {
        this.xtipoc = 0;
        this.xidproducto = 1L;
        this.xestadog = false;
        this.JRBManual.setSelected(true);
        if (xtipo) {
            this.JCBTipoProducto.setSelectedIndex(-1);
        } else {
            this.JCBTipoProducto.removeAllItems();
            this.xsql = "SELECT i_tipoproducto.Id, i_tipoproducto.Nbre FROM i_suministro INNER JOIN i_tipoproducto ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) WHERE (i_suministro.EstaActivo =1) GROUP BY i_tipoproducto.Id ORDER BY i_tipoproducto.Nbre ASC ";
            this.xidtipop = this.xconsultas.llenarCombo(this.xsql, this.xidtipop, this.JCBTipoProducto);
            this.JCBTipoProducto.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            mCrearTablaDetalleMedicamentos();
        }
        this.JCBTipoProducto.setEnabled(false);
        this.xconsultas.cerrarConexionBd();
        this.JTFNombreP.setText("");
        this.JTFFValor.setValue(new Integer(0));
        this.JTFDosisFrecuencia.setText("");
        this.JTFFCantidad.setValue(new Integer(1));
        this.JTFFDuracion.setValue(new Integer(0));
        this.JTAObservaciones.setText("");
        this.JRBManual.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleMedicamentos() {
        this.xmodelodetallet = new DefaultTableModel(new Object[0], new String[]{"IdProducto", "Producto", "xfrecuencia", "duracion", "cantidad", "observaciones", "Valor"}) { // from class: AutorizacionMP.JIFRProductosNAutorizados.7
            Class[] types = {Integer.class, String.class, String.class, Integer.class, Integer.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDatosDetMedicamentos.setModel(this.xmodelodetallet);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDatosDetMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mAdicionar() {
        if (!this.JTFNombreP.getText().isEmpty()) {
            if (!this.JTFDosisFrecuencia.getText().isEmpty()) {
                if (!this.JTFFDuracion.getText().isEmpty()) {
                    if (!this.JTFFCantidad.getText().isEmpty()) {
                        this.xnfila++;
                        this.xmodelodetallet.addRow(this.xdato);
                        this.xmodelodetallet.setValueAt(Long.valueOf(this.xidproducto), this.xnfila, 0);
                        this.xmodelodetallet.setValueAt(this.JTFNombreP.getText(), this.xnfila, 1);
                        this.xmodelodetallet.setValueAt(this.JTFDosisFrecuencia.getText(), this.xnfila, 2);
                        this.xmodelodetallet.setValueAt(this.JTFFDuracion.getValue(), this.xnfila, 3);
                        this.xmodelodetallet.setValueAt(this.JTFFCantidad.getValue(), this.xnfila, 4);
                        this.xmodelodetallet.setValueAt(this.JTAObservaciones.getText(), this.xnfila, 5);
                        this.xmodelodetallet.setValueAt(this.JTFFValor.getValue(), this.xnfila, 6);
                        mNuevo(true);
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo cantidad   \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFCantidad.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo duración   \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFDuracion.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "\t\t\tEl campo dosis y frecuencia  \n no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFDosisFrecuencia.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un producto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombreP.requestFocus();
    }

    public void mGrabar() {
        try {
            if (!this.xestadog) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0 && this.JTDatosDetMedicamentos.getRowCount() != 0) {
                    for (int J = 0; J < this.JTDatosDetMedicamentos.getRowCount(); J++) {
                        this.xsql = "insert into h_itemordenessum_negados (Id_HOrdenes, Id_Usuario, EsManual, Id_Suministro, SuministroM, PosologiaManual, Duracion, Cantidad, ObservacionA, ValorUnitario, Fecha, UsuarioS) values('" + this.xnorden + "','" + Principal.claseautorizacionmp.autorizacion.frmPersona.getIdPersona() + "','" + this.xtipoc + "','" + this.xmodelodetallet.getValueAt(J, 0) + "','" + this.xmodelodetallet.getValueAt(J, 1) + "','" + this.xmodelodetallet.getValueAt(J, 2) + "','" + this.xmodelodetallet.getValueAt(J, 3) + "','" + this.xmodelodetallet.getValueAt(J, 4) + "','" + this.xmodelodetallet.getValueAt(J, 5) + "','" + this.xmodelodetallet.getValueAt(J, 6) + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xconsultas.ejecutarSQL(this.xsql);
                        this.xconsultas.cerrarConexionBd();
                    }
                    this.xestadog = true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
