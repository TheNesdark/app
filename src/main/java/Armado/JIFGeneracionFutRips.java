package Armado;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Armado/JIFGeneracionFutRips.class */
public class JIFGeneracionFutRips extends JInternalFrame {
    private String[] xid_factura;
    private String[] xidempresa;
    private String xsql;
    private String sql;
    private File xfile;
    private Vector xvector;
    private String xnumerorips;
    private String xcodigo;
    private ButtonGroup JBGMFact;
    private JButton JBTGenerar;
    private JComboBox JCBEmpresa;
    private JComboBox JCBNFactura;
    private JDateChooser JDC_FechaF;
    private JDateChooser JDC_FechaI;
    private ButtonGroup JGBGeneracion;
    private JPanel JPIDatosT;
    private JPanel JPTipo1;
    private JPanel JPTipoGeneracion;
    private JRadioButton JRBCCobro;
    private JRadioButton JRBFactura;
    private JRadioButton JRBFechas;
    private JRadioButton JRBFurips;
    private JRadioButton JRBFurtran;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xtipo = 0;
    private int xIncluir_Dx = 0;
    private boolean xlleno = false;

    public JIFGeneracionFutRips() {
        initComponents();
        mTraerDatosRips();
        mNuevo();
    }

    private void initComponents() {
        this.JBGMFact = new ButtonGroup();
        this.JGBGeneracion = new ButtonGroup();
        this.JBTGenerar = new JButton();
        this.JPIDatosT = new JPanel();
        this.JDC_FechaI = new JDateChooser();
        this.JDC_FechaF = new JDateChooser();
        this.JCBEmpresa = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JPTipo1 = new JPanel();
        this.JRBFactura = new JRadioButton();
        this.JRBCCobro = new JRadioButton();
        this.JCBNFactura = new JComboBox();
        this.JRBFechas = new JRadioButton();
        this.JPTipoGeneracion = new JPanel();
        this.JRBFurips = new JRadioButton();
        this.JRBFurtran = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERACIÓN FURIPS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgeneracionrips");
        this.JBTGenerar.setFont(new Font("Arial", 1, 12));
        this.JBTGenerar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGenerar.setText("Generar");
        this.JBTGenerar.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionFutRips.1
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionFutRips.this.JBTGenerarActionPerformed(evt);
            }
        });
        this.JPIDatosT.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDC_FechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaI.setDateFormatString("dd/MM/yyyy");
        this.JDC_FechaI.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFGeneracionFutRips.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGeneracionFutRips.this.JDC_FechaIPropertyChange(evt);
            }
        });
        this.JDC_FechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDC_FechaF.setDateFormatString("dd/MM/yyyy");
        this.JDC_FechaF.setFont(new Font("Arial", 1, 12));
        this.JDC_FechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Armado.JIFGeneracionFutRips.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGeneracionFutRips.this.JDC_FechaFPropertyChange(evt);
            }
        });
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEmpresa.addItemListener(new ItemListener() { // from class: Armado.JIFGeneracionFutRips.4
            public void itemStateChanged(ItemEvent evt) {
                JIFGeneracionFutRips.this.JCBEmpresaItemStateChanged(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta (Directorio)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Armado.JIFGeneracionFutRips.5
            public void mouseClicked(MouseEvent evt) {
                JIFGeneracionFutRips.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JPTipo1.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtrar Por:", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGMFact.add(this.JRBFactura);
        this.JRBFactura.setFont(new Font("Arial", 1, 12));
        this.JRBFactura.setText("Factura");
        this.JRBFactura.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionFutRips.6
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionFutRips.this.JRBFacturaActionPerformed(evt);
            }
        });
        this.JBGMFact.add(this.JRBCCobro);
        this.JRBCCobro.setFont(new Font("Arial", 1, 12));
        this.JRBCCobro.setText("Cuenta de Cobro");
        this.JRBCCobro.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionFutRips.7
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionFutRips.this.JRBCCobroActionPerformed(evt);
            }
        });
        this.JCBNFactura.setFont(new Font("Arial", 1, 12));
        this.JCBNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNFactura.setEnabled(false);
        this.JBGMFact.add(this.JRBFechas);
        this.JRBFechas.setFont(new Font("Arial", 1, 12));
        this.JRBFechas.setSelected(true);
        this.JRBFechas.setText("Rango de Fecha");
        this.JRBFechas.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionFutRips.8
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionFutRips.this.JRBFechasActionPerformed(evt);
            }
        });
        GroupLayout JPTipo1Layout = new GroupLayout(this.JPTipo1);
        this.JPTipo1.setLayout(JPTipo1Layout);
        JPTipo1Layout.setHorizontalGroup(JPTipo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipo1Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPTipo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipo1Layout.createSequentialGroup().addComponent(this.JRBFactura).addGap(54, 54, 54).addComponent(this.JRBFechas)).addComponent(this.JRBCCobro)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBNFactura, -2, 244, -2)));
        JPTipo1Layout.setVerticalGroup(JPTipo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipo1Layout.createSequentialGroup().addGroup(JPTipo1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBNFactura, -2, -1, -2).addGroup(JPTipo1Layout.createSequentialGroup().addGroup(JPTipo1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFactura).addComponent(this.JRBFechas)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBCCobro))).addContainerGap(-1, 32767)));
        this.JPTipoGeneracion.setBorder(BorderFactory.createTitledBorder((Border) null, "GENERAR", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JGBGeneracion.add(this.JRBFurips);
        this.JRBFurips.setFont(new Font("Arial", 1, 12));
        this.JRBFurips.setSelected(true);
        this.JRBFurips.setText("Furips");
        this.JRBFurips.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionFutRips.9
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionFutRips.this.JRBFuripsActionPerformed(evt);
            }
        });
        this.JGBGeneracion.add(this.JRBFurtran);
        this.JRBFurtran.setFont(new Font("Arial", 1, 12));
        this.JRBFurtran.setText("Furtran");
        this.JRBFurtran.addActionListener(new ActionListener() { // from class: Armado.JIFGeneracionFutRips.10
            public void actionPerformed(ActionEvent evt) {
                JIFGeneracionFutRips.this.JRBFurtranActionPerformed(evt);
            }
        });
        GroupLayout JPTipoGeneracionLayout = new GroupLayout(this.JPTipoGeneracion);
        this.JPTipoGeneracion.setLayout(JPTipoGeneracionLayout);
        JPTipoGeneracionLayout.setHorizontalGroup(JPTipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoGeneracionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBFurips).addGap(18, 18, 18).addComponent(this.JRBFurtran).addContainerGap(-1, 32767)));
        JPTipoGeneracionLayout.setVerticalGroup(JPTipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoGeneracionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFurips).addComponent(this.JRBFurtran)));
        GroupLayout JPIDatosTLayout = new GroupLayout(this.JPIDatosT);
        this.JPIDatosT.setLayout(JPIDatosTLayout);
        JPIDatosTLayout.setHorizontalGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTLayout.createSequentialGroup().addComponent(this.JPTipo1, -2, -1, -2).addGap(0, 205, 32767)).addGroup(JPIDatosTLayout.createSequentialGroup().addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta).addGroup(JPIDatosTLayout.createSequentialGroup().addComponent(this.JPTipoGeneracion, -2, -1, -2).addGap(10, 10, 10).addComponent(this.JDC_FechaI, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDC_FechaF, -2, 121, -2).addGap(0, 0, 32767))).addContainerGap()).addComponent(this.JCBEmpresa, 0, -1, 32767))));
        JPIDatosTLayout.setVerticalGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosTLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDC_FechaI, -2, 50, -2).addComponent(this.JDC_FechaF, -2, 50, -2)).addComponent(this.JPTipoGeneracion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBEmpresa, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 7, 32767).addComponent(this.JPTipo1, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRuta, -2, 50, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosT, -1, -1, 32767).addComponent(this.JBTGenerar, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosT, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGenerar, -2, 51, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGenerarActionPerformed(ActionEvent evt) {
        mGenerarArchivos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarComboEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDC_FechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            mLLenarComboEmpresa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xfile.getAbsolutePath() + this.xmt.getBarra());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEmpresaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEmpresa.getSelectedIndex() != -1) {
            mLlenar_CboFactura();
        }
    }

    private void mLlenar_CboFactura() {
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            if (this.JRBFurips.isSelected()) {
                if (this.JRBCCobro.isSelected()) {
                    this.xsql = "SELECT f_factura_evento.`No_CuentaCobro`, f_factura_evento.No_CuentaCobro FROM `f_factura_evento` INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`) INNER JOIN  `ingreso`  \nON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  `g_municipio`  ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN  `a_eventoecat_paciente`  ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `a_eventoecat`  ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`) INNER JOIN  `a_accidentetransito`  \nON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`) INNER JOIN  `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) \nWHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_evento`.`Estado` =0 AND `f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_factura_evento`.`EstaArmada` =2) \nGROUP BY f_factura_evento.`No_CuentaCobro` ORDER BY f_factura_evento.`No_CuentaCobro` ASC ";
                } else if (this.JRBFactura.isSelected()) {
                    this.xsql = "SELECT IF( `f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento`)), IF( `f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento`)) AS `NFactura` \nFROM `f_factura_evento` INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`) INNER JOIN  `ingreso`  \nON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN  `g_municipio`  ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN  `a_eventoecat_paciente`  ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `a_eventoecat`  ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`) INNER JOIN  `a_accidentetransito`  \nON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`) INNER JOIN  `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) \nWHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_evento`.`Estado` =0 AND `f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_factura_evento`.`EstaArmada` =2) \nGROUP BY `f_factura_evento`.`No_FacturaEvento` ORDER BY `f_factura_evento`.`No_FacturaEvento` ";
                }
            } else if (this.JRBFurtran.isSelected()) {
                if (this.JRBCCobro.isSelected()) {
                    this.xsql = "SELECT f_factura_evento.`No_CuentaCobro`, f_factura_evento.No_CuentaCobro\nFROM `f_factura_evento` INNER JOIN `f_liquidacion` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)\nINNER JOIN `ingreso` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `d_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `d_ips`.`Id`) INNER JOIN `a_eventoecat_paciente` ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `a_eventoecat` ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`) INNER JOIN `a_furtran` ON (`a_furtran`.`IdEvento` = `a_eventoecat`.`Id`)\n LEFT JOIN `h_atencion` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nLEFT JOIN `h_remisiones` ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`) LEFT JOIN `h_egreso_atencion` ON (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nLEFT JOIN `a_furtran_persona` ON (`a_furtran_persona`.`IdPersonaEvento` = `a_eventoecat_paciente`.`Id`) AND (`a_furtran_persona`.`IdFurtran` = `a_furtran`.`Id`)\nLEFT JOIN `g_empresa` ON (`g_empresa`.`Id` = `a_furtran`.`IdMunicipioRec`) INNER JOIN `g_persona` ON (`g_persona`.`Id` = `a_eventoecat_paciente`.`Id_Persona`)\nINNER JOIN g_empresa empresar ON (`empresar`.`Id` = `a_furtran`.`IdTerceroRecibe`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_evento`.`Estado` =0 AND `f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_factura_evento`.`EstaArmada` =2)\nGROUP BY f_factura_evento.`No_CuentaCobro` ORDER BY f_factura_evento.`No_CuentaCobro` ASC ";
                } else if (this.JRBFactura.isSelected()) {
                    this.xsql = "SELECT IF( `f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento`)), IF( `f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento`)) AS `NFactura`\nFROM `f_factura_evento` INNER JOIN `f_liquidacion` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)\nINNER JOIN `ingreso` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `d_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `d_ips`.`Id`) INNER JOIN `a_eventoecat_paciente` ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `a_eventoecat` ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`) INNER JOIN `a_furtran` ON (`a_furtran`.`IdEvento` = `a_eventoecat`.`Id`)\n LEFT JOIN `h_atencion` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nLEFT JOIN `h_remisiones` ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`) LEFT JOIN `h_egreso_atencion` ON (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nLEFT JOIN `a_furtran_persona` ON (`a_furtran_persona`.`IdPersonaEvento` = `a_eventoecat_paciente`.`Id`) AND (`a_furtran_persona`.`IdFurtran` = `a_furtran`.`Id`)\nLEFT JOIN `g_empresa` ON (`g_empresa`.`Id` = `a_furtran`.`IdMunicipioRec`) INNER JOIN `g_persona` ON (`g_persona`.`Id` = `a_eventoecat_paciente`.`Id_Persona`)\nINNER JOIN g_empresa empresar ON (`empresar`.`Id` = `a_furtran`.`IdTerceroRecibe`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_evento`.`Estado` =0 AND `f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_factura_evento`.`EstaArmada` =2)\nGROUP BY `f_factura_evento`.`No_FacturaEvento` ORDER BY `f_factura_evento`.`No_FacturaEvento` ";
                }
            }
            this.JCBNFactura.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xid_factura = xct1.llenarCombo(this.xsql, this.xid_factura, this.JCBNFactura);
            this.JCBNFactura.setSelectedIndex(-1);
            xct1.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFacturaActionPerformed(ActionEvent evt) {
        this.JCBNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNFactura.setEnabled(true);
        mLlenar_CboFactura();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCCobroActionPerformed(ActionEvent evt) {
        this.JCBNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cuenta de Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNFactura.setEnabled(true);
        mLlenar_CboFactura();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFechasActionPerformed(ActionEvent evt) {
        this.JCBNFactura.setEnabled(false);
        this.JCBNFactura.setSelectedIndex(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFuripsActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFurtranActionPerformed(ActionEvent evt) {
        mNuevo();
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        this.JDC_FechaI.setDate(this.xmt.getFechaActual());
        this.JDC_FechaF.setDate(this.xmt.getFechaActual());
        mLLenarComboEmpresa();
        this.JDC_FechaI.requestFocus();
    }

    private void mLLenarComboEmpresa() {
        this.xlleno = false;
        if (this.JRBFurips.isSelected()) {
            this.xsql = "SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre` FROM `f_factura_evento` INNER JOIN  `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN  `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`) INNER JOIN  `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) INNER JOIN  `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) INNER JOIN  `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) INNER JOIN  `g_municipio`  ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) INNER JOIN  `a_eventoecat_paciente`  ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `a_eventoecat`  ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`) INNER JOIN  `a_accidentetransito`  ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`) INNER JOIN  `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_evento`.`Estado` =0 AND `f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD.format(this.JDC_FechaI.getDate()) + "' AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD.format(this.JDC_FechaF.getDate()) + "' AND `f_factura_evento`.`EstaArmada` =2) GROUP BY  f_empresacontxconvenio.`Id` order by f_empresacontxconvenio.`Nbre` ";
        } else if (this.JRBFurtran.isSelected()) {
            this.xsql = "SELECT f_empresacontxconvenio.`Id`, f_empresacontxconvenio.`Nbre`\nFROM `f_factura_evento` INNER JOIN `f_liquidacion` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) INNER JOIN `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)\nINNER JOIN `ingreso` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\nINNER JOIN `d_ips` ON (`f_empresacontxconvenio`.`Id_GIps` = `d_ips`.`Id`) INNER JOIN `a_eventoecat_paciente` ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `a_eventoecat` ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`) INNER JOIN `a_furtran` ON (`a_furtran`.`IdEvento` = `a_eventoecat`.`Id`)\n LEFT JOIN `h_atencion` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nLEFT JOIN `h_remisiones` ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`) LEFT JOIN `h_egreso_atencion` ON (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\nLEFT JOIN `a_furtran_persona` ON (`a_furtran_persona`.`IdPersonaEvento` = `a_eventoecat_paciente`.`Id`) AND (`a_furtran_persona`.`IdFurtran` = `a_furtran`.`Id`)\nLEFT JOIN `g_empresa` ON (`g_empresa`.`Id` = `a_furtran`.`IdMunicipioRec`) INNER JOIN `g_persona` ON (`g_persona`.`Id` = `a_eventoecat_paciente`.`Id_Persona`)\nINNER JOIN g_empresa empresar ON (`empresar`.`Id` = `a_furtran`.`IdTerceroRecibe`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_evento`.`Estado` =0 AND `f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD.format(this.JDC_FechaI.getDate()) + "'\nAND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD.format(this.JDC_FechaF.getDate()) + "' AND `f_factura_evento`.`EstaArmada` =2) GROUP BY  f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre`;";
        }
        this.JCBEmpresa.removeAllItems();
        this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresa);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mTraerDatosRips() {
        try {
            this.sql = "SELECT NoRemisionRips, CodigoOrganismo FROM g_ips";
            ResultSet xrs = this.xct.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                this.xnumerorips = xrs.getString(1);
                this.xcodigo = xrs.getString(2);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGeneracionFutRips.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGenerarArchivos() {
        this.xvector = new Vector();
        this.xsql = "";
        if (this.JCBEmpresa.getSelectedIndex() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de generar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (this.JRBFurips.isSelected()) {
                    mTraerDatosRips();
                    mCrearArchivo_FutRips1();
                    mCrearArchivo_FutRips2();
                } else if (this.JRBFurtran.isSelected()) {
                    mCrearArchivo_FurTran();
                }
                JOptionPane.showInternalMessageDialog(this, "Archivo(s) generados exitosamente!!!!", "CONFIRMACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBNFactura.requestFocus();
    }

    private void mCrearArchivo_FurTran() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "FURTRAN" + this.xcodigo + "" + this.xmt.formatoAMD_Unida1.format(this.xmt.getFechaActual()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            if (this.JRBFactura.isSelected() || this.JRBCCobro.isSelected()) {
                this.xsql = "SELECT CONCAT(''\n,',', ''\n,',',SUBSTRING(`d_ips`.`NEmpresa`,1,60)\n,',', `a_furtran`.`CodHabil`\n,',', SUBSTRING(`a_furtran`.`Apellido1`,1,20)\n,',', SUBSTRING(`a_furtran`.`Apellido2`,1,30)\n,',', SUBSTRING(`a_furtran`.`Nombre1`,1,20)\n,',', SUBSTRING(`a_furtran`.`Nombre2`,1,30)\n,',', IF(`a_furtran`.`NumDocumento`='','',`a_furtran`.`TDocumento`)\n,',', `a_furtran`.`NumDocumento`\n,',', `a_furtran`.`IdTipoServicio`\n,',', SUBSTRING(`a_furtran`.`CualServ`, 1,20)\n,',', `a_furtran`.`Placa`\n,',', SUBSTRING(`a_furtran`.`Direccion`,1,40)\n,',', `a_furtran`.`Telefono`\n,',', LPAD(`a_furtran`.`IdDepartamento`,2,'0')\n,',', MID(`a_furtran`.`IdMunicipio`,3,3)\n,',', `g_persona`.`Id_TipoIdentificacion`\n,',', `g_persona`.`NoDocumento`\n,',', SUBSTRING(`g_persona`.`Nombre1`,1,20)\n,',', SUBSTRING(`g_persona`.`Nombre2`,1,30)\n,',', SUBSTRING(`g_persona`.`Apellido1`,1,20)\n,',', SUBSTRING(`g_persona`.`Apellido2`,1,30)\n,',', 1\n,',', SUBSTRING(`a_furtran`.`DireccionRec`,1,40)\n,',', LPAD(`a_furtran`.`IdDepartamentoRec`,2,'0')\n,',', MID(`a_furtran`.`IdMunicipioRec`,3,3)\n,',', `a_furtran`.`Zona`\n,',', DATE_FORMAT(a_eventoecat.Fechaeventoecat, '%d/%m/%Y')\n,',', TIME_FORMAT(a_eventoecat.Horaeventoecat, '%H:%i')\n,',', empresar.CHabilitacion \n,',', MID(`empresar`.`Id_Municipio`,1,2)\n,',', MID(`empresar`.`Id_Municipio`,3,3)\n,',', `f_liquidacion`.`NFolios`) AS Linea\nFROM\n    `f_factura_evento`\n    INNER JOIN `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `f_cuentacobro` \n        ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)\n    INNER JOIN `ingreso` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `d_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `d_ips`.`Id`)\n    INNER JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `a_furtran` \n        ON (`a_furtran`.`IdEvento` = `a_eventoecat`.`Id`)\n    LEFT JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `h_remisiones` \n        ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `a_furtran_persona` \n        ON (`a_furtran_persona`.`IdPersonaEvento` = `a_eventoecat_paciente`.`Id`) AND (`a_furtran_persona`.`IdFurtran` = `a_furtran`.`Id`)\n    LEFT JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `a_furtran`.`IdMunicipioRec`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `a_eventoecat_paciente`.`Id_Persona`)\n        INNER JOIN g_empresa empresar        \n        ON (`empresar`.`Id` = `a_furtran`.`IdTerceroRecibe`)        \nWHERE ((IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)) ='" + this.JCBNFactura.getSelectedItem() + "' OR f_factura_evento.`No_CuentaCobro`='" + this.JCBNFactura.getSelectedItem() + "') \n    AND `f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'\n    AND `f_factura_evento`.`EstaArmada` =2)\nGROUP BY `ingreso`.`Id`\nORDER BY `f_factura_evento`.`No_FacturaEvento` ASC;";
            } else {
                this.xsql = "SELECT CONCAT(''\n,',', ''\n,',',SUBSTRING(`d_ips`.`NEmpresa`,1,60)\n,',', `a_furtran`.`CodHabil`\n,',', SUBSTRING(`a_furtran`.`Apellido1`,1,20)\n,',', SUBSTRING(`a_furtran`.`Apellido2`,1,30)\n,',', SUBSTRING(`a_furtran`.`Nombre1`,1,20)\n,',', SUBSTRING(`a_furtran`.`Nombre2`,1,30)\n,',', IF(`a_furtran`.`NumDocumento`='','',`a_furtran`.`TDocumento`)\n,',', `a_furtran`.`NumDocumento`\n,',', `a_furtran`.`IdTipoServicio`\n,',', SUBSTRING(`a_furtran`.`CualServ`, 1,20)\n,',', `a_furtran`.`Placa`\n,',', SUBSTRING(`a_furtran`.`Direccion`,1,40)\n,',', `a_furtran`.`Telefono`\n,',', LPAD(`a_furtran`.`IdDepartamento`,2,'0')\n,',', MID(`a_furtran`.`IdMunicipio`,3,3)\n,',', `g_persona`.`Id_TipoIdentificacion`\n,',', `g_persona`.`NoDocumento`\n,',', SUBSTRING(`g_persona`.`Nombre1`,1,20)\n,',', SUBSTRING(`g_persona`.`Nombre2`,1,30)\n,',', SUBSTRING(`g_persona`.`Apellido1`,1,20)\n,',', SUBSTRING(`g_persona`.`Apellido2`,1,30)\n,',', 1\n,',', SUBSTRING(`a_furtran`.`DireccionRec`,1,40)\n,',', LPAD(`a_furtran`.`IdDepartamentoRec`,2,'0')\n,',', MID(`a_furtran`.`IdMunicipioRec`,3,3)\n,',', `a_furtran`.`Zona`\n,',', DATE_FORMAT(a_eventoecat.Fechaeventoecat, '%d/%m/%Y')\n,',', TIME_FORMAT(a_eventoecat.Horaeventoecat, '%H:%i')\n,',', empresar.CHabilitacion \n,',', MID(`empresar`.`Id_Municipio`,1,2)\n,',', MID(`empresar`.`Id_Municipio`,3,3)\n,',', `f_liquidacion`.`NFolios`) AS Linea\nFROM\n    `f_factura_evento`\n    INNER JOIN `f_liquidacion` \n        ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    INNER JOIN `f_cuentacobro` \n        ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`)\n    INNER JOIN `ingreso` \n        ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `d_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `d_ips`.`Id`)\n    INNER JOIN `a_eventoecat_paciente` \n        ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `a_eventoecat` \n        ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)\n    INNER JOIN `a_furtran` \n        ON (`a_furtran`.`IdEvento` = `a_eventoecat`.`Id`)\n    LEFT JOIN `h_atencion` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `h_remisiones` \n        ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`)\n    LEFT JOIN `h_egreso_atencion` \n        ON (`h_egreso_atencion`.`Id_Tipo` = `ingreso`.`Id_TipoAtencion`) AND (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    LEFT JOIN `a_furtran_persona` \n        ON (`a_furtran_persona`.`IdPersonaEvento` = `a_eventoecat_paciente`.`Id`) AND (`a_furtran_persona`.`IdFurtran` = `a_furtran`.`Id`)\n    LEFT JOIN `g_empresa` \n        ON (`g_empresa`.`Id` = `a_furtran`.`IdMunicipioRec`)\n    INNER JOIN `g_persona` \n        ON (`g_persona`.`Id` = `a_eventoecat_paciente`.`Id_Persona`)\n        INNER JOIN g_empresa empresar        \n        ON (`empresar`.`Id` = `a_furtran`.`IdTerceroRecibe`)        \nWHERE (`f_liquidacion`.`Estado` =0\n    AND `f_factura_evento`.`Estado` =0\n    AND `f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'\n    AND `f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD1.format(this.JDC_FechaI.getDate()) + "'\n    AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD1.format(this.JDC_FechaF.getDate()) + "'\n    AND `f_factura_evento`.`EstaArmada` =2)\nGROUP BY `ingreso`.`Id`\nORDER BY `f_factura_evento`.`No_FacturaEvento` ASC;";
            }
            int x = 0;
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionFutRips.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionFutRips.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_FutRips1() {
        long xvalor;
        long xvalorf;
        long xvalor_trans;
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "FURIPS1" + this.xcodigo + "" + this.xmt.formatoAMD_Unida1.format(this.xmt.getFechaActual()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            if (this.JRBFactura.isSelected() || this.JRBCCobro.isSelected()) {
                this.xsql = "SELECT  CONCAT('',',' , '' ,',' , IF(`cc_resolucion_dian`.`trasmision` = 0,IF(f_factura_evento.Prefijo = '',`f_factura_evento`.`No_FacturaEvento`,CONCAT(f_factura_evento.Prefijo,`f_factura_evento`.`No_FacturaEvento`)),IF(f_factura_evento.Prefijo = '',`f_factura_evento`.`No_FacturaEvento_M`,CONCAT(f_factura_evento.Prefijo,`f_factura_evento`.`No_FacturaEvento_M`))) ,',', f_factura_evento.`No_CuentaCobro`,',' , `d_ips`.`CodigoOrganismo` ,',' ,  REPLACE(`g_persona`.`Apellido1`,'Ñ','N'),',' , REPLACE(`g_persona`.`Apellido2`,'Ñ','N'),',' , REPLACE(`g_persona`.`Nombre1`,'Ñ','N'),',' \n, REPLACE(`g_persona`.`Nombre2`,'Ñ','N'),',' , `g_persona`.`Id_TipoIdentificacion`,',' , `g_persona`.`NoDocumento`,',' , DATE_FORMAT(`g_persona`.`FechaNac`,'%d/%m/%Y'),',' , `g_persona`.`Id_Sexo`,',' , REPLACE(`g_persona`.`Direccion`,'Ñ','N'),',' , `g_municipio`.`Id_Dpto` ,',' ,  MID(`g_municipio`.`Id`,3,LENGTH(`g_municipio`.`Id`)) ,',' , IF(`g_persona`.`Telefono`='', IF(`g_persona`.`Movil`='','',`g_persona`.`Movil`), `g_persona`.`Telefono`) ,',' \n, `a_eventoecat_paciente`.`Id_condvictima`,',' , `a_eventoecat`.`Id_tipoevento`,',' , IF(`a_eventoecat`.`Id_tipoevento`=17,MID(REPLACE(`a_eventoecat`.`Descripcion`,',',''),1,25),''),',' , MID(`a_eventoecat`.`Direccion`,1,40) ,',' ,  DATE_FORMAT(`a_eventoecat`.`Fechaeventoecat`,'%d/%m/%Y') ,',' , TIME_FORMAT(`a_eventoecat`.`Horaeventoecat`,'%H:%i'),',' , `a_eventoecat`.`Id_Departamento`,',' , MID(`a_eventoecat`.`Id_Munucipio`,3,LENGTH(`a_eventoecat`.`Id_Munucipio`)) ,',' \n, `a_eventoecat`.`Zona` ,',' ,  `a_accidentetransito`.`Id_estadoasegveh`,',' , `a_marcavehiculo`.`Nbre`,',' , `a_accidentetransito`.`Placa1Veh`,',' , if(`a_accidentetransito`.`Id_tipovehiculo`=10, '',`a_accidentetransito`.`Id_tipovehiculo`) ,',' , `a_aseguradora`.`Codigo`,',' , if(`a_accidentetransito`.`Id_estadoasegveh`=1,`a_accidentetransito`.`NoPoliza`,''),',' , if(`a_accidentetransito`.`Id_estadoasegveh`=1, DATE_FORMAT(`a_accidentetransito`.`FechaInicPol`,'%d/%m/%Y'),'') ,',' ,  if(`a_accidentetransito`.`Id_estadoasegveh`=1,DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%d/%m/%Y'),'') ,',' , `a_accidentetransito`.`IntAutoridad`,',' \n, 0 ,',' , `a_accidentetransito`.`Placa2Veh`,',' , `a_accidentetransito`.`TipodocProp2`,',' , `a_accidentetransito`.`NoDocProp2`,',' , `a_accidentetransito`.`Placa3Veh`,',' , `a_accidentetransito`.`TipodocProp3`,',' , `a_accidentetransito`.`NoDocProp3`,',' , `a_accidentetransito`.`Id_tipodocProp`,',' , `a_accidentetransito`.`NodocumProp`,',' , `a_accidentetransito`.`Apellido1Prop`,',' , `a_accidentetransito`.`Apellido2Prop`,',' , `a_accidentetransito`.`Nombre1Prop`,',' , `a_accidentetransito`.`Nombre2Prop`,',' , REPLACE(`a_accidentetransito`.`DireccionProp`,'Ñ','N'),',' \n, `a_accidentetransito`.`TelefonoProp`,',' , `a_accidentetransito`.`DepartProp`,',' , MID(`a_accidentetransito`.`MunicProp`,3,LENGTH(`a_accidentetransito`.`MunicProp`)) ,',' , `a_accidentetransito`.`Apellido1Cond`,',' , `a_accidentetransito`.`Apellido2Cond`,',' , `a_accidentetransito`.`Nombre1Cond`,',' , `a_accidentetransito`.`Nombre2Cond`,',' , `a_accidentetransito`.`tipodocCond`,',' , `a_accidentetransito`.`NodocumCond`,',' , `a_accidentetransito`.`DireccionCond`,',' , `a_accidentetransito`.`DepartCond`,',' , MID(`a_accidentetransito`.`MunicCond`,3,LENGTH(`a_accidentetransito`.`MunicCond`)),',' \n, `a_accidentetransito`.`TelefonoCond`,',' , IF(`h_remisiones`.`Id` IS NULL, '', 1),',' , IF(`h_remisiones`.`Fecha` IS NULL, '', DATE_FORMAT(`h_remisiones`.`Fecha`,'%d/%m/%Y')) ,',' , IF(`h_remisiones`.`Hora` IS NULL, '',TIME_FORMAT(`h_remisiones`.`Hora`,'%H:%i') ) ,',' , IF(`h_remisiones`.`Id` IS NULL, '', `d_ips`.`CodigoOrganismo`) ,',' , IF(CONCAT(g_persona_R.`Apellido1`,' ', g_persona_R.`Apellido2`,' ', g_persona_R.`Nombre1`,' ', g_persona_R.`Nombre2`) IS NULL, '', MID(CONCAT(g_persona_R.`Apellido1`,' ', g_persona_R.`Apellido2`,' ', g_persona_R.`Nombre1`,' ', g_persona_R.`Nombre2`),1,60)) ,',' , IF(g_especialidad.`Nbre` IS NULL, '',MID(g_especialidad.`Nbre`,1,30)) ,',' , IF(`h_remisiones`.`FechaA` IS NULL, '', DATE_FORMAT(`h_remisiones`.`FechaA`,'%d/%m/%Y')) ,',' ,IF(`h_remisiones`.`HoraA` IS NULL, '', TIME_FORMAT(`h_remisiones`.`HoraA`,'%H:%i'))  ,',' , IF(`h_remisiones`.`CHabilitacion` IS NULL, '', `h_remisiones`.`CHabilitacion`) ,',' , IF(`h_remisiones`.`MedicosRecibe` IS NULL, '', `h_remisiones`.`MedicosRecibe`) ,',' ,  IF(`h_remisiones`.`ProfesionPR` IS NULL, '', `h_remisiones`.`ProfesionPR`) ,',' , IFNULL(a_transp_mov.`Placa`, '') ,',' , IFNULL(a_transp_mov.`SitioEvento`, '') ,',' ,   IFNULL(a_transp_mov.`FinRecorrido`, '') ,',' , IFNULL(a_transp_mov.`Id_TipoServAmb`, '')  ,',' ,  IFNULL(a_transp_mov.`ZonaRecogeVict`, '') ,',' , IF(ingreso.`Id_TipoAtencion`=1,DATE_FORMAT(ingreso.`FechaIngreso`,'%d/%m/%Y') ,IF(`h_atencion`.`Fecha_Atencion` IS NULL, '', DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d/%m/%Y')))  ,',' , IF(ingreso.`Id_TipoAtencion`=1,TIME_FORMAT(`ingreso`.`HoraIngreso`,'%H:%i') ,IF(`h_atencion`.`Hora_Atencion` IS NULL, '', TIME_FORMAT(`h_atencion`.`Hora_Atencion`,'%H:%i'))),',' , IF(ingreso.`Id_TipoAtencion`=1, DATE_FORMAT(ingreso.`FechaIngreso`,'%d/%m/%Y') ,IF(`h_egreso_atencion`.`FechaSO` IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d/%m/%Y'))),',' \n, IF(ingreso.`Id_TipoAtencion`=1,TIME_FORMAT(ADDTIME(`ingreso`.`HoraIngreso`,'00:30:00'),'%H:%i') , IF(`h_egreso_atencion`.`HoraSO` IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`HoraSO`,'%H:%i'))),',' , IF(ingreso.`Id_TipoAtencion`=1,ingreso.`DxIngreso`,IF(`h_atencion`.`Codigo_Dxp` IS NULL ,'', `h_atencion`.`Codigo_Dxp`)) ,',' , IF(`h_atencion`.`Codigo_DxR1` IS NULL, '', `h_atencion`.`Codigo_DxR1`) ,',' , IF(`h_atencion`.`Codigo_DxR2` IS NULL, '', `h_atencion`.`Codigo_DxR2`),',' , IF(ingreso.`Id_TipoAtencion`=1,ingreso.`DxIngreso`,IF(`h_egreso_atencion`.`DxP` IS NULL, '', `h_egreso_atencion`.`DxP`)) ,',' , IF(ingreso.`Id_TipoAtencion`=1,IF(`h_atencion`.`Codigo_DxR1` IS NULL, '', `h_atencion`.`Codigo_DxR1`),IF(`h_egreso_atencion`.`DxR1` IS NULL, '',`h_egreso_atencion`.`DxR1`))  ,',' , IF(ingreso.`Id_TipoAtencion`=1,IF(`h_atencion`.`Codigo_DxR2` IS NULL, '', `h_atencion`.`Codigo_DxR2`),IF(`h_egreso_atencion`.`DxR2` IS NULL, '', `h_egreso_atencion`.`DxR2`)),',' \n, IFNULL(g_profesional_R.`Apellido1`,IFNULL(g_profesional_A.`Apellido1`, IFNULL(g_profesional_I.`Apellido1`, ''))),',' , IFNULL(g_profesional_R.`Apellido2`,IFNULL(g_profesional_A.`Apellido2`, IFNULL(g_profesional_I.`Apellido2`, ''))),',' , IFNULL(g_profesional_R.`Nombre1`,IFNULL(g_profesional_A.`Nombre1`, IFNULL(g_profesional_I.`Nombre1`, ''))),',' , IFNULL(g_profesional_R.`Nombre2`,IFNULL(g_profesional_A.`Nombre2`, IFNULL(g_profesional_I.`Nombre2`, ''))),',' , IFNULL(g_profesional_R.`Id_TipoIdentificacion`, IFNULL(g_profesional_A.`Id_TipoIdentificacion`, IFNULL(g_profesional_I.`Id_TipoIdentificacion`, ''))),',' , IFNULL(g_profesional_R.`NoDocumento`,IFNULL(g_profesional_A.`NoDocumento`, IFNULL(g_profesional_I.`NoDocumento`, ''))),',' , IFNULL(g_profesional_R1.`Tarjeta`, IFNULL(g_profesional_A1.`Tarjeta`,IFNULL(g_profesional_I1.`Tarjeta`, '')))) AS Linea  \n,`ingreso`.`Id` AS IdIngreso, `f_liquidacion`.`TotalEps`, f_liquidacion.NFolios, `a_accidentetransito`.`Id_estadoasegveh` \nFROM   `f_factura_evento` \nINNER JOIN   `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) \nINNER JOIN   `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`) \nINNER JOIN   `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) \nINNER JOIN   `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   `d_ips`  ON (`d_ips`.`Id`= `f_empresacontxconvenio`.`Id_GIps`) \nINNER JOIN   `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN   `g_municipio`  ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nINNER JOIN   `a_eventoecat_paciente`  ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN   `a_eventoecat`  ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`) \nINNER JOIN   `a_accidentetransito`  ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`) \nINNER JOIN   `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) \nINNER JOIN   `a_aseguradora`  ON (`a_aseguradora`.`Id` = `a_accidentetransito`.`Id_aseguradora`)  \nLEFT JOIN   `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  \nLEFT JOIN   `g_persona` AS `g_profesional_A`  ON (`g_profesional_A`.`Id` = `h_atencion`.`Id_Profesional`)   \nLEFT JOIN   `g_profesional` AS `g_profesional_A1`  ON (`g_profesional_A1`.`Id_Persona` = `g_profesional_A`.`Id`)  \nLEFT JOIN   `g_persona` AS `g_profesional_I`  ON (`g_profesional_I`.`Id` = `ingreso`.`Id_Profesional`)   \nLEFT JOIN   `g_profesional` AS `g_profesional_I1`  ON (`g_profesional_I1`.`Id_Persona` = `g_profesional_I`.`Id`) \nLEFT JOIN   `h_remisiones`  ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`) \nLEFT JOIN   `g_persona` AS `g_persona_R`  ON (`g_persona_R`.`Id` = `h_remisiones`.`Id_Profesional`) \nLEFT JOIN   `g_especialidad`  ON (`g_especialidad`.`Id` = `h_remisiones`.`Id_EspecialidadR`) \nLEFT JOIN   `g_municipio` AS `g_municipio_1`  ON (`g_municipio_1`.`Id` = `h_remisiones`.`Id_Municipio`) \nLEFT JOIN   `h_egreso_atencion`  ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (ingreso.Id_TipoAtencion=h_egreso_atencion.Id_Tipo) \nLEFT JOIN   `g_persona` AS `g_profesional_R`  ON (`g_profesional_R`.`Id` = `h_egreso_atencion`.`Id_Profesional`)  \nLEFT JOIN   `g_profesional` AS `g_profesional_R1`  ON (`g_profesional_R1`.`Id_Persona` = `g_profesional_R`.`Id`) \nLEFT JOIN   `a_transp_mov`  ON (`a_transp_mov`.`Id_eventoecat_persona`= `a_eventoecat_paciente`.`Id`) INNER JOIN `cc_resolucion_dian`\nON(`cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`)WHERE ((IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)) ='" + this.JCBNFactura.getSelectedItem() + "' OR f_factura_evento.`No_CuentaCobro`='" + this.JCBNFactura.getSelectedItem() + "') and `f_liquidacion`.`Estado` =0 AND `f_factura_evento`.`Estado` =0 AND `f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_factura_evento`.`EstaArmada` =2 )  GROUP BY `ingreso`.Id  order by `f_factura_evento`.`No_FacturaEvento` asc";
            } else {
                this.xsql = "SELECT  CONCAT('',',' , '' ,',' , IF( `f_factura_evento`.`Prefijo`='', `f_factura_evento`.`No_FacturaEvento`, CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento`)) ,',', f_factura_evento.`No_CuentaCobro`,',' , `d_ips`.`CodigoOrganismo` ,',' ,  REPLACE(`g_persona`.`Apellido1`,'Ñ','N'),',' , REPLACE(`g_persona`.`Apellido2`,'Ñ','N'),',' , REPLACE(`g_persona`.`Nombre1`,'Ñ','N'),',' \n, REPLACE(`g_persona`.`Nombre2`,'Ñ','N'),',' , `g_persona`.`Id_TipoIdentificacion`,',' , `g_persona`.`NoDocumento`,',' , DATE_FORMAT(`g_persona`.`FechaNac`,'%d/%m/%Y'),',' , `g_persona`.`Id_Sexo`,',' , `g_persona`.`Direccion`,',' , `g_municipio`.`Id_Dpto` ,',' ,  MID(`g_municipio`.`Id`,3,LENGTH(`g_municipio`.`Id`)) ,',' , IF(`g_persona`.`Telefono`='', IF(`g_persona`.`Movil`='','',`g_persona`.`Movil`), `g_persona`.`Telefono`) ,',' \n, `a_eventoecat_paciente`.`Id_condvictima`,',' , `a_eventoecat`.`Id_tipoevento`,',' , IF(`a_eventoecat`.`Id_tipoevento`=17,MID(REPLACE(`a_eventoecat`.`Descripcion`,',',''),1,25),''),',' , MID(`a_eventoecat`.`Direccion`,1,40) ,',' ,  DATE_FORMAT(`a_eventoecat`.`Fechaeventoecat`,'%d/%m/%Y') ,',' , TIME_FORMAT(`a_eventoecat`.`Horaeventoecat`,'%H:%i'),',' , `a_eventoecat`.`Id_Departamento`,',' , MID(`a_eventoecat`.`Id_Munucipio`,3,LENGTH(`a_eventoecat`.`Id_Munucipio`)) ,',' \n, `a_eventoecat`.`Zona` ,',' ,  `a_accidentetransito`.`Id_estadoasegveh`,',' , `a_marcavehiculo`.`Nbre`,',' , `a_accidentetransito`.`Placa1Veh`,',' , if(`a_accidentetransito`.`Id_tipovehiculo`=10, '',`a_accidentetransito`.`Id_tipovehiculo`) ,',' , `a_aseguradora`.`Codigo`,',' , if(`a_accidentetransito`.`Id_estadoasegveh`=1,`a_accidentetransito`.`NoPoliza`,''),',' , if(`a_accidentetransito`.`Id_estadoasegveh`=1, DATE_FORMAT(`a_accidentetransito`.`FechaInicPol`,'%d/%m/%Y'),'') ,',' ,  if(`a_accidentetransito`.`Id_estadoasegveh`=1,DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%d/%m/%Y'),'') ,',' , `a_accidentetransito`.`IntAutoridad`,',' \n, 0 ,',' , `a_accidentetransito`.`Placa2Veh`,',' , `a_accidentetransito`.`TipodocProp2`,',' , `a_accidentetransito`.`NoDocProp2`,',' , `a_accidentetransito`.`Placa3Veh`,',' , `a_accidentetransito`.`TipodocProp3`,',' , `a_accidentetransito`.`NoDocProp3`,',' , `a_accidentetransito`.`Id_tipodocProp`,',' , `a_accidentetransito`.`NodocumProp`,',' , `a_accidentetransito`.`Apellido1Prop`,',' , `a_accidentetransito`.`Apellido2Prop`,',' , `a_accidentetransito`.`Nombre1Prop`,',' , `a_accidentetransito`.`Nombre2Prop`,',' , `a_accidentetransito`.`DireccionProp`,',' \n, `a_accidentetransito`.`TelefonoProp`,',' , `a_accidentetransito`.`DepartProp`,',' , MID(`a_accidentetransito`.`MunicProp`,3,LENGTH(`a_accidentetransito`.`MunicProp`)) ,',' , `a_accidentetransito`.`Apellido1Cond`,',' , `a_accidentetransito`.`Apellido2Cond`,',' , `a_accidentetransito`.`Nombre1Cond`,',' , `a_accidentetransito`.`Nombre2Cond`,',' , `a_accidentetransito`.`tipodocCond`,',' , `a_accidentetransito`.`NodocumCond`,',' , `a_accidentetransito`.`DireccionCond`,',' , `a_accidentetransito`.`DepartCond`,',' , MID(`a_accidentetransito`.`MunicCond`,3,LENGTH(`a_accidentetransito`.`MunicCond`)),',' \n, `a_accidentetransito`.`TelefonoCond`,',' , IF(`h_remisiones`.`Id` IS NULL, '', 1),',' , IF(`h_remisiones`.`Fecha` IS NULL, '', DATE_FORMAT(`h_remisiones`.`Fecha`,'%d/%m/%Y')) ,',' , IF(`h_remisiones`.`Hora` IS NULL, '',TIME_FORMAT(`h_remisiones`.`Hora`,'%H:%i') ) ,',' , IF(`h_remisiones`.`Id` IS NULL, '', `d_ips`.`CodigoOrganismo`) ,',' , IF(CONCAT(g_persona_R.`Apellido1`,' ', g_persona_R.`Apellido2`,' ', g_persona_R.`Nombre1`,' ', g_persona_R.`Nombre2`) IS NULL, '', MID(CONCAT(g_persona_R.`Apellido1`,' ', g_persona_R.`Apellido2`,' ', g_persona_R.`Nombre1`,' ', g_persona_R.`Nombre2`),1,60)) ,',' , IF(g_especialidad.`Nbre` IS NULL, '',MID(g_especialidad.`Nbre`,1,30)) ,',' , IF(`h_remisiones`.`FechaA` IS NULL, '', DATE_FORMAT(`h_remisiones`.`FechaA`,'%d/%m/%Y')) ,',' ,IF(`h_remisiones`.`HoraA` IS NULL, '', TIME_FORMAT(`h_remisiones`.`HoraA`,'%H:%i'))  ,',' , IF(`h_remisiones`.`CHabilitacion` IS NULL, '', `h_remisiones`.`CHabilitacion`) ,',' , IF(`h_remisiones`.`MedicosRecibe` IS NULL, '', `h_remisiones`.`MedicosRecibe`) ,',' ,  IF(`h_remisiones`.`ProfesionPR` IS NULL, '', `h_remisiones`.`ProfesionPR`) ,',' , IFNULL(a_transp_mov.`Placa`, '') ,',' , IFNULL(a_transp_mov.`SitioEvento`, '') ,',' ,   IFNULL(a_transp_mov.`FinRecorrido`, '') ,',' , IFNULL(a_transp_mov.`Id_TipoServAmb`, '')  ,',' ,  IFNULL(a_transp_mov.`ZonaRecogeVict`, '') ,',' , IF(`h_atencion`.`Fecha_Atencion` IS NULL, '', DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d/%m/%Y'))  ,',' , IF(`h_atencion`.`Hora_Atencion` IS NULL, '', TIME_FORMAT(`h_atencion`.`Hora_Atencion`,'%H:%i')),',' , IF(`h_egreso_atencion`.`FechaSO` IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d/%m/%Y')),',' \n, IF(`h_egreso_atencion`.`HoraSO` IS NULL, '', DATE_FORMAT(`h_egreso_atencion`.`HoraSO`,'%H:%i')),',' , IF(`h_atencion`.`Codigo_Dxp` IS NULL ,'', `h_atencion`.`Codigo_Dxp`) ,',' , IF(`h_atencion`.`Codigo_DxR1` IS NULL, '', `h_atencion`.`Codigo_DxR1`) ,',' , IF(`h_atencion`.`Codigo_DxR2` IS NULL, '', `h_atencion`.`Codigo_DxR2`),',' , IF(`h_egreso_atencion`.`DxP` IS NULL, '', `h_egreso_atencion`.`DxP`) ,',' , IF(`h_egreso_atencion`.`DxR1` IS NULL, '',`h_egreso_atencion`.`DxR1`) ,',' , IF(`h_egreso_atencion`.`DxR2` IS NULL, '', `h_egreso_atencion`.`DxR2`),',' \n, IFNULL(g_profesional_R.`Apellido1`,IFNULL(g_profesional_A.`Apellido1`, IFNULL(g_profesional_I.`Apellido1`, ''))),',' , IFNULL(g_profesional_R.`Apellido2`,IFNULL(g_profesional_A.`Apellido2`, IFNULL(g_profesional_I.`Apellido2`, ''))),',' , IFNULL(g_profesional_R.`Nombre1`,IFNULL(g_profesional_A.`Nombre1`, IFNULL(g_profesional_I.`Nombre1`, ''))),',' , IFNULL(g_profesional_R.`Nombre2`,IFNULL(g_profesional_A.`Nombre2`, IFNULL(g_profesional_I.`Nombre2`, ''))),',' , IFNULL(g_profesional_R.`Id_TipoIdentificacion`, IFNULL(g_profesional_A.`Id_TipoIdentificacion`, IFNULL(g_profesional_I.`Id_TipoIdentificacion`, ''))),',' , IFNULL(g_profesional_R.`NoDocumento`,IFNULL(g_profesional_A.`NoDocumento`, IFNULL(g_profesional_I.`NoDocumento`, ''))),',' , IFNULL(g_profesional_R1.`Tarjeta`, IFNULL(g_profesional_A1.`Tarjeta`,IFNULL(g_profesional_I1.`Tarjeta`, '')))) AS Linea  \n,`ingreso`.`Id` AS IdIngreso, `f_liquidacion`.`TotalEps`, f_liquidacion.NFolios, `a_accidentetransito`.`Id_estadoasegveh` \nFROM   `f_factura_evento` \nINNER JOIN   `f_liquidacion`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) \nINNER JOIN   `f_cuentacobro` ON (`f_factura_evento`.`No_CuentaCobro` = `f_cuentacobro`.`NoCuenta`) \nINNER JOIN   `ingreso`  ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`) \nINNER JOIN   `g_usuario`  ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`) \nINNER JOIN   `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) \nINNER JOIN   `d_ips`  ON (`d_ips`.`Id`= `f_empresacontxconvenio`.`Id_GIps`) \nINNER JOIN   `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`) \nINNER JOIN   `g_municipio`  ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`) \nINNER JOIN   `a_eventoecat_paciente`  ON (`a_eventoecat_paciente`.`Id_Ingreso` = `ingreso`.`Id`) \nINNER JOIN   `a_eventoecat`  ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`) \nINNER JOIN   `a_accidentetransito`  ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`) \nINNER JOIN   `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) \nINNER JOIN   `a_aseguradora`  ON (`a_aseguradora`.`Id` = `a_accidentetransito`.`Id_aseguradora`)  \nLEFT JOIN   `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  \nLEFT JOIN   `g_persona` AS `g_profesional_A`  ON (`g_profesional_A`.`Id` = `h_atencion`.`Id_Profesional`)   \nLEFT JOIN   `g_profesional` AS `g_profesional_A1`  ON (`g_profesional_A1`.`Id_Persona` = `g_profesional_A`.`Id`)  \nLEFT JOIN   `g_persona` AS `g_profesional_I`  ON (`g_profesional_I`.`Id` = `ingreso`.`Id_Profesional`)   \nLEFT JOIN   `g_profesional` AS `g_profesional_I1`  ON (`g_profesional_I1`.`Id_Persona` = `g_profesional_I`.`Id`) \nLEFT JOIN   `h_remisiones`  ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`) \nLEFT JOIN   `g_persona` AS `g_persona_R`  ON (`g_persona_R`.`Id` = `h_remisiones`.`Id_Profesional`) \nLEFT JOIN   `g_especialidad`  ON (`g_especialidad`.`Id` = `h_remisiones`.`Id_EspecialidadR`) \nLEFT JOIN   `g_municipio` AS `g_municipio_1`  ON (`g_municipio_1`.`Id` = `h_remisiones`.`Id_Municipio`) \nLEFT JOIN   `h_egreso_atencion`  ON (`h_egreso_atencion`.`Id_Ingreso` = `ingreso`.`Id`) AND (ingreso.Id_TipoAtencion=h_egreso_atencion.Id_Tipo) \nLEFT JOIN   `g_persona` AS `g_profesional_R`  ON (`g_profesional_R`.`Id` = `h_egreso_atencion`.`Id_Profesional`)  \nLEFT JOIN   `g_profesional` AS `g_profesional_R1`  ON (`g_profesional_R1`.`Id_Persona` = `g_profesional_R`.`Id`) \nLEFT JOIN   `a_transp_mov`  ON (`a_transp_mov`.`Id_eventoecat_persona`= `a_eventoecat_paciente`.`Id`) WHERE (`f_liquidacion`.`Estado` =0 AND `f_factura_evento`.`Estado` =0 AND `f_factura_evento`.`Fecha_FacturaEvento` >='" + this.xmt.formatoAMD1.format(this.JDC_FechaI.getDate()) + "' AND `f_factura_evento`.`Fecha_FacturaEvento` <='" + this.xmt.formatoAMD1.format(this.JDC_FechaF.getDate()) + "' AND `f_empresacontxconvenio`.`Id` ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' AND `f_factura_evento`.`EstaArmada` =2 )  GROUP BY `ingreso`.Id  order by `f_factura_evento`.`No_FacturaEvento` asc";
            }
            int x = 0;
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    long xvalort = mConsultarV(xrs.getString("IdIngreso"), 2);
                    if (xrs.getInt("Id_estadoasegveh") == 1) {
                        xvalor = xrs.getLong("TotalEps") - xvalort;
                        xvalorf = 0;
                        xvalor_trans = xvalort;
                        xvalort = 0;
                    } else {
                        xvalor = xrs.getLong("TotalEps") - xvalort;
                        xvalorf = xrs.getLong("TotalEps") - xvalort;
                        xvalor_trans = xvalort;
                    }
                    bw.write(xrs.getString(1) + "," + xvalor + "," + xvalorf + "," + xvalor_trans + "," + xvalort + "," + xrs.getLong("NFolios"));
                    bw.newLine();
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionFutRips.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionFutRips.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCrearArchivo_FutRips2() {
        try {
            String sFichero = this.JTFRuta.getText() + this.xmt.getBarra() + "FURIPS2" + this.xcodigo + "" + this.xmt.formatoAMD_Unida1.format(this.xmt.getFechaActual()) + ".txt";
            this.xmt.mEliminarArchivo(new File(sFichero));
            BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
            this.xsql = "delete from f_tmp_frips";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            if (this.JRBFactura.isSelected() || this.JRBCCobro.isSelected()) {
                this.xsql = "INSERT INTO f_tmp_frips(`NFactura`, `Fecha`, `Tipo`, `CodigoS`, `NombreP`, `Cantidad`, `VUnitario`, `VTotal`, `VRlamado`) (SELECT  IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))) As No_FacturaEvento ,f_factura_evento.`No_CuentaCobro`,IF((IF(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real)='39601' || IF(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real)='1931304' || IF(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real)='1931306')='39601',3,2), IF(IF(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real)='39601','',IF(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real))\n,IF((IF(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real)='39601' || IF(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real)='1931304' || IF(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real)='1931306'),LPAD(g_procedimiento.`Nbre_Soat`,40,1),''),  \n f_itemordenesproced.Cantidad,f_itemordenesproced.ValorUnitario ,((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+IFNULL(f_itemordenesproced.valorImpuesto,0)),((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+IFNULL(f_itemordenesproced.valorImpuesto,0))  \n FROM  g_usuario INNER JOIN g_persona ON \n(g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso \nON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes \nON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio \nON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_itemordenesproced \nON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN g_procedimiento \nON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_liquidacion \nON (f_liquidacion.Id_Ingreso = ingreso.Id)  \n INNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  \n INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \n INNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND \n(f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE ( f_itemordenesproced.ValorUnitario >0 and f_itemordenesproced.EsCobrable=1 \n AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND (IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)) ='" + this.JCBNFactura.getSelectedItem() + "' OR CAST(f_factura_evento.`No_CuentaCobro` AS CHAR)='" + this.JCBNFactura.getSelectedItem() + "') AND f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'))";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "INSERT INTO f_tmp_frips(`NFactura`, `Fecha`, `Tipo`, `CodigoS`, `NombreP`, `Cantidad`, `VUnitario`, `VTotal`, `VRlamado`) (SELECT IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))) As No_FacturaEvento ,f_factura_evento.`No_CuentaCobro`, 2 ,if(f_empresacontxconvenio.TCodigo=0,g_procedimiento1.C_Homologado, g_procedimiento1.C_Real),'', 1,(f_itemordenesqx.`VrCobro`) , (f_itemordenesqx.`VrCobro`),(f_itemordenesqx.`VrCobro`) FROM  g_usuario  \nINNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso  \nON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) INNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden) INNER JOIN `f_itemordenesqx`  ON (f_itemordenesqx.`Id_OrdenQX`= f_ordenesqx.`Id`)   \nINNER JOIN `g_especialidad` ON (g_especialidad.`Id` = f_ordenesqx.`Id_Especialidad`)  \n INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN g_procedimiento ON (f_ordenesqx.`Id_Procedimiento` = g_procedimiento.Id)  INNER JOIN g_procedimiento g_procedimiento1  ON (f_itemordenesqx.`Id_Procedimiento` = g_procedimiento1.Id)   \nINNER JOIN `q_procedtipomanqx`   ON (`q_procedtipomanqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \n INNER JOIN  `q_tipomanualqx`  ON (`q_procedtipomanqx`.`Id_TipoManualQx` = `q_tipomanualqx`.`Id`) \nINNER JOIN  `f_manual`  ON (`f_manual`.`Id_TipoManQx` = `q_tipomanualqx`.`Id`)  and (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`) \nINNER JOIN f_liquidacion  \nON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_factura_evento  \nON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)   INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`)  WHERE ((IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)) ='" + this.JCBNFactura.getSelectedItem() + "' OR CAST(f_factura_evento.`No_CuentaCobro` AS CHAR)='" + this.JCBNFactura.getSelectedItem() + "') AND f_ordenesqx.`Valor`>0 AND f_ordenesqx.`EsCobrable`=1 \nAND g_procedimiento.Id_TipoProcRIPS =6 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2  \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "') ORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)) ASC) ";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "INSERT INTO f_tmp_frips(`NFactura`, `Fecha`, `Tipo`, `CodigoS`, `NombreP`, `Cantidad`, `VUnitario`, `VTotal`, `VRlamado`) (SELECT  IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))) AS No_FacturaEvento ,f_factura_evento.`No_CuentaCobro` ,IF(i_suministro.`EsMaterial`=1, 5, 1),IF(i_suministro.`EsMaterial`=1, '',  i_suministro.CodigoCUM), IF(i_suministro.`EsMaterial`=1, i_suministro.Nbre,''),sum(f_itemordenessum.Cantidad) Cantidad ,f_itemordenessum.ValorUnit,((sum(f_itemordenessum.Cantidad)*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto),((sum(f_itemordenessum.Cantidad)*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)  \n FROM  g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso \nON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \n INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) INNER JOIN i_suministro \nON (f_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_unidadmedida \nON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_principioactivo \nON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_concentracion \nON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacionfarmaceutica \nON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_formafarmaceutica \nON (i_presentacionfarmaceutica.IdFormaFarmaceutica = i_formafarmaceutica.Id) INNER JOIN f_tarifasuministro \nON (f_tarifasuministro.Id_suministro = i_suministro.Id) AND (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_factura_evento \nON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE ((IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)) ='" + this.JCBNFactura.getSelectedItem() + "' OR CAST(f_factura_evento.`No_CuentaCobro` AS CHAR)='" + this.JCBNFactura.getSelectedItem() + "') AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0 \n AND f_itemordenessum.EsCobrable=1  AND ingreso.Estado =0 AND f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "' ) group by ingreso.Id, i_suministro.Id )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            } else {
                this.xsql = "INSERT INTO f_tmp_frips(`NFactura`, `Fecha`, `Tipo`, `CodigoS`, `NombreP`, `Cantidad`, `VUnitario`, `VTotal`, `VRlamado`) (SELECT   IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))) AS No_FacturaEvento ,f_factura_evento.`No_CuentaCobro`,2, if(f_empresacontxconvenio.TCodigo=0,g_procedimiento.C_Homologado, g_procedimiento.C_Real),'', \nf_itemordenesproced.Cantidad,f_itemordenesproced.ValorUnitario ,((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+IFNULL(f_itemordenesproced.valorImpuesto,0)),((f_itemordenesproced.ValorUnitario*f_itemordenesproced.Cantidad)+IFNULL(f_itemordenesproced.valorImpuesto,0)) \nFROM  g_usuario INNER JOIN g_persona ON \n(g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso \nON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes \nON (f_ordenes.Id_Ingreso = ingreso.Id) INNER JOIN f_empresacontxconvenio \nON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN f_itemordenesproced \nON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id)   INNER JOIN g_procedimiento \nON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id) INNER JOIN f_liquidacion \nON (f_liquidacion.Id_Ingreso = ingreso.Id)  \n INNER JOIN f_factura_evento ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  \n INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \n INNER JOIN f_tarifaprocedimiento ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) AND \n(f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_itemordenesproced.ValorUnitario >0 and f_itemordenesproced.EsCobrable=1 \n AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDC_FechaI.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDC_FechaF.getDate()) + "'  AND f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'))";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "INSERT INTO f_tmp_frips( `NFactura`, `Fecha`, `Tipo`, `CodigoS`, `NombreP`, `Cantidad`, `VUnitario`, `VTotal`, `VRlamado`) (SELECT  IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))) AS No_FacturaEvento ,f_factura_evento.`No_CuentaCobro`, 2 ,if(f_empresacontxconvenio.TCodigo=0,g_procedimiento1.C_Homologado, g_procedimiento1.C_Real),'', 1,(f_itemordenesqx.`VrCobro`) , (f_itemordenesqx.`VrCobro`),(f_itemordenesqx.`VrCobro`) FROM  g_usuario  \nINNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso  \nON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)  \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)  \nINNER JOIN g_tipoatencion ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) INNER JOIN f_ordenesqx  ON (f_ordenes.Id = f_ordenesqx.Id_Orden) INNER JOIN `f_itemordenesqx`  ON (f_itemordenesqx.`Id_OrdenQX`= f_ordenesqx.`Id`)  \nINNER JOIN `g_especialidad` ON (g_especialidad.`Id` = f_ordenesqx.`Id_Especialidad`)  \n INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN g_procedimiento  ON (f_ordenesqx.`Id_Procedimiento` = g_procedimiento.Id)   INNER JOIN g_procedimiento g_procedimiento1  ON (f_itemordenesqx.`Id_Procedimiento` = g_procedimiento1.Id) \nINNER JOIN `q_procedtipomanqx`   ON (`q_procedtipomanqx`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \n INNER JOIN  `q_tipomanualqx`  ON (`q_procedtipomanqx`.`Id_TipoManualQx` = `q_tipomanualqx`.`Id`) \nINNER JOIN  `f_manual`  ON (`f_manual`.`Id_TipoManQx` = `q_tipomanualqx`.`Id`)  and (`f_empresacontxconvenio`.`Id_Manual` = `f_manual`.`Id`) \nINNER JOIN f_liquidacion  \nON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_factura_evento  \nON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)    INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (f_ordenesqx.`Valor`>0 AND f_ordenesqx.`EsCobrable`=1 \nAND g_procedimiento.Id_TipoProcRIPS =6 AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2  \nAND ingreso.Estado =0 AND f_ordenes.Estado =0 AND f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "'AND f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDC_FechaI.getDate()) + "' \nAND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDC_FechaF.getDate()) + "') ORDER BY IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)) ASC) ";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.xsql = "INSERT INTO f_tmp_frips( `NFactura`, `Fecha`, `Tipo`, `CodigoS`, `NombreP`, `Cantidad`, `VUnitario`, `VTotal`, `VRlamado`) (SELECT  IF ( `cc_resolucion_dian`.`trasmision`= 0 ,IF(f_factura_evento.Prefijo='',f_factura_evento.No_FacturaEvento ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.No_FacturaEvento)), IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`))) AS No_FacturaEvento ,f_factura_evento.`No_CuentaCobro` ,IF(i_suministro.`EsMaterial`=1, 5, 1),IF(i_suministro.`EsMaterial`=1, '',  i_suministro.CodigoCUM), IF(i_suministro.`EsMaterial`=0,'', i_suministro.Nbre),sum(f_itemordenessum.Cantidad) Cantidad ,f_itemordenessum.ValorUnit,((sum(f_itemordenessum.Cantidad)*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto),((sum(f_itemordenessum.Cantidad)*f_itemordenessum.ValorUnit)+f_itemordenessum.valorImpuesto)  \n FROM  g_usuario \nINNER JOIN g_persona ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN ingreso \nON (ingreso.Id_Usuario = g_usuario.Id_persona) INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id) \n INNER JOIN g_ips ON (f_empresacontxconvenio.Id_GIps = g_ips.Id)  \nINNER JOIN f_itemordenessum ON (f_itemordenessum.Id_Ordenes = f_ordenes.Id) INNER JOIN i_suministro \nON (f_itemordenessum.Id_Suministro = i_suministro.Id) INNER JOIN i_unidadmedida \nON (i_suministro.IdUnidadMedida = i_unidadmedida.Id) INNER JOIN i_principioactivo \nON (i_suministro.IdPrincipioActivo = i_principioactivo.Id) INNER JOIN i_concentracion \nON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacionfarmaceutica \nON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_formafarmaceutica \nON (i_presentacionfarmaceutica.IdFormaFarmaceutica = i_formafarmaceutica.Id) INNER JOIN f_tarifasuministro \nON (f_tarifasuministro.Id_suministro = i_suministro.Id) AND (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \nINNER JOIN f_liquidacion ON (f_liquidacion.Id_Ingreso = ingreso.Id) INNER JOIN f_factura_evento \nON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id)  INNER JOIN `cc_resolucion_dian` ON( `cc_resolucion_dian`.`Id` = `f_factura_evento`.`idResolucionDian`) WHERE (  f_factura_evento.Fecha_FacturaEvento >='" + this.xmt.formatoAMD.format(this.JDC_FechaI.getDate()) + "' AND f_factura_evento.Fecha_FacturaEvento <='" + this.xmt.formatoAMD.format(this.JDC_FechaF.getDate()) + "' AND f_factura_evento.Estado =0 AND f_factura_evento.EstaArmada =2 AND f_liquidacion.Estado =0 AND f_ordenes.Estado =0 \n AND f_itemordenessum.EsCobrable=1  AND ingreso.Estado =0 AND f_empresacontxconvenio.Id ='" + this.xidempresa[this.JCBEmpresa.getSelectedIndex()] + "') group by ingreso.Id, i_suministro.Id )";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
            this.xsql = "SELECT  CONCAT(`NFactura`,',', `Fecha`,',',`Tipo`,',', `CodigoS`,',', SUBSTRING(NombreP,1,40) ,',',`Cantidad`,',',`VUnitario`,',',`VTotal`,',',`VRlamado`) FROM `f_tmp_frips` order by NFactura";
            int x = 0;
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    bw.write(xrs.getString(1));
                    bw.newLine();
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFGeneracionFutRips.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        } catch (SQLException ex2) {
            Logger.getLogger(JIFGeneracionFutRips.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private long mConsultarV(String xIngreso, int xpos) {
        ConsultasMySQL xct1;
        ResultSet xrs1;
        Throwable th;
        long xvalor = 0;
        try {
            xct1 = new ConsultasMySQL();
            this.xsql = "SELECT (`f_liquidacion`.`TotalEps`-((f_itemordenesproced.`ValorUnitario` * f_itemordenesproced.`Cantidad`)+IFNULL(f_itemordenesproced.valorImpuesto,0))) AS ValorT, ((f_itemordenesproced.`ValorUnitario` * f_itemordenesproced.`Cantidad`)+IFNULL(f_itemordenesproced.valorImpuesto,0)) AS VTranspo FROM `a_eventoecat_paciente`  LEFT JOIN `f_liquidacion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `f_liquidacion`.`Id_Ingreso`)    LEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)   LEFT JOIN ingreso ON (a_eventoecat_paciente.`Id_Ingreso`=ingreso.`Id`)  LEFT JOIN `f_ordenes` ON (ingreso.`Id`=f_ordenes.`Id_Ingreso`)  LEFT JOIN `f_itemordenesproced` ON (f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`)  LEFT JOIN `g_procedimiento` ON (f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`)  WHERE (`f_liquidacion`.`Estado`=0 AND `a_eventoecat_paciente`.`Id_Ingreso` ='" + xIngreso + "'  AND `f_ordenes`.`Estado`=0 AND g_procedimiento.`Id_tipoprocedimiento`=14 AND g_procedimiento.`C_Real`='39601')   GROUP BY `f_liquidacion`.`Id` ";
            xrs1 = xct1.traerRs(this.xsql);
            th = null;
        } catch (SQLException ex) {
            Logger.getLogger(JIFGeneracionFutRips.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        try {
            try {
                if (xrs1.next()) {
                    xrs1.first();
                    xvalor = xrs1.getLong(xpos);
                }
                if (xrs1 != null) {
                    if (0 != 0) {
                        try {
                            xrs1.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs1.close();
                    }
                }
                xct1.cerrarConexionBd();
                return xvalor;
            } finally {
            }
        } finally {
        }
    }
}
