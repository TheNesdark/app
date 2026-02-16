package com.genoma.plus.controller.referencia;

import Acceso.Principal;
import General.JD_Impresin_Central_Dc;
import Utilidades.Metodos;
import com.genoma.plus.jpa.projection.IInformeRemision;
import com.genoma.plus.jpa.service.IRemisionesService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/referencia/JIF_Referencia.class */
public class JIF_Referencia extends JInternalFrame {
    private List<Integer> filtro;
    private DefaultTableModel modelo;
    private Object[] dato;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JButton JBTRegistrarSeguimiento;
    private JButton JBT_AbrirHC;
    private JButton JBT_RegistrarSeguimiento;
    private JLabel JLB_NRegistro;
    private JPanel JPIDatos;
    private JPanel JPIFiltro;
    private JPanel JPIFuncionalidades;
    private JPanel JPIUtilidades;
    private JRadioButton JRB_Cerrados;
    private JRadioButton JRB_PorCerrar;
    private JRadioButton JRB_Todos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFPaciente;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatos;
    private final Metodos metodos = new Metodos();
    private final IRemisionesService remisionesService = (IRemisionesService) Principal.contexto.getBean(IRemisionesService.class);

    public JIF_Referencia() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JPIFiltro = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Cerrados = new JRadioButton();
        this.JRB_PorCerrar = new JRadioButton();
        this.JLB_NRegistro = new JLabel();
        this.JTFPaciente = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTPDatos = new JTabbedPane();
        this.JPIFuncionalidades = new JPanel();
        this.JBTRegistrarSeguimiento = new JButton();
        this.JBT_RegistrarSeguimiento = new JButton();
        this.JBT_AbrirHC = new JButton();
        this.JPIUtilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN REFERENCIA");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifReferencia");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBG_Filtro.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setText("Todos");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.1
            public void actionPerformed(ActionEvent evt) {
                JIF_Referencia.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Cerrados);
        this.JRB_Cerrados.setFont(new Font("Arial", 1, 12));
        this.JRB_Cerrados.setText("Cerrados");
        this.JRB_Cerrados.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.2
            public void actionPerformed(ActionEvent evt) {
                JIF_Referencia.this.JRB_CerradosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_PorCerrar);
        this.JRB_PorCerrar.setFont(new Font("Arial", 1, 12));
        this.JRB_PorCerrar.setSelected(true);
        this.JRB_PorCerrar.setText("Pendientes...");
        this.JRB_PorCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.3
            public void actionPerformed(ActionEvent evt) {
                JIF_Referencia.this.JRB_PorCerrarActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JRB_Todos).addGap(18, 18, 18).addComponent(this.JRB_Cerrados).addGap(18, 18, 18).addComponent(this.JRB_PorCerrar).addGap(0, 32, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_Cerrados).addComponent(this.JRB_PorCerrar)).addContainerGap(11, 32767)));
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 12));
        this.JLB_NRegistro.setForeground(Color.red);
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No Registros", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTFPaciente.setFont(new Font("Arial", 1, 12));
        this.JTFPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Paciente o Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPaciente.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.4
            public void keyPressed(KeyEvent evt) {
                JIF_Referencia.this.JTFPacienteKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(23, 23, 23).addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPaciente, -2, 542, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NRegistro, -2, 163, -2).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPIFiltro, -2, -1, -2).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFPaciente, -2, 50, -2)).addComponent(this.JLB_NRegistro, -1, -1, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HÍSTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalle.setFont(new Font("Arial", 1, 14));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JBTRegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBTRegistrarSeguimiento.setForeground(Color.red);
        this.JBTRegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Seguimiento_32.png")));
        this.JBTRegistrarSeguimiento.setText("Seguimiento");
        this.JBTRegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.5
            public void actionPerformed(ActionEvent evt) {
                JIF_Referencia.this.JBTRegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JBT_RegistrarSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JBT_RegistrarSeguimiento.setForeground(Color.red);
        this.JBT_RegistrarSeguimiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_RegistrarSeguimiento.setText("Cierre");
        this.JBT_RegistrarSeguimiento.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.6
            public void actionPerformed(ActionEvent evt) {
                JIF_Referencia.this.JBT_RegistrarSeguimientoActionPerformed(evt);
            }
        });
        this.JBT_AbrirHC.setFont(new Font("Arial", 1, 12));
        this.JBT_AbrirHC.setForeground(Color.red);
        this.JBT_AbrirHC.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.JBT_AbrirHC.setText("Visualización de reportes ");
        this.JBT_AbrirHC.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.7
            public void actionPerformed(ActionEvent evt) {
                JIF_Referencia.this.JBT_AbrirHCActionPerformed(evt);
            }
        });
        GroupLayout JPIFuncionalidadesLayout = new GroupLayout(this.JPIFuncionalidades);
        this.JPIFuncionalidades.setLayout(JPIFuncionalidadesLayout);
        JPIFuncionalidadesLayout.setHorizontalGroup(JPIFuncionalidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFuncionalidadesLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JBTRegistrarSeguimiento, -2, 272, -2).addGap(40, 40, 40).addComponent(this.JBT_RegistrarSeguimiento, -2, 272, -2).addGap(30, 30, 30).addComponent(this.JBT_AbrirHC, -2, 272, -2).addContainerGap(207, 32767)));
        JPIFuncionalidadesLayout.setVerticalGroup(JPIFuncionalidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFuncionalidadesLayout.createSequentialGroup().addContainerGap(7, 32767).addGroup(JPIFuncionalidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTRegistrarSeguimiento, -2, 50, -2).addComponent(this.JBT_RegistrarSeguimiento, -2, 50, -2).addComponent(this.JBT_AbrirHC, -2, 50, -2)).addContainerGap()));
        this.JTPDatos.addTab("FUNCIONALIDADES", this.JPIFuncionalidades);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.8
            public void mouseClicked(MouseEvent evt) {
                JIF_Referencia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.9
            public void actionPerformed(ActionEvent evt) {
                JIF_Referencia.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPIUtilidadesLayout = new GroupLayout(this.JPIUtilidades);
        this.JPIUtilidades.setLayout(JPIUtilidadesLayout);
        JPIUtilidadesLayout.setHorizontalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JTFRuta, -2, 792, -2).addGap(59, 59, 59).addComponent(this.JBTExportar, -2, 211, -2).addContainerGap(39, 32767)));
        JPIUtilidadesLayout.setVerticalGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIUtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPIUtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -2, 50, -2)).addContainerGap(7, 32767)));
        this.JTPDatos.addTab("UTILIDADES", this.JPIUtilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 109, -2).addGap(16, 16, 16)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(0);
        this.filtro.add(1);
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CerradosActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(1);
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_PorCerrarActionPerformed(ActionEvent evt) {
        this.filtro = new ArrayList();
        this.filtro.add(0);
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodos.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.metodos.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRegistrarSeguimientoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_RegistoSeguimiento registoSeguimiento = new JD_RegistoSeguimiento(null, true, Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            registoSeguimiento.setLocationRelativeTo(this);
            registoSeguimiento.setVisible(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_RegistrarSeguimientoActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_RegistoCierre registoCierre = new JD_RegistoCierre(null, true, Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            registoCierre.setLocationRelativeTo(this);
            registoCierre.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AbrirHCActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            JD_Impresin_Central_Dc xjd = new JD_Impresin_Central_Dc(null, true, this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 26).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 27).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 28).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 30).toString(), Integer.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 31).toString()), "");
            xjd.setLocationRelativeTo(this);
            xjd.setVisible(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon("src/Imagenes/Information.png"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPacienteKeyPressed(KeyEvent evt) {
        buscar();
    }

    private void crearTabla() {
        this.modelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.referencia.JIF_Referencia.10
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, Long.class, Integer.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modelo.addColumn("Id");
        this.modelo.addColumn("Fecha_Remision");
        this.modelo.addColumn("Hora_Remision");
        this.modelo.addColumn("Identificacion");
        this.modelo.addColumn("Nombre Usuario");
        this.modelo.addColumn("Edad");
        this.modelo.addColumn("Sexo");
        this.modelo.addColumn("Empresa Convenio");
        this.modelo.addColumn("Servicio");
        this.modelo.addColumn("Especialidad Remite");
        this.modelo.addColumn("Diagnostico Ingreso");
        this.modelo.addColumn("Nombre Patologia");
        this.modelo.addColumn("Especialidad Remitente");
        this.modelo.addColumn("Aceptado");
        this.modelo.addColumn("Profesional Remite");
        this.modelo.addColumn("Profesional Acepta");
        this.modelo.addColumn("Fecha Llegada");
        this.modelo.addColumn("Diagnostico Final");
        this.modelo.addColumn("Auxiliar Remision");
        this.modelo.addColumn("Conductor");
        this.modelo.addColumn("Profesional Remision");
        this.modelo.addColumn("Municipio Destino");
        this.modelo.addColumn("Institucion Recibe");
        this.modelo.addColumn("Observacion");
        this.modelo.addColumn("fechaUbicacion");
        this.modelo.addColumn("fechaSalida");
        this.modelo.addColumn("idAtencion");
        this.modelo.addColumn("idPersona");
        this.modelo.addColumn("idIngreso");
        this.modelo.addColumn("Cerrado");
        this.modelo.addColumn("idTipoAtencion");
        this.modelo.addColumn("idTipoHistoria");
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(21).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(22).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(23).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(25).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(26).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(27).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(28).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(29).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(30).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(31).setPreferredWidth(100);
        this.JTDetalle.setModel(this.modelo);
    }

    private void cargarDatosTabla() {
        List<IInformeRemision> lista = this.remisionesService.listaRemisiones(this.filtro, this.JTFPaciente.getText());
        crearTabla();
        this.JLB_NRegistro.setText("0");
        if (!lista.isEmpty()) {
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 7);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 10);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 17);
            this.metodos.mEstablecerTextEditor(this.JTDetalle, 23);
            lista.forEach(e -> {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(e.getIdRemision(), this.JTDetalle.getRowCount() - 1, 0);
                this.modelo.setValueAt(e.getFecha(), this.JTDetalle.getRowCount() - 1, 1);
                this.modelo.setValueAt(e.getHora(), this.JTDetalle.getRowCount() - 1, 2);
                this.modelo.setValueAt(e.getIdentificacion(), this.JTDetalle.getRowCount() - 1, 3);
                this.modelo.setValueAt(e.getNombreUsuario(), this.JTDetalle.getRowCount() - 1, 4);
                this.modelo.setValueAt(e.getEdad(), this.JTDetalle.getRowCount() - 1, 5);
                this.modelo.setValueAt(e.getSexo(), this.JTDetalle.getRowCount() - 1, 6);
                this.modelo.setValueAt(e.getEmpresaConvenio(), this.JTDetalle.getRowCount() - 1, 7);
                this.modelo.setValueAt(e.getServicio(), this.JTDetalle.getRowCount() - 1, 8);
                this.modelo.setValueAt(e.getEspecialidadRemite(), this.JTDetalle.getRowCount() - 1, 9);
                this.modelo.setValueAt(e.getDiagnosticoIngreso(), this.JTDetalle.getRowCount() - 1, 10);
                this.modelo.setValueAt(e.getNombrePatologia(), this.JTDetalle.getRowCount() - 1, 11);
                this.modelo.setValueAt(e.getEspecialidadRemitente(), this.JTDetalle.getRowCount() - 1, 12);
                this.modelo.setValueAt(e.getAceptado(), this.JTDetalle.getRowCount() - 1, 13);
                this.modelo.setValueAt(e.getProfesionalRemite(), this.JTDetalle.getRowCount() - 1, 14);
                this.modelo.setValueAt(e.getProfesionalAcepta(), this.JTDetalle.getRowCount() - 1, 15);
                this.modelo.setValueAt(e.getFechaLlegada(), this.JTDetalle.getRowCount() - 1, 16);
                this.modelo.setValueAt(e.getDiagnosticoFinal(), this.JTDetalle.getRowCount() - 1, 17);
                this.modelo.setValueAt(e.getAuxiliarRemision(), this.JTDetalle.getRowCount() - 1, 18);
                this.modelo.setValueAt(e.getConductor(), this.JTDetalle.getRowCount() - 1, 19);
                this.modelo.setValueAt(e.getProfesionalRemision(), this.JTDetalle.getRowCount() - 1, 20);
                this.modelo.setValueAt(e.getMunicipioDestino(), this.JTDetalle.getRowCount() - 1, 21);
                this.modelo.setValueAt(e.getInstitucionRecibe(), this.JTDetalle.getRowCount() - 1, 22);
                this.modelo.setValueAt(e.getObservacion(), this.JTDetalle.getRowCount() - 1, 23);
                this.modelo.setValueAt(e.getFechaUbicacion(), this.JTDetalle.getRowCount() - 1, 24);
                this.modelo.setValueAt(e.getFechaSalida(), this.JTDetalle.getRowCount() - 1, 25);
                this.modelo.setValueAt(e.getIdAtencion(), this.JTDetalle.getRowCount() - 1, 26);
                this.modelo.setValueAt(e.getIdPersona(), this.JTDetalle.getRowCount() - 1, 27);
                this.modelo.setValueAt(e.getIdIngreso(), this.JTDetalle.getRowCount() - 1, 28);
                this.modelo.setValueAt(e.getCerrado(), this.JTDetalle.getRowCount() - 1, 29);
                this.modelo.setValueAt(e.getIdTipoAtencion(), this.JTDetalle.getRowCount() - 1, 30);
                this.modelo.setValueAt(e.getIdTipoHistoria(), this.JTDetalle.getRowCount() - 1, 31);
                this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
            });
            this.JLB_NRegistro.setText("" + this.JTDetalle.getRowCount());
            return;
        }
        System.err.println("vacio" + lista);
    }

    public void buscar() {
        cargarDatosTabla();
    }

    public void nuevo() {
        this.JLB_NRegistro.setText("0");
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        this.JTFPaciente.setText("");
        this.JRB_PorCerrar.setSelected(true);
        this.JTFPaciente.setText("");
        this.filtro = new ArrayList();
        this.filtro.add(0);
        buscar();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/referencia/JIF_Referencia$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Integer nvalidacion = Integer.valueOf(table.getValueAt(row, 29).toString());
            switch (nvalidacion.intValue()) {
                case 1:
                    cell.setBackground(Color.GREEN);
                    cell.setForeground(Color.BLACK);
                    break;
                case 2:
                    cell.setBackground(Color.RED);
                    cell.setForeground(Color.BLACK);
                    break;
                default:
                    cell.setBackground(Color.white);
                    cell.setForeground(Color.BLACK);
                    break;
            }
            return cell;
        }
    }
}
