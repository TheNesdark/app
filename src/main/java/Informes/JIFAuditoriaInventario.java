package Informes;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFAuditoriaInventario.class */
public class JIFAuditoriaInventario extends JInternalFrame {
    private String sql;
    private String IdAuditoria;
    private int cboLleno;
    private Object[] dato;
    private String[] listaBodega;
    private ButtonGroup JBConsulta;
    private JButton btnAceptar;
    private JRadioButton btnConsultarFecha;
    private JRadioButton btnConsultarNumero;
    private JRadioButton btnGenerar;
    private JButton btnGrabar;
    private JButton btnImprimir;
    private JButton btnImprimir1;
    private JButton btnModificar;
    private JComboBox cboBodega;
    private JTable grid;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JLabel lblNumero;
    private JLabel lblTitulo;
    private JTextArea txtAccion;
    private JFormattedTextField txtCantDiferencia;
    private JFormattedTextField txtCantFisica;
    private JFormattedTextField txtCantInventario;
    private JSpinner txtCantidad;
    private JFormattedTextField txtCostoDiferencia;
    private JTextArea txtExplicacion;
    public JDateChooser txtFecha;
    private JSpinner txtNumero;
    private JTextField txtProducto;
    private JTextField txtResponsable;
    private JSpinner txtValorMaximo;
    private JSpinner txtValorMinimo;
    private JFormattedTextField txtValorUnidad;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private String titulo = "G@noma Soft";
    private int filaGrid = 0;
    private int opcion = 1;
    private Date fechaActual = new Date();
    private GregorianCalendar fechaAnterior = new GregorianCalendar();
    private DefaultTableModel modelo = new DefaultTableModel();

    public JIFAuditoriaInventario() {
        initComponents();
        this.txtFecha.setDate(this.xmetodos.getFechaActual());
        this.listaBodega = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM i_bodegas ORDER BY Nbre", this.listaBodega, this.cboBodega);
        this.xconsultas.cerrarConexionBd();
        this.cboLleno = 1;
        this.fechaAnterior.add(2, -1);
        crearGrid();
    }

