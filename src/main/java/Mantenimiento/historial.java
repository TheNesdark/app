package Mantenimiento;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Mantenimiento/historial.class */
public class historial extends JInternalFrame {
    public claseMantenimiento Cmantenimiento;
    private String[][] xidpersona;
    private String[][] xidjefe;
    public Object[] dato;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    public DefaultTableModel xmodelo3;
    public String sql;
    public String sql11;
    public String sql1;
    public String sql2;
    public String sql3;
    public String sql4;
    public String estado;
    private JCheckBox Dos;
    private JCheckBox Uno;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JComboBox combojefe;
    private JComboBox combopersona;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane12;
    private JScrollPane jScrollPane13;
    private JScrollPane jScrollPane14;
    private JTable tablaservicio;
    private JComboBox tipo;
    private JTextArea txtdes;
    private JTextArea txtdes1;
    private JTextArea txtdes2;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    public boolean lleno = false;
    private int estadob = 1;
    private int nfila = 0;
    private Metodos xmetodo = new Metodos();

    public historial(claseMantenimiento Cmantenimiento) {
        this.estado = "1";
        initComponents();
        this.Cmantenimiento = Cmantenimiento;
        crearGridnormalidad();
        llenatablanormalidad();
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
            this.Uno.setEnabled(true);
            this.Dos.setEnabled(true);
        }
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 3) {
            this.Uno.setEnabled(true);
            this.Dos.setEnabled(true);
        }
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 4) {
            this.Uno.setEnabled(true);
            this.Dos.setEnabled(true);
        }
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 2) {
            this.jButton1.setEnabled(true);
        }
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 4) {
            this.jButton1.setEnabled(true);
        }
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 4) {
            this.jButton2.setEnabled(true);
            this.jButton3.setEnabled(true);
            this.estado = "0";
            crearGridnormalidad();
            llenatablanormalidad();
        }
        if (Principal.usuarioSistemaDTO.getTipoUsuario().intValue() == 3) {
            this.jButton1.setEnabled(true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGridnormalidad() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo", "descripcion", "Justificacion", "Objeto de Cambio", "Fecha"}) { // from class: Mantenimiento.historial.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tablaservicio.setModel(this.xmodelo);
        this.tablaservicio.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.tablaservicio.getColumnModel().getColumn(1).setPreferredWidth(90);
        this.tablaservicio.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.tablaservicio.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.tablaservicio.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.tablaservicio.getColumnModel().getColumn(5).setPreferredWidth(5);
    }

    public final void cargarDatosnormalidad(String dat) {
        ResultSet rs = this.xconsulta.traerRs(dat);
        int n = 0;
        while (rs.next()) {
            try {
                this.xmodelo.addRow(this.dato);
                this.xmodelo.setValueAt(rs.getString(1), n, 0);
                this.xmodelo.setValueAt(rs.getString(2), n, 1);
                this.xmodelo.setValueAt(rs.getString(3), n, 2);
                this.xmodelo.setValueAt(rs.getString(4), n, 3);
                this.xmodelo.setValueAt(rs.getString(5), n, 4);
                this.xmodelo.setValueAt(rs.getString(6), n, 5);
                n++;
            } catch (SQLException ex) {
                this.xconsulta.mostrarErrorSQL(ex);
                return;
            }
        }
        rs.close();
        this.xconsulta.cerrarConexionBd();
    }

    private void llenatablanormalidad() {
        this.sql1 = " SELECT Id, Tipo, Descripcion, Justificacion, Objeto_cambio, Fecha FROM baseserver.sis_cambios Where Estado='" + this.estado + "'";
        cargarDatosnormalidad(this.sql1);
    }

    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.jScrollPane1 = new JScrollPane();
        this.tablaservicio = new JTable();
        this.jPanel1 = new JPanel();
        this.combopersona = new JComboBox();
        this.combojefe = new JComboBox();
        this.jPanel2 = new JPanel();
        this.Uno = new JCheckBox();
        this.Dos = new JCheckBox();
        this.jButton1 = new JButton();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        this.jRadioButton3 = new JRadioButton();
        this.jScrollPane13 = new JScrollPane();
        this.txtdes1 = new JTextArea();
        this.jScrollPane12 = new JScrollPane();
        this.txtdes = new JTextArea();
        this.jScrollPane14 = new JScrollPane();
        this.txtdes2 = new JTextArea();
        this.tipo = new JComboBox();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("HISTORIAL SOLICITUDES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1023, 769));
        setMinimumSize(new Dimension(1023, 769));
        getContentPane().setLayout(new AbsoluteLayout());
        this.tablaservicio.setFont(new Font("Arial", 1, 12));
        this.tablaservicio.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.tablaservicio.setRowHeight(25);
        this.tablaservicio.setSelectionBackground(new Color(255, 255, 255));
        this.tablaservicio.setSelectionForeground(new Color(255, 0, 0));
        this.tablaservicio.setSelectionMode(0);
        this.tablaservicio.addMouseListener(new MouseAdapter() { // from class: Mantenimiento.historial.2
            public void mouseClicked(MouseEvent evt) {
                historial.this.tablaservicioMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.tablaservicio);
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(10, 39, 979, 376));
        this.jPanel1.setBorder(new SoftBevelBorder(0));
        this.combopersona.setFont(new Font("Arial", 1, 12));
        this.combopersona.setBorder(BorderFactory.createTitledBorder((Border) null, "Quien Solicita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.combojefe.setFont(new Font("Arial", 1, 12));
        this.combojefe.setBorder(BorderFactory.createTitledBorder((Border) null, "Jefe Inmediato", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Visto Bueno Jefe", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.buttonGroup2.add(this.Uno);
        this.Uno.setFont(new Font("Arial", 1, 12));
        this.Uno.setForeground(new Color(255, 0, 0));
        this.Uno.setText("No");
        this.Uno.setEnabled(false);
        this.Uno.addActionListener(new ActionListener() { // from class: Mantenimiento.historial.3
            public void actionPerformed(ActionEvent evt) {
                historial.this.UnoActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.Dos);
        this.Dos.setFont(new Font("Arial", 1, 12));
        this.Dos.setForeground(new Color(255, 0, 0));
        this.Dos.setText("Si");
        this.Dos.setEnabled(false);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.Dos).addGap(18, 18, 18).addComponent(this.Uno).addContainerGap(17, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Dos).addComponent(this.Uno)).addContainerGap(9, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.combopersona, 0, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.combojefe, -2, 320, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.combopersona, -2, -1, -2).addGap(8, 8, 8).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.combojefe, -2, -1, -2).addGap(13, 13, 13)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(6, 6, 6)))));
        getContentPane().add(this.jPanel1, new AbsoluteConstraints(10, 433, -1, -1));
        this.jButton1.setFont(new Font("Arial", 1, 14));
        this.jButton1.setForeground(new Color(0, 102, 0));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton1.setText("Visto Bueno");
        this.jButton1.setEnabled(false);
        this.jButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.historial.4
            public void actionPerformed(ActionEvent evt) {
                historial.this.jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jButton1, new AbsoluteConstraints(10, 670, 510, 35));
        this.buttonGroup1.add(this.jRadioButton1);
        this.jRadioButton1.setFont(new Font("Arial", 1, 14));
        this.jRadioButton1.setForeground(new Color(0, 102, 0));
        this.jRadioButton1.setSelected(true);
        this.jRadioButton1.setText("Pendientes sin Aprobar");
        this.jRadioButton1.addActionListener(new ActionListener() { // from class: Mantenimiento.historial.5
            public void actionPerformed(ActionEvent evt) {
                historial.this.jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jRadioButton1, new AbsoluteConstraints(26, 7, -1, -1));
        this.buttonGroup1.add(this.jRadioButton2);
        this.jRadioButton2.setFont(new Font("Arial", 1, 14));
        this.jRadioButton2.setForeground(new Color(0, 102, 0));
        this.jRadioButton2.setText("Aprobados");
        this.jRadioButton2.addActionListener(new ActionListener() { // from class: Mantenimiento.historial.6
            public void actionPerformed(ActionEvent evt) {
                historial.this.jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jRadioButton2, new AbsoluteConstraints(250, 7, -1, -1));
        this.buttonGroup1.add(this.jRadioButton3);
        this.jRadioButton3.setFont(new Font("Arial", 1, 14));
        this.jRadioButton3.setForeground(new Color(0, 102, 0));
        this.jRadioButton3.setText("Terminados");
        this.jRadioButton3.addActionListener(new ActionListener() { // from class: Mantenimiento.historial.7
            public void actionPerformed(ActionEvent evt) {
                historial.this.jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jRadioButton3, new AbsoluteConstraints(402, 7, -1, -1));
        this.txtdes1.setEditable(false);
        this.txtdes1.setBackground(new Color(153, 153, 255));
        this.txtdes1.setColumns(7);
        this.txtdes1.setFont(new Font("Arial", 1, 12));
        this.txtdes1.setRows(1);
        this.txtdes1.setText(" ");
        this.txtdes1.setBorder(BorderFactory.createTitledBorder((Border) null, "Justificación", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane13.setViewportView(this.txtdes1);
        getContentPane().add(this.jScrollPane13, new AbsoluteConstraints(10, 583, 513, 80));
        this.txtdes.setEditable(false);
        this.txtdes.setBackground(new Color(153, 153, 255));
        this.txtdes.setColumns(7);
        this.txtdes.setFont(new Font("Arial", 1, 12));
        this.txtdes.setRows(1);
        this.txtdes.setText(" ");
        this.txtdes.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción de la Solicitud", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane12.setViewportView(this.txtdes);
        getContentPane().add(this.jScrollPane12, new AbsoluteConstraints(530, 490, 454, 79));
        this.txtdes2.setEditable(false);
        this.txtdes2.setBackground(new Color(153, 153, 255));
        this.txtdes2.setColumns(7);
        this.txtdes2.setFont(new Font("Arial", 1, 12));
        this.txtdes2.setRows(1);
        this.txtdes2.setText(" ");
        this.txtdes2.setBorder(BorderFactory.createTitledBorder((Border) null, "Modulo o Aplicación objeto de cambio", 0, 0, new Font("Arial", 1, 12)));
        this.jScrollPane14.setViewportView(this.txtdes2);
        getContentPane().add(this.jScrollPane14, new AbsoluteConstraints(530, 580, 454, 83));
        this.tipo.setFont(new Font("Arial", 1, 12));
        this.tipo.setModel(new DefaultComboBoxModel(new String[]{"Actualizacion", "Cambio", "Desarrollo", " "}));
        this.tipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Solicitud", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.tipo.setEnabled(false);
        getContentPane().add(this.tipo, new AbsoluteConstraints(530, 430, 454, -1));
        this.jButton2.setFont(new Font("Arial", 1, 14));
        this.jButton2.setForeground(new Color(0, 102, 0));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/BtnUltimo.png")));
        this.jButton2.setText("APROBAR");
        this.jButton2.setEnabled(false);
        this.jButton2.addActionListener(new ActionListener() { // from class: Mantenimiento.historial.8
            public void actionPerformed(ActionEvent evt) {
                historial.this.jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jButton2, new AbsoluteConstraints(530, 670, 260, 35));
        this.jButton3.setFont(new Font("Arial", 1, 14));
        this.jButton3.setForeground(new Color(0, 102, 0));
        this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Anular.png")));
        this.jButton3.setText("desistir");
        this.jButton3.setEnabled(false);
        this.jButton3.addActionListener(new ActionListener() { // from class: Mantenimiento.historial.9
            public void actionPerformed(ActionEvent evt) {
                historial.this.jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(this.jButton3, new AbsoluteConstraints(800, 670, 180, 35));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tablaservicioMouseClicked(MouseEvent evt) {
        if (this.jRadioButton2.isSelected() && evt.getClickCount() == 2 && this.tablaservicio.getSelectedRow() != -1) {
            this.Cmantenimiento.cargarPantalla("aprobo", this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 0).toString());
        }
        if (evt.getClickCount() == 2 && this.tablaservicio.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 0).toString());
            this.txtdes.setText(this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 2).toString());
            this.txtdes1.setText(this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 3).toString());
            this.txtdes2.setText(this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 4).toString());
            this.tipo.setSelectedItem(this.xmodelo.getValueAt(this.tablaservicio.getSelectedRow(), 1).toString());
            personas();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UnoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton1ActionPerformed(ActionEvent evt) {
        this.estado = "1";
        crearGridnormalidad();
        llenatablanormalidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton2ActionPerformed(ActionEvent evt) {
        this.estado = "2";
        crearGridnormalidad();
        llenatablanormalidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton3ActionPerformed(ActionEvent evt) {
        this.estado = "3";
        crearGridnormalidad();
        llenatablanormalidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        aprobar();
        sistemas();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton3ActionPerformed(ActionEvent evt) {
        desistir();
    }

    private void personas() {
        this.sql1 = "SELECT  sis_cambios.Id  ,CONCAT( `g_persona_1`.`Nombre1` ,' ', `g_persona_1`.`Nombre2` ,' ', `g_persona_1`.`Apellido1` ,' ', `g_persona_1`.`Apellido2`) AS persona FROM  baseserver.sis_cambios INNER JOIN baseserver.g_persona AS g_persona_1  ON (sis_cambios.Id_persona = g_persona_1.Id) INNER JOIN baseserver.g_persona AS g_persona_2 ON (sis_cambios.Id_jefe = g_persona_2.Id) WHERE sis_cambios.Id='" + Principal.txtNo.getText() + "'";
        System.out.println(this.sql1);
        this.xidpersona = this.xconsulta.llenarComboyLista(this.sql1, this.xidpersona, this.combopersona, 2);
        this.combopersona.setSelectedIndex(0);
        this.xconsulta.cerrarConexionBd();
        this.sql2 = "SELECT  sis_cambios.Id  ,CONCAT( `g_persona_2`.`Nombre1` ,' ', `g_persona_2`.`Nombre2` ,' ', `g_persona_2`.`Apellido1` ,' ', `g_persona_2`.`Apellido2`) AS jefe FROM  baseserver.sis_cambios INNER JOIN baseserver.g_persona AS g_persona_1  ON (sis_cambios.Id_persona = g_persona_1.Id) INNER JOIN baseserver.g_persona AS g_persona_2 ON (sis_cambios.Id_jefe = g_persona_2.Id) WHERE sis_cambios.Id='" + Principal.txtNo.getText() + "'";
        this.xidjefe = this.xconsulta.llenarComboyLista(this.sql2, this.xidjefe, this.combojefe, 2);
        this.combojefe.setSelectedIndex(0);
        this.xconsulta.cerrarConexionBd();
    }

    public void grabar() {
        if (Principal.txtNo.getText() != null && this.Dos.isSelected()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql3 = " UPDATE sis_cambios set Estado = 0 WHERE sis_cambios.Id = '" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(sql3);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                mandacorreo();
                gerente();
            }
        }
        if (this.Uno.isSelected()) {
            int n2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n2 == 0) {
                String sql32 = " UPDATE sis_cambios set Estado = 9 WHERE sis_cambios.Id = '" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(sql32);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    public void aprobar() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql3 = " UPDATE sis_cambios set Estado = 2 WHERE sis_cambios.Id = '" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(sql3);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                mandacorreo2();
            }
        }
    }

    public void desistir() {
        if (Principal.txtNo.getText() != null) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql3 = " UPDATE sis_cambios set Estado = 9 WHERE sis_cambios.Id = '" + Principal.txtNo.getText() + "'";
                this.xconsulta.ejecutarSQL(sql3);
                this.xconsulta.cerrarConexionBd();
                JOptionPane.showInternalMessageDialog(this, "Registro anulado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    private void mandacorreo() {
        String correo = "SELECT g_persona.Correo FROM baseserver.g_persona INNER JOIN baseserver.sis_cambios ON (g_persona.Id = sis_cambios.Id_persona) WHERE sis_cambios.Id = '" + Principal.txtNo.getText() + "'";
        String datos = this.xconsulta.traerDato(correo);
        String mensaje = "su Jefe a Dado Visto Bueno a la Solicitud Que usted Envió a Sistemas \n\nDescripcion de la Solicitud:  " + this.txtdes.getText();
        Email em = new Email();
        em.Send("sistemas@fundacionpazenu.org.co", mensaje, datos, " RESPUESTA DE SOLICITUD A SISTEMAS ");
    }

    private void mandacorreo2() {
        String correo = "SELECT g_persona.Correo FROM baseserver.g_persona INNER JOIN baseserver.sis_cambios ON (g_persona.Id = sis_cambios.Id_persona) WHERE sis_cambios.Id = '" + Principal.txtNo.getText() + "'";
        String datos = this.xconsulta.traerDato(correo);
        Email em = new Email();
        em.Send("sistemas@fundacionpazenu.org.co", "Ya fue aprobada la solicitud que usted realizo al area de sistemas, al terminarla se le informara ", datos, " RESPUESTA DE SOLICITUD A SISTEMAS ");
    }

    private void gerente() {
        String datos = this.xconsulta.traerDato(" SELECT g_persona.Correo FROM baseserver.g_usuario_sist INNER JOIN baseserver.g_persona ON (g_usuario_sist.Id_Persona = g_persona.Id) WHERE (g_usuario_sist.EsAdministrativo =4)");
        Email em = new Email();
        em.Send("sistemas@fundacionpazenu.org.co", "Se ha dado el visto bueno a una solicitud al área de sistemas, Verifique en el sistema para su aprobación y posterior desarrollo", datos, " SOLICITUD A SISTEMAS ");
    }

    private void sistemas() {
        String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
        String mensaje = "se Aprobo una solicitud para su desarrollo, verificar en el sistema\n\n\n\n " + Principal.usuarioSistemaDTO.getNombreUsuario();
        Email em = new Email();
        em.Send(xfrom, mensaje, "sistemas@fundacionpanzenu.org.co", "Solicitud ");
    }
}
