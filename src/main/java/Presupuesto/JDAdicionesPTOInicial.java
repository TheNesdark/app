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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDAdicionesPTOInicial.class */
public class JDAdicionesPTOInicial extends JDialog {
    private Object xLlamador;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xModelogasto;
    private DefaultTableModel xModeloHist;
    private JIFFCarguePTOInicial xJIFFCarguePTOInicial;
    private String[] xIdTipDocumento;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private Metodos xmt;
    private boolean xLleno;
    private int xConsecutivo;
    private String[][] xIdDocumento;
    private String xIdAdicion;
    private JButton JBGrabar;
    private JButton JBImprimir;
    private JButton JBImprimir1;
    private JButton JBImprimir2;
    private JComboBox JCBTipoDocumento;
    public JDateChooser JDFFechaAD;
    public JDateChooser JDFFechaR;
    private JFormattedTextField JFTFValorTotal_Gast;
    private JFormattedTextField JFTFValorTotal_Ing;
    private JLabel JLNoAdicion;
    private JTable JTDetalleGastos;
    private JTable JTDetalleIngresos;
    private JTextField JTFDatosRes;
    private JTextField JTFObservacion;
    private JTextField JTFRuta;
    private JTable JTHistAdicion;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;

    public JDAdicionesPTOInicial(Frame parent, boolean modal, JIFFCarguePTOInicial xJIFFCarguePTOInicial) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xLleno = false;
        this.xConsecutivo = 0;
        this.xIdAdicion = "";
        setTitle("ADICIÓN AL PRESUPUESTO INICIAL");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        initComponents();
        this.xJIFFCarguePTOInicial = xJIFFCarguePTOInicial;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setLocationRelativeTo(null);
        mIniciaComponentes();
        mLlenaTablaIngersos();
        mLlenaTablaGastos();
        mTotaliza();
        mBuscarHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCBTipoDocumento = new JComboBox();
        this.JTFDatosRes = new JTextField();
        this.JDFFechaAD = new JDateChooser();
        this.JDFFechaR = new JDateChooser();
        this.JTFObservacion = new JTextField();
        this.JFTFValorTotal_Ing = new JFormattedTextField();
        this.JBGrabar = new JButton();
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalleIngresos = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleGastos = new JTable();
        this.jScrollPane3 = new JScrollPane();
        this.JTHistAdicion = new JTable();
        this.JFTFValorTotal_Gast = new JFormattedTextField();
        this.JBImprimir = new JButton();
        this.JBImprimir1 = new JButton();
        this.JLNoAdicion = new JLabel();
        this.JTFRuta = new JTextField();
        this.JBImprimir2 = new JButton();
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 100, 32767));
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JDAdicionesPTOInicial.1
            public void itemStateChanged(ItemEvent evt) {
                JDAdicionesPTOInicial.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JTFDatosRes.setFont(new Font("Arial", 1, 12));
        this.JTFDatosRes.setBorder(BorderFactory.createTitledBorder((Border) null, "Acto Admin.", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFFechaAD.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Act. Admin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaAD.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaAD.setFont(new Font("Arial", 1, 12));
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JDFFechaR, -1, 108, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, -2, 288, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDatosRes, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFFechaAD, -2, 121, -2).addGap(22, 22, 22)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFFechaAD, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JCBTipoDocumento, -2, 50, -2).addComponent(this.JTFDatosRes, GroupLayout.Alignment.LEADING)).addGap(12, 12, 12)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFFechaR, -1, -1, 32767).addContainerGap()));
        this.JTFObservacion.setFont(new Font("Arial", 1, 12));
        this.JTFObservacion.setToolTipText("");
        this.JTFObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorTotal_Ing.setEditable(false);
        this.JFTFValorTotal_Ing.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL INGRESOS", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorTotal_Ing.setForeground(Color.red);
        this.JFTFValorTotal_Ing.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFValorTotal_Ing.setHorizontalAlignment(0);
        this.JFTFValorTotal_Ing.setFont(new Font("Arial", 1, 14));
        this.JFTFValorTotal_Ing.addActionListener(new ActionListener() { // from class: Presupuesto.JDAdicionesPTOInicial.2
            public void actionPerformed(ActionEvent evt) {
                JDAdicionesPTOInicial.this.JFTFValorTotal_IngActionPerformed(evt);
            }
        });
        this.JFTFValorTotal_Ing.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JDAdicionesPTOInicial.3
            public void keyTyped(KeyEvent evt) {
                JDAdicionesPTOInicial.this.JFTFValorTotal_IngKeyTyped(evt);
            }
        });
        this.JBGrabar.setFont(new Font("Arial", 1, 14));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Guardar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Presupuesto.JDAdicionesPTOInicial.4
            public void actionPerformed(ActionEvent evt) {
                JDAdicionesPTOInicial.this.JBGrabarActionPerformed(evt);
            }
        });
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleIngresos.setFont(new Font("Arial", 1, 12));
        this.JTDetalleIngresos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleIngresos.setSelectionBackground(Color.white);
        this.JTDetalleIngresos.setSelectionForeground(Color.red);
        this.JTDetalleIngresos.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDAdicionesPTOInicial.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDAdicionesPTOInicial.this.JTDetalleIngresosPropertyChange(evt);
            }
        });
        this.JTDetalleIngresos.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JDAdicionesPTOInicial.6
            public void keyPressed(KeyEvent evt) {
                JDAdicionesPTOInicial.this.JTDetalleIngresosKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalleIngresos);
        this.jTabbedPane1.addTab("INGRESOS", this.jScrollPane1);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane2.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDAdicionesPTOInicial.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDAdicionesPTOInicial.this.jScrollPane2PropertyChange(evt);
            }
        });
        this.JTDetalleGastos.setFont(new Font("Arial", 1, 12));
        this.JTDetalleGastos.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleGastos.setSelectionBackground(Color.white);
        this.JTDetalleGastos.setSelectionForeground(Color.red);
        this.JTDetalleGastos.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDAdicionesPTOInicial.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDAdicionesPTOInicial.this.JTDetalleGastosPropertyChange(evt);
            }
        });
        this.JTDetalleGastos.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JDAdicionesPTOInicial.9
            public void keyPressed(KeyEvent evt) {
                JDAdicionesPTOInicial.this.JTDetalleGastosKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalleGastos);
        this.jTabbedPane1.addTab("GASTOS", this.jScrollPane2);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jScrollPane3.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDAdicionesPTOInicial.10
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDAdicionesPTOInicial.this.jScrollPane3PropertyChange(evt);
            }
        });
        this.JTHistAdicion.setFont(new Font("Arial", 1, 12));
        this.JTHistAdicion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistAdicion.setSelectionBackground(Color.white);
        this.JTHistAdicion.setSelectionForeground(Color.red);
        this.JTHistAdicion.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDAdicionesPTOInicial.11
            public void mouseClicked(MouseEvent evt) {
                JDAdicionesPTOInicial.this.JTHistAdicionMouseClicked(evt);
            }
        });
        this.JTHistAdicion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDAdicionesPTOInicial.12
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDAdicionesPTOInicial.this.JTHistAdicionPropertyChange(evt);
            }
        });
        this.jScrollPane3.setViewportView(this.JTHistAdicion);
        this.jTabbedPane1.addTab("HISTÓRICO", this.jScrollPane3);
        this.JFTFValorTotal_Gast.setEditable(false);
        this.JFTFValorTotal_Gast.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL GASTOS", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorTotal_Gast.setForeground(Color.red);
        this.JFTFValorTotal_Gast.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFValorTotal_Gast.setHorizontalAlignment(0);
        this.JFTFValorTotal_Gast.setFont(new Font("Arial", 1, 14));
        this.JBImprimir.setFont(new Font("Arial", 1, 14));
        this.JBImprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.JBImprimir.setText("Exportar");
        this.JBImprimir.addActionListener(new ActionListener() { // from class: Presupuesto.JDAdicionesPTOInicial.13
            public void actionPerformed(ActionEvent evt) {
                JDAdicionesPTOInicial.this.JBImprimirActionPerformed(evt);
            }
        });
        this.JBImprimir1.setFont(new Font("Arial", 1, 14));
        this.JBImprimir1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBImprimir1.setText("Limpiar");
        this.JBImprimir1.addActionListener(new ActionListener() { // from class: Presupuesto.JDAdicionesPTOInicial.14
            public void actionPerformed(ActionEvent evt) {
                JDAdicionesPTOInicial.this.JBImprimir1ActionPerformed(evt);
            }
        });
        this.JLNoAdicion.setFont(new Font("Arial", 1, 18));
        this.JLNoAdicion.setForeground(Color.red);
        this.JLNoAdicion.setHorizontalAlignment(0);
        this.JLNoAdicion.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Adición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDAdicionesPTOInicial.15
            public void mouseClicked(MouseEvent evt) {
                JDAdicionesPTOInicial.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBImprimir2.setFont(new Font("Arial", 1, 14));
        this.JBImprimir2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.JBImprimir2.setText("Imprimir");
        this.JBImprimir2.addActionListener(new ActionListener() { // from class: Presupuesto.JDAdicionesPTOInicial.16
            public void actionPerformed(ActionEvent evt) {
                JDAdicionesPTOInicial.this.JBImprimir2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jTabbedPane1).addComponent(this.JTFObservacion).addGroup(layout.createSequentialGroup().addComponent(this.JFTFValorTotal_Ing, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFValorTotal_Gast, -2, 169, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLNoAdicion, -2, 120, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JBGrabar, -2, 149, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBImprimir1, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBImprimir2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBImprimir, -2, 147, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 268, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFValorTotal_Ing, -2, 52, -2).addComponent(this.JFTFValorTotal_Gast, -2, 52, -2)).addComponent(this.JLNoAdicion, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFObservacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabar, -2, 36, -2).addComponent(this.JBImprimir1, -2, 36, -2).addComponent(this.JBImprimir2, -2, 36, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 53, -2).addComponent(this.JBImprimir, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JFTFValorTotal_Ing.getAccessibleContext().setAccessibleDescription("");
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
    public void JTDetalleIngresosPropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalleIngresos.getRowCount() > -1 && this.xLleno) {
            mTotaliza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleGastosPropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalleGastos.getRowCount() > -1 && this.xLleno) {
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
            this.xIdAdicion = this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 0).toString();
            this.JLNoAdicion.setText(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 1).toString());
            this.JCBTipoDocumento.setSelectedItem(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 3).toString());
            this.JTFDatosRes.setText(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 6).toString());
            this.JDFFechaAD.setDate(mStringToDate(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 7).toString()));
            this.JDFFechaR.setDate(mStringToDate(this.xModeloHist.getValueAt(this.JTHistAdicion.getSelectedRow(), 2).toString()));
            mBuscaSaldoAdicionRubro();
            this.jTabbedPane1.setSelectedIndex(0);
            mTotaliza();
        }
    }

    private Date mStringToDate(String fechaValue) {
        System.out.println("fechaValue-->" + fechaValue);
        Date fecha = null;
        String anio = fechaValue.substring(0, 4);
        String mes = fechaValue.substring(5, 7);
        String dia = fechaValue.substring(8, 10);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fecha = formato.parse(dia + "/" + mes + "/" + anio);
        } catch (ParseException ex) {
            Logger.getLogger(JDAdicionesPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return fecha;
    }

    private void mBuscaSaldoAdicionRubro() {
        String sql = "SELECT `Valor` , `Id_Rubro`, Estado FROM `pp_detalle_movimiento` WHERE (`Id_Movimiento` ='" + this.xIdAdicion + "' AND idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("mBuscaSaldoAdicionRubro-->" + sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    int i = 0;
                    while (true) {
                        if (i >= this.JTDetalleIngresos.getRowCount()) {
                            break;
                        }
                        if (!this.xmodelo.getValueAt(i, 0).equals(xrs.getString("Id_Rubro"))) {
                            i++;
                        } else {
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Valor")), i, 3);
                            this.xmodelo.setValueAt(xrs.getString("Estado"), i, 4);
                            break;
                        }
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.JTDetalleGastos.getRowCount()) {
                            break;
                        }
                        if (!this.xModelogasto.getValueAt(i2, 0).equals(xrs.getString("Id_Rubro"))) {
                            i2++;
                        } else {
                            this.xModelogasto.setValueAt(Double.valueOf(xrs.getDouble("Valor")), i2, 3);
                            this.xModelogasto.setValueAt(xrs.getString("Estado"), i2, 4);
                            break;
                        }
                    }
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDAdicionesPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImprimirActionPerformed(ActionEvent evt) {
        mExportar();
    }

    private void mExportar() {
        if (this.JTDetalleIngresos.getRowCount() > 0) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("Ingresos", 0);
                    for (int x = 0; x < this.JTDetalleIngresos.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalleIngresos.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalleIngresos.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Number(2, y, Double.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).doubleValue()));
                        sheet.addCell(new Number(3, y, Double.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).doubleValue()));
                        y++;
                    }
                    WritableSheet sheet2 = workbook.createSheet("Gastos", 0);
                    for (int x3 = 0; x3 < this.JTDetalleGastos.getColumnCount(); x3++) {
                        sheet2.addCell(new Label(x3, 0, this.JTDetalleGastos.getColumnName(x3)));
                    }
                    int z = 1;
                    for (int x4 = 0; x4 < this.JTDetalleGastos.getRowCount(); x4++) {
                        sheet2.addCell(new Label(0, z, this.xModelogasto.getValueAt(x4, 0).toString()));
                        sheet2.addCell(new Label(1, z, this.xModelogasto.getValueAt(x4, 1).toString()));
                        sheet2.addCell(new Number(2, z, Double.valueOf(this.xModelogasto.getValueAt(x4, 2).toString()).doubleValue()));
                        sheet2.addCell(new Number(3, z, Double.valueOf(this.xModelogasto.getValueAt(x4, 3).toString()).doubleValue()));
                        z++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (WriteException e) {
                    Logger.getLogger(JDAdiciones.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex) {
                    Logger.getLogger(JDAdiciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImprimir1ActionPerformed(ActionEvent evt) {
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.JTFDatosRes.setText("");
        this.JLNoAdicion.setText("");
        this.xIdAdicion = "";
        mLlenaTablaIngersos();
        mLlenaTablaGastos();
        mTotaliza();
        this.JDFFechaR.setDate(this.xmt.getFechaActual());
        this.JDFFechaAD.setDate(this.xmt.getFechaActual());
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
    public void JTDetalleIngresosKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleGastosKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBImprimir2ActionPerformed(ActionEvent evt) {
        mImprimir(this.xIdAdicion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorTotal_IngActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JFTFValorTotal_IngKeyTyped(KeyEvent evt) {
    }

    private void mIniciaComponentes() {
        this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE (`Id_ClaseDoc`=8 AND `Estado`=1 AND EsReduccion=0)", this.xIdTipDocumento, this.JCBTipoDocumento);
        this.xct.cerrarConexionBd();
        this.JCBTipoDocumento.setSelectedIndex(-1);
        this.JDFFechaR.setDate(this.xmt.getFechaActual());
        this.JDFFechaAD.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosGastos() {
        this.xModelogasto = new DefaultTableModel(new Object[0], new String[]{"Cod.Rubro", "Nombre Rubro", "Valor", "Adición", ""}) { // from class: Presupuesto.JDAdicionesPTOInicial.17
            Class[] types = {String.class, String.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleGastos.setModel(this.xModelogasto);
        this.JTDetalleGastos.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleGastos.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleGastos.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalleGastos.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalleGastos.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleGastos.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleGastos.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosHist() {
        this.xModeloHist = new DefaultTableModel(new Object[0], new String[]{"Id", "Cod. Doc", "Fecha", "Nombre Doc", "Valor", "Observacion", "Acto Admin.", "FechaActo.Admin"}) { // from class: Presupuesto.JDAdicionesPTOInicial.18
            Class[] types = {String.class, String.class, String.class, String.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

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

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosIngreso() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.Rubro", "Nombre Rubro", "Valor", "Adición", ""}) { // from class: Presupuesto.JDAdicionesPTOInicial.19
            Class[] types = {String.class, String.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleIngresos.setModel(this.xmodelo);
        this.JTDetalleIngresos.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalleIngresos.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleIngresos.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalleIngresos.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalleIngresos.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleIngresos.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mLlenaTablaIngersos() {
        mCrearModeloDatosIngreso();
        String sql = "SELECT\n    `pp_rubros`.`Id`\n    , `pp_rubros`.`Nbre`\n    , `pp_detalle_movimiento`.`Valor`\nFROM\n    `pp_detalle_movimiento`\n    INNER JOIN `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_rubros` \n        ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`)\nWHERE (`pp_rubros`.`UltNivel` =1\n    AND `pp_movimiento`.`Id` ='" + Principal.txtNo.getText() + "'\n    AND `pp_movimiento`.`Id_MotivoAnulacion` =1\n    AND `pp_rubros`.`TipoRubro` ='I' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')\n    ORDER BY `pp_rubros`.`Id` ASC";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(0, n, 3);
                    this.xmodelo.setValueAt(0, n, 4);
                    n++;
                }
                this.xLleno = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDAdicionesPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenaTablaGastos() {
        mCrearModeloDatosGastos();
        String sql = "SELECT\n    `pp_rubros`.`Id`\n    , `pp_rubros`.`Nbre`\n    , `pp_detalle_movimiento`.`Valor`\nFROM\n    `pp_detalle_movimiento`\n    INNER JOIN `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_rubros` \n        ON (`pp_detalle_movimiento`.`Id_Rubro` = `pp_rubros`.`Id`) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`)\nWHERE (`pp_rubros`.`UltNivel` =1\n    AND `pp_movimiento`.`Id` ='" + Principal.txtNo.getText() + "'\n    AND `pp_movimiento`.`Id_MotivoAnulacion` =1\n    AND `pp_rubros`.`TipoRubro` ='G' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')\n    ORDER BY `pp_rubros`.`Id` ASC";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xModelogasto.addRow(this.xdatos);
                    this.xModelogasto.setValueAt(xrs.getString(1), n, 0);
                    this.xModelogasto.setValueAt(xrs.getString(2), n, 1);
                    this.xModelogasto.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xModelogasto.setValueAt(0, n, 3);
                    this.xModelogasto.setValueAt(0, n, 4);
                    n++;
                }
                this.xLleno = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDAdicionesPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mTotaliza() {
        double totalGasto = 0.0d;
        double totalIngresos = 0.0d;
        if (this.xLleno) {
            for (int i = 0; i < this.JTDetalleIngresos.getRowCount(); i++) {
                totalIngresos += Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue();
            }
            for (int i2 = 0; i2 < this.JTDetalleGastos.getRowCount(); i2++) {
                totalGasto += Double.valueOf(this.xModelogasto.getValueAt(i2, 3).toString()).doubleValue();
            }
            System.out.println("totalIngresos-->" + totalIngresos);
            System.out.println("totalGasto-->" + totalGasto);
            this.JFTFValorTotal_Ing.setValue(Double.valueOf(totalIngresos));
            this.JFTFValorTotal_Gast.setValue(Double.valueOf(totalGasto));
        }
    }

    private void mGraba() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.JDFFechaR.getDate()))) {
            if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                if (mVerificaSaldoAdicion()) {
                    if (Objects.equals(Double.valueOf(this.JFTFValorTotal_Ing.getValue().toString()), Double.valueOf(this.JFTFValorTotal_Gast.getValue().toString()))) {
                        if (this.xIdAdicion.equals("")) {
                            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                mConcecutivo();
                                String sql = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`         , NoConcecutivo  , DatoResolucion  , FechaAD  , NoDocumentoPadre          ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaR.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.xConsecutivo + "'\t    , '" + this.JTFDatosRes.getText() + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaAD.getDate()) + "', '" + Principal.txtNo.getText() + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                System.out.println("Inserta Encabezado Adicion-->" + sql);
                                String xidAdicion = this.xct.ejecutarSQLId(sql);
                                this.xct.cerrarConexionBd();
                                for (int i = 0; i < this.JTDetalleIngresos.getRowCount(); i++) {
                                    if (Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue() != 0.0d) {
                                        String sql2 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`, idEncabezado)\n VALUES ('" + xidAdicion + "', '" + this.xmodelo.getValueAt(i, 0) + "', '" + Principal.informacionIps.getIdEmpresa() + "', '" + this.xmodelo.getValueAt(i, 3) + "', '" + this.JTFObservacion.getText() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                        System.out.println("Inserta detalle Adicion-->" + sql2);
                                        this.xct.ejecutarSQL(sql2);
                                        this.xct.cerrarConexionBd();
                                    }
                                }
                                for (int i2 = 0; i2 < this.JTDetalleGastos.getRowCount(); i2++) {
                                    if (Double.valueOf(this.xModelogasto.getValueAt(i2, 3).toString()).doubleValue() != 0.0d) {
                                        String sql22 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`, idEncabezado)\n VALUES ('" + xidAdicion + "', '" + this.xModelogasto.getValueAt(i2, 0) + "', '" + Principal.informacionIps.getIdEmpresa() + "', '" + this.xModelogasto.getValueAt(i2, 3) + "', '" + this.JTFObservacion.getText() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                        System.out.println("Inserta detalle Adicion-->" + sql22);
                                        this.xct.ejecutarSQL(sql22);
                                        this.xct.cerrarConexionBd();
                                    }
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
                            this.xct.ejecutarSQL("UPDATE pp_movimiento SET `Observacion`='" + this.JTFObservacion.getText() + ", 'FechaD='" + this.xmt.formatoAMD.format(this.JDFFechaR.getDate()) + "', `IdUsuarioR`='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "', `DatoResolucion`='" + this.JTFDatosRes.getText() + "' , FechaAD='" + this.xmt.formatoAMD.format(this.JDFFechaAD.getDate()) + "', `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' WHERE `Id`='" + this.xIdAdicion + "'");
                            this.xct.cerrarConexionBd();
                            for (int i3 = 0; i3 < this.JTDetalleIngresos.getRowCount(); i3++) {
                                System.out.println("3-->" + Double.valueOf(this.xmodelo.getValueAt(i3, 3).toString()) + " estado-->" + this.xmodelo.getValueAt(i3, 4).toString());
                                if (Double.valueOf(this.xmodelo.getValueAt(i3, 3).toString()).doubleValue() != 0.0d && this.xmodelo.getValueAt(i3, 4).toString().equals("0")) {
                                    String sql23 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`, idEncabezado)\n VALUES ('" + this.xIdAdicion + "', '" + this.xmodelo.getValueAt(i3, 0) + "', '" + Principal.informacionIps.getIdEmpresa() + "', '" + this.xmodelo.getValueAt(i3, 3) + "', '" + this.JTFObservacion.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                    System.out.println("Inserta nuevo detalle Adicion Ingresos-->" + sql23);
                                    this.xct.ejecutarSQL(sql23);
                                    this.xct.cerrarConexionBd();
                                } else if (this.xmodelo.getValueAt(i3, 4).equals("1")) {
                                    System.out.println("Actualiza registro en Ingreso");
                                    String sql24 = "UPDATE `pp_detalle_movimiento` SET  `Valor`='" + this.xmodelo.getValueAt(i3, 3) + "',  Observacion='" + this.JTFObservacion.getText() + "' where (Id_Movimiento='" + this.xIdAdicion + "' AND Id_Rubro='" + this.xmodelo.getValueAt(i3, 0) + "' AND idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
                                    System.out.println("Actualiza detalle Adicion-->" + sql24);
                                    this.xct.ejecutarSQL(sql24);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            for (int i4 = 0; i4 < this.JTDetalleGastos.getRowCount(); i4++) {
                                if (Double.valueOf(this.xModelogasto.getValueAt(i4, 3).toString()).doubleValue() != 0.0d && this.xModelogasto.getValueAt(i4, 4).toString().equals("0")) {
                                    String sql25 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`, idEncabezado)\n VALUES ('" + this.xIdAdicion + "', '" + this.xModelogasto.getValueAt(i4, 0) + "', '" + Principal.informacionIps.getIdEmpresa() + "', '" + this.xModelogasto.getValueAt(i4, 3) + "', '" + this.JTFObservacion.getText() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                    System.out.println("Inserta nuevo detalle Adicion Gasto-->" + sql25);
                                    this.xct.ejecutarSQL(sql25);
                                    this.xct.cerrarConexionBd();
                                } else if (this.xModelogasto.getValueAt(i4, 4).equals("1")) {
                                    String sql26 = "UPDATE `pp_detalle_movimiento` SET  `Valor`='" + this.xModelogasto.getValueAt(i4, 3) + "',  Observacion='" + this.JTFObservacion.getText() + "' where (Id_Movimiento='" + this.xIdAdicion + "' AND Id_Rubro='" + this.xModelogasto.getValueAt(i4, 0) + "' AND idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "')";
                                    System.out.println("Actualiza detalle Adicion Gastos-->" + sql26);
                                    this.xct.ejecutarSQL(sql26);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            this.xJIFFCarguePTOInicial.mBuscaMovimiento(Principal.txtNo.getText());
                            dispose();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "La adición del gasto debe ser igual a la del ingreso", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe digitar por lo menos un saldo en el rubro para la Adición", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
        }
    }

    private boolean mVerificaSaldoAdicion() {
        boolean saldo = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalleIngresos.getRowCount()) {
                break;
            }
            if (Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue() == 0.0d) {
                i++;
            } else {
                saldo = true;
                break;
            }
        }
        return saldo;
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , IFNULL (MAX(`pp_movimiento`.`NoConcecutivo`),0) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (date_format(pp_movimiento.FechaD,'%Y')='" + this.xmt.formatoANO.format(this.JDFFechaR.getDate()) + "' and `pp_tipo_documentos`.`Id_ClaseDoc` ='8'  AND  pp_tipo_documentos.`Id`='" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "');";
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
        String sql = "SELECT\n    `pp_movimiento`.`Id`\n    , `pp_movimiento`.`NoConcecutivo`\n    , `pp_tipo_documentos`.`Nbre` AS TipoDoc\n    , `pp_movimiento`.`FechaD`\n    , `pp_movimiento`.`Observacion`\n    , SUM(`pp_detalle_movimiento`.`Valor`)/2 AS Valor\n, pp_movimiento.DatoResolucion , IF(pp_movimiento.FechaAD IS NULL,'',pp_movimiento.FechaAD) AS FechaAD FROM\n    `pp_detalle_movimiento`\n    INNER JOIN `pp_movimiento` \n        ON (`pp_detalle_movimiento`.`Id_Movimiento` = `pp_movimiento`.`Id`)\n    INNER JOIN `pp_tipo_documentos` \n        ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\n        WHERE pp_tipo_documentos.EsReduccion=0 AND pp_tipo_documentos.`Id_ClaseDoc`=8 AND pp_movimiento.`NoDocumentoPadre`='" + Principal.txtNo.getText() + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "'  \n    GROUP BY pp_movimiento.`Id` \n    ORDER BY pp_movimiento.NoConcecutivo DESC, pp_movimiento.`FechaD` DESC;";
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
            Logger.getLogger(JDAdicionesPTOInicial.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
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
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_Adicion_Reduccion", mparametros);
    }
}
