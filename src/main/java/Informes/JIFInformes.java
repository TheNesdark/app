package Informes;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFInformes.class */
public class JIFInformes extends JInternalFrame {
    private String[] listaProfesional;
    private String[] listaProgramas;
    private String[] listaEspecialidad;
    private String[] listaClaseCita;
    private String xtitulo;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPEstado;
    private JRadioButton JRBEstado1;
    private JRadioButton JRBEstado2;
    private JSpinner JSPCant;
    private JTextField JTFRuta;
    private JButton btnExportar;
    private JButton btnInforme;
    private JComboBox cboClaseCita;
    private JComboBox cboEspecialidad;
    private JComboBox cboProfesional;
    private JComboBox cboProgramas;
    private JComboBox cboTipoEdad;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JLabel lblTitulo;
    private JSpinner txtEdadFin;
    private JSpinner txtEdadIni;
    private int filaArbol = 0;
    private int cboLleno = 0;
    private String xestado = "1";
    private Metodos xmt = new Metodos();

    public JIFInformes(String xtitulo) {
        initComponents();
        Metodos xmt = new Metodos();
        this.JDFechaI.setDate(xmt.getFechaActual());
        this.JDFechaF.setDate(xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xtitulo = xtitulo;
        mActivarComponentes(xtitulo);
    }

    private void initComponents() {
        this.lblTitulo = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel1 = new JLabel();
        this.cboProfesional = new JComboBox();
        this.jLabel2 = new JLabel();
        this.cboEspecialidad = new JComboBox();
        this.btnInforme = new JButton();
        this.cboProgramas = new JComboBox();
        this.jLabel3 = new JLabel();
        this.jPanel3 = new JPanel();
        this.txtEdadIni = new JSpinner();
        this.txtEdadFin = new JSpinner();
        this.cboTipoEdad = new JComboBox();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jLabel4 = new JLabel();
        this.jLabel7 = new JLabel();
        this.cboClaseCita = new JComboBox();
        this.JPEstado = new JPanel();
        this.JRBEstado1 = new JRadioButton();
        this.JRBEstado2 = new JRadioButton();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.btnExportar = new JButton();
        this.JSPCant = new JSpinner();
        this.JCHFiltro = new JCheckBox();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERADOR DE INFORMES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.lblTitulo.setFont(new Font("Arial", 1, 14));
        this.lblTitulo.setForeground(new Color(0, 102, 0));
        this.lblTitulo.setHorizontalAlignment(0);
        this.lblTitulo.setText("GENERADOR DE INFORMES");
        this.lblTitulo.setOpaque(true);
        this.jPanel2.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 255));
        this.jLabel1.setText("Profesional");
        this.cboProfesional.setFont(new Font("Arial", 1, 12));
        this.cboProfesional.setEnabled(false);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 255));
        this.jLabel2.setText("Especialidad");
        this.cboEspecialidad.setFont(new Font("Arial", 1, 12));
        this.cboEspecialidad.setEnabled(false);
        this.cboEspecialidad.addActionListener(new ActionListener() { // from class: Informes.JIFInformes.1
            public void actionPerformed(ActionEvent evt) {
                JIFInformes.this.cboEspecialidadActionPerformed(evt);
            }
        });
        this.btnInforme.setFont(new Font("Arial", 1, 12));
        this.btnInforme.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.btnInforme.setText("Generar Informe");
        this.btnInforme.addActionListener(new ActionListener() { // from class: Informes.JIFInformes.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformes.this.btnInformeActionPerformed(evt);
            }
        });
        this.cboProgramas.setFont(new Font("Arial", 1, 12));
        this.cboProgramas.setEnabled(false);
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 255));
        this.jLabel3.setText("Programa");
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "EDAD", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.jPanel3.setLayout((LayoutManager) null);
        this.txtEdadIni.setFont(new Font("Arial", 1, 12));
        this.txtEdadIni.setEnabled(false);
        this.jPanel3.add(this.txtEdadIni);
        this.txtEdadIni.setBounds(10, 40, 60, 30);
        this.txtEdadFin.setFont(new Font("Arial", 1, 12));
        this.txtEdadFin.setEnabled(false);
        this.jPanel3.add(this.txtEdadFin);
        this.txtEdadFin.setBounds(80, 40, 60, 30);
        this.cboTipoEdad.setFont(new Font("Arial", 1, 12));
        this.cboTipoEdad.setModel(new DefaultComboBoxModel(new String[]{"Años", "Meses", "Días"}));
        this.cboTipoEdad.setEnabled(false);
        this.jPanel3.add(this.cboTipoEdad);
        this.cboTipoEdad.setBounds(150, 40, 70, 30);
        this.jLabel5.setFont(new Font("Arial", 1, 12));
        this.jLabel5.setForeground(Color.blue);
        this.jLabel5.setText("Inicial");
        this.jPanel3.add(this.jLabel5);
        this.jLabel5.setBounds(10, 20, 54, 14);
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(Color.blue);
        this.jLabel6.setText("Final");
        this.jPanel3.add(this.jLabel6);
        this.jLabel6.setBounds(80, 20, 60, 14);
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(Color.blue);
        this.jLabel4.setText("Tipo");
        this.jPanel3.add(this.jLabel4);
        this.jLabel4.setBounds(150, 20, 60, 14);
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 255));
        this.jLabel7.setText("Clase de Cita");
        this.cboClaseCita.setFont(new Font("Arial", 1, 12));
        this.cboClaseCita.setEnabled(false);
        this.JPEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JRBEstado1.setFont(new Font("Arial", 1, 12));
        this.JRBEstado1.setForeground(new Color(0, 0, 255));
        this.JRBEstado1.setSelected(true);
        this.JRBEstado1.setText("Telefonica");
        this.JRBEstado1.setEnabled(false);
        this.JRBEstado1.addActionListener(new ActionListener() { // from class: Informes.JIFInformes.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformes.this.JRBEstado1ActionPerformed(evt);
            }
        });
        this.JRBEstado2.setFont(new Font("Arial", 1, 12));
        this.JRBEstado2.setForeground(new Color(0, 0, 255));
        this.JRBEstado2.setText("Personal");
        this.JRBEstado2.setEnabled(false);
        this.JRBEstado2.addActionListener(new ActionListener() { // from class: Informes.JIFInformes.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformes.this.JRBEstado2ActionPerformed(evt);
            }
        });
        GroupLayout JPEstadoLayout = new GroupLayout(this.JPEstado);
        this.JPEstado.setLayout(JPEstadoLayout);
        JPEstadoLayout.setHorizontalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEstado1).addGap(18, 18, 18).addComponent(this.JRBEstado2).addContainerGap(18, 32767)));
        JPEstadoLayout.setVerticalGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEstadoLayout.createSequentialGroup().addGroup(JPEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEstado1).addComponent(this.JRBEstado2)).addContainerGap(-1, 32767)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setEnabled(false);
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setEnabled(false);
        this.btnExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.btnExportar.setText("Exportar");
        this.btnExportar.addActionListener(new ActionListener() { // from class: Informes.JIFInformes.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformes.this.btnExportarActionPerformed(evt);
            }
        });
        this.JSPCant.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSPCant.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPCant.setEnabled(false);
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(new Color(0, 0, 255));
        this.JCHFiltro.setText("Filtro");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Informes.JIFInformes.6
            public void mouseClicked(MouseEvent evt) {
                JIFInformes.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 136, -2).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboEspecialidad, 0, -1, 32767).addComponent(this.jLabel2, -2, 140, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 130, -2).addComponent(this.cboProfesional, -2, 420, -2)).addContainerGap(-1, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel3, -2, 140, -2).addComponent(this.cboProgramas, -2, 420, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel7, -2, 140, -2).addComponent(this.cboClaseCita, -2, 420, -2))).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JPEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCant, -2, 79, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addComponent(this.jPanel3, -2, 230, -2).addGap(25, 25, 25)).addGroup(jPanel2Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.btnInforme, -2, 341, -2).addGap(18, 18, 18).addComponent(this.JTFRuta, -1, 382, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.btnExportar, -2, 373, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(6, 6, 6).addComponent(this.cboProfesional, -2, 30, -2)).addComponent(this.JDFechaI, -1, 53, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboEspecialidad, -2, 30, -2)).addComponent(this.JDFechaF, -1, -1, 32767)).addGap(28, 28, 28).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel3).addGap(6, 6, 6).addComponent(this.cboProgramas, -2, 30, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(6, 6, 6).addComponent(this.cboClaseCita, -2, 30, -2))).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPCant).addComponent(this.JPEstado, -2, -1, -2).addComponent(this.JCHFiltro))).addComponent(this.jPanel3, -2, 80, -2)).addGap(8, 8, 8).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnInforme, -2, 50, -2).addComponent(this.btnExportar, -2, 58, -2).addComponent(this.JTFRuta, -2, 56, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.lblTitulo, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.lblTitulo, -2, 30, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEspecialidadActionPerformed(ActionEvent evt) {
        cargarComboClaseCita();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnInformeActionPerformed(ActionEvent evt) {
        generar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstado1ActionPerformed(ActionEvent evt) {
        this.xestado = "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstado2ActionPerformed(ActionEvent evt) {
        this.xestado = "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnExportarActionPerformed(ActionEvent evt) {
        String sql;
        Metodos metodos = new Metodos();
        if (this.xtitulo.equals("Usuarios por Programas")) {
            String sql2 = "SELECT g_usuario.NoHistoria, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2, g_persona.Edad, g_persona.Id_Sexo, g_persona.Direccion, g_persona.Telefono, f_empresacontxconvenio.Nbre  FROM baseserver.g_usuario INNER JOIN baseserver.g_persona  ON (g_usuario.Id_persona = g_persona.Id) INNER JOIN baseserver.f_empresacontxconvenio  ON (f_empresacontxconvenio.Id_EmpresaCont = g_usuario.Id_EmpresaCont) INNER JOIN baseserver.g_usuarioxprograma  ON (g_usuarioxprograma.Id_Usuario = g_usuario.Id_persona)  WHERE (g_usuarioxprograma.Id_Programa = '" + this.listaProgramas[this.cboProgramas.getSelectedIndex()] + "' AND g_usuarioxprograma.Estado =0 AND g_usuario.Estado =0) ORDER BY g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC ";
            mExportarUsuarioPorProgramaEdad(sql2);
            return;
        }
        if (this.xtitulo.equals("Usuarios por Programa por EPS por Edad")) {
            String sql3 = "SELECT g_usuario.NoHistoria, g_persona.Apellido1, g_persona.Apellido2, g_persona.Nombre1, g_persona.Nombre2, g_persona.Edad, g_persona.Id_Sexo, g_persona.Direccion, g_persona.Telefono, f_empresacontxconvenio.Nbre FROM baseserver.g_usuario INNER JOIN baseserver.g_persona ON (g_usuario.Id_persona = g_persona.Id)INNER JOIN baseserver.f_empresacontxconvenio ON (f_empresacontxconvenio.Id_EmpresaCont = g_usuario.Id_EmpresaCont)INNER JOIN baseserver.g_usuarioxprograma ON (g_usuarioxprograma.Id_Usuario = g_usuario.Id_persona) WHERE (g_persona.Edad >='" + this.txtEdadIni.getValue() + "' AND g_persona.Edad <= '" + this.txtEdadFin.getValue() + "' AND g_persona.Id_TipoEdad ='" + this.cboTipoEdad.getSelectedItem().toString() + "' AND g_usuarioxprograma.Id_Programa ='" + this.listaProgramas[this.cboProgramas.getSelectedIndex()] + "'AND g_usuarioxprograma.Estado =0 AND g_usuario.Estado =0) ORDER BY g_persona.Apellido1 ASC, g_persona.Apellido2 ASC, g_persona.Nombre1 ASC, g_persona.Nombre2 ASC ";
            mExportarUsuarioPorProgramaEdad(sql3);
            return;
        }
        if (this.xtitulo.equals("Consultadores Crónicos Por Especialidad")) {
            try {
                mCrearDatosCronicos();
                if (this.JCHFiltro.isSelected()) {
                    sql = "SELECT\n   h_atencion.Fecha_Atencion,\n       persona.`NoHistoria`,\n       CONCAT(gpersona.`Apellido1`,' ', gpersona.`Apellido2`,' ', gpersona.`Nombre1`,' ', gpersona.`Nombre2`) AS NUsuario,\n       gpersona.`Id_Sexo` NSexo,\n       gpersona.`Edad`,\n       g_tipoedad.`Nbre` AS NTipoEdad,\n       h_atencion.Codigo_Dxp,\n       g_patologia.Nbre AS NPatologia,        c_clasecita.Nbre AS ClaseCita,\n       CONCAT(profesionalN.`Apellido1`,' ', profesionalN.`Apellido2`,' ', profesionalN.`Nombre1`,' ', profesionalN.`Nombre2`) NProfesional,\n       r_consultadorescronicos.Cantidad,\n       f_empresacontxconvenio.Nbre AS Empresa, \n       g_especialidad.Nbre,  IFNULL(g_parentesco.`Nbre`,'') AS parentezco FROM\n    `baseserver`.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` \n        ON (`h_atencion`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`g_usuario` AS `persona`\n        ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` AS `gpersona`\n        ON (`persona`.`Id_persona` = `gpersona`.`Id`)\n    INNER JOIN g_tipoedad\n        ON (gpersona.`Id_TipoEdad` = g_tipoedad.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\n    INNER JOIN `baseserver`.`g_persona` AS `profesionalN` \n        ON (`profesionalN`.`Id` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`r_consultadorescronicos` \n        ON (`r_consultadorescronicos`.`N_Hc` = `persona`.`NoHistoria`)\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n   LEFT  JOIN `baseserver`.`g_usuario_fpz`\n         ON (gpersona.`Id` = g_usuario_fpz.`Id_Persona`)\n    LEFT JOIN g_parentesco\n       ON (g_usuario_fpz.`Id_Parentesco`=g_parentesco.`Id`)  WHERE (h_atencion.Fecha_Atencion >= '" + metodos.formatoAMD.format(this.JDFechaI.getDate()) + "'\n        AND h_atencion.Fecha_Atencion <= '" + metodos.formatoAMD.format(this.JDFechaF.getDate()) + "')\n       AND (h_atencion.Id_Especialidad = '" + this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "')\n       AND (h_atencion.Codigo_Dxp <> ' ')\n       AND (c_clasecita.Id <> 17)\n       AND (r_consultadorescronicos.Cantidad >= '" + this.JSPCant.getValue() + "')\nORDER BY r_consultadorescronicos.Cantidad DESC, CONCAT(gpersona.`Apellido1`,' ', gpersona.`Apellido2`,' ', gpersona.`Nombre1`,' ', gpersona.`Nombre2`) ASC, h_atencion.Fecha_Atencion ASC";
                } else {
                    sql = "SELECT\n   h_atencion.Fecha_Atencion,\n       persona.`NoHistoria`,\n       CONCAT(gpersona.`Apellido1`,' ', gpersona.`Apellido2`,' ', gpersona.`Nombre1`,' ', gpersona.`Nombre2`) AS NUsuario,\n       gpersona.`Id_Sexo` NSexo,\n       gpersona.`Edad`,\n       g_tipoedad.`Nbre` AS NTipoEdad,\n       h_atencion.Codigo_Dxp,\n       g_patologia.Nbre AS NPatologia,        c_clasecita.Nbre AS ClaseCita,\n       CONCAT(profesionalN.`Apellido1`,' ', profesionalN.`Apellido2`,' ', profesionalN.`Nombre1`,' ', profesionalN.`Nombre2`) NProfesional,\n       r_consultadorescronicos.Cantidad,\n       f_empresacontxconvenio.Nbre AS Empresa, \n       g_especialidad.Nbre,  IFNULL(g_parentesco.`Nbre`,'') AS parentezco FROM\n    `baseserver`.`g_ips`, \n    `baseserver`.`h_atencion`\n    INNER JOIN `baseserver`.`ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN `baseserver`.`c_clasecita` \n        ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`)\n    INNER JOIN `baseserver`.`g_profesional` \n        ON (`h_atencion`.`Id_Profesional` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`g_usuario` AS `persona`\n        ON (`ingreso`.`Id_Usuario` = `persona`.`Id_persona`)\n    INNER JOIN `baseserver`.`f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN `baseserver`.`g_persona` AS `gpersona`\n        ON (`persona`.`Id_persona` = `gpersona`.`Id`)\n    INNER JOIN g_tipoedad\n        ON (gpersona.`Id_TipoEdad` = g_tipoedad.`Id`)\n    INNER JOIN `baseserver`.`g_especialidad` \n        ON (`g_especialidad`.`Id` = `h_atencion`.`Id_Especialidad`)\n    INNER JOIN `baseserver`.`g_persona` AS `profesionalN` \n        ON (`profesionalN`.`Id` = `g_profesional`.`Id_Persona`)\n    INNER JOIN `baseserver`.`r_consultadorescronicos` \n        ON (`r_consultadorescronicos`.`N_Hc` = `persona`.`NoHistoria`)\n    INNER JOIN `baseserver`.`g_patologia` \n        ON (`g_patologia`.`Id` = `h_atencion`.`Codigo_Dxp`)\n   LEFT  JOIN `baseserver`.`g_usuario_fpz`\n         ON (gpersona.`Id` = g_usuario_fpz.`Id_Persona`)\n    LEFT JOIN g_parentesco\n       ON (g_usuario_fpz.`Id_Parentesco`=g_parentesco.`Id`)  WHERE (h_atencion.Fecha_Atencion >= '" + metodos.formatoAMD.format(this.JDFechaI.getDate()) + "'\n        AND h_atencion.Fecha_Atencion <= '" + metodos.formatoAMD.format(this.JDFechaF.getDate()) + "')\n       AND (h_atencion.Codigo_Dxp <> ' ')\n       AND (c_clasecita.Id <> 17)\n       AND (r_consultadorescronicos.Cantidad >= '" + this.JSPCant.getValue() + "')\nORDER BY r_consultadorescronicos.Cantidad DESC, CONCAT(gpersona.`Apellido1`,' ', gpersona.`Apellido2`,' ', gpersona.`Nombre1`,' ', gpersona.`Nombre2`) ASC, h_atencion.Fecha_Atencion ASC";
                }
                this.xmt.mExportar_Datos_Formato_Consulta(sql, this.JTFRuta.getText(), "USUARIOS CRONICOS");
                return;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        if (this.xtitulo.equals("Procedimientos Facturados x Empresa")) {
            String sql4 = " SELECT f_empresacontxconvenio.Nbre as Eps, g_procedimiento.Nbre as NProcedimiento, COUNT(f_itemordenesproced.Cantidad) as Cant, f_itemordenesproced.ValorUnitario, ((f_itemordenesproced.ValorUnitario*COUNT(f_itemordenesproced.Cantidad))+f_itemordenesproced.valorImpuesto) AS Total  FROM    (   (   (   (   baseserver.ingreso ingreso INNER JOIN baseserver.f_empresacontxconvenio f_empresacontxconvenio ON (ingreso.Id_EmpresaContxConv =  f_empresacontxconvenio.Id)) INNER JOIN baseserver.f_ordenes f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)) INNER JOIN baseserver.f_itemordenesproced f_itemordenesproced  ON (f_itemordenesproced.Id_Ordenes = f_ordenes.Id))  INNER JOIN baseserver.g_procedimiento g_procedimiento ON (f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)) INNER JOIN baseserver.persona persona ON (persona.Id_persona = ingreso.Id_Usuario) WHERE (ingreso.FechaIngreso >= '" + metodos.formatoAMD.format(this.JDFechaI.getDate()) + "'  AND ingreso.FechaIngreso <= '" + metodos.formatoAMD.format(this.JDFechaF.getDate()) + "') AND (f_ordenes.Estado = 0) AND (f_ordenes.Id_TipoServicio = '" + this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "') GROUP BY g_procedimiento.Nbre, f_empresacontxconvenio.Nbre  ORDER BY f_empresacontxconvenio.Nbre ASC, g_procedimiento.Nbre ASC ";
            mExportarProcedimientosxEmpresa(sql4);
        }
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

    private void mActivarComponentes(String titulo) {
        this.lblTitulo.setText(titulo.toUpperCase());
        if (titulo.equals("Usuarios por Programas")) {
            cargarCboProgramas();
            this.JRBEstado1.setEnabled(false);
            this.JRBEstado2.setEnabled(false);
            return;
        }
        if (titulo.equals("Usuarios por Programa por EPS por Edad")) {
            this.txtEdadIni.setEnabled(true);
            this.txtEdadFin.setEnabled(true);
            this.cboTipoEdad.setEnabled(true);
            this.JRBEstado1.setEnabled(false);
            this.JRBEstado2.setEnabled(false);
            cargarCboProgramas();
            return;
        }
        if (titulo.equals("Morbilidad x Tipo de Consulta")) {
            this.JDFechaI.setEnabled(true);
            this.JDFechaF.setEnabled(true);
            this.JSPCant.setEnabled(true);
            this.cboEspecialidad.setEnabled(true);
            cargarComboEspecialidad();
            cargarComboClaseCita();
            this.cboClaseCita.setEnabled(true);
            return;
        }
        if (titulo.equals("Consultadores Crónicos Por Especialidad")) {
            this.JDFechaI.setEnabled(true);
            this.JDFechaF.setEnabled(true);
            this.JSPCant.setEnabled(true);
            this.cboEspecialidad.setEnabled(true);
            cargarComboEspecialidad();
            return;
        }
        if (titulo.equals("Procedimientos Facturados x Empresa")) {
            this.jLabel2.setText("Servicios");
            this.JDFechaI.setEnabled(true);
            this.JDFechaF.setEnabled(true);
            this.cboProgramas.setEnabled(true);
            mcargarCboSerivicio();
            return;
        }
        if (titulo.equals("Consolidado de Información")) {
            this.JDFechaI.setEnabled(true);
            this.JDFechaF.setEnabled(true);
        }
    }

    private void cargarComboClaseCita() {
        if (this.cboLleno == 1 && this.cboEspecialidad.getSelectedIndex() > -1) {
            this.cboClaseCita.removeAllItems();
            ConsultasMySQL xmt = new ConsultasMySQL();
            this.listaClaseCita = xmt.llenarCombo("SELECT Id, nbre FROM baseserver.c_clasecita WHERE estado = 0  AND Id_Especialidad ='" + this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "' ORDER BY nbre ASC", this.listaClaseCita, this.cboClaseCita);
            this.cboLleno = 1;
            xmt.cerrarConexionBd();
        }
    }

    private void cargarComboEspecialidad() {
        this.cboEspecialidad.removeAllItems();
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.listaEspecialidad = xmt.llenarCombo("SELECT Id, nbre FROM baseserver.g_especialidad WHERE estado = 0 ORDER BY nbre ASC", this.listaEspecialidad, this.cboEspecialidad);
        this.cboLleno = 1;
        xmt.cerrarConexionBd();
    }

    private void cargarComboProfesional() {
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.listaProfesional = xmt.llenarCombo("SELECT Id_Persona, NProfesional FROM baseserver.profesional ORDER BY NProfesional ASC", this.listaProfesional, this.cboProfesional);
        this.cboLleno = 1;
        xmt.cerrarConexionBd();
    }

    private void cargarCboProgramas() {
        this.cboProgramas.removeAllItems();
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.listaProgramas = xmt.llenarCombo("SELECT Id_TipoPrograma, Nbre FROM baseserver.g_tipoprograma WHERE (Estado =0) ORDER BY Nbre ASC;", this.listaProgramas, this.cboProgramas);
        this.cboProgramas.setEnabled(true);
        this.cboLleno = 1;
        xmt.cerrarConexionBd();
    }

    private void mcargarCboSerivicio() {
        this.cboEspecialidad.removeAllItems();
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.listaEspecialidad = xmt.llenarCombo("SELECT Id, Nbre FROM baseserver.f_tiposervicio WHERE (Estado =0) ORDER BY Nbre ASC;", this.listaEspecialidad, this.cboEspecialidad);
        this.cboEspecialidad.setEnabled(true);
        this.cboLleno = 1;
        xmt.cerrarConexionBd();
    }

    private void generar() {
        if (this.xtitulo.equals("Usuarios por Programas")) {
            informeDeUsuariosPorPrograma();
            return;
        }
        if (this.xtitulo.equals("Usuarios por Programa por EPS por Edad")) {
            informeDeUsuariosPorProgramaPorEpsPorEdad();
            return;
        }
        if (this.xtitulo.equals("Consultadores Crónicos Por Especialidad")) {
            mInformeUsuariosCronicos();
            return;
        }
        if (this.xtitulo.equals("Procedimientos Facturados x Empresa")) {
            mInformeProcedimientosxEmpresa();
        } else if (this.xtitulo.equals("Consolidado de Información")) {
            mInformesNutricion();
        } else if (this.xtitulo.equals("Morbilidad x Tipo de Consulta")) {
            mInformeMorbiliadxTipoConsulta();
        }
    }

    private void mExportarUsuarioPorProgramaEdad(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 0, "PROGRAMA : " + this.cboProgramas.getSelectedItem().toString()));
                sheet.addCell(new Label(0, 1, "N° Historia"));
                sheet.addCell(new Label(1, 1, "Nombre Usuario"));
                sheet.addCell(new Label(2, 1, "Edad"));
                sheet.addCell(new Label(3, 1, "Sexo"));
                sheet.addCell(new Label(4, 1, "Dirección"));
                sheet.addCell(new Label(5, 1, "Teléfono"));
                sheet.addCell(new Label(6, 1, "EPS"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Number(0, x, rs.getLong(1)));
                        sheet.addCell(new Label(1, x, rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5)));
                        sheet.addCell(new Label(2, x, rs.getString(6)));
                        sheet.addCell(new Label(3, x, rs.getString(7)));
                        sheet.addCell(new Label(4, x, rs.getString(8)));
                        sheet.addCell(new Label(5, x, rs.getString(9)));
                        sheet.addCell(new Label(6, x, rs.getString(10)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                new SimpleDateFormat("yyyy/MM/dd");
                workbook.write();
                workbook.close();
            } catch (SQLException ex) {
                Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (WriteException e) {
                Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex2) {
                Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    private void mExportarUsuarioCronicos(String xsql) {
        if (mValidarEspecialidad()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, "USUARIOS CRONICOS"));
                    sheet.addCell(new Label(0, 1, "Fecha"));
                    sheet.addCell(new Label(1, 1, "N° Historia"));
                    sheet.addCell(new Label(2, 1, "Nombre"));
                    sheet.addCell(new Label(3, 1, "Sexo"));
                    sheet.addCell(new Label(4, 1, "Edad"));
                    sheet.addCell(new Label(5, 1, "Codigo Cie10"));
                    sheet.addCell(new Label(6, 1, "Nombre Patología"));
                    sheet.addCell(new Label(7, 1, "Clase de Cita"));
                    sheet.addCell(new Label(8, 1, "Cantidad"));
                    sheet.addCell(new Label(9, 1, "Nconsulta"));
                    sheet.addCell(new Label(10, 1, "Eps"));
                    sheet.addCell(new Label(11, 1, "Especialidad"));
                    sheet.addCell(new Label(12, 1, "Parentezco"));
                    ConsultasMySQL xt2 = new ConsultasMySQL();
                    ResultSet rs = xt2.traerRs(xsql);
                    if (rs.next()) {
                        rs.beforeFirst();
                        int x = 2;
                        while (rs.next()) {
                            sheet.addCell(new Label(0, x, rs.getString(1)));
                            sheet.addCell(new Label(1, x, rs.getString(2)));
                            sheet.addCell(new Label(2, x, rs.getString(3)));
                            sheet.addCell(new Label(3, x, rs.getString(4)));
                            sheet.addCell(new Label(4, x, rs.getString(5) + " " + rs.getString(6)));
                            sheet.addCell(new Label(5, x, rs.getString(7)));
                            sheet.addCell(new Label(6, x, rs.getString(8)));
                            sheet.addCell(new Label(7, x, rs.getString(9)));
                            sheet.addCell(new Label(8, x, rs.getString(10)));
                            sheet.addCell(new Label(9, x, rs.getString(11)));
                            sheet.addCell(new Label(10, x, rs.getString(12)));
                            sheet.addCell(new Label(11, x, rs.getString(13)));
                            sheet.addCell(new Label(12, x, rs.getString(14)));
                            x++;
                        }
                    }
                    rs.close();
                    xt2.cerrarConexionBd();
                    new SimpleDateFormat("yyyy/MM/dd");
                    workbook.write();
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (SQLException ex2) {
                    Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
        }
    }

    private void mExportarProcedimientosxEmpresa(String xsql) {
        if (mValidarEspecialidad()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                try {
                    Metodos metodos = new Metodos();
                    WritableWorkbook workbook = Workbook.createWorkbook(new File(this.JTFRuta.getText() + ".xls"));
                    WritableSheet sheet = workbook.createSheet("plantilla", 0);
                    sheet.addCell(new Label(0, 0, "PROCEDIMIENTOS REALIZADOS X EMPRESA DEL PERIODO " + metodos.formatoDMA.format(this.JDFechaI.getDate()) + "  Al  " + metodos.formatoDMA.format(this.JDFechaF.getDate())));
                    sheet.addCell(new Label(0, 1, "Empresa"));
                    sheet.addCell(new Label(1, 1, "Nombre del Procedimiento"));
                    sheet.addCell(new Label(2, 1, "Cantidad"));
                    sheet.addCell(new Label(3, 1, "V/Unitario"));
                    sheet.addCell(new Label(4, 1, "V/Total"));
                    ConsultasMySQL xt2 = new ConsultasMySQL();
                    ResultSet rs = xt2.traerRs(xsql);
                    if (rs.next()) {
                        rs.beforeFirst();
                        int x = 2;
                        while (rs.next()) {
                            sheet.addCell(new Label(0, x, rs.getString(1)));
                            sheet.addCell(new Label(1, x, rs.getString(2)));
                            sheet.addCell(new Number(2, x, rs.getLong(3)));
                            sheet.addCell(new Number(3, x, rs.getDouble(4)));
                            sheet.addCell(new Number(4, x, rs.getDouble(5)));
                            x++;
                        }
                    }
                    rs.close();
                    xt2.cerrarConexionBd();
                    workbook.write();
                    workbook.close();
                } catch (SQLException ex) {
                    Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                } catch (WriteException e) {
                    Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, e);
                } catch (IOException ex2) {
                    Logger.getLogger(JIFInformes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
                }
            }
        }
    }

    private void informeDeUsuariosPorPrograma() {
        Metodos metodos = new Metodos();
        if (this.cboProgramas.getSelectedIndex() != -1) {
            String[][] parametros = new String[4][2];
            parametros[0][0] = "idPrograma";
            parametros[0][1] = this.listaProgramas[this.cboProgramas.getSelectedIndex()];
            parametros[1][0] = "nbrePrograma";
            parametros[1][1] = this.cboProgramas.getSelectedItem().toString();
            parametros[2][0] = "SUBREPORT_DIR";
            parametros[2][1] = metodos.getSO() + metodos.getBarra() + "Reportes" + metodos.getBarra();
            parametros[3][0] = "SUBREPORTFIRMA_DIR";
            parametros[3][1] = metodos.getSO() + metodos.getBarra() + "Firmas" + metodos.getBarra();
            metodos.GenerarPDF(metodos.getRutaRep() + "P_ListadoDeUsuariosPorPrograma", parametros);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un progama", "VERIFICAR", 0);
        this.cboProgramas.requestFocus();
    }

    private void informeDeUsuariosPorProgramaPorEpsPorEdad() {
        Metodos metodos = new Metodos();
        String[][] parametros = new String[8][2];
        parametros[0][0] = "idPrograma";
        parametros[0][1] = this.listaProgramas[this.cboProgramas.getSelectedIndex()];
        parametros[1][0] = "nbrePrograma";
        parametros[1][1] = this.cboProgramas.getSelectedItem().toString();
        parametros[2][0] = "edadIni";
        parametros[2][1] = this.txtEdadIni.getValue().toString();
        parametros[3][0] = "edadFin";
        parametros[3][1] = this.txtEdadFin.getValue().toString();
        parametros[4][0] = "tipoEdad";
        parametros[4][1] = String.valueOf(this.cboTipoEdad.getSelectedIndex() + 1);
        parametros[5][0] = "nbreTipoEdad";
        parametros[5][1] = this.cboTipoEdad.getSelectedItem().toString();
        parametros[6][0] = "SUBREPORT_DIR";
        parametros[6][1] = metodos.getSO() + metodos.getBarra() + "Reportes" + metodos.getBarra();
        parametros[7][0] = "SUBREPORTFIRMA_DIR";
        parametros[7][1] = metodos.getSO() + metodos.getBarra() + "Firmas" + metodos.getBarra();
        metodos.GenerarPDF(metodos.getRutaRep() + "P_ListadoDeUsuariosPorProgramaPorEpsPorEdad", parametros);
    }

    /* JADX INFO: renamed from: informeConsolidadoNutrición, reason: contains not printable characters */
    private void m32informeConsolidadoNutricin() {
        Metodos metodos = new Metodos();
        String[][] parametros = new String[4][2];
        parametros[0][0] = "Periodo";
        parametros[0][1] = "Del " + metodos.formatoDMA.format(this.JDFechaI.getDate()) + " al  " + metodos.formatoDMA.format(this.JDFechaF.getDate());
        parametros[1][0] = "usuarios";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = metodos.getSO() + metodos.getBarra() + "Reportes" + metodos.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = metodos.getSO() + metodos.getBarra() + "Firmas" + metodos.getBarra();
        metodos.GenerarPDF(metodos.getRutaRep() + "H_InformacionNutricion", parametros);
    }

    private void mInformeMorbiliadxTipoConsulta() {
        Metodos metodos = new Metodos();
        String[][] parametros = new String[9][2];
        parametros[0][0] = "periodo";
        parametros[0][1] = "Del " + metodos.formatoDMA.format(this.JDFechaI.getDate()) + " al  " + metodos.formatoDMA.format(this.JDFechaF.getDate());
        parametros[1][0] = "usuarios";
        parametros[1][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[2][0] = "fechai";
        parametros[2][1] = metodos.formatoAMD.format(this.JDFechaI.getDate());
        parametros[3][0] = "fechaf";
        parametros[3][1] = metodos.formatoAMD.format(this.JDFechaF.getDate());
        parametros[4][0] = "numero";
        parametros[4][1] = this.JSPCant.getValue().toString();
        parametros[5][0] = "tipocita";
        parametros[5][1] = this.listaClaseCita[this.cboClaseCita.getSelectedIndex()];
        parametros[6][0] = "especialidad";
        parametros[6][1] = this.cboEspecialidad.getSelectedItem().toString();
        parametros[7][0] = "SUBREPORT_DIR";
        parametros[7][1] = metodos.getSO() + metodos.getBarra() + "Reportes" + metodos.getBarra();
        parametros[8][0] = "SUBREPORTFIRMA_DIR";
        parametros[8][1] = metodos.getSO() + metodos.getBarra() + "Firmas" + metodos.getBarra();
        metodos.GenerarPDF(metodos.getRutaRep() + "E_MorbilidadxTipodeConsulta", parametros);
    }

    private void mCrearDatosCronicos() {
        String sql;
        ConsultasMySQL xmt = new ConsultasMySQL();
        Metodos metodos = new Metodos();
        xmt.ejecutarSQL("DELETE FROM r_consultadorescronicos ");
        xmt.cerrarConexionBd();
        if (this.JCHFiltro.isSelected()) {
            sql = " INSERT INTO r_consultadorescronicos (N_Hc,Cantidad) SELECT persona.NoHistoria, COUNT(h_atencion.Codigo_Dxp) AS Cant FROM (baseserver.ingreso ingreso INNER JOIN baseserver.persona persona ON (ingreso.Id_Usuario = persona.Id_persona)) INNER JOIN baseserver.h_atencion h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (h_atencion.Codigo_Dxp <> ' ') AND (h_atencion.Id_Especialidad ='" + this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()] + "') AND (h_atencion.Fecha_Atencion >='" + metodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <= '" + metodos.formatoAMD.format(this.JDFechaF.getDate()) + "') AND (h_atencion.Id_ClaseCita <> 17) GROUP BY persona.NoHistoria ORDER BY 2 desc";
        } else {
            sql = " INSERT INTO r_consultadorescronicos (N_Hc,Cantidad) SELECT persona.NoHistoria, COUNT(h_atencion.Codigo_Dxp) AS Cant FROM (baseserver.ingreso ingreso INNER JOIN baseserver.persona persona ON (ingreso.Id_Usuario = persona.Id_persona)) INNER JOIN baseserver.h_atencion h_atencion ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (h_atencion.Codigo_Dxp <> ' ')  AND (h_atencion.Fecha_Atencion >='" + metodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND h_atencion.Fecha_Atencion <= '" + metodos.formatoAMD.format(this.JDFechaF.getDate()) + "') AND (h_atencion.Id_ClaseCita <> 17) GROUP BY persona.NoHistoria ORDER BY 2 desc";
        }
        xmt.ejecutarSQL(sql);
        xmt.cerrarConexionBd();
    }

    private void mInformeUsuariosCronicos() {
        if (mValidarEspecialidad()) {
            mCrearDatosCronicos();
            Metodos metodos = new Metodos();
            String[][] parametros = new String[7][2];
            parametros[0][0] = "fechai";
            parametros[0][1] = metodos.formatoAMD.format(this.JDFechaI.getDate());
            parametros[1][0] = "fechaf";
            parametros[1][1] = metodos.formatoAMD.format(this.JDFechaF.getDate());
            parametros[2][0] = "especialidad";
            parametros[2][1] = this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()];
            parametros[3][0] = "cantidad";
            parametros[3][1] = this.JSPCant.getValue().toString();
            parametros[4][0] = "tfecha";
            parametros[4][1] = "PERIODO DEL  " + metodos.formatoDMA.format(this.JDFechaI.getDate()) + "  Al  " + metodos.formatoDMA.format(this.JDFechaF.getDate());
            parametros[5][0] = "SUBREPORT_DIR";
            parametros[5][1] = metodos.getSO() + metodos.getBarra() + "Reportes" + metodos.getBarra();
            parametros[6][0] = "SUBREPORTFIRMA_DIR";
            parametros[6][1] = metodos.getSO() + metodos.getBarra() + "Firmas" + metodos.getBarra();
            metodos.GenerarPDF(metodos.getRutaRep() + "C_ConsultadoresCronicos", parametros);
        }
    }

    private void mInformeProcedimientosxEmpresa() {
        if (mValidarEspecialidad()) {
            Metodos metodos = new Metodos();
            String[][] parametros = new String[6][2];
            parametros[0][0] = "fechai";
            parametros[0][1] = metodos.formatoAMD.format(this.JDFechaI.getDate());
            parametros[1][0] = "fechaf";
            parametros[1][1] = metodos.formatoAMD.format(this.JDFechaF.getDate());
            parametros[2][0] = "idservicio";
            parametros[2][1] = this.listaEspecialidad[this.cboEspecialidad.getSelectedIndex()];
            parametros[3][0] = "tfecha";
            parametros[3][1] = "PERIODO DEL  " + metodos.formatoDMA.format(this.JDFechaI.getDate()) + "  Al  " + metodos.formatoDMA.format(this.JDFechaF.getDate());
            parametros[4][0] = "SUBREPORT_DIR";
            parametros[4][1] = metodos.getSO() + metodos.getBarra() + "Reportes" + metodos.getBarra();
            parametros[5][0] = "SUBREPORTFIRMA_DIR";
            parametros[5][1] = metodos.getSO() + metodos.getBarra() + "Firmas" + metodos.getBarra();
            metodos.GenerarPDF(metodos.getRutaRep() + "F_ProcedimientosFacxEmpresaServicio", parametros);
        }
    }

    private void mInformesNutricion() {
        Metodos metodos = new Metodos();
        ConsultasMySQL xmt = new ConsultasMySQL();
        xmt.ejecutarSQL("DROP VIEW IF EXISTS e_nutricion  ");
        xmt.cerrarConexionBd();
        String sql = "SELECT h_tipoestadonutricional.Nbre as NEstadoNutricional, `g_persona`.`Id` AS Id_persona, CONCAT(`g_persona`.`Apellido1`,' ', g_persona.`Apellido2`,' ',g_persona.`Nombre1`,' ', g_persona.`Nombre2`)  AS `NUsuario`, `g_persona`.`Id_Sexo` AS `NSexo`  , g_tipoafiliado.Nbre as NtipoAfiliacion, `g_usuario`.`NoHistoria` , g_usuario_fpz.Id_Parentesco, g_parentesco.Nbre as NParentesco, h_nutricional.CCintura, g_sedes.`Nbre`  AS Sede   FROM baseserver.h_nutricional INNER JOIN baseserver.h_tipoestadonutricional  ON (h_nutricional.Id_tipoestadonutricional = h_tipoestadonutricional.Id) INNER JOIN baseserver.h_atencion ON (h_nutricional.Id_Atencion = h_atencion.Id)  INNER JOIN baseserver.ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) INNER JOIN baseserver.g_persona ON (`g_persona`.`Id` = ingreso.Id_Usuario)INNER JOIN baseserver.g_usuario ON (ingreso.Id_Usuario = g_usuario.Id_persona)INNER JOIN baseserver.g_tipoafiliado  ON (g_usuario.Id_TipoAfiliado = g_tipoafiliado.Id) INNER JOIN baseserver.g_usuario_fpz  ON (g_usuario.Id_persona = g_usuario_fpz.Id_Persona) INNER JOIN baseserver.g_parentesco  ON (g_parentesco.Id = g_usuario_fpz.Id_Parentesco) INNER JOIN `baseserver`.`g_sedes`  ON (`ingreso`.`Id_Sede` = `g_sedes`.`Id`)  WHERE (ingreso.FechaIngreso >='" + metodos.formatoAMD.format(this.JDFechaI.getDate()) + "' AND ingreso.FechaIngreso <='" + metodos.formatoAMD.format(this.JDFechaF.getDate()) + "') GROUP BY ingreso.Id_Usuario ";
        String sqlw = "CREATE VIEW e_nutricion AS " + sql;
        xmt.ejecutarSQL(sqlw);
        xmt.cerrarConexionBd();
        m32informeConsolidadoNutricin();
    }

    private boolean mValidarEspecialidad() {
        boolean estado = false;
        if (this.cboEspecialidad.getSelectedIndex() != -1) {
            estado = true;
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la especialidad", "VERIFICAR", 0);
            this.cboEspecialidad.requestFocus();
        }
        return estado;
    }
}
