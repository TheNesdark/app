package Presupuesto;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
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
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDTrasladoPTOInicial.class */
public class JDTrasladoPTOInicial extends JDialog {
    private Object xLlamador;
    private DefaultTableModel xModelogasto;
    private DefaultTableModel xModeloHist;
    private JIFFCarguePTOInicial xJIFFCarguePTOInicial;
    private String[] xIdTipDocumento;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private String[] xIdRubros;
    private Metodos xmt;
    private boolean xLleno;
    private int xConsecutivo;
    private String[][] xIdDocumento;
    private String xIdTraslado;
    private boolean xllenoRubro;
    private int xTipo;
    private int xFila;
    private JButton JBAdicionar;
    private JButton JBGrabar;
    private JButton JBImprimir;
    private JButton JBImprimir2;
    private JButton JBLimpia;
    private JComboBox JCBRubros;
    private JComboBox JCBTipoDocumento;
    private JFormattedTextField JFTFValor;
    private JFormattedTextField JFTFValorSaldoR;
    private JFormattedTextField JFTFValorTotal_Cre;
    private JFormattedTextField JFTFValorTotal_Debito;
    private JLabel JLNoAdicion;
    private JRadioButton JRBCredito;
    private JRadioButton JRBDebito;
    private JTable JTDetalleTraslado;
    private JTextField JTFCodigoRbro;
    private JTextField JTFDatosRes;
    private JTextField JTFObservacion;
    private JTextField JTFRuta;
    private JTable JTHistAdicion;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    public JDateChooser txtFechaAD;
    public JDateChooser txtFechaR;

