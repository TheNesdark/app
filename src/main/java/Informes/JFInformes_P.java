package Informes;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/* JADX INFO: loaded from: GenomaP.jar:Informes/JFInformes_P.class */
public class JFInformes_P extends JFrame {
    public static clasesInformes claseinformes = null;
    private ConsultasMySQL xconsultas = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private JMenuItem JIMIIncapacidades;
    private JMenuItem JMCAMedicosE;
    private JMenuItem JMCAMedicosG;
    private JMenuItem JMCRemisionMD;
    private JMenuItem JMCRemisionMDPyP;
    private JMenuItem JMCRemisionME;
    private JMenuItem JMFConsolidadoC;
    private JMenuItem JMIAuditoriaHC;
    private JMenuItem JMIAuditoriaTriage;
    private JMenuItem JMICCronicos;
    private JMenu JMIConsolidadoAt;
    private JMenu JMIConsolidadoAt1;
    private JMenu JMIConsolidadoFT;
    private JMenu JMIDireccionCient1;
    private JMenuItem JMIIAuditoriaI;
    private JMenu JMIInventario;
    private JMenu JMILaboratorio;
    private JMenuItem JMIMorbilidadTCons1;
    private JMenu JMINutricion1;
    private JMenuItem JMIPTiempoFacCons;
    private JMenuItem JMIPTiempoLab;
    private JMenu JMIPamec;
    private JMenu JMIPromocionyP;
    private JMenuItem JMIPyPFSActividad;
    private JMenuItem JMIPyPFSPrgActividad;
    private JMenuItem JMIPyPFSReggActividad;
    private JMenu JMIPyPFSalud;
    private JMenuItem JMIRFInformeNP;
    private JMenu JMIRFacturacion;
    private JMenu JMIVarios;
    private JMenuItem JMLRecepciones;
    private JMenuItem JMNIActualizarRef;
    private JMenuItem JMNIActualizarRef1;
    private JMenuItem JMNICInforNutricional;
    private JMenuItem JMNIEstadoN;
    public static JMenuBar barraMnuInformes;
    private JMenuItem jMenuItem20;
    private JMenuItem jMenuItem21;
    private JMenuItem jMenuItem23;
    private JMenuItem mnuPyp2;
    private JMenuItem mnuPyp4;

    public JFInformes_P() {
        initComponents();
    }

