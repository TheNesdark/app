package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFFAumentoTarifas.class */
public class JIFFAumentoTarifas extends JInternalFrame {
    private String[] listaManuales;
    private String[] listaTipoPlan;
    private DefaultTableModel xModelo;
    private DefaultTableModel xModeloSum;
    private Object[] xDatos;
    private Object[] xDatosSum;
    private JPanel JPTarifas;
    private JScrollPane JSPPanel;
    private JScrollPane JSPPanel1;
    private JRadioButton btnCentecima;
    private JRadioButton btnCopiarManual;
    private JRadioButton btnCopiarTodo;
    private JRadioButton btnDeAcuerdoAlFactor;
    private JRadioButton btnDecima;
    private JRadioButton btnDecrementarManual;
    private JRadioButton btnFactor;
    private JRadioButton btnIncrementarManual;
    private JRadioButton btnMilecima;
    private JRadioButton btnNinguno;
    private JRadioButton btnPorcentaje;
    private JRadioButton btnSeleccionar;
    private JRadioButton btnSeleccionarSum;
    private JRadioButton btnUnidad;
    private JRadioButton btnValorFijo;
    private JComboBox cboManualD;
    private JComboBox cboManualO;
    private JComboBox cboTipoPlan;
    private JTable grid;
    private JTable gridSum;
    private ButtonGroup grpCopiar;
    private ButtonGroup grpDecremento;
    private ButtonGroup grpIncremento;
    private ButtonGroup grpRedondeo;
    private ButtonGroup grpTipo;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel2;
    private JPanel panelCopia;
    private JPanel panelIncremento;
    private JPanel panelRedondeo;
    private JSpinner txtSalario;
    private JSpinner txtValor;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private int cboLleno = 0;
    private int redondeo = 0;
    private String xOpera = "C";

    public JIFFAumentoTarifas() {
        initComponents();
        desactivarObjetos();
        activarPanelCopia();
        cargarCombos();
        mCargarDatos();
        cargarSMLV();
    }

