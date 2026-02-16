package Salud_Ocupacional;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFGestion_ManPower.class */
public class JIFGestion_ManPower extends JInternalFrame {
    private File xfile;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xsql;
    private String[] xidperiodo;
    private WorkerSQL xWorkerSQL;
    public JDCargueManPower xv;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO = Charset.forName("ISO-8859-1");
    private JButton JBTExportar;
    private JButton JBT_Cargue;
    private JComboBox JCBPeriodo;
    private JCheckBox JCH_IncluirSeguimiento;
    private JLabel JLBNRegistrados;
    private JLabel JLBNTrabajadores;
    private JPanel JPDetalle;
    private JPanel JPIDatosC;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    private JTable JTBConsolidado;
    private JTable JTBDetalle;
    public JTextField JTFRuta;
    private JTextField JTFRuta1;
    private JTabbedPane JTPDatos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public int xValidado = 0;

    public JIFGestion_ManPower() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JTFRuta = new JTextField();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBT_Cargue = new JButton();
        this.JCH_IncluirSeguimiento = new JCheckBox();
        this.JTPDatos = new JTabbedPane();
        this.JSPConsolidado = new JScrollPane();
        this.JTBConsolidado = new JTable();
        this.JPDetalle = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JLBNTrabajadores = new JLabel();
        this.JLBNRegistrados = new JLabel();
        this.JTFRuta1 = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE MANPOWER");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifgestionmanp");
        addInternalFrameListener(new InternalFrameListener() { // from class: Salud_Ocupacional.JIFGestion_ManPower.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFGestion_ManPower.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA IMPORTACIÓN DE INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFRuta.setEditable(false);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta de Archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFGestion_ManPower.2
            public void mouseClicked(MouseEvent evt) {
                JIFGestion_ManPower.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JSPObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder((Border) null);
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JBT_Cargue.setFont(new Font("Arial", 1, 12));
        this.JBT_Cargue.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBT_Cargue.setText("Validación-Cargue");
        this.JBT_Cargue.setToolTipText("Asistente de validación y cargue");
        this.JBT_Cargue.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFGestion_ManPower.3
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_ManPower.this.JBT_CargueActionPerformed(evt);
            }
        });
        this.JCH_IncluirSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_IncluirSeguimiento.setSelected(true);
        this.JCH_IncluirSeguimiento.setText("Incluir Seguimientos?");
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 204, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_Cargue, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_IncluirSeguimiento, -2, 181, -2)).addComponent(this.JSPObservacion).addComponent(this.JTFRuta)).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodo, -1, 50, 32767).addComponent(this.JBT_Cargue, -1, -1, 32767).addGroup(JPIDatosCLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCH_IncluirSeguimiento))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion, -2, 59, -2).addContainerGap()));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTBConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTBConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBConsolidado.setRowHeight(25);
        this.JTBConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBConsolidado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBConsolidado.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFGestion_ManPower.4
            public void mouseClicked(MouseEvent evt) {
                JIFGestion_ManPower.this.JTBConsolidadoMouseClicked(evt);
            }
        });
        this.JSPConsolidado.setViewportView(this.JTBConsolidado);
        this.JTPDatos.addTab("CONSOLIDADO", this.JSPConsolidado);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFGestion_ManPower.5
            public void keyPressed(KeyEvent evt) {
                JIFGestion_ManPower.this.JTBDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JLBNTrabajadores.setFont(new Font("Arial", 1, 16));
        this.JLBNTrabajadores.setHorizontalAlignment(0);
        this.JLBNTrabajadores.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Trabajadores", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNRegistrados.setBackground(new Color(177, 251, 177));
        this.JLBNRegistrados.setFont(new Font("Arial", 1, 16));
        this.JLBNRegistrados.setHorizontalAlignment(0);
        this.JLBNRegistrados.setBorder(BorderFactory.createTitledBorder((Border) null, "N° NRegistrados", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNRegistrados.setOpaque(true);
        this.JTFRuta1.setFont(new Font("Arial", 1, 12));
        this.JTFRuta1.setText("C:\\Genoma\\plantilla");
        this.JTFRuta1.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta1.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFGestion_ManPower.6
            public void mouseClicked(MouseEvent evt) {
                JIFGestion_ManPower.this.JTFRuta1MouseClicked(evt);
            }
        });
        this.JTFRuta1.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFGestion_ManPower.7
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_ManPower.this.JTFRuta1ActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFGestion_ManPower.8
            public void actionPerformed(ActionEvent evt) {
                JIFGestion_ManPower.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPDetalleLayout = new GroupLayout(this.JPDetalle);
        this.JPDetalle.setLayout(JPDetalleLayout);
        JPDetalleLayout.setHorizontalGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, -2, 788, -2).addGroup(JPDetalleLayout.createSequentialGroup().addComponent(this.JLBNTrabajadores, -2, 118, -2).addGap(18, 18, 18).addComponent(this.JLBNRegistrados, -2, 118, -2).addGap(18, 18, 18).addComponent(this.JTFRuta1).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 128, -2))).addContainerGap(22, 32767)));
        JPDetalleLayout.setVerticalGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 348, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNTrabajadores, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JLBNRegistrados, GroupLayout.Alignment.TRAILING, -2, 50, -2).addGroup(GroupLayout.Alignment.TRAILING, JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta1, -2, 50, -2))).addContainerGap()));
        this.JTPDatos.addTab("DETALLE", this.JPDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTPDatos).addComponent(this.JPIDatosC, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JTPDatos, -2, 462, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBConsolidadoMouseClicked(MouseEvent evt) {
        if (this.JTBConsolidado.getSelectedRow() != -1) {
            this.JCBPeriodo.setSelectedItem(this.xmodelo.getValueAt(this.JTBConsolidado.getSelectedRow(), 1));
            mCargarDatosTablaD(this.xmodelo.getValueAt(this.JTBConsolidado.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1MouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser("C:\\");
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta1.setText(xfile.getAbsolutePath() + "\\");
                this.JTFRuta1.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta1.getText().isEmpty()) {
            if (this.JTBDetalle.getRowCount() > -1) {
                mExportar();
                return;
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta1.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRuta1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTBDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar el registro seleccionado?", "CONFIRMAR", 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "DELETE FROM so_manporwer_detalle WHERE Id='" + this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 8) + "'";
                System.out.println("Eliminar : " + this.xsql);
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mCargarDatosTablaD(Principal.txtNo.getText());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargueActionPerformed(ActionEvent evt) {
        this.xv = new JDCargueManPower(null, true, this);
        this.xv.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBPeriodo.removeAllItems();
        this.xsql = "SELECT `Id`, `Nbre` FROM `cc_periodo_financiero` ORDER BY `FechaI` DESC ";
        this.xidperiodo = this.xct.llenarCombo(this.xsql, this.xidperiodo, this.JCBPeriodo);
        this.xct.cerrarConexionBd();
        this.JTFRuta.setText("");
        this.JTAObservacion.setText("");
        mCargarDatosTablaC();
        mCrearModeloDetalle();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloC() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Observación", "Activa"}) { // from class: Salud_Ocupacional.JIFGestion_ManPower.9
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBConsolidado.setModel(this.xmodelo);
        this.JTBConsolidado.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTBConsolidado.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBConsolidado.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBConsolidado.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Cédula", "TContrato", "Nombre", "FEntrada", "Cargo", "Grupo", "Unidad", "Id_Persona", "Id"}) { // from class: Salud_Ocupacional.JIFGestion_ManPower.10
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo1);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    private void mCargarDatosTablaC() {
        try {
            mCrearModeloC();
            this.xsql = "SELECT `so_manporwer_encabezado`.`Id`, `cc_periodo_financiero`.`Nbre`, `so_manporwer_encabezado`.`Observacion`, `so_manporwer_encabezado`.`Activa` FROM  `so_manporwer_encabezado` INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) ORDER BY `so_manporwer_encabezado`.`Id` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(4)), x, 3);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaD(String xid) {
        try {
            this.xsql = "CALL so_actualizacion_datos(5," + xid + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mCrearModeloDetalle();
            this.xsql = "SELECT`so_manporwer_detalle`.`Cedula`, `so_manporwer_detalle`.`TContrato1`, `so_manporwer_detalle`.`Nombre_Completo`, `so_manporwer_detalle`.`FEntrada`, `so_manporwer_detalle`.`Cargo`, `so_manporwer_detalle`.`Grupo`, `so_manporwer_detalle`.`UnidadN`, `so_manporwer_detalle`.`Id_Persona`, so_manporwer_detalle.Id FROM  `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado` ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) WHERE (`so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "') ORDER BY `so_manporwer_detalle`.`UnidadN` ASC, `so_manporwer_detalle`.`TContrato1` ASC, `so_manporwer_detalle`.`Nombre_Completo` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            int x = 0;
            int xnr = 0;
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo1.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo1.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo1.setValueAt(xrs.getString(7), x, 6);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(8)), x, 7);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(9)), x, 8);
                    if (xrs.getLong(8) == 0) {
                        xnr++;
                    }
                    this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            this.JLBNTrabajadores.setText("" + x);
            this.JLBNRegistrados.setText("" + xnr);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (this.xValidado == 1) {
            if (Principal.txtNo.getText().isEmpty()) {
                if (!this.JTFRuta.getText().isEmpty()) {
                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y == 0) {
                        this.xWorkerSQL = new WorkerSQL("Procesando informacion", this);
                        this.xWorkerSQL.execute();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una ruta", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFRuta.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El archivo aun no ha sido validado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public void mImportar() {
        try {
            String archivo = this.JTFRuta.getText();
            DecimalFormat formatDecimal = new DecimalFormat("#");
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(archivo));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            int rows = sheet.getLastRowNum();
            System.out.println(rows);
            this.xsql = "INSERT INTO so_manporwer_encabezado (`Id_Periodo`, `Observacion`, `Usuario`) VALUES('" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
            this.xct.cerrarConexionBd();
            for (int x = 1; x < rows; x++) {
                HSSFRow row = sheet.getRow(x);
                this.xsql = "insert into so_manporwer_detalle (`Id_mampower`, `Codigo`, `Cedula`, `TContrato`, `TContrato1`, `Nombre_Completo`, `FEntrada`, `Cargo`, `Grupo`, `Email`, `UnidadN`,SEG)  values('" + Principal.txtNo.getText() + "','" + formatDecimal.format(row.getCell(0).getNumericCellValue()) + "','" + formatDecimal.format(row.getCell(1).getNumericCellValue()) + "','" + row.getCell(2).getStringCellValue() + "','" + row.getCell(3).getStringCellValue() + "','" + row.getCell(4).getStringCellValue() + "',ADDDATE('" + this.xmt.formatoAMD.format(row.getCell(9).getDateCellValue()) + "', INTERVAL 1 DAY),'" + row.getCell(5).getStringCellValue() + "','" + row.getCell(6).getStringCellValue() + "','" + row.getCell(7).getStringCellValue() + "','" + row.getCell(8).getStringCellValue() + "','" + row.getCell(10).getStringCellValue() + "')";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                if (x % 500 == 0) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    }
                }
            }
            mActualizarDatosEO();
            this.xsql = "CALL so_actualizacion_datos(3," + Principal.txtNo.getText() + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL so_actualizacion_datos(4," + Principal.txtNo.getText() + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL so_actualizacion_datos(1," + Principal.txtNo.getText() + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "CALL so_actualizacion_datos(6," + Principal.txtNo.getText() + ")";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mCargarDatosTablaD(Principal.txtNo.getText());
            if (this.JCH_IncluirSeguimiento.isSelected()) {
                mCopiaSeguimientos(Principal.txtNo.getText());
            }
        } catch (IOException ex2) {
            Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
        }
    }

    private void mCopiaSeguimientos(String xidPO) {
        System.out.println("1-->Entra a copiar seguimientos...");
        String sqlSEG = "INSERT INTO so_manpower_seguimiento(\n    `Id_Manpower_Detalle`\n    , `FechaR`\n    , `Observacion`\n    , `FechaCierre`\n    , `Id_Profesional`\n    , `Id_Especialidad`\n    , `Estado`\n    , `UsuarioS`\n    , `idSegAnterior`)\n    \n    SELECT id.`Id` \n   -- `so_manpower_seguimiento`.`Id_Manpower_Detalle`\n    , `so_manpower_seguimiento`.`FechaR`\n    , `so_manpower_seguimiento`.`Observacion`\n    , `so_manpower_seguimiento`.`FechaCierre`\n    , `so_manpower_seguimiento`.`Id_Profesional`\n    , `so_manpower_seguimiento`.`Id_Especialidad`\n    , `so_manpower_seguimiento`.`Estado`\n    , `so_manpower_seguimiento`.`UsuarioS`\n-- , `so_manpower_seguimiento`.`Fecha`\n    ,so_manpower_seguimiento.`Id`\nFROM\n    `baseserver`.`so_manpower_seguimiento`\n    INNER JOIN `baseserver`.`so_manporwer_detalle` \n        ON (`so_manpower_seguimiento`.`Id_Manpower_Detalle` = `so_manporwer_detalle`.`Id`)\n    INNER JOIN `baseserver`.`so_manpower_seguimiento_detalle` \n        ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`)\n        RIGHT JOIN `so_manporwer_detalle` id ON (id.Cedula=so_manporwer_detalle.`Cedula`) AND (id.`Id_mampower`='" + xidPO + "')\nWHERE (`so_manporwer_detalle`.`Id_mampower` =(" + xidPO + "-1)\n    AND `so_manpower_seguimiento_detalle`.`FechaCierre` IS NULL\nAND `so_manpower_seguimiento`.`idSegAnterior` IS NOT NULL    \n    )";
        this.xct.ejecutarSQL(sqlSEG);
        this.xct.cerrarConexionBd();
        System.out.println("2-->Entra a copiar seguimientos detalles...");
        String sqlDSEG = "INSERT INTO so_manpower_seguimiento_detalle(\n    `Id_Mp_Seguimiento`\n    , `Id_Tipo_Vigilancia`\n    , `Observacion`\n    , `NDiasS`\n    , `FechaUS`\n    , `FechaCierre`\n    , `Estado`\n    , `MAnulacion`\n    , `FAnulacion`\n    , `UAnulacion`\n    , `ObservacionA`\n    , `Fecha`\n    , `UsuarioS`\n    , `idSegDet_Anterior`)SELECT\n    `so_manpower_seguimiento`.`Id`\n    , `so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia`\n    , `so_manpower_seguimiento_detalle`.`Observacion`\n    , `so_manpower_seguimiento_detalle`.`NDiasS`\n    , `so_manpower_seguimiento_detalle`.`FechaUS`\n    , `so_manpower_seguimiento_detalle`.`FechaCierre`\n    , `so_manpower_seguimiento_detalle`.`Estado`\n    , `so_manpower_seguimiento_detalle`.`MAnulacion`\n    , `so_manpower_seguimiento_detalle`.`FAnulacion`\n    , `so_manpower_seguimiento_detalle`.`UAnulacion`\n    , `so_manpower_seguimiento_detalle`.`ObservacionA`\n    , `so_manpower_seguimiento_detalle`.`Fecha`\n    , `so_manpower_seguimiento_detalle`.`UsuarioS`\n    , `so_manpower_seguimiento_detalle`.`Id`\n   \nFROM\n    `baseserver`.`so_manpower_seguimiento`\n    INNER JOIN `baseserver`.`so_manporwer_detalle` \n        ON (`so_manpower_seguimiento`.`Id_Manpower_Detalle` = `so_manporwer_detalle`.`Id`)\n    INNER JOIN `baseserver`.`so_manpower_seguimiento_detalle` \n        ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`idSegAnterior`)\nWHERE (`so_manpower_seguimiento_detalle`.`FechaCierre` IS NULL\n    AND `so_manporwer_detalle`.`Id_mampower` ='" + xidPO + "')";
        this.xct.ejecutarSQL(sqlDSEG);
        this.xct.cerrarConexionBd();
        System.out.println("3-->Entra a copiar comentarios seguimientos detalles...");
        String sqlDCSEG = "INSERT INTO so_manpower_seguimiento_detalle_s(\n    `Fecha_S`\n    , `Id_Mp_SDetalle`\n    , `Id_Vigilancia_S`\n    , `Descrpcion`\n    , `Id_Especialidad`\n    , `Id_Profesional`\n    , `Estado`\n    , `MAnulacion`\n    , `FAnulacion`\n    , `UAnulacion`\n    , `ObservacionA`\n    , `Fecha`\n    , `UsuarioS`)SELECT\n    `so_manpower_seguimiento_detalle_s`.`Fecha_S`\n    , `so_manpower_seguimiento_detalle`.`Id`\n    , `so_manpower_seguimiento_detalle_s`.`Id_Vigilancia_S`\n    , `so_manpower_seguimiento_detalle_s`.`Descrpcion`\n    , `so_manpower_seguimiento_detalle_s`.`Id_Especialidad`\n    , `so_manpower_seguimiento_detalle_s`.`Id_Profesional`\n    , `so_manpower_seguimiento_detalle_s`.`Estado`\n    , `so_manpower_seguimiento_detalle_s`.`MAnulacion`\n    , `so_manpower_seguimiento_detalle_s`.`FAnulacion`\n    , `so_manpower_seguimiento_detalle_s`.`UAnulacion`\n    , `so_manpower_seguimiento_detalle_s`.`ObservacionA`\n    , `so_manpower_seguimiento_detalle_s`.`Fecha`\n    , `so_manpower_seguimiento_detalle_s`.`UsuarioS`\nFROM\n    `baseserver`.`so_manpower_seguimiento`\n    INNER JOIN `baseserver`.`so_manporwer_detalle` \n        ON (`so_manpower_seguimiento`.`Id_Manpower_Detalle` = `so_manporwer_detalle`.`Id`)\n    INNER JOIN `baseserver`.`so_manpower_seguimiento_detalle` \n        ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`)\n    INNER JOIN `baseserver`.`so_manpower_seguimiento_detalle_s` \n        ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`idSegDet_Anterior`)\nWHERE (`so_manporwer_detalle`.`Id_mampower` ='" + xidPO + "')";
        this.xct.ejecutarSQL(sqlDCSEG);
        this.xct.cerrarConexionBd();
    }

    public void mActualizarDatosEO() {
        this.xsql = "DROP VIEW IF EXISTS v_so_atencion";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_so_atencion`  AS  SELECT MAX(`h_atencion`.`Id`) AS `Id_Atencion` FROM `h_atencion` INNER JOIN  `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `h_atencion`.`Id_ClaseCita` =222) GROUP BY `h_atencion`.`Id` ORDER BY `Id_Atencion` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS v_so_atencion_detalle";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `v_so_atencion_detalle`  AS SELECT `ingreso`.`Id_Usuario`, `h_atencion`.`Fecha_Atencion`  FROM `v_so_atencion` INNER JOIN `h_atencion`  ON (`v_so_atencion`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) ORDER BY `ingreso`.`Id_Usuario` ASC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    private void mActualizarDatos() {
        this.xsql = "UPDATE `so_manporwer_detalle`, `g_persona` SET so_manporwer_detalle.`Id_Persona`=g_persona.`Id` , g_persona.`ActivoSo`=1 WHERE g_persona.`NoDocumento`=so_manporwer_detalle.`Cedula`";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "DROP VIEW IF EXISTS a_actualizar";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "CREATE VIEW  `a_actualizar`  AS SELECT `so_manporwer_detalle`.`Id_Persona` , `g_cargos`.`Id` FROM `g_cargos` INNER JOIN `so_manporwer_detalle`  ON (`g_cargos`.`N_Ingles` = `so_manporwer_detalle`.`Cargo`)   ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xct.ejecutarSQL("UPDATE `g_usuario`,`a_actualizar` SET g_usuario.`Id_Cargo`=a_actualizar.`Id` WHERE a_actualizar.`Id_Persona`=g_usuario.`Id_persona`");
        this.xct.cerrarConexionBd();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFGestion_ManPower$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 7).toString()).longValue() == 0) {
                cell.setBackground(new Color(177, 251, 177));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    private void mExportar() {
        WritableWorkbook workbook;
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                File archivo = new File(this.JTFRuta.getText() + ".xls");
                if (this.xmt.mEliminarArchivo(archivo)) {
                    workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                } else {
                    workbook = Workbook.createWorkbook(archivo);
                }
                WritableSheet sheet = workbook.createSheet("Consolidado", 0);
                for (int x = 0; x < this.JTBDetalle.getColumnCount(); x++) {
                    sheet.addCell(new Label(x, 0, this.JTBDetalle.getColumnName(x)));
                }
                for (int x2 = 0; x2 < this.JTBDetalle.getRowCount(); x2++) {
                    sheet.addCell(new Label(0, x2 + 1, this.xmodelo1.getValueAt(x2, 0).toString()));
                    sheet.addCell(new Label(1, x2 + 1, this.xmodelo1.getValueAt(x2, 1).toString()));
                    sheet.addCell(new Label(2, x2 + 1, this.xmodelo1.getValueAt(x2, 2).toString()));
                    sheet.addCell(new Label(3, x2 + 1, this.xmodelo1.getValueAt(x2, 3).toString()));
                    sheet.addCell(new Label(4, x2 + 1, this.xmodelo1.getValueAt(x2, 4).toString()));
                    sheet.addCell(new Label(5, x2 + 1, this.xmodelo1.getValueAt(x2, 5).toString()));
                    sheet.addCell(new Label(6, x2 + 1, this.xmodelo1.getValueAt(x2, 6).toString()));
                    sheet.addCell(new Label(7, x2 + 1, this.xmodelo1.getValueAt(x2, 7).toString()));
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
