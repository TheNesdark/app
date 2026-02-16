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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFPatologias_Cie10.class */
public class JIFPatologias_Cie10 extends JInternalFrame {
    private Object[] xdatos;
    private String[] xidespecialidad;
    private String[] xidprograma;
    private String[] xIdEntidades;
    private String[] xIdFicha;
    private DefaultTableModel xmodeloH;
    private DefaultTableModel xmodeloR;
    private DefaultTableModel xmodeloE;
    private DefaultTableModel xmodeloP;
    private DefaultTableModel xmodeloET;
    private DefaultTableModel xmodeloF;
    private String xsql;
    private JButton JBTCarguesA1;
    private JComboBox JCBEntidades;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBFicha;
    private JComboBox JCBPrograma;
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstadoEntidades;
    private JCheckBox JCHEstadoEsp;
    private JCheckBox JCHEstadoFicha;
    private JCheckBox JCHEstadoProg;
    private JCheckBox JCHREstado;
    private JCheckBox JCHSeleecionar;
    private JPanel JPIDatos;
    private JPanel JPIEspecialidad;
    private JPanel JPIFichaSivigila;
    private JPanel JPIFiltro;
    private JPanel JPIHistorico;
    private JPanel JPIIEntidadesReporte;
    private JPanel JPIPrograma;
    private JPanel JPIRDatos;
    private JPanel JPIRecomendaciones;
    private JScrollPane JSPDetalleE;
    private JScrollPane JSPDetalleET;
    private JScrollPane JSPDetalleFicha;
    private JScrollPane JSPDetalleH;
    private JScrollPane JSPDetalleP;
    private JScrollPane JSPDetalleR;
    private JScrollPane JSPRDescripcion;
    private JSpinner JSPROrden;
    private JSpinner JSPRPrioridad;
    private JTextArea JTARDescripcion;
    private JTable JTDetalleE;
    private JTable JTDetalleET;
    private JTable JTDetalleFicha;
    private JTable JTDetalleH;
    private JTable JTDetalleP;
    private JTable JTDetalleR;
    private JTextField JTFFCodigo;
    private JTextField JTFFNombre;
    private JTextField JTFFNombreB;
    private JTextField JTFRuta;
    private JTabbedPane JTPDatosH;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 1;
    private int xestadoesp = 1;
    private int xestadoProg = 1;
    private int xestadoET = 1;
    private int xEstadoFich = 1;

