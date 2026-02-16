package Salud_Ocupacional;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.HSoDatosSensibles;
import com.genoma.plus.jpa.entities.HSoDeclaracionSalud;
import com.genoma.plus.jpa.service.HSoDatosSensiblesService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JDDatosSensibles.class */
public class JDDatosSensibles extends JDialog {
    private HSoDatosSensibles datosSensibles;
    private final HSoDatosSensiblesService datosSensiblesService;
    private Metodos metodos;
    private Long idIngreso;
    private HSoDeclaracionSalud declaracion;
    private JButton JBTAceptar;
    private JButton JBTRechazar;
    private JTextArea JTADatos;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDDatosSensibles(Frame parent, boolean modal, Long ingreso, HSoDeclaracionSalud declaracion) {
        super(parent, modal);
        this.metodos = new Metodos();
        initComponents();
        this.datosSensiblesService = (HSoDatosSensiblesService) Principal.contexto.getBean(HSoDatosSensiblesService.class);
        this.idIngreso = ingreso;
        this.declaracion = declaracion;
        cargarAutorizacionInicial();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTADatos = new JTextArea();
        this.jLabel1 = new JLabel();
        this.JBTAceptar = new JButton();
        this.JBTRechazar = new JButton();
        setDefaultCloseOperation(2);
        this.jScrollPane1.setFont(new Font("Dialog", 0, 14));
        this.JTADatos.setColumns(20);
        this.JTADatos.setFont(new Font("Arial", 0, 16));
        this.JTADatos.setForeground(new Color(0, 0, 0));
        this.JTADatos.setRows(5);
        this.JTADatos.setSelectedTextColor(new Color(0, 0, 0));
        this.jScrollPane1.setViewportView(this.JTADatos);
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("AUTORIZACIÓN DE TRATAMIENTOS DE DATOS PERSONALES SENSIBLES");
        this.jLabel1.setOpaque(true);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, 1342, 32767).addComponent(this.jScrollPane1)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 819, 32767).addContainerGap()));
        this.JBTAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAceptar.setText("ACEPTAR");
        this.JBTAceptar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JDDatosSensibles.1
            public void actionPerformed(ActionEvent evt) {
                JDDatosSensibles.this.JBTAceptarActionPerformed(evt);
            }
        });
        this.JBTRechazar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/equiz rojo.png")));
        this.JBTRechazar.setText("RECHAZAR");
        this.JBTRechazar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JDDatosSensibles.2
            public void actionPerformed(ActionEvent evt) {
                JDDatosSensibles.this.JBTRechazarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JBTAceptar, -2, 197, -2).addGap(18, 18, 18).addComponent(this.JBTRechazar, -2, 177, -2).addGap(456, 456, 456)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTAceptar, -1, -1, 32767).addComponent(this.JBTRechazar, -2, 48, -2)).addGap(12, 12, 12)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAceptarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRechazarActionPerformed(ActionEvent evt) {
        dispose();
    }

    private void cargarAutorizacionInicial() {
        this.JTADatos.setText("Las compañías que conforman el Grupo Empresarial MINEROS S.A., de acuerdo con las facultades y deberes establecidos en Ley 1581 de 2012 y demás normas complementarias, será la responsable del tratamiento de datos personales sensibles y, en tal virtud, podrá recolectar, almacenar, usar, circular o suprimir los datos personales sensibles suministrado y entregados por usted.\n\nManifiesto que me informaron que los datos sensibles que se recolectarán serán utilizados para las siguientes finalidades:\n\nLas historias clínicas, exámenes, resultados diagnósticos, pruebas de laboratorio y datos de la salud de los titulares serán utilizados con los fines pertinentes para el buen desempeño de las funciones a cargo de la Dirección financiera y administrativa, Vicepresidencia de Talento y las áreas de estrategia y desarrollo Organizacional y de Sistema de Gestión de seguridad y salud en el trabajo, evaluar la situación de ingreso y egreso del personal, aptitud, prevención, control, investigaciones y seguimiento a la salud al interior de la compañía.\n\nEmito la presente autorización de manera consciente y expresa para que las compañías que conforman el Grupo empresarial MINEROS S.A., puedan llevar a cabo lo siguiente: i) Realizar reclamaciones a las compañías aseguradoras y empresas de medicina prepagada. ii) Evaluar casos médicos críticos por ausentismo laboral y reintegro laboral, iii) Realizar evaluación y seguimiento a los casos de los programas de vigilancia epidemiológica. iv) Para la aplicación y manejo de la evaluación del riesgo psicosocial. v) Para interactuar con las diferentes entidades del Sistema de Seguridad Social, compañía aseguradoras y entidades con competencia legal de diagnosticar mi estado de salud, la calificación del origen y perdida de capacidad laboral, o en cumplimiento del Decreto 1333 de 2018 o norma vigente. vi) Participar de las investigaciones de enfermedad laboral, vii) acceso o suministro de copia de Historia Clínica Ocupacional y los documentos anexos, e informe a Seguridad y Salud en el Trabajo de mi empresa, al equipo investigador de la enfermedad y a la ARL a la cual me encuentro afiliado. viii) Agilizar los tramites en los procesos asistenciales o de reclamación, así como cualquier requerimiento relacionado con mi estado de salud, que pudieran estar relacionadas y/o agravadas con la exposición a agentes de riesgo laborales con el fin de que sean intervenidos.\n\nManifiesto que me informaron que, en caso de recolectar mi información sensible tengo derecho a contestar o no las preguntas que me formulen y a entregar o no los datos solicitados.\nEntiendo que son datos sensibles aquellos que afectan la intimidad del titular o cuyo uso indebido puede generar discriminación, tales como aquellos que revelen el origen racial o étnico, la orientación política, las convicciones religiosas o filosóficas, la pertenencia a sindicatos, organizaciones sociales, de derechos humanos o que promueva intereses de cualquier partido político o que garanticen los derechos y garantías de partidos políticos de oposición, así como los datos relativos a la salud, a la vida sexual, y los datos biométricos.\n\nDerechos del titular:\n\nLos derechos como titular de los datos son previstos en la Constitución Política y en la Ley 1581 de 2012, especialmente los siguientes: 1) Acceder en forma gratuita a los datos proporcionados que hayan sido objeto de tratamiento. 2) Solicitar la actualización y rectificación de su información frente a datos parciales, inexactos, incompletos, fraccionados, que induzcan al error, o a aquellos cuyo tratamiento este prohibido o no haya sido autorizado. 3) Solicitar prueba de la autorización otorgada. 4) Presentar ante la Superintendencia de Industria y Comercio quejas por infracciones a lo dispuesto en la normativa vigente. 5) Revocar la autorización y/o solicitar la supresión del dato, a menos que exista un deber legal o contractual que haga imperativo conservar la información. 6) Abstenerse de responder las preguntas sobre datos sensibles o sobre datos de los niños y adolescentes.\n\nEstos derechos se podrán ejercer a través de los canales dispuestos por MINEROS S.A.: www.mineros.com.co o en la línea de atención 604 266 57577, correo electrónico gestion.datos@mineros.com.co en la Carrera 43ª # 14-109 Medellín, Antioquia.\n\nLa compañía Mineros S.A., me informó que la historia clínica es un documento que, según el articulo 34 de Ley 23 de 1981, define la historia clínica como “un documento privado sometido a reserva que únicamente puede ser conocido por terceros previa autorización del paciente o en los casos previstos por la Ley”, por lo cual, conociendo esta información, autorizo el tratamiento de datos personales sensibles contemplados en esta.\nPor todo lo anterior, otorgo mi consentimiento a Mineros S.A., para que trate mi información personal de acuerdo con el Manual para el manejo de datos personales dispuesto por la compañía y al que he tenido acceso.\n\nManifiesto que la presente autorización me fue solicitada y puesta presente antes de entregar mis datos sensibles y que la suscribo de forma libre y voluntaria una vez comprendida y leída en su totalidad.\n");
        this.JTADatos.setLineWrap(true);
        this.JTADatos.setWrapStyleWord(true);
        this.JTADatos.setEnabled(false);
    }

    private void grabar() {
        HSoDatosSensibles ds = new HSoDatosSensibles();
        ds.setIdDeclaracion(this.declaracion.getId());
        ds.setIdIngreso(this.idIngreso.longValue());
        ds.setAutorizacion("");
        ds.setFechaCreacion(this.metodos.getFechaActual());
        this.datosSensiblesService.save(ds);
        JOptionPane.showMessageDialog(this, "Autorización aceptada", "ACEPTADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Aceptar30x30.png"))));
        imprimir();
        dispose();
    }

    private void imprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idDeclaracion";
        mparametros[0][1] = String.valueOf(this.declaracion.getId());
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "DatosSensibles", mparametros);
    }

    public void imprimirGuardado(String idDeclaracion) {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idDeclaracion";
        mparametros[0][1] = idDeclaracion;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
        this.metodos.GenerarPDF(this.metodos.getRutaRep() + "DatosSensibles", mparametros);
    }
}
