package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConsultarBalance.class */
public class JIFConsultarBalance extends JInternalFrame {
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String[][] xid;
    private Object[] xdato;
    private String[] xidnivel;
    private String[] xidtercero;
    private String xsql;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private JButton JBTExportar;
    private JComboBox JCBNivel;
    private JComboBox JCBPeriodo;
    private JComboBox JCBTercero;
    private JCheckBox JCHActivo;
    private JCheckBox JCHAuxiliares;
    private JCheckBox JCHNivel;
    private JCheckBox JCHTercero;
    private JPanel JPIAuxiliares;
    private JPanel JPIDatosC;
    private JPanel JPIFNivel;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalle1;
    private JTable JTDetalle;
    private JTable JTDetalle1;
    private JTextField JTFCuenta;
    private JFormattedTextField JTFFTCredito;
    private JFormattedTextField JTFFTDebito;
    private JTextField JTFRuta;
    private JTabbedPane JTPDetalle;
    private JYearChooser JYCAno;

    public JIFConsultarBalance() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v45, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v49, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JYCAno = new JYearChooser();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JCHTercero = new JCheckBox();
        this.JCHAuxiliares = new JCheckBox();
        this.JPIFNivel = new JPanel();
        this.JCBNivel = new JComboBox();
        this.JCHNivel = new JCheckBox();
        this.JTPDetalle = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalle1 = new JScrollPane();
        this.JTDetalle1 = new JTable();
        this.JPIAuxiliares = new JPanel();
        this.JTFCuenta = new JTextField();
        this.JCBTercero = new JComboBox();
        this.JTFFTDebito = new JFormattedTextField();
        this.JTFFTCredito = new JFormattedTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("BALANCE CONTABLE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifbalancecontable");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConsultarBalance.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConsultarBalance.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarBalance.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarBalance.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JCHTercero.setFont(new Font("Arial", 1, 13));
        this.JCHTercero.setText("Tercero");
        this.JCHAuxiliares.setFont(new Font("Arial", 1, 13));
        this.JCHAuxiliares.setText("Auxiliares");
        this.JCHAuxiliares.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarBalance.3
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarBalance.this.JCHAuxiliaresActionPerformed(evt);
            }
        });
        this.JPIFNivel.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por nivel", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBNivel.setFont(new Font("Arial", 1, 12));
        this.JCBNivel.setBorder(BorderFactory.createTitledBorder((Border) null, "Nivel", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNivel.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarBalance.4
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarBalance.this.JCBNivelActionPerformed(evt);
            }
        });
        GroupLayout JPIFNivelLayout = new GroupLayout(this.JPIFNivel);
        this.JPIFNivel.setLayout(JPIFNivelLayout);
        JPIFNivelLayout.setHorizontalGroup(JPIFNivelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFNivelLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JCBNivel, 0, 229, 32767).addContainerGap()));
        JPIFNivelLayout.setVerticalGroup(JPIFNivelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFNivelLayout.createSequentialGroup().addComponent(this.JCBNivel, -2, -1, -2).addGap(0, 12, 32767)));
        this.JCHNivel.setFont(new Font("Arial", 1, 13));
        this.JCHNivel.setText("Nivel");
        this.JCHNivel.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarBalance.5
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarBalance.this.JCHNivelActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 95, -2).addGap(10, 10, 10).addComponent(this.JCBPeriodo, -2, 300, -2).addGap(18, 18, 18).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCHActivo, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JCHTercero, -1, -1, 32767).addGap(56, 56, 56)).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCHAuxiliares).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHNivel, -1, -1, 32767).addGap(48, 48, 48))).addComponent(this.JPIFNivel, -2, -1, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIFNivel, -2, -1, -2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(1, 1, 1).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAuxiliares, -2, 22, -2).addComponent(this.JCHNivel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPeriodo, -2, -1, -2).addComponent(this.JCHActivo).addComponent(this.JCHTercero))).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JYCAno, -2, 44, -2)))).addContainerGap(-1, 32767)));
        this.JTPDetalle.setForeground(Color.red);
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDetalle.addTab("DETALLE", this.JSPDetalle);
        this.JTDetalle1.setFont(new Font("Arial", 1, 12));
        this.JTDetalle1.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle1.setRowHeight(25);
        this.JTDetalle1.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle1.setSelectionForeground(Color.red);
        this.JTDetalle1.setSelectionMode(0);
        this.JSPDetalle1.setViewportView(this.JTDetalle1);
        this.JTPDetalle.addTab("CONSOLIDADO", this.JSPDetalle1);
        this.JTFCuenta.setFont(new Font("Arial", 1, 12));
        this.JTFCuenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTercero.setFont(new Font("Arial", 1, 12));
        this.JCBTercero.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIAuxiliaresLayout = new GroupLayout(this.JPIAuxiliares);
        this.JPIAuxiliares.setLayout(JPIAuxiliaresLayout);
        JPIAuxiliaresLayout.setHorizontalGroup(JPIAuxiliaresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAuxiliaresLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCuenta, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTercero, -2, 568, -2).addContainerGap(227, 32767)));
        JPIAuxiliaresLayout.setVerticalGroup(JPIAuxiliaresLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAuxiliaresLayout.createSequentialGroup().addContainerGap().addGroup(JPIAuxiliaresLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCuenta, -2, -1, -2).addComponent(this.JCBTercero, -2, -1, -2)).addContainerGap(329, 32767)));
        this.JTPDetalle.addTab("AUXILIARES", this.JPIAuxiliares);
        this.JTFFTDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Debito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTDebito.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTDebito.setHorizontalAlignment(4);
        this.JTFFTDebito.setFont(new Font("Arial", 1, 12));
        this.JTFFTCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "Credito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTCredito.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTCredito.setHorizontalAlignment(4);
        this.JTFFTCredito.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConsultarBalance.6
            public void mouseClicked(MouseEvent evt) {
                JIFConsultarBalance.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConsultarBalance.7
            public void actionPerformed(ActionEvent evt) {
                JIFConsultarBalance.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFFTDebito, -2, 147, -2).addGap(18, 18, 18).addComponent(this.JTFFTCredito, -2, 140, -2)).addComponent(this.JPIDatosC, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTPDetalle, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDetalle, -2, 414, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTCredito).addComponent(this.JTFFTDebito, -2, -1, -2)).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
        pack();
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
            if (this.JTPDetalle.getSelectedIndex() == 0) {
                if (this.JTDetalle.getRowCount() > -1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNivelActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHNivelActionPerformed(ActionEvent evt) {
        if (this.JCHNivel.isSelected()) {
            this.JCBNivel.setEnabled(true);
        } else {
            this.JCBNivel.setEnabled(true);
            this.JCBNivel.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAuxiliaresActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        this.JTFFTDebito.setValue(new Double(0.0d));
        this.JTFFTCredito.setValue(new Double(0.0d));
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCargarCombo();
        mCrearModeloDatos();
        mCrearModeloDatos1();
        this.JCBPeriodo.requestFocus();
    }

    public void mBuscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            if (this.JCHTercero.isSelected()) {
                if (this.JCHAuxiliares.isSelected()) {
                    this.xct.ejecutarSQL("delete from cc_tmp_balance_tercero");
                    this.xct.cerrarConexionBd();
                    if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                        String xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
                        mCrearVistaMovimientoTercero(xcd);
                        mCargarDatos_Tercero();
                        mImprimir();
                        return;
                    }
                    if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                        String xcd2 = "WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' and cc_detalle_documentoc.Id_Tercero='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
                        mCrearVistaMovimientoTercero(xcd2);
                        mCargarDatos_Tercero();
                        mImprimir();
                        return;
                    }
                    if (this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                        String xcd3 = "WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.Id_Tercero='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
                        mCrearVistaMovimientoTercero(xcd3);
                        mCargarDatos_Tercero();
                        mImprimir();
                        return;
                    }
                    return;
                }
                this.xct.ejecutarSQL("delete from cc_tmp_balance_tercero");
                this.xct.cerrarConexionBd();
                mCrearVistaMovimientoTercero("");
                mCargarDatos_Tercero();
                mImprimir();
                return;
            }
            if (this.JTPDetalle.getSelectedIndex() == 2) {
                if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() == -1) {
                    mInicarValoresPuc();
                    this.xct.ejecutarSQL("delete from cc_tmp_balance_tercero");
                    this.xct.cerrarConexionBd();
                    mCrearVistaMovimientoTercero();
                    mImprimir();
                    return;
                }
                return;
            }
            if (this.JCHNivel.isSelected()) {
                if (this.JCBNivel.getSelectedIndex() != -1) {
                    mInicarValoresPuc();
                    mCrearVistaMovimiento();
                    mImprimir();
                    mCargarDatos();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un  nivel", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBNivel.requestFocus();
                return;
            }
            mInicarValoresPuc();
            mCrearVistaMovimiento();
            mImprimir();
            mCargarDatos();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un periodo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBPeriodo.requestFocus();
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=1 ORDER BY Id DESC; ";
        } else {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM cc_periodo_contable WHERE DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "'  ORDER BY Id DESC; ";
        }
        this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBPeriodo, 6);
        this.JCBTercero.removeAllItems();
        this.xsql = "SELECT `cc_terceros`.`Id`, `cc_terceros`.`RazonSocialCompleta` FROM  `cc_terceros` INNER JOIN  `cc_detalle_documentoc`  ON (`cc_terceros`.`Id` = `cc_detalle_documentoc`.`Id_Tercero`) INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`) WHERE (`cc_documentoc`.`Estado` =1) GROUP BY `cc_terceros`.`Id` ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        this.xidtercero = this.xct.llenarCombo(this.xsql, this.xidtercero, this.JCBTercero);
        this.JCBTercero.setSelectedIndex(-1);
        this.JCBNivel.removeAllItems();
        this.xidnivel = this.xct.llenarCombo("SELECT `cc_puc_nivel`.`Id`, `cc_puc_nivel`.`Nbre` FROM  `cc_puc` INNER JOIN  `cc_puc_nivel`  ON (`cc_puc`.`Id_Nivel` = `cc_puc_nivel`.`Id`) GROUP BY `cc_puc_nivel`.`Id`", this.xidnivel, this.JCBNivel);
        this.JCBNivel.setSelectedIndex(0);
        this.xct.cerrarConexionBd();
        this.JCBNivel.setEnabled(false);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "NCuenta", "Saldo Anterior", "V/Debito", "V/Credito", "Saldo", "Clasificacion"}) { // from class: Contabilidad.JIFConsultarBalance.8
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTercero() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "NCuenta", "Saldo Anterior", "V/Debito", "V/Credito", "Saldo", "Clasificacion", "Documento", "NTercero"}) { // from class: Contabilidad.JIFConsultarBalance.9
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"IdAuxiliar", "NAuxiliar", "%Base", "Valor", "SBase"}) { // from class: Contabilidad.JIFConsultarBalance.10
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle1.setModel(this.xmodelo1);
        this.JTDetalle1.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle1.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle1.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatos() {
        if (this.JCHNivel.isSelected()) {
            this.xsql = "SELECT `cc_puc`.`Id`, `cc_puc`.`Nbre`, `cc_puc`.`SaldoAnterior`, `cc_puc`.`VDebito`, `cc_puc`.`VCredito`, `cc_puc`.`SaldoActual`, `cc_puc_nivel`.`Nbre` FROM `cc_puc` INNER JOIN `cc_puc_nivel`  ON (`cc_puc`.`Id_Nivel` = `cc_puc_nivel`.`Id`) where `cc_puc`.`Id_Nivel`='" + this.xidnivel[this.JCBNivel.getSelectedIndex()] + "' ORDER BY `cc_puc`.`Id` ASC ";
        } else {
            this.xsql = "SELECT `cc_puc`.`Id`, `cc_puc`.`Nbre`, `cc_puc`.`SaldoAnterior`, `cc_puc`.`VDebito`, `cc_puc`.`VCredito`, `cc_puc`.`SaldoActual`, `cc_puc_nivel`.`Nbre` FROM `cc_puc` INNER JOIN `cc_puc_nivel`  ON (`cc_puc`.`Id_Nivel` = `cc_puc_nivel`.`Id`) ORDER BY `cc_puc`.`Id` ASC ";
        }
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT  `SAnterior`, `SDebito`, `SCredito`, `SActual` FROM `cc_v_puc_totates` ";
            ResultSet rs2 = this.xct.traerRs(this.xsql);
            if (rs2.next()) {
                rs2.first();
                this.JTFFTDebito.setValue(Double.valueOf(rs2.getDouble(2)));
                this.JTFFTCredito.setValue(Double.valueOf(rs2.getDouble(3)));
            }
            rs2.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatos_Tercero() {
        if (this.JCHNivel.isSelected()) {
            this.xsql = "SELECT `cc_puc`.`Id`, `cc_puc`.`Nbre`, `cc_puc`.`SaldoAnterior`, `cc_puc`.`VDebito`, `cc_puc`.`VCredito`, `cc_puc`.`SaldoActual`, `cc_puc_nivel`.`Nbre` FROM `cc_puc` INNER JOIN `cc_puc_nivel`  ON (`cc_puc`.`Id_Nivel` = `cc_puc_nivel`.`Id`) where `cc_puc`.`Id_Nivel`='" + this.xidnivel[this.JCBNivel.getSelectedIndex()] + "' ORDER BY `cc_puc`.`Id` ASC ";
        } else {
            this.xsql = "SELECT `cc_puc`.`Id`, `cc_puc`.`Nbre`, `cc_puc`.`SaldoAnterior`, `cc_puc`.`VDebito`, `cc_puc`.`VCredito`, `cc_puc`.`SaldoActual`, `cc_puc_nivel`.`Nbre` FROM `cc_puc` INNER JOIN `cc_puc_nivel`  ON (`cc_puc`.`Id_Nivel` = `cc_puc_nivel`.`Id`) ORDER BY `cc_puc`.`Id` ASC ";
        }
        mCrearModeloDatosTercero();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt("", x, 7);
                    this.xmodelo.setValueAt("", x, 8);
                    x++;
                    if (rs.getString(7).equals("AUXILIAR")) {
                        ConsultasMySQL xct1 = new ConsultasMySQL();
                        this.xsql = "SELECT`IdAuxiliar`, `TDCompleto`, `RazonSocialCompleta`, `SDAnterior`, `SDDebito`, `SDCredito`, `SDSaldoA`\nFROM `cc_v_tmp_datos1`\nWHERE (`TDCompleto`IS NOT NULL AND IdAuxiliar='" + rs.getString(1) + "' ) ORDER BY `RazonSocialCompleta`";
                        ResultSet xrs1 = xct1.traerRs(this.xsql);
                        if (xrs1.next()) {
                            xrs1.beforeFirst();
                            while (xrs1.next()) {
                                this.xmodelo.addRow(this.xdato);
                                this.xmodelo.setValueAt("", x, 0);
                                this.xmodelo.setValueAt(xrs1.getString("RazonSocialCompleta"), x, 1);
                                this.xmodelo.setValueAt(Double.valueOf(xrs1.getDouble("SDAnterior")), x, 2);
                                this.xmodelo.setValueAt(Double.valueOf(xrs1.getDouble("SDDebito")), x, 3);
                                this.xmodelo.setValueAt(Double.valueOf(xrs1.getDouble("SDCredito")), x, 4);
                                this.xmodelo.setValueAt(Double.valueOf(xrs1.getDouble("SDSaldoA")), x, 5);
                                this.xmodelo.setValueAt("", x, 6);
                                this.xmodelo.setValueAt(xrs1.getString("TDCompleto"), x, 7);
                                this.xmodelo.setValueAt(xrs1.getString("RazonSocialCompleta"), x, 8);
                                x++;
                            }
                        }
                        xrs1.close();
                        xct1.cerrarConexionBd();
                    }
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT  `SAnterior`, `SDebito`, `SCredito`, `SActual` FROM `cc_v_puc_totates` ";
            ResultSet rs2 = this.xct.traerRs(this.xsql);
            if (rs2.next()) {
                rs2.first();
                this.JTFFTDebito.setValue(Double.valueOf(rs2.getDouble(2)));
                this.JTFFTCredito.setValue(Double.valueOf(rs2.getDouble(3)));
            }
            rs2.close();
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
                for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Number(2, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).doubleValue()));
                    sheet.addCell(new Number(3, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 3).toString()).doubleValue()));
                    sheet.addCell(new Number(4, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 4).toString()).doubleValue()));
                    sheet.addCell(new Number(5, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 5).toString()).doubleValue()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                }
                WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                for (int x3 = 0; x3 < this.JTDetalle1.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTDetalle1.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTDetalle1.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo1.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Number(2, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 2).toString()).doubleValue()));
                    sheet2.addCell(new Number(3, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 3).toString()).doubleValue()));
                    sheet2.addCell(new Number(4, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 4).toString()).doubleValue()));
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

    private void mCrearVistaMovimiento() {
        mInicarValoresPuc();
        for (int x = 1; x < 14; x++) {
            this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos");
            this.xct.cerrarConexionBd();
            this.xsql = "";
            this.xsql = "SELECT MID(cc_detalle_documentoc.`Id_Puc`,1," + x + ") AS `Puc`, SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`, ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total    FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1 ) GROUP BY `Puc`  ";
            String sqlw = "CREATE VIEW cc_v_tmp_datos AS " + this.xsql;
            this.xct.ejecutarSQL(sqlw);
            this.xct.cerrarConexionBd();
            this.xsql = "UPDATE `cc_puc`, `cc_v_tmp_datos` SET cc_puc.`SaldoAnterior`= `cc_v_tmp_datos`.`Total` WHERE `cc_puc`.`Id`=`cc_v_tmp_datos`.`Puc`";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos");
            this.xct.cerrarConexionBd();
            this.xsql = "";
            this.xsql = "SELECT MID(cc_detalle_documentoc.`Id_Puc`,1," + x + ") AS `Puc`, SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`, ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total    FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1 ) GROUP BY `Puc`  ";
            String sqlw2 = "CREATE VIEW cc_v_tmp_datos AS " + this.xsql;
            this.xct.ejecutarSQL(sqlw2);
            this.xct.cerrarConexionBd();
            this.xsql = "UPDATE `cc_puc`, `cc_v_tmp_datos` SET cc_puc.`VDebito`= `cc_v_tmp_datos`.`VDebito`,cc_puc.`VCredito`= `cc_v_tmp_datos`.`VCredito`  WHERE `cc_puc`.`Id`=`cc_v_tmp_datos`.`Puc`";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos  ");
            this.xct.cerrarConexionBd();
            this.xsql = "";
            this.xsql = "SELECT MID(cc_detalle_documentoc.`Id_Puc`,1," + x + ") AS `Puc`, SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`, ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total    FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)  INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1 ) GROUP BY `Puc`  ";
            String sqlw3 = "CREATE VIEW cc_v_tmp_datos AS " + this.xsql;
            this.xct.ejecutarSQL(sqlw3);
            this.xct.cerrarConexionBd();
            this.xsql = "UPDATE `cc_puc`, `cc_v_tmp_datos` SET `cc_puc`.`SaldoActual`= `cc_v_tmp_datos`.`Total` WHERE `cc_puc`.`Id`=`cc_v_tmp_datos`.`Puc`";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
        }
    }

    private void mCrearVistaMovimientoTercero(String xcondicion) {
        String sqle;
        String sqle2;
        String sqle3;
        mCrearVistaMovimiento();
        String xcd = "";
        if (this.JCHAuxiliares.isSelected()) {
            if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() == -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            } else if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' and cc_detalle_documentoc.Id_Tercero='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            } else if (this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.Id_Tercero='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            }
            sqle = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SaldoAnterior`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   " + xcd;
        } else {
            sqle = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SaldoAnterior`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
        }
        this.xct.ejecutarSQL(sqle);
        this.xct.cerrarConexionBd();
        if (this.JCHAuxiliares.isSelected()) {
            if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() == -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            } else if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' and cc_detalle_documentoc.Id_Tercero='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            } else if (this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.Id_Tercero='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            }
            sqle2 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `VDebito`, `VCredito`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)  " + xcd;
        } else {
            sqle2 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `VDebito`, `VCredito`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
        }
        this.xct.ejecutarSQL(sqle2);
        this.xct.cerrarConexionBd();
        if (this.JCHAuxiliares.isSelected()) {
            if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() == -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            } else if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' and cc_detalle_documentoc.Id_Tercero='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            } else if (this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() != -1) {
                xcd = "WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.Id_Tercero='" + this.xidtercero[this.JCBTercero.getSelectedIndex()] + "' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
            }
            sqle3 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SActual`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   " + xcd;
        } else {
            sqle3 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SActual`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  ) GROUP BY `Puc`, `cc_terceros`.`Id`";
        }
        this.xct.ejecutarSQL(sqle3);
        this.xct.cerrarConexionBd();
        this.xsql = "SELECT `cc_puc_clasep`.`Id` AS `IdClase`, `cc_puc_clasep`.`Nbre` AS `NClase`, `cc_puc_clasep`.`SaldoAnterior` AS `CSaldoAnterior`, `cc_puc_clasep`.`VDebito` AS `CDebito`, `cc_puc_clasep`.`VCredito` AS `CCredito`, `cc_puc_clasep`.`SaldoActual` AS `CSaldoActual`, `cc_puc_grupo`.`Id` AS `IdGrupo` , `cc_puc_grupo`.`Nbre` AS `NGrupo`, `cc_puc_grupop`.`SaldoAnterior` AS `GSaldoAnterior`, `cc_puc_grupop`.`VDebito` AS `GDebito`, `cc_puc_grupop`.`VCredito` AS `GCredito`, `cc_puc_grupop`.`SaldoActual` AS `GSaldoActual`, `cc_puc_cuenta`.`Id` AS `IdCuenta`, `cc_puc_cuenta`.`Nbre` AS `NCuenta`, `cc_puc_cuentap`.`SaldoAnterior` AS `CCSaldoAnterior` , `cc_puc_cuentap`.`VDebito` AS `CCDebito`, `cc_puc_cuentap`.`VCredito` AS `CCCredito`, `cc_puc_cuentap`.`SaldoActual` AS `CCSaldoActual`, `cc_puc_subcuenta`.`Id` AS `IdSubcuenta`, `cc_puc_subcuenta`.`Nbre` AS `NSubCuenta`, `cc_puc_subcuentap`.`SaldoAnterior` AS `SSaldoAnterior`, `cc_puc_subcuentap`.`VDebito` AS `SDebito`, `cc_puc_subcuentap`.`VCredito` AS `SCredito` , `cc_puc_subcuentap`.`SaldoActual` AS `SSaldoActual`, `cc_puc_auxiliar`.`Id` AS `IdAuxiliar`, `cc_puc_auxiliar`.`Nbre` AS `NAuxiliar`, `cc_puc`.`SaldoAnterior` AS `ASaldoAnterior`, `cc_puc`.`VDebito` AS `ADebito`, `cc_puc`.`VCredito` AS `ACredito`, `cc_puc`.`SaldoActual` AS `ASandoActual`, `cc_puc`.`Id_Tercero`, IF(`cc_puc`.`Id_Tercero`=0,NULL,`cc_terceros`.`Id`) AS Id , IF(`cc_puc`.`Id_Tercero`=0,NULL, `cc_terceros`.`TDCompleto1`)AS TDCompleto, IF(`cc_puc`.`Id_Tercero`=0,NULL, `cc_terceros`.`RazonSocialCompleta`) AS RazonSocialCompleta, IF(`cc_puc`.`Id_Tercero`=0,NULL,`cc_tmp_balance_tercero`.`Id_Puc`) AS Id_Puc, IF(`cc_puc`.`Id_Tercero`=0,NULL,SUM(`cc_tmp_balance_tercero`.`SaldoAnterior`)) AS SDAnterior, IF(`cc_puc`.`Id_Tercero`=0,NULL,SUM(`cc_tmp_balance_tercero`.`VDebito`)) AS SDDebito , IF(`cc_puc`.`Id_Tercero`=0,NULL, SUM(`cc_tmp_balance_tercero`.`VCredito`)) AS SDCredito, IF(`cc_puc`.`Id_Tercero`=0,NULL, SUM(`cc_tmp_balance_tercero`.`SActual`)) AS SDSaldoA FROM  `cc_terceros`INNER JOIN `cc_tmp_balance_tercero` ON (`cc_terceros`.`Id` = `cc_tmp_balance_tercero`.`Id_Tercero`) INNER JOIN `cc_puc_auxiliar` ON (`cc_puc_auxiliar`.`Id` = `cc_tmp_balance_tercero`.`Id_Puc`) INNER JOIN `cc_puc` ON (`cc_puc`.`Id` = `cc_puc_auxiliar`.`Id`) INNER JOIN `cc_puc_subcuenta` ON (`cc_puc_subcuenta`.`Id` = `cc_puc_auxiliar`.`Id_subcuenta`) INNER JOIN `cc_puc` AS `cc_puc_subcuentap` ON (`cc_puc_subcuentap`.`Id` = `cc_puc_subcuenta`.`Id`) INNER JOIN `cc_puc_cuenta` ON (`cc_puc_cuenta`.`Id` = `cc_puc_subcuenta`.`Id_cuenta`) INNER JOIN `cc_puc` AS `cc_puc_cuentap` ON (`cc_puc_cuentap`.`Id` = `cc_puc_cuenta`.`Id`) INNER JOIN `cc_puc_grupo` ON (`cc_puc_cuenta`.`Id_Grupo` = `cc_puc_grupo`.`Id`) INNER JOIN `cc_puc` AS `cc_puc_grupop` ON (`cc_puc_grupop`.`Id` = `cc_puc_grupo`.`Id`) INNER JOIN `cc_puc_clase` ON (`cc_puc_grupo`.`Id_clase` = `cc_puc_clase`.`Id`) INNER JOIN `cc_puc` AS `cc_puc_clasep` ON (`cc_puc_clasep`.`Id` = `cc_puc_clase`.`Id`) GROUP BY `cc_terceros`.`Id`, `cc_tmp_balance_tercero`.`Id_Puc` ORDER BY `cc_tmp_balance_tercero`.`Id_Puc` ASC, `cc_terceros`.`RazonSocialCompleta` ASC ";
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos1");
        this.xct.cerrarConexionBd();
        String sqlw = "CREATE VIEW cc_v_tmp_datos1 AS " + this.xsql;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
    }

    private void mCrearVistaMovimientoTercero() {
        mCrearVistaMovimiento();
        String sqle = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SaldoAnterior`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` <'" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
        this.xct.ejecutarSQL(sqle);
        this.xct.cerrarConexionBd();
        String sqle2 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `VDebito`, `VCredito`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,SUM(`cc_detalle_documentoc`.`VDebito`) AS `VDebito`,SUM(`cc_detalle_documentoc`.`VCredito`) AS `VCredito`   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` ='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
        this.xct.ejecutarSQL(sqle2);
        this.xct.cerrarConexionBd();
        String sqle3 = "insert into cc_tmp_balance_tercero(`Id_Tercero`, `Id_Puc`, `SActual`) SELECT `cc_terceros`.`Id`, cc_detalle_documentoc.`Id_Puc` AS `Puc`,ROUND(IF(cc_puc.Tipo=0,(SUM(cc_detalle_documentoc.VDebito) -SUM(cc_detalle_documentoc.VCredito)), (SUM(cc_detalle_documentoc.VCredito) -SUM(cc_detalle_documentoc.VDebito))),2) AS Total   FROM `cc_detalle_documentoc` INNER JOIN  `cc_documentoc`  ON (`cc_detalle_documentoc`.`Id_Documentoc` = `cc_documentoc`.`Id`)   INNER JOIN `cc_puc` ON (`cc_detalle_documentoc`.`Id_Puc` = `cc_puc`.`Id`)  INNER JOIN  `cc_terceros`  ON (`cc_detalle_documentoc`.`Id_Tercero` = `cc_terceros`.`Id`)   WHERE (`cc_documentoc`.`Id_PeriodoC` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `cc_documentoc`.`Estado` =1  and cc_detalle_documentoc.`Id_Puc` like'" + this.JTFCuenta.getText() + "%' ) GROUP BY `Puc`, `cc_terceros`.`Id` ";
        this.xct.ejecutarSQL(sqle3);
        this.xct.cerrarConexionBd();
        this.xsql = "SELECT `cc_puc_clasep`.`Id` AS `IdClase`, `cc_puc_clasep`.`Nbre` AS `NClase`, `cc_puc_clasep`.`SaldoAnterior` AS `CSaldoAnterior`, `cc_puc_clasep`.`VDebito` AS `CDebito`, `cc_puc_clasep`.`VCredito` AS `CCredito`, `cc_puc_clasep`.`SaldoActual` AS `CSaldoActual`, `cc_puc_grupo`.`Id` AS `IdGrupo` , `cc_puc_grupo`.`Nbre` AS `NGrupo`, `cc_puc_grupop`.`SaldoAnterior` AS `GSaldoAnterior`, `cc_puc_grupop`.`VDebito` AS `GDebito`, `cc_puc_grupop`.`VCredito` AS `GCredito`, `cc_puc_grupop`.`SaldoActual` AS `GSaldoActual`, `cc_puc_cuenta`.`Id` AS `IdCuenta`, `cc_puc_cuenta`.`Nbre` AS `NCuenta`, `cc_puc_cuentap`.`SaldoAnterior` AS `CCSaldoAnterior` , `cc_puc_cuentap`.`VDebito` AS `CCDebito`, `cc_puc_cuentap`.`VCredito` AS `CCCredito`, `cc_puc_cuentap`.`SaldoActual` AS `CCSaldoActual`, `cc_puc_subcuenta`.`Id` AS `IdSubcuenta`, `cc_puc_subcuenta`.`Nbre` AS `NSubCuenta`, `cc_puc_subcuentap`.`SaldoAnterior` AS `SSaldoAnterior`, `cc_puc_subcuentap`.`VDebito` AS `SDebito`, `cc_puc_subcuentap`.`VCredito` AS `SCredito` , `cc_puc_subcuentap`.`SaldoActual` AS `SSaldoActual`, `cc_puc_auxiliar`.`Id` AS `IdAuxiliar`, `cc_puc_auxiliar`.`Nbre` AS `NAuxiliar`, `cc_puc`.`SaldoAnterior` AS `ASaldoAnterior`, `cc_puc`.`VDebito` AS `ADebito`, `cc_puc`.`VCredito` AS `ACredito`, `cc_puc`.`SaldoActual` AS `ASandoActual`, `cc_puc`.`Id_Tercero`, IF(`cc_puc`.`Id_Tercero`=0,NULL,`cc_terceros`.`Id`) AS Id , IF(`cc_puc`.`Id_Tercero`=0,NULL, `cc_terceros`.`TDCompleto1`)AS TDCompleto, IF(`cc_puc`.`Id_Tercero`=0,NULL, `cc_terceros`.`RazonSocialCompleta`) AS RazonSocialCompleta, IF(`cc_puc`.`Id_Tercero`=0,NULL,`cc_tmp_balance_tercero`.`Id_Puc`) AS Id_Puc, IF(`cc_puc`.`Id_Tercero`=0,NULL,SUM(`cc_tmp_balance_tercero`.`SaldoAnterior`)) AS SDAnterior, IF(`cc_puc`.`Id_Tercero`=0,NULL,SUM(`cc_tmp_balance_tercero`.`VDebito`)) AS SDDebito , IF(`cc_puc`.`Id_Tercero`=0,NULL, SUM(`cc_tmp_balance_tercero`.`VCredito`)) AS SDCredito, IF(`cc_puc`.`Id_Tercero`=0,NULL, SUM(`cc_tmp_balance_tercero`.`SActual`)) AS SDSaldoA FROM  `cc_terceros`INNER JOIN `cc_tmp_balance_tercero` ON (`cc_terceros`.`Id` = `cc_tmp_balance_tercero`.`Id_Tercero`) INNER JOIN `cc_puc_auxiliar` ON (`cc_puc_auxiliar`.`Id` = `cc_tmp_balance_tercero`.`Id_Puc`) INNER JOIN `cc_puc` ON (`cc_puc`.`Id` = `cc_puc_auxiliar`.`Id`) INNER JOIN `cc_puc_subcuenta` ON (`cc_puc_subcuenta`.`Id` = `cc_puc_auxiliar`.`Id_subcuenta`) INNER JOIN `cc_puc` AS `cc_puc_subcuentap` ON (`cc_puc_subcuentap`.`Id` = `cc_puc_subcuenta`.`Id`) INNER JOIN `cc_puc_cuenta` ON (`cc_puc_cuenta`.`Id` = `cc_puc_subcuenta`.`Id_cuenta`) INNER JOIN `cc_puc` AS `cc_puc_cuentap` ON (`cc_puc_cuentap`.`Id` = `cc_puc_cuenta`.`Id`) INNER JOIN `cc_puc_grupo` ON (`cc_puc_cuenta`.`Id_Grupo` = `cc_puc_grupo`.`Id`) INNER JOIN `cc_puc` AS `cc_puc_grupop` ON (`cc_puc_grupop`.`Id` = `cc_puc_grupo`.`Id`) INNER JOIN `cc_puc_clase` ON (`cc_puc_grupo`.`Id_clase` = `cc_puc_clase`.`Id`) INNER JOIN `cc_puc` AS `cc_puc_clasep` ON (`cc_puc_clasep`.`Id` = `cc_puc_clase`.`Id`) GROUP BY `cc_terceros`.`Id`, `cc_tmp_balance_tercero`.`Id_Puc` ORDER BY `cc_tmp_balance_tercero`.`Id_Puc` ASC, `cc_terceros`.`RazonSocialCompleta` ASC ";
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS cc_v_tmp_datos1");
        this.xct.cerrarConexionBd();
        String sqlw = "CREATE VIEW cc_v_tmp_datos1 AS " + this.xsql;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
    }

    public void mImprimir() {
        String[][] parametros = new String[5][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "periodo";
        parametros[1][1] = this.JCBPeriodo.getSelectedItem().toString();
        parametros[2][0] = "nivel";
        parametros[2][1] = this.xidnivel[this.JCBNivel.getSelectedIndex()];
        parametros[3][0] = "SUBREPORT_DIR";
        parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[4][0] = "SUBREPORTFIRMA_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.JCHTercero.isSelected()) {
            if (this.JCHAuxiliares.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Saldos_Terceros", parametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_BalancePrueba_Tercero", parametros);
                return;
            }
        }
        if (this.JTPDetalle.getSelectedIndex() == 2) {
            if (!this.JTFCuenta.getText().isEmpty() && this.JCBTercero.getSelectedIndex() == -1) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_Saldos_Terceros_Auxiliares", parametros);
                return;
            }
            return;
        }
        if (this.JCHNivel.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_BalancePrueba_Nivel", parametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "CC_BalancePrueba", parametros);
        }
    }

    private void mInicarValoresPuc() {
        this.xsql = "update cc_puc set SaldoAnterior=0, VDebito=0, VCredito=0, SaldoActual=0";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }
}
