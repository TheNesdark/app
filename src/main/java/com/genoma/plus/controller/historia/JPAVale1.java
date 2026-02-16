package com.genoma.plus.controller.historia;

import Utilidades.Metodos;
import com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO;
import com.genoma.plus.dao.historia.ValePreguntasDAO;
import com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl;
import com.genoma.plus.dto.historia.EADEvaluacionDetalleItemsDTO;
import com.genoma.plus.dto.historia.EADEvaluacionResultadoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
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
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAVale1.class */
public class JPAVale1 extends JPanel {
    private DefaultTableModel modeloRiesgosGenerales;
    private DefaultTableModel modeloCondicionesEstructurales;
    private Object[] datos;
    private int puntoDeInicioRiesgosGenerales;
    private int puntoDeInicioCondicionesEstructurales;
    private int puntoFinalDeRiesgosGenerales;
    private int puntoFinalDeCondicionesEstructurales;
    private int puntuacionDirectaRiesgosGenerales;
    private int puntuacionDirectaCondicionesEstructurales;
    private int PersonalSocial;
    private int puntoReferenciaRiesgosGenerales;
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
    private ValePreguntasDAO valePreguntasDAO;
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
    private JLabel JLPuntuacionDirectaMotricidadFinoAdaptativa;
    private JLabel JLPuntuacionDirectaMotricidadGruesa;
    private JLabel JLRango;
    private JPanel JPCalcularRango;
    private JPanel JPCondicionesEstructurales;
    private JPanel JPEdad;
    private JPanel JPEdadCorregida;
    private JPanel JPFechaAtencion;
    private JPanel JPFechaNacimiento;
    private JPanel JPRiesgosGenerales;
    private JScrollPane JSPMotricidadFinoadaptativa;
    private JScrollPane JSPMotrocidadGruesa;
    private JSpinner JSPSemanasDeGestacion;
    private JTable JTCondicioneEstructurales;
    private JTabbedPane JTPEscalaAbreviadaDeDesarrollo;
    private JTable JTRiesgosGenerales;
    private JPanel jPanel1;
    private int rango = 5;
    private int cuentaClickTablaRiesgosGenerales = 0;
    private int cuentaClickTablaCondicionesEstructuruales = 0;
    private Metodos metodos = new Metodos();
    private int[] puntuacionTipicaYDirecta = new int[8];
    private SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    private int guardado = 0;

    public JPAVale1(String fechaDeNacimiento, String idAtencion, String idEspecialidad, long idUsuario, long idProfesional) {
        initComponents();
        springStart();
        this.idAtencion = idAtencion;
        this.idEspecialidad = idEspecialidad;
        this.idUsuario = idUsuario;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.idProfesional = idProfesional;
        inicializarDatos();
        cargarDatosGuardados(idAtencion);
    }

