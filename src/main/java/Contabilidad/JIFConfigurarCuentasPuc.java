package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConfigurarCuentasPuc.class */
public class JIFConfigurarCuentasPuc extends JInternalFrame {
    private String xsql;
    private boolean xmodo;
    private String[] xidtipoimpuesto;
    private String[] xidconceptosdian;
    private String[] xidconceptosid;
    private String[] xidnivelpuc;
    private String[] xidconceptoPago;
    private String[] xidconceptosdianf;
    private Object[] xDato;
    private DefaultTableModel xModelo;
    private ButtonGroup JBGCCostos;
    private ButtonGroup JBGMTercero;
    private ButtonGroup JBGTipo;
    private ButtonGroup JBGTipo1;
    private JComboBox JCBConceptoDian;
    private JComboBox JCBConceptoDianF;
    private JComboBox JCBConceptoID;
    private JComboBox JCBConceptoPago;
    private JComboBox JCBNivel;
    private JComboBox JCBTipoImp;
    private JCheckBox JCHAplicaNiif;
    private JCheckBox JCHCXP;

    /* JADX INFO: renamed from: JCHEsDedución, reason: contains not printable characters */
    private JCheckBox f2JCHEsDeducin;

    /* JADX INFO: renamed from: JCHEsDedución1, reason: contains not printable characters */
    private JCheckBox f3JCHEsDeducin1;
    private JCheckBox JCHEsIbc;
    private JCheckBox JCHEsUNivel;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JPanel JPIDian;
    private JPanel JPI_Datos1;
    private JPanel JPI_DatosC;
    private JPanel JPI_TipoMov;
    private JPanel JPMCentroCosto;
    private JPanel JPMTercero;
    private JPanel JPTipo;
    private JRadioButton JRBCredito;
    private JRadioButton JRBDebito;
    private JRadioButton JRBNo;
    private JRadioButton JRBNoC;
    private JRadioButton JRBSi;
    private JRadioButton JRBSiC;
    private JRadioButton JRB_Tipo_Niif;
    private JRadioButton JRB_Tipo_Normal;
    private JScrollPane JSPDian;
    private JSpinner JSPPBase;
    private JSpinner JSPPBaseR;
    private JTable JTDetalleDian;
    private JFormattedTextField JTFFCodigoAlterno;
    private JFormattedTextField JTFFCodigoNiif;
    private JFormattedTextField JTFFCodigoPadre;
    private JFormattedTextField JTFFIdCuenta;
    public JFormattedTextField JTFFTope;
    public JTextField JTFNCuentasPuc;
    private JTabbedPane JTP_Datos;
    private int xtipoc = 1;
    private int xmtercero = 0;
    private int xesdediccion = 0;
    private int xesdedicciond = 0;
    private int xesibc = 0;
    private int xesunivel = 0;
    private int xaplicaniif = 0;
    private int xguardar = 0;
    private int xestado = 0;
    private int xgrabarDian = 0;
    private int xcxp = 0;
    private String xcentrocosto = "000";
    private String xCuentaEquivocado = "";
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xmodoC = false;

