package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.PAiepiClasificacion;
import com.genoma.plus.jpa.entities.PAiepiEncabezado;
import com.genoma.plus.jpa.entities.PAiepiOncologicoPreguntas;
import com.genoma.plus.jpa.entities.PAiepiOncologicoRespuestas;
import com.genoma.plus.jpa.entities.PAiepiRespuestas;
import com.genoma.plus.jpa.service.IPAiepiClasificacionService;
import com.genoma.plus.jpa.service.IPAiepiEncabezadoService;
import com.genoma.plus.jpa.service.IPAiepiOncologicoPreguntasService;
import com.genoma.plus.jpa.service.IPAiepiOncologicoRespuestasService;
import com.genoma.plus.jpa.service.IPAiepiRespuestasService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPAiepiOncologicoTest.class */
public class JPAiepiOncologicoTest extends JPanel {
    private DefaultTableModel model;
    private DefaultTableModel modelH;
    private Metodos metodos;
    private Object[] data;
    private final PAiepiOncologicoRespuestas aiepiOncologicoRespuestas;
    private final IPAiepiOncologicoRespuestasService aiepiOncologicoRespuestasService;
    private List<PAiepiOncologicoRespuestas> listAiepiOncologicorespuestas;
    private final PAiepiClasificacion aiepiClasificacion;
    private final IPAiepiClasificacionService aiepiClasificacionService;
    private List<PAiepiClasificacion> listAiepiClasificacion;
    private final PAiepiRespuestas aiepiRespuestas;
    private final IPAiepiRespuestasService aiepiRespuestasService;
    private List<PAiepiRespuestas> listAiepiRespuestas;
    private final PAiepiOncologicoPreguntas aiepiOncologicoPreguntas;
    private final IPAiepiOncologicoPreguntasService aiepiOncologicoPreguntasService;
    private List<PAiepiOncologicoPreguntas> listPAiepiOncologicoPreguntas;
    private final PAiepiEncabezado aiepiEncabezado;
    private final IPAiepiEncabezadoService aiepiEncabezadoService;
    private List<PAiepiEncabezado> listPAiepiEncabezado;
    private int idAtencion;
    private int idUsuario;
    private int idEspecialidad;
    private String usuarioS;
    private String pregunta;
    private String respuesta;
    private String clasificacion;
    private EntityManager entityManager;
    private String[] radioButtons = new String[5];
    LocalDate currentDate;
    private String observaciones;
    private JButton JBClasificacion;
    private JButton JBClasificacion1;
    private ButtonGroup JBG1;
    private ButtonGroup JBG2;
    private ButtonGroup JBG3;
    private ButtonGroup JBG4;
    private ButtonGroup JBG5;
    private JButton JBTGrabar;
    private JCheckBox JCBAlteracionVision;
    private JCheckBox JCBAsimetria;
    private JCheckBox JCBCambios;
    private JCheckBox JCBCojea;
    private JCheckBox JCBDebilidad;
    private JCheckBox JCBDificultadHabla;
    private JCheckBox JCBEstrabismo;
    private JCheckBox JCBFaltaIris;
    private JCheckBox JCBIntensa;
    private JCheckBox JCBLeve;
    private JCheckBox JCBOjoBlanco;
    private JCheckBox JCBOjosDiferentes;
    private JCheckBox JCBPerdidaEquilibrio;
    private JCheckBox JCBSalido;
    private JCheckBox JCBSangre;
    private JLabel JL1;
    private JLabel JL2;
    private JLabel JL3;
    private JLabel JL4;
    private JLabel JL5;
    private JLabel JL6;
    private JLabel JL7;
    private JLabel JL8;
    private JPanel JPIDeterminar;
    private JPanel JPIHistorico;
    private JPanel JPIPreguntar;
    private JPanel JPObserve;
    private JRadioButton JRBNo1;
    private JRadioButton JRBNo2;
    private JRadioButton JRBNo3;
    private JRadioButton JRBNo4;
    private JRadioButton JRBNo5;
    private JRadioButton JRBSi1;
    private JRadioButton JRBSi2;
    private JRadioButton JRBSi3;
    private JRadioButton JRBSi4;
    private JRadioButton JRBSi5;
    private JScrollPane JSPPreguntasAiepi;
    private JScrollPane JSPPreguntasAiepi1;
    private JTextArea JTAObservacion;
    private JTable JTBPreguntasAiepi;
    private JTable JTBhistorico;
    private JTextField JTF1;
    private JTextField JTF2;
    private JTabbedPane JTP_Informacion;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JScrollPane jScrollPane1;

    public JPAiepiOncologicoTest(String idAtencion, Long idEspecialidad, Long idUsuario, String usuarioS) {
        initComponents();
        this.currentDate = LocalDate.now();
        this.idAtencion = Integer.parseInt(idAtencion);
        this.idEspecialidad = Integer.parseInt(idEspecialidad.toString());
        this.idUsuario = Integer.parseInt(idUsuario.toString());
        this.usuarioS = usuarioS;
        this.pregunta = "";
        this.model = new DefaultTableModel();
        this.modelH = new DefaultTableModel();
        this.aiepiClasificacion = new PAiepiClasificacion();
        this.aiepiClasificacionService = (IPAiepiClasificacionService) Principal.contexto.getBean(IPAiepiClasificacionService.class);
        this.listAiepiClasificacion = new ArrayList();
        this.aiepiRespuestas = new PAiepiRespuestas();
        this.aiepiRespuestasService = (IPAiepiRespuestasService) Principal.contexto.getBean(IPAiepiRespuestasService.class);
        this.listAiepiRespuestas = new ArrayList();
        this.aiepiOncologicoPreguntas = new PAiepiOncologicoPreguntas();
        this.aiepiOncologicoPreguntasService = (IPAiepiOncologicoPreguntasService) Principal.contexto.getBean(IPAiepiOncologicoPreguntasService.class);
        this.listPAiepiOncologicoPreguntas = new ArrayList();
        this.aiepiOncologicoRespuestas = new PAiepiOncologicoRespuestas();
        this.aiepiOncologicoRespuestasService = (IPAiepiOncologicoRespuestasService) Principal.contexto.getBean(IPAiepiOncologicoRespuestasService.class);
        this.listAiepiOncologicorespuestas = new ArrayList();
        this.aiepiEncabezado = new PAiepiEncabezado();
        this.aiepiEncabezadoService = (IPAiepiEncabezadoService) Principal.contexto.getBean(IPAiepiEncabezadoService.class);
        this.listPAiepiEncabezado = new ArrayList();
        newM();
    }

