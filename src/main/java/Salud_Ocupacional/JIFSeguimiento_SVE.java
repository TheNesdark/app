package Salud_Ocupacional;

import Acceso.Principal;
import General.Anular;
import Historia.JDRegistro_SVE;
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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFSeguimiento_SVE.class */
public class JIFSeguimiento_SVE extends JInternalFrame {
    private File xfile;
    private DefaultTableModel xmodelo_tv;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo_h;
    private Object[] xdatos;
    private String xsql;
    private String[] xidperiodo;
    private String[] xid_tseguimiento;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroC;
    private JButton JBTActualizarUA;
    private JButton JBTExportar;
    private JButton JBTSGrabar;
    private JComboBox JCBPeriodo;
    private JComboBox JCBTiposSeguimiento;
    private JCheckBox JCHCSeguimiento;
    private JCheckBox JCHCerrado;
    private JCheckBox JCHEstado;
    private JCheckBox JCHFAlterado;
    private JCheckBox JCHFNoAlterado;
    private JCheckBox JCHFTodos;
    private JCheckBox JCHFVisualizarMP;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHFiltroAnalisis;
    private JCheckBox JCHSSeguimiento;
    private JCheckBox JCHUltimo;
    private JLabel JLBNTrabajadores;
    private JPanel JPDetalle;
    private JPanel JPIDConvenciones;
    private JPanel JPIDatosC;
    private JPanel JPIDatosS;
    private JPanel JPIFiltro;
    private JPanel JPIFiltroNombre;
    private JPanel JPISeguimiento;
    private JScrollPane JSPDescripcion_Seg;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPSHistorico;
    private JScrollPane JSPTipoVigilancia;
    private JTable JTBDetalle;
    private JTable JTBSHistorico;
    private JTable JTBTipoVigilancia;
    private JTextField JTFNombre;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JTextPane JTPDescripcion_Seg;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private ConsultasMySQL xct2 = new ConsultasMySQL();
    private boolean xlleno = false;
    private boolean xforma_busqueda = false;
    private boolean xllenoC = false;
    private int xtipo_anulacion = -1;
    private List<Integer> xfiltro_busqueda = new ArrayList();

    public JIFSeguimiento_SVE() {
        initComponents();
        mNuevo();
        this.JBTActualizarUA.setVisible(false);
    }

