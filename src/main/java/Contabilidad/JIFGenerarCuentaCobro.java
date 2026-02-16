package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.convertirNumerosLetras;
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
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFGenerarCuentaCobro.class */
public class JIFGenerarCuentaCobro extends JInternalFrame {
    private DefaultTableModel xmodelo;
    public String[] xidempresa;
    public String[] xidconcepto1;
    public String[] xidtipodoc;
    public String[][] xidsubgrupo;
    public String[][] xidconcepto;
    private Object[] xdato;
    private JIFConsultarDatosV xjifconsultard;
    private String xsql;
    private ButtonGroup JBGTipo;
    private JButton JBTExportar;
    private JComboBox JCBConcepto;
    private JComboBox JCBSubGrupo;
    private JComboBox JCBTercero;
    private JComboBox JCBTipoC;
    private JDateChooser JDFFechaC;
    private JPanel JPIDatosFactura1;
    private JPanel JPIDatosP;
    private JScrollPane JSPObservacion;
    private JScrollPane JSPResultado;
    private JTextPane JTAObservacion;
    private JFormattedTextField JTFFNFacturaEvento;
    private JFormattedTextField JTFFTotalizarR;
    private JTextField JTFRuta;
    private JTabbedPane JTP_DatosFac;
    public JTable JTResultado;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private JComboBox comboBox = new JComboBox();
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private String xnfacturaevento = "";

