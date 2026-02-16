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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFRegistroFacturas.class */
public class JIFRegistroFacturas extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String xsql;
    private ButtonGroup JBGOpciones;
    private JDateChooser JDFFechaF;
    private JDateChooser JDFFechaI;
    private JPanel JPIDatos;
    private JPanel JPIDatosP;
    private JPanel JPIOrigen;
    private JRadioButton JRBAuditoria;
    private JRadioButton JRBEntrada;
    private JRadioButton JRBOrdenC;
    private JScrollPane JSPDetalle1;
    private JScrollPane JSPObservacion;
    private JFormattedTextField JTFFNImprimir;
    private JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValor1;
    private JTextField JTFNPersona;
    private JTextPane JTPObservacion;
    public JTable JTResultado;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xorigen = "ENTRADA";

    public JIFRegistroFacturas() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JPIOrigen = new JPanel();
        this.JRBEntrada = new JRadioButton();
        this.JRBAuditoria = new JRadioButton();
        this.JRBOrdenC = new JRadioButton();
        this.JTFFValor = new JFormattedTextField();
        this.JSPDetalle1 = new JScrollPane();
        this.JTResultado = new JTable();
        this.JPIDatosP = new JPanel();
        this.JTFNPersona = new JTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTPObservacion = new JTextPane();
        this.JTFFValor1 = new JFormattedTextField();
        this.JTFFNImprimir = new JFormattedTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE FACTURAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifregistrofact");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Contabilidad.JIFRegistroFacturas.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRegistroFacturas.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSULTA DE DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 51)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd-MM-yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JPIOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "Origen", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGOpciones.add(this.JRBEntrada);
        this.JRBEntrada.setFont(new Font("Arial", 1, 12));
        this.JRBEntrada.setSelected(true);
        this.JRBEntrada.setText("Entrada");
        this.JRBEntrada.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRegistroFacturas.2
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroFacturas.this.JRBEntradaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBAuditoria);
        this.JRBAuditoria.setFont(new Font("Arial", 1, 12));
        this.JRBAuditoria.setText("Auditoria");
        this.JRBAuditoria.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRegistroFacturas.3
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroFacturas.this.JRBAuditoriaActionPerformed(evt);
            }
        });
        this.JBGOpciones.add(this.JRBOrdenC);
        this.JRBOrdenC.setFont(new Font("Arial", 1, 12));
        this.JRBOrdenC.setText("Ordenes de Compra");
        this.JRBOrdenC.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRegistroFacturas.4
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroFacturas.this.JRBOrdenCActionPerformed(evt);
            }
        });
        GroupLayout JPIOrigenLayout = new GroupLayout(this.JPIOrigen);
        this.JPIOrigen.setLayout(JPIOrigenLayout);
        JPIOrigenLayout.setHorizontalGroup(JPIOrigenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOrigenLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEntrada).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAuditoria).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBOrdenC).addContainerGap(-1, 32767)));
        JPIOrigenLayout.setVerticalGroup(JPIOrigenLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIOrigenLayout.createSequentialGroup().addContainerGap().addGroup(JPIOrigenLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEntrada).addComponent(this.JRBAuditoria).addComponent(this.JRBOrdenC)).addContainerGap(-1, 32767)));
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 14));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JPIOrigen, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFValor, -2, 146, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 51, -2).addComponent(this.JDFFechaF, -2, 51, -2)).addComponent(this.JPIOrigen, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFFValor, GroupLayout.Alignment.TRAILING)).addContainerGap(-1, 32767)));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFRegistroFacturas.5
            public void mouseExited(MouseEvent evt) {
                JIFRegistroFacturas.this.JTResultadoMouseExited(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTResultado);
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ADICIONALES", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNPersona.setFont(new Font("Arial", 1, 12));
        this.JTFNPersona.setHorizontalAlignment(2);
        this.JTFNPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona que entrega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPObservacion.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setViewportView(this.JTPObservacion);
        this.JTFFValor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFValor1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor1.setHorizontalAlignment(4);
        this.JTFFValor1.setFont(new Font("Arial", 1, 14));
        this.JTFFNImprimir.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Relación Imprimir", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNImprimir.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNImprimir.setHorizontalAlignment(4);
        this.JTFFNImprimir.setFont(new Font("Arial", 1, 14));
        this.JTFFNImprimir.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFRegistroFacturas.6
            public void focusLost(FocusEvent evt) {
                JIFRegistroFacturas.this.JTFFNImprimirFocusLost(evt);
            }
        });
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNPersona, -1, 301, 32767).addComponent(this.JSPObservacion)).addGap(18, 18, 18).addComponent(this.JTFFValor1, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFNImprimir, -2, 146, -2).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValor1, -2, 51, -2).addComponent(this.JTFFNImprimir, -2, 51, -2))).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JTFNPersona, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -1, 100, 32767))).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle1, -1, 813, 32767).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JPIDatosP, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle1, -2, 263, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosP, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEntradaActionPerformed(ActionEvent evt) {
        this.xorigen = "ENTRADA";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAuditoriaActionPerformed(ActionEvent evt) {
        this.xorigen = "AUDITORIA FORMULAS MEDICINA PREPAGADA";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOrdenCActionPerformed(ActionEvent evt) {
        this.xorigen = "ORDENES DE COMPRA";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseExited(MouseEvent evt) {
        if (this.JTResultado.getRowCount() != -1) {
            mTotalizarRecibido();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNImprimirFocusLost(FocusEvent evt) {
        if (!this.JTFFNImprimir.getText().isEmpty()) {
            try {
                this.xsql = "SELECT `Origen`, `Id` FROM  `cc_resgitro_facturas` WHERE (`Id` ='" + this.JTFFNImprimir.getText() + "') ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.first();
                    Principal.txtNo.setText(this.JTFFNImprimir.getText());
                    if (xrs.getString(1).equals("ENTRADA")) {
                        this.JRBEntrada.setSelected(true);
                    } else if (xrs.getString(1).equals("AUDITORIA FORMULAS MEDICINA PREPAGADA")) {
                        this.JRBAuditoria.setSelected(true);
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "N° no se ha generado aun", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    Principal.txtNo.setText("");
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFRegistroFacturas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Tercero", "N° Factura", "Valor", "R", "Observación"}) { // from class: Contabilidad.JIFRegistroFacturas.7
            Class[] types = {Long.class, String.class, String.class, String.class, Double.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(50);
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JRBEntrada.setSelected(true);
        this.JTFNPersona.setText("");
        this.JTPObservacion.setText("");
        this.JTFFValor.setValue(new Double(0.0d));
        this.JTFFValor1.setValue(new Double(0.0d));
        this.JTFFNImprimir.setText("");
        mCrearTabla();
    }

    private void mCargarDatos() {
        if (this.JRBEntrada.isSelected()) {
            this.xsql = "SELECT `i_entradas`.`Id`    , DATE_FORMAT(`i_entradas`.`FechaEntrada`,'%d-%m-%Y')AS Fecha, `cc_terceros`.`RazonSocialCompleta`, `i_entradas`.`NoFactura`     , SUM(ROUND(( (`i_detalleentrada`.`ValorUnitario`*`i_detalleentrada`.`Cantidad`)+(((`i_detalleentrada`.`ValorUnitario`*`i_detalleentrada`.`Iva`)/100)*`i_detalleentrada`.`Cantidad`)))) AS `Valor`, `i_entradas`.Observacion FROM  `cc_terceros` INNER JOIN  `i_entradas`  ON (`cc_terceros`.`Id` = `i_entradas`.`IdProveedor`) INNER JOIN  `i_detalleentrada`  ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`) WHERE (`i_entradas`.`NoFactura` <>'0' AND `i_entradas`.`FechaEntrada` >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `i_entradas`.`FechaEntrada` <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND `i_entradas`.`IdBodega`=1 and `i_entradas`.Id_Registrofac=0 and i_entradas.Estado=0) GROUP BY `cc_terceros`.`Id`, `i_entradas`.`NoFactura` ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `i_entradas`.`NoFactura` ASC, `i_entradas`.`FechaEntrada` ASC ";
        } else if (this.JRBAuditoria.isSelected()) {
            this.xsql = "SELECT `d_auditoria_formulamp`.`Id`, `d_auditoria_formulamp`.`FechaF`, `cc_terceros`.`RazonSocialCompleta` , `d_auditoria_formulamp`.`NFactura` , (`d_auditoria_formulamp`.`Subtotal`+`d_auditoria_formulamp`.`Iva`+ `d_auditoria_formulamp`.`OtroValor`)  AS `Valor`, d_auditoria_formulamp.Observacion FROM `cc_terceros` INNER JOIN  `d_auditoria_formulamp`  ON (`cc_terceros`.`Id` = `d_auditoria_formulamp`.`Id_Empresa`) WHERE (`d_auditoria_formulamp`.`FechaF` >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `d_auditoria_formulamp`.`Id_Registrofac` =0 AND `d_auditoria_formulamp`.`Estado` =1 AND `d_auditoria_formulamp`.`FechaF` <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `d_auditoria_formulamp`.`NFactura` ASC ";
        } else if (this.JRBOrdenC.isSelected()) {
            this.xsql = "SELECT `cc_orden_compra_seguimiento`.`Id`, `cc_orden_compra_seguimiento`.`FechaFac`, `cc_terceros`.`RazonSocialCompleta`, `cc_orden_compra_seguimiento`.`NFactura`, `cc_orden_compra_seguimiento`.`Valor`, `cc_orden_compra`.`ObjetivoG` FROM  `cc_orden_compra_seguimiento` INNER JOIN  `cc_orden_compra`  ON (`cc_orden_compra_seguimiento`.`Id_OrdenC` = `cc_orden_compra`.`Id`) INNER JOIN  `cc_terceros`  ON (`cc_terceros`.`Id` = `cc_orden_compra`.`Id_Tercero`) WHERE (`cc_orden_compra_seguimiento`.`NFactura` <>'' AND `cc_orden_compra_seguimiento`.`Estado` =1 AND `cc_orden_compra_seguimiento`.`Id_Registrofac` =0) ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC, `cc_orden_compra_seguimiento`.`NFactura` ASC ";
        }
        mCrearTabla();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int xnfila = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), xnfila, 0);
                    this.xmodelo.setValueAt(rs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(rs.getString(3), xnfila, 2);
                    this.xmodelo.setValueAt(rs.getString(4), xnfila, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), xnfila, 4);
                    this.xmodelo.setValueAt(false, xnfila, 5);
                    this.xmodelo.setValueAt(rs.getString(6), xnfila, 6);
                    xvalor += rs.getDouble(5);
                    xnfila++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFValor.setValue(Double.valueOf(xvalor));
        } catch (SQLException ex) {
            Logger.getLogger(JIFDocContable.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        mCargarDatos();
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTResultado, 5)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "Insert into cc_resgitro_facturas(`FechaR`,Origen,  `NPersona`, `Observacion`,NPersonaR, CargoPR, `UsuarioS`) values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xorigen + "','" + this.JTFNPersona.getText() + "','" + this.JTPObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getNombreUsuario() + "','" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
                        if (this.xmodelo.getValueAt(y, 5).toString().equals("true")) {
                            if (this.JRBEntrada.isSelected()) {
                                this.xsql = "update i_entradas set Id_Registrofac='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                            } else if (this.JRBAuditoria.isSelected()) {
                                this.xsql = "update d_auditoria_formulamp set Id_Registrofac='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                            } else if (this.JRBOrdenC.isSelected()) {
                                this.xsql = "update cc_orden_compra_seguimiento set Id_Registrofac='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                            }
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        } else if (this.JRBOrdenC.isSelected()) {
                            this.xsql = "update cc_orden_compra_seguimiento set Id_Registrofac='" + Principal.txtNo.getText() + "' where Id='" + this.xmodelo.getValueAt(y, 0) + "'";
                        }
                    }
                    mBuscar();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar refistro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mPrepararVistaReporte() {
        mEliminarVista();
        if (this.JRBEntrada.isSelected()) {
            this.xsql = "SELECT `cc_resgitro_facturas`.`Id`,`cc_resgitro_facturas`.`Origen`, `cc_resgitro_facturas`.`FechaR`, `cc_resgitro_facturas`.`NPersona`, `cc_resgitro_facturas`.`Observacion`, `cc_resgitro_facturas`.`NPersonaR` , `cc_resgitro_facturas`.`CargoPR`, `i_entradas`.`Id` AS IdInterno, `i_entradas`.`FechaEntrada` AS FechaFac, `cc_terceros`.`RazonSocialCompleta`AS NTercero, `i_entradas`.`NoFactura` AS NFactura, SUM(ROUND(( (`i_detalleentrada`.`ValorUnitario`*`i_detalleentrada`.`Cantidad`)+(((`i_detalleentrada`.`ValorUnitario`*`i_detalleentrada`.`Iva`)/100)*`i_detalleentrada`.`Cantidad`)))) AS `Valor` FROM  `i_detalleentrada` INNER JOIN  `i_entradas`  ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `i_entradas`.`IdProveedor`) INNER JOIN  `cc_resgitro_facturas`  ON (`cc_resgitro_facturas`.`Id` = `i_entradas`.`Id_Registrofac`) WHERE (`cc_resgitro_facturas`.`Id` ='" + Principal.txtNo.getText() + "') GROUP BY  `cc_terceros`.`Id`, `i_entradas`.`NoFactura` ORDER BY  `cc_terceros`.`RazonSocialCompleta` ASC , `i_entradas`.`NoFactura` ASC  ";
        } else if (this.JRBAuditoria.isSelected()) {
            this.xsql = "SELECT `cc_resgitro_facturas`.`Id`,`cc_resgitro_facturas`.`Origen`, `cc_resgitro_facturas`.`FechaR`, `cc_resgitro_facturas`.`NPersona`, `cc_resgitro_facturas`.`Observacion`, `cc_resgitro_facturas`.`NPersonaR` ,`cc_resgitro_facturas`.`CargoPR`,  `d_auditoria_formulamp`.`Id` AS IdInterno, `d_auditoria_formulamp`.`FechaF` AS FechaFac,`cc_terceros`.`RazonSocialCompleta`AS NTercero , `d_auditoria_formulamp`.`NFactura` AS NFactura, (`d_auditoria_formulamp`.`Subtotal`+ `d_auditoria_formulamp`.`Iva`+ `d_auditoria_formulamp`.`OtroValor`) AS Valor FROM `cc_terceros` INNER JOIN `d_auditoria_formulamp`  ON (`cc_terceros`.`Id` = `d_auditoria_formulamp`.`Id_Empresa`) INNER JOIN `cc_resgitro_facturas` ON (`cc_resgitro_facturas`.`Id` = `d_auditoria_formulamp`.`Id_Registrofac`) WHERE `cc_resgitro_facturas`.`Id`='" + Principal.txtNo.getText() + "' ";
        }
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        String sqle = "CREATE VIEW cc_v_reporte_fac_recibidas AS " + this.xsql;
        this.xct.ejecutarSQL(sqle);
        this.xct.cerrarConexionBd();
    }

    private void mTotalizarRecibido() {
        double xvalor = 0.0d;
        for (int y = 0; y < this.JTResultado.getRowCount(); y++) {
            if (this.xmodelo.getValueAt(y, 5).toString().equals("true")) {
                xvalor += Double.valueOf(this.xmodelo.getValueAt(y, 4).toString()).doubleValue();
            }
        }
        this.JTFFValor1.setValue(Double.valueOf(xvalor));
    }

    private void mEliminarVista() {
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_reporte_fac_recibidas  ");
        this.xct.cerrarConexionBd();
    }

    public void mImprimir() {
        mPrepararVistaReporte();
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "id";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Relacion_Facturas_Recibidas", mparametros);
        }
    }
}
