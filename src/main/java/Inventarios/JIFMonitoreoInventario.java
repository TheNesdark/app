package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFMonitoreoInventario.class */
public class JIFMonitoreoInventario extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelodetalletto;
    private Object[] xdato;
    private String[] xidbodega;
    private String xsql;
    private ButtonGroup JBGConteos;
    private ButtonGroup JBGFiltro;
    private JButton JBTExportar;
    private JComboBox JCBBodega;
    private JCheckBox JCH_Cerrado;
    private JCheckBox JCH_VAgrupada;
    private JPanel JPIComparacion;
    private JPanel JPIDatos;
    private JPanel JPIFiltro;
    public static JRadioButton JRBC1;
    public static JRadioButton JRBC2;
    public static JRadioButton JRBFDiferencias;
    public static JRadioButton JRBFTodas;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    private JTable JTConsolidado;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;
    private int xnfila = -1;
    private int xnfila1 = -1;
    private int xTipo = 0;
    private String xFiltro = ">0";

    public JIFMonitoreoInventario() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v60, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGConteos = new ButtonGroup();
        this.JBGFiltro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBBodega = new JComboBox();
        this.JPIComparacion = new JPanel();
        JRBC1 = new JRadioButton();
        JRBC2 = new JRadioButton();
        this.JPIFiltro = new JPanel();
        JRBFTodas = new JRadioButton();
        JRBFDiferencias = new JRadioButton();
        this.JCH_VAgrupada = new JCheckBox();
        this.JCH_Cerrado = new JCheckBox();
        this.JSPConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("MONITOREO DE INVENTARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifmonitoreoinventario");
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.JIFMonitoreoInventario.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFMonitoreoInventario.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBodega.addItemListener(new ItemListener() { // from class: Inventarios.JIFMonitoreoInventario.2
            public void itemStateChanged(ItemEvent evt) {
                JIFMonitoreoInventario.this.JCBBodegaItemStateChanged(evt);
            }
        });
        this.JPIComparacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Comparación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGConteos.add(JRBC1);
        JRBC1.setFont(new Font("Arial", 1, 12));
        JRBC1.setSelected(true);
        JRBC1.setText("Conteo1");
        JRBC1.addActionListener(new ActionListener() { // from class: Inventarios.JIFMonitoreoInventario.3
            public void actionPerformed(ActionEvent evt) {
                JIFMonitoreoInventario.this.JRBC1ActionPerformed(evt);
            }
        });
        this.JBGConteos.add(JRBC2);
        JRBC2.setFont(new Font("Arial", 1, 12));
        JRBC2.setText("Conteo2");
        JRBC2.addActionListener(new ActionListener() { // from class: Inventarios.JIFMonitoreoInventario.4
            public void actionPerformed(ActionEvent evt) {
                JIFMonitoreoInventario.this.JRBC2ActionPerformed(evt);
            }
        });
        GroupLayout JPIComparacionLayout = new GroupLayout(this.JPIComparacion);
        this.JPIComparacion.setLayout(JPIComparacionLayout);
        JPIComparacionLayout.setHorizontalGroup(JPIComparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIComparacionLayout.createSequentialGroup().addContainerGap().addComponent(JRBC1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(JRBC2).addContainerGap(-1, 32767)));
        JPIComparacionLayout.setVerticalGroup(JPIComparacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIComparacionLayout.createSequentialGroup().addGroup(JPIComparacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(JRBC1).addComponent(JRBC2)).addContainerGap(-1, 32767)));
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGFiltro.add(JRBFTodas);
        JRBFTodas.setFont(new Font("Arial", 1, 12));
        JRBFTodas.setSelected(true);
        JRBFTodas.setText("Todas");
        JRBFTodas.addActionListener(new ActionListener() { // from class: Inventarios.JIFMonitoreoInventario.5
            public void actionPerformed(ActionEvent evt) {
                JIFMonitoreoInventario.this.JRBFTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(JRBFDiferencias);
        JRBFDiferencias.setFont(new Font("Arial", 1, 12));
        JRBFDiferencias.setText("Diferencias");
        JRBFDiferencias.addActionListener(new ActionListener() { // from class: Inventarios.JIFMonitoreoInventario.6
            public void actionPerformed(ActionEvent evt) {
                JIFMonitoreoInventario.this.JRBFDiferenciasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(JRBFTodas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(JRBFDiferencias).addContainerGap(-1, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(JRBFTodas).addComponent(JRBFDiferencias)).addContainerGap(-1, 32767)));
        this.JCH_VAgrupada.setFont(new Font("Arial", 1, 12));
        this.JCH_VAgrupada.setText("Visualización Agrupada?");
        this.JCH_Cerrado.setFont(new Font("Arial", 1, 12));
        this.JCH_Cerrado.setSelected(true);
        this.JCH_Cerrado.setText("Cerrado?");
        this.JCH_Cerrado.addActionListener(new ActionListener() { // from class: Inventarios.JIFMonitoreoInventario.7
            public void actionPerformed(ActionEvent evt) {
                JIFMonitoreoInventario.this.JCH_CerradoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBBodega, -2, 348, -2).addGap(37, 37, 37).addComponent(this.JPIComparacion, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_VAgrupada).addComponent(this.JCH_Cerrado)).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(0, 1, 32767).addComponent(this.JCH_Cerrado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_VAgrupada)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIComparacion, GroupLayout.Alignment.LEADING, 0, 50, 32767).addComponent(this.JCBBodega, GroupLayout.Alignment.LEADING)).addGap(0, 0, 32767)).addComponent(this.JPIFiltro, GroupLayout.Alignment.LEADING, 0, -1, 32767)).addContainerGap()));
        this.JSPConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTConsolidado.setRowHeight(25);
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(new Color(255, 0, 0));
        this.JTConsolidado.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFMonitoreoInventario.8
            public void mouseClicked(MouseEvent evt) {
                JIFMonitoreoInventario.this.JTConsolidadoMouseClicked(evt);
            }
        });
        this.JSPConsolidado.setViewportView(this.JTConsolidado);
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE SUMINISTRO POR LOTE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFMonitoreoInventario.9
            public void mouseClicked(MouseEvent evt) {
                JIFMonitoreoInventario.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Inventarios.JIFMonitoreoInventario.10
            public void actionPerformed(ActionEvent evt) {
                JIFMonitoreoInventario.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPConsolidado, GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 597, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPConsolidado, -2, 274, -2).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -1, 50, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBodegaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBBodega.getSelectedIndex() != -1) {
            mBuscarDConsolidado();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBC1ActionPerformed(ActionEvent evt) {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mBuscarDConsolidado();
            this.xTipo = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBC2ActionPerformed(ActionEvent evt) {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mBuscarDConsolidado();
            this.xTipo = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFTodasActionPerformed(ActionEvent evt) {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mBuscarDConsolidado();
            this.xFiltro = "<>0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFDiferenciasActionPerformed(ActionEvent evt) {
        if (this.JCBBodega.getSelectedIndex() != -1) {
            mBuscarDConsolidado();
            this.xFiltro = ">0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTConsolidadoMouseClicked(MouseEvent evt) {
        if (this.JTConsolidado.getSelectedRow() != -1) {
            mBuscarDDetalle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_CerradoActionPerformed(ActionEvent evt) {
        mLlenar_Cbo_Inventario();
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
        if (this.JTConsolidado.getRowCount() != -1) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTConsolidado, this.JTFRuta.getText(), getTitle());
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.xnfila = -1;
        mLlenar_Cbo_Inventario();
        mCrearTablaConsolidad();
        mCrearTablaDetalle();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    private void mLlenar_Cbo_Inventario() {
        this.xlleno = false;
        this.JCBBodega.removeAllItems();
        if (this.JCH_Cerrado.isSelected()) {
            this.xidbodega = this.xct.llenarCombo("SELECT i_inventario.Id, concat(i_bodegas.Nbre, ' - ',i_inventario.Id) FROM i_bodegas INNER JOIN i_inventario  ON (i_bodegas.Id = i_inventario.Id_Bodega) WHERE (i_inventario.Estado=1)", this.xidbodega, this.JCBBodega);
        } else if (this.JCH_Cerrado.isSelected()) {
            this.xidbodega = this.xct.llenarCombo("SELECT i_inventario.Id, i_bodegas.Nbre FROM i_bodegas INNER JOIN i_inventario  ON (i_bodegas.Id = i_inventario.Id_Bodega) WHERE (i_inventario.Fecha_Cierre IS NULL and i_inventario.Estado=1)", this.xidbodega, this.JCBBodega);
        }
        this.JCBBodega.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaConsolidad() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Suministro", "Presentación", "Laboratorio", "Existencia", "Conteo1", "DConteo1", "Conteo2", "DConteo2", "Valor"}) { // from class: Inventarios.JIFMonitoreoInventario.11
            Class[] types = {Long.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTConsolidado.setModel(this.xmodelo);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTConsolidado.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTConsolidado.getColumnModel().getColumn(5).setPreferredWidth(20);
        if (JRBC1.isSelected()) {
            this.JTConsolidado.getColumnModel().getColumn(6).setPreferredWidth(20);
        } else {
            this.JTConsolidado.getColumnModel().getColumn(6).setPreferredWidth(0);
            this.JTConsolidado.getColumnModel().getColumn(6).setMinWidth(0);
            this.JTConsolidado.getColumnModel().getColumn(6).setMaxWidth(0);
        }
        this.JTConsolidado.getColumnModel().getColumn(7).setPreferredWidth(20);
        if (JRBC2.isSelected()) {
            this.JTConsolidado.getColumnModel().getColumn(8).setPreferredWidth(20);
        } else {
            this.JTConsolidado.getColumnModel().getColumn(8).setPreferredWidth(0);
            this.JTConsolidado.getColumnModel().getColumn(8).setMinWidth(0);
            this.JTConsolidado.getColumnModel().getColumn(8).setMaxWidth(0);
        }
        this.JTConsolidado.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.xnfila = -1;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Lote", "Fecha Vencimiento", "Existencia", "Conteo1", "DConteo1", "Conteo2", "DConteo2"}) { // from class: Inventarios.JIFMonitoreoInventario.12
            Class[] types = {String.class, String.class, Long.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, true, true, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        if (JRBC1.isSelected()) {
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        } else {
            this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        }
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        if (JRBC2.isSelected()) {
            this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        } else {
            this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
            this.JTDetalle.getColumnModel().getColumn(6).setMinWidth(0);
            this.JTDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        }
        this.xnfila1 = -1;
    }

    private void mBuscarDConsolidado() {
        mCrearTablaConsolidad();
        mCrearTablaDetalle();
        if (JRBFTodas.isSelected()) {
            this.xsql = "SELECT i_suministroxlotexbodegainv.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, SUM(i_suministroxlotexbodegainv.Cantidad) AS Existencia, SUM(i_suministroxlotexbodegainv.Conteo1) AS Conteo1, (SUM(i_suministroxlotexbodegainv.Cantidad)-SUM(i_suministroxlotexbodegainv.Conteo1)) AS DConteo1,  SUM(i_suministroxlotexbodegainv.Conteo2) AS Conteo2, (SUM(i_suministroxlotexbodegainv.Cantidad)-SUM(i_suministroxlotexbodegainv.Conteo2)) AS DConteo2, i_suministroxbodegainv.Costo FROM i_suministroxbodegainv INNER JOIN i_inventario  ON (i_suministroxbodegainv.Id_inventario = i_inventario.Id) INNER JOIN i_suministroxlotexbodegainv  ON (i_suministroxbodegainv.Id_SuministroBodega = i_suministroxlotexbodegainv.Id) AND (i_suministroxbodegainv.Id_inventario = i_suministroxlotexbodegainv.Id_Inventario) INNER JOIN i_suministroxbodega  ON (i_suministroxbodega.IdBodega = i_inventario.Id_Bodega) AND (i_suministroxbodega.Id = i_suministroxlotexbodegainv.Id) INNER JOIN i_suministro  ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_inventario.Id ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_suministroxlotexbodegainv.Id ORDER BY i_suministro.Nbre ASC ";
        } else if (JRBFDiferencias.isSelected()) {
            if (JRBC1.isSelected()) {
                this.xsql = "SELECT i_suministroxlotexbodegainv.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, SUM(i_suministroxlotexbodegainv.Cantidad) AS Existencia, SUM(i_suministroxlotexbodegainv.Conteo1) AS Conteo1, SUM(i_suministroxlotexbodegainv.Cantidad-i_suministroxlotexbodegainv.Conteo1) AS DConteo1, i_suministroxlotexbodegainv.Conteo2 AS Conteo2, SUM(i_suministroxlotexbodegainv.Cantidad-i_suministroxlotexbodegainv.Conteo2) AS DConteo2, i_suministroxbodegainv.Costo FROM i_suministroxbodegainv INNER JOIN i_inventario  ON (i_suministroxbodegainv.Id_inventario = i_inventario.Id) INNER JOIN i_suministroxlotexbodegainv  ON (i_suministroxbodegainv.Id_SuministroBodega = i_suministroxlotexbodegainv.Id) AND (i_suministroxbodegainv.Id_inventario = i_suministroxlotexbodegainv.Id_Inventario) INNER JOIN i_suministroxbodega   ON (i_suministroxbodega.IdBodega = i_inventario.Id_Bodega) AND (i_suministroxbodega.Id = i_suministroxlotexbodegainv.Id) INNER JOIN i_suministro  ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_inventario.Id ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' ) GROUP BY i_suministroxlotexbodegainv.Id HAVING (DConteo1 <>0) ORDER BY i_suministro.Nbre ASC ";
            } else if (JRBC1.isSelected()) {
                this.xsql = "SELECT i_suministroxlotexbodegainv.Id, i_suministro.Nbre, i_presentacioncomercial.Nbre, i_laboratorio.Nbre, SUM(i_suministroxlotexbodegainv.Cantidad) AS Existencia, SUM(i_suministroxlotexbodegainv.Conteo1) AS Conteo1, SUM(i_suministroxlotexbodegainv.Cantidad-i_suministroxlotexbodegainv.Conteo1) AS DConteo1, i_suministroxlotexbodegainv.Conteo2 AS Conteo2, SUM(i_suministroxlotexbodegainv.Cantidad-i_suministroxlotexbodegainv.Conteo2) AS DConteo2, i_suministroxbodegainv.Costo FROM i_suministroxbodegainv INNER JOIN i_inventario  ON (i_suministroxbodegainv.Id_inventario = i_inventario.Id) INNER JOIN i_suministroxlotexbodegainv  ON (i_suministroxbodegainv.Id_SuministroBodega = i_suministroxlotexbodegainv.Id) AND (i_suministroxbodegainv.Id_inventario = i_suministroxlotexbodegainv.Id_Inventario) INNER JOIN i_suministroxbodega   ON (i_suministroxbodega.IdBodega = i_inventario.Id_Bodega) AND (i_suministroxbodega.Id = i_suministroxlotexbodegainv.Id) INNER JOIN i_suministro  ON (i_suministroxbodega.IdSuministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id) INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id) WHERE (i_inventario.Id ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' ) GROUP BY i_suministroxlotexbodegainv.Id HAVING (DConteo2 <>0) ORDER BY i_suministro.Nbre ASC ";
            }
        }
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnfila++;
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), this.xnfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), this.xnfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), this.xnfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), this.xnfila, 3);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(5)), this.xnfila, 4);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), this.xnfila, 5);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(7)), this.xnfila, 6);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(8)), this.xnfila, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(9)), this.xnfila, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble("Costo")), this.xnfila, 9);
                    this.JTConsolidado.setDefaultRenderer(Object.class, new MiRender());
                }
                Principal.txtNo.setText("" + this.xnfila);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFMonitoreoInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDDetalle() {
        mCrearTablaDetalle();
        this.xsql = "SELECT Lote, FechaVencimiento, Cantidad, Conteo1, (Cantidad-Conteo1) AS DConteo1, Conteo2, (Cantidad-Conteo2) AS DConteo2 FROM i_suministroxlotexbodegainv WHERE (Id ='" + this.xmodelo.getValueAt(this.JTConsolidado.getSelectedRow(), 0) + "' AND Id_Inventario ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') ORDER BY Cantidad DESC ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xnfila1++;
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(xrs.getString(1), this.xnfila1, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), this.xnfila1, 1);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(3)), this.xnfila1, 2);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(4)), this.xnfila1, 3);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(5)), this.xnfila1, 4);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(6)), this.xnfila1, 5);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(7)), this.xnfila1, 6);
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFMonitoreoInventario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFMonitoreoInventario$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int atendido = -1;
            if (JIFMonitoreoInventario.JRBC1.isSelected()) {
                atendido = Integer.parseInt(table.getValueAt(row, 6).toString());
            } else if (JIFMonitoreoInventario.JRBC2.isSelected()) {
                atendido = Integer.parseInt(table.getValueAt(row, 8).toString());
            }
            if (atendido != 0) {
                cell.setBackground(new Color(133, 218, 160));
            } else {
                cell.setBackground(Color.WHITE);
            }
            return cell;
        }
    }

    public void mGrabar() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "update i_suministroxlotexbodegainv set Cantidad='" + this.xmodelo1.getValueAt(this.JTDetalle.getSelectedRow(), 2) + "', Conteo1='" + this.xmodelo1.getValueAt(this.JTDetalle.getSelectedRow(), 3) + "', Conteo2='" + this.xmodelo1.getValueAt(this.JTDetalle.getSelectedRow(), 5) + "' where Id='" + this.xmodelo.getValueAt(this.JTConsolidado.getSelectedRow(), 0) + "' and Id_Inventario ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' and Lote='" + this.xmodelo1.getValueAt(this.JTDetalle.getSelectedRow(), 0) + "'";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mBuscarDDetalle();
            }
        }
    }

    public void mImprimir() {
        String[][] parametros = new String[6][2];
        parametros[0][0] = "UsuarioS";
        parametros[0][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[1][0] = "Id";
        parametros[1][1] = this.xidbodega[this.JCBBodega.getSelectedIndex()];
        parametros[2][0] = "Tipo";
        parametros[2][1] = String.valueOf(this.xTipo);
        parametros[3][0] = "Filtro";
        parametros[3][1] = this.xFiltro;
        parametros[4][0] = "SUBREPORT_DIR";
        parametros[4][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        parametros[5][0] = "SUBREPORTFIRMA_DIR";
        parametros[5][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (this.JCH_VAgrupada.isSelected()) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_Diferencias_Inventario_N_Agrupado", parametros);
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_Diferencias_Inventario_N_Agrupado_Valores", parametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_Diferencias_Inventario_N", parametros);
        }
    }
}
