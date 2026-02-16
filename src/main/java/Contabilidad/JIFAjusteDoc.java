package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFAjusteDoc.class */
public class JIFAjusteDoc extends JInternalFrame {
    private DefaultTableModel xmodelo;
    public String[] xidempresa;
    public String[] xidconcepto;
    public String[] xidconcepto1;
    private Object[] xdato;
    private ButtonGroup JBGTipo;
    private JPanel JPIConsulta;
    private JPanel JPTipo;
    private JRadioButton JRBComprobante;
    private JRadioButton JRBDocumento;
    private JScrollPane JSPResultado;
    private JFormattedTextField JTFFTotalizarR;
    public JTable JTResultado;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xposv = 5;
    private JComboBox comboBox = new JComboBox();
    private String xidcuentapuc = "0";

    public JIFAjusteDoc() {
        initComponents();
        mNuevo();
        this.xidconcepto1 = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_conceptocmsa WHERE (Estado =1) ORDER BY Nbre ASC", this.xidconcepto1, this.comboBox);
        this.xconsultas.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPIConsulta = new JPanel();
        this.JPTipo = new JPanel();
        this.JRBComprobante = new JRadioButton();
        this.JRBDocumento = new JRadioButton();
        this.JTFFTotalizarR = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIA CUENTAS POR PAGAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifajustedoc");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Tahoma", 0, 12));
        this.JTResultado.setForeground(new Color(0, 0, 204));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 255, 204));
        this.JTResultado.setRowHeight(20);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFAjusteDoc.1
            public void mouseClicked(MouseEvent evt) {
                JIFAjusteDoc.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFAjusteDoc.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAjusteDoc.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPIConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo.add(this.JRBComprobante);
        this.JRBComprobante.setFont(new Font("Arial", 1, 11));
        this.JRBComprobante.setText("Comprobante");
        this.JRBComprobante.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAjusteDoc.3
            public void actionPerformed(ActionEvent evt) {
                JIFAjusteDoc.this.JRBComprobanteActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBDocumento);
        this.JRBDocumento.setFont(new Font("Arial", 1, 11));
        this.JRBDocumento.setSelected(true);
        this.JRBDocumento.setText("Documento Contable");
        this.JRBDocumento.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAjusteDoc.4
            public void actionPerformed(ActionEvent evt) {
                JIFAjusteDoc.this.JRBDocumentoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBComprobante).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDocumento)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDocumento).addComponent(this.JRBComprobante)).addContainerGap(-1, 32767)));
        GroupLayout JPIConsultaLayout = new GroupLayout(this.JPIConsulta);
        this.JPIConsulta.setLayout(JPIConsultaLayout);
        JPIConsultaLayout.setHorizontalGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPTipo, -2, -1, -2).addContainerGap(-1, 32767)));
        JPIConsultaLayout.setVerticalGroup(JPIConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsultaLayout.createSequentialGroup().addComponent(this.JPTipo, -2, 50, 32767).addGap(13, 13, 13)));
        this.JTFFTotalizarR.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Reembolso", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalizarR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalizarR.setHorizontalAlignment(4);
        this.JTFFTotalizarR.setFont(new Font("Arial", 1, 13));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIConsulta, -2, -1, -2).addComponent(this.JSPResultado, GroupLayout.Alignment.TRAILING, -1, 1136, 32767).addComponent(this.JTFFTotalizarR, -2, 185, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIConsulta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 620, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFTotalizarR, -1, 68, 32767).addGap(13, 13, 13)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        mTotalizarReembolso();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBComprobanteActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDocumentoActionPerformed(ActionEvent evt) {
    }

    public boolean isCellEditable(int row, int column) {
        return this.JTResultado.getModel().isCellEditable(row, column);
    }

    public void mGrabar() {
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                if (!this.JTResultado.getValueAt(y, 5).toString().equals("")) {
                    String sql = "update cc_documentoc set Id_Concepto='" + mDdevuelveValorCombo(this.xmodelo.getValueAt(y, 5).toString()) + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                    this.xconsultas.ejecutarSQL(sql);
                    this.xconsultas.cerrarConexionBd();
                }
            }
            mCargarDatos();
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JRBDocumento.setSelected(true);
        mCargarDatos();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Empresa", "N° Comprobante", "N° Radicación", "Valor", "Concepto"}) { // from class: Contabilidad.JIFAjusteDoc.5
            Class[] types = {Long.class, String.class, Long.class, Long.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, true};

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
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(200);
        TableColumn sportColumn = this.JTResultado.getColumnModel().getColumn(5);
        sportColumn.setCellEditor(new DefaultCellEditor(this.comboBox));
    }

    private void mCargarDatos() {
        mCrearTabla();
        ResultSet rs = this.xconsultas.traerRs("SELECT cc_documentoc.Id , cc_terceros.RazonSocialCompleta, cc_radicacion.Id_Comprobante , cc_radicacion.Id , SUM(cc_radicacion.SubTotal+cc_radicacion.Iva+ cc_radicacion.Flete+ cc_radicacion.Otros)  AS STotal FROM cc_radicacion INNER JOIN cc_documentoc ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion) INNER JOIN cc_terceros ON (cc_radicacion.Id_Proveedor = cc_terceros.Id) WHERE (cc_radicacion.Id_Comprobante <>0 AND cc_documentoc.Estado =1 and cc_radicacion.Id_Concepto=0) GROUP BY cc_documentoc.Id ORDER BY cc_radicacion.Id_Comprobante ASC, cc_terceros.RazonSocialCompleta, cc_documentoc.Id ");
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
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt("", x, 5);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            Principal.xclase.mImprimDocumentoContable("IdC", Principal.txtNo.getText(), "CC_CuentaCobro", "2", "", "");
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
            if (this.JTResultado.getValueAt(y, 6).toString().equals("true")) {
                xtotal += Double.valueOf(this.xmodelo.getValueAt(y, 5).toString()).doubleValue();
            }
        }
        this.JTFFTotalizarR.setValue(Double.valueOf(xtotal));
    }
}
