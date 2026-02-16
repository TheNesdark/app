package com.genoma.plus.controller.historia;

import Acceso.Principal;
import PyP.JPEAD_PuntuacionGrafica;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO;
import com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl;
import com.genoma.plus.dto.historia.EADEvaluacionDTO;
import com.genoma.plus.dto.historia.EADEvaluacionDetalleItemsDTO;
import com.genoma.plus.dto.historia.EADEvaluacionResultadoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAEscalaAbreviadaDeDesarrollo.class */
public class JPAEscalaAbreviadaDeDesarrollo extends JPanel {
    private DefaultTableModel modeloMotricidadGruesa;
    private DefaultTableModel modeloMotricidadFinoadaptativa;
    private DefaultTableModel modeloAudicionLenguaje;
    private DefaultTableModel modeloPersonalSocial;
    private Object[] datos;
    private int puntoDeInicioMotricidadGruesa;
    private int puntoDeInicioMotricidadFinoAdaptativa;
    private int puntoDeInicioAudicionLenguaje;
    private int puntoDeInicioPersonalSocial;
    private int puntoFinalDeMotricidadGruesa;
    private int puntoFinalDeMotricidadFinoAdaptativa;
    private int puntoFinalDeAudicionLenguaje;
    private int puntoFinalDePersonalSocial;
    private int puntuacionDirectaMotrocidadGruesa;
    private int puntuacionDirectaMotrocidadFinoAdaptiva;
    private int puntuacionDirectaAudicionLenguaje;
    private int puntuacionDirectaPersonalSocial;
    private int PersonalSocial;
    private int puntoReferenciaMotricidadGruesa;
    private String fechaDeNacimiento;
    private String idAtencion;
    private String idEspecialidad;
    private long idUsuario;
    private long idProfesional;
    private int edadDias;
    private int edadMes;
    private int edadAnio;
    private String edad;
    private String fechaCorregida;
    private int filaDelRango;
    private String fechaAtencion;
    private EscalaAbreviadadeDesarrolloDAO escalaAbreviadaDesarrolloDAO;
    private JButton JBCalcularEdad;
    private JCheckBox JCEsPrematuro;
    private JLabel JLAnioEdad1;
    private JLabel JLAnioEdadCorregida;
    private JLabel JLAnioFechaAtencion;
    private JLabel JLAnioFechaNacimiento;
    private JLabel JLDiasEdad1;
    private JLabel JLDiasEdadCorregida;
    private JLabel JLDiasFechaAtencion;
    private JLabel JLDiasFechaNacimiento;
    private JLabel JLMesesEdad1;
    private JLabel JLMesesEdadCorrigida;
    private JLabel JLMesesFechaAtencion;
    private JLabel JLMesesFechaNacimiento;
    private JLabel JLPuntuacionDirectaAudicionLenguaje;
    private JLabel JLPuntuacionDirectaMotricidadFinoAdaptativa;
    private JLabel JLPuntuacionDirectaMotricidadGruesa;
    private JLabel JLPuntuacionDirectaPersonalSocial;
    private JLabel JLRango;
    private JPanel JPAudicionLenguaje;
    private JPanel JPCalcularRango;
    private JPanel JPEdad;
    private JPanel JPEdadCorregida;
    private JPanel JPFechaAtencion;
    private JPanel JPFechaNacimiento;
    private JPanel JPMotrocidadFinoadaptiva;
    private JPanel JPMotrocidadGruesa;
    private JPanel JPPersonalSocial;
    private JPanel JPResultado;
    private JPanel JPResultadoGrafica;
    private JScrollPane JSPAudicionLenguaje;
    private JScrollPane JSPMotricidadFinoadaptativa;
    private JScrollPane JSPMotrocidadGruesa;
    private JScrollPane JSPPersonalSocial;
    private JSpinner JSPSemanasDeGestacion;
    private JTable JTAudicionLenguaje;
    private JTable JTMotricidadFinoadaptativa;
    private JTable JTMotrocidadGruesa;
    private JTabbedPane JTPEscalaAbreviadaDeDesarrollo;
    private JTable JTPersonalSocial;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private int rango = 5;
    private int cuentaClickTablaMotrocidadGruesa = 0;
    private int cuentaClickTablaMotrocidadFinoadaptativa = 0;
    private int cuentaClickTablaAudicionLenguaje = 0;
    private int cuentaClickTablaPersonalSocial = 0;
    private Metodos metodos = new Metodos();
    private int[] puntuacionTipicaYDirecta = new int[8];
    private SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    private int guardado = 0;

    public JPAEscalaAbreviadaDeDesarrollo(String fechaDeNacimiento, String idAtencion, String idEspecialidad, long idUsuario, long idProfesional) {
        initComponents();
        springStart();
        this.idAtencion = idAtencion;
        this.idEspecialidad = idEspecialidad;
        this.idUsuario = idUsuario;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.idProfesional = idProfesional;
        inicializarDatos(idAtencion);
        System.out.println("id atencion >>>>>> " + idAtencion);
        cargarDatosGuardados(idAtencion);
        mostrarRango(this.fechaAtencion);
    }

