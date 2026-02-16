package Sig;

import Acceso.Principal;
import Contabilidad.JIFInformesMov;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFGenericoxFecha.class */
public class JIFGenericoxFecha extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xidempresa;
    private String[] xidcentrocosto;
    private String xllamador;
    private ButtonGroup JBGOpciones;
    private JButton JBTExportar;
    public JDateChooser JDFFechaF;
    public JDateChooser JDFFechaI;
    private JScrollPane JSPDetalle1;
    private JTextField JTFRuta;
    public JTable JTResultado;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private JDateChooser xjdfecha = new JDateChooser();
    private JComboBox xjcbcentrocosto = new JComboBox();

    public JIFGenericoxFecha(String xllamador, String xTitulo) {
        initComponents();
        this.xllamador = xllamador;
        setTitle(xTitulo.toUpperCase());
        mIniciar();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.jPanel2 = new JPanel();
        this.JDFFechaI = new JDateChooser();
        this.JDFFechaF = new JDateChooser();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JSPDetalle1 = new JScrollPane();
        this.JTResultado = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR MOVIMIENTOS x RANGO DE FECHA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifGenericoxFecha");
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaF.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFGenericoxFecha.1
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoxFecha.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFGenericoxFecha.2
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoxFecha.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFFechaF, -2, 121, -2).addContainerGap(700, 32767)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(284, 32767).addComponent(this.JTFRuta, -2, 358, -2).addGap(110, 110, 110).addComponent(this.JBTExportar, -2, 217, -2).addGap(1, 1, 1))));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFFechaI, -2, 54, -2).addComponent(this.JDFFechaF, -2, 54, -2)).addContainerGap(-1, 32767)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 52, 32767).addComponent(this.JBTExportar, -1, -1, 32767)).addGap(37, 37, 37))));
        this.JSPDetalle1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setAutoResizeMode(0);
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setGridColor(new Color(153, 153, 153));
        this.JTResultado.setRowHeight(20);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: Sig.JIFGenericoxFecha.3
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoxFecha.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPDetalle1.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle1, GroupLayout.Alignment.LEADING, -1, 982, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle1, -1, 479, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
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
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTResultado, this.JTFRuta.getText(), getTitle());
        }
    }

    public void mBuscar() {
        if (this.xllamador.equals("xAudiometria")) {
            mCargarDatosTablaAudio();
            return;
        }
        if (this.xllamador.equals("xEspiromertria") || this.xllamador.equals("xEspiromertria1")) {
            mCargarDatosTablaEspiro();
        } else if (this.xllamador.equals("xDeportologia")) {
            mBuscaDeportologia();
        } else if (this.xllamador.equals("xSomnolencia")) {
            mBuscaSomnolencia();
        }
    }

    private void mCargarDatosTablaAudio() {
        try {
            mCrearModeloRAudiometria();
            String sql = "SELECT `h_so_audiometria`.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n        , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_audiometria`.`D500`\n    , `h_so_audiometria`.`D1000`\n    , `h_so_audiometria`.`D2000`\n    , `h_so_audiometria`.`D3000`\n    , `h_so_audiometria`.`D4000`\n    , `h_so_audiometria`.`D6000`\n    , `h_so_audiometria`.`D8000`\n    , `h_so_audiometria`.`POD`\n    ,`h_so_audiometria`.`I500`\n    , `h_so_audiometria`.`I1000`\n    , `h_so_audiometria`.`I2000`\n    , `h_so_audiometria`.`I3000`\n    , `h_so_audiometria`.`I4000`\n    , `h_so_audiometria`.`I6000`\n    , `h_so_audiometria`.`I8000`\n    , `h_so_audiometria`.`POI`\n    , IF(`h_so_audiometria`.`ResultadoM` IS NULL, '',`h_so_audiometria`.`ResultadoM`) AS ResultadoM      , `c_clasecita`.`Nbre` AS ClaseCita, IF(`h_so_audiometria`.`ObservacionAudio` IS NULL, '',`h_so_audiometria`.`ObservacionAudio`) AS ObservacionAudio, `f_empresacontxconvenio`.`Nbre` AS EmpresaF FROM     `h_so_audiometria`\n    INNER JOIN  `g_persona`  ON (`h_so_audiometria`.`Id_Usuario` = `g_persona`.`Id`)\n    INNER JOIN  `g_usuario`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz`  ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)\n INNER JOIN  `h_atencion`  ON (`h_so_audiometria`.`Id_Atencion` = `h_atencion`.`Id`)     INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN `f_empresacontxconvenio`  ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)  WHERE (`h_so_audiometria`.`Fecha_R` >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `h_so_audiometria`.`Fecha_R` <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "'\n AND `h_so_audiometria`.`Estado` =1) ORDER BY  CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) asc ";
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(xrs.getString(23), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(xrs.getString(26), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                    this.xmodelo.setValueAt(xrs.getString("EmpresaF"), n, 27);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloRAudiometria() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Prueba", "No. Documento", "TipoDocumento", "Usuario", "Edad", "FechaNac", "Sexo", "UnidadNeg", "OD500", "OD1000 ", "OD2000", "OD3000", "OD4000", "OD6000", "OD8000", "Prom_OD", "OI500", "OI1000", "OI2000", "OI3000", "OI4000", "OI6000", "OI8000", "Prom_OI", "ResultadoM", "ClaseCita", "ObservacionA", "Empresa"}) { // from class: Sig.JIFGenericoxFecha.4
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(15).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(15).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(21).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(21).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(22).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(22).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(23).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(23).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(23).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(26).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(26).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(26).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(27).setMaxWidth(0);
    }

    private void mCargarDatosTablaEspiro() {
        String sql;
        try {
            mCrearModeloREspiro();
            if (this.xllamador.equals("xEspiromertria1")) {
                sql = " select  h_so_espirometria_g.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario` \n    , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_espirometria_g`.`FEV1_FVC`\n    , `h_so_espirometria_g`.`FEF2575`\n    , `h_so_espirometria_g`.`FV1`\n    , `h_so_espirometria_g`.`FVC`\n    , `h_so_espirometria_g`.`PEF`\n    , 0\n    , 0\n    , `h_so_espirometria_g`.`Resultado`\n    , IF(`h_so_espirometria_g`.`ResultadoM` IS NULL, '', `h_so_espirometria_g`.`ResultadoM`) AS ResultadoM \n  ,`c_clasecita`.`Nbre` AS ClaseCita, `f_empresacontxconvenio`.`Nbre` AS EmpresaF    \nFROM\n     `h_so_espirometria_g`\n    INNER JOIN  `h_atencion` \n        ON (`h_so_espirometria_g`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` \n        ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`)  \n WHERE (`h_so_espirometria_g`.`Estado` =1\n    AND `h_so_espirometria_g`.`Fecha_R`>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and `h_so_espirometria_g`.`Fecha_R`<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') order by CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` );";
            } else {
                sql = "SELECT\nh_so_espirometria.`Fecha_R`,\n    `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`Edad`\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Id_Sexo`\n    , CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` ) AS  `NUsuario` \n    , IF(`g_tipounidadnegocio`.`Nbre`  IS NULL , '',`g_tipounidadnegocio`.`Nbre`) AS UN\n    , `h_so_espirometria`.`FVCM`\n    , `h_so_espirometria`.`FVCP`\n    , `h_so_espirometria`.`VEF1M`\n    , `h_so_espirometria`.`VEF1P`\n    , `h_so_espirometria`.`DVEF1`\n    , `h_so_espirometria`.`DFVC`\n    , `h_so_espirometria`.`IndicT`\n    , `h_so_espirometria`.`Resultado`\n    , IF(`h_so_espirometria`.`ResultadoM` IS NULL, '', `h_so_espirometria`.`ResultadoM`) AS ResultadoM \n  ,`c_clasecita`.`Nbre` AS ClaseCita, `f_empresacontxconvenio`.`Nbre` AS EmpresaF    \nFROM\n     `h_so_espirometria`\n    INNER JOIN  `h_atencion` \n        ON (`h_so_espirometria`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_usuario` \n        ON (`ingreso`.`Id_Usuario` = `g_usuario`.`Id_persona`)\n    INNER JOIN  `g_persona` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    LEFT JOIN  `g_tipounidadnegocio` \n        ON (`g_usuario_fpz`.`Id_UnidadN` = `g_tipounidadnegocio`.`Id`) \n WHERE (`h_so_espirometria`.`Estado` =1\n    AND `h_so_espirometria`.`Fecha_R`>='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' and `h_so_espirometria`.`Fecha_R`<='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') order by CONCAT(g_persona.`Apellido1`, ' ', g_persona.`Apellido2`,' ', g_persona.`Nombre1`,' ', g_persona.`Nombre2` );";
            }
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(9)), n, 8);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(10)), n, 9);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 10);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(12)), n, 11);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(13)), n, 12);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(14)), n, 13);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(15)), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString("EmpresaF"), n, 18);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloREspiro() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Fecha Prueba", "No. Documento", "TipoDocumento", "Usuario", "Edad", "FechaNac", "Sexo", "UnidadNeg", "FVCM", "FVCP ", "VEF1M", "VEF1P", "DVEF1", "DFVC", "IndicT", "ResultadoPrueba", "ResultadoMedico", "ClaseCita", "Empresa"}) { // from class: Sig.JIFGenericoxFecha.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(8).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTResultado.getColumnModel().getColumn(15).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTResultado.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTResultado.getColumnModel().getColumn(18).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloMedDeporte() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"TipoDocumento", "No. Documento", "No. Historia", "PrimerApellido", "SegundoApellido", "PrimerNombre", "SegundoNombre", "Sexo", "FechaNacimiento", "Edad ", "Correo", "Cargo", "Grupo", "Supervisor", "SEG", "UnidadNegocio", "FechaAtencion", "ClaseCita", "TensionArterialSistolica", "TensionArterialDiastolica", "Peso", "Talla", "IMC", "RiesgoIMC", "PerimetroAbdominal", "RiesgoPerimetroAbdominal", "%Grasa", "Riesgo %Grasa", "Flexibilidad", "RiesgoFlexibilidad", "ResultadoVO2(ml/kg/min)", "ClasificacionVO2-Percentil", "FrecuenciaMax", "FrecuenciaMaxAlcanzada", "ResultadoFrecMax", "IRC", "ClasificacionIRC", "DxPrincipal-CodCUP", "Patologia", "Dx2-CodCUP", "Patologia", "Dx3Principal-CodCUP", "Patologia"}) { // from class: Sig.JIFGenericoxFecha.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(7).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(11).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(12).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(13).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(14).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(15).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(16).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(17).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(18).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(19).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(20).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(21).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(22).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(23).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(24).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(25).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(26).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(27).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(28).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(29).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(30).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(31).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(32).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(33).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(34).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(35).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(36).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(37).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(38).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(39).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(40).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(41).setPreferredWidth(50);
        this.JTResultado.getColumnModel().getColumn(42).setPreferredWidth(50);
    }

    private void mBuscaDeportologia() {
        try {
            mCrearModeloMedDeporte();
            String sql = "SELECT     `g_persona`.`Id_TipoIdentificacion`     , `g_persona`.`NoDocumento`     , `g_usuario`.`NoHistoria`     , `g_persona`.`Apellido1`     , `g_persona`.`Apellido2`     , `g_persona`.`Nombre1`     , `g_persona`.`Nombre2`     , `g_persona`.`Id_Sexo`     , `g_persona`.`FechaNac`     , `g_persona`.`Edad`     , `g_persona`.`Correo`     , `ingreso`.`SO_Cargo`     , `ingreso`.`SO_Grupo`     , `ingreso`.`SO_Supervisor`     , `ingreso`.`SO_SEG`     , `ingreso`.`SO_UNegocio`     , `h_atencion`.`Fecha_Atencion`     , `c_clasecita`.`Nbre` as ClaseCita     , `h_examenfisico`.`TArtSentadoS`      , `h_examenfisico`.`TArtSentadoD`     , `h_examenfisico`.`Peso`     , `h_examenfisico`.`Talla`     , `h_examenfisico`.`IMC`     , `h_examenfisico`.`RImc`     , `h_examenfisico`.`PerimetroAbdominal`     , `h_examenfisico`.`RPAbdominal`     , `h_examenfisico`.`PGrasa`     , `h_examenfisico`.`RPGrasa`     , `h_examenfisico`.`Flexibilidad`     , `h_examenfisico`.`RFlexibilidad`     , `h_examenfisico`.`ResultadoVMAX`     , `h_examenfisico`.`ClaVMAX`     , `h_examenfisico`.`FrecMax`     , `h_examenfisico`.`FrecMaxAlc`     , `h_examenfisico`.`ResultadoFrecMax`     , `h_examenfisico`.`IRC`     , `h_examenfisico`.`ClaIRC`     , `h_atencion`.`Codigo_Dxp`     , `g_patologia`.`Nbre` as NombreDx1     , `h_atencion`.`Codigo_DxR1`     , if(`g_patologia_1`.`Nbre` is null,'',`g_patologia_1`.`Nbre`) as NombreDx2     , `h_atencion`.`Codigo_DxR2`     , if(`g_patologia_2`.`Nbre` is null,'',`g_patologia_2`.`Nbre` ) as NombreDx3 FROM     `h_atencion` INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)     INNER JOIN `c_clasecita`   ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)     INNER JOIN `g_persona`  ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)     INNER JOIN `g_usuario`   ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)     INNER JOIN `h_examenfisico` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`)     INNER JOIN `g_patologia`  ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)     left JOIN `g_patologia` AS `g_patologia_1`  ON (`h_atencion`.`Codigo_DxR1` = `g_patologia_1`.`Id`)     left JOIN `g_patologia` AS `g_patologia_2` ON (`h_atencion`.`Codigo_DxR2` = `g_patologia_2`.`Id`) WHERE (`h_atencion`.`Id_Especialidad` =383 AND `h_atencion`.`Fecha_Atencion` >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'     AND `h_atencion`.`Fecha_Atencion` <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "' AND `h_atencion`.`Estado` =0) order by `g_persona`.`Apellido1` asc;";
            System.out.println("sql deport-->" + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), n, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), n, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), n, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 12);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 13);
                    this.xmodelo.setValueAt(xrs.getString(15), n, 14);
                    this.xmodelo.setValueAt(xrs.getString(16), n, 15);
                    this.xmodelo.setValueAt(xrs.getString(17), n, 16);
                    this.xmodelo.setValueAt(xrs.getString(18), n, 17);
                    this.xmodelo.setValueAt(xrs.getString(19), n, 18);
                    this.xmodelo.setValueAt(xrs.getString(20), n, 19);
                    this.xmodelo.setValueAt(xrs.getString(21), n, 20);
                    this.xmodelo.setValueAt(xrs.getString(22), n, 21);
                    this.xmodelo.setValueAt(xrs.getString(23), n, 22);
                    this.xmodelo.setValueAt(xrs.getString(24), n, 23);
                    this.xmodelo.setValueAt(xrs.getString(25), n, 24);
                    this.xmodelo.setValueAt(xrs.getString(26), n, 25);
                    this.xmodelo.setValueAt(xrs.getString(27), n, 26);
                    this.xmodelo.setValueAt(xrs.getString(28), n, 27);
                    this.xmodelo.setValueAt(xrs.getString(29), n, 28);
                    this.xmodelo.setValueAt(xrs.getString(30), n, 29);
                    this.xmodelo.setValueAt(xrs.getString(31), n, 30);
                    this.xmodelo.setValueAt(xrs.getString(32), n, 31);
                    this.xmodelo.setValueAt(xrs.getString(33), n, 32);
                    this.xmodelo.setValueAt(xrs.getString(34), n, 33);
                    this.xmodelo.setValueAt(xrs.getString(35), n, 34);
                    this.xmodelo.setValueAt(xrs.getString(36), n, 35);
                    this.xmodelo.setValueAt(xrs.getString(37), n, 36);
                    this.xmodelo.setValueAt(xrs.getString(38), n, 37);
                    this.xmodelo.setValueAt(xrs.getString(39), n, 38);
                    this.xmodelo.setValueAt(xrs.getString(40), n, 39);
                    this.xmodelo.setValueAt(xrs.getString(41), n, 40);
                    this.xmodelo.setValueAt(xrs.getString(42), n, 41);
                    this.xmodelo.setValueAt(xrs.getString(43), n, 42);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mIniciar() {
    }

    public void mNuevo() {
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
        this.JDFFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloSomnolencia() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"No. Historia", "Usuario", "Sexo", "FechaDespacho ", "Cod.Barra", "Suministro"}) { // from class: Sig.JIFGenericoxFecha.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(400);
    }

    private void mBuscaSomnolencia() {
        String sql;
        try {
            mCrearModeloSomnolencia();
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                sql = "SELECT\n    `g_usuario`.`NoHistoria`\n    ,CONCAT(`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2` ,' ', `g_persona`.`Apellido1` ,' ' , `g_persona`.`Apellido2`) AS usuario\n    , `g_persona`.`Id_Sexo`\n    , `i_salidas`.`FechaSalida`\n    , `i_suministro`.`CodBarraUnidad`\n    , `i_suministro`.`Nbre`\nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`i_salidas`.`IdDestino` = `g_persona`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `g_usuario_fpz` \n        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n     INNER JOIN `i_bodegas` \n        ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`)\nWHERE (if((`i_suministro`.`DLogo` is null or `i_suministro`.`DLogo`='(NULL)'),'', `i_suministro`.`DLogo`)<>''  and `g_usuario_fpz`.`Id_Parentesco` =1\n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') ORDER BY `i_salidas`.`FechaSalida` DESC";
            } else {
                sql = "SELECT\n    `g_usuario`.`NoHistoria`\n    ,CONCAT(`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2` ,' ', `g_persona`.`Apellido1` ,' ' , `g_persona`.`Apellido2`) AS usuario\n    , `g_persona`.`Id_Sexo`\n    , `i_salidas`.`FechaSalida`\n    , `i_suministro`.`CodBarraUnidad`\n    , `i_suministro`.`Nbre`\nFROM\n    `i_detallesalida`\n    INNER JOIN `i_salidas` \n        ON (`i_detallesalida`.`IdSalida` = `i_salidas`.`Id`)\n    INNER JOIN `g_persona` \n        ON (`i_salidas`.`IdDestino` = `g_persona`.`Id`)\n    INNER JOIN `i_suministro` \n        ON (`i_detallesalida`.`IdSuministro` = `i_suministro`.`Id`)\n    INNER JOIN `g_usuario` \n        ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n     INNER JOIN `i_bodegas` \n        ON (`i_salidas`.`IdBodega` = `i_bodegas`.`Id`)\nWHERE (if((`i_suministro`.`DLogo` is null or `i_suministro`.`DLogo`='(NULL)'),'', `i_suministro`.`DLogo`)<>'' \n    AND `i_salidas`.`FechaSalida` >='" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "' AND `i_salidas`.`FechaSalida` <='" + this.xmt.formatoAMD.format(this.JDFFechaF.getDate()) + "') ORDER BY `i_salidas`.`FechaSalida` DESC";
            }
            System.out.println("sql somnolencia-->" + sql);
            ResultSet xrs = this.xconsultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    n++;
                }
            }
            xrs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFInformesMov.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
