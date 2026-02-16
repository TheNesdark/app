package Informes;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Dimension;
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
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
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

/* JADX INFO: loaded from: GenomaP.jar:Informes/JIFRegistroActividadesPyPUsuario.class */
public class JIFRegistroActividadesPyPUsuario extends JInternalFrame {
    private Object[] dato;
    private DefaultTableModel xmodeloasistentes;
    private DefaultTableModel xmodeloactividad;
    private int xlleno;
    private File xfile;
    public Persona xjppersona;
    private String[] xidactividad;
    private JButton JBTAdicionar;
    private JComboBox JCBActividad;
    private JPanel JPIDUsuario;
    private JPanel JPIDatosBusqueda;
    private JScrollPane JSPDetalleAct;
    private JScrollPane JSPUsuarios;
    private JTable JTBDetalleAct;
    private JTable JTBUsuarios;
    private JTextField JTFRuta;
    private JButton JTGrabarEvidencia;
    private JPanel jPanel1;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private boolean xguardado = false;

    public JIFRegistroActividadesPyPUsuario() {
        this.xlleno = 0;
        initComponents();
        mLlenarCombobox();
        mCargasPanelUsuario();
        mCrearTablaActividad();
        mCrearTablaAsistentes();
        this.xlleno = 1;
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JPIDatosBusqueda = new JPanel();
        this.JBTAdicionar = new JButton();
        this.JSPDetalleAct = new JScrollPane();
        this.JTBDetalleAct = new JTable();
        this.JCBActividad = new JComboBox();
        this.JSPUsuarios = new JScrollPane();
        this.JTBUsuarios = new JTable();
        this.JPIDUsuario = new JPanel();
        this.JTFRuta = new JTextField();
        this.JTGrabarEvidencia = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO DE ACTIVIDADES ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifregactividadespyp");
        setPreferredSize(new Dimension(1017, 811));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "REGISTRO DE ACTIVIDADES", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.jPanel1.setName("jpregistraractividades");
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCION", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Informes.JIFRegistroActividadesPyPUsuario.1
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroActividadesPyPUsuario.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JSPDetalleAct.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE ACTIVIDADES", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalleAct.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleAct.setRowHeight(25);
        this.JTBDetalleAct.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleAct.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleAct.setSelectionMode(0);
        this.JTBDetalleAct.addMouseListener(new MouseAdapter() { // from class: Informes.JIFRegistroActividadesPyPUsuario.2
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroActividadesPyPUsuario.this.JTBDetalleActMouseClicked(evt);
            }
        });
        this.JSPDetalleAct.setViewportView(this.JTBDetalleAct);
        this.JCBActividad.setFont(new Font("Arial", 1, 12));
        this.JCBActividad.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBActividad.addItemListener(new ItemListener() { // from class: Informes.JIFRegistroActividadesPyPUsuario.3
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistroActividadesPyPUsuario.this.JCBActividadItemStateChanged(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionar, -1, 959, 32767).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleAct, -1, 949, 32767).addComponent(this.JCBActividad, 0, 949, 32767)))).addContainerGap()));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBActividad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleAct, -1, 125, 32767).addGap(18, 18, 18).addComponent(this.JBTAdicionar)));
        this.JSPUsuarios.setBorder(BorderFactory.createTitledBorder((Border) null, "ASISTENTES", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBUsuarios.setFont(new Font("Arial", 1, 12));
        this.JTBUsuarios.setRowHeight(25);
        this.JTBUsuarios.setSelectionBackground(new Color(255, 255, 255));
        this.JTBUsuarios.setSelectionForeground(new Color(0, 102, 0));
        this.JTBUsuarios.setSelectionMode(0);
        this.JSPUsuarios.setViewportView(this.JTBUsuarios);
        GroupLayout JPIDUsuarioLayout = new GroupLayout(this.JPIDUsuario);
        this.JPIDUsuario.setLayout(JPIDUsuarioLayout);
        JPIDUsuarioLayout.setHorizontalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 981, 32767));
        JPIDUsuarioLayout.setVerticalGroup(JPIDUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 174, 32767));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Informes.JIFRegistroActividadesPyPUsuario.4
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroActividadesPyPUsuario.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JTGrabarEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTGrabarEvidencia.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JTGrabarEvidencia.setText("Grabar");
        this.JTGrabarEvidencia.addActionListener(new ActionListener() { // from class: Informes.JIFRegistroActividadesPyPUsuario.5
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroActividadesPyPUsuario.this.JTGrabarEvidenciaActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDUsuario, -1, -1, 32767).addComponent(this.JPIDatosBusqueda, -1, -1, 32767).addComponent(this.JSPUsuarios, -1, 981, 32767).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 740, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTGrabarEvidencia, -1, 203, 32767).addGap(18, 18, 18)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPIDUsuario, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPUsuarios, -2, 178, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTGrabarEvidencia, -1, -1, 32767).addComponent(this.JTFRuta, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1003, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 785, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(52, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (!this.xjppersona.txtHistoria.getText().isEmpty()) {
            if (this.JTBDetalleAct.getSelectedRow() != -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 2);
                if (n == 0) {
                    new GregorianCalendar();
                    String sql = "insert ignore into  baseserver.h_actividadespyp (Id_Usuario, Id_Actividad, Fecha, UsuarioS)  values('" + this.xjppersona.getIdPersona() + "','" + this.JTBDetalleAct.getValueAt(this.JTBDetalleAct.getSelectedRow(), 0).toString() + "','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xconsultas.ejecutarSQL(sql);
                    this.xconsultas.cerrarConexionBd();
                    mCrearTablaAsistentes();
                    mCargarDatosTablaAsistentes(this.JTBDetalleAct.getValueAt(this.JTBDetalleAct.getSelectedRow(), 0).toString());
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una actividad", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un usuario", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleActMouseClicked(MouseEvent evt) {
        if (this.JTBDetalleAct.getSelectedRow() != -1) {
            mCrearTablaAsistentes();
            mCargarDatosTablaAsistentes(this.JTBDetalleAct.getValueAt(this.JTBDetalleAct.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        JFileChooser xfilec;
        if (evt.getClickCount() == 2) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                xfilec = new JFileChooser("S:\\Promocion y Prevencion\\");
            } else {
                xfilec = new JFileChooser("S:\\");
            }
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                this.xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(this.xmetodo.mTraerUrlBD(this.xfile.getPath()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTGrabarEvidenciaActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty() && this.JTBDetalleAct.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de guardar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "UPDATE  p_planeacionactividades SET Registro='" + this.JTFRuta.getText() + "' where Id = '" + this.JTBDetalleAct.getValueAt(this.JTBDetalleAct.getSelectedRow(), 0) + "'";
                this.xconsultas.ejecutarSQL(sql);
                this.xconsultas.cerrarConexionBd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBActividadItemStateChanged(ItemEvent evt) {
        if (this.xlleno == 1 && this.JCBActividad.getSelectedIndex() != -1) {
            mCrearTablaActividad();
            mCargarDatosTablaActividad(this.xidactividad[this.JCBActividad.getSelectedIndex()]);
        }
    }

    private void mCargarDatosTabla() {
    }

    private void mCrearTablaActividad() {
        this.xmodeloactividad = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Nombre", "Fecha", "Hora", "Profesional"}) { // from class: Informes.JIFRegistroActividadesPyPUsuario.6
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBDetalleAct.setModel(this.xmodeloactividad);
        this.JTBDetalleAct.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTBDetalleAct.getColumnModel().getColumn(0).setMinWidth(40);
        this.JTBDetalleAct.getColumnModel().getColumn(0).setMaxWidth(40);
        this.JTBDetalleAct.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalleAct.getColumnModel().getColumn(1).setMinWidth(500);
        this.JTBDetalleAct.getColumnModel().getColumn(1).setMaxWidth(500);
        this.JTBDetalleAct.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTBDetalleAct.getColumnModel().getColumn(2).setMinWidth(80);
        this.JTBDetalleAct.getColumnModel().getColumn(2).setMaxWidth(80);
        this.JTBDetalleAct.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTBDetalleAct.getColumnModel().getColumn(3).setMinWidth(80);
        this.JTBDetalleAct.getColumnModel().getColumn(3).setMaxWidth(80);
        this.JTBDetalleAct.getColumnModel().getColumn(4).setPreferredWidth(350);
        this.JTBDetalleAct.getColumnModel().getColumn(4).setMinWidth(350);
        this.JTBDetalleAct.getColumnModel().getColumn(4).setMaxWidth(350);
    }

    private void mCargarDatosTablaActividad(String id) {
        try {
            String sql = " SELECT p_planeacionactividades.Id, p_actividades.Nbre, DATE_FORMAT(p_planeacionactividades.Fecha_Actividad, '%d/%m/%Y') AS FechaAct, p_planeacionactividades.Hora_Actividad, profesional.NProfesional FROM baseserver.p_planeacionactividades INNER JOIN baseserver.p_actividades ON (p_planeacionactividades.Id_PActividad = p_actividades.Id) INNER JOIN baseserver.profesional ON (p_planeacionactividades.Id_Profesional = profesional.Id_Persona)  WHERE (p_planeacionactividades.Estado =1 AND p_planeacionactividades.Id_PActividad ='" + id + "') ORDER BY p_planeacionactividades.Fecha_Actividad ASC, p_planeacionactividades.Hora_Actividad ASC, p_actividades.Nbre ASC";
            ResultSet rs = this.xconsultas.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodeloactividad.addRow(this.dato);
                    this.xmodeloactividad.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodeloactividad.setValueAt(rs.getString(2), i, 1);
                    this.xmodeloactividad.setValueAt(rs.getString(3), i, 2);
                    this.xmodeloactividad.setValueAt(rs.getString(4), i, 3);
                    this.xmodeloactividad.setValueAt(rs.getString(5), i, 4);
                    i++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroActividadesPyPUsuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCrearTablaAsistentes() {
        this.xmodeloasistentes = new DefaultTableModel((Object[][]) null, new String[]{"N°", "N° HC", "Usuario", ""}) { // from class: Informes.JIFRegistroActividadesPyPUsuario.7
            Class[] types = {Integer.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTBUsuarios.setModel(this.xmodeloasistentes);
        this.JTBUsuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBUsuarios.getColumnModel().getColumn(0).setMinWidth(50);
        this.JTBUsuarios.getColumnModel().getColumn(0).setMaxWidth(50);
        this.JTBUsuarios.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBUsuarios.getColumnModel().getColumn(1).setMinWidth(100);
        this.JTBUsuarios.getColumnModel().getColumn(1).setMaxWidth(100);
        this.JTBUsuarios.getColumnModel().getColumn(2).setPreferredWidth(800);
        this.JTBUsuarios.getColumnModel().getColumn(2).setMinWidth(800);
        this.JTBUsuarios.getColumnModel().getColumn(2).setMaxWidth(800);
        this.JTBUsuarios.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTBUsuarios.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTBUsuarios.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatosTablaAsistentes(String id) {
        try {
            String sql = "SELECT persona.NoHistoria, persona.NUsuario,persona.Id_persona FROM baseserver.p_planeacionactividades INNER JOIN baseserver.p_actividades  ON (p_planeacionactividades.Id_PActividad = p_actividades.Id) INNER JOIN baseserver.profesional  ON (p_planeacionactividades.Id_Profesional = profesional.Id_Persona) INNER JOIN baseserver.h_actividadespyp  ON (h_actividadespyp.Id_Actividad = p_planeacionactividades.Id) INNER JOIN baseserver.persona  ON (persona.Id_persona = h_actividadespyp.Id_Usuario) WHERE (p_planeacionactividades.Id ='" + id + "') ";
            ResultSet rs = this.xconsultas.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodeloasistentes.addRow(this.dato);
                    this.xmodeloasistentes.setValueAt(Integer.valueOf(i + 1), i, 0);
                    this.xmodeloasistentes.setValueAt(rs.getString(1), i, 1);
                    this.xmodeloasistentes.setValueAt(rs.getString(2), i, 2);
                    this.xmodeloasistentes.setValueAt(rs.getString(3), i, 3);
                    i++;
                }
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroActividadesPyPUsuario.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLlenarCombobox() {
        this.xidactividad = this.xconsultas.llenarCombo("SELECT p_actividades.Id, p_actividades.Nbre FROM baseserver.p_planeacionactividades INNER JOIN baseserver.p_actividades ON (p_planeacionactividades.Id_PActividad = p_actividades.Id)  WHERE (p_actividades.Estado =1) GROUP BY p_actividades.Id ORDER BY p_actividades.Nbre ASC ", this.xidactividad, this.JCBActividad);
        this.JCBActividad.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIDUsuario.setVisible(false);
        this.xjppersona.setBounds(1, 1, 1000, 160);
        this.JPIDUsuario.add(this.xjppersona);
        this.JPIDUsuario.setVisible(true);
    }

    public void mNuevo() {
        this.xjppersona.nuevo();
    }
}