    public JIFConfigurarCuentasPuc(String xcodigoc, boolean xmodo) {
        this.xmodo = false;
        initComponents();
        this.xmodo = xmodo;
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.JRB_Tipo_Niif.setSelected(true);
            JRB_Tipo_NiifActionPerformed(null);
        } else {
            this.JRB_Tipo_Normal.setSelected(true);
            JRB_Tipo_NormalActionPerformed(null);
        }
        mNuevo();
        this.JTFFIdCuenta.setText(xcodigoc);
        mBuscarCuenta(xcodigoc);
    }

    /* JADX WARN: Type inference failed for: r3v186, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JBGMTercero = new ButtonGroup();
        this.JBGCCostos = new ButtonGroup();
        this.JBGTipo1 = new ButtonGroup();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_DatosC = new JPanel();
        this.JPI_TipoMov = new JPanel();
        this.JRB_Tipo_Normal = new JRadioButton();
        this.JRB_Tipo_Niif = new JRadioButton();
        this.JPIDatos = new JPanel();
        this.JTFFIdCuenta = new JFormattedTextField();
        this.JTFNCuentasPuc = new JTextField();
        this.JCBNivel = new JComboBox();
        this.JPTipo = new JPanel();
        this.JRBCredito = new JRadioButton();
        this.JRBDebito = new JRadioButton();
        this.JPMTercero = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JPMCentroCosto = new JPanel();
        this.JRBSiC = new JRadioButton();
        this.JRBNoC = new JRadioButton();
        this.JCBTipoImp = new JComboBox();
        this.JSPPBase = new JSpinner();
        this.JSPPBaseR = new JSpinner();
        this.JTFFCodigoAlterno = new JFormattedTextField();
        this.JTFFCodigoPadre = new JFormattedTextField();
        this.JCHEsUNivel = new JCheckBox();
        this.JCHAplicaNiif = new JCheckBox();
        this.JTFFCodigoNiif = new JFormattedTextField();
        this.JCHCXP = new JCheckBox();
        this.JPI_Datos1 = new JPanel();
        this.f3JCHEsDeducin1 = new JCheckBox();
        this.f2JCHEsDeducin = new JCheckBox();
        this.JCHEsIbc = new JCheckBox();
        this.JCBConceptoDian = new JComboBox();
        this.JTFFTope = new JFormattedTextField();
        this.JCBConceptoID = new JComboBox();
        this.JCBConceptoPago = new JComboBox();
        this.JPIDian = new JPanel();
        this.JCBConceptoDianF = new JComboBox();
        this.JSPDian = new JScrollPane();
        this.JTDetalleDian = new JTable();
        this.JCHEstado = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("PUC");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconfigurarcuenta");
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_TipoMov.setBorder(BorderFactory.createTitledBorder((Border) null, "MOVIMIENTOS EN:", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo1.add(this.JRB_Tipo_Normal);
        this.JRB_Tipo_Normal.setFont(new Font("Arial", 1, 12));
        this.JRB_Tipo_Normal.setSelected(true);
        this.JRB_Tipo_Normal.setText("Colgaap");
        this.JRB_Tipo_Normal.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.1
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JRB_Tipo_NormalActionPerformed(evt);
            }
        });
        this.JBGTipo1.add(this.JRB_Tipo_Niif);
        this.JRB_Tipo_Niif.setFont(new Font("Arial", 1, 12));
        this.JRB_Tipo_Niif.setText("Niif");
        this.JRB_Tipo_Niif.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.2
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JRB_Tipo_NiifActionPerformed(evt);
            }
        });
        GroupLayout JPI_TipoMovLayout = new GroupLayout(this.JPI_TipoMov);
        this.JPI_TipoMov.setLayout(JPI_TipoMovLayout);
        JPI_TipoMovLayout.setHorizontalGroup(JPI_TipoMovLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoMovLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Tipo_Normal).addGap(18, 18, 18).addComponent(this.JRB_Tipo_Niif).addContainerGap(15, 32767)));
        JPI_TipoMovLayout.setVerticalGroup(JPI_TipoMovLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_TipoMovLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPI_TipoMovLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Tipo_Normal).addComponent(this.JRB_Tipo_Niif))));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS BASICOS DE LA CUENTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFIdCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Puc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIdCuenta.setHorizontalAlignment(4);
        this.JTFFIdCuenta.setFont(new Font("Arial", 1, 13));
        this.JTFFIdCuenta.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConfigurarCuentasPuc.3
            public void focusLost(FocusEvent evt) {
                JIFConfigurarCuentasPuc.this.JTFFIdCuentaFocusLost(evt);
            }
        });
        this.JTFFIdCuenta.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.4
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JTFFIdCuentaActionPerformed(evt);
            }
        });
        this.JTFNCuentasPuc.setFont(new Font("Arial", 1, 13));
        this.JTFNCuentasPuc.setHorizontalAlignment(2);
        this.JTFNCuentasPuc.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNivel.setFont(new Font("Arial", 1, 13));
        this.JCBNivel.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Naturaleza", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipo.add(this.JRBCredito);
        this.JRBCredito.setFont(new Font("Arial", 1, 11));
        this.JRBCredito.setSelected(true);
        this.JRBCredito.setText("Crédito");
        this.JRBCredito.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.5
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JRBCreditoActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBDebito);
        this.JRBDebito.setFont(new Font("Arial", 1, 11));
        this.JRBDebito.setText("Débito");
        this.JRBDebito.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.6
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JRBDebitoActionPerformed(evt);
            }
        });
        GroupLayout JPTipoLayout = new GroupLayout(this.JPTipo);
        this.JPTipo.setLayout(JPTipoLayout);
        JPTipoLayout.setHorizontalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBCredito).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDebito)));
        JPTipoLayout.setVerticalGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoLayout.createSequentialGroup().addGroup(JPTipoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDebito).addComponent(this.JRBCredito)).addContainerGap(-1, 32767)));
        this.JPMTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Maneja Tercero?", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGMTercero.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 11));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.7
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGMTercero.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 11));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.8
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPMTerceroLayout = new GroupLayout(this.JPMTercero);
        this.JPMTercero.setLayout(JPMTerceroLayout);
        JPMTerceroLayout.setHorizontalGroup(JPMTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMTerceroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addComponent(this.JRBNo).addGap(15, 15, 15)));
        JPMTerceroLayout.setVerticalGroup(JPMTerceroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMTerceroLayout.createSequentialGroup().addGroup(JPMTerceroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)).addContainerGap(-1, 32767)));
        this.JPMCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Maneja CCostos?", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGCCostos.add(this.JRBSiC);
        this.JRBSiC.setFont(new Font("Arial", 1, 11));
        this.JRBSiC.setText("Si");
        this.JRBSiC.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.9
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JRBSiCActionPerformed(evt);
            }
        });
        this.JBGCCostos.add(this.JRBNoC);
        this.JRBNoC.setFont(new Font("Arial", 1, 11));
        this.JRBNoC.setSelected(true);
        this.JRBNoC.setText("No");
        this.JRBNoC.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.10
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JRBNoCActionPerformed(evt);
            }
        });
        GroupLayout JPMCentroCostoLayout = new GroupLayout(this.JPMCentroCosto);
        this.JPMCentroCosto.setLayout(JPMCentroCostoLayout);
        JPMCentroCostoLayout.setHorizontalGroup(JPMCentroCostoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMCentroCostoLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JRBSiC).addGap(18, 18, 18).addComponent(this.JRBNoC).addContainerGap(12, 32767)));
        JPMCentroCostoLayout.setVerticalGroup(JPMCentroCostoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMCentroCostoLayout.createSequentialGroup().addGroup(JPMCentroCostoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiC).addComponent(this.JRBNoC)).addContainerGap(-1, 32767)));
        this.JCBTipoImp.setFont(new Font("Arial", 1, 13));
        this.JCBTipoImp.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPBase.setFont(new Font("Arial", 1, 13));
        this.JSPPBase.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPBase.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPBaseR.setFont(new Font("Arial", 1, 13));
        this.JSPPBaseR.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPBaseR.setBorder(BorderFactory.createTitledBorder((Border) null, "% Base Real", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoAlterno.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Alterno", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoAlterno.setHorizontalAlignment(4);
        this.JTFFCodigoAlterno.setFont(new Font("Arial", 1, 13));
        this.JTFFCodigoAlterno.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConfigurarCuentasPuc.11
            public void focusLost(FocusEvent evt) {
                JIFConfigurarCuentasPuc.this.JTFFCodigoAlternoFocusLost(evt);
            }
        });
        this.JTFFCodigoPadre.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Padre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoPadre.setHorizontalAlignment(4);
        this.JTFFCodigoPadre.setFont(new Font("Arial", 1, 13));
        this.JTFFCodigoPadre.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConfigurarCuentasPuc.12
            public void focusLost(FocusEvent evt) {
                JIFConfigurarCuentasPuc.this.JTFFCodigoPadreFocusLost(evt);
            }
        });
        this.JCHEsUNivel.setFont(new Font("Arial", 1, 12));
        this.JCHEsUNivel.setText("Es Ultimo Nivel?");
        this.JCHEsUNivel.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.13
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JCHEsUNivelActionPerformed(evt);
            }
        });
        this.JCHAplicaNiif.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaNiif.setText("Aplica Niif?");
        this.JCHAplicaNiif.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.14
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JCHAplicaNiifActionPerformed(evt);
            }
        });
        this.JTFFCodigoNiif.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Niif", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoNiif.setHorizontalAlignment(4);
        this.JTFFCodigoNiif.setFont(new Font("Arial", 1, 13));
        this.JTFFCodigoNiif.addFocusListener(new FocusAdapter() { // from class: Contabilidad.JIFConfigurarCuentasPuc.15
            public void focusLost(FocusEvent evt) {
                JIFConfigurarCuentasPuc.this.JTFFCodigoNiifFocusLost(evt);
            }
        });
        this.JCHCXP.setFont(new Font("Arial", 1, 12));
        this.JCHCXP.setText("Aplica CxP?");
        this.JCHCXP.setToolTipText("Identifica la cuenta por pagar para la relacion con la radicacion");
        this.JCHCXP.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.16
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JCHCXPActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPTipo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPMTercero, -1, -1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFIdCuenta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCodigoAlterno)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFCodigoPadre, -2, 142, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEsUNivel).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNCuentasPuc).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBNivel, -2, 167, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPMCentroCosto, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoImp, -2, 167, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPPBase, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPPBaseR, -2, 95, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFCodigoNiif, -2, 142, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHAplicaNiif).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHCXP))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFIdCuenta, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCuentasPuc, -2, 50, -2).addComponent(this.JCBNivel, -2, 50, -2).addComponent(this.JTFFCodigoAlterno, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPPBase, -2, 50, -2).addComponent(this.JSPPBaseR, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPMCentroCosto, -2, 50, -2).addComponent(this.JCBTipoImp, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPTipo, GroupLayout.Alignment.TRAILING, -2, 0, 32767).addComponent(this.JPMTercero, GroupLayout.Alignment.TRAILING, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCodigoPadre, -2, 50, -2).addComponent(this.JCHEsUNivel).addComponent(this.JCHAplicaNiif).addComponent(this.JTFFCodigoNiif, -2, 50, -2).addComponent(this.JCHCXP)).addContainerGap(-1, 32767)));
        this.JPI_Datos1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA INFORMACION EXÓGENA Y MEDIOS DISTRITALES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.f3JCHEsDeducin1.setFont(new Font("Arial", 1, 12));
        this.f3JCHEsDeducin1.setText("No es Deducible");
        this.f3JCHEsDeducin1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.17
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.m5JCHEsDeducin1ActionPerformed(evt);
            }
        });
        this.f2JCHEsDeducin.setFont(new Font("Arial", 1, 12));
        this.f2JCHEsDeducin.setText("Es Deducción");
        this.f2JCHEsDeducin.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.18
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.m4JCHEsDeducinActionPerformed(evt);
            }
        });
        this.JCHEsIbc.setFont(new Font("Arial", 1, 12));
        this.JCHEsIbc.setText("Es IBC?");
        this.JCHEsIbc.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.19
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JCHEsIbcActionPerformed(evt);
            }
        });
        this.JCBConceptoDian.setFont(new Font("Arial", 1, 13));
        this.JCBConceptoDian.setBorder(BorderFactory.createTitledBorder((Border) null, "Conceptos Dian", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTope.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Minimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTope.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTope.setHorizontalAlignment(4);
        this.JTFFTope.setFont(new Font("Arial", 1, 13));
        this.JCBConceptoID.setFont(new Font("Arial", 1, 13));
        this.JCBConceptoID.setBorder(BorderFactory.createTitledBorder((Border) null, "Conceptos Impuestos Distritales", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBConceptoPago.setFont(new Font("Arial", 1, 13));
        this.JCBConceptoPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Conceptos de Pago", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_Datos1Layout = new GroupLayout(this.JPI_Datos1);
        this.JPI_Datos1.setLayout(JPI_Datos1Layout);
        JPI_Datos1Layout.setHorizontalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addComponent(this.JCBConceptoDian, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JTFFTope, -2, 153, -2)).addGroup(JPI_Datos1Layout.createSequentialGroup().addComponent(this.f3JCHEsDeducin1).addGap(41, 41, 41).addComponent(this.f2JCHEsDeducin).addGap(31, 31, 31).addComponent(this.JCHEsIbc).addGap(0, 0, 32767)).addGroup(JPI_Datos1Layout.createSequentialGroup().addComponent(this.JCBConceptoID, -2, 362, -2).addGap(18, 18, 18).addComponent(this.JCBConceptoPago, 0, -1, 32767))).addContainerGap()));
        JPI_Datos1Layout.setVerticalGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createSequentialGroup().addContainerGap().addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.f3JCHEsDeducin1).addComponent(this.f2JCHEsDeducin)).addComponent(this.JCHEsIbc)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConceptoDian, -2, 50, -2).addComponent(this.JTFFTope, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPI_Datos1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBConceptoPago, -2, 50, -2).addComponent(this.JCBConceptoID, -2, 50, -2)).addContainerGap()));
        GroupLayout JPI_DatosCLayout = new GroupLayout(this.JPI_DatosC);
        this.JPI_DatosC.setLayout(JPI_DatosCLayout);
        JPI_DatosCLayout.setHorizontalGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCLayout.createSequentialGroup().addGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_TipoMov, -2, -1, -2).addComponent(this.JPIDatos, -2, -1, -2)).addGap(0, 0, 32767)).addComponent(this.JPI_Datos1, -1, -1, 32767)).addContainerGap()));
        JPI_DatosCLayout.setVerticalGroup(JPI_DatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_TipoMov, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatos, -2, 202, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, 32767).addComponent(this.JPI_Datos1, -2, -1, -2).addContainerGap()));
        this.JTP_Datos.addTab("DATOS CUENTA", this.JPI_DatosC);
        this.JCBConceptoDianF.setFont(new Font("Arial", 1, 13));
        this.JCBConceptoDianF.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto Dian", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPDian.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleDian.setFont(new Font("Arial", 1, 12));
        this.JTDetalleDian.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleDian.setSelectionBackground(Color.white);
        this.JTDetalleDian.setSelectionForeground(Color.red);
        this.JTDetalleDian.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConfigurarCuentasPuc.20
            public void mouseClicked(MouseEvent evt) {
                JIFConfigurarCuentasPuc.this.JTDetalleDianMouseClicked(evt);
            }
        });
        this.JSPDian.setViewportView(this.JTDetalleDian);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConfigurarCuentasPuc.21
            public void actionPerformed(ActionEvent evt) {
                JIFConfigurarCuentasPuc.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDianLayout = new GroupLayout(this.JPIDian);
        this.JPIDian.setLayout(JPIDianLayout);
        JPIDianLayout.setHorizontalGroup(JPIDianLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDianLayout.createSequentialGroup().addContainerGap().addGroup(JPIDianLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDian, -1, 825, 32767).addGroup(JPIDianLayout.createSequentialGroup().addComponent(this.JCBConceptoDianF, -2, 733, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(0, 0, 32767))).addContainerGap()));
        JPIDianLayout.setVerticalGroup(JPIDianLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDianLayout.createSequentialGroup().addContainerGap().addGroup(JPIDianLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBConceptoDianF, -2, 50, -2).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDian).addContainerGap()));
        this.JTP_Datos.addTab("FORMATOS DIAN", this.JPIDian);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsIbcActionPerformed(ActionEvent evt) {
        if (this.JCHEsIbc.isSelected()) {
            this.xesibc = 1;
        } else {
            this.xesibc = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JCHEsDeduciónActionPerformed, reason: contains not printable characters */
    public void m4JCHEsDeducinActionPerformed(ActionEvent evt) {
        if (this.f2JCHEsDeducin.isSelected()) {
            this.xesdediccion = 1;
        } else {
            this.xesdediccion = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JCHEsDedución1ActionPerformed, reason: contains not printable characters */
    public void m5JCHEsDeducin1ActionPerformed(ActionEvent evt) {
        if (this.f3JCHEsDeducin1.isSelected()) {
            this.xesdedicciond = 1;
        } else {
            this.xesdedicciond = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoNiifFocusLost(FocusEvent evt) {
        if (!this.JTFFCodigoNiif.getText().isEmpty()) {
            this.xmodoC = true;
            mBuscarCuentaNiif(this.JTFFCodigoNiif.getText(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaNiifActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaNiif.isSelected()) {
            this.xaplicaniif = 1;
        } else {
            this.xaplicaniif = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsUNivelActionPerformed(ActionEvent evt) {
        if (this.JCHEsUNivel.isSelected()) {
            this.xesunivel = 1;
        } else {
            this.xesunivel = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoPadreFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoAlternoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoCActionPerformed(ActionEvent evt) {
        this.xcentrocosto = "000";
        this.xcentrocosto = "000";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiCActionPerformed(ActionEvent evt) {
        this.xcentrocosto = "001";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xmtercero = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xmtercero = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDebitoActionPerformed(ActionEvent evt) {
        this.xtipoc = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCreditoActionPerformed(ActionEvent evt) {
        this.xtipoc = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIdCuentaFocusLost(FocusEvent evt) {
        if (!this.JTFFIdCuenta.getText().isEmpty()) {
            this.xmodo = true;
            mBuscarCuenta(this.JTFFIdCuenta.getText());
            this.xmodoC = true;
            mBuscarCuentaNiif(this.JTFFIdCuenta.getText(), 1);
            mCargarDatosTablaDian(this.JTFFIdCuenta.getText());
            mRecorteDigitosCuenta();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Tipo_NiifActionPerformed(ActionEvent evt) {
        mLLenarCbo_Nivel();
        this.JTP_Datos.setEnabledAt(1, false);
        this.JCHAplicaNiif.setVisible(false);
        this.JTFFCodigoNiif.setVisible(false);
        this.JCHCXP.setVisible(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_Tipo_NormalActionPerformed(ActionEvent evt) {
        mLLenarCbo_Nivel();
        this.JTP_Datos.setEnabledAt(1, true);
        this.JCHAplicaNiif.setVisible(true);
        this.JTFFCodigoNiif.setVisible(true);
        this.JCHCXP.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleDianMouseClicked(MouseEvent evt) {
        if (this.JTDetalleDian.getSelectedRow() != -1) {
            this.JCBConceptoDianF.setSelectedItem(this.xModelo.getValueAt(this.JTDetalleDian.getSelectedRow(), 0).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalleDian.getSelectedRow(), 1).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            this.xgrabarDian = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCXPActionPerformed(ActionEvent evt) {
        if (this.JCHCXP.isSelected()) {
            this.xcxp = 1;
        } else {
            this.xcxp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIdCuentaActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        if (this.JTP_Datos.getSelectedIndex() == 0) {
            this.JCBTipoImp.removeAllItems();
            this.xidtipoimpuesto = this.xct.llenarCombo("SELECT Id, Nbre FROM cc_tipo_impuesto ORDER BY Nbre ASC", this.xidtipoimpuesto, this.JCBTipoImp);
            this.JCBTipoImp.setSelectedIndex(-1);
            this.JCBConceptoDian.removeAllItems();
            this.xidconceptosdian = this.xct.llenarCombo("SELECT Id , concat(Id, ' ' ,Nbre) as Nbre FROM cc_tipo_concepto_dian WHERE (Estado =1) ORDER BY Id ASC", this.xidconceptosdian, this.JCBConceptoDian);
            this.JCBConceptoDian.setSelectedItem("0000 N/A");
            this.JCBConceptoID.removeAllItems();
            this.xidconceptosid = this.xct.llenarCombo("SELECT Id , concat(Id, ' ' ,Nbre) as Nbre FROM cc_tipo_concepto_dian WHERE (Estado =1 and EsDistrital=1) ORDER BY Id ASC", this.xidconceptosid, this.JCBConceptoID);
            this.JCBConceptoID.setSelectedItem("N/A");
            mLLenarCbo_Nivel();
            this.JCBConceptoPago.removeAllItems();
            this.xidconceptoPago = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `cc_tipo_concepto_pago` WHERE (`Estado` =1)", this.xidconceptoPago, this.JCBConceptoPago);
            this.JCBConceptoPago.setSelectedItem(0);
            this.xct.cerrarConexionBd();
            this.JTFFIdCuenta.setText("");
            this.JTFNCuentasPuc.setText("");
            this.JTFFCodigoAlterno.setText("");
            this.JCBNivel.setSelectedIndex(-1);
            this.JRBCredito.setSelected(true);
            this.xtipoc = 1;
            this.JRBNo.setSelected(true);
            this.xmtercero = 0;
            this.JRBNoC.setSelected(true);
            this.xcentrocosto = "000";
            this.xcentrocosto = "000";
            this.JCHEsUNivel.setSelected(false);
            this.xesunivel = 0;
            this.xaplicaniif = 0;
            this.xguardar = 0;
            this.JCHAplicaNiif.setSelected(false);
            this.JTFFCodigoPadre.setText("");
            this.JTFFCodigoNiif.setText("");
            this.JTFFTope.setValue(0);
            this.JSPPBase.setValue(0);
            this.JSPPBaseR.setValue(0);
            this.JCBConceptoDianF.removeAllItems();
            this.xidconceptosdianf = this.xct.llenarCombo("SELECT Id , concat(Id, ' ' ,Nbre) as Nbre FROM cc_tipo_concepto_dian WHERE (Estado =1) ORDER BY Id ASC", this.xidconceptosdianf, this.JCBConceptoDianF);
            this.JCBConceptoDianF.setSelectedIndex(-1);
            this.JCHEstado.setSelected(true);
            this.xestado = 1;
            this.JCHCXP.setSelected(false);
            this.xcxp = 0;
            this.xgrabarDian = 0;
        } else {
            this.JCBConceptoDianF.removeAllItems();
            this.xidconceptosdianf = this.xct.llenarCombo("SELECT Id , concat(Id, ' ' ,Nbre) as Nbre FROM cc_tipo_concepto_dian WHERE (Estado =1) ORDER BY Id ASC", this.xidconceptosdianf, this.JCBConceptoDianF);
            this.JCBConceptoDianF.setSelectedIndex(-1);
            this.JCHEstado.setSelected(true);
            this.xestado = 1;
            this.xgrabarDian = 0;
        }
        mCargarDatosTablaDian(this.JTFFIdCuenta.getText());
    }

    private void mLLenarCbo_Nivel() {
        this.JCBNivel.removeAllItems();
        if (this.JRB_Tipo_Normal.isSelected()) {
            this.xidnivelpuc = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM  `cc_puc_nivel` ORDER BY `Id` ASC", this.xidnivelpuc, this.JCBNivel);
        } else {
            this.xidnivelpuc = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM  `cc_puc_nivel` ORDER BY `Id` ASC", this.xidnivelpuc, this.JCBNivel);
        }
        this.JCBNivel.setSelectedItem(-1);
    }

    public void mGrabar() {
        String sql;
        String sql2;
        if (this.JTP_Datos.getSelectedIndex() == 0) {
            if (!this.JTFFIdCuenta.getText().isEmpty()) {
                if (!this.JTFNCuentasPuc.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (this.xmodo) {
                            if (this.JRB_Tipo_Normal.isSelected()) {
                                sql2 = "update cc_puc set Nbre='" + this.JTFNCuentasPuc.getText() + "', Tipo='" + this.xtipoc + "',Id_Tercero='" + this.xmtercero + "', Nivel='" + this.JTFFIdCuenta.getText().length() + "', Id_TipoImpuesto='" + this.xidtipoimpuesto[this.JCBTipoImp.getSelectedIndex()] + "', CCosto='" + this.xcentrocosto + "', EsDeduccion='" + this.xesdediccion + "', PBase='" + this.JSPPBase.getValue() + "', PBaseR='" + this.JSPPBaseR.getValue() + "', Doc='" + this.JTFFCodigoAlterno.getText() + "', EsDeduccionDian='" + this.xesdedicciond + "', EsIbc='" + this.xesibc + "', Id_TipoConceptoDian='" + this.xidconceptosdian[this.JCBConceptoDian.getSelectedIndex()] + "', Id_Nivel='" + this.xidnivelpuc[this.JCBNivel.getSelectedIndex()] + "', Id_TipoConceptoID='" + this.xidconceptosid[this.JCBConceptoID.getSelectedIndex()] + "', TopeMinimoDian='" + this.JTFFTope.getValue() + "', Id_ConceptoP='" + this.xidconceptoPago[this.JCBConceptoPago.getSelectedIndex()] + "', Id_Padre='" + this.JTFFCodigoPadre.getText() + "', UNivel='" + this.xesunivel + "', AplicaNiif='" + this.xaplicaniif + "', CxP='" + this.xcxp + "' where Id='" + this.JTFFIdCuenta.getText() + "'";
                                mGrabar_Puc_Niif();
                            } else {
                                sql2 = "update cc_puc_niif set Nbre='" + this.JTFNCuentasPuc.getText() + "', Tipo='" + this.xtipoc + "',Id_Tercero='" + this.xmtercero + "', Nivel='" + this.JTFFIdCuenta.getText().length() + "', Id_TipoImpuesto='" + this.xidtipoimpuesto[this.JCBTipoImp.getSelectedIndex()] + "', CCosto='" + this.xcentrocosto + "', EsDeduccion='" + this.xesdediccion + "', Doc='" + this.JTFFCodigoAlterno.getText() + "', PBase='" + this.JSPPBase.getValue() + "', EsDeduccionDian='" + this.xesdedicciond + "', EsIbc='" + this.xesibc + "', Id_TipoConceptoDian='" + this.xidconceptosdian[this.JCBConceptoDian.getSelectedIndex()] + "', Id_Nivel='" + this.xidnivelpuc[this.JCBNivel.getSelectedIndex()] + "', Id_TipoConceptoID='" + this.xidconceptosid[this.JCBConceptoID.getSelectedIndex()] + "', TopeMinimoDian='" + this.JTFFTope.getValue() + "', Id_ConceptoP='" + this.xidconceptoPago[this.JCBConceptoPago.getSelectedIndex()] + "', Id_Padre='" + this.JTFFCodigoPadre.getText() + "', UNivel='" + this.xesunivel + "' where Id='" + this.JTFFIdCuenta.getText() + "'";
                            }
                        } else if (this.JRB_Tipo_Normal.isSelected()) {
                            sql2 = "Insert into cc_puc(Id, Nbre, Tipo, Id_Tercero, Nivel, CCosto, Doc, EsDeduccion, Id_TipoImpuesto, Id_TipoConceptoID, PBase, Id_TipoConceptoDian, Id_Nivel, EsDeduccionDian, EsIbc, TopeMinimoDian,Id_ConceptoP,Id_Padre,UNivel,AplicaNiif,CxP)  values('" + this.JTFFIdCuenta.getText() + "','" + this.JTFNCuentasPuc.getText() + "','" + this.xtipoc + "','" + this.xmtercero + "','" + this.JTFFIdCuenta.getText().length() + "','" + this.xcentrocosto + "','" + this.JTFFCodigoAlterno.getText() + "','" + this.xesdediccion + "','" + this.xidtipoimpuesto[this.JCBTipoImp.getSelectedIndex()] + "','" + this.xidconceptosid[this.JCBConceptoID.getSelectedIndex()] + "','" + this.JSPPBase.getValue() + "','" + this.xidconceptosdian[this.JCBConceptoDian.getSelectedIndex()] + "','" + this.xidnivelpuc[this.JCBNivel.getSelectedIndex()] + "','" + this.xesdedicciond + "','" + this.xesibc + "','" + this.JTFFTope.getValue() + "','" + this.xidconceptoPago[this.JCBConceptoPago.getSelectedIndex()] + "','" + this.JTFFCodigoPadre.getText() + "','" + this.xesunivel + "','" + this.xaplicaniif + "','" + this.xcxp + "')";
                            mGrabar_Puc_Niif();
                        } else {
                            sql2 = "Insert into cc_puc_niif(Id, Nbre, Tipo, Id_Tercero, Nivel, CCosto, Doc, EsDeduccion, Id_TipoImpuesto, Id_TipoConceptoID, PBase, Id_TipoConceptoDian, Id_Nivel, EsDeduccionDian, EsIbc, TopeMinimoDian,Id_ConceptoP,Id_Padre,UNivel)  values('" + this.JTFFIdCuenta.getText() + "','" + this.JTFNCuentasPuc.getText() + "','" + this.xtipoc + "','" + this.xmtercero + "','" + this.JTFFIdCuenta.getText().length() + "','" + this.xcentrocosto + "','" + this.JTFFCodigoAlterno.getText() + "','" + this.xesdediccion + "','" + this.xidtipoimpuesto[this.JCBTipoImp.getSelectedIndex()] + "','" + this.xidconceptosid[this.JCBConceptoID.getSelectedIndex()] + "','" + this.JSPPBase.getValue() + "','" + this.xidconceptosdian[this.JCBConceptoDian.getSelectedIndex()] + "','" + this.xidnivelpuc[this.JCBNivel.getSelectedIndex()] + "','" + this.xesdedicciond + "','" + this.xesibc + "','" + this.JTFFTope.getValue() + "','" + this.xidconceptoPago[this.JCBConceptoPago.getSelectedIndex()] + "','" + this.JTFFCodigoPadre.getText() + "','" + this.xesunivel + "')";
                        }
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        mActualiar_Cuentas();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "N° cuenta no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNCuentasPuc.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "N° cuenta no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFIdCuenta.requestFocus();
            return;
        }
        if (this.JTP_Datos.getSelectedIndex() == 1) {
            if (!mVerificaUltNivel()) {
                if (this.JCBConceptoDianF.getSelectedIndex() != -1) {
                    int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n2 == 0) {
                        if (this.xgrabarDian == 0) {
                            sql = "INSERT IGNORE INTO `cc_puc_formato_concepto_dian`(`Id_Puc`,`Id_formato_concepto`,`Estado`) VALUES ('" + this.JTFFIdCuenta.getText() + "','" + this.xidconceptosdianf[this.JCBConceptoDianF.getSelectedIndex()] + "','" + this.xestado + "');";
                        } else {
                            sql = "UPDATE `cc_puc_formato_concepto_dian` SET `Estado` = '" + this.xestado + "' WHERE `Id_Puc` = '" + this.JTFFIdCuenta.getText() + "' AND `Id_formato_concepto` = '" + this.xidconceptosdianf[this.JCBConceptoDianF.getSelectedIndex()] + "';";
                        }
                        this.xct.ejecutarSQL(sql);
                        this.xct.cerrarConexionBd();
                        mNuevo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe Seleccionar un concepto dian", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTP_Datos.setSelectedIndex(1);
                this.JCBConceptoDianF.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La Cuenta " + this.xCuentaEquivocado + " NO existe o No es de último nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTP_Datos.setSelectedIndex(0);
            this.JTFFIdCuenta.requestFocus();
        }
    }

    private void mGrabar_Puc_Niif() {
        if (this.JRB_Tipo_Normal.isSelected() && this.JCBNivel.getSelectedIndex() != -1 && !this.JTFFCodigoNiif.getText().isEmpty() && this.xidnivelpuc[this.JCBNivel.getSelectedIndex()].equals("5")) {
            if (!VerificarExistencia(this.JTFFIdCuenta.getText())) {
                this.xsql = "insert ignore into cc_pucg_niif (`Id_Puc_G` , `Id_Puc_Niif` , `UsuarioS`  , `Id_UsuarioS`) values('" + this.JTFFIdCuenta.getText() + "','" + this.JTFFCodigoNiif.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
            } else {
                this.xsql = "UPDATE `cc_pucg_niif` SET `Id_Puc_Niif` = '" + this.JTFFCodigoNiif.getText() + "',`UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "',`Id_UsuarioS` = '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' WHERE `Id_Puc_G` = '" + this.JTFFIdCuenta.getText() + "'";
            }
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private boolean VerificarExistencia(String xcodigo) {
        boolean existe = false;
        try {
            String sql = "SELECT `Id_Puc_Niif` FROM `cc_pucg_niif` WHERE (`Id_Puc_G` ='" + xcodigo + "');";
            ResultSet xrs = this.xct.traerRs(sql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        existe = true;
                    } else {
                        existe = false;
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } finally {
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFConfigurarCuentasPuc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existe;
    }

    private boolean mVerificaUltNivel() {
        boolean xOk = false;
        String sql = "SELECT `Id`, UNivel FROM `cc_puc` WHERE Id='" + this.JTFFIdCuenta.getText() + "'";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                if (xrs.getInt("UNivel") == 0) {
                    xOk = true;
                    this.xCuentaEquivocado = xrs.getString("Id");
                }
            } else {
                xOk = true;
                this.xCuentaEquivocado = this.JTFFIdCuenta.getText();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConfigurarCuentasPuc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xOk;
    }

    private void mBuscarCuenta(String xcodigo) {
        String sql;
        if (this.xmodo) {
            try {
                if (this.JRB_Tipo_Normal.isSelected()) {
                    sql = "SELECT cc_puc.Nbre, Tipo , Id_Tercero , Nivel, CCosto, EsDeduccion, cc_tipo_impuesto.Nbre, cc_puc.PBase, concat(cc_tipo_concepto_dian.Id,' ', cc_tipo_concepto_dian.Nbre) as Nbre, cc_puc.EsDeduccionDian, cc_puc.TopeMinimoDian, cc_puc.PBaseR, cc_puc.EsIbc, `cc_puc_nivel`.`Nbre` ,cc_tipo_concepto_pago.Nbre AS ConcPago, concat(cc_tipo_concepto_dian_1.`Id`, ' ' ,cc_tipo_concepto_dian_1.`Nbre`) AS ConcepID, Doc, cc_puc.Id_Padre, cc_puc.UNivel, cc_puc.AplicaNiif, cc_puc.CxP  FROM cc_puc INNER JOIN `cc_puc_nivel` ON (`cc_puc`.`Id_Nivel` = `cc_puc_nivel`.`Id`)INNER JOIN cc_tipo_impuesto  ON (cc_puc.Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN cc_tipo_concepto_dian  ON (cc_puc.Id_TipoConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN `cc_tipo_concepto_pago`  ON (`cc_puc`.`Id_ConceptoP` = `cc_tipo_concepto_pago`.`Id`) INNER JOIN `cc_tipo_concepto_dian` AS `cc_tipo_concepto_dian_1` ON (`cc_puc`.`Id_TipoConceptoID` = `cc_tipo_concepto_dian_1`.`Id`)  WHERE (cc_puc.Id ='" + xcodigo + "') ";
                } else {
                    sql = "SELECT cc_puc_niif.Nbre, Tipo , Id_Tercero , Nivel, CCosto, EsDeduccion, cc_tipo_impuesto.Nbre, cc_puc_niif.PBase, concat(cc_tipo_concepto_dian.Id,' ', cc_tipo_concepto_dian.Nbre) as Nbre, cc_puc_niif.EsDeduccionDian, cc_puc_niif.TopeMinimoDian, cc_puc_niif.PBaseR, cc_puc_niif.EsIbc, `cc_puc_nivel`.`Nbre` ,cc_tipo_concepto_pago.Nbre AS ConcPago, concat(cc_tipo_concepto_dian_1.`Id`, ' ' ,cc_tipo_concepto_dian_1.`Nbre`) AS ConcepID, Doc, cc_puc_niif.Id_Padre, cc_puc_niif.UNivel, 0, 0  FROM cc_puc_niif INNER JOIN `cc_puc_nivel` ON (`cc_puc_niif`.`Id_Nivel` = `cc_puc_nivel`.`Id`)INNER JOIN cc_tipo_impuesto  ON (cc_puc_niif.Id_TipoImpuesto = cc_tipo_impuesto.Id) INNER JOIN cc_tipo_concepto_dian  ON (cc_puc_niif.Id_TipoConceptoDian = cc_tipo_concepto_dian.Id) INNER JOIN `cc_tipo_concepto_pago`  ON (`cc_puc_niif`.`Id_ConceptoP` = `cc_tipo_concepto_pago`.`Id`) INNER JOIN `cc_tipo_concepto_dian` AS `cc_tipo_concepto_dian_1` ON (`cc_puc_niif`.`Id_TipoConceptoID` = `cc_tipo_concepto_dian_1`.`Id`)  WHERE (cc_puc_niif.Id ='" + xcodigo + "') ";
                }
                ResultSet xrs = this.xct.traerRs(sql);
                if (xrs.next()) {
                    this.JTFNCuentasPuc.setText(xrs.getString(1));
                    if (xrs.getInt(2) == 1) {
                        this.JRBCredito.setSelected(true);
                        this.xtipoc = 1;
                    } else {
                        this.JRBDebito.setSelected(true);
                        this.xtipoc = 0;
                    }
                    if (xrs.getInt(3) == 1) {
                        this.JRBSi.setSelected(true);
                        this.xmtercero = 1;
                    } else {
                        this.JRBNo.setSelected(true);
                        this.xmtercero = 0;
                    }
                    if (xrs.getString(5).equals("001")) {
                        this.JRBSiC.setSelected(true);
                        this.xcentrocosto = "001";
                    } else {
                        this.JRBNoC.setSelected(true);
                        this.xcentrocosto = "001";
                    }
                    if (xrs.getInt(6) == 1) {
                        this.f2JCHEsDeducin.setSelected(true);
                        this.xesdediccion = 1;
                    } else {
                        this.f2JCHEsDeducin.setSelected(false);
                        this.xesdediccion = 0;
                    }
                    this.JCBTipoImp.setSelectedItem(xrs.getString(7));
                    this.JSPPBase.setValue(Double.valueOf(xrs.getDouble(8)));
                    this.JSPPBaseR.setValue(Double.valueOf(xrs.getDouble(12)));
                    this.JCBConceptoDian.setSelectedItem(xrs.getString(9));
                    if (xrs.getInt(10) == 1) {
                        this.f3JCHEsDeducin1.setSelected(true);
                        this.xesdedicciond = 1;
                    } else {
                        this.f3JCHEsDeducin1.setSelected(false);
                        this.xesdedicciond = 0;
                    }
                    if (xrs.getInt(13) == 1) {
                        this.JCHEsIbc.setSelected(true);
                        this.xesibc = 1;
                    } else {
                        this.JCHEsIbc.setSelected(false);
                        this.xesibc = 0;
                    }
                    this.JCBNivel.setSelectedItem(xrs.getString(14));
                    this.JTFFTope.setValue(Double.valueOf(xrs.getDouble(11)));
                    this.xmodo = true;
                    this.JCBConceptoPago.setSelectedItem(xrs.getString("ConcPago"));
                    this.JCBConceptoID.setSelectedItem(xrs.getString("ConcepID"));
                    this.JTFFCodigoPadre.setText(xrs.getString("Id_Padre"));
                    this.JTFFCodigoAlterno.setText(xrs.getString("Doc"));
                    if (xrs.getInt(19) == 1) {
                        this.JCHEsUNivel.setSelected(true);
                        this.xesunivel = 1;
                    } else {
                        this.JCHEsUNivel.setSelected(false);
                        this.xesunivel = 0;
                    }
                    if (xrs.getInt(20) == 1) {
                        this.JCHAplicaNiif.setSelected(true);
                        this.xaplicaniif = 1;
                    } else {
                        this.JCHAplicaNiif.setSelected(false);
                        this.xaplicaniif = 0;
                    }
                    if (xrs.getInt(21) == 1) {
                        this.JCHCXP.setSelected(true);
                        this.xcxp = 1;
                    } else {
                        this.JCHCXP.setSelected(false);
                        this.xcxp = 0;
                    }
                } else {
                    this.xmodo = false;
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFConfigurarCuentasPuc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x00e7: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r14 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('xrs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:32:0x00e7 */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x00ec: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r15 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:34:0x00ec */
    private void mBuscarCuentaNiif(String xcodigo, int xopc) {
        String sql;
        if (this.xmodoC) {
            try {
                if (xopc == 0) {
                    sql = "SELECT Id FROM `cc_puc_niif` WHERE Id LIKE '" + xcodigo + "%' AND UNivel='1'";
                } else {
                    sql = "SELECT `Id_Puc_Niif` FROM `cc_pucg_niif` WHERE (`Id_Puc_G` ='" + xcodigo + "');";
                }
                try {
                    ResultSet xrs = this.xct.traerRs(sql);
                    Throwable th = null;
                    if (xrs.next()) {
                        if (xopc != 0) {
                            this.xguardar = 1;
                        }
                        this.JTFFCodigoNiif.setText(xrs.getString(1));
                    } else {
                        if (xopc == 0) {
                            JOptionPane.showInternalMessageDialog(this, "Esta cuenta no existe o no es de ultimo nivel", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        } else {
                            this.xguardar = 0;
                        }
                        this.JTFFCodigoNiif.setText("");
                        this.xmodoC = false;
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFConfigurarCuentasPuc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private void mActualiar_Cuentas() {
        if (this.JRB_Tipo_Normal.isSelected()) {
            this.xsql = "INSERT IGNORE INTO cc_puc_auxiliar(`Id`, `Nbre`, `Id_subcuenta`) SELECT  `Id` , `Nbre` ,  MID(`Id`,1,6) AS `Id_subcuenta` FROM `cc_puc` WHERE (`Id_Nivel` =5)";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "INSERT IGNORE INTO cc_puc_subcuenta(`Id`, `Nbre`, `Id_cuenta`) SELECT  `Id` , `Nbre` ,  MID(`Id`,1,4) AS `Id_cuenta` FROM `cc_puc` WHERE (`Id_Nivel` =4)";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "INSERT IGNORE INTO cc_puc_cuenta(`Id`, `Nbre`, `Id_Grupo`)SELECT  `Id` , `Nbre` ,  MID(`Id`,1,2) AS `Id_Grupo` FROM `cc_puc` WHERE (`Id_Nivel` =3)";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT `Id` , `Nbre` ,  MID(`Id`,1,1) AS `Id_clase` FROM `cc_puc` WHERE (`Id_Nivel` =2) ";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Nombre", "Estado"}) { // from class: Contabilidad.JIFConfigurarCuentasPuc.22
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleDian.setModel(this.xModelo);
        this.JTDetalleDian.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTDetalleDian.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    private void mCargarDatosTablaDian(String Cuenta) {
        try {
            this.xsql = "SELECT concat(cc_tipo_concepto_dian.Id,' ', cc_tipo_concepto_dian.Nbre) as Nbre, `cc_puc_formato_concepto_dian`.`Estado`\nFROM `cc_puc_formato_concepto_dian` INNER JOIN `cc_tipo_concepto_dian` ON (`cc_puc_formato_concepto_dian`.`Id_formato_concepto` = `cc_tipo_concepto_dian`.`Id`)\nWHERE (`cc_puc_formato_concepto_dian`.`Id_Puc` ='" + Cuenta + "') ORDER BY `cc_tipo_concepto_dian`.`Nbre` ASC;";
            mCrearTabla();
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xModelo.addRow(this.xDato);
                    this.xModelo.setValueAt(xrs.getString(1), x, 0);
                    this.xModelo.setValueAt(Boolean.valueOf(xrs.getBoolean(2)), x, 1);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConfigurarCuentasPuc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mRecorteDigitosCuenta() {
        if (!this.JTFFIdCuenta.getText().isEmpty()) {
            if (this.JTFFIdCuenta.getText().length() == 1) {
                this.JTFFCodigoPadre.setText("0");
                return;
            }
            if (this.JTFFIdCuenta.getText().length() == 2) {
                this.JTFFCodigoPadre.setText(this.JTFFIdCuenta.getText().trim().substring(0, this.JTFFIdCuenta.getText().length() - 1));
            } else if (this.JTFFIdCuenta.getText().length() >= 2 && this.JTFFIdCuenta.getText().length() % 2 == 0) {
                this.JTFFCodigoPadre.setText(this.JTFFIdCuenta.getText().trim().substring(0, this.JTFFIdCuenta.getText().length() - 2));
            }
        }
    }
}
