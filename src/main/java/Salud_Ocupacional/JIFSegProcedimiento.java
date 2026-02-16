package Salud_Ocupacional;

import Acceso.Principal;
import ParametrizacionN.JIFGenerico1CheckBox;
import Utilidades.ConsultasMySQL;
import Utilidades.WorkerSQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFSegProcedimiento.class */
public class JIFSegProcedimiento extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloE;
    private Object[] xdato;
    private String[] xSeg;
    private String[] xProce;
    private String[] xPeriodo;
    private File xfile;
    private WorkerSQL xWorkerSQL;
    private JComboBox JCBPeriodo;
    private JComboBox JCBProcedimiento;
    private JComboBox JCBSeg;
    private JCheckBox JCHEstado;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPEncabezado;
    private JScrollPane JSPObs;
    private JSpinner JSPPeriodo;
    private JTextArea JTAObs;
    private JTable JTConsolidado;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JButton jButton1;
    private JButton jButton2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private long xestado = 1;
    private long g = 0;

    public JIFSegProcedimiento() {
        initComponents();
        mBuscaEncabezado();
        mIniciaCombos();
    }

    public void mNuevo() {
        this.JCBSeg.setSelectedIndex(-1);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.JSPPeriodo.setValue(0);
        this.JTAObs.setText("");
        this.JCHEstado.setSelected(true);
        this.JTFRuta.setText("");
        this.xestado = 1L;
        this.g = 0L;
    }

    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBSeg = new JComboBox();
        this.JCBProcedimiento = new JComboBox();
        this.JSPPeriodo = new JSpinner();
        this.JSPObs = new JScrollPane();
        this.JTAObs = new JTextArea();
        this.JCHEstado = new JCheckBox();
        this.JCBPeriodo = new JComboBox();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JSPEncabezado = new JScrollPane();
        this.JTConsolidado = new JTable();
        this.jButton2 = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.jButton1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SEG PROCEDIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifsegprocedimiento");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBSeg.setFont(new Font("Arial", 1, 12));
        this.JCBSeg.setBorder(BorderFactory.createTitledBorder((Border) null, "SEG", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPeriodo.setFont(new Font("Arial", 1, 12));
        this.JSPPeriodo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObs.setColumns(1);
        this.JTAObs.setFont(new Font("Arial", 1, 12));
        this.JTAObs.setLineWrap(true);
        this.JTAObs.setRows(1);
        this.JTAObs.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObs.setViewportView(this.JTAObs);
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSegProcedimiento.1
            public void actionPerformed(ActionEvent evt) {
                JIFSegProcedimiento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Periodo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPPeriodo, -2, 91, -2).addGap(16, 16, 16).addComponent(this.JSPObs)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 268, -2).addGap(44, 44, 44).addComponent(this.JCBSeg, 0, -1, 32767)).addComponent(this.JCBProcedimiento, 0, -1, 32767)).addGap(18, 18, 18).addComponent(this.JCHEstado).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSeg, -2, -1, -2).addComponent(this.JCBPeriodo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBProcedimiento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPPeriodo, -2, -1, -2).addComponent(this.JSPObs, -2, 60, -2))).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHEstado).addGap(0, 0, 32767)))));
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(Color.red);
        this.JTConsolidado.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFSegProcedimiento.2
            public void mouseClicked(MouseEvent evt) {
                JIFSegProcedimiento.this.JTConsolidadoMouseClicked(evt);
            }
        });
        this.JSPEncabezado.setViewportView(this.JTConsolidado);
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
        this.jButton2.setText("Desactivar");
        this.jButton2.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSegProcedimiento.3
            public void actionPerformed(ActionEvent evt) {
                JIFSegProcedimiento.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton2, -2, 176, -2).addContainerGap(615, 32767)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPEncabezado, -2, 781, -2).addContainerGap(-1, 32767))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(0, 241, 32767).addComponent(this.jButton2, -2, 37, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPEncabezado, -2, 226, -2).addContainerGap(37, 32767))));
        this.jTabbedPane1.addTab("ENCABEZADO", this.jPanel2);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFSegProcedimiento.4
            public void mouseClicked(MouseEvent evt) {
                JIFSegProcedimiento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jTabbedPane1.addTab("DETALLE", this.JSPDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFSegProcedimiento.5
            public void mouseClicked(MouseEvent evt) {
                JIFSegProcedimiento.this.JTFRutaMouseClicked(evt);
            }
        });
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel.jpg")));
        this.jButton1.setText("Importar");
        this.jButton1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSegProcedimiento.6
            public void actionPerformed(ActionEvent evt) {
                JIFSegProcedimiento.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 579, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -1, 79, 32767).addComponent(this.jButton1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTabbedPane1, -2, 312, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 1L;
        } else {
            this.xestado = 0L;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloEncabezado() {
        this.xmodeloE = new DefaultTableModel(new Object[0], new String[]{"Id", "Periodo", "Estado"}) { // from class: Salud_Ocupacional.JIFSegProcedimiento.7
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidado.setModel(this.xmodeloE);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mBuscaEncabezado() {
        System.out.println("sqlEncabezado-->SELECT\n    `so_seg_procedimiento_encabezado`.`id`\n    , `cc_periodo_financiero`.`Nbre`\n    , `so_seg_procedimiento_encabezado`.`Estado`\nFROM\n    `so_seg_procedimiento_encabezado`\n    INNER JOIN `cc_periodo_financiero` \n        ON (`so_seg_procedimiento_encabezado`.`idFy` = `cc_periodo_financiero`.`Id`)\nORDER BY `so_seg_procedimiento_encabezado`.`id` DESC;");
        mModeloEncabezado();
        ResultSet xrs = this.xct.traerRs("SELECT\n    `so_seg_procedimiento_encabezado`.`id`\n    , `cc_periodo_financiero`.`Nbre`\n    , `so_seg_procedimiento_encabezado`.`Estado`\nFROM\n    `so_seg_procedimiento_encabezado`\n    INNER JOIN `cc_periodo_financiero` \n        ON (`so_seg_procedimiento_encabezado`.`idFy` = `cc_periodo_financiero`.`Id`)\nORDER BY `so_seg_procedimiento_encabezado`.`id` DESC;");
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloE.addRow(this.xdato);
                    this.xmodeloE.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloE.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloE.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSegProcedimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBSeg.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0));
            this.JCBProcedimiento.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1));
            this.JSPPeriodo.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
            this.JTAObs.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xestado = 1L;
            } else {
                this.JCHEstado.setSelected(false);
                this.xestado = 0L;
            }
            this.g = 1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTConsolidadoMouseClicked(MouseEvent evt) {
        if (this.JTConsolidado.getSelectedRow() > -1 && evt.getClickCount() == 2) {
            this.jTabbedPane1.setSelectedIndex(1);
            this.JCBPeriodo.setSelectedItem(this.xmodeloE.getValueAt(this.JTConsolidado.getSelectedRow(), 1).toString());
            mCargarDatosTabla();
        } else if (this.JTConsolidado.getSelectedRow() > -1 && evt.getClickCount() == 1) {
            if (Boolean.valueOf(this.xmodeloE.getValueAt(this.JTConsolidado.getSelectedRow(), 2).toString()).booleanValue()) {
                this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Cancelar30x30.png")));
                this.jButton2.setText("Desactivar");
            } else {
                this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
                this.jButton2.setText("Activar");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("XLS", new String[]{"xls"});
            xfilec.setFileFilter(filtroImagen);
            int r = xfilec.showOpenDialog(this);
            if (r == 0) {
                xfilec.showOpenDialog(this);
                this.xfile = xfilec.getSelectedFile();
                System.out.println(this.xfile.getAbsolutePath());
                this.JTFRuta.setText(this.xfile.getAbsolutePath());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        if (this.JCBPeriodo.getSelectedIndex() > -1) {
            if (!this.JTFRuta.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de importar la Información?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xWorkerSQL = new WorkerSQL("Importando información", this);
                    this.xWorkerSQL.execute();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la Ruta del archivo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFRuta.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el Periodo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBPeriodo.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        if (this.JTConsolidado.getSelectedRow() > -1) {
            if (Boolean.valueOf(this.xmodeloE.getValueAt(this.JTConsolidado.getSelectedRow(), 2).toString()).booleanValue()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de desactivar el registro?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String sql = "UPDATE `so_seg_procedimiento_encabezado` SET `Estado` = '0', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE `id` = '" + this.xmodeloE.getValueAt(this.JTConsolidado.getSelectedRow(), 0) + "';";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    mBuscaEncabezado();
                    return;
                }
                return;
            }
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Activar el registro?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                String sql2 = "UPDATE `so_seg_procedimiento_encabezado` SET `Estado` = '1', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE `id` = '" + this.xmodeloE.getValueAt(this.JTConsolidado.getSelectedRow(), 0) + "';";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
                mBuscaEncabezado();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"SEG", "Procedimiento", "Periodo", "Observaciones", "Estado"}) { // from class: Salud_Ocupacional.JIFSegProcedimiento.8
            Class[] types = {String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT `so_tipo_segmento`.`Nbre` , `g_procedimiento`.`Nbre` , `so_seg_procedimiento`.`IPeriodo` , IF(`so_seg_procedimiento`.`Observacion` IS NULL,'',`so_seg_procedimiento`.`Observacion`) AS Obsertvacion  , \n`so_seg_procedimiento`.`Estado` \nFROM `so_seg_procedimiento`  INNER JOIN `so_tipo_segmento`  ON (`so_seg_procedimiento`.`Id_TSegmento` = `so_tipo_segmento`.`Id`)\nINNER JOIN  so_seg_procedimiento_encabezado ON (so_seg_procedimiento.`IdEncabezado`=so_seg_procedimiento_encabezado.`id`)\nINNER JOIN  `g_procedimiento`   ON (`so_seg_procedimiento`.`Id_Procedimiento` = `g_procedimiento`.`Id`) \nWHERE so_seg_procedimiento.`IdEncabezado`='" + this.xmodeloE.getValueAt(this.JTConsolidado.getSelectedRow(), 0) + "'\nORDER BY `so_tipo_segmento`.`Nbre`";
            ResultSet xrs = this.xct.traerRs(sql);
            System.out.println("sql-->" + sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGenerico1CheckBox.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGuardar() {
        String sql;
        if (this.JCBSeg.getSelectedIndex() != -1) {
            if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.g == 0) {
                        sql = "INSERT INTO  `so_seg_procedimiento` (IdEncabezado ,`Id_TSegmento`, `Id_Procedimiento`, `IPeriodo`, `Observacion`, `Estado`,UsuarioS)  VALUES ('" + this.xmodeloE.getValueAt(this.JTConsolidado.getSelectedRow(), 0).toString() + "','" + this.xSeg[this.JCBSeg.getSelectedIndex()] + "', '" + this.xProce[this.JCBProcedimiento.getSelectedIndex()] + "',  '" + this.JSPPeriodo.getValue() + "', '" + this.JTAObs.getText() + "', '" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    } else {
                        sql = "UPDATE  `so_seg_procedimiento` SET `IPeriodo` = '" + this.JSPPeriodo.getValue() + "', `Observacion` = '" + this.JTAObs.getText() + "', `Estado` = '" + this.xestado + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'  WHERE `Id_TSegmento` = '" + this.xSeg[this.JCBSeg.getSelectedIndex()] + "' AND `Id_Procedimiento` = '" + this.xProce[this.JCBProcedimiento.getSelectedIndex()] + "' AND `IdEncabezado` = '" + this.xmodeloE.getValueAt(this.JTConsolidado.getSelectedRow(), 0).toString() + "' ";
                    }
                    this.xct.ejecutarSQL(sql);
                    System.err.println("consulta" + sql);
                    this.xct.cerrarConexionBd();
                    mNuevo();
                    mCargarDatosTabla();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el Procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBSeg.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el SEG", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBSeg.requestFocus();
    }

    private void mIniciaCombos() {
        this.xSeg = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `so_tipo_segmento` WHERE (`Estado` =1) ORDER BY Nbre ASC", this.xSeg, this.JCBSeg);
        this.JCBSeg.setSelectedIndex(-1);
        this.xProce = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_procedimiento` WHERE (`Estado` =0) ORDER BY Nbre ASC", this.xProce, this.JCBProcedimiento);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.xPeriodo = this.xct.llenarCombo("SELECT  `Id`, `Nbre` FROM `cc_periodo_financiero` WHERE Estado =1 ORDER BY Id DESC", this.xPeriodo, this.JCBPeriodo);
        this.JCBPeriodo.setSelectedIndex(-1);
    }

    public void mImportar() {
        int TV;
        try {
            String archivo = this.JTFRuta.getText();
            Workbook workbook = Workbook.getWorkbook(new File(archivo));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            String sql = "INSERT INTO `so_seg_procedimiento_encabezado` (`idFy`,`UsuarioS`) VALUES ( '" + this.xPeriodo[this.JCBPeriodo.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
            String xidEncabezado = this.xct.ejecutarSQLId(sql);
            this.xct.cerrarConexionBd();
            for (int x = 1; x < rows; x++) {
                if (!sheet.getCell(0, x).getContents().equals("")) {
                    System.out.println(sheet.getCell(0, x).getContents() + "<-->" + sheet.getCell(1, x).getContents());
                    String xsIdSEG = sheet.getCell(0, x).getContents();
                    String xsRango = sheet.getCell(1, x).getContents();
                    StringTokenizer stRangos = new StringTokenizer(xsRango, "-");
                    StringTokenizer stIdSEG = new StringTokenizer(xsIdSEG, "-");
                    int[] xRango = new int[2];
                    for (int i = 0; i <= stRangos.countTokens(); i++) {
                        xRango[i] = Integer.valueOf(stRangos.nextToken()).intValue();
                    }
                    while (stIdSEG.hasMoreTokens()) {
                        String IdSegT = stIdSEG.nextToken();
                        for (int y = 1; y < rows; y++) {
                            if (y >= xRango[0] - 1 && y <= xRango[1] - 1) {
                                if (sheet.getCell(4, y).getContents().equals("VM")) {
                                    TV = 0;
                                } else if (sheet.getCell(4, y).getContents().equals("VE")) {
                                    TV = 2;
                                } else if (sheet.getCell(4, y).getContents().equals("VO")) {
                                    TV = 1;
                                } else {
                                    TV = -1;
                                }
                                System.out.println("FILA-->" + y + " IdSeg-->" + IdSegT + " idProce-->" + sheet.getCell(2, y).getContents() + " Periodicidad-->" + sheet.getCell(5, y).getContents());
                                String sqlDet = "INSERT INTO `so_seg_procedimiento`\n            (`Id_TSegmento`,\n             `Id_Procedimiento`,\n             `IdEncabezado`,\n             `EInicio`,\n             `EFinal`,\n             `IPeriodo`,\n             `Observacion`,\n             `TVigilancia`,\n             `UsuarioS`)\nVALUES ('" + IdSegT + "',\n        '" + sheet.getCell(2, y).getContents() + "',\n        '" + xidEncabezado + "',\n        '" + sheet.getCell(5, y).getContents() + "',\n        '" + sheet.getCell(6, y).getContents() + "',\n        '" + sheet.getCell(7, y).getContents() + "',\n        '" + sheet.getCell(8, y).getContents() + "',\n        '" + TV + "',\n        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                System.out.println("InsertaDetalle-->" + sqlDet);
                                this.xct.ejecutarSQL(sqlDet);
                                this.xct.cerrarConexionBd();
                            }
                        }
                        System.out.println("-------------TERMINA->" + IdSegT + "-----------------");
                    }
                    System.out.println("-----------------TERMINA PROCESO------------------------");
                }
                if (x % 500 == 0) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
            workbook.close();
            this.jTabbedPane1.setSelectedIndex(0);
            mBuscaEncabezado();
            this.JTFRuta.setText("");
        } catch (BiffException e) {
            Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (IOException ex2) {
            Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }
}
