package Caja;

import Acceso.Principal;
import Facturacion.Facturac;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:Caja/JP_ReciboCaja.class */
public class JP_ReciboCaja extends JPanel {
    private String[][] xId_Fpago;
    private String[][] xId_Concepto;
    private String xsql;
    private String xNombre_Objeto;
    private int xId_Caja;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xDato;
    private Facturac xFacturacion;
    private JButton JBT_Adicionar;
    private JComboBox JCBConcepto_C;
    private JComboBox JCBFPago;
    private JLabel JLB_NRecibo;
    private JPanel JPI_Dato;
    private JPanel JPI_Historico;
    private JPanel JPI_ReciboC;
    private JScrollPane JSP_Detalle;
    private JScrollPane JSP_Detalle1;
    private JTable JTB_Detalle;
    private JTable JTB_Detalle1;
    private JFormattedTextField JTFF_DCantidad;
    private JFormattedTextField JTFF_DVTotal;
    private JFormattedTextField JTFF_DVTotalR;
    private JFormattedTextField JTFF_DVUnitario;
    private JTextField JTFNTransaccion;
    private JTabbedPane JTPDatos;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private int xN_Fila = 0;

    public JP_ReciboCaja(Facturac frm) {
        initComponents();
        this.xFacturacion = frm;
        this.xNombre_Objeto = "Facturacion";
        this.xId_Caja = this.xFacturacion.clasecaja.getIdCaja();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPI_ReciboC = new JPanel();
        this.JPI_Dato = new JPanel();
        this.JCBConcepto_C = new JComboBox();
        this.JTFF_DCantidad = new JFormattedTextField();
        this.JTFF_DVUnitario = new JFormattedTextField();
        this.JTFF_DVTotal = new JFormattedTextField();
        this.JBT_Adicionar = new JButton();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        this.JCBFPago = new JComboBox();
        this.JTFNTransaccion = new JTextField();
        this.JTFF_DVTotalR = new JFormattedTextField();
        this.JLB_NRecibo = new JLabel();
        this.JPI_Historico = new JPanel();
        this.JSP_Detalle1 = new JScrollPane();
        this.JTB_Detalle1 = new JTable();
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JPI_Dato.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBConcepto_C.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto_C.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto_C.addItemListener(new ItemListener() { // from class: Caja.JP_ReciboCaja.1
            public void itemStateChanged(ItemEvent evt) {
                JP_ReciboCaja.this.JCBConcepto_CItemStateChanged(evt);
            }
        });
        this.JTFF_DCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_DCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFF_DCantidad.setHorizontalAlignment(4);
        this.JTFF_DCantidad.setText("1");
        this.JTFF_DCantidad.setFont(new Font("Arial", 1, 12));
        this.JTFF_DCantidad.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JP_ReciboCaja.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_ReciboCaja.this.JTFF_DCantidadPropertyChange(evt);
            }
        });
        this.JTFF_DVUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_DVUnitario.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_DVUnitario.setHorizontalAlignment(4);
        this.JTFF_DVUnitario.setFont(new Font("Arial", 1, 12));
        this.JTFF_DVUnitario.addPropertyChangeListener(new PropertyChangeListener() { // from class: Caja.JP_ReciboCaja.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JP_ReciboCaja.this.JTFF_DVUnitarioPropertyChange(evt);
            }
        });
        this.JTFF_DVTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_DVTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_DVTotal.setHorizontalAlignment(4);
        this.JTFF_DVTotal.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar.setText("Adicionar");
        this.JBT_Adicionar.addActionListener(new ActionListener() { // from class: Caja.JP_ReciboCaja.4
            public void actionPerformed(ActionEvent evt) {
                JP_ReciboCaja.this.JBT_AdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatoLayout = new GroupLayout(this.JPI_Dato);
        this.JPI_Dato.setLayout(JPI_DatoLayout);
        JPI_DatoLayout.setHorizontalGroup(JPI_DatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Adicionar, -1, -1, 32767).addGroup(JPI_DatoLayout.createSequentialGroup().addComponent(this.JCBConcepto_C, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JTFF_DCantidad, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_DVUnitario, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_DVTotal, -2, 104, -2))).addContainerGap()));
        JPI_DatoLayout.setVerticalGroup(JPI_DatoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatoLayout.createSequentialGroup().addGroup(JPI_DatoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConcepto_C, -2, 50, -2).addComponent(this.JTFF_DCantidad, -2, 50, -2).addComponent(this.JTFF_DVUnitario, -2, 50, -2).addComponent(this.JTFF_DVTotal, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Adicionar, -1, 44, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle.setSelectionForeground(Color.red);
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        this.JCBFPago.setFont(new Font("Arial", 1, 12));
        this.JCBFPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFPago.addItemListener(new ItemListener() { // from class: Caja.JP_ReciboCaja.5
            public void itemStateChanged(ItemEvent evt) {
                JP_ReciboCaja.this.JCBFPagoItemStateChanged(evt);
            }
        });
        this.JTFNTransaccion.setFont(new Font("Arial", 1, 12));
        this.JTFNTransaccion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Transacción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_DVTotalR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Recibo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_DVTotalR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_DVTotalR.setHorizontalAlignment(4);
        this.JTFF_DVTotalR.setFont(new Font("Arial", 1, 12));
        this.JLB_NRecibo.setFont(new Font("Arial", 1, 14));
        this.JLB_NRecibo.setForeground(Color.red);
        this.JLB_NRecibo.setHorizontalAlignment(0);
        this.JLB_NRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Recibo", 2, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout JPI_ReciboCLayout = new GroupLayout(this.JPI_ReciboC);
        this.JPI_ReciboC.setLayout(JPI_ReciboCLayout);
        JPI_ReciboCLayout.setHorizontalGroup(JPI_ReciboCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ReciboCLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ReciboCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Dato, -1, -1, 32767).addComponent(this.JSP_Detalle).addGroup(JPI_ReciboCLayout.createSequentialGroup().addComponent(this.JCBFPago, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNTransaccion, -2, 135, -2).addGap(18, 18, 18).addComponent(this.JLB_NRecibo, -2, 181, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, 32767).addComponent(this.JTFF_DVTotalR, -2, 187, -2))).addContainerGap()));
        JPI_ReciboCLayout.setVerticalGroup(JPI_ReciboCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ReciboCLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Dato, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_Detalle, -1, 133, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_ReciboCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_NRecibo, -2, 50, -2).addGroup(JPI_ReciboCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFPago, -2, 50, -2).addComponent(this.JTFNTransaccion, -2, 50, -2).addComponent(this.JTFF_DVTotalR, -2, 50, -2))).addContainerGap()));
        this.JTPDatos.addTab("RECIBO", this.JPI_ReciboC);
        this.JSP_Detalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTB_Detalle1.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Detalle1.setRowHeight(25);
        this.JTB_Detalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Detalle1.setSelectionForeground(Color.red);
        this.JTB_Detalle1.addMouseListener(new MouseAdapter() { // from class: Caja.JP_ReciboCaja.6
            public void mouseClicked(MouseEvent evt) {
                JP_ReciboCaja.this.JTB_Detalle1MouseClicked(evt);
            }
        });
        this.JTB_Detalle1.addKeyListener(new KeyAdapter() { // from class: Caja.JP_ReciboCaja.7
            public void keyPressed(KeyEvent evt) {
                JP_ReciboCaja.this.JTB_Detalle1KeyPressed(evt);
            }
        });
        this.JSP_Detalle1.setViewportView(this.JTB_Detalle1);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Detalle1).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JSP_Detalle1, -1, 312, 32767).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFPagoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBFPago.getSelectedIndex() != -1) {
            if (this.xId_Fpago[this.JCBFPago.getSelectedIndex()][1].equals("1")) {
                this.JTFNTransaccion.setEnabled(true);
                this.JTFNTransaccion.requestFocus();
            } else {
                this.JTFNTransaccion.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBConcepto_C.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConcepto_C.requestFocus();
            return;
        }
        if (Long.valueOf(this.JTFF_DCantidad.getText()).longValue() == 0) {
            JOptionPane.showInternalMessageDialog(this, "Cantidad debe ser mayor a uno", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFF_DCantidad.requestFocus();
            return;
        }
        if (Double.valueOf(this.JTFF_DVUnitario.getText()).doubleValue() != 0.0d) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(this.xId_Concepto[this.JCBConcepto_C.getSelectedIndex()][0], this.xN_Fila, 0);
            this.xmodelo.setValueAt(this.JCBConcepto_C.getSelectedItem(), this.xN_Fila, 1);
            this.xmodelo.setValueAt(this.JTFF_DCantidad.getValue(), this.xN_Fila, 2);
            this.xmodelo.setValueAt(this.JTFF_DVUnitario.getValue(), this.xN_Fila, 3);
            this.xmodelo.setValueAt(this.JTFF_DVTotal.getValue(), this.xN_Fila, 4);
            this.xN_Fila++;
            mCalculat_Total_Recibo();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Valor deber ser mayor a uno", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFF_DVUnitario.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConcepto_CItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBConcepto_C.getSelectedIndex() != -1) {
            this.JTFF_DVUnitario.setValue(Double.valueOf(this.xId_Concepto[this.JCBConcepto_C.getSelectedIndex()][2]));
            mCalcular_VTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_DCantidadPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCalcular_VTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_DVUnitarioPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mCalcular_VTotal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_Detalle1MouseClicked(MouseEvent evt) {
        if (this.JTB_Detalle1.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            this.xFacturacion.clasecaja.imprimirRecibo(this.xmodelo1.getValueAt(this.JTB_Detalle1.getSelectedRow(), 9).toString(), String.valueOf(this.xmodelo1.getValueAt(this.JTB_Detalle1.getSelectedRow(), 3).toString()), String.valueOf(this.xmodelo1.getValueAt(this.JTB_Detalle1.getSelectedRow(), 8).toString()), this.xFacturacion);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_Detalle1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTB_Detalle1.getSelectedRow() != -1 && Long.valueOf(this.xmodelo1.getValueAt(this.JTB_Detalle1.getSelectedRow(), 6).toString()).longValue() == 0) {
            int x = JOptionPane.showConfirmDialog((Component) null, "Desea anular el recibo seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "Recibo Caja", 12);
                frm.setVisible(true);
            }
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCBConcepto_C.removeAllItems();
        this.xsql = "SELECT k_cajaxconceptos.Id_Concepto, k_conceptos.Nbre, k_conceptos.Abono, k_conceptos.Valor FROM k_cajaxconceptos INNER JOIN k_conceptos ON (k_cajaxconceptos.Id_Concepto = k_conceptos.Id) WHERE (k_cajaxconceptos.Id_Caja ='" + this.xId_Caja + "' AND k_cajaxconceptos.Estado =1) ORDER BY Orden asc, k_conceptos.Nbre ASC";
        this.xId_Concepto = this.xct.llenarComboyLista(this.xsql, this.xId_Concepto, this.JCBConcepto_C, 4);
        this.JCBConcepto_C.setSelectedIndex(-1);
        this.JCBFPago.removeAllItems();
        this.xId_Fpago = this.xct.llenarComboyLista("SELECT  `Id` , `Nbre` , `DatosA` FROM `k_formapago` WHERE (`Estado` =1) ORDER BY `Orden` ASC, `Nbre` ASC", this.xId_Fpago, this.JCBFPago, 3);
        this.JCBFPago.setSelectedIndex(0);
        this.xct.cerrarConexionBd();
        this.JTFF_DCantidad.setValue(new Integer(1));
        this.JTFF_DVUnitario.setValue(new Double(0.0d));
        this.JTFF_DVTotal.setValue(new Double(0.0d));
        this.JTFF_DVTotalR.setValue(new Double(0.0d));
        this.JTFNTransaccion.setText("");
        this.JLB_NRecibo.setText("");
        mCrearTablaDetalle();
        mCrearTablaHistorico();
        this.xlleno = true;
    }

    private void mCrearTablaDetalle() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Concepto", "Cantidad", "V/Unitario", "V/Total"}) { // from class: Caja.JP_ReciboCaja.8
            Class[] types = {Long.class, String.class, Long.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTB_Detalle.setModel(this.xmodelo);
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTB_Detalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.xN_Fila = 0;
    }

    private void mCrearTablaHistorico() {
        this.xmodelo1 = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Caja", "Forma de Pago", "N° Transacción", "V/Total", "Id_Cierre", "Estado", "Id_Caja", "IdRecibo"}) { // from class: Caja.JP_ReciboCaja.9
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Double.class, Long.class, Boolean.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTB_Detalle1.setModel(this.xmodelo1);
        this.JTB_Detalle1.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTB_Detalle1.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTB_Detalle1.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTB_Detalle1.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTB_Detalle1.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTB_Detalle1.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTB_Detalle1.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTB_Detalle1.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTB_Detalle1.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTB_Detalle1.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    private void mCalcular_VTotal() {
        if (!this.JTFF_DCantidad.getText().equals("") && !this.JTFF_DCantidad.getText().equals("0")) {
            this.JTFF_DVTotal.setValue(Double.valueOf(Long.valueOf(this.JTFF_DCantidad.getValue().toString()).longValue() * Double.valueOf(this.JTFF_DVUnitario.getValue().toString()).doubleValue()));
        }
    }

    private void mCalculat_Total_Recibo() {
        if (this.JTB_Detalle.getRowCount() != -1) {
            double xvalor = 0.0d;
            for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                xvalor += Long.valueOf(this.xmodelo.getValueAt(x, 2).toString()).longValue() * Double.valueOf(this.xmodelo.getValueAt(x, 3).toString()).doubleValue();
            }
            this.JTFF_DVTotalR.setValue(Double.valueOf(xvalor));
        }
    }

    public void mGrabar() {
        if (this.JLB_NRecibo.getText().isEmpty()) {
            if (this.JCBFPago.getSelectedIndex() != -1) {
                if (this.JTB_Detalle.getRowCount() > 0) {
                    if (this.xNombre_Objeto.equals("Facturacion")) {
                        if (!Principal.clasefacturacion.frmFacturac.frmPersona.getIdPersona().equals("") || !Principal.clasefacturacion.frmFacturac.frmPersona.getIdPersona().equals("0")) {
                            if (Principal.clasefacturacion.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex() != -1) {
                                this.xsql = "insert into k_recibos_n (`Id_Caja`, `Id_Persona`, `Id_EmpresaContxConv`, `FechaR`, `NoRecibo`, `Id_FPago`, `NTransaccion`, `VDescuento`, `Valor`, `Observacion`,  `Id_Liquidacion`,  `Id_Tercero`, `UsuarioS`, `Id_UsuarioS`) values('" + this.xFacturacion.clasecaja.getIdCaja() + "','" + this.xFacturacion.frmPersona.getIdPersona() + "','" + this.xFacturacion.frmIngreso.getIdEmpresa() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + String.valueOf(Integer.parseInt(this.xFacturacion.clasecaja.getUltimoNoRecibo()) + 1) + "','" + this.xId_Fpago[this.JCBFPago.getSelectedIndex()][0] + "','" + this.JTFNTransaccion.getText() + "','0','" + this.JTFF_DVTotalR.getValue() + "','','0','" + mConsultar_IdTercero() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                                long id_recibo = Long.valueOf(this.xct.ejecutarSQLId(this.xsql)).longValue();
                                this.xct.cerrarConexionBd();
                                this.JLB_NRecibo.setText(this.xFacturacion.clasecaja.setActualizarNoRecibo());
                                for (int x = 0; x < this.JTB_Detalle.getRowCount(); x++) {
                                    this.xsql = "INSERT INTO k_itemrecibos (Id_Recibo, Id_Concepto, Cantidad, VrUnitario) VALUES ('" + id_recibo + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "','" + this.xmodelo.getValueAt(x, 3) + "')";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                }
                                this.xFacturacion.clasecaja.imprimirRecibo(String.valueOf(id_recibo), String.valueOf(this.JTFF_DVTotalR.getValue().toString()), String.valueOf(this.xFacturacion.clasecaja.getIdCaja()), this.xFacturacion);
                                mCargar_DatosHistorico();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.xFacturacion.frmIngreso.cboEmpresa.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.xFacturacion.frmPersona.txtHistoria.requestFocus();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe agregar un concepto de pago", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una forma de pago", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBFPago.requestFocus();
        }
    }

    public void mCargar_DatosHistorico() {
        try {
            mCrearTablaHistorico();
            this.xsql = "SELECT  `k_recibos_n`.`NoRecibo` , date_format(`k_recibos_n`.`FechaR`,'%d-%m-%Y') as fecha , `k_caja`.`Nbre` , `k_formapago`.`Nbre` , `k_recibos_n`.`NTransaccion` , `k_recibos_n`.`Valor` , `k_recibos_n`.`Id_Cierre` , `k_recibos_n`.`Estado`,`k_recibos_n`.`Id_Caja`, `k_recibos_n`.`Id` FROM  `k_recibos_n` INNER JOIN  `k_caja`  ON (`k_recibos_n`.`Id_Caja` = `k_caja`.`Id`) INNER JOIN  `k_formapago`  ON (`k_recibos_n`.`Id_FPago` = `k_formapago`.`Id`)  WHERE (`k_recibos_n`.`Id_Persona` ='" + this.xFacturacion.frmPersona.getIdPersona() + "') ORDER BY `k_recibos_n`.`FechaR` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xDato);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(1)), xnfila, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), xnfila, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), xnfila, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), xnfila, 4);
                    this.xmodelo1.setValueAt(Double.valueOf(xrs.getDouble(6)), xnfila, 5);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(7)), xnfila, 6);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(8)), xnfila, 7);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong("Id_Caja")), xnfila, 8);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong("Id")), xnfila, 9);
                    xnfila++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_ReciboCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mConsultar_IdTercero() {
        String xid = "0";
        try {
            this.xsql = "SELECT  `Id` FROM `g_empresa` WHERE (`Id_TipoIdentificacion` ='" + this.xFacturacion.frmPersona.listaTipoIdentificacion[this.xFacturacion.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0] + "' AND `No_identificacion` ='" + this.xFacturacion.frmPersona.txtIdentificacion.getText() + "') ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xid = xrs.getString(1);
            } else {
                this.xsql = "insert into g_empresa (    `Apellido1` , `Apellido2` , `Nombre1` , `Nombre2` , `Id_TipoIdentificacion` , `No_identificacion` , Dig_Verificacion, `Id_Municipio` , `Direccion` , `Tel_Numero` , `FacTInterna` , `Fecha` , `UsuarioS` )values('" + this.xFacturacion.frmPersona.txtApellido1.getText() + "','" + this.xFacturacion.frmPersona.txtApellido2.getText() + "','" + this.xFacturacion.frmPersona.txtNombre1.getText() + "','" + this.xFacturacion.frmPersona.txtNombre2.getText() + "','" + this.xFacturacion.frmPersona.listaTipoIdentificacion[this.xFacturacion.frmPersona.cboTipoIdentificacion.getSelectedIndex()][0] + "','" + this.xFacturacion.frmPersona.txtIdentificacion.getText() + "','','" + this.xFacturacion.frmPersona.listaMunicipio[this.xFacturacion.frmPersona.cboMunicipio.getSelectedIndex()] + "','" + this.xFacturacion.frmPersona.txtDireccion.getText() + "','" + this.xFacturacion.frmPersona.txtTelefono.getText() + "','1','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                xid = this.xct.ejecutarSQLId(this.xsql);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JP_ReciboCaja.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xid;
    }

    public void mAnular(String xid, String xdetalle) {
        this.xsql = "update k_recibos_n set `Estado`=0, `Id_Motivo_Anulacion`='" + xid + "', `Observacion_Anulado`='" + xdetalle + "', `UsuarioA`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `FechaA`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where NoRecibo='" + this.xmodelo1.getValueAt(this.JTB_Detalle1.getSelectedRow(), 0) + "' and Id_Caja='" + this.xmodelo1.getValueAt(this.JTB_Detalle1.getSelectedRow(), 8) + "'";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        mCargar_DatosHistorico();
    }
}