    /* JADX WARN: Type inference failed for: r3v129, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v93, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroC = new ButtonGroup();
        this.JPIDatosC = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JPIFiltro = new JPanel();
        this.JCHFAlterado = new JCheckBox();
        this.JCHFNoAlterado = new JCheckBox();
        this.JCHFTodos = new JCheckBox();
        this.JCHFVisualizarMP = new JCheckBox();
        this.JBTActualizarUA = new JButton();
        this.JCHEstado = new JCheckBox();
        this.JTPDatos = new JTabbedPane();
        this.JPDetalle = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JPIFiltroNombre = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHFiltro = new JCheckBox();
        this.JLBNTrabajadores = new JLabel();
        this.JPISeguimiento = new JPanel();
        this.JSPTipoVigilancia = new JScrollPane();
        this.JTBTipoVigilancia = new JTable();
        this.JPIDatosS = new JPanel();
        this.JCBTiposSeguimiento = new JComboBox();
        this.JSPDescripcion_Seg = new JScrollPane();
        this.JTPDescripcion_Seg = new JTextPane();
        this.JCHUltimo = new JCheckBox();
        this.JBTSGrabar = new JButton();
        this.JCHFiltroAnalisis = new JCheckBox();
        this.JSPSHistorico = new JScrollPane();
        this.JTBSHistorico = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPIDConvenciones = new JPanel();
        this.JCHSSeguimiento = new JCheckBox();
        this.JCHCSeguimiento = new JCheckBox();
        this.JCHCerrado = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("SEGUIMIENTO SVE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifseguimientosve");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCHFAlterado.setBackground(new Color(177, 251, 177));
        this.JBGFiltro.add(this.JCHFAlterado);
        this.JCHFAlterado.setFont(new Font("Arial", 1, 12));
        this.JCHFAlterado.setText("Alterados");
        this.JBGFiltro.add(this.JCHFNoAlterado);
        this.JCHFNoAlterado.setFont(new Font("Arial", 1, 12));
        this.JCHFNoAlterado.setText("No alterados");
        this.JBGFiltro.add(this.JCHFTodos);
        this.JCHFTodos.setFont(new Font("Arial", 1, 12));
        this.JCHFTodos.setSelected(true);
        this.JCHFTodos.setText("Todos");
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHFAlterado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFNoAlterado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFTodos).addContainerGap(-1, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFAlterado).addComponent(this.JCHFNoAlterado).addComponent(this.JCHFTodos)));
        this.JCHFVisualizarMP.setFont(new Font("Arial", 1, 12));
        this.JCHFVisualizarMP.setSelected(true);
        this.JCHFVisualizarMP.setText("Visualizar ManPower");
        this.JBTActualizarUA.setFont(new Font("Arial", 1, 12));
        this.JBTActualizarUA.setForeground(Color.red);
        this.JBTActualizarUA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTActualizarUA.setText("Actualizar Atención");
        this.JBTActualizarUA.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.1
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JBTActualizarUAActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.2
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeriodo, -2, 204, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPIFiltro, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCHFVisualizarMP).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTActualizarUA, -2, 197, -2).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHEstado).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodo, -2, 50, -2).addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHFVisualizarMP).addComponent(this.JPIFiltro, -2, -1, -2).addComponent(this.JBTActualizarUA, -2, 50, -2)))).addContainerGap(-1, 32767)));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.3
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimiento_SVE.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JPIFiltroNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA FILTRADA POR NOMBRE", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.4
            public void keyPressed(KeyEvent evt) {
                JIFSeguimiento_SVE.this.JTFNombreKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.5
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroNombreLayout = new GroupLayout(this.JPIFiltroNombre);
        this.JPIFiltroNombre.setLayout(JPIFiltroNombreLayout);
        JPIFiltroNombreLayout.setHorizontalGroup(JPIFiltroNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNombreLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 572, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap(-1, 32767)));
        JPIFiltroNombreLayout.setVerticalGroup(JPIFiltroNombreLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroNombreLayout.createSequentialGroup().addGroup(JPIFiltroNombreLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIFiltroNombreLayout.createSequentialGroup().addGap(0, 18, 32767).addComponent(this.JCHFiltro)).addComponent(this.JTFNombre)).addContainerGap()));
        this.JLBNTrabajadores.setBackground(new Color(255, 255, 255));
        this.JLBNTrabajadores.setFont(new Font("Arial", 1, 16));
        this.JLBNTrabajadores.setHorizontalAlignment(0);
        this.JLBNTrabajadores.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Exámenes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNTrabajadores.setOpaque(true);
        GroupLayout JPDetalleLayout = new GroupLayout(this.JPDetalle);
        this.JPDetalle.setLayout(JPDetalleLayout);
        JPDetalleLayout.setHorizontalGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalleLayout.createSequentialGroup().addComponent(this.JSPDetalle, -1, 993, 32767).addContainerGap()).addGroup(JPDetalleLayout.createSequentialGroup().addComponent(this.JPIFiltroNombre, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNTrabajadores, -2, 178, -2).addGap(28, 28, 28)))));
        JPDetalleLayout.setVerticalGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFiltroNombre, -1, -1, 32767).addComponent(this.JLBNTrabajadores, -1, -1, 32767)).addContainerGap()));
        this.JTPDatos.addTab("DETALLE", this.JPDetalle);
        this.JSPTipoVigilancia.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE VIGILANCIA", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTBTipoVigilancia.setFont(new Font("Arial", 1, 12));
        this.JTBTipoVigilancia.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBTipoVigilancia.setRowHeight(25);
        this.JTBTipoVigilancia.setSelectionBackground(new Color(255, 255, 255));
        this.JTBTipoVigilancia.setSelectionForeground(new Color(255, 0, 0));
        this.JTBTipoVigilancia.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.6
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimiento_SVE.this.JTBTipoVigilanciaMouseClicked(evt);
            }
        });
        this.JTBTipoVigilancia.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.7
            public void keyPressed(KeyEvent evt) {
                JIFSeguimiento_SVE.this.JTBTipoVigilanciaKeyPressed(evt);
            }
        });
        this.JSPTipoVigilancia.setViewportView(this.JTBTipoVigilancia);
        this.JPIDatosS.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA SEGUIMIENTO", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBTiposSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTiposSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPDescripcion_Seg.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTPDescripcion_Seg.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcion_Seg.setViewportView(this.JTPDescripcion_Seg);
        this.JCHUltimo.setFont(new Font("Arial", 1, 12));
        this.JCHUltimo.setText("Ultimo?");
        this.JBTSGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTSGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTSGrabar.setText("Grabar");
        this.JBTSGrabar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.8
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JBTSGrabarActionPerformed(evt);
            }
        });
        this.JCHFiltroAnalisis.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroAnalisis.setText("Filtro Analisis");
        GroupLayout JPIDatosSLayout = new GroupLayout(this.JPIDatosS);
        this.JPIDatosS.setLayout(JPIDatosSLayout);
        JPIDatosSLayout.setHorizontalGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTiposSeguimiento, 0, 697, 32767).addComponent(this.JSPDescripcion_Seg)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHUltimo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTSGrabar, -1, 189, 32767).addGroup(JPIDatosSLayout.createSequentialGroup().addComponent(this.JCHFiltroAnalisis, -2, 178, -2).addGap(0, 0, 32767))).addContainerGap()));
        JPIDatosSLayout.setVerticalGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosSLayout.createSequentialGroup().addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosSLayout.createSequentialGroup().addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTiposSeguimiento, -2, 50, -2).addGroup(JPIDatosSLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHFiltroAnalisis))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTSGrabar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDescripcion_Seg, -1, 94, 32767))).addGroup(JPIDatosSLayout.createSequentialGroup().addContainerGap(131, 32767).addComponent(this.JCHUltimo))).addContainerGap()));
        this.JSPSHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HÍSTORICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTBSHistorico.setFont(new Font("Arial", 1, 12));
        this.JTBSHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBSHistorico.setRowHeight(25);
        this.JTBSHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBSHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTBSHistorico.addKeyListener(new KeyAdapter() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.9
            public void keyPressed(KeyEvent evt) {
                JIFSeguimiento_SVE.this.JTBSHistoricoKeyPressed(evt);
            }
        });
        this.JSPSHistorico.setViewportView(this.JTBSHistorico);
        GroupLayout JPISeguimientoLayout = new GroupLayout(this.JPISeguimiento);
        this.JPISeguimiento.setLayout(JPISeguimientoLayout);
        JPISeguimientoLayout.setHorizontalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosS, -1, -1, 32767).addComponent(this.JSPSHistorico, -1, 993, 32767).addComponent(this.JSPTipoVigilancia)).addContainerGap()));
        JPISeguimientoLayout.setVerticalGroup(JPISeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPISeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPTipoVigilancia, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosS, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPSHistorico, -2, 172, -2).addContainerGap()));
        this.JTPDatos.addTab("SVE - SEGUIMIENTO", this.JPISeguimiento);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.10
            public void mouseClicked(MouseEvent evt) {
                JIFSeguimiento_SVE.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTFRuta.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.11
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JTFRutaActionPerformed(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.12
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JPIDConvenciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Convenciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHSSeguimiento.setBackground(new Color(251, 54, 54));
        this.JBGFiltroC.add(this.JCHSSeguimiento);
        this.JCHSSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCHSSeguimiento.setForeground(new Color(255, 255, 255));
        this.JCHSSeguimiento.setText("Sin seguimiento");
        this.JCHSSeguimiento.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.13
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JCHSSeguimientoActionPerformed(evt);
            }
        });
        this.JCHCSeguimiento.setBackground(Color.yellow);
        this.JBGFiltroC.add(this.JCHCSeguimiento);
        this.JCHCSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JCHCSeguimiento.setText("Con Seguimiento");
        this.JCHCSeguimiento.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.14
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JCHCSeguimientoActionPerformed(evt);
            }
        });
        this.JCHCerrado.setBackground(new Color(133, 218, 160));
        this.JBGFiltroC.add(this.JCHCerrado);
        this.JCHCerrado.setFont(new Font("Arial", 1, 12));
        this.JCHCerrado.setText("Cerrada");
        this.JCHCerrado.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.15
            public void actionPerformed(ActionEvent evt) {
                JIFSeguimiento_SVE.this.JCHCerradoActionPerformed(evt);
            }
        });
        GroupLayout JPIDConvencionesLayout = new GroupLayout(this.JPIDConvenciones);
        this.JPIDConvenciones.setLayout(JPIDConvencionesLayout);
        JPIDConvencionesLayout.setHorizontalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHSSeguimiento).addGap(18, 18, 18).addComponent(this.JCHCSeguimiento).addGap(18, 18, 18).addComponent(this.JCHCerrado, -2, 121, -2).addContainerGap(16, 32767)));
        JPIDConvencionesLayout.setVerticalGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConvencionesLayout.createSequentialGroup().addGroup(JPIDConvencionesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHSSeguimiento).addComponent(this.JCHCSeguimiento).addComponent(this.JCHCerrado)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDConvenciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFRuta, -2, 363, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 128, -2)).addComponent(this.JTPDatos).addComponent(this.JPIDatosC, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JTPDatos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JPIDConvenciones, -2, -1, -2)).addContainerGap()));
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
            if (this.JTBDetalle.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTBDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTBDetalle.getSelectedRow() != -1) {
            Object[] botones = {"Visualizar HC", "Registrar SVE - Seguimiento", "Seguimiento", "R.Llamadas", "Cerrar"};
            int y = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "SELECCIONAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            switch (y) {
                case 0:
                    String[][] mparametros = new String[4][2];
                    mparametros[0][0] = "idatencion1";
                    mparametros[0][1] = this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString();
                    mparametros[1][0] = "idpaciente1";
                    mparametros[1][1] = this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString();
                    mparametros[2][0] = "SUBREPORT_DIR";
                    mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
                    mparametros[3][0] = "SUBREPORTFIRMA_DIR";
                    mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
                    this.xmt.mGenerarGrafico(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString());
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_HistoriaClinicaSO_FPZ", mparametros);
                    break;
                case 1:
                    mCargarDatosTVigilancia();
                    mCrearModelo_H();
                    JDRegistro_SVE dialog = new JDRegistro_SVE(Principal.xclaseso.xjfp, true, Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString()).longValue());
                    dialog.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
                    dialog.setVisible(true);
                    break;
                case 2:
                    this.JTPDatos.setSelectedIndex(1);
                    mCargarDatosTVigilancia();
                    mCrearModelo_H();
                    break;
                case 3:
                    Principal.clasegeneral.cargarPantalla("Llamadas");
                    Principal.clasegeneral.frmLlamadas.frmPersona.txtHistoria.setText(this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
                    Principal.clasegeneral.frmLlamadas.frmPersona.buscar(2);
                    Principal.clasegeneral.frmLlamadas.cboServicio.setSelectedItem("SALUD OCUPACIONAL");
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTipoVigilanciaKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (this.JTBTipoVigilancia.getSelectedRow() != -1) {
            if (this.JTBTipoVigilancia.getSelectedColumn() == 3) {
                if (evt.getKeyCode() == 10) {
                    mActualizarDiasSeguimiento();
                }
            } else if (evt.getKeyCode() == 127) {
                System.out.println(this.JTBSHistorico.getRowCount());
                if (this.JTBSHistorico.getRowCount() == 0) {
                    this.xtipo_anulacion = 1;
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        Anular frm = new Anular(null, true, "SeguimientosSo", 33);
                        frm.setLocationRelativeTo(this);
                        frm.setVisible(true);
                        return;
                    }
                    return;
                }
                this.xtipo_anulacion = -1;
                JOptionPane.showInternalMessageDialog(this, "No se puede anular; tiene seguimiento activos", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBTipoVigilanciaMouseClicked(MouseEvent evt) {
        if (this.JTBTipoVigilancia.getSelectedRow() != -1) {
            this.xlleno = true;
            mNuevo_Rseguimiento();
            mCargarDatos_Historico();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSGrabarActionPerformed(ActionEvent evt) {
        if (this.JTBTipoVigilancia.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un SVE", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (Long.valueOf(this.xmodelo_tv.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 6).toString()).longValue() != -1) {
            if (this.JCBTiposSeguimiento.getSelectedIndex() != -1) {
                if (!this.JTPDescripcion_Seg.getText().isEmpty()) {
                    int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (y == 0) {
                        this.xlleno = false;
                        this.xsql = "insert into so_manpower_seguimiento_detalle_s (`Fecha_S`, `Id_Mp_SDetalle`, `Id_Vigilancia_S`, `Descrpcion`, `Id_Especialidad`, `Id_Profesional`, `UsuarioS` ) values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xmodelo_tv.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 0) + "','" + this.xid_tseguimiento[this.JCBTiposSeguimiento.getSelectedIndex()] + "','" + this.JTPDescripcion_Seg.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        if (this.JCHUltimo.isSelected()) {
                            this.xsql = "update so_manpower_seguimiento_detalle set `FechaUS`='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "', `FechaCierre`='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id='" + this.xmodelo_tv.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 0) + "'";
                        } else {
                            this.xsql = "update so_manpower_seguimiento_detalle set `FechaUS`='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id='" + this.xmodelo_tv.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 0) + "'";
                        }
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        mCargarDatos_Historico();
                        mNuevo_Rseguimiento();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La descripción no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPDescripcion_Seg.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de seguimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTiposSeguimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Este seguimiento ya se encuentra cerrado, no se puede agregar seguimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        if (!this.JTFNombre.getText().isEmpty()) {
            this.JCHFiltro.setSelected(true);
            mCargarDatosTablaD();
        } else {
            this.JCHFiltro.setSelected(false);
            mCargarDatosTablaD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarUAActionPerformed(ActionEvent evt) {
        if (this.JTBDetalle.getRowCount() != -1) {
            mActualizarDatosUltimaAtencion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBSHistoricoKeyPressed(KeyEvent evt) {
        if (this.JTBSHistorico.getSelectedRow() != -1 && evt.getKeyCode() == 127) {
            this.xtipo_anulacion = 0;
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "SeguimientosSo", 33);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSSeguimientoActionPerformed(ActionEvent evt) {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            this.xforma_busqueda = true;
            this.xfiltro_busqueda = new ArrayList();
            this.xfiltro_busqueda.add(2);
            this.xfiltro_busqueda.add(4);
            this.xWorkerSQL = new WorkerSQL("Buscando información", this);
            this.xWorkerSQL.execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCSeguimientoActionPerformed(ActionEvent evt) {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            this.xforma_busqueda = true;
            this.xfiltro_busqueda = new ArrayList();
            this.xfiltro_busqueda.add(1);
            this.xWorkerSQL = new WorkerSQL("Buscando información", this);
            this.xWorkerSQL.execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCerradoActionPerformed(ActionEvent evt) {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            this.xforma_busqueda = true;
            this.xfiltro_busqueda = new ArrayList();
            this.xfiltro_busqueda.add(3);
            this.xWorkerSQL = new WorkerSQL("Buscando información", this);
            this.xWorkerSQL.execute();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            mLLenarCombo(true);
        } else {
            mLLenarCombo(false);
        }
    }

    private void mActualizarDiasSeguimiento() {
        if (Long.valueOf(this.JTBTipoVigilancia.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 6).toString()).longValue() != -1) {
            this.xsql = "update so_manpower_seguimiento_detalle set NDiasS='" + this.JTBTipoVigilancia.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 3) + "' where  Id= '" + this.JTBTipoVigilancia.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 0) + "'";
            System.out.println(this.xsql);
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mCargarDatosTVigilancia();
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xforma_busqueda = false;
        this.xfiltro_busqueda = new ArrayList();
        this.xfiltro_busqueda.add(-1);
        this.JCHCSeguimiento.setSelected(false);
        this.JCHSSeguimiento.setSelected(false);
        this.JCHCerrado.setSelected(false);
        mCrearModeloDetalle();
        mCrearModeloTV();
        mCrearModelo_H();
        this.xtipo_anulacion = -1;
        mLLenarCombo(true);
    }

    private void mLLenarCombo(boolean xestado) {
        this.xllenoC = false;
        this.JCBPeriodo.removeAllItems();
        if (xestado) {
            this.xsql = "SELECT `cc_periodo_financiero`.`Id` , `cc_periodo_financiero`.`Nbre` FROM `so_manporwer_detalle` INNER JOIN  `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) WHERE (`so_manporwer_encabezado`.`Estado` =1) GROUP BY `cc_periodo_financiero`.`Id` ORDER BY `cc_periodo_financiero`.`FechaI` DESC";
        } else {
            this.xsql = "SELECT `cc_periodo_financiero`.`Id` , `cc_periodo_financiero`.`Nbre` FROM `so_manporwer_detalle` INNER JOIN  `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) WHERE (`so_manporwer_encabezado`.`Estado` =0) GROUP BY `cc_periodo_financiero`.`Id` ORDER BY `cc_periodo_financiero`.`FechaI` DESC";
        }
        this.xidperiodo = this.xct.llenarCombo(this.xsql, this.xidperiodo, this.JCBPeriodo);
        this.xct.cerrarConexionBd();
        this.xllenoC = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTV() {
        this.xmodelo_tv = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "Observación", "NDías", "FUSeguimiento", "FCierre", "CT", "Id_SV", "FPSeguimiento", "CSeguimiento"}) { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.16
            Class[] types = {Long.class, String.class, String.class, Long.class, String.class, String.class, Long.class, Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBTipoVigilancia.setModel(this.xmodelo_tv);
        this.JTBTipoVigilancia.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTBTipoVigilancia.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBTipoVigilancia.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBTipoVigilancia.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBTipoVigilancia.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBTipoVigilancia.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBTipoVigilancia.getColumnModel().getColumn(8).setPreferredWidth(5);
        this.JTBTipoVigilancia.getColumnModel().getColumn(9).setPreferredWidth(5);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_H() {
        this.xmodelo_h = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Tipo", "Descripción", "Especialidad", "Profesional"}) { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.17
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBSHistorico.setModel(this.xmodelo_h);
        this.JTBSHistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBSHistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBSHistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBSHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBSHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBSHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBSHistorico.getColumnModel().getColumn(4).setPreferredWidth(40);
        this.JTBSHistorico.getColumnModel().getColumn(5).setPreferredWidth(80);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Cédula", "Nombre", "Cargo", "Unidad", "#Seg", "Clasificación", "FPeriodico", "Estado", "Concepto", "Id_Atencion", "Id_Usuario", "EstadoS", "Restricción", "HConcepto", "U_FechaA", "Tipo_Cita", "UConceto", "RestricionesUC", "Tipo Proxima Consulta", "Fecha y Hora Proxima Consulta", "Edad", "Fecha_Ingreso", "Años_Antiguedad", "Sexo"}) { // from class: Salud_Ocupacional.JIFSeguimiento_SVE.18
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Long.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo1);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(24).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(24).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(24).setMaxWidth(0);
    }

    private void mCargarDatosTVigilancia() {
        try {
            mCrearModeloTV();
            this.xsql = "SELECT`so_manpower_seguimiento_detalle`.`Id`, `so_tipo_vigilancia`.`Nbre`, `so_manpower_seguimiento_detalle`.`Observacion`, `so_manpower_seguimiento_detalle`.`NDiasS`, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, '',date_format(`so_manpower_seguimiento_detalle`.`FechaUS`,'%d-%m-%Y')) AS `Fecha_US` , IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NULL, '',date_format(`so_manpower_seguimiento_detalle`.`FechaCierre`,'%d-%m-%Y')) AS `Fecha_Cierre` , IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC, `so_tipo_vigilancia`.`Id`, DATE_FORMAT(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY),'%d-%m-%Y') AS FP, COUNT(`so_manpower_seguimiento_detalle_s`.`Id`) AS `Canti` FROM  `so_manpower_seguimiento_detalle` INNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) LEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) INNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) WHERE (`so_manpower_seguimiento`.`Id_Manpower_Detalle` ='" + this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 0) + "' AND `so_manpower_seguimiento_detalle`.`Estado` =1) GROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY `so_tipo_vigilancia`.`Nbre` ASC ";
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                this.xmt.mEstablecerTextEditor(this.JTBTipoVigilancia, 2);
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo_tv.addRow(this.xdatos);
                    this.xmodelo_tv.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo_tv.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo_tv.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo_tv.setValueAt(Long.valueOf(xrs.getLong(4)), x, 3);
                    this.xmodelo_tv.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo_tv.setValueAt(xrs.getString(6), x, 5);
                    this.xmodelo_tv.setValueAt(Long.valueOf(xrs.getLong(7)), x, 6);
                    this.xmodelo_tv.setValueAt(Long.valueOf(xrs.getLong(8)), x, 7);
                    this.xmodelo_tv.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo_tv.setValueAt(Long.valueOf(xrs.getLong(10)), x, 9);
                    this.JTBTipoVigilancia.setDefaultRenderer(Object.class, new MiRender1());
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimiento_SVE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatos_Historico() {
        try {
            mCrearModelo_H();
            int filtro = 0;
            if (this.JCHFiltroAnalisis.isSelected()) {
                filtro = 1;
            }
            this.xsql = "SELECT `so_manpower_seguimiento_detalle_s`.`Id`, DATE_FORMAT(`so_manpower_seguimiento_detalle_s`.`Fecha_S`, '%d-%m-%Y') AS Fecha , `so_tipo_vigilancia_seguimiento`.`Nbre`, `so_manpower_seguimiento_detalle_s`.`Descrpcion`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional` FROM `so_manpower_seguimiento_detalle_s` INNER JOIN  `so_vigilancia_seguimiento`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Vigilancia_S` = `so_vigilancia_seguimiento`.`Id`) INNER JOIN  `so_tipo_vigilancia`  ON (`so_vigilancia_seguimiento`.`Id_TVigilancia` = `so_tipo_vigilancia`.`Id`) INNER JOIN  `so_tipo_vigilancia_seguimiento`  ON (`so_vigilancia_seguimiento`.`Id_TV_Seguimiento` = `so_tipo_vigilancia_seguimiento`.`Id`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `so_manpower_seguimiento_detalle_s`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `so_manpower_seguimiento_detalle_s`.`Id_Especialidad`)  INNER JOIN `so_manpower_seguimiento_detalle` ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) INNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) WHERE (so_manpower_seguimiento_detalle_s.`Id_Mp_SDetalle`='" + this.xmodelo_tv.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 0) + "' AND `so_manpower_seguimiento_detalle_s`.`Estado` =1  and so_tipo_vigilancia_seguimiento.filtroAnalisis='" + filtro + "' ) ORDER BY `so_manpower_seguimiento_detalle_s`.`Fecha_S` DESC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                this.xmt.mEstablecerTextEditor(this.JTBSHistorico, 2);
                this.xmt.mEstablecerTextEditor(this.JTBSHistorico, 3);
                int x = 0;
                while (xrs.next()) {
                    this.xmodelo_h.addRow(this.xdatos);
                    this.xmodelo_h.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xmodelo_h.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo_h.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo_h.setValueAt(xrs.getString(4), x, 3);
                    this.xmodelo_h.setValueAt(xrs.getString(5), x, 4);
                    this.xmodelo_h.setValueAt(xrs.getString(6), x, 5);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimiento_SVE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosTablaD() {
        try {
            this.JLBNTrabajadores.setText("0");
            mCrearModeloDetalle();
            if (this.xforma_busqueda) {
                this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE (concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2)  LIKE'" + this.JTFNombre.getText() + "%' and  `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\ninner join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\n where ifnull(s.FC, 0)  IN(" + this.xfiltro_busqueda.toString().replace("[", "").replace("]", "") + ") group by m.Id order by m.`NUsuario` asc\n";
            } else if (this.JCHFVisualizarMP.isSelected()) {
                if (this.JCHFiltro.isSelected()) {
                    this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE (concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2)  LIKE'" + this.JTFNombre.getText() + "%' and  `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\nleft join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\ngroup by m.Id order by m.`NUsuario` asc\n";
                } else {
                    this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE ( `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\nleft join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\ngroup by m.Id order by m.`NUsuario` asc\n";
                }
            } else if (this.JCHFTodos.isSelected()) {
                if (this.JCHFiltro.isSelected()) {
                    this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE (concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2)  LIKE'" + this.JTFNombre.getText() + "%' and  `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\nleft join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\ngroup by m.Id order by m.`NUsuario` asc\n";
                } else {
                    this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE (`so_manporwer_detalle`.`FechaPA` IS NOT NULL AND  `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\nleft join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\ngroup by m.Id order by m.`NUsuario` asc\n";
                }
            } else if (this.JCHFAlterado.isSelected()) {
                if (this.JCHFiltro.isSelected()) {
                    this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE (concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2)  LIKE'" + this.JTFNombre.getText() + "%' AND `so_manporwer_detalle`.`FechaPA` IS NOT NULL and  `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\nleft join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\ngroup by m.Id order by m.`NUsuario` asc\n";
                } else {
                    this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE (`so_manporwer_detalle`.`FechaPA` IS NOT NULL  AND `so_manporwer_detalle`.`Alterado`=1 and  `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\nleft join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\ngroup by m.Id order by m.`NUsuario` asc\n";
                }
            } else if (this.JCHFNoAlterado.isSelected()) {
                if (this.JCHFiltro.isSelected()) {
                    this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE (concat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2)  LIKE'" + this.JTFNombre.getText() + "%' AND `so_manporwer_detalle`.`FechaPA` IS NOT NULL AND `so_manporwer_detalle`.`Alterado`=0  and  `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\nleft join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\ngroup by m.Id order by m.`NUsuario` asc\n";
                } else {
                    this.xsql = "with  maestra as (\n\tSELECT \n\t`so_manporwer_detalle`.`Id`,\n\t`so_manporwer_detalle`.`Cedula`, \n\tconcat(gp.Apellido1,' ', gp.Apellido2,' ', gp.Nombre1,' ', gp.Nombre2) `NUsuario`\n\t, `g_cargos`.`Nbre` cargo\n\t, so_manporwer_detalle.`UnidadN`\n\t, `so_tipo_segmento`.`Nbre` nombreSegmento\n\t, `so_tipo_clasificacion`.`Nbre`  clasificacion\n\t, if(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA \n\t, `so_manporwer_detalle`.`Alterado`\n\t, `so_manporwer_detalle`.ConceptoI\n\t, `so_manporwer_detalle`.`Id_Atencion`\n\t, `so_manporwer_detalle`.`Id_Persona`\n\t, `so_manporwer_detalle`.EstadoS\n\t,IF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT\n\t, IF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC\n\t,TIMESTAMPDIFF(year , gp.FechaNac, now()) Edad \n\t,`so_manporwer_detalle`.`FEntrada`,\n\t`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) fechaEntrada\n\t, gs.Nbre  as NSexo \n\tFROM  `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)\n\tINNER JOIN g_persona gp  ON (`gp`.`Id` = `so_manporwer_detalle`.`Id_Persona`)   \n\tinner join g_sexo gs  on (gs.Id=gp.Id_Sexo)\n\tINNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `gp`.`Id`) \n\tINNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n\tINNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)\n\tINNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`) \n\tWHERE (`so_manporwer_detalle`.`FechaPA` IS NOT NULL  AND `so_manporwer_detalle`.`Alterado`=0  AND  `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "')\n\tORDER BY NUsuario  asc\n)\n, seguimiento as (\n\tSELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle` idDetalle\n\t,IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\n\tFROM  `so_manpower_seguimiento_detalle` \n\tINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n\tLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \n\tINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n\tinner join maestra m on (`so_manpower_seguimiento`.Id_Manpower_Detalle=m.Id)\n\tWHERE (`so_manpower_seguimiento_detalle`.`Estado` =1) \n\tGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC \n)\n, atencion as (\n\tselect  h_atencion.Id  idAtencion, DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         \n\t, IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\n\tObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n\t')) AS Restricicones \n\t, so_manporwer_detalle.Id  idDetalle\n\tFROM `so_manporwer_detalle` \n\tINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \n\tINNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) \n\tINNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) \n\tINNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) \n\tINNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) \n\tinner join maestra m on (`so_manporwer_detalle`.`Id`=m.Id)\n\tLEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) \n\tINNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tLEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) \n\tWHERE ( h_so_concepto_laboral.`Estado`=1)\n\tGROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  \n)\n, \ncita as (\n\tSELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  \n\t, `c_citas`.`Id_Usuario` idPersona\n\tFROM `c_citas` \n\tINNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) \n\tinner join maestra m on (m.Id_Persona=`c_citas`.`Id_Usuario`)\n\tWHERE (`c_citas`.`Fecha_Cita` >=NOW() AND  `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) \n)\n\nselect \nm.`Id`,\n\tm.`Cedula`, \n\tm.`NUsuario`\n\t,m.cargo\n\t, m.`UnidadN`\n\t, m.nombreSegmento\n\t, m.clasificacion\n\t, m.FechaPA \n\t, `m`.`Alterado`\n\t, `m`.ConceptoI\n\t, a.idAtencion\n\t, `m`.`Id_Persona`\n\t, ifnull(s.FC, 0) FC\n\t, m.RT\n\t, m.HC\n\t, m.Edad \n\t,`m`.`FEntrada`\n\t, m.fechaEntrada\n\t, m.NSexo  \n\t, ifnull(a.FAtencion, '')FAtencion\n\t, ifnull(a.ClaseCita, '')ClaseCita\n\t, ifnull(a.Concepto   , '')      Concepto\n\t, ifnull(a.Restricicones , '')Restricicones\n\t,  ifnull(c.`CCita` , '')CCita\n\t, ifnull(c.`FHora`   , '')FHora\nfrom maestra m\nleft join seguimiento s on (s.idDetalle=m.Id)\nleft join atencion a on (a.idDetalle=m.Id)\nleft join cita c on (c.idPersona=m.Id_Persona)\ngroup by m.Id order by m.`NUsuario` asc\n";
                }
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            int x = 0;
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
                    this.xmodelo1.setValueAt(xrs.getString(8), x, 7);
                    this.xmodelo1.setValueAt(Boolean.valueOf(xrs.getBoolean(9)), x, 8);
                    this.xmodelo1.setValueAt(xrs.getString(10), x, 9);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(11)), x, 10);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(12)), x, 11);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong("FC")), x, 12);
                    this.xmodelo1.setValueAt(xrs.getString(14), x, 13);
                    this.xmodelo1.setValueAt(xrs.getString(15), x, 14);
                    this.xmodelo1.setValueAt(xrs.getString("FAtencion"), x, 15);
                    this.xmodelo1.setValueAt(xrs.getString("ClaseCita"), x, 16);
                    this.xmodelo1.setValueAt(xrs.getString("Concepto"), x, 17);
                    this.xmodelo1.setValueAt(xrs.getString("Restricicones"), x, 18);
                    this.xmodelo1.setValueAt(xrs.getString("CCita"), x, 19);
                    this.xmodelo1.setValueAt(xrs.getString("FHora"), x, 20);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), x, 21);
                    this.xmodelo1.setValueAt(xrs.getString(17), x, 22);
                    this.xmodelo1.setValueAt(xrs.getString(18), x, 23);
                    this.xmodelo1.setValueAt(xrs.getString(19), x, 24);
                    this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            this.JLBNTrabajadores.setText("" + x);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimiento_SVE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private int mVerificaSeguimientos(int xid) {
        int estado = 0;
        String sql = "SELECT `so_manpower_seguimiento`.`Id_Manpower_Detalle`,\nIF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,3, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,2,  1))) AS FC\nFROM  `so_manpower_seguimiento_detalle` \nINNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \nLEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`) \nINNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \nWHERE (`so_manpower_seguimiento`.`Id_Manpower_Detalle` ='" + xid + "' AND `so_manpower_seguimiento_detalle`.`Estado` =1) \nGROUP BY `so_manpower_seguimiento_detalle`.`Id` ORDER BY FC ASC ";
        System.out.println("" + sql);
        try {
            ResultSet xrs = this.xct2.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    if (xrs.getInt("FC") == 2 || xrs.getInt("FC") == 3) {
                        estado = 2;
                        break;
                    }
                    if (xrs.getInt("FC") == 4) {
                        estado = 1;
                    } else if (xrs.getInt("FC") == 1) {
                        estado = 3;
                    }
                }
            }
            xrs.close();
            this.xct2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFSeguimiento_SVE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }

    public void mAnular(String xmotivo, String xobservacion) {
        if (this.xtipo_anulacion == 0) {
            this.xsql = "update  so_manpower_seguimiento_detalle_s set `Estado`=0, `MAnulacion`='" + xmotivo + "', `FAnulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',  `UAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `ObservacionA`='" + xobservacion + "' where Id='" + this.xmodelo_h.getValueAt(this.JTBSHistorico.getSelectedRow(), 0) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mCargarDatos_Historico();
            return;
        }
        if (this.xtipo_anulacion == 1) {
            this.xsql = "update  so_manpower_seguimiento_detalle set `Estado`=0, `MAnulacion`='" + xmotivo + "', `FAnulacion`='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "',  `UAnulacion`='" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `ObservacionA`='" + xobservacion + "' where Id='" + this.xmodelo_tv.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 0) + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mCargarDatosTVigilancia();
            mCargarDatos_Historico();
        }
    }

    public void mBuscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            this.xWorkerSQL = new WorkerSQL("Buscando información", this);
            this.xWorkerSQL.execute();
        }
    }

    public void mBuscarFiltrao() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            this.xWorkerSQL = new WorkerSQL("Buscando información", this);
            this.xWorkerSQL.execute();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFSeguimiento_SVE$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 12) != null) {
                switch (Integer.valueOf(table.getValueAt(row, 12).toString()).intValue()) {
                    case 0:
                        cell.setBackground(new Color(255, 255, 255));
                        cell.setForeground(Color.BLACK);
                        break;
                    case 1:
                        cell.setBackground(Color.YELLOW);
                        cell.setForeground(Color.BLACK);
                        break;
                    case 2:
                        cell.setBackground(new Color(251, 54, 54));
                        cell.setForeground(Color.BLACK);
                        break;
                    case 3:
                        cell.setBackground(new Color(133, 218, 160));
                        cell.setForeground(Color.BLACK);
                        break;
                }
                return cell;
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
                    sheet.addCell(new Label(8, x2 + 1, this.xmodelo1.getValueAt(x2, 8).toString()));
                    sheet.addCell(new Label(9, x2 + 1, this.xmodelo1.getValueAt(x2, 9).toString()));
                }
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFSeguimiento_SVE.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFSeguimiento_SVE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFSeguimiento_SVE$MiRender1.class */
    public class MiRender1 extends DefaultTableCellRenderer {
        public MiRender1() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xestado = Long.valueOf(table.getValueAt(row, 6).toString()).longValue();
            if (xestado == 3) {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            } else if (xestado == 1) {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            } else if (xestado == 2) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mNuevo_Rseguimiento() {
        this.JCBTiposSeguimiento.removeAllItems();
        if (this.xlleno) {
            this.xsql = "SELECT `so_vigilancia_seguimiento`.`Id`, `so_tipo_vigilancia_seguimiento`.`Nbre` FROM  `so_vigilancia_seguimiento` INNER JOIN`so_tipo_vigilancia_seguimiento`  ON (`so_vigilancia_seguimiento`.`Id_TV_Seguimiento` = `so_tipo_vigilancia_seguimiento`.`Id`) WHERE (`so_vigilancia_seguimiento`.`Id_TVigilancia` ='" + this.xmodelo_tv.getValueAt(this.JTBTipoVigilancia.getSelectedRow(), 7) + "') ORDER BY `so_tipo_vigilancia_seguimiento`.`Nbre` ASC ";
            this.xid_tseguimiento = this.xct.llenarCombo(this.xsql, this.xid_tseguimiento, this.JCBTiposSeguimiento);
            this.JCBTiposSeguimiento.setSelectedIndex(-1);
        }
        this.JTPDescripcion_Seg.setText("");
        this.JCHUltimo.setSelected(false);
    }

