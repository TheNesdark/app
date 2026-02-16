package Historia;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFRegistroAtencionesEsp.class */
public class JIFRegistroAtencionesEsp extends JInternalFrame {
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelor;
    private Object[] dato;
    private String[] xidespecialidad;
    private String[] xidespecialidad1;
    private String[] xidprofesional;
    private String[] xidprofesional1;
    private String[] xidtipocita;
    private String xsql;
    private ButtonGroup JBGOpciones;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBEspecialidad1;
    private JComboBox JCBProfesional;
    private JComboBox JCBTipoCita;
    private JCheckBox JCHFiltro;
    private JPanel JPIDatosAtencion;
    private JPanel JPIDatosAtencion1;
    private JPanel JPIFDatosUsuario;
    private JScrollPane JSPRegistro;
    private JScrollPane JSPResultado;
    private JTable JTBRegistro;
    private JTable JTBResultado;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xestado = false;
    private int xTipo = 0;

    public JIFRegistroAtencionesEsp(String xnombre) {
        initComponents();
        setName(xnombre);
        mCargasPanelUsuario();
        mLimpiarComponente();
    }

    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v36, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JSPResultado = new JScrollPane();
        this.JTBResultado = new JTable();
        this.JPIDatosAtencion = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JCBTipoCita = new JComboBox();
        this.JSPRegistro = new JScrollPane();
        this.JTBRegistro = new JTable();
        this.JPIDatosAtencion1 = new JPanel();
        this.JCBEspecialidad1 = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("REGISTRO ATENCIONES ESPECIALES");
        setAutoscrolls(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("jifregistroatencionesp");
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFRegistroAtencionesEsp.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRegistroAtencionesEsp.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1014, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 168, 32767));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO DE ATENCIONES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBResultado.setFont(new Font("Arial", 1, 12));
        this.JTBResultado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBResultado.setAutoResizeMode(4);
        this.JTBResultado.setRowHeight(25);
        this.JTBResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTBResultado.setSelectionForeground(new Color(255, 0, 0));
        this.JTBResultado.setSelectionMode(0);
        this.JTBResultado.addMouseListener(new MouseAdapter() { // from class: Historia.JIFRegistroAtencionesEsp.2
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroAtencionesEsp.this.JTBResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTBResultado);
        this.JPIDatosAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA LA ATENCIÓN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JIFRegistroAtencionesEsp.3
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistroAtencionesEsp.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoCita.setFont(new Font("Arial", 1, 12));
        this.JCBTipoCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosAtencionLayout = new GroupLayout(this.JPIDatosAtencion);
        this.JPIDatosAtencion.setLayout(JPIDatosAtencionLayout);
        JPIDatosAtencionLayout.setHorizontalGroup(JPIDatosAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEspecialidad, -2, 267, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProfesional, -2, 405, -2).addGap(18, 18, 18).addComponent(this.JCBTipoCita, 0, 298, 32767).addContainerGap()));
        JPIDatosAtencionLayout.setVerticalGroup(JPIDatosAtencionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -1, 45, 32767).addComponent(this.JCBProfesional, -1, 45, 32767).addComponent(this.JCBTipoCita, -1, 45, 32767));
        this.JSPRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO DE REGISTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTBRegistro.setFont(new Font("Arial", 1, 12));
        this.JTBRegistro.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBRegistro.setAutoResizeMode(4);
        this.JTBRegistro.setRowHeight(25);
        this.JTBRegistro.setSelectionBackground(new Color(255, 255, 255));
        this.JTBRegistro.setSelectionForeground(new Color(255, 0, 0));
        this.JTBRegistro.setSelectionMode(0);
        this.JTBRegistro.addMouseListener(new MouseAdapter() { // from class: Historia.JIFRegistroAtencionesEsp.4
            public void mouseClicked(MouseEvent evt) {
                JIFRegistroAtencionesEsp.this.JTBRegistroMouseClicked(evt);
            }
        });
        this.JSPRegistro.setViewportView(this.JTBRegistro);
        this.JPIDatosAtencion1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTAR", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBEspecialidad1.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad1.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad1.addItemListener(new ItemListener() { // from class: Historia.JIFRegistroAtencionesEsp.5
            public void itemStateChanged(ItemEvent evt) {
                JIFRegistroAtencionesEsp.this.JCBEspecialidad1ItemStateChanged(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Todas");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Historia.JIFRegistroAtencionesEsp.6
            public void actionPerformed(ActionEvent evt) {
                JIFRegistroAtencionesEsp.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosAtencion1Layout = new GroupLayout(this.JPIDatosAtencion1);
        this.JPIDatosAtencion1.setLayout(JPIDatosAtencion1Layout);
        JPIDatosAtencion1Layout.setHorizontalGroup(JPIDatosAtencion1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtencion1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBEspecialidad1, -2, 788, -2).addGap(44, 44, 44).addComponent(this.JCHFiltro).addContainerGap(-1, 32767)));
        JPIDatosAtencion1Layout.setVerticalGroup(JPIDatosAtencion1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtencion1Layout.createSequentialGroup().addGroup(JPIDatosAtencion1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad1, -1, 45, 32767).addComponent(this.JCHFiltro)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPRegistro, GroupLayout.Alignment.LEADING, -1, 1030, 32767).addComponent(this.JPIDatosAtencion, -1, -1, 32767).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING, -1, 1030, 32767).addComponent(this.JPIDatosAtencion1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIFDatosUsuario, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDatosAtencion1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 165, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosAtencion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPRegistro, -2, 195, -2).addContainerGap(15, 32767)));
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBResultadoMouseClicked(MouseEvent evt) {
        if (this.JTBResultado.getSelectedRow() != -1 && !this.xjppersona.IdPersona.isEmpty()) {
            mCargarDatosR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.JCBEspecialidad.getSelectedIndex() != -1 && this.xestado) {
            this.JCBProfesional.removeAllItems();
            this.JCBTipoCita.removeAllItems();
            this.xidprofesional = this.xconsultas.llenarCombo("SELECT Id_Persona, NProfesional FROM profesional1 WHERE (Estado =0 AND IdEspecialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY NProfesional ASC", this.xidprofesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
            this.xidtipocita = this.xconsultas.llenarCombo("SELECT Id, Nbre FROM c_clasecita WHERE (Id_Especialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "' AND Estado =0) ORDER BY Nbre ASC", this.xidtipocita, this.JCBTipoCita);
            this.JCBTipoCita.setSelectedIndex(-1);
            this.xconsultas.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBRegistroMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidad1ItemStateChanged(ItemEvent evt) {
        if (this.JCBEspecialidad1.getSelectedIndex() != -1 && this.xestado && !this.xjppersona.IdPersona.isEmpty()) {
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCBEspecialidad1.getSelectedIndex() != -1 && this.xestado && !this.xjppersona.IdPersona.isEmpty()) {
            mCargarDatos();
        }
    }

    public void mNuevo_A() {
        this.xestado = false;
        this.JCBEspecialidad1.removeAllItems();
        String xsql = "SELECT `profesional1`.`IdEspecialidad` , `profesional1`.`Especialidad`  FROM `profesional1` INNER JOIN `h_atencion`   ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`) INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`h_atencion`.`Codigo_Dxp` <>'' AND `ingreso`.`Id_Usuario` ='" + this.xjppersona.IdPersona + "') GROUP BY `profesional1`.`IdEspecialidad` ORDER BY `profesional1`.`Especialidad` ASC";
        this.xidespecialidad1 = this.xconsultas.llenarCombo(xsql, this.xidespecialidad1, this.JCBEspecialidad1);
        this.JCBEspecialidad1.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        this.xestado = true;
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"N° Atencion", "Fecha", "Hora", "Profesional", "Id_Ingreso", "Id_TipoA"}) { // from class: Historia.JIFRegistroAtencionesEsp.7
            Class[] types = {String.class, String.class, String.class, String.class, Long.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBResultado.setModel(this.xmodelo);
        this.JTBResultado.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTBResultado.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTBResultado.getColumnModel().getColumn(2).setPreferredWidth(40);
        this.JTBResultado.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTBResultado.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTBResultado.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaR() {
        this.xmodelor = new DefaultTableModel(new Object[0], new String[]{"N°", "Fecha Hora", "Tipo Cita", "Especialidad", "Profesional", "Atendido?", "Estado?"}) { // from class: Historia.JIFRegistroAtencionesEsp.8
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBRegistro.setModel(this.xmodelor);
        this.JTBRegistro.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTBRegistro.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBRegistro.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBRegistro.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBRegistro.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBRegistro.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBRegistro.getColumnModel().getColumn(6).setPreferredWidth(20);
    }

    public void mBuscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }

    private void mCargarDatos() {
        String sql;
        try {
            if (this.JCHFiltro.isSelected()) {
                sql = "SELECT h_atencion.Id , h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion, profesional1.NProfesional, ingreso.Id, ingreso.Id_TipoAtencion FROM profesional1 INNER JOIN h_atencion  ON (profesional1.Id_Persona = h_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad) INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + this.xjppersona.IdPersona + "' AND h_atencion.Id_Especialidad ='" + this.xidespecialidad1[this.JCBEspecialidad1.getSelectedIndex()] + "') ORDER BY h_atencion.Fecha_Atencion DESC, h_atencion.Hora_Atencion DESC ";
            } else {
                sql = "SELECT h_atencion.Id , h_atencion.Fecha_Atencion, h_atencion.Hora_Atencion, profesional1.NProfesional, ingreso.Id, ingreso.Id_TipoAtencion FROM profesional1 INNER JOIN h_atencion  ON (profesional1.Id_Persona = h_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencion.Id_Especialidad) INNER JOIN ingreso ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + this.xjppersona.IdPersona + "' AND h_atencion.Id_Especialidad ='" + this.xidespecialidad1[this.JCBEspecialidad1.getSelectedIndex()] + "' and h_atencion.Ip6=1) ORDER BY h_atencion.Fecha_Atencion DESC, h_atencion.Hora_Atencion DESC ";
            }
            ResultSet rs = this.xconsultas.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearTabla();
                while (rs.next()) {
                    this.xmodelo.addRow(this.dato);
                    this.xmodelo.setValueAt(rs.getString(1), filaGrid, 0);
                    this.xmodelo.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodelo.setValueAt(rs.getString(3), filaGrid, 2);
                    this.xmodelo.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(5)), filaGrid, 4);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(6)), filaGrid, 5);
                    filaGrid++;
                }
            } else {
                mCrearTabla();
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarResultadoExamenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mCargarDatosR() {
        try {
            String sql = "SELECT h_atencionespeciales.Id, h_atencionespeciales.Fecha_Atencion, c_clasecita.Nbre, profesional1.Especialidad, profesional1.NProfesional, h_atencionespeciales.EstadoA, h_atencionespeciales.Estado FROM h_atencionespeciales INNER JOIN c_clasecita  ON (h_atencionespeciales.Id_TipoConsulta = c_clasecita.Id) INNER JOIN profesional1  ON (profesional1.Id_Persona = h_atencionespeciales.Id_Profesional) AND (profesional1.IdEspecialidad = h_atencionespeciales.Id_Especialidad) INNER JOIN h_atencion  ON (h_atencionespeciales.Id_Atencion = h_atencion.Id) INNER JOIN ingreso  ON (h_atencion.Id_Ingreso = ingreso.Id) WHERE (ingreso.Id_Usuario ='" + this.xjppersona.IdPersona + "' and h_atencionespeciales.Id_Atencion='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "') ORDER BY h_atencionespeciales.Fecha_Atencion DESC ";
            ResultSet rs = this.xconsultas.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int filaGrid = 0;
                mCrearTablaR();
                while (rs.next()) {
                    this.xmodelor.addRow(this.dato);
                    this.xmodelor.setValueAt(Integer.valueOf(rs.getInt(1)), filaGrid, 0);
                    this.xmodelor.setValueAt(rs.getString(2), filaGrid, 1);
                    this.xmodelor.setValueAt(rs.getString(3), filaGrid, 2);
                    this.xmodelor.setValueAt(rs.getString(4), filaGrid, 3);
                    this.xmodelor.setValueAt(rs.getString(5), filaGrid, 4);
                    this.xmodelor.setValueAt(Boolean.valueOf(rs.getBoolean(6)), filaGrid, 5);
                    this.xmodelor.setValueAt(Boolean.valueOf(rs.getBoolean(7)), filaGrid, 6);
                    filaGrid++;
                }
            } else {
                mCrearTablaR();
            }
            rs.close();
            this.xconsultas.cerrarConexionBd();
        } catch (Exception ex) {
            Logger.getLogger(JIFConsultarResultadoExamenes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFRegistroAtencionesEsp$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 5).toString().equals("false")) {
                cell.setBackground(new Color(0, 0, 102));
            } else if (table.getValueAt(row, 5).toString().equals("true")) {
                cell.setBackground(new Color(103, 0, 103));
            }
            cell.setForeground(Color.WHITE);
            return cell;
        }
    }

    public void mNuevo() {
        Object[] botones = {"Usuario", "Registro", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.xjppersona.nuevo();
            mLimpiarComponente();
        } else if (n == 1) {
            mLimpiarComponente();
        }
    }

    public void mGrabar() {
        if (Principal.txtNo.getText().isEmpty()) {
            if (!this.xjppersona.IdPersona.isEmpty()) {
                if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                    if (this.JCBProfesional.getSelectedIndex() != -1) {
                        if (this.JCBTipoCita.getSelectedIndex() != -1) {
                            if (this.JTBResultado.getSelectedRow() != -1) {
                                mVerificarEstadoFactura(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4).toString());
                                String sql = "insert into h_atencionespeciales (Fecha_Atencion, Id_TipoConsulta, Id_Atencion, Id_Profesional, Id_Especialidad, Id_Sede,RCargos, Fecha, UsuarioS)values ('" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + this.xidtipocita[this.JCBTipoCita.getSelectedIndex()] + "','" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 0) + "','" + this.xidprofesional[this.JCBProfesional.getSelectedIndex()] + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "','" + this.xTipo + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                Principal.txtNo.setText(this.xconsultas.ejecutarSQLId(sql));
                                this.xconsultas.cerrarConexionBd();
                                mCargarDatosR();
                                if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
                                    mActualizarDatos();
                                }
                                if (this.xTipo == 1) {
                                    JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Ingreso con liquidación de servicios cerrada, no se podrán registrar más cargos;</p><font face='Arial' color='red' size=4>Informar al departamento de facturación", "VERIFICACIÓN DE LIQUIDACIÓN", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                                    return;
                                }
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTBResultado.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTipoCita.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un profesional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBProfesional.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEspecialidad.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe buscar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mVerificarEstadoFactura(String xIdIngreso) {
        try {
            this.xsql = "SELECT `Id` , `Id_Ingreso` , `Estado`\nFROM `f_liquidacion`\nWHERE (`Id_Ingreso` ='" + xIdIngreso + "'  AND `Estado` =0)";
            ResultSet xrs1 = this.xconsultas.traerRs(this.xsql);
            if (xrs1.next()) {
                xrs1.first();
                this.xTipo = 1;
            } else {
                this.xTipo = 0;
            }
            xrs1.close();
            this.xconsultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRegistroAtencionesEsp.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLimpiarComponente() {
        Principal.mLimpiarDatosP();
        this.xestado = false;
        this.JCBTipoCita.removeAllItems();
        this.JCBProfesional.removeAllItems();
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidad = this.xconsultas.llenarCombo("SELECT `IdEspecialidad`, `Especialidad` FROM `profesional1` GROUP BY `IdEspecialidad` ORDER BY `Especialidad` ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBEspecialidad1.setSelectedIndex(-1);
        this.xconsultas.cerrarConexionBd();
        mCrearTabla();
        mCrearTablaR();
        this.JCHFiltro.setSelected(false);
        this.xestado = true;
    }

    private void mActualizarDatos() {
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 5).toString()).longValue() == 3) {
            this.xsql = "UPDATE h_egreso_atencion SET  Estado=2 WHERE Id_Ingreso='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4) + "' AND Id_Tipo='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 5) + "'";
            this.xconsultas.ejecutarSQL(this.xsql);
            this.xconsultas.cerrarConexionBd();
            this.xsql = "update ingreso set Egreso=0, FEgreso= null where Id='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4) + "'";
            this.xconsultas.ejecutarSQL(this.xsql);
            this.xconsultas.cerrarConexionBd();
            return;
        }
        if (Long.valueOf(this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 5).toString()).longValue() == 2) {
            this.xsql = "UPDATE h_egreso_atencion SET  Estado=2 WHERE Id_Ingreso='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4) + "' AND Id_Tipo='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 5) + "'";
            this.xconsultas.ejecutarSQL(this.xsql);
            this.xconsultas.cerrarConexionBd();
            this.xsql = "update ingreso set Egreso_H=0, FEgreso_H= null where Id='" + this.xmodelo.getValueAt(this.JTBResultado.getSelectedRow(), 4) + "'";
            this.xconsultas.ejecutarSQL(this.xsql);
            this.xconsultas.cerrarConexionBd();
        }
    }
}
