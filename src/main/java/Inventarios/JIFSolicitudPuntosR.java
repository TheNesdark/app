package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFSolicitudPuntosR.class */
public class JIFSolicitudPuntosR extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidempresa;
    private String[] xidordenc;
    private String[] xidbodega;
    private ButtonGroup JBGSeleccion;
    private ButtonGroup JBGSeleccion1;
    private JButton JBTExportar;
    private JButton JBTExportar1;
    private JButton JBTOrdenCompra;
    private JComboBox JCBBodega;
    public JComboBox JCBEmpresa;
    private JComboBox JCBOrdenesC;
    private JCheckBox JCHNsp;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JDateChooser JDFechaI1;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JFormattedTextField JTFFTotalizarR;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xnfila = 0;
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private String xsql = "";

    public JIFSolicitudPuntosR() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JBGSeleccion1 = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBEmpresa = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JCHNsp = new JCheckBox();
        this.JCBOrdenesC = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFFTotalizarR = new JFormattedTextField();
        this.JBTExportar = new JButton();
        this.JBTOrdenCompra = new JButton();
        this.jPanel1 = new JPanel();
        this.JDFechaI1 = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBBodega = new JComboBox();
        this.JBTExportar1 = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifsolicitudproductos");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.JIFSolicitudPuntosR.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSolicitudPuntosR.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Inventarios.JIFSolicitudPuntosR.2
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudPuntosR.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JCHNsp.setFont(new Font("Arial", 1, 12));
        this.JCHNsp.setText("NSP?");
        this.JCBOrdenesC.setFont(new Font("Arial", 1, 12));
        this.JCBOrdenesC.setBorder(BorderFactory.createTitledBorder((Border) null, "N° OrdenC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBOrdenesC.addItemListener(new ItemListener() { // from class: Inventarios.JIFSolicitudPuntosR.3
            public void itemStateChanged(ItemEvent evt) {
                JIFSolicitudPuntosR.this.JCBOrdenesCItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHNsp).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, -2, 513, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBOrdenesC, 0, -1, 32767).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFechaI, -2, -1, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBOrdenesC, GroupLayout.Alignment.TRAILING).addComponent(this.JCBEmpresa, GroupLayout.Alignment.TRAILING).addComponent(this.JCHNsp))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(0, 0, 255));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Inventarios.JIFSolicitudPuntosR.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFSolicitudPuntosR.this.JTDetallePropertyChange(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Inventarios.JIFSolicitudPuntosR.5
            public void keyPressed(KeyEvent evt) {
                JIFSolicitudPuntosR.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFFTotalizarR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setHorizontalAlignment(4);
        this.JTFFTotalizarR.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFSolicitudPuntosR.6
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudPuntosR.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBTOrdenCompra.setFont(new Font("Arial", 1, 12));
        this.JBTOrdenCompra.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOrdenCompra.setText("Generar Orden de Compra");
        this.JBTOrdenCompra.addActionListener(new ActionListener() { // from class: Inventarios.JIFSolicitudPuntosR.7
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudPuntosR.this.JBTOrdenCompraActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXCLUIR PRODUCTOS SIN ROTACIÓN", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaI1.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI1.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI1.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTExportar1.setFont(new Font("Arial", 1, 12));
        this.JBTExportar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar1.setText("Actualizar");
        this.JBTExportar1.addActionListener(new ActionListener() { // from class: Inventarios.JIFSolicitudPuntosR.8
            public void actionPerformed(ActionEvent evt) {
                JIFSolicitudPuntosR.this.JBTExportar1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI1, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 116, -2).addGap(18, 18, 18).addComponent(this.JCBBodega, -2, 371, -2).addGap(18, 18, 18).addComponent(this.JBTExportar1, -1, 149, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTExportar1, GroupLayout.Alignment.LEADING, -1, 52, 32767).addComponent(this.JCBBodega, GroupLayout.Alignment.LEADING, -1, 52, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JDFechaI1, GroupLayout.Alignment.LEADING, -2, -1, -2))).addContainerGap()));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\Plantilla.xls");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFSolicitudPuntosR.9
            public void mouseClicked(MouseEvent evt) {
                JIFSolicitudPuntosR.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING, -1, 830, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBTExportar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTOrdenCompra).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTotalizarR, -2, 169, -2)).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 329, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -1, 64, 32767).addComponent(this.JBTOrdenCompra, -1, 64, 32767).addComponent(this.JTFFTotalizarR, -1, 64, 32767).addComponent(this.JTFRuta, -2, 67, -2)).addGap(43, 43, 43)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.JCBEmpresa.getSelectedIndex() != -1 && this.xlleno) {
            Principal.mLimpiarDatosP();
            mBuscar();
            mLLenarCOrdenesCompra();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        mCalcularCantidadP();
        mTotalizar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        mExportar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1) {
            if (this.JCHNsp.isSelected()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    String xsql = "delete from i_manejo_puntosr where Id_Producto='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString() + "' and Id_Proveedor='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'";
                    this.xct.ejecutarSQL(xsql);
                    this.xct.cerrarConexionBd();
                    this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                    this.xnfila--;
                    mTotalizar();
                }
            } else {
                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x2 == 0) {
                    this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
                }
            }
            mCalcularCantidadP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOrdenCompraActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.xClaseInventario.cargarPantalla("jifcompras1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar1ActionPerformed(ActionEvent evt) {
        if (this.JCBBodega.getSelectedIndex() != -1 && this.JCHNsp.isSelected()) {
            mArmarDatosSinRotacion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBOrdenesCItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBOrdenesC.getSelectedIndex() != -1) {
            try {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                mLimpidarDatosOrdenC();
                this.xsql = "SELECT `cc_detalle_orden_compra`.`Id_Producto`, `cc_detalle_orden_compra`.`Cantidad`  FROM `cc_detalle_orden_compra` INNER JOIN `cc_orden_compra`  ON (`cc_detalle_orden_compra`.`Id_OrdenC` = `cc_orden_compra`.`Id`) WHERE (`cc_orden_compra`.`Id` ='" + this.xidordenc[this.JCBOrdenesC.getSelectedIndex()] + "') ";
                ResultSet xrs = xct1.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        int x = 0;
                        while (true) {
                            if (x >= this.JTDetalle.getRowCount()) {
                                break;
                            }
                            if (!this.xmodelo.getValueAt(x, 0).toString().equals(xrs.getString(1))) {
                                x++;
                            } else {
                                this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), x, 13);
                                break;
                            }
                        }
                    }
                }
                xrs.close();
                xct1.cerrarConexionBd();
                mCalcularCantidadP();
                mTotalizar();
            } catch (SQLException ex) {
                Logger.getLogger(JIFSolicitudPuntosR.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
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

    private void mLimpidarDatosOrdenC() {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            this.xmodelo.setValueAt(new Long(0L), x, 10);
            this.xmodelo.setValueAt(this.xmodelo.getValueAt(x, 2), x, 11);
            this.xmodelo.setValueAt(true, x, 5);
        }
    }

    private void mCalcularCantidadP() {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            long xcantidad = Long.valueOf(this.xmodelo.getValueAt(x, 2).toString()).longValue() - Long.valueOf(this.xmodelo.getValueAt(x, 13).toString()).longValue();
            if (xcantidad > 0) {
                this.xmodelo.setValueAt(Long.valueOf(xcantidad), x, 14);
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(new Long(0L), x, 14);
                this.xmodelo.setValueAt(false, x, 5);
            }
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText()));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 0, "Id"));
                sheet.addCell(new Label(1, 0, "Suministro"));
                sheet.addCell(new Label(2, 0, "Laboratorio"));
                sheet.addCell(new Label(3, 0, "Cantidad"));
                sheet.addCell(new Label(4, 0, "Valor"));
                sheet.addCell(new Label(5, 0, "Iva"));
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (this.JTDetalle.getValueAt(y, 5).toString().equals("true")) {
                        sheet.addCell(new Label(0, y + 1, this.xmodelo.getValueAt(y, 0).toString()));
                        sheet.addCell(new Label(1, y + 1, this.xmodelo.getValueAt(y, 1).toString()));
                        sheet.addCell(new Label(2, y + 1, this.xmodelo.getValueAt(y, 6).toString()));
                        sheet.addCell(new Number(3, y + 1, Long.valueOf(this.xmodelo.getValueAt(y, 2).toString()).longValue()));
                        sheet.addCell(new Number(4, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 3).toString()).doubleValue()));
                        sheet.addCell(new Number(5, y + 1, Double.valueOf(this.xmodelo.getValueAt(y, 7).toString()).doubleValue()));
                    }
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFSolicitudPuntosR.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFSolicitudPuntosR.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xlleno = false;
        this.JCBEmpresa.removeAllItems();
        this.xidempresa = this.xct.llenarCombo("SELECT cc_terceros.Id , cc_terceros.RazonSocialCompleta FROM  cc_terceros INNER JOIN i_reposiciones ON (cc_terceros.Id = i_reposiciones.Id_Proveedores) GROUP BY cc_terceros.Id ORDER BY cc_terceros.RazonSocialCompleta ASC", this.xidempresa, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCrearModeloDatos();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaI1.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.xsql = "SELECT i_bodegas.Id, i_bodegas.Nbre FROM i_bodegas INNER JOIN i_reposiciones  ON (i_bodegas.Id = i_reposiciones.Id_Bodega) GROUP BY i_bodegas.Id";
        this.xidbodega = this.xct.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        this.JDFechaI.requestFocus();
        this.xlleno = true;
        this.xct.cerrarConexionBd();
    }

    public void mGrabar() {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 5)) {
            if (this.JCBEmpresa.getSelectedIndex() != -1) {
                String sql = "insert into i_msolicitud_pedido (FechaS, Id_Proveedor, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "','" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                Principal.txtEstado.setText("ACTIVO");
                this.xct.cerrarConexionBd();
                for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                    if (this.JTDetalle.getValueAt(y, 5).toString().equals("true")) {
                        String sql2 = "insert into i_mdetalle_solicitud_pedido(Id_msolicitud, Id_Producto, Cantidad, Valor) values('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(y, 0).toString() + "','" + this.xmodelo.getValueAt(y, 14).toString() + "','" + this.xmodelo.getValueAt(y, 3).toString() + "')";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        if (this.JCHNsp.isSelected()) {
                            String sql3 = "update i_manejo_puntosr set Id_msolicitud='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(y, 4).toString() + "'";
                            this.xct.ejecutarSQL(sql3);
                            this.xct.cerrarConexionBd();
                        }
                    }
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe sleccionar un empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBEmpresa.requestFocus();
        }
    }

    private void mBuscar() {
        if (this.JCHNsp.isSelected()) {
            this.xsql = "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ' ,i_presentacioncomercial.Nbre,' ' , i_laboratorio.Nbre ) AS Nombre, i_manejo_puntosr.Cantidad, i_manejo_puntosr.Valor, i_manejo_puntosr.Id, i_laboratorio.Nbre, i_suministro.Iva, i_suministro.IdPrioridad     FROM i_manejo_puntosr INNER JOIN i_suministro ON (i_manejo_puntosr.Id_Producto = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_manejo_puntosr.Id_msolicitud =0 AND i_manejo_puntosr.Id_Proveedor ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "') ORDER BY  i_suministro.Nbre ASC ";
        } else {
            mCrearVista1();
            this.xsql = "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ', i_presentacioncomercial.Nbre,' ', i_laboratorio.Nbre) AS NProducto, (i_reposiciones.Minimo-ROUND(i_existencia_inventario.Cantidad/i_suministro.`CantidadUnidad`)) AS Pedido, i_reposiciones.valor , 0 AS IdR , i_laboratorio.Nbre, i_suministro.Iva, i_suministro.IdPrioridad, ROUND(i_existencia_inventario.Cantidad/i_suministro.`CantidadUnidad`) as CTotal, i_existencia_inventario.Cantidad  AS CT, i_suministro.`CantidadUnidad` AS UE, i_existencia_inventario.`CantidadP` AS CP  FROM i_reposiciones INNER JOIN i_suministro  ON (i_reposiciones.Id_Suministro = i_suministro.Id) INNER JOIN i_existencia_inventario  ON (i_existencia_inventario.CodigoAgrupacion = i_reposiciones.Id_Suministro) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_reposiciones.Id_Proveedores ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND i_reposiciones.P =1 AND ((i_reposiciones.PReposicion-ROUND(i_existencia_inventario.Cantidad/i_suministro.`CantidadUnidad`)) <=i_reposiciones.Minimo)  AND (i_reposiciones.Minimo-ROUND(i_existencia_inventario.Cantidad/i_suministro.`CantidadUnidad`))>0 ) ORDER BY  NProducto ASC ";
        }
        mCargarDatosTabla(this.xsql);
    }

    private void mCrearVista1() {
        ConsultasMySQL xmt1 = new ConsultasMySQL();
        xmt1.ejecutarSQL("DROP VIEW IF EXISTS i_existencia_inventario  ");
        xmt1.cerrarConexionBd();
        String sql = "select * from (WITH set_datos  AS (\nSELECT i_bodegas.Id AS idBodega, i_bodegas.Nbre nombreBodega, \n    i_suministro.Id AS idSuministro\n    , i_suministro.CodBarraUnidad\n    , i_suministro.CantidadUnidad\n    , i_suministro.Nbre AS NSuministro\n    , i_suministro.RegistroInvima  \n    , i_suministro.FechaVInvima  \n    , IFNULL(i_suministro.CodigoCUM,'') AS CodigoCUM \n    , IFNULL(i_suministro.CodigoAtc,'') AS CodigoAtc \n   , i_laboratorio.Nbre AS NLaboratorio\n    , i_suministroxlotexbodega.Lote\n    , i_suministroxlotexbodega.FechaVencimiento\n    , i_suministroxlotexbodega.Cantidad\n    , i_suministroxlotexbodega.CPendiente \n    ,it.Nbre tipoProducto\n    , ic.Nbre tipoCategoria\n     , i_clasificacion.Nbre AS NClasificacion\n    , ip.Nbre nombrePrincipioActivo\n    , ip2.Nbre nombrePresentacionComercial\n    , ip3.Nbre nombrePresentacionFarmaceutica\n    , IF(i_suministro.Pos=0,'NO POS','POS') AS clasificacion \n    , i_concentracion.Nbre  nombreConcentracion \n    , i_suministro.CodigoAgrupacion \n   \n\nFROM\n     i_suministroxbodega\n    INNER JOIN  i_suministro \n        ON (i_suministroxbodega.IdSuministro = i_suministro.Id)\n     INNER JOIN  i_suministroxlotexbodega \n         ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)\n    INNER JOIN  i_laboratorio \n        ON (i_suministro.IdLaboratorio = i_laboratorio.Id)\n    INNER JOIN  i_tipoproducto \n        ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)\n    INNER JOIN  i_bodegas \n        ON (i_suministroxbodega.IdBodega = i_bodegas.Id)        \n    INNER JOIN  i_concentracion \n        ON (i_suministro.idconcentracion = i_concentracion.Id) \n    INNER JOIN i_tipoproducto it  ON (it.Id=i_suministro.IdTipoProducto)   \n    INNER  JOIN i_categoria ic ON (ic.Id=i_suministro.IdCategoria)\n    INNER JOIN i_principioactivo ip ON (ip.Id=i_suministro.IdPrincipioActivo)\n    INNER JOIN i_presentacioncomercial ip2 ON (ip2.Id=i_suministro.IdPresentacionComercial)\n    INNER JOIN i_presentacionfarmaceutica ip3 ON (ip3.Id=i_suministro.IdPresentacionFarmaceutica)\n    INNER JOIN i_clasificacion\n        ON (i_suministro.IdClasificacion= i_clasificacion.Id)\n   WHERE  i_suministroxbodega.IdBodega='" + Principal.xClaseInventario.getIdBodega() + "'  \n   --  AND i_suministro.Id=1203\n   )\n      ,  set_salida AS (\n\tSELECT\n    i_detallesalida.IdSuministro\n    , i_detallesalida.Lote\n   -- , avg(i_detallesalida.ValorUnitario) as valor\n  -- ,i_detallesalida.ValorUnitario\n    , SUM(i_detallesalida.CantidadDespachada) AS CSalida\nFROM\n     i_detallesalida\n    INNER JOIN  i_salidas \n        ON (i_detallesalida.IdSalida = i_salidas.Id)\nWHERE (i_salidas.FechaSalida <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND i_salidas.IdBodega='" + Principal.xClaseInventario.getIdBodega() + "'\n    AND i_salidas.Estado=0\n  --    AND i_detallesalida.IdSuministro=1203\n    )\nGROUP BY  i_detallesalida.IdSuministro\n  , i_detallesalida.Lote\n   ) \n      ,  set_entrada AS (\n\tSELECT\n    i_detalleentrada.IdSuministro\t\n    , i_detalleentrada.Lote\n    , SUM(i_detalleentrada.Cantidad) AS CEntrada\n    , i_entradas.IdBodega\n     ,SUM(i_detalleentrada.Cantidad*(i_detalleentrada.ValorUnitario+((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+i_detalleentrada.VFletesO-i_detalleentrada.VDescuento)) Valortotal\n    FROM\n     i_detalleentrada\n    INNER JOIN  i_entradas\n        ON (i_detalleentrada.IdEntrada = i_entradas.Id)\nWHERE (i_entradas.FechaEntrada <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "'\n    AND i_entradas.IdBodega='" + Principal.xClaseInventario.getIdBodega() + "'\n    AND i_entradas.Estado=0 \n   --  AND i_detalleentrada.IdSuministro\t=1203\n    )\t\nGROUP BY  i_detalleentrada.IdSuministro\n   , i_detalleentrada.Lote\n   ) \n   , set_entrada_def AS (\nSELECT Idsuministro,\n Lote,\n CEntrada,\n IdBodega,\n (Valortotal/CEntrada) costo_lote ,\n SUM(Valortotal) over (PARTITION BY Idsuministro)/SUM(CEntrada) over (PARTITION BY Idsuministro) valorUnitario\nFROM set_entrada\n)   \n    SELECT \n    i.CodigoAgrupacion\n     ,i.NSuministro NSuministro\n      , SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) Cantidad\n     , sum(i.CPendiente) CantidadP\n     \n     ,i.CantidadUnidad,  \nROUND(sum(i.CPendiente)/ i.CantidadUnidad) AS CUEmpaqueP, \nROUND(SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0))/ i.CantidadUnidad) AS CUEmpaque, \n(ROUND(SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0))/ i.CantidadUnidad)- ROUND(sum(i.CPendiente)/ i.CantidadUnidad)) AS CTotal\n\n    ,SUM(IFNULL(e.CEntrada,0)) cantidadEntrada\n    ,SUM(IFNULL(s.CSalida,0)) cantidadSalida\n    ,SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) totalInventario\n    ,ifnull(SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0))* sum(DISTINCT e.valorUnitario),0) valorTotal\n\t, i.CPendiente\n  FROM set_datos i\n    LEFT JOIN set_entrada_def e ON (e.IdSuministro=i.idSuministro)  AND (e.Lote=i.Lote)\n  LEFT  JOIN set_salida s ON (s.IdSuministro=i.idSuministro)  AND (s.Lote=i.Lote)\n\n  GROUP BY i.CodigoAgrupacion\n  --   HAVING totalInventario>0\n   ORDER BY i.CodigoAgrupacion ASC) d";
        String sqlw = "CREATE VIEW i_existencia_inventario AS " + sql;
        System.out.println(" vista : " + sqlw);
        xmt1.ejecutarSQL(sqlw);
        xmt1.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Suministro", "Cantidad", "Valor", "IdR", "Pedir", "Laboratorio", "Iva", "IdPrioridad", "C/Unidad", "U/E", "C/Pendiente", "E/UE", "COrdenC", "CPedir"}) { // from class: Inventarios.JIFSolicitudPuntosR.10
            Class[] types = {Long.class, String.class, Long.class, Double.class, Long.class, Boolean.class, String.class, Double.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, true, false, false, true, false, false, false, false, false, false, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(10);
    }

    public void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            System.out.println(" suministro : " + xsql);
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                this.xnfila = 0;
                while (xrs.next()) {
                    if (this.JCHNsp.isSelected()) {
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        ResultSet rs = xct1.traerRs("SELECT Id_Suministro FROM i_tmp_sbodega WHERE (Id_Suministro ='" + xrs.getLong(1) + "')");
                        if (!rs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), this.xnfila, 0);
                            this.xmodelo.setValueAt(xrs.getString(2), this.xnfila, 1);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), this.xnfila, 2);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), this.xnfila, 3);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), this.xnfila, 4);
                            this.xmodelo.setValueAt(true, this.xnfila, 5);
                            this.xmodelo.setValueAt(xrs.getString(6), this.xnfila, 6);
                            this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), this.xnfila, 7);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), this.xnfila, 8);
                            this.xmodelo.setValueAt(new Long(0L), this.xnfila, 13);
                            this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), this.xnfila, 14);
                            this.xmodelo.setValueAt(new Integer(0), this.xnfila, 9);
                            this.xmodelo.setValueAt(new Integer(0), this.xnfila, 10);
                            this.xmodelo.setValueAt(new Integer(0), this.xnfila, 11);
                            this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                            this.xnfila++;
                        } else {
                            ConsultasMySQL xct2 = new ConsultasMySQL();
                            xct2.ejecutarSQL("DELETE FROM i_manejo_puntosr WHERE Id_Producto='" + xrs.getLong(1) + "' AND Id_Proveedor='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'AND Id_msolicitud=0");
                            xct2.cerrarConexionBd();
                        }
                        rs.close();
                        xct1.cerrarConexionBd();
                    } else {
                        this.xmodelo.addRow(this.xdatos);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), this.xnfila, 0);
                        this.xmodelo.setValueAt(xrs.getString(2), this.xnfila, 1);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), this.xnfila, 2);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), this.xnfila, 3);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), this.xnfila, 4);
                        this.xmodelo.setValueAt(true, this.xnfila, 5);
                        this.xmodelo.setValueAt(xrs.getString(6), this.xnfila, 6);
                        this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), this.xnfila, 7);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), this.xnfila, 8);
                        this.xmodelo.setValueAt(new Long(0L), this.xnfila, 13);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), this.xnfila, 14);
                        this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), this.xnfila, 12);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(10)), this.xnfila, 9);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(11)), this.xnfila, 10);
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(12)), this.xnfila, 11);
                        this.xnfila++;
                    }
                }
                mTotalizar();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSolicitudPuntosR.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFSolicitudPuntosR$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int xvalor = Integer.valueOf(table.getValueAt(row, 8).toString()).intValue();
            if (xvalor == 6) {
                cell.setBackground(Color.RED);
            } else if (xvalor == 7) {
                cell.setBackground(Color.YELLOW);
            } else if (xvalor == 8) {
                cell.setBackground(new Color(255, 51, 255));
            } else if (xvalor == 9) {
                cell.setBackground(new Color(133, 218, 160));
            }
            return cell;
        }
    }

    private void mTotalizar() {
        double xtotal = 0.0d;
        for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
            if (this.JTDetalle.getValueAt(y, 5).toString().equals("true")) {
                xtotal += Double.valueOf(this.xmodelo.getValueAt(y, 3).toString()).doubleValue() * Long.valueOf(this.xmodelo.getValueAt(y, 14).toString()).longValue();
            }
        }
        this.JTFFTotalizarR.setValue(Double.valueOf(xtotal));
    }

    private void mArmarDatosSinRotacion() {
        this.xsql = "DROP TABLE IF EXISTS i_tmp_sbodega ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE TABLE `i_tmp_sbodega` (`Id_Suministro` bigint(19) default '0',  `Id_SuministroB` bigint(18) default '0', `TMov` tinyint(1) default '0') ENGINE=InnoDB DEFAULT CHARSET=latin1 ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "INSERT INTO i_tmp_sbodega (Id_Suministro,Id_SuministroB) SELECT i_suministro.Id , i_suministroxbodega.Id  FROM i_suministro INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_principioactivo  ON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_suministroxbodega  ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_suministroxlotexbodega  ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id) WHERE (i_suministroxbodega.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_suministroxlotexbodega.Id HAVING (SUM(i_suministroxlotexbodega.Cantidad) <>0) ORDER BY i_principioactivo.Nbre ASC, i_suministro.Nbre ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP TABLE IF EXISTS i_tmp  ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE TABLE `i_tmp` (`Id` bigint(19) default NULL ) ENGINE=InnoDB DEFAULT CHARSET=latin1 ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "INSERT INTO i_tmp (Id) SELECT i_suministro.Id FROM i_detallesalida INNER JOIN i_suministro  ON (i_detallesalida.IdSuministro = i_suministro.Id) INNER JOIN i_salidas  ON (i_detallesalida.IdSalida = i_salidas.Id) WHERE (i_salidas.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' AND i_salidas.FechaSalida >='" + this.xmt.formatoAMD.format(this.JDFechaI1.getDate()) + "' AND i_salidas.IdDestino <>0 AND i_salidas.FechaSalida <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY i_suministro.Id ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "UPDATE i_tmp_sbodega, i_tmp SET i_tmp_sbodega.TMov=1 WHERE i_tmp_sbodega.Id_Suministro=i_tmp.Id ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "delete  from i_tmp_sbodega  where i_tmp_sbodega.TMov=1";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mLLenarCOrdenesCompra() {
        this.xlleno1 = false;
        this.JCBOrdenesC.removeAllItems();
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xsql = "SELECT `Id`, `Id` FROM  `cc_orden_compra` WHERE (`Estado` =1 AND `Id_Tercero` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `EstadoR` <>2) ORDER BY `Id` DESC ";
        this.xidordenc = xct1.llenarCombo(this.xsql, this.xidordenc, this.JCBOrdenesC);
        this.JCBOrdenesC.setSelectedIndex(-1);
        xct1.cerrarConexionBd();
        this.xlleno1 = true;
    }
}