    private void mActualizarDatosUltimaAtencion() {
        for (int x = 0; x < this.JTBDetalle.getRowCount(); x++) {
            try {
                ConsultasMySQL xct1 = new ConsultasMySQL();
                this.xsql = "SELECT DATE_FORMAT(`h_atencion`.`Fecha_Atencion`,'%d-%m-%Y') AS FAtencion, `c_clasecita`.`Nbre` AS ClaseCita, `so_tipo_concepto`.`Nbre` AS Concepto         , IF(`so_tipo_restriccion`.`Nbre` IS NULL,'', GROUP_CONCAT( CONCAT(IF(`so_tipo_restriccion`.`Nbre` IS NULL, '',`so_tipo_restriccion`.`Nbre`), CONCAT('\tTipo : ', IF(`h_so_concepto_laboral_restricciones`.`Tipo`=0, 'Temporal','Permanente')),'\tN° Días : ',IF(`h_so_concepto_laboral_restricciones`.`NDias`=0, '',`h_so_concepto_laboral_restricciones`.`NDias`), IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '',CONCAT('\nObservación',`h_so_concepto_laboral_restricciones`.`Observacion`)) ) SEPARATOR '\n')) AS Restricicones FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `ingreso`  ON (`ingreso`.`Id_Usuario` = `so_manporwer_detalle`.`Id_Persona`) INNER JOIN `h_atencion`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) LEFT JOIN `h_so_concepto_laboral_restricciones`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) LEFT JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) WHERE (`so_manporwer_detalle`.`Id` ='" + this.xmodelo1.getValueAt(x, 0) + "' AND h_so_concepto_laboral.`Estado`=1) GROUP BY `h_so_concepto_laboral`.`Id` ORDER BY `h_atencion`.`Fecha_Atencion` DESC  ";
                System.out.println(this.xsql);
                ResultSet xrs = xct1.traerRs(this.xsql);
                if (xrs.next()) {
                    this.xmodelo1.setValueAt(xrs.getString(1), x, 15);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 16);
                    this.xmodelo1.setValueAt(xrs.getString(3), x, 17);
                    this.xmodelo1.setValueAt(xrs.getString(4), x, 18);
                }
                xrs.close();
                xct1.cerrarConexionBd();
                this.xsql = "SELECT `c_clasecita`.`Nbre` AS `CCita`, CONCAT(DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y'),' ' ,`c_citas`.`HoraInicial`)  AS `FHora`  FROM `c_citas` INNER JOIN `c_clasecita`  ON (`c_citas`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`c_citas`.`Fecha_Cita` >=NOW() AND `c_citas`.`Id_Usuario` ='" + this.xmodelo1.getValueAt(x, 11) + "' AND `c_citas`.`Id_Especialidad` =690 AND `c_citas`.`Id_MotivoDesistida` =1) ";
                ResultSet xrs2 = xct1.traerRs(this.xsql);
                if (xrs2.next()) {
                    this.xmodelo1.setValueAt(xrs2.getString(1), x, 19);
                    this.xmodelo1.setValueAt(xrs2.getString(2), x, 20);
                }
                xrs2.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFSeguimiento_SVE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }
}
