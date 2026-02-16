package Sig;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFInformesSupersalud.class */
public class JIFInformesSupersalud extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private String[][] xidindicador;
    private String[][] xidperiodo;
    private String xsql;
    private Object[] xdato;
    private ButtonGroup JBGTipo;
    private JButton JBTExportar;
    private JComboBox JCBIdicador;
    private JComboBox JCBPeriodo;
    private JPanel JPIDExportar;
    private JPanel JPIDatosB;
    private JRadioButton JRBExcel;
    private JRadioButton JRBTxT;
    private JScrollPane JSPDetalleC;
    private JTable JTDetalleC;
    private JTextField JTFRuta;
    private JYearChooser JYAno;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private String xnombrearchivo = "";

    public JIFInformesSupersalud() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.JPIDatosB = new JPanel();
        this.JCBIdicador = new JComboBox();
        this.JCBPeriodo = new JComboBox();
        this.JYAno = new JYearChooser();
        this.JSPDetalleC = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JPIDExportar = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JRBExcel = new JRadioButton();
        this.JRBTxT = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMACIÓN SUPER SALUD");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformesupersalud");
        this.JPIDatosB.setBorder(BorderFactory.createTitledBorder((Border) null, "DATO CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBIdicador.setFont(new Font("Arial", 1, 12));
        this.JCBIdicador.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Indicador", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JYAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosBLayout = new GroupLayout(this.JPIDatosB);
        this.JPIDatosB.setLayout(JPIDatosBLayout);
        JPIDatosBLayout.setHorizontalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBIdicador, -2, 651, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBPeriodo, -2, 284, -2).addGap(18, 18, 18).addComponent(this.JYAno, -2, 82, -2).addContainerGap(-1, 32767)));
        JPIDatosBLayout.setVerticalGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JYAno, GroupLayout.Alignment.LEADING, 0, 0, 32767).addComponent(this.JCBIdicador, GroupLayout.Alignment.LEADING, -1, 50, 32767).addComponent(this.JCBPeriodo, GroupLayout.Alignment.LEADING, -1, 50, 32767)).addContainerGap(-1, 32767)));
        this.JSPDetalleC.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleC.setEditingColumn(1);
        this.JTDetalleC.setEditingRow(1);
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(Color.red);
        this.JTDetalleC.setSelectionMode(0);
        this.JSPDetalleC.setViewportView(this.JTDetalleC);
        this.JPIDExportar.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFInformesSupersalud.1
            public void mouseClicked(MouseEvent evt) {
                JIFInformesSupersalud.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFInformesSupersalud.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformesSupersalud.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBGTipo.add(this.JRBExcel);
        this.JRBExcel.setFont(new Font("Arial", 1, 12));
        this.JRBExcel.setSelected(true);
        this.JRBExcel.setText("Excel");
        this.JBGTipo.add(this.JRBTxT);
        this.JRBTxT.setFont(new Font("Arial", 1, 12));
        this.JRBTxT.setText("Texto");
        GroupLayout JPIDExportarLayout = new GroupLayout(this.JPIDExportar);
        this.JPIDExportar.setLayout(JPIDExportarLayout);
        JPIDExportarLayout.setHorizontalGroup(JPIDExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDExportarLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBExcel).addGap(18, 18, 18).addComponent(this.JRBTxT).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, 32767).addComponent(this.JTFRuta, -2, 725, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 128, -2).addContainerGap()));
        JPIDExportarLayout.setVerticalGroup(JPIDExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDExportarLayout.createSequentialGroup().addContainerGap().addGroup(JPIDExportarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDExportarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JRBExcel).addComponent(this.JRBTxT)).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(12, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleC, GroupLayout.Alignment.TRAILING, -1, 1081, 32767).addComponent(this.JPIDExportar, -1, -1, 32767).addComponent(this.JPIDatosB, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosB, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleC, -1, 374, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDExportar, -2, -1, -2).addContainerGap()));
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
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.JRBExcel.isSelected()) {
                        mExportarDExcel();
                        return;
                    } else {
                        mGenerarArchivoTexto();
                        return;
                    }
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBIdicador.removeAllItems();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            this.xsql = "SELECT s_sgc_i_fichatecnica.Id,CONCAT(s_sgc_i_fichatecnica.Codigo,' - ', s_sgc_i_fichatecnica.Descripcion) AS NIndicador, s_sgc_i_fichatecnica.Codigo, s_sgc_i_fichatecnica.EncabezadoTabla FROM s_sgc_i_fichatecnica_tipoindicador INNER JOIN s_sgc_i_fichatecnica  ON (s_sgc_i_fichatecnica_tipoindicador.Id_fichatecnicai = s_sgc_i_fichatecnica.Id) WHERE (s_sgc_i_fichatecnica.Id_TipoProceso ='" + Principal.informacionGeneralPrincipalDTO.getIdTipoProceso() + "') ";
        } else {
            this.xsql = "SELECT s_sgc_i_fichatecnica.Id,CONCAT(s_sgc_i_fichatecnica.Codigo,' - ', s_sgc_i_fichatecnica.Descripcion) AS NIndicador, s_sgc_i_fichatecnica.Codigo, s_sgc_i_fichatecnica.EncabezadoTabla FROM s_sgc_i_fichatecnica_tipoindicador INNER JOIN s_sgc_i_fichatecnica  ON (s_sgc_i_fichatecnica_tipoindicador.Id_fichatecnicai = s_sgc_i_fichatecnica.Id) WHERE (s_sgc_i_fichatecnica.Id_TipoProceso =1) ";
        }
        this.xidindicador = this.xct.llenarComboyLista(this.xsql, this.xidindicador, this.JCBIdicador, 4);
        this.JCBIdicador.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JCBPeriodo.removeAllItems();
        this.xsql = "SELECT Id, NPerido, FechaI, FechaF, CodS  FROM cc_periodost WHERE (TipoS =1)";
        this.xidperiodo = this.xct.llenarComboyLista(this.xsql, this.xidperiodo, this.JCBPeriodo, 5);
        this.JCBPeriodo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion());
        mCrearTabla059();
    }

    public void mBuscar() {
        if (this.JCBIdicador.getSelectedIndex() != -1) {
            if (this.JCBPeriodo.getSelectedIndex() != -1) {
                if (this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("059")) {
                    mCargarDatos059();
                    return;
                }
                if (this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("060")) {
                    mCargarDatos060();
                    return;
                } else {
                    if (this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("057") || this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("058")) {
                        mCargarDatos057058();
                        return;
                    }
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBPeriodo.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el indicador", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCBIdicador.requestFocus();
    }

    private void mCrearTabla059() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Nit", "Dv", "PeriodoC", "Año", "TipoArchivo", "NitD", "DvD", "NombreD", "ClaseD", "V/CCnoVencidas", "V/CuentasMora", "V/Mora30", "V/Mora31-60", "V/Mora61-90", "V/Mora91-180", "V/Mora181-360", "V/Mora>360", "V/CGlosadas", "V/Conciliacion"}) { // from class: Sig.JIFInformesSupersalud.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(11).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(13).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(14).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(15).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(16).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(17).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(18).setPreferredWidth(10);
    }

    private void mCrearTabla057058() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Nit", "Dv", "PeriodoC", "Año", "TipoArchivo", "ClaseD", "Valor"}) { // from class: Sig.JIFInformesSupersalud.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(10);
    }

    private void mCrearTabla060() {
        this.xmodelo = new DefaultTableModel((Object[][]) null, new String[]{"Nit", "Dv", "PeriodoC", "Año", "TipoArchivo", "ClaseA", "NitA", "NombreA", "V/AcreencianoVencidas", "V/Acreencia31-60", "V/Acreencia61-90", "V/Acreencia91-180", "V/Acreencia181-360", "V/Acreencia>360"}) { // from class: Sig.JIFInformesSupersalud.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, true, true, false, false, true, true, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(11).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTDetalleC.getColumnModel().getColumn(13).setPreferredWidth(10);
    }

    private void mCargarDatos059() {
        mCrearTabla059();
        this.xsql = "SELECT g_ips.Identificacion , g_ips.DigitoVerificacion, s_sgc_i_fichatecnica.Codigo, cc_terceros.No_identificacion, IF( cc_terceros.Dig_Verificacion='',0, cc_terceros.Dig_Verificacion) AS DV , IF(cc_terceros.RazonSocial<>'', cc_terceros.RazonSocial, CONCAT(cc_terceros.Apellido1,' ',cc_terceros.Apellido2,' ', cc_terceros.Nombre1,' ',cc_terceros.Nombre2)) AS NEmpresa,  MID(cc_puc.Id,1,cc_puc.NCaracteresI) AS Cuenta, ROUND(((SUM(cc_detalle_documentoc.VDebito)-SUM(cc_detalle_documentoc.VCredito))/1000)) AS V,cc_terceros.Id, cc_terceros.EsManejoC  FROM g_ips,  cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc  ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_puc_tipo_indicador  ON (cc_puc_tipo_indicador.Id_Puc = cc_puc.Id) INNER JOIN s_sgc_i_fichatecnica  ON (cc_puc_tipo_indicador.Id_TipoFicha = s_sgc_i_fichatecnica.Id) INNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) WHERE ( cc_puc_tipo_indicador.Id_TipoFicha ='" + this.xidindicador[this.JCBIdicador.getSelectedIndex()][0] + "' AND cc_documentoc.Estado =1)GROUP BY NEmpresa, Cuenta ORDER BY Cuenta ASC, NEmpresa ASC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xnombrearchivo = xrs.getString(1) + xrs.getString(2) + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][3] + this.JYAno.getValue() + this.xidindicador[this.JCBIdicador.getSelectedIndex()][1];
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][3], xnfila, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(this.JYAno.getValue()), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(4), xnfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(5), xnfila, 6);
                    this.xmodelo.setValueAt(xrs.getString(6), xnfila, 7);
                    this.xmodelo.setValueAt(xrs.getString(7), xnfila, 8);
                    if (xrs.getBoolean(10)) {
                        this.xsql = "SELECT ROUND(SUM((f_liquidacion.TotalEps-(f_liquidacion.VGlosaNR+f_liquidacion.TPagado)))/1000) AS VTPago FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id) WHERE (g_empresa.Id ='" + xrs.getString(9) + "' AND f_factura_evento.EstaArmada =2 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) <1  ) HAVING (VTPago <>0 ) ";
                        this.xmodelo.setValueAt(Long.valueOf(mBuscarDatosCartera()), xnfila, 9);
                    } else {
                        this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), xnfila, 9);
                    }
                    this.xsql = "SELECT ROUND(SUM((f_liquidacion.TotalEps-(f_liquidacion.VGlosaNR+f_liquidacion.TPagado)))/1000) AS VTPago FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id) WHERE (g_empresa.Id ='" + xrs.getString(9) + "' AND f_factura_evento.EstaArmada =2 ) HAVING (VTPago <>0 ) ";
                    this.xmodelo.setValueAt(Long.valueOf(mBuscarDatosCartera()), xnfila, 10);
                    this.xsql = "SELECT ROUND(SUM((f_liquidacion.TotalEps-(f_liquidacion.VGlosaNR+f_liquidacion.TPagado)))/1000) AS VTPago FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id) WHERE (g_empresa.Id ='" + xrs.getString(9) + "' AND f_factura_evento.EstaArmada =2 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) >=1 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) <=30     ) HAVING (VTPago <>0 ) ";
                    this.xmodelo.setValueAt(Long.valueOf(mBuscarDatosCartera()), xnfila, 11);
                    this.xsql = "SELECT ROUND(SUM((f_liquidacion.TotalEps-(f_liquidacion.VGlosaNR+f_liquidacion.TPagado)))/1000) AS VTPago FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id) WHERE (g_empresa.Id ='" + xrs.getString(9) + "' AND f_factura_evento.EstaArmada =2 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) >30 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) <=60     ) HAVING (VTPago <>0 ) ";
                    this.xmodelo.setValueAt(Long.valueOf(mBuscarDatosCartera()), xnfila, 12);
                    this.xsql = "SELECT ROUND(SUM((f_liquidacion.TotalEps-(f_liquidacion.VGlosaNR+f_liquidacion.TPagado)))/1000) AS VTPago FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id) WHERE (g_empresa.Id ='" + xrs.getString(9) + "' AND f_factura_evento.EstaArmada =2 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) >60 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) <=90     ) HAVING (VTPago <>0 ) ";
                    this.xmodelo.setValueAt(Long.valueOf(mBuscarDatosCartera()), xnfila, 13);
                    this.xsql = "SELECT ROUND(SUM((f_liquidacion.TotalEps-(f_liquidacion.VGlosaNR+f_liquidacion.TPagado)))/1000) AS VTPago FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id) WHERE (g_empresa.Id ='" + xrs.getString(9) + "' AND f_factura_evento.EstaArmada =2 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) >90 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) <=180     ) HAVING (VTPago <>0 ) ";
                    this.xsql = "SELECT ROUND(SUM((f_liquidacion.TotalEps-(f_liquidacion.VGlosaNR+f_liquidacion.TPagado)))/1000) AS VTPago FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id) WHERE (g_empresa.Id ='" + xrs.getString(9) + "' AND f_factura_evento.EstaArmada =2 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) >180 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) <=360     ) HAVING (VTPago <>0 ) ";
                    this.xmodelo.setValueAt(Long.valueOf(mBuscarDatosCartera()), xnfila, 15);
                    this.xsql = "SELECT ROUND(SUM((f_liquidacion.TotalEps-(f_liquidacion.VGlosaNR+f_liquidacion.TPagado)))/1000) AS VTPago FROM f_factura_evento INNER JOIN f_liquidacion  ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id = f_liquidacion.IdEmpresaContxConv) INNER JOIN g_empresacont  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_empresa  ON (g_empresacont.Id_empresa = g_empresa.Id) WHERE (g_empresa.Id ='" + xrs.getString(9) + "' AND f_factura_evento.EstaArmada =2 AND IF((IF(g_empresacont.Id_TipoPlan=4,f_liquidacion.TotalPaciente,f_liquidacion.TotalEps )-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR))=0 ,0, IF(f_liquidacion.TotalEps-(f_liquidacion.TPagado+f_liquidacion.VGlosaNR)=0,0, IF(f_factura_evento.FechaRadicado IS NULL,0, IF(DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY))<0,0,DATEDIFF( NOW(), DATE_ADD(f_factura_evento.FechaRadicado, INTERVAL f_empresacontxconvenio.NDiasP DAY)) ) ) ) ) >360  ) HAVING (VTPago <>0 ) ";
                    this.xmodelo.setValueAt(Long.valueOf(mBuscarDatosCartera()), xnfila, 16);
                    this.xmodelo.setValueAt(new Integer(0), xnfila, 17);
                    this.xmodelo.setValueAt(new Integer(0), xnfila, 18);
                    xnfila++;
                }
                this.JTFRuta.setText(this.JTFRuta.getText() + "\\" + this.xnombrearchivo);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesSupersalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatos057058() {
        mCrearTabla057058();
        this.xsql = "SELECT g_ips.Identificacion, g_ips.DigitoVerificacion, s_sgc_i_fichatecnica.Codigo , MID(cc_puc_tipo_indicador.Id_Puc,1,cc_puc_tipo_indicador.NCaracteresI) AS Cuenta, cc_puc_tipo_indicador.DatosC, cc_puc_tipo_indicador.Id_Puc FROM g_ips,  cc_puc_tipo_indicador INNER JOIN cc_puc  ON (cc_puc_tipo_indicador.Id_Puc = cc_puc.Id) INNER JOIN s_sgc_i_fichatecnica  ON (cc_puc_tipo_indicador.Id_TipoFicha = s_sgc_i_fichatecnica.Id) WHERE (cc_puc_tipo_indicador.Id_TipoFicha ='" + this.xidindicador[this.JCBIdicador.getSelectedIndex()][0] + "' AND cc_puc_tipo_indicador.Estado=1) ORDER BY cc_puc_tipo_indicador.NOrden ASC";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xnombrearchivo = xrs.getString(1) + xrs.getString(2) + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][3] + this.JYAno.getValue() + this.xidindicador[this.JCBIdicador.getSelectedIndex()][1];
                xrs.beforeFirst();
                int xnfila = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][3], xnfila, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(this.JYAno.getValue()), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(4), xnfila, 5);
                    this.xsql = "SELECT IF( cc_puc.Tipo=1, ROUND( (SUM(cc_detalle_documentoc.VCredito)-SUM(cc_detalle_documentoc.VDebito))/1000) ,IF (MID(cc_detalle_documentoc.Id_Puc,1," + xrs.getString(4).length() + ")='4175',( ROUND(( SUM(cc_detalle_documentoc.VDebito)-SUM(cc_detalle_documentoc.VCredito))/1000))*-1 ,(ROUND((SUM(cc_detalle_documentoc.VDebito)-SUM(cc_detalle_documentoc.VCredito))/1000)))      )  AS Valor , MID(cc_detalle_documentoc.Id_Puc,1," + xrs.getString(4).length() + ")  FROM cc_detalle_documentoc  INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id)  INNER JOIN cc_puc  ON (cc_detalle_documentoc.Id_Puc = cc_puc.Id)  WHERE (cc_documentoc.Id =1 AND cc_detalle_documentoc.Id_Puc LIKE  '" + xrs.getString(6).substring(0, xrs.getInt(5)) + "%' AND cc_documentoc.Estado =1)  GROUP BY MID(cc_detalle_documentoc.Id_Puc,1," + xrs.getInt(5) + ")  ";
                    this.xmodelo.setValueAt(Long.valueOf(mBuscarDatosCartera()), xnfila, 6);
                    xnfila++;
                }
                this.JTFRuta.setText(this.JTFRuta.getText() + "\\" + this.xnombrearchivo);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesSupersalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatos060() {
        mCrearTabla060();
        int xnfila = 0;
        this.xsql = "SELECT g_ips.Identificacion, g_ips.DigitoVerificacion, s_sgc_i_fichatecnica.Codigo,IF(cc_terceros.Dig_Verificacion='',cc_terceros.No_identificacion, CONCAT(cc_terceros.No_identificacion,'-', cc_terceros.Dig_Verificacion)) AS NitA , IF(cc_terceros.RazonSocial<>'', cc_terceros.RazonSocial, CONCAT(cc_terceros.Apellido1,' ',cc_terceros.Apellido2,' ', cc_terceros.Nombre1,' ',cc_terceros.Nombre2)) AS NEmpresa , MID(cc_puc.Id,1,cc_puc.NCaracteresI) AS Cuenta , SUM(ROUND((cc_detalle_documentoc.VCredito-cc_detalle_documentoc.VDebito)/1000)) AS Valor  FROM g_ips,  cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc  ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_puc_tipo_indicador  ON (cc_puc_tipo_indicador.Id_Puc = cc_puc.Id) INNER JOIN s_sgc_i_fichatecnica  ON (cc_puc_tipo_indicador.Id_TipoFicha = s_sgc_i_fichatecnica.Id) INNER JOIN cc_terceros ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) INNER JOIN cc_tipo_impuesto  ON (cc_puc.Id_TipoImpuesto = cc_tipo_impuesto.Id) WHERE ( cc_puc_tipo_indicador.Id_TipoFicha ='" + this.xidindicador[this.JCBIdicador.getSelectedIndex()][0] + "' AND cc_documentoc.Estado =1 AND cc_tipo_impuesto.EsImpuestos =0) GROUP BY NEmpresa, Cuenta HAVING (Valor <>0) ORDER BY Cuenta ASC, NEmpresa ASC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.xnombrearchivo = xrs.getString(1) + xrs.getString(2) + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][3] + this.JYAno.getValue() + this.xidindicador[this.JCBIdicador.getSelectedIndex()][1];
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][3], xnfila, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(this.JYAno.getValue()), xnfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(3), xnfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), xnfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(4), xnfila, 6);
                    this.xmodelo.setValueAt(xrs.getString(5), xnfila, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), xnfila, 8);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 9);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 10);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 11);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 12);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 13);
                    xnfila++;
                }
                this.JTFRuta.setText(this.JTFRuta.getText() + "\\" + this.xnombrearchivo);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT g_ips.Identificacion, g_ips.DigitoVerificacion, s_sgc_i_fichatecnica.Codigo, '800197268-4' AS Nit, 'DIRECCION DE IMPUESTOS Y ADUANAS NACIONALES' AS NEmpresa, '24' AS Cuenta, ROUND(((SUM(cc_detalle_documentoc.VCredito)-SUM(cc_detalle_documentoc.VDebito))/1000)) AS Valor, cc_tipo_impuesto.Id , cc_tipo_impuesto.Id FROM g_ips, cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc  ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_puc_tipo_indicador  ON (cc_puc_tipo_indicador.Id_Puc = cc_puc.Id) INNER JOIN s_sgc_i_fichatecnica  ON (cc_puc_tipo_indicador.Id_TipoFicha = s_sgc_i_fichatecnica.Id) INNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) INNER JOIN cc_tipo_impuesto  ON (cc_puc.Id_TipoImpuesto = cc_tipo_impuesto.Id) WHERE (cc_documentoc.Id =1 AND cc_puc_tipo_indicador.Id_TipoFicha ='" + this.xidindicador[this.JCBIdicador.getSelectedIndex()][0] + "' AND cc_documentoc.Estado =1 AND cc_tipo_impuesto.Id IN(1,3)) GROUP BY Nit HAVING (Valor <>0) ORDER BY Cuenta ASC, NEmpresa ASC ";
            ResultSet xrs2 = this.xct.traerRs(this.xsql);
            if (xrs2.next()) {
                xrs2.beforeFirst();
                while (xrs2.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs2.getString(1), xnfila, 0);
                    this.xmodelo.setValueAt(xrs2.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][3], xnfila, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(this.JYAno.getValue()), xnfila, 3);
                    this.xmodelo.setValueAt(xrs2.getString(3), xnfila, 4);
                    this.xmodelo.setValueAt(xrs2.getString(6), xnfila, 5);
                    this.xmodelo.setValueAt(xrs2.getString(4), xnfila, 6);
                    this.xmodelo.setValueAt(xrs2.getString(5), xnfila, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs2.getLong(7)), xnfila, 8);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 9);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 10);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 11);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 12);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 13);
                    xnfila++;
                }
            }
            xrs2.close();
            this.xct.cerrarConexionBd();
            this.xsql = "SELECT g_ips.Identificacion, g_ips.DigitoVerificacion, s_sgc_i_fichatecnica.Codigo, '800096763-5' AS Nit, 'MUNICIPIO DE MONTELIBANO' AS NEmpresa, '24' AS Cuenta, ROUND(((SUM(cc_detalle_documentoc.VCredito)-SUM(cc_detalle_documentoc.VDebito))/1000)) AS Valor, cc_tipo_impuesto.Id , cc_tipo_impuesto.Id FROM g_ips, cc_detalle_documentoc INNER JOIN cc_documentoc  ON (cc_detalle_documentoc.Id_Documentoc = cc_documentoc.Id) INNER JOIN cc_puc  ON (cc_puc.Id = cc_detalle_documentoc.Id_Puc) INNER JOIN cc_puc_tipo_indicador  ON (cc_puc_tipo_indicador.Id_Puc = cc_puc.Id) INNER JOIN s_sgc_i_fichatecnica  ON (cc_puc_tipo_indicador.Id_TipoFicha = s_sgc_i_fichatecnica.Id) INNER JOIN cc_terceros  ON (cc_terceros.Id = cc_detalle_documentoc.Id_Tercero) INNER JOIN cc_tipo_impuesto  ON (cc_puc.Id_TipoImpuesto = cc_tipo_impuesto.Id) WHERE (cc_documentoc.Id =1 AND cc_puc_tipo_indicador.Id_TipoFicha ='" + this.xidindicador[this.JCBIdicador.getSelectedIndex()][0] + "' AND cc_documentoc.Estado =1 AND cc_tipo_impuesto.Id IN(2)) GROUP BY Nit HAVING (Valor <>0) ORDER BY Cuenta ASC, NEmpresa ASC ";
            ResultSet xrs3 = this.xct.traerRs(this.xsql);
            if (xrs3.next()) {
                xrs3.beforeFirst();
                while (xrs3.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs3.getString(1), xnfila, 0);
                    this.xmodelo.setValueAt(xrs3.getString(2), xnfila, 1);
                    this.xmodelo.setValueAt(this.xidperiodo[this.JCBPeriodo.getSelectedIndex()][3], xnfila, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(this.JYAno.getValue()), xnfila, 3);
                    this.xmodelo.setValueAt(xrs3.getString(3), xnfila, 4);
                    this.xmodelo.setValueAt(xrs3.getString(6), xnfila, 5);
                    this.xmodelo.setValueAt(xrs3.getString(4), xnfila, 6);
                    this.xmodelo.setValueAt(xrs3.getString(5), xnfila, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs3.getLong(7)), xnfila, 8);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 9);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 10);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 11);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 12);
                    this.xmodelo.setValueAt(new Long(0L), xnfila, 13);
                    xnfila++;
                }
            }
            xrs3.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesSupersalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public long mBuscarDatosCartera() {
        long xvalor = 0;
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                xvalor = xrs.getLong(1);
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesSupersalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalor;
    }

    private void mExportarDExcel() {
        try {
            this.xmt.mEliminarArchivo(new File(this.JTFRuta.getText() + ".xls"));
            WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
            WritableSheet sheet = workbook.createSheet("Datos", 0);
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
                if (!this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("058") && !this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("057")) {
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo.getValueAt(x2, 9).toString()));
                    sheet.addCell(new Label(10, x2 + 1, this.xmodelo.getValueAt(x2, 10).toString()));
                    sheet.addCell(new Label(11, x2 + 1, this.xmodelo.getValueAt(x2, 11).toString()));
                    sheet.addCell(new Label(12, x2 + 1, this.xmodelo.getValueAt(x2, 12).toString()));
                    sheet.addCell(new Label(13, x2 + 1, this.xmodelo.getValueAt(x2, 13).toString()));
                    if (this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("059")) {
                        sheet.addCell(new Label(14, x2 + 1, this.xmodelo.getValueAt(x2, 14).toString()));
                        sheet.addCell(new Label(15, x2 + 1, this.xmodelo.getValueAt(x2, 15).toString()));
                        sheet.addCell(new Label(16, x2 + 1, this.xmodelo.getValueAt(x2, 16).toString()));
                        sheet.addCell(new Label(17, x2 + 1, this.xmodelo.getValueAt(x2, 17).toString()));
                        sheet.addCell(new Label(18, x2 + 1, this.xmodelo.getValueAt(x2, 18).toString()));
                    }
                }
            }
            workbook.write();
            workbook.close();
        } catch (WriteException e) {
            Logger.getLogger(JIFInformesSupersalud.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (IOException ex) {
            Logger.getLogger(JIFInformesSupersalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGenerarArchivoTexto() {
        this.xmt.mEliminarArchivo(new File(this.JTFRuta.getText() + ".txt"));
        try {
            FileWriter fw = new FileWriter(this.JTFRuta.getText() + ".txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter salArch = new PrintWriter(bw);
            for (int x = 0; x < this.JTDetalleC.getRowCount(); x++) {
                if (this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("059")) {
                    salArch.println(this.xmodelo.getValueAt(x, 0).toString() + "," + this.xmodelo.getValueAt(x, 1) + "," + this.xmodelo.getValueAt(x, 2) + "," + this.xmodelo.getValueAt(x, 3) + "," + this.xmodelo.getValueAt(x, 4) + "," + this.xmodelo.getValueAt(x, 5) + "," + this.xmodelo.getValueAt(x, 6) + "," + this.xmodelo.getValueAt(x, 7) + "," + this.xmodelo.getValueAt(x, 8) + "," + this.xmodelo.getValueAt(x, 9) + "," + this.xmodelo.getValueAt(x, 10) + "," + this.xmodelo.getValueAt(x, 11) + "," + this.xmodelo.getValueAt(x, 12) + "," + this.xmodelo.getValueAt(x, 13) + "," + this.xmodelo.getValueAt(x, 14) + "," + this.xmodelo.getValueAt(x, 15) + "," + this.xmodelo.getValueAt(x, 16) + "," + this.xmodelo.getValueAt(x, 17) + "," + this.xmodelo.getValueAt(x, 18));
                } else if (this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("060")) {
                    salArch.println(this.xmodelo.getValueAt(x, 0).toString() + "," + this.xmodelo.getValueAt(x, 1) + "," + this.xmodelo.getValueAt(x, 2) + "," + this.xmodelo.getValueAt(x, 3) + "," + this.xmodelo.getValueAt(x, 4) + "," + this.xmodelo.getValueAt(x, 5) + "," + this.xmodelo.getValueAt(x, 6) + "," + this.xmodelo.getValueAt(x, 7) + "," + this.xmodelo.getValueAt(x, 8) + "," + this.xmodelo.getValueAt(x, 9) + "," + this.xmodelo.getValueAt(x, 10) + "," + this.xmodelo.getValueAt(x, 11) + "," + this.xmodelo.getValueAt(x, 12) + "," + this.xmodelo.getValueAt(x, 13));
                } else if (this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("058") || this.xidindicador[this.JCBIdicador.getSelectedIndex()][1].equals("057")) {
                    salArch.println(this.xmodelo.getValueAt(x, 0).toString() + "," + this.xmodelo.getValueAt(x, 1) + "," + this.xmodelo.getValueAt(x, 2) + "," + this.xmodelo.getValueAt(x, 3) + "," + this.xmodelo.getValueAt(x, 4) + "," + this.xmodelo.getValueAt(x, 5) + "," + this.xmodelo.getValueAt(x, 6));
                }
            }
            salArch.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(JIFInformesSupersalud.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
