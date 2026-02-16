package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFModificarDocumentosC.class */
public class JIFModificarDocumentosC extends JInternalFrame {
    private String[][] xidtipo;
    private String[] xidoc;
    private Object[] xdato;
    private String xsql;
    private DefaultTableModel xmodelo;
    private JComboBox JCBIdDoc;
    private JComboBox JCBTipoDoc;
    private JCheckBox JCHDocumento;
    private JPanel JPIDatos;
    private JPanel JPIFiltro;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JIFModificarDocumentosC() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTipoDoc = new JComboBox();
        this.JPIFiltro = new JPanel();
        this.JCHDocumento = new JCheckBox();
        this.JCBIdDoc = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("MODIFICACIÓN DE DOCUMENTOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifmoddocumentoc");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDoc.addItemListener(new ItemListener() { // from class: Contabilidad.JIFModificarDocumentosC.1
            public void itemStateChanged(ItemEvent evt) {
                JIFModificarDocumentosC.this.JCBTipoDocItemStateChanged(evt);
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTROS", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCHDocumento.setFont(new Font("Arial", 1, 12));
        this.JCHDocumento.setText("N° Documento");
        this.JCHDocumento.addActionListener(new ActionListener() { // from class: Contabilidad.JIFModificarDocumentosC.2
            public void actionPerformed(ActionEvent evt) {
                JIFModificarDocumentosC.this.JCHDocumentoActionPerformed(evt);
            }
        });
        this.JCBIdDoc.setFont(new Font("Arial", 1, 12));
        this.JCBIdDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHDocumento).addGap(18, 18, 18).addComponent(this.JCBIdDoc, -2, 107, -2).addContainerGap(103, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHDocumento).addComponent(this.JCBIdDoc, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoDoc, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIFiltro, -2, -1, -2).addGap(209, 209, 209)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDoc, -2, 50, -2).addComponent(this.JPIFiltro, -2, -1, -2)).addContainerGap(26, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFModificarDocumentosC.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFModificarDocumentosC.this.JSPDetallePropertyChange(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFModificarDocumentosC.4
            public void mouseClicked(MouseEvent evt) {
                JIFModificarDocumentosC.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFModificarDocumentosC.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFModificarDocumentosC.this.JTDetallePropertyChange(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 1001, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 354, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoDoc.getSelectedIndex() != -1) {
            this.JCBIdDoc.removeAllItems();
            this.xsql = "SELECT `cc_documentoc`.`Id`,`cc_documentoc`.`Id`  FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + Principal.xclase.getXidperiodoc() + "'AND `cc_documentoc`.`Estado` =1 AND `cc_documentoc`.`Id_TipoComprobante` ='" + this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0] + "') GROUP BY `cc_documentoc`.`Id` ORDER BY `cc_documentoc`.`Id` ASC ";
            this.xidoc = this.xct.llenarCombo(this.xsql, this.xidoc, this.JCBIdDoc);
            this.xlleno = true;
            this.JCBIdDoc.setSelectedIndex(-1);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHDocumentoActionPerformed(ActionEvent evt) {
        if (this.JCBTipoDoc.getSelectedIndex() != -1) {
            if (this.JCHDocumento.isSelected()) {
                this.JCBIdDoc.setEnabled(true);
            } else {
                this.JCBIdDoc.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0].equals("1")) {
            if (!this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString().equals("") && Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()).longValue() != 0 && Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString()).longValue() != 0) {
                String string1 = "Soporte Factura N° " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13);
                String string2 = "Factura Interna N° :  " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15);
                String string3 = "Comprobante Egreso :  " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16);
                Object[] botones = {string1, string2, string3, "Cerrar"};
                int n = JOptionPane.showInternalOptionDialog(this, "Que desea imprimir", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n == 0) {
                    this.xmt.mostrarPdf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString());
                    return;
                }
                if (n == 1) {
                    mImprimirD("Id", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString(), "CC_Factura_Interna");
                    return;
                } else {
                    if (n == 2) {
                        Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString(), "CC_DocumentoContableCE", "2", "", "");
                        Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString(), "CC_ComprobanteEgresoN", "2", "", "");
                        return;
                    }
                    return;
                }
            }
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString().equals("") || Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()).longValue() != 0 || Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString()).longValue() == 0) {
                if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString().equals("") && Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 15).toString()).longValue() == 0 && Long.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString()).longValue() != 0) {
                    String string12 = "Comprobante Egreso :  " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16);
                    Object[] botones2 = {string12, "Cerrar"};
                    if (JOptionPane.showInternalOptionDialog(this, "Que desea imprimir", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones2, "Cerrar") == 0) {
                        Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString(), "CC_DocumentoContableCE", "2", "", "");
                        Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString(), "CC_ComprobanteEgresoN", "2", "", "");
                        return;
                    }
                    return;
                }
                return;
            }
            String string13 = "Soporte Factura N° " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 13);
            String string22 = "Comprobante Egreso :  " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16);
            Object[] botones3 = {string13, string22, "Cerrar"};
            int n2 = JOptionPane.showInternalOptionDialog(this, "Que desea imprimir", "VISUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones3, "Cerrar");
            if (n2 == 0) {
                this.xmt.mostrarPdf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 14).toString());
            } else if (n2 == 1) {
                Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString(), "CC_DocumentoContableCE", "2", "", "");
                Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 16).toString(), "CC_ComprobanteEgresoN", "2", "", "");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPDetallePropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle.getRowCount() > 0 && this.JTDetalle.getSelectedRow() != -1) {
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3) != null) {
                mBuscarCuentaPuc(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString(), this.JTDetalle.getSelectedRow());
            } else {
                this.xmodelo.setValueAt("0", this.JTDetalle.getSelectedRow(), 3);
                this.xmodelo.setValueAt("", this.JTDetalle.getSelectedRow(), 4);
            }
            if (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5) != null) {
                mBuscarTercero(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString(), this.JTDetalle.getSelectedRow());
            } else {
                this.xmodelo.setValueAt("0", this.JTDetalle.getSelectedRow(), 5);
                this.xmodelo.setValueAt("", this.JTDetalle.getSelectedRow(), 6);
            }
        }
    }

    private void mImprimirD(String xdato, String xnvariable, String xnarchivo) {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = xnvariable;
        mparametros[0][1] = xdato;
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + xnarchivo, mparametros);
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCBTipoDoc.removeAllItems();
        this.xsql = "SELECT `cc_tipo_documentoc`.`Id`, `cc_tipo_documentoc`.`Nbre`, `cc_tipo_documentoc`.NReporte FROM  `cc_documentoc` INNER JOIN  `cc_tipo_documentoc`  ON (`cc_documentoc`.`Id_TipoComprobante` = `cc_tipo_documentoc`.`Id`) WHERE (`cc_documentoc`.`Estado` =1 AND `cc_documentoc`.`Id_PeriodoC` ='" + Principal.xclase.getXidperiodoc() + "') GROUP BY `cc_tipo_documentoc`.`Id` ORDER BY `cc_tipo_documentoc`.`Nbre` ASC ";
        this.xidtipo = this.xct.llenarComboyLista(this.xsql, this.xidtipo, this.JCBTipoDoc, 3);
        this.xlleno = true;
        this.JCBTipoDoc.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCHDocumento.setSelected(false);
        this.JCBIdDoc.setEnabled(false);
        mCrearModeloDatos();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Id_Periodo", "Puc", "Nombre Auxiliar Puc", "Id Tercero", "Nombre Tercero", "Debito", "Credito", "%Retención", "Base", "PucA", "Id TerceroA", "Id_C "}) { // from class: Contabilidad.JIFModificarDocumentosC.6
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, true, true, true, false, true, false, true, true, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCxP() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Id_Periodo", "Puc", "Nombre Auxiliar Puc", "Id Tercero", "Nombre Tercero", "Debito", "Credito", "%Retención", "Base", "PucA", "Id TerceroA", "Id_C", "UrlFactura", "Fac_Interna", "Id_Comprobante", "N° Fac"}) { // from class: Contabilidad.JIFModificarDocumentosC.7
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, Long.class, Long.class, String.class, Long.class, Long.class, String.class};
            boolean[] canEdit = {false, true, true, true, false, true, false, true, true, true, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
    }

    private void mCargarDatos(String sql) {
        if (this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0].equals("1")) {
            mCrearModeloDatosCxP();
        } else {
            mCrearModeloDatos();
        }
        ResultSet rs = this.xct.traerRs(sql);
        TableColumnModel cmodel = this.JTDetalle.getColumnModel();
        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        cmodel.getColumn(4).setCellRenderer(textAreaRenderer);
        TextAreaEditor textEditor = new TextAreaEditor();
        cmodel.getColumn(4).setCellEditor(textEditor);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(3)), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(8)), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(10)), x, 9);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(11)), x, 10);
                    this.xmodelo.setValueAt(rs.getString(4), x, 11);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), x, 12);
                    if (this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0].equals("1")) {
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(19)), x, 13);
                        this.xmodelo.setValueAt(rs.getString(16), x, 14);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(17)), x, 15);
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(18)), x, 16);
                        this.xmodelo.setValueAt(rs.getString(15), x, 17);
                    } else {
                        this.xmodelo.setValueAt(Long.valueOf(rs.getLong(12)), x, 13);
                    }
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    public void mBuscar() {
        this.xsql = "";
        if (this.JCBTipoDoc.getSelectedIndex() != -1) {
            if (this.JCHDocumento.isSelected()) {
                if (this.JCBIdDoc.getSelectedIndex() != -1) {
                    if (this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0].equals("1")) {
                        this.xsql = "SELECT `cc_documentoc`.`Id`, `cc_documentoc`.`FechaD`, `cc_documentoc`.`Id_PeriodoC`, `cc_detalle_documentoc`.`Id_Puc`, `cc_puc`.`Nbre`, `cc_detalle_documentoc`.`Id_Tercero`, `cc_terceros`.`RazonSocialCompleta`, `cc_detalle_documentoc`.`VDebito` , `cc_detalle_documentoc`.`VCredito`, `cc_detalle_documentoc`.`PRetencion`, `cc_detalle_documentoc`.`Base`, `cc_detalle_documentoc`.`Id_Puc`, `cc_detalle_documentoc`.`Id_Tercero`, `cc_puc`.`PBase`, `cc_radicacion`.`NoFactura`, `cc_radicacion`.`UrlFactura` , `cc_radicacion`.`Id_FacturaInterna`, `cc_radicacion`.`Id_Comprobante`, `cc_detalle_documentoc`.Id     FROM  `cc_detalle_documentoc` INNER JOIN  `cc_radicacion`  ON (`cc_detalle_documentoc`.`Id_Radicacion` = `cc_radicacion`.`Id`) INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN  `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) WHERE (`cc_documentoc`.`Id`='" + this.xidoc[this.JCBIdDoc.getSelectedIndex()] + "' and `cc_documentoc`.`Id_TipoComprobante` ='" + this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0] + "' and `cc_documentoc`.`Id_PeriodoC` ='" + Principal.xclase.getXidperiodoc() + "'  AND `cc_documentoc`.`Estado` =1) ORDER BY `cc_documentoc`.`Id` DESC, `cc_detalle_documentoc`.`VDebito` ASC ";
                    } else {
                        this.xsql = "SELECT `cc_documentoc`.`Id`, `cc_documentoc`.`FechaD`, `cc_documentoc`.`Id_PeriodoC`, `cc_detalle_documentoc`.`Id_Puc`, `cc_puc`.`Nbre`, `cc_detalle_documentoc`.`Id_Tercero`, `cc_terceros`.`RazonSocialCompleta`, `cc_detalle_documentoc`.`VDebito`, `cc_detalle_documentoc`.`VCredito`, `cc_detalle_documentoc`.`PRetencion`, `cc_detalle_documentoc`.`Base`, `cc_detalle_documentoc`.Id FROM  `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN  `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) WHERE (`cc_documentoc`.`Id`='" + this.xidoc[this.JCBIdDoc.getSelectedIndex()] + "' and `cc_documentoc`.`Id_PeriodoC` ='" + Principal.xclase.getXidperiodoc() + "' AND `cc_documentoc`.`Estado` =1 AND `cc_documentoc`.`Id_TipoComprobante` ='" + this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0] + "') ORDER BY `cc_documentoc`.`Id` ASC, `cc_detalle_documentoc`.`VDebito` DESC ";
                    }
                    mCargarDatos(this.xsql);
                    return;
                }
                return;
            }
            if (this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0].equals("1")) {
                this.xsql = "SELECT `cc_documentoc`.`Id`, `cc_documentoc`.`FechaD`, `cc_documentoc`.`Id_PeriodoC`, `cc_detalle_documentoc`.`Id_Puc`, `cc_puc`.`Nbre`, `cc_detalle_documentoc`.`Id_Tercero`, `cc_terceros`.`RazonSocialCompleta`, `cc_detalle_documentoc`.`VDebito` , `cc_detalle_documentoc`.`VCredito`, `cc_detalle_documentoc`.`PRetencion`, `cc_detalle_documentoc`.`Base`, `cc_detalle_documentoc`.`Id_Puc`, `cc_detalle_documentoc`.`Id_Tercero`, `cc_puc`.`PBase`, `cc_radicacion`.`NoFactura`, `cc_radicacion`.`UrlFactura` , `cc_radicacion`.`Id_FacturaInterna`, `cc_radicacion`.`Id_Comprobante`, `cc_detalle_documentoc`.Id     FROM  `cc_detalle_documentoc` INNER JOIN  `cc_radicacion`  ON (`cc_detalle_documentoc`.`Id_Radicacion` = `cc_radicacion`.`Id`) INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN  `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) WHERE (`cc_documentoc`.`Id_TipoComprobante` ='" + this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0] + "' and `cc_documentoc`.`Id_PeriodoC` ='" + Principal.xclase.getXidperiodoc() + "'  AND `cc_documentoc`.`Estado` =1) ORDER BY `cc_documentoc`.`Id` DESC, `cc_detalle_documentoc`.`VDebito` ASC ";
            } else {
                this.xsql = "SELECT `cc_documentoc`.`Id`, `cc_documentoc`.`FechaD`, `cc_documentoc`.`Id_PeriodoC`, `cc_detalle_documentoc`.`Id_Puc`, `cc_puc`.`Nbre`, `cc_detalle_documentoc`.`Id_Tercero`, `cc_terceros`.`RazonSocialCompleta`, `cc_detalle_documentoc`.`VDebito`, `cc_detalle_documentoc`.`VCredito`, `cc_detalle_documentoc`.`PRetencion`, `cc_detalle_documentoc`.`Base`, `cc_detalle_documentoc`.Id FROM  `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) INNER JOIN  `cc_puc`  ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`) INNER JOIN  `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + Principal.xclase.getXidperiodoc() + "' AND `cc_documentoc`.`Estado` =1 AND `cc_documentoc`.`Id_TipoComprobante` ='" + this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0] + "') ORDER BY `cc_documentoc`.`Id` ASC ";
            }
            mCargarDatos(this.xsql);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoDoc.requestFocus();
    }

    public void mGrabar() {
        if (this.JTDetalle.getRowCount() != -1) {
            if (!mVerificarDatosLLeno(this.JTDetalle, 3)) {
                if (!mVerificarDatosLLeno(this.JTDetalle, 5)) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de actualizar?", "ACTUALIZAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        this.xsql = "update cc_documentoc set FechaD='" + this.xmodelo.getValueAt(0, 1) + "' where Id='" + this.xmodelo.getValueAt(0, 0) + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                            this.xsql = "update cc_detalle_documentoc set `Id_Puc`='" + this.xmodelo.getValueAt(y, 3) + "', `Id_Tercero`='" + this.xmodelo.getValueAt(y, 5) + "', `VDebito`='" + this.xmodelo.getValueAt(y, 7) + "', `VCredito`='" + this.xmodelo.getValueAt(y, 8) + "', `PRetencion`='" + this.xmodelo.getValueAt(y, 9) + "', `Base`='" + this.xmodelo.getValueAt(y, 10) + "' WHERE `Id`='" + this.xmodelo.getValueAt(y, 13) + "' and Id_Documentoc='" + this.xmodelo.getValueAt(y, 0) + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        mBuscar();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Tiene Terceros No Validos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Tiene Cuentas Puc No Validos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public boolean mVerificarDatosLLeno(JTable xjtabla, int xpos) {
        boolean estado = false;
        if (xjtabla.getRowCount() > 0) {
            for (int i = 0; i < xjtabla.getRowCount(); i++) {
                if (xjtabla.getValueAt(i, xpos).equals("") || xjtabla.getValueAt(i, xpos) == null || xjtabla.getValueAt(i, xpos).toString().equals("0")) {
                    estado = true;
                    break;
                }
            }
        }
        return estado;
    }

    public void mImprimir() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "TipoDoc";
            mparametros[2][1] = this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][0];
            mparametros[3][0] = "SUBREPORT_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[4][0] = "SUBREPORTFIRMA_DIR";
            mparametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + this.xidtipo[this.JCBTipoDoc.getSelectedIndex()][1], mparametros);
        }
    }

    public void mBuscarCuentaPuc(String xId, int fila) {
        if (xId != null) {
            try {
                if (!xId.isEmpty()) {
                    String xsql = "SELECT `Nbre` FROM `cc_puc` WHERE (`Id` ='" + xId + "' AND `UNivel` =1);";
                    ResultSet rs = this.xct.traerRs(xsql);
                    if (rs.next()) {
                        rs.first();
                        this.xmodelo.setValueAt(rs.getString(1), fila, 4);
                    } else {
                        this.xmodelo.setValueAt("0", fila, 3);
                        this.xmodelo.setValueAt("", fila, 4);
                    }
                    rs.close();
                    this.xct.cerrarConexionBd();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFModificarDocumentosC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mBuscarTercero(String xId, int fila) {
        if (xId != null) {
            try {
                if (!xId.isEmpty()) {
                    String xsql = "SELECT `RazonSocialCompleta` FROM `cc_terceros` WHERE (`Id` ='" + xId + "' AND `Estado` =1);";
                    ResultSet rs = this.xct.traerRs(xsql);
                    if (rs.next()) {
                        rs.first();
                        this.xmodelo.setValueAt(rs.getString(1), fila, 6);
                    } else {
                        this.xmodelo.setValueAt("0", fila, 5);
                        this.xmodelo.setValueAt("", fila, 6);
                    }
                    rs.close();
                    this.xct.cerrarConexionBd();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFModificarDocumentosC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