    public JIFGenerarCuentaCobro() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPIDatosP = new JPanel();
        this.JCBTercero = new JComboBox();
        this.JDFFechaC = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JCBConcepto = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTP_DatosFac = new JTabbedPane();
        this.JPIDatosFactura1 = new JPanel();
        this.JCBTipoC = new JComboBox();
        this.JCBSubGrupo = new JComboBox();
        this.JTFFTotalizarR = new JFormattedTextField();
        this.JTFFNFacturaEvento = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN DE CUENTAS DE COBRO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifcuentacobro");
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFGenerarCuentaCobro.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGenerarCuentaCobro.this.formInternalFrameClosing(evt);
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
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 204, 204));
        this.JTResultado.setRowHeight(20);
        this.JTResultado.setSelectionBackground(Color.red);
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFGenerarCuentaCobro.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGenerarCuentaCobro.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addItemListener(new ItemListener() { // from class: Contabilidad.JIFGenerarCuentaCobro.3
            public void itemStateChanged(ItemEvent evt) {
                JIFGenerarCuentaCobro.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JCBTercero, -2, 417, -2)).addComponent(this.JCBConcepto, -2, 547, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPObservacion, -2, 249, -2).addGap(49, 49, 49)));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTercero, -2, 50, -2).addComponent(this.JDFFechaC, -2, 50, -2)).addGap(10, 10, 10).addComponent(this.JCBConcepto, -1, 52, 32767)).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPObservacion))).addContainerGap()));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFGenerarCuentaCobro.4
            public void mouseClicked(MouseEvent evt) {
                JIFGenerarCuentaCobro.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFGenerarCuentaCobro.5
            public void actionPerformed(ActionEvent evt) {
                JIFGenerarCuentaCobro.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTP_DatosFac.setForeground(Color.red);
        this.JTP_DatosFac.setFont(new Font("Arial", 1, 14));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSubGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBSubGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "SubGrupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Reembolso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalizarR.setHorizontalAlignment(4);
        this.JTFFTotalizarR.setFont(new Font("Arial", 1, 13));
        this.JTFFNFacturaEvento.setEditable(false);
        this.JTFFNFacturaEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° FACTURA EVENTO", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNFacturaEvento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNFacturaEvento.setHorizontalAlignment(0);
        this.JTFFNFacturaEvento.setFont(new Font("Arial", 1, 18));
        GroupLayout JPIDatosFactura1Layout = new GroupLayout(this.JPIDatosFactura1);
        this.JPIDatosFactura1.setLayout(JPIDatosFactura1Layout);
        JPIDatosFactura1Layout.setHorizontalGroup(JPIDatosFactura1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFactura1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFactura1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSubGrupo, -2, 487, -2).addComponent(this.JCBTipoC, -2, 238, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 61, 32767).addGroup(JPIDatosFactura1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFTotalizarR, -1, 185, 32767).addComponent(this.JTFFNFacturaEvento)).addGap(156, 156, 156)));
        JPIDatosFactura1Layout.setVerticalGroup(JPIDatosFactura1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFactura1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFactura1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFTotalizarR, -2, 59, -2).addGroup(JPIDatosFactura1Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JCBSubGrupo, -2, 51, -2))).addGap(17, 17, 17).addGroup(JPIDatosFactura1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JTFFNFacturaEvento)).addGap(22, 22, 22)));
        this.JTP_DatosFac.addTab("DATOS PARA FACTURAR", this.JPIDatosFactura1);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPResultado).addComponent(this.JTP_DatosFac).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2)).addComponent(this.JPIDatosP, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JPIDatosP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResultado, -2, 251, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTP_DatosFac, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
        mTotalizarReembolso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
        if (this.JCBTercero.getSelectedIndex() != -1 && this.xlleno) {
            this.xlleno1 = false;
            this.JCBSubGrupo.removeAllItems();
            this.xsql = "SELECT `f_subgrupo_empresa`.`Id`, `f_subgruposervicio`.`Nbre`, `f_empresacontxconvenio`.`Id`, `f_subgruposervicio`.`Id_GrupoServicio`,`f_subgrupo_empresa`.`CPuc_Debito`, `f_subgrupo_empresa`.`CPuc_Credito` FROM  `f_subgrupo_empresa` INNER JOIN  `f_subgruposervicio`  ON (`f_subgrupo_empresa`.`Id_SubGrupo` = `f_subgruposervicio`.`Id_SubgrupoServicio`) INNER JOIN  `f_empresacontxconvenio`  ON (`f_subgrupo_empresa`.`Id_Empresa` = `f_empresacontxconvenio`.`Id`) WHERE (`f_subgrupo_empresa`.`EsContable` =1 AND `f_empresacontxconvenio`.`Id_EmpresaCont` ='" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "' AND `f_subgrupo_empresa`.`Estado` =1) ORDER BY `f_subgruposervicio`.`Nbre` ASC ";
            this.xidsubgrupo = this.xct.llenarComboyLista(this.xsql, this.xidsubgrupo, this.JCBSubGrupo, 6);
            this.JCBSubGrupo.setSelectedIndex(-1);
            this.xlleno1 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
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
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTResultado.getRowCount() > -1) {
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    private void mGenerarDocContable_Evento() {
        if (!this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][4].equals("")) {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "insert into cc_documentoc (FechaD, Id_TipoComprobante, Id_PeriodoC, Descripcion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xidtipodoc[this.JCBTipoC.getSelectedIndex()] + "','" + Principal.xclase.getXidperiodoc() + "','" + this.JTAObservacion.getText() + " Factura Venta N° " + this.JTFFNFacturaEvento.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            Principal.txtNo.setText(xct1.ejecutarSQLId(this.xsql));
            xct1.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][3] + "','0','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.JTFFNFacturaEvento.getText() + "','" + this.JTFFTotalizarR.getValue() + "','0','" + this.JTAObservacion.getText() + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "'  )";
            xct1.ejecutarSQL(this.xsql);
            xct1.cerrarConexionBd();
            this.xsql = "insert into cc_detalle_documentoc (Id_Documentoc, Id_Puc, TipoCPuc, Id_Tercero, NFactura, VDebito, VCredito, Concepto) Values ('" + Principal.txtNo.getText() + "','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][4] + "','1','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.JTFFNFacturaEvento.getText() + "','0','" + this.JTFFTotalizarR.getValue() + "','" + this.JTAObservacion.getText() + "  Factura de Venta N° : " + this.JTFFNFacturaEvento.getText() + "'  )";
            xct1.ejecutarSQL(this.xsql);
            xct1.cerrarConexionBd();
            this.xsql = "update f_factura_evento set Id_DocumentoC='" + Principal.txtNo.getText() + "' where No_FacturaEvento='" + this.xnfacturaevento + "'";
            xct1.ejecutarSQL(this.xsql);
            xct1.cerrarConexionBd();
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (!this.JTAObservacion.getText().isEmpty()) {
                if (this.xmt.mVerificarDatosTablaTrue(this.JTResultado, 7)) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        String sql = "insert into cc_cuentacobro (FechaC, Id_Tercero, Observacion, Fecha, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()] + "','" + this.JTAObservacion.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                        this.xct.cerrarConexionBd();
                        String sql2 = "insert into cc_detalle_cuentacobrom (Id_cuentacobro, Id_ConceptoCC, TipoConcepto, Valor) Values ('" + Principal.txtNo.getText() + "','" + this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0] + "','0','" + this.JTFFTotalizarR.getValue() + "')";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                            if (this.JTResultado.getValueAt(y, 7).toString().equals("true")) {
                                String sql3 = "insert into cc_detalle_cuentacobro (Id_cuentacobro, Id_Concepto, Id_Tercero, Id_DocumentoC, Valor) Values ('" + Principal.txtNo.getText() + "','" + mDdevuelveValorCombo(this.xmodelo.getValueAt(y, 8).toString()) + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 5) + "','" + this.xmodelo.getValueAt(y, 6) + "')";
                                this.xct.ejecutarSQL(sql3);
                                this.xct.cerrarConexionBd();
                                String sql4 = "update cc_documentoc set Id_CuentaCobro='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(y, 5) + "'";
                                this.xct.ejecutarSQL(sql4);
                                this.xct.cerrarConexionBd();
                            }
                        }
                        mGenerarFacturaEvento();
                        mGenerarDocContable_Evento();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Falta registro de observación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xlleno = false;
        this.JCBSubGrupo.removeAllItems();
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBTercero.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JCBTercero.removeAllItems();
        this.xsql = "SELECT  `cc_terceros`.`Id` , `cc_terceros`.`RazonSocialCompleta`  FROM `f_empresacontxconvenio` INNER JOIN `baseserver`.`cc_terceros`  ON (`f_empresacontxconvenio`.`Id_EmpresaCont` = `cc_terceros`.`Id`) INNER JOIN `baseserver`.`f_subgrupo_empresa`  ON (`f_subgrupo_empresa`.`Id_Empresa` = `f_empresacontxconvenio`.`Id`) GROUP BY `cc_terceros`.`Id` ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBConcepto.removeAllItems();
        this.xidconcepto = this.xct.llenarComboyLista("SELECT Id, Nbre, VFijo, Valor FROM cc_tipo_concepto_cuentacobro WHERE (Estado =1)", this.xidconcepto, this.JCBConcepto, 4);
        this.JCBTercero.setSelectedIndex(-1);
        this.xsql = "SELECT `Id`, `Nbre` FROM  `cc_tipo_documentoc` WHERE (`EsVentas` =1 AND `Estado` =1) ORDER BY `Nbre` ASC ";
        this.xidtipodoc = this.xct.llenarCombo(this.xsql, this.xidtipodoc, this.JCBTipoC);
        if (this.xidtipodoc.length > 1) {
            this.JCBTipoC.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        this.JTFFNFacturaEvento.setText("");
        this.xlleno = true;
        mCrearTabla();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Empresa", "N° Comprobante", "N° Radicación", "Fecha Radicación", "N° DocumentoC", "Valor", "Reembolsar?", "Concepto"}) { // from class: Contabilidad.JIFGenerarCuentaCobro.6
            Class[] types = {Long.class, String.class, Long.class, Long.class, String.class, Long.class, Double.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(40);
        TableColumn sportColumn = this.JTResultado.getColumnModel().getColumn(8);
        sportColumn.setCellEditor(new DefaultCellEditor(this.comboBox));
    }

    public void mBuscar() {
        Object[] botones = {"Datos", "Cuentas de Cobro", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea buscar?", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            mCargarDatos();
        } else if (n == 1) {
            this.xjifconsultard = new JIFConsultarDatosV(this);
            Principal.cargarPantalla(this.xjifconsultard);
        }
    }

    public void mBuscarId(String xid) {
        String xsql = "SELECT cc_cuentacobro.Id, cc_cuentacobro.FechaC, cc_terceros.`RazonSocialCompleta`, cc_cuentacobro.Observacion, cc_detalle_cuentacobro.Id_Tercero, cc_tercero.NEmpresa, cc_radicacion.Id_Comprobante, cc_radicacion.Id, cc_radicacion.Fecha, cc_documentoc.Id \n, ROUND(SUM( cc_radicacion.SubTotal+ cc_radicacion.Iva+cc_radicacion.Flete+ cc_radicacion.Otros)) AS TotalReembolso , cc_conceptocmsa.Nbre, `cc_cuentacobro`.`NFactura_Evento`  \nFROM cc_detalle_cuentacobro INNER JOIN cc_cuentacobro  ON (cc_detalle_cuentacobro.Id_cuentacobro = cc_cuentacobro.Id) INNER JOIN cc_terceros  ON (cc_cuentacobro.Id_Tercero = cc_terceros.Id) \nINNER JOIN cc_tercero  ON (cc_detalle_cuentacobro.Id_Tercero = cc_tercero.Id) INNER JOIN cc_documentoc  ON (cc_detalle_cuentacobro.Id_DocumentoC = cc_documentoc.Id) INNER JOIN cc_radicacion  \nON (cc_radicacion.Id = cc_documentoc.Id_Radicacion) INNER JOIN cc_conceptocmsa  ON (cc_detalle_cuentacobro.Id_Concepto = cc_conceptocmsa.Id) WHERE (cc_cuentacobro.Id ='" + xid + "') GROUP BY cc_radicacion.Id ";
        ResultSet xrs = this.xct.traerRs(xsql);
        mCrearTabla();
        try {
            if (xrs.next()) {
                xrs.first();
                Principal.txtNo.setText(xrs.getString(1));
                this.JDFFechaC.setDate(xrs.getDate(2));
                this.JCBTercero.setSelectedItem(xrs.getString(3));
                this.JTAObservacion.setText(xrs.getString(4));
                this.JTFFNFacturaEvento.setText(xrs.getString(13));
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(6), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), x, 2);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), x, 3);
                    this.xmodelo.setValueAt(xrs.getString(9), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(10)), x, 5);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), x, 6);
                    this.xmodelo.setValueAt(true, x, 7);
                    this.xmodelo.setValueAt(xrs.getString(12), x, 8);
                    x++;
                }
                mTotalizarReembolso();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerarCuentaCobro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatos() {
        String sql = "SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta, cc_radicacion.Id_Comprobante, cc_radicacion.Id , round(SUM( cc_radicacion.SubTotal+ cc_radicacion.Iva+cc_radicacion.Flete+ cc_radicacion.Otros)) AS TotalReembolso, cc_conceptocmsa.Nbre AS Concepto, DATE_FORMAT(cc_radicacion.Fecha,'%d-%m-%Y') as FechaR FROM cc_radicacion INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_conceptocmsa ON (cc_radicacion.Id_Concepto= cc_conceptocmsa.Id)  INNER JOIN cc_documento_contables ON (cc_documento_contables.Id_Radicacion = cc_radicacion.Id) WHERE (cc_radicacion.`Tipo`= 0 AND cc_radicacion.Estado =1 AND cc_documento_contables.Id_CuentaCobro =0 and DATE_FORMAT(cc_radicacion.Fecha,'%Y')='" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + "' ) GROUP BY cc_radicacion.Id ORDER BY  cc_terceros.RazonSocialCompleta ASC, cc_radicacion.Fecha DESC ";
        mCrearTabla();
        ResultSet rs = this.xct.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), x, 3);
                    this.xmodelo.setValueAt(rs.getString(7), x, 4);
                    ConsultasMySQL xct = new ConsultasMySQL();
                    String sql2 = "SELECT Id FROM cc_documentoc WHERE (Id_Radicacion =" + rs.getLong(4) + " AND Estado =1) ";
                    ResultSet xrs = xct.traerRs(sql2);
                    if (xrs.next()) {
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 5);
                    } else {
                        this.xmodelo.setValueAt(new Integer(0), x, 5);
                    }
                    xrs.close();
                    xct.cerrarConexionBd();
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 6);
                    this.xmodelo.setValueAt(false, x, 7);
                    this.xmodelo.setValueAt(rs.getString(6), x, 8);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Detalle", 0);
                for (int x = 0; x < this.JTResultado.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTResultado.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTResultado.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Number(6, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 6).toString()).doubleValue()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConsultarBalance.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultarBalance.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }

    public void mImprimir() {
        new convertirNumerosLetras();
        String[][] mparametros = new String[5][2];
        mparametros[0][0] = "IdC";
        mparametros[0][1] = Principal.txtNo.getText();
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "nvalor";
        mparametros[2][1] = this.xmt.mConvertirNumeroLetras(this.JTFFTotalizarR.getText().replace(".", ","));
        mparametros[3][0] = "SUBREPORT_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[4][0] = "SUBREPORTFIRMA_DIR";
        mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (!this.JTFFNFacturaEvento.getText().equals("0")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_F_FacturaDianConsolidada_A", mparametros);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_CuentaCobro_Relacion", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_CuentaCobro", mparametros);
        }
    }

    private String mDdevuelveValorCombo(String dato) {
        String sqls = "SELECT Id FROM cc_conceptocmsa WHERE (Nbre ='" + dato + "') ";
        ConsultasMySQL xct = new ConsultasMySQL();
        String xv = xct.traerDato(sqls);
        xct.cerrarConexionBd();
        return xv;
    }

    private void mTotalizarReembolso() {
        double xtotal = 0.0d;
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            if (this.JTResultado.getValueAt(y, 7).toString().equals("true")) {
                xtotal += Double.valueOf(this.xmodelo.getValueAt(y, 6).toString()).doubleValue();
            }
        }
        this.JTFFTotalizarR.setValue(Double.valueOf(xtotal));
    }

    public void mAnular() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            String sql = "update cc_cuentacobro set Estado=0 where Id='" + Principal.txtNo.getText() + "'";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            String sql2 = "update cc_documentoc set Id_CuentaCobro=0 where Id_CuentaCobro='" + Principal.txtNo.getText() + "'";
            this.xct.ejecutarSQL(sql2);
            this.xct.cerrarConexionBd();
            Principal.xclase.mAnularFacturaEvento(this.JTFFNFacturaEvento.getText());
        }
    }

    private void mGenerarFacturaEvento() {
        String sql = "insert into f_liquidacion (TotalServicio, TotalEps, TotalDescuento, TotalPaciente, CuotaModeradora, Copago, Id_SubGrupoServicio, IdEmpresaContxConv, NEquipo, DireccionIp, Estado, Fecha, UsuarioS )  values ('" + this.JTFFTotalizarR.getValue() + "','" + this.JTFFTotalizarR.getValue() + "','0','0','0','0','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][0] + "','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][1] + "','" + Principal.getLocalHost().getHostName() + "','" + Principal.getLocalHost().getHostAddress() + "','0','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xidliquidacion = this.xct.ejecutarSQLId(sql);
        this.xct.cerrarConexionBd();
        String sql2 = "insert into f_cuentacobro(IdGrupoServicio, Id_PeriodoC, IdEmpContxConv, Periodo_Fact, Periodo_Fact1, TotalServicio, TotalCuotaM, TotalCopago, TotalDesc, TotalNeto, NoRegistros, Fecha, UsuarioS)  values('" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][2] + "','" + Principal.xclase.getXidperiodoc() + "','" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()][1] + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + this.JTFFTotalizarR.getValue() + "','0','0','0','" + this.JTFFTotalizarR.getValue() + "','" + this.JTResultado.getRowCount() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        String xcuentacobro = this.xct.ejecutarSQLId(sql2);
        this.xct.cerrarConexionBd();
        String sql3 = "insert into f_factura_evento(Fecha_FacturaEvento, Prefijo, Id_Liquidacion, EstaArmada, No_CuentaCobro, ConceptoCobro, Sede, Fecha, UsuarioS)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.informacionIps.getPrefijoFactura() + "','" + xidliquidacion + "','2','" + xcuentacobro + "','" + this.JTAObservacion.getText() + "','" + Principal.sedeUsuarioSeleccionadaDTO.getNombre() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xnfacturaevento = this.xct.ejecutarSQLId(sql3);
        this.xct.cerrarConexionBd();
        String sql4 = "insert into f_detalle_facturaevento (No_FacturaEvento, Concepto, Total ) values('" + this.xnfacturaevento + "','" + this.JCBSubGrupo.getSelectedItem() + "','" + this.JTFFTotalizarR.getValue() + "')";
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
        this.JTFFNFacturaEvento.setText(Principal.informacionIps.getPrefijoFactura() + "" + this.xnfacturaevento);
        String sql5 = "update cc_cuentacobro set NFactura_Evento='" + this.xnfacturaevento + "' where Id='" + Principal.txtNo.getText() + "'";
        this.xct.ejecutarSQL(sql5);
        this.xct.cerrarConexionBd();
        JOptionPane.showInternalMessageDialog(this, "Se guardo con exito", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }
}