    /* JADX WARN: Type inference failed for: r3v219, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG1 = new ButtonGroup();
        this.JBG2 = new ButtonGroup();
        this.JBG3 = new ButtonGroup();
        this.JBG4 = new ButtonGroup();
        this.JBG5 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JTP_Informacion = new JTabbedPane();
        this.JPIPreguntar = new JPanel();
        this.JSPPreguntasAiepi = new JScrollPane();
        this.JTBPreguntasAiepi = new JTable();
        this.JTF1 = new JTextField();
        this.JTF2 = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBClasificacion = new JButton();
        this.JPIDeterminar = new JPanel();
        this.JPObserve = new JPanel();
        this.jPanel2 = new JPanel();
        this.JRBNo1 = new JRadioButton();
        this.JL1 = new JLabel();
        this.JRBSi1 = new JRadioButton();
        this.jPanel3 = new JPanel();
        this.JCBFaltaIris = new JCheckBox();
        this.JCBSangre = new JCheckBox();
        this.JL6 = new JLabel();
        this.JCBOjoBlanco = new JCheckBox();
        this.JCBEstrabismo = new JCheckBox();
        this.JCBSalido = new JCheckBox();
        this.JCBOjosDiferentes = new JCheckBox();
        this.jPanel4 = new JPanel();
        this.JCBIntensa = new JCheckBox();
        this.JCBLeve = new JCheckBox();
        this.JL7 = new JLabel();
        this.jPanel5 = new JPanel();
        this.JRBNo2 = new JRadioButton();
        this.JRBSi2 = new JRadioButton();
        this.JL2 = new JLabel();
        this.jPanel6 = new JPanel();
        this.JCBAsimetria = new JCheckBox();
        this.JCBPerdidaEquilibrio = new JCheckBox();
        this.JL8 = new JLabel();
        this.JCBCambios = new JCheckBox();
        this.JCBDificultadHabla = new JCheckBox();
        this.JCBCojea = new JCheckBox();
        this.JCBAlteracionVision = new JCheckBox();
        this.JCBDebilidad = new JCheckBox();
        this.jPanel7 = new JPanel();
        this.JRBNo3 = new JRadioButton();
        this.JL3 = new JLabel();
        this.JRBSi3 = new JRadioButton();
        this.jPanel8 = new JPanel();
        this.JRBNo4 = new JRadioButton();
        this.JL4 = new JLabel();
        this.JRBSi4 = new JRadioButton();
        this.jPanel9 = new JPanel();
        this.JRBNo5 = new JRadioButton();
        this.JL5 = new JLabel();
        this.JRBSi5 = new JRadioButton();
        this.JBTGrabar = new JButton();
        this.JBClasificacion1 = new JButton();
        this.JPIHistorico = new JPanel();
        this.JSPPreguntasAiepi1 = new JScrollPane();
        this.JTBhistorico = new JTable();
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMULARIO DE REGISTRO DE DETECCIÓN DE CÁNCER INFANTIL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTP_Informacion.setBorder(BorderFactory.createTitledBorder((Border) null, "TEST AIEPI ONCOLÓGICO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTP_Informacion.setForeground(new Color(0, 103, 0));
        this.JTP_Informacion.setFont(new Font("Arial", 1, 14));
        this.JSPPreguntasAiepi.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBPreguntasAiepi.setFont(new Font("Arial", 1, 12));
        this.JTBPreguntasAiepi.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBPreguntasAiepi.setRowHeight(30);
        this.JTBPreguntasAiepi.setSelectionMode(0);
        this.JTBPreguntasAiepi.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.1
            public void mouseClicked(MouseEvent evt) {
                JPAiepiOncologicoTest.this.JTBPreguntasAiepiMouseClicked(evt);
            }
        });
        this.JSPPreguntasAiepi.setViewportView(this.JTBPreguntasAiepi);
        this.JTF1.setFont(new Font("Arial", 1, 12));
        this.JTF1.setToolTipText("");
        this.JTF1.setBorder(BorderFactory.createTitledBorder((Border) null, "¿Desde cuándo?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.2
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JTF1ActionPerformed(evt);
            }
        });
        this.JTF1.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.3
            public void keyTyped(KeyEvent evt) {
                JPAiepiOncologicoTest.this.JTF1KeyTyped(evt);
            }
        });
        this.JTF2.setFont(new Font("Arial", 1, 12));
        this.JTF2.setToolTipText("");
        this.JTF2.setBorder(BorderFactory.createTitledBorder((Border) null, "¿Cuáles y desde cuándo?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTF2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.4
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JTF2ActionPerformed(evt);
            }
        });
        this.JTF2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.5
            public void keyTyped(KeyEvent evt) {
                JPAiepiOncologicoTest.this.JTF2KeyTyped(evt);
            }
        });
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación: ", 0, 0, new Font("Arial", 1, 14), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JBClasificacion.setBackground(new Color(59, 62, 65));
        GroupLayout JPIPreguntarLayout = new GroupLayout(this.JPIPreguntar);
        this.JPIPreguntar.setLayout(JPIPreguntarLayout);
        JPIPreguntarLayout.setHorizontalGroup(JPIPreguntarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntarLayout.createSequentialGroup().addContainerGap().addGroup(JPIPreguntarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPPreguntasAiepi, -2, 1005, -2).addGroup(JPIPreguntarLayout.createSequentialGroup().addGroup(JPIPreguntarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIPreguntarLayout.createSequentialGroup().addComponent(this.JTF1, -2, 286, -2).addGap(18, 18, 18).addComponent(this.JTF2, -2, 365, -2)).addComponent(this.jScrollPane1)).addGap(18, 18, 18).addComponent(this.JBClasificacion, -1, -1, 32767))).addContainerGap(17, 32767)));
        JPIPreguntarLayout.setVerticalGroup(JPIPreguntarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPreguntarLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPPreguntasAiepi, -2, 325, -2).addGap(45, 45, 45).addGroup(JPIPreguntarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTF1, -2, -1, -2).addComponent(this.JTF2, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPIPreguntarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBClasificacion, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 141, 32767)).addGap(35, 35, 35)));
        this.JTP_Informacion.addTab("PREGUNTAR", this.JPIPreguntar);
        this.JPObserve.setBorder(BorderFactory.createTitledBorder((Border) null, "SELECCIONE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JBG1.add(this.JRBNo1);
        this.JRBNo1.setSelected(true);
        this.JRBNo1.setText("No");
        this.JRBNo1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.6
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBNo1ActionPerformed(evt);
            }
        });
        this.JL1.setText("Petequias, moretes o sangrado");
        this.JBG1.add(this.JRBSi1);
        this.JRBSi1.setText("Si");
        this.JRBSi1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.7
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBSi1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JL1).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRBSi1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNo1))).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo1).addComponent(this.JRBSi1))).addComponent(this.JL1)).addContainerGap()));
        this.jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JCBFaltaIris.setText("Falta de iris");
        this.JCBSangre.setText("Sangre dentro del ojo");
        this.JL6.setText("Anormalidad en los ojos:");
        this.JCBOjoBlanco.setText("Ojo blanco");
        this.JCBOjoBlanco.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.8
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JCBOjoBlancoActionPerformed(evt);
            }
        });
        this.JCBEstrabismo.setText("Estrabismo adquirido");
        this.JCBSalido.setText("Salido");
        this.JCBOjosDiferentes.setText("Ojos de diferente color");
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBOjoBlanco).addComponent(this.JL6).addComponent(this.JCBEstrabismo).addComponent(this.JCBSangre).addComponent(this.JCBOjosDiferentes).addComponent(this.JCBFaltaIris).addComponent(this.JCBSalido)).addContainerGap(-1, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JL6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBOjoBlanco).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBFaltaIris).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEstrabismo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSangre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBOjosDiferentes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSalido).addContainerGap()));
        this.jPanel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JCBIntensa.setText("Intensa");
        this.JCBLeve.setText("Leve");
        this.JL7.setText("Palidez palmar y/o conjuntival:");
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JL7).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.JCBLeve).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBIntensa))).addContainerGap(-1, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JL7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBLeve).addComponent(this.JCBIntensa)).addContainerGap()));
        this.jPanel5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JBG2.add(this.JRBNo2);
        this.JRBNo2.setSelected(true);
        this.JRBNo2.setText("No");
        this.JRBNo2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.9
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBNo2ActionPerformed(evt);
            }
        });
        this.JBG2.add(this.JRBSi2);
        this.JRBSi2.setText("Si");
        this.JRBSi2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.10
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBSi2ActionPerformed(evt);
            }
        });
        this.JL2.setText("Ganglios: Tamaño > 2,5 cm. Sin dolor ni inflamación. Consistencia dura y firme > 4 semanas de evolución");
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JRBSi2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNo2)).addComponent(this.JL2)).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JL2).addGap(18, 18, 18).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo2).addComponent(this.JRBSi2)).addContainerGap()));
        this.jPanel6.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JCBAsimetria.setText("Asimetría física (facial)");
        this.JCBPerdidaEquilibrio.setText("Pérdida del equilibrio al caminar");
        this.JL8.setText("Signos y síntomas neurológicos focales de aparición aguda o progresiva:");
        this.JCBCambios.setText("Cambios en el estado de conciencia o mental (en el comportamiento, confusión)");
        this.JCBDificultadHabla.setText("Dificultad para hablar");
        this.JCBCojea.setText("Cojea por dolor ");
        this.JCBAlteracionVision.setText("Alteración en la visión: (borrosa, doble, ceguera súbita)");
        this.JCBDebilidad.setText("Debilidad unilateral: debilidad unilateral, una de las extremidades o de un lado del cuerpo");
        this.JCBDebilidad.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.11
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JCBDebilidadActionPerformed(evt);
            }
        });
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JL8).addComponent(this.JCBCambios).addComponent(this.JCBPerdidaEquilibrio).addComponent(this.JCBCojea).addComponent(this.JCBAsimetria).addComponent(this.JCBDificultadHabla).addComponent(this.JCBAlteracionVision).addComponent(this.JCBDebilidad, -2, 539, -2)).addContainerGap(-1, 32767)));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.JL8).addGap(18, 18, 18).addComponent(this.JCBDebilidad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBAsimetria).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCambios).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPerdidaEquilibrio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCojea).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDificultadHabla).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBAlteracionVision).addContainerGap(18, 32767)));
        this.jPanel7.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JBG3.add(this.JRBNo3);
        this.JRBNo3.setSelected(true);
        this.JRBNo3.setText("No");
        this.JRBNo3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.12
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBNo3ActionPerformed(evt);
            }
        });
        this.JL3.setText("Presencia de masa palpable abdominal");
        this.JBG3.add(this.JRBSi3);
        this.JRBSi3.setText("Si");
        this.JRBSi3.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.13
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBSi3ActionPerformed(evt);
            }
        });
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JL3).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.JRBSi3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNo3))).addContainerGap(37, 32767)));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo3).addComponent(this.JRBSi3))).addComponent(this.JL3)).addContainerGap()));
        this.jPanel8.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JBG4.add(this.JRBNo4);
        this.JRBNo4.setSelected(true);
        this.JRBNo4.setText("No");
        this.JRBNo4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.14
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBNo4ActionPerformed(evt);
            }
        });
        this.JL4.setText("Hepatomegalia y/o esplenomegalia");
        this.JBG4.add(this.JRBSi4);
        this.JRBSi4.setText("Si");
        this.JRBSi4.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.15
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBSi4ActionPerformed(evt);
            }
        });
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JL4).addGroup(jPanel8Layout.createSequentialGroup().addComponent(this.JRBSi4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNo4))).addContainerGap(-1, 32767)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo4).addComponent(this.JRBSi4))).addComponent(this.JL4)).addContainerGap()));
        this.jPanel9.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JBG5.add(this.JRBNo5);
        this.JRBNo5.setSelected(true);
        this.JRBNo5.setText("No");
        this.JRBNo5.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.16
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBNo5ActionPerformed(evt);
            }
        });
        this.JL5.setText("Aumento de volumen en alguna región del cuerpo (masa)");
        this.JBG5.add(this.JRBSi5);
        this.JRBSi5.setText("Si");
        this.JRBSi5.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.17
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JRBSi5ActionPerformed(evt);
            }
        });
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JL5).addGroup(jPanel9Layout.createSequentialGroup().addComponent(this.JRBSi5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNo5))).addContainerGap(-1, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo5).addComponent(this.JRBSi5))).addComponent(this.JL5)).addContainerGap()));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("GRABAR");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.18
            public void actionPerformed(ActionEvent evt) {
                JPAiepiOncologicoTest.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBClasificacion1.setBackground(new Color(238, 238, 238));
        this.JBClasificacion1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        GroupLayout JPObserveLayout = new GroupLayout(this.JPObserve);
        this.JPObserve.setLayout(JPObserveLayout);
        JPObserveLayout.setHorizontalGroup(JPObserveLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPObserveLayout.createSequentialGroup().addContainerGap().addGroup(JPObserveLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel8, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addGroup(JPObserveLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPObserveLayout.createSequentialGroup().addGap(80, 80, 80).addGroup(JPObserveLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel5, -1, -1, 32767).addComponent(this.jPanel9, -1, -1, 32767).addComponent(this.jPanel6, -1, -1, 32767))).addGroup(JPObserveLayout.createSequentialGroup().addGap(76, 76, 76).addComponent(this.JBClasificacion1, -1, 313, 32767).addGap(2, 2, 2).addComponent(this.JBTGrabar, -2, 298, -2))).addContainerGap(42, 32767)));
        JPObserveLayout.setVerticalGroup(JPObserveLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPObserveLayout.createSequentialGroup().addGroup(JPObserveLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addComponent(this.jPanel9, -2, -1, -2)).addGap(18, 18, 18).addGroup(JPObserveLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPObserveLayout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel7, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel8, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel4, -2, -1, -2).addGap(0, 0, 32767)).addGroup(JPObserveLayout.createSequentialGroup().addComponent(this.jPanel5, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel6, -2, -1, -2).addGap(18, 18, 18).addGroup(JPObserveLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGrabar, -1, 101, 32767).addComponent(this.JBClasificacion1, -1, -1, 32767)))).addContainerGap()));
        GroupLayout JPIDeterminarLayout = new GroupLayout(this.JPIDeterminar);
        this.JPIDeterminar.setLayout(JPIDeterminarLayout);
        JPIDeterminarLayout.setHorizontalGroup(JPIDeterminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDeterminarLayout.createSequentialGroup().addComponent(this.JPObserve, -2, -1, -2).addGap(0, 13, 32767)));
        JPIDeterminarLayout.setVerticalGroup(JPIDeterminarLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDeterminarLayout.createSequentialGroup().addComponent(this.JPObserve, -2, -1, -2).addGap(0, 20, 32767)));
        this.JTP_Informacion.addTab("OBSERVAR Y DETERMINAR", this.JPIDeterminar);
        this.JSPPreguntasAiepi1.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBhistorico.setFont(new Font("Arial", 1, 12));
        this.JTBhistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBhistorico.setRowHeight(30);
        this.JTBhistorico.setSelectionMode(0);
        this.JTBhistorico.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.19
            public void mouseClicked(MouseEvent evt) {
                JPAiepiOncologicoTest.this.JTBhistoricoMouseClicked(evt);
            }
        });
        this.JSPPreguntasAiepi1.setViewportView(this.JTBhistorico);
        GroupLayout JPIHistoricoLayout = new GroupLayout(this.JPIHistorico);
        this.JPIHistorico.setLayout(JPIHistoricoLayout);
        JPIHistoricoLayout.setHorizontalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPPreguntasAiepi1, -2, 1024, -2).addContainerGap(-1, 32767)));
        JPIHistoricoLayout.setVerticalGroup(JPIHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPPreguntasAiepi1, -2, 491, -2).addContainerGap(110, 32767)));
        this.JTP_Informacion.addTab("HISTORICO", this.JPIHistorico);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTP_Informacion, -2, 1040, -2).addGap(0, 14, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTP_Informacion));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(17, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBOjoBlancoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBDebilidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF1KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF2ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF2KeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        save();
        loadHistoricalData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi1ActionPerformed(ActionEvent evt) {
        this.radioButtons[0] = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi3ActionPerformed(ActionEvent evt) {
        this.radioButtons[2] = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo3ActionPerformed(ActionEvent evt) {
        this.radioButtons[2] = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo1ActionPerformed(ActionEvent evt) {
        this.radioButtons[0] = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi2ActionPerformed(ActionEvent evt) {
        this.radioButtons[1] = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo2ActionPerformed(ActionEvent evt) {
        this.radioButtons[1] = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi4ActionPerformed(ActionEvent evt) {
        this.radioButtons[3] = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSi5ActionPerformed(ActionEvent evt) {
        this.radioButtons[4] = "SI";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo4ActionPerformed(ActionEvent evt) {
        this.radioButtons[3] = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNo5ActionPerformed(ActionEvent evt) {
        this.radioButtons[4] = "NO";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBPreguntasAiepiMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBhistoricoMouseClicked(MouseEvent evt) {
        ListSelectionModel selectionModel = this.JTBhistorico.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.20
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = JPAiepiOncologicoTest.this.JTBhistorico.getSelectedRow();
                if (selectedRow != -1) {
                    JPAiepiOncologicoTest.this.JTBhistorico.setSelectionBackground(Color.RED);
                }
            }
        });
        if (evt.getClickCount() == 2) {
            loadResultHistorical();
        }
    }

    public void newM() {
        loadModelDataQuestions();
        this.JTF1.setEnabled(false);
        this.JTF2.setEnabled(false);
        this.JTF1.setText("");
        this.JTF2.setText("");
        this.JTAObservacion.setText("");
        this.JBClasificacion.setOpaque(false);
        this.JBClasificacion.setBackground(new Color(0, 0, 0, 0));
        this.JBClasificacion.setRolloverEnabled(false);
        this.JBClasificacion.setOpaque(false);
        this.JBClasificacion.setBackground(new Color(0, 0, 0, 0));
        this.JBClasificacion1.setRolloverEnabled(false);
        this.radioButtons[0] = "NO";
        this.radioButtons[1] = "NO";
        this.radioButtons[2] = "NO";
        this.radioButtons[3] = "NO";
        this.radioButtons[4] = "NO";
        loadHistoricalData();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void createModelDataQuestions() {
        this.model = new DefaultTableModel(new Object[0], new String[]{"PREGUNTA", "RESPUESTA"}) { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.21
            Class[] types = {String.class, Object.class};
            boolean[] canEdit = {false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBPreguntasAiepi.setModel(this.model);
        this.JTBPreguntasAiepi.doLayout();
        this.JTBPreguntasAiepi.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBPreguntasAiepi.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    private void loadModelDataQuestions() {
        new JTextField();
        new JTextField();
        createModelDataQuestions();
        this.listPAiepiOncologicoPreguntas = this.aiepiOncologicoPreguntasService.getListPAiepiOncologicoPreguntasByTestPadreAndOrden(0);
        TableColumn comboBoxColumn = this.JTBPreguntasAiepi.getColumnModel().getColumn(1);
        JComboBox<String> comboBox = new JComboBox<>();
        loadComboAnswersToQuestions(comboBox);
        comboBoxColumn.setCellEditor(new DefaultCellEditor(comboBox));
        comboBoxColumn.setCellRenderer(new DefaultTableCellRenderer());
        for (PAiepiOncologicoPreguntas pregunta : this.listPAiepiOncologicoPreguntas) {
            JComboBox<String> comboBox2 = new JComboBox<>();
            this.model.addRow(new Object[]{pregunta.getPregunta(), comboBox2});
            loadComboAnswersToQuestions(comboBox2);
        }
        validateSelection();
        int tableHeight = this.JTBPreguntasAiepi.getRowHeight() * this.JTBPreguntasAiepi.getRowCount();
        Dimension tableDimension = new Dimension(500, tableHeight);
        this.JTBPreguntasAiepi.setPreferredSize(tableDimension);
        for (int i = 0; i < this.JTBPreguntasAiepi.getRowCount(); i++) {
            this.JTBPreguntasAiepi.setValueAt("Seleccione", i, 1);
        }
    }

    public void loadComboAnswersToQuestions(JComboBox<String> comboBox) {
        this.listAiepiRespuestas = this.aiepiRespuestasService.getListPAiepiRespuestasByTestPadreOrderedByOrden(0);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (PAiepiRespuestas respuesta : this.listAiepiRespuestas) {
            model.addElement(respuesta.getDescripcion());
        }
        comboBox.setModel(model);
        comboBox.setSelectedIndex(0);
    }

    public void save() {
        boolean allSelected = true;
        for (int row = 0; row < this.model.getRowCount(); row++) {
            Object value = this.model.getValueAt(row, 1);
            if (value == null || value.toString().isEmpty() || value.toString().equals("Seleccione")) {
                allSelected = false;
                break;
            }
        }
        if (allSelected) {
            PAiepiEncabezado encabezadoO = new PAiepiEncabezado();
            encabezadoO.setIdAtencion(this.idAtencion);
            encabezadoO.setIdUsuario(this.idUsuario);
            encabezadoO.setIdEspecialista(Integer.valueOf(this.idEspecialidad));
            encabezadoO.setFecha(this.currentDate);
            encabezadoO.setFechaR(this.currentDate);
            encabezadoO.setEstado(true);
            encabezadoO.setUsuarioS(this.usuarioS);
            encabezadoO.setIdProfesional((Integer) null);
            this.aiepiEncabezadoService.save(encabezadoO);
            List<PAiepiEncabezado> encabezado1 = this.aiepiEncabezadoService.getListPAiepiEncabezadoByIdAsc();
            PAiepiEncabezado ultimoEncabezado = encabezado1.get(encabezado1.size() - 1);
            int i = 0;
            while (true) {
                if (i >= 5) {
                    break;
                }
                Map<String, List<String>> preguntasYRespuestas1 = saveQuestionsAndAnswersCHB();
                Iterator<Map.Entry<String, List<String>>> it = preguntasYRespuestas1.entrySet().iterator();
                if (it.hasNext()) {
                    List<String> respuest1 = it.next().getValue();
                    if (respuest1.size() > 0 && this.JBClasificacion.getText().isEmpty()) {
                        System.out.println("graveeee ");
                        this.JBClasificacion.setText("POSIBLE CÁNCER O ENFERMEDAD MUY GRAVE");
                        this.JBClasificacion1.setText("POSIBLE CÁNCER O ENFERMEDAD MUY GRAVE");
                        this.JBClasificacion.setBackground(Color.RED);
                        this.JBClasificacion1.setBackground(Color.RED);
                    }
                }
                if (!this.radioButtons[i].toString().equals("SI")) {
                    i++;
                } else {
                    this.JBClasificacion.setText("POSIBLE CÁNCER O ENFERMEDAD MUY GRAVE");
                    this.JBClasificacion1.setText("POSIBLE CÁNCER O ENFERMEDAD MUY GRAVE");
                    this.JBClasificacion.setBackground(Color.red);
                    this.JBClasificacion1.setBackground(Color.red);
                    break;
                }
            }
            int i2 = 0;
            while (true) {
                if (i2 >= this.JTBPreguntasAiepi.getRowCount()) {
                    break;
                }
                System.out.println("this.model.getValueAt(i, 1).toString() -> " + i2 + "" + this.model.getValueAt(i2, 1).toString());
                System.out.println("this.JBClasificacion.getText() -> " + this.JBClasificacion.getText());
                if (!this.JBClasificacion.getText().isEmpty() || !this.model.getValueAt(i2, 1).toString().equals("SI")) {
                    i2++;
                } else {
                    this.JBClasificacion.setText("ALGÚN RIESGO DE CÁNCER");
                    this.JBClasificacion1.setText("ALGÚN RIESGO DE CÁNCER");
                    this.JBClasificacion.setBackground(Color.ORANGE);
                    this.JBClasificacion1.setBackground(Color.ORANGE);
                    break;
                }
            }
            if (this.JBClasificacion.getText().isEmpty()) {
                this.JBClasificacion.setText("NO TIENE CÁNCER");
                this.JBClasificacion1.setText("NO TIENE CÁNCER");
                this.JBClasificacion.setBackground(Color.GREEN);
                this.JBClasificacion1.setBackground(Color.GREEN);
            }
            this.clasificacion = this.JBClasificacion.getText();
            System.out.println("la clasificacion es -> " + this.clasificacion);
            new PAiepiEncabezado();
            PAiepiOncologicoPreguntas preguntaObj = new PAiepiOncologicoPreguntas();
            PAiepiRespuestas respuestaObj = new PAiepiRespuestas();
            PAiepiClasificacion clasificacionObj = new PAiepiClasificacion();
            for (int i3 = 0; i3 < this.JTBPreguntasAiepi.getRowCount(); i3++) {
                PAiepiOncologicoRespuestas respuestas = new PAiepiOncologicoRespuestas();
                this.pregunta = this.model.getValueAt(i3, 0).toString();
                this.respuesta = this.model.getValueAt(i3, 1).toString();
                List<PAiepiOncologicoPreguntas> preguntaR = this.aiepiOncologicoPreguntasService.getListPAiepiOncologicoPreguntasByPregunta(this.pregunta);
                for (PAiepiOncologicoPreguntas preguntaRP : preguntaR) {
                    preguntaObj.setId(preguntaRP.getId());
                }
                List<PAiepiRespuestas> respuestaR = this.aiepiRespuestasService.getListPAiepiRespuestasByDescripcion(this.respuesta);
                for (PAiepiRespuestas respuestaRP : respuestaR) {
                    respuestaObj.setId(respuestaRP.getId());
                }
                List<PAiepiClasificacion> clasificacionR = this.aiepiClasificacionService.getListPAiepiClasificacionByDescripcion(this.clasificacion);
                for (PAiepiClasificacion clasificacionRP : clasificacionR) {
                    clasificacionObj.setId(clasificacionRP.getId());
                }
                String Obsv1 = this.JTF1.getText();
                String Obsv2 = this.JTF2.getText();
                System.out.println("Obsv1 -> " + Obsv1);
                System.out.println("Obsv2 -> " + Obsv2);
                System.out.println("this.JTAObservacion.getText() -> " + this.JTAObservacion.getText());
                System.out.println("encabezado -> " + ultimoEncabezado);
                System.out.println("preguntaObj -> " + preguntaObj);
                System.out.println("respuestaObj -> " + respuestaObj);
                System.out.println("clasificacionObj -> " + clasificacionObj);
                System.out.println(this.currentDate + "-" + this.usuarioS);
                System.out.println("");
                respuestas.setObsv1(Obsv1);
                respuestas.setObsv2(Obsv2);
                respuestas.setObservacion(this.JTAObservacion.getText());
                respuestas.setIdEncabezado(ultimoEncabezado);
                respuestas.setIdPregunta(preguntaObj);
                respuestas.setIdRespuesta(respuestaObj);
                respuestas.setIdClasificacion(clasificacionObj);
                respuestas.setEstado(1);
                respuestas.setFechaCreacion(this.currentDate);
                respuestas.setUsuarioS(this.usuarioS);
                this.aiepiOncologicoRespuestasService.save(respuestas);
            }
            for (int i4 = 0; i4 < 5; i4++) {
                PAiepiOncologicoPreguntas preguntaObj1 = new PAiepiOncologicoPreguntas();
                PAiepiRespuestas respuestaObj1 = new PAiepiRespuestas();
                PAiepiClasificacion clasificacionObj1 = new PAiepiClasificacion();
                PAiepiOncologicoRespuestas respuestas2 = new PAiepiOncologicoRespuestas();
                String[] jLabels = getJLabelValues();
                this.clasificacion = this.JBClasificacion.getText();
                List<PAiepiOncologicoPreguntas> preguntaR2 = this.aiepiOncologicoPreguntasService.getListPAiepiOncologicoPreguntasByPregunta(jLabels[i4]);
                for (PAiepiOncologicoPreguntas preguntaRP2 : preguntaR2) {
                    preguntaObj1.setId(preguntaRP2.getId());
                }
                List<PAiepiRespuestas> respuestaR2 = this.aiepiRespuestasService.getListPAiepiRespuestasByDescripcion(this.radioButtons[i4]);
                for (PAiepiRespuestas respuestaRP2 : respuestaR2) {
                    respuestaObj1.setId(respuestaRP2.getId());
                }
                List<PAiepiClasificacion> clasificacionR2 = this.aiepiClasificacionService.getListPAiepiClasificacionByDescripcion(this.clasificacion);
                for (PAiepiClasificacion clasificacionRP2 : clasificacionR2) {
                    clasificacionObj1.setId(clasificacionRP2.getId());
                }
                respuestas2.setIdEncabezado(ultimoEncabezado);
                respuestas2.setIdPregunta(preguntaObj1);
                respuestas2.setIdRespuesta(respuestaObj1);
                respuestas2.setIdClasificacion(clasificacionObj1);
                respuestas2.setEstado(1);
                respuestas2.setFechaCreacion(this.currentDate);
                respuestas2.setUsuarioS(this.usuarioS);
                this.aiepiOncologicoRespuestasService.save(respuestas2);
            }
            Map<String, List<String>> preguntasYRespuestas = saveQuestionsAndAnswersCHB();
            for (Map.Entry<String, List<String>> entry : preguntasYRespuestas.entrySet()) {
                String pregunta = entry.getKey();
                List<String> respuest = entry.getValue();
                for (String respuesta : respuest) {
                    System.out.println(pregunta + " - " + respuesta);
                    PAiepiOncologicoPreguntas preguntaObj12 = new PAiepiOncologicoPreguntas();
                    PAiepiRespuestas respuestaObj12 = new PAiepiRespuestas();
                    PAiepiClasificacion clasificacionObj12 = new PAiepiClasificacion();
                    PAiepiOncologicoRespuestas respuestas3 = new PAiepiOncologicoRespuestas();
                    this.clasificacion = this.JBClasificacion.getText();
                    List<PAiepiOncologicoPreguntas> preguntaR3 = this.aiepiOncologicoPreguntasService.getListPAiepiOncologicoPreguntasByPregunta(pregunta);
                    for (PAiepiOncologicoPreguntas preguntaRP3 : preguntaR3) {
                        preguntaObj12.setId(preguntaRP3.getId());
                    }
                    List<PAiepiRespuestas> respuestaR3 = this.aiepiRespuestasService.getListPAiepiRespuestasByDescripcion(respuesta);
                    for (PAiepiRespuestas respuestaRP3 : respuestaR3) {
                        respuestaObj12.setId(respuestaRP3.getId());
                    }
                    List<PAiepiClasificacion> clasificacionR3 = this.aiepiClasificacionService.getListPAiepiClasificacionByDescripcion(this.clasificacion);
                    for (PAiepiClasificacion clasificacionRP3 : clasificacionR3) {
                        clasificacionObj12.setId(clasificacionRP3.getId());
                    }
                    respuestas3.setIdEncabezado(ultimoEncabezado);
                    respuestas3.setIdPregunta(preguntaObj12);
                    respuestas3.setIdRespuesta(respuestaObj12);
                    respuestas3.setIdClasificacion(clasificacionObj12);
                    respuestas3.setEstado(1);
                    respuestas3.setFechaCreacion(this.currentDate);
                    respuestas3.setUsuarioS(this.usuarioS);
                    this.aiepiOncologicoRespuestasService.save(respuestas3);
                }
            }
            this.JBTGrabar.setEnabled(false);
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Por favor responda todas las preguntas.");
    }

    public String[] getJLabelValues() {
        String[] preguntas = new String[5];
        JLabel[] jlabels = {this.JL1, this.JL2, this.JL3, this.JL4, this.JL5};
        for (int i = 0; i < jlabels.length; i++) {
            String selectedValue = jlabels[i].getText();
            preguntas[i] = selectedValue;
        }
        return preguntas;
    }

    public Map<String, List<String>> saveQuestionsAndAnswersCHB() {
        String pregunta6 = this.JL6.getText();
        String pregunta7 = this.JL7.getText();
        String pregunta8 = this.JL8.getText();
        Map<String, List<String>> preguntasYRespuestas = new HashMap<>();
        List<String> respuestasSeleccionadas6 = new ArrayList<>();
        if (this.JCBOjoBlanco.isSelected()) {
            respuestasSeleccionadas6.add(this.JCBOjoBlanco.getText());
        }
        if (this.JCBFaltaIris.isSelected()) {
            respuestasSeleccionadas6.add(this.JCBFaltaIris.getText());
        }
        if (this.JCBEstrabismo.isSelected()) {
            respuestasSeleccionadas6.add(this.JCBEstrabismo.getText());
        }
        if (this.JCBSangre.isSelected()) {
            respuestasSeleccionadas6.add(this.JCBSangre.getText());
        }
        if (this.JCBOjosDiferentes.isSelected()) {
            respuestasSeleccionadas6.add(this.JCBOjosDiferentes.getText());
        }
        if (this.JCBSalido.isSelected()) {
            respuestasSeleccionadas6.add(this.JCBSalido.getText());
        }
        if (!respuestasSeleccionadas6.isEmpty() && respuestasSeleccionadas6 != null) {
            preguntasYRespuestas.put(pregunta6, respuestasSeleccionadas6);
        }
        List<String> respuestasSeleccionadas7 = new ArrayList<>();
        if (this.JCBLeve.isSelected()) {
            respuestasSeleccionadas7.add(this.JCBLeve.getText());
        }
        if (this.JCBIntensa.isSelected()) {
            respuestasSeleccionadas7.add(this.JCBIntensa.getText());
        }
        if (!respuestasSeleccionadas7.isEmpty() && respuestasSeleccionadas7 != null) {
            preguntasYRespuestas.put(pregunta7, respuestasSeleccionadas7);
        }
        List<String> respuestasSeleccionadas8 = new ArrayList<>();
        if (this.JCBAsimetria.isSelected()) {
            respuestasSeleccionadas8.add(this.JCBAsimetria.getText());
        }
        if (this.JCBCambios.isSelected()) {
            respuestasSeleccionadas8.add(this.JCBCambios.getText());
        }
        if (this.JCBPerdidaEquilibrio.isSelected()) {
            respuestasSeleccionadas8.add(this.JCBPerdidaEquilibrio.getText());
        }
        if (this.JCBCojea.isSelected()) {
            respuestasSeleccionadas8.add(this.JCBCojea.getText());
        }
        if (this.JCBDificultadHabla.isSelected()) {
            respuestasSeleccionadas8.add(this.JCBDificultadHabla.getText());
        }
        if (this.JCBAlteracionVision.isSelected()) {
            respuestasSeleccionadas8.add(this.JCBAlteracionVision.getText());
        }
        if (this.JCBDebilidad.isSelected()) {
            respuestasSeleccionadas8.add(this.JCBDebilidad.getText());
        }
        if (!respuestasSeleccionadas8.isEmpty() && respuestasSeleccionadas8 != null) {
            preguntasYRespuestas.put(pregunta8, respuestasSeleccionadas8);
        }
        return preguntasYRespuestas;
    }

    private void validateSelection() {
        final DefaultTableModel model = this.JTBPreguntasAiepi.getModel();
        final JComboBox comboBox = new JComboBox(new String[]{"", "SI", "NO"});
        TableColumn comboColumn = this.JTBPreguntasAiepi.getColumnModel().getColumn(1);
        comboColumn.setCellEditor(new DefaultCellEditor(comboBox));
        comboBox.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.22
            public void actionPerformed(ActionEvent e) {
                int row = JPAiepiOncologicoTest.this.JTBPreguntasAiepi.getSelectedRow();
                int col = JPAiepiOncologicoTest.this.JTBPreguntasAiepi.getSelectedColumn();
                String selectedItem = (String) comboBox.getSelectedItem();
                if (selectedItem.equals("")) {
                    JOptionPane.showMessageDialog((Component) null, "Debe seleccionar una respuesta");
                    comboBox.setSelectedItem("NO");
                    return;
                }
                if (col == 1 && row == 1) {
                    if (selectedItem.equals("SI")) {
                        JPAiepiOncologicoTest.this.JTF1.setEnabled(true);
                        JOptionPane.showMessageDialog((Component) null, "Por favor Responda " + model.getValueAt(row, 0).toString());
                        JPAiepiOncologicoTest.this.JTF1.requestFocus();
                        return;
                    }
                    JPAiepiOncologicoTest.this.JTF1.setEnabled(false);
                    return;
                }
                if (col == 1 && row == 7) {
                    if (selectedItem.equals("SI")) {
                        JPAiepiOncologicoTest.this.JTF2.setEnabled(true);
                        JOptionPane.showMessageDialog((Component) null, "Por favor Responda " + model.getValueAt(row, 0).toString());
                        JPAiepiOncologicoTest.this.JTF2.requestFocus();
                        return;
                    }
                    JPAiepiOncologicoTest.this.JTF2.setEnabled(false);
                }
            }
        });
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void createHistoricalDataModel() {
        this.modelH = new DefaultTableModel(new Object[0], new String[]{"ID ENCABEZADO", "FECHA", "ID ATENCION"}) { // from class: com.genoma.plus.controller.historia.JPAiepiOncologicoTest.23
            Class[] types = {Integer.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBhistorico.setModel(this.modelH);
        this.JTBhistorico.doLayout();
        this.JTBhistorico.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTBhistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTBhistorico.getColumnModel().getColumn(1).setPreferredWidth(50);
    }

    private void loadHistoricalData() {
        createHistoricalDataModel();
        this.listPAiepiEncabezado = this.aiepiEncabezadoService.getfindByIdUsuario(Integer.valueOf(this.idUsuario));
        this.listPAiepiEncabezado.forEach(e -> {
            this.modelH.addRow(this.data);
            this.modelH.setValueAt(e.getId(), this.JTBhistorico.getRowCount() - 1, 0);
            this.modelH.setValueAt(e.getFechaR(), this.JTBhistorico.getRowCount() - 1, 1);
            this.modelH.setValueAt(Long.valueOf(e.getIdAtencion()), this.JTBhistorico.getRowCount() - 1, 2);
        });
    }

    private void loadResultHistorical() {
        this.JTP_Informacion.setSelectedIndex(1);
        this.JBTGrabar.setEnabled(false);
        createModelDataQuestions();
        this.JTAObservacion.setEnabled(false);
        int encabezadoId = Integer.parseInt(this.modelH.getValueAt(this.JTBhistorico.getSelectedRow(), 0).toString());
        List<PAiepiEncabezado> encabezado = this.aiepiEncabezadoService.getListPAiepiEncabezadoByIdAsc(Integer.valueOf(encabezadoId));
        System.out.println("encabezadoId -> " + encabezadoId);
        new ArrayList();
        List<PAiepiOncologicoRespuestas> respuesta = this.aiepiOncologicoRespuestasService.getListPAiepiRespuestasByIdEncabezadoOrderByIdAsc(encabezado);
        System.out.println("lista respuesta -> " + respuesta.size());
        respuesta.forEach(e -> {
            this.model.addRow(this.data);
            this.model.setValueAt(e.getIdPregunta().getPregunta(), this.JTBPreguntasAiepi.getRowCount() - 1, 0);
            this.model.setValueAt(e.getIdRespuesta().getDescripcion(), this.JTBPreguntasAiepi.getRowCount() - 1, 1);
            if (e.getObsv1() != null) {
                this.JTF1.setText(e.getObsv1());
            }
            if (e.getObsv2() != null) {
                this.JTF2.setText(e.getObsv2());
            }
            if (e.getObservacion() != null) {
                this.JTAObservacion.setText(e.getObservacion());
            }
            if (this.JBClasificacion.getText().isEmpty() && this.JBClasificacion1.getText().isEmpty()) {
                this.JBClasificacion.setText(e.getIdClasificacion().getDescripcion());
                this.JBClasificacion1.setText(e.getIdClasificacion().getDescripcion());
                if (e.getIdClasificacion().getId().intValue() == 1) {
                    this.JBClasificacion.setBackground(Color.green);
                    this.JBClasificacion1.setBackground(Color.green);
                } else if (e.getIdClasificacion().getId().intValue() == 2) {
                    this.JBClasificacion1.setBackground(Color.red);
                    this.JBClasificacion.setBackground(Color.red);
                } else if (e.getIdClasificacion().getId().intValue() == 3) {
                    this.JBClasificacion.setBackground(Color.orange);
                    this.JBClasificacion1.setBackground(Color.orange);
                }
            }
        });
        new ArrayList();
        List<PAiepiOncologicoRespuestas> respuesta2 = this.aiepiOncologicoRespuestasService.getListPAiepiRespuestasByIdEncabezadoOrderByIdDesc(encabezado);
        respuesta2.forEach(e2 -> {
            if (e2.getIdPregunta().getPregunta().equalsIgnoreCase(this.JL1.getText())) {
                if (e2.getIdRespuesta().getDescripcion().equals("SI")) {
                    this.JRBSi1.setSelected(true);
                } else {
                    this.JRBNo1.setSelected(true);
                }
            } else if (e2.getIdPregunta().getPregunta().equalsIgnoreCase(this.JL2.getText())) {
                if (e2.getIdRespuesta().getDescripcion().equals("SI")) {
                    this.JRBSi2.setSelected(true);
                } else {
                    this.JRBNo2.setSelected(true);
                }
            } else if (e2.getIdPregunta().getPregunta().equalsIgnoreCase(this.JL3.getText())) {
                if (e2.getIdRespuesta().getDescripcion().equals("SI")) {
                    this.JRBSi3.setSelected(true);
                } else {
                    this.JRBNo3.setSelected(true);
                }
            } else if (e2.getIdPregunta().getPregunta().equalsIgnoreCase(this.JL4.getText())) {
                if (e2.getIdRespuesta().getDescripcion().equals("SI")) {
                    this.JRBSi4.setSelected(true);
                } else {
                    this.JRBNo4.setSelected(true);
                }
            } else if (e2.getIdPregunta().getPregunta().equalsIgnoreCase(this.JL5.getText())) {
                if (e2.getIdRespuesta().getDescripcion().equals("SI")) {
                    this.JRBSi5.setSelected(true);
                } else {
                    this.JRBNo5.setSelected(true);
                }
            }
            if (e2.getIdPregunta().getPregunta().equalsIgnoreCase(this.JL6.getText())) {
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBOjoBlanco.getText())) {
                    this.JCBOjoBlanco.setSelected(true);
                    return;
                }
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBFaltaIris.getText())) {
                    this.JCBFaltaIris.setSelected(true);
                    return;
                }
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBEstrabismo.getText())) {
                    this.JCBEstrabismo.setSelected(true);
                    return;
                }
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBSangre.getText())) {
                    this.JCBSangre.setSelected(true);
                    return;
                } else if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBOjosDiferentes.getText())) {
                    this.JCBOjosDiferentes.setSelected(true);
                    return;
                } else {
                    if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBSalido.getText())) {
                        this.JCBSalido.setSelected(true);
                        return;
                    }
                    return;
                }
            }
            if (e2.getIdPregunta().getPregunta().equalsIgnoreCase(this.JL7.getText())) {
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBLeve.getText())) {
                    this.JCBLeve.setSelected(true);
                    return;
                } else {
                    if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBIntensa.getText())) {
                        this.JCBIntensa.setSelected(true);
                        return;
                    }
                    return;
                }
            }
            if (e2.getIdPregunta().getPregunta().equalsIgnoreCase(this.JL8.getText())) {
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBDebilidad.getText())) {
                    this.JCBDebilidad.setSelected(true);
                    return;
                }
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBAsimetria.getText())) {
                    this.JCBAsimetria.setSelected(true);
                    return;
                }
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBCambios.getText())) {
                    this.JCBCambios.setSelected(true);
                    return;
                }
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBPerdidaEquilibrio.getText())) {
                    this.JCBPerdidaEquilibrio.setSelected(true);
                    return;
                }
                if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBCojea.getText())) {
                    this.JCBCojea.setSelected(true);
                } else if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBDificultadHabla.getText())) {
                    this.JCBDificultadHabla.setSelected(true);
                } else if (e2.getIdRespuesta().getDescripcion().equalsIgnoreCase(this.JCBAlteracionVision.getText())) {
                    this.JCBAlteracionVision.setSelected(true);
                }
            }
        });
    }
}
