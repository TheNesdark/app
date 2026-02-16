package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFEnviarDocTerceros.class */
public class JIFEnviarDocTerceros extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidtipodocumento;
    private String[][] xidtercero;
    private String xsql;
    private String xcc_detalle_documentoc;
    private String xcc_puc;
    private String xcc_documentoc;
    private ButtonGroup JBGSeleccion;
    private JButton JBTGenerar;
    private JComboBox JCBTercero;
    private JComboBox JCBTipoDoc;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCorreo;
    private JFormattedTextField JTFFTotalPagado;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xlleno = false;
    private boolean xlleno1 = false;

    public JIFEnviarDocTerceros() {
        initComponents();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc_niif";
            this.xcc_puc = "cc_puc_niif";
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc";
            this.xcc_puc = "cc_puc";
            this.xcc_documentoc = "cc_documentoc";
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBTipoDoc = new JComboBox();
        this.JCBTercero = new JComboBox();
        this.JTFCorreo = new JTextField();
        this.JBTGenerar = new JButton();
        this.JTFFTotalPagado = new JFormattedTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR DOCUMENTOS POR TERCERO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifenviardoctercero");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFEnviarDocTerceros.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFEnviarDocTerceros.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFEnviarDocTerceros.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFEnviarDocTerceros.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFEnviarDocTerceros.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFEnviarDocTerceros.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCBTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc.addItemListener(new ItemListener() { // from class: Contabilidad.JIFEnviarDocTerceros.4
            public void itemStateChanged(ItemEvent evt) {
                JIFEnviarDocTerceros.this.JCBTipoDocItemStateChanged(evt);
            }
        });
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addItemListener(new ItemListener() { // from class: Contabilidad.JIFEnviarDocTerceros.5
            public void itemStateChanged(ItemEvent evt) {
                JIFEnviarDocTerceros.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JTFCorreo.setFont(new Font("Arial", 1, 12));
        this.JTFCorreo.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFEnviarDocTerceros.6
            public void actionPerformed(ActionEvent evt) {
                JIFEnviarDocTerceros.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JTFFTotalPagado.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL PAGADO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalPagado.setEditable(false);
        this.JTFFTotalPagado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalPagado.setHorizontalAlignment(4);
        this.JTFFTotalPagado.setFont(new Font("Arial", 1, 16));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoDoc, -2, 277, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTercero, 0, 431, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCorreo, -2, 458, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGenerar, -2, 315, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalPagado, -1, 177, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDoc, -2, -1, -2).addComponent(this.JCBTercero, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -1, 45, 32767).addComponent(this.JDFechaI, GroupLayout.Alignment.LEADING, -2, -1, -2))).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCorreo, -1, 56, 32767).addComponent(this.JBTGenerar, -1, 56, 32767).addComponent(this.JTFFTotalPagado, GroupLayout.Alignment.TRAILING, -1, 56, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFEnviarDocTerceros.7
            public void mouseClicked(MouseEvent evt) {
                JIFEnviarDocTerceros.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 1010, 32767).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 372, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoDoc.getSelectedIndex() != -1) {
            this.JCBTercero.removeAllItems();
            this.xlleno1 = false;
            if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
                this.xsql = "SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta, cc_terceros.Correo FROM cc_radicacion INNER JOIN " + this.xcc_documentoc + " ON (cc_radicacion.Id = " + this.xcc_documentoc + ".Id_Radicacion) INNER JOIN cc_terceros  ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) WHERE (" + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()] + "') GROUP BY cc_terceros.Id ORDER BY cc_terceros.RazonSocialCompleta ASC ";
            } else {
                this.xsql = "SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta, cc_terceros.Correo FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN cc_terceros  ON (cc_terceros.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero) WHERE (" + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()] + "' AND " + this.xcc_documentoc + ".FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND " + this.xcc_documentoc + ".FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY cc_terceros.Id  ORDER BY cc_terceros.RazonSocialCompleta ASC ";
            }
            this.xidtercero = this.xconsulta.llenarComboyLista(this.xsql, this.xidtercero, this.JCBTercero, 3);
            this.JCBTercero.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        if (this.xmetodos.mVerificarDatosTablaTrue(this.JTDetalle, 9)) {
            mGenerarPDF();
            int x = JOptionPane.showInternalConfirmDialog(this, "Desea enviar documento(s) por correo electrónico", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                mEnviarArchivos();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un docuemento a generar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTDetalle.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBTercero.getSelectedIndex() != -1) {
            if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
                mCrearModeloDatos();
            } else {
                mCrearModeloDatos1();
            }
            this.JTFCorreo.setText(this.xidtercero[this.JCBTercero.getSelectedIndex()][1]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarDatosTipoDoc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarDatosTipoDoc();
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFechaF.setDate(this.xmetodos.getFechaActual());
        mLLenarDatosTipoDoc();
        mCrearModeloDatos();
        this.JDFechaI.requestFocus();
    }

    private void mLLenarDatosTipoDoc() {
        this.xlleno = false;
        this.xlleno1 = false;
        this.JCBTercero.removeAllItems();
        this.JCBTipoDoc.removeAllItems();
        this.xidtipodocumento = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM cc_tipo_documentoc WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodocumento, this.JCBTipoDoc);
        this.xconsulta.cerrarConexionBd();
        this.JCBTipoDoc.setSelectedIndex(-1);
        this.JTFFTotalPagado.setValue(new Double(0.0d));
        this.xlleno = true;
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[6][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "TipoDoc";
            mparametros[2][1] = this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()];
            mparametros[3][0] = "IdTercero";
            mparametros[3][1] = this.xidtercero[this.JCBTercero.getSelectedIndex()][0];
            mparametros[4][0] = "SUBREPORT_DIR";
            mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[5][0] = "SUBREPORTFIRMA_DIR";
            mparametros[5][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros);
                return;
            }
            if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("4")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_LiquidacionFactura", mparametros);
                return;
            }
            if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("5")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_LiquidacionNotaCredito", mparametros);
            } else if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("6")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenServicio", mparametros);
            } else if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("2")) {
                this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_Relacion_Pagos_Terceros", mparametros);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N°", "Fecha", "N° Factura", "Fecha Factura", "NPuc", "Valor", "UrlFactura", "IdFacInterna", "IdComprobante", "Enviar?"}) { // from class: Contabilidad.JIFEnviarDocTerceros.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Double.class, String.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
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
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Comprobante", "Fecha", "Fecha Factura", "N° Factura", "Valor", "UrlFactura", "IdFacInterna", "IdDocContable", "IdCuentaCobro", "Enviar?"}) { // from class: Contabilidad.JIFEnviarDocTerceros.9
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, String.class, Long.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
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
    }

    public void mBuscar() {
        if (this.JCBTipoDoc.getSelectedIndex() != -1) {
            if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
                this.xsql = "SELECT " + this.xcc_documentoc + ".Id, DATE_FORMAT(" + this.xcc_documentoc + ".FechaD, '%d-%m-%Y') as Fecha, cc_radicacion.NoFactura, DATE_FORMAT(cc_radicacion.FechaFac, '%d-%m-%Y') as FechaA , " + this.xcc_puc + ".Nbre, " + this.xcc_detalle_documentoc + ".VCredito, cc_radicacion.UrlFactura, cc_radicacion.Id_FacturaInterna, cc_radicacion.Id_Comprobante FROM cc_radicacion INNER JOIN " + this.xcc_documentoc + " ON (cc_radicacion.Id = " + this.xcc_documentoc + ".Id_Radicacion) INNER JOIN " + this.xcc_detalle_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) AND (" + this.xcc_detalle_documentoc + ".Id_Puc = cc_radicacion.Id_CuentaAuxPPagar) INNER JOIN " + this.xcc_puc + "  ON (" + this.xcc_puc + ".Id = " + this.xcc_detalle_documentoc + ".Id_Puc) WHERE (" + this.xcc_documentoc + ".FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND " + this.xcc_documentoc + ".FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND " + this.xcc_documentoc + ".Estado =1 AND cc_radicacion.Id_Proveedor ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()][0] + "' and cc_radicacion.Id_Comprobante<>0) ORDER BY " + this.xcc_documentoc + ".Id asc,  " + this.xcc_documentoc + ".FechaD DESC ";
                mCargarDatosTabla(this.xsql);
            } else {
                this.xsql = "SELECT " + this.xcc_documentoc + ".Id, date_format(" + this.xcc_documentoc + ".FechaD,'%d-%m-%Y') as FechaDoc, date_format(cc_radicacion.FechaFac,'%d-%m-%Y') as FechaFac, cc_radicacion.NoFactura , " + this.xcc_detalle_documentoc + ".VDebito, cc_radicacion.UrlFactura , cc_radicacion.Id_FacturaInterna , cc_documento_contables.Id , cc_documento_contables.Id_CuentaCobro FROM " + this.xcc_detalle_documentoc + " INNER JOIN " + this.xcc_documentoc + "  ON (" + this.xcc_detalle_documentoc + ".Id_Documentoc = " + this.xcc_documentoc + ".Id) INNER JOIN g_empresa  ON (g_empresa.Id = " + this.xcc_detalle_documentoc + ".Id_Tercero) INNER JOIN cc_radicacion  ON (" + this.xcc_detalle_documentoc + ".Id_Radicacion = cc_radicacion.Id) AND (cc_radicacion.Id_CuentaAuxPPagar = " + this.xcc_detalle_documentoc + ".Id_Puc) INNER JOIN cc_documento_contables  ON (cc_documento_contables.Id_Radicacion = cc_radicacion.Id) WHERE (" + this.xcc_documentoc + ".Id_TipoComprobante ='" + this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()] + "' AND " + this.xcc_documentoc + ".FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND " + this.xcc_documentoc + ".FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFechaF.getDate()) + "' AND g_empresa.Id ='" + this.xidtercero[this.JCBTercero.getSelectedIndex()][0] + "' AND " + this.xcc_documentoc + ".Estado =1) ORDER BY " + this.xcc_documentoc + ".Id asc, " + this.xcc_documentoc + ".FechaD ASC ";
                mCargarDatosTabla1(this.xsql);
            }
        }
    }

    private void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(6)), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    this.xmodelo.setValueAt(false, n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEnviarDocTerceros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTabla1(String xsql) {
        try {
            mCrearModeloDatos1();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            double xvalor = 0.0d;
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    xvalor += xrs.getDouble(5);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), n, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), n, 8);
                    this.xmodelo.setValueAt(false, n, 9);
                    n++;
                }
            }
            this.JTFFTotalPagado.setValue(Double.valueOf(xvalor));
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFEnviarDocTerceros.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mRecorrerTablaG(String xruta1) {
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo.getValueAt(x, 9).toString()).booleanValue()) {
                String nbre = "" + this.xmodelo.getValueAt(x, 0).toString();
                String[][] mparametros = new String[6][2];
                mparametros[0][0] = "IdC";
                mparametros[0][1] = Principal.txtNo.getText();
                mparametros[1][0] = "UsuarioS";
                mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
                mparametros[2][0] = "TipoDoc";
                mparametros[2][1] = this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()];
                mparametros[3][0] = "IdTercero";
                mparametros[3][1] = this.xidtercero[this.JCBTercero.getSelectedIndex()][0];
                mparametros[4][0] = "SUBREPORT_DIR";
                mparametros[4][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
                mparametros[5][0] = "SUBREPORTFIRMA_DIR";
                mparametros[5][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
                if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenCompra", mparametros);
                } else if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("4")) {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_LiquidacionFactura", mparametros);
                } else if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("5")) {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_LiquidacionNotaCredito", mparametros);
                } else if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("6")) {
                    this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_OrdenServicio", mparametros);
                } else if (this.xidtipodocumento[this.JCBTipoDoc.getSelectedIndex()].equals("2")) {
                    this.xmetodos.mGenerarPDF("CC_Relacion_Pagos_Terceros", mparametros, nbre, xruta1);
                }
            }
        }
    }

    private void mGenerarPDF() {
        File directorio2 = new File("C:\\Genoma\\DocumentosC\\");
        if (directorio2.exists()) {
            Metodos.mBorrarDirectorio(directorio2);
            String xruta = directorio2.getPath();
            mRecorrerTablaG(xruta);
        } else if (directorio2.mkdirs()) {
            String xruta2 = directorio2.getPath();
            mRecorrerTablaG(xruta2);
        }
    }

    private void mEnviarArchivos() {
        if (!this.JTFCorreo.getText().isEmpty()) {
            File directorio2 = new File("C:\\Genoma\\DocumentosC\\");
            String[] ficheros = directorio2.list();
            if (ficheros != null) {
                for (int x = 0; x <= ficheros.length - 1; x++) {
                    File f2 = new File(directorio2.getPath() + "\\" + ficheros[x]);
                    String remite = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                    String mensaje = "Anexo archivo con documento contable : " + this.JCBTipoDoc.getSelectedItem().toString() + "\n\n\nDEPARTAMENTO DE CONTABILIDAD";
                    Email correo = new Email();
                    List<String> correoE = new ArrayList<>();
                    correoE.add(this.JTFCorreo.getText());
                    correo.enviarAdjunto(correoE, mensaje, remite, this.JCBTipoDoc.getSelectedItem().toString() + " N°" + ficheros[x].substring(0, ficheros[x].length() - 4), ficheros[x], f2.getPath());
                    f2.delete();
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo Email no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFCorreo.requestFocus();
    }
}
