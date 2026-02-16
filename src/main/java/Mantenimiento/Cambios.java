package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/Cambios.class */
public class Cambios extends JInternalFrame {
    private String[][] xidpersona;
    private String[][] xidjefe;
    private String[][] xidprocedimiento;
    private File xfile;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelocomponente;
    public DefaultTableModel xmodelonormalidad;
    public DefaultTableModel xmodelomanual;
    public DefaultTableModel xmodeloproce;
    public DefaultTableModel xmodelocalibra;
    public DefaultTableModel xmodelorepuesto;
    public DefaultTableModel xmodeloregistrotecnico;
    public Object[] dato;
    public Object[] datocomponente;
    public Object[] datosnormalidad;
    public Object[] datosmanual;
    public Object[] datosproce;
    public Object[] datoscalibra;
    public Object[] datosrepuesto;
    public Object[] datoscomponente;
    public Object[] datosregistrotecnico;
    public String sql;
    public String sqlnormalidad;
    public String sqlmanual;
    public String sqlproce;
    public String sqlcalibra;
    public String sqlrepuesto;
    public String sqlcomponente;
    public String sqlregistrotecnico;
    public String ruta;
    public String dato1;
    public String dato2;
    public String sql1;
    public String sql2;
    public String util;
    public Integer edad;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox combojefe;
    private JComboBox combopersona;
    private JComboBox combotipo;
    private JDateChooser fecharegistro;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JScrollPane jScrollPane12;
    private JScrollPane jScrollPane13;
    private JScrollPane jScrollPane14;
    private JTextArea justi;
    private JTextArea txtdes;
    private JTextArea txtmod;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta5 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta6 = new ConsultasMySQL();
    private ConsultasMySQL xconsulta7 = new ConsultasMySQL();
    public boolean lleno = false;
    private Metodos xmetodo = new Metodos();

    public Cambios() {
        initComponents();
        this.fecharegistro.setDate(this.metodos.getFechaActual());
        this.sql1 = "SELECT g_usuario_sist.Id_Persona , CONCAT( `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2` ,' ', `g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`), g_persona.Nombre1 , g_persona.Nombre2 , g_persona.Apellido1 , g_persona.Apellido2 FROM  baseserver.g_usuario_sist INNER JOIN baseserver.g_persona  ON (g_usuario_sist.Id_Persona = g_persona.Id) ORDER BY g_persona.Nombre1 ASC ";
        this.xidpersona = this.xconsulta.llenarComboyLista(this.sql1, this.xidpersona, this.combopersona, 4);
        this.combopersona.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.sql2 = "SELECT  g_supervisor.Id_Persona , CONCAT( `g_persona`.`Nombre1` ,' ', `g_persona`.`Nombre2` ,' ', `g_persona`.`Apellido1` ,' ', `g_persona`.`Apellido2`), g_persona.Nombre1 , g_persona.Nombre2 , g_persona.Apellido1 , g_persona.Apellido2 , g_persona.Correo FROM  baseserver.g_supervisor INNER JOIN baseserver.g_persona  ON (g_supervisor.Id_Persona = g_persona.Id) WHERE g_supervisor.Id_TipoEmpresa = 2 AND g_supervisor.Estado = 0 ORDER BY `g_persona`.`Nombre1`  ASC";
        this.xidjefe = this.xconsulta.llenarComboyLista(this.sql2, this.xidjefe, this.combojefe, 7);
        this.combojefe.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
    }

