package Historia;

import Acceso.Principal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDNoPOS.class */
public class JDNoPOS extends JDialog {
    private String xllamador;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JRadioButton JRBSucesivo;
    private JRadioButton JRBUnico;
    private JTextArea JTACasuistca;
    private JTextArea JTACasuistcaPro;
    private JTextArea JTAEvidencia;
    private JTextArea JTAEvidenciaPro;
    private JTextArea JTAFVigilancia;
    private JTextArea JTAFVigilanciaPro;
    private JTextArea JTAJustificacion;
    private JTextArea JTAJustificacionPro;
    private JTextField JTFCantidad;
    private JTextField JTFDias;
    private JTextField JTFNServicio;
    private JTabbedPane JTPJustificacion;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    private JScrollPane jScrollPane8;

    public JDNoPOS(Frame parent, boolean modal, String xllamador, String xv1, String xv2, String xv3, String xv4) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xllamador = xllamador;
        setLocationRelativeTo(null);
        if (this.xllamador.equals("xProcedimientos")) {
            this.JTPJustificacion.remove(0);
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x1 = "Único";
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x4 = "No";
        } else if (this.xllamador.equals("xMedicamentos")) {
            this.JTPJustificacion.remove(1);
            this.JTAJustificacion.setText(clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta() + "\n" + clasesHistoriaCE.informacionAgendaMedicaDTO.getEnfermedadActual() + "\n" + xv1);
            this.JTAEvidencia.setText(xv2);
            this.JTACasuistca.setText(xv3);
            this.JTAFVigilancia.setText(xv4);
        }
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.JTPJustificacion = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTAJustificacion = new JTextArea();
        this.jScrollPane2 = new JScrollPane();
        this.JTAEvidencia = new JTextArea();
        this.jScrollPane3 = new JScrollPane();
        this.JTACasuistca = new JTextArea();
        this.jScrollPane4 = new JScrollPane();
        this.JTAFVigilancia = new JTextArea();
        this.jPanel2 = new JPanel();
        this.JRBUnico = new JRadioButton();
        this.JRBSucesivo = new JRadioButton();
        this.jLabel1 = new JLabel();
        this.JTFCantidad = new JTextField();
        this.JTFDias = new JTextField();
        this.jLabel2 = new JLabel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JTFNServicio = new JTextField();
        this.jScrollPane5 = new JScrollPane();
        this.JTAJustificacionPro = new JTextArea();
        this.jScrollPane6 = new JScrollPane();
        this.JTAEvidenciaPro = new JTextArea();
        this.jScrollPane7 = new JScrollPane();
        this.JTACasuistcaPro = new JTextArea();
        this.jScrollPane8 = new JScrollPane();
        this.JTAFVigilanciaPro = new JTextArea();
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        setDefaultCloseOperation(2);
        this.JTPJustificacion.setForeground(Color.red);
        this.JTPJustificacion.setFont(new Font("Arial", 1, 12));
        this.JTAJustificacion.setColumns(1);
        this.JTAJustificacion.setFont(new Font("Arial", 1, 12));
        this.JTAJustificacion.setLineWrap(true);
        this.JTAJustificacion.setRows(1);
        this.JTAJustificacion.setToolTipText("Escriba Texto");
        this.JTAJustificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Justificación General", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAJustificacion);
        this.JTAEvidencia.setColumns(1);
        this.JTAEvidencia.setFont(new Font("Arial", 1, 12));
        this.JTAEvidencia.setLineWrap(true);
        this.JTAEvidencia.setRows(1);
        this.JTAEvidencia.setToolTipText("Escriba Texto");
        this.JTAEvidencia.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p>Señale la Evidencia Científica  en Casos Similares con  Grado de Recomendación  y Relacione Soporte Científico Bibliográfico</p><html>", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane2.setViewportView(this.JTAEvidencia);
        this.JTACasuistca.setColumns(1);
        this.JTACasuistca.setFont(new Font("Arial", 1, 12));
        this.JTACasuistca.setLineWrap(true);
        this.JTACasuistca.setRows(1);
        this.JTACasuistca.setToolTipText("Escriba Texto");
        this.JTACasuistca.setBorder(BorderFactory.createTitledBorder((Border) null, "Casuistica del Ordenador Sobre el Medicamento Solicitado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane3.setViewportView(this.JTACasuistca);
        this.JTAFVigilancia.setColumns(1);
        this.JTAFVigilancia.setFont(new Font("Arial", 1, 12));
        this.JTAFVigilancia.setLineWrap(true);
        this.JTAFVigilancia.setRows(1);
        this.JTAFVigilancia.setToolTipText("Escriba Texto");
        this.JTAFVigilancia.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p>Señale las precauciones, contraindicaciones, efectos secundarios y toxicidad asociada con el empleo y abuso, del medicamento  NO POS solicitado.</p></html>", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane4.setViewportView(this.JTAFVigilancia);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -2, 456, -2).addComponent(this.jScrollPane2, -2, 456, -2).addComponent(this.jScrollPane3, -2, 456, -2)).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jScrollPane4, -2, 456, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.jScrollPane1, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane4, -2, 115, -2).addContainerGap(13, 32767)));
        this.JTPJustificacion.addTab("Justificación Medicamentos No POS", this.jPanel1);
        this.buttonGroup1.add(this.JRBUnico);
        this.JRBUnico.setFont(new Font("Arial", 1, 12));
        this.JRBUnico.setSelected(true);
        this.JRBUnico.setText("Único");
        this.JRBUnico.addActionListener(new ActionListener() { // from class: Historia.JDNoPOS.1
            public void actionPerformed(ActionEvent evt) {
                JDNoPOS.this.JRBUnicoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBSucesivo);
        this.JRBSucesivo.setFont(new Font("Arial", 1, 12));
        this.JRBSucesivo.setText("Sucesivo");
        this.JRBSucesivo.addActionListener(new ActionListener() { // from class: Historia.JDNoPOS.2
            public void actionPerformed(ActionEvent evt) {
                JDNoPOS.this.JRBSucesivoActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Carácter del Servicio");
        this.JTFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad Tratamiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCantidad.setEnabled(false);
        this.JTFDias.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias Tratamiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFDias.setEnabled(false);
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Homologo");
        this.buttonGroup2.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JDNoPOS.3
            public void actionPerformed(ActionEvent evt) {
                JDNoPOS.this.JRBSiActionPerformed(evt);
            }
        });
        this.buttonGroup2.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JDNoPOS.4
            public void actionPerformed(ActionEvent evt) {
                JDNoPOS.this.JRBNoActionPerformed(evt);
            }
        });
        this.JTFNServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre del Servicio que se Reemplaza o Sustituye", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAJustificacionPro.setColumns(1);
        this.JTAJustificacionPro.setFont(new Font("Arial", 1, 12));
        this.JTAJustificacionPro.setLineWrap(true);
        this.JTAJustificacionPro.setRows(1);
        this.JTAJustificacionPro.setToolTipText("Escriba Texto");
        this.JTAJustificacionPro.setBorder(BorderFactory.createTitledBorder((Border) null, "Justificación de la Solicitud:", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane5.setViewportView(this.JTAJustificacionPro);
        this.JTAEvidenciaPro.setColumns(1);
        this.JTAEvidenciaPro.setFont(new Font("Arial", 1, 12));
        this.JTAEvidenciaPro.setLineWrap(true);
        this.JTAEvidenciaPro.setRows(1);
        this.JTAEvidenciaPro.setToolTipText("Escriba Texto");
        this.JTAEvidenciaPro.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p>Señale la Evidencia Científica  en Casos Similares con  Grado de Recomendación  y Relacione Soporte Científico Bibliográfico</p><html>", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane6.setViewportView(this.JTAEvidenciaPro);
        this.JTACasuistcaPro.setColumns(1);
        this.JTACasuistcaPro.setFont(new Font("Arial", 1, 12));
        this.JTACasuistcaPro.setLineWrap(true);
        this.JTACasuistcaPro.setRows(1);
        this.JTACasuistcaPro.setToolTipText("Escriba Texto");
        this.JTACasuistcaPro.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p>Casuistica del Ordenador Sobre el Procedimiento , Actividad o Intervención Solicitado</p></html>", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane7.setViewportView(this.JTACasuistcaPro);
        this.JTAFVigilanciaPro.setColumns(1);
        this.JTAFVigilanciaPro.setFont(new Font("Arial", 1, 12));
        this.JTAFVigilanciaPro.setLineWrap(true);
        this.JTAFVigilanciaPro.setRows(1);
        this.JTAFVigilanciaPro.setToolTipText("Escriba Texto");
        this.JTAFVigilanciaPro.setBorder(BorderFactory.createTitledBorder((Border) null, "<html><p> Señale las precauciones, contraindicaciones, efectos secundarios y toxicidad asociada con el empleo y abuso, del  servicio NO POS solicitado.</p></html>", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane8.setViewportView(this.JTAFVigilanciaPro);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNServicio).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFCantidad, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDias, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane5, -2, 456, -2).addComponent(this.jScrollPane6, -2, 456, -2).addComponent(this.jScrollPane7, -2, 456, -2).addComponent(this.jScrollPane8, GroupLayout.Alignment.TRAILING, -2, 456, -2))).addGap(0, 0, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBUnico).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSucesivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.JRBUnico).addComponent(this.JRBSucesivo)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCantidad, -2, 50, -2).addComponent(this.JTFDias, -2, 50, -2)).addGap(3, 3, 3).addComponent(this.JTFNServicio, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane5, -2, 56, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane6, -2, 74, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane7, -2, -1, -2).addGap(4, 4, 4).addComponent(this.jScrollPane8, -2, 96, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.JRBSi).addComponent(this.JRBNo))).addContainerGap()));
        this.JTPJustificacion.addTab("Justificación de Servicios No POS", this.jPanel2);
        this.jButton1.setFont(new Font("Arial", 1, 12));
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.jButton1.setText("SALIR");
        this.jButton1.addActionListener(new ActionListener() { // from class: Historia.JDNoPOS.5
            public void actionPerformed(ActionEvent evt) {
                JDNoPOS.this.jButton1ActionPerformed(evt);
            }
        });
        this.jButton2.setFont(new Font("Arial", 1, 12));
        this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.jButton2.setText("GRABAR");
        this.jButton2.addActionListener(new ActionListener() { // from class: Historia.JDNoPOS.6
            public void actionPerformed(ActionEvent evt) {
                JDNoPOS.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPJustificacion).addGroup(layout.createSequentialGroup().addComponent(this.jButton2, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1, -2, 219, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JTPJustificacion, -2, 477, -2).addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1, -2, 33, -2).addComponent(this.jButton2)).addGap(3, 3, 3)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        mIniciar();
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUnicoActionPerformed(ActionEvent evt) {
        Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x1 = "Único";
        this.JTFCantidad.setEnabled(false);
        this.JTFDias.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSucesivoActionPerformed(ActionEvent evt) {
        Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x1 = "Sucesivo";
        this.JTFCantidad.setEnabled(true);
        this.JTFDias.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x4 = "Si";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x4 = "No";
    }

    private void mIniciar() {
        if (this.xllamador.equals("xMedicamentos")) {
            Principal.clasehistoriace.xjifhistoriaclinica.xjpsuministroh.x1 = this.JTAJustificacion.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpsuministroh.x2 = this.JTAEvidencia.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpsuministroh.x3 = this.JTACasuistca.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpsuministroh.x4 = this.JTAFVigilancia.getText();
            return;
        }
        if (this.xllamador.equals("xProcedimientos")) {
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x2 = this.JTFCantidad.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x3 = this.JTFDias.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x5 = this.JTFNServicio.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x6 = this.JTAJustificacionPro.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x7 = this.JTAEvidenciaPro.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x8 = this.JTACasuistcaPro.getText();
            Principal.clasehistoriace.xjifhistoriaclinica.xjpprocedimientosh.x9 = this.JTAFVigilanciaPro.getText();
        }
    }
}
