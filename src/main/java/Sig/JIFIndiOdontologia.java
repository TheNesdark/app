package Sig;

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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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

/* JADX INFO: loaded from: GenomaP.jar:Sig/JIFIndiOdontologia.class */
public class JIFIndiOdontologia extends JInternalFrame {
    private String[] xidCombo;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloPaciente;
    private Object[] xdatos;
    private JButton JBTExportar;
    private JComboBox JCBUno;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JRadioButton JRBPaciente;
    private JRadioButton JTBProc;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFIndiOdontologia() {
        initComponents();
        mIniciaElementos();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBUno = new JComboBox();
        this.JTBProc = new JRadioButton();
        this.JRBPaciente = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INFORME ODONTOLOGÍA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifInformeOdont");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sig.JIFIndiOdontologia.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFIndiOdontologia.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setFont(new Font("Arial", 1, 12));
        this.JCBUno.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.buttonGroup1.add(this.JTBProc);
        this.JTBProc.setFont(new Font("Arial", 1, 12));
        this.JTBProc.setSelected(true);
        this.JTBProc.setText("No. Procedimientos");
        this.buttonGroup1.add(this.JRBPaciente);
        this.JRBPaciente.setFont(new Font("Arial", 1, 12));
        this.JRBPaciente.setText("No. Pacientes Atendidos");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUno, -2, 294, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTBProc).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addComponent(this.JRBPaciente).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, -1, -2).addComponent(this.JDFechaI, -2, -1, -2))).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUno, -2, -1, -2).addComponent(this.JTBProc).addComponent(this.JRBPaciente)))).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Sig.JIFIndiOdontologia.2
            public void mouseClicked(MouseEvent evt) {
                JIFIndiOdontologia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Sig.JIFIndiOdontologia.3
            public void actionPerformed(ActionEvent evt) {
                JIFIndiOdontologia.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 340, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 397, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 52, 32767).addComponent(this.JBTExportar, -1, -1, 32767)).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
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
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "Confirmación", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.JRBPaciente.isSelected()) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                } else {
                    mExportaProc();
                }
            }
        }
    }

    private void mExportaProc() {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
            WritableSheet sheet = workbook.createSheet("Consolidado", 0);
            for (int x = 0; x < this.JTDetalle.getColumnCount(); x++) {
                sheet.addCell(new Label(x, 0, this.JTDetalle.getColumnName(x)));
            }
            int y = 1;
            for (int x2 = 0; x2 < this.JTDetalle.getRowCount(); x2++) {
                sheet.addCell(new Label(0, y, this.xmodelo.getValueAt(x2, 0).toString()));
                sheet.addCell(new Label(1, y, this.xmodelo.getValueAt(x2, 1).toString()));
                sheet.addCell(new Number(2, y, Integer.valueOf(this.xmodelo.getValueAt(x2, 2).toString()).intValue()));
                sheet.addCell(new Label(3, y, this.xmodelo.getValueAt(x2, 3).toString()));
                sheet.addCell(new Label(4, y, this.xmodelo.getValueAt(x2, 4).toString()));
                y++;
            }
            String sql = "SELECT persona.`Id_TipoIdentificacion`, persona.`NoDocumento`, persona.`NUsuario` AS NombreUsuario,persona.`NSexo` ,persona.`Edad`, persona.`FechaNac`, o_hc_tratamiento_procedimiento.`Id_Tratamiento` AS CodTratamiento, `o_hc_tratamiento_procedimiento`.`IdProcedimiento` , `g_procedimiento`.`Nbre` AS Procedimiento\n    , `o_hc_tratamiento_procedimiento`.`Cantidad` , DATE_FORMAT(`o_hc_tratamiento_procedimiento`.`Fecha`,'%Y-%m-%d') AS FechaProcedimiento \n    , `profesional1`.`NProfesional` , `profesional1`.`Especialidad` \n FROM `o_hc_tratamiento_procedimiento` INNER JOIN `o_hc_tratamiento`   ON (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` = `o_hc_tratamiento`.`Id`)\n    INNER JOIN `profesional1`   ON (`o_hc_tratamiento`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`o_hc_tratamiento`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)\n    INNER JOIN `g_procedimiento`  ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `h_atencion`   ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso`   ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `persona`   ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`)\n WHERE (`o_hc_tratamiento`.`Id_Especialidad` ='" + this.xidCombo[this.JCBUno.getSelectedIndex()] + "' AND DATE_FORMAT(`o_hc_tratamiento_procedimiento`.`Fecha`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND DATE_FORMAT(`o_hc_tratamiento_procedimiento`.`Fecha`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND o_hc_tratamiento_procedimiento.`Estado`=1) ORDER BY `profesional1`.`NProfesional` ASC,`o_hc_tratamiento_procedimiento`.`Fecha` DESC;";
            System.out.println("Detalle-->" + sql);
            ResultSet xrs = this.xct.traerRs(sql);
            try {
                ResultSetMetaData rsmetadatos = xrs.getMetaData();
                sheet = workbook.createSheet("Detalle", 1);
                for (int x3 = 1; x3 <= rsmetadatos.getColumnCount(); x3++) {
                    sheet.addCell(new Label(x3 - 1, 0, rsmetadatos.getColumnName(x3)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
            try {
                if (xrs.next()) {
                    int x4 = 0;
                    xrs.beforeFirst();
                    while (xrs.next()) {
                        sheet.addCell(new Label(0, x4 + 1, xrs.getString(1)));
                        sheet.addCell(new Label(1, x4 + 1, xrs.getString(2)));
                        sheet.addCell(new Label(2, x4 + 1, xrs.getString(3)));
                        sheet.addCell(new Label(3, x4 + 1, xrs.getString(4)));
                        sheet.addCell(new Label(4, x4 + 1, xrs.getString(5)));
                        sheet.addCell(new Label(5, x4 + 1, xrs.getString(6)));
                        sheet.addCell(new Label(6, x4 + 1, xrs.getString(7)));
                        sheet.addCell(new Label(7, x4 + 1, xrs.getString(8)));
                        sheet.addCell(new Label(8, x4 + 1, xrs.getString(9)));
                        sheet.addCell(new Number(9, x4 + 1, xrs.getInt(10)));
                        sheet.addCell(new Label(10, x4 + 1, xrs.getString(11)));
                        sheet.addCell(new Label(11, x4 + 1, xrs.getString(12)));
                        sheet.addCell(new Label(12, x4 + 1, xrs.getString(13)));
                        x4++;
                    }
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex2) {
                Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
            workbook.write();
            workbook.close();
        } catch (WriteException e) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, e);
        } catch (IOException ex3) {
            Logger.getLogger(JIFInformesPyP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex3);
        }
    }

    private void mIniciaElementos() {
        this.xidCombo = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `g_especialidad` WHERE (`EsOdontologia` =1  AND `Estado` =0) ORDER BY Nbre;", this.xidCombo, this.JCBUno);
        this.JCBUno.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JDFechaI.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloProc() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod. Procedimiento", "Procedimiento", "Cantidad", "Profesional", "Especialidad"}) { // from class: Sig.JIFIndiOdontologia.4
            Class[] types = {String.class, String.class, Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    public void mBuscar() {
        if (this.JTBProc.isSelected()) {
            mBuscaProc();
        } else {
            mBuscaPaciente();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloPaciente() {
        this.xmodeloPaciente = new DefaultTableModel(new Object[0], new String[]{"TipoDocumento", "No.Documento", "Nomber Usuario", "Sexo", "Edad", "FechaNac", "TipoAfiliacion", "Cod. Tratamiento", "FechaAtencion", "ClaseCita", "Asistencia", "EstadoTratamiento", "Cod. Atencion", "CIE10", "Patologia", "TipoDX", "Profesional", "Especialidad"}) { // from class: Sig.JIFIndiOdontologia.5
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodeloPaciente);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    }

    private void mBuscaPaciente() {
        String sql = "SELECT\n  `g_persona`.`Id_TipoIdentificacion`,\n  `g_persona`.`NoDocumento`,\n  concat(`g_persona`.`Apellido1`,' ',`g_persona`.`Apellido2`,' ',`g_persona`.`Nombre1`,' ',`g_persona`.`Nombre2`) NUsuario,\n  `g_sexo`.`Nbre` as `NSexo`,\n  `g_persona`.`Edad`,\n  `g_persona`.`FechaNac`,\n  `g_tipoafiliado`.`Nbre` as TipoAfiliacion,\n  `c_citas`.`Id_TratamientoO` AS CodTratamiento,\n  `c_citas`.`Fecha_Cita`,\n  `c_clasecita`.`Nbre` AS ClaseCita,\n  IF(`c_citas`.`Asistida` = 0,'No Asistida',IF(`c_citas`.`Asistida` = 1,'Asistida(Facturada)',IF(`c_citas`.`Asistida` = 2,'Anulada','Atendida'))) AS Asistida,\n  IF(o_hc_tratamiento.`Estado` = 1,'TTO Activo','TTO Cerrado') AS EstadoTTO,\n  IF(h_atencion.`Id` IS NULL,'',h_atencion.`Id`) AS CodigoAtencion,\n  IF(h_atencion.`Codigo_Dxp` IS NULL,'',h_atencion.`Codigo_Dxp`) AS CIE10,\n  IF(g_patologia.`Nbre` IS NULL,'',g_patologia.`Nbre`) AS Patologia,\n  IF(h_tipodiagnostico.`Nbre` IS NULL,'',h_tipodiagnostico.`Nbre`) AS TipoDX,\n  concat(`profesional`.`Apellido1`,' ',`profesional`.`Apellido2`,' ',`profesional`.`Nombre1`,' ',`profesional`.`Nombre2`) NProfesional,\n  `g_especialidad`.`Nbre` `Especialidad`\nFROM\n  `c_citas`\n  inner join `g_persona` \n    ON (`c_citas`.`Id_Usuario` = `g_persona`.`Id`)\n  inner join `g_sexo`\n    on (`g_sexo`.`Id` = `g_persona`.`Id_Sexo`)\n  inner join `g_usuario`\n    on (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n  inner join g_tipoafiliado\n    on (`g_tipoafiliado`.`Id` =`g_usuario`.`Id_TipoAfiliado`)\n  inner join `g_profesionalespecial`\n    on (g_profesionalespecial.`Id_Profesional` = `c_citas`.`Id_Profesional`) and (g_profesionalespecial.`Id_Especialidad` = `c_citas`.`Id_Especialidad`)\n  inner join `g_persona` as profesional\n    on (profesional.`Id` = g_profesionalespecial.`Id_Profesional`)\n  inner join  `g_especialidad`\n    ON (`g_especialidad`.`Id` = `g_profesionalespecial`.`Id_Especialidad`)  \n  INNER JOIN `c_clasecita`\n    ON (c_citas.`Id_ClaseCita` = c_clasecita.`Id`)\n  LEFT JOIN `o_hc_tratamiento`\n    ON (`c_citas`.`Id_TratamientoO` = `o_hc_tratamiento`.`Id`)\n  LEFT JOIN `h_atencion`\n    ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`)\n  LEFT JOIN `g_patologia`\n    ON (`h_atencion`.`Codigo_Dxp` = `g_patologia`.`Id`)\n  LEFT JOIN `h_tipodiagnostico`\n    ON (`h_atencion`.`Id_TipoDx` = `h_tipodiagnostico`.`Id`)\nWHERE (\n    `c_citas`.`Fecha_Cita` >= '" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND `c_citas`.`Fecha_Cita` <= '" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "'\n    AND `c_citas`.`Id_Especialidad` = '" + this.xidCombo[this.JCBUno.getSelectedIndex()] + "'\n  )\nORDER BY `c_citas`.`Fecha_Cita` DESC,\n  `NProfesional` ASC;";
        mModeloPaciente();
        System.out.println("Paciente-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodeloPaciente.addRow(this.xdatos);
                    this.xmodeloPaciente.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloPaciente.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloPaciente.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloPaciente.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloPaciente.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloPaciente.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloPaciente.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloPaciente.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloPaciente.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloPaciente.setValueAt(xrs.getString(10), n, 9);
                    this.xmodeloPaciente.setValueAt(xrs.getString(11), n, 10);
                    this.xmodeloPaciente.setValueAt(xrs.getString(12), n, 11);
                    this.xmodeloPaciente.setValueAt(xrs.getString(13), n, 12);
                    this.xmodeloPaciente.setValueAt(xrs.getString(14), n, 13);
                    this.xmodeloPaciente.setValueAt(xrs.getString(15), n, 14);
                    this.xmodeloPaciente.setValueAt(xrs.getString(16), n, 15);
                    this.xmodeloPaciente.setValueAt(xrs.getString(17), n, 16);
                    this.xmodeloPaciente.setValueAt(xrs.getString(18), n, 17);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFIndiOdontologia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaProc() {
        String sql = "SELECT `o_hc_tratamiento_procedimiento`.`IdProcedimiento`, `g_procedimiento`.`Nbre` AS Procedimiento, SUM(`o_hc_tratamiento_procedimiento`.`Cantidad`) AS cantidad\n    , `profesional1`.`NProfesional`, `profesional1`.`Especialidad`\n FROM `o_hc_tratamiento_procedimiento`\n    INNER JOIN `o_hc_tratamiento`  ON (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` = `o_hc_tratamiento`.`Id`)\n    INNER JOIN `profesional1`  ON (`o_hc_tratamiento`.`Id_Profesional` = `profesional1`.`Id_Persona`) AND (`o_hc_tratamiento`.`Id_Especialidad` = `profesional1`.`IdEspecialidad`)\n    INNER JOIN `g_procedimiento`  ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`)\n    INNER JOIN `h_atencion`  ON (`o_hc_tratamiento`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n WHERE (`o_hc_tratamiento`.`Id_Especialidad` ='" + this.xidCombo[this.JCBUno.getSelectedIndex()] + "' AND DATE_FORMAT(`o_hc_tratamiento_procedimiento`.`Fecha`,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "'\n    AND DATE_FORMAT(`o_hc_tratamiento_procedimiento`.`Fecha`,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND o_hc_tratamiento_procedimiento.`Estado`=1) GROUP BY `o_hc_tratamiento_procedimiento`.`IdProcedimiento`,profesional1.`Id_Persona`  ORDER BY `profesional1`.`NProfesional` ASC ,`g_procedimiento`.`Nbre`ASC;";
        mCreaModeloProc();
        System.out.println("Proc-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFIndiOdontologia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