    /* JADX WARN: Type inference failed for: r3v79, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v86, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.grpTipo = new ButtonGroup();
        this.grpCopiar = new ButtonGroup();
        this.grpIncremento = new ButtonGroup();
        this.grpDecremento = new ButtonGroup();
        this.grpRedondeo = new ButtonGroup();
        this.JPTarifas = new JPanel();
        this.jLabel1 = new JLabel();
        this.panelCopia = new JPanel();
        this.btnCopiarTodo = new JRadioButton();
        this.btnDeAcuerdoAlFactor = new JRadioButton();
        this.panelIncremento = new JPanel();
        this.btnValorFijo = new JRadioButton();
        this.btnPorcentaje = new JRadioButton();
        this.txtValor = new JSpinner();
        this.panelRedondeo = new JPanel();
        this.btnNinguno = new JRadioButton();
        this.btnCentecima = new JRadioButton();
        this.btnMilecima = new JRadioButton();
        this.btnDecima = new JRadioButton();
        this.btnUnidad = new JRadioButton();
        this.jLabel2 = new JLabel();
        this.txtSalario = new JSpinner();
        this.jLabel7 = new JLabel();
        this.jLabel8 = new JLabel();
        this.jLabel9 = new JLabel();
        this.cboManualD = new JComboBox();
        this.cboManualO = new JComboBox();
        this.jPanel2 = new JPanel();
        this.btnCopiarManual = new JRadioButton();
        this.btnIncrementarManual = new JRadioButton();
        this.btnDecrementarManual = new JRadioButton();
        this.btnFactor = new JRadioButton();
        this.jLabel4 = new JLabel();
        this.cboTipoPlan = new JComboBox();
        this.JSPPanel = new JScrollPane();
        this.grid = new JTable();
        this.btnSeleccionar = new JRadioButton();
        this.JSPPanel1 = new JScrollPane();
        this.gridSum = new JTable();
        this.btnSeleccionarSum = new JRadioButton();
        this.jLabel3 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("INCREMENTO, DECREMENTO O TRANSFERENCIA DE TARIFAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifaumentotarifas");
        this.JPTarifas.setName("Tarifas");
        this.JPTarifas.setLayout((LayoutManager) null);
        this.jLabel1.setBackground(new Color(0, 0, 102));
        this.jLabel1.setFont(new Font("Tahoma", 1, 14));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("TARIFAS");
        this.jLabel1.setOpaque(true);
        this.JPTarifas.add(this.jLabel1);
        this.jLabel1.setBounds(10, 10, 870, 30);
        this.panelCopia.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Tahoma", 0, 11), new Color(153, 0, 0)), "Copia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.panelCopia.setLayout((LayoutManager) null);
        this.grpCopiar.add(this.btnCopiarTodo);
        this.btnCopiarTodo.setFont(new Font("Arial", 1, 12));
        this.btnCopiarTodo.setSelected(true);
        this.btnCopiarTodo.setText("Copiar Todo");
        this.panelCopia.add(this.btnCopiarTodo);
        this.btnCopiarTodo.setBounds(20, 30, 150, 23);
        this.grpCopiar.add(this.btnDeAcuerdoAlFactor);
        this.btnDeAcuerdoAlFactor.setFont(new Font("Arial", 1, 12));
        this.btnDeAcuerdoAlFactor.setText("De acuerdo al Factor");
        this.btnDeAcuerdoAlFactor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.1
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnDeAcuerdoAlFactorActionPerformed(evt);
            }
        });
        this.panelCopia.add(this.btnDeAcuerdoAlFactor);
        this.btnDeAcuerdoAlFactor.setBounds(20, 60, 150, 23);
        this.JPTarifas.add(this.panelCopia);
        this.panelCopia.setBounds(10, 110, 180, 100);
        this.panelIncremento.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Tahoma", 0, 11), new Color(204, 0, 0)), "Incremento / Decremento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.panelIncremento.setLayout((LayoutManager) null);
        this.grpDecremento.add(this.btnValorFijo);
        this.btnValorFijo.setFont(new Font("Arial", 1, 12));
        this.btnValorFijo.setSelected(true);
        this.btnValorFijo.setText("Valor Fijo");
        this.btnValorFijo.setEnabled(false);
        this.btnValorFijo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.2
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnValorFijoActionPerformed(evt);
            }
        });
        this.panelIncremento.add(this.btnValorFijo);
        this.btnValorFijo.setBounds(20, 30, 80, 23);
        this.grpDecremento.add(this.btnPorcentaje);
        this.btnPorcentaje.setFont(new Font("Arial", 1, 12));
        this.btnPorcentaje.setText("Porcentaje");
        this.btnPorcentaje.setEnabled(false);
        this.btnPorcentaje.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.3
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnPorcentajeActionPerformed(evt);
            }
        });
        this.panelIncremento.add(this.btnPorcentaje);
        this.btnPorcentaje.setBounds(110, 30, 90, 23);
        this.txtValor.setFont(new Font("Arial", 1, 12));
        this.txtValor.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), (Comparable) null, Float.valueOf(1.0f)));
        this.txtValor.setEnabled(false);
        this.panelIncremento.add(this.txtValor);
        this.txtValor.setBounds(20, 60, 190, 30);
        this.JPTarifas.add(this.panelIncremento);
        this.panelIncremento.setBounds(200, 110, 220, 100);
        this.panelRedondeo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Tahoma", 0, 11), new Color(204, 0, 0)), "Redondeo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.panelRedondeo.setLayout((LayoutManager) null);
        this.grpRedondeo.add(this.btnNinguno);
        this.btnNinguno.setFont(new Font("Arial", 1, 12));
        this.btnNinguno.setSelected(true);
        this.btnNinguno.setText("Ninguno");
        this.btnNinguno.setEnabled(false);
        this.btnNinguno.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.4
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnNingunoActionPerformed(evt);
            }
        });
        this.panelRedondeo.add(this.btnNinguno);
        this.btnNinguno.setBounds(20, 20, 80, 23);
        this.grpRedondeo.add(this.btnCentecima);
        this.btnCentecima.setFont(new Font("Arial", 1, 12));
        this.btnCentecima.setText("Centecima");
        this.btnCentecima.setEnabled(false);
        this.btnCentecima.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.5
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnCentecimaActionPerformed(evt);
            }
        });
        this.panelRedondeo.add(this.btnCentecima);
        this.btnCentecima.setBounds(120, 60, 90, 23);
        this.grpRedondeo.add(this.btnMilecima);
        this.btnMilecima.setFont(new Font("Arial", 1, 12));
        this.btnMilecima.setText("Milecima");
        this.btnMilecima.setEnabled(false);
        this.btnMilecima.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.6
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnMilecimaActionPerformed(evt);
            }
        });
        this.panelRedondeo.add(this.btnMilecima);
        this.btnMilecima.setBounds(210, 20, 80, 23);
        this.grpRedondeo.add(this.btnDecima);
        this.btnDecima.setFont(new Font("Arial", 1, 12));
        this.btnDecima.setText("Decima");
        this.btnDecima.setEnabled(false);
        this.btnDecima.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.7
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnDecimaActionPerformed(evt);
            }
        });
        this.panelRedondeo.add(this.btnDecima);
        this.btnDecima.setBounds(120, 20, 80, 23);
        this.grpRedondeo.add(this.btnUnidad);
        this.btnUnidad.setFont(new Font("Arial", 1, 12));
        this.btnUnidad.setText("Unidad");
        this.btnUnidad.setEnabled(false);
        this.btnUnidad.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.8
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnUnidadActionPerformed(evt);
            }
        });
        this.panelRedondeo.add(this.btnUnidad);
        this.btnUnidad.setBounds(20, 60, 80, 23);
        this.JPTarifas.add(this.panelRedondeo);
        this.panelRedondeo.setBounds(420, 110, 300, 100);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Tipo Producto Suministro");
        this.JPTarifas.add(this.jLabel2);
        this.jLabel2.setBounds(390, 320, 150, 20);
        this.txtSalario.setFont(new Font("Arial", 1, 12));
        this.JPTarifas.add(this.txtSalario);
        this.txtSalario.setBounds(750, 140, 120, 30);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setText("Manual Destino");
        this.JPTarifas.add(this.jLabel7);
        this.jLabel7.setBounds(20, 270, 90, 15);
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setText("Salario MLV");
        this.JPTarifas.add(this.jLabel8);
        this.jLabel8.setBounds(750, 120, 70, 15);
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setText("Manual Origen");
        this.JPTarifas.add(this.jLabel9);
        this.jLabel9.setBounds(20, 230, 90, 15);
        this.cboManualD.setFont(new Font("Arial", 1, 12));
        this.JPTarifas.add(this.cboManualD);
        this.cboManualD.setBounds(230, 260, 650, 30);
        this.cboManualO.setFont(new Font("Arial", 1, 12));
        this.JPTarifas.add(this.cboManualO);
        this.cboManualO.setBounds(230, 220, 650, 30);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Movimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel2.setLayout((LayoutManager) null);
        this.grpTipo.add(this.btnCopiarManual);
        this.btnCopiarManual.setFont(new Font("Arial", 1, 12));
        this.btnCopiarManual.setSelected(true);
        this.btnCopiarManual.setText("Copiar Manual");
        this.btnCopiarManual.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.9
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnCopiarManualActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnCopiarManual);
        this.btnCopiarManual.setBounds(10, 20, 150, 23);
        this.grpTipo.add(this.btnIncrementarManual);
        this.btnIncrementarManual.setFont(new Font("Arial", 1, 12));
        this.btnIncrementarManual.setText("Incrementar Manual");
        this.btnIncrementarManual.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.10
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnIncrementarManualActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnIncrementarManual);
        this.btnIncrementarManual.setBounds(200, 20, 150, 23);
        this.grpTipo.add(this.btnDecrementarManual);
        this.btnDecrementarManual.setFont(new Font("Arial", 1, 12));
        this.btnDecrementarManual.setText("Decrementar Manual");
        this.btnDecrementarManual.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.11
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnDecrementarManualActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnDecrementarManual);
        this.btnDecrementarManual.setBounds(410, 20, 160, 23);
        this.grpTipo.add(this.btnFactor);
        this.btnFactor.setFont(new Font("Arial", 1, 12));
        this.btnFactor.setText("Actualizar de Acuerdo al Factor");
        this.btnFactor.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.12
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnFactorActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.btnFactor);
        this.btnFactor.setBounds(610, 20, 260, 23);
        this.JPTarifas.add(this.jPanel2);
        this.jPanel2.setBounds(10, 50, 870, 50);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setText("Tipo de Plan");
        this.JPTarifas.add(this.jLabel4);
        this.jLabel4.setBounds(760, 320, 100, 20);
        this.cboTipoPlan.setFont(new Font("Arial", 1, 12));
        this.JPTarifas.add(this.cboTipoPlan);
        this.cboTipoPlan.setBounds(760, 350, 120, 30);
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.grid.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFFAumentoTarifas.13
            public void mouseClicked(MouseEvent evt) {
                JIFFAumentoTarifas.this.gridMouseClicked(evt);
            }
        });
        this.JSPPanel.setViewportView(this.grid);
        this.JPTarifas.add(this.JSPPanel);
        this.JSPPanel.setBounds(20, 350, 340, 190);
        this.btnSeleccionar.setFont(new Font("Arial", 1, 12));
        this.btnSeleccionar.setText("Seleccionar Todo");
        this.btnSeleccionar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.14
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnSeleccionarActionPerformed(evt);
            }
        });
        this.JPTarifas.add(this.btnSeleccionar);
        this.btnSeleccionar.setBounds(180, 320, 140, 23);
        this.gridSum.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JSPPanel1.setViewportView(this.gridSum);
        this.JPTarifas.add(this.JSPPanel1);
        this.JSPPanel1.setBounds(390, 350, 340, 190);
        this.btnSeleccionarSum.setFont(new Font("Arial", 1, 12));
        this.btnSeleccionarSum.setText("Seleccionar Todo");
        this.btnSeleccionarSum.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFFAumentoTarifas.15
            public void actionPerformed(ActionEvent evt) {
                JIFFAumentoTarifas.this.btnSeleccionarSumActionPerformed(evt);
            }
        });
        this.JPTarifas.add(this.btnSeleccionarSum);
        this.btnSeleccionarSum.setBounds(590, 320, 130, 23);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Tipo de Procedimiento");
        this.JPTarifas.add(this.jLabel3);
        this.jLabel3.setBounds(20, 320, 190, 20);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPTarifas, -2, 885, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPTarifas, -1, 555, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDeAcuerdoAlFactorActionPerformed(ActionEvent evt) {
        activarPanelRedondeo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnValorFijoActionPerformed(ActionEvent evt) {
        this.txtValor.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnPorcentajeActionPerformed(ActionEvent evt) {
        this.txtValor.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnNingunoActionPerformed(ActionEvent evt) {
        this.redondeo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCentecimaActionPerformed(ActionEvent evt) {
        this.redondeo = 100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnMilecimaActionPerformed(ActionEvent evt) {
        this.redondeo = 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDecimaActionPerformed(ActionEvent evt) {
        this.redondeo = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCopiarManualActionPerformed(ActionEvent evt) {
        copiarManual();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnIncrementarManualActionPerformed(ActionEvent evt) {
        incrementarManual();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnDecrementarManualActionPerformed(ActionEvent evt) {
        incrementarManual();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnFactorActionPerformed(ActionEvent evt) {
        desactivarObjetos();
        activarPanelRedondeo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSeleccionarActionPerformed(ActionEvent evt) {
        mSeleccionar();
        mVerificarMed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnUnidadActionPerformed(ActionEvent evt) {
        this.redondeo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSeleccionarSumActionPerformed(ActionEvent evt) {
        if (this.gridSum.getRowCount() > 0) {
            mSeleccionarSum();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        mVerificarMed();
    }

    private void activarPanelCopia() {
        for (int i = 0; i < this.panelCopia.getComponentCount(); i++) {
            this.panelCopia.getComponent(i).setEnabled(true);
        }
        this.cboManualD.setEnabled(true);
        this.cboTipoPlan.setEnabled(true);
    }

    private void activarPanelIncremento() {
        for (int i = 0; i < this.panelIncremento.getComponentCount(); i++) {
            this.panelIncremento.getComponent(i).setEnabled(true);
        }
    }

    private void activarPanelRedondeo() {
        for (int i = 0; i < this.panelRedondeo.getComponentCount(); i++) {
            this.panelRedondeo.getComponent(i).setEnabled(true);
        }
    }

    private void copiarManual() {
        desactivarObjetos();
        activarPanelCopia();
    }

    private void cargarCombos() {
        this.listaManuales = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_manual WHERE (Estado =0) ORDER BY Nbre ASC", this.listaManuales, this.cboManualO);
        this.listaManuales = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_manual WHERE (Estado =0) ORDER BY Nbre ASC", this.listaManuales, this.cboManualD);
        this.listaTipoPlan = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM f_tipoplan WHERE (Estado =0) ORDER BY Nbre ASC", this.listaTipoPlan, this.cboTipoPlan);
        this.cboManualO.setSelectedIndex(-1);
        this.cboManualD.setSelectedIndex(-1);
        this.cboTipoPlan.setSelectedIndex(-1);
        this.cboLleno = 1;
        this.xconsulta.cerrarConexionBd();
    }

    private void cargarSMLV() {
        String dato = this.xconsulta.traerDato("SELECT SalarioMinimo FROM g_ips");
        this.xconsulta.cerrarConexionBd();
        this.txtSalario.setValue(Integer.valueOf(Integer.parseInt(dato)));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Procedimiento", "Seleccionado"}) { // from class: ParametrizacionN.JIFFAumentoTarifas.16
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.xModelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaSum() {
        this.xModeloSum = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Producto", "Seleccionado"}) { // from class: ParametrizacionN.JIFFAumentoTarifas.17
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.gridSum.setModel(this.xModeloSum);
        this.gridSum.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.gridSum.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.gridSum.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mCargarDatos() {
        mCrearTabla();
        ResultSet xrs = this.xconsulta.traerRs("SELECT f_tipoprocedimiento.Id AS Id, f_tipoprocedimiento.Nbre AS Nbre, 0 Sel FROM f_tipoprocedimiento INNER JOIN f_tipoclaseproc ON (f_tipoprocedimiento.Id_tipoclaseproc = f_tipoclaseproc.Id) WHERE (f_tipoclaseproc.EsQco <>0) ORDER BY f_tipoprocedimiento.Id");
        int xnfila = 0;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDatos);
                    this.xModelo.setValueAt(Long.valueOf(xrs.getLong("Id")), xnfila, 0);
                    this.xModelo.setValueAt(xrs.getString("Nbre"), xnfila, 1);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean("Sel")), xnfila, 2);
                    xnfila++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFAumentoTarifas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarMed() {
        if (this.grid.getValueAt(0, 2).equals(Boolean.TRUE)) {
            if (mVerificarSelSum().equals("")) {
                mCargarDatosSum();
                return;
            }
            return;
        }
        mCrearTablaSum();
    }

    private void mCargarDatosSum() {
        mCrearTablaSum();
        ResultSet xrs = this.xconsulta.traerRs("SELECT Id, Nbre, 0 Sel FROM  i_tipoproducto WHERE Estado=0 ORDER BY Id");
        int xnfila = 0;
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xModeloSum.addRow(this.xDatosSum);
                    this.xModeloSum.setValueAt(Long.valueOf(xrs.getLong("Id")), xnfila, 0);
                    this.xModeloSum.setValueAt(xrs.getString("Nbre"), xnfila, 1);
                    this.xModeloSum.setValueAt(Boolean.valueOf(xrs.getBoolean("Sel")), xnfila, 2);
                    xnfila++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFAumentoTarifas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mSeleccionar() {
        for (int x = 0; x < this.grid.getRowCount(); x++) {
            if (this.btnSeleccionar.isSelected()) {
                this.xModelo.setValueAt(Boolean.TRUE, x, 2);
            } else {
                this.xModelo.setValueAt(Boolean.FALSE, x, 2);
            }
        }
    }

    private void mSeleccionarSum() {
        for (int x = 0; x < this.gridSum.getRowCount(); x++) {
            if (this.btnSeleccionarSum.isSelected()) {
                this.xModeloSum.setValueAt(Boolean.TRUE, x, 2);
            } else {
                this.xModeloSum.setValueAt(Boolean.FALSE, x, 2);
            }
        }
    }

    private String mVerificarSel() {
        String dato = "";
        for (int x = 0; x < this.grid.getRowCount(); x++) {
            if (this.grid.getValueAt(x, 2).equals(Boolean.TRUE)) {
                dato = dato + "," + this.grid.getValueAt(x, 0).toString();
            }
        }
        if (dato.length() > 0) {
            dato = dato.substring(1);
        }
        return dato;
    }

    private String mVerificarSelSum() {
        String dato = "";
        for (int x = 0; x < this.gridSum.getRowCount(); x++) {
            if (this.gridSum.getValueAt(x, 2).equals(Boolean.TRUE)) {
                dato = dato + "," + this.gridSum.getValueAt(x, 0).toString();
            }
        }
        if (dato.length() > 0) {
            dato = dato.substring(1);
        }
        return dato;
    }

    private int mCantidadSel() {
        int cant = 0;
        for (int x = 0; x < this.grid.getRowCount(); x++) {
            if (this.grid.getValueAt(x, 2).equals(Boolean.TRUE)) {
                cant++;
            }
        }
        return cant;
    }

    private int mCantidadSelSum() {
        int cant = 0;
        for (int x = 0; x < this.gridSum.getRowCount(); x++) {
            if (this.gridSum.getValueAt(x, 2).equals(Boolean.TRUE)) {
                cant++;
            }
        }
        return cant;
    }

    private void mValidarOper() {
        if (this.btnCopiarManual.isSelected()) {
            if (this.btnCopiarTodo.isSelected()) {
                this.xOpera = "C";
                return;
            } else {
                if (this.btnDeAcuerdoAlFactor.isEnabled()) {
                    this.xOpera = "CF";
                    return;
                }
                return;
            }
        }
        if (this.btnIncrementarManual.isSelected()) {
            if (this.btnValorFijo.isSelected()) {
                this.xOpera = "+";
                return;
            } else {
                if (this.btnPorcentaje.isSelected()) {
                    this.xOpera = "+%";
                    return;
                }
                return;
            }
        }
        if (this.btnDecrementarManual.isSelected()) {
            if (this.btnValorFijo.isSelected()) {
                this.xOpera = "-";
                return;
            } else {
                if (this.btnPorcentaje.isSelected()) {
                    this.xOpera = "-%";
                    return;
                }
                return;
            }
        }
        if (this.btnFactor.isSelected()) {
            this.xOpera = "F";
        }
    }

    private void tarifas() {
        String valores;
        String sql;
        String sqlm = "";
        String sqlmed = "(SELECT  t.Id_suministro,\n\tt.Id_Manual,\n\tt.Codigo,\nCASE  WHEN @VrRedondeo=0 THEN\n\t Valor\t\n      WHEN @VrRedondeo=1 THEN\n\tROUND(Valor,0)\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(Valor,-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(Valor,-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(Valor,-3) \t \t\nEND Valor, \n\n\nCASE  WHEN @VrRedondeo=0 THEN\n\t(Valor+@VrFijo)\n      WHEN @VrRedondeo=1 THEN\n\tROUND((Valor+@VrFijo),0)\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND((Valor+@VrFijo),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND((Valor+@VrFijo),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND((Valor+@VrFijo),-3) \t \t\nEND VrFijoInc, \n\nCASE WHEN @VrRedondeo=0 THEN\n\t(Valor-@VrFijo)\n     WHEN @VrRedondeo=1 THEN\n\tROUND((Valor-@VrFijo),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND((Valor-@VrFijo),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND((Valor-@VrFijo),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND((Valor-@VrFijo),-3) \t \t\nEND VrFijoDec, \n\nCASE WHEN @VrRedondeo=0 THEN\n\tValor+(Valor*@VrPorc/100)\n     WHEN @VrRedondeo=1 THEN\n\tROUND(Valor+(Valor*@VrPorc/100),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(Valor+(Valor*@VrPorc/100),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(Valor+(Valor*@VrPorc/100),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(Valor+(Valor*@VrPorc/100),-3) \t \t\nEND VrPorcInc, \n\nCASE WHEN @VrRedondeo=0 THEN\n\tValor-(Valor*@VrPorc/100)\n\tWHEN @VrRedondeo=1 THEN\n\tROUND(Valor-(Valor*@VrPorc/100),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(Valor-(Valor*@VrPorc/100),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(Valor-(Valor*@VrPorc/100),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(Valor-(Valor*@VrPorc/100),-3) \t \t\nEND VrPorcDec, \n\nt.Id_TipoPlan,\nt.Fecha,\t\nt.UsuarioS,\n@opera AS opera\n    \t\nFROM (SELECT @VrFijo := " + this.txtValor.getValue().toString() + ") f, \n(SELECT @VrPorc := " + this.txtValor.getValue().toString() + ") p, \n(SELECT @VrRedondeo := " + this.redondeo + ") r, (SELECT @opera:='" + this.xOpera + "') d,  f_tarifasuministro t INNER JOIN i_suministro i ON t.Id_suministro=i.Id \nINNER JOIN i_tipoproducto p ON i.IdTipoProducto=p.id  WHERE t.id_manual='" + this.listaManuales[this.cboManualO.getSelectedIndex()] + "' AND  p.id IN (" + mVerificarSelSum() + ") ) t ";
        String sqlbase = " (SELECT  t.Id_Procedimiento,\n\tt.Id_Manual,\n\tt.CodCUPS,\n\tt.FactorMinimo,\n\tt.FactorMaximo,\nCASE  WHEN @VrRedondeo=0 THEN\n\t VrMinimo\t\n      WHEN @VrRedondeo=1 THEN\n\tROUND(VrMinimo,0)\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(VrMinimo,-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(VrMinimo,-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(VrMinimo,-3) \t \t\nEND VrMinimo, \n\nCASE \tWHEN @VrRedondeo=0 THEN\n\tVrMaximo\n\tWHEN @VrRedondeo=1 THEN\n\tROUND(VrMaximo,0)\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(VrMaximo,-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(VrMaximo,-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(VrMaximo,-3) \t \t\nEND VrMaximo, \n\nCASE  WHEN @VrRedondeo=0 THEN\n\t(VrMinimo+@VrFijo)\n      WHEN @VrRedondeo=1 THEN\n\tROUND((VrMinimo+@VrFijo),0)\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND((VrMinimo+@VrFijo),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND((VrMinimo+@VrFijo),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND((VrMinimo+@VrFijo),-3) \t \t\nEND VrMinFijoInc, \n\nCASE WHEN @VrRedondeo=0 THEN\n\t(VrMaximo+@VrFijo)\n     WHEN @VrRedondeo=1 THEN\n\tROUND((VrMaximo+@VrFijo),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND((VrMaximo+@VrFijo),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND((VrMaximo+@VrFijo),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND((VrMaximo+@VrFijo),-3) \t \t\nEND VrMaxFijoInc, \n\nCASE WHEN @VrRedondeo=0 THEN\n\t(VrMinimo-@VrFijo)\n     WHEN @VrRedondeo=1 THEN\n\tROUND((VrMinimo-@VrFijo),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND((VrMinimo-@VrFijo),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND((VrMinimo-@VrFijo),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND((VrMinimo-@VrFijo),-3) \t \t\nEND VrMinFijoDec, \n\nCASE WHEN @VrRedondeo=0 THEN\n\t(VrMaximo-@VrFijo)\n     WHEN @VrRedondeo=1 THEN\n\tROUND((VrMaximo-@VrFijo),0) \t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND((VrMaximo-@VrFijo),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND((VrMaximo-@VrFijo),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND((VrMaximo-@VrFijo),-3) \t \t\nEND VrMaxFijoDec, \n\nCASE WHEN @VrRedondeo=0 THEN\n\tVrMinimo+(VrMinimo*@VrPorc/100)\n     WHEN @VrRedondeo=1 THEN\n\tROUND(VrMinimo+(VrMinimo*@VrPorc/100),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(VrMinimo+(VrMinimo*@VrPorc/100),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(VrMinimo+(VrMinimo*@VrPorc/100),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(VrMinimo+(VrMinimo*@VrPorc/100),-3) \t \t\nEND VrMinPorcInc, \n\nCASE WHEN @VrRedondeo=0 THEN\n\tVrMaximo+(VrMaximo*@VrPorc/100)\n     WHEN @VrRedondeo=1 THEN\n\tROUND(VrMaximo+(VrMaximo*@VrPorc/100),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(VrMaximo+(VrMaximo*@VrPorc/100),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(VrMaximo+(VrMaximo*@VrPorc/100),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(VrMaximo+(VrMaximo*@VrPorc/100),-3) \t \t\nEND VrMaxPorcInc, \n\nCASE WHEN @VrRedondeo=0 THEN\n\tVrMinimo-(VrMinimo*@VrPorc/100)\n\tWHEN @VrRedondeo=1 THEN\n\tROUND(VrMinimo-(VrMinimo*@VrPorc/100),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(VrMinimo-(VrMinimo*@VrPorc/100),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(VrMinimo-(VrMinimo*@VrPorc/100),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(VrMinimo-(VrMinimo*@VrPorc/100),-3) \t \t\nEND VrMinPorcDec, \n\nCASE WHEN @VrRedondeo=0 THEN\n\tVrMaximo-(VrMaximo*@VrPorc/100)\n     WHEN @VrRedondeo=1 THEN\n\tROUND(VrMaximo-(VrMaximo*@VrPorc/100),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(VrMaximo-(VrMaximo*@VrPorc/100),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(VrMaximo-(VrMaximo*@VrPorc/100),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(VrMaximo-(VrMaximo*@VrPorc/100),-3) \t \t\nEND VrMaxPorcDec, \n\nCASE WHEN @VrRedondeo=0 THEN\n\tFactorMinimo*(@VrSalario/30)\n     WHEN @VrRedondeo=1 THEN\n\tROUND(FactorMinimo*(@VrSalario/30),0)\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(FactorMinimo*(@VrSalario/30),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(FactorMinimo*(@VrSalario/30),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(FactorMinimo*(@VrSalario/30),-3) \t \t\nEND VrMinFactor, \n\nCASE WHEN @VrRedondeo=0 THEN\n\tFactorMaximo*(@VrSalario/30)\n     WHEN @VrRedondeo=1 THEN\n\tROUND(FactorMaximo*(@VrSalario/30),0)\t\t\t\n     WHEN @VrRedondeo=10 THEN\n\tROUND(FactorMaximo*(@VrSalario/30),-1)\n     WHEN @VrRedondeo=100 THEN\n\tROUND(FactorMaximo*(@VrSalario/30),-2)\n       WHEN @VrRedondeo=1000 THEN\n ROUND(FactorMaximo*(@VrSalario/30),-3) \t \t\nEND VrMaxFactor,t.Id_TipoPlan,\nt.Fecha,\nt.UsuarioS,\n@opera AS OPERA \nFROM (SELECT @VrFijo := " + this.txtValor.getValue().toString() + ") f, \n(SELECT @VrPorc := " + this.txtValor.getValue().toString() + ") p, (SELECT @VrSalario := " + this.txtSalario.getValue().toString() + ") s,\n(SELECT @VrRedondeo := " + this.redondeo + ") r, (SELECT @opera:='" + this.xOpera + "') d, f_tarifaprocedimiento t\nINNER JOIN g_procedimiento  ON (t.Id_Procedimiento = g_procedimiento.Id) \nINNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n WHERE t.id_manual='" + this.listaManuales[this.cboManualO.getSelectedIndex()] + "' AND f_tipoprocedimiento.Id IN (" + mVerificarSel() + ")) t ";
        if (this.xOpera.equals("C") || this.xOpera.equals("CF")) {
            if (this.xOpera.equals("C")) {
                valores = "t.VrMinimo,t.VrMaximo,";
            } else {
                valores = "t.VrMinFactor,t.VrMaxFactor,";
            }
            if (this.grid.getValueAt(0, 2).equals(Boolean.TRUE)) {
                sqlm = ("INSERT IGNORE INTO  f_tarifasuministro (Id_suministro, Id_manual, Codigo, Valor, Id_TipoPlan, Fecha, UsuarioS) \nSELECT t.Id_Suministro, " + this.listaManuales[this.cboManualD.getSelectedIndex()] + " AS Id_Manual,  t.Codigo, t.Valor," + this.listaTipoPlan[this.cboTipoPlan.getSelectedIndex()] + " As Id_TipoPlan,'" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' As Fecha, '" + Principal.usuarioSistemaDTO.getLogin() + "' As UsuarioS  FROM \n") + sqlmed;
            }
            String sql2 = "INSERT IGNORE INTO  f_tarifaprocedimiento (Id_Procedimiento,Id_Manual,CodCUPS,FactorMinimo,FactorMaximo, VrMinimo,VrMaximo,Id_TipoPlan,Fecha,UsuarioS) \nSELECT t.Id_Procedimiento, " + this.listaManuales[this.cboManualD.getSelectedIndex()] + " AS Id_Manual, t.CodCUPS,t.FactorMinimo,t.FactorMaximo," + valores + this.listaTipoPlan[this.cboTipoPlan.getSelectedIndex()] + " As Id_TipoPlan,'" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getLogin() + "'  FROM \n";
            sql = sql2 + sqlbase;
        } else {
            if (this.grid.getValueAt(0, 2).equals(Boolean.TRUE)) {
                sqlm = (" UPDATE  f_tarifasuministro f INNER JOIN " + sqlmed) + "ON f.Id_suministro=t.Id_suministro AND f.Id_Manual=t.Id_Manual \nSET f.Valor = CASE WHEN  OPERA='+' THEN\n\t\t\tVrFijoInc\n\t\t     WHEN OPERA='-' THEN\n\t\t\tVrFijoDec\t\n\t\t     WHEN OPERA='+%' THEN\n\t\t\tVrPorcInc\t\t\n\t\t     WHEN OPERA='-%' THEN\n\t\t\tVrPorcDec \n\t\t     WHEN OPERA='F' THEN\n\t\t\tt.Valor \n\t\tEND,\nf.Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',f.UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "'";
            }
            String sql3 = " UPDATE  f_tarifaprocedimiento f INNER JOIN " + sqlbase;
            sql = sql3 + "ON f.Id_Procedimiento=t.Id_Procedimiento AND f.Id_Manual=t.Id_Manual \nSET f.VrMinimo = CASE WHEN  OPERA='+' THEN\n\t\t\tVrMinFijoInc\n\t\t     WHEN OPERA='-' THEN\n\t\t\tVrMinFijoDec\t\n\t\t     WHEN OPERA='+%' THEN\n\t\t\tVrMinPorcInc\t\t\n\t\t     WHEN OPERA='-%' THEN\n\t\t\tVrMinPorcDec \n\t\t     WHEN OPERA='F' THEN \n\t\t\tVrMinFactor\t\n\t\tEND,\n   f.VrMaximo = CASE WHEN  OPERA='+' THEN\n\t\t\tVrMaxFijoInc\n\t\t     WHEN OPERA='-' THEN\n\t\t\tVrMaxFijoDec\t\n\t\t     WHEN OPERA='+%' THEN\n\t\t\tVrMaxPorcInc\t\t\n\t\t     WHEN OPERA='-%' THEN\n\t\t\tVrMaxPorcDec\n\t\t     WHEN OPERA='F' THEN \n\t\t\tVrMaxFactor\t\n\t\tEND,f.Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "',f.UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "'";
        }
        System.out.println("SQL Final:" + sql);
        System.out.println("SQL Final Med:" + sqlm);
        this.xconsulta.ejecutarSQL(sql);
        if (this.grid.getValueAt(0, 2).equals(Boolean.TRUE)) {
            this.xconsulta.ejecutarSQL(sqlm);
        }
        this.xconsulta.cerrarConexionBd();
        if (this.xOpera.equals("C") || this.xOpera.equals("CF")) {
            JOptionPane.showInternalMessageDialog(this, "Manual Transferido Exitosamente", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else {
            JOptionPane.showMessageDialog(this, "Manual de Tarifas Actualizado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void desactivarObjetos() {
        for (int i = 0; i < this.panelCopia.getComponentCount(); i++) {
            this.panelCopia.getComponent(i).setEnabled(false);
        }
        for (int i2 = 0; i2 < this.panelIncremento.getComponentCount(); i2++) {
            this.panelIncremento.getComponent(i2).setEnabled(false);
        }
        for (int i3 = 0; i3 < this.panelRedondeo.getComponentCount(); i3++) {
            this.panelRedondeo.getComponent(i3).setEnabled(false);
        }
        this.cboManualD.setEnabled(false);
        this.cboTipoPlan.setEnabled(false);
    }

    public void mGrabar() {
        if (validar() == 1) {
            mValidarOper();
            if (this.xOpera.equals("C") || this.xOpera.equals("CF")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de la  Transferencia de Tarifas entre\nManual Origen: " + this.listaManuales[this.cboManualO.getSelectedIndex()] + " - " + this.cboManualO.getSelectedItem().toString() + "\nManual Destino: " + this.listaManuales[this.cboManualD.getSelectedIndex()] + " - " + this.cboManualD.getSelectedItem().toString() + "\n", "Confirmar Traslado de Tarifas", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    tarifas();
                    return;
                }
                return;
            }
            int j = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de la  Actualización de Tarifas del \nManual: " + this.listaManuales[this.cboManualO.getSelectedIndex()] + " - " + this.cboManualO.getSelectedItem().toString() + "\n", "Confirmar Actualización de Tarifas", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (j == 0) {
                tarifas();
            }
        }
    }

    private void incrementarManual() {
        desactivarObjetos();
        activarPanelIncremento();
        activarPanelRedondeo();
    }

    private int validar() {
        int valor = 0;
        if (this.cboManualO.getSelectedIndex() < 0) {
            JOptionPane.showInternalMessageDialog(this, "Por favor seleccione el Manual de Origen", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.cboManualO.requestFocus();
        } else if (mCantidadSel() == 0) {
            JOptionPane.showInternalMessageDialog(this, "Por favor seleccione por lo menos un Tipo de Procedimiento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.btnSeleccionar.requestFocus();
        } else if (this.grid.getValueAt(0, 2).equals(Boolean.TRUE) && mCantidadSelSum() == 0) {
            JOptionPane.showInternalMessageDialog(this, "Por favor seleccione por lo menos un Tipo de Producto de los Suministros", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.btnSeleccionarSum.requestFocus();
        } else if ((this.btnCopiarManual.isSelected() && this.btnCopiarTodo.isSelected()) || (this.btnCopiarManual.isSelected() && this.btnDeAcuerdoAlFactor.isSelected())) {
            if (this.cboManualD.getSelectedIndex() < 0) {
                JOptionPane.showInternalMessageDialog(this, "Por favor seleccione el Manual de Destino", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.cboManualD.requestFocus();
            } else if (this.btnDeAcuerdoAlFactor.isSelected() && Integer.parseInt(this.txtSalario.getValue().toString()) < 1) {
                JOptionPane.showInternalMessageDialog(this, "Por favor digite el valor del Salario Mínimo Legal Mensual Vigente", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.txtSalario.requestFocus();
            } else if (this.cboTipoPlan.getSelectedIndex() < 0) {
                JOptionPane.showInternalMessageDialog(this, "Por favor seleccione el Tipo de Plan", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.cboTipoPlan.requestFocus();
            } else {
                valor = 1;
            }
        } else if (this.btnIncrementarManual.isSelected()) {
            if ((this.btnValorFijo.isSelected() || this.btnPorcentaje.isSelected()) && Double.parseDouble(this.txtValor.getValue().toString()) < 1.0d) {
                JOptionPane.showInternalMessageDialog(this, "Por favor digite la Cantidad fija o el porcentaje de incremento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.txtValor.requestFocus();
            } else {
                valor = 1;
            }
        } else if (this.btnDecrementarManual.isSelected()) {
            if ((this.btnValorFijo.isSelected() || this.btnPorcentaje.isSelected()) && Double.parseDouble(this.txtValor.getValue().toString()) < 1.0d) {
                JOptionPane.showInternalMessageDialog(this, "Por favor digite la Cantidad fija o el porcentaje de Decremento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.txtValor.requestFocus();
            } else {
                valor = 1;
            }
        } else if (this.btnFactor.isSelected() && Integer.parseInt(this.txtSalario.getValue().toString()) < 1) {
            JOptionPane.showInternalMessageDialog(this, "Por favor digite el valor del Salario Mínimo Legal Mensual Vigente", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.txtSalario.requestFocus();
        } else {
            valor = 1;
        }
        return valor;
    }
}
