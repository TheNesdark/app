package Contabilidad;

import Acceso.Principal;
import General.Anular;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFRegistroRecibos.class */
public class JIFRegistroRecibos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[][] xidconcepto;
    private String[][] xidempresa;
    private JIFConsultarDatosR xjifregisrecibos;
    private String xsql;
    private long xConsecutivo;
    private JButton JBTAdicionar;
    private JComboBox JCBConcepto;
    private JComboBox JCBTercero;
    private JDateChooser JDFFechaR;
    private JLabel JLBEtiquetaI;
    private JLabel JLBNSolicitud;
    private JLabel JLRubro;
    private JFormattedTextField JLSaldoR;
    private JPanel JPConcepto;
    private JPanel JPIDatos;
    private JPanel JPInfoPPTO;
    private JScrollPane JSPDetalle;
    private JSpinner JSPNEntrada;
    private JScrollPane JSPObservacion;
    private JTextPane JTAObservacion;
    private JTable JTDetalle;
    private JFormattedTextField JTFFValor;
    private JFormattedTextField JTFFValor1;
    private JFormattedTextField JTFFValorSaldo;
    private JFormattedTextField JTFFValorTotal;
    private JTextField JTF_NRecibo;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private int xnfila = -1;
    private double xvalormaxr = 0.0d;
    private double xporcentajer = 0.0d;
    private boolean xlleno = false;

    public JIFRegistroRecibos(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 0) {
            this.JPInfoPPTO.setVisible(false);
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(`NConsecutivo`) AS `MaximoCons` FROM `cc_recibocm` WHERE (`Id_TipoCaja` ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "' AND `Estado` =1);";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroRecibos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTercero = new JComboBox();
        this.JDFFechaR = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextPane();
        this.JSPNEntrada = new JSpinner();
        this.JTF_NRecibo = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPConcepto = new JPanel();
        this.JCBConcepto = new JComboBox();
        this.JTFFValor = new JFormattedTextField();
        this.JBTAdicionar = new JButton();
        this.JPInfoPPTO = new JPanel();
        this.JLRubro = new JLabel();
        this.JLSaldoR = new JFormattedTextField();
        this.JTFFValor1 = new JFormattedTextField();
        this.JTFFValorTotal = new JFormattedTextField();
        this.JLBNSolicitud = new JLabel();
        this.JTFFValorSaldo = new JFormattedTextField();
        this.JLBEtiquetaI = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE RECIBOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifregistrorecibos");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTercero.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRegistroRecibos.1
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistroRecibos.this.JCBTerceroItemStateChanged(evt);
            }
        });
        this.JDFFechaR.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaR.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaR.setFont(new Font("Arial", 1, 12));
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObservacion.setFont(new Font("Tahoma", 1, 12));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JSPNEntrada.setFont(new Font("Arial", 1, 12));
        this.JSPNEntrada.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        this.JSPNEntrada.setToolTipText("N° Entrada si Aplica");
        this.JSPNEntrada.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Entrada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_NRecibo.setFont(new Font("Arial", 1, 12));
        this.JTF_NRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFFechaR, -2, 121, -2).addGap(12, 12, 12).addComponent(this.JCBTercero, -2, 653, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPObservacion, -2, 534, -2).addGap(18, 18, 18).addComponent(this.JTF_NRecibo, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNEntrada, -2, 91, -2))).addContainerGap(16, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFFechaR, -2, 51, -2).addComponent(this.JCBTercero, -2, 51, -2)).addGap(5, 5, 5).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservacion, -2, 62, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_NRecibo, -2, 62, -2).addComponent(this.JSPNEntrada, -2, 62, -2))).addContainerGap(10, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Contabilidad.JIFRegistroRecibos.2
            public void keyPressed(KeyEvent evt) {
                JIFRegistroRecibos.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "CONCEPTO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBConcepto.setFont(new Font("Arial", 1, 12));
        this.JCBConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConcepto.addItemListener(new ItemListener() { // from class: Contabilidad.JIFRegistroRecibos.3
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistroRecibos.this.JCBConceptoItemStateChanged(evt);
            }
        });
        this.JTFFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor.setHorizontalAlignment(4);
        this.JTFFValor.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFRegistroRecibos.4
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroRecibos.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JPInfoPPTO.setBorder(BorderFactory.createTitledBorder((Border) null, "Información Presupuestal", 2, 0, new Font("Arial", 1, 11), new Color(0, 102, 0)));
        this.JLRubro.setFont(new Font("Arial", 1, 12));
        this.JLRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 11), Color.blue));
        this.JLSaldoR.setEditable(false);
        this.JLSaldoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLSaldoR.setForeground(Color.red);
        this.JLSaldoR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JLSaldoR.setHorizontalAlignment(4);
        this.JLSaldoR.setFont(new Font("Arial", 1, 12));
        GroupLayout JPInfoPPTOLayout = new GroupLayout(this.JPInfoPPTO);
        this.JPInfoPPTO.setLayout(JPInfoPPTOLayout);
        JPInfoPPTOLayout.setHorizontalGroup(JPInfoPPTOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInfoPPTOLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JLRubro, -2, 519, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLSaldoR, -1, 149, 32767).addContainerGap()));
        JPInfoPPTOLayout.setVerticalGroup(JPInfoPPTOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInfoPPTOLayout.createSequentialGroup().addGroup(JPInfoPPTOLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInfoPPTOLayout.createSequentialGroup().addComponent(this.JLRubro, -2, 50, -2).addGap(0, 0, 32767)).addComponent(this.JLSaldoR)).addContainerGap()));
        this.JTFFValor1.setEditable(false);
        this.JTFFValor1.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValor1.setForeground(Color.red);
        this.JTFFValor1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValor1.setHorizontalAlignment(0);
        this.JTFFValor1.setFont(new Font("Arial", 1, 12));
        GroupLayout JPConceptoLayout = new GroupLayout(this.JPConcepto);
        this.JPConcepto.setLayout(JPConceptoLayout);
        JPConceptoLayout.setHorizontalGroup(JPConceptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConceptoLayout.createSequentialGroup().addGroup(JPConceptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConceptoLayout.createSequentialGroup().addComponent(this.JCBConcepto, -2, 436, -2).addGap(6, 6, 6).addComponent(this.JTFFValor, -2, 122, -2).addGap(9, 9, 9).addComponent(this.JTFFValor1, -2, 122, -2)).addComponent(this.JPInfoPPTO, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar).addContainerGap()));
        JPConceptoLayout.setVerticalGroup(JPConceptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConceptoLayout.createSequentialGroup().addGroup(JPConceptoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConcepto, -2, 50, -2).addComponent(this.JTFFValor, -2, 50, -2).addComponent(this.JTFFValor1, -2, 50, -2)).addGap(11, 11, 11).addComponent(this.JPInfoPPTO, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPConceptoLayout.createSequentialGroup().addComponent(this.JBTAdicionar, -1, -1, 32767).addContainerGap()));
        this.JTFFValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Recibo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorTotal.setHorizontalAlignment(4);
        this.JTFFValorTotal.setFont(new Font("Arial", 1, 13));
        this.JLBNSolicitud.setFont(new Font("Arial", 1, 18));
        this.JLBNSolicitud.setForeground(Color.red);
        this.JLBNSolicitud.setHorizontalAlignment(0);
        this.JLBNSolicitud.setText("0");
        this.JLBNSolicitud.setBorder(BorderFactory.createTitledBorder((Border) null, "Solicitud N°", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTFFValorSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Saldo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorSaldo.setHorizontalAlignment(4);
        this.JTFFValorSaldo.setFont(new Font("Arial", 1, 13));
        this.JLBEtiquetaI.setFont(new Font("Arial", 1, 18));
        this.JLBEtiquetaI.setForeground(Color.red);
        this.JLBEtiquetaI.setHorizontalAlignment(0);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JLBNSolicitud, -2, 130, -2).addGap(6, 6, 6).addComponent(this.JTFFValorSaldo, -2, 144, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEtiquetaI, -2, 386, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorTotal, -2, 140, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPConcepto, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addGap(12, 12, 12).addComponent(this.JPConcepto, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 208, -2).addGap(9, 9, 9).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNSolicitud, -2, 67, -2).addComponent(this.JTFFValorSaldo, -2, 67, -2).addComponent(this.JLBEtiquetaI, -2, 67, -2)).addComponent(this.JTFFValorTotal, -2, 66, -2))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        mAdicionarC();
    }

    private void mGrabarR() {
        this.xnfila++;
        this.xmodelo.addRow(this.xdato);
        this.xmodelo.setValueAt(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0], this.xnfila, 0);
        this.xmodelo.setValueAt(this.JCBConcepto.getSelectedItem().toString(), this.xnfila, 1);
        this.xmodelo.setValueAt(this.JTFFValor.getValue(), this.xnfila, 2);
        mTotalizar();
        mLimpiarDP();
    }

    private void llenarCombo() {
        this.xlleno = false;
        this.JCBTercero.removeAllItems();
        this.xidempresa = this.xconsultas.llenarComboyLista("SELECT  `Id` , `RazonSocialCompleta` ,  `ActivoC` FROM `cc_terceros` ORDER BY `RazonSocialCompleta` ASC", this.xidempresa, this.JCBTercero, 3);
        this.JCBConcepto.removeAllItems();
        this.xsql = "SELECT cc_tipo_concepto_caja.Id, cc_tipo_concepto_caja.Nbre, cc_tipo_concepto_caja.Id_RubroP , cc_tipo_concepto_caja.VTope, IFNULL(SUM(D.Valor),0) Gastado,  (cc_tipo_concepto_caja.VTope-IFNULL(SUM(D.Valor),0)) Saldo\nFROM cc_tipo_concepto_caja \nLEFT JOIN(SELECT\n    `cc_recibocm`.`Id_TipoCaja`\n    , `cc_recibocm`.`Id_SolicitudR`\n    , `cc_detalle_recibocm`.`Id_TipoConceptoC`\n    , `cc_detalle_recibocm`.`Valor`\nFROM\n    `cc_detalle_recibocm`\n    INNER JOIN `cc_recibocm` \n        ON (`cc_detalle_recibocm`.`Id_ReciboCm` = `cc_recibocm`.`Id`)\nWHERE (`cc_recibocm`.`Id_SolicitudR` =0 AND  `cc_recibocm`.`Id_TipoCaja` ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "' AND cc_recibocm.`Estado`=1)) D\nON (D.Id_TipoConceptoC=cc_tipo_concepto_caja.Id)\nWHERE (cc_tipo_concepto_caja.Estado =1) GROUP BY cc_tipo_concepto_caja.Id ORDER BY cc_tipo_concepto_caja.Nbre ASC";
        this.xidconcepto = this.xconsultas.llenarComboyLista(this.xsql, this.xidconcepto, this.JCBConcepto, 6);
        this.xlleno = true;
        this.xconsultas.cerrarConexionBd();
    }

    private void mAdicionarC() {
        if (this.JCBConcepto.getSelectedIndex() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBConcepto.requestFocus();
            return;
        }
        if (Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() != 0.0d) {
            if (!mVerificarExistencia(Long.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][0]).longValue())) {
                if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                    if (Principal.informacionIps.getNombreIps().equals("E.S.E CAMU IRIS LOPEZ DURAN DE SAN ANTERO")) {
                        mGrabarR();
                        return;
                    }
                    if (mValidaSaldoRubro()) {
                        JOptionPane.showInternalMessageDialog(this, "El Valor no puede ser mayor al saldo del Rubro Presupuestal", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFFValor.requestFocus();
                        return;
                    } else if (Double.valueOf(this.JTFFValor1.getValue().toString()).doubleValue() <= 0.0d) {
                        JOptionPane.showInternalMessageDialog(this, "Concepto no tiene saldo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    } else if (Double.valueOf(this.JTFFValor1.getValue().toString()).doubleValue() >= Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue()) {
                        mGrabarR();
                        return;
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "El valor del recibo no puede ser mayor al saldo del concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                }
                mGrabarR();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Concepto ya existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El valor no puede ser cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFValor.requestFocus();
    }

    private boolean mValidaSaldoRubro() {
        boolean xValida = false;
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1 && Double.valueOf(this.JTFFValor.getValue().toString()).doubleValue() > Double.valueOf(this.JLSaldoR.getValue().toString()).doubleValue()) {
            xValida = true;
        }
        return xValida;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTerceroItemStateChanged(ItemEvent evt) {
        if (this.JCBTercero.getSelectedIndex() != -1 && this.xlleno && this.xidempresa[this.JCBTercero.getSelectedIndex()][1].equals("0")) {
            mMensajeTercero();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBConceptoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBConcepto.getSelectedIndex() != -1) {
            if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
                this.JLRubro.setText("");
                this.JLSaldoR.setValue(0);
                mRubro_Saldo();
                this.JTFFValor1.setValue(Double.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][4]));
            }
            if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
                this.JTFFValor.setValue(Double.valueOf(this.xidconcepto[this.JCBConcepto.getSelectedIndex()][2]));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
        }
    }

    private void mRubro_Saldo() {
        String sql = "SELECT  \nr.Id\n,r.IdPadre\n,r.Nbre NombreRubro \n,r.TipoRubro\n,Presupuesto_Inicial\n,Adicion_Presupuesto\n,Reduccion_Presupuesto\n,Traslados_Debitos\n,Traslados_Creditos\n,Presupuesto_Definitivo\n,Reconocimiento_Anterior\n,Reconocimiento_Actual\n,Reconocimiento_Total\n,Recaudo_Anterior\n,Recaudo_Actual\n,Recaudo_Total\n,Saldo_por_Ejecutar\n,Saldo_por_Recaudar \n,Certificado_Anterior\n,Certificado_Actual\n,Total_Certificados\n,Compromiso_Anterior\n,Compromiso_Actual\n,Compromiso_Total\n,Obligacion_Anterior\n,Obligacion_Actual\n,Total_Obligaciones\n,Pagos_Anterior\n,Pagos_Actual\n,Total_Pagos\n,Saldo_Disponible\n,Sin_Comprometer\n,Compromisos_por_Pagar\n,Cuentas_por_Pagar\n,Certificado_sin_Comprometer\n\nFROM pp_rubros r\nINNER JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n/*Actualizacion con nuevos clase documentos*/ \n/*Disponibilidad CDP*/\n ,(Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)  AS Certificado_Anterior\n ,(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)  AS Certificado_Actual\n ,((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)) Total_Certificados\n/*Compromiso RP*/\n ,(Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior) AS Compromiso_Anterior\n ,(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual) AS Compromiso_Actual\n ,((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual)) Compromiso_Total\n /*Obligacion OP*/\n ,(Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior) AS Obligacion_Anterior\n ,(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual) AS Obligacion_Actual\n ,((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual)) Total_Obligaciones\n /*Pagos PP*/\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n /*Operaciones...*/\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- ((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Sin_Comprometer\n ,(((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,(((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual))-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,(((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\n-- -------------------------------------------------------------\n,SUM(IFNULL(Adicion_Disponibilidad_Anterior,0)) Adicion_Disponibilidad_Anterior\n,SUM(IFNULL(Adicion_Disponibilidad_Actual,0)) Adicion_Disponibilidad_Actual\n,SUM(IFNULL(Reintegro_Disponibilidad_Anterior,0)) Reintegro_Disponibilidad_Anterior\n,SUM(IFNULL(Reintegro_Disponibilidad_Actual,0)) Reintegro_Disponibilidad_Actual\n,SUM(IFNULL(Adicion_Compromiso_Anterior,0)) Adicion_Compromiso_Anterior\n,SUM(IFNULL(Adicion_Compromiso_Actual,0)) Adicion_Compromiso_Actual\n,SUM(IFNULL(Reintegro_Compromiso_Anterior,0)) Reintegro_Compromiso_Anterior\n,SUM(IFNULL(Reintegro_Compromiso_Actual,0)) Reintegro_Compromiso_Actual\n,SUM(IFNULL(Adicion_Obligacion_Anterior,0)) Adicion_Obligacion_Anterior\n,SUM(IFNULL(Adicion_Obligacion_Actual,0)) Adicion_Obligacion_Actual\n,SUM(IFNULL(Reintegro_Obligacion_Anterior,0)) Reintegro_Obligacion_Anterior\n,SUM(IFNULL(Reintegro_Obligacion_Actual,0)) Reintegro_Obligacion_Actual\n\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD=9  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD=9  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD=4  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Compromiso_Anterior\n \n ,CASE WHEN Id_CD=4  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Compromiso_Actual\n \n,CASE WHEN Id_CD=5  AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Obligacion_Anterior\n \n,CASE WHEN Id_CD=5  AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Obligacion_Actual \n \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n -- -------------------------------------------------------\n /*\n10\tAdicion Disponibilidad\n11\tReintegro Disponibilidad\n12\tAdicion Compromiso\n13\tReintegro Compromiso\n14\tAdicion Obligación\n15\tReintegro Obligación\n*/\n ,CASE WHEN Id_CD=10 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=10 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Actual\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Actual\n\n ,CASE WHEN Id_CD=12 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=12 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Actual\n\n ,CASE WHEN Id_CD=13 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=13 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Reintegro_Compromiso_Actual \n    \n ,CASE WHEN Id_CD=14 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=14 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Adicion_Obligacion_Actual\n  \n,CASE WHEN Id_CD=15 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=15 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Actual\n \n\nFROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE   pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n    WHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') pact\n    WHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n    OR pact.Id=pant.id\n         )  \n    AND pp_movimiento.Id_MotivoAnulacion=1  and pp_detalle_movimiento.Estado =1 AND pp_rubros.`Id`='" + this.xidconcepto[this.JCBConcepto.getSelectedIndex()][1] + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' \n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos ) datos\nON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "';";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        System.out.println("Saldo Disponible-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                double valor = xrs.getDouble("Saldo_Disponible");
                this.JLRubro.setText(xrs.getString("NombreRubro"));
                this.JLSaldoR.setValue(Double.valueOf(valor));
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroRecibos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mMensajeTercero() {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Tercero desactivado por no tener movimiento;</p><font face='Arial' color='red' size=4>No se pueder realizar registro.", "VERIFICACIÓN TERCERO", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
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
        this.JTF_NRecibo.setText("");
        this.xlleno = false;
        llenarCombo();
        this.JLBNSolicitud.setText("0");
        this.JDFFechaR.setDate(this.xmetodos.getFechaActual());
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBConcepto.setSelectedIndex(-1);
        this.JTAObservacion.setText("");
        this.JTFFValor.setValue(0);
        this.JTFFValorTotal.setValue(0);
        this.JTFFValorSaldo.setValue(0);
        this.JSPNEntrada.setValue(0);
        this.JLBEtiquetaI.setText("");
        this.JLRubro.setText("");
        this.JLSaldoR.setValue(0);
        mCrearTabla();
        mTraerSaldoCaja();
        this.xlleno = true;
        this.JCBTercero.requestFocus();
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (this.JCBTercero.getSelectedIndex() == -1) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTercero.requestFocus();
                return;
            }
            if (Double.valueOf(this.JTFFValorTotal.getValue().toString()).doubleValue() <= getXvalormaxr()) {
                if (this.xnfila != -1) {
                    if (!this.JTAObservacion.getText().isEmpty()) {
                        if (this.xidempresa[this.JCBTercero.getSelectedIndex()][1].equals("1")) {
                            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (n == 0) {
                                mConcecutivo();
                                String sql = "insert into cc_recibocm(FechaR, NConsecutivo, Id_TipoCaja, Id_Empresa, Observacion, NEntrada, NFactura, Fecha, UsuarioS)values ('" + this.xmetodos.formatoAMD.format(this.JDFFechaR.getDate()) + "','" + this.xConsecutivo + "','" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "','" + this.xidempresa[this.JCBTercero.getSelectedIndex()][0] + "','" + this.JTAObservacion.getText() + "','" + this.JSPNEntrada.getValue() + "','" + this.JTF_NRecibo.getText() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                                Principal.txtEstado.setText("ACTIVO");
                                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                                    String sql2 = "insert into cc_detalle_recibocm (Id_ReciboCm, Id_TipoConceptoC, Valor)values ('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "')";
                                    this.xconsultas.ejecutarSQL(sql2);
                                }
                                mDescontarRecibo();
                                mTraerSaldoCaja();
                                return;
                            }
                            return;
                        }
                        mMensajeTercero();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "la observación no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTAObservacion.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe adicionar un concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El valor del recibo supera el tope máximo de reembolso\nTope$" + getXvalormaxr(), "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Concepto", "Valor"}) { // from class: Contabilidad.JIFRegistroRecibos.5
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
        this.JLRubro.setText("");
        this.JLSaldoR.setValue(new Integer(0));
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty() && !Principal.txtEstado.getText().equals("ANULADO")) {
            if (this.JLBNSolicitud.getText().equals("0")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular el registro?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    Anular frm = new Anular(null, true, "Registro de Recibos", 5);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El registro no se puede anular;\nYa tiene una solicitud realizada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    public void mAnular(String idMotivoAnulacion, String xObservacion) {
        this.xsql = "update cc_recibocm set Estado=0,  Id_Motivo_Anulacion='" + idMotivoAnulacion + "' ,`Fecha_Anulacion`='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' ,`Observacion_Anulacion`='" + xObservacion + "' ,`Usuario_Anulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "' where Id= '" + Principal.txtNo.getText() + "'";
        this.xconsultas.ejecutarSQL(this.xsql);
        this.xconsultas.cerrarConexionBd();
        Principal.txtEstado.setText("ANULADO");
        mSumarRecibo();
    }

    public void mBuscarDatos(String xid) {
        String sql = "SELECT cc_recibocm.Id, cc_recibocm.FechaR, cc_terceros.RazonSocialCompleta, cc_recibocm.Observacion, cc_recibocm.Id_SolicitudR, cc_detalle_recibocm.Id_TipoConceptoC, cc_tipo_concepto_caja.Nbre, cc_detalle_recibocm.Valor, if(cc_recibocm.Estado=1,'ACTIVO','ANULADO') AS estado FROM cc_detalle_recibocm INNER JOIN cc_recibocm ON (cc_detalle_recibocm.Id_ReciboCm = cc_recibocm.Id) INNER JOIN cc_terceros ON (cc_recibocm.Id_Empresa = cc_terceros.Id) INNER JOIN cc_tipo_concepto_caja  ON (cc_detalle_recibocm.Id_TipoConceptoC = cc_tipo_concepto_caja.Id) WHERE (cc_recibocm.Id ='" + xid + "' AND cc_recibocm.Id_TipoCaja ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "') ORDER BY cc_recibocm.FechaR DESC ";
        ResultSet xrs = this.xconsultas.traerRs(sql);
        mCrearTabla();
        try {
            if (xrs.next()) {
                Principal.txtNo.setText(xrs.getString(1));
                Principal.txtEstado.setText(xrs.getString(9));
                this.JDFFechaR.setDate(xrs.getDate(2));
                this.JCBTercero.setSelectedItem(xrs.getString(3));
                this.JTAObservacion.setText(xrs.getString(4));
                this.JLBNSolicitud.setText(xrs.getString(5));
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(7), this.xnfila, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(8)), this.xnfila, 2);
                    mTotalizar();
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroRecibos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        this.xjifregisrecibos = new JIFConsultarDatosR(this);
        Principal.cargarPantalla(this.xjifregisrecibos);
    }

    private void mDescontarRecibo() {
        String sql = "update cc_tipo_caja set Saldo=Saldo-" + Double.valueOf(this.JTFFValorTotal.getValue().toString()) + " where Id='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    private void mSumarRecibo() {
        String sql = "update cc_tipo_caja set Saldo=Saldo+" + Double.valueOf(this.JTFFValorTotal.getValue().toString()) + " where Id='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "'";
        this.xconsultas.ejecutarSQL(sql);
        this.xconsultas.cerrarConexionBd();
    }

    private void mTraerSaldoCaja() {
        try {
            String sql = "SELECT (cc_tipo_caja.monto-IFNULL(d.valor,0)) AS Saldo, PorcentajeR, VMaxReembolso\n,  IF( ((cc_tipo_caja.monto-IFNULL(d.valor,0))<=((cc_tipo_caja.Monto*cc_tipo_caja.PorcentajeR)/100)), 'DEBE REALIZAR REEMBOLSO', '') AS ETIQUETA \n FROM cc_tipo_caja \n LEFT JOIN (SELECT\n  SUM(`cc_detalle_recibocm`.`Valor`) Valor\n    , `cc_recibocm`.`Id_TipoCaja`\nFROM\n     `cc_detalle_recibocm`\n    INNER JOIN  `cc_recibocm` \n        ON (`cc_detalle_recibocm`.`Id_ReciboCm` = `cc_recibocm`.`Id`)\nWHERE (`cc_recibocm`.`Estado` =1\n    AND `cc_recibocm`.`Id_SolicitudR` =0)) d  ON (d.Id_TipoCaja=cc_tipo_caja.`Id`)\n WHERE (Id ='" + Principal.informacionGeneralPrincipalDTO.getIdCajaMenor() + "')";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                this.JTFFValorSaldo.setValue(Double.valueOf(xrs.getDouble(1)));
                setXporcentajer(xrs.getDouble(2));
                setXvalormaxr(xrs.getDouble(3));
                this.JLBEtiquetaI.setText(xrs.getString(4));
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroRecibos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public double getXporcentajer() {
        return this.xporcentajer;
    }

    public void setXporcentajer(double xporcentajer) {
        this.xporcentajer = xporcentajer;
    }

    public double getXvalormaxr() {
        return this.xvalormaxr;
    }

    public void setXvalormaxr(double xvalormaxr) {
        this.xvalormaxr = xvalormaxr;
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            mImprimir(Principal.txtNo.getText());
        }
    }

    private void mImprimir(String xid) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id_recibo";
        mparametros[0][1] = xid;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        if (Principal.informacionIps.getNombreIps().equals("SERVICIO OPORTUNO EN ASISTENCIA IPS S.A.S.")) {
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_ReciboCajaMenor_SOA", mparametros);
        } else {
            this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "CC_ReciboCajaMenor", mparametros);
        }
    }
}
