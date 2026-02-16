package Salud_Ocupacional;

import Utilidades.ConsultasMySQL;
import Utilidades.JTableX;
import Utilidades.Metodos;
import Utilidades.RowEditorModel;
import java.awt.Color;
import java.awt.Component;
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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFCMan_Power.class */
public class JIFCMan_Power extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelocombo;
    private Object[] xdatos;
    private String xsql;
    private String xsql1;
    private String[] xidperiodo;
    private String[] xidclasificacion;
    private JTableX JTDetalleCombo;
    private JTable tabla_combo;
    private JButton JBTClasificacion;
    private JButton JBTExportar;
    private JComboBox JCBPeriodo;
    private JCheckBox JCHAdministrativos;
    private JCheckBox JCHEspecial;
    private JCheckBox JCHPExpuestos;
    private JLabel JLBNTrabajadores;
    private JPanel JPIDatosC;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    private JTable JTBConsolidado;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private RowEditorModel rm = new RowEditorModel();
    private ArrayList editors = new ArrayList();

    public JIFCMan_Power() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JBTClasificacion = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JSPConsolidado = new JScrollPane();
        this.JTBConsolidado = new JTable();
        this.JCHEspecial = new JCheckBox();
        this.JCHPExpuestos = new JCheckBox();
        this.JCHAdministrativos = new JCheckBox();
        this.JLBNTrabajadores = new JLabel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("CLASIFICACIÓN DE MANPOWER (De acuerdo a los factores de exposicion por seg)");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifc_man_power");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBPeriodo.addItemListener(new ItemListener() { // from class: Salud_Ocupacional.JIFCMan_Power.1
            public void itemStateChanged(ItemEvent evt) {
                JIFCMan_Power.this.JCBPeriodoItemStateChanged(evt);
            }
        });
        this.JBTClasificacion.setFont(new Font("Arial", 1, 12));
        this.JBTClasificacion.setForeground(Color.red);
        this.JBTClasificacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTClasificacion.setText("Clasificación SO");
        this.JBTClasificacion.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFCMan_Power.2
            public void actionPerformed(ActionEvent evt) {
                JIFCMan_Power.this.JBTClasificacionActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeriodo, -2, 204, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTClasificacion, -2, 232, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodo, -2, 50, -2).addComponent(this.JBTClasificacion, -2, 59, -2)).addContainerGap(-1, 32767)));
        this.JTPDatos.setForeground(new Color(255, 0, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JTPDatos.addTab("DETALLE", this.JSPDetalle);
        this.JTBConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTBConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBConsolidado.setRowHeight(25);
        this.JTBConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBConsolidado.setSelectionForeground(new Color(255, 0, 0));
        this.JSPConsolidado.setViewportView(this.JTBConsolidado);
        this.JTPDatos.addTab("CONSOLIDADO", this.JSPConsolidado);
        this.JCHEspecial.setBackground(new Color(251, 54, 54));
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setSelected(true);
        this.JCHEspecial.setText("Especiales");
        this.JCHPExpuestos.setBackground(Color.yellow);
        this.JCHPExpuestos.setFont(new Font("Arial", 1, 12));
        this.JCHPExpuestos.setSelected(true);
        this.JCHPExpuestos.setText("Potencialmente Expuesto");
        this.JCHAdministrativos.setBackground(new Color(133, 218, 160));
        this.JCHAdministrativos.setFont(new Font("Arial", 1, 12));
        this.JCHAdministrativos.setSelected(true);
        this.JCHAdministrativos.setText("Administrativos");
        this.JLBNTrabajadores.setFont(new Font("Arial", 1, 16));
        this.JLBNTrabajadores.setHorizontalAlignment(0);
        this.JLBNTrabajadores.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Trabajadores", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFCMan_Power.3
            public void mouseClicked(MouseEvent evt) {
                JIFCMan_Power.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFCMan_Power.4
            public void actionPerformed(ActionEvent evt) {
                JIFCMan_Power.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosC, -1, -1, 32767).addComponent(this.JTPDatos).addGroup(layout.createSequentialGroup().addComponent(this.JCHEspecial, -2, 175, -2).addGap(18, 18, 18).addComponent(this.JCHPExpuestos, -2, 175, -2).addGap(18, 18, 18).addComponent(this.JCHAdministrativos, -2, 175, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 323, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 275, 32767).addComponent(this.JLBNTrabajadores, -2, 118, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatos, -1, 426, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 53, -2).addComponent(this.JLBNTrabajadores, GroupLayout.Alignment.LEADING, -2, 50, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEspecial).addComponent(this.JCHPExpuestos).addComponent(this.JCHAdministrativos)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBPeriodo.getSelectedIndex() != -1) {
            mModeloDatosCombo();
            mCrearModeloC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTClasificacionActionPerformed(ActionEvent evt) {
        if (this.tabla_combo.getRowCount() != -1) {
            for (int x = 0; x < this.tabla_combo.getRowCount(); x++) {
                if (Long.valueOf(this.xmodelocombo.getValueAt(x, 5).toString()).longValue() == 1) {
                    this.xsql = "UPDATE so_manporwer_detalle SET Id_Clasificacion=3 where Id='" + this.xmodelocombo.getValueAt(x, 9) + "'";
                } else if (Long.valueOf(this.xmodelocombo.getValueAt(x, 8).toString()).longValue() == 0) {
                    this.xsql = "UPDATE so_manporwer_detalle SET Id_Clasificacion=2 where Id='" + this.xmodelocombo.getValueAt(x, 9) + "'";
                } else {
                    this.xsql = "UPDATE so_manporwer_detalle SET Id_Clasificacion=4 where Id='" + this.xmodelocombo.getValueAt(x, 9) + "'";
                }
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
            mLLenaTablaconCombo();
        }
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
            if (this.tabla_combo.getRowCount() > -1) {
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

    public void mBuscar() {
        if (this.xlleno && this.JCBPeriodo.getSelectedIndex() != -1) {
            mLLenaTablaconCombo();
            mCargarDatosTablaC();
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBPeriodo.removeAllItems();
        this.xsql = "SELECT `cc_periodo_financiero`.`Id`, `cc_periodo_financiero`.`Nbre` FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) WHERE (`so_manporwer_encabezado`.`Estado` =1) GROUP BY `cc_periodo_financiero`.`Id` ORDER BY `cc_periodo_financiero`.`FechaI` DESC ";
        this.xidperiodo = this.xct.llenarCombo(this.xsql, this.xidperiodo, this.JCBPeriodo);
        this.JCBPeriodo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mCrearModeloC();
        mModeloDatosCombo();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloDatosCombo() {
        String[] columnNames = {"Id_Persona", "CC", "Nombre Usuario", "FEntrada", "Unidad", "Id_Seg", "NSeg", "Clasificación", "Tipo", "Id_Manpower", "Id_Clas"};
        this.xmodelocombo = new DefaultTableModel(new Object[0], columnNames) { // from class: Salud_Ocupacional.JIFCMan_Power.5
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, JComboBox.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla_combo = new JTable(this.xmodelocombo) { // from class: Salud_Ocupacional.JIFCMan_Power.6
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 7 && row < JIFCMan_Power.this.tabla_combo.getRowCount()) {
                    return (TableCellEditor) JIFCMan_Power.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        this.tabla_combo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.tabla_combo.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.tabla_combo.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.tabla_combo.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(5).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(5).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.tabla_combo.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.tabla_combo.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(8).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(8).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(9).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(9).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(10).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JSPDetalle.getViewport().add(this.tabla_combo);
    }

    private void mLLenaTablaconCombo() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            this.xsql = "SELECT `persona`.`Id_persona`, `so_manporwer_detalle`.`Cedula`, `persona`.`NUsuario`, `so_manporwer_detalle`.`FEntrada`, `so_manporwer_detalle`.`UnidadN`, `so_tipo_segmento`.`Id`, `so_tipo_segmento`.`Nbre`, `so_tipo_clasificacion`.`Nbre`, `so_tipo_segmento`.`Tipo`, so_manporwer_detalle.`Id`, `so_tipo_clasificacion`.`Id` FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `persona`  ON (`persona`.`Id_persona` = `so_manporwer_detalle`.`Id_Persona`) INNER JOIN `g_usuario`  ON (`persona`.`Id_persona` = `g_usuario`.`Id_persona`) INNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) INNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) WHERE (`so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "') ORDER BY `so_manporwer_detalle`.`UnidadN` ASC, `so_tipo_segmento`.`Nbre` ASC, `persona`.`NUsuario` ASC  ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mModeloDatosCombo();
            try {
                int n = 0;
                if (xrs.next()) {
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        this.xmodelocombo.addRow(this.xdatos);
                        this.xmodelocombo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                        this.xmodelocombo.setValueAt(xrs.getString(2), n, 1);
                        this.xmodelocombo.setValueAt(xrs.getString(3), n, 2);
                        this.xmodelocombo.setValueAt(xrs.getString(4), n, 3);
                        this.xmodelocombo.setValueAt(xrs.getString(5), n, 4);
                        this.xmodelocombo.setValueAt(Integer.valueOf(xrs.getInt(6)), n, 5);
                        this.xmodelocombo.setValueAt(xrs.getString(7), n, 6);
                        DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo());
                        this.editors.add(defaultCellEditor);
                        this.xmodelocombo.setValueAt(xrs.getString(8), n, 7);
                        this.xmodelocombo.setValueAt(Integer.valueOf(xrs.getInt(9)), n, 8);
                        this.xmodelocombo.setValueAt(Integer.valueOf(xrs.getInt(10)), n, 9);
                        this.xmodelocombo.setValueAt(Integer.valueOf(xrs.getInt(11)), n, 10);
                        this.tabla_combo.setDefaultRenderer(Object.class, new MiRender());
                        n++;
                    }
                }
                this.JLBNTrabajadores.setText("" + n);
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCMan_Power.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private JComboBox mLlenaComboModelo() {
        JComboBox xcomboBox = new JComboBox();
        xcomboBox.removeAllItems();
        ConsultasMySQL xct1 = new ConsultasMySQL();
        this.xidclasificacion = xct1.llenarCombo("SELECT `Id`, `Nbre` FROM `so_tipo_clasificacion` ORDER BY `Nbre` ASC", this.xidclasificacion, xcomboBox);
        xcomboBox.setSelectedIndex(-1);
        xct1.cerrarConexionBd();
        return xcomboBox;
    }

    /* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFCMan_Power$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(JIFCMan_Power.this.tabla_combo.getValueAt(row, 10).toString()).longValue() == 4) {
                cell.setBackground(new Color(251, 54, 54));
            } else if (Long.valueOf(JIFCMan_Power.this.tabla_combo.getValueAt(row, 10).toString()).longValue() == 3) {
                cell.setBackground(new Color(133, 218, 160));
            } else {
                cell.setBackground(Color.YELLOW);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloC() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Unidad", "Clasificación", "Cantidad", "%"}) { // from class: Salud_Ocupacional.JIFCMan_Power.7
            Class[] types = {String.class, String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBConsolidado.setModel(this.xmodelo);
        this.JTBConsolidado.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTBConsolidado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBConsolidado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTBConsolidado.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarDatosTablaC() {
        try {
            mCrearModeloC();
            this.xsql1 = "SELECT `so_manporwer_detalle`.`UnidadN`,`so_tipo_clasificacion`.`Nbre`, COUNT(`so_tipo_clasificacion`.`Nbre`) AS Cant FROM `so_manporwer_detalle`  INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)  INNER JOIN `persona`  ON (`persona`.`Id_persona` = `so_manporwer_detalle`.`Id_Persona`)  INNER JOIN `g_usuario`  ON (`persona`.`Id_persona` = `g_usuario`.`Id_persona`)  INNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`)  INNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) WHERE (`so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')  GROUP BY `so_manporwer_detalle`.`UnidadN`, `so_tipo_clasificacion`.`Nbre` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC, `so_tipo_clasificacion`.`Nbre` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql1);
            int x = 0;
            DecimalFormat xformato = new DecimalFormat("###.##");
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), x, 2);
                    double xvalor = (xrs.getLong(3) / Double.valueOf(this.JLBNTrabajadores.getText()).doubleValue()) * 100.0d;
                    this.xmodelo.setValueAt(Double.valueOf(xformato.format(xvalor).replaceAll(",", ".")), x, 3);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("Detalle", 0);
                for (int x = 0; x < this.tabla_combo.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.tabla_combo.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.tabla_combo.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.tabla_combo.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.tabla_combo.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.tabla_combo.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.tabla_combo.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.tabla_combo.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.tabla_combo.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.tabla_combo.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.tabla_combo.getValueAt(x2, 7).toString()));
                    sheet.addCell(new Label(8, x2 + 1, this.tabla_combo.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.tabla_combo.getValueAt(x2, 9).toString()));
                    sheet.addCell(new Label(10, x2 + 1, this.tabla_combo.getValueAt(x2, 10).toString()));
                }
                WritableSheet sheet2 = workbook.createSheet("Consolidado", 1);
                for (int x3 = 0; x3 < this.JTBConsolidado.getColumnCount(); x3++) {
                    sheet2.addCell(new Label(x3, 0, this.JTBConsolidado.getColumnName(x3)));
                }
                for (int x4 = 0; x4 < this.JTBConsolidado.getRowCount(); x4++) {
                    sheet2.addCell(new Label(0, x4 + 1, this.xmodelo.getValueAt(x4, 0).toString()));
                    sheet2.addCell(new Label(1, x4 + 1, this.xmodelo.getValueAt(x4, 1).toString()));
                    sheet2.addCell(new Number(2, x4 + 1, Long.valueOf(this.xmodelo.getValueAt(x4, 2).toString()).longValue()));
                    sheet2.addCell(new Number(3, x4 + 1, Double.valueOf(this.xmodelo.getValueAt(x4, 3).toString()).doubleValue()));
                }
                workbook.write();
                workbook.close();
            } catch (IOException ex) {
                Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        }
    }
}
