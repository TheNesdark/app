package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.EscalaAbreviadadeDesarrolloDAO;
import com.genoma.plus.dao.historia.ValeCondicionesEstructuralesDAO;
import com.genoma.plus.dao.historia.ValePreguntasDAO;
import com.genoma.plus.dao.historia.ValeReportePadresDetalleDAO;
import com.genoma.plus.dao.historia.ValeReportePadresEncabezadoDAO;
import com.genoma.plus.dao.historia.ValeRiesgoGeneralesDAO;
import com.genoma.plus.dao.impl.historia.EscalaAbreviadadeDesarrolloDAOImpl;
import com.genoma.plus.dao.impl.historia.ValeCondicionesEstructuralesDAOImpl;
import com.genoma.plus.dao.impl.historia.ValePreguntasDAOImpl;
import com.genoma.plus.dao.impl.historia.ValeReportePadresDetalleDAOImpl;
import com.genoma.plus.dao.impl.historia.ValeReportePadresEncabezadoDAOImpl;
import com.genoma.plus.dao.impl.historia.ValeRiesgosGeneralesDAOImpl;
import com.genoma.plus.dto.historia.ValeCondicionesEstructuralesDTO;
import com.genoma.plus.dto.historia.ValeReportePadresDetalleDTO;
import com.genoma.plus.dto.historia.ValeReportePadresEncabezadoDTO;
import com.genoma.plus.dto.historia.ValeRiesgoGeneralesDTO;
import java.awt.Color;
import java.awt.Component;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAVale.class */
public class JPAVale extends JPanel {
    private DefaultTableModel modeloRiesgoGenerales;
    private DefaultTableModel modeloCondicionesEstructurales;
    private Object[] datos;
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
    private ValeCondicionesEstructuralesDAO valeCondicionesEstructuralesDAO;
    private ValePreguntasDAO valePreguntasDAO;
    private ValeRiesgoGeneralesDAO valeRiesgoGeneralesDAO;
    private ValeReportePadresDetalleDAO valeReportePadresDetalleDAO;
    private ValeReportePadresEncabezadoDAO valeReportePadresEncabezadoDAO;
    private DefaultTableModel modeloReportePadres;
    private int edadEnDias;
    private int rangoNormal;
    private int rangoVestibular;
    private EscalaAbreviadadeDesarrolloDAO escalaAbreviadaDesarrolloDAO;
    private Integer rangoPaciente;
    private JButton JBCalcularEdad;
    private JCheckBox JCEsPrematuro;
    private JLabel JLAnioEdad1;
    private JLabel JLAnioEdadCorregida;
    private JLabel JLAnioFechaAtencion;
    private JLabel JLAnioFechaNacimiento;
    private JLabel JLBCuestionario;
    private JLabel JLBCuestionario1;
    private JLabel JLBResultado;
    private JLabel JLBResultado2;
    private JLabel JLDiasEdad1;
    private JLabel JLDiasEdadCorregida;
    private JLabel JLDiasFechaAtencion;
    private JLabel JLDiasFechaNacimiento;
    private JLabel JLMesesEdad1;
    private JLabel JLMesesEdadCorrigida;
    private JLabel JLMesesFechaAtencion;
    private JLabel JLMesesFechaNacimiento;
    private JLabel JLPuntajeCompresion;
    private JLabel JLPuntajeExpresion;
    private JLabel JLPuntajeInteracion;
    private JLabel JLPuntajeTotal;
    private JLabel JLPuntajeVestibular;
    private JLabel JLRango;
    private JLabel JLResultado;
    private JPanel JPCalcularRango;
    private JPanel JPCondicionesEstructurales;
    private JPanel JPEdad;
    private JPanel JPEdadCorregida;
    private JPanel JPFechaAtencion;
    private JPanel JPFechaNacimiento;
    private JPanel JPReportePanel;
    private JPanel JPRiesgosGenerales;
    private JScrollPane JSPMotricidadFinoadaptativa;
    private JSpinner JSPSemanasDeGestacion;
    private JTable JTCondicioneEstructurales;
    private JTabbedPane JTPEscalaAbreviadaDeDesarrollo;
    private JTable JTReportesPadres;
    private JTable JTRiesgoGenerales;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private Metodos metodos = new Metodos();
    private SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
    private int guardado = 0;
    private int puntajeCompresion = 0;
    private int puntajeInteracion = 0;
    private int puntajeExpresion = 0;
    private int puntajeVestibular = 0;
    private int puntajeTotal = 0;
    private int idEncabezado = 0;

    public JPAVale(String fechaDeNacimiento, String idAtencion, String idEspecialidad, long idUsuario, long idProfesional) {
        initComponents();
        springStart();
        this.idAtencion = idAtencion;
        this.idEspecialidad = idEspecialidad;
        this.idUsuario = idUsuario;
        this.fechaDeNacimiento = fechaDeNacimiento;
        System.out.println("fecha de nacimiento " + fechaDeNacimiento);
        this.idProfesional = idProfesional;
        inicializarDatos();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.valePreguntasDAO = (ValePreguntasDAOImpl) classPathXmlApplicationContext.getBean("ValePreguntasDAO");
        this.valeCondicionesEstructuralesDAO = (ValeCondicionesEstructuralesDAOImpl) classPathXmlApplicationContext.getBean("ValeCodicionesEstructuralesDAO");
        this.valeRiesgoGeneralesDAO = (ValeRiesgosGeneralesDAOImpl) classPathXmlApplicationContext.getBean("valeRiesgosGenerales");
        this.valeReportePadresDetalleDAO = (ValeReportePadresDetalleDAOImpl) classPathXmlApplicationContext.getBean("valeReportePadresDetalle");
        this.valeReportePadresEncabezadoDAO = (ValeReportePadresEncabezadoDAOImpl) classPathXmlApplicationContext.getBean("valeReportePadresEncabezado");
        this.escalaAbreviadaDesarrolloDAO = (EscalaAbreviadadeDesarrolloDAOImpl) classPathXmlApplicationContext.getBean("EscalaAbreviadadeDesarrolloDAO");
    }

