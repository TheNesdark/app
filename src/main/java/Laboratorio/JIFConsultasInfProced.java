package Laboratorio;

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
import java.io.IOException;
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
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFConsultasInfProced.class */
public class JIFConsultasInfProced extends JInternalFrame {
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xidprocedimiento;
    private String xsql;
    private ButtonGroup JBGFiltro;
    private JButton JBTGrafico1;
    private JComboBox JCBProcedimiento;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHFiltroPyP;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JRadioButton JRBMuestraN;
    private JRadioButton JRBNormal;
    private JRadioButton JRBTodo;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;

    public JIFConsultasInfProced(String xidnombre) {
        initComponents();
        setName(xidnombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCBProcedimiento = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JCHFiltroPyP = new JCheckBox();
        this.jPanel1 = new JPanel();
        this.JRBNormal = new JRadioButton();
        this.JRBMuestraN = new JRadioButton();
        this.JRBTodo = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGrafico1 = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTAR INFORMACIÓN DE EXÁMENES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setName("jifconsultarinforlab");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfProced.1
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfProced.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCHFiltroPyP.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroPyP.setText("Filtro por programa");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Muestra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGFiltro.add(this.JRBNormal);
        this.JRBNormal.setFont(new Font("Arial", 1, 12));
        this.JRBNormal.setText("Normal");
        this.JBGFiltro.add(this.JRBMuestraN);
        this.JRBMuestraN.setFont(new Font("Arial", 1, 12));
        this.JRBMuestraN.setText("Muestra Nueva");
        this.JBGFiltro.add(this.JRBTodo);
        this.JRBTodo.setFont(new Font("Arial", 1, 12));
        this.JRBTodo.setText("Todo");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JRBTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addComponent(this.JRBNormal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBMuestraN).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodo).addComponent(this.JRBNormal).addComponent(this.JRBMuestraN)).addGap(0, 0, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBProcedimiento, 0, 911, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(12, 12, 12).addComponent(this.JCHFiltro).addGap(29, 29, 29).addComponent(this.JCHFiltroPyP).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 937, 32767));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addGap(32, 32, 32)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, 51, -2).addComponent(this.JDFechaI, -2, 51, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JCHFiltroPyP)))).addGap(34, 34, 34))).addComponent(this.JCBProcedimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 281, 32767).addContainerGap()));
        this.JBTGrafico1.setFont(new Font("Arial", 1, 12));
        this.JBTGrafico1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTGrafico1.setText("Exportar");
        this.JBTGrafico1.addActionListener(new ActionListener() { // from class: Laboratorio.JIFConsultasInfProced.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultasInfProced.this.JBTGrafico1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFConsultasInfProced.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultasInfProced.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 436, -2).addGap(143, 143, 143).addComponent(this.JBTGrafico1, -1, 368, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrafico1, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2)).addContainerGap()));
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
    public void JBTGrafico1ActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1 && !this.JTFRuta.getText().isEmpty()) {
            mExportar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        this.JCBProcedimiento.removeAllItems();
        mCrearModeloDatos();
        if (this.JCHFiltro.isSelected()) {
            this.xsql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (l_recepcion.Estado =0 AND l_recepcion.FechaRecep >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " 00:00:00' AND l_recepcion.FechaRecep <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " 23:59:59') GROUP BY g_procedimiento.Id ORDER BY g_procedimiento.Nbre ASC ";
        } else {
            this.xsql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (l_recepcion.Estado =0 ) GROUP BY g_procedimiento.Id ORDER BY g_procedimiento.Nbre ASC ";
        }
        this.xidprocedimiento = this.xconsulta.llenarCombo(this.xsql, this.xidprocedimiento, this.JCBProcedimiento);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    public void mBuscar() {
        String filtro = "";
        if (this.JRBTodo.isSelected()) {
            filtro = "IN(0,1)";
        } else if (this.JRBNormal.isSelected()) {
            filtro = "IN(0)";
        } else if (this.JRBMuestraN.isSelected()) {
            filtro = "IN(1)";
        }
        if (!this.JCHFiltro.isSelected()) {
            String sql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre, COUNT(l_recepcion.Id) FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN   `f_ordenes`  ON (`f_ordenes`.`Id` = `l_recepcion`.`Id_OrdenFacturac`) INNER JOIN   `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = ingreso.`Id`) WHERE (l_recepcion.Estado =0 AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND ingreso.`NMuestra` " + filtro + ") GROUP BY g_procedimiento.Id ORDER BY g_procedimiento.Nbre ASC ";
            mCargarDatosTabla(sql);
        } else if (this.JCBProcedimiento.getSelectedIndex() != -1) {
            String sql2 = "SELECT g_procedimiento.Id, g_procedimiento.Nbre, COUNT(l_recepcion.Id) FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (l_recepcion.Estado =0 AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND DATE_FORMAT(l_recepcion.FechaRecep,'%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' and g_procedimiento.Id='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "') GROUP BY g_procedimiento.Id ORDER BY g_procedimiento.Nbre ASC ";
            mCargarDatosTabla(sql2);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProcedimiento.requestFocus();
        }
    }

    private void mExportar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 0, "CONSOLIDADO DE EXAMENES"));
                sheet.addCell(new Label(0, 1, "Id"));
                sheet.addCell(new Label(1, 1, "Procedimiento"));
                sheet.addCell(new Label(2, 1, "Cantidad"));
                int z = 1;
                for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
                    sheet.addCell(new Number(0, z, Long.valueOf(this.xmodelo.getValueAt(x, 0).toString()).longValue()));
                    sheet.addCell(new Label(1, z, this.xmodelo.getValueAt(x, 1).toString()));
                    sheet.addCell(new Number(2, z, Long.valueOf(this.xmodelo.getValueAt(x, 2).toString()).longValue()));
                    z++;
                }
                if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                    WritableSheet sheet1 = workbook.createSheet("Detalle", 1);
                    sheet1.addCell(new Label(0, 0, "RESULTADO DE EXAMENES"));
                    sheet1.addCell(new Label(0, 1, "NHC"));
                    sheet1.addCell(new Label(1, 1, "TD"));
                    sheet1.addCell(new Label(2, 1, "NDocumento"));
                    sheet1.addCell(new Label(3, 1, "NUsuario"));
                    sheet1.addCell(new Label(4, 1, "FechaNac"));
                    sheet1.addCell(new Label(5, 1, "Edad"));
                    sheet1.addCell(new Label(6, 1, "TipoEdad"));
                    sheet1.addCell(new Label(7, 1, "Sexo"));
                    sheet1.addCell(new Label(8, 1, "Departamento"));
                    sheet1.addCell(new Label(9, 1, "Municipio"));
                    sheet1.addCell(new Label(10, 1, "Dirección"));
                    sheet1.addCell(new Label(11, 1, "Teléfono"));
                    sheet1.addCell(new Label(12, 1, "Tipo Empresa"));
                    sheet1.addCell(new Label(13, 1, "Parentesco"));
                    sheet1.addCell(new Label(14, 1, "Eps"));
                    sheet1.addCell(new Label(15, 1, "Tipo Afiliación"));
                    sheet1.addCell(new Label(16, 1, "FechaResultado"));
                    sheet1.addCell(new Label(17, 1, "Exámen"));
                    sheet1.addCell(new Label(18, 1, "Protocolo"));
                    sheet1.addCell(new Label(19, 1, "V/Resultado"));
                    ConsultasMySQL xt2 = new ConsultasMySQL();
                    if (this.JCHFiltroPyP.isSelected()) {
                        this.xsql = "SELECT persona.NoHistoria, persona.Id_TipoIdentificacion, persona.NoDocumento, persona.NUsuario, date_format(persona.FechaNac,'%d-%m-%Y') as FechaN, persona.Edad, persona.NTipoEdad, persona.NSexo, g_departamento.Nbre AS NDepartamento , g_municipio.Nbre AS NMunicipio, persona.Direccion, persona.Telefono, g_tipoempresa.Nbre AS NTipoEmpresa, g_parentesco.Nbre AS Nparentesco, f_empresacontxconvenio.Nbre AS NEmpresa, g_tipoafiliado.Nbre AS NTipoAfiliacion, date_format(l_resultados.FechaResult,'%d-%m-%Y') as FechaR , g_procedimiento.Nbre , l_protocolos.Nbre , IF(l_tiporesultado.Id=l_detalleresultado.VrNumerico,l_tiporesultado.Nbre,l_detalleresultado.VrNumerico) AS Resultado FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) INNER JOIN l_resultados  ON (l_resultados.Id_Recepcion = l_recepcion.Id) INNER JOIN l_detalleresultado  ON (l_detalleresultado.Id_Resultado = l_resultados.Id) INNER JOIN l_tiporesultado  ON (l_detalleresultado.Resultado = l_tiporesultado.Id) INNER JOIN l_protocoloxprocedimiento ON (l_protocoloxprocedimiento.Id_Procedim = g_procedimiento.Id) AND (l_detalleresultado.Id_ProtocolProcedim = l_protocoloxprocedimiento.Id) INNER JOIN l_protocolos  ON (l_protocoloxprocedimiento.Id_Protocolo = l_protocolos.Id) INNER JOIN persona  ON (persona.Id_persona = l_recepcion.Id_Paciente) INNER JOIN g_usuario  ON (g_usuario.Id_persona = persona.Id_persona) INNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN g_municipio  ON (g_persona.Id_Municipio = g_municipio.Id) INNER JOIN g_departamento  ON (g_municipio.Id_Dpto = g_departamento.Id) INNER JOIN g_usuario_fpz  ON (g_usuario_fpz.Id_Persona = g_persona.Id) INNER JOIN g_usuarioxprograma  ON (g_usuario.Id_persona = g_usuarioxprograma.Id_Usuario)INNER JOIN g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN g_tipoempresa  ON (g_usuario_fpz.Id_Empresa = g_tipoempresa.Id) INNER JOIN g_empresacont  ON (g_usuario.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa) INNER JOIN g_tipoafiliado  ON (g_usuario.Id_TipoAfiliado = g_tipoafiliado.Id) WHERE (g_procedimiento.Id ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "' AND l_recepcion.FechaRecep >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + " 00:00:00' AND l_recepcion.FechaRecep <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + " 23:59:59 ' AND l_recepcion.Estado =0 AND g_usuarioxprograma.Estado =0) ORDER BY persona.NUsuario ASC ";
                    } else {
                        this.xsql = "SELECT\n      `g_persona`.`NoDocumento`\n    , `g_persona`.`Id_TipoIdentificacion`\n    , `g_persona`.`NoDocumento`\n    ,  CONCAT( `g_persona`.`Nombre1`,' ' , `g_persona`.`Nombre2` ,' ', `g_persona`.`Apellido1` ,' ',  `g_persona`.`Apellido2`) NUsuario\n    , `g_persona`.`FechaNac`\n    , `g_persona`.`Edad`\n    ,  IF(g_persona.`Id_TipoEdad`=1,'AÑOS' , IF(g_persona.`Id_TipoEdad`=2,'MESES', 'DIAS')) TipoEdad\n   ,  `g_persona`.`Id_Sexo`\n    , `g_departamento`.`Nbre` AS `Departamento`\n    , `g_municipio`.`Nbre` AS `Municipio`\n    , `g_persona`.`Direccion`\n    ,  CONCAT(`g_persona`.`Telefono`,' -' , `g_persona`.`Movil` ) Telefono\n    , `g_tipoempresa`.`Nbre` AS  TipoEmpresa\n    , `g_parentesco`.`Nbre` AS `Parentesco`\n    , `g_empresa`.`Nbre` AS `e.p.s.`\n    , `g_tipoafiliado`.`Nbre` AS `afiliacion`\n    , `l_resultados`.`FechaResult`\n    , `g_procedimiento`.`Nbre` AS `procedimiento`\n    ,  l_protocolos.Nbre \n    ,  IF(l_tiporesultado.Id=l_detalleresultado.VrNumerico,l_tiporesultado.Nbre,l_detalleresultado.VrNumerico) AS Resultado \nFROM\n    `g_usuario`\n    INNER JOIN `g_persona`  ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\n    INNER JOIN `g_municipio`    ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)\n    INNER JOIN `g_tipoedad`     ON (`g_persona`.`Id_TipoEdad` = `g_tipoedad`.`Id`)\n    INNER JOIN `l_recepcion`      ON (`g_usuario`.`Id_persona` = `l_recepcion`.`Id_Paciente`)\n    INNER JOIN `g_empresacont`      ON (`g_usuario`.`Id_EmpresaCont` = `g_empresacont`.`Id_empresa`)\n    INNER JOIN `g_tipoafiliado`        ON (`g_usuario`.`Id_TipoAfiliado` = `g_tipoafiliado`.`Id`)\n    INNER JOIN `g_usuario_fpz`        ON (`g_usuario_fpz`.`Id_Persona` = `g_persona`.`Id`)\n    INNER JOIN `g_tipoempresa`      ON (`g_usuario_fpz`.`Id_Empresa` = `g_tipoempresa`.`Id`)\n    INNER JOIN `g_parentesco`       ON (`g_usuario_fpz`.`Id_Parentesco` = `g_parentesco`.`Id`)\n    INNER JOIN `l_detallerecepcion`       ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_resultados`       ON (`l_resultados`.`Id_Recepcion` = `l_recepcion`.`Id`)\n    INNER JOIN `l_detalleresultado`       ON (`l_detalleresultado`.`Id_Resultado` = `l_resultados`.`Id`)\n    INNER JOIN `g_departamento`     ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)\n    INNER JOIN `g_empresa`      ON (`g_empresacont`.`Id_empresa` = `g_empresa`.`Id`)\n    INNER JOIN `g_procedimiento`      ON (`g_procedimiento`.`Id` = `l_detalleresultado`.`Id_Procedimiento`)\n    INNER JOIN `l_protocoloxprocedimiento`      ON (`l_detalleresultado`.`Id_ProtocolProcedim` = `l_protocoloxprocedimiento`.`Id`)\n    INNER JOIN `l_protocolos`     ON (`l_protocoloxprocedimiento`.`Id_Protocolo` = `l_protocolos`.`Id`)\n    INNER JOIN `l_tiporesultado`    ON (`l_tiporesultado`.`Id` = `l_detalleresultado`.`Resultado`)\n     WHERE (g_procedimiento.Id ='" + this.xidprocedimiento[this.JCBProcedimiento.getSelectedIndex()] + "'  AND l_recepcion.`Fecha_Toma` >='" + this.xmt.formatoAMDG.format(this.JDFechaI.getDate()) + "' \n        AND l_recepcion.Fecha_Toma <='" + this.xmt.formatoAMDG.format(this.JDFechaF.getDate()) + "' AND l_recepcion.Estado =0) ORDER BY NUsuario ASC ";
                    }
                    ResultSet rs = xt2.traerRs(this.xsql);
                    if (rs.next()) {
                        rs.beforeFirst();
                        int y = 2;
                        while (rs.next()) {
                            sheet1.addCell(new Label(0, y, rs.getString(1)));
                            sheet1.addCell(new Label(1, y, rs.getString(2)));
                            sheet1.addCell(new Label(2, y, rs.getString(3)));
                            sheet1.addCell(new Label(3, y, rs.getString(4)));
                            sheet1.addCell(new Label(4, y, rs.getString(5)));
                            sheet1.addCell(new Number(5, y, rs.getInt(6)));
                            sheet1.addCell(new Label(6, y, rs.getString(7)));
                            sheet1.addCell(new Label(7, y, rs.getString(8)));
                            sheet1.addCell(new Label(8, y, rs.getString(9)));
                            sheet1.addCell(new Label(9, y, rs.getString(10)));
                            sheet1.addCell(new Label(10, y, rs.getString(11)));
                            sheet1.addCell(new Label(11, y, rs.getString(12)));
                            sheet1.addCell(new Label(12, y, rs.getString(13)));
                            sheet1.addCell(new Label(13, y, rs.getString(14)));
                            sheet1.addCell(new Label(14, y, rs.getString(15)));
                            sheet1.addCell(new Label(15, y, rs.getString(16)));
                            sheet1.addCell(new Label(16, y, rs.getString(17)));
                            sheet1.addCell(new Label(17, y, rs.getString(18)));
                            sheet1.addCell(new Label(18, y, rs.getString(19)));
                            sheet1.addCell(new Label(19, y, rs.getString(20)));
                            y++;
                        }
                    }
                    rs.close();
                    xt2.cerrarConexionBd();
                }
                workbook.write();
                workbook.close();
            } catch (SQLException ex) {
                Logger.getLogger(JIFConsultasInfProced.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFConsultasInfProced.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex2) {
                Logger.getLogger(JIFConsultasInfProced.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    public void mNuevo() {
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JRBTodo.setSelected(true);
        this.JCBProcedimiento.removeAllItems();
        this.xsql = "SELECT g_procedimiento.Id, g_procedimiento.Nbre FROM l_detallerecepcion INNER JOIN l_recepcion  ON (l_detallerecepcion.Id_Recepcion = l_recepcion.Id) INNER JOIN g_procedimiento  ON (l_detallerecepcion.Id_Procedim = g_procedimiento.Id) WHERE (l_recepcion.Estado =0 ) GROUP BY g_procedimiento.Id ORDER BY g_procedimiento.Nbre ASC ";
        this.xidprocedimiento = this.xconsulta.llenarCombo(this.xsql, this.xidprocedimiento, this.JCBProcedimiento);
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JCHFiltro.setSelected(false);
        mCrearModeloDatos();
        this.JDFechaI.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Cantidad"}) { // from class: Laboratorio.JIFConsultasInfProced.4
            Class[] types = {Long.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(40);
    }

    public void mCargarDatosTabla(String xsql) {
        try {
            mCrearModeloDatos();
            ResultSet xrs = this.xconsulta.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(3)), n, 2);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFConsultasInfProced.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