    private void springStart() {
        this.escalaAbreviadaDesarrolloDAO = (EscalaAbreviadadeDesarrolloDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("EscalaAbreviadadeDesarrolloDAO");
    }

    /* JADX WARN: Type inference failed for: r3v103, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v118, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v134, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v149, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPEscalaAbreviadaDeDesarrollo = new JTabbedPane();
        this.JPCalcularRango = new JPanel();
        this.jPanel1 = new JPanel();
        this.JCEsPrematuro = new JCheckBox();
        this.JSPSemanasDeGestacion = new JSpinner();
        this.JBCalcularEdad = new JButton();
        this.JPFechaNacimiento = new JPanel();
        this.JLAnioFechaNacimiento = new JLabel();
        this.JLMesesFechaNacimiento = new JLabel();
        this.JLDiasFechaNacimiento = new JLabel();
        this.JPFechaAtencion = new JPanel();
        this.JLAnioFechaAtencion = new JLabel();
        this.JLMesesFechaAtencion = new JLabel();
        this.JLDiasFechaAtencion = new JLabel();
        this.JPEdadCorregida = new JPanel();
        this.JLAnioEdadCorregida = new JLabel();
        this.JLMesesEdadCorrigida = new JLabel();
        this.JLDiasEdadCorregida = new JLabel();
        this.JPEdad = new JPanel();
        this.JLAnioEdad1 = new JLabel();
        this.JLMesesEdad1 = new JLabel();
        this.JLDiasEdad1 = new JLabel();
        this.JLRango = new JLabel();
        this.JPMotrocidadGruesa = new JPanel();
        this.JSPMotrocidadGruesa = new JScrollPane();
        this.JTMotrocidadGruesa = new JTable();
        this.JLPuntuacionDirectaMotricidadGruesa = new JLabel();
        this.JPMotrocidadFinoadaptiva = new JPanel();
        this.JSPMotricidadFinoadaptativa = new JScrollPane();
        this.JTMotricidadFinoadaptativa = new JTable();
        this.JLPuntuacionDirectaMotricidadFinoAdaptativa = new JLabel();
        this.JPAudicionLenguaje = new JPanel();
        this.JSPAudicionLenguaje = new JScrollPane();
        this.JTAudicionLenguaje = new JTable();
        this.JLPuntuacionDirectaAudicionLenguaje = new JLabel();
        this.JPPersonalSocial = new JPanel();
        this.JSPPersonalSocial = new JScrollPane();
        this.JTPersonalSocial = new JTable();
        this.JLPuntuacionDirectaPersonalSocial = new JLabel();
        this.JPResultado = new JPanel();
        this.JPResultadoGrafica = new JPanel();
        this.jPanel2 = new JPanel();
        this.jTextField1 = new JTextField();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jTextField2 = new JTextField();
        this.jLabel3 = new JLabel();
        this.jTextField3 = new JTextField();
        setBorder(BorderFactory.createTitledBorder((Border) null, "Escala Abreviada de Desarrollo", 2, 0, new Font("Arial", 1, 12)));
        setName("JPAEscalaAbreviadaDeDesarrollo");
        this.JTPEscalaAbreviadaDeDesarrollo.setFont(new Font("Arial", 1, 12));
        this.JTPEscalaAbreviadaDeDesarrollo.setName("Motricidad Gruesa");
        this.JTPEscalaAbreviadaDeDesarrollo.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.1
            public void stateChanged(ChangeEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JTPEscalaAbreviadaDeDesarrolloStateChanged(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCEsPrematuro.setFont(new Font("Arial", 1, 12));
        this.JCEsPrematuro.setForeground(Color.blue);
        this.JCEsPrematuro.setText("Es prematuro");
        this.JCEsPrematuro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.2
            public void actionPerformed(ActionEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JCEsPrematuroActionPerformed(evt);
            }
        });
        this.JSPSemanasDeGestacion.setFont(new Font("Arial", 1, 12));
        this.JSPSemanasDeGestacion.setModel(new SpinnerNumberModel(39, 20, 42, 1));
        this.JSPSemanasDeGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° semanas de Gestacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPSemanasDeGestacion.setEnabled(false);
        this.JSPSemanasDeGestacion.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.3
            public void keyPressed(KeyEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JSPSemanasDeGestacionKeyPressed(evt);
            }
        });
        this.JBCalcularEdad.setFont(new Font("Arial", 1, 12));
        this.JBCalcularEdad.setForeground(Color.blue);
        this.JBCalcularEdad.setText("Calcular Edad");
        this.JBCalcularEdad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.4
            public void actionPerformed(ActionEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JBCalcularEdadActionPerformed(evt);
            }
        });
        this.JPFechaNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha De Nacimiento", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLAnioFechaNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Años", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLMesesFechaNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Meses", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLDiasFechaNacimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPFechaNacimientoLayout = new GroupLayout(this.JPFechaNacimiento);
        this.JPFechaNacimiento.setLayout(JPFechaNacimientoLayout);
        JPFechaNacimientoLayout.setHorizontalGroup(JPFechaNacimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFechaNacimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JLAnioFechaNacimiento, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLMesesFechaNacimiento, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLDiasFechaNacimiento, -2, 93, -2).addContainerGap()));
        JPFechaNacimientoLayout.setVerticalGroup(JPFechaNacimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFechaNacimientoLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPFechaNacimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLDiasFechaNacimiento, -2, 41, -2).addComponent(this.JLMesesFechaNacimiento, -1, -1, 32767).addComponent(this.JLAnioFechaNacimiento, -1, -1, 32767)).addContainerGap()));
        this.JPFechaAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha De Atencion", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLAnioFechaAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Años", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLMesesFechaAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Meses", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLDiasFechaAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPFechaAtencionLayout = new GroupLayout(this.JPFechaAtencion);
        this.JPFechaAtencion.setLayout(JPFechaAtencionLayout);
        JPFechaAtencionLayout.setHorizontalGroup(JPFechaAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFechaAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JLAnioFechaAtencion, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLMesesFechaAtencion, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLDiasFechaAtencion, -2, 93, -2).addContainerGap(-1, 32767)));
        JPFechaAtencionLayout.setVerticalGroup(JPFechaAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFechaAtencionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPFechaAtencionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLDiasFechaAtencion, -2, 41, -2).addComponent(this.JLMesesFechaAtencion, -2, 41, -2).addComponent(this.JLAnioFechaAtencion, -2, 41, -2)).addContainerGap()));
        this.JPEdadCorregida.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Corregida", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLAnioEdadCorregida.setBorder(BorderFactory.createTitledBorder((Border) null, "Años", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLMesesEdadCorrigida.setBorder(BorderFactory.createTitledBorder((Border) null, "Meses", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLDiasEdadCorregida.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPEdadCorregidaLayout = new GroupLayout(this.JPEdadCorregida);
        this.JPEdadCorregida.setLayout(JPEdadCorregidaLayout);
        JPEdadCorregidaLayout.setHorizontalGroup(JPEdadCorregidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEdadCorregidaLayout.createSequentialGroup().addContainerGap().addComponent(this.JLAnioEdadCorregida, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLMesesEdadCorrigida, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLDiasEdadCorregida, -2, 93, -2).addContainerGap(-1, 32767)));
        JPEdadCorregidaLayout.setVerticalGroup(JPEdadCorregidaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEdadCorregidaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPEdadCorregidaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLDiasEdadCorregida, -2, 41, -2).addComponent(this.JLMesesEdadCorrigida, -2, 41, -2).addComponent(this.JLAnioEdadCorregida, -2, 41, -2)).addContainerGap()));
        this.JPEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Del Niño", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLAnioEdad1.setBorder(BorderFactory.createTitledBorder((Border) null, "Años", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLMesesEdad1.setBorder(BorderFactory.createTitledBorder((Border) null, "Meses", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLDiasEdad1.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPEdadLayout = new GroupLayout(this.JPEdad);
        this.JPEdad.setLayout(JPEdadLayout);
        JPEdadLayout.setHorizontalGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEdadLayout.createSequentialGroup().addContainerGap().addComponent(this.JLAnioEdad1, -2, 101, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLMesesEdad1, -2, 94, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLDiasEdad1, -2, 93, -2).addContainerGap(-1, 32767)));
        JPEdadLayout.setVerticalGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPEdadLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPEdadLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLDiasEdad1, -2, 41, -2).addComponent(this.JLMesesEdad1, -2, 41, -2).addComponent(this.JLAnioEdad1, -2, 41, -2)).addContainerGap()));
        this.JLRango.setFont(new Font("Arial", 1, 12));
        this.JLRango.setBorder(BorderFactory.createTitledBorder((Border) null, "Rango", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPEdad, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPFechaAtencion, -1, -1, 32767).addComponent(this.JPFechaNacimiento, -1, -1, 32767))).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JPEdadCorregida, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPSemanasDeGestacion, -2, 173, -2).addComponent(this.JCEsPrematuro).addComponent(this.JBCalcularEdad, -2, 161, -2).addComponent(this.JLRango, -2, 243, -2)).addGap(34, 34, 34)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JPFechaNacimiento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPFechaAtencion, -2, -1, -2).addGap(22, 22, 22).addComponent(this.JPEdad, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPEdadCorregida, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCEsPrematuro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPSemanasDeGestacion, -2, -1, -2).addGap(26, 26, 26).addComponent(this.JBCalcularEdad, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLRango, -2, 50, -2).addGap(0, 0, 32767))).addContainerGap(37, 32767)));
        GroupLayout JPCalcularRangoLayout = new GroupLayout(this.JPCalcularRango);
        this.JPCalcularRango.setLayout(JPCalcularRangoLayout);
        JPCalcularRangoLayout.setHorizontalGroup(JPCalcularRangoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767));
        JPCalcularRangoLayout.setVerticalGroup(JPCalcularRangoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCalcularRangoLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 185, 32767)));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Calculo De Edad", this.JPCalcularRango);
        this.JPMotrocidadGruesa.setFont(new Font("Arial", 1, 12));
        this.JPMotrocidadGruesa.setName("");
        this.JSPMotrocidadGruesa.setName("Motricidad Gruesa");
        this.JTMotrocidadGruesa.setFont(new Font("Arial", 1, 12));
        this.JTMotrocidadGruesa.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTMotrocidadGruesa.setSelectionBackground(Color.white);
        this.JTMotrocidadGruesa.setSelectionForeground(Color.red);
        this.JTMotrocidadGruesa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.5
            public void mouseReleased(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JTMotrocidadGruesaMouseReleased(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JTMotrocidadGruesaMouseClicked(evt);
            }
        });
        this.JSPMotrocidadGruesa.setViewportView(this.JTMotrocidadGruesa);
        this.JLPuntuacionDirectaMotricidadGruesa.setFont(new Font("Arial", 1, 12));
        this.JLPuntuacionDirectaMotricidadGruesa.setText("Puntuacion Directa :");
        GroupLayout JPMotrocidadGruesaLayout = new GroupLayout(this.JPMotrocidadGruesa);
        this.JPMotrocidadGruesa.setLayout(JPMotrocidadGruesaLayout);
        JPMotrocidadGruesaLayout.setHorizontalGroup(JPMotrocidadGruesaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMotrocidadGruesa, -1, 696, 32767).addGroup(JPMotrocidadGruesaLayout.createSequentialGroup().addComponent(this.JLPuntuacionDirectaMotricidadGruesa, -2, 167, -2).addGap(167, 529, 32767)));
        JPMotrocidadGruesaLayout.setVerticalGroup(JPMotrocidadGruesaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMotrocidadGruesaLayout.createSequentialGroup().addComponent(this.JSPMotrocidadGruesa, -2, 559, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPuntuacionDirectaMotricidadGruesa, -2, 33, -2).addContainerGap()));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Motricidad Gruesa", this.JPMotrocidadGruesa);
        this.JPMotrocidadFinoadaptiva.setFont(new Font("Arial", 1, 12));
        this.JSPMotricidadFinoadaptativa.setName("Motricidad FinoAdatativa");
        this.JTMotricidadFinoadaptativa.setFont(new Font("Arial", 1, 12));
        this.JTMotricidadFinoadaptativa.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTMotricidadFinoadaptativa.setSelectionBackground(Color.white);
        this.JTMotricidadFinoadaptativa.setSelectionForeground(Color.red);
        this.JTMotricidadFinoadaptativa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.6
            public void mouseClicked(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JTMotricidadFinoadaptativaMouseClicked(evt);
            }
        });
        this.JSPMotricidadFinoadaptativa.setViewportView(this.JTMotricidadFinoadaptativa);
        this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setFont(new Font("Arial", 1, 12));
        this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setText("Puntuacion Directa :");
        GroupLayout JPMotrocidadFinoadaptivaLayout = new GroupLayout(this.JPMotrocidadFinoadaptiva);
        this.JPMotrocidadFinoadaptiva.setLayout(JPMotrocidadFinoadaptivaLayout);
        JPMotrocidadFinoadaptivaLayout.setHorizontalGroup(JPMotrocidadFinoadaptivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMotricidadFinoadaptativa, -1, 690, 32767).addGroup(JPMotrocidadFinoadaptivaLayout.createSequentialGroup().addComponent(this.JLPuntuacionDirectaMotricidadFinoAdaptativa, -2, 167, -2).addGap(0, 0, 32767)));
        JPMotrocidadFinoadaptivaLayout.setVerticalGroup(JPMotrocidadFinoadaptivaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMotrocidadFinoadaptivaLayout.createSequentialGroup().addComponent(this.JSPMotricidadFinoadaptativa, -2, 553, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPuntuacionDirectaMotricidadFinoAdaptativa, -2, 33, -2).addContainerGap(-1, 32767)));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Motricidad  Finoadaptativa", this.JPMotrocidadFinoadaptiva);
        this.JPAudicionLenguaje.setFont(new Font("Arial", 1, 12));
        this.JTAudicionLenguaje.setFont(new Font("Arial", 1, 12));
        this.JTAudicionLenguaje.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTAudicionLenguaje.setSelectionBackground(Color.white);
        this.JTAudicionLenguaje.setSelectionForeground(Color.red);
        this.JTAudicionLenguaje.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.7
            public void mouseClicked(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JTAudicionLenguajeMouseClicked(evt);
            }
        });
        this.JSPAudicionLenguaje.setViewportView(this.JTAudicionLenguaje);
        this.JLPuntuacionDirectaAudicionLenguaje.setFont(new Font("Arial", 1, 12));
        this.JLPuntuacionDirectaAudicionLenguaje.setText("Puntuacion Directa:");
        GroupLayout JPAudicionLenguajeLayout = new GroupLayout(this.JPAudicionLenguaje);
        this.JPAudicionLenguaje.setLayout(JPAudicionLenguajeLayout);
        JPAudicionLenguajeLayout.setHorizontalGroup(JPAudicionLenguajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPAudicionLenguaje, -1, 690, 32767).addGroup(JPAudicionLenguajeLayout.createSequentialGroup().addComponent(this.JLPuntuacionDirectaAudicionLenguaje, -2, 205, -2).addGap(0, 0, 32767)));
        JPAudicionLenguajeLayout.setVerticalGroup(JPAudicionLenguajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAudicionLenguajeLayout.createSequentialGroup().addComponent(this.JSPAudicionLenguaje, -2, 559, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPuntuacionDirectaAudicionLenguaje, -2, 25, -2).addContainerGap()));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Audición Lenguaje", this.JPAudicionLenguaje);
        this.JPPersonalSocial.setFont(new Font("Arial", 1, 12));
        this.JSPPersonalSocial.setName("jajaj");
        this.JTPersonalSocial.setFont(new Font("Arial", 1, 12));
        this.JTPersonalSocial.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTPersonalSocial.setSelectionBackground(Color.white);
        this.JTPersonalSocial.setSelectionForeground(Color.red);
        this.JTPersonalSocial.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.8
            public void mouseClicked(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo.this.JTPersonalSocialMouseClicked(evt);
            }
        });
        this.JSPPersonalSocial.setViewportView(this.JTPersonalSocial);
        this.JLPuntuacionDirectaPersonalSocial.setFont(new Font("Arial", 1, 12));
        this.JLPuntuacionDirectaPersonalSocial.setText("Puntuacion Directa:");
        this.JLPuntuacionDirectaPersonalSocial.setName("JPAEscalaAbreviadaDeDesarrollo");
        GroupLayout JPPersonalSocialLayout = new GroupLayout(this.JPPersonalSocial);
        this.JPPersonalSocial.setLayout(JPPersonalSocialLayout);
        JPPersonalSocialLayout.setHorizontalGroup(JPPersonalSocialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPPersonalSocial, -1, 688, 32767).addGroup(JPPersonalSocialLayout.createSequentialGroup().addComponent(this.JLPuntuacionDirectaPersonalSocial, -2, 186, -2).addGap(0, 0, 32767)));
        JPPersonalSocialLayout.setVerticalGroup(JPPersonalSocialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPersonalSocialLayout.createSequentialGroup().addComponent(this.JSPPersonalSocial, -1, 553, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPuntuacionDirectaPersonalSocial, -2, 33, -2)));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Personal Social", this.JPPersonalSocial);
        GroupLayout JPResultadoGraficaLayout = new GroupLayout(this.JPResultadoGrafica);
        this.JPResultadoGrafica.setLayout(JPResultadoGraficaLayout);
        JPResultadoGraficaLayout.setHorizontalGroup(JPResultadoGraficaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPResultadoGraficaLayout.setVerticalGroup(JPResultadoGraficaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 160, 32767));
        this.jTextField1.setEditable(false);
        this.jTextField1.setBackground(new Color(42, 138, 26));
        this.jTextField1.setFocusable(false);
        this.jLabel1.setFont(new Font("Arial", 1, 13));
        this.jLabel1.setText("Desarollo esperado para la edad");
        this.jLabel2.setFont(new Font("Arial", 1, 13));
        this.jLabel2.setText("Riesgo de problemas en el desarrollo");
        this.jTextField2.setEditable(false);
        this.jTextField2.setBackground(Color.yellow);
        this.jTextField2.setFocusable(false);
        this.jLabel3.setFont(new Font("Arial", 1, 13));
        this.jLabel3.setText("Sospecha de problemas en el desarrollo");
        this.jTextField3.setEditable(false);
        this.jTextField3.setBackground(Color.red);
        this.jTextField3.setFocusable(false);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jTextField3, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addGap(0, 0, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jTextField1, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addGap(56, 56, 56).addComponent(this.jTextField2, -2, 51, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2, -1, 260, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField1, -2, -1, -2).addComponent(this.jLabel1).addComponent(this.jTextField2, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTextField3, -2, -1, -2).addComponent(this.jLabel3)).addContainerGap(16, 32767)));
        GroupLayout JPResultadoLayout = new GroupLayout(this.JPResultado);
        this.JPResultado.setLayout(JPResultadoLayout);
        JPResultadoLayout.setHorizontalGroup(JPResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPResultadoGrafica, -1, -1, 32767).addGroup(JPResultadoLayout.createSequentialGroup().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        JPResultadoLayout.setVerticalGroup(JPResultadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPResultadoLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.JPResultadoGrafica, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addGap(0, 302, 32767)));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Resultado", this.JPResultado);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPEscalaAbreviadaDeDesarrollo));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPEscalaAbreviadaDeDesarrollo, -2, 635, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTMotrocidadGruesaMouseClicked(MouseEvent evt) {
        if (this.guardado == 0) {
            if (this.cuentaClickTablaMotrocidadGruesa == 0) {
                this.cuentaClickTablaMotrocidadGruesa = validacionInicio(this.JTMotrocidadGruesa, this.rango);
            } else if (this.cuentaClickTablaMotrocidadGruesa == 1) {
                int auxiliarValidacion2 = validarValorSegundaPreguntaPorRango(this.modeloMotricidadGruesa);
                if (this.JTMotrocidadGruesa.getSelectedRow() == auxiliarValidacion2 && ((Boolean) this.JTMotrocidadGruesa.getValueAt(auxiliarValidacion2, 6)).booleanValue()) {
                    this.cuentaClickTablaMotrocidadGruesa = auxiliarValidacion2;
                } else {
                    ValidarSelecion();
                    puntoDeInicio();
                }
            } else if (this.puntoFinalDeMotricidadGruesa == -1) {
                ValidarSelecion();
                if (buscarPuntoDeInicio(this.modeloMotricidadGruesa) == -1) {
                    if (this.rango != 1 && this.cuentaClickTablaMotrocidadGruesa < this.JTMotrocidadGruesa.getSelectedRow()) {
                        this.metodos.mostrarMensaje("Debe devolverse al rango anterior hasta hallar un punto de inicio");
                        this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 5);
                        this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 6);
                    }
                } else {
                    this.cuentaClickTablaMotrocidadGruesa = 1;
                }
            } else {
                this.metodos.mostrarMensaje("Ya se establecio un punto de fin");
                this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 5);
                this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 6);
            }
            this.puntoFinalDeMotricidadGruesa = buscaPuntoDeFin(this.modeloMotricidadGruesa);
            if (this.puntoFinalDeMotricidadGruesa != -1) {
                this.puntuacionDirectaMotrocidadGruesa = obtenerPuntuacionDirecta(this.modeloMotricidadGruesa, this.puntoDeInicioMotricidadGruesa, this.puntoFinalDeMotricidadGruesa);
                this.JLPuntuacionDirectaMotricidadGruesa.setText("La Puntuacion directa es: " + this.puntuacionDirectaMotrocidadGruesa);
            }
            System.err.println("va a validar punto de inicio");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTMotricidadFinoadaptativaMouseClicked(MouseEvent evt) {
        if (this.guardado == 0) {
            if (this.cuentaClickTablaMotrocidadFinoadaptativa == 0) {
                this.cuentaClickTablaMotrocidadFinoadaptativa = validacionInicio(this.JTMotricidadFinoadaptativa, this.rango);
            } else if (this.cuentaClickTablaMotrocidadFinoadaptativa == 1) {
                int auxiliarValidacion2 = validarValorSegundaPreguntaPorRango(this.modeloMotricidadFinoadaptativa);
                if (this.JTMotricidadFinoadaptativa.getSelectedRow() == auxiliarValidacion2 && ((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(auxiliarValidacion2, 6)).booleanValue()) {
                    this.cuentaClickTablaMotrocidadFinoadaptativa = auxiliarValidacion2;
                    this.puntoFinalDeMotricidadFinoAdaptativa = buscaPuntoDeFin(this.modeloMotricidadFinoadaptativa);
                } else {
                    ValidarSelecion();
                    puntoDeInicio();
                }
            } else {
                ValidarSelecion();
                if (this.puntoFinalDeMotricidadFinoAdaptativa == -1) {
                    ValidarSelecion();
                    if (buscarPuntoDeInicio(this.modeloMotricidadFinoadaptativa) == -1) {
                        if (this.rango != 1 && this.cuentaClickTablaMotrocidadFinoadaptativa < this.JTMotricidadFinoadaptativa.getSelectedRow()) {
                            this.metodos.mostrarMensaje("Debe devolverse al rango anterior hasta hallar un punto de inicio");
                            this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 5);
                            this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 6);
                        }
                    } else {
                        this.cuentaClickTablaMotrocidadFinoadaptativa = 1;
                    }
                } else {
                    this.metodos.mostrarMensaje("Ya se establecio un punto de fin");
                    this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 5);
                    this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 6);
                }
                puntoDeInicio();
            }
            this.puntoFinalDeMotricidadFinoAdaptativa = buscaPuntoDeFin(this.modeloMotricidadFinoadaptativa);
            if (this.puntoFinalDeMotricidadFinoAdaptativa != -1) {
                this.puntuacionDirectaMotrocidadFinoAdaptiva = obtenerPuntuacionDirecta(this.modeloMotricidadFinoadaptativa, this.puntoDeInicioMotricidadFinoAdaptativa, this.puntoFinalDeMotricidadFinoAdaptativa);
                this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setText("La Puntuacion directa es: " + this.puntuacionDirectaMotrocidadFinoAdaptiva);
            }
            System.err.println("va a validar punto de inicio");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAudicionLenguajeMouseClicked(MouseEvent evt) {
        if (this.guardado == 0) {
            switch (this.cuentaClickTablaAudicionLenguaje) {
                case 0:
                    this.cuentaClickTablaAudicionLenguaje = validacionInicio(this.JTAudicionLenguaje, this.rango);
                    break;
                case 1:
                    int auxiliarValidacion2 = validarValorSegundaPreguntaPorRango(this.modeloAudicionLenguaje);
                    if (this.JTAudicionLenguaje.getSelectedRow() == auxiliarValidacion2 && ((Boolean) this.JTAudicionLenguaje.getValueAt(auxiliarValidacion2, 6)).booleanValue()) {
                        this.cuentaClickTablaAudicionLenguaje = auxiliarValidacion2;
                    } else {
                        ValidarSelecion();
                        puntoDeInicio();
                    }
                    break;
                default:
                    ValidarSelecion();
                    if (this.puntoFinalDeAudicionLenguaje == -1) {
                        if (buscarPuntoDeInicio(this.modeloAudicionLenguaje) == -1) {
                            if (this.rango != 1 && this.cuentaClickTablaAudicionLenguaje < this.JTAudicionLenguaje.getSelectedRow()) {
                                this.metodos.mostrarMensaje("Debe devolverse al rango anterior hasta hallar un punto de inicio");
                                this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 5);
                                this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 6);
                            }
                        } else {
                            this.cuentaClickTablaAudicionLenguaje = 1;
                        }
                    } else {
                        this.metodos.mostrarMensaje("Ya se establecio un punto de fin");
                        this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 5);
                        this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 6);
                    }
                    break;
            }
            this.puntoFinalDeAudicionLenguaje = buscaPuntoDeFin(this.modeloAudicionLenguaje);
            if (this.puntoFinalDeAudicionLenguaje != -1) {
                this.puntuacionDirectaAudicionLenguaje = obtenerPuntuacionDirecta(this.modeloAudicionLenguaje, this.puntoDeInicioAudicionLenguaje, this.puntoFinalDeAudicionLenguaje);
                this.JLPuntuacionDirectaAudicionLenguaje.setText("La Puntuacion directa es: " + this.puntuacionDirectaAudicionLenguaje);
            }
            System.err.println("va a validar punto de inicio");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPersonalSocialMouseClicked(MouseEvent evt) {
        if (this.guardado == 0) {
            if (this.cuentaClickTablaPersonalSocial == 0) {
                this.cuentaClickTablaPersonalSocial = validacionInicio(this.JTPersonalSocial, this.rango);
            } else if (this.cuentaClickTablaPersonalSocial == 1) {
                int auxiliarValidacion2 = validarValorSegundaPreguntaPorRango(this.modeloPersonalSocial);
                if (this.JTPersonalSocial.getSelectedRow() == auxiliarValidacion2 && ((Boolean) this.JTPersonalSocial.getValueAt(auxiliarValidacion2, 6)).booleanValue()) {
                    this.cuentaClickTablaPersonalSocial = auxiliarValidacion2;
                } else {
                    ValidarSelecion();
                    puntoDeInicio();
                }
            } else {
                ValidarSelecion();
                if (this.puntoFinalDePersonalSocial == -1) {
                    if (buscarPuntoDeInicio(this.modeloPersonalSocial) == -1) {
                        if (this.rango != 1 && this.cuentaClickTablaPersonalSocial < this.JTPersonalSocial.getSelectedRow()) {
                            this.metodos.mostrarMensaje("Debe devolverse al rango anterior hasta hallar un punto de inicio");
                            this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 5);
                            this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 6);
                        }
                    } else {
                        this.cuentaClickTablaPersonalSocial = 1;
                    }
                } else {
                    this.metodos.mostrarMensaje("Ya se establecio un punto de fin");
                    this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 5);
                    this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 6);
                }
            }
            this.puntoFinalDePersonalSocial = buscaPuntoDeFin(this.modeloPersonalSocial);
            if (this.puntoFinalDePersonalSocial != -1) {
                this.puntuacionDirectaPersonalSocial = obtenerPuntuacionDirecta(this.modeloPersonalSocial, this.puntoDeInicioPersonalSocial, this.puntoFinalDePersonalSocial);
                this.JLPuntuacionDirectaPersonalSocial.setText("La Puntuacion directa es: " + this.puntuacionDirectaPersonalSocial);
            }
            System.err.println("va a validar punto de inicio");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCalcularEdadActionPerformed(ActionEvent evt) {
        calcularEdadCorregidaRefac();
    }

    private void calcularEdadCorregida(String fechaAtencion) {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            if (this.JCEsPrematuro.isSelected()) {
                int semanas = 40 - Integer.parseInt(this.JSPSemanasDeGestacion.getValue().toString());
                int semanasTotales = 7 * semanas;
                int calculoDiaCorregido = 0;
                int calculoMesCorregido = 0;
                int calculoAnioCorregido = 0;
                System.out.println("semanasTotales -> " + semanasTotales);
                if (Integer.parseInt(this.JLDiasEdad1.getText()) < semanasTotales) {
                    switch (semanasTotales) {
                        case 35:
                        case 42:
                        case 49:
                        case 56:
                            calculoDiaCorregido = (Integer.parseInt(this.JLDiasEdad1.getText()) + 30) - semanasTotales;
                            if (calculoDiaCorregido < 0) {
                                calculoDiaCorregido += 31;
                            }
                            if (Integer.parseInt(this.JLMesesEdad1.getText()) == 0) {
                                calculoMesCorregido = 11;
                            } else if (semanasTotales == 56) {
                                calculoMesCorregido = Integer.parseInt(this.JLMesesEdad1.getText()) - 2;
                            } else {
                                calculoMesCorregido = Integer.parseInt(this.JLMesesEdad1.getText()) - 1;
                            }
                            break;
                        case 63:
                        case 70:
                        case 77:
                        case 84:
                            calculoDiaCorregido = (Integer.parseInt(this.JLDiasEdad1.getText()) + 60) - semanasTotales;
                            if (calculoDiaCorregido < 0) {
                                calculoDiaCorregido += 31;
                            }
                            switch (Integer.parseInt(this.JLMesesEdad1.getText())) {
                                case 0:
                                    calculoMesCorregido = 10;
                                    break;
                                case 1:
                                    calculoMesCorregido = 11;
                                    break;
                                default:
                                    calculoMesCorregido = (semanasTotales == 63 || semanasTotales == 70 || semanasTotales == 77) ? Integer.parseInt(this.JLMesesEdad1.getText()) - 2 : Integer.parseInt(this.JLMesesEdad1.getText()) - 3;
                                    break;
                            }
                            break;
                        case 91:
                        case 98:
                        case 105:
                        case 112:
                            calculoDiaCorregido = (Integer.parseInt(this.JLDiasEdad1.getText()) + 90) - semanasTotales;
                            if (calculoDiaCorregido < 0) {
                                calculoDiaCorregido += 31;
                            }
                            switch (Integer.parseInt(this.JLMesesEdad1.getText())) {
                                case 0:
                                    calculoMesCorregido = 9;
                                    break;
                                case 1:
                                    calculoMesCorregido = 10;
                                    break;
                                case 2:
                                    calculoMesCorregido = 11;
                                    break;
                                default:
                                    calculoMesCorregido = (semanasTotales == 98 || semanasTotales == 105 || semanasTotales == 112) ? Integer.parseInt(this.JLMesesEdad1.getText()) - 4 : Integer.parseInt(this.JLMesesEdad1.getText()) - 3;
                                    break;
                            }
                            break;
                        case 119:
                        case 126:
                        case 133:
                        case 140:
                        case 147:
                            calculoDiaCorregido = (Integer.parseInt(this.JLDiasEdad1.getText()) + 120) - semanasTotales;
                            if (calculoDiaCorregido < 0) {
                                calculoDiaCorregido += 31;
                            }
                            switch (Integer.parseInt(this.JLMesesEdad1.getText())) {
                                case 0:
                                    calculoMesCorregido = 8;
                                    break;
                                case 1:
                                    calculoMesCorregido = 9;
                                    break;
                                case 2:
                                    calculoMesCorregido = 10;
                                    break;
                                case 3:
                                    calculoMesCorregido = 11;
                                    break;
                                default:
                                    calculoMesCorregido = (semanasTotales == 140 || semanasTotales == 147) ? Integer.parseInt(this.JLMesesEdad1.getText()) - 5 : Integer.parseInt(this.JLMesesEdad1.getText()) - 4;
                                    break;
                            }
                            break;
                        case 154:
                        case 161:
                        case 168:
                        case 175:
                            int calculoDiaCorregido2 = (Integer.parseInt(this.JLDiasEdad1.getText()) + 150) - semanasTotales;
                            if (calculoDiaCorregido2 < 0) {
                                int i = calculoDiaCorregido2 + 31;
                            }
                            switch (Integer.parseInt(this.JLMesesEdad1.getText())) {
                                case 0:
                                    break;
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    break;
                                case 4:
                                    break;
                                default:
                                    int i2 = Integer.parseInt(this.JLMesesEdad1.getText()) - 6;
                                    break;
                            }
                        default:
                            calculoDiaCorregido = (Integer.parseInt(this.JLDiasEdad1.getText()) + 30) - semanasTotales;
                            if (Integer.parseInt(this.JLMesesEdad1.getText()) > 0) {
                                calculoMesCorregido = Integer.parseInt(this.JLMesesEdad1.getText()) - 1;
                                calculoAnioCorregido = Integer.parseInt(this.JLAnioEdad1.getText());
                            } else {
                                calculoMesCorregido = 11;
                                calculoAnioCorregido = Integer.parseInt(this.JLAnioEdad1.getText()) == 0 ? Integer.parseInt(this.JLAnioEdad1.getText()) : Integer.parseInt(this.JLAnioEdad1.getText()) - 1;
                            }
                            break;
                    }
                    if (Integer.parseInt(this.JLMesesEdad1.getText()) == 0) {
                        calculoAnioCorregido = 0;
                    }
                } else if (Integer.parseInt(this.JLDiasEdad1.getText()) >= semanasTotales) {
                    calculoDiaCorregido = Integer.parseInt(this.JLDiasEdad1.getText()) - semanasTotales;
                    calculoMesCorregido = Integer.parseInt(this.JLMesesEdad1.getText());
                    calculoAnioCorregido = Integer.parseInt(this.JLAnioEdad1.getText());
                }
                String diaCorregido = Integer.toString(calculoDiaCorregido);
                String mesCorregido = Integer.toString(calculoMesCorregido);
                String anioCorregido = Integer.toString(calculoAnioCorregido);
                System.out.println("dia corregido --> " + diaCorregido);
                System.out.println("mes corregido --> " + mesCorregido);
                System.out.println("año corregido --> " + anioCorregido);
                this.JLAnioEdadCorregida.setText(anioCorregido);
                this.JLMesesEdadCorrigida.setText(mesCorregido);
                this.JLDiasEdadCorregida.setText(diaCorregido);
            }
            String anioAtencion = this.JLAnioFechaAtencion.getText() + "-";
            String mesAtencion = this.JLMesesFechaAtencion.getText() + "-";
            String diaAtencion = this.JLDiasFechaAtencion.getText();
            String anioNacimiento = this.JLAnioFechaNacimiento.getText() + "-";
            String mesNacimiento = this.JLMesesFechaNacimiento.getText() + "-";
            String diaNacimiento = this.JLDiasFechaNacimiento.getText();
            String fechaAtencion2 = anioAtencion + mesAtencion + diaAtencion;
            this.fechaCorregida = anioNacimiento + mesNacimiento + diaNacimiento;
            System.out.println("fecha de atencion:: " + fechaAtencion2);
            System.out.println("fecha corregida:: " + this.fechaCorregida);
            this.rango = this.escalaAbreviadaDesarrolloDAO.traerRango(fechaAtencion2, this.fechaCorregida);
            this.JLRango.setText("El rango del paciente es de: " + this.rango);
            return;
        }
        if (this.JCEsPrematuro.isSelected()) {
            try {
                String anio = this.JLAnioEdad1.getText();
                String mes = this.JLMesesEdad1.getText();
                String dia = this.JLDiasEdad1.getText();
                System.out.println("año: " + anio);
                int sumaDias = Integer.parseInt(dia) + 30;
                System.out.println("la diferencia en dias es: " + sumaDias);
                int diferenciaMes = Integer.parseInt(mes) - 1;
                System.out.println("la diferencia en mes es: " + diferenciaMes);
                String numeroDeSemanas = this.JSPSemanasDeGestacion.getValue().toString();
                int calculoDeSemanas = 40 - Integer.parseInt(numeroDeSemanas);
                System.out.println("diferencia semanas de gestacion: " + calculoDeSemanas);
                int semanasTotales2 = 7 * calculoDeSemanas;
                int diaTotal = sumaDias - semanasTotales2;
                System.out.println("semanas totales: " + semanasTotales2);
                String mesCorregido2 = Integer.toString(diferenciaMes);
                String diaCorregido2 = Integer.toString(diaTotal);
                this.JLAnioEdadCorregida.setText(anio);
                this.JLMesesEdadCorrigida.setText(mesCorregido2);
                this.JLDiasEdadCorregida.setText(diaCorregido2);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        String anioAtencion2 = this.JLAnioFechaAtencion.getText() + "-";
        String mesAtencion2 = this.JLMesesFechaAtencion.getText() + "-";
        String diaAtencion2 = this.JLDiasFechaAtencion.getText();
        String anioNacimiento2 = this.JLAnioFechaNacimiento.getText() + "-";
        String mesNacimiento2 = this.JLMesesFechaNacimiento.getText() + "-";
        String diaNacimiento2 = this.JLDiasFechaNacimiento.getText();
        String fechaAtencion3 = anioAtencion2 + mesAtencion2 + diaAtencion2;
        this.fechaCorregida = anioNacimiento2 + mesNacimiento2 + diaNacimiento2;
        System.out.println("fecha de atencion:: " + fechaAtencion3);
        System.out.println("fecha corregida:: " + this.fechaCorregida);
        this.rango = this.escalaAbreviadaDesarrolloDAO.traerRango(fechaAtencion3, this.fechaCorregida);
        this.JLRango.setText("El rango del paciente es de: " + this.rango);
    }

    private void calcularEdadCorregidaRefac() {
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            if (this.JCEsPrematuro.isSelected()) {
                int semanas = Integer.parseInt(this.JSPSemanasDeGestacion.getValue().toString());
                int semanas2 = 40 - semanas;
                LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(this.JLAnioFechaNacimiento.getText()), Integer.parseInt(this.JLMesesFechaNacimiento.getText()), Integer.parseInt(this.JLDiasFechaNacimiento.getText()));
                LocalDate fechaEvaluacion = LocalDate.of(Integer.parseInt(this.JLAnioFechaAtencion.getText()), Integer.parseInt(this.JLMesesFechaAtencion.getText()), Integer.parseInt(this.JLDiasFechaAtencion.getText()));
                LocalDate fechaCorregidaE = fechaNacimiento.plusWeeks(semanas2);
                Period edadCorregida = Period.between(fechaCorregidaE, fechaEvaluacion);
                System.out.printf("----EDAD CORREGIDA----%d anios, %d meses, %d dias\n", Integer.valueOf(edadCorregida.getYears()), Integer.valueOf(edadCorregida.getMonths()), Integer.valueOf(edadCorregida.getDays()));
                this.JLAnioEdadCorregida.setText(Integer.toString(edadCorregida.getYears()));
                this.JLMesesEdadCorrigida.setText(Integer.toString(edadCorregida.getMonths()));
                this.JLDiasEdadCorregida.setText(Integer.toString(edadCorregida.getDays()));
                this.fechaCorregida = fechaCorregidaE.toString();
                this.rango = this.escalaAbreviadaDesarrolloDAO.traerRango(fechaEvaluacion.toString(), this.fechaCorregida);
                this.JLRango.setText("El rango del paciente es de :" + this.rango);
                return;
            }
            return;
        }
        if (this.JCEsPrematuro.isSelected()) {
            try {
                String anio = this.JLAnioEdad1.getText();
                String mes = this.JLMesesEdad1.getText();
                String dia = this.JLDiasEdad1.getText();
                System.out.println("año: " + anio);
                int sumaDias = Integer.parseInt(dia) + 30;
                System.out.println("la diferencia en dias es: " + sumaDias);
                int diferenciaMes = Integer.parseInt(mes) - 1;
                System.out.println("la diferencia en mes es: " + diferenciaMes);
                String numeroDeSemanas = this.JSPSemanasDeGestacion.getValue().toString();
                int calculoDeSemanas = 40 - Integer.parseInt(numeroDeSemanas);
                System.out.println("diferencia semanas de gestacion: " + calculoDeSemanas);
                int semanasTotales = 7 * calculoDeSemanas;
                int diaTotal = sumaDias - semanasTotales;
                System.out.println("semanas totales: " + semanasTotales);
                String mesCorregido = Integer.toString(diferenciaMes);
                String diaCorregido = Integer.toString(diaTotal);
                this.JLAnioEdadCorregida.setText(anio);
                this.JLMesesEdadCorrigida.setText(mesCorregido);
                this.JLDiasEdadCorregida.setText(diaCorregido);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        String anioAtencion = this.JLAnioFechaAtencion.getText() + "-";
        String mesAtencion = this.JLMesesFechaAtencion.getText() + "-";
        String diaAtencion = this.JLDiasFechaAtencion.getText();
        String anioNacimiento = this.JLAnioFechaNacimiento.getText() + "-";
        String mesNacimiento = this.JLMesesFechaNacimiento.getText() + "-";
        String diaNacimiento = this.JLDiasFechaNacimiento.getText();
        this.fechaAtencion = anioAtencion + mesAtencion + diaAtencion;
        this.fechaCorregida = anioNacimiento + mesNacimiento + diaNacimiento;
        System.out.println("fecha de atencion:: " + this.fechaAtencion);
        System.out.println("fecha corregida:: " + this.fechaCorregida);
        this.rango = this.escalaAbreviadaDesarrolloDAO.traerRango(this.fechaAtencion, this.fechaCorregida);
        this.JLRango.setText("El rango del paciente es de: " + this.rango);
    }

    private void mostrarRango(String fechaAtencion) {
        String anioAtencion = this.JLAnioFechaAtencion.getText() + "-";
        String mesAtencion = this.JLMesesFechaAtencion.getText() + "-";
        String diaAtencion = this.JLDiasFechaAtencion.getText();
        String anioNacimiento = this.JLAnioFechaNacimiento.getText() + "-";
        String mesNacimiento = this.JLMesesFechaNacimiento.getText() + "-";
        String diaNacimiento = this.JLDiasFechaNacimiento.getText();
        String fechaAtencion2 = anioAtencion + mesAtencion + diaAtencion;
        this.fechaCorregida = anioNacimiento + mesNacimiento + diaNacimiento;
        System.out.println("fecha de atencion:: " + fechaAtencion2);
        System.out.println("fecha corregida:: " + this.fechaCorregida);
        this.rango = this.escalaAbreviadaDesarrolloDAO.traerRango(fechaAtencion2, this.fechaCorregida);
        this.JLRango.setText("El rango del paciente es de: " + this.rango);
    }

    private void calcularEdad(String edad, String fechaAtencion) {
        try {
            String text = this.JLAnioFechaAtencion.getText();
            String mes = this.JLMesesFechaAtencion.getText();
            String dia = this.JLDiasFechaAtencion.getText();
            String fechaAtenc = text + "-" + mes + "-" + dia;
            System.out.println("feCHAA de atencion " + fechaAtenc);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNac = LocalDate.parse(this.fechaDeNacimiento, format);
            System.out.println("fecha de nacimiento para usar " + fechaNac);
            LocalDate fechaAtencE = LocalDate.parse(fechaAtenc, format);
            System.out.println("fecha de atencion para usar " + fechaAtencE);
            Period edadR = Period.between(fechaNac, fechaAtencE);
            System.out.println("fecha de atencion: " + fechaAtencE);
            System.out.println(String.format("%d años, %d meses y %d días", Integer.valueOf(edadR.getYears()), Integer.valueOf(edadR.getMonths()), Integer.valueOf(edadR.getDays())));
            String edadSanio = Integer.toString(edadR.getYears());
            String edadSmes = Integer.toString(edadR.getMonths());
            String edadSdia = Integer.toString(edadR.getDays());
            this.JLAnioEdad1.setText(edadSanio);
            this.JLMesesEdad1.setText(edadSmes);
            this.JLDiasEdad1.setText(edadSdia);
        } catch (Exception e) {
            System.out.println("Error");
        }
        String text2 = this.JLAnioFechaNacimiento.getText();
        String mes2 = this.JLMesesFechaNacimiento.getText();
        String dia2 = this.JLDiasFechaNacimiento.getText();
        this.fechaCorregida = text2 + mes2 + dia2;
        System.out.println("edad corregida: " + this.fechaCorregida);
        this.rango = this.escalaAbreviadaDesarrolloDAO.traerRango(fechaAtencion, this.fechaCorregida);
        this.JLRango.setText("El rango del paciente es de: " + this.rango);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCEsPrematuroActionPerformed(ActionEvent evt) {
        if (this.JCEsPrematuro.isSelected()) {
            this.JPEdadCorregida.setVisible(true);
            this.JSPSemanasDeGestacion.setEnabled(true);
            this.JBCalcularEdad.setEnabled(true);
        } else {
            this.JPEdadCorregida.setVisible(false);
            this.JSPSemanasDeGestacion.setEnabled(false);
            this.JBCalcularEdad.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTMotrocidadGruesaMouseReleased(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEscalaAbreviadaDeDesarrolloStateChanged(ChangeEvent evt) {
        if (this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex() == 5 && this.puntoFinalDeAudicionLenguaje > 0 && this.puntoFinalDeMotricidadFinoAdaptativa > 0 && this.puntoFinalDeMotricidadGruesa > 0 && this.puntoFinalDePersonalSocial > 0) {
            this.puntuacionTipicaYDirecta[0] = this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(this.puntuacionDirectaMotrocidadGruesa, 1, this.rango);
            this.puntuacionTipicaYDirecta[1] = this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(this.puntuacionDirectaMotrocidadFinoAdaptiva, 2, this.rango);
            this.puntuacionTipicaYDirecta[2] = this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(this.puntuacionDirectaAudicionLenguaje, 3, this.rango);
            this.puntuacionTipicaYDirecta[3] = this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(this.puntuacionDirectaPersonalSocial, 4, this.rango);
            this.puntuacionTipicaYDirecta[4] = this.puntuacionDirectaMotrocidadGruesa;
            this.puntuacionTipicaYDirecta[5] = this.puntuacionDirectaMotrocidadFinoAdaptiva;
            this.puntuacionTipicaYDirecta[6] = this.puntuacionDirectaAudicionLenguaje;
            this.puntuacionTipicaYDirecta[7] = this.puntuacionDirectaPersonalSocial;
            this.JPResultadoGrafica.removeAll();
            JPEAD_PuntuacionGrafica jPEADPuntuacionGrafica = new JPEAD_PuntuacionGrafica(this.rango, this.puntuacionTipicaYDirecta);
            jPEADPuntuacionGrafica.setVisible(true);
            jPEADPuntuacionGrafica.setBounds(3, 15, 810, 115);
            this.JPResultadoGrafica.add(jPEADPuntuacionGrafica);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPSemanasDeGestacionKeyPressed(KeyEvent evt) {
    }

    private void inicializarDatos(String idAtencion) {
        boolean[] cantidadColumnasEditables;
        System.out.println("idAtencion -> " + idAtencion);
        int evaluacion = this.escalaAbreviadaDesarrolloDAO.traerEvaluacion(Integer.parseInt(idAtencion));
        List<Object[]> listaEncabezadoResultado = this.escalaAbreviadaDesarrolloDAO.listaEncabezado(Integer.parseInt(idAtencion));
        if (listaEncabezadoResultado.isEmpty()) {
            cantidadColumnasEditables = new boolean[]{false, false, false, false, false, true, true};
        } else {
            cantidadColumnasEditables = new boolean[]{false, false, false, false, false, false, false};
        }
        this.modeloAudicionLenguaje = crearModelo(cantidadColumnasEditables);
        this.modeloMotricidadFinoadaptativa = crearModelo(cantidadColumnasEditables);
        this.modeloMotricidadGruesa = crearModelo(cantidadColumnasEditables);
        this.modeloPersonalSocial = crearModelo(cantidadColumnasEditables);
        iniciarTabla(this.JTMotrocidadGruesa, this.modeloMotricidadGruesa);
        iniciarTabla(this.JTMotricidadFinoadaptativa, this.modeloMotricidadFinoadaptativa);
        iniciarTabla(this.JTAudicionLenguaje, this.modeloAudicionLenguaje);
        iniciarTabla(this.JTPersonalSocial, this.modeloPersonalSocial);
        CargarDatos(1, this.modeloMotricidadGruesa, evaluacion);
        CargarDatos(2, this.modeloMotricidadFinoadaptativa, evaluacion);
        CargarDatos(3, this.modeloAudicionLenguaje, evaluacion);
        CargarDatos(4, this.modeloPersonalSocial, evaluacion);
        String[] fechaNacimeintoVector = this.fechaDeNacimiento.split("-");
        this.JLAnioFechaNacimiento.setText(fechaNacimeintoVector[0]);
        this.JLMesesFechaNacimiento.setText(fechaNacimeintoVector[1]);
        this.JLDiasFechaNacimiento.setText(fechaNacimeintoVector[2]);
        List<Object[]> listaFechaIngreso = this.escalaAbreviadaDesarrolloDAO.listaFechaIngreso(Integer.parseInt(idAtencion));
        System.out.println("la lista de la fecha de ingreso es ::: ---- " + listaFechaIngreso);
        String[] fechaAtencion = listaFechaIngreso.get(0)[0].toString().split("-");
        System.out.println("la fecha de atencion es --->>>> " + Arrays.toString(fechaAtencion));
        this.JLAnioFechaAtencion.setText(fechaAtencion[0]);
        this.JLMesesFechaAtencion.setText(fechaAtencion[1]);
        this.JLDiasFechaAtencion.setText(fechaAtencion[2]);
        calcularEdad(this.edad, Arrays.toString(fechaAtencion));
    }

    private void iniciarTabla(JTable tablaGenerica, DefaultTableModel modeloGenerico) {
        tablaGenerica.setModel(modeloGenerico);
        tablaGenerica.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaGenerica.getColumnModel().getColumn(0).setMinWidth(0);
        tablaGenerica.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaGenerica.getColumnModel().getColumn(1).setPreferredWidth(80);
        tablaGenerica.getColumnModel().getColumn(2).setPreferredWidth(80);
        tablaGenerica.getColumnModel().getColumn(3).setPreferredWidth(350);
        tablaGenerica.getColumnModel().getColumn(4).setPreferredWidth(0);
        tablaGenerica.getColumnModel().getColumn(4).setMinWidth(0);
        tablaGenerica.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaGenerica.getColumnModel().getColumn(5).setPreferredWidth(90);
        tablaGenerica.getColumnModel().getColumn(6).setPreferredWidth(90);
    }

    public void puntoDeInicio() {
        boolean casoRango12 = false;
        if (this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex() > 0) {
            casoRango12 = validacionRango12(this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex());
        }
        switch (this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex()) {
            case 1:
                System.err.println("se esta mostrando el panel MotrocidadGruesa");
                if (this.JTMotrocidadGruesa.getSelectedRow() != -1) {
                    this.puntoDeInicioMotricidadGruesa = buscarPuntoDeInicio(this.modeloMotricidadGruesa);
                    if (this.JTMotrocidadGruesa.getSelectedColumn() == 5) {
                        this.puntoFinalDeMotricidadGruesa = buscaPuntoDeFin(this.modeloMotricidadGruesa);
                        System.out.println("punto final motricidad gruesaaa -> " + this.puntoFinalDeMotricidadGruesa);
                        if (this.puntoFinalDeMotricidadGruesa != -1 && !casoRango12) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 5);
                            this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 6);
                        }
                    }
                    if (this.JTMotrocidadGruesa.getSelectedColumn() == 6) {
                        if (this.puntoFinalDeMotricidadGruesa != -1 && !casoRango12) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 5);
                            this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 6);
                        } else {
                            this.puntoFinalDeMotricidadGruesa = buscaPuntoDeFin(this.modeloMotricidadGruesa);
                        }
                    }
                    System.out.println("punto de inicio " + this.puntoDeInicioMotricidadGruesa);
                    System.out.println("punto de fin motricidad gruesa" + this.puntoFinalDeMotricidadGruesa);
                    if (this.puntoFinalDeMotricidadGruesa != -1) {
                        this.puntuacionDirectaMotrocidadGruesa = obtenerPuntuacionDirecta(this.modeloMotricidadGruesa, this.puntoDeInicioMotricidadGruesa, this.puntoFinalDeMotricidadGruesa);
                        this.JLPuntuacionDirectaMotricidadGruesa.setText("Puntuacion Directa: " + obtenerPuntuacionDirecta(this.modeloMotricidadGruesa, this.puntoDeInicioMotricidadGruesa, this.puntoFinalDeMotricidadGruesa));
                    }
                }
                break;
            case 2:
                System.err.println("se esta mostrando el panel MotrocidadFinoAdaptativa");
                if (this.JTMotricidadFinoadaptativa.getSelectedRow() != -1) {
                    this.puntoDeInicioMotricidadFinoAdaptativa = buscarPuntoDeInicio(this.modeloMotricidadFinoadaptativa);
                    if (this.JTMotricidadFinoadaptativa.getSelectedColumn() == 5) {
                        this.puntoFinalDeMotricidadFinoAdaptativa = buscaPuntoDeFin(this.modeloMotricidadFinoadaptativa);
                        if (this.puntoFinalDeMotricidadFinoAdaptativa != -1 && !casoRango12) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 5);
                            this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 6);
                        }
                    }
                    if (this.JTMotricidadFinoadaptativa.getSelectedColumn() == 6) {
                        if (this.puntoFinalDeMotricidadFinoAdaptativa != -1 && !casoRango12) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 5);
                            this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 6);
                        } else {
                            this.puntoFinalDeMotricidadFinoAdaptativa = buscaPuntoDeFin(this.modeloMotricidadFinoadaptativa);
                        }
                    }
                    this.puntoFinalDeMotricidadFinoAdaptativa = buscaPuntoDeFin(this.modeloMotricidadFinoadaptativa);
                    System.out.println("punto de inicio " + this.puntoDeInicioMotricidadFinoAdaptativa);
                    System.out.println("punto de fin motricidad fino adaptativa" + this.puntoFinalDeMotricidadFinoAdaptativa);
                    if (this.puntoFinalDeMotricidadFinoAdaptativa != -1) {
                        this.puntuacionDirectaMotrocidadFinoAdaptiva = obtenerPuntuacionDirecta(this.modeloMotricidadFinoadaptativa, this.puntoDeInicioMotricidadFinoAdaptativa, this.puntoFinalDeMotricidadFinoAdaptativa);
                        this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setText("Puntuacion Directa: " + obtenerPuntuacionDirecta(this.modeloMotricidadFinoadaptativa, this.puntoDeInicioMotricidadFinoAdaptativa, this.puntoFinalDeMotricidadFinoAdaptativa));
                    }
                }
                break;
            case 3:
                System.err.println("se esta mostrando el panel Audicion Lenguaje");
                if (this.JTAudicionLenguaje.getSelectedRow() != -1) {
                    this.puntoDeInicioAudicionLenguaje = buscarPuntoDeInicio(this.modeloAudicionLenguaje);
                    if (this.JTAudicionLenguaje.getSelectedColumn() == 5) {
                        this.puntoFinalDeAudicionLenguaje = buscaPuntoDeFin(this.modeloAudicionLenguaje);
                        if (this.puntoFinalDeAudicionLenguaje != -1 && !casoRango12) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 5);
                            this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 6);
                        }
                    }
                    if (this.JTAudicionLenguaje.getSelectedColumn() == 6) {
                        if (this.puntoFinalDeAudicionLenguaje != -1 && !casoRango12) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 5);
                            this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 6);
                        } else {
                            this.puntoFinalDeAudicionLenguaje = buscaPuntoDeFin(this.modeloAudicionLenguaje);
                        }
                    }
                    System.out.println("punto de inicio " + this.puntoDeInicioAudicionLenguaje);
                    System.out.println("punto de fin audicion lenguaje" + this.puntoFinalDeAudicionLenguaje);
                    if (this.puntoFinalDeAudicionLenguaje != -1) {
                        this.puntuacionDirectaAudicionLenguaje = obtenerPuntuacionDirecta(this.modeloAudicionLenguaje, this.puntoDeInicioAudicionLenguaje, this.puntoFinalDeAudicionLenguaje);
                        this.JLPuntuacionDirectaAudicionLenguaje.setText("Puntuacion Directa: " + obtenerPuntuacionDirecta(this.modeloAudicionLenguaje, this.puntoDeInicioAudicionLenguaje, this.puntoFinalDeAudicionLenguaje));
                    }
                    System.out.println("punto de inicio " + this.puntoDeInicioAudicionLenguaje);
                }
                break;
            case 4:
                System.err.println("se esta mostrando el panel personal social");
                if (this.JTPersonalSocial.getSelectedRow() != -1) {
                    this.puntoDeInicioPersonalSocial = buscarPuntoDeInicio(this.modeloPersonalSocial);
                    if (this.JTPersonalSocial.getSelectedColumn() == 5) {
                        this.puntoFinalDePersonalSocial = buscaPuntoDeFin(this.modeloPersonalSocial);
                        if (this.puntoFinalDePersonalSocial != -1 && !casoRango12) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 5);
                            this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 6);
                        }
                    }
                    if (this.JTPersonalSocial.getSelectedColumn() == 6) {
                        if (this.puntoFinalDePersonalSocial != -1 && !casoRango12) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 5);
                            this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 6);
                        } else {
                            this.puntoFinalDePersonalSocial = buscaPuntoDeFin(this.modeloPersonalSocial);
                        }
                    }
                    System.out.println("punto de inicio " + this.puntoDeInicioPersonalSocial);
                    System.out.println("punto de fin persona social" + this.puntoFinalDePersonalSocial);
                    if (this.puntoFinalDePersonalSocial != -1) {
                        this.puntuacionDirectaPersonalSocial = obtenerPuntuacionDirecta(this.modeloPersonalSocial, this.puntoDeInicioPersonalSocial, this.puntoFinalDePersonalSocial);
                        this.JLPuntuacionDirectaPersonalSocial.setText("Puntuacion Directa: " + obtenerPuntuacionDirecta(this.modeloPersonalSocial, this.puntoDeInicioPersonalSocial, this.puntoFinalDePersonalSocial));
                    }
                }
                break;
        }
    }

    private int buscaPuntoDeFin(DefaultTableModel modeloGenerico) {
        int auxiliar = 0;
        int puntoOrigen = -1;
        if (validacionRango12(this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex())) {
            System.out.println("ValidacionRago12 true");
            int puntoOrigen2 = modeloGenerico.getRowCount() - 1;
            System.out.println("ValidacionRago12 true " + puntoOrigen2);
            return puntoOrigen2;
        }
        for (int x = 0; x < modeloGenerico.getRowCount(); x++) {
            if (((Boolean) modeloGenerico.getValueAt(x, 6)).booleanValue()) {
                auxiliar++;
            } else {
                auxiliar = 0;
            }
            if (auxiliar == 2) {
                puntoOrigen = x;
            }
        }
        return puntoOrigen;
    }

    private boolean validacionRango12(int tab) {
        boolean rpta;
        switch (tab) {
            case 1:
                int filas = this.JTMotrocidadGruesa.getRowCount();
                if (filas > -1 && this.JTMotrocidadGruesa.getValueAt(filas - 3, 1).toString().equals("12") && ((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 3, 5)).booleanValue() && !((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 3, 6)).booleanValue() && ((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 2, 5)).booleanValue() && !((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 2, 6)).booleanValue() && ((((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 1, 5)).booleanValue() && !((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 1, 6)).booleanValue()) || (!((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 1, 5)).booleanValue() && ((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 1, 6)).booleanValue()))) {
                    return true;
                }
                rpta = false;
                break;
                break;
            case 2:
                int filas2 = this.JTMotricidadFinoadaptativa.getRowCount();
                if (filas2 > -1 && this.JTMotricidadFinoadaptativa.getValueAt(filas2 - 3, 1).toString().equals("12") && ((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 3, 5)).booleanValue() && !((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 3, 6)).booleanValue() && ((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 2, 5)).booleanValue() && !((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 2, 6)).booleanValue() && ((((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 1, 5)).booleanValue() && !((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 1, 6)).booleanValue()) || (!((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 1, 5)).booleanValue() && ((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 1, 6)).booleanValue()))) {
                    return true;
                }
                rpta = false;
                break;
                break;
            case 3:
                int filas3 = this.JTAudicionLenguaje.getRowCount();
                if (filas3 > -1 && this.JTAudicionLenguaje.getValueAt(filas3 - 3, 1).toString().equals("12") && ((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 3, 5)).booleanValue() && !((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 3, 6)).booleanValue() && ((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 2, 5)).booleanValue() && !((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 2, 6)).booleanValue() && ((((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 1, 5)).booleanValue() && !((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 1, 6)).booleanValue()) || (!((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 1, 5)).booleanValue() && ((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 1, 6)).booleanValue()))) {
                    return true;
                }
                rpta = false;
                break;
                break;
            case 4:
                int filas4 = this.JTPersonalSocial.getRowCount();
                if (filas4 > -1 && this.JTPersonalSocial.getValueAt(filas4 - 3, 1).toString().equals("12") && ((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 3, 5)).booleanValue() && !((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 3, 6)).booleanValue() && ((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 2, 5)).booleanValue() && !((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 2, 6)).booleanValue() && ((((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 1, 5)).booleanValue() && !((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 1, 6)).booleanValue()) || (!((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 1, 5)).booleanValue() && ((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 1, 6)).booleanValue()))) {
                    return true;
                }
                rpta = false;
                break;
                break;
            default:
                rpta = false;
                break;
        }
        return rpta;
    }

    boolean ultimoCheckRango12(int tab) {
        boolean ultimoCheckRango12 = false;
        if (validacionRango12(this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex())) {
            switch (tab) {
                case 1:
                    if (((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 3, 5)).booleanValue() && !((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 3, 6)).booleanValue() && ((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 2, 5)).booleanValue() && !((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 2, 6)).booleanValue() && ((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 1, 5)).booleanValue() && !((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getRowCount() - 1, 6)).booleanValue()) {
                        ultimoCheckRango12 = true;
                    }
                    break;
                case 2:
                    if (((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 3, 5)).booleanValue() && !((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 3, 6)).booleanValue() && ((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 2, 5)).booleanValue() && !((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 2, 6)).booleanValue() && ((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 1, 5)).booleanValue() && !((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getRowCount() - 1, 6)).booleanValue()) {
                        ultimoCheckRango12 = true;
                    }
                    break;
                case 3:
                    if (((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 3, 5)).booleanValue() && !((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 3, 6)).booleanValue() && ((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 2, 5)).booleanValue() && !((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 2, 6)).booleanValue() && ((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 1, 5)).booleanValue() && !((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getRowCount() - 1, 6)).booleanValue()) {
                        ultimoCheckRango12 = true;
                    }
                    break;
                case 4:
                    if (((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 3, 5)).booleanValue() && !((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 3, 6)).booleanValue() && ((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 2, 5)).booleanValue() && !((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 2, 6)).booleanValue() && ((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 1, 5)).booleanValue() && !((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getRowCount() - 1, 6)).booleanValue()) {
                        ultimoCheckRango12 = true;
                    }
                    break;
                default:
                    ultimoCheckRango12 = false;
                    break;
            }
        }
        return ultimoCheckRango12;
    }

    private int obtenerPuntuacionDirecta(DefaultTableModel modeloGenerico, int puntoInicio, int puntoFin) {
        int contador = 0;
        validacionRango12(this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex());
        boolean ultimoCheckRango12 = ultimoCheckRango12(this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex());
        if (puntoInicio == 0) {
            puntoInicio = buscarInicio(modeloGenerico);
        }
        if (Integer.parseInt(modeloGenerico.getValueAt(puntoFin, 1).toString()) < this.rango) {
            System.out.println("Termino en un rango menor del calculado");
            for (int x = 0; x < modeloGenerico.getRowCount(); x++) {
                if (((Boolean) modeloGenerico.getValueAt(x, 5)).booleanValue()) {
                    contador++;
                }
            }
            return contador;
        }
        for (int x2 = puntoInicio; x2 < puntoFin; x2++) {
            if (((Boolean) modeloGenerico.getValueAt(x2, 5)).booleanValue()) {
                contador++;
            }
        }
        if (ultimoCheckRango12) {
            return puntoInicio + contador + 1;
        }
        return puntoInicio + contador;
    }

    private int buscarPuntoDeInicio(DefaultTableModel modeloGenerico) {
        int auxiliar = 0;
        int puntoOrigen = -1;
        int x = 0;
        while (true) {
            if (x >= modeloGenerico.getRowCount()) {
                break;
            }
            if (((Boolean) modeloGenerico.getValueAt(x, 5)).booleanValue()) {
                auxiliar++;
            } else {
                auxiliar = 0;
            }
            if (auxiliar != 2) {
                x++;
            } else {
                puntoOrigen = x - 1;
                break;
            }
        }
        return puntoOrigen;
    }

    private int validacionInicio(JTable tablaGenerica, int rango) {
        System.out.println(this.metodos.formatoH24.format(this.metodos.getFechaActual()));
        int conteoGenerico = 0;
        if (Integer.parseInt(tablaGenerica.getValueAt(tablaGenerica.getSelectedRow(), 1).toString()) == rango) {
            if (rango == 1 && tablaGenerica.getSelectedRow() == 0) {
                conteoGenerico = 1;
            } else if (Integer.parseInt(tablaGenerica.getValueAt(tablaGenerica.getSelectedRow() - 1, 1).toString()) == rango) {
                this.metodos.mostrarMensaje("Se debe empezar con la primera pregunta del rango correspondiente ");
                tablaGenerica.setValueAt(false, tablaGenerica.getSelectedRow(), 5);
                tablaGenerica.setValueAt(false, tablaGenerica.getSelectedRow(), 6);
                if (((Boolean) tablaGenerica.getValueAt(tablaGenerica.getSelectedRow(), 5)).booleanValue()) {
                    conteoGenerico = 0;
                }
            } else {
                conteoGenerico = 1;
                if (((Boolean) tablaGenerica.getValueAt(tablaGenerica.getSelectedRow(), 6)).booleanValue()) {
                    conteoGenerico = tablaGenerica.getSelectedRow();
                }
            }
        } else {
            this.metodos.mostrarMensaje("Debe empezar con el rango correspondiente");
            tablaGenerica.setValueAt(false, tablaGenerica.getSelectedRow(), 5);
            tablaGenerica.setValueAt(false, tablaGenerica.getSelectedRow(), 6);
        }
        return conteoGenerico;
    }

    private void ValidarSelecion() {
        switch (this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex()) {
            case 1:
                System.err.println("se esta mostrando el panel MotrocidadGruesa");
                if (this.JTMotrocidadGruesa.getSelectedRow() != -1) {
                    if (this.JTMotrocidadGruesa.getSelectedColumn() == 6) {
                        if (((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getSelectedRow(), 5)).booleanValue()) {
                            this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 5);
                        }
                        System.out.println(" Seleciono No cumple");
                        break;
                    } else if (this.JTMotrocidadGruesa.getSelectedColumn() == 5 && ((Boolean) this.JTMotrocidadGruesa.getValueAt(this.JTMotrocidadGruesa.getSelectedRow(), 6)).booleanValue()) {
                        this.JTMotrocidadGruesa.setValueAt(false, this.JTMotrocidadGruesa.getSelectedRow(), 6);
                        break;
                    }
                }
                break;
            case 2:
                System.err.println("se esta mostrando el panel MotrocidadFinoAdaptativa");
                if (this.JTMotricidadFinoadaptativa.getSelectedRow() != -1) {
                    if (this.JTMotricidadFinoadaptativa.getSelectedColumn() == 6) {
                        if (((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getSelectedRow(), 5)).booleanValue()) {
                            this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 5);
                        }
                        System.out.println(" Seleciono No cumple");
                        break;
                    } else if (this.JTMotricidadFinoadaptativa.getSelectedColumn() == 5 && ((Boolean) this.JTMotricidadFinoadaptativa.getValueAt(this.JTMotricidadFinoadaptativa.getSelectedRow(), 6)).booleanValue()) {
                        this.JTMotricidadFinoadaptativa.setValueAt(false, this.JTMotricidadFinoadaptativa.getSelectedRow(), 6);
                        break;
                    }
                }
                break;
            case 3:
                System.err.println("se esta mostrando el panel Audicion Lenguaje");
                if (this.JTAudicionLenguaje.getSelectedRow() != -1) {
                    if (this.JTAudicionLenguaje.getSelectedColumn() == 6) {
                        if (((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getSelectedRow(), 5)).booleanValue()) {
                            this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 5);
                        }
                        System.out.println(" Seleciono No cumple");
                        break;
                    } else if (this.JTAudicionLenguaje.getSelectedColumn() == 5 && ((Boolean) this.JTAudicionLenguaje.getValueAt(this.JTAudicionLenguaje.getSelectedRow(), 6)).booleanValue()) {
                        this.JTAudicionLenguaje.setValueAt(false, this.JTAudicionLenguaje.getSelectedRow(), 6);
                        break;
                    }
                }
                break;
            case 4:
                System.err.println("se esta mostrando el panel personal social");
                if (this.JTPersonalSocial.getSelectedRow() != -1) {
                    if (this.JTPersonalSocial.getSelectedColumn() == 6) {
                        if (((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getSelectedRow(), 5)).booleanValue()) {
                            this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 5);
                        }
                        System.out.println(" Seleciono No cumple");
                        break;
                    } else if (this.JTPersonalSocial.getSelectedColumn() == 5 && ((Boolean) this.JTPersonalSocial.getValueAt(this.JTPersonalSocial.getSelectedRow(), 6)).booleanValue()) {
                        this.JTPersonalSocial.setValueAt(false, this.JTPersonalSocial.getSelectedRow(), 6);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private DefaultTableModel crearModelo(final boolean[] canEdita) {
        DefaultTableModel modeloGenerico = new DefaultTableModel(new Object[0], new String[]{"id", "Rango", "N° ", "Pregunta ", "idArea", "Cumple", "No Cumple"}) { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo.9
            Class[] types = {Integer.class, Integer.class, Integer.class, String.class, Integer.class, Boolean.class, Boolean.class};
            boolean[] canEdit;

            {
                this.canEdit = canEdita;
            }

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        return modeloGenerico;
    }

    private void CargarDatos(int area, DefaultTableModel modelo, int evaluacion) {
        System.out.println("evaluacion -> " + evaluacion);
        List<Object[]> listaEscalaAbreviadaDesarollo = this.escalaAbreviadaDesarrolloDAO.listaEscalaAbreviadadeDesarrollo(area, evaluacion);
        for (int x = 0; x < listaEscalaAbreviadaDesarollo.size(); x++) {
            modelo.addRow(this.datos);
            for (int j = 0; j < 4; j++) {
                if (j == 2) {
                    modelo.setValueAt(listaEscalaAbreviadaDesarollo.get(x)[2], x, 4);
                    modelo.setValueAt(Integer.valueOf(x + 1), x, j);
                } else {
                    modelo.setValueAt(listaEscalaAbreviadaDesarollo.get(x)[j], x, j);
                }
            }
            modelo.setValueAt(false, x, 5);
            modelo.setValueAt(false, x, 6);
        }
    }

    public void imprimir() {
        this.metodos.imprimirEscalaAbreviadaDeDesarrollo(this.idAtencion, this.idUsuario);
    }

    public void mGrabar() {
        if (!this.escalaAbreviadaDesarrolloDAO.validarGuardado(Integer.parseInt(this.idAtencion))) {
            if (this.puntoFinalDeAudicionLenguaje > 0 && this.puntoFinalDeMotricidadFinoAdaptativa > 0 && this.puntoFinalDeMotricidadGruesa > 0 && this.puntoFinalDePersonalSocial > 0) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String anio1 = this.JLAnioFechaAtencion.getText();
                    String mes1 = this.JLMesesFechaAtencion.getText();
                    String dia1 = this.JLDiasFechaAtencion.getText();
                    System.out.println("datos--> " + anio1 + mes1 + dia1);
                    String fechaAtencion = anio1 + "-" + mes1 + "-" + dia1;
                    System.out.println("fecha de atencion-----" + fechaAtencion);
                    int edadAnio = Integer.parseInt(this.JLAnioEdad1.getText());
                    System.out.println("año a grabar----- " + edadAnio);
                    int edadMes = Integer.parseInt(this.JLMesesEdad1.getText());
                    System.out.println("mes a grabar----- " + edadMes);
                    int edadDias = Integer.parseInt(this.JLDiasEdad1.getText());
                    System.out.println("dia a grabar----- " + edadDias);
                    String edad = edadDias + "-" + edadMes + "-" + edadAnio;
                    System.out.println("edad cronologica----- " + edad);
                    EADEvaluacionDTO evaluacionDTO = new EADEvaluacionDTO();
                    evaluacionDTO.setIdAtencion(Integer.parseInt(this.idAtencion));
                    evaluacionDTO.setFechaR(fechaAtencion);
                    evaluacionDTO.setIdProfesional(this.idProfesional);
                    evaluacionDTO.setIdEspecialidad(this.idEspecialidad);
                    evaluacionDTO.setIdRangoEdad(this.rango);
                    evaluacionDTO.setIdUsuario(this.idUsuario);
                    evaluacionDTO.setEdadAnio(edadAnio);
                    evaluacionDTO.setEdadMes(edadMes);
                    evaluacionDTO.setEdadDia(edadDias);
                    evaluacionDTO.setEdadCronologica(edad);
                    evaluacionDTO.setEsPrematuro(this.JCEsPrematuro.isSelected());
                    evaluacionDTO.setSemanasDeGestacion(((Integer) this.JSPSemanasDeGestacion.getValue()).intValue());
                    evaluacionDTO.setEstado(true);
                    int idEvaluacion = this.escalaAbreviadaDesarrolloDAO.insertarEvaluacion(evaluacionDTO);
                    InsertarResultado(this.modeloMotricidadGruesa, this.puntoFinalDeMotricidadGruesa, this.puntoDeInicioMotricidadGruesa, this.puntuacionDirectaMotrocidadGruesa, idEvaluacion);
                    InsertarResultado(this.modeloMotricidadFinoadaptativa, this.puntoFinalDeMotricidadFinoAdaptativa, this.puntoDeInicioMotricidadFinoAdaptativa, this.puntuacionDirectaMotrocidadFinoAdaptiva, idEvaluacion);
                    InsertarResultado(this.modeloAudicionLenguaje, this.puntoFinalDeAudicionLenguaje, this.puntoDeInicioAudicionLenguaje, this.puntuacionDirectaAudicionLenguaje, idEvaluacion);
                    InsertarResultado(this.modeloPersonalSocial, this.puntoFinalDePersonalSocial, this.puntoDeInicioPersonalSocial, this.puntuacionDirectaPersonalSocial, idEvaluacion);
                    imprimir();
                    inicializarDatos(this.idAtencion);
                    cargarDatosGuardados(this.idAtencion);
                    return;
                }
                return;
            }
            this.metodos.mostrarMensaje("Se deben diligenciar todas las encuestas");
            return;
        }
        this.metodos.mostrarMensaje("Esta atencion ya cuenta con una escala abreviada de desarrollo diligenciada");
    }

    private void InsertarResultado(DefaultTableModel modeloGenerico, int puntoFin, int puntoInicio, int putuacionDirecta, int idEvaluacion) {
        int contadorAciertos = 0;
        if (puntoInicio == 0) {
            puntoInicio = buscarInicio(modeloGenerico);
        }
        for (int x = puntoInicio; x <= puntoFin; x++) {
            if (((Boolean) modeloGenerico.getValueAt(x, 5)).booleanValue()) {
                contadorAciertos++;
                EADEvaluacionDetalleItemsDTO eADEvaluacionDetalleItemsDTO = new EADEvaluacionDetalleItemsDTO();
                eADEvaluacionDetalleItemsDTO.setIdEvaluacion(idEvaluacion);
                eADEvaluacionDetalleItemsDTO.setIdItem(((Integer) modeloGenerico.getValueAt(x, 0)).intValue());
                eADEvaluacionDetalleItemsDTO.setValor(1);
                eADEvaluacionDetalleItemsDTO.setEstado(true);
                this.escalaAbreviadaDesarrolloDAO.insertarEvaluacionDetallesItems(eADEvaluacionDetalleItemsDTO);
            } else {
                EADEvaluacionDetalleItemsDTO eADEvaluacionDetalleItemsDTO2 = new EADEvaluacionDetalleItemsDTO();
                eADEvaluacionDetalleItemsDTO2.setIdEvaluacion(idEvaluacion);
                eADEvaluacionDetalleItemsDTO2.setIdItem(((Integer) modeloGenerico.getValueAt(x, 0)).intValue());
                eADEvaluacionDetalleItemsDTO2.setValor(0);
                eADEvaluacionDetalleItemsDTO2.setEstado(true);
                this.escalaAbreviadaDesarrolloDAO.insertarEvaluacionDetallesItems(eADEvaluacionDetalleItemsDTO2);
            }
        }
        EADEvaluacionResultadoDTO evaluacionResultadoDTO = new EADEvaluacionResultadoDTO();
        evaluacionResultadoDTO.setIdEvaluacion(idEvaluacion);
        evaluacionResultadoDTO.setIdArea(((Integer) modeloGenerico.getValueAt(0, 4)).intValue());
        evaluacionResultadoDTO.setTotalAcumuladosInicio(puntoInicio);
        evaluacionResultadoDTO.setNumeroDeItemsCorrectos(contadorAciertos);
        evaluacionResultadoDTO.setTotalPuntuacionDirecta(putuacionDirecta);
        evaluacionResultadoDTO.setTotalPutuacionTipica(this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(putuacionDirecta, ((Integer) modeloGenerico.getValueAt(0, 4)).intValue(), this.rango));
        evaluacionResultadoDTO.setIdClasificacionColor(this.escalaAbreviadaDesarrolloDAO.traerColor(evaluacionResultadoDTO.getTotalPutuacionTipica(), evaluacionResultadoDTO.getIdArea(), this.rango));
        this.escalaAbreviadaDesarrolloDAO.insertarEvaluacionResultado(evaluacionResultadoDTO);
    }

    public Date sumarDiasAFecha(Date fecha, int dias) {
        if (dias == 0) {
            return fecha;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(6, dias);
        return calendar.getTime();
    }

    private int buscarInicio(DefaultTableModel modeloGenerico) {
        int fila = 0;
        int x = 0;
        while (true) {
            if (x >= modeloGenerico.getRowCount()) {
                break;
            }
            if (!((Boolean) modeloGenerico.getValueAt(x, 5)).booleanValue()) {
                x++;
            } else {
                fila = x;
                break;
            }
        }
        return fila;
    }

    private int validarValorSegundaPreguntaPorRango(DefaultTableModel modeloGenerico) {
        int contador = 0;
        int respuesta = 0;
        int x = 0;
        while (true) {
            if (x >= modeloGenerico.getRowCount()) {
                break;
            }
            if (Integer.parseInt(modeloGenerico.getValueAt(x, 1).toString()) == this.rango) {
                contador++;
            }
            if (contador != 2) {
                x++;
            } else {
                respuesta = x;
                break;
            }
        }
        return respuesta;
    }

    private String traerEdad(String edad) {
        int dias = Integer.parseInt(edad);
        int mes = dias / 30;
        int anio = mes / 12;
        if (dias > 30) {
            dias -= mes * 30;
        }
        if (mes > 12) {
            mes -= anio * 12;
        }
        return dias + "-" + mes + "-" + anio;
    }

    private void cargarDatosGuardados(String idAtencion) {
        List<Object[]> listaEncabezadoResultado = this.escalaAbreviadaDesarrolloDAO.listaEncabezado(Integer.parseInt(idAtencion));
        System.out.println("id de atencion >>>>> " + idAtencion);
        System.out.println("lista de encabezado -> " + listaEncabezadoResultado);
        if (listaEncabezadoResultado.size() > 0) {
            this.guardado = 1;
            List<Object[]> listaItemResultado = this.escalaAbreviadaDesarrolloDAO.listaItemenes(((Integer) listaEncabezadoResultado.get(0)[0]).intValue());
            List<Object[]> listaResultado = this.escalaAbreviadaDesarrolloDAO.listResuldatdo(((Integer) listaEncabezadoResultado.get(0)[0]).intValue());
            for (int j = 0; j < listaItemResultado.size(); j++) {
                switch (((Integer) listaItemResultado.get(j)[0]).intValue()) {
                    case 1:
                        cargarItemsSelecionado(this.JTMotrocidadGruesa, ((Integer) listaItemResultado.get(j)[2]).intValue(), ((Integer) listaItemResultado.get(j)[3]).intValue());
                        break;
                    case 2:
                        cargarItemsSelecionado(this.JTMotricidadFinoadaptativa, ((Integer) listaItemResultado.get(j)[2]).intValue(), ((Integer) listaItemResultado.get(j)[3]).intValue());
                        break;
                    case 3:
                        cargarItemsSelecionado(this.JTAudicionLenguaje, ((Integer) listaItemResultado.get(j)[2]).intValue(), ((Integer) listaItemResultado.get(j)[3]).intValue());
                        break;
                    case 4:
                        cargarItemsSelecionado(this.JTPersonalSocial, ((Integer) listaItemResultado.get(j)[2]).intValue(), ((Integer) listaItemResultado.get(j)[3]).intValue());
                        break;
                }
            }
            calcularEdad(listaEncabezadoResultado.get(0)[10].toString(), listaEncabezadoResultado.get(0)[2].toString());
            if (listaResultado.size() > 0) {
                this.puntuacionDirectaMotrocidadGruesa = ((Integer) listaResultado.get(0)[5]).intValue();
                this.puntuacionDirectaMotrocidadFinoAdaptiva = ((Integer) listaResultado.get(1)[5]).intValue();
                this.puntuacionDirectaAudicionLenguaje = ((Integer) listaResultado.get(2)[5]).intValue();
                this.puntuacionDirectaPersonalSocial = ((Integer) listaResultado.get(3)[5]).intValue();
                this.puntuacionTipicaYDirecta[0] = this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(this.puntuacionDirectaMotrocidadGruesa, 1, this.rango);
                this.puntuacionTipicaYDirecta[1] = this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(this.puntuacionDirectaMotrocidadFinoAdaptiva, 2, this.rango);
                this.puntuacionTipicaYDirecta[2] = this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(this.puntuacionDirectaAudicionLenguaje, 3, this.rango);
                this.puntuacionTipicaYDirecta[3] = this.escalaAbreviadaDesarrolloDAO.traerPuntuacionTipica(this.puntuacionDirectaPersonalSocial, 4, this.rango);
                this.puntuacionTipicaYDirecta[4] = this.puntuacionDirectaMotrocidadGruesa;
                this.puntuacionTipicaYDirecta[5] = this.puntuacionDirectaMotrocidadFinoAdaptiva;
                this.puntuacionTipicaYDirecta[6] = this.puntuacionDirectaAudicionLenguaje;
                this.puntuacionTipicaYDirecta[7] = this.puntuacionDirectaPersonalSocial;
                this.JLPuntuacionDirectaMotricidadGruesa.setText("Puntuacion Directa: " + this.puntuacionDirectaMotrocidadGruesa);
                this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setText("Puntuacion Directa " + this.puntuacionDirectaMotrocidadFinoAdaptiva);
                this.JLPuntuacionDirectaAudicionLenguaje.setText("Puntuacion Directa " + this.puntuacionDirectaAudicionLenguaje);
                this.JLPuntuacionDirectaPersonalSocial.setText("Puntuacion Directo " + this.puntuacionDirectaPersonalSocial);
                this.puntoFinalDeMotricidadGruesa = buscaPuntoDeFin(this.modeloMotricidadGruesa);
                this.puntoFinalDeMotricidadFinoAdaptativa = buscaPuntoDeFin(this.modeloMotricidadFinoadaptativa);
                this.puntoFinalDeAudicionLenguaje = buscaPuntoDeFin(this.modeloAudicionLenguaje);
                this.puntoFinalDePersonalSocial = buscaPuntoDeFin(this.modeloPersonalSocial);
            }
            String[] fechaAtencion = listaEncabezadoResultado.get(0)[2].toString().split("-");
            System.out.println("la fecha de atencion es --->>>> " + Arrays.toString(fechaAtencion));
            this.JLAnioFechaAtencion.setText(fechaAtencion[0]);
            System.out.println("el año de atencion es ---->>>>" + fechaAtencion[0]);
            this.JLMesesFechaAtencion.setText(fechaAtencion[1]);
            this.JLDiasFechaAtencion.setText(fechaAtencion[2]);
            this.JCEsPrematuro.setEnabled(true);
            this.JBCalcularEdad.setEnabled(false);
            if (((Boolean) listaEncabezadoResultado.get(0)[11]).booleanValue()) {
                this.JPEdadCorregida.setVisible(true);
            } else {
                this.JPEdadCorregida.setVisible(false);
            }
            this.rango = ((Integer) listaEncabezadoResultado.get(0)[5]).intValue();
            puntoDeInicio();
        }
    }

    private void cargarItemsSelecionado(JTable tablaGenerica, int idItem, int valor) {
        for (int x = 0; x < tablaGenerica.getRowCount(); x++) {
            if (((Integer) tablaGenerica.getValueAt(x, 0)).intValue() == idItem) {
                if (valor == 1) {
                    tablaGenerica.setValueAt(true, x, 5);
                } else {
                    tablaGenerica.setValueAt(true, x, 6);
                }
            }
        }
    }

    private void bloquearTablas() {
        this.JTAudicionLenguaje.setColumnSelectionAllowed(false);
        this.JTAudicionLenguaje.setEnabled(false);
    }
}
