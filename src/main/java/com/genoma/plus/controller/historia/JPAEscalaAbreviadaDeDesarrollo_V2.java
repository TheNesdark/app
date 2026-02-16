package com.genoma.plus.controller.historia;

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAEscalaAbreviadaDeDesarrollo_V2.class */
public class JPAEscalaAbreviadaDeDesarrollo_V2 extends JPanel {
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

    public JPAEscalaAbreviadaDeDesarrollo_V2(String fechaDeNacimiento, String idAtencion, String idEspecialidad, long idUsuario, long idProfesional) {
        initComponents();
        springStart();
        this.idAtencion = idAtencion;
        this.idEspecialidad = idEspecialidad;
        this.idUsuario = idUsuario;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.idProfesional = idProfesional;
        inicializarDatos();
    }

    private void springStart() {
        this.escalaAbreviadaDesarrolloDAO = (EscalaAbreviadadeDesarrolloDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("EscalaAbreviadadeDesarrolloDAO");
    }

    /* JADX WARN: Type inference failed for: r3v101, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v116, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v132, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v147, types: [java.lang.Object[], java.lang.Object[][]] */
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
        setName("JPAEscalaAbreviadaDeDesarrollo_V2");
        this.JTPEscalaAbreviadaDeDesarrollo.setFont(new Font("Arial", 1, 12));
        this.JTPEscalaAbreviadaDeDesarrollo.setName("Motricidad Gruesa");
        this.JTPEscalaAbreviadaDeDesarrollo.addChangeListener(new ChangeListener() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo_V2.1
            public void stateChanged(ChangeEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTPEscalaAbreviadaDeDesarrolloStateChanged(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JCEsPrematuro.setFont(new Font("Arial", 1, 12));
        this.JCEsPrematuro.setForeground(Color.blue);
        this.JCEsPrematuro.setText("Es prematuro");
        this.JCEsPrematuro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo_V2.2
            public void actionPerformed(ActionEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JCEsPrematuroActionPerformed(evt);
            }
        });
        this.JSPSemanasDeGestacion.setFont(new Font("Arial", 1, 12));
        this.JSPSemanasDeGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "N° semanas de Gestacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPSemanasDeGestacion.setEnabled(false);
        this.JBCalcularEdad.setFont(new Font("Arial", 1, 12));
        this.JBCalcularEdad.setForeground(Color.blue);
        this.JBCalcularEdad.setText("Calcular Edad");
        this.JBCalcularEdad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo_V2.3
            public void actionPerformed(ActionEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JBCalcularEdadActionPerformed(evt);
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
        this.JTMotrocidadGruesa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo_V2.4
            public void mouseReleased(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTMotrocidadGruesaMouseReleased(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTMotrocidadGruesaMouseClicked(evt);
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
        this.JTMotricidadFinoadaptativa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo_V2.5
            public void mouseReleased(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTMotricidadFinoadaptativaMouseReleased(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTMotricidadFinoadaptativaMouseClicked(evt);
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
        this.JTAudicionLenguaje.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo_V2.6
            public void mouseReleased(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTAudicionLenguajeMouseReleased(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTAudicionLenguajeMouseClicked(evt);
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
        this.JTPersonalSocial.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo_V2.7
            public void mouseReleased(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTPersonalSocialMouseReleased(evt);
            }

            public void mouseClicked(MouseEvent evt) {
                JPAEscalaAbreviadaDeDesarrollo_V2.this.JTPersonalSocialMouseClicked(evt);
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
        ValidarSelecion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTMotricidadFinoadaptativaMouseClicked(MouseEvent evt) {
        ValidarSelecion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAudicionLenguajeMouseClicked(MouseEvent evt) {
        ValidarSelecion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPersonalSocialMouseClicked(MouseEvent evt) {
        ValidarSelecion();
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
        calcularPutuacion(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEscalaAbreviadaDeDesarrolloStateChanged(ChangeEvent evt) {
        if (this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex() == 5) {
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
    public void JTMotricidadFinoadaptativaMouseReleased(MouseEvent evt) {
        calcularPutuacion(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTAudicionLenguajeMouseReleased(MouseEvent evt) {
        calcularPutuacion(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPersonalSocialMouseReleased(MouseEvent evt) {
        calcularPutuacion(4);
    }

    private void inicializarDatos() {
        boolean[] cantidadColumnasEditables;
        System.out.println("idAtencion -> " + this.idAtencion);
        int evaluacion = this.escalaAbreviadaDesarrolloDAO.traerEvaluacion(Integer.parseInt(this.idAtencion));
        List<Object[]> listaEncabezadoResultado = this.escalaAbreviadaDesarrolloDAO.listaEncabezado(Integer.parseInt(this.idAtencion));
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
        this.edad = this.escalaAbreviadaDesarrolloDAO.edad(fechaNacimiento, fechaAtencion);
        String edadf = traerEdad(this.edad);
        this.edad = edadf;
        calcularEdad(edadf, fechaAtencion);
        CargarDatos(1, this.modeloMotricidadGruesa, evaluacion);
        CargarDatos(2, this.modeloMotricidadFinoadaptativa, evaluacion);
        CargarDatos(3, this.modeloAudicionLenguaje, evaluacion);
        CargarDatos(4, this.modeloPersonalSocial, evaluacion);
        calcularPutuacion(1);
        calcularPutuacion(2);
        calcularPutuacion(3);
        calcularPutuacion(4);
        this.JPEdadCorregida.setVisible(false);
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

    private void calcularPuntuacionTest(JTable t, JLabel etiqueda, int hojaSeleccionada) {
        int puntuacion = 0;
        for (int x = 0; x < this.rango * 3; x++) {
            if (Boolean.valueOf(t.getValueAt(x, 5).toString()).booleanValue()) {
                puntuacion++;
            }
        }
        switch (hojaSeleccionada) {
            case 1:
                this.puntuacionDirectaMotrocidadGruesa = puntuacion;
                break;
            case 2:
                this.puntuacionDirectaMotrocidadFinoAdaptiva = puntuacion;
                break;
            case 3:
                this.puntuacionDirectaAudicionLenguaje = puntuacion;
                break;
            case 4:
                this.puntuacionDirectaPersonalSocial = puntuacion;
                break;
        }
        etiqueda.setText("Puntuacion Directa: " + puntuacion);
    }

    public void calcularPutuacion(int hojaSeleccionada) {
        switch (hojaSeleccionada) {
            case 1:
                calcularPuntuacionTest(this.JTMotrocidadGruesa, this.JLPuntuacionDirectaMotricidadGruesa, hojaSeleccionada);
                break;
            case 2:
                calcularPuntuacionTest(this.JTMotricidadFinoadaptativa, this.JLPuntuacionDirectaMotricidadFinoAdaptativa, hojaSeleccionada);
                break;
            case 3:
                calcularPuntuacionTest(this.JTAudicionLenguaje, this.JLPuntuacionDirectaAudicionLenguaje, hojaSeleccionada);
                break;
            case 4:
                calcularPuntuacionTest(this.JTPersonalSocial, this.JLPuntuacionDirectaPersonalSocial, hojaSeleccionada);
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

    private void validarSeleccionTabla(JTable t) {
        if (t.getSelectedRow() != -1) {
            System.out.println("" + Integer.valueOf(t.getValueAt(t.getSelectedRow(), 1).toString()));
            if (this.rango >= Integer.parseInt(t.getValueAt(t.getSelectedRow(), 1).toString())) {
                if (t.getSelectedColumn() == 6) {
                    try {
                        if (t.getValueAt(t.getSelectedRow(), 5) != null) {
                            t.setValueAt(false, t.getSelectedRow(), 5);
                            t.setValueAt(true, t.getSelectedRow(), 6);
                        } else if (((Boolean) t.getValueAt(t.getSelectedRow(), 5)).booleanValue()) {
                            t.setValueAt(false, t.getSelectedRow(), 5);
                        }
                        return;
                    } catch (NullPointerException e) {
                        return;
                    }
                }
                if (t.getSelectedColumn() == 5) {
                    try {
                        if (((Boolean) t.getValueAt(t.getSelectedRow(), 6)).booleanValue()) {
                            t.setValueAt(false, t.getSelectedRow(), 6);
                            t.setValueAt(true, t.getSelectedRow(), 5);
                        }
                        return;
                    } catch (NullPointerException e2) {
                        return;
                    }
                }
                return;
            }
            t.setValueAt(false, t.getSelectedRow(), 5);
            t.setValueAt(false, t.getSelectedRow(), 6);
        }
    }

    private void ValidarSelecion() {
        switch (this.JTPEscalaAbreviadaDeDesarrollo.getSelectedIndex()) {
            case 1:
                validarSeleccionTabla(this.JTMotrocidadGruesa);
                break;
            case 2:
                validarSeleccionTabla(this.JTMotricidadFinoadaptativa);
                break;
            case 3:
                validarSeleccionTabla(this.JTAudicionLenguaje);
                break;
            case 4:
                validarSeleccionTabla(this.JTPersonalSocial);
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private DefaultTableModel crearModelo(final boolean[] canEdita) {
        DefaultTableModel modeloGenerico = new DefaultTableModel(new Object[0], new String[]{"id", "Rango", "N° ", "Pregunta ", "idArea", "Cumple", "No Cumple"}) { // from class: com.genoma.plus.controller.historia.JPAEscalaAbreviadaDeDesarrollo_V2.8
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
                    EADEvaluacionDTO evaluacionDTO = new EADEvaluacionDTO();
                    evaluacionDTO.setIdAtencion(Integer.parseInt(this.idAtencion));
                    evaluacionDTO.setFechaR(this.fechaAtencion);
                    evaluacionDTO.setIdProfesional(this.idProfesional);
                    evaluacionDTO.setIdEspecialidad(this.idEspecialidad);
                    evaluacionDTO.setIdRangoEdad(this.rango);
                    evaluacionDTO.setIdUsuario(this.idUsuario);
                    evaluacionDTO.setEdadAnio(this.edadAnio);
                    evaluacionDTO.setEdadMes(this.edadMes);
                    evaluacionDTO.setEdadDia(this.edadDias);
                    evaluacionDTO.setEdadCronologica(this.edad);
                    evaluacionDTO.setEsPrematuro(this.JCEsPrematuro.isSelected());
                    evaluacionDTO.setSemanasDeGestacion(((Integer) this.JSPSemanasDeGestacion.getValue()).intValue());
                    evaluacionDTO.setEstado(true);
                    int idEvaluacion = this.escalaAbreviadaDesarrolloDAO.insertarEvaluacion(evaluacionDTO);
                    InsertarResultado(this.modeloMotricidadGruesa, this.puntoFinalDeMotricidadGruesa, this.puntoDeInicioMotricidadGruesa, this.puntuacionDirectaMotrocidadGruesa, idEvaluacion);
                    InsertarResultado(this.modeloMotricidadFinoadaptativa, this.puntoFinalDeMotricidadFinoAdaptativa, this.puntoDeInicioMotricidadFinoAdaptativa, this.puntuacionDirectaMotrocidadFinoAdaptiva, idEvaluacion);
                    InsertarResultado(this.modeloAudicionLenguaje, this.puntoFinalDeAudicionLenguaje, this.puntoDeInicioAudicionLenguaje, this.puntuacionDirectaAudicionLenguaje, idEvaluacion);
                    InsertarResultado(this.modeloPersonalSocial, this.puntoFinalDePersonalSocial, this.puntoDeInicioPersonalSocial, this.puntuacionDirectaPersonalSocial, idEvaluacion);
                    imprimir();
                    inicializarDatos();
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