    /* JADX WARN: Type inference failed for: r3v101, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v130, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v166, types: [java.lang.Object[], java.lang.Object[][]] */
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
        this.jScrollPane1 = new JScrollPane();
        this.JTRiesgoGenerales = new JTable();
        this.jLabel1 = new JLabel();
        this.JLBCuestionario1 = new JLabel();
        this.JLBResultado = new JLabel();
        this.JPCondicionesEstructurales = new JPanel();
        this.JSPMotricidadFinoadaptativa = new JScrollPane();
        this.JTCondicioneEstructurales = new JTable();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.JLBCuestionario = new JLabel();
        this.JLBResultado2 = new JLabel();
        this.JPReportePanel = new JPanel();
        this.jPanel2 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTReportesPadres = new JTable();
        this.jLabel4 = new JLabel();
        this.JLPuntajeCompresion = new JLabel();
        this.JLPuntajeExpresion = new JLabel();
        this.JLPuntajeInteracion = new JLabel();
        this.JLPuntajeVestibular = new JLabel();
        this.JLPuntajeTotal = new JLabel();
        this.JLResultado = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "Cuestionario Vale", 2, 0, new Font("Arial", 1, 12)));
        setName("JPAVale");
        this.JTPEscalaAbreviadaDeDesarrollo.setFont(new Font("Arial", 1, 12));
        this.JTPEscalaAbreviadaDeDesarrollo.setName("Motricidad Gruesa");
        this.JTPEscalaAbreviadaDeDesarrollo.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPAVale.1
            public void stateChanged(ChangeEvent evt) {
                JPAVale.this.JTPEscalaAbreviadaDeDesarrolloStateChanged(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCEsPrematuro.setFont(new Font("Arial", 1, 12));
        this.JCEsPrematuro.setForeground(Color.blue);
        this.JCEsPrematuro.setText("Es prematuro");
        this.JCEsPrematuro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAVale.2
            public void actionPerformed(ActionEvent evt) {
                JPAVale.this.JCEsPrematuroActionPerformed(evt);
            }
        });
        this.JSPSemanasDeGestacion.setFont(new Font("Arial", 1, 12));
        this.JSPSemanasDeGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° semanas de Gestacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPSemanasDeGestacion.setEnabled(false);
        this.JBCalcularEdad.setFont(new Font("Arial", 1, 12));
        this.JBCalcularEdad.setForeground(Color.blue);
        this.JBCalcularEdad.setText("Calcular Edad");
        this.JBCalcularEdad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAVale.3
            public void actionPerformed(ActionEvent evt) {
                JPAVale.this.JBCalcularEdadActionPerformed(evt);
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
        this.JPEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Corregida", 2, 0, new Font("Arial", 1, 12), Color.blue));
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
        JPCalcularRangoLayout.setVerticalGroup(JPCalcularRangoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCalcularRangoLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 173, 32767)));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Calculo De Edad", this.JPCalcularRango);
        this.JPRiesgosGenerales.setFont(new Font("Arial", 1, 12));
        this.JPRiesgosGenerales.setName("");
        this.JTRiesgoGenerales.setFont(new Font("Arial", 1, 12));
        this.JTRiesgoGenerales.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTRiesgoGenerales.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAVale.4
            public void mouseClicked(MouseEvent evt) {
                JPAVale.this.JTRiesgoGeneralesMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTRiesgoGenerales);
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Respuesta");
        this.jLabel1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.JLBCuestionario1.setFont(new Font("Arial", 1, 14));
        this.JLBCuestionario1.setText("ESTADO DE CUESTIONARIO:");
        GroupLayout JPRiesgosGeneralesLayout = new GroupLayout(this.JPRiesgosGenerales);
        this.JPRiesgosGenerales.setLayout(JPRiesgosGeneralesLayout);
        JPRiesgosGeneralesLayout.setHorizontalGroup(JPRiesgosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 696, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPRiesgosGeneralesLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel1, -2, 235, -2)).addGroup(JPRiesgosGeneralesLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JLBCuestionario1, -2, 194, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBResultado, -2, 202, -2).addContainerGap(-1, 32767)));
        JPRiesgosGeneralesLayout.setVerticalGroup(JPRiesgosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPRiesgosGeneralesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 515, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPRiesgosGeneralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBResultado, -1, -1, 32767).addComponent(this.JLBCuestionario1, -2, 41, -2)).addContainerGap()));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Riesgos Generales", this.JPRiesgosGenerales);
        this.JPCondicionesEstructurales.setFont(new Font("Arial", 1, 12));
        this.JSPMotricidadFinoadaptativa.setName("Motricidad FinoAdatativa");
        this.JTCondicioneEstructurales.setFont(new Font("Arial", 1, 12));
        this.JTCondicioneEstructurales.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTCondicioneEstructurales.setSelectionBackground(Color.white);
        this.JTCondicioneEstructurales.setSelectionForeground(Color.red);
        this.JTCondicioneEstructurales.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAVale.5
            public void mouseClicked(MouseEvent evt) {
                JPAVale.this.JTCondicioneEstructuralesMouseClicked(evt);
            }
        });
        this.JSPMotricidadFinoadaptativa.setViewportView(this.JTCondicioneEstructurales);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("Integridad");
        this.jLabel2.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("Presente");
        this.jLabel3.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        this.JLBCuestionario.setFont(new Font("Arial", 1, 14));
        this.JLBCuestionario.setText("ESTADO DE CUESTIONARIO:");
        GroupLayout JPCondicionesEstructuralesLayout = new GroupLayout(this.JPCondicionesEstructurales);
        this.JPCondicionesEstructurales.setLayout(JPCondicionesEstructuralesLayout);
        JPCondicionesEstructuralesLayout.setHorizontalGroup(JPCondicionesEstructuralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMotricidadFinoadaptativa, -1, 696, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPCondicionesEstructuralesLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jLabel3, -2, 140, -2).addGap(104, 104, 104).addComponent(this.jLabel2, -2, 150, -2).addGap(49, 49, 49)).addGroup(JPCondicionesEstructuralesLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JLBCuestionario, -2, 195, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBResultado2, -2, 151, -2).addContainerGap(-1, 32767)));
        JPCondicionesEstructuralesLayout.setVerticalGroup(JPCondicionesEstructuralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCondicionesEstructuralesLayout.createSequentialGroup().addContainerGap().addGroup(JPCondicionesEstructuralesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabel3)).addGap(10, 10, 10).addComponent(this.JSPMotricidadFinoadaptativa, -2, 513, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPCondicionesEstructuralesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBResultado2, -1, -1, 32767).addComponent(this.JLBCuestionario, -1, 38, 32767)).addContainerGap()));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Condiciones Estructurales", this.JPCondicionesEstructurales);
        this.JTReportesPadres.setFont(new Font("Arial", 1, 12));
        this.JTReportesPadres.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTReportesPadres.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAVale.6
            public void mouseClicked(MouseEvent evt) {
                JPAVale.this.JTReportesPadresMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTReportesPadres);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 684, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 514, 32767)));
        this.JLPuntajeCompresion.setFont(new Font("Arial", 1, 12));
        this.JLPuntajeCompresion.setText("Puntaje Compresion: 0");
        this.JLPuntajeExpresion.setFont(new Font("Arial", 1, 12));
        this.JLPuntajeExpresion.setText("Puntaje Expresion: 0");
        this.JLPuntajeInteracion.setFont(new Font("Arial", 1, 12));
        this.JLPuntajeInteracion.setText("Puntaje Interacion: 0");
        this.JLPuntajeVestibular.setFont(new Font("Arial", 1, 12));
        this.JLPuntajeVestibular.setText("Puntaje Vestibular: 0");
        this.JLPuntajeTotal.setFont(new Font("Arial", 1, 12));
        this.JLPuntajeTotal.setText("Puntaje Total: 0");
        this.JLResultado.setFont(new Font("Arial", 1, 12));
        this.JLResultado.setText("Resultado :");
        GroupLayout JPReportePanelLayout = new GroupLayout(this.JPReportePanel);
        this.JPReportePanel.setLayout(JPReportePanelLayout);
        JPReportePanelLayout.setHorizontalGroup(JPReportePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(JPReportePanelLayout.createSequentialGroup().addContainerGap().addGroup(JPReportePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPReportePanelLayout.createSequentialGroup().addComponent(this.JLPuntajeCompresion).addGroup(JPReportePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPReportePanelLayout.createSequentialGroup().addGap(24, 24, 24).addGroup(JPReportePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPReportePanelLayout.createSequentialGroup().addComponent(this.jLabel4, -2, 99, -2).addGap(0, 431, 32767)).addGroup(JPReportePanelLayout.createSequentialGroup().addGap(136, 136, 136).addComponent(this.JLPuntajeTotal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 306, 32767)))).addGroup(JPReportePanelLayout.createSequentialGroup().addGap(88, 88, 88).addComponent(this.JLPuntajeExpresion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLPuntajeInteracion, -2, 183, -2)))).addGroup(JPReportePanelLayout.createSequentialGroup().addComponent(this.JLPuntajeVestibular, -2, 170, -2).addGap(0, 0, 32767)).addComponent(this.JLResultado, -1, -1, 32767)).addContainerGap()));
        JPReportePanelLayout.setVerticalGroup(JPReportePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPReportePanelLayout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addGroup(JPReportePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLPuntajeCompresion).addComponent(this.JLPuntajeExpresion).addComponent(this.JLPuntajeInteracion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPReportePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLPuntajeVestibular).addComponent(this.JLPuntajeTotal)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLResultado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel4).addContainerGap(-1, 32767)));
        this.JTPEscalaAbreviadaDeDesarrollo.addTab("Items de Valoracion", this.JPReportePanel);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPEscalaAbreviadaDeDesarrollo));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPEscalaAbreviadaDeDesarrollo, -2, 635, -2).addContainerGap()));
        getAccessibleContext().setAccessibleName("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEscalaAbreviadaDeDesarrolloStateChanged(ChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTCondicioneEstructuralesMouseClicked(MouseEvent evt) {
        if (this.JTCondicioneEstructurales.getSelectedRow() != -1) {
            if (this.JTCondicioneEstructurales.getSelectedColumn() == 4) {
                if (((Boolean) this.modeloCondicionesEstructurales.getValueAt(this.JTCondicioneEstructurales.getSelectedRow(), 4)).booleanValue()) {
                    this.JTCondicioneEstructurales.setValueAt(true, this.JTCondicioneEstructurales.getSelectedRow(), 4);
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                } else {
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 4);
                    this.JTCondicioneEstructurales.setValueAt(true, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                }
            }
            if (this.JTCondicioneEstructurales.getSelectedColumn() == 5) {
                if (((Boolean) this.modeloCondicionesEstructurales.getValueAt(this.JTCondicioneEstructurales.getSelectedRow(), 5)).booleanValue()) {
                    this.JTCondicioneEstructurales.setValueAt(true, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 4);
                } else {
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 5);
                    this.JTCondicioneEstructurales.setValueAt(true, this.JTCondicioneEstructurales.getSelectedRow(), 4);
                }
            }
            if (this.JTCondicioneEstructurales.getSelectedColumn() == 6) {
                if (((Boolean) this.modeloCondicionesEstructurales.getValueAt(this.JTCondicioneEstructurales.getSelectedRow(), 6)).booleanValue()) {
                    this.JTCondicioneEstructurales.setValueAt(true, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 7);
                } else {
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                    this.JTCondicioneEstructurales.setValueAt(true, this.JTCondicioneEstructurales.getSelectedRow(), 7);
                }
            }
            if (this.JTCondicioneEstructurales.getSelectedColumn() == 7) {
                if (((Boolean) this.modeloCondicionesEstructurales.getValueAt(this.JTCondicioneEstructurales.getSelectedRow(), 7)).booleanValue()) {
                    this.JTCondicioneEstructurales.setValueAt(true, this.JTCondicioneEstructurales.getSelectedRow(), 7);
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                } else {
                    this.JTCondicioneEstructurales.setValueAt(false, this.JTCondicioneEstructurales.getSelectedRow(), 7);
                    this.JTCondicioneEstructurales.setValueAt(true, this.JTCondicioneEstructurales.getSelectedRow(), 6);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBCalcularEdadActionPerformed(ActionEvent evt) {
        String fechaNacimiento = this.fechaDeNacimiento;
        String fechaAtencion = this.metodos.formatoAMD1.format(this.metodos.getFechaActual());
        System.out.println("fechaaaaaa " + fechaNacimiento);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JTReportesPadresMouseClicked(MouseEvent evt) {
        if (this.JTReportesPadres.getSelectedRow() > -1) {
            if (this.JTReportesPadres.getSelectedColumn() == 8) {
                if (((Boolean) this.modeloReportePadres.getValueAt(this.JTReportesPadres.getSelectedRow(), 8)).booleanValue()) {
                    this.modeloReportePadres.setValueAt(true, this.JTReportesPadres.getSelectedRow(), 8);
                    this.modeloReportePadres.setValueAt(false, this.JTReportesPadres.getSelectedRow(), 9);
                } else {
                    this.modeloReportePadres.setValueAt(false, this.JTReportesPadres.getSelectedRow(), 8);
                    this.modeloReportePadres.setValueAt(true, this.JTReportesPadres.getSelectedRow(), 9);
                }
            }
            if (this.JTReportesPadres.getSelectedColumn() == 9) {
                if (((Boolean) this.modeloReportePadres.getValueAt(this.JTReportesPadres.getSelectedRow(), 9)).booleanValue()) {
                    this.modeloReportePadres.setValueAt(true, this.JTReportesPadres.getSelectedRow(), 9);
                    this.modeloReportePadres.setValueAt(false, this.JTReportesPadres.getSelectedRow(), 8);
                } else {
                    this.modeloReportePadres.setValueAt(false, this.JTReportesPadres.getSelectedRow(), 9);
                    this.modeloReportePadres.setValueAt(true, this.JTReportesPadres.getSelectedRow(), 8);
                }
            }
            CalcularPuntaje();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTRiesgoGeneralesMouseClicked(MouseEvent evt) {
        if (this.JTRiesgoGenerales.getSelectedRow() != -1) {
            if (this.JTRiesgoGenerales.getSelectedColumn() == 6) {
                if (((Boolean) this.modeloRiesgoGenerales.getValueAt(this.JTRiesgoGenerales.getSelectedRow(), 6)).booleanValue()) {
                    this.modeloRiesgoGenerales.setValueAt(true, this.JTRiesgoGenerales.getSelectedRow(), 6);
                    this.modeloRiesgoGenerales.setValueAt(false, this.JTRiesgoGenerales.getSelectedRow(), 7);
                } else {
                    this.modeloRiesgoGenerales.setValueAt(false, this.JTRiesgoGenerales.getSelectedRow(), 6);
                    this.modeloRiesgoGenerales.setValueAt(true, this.JTRiesgoGenerales.getSelectedRow(), 7);
                }
            }
            if (this.JTRiesgoGenerales.getSelectedColumn() == 7) {
                if (((Boolean) this.modeloRiesgoGenerales.getValueAt(this.JTRiesgoGenerales.getSelectedRow(), 7)).booleanValue()) {
                    this.modeloRiesgoGenerales.setValueAt(false, this.JTRiesgoGenerales.getSelectedRow(), 6);
                    this.modeloRiesgoGenerales.setValueAt(true, this.JTRiesgoGenerales.getSelectedRow(), 7);
                } else {
                    this.modeloRiesgoGenerales.setValueAt(true, this.JTRiesgoGenerales.getSelectedRow(), 6);
                    this.modeloRiesgoGenerales.setValueAt(false, this.JTRiesgoGenerales.getSelectedRow(), 7);
                }
            }
        }
    }

    private void calcularEdad(String edad, String fechaAtencion) {
        int semanas = ((Integer) this.JSPSemanasDeGestacion.getValue()).intValue();
        System.out.println("Fecha Nacimiento " + this.fechaDeNacimiento);
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
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-DD");
            Date fechaNacimientoDate = null;
            try {
                fechaNacimientoDate = formato.parse(this.fechaDeNacimiento);
            } catch (Exception e) {
                System.out.println("error al parsear");
            }
            this.fechaCorregida = formato.format(sumarDiasAFecha(fechaNacimientoDate, diferenciaEnDias));
            System.out.println("fecha corregida" + this.fechaCorregida);
            String edad2 = this.valePreguntasDAO.edad(this.fechaCorregida, fechaAtencion);
            System.out.println("edad a" + edad2);
            anio = Integer.parseInt(edad2) / 365;
            mes = ((Integer.parseInt(edad2) / 365) * 12) - (anio * 12);
            dias = Integer.parseInt(edad2) - ((mes * 30) + (anio * 365));
            System.out.println("dia " + dias + " mes " + mes + " año" + anio);
            this.JLAnioEdadCorregida.setText("" + anio);
            this.JLMesesEdadCorrigida.setText("" + mes);
            this.JLDiasEdadCorregida.setText("" + dias);
        }
        this.edadEnDias = (anio * 360) + (mes * 30) + dias;
        List<Object[]> rangosPorEdad = this.valeRiesgoGeneralesDAO.obtenerRango(Integer.valueOf(this.edadEnDias));
        if (rangosPorEdad.size() > 0) {
            this.rangoPaciente = (Integer) rangosPorEdad.get(0)[0];
            this.JLRango.setText("" + this.rangoPaciente);
        }
    }

    private void inicializarDatos() {
        String[] fechaNacimeintoVector = this.fechaDeNacimiento.split("-");
        this.JLAnioFechaNacimiento.setText(fechaNacimeintoVector[0]);
        this.JLMesesFechaNacimiento.setText(fechaNacimeintoVector[1]);
        this.JLDiasFechaNacimiento.setText(fechaNacimeintoVector[2]);
        this.fechaAtencion = this.metodos.formatoAMD1.format(this.metodos.getFechaActual());
        String[] fechaA = this.fechaAtencion.split("-");
        this.JLAnioFechaAtencion.setText(fechaA[0]);
        this.JLMesesFechaAtencion.setText(fechaA[1]);
        this.JLDiasFechaAtencion.setText(fechaA[2]);
        String fechaNacimiento = this.fechaDeNacimiento;
        String fechaAtencion = this.metodos.formatoAMD1.format(this.metodos.getFechaActual());
        this.edad = this.valePreguntasDAO.edad(fechaNacimiento, fechaAtencion);
        String edadf = traerEdad(this.edad);
        this.edad = edadf;
        System.out.println("la fecha de nacimiento actual" + this.fechaDeNacimiento);
        calcularEdad(edadf, fechaAtencion);
        this.JPEdadCorregida.setVisible(false);
        cargaRiesgosGenerales();
        cargarCondicionesEstructurales();
        cargarRangos();
        cargarReportePadres();
        cargarReportePadresEncabezado();
        CalcularPuntaje();
    }

    private void cargarCondicionesEstructurales() {
        List<Object[]> listaCodicionesE;
        crearmodeloCodicionesEstructurales();
        List<Object[]> VerificarExistencia = this.valeCondicionesEstructuralesDAO.listaValeCondicionesEstructurales(Integer.parseInt(this.idAtencion));
        if (VerificarExistencia.size() > 0) {
            listaCodicionesE = VerificarExistencia;
            this.JLBResultado2.setText("GRABADO");
            this.JLBResultado2.setForeground(Color.red);
            this.JLBResultado2.setFont(new Font("Arial", 1, 14));
        } else {
            listaCodicionesE = this.valeCondicionesEstructuralesDAO.listaValeCondicionesEstructurales(0);
        }
        for (int j = 0; j < listaCodicionesE.size(); j++) {
            this.modeloCondicionesEstructurales.addRow(this.datos);
            this.modeloCondicionesEstructurales.setValueAt(listaCodicionesE.get(j)[0], j, 0);
            this.modeloCondicionesEstructurales.setValueAt(listaCodicionesE.get(j)[1], j, 1);
            this.modeloCondicionesEstructurales.setValueAt(listaCodicionesE.get(j)[2], j, 2);
            this.modeloCondicionesEstructurales.setValueAt(listaCodicionesE.get(j)[3], j, 3);
            if (((Boolean) listaCodicionesE.get(j)[4]).booleanValue()) {
                this.modeloCondicionesEstructurales.setValueAt(true, j, 4);
                this.modeloCondicionesEstructurales.setValueAt(false, j, 5);
            } else {
                this.modeloCondicionesEstructurales.setValueAt(true, j, 5);
                this.modeloCondicionesEstructurales.setValueAt(false, j, 4);
            }
            if (((Boolean) listaCodicionesE.get(j)[5]).booleanValue()) {
                this.modeloCondicionesEstructurales.setValueAt(true, j, 6);
                this.modeloCondicionesEstructurales.setValueAt(false, j, 7);
            } else {
                this.modeloCondicionesEstructurales.setValueAt(false, j, 6);
                this.modeloCondicionesEstructurales.setValueAt(true, j, 7);
            }
        }
    }

    private void cargaRiesgosGenerales() {
        List<Object[]> listaRiesgoGenerales;
        crearModeloRiesgoGenerales();
        this.metodos.mEstablecerTextEditor(this.JTRiesgoGenerales, 3);
        if (this.valeRiesgoGeneralesDAO.verificarExistencia(this.idAtencion) > 0) {
            listaRiesgoGenerales = this.valeRiesgoGeneralesDAO.listariesgoGenerales(Integer.parseInt(this.idAtencion));
            this.JLBResultado.setText("GRABADO");
            this.JLBResultado.setForeground(Color.red);
            this.JLBResultado.setFont(new Font("Arial", 1, 14));
        } else {
            listaRiesgoGenerales = this.valeRiesgoGeneralesDAO.listariesgoGenerales(0);
        }
        for (int x = 0; x < listaRiesgoGenerales.size(); x++) {
            this.modeloRiesgoGenerales.addRow(this.datos);
            this.modeloRiesgoGenerales.setValueAt(listaRiesgoGenerales.get(x)[0], x, 0);
            this.modeloRiesgoGenerales.setValueAt(listaRiesgoGenerales.get(x)[1], x, 1);
            this.modeloRiesgoGenerales.setValueAt(listaRiesgoGenerales.get(x)[2], x, 2);
            this.modeloRiesgoGenerales.setValueAt(listaRiesgoGenerales.get(x)[3], x, 3);
            this.modeloRiesgoGenerales.setValueAt(listaRiesgoGenerales.get(x)[4], x, 4);
            this.modeloRiesgoGenerales.setValueAt(listaRiesgoGenerales.get(x)[5], x, 5);
            if (((Boolean) listaRiesgoGenerales.get(x)[6]).booleanValue()) {
                this.modeloRiesgoGenerales.setValueAt(true, x, 6);
                this.modeloRiesgoGenerales.setValueAt(false, x, 7);
            } else {
                this.modeloRiesgoGenerales.setValueAt(true, x, 7);
                this.modeloRiesgoGenerales.setValueAt(false, x, 6);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloRiesgoGenerales() {
        this.modeloRiesgoGenerales = new DefaultTableModel(new Object[0], new String[]{"id", "idPregunta", "Rango", "Pregunta ", "idAtencion", "Observacion", "Si", "No"}) { // from class: com.genoma.plus.controller.historia.JPAVale.7
            Class[] types = {Integer.class, Integer.class, String.class, String.class, Integer.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTRiesgoGenerales.setModel(this.modeloRiesgoGenerales);
        this.JTRiesgoGenerales.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTRiesgoGenerales.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTRiesgoGenerales.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTRiesgoGenerales.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTRiesgoGenerales.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTRiesgoGenerales.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    public void crearmodeloCodicionesEstructurales() {
        this.modeloCondicionesEstructurales = new DefaultTableModel(new Object[0], new String[]{"id", "idAtencion", "idEstructura", "Condiciones Estructurales", "Si ", "No", "Si", "No"}) { // from class: com.genoma.plus.controller.historia.JPAVale.8
            Class[] types = {Integer.class, Integer.class, Integer.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, true, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTCondicioneEstructurales.setModel(this.modeloCondicionesEstructurales);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(3).setPreferredWidth(500);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(6).setPreferredWidth(50);
        this.JTCondicioneEstructurales.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    public void imprimir() {
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.JTPEscalaAbreviadaDeDesarrollo.getComponentAt(1).isVisible()) {
                grabarRiesgoGenerales(this.modeloRiesgoGenerales);
                JOptionPane.showMessageDialog((Component) null, "Guardado con éxito");
            } else if (this.JTPEscalaAbreviadaDeDesarrollo.getComponentAt(2).isVisible()) {
                grabarCodicionesEstructurales(this.modeloCondicionesEstructurales);
                JOptionPane.showMessageDialog((Component) null, "Guardado con éxito");
            } else if (this.JTPEscalaAbreviadaDeDesarrollo.getComponentAt(3).isVisible()) {
                grabarReportepadres(this.modeloReportePadres);
                JOptionPane.showMessageDialog((Component) null, "Guardado con éxito");
            }
        }
    }

    public Date sumarDiasAFecha(Date fecha, int dias) {
        if (dias == 0) {
            return fecha;
        }
        System.out.println("fecha que llega " + fecha);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(6, dias);
        return calendar.getTime();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloReportePadres() {
        this.modeloReportePadres = new DefaultTableModel(new Object[0], new String[]{"Rango de Edad", "idEncabezado", "idDetale", "idItem", "Reporte Padres", "Observacion Directa", "clasificacion", "Orden", "Si", "No"}) { // from class: com.genoma.plus.controller.historia.JPAVale.9
            Class[] types = {String.class, Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, Integer.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        };
        JTable jTable = this.JTReportesPadres;
        JTable jTable2 = this.JTReportesPadres;
        jTable.setAutoResizeMode(0);
        this.JTReportesPadres.setModel(this.modeloReportePadres);
        this.JTReportesPadres.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.JTReportesPadres.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(4).setPreferredWidth(350);
        this.JTReportesPadres.getColumnModel().getColumn(5).setPreferredWidth(350);
        this.JTReportesPadres.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTReportesPadres.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTReportesPadres.getColumnModel().getColumn(9).setPreferredWidth(50);
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

    private void bloquearTablas() {
    }

    private void grabarRiesgoGenerales(DefaultTableModel modelo) {
        if (this.JTRiesgoGenerales.isEditing()) {
            this.JTRiesgoGenerales.getCellEditor().stopCellEditing();
        }
        for (int x = 0; x < modelo.getRowCount(); x++) {
            ValeRiesgoGeneralesDTO riesgo = ValeRiesgoGeneralesDTO.builder().idPregunta(((Integer) modelo.getValueAt(x, 1)).intValue()).idAtencion(Integer.parseInt(this.idAtencion)).respuesta(((Boolean) modelo.getValueAt(x, 6)).booleanValue()).observacion(modelo.getValueAt(x, 5).toString()).idUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()).build();
            if (((Integer) modelo.getValueAt(x, 0)).intValue() == 0) {
                this.valeRiesgoGeneralesDAO.create(riesgo);
                this.JLBResultado.setText("GRABADO");
                this.JLBResultado.setForeground(Color.red);
                this.JLBResultado.setFont(new Font("Arial", 1, 14));
            } else {
                riesgo.setId(((Integer) modelo.getValueAt(x, 0)).intValue());
                this.valeRiesgoGeneralesDAO.update(riesgo);
            }
        }
    }

    private void grabarCodicionesEstructurales(DefaultTableModel modelo) {
        for (int x = 0; x < modelo.getRowCount(); x++) {
            ValeCondicionesEstructuralesDTO condiciones = ValeCondicionesEstructuralesDTO.builder().idAtencion(Integer.parseInt(this.idAtencion)).idEstructura(((Integer) modelo.getValueAt(x, 2)).intValue()).presencia(((Boolean) modelo.getValueAt(x, 4)).booleanValue()).integridad(((Boolean) modelo.getValueAt(x, 6)).booleanValue()).estado(true).idUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()).build();
            System.out.println("Valor4 " + modelo.getValueAt(x, 4).toString());
            System.out.println("Valor6 " + modelo.getValueAt(x, 6).toString());
            if (((Integer) modelo.getValueAt(x, 0)).intValue() == 0) {
                System.out.println("Grabo");
                this.valeCondicionesEstructuralesDAO.mCreate(condiciones);
                this.JLBResultado2.setText("GRABADO");
                this.JLBResultado2.setForeground(Color.red);
                this.JLBResultado2.setFont(new Font("Arial", 1, 14));
            } else {
                System.out.println("Actualizo" + ((Integer) modelo.getValueAt(x, 0)).intValue());
                condiciones.setId(((Integer) modelo.getValueAt(x, 0)).intValue());
                this.valeCondicionesEstructuralesDAO.mUpdate(condiciones);
            }
        }
    }

    private void cargarReportePadres() {
        List<Object[]> listaReportePadre;
        crearModeloReportePadres();
        this.metodos.mEstablecerTextEditor(this.JTReportesPadres, 4);
        this.metodos.mEstablecerTextEditor(this.JTReportesPadres, 5);
        List<Object[]> lista = this.valeReportePadresEncabezadoDAO.listaReportePadresEncabezado(Integer.parseInt(this.idAtencion));
        if (lista.isEmpty()) {
            listaReportePadre = this.valeReportePadresDetalleDAO.listaReportePadres(0, this.rangoNormal, this.rangoVestibular);
        } else {
            listaReportePadre = this.valeReportePadresDetalleDAO.listaReportePadres(Integer.parseInt(this.idAtencion), this.rangoNormal, this.rangoVestibular);
        }
        for (int x = 0; x < listaReportePadre.size(); x++) {
            this.modeloReportePadres.addRow(this.datos);
            this.modeloReportePadres.setValueAt(listaReportePadre.get(x)[0], x, 0);
            this.modeloReportePadres.setValueAt(listaReportePadre.get(x)[1], x, 1);
            this.modeloReportePadres.setValueAt(listaReportePadre.get(x)[2], x, 2);
            this.modeloReportePadres.setValueAt(listaReportePadre.get(x)[3], x, 3);
            this.modeloReportePadres.setValueAt(listaReportePadre.get(x)[6], x, 6);
            this.modeloReportePadres.setValueAt(listaReportePadre.get(x)[6].toString() + ": " + listaReportePadre.get(x)[4].toString(), x, 4);
            this.modeloReportePadres.setValueAt(listaReportePadre.get(x)[6].toString() + ": " + listaReportePadre.get(x)[5].toString(), x, 5);
            this.modeloReportePadres.setValueAt(listaReportePadre.get(x)[7], x, 7);
            if (((Boolean) listaReportePadre.get(x)[8]).booleanValue()) {
                this.modeloReportePadres.setValueAt(true, x, 8);
                this.modeloReportePadres.setValueAt(false, x, 9);
            } else {
                this.modeloReportePadres.setValueAt(false, x, 8);
                this.modeloReportePadres.setValueAt(true, x, 9);
            }
        }
    }

    private void grabarReportepadres(DefaultTableModel modeloReportePadres) {
        guardarEncabezado();
        for (int x = 0; x < modeloReportePadres.getRowCount(); x++) {
            System.out.println("valor 8: " + modeloReportePadres.getValueAt(x, 8).toString());
            ValeReportePadresDetalleDTO reportePadres = ValeReportePadresDetalleDTO.builder().idItem(((Integer) modeloReportePadres.getValueAt(x, 3)).intValue()).idEncabezado(this.idEncabezado).respuesta(((Boolean) modeloReportePadres.getValueAt(x, 8)).booleanValue()).estado(true).idUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()).build();
            System.err.println("Id modelo reporte padre  " + ((Integer) modeloReportePadres.getValueAt(x, 1)).intValue());
            if (((Integer) modeloReportePadres.getValueAt(x, 1)).intValue() == 0) {
                System.out.println("Guardo");
                this.valeReportePadresDetalleDAO.create(reportePadres);
            } else {
                System.out.println("Actualizo id " + ((Integer) modeloReportePadres.getValueAt(x, 2)).intValue());
                reportePadres.setId(((Integer) modeloReportePadres.getValueAt(x, 2)).intValue());
                this.valeReportePadresDetalleDAO.update(reportePadres);
            }
        }
        cargarReportePadres();
        cargarReportePadresEncabezado();
        CalcularPuntaje();
    }

    private void guardarEncabezado() {
        ValeReportePadresEncabezadoDTO reportePadresEncabezadoDTO = ValeReportePadresEncabezadoDTO.builder().idAtencion(Long.parseLong(this.idAtencion)).idUsuarioAtendido(this.idUsuario).idProfesional(this.idProfesional).idEspecialidad(Integer.parseInt(this.idEspecialidad)).puntajeCompresion(this.puntajeCompresion).fechaRegistro(this.metodos.formatoAMD1.format(this.metodos.getFechaActual())).puntajeExpresion(this.puntajeExpresion).puntajeInteracion(this.puntajeInteracion).puntajeVestibular(this.puntajeVestibular).puntajeTotal(this.puntajeTotal).idUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().longValue()).build();
        if (((Integer) this.modeloReportePadres.getValueAt(0, 1)).intValue() == 0) {
            this.idEncabezado = this.valeReportePadresEncabezadoDAO.create(reportePadresEncabezadoDTO);
        } else {
            reportePadresEncabezadoDTO.setId(((Integer) this.JTReportesPadres.getValueAt(0, 1)).intValue());
            this.valeReportePadresEncabezadoDAO.update(reportePadresEncabezadoDTO);
        }
    }

    private void CalcularPuntaje() {
        this.puntajeCompresion = 0;
        this.puntajeExpresion = 0;
        this.puntajeInteracion = 0;
        this.puntajeVestibular = 0;
        for (int x = 0; x < this.JTReportesPadres.getRowCount(); x++) {
            System.out.println("prueba " + this.modeloReportePadres.getValueAt(x, 6).toString());
            if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
                switch (this.modeloReportePadres.getValueAt(x, 6).toString()) {
                    case "C":
                        if (((Boolean) this.modeloReportePadres.getValueAt(x, 8)).booleanValue()) {
                            this.puntajeCompresion++;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "E":
                        if (((Boolean) this.modeloReportePadres.getValueAt(x, 8)).booleanValue()) {
                            this.puntajeExpresion++;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "I":
                        if (((Boolean) this.modeloReportePadres.getValueAt(x, 8)).booleanValue()) {
                            this.puntajeInteracion++;
                            break;
                        } else {
                            break;
                        }
                        break;
                    case "V":
                        if (((Boolean) this.modeloReportePadres.getValueAt(x, 8)).booleanValue()) {
                            this.puntajeVestibular++;
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            } else {
                switch (this.modeloReportePadres.getValueAt(x, 6).toString()) {
                    case "C":
                        if (((Boolean) this.modeloReportePadres.getValueAt(x, 8)).booleanValue()) {
                            break;
                        } else {
                            this.puntajeCompresion++;
                            break;
                        }
                        break;
                    case "E":
                        if (((Boolean) this.modeloReportePadres.getValueAt(x, 8)).booleanValue()) {
                            break;
                        } else {
                            this.puntajeExpresion++;
                            break;
                        }
                        break;
                    case "I":
                        if (((Boolean) this.modeloReportePadres.getValueAt(x, 8)).booleanValue()) {
                            break;
                        } else {
                            this.puntajeInteracion++;
                            break;
                        }
                        break;
                    case "V":
                        if (((Boolean) this.modeloReportePadres.getValueAt(x, 8)).booleanValue()) {
                            break;
                        } else {
                            this.puntajeVestibular++;
                            break;
                        }
                        break;
                }
            }
        }
        this.puntajeTotal = this.puntajeCompresion + this.puntajeExpresion + this.puntajeInteracion + this.puntajeVestibular;
        this.JLPuntajeCompresion.setText("Puntaje Compresion: " + this.puntajeCompresion);
        this.JLPuntajeExpresion.setText("Puntaje Expresison: " + this.puntajeExpresion);
        this.JLPuntajeInteracion.setText("Puntaje Interacion: " + this.puntajeInteracion);
        this.JLPuntajeVestibular.setText("Puntaje Vestibular: " + this.puntajeVestibular);
        this.JLPuntajeTotal.setText("Puntaje Total: " + this.puntajeTotal);
        if (this.puntajeTotal > 0) {
            this.JLResultado.setText("Resultado: Fallo se recomienda remitir con fonoaudiologia si lo considera necesario");
        } else {
            this.JLResultado.setText("Resultado: Paso sin problemas");
        }
    }

    private void cargarReportePadresEncabezado() {
        List<Object[]> listaReportePadresEncabezado = this.valeReportePadresEncabezadoDAO.listaReportePadresEncabezado(Integer.parseInt(this.idAtencion));
        if (listaReportePadresEncabezado.size() > 0) {
            this.JLPuntajeCompresion.setText("Puntaje Compresion: " + ((Integer) listaReportePadresEncabezado.get(0)[0]).intValue());
            this.JLPuntajeExpresion.setText("Puntaje Expresion: " + ((Integer) listaReportePadresEncabezado.get(0)[1]).intValue());
            this.JLPuntajeInteracion.setText("Puntaje Interacion: " + ((Integer) listaReportePadresEncabezado.get(0)[2]).intValue());
            this.JLPuntajeVestibular.setText("Puntaje Vestibular: " + ((Integer) listaReportePadresEncabezado.get(0)[3]).intValue());
            this.JLPuntajeTotal.setText("Puntaje Total: " + ((Integer) listaReportePadresEncabezado.get(0)[4]).intValue());
        }
    }

    private void cargarRangos() {
        List<Integer> listaGeneral = this.valeReportePadresDetalleDAO.buscarItemsPorRango(this.edadEnDias);
        this.rangoNormal = listaGeneral.get(0).intValue();
        List<Integer> listaVestibular = this.valeReportePadresDetalleDAO.buscarItemsVestibularPorRango(this.edadEnDias);
        this.rangoVestibular = listaVestibular.get(0).intValue();
    }
}
