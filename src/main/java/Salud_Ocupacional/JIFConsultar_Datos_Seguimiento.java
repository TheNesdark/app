package Salud_Ocupacional;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFConsultar_Datos_Seguimiento.class */
public class JIFConsultar_Datos_Seguimiento extends JInternalFrame {
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xsql;
    private String[] xidperiodo;
    private String[] xid_tseguimiento;
    private ButtonGroup JBGFiltro;
    private JButton JBTExportar;
    private JComboBox JCBPeriodo;
    private JLabel JLBNTrabajadores;
    private JPanel JPIDConsulta;
    private JScrollPane JSPDetalle;
    private JTable JTBDetalle;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private boolean xlleno = false;

    public JIFConsultar_Datos_Seguimiento() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JPIDConsulta = new JPanel();
        this.JCBPeriodo = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JLBNTrabajadores = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN SEGUIMIENTO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsultar_seguimientoso");
        this.JPIDConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPeriodo.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDConsultaLayout = new GroupLayout(this.JPIDConsulta);
        this.JPIDConsulta.setLayout(JPIDConsultaLayout);
        JPIDConsultaLayout.setHorizontalGroup(JPIDConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeriodo, -2, 204, -2).addContainerGap(-1, 32767)));
        JPIDConsultaLayout.setVerticalGroup(JPIDConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBPeriodo, -2, 50, -2).addContainerGap(22, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Salud_Ocupacional.JIFConsultar_Datos_Seguimiento.1
            public void mouseClicked(MouseEvent evt) {
                JIFConsultar_Datos_Seguimiento.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JIFConsultar_Datos_Seguimiento.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultar_Datos_Seguimiento.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JLBNTrabajadores.setBackground(new Color(255, 255, 255));
        this.JLBNTrabajadores.setFont(new Font("Arial", 1, 16));
        this.JLBNTrabajadores.setHorizontalAlignment(0);
        this.JLBNTrabajadores.setBorder(BorderFactory.createTitledBorder((Border) null, "N° SVE", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBNTrabajadores.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 897, 32767).addComponent(this.JPIDConsulta, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JLBNTrabajadores, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFRuta, -2, 363, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 128, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDConsulta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 352, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNTrabajadores, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JTFRuta, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGap(26, 26, 26)));
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

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBPeriodo.removeAllItems();
        this.xsql = "SELECT `cc_periodo_financiero`.`Id` , `cc_periodo_financiero`.`Nbre` FROM `so_manporwer_detalle` INNER JOIN  `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) INNER JOIN `cc_periodo_financiero`  ON (`so_manporwer_encabezado`.`Id_Periodo` = `cc_periodo_financiero`.`Id`) WHERE (`so_manporwer_encabezado`.`Estado` =1) GROUP BY `cc_periodo_financiero`.`Id` ORDER BY `cc_periodo_financiero`.`FechaI` DESC";
        this.xidperiodo = this.xct.llenarCombo(this.xsql, this.xidperiodo, this.JCBPeriodo);
        this.xct.cerrarConexionBd();
        mCrearModeloDetalle();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Cédula", "Nombre", "Cargo", "Unidad", "#Seg", "Clasificación", "FPeriodico", "Estado", "Concepto", "Id_Atencion", "Id_Usuario", "EstadoS", "Restricción", "HConcepto", "Edad", "Fecha_Ingreso", "Años_Antiguedad", "Fecha Registro", "Observación", "Fecha Cierre", "SVE", "Días Seguimiento", "Fecha Último Seguimiento", "Fecha Cierre", "Detalle", "Observación General"}) { // from class: Salud_Ocupacional.JIFConsultar_Datos_Seguimiento.3
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
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
        this.JTBDetalle.getColumnModel().getColumn(25).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(26).setMaxWidth(0);
    }

    private void mCargarDatosTablaD() {
        try {
            mCrearModeloDetalle();
            this.xsql = "SELECT `so_manporwer_detalle`.`Id`, \n`so_manporwer_detalle`.`Cedula`, \n CONCAT(g_persona.`Nombre1` ,' ',g_persona.`Nombre2` ,' ',g_persona.`Apellido1`,' ', g_persona.`Apellido2`) nombre,\n`g_cargos`.`Nbre`, \nso_manporwer_detalle.`UnidadN`, \n`so_tipo_segmento`.`Nbre`, \n`so_tipo_clasificacion`.`Nbre` , \n IF(`so_manporwer_detalle`.`FechaPA` IS NULL, '',`so_manporwer_detalle`.`FechaPA`) AS FechaPA  , \n `so_manporwer_detalle`.`Alterado`, \n `so_manporwer_detalle`.ConceptoI, \n `so_manporwer_detalle`.`Id_Atencion`,\n  `so_manporwer_detalle`.`Id_Persona`, \n -- IF(GROUP_CONCAT(CONCAT(`so_manpower_seguimiento_detalle_s`.`Fecha_S`,' ', `so_tipo_vigilancia_seguimiento`.`Nbre` ,' ', `so_manpower_seguimiento_detalle_s`.`Descrpcion` ,' ', `profesional1`.`Especialidad`,' ', `profesional1`.`NProfesional`) ORDER BY  `so_tipo_vigilancia_seguimiento`.`Nbre`, `so_manpower_seguimiento_detalle_s`.`Fecha_S` SEPARATOR'\\ ') IS NULL,0,1)    AS EstadoS,\n IF(GROUP_CONCAT(CONCAT(`so_manpower_seguimiento_detalle_s`.`Fecha_S`,' ', `so_tipo_vigilancia_seguimiento`.`Nbre` ,' ', `so_manpower_seguimiento_detalle_s`.`Descrpcion` ,' ', `g_especialidad`.`Nbre`,' ',gp1.`Nombre1` ,' ',gp1.`Nombre2` ,' ',gp1.`Apellido1`,' ', gp1.`Apellido2`) ORDER BY  `so_tipo_vigilancia_seguimiento`.`Nbre`, `so_manpower_seguimiento_detalle_s`.`Fecha_S` SEPARATOR'\\ ') IS NULL,0,1)    AS EstadoS,\nIF(`so_manporwer_detalle`.`Restricciones` IS NULL, '', `so_manporwer_detalle`.`Restricciones` ) AS RT,\nIF(`so_manporwer_detalle`.`HConcepto` IS NULL, '', `so_manporwer_detalle`.`HConcepto`) AS HC, \n`Devuelve_Edad_2F`(g_persona.`FechaNac`, NOW()) edad, \n`so_manporwer_detalle`.`FEntrada`, \n`CalculaTiempo_AMD`(`so_manporwer_detalle`.`FEntrada`) , \n`so_manpower_seguimiento`.`FechaR` , \n`so_manpower_seguimiento`.`Observacion` , \nIF(`so_manpower_seguimiento`.`FechaCierre` IS NULL, '',`so_manpower_seguimiento`.`FechaCierre` ) AS `FCierre` , \n`so_tipo_vigilancia`.`Nbre` AS `NSIstema` , \n`so_manpower_seguimiento_detalle`.`Observacion` , \n`so_manpower_seguimiento_detalle`.`NDiasS` \n, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, '',`so_manpower_seguimiento_detalle`.`FechaUS` ) AS `FUSeguimiento` , \nIF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NULL, '', `so_manpower_seguimiento_detalle`.`FechaCierre`) AS `FSCierre` ,\n-- IF(GROUP_CONCAT(CONCAT(`so_manpower_seguimiento_detalle_s`.`Fecha_S`,' ', `so_tipo_vigilancia_seguimiento`.`Nbre` ,' ', `so_manpower_seguimiento_detalle_s`.`Descrpcion` ,' ', `profesional1`.`Especialidad`,' ', `profesional1`.`NProfesional`) ORDER BY  `so_tipo_vigilancia_seguimiento`.`Nbre`, `so_manpower_seguimiento_detalle_s`.`Fecha_S` SEPARATOR'\n-- ') IS NULL,'NO TIENE SEGUIMIENTO REGISTRADO',GROUP_CONCAT(CONCAT(`so_manpower_seguimiento_detalle_s`.`Fecha_S`,' ', `so_tipo_vigilancia_seguimiento`.`Nbre` ,' ', `so_manpower_seguimiento_detalle_s`.`Descrpcion` ,' ', `profesional1`.`Especialidad`,' ', `profesional1`.`NProfesional`) ORDER BY  `so_tipo_vigilancia_seguimiento`.`Nbre`, `so_manpower_seguimiento_detalle_s`.`Fecha_S` SEPARATOR'\n-- '))  \nIF(GROUP_CONCAT(CONCAT(`so_manpower_seguimiento_detalle_s`.`Fecha_S`,' ', `so_tipo_vigilancia_seguimiento`.`Nbre` ,' ', `so_manpower_seguimiento_detalle_s`.`Descrpcion` ,' ', `g_especialidad`.`Nbre`,' ',gp1.`Nombre1` ,' ',gp1.`Nombre2` ,' ',gp1.`Apellido1`,' ', gp1.`Apellido2`) ORDER BY  `so_tipo_vigilancia_seguimiento`.`Nbre`, `so_manpower_seguimiento_detalle_s`.`Fecha_S` SEPARATOR'\n') IS NULL,'NO TIENE SEGUIMIENTO REGISTRADO',GROUP_CONCAT(CONCAT(`so_manpower_seguimiento_detalle_s`.`Fecha_S`,' ', `so_tipo_vigilancia_seguimiento`.`Nbre` ,' ', `so_manpower_seguimiento_detalle_s`.`Descrpcion` ,' ', `g_especialidad`.`Nbre`,' ',gp1.`Nombre1` ,' ',gp1.`Nombre2` ,' ',gp1.`Apellido1`,' ', gp1.`Apellido2`) ORDER BY  `so_tipo_vigilancia_seguimiento`.`Nbre`, `so_manpower_seguimiento_detalle_s`.`Fecha_S` SEPARATOR'\n'))AS Detalle, \nIF(`so_manporwer_detalle`.`Observacion_CI` IS NULL, '',`so_manporwer_detalle`.`Observacion_CI`) AS   Observacion_CI      \n \nFROM  `so_manporwer_detalle`  \nINNER JOIN `so_manporwer_encabezado`  ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`)  \n-- INNER JOIN `persona`  ON (`persona`.`Id_persona` = `so_manporwer_detalle`.`Id_Persona`)   \n  INNER JOIN `g_persona` ON  (`g_persona`.`Id` = `so_manporwer_detalle`.`Id_Persona`) \n  INNER JOIN `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)  \n  INNER JOIN `so_tipo_segmento`  ON (`g_usuario`.`Id_Segmento` = `so_tipo_segmento`.`Id`) \n  INNER JOIN `g_cargos`  ON (`g_usuario`.`Id_Cargo` = `g_cargos`.`Id`)  \n  INNER JOIN `so_tipo_clasificacion`  ON (`so_manporwer_detalle`.`Id_Clasificacion` = `so_tipo_clasificacion`.`Id`)  \n  INNER JOIN `so_manpower_seguimiento`  ON (`so_manpower_seguimiento`.`Id_Manpower_Detalle` = `so_manporwer_detalle`.`Id`) \n  INNER JOIN `so_manpower_seguimiento_detalle`  ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \n  INNER JOIN `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \n  LEFT JOIN `so_manpower_seguimiento_detalle_s`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Mp_SDetalle` = `so_manpower_seguimiento_detalle`.`Id`)\n  LEFT JOIN `so_vigilancia_seguimiento`  ON (`so_manpower_seguimiento_detalle_s`.`Id_Vigilancia_S` = `so_vigilancia_seguimiento`.`Id`) \n  LEFT JOIN `so_tipo_vigilancia_seguimiento`  ON (`so_vigilancia_seguimiento`.`Id_TV_Seguimiento` = `so_tipo_vigilancia_seguimiento`.`Id`) \n  LEFT JOIN  `g_persona` gp1 ON   (gp1.`Id`= `so_manpower_seguimiento_detalle_s`.`Id_Profesional`)\n  INNER JOIN  `g_profesional` ON (g_profesional.`Id_Persona`=gp1.`Id`)\n  INNER JOIN `g_profesionalespecial` ON (`g_profesional`.`id`=`g_profesionalespecial`.`Id_Profesional`)\n  INNER JOIN `g_especialidad` ON (`g_especialidad`.`Id`=`g_profesionalespecial`.`Id_Especialidad`)\n  -- LEFT JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `so_manpower_seguimiento_detalle_s`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `so_manpower_seguimiento_detalle_s`.`Id_Especialidad`) \n   \nWHERE ( `so_manporwer_encabezado`.`Id_Periodo` ='" + this.xidperiodo[this.JCBPeriodo.getSelectedIndex()] + "' \nAND `so_manporwer_encabezado`.`Estado`=1 \nAND `so_manpower_seguimiento`.`Estado` =1 \nAND `so_manpower_seguimiento_detalle`.`Estado` =1) \nGROUP BY `so_manporwer_detalle`.`Id`, `so_manpower_seguimiento_detalle`.`Id` ORDER BY g_persona.`Apellido1`, `so_tipo_vigilancia`.`Nbre` ";
            System.out.println("Consulta buscar -> " + this.xsql);
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
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(13)), x, 12);
                    this.xmodelo1.setValueAt(xrs.getString(14), x, 13);
                    this.xmodelo1.setValueAt(xrs.getString(15), x, 14);
                    this.xmodelo1.setValueAt(Long.valueOf(xrs.getLong(16)), x, 15);
                    this.xmodelo1.setValueAt(xrs.getString(17), x, 16);
                    this.xmodelo1.setValueAt(xrs.getString(18), x, 17);
                    this.xmodelo1.setValueAt(xrs.getString(19), x, 18);
                    this.xmodelo1.setValueAt(xrs.getString(20), x, 19);
                    this.xmodelo1.setValueAt(xrs.getString(21), x, 20);
                    this.xmodelo1.setValueAt(xrs.getString(22), x, 21);
                    this.xmodelo1.setValueAt(xrs.getString(23), x, 22);
                    this.xmodelo1.setValueAt(xrs.getString(24), x, 23);
                    this.xmodelo1.setValueAt(xrs.getString(25), x, 24);
                    this.xmodelo1.setValueAt(xrs.getString("Detalle"), x, 25);
                    this.xmodelo1.setValueAt(xrs.getString("Observacion_CI"), x, 26);
                    this.JTBDetalle.setDefaultRenderer(Object.class, new MiRender());
                    x++;
                }
            }
            this.JLBNTrabajadores.setText("" + x);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultar_Datos_Seguimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscar() {
        if (this.JCBPeriodo.getSelectedIndex() != -1) {
            mCargarDatosTablaD();
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JIFConsultar_Datos_Seguimiento$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xestado = Long.valueOf(table.getValueAt(row, 12).toString()).longValue();
            if (xestado == 0) {
                cell.setBackground(new Color(251, 54, 54));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(new Color(255, 255, 255));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
