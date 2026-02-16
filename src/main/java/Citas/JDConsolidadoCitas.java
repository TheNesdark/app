package Citas;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Citas/JDConsolidadoCitas.class */
public class JDConsolidadoCitas extends JDialog {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloA;
    private DefaultTableModel xmodeloNA;
    private Object[] xdatos;
    private CitasGral xcitas;
    private JButton JBBuscarDatos;
    private JButton JBTExportar;
    private JCheckBox JCHEspecialidad;
    public JDateChooser JDFechaFin;
    public JDateChooser JDFechaInicio;
    private JPanel JPFechas;
    private JPanel JPIConsolidado;
    private JPanel JPIDetalleAtendidas;
    private JPanel JPIDetalleNoAtendidas;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleA;
    private JScrollPane JSPDetalleNA;
    private JTable JTDetalle;
    private JTable JTDetalleA;
    private JTable JTDetalleNA;
    private JTextField JTFRuta;
    private JTextField JTFTotal;
    private JTextField JTFTotalA;
    private JTextField JTFTotalNA;
    private JTabbedPane JTPDatosC;

    public JDConsolidadoCitas(CitasGral xcitas) {
        initComponents();
        this.xcitas = xcitas;
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setTitle("CONSOLIDADO DE CITAS POR ESPECIALIDAD");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.JDFechaInicio.setDate(this.xmt.getFechaActual());
        this.JDFechaFin.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTFTotal = new JTextField();
        this.JTPDatosC = new JTabbedPane();
        this.JPIConsolidado = new JPanel();
        this.JPFechas = new JPanel();
        this.JDFechaInicio = new JDateChooser();
        this.JDFechaFin = new JDateChooser();
        this.JBBuscarDatos = new JButton();
        this.JCHEspecialidad = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPIDetalleAtendidas = new JPanel();
        this.JSPDetalleA = new JScrollPane();
        this.JTDetalleA = new JTable();
        this.JTFTotalA = new JTextField();
        this.JPIDetalleNoAtendidas = new JPanel();
        this.JSPDetalleNA = new JScrollPane();
        this.JTDetalleNA = new JTable();
        this.JTFTotalNA = new JTextField();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setDefaultCloseOperation(2);
        addKeyListener(new KeyAdapter() { // from class: Citas.JDConsolidadoCitas.1
            public void keyPressed(KeyEvent evt) {
                JDConsolidadoCitas.this.formKeyPressed(evt);
            }
        });
        this.JTFTotal.setFont(new Font("Arial", 1, 14));
        this.JTFTotal.setHorizontalAlignment(4);
        this.JTFTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDatosC.setForeground(new Color(0, 103, 0));
        this.JTPDatosC.setFont(new Font("Arial", 1, 14));
        this.JPFechas.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaInicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaInicio.setDateFormatString("dd/MM/yyyy");
        this.JDFechaInicio.setFont(new Font("Arial", 1, 12));
        this.JDFechaFin.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Fin", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFin.setDateFormatString("dd/MM/yyyy");
        this.JDFechaFin.setFont(new Font("Arial", 1, 12));
        this.JBBuscarDatos.setFont(new Font("Arial", 1, 12));
        this.JBBuscarDatos.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Buscar.png")));
        this.JBBuscarDatos.setText("Buscar");
        this.JBBuscarDatos.addActionListener(new ActionListener() { // from class: Citas.JDConsolidadoCitas.2
            public void actionPerformed(ActionEvent evt) {
                JDConsolidadoCitas.this.JBBuscarDatosActionPerformed(evt);
            }
        });
        this.JCHEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCHEspecialidad.setText("Especialidad?");
        GroupLayout JPFechasLayout = new GroupLayout(this.JPFechas);
        this.JPFechas.setLayout(JPFechasLayout);
        JPFechasLayout.setHorizontalGroup(JPFechasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFechasLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaInicio, -2, 107, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaFin, -2, 107, -2).addGap(18, 18, 18).addComponent(this.JCHEspecialidad, -1, 449, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBBuscarDatos).addGap(24, 24, 24)));
        JPFechasLayout.setVerticalGroup(JPFechasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFechasLayout.createSequentialGroup().addGroup(JPFechasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFechasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaInicio, -2, 53, -2).addComponent(this.JDFechaFin, -2, 53, -2)).addGroup(JPFechasLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JCHEspecialidad)).addComponent(this.JBBuscarDatos, -2, 47, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout JPIConsolidadoLayout = new GroupLayout(this.JPIConsolidado);
        this.JPIConsolidado.setLayout(JPIConsolidadoLayout);
        JPIConsolidadoLayout.setHorizontalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFechas, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        JPIConsolidadoLayout.setVerticalGroup(JPIConsolidadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConsolidadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPFechas, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 244, 32767).addContainerGap()));
        this.JTPDatosC.addTab("CONSOLIDADO", this.JPIConsolidado);
        this.JSPDetalleA.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleA.setFont(new Font("Arial", 1, 12));
        this.JTDetalleA.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleA.setRowHeight(25);
        this.JTDetalleA.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleA.setSelectionForeground(Color.red);
        this.JSPDetalleA.setViewportView(this.JTDetalleA);
        this.JTFTotalA.setFont(new Font("Arial", 1, 14));
        this.JTFTotalA.setHorizontalAlignment(4);
        this.JTFTotalA.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDetalleAtendidasLayout = new GroupLayout(this.JPIDetalleAtendidas);
        this.JPIDetalleAtendidas.setLayout(JPIDetalleAtendidasLayout);
        JPIDetalleAtendidasLayout.setHorizontalGroup(JPIDetalleAtendidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleAtendidasLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleAtendidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleA, GroupLayout.Alignment.TRAILING, -1, 833, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleAtendidasLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFTotalA, -2, 160, -2))).addContainerGap()));
        JPIDetalleAtendidasLayout.setVerticalGroup(JPIDetalleAtendidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleAtendidasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleA, -1, 282, 32767).addGap(18, 18, 18).addComponent(this.JTFTotalA, -2, 40, -2).addContainerGap()));
        this.JTPDatosC.addTab("ATENDIDAS", this.JPIDetalleAtendidas);
        this.JSPDetalleNA.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalleNA.setFont(new Font("Arial", 1, 12));
        this.JTDetalleNA.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleNA.setRowHeight(25);
        this.JTDetalleNA.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleNA.setSelectionForeground(Color.red);
        this.JSPDetalleNA.setViewportView(this.JTDetalleNA);
        this.JTFTotalNA.setFont(new Font("Arial", 1, 14));
        this.JTFTotalNA.setHorizontalAlignment(4);
        this.JTFTotalNA.setBorder(BorderFactory.createTitledBorder((Border) null, "Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDetalleNoAtendidasLayout = new GroupLayout(this.JPIDetalleNoAtendidas);
        this.JPIDetalleNoAtendidas.setLayout(JPIDetalleNoAtendidasLayout);
        JPIDetalleNoAtendidasLayout.setHorizontalGroup(JPIDetalleNoAtendidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleNoAtendidasLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleNoAtendidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleNA, GroupLayout.Alignment.TRAILING, -1, 833, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleNoAtendidasLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFTotalNA, -2, 160, -2))).addContainerGap()));
        JPIDetalleNoAtendidasLayout.setVerticalGroup(JPIDetalleNoAtendidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleNoAtendidasLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleNA, -1, 282, 32767).addGap(18, 18, 18).addComponent(this.JTFTotalNA, -2, 40, -2).addContainerGap()));
        this.JTPDatosC.addTab("NO ATENDIDAS - DESISTIDAS", this.JPIDetalleNoAtendidas);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Citas.JDConsolidadoCitas.3
            public void mouseClicked(MouseEvent evt) {
                JDConsolidadoCitas.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Citas.JDConsolidadoCitas.4
            public void actionPerformed(ActionEvent evt) {
                JDConsolidadoCitas.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosC).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 145, -2).addGap(236, 236, 236).addComponent(this.JTFTotal, -2, 165, -2).addGap(15, 15, 15))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosC).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JTFTotal, -2, 40, -2))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBBuscarDatosActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
        mCargarDatosTablaAsistidas();
        mCargarDatosTablaNaAsistidas();
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
            switch (this.JTPDatosC.getSelectedIndex()) {
                case 0:
                    if (this.JTDetalle.getRowCount() != -1) {
                        int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(0));
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                    break;
                case 1:
                    if (this.JTDetalleA.getRowCount() != -1) {
                        int n2 = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n2 == 0) {
                            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleA, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(1));
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                    break;
                case 2:
                    if (this.JTDetalleNA.getRowCount() != -1) {
                        int n3 = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n3 == 0) {
                            this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleNA, this.JTFRuta.getText(), getTitle() + ": " + this.JTPDatosC.getTitleAt(2));
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No existe información para exportar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                    break;
            }
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 27) {
            dispose();
        }
    }

    private void mCargarDatosTabla() {
        String sql;
        try {
            mCrearModeloDatos();
            int total = 0;
            if (this.JCHEspecialidad.isSelected()) {
                sql = "SELECT f_empresacontxconvenio.`Nbre`,COUNT(distinct(`c_citas`.`Id`)) as cantidad  FROM  c_citas INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id)  INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN w_persona  ON (c_citas.Id_Usuario = w_persona.Id_persona) INNER JOIN g_usuario ON (w_persona.Id_persona = g_usuario.Id_persona) WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaInicio.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaFin.getDate()) + "'   AND c_citas.Id_MotivoDesistida =1 AND c_citas.Id_Especialidad ='" + this.xcitas.idEspecialidad + "')  GROUP BY f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC";
            } else {
                sql = "SELECT f_empresacontxconvenio.`Nbre`,COUNT(distinct(`c_citas`.`Id`)) as cantidad  FROM  c_citas INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id)  INNER JOIN `f_empresacontxconvenio` ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN w_persona  ON (c_citas.Id_Usuario = w_persona.Id_persona) INNER JOIN g_usuario ON (w_persona.Id_persona = g_usuario.Id_persona) WHERE (c_citas.Fecha_Cita >='" + this.xmt.formatoAMD.format(this.JDFechaInicio.getDate()) + "' AND c_citas.Fecha_Cita <='" + this.xmt.formatoAMD.format(this.JDFechaFin.getDate()) + "'   AND c_citas.Id_MotivoDesistida =1 AND c_citas.Id_Especialidad ='" + this.xcitas.idEspecialidad + "' and  c_citas.`Id_Profesional`='" + this.xcitas.listaProfesional[this.xcitas.filaArbol][0] + "')  GROUP BY f_empresacontxconvenio.`Id` ORDER BY f_empresacontxconvenio.`Nbre` ASC";
            }
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(2)), n, 1);
                    n++;
                    total += xrs.getInt(2);
                }
            }
            this.JTFTotal.setText(String.valueOf(total));
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDConsolidadoCitas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaAsistidas() {
        String sql;
        try {
            mCrearModeloDatosAtendidas();
            int total = 0;
            if (this.JCHEspecialidad.isSelected()) {
                sql = "SELECT DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y') AS Fecha, `f_empresacontxconvenio`.`Nbre`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`,`persona`.`NMunicipio` , `persona`.`NBarrio`, `persona`.`Direccion`, `persona`.`Telefono`, c_clasecita.Nbre AS ClaseCita  FROM  `c_citas` INNER JOIN  `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `baseserver`.`persona`  ON (`persona`.`Id_persona` = `c_citas`.`Id_Usuario`) INNER JOIN `baseserver`.`c_clasecita`  ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`) WHERE (`c_citas`.`Id_MotivoDesistida` =1 AND `c_citas`.`Asistida` >0 AND `c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaInicio.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaFin.getDate()) + "'  AND  `c_citas`.`Id_Especialidad` ='" + this.xcitas.idEspecialidad + "') ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, `c_citas`.`Fecha_Cita` ASC, `persona`.`NoHistoria` ASC ";
            } else {
                sql = "SELECT DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y') AS Fecha, `f_empresacontxconvenio`.`Nbre`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, `persona`.`NMunicipio` , `persona`.`NBarrio`, `persona`.`Direccion`, `persona`.`Telefono`, c_clasecita.Nbre AS ClaseCita  FROM  `c_citas` INNER JOIN  `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `baseserver`.`persona`  ON (`persona`.`Id_persona` = `c_citas`.`Id_Usuario`) INNER JOIN `baseserver`.`c_clasecita`  ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`) WHERE (`c_citas`.`Id_MotivoDesistida` =1 AND `c_citas`.`Asistida` >0 AND `c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaInicio.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaFin.getDate()) + "'  AND `c_citas`.`Id_Profesional` ='" + this.xcitas.listaProfesional[this.xcitas.filaArbol][0] + "' AND `c_citas`.`Id_Especialidad` ='" + this.xcitas.idEspecialidad + "') ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, `c_citas`.`Fecha_Cita` ASC, `persona`.`NoHistoria` ASC ";
            }
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloA.addRow(this.xdatos);
                    this.xmodeloA.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloA.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloA.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloA.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloA.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloA.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloA.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloA.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloA.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloA.setValueAt(xrs.getString("ClaseCita"), n, 9);
                    n++;
                    total++;
                }
            }
            this.JTFTotalA.setText(String.valueOf(total));
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDConsolidadoCitas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaNaAsistidas() {
        String sql;
        try {
            mCrearModeloDatosNAtendidas();
            int total = 0;
            if (this.JCHEspecialidad.isSelected()) {
                sql = "SELECT DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y') AS Fecha, `f_empresacontxconvenio`.`Nbre`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`,`persona`.`NMunicipio` , `persona`.`NBarrio`, `persona`.`Direccion`, `persona`.`Telefono`,IF(`c_citas`.`Id_MotivoDesistida` >1,'DESISTIDA', 'NO ATENDIDA') AS Tipo, c_clasecita.Nbre AS ClaseCita  FROM  `c_citas` INNER JOIN  `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `baseserver`.`persona`  ON (`persona`.`Id_persona` = `c_citas`.`Id_Usuario`) INNER JOIN `baseserver`.`c_clasecita`  ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`) WHERE (`c_citas`.`Asistida` =0 AND `c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaInicio.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaFin.getDate()) + "'  AND  `c_citas`.`Id_Especialidad` ='" + this.xcitas.idEspecialidad + "') ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, `c_citas`.`Fecha_Cita` ASC, `persona`.`NoHistoria` ASC ";
            } else {
                sql = "SELECT DATE_FORMAT(`c_citas`.`Fecha_Cita`,'%d-%m-%Y') AS Fecha, `f_empresacontxconvenio`.`Nbre`, `persona`.`NoHistoria`, `persona`.`NUsuario`, `persona`.`IdSexo`, `persona`.`NMunicipio` , `persona`.`NBarrio`, `persona`.`Direccion`, `persona`.`Telefono`,IF(`c_citas`.`Id_MotivoDesistida` >1,'DESISTIDA', 'NO ATENDIDA') AS Tipo, c_clasecita.Nbre AS ClaseCita FROM  `c_citas` INNER JOIN  `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `c_citas`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `c_citas`.`Id_Especialidad`) INNER JOIN `baseserver`.`persona`  ON (`persona`.`Id_persona` = `c_citas`.`Id_Usuario`) INNER JOIN `baseserver`.`c_clasecita`  ON (`c_clasecita`.`Id` = `c_citas`.`Id_ClaseCita`) WHERE ( `c_citas`.`Asistida` =0 AND `c_citas`.`Fecha_Cita` >='" + this.xmt.formatoAMD.format(this.JDFechaInicio.getDate()) + "' AND `c_citas`.`Fecha_Cita` <='" + this.xmt.formatoAMD.format(this.JDFechaFin.getDate()) + "'  AND `c_citas`.`Id_Profesional` ='" + this.xcitas.listaProfesional[this.xcitas.filaArbol][0] + "' AND `c_citas`.`Id_Especialidad` ='" + this.xcitas.idEspecialidad + "') ORDER BY `f_empresacontxconvenio`.`Nbre` ASC, `c_citas`.`Fecha_Cita` ASC, `persona`.`NoHistoria` ASC ";
            }
            ResultSet xrs = this.consultas.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloNA.addRow(this.xdatos);
                    this.xmodeloNA.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloNA.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloNA.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloNA.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloNA.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloNA.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloNA.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloNA.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloNA.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloNA.setValueAt(xrs.getString(10), n, 9);
                    this.xmodeloNA.setValueAt(xrs.getString("ClaseCita"), n, 10);
                    n++;
                    total++;
                }
            }
            this.JTFTotalNA.setText(String.valueOf(total));
            xrs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDConsolidadoCitas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Empresa", "Cantidad Citas"}) { // from class: Citas.JDConsolidadoCitas.5
            Class[] types = {String.class, Integer.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosAtendidas() {
        this.xmodeloA = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Empresa", "N° HC", "Usuario", "Sexo", "Municipio", "Barrio", "Dirección", "Teléfono", "Clase de Cita"}) { // from class: Citas.JDConsolidadoCitas.6
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleA;
        JTable jTable2 = this.JTDetalleA;
        jTable.setAutoResizeMode(0);
        this.JTDetalleA.doLayout();
        this.JTDetalleA.setModel(this.xmodeloA);
        this.JTDetalleA.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalleA.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleA.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalleA.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleA.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleA.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalleA.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalleA.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleA.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleA.getColumnModel().getColumn(9).setPreferredWidth(300);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosNAtendidas() {
        this.xmodeloNA = new DefaultTableModel(new Object[0], new String[]{"Fecha", "Empresa", "N° HC", "Usuario", "Sexo", "Municipio", "Barrio", "Dirección", "Teléfono", "Tipo", "Clase de Cita"}) { // from class: Citas.JDConsolidadoCitas.7
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleNA;
        JTable jTable2 = this.JTDetalleNA;
        jTable.setAutoResizeMode(0);
        this.JTDetalleNA.doLayout();
        this.JTDetalleNA.setModel(this.xmodeloNA);
        this.JTDetalleNA.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalleNA.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleNA.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalleNA.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleNA.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalleNA.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalleNA.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalleNA.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleNA.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleNA.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleNA.getColumnModel().getColumn(10).setPreferredWidth(300);
    }
}