    public void grabar() {
        if (Principal.txtNo.getText().equals("") && Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                Metodos xmt = new Metodos();
                String sql100 = "insert into sis_cambios ( Id_persona, Id_jefe, Tipo, Descripcion, Justificacion, Objeto_cambio, Fecha,  UsuarioS, Estado, Fecha_R) values('" + this.xidpersona[this.combopersona.getSelectedIndex()][0] + "','" + this.xidjefe[this.combojefe.getSelectedIndex()][0] + "','" + this.combotipo.getSelectedItem() + "','" + this.txtdes.getText() + "','" + this.justi.getText() + "','" + this.txtmod.getText() + "', '" + this.metodos.formatoAMD.format(this.fecharegistro.getDate()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "', '1' ,'" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "')";
                System.out.println(sql100);
                Principal.txtNo.setText(this.xconsulta.ejecutarSQLId(sql100));
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                String mensaje = "Se genero reporte de Solicitud al area sistemas  \nQuien Solicita : " + this.combopersona.getSelectedItem() + "\nJefe Inmediato del Solicitante : " + this.combojefe.getSelectedItem() + "\nTipo Solicitud : " + this.combotipo.getSelectedItem() + "\nSolicitud : " + this.txtdes.getText() + "\n\n\n\n " + Principal.usuarioSistemaDTO.getNombreUsuario();
                Email em = new Email();
                em.Send(xfrom, mensaje, this.xidjefe[this.combojefe.getSelectedIndex()][5], "REPORTE DE SOLICITUD A SISTEMAS");
                this.txtdes.setText("");
                this.txtmod.setText("");
            }
        }
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.fecharegistro = new JDateChooser();
        this.combopersona = new JComboBox();
        this.combojefe = new JComboBox();
        this.combotipo = new JComboBox();
        this.jPanel3 = new JPanel();
        this.jScrollPane12 = new JScrollPane();
        this.txtdes = new JTextArea();
        this.jScrollPane13 = new JScrollPane();
        this.justi = new JTextArea();
        this.jScrollPane14 = new JScrollPane();
        this.txtmod = new JTextArea();
        this.jButton1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CAMBIOS AL SISTEMA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(748, 645));
        setMinimumSize(new Dimension(748, 645));
        setName("Cambios");
        this.jLabel1.setFont(new Font("Arial", 1, 24));
        this.jLabel1.setForeground(new Color(0, 102, 0));
        this.jLabel1.setText("Solicitud Actualizaciones del Sitema de Información");
        this.jPanel1.setBorder(new SoftBevelBorder(0));
        this.fecharegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Registro", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.fecharegistro.setDateFormatString("dd/MM/yyyy");
        this.fecharegistro.setFont(new Font("Arial", 1, 12));
        this.fecharegistro.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.Cambios.1
            public void mouseClicked(MouseEvent evt) {
                Cambios.this.fecharegistroMouseClicked(evt);
            }
        });
        this.combopersona.setFont(new Font("Arial", 1, 12));
        this.combopersona.setBorder(BorderFactory.createTitledBorder((Border) null, "Quien Solicita", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.combojefe.setFont(new Font("Arial", 1, 12));
        this.combojefe.setBorder(BorderFactory.createTitledBorder((Border) null, "Jefe Inmediato", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.combotipo.setFont(new Font("Arial", 1, 12));
        this.combotipo.setModel(new DefaultComboBoxModel(new String[]{"Actualizacion", "Desarrollo", "Cambio", "Otro"}));
        this.combotipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Solicitud", 0, 0, new Font("Arial", 1, 12), Color.red));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.combojefe, -2, 356, -2).addGap(18, 18, 18).addComponent(this.combotipo, 0, -1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.fecharegistro, -2, 207, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.combopersona, -2, 474, -2))).addContainerGap(11, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.fecharegistro, -2, -1, -2).addComponent(this.combopersona, -2, -1, -2)).addGap(15, 15, 15).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.combojefe, -2, -1, -2).addComponent(this.combotipo, -2, 49, -2)).addContainerGap(12, 32767)));
        this.jPanel3.setBorder(new SoftBevelBorder(0));
        this.jScrollPane12.setFont(new Font("Arial", 1, 12));
        this.txtdes.setColumns(7);
        this.txtdes.setFont(new Font("Arial", 1, 12));
        this.txtdes.setRows(3);
        this.txtdes.setText(" ");
        this.txtdes.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción de la Solicitud", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane12.setViewportView(this.txtdes);
        this.justi.setColumns(7);
        this.justi.setFont(new Font("Arial", 1, 12));
        this.justi.setRows(3);
        this.justi.setText(" ");
        this.justi.setBorder(BorderFactory.createTitledBorder((Border) null, "Justificación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane13.setViewportView(this.justi);
        this.txtmod.setColumns(7);
        this.txtmod.setFont(new Font("Arial", 1, 12));
        this.txtmod.setRows(3);
        this.txtmod.setText(" ");
        this.txtmod.setBorder(BorderFactory.createTitledBorder((Border) null, "Modulo o Aplicación objeto de cambio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane14.setViewportView(this.txtmod);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jScrollPane12, -2, 372, -2).addGap(16, 16, 16).addComponent(this.jScrollPane14, -1, 302, 32767)).addComponent(this.jScrollPane13, -1, 690, 32767)).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane12, -2, 203, -2).addComponent(this.jScrollPane14)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane13, -2, 96, -2).addContainerGap()));
        this.jButton1.setFont(new Font("Arial", 1, 14));
        this.jButton1.setForeground(new Color(0, 102, 0));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.jButton1.setText("ENVIAR SOLICITUD ");
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.Cambios.2
            public void actionPerformed(ActionEvent evt) {
                Cambios.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addComponent(this.jLabel1))).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel3, -1, -1, 32767).addGap(12, 12, 12)).addGroup(layout.createSequentialGroup().addComponent(this.jButton1, -1, 718, 32767).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 22, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -1, 53, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fecharegistroMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        grabar();
    }
}
