package ParametrizacionN;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIF_HTipo_Notas.class */
public class JIF_HTipo_Notas extends JInternalFrame {
    private String xsql;
    private String[] xId_Especialidad;
    private String[] xIdClasificacion;
    private DefaultTableModel xModelo_Especialidad;
    private DefaultTableModel xModelo_NPredefinida;
    private DefaultTableModel xModelo_Historico;
    private Object[] xDatos;
    private JButton JBT_EAdicionar;
    private JButton JBT_EAdicionar1;
    private JButton JBT_PAdicionar;
    private JButton JBT_PNuevo;
    private JComboBox JCBClasificacion;
    private JComboBox JCB_EEspecialidad;
    private JCheckBox JCH_EEstado;
    private JCheckBox JCH_EInterconsulta;
    private JCheckBox JCH_EsQx;
    private JCheckBox JCH_Estado;
    private JCheckBox JCH_PEstado;
    private JPanel JPI_DNota;
    private JPanel JPI_Datos;
    private JPanel JPI_EEspecialdiad;
    private JPanel JPI_Especialidad;
    private JPanel JPI_Historico;
    private JPanel JPI_NPredefinidas;
    private JPanel JPI_PDatos;
    private JScrollPane JSP_EDetalle;
    private JSpinner JSP_ENOrden;
    private JScrollPane JSP_Historico;
    private JScrollPane JSP_PDescripcion;
    private JScrollPane JSP_PDetalle;
    private JSpinner JSP_PNOrden;
    private JTextArea JTA_PDescripcion;
    private JTabbedPane JTB_Datos_P;
    private JTable JTB_EDetalle_Especialidad;
    private JTable JTB_Historico;
    private JTable JTB_PDetalle_NPredefinidas;
    private JTextField JTF_ECodigo;
    private JTextField JTF_EIdHistoria;
    private JTextField JTF_NReporte;
    private JTextField JTF_Nombre;
    private JTextField JTF_PNombre;
    private JTabbedPane JTP_Datos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xEstado = 1;
    private int xEs_Qx = 0;
    private int xEEstado = 1;
    private int xPEstado = 1;
    private int xEInterconsulta = 0;
    private long xId_Comentario = 0;
    private boolean xGrabar_Especialidad = false;
    private boolean XGrabar_NPredefinidas = false;

