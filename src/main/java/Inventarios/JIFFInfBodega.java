package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFFInfBodega.class */
public class JIFFInfBodega extends JInternalFrame {
    private String xNombre;
    private String[] xIdBodega;
    private DefaultTableModel xmodeloEvidencia;
    private DefaultTableModel xmodeloEx;
    private Object[] xdatos;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JTable JTDetalle;
    private JTable JTDetalleEx;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    Metodos xmt = new Metodos();

    public JIFFInfBodega(String xNombre) {
        initComponents();
        this.xNombre = xNombre;
        if (this.xNombre.equals("UltimaRotacion")) {
            setTitle("Productos con ultima fecha de rotación".toUpperCase());
        }
        mLLenaCombo();
    }

    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBBodega = new JComboBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalleEx = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifRotacionBodega");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBodega.addItemListener(new ItemListener() { // from class: Inventarios.JIFFInfBodega.1
            public void itemStateChanged(ItemEvent evt) {
                JIFFInfBodega.this.JCBBodegaItemStateChanged(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 761, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBBodega, 0, 741, 32767).addContainerGap())));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 65, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JCBBodega, -1, 50, 32767).addGap(8, 8, 8))));
        this.jTabbedPane1.setForeground(Color.red);
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jTabbedPane1.addTab("ULTIMA ROTACIÓN", this.jScrollPane1);
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleEx.setFont(new Font("Arial", 1, 12));
        this.JTDetalleEx.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleEx.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleEx.setSelectionForeground(Color.red);
        this.jScrollPane2.setViewportView(this.JTDetalleEx);
        this.jTabbedPane1.addTab("PRODUCTOS CON EXISTENCIA", this.jScrollPane2);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFFInfBodega.2
            public void mouseClicked(MouseEvent evt) {
                JIFFInfBodega.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFFInfBodega.3
            public void actionPerformed(ActionEvent evt) {
                JIFFInfBodega.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jTabbedPane1).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 297, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -1, 390, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBodegaItemStateChanged(ItemEvent evt) {
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
        mExportarInformacionG8();
    }

    private void mExportarInformacionG8() {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                        sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
                    }
                    int y = 1;
                    for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                        sheet.addCell(new Label(0, y, this.xmodeloEvidencia.getValueAt(x2, 0).toString()));
                        sheet.addCell(new Label(1, y, this.xmodeloEvidencia.getValueAt(x2, 1).toString()));
                        sheet.addCell(new Label(2, y, this.xmodeloEvidencia.getValueAt(x2, 2).toString()));
                        sheet.addCell(new Label(3, y, this.xmodeloEvidencia.getValueAt(x2, 3).toString()));
                        sheet.addCell(new Label(4, y, this.xmodeloEvidencia.getValueAt(x2, 4).toString()));
                        sheet.addCell(new Label(5, y, this.xmodeloEvidencia.getValueAt(x2, 5).toString()));
                        sheet.addCell(new Label(6, y, this.xmodeloEvidencia.getValueAt(x2, 6).toString()));
                        y++;
                    }
                    WritableSheet sheet2 = workbook.createSheet("Detalle", 1);
                    for (int x3 = 0; x3 < this.JTDetalleEx.getColumnCount(); x3++) {
                        sheet2.addCell(new Label(x3, 0, this.JTDetalleEx.getColumnName(x3)));
                    }
                    int z = 1;
                    for (int x4 = 0; x4 < this.JTDetalleEx.getRowCount(); x4++) {
                        sheet2.addCell(new Label(0, z, this.xmodeloEx.getValueAt(x4, 0).toString()));
                        sheet2.addCell(new Label(1, z, this.xmodeloEx.getValueAt(x4, 1).toString()));
                        sheet2.addCell(new Label(2, z, this.xmodeloEx.getValueAt(x4, 2).toString()));
                        sheet2.addCell(new Label(3, z, this.xmodeloEx.getValueAt(x4, 3).toString()));
                        sheet2.addCell(new Label(4, z, this.xmodeloEx.getValueAt(x4, 4).toString()));
                        sheet2.addCell(new Label(5, z, this.xmodeloEx.getValueAt(x4, 5).toString()));
                        sheet2.addCell(new Label(6, z, this.xmodeloEx.getValueAt(x4, 6).toString()));
                        sheet2.addCell(new Number(7, z, Long.valueOf(this.xmodeloEx.getValueAt(x4, 7).toString()).longValue()));
                        sheet2.addCell(new Number(8, z, Double.valueOf(this.xmodeloEx.getValueAt(x4, 8).toString()).doubleValue()));
                        sheet2.addCell(new Number(9, z, Double.valueOf(this.xmodeloEx.getValueAt(x4, 9).toString()).doubleValue()));
                        z++;
                    }
                    workbook.write();
                    workbook.close();
                } catch (WriteException e) {
                    Logger.getLogger(JIFFInfBodega.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex) {
                    Logger.getLogger(JIFFInfBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloUltRotacion() {
        this.xmodeloEvidencia = new DefaultTableModel(new Object[0], new String[]{"Id", "Cod. Barra", "Producto", "Pres. Comercial", "Pres. Farmaceutica", "Laboratorio", "F.Ult.Rotación"}) { // from class: Inventarios.JIFFInfBodega.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloEvidencia);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mBuscaRotacion() {
        mModeloUltRotacion();
        String sql = "SELECT\n    `i_suministro`.`Id`\n    , `i_suministro`.`CodBarraUnidad`\n    , `i_suministro`.`Nbre` AS `NProducto`\n    , `i_presentacioncomercial`.`Nbre` AS `NPComercial`\n    , `i_presentacionfarmaceutica`.`Nbre` AS `NPFarmaceutica`\n    , `i_laboratorio`.`Nbre` AS `NLaboratorio`\n    , IF(`i_suministroxbodega`.`FechaUR` IS NULL,'',`i_suministroxbodega`.`FechaUR`) AS FechaUR \nFROM\n     `i_suministroxbodega`\n    INNER JOIN  `i_suministro` \n        ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\nWHERE (`i_suministroxbodega`.`IdBodega` ='" + this.xIdBodega[this.JCBBodega.getSelectedIndex()] + "')\nORDER BY `NProducto` ASC;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloEvidencia.addRow(this.xdatos);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("CodBarraUnidad"), n, 1);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("NProducto"), n, 2);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("NPComercial"), n, 3);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("NPFarmaceutica"), n, 4);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("NLaboratorio"), n, 5);
                    this.xmodeloEvidencia.setValueAt(xrs.getString("FechaUR"), n, 6);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInfBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloExistencia() {
        this.xmodeloEx = new DefaultTableModel(new Object[0], new String[]{"Id", "Cod. Barra", "Producto", "Pres. Comercial", "Pres. Farmaceutica", "Laboratorio", "F.Ult.Rotación", "Cantidad", "ValorUnitario", "Valor Total"}) { // from class: Inventarios.JIFFInfBodega.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleEx.setModel(this.xmodeloEx);
        this.JTDetalleEx.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleEx.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleEx.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleEx.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleEx.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalleEx.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleEx.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalleEx.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalleEx.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalleEx.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    private void mBuscaExistencia() {
        mModeloExistencia();
        String sql = "SELECT\n    `i_suministro`.`Id`\n    , `i_suministro`.`CodBarraUnidad`\n    , `i_suministro`.`Nbre` AS `NProducto`\n    , `i_presentacioncomercial`.`Nbre` AS `NPComercial`\n    , `i_presentacionfarmaceutica`.`Nbre` AS `NPFarmaceutica`\n    , `i_laboratorio`.`Nbre` AS `NLaboratorio`\n    ,  IF(`i_suministroxbodega`.`FechaUR` IS NULL,'',`i_suministroxbodega`.`FechaUR`) AS FechaUR \n    , SUM(`i_suministroxlotexbodega`.`Cantidad`) AS `Cantidad`\n    , i_suministroxbodega.`Costo` AS VUnitario,  ( i_suministroxbodega.`Costo`* SUM(`i_suministroxlotexbodega`.`Cantidad`)) AS VTotal\n FROM\n     `i_suministroxbodega`\n    INNER JOIN  `i_suministro` \n        ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN  `i_presentacioncomercial` \n        ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`)\n    INNER JOIN  `i_presentacionfarmaceutica` \n        ON (`i_suministro`.`IdPresentacionFarmaceutica` = `i_presentacionfarmaceutica`.`Id`)\n    INNER JOIN  `i_laboratorio` \n        ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`)\n    INNER JOIN  `i_suministroxlotexbodega` \n        ON (`i_suministroxlotexbodega`.`Id` = `i_suministroxbodega`.`Id`)\nWHERE (`i_suministroxbodega`.`IdBodega` ='" + this.xIdBodega[this.JCBBodega.getSelectedIndex()] + "')\nGROUP BY `i_suministro`.`Id`\nHAVING (`Cantidad` <>0)\nORDER BY `NProducto` ASC;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloEx.addRow(this.xdatos);
                    this.xmodeloEx.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodeloEx.setValueAt(xrs.getString("CodBarraUnidad"), n, 1);
                    this.xmodeloEx.setValueAt(xrs.getString("NProducto"), n, 2);
                    this.xmodeloEx.setValueAt(xrs.getString("NPComercial"), n, 3);
                    this.xmodeloEx.setValueAt(xrs.getString("NPFarmaceutica"), n, 4);
                    this.xmodeloEx.setValueAt(xrs.getString("NLaboratorio"), n, 5);
                    this.xmodeloEx.setValueAt(xrs.getString("FechaUR"), n, 6);
                    this.xmodeloEx.setValueAt(Integer.valueOf(xrs.getInt("Cantidad")), n, 7);
                    this.xmodeloEx.setValueAt(Double.valueOf(xrs.getDouble("VUnitario")), n, 8);
                    this.xmodeloEx.setValueAt(Double.valueOf(xrs.getDouble("VTotal")), n, 9);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFInfBodega.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLLenaCombo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xIdBodega = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM  `i_bodegas` WHERE Estado=0 ORDER BY Nbre ASC", this.xIdBodega, this.JCBBodega);
        this.xct.cerrarConexionBd();
        this.JCBBodega.setSelectedIndex(-1);
    }

    public void mBuscar() {
        if (this.JCBBodega.getSelectedIndex() > -1) {
            mBuscaRotacion();
            mBuscaExistencia();
        }
    }
}
