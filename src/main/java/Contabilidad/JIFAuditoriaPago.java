package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFAuditoriaPago.class */
public class JIFAuditoriaPago extends JInternalFrame {
    private DefaultTableModel xmodelo;
    public String[] xidauxiliar;
    public String[] xidauxiliarxpagar;
    public String[][] xidcentrocosto;
    public String[][] xidempresa;
    private Object[] xdato;
    private ButtonGroup JBGTipo;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPITipo;
    private JRadioButton JRBAprobados;
    private JRadioButton JRBPorAprobar;
    private JRadioButton JRBPorRevisar;
    private JRadioButton JRBRevAprovados;
    private JRadioButton JRBRevisados;
    private JScrollPane JSPResultado;
    private JTextField JTFTercero;
    public JTable JTResultado;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xposv = 5;
    private String xidcuentapuc = "0";

    public JIFAuditoriaPago(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPITipo = new JPanel();
        this.JRBPorRevisar = new JRadioButton();
        this.JRBRevisados = new JRadioButton();
        this.JRBPorAprobar = new JRadioButton();
        this.JRBRevAprovados = new JRadioButton();
        this.JRBAprobados = new JRadioButton();
        this.JTFTercero = new JTextField();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("ADITORIA CUENTAS POR PAGAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifauditoriacp");
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Tahoma", 0, 12));
        this.JTResultado.setForeground(new Color(0, 0, 204));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 255, 204));
        this.JTResultado.setRowHeight(20);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFAuditoriaPago.1
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriaPago.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        this.JPITipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGTipo.add(this.JRBPorRevisar);
        this.JRBPorRevisar.setFont(new Font("Arial", 1, 12));
        this.JRBPorRevisar.setSelected(true);
        this.JRBPorRevisar.setText("Por Revisar");
        this.JRBPorRevisar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAuditoriaPago.2
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaPago.this.JRBPorRevisarActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBRevisados);
        this.JRBRevisados.setFont(new Font("Arial", 1, 12));
        this.JRBRevisados.setText("Revisados");
        this.JRBRevisados.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAuditoriaPago.3
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaPago.this.JRBRevisadosActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBPorAprobar);
        this.JRBPorAprobar.setFont(new Font("Arial", 1, 12));
        this.JRBPorAprobar.setText("Por Aprobar");
        this.JRBPorAprobar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAuditoriaPago.4
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaPago.this.JRBPorAprobarActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBRevAprovados);
        this.JRBRevAprovados.setFont(new Font("Arial", 1, 12));
        this.JRBRevAprovados.setText("Revisados y Aprobados");
        this.JRBRevAprovados.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAuditoriaPago.5
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaPago.this.JRBRevAprovadosActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBAprobados);
        this.JRBAprobados.setFont(new Font("Arial", 1, 12));
        this.JRBAprobados.setText("Aprobados");
        this.JRBAprobados.addActionListener(new ActionListener() { // from class: Contabilidad.JIFAuditoriaPago.6
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriaPago.this.JRBAprobadosActionPerformed(evt);
            }
        });
        GroupLayout JPITipoLayout = new GroupLayout(this.JPITipo);
        this.JPITipo.setLayout(JPITipoLayout);
        JPITipoLayout.setHorizontalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addComponent(this.JRBPorRevisar).addGap(18, 18, 18).addComponent(this.JRBRevisados).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPorAprobar)).addGroup(JPITipoLayout.createSequentialGroup().addComponent(this.JRBAprobados).addGap(31, 31, 31).addComponent(this.JRBRevAprovados))).addContainerGap(12, 32767)));
        JPITipoLayout.setVerticalGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPorRevisar).addComponent(this.JRBRevisados).addComponent(this.JRBPorAprobar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addGroup(JPITipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAprobados).addComponent(this.JRBRevAprovados)).addContainerGap()));
        this.JTFTercero.setFont(new Font("Arial", 0, 13));
        this.JTFTercero.setHorizontalAlignment(2);
        this.JTFTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTercero.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFAuditoriaPago.7
            public void keyTyped(KeyEvent evt) {
                JIFAuditoriaPago.this.JTFTerceroKeyTyped(evt);
            }
        });
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 0, 13));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 0, 13));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPResultado, -1, 1142, 32767).addComponent(this.JPITipo, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTercero, -2, 673, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFTercero, -2, -1, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2))).addComponent(this.JSPResultado, -2, 573, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipo, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1 && this.JTResultado.getSelectedColumn() == 0) {
            if (this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 9).toString().equals("")) {
                Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString(), "CC_LiquidacionFactura", "4", "", "");
                return;
            }
            Object[] botones = {"Documento Contable", "Soporte Factura", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea visualizar", "VSUALIZAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                Principal.xclase.mImprimDocumentoContable("IdC", this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString(), "CC_LiquidacionFactura", "4", "", "");
            } else if (n == 1) {
                this.xmetodos.mostrarPdf(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 9).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorRevisarActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRevisadosActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorAprobarActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAprobadosActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRevAprovadosActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFTerceroKeyTyped(KeyEvent evt) {
        if (!this.JTFTercero.getText().isEmpty()) {
            mCargarDatos();
        }
    }

    public boolean isCellEditable(int row, int column) {
        return this.JTResultado.getModel().isCellEditable(row, column);
    }

    public void mGrabar() {
        String sql = null;
        if (this.xmetodos.mVerificarDatosTablaTrue(this.JTResultado, this.xposv)) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                    if (this.JTResultado.getValueAt(y, this.xposv).toString().equals("true")) {
                        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
                            sql = "update cc_documentoc set cc_documentoc.RevisadoC=1, cc_documentoc.FechaR='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                        } else if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 3) {
                            sql = "update cc_documentoc set cc_documentoc.AprobadoA=1, cc_documentoc.FechaA='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                        }
                        this.xconsultas.ejecutarSQL(sql);
                        this.xconsultas.cerrarConexionBd();
                    }
                }
                mCargarDatos();
            }
        }
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFFechaF.setDate(this.xmetodos.getFechaActual());
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Empresa", "SubTotal", "Neto a Pagar", "RevisadoC", "FechaR", "AprobadoA", "FechaA", "Url"}) { // from class: Contabilidad.JIFAuditoriaPago.8
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Boolean.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    private void mCrearTabla1() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Empresa", "SubTotal", "Neto a Pagar", "RevisadoC", "FechaR", "AprobadoA", "FechaA", "Url"}) { // from class: Contabilidad.JIFAuditoriaPago.9
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Boolean.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    private void mCrearTabla2() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Empresa", "SubTotal", "Neto a Pagar", "RevisadoC", "FechaR", "AprobadoA", "FechaA", "Url"}) { // from class: Contabilidad.JIFAuditoriaPago.10
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Boolean.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(40);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
    }

    private void mCargarDatos() {
        String sql = null;
        if (this.JRBPorRevisar.isSelected()) {
            if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
                mCrearTabla();
                this.xposv = 5;
            }
            if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 3) {
                mCrearTabla1();
                this.xposv = 7;
            }
            sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS fecha, ccv_radicacion.Nbre, ccv_radicacion.SubTotal, SUM(cc_detalle_documentoc.VDebito) AS NetoPagar, cc_documentoc.RevisadoC, cc_documentoc.FechaR , cc_documentoc.AprobadoA, cc_documentoc.FechaA, ccv_radicacion.Url FROM cc_documentoc INNER JOIN ccv_radicacion ON (cc_documentoc.Id_Radicacion = ccv_radicacion.Id)INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) WHERE (ccv_radicacion.IdComprobante=0 and cc_documentoc.RevisadoC =0 and cc_documentoc.Estado =1  and cc_documentoc.FechaD>='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' and cc_documentoc.FechaD<='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY cc_documentoc.Id  order by ccv_radicacion.Nbre, cc_documentoc.Id";
        } else if (this.JRBRevisados.isSelected()) {
            mCrearTabla2();
            sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS fecha, ccv_radicacion.Nbre, ccv_radicacion.SubTotal, SUM(cc_detalle_documentoc.VDebito) AS NetoPagar, cc_documentoc.RevisadoC, cc_documentoc.FechaR , cc_documentoc.AprobadoA, cc_documentoc.FechaA, ccv_radicacion.Url FROM cc_documentoc INNER JOIN ccv_radicacion ON (cc_documentoc.Id_Radicacion = ccv_radicacion.Id)INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) WHERE (ccv_radicacion.IdComprobante=0 and cc_documentoc.RevisadoC =1  and cc_documentoc.AprobadoA =0 and cc_documentoc.Estado =1 and cc_documentoc.FechaD>='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' and cc_documentoc.FechaD<='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "' ) GROUP BY cc_documentoc.Id order by ccv_radicacion.Nbre, cc_documentoc.Id";
        } else if (this.JRBPorAprobar.isSelected()) {
            if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
                mCrearTabla();
                this.xposv = 5;
            }
            if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 3) {
                mCrearTabla1();
                this.xposv = 7;
            }
            sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS fecha, ccv_radicacion.Nbre, ccv_radicacion.SubTotal, SUM(cc_detalle_documentoc.VDebito) AS NetoPagar, cc_documentoc.RevisadoC, cc_documentoc.FechaR , cc_documentoc.AprobadoA, cc_documentoc.FechaA, ccv_radicacion.Url FROM cc_documentoc INNER JOIN ccv_radicacion ON (cc_documentoc.Id_Radicacion = ccv_radicacion.Id)INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) WHERE (ccv_radicacion.IdComprobante=0 and cc_documentoc.AprobadoA =0 and cc_documentoc.Estado =1 and cc_documentoc.FechaD>='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' and cc_documentoc.FechaD<='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "' ) GROUP BY cc_documentoc.Id ";
        } else if (this.JRBAprobados.isSelected()) {
            mCrearTabla2();
            sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS fecha, ccv_radicacion.Nbre, ccv_radicacion.SubTotal, SUM(cc_detalle_documentoc.VDebito) AS NetoPagar, cc_documentoc.RevisadoC, cc_documentoc.FechaR , cc_documentoc.AprobadoA, cc_documentoc.FechaA, ccv_radicacion.Url FROM cc_documentoc INNER JOIN ccv_radicacion ON (cc_documentoc.Id_Radicacion = ccv_radicacion.Id)INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) WHERE (ccv_radicacion.IdComprobante=0 and cc_documentoc.AprobadoA =1 and cc_documentoc.Estado =1 and cc_documentoc.FechaD>='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' and cc_documentoc.FechaD<='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "' ) GROUP BY cc_documentoc.Id ";
        } else if (this.JRBRevAprovados.isSelected()) {
            mCrearTabla2();
            sql = "SELECT cc_documentoc.Id, DATE_FORMAT(cc_documentoc.FechaD,'%d-%m-%Y') AS fecha, ccv_radicacion.Nbre, ccv_radicacion.SubTotal, SUM(cc_detalle_documentoc.VDebito) AS NetoPagar, cc_documentoc.RevisadoC, cc_documentoc.FechaR , cc_documentoc.AprobadoA, cc_documentoc.FechaA, ccv_radicacion.Url FROM cc_documentoc INNER JOIN ccv_radicacion ON (cc_documentoc.Id_Radicacion = ccv_radicacion.Id)INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) WHERE (ccv_radicacion.IdComprobante=0 and cc_documentoc.RevisadoC =1 and cc_documentoc.AprobadoA =1 and cc_documentoc.Estado =1 and cc_documentoc.FechaD>='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' and cc_documentoc.FechaD<='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "' ) GROUP BY cc_documentoc.Id ";
        }
        ResultSet rs = this.xconsultas.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(8)), x, 7);
                    this.xmodelo.setValueAt(rs.getString(9), x, 8);
                    this.xmodelo.setValueAt(this.xmetodos.mTraerUrlBD(rs.getString(10)), x, 9);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }
}
