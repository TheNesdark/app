package Contabilidad;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFConciliacionInventarios.class */
public class JIFConciliacionInventarios extends JInternalFrame {
    private String[][] xid;
    private Object[] xdato;
    private String[] xidtipoimpuesto;
    private String xsql;
    private String xcc_detalle_documentoc;
    private String xcc_documentoc;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private JButton JBTExportar;
    private JButton JBTExportar1;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHActivo;
    private JDateChooser JDFFechaC;
    private JPanel JPIConsolidado;
    private JPanel JPIDConsolidado;
    private JPanel JPIDConsolidado1;
    private JPanel JPIDatosC;
    private JScrollPane JSPConsolidadoC;
    private JScrollPane JSPDetalle2;
    private JScrollPane JSPDetalleC;
    private JTable JTConsolidadoC;
    private JTable JTDetalle2;
    private JTable JTDetalleC;
    private JFormattedTextField JTFFCuentaP;
    private JFormattedTextField JTFFTotalSaldo;
    private JFormattedTextField JTFFTotalSaldoC;
    private JFormattedTextField JTFFTotalSaldoD;
    private JFormattedTextField JTFFTotalSaldoInv;
    private JTextField JTFRuta;
    private JTabbedPane JTPDetalle;
    private JTabbedPane JTPRegistrosC;
    private JTabbedPane JTPRegistrosC1;
    private JYearChooser JYCAno;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private String xcodigopro = "";

