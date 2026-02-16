package Salud_Ocupacional;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.HSoDeclaracionSalud;
import com.genoma.plus.jpa.service.HSoDeclaracionSaludService;
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

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/JDAccederDeclaracionSalud.class */
public class JDAccederDeclaracionSalud extends JDialog {
    private HSoDeclaracionSalud declaracionSalud;
    private final HSoDeclaracionSaludService declaracionSaludService;
    private JIFDeclaracionSalud frmDeclaracionSalud;
    private Metodos metodos;
    String cargo;
    String nombre;
    String numeroDoc;
    String ciudad;
    String lugarDoc;
    Integer ingreso;
    private JButton JBTAceptar;
    private JButton JBTRechazar;
    private JTextArea JTADatos;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDAccederDeclaracionSalud(Frame parent, boolean modal, JIFDeclaracionSalud declaracion, String cargo, String nombre, String numeroDoc, String ciudad, Integer ingreso) {
        super(parent, modal);
        this.metodos = new Metodos();
        initComponents();
        this.declaracionSalud = new HSoDeclaracionSalud();
        this.declaracionSaludService = (HSoDeclaracionSaludService) Principal.contexto.getBean(HSoDeclaracionSaludService.class);
        this.cargo = cargo;
        this.nombre = nombre;
        this.numeroDoc = numeroDoc;
        this.ciudad = ciudad;
        this.ingreso = ingreso;
        cargarDeclaracion();
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
        this.JTADatos.setFont(new Font("Arial", 3, 16));
        this.JTADatos.setRows(5);
        this.jScrollPane1.setViewportView(this.JTADatos);
        this.jLabel1.setBackground(new Color(0, 0, 153));
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(255, 255, 255));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Declaración de condición y antecedentes de salud");
        this.jLabel1.setOpaque(true);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 910, -2).addGap(0, 0, 32767)).addComponent(this.jLabel1, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 547, 32767).addContainerGap()));
        this.JBTAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAceptar.setText("ACEPTAR");
        this.JBTAceptar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JDAccederDeclaracionSalud.1
            public void actionPerformed(ActionEvent evt) {
                JDAccederDeclaracionSalud.this.JBTAceptarActionPerformed(evt);
            }
        });
        this.JBTRechazar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/equiz rojo.png")));
        this.JBTRechazar.setText("RECHAZAR");
        this.JBTRechazar.addActionListener(new ActionListener() { // from class: Salud_Ocupacional.JDAccederDeclaracionSalud.2
            public void actionPerformed(ActionEvent evt) {
                JDAccederDeclaracionSalud.this.JBTRechazarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(218, 218, 218).addComponent(this.JBTAceptar, -2, 197, -2).addGap(18, 18, 18).addComponent(this.JBTRechazar, -2, 177, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTAceptar, -1, -1, 32767).addComponent(this.JBTRechazar, -2, 48, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAceptarActionPerformed(ActionEvent evt) {
        System.out.println(this.JTADatos.getText());
        try {
            Principal.txtNo.setText(this.ingreso.toString());
            HSoDeclaracionSalud ds = new HSoDeclaracionSalud();
            ds.setIdIngreso(this.ingreso.intValue());
            ds.setDeclaracion(this.JTADatos.getText());
            ds.setFechaCreacion(this.metodos.getFechaActual());
            ds.setFechaActualizacion(this.metodos.getFechaActual());
            JIFDeclaracionSalud d = new JIFDeclaracionSalud();
            this.declaracionSaludService.save(ds);
            d.recibirIngresoDeclaracion(Long.valueOf(Long.parseLong(this.ingreso.toString())), ds.getId());
            dispose();
            JOptionPane.showMessageDialog(this, "Acuerdo aceptado", "ACEPTADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Aceptar30x30.png"))));
            new HSoDeclaracionSalud();
            this.declaracionSaludService.findByIdIngreso(Long.valueOf(this.ingreso.intValue()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTRechazarActionPerformed(ActionEvent evt) {
        consultarDeclaracionPorIngreso();
        dispose();
    }

    private void cargarDeclaracion() {
        String declaracionSalud = "Ciudad: " + this.ciudad + "\nFecha: " + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "\n\nSeñores\nMINEROS ALUVIAL S.A.S. BIC\nSalud Empresarial\nE.S.M.\n\nAsunto: Declaración, autorización y uso de la información contenida en la historia clínica.\n\nEn pleno uso de mis facultades, de forma libre, informada y voluntariamente, yo " + this.nombre + ", identificado(a) con el documento de identidad(C-C., C.E., T.I.) número " + this.numeroDoc + " autorizo al Medico especialista designado por la empresa Mineros Aluvial S.A.S. BIC, quien cumple con los requisitos de la licencia de Salud Ocupacional, para que conozca la información suministrada en la presente encuesta y, tenga acceso a mi historia clínica, de acuerdo con lo establecido en la Ley 23 de 1981, Resolución 2346 de 2007, Resolución 1995 de 1999, Resolución 4502 de 2012, Resolución 2569 de 1999, Decreto Ley 19 de 2012, y la Resolución 1918 del 2009 del Ministerio de Salud y Protección Social, y a todas las normas vigentes que regulen en Colombia, el uso, acceso, consulta y custodia de las historias clínicas, con el fin de que analicen si mi condición de salud y antecedentes de enfermedades, me permiten cumplir cabalmente con el cargo " + this.cargo + " y no me expone a exacerbar un padecimiento por los riesgos del trabajo a los que estaría expuesto(a), acorde con los requerimientos de la tarea y con el perfil del cargo " + this.cargo + " al cual estoy aspirando desempeñar, según el proceso de selección en el que me encuentro participando actualmente.\nDeclaro que he recibido en forma clara y precisa, la información relacionada con el perfil del cargo, las tareas de este, el frente de trabajo, la zona geográfica, los medios en los cuales se desarrollaría la labor y en general de todos sus riesgos asociados.";
        this.JTADatos.setText(declaracionSalud);
        this.JTADatos.setLineWrap(true);
        this.JTADatos.setWrapStyleWord(true);
        this.JTADatos.setEnabled(false);
    }

    private void consultarDeclaracionPorIngreso() {
        new HSoDeclaracionSalud();
        HSoDeclaracionSalud d = this.declaracionSaludService.findByIdIngreso(Long.valueOf(Long.parseLong(this.ingreso.toString())));
        Principal.txtNo.setText(d.getId().toString());
    }
}