    /* JADX WARN: Type inference failed for: r3v110, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBConsulta = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.btnAceptar = new JButton();
        this.lblTitulo = new JLabel();
        this.cboBodega = new JComboBox();
        this.jPanel2 = new JPanel();
        this.btnConsultarFecha = new JRadioButton();
        this.txtFecha = new JDateChooser();
        this.btnConsultarNumero = new JRadioButton();
        this.txtNumero = new JSpinner();
        this.jPanel3 = new JPanel();
        this.btnGenerar = new JRadioButton();
        this.txtCantidad = new JSpinner();
        this.txtValorMinimo = new JSpinner();
        this.txtValorMaximo = new JSpinner();
        this.lblNumero = new JLabel();
        this.jPanel4 = new JPanel();
        this.txtProducto = new JTextField();
        this.jScrollPane2 = new JScrollPane();
        this.txtExplicacion = new JTextArea();
        this.jScrollPane3 = new JScrollPane();
        this.txtAccion = new JTextArea();
        this.txtResponsable = new JTextField();
        this.jLabel12 = new JLabel();
        this.jLabel13 = new JLabel();
        this.btnModificar = new JButton();
        this.jPanel5 = new JPanel();
        this.txtCantInventario = new JFormattedTextField();
        this.txtCantFisica = new JFormattedTextField();
        this.txtCantDiferencia = new JFormattedTextField();
        this.jPanel6 = new JPanel();
        this.txtValorUnidad = new JFormattedTextField();
        this.txtCostoDiferencia = new JFormattedTextField();
        this.btnImprimir = new JButton();
        this.btnGrabar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.btnImprimir1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTA DE AUDITORIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setLayout((LayoutManager) null);
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.btnAceptar.setText("Generar  / Buscar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.1
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.btnAceptarActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnAceptar);
        this.btnAceptar.setBounds(750, 135, 280, 40);
        this.lblTitulo.setBackground((Color) null);
        this.lblTitulo.setFont(new Font("Arial", 1, 14));
        this.lblTitulo.setForeground(new Color(0, 102, 0));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("CONSULTA DE AUDITORIA");
        this.lblTitulo.setOpaque(true);
        this.jPanel1.add(this.lblTitulo);
        this.lblTitulo.setBounds(20, 20, 1010, 20);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboBodega.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.2
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.cboBodegaActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.cboBodega);
        this.cboBodega.setBounds(450, 140, 260, 40);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTAR", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.JBConsulta.add(this.btnConsultarFecha);
        this.btnConsultarFecha.setFont(new Font("Arial", 1, 12));
        this.btnConsultarFecha.setForeground(Color.blue);
        this.btnConsultarFecha.setText("Consultar fechas anteriores");
        this.btnConsultarFecha.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.3
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.btnConsultarFechaActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnConsultarFecha);
        this.btnConsultarFecha.setBounds(10, 20, 190, 30);
        this.txtFecha.setEnabled(false);
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel2.add(this.txtFecha);
        this.txtFecha.setBounds(20, 50, 150, 30);
        this.JBConsulta.add(this.btnConsultarNumero);
        this.btnConsultarNumero.setFont(new Font("Arial", 1, 12));
        this.btnConsultarNumero.setForeground(Color.blue);
        this.btnConsultarNumero.setText("No a Consultar");
        this.btnConsultarNumero.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.4
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.btnConsultarNumeroActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnConsultarNumero);
        this.btnConsultarNumero.setBounds(210, 20, 120, 23);
        this.txtNumero.setFont(new Font("Arial", 1, 12));
        this.txtNumero.setEnabled(false);
        this.txtNumero.addChangeListener(new ChangeListener() { // from class: Informes.JIFAuditoriaInventario.5
            public void stateChanged(ChangeEvent evt) {
                JIFAuditoriaInventario.this.txtNumeroStateChanged(evt);
            }
        });
        this.txtNumero.addPropertyChangeListener(new PropertyChangeListener() { // from class: Informes.JIFAuditoriaInventario.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAuditoriaInventario.this.txtNumeroPropertyChange(evt);
            }
        });
        this.jPanel2.add(this.txtNumero);
        this.txtNumero.setBounds(210, 50, 110, 30);
        this.jPanel1.add(this.jPanel2);
        this.jPanel2.setBounds(400, 50, 340, 90);
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "GENERAR Y CONSULTAR", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.JBConsulta.add(this.btnGenerar);
        this.btnGenerar.setFont(new Font("Arial", 1, 12));
        this.btnGenerar.setForeground(new Color(0, 0, 255));
        this.btnGenerar.setSelected(true);
        this.btnGenerar.setText("Generar y mostrar reporte");
        this.btnGenerar.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.7
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.btnGenerarActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.btnGenerar);
        this.btnGenerar.setBounds(10, 20, 190, 23);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel3.add(this.txtCantidad);
        this.txtCantidad.setBounds(270, 60, 110, 40);
        this.txtValorMinimo.setFont(new Font("Arial", 1, 12));
        this.txtValorMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel3.add(this.txtValorMinimo);
        this.txtValorMinimo.setBounds(20, 60, 110, 40);
        this.txtValorMaximo.setFont(new Font("Arial", 1, 12));
        this.txtValorMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel3.add(this.txtValorMaximo);
        this.txtValorMaximo.setBounds(150, 60, 110, 40);
        this.jPanel1.add(this.jPanel3);
        this.jPanel3.setBounds(10, 50, 390, 130);
        this.lblNumero.setBackground(new Color(0, 0, 102));
        this.lblNumero.setFont(new Font("Arial", 1, 24));
        this.lblNumero.setForeground(new Color(255, 255, 255));
        this.lblNumero.setHorizontalAlignment(0);
        this.lblNumero.setText("0");
        this.lblNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 0, 0, (Font) null, new Color(204, 255, 255)));
        this.lblNumero.setEnabled(false);
        this.lblNumero.setOpaque(true);
        this.jPanel1.add(this.lblNumero);
        this.lblNumero.setBounds(750, 50, 280, 80);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL PRODUCTO A AUDITAR", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.jPanel4.setLayout((LayoutManager) null);
        this.txtProducto.setEditable(false);
        this.txtProducto.setBackground((Color) null);
        this.txtProducto.setForeground(new Color(255, 255, 255));
        this.txtProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Producto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel4.add(this.txtProducto);
        this.txtProducto.setBounds(20, 30, 660, 40);
        this.txtExplicacion.setColumns(20);
        this.txtExplicacion.setFont(new Font("Arial", 1, 12));
        this.txtExplicacion.setRows(5);
        this.jScrollPane2.setViewportView(this.txtExplicacion);
        this.jPanel4.add(this.jScrollPane2);
        this.jScrollPane2.setBounds(430, 100, 250, 100);
        this.txtAccion.setColumns(20);
        this.txtAccion.setFont(new Font("Arial", 1, 12));
        this.txtAccion.setRows(5);
        this.jScrollPane3.setViewportView(this.txtAccion);
        this.jPanel4.add(this.jScrollPane3);
        this.jScrollPane3.setBounds(690, 100, 210, 100);
        this.txtResponsable.setFont(new Font("Arial", 1, 12));
        this.txtResponsable.setBorder(BorderFactory.createTitledBorder((Border) null, "Responsable", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel4.add(this.txtResponsable);
        this.txtResponsable.setBounds(690, 30, 310, 40);
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(0, 0, 255));
        this.jLabel12.setText("Explicación de la Diferencia");
        this.jPanel4.add(this.jLabel12);
        this.jLabel12.setBounds(430, 80, 180, 15);
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(0, 0, 255));
        this.jLabel13.setText("Acción");
        this.jPanel4.add(this.jLabel13);
        this.jLabel13.setBounds(690, 80, 80, 15);
        this.btnModificar.setFont(new Font("Arial", 1, 12));
        this.btnModificar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Deshacer.png")));
        this.btnModificar.setText("Modificar");
        this.btnModificar.setHorizontalTextPosition(0);
        this.btnModificar.setVerticalTextPosition(3);
        this.btnModificar.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.8
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.btnModificarActionPerformed(evt);
            }
        });
        this.jPanel4.add(this.btnModificar);
        this.btnModificar.setBounds(910, 100, 90, 100);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "CANTIDADES", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel5.setLayout((LayoutManager) null);
        this.txtCantInventario.setEditable(false);
        this.txtCantInventario.setBackground((Color) null);
        this.txtCantInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "Inventario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantInventario.setForeground(new Color(255, 255, 255));
        this.txtCantInventario.setHorizontalAlignment(4);
        this.txtCantInventario.setFont(new Font("Arial", 1, 12));
        this.jPanel5.add(this.txtCantInventario);
        this.txtCantInventario.setBounds(20, 20, 170, 40);
        this.txtCantFisica.setBorder(BorderFactory.createTitledBorder((Border) null, "Física", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantFisica.setHorizontalAlignment(4);
        this.txtCantFisica.setFont(new Font("Arial", 1, 12));
        this.txtCantFisica.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.9
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.txtCantFisicaActionPerformed(evt);
            }
        });
        this.jPanel5.add(this.txtCantFisica);
        this.txtCantFisica.setBounds(20, 60, 170, 40);
        this.txtCantDiferencia.setEditable(false);
        this.txtCantDiferencia.setBackground((Color) null);
        this.txtCantDiferencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Diferencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantDiferencia.setForeground(new Color(255, 255, 255));
        this.txtCantDiferencia.setHorizontalAlignment(4);
        this.txtCantDiferencia.setFont(new Font("Arial", 1, 12));
        this.jPanel5.add(this.txtCantDiferencia);
        this.txtCantDiferencia.setBounds(20, 100, 170, 40);
        this.jPanel4.add(this.jPanel5);
        this.jPanel5.setBounds(20, 70, 210, 150);
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "COSTOS", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel6.setLayout((LayoutManager) null);
        this.txtValorUnidad.setEditable(false);
        this.txtValorUnidad.setBackground((Color) null);
        this.txtValorUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Unidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorUnidad.setForeground(new Color(255, 255, 255));
        this.txtValorUnidad.setHorizontalAlignment(4);
        this.jPanel6.add(this.txtValorUnidad);
        this.txtValorUnidad.setBounds(10, 20, 170, 40);
        this.txtCostoDiferencia.setEditable(false);
        this.txtCostoDiferencia.setBackground((Color) null);
        this.txtCostoDiferencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Costo Diferencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCostoDiferencia.setForeground(new Color(255, 255, 255));
        this.txtCostoDiferencia.setHorizontalAlignment(4);
        this.jPanel6.add(this.txtCostoDiferencia);
        this.txtCostoDiferencia.setBounds(10, 70, 170, 40);
        this.jPanel4.add(this.jPanel6);
        this.jPanel6.setBounds(230, 70, 190, 140);
        this.jPanel1.add(this.jPanel4);
        this.jPanel4.setBounds(10, 180, 1020, 230);
        this.btnImprimir.setFont(new Font("Arial", 1, 12));
        this.btnImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.btnImprimir.setText("Imprimir Cuadro de Auditoria");
        this.btnImprimir.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.10
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.btnImprimirActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnImprimir);
        this.btnImprimir.setBounds(360, 640, 320, 40);
        this.btnGrabar.setFont(new Font("Arial", 1, 12));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.11
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.btnGrabarActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnGrabar);
        this.btnGrabar.setBounds(10, 640, 320, 40);
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane1.setViewportView(this.grid);
        this.jPanel1.add(this.jScrollPane1);
        this.jScrollPane1.setBounds(20, 410, 1010, 210);
        this.btnImprimir1.setFont(new Font("Arial", 1, 12));
        this.btnImprimir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.btnImprimir1.setText("Imprimir Informe de Gerencia");
        this.btnImprimir1.addActionListener(new ActionListener() { // from class: Informes.JIFAuditoriaInventario.12
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaInventario.this.btnImprimir1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.btnImprimir1);
        this.btnImprimir1.setBounds(710, 640, 320, 40);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1043, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel1, -2, 1043, -2).addGap(0, 0, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 715, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 6, 32767).addComponent(this.jPanel1, -2, 703, -2).addGap(0, 6, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        evaluarAccion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboBodegaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnConsultarFechaActionPerformed(ActionEvent evt) {
        this.opcion = 2;
        activarCampos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnConsultarNumeroActionPerformed(ActionEvent evt) {
        this.opcion = 3;
        activarCampos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroStateChanged(ChangeEvent evt) {
        this.lblNumero.setText(String.valueOf(this.txtNumero.getValue().toString()));
        Principal.txtNo.setText(String.valueOf(this.txtNumero.getValue().toString()));
        this.btnAceptar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNumeroPropertyChange(PropertyChangeEvent evt) {
        this.lblNumero.setText(String.valueOf(this.txtNumero.getValue().toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGenerarActionPerformed(ActionEvent evt) {
        this.opcion = 1;
        activarCampos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnModificarActionPerformed(ActionEvent evt) {
        this.grid.setValueAt(this.txtCantFisica.getText(), this.filaGrid, 4);
        this.grid.setValueAt(this.txtCantDiferencia.getText(), this.filaGrid, 5);
        this.grid.setValueAt(this.txtCostoDiferencia.getText(), this.filaGrid, 7);
        this.grid.setValueAt(this.txtExplicacion.getText(), this.filaGrid, 8);
        this.grid.setValueAt(this.txtAccion.getText(), this.filaGrid, 9);
        this.grid.setValueAt(this.txtResponsable.getText(), this.filaGrid, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantFisicaActionPerformed(ActionEvent evt) {
        this.txtCantDiferencia.setText(String.valueOf(Integer.parseInt(this.txtCantInventario.getText()) - Integer.parseInt(this.txtCantFisica.getText())));
        this.txtCostoDiferencia.setValue(Integer.valueOf(Integer.parseInt(this.txtValorUnidad.getValue().toString()) * (Integer.parseInt(this.txtCantInventario.getText()) - Integer.parseInt(this.txtCantFisica.getText()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimirActionPerformed(ActionEvent evt) {
        imprimir(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnImprimir1ActionPerformed(ActionEvent evt) {
        imprimir(2);
    }

    public void activarCampos() {
        switch (this.opcion) {
            case 1:
                this.txtValorMinimo.setEnabled(true);
                this.txtValorMaximo.setEnabled(true);
                this.txtCantidad.setEnabled(true);
                this.txtFecha.setEnabled(false);
                this.txtNumero.setEnabled(false);
                this.txtValorMinimo.requestFocus();
                break;
            case 2:
                this.txtValorMinimo.setEnabled(false);
                this.txtValorMaximo.setEnabled(false);
                this.txtCantidad.setEnabled(false);
                this.txtFecha.setEnabled(true);
                this.txtNumero.setEnabled(false);
                this.txtFecha.requestFocus();
                break;
            case 3:
                this.txtValorMinimo.setEnabled(false);
                this.txtValorMaximo.setEnabled(false);
                this.txtCantidad.setEnabled(false);
                this.txtFecha.setEnabled(false);
                this.txtNumero.setEnabled(true);
                this.txtNumero.requestFocus();
                break;
        }
    }

    public void cargarDatos() {
        this.txtProducto.setText(this.modelo.getValueAt(this.filaGrid, 1).toString());
        this.txtCantInventario.setText(this.modelo.getValueAt(this.filaGrid, 3).toString());
        this.txtCantFisica.setText(this.modelo.getValueAt(this.filaGrid, 4).toString());
        this.txtCantDiferencia.setText(this.modelo.getValueAt(this.filaGrid, 5).toString());
        this.txtValorUnidad.setValue(Double.valueOf(Double.parseDouble(this.modelo.getValueAt(this.filaGrid, 6).toString())));
        this.txtCostoDiferencia.setValue(Double.valueOf(Double.parseDouble(this.modelo.getValueAt(this.filaGrid, 7).toString())));
        if (this.modelo.getValueAt(this.filaGrid, 8) != null) {
            this.txtExplicacion.setText(this.modelo.getValueAt(this.filaGrid, 8).toString());
        } else {
            this.txtExplicacion.setText("");
        }
        if (this.modelo.getValueAt(this.filaGrid, 9) != null) {
            this.txtAccion.setText(this.modelo.getValueAt(this.filaGrid, 9).toString());
        } else {
            this.txtAccion.setText("");
        }
        if (this.modelo.getValueAt(this.filaGrid, 10) != null) {
            this.txtResponsable.setText(this.modelo.getValueAt(this.filaGrid, 10).toString());
        } else {
            this.txtResponsable.setText("");
        }
    }

    private void consultaPorFecha() {
        try {
            this.sql = "SELECT Id, VrMinimo, VrMaximo, Cantidad FROM i_auditoria WHERE (FechaAuditoria = '" + this.xmetodos.formatoAMD.format(this.txtFecha.getDate()) + "') AND (IdBodega = '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "') ORDER BY Id DESC";
            ResultSet rs1 = this.xconsultas.traerRs(this.sql);
            rs1.next();
            if (rs1.getRow() > 0) {
                this.IdAuditoria = rs1.getString(1);
                this.txtValorMinimo.setValue(Integer.valueOf(rs1.getInt(2)));
                this.txtValorMaximo.setValue(Integer.valueOf(rs1.getInt(3)));
                this.txtCantidad.setValue(Integer.valueOf(rs1.getInt(4)));
                this.lblNumero.setText(this.IdAuditoria);
                Principal.txtNo.setText(this.IdAuditoria);
                if (Integer.parseInt(this.IdAuditoria) > 0) {
                    llenarGrid(this.lblNumero.getText());
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe Información de productos para la Bodega seleccionada", this.titulo, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
            }
            rs1.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void consultarPorNumero() {
        try {
            this.lblNumero.setText(this.txtNumero.getValue().toString());
            Principal.txtNo.setText(this.txtNumero.getValue().toString());
            this.IdAuditoria = this.txtNumero.getValue().toString();
            this.sql = "SELECT i_bodegas.Nbre, i_auditoria.VrMinimo, i_auditoria.VrMaximo, i_auditoria.Cantidad FROM baseserver.i_auditoria INNER JOIN baseserver.i_bodegas ON (i_auditoria.IdBodega = i_bodegas.Id) WHERE (i_auditoria.Id ='" + this.txtNumero.getValue().toString() + "')";
            ResultSet rs1 = this.xconsultas.traerRs(this.sql);
            rs1.next();
            if (rs1.getRow() > 0) {
                this.cboBodega.setSelectedItem(rs1.getString(1));
                this.txtValorMinimo.setValue(Integer.valueOf(rs1.getInt(2)));
                this.txtValorMaximo.setValue(Integer.valueOf(rs1.getInt(3)));
                this.txtCantidad.setValue(Integer.valueOf(rs1.getInt(4)));
                if (Integer.parseInt(this.IdAuditoria) > 0) {
                    llenarGrid(this.lblNumero.getText());
                } else {
                    JOptionPane.showMessageDialog(this, "No existe Información de productos para la Bodega seleccionada", this.titulo, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                }
            }
            rs1.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void crearGrid() {
        this.modelo.addColumn("Id");
        this.modelo.addColumn("Producto");
        this.modelo.addColumn("Rotacion");
        this.modelo.addColumn("Cant. Inventario");
        this.modelo.addColumn("Cant. Física");
        this.modelo.addColumn("Cant. Diferencia");
        this.modelo.addColumn("Valor Unidad");
        this.modelo.addColumn("Costo Diferencia");
        this.modelo.addColumn("Explicación Diferencia");
        this.modelo.addColumn("Acción");
        this.modelo.addColumn("Responsable");
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.grid.getColumnModel().getColumn(0).setMinWidth(80);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(80);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(9).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(8).setMinWidth(0);
        this.grid.getColumnModel().getColumn(8).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(9).setMinWidth(0);
        this.grid.getColumnModel().getColumn(9).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(10).setMinWidth(0);
        this.grid.getColumnModel().getColumn(10).setMaxWidth(0);
    }

    public void evaluarAccion() {
        limpiarGrid();
        this.filaGrid = 0;
        switch (this.opcion) {
            case 1:
                generacion();
                break;
            case 2:
                consultaPorFecha();
                break;
            case 3:
                consultarPorNumero();
                break;
        }
    }

    public void grabar() {
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            this.sql = "UPDATE i_detalleauditoria SET CantidadFisica = '" + this.modelo.getValueAt(i, 4).toString();
            if (this.modelo.getValueAt(i, 8) != null) {
                this.sql += "', Explicacion = '" + this.modelo.getValueAt(i, 8).toString();
            }
            if (this.modelo.getValueAt(i, 9) != null) {
                this.sql += "', Accion = '" + this.modelo.getValueAt(i, 9);
            }
            if (this.modelo.getValueAt(i, 10) != null) {
                this.sql += "', Responsable = '" + this.modelo.getValueAt(i, 10);
            }
            this.sql += "' WHERE (Id ='" + this.lblNumero.getText() + "') AND (IdSuministro ='" + this.modelo.getValueAt(i, 0).toString() + "')";
            this.xconsultas.ejecutarSQL(this.sql);
            this.xconsultas.cerrarConexionBd();
        }
        JOptionPane.showMessageDialog(this, "Grabada las modificaciones del registro", this.titulo, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void generacion() {
        mCrearVista1();
        mGrabarDato();
    }

    private void imprimir(int op) {
        String[][] parametros = new String[8][2];
        parametros[0][0] = "fecha";
        parametros[0][1] = this.xmetodos.formatoAMD.format(Long.valueOf(this.fechaActual.getTime()));
        parametros[1][0] = "numero";
        parametros[1][1] = Principal.txtNo.getText();
        parametros[2][0] = "nbreBodega";
        parametros[2][1] = this.cboBodega.getSelectedItem().toString();
        parametros[3][0] = "vrMinimo";
        parametros[3][1] = this.txtValorMinimo.getValue().toString();
        parametros[4][0] = "vrMaximo";
        parametros[4][1] = this.txtValorMaximo.getValue().toString();
        parametros[5][0] = "cantidad";
        parametros[5][1] = this.txtCantidad.getValue().toString();
        parametros[6][0] = "SUBREPORT_DIR";
        parametros[6][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        parametros[7][0] = "SUBREPORTFIRMA_DIR";
        parametros[7][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        if (op == 1) {
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "I_CuadroAuditoria", parametros);
        } else {
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "I_InformeAuditoria", parametros);
        }
    }

    public void limpiarGrid() {
        int fila = this.modelo.getRowCount();
        if (fila >= 0) {
            for (int i = 1; i <= fila; i++) {
                this.modelo.removeRow(0);
            }
        }
    }

    public void llenarGrid(String numero) {
        try {
            this.sql = "SELECT i_suministro.Nbre, i_presentacioncomercial.Nbre, i_detalleauditoria.Rotacion, i_detalleauditoria.CantidadInventario, i_detalleauditoria.CantidadFisica, i_detalleauditoria.Valor, i_detalleauditoria.Explicacion, i_detalleauditoria.Accion, i_detalleauditoria.Responsable, i_suministro.Id, i_auditoria.Id, i_tipoproducto.Nbre, i_laboratorio.Nbre FROM i_auditoria INNER JOIN i_detalleauditoria ON i_auditoria.Id = i_detalleauditoria.Id INNER JOIN i_suministro ON i_detalleauditoria.IdSuministro = i_suministro.Id INNER JOIN i_presentacioncomercial ON i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id INNER JOIN i_laboratorio ON i_suministro.IdLaboratorio = i_laboratorio.Id INNER JOIN i_tipoproducto ON i_suministro.IdTipoProducto = i_tipoproducto.Id WHERE (i_auditoria.Id = '" + numero + "')";
            ResultSet rs = this.xconsultas.traerRs(this.sql);
            while (rs.next()) {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(12) + " - " + rs.getString(13), this.filaGrid, 1);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(3)), this.filaGrid, 2);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(4)), this.filaGrid, 3);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(5)), this.filaGrid, 4);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(4) - rs.getInt(5)), this.filaGrid, 5);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(6)), this.filaGrid, 6);
                this.modelo.setValueAt(Integer.valueOf(rs.getInt(6) * (rs.getInt(4) - rs.getInt(5))), this.filaGrid, 7);
                this.modelo.setValueAt(rs.getString(7), this.filaGrid, 8);
                this.modelo.setValueAt(rs.getString(8), this.filaGrid, 9);
                this.modelo.setValueAt(rs.getString(9), this.filaGrid, 10);
                this.modelo.setValueAt(rs.getString(10), this.filaGrid, 0);
                this.filaGrid++;
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void sacarProductos(String sql) {
        try {
            ResultSet rs = this.xconsultas.traerRs(sql);
            rs.last();
            int registros = rs.getRow();
            if (registros < Integer.parseInt(this.txtCantidad.getValue().toString()) / 2) {
                JOptionPane.showMessageDialog(this, "La Cantidad de registros consultados es menor a la Cantidad solicitada.\n Se utilizarán solo la Cantidad existente según los valores Mínimo y Máximo", this.titulo, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.txtCantidad.setValue(Integer.valueOf(registros));
            } else {
                for (int i = 0; i < Integer.parseInt(this.txtCantidad.getValue().toString()) / 2; i++) {
                    int producto = (int) (Math.random() * ((double) registros));
                    if (producto > 0) {
                        rs.absolute(producto);
                        int encontrado = 0;
                        int h = 0;
                        while (true) {
                            if (h >= this.modelo.getRowCount()) {
                                break;
                            }
                            if (!this.modelo.getValueAt(h, 0).toString().equals(rs.getString(1))) {
                                h++;
                            } else {
                                encontrado = 1;
                                break;
                            }
                        }
                        if (encontrado == 0) {
                            ConsultasMySQL xct = new ConsultasMySQL();
                            String sql2 = "SELECT sum(Cantidad) FROM  baseserver.i_suministroxlotexbodega WHERE (Id ='" + rs.getString(9) + "') GROUP BY Id";
                            String CantSxB = xct.traerDato(sql2);
                            if (!CantSxB.equals(null) && !CantSxB.equals("") && Integer.parseInt(CantSxB) > 0) {
                                String sql3 = "INSERT INTO i_detalleauditoria(Id, IdSuministro, Rotacion, CantidadInventario, Valor) VALUES ('" + this.IdAuditoria + "','" + rs.getString(1) + "','" + rs.getString(6) + "','" + CantSxB + "','" + rs.getString(7) + "')";
                                xct.ejecutarSQL(sql3);
                                this.modelo.addRow(this.dato);
                                this.modelo.setValueAt(rs.getString(1), this.filaGrid, 0);
                                this.modelo.setValueAt(rs.getString(3) + " - " + rs.getString(4) + " - " + rs.getString(5) + " - " + rs.getString(8), this.filaGrid, 1);
                                this.modelo.setValueAt(rs.getString(6), this.filaGrid, 2);
                                if (CantSxB.equals(null)) {
                                    this.modelo.setValueAt(0, this.filaGrid, 3);
                                } else {
                                    this.modelo.setValueAt(CantSxB, this.filaGrid, 3);
                                }
                                this.modelo.setValueAt(0, this.filaGrid, 4);
                                this.modelo.setValueAt(CantSxB, this.filaGrid, 5);
                                if (rs.getInt(7) < 1) {
                                    this.modelo.setValueAt(0, this.filaGrid, 6);
                                } else {
                                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(7)), this.filaGrid, 6);
                                }
                                this.modelo.setValueAt(Integer.valueOf(Integer.parseInt(CantSxB) * rs.getInt(7)), this.filaGrid, 7);
                                this.filaGrid++;
                            }
                            xct.cerrarConexionBd();
                        }
                    }
                }
                rs.close();
                this.xconsultas.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearVista1() {
        ConsultasMySQL xmt = new ConsultasMySQL();
        xmt.ejecutarSQL("DROP VIEW IF EXISTS i_auditoria_vista");
        xmt.cerrarConexionBd();
        this.sql = "SELECT i_suministro.Id, i_suministro.CodBarraUnidad, i_suministro.Nbre as NSuministro, i_presentacioncomercial.Nbre as NPresentacionC, i_laboratorio.Nbre as NLaboratorio, SUM(i_detallesalida.CantidadDespachada) AS Cantidad, ROUND(AVG(i_detallesalida.ValorUnitario)) AS VUnitario, i_suministroxbodega.Id as IdSBodega FROM i_detallesalida INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_presentacioncomercial ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) INNER JOIN i_tiposmovimientos  ON (i_salidas.IdTipoMovimiento = i_tiposmovimientos.Id) INNER JOIN i_suministroxbodega  ON (i_suministroxbodega.IdSuministro = i_suministro.Id) AND (i_salidas.IdBodega = i_suministroxbodega.IdBodega) WHERE (i_salidas.FechaSalida >='" + this.xmetodos.formatoAMD.format(this.fechaAnterior.getTime()) + "'  AND i_salidas.FechaSalida <='" + this.xmetodos.formatoAMD.format(this.xmetodos.getFechaActual()) + "' AND i_tiposmovimientos.Despacho =1 AND i_salidas.IdBodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "' AND i_salidas.Estado =0 AND ValorUnitario>='" + this.txtValorMinimo.getValue() + "' AND ValorUnitario<='" + this.txtValorMaximo.getValue() + "') GROUP BY i_suministro.Id HAVING (Cantidad <>0) ORDER BY Cantidad DESC ";
        String sqlw = "CREATE VIEW i_auditoria_vista AS " + this.sql;
        xmt.ejecutarSQL(sqlw);
        xmt.cerrarConexionBd();
    }

    private void mGrabarDato() {
        this.sql = "SELECT i_auditoria_vista.Id, i_auditoria_vista.NSuministro, i_auditoria_vista.NPresentacionC, i_auditoria_vista.NLaboratorio, i_auditoria_vista.Cantidad AS NRotacion, SUM(i_suministroxlotexbodega.Cantidad),i_auditoria_vista.VUnitario , i_auditoria_vista.Id FROM i_suministroxlotexbodega INNER JOIN i_auditoria_vista  ON (i_suministroxlotexbodega.Id = i_auditoria_vista.IdSBodega) GROUP BY i_auditoria_vista.Id HAVING (SUM(i_suministroxlotexbodega.Cantidad) <>0) ORDER BY i_auditoria_vista.NSuministro ASC, SUM(i_suministroxlotexbodega.Cantidad) DESC ";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet rs = xct1.traerRs(this.sql);
        try {
            if (rs.next()) {
                mGrabarCabecera();
                rs.last();
                int xn = rs.getRow();
                rs.beforeFirst();
                for (int x = 0; x < Integer.valueOf(this.txtCantidad.getValue().toString()).intValue(); x++) {
                    ConsultasMySQL xct = new ConsultasMySQL();
                    int num = (int) (Math.random() * ((double) (xn - 1)));
                    rs.absolute(num);
                    this.sql = "INSERT INTO i_detalleauditoria(Id, IdSuministro, Rotacion, CantidadInventario, Valor) VALUES ('" + Principal.txtNo.getText() + "','" + rs.getString(1) + "','" + rs.getString(5) + "','" + rs.getString(6) + "','" + rs.getString(7) + "')";
                    xct.ejecutarSQL(this.sql);
                    xct.cerrarConexionBd();
                    this.modelo.addRow(this.dato);
                    this.modelo.setValueAt(rs.getString(1), x, 0);
                    this.modelo.setValueAt(rs.getString(2) + " - " + rs.getString(3) + " - " + rs.getString(4), x, 1);
                    this.modelo.setValueAt(rs.getString(5), x, 2);
                    this.modelo.setValueAt(rs.getString(6), x, 3);
                    this.modelo.setValueAt(0, x, 4);
                    this.modelo.setValueAt(rs.getString(6), x, 5);
                    this.modelo.setValueAt(rs.getString(7), x, 6);
                    this.modelo.setValueAt(Integer.valueOf(rs.getInt(6) * rs.getInt(7)), x, 7);
                }
            }
            rs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriaInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarCabecera() {
        this.sql = "INSERT INTO i_auditoria(FechaAuditoria, IdBodega, VrMinimo, VrMaximo, Cantidad, Fecha, UsuarioS) VALUES ('" + this.xmetodos.formatoAMD.format(this.fechaActual) + "','" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "','" + this.txtValorMinimo.getValue() + "','" + this.txtValorMaximo.getValue() + "','" + this.txtCantidad.getValue() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(this.sql));
    }
}
