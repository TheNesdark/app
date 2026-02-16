package ImagenesDx;

import Acceso.Principal;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.general.JDGenericoPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ImagenesDx/JIFRecepcion_Rx.class */
public class JIFRecepcion_Rx extends JInternalFrame {
    public Persona frmPersona;
    private DefaultTableModel modelo;
    private String sql;
    public String xIdIngreso;
    private Object[] fila;
    private String[] xidesps;
    private String[] xidprofe;
    private JButton JBTCerrar;
    private JButton JBTConsultarHC;
    private JButton JBTEventoAdverso;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JCheckBox JCHRLEctura;
    private JTable grid;
    private JPanel jPanel1;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel panelPersona;
    public JTextField txtFecha;
    public JTextField txtNoOrden;
    private JEditorPane txtObservaciones;
    private JTextField txtProfesional;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    public String xidnrecepcion = "0";
    private int xrlectura = 0;
    private boolean xtipog = false;
    private boolean xlleno = false;
    private long xidespecialidad = 0;
    private long xidprofesional = 0;

    public JIFRecepcion_Rx() {
        initComponents();
        mNuevo();
    }

    private void mActualizarEstadoRecepOrden() {
        this.sql = "update f_ordenes set EstadoRecep=2, Id_OrdenRecep='" + Principal.txtNo.getText() + "' where Id='" + this.txtNoOrden.getText() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void mBuscarOrden() {
        String idPaciente = "0";
        mCrearTabla();
        this.sql = "SELECT `f_itemordenesproced`.`Id_Procedimiento`, `g_procedimiento`.`Nbre`, `f_itemordenesproced`.`Cantidad`, `f_ordenes`.`FechaOrden`, `profesional1`.`Especialidad`, `profesional1`.`NProfesional`, `f_ordenes`.`Id`, `ingreso`.`Id_Usuario`, `f_ordenes`.Id_OrdenRecep FROM  `f_itemordenesproced` INNER JOIN  `f_ordenes`  ON (`f_itemordenesproced`.`Id_Ordenes` = `f_ordenes`.`Id`) INNER JOIN  `ingreso`  ON (`f_ordenes`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `g_procedimiento`  ON (`f_itemordenesproced`.`Id_Procedimiento` = `g_procedimiento`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `profesional1`  ON (`profesional1`.`Id_Persona` = `f_ordenes`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `f_ordenes`.`Id_Especialidad`) WHERE (`f_ordenes`.`Id` ='" + this.txtNoOrden.getText() + "') ORDER BY `g_procedimiento`.`Nbre` ASC ";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.txtFecha.setText(this.metodos.formatoDMA.format((Date) rs.getDate("FechaOrden")));
                this.txtProfesional.setText(rs.getString("NProfesional"));
                Principal.txtNo.setText(rs.getString("Id_OrdenRecep"));
                idPaciente = rs.getString("Id_Usuario");
                rs.beforeFirst();
                int xnfila = 0;
                while (rs.next()) {
                    this.modelo.addRow(this.fila);
                    this.modelo.setValueAt(rs.getString("Id_Procedimiento"), xnfila, 0);
                    this.modelo.setValueAt(rs.getString("Nbre"), xnfila, 1);
                    this.modelo.setValueAt(rs.getString("Cantidad"), xnfila, 2);
                    this.modelo.setValueAt(true, xnfila, 3);
                    xnfila++;
                }
            }
            rs.close();
            this.consultas.cerrarConexionBd();
            this.frmPersona.setIdPersona(idPaciente);
            this.frmPersona.buscar(1);
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void cargarPanelPersonas() {
        this.frmPersona = new Persona(this);
        this.frmPersona.setVisible(false);
        this.panelPersona.setVisible(false);
        this.frmPersona.setBounds(1, 1, 950, 160);
        this.panelPersona.add(this.frmPersona);
        this.panelPersona.setVisible(true);
        this.frmPersona.setVisible(true);
    }

    private void mCrearTabla() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"Id", "Examen", "Cantidad", "Realizar"}) { // from class: ImagenesDx.JIFRecepcion_Rx.1
            Class[] types = {String.class, String.class, Integer.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(0).setMinWidth(0);
        this.grid.getColumnModel().getColumn(0).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(650);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.grid.getColumnModel().getColumn(2).setMinWidth(0);
        this.grid.getColumnModel().getColumn(2).setMaxWidth(0);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    public void grabar() {
        if (!this.xtipog) {
            if (this.xidnrecepcion.equals("0")) {
                if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && mValidadDatos() == 1) {
                    this.frmPersona.grabar();
                    grabarCabecera();
                    grabarDetalle();
                    mActualizarEstadoRecepOrden();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Orden ya recepcionada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.metodos.getPregunta("Esta seguro de Grabar?") == 0 && mValidadDatos() == 1) {
            this.frmPersona.grabar();
            grabarDetalle();
            mActualizarEstadoRecepOrden();
        }
    }

    private void grabarCabecera() {
        if (this.JCHRLEctura.isSelected()) {
            this.xidespecialidad = Long.valueOf(this.xidesps[this.JCBEspecialidad.getSelectedIndex()]).longValue();
            this.xidprofesional = Long.valueOf(this.xidprofe[this.JCBProfesional.getSelectedIndex()]).longValue();
        }
        this.sql = "INSERT INTO h_radiologia(`Fecha_Rec`, `Id_OrdenFac`, `Observacion`, `Id_Usuario`, `Lectura`, `Id_Especialidad`, `Id_Profesional`, `UsuarioS`) VALUES('" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + this.txtNoOrden.getText() + "','" + this.txtObservaciones.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xrlectura + "','" + this.xidespecialidad + "','" + this.xidprofesional + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        Principal.txtNo.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
    }

    private void grabarDetalle() {
        for (int f = 0; f < this.grid.getRowCount(); f++) {
            if (Integer.parseInt(this.modelo.getValueAt(f, 2).toString()) > 0 && this.modelo.getValueAt(f, 3).equals(true)) {
                this.sql = "INSERT INTO h_radiologia_detalle(`Id_radiologia`, `Id_Procedimiento`, `Cant`) VALUES('" + Principal.txtNo.getText() + "','" + this.modelo.getValueAt(f, 0) + "','" + this.modelo.getValueAt(f, 2) + "')";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
            }
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        cargarPanelPersonas();
        this.frmPersona.panelPersona.setEnabledAt(0, true);
        this.frmPersona.panelPersona.setSelectedIndex(0);
        this.JCBProfesional.removeAllItems();
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidad = 0L;
        this.xidprofesional = 0L;
        this.xidesps = this.consultas.llenarCombo("SELECT `IdEspecialidad`, `Especialidad` FROM  `profesional1` WHERE (`LecturaRx` =1) GROUP BY `IdEspecialidad` ORDER BY `Especialidad` ASC", this.xidesps, this.JCBEspecialidad);
        this.consultas.cerrarConexionBd();
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.frmPersona.txtHistoria.requestFocus();
        this.xlleno = true;
    }

    private int mValidadDatos() {
        int retorno = 0;
        if (this.txtNoOrden.getText() == null || this.txtNoOrden.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite un Número de Orden / Factura");
        } else if (this.txtFecha.getText() == null || this.txtProfesional.getText() == null || this.txtProfesional.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite una Orden que contenga datos");
        } else if (this.grid.getRowCount() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione los Exámenes que desea cargar");
        } else {
            retorno = 1;
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel5 = new JPanel();
        this.panelPersona = new JPanel();
        this.jPanel1 = new JPanel();
        this.txtNoOrden = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.txtObservaciones = new JEditorPane();
        this.txtProfesional = new JTextField();
        this.txtFecha = new JTextField();
        this.JCHRLEctura = new JCheckBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.jScrollPane2 = new JScrollPane();
        this.grid = new JTable();
        this.JBTCerrar = new JButton();
        this.JBTConsultarHC = new JButton();
        this.JBTEventoAdverso = new JButton();
        setBorder(BorderFactory.createBevelBorder(0));
        setClosable(true);
        setTitle("RECEPCIÓN AUTOMATICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(982, 577));
        setMinimumSize(new Dimension(982, 577));
        setName("xjifrecepcionar_rx");
        setNormalBounds(new Rectangle(0, 0, 106, 0));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: ImagenesDx.JIFRecepcion_Rx.2
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRecepcion_Rx.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFRecepcion_Rx.this.formInternalFrameClosed(evt);
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFRecepcion_Rx.this.formInternalFrameActivated(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.panelPersona.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.panelPersona.setFont(new Font("Arial", 1, 12));
        this.panelPersona.setMaximumSize(new Dimension(1000, 160));
        this.panelPersona.setMinimumSize(new Dimension(1000, 160));
        this.panelPersona.setPreferredSize(new Dimension(1000, 160));
        GroupLayout panelPersonaLayout = new GroupLayout(this.panelPersona);
        this.panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        panelPersonaLayout.setVerticalGroup(panelPersonaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 146, 32767));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE LA ORDEN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jPanel1.setFont(new Font("Arial", 1, 12));
        this.txtNoOrden.setFont(new Font("Arial", 1, 12));
        this.txtNoOrden.setHorizontalAlignment(0);
        this.txtNoOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Número de Orden / Factura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoOrden.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx.3
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx.this.txtNoOrdenActionPerformed(evt);
            }
        });
        this.txtNoOrden.addFocusListener(new FocusAdapter() { // from class: ImagenesDx.JIFRecepcion_Rx.4
            public void focusLost(FocusEvent evt) {
                JIFRecepcion_Rx.this.txtNoOrdenFocusLost(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setHorizontalScrollBarPolicy(31);
        this.jScrollPane1.setVerticalScrollBarPolicy(21);
        this.jScrollPane1.setFont(new Font("Arial", 1, 12));
        this.txtObservaciones.setBorder((Border) null);
        this.txtObservaciones.setFont(new Font("Arial", 1, 12));
        this.jScrollPane1.setViewportView(this.txtObservaciones);
        this.txtProfesional.setBackground(new Color(0, 0, 102));
        this.txtProfesional.setFont(new Font("Arial", 1, 12));
        this.txtProfesional.setForeground(new Color(0, 0, 204));
        this.txtProfesional.setHorizontalAlignment(0);
        this.txtProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional que Ordena", 0, 0, new Font("Dialog", 1, 12), new Color(204, 255, 255)));
        this.txtProfesional.setDisabledTextColor(new Color(255, 255, 255));
        this.txtProfesional.setEnabled(false);
        this.txtFecha.setBackground(new Color(0, 0, 102));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.txtFecha.setHorizontalAlignment(0);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Dialog", 1, 12), new Color(204, 255, 255)));
        this.txtFecha.setDisabledTextColor(new Color(255, 255, 255));
        this.txtFecha.setEnabled(false);
        this.txtFecha.setMinimumSize(new Dimension(30, 54));
        this.txtFecha.setPreferredSize(new Dimension(30, 54));
        this.JCHRLEctura.setFont(new Font("Arial", 1, 12));
        this.JCHRLEctura.setText("Requiere Lectura?");
        this.JCHRLEctura.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx.5
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx.this.JCHRLEcturaActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: ImagenesDx.JIFRecepcion_Rx.6
            public void itemStateChanged(ItemEvent evt) {
                JIFRecepcion_Rx.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(4, 4, 4).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtNoOrden, -2, 190, -2).addGap(10, 10, 10).addComponent(this.txtFecha, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JCHRLEctura, -2, 139, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtProfesional, -2, 360, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEspecialidad, 0, -1, 32767).addComponent(this.JCBProfesional, GroupLayout.Alignment.TRAILING, 0, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtNoOrden, -2, 50, -2).addComponent(this.txtFecha, -2, 50, -2).addComponent(this.JCHRLEctura, GroupLayout.Alignment.TRAILING).addComponent(this.JCBEspecialidad, -2, 49, -2)).addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtProfesional).addComponent(this.jScrollPane1).addComponent(this.JCBProfesional, -1, 50, 32767)).addContainerGap()));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.jScrollPane2.setViewportView(this.grid);
        this.JBTCerrar.setFont(new Font("Arial", 1, 12));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx.7
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JBTConsultarHC.setFont(new Font("Arial", 1, 12));
        this.JBTConsultarHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Configuracion29x27.png")));
        this.JBTConsultarHC.setText("<html><P ALIGN=center>Consultar HC");
        this.JBTConsultarHC.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx.8
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx.this.JBTConsultarHCActionPerformed(evt);
            }
        });
        this.JBTEventoAdverso.setFont(new Font("Arial", 1, 12));
        this.JBTEventoAdverso.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Evento Adverso.png")));
        this.JBTEventoAdverso.setText("<html><P ALIGN=center>Caso de Seguridad del Paciente\n");
        this.JBTEventoAdverso.addActionListener(new ActionListener() { // from class: ImagenesDx.JIFRecepcion_Rx.9
            public void actionPerformed(ActionEvent evt) {
                JIFRecepcion_Rx.this.JBTEventoAdversoActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addComponent(this.JBTConsultarHC).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTEventoAdverso, -2, 291, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar, -2, 320, -2)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.panelPersona, -2, 940, -2).addGap(0, 0, 32767)).addComponent(this.jScrollPane2).addComponent(this.jPanel1, -1, -1, 32767)).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.panelPersona, -2, 170, -2).addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addGap(10, 10, 10).addComponent(this.jScrollPane2, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTCerrar, -1, 59, 32767).addComponent(this.JBTConsultarHC).addComponent(this.JBTEventoAdverso)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -2, -1, -2));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel5, -2, -1, -2));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenFocusLost(FocusEvent evt) {
        mBuscarOrden();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoOrdenActionPerformed(ActionEvent evt) {
        this.txtFecha.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        if (getName().equals("xjifrecepcionar_rx") && Principal.claseimagendx.xjifagenda != null) {
            Principal.mLimpiarDatosP();
            Principal.claseimagendx.xjifagenda.cargarDatos();
            Principal.claseimagendx.xjifagenda.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        if (getName().equals("xjifrecepcionar_rx")) {
            if (Principal.claseimagendx.xjifagenda != null) {
                Principal.mLimpiarDatosP();
                Principal.claseimagendx.xjifagenda.cargarDatos();
                Principal.claseimagendx.xjifagenda.setVisible(true);
                Principal.claseimagendx.xjifagenda.JRBTodas.setSelected(true);
                dispose();
                return;
            }
            return;
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTConsultarHCActionPerformed(ActionEvent evt) {
        Principal.claseimagendx.cargarPantalla("Consultar HC");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        if (getName().equals("xjifrecepcionar_rx") && Principal.claseimagendx.xjifagenda != null) {
            Principal.mLimpiarDatosP();
            Principal.claseimagendx.xjifagenda.setVisible(true);
            Principal.claseimagendx.xjifagenda.JRBTodas.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRLEcturaActionPerformed(ActionEvent evt) {
        if (this.JCHRLEctura.isSelected()) {
            this.xrlectura = 1;
        } else {
            this.xrlectura = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            this.xidprofe = this.consultas.llenarCombo("SELECT `Id_Persona`, `NProfesional` FROM `profesional1` WHERE (`IdEspecialidad` ='" + this.xidesps[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY `NProfesional` ASC", this.xidesps, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEventoAdversoActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            mTraerIngreso();
            JDGenericoPanel detalle = new JDGenericoPanel(null, true, "Evento Adverso", this.xIdIngreso, 29);
            detalle.setLocationRelativeTo(this);
            detalle.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Se debe cargar un registro", "Verificar", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mTraerIngreso() {
        this.sql = "SELECT `Id_Ingreso` FROM `f_ordenes` WHERE (`Id` ='" + this.txtNoOrden.getText() + "');";
        ResultSet rs = this.consultas.traerRs(this.sql);
        try {
            if (rs.next()) {
                this.xIdIngreso = rs.getString("Id_Ingreso");
            }
            rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }
}
