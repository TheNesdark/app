package Salud_Ocupacional;

import Acceso.Principal;
import Facturacion.Paquetes;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFG_Periodicos.class */
public class JIFG_Periodicos extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xsql;
    private String xsql1;
    private String[] xidperiodo;
    private String[] xidunidad;
    private JButton JBTExportar;
    private JComboBox JCBPeriodo;
    private JComboBox JCBUnidad;
    private JCheckBox JCHAdministrativos;
    private JCheckBox JCHAplica;
    private JCheckBox JCHEspecial;
    private JCheckBox JCHFiltroT;
    private JCheckBox JCHPExpuestos;
    private JDateChooser JDFechaI;
    private JLabel JLBNRegistrados;
    private JLabel JLBNTrabajadores;
    private JPanel JPDetalle;
    private JPanel JPIDatosC;
    private JPanel JPIFiltro;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    private JTable JTBConsolidado;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;

    public JIFG_Periodicos() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v79, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatosC = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JPIFiltro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JCBUnidad = new JComboBox();
        this.JCHAplica = new JCheckBox();
        this.JCHFiltroT = new JCheckBox();
        this.JTPDatos = new JTabbedPane();
        this.JPDetalle = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JLBNTrabajadores = new JLabel();
        this.JLBNRegistrados = new JLabel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHEspecial = new JCheckBox();
        this.JCHAdministrativos = new JCheckBox();
        this.JCHPExpuestos = new JCheckBox();
        this.JSPConsolidado = new JScrollPane();
        this.JTBConsolidado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE EXÁMENES PERIÓDICOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifgestionep");
        this.JPIDatosC.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTAR INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBPeriodo.addItemListener(new ItemListener() { // from class: Salud_Ocupacional.JIFG_Periodicos.1
            public void itemStateChanged(ItemEvent evt) {
                JIFG_Periodicos.this.JCBPeriodoItemStateChanged(evt);
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JCBUnidad.setFont(new Font("Arial", 1, 12));
        this.JCBUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad de Negocio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHAplica.setFont(new Font("Arial", 1, 12));
        this.JCHAplica.setText("Aplica?");
        this.JCHAplica.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFG_Periodicos.2
            public void actionPerformed(ActionEvent evt) {
                JIFG_Periodicos.this.JCHAplicaActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 115, -2).addGap(18, 18, 18).addComponent(this.JCBUnidad, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JCHAplica)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHAplica).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JCBUnidad, -2, 50, -2))).addGap(0, 16, 32767)));
        this.JCHFiltroT.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroT.setText("Todos?");
        this.JCHFiltroT.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFG_Periodicos.3
            public void actionPerformed(ActionEvent evt) {
                JIFG_Periodicos.this.JCHFiltroTActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosCLayout = new GroupLayout(this.JPIDatosC);
        this.JPIDatosC.setLayout(JPIDatosCLayout);
        JPIDatosCLayout.setHorizontalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodo, -2, 204, -2).addComponent(this.JCHFiltroT)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIFiltro, -1, -1, 32767).addContainerGap()));
        JPIDatosCLayout.setVerticalGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIFiltro, -2, -1, -2).addGroup(JPIDatosCLayout.createSequentialGroup().addComponent(this.JCBPeriodo, -2, 50, -2).addGap(18, 18, 18).addComponent(this.JCHFiltroT))).addContainerGap(-1, 32767)));
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFG_Periodicos.4
            public void mouseClicked(MouseEvent evt) {
                JIFG_Periodicos.this.JTBDetalleMouseClicked(evt);
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
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFG_Periodicos.5
            public void mouseClicked(MouseEvent evt) {
                JIFG_Periodicos.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFG_Periodicos.6
            public void actionPerformed(ActionEvent evt) {
                JIFG_Periodicos.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHEspecial.setBackground(new Color(251, 54, 54));
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setSelected(true);
        this.JCHEspecial.setText("Por programar");
        this.JCHAdministrativos.setBackground(new Color(133, 218, 160));
        this.JCHAdministrativos.setFont(new Font("Arial", 1, 12));
        this.JCHAdministrativos.setSelected(true);
        this.JCHAdministrativos.setText("Asistidos");
        this.JCHPExpuestos.setBackground(Color.yellow);
        this.JCHPExpuestos.setFont(new Font("Arial", 1, 12));
        this.JCHPExpuestos.setSelected(true);
        this.JCHPExpuestos.setText("Programados");
        GroupLayout JPDetalleLayout = new GroupLayout(this.JPDetalle);
        this.JPDetalle.setLayout(JPDetalleLayout);
        JPDetalleLayout.setHorizontalGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 962, 32767).addGroup(JPDetalleLayout.createSequentialGroup().addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCHEspecial, -1, 125, 32767).addComponent(this.JCHPExpuestos, -1, -1, 32767)).addGap(18, 18, 18).addComponent(this.JCHAdministrativos, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNTrabajadores, -2, 118, -2).addGap(18, 18, 18).addComponent(this.JLBNRegistrados, -2, 118, -2).addGap(18, 18, 18).addComponent(this.JTFRuta, -2, 207, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2))).addContainerGap()));
        JPDetalleLayout.setVerticalGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDetalleLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle, -1, 384, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(JPDetalleLayout.createSequentialGroup().addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEspecial).addComponent(this.JCHAdministrativos)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHPExpuestos)).addComponent(this.JLBNTrabajadores, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPDetalleLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNRegistrados, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 50, -2)))).addContainerGap()));
        this.JTPDatos.addTab("DETALLE", this.JPDetalle);
        this.JTBConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTBConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBConsolidado.setRowHeight(25);
        this.JTBConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBConsolidado.setSelectionForeground(new Color(255, 0, 0));
        this.JSPConsolidado.setViewportView(this.JTBConsolidado);
        this.JTPDatos.addTab("CONSOLIDADO", this.JSPConsolidado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosC, -1, -1, 32767).addComponent(this.JTPDatos)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -1, 503, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBPeriodoItemStateChanged(ItemEvent evt) {
        mLlenarComboUnidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaActionPerformed(ActionEvent evt) {
        mLlenarComboUnidad();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroTActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            Object[] botones = {"Asignar Cita", "Procedimientos por SEG", "Registro de llamadas", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "CONSULTAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "Citas");
                Principal.clasescita.setXid_manpower(Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 15).toString()).longValue());
                Principal.clasescita.frmCita.frmPersona.txtHistoria.setText(this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                Principal.clasescita.frmCita.frmPersona.buscar(2);
                return;
            }
            if (n == 1) {
                Paquetes frmPq = new Paquetes(null, true, false, Integer.valueOf(this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 20).toString()).intValue(), Long.valueOf(this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 22).toString()).longValue(), new Long(14L).longValue(), null, "0", "", "");
                frmPq.setVisible(true);
            } else if (n == 2) {
                Principal.clasegeneral.cargarPantalla("Llamadas");
                Principal.clasegeneral.frmLlamadas.frmPersona.txtHistoria.setText(this.xmodelo1.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
                Principal.clasegeneral.frmLlamadas.frmPersona.buscar(2);
                Principal.clasegeneral.frmLlamadas.cboServicio.setSelectedItem("SALUD OCUPACIONAL");
            }
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBPeriodo.removeAllItems();
        this.xsql = "SELECT `cc_periodo_financiero`.`Id`, `cc_periodo_financiero`.`Nbre` FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) WHERE (`so_manporwer_encabezado`.`Estado` =1) GROUP BY `cc_periodo_financiero`.`Id` ORDER BY `cc_periodo_financiero`.`FechaI` DESC ";
        this.xidperiodo = this.xct.llenarCombo(this.xsql, this.xidperiodo, this.JCBPeriodo);
        this.xct.cerrarConexionBd();
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        mCrearModeloC();
        mCrearModeloDetalle();
        this.xlleno = true;
    }

    private void mLlenarComboUnidad() {
        if (this.xlleno && this.JCBPeriodo.getSelectedIndex() != -1) {
            this.JCBUnidad.removeAllItems();
            this.xsql = "SELECT `g_persona`.`Id` , `so_manporwer_detalle`.`UnidadN`     FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`) WHERE (`g_persona`.`FEPeriodico` IS NOT NULL AND `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL 360 DAY)  <='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `so_manporwer_encabezado`.`Estado` =1) GROUP BY `so_manporwer_detalle`.`UnidadN`     ORDER BY `so_manporwer_detalle`.`UnidadN` ASC ";
            this.xidunidad = this.xct.llenarCombo(this.xsql, this.xidunidad, this.JCBUnidad);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Cédula", "TContrato", "Nombre", "FEntrada", "Supervisor", "Grupo", "Email", "Unidad", "FUPeriódico", "FPPeriódico", "DDías", "FIngreso", "#Seg", "Tipo", "Id_Clas", "Id", "Id_Citas", "F_Cita", "Id_Ingreso", "F_Atención", "Id_Seg", "Edad", "Id_Persona"}) { // from class: Salud_Ocupacional.JIFG_Periodicos.7
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class, String.class, String.class, Long.class, Long.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo1);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
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
        this.JTBDetalle.getColumnModel().getColumn(17).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloC() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Unidad", "Cantidad", "%"}) { // from class: Salud_Ocupacional.JIFG_Periodicos.8
            Class[] types = {String.class, Long.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBConsolidado.setModel(this.xmodelo);
        this.JTBConsolidado.getColumnModel().getColumn(0).setPreferredWidth(300);
        this.JTBConsolidado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBConsolidado.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    public void mBuscar() {
        if (this.JCHAplica.isSelected()) {
            if (this.JCBUnidad.getSelectedIndex() != -1) {
                if (this.JCHFiltroT.isSelected()) {
                    this.xsql = "SELECT  `so_manporwer_detalle`.`Cedula`, `so_manporwer_detalle`.`TContrato1`, `so_manporwer_detalle`.`Nombre_Completo`, `so_manporwer_detalle`.`FEntrada`,`supervisor`.NSupervisor, `so_tipo_grupo`.`Nbre`  AS Grupo, `so_manporwer_detalle`.`Email` , `so_manporwer_detalle`.`UnidadN`, IF(`g_persona`.`FEPeriodico` IS NULL, 'NO TIENE', `g_persona`.`FEPeriodico`) AS FPeriodico, IF(`g_persona`.`FEPeriodico` IS NULL, 'NO TIENE',ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY))  AS `FNPeriodico` , IF(`g_persona`.`FEPeriodico` IS NULL, 0, DATEDIFF(ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY), NOW())) AS `NDiasD`, `so_manporwer_detalle`.`FEntrada`, so_tipo_segmento.`Nbre`, so_tipo_segmento.`Tipo`, so_tipo_clasificacion.`Id`, `so_manporwer_detalle`.`Id`,`so_manporwer_detalle`.`Id_Cita`, IF(`so_manporwer_detalle`.`FProgramacion` IS NULL, '', `so_manporwer_detalle`.`FProgramacion`) AS FCita, `so_tipo_segmento`.`Id`,`Devuelve_Edad`(`g_persona`.`FechaNac` ), `g_persona`.`Id`  FROM `so_manporwer_detalle`  INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)  INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`)  INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`) INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`) INNER JOIN `so_tipo_segmento`  ON (`so_tipo_segmento`.`Id` = `g_usuario`.`Id_Segmento`)  INNER JOIN `so_tipo_grupo`  ON (`so_tipo_grupo`.`Id` = `g_usuario`.`Id_TipoGrupo`)  INNER JOIN `supervisor`  ON (`supervisor`.`Id_Persona` = `g_usuario`.`Id_Supervisor`) INNER JOIN `so_tipo_clasificacion`  ON (`so_tipo_clasificacion`.`Id` = `so_manporwer_detalle`.`Id_Clasificacion`)  WHERE (`so_manporwer_detalle`.`UnidadN`='" + this.JCBUnidad.getSelectedItem() + "' and `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "'  AND `so_manporwer_encabezado`.`Estado` =1)  GROUP BY so_manporwer_detalle.`Cedula` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC, `so_manporwer_detalle`.`Nombre_Completo` ASC ";
                    mCargarDatosTablaD();
                    this.xsql1 = "SELECT  `so_manporwer_detalle`.`UnidadN`, COUNT(`so_manporwer_detalle`.`UnidadN`) AS Cantidad  FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`   ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`) INNER JOIN `so_tipo_clasificacion`  ON (`so_tipo_clasificacion`.`Id` = `so_manporwer_detalle`.`Id_Clasificacion`) WHERE (`so_manporwer_detalle`.`UnidadN`='" + this.JCBUnidad.getSelectedItem() + "'  AND `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "'  AND `so_manporwer_encabezado`.`Estado` =1) GROUP BY `so_manporwer_detalle`.`UnidadN` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC ";
                    mCargarDatosTablaC();
                    return;
                }
                this.xsql = "SELECT  `so_manporwer_detalle`.`Cedula`, `so_manporwer_detalle`.`TContrato1`, `so_manporwer_detalle`.`Nombre_Completo`, `so_manporwer_detalle`.`FEntrada`,`supervisor`.NSupervisor, `so_tipo_grupo`.`Nbre`  AS Grupo, `so_manporwer_detalle`.`Email` , `so_manporwer_detalle`.`UnidadN`, IF(`g_persona`.`FEPeriodico` IS NULL, 'NO TIENE', `g_persona`.`FEPeriodico`) AS FPeriodico, IF(`g_persona`.`FEPeriodico` IS NULL, 'NO TIENE',ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY))  AS `FNPeriodico` , IF(`g_persona`.`FEPeriodico` IS NULL, 0, DATEDIFF(ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY), NOW())) AS `NDiasD`, `so_manporwer_detalle`.`FEntrada`, so_tipo_segmento.`Nbre`, so_tipo_segmento.`Tipo`, so_tipo_clasificacion.`Id`, `so_manporwer_detalle`.`Id`,`so_manporwer_detalle`.`Id_Cita`, IF(`so_manporwer_detalle`.`FProgramacion` IS NULL, '', `so_manporwer_detalle`.`FProgramacion`) AS FCita, `so_tipo_segmento`.`Id`,`Devuelve_Edad`(`g_persona`.`FechaNac` ),`g_persona`.`Id`  FROM `so_manporwer_detalle`  INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)  INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`)  INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`) INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`) INNER JOIN `so_tipo_segmento`  ON (`so_tipo_segmento`.`Id` = `g_usuario`.`Id_Segmento`)  INNER JOIN `so_tipo_grupo`  ON (`so_tipo_grupo`.`Id` = `g_usuario`.`Id_TipoGrupo`)  INNER JOIN `supervisor`  ON (`supervisor`.`Id_Persona` = `g_usuario`.`Id_Supervisor`)  INNER JOIN `so_tipo_clasificacion`  ON (`so_tipo_clasificacion`.`Id` = `so_manporwer_detalle`.`Id_Clasificacion`)  WHERE (`so_manporwer_detalle`.`UnidadN`='" + this.JCBUnidad.getSelectedItem() + "' and  `g_persona`.`FEPeriodico` IS NOT NULL AND `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY)  <='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `so_manporwer_encabezado`.`Estado` =1)  GROUP BY so_manporwer_detalle.`Cedula` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC, `so_manporwer_detalle`.`Nombre_Completo` ASC ";
                mCargarDatosTablaD();
                this.xsql1 = "SELECT  `so_manporwer_detalle`.`UnidadN`, COUNT(`so_manporwer_detalle`.`UnidadN`) AS Cantidad  FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`   ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`)  INNER JOIN `so_tipo_clasificacion`  ON (`so_tipo_clasificacion`.`Id` = `so_manporwer_detalle`.`Id_Clasificacion`) WHERE (`so_manporwer_detalle`.`UnidadN`='" + this.JCBUnidad.getSelectedItem() + "' and  `g_persona`.`FEPeriodico` IS NOT NULL AND `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY)  <='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `so_manporwer_encabezado`.`Estado` =1) GROUP BY `so_manporwer_detalle`.`UnidadN` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC ";
                mCargarDatosTablaC();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUnidad.requestFocus();
            return;
        }
        if (this.JCHFiltroT.isSelected()) {
            this.xsql = "SELECT  `so_manporwer_detalle`.`Cedula`, `so_manporwer_detalle`.`TContrato1`, `so_manporwer_detalle`.`Nombre_Completo`, `so_manporwer_detalle`.`FEntrada`,`supervisor`.NSupervisor, `so_tipo_grupo`.`Nbre`  AS Grupo, `so_manporwer_detalle`.`Email` , `so_manporwer_detalle`.`UnidadN`, IF(`g_persona`.`FEPeriodico` IS NULL, 'NO TIENE', `g_persona`.`FEPeriodico`) AS FPeriodico, IF(`g_persona`.`FEPeriodico` IS NULL, 'NO TIENE',ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY))  AS `FNPeriodico` , IF(`g_persona`.`FEPeriodico` IS NULL, 0, DATEDIFF(ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY), NOW())) AS `NDiasD`, `so_manporwer_detalle`.`FEntrada`, so_tipo_segmento.`Nbre`, so_tipo_segmento.`Tipo`, so_tipo_clasificacion.`Id`, `so_manporwer_detalle`.`Id`,`so_manporwer_detalle`.`Id_Cita`, IF(`so_manporwer_detalle`.`FProgramacion` IS NULL, '', `so_manporwer_detalle`.`FProgramacion`) AS FCita, `so_tipo_segmento`.`Id`,`Devuelve_Edad`(`g_persona`.`FechaNac` ), `g_persona`.`Id`  FROM `so_manporwer_detalle`  INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)  INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`)  INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`) INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`) INNER JOIN `so_tipo_segmento`  ON (`so_tipo_segmento`.`Id` = `g_usuario`.`Id_Segmento`)  INNER JOIN `so_tipo_grupo`  ON (`so_tipo_grupo`.`Id` = `g_usuario`.`Id_TipoGrupo`)  INNER JOIN `supervisor`  ON (`supervisor`.`Id_Persona` = `g_usuario`.`Id_Supervisor`)  INNER JOIN `so_tipo_clasificacion`  ON (`so_tipo_clasificacion`.`Id` = `so_manporwer_detalle`.`Id_Clasificacion`)  WHERE (`so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "'  AND `so_manporwer_encabezado`.`Estado` =1)  GROUP BY so_manporwer_detalle.`Cedula` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC, `so_manporwer_detalle`.`Nombre_Completo` ASC ";
            mCargarDatosTablaD();
            this.xsql1 = "SELECT  `so_manporwer_detalle`.`UnidadN`, COUNT(`so_manporwer_detalle`.`UnidadN`) AS Cantidad  FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`   ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`)  INNER JOIN `so_tipo_clasificacion`  ON (`so_tipo_clasificacion`.`Id` = `so_manporwer_detalle`.`Id_Clasificacion`) WHERE ( `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "'  AND `so_manporwer_encabezado`.`Estado` =1) GROUP BY `so_manporwer_detalle`.`UnidadN` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC ";
            mCargarDatosTablaC();
            return;
        }
        this.xsql = "SELECT  `so_manporwer_detalle`.`Cedula`, `so_manporwer_detalle`.`TContrato1`, `so_manporwer_detalle`.`Nombre_Completo`, `so_manporwer_detalle`.`FEntrada`,`supervisor`.NSupervisor, `so_tipo_grupo`.`Nbre`  AS Grupo, `so_manporwer_detalle`.`Email` , `so_manporwer_detalle`.`UnidadN`, IF(`g_persona`.`FEPeriodico` IS NULL, 'NO TIENE', `g_persona`.`FEPeriodico`) AS FPeriodico, IF(`g_persona`.`FEPeriodico` IS NULL, 'NO TIENE',ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY))  AS `FNPeriodico` , IF(`g_persona`.`FEPeriodico` IS NULL, 0, DATEDIFF(ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY), NOW())) AS `NDiasD`, `so_manporwer_detalle`.`FEntrada`, so_tipo_segmento.`Nbre`, so_tipo_segmento.`Tipo`, so_tipo_clasificacion.`Id`, `so_manporwer_detalle`.`Id`,`so_manporwer_detalle`.`Id_Cita`, IF(`so_manporwer_detalle`.`FProgramacion` IS NULL, '', `so_manporwer_detalle`.`FProgramacion`) AS FCita, `so_tipo_segmento`.`Id`,`Devuelve_Edad`(`g_persona`.`FechaNac` ), `g_persona`.`Id`  FROM `so_manporwer_detalle`  INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)  INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`)  INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`) INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`) INNER JOIN `so_tipo_segmento`  ON (`so_tipo_segmento`.`Id` = `g_usuario`.`Id_Segmento`)  INNER JOIN `so_tipo_grupo`  ON (`so_tipo_grupo`.`Id` = `g_usuario`.`Id_TipoGrupo`)  INNER JOIN `supervisor`  ON (`supervisor`.`Id_Persona` = `g_usuario`.`Id_Supervisor`)  INNER JOIN `so_tipo_clasificacion`  ON (`so_tipo_clasificacion`.`Id` = `so_manporwer_detalle`.`Id_Clasificacion`)  WHERE (`g_persona`.`FEPeriodico` IS NOT NULL AND `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY)  <='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `so_manporwer_encabezado`.`Estado` =1)  GROUP BY so_manporwer_detalle.`Cedula` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC, `so_manporwer_detalle`.`Nombre_Completo` ASC ";
        mCargarDatosTablaD();
        this.xsql1 = "SELECT  `so_manporwer_detalle`.`UnidadN`, COUNT(`so_manporwer_detalle`.`UnidadN`) AS Cantidad  FROM `so_manporwer_detalle` INNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`   ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) INNER JOIN `g_persona`  ON (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`) INNER JOIN `so_tipo_clasificacion`  ON (`so_tipo_clasificacion`.`Id` = `so_manporwer_detalle`.`Id_Clasificacion`) WHERE (`g_persona`.`FEPeriodico` IS NOT NULL AND `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' AND ADDDATE(`g_persona`.`FEPeriodico`, INTERVAL so_tipo_clasificacion.`NDiasP` DAY)  <='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND `so_manporwer_encabezado`.`Estado` =1)  GROUP BY `so_manporwer_detalle`.`UnidadN` ORDER BY `so_manporwer_detalle`.`UnidadN` ASC ";
        mCargarDatosTablaC();
    }

    private void mCargarDatosTablaD() {
        try {
            mCrearModeloDetalle();
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
                    this.xmodelo1.setValueAt(xrs.getString(9), x, 8);
                    this.xmodelo1.setValueAt(xrs.getString(10), x, 9);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(11)), x, 10);
                    this.xmodelo1.setValueAt(xrs.getString(12), x, 11);
                    this.xmodelo1.setValueAt(xrs.getString(13), x, 12);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(14)), x, 13);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(15)), x, 14);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), x, 15);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(17)), x, 16);
                    this.xmodelo1.setValueAt(xrs.getString(18), x, 17);
                    this.xmodelo1.setValueAt(Long.valueOf(mConsultar_Ingreso_Cita(xrs.getLong(17))), x, 18);
                    this.xmodelo1.setValueAt(mConsultar_Ingreso_Atencion(Long.valueOf(this.xmodelo1.getValueAt(x, 18).toString()).longValue()), x, 19);
                    this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodelo1.setValueAt(xrs.getString(19), x, 20);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(20)), x, 21);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(21)), x, 22);
                    x++;
                }
            }
            this.JLBNTrabajadores.setText("" + x);
            this.JLBNRegistrados.setText("0");
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaC() {
        try {
            mCrearModeloC();
            ResultSet xrs = this.xct.traerRs(this.xsql1);
            int x = 0;
            System.out.println(this.xsql1);
            DecimalFormat xformato = new DecimalFormat("###.##");
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(2)), x, 1);
                    double xvalor = (xrs.getLong(2) / Double.valueOf(this.JLBNTrabajadores.getText()).doubleValue()) * 100.0d;
                    this.xmodelo.setValueAt(Double.valueOf(xformato.format(xvalor).replaceAll(",", ".")), x, 2);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFGestion_ManPower.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFG_Periodicos$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(JIFG_Periodicos.this.JTBDetalle.getValueAt(row, 18).toString()).longValue() != 0) {
                cell.setBackground(new Color(133, 218, 160));
                cell.setForeground(Color.BLACK);
            } else if (Long.valueOf(JIFG_Periodicos.this.JTBDetalle.getValueAt(row, 16).toString()).longValue() != 0) {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private long mConsultar_Ingreso_Cita(long xidcita) {
        long xidingreso = 0;
        if (xidcita != 0) {
            try {
                this.xsql = "SELECT `Id_ingreso` FROM `c_citas` WHERE (`Id` ='" + xidcita + "' AND `Id_MotivoDesistida` =1) ";
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet xrs1 = xct1.traerRs(this.xsql);
                if (xrs1.next()) {
                    xrs1.first();
                    xidingreso = xrs1.getLong(1);
                }
                xrs1.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFG_Periodicos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return xidingreso;
    }

    private String mConsultar_Ingreso_Atencion(long xidingreso) {
        String xfecha_atencion = "";
        if (xidingreso != 0) {
            try {
                this.xsql = "SELECT `Fecha_Atencion` FROM  `h_atencion` WHERE (`Id_Ingreso` ='" + xidingreso + "') ";
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet xrs1 = xct1.traerRs(this.xsql);
                if (xrs1.next()) {
                    xrs1.first();
                    xfecha_atencion = xrs1.getString(1);
                }
                xrs1.close();
                xct1.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFG_Periodicos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
        return xfecha_atencion;
    }
}