    public JIFPatologias_Cie10() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v119, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v141, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v165, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v189, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v68, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFFCodigo = new JTextField();
        this.JTFFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTPDatosH = new JTabbedPane();
        this.JPIHistorico = new JPanel();
        this.JPIFiltro = new JPanel();
        this.JTFFNombreB = new JTextField();
        this.JCHSeleecionar = new JCheckBox();
        this.JSPDetalleH = new JScrollPane();
        this.JTDetalleH = new JTable();
        this.JPIEspecialidad = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JSPDetalleE = new JScrollPane();
        this.JTDetalleE = new JTable();
        this.JCHEstadoEsp = new JCheckBox();
        this.JPIRecomendaciones = new JPanel();
        this.JPIRDatos = new JPanel();
        this.JSPRDescripcion = new JScrollPane();
        this.JTARDescripcion = new JTextArea();
        this.JSPROrden = new JSpinner();
        this.JCHREstado = new JCheckBox();
        this.JSPRPrioridad = new JSpinner();
        this.JSPDetalleR = new JScrollPane();
        this.JTDetalleR = new JTable();
        this.JPIPrograma = new JPanel();
        this.JCBPrograma = new JComboBox();
        this.JCHEstadoProg = new JCheckBox();
        this.JSPDetalleP = new JScrollPane();
        this.JTDetalleP = new JTable();
        this.JPIIEntidadesReporte = new JPanel();
        this.JCBEntidades = new JComboBox();
        this.JCHEstadoEntidades = new JCheckBox();
        this.JSPDetalleET = new JScrollPane();
        this.JTDetalleET = new JTable();
        this.JPIFichaSivigila = new JPanel();
        this.JCBFicha = new JComboBox();
        this.JCHEstadoFicha = new JCheckBox();
        this.JSPDetalleFicha = new JScrollPane();
        this.JTDetalleFicha = new JTable();
        this.JBTCarguesA1 = new JButton();
        this.JTFRuta = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("PATOLOGÍAS CIE10");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifpatologiacie10");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.1
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFCodigo, -2, 70, -2).addGap(18, 18, 18).addComponent(this.JTFFNombre, -2, 573, -2).addGap(18, 18, 18).addComponent(this.JCHEstado, -1, -1, 32767).addGap(17, 17, 17)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCodigo, -2, 50, -2).addComponent(this.JTFFNombre, -2, 50, -2).addComponent(this.JCHEstado)).addContainerGap(-1, 32767)));
        this.JTPDatosH.setForeground(new Color(255, 0, 0));
        this.JTPDatosH.setFont(new Font("Arial", 1, 14));
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO PARA BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFNombreB.setFont(new Font("Arial", 1, 12));
        this.JTFFNombreB.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar por Codigo o Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFNombreB.addKeyListener(new KeyAdapter() { // from class: ParametrizacionN.JIFPatologias_Cie10.2
            public void keyReleased(KeyEvent evt) {
                JIFPatologias_Cie10.this.JTFFNombreBKeyReleased(evt);
            }
        });
        this.JCHSeleecionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleecionar.setSelected(true);
        this.JCHSeleecionar.setText("Seleccionar?");
        this.JCHSeleecionar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.3
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCHSeleecionarActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFNombreB, -2, 536, -2).addGap(18, 18, 18).addComponent(this.JCHSeleecionar, -1, 145, 32767).addGap(130, 130, 130)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFNombreB, -2, 50, -2).addComponent(this.JCHSeleecionar)).addContainerGap(-1, 32767)));
        this.JSPDetalleH.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleH.setFont(new Font("Arial", 1, 12));
        this.JTDetalleH.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleH.setRowHeight(25);
        this.JTDetalleH.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleH.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleH.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPatologias_Cie10.4
            public void mouseClicked(MouseEvent evt) {
                JIFPatologias_Cie10.this.JTDetalleHMouseClicked(evt);
            }
        });
        this.JSPDetalleH.setViewportView(this.JTDetalleH);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleH, -1, 845, 32767).addComponent(this.JPIFiltro, -1, -1, 32767)).addContainerGap()));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleH, -2, 206, -2).addContainerGap(-1, 32767)));
        this.JTPDatosH.addTab("HISTÓRICO", this.JPIHistorico);
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.5
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCBEspecialidadActionPerformed(evt);
            }
        });
        this.JSPDetalleE.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleE.setFont(new Font("Arial", 1, 12));
        this.JTDetalleE.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleE.setRowHeight(25);
        this.JTDetalleE.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleE.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleE.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPatologias_Cie10.6
            public void mouseClicked(MouseEvent evt) {
                JIFPatologias_Cie10.this.JTDetalleEMouseClicked(evt);
            }
        });
        this.JSPDetalleE.setViewportView(this.JTDetalleE);
        this.JCHEstadoEsp.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoEsp.setSelected(true);
        this.JCHEstadoEsp.setText("Estado");
        this.JCHEstadoEsp.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.7
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCHEstadoEspActionPerformed(evt);
            }
        });
        GroupLayout JPIEspecialidadLayout = new GroupLayout(this.JPIEspecialidad);
        this.JPIEspecialidad.setLayout(JPIEspecialidadLayout);
        JPIEspecialidadLayout.setHorizontalGroup(JPIEspecialidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEspecialidadLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBEspecialidad, 0, 761, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstadoEsp).addGap(15, 15, 15)).addGroup(JPIEspecialidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEspecialidadLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleE, -1, 845, 32767).addContainerGap())));
        JPIEspecialidadLayout.setVerticalGroup(JPIEspecialidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEspecialidadLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(JPIEspecialidadLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEspecialidad, -2, -1, -2).addComponent(this.JCHEstadoEsp)).addContainerGap(248, 32767)).addGroup(JPIEspecialidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIEspecialidadLayout.createSequentialGroup().addContainerGap(55, 32767).addComponent(this.JSPDetalleE, -2, 252, -2).addContainerGap())));
        this.JTPDatosH.addTab("ESPECIALIDADES", this.JPIEspecialidad);
        this.JPIRDatos.setBorder(BorderFactory.createEtchedBorder());
        this.JTARDescripcion.setColumns(1);
        this.JTARDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTARDescripcion.setLineWrap(true);
        this.JTARDescripcion.setRows(1);
        this.JTARDescripcion.setTabSize(1);
        this.JTARDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPRDescripcion.setViewportView(this.JTARDescripcion);
        this.JSPROrden.setFont(new Font("Arial", 1, 12));
        this.JSPROrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHREstado.setFont(new Font("Arial", 1, 12));
        this.JCHREstado.setSelected(true);
        this.JCHREstado.setText("Estado");
        this.JCHREstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.8
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCHREstadoActionPerformed(evt);
            }
        });
        this.JSPRPrioridad.setFont(new Font("Arial", 1, 12));
        this.JSPRPrioridad.setModel(new SpinnerNumberModel(1, 1, 3, 1));
        this.JSPRPrioridad.setBorder(BorderFactory.createTitledBorder((Border) null, "Prioridad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIRDatosLayout = new GroupLayout(this.JPIRDatos);
        this.JPIRDatos.setLayout(JPIRDatosLayout);
        JPIRDatosLayout.setHorizontalGroup(JPIRDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPRDescripcion, -2, 594, -2).addGap(18, 18, 18).addGroup(JPIRDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRDatosLayout.createSequentialGroup().addComponent(this.JSPRPrioridad, -2, 86, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHREstado)).addComponent(this.JSPROrden, -2, 87, -2)).addContainerGap(62, 32767)));
        JPIRDatosLayout.setVerticalGroup(JPIRDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIRDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPRDescripcion, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIRDatosLayout.createSequentialGroup().addGap(55, 55, 55).addGroup(JPIRDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPRPrioridad, -2, -1, -2).addComponent(this.JCHREstado)))).addComponent(this.JSPROrden, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalleR.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleR.setFont(new Font("Arial", 1, 12));
        this.JTDetalleR.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleR.setRowHeight(25);
        this.JTDetalleR.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleR.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleR.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPatologias_Cie10.9
            public void mouseClicked(MouseEvent evt) {
                JIFPatologias_Cie10.this.JTDetalleRMouseClicked(evt);
            }
        });
        this.JSPDetalleR.setViewportView(this.JTDetalleR);
        GroupLayout JPIRecomendacionesLayout = new GroupLayout(this.JPIRecomendaciones);
        this.JPIRecomendaciones.setLayout(JPIRecomendacionesLayout);
        JPIRecomendacionesLayout.setHorizontalGroup(JPIRecomendacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRecomendacionesLayout.createSequentialGroup().addContainerGap().addGroup(JPIRecomendacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIRDatos, -1, -1, 32767).addComponent(this.JSPDetalleR, GroupLayout.Alignment.TRAILING, -1, 845, 32767)).addContainerGap()));
        JPIRecomendacionesLayout.setVerticalGroup(JPIRecomendacionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRecomendacionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIRDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalleR, -2, 176, -2).addContainerGap(-1, 32767)));
        this.JTPDatosH.addTab("RECOMENDACIONES", this.JPIRecomendaciones);
        this.JCBPrograma.setFont(new Font("Arial", 1, 12));
        this.JCBPrograma.setBorder(BorderFactory.createTitledBorder((Border) null, "Programa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBPrograma.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.10
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCBProgramaActionPerformed(evt);
            }
        });
        this.JCHEstadoProg.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoProg.setSelected(true);
        this.JCHEstadoProg.setText("Estado");
        this.JCHEstadoProg.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.11
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCHEstadoProgActionPerformed(evt);
            }
        });
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleP.setFont(new Font("Arial", 1, 12));
        this.JTDetalleP.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleP.setRowHeight(25);
        this.JTDetalleP.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleP.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleP.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPatologias_Cie10.12
            public void mouseClicked(MouseEvent evt) {
                JIFPatologias_Cie10.this.JTDetallePMouseClicked(evt);
            }
        });
        this.JSPDetalleP.setViewportView(this.JTDetalleP);
        GroupLayout JPIProgramaLayout = new GroupLayout(this.JPIPrograma);
        this.JPIPrograma.setLayout(JPIProgramaLayout);
        JPIProgramaLayout.setHorizontalGroup(JPIProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProgramaLayout.createSequentialGroup().addContainerGap().addGroup(JPIProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProgramaLayout.createSequentialGroup().addComponent(this.JCBPrograma, 0, 761, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstadoProg).addGap(15, 15, 15)).addGroup(JPIProgramaLayout.createSequentialGroup().addComponent(this.JSPDetalleP, -1, 845, 32767).addContainerGap()))));
        JPIProgramaLayout.setVerticalGroup(JPIProgramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIProgramaLayout.createSequentialGroup().addContainerGap().addGroup(JPIProgramaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBPrograma, -2, -1, -2).addComponent(this.JCHEstadoProg)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleP, -2, 257, -2).addContainerGap(-1, 32767)));
        this.JTPDatosH.addTab("PROGRAMA", this.JPIPrograma);
        this.JCBEntidades.setFont(new Font("Arial", 1, 12));
        this.JCBEntidades.setBorder(BorderFactory.createTitledBorder((Border) null, "Entidades", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEntidades.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.13
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCBEntidadesActionPerformed(evt);
            }
        });
        this.JCHEstadoEntidades.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoEntidades.setSelected(true);
        this.JCHEstadoEntidades.setText("Estado");
        this.JCHEstadoEntidades.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.14
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCHEstadoEntidadesActionPerformed(evt);
            }
        });
        this.JSPDetalleET.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleET.setFont(new Font("Arial", 1, 12));
        this.JTDetalleET.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleET.setRowHeight(25);
        this.JTDetalleET.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleET.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleET.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPatologias_Cie10.15
            public void mouseClicked(MouseEvent evt) {
                JIFPatologias_Cie10.this.JTDetalleETMouseClicked(evt);
            }
        });
        this.JSPDetalleET.setViewportView(this.JTDetalleET);
        GroupLayout JPIIEntidadesReporteLayout = new GroupLayout(this.JPIIEntidadesReporte);
        this.JPIIEntidadesReporte.setLayout(JPIIEntidadesReporteLayout);
        JPIIEntidadesReporteLayout.setHorizontalGroup(JPIIEntidadesReporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIEntidadesReporteLayout.createSequentialGroup().addContainerGap().addGroup(JPIIEntidadesReporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIEntidadesReporteLayout.createSequentialGroup().addComponent(this.JCBEntidades, -2, 681, -2).addGap(18, 18, 18).addComponent(this.JCHEstadoEntidades).addGap(0, 0, 32767)).addComponent(this.JSPDetalleET, GroupLayout.Alignment.TRAILING, -1, 845, 32767)).addContainerGap()));
        JPIIEntidadesReporteLayout.setVerticalGroup(JPIIEntidadesReporteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIIEntidadesReporteLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIIEntidadesReporteLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEntidades, -2, -1, -2).addComponent(this.JCHEstadoEntidades)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleET, -2, 257, -2).addContainerGap(-1, 32767)));
        this.JTPDatosH.addTab("REPORTE A ENTIDADES", this.JPIIEntidadesReporte);
        this.JCBFicha.setFont(new Font("Arial", 1, 12));
        this.JCBFicha.setBorder(BorderFactory.createTitledBorder((Border) null, "Ficha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstadoFicha.setFont(new Font("Arial", 1, 12));
        this.JCHEstadoFicha.setSelected(true);
        this.JCHEstadoFicha.setText("Estado");
        this.JCHEstadoFicha.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.16
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JCHEstadoFichaActionPerformed(evt);
            }
        });
        this.JSPDetalleFicha.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleFicha.setFont(new Font("Arial", 1, 12));
        this.JTDetalleFicha.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleFicha.setRowHeight(25);
        this.JTDetalleFicha.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleFicha.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleFicha.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPatologias_Cie10.17
            public void mouseClicked(MouseEvent evt) {
                JIFPatologias_Cie10.this.JTDetalleFichaMouseClicked(evt);
            }
        });
        this.JSPDetalleFicha.setViewportView(this.JTDetalleFicha);
        GroupLayout JPIFichaSivigilaLayout = new GroupLayout(this.JPIFichaSivigila);
        this.JPIFichaSivigila.setLayout(JPIFichaSivigilaLayout);
        JPIFichaSivigilaLayout.setHorizontalGroup(JPIFichaSivigilaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFichaSivigilaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFichaSivigilaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFichaSivigilaLayout.createSequentialGroup().addComponent(this.JCBFicha, 0, 761, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstadoFicha).addGap(15, 15, 15)).addGroup(JPIFichaSivigilaLayout.createSequentialGroup().addComponent(this.JSPDetalleFicha, -1, 845, 32767).addContainerGap()))));
        JPIFichaSivigilaLayout.setVerticalGroup(JPIFichaSivigilaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFichaSivigilaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFichaSivigilaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFicha, -2, -1, -2).addComponent(this.JCHEstadoFicha)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleFicha, -2, 257, -2).addContainerGap(-1, 32767)));
        this.JTPDatosH.addTab("FICHA NOTIFICACIÓN (SIVIGILA)", this.JPIFichaSivigila);
        this.JBTCarguesA1.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTCarguesA1.setText("Exportar");
        this.JBTCarguesA1.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFPatologias_Cie10.18
            public void actionPerformed(ActionEvent evt) {
                JIFPatologias_Cie10.this.JBTCarguesA1ActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFPatologias_Cie10.19
            public void mouseClicked(MouseEvent evt) {
                JIFPatologias_Cie10.this.JTFRutaMouseClicked(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JTPDatosH, -1, 857, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCarguesA1, -2, 131, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTPDatosH, -2, 359, -2).addGap(9, 9, 9).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFRuta, -2, 50, -2)).addComponent(this.JBTCarguesA1, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleecionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleecionar.isSelected()) {
            this.JCHSeleecionar.setText("Quitar Seleccion?");
        } else {
            this.JCHSeleecionar.setText("Seleccionar?");
        }
        seleccionarPatologias();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNombreBKeyReleased(KeyEvent evt) {
        if (!this.JTFFNombreB.getText().isEmpty()) {
            mCargarDatosC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHMouseClicked(MouseEvent evt) {
        if (this.JTDetalleH.getSelectedRow() != -1) {
            this.JTFFCodigo.setText(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0).toString());
            this.JTFFNombre.setText(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 1).toString());
            this.JCHEstado.setSelected(Boolean.parseBoolean(this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 2).toString()));
            mCargarDatosR();
            mCargarDatosE();
            mCargarDatosP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleRMouseClicked(MouseEvent evt) {
        if (this.JTDetalleR.getSelectedRow() != -1) {
            this.JTARDescripcion.setText(this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 0).toString());
            this.JSPROrden.setValue(Integer.valueOf(this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 1).toString()));
            this.JSPRPrioridad.setValue(Integer.valueOf(this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 2).toString()));
            this.JCHREstado.setSelected(Boolean.parseBoolean(this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 3).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHREstadoActionPerformed(ActionEvent evt) {
        if (this.JCHREstado.isSelected()) {
            this.xestado = 1;
        } else {
            this.xestado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleEMouseClicked(MouseEvent evt) {
        if (this.JTDetalleE.getSelectedRow() != -1) {
            this.JCBEspecialidad.setSelectedItem(this.xmodeloE.getValueAt(this.JTDetalleE.getSelectedRow(), 0).toString());
            this.JCHEstadoEsp.setSelected(Boolean.valueOf(this.xmodeloE.getValueAt(this.JTDetalleE.getSelectedRow(), 1).toString()).booleanValue());
            if (this.JCHEstadoEsp.isSelected()) {
                this.xestadoesp = 1;
            } else {
                this.xestadoesp = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoEspActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoEsp.isSelected()) {
            this.xestadoesp = 1;
        } else {
            this.xestadoesp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProgramaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoProgActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoProg.isSelected()) {
            this.xestadoProg = 1;
        } else {
            this.xestadoProg = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePMouseClicked(MouseEvent evt) {
        if (this.JTDetalleP.getSelectedRow() != -1) {
            this.JCBPrograma.setSelectedItem(this.xmodeloP.getValueAt(this.JTDetalleP.getSelectedRow(), 0).toString());
            this.JCHEstadoProg.setSelected(Boolean.valueOf(this.xmodeloP.getValueAt(this.JTDetalleP.getSelectedRow(), 1).toString()).booleanValue());
            if (this.JCHEstadoProg.isSelected()) {
                this.xestadoProg = 1;
            } else {
                this.xestadoProg = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEntidadesActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoEntidadesActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoEntidades.isSelected()) {
            this.xestadoET = 1;
        } else {
            this.xestadoET = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleETMouseClicked(MouseEvent evt) {
        if (this.JTDetalleET.getSelectedRow() != -1) {
            this.JTFFCodigo.setText(this.JTDetalleET.getValueAt(this.JTDetalleET.getSelectedRow(), 0).toString());
            this.JTFFNombre.setText(this.JTDetalleET.getValueAt(this.JTDetalleET.getSelectedRow(), 1).toString());
            this.JCBEntidades.setSelectedItem(this.JTDetalleET.getValueAt(this.JTDetalleET.getSelectedRow(), 3).toString());
            this.JCBPrograma.setSelectedItem(this.JTDetalleET.getValueAt(this.JTDetalleET.getSelectedRow(), 4).toString());
            if (Boolean.valueOf(this.JTDetalleET.getValueAt(this.JTDetalleET.getSelectedRow(), 2).toString()).booleanValue()) {
                this.JCHEstadoEntidades.setSelected(true);
                this.xestadoET = 1;
            } else {
                this.JCHEstadoEntidades.setSelected(false);
                this.xestadoET = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesA1ActionPerformed(ActionEvent evt) {
        switch (this.JTPDatosH.getSelectedIndex()) {
            case 0:
                if (this.JTDetalleH.getRowCount() > 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleH, this.JTFRuta.getText(), "PATOLOGÍAS CIE10");
                }
                break;
            case 1:
                if (this.JTDetalleE.getRowCount() > 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleE, this.JTFRuta.getText(), "PATOLOGÍAS CIE10 POR ESPECIALIDAD");
                }
                break;
            case 2:
                if (this.JTDetalleR.getRowCount() > 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleR, this.JTFRuta.getText(), "PATOLOGÍAS CIE10 CON RECOMENDACIONES");
                }
                break;
            case 3:
                if (this.JTDetalleP.getRowCount() > 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleP, this.JTFRuta.getText(), "PATOLOGÍAS CIE10 POR PROGRAMA");
                }
                break;
            case 4:
                if (this.JTDetalleET.getRowCount() > 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleET, this.JTFRuta.getText(), "PATOLOGÍAS CIE10 POR ENTIDAD");
                }
                break;
            case 5:
                if (this.JTDetalleFicha.getRowCount() > 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleFicha, this.JTFRuta.getText(), "PATOLOGÍAS CIE10 - FICHA DE NOTIFICACION OBLIGATORIA CIE10");
                }
                break;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoFichaActionPerformed(ActionEvent evt) {
        if (this.JCHEstadoFicha.isSelected()) {
            this.xEstadoFich = 1;
        } else {
            this.xEstadoFich = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleFichaMouseClicked(MouseEvent evt) {
        if (this.JTDetalleFicha.getSelectedRow() != -1) {
            this.JTFFCodigo.setText(this.JTDetalleFicha.getValueAt(this.JTDetalleFicha.getSelectedRow(), 0).toString());
            this.JTFFNombre.setText(this.JTDetalleFicha.getValueAt(this.JTDetalleFicha.getSelectedRow(), 1).toString());
            this.JCBFicha.setSelectedItem(this.JTDetalleFicha.getValueAt(this.JTDetalleFicha.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.JTDetalleFicha.getValueAt(this.JTDetalleFicha.getSelectedRow(), 3).toString()).booleanValue()) {
                this.JCHEstadoFicha.setSelected(true);
                this.xEstadoFich = 1;
            } else {
                this.JCHEstadoFicha.setSelected(false);
                this.xEstadoFich = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        this.JTFFNombreB.setText("");
        this.JCHSeleecionar.setSelected(true);
        if (this.JCHSeleecionar.isSelected()) {
            this.JCHSeleecionar.setText("Comienza?");
        } else {
            this.JCHSeleecionar.setText("Contiene?");
        }
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JCBEspecialidad.removeAllItems();
        this.xidespecialidad = this.xct.llenarCombo("SELECT Id, Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBPrograma.removeAllItems();
        this.xidprograma = this.xct.llenarCombo("SELECT Id_TipoPrograma, Nbre FROM g_tipoprograma WHERE (Estado =0) ORDER BY Nbre ASC", this.xidprograma, this.JCBPrograma);
        this.JCBPrograma.setSelectedIndex(-1);
        this.JCBEntidades.removeAllItems();
        this.xIdEntidades = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `g_tipoentidad` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xIdEntidades, this.JCBEntidades);
        this.JCBEntidades.setSelectedIndex(-1);
        this.JCBFicha.removeAllItems();
        this.xIdFicha = this.xct.llenarCombo("SELECT `Id` , IF(Codigo='', `Nbre` , CONCAT(Nbre, ' ', Codigo)) Nbre FROM `g_fichas_notificacion_sivigila` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xIdFicha, this.JCBFicha);
        this.JCBFicha.setSelectedIndex(-1);
        this.xEstadoFich = 1;
        this.JCHEstadoFicha.setSelected(true);
        mCargarDatosC();
        mCargarDatosET();
        mCargarDatosF();
        mCrearModeloTablaR();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaH() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Nombre", "Estado?", "Selección?"}) { // from class: ParametrizacionN.JIFPatologias_Cie10.20
            Class[] types = {String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleH.setModel(this.xmodeloH);
        this.JTDetalleH.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleH.getColumnModel().getColumn(1).setPreferredWidth(550);
        this.JTDetalleH.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleH.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaR() {
        this.xmodeloR = new DefaultTableModel(new Object[0], new String[]{"Recomendación", "Orden", "Prioridad", "Estado", "ID"}) { // from class: ParametrizacionN.JIFPatologias_Cie10.21
            Class[] types = {String.class, Long.class, Long.class, Boolean.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleR.setModel(this.xmodeloR);
        this.JTDetalleR.getColumnModel().getColumn(0).setPreferredWidth(500);
        this.JTDetalleR.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleR.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleR.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalleR.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleR.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleR.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaE() {
        this.xmodeloE = new DefaultTableModel(new Object[0], new String[]{"Especialidad", "Estado"}) { // from class: ParametrizacionN.JIFPatologias_Cie10.22
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleE.setModel(this.xmodeloE);
        this.JTDetalleE.getColumnModel().getColumn(0).setPreferredWidth(500);
        this.JTDetalleE.getColumnModel().getColumn(1).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaP() {
        this.xmodeloP = new DefaultTableModel(new Object[0], new String[]{"Programa", "Estado"}) { // from class: ParametrizacionN.JIFPatologias_Cie10.23
            Class[] types = {String.class, Boolean.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleP.setModel(this.xmodeloP);
        this.JTDetalleP.getColumnModel().getColumn(0).setPreferredWidth(500);
        this.JTDetalleP.getColumnModel().getColumn(1).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaET() {
        this.xmodeloET = new DefaultTableModel(new Object[0], new String[]{"Código", "Nombre", "Estado", "Entidad", "Programa"}) { // from class: ParametrizacionN.JIFPatologias_Cie10.24
            Class[] types = {String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleET;
        JTable jTable2 = this.JTDetalleET;
        jTable.setAutoResizeMode(0);
        this.JTDetalleET.doLayout();
        this.JTDetalleET.setModel(this.xmodeloET);
        this.JTDetalleET.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleET.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTDetalleET.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalleET.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalleET.getColumnModel().getColumn(4).setPreferredWidth(200);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTablaF() {
        this.xmodeloF = new DefaultTableModel(new Object[0], new String[]{"Código", "Nombre", "Ficha", "Estado"}) { // from class: ParametrizacionN.JIFPatologias_Cie10.25
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleFicha.setAutoResizeMode(0);
        this.JTDetalleFicha.doLayout();
        this.JTDetalleFicha.setModel(this.xmodeloF);
        this.JTDetalleFicha.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalleFicha.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTDetalleFicha.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleFicha.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mCargarDatosC() {
        try {
            mCrearModeloTablaH();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            if (!this.JTFFNombreB.getText().isEmpty()) {
                this.xsql = "SELECT `Id`, `Nbre`, Estado FROM `g_patologia` where Nbre LIKE '%" + this.JTFFNombreB.getText() + "%' OR Id LIKE '%" + this.JTFFNombreB.getText() + "%' ORDER BY `Id` ASC";
            } else {
                this.xsql = "SELECT `Id`, `Nbre`, Estado FROM `g_patologia` where Estado=1 ORDER BY `Id` ASC ";
            }
            System.out.println("En : " + this.xsql);
            ResultSet xrs1 = xct1.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs1.next()) {
                        xrs1.beforeFirst();
                        int x = 0;
                        this.xmt.mEstablecerTextEditor(this.JTDetalleH, 1);
                        while (xrs1.next()) {
                            this.xmodeloH.addRow(this.xdatos);
                            this.xmodeloH.setValueAt(xrs1.getString(1), x, 0);
                            this.xmodeloH.setValueAt(xrs1.getString(2), x, 1);
                            this.xmodeloH.setValueAt(Boolean.valueOf(xrs1.getBoolean("Estado")), x, 2);
                            this.xmodeloH.setValueAt(false, x, 3);
                            x++;
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct1.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPatologias_Cie10.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosR() {
        try {
            mCrearModeloTablaR();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT `Recomedaciones`, `Orden`,`Prioridad`,  `Estado`, `Id` FROM `g_patologia_recomedaciones` WHERE (`Id_Patologia` ='" + this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0) + "') ORDER BY `Orden` ASC ";
            System.out.println("En : " + this.xsql);
            ResultSet xrs1 = xct1.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs1.next()) {
                        xrs1.beforeFirst();
                        int x = 0;
                        this.xmt.mEstablecerTextEditor(this.JTDetalleR, 0);
                        while (xrs1.next()) {
                            this.xmodeloR.addRow(this.xdatos);
                            this.xmodeloR.setValueAt(xrs1.getString(1), x, 0);
                            this.xmodeloR.setValueAt(Long.valueOf(xrs1.getLong(2)), x, 1);
                            this.xmodeloR.setValueAt(Long.valueOf(xrs1.getLong(3)), x, 2);
                            this.xmodeloR.setValueAt(Boolean.valueOf(xrs1.getBoolean(4)), x, 3);
                            this.xmodeloR.setValueAt(Long.valueOf(xrs1.getLong(5)), x, 4);
                            x++;
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct1.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPatologias_Cie10.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosE() {
        try {
            mCrearModeloTablaE();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT `g_especialidad`.`Nbre`, `g_patologia_especialidad`.`Estado` FROM `g_patologia_especialidad` INNER JOIN `g_especialidad` ON (`g_patologia_especialidad`.`IdEspecialidad` = `g_especialidad`.`Id`)WHERE (`g_patologia_especialidad`.`IdPatologia` ='" + this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0) + "') ORDER BY `g_especialidad`.`Nbre` ASC;";
            System.out.println("En : " + this.xsql);
            ResultSet xrs1 = xct1.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs1.next()) {
                        xrs1.beforeFirst();
                        int x = 0;
                        while (xrs1.next()) {
                            this.xmodeloE.addRow(this.xdatos);
                            this.xmodeloE.setValueAt(xrs1.getString(1), x, 0);
                            this.xmodeloE.setValueAt(Boolean.valueOf(xrs1.getBoolean(2)), x, 1);
                            x++;
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct1.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPatologias_Cie10.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosET() {
        try {
            mCrearModeloTablaET();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = " SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\n    , `r_patologiasreporte`.`Estado`\n    , `g_tipoentidad`.`Nbre`, g_tipoprograma.`Nbre`\nFROM\n    `r_patologiasreporte`\n    INNER JOIN `g_patologia` \n        ON (`r_patologiasreporte`.`Id_Patologia` = `g_patologia`.`Id`)\n    INNER JOIN `g_tipoentidad` \n        ON (`r_patologiasreporte`.`Id_TipoEntidadR` = `g_tipoentidad`.`Id`)\n        INNER JOIN `g_tipoprograma`\n        ON (`r_patologiasreporte`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`)\nORDER BY `g_patologia`.`Nbre` ASC, `g_tipoentidad`.`Nbre` ASC";
            System.out.println("En : " + this.xsql);
            ResultSet xrs1 = xct1.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs1.next()) {
                        xrs1.beforeFirst();
                        int x = 0;
                        this.xmt.mEstablecerTextEditor(this.JTDetalleET, 1);
                        while (xrs1.next()) {
                            this.xmodeloET.addRow(this.xdatos);
                            this.xmodeloET.setValueAt(xrs1.getString(1), x, 0);
                            this.xmodeloET.setValueAt(xrs1.getString(2), x, 1);
                            this.xmodeloET.setValueAt(Boolean.valueOf(xrs1.getBoolean(3)), x, 2);
                            this.xmodeloET.setValueAt(xrs1.getString(4), x, 3);
                            this.xmodeloET.setValueAt(xrs1.getString(5), x, 4);
                            x++;
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct1.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPatologias_Cie10.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosF() {
        try {
            mCrearModeloTablaF();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre` AS `NPatologia`\n    , `g_fichas_notificacion_sivigila`.`Nbre` AS `NFicha`\n    , `g_patologia_ficha_sivigila`.`Estado`\n    \nFROM\n     `g_patologia_ficha_sivigila`\n    INNER JOIN  `g_patologia` \n        ON (`g_patologia_ficha_sivigila`.`IdPatologia` = `g_patologia`.`Id`)\n    INNER JOIN  `g_fichas_notificacion_sivigila` \n        ON (`g_patologia_ficha_sivigila`.`IdFichaNotificcion` = `g_fichas_notificacion_sivigila`.`Id`)\nORDER BY `g_patologia`.`Id` ASC";
            System.out.println("En : " + this.xsql);
            ResultSet xrs1 = xct1.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs1.next()) {
                        xrs1.beforeFirst();
                        int x = 0;
                        this.xmt.mEstablecerTextEditor(this.JTDetalleFicha, 1);
                        while (xrs1.next()) {
                            this.xmodeloF.addRow(this.xdatos);
                            this.xmodeloF.setValueAt(xrs1.getString(1), x, 0);
                            this.xmodeloF.setValueAt(xrs1.getString(2), x, 1);
                            this.xmodeloF.setValueAt(Boolean.valueOf(xrs1.getBoolean(4)), x, 3);
                            this.xmodeloF.setValueAt(xrs1.getString(3), x, 2);
                            x++;
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct1.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPatologias_Cie10.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosP() {
        try {
            mCrearModeloTablaP();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT `g_tipoprograma`.`Nbre`, `g_patologia_programa`.`Estado` FROM `g_patologia_programa` INNER JOIN `g_tipoprograma` ON (`g_patologia_programa`.`Id_Programa` = `g_tipoprograma`.`Id_TipoPrograma`) WHERE (`g_patologia_programa`.`Id_Patologia` ='" + this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0) + "') ORDER BY `g_tipoprograma`.`Nbre` ASC;";
            System.out.println("En : " + this.xsql);
            ResultSet xrs1 = xct1.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs1.next()) {
                        xrs1.beforeFirst();
                        int x = 0;
                        while (xrs1.next()) {
                            this.xmodeloP.addRow(this.xdatos);
                            this.xmodeloP.setValueAt(xrs1.getString(1), x, 0);
                            this.xmodeloP.setValueAt(Boolean.valueOf(xrs1.getBoolean(2)), x, 1);
                            x++;
                        }
                    }
                    if (xrs1 != null) {
                        if (0 != 0) {
                            try {
                                xrs1.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs1.close();
                        }
                    }
                    xct1.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFPatologias_Cie10.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        switch (this.JTPDatosH.getSelectedIndex()) {
            case 1:
                if (this.JTDetalleH.getSelectedRow() != -1) {
                    if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            if (this.JTDetalleE.getSelectedRow() == -1) {
                                if (!mVerfica()) {
                                    this.xsql = "insert into g_patologia_especialidad (`IdPatologia`, `IdEspecialidad`, `Estado`, `UsuarioS`)  values('" + this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0) + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.xestadoesp + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Esta configuracion ya esta registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                }
                            } else {
                                this.xsql = "update g_patologia_especialidad set Estado='" + this.xestadoesp + "',Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where IdPatologia='" + this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0) + "' and IdEspecialidad='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'";
                            }
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            mCargarDatosE();
                            this.JCBEspecialidad.setSelectedIndex(-1);
                            this.JCHEstadoEsp.setSelected(true);
                            this.xestadoesp = 1;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBEspecialidad.setFocusable(true);
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una patología", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDatosH.setSelectedIndex(0);
                }
                break;
            case 2:
                if (this.JTDetalleH.getSelectedRow() != -1) {
                    if (!this.JTARDescripcion.getText().isEmpty()) {
                        int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x2 == 0) {
                            if (this.JTDetalleR.getSelectedRow() == -1) {
                                this.xsql = "insert into g_patologia_recomedaciones (`Id_Patologia`, `Recomedaciones`, `Orden`, `Prioridad`, `Estado`, `UsuarioS` )  values('" + this.xmodeloH.getValueAt(this.JTDetalleH.getSelectedRow(), 0) + "','" + this.JTARDescripcion.getText() + "','" + this.JSPROrden.getValue() + "','" + this.JSPRPrioridad.getValue() + "','" + this.xestado + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            } else {
                                this.xsql = "update g_patologia_recomedaciones set Recomedaciones='" + this.JTARDescripcion.getText() + "',Orden='" + this.JSPROrden.getValue() + "',Prioridad='" + this.JSPRPrioridad.getValue() + "',Estado='" + this.xestado + "',Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id='" + this.xmodeloR.getValueAt(this.JTDetalleR.getSelectedRow(), 4) + "'";
                            }
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            mCargarDatosR();
                            this.JTARDescripcion.setText("");
                            this.JSPROrden.setValue(new Integer(0));
                            this.JSPRPrioridad.setValue(new Integer(1));
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "La descripción no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTARDescripcion.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una patología", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDatosH.setSelectedIndex(0);
                }
                break;
            case 3:
                if (this.JTDetalleH.getSelectedRow() != -1) {
                    if (this.JCBPrograma.getSelectedIndex() != -1) {
                        int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x3 == 0) {
                            for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
                                if (Boolean.parseBoolean(this.JTDetalleH.getValueAt(i, 3).toString())) {
                                    this.xsql = "insert Ignore into g_patologia_programa (`Id_Patologia`, `Id_Programa`, `Estado`, `Id_UsuarioS`)  values('" + this.JTDetalleH.getValueAt(i, 0) + "','" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "','" + this.xestadoesp + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "')";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            mCargarDatosP();
                            this.JCBPrograma.setSelectedIndex(-1);
                            this.JCHEstadoProg.setSelected(true);
                            this.xestadoProg = 1;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBPrograma.setFocusable(true);
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una patología", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTPDatosH.setSelectedIndex(0);
                }
                break;
            case 4:
                if (!this.JTFFCodigo.getText().isEmpty()) {
                    if (this.JCBPrograma.getSelectedIndex() != -1) {
                        if (this.JCBPrograma.getSelectedIndex() != -1) {
                            int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x4 == 0) {
                                if (this.JTDetalleET.getSelectedRow() == -1) {
                                    this.xsql = "insert Ignore into r_patologiasreporte ( `Id_Patologia` , `Id_TipoEntidadR` , `Id_Programa` , `UsuarioS` , `Fecha`)  values('" + this.JTFFCodigo.getText() + "','" + this.xIdEntidades[this.JCBEntidades.getSelectedIndex()] + "','" + this.xidprograma[this.JCBPrograma.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "')";
                                } else {
                                    this.xsql = "update r_patologiasreporte set Estado='" + this.xestadoET + "',Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where Id_Patologia='" + this.xmodeloET.getValueAt(this.JTDetalleET.getSelectedRow(), 0) + "' and Id_TipoEntidadR='" + this.xIdEntidades[this.JCBEntidades.getSelectedIndex()] + "'";
                                }
                                this.xct.ejecutarSQL(this.xsql);
                                this.xct.cerrarConexionBd();
                                mCargarDatosET();
                                this.JCBPrograma.setSelectedIndex(-1);
                                this.JCBEntidades.setSelectedIndex(-1);
                                this.JCHEstadoEntidades.setSelected(true);
                                this.xestadoET = 1;
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una entidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTPDatosH.setSelectedIndex(4);
                            this.JCBPrograma.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un programa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTPDatosH.setSelectedIndex(3);
                        this.JCBPrograma.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una patología", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFCodigo.requestFocus();
                }
                break;
            case 5:
                if (!this.JTFFCodigo.getText().isEmpty()) {
                    if (this.JCBFicha.getSelectedIndex() != -1) {
                        int x5 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x5 == 0) {
                            if (this.JTDetalleET.getSelectedRow() == -1) {
                                this.xsql = "insert Ignore into g_patologia_ficha_sivigila ( `IdPatologia` , `IdFichaNotificcion` , `IdUsuarioR`)  values('" + this.JTFFCodigo.getText() + "','" + this.xIdFicha[this.JCBFicha.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
                            } else {
                                this.xsql = "update g_patologia_ficha_sivigila set Estado='" + this.xEstadoFich + "',Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "' where IdPatologia='" + this.JTFFCodigo.getText() + "' and IdFichaNotificcion='" + this.xIdFicha[this.JCBFicha.getSelectedIndex()] + "'";
                            }
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            mCargarDatosF();
                            this.JCBFicha.setSelectedIndex(-1);
                            this.JCHEstadoFicha.setSelected(true);
                            this.xEstadoFich = 1;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar fecha", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTPDatosH.setSelectedIndex(5);
                        this.JCBFicha.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una patología", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFCodigo.requestFocus();
                }
                break;
        }
    }

    private boolean mVerfica() {
        boolean xexiste = false;
        int i = 0;
        while (true) {
            if (i >= this.xmodeloE.getRowCount()) {
                break;
            }
            if (!this.JCBEspecialidad.getSelectedItem().equals(this.xmodeloE.getValueAt(i, 0).toString())) {
                i++;
            } else {
                xexiste = true;
                break;
            }
        }
        return xexiste;
    }

    private void seleccionarPatologias() {
        for (int i = 0; i < this.JTDetalleH.getRowCount(); i++) {
            this.JTDetalleH.setValueAt(Boolean.valueOf(this.JCHSeleecionar.isSelected()), i, 3);
        }
    }
}
