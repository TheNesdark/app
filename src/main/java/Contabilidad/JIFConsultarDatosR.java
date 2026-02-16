package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultarDatosR.class */
public class JIFConsultarDatosR extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidempresa;
    private JIFRegistroRecibos xjifrrecibos;
    private JIFRegistroSReembolso xjifregistroreembolso;
    private JIFRadicacion jifradicacionr;
    private String xobjetollamador;
    private ButtonGroup JBGOpciones;
    private JComboBox JCBEmpresa;
    private JCheckBox JCHFiltro;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle1;
    public JTable JTResultado;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();

    public JIFConsultarDatosR(JInternalFrame xjif) {
        initComponents();
        this.xidempresa = this.xconsultas.llenarCombo("SELECT Id, RazonSocialCompleta FROM cc_terceros WHERE (Estado =1) ORDER BY RazonSocialCompleta ASC", this.xidempresa, this.JCBEmpresa);
        this.xconsultas.cerrarConexionBd();
        mRealizarCasting(xjif);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JSPDetalle1 = new JScrollPane();
        this.JTResultado = new JTable();
        this.JCHFiltro = new JCheckBox();
        this.JCBEmpresa = new JComboBox();
        this.JDFFechaF = new JDateChooser();
        this.JDFFechaI = new JDateChooser();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifmodificarcodagrup");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTA DE DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setForeground(new Color(0, 0, 204));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 255, 204));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarDatosR.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarDatosR.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTResultado);
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarDatosR.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarDatosR.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Contabilidad.JIFConsultarDatosR.3
            public void itemStateChanged(ItemEvent evt) {
                JIFConsultarDatosR.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, -2, 563, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltro).addGap(42, 42, 42)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle1).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, -1, -2).addComponent(this.JCHFiltro))).addGap(36, 36, 36).addComponent(this.JSPDetalle1, -2, -1, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            if (this.xobjetollamador.equals("jifregistrorecibos") || this.xobjetollamador.equals("jifregistrorecibos1")) {
                try {
                    this.xjifrrecibos.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                    this.xjifrrecibos.setSelected(true);
                } catch (PropertyVetoException e) {
                    Logger.getLogger(JIFConsultarDatosR.class.getName()).log(Level.SEVERE, (String) null, e);
                }
            } else if (this.xobjetollamador.equals("jifrgeistroreembolso") || this.xobjetollamador.equals("jifregistroreembolso1")) {
                try {
                    this.xjifregistroreembolso.mBuscarDatos(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                    this.xjifregistroreembolso.setSelected(true);
                } catch (PropertyVetoException e2) {
                    Logger.getLogger(JIFConsultarDatosR.class.getName()).log(Level.SEVERE, (String) null, e2);
                }
            } else if (this.xobjetollamador.equals("jifradicacionfac")) {
                try {
                    this.jifradicacionr.mCargarDatosReembolso(this.xmodelo.getValueAt(this.JTResultado.getSelectedRow(), 0).toString());
                    this.jifradicacionr.setSelected(true);
                } catch (PropertyVetoException e3) {
                    Logger.getLogger(JIFConsultarDatosR.class.getName()).log(Level.SEVERE, (String) null, e3);
                }
            }
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.JCBEmpresa.getSelectedIndex() != -1 && this.JCHFiltro.isSelected()) {
            mValidarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mValidarDatos();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Tercero", "Valor", "Estado"}) { // from class: Contabilidad.JIFConsultarDatosR.4
            Class[] types = {Long.class, String.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(30);
    }

    private void mCrearTabla2() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "No. Consecutivo", "Fecha", "Tercero", "Valor", "Estado"}) { // from class: Contabilidad.JIFConsultarDatosR.5
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mValidarDatos() {
        String sql = null;
        if (this.JCHFiltro.isSelected()) {
            if (this.xobjetollamador.equals("jifregistrorecibos") || this.xobjetollamador.equals("jifregistrorecibos1")) {
                mCargarDatos1("SELECT cc_recibocm.Id, cc_recibocm.NConsecutivo, DATE_FORMAT(cc_recibocm.FechaR,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, sum(cc_detalle_recibocm.Valor) as Valor, cc_recibocm.Estado FROM cc_detalle_recibocm INNER JOIN cc_recibocm ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) INNER JOIN cc_terceros  ON (cc_recibocm.Id_Empresa = cc_terceros.Id) INNER JOIN cc_tipo_concepto_caja  ON (cc_detalle_recibocm.Id_TipoConceptoC = cc_tipo_concepto_caja.Id) WHERE (cc_recibocm.FechaR>='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_recibocm.Id_TipoCaja ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "' AND cc_terceros.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND cc_recibocm.FechaR <='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY cc_recibocm.Id ORDER BY cc_recibocm.FechaR DESC ");
                return;
            }
            if (this.xobjetollamador.equals("jifrgeistroreembolso") || this.xobjetollamador.equals("jifrgeistroreembolso1")) {
                sql = "SELECT cc_radicacion_reembolso.Id, DATE_FORMAT(cc_radicacion_reembolso.Fecha,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, sum(cc_detalle_radicacion_reembolso.Valor) as Valor, cc_radicacion_reembolso.Estado FROM cc_radicacion_reembolso INNER JOIN cc_terceros  ON (cc_radicacion_reembolso.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_detalle_radicacion_reembolso ON (cc_detalle_radicacion_reembolso.Id_RadicacionR = cc_radicacion_reembolso.Id) WHERE (cc_radicacion_reembolso.Fecha >='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_radicacion_reembolso.Id_Proveedor ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND cc_radicacion_reembolso.Fecha <='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "') GROUP BY cc_radicacion_reembolso.Id ORDER BY cc_radicacion_reembolso.Fecha DES ";
            } else if (this.xobjetollamador.equals("jifradicacionfac")) {
                sql = "SELECT cc_radicacion_reembolso.Id, DATE_FORMAT(cc_radicacion_reembolso.Fecha,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, sum(cc_detalle_radicacion_reembolso.Valor), cc_radicacion_reembolso.Estado FROM cc_detalle_radicacion_reembolso INNER JOIN cc_radicacion_reembolso ON (cc_detalle_radicacion_reembolso.Id_RadicacionR = cc_radicacion_reembolso.Id) INNER JOIN cc_terceros  ON (cc_radicacion_reembolso.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_tipo_concepto_reembolso  ON (cc_detalle_radicacion_reembolso.Id_TipoConceptoR = cc_tipo_concepto_reembolso.Id) INNER JOIN cc_auxiliar_cuenta ON (cc_tipo_concepto_reembolso.Id_CPuc = cc_auxiliar_cuenta.Id) INNER JOIN cc_cuentapuc ON (cc_cuentapuc.Id = cc_auxiliar_cuenta.Cuenta) INNER JOIN cc_pucxunidad_funcional ON (cc_auxiliar_cuenta.Cuenta = cc_pucxunidad_funcional.Id_Puc)  INNER JOIN cc_unidad_funcional ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) WHERE (cc_radicacion_reembolso.Id_Radicacion=0 and cc_radicacion_reembolso.Fecha >='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_radicacion_reembolso.Fecha <='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "' and cc_radicacion_reembolso.Estado =1 AND cc_radicacion_reembolso.Autorizado =0) GROUP BY cc_radicacion_reembolso.Id";
            }
            mCargarDatos(sql);
            return;
        }
        if (this.xobjetollamador.equals("jifregistrorecibos") || this.xobjetollamador.equals("jifregistrorecibos1")) {
            mCargarDatos1("SELECT cc_recibocm.Id, cc_recibocm.NConsecutivo, DATE_FORMAT(cc_recibocm.FechaR,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, sum(cc_detalle_recibocm.Valor) as Valor, cc_recibocm.Estado FROM cc_detalle_recibocm INNER JOIN cc_recibocm ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) INNER JOIN cc_terceros  ON (cc_recibocm.Id_Empresa = cc_terceros.Id) INNER JOIN cc_tipo_concepto_caja  ON (cc_detalle_recibocm.Id_TipoConceptoC = cc_tipo_concepto_caja.Id) WHERE (cc_recibocm.Id_TipoCaja ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "') GROUP BY cc_recibocm.Id ORDER BY cc_recibocm.FechaR DESC ");
            return;
        }
        if (this.xobjetollamador.equals("jifrgeistroreembolso") || this.xobjetollamador.equals("jifregistroreembolso1")) {
            sql = "SELECT cc_radicacion_reembolso.Id, DATE_FORMAT(cc_radicacion_reembolso.Fecha,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, sum(cc_detalle_radicacion_reembolso.Valor) as Valor, cc_radicacion_reembolso.Estado FROM cc_radicacion_reembolso INNER JOIN cc_terceros  ON (cc_radicacion_reembolso.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_detalle_radicacion_reembolso ON (cc_detalle_radicacion_reembolso.Id_RadicacionR = cc_radicacion_reembolso.Id) GROUP BY cc_radicacion_reembolso.Id ORDER BY cc_radicacion_reembolso.Fecha DESC ";
        } else if (this.xobjetollamador.equals("jifradicacionfac")) {
            sql = "SELECT cc_radicacion_reembolso.Id, DATE_FORMAT(cc_radicacion_reembolso.Fecha,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, sum(cc_detalle_radicacion_reembolso.Valor), cc_radicacion_reembolso.Estado FROM cc_detalle_radicacion_reembolso INNER JOIN cc_radicacion_reembolso ON (cc_detalle_radicacion_reembolso.Id_RadicacionR = cc_radicacion_reembolso.Id) INNER JOIN cc_terceros  ON (cc_radicacion_reembolso.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_tipo_concepto_reembolso  ON (cc_detalle_radicacion_reembolso.Id_TipoConceptoR = cc_tipo_concepto_reembolso.Id) INNER JOIN cc_auxiliar_cuenta ON (cc_tipo_concepto_reembolso.Id_CPuc = cc_auxiliar_cuenta.Id) INNER JOIN cc_cuentapuc ON (cc_cuentapuc.Id = cc_auxiliar_cuenta.Cuenta) INNER JOIN cc_pucxunidad_funcional ON (cc_auxiliar_cuenta.Cuenta = cc_pucxunidad_funcional.Id_Puc)  INNER JOIN cc_unidad_funcional ON (cc_pucxunidad_funcional.Id_UnidadFuncional = cc_unidad_funcional.Id) WHERE (cc_radicacion_reembolso.Id_Radicacion=0 and  cc_radicacion_reembolso.Estado =1 AND cc_radicacion_reembolso.Autorizado =0) GROUP BY cc_radicacion_reembolso.Id ";
        }
        mCargarDatos(sql);
    }

    private void mCargarDatos(String sql) {
        mCrearTabla();
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
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(5)), x, 4);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos1(String sql) {
        mCrearTabla2();
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
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(6)), x, 5);
                    x++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xconsultas.mostrarErrorSQL(ex);
        }
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmetodos.getFechaActual());
        this.JDFFechaF.setDate(this.xmetodos.getFechaActual());
        this.JCHFiltro.setSelected(false);
        this.JCBEmpresa.setSelectedIndex(-1);
        mValidarDatos();
    }

    private void mRealizarCasting(JInternalFrame frm) {
        if (frm.getName().equals("jifregistrorecibos")) {
            this.xjifrrecibos = (JIFRegistroRecibos) frm;
            this.xobjetollamador = "jifregistrorecibos";
            return;
        }
        if (frm.getName().equals("jifregistrorecibos1")) {
            this.xjifrrecibos = (JIFRegistroRecibos) frm;
            this.xobjetollamador = "jifregistrorecibos1";
            return;
        }
        if (frm.getName().equals("jifrgeistroreembolso")) {
            this.xjifregistroreembolso = (JIFRegistroSReembolso) frm;
            this.xobjetollamador = "jifrgeistroreembolso";
        } else if (frm.getName().equals("jifradicacionfac")) {
            this.jifradicacionr = (JIFRadicacion) frm;
            this.xobjetollamador = "jifradicacionfac";
        } else if (frm.getName().equals("jifregistroreembolso1")) {
            this.xjifregistroreembolso = (JIFRegistroSReembolso) frm;
            this.xobjetollamador = "jifregistroreembolso1";
        }
    }
}
