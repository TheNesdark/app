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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JIFExportarDatosTipoDoc.class */
public class JIFExportarDatosTipoDoc extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidtipodoc;
    private ButtonGroup JBGOpciones;
    private JButton JBTExportar;
    private JComboBox JCBTipoDoc;
    private JCheckBox JCHCajaMenor;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JScrollPane JSPDetalle1;
    private JTextField JTFRuta;
    public JTable JTResultado;
    private JPanel jPanel2;
    private Metodos xmetodos = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();

    public JIFExportarDatosTipoDoc() {
        initComponents();
        this.xidtipodoc = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM cc_tipo_documentoc WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipodoc, this.JCBTipoDoc);
        this.xconsultas.cerrarConexionBd();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.jPanel2 = new JPanel();
        this.JDFFechaF = new JDateChooser();
        this.JDFFechaI = new JDateChooser();
        this.JCBTipoDoc = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHCajaMenor = new JCheckBox();
        this.JSPDetalle1 = new JScrollPane();
        this.JTResultado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("EXPORTACION DOCUMENTOS CONTABLES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifexportarinformacionc");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 0, 13));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 0, 13));
        this.JCBTipoDoc.setFont(new Font("Arial", 0, 13));
        this.JCBTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Mecosoft\\MECOsic\\Planos\\CMDMOVIMIENTO.TXT");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Contabilidad.JIFExportarDatosTipoDoc.1
            public void mouseClicked(MouseEvent evt) {
                JIFExportarDatosTipoDoc.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Contabilidad.JIFExportarDatosTipoDoc.2
            public void actionPerformed(ActionEvent evt) {
                JIFExportarDatosTipoDoc.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHCajaMenor.setFont(new Font("Arial", 1, 12));
        this.JCHCajaMenor.setText("Es Caja Menor?");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2)).addComponent(this.JBTExportar, -2, 226, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBTipoDoc, -2, 525, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHCajaMenor)).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -1, 668, 32767)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDoc, -2, -1, -2).addComponent(this.JCHCajaMenor)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, -1, -2).addComponent(this.JDFFechaF, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -2, 52, -2))));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Tahoma", 0, 12));
        this.JTResultado.setForeground(new Color(0, 0, 204));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(204, 255, 204));
        this.JTResultado.setRowHeight(20);
        this.JSPDetalle1.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSPDetalle1, GroupLayout.Alignment.LEADING, -1, 978, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle1, -2, 432, -2).addContainerGap(43, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\Mecosoft\\MECOsic\\Planos");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmetodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.xmetodos.mVerificarDatosTablaTrue(this.JTResultado, 3)) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta exportar la información?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    if (this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
                        mCrearArchivo();
                        mCargarDatos();
                        return;
                    } else {
                        if (this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()].equals("2")) {
                            mCrearArchivoComprobanteEgresoSF();
                            mCargarDatos();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un items de la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la ruta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Fecha", "Tercero", "Exportar", "NR"}) { // from class: Contabilidad.JIFExportarDatosTipoDoc.3
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(400);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mCargarDatos() {
        String sql = null;
        if (this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()].equals("1")) {
            sql = "SELECT cc_documentoc.Id,Date_format(cc_documentoc.FechaD,'%d-%m-%Y') as Fecha, cc_terceros.RazonSocialCompleta, COUNT(cc_documentoc.Id) AS CR FROM cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) WHERE (cc_documentoc.FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_documentoc.FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND cc_documentoc.Estado =1 AND cc_documentoc.ExportadoC =0 and Id_PeriodoC='" + Principal.xclase.getXidperiodoc() + "' ) GROUP BY cc_documentoc.Id ORDER BY cc_documentoc.Id ASC ";
        } else if (this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()].equals("2")) {
            sql = "SELECT cc_documentoc.Id, DATE_FORMAT(FechaD,'%d-%m-%Y') AS Fecha, '' AS NEmpresa, COUNT(cc_documentoc.Id)FROM cc_detalle_documentoc INNER JOIN cc_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) WHERE (cc_documentoc.Id_TipoComprobante ='" + this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()] + "' AND cc_documentoc.FechaD <='" + this.xmetodos.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND cc_documentoc.FechaD >='" + this.xmetodos.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND cc_documentoc.Estado =1 AND cc_documentoc.ExportadoC =0 and Id_PeriodoC='" + Principal.xclase.getXidperiodoc() + "')  GROUP BY cc_documentoc.Id ORDER BY cc_documentoc.Id ASC ";
        }
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
                    this.xmodelo.setValueAt(false, x, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(4)), x, 4);
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
        this.JCBTipoDoc.setSelectedIndex(-1);
        mCrearTabla();
        this.JCBTipoDoc.requestFocus();
    }

    public void mBuscar() {
        if (this.JCBTipoDoc.getSelectedIndex() != -1) {
            if (this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()].equals("1") || this.xidtipodoc[this.JCBTipoDoc.getSelectedIndex()].equals("2")) {
                mCargarDatos();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoDoc.requestFocus();
    }

    private void mCrearArchivo() {
        String sFichero = this.JTFRuta.getText();
        File fichero = new File(sFichero);
        if (fichero.exists()) {
            return;
        }
        BufferedWriter bw = null;
        try {
            try {
                bw = new BufferedWriter(new FileWriter(sFichero));
                for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                        mActualizarEstado(this.xmodelo.getValueAt(x, 0).toString());
                        String sql = "SELECT DATE_FORMAT(FechaI,'%Y') AS PAno,'!', DATE_FORMAT(FechaI,'%m') AS PMes,'!', cc_tipo_documentoc.CodigoC AS NComprobante,'!', LPAD('0',5,0) AS Prefijo,'!' , LPAD(IF(g_empresa.FacTInterna=1,CONCAT('C-',cc_radicacion.Id_FacturaInterna),LEFT(NoFactura,15)),15,0) AS NDocumento,'!', DATE_FORMAT(FechaD,'%m/%d/%Y') AS FechaD,'!', cc_detalle_documentoc.Id_Puc AS CuentaContable,'!', LPAD(cc_puc.CCosto,3,0) AS CCosto,'!', LPAD('0',5,0) AS CodigoMoneda,'!' , LPAD('',0,'') AS Cod1,'!', LPAD('',0,'') AS Cod2,'!', g_empresa.DocComodin AS NitCed,'!', LPAD('0',11,0) AS Cod3,'!', LPAD('0',3,0) AS Cod4,'!', LPAD('0',5,0) AS Cod5,'!', LEFT(NoFactura,15) AS Nfactura,'!' , LEFT(Descripcion,50) AS Concepto,'!', cc_detalle_documentoc.VDebito+cc_detalle_documentoc.VCredito  AS Valor,'!', cc_detalle_documentoc.Base,'!', LPAD('0',1,0) AS Cod7,'!', IF(cc_detalle_documentoc.TipoCPuc=0,'DNO', 'CNO')  AS NatCuenta,'!' , 'DIG','!', LPAD('0',1,0) AS Cod8,'!', LPAD('',0,'') AS Cod9,'!', LPAD('',0,'') AS Cod10 FROM cc_periodo_contable INNER JOIN cc_documentoc ON (cc_periodo_contable.Id = cc_documentoc.Id_PeriodoC) INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id) INNER JOIN g_empresa  ON (g_empresa.Id = cc_detalle_documentoc.Id_Tercero) INNER JOIN cc_radicacion  ON (cc_radicacion.Id = cc_documentoc.Id_Radicacion) WHERE ((cc_documentoc.Id IN(" + this.xmodelo.getValueAt(x, 0).toString() + "))) ";
                        ResultSet xrs = this.xconsultas.traerRs(sql);
                        xrs.first();
                        for (int y = 1; y <= Integer.valueOf(this.xmodelo.getValueAt(x, 4).toString()).intValue(); y++) {
                            DecimalFormat format = new DecimalFormat("00000");
                            String ret = format.format(y);
                            bw.write(xrs.getString(1) + xrs.getString(2) + xrs.getString(3) + xrs.getString(4) + xrs.getString(5) + xrs.getString(6) + xrs.getString(7) + xrs.getString(8) + xrs.getString(9) + xrs.getString(10) + xrs.getString(11) + "!" + ret + xrs.getString(12) + xrs.getString(13) + xrs.getString(14) + xrs.getString(15) + xrs.getString(16) + xrs.getString(17) + xrs.getString(18) + xrs.getString(19) + xrs.getString(20) + xrs.getString(21) + xrs.getString(22) + xrs.getString(23) + xrs.getString(24) + xrs.getString(25) + xrs.getString(26) + xrs.getString(27) + xrs.getString(28) + xrs.getString(29) + xrs.getString(30) + xrs.getString(31) + xrs.getString(32) + xrs.getString(33) + xrs.getString(34) + xrs.getString(35) + xrs.getString(36) + xrs.getString(37) + xrs.getString(38) + xrs.getString(39) + xrs.getString(40) + xrs.getString(41) + xrs.getString(42) + xrs.getString(43) + xrs.getString(44) + xrs.getString(45) + xrs.getString(46) + xrs.getString(47) + xrs.getString(48) + xrs.getString(49));
                            bw.newLine();
                            xrs.next();
                        }
                        xrs.close();
                        this.xconsultas.cerrarConexionBd();
                    }
                }
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } catch (IOException ex2) {
                Logger.getLogger(JIFExportarDatosTipoDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                try {
                    bw.close();
                } catch (IOException ex3) {
                    Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                }
            } catch (SQLException ex4) {
                Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
                try {
                    bw.close();
                } catch (IOException ex5) {
                    Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex5);
                }
            }
        } catch (Throwable th) {
            try {
                bw.close();
            } catch (IOException ex6) {
                Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex6);
            }
            throw th;
        }
    }

    private void mCrearArchivoComprobanteEgresoSF() {
        String sql;
        String sFichero = this.JTFRuta.getText();
        File fichero = new File(sFichero);
        if (fichero.exists()) {
            return;
        }
        BufferedWriter bw = null;
        try {
            try {
                bw = new BufferedWriter(new FileWriter(sFichero));
                for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                        String sql1 = null;
                        if (this.JCHCajaMenor.isSelected()) {
                            sql = "SELECT DATE_FORMAT(FechaD,'%Y') AS PAno,'!', DATE_FORMAT(FechaD,'%m') AS PMes,'!', cc_tipo_documentoc.CodigoC AS NComprobante,'!',  LPAD('0',5,0) AS Prefijo,'!' , LPAD(cc_documentoc.Id,15,0) AS NDocumento, '!', DATE_FORMAT(FechaD,'%m/%d/%Y') AS FechaD,'!',LPAD(@numeroConsecutivo:=@numeroConsecutivo+1  ,5,0) AS Consecutivo, '!', cc_detalle_documentoc.Id_Puc AS CuentaContable,'!', LPAD(cc_puc.CCosto,3,0) AS CCosto,'!', LPAD('0',5,0) AS CodigoMoneda,'!'  , LPAD('',0,'') AS Cod1,'!', LPAD('',0,'') AS Cod2,'!', IF(cc_puc.Id_Tercero=1,g_empresa.DocComodin,LPAD('0',11,0)) AS NitCed,'!', LPAD('0',11,0) AS Cod3,'!', LPAD('0',3,0) AS Cod4,'!', LPAD('0',5,0) AS Cod5,'!', LEFT(IF(cc_documentoc.TipoPago=0,'DISFON','CHEQUE') ,15)AS Nfactura,'!' ,LEFT(cc_puc.Nbre,50) AS Concepto,'!', cc_detalle_documentoc.VDebito+cc_detalle_documentoc.VCredito  AS Valor,'!', LPAD('0',1,0) AS Cod6,'!', LPAD('0',1,0) AS Cod7,'!',  IF(cc_detalle_documentoc.TipoCPuc=0,'DNO', 'CNO')  AS NatCuenta,'!' , 'DIG','!', LPAD('0',1,0) AS Cod8,'!', LPAD('',0,'') AS Cod9, '!', LPAD('',0,'') AS Cod10 FROM (SELECT @numeroConsecutivo:=0) r,  cc_periodo_contable INNER JOIN cc_documentoc ON (cc_periodo_contable.Id = cc_documentoc.Id_PeriodoC) INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id)  INNER JOIN g_empresa  ON (g_empresa.Id = cc_detalle_documentoc.Id_Tercero) INNER JOIN cc_solicitud_reembolso ON (cc_documentoc.Id = cc_solicitud_reembolso.Id_DocContable) WHERE ((cc_documentoc.Id IN(" + this.xmodelo.getValueAt(x, 0).toString() + ")))  ORDER BY cc_detalle_documentoc.Id_Radicacion ";
                        } else {
                            sql = "SELECT DATE_FORMAT(FechaD,'%Y') AS PAno,'!', DATE_FORMAT(FechaD,'%m') AS PMes,'!', cc_tipo_documentoc.CodigoC AS NComprobante,'!',  LPAD('0',5,0) AS Prefijo,'!' , LPAD(cc_documentoc.Id,15,0) AS NDocumento, '!', DATE_FORMAT(FechaD,'%m/%d/%Y') AS FechaD,'!',LPAD(@numeroConsecutivo:=@numeroConsecutivo+1  ,5,0) AS Consecutivo, '!', cc_detalle_documentoc.Id_Puc AS CuentaContable,'!', LPAD(cc_puc.CCosto,3,0) AS CCosto,'!', LPAD('0',5,0) AS CodigoMoneda,'!'  , LPAD('',0,'') AS Cod1,'!', LPAD('',0,'') AS Cod2,'!', IF(cc_puc.Id_Tercero=1,g_empresa.DocComodin,LPAD('0',11,0)) AS NitCed,'!', LPAD('0',11,0) AS Cod3,'!', LPAD('0',3,0) AS Cod4,'!', LPAD('0',5,0) AS Cod5,'!', LEFT(IF(cc_documentoc.TipoPago=0,'DISFON','CHEQUE') ,15)AS Nfactura,'!' , LEFT(CONCAT('PAGO FACTURA - ', IF(g_empresa.FacTInterna=1,CONCAT('C-',cc_radicacion.Id_FacturaInterna),LEFT(NoFactura,50))) ,50) AS Concepto,'!', cc_detalle_documentoc.VDebito+cc_detalle_documentoc.VCredito  AS Valor,'!', LPAD('0',1,0) AS Cod6,'!', LPAD('0',1,0) AS Cod7,'!',  IF(cc_detalle_documentoc.TipoCPuc=0,'DNO', 'CNO')  AS NatCuenta,'!' , 'DIG','!', LPAD('0',1,0) AS Cod8,'!', LPAD('',0,'') AS Cod9, '!', LPAD('',0,'') AS Cod10 FROM (SELECT @numeroConsecutivo:=0) r,  cc_periodo_contable INNER JOIN cc_documentoc ON (cc_periodo_contable.Id = cc_documentoc.Id_PeriodoC) INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id)  INNER JOIN g_empresa  ON (g_empresa.Id = cc_detalle_documentoc.Id_Tercero) INNER JOIN cc_radicacion ON (cc_radicacion.Id = cc_detalle_documentoc.Id_Radicacion) WHERE ((cc_documentoc.Id IN(" + this.xmodelo.getValueAt(x, 0).toString() + ")))  ORDER BY cc_detalle_documentoc.Id_Radicacion ";
                            sql1 = "SELECT DATE_FORMAT(FechaD,'%Y') AS PAno,'!', DATE_FORMAT(FechaD,'%m') AS PMes,'!', cc_tipo_documentoc.CodigoC AS NComprobante,'!',  LPAD('0',5,0) AS Prefijo,'!' , LPAD(cc_documentoc.Id,15,0) AS NDocumento, '!', DATE_FORMAT(FechaD,'%m/%d/%Y') AS FechaD,'!',LPAD(@numeroConsecutivo:=@numeroConsecutivo+1  ,5,0) AS Consecutivo, '!', cc_detalle_documentoc.Id_Puc AS CuentaContable,'!', LPAD(cc_puc.CCosto,3,0) AS CCosto,'!', LPAD('0',5,0) AS CodigoMoneda,'!'  , LPAD('',0,'') AS Cod1,'!', LPAD('',0,'') AS Cod2,'!', IF(cc_puc.Id_Tercero=1,g_empresa.DocComodin,LPAD('0',11,0)) AS NitCed,'!', LPAD('0',11,0) AS Cod3,'!', LPAD('0',3,0) AS Cod4,'!', LPAD('0',5,0) AS Cod5,'!', LEFT(IF(cc_documentoc.TipoPago=0,'DISFON','CHEQUE') ,15)AS Nfactura,'!' , LEFT('' ,50) AS Concepto,'!', cc_detalle_documentoc.VDebito+cc_detalle_documentoc.VCredito  AS Valor,'!', LPAD('0',1,0) AS Cod6,'!', LPAD('0',1,0) AS Cod7,'!',  IF(cc_detalle_documentoc.TipoCPuc=0,'DNO', 'CNO')  AS NatCuenta,'!' , 'DIG','!', LPAD('0',1,0) AS Cod8,'!', LPAD('',0,'') AS Cod9, '!', LPAD('',0,'') AS Cod10 FROM (SELECT @numeroConsecutivo:=0) r,  cc_periodo_contable INNER JOIN cc_documentoc ON (cc_periodo_contable.Id = cc_documentoc.Id_PeriodoC) INNER JOIN cc_tipo_documentoc  ON (cc_documentoc.Id_TipoComprobante = cc_tipo_documentoc.Id) INNER JOIN cc_detalle_documentoc ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id)  INNER JOIN g_empresa  ON (g_empresa.Id = cc_detalle_documentoc.Id_Tercero)  WHERE ((cc_documentoc.Id IN(" + this.xmodelo.getValueAt(x, 0).toString() + ") AND cc_detalle_documentoc.TipoCPuc=1 ))  ORDER BY cc_detalle_documentoc.Id_Radicacion ";
                        }
                        ResultSet xrs = this.xconsultas.traerRs(sql);
                        xrs.first();
                        for (int y = 1; y < Integer.valueOf(this.xmodelo.getValueAt(x, 4).toString()).intValue(); y++) {
                            bw.write(xrs.getString(1) + xrs.getString(2) + xrs.getString(3) + xrs.getString(4) + xrs.getString(5) + xrs.getString(6) + xrs.getString(7) + xrs.getString(8) + xrs.getString(9) + xrs.getString(10) + xrs.getString(11) + xrs.getString(12) + xrs.getString(13) + xrs.getString(14) + xrs.getString(15) + xrs.getString(16) + xrs.getString(17) + xrs.getString(18) + xrs.getString(19) + xrs.getString(20) + xrs.getString(21) + xrs.getString(22) + xrs.getString(23) + xrs.getString(24) + xrs.getString(25) + xrs.getString(26) + xrs.getString(27) + xrs.getString(28) + xrs.getString(29) + xrs.getString(30) + xrs.getString(31) + xrs.getString(32) + xrs.getString(33) + xrs.getString(34) + xrs.getString(35) + xrs.getString(36) + xrs.getString(37) + xrs.getString(38) + xrs.getString(39) + xrs.getString(40) + xrs.getString(41) + xrs.getString(42) + xrs.getString(43) + xrs.getString(44) + xrs.getString(45) + xrs.getString(46) + xrs.getString(47) + xrs.getString(48) + xrs.getString(49) + xrs.getString(50) + xrs.getString(51));
                            bw.newLine();
                            xrs.next();
                        }
                        xrs.close();
                        this.xconsultas.cerrarConexionBd();
                        ResultSet xrs2 = this.xconsultas.traerRs(sql1);
                        xrs2.first();
                        bw.write(xrs2.getString(1) + xrs2.getString(2) + xrs2.getString(3) + xrs2.getString(4) + xrs2.getString(5) + xrs2.getString(6) + xrs2.getString(7) + xrs2.getString(8) + xrs2.getString(9) + xrs2.getString(10) + xrs2.getString(11) + xrs2.getString(12) + xrs2.getString(13) + xrs2.getString(14) + xrs2.getString(15) + xrs2.getString(16) + xrs2.getString(17) + xrs2.getString(18) + xrs2.getString(19) + xrs2.getString(20) + xrs2.getString(21) + xrs2.getString(22) + xrs2.getString(23) + xrs2.getString(24) + xrs2.getString(25) + xrs2.getString(26) + xrs2.getString(27) + xrs2.getString(28) + xrs2.getString(29) + xrs2.getString(30) + xrs2.getString(31) + xrs2.getString(32) + xrs2.getString(33) + xrs2.getString(34) + xrs2.getString(35) + xrs2.getString(36) + xrs2.getString(37) + xrs2.getString(38) + xrs2.getString(39) + xrs2.getString(40) + xrs2.getString(41) + xrs2.getString(42) + xrs2.getString(43) + xrs2.getString(44) + xrs2.getString(45) + xrs2.getString(46) + xrs2.getString(47) + xrs2.getString(48) + xrs2.getString(49) + xrs2.getString(50) + xrs2.getString(51));
                        bw.newLine();
                        xrs2.next();
                        xrs2.close();
                        this.xconsultas.cerrarConexionBd();
                    }
                }
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            } catch (IOException ex2) {
                Logger.getLogger(JIFExportarDatosTipoDoc.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                try {
                    bw.close();
                } catch (IOException ex3) {
                    Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
                }
            } catch (SQLException ex4) {
                Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex4);
                try {
                    bw.close();
                } catch (IOException ex5) {
                    Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex5);
                }
            }
        } catch (Throwable th) {
            try {
                bw.close();
            } catch (IOException ex6) {
                Logger.getLogger(JIFGeneracionDisfon.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex6);
            }
            throw th;
        }
    }

    private void mActualizarEstado(String xid) {
        String sql = "update cc_documentoc set ExportadoC=1 where Id='" + xid + "'";
        ConsultasMySQL xct = new ConsultasMySQL();
        xct.ejecutarSQL(sql);
        xct.cerrarConexionBd();
    }
}
