package PyP;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:PyP/JIFPyP_InformesC.class */
public class JIFPyP_InformesC extends JInternalFrame {
    private DefaultTableModel xmodelo_detalle;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private String xsql;
    private String xtipofiltro;
    private Object[] xdato;
    private String xnombre;
    private JButton JBTExportar;
    private JCheckBox JCHEspecial;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatosConsolidado;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    public JTable JTConsolidado;
    public JTable JTDetalle;
    private JFormattedTextField JTFFCuatro;
    private JFormattedTextField JTFFDos;
    private JFormattedTextField JTFFTres;
    private JFormattedTextField JTFFUno;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFPyP_InformesC(String xnombre, String xtitulo) {
        initComponents();
        setName(xnombre);
        this.xnombre = xnombre;
        setTitle(xtitulo);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v39, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JTPDatos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        this.JPIDatosConsolidado = new JPanel();
        this.JTFFUno = new JFormattedTextField();
        this.JTFFDos = new JFormattedTextField();
        this.JTFFTres = new JFormattedTextField();
        this.JTFFCuatro = new JFormattedTextField();
        this.JCHEspecial = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_pyp_informes");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: PyP.JIFPyP_InformesC.1
            public void mouseClicked(MouseEvent evt) {
                JIFPyP_InformesC.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: PyP.JIFPyP_InformesC.2
            public void actionPerformed(ActionEvent evt) {
                JIFPyP_InformesC.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, 32767).addComponent(this.JTFRuta, -2, 383, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 143, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2))).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTFRuta, -1, 50, 32767)))).addGap(0, 0, 0)));
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setBorder(BorderFactory.createBevelBorder(0));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setEditingColumn(0);
        this.JTDetalle.setEditingRow(0);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setRowMargin(4);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.addTab("DETALLE", this.JSPDetalle);
        this.JTConsolidado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTConsolidado.setEditingColumn(0);
        this.JTConsolidado.setEditingRow(0);
        this.JTConsolidado.setRowHeight(25);
        this.JTConsolidado.setRowMargin(4);
        this.JTConsolidado.setSelectionBackground(new Color(255, 255, 255));
        this.JTConsolidado.setSelectionForeground(Color.red);
        this.JSPConsolidado.setViewportView(this.JTConsolidado);
        this.JTPDatos.addTab("CONSOLIDADO", this.JSPConsolidado);
        this.JPIDatosConsolidado.setBorder(BorderFactory.createTitledBorder((Border) null, "CONSOLIDADO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFUno.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFUno.setHorizontalAlignment(0);
        this.JTFFUno.setFont(new Font("Arial", 1, 14));
        this.JTFFDos.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDos.setHorizontalAlignment(0);
        this.JTFFDos.setFont(new Font("Arial", 1, 14));
        this.JTFFTres.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTres.setHorizontalAlignment(0);
        this.JTFFTres.setFont(new Font("Arial", 1, 14));
        this.JTFFCuatro.setBorder(BorderFactory.createTitledBorder((Border) null, "UNO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuatro.setHorizontalAlignment(0);
        this.JTFFCuatro.setFont(new Font("Arial", 1, 14));
        this.JCHEspecial.setBackground(new Color(251, 54, 54));
        this.JCHEspecial.setFont(new Font("Arial", 1, 12));
        this.JCHEspecial.setSelected(true);
        this.JCHEspecial.setText("Por resultado");
        GroupLayout JPIDatosConsolidadoLayout = new GroupLayout(this.JPIDatosConsolidado);
        this.JPIDatosConsolidado.setLayout(JPIDatosConsolidadoLayout);
        JPIDatosConsolidadoLayout.setHorizontalGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFUno, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JTFFDos, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JTFFTres, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JTFFCuatro, -2, 109, -2).addGap(234, 234, 234).addComponent(this.JCHEspecial, -1, 125, 32767).addGap(17, 17, 17)));
        JPIDatosConsolidadoLayout.setVerticalGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosConsolidadoLayout.createSequentialGroup().addGroup(JPIDatosConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFUno, -2, -1, -2).addComponent(this.JTFFDos, -2, -1, -2).addComponent(this.JTFFTres, -2, -1, -2).addComponent(this.JTFFCuatro, -2, -1, -2).addComponent(this.JCHEspecial)).addGap(0, 11, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTPDatos).addComponent(this.jPanel1, -1, -1, 32767)).addGap(0, 0, 32767)).addComponent(this.JPIDatosConsolidado, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatos, -1, 409, 32767).addGap(18, 18, 18).addComponent(this.JPIDatosConsolidado, -2, -1, -2).addContainerGap()));
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
        if ((this.xnombre.equals("xjif_pyp_informes") || this.xnombre.equals("xjif_pyp_informes1")) && this.JTDetalle.getRowCount() != -1 && this.JTPDatos.getSelectedIndex() == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearTablaDetalle1();
        if (this.xnombre.equals("xjif_pyp_informes") || this.xnombre.equals("xjif_pyp_informes1")) {
            mFijarTitulosCombos();
        }
    }

    private void mCrearTablaDetalle1() {
        this.xmodelo_detalle = new DefaultTableModel((Object[][]) null, new String[]{"Fecha Toma", "Apellido1", "Apellido2", "Nombre1", "Nombre2", "TD", "Documento", "Fecha Nacimiento", "Edad", "Etnia", "Ocupación", "Nivel de Estudio", "Dirección", "Zona", "Telefono", "Celular", "Esquema", "Factor Riesgo", "Antecedentes Patológicos", "Vacina CaCervix", "Vacina Gardiacil", "Fecha Resultado", "Calidad Muestra", "Resultado", "Fecha Entrega Resultado", "Conducta", "NUsuario", "Tomada", "Eps"}) { // from class: PyP.JIFPyP_InformesC.3
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo_detalle);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(300);
    }

    public void mBuscar() {
        mCrearTablaDetalle1();
        if (Principal.informacionIps.getIdentificacion().equals("812000852")) {
            this.xsql = "with maestra as (\nSELECT `p_citologia`.`FechaToma`\n, `g_persona`.`Apellido1`\n, `g_persona`.`Apellido2`\n, `g_persona`.`Nombre1`\n, `g_persona`.`Nombre2`\n, `g_persona`.`Id_TipoIdentificacion`\n, `g_persona`.`NoDocumento`\n, `g_persona`.`FechaNac`\n,`g_persona`.`Edad` \n, `g_tipo_etnia`.`Nbre` AS `NEtnia`  \n, `g_ocupacion`.`Nbre` AS `NOcupacion` \n, `g_nivelestudio`.`Nbre` AS `NNivel_Estudio` \n, `g_persona`.`Direccion` \n, `g_barrio`.`Zona` \n, `g_persona`.`Telefono` \n, `g_persona`.`Movil` AS  Celular \n, `p_citologiaesquema`.`Nbre` AS `NEsquema` \n, `F_Riesgo`.`Nbre` AS `NFRiesgo`\n,`A_Patologicos`.`Nbre` AS `APatologicos` \n, `VCa_Cervix`.`Nbre` AS `VCaCervix` \n, `V_Gardacil`.`Nbre` AS `VGardacil`\n,CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2` ) AS  NUsuario \n        ,IF(`p_citologia`.`Tomada`=1,'SI','NO') AS Tomada, g_empresa.`Nbre` AS EPS   \n        , p_citologia.Id idCitologia\n        FROM  `g_persona`  \n        INNER JOIN `p_citologia`  ON (`g_persona`.`Id` = `p_citologia`.`Id_Persona`)  \n        INNER JOIN `g_tipo_etnia`  ON (`g_persona`.`Id_Etnia` = `g_tipo_etnia`.`Id`)  \n        INNER JOIN `g_barrio`  ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)  \n        INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  \n        INNER JOIN `g_empresacont`  ON (`g_empresacont`.`Id_empresa`= `g_usuario`.`Id_EmpresaCont`)  \n        INNER JOIN `g_empresa`  ON (`g_empresacont`.`Id_empresa`= `g_empresa`.`Id`)  \n        INNER JOIN `l_recepcion`  ON (`l_recepcion`.`Id` = `p_citologia`.`Id_Recepcion`)  \n        INNER JOIN `p_tipo_respuestas_c` AS `F_Riesgo` ON (`p_citologia`.`Id_FRiesgo` = `F_Riesgo`.`Id`)  \n        INNER JOIN `p_tipo_respuestas_c` AS `V_Gardacil` ON (`p_citologia`.`Id_VGardasil` = `V_Gardacil`.`Id`)  \n        INNER JOIN `p_citologiaesquema`  ON (`p_citologia`.`Id_Esquema` = `p_citologiaesquema`.`Id`)  \n        INNER JOIN `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)  \n        INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  \n        INNER JOIN `g_ocupacion`  ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)  \n        INNER JOIN `g_nivelestudio`  ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  \n        INNER JOIN `p_tipo_respuestas_c` AS `A_Patologicos`   ON (`A_Patologicos`.`Id` = `p_citologia`.`Id_APatologicos`) \n        INNER JOIN `p_tipo_respuestas_c` AS `VCa_Cervix`  ON (`VCa_Cervix`.`Id` = `p_citologia`.`Id_VCaCervix`)  \n       \n        WHERE (`p_citologia`.`FechaToma`>='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `p_citologia`.`FechaToma` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `p_citologia`.`Estado` =0) \n        group by l_recepcion.Id \n        ORDER BY `p_citologia`.`FechaToma`  ASC , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2` ) ASC \n   )\n\n   , resultado as (\n\t  select pcr.FechaR fechaResultado, pcc.Nbre calidadMuestra, GROUP_CONCAT(concat(pct.Nbre,' : ', pcc2.Nbre) separator '\\n')resultado\n\t\t, ptrc.Nbre conducta, pcr.Id_Citologia idCitologia\n\t\tfrom p_citologia_resultados pcr \n\t\tinner join p_citologia_cmuestra pcc on (pcc.Id=pcr.Id_Calitad)\n\t\tinner join p_citologia_resultado_cestudio pcrc  on (pcrc.Id_RCitologia=pcr.Id)\n\t\tleft join p_citologia_conceptoestudio pcc2 on (pcc2.Id=pcrc.Id_ConceptoEstudio)\n\t\tleft join p_citologia_tipoestudio pct on (pct.Id=pcc2.Id_TipoEstudio)\n\t\tleft join p_tipo_respuestas_c ptrc on (ptrc.Id=pcr.Id_Conducta)\n\t\tinner join maestra m on (m.idCitologia=pcr.Id_Citologia)\n\t\tgroup by pcr.Id_Citologia   )\n   select \n    m.`FechaToma`\n, m.`Apellido1`\n, m.`Apellido2`\n, m.`Nombre1`\n, m.`Nombre2`\n, m.`Id_TipoIdentificacion`\n, m.`NoDocumento`\n, m.`FechaNac`\n, m.`Edad` \n, m.`NEtnia`  \n, m.`NOcupacion` \n, m.`NNivel_Estudio` \n, m.`Direccion` \n, m.`Zona` \n, m.`Telefono` \n, m.Celular \n, m.`NEsquema` \n, m.`NFRiesgo`\n, m.`APatologicos` \n, m.`VCaCervix` \n, m.`VGardacil`\n, ifnull(r.fechaResultado, '')fechaResultado\n, ifnull(r.calidadMuestra, '')calidadMuestra\n, ifnull(r.resultado, '')resultado\n, ifnull(r.fechaResultado, '')fechaResultado\n, ifnull(r.conducta, '')conducta\n, m.NUsuario \n,m.Tomada\n, m.EPS\n   from maestra m\n   left join resultado r on (r.idCitologia=m.idCitologia)";
        } else {
            this.xsql = "SELECT `p_citologia`.`FechaToma`, `g_persona`.`Apellido1`, `g_persona`.`Apellido2`, `g_persona`.`Nombre1`, `g_persona`.`Nombre2`, `g_persona`.`Id_TipoIdentificacion`, `g_persona`.`NoDocumento`, `g_persona`.`FechaNac` ,`g_persona`.`Edad` , `g_tipo_etnia`.`Nbre` AS `NEtnia`  , `g_ocupacion`.`Nbre` AS `NOcupacion` , `g_nivelestudio`.`Nbre` AS `NNivel_Estudio` , `g_persona`.`Direccion` , `g_barrio`.`Zona` , `g_persona`.`Telefono` ,\n `g_persona`.`Movil` AS  Celular , `p_citologiaesquema`.`Nbre` AS `NEsquema` , `F_Riesgo`.`Nbre` AS `NFRiesgo` ,\n `A_Patologicos`.`Nbre` AS `APatologicos` , `VCa_Cervix`.`Nbre` AS `VCaCervix` ,\n  `V_Gardacil`.`Nbre` AS `VGardacil` ,\n   IF(`p_citologia_resultados`.`FechaR` IS NULL ,IFNULL((SELECT\n    `l_resultados`.`FechaResult`\nFROM\n    `l_recepcion_citologia`\n    INNER JOIN `l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN `l_tipo_encabezado` \n        ON (`l_protocolos`.`Id_tencabezado` = `l_tipo_encabezado`.`Id`)\nWHERE (`l_resultados`.`Estado` =0 AND l_recepcion.`Id`=p_citologia.`Id_Recepcion`)\nGROUP BY `l_recepcion`.`Id`\nORDER BY `l_recepcion`.`Id` ASC, `l_protocoloxprocedimiento`.`Orden` ASC),'SIN RESULTADO'),`p_citologia_resultados`.`FechaR`) AS FechaR ,\n    IF(`p_citologia_cmuestra`.`Nbre` IS NULL,IFNULL((SELECT\n    `l_protocolos`.`Nbre`\nFROM\n    `l_recepcion_citologia`\n    INNER JOIN `l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN `l_tipo_encabezado` \n        ON (`l_protocolos`.`Id_tencabezado` = `l_tipo_encabezado`.`Id`)\nWHERE (`l_resultados`.`Estado` =0 AND l_recepcion.`Id`=p_citologia.`Id_Recepcion` AND l_tipo_encabezado.`Id`=10)\nGROUP BY `l_recepcion`.`Id`\nORDER BY `l_recepcion`.`Id` ASC, `l_protocoloxprocedimiento`.`Orden` ASC),'SIN RESULTADO'), `p_citologia_cmuestra`.`Nbre`) AS `CMuestra` ,\n     IF(`p_citologia_conceptoestudio`.`Nbre` IS NULL, IFNULL((SELECT\n   GROUP_CONCAT(`l_protocolos`.`Nbre` SEPARATOR '\\n') Result\nFROM\n    `l_recepcion_citologia`\n    INNER JOIN `l_recepcion` \n        ON (`l_recepcion_citologia`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_resultados` \n        ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_detalleresultado` \n        ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `l_protocoloxprocedimiento` \n        ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN `l_protocolos` \n        ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN `l_tipo_encabezado` \n        ON (`l_protocolos`.`Id_tencabezado` = `l_tipo_encabezado`.`Id`)\nWHERE (`l_resultados`.`Estado` =0 AND l_recepcion.`Id`=p_citologia.`Id_Recepcion` AND l_tipo_encabezado.`Id`<>10)\nGROUP BY `l_recepcion`.`Id`\nORDER BY `l_recepcion`.`Id` ASC, `l_protocoloxprocedimiento`.`Orden` ASC),'SIN RESULTADO'),`p_citologia_cmuestra`.`Nbre`) AS `NResultado` ,\n     IF(`p_citologia_resultados`.`FechaER` IS NULL, '', `p_citologia_resultados`.`FechaER`) AS FEchaER ,\n     IF(`Conducta`.`Nbre` IS NULL, '',`Conducta`.`Nbre`)  AS `Conducta` , \n     CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2` ) AS  NUsuario \n        ,IF(`p_citologia`.`Tomada`=1,'SI','NO') AS Tomada, g_empresa.`Nbre` AS EPS   FROM  `g_persona`  INNER JOIN `p_citologia`  ON (`g_persona`.`Id` = `p_citologia`.`Id_Persona`)  INNER JOIN `g_tipo_etnia`  ON (`g_persona`.`Id_Etnia` = `g_tipo_etnia`.`Id`)  INNER JOIN `g_barrio`  ON (`g_persona`.`Id_Barrio` = `g_barrio`.`Id`)  INNER JOIN `g_usuario`  ON (`g_persona`.`Id` = `g_usuario`.`Id_persona`)  INNER JOIN `g_empresacont`  ON (`g_empresacont`.`Id_empresa`= `g_usuario`.`Id_EmpresaCont`)  INNER JOIN `g_empresa`  ON (`g_empresacont`.`Id_empresa`= `g_empresa`.`Id`)  INNER JOIN `l_recepcion`  ON (`l_recepcion`.`Id` = `p_citologia`.`Id_Recepcion`)  INNER JOIN `p_tipo_respuestas_c` AS `F_Riesgo` ON (`p_citologia`.`Id_FRiesgo` = `F_Riesgo`.`Id`)  INNER JOIN `p_tipo_respuestas_c` AS `V_Gardacil` ON (`p_citologia`.`Id_VGardasil` = `V_Gardacil`.`Id`)  INNER JOIN `p_citologiaesquema`  ON (`p_citologia`.`Id_Esquema` = `p_citologiaesquema`.`Id`)  INNER JOIN `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`)  INNER JOIN `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`)  INNER JOIN `g_ocupacion`  ON (`g_ocupacion`.`Id` = `ingreso`.`Id_Ocupacion`)  INNER JOIN `g_nivelestudio`  ON (`g_nivelestudio`.`Id` = `ingreso`.`Id_NivelEstudio`)  INNER JOIN `p_tipo_respuestas_c` AS `A_Patologicos`   ON (`A_Patologicos`.`Id` = `p_citologia`.`Id_APatologicos`)  INNER JOIN `p_tipo_respuestas_c` AS `VCa_Cervix`  ON (`VCa_Cervix`.`Id` = `p_citologia`.`Id_VCaCervix`)  LEFT JOIN `p_citologia_resultados`  ON (`p_citologia_resultados`.`Id_Citologia` = `p_citologia`.`Id`) LEFT JOIN `p_citologia_cmuestra`  ON (`p_citologia_resultados`.`Id_Calitad` = `p_citologia_cmuestra`.`Id`)  LEFT JOIN `p_citologia_conceptoestudio`  ON (`p_citologia_resultados`.`Id_ConceptoEstudio` = `p_citologia_conceptoestudio`.`Id`)  LEFT JOIN `p_tipo_respuestas_c` AS `Conducta` ON (`p_citologia_resultados`.`Id_Conducta` = `Conducta`.`Id`)   WHERE (`p_citologia`.`FechaToma` >='" + this.xmt.formatoAMD1.format(this.JDFechaI.getDate()) + "' AND `p_citologia`.`FechaToma` <='" + this.xmt.formatoAMD1.format(this.JDFechaF.getDate()) + "' AND `p_citologia`.`Estado` =0) group by l_recepcion.Id ORDER BY `p_citologia`.`FechaToma`  ASC , CONCAT(`g_persona`.`Apellido1`,' ', `g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2` ) ASC ";
        }
        System.out.println(" primera : " + this.xsql);
        ResultSet rs = this.xct.traerRs(this.xsql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                int xvalor1 = 0;
                int xvalor2 = 0;
                while (rs.next()) {
                    this.xmodelo_detalle.addRow(this.xdato);
                    this.xmodelo_detalle.setValueAt(rs.getString(1), x, 0);
                    this.xmodelo_detalle.setValueAt(rs.getString(2), x, 1);
                    this.xmodelo_detalle.setValueAt(rs.getString(3), x, 2);
                    this.xmodelo_detalle.setValueAt(rs.getString(4), x, 3);
                    this.xmodelo_detalle.setValueAt(rs.getString(5), x, 4);
                    this.xmodelo_detalle.setValueAt(rs.getString(6), x, 5);
                    this.xmodelo_detalle.setValueAt(rs.getString(7), x, 6);
                    this.xmodelo_detalle.setValueAt(rs.getString(8), x, 7);
                    this.xmodelo_detalle.setValueAt(Long.valueOf(rs.getLong(9)), x, 8);
                    this.xmodelo_detalle.setValueAt(rs.getString(10), x, 9);
                    this.xmodelo_detalle.setValueAt(rs.getString(11), x, 10);
                    this.xmodelo_detalle.setValueAt(rs.getString(12), x, 11);
                    this.xmodelo_detalle.setValueAt(rs.getString(13), x, 12);
                    this.xmodelo_detalle.setValueAt(rs.getString(14), x, 13);
                    this.xmodelo_detalle.setValueAt(rs.getString(15), x, 14);
                    this.xmodelo_detalle.setValueAt(rs.getString(16), x, 15);
                    this.xmodelo_detalle.setValueAt(rs.getString(17), x, 16);
                    this.xmodelo_detalle.setValueAt(rs.getString(18), x, 17);
                    this.xmodelo_detalle.setValueAt(rs.getString(19), x, 18);
                    this.xmodelo_detalle.setValueAt(rs.getString(20), x, 19);
                    this.xmodelo_detalle.setValueAt(rs.getString(21), x, 20);
                    this.xmodelo_detalle.setValueAt(rs.getString(22), x, 21);
                    this.xmodelo_detalle.setValueAt(rs.getString(23), x, 22);
                    this.xmodelo_detalle.setValueAt(rs.getString(24), x, 23);
                    this.xmodelo_detalle.setValueAt(rs.getString(25), x, 24);
                    this.xmodelo_detalle.setValueAt(rs.getString(26), x, 25);
                    this.xmodelo_detalle.setValueAt(rs.getString(27), x, 26);
                    this.xmodelo_detalle.setValueAt(rs.getString(28), x, 27);
                    this.xmodelo_detalle.setValueAt(rs.getString(29), x, 28);
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    if (rs.getString(28).equals("SI")) {
                        xvalor1++;
                    } else {
                        xvalor2++;
                    }
                    x++;
                }
                this.JTFFUno.setValue(Integer.valueOf(x));
                this.JTFFDos.setValue(Integer.valueOf(xvalor1));
                this.JTFFTres.setValue(Integer.valueOf(xvalor2));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            this.xct.mostrarErrorSQL(ex);
        }
    }

    private void mFijarTitulosCombos() {
        this.JTFFUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDos.setBorder(BorderFactory.createTitledBorder((Border) null, "Realizadas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFTres.setBorder(BorderFactory.createTitledBorder((Border) null, "No realizadas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCuatro.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Asignadas", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: loaded from: GenomaP.jar:PyP/JIFPyP_InformesC$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 21).equals("")) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(new Color(255, 255, 255));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