    private void initComponents() {
        barraMnuInformes = new JMenuBar();
        this.JMIDireccionCient1 = new JMenu();
        this.JMIAuditoriaHC = new JMenuItem();
        this.JMIAuditoriaTriage = new JMenuItem();
        this.JMICCronicos = new JMenuItem();
        this.JMIMorbilidadTCons1 = new JMenuItem();
        this.JMIConsolidadoAt1 = new JMenu();
        this.JMNIActualizarRef = new JMenuItem();
        this.JMNIEstadoN = new JMenuItem();
        this.JMNICInforNutricional = new JMenuItem();
        this.JMNIActualizarRef1 = new JMenuItem();
        this.JMIConsolidadoAt = new JMenu();
        this.JMCAMedicosG = new JMenuItem();
        this.JMCAMedicosE = new JMenuItem();
        this.JMCRemisionMD = new JMenuItem();
        this.JMCRemisionME = new JMenuItem();
        this.JMCRemisionMDPyP = new JMenuItem();
        this.JMILaboratorio = new JMenu();
        this.JMLRecepciones = new JMenuItem();
        this.JMIConsolidadoFT = new JMenu();
        this.JMFConsolidadoC = new JMenuItem();
        this.JMIRFacturacion = new JMenu();
        this.JMIRFInformeNP = new JMenuItem();
        this.jMenuItem21 = new JMenuItem();
        this.jMenuItem20 = new JMenuItem();
        this.JMIInventario = new JMenu();
        this.JMIIAuditoriaI = new JMenuItem();
        this.JMIPamec = new JMenu();
        this.JMINutricion1 = new JMenu();
        this.JMIPTiempoLab = new JMenuItem();
        this.JMIPTiempoFacCons = new JMenuItem();
        this.JMIPromocionyP = new JMenu();
        this.mnuPyp2 = new JMenuItem();
        this.JMIPyPFSalud = new JMenu();
        this.JMIPyPFSActividad = new JMenuItem();
        this.JMIPyPFSPrgActividad = new JMenuItem();
        this.JMIPyPFSReggActividad = new JMenuItem();
        this.mnuPyp4 = new JMenuItem();
        this.JMIVarios = new JMenu();
        this.jMenuItem23 = new JMenuItem();
        this.JIMIIncapacidades = new JMenuItem();
        setDefaultCloseOperation(3);
        this.JMIDireccionCient1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JMIDireccionCient1.setText("Dirección Científica");
        this.JMIDireccionCient1.setToolTipText("Informes Preliminares");
        this.JMIDireccionCient1.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.1
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIDireccionCient1ActionPerformed(evt);
            }
        });
        this.JMIAuditoriaHC.setText("Auditoria HC");
        this.JMIAuditoriaHC.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.2
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIAuditoriaHCActionPerformed(evt);
            }
        });
        this.JMIDireccionCient1.add(this.JMIAuditoriaHC);
        this.JMIAuditoriaTriage.setText("Auditoria de Triage");
        this.JMIAuditoriaTriage.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.3
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIAuditoriaTriageActionPerformed(evt);
            }
        });
        this.JMIDireccionCient1.add(this.JMIAuditoriaTriage);
        this.JMICCronicos.setText("Consultadores Crónicos x Especialidad");
        this.JMICCronicos.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.4
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMICCronicosActionPerformed(evt);
            }
        });
        this.JMIDireccionCient1.add(this.JMICCronicos);
        this.JMIMorbilidadTCons1.setText("Morbilidad x Tipo de Consulta");
        this.JMIMorbilidadTCons1.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.5
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIMorbilidadTCons1ActionPerformed(evt);
            }
        });
        this.JMIDireccionCient1.add(this.JMIMorbilidadTCons1);
        this.JMIConsolidadoAt1.setText("Nutrición");
        this.JMNIActualizarRef.setText("Actualizar Referencia de Consulta");
        this.JMNIActualizarRef.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.6
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMNIActualizarRefActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt1.add(this.JMNIActualizarRef);
        this.JMNIEstadoN.setText("Consolidado de Información");
        this.JMNIEstadoN.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.7
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMNIEstadoNActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt1.add(this.JMNIEstadoN);
        this.JMNICInforNutricional.setText("Consultar Información Nutricional");
        this.JMNICInforNutricional.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.8
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMNICInforNutricionalActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt1.add(this.JMNICInforNutricional);
        this.JMNIActualizarRef1.setText("Consultar Reduciones de Peso");
        this.JMNIActualizarRef1.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.9
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMNIActualizarRef1ActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt1.add(this.JMNIActualizarRef1);
        this.JMIDireccionCient1.add(this.JMIConsolidadoAt1);
        this.JMIConsolidadoAt.setText("Consolidado de Atenciones");
        this.JMCAMedicosG.setText("Médicos Generales");
        this.JMCAMedicosG.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.10
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMCAMedicosGActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt.add(this.JMCAMedicosG);
        this.JMCAMedicosE.setText("Médicos Especialistas");
        this.JMCAMedicosE.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.11
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMCAMedicosEActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt.add(this.JMCAMedicosE);
        this.JMCRemisionMD.setText("Remisiones x Medicos Generales");
        this.JMCRemisionMD.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.12
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMCRemisionMDActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt.add(this.JMCRemisionMD);
        this.JMCRemisionME.setText("Remisiones x Medicos Especialistas");
        this.JMCRemisionME.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.13
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMCRemisionMEActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt.add(this.JMCRemisionME);
        this.JMCRemisionMDPyP.setText("Remisiones x Medicos PyP");
        this.JMCRemisionMDPyP.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.14
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMCRemisionMDPyPActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoAt.add(this.JMCRemisionMDPyP);
        this.JMIDireccionCient1.add(this.JMIConsolidadoAt);
        this.JMILaboratorio.setText("Laboratorio");
        this.JMLRecepciones.setText("Estadistica de Recepciones");
        this.JMLRecepciones.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.15
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMLRecepcionesActionPerformed1(evt);
            }
        });
        this.JMILaboratorio.add(this.JMLRecepciones);
        this.JMIDireccionCient1.add(this.JMILaboratorio);
        this.JMIConsolidadoFT.setText("Fisioterapia");
        this.JMFConsolidadoC.setText("Consolidado de Citas");
        this.JMFConsolidadoC.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.16
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMFConsolidadoCActionPerformed1(evt);
            }
        });
        this.JMIConsolidadoFT.add(this.JMFConsolidadoC);
        this.JMIDireccionCient1.add(this.JMIConsolidadoFT);
        barraMnuInformes.add(this.JMIDireccionCient1);
        this.JMIRFacturacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JMIRFacturacion.setText("Facturación");
        this.JMIRFacturacion.setToolTipText("Informes Preliminares");
        this.JMIRFacturacion.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.17
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIRFacturacionActionPerformed(evt);
            }
        });
        this.JMIRFInformeNP.setText("Consolidado de Atenciones No Programadas x Médicos");
        this.JMIRFInformeNP.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.18
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIRFInformeNPActionPerformed1(evt);
            }
        });
        this.JMIRFacturacion.add(this.JMIRFInformeNP);
        this.jMenuItem21.setText("Morbilidad x Tipo de Consulta");
        this.jMenuItem21.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.19
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.jMenuItem21ActionPerformed1(evt);
            }
        });
        this.JMIRFacturacion.add(this.jMenuItem21);
        this.jMenuItem20.setText("Procedimientos Facturados x Empresa");
        this.jMenuItem20.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.20
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.jMenuItem20ActionPerformed1(evt);
            }
        });
        this.JMIRFacturacion.add(this.jMenuItem20);
        barraMnuInformes.add(this.JMIRFacturacion);
        this.JMIInventario.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JMIInventario.setText("Inventario");
        this.JMIInventario.setToolTipText("Informes Preliminares");
        this.JMIIAuditoriaI.setText("Auditoria de Productos");
        this.JMIIAuditoriaI.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.21
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIIAuditoriaIActionPerformed(evt);
            }
        });
        this.JMIInventario.add(this.JMIIAuditoriaI);
        barraMnuInformes.add(this.JMIInventario);
        this.JMIPamec.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JMIPamec.setText("Pamec");
        this.JMIPamec.setToolTipText("Informes Preliminares");
        this.JMIPamec.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.22
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIPamecActionPerformed(evt);
            }
        });
        this.JMINutricion1.setText("Reportes de Tiempo");
        this.JMIPTiempoLab.setText("Laboratorio - Atención Médica");
        this.JMIPTiempoLab.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.23
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIPTiempoLabActionPerformed(evt);
            }
        });
        this.JMINutricion1.add(this.JMIPTiempoLab);
        this.JMIPTiempoFacCons.setText("Facturación - Atención Médica Programada");
        this.JMIPTiempoFacCons.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.24
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIPTiempoFacConsActionPerformed(evt);
            }
        });
        this.JMINutricion1.add(this.JMIPTiempoFacCons);
        this.JMIPamec.add(this.JMINutricion1);
        barraMnuInformes.add(this.JMIPamec);
        this.JMIPromocionyP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ordenes16x16.png")));
        this.JMIPromocionyP.setText("Promoción y Prevención");
        this.JMIPromocionyP.setToolTipText("Agenda y Atención de Enfermería");
        this.JMIPromocionyP.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.25
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIPromocionyPActionPerformed(evt);
            }
        });
        this.mnuPyp2.setText("Usuarios por Programa por EPS por Edad");
        this.mnuPyp2.setToolTipText("Ingreso de Usuarios");
        this.mnuPyp2.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.26
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.mnuPyp2ActionPerformed(evt);
            }
        });
        this.JMIPromocionyP.add(this.mnuPyp2);
        this.JMIPyPFSalud.setText("Fomento de la Salud");
        this.JMIPyPFSActividad.setText("Actividades");
        this.JMIPyPFSActividad.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.27
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIPyPFSActividadActionPerformed1(evt);
            }
        });
        this.JMIPyPFSalud.add(this.JMIPyPFSActividad);
        this.JMIPyPFSPrgActividad.setText("Calendario de Actividades");
        this.JMIPyPFSPrgActividad.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.28
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIPyPFSPrgActividadActionPerformed1(evt);
            }
        });
        this.JMIPyPFSalud.add(this.JMIPyPFSPrgActividad);
        this.JMIPyPFSReggActividad.setText("Registro x Usuario");
        this.JMIPyPFSReggActividad.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.29
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIPyPFSReggActividadActionPerformed1(evt);
            }
        });
        this.JMIPyPFSalud.add(this.JMIPyPFSReggActividad);
        this.JMIPromocionyP.add(this.JMIPyPFSalud);
        this.mnuPyp4.setText("Usuarios por Programas");
        this.mnuPyp4.setToolTipText("Ingreso de Usuarios");
        this.mnuPyp4.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.30
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.mnuPyp4ActionPerformed(evt);
            }
        });
        this.JMIPromocionyP.add(this.mnuPyp4);
        barraMnuInformes.add(this.JMIPromocionyP);
        this.JMIVarios.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JMIVarios.setText("Varios");
        this.JMIVarios.setToolTipText("Informes Preliminares");
        this.JMIVarios.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.31
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JMIVariosActionPerformed(evt);
            }
        });
        this.jMenuItem23.setText("Morbilidad x Tipo de Consulta");
        this.jMenuItem23.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.32
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.jMenuItem23ActionPerformed1(evt);
            }
        });
        this.JMIVarios.add(this.jMenuItem23);
        this.JIMIIncapacidades.setText("Incapacidades");
        this.JIMIIncapacidades.addActionListener(new ActionListener() { // from class: Informes.JFInformes_P.33
            public void actionPerformed(ActionEvent evt) {
                JFInformes_P.this.JIMIIncapacidadesActionPerformed1(evt);
            }
        });
        this.JMIVarios.add(this.JIMIIncapacidades);
        barraMnuInformes.add(this.JMIVarios);
        setJMenuBar(barraMnuInformes);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 742, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 271, 32767));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAuditoriaHCActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIAuditoriaHC.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIAuditoriaTriageActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIAuditoriaTriage.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMICCronicosActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMICCronicos.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIMorbilidadTCons1ActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIMorbilidadTCons1.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMNIActualizarRefActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMNIActualizarRef.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMNIEstadoNActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMNIEstadoN.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMNICInforNutricionalActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMNICInforNutricional.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMNIActualizarRef1ActionPerformed1(ActionEvent evt) {
        ConsultasMySQL xmt = new ConsultasMySQL();
        xmt.ejecutarSQL("DROP VIEW IF EXISTS e_refa  ");
        xmt.cerrarConexionBd();
        String sqlw = "CREATE VIEW e_refa AS SELECT h_atencion.Fecha_Atencion AS Fecha,ingreso.Id_Usuario AS Id_Usuario,h_nutricional.Imc AS Imc FROM ((h_atencion JOIN ingreso ON ((h_atencion.Id_Ingreso = ingreso.Id))) JOIN h_nutricional ON ((h_nutricional.Id_Atencion = h_atencion.Id))) WHERE (h_nutricional.AReferencia = 1) ORDER BY h_atencion.Fecha_Atencion ";
        xmt.ejecutarSQL(sqlw);
        xmt.cerrarConexionBd();
        xmt.ejecutarSQL("DROP VIEW IF EXISTS e_refb  ");
        xmt.cerrarConexionBd();
        String sqlw2 = "CREATE VIEW e_refb AS SELECT ingreso.Id_Usuario AS Id_Usuario, MAX(h_nutricional.Id) AS Id FROM ((h_atencion  JOIN ingreso ON ((h_atencion.Id_Ingreso = ingreso.Id))) JOIN h_nutricional ON ((h_nutricional.Id_Atencion = h_atencion.Id))) WHERE (h_nutricional.AReferencia = 0) GROUP BY ingreso.Id_Usuario ";
        xmt.ejecutarSQL(sqlw2);
        xmt.cerrarConexionBd();
        String[][] parametros = new String[3][2];
        parametros[0][0] = "usuario";
        parametros[0][1] = Principal.usuarioSistemaDTO.getNombreUsuario();
        parametros[1][0] = "SUBREPORT_DIR";
        parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        parametros[2][0] = "SUBREPORTFIRMA_DIR";
        parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "H_InformacionNutricionReducionPeso", parametros);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCAMedicosGActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMCAMedicosG.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCAMedicosEActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMCAMedicosE.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCRemisionMDActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMCRemisionMD.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCRemisionMEActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMCRemisionME.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMCRemisionMDPyPActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMCRemisionMDPyP.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMLRecepcionesActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMLRecepciones.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMFConsolidadoCActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMFConsolidadoC.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIDireccionCient1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRFInformeNPActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIRFInformeNP.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem21ActionPerformed1(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem20ActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.jMenuItem20.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIRFacturacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIIAuditoriaIActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIIAuditoriaI.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPTiempoLabActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIPTiempoLab.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPTiempoFacConsActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIPTiempoFacCons.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPamecActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPyp2ActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.mnuPyp2.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPyPFSActividadActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIPyPFSActividad.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPyPFSPrgActividadActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIPyPFSPrgActividad.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPyPFSReggActividadActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JMIPyPFSReggActividad.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mnuPyp4ActionPerformed(ActionEvent evt) {
        claseinformes.cargarPantalla(this.mnuPyp4.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIPromocionyPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jMenuItem23ActionPerformed1(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JIMIIncapacidadesActionPerformed1(ActionEvent evt) {
        claseinformes.cargarPantalla(this.JIMIIncapacidades.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JMIVariosActionPerformed(ActionEvent evt) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0020, code lost:
    
        javax.swing.UIManager.setLookAndFeel(r0.getClassName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r5) {
        /*
            javax.swing.UIManager$LookAndFeelInfo[] r0 = javax.swing.UIManager.getInstalledLookAndFeels()     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L49 java.lang.IllegalAccessException -> L5e javax.swing.UnsupportedLookAndFeelException -> L73
            r6 = r0
            r0 = r6
            int r0 = r0.length     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L49 java.lang.IllegalAccessException -> L5e javax.swing.UnsupportedLookAndFeelException -> L73
            r7 = r0
            r0 = 0
            r8 = r0
        L9:
            r0 = r8
            r1 = r7
            if (r0 >= r1) goto L31
            r0 = r6
            r1 = r8
            r0 = r0[r1]     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L49 java.lang.IllegalAccessException -> L5e javax.swing.UnsupportedLookAndFeelException -> L73
            r9 = r0
            java.lang.String r0 = "Nimbus"
            r1 = r9
            java.lang.String r1 = r1.getName()     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L49 java.lang.IllegalAccessException -> L5e javax.swing.UnsupportedLookAndFeelException -> L73
            boolean r0 = r0.equals(r1)     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L49 java.lang.IllegalAccessException -> L5e javax.swing.UnsupportedLookAndFeelException -> L73
            if (r0 == 0) goto L2b
            r0 = r9
            java.lang.String r0 = r0.getClassName()     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L49 java.lang.IllegalAccessException -> L5e javax.swing.UnsupportedLookAndFeelException -> L73
            javax.swing.UIManager.setLookAndFeel(r0)     // Catch: java.lang.ClassNotFoundException -> L34 java.lang.InstantiationException -> L49 java.lang.IllegalAccessException -> L5e javax.swing.UnsupportedLookAndFeelException -> L73
            goto L31
        L2b:
            int r8 = r8 + 1
            goto L9
        L31:
            goto L85
        L34:
            r6 = move-exception
            java.lang.Class<Informes.JFInformes_P> r0 = Informes.JFInformes_P.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            r2 = 0
            r3 = r6
            r0.log(r1, r2, r3)
            goto L85
        L49:
            r6 = move-exception
            java.lang.Class<Informes.JFInformes_P> r0 = Informes.JFInformes_P.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            r2 = 0
            r3 = r6
            r0.log(r1, r2, r3)
            goto L85
        L5e:
            r6 = move-exception
            java.lang.Class<Informes.JFInformes_P> r0 = Informes.JFInformes_P.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            r2 = 0
            r3 = r6
            r0.log(r1, r2, r3)
            goto L85
        L73:
            r6 = move-exception
            java.lang.Class<Informes.JFInformes_P> r0 = Informes.JFInformes_P.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE
            r2 = 0
            r3 = r6
            r0.log(r1, r2, r3)
        L85:
            Informes.JFInformes_P$34 r0 = new Informes.JFInformes_P$34
            r1 = r0
            r1.<init>()
            java.awt.EventQueue.invokeLater(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: Informes.JFInformes_P.main(java.lang.String[]):void");
    }
}