    public JIFConciliacionInventarios() {
        initComponents();
        if (Principal.xclase.getxForma_Gn_Niif() == 1) {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc_niif";
            this.xcc_documentoc = "cc_documentoc_niif";
        } else {
            this.xcc_detalle_documentoc = "cc_detalle_documentoc";
            this.xcc_documentoc = "cc_documentoc";
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v24, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v54, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JTFFCuentaP = new JFormattedTextField();
        this.JTPDetalle = new JTabbedPane();
        this.JPIDConsolidado = new JPanel();
        this.JTPRegistrosC = new JTabbedPane();
        this.JSPConsolidadoC = new JScrollPane();
        this.JTConsolidadoC = new JTable();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JTFFTotalSaldoD = new JFormattedTextField();
        this.JTFFTotalSaldoC = new JFormattedTextField();
        this.JTFFTotalSaldo = new JFormattedTextField();
        this.JPIDConsolidado1 = new JPanel();
        this.JTPRegistrosC1 = new JTabbedPane();
        this.JPIConsolidado = new JPanel();
        this.JSPDetalle2 = new JScrollPane();
        this.JTDetalle2 = new JTable();
        this.JTFFTotalSaldoInv = new JFormattedTextField();
        this.JYCAno = new JYearChooser();
        this.JCBPeriodo = new JComboBox();
        this.JCHActivo = new JCheckBox();
        this.JBTExportar1 = new JButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CUENTAS POR PAGAR");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconciliacioninventario");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Corte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JTFFCuentaP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Puc", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuentaP.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaC, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JTFFCuentaP, -2, 127, -2).addContainerGap(-1, 32767)));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFCuentaP, -2, 50, -2).addComponent(this.JDFFechaC, -2, 50, -2)).addContainerGap()));
        this.JTPDetalle.setForeground(new Color(0, 103, 0));
        this.JTPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTPRegistrosC.setForeground(Color.red);
        this.JTPRegistrosC.setFont(new Font("Arial", 1, 14));
        this.JTConsolidadoC.setFont(new Font("Arial", 1, 12));
        this.JTConsolidadoC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTConsolidadoC.setRowHeight(25);
        this.JTConsolidadoC.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidadoC.setSelectionForeground(Color.red);
        this.JTConsolidadoC.setSelectionMode(0);
        this.JSPConsolidadoC.setViewportView(this.JTConsolidadoC);
        this.JTPRegistrosC.addTab("CONSOLIDADO", this.JSPConsolidadoC);
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.setSelectionMode(0);
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JTPRegistrosC.addTab("DETALLE", this.JSPDetalleC);
        this.JTFFTotalSaldoD.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Debito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalSaldoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalSaldoD.setHorizontalAlignment(4);
        this.JTFFTotalSaldoD.setFont(new Font("Arial", 1, 12));
        this.JTFFTotalSaldoC.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Credito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalSaldoC.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalSaldoC.setHorizontalAlignment(4);
        this.JTFFTotalSaldoC.setFont(new Font("Arial", 1, 12));
        this.JTFFTotalSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalSaldo.setHorizontalAlignment(4);
        this.JTFFTotalSaldo.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDConsolidadoLayout = new GroupLayout(this.JPIDConsolidado);
        this.JPIDConsolidado.setLayout(JPIDConsolidadoLayout);
        JPIDConsolidadoLayout.setHorizontalGroup(JPIDConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPRegistrosC, -1, 1018, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDConsolidadoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFFTotalSaldoD, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalSaldoC, -2, 140, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalSaldo, -2, 140, -2))).addContainerGap()));
        JPIDConsolidadoLayout.setVerticalGroup(JPIDConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPRegistrosC, -2, 252, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIDConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTotalSaldo, -2, 50, -2).addComponent(this.JTFFTotalSaldoD, -2, 50, -2).addComponent(this.JTFFTotalSaldoC, -2, 50, -2)).addContainerGap()));
        this.JTPDetalle.addTab("REGISTROS CONTABLES", this.JPIDConsolidado);
        this.JTPRegistrosC1.setForeground(Color.red);
        this.JTPRegistrosC1.setFont(new Font("Arial", 1, 14));
        this.JTDetalle2.setFont(new Font("Arial", 1, 12));
        this.JTDetalle2.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle2.setRowHeight(25);
        this.JTDetalle2.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle2.setSelectionForeground(Color.red);
        this.JTDetalle2.setSelectionMode(0);
        this.JSPDetalle2.setViewportView(this.JTDetalle2);
        this.JTFFTotalSaldoInv.setBorder(BorderFactory.createTitledBorder((Border) null, "V/Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTotalSaldoInv.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFTotalSaldoInv.setHorizontalAlignment(4);
        this.JTFFTotalSaldoInv.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle2, -2, 528, -2).addGap(18, 18, 18).addComponent(this.JTFFTotalSaldoInv, -2, 140, -2).addContainerGap(317, 32767)));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addGap(0, 149, 32767).addComponent(this.JTFFTotalSaldoInv, -2, 50, -2)).addComponent(this.JSPDetalle2, -2, 0, 32767)).addContainerGap()));
        this.JTPRegistrosC1.addTab("CONSOLIDADO", this.JPIConsolidado);
        this.JYCAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JYCAno.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JIFConciliacionInventarios.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFConciliacionInventarios.this.JYCAnoPropertyChange(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHActivo.setFont(new Font("Arial", 1, 13));
        this.JCHActivo.setSelected(true);
        this.JCHActivo.setText("Activo");
        this.JCHActivo.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConciliacionInventarios.2
            public void actionPerformed(ActionEvent evt) {
                JIFConciliacionInventarios.this.JCHActivoActionPerformed(evt);
            }
        });
        this.JBTExportar1.setFont(new Font("Arial", 1, 12));
        this.JBTExportar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTExportar1.setText("Actualizar");
        this.JBTExportar1.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConciliacionInventarios.3
            public void actionPerformed(ActionEvent evt) {
                JIFConciliacionInventarios.this.JBTExportar1ActionPerformed(evt);
            }
        });
        GroupLayout JPIDConsolidado1Layout = new GroupLayout(this.JPIDConsolidado1);
        this.JPIDConsolidado1.setLayout(JPIDConsolidado1Layout);
        JPIDConsolidado1Layout.setHorizontalGroup(JPIDConsolidado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsolidado1Layout.createSequentialGroup().addContainerGap().addGroup(JPIDConsolidado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPRegistrosC1).addGroup(JPIDConsolidado1Layout.createSequentialGroup().addComponent(this.JYCAno, -2, 67, -2).addGap(18, 18, 18).addComponent(this.JCBPeriodo, -2, 300, -2).addGap(18, 18, 18).addComponent(this.JCHActivo, -2, 67, -2).addGap(34, 34, 34).addComponent(this.JBTExportar1, -1, -1, 32767))).addContainerGap()));
        JPIDConsolidado1Layout.setVerticalGroup(JPIDConsolidado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsolidado1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTPRegistrosC1, -2, 252, -2).addGroup(JPIDConsolidado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, JPIDConsolidado1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, 32767).addComponent(this.JYCAno, -2, 50, -2)).addGroup(JPIDConsolidado1Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDConsolidado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsolidado1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodo, -2, 50, -2).addComponent(this.JCHActivo, GroupLayout.Alignment.TRAILING)).addComponent(this.JBTExportar1, GroupLayout.Alignment.TRAILING, -2, 50, -2)))).addContainerGap(-1, 32767)));
        this.JTPDetalle.addTab("REGISTROS INVENTARIO", this.JPIDConsolidado1);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFConciliacionInventarios.4
            public void mouseClicked(MouseEvent evt) {
                JIFConciliacionInventarios.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFConciliacionInventarios.5
            public void actionPerformed(ActionEvent evt) {
                JIFConciliacionInventarios.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 269, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 128, -2).addGap(0, 0, 32767)).addComponent(this.JPIDatosC, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTPDetalle, -2, 362, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap()));
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
            if (this.JTDetalleC.getRowCount() > -1) {
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JYCAnoPropertyChange(PropertyChangeEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHActivoActionPerformed(ActionEvent evt) {
        mCargarCombo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar1ActionPerformed(ActionEvent evt) {
        mActualizarValores();
        mCargarDatosCRInventario();
    }

    private void mActualizarValores() {
        String sql = "UPDATE `i_suministroxbodega`  SET `i_suministroxbodega`.`CExistencia`=0,  `i_suministroxbodega`.`CEntrada`=0, `i_suministroxbodega`.`CSalida`=0    WHERE `i_suministroxbodega`.`IdBodega` in(" + mConsultarIdBodegas() + ") ";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle = "SELECT `i_detalleentrada`.`IdSuministro` AS `Id`, SUM(`i_detalleentrada`.`Cantidad`) AS `Cantidad` FROM  `i_detalleentrada` INNER JOIN  `i_entradas`  ON (`i_detalleentrada`.`IdEntrada` = `i_entradas`.`Id`) INNER JOIN  `i_tiposmovimientos`  ON (`i_entradas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) WHERE (`i_entradas`.`Id_Periodo` >=27 AND `i_entradas`.`Id_Periodo` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `i_entradas`.`Estado` =0 AND `i_entradas`.`IdBodega` in(" + mConsultarIdBodegas() + ") ) GROUP BY `Id` HAVING (`Cantidad` <>0) ORDER BY `Id` ASC";
        String sqlw = "CREATE VIEW i_tmp_datos AS " + sqle;
        this.xct.ejecutarSQL(sqlw);
        this.xct.cerrarConexionBd();
        String sql2 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CEntrada`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega`in(" + mConsultarIdBodegas() + ") ";
        this.xct.ejecutarSQL(sql2);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle2 = "SELECT `i_detallesalida`.`IdSuministro` AS `Id` , SUM(`i_detallesalida`.`CantidadDespachada`) AS `Cantidad` FROM  `i_detallesalida` INNER JOIN  `i_salidas`  ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`) INNER JOIN `i_tiposmovimientos`  ON (`i_salidas`.`IdTipoMovimiento` = `i_tiposmovimientos`.`Id`) WHERE (`i_salidas`.`Id_Periodo` >=27 AND `i_salidas`.`Id_Periodo` <='" + this.xid[this.JCBPeriodo.getSelectedIndex()][0] + "' AND `i_salidas`.`Estado` =0 AND `i_salidas`.`IdBodega` in(" + mConsultarIdBodegas() + ") ) GROUP BY `Id` HAVING (`Cantidad` <>0) ORDER BY `Id` ASC ";
        String sqlw2 = "CREATE VIEW i_tmp_datos AS " + sqle2;
        this.xct.ejecutarSQL(sqlw2);
        this.xct.cerrarConexionBd();
        String sql3 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CSalida`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega` in(" + mConsultarIdBodegas() + ") ";
        this.xct.ejecutarSQL(sql3);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("DROP VIEW IF EXISTS i_tmp_datos");
        this.xct.cerrarConexionBd();
        String sqle3 = "SELECT `i_suministroxbodega`.`IdSuministro` AS `Id`, SUM(`i_suministroxlotexbodega`.`Cantidad`) AS `Cantidad` FROM `i_suministroxlotexbodega` INNER JOIN  `i_suministroxbodega`  ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`) WHERE (`i_suministroxbodega`.`IdBodega` in(" + mConsultarIdBodegas() + ") ) GROUP BY `Id` HAVING (`Cantidad` <>0) ORDER BY `Id` ASC ";
        String sqlw3 = "CREATE VIEW i_tmp_datos AS " + sqle3;
        this.xct.ejecutarSQL(sqlw3);
        this.xct.cerrarConexionBd();
        String sql4 = "UPDATE `i_suministroxbodega` ,`i_tmp_datos` SET i_suministroxbodega.`CExistencia`=i_tmp_datos.Cantidad WHERE i_tmp_datos.Id=i_suministroxbodega.`IdSuministro` AND i_suministroxbodega.`IdBodega` in(" + mConsultarIdBodegas() + ") ";
        this.xct.ejecutarSQL(sql4);
        this.xct.cerrarConexionBd();
    }

    private void mCargarCombo() {
        this.JCBPeriodo.removeAllItems();
        if (this.JCHActivo.isSelected()) {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM i_periodo WHERE estado=1 and  DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "' AND Activo=1 ORDER BY Id DESC; ";
        } else {
            this.xsql = "SELECT Id, IF(Nbre IS NULL || Nbre='',DevuelveMes(FechaI),Nbre)  AS Mes, DATE_FORMAT(FechaI,'%d-%m-%Y') AS FechaI, DATE_FORMAT(FechaF,'%d-%m-%Y') AS FechaF,  Activo, Estado FROM i_periodo WHERE estado=1 and DATE_FORMAT(FechaI,'%Y')='" + this.JYCAno.getValue() + "'  ORDER BY Id DESC; ";
        }
        this.xid = this.xct.llenarComboyLista(this.xsql, this.xid, this.JCBPeriodo, 6);
        this.xct.cerrarConexionBd();
    }

    public void mNuevo() {
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFFTotalSaldo.setValue(new Double(0.0d));
        this.JTFFTotalSaldoD.setValue(new Double(0.0d));
        this.JTFFTotalSaldoC.setValue(new Double(0.0d));
        mCargarCombo();
        mCrearModeloDatos();
        mCrearModeloDatosCRContables();
        mCrearModeloDatosCRInventario();
    }

    public void mBuscar() {
        if (!this.JTFFCuentaP.getText().isEmpty()) {
            mCargarDatosCRContables();
            mCargarDatosCRInventario();
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe digitar cuenta a consultar", "VALIDACIÓN", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFFCuentaP.requestFocus();
        }
    }

    public void mImprimir() {
        if (this.JTPDetalle.getSelectedIndex() == 1) {
            mConsultarIdBodegas();
            if (!this.xcodigopro.equals("")) {
                String[][] parametros = new String[3][2];
                parametros[0][0] = "IdBodega";
                parametros[0][1] = this.xcodigopro;
                parametros[1][0] = "SUBREPORT_DIR";
                parametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                parametros[2][0] = "SUBREPORTFIRMA_DIR";
                parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_Kardex_Bodegas", parametros);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"TipoDoc", "Tercero", "Depto", "Municipio", "Direccion", "Telefono", "FechaFac", "NFactura", "Valor"}) { // from class: Contabilidad.JIFConciliacionInventarios.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(8).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCRContables() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "TipoDoc", "Tercero", "VCredito", "VDebito", "Saldo"}) { // from class: Contabilidad.JIFConciliacionInventarios.7
            Class[] types = {Long.class, String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidadoC.setModel(this.xmodelo1);
        this.JTConsolidadoC.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTConsolidadoC.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTConsolidadoC.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTConsolidadoC.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTConsolidadoC.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTConsolidadoC.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTConsolidadoC.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTConsolidadoC.getColumnModel().getColumn(5).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCRInventario() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "Bodega", "Valor", "Consultar?"}) { // from class: Contabilidad.JIFConciliacionInventarios.8
            Class[] types = {Long.class, String.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle2.setModel(this.xmodelo2);
        this.JTDetalle2.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle2.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle2.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle2.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    private void mCargarDatos() {
        this.xsql = "SELECT `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, UCASE(`cc_terceros`.`NDepartamento`), `cc_terceros`.`NMunicipio`, `cc_terceros`.`Direccion`, `cc_terceros`.`Tel_Numero`, `cc_radicacion`.`FechaFac`, `cc_radicacion`.`NoFactura`, ROUND(SUM(`" + this.xcc_detalle_documentoc + "`.`VCredito`-`" + this.xcc_detalle_documentoc + "`.`VDebito`)) AS `Saldo` FROM `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) INNER JOIN  `cc_radicacion`  ON (`cc_radicacion`.`Id_Proveedor` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) AND (`cc_radicacion`.`NoFactura` = `" + this.xcc_detalle_documentoc + "`.`NFactura`) WHERE (`" + this.xcc_documentoc + "`.`FechaD` <='" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `" + this.xcc_detalle_documentoc + "`.`Id_Puc` LIKE'" + this.JTFFCuentaP.getText() + "%' AND `cc_radicacion`.`Estado` =1) GROUP BY `cc_terceros`.`Id`, `cc_radicacion`.`NoFactura` HAVING (`Saldo` <>0) ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        mCrearModeloDatos();
        ResultSet rs = this.xct.traerRs(this.xsql);
        double xvalor = 0.0d;
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo.setValueAt(Double.valueOf(rs.getDouble(9)), x, 8);
                    xvalor += rs.getDouble(9);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFTotalSaldo.setValue(Double.valueOf(xvalor));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosCRContables() {
        this.xsql = "SELECT `cc_terceros`.`Id`, `cc_terceros`.`TDCompleto`, `cc_terceros`.`RazonSocialCompleta`, ROUND(SUM(`" + this.xcc_detalle_documentoc + "`.`VDebito`)), ROUND(SUM(`" + this.xcc_detalle_documentoc + "`.`VCredito`)), ROUND(SUM(`" + this.xcc_detalle_documentoc + "`.`VDebito`-`" + this.xcc_detalle_documentoc + "`.`VCredito`)) AS `Saldo` FROM  `" + this.xcc_detalle_documentoc + "` INNER JOIN  `" + this.xcc_documentoc + "`  ON (`" + this.xcc_detalle_documentoc + "`.`Id_Documentoc` = `" + this.xcc_documentoc + "`.`Id`) INNER JOIN `cc_terceros`  ON (`cc_terceros`.`Id` = `" + this.xcc_detalle_documentoc + "`.`Id_Tercero`) WHERE (`" + this.xcc_detalle_documentoc + "`.`Id_Puc` LIKE'" + this.JTFFCuentaP.getText() + "%' AND `" + this.xcc_documentoc + "`.`Estado` =1 AND `" + this.xcc_documentoc + "`.`Id_PeriodoC`<='" + Principal.xclase.getXidperiodoc() + "') GROUP BY `cc_terceros`.`Id` ORDER BY `cc_terceros`.`RazonSocialCompleta` ASC ";
        mCrearModeloDatosCRContables();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            double xsd = 0.0d;
            double xsc = 0.0d;
            double xss = 0.0d;
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo1.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(4)), x, 3);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(5)), x, 4);
                    this.xmodelo1.setValueAt(Double.valueOf(rs.getDouble(6)), x, 5);
                    xsd += rs.getDouble(4);
                    xsc += rs.getDouble(5);
                    xss += rs.getDouble(6);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFTotalSaldoD.setValue(Double.valueOf(xsd));
            this.JTFFTotalSaldoC.setValue(Double.valueOf(xsc));
            this.JTFFTotalSaldo.setValue(Double.valueOf(xss));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mCargarDatosCRInventario() {
        this.xsql = "SELECT`i_bodegas`.`Id`, `i_bodegas`.`Nbre`, SUM(ROUND((`i_suministroxbodega`.`ETemporal`*`i_suministroxbodega`.`ValorI`))) AS `Total` FROM  `i_suministroxbodega` INNER JOIN `i_bodegas` ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) WHERE (`i_bodegas`.`Contabilidad` =1) GROUP BY `i_bodegas`.`Id` ORDER BY `i_bodegas`.`Nbre` ASC ";
        mCrearModeloDatosCRInventario();
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            double xsd = 0.0d;
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Long.valueOf(rs.getLong(1)), x, 0);
                    this.xmodelo2.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo2.setValueAt(Double.valueOf(rs.getDouble(3)), x, 2);
                    this.xmodelo2.setValueAt(true, x, 3);
                    xsd += rs.getDouble(3);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
            this.JTFFTotalSaldoInv.setValue(Double.valueOf(xsd));
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private String mConsultarIdBodegas() {
        this.xcodigopro = "";
        for (int x = 0; x < this.JTDetalle2.getRowCount(); x++) {
            if (Boolean.valueOf(this.xmodelo2.getValueAt(x, 3).toString()).booleanValue()) {
                this.xcodigopro += "," + this.xmodelo2.getValueAt(x, 0).toString();
            }
        }
        if (!this.xcodigopro.equals("")) {
            this.xcodigopro = this.xcodigopro.substring(1, this.xcodigopro.length());
        }
        return this.xcodigopro;
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Detalle", 0);
                for (int x = 0; x < this.JTDetalleC.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTDetalleC.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTDetalleC.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Number(8, x2 + 1, Double.valueOf(this.xmodelo.getValueAt(x2, 8).toString()).doubleValue()));
                }
                WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                for (int x3 = 0; x3 < this.JTConsolidadoC.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTConsolidadoC.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTConsolidadoC.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo1.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo1.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Label(2, x4 + 1, this.xmodelo1.getValueAt(x4, 2).toString()));
                    sheet2.addCell(new Label(3, x4 + 1, this.xmodelo1.getValueAt(x4, 3).toString()));
                    sheet2.addCell(new Label(4, x4 + 1, this.xmodelo1.getValueAt(x4, 4).toString()));
                    sheet2.addCell(new Label(5, x4 + 1, this.xmodelo1.getValueAt(x4, 5).toString()));
                    sheet2.addCell(new Number(6, x4 + 1, Double.valueOf(this.xmodelo1.getValueAt(x4, 6).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFConciliacionInventarios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConciliacionInventarios.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