    private void springStart() {
        this.escalaAbreviadaDesarrolloDAO = (EscalaAbreviadadeDesarrolloDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("EscalaAbreviadadeDesarrolloDAO");
    }

    /* JADX WARN: Type inference failed for: r3v101, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v116, types: [java.lang.Object[], java.lang.Object[][]] */
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
        this.JPRiesgosGenerales = new JPanel();
        this.JSPMotrocidadGruesa = new JScrollPane();
        this.JTRiesgosGenerales = new JTable();
        this.JLPuntuacionDirectaMotricidadGruesa = new JLabel();
        this.JPCondicionesEstructurales = new JPanel();
        this.JSPMotricidadFinoadaptativa = new JScrollPane();
        this.JTCondicioneEstructurales = new JTable();
        this.JLPuntuacionDirectaMotricidadFinoAdaptativa = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "Escala Abreviada de Desarrollo", 2, 0, new Font("Arial", 1, 12)));
        setName("JPAEscalaAbreviadaDeDesarrollo");
        this.JTPEscalaAbreviadaDeDesarrollo.setFont(new Font("Arial", 1, 12));
        this.JTPEscalaAbreviadaDeDesarrollo.setName("Motricidad Gruesa");
        this.JTPEscalaAbreviadaDeDesarrollo.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPAVale1.1
            public void stateChanged(ChangeEvent evt) {
                JPAVale1.this.JTPEscalaAbreviadaDeDesarrolloStateChanged(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCEsPrematuro.setFont(new Font("Arial", 1, 12));
        this.JCEsPrematuro.setForeground(Color.blue);
        this.JCEsPrematuro.setText("Es prematuro");
        this.JCEsPrematuro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAVale1.2
            public void actionPerformed(ActionEvent evt) {
                JPAVale1.this.JCEsPrematuroActionPerformed(evt);
            }
        });
        this.JSPSemanasDeGestacion.setFont(new Font("Arial", 1, 12));
        this.JSPSemanasDeGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° semanas de Gestacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPSemanasDeGestacion.setEnabled(false);
        this.JBCalcularEdad.setFont(new Font("Arial", 1, 12));
        this.JBCalcularEdad.setForeground(Color.blue);
        this.JBCalcularEdad.setText("Calcular Edad");
        this.JBCalcularEdad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAVale1.3
            public void actionPerformed(ActionEvent evt) {
                JPAVale1.this.JBCalcularEdadActionPerformed(evt);
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
        JPCalcularRangoLayout.setVerticalGroup(JPCalcularRangoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCalcularRangoLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 158, 32767)));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Calculo De Edad", this.JPCalcularRango);
        this.JPRiesgosGenerales.setFont(new Font("Arial", 1, 12));
        this.JPRiesgosGenerales.setName("");
        this.JSPMotrocidadGruesa.setName("Motricidad Gruesa");
        this.JTRiesgosGenerales.setFont(new Font("Arial", 1, 12));
        this.JTRiesgosGenerales.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTRiesgosGenerales.setSelectionBackground(Color.white);
        this.JTRiesgosGenerales.setSelectionForeground(Color.red);
        this.JTRiesgosGenerales.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAVale1.4
            public void mouseReleased(MouseEvent evt) {
                JPAVale1.this.JTRiesgosGeneralesMouseReleased(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                JPAVale1.this.JTRiesgosGeneralesMouseClicked(evt);
            }
        });
        this.JSPMotrocidadGruesa.setViewportView(this.JTRiesgosGenerales);
        this.JLPuntuacionDirectaMotricidadGruesa.setFont(new Font("Arial", 1, 12));
        this.JLPuntuacionDirectaMotricidadGruesa.setText("Puntuacion Directa :");
        GroupLayout JPRiesgosGeneralesLayout = new GroupLayout(this.JPRiesgosGenerales);
        this.JPRiesgosGenerales.setLayout(JPRiesgosGeneralesLayout);
        JPRiesgosGeneralesLayout.setHorizontalGroup(JPRiesgosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMotrocidadGruesa, -1, 690, 32767).addGroup(JPRiesgosGeneralesLayout.createSequentialGroup().addComponent(this.JLPuntuacionDirectaMotricidadGruesa, -2, 167, -2).addGap(0, 0, 32767)));
        JPRiesgosGeneralesLayout.setVerticalGroup(JPRiesgosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPRiesgosGeneralesLayout.createSequentialGroup().addComponent(this.JSPMotrocidadGruesa, -2, 559, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPuntuacionDirectaMotricidadGruesa, -2, 33, -2).addContainerGap()));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Riesgos Generales", this.JPRiesgosGenerales);
        this.JPCondicionesEstructurales.setFont(new Font("Arial", 1, 12));
        this.JSPMotricidadFinoadaptativa.setName("Motricidad FinoAdatativa");
        this.JTCondicioneEstructurales.setFont(new Font("Arial", 1, 12));
        this.JTCondicioneEstructurales.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTCondicioneEstructurales.setSelectionBackground(Color.white);
        this.JTCondicioneEstructurales.setSelectionForeground(Color.red);
        this.JTCondicioneEstructurales.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAVale1.5
            public void mouseClicked(MouseEvent evt) {
                JPAVale1.this.JTCondicioneEstructuralesMouseClicked(evt);
            }
        });
        this.JSPMotricidadFinoadaptativa.setViewportView(this.JTCondicioneEstructurales);
        this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setFont(new Font("Arial", 1, 12));
        this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setText("Puntuacion Directa :");
        GroupLayout JPCondicionesEstructuralesLayout = new GroupLayout(this.JPCondicionesEstructurales);
        this.JPCondicionesEstructurales.setLayout(JPCondicionesEstructuralesLayout);
        JPCondicionesEstructuralesLayout.setHorizontalGroup(JPCondicionesEstructuralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMotricidadFinoadaptativa, -1, 690, 32767).addGroup(JPCondicionesEstructuralesLayout.createSequentialGroup().addComponent(this.JLPuntuacionDirectaMotricidadFinoAdaptativa, -2, 167, -2).addGap(0, 0, 32767)));
        JPCondicionesEstructuralesLayout.setVerticalGroup(JPCondicionesEstructuralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCondicionesEstructuralesLayout.createSequentialGroup().addComponent(this.JSPMotricidadFinoadaptativa, -2, 553, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLPuntuacionDirectaMotricidadFinoAdaptativa, -2, 33, -2).addContainerGap(-1, 32767)));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Condiciones Estructurales", this.JPCondicionesEstructurales);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPEscalaAbreviadaDeDesarrollo));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPEscalaAbreviadaDeDesarrollo, -2, 635, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEscalaAbreviadaDeDesarrolloStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCondicioneEstructuralesMouseClicked(MouseEvent evt) {
        if (this.guardado == 0) {
            if (this.cuentaClickTablaCondicionesEstructuruales == 0) {
                this.cuentaClickTablaCondicionesEstructuruales = validacionInicio(this.JTCondicioneEstructurales, this.rango);
            } else if (this.cuentaClickTablaCondicionesEstructuruales == 1) {
                int auxiliarValidacion2 = validarValorSegundaPreguntaPorRango(this.modeloCondicionesEstructurales);
                if (this.JTCondicioneEstructurales.getSelectedRow() == auxiliarValidacion2 && ((Boolean) this.JTCondicioneEstructurales.getValueAt(auxiliarValidacion2, 6)).booleanValue()) {
                    this.cuentaClickTablaCondicionesEstructuruales = auxiliarValidacion2;
                    this.puntoFinalDeCondicionesEstructurales = buscaPuntoDeFin(this.modeloCondicionesEstructurales);
                } else {
                    ValidarSelecion();
                    puntoDeInicio();
                }
            } else {
                ValidarSelecion();
                if (this.puntoFinalDeCondicionesEstructurales == -1) {
                    ValidarSelecion();
                    if (buscarPuntoDeInicio(this.modeloCondicionesEstructurales) == -1) {
                        if (this.rango != 1 && this.cuentaClickTablaCondicionesEstructuruales < this.JTCondicioneEstructurales.getSelectedRow()) {
                            this.metodos.mostrarMensaje("Debe devolverse al rango anterior hasta hallar un punto de inicio");
                            this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                            this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                        }
                    } else {
                        this.cuentaClickTablaCondicionesEstructuruales = 1;
                    }
                } else {
                    this.metodos.mostrarMensaje("Ya se establecio un punto de fin");
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                }
                puntoDeInicio();
            }
            this.puntoFinalDeCondicionesEstructurales = buscaPuntoDeFin(this.modeloCondicionesEstructurales);
            if (this.puntoFinalDeCondicionesEstructurales != -1) {
                this.puntuacionDirectaCondicionesEstructurales = obtenerPuntuacionDirecta(this.modeloCondicionesEstructurales, this.puntoDeInicioCondicionesEstructurales, this.puntoFinalDeCondicionesEstructurales);
                this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setText("La Puntuacion directa es: " + this.puntuacionDirectaCondicionesEstructurales);
            }
            System.err.println("va a validar punto de inicio");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRiesgosGeneralesMouseClicked(MouseEvent evt) {
        if (this.guardado == 0) {
            if (this.cuentaClickTablaRiesgosGenerales == 0) {
                this.cuentaClickTablaRiesgosGenerales = validacionInicio(this.JTRiesgosGenerales, this.rango);
            } else if (this.cuentaClickTablaRiesgosGenerales == 1) {
                int auxiliarValidacion2 = validarValorSegundaPreguntaPorRango(this.modeloRiesgosGenerales);
                if (this.JTRiesgosGenerales.getSelectedRow() == auxiliarValidacion2 && ((Boolean) this.JTRiesgosGenerales.getValueAt(auxiliarValidacion2, 6)).booleanValue()) {
                    this.cuentaClickTablaRiesgosGenerales = auxiliarValidacion2;
                } else {
                    ValidarSelecion();
                    puntoDeInicio();
                }
            } else if (this.puntoFinalDeRiesgosGenerales == -1) {
                ValidarSelecion();
                if (buscarPuntoDeInicio(this.modeloRiesgosGenerales) == -1) {
                    if (this.rango != 1 && this.cuentaClickTablaRiesgosGenerales < this.JTRiesgosGenerales.getSelectedRow()) {
                        this.metodos.mostrarMensaje("Debe devolverse al rango anterior hasta hallar un punto de inicio");
                        this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 5);
                        this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 6);
                    }
                } else {
                    this.cuentaClickTablaRiesgosGenerales = 1;
                }
            } else {
                this.metodos.mostrarMensaje("Ya se establecio un punto de fin");
                this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 5);
                this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 6);
            }
            this.puntoFinalDeRiesgosGenerales = buscaPuntoDeFin(this.modeloRiesgosGenerales);
            if (this.puntoFinalDeRiesgosGenerales != -1) {
                this.puntuacionDirectaRiesgosGenerales = obtenerPuntuacionDirecta(this.modeloRiesgosGenerales, this.puntoDeInicioRiesgosGenerales, this.puntoFinalDeRiesgosGenerales);
                this.JLPuntuacionDirectaMotricidadGruesa.setText("La Puntuacion directa es: " + this.puntuacionDirectaRiesgosGenerales);
            }
            System.err.println("va a validar punto de inicio");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRiesgosGeneralesMouseReleased(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCalcularEdadActionPerformed(ActionEvent evt) {
        String fechaNacimiento = this.fechaDeNacimiento;
        String fechaAtencion = this.metodos.formatoAMD1.format(this.metodos.getFechaActual());
        this.edad = this.escalaAbreviadaDesarrolloDAO.edad(fechaNacimiento, fechaAtencion);
        String edadf = traerEdad(this.edad);
        this.edad = edadf;
        calcularEdad(edadf, fechaAtencion);
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

    private void calcularEdad(String edad, String fechaAtencion) {
        int semanas = ((Integer) this.JSPSemanasDeGestacion.getValue()).intValue();
        System.out.println("Fecha Nacimiento " + edad);
        System.out.println("edad " + edad);
        String[] fecha = edad.split("-");
        int dias = Integer.parseInt(fecha[0]);
        int mes = Integer.parseInt(fecha[1]);
        int anio = Integer.parseInt(fecha[2]);
        this.JLAnioEdad1.setText("" + anio);
        this.JLMesesEdad1.setText("" + mes);
        this.JLDiasEdad1.setText("" + dias);
        if (!this.JCEsPrematuro.isSelected()) {
            this.JLAnioEdadCorregida.setText("" + anio);
            this.JLMesesEdadCorrigida.setText("" + mes);
            this.JLDiasEdadCorregida.setText("" + dias);
            this.edadAnio = anio;
            this.edadMes = mes;
            this.edadDias = dias;
            this.fechaCorregida = this.fechaDeNacimiento;
            System.out.println("dia " + dias + " mes " + mes + " año" + anio);
        } else {
            int diferenciaEnDias = (40 - semanas) * 7;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/DD");
            Date fechaNacimientoDate = null;
            try {
                fechaNacimientoDate = formato.parse(this.fechaDeNacimiento);
            } catch (Exception e) {
            }
            this.fechaCorregida = sumarDiasAFecha(fechaNacimientoDate, diferenciaEnDias).toString();
            String[] fecha2 = this.escalaAbreviadaDesarrolloDAO.edad(this.metodos.formatoAMD1.format(this.fechaCorregida), fechaAtencion).split("-");
            int dias2 = Integer.parseInt(fecha2[0]);
            int mes2 = Integer.parseInt(fecha2[1]);
            int anio2 = Integer.parseInt(fecha2[2]);
            System.out.println("dia " + dias2 + " mes " + mes2 + " año" + anio2);
            this.JLAnioEdadCorregida.setText("" + anio2);
            this.JLMesesEdadCorrigida.setText("" + mes2);
            this.JLDiasEdadCorregida.setText("" + dias2);
        }
        this.rango = this.escalaAbreviadaDesarrolloDAO.traerRango(fechaAtencion, this.fechaCorregida);
        this.JLRango.setText("El rango del paciente es de: " + this.rango);
    }

    private void inicializarDatos() {
        List<Object[]> listaEncabezadoResultado = this.valePreguntasDAO.listaValePreguntas();
        if (listaEncabezadoResultado.isEmpty()) {
            boolean[] zArr = {false, false, false, false, false, true, true};
        } else {
            boolean[] zArr2 = {false, false, false, false, false, false, false};
        }
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
        switch (this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex()) {
            case 1:
                System.err.println("se esta mostrando el panel MotrocidadGruesa");
                if (this.JTRiesgosGenerales.getSelectedRow() != -1) {
                    this.puntoDeInicioRiesgosGenerales = buscarPuntoDeInicio(this.modeloRiesgosGenerales);
                    if (this.JTRiesgosGenerales.getSelectedColumn() == 5) {
                        this.puntoFinalDeRiesgosGenerales = buscaPuntoDeFin(this.modeloRiesgosGenerales);
                        if (this.puntoFinalDeRiesgosGenerales != -1) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 5);
                            this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 6);
                        }
                    }
                    if (this.JTRiesgosGenerales.getSelectedColumn() == 6) {
                        if (this.puntoFinalDeRiesgosGenerales != -1) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 5);
                            this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 6);
                        } else {
                            this.puntoFinalDeRiesgosGenerales = buscaPuntoDeFin(this.modeloRiesgosGenerales);
                        }
                    }
                    System.out.println("punto de inicio " + this.puntoDeInicioRiesgosGenerales);
                    System.out.println("punto de fin" + this.puntoFinalDeRiesgosGenerales);
                    if (this.puntoFinalDeRiesgosGenerales != -1) {
                        this.puntuacionDirectaRiesgosGenerales = obtenerPuntuacionDirecta(this.modeloRiesgosGenerales, this.puntoDeInicioRiesgosGenerales, this.puntoFinalDeRiesgosGenerales);
                        this.JLPuntuacionDirectaMotricidadGruesa.setText("Puntuacion Directa: " + obtenerPuntuacionDirecta(this.modeloRiesgosGenerales, this.puntoDeInicioRiesgosGenerales, this.puntoFinalDeRiesgosGenerales));
                    }
                }
                break;
            case 2:
                System.err.println("se esta mostrando el panel MotrocidadFinoAdaptativa");
                if (this.JTCondicioneEstructurales.getSelectedRow() != -1) {
                    this.puntoDeInicioCondicionesEstructurales = buscarPuntoDeInicio(this.modeloCondicionesEstructurales);
                    if (this.JTCondicioneEstructurales.getSelectedColumn() == 5) {
                        this.puntoFinalDeCondicionesEstructurales = buscaPuntoDeFin(this.modeloCondicionesEstructurales);
                        if (this.puntoFinalDeCondicionesEstructurales != -1) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                            this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                        }
                    }
                    if (this.JTCondicioneEstructurales.getSelectedColumn() == 6) {
                        if (this.puntoFinalDeCondicionesEstructurales != -1) {
                            this.metodos.mostrarMensaje("El punto de fin ya ha sido establecido");
                            this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                            this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                        } else {
                            this.puntoFinalDeCondicionesEstructurales = buscaPuntoDeFin(this.modeloCondicionesEstructurales);
                        }
                    }
                    this.puntoFinalDeCondicionesEstructurales = buscaPuntoDeFin(this.modeloCondicionesEstructurales);
                    System.out.println("punto de inicio " + this.puntoDeInicioCondicionesEstructurales);
                    System.out.println("punto de fin" + this.puntoFinalDeCondicionesEstructurales);
                    if (this.puntoFinalDeCondicionesEstructurales != -1) {
                        this.puntuacionDirectaCondicionesEstructurales = obtenerPuntuacionDirecta(this.modeloCondicionesEstructurales, this.puntoDeInicioCondicionesEstructurales, this.puntoFinalDeCondicionesEstructurales);
                        this.JLPuntuacionDirectaMotricidadFinoAdaptativa.setText("Puntuacion Directa: " + obtenerPuntuacionDirecta(this.modeloCondicionesEstructurales, this.puntoDeInicioCondicionesEstructurales, this.puntoFinalDeCondicionesEstructurales));
                    }
                }
                break;
        }
    }

    private int buscaPuntoDeFin(DefaultTableModel modeloGenerico) {
        int auxiliar = 0;
        int puntoOrigen = -1;
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

    private int obtenerPuntuacionDirecta(DefaultTableModel modeloGenerico, int puntoInicio, int puntoFin) {
        int contador = 0;
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
            System.out.println("Son iguales  anterior " + tablaGenerica.getValueAt(tablaGenerica.getSelectedRow() - 1, 1).toString());
            if (Integer.parseInt(tablaGenerica.getValueAt(tablaGenerica.getSelectedRow() - 1, 1).toString()) == rango) {
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
                if (this.JTRiesgosGenerales.getSelectedRow() != -1) {
                    if (this.JTRiesgosGenerales.getSelectedColumn() == 6) {
                        if (((Boolean) this.JTRiesgosGenerales.getValueAt(this.JTRiesgosGenerales.getSelectedRow(), 5)).booleanValue()) {
                            this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 5);
                        }
                        System.out.println(" Seleciono No cumple");
                        break;
                    } else if (this.JTRiesgosGenerales.getSelectedColumn() == 5 && ((Boolean) this.JTRiesgosGenerales.getValueAt(this.JTRiesgosGenerales.getSelectedRow(), 6)).booleanValue()) {
                        this.JTRiesgosGenerales.setValueAt(false, this.JTRiesgosGenerales.getSelectedRow(), 6);
                        break;
                    }
                }
                break;
            case 2:
                System.err.println("se esta mostrando el panel MotrocidadFinoAdaptativa");
                if (this.JTCondicioneEstructurales.getSelectedRow() != -1) {
                    if (this.JTCondicioneEstructurales.getSelectedColumn() == 6) {
                        if (((Boolean) this.JTCondicioneEstructurales.getValueAt(this.JTCondicioneEstructurales.getSelectedRow(), 5)).booleanValue()) {
                            this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                        }
                        System.out.println(" Seleciono No cumple");
                        break;
                    } else if (this.JTCondicioneEstructurales.getSelectedColumn() == 5 && ((Boolean) this.JTCondicioneEstructurales.getValueAt(this.JTCondicioneEstructurales.getSelectedRow(), 6)).booleanValue()) {
                        this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private DefaultTableModel crearModelo(final boolean[] canEdita) {
        DefaultTableModel modeloGenerico = new DefaultTableModel(new Object[0], new String[]{"id", "Rango", "N° ", "Pregunta ", "idArea", "Cumple", "No Cumple"}) { // from class: com.genoma.plus.controller.historia.JPAVale1.6
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
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0 && this.escalaAbreviadaDesarrolloDAO.validarGuardado(Integer.parseInt(this.idAtencion))) {
            this.metodos.mostrarMensaje("Esta atencion ya cuenta con una escala abreviada de desarrollo diligenciada");
        }
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
        if (listaEncabezadoResultado.size() > 0) {
            this.guardado = 1;
            List<Object[]> listaItemResultado = this.escalaAbreviadaDesarrolloDAO.listaItemenes(((Integer) listaEncabezadoResultado.get(0)[0]).intValue());
            this.escalaAbreviadaDesarrolloDAO.listResuldatdo(((Integer) listaEncabezadoResultado.get(0)[0]).intValue());
            for (int j = 0; j < listaItemResultado.size(); j++) {
                switch (((Integer) listaItemResultado.get(j)[0]).intValue()) {
                    case 1:
                        cargarItemsSelecionado(this.JTRiesgosGenerales, ((Integer) listaItemResultado.get(j)[2]).intValue(), ((Integer) listaItemResultado.get(j)[3]).intValue());
                        break;
                    case 2:
                        cargarItemsSelecionado(this.JTCondicioneEstructurales, ((Integer) listaItemResultado.get(j)[2]).intValue(), ((Integer) listaItemResultado.get(j)[3]).intValue());
                        break;
                }
            }
            String[] fechaAtencion = listaEncabezadoResultado.get(0)[2].toString().split("-");
            this.JLAnioFechaAtencion.setText(fechaAtencion[0]);
            this.JLMesesFechaAtencion.setText(fechaAtencion[1]);
            this.JLDiasFechaAtencion.setText(fechaAtencion[2]);
            this.JCEsPrematuro.setEnabled(false);
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
    }
}