    public JDTrasladoPTOInicial(Frame parent, boolean modal, JIFFCarguePTOInicial xJIFFCarguePTOInicial) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xLleno = false;
        this.xConsecutivo = 0;
        this.xIdTraslado = "";
        this.xllenoRubro = false;
        this.xTipo = 1;
        this.xFila = 0;
        setTitle("TRASLADO AL PRESUPUESTO INICIAL");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        initComponents();
        this.xJIFFCarguePTOInicial = xJIFFCarguePTOInicial;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setLocationRelativeTo(null);
        mIniciaComponentes();
        mCrearModeloDatosTraslado();
        mBuscarHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v103, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JCBTipoDocumento = new JComboBox();
        this.JTFDatosRes = new JTextField();
        this.txtFechaAD = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.txtFechaR = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
        this.JTFObservacion = new JTextField();
        this.JFTFValorTotal_Cre = new JFormattedTextField();
        this.JBGrabar = new JButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel3 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleTraslado = new JTable();
        this.JTFCodigoRbro = new JTextField();
        this.JCBRubros = new JComboBox();
        this.JFTFValor = new JFormattedTextField();
        this.JFTFValorSaldoR = new JFormattedTextField();
        this.jPanel4 = new JPanel();
        this.JRBCredito = new JRadioButton();
        this.JRBDebito = new JRadioButton();
        this.JBAdicionar = new JButton();
        this.jScrollPane3 = new JScrollPane();
        this.JTHistAdicion = new JTable();
        this.JFTFValorTotal_Debito = new JFormattedTextField();
        this.JBLimpia = new JButton();
        this.JLNoAdicion = new JLabel();
        this.JBImprimir = new JButton();
        this.JTFRuta = new JTextField();
        this.JBImprimir2 = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JDTrasladoPTOInicial.1
            public void itemStateChanged(ItemEvent evt) {
                JDTrasladoPTOInicial.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JTFDatosRes.setFont(new Font("Arial", 1, 12));
        this.JTFDatosRes.setBorder(BorderFactory.createTitledBorder((Border) null, "Acto Admin.", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.txtFechaAD.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Act. Admin.", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.txtFechaAD.setDateFormatString("dd/MM/yyyy");
        this.txtFechaAD.setFont(new Font("Tahoma", 1, 12));
        this.txtFechaAD.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JDTrasladoPTOInicial.2
            public void keyPressed(KeyEvent evt) {
                JDTrasladoPTOInicial.this.txtFechaADKeyPressed(evt);
            }
        });
        this.txtFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.txtFechaR.setDateFormatString("dd/MM/yyyy");
        this.txtFechaR.setFont(new Font("Tahoma", 1, 12));
        this.txtFechaR.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JDTrasladoPTOInicial.3
            public void keyPressed(KeyEvent evt) {
                JDTrasladoPTOInicial.this.txtFechaRKeyPressed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.txtFechaR, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDatosRes, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtFechaAD, -2, 123, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFechaR, -2, 50, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtFechaAD, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFDatosRes, -2, 50, -2).addComponent(this.JCBTipoDocumento, -2, 50, -2)))).addContainerGap(-1, 32767)));
        this.JTFObservacion.setFont(new Font("Arial", 1, 12));
        this.JTFObservacion.setToolTipText("");
        this.JTFObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorTotal_Cre.setEditable(false);
        this.JFTFValorTotal_Cre.setBackground(new Color(255, 255, 255));
        this.JFTFValorTotal_Cre.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL CRÉDITO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorTotal_Cre.setForeground(Color.red);
        this.JFTFValorTotal_Cre.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorTotal_Cre.setHorizontalAlignment(0);
        this.JFTFValorTotal_Cre.setText("0");
        this.JFTFValorTotal_Cre.setFont(new Font("Arial", 1, 14));
        this.JBGrabar.setFont(new Font("Arial", 1, 14));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Guardar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.4
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JBGrabarActionPerformed(evt);
            }
        });
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane2.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDTrasladoPTOInicial.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDTrasladoPTOInicial.this.jScrollPane2PropertyChange(evt);
            }
        });
        this.JTDetalleTraslado.setFont(new Font("Arial", 1, 12));
        this.JTDetalleTraslado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleTraslado.setSelectionBackground(Color.white);
        this.JTDetalleTraslado.setSelectionForeground(Color.red);
        this.JTDetalleTraslado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDTrasladoPTOInicial.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDTrasladoPTOInicial.this.JTDetalleTrasladoPropertyChange(evt);
            }
        });
        this.JTDetalleTraslado.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JDTrasladoPTOInicial.7
            public void keyPressed(KeyEvent evt) {
                JDTrasladoPTOInicial.this.JTDetalleTrasladoKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalleTraslado);
        this.JTFCodigoRbro.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoRbro.setToolTipText("");
        this.JTFCodigoRbro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoRbro.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.8
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JTFCodigoRbroActionPerformed(evt);
            }
        });
        this.JTFCodigoRbro.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JDTrasladoPTOInicial.9
            public void focusLost(FocusEvent evt) {
                JDTrasladoPTOInicial.this.JTFCodigoRbroFocusLost(evt);
            }
        });
        this.JCBRubros.setFont(new Font("Arial", 1, 12));
        this.JCBRubros.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRubros.addItemListener(new ItemListener() { // from class: Presupuesto.JDTrasladoPTOInicial.10
            public void itemStateChanged(ItemEvent evt) {
                JDTrasladoPTOInicial.this.JCBRubrosItemStateChanged(evt);
            }
        });
        this.JCBRubros.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.11
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JCBRubrosActionPerformed(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValor.setHorizontalAlignment(0);
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        this.JFTFValorSaldoR.setEditable(false);
        this.JFTFValorSaldoR.setBackground(new Color(255, 255, 255));
        this.JFTFValorSaldoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorSaldoR.setForeground(Color.red);
        this.JFTFValorSaldoR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorSaldoR.setHorizontalAlignment(0);
        this.JFTFValorSaldoR.setText("0");
        this.JFTFValorSaldoR.setFont(new Font("Arial", 1, 14));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.buttonGroup1.add(this.JRBCredito);
        this.JRBCredito.setFont(new Font("Arial", 1, 12));
        this.JRBCredito.setSelected(true);
        this.JRBCredito.setText("Crédito");
        this.JRBCredito.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.12
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JRBCreditoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBDebito);
        this.JRBDebito.setFont(new Font("Arial", 1, 12));
        this.JRBDebito.setText("Débito");
        this.JRBDebito.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.13
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JRBDebitoActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBCredito).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBDebito).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCredito).addComponent(this.JRBDebito)).addContainerGap(-1, 32767)));
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.14
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JBAdicionarActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFCodigoRbro, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRubros, -2, 441, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValor, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorSaldoR, -2, 125, -2)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar, -1, -1, 32767))).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigoRbro, -2, 53, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBRubros, -2, 52, -2).addComponent(this.JFTFValor, -2, 52, -2).addComponent(this.JFTFValorSaldoR, -2, 52, -2))).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel4, -2, 51, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBAdicionar, -2, 40, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 163, -2).addContainerGap()));
        this.jTabbedPane1.addTab("DETALLE", this.jPanel3);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane3.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDTrasladoPTOInicial.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDTrasladoPTOInicial.this.jScrollPane3PropertyChange(evt);
            }
        });
        this.JTHistAdicion.setFont(new Font("Arial", 1, 12));
        this.JTHistAdicion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistAdicion.setSelectionBackground(Color.white);
        this.JTHistAdicion.setSelectionForeground(Color.red);
        this.JTHistAdicion.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDTrasladoPTOInicial.16
            public void mouseClicked(MouseEvent evt) {
                JDTrasladoPTOInicial.this.JTHistAdicionMouseClicked(evt);
            }
        });
        this.JTHistAdicion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDTrasladoPTOInicial.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDTrasladoPTOInicial.this.JTHistAdicionPropertyChange(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTHistAdicion);
        this.jTabbedPane1.addTab("HISTÓRICO", this.jScrollPane3);
        this.JFTFValorTotal_Debito.setEditable(false);
        this.JFTFValorTotal_Debito.setBackground(new Color(255, 255, 255));
        this.JFTFValorTotal_Debito.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL CONTRACRÉDITO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorTotal_Debito.setForeground(Color.red);
        this.JFTFValorTotal_Debito.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorTotal_Debito.setHorizontalAlignment(0);
        this.JFTFValorTotal_Debito.setText("0");
        this.JFTFValorTotal_Debito.setFont(new Font("Arial", 1, 14));
        this.JBLimpia.setFont(new Font("Arial", 1, 14));
        this.JBLimpia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBLimpia.setText("Limpiar");
        this.JBLimpia.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.18
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JBLimpiaActionPerformed(evt);
            }
        });
        this.JLNoAdicion.setFont(new Font("Arial", 1, 18));
        this.JLNoAdicion.setForeground(Color.red);
        this.JLNoAdicion.setHorizontalAlignment(0);
        this.JLNoAdicion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Traslado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBImprimir.setFont(new Font("Arial", 1, 14));
        this.JBImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.JBImprimir.setText("Exportar");
        this.JBImprimir.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.19
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JBImprimirActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDTrasladoPTOInicial.20
            public void mouseClicked(MouseEvent evt) {
                JDTrasladoPTOInicial.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBImprimir2.setFont(new Font("Arial", 1, 14));
        this.JBImprimir2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBImprimir2.setText("Imprimir");
        this.JBImprimir2.addActionListener(new ActionListener() { // from class: Presupuesto.JDTrasladoPTOInicial.21
            public void actionPerformed(ActionEvent evt) {
                JDTrasladoPTOInicial.this.JBImprimir2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jTabbedPane1).addComponent(this.JTFObservacion).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JLNoAdicion, -2, 142, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 651, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBImprimir, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JFTFValorTotal_Cre, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFValorTotal_Debito, -2, 169, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JBGrabar, -2, 183, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBLimpia, -2, 154, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBImprimir2))).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -1, 322, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFValorTotal_Cre, -2, 52, -2).addComponent(this.JFTFValorTotal_Debito, -2, 52, -2)).addComponent(this.JLNoAdicion, -2, 52, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFObservacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabar, -2, 36, -2).addComponent(this.JBLimpia, -2, 36, -2).addComponent(this.JBImprimir2, -2, 36, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBImprimir, -1, -1, 32767).addComponent(this.JTFRuta, -1, 53, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGraba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleTrasladoPropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalleTraslado.getRowCount() > -1) {
            mTotaliza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jScrollPane2PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistAdicionPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jScrollPane3PropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistAdicionMouseClicked(MouseEvent evt) {
        if (this.JTHistAdicion.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            this.xIdTraslado = this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 0).toString();
            this.JLNoAdicion.setText(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 1).toString());
            this.JCBTipoDocumento.setSelectedItem(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 3).toString());
            this.JTFDatosRes.setText(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 6).toString());
            this.txtFechaR.setDate(Date.valueOf(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 2).toString()));
            this.txtFechaAD.setDate(Date.valueOf(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 7).toString()));
            this.jTabbedPane1.setSelectedIndex(0);
            mBuscaRubrosTraslado();
        }
    }

    private void mBuscaRubrosTraslado() {
        mCrearModeloDatosTraslado();
        String sql = "SELECT\n    `pp_detalle_movimiento`.`Id_Rubro`\n    , `pp_rubros`.`Nbre` as Rubro\n    , `pp_detalle_movimiento`.`Valor`\n    , `pp_detalle_movimiento`.`Tipo`\n    , `pp_detalle_movimiento`.`Estado`\nFROM `pp_detalle_movimiento` INNER JOIN `pp_rubros` \n        ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`)\nWHERE (`pp_detalle_movimiento`.`Id_Movimiento` ='" + this.xIdTraslado + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                this.xFila = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xModelogasto.addRow(this.xdatos);
                    this.xModelogasto.setValueAt(xrs.getString("Id_Rubro"), this.xFila, 0);
                    this.xModelogasto.setValueAt(xrs.getString("Rubro"), this.xFila, 1);
                    this.xModelogasto.setValueAt(Double.valueOf(xrs.getDouble("Valor")), this.xFila, 2);
                    this.xModelogasto.setValueAt(0, this.xFila, 3);
                    if (xrs.getInt("Tipo") == 1) {
                        this.xModelogasto.setValueAt("C", this.xFila, 4);
                    } else {
                        this.xModelogasto.setValueAt("D", this.xFila, 4);
                    }
                    this.xModelogasto.setValueAt(xrs.getString("Estado"), this.xFila, 5);
                    this.xModelogasto.setValueAt(xrs.getString("Tipo"), this.xFila, 6);
                    this.xFila++;
                    this.xLleno = true;
                }
            }
            mTotaliza();
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDTrasladoPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBLimpiaActionPerformed(ActionEvent evt) {
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.JTFDatosRes.setText("");
        this.JLNoAdicion.setText("");
        this.xIdTraslado = "";
        this.JTFObservacion.setText("");
        this.xFila = 0;
        mCrearModeloDatosTraslado();
        mLimpia();
        mTotaliza();
        this.txtFechaR.setDate(this.xmt.getFechaActual());
        this.txtFechaAD.setDate(this.xmt.getFechaActual());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroActionPerformed(ActionEvent evt) {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
            mVerificarRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroFocusLost(FocusEvent evt) {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
            mVerificarRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRubrosItemStateChanged(ItemEvent evt) {
        if (this.xllenoRubro && this.JCBRubros.getSelectedIndex() > -1) {
            this.JTFCodigoRbro.setText(this.xIdRubros[this.JCBRubros.getSelectedIndex()]);
            mSaldoRubro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRubrosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCreditoActionPerformed(ActionEvent evt) {
        this.xTipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDebitoActionPerformed(ActionEvent evt) {
        this.xTipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        mAdicionar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaADKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaRKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImprimirActionPerformed(ActionEvent evt) {
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleTrasladoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            this.xModelogasto.removeRow(this.JTDetalleTraslado.getSelectedRow());
            this.xFila--;
            mTotaliza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImprimir2ActionPerformed(ActionEvent evt) {
        mImprimir(this.xIdTraslado);
    }

    private void mExportar() {
        if (this.JTDetalleTraslado.getRowCount() > 0) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("Traslados", 0);
                    for (int x = 0; x < this.JTDetalleTraslado.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalleTraslado.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalleTraslado.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, y, this.xModelogasto.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xModelogasto.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Number(2, y, Double.valueOf(this.xModelogasto.getValueAt(x2, 2).toString()).doubleValue()));
                        sheet.addCell(new Label(3, y, this.xModelogasto.getValueAt(x2, 4).toString()));
                        y++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JDTrasladoPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JDTrasladoPTOInicial.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            }
        }
    }

    private void mAdicionar() {
        if (this.JCBRubros.getSelectedIndex() > -1) {
            if (mVerificaRubroTabla()) {
                JOptionPane.showMessageDialog(this, "Ya existe este rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            if (Double.valueOf(this.JFTFValor.getValue().toString()).doubleValue() > 0.0d) {
                if (mVerificaSaldoRubro()) {
                    this.xModelogasto.addRow(this.xdatos);
                    this.xModelogasto.setValueAt(this.xIdRubros[this.JCBRubros.getSelectedIndex()], this.xFila, 0);
                    this.xModelogasto.setValueAt(this.JCBRubros.getSelectedItem(), this.xFila, 1);
                    this.xModelogasto.setValueAt(this.JFTFValor.getValue(), this.xFila, 2);
                    this.xModelogasto.setValueAt(this.JFTFValorSaldoR.getValue(), this.xFila, 3);
                    if (this.xTipo == 1) {
                        this.xModelogasto.setValueAt("C", this.xFila, 4);
                    } else {
                        this.xModelogasto.setValueAt("D", this.xFila, 4);
                    }
                    this.xModelogasto.setValueAt(0, this.xFila, 5);
                    this.xModelogasto.setValueAt(Integer.valueOf(this.xTipo), this.xFila, 6);
                    this.xFila++;
                    this.xLleno = true;
                    mLimpia();
                    mTotaliza();
                    return;
                }
                JOptionPane.showMessageDialog(this, "el valor debe ser menor al saldo del Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JFTFValor.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "El valor debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JFTFValor.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBRubros.requestFocus();
    }

    private void mLimpia() {
        this.JTFCodigoRbro.setText("");
        this.JCBRubros.setSelectedIndex(-1);
        this.JFTFValor.setValue(0);
        this.JFTFValorSaldoR.setValue(0);
        this.xTipo = 1;
        this.JRBCredito.setSelected(true);
    }

    private boolean mVerificaSaldoRubro() {
        boolean x = false;
        if (this.JRBDebito.isSelected()) {
            if (Double.valueOf(this.JFTFValor.getValue().toString()).doubleValue() <= Double.valueOf(this.JFTFValorSaldoR.getValue().toString()).doubleValue()) {
                x = true;
            }
        } else if (this.JRBCredito.isSelected()) {
            x = true;
        }
        return x;
    }

    private void mSaldoRubro() {
        String sql = "SELECT  \nr.Id\n,r.IdPadre\n,r.Nbre\n,r.TipoRubro\n,Presupuesto_Inicial\n,Adicion_Presupuesto\n,Reduccion_Presupuesto\n,Traslados_Debitos\n,Traslados_Creditos\n,Presupuesto_Definitivo\n,Reconocimiento_Anterior\n,Reconocimiento_Actual\n,Reconocimiento_Total\n,Recaudo_Anterior\n,Recaudo_Actual\n,Recaudo_Total\n,Saldo_por_Ejecutar\n,Saldo_por_Recaudar \n,Certificado_Anterior\n,Certificado_Actual\n,Total_Certificados\n,Compromiso_Anterior\n,Compromiso_Actual\n,Compromiso_Total\n,Obligacion_Anterior\n,Obligacion_Actual\n,Total_Obligaciones\n,Pagos_Anterior\n,Pagos_Actual\n,Total_Pagos\n,Saldo_Disponible\n,Sin_Comprometer\n,Compromisos_por_Pagar\n,Cuentas_por_Pagar\n,Certificado_sin_Comprometer\n\nFROM pp_rubros r\nINNER JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n/*Actualizacion con nuevos clase documentos*/ \n/*Disponibilidad CDP*/\n ,(Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)  AS Certificado_Anterior\n ,(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)  AS Certificado_Actual\n ,((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)) Total_Certificados\n/*Compromiso RP*/\n ,(Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior) AS Compromiso_Anterior\n ,(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual) AS Compromiso_Actual\n ,((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual)) Compromiso_Total\n /*Obligacion OP*/\n ,(Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior) AS Obligacion_Anterior\n ,(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual) AS Obligacion_Actual\n ,((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual)) Total_Obligaciones\n /*Pagos PP*/\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n /*Operaciones...*/\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- ((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Sin_Comprometer\n ,(((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,(((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual))-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,(((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\n-- -------------------------------------------------------------\n,SUM(IFNULL(Adicion_Disponibilidad_Anterior,0)) Adicion_Disponibilidad_Anterior\n,SUM(IFNULL(Adicion_Disponibilidad_Actual,0)) Adicion_Disponibilidad_Actual\n,SUM(IFNULL(Reintegro_Disponibilidad_Anterior,0)) Reintegro_Disponibilidad_Anterior\n,SUM(IFNULL(Reintegro_Disponibilidad_Actual,0)) Reintegro_Disponibilidad_Actual\n,SUM(IFNULL(Adicion_Compromiso_Anterior,0)) Adicion_Compromiso_Anterior\n,SUM(IFNULL(Adicion_Compromiso_Actual,0)) Adicion_Compromiso_Actual\n,SUM(IFNULL(Reintegro_Compromiso_Anterior,0)) Reintegro_Compromiso_Anterior\n,SUM(IFNULL(Reintegro_Compromiso_Actual,0)) Reintegro_Compromiso_Actual\n,SUM(IFNULL(Adicion_Obligacion_Anterior,0)) Adicion_Obligacion_Anterior\n,SUM(IFNULL(Adicion_Obligacion_Actual,0)) Adicion_Obligacion_Actual\n,SUM(IFNULL(Reintegro_Obligacion_Anterior,0)) Reintegro_Obligacion_Anterior\n,SUM(IFNULL(Reintegro_Obligacion_Actual,0)) Reintegro_Obligacion_Actual\n\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD=9  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD=9  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD=4  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Compromiso_Anterior\n \n ,CASE WHEN Id_CD=4  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Compromiso_Actual\n \n,CASE WHEN Id_CD=5  AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Obligacion_Anterior\n \n,CASE WHEN Id_CD=5  AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Obligacion_Actual \n \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n -- -------------------------------------------------------\n /*\n10\tAdicion Disponibilidad\n11\tReintegro Disponibilidad\n12\tAdicion Compromiso\n13\tReintegro Compromiso\n14\tAdicion Obligación\n15\tReintegro Obligación\n*/\n ,CASE WHEN Id_CD=10 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=10 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Actual\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Actual\n\n ,CASE WHEN Id_CD=12 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=12 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Actual\n\n ,CASE WHEN Id_CD=13 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=13 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Reintegro_Compromiso_Actual \n    \n ,CASE WHEN Id_CD=14 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=14 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Adicion_Obligacion_Actual\n  \n,CASE WHEN Id_CD=15 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=15 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Actual\n \n\nFROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE   pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n    WHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') pact\n    WHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n    OR pact.Id=pant.id\n         )  \n    AND pp_movimiento.Id_MotivoAnulacion=1  and pp_detalle_movimiento.Estado =1 AND pp_rubros.`Id`='" + this.xIdRubros[this.JCBRubros.getSelectedIndex()] + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' \n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos ) datos\nON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "';";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("Saldo Disponible-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                double valor = xrs.getDouble("Saldo_Disponible");
                this.JFTFValorSaldoR.setValue(Double.valueOf(valor));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificarRubro() {
        String sql = "SELECT CONCAT(Nbre, ' - ',Id) AS Rubro FROM `pp_rubros` WHERE idEncabezadoRubro='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' and Id='" + this.JTFCodigoRbro.getText() + "'";
        System.out.println("Entra Sql-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JCBRubros.setSelectedItem(xrs.getString("Rubro"));
            } else {
                this.JCBRubros.setSelectedIndex(-1);
                this.JTFCodigoRbro.setText("");
                JOptionPane.showMessageDialog(this, "Rubro no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDTrasladoPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciaComponentes() {
        this.JFTFValor.setValue(0);
        this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=7 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
        this.xct.cerrarConexionBd();
        this.JCBTipoDocumento.setSelectedIndex(-1);
        String sql = "SELECT `pp_rubro_x_tipo_doc`.`IdRubro`,concat(`pp_rubros`.`Nbre`, ' - ', `pp_rubro_x_tipo_doc`.`IdRubro`) AS Rubro FROM `pp_rubro_x_tipo_doc` INNER JOIN  `pp_rubros` ON (`pp_rubro_x_tipo_doc`.`IdRubro` = `pp_rubros`.`Id`) WHERE (pp_rubro_x_tipo_doc.idEncabezadoRubro ='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' and `pp_rubro_x_tipo_doc`.`Estado` =1 ) GROUP BY pp_rubros.`Id` ORDER BY `pp_rubro_x_tipo_doc`.`IdRubro` ASC;";
        System.out.println("Items COmbo-->" + sql);
        this.xIdRubros = this.xct.llenarCombo(sql, this.xIdRubros, this.JCBRubros);
        this.JCBRubros.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xllenoRubro = true;
        this.txtFechaAD.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTraslado() {
        this.xModelogasto = new DefaultTableModel(new Object[0], new String[]{"Cod.Rubro", "Nombre Rubro", "Valor", "Saldo", "Tipo", "Estado", "TipoR"}) { // from class: Presupuesto.JDTrasladoPTOInicial.22
            Class[] types = {String.class, String.class, Double.class, Double.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleTraslado.setModel(this.xModelogasto);
        this.JTDetalleTraslado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleTraslado.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleTraslado.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalleTraslado.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalleTraslado.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleTraslado.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleTraslado.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosHist() {
        this.xModeloHist = new DefaultTableModel(new Object[0], new String[]{"Id", "Cod. Doc", "Fecha", "Nombre Doc", "Valor", "Observacion", "Acto Admin.", "FechaActo.Admin"}) { // from class: Presupuesto.JDTrasladoPTOInicial.23
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistAdicion.setModel(this.xModeloHist);
        this.JTHistAdicion.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTHistAdicion.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistAdicion.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistAdicion.getColumnModel().getColumn(1).setPreferredWidth(15);
        this.JTHistAdicion.getColumnModel().getColumn(2).setPreferredWidth(15);
        this.JTHistAdicion.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTHistAdicion.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTHistAdicion.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTHistAdicion.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTHistAdicion.getColumnModel().getColumn(7).setPreferredWidth(10);
    }

    private void mTotaliza() {
        double totalCredito = 0.0d;
        double totalDebito = 0.0d;
        if (this.xLleno) {
            for (int i = 0; i < this.JTDetalleTraslado.getRowCount(); i++) {
                if (this.xModelogasto.getValueAt(i, 4).toString().equals("C")) {
                    totalCredito += Double.valueOf(this.xModelogasto.getValueAt(i, 2).toString()).doubleValue();
                } else {
                    totalDebito += Double.valueOf(this.xModelogasto.getValueAt(i, 2).toString()).doubleValue();
                }
            }
            this.JFTFValorTotal_Cre.setValue(Double.valueOf(totalCredito));
            this.JFTFValorTotal_Debito.setValue(Double.valueOf(totalDebito));
        }
    }

    private void mGraba() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.txtFechaR.getDate()))) {
            if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                if (this.JTDetalleTraslado.getRowCount() > 0) {
                    if (Objects.equals(Double.valueOf(this.JFTFValorTotal_Cre.getValue().toString()), Double.valueOf(this.JFTFValorTotal_Debito.getValue().toString()))) {
                        if (this.xIdTraslado.equals("")) {
                            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                mConcecutivo();
                                String sql = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`         , NoConcecutivo  , DatoResolucion  , FechaAD  , NoDocumentoPadre          ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.txtFechaR.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.xConsecutivo + "'\t    , '" + this.JTFDatosRes.getText() + "'\t    , '" + this.xmt.formatoAMD.format(this.txtFechaAD.getDate()) + "', '" + Principal.txtNo.getText() + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                System.out.println("Inserta Encabezado Adicion-->" + sql);
                                String xidTrasladoMov = this.xct.ejecutarSQLId(sql);
                                this.xct.cerrarConexionBd();
                                for (int i = 0; i < this.JTDetalleTraslado.getRowCount(); i++) {
                                    String sql2 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`, Tipo,  `Observacion`, idEncabezado)\n VALUES ('" + xidTrasladoMov + "', '" + this.xModelogasto.getValueAt(i, 0) + "', '" + Principal.informacionIps.getIdEmpresa() + "', '" + this.xModelogasto.getValueAt(i, 2) + "', '" + this.xModelogasto.getValueAt(i, 6) + "','" + this.JTFObservacion.getText() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                    System.out.println("Inserta detalle Adicion-->" + sql2);
                                    this.xct.ejecutarSQL(sql2);
                                    this.xct.cerrarConexionBd();
                                }
                                this.xJIFFCarguePTOInicial.mBuscaMovimiento(Principal.txtNo.getText());
                                dispose();
                                return;
                            }
                            return;
                        }
                        int n2 = JOptionPane.showConfirmDialog(this, "Esta seguro de Actualizar la Información?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n2 == 0) {
                            System.out.println("Actualiza-->");
                            this.xct.ejecutarSQL("UPDATE pp_movimiento SET `Observacion`='" + this.JTFObservacion.getText() + "',FechaD='" + this.xmt.formatoAMD.format(this.txtFechaR.getDate()) + "', `IdUsuarioR`='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "', `DatoResolucion`='" + this.JTFDatosRes.getText() + "' , FechaAD='" + this.xmt.formatoAMD.format(this.txtFechaAD.getDate()) + "', `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id`='" + this.xIdTraslado + "'");
                            this.xct.cerrarConexionBd();
                            for (int i2 = 0; i2 < this.JTDetalleTraslado.getRowCount(); i2++) {
                                if (this.xModelogasto.getValueAt(i2, 5).toString().equals("0")) {
                                    String sql22 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  Tipo, `Observacion`, idEncabezado)\n VALUES ('" + this.xIdTraslado + "', '" + this.xModelogasto.getValueAt(i2, 0) + "', '" + Principal.informacionIps.getIdEmpresa() + "', '" + this.xModelogasto.getValueAt(i2, 2) + "', '" + this.xModelogasto.getValueAt(i2, 6) + "','" + this.JTFObservacion.getText() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                    System.out.println("Inserta nuevo detalle Traslado Ingresos-->" + sql22);
                                    this.xct.ejecutarSQL(sql22);
                                    this.xct.cerrarConexionBd();
                                } else if (this.xModelogasto.getValueAt(i2, 5).equals("1")) {
                                    System.out.println("Actualiza registro en Ingreso");
                                    String sql23 = "UPDATE `pp_detalle_movimiento` SET  `Valor`='" + this.xModelogasto.getValueAt(i2, 2) + "',  Observacion='" + this.JTFObservacion.getText() + "' where (Id_Movimiento='" + this.xIdTraslado + "' AND Id_Rubro='" + this.xModelogasto.getValueAt(i2, 0) + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
                                    System.out.println("Actualiza detalle Traslado-->" + sql23);
                                    this.xct.ejecutarSQL(sql23);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            this.xJIFFCarguePTOInicial.mBuscaMovimiento(Principal.txtNo.getText());
                            dispose();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "El credito debe ser igual al debito", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe cargar rubros a la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , MAX(`pp_movimiento`.`NoConcecutivo`) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='7' and DATE_FORMAT(pp_movimiento.`FechaD`, '%Y') ='" + this.xmt.formatoANO.format(this.txtFechaR.getDate()) + "' AND  pp_tipo_documentos.`Id`='" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "');";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    private void mBuscarHistorico() {
        String sql = "SELECT\n    `pp_movimiento`.`Id`\n    , `pp_movimiento`.`NoConcecutivo`\n    , `pp_tipo_documentos`.`Nbre` AS TipoDoc\n    , `pp_movimiento`.`FechaD`\n    , `pp_movimiento`.`Observacion`\n    , SUM(`pp_detalle_movimiento`.`Valor`)/2 AS Valor\n, pp_movimiento.DatoResolucion , IF(pp_movimiento.FechaAD IS NULL,'',pp_movimiento.FechaAD) AS FechaAD FROM\n    `pp_detalle_movimiento`\n    INNER JOIN `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n        WHERE pp_tipo_documentos.`Id_ClaseDoc`=7 AND pp_movimiento.`NoDocumentoPadre`='" + Principal.txtNo.getText() + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'  \n    GROUP BY pp_movimiento.`Id` \n    ORDER BY pp_movimiento.NoConcecutivo DESC, pp_movimiento.`FechaD` DESC;";
        mCrearModeloDatosHist();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModeloHist.addRow(this.xdatos);
                    this.xModeloHist.setValueAt(xrs.getString("Id"), n, 0);
                    this.xModeloHist.setValueAt(xrs.getString("NoConcecutivo"), n, 1);
                    this.xModeloHist.setValueAt(xrs.getString("FechaD"), n, 2);
                    this.xModeloHist.setValueAt(xrs.getString("TipoDoc"), n, 3);
                    this.xModeloHist.setValueAt(Double.valueOf(xrs.getDouble("Valor")), n, 4);
                    this.xModeloHist.setValueAt(xrs.getString("Observacion"), n, 5);
                    this.xModeloHist.setValueAt(xrs.getString("DatoResolucion"), n, 6);
                    this.xModeloHist.setValueAt(xrs.getString("FechaAD"), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDTrasladoPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaRubroTabla() {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalleTraslado.getRowCount()) {
                break;
            }
            if (!this.xModelogasto.getValueAt(i, 0).toString().equals(this.xIdRubros[this.JCBRubros.getSelectedIndex()])) {
                i++;
            } else {
                xExiste = true;
                break;
            }
        }
        return xExiste;
    }

    public void mImprimir(String xid) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = xid;
        mparametros[1][0] = "idEncabezado";
        mparametros[1][1] = Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_Traslado", mparametros);
    }
}
