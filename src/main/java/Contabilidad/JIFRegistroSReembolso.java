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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFRegistroSReembolso.class */
public class JIFRegistroSReembolso extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[][] xidempresa;
    private String[][] xidconcepto;
    private JIFConsultarDatosR xjifregisrecibos;
    private JButton JBTAdicionar;
    private JComboBox JCBConcepto;
    private JComboBox JCBTercero;
    private JDateChooser JDFFechaR;
    private JPanel JPConcepto;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValorTotal;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xnfila = -1;
    private boolean xlleno = false;

    public JIFRegistroSReembolso(String xnombre) {
        initComponents();
        setName(xnombre);
        this.xidempresa = this.xconsultas.llenarComboyLista("SELECT `Id` , `RazonSocialCompleta`, ActivoC FROM `cc_terceros` WHERE (`Estado` =1) ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBTercero, 3);
        this.xidconcepto = this.xconsultas.llenarComboyLista("SELECT Id, Nbre, VFijo, Valor  FROM cc_tipo_concepto_reembolso WHERE (Estado =1) ORDER BY Nbre ASC", this.xidconcepto, this.JCBConcepto, 4);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTercero = new JComboBox();
        this.JDFFechaR = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPConcepto = new JPanel();
        this.JCBConcepto = new JComboBox();
        this.JTFFValor = new JFormattedTextField();
        this.JBTAdicionar = new JButton();
        this.JTFFValorTotal = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE REEMBOLSO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifregistroreembolso");
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFRegistroSReembolso.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRegistroSReembolso.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRegistroSReembolso.2
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistroSReembolso.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPObservacion, GroupLayout.Alignment.LEADING, -1, 777, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTercero, 0, 646, 32767))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTercero, -1, 51, 32767).addComponent(this.JDFFechaR, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JSPObservacion, -2, 73, -2).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "CONCEPTO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRegistroSReembolso.3
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistroSReembolso.this.JCBConceptoItemStateChanged(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("...");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRegistroSReembolso.4
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroSReembolso.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPConceptoLayout = new GroupLayout(this.JPConcepto);
        this.JPConcepto.setLayout(JPConceptoLayout);
        JPConceptoLayout.setHorizontalGroup(JPConceptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConceptoLayout.createSequentialGroup().addComponent(this.JCBConcepto, -2, 565, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFValor, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -1, 93, 32767).addContainerGap()));
        JPConceptoLayout.setVerticalGroup(JPConceptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPConceptoLayout.createSequentialGroup().addGroup(JPConceptoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFValor, GroupLayout.Alignment.LEADING, -1, 51, 32767).addComponent(this.JCBConcepto, -1, 51, 32767).addComponent(this.JBTAdicionar, -1, 51, 32767)).addGap(22, 22, 22)));
        this.JTFFValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Recibo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorTotal.setHorizontalAlignment(4);
        this.JTFFValorTotal.setFont(new Font("Arial", 1, 13));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(691, 691, 691).addComponent(this.JTFFValorTotal, -1, 141, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 822, 32767).addComponent(this.JPIDatos, -2, -1, -2).addComponent(this.JPConcepto, -1, -1, 32767)))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(3, 3, 3).addComponent(this.JPConcepto, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 166, -2).addGap(8, 8, 8).addComponent(this.JTFFValorTotal, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (this.JCBConcepto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConcepto.requestFocus();
            return;
        }
        if (Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() != 0.0d) {
            if (!mVerificarExistencia(Long.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0]).longValue())) {
                this.xnfila++;
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0], this.xnfila, 0);
                this.xmodelo.setValueAt(this.JCBConcepto.getSelectedItem().toString(), this.xnfila, 1);
                this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 2);
                mTotalizar();
                mLimpiarDP();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Concepto ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El valor no puede ser cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFValor.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBConcepto.getSelectedIndex() != -1) {
            if (this.xidconcepto[this.JCBConcepto.getSelectedIndex()][1].equals("1")) {
                this.JTFFValor.setValue(Double.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][2]));
            } else {
                this.JTFFValor.setValue(new Double(0.0d));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTercero.getSelectedIndex() != -1 && this.xidempresa[this.JCBTercero.getSelectedIndex()][1].equals("0")) {
            mMensajeTercero();
        }
    }

    private void mMensajeTercero() {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Tercero desactivado por no tener movimiento;</p><font face='Arial' color='red' size=4>No se pueder realizar registro.", "VERIFICACIÓN TERCERO", 2);
    }

    private void mTotalizar() {
        double xvalor = 0.0d;
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            xvalor += Double.valueOf(this.xmodelo.getValueAt(x, 2).toString()).doubleValue();
        }
        this.JTFFValorTotal.setValue(Double.valueOf(xvalor));
    }

    public void mNuevo() {
        Principal.txtEstado.setText("");
        Principal.txtNo.setText("");
        this.JDFFechaR.setDate(this.xmetodos.getFechaActual());
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBConcepto.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JTFFValor.setValue(new Integer(0));
        this.JTFFValorTotal.setValue(new Integer(0));
        mCrearTabla();
        this.JCBTercero.requestFocus();
        this.xlleno = true;
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() != -1) {
                if (this.xidempresa[this.JCBTercero.getSelectedIndex()][1].equals("1")) {
                    if (this.xnfila != -1) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            String sql = "insert into cc_radicacion_reembolso(Fecha, Id_Proveedor, Observacion, FechaS, UsuarioS)values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaR.getDate()) + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + this.JTAObservacion.getText() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                            this.xconsultas.cerrarConexionBd();
                            Principal.txtEstado.setText("ACTIVO");
                            for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                                String sql2 = "insert into cc_detalle_radicacion_reembolso (Id_RadicacionR, Id_TipoConceptoR, Valor)values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "')";
                                this.xconsultas.ejecutarSQL(sql2);
                                this.xconsultas.cerrarConexionBd();
                            }
                            mImprimir();
                            this.xmetodos.mEnvioCorreoElectronico("Se ha generado la radicación de reembolso N°" + Principal.txtNo.getText() + "\nfavor entrar a la aplicación Genoma Plus y autorizar", "autorizacioncompras@fundacionpanzenu.org.co", "AUTORIZACIÓN DE ORDEN DE SOLICITUD DE REEMBOLSO", Principal.usuarioSistemaDTO.getLogin());
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe adicionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                mMensajeTercero();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTercero.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Concepto", "Valor"}) { // from class: Contabilidad.JIFRegistroSReembolso.5
            Class[] types = {Long.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.xnfila = -1;
    }

    private boolean mVerificarExistencia(long xid) {
        boolean xestado = false;
        int x = 0;
        while (true) {
            if (x >= this.JTDetalle.getRowCount()) {
                break;
            }
            if (xid != Long.valueOf(this.xmodelo.getValueAt(x, 0).toString()).longValue()) {
                x++;
            } else {
                xestado = true;
                break;
            }
        }
        return xestado;
    }

    private void mLimpiarDP() {
        this.JCBConcepto.setSelectedIndex(-1);
        this.JTFFValor.setValue(new Integer(0));
        this.JCBConcepto.requestFocus();
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty() && !Principal.txtEstado.getText().equals("ANULADO")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular el registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "update cc_radicacion_reembolso set Estado=0 where Id='" + Principal.txtNo.getText() + "'";
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
                Principal.txtEstado.setText("ANULADO");
                this.xmetodos.mEnvioCorreoElectronico("Se anulo la la radicacion N°" + Principal.txtNo.getText(), "autorizacioncompras@fundacionpanzenu.org.co", "AUTORIZACIÓN DE ORDEN DE COMPRA", Principal.usuarioSistemaDTO.getLogin());
            }
        }
    }

    public void mBuscarDatos(String xid) {
        String sql = "SELECT cc_radicacion_reembolso.Id, cc_radicacion_reembolso.Fecha, cc_terceros.RazonSocialCompleta, cc_radicacion_reembolso.Observacion, cc_tipo_concepto_reembolso.Id, cc_tipo_concepto_reembolso.Nbre, cc_detalle_radicacion_reembolso.Valor, IF(cc_radicacion_reembolso.Estado=1,'ACTIVO','ANULADO') AS estado FROM cc_radicacion_reembolso INNER JOIN cc_terceros ON (cc_radicacion_reembolso.Id_Proveedor = cc_terceros.Id) INNER JOIN cc_detalle_radicacion_reembolso  ON (cc_detalle_radicacion_reembolso.Id_RadicacionR = cc_radicacion_reembolso.Id) INNER JOIN cc_tipo_concepto_reembolso ON (cc_detalle_radicacion_reembolso.Id_TipoConceptoR = cc_tipo_concepto_reembolso.Id) WHERE cc_radicacion_reembolso.Id='" + xid + "' ORDER BY cc_terceros.RazonSocialCompleta ASC ";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        mCrearTabla();
        try {
            if (xrs.next()) {
                Principal.txtNo.setText(xrs.getString(1));
                Principal.txtEstado.setText(xrs.getString(8));
                this.JDFFechaR.setDate(xrs.getDate(2));
                this.JCBTercero.setSelectedItem(xrs.getString(3));
                this.JTAObservacion.setText(xrs.getString(4));
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(6), this.xnfila, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(7)), this.xnfila, 2);
                    mTotalizar();
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroSReembolso.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        this.xjifregisrecibos = new JIFConsultarDatosR(this);
        Principal.cargarPantalla(this.xjifregisrecibos);
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "Id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_FReembolso", mparametros);
        }
    }
}