    public JIF_HTipo_Notas() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v133, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v157, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v79, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTB_Datos_P = new JTabbedPane();
        this.JPI_Datos = new JPanel();
        this.JPI_DNota = new JPanel();
        this.JTF_Nombre = new JTextField();
        this.JCH_EsQx = new JCheckBox();
        this.JCH_Estado = new JCheckBox();
        this.JTF_NReporte = new JTextField();
        this.JCBClasificacion = new JComboBox();
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Especialidad = new JPanel();
        this.JPI_EEspecialdiad = new JPanel();
        this.JTF_ECodigo = new JTextField();
        this.JSP_ENOrden = new JSpinner();
        this.JBT_EAdicionar = new JButton();
        this.JCB_EEspecialidad = new JComboBox();
        this.JTF_EIdHistoria = new JTextField();
        this.JCH_EEstado = new JCheckBox();
        this.JBT_EAdicionar1 = new JButton();
        this.JCH_EInterconsulta = new JCheckBox();
        this.JSP_EDetalle = new JScrollPane();
        this.JTB_EDetalle_Especialidad = new JTable();
        this.JPI_NPredefinidas = new JPanel();
        this.JPI_PDatos = new JPanel();
        this.JTF_PNombre = new JTextField();
        this.JCH_PEstado = new JCheckBox();
        this.JSP_PNOrden = new JSpinner();
        this.JSP_PDescripcion = new JScrollPane();
        this.JTA_PDescripcion = new JTextArea();
        this.JBT_PNuevo = new JButton();
        this.JBT_PAdicionar = new JButton();
        this.JSP_PDetalle = new JScrollPane();
        this.JTB_PDetalle_NPredefinidas = new JTable();
        this.JPI_Historico = new JPanel();
        this.JSP_Historico = new JScrollPane();
        this.JTB_Historico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPOS DE NOTAS CLÍNICAS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjif_Notas_clinicas");
        this.JTB_Datos_P.setForeground(Color.red);
        this.JTB_Datos_P.setFont(new Font("Arial", 1, 14));
        this.JPI_DNota.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN NOTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_Nombre.setFont(new Font("Arial", 1, 12));
        this.JTF_Nombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_EsQx.setFont(new Font("Arial", 1, 12));
        this.JCH_EsQx.setText("Es Qx?");
        this.JCH_EsQx.setToolTipText("Realizar notas de cirugìa");
        this.JCH_EsQx.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.1
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JCH_EsQxActionPerformed(evt);
            }
        });
        this.JCH_Estado.setFont(new Font("Arial", 1, 12));
        this.JCH_Estado.setText("Estado");
        this.JCH_Estado.setToolTipText("Realizar notas de cirugìa");
        this.JCH_Estado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.2
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JCH_EstadoActionPerformed(evt);
            }
        });
        this.JTF_NReporte.setFont(new Font("Arial", 1, 12));
        this.JTF_NReporte.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del reporte a visualizar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion", 1, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPI_DNotaLayout = new GroupLayout(this.JPI_DNota);
        this.JPI_DNota.setLayout(JPI_DNotaLayout);
        JPI_DNotaLayout.setHorizontalGroup(JPI_DNotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNotaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DNotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNotaLayout.createSequentialGroup().addComponent(this.JTF_NReporte, -2, 516, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClasificacion, 0, -1, 32767)).addGroup(JPI_DNotaLayout.createSequentialGroup().addComponent(this.JTF_Nombre, -1, 645, 32767).addGap(18, 18, 18).addComponent(this.JCH_EsQx).addGap(10, 10, 10).addComponent(this.JCH_Estado))).addContainerGap()));
        JPI_DNotaLayout.setVerticalGroup(JPI_DNotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNotaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DNotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DNotaLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPI_DNotaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_EsQx).addComponent(this.JCH_Estado))).addComponent(this.JTF_Nombre, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_DNotaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_NReporte, -2, 50, -2).addComponent(this.JCBClasificacion, -2, 50, -2)).addContainerGap(16, 32767)));
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_EEspecialdiad.setBorder(BorderFactory.createEtchedBorder());
        this.JTF_ECodigo.setFont(new Font("Arial", 1, 12));
        this.JTF_ECodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código Cups", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_ECodigo.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIF_HTipo_Notas.3
            public void keyTyped(KeyEvent evt) {
                JIF_HTipo_Notas.this.JTF_ECodigoKeyTyped(evt);
            }
        });
        this.JSP_ENOrden.setFont(new Font("Arial", 1, 12));
        this.JSP_ENOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSP_ENOrden.setToolTipText("Orden de la Cirugía");
        this.JSP_ENOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_EAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_EAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_EAdicionar.setText("Adicionar");
        this.JBT_EAdicionar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.4
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JBT_EAdicionarActionPerformed(evt);
            }
        });
        this.JCB_EEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCB_EEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_EEspecialidad.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.5
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JCB_EEspecialidadActionPerformed(evt);
            }
        });
        this.JTF_EIdHistoria.setFont(new Font("Arial", 1, 12));
        this.JTF_EIdHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Historia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF_EIdHistoria.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIF_HTipo_Notas.6
            public void keyTyped(KeyEvent evt) {
                JIF_HTipo_Notas.this.JTF_EIdHistoriaKeyTyped(evt);
            }
        });
        this.JCH_EEstado.setFont(new Font("Arial", 1, 12));
        this.JCH_EEstado.setText("Estado");
        this.JCH_EEstado.setToolTipText("Realizar notas de cirugìa");
        this.JCH_EEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.7
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JCH_EEstadoActionPerformed(evt);
            }
        });
        this.JBT_EAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBT_EAdicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_EAdicionar1.setText("Nuevo");
        this.JBT_EAdicionar1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.8
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JBT_EAdicionar1ActionPerformed(evt);
            }
        });
        this.JCH_EInterconsulta.setFont(new Font("Arial", 1, 12));
        this.JCH_EInterconsulta.setText("Es Interconsulta ?");
        this.JCH_EInterconsulta.setToolTipText("Realizar notas de cirugìa");
        this.JCH_EInterconsulta.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.9
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JCH_EInterconsultaActionPerformed(evt);
            }
        });
        GroupLayout JPI_EEspecialdiadLayout = new GroupLayout(this.JPI_EEspecialdiad);
        this.JPI_EEspecialdiad.setLayout(JPI_EEspecialdiadLayout);
        JPI_EEspecialdiadLayout.setHorizontalGroup(JPI_EEspecialdiadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEspecialdiadLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EEspecialdiadLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_EEspecialdiadLayout.createSequentialGroup().addComponent(this.JCB_EEspecialidad, -2, 558, -2).addGap(11, 11, 11)).addGroup(JPI_EEspecialdiadLayout.createSequentialGroup().addComponent(this.JTF_EIdHistoria, -2, 100, -2).addGap(18, 18, 18).addComponent(this.JCH_EEstado).addGap(18, 18, 18).addComponent(this.JCH_EInterconsulta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_EAdicionar1, -2, 178, -2).addGap(32, 32, 32))).addGroup(JPI_EEspecialdiadLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPI_EEspecialdiadLayout.createSequentialGroup().addComponent(this.JTF_ECodigo, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JSP_ENOrden, -2, 51, -2)).addComponent(this.JBT_EAdicionar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPI_EEspecialdiadLayout.setVerticalGroup(JPI_EEspecialdiadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEspecialdiadLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EEspecialdiadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF_ECodigo, -2, 50, -2).addComponent(this.JSP_ENOrden, -2, 50, -2).addComponent(this.JCB_EEspecialidad, -2, 51, -2)).addGroup(JPI_EEspecialdiadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEspecialdiadLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_EIdHistoria, -2, 50, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI_EEspecialdiadLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addGroup(JPI_EEspecialdiadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_EAdicionar, -2, 47, -2).addComponent(this.JBT_EAdicionar1, -2, 47, -2).addComponent(this.JCH_EInterconsulta).addComponent(this.JCH_EEstado)).addGap(25, 25, 25)))));
        this.JSP_EDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_EDetalle_Especialidad.setFont(new Font("Arial", 1, 12));
        this.JTB_EDetalle_Especialidad.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_EDetalle_Especialidad.setRowHeight(25);
        this.JTB_EDetalle_Especialidad.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_EDetalle_Especialidad.setSelectionForeground(Color.red);
        this.JTB_EDetalle_Especialidad.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIF_HTipo_Notas.10
            public void mouseClicked(MouseEvent evt) {
                JIF_HTipo_Notas.this.JTB_EDetalle_EspecialidadMouseClicked(evt);
            }
        });
        this.JSP_EDetalle.setViewportView(this.JTB_EDetalle_Especialidad);
        GroupLayout JPI_EspecialidadLayout = new GroupLayout(this.JPI_Especialidad);
        this.JPI_Especialidad.setLayout(JPI_EspecialidadLayout);
        JPI_EspecialidadLayout.setHorizontalGroup(JPI_EspecialidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EspecialidadLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EspecialidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_EEspecialdiad, -1, -1, 32767).addComponent(this.JSP_EDetalle)).addContainerGap()));
        JPI_EspecialidadLayout.setVerticalGroup(JPI_EspecialidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EspecialidadLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_EEspecialdiad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_EDetalle, -1, 187, 32767).addContainerGap()));
        this.JTP_Datos.addTab("ESPECIALIDADES", this.JPI_Especialidad);
        this.JPI_PDatos.setBorder(BorderFactory.createEtchedBorder());
        this.JTF_PNombre.setFont(new Font("Arial", 1, 12));
        this.JTF_PNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_PEstado.setFont(new Font("Arial", 1, 12));
        this.JCH_PEstado.setSelected(true);
        this.JCH_PEstado.setText("Estado");
        this.JCH_PEstado.setToolTipText("Realizar notas de cirugìa");
        this.JCH_PEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.11
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JCH_PEstadoActionPerformed(evt);
            }
        });
        this.JSP_PNOrden.setFont(new Font("Arial", 1, 12));
        this.JSP_PNOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSP_PNOrden.setToolTipText("Orden de la Cirugía");
        this.JSP_PNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_PDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_PDescripcion.setAutoscrolls(true);
        this.JTA_PDescripcion.setColumns(20);
        this.JTA_PDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTA_PDescripcion.setLineWrap(true);
        this.JTA_PDescripcion.setRows(1);
        this.JTA_PDescripcion.setTabSize(1);
        this.JSP_PDescripcion.setViewportView(this.JTA_PDescripcion);
        this.JBT_PNuevo.setFont(new Font("Arial", 1, 12));
        this.JBT_PNuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo29x25.png")));
        this.JBT_PNuevo.setText("Nuevo");
        this.JBT_PNuevo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.12
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JBT_PNuevoActionPerformed(evt);
            }
        });
        this.JBT_PAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_PAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_PAdicionar.setText("Adicionar");
        this.JBT_PAdicionar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIF_HTipo_Notas.13
            public void actionPerformed(ActionEvent evt) {
                JIF_HTipo_Notas.this.JBT_PAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPI_PDatosLayout = new GroupLayout(this.JPI_PDatos);
        this.JPI_PDatos.setLayout(JPI_PDatosLayout);
        JPI_PDatosLayout.setHorizontalGroup(JPI_PDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_PDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PDatosLayout.createSequentialGroup().addComponent(this.JTF_PNombre, -2, 481, -2).addGap(18, 18, 18).addComponent(this.JCH_PEstado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_PNOrden, -2, 50, -2).addGap(18, 18, 32767)).addGroup(JPI_PDatosLayout.createSequentialGroup().addComponent(this.JSP_PDescripcion).addGap(26, 26, 26))).addGroup(JPI_PDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_PAdicionar, -1, -1, 32767).addComponent(this.JBT_PNuevo, -1, -1, 32767)).addContainerGap()));
        JPI_PDatosLayout.setVerticalGroup(JPI_PDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_PDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPI_PDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSP_PNOrden).addGroup(JPI_PDatosLayout.createSequentialGroup().addGap(0, 8, 32767).addGroup(JPI_PDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTF_PNombre, -2, 50, -2).addComponent(this.JCH_PEstado))).addComponent(this.JBT_PNuevo, -1, -1, 32767)).addGap(18, 18, 18).addGroup(JPI_PDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_PDescripcion).addGroup(JPI_PDatosLayout.createSequentialGroup().addGap(0, 27, 32767).addComponent(this.JBT_PAdicionar, -2, 52, -2))).addGap(13, 13, 13)));
        this.JSP_PDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTB_PDetalle_NPredefinidas.setFont(new Font("Arial", 1, 12));
        this.JTB_PDetalle_NPredefinidas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_PDetalle_NPredefinidas.setRowHeight(25);
        this.JTB_PDetalle_NPredefinidas.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_PDetalle_NPredefinidas.setSelectionForeground(Color.red);
        this.JTB_PDetalle_NPredefinidas.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIF_HTipo_Notas.14
            public void mouseClicked(MouseEvent evt) {
                JIF_HTipo_Notas.this.JTB_PDetalle_NPredefinidasMouseClicked(evt);
            }
        });
        this.JSP_PDetalle.setViewportView(this.JTB_PDetalle_NPredefinidas);
        GroupLayout JPI_NPredefinidasLayout = new GroupLayout(this.JPI_NPredefinidas);
        this.JPI_NPredefinidas.setLayout(JPI_NPredefinidasLayout);
        JPI_NPredefinidasLayout.setHorizontalGroup(JPI_NPredefinidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NPredefinidasLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NPredefinidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_PDatos, -1, -1, 32767).addComponent(this.JSP_PDetalle, -1, 807, 32767)).addContainerGap()));
        JPI_NPredefinidasLayout.setVerticalGroup(JPI_NPredefinidasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NPredefinidasLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_PDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_PDetalle, -2, 162, -2).addContainerGap()));
        this.JTP_Datos.addTab("NOTAS PREDEFINIDAS", this.JPI_NPredefinidas);
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_DNota, -1, -1, 32767).addComponent(this.JTP_Datos)).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JPI_DNota, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTP_Datos).addContainerGap()));
        this.JTP_Datos.getAccessibleContext().setAccessibleName("NOTAS PREDEFINIDAS");
        this.JTB_Datos_P.addTab("DATOS", this.JPI_Datos);
        this.JTB_Historico.setFont(new Font("Arial", 1, 12));
        this.JTB_Historico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_Historico.setRowHeight(25);
        this.JTB_Historico.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_Historico.setSelectionForeground(Color.red);
        this.JTB_Historico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIF_HTipo_Notas.15
            public void mouseClicked(MouseEvent evt) {
                JIF_HTipo_Notas.this.JTB_HistoricoMouseClicked(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTB_Historico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 875, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSP_Historico, -2, 825, -2).addContainerGap(-1, 32767))));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 623, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_HistoricoLayout.createSequentialGroup().addContainerGap(40, 32767).addComponent(this.JSP_Historico, -2, 544, -2).addContainerGap(-1, 32767))));
        this.JTB_Datos_P.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos_P).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTB_Datos_P).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EsQxActionPerformed(ActionEvent evt) {
        mIniciarCheckBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EstadoActionPerformed(ActionEvent evt) {
        mIniciarCheckBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_HistoricoMouseClicked(MouseEvent evt) {
        if (this.JTB_Historico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 0).toString());
            this.JTF_Nombre.setText(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 1).toString());
            this.JCH_EsQx.setSelected(Boolean.valueOf(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 2).toString()).booleanValue());
            this.JTF_NReporte.setText(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 3).toString());
            this.JCH_Estado.setSelected(Boolean.valueOf(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 4).toString()).booleanValue());
            this.JCBClasificacion.setSelectedItem(this.xModelo_Historico.getValueAt(this.JTB_Historico.getSelectedRow(), 5).toString());
            mIniciarCheckBox();
            mCargarDatos_Especialidad();
            mCargarDatos_NPredefinida();
            this.JTB_Datos_P.setSelectedIndex(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_EAdicionarActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (this.JCB_EEspecialidad.getSelectedIndex() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                if (x == 0) {
                    if (!this.xGrabar_Especialidad) {
                        this.xsql = "insert into h_tiponota_especialidad ( `Id_TipoNota` , `Id_Especialidad` , `Id_Procedimiento` , `Id_Historia` , `Orden`, EsInterconsulta , `Estado` , `UsuarioS` ) values('" + Principal.txtNo.getText() + "','" + this.xId_Especialidad[this.JCB_EEspecialidad.getSelectedIndex()] + "','" + this.JTF_ECodigo.getText() + "','" + this.JTF_EIdHistoria.getText() + "','" + this.JSP_ENOrden.getValue() + "','" + this.xEInterconsulta + "','" + this.xEEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    } else {
                        this.xsql = "update h_tiponota_especialidad set `Id_Procedimiento`='" + this.JTF_ECodigo.getText() + "' , `Id_Historia`='" + this.JTF_EIdHistoria.getText() + "' , `Orden`='" + this.JSP_ENOrden.getValue() + "' , `Esinterconsulta`='" + this.xEInterconsulta + "' , `Estado`='" + this.xEEstado + "' , `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' where `Id_TipoNota`='" + Principal.txtNo.getText() + "' and `Id_Especialidad`='" + this.xId_Especialidad[this.JCB_EEspecialidad.getSelectedIndex()] + "'";
                    }
                }
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                mCargarDatos_Especialidad();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCB_EEspecialidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheckBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_EDetalle_EspecialidadMouseClicked(MouseEvent evt) {
        if (this.JTB_EDetalle_Especialidad.getSelectedRow() != -1) {
            this.xGrabar_Especialidad = true;
            this.JCB_EEspecialidad.setSelectedItem(this.xModelo_Especialidad.getValueAt(this.JTB_EDetalle_Especialidad.getSelectedRow(), 0));
            this.JTF_ECodigo.setText(this.xModelo_Especialidad.getValueAt(this.JTB_EDetalle_Especialidad.getSelectedRow(), 1).toString());
            this.JTF_EIdHistoria.setText(this.xModelo_Especialidad.getValueAt(this.JTB_EDetalle_Especialidad.getSelectedRow(), 2).toString());
            this.JSP_ENOrden.setValue(Integer.valueOf(this.xModelo_Especialidad.getValueAt(this.JTB_EDetalle_Especialidad.getSelectedRow(), 3).toString()));
            this.JCH_EInterconsulta.setSelected(Boolean.valueOf(this.xModelo_Especialidad.getValueAt(this.JTB_EDetalle_Especialidad.getSelectedRow(), 4).toString()).booleanValue());
            this.JCH_EEstado.setSelected(Boolean.valueOf(this.xModelo_Especialidad.getValueAt(this.JTB_EDetalle_Especialidad.getSelectedRow(), 5).toString()).booleanValue());
            mIniciarCheckBox();
            return;
        }
        this.xGrabar_Especialidad = false;
        this.JCB_EEspecialidad.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_EAdicionar1ActionPerformed(ActionEvent evt) {
        mNuevo_Especialidad();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_PAdicionarActionPerformed(ActionEvent evt) {
        if (!Principal.txtNo.getText().isEmpty()) {
            if (!this.JTF_PNombre.getText().isEmpty()) {
                if (!this.JTA_PDescripcion.getText().isEmpty()) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                    if (x == 0) {
                        if (this.xId_Comentario == 0) {
                            this.xsql = "insert into h_tiponota_comentario ( `Id_TipoNota` , `Nbre` , `Descripcion` , `NOrden` , `Estado` , `UsuarioS` ) values('" + Principal.txtNo.getText() + "','" + this.JTF_PNombre.getText() + "','" + this.JTA_PDescripcion.getText() + "','" + this.JSP_PNOrden.getValue() + "','" + this.xPEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            this.xsql = "update h_tiponota_comentario set `Nbre`='" + this.JTF_PNombre.getText() + "' , `Descripcion`='" + this.JTA_PDescripcion.getText() + "' , `NOrden`='" + this.JSP_PNOrden.getValue() + "' , `Estado`='" + this.xEEstado + "' , `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' where `Id`='" + this.xId_Comentario + "' ";
                        }
                    }
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mCargarDatos_NPredefinida();
                    mNuevo_NPredefinida();
                    this.JTF_PNombre.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Descripción no puede estas en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTA_PDescripcion.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Nombre no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_PNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PEstadoActionPerformed(ActionEvent evt) {
        mIniciarCheckBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_PNuevoActionPerformed(ActionEvent evt) {
        mNuevo_NPredefinida();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_PDetalle_NPredefinidasMouseClicked(MouseEvent evt) {
        if (this.JTB_PDetalle_NPredefinidas.getSelectedRow() != -1) {
            this.xId_Comentario = Long.valueOf(this.xModelo_NPredefinida.getValueAt(this.JTB_PDetalle_NPredefinidas.getSelectedRow(), 0).toString()).longValue();
            this.JTF_PNombre.setText(this.xModelo_NPredefinida.getValueAt(this.JTB_PDetalle_NPredefinidas.getSelectedRow(), 1).toString());
            this.JTA_PDescripcion.setText(this.xModelo_NPredefinida.getValueAt(this.JTB_PDetalle_NPredefinidas.getSelectedRow(), 2).toString());
            this.JSP_PNOrden.setValue(Long.valueOf(this.xModelo_NPredefinida.getValueAt(this.JTB_PDetalle_NPredefinidas.getSelectedRow(), 3).toString()));
            this.JCH_EEstado.setSelected(Boolean.valueOf(this.xModelo_NPredefinida.getValueAt(this.JTB_PDetalle_NPredefinidas.getSelectedRow(), 4).toString()).booleanValue());
            return;
        }
        this.xId_Comentario = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_EInterconsultaActionPerformed(ActionEvent evt) {
        mIniciarCheckBox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_ECodigoKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_ECodigo.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_ECodigo.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_EIdHistoriaKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_EIdHistoria.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTF_EIdHistoria.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EEspecialidadActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTF_Nombre.setText("");
        this.JTF_NReporte.setText("");
        this.xEs_Qx = 0;
        this.xEstado = 1;
        this.JCH_EsQx.setSelected(false);
        this.JCH_Estado.setSelected(true);
        this.JCBClasificacion.removeAllItems();
        this.xsql = "SELECT `Id`, `Nbre` FROM `h_tiponota_clasificacion` WHERE (`Estado` =1) ORDER BY `Nbre` ASC;";
        this.xIdClasificacion = this.xct.llenarCombo(this.xsql, this.xIdClasificacion, this.JCBClasificacion);
        mCargarDatos_Historico();
        mCrearModelo_Especialidad();
        this.JTF_Nombre.requestFocus();
        mNuevo_Especialidad();
    }

    private void mIniciarCheckBox() {
        if (this.JCH_EEstado.isSelected()) {
            this.xEEstado = 1;
        } else {
            this.xEEstado = 0;
        }
        if (this.JCH_PEstado.isSelected()) {
            this.xPEstado = 1;
        } else {
            this.xPEstado = 0;
        }
        if (this.JCH_Estado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
        if (this.JCH_EsQx.isSelected()) {
            this.xEs_Qx = 1;
        } else {
            this.xEs_Qx = 0;
        }
        if (this.JCH_EInterconsulta.isSelected()) {
            this.xEInterconsulta = 1;
        } else {
            this.xEInterconsulta = 0;
        }
    }

    public void mGrabar() {
        if (!this.JTF_Nombre.getText().isEmpty()) {
            if (this.JCBClasificacion.getSelectedIndex() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0);
                if (x == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.xsql = "insert into h_tiponota( `Nbre` , `Es_Qx` , `NReporte`, Id_Clasificacion , `Estado` , `UsuarioS` , `Id_UsuarioS`) values('" + this.JTF_Nombre.getText() + "','" + this.xEs_Qx + "','" + this.JTF_NReporte.getText() + "','" + this.xIdClasificacion[this.JCBClasificacion.getSelectedIndex()] + "','" + this.xEstado + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                        Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
                        this.xct.cerrarConexionBd();
                    } else {
                        this.xsql = "update h_tiponota set `Nbre`='" + this.JTF_Nombre.getText() + "', `Es_Qx`='" + this.xEs_Qx + "' , `NReporte`='" + this.JTF_NReporte.getText() + "' , `Id_Clasificacion`='" + this.xIdClasificacion[this.JCBClasificacion.getSelectedIndex()] + "' , `Estado`='" + this.xEstado + "' , `UsuarioS`='" + Principal.usuarioSistemaDTO.getLogin() + "' , `Id_UsuarioS`='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "' where Id='" + Principal.txtNo.getText() + "'";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                    mCargarDatos_Historico();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una Clasificacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe digitar un Nombres", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xModelo_Historico = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "EsQx", "NReporte", "Estado", "Clasificacion"}) { // from class: ParametrizacionN.JIF_HTipo_Notas.16
            Class[] types = {Long.class, String.class, Boolean.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_Historico.setModel(this.xModelo_Historico);
        this.JTB_Historico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTB_Historico.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTB_Historico.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_Historico.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void mCargarDatos_Historico() {
        try {
            mCrearModeloHistorico();
            this.xsql = "SELECT\n    `h_tiponota`.`Id`\n    , `h_tiponota`.`Nbre`\n    , `h_tiponota`.`Es_Qx`\n    , `h_tiponota`.`NReporte`\n    , `h_tiponota`.`Estado`\n    , `h_tiponota_clasificacion`.`Nbre` AS `Clasificacion`\nFROM\n    `h_tiponota`\n    INNER JOIN `h_tiponota_clasificacion` \n        ON (`h_tiponota`.`Id_Clasificacion` = `h_tiponota_clasificacion`.`Id`)\nORDER BY `h_tiponota`.`Nbre` ASC;";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xModelo_Historico.addRow(this.xDatos);
                    this.xModelo_Historico.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo_Historico.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Historico.setValueAt(Boolean.valueOf(xrs.getBoolean(3)), x, 2);
                    this.xModelo_Historico.setValueAt(xrs.getString(4), x, 3);
                    this.xModelo_Historico.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), x, 4);
                    this.xModelo_Historico.setValueAt(xrs.getString(6), x, 5);
                    x++;
                }
            } else {
                mCrearModeloHistorico();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_HTipo_Notas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mNuevo_Especialidad() {
        this.JCB_EEspecialidad.removeAllItems();
        this.xsql = "SELECT `Id` , `Nbre` FROM `g_especialidad` WHERE (`Estado` =0) ORDER BY `Nbre` ASC";
        this.xId_Especialidad = this.xct.llenarCombo(this.xsql, this.xId_Especialidad, this.JCB_EEspecialidad);
        this.xct.cerrarConexionBd();
        this.JCB_EEspecialidad.setSelectedIndex(-1);
        this.JTF_ECodigo.setText("0");
        this.JTF_EIdHistoria.setText("0");
        this.JSP_ENOrden.setValue(new Integer(0));
        this.JCH_EEstado.setSelected(true);
        this.xEInterconsulta = 0;
        this.JCH_EInterconsulta.setSelected(false);
        mIniciarCheckBox();
        this.xGrabar_Especialidad = false;
    }

    private void mNuevo_NPredefinida() {
        this.JTF_PNombre.setText("");
        this.xId_Comentario = 0L;
        this.JSP_PNOrden.setValue(new Integer(0));
        this.JTA_PDescripcion.setText("");
        this.JCH_PEstado.setSelected(true);
        mIniciarCheckBox();
        this.XGrabar_NPredefinidas = false;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_Especialidad() {
        this.xModelo_Especialidad = new DefaultTableModel(new Object[0], new String[]{"Especialidad", "Cups", "Id_Historia", "N° Orden", "Es Interconsulta", "Estado"}) { // from class: ParametrizacionN.JIF_HTipo_Notas.17
            Class[] types = {String.class, String.class, String.class, Long.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_EDetalle_Especialidad.setModel(this.xModelo_Especialidad);
        this.JTB_EDetalle_Especialidad.getColumnModel().getColumn(0).setPreferredWidth(250);
        this.JTB_EDetalle_Especialidad.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTB_EDetalle_Especialidad.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTB_EDetalle_Especialidad.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTB_EDetalle_Especialidad.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTB_EDetalle_Especialidad.getColumnModel().getColumn(5).setPreferredWidth(10);
    }

    private void mCargarDatos_Especialidad() {
        try {
            mCrearModelo_Especialidad();
            this.xsql = "SELECT`g_especialidad`.`Nbre`  AS `especialidad`, `h_tiponota_especialidad`.`Id_Procedimiento`, `h_tiponota_especialidad`.`Id_Historia` , `h_tiponota_especialidad`.`Orden`\n, `h_tiponota_especialidad`.`EsInterconsulta`, `h_tiponota_especialidad`.`Estado`FROM`baseserver`.`h_tiponota_especialidad`INNER JOIN `baseserver`.`h_tiponota` \nON (`h_tiponota_especialidad`.`Id_TipoNota` ='" + Principal.txtNo.getText() + "')INNER JOIN `baseserver`.`g_especialidad` ON (`h_tiponota_especialidad`.`Id_Especialidad` = `g_especialidad`.`Id`) GROUP BY `g_especialidad`.`Nbre` ;";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                while (xrs.next()) {
                    this.xModelo_Especialidad.addRow(this.xDatos);
                    this.xModelo_Especialidad.setValueAt(xrs.getString(1), x, 0);
                    this.xModelo_Especialidad.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_Especialidad.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_Especialidad.setValueAt(Long.valueOf(xrs.getLong(4)), x, 3);
                    this.xModelo_Especialidad.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), x, 4);
                    this.xModelo_Especialidad.setValueAt(Boolean.valueOf(xrs.getBoolean(6)), x, 5);
                    x++;
                }
            } else {
                mCrearModelo_Especialidad();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_HTipo_Notas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo_NPredefinida() {
        this.xModelo_NPredefinida = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Descripción", "N° Orden", "Estado"}) { // from class: ParametrizacionN.JIF_HTipo_Notas.18
            Class[] types = {Long.class, String.class, String.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_PDetalle_NPredefinidas.setModel(this.xModelo_NPredefinida);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatos_NPredefinida() {
        try {
            mCrearModelo_NPredefinida();
            this.xsql = "SELECT  `Id` , `Nbre` , `Descripcion` , `NOrden` , `Estado` FROM `h_tiponota_comentario` WHERE (`Id_TipoNota` ='" + Principal.txtNo.getText() + "') ORDER BY `Nbre` ASC";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int x = 0;
                this.xmt.mEstablecerTextEditor(this.JTB_PDetalle_NPredefinidas, 2);
                while (xrs.next()) {
                    this.xModelo_NPredefinida.addRow(this.xDatos);
                    this.xModelo_NPredefinida.setValueAt(Long.valueOf(xrs.getLong(1)), x, 0);
                    this.xModelo_NPredefinida.setValueAt(xrs.getString(2), x, 1);
                    this.xModelo_NPredefinida.setValueAt(xrs.getString(3), x, 2);
                    this.xModelo_NPredefinida.setValueAt(Long.valueOf(xrs.getLong(4)), x, 3);
                    this.xModelo_NPredefinida.setValueAt(Boolean.valueOf(xrs.getBoolean(5)), x, 4);
                    x++;
                }
            } else {
                mCrearModelo_NPredefinida();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIF_HTipo_Notas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
