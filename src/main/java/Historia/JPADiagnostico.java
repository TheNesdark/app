package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPADiagnostico.class */
public class JPADiagnostico extends JPanel {
    private String[] idtipodx;
    private clasesHistoriaCE xclase;
    private String x_NAtencion;
    private String xIngreso;
    public boolean nDiagnostico;
    private ButtonGroup JBGSalida;
    private JButton JBTGuardar;
    private JComboBox JCBTipoDx;
    private JLabel JLBTDxRelacionados;
    private JPanel JPIConclusion;
    private JPanel JPIConclusionAtencion;
    private JPanel JPIDxConclusion;
    private JPanel JPI_Destino;
    private JRadioButton JRBContraremision;
    private JRadioButton JRBDomicilio;
    private JRadioButton JRBInternacion;
    private JRadioButton JRBObservacion;
    private JRadioButton JRBOtro;
    private JRadioButton JRBRemision;
    private JScrollPane JSPEor;
    public JTextField JTFCDxP;
    private JTextField JTFCDxR1;
    private JTextField JTFCDxR2;
    private JTextField JTFCDxR3;
    public JTextField JTFNCodigoDxP;
    private JTextField JTFNDxR1;
    private JTextField JTFNDxR2;
    private JTextField JTFNDxR3;
    private JTextPane JTPConclusion;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xDestino = -1;

    public JPADiagnostico(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        this.x_NAtencion = "";
        mResetForm();
        this.x_NAtencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        this.xIngreso = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString();
        this.idtipodx = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tipodiagnostico ORDER BY Nbre ASC", this.idtipodx, this.JCBTipoDx);
        this.JCBTipoDx.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        mBuscarDatosBd();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
            this.JPI_Destino.setVisible(false);
            this.JPIConclusionAtencion.setVisible(false);
        } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            this.JPIConclusionAtencion.setVisible(false);
        } else {
            this.JBTGuardar.setVisible(true);
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            this.JRBOtro.setVisible(false);
        }
        if (!this.JTPConclusion.getText().isEmpty() && this.JTPConclusion.getText() != null && this.xDestino != -1 && this.JCBTipoDx.getSelectedIndex() != -1 && !this.JTFNCodigoDxP.getText().isEmpty() && !this.JTFCDxP.getText().isEmpty()) {
            this.nDiagnostico = true;
        } else {
            this.nDiagnostico = false;
        }
    }

    public JPADiagnostico(String xid_Atencion) {
        initComponents();
        this.x_NAtencion = "";
        mResetForm();
        this.x_NAtencion = xid_Atencion;
        this.idtipodx = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM h_tipodiagnostico ORDER BY Nbre ASC", this.idtipodx, this.JCBTipoDx);
        this.JCBTipoDx.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        mBuscarDatosBd();
        this.JBTGuardar.setEnabled(false);
    }

    private void initComponents() {
        this.JBGSalida = new ButtonGroup();
        this.JPIConclusion = new JPanel();
        this.JPIDxConclusion = new JPanel();
        this.JCBTipoDx = new JComboBox();
        this.JTFCDxR1 = new JTextField();
        this.JTFNDxR1 = new JTextField();
        this.JLBTDxRelacionados = new JLabel();
        this.JTFCDxR2 = new JTextField();
        this.JTFNDxR2 = new JTextField();
        this.JTFCDxR3 = new JTextField();
        this.JTFNDxR3 = new JTextField();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JPIConclusionAtencion = new JPanel();
        this.JSPEor = new JScrollPane();
        this.JTPConclusion = new JTextPane();
        this.JPI_Destino = new JPanel();
        this.JRBDomicilio = new JRadioButton();
        this.JRBInternacion = new JRadioButton();
        this.JRBContraremision = new JRadioButton();
        this.JRBObservacion = new JRadioButton();
        this.JRBRemision = new JRadioButton();
        this.JRBOtro = new JRadioButton();
        this.JBTGuardar = new JButton();
        setName("jpconclusiones");
        addAncestorListener(new AncestorListener() { // from class: Historia.JPADiagnostico.1
            public void ancestorAdded(AncestorEvent evt) {
                JPADiagnostico.this.formAncestorAdded(evt);
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPADiagnostico.this.formAncestorRemoved(evt);
            }

            public void ancestorMoved(AncestorEvent evt) {
            }
        });
        addMouseListener(new MouseAdapter() { // from class: Historia.JPADiagnostico.2
            public void mouseExited(MouseEvent evt) {
                JPADiagnostico.this.formMouseExited(evt);
            }
        });
        this.JPIDxConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "DIAGNÓSTICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Dx", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoDx.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.3
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JCBTipoDxKeyPressed(evt);
            }
        });
        this.JTFCDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR1.addFocusListener(new FocusAdapter() { // from class: Historia.JPADiagnostico.4
            public void focusLost(FocusEvent evt) {
                JPADiagnostico.this.JTFCDxR1FocusLost(evt);
            }
        });
        this.JTFCDxR1.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.5
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFCDxR1KeyPressed(evt);
            }
        });
        this.JTFNDxR1.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR1.addMouseListener(new MouseAdapter() { // from class: Historia.JPADiagnostico.6
            public void mouseClicked(MouseEvent evt) {
                JPADiagnostico.this.JTFNDxR1MouseClicked(evt);
            }
        });
        this.JTFNDxR1.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.7
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFNDxR1KeyPressed(evt);
            }
        });
        this.JLBTDxRelacionados.setBackground(new Color(0, 0, 153));
        this.JLBTDxRelacionados.setFont(new Font("Bell MT", 1, 14));
        this.JLBTDxRelacionados.setForeground(new Color(204, 255, 255));
        this.JLBTDxRelacionados.setHorizontalAlignment(0);
        this.JLBTDxRelacionados.setText("Diagnosticos Relacionados");
        this.JLBTDxRelacionados.setBorder(new SoftBevelBorder(0));
        this.JLBTDxRelacionados.setOpaque(true);
        this.JTFCDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR2.addFocusListener(new FocusAdapter() { // from class: Historia.JPADiagnostico.8
            public void focusLost(FocusEvent evt) {
                JPADiagnostico.this.JTFCDxR2FocusLost(evt);
            }
        });
        this.JTFCDxR2.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.9
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFCDxR2KeyPressed(evt);
            }
        });
        this.JTFNDxR2.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR2.addMouseListener(new MouseAdapter() { // from class: Historia.JPADiagnostico.10
            public void mouseClicked(MouseEvent evt) {
                JPADiagnostico.this.JTFNDxR2MouseClicked(evt);
            }
        });
        this.JTFNDxR2.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.11
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFNDxR2KeyPressed(evt);
            }
        });
        this.JTFCDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFCDxR3.addFocusListener(new FocusAdapter() { // from class: Historia.JPADiagnostico.12
            public void focusLost(FocusEvent evt) {
                JPADiagnostico.this.JTFCDxR3FocusLost(evt);
            }
        });
        this.JTFCDxR3.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.13
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFCDxR3KeyPressed(evt);
            }
        });
        this.JTFNDxR3.setFont(new Font("Arial", 1, 12));
        this.JTFNDxR3.addMouseListener(new MouseAdapter() { // from class: Historia.JPADiagnostico.14
            public void mouseClicked(MouseEvent evt) {
                JPADiagnostico.this.JTFNDxR3MouseClicked(evt);
            }
        });
        this.JTFNDxR3.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.15
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFNDxR3KeyPressed(evt);
            }
        });
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPADiagnostico.16
            public void focusLost(FocusEvent evt) {
                JPADiagnostico.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.17
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPADiagnostico.18
            public void mouseClicked(MouseEvent evt) {
                JPADiagnostico.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.19
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        GroupLayout JPIDxConclusionLayout = new GroupLayout(this.JPIDxConclusion);
        this.JPIDxConclusion.setLayout(JPIDxConclusionLayout);
        JPIDxConclusionLayout.setHorizontalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addContainerGap().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBTDxRelacionados, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIDxConclusionLayout.createSequentialGroup().addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFCDxR3, -2, 64, -2).addComponent(this.JTFCDxR2, -2, 64, -2).addComponent(this.JTFCDxR1, -2, 64, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFNDxR2, GroupLayout.Alignment.LEADING, -2, 677, -2).addComponent(this.JTFNDxR3, -2, 677, -2).addComponent(this.JTFNDxR1, GroupLayout.Alignment.LEADING, -2, 677, -2)))).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDxConclusionLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JTFCDxP, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 393, -2).addGap(18, 18, 18).addComponent(this.JCBTipoDx, -2, 209, -2).addContainerGap()))));
        JPIDxConclusionLayout.setVerticalGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDxConclusionLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, 40, -2).addComponent(this.JTFNCodigoDxP, -2, 40, -2).addComponent(this.JCBTipoDx, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBTDxRelacionados, -2, 15, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR1, -2, 30, -2).addComponent(this.JTFCDxR1, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR2, -2, 30, -2).addComponent(this.JTFCDxR2, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDxConclusionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDxR3, -2, 30, -2).addComponent(this.JTFCDxR3, -2, 30, -2)).addContainerGap(-1, 32767)));
        this.JPIConclusionAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "OBSERVACION", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPConclusion.setFont(new Font("Arial", 1, 12));
        this.JTPConclusion.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.20
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JTPConclusionKeyPressed(evt);
            }
        });
        this.JSPEor.setViewportView(this.JTPConclusion);
        GroupLayout JPIConclusionAtencionLayout = new GroupLayout(this.JPIConclusionAtencion);
        this.JPIConclusionAtencion.setLayout(JPIConclusionAtencionLayout);
        JPIConclusionAtencionLayout.setHorizontalGroup(JPIConclusionAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConclusionAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPEor, -2, 746, -2).addContainerGap(-1, 32767)));
        JPIConclusionAtencionLayout.setVerticalGroup(JPIConclusionAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConclusionAtencionLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JSPEor, -1, 136, 32767).addGap(3, 3, 3)));
        this.JPI_Destino.setBorder(BorderFactory.createTitledBorder((Border) null, "Destino del Paciente", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGSalida.add(this.JRBDomicilio);
        this.JRBDomicilio.setFont(new Font("Arial", 1, 12));
        this.JRBDomicilio.setText("Domicilio");
        this.JRBDomicilio.addActionListener(new ActionListener() { // from class: Historia.JPADiagnostico.21
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JRBDomicilioActionPerformed(evt);
            }
        });
        this.JBGSalida.add(this.JRBInternacion);
        this.JRBInternacion.setFont(new Font("Arial", 1, 12));
        this.JRBInternacion.setText("Internación");
        this.JRBInternacion.addActionListener(new ActionListener() { // from class: Historia.JPADiagnostico.22
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JRBInternacionActionPerformed(evt);
            }
        });
        this.JBGSalida.add(this.JRBContraremision);
        this.JRBContraremision.setFont(new Font("Arial", 1, 12));
        this.JRBContraremision.setText("Contrarremisión");
        this.JRBContraremision.addActionListener(new ActionListener() { // from class: Historia.JPADiagnostico.23
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JRBContraremisionActionPerformed(evt);
            }
        });
        this.JBGSalida.add(this.JRBObservacion);
        this.JRBObservacion.setFont(new Font("Arial", 1, 12));
        this.JRBObservacion.setText("Observación");
        this.JRBObservacion.addActionListener(new ActionListener() { // from class: Historia.JPADiagnostico.24
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JRBObservacionActionPerformed(evt);
            }
        });
        this.JBGSalida.add(this.JRBRemision);
        this.JRBRemision.setFont(new Font("Arial", 1, 12));
        this.JRBRemision.setText("Remisión");
        this.JRBRemision.addActionListener(new ActionListener() { // from class: Historia.JPADiagnostico.25
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JRBRemisionActionPerformed(evt);
            }
        });
        this.JBGSalida.add(this.JRBOtro);
        this.JRBOtro.setFont(new Font("Arial", 1, 12));
        this.JRBOtro.setText("Otro");
        this.JRBOtro.addActionListener(new ActionListener() { // from class: Historia.JPADiagnostico.26
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JRBOtroActionPerformed(evt);
            }
        });
        GroupLayout JPI_DestinoLayout = new GroupLayout(this.JPI_Destino);
        this.JPI_Destino.setLayout(JPI_DestinoLayout);
        JPI_DestinoLayout.setHorizontalGroup(JPI_DestinoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DestinoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDomicilio).addGap(26, 26, 26).addComponent(this.JRBInternacion).addGap(18, 18, 18).addComponent(this.JRBContraremision).addGap(18, 18, 18).addComponent(this.JRBObservacion).addGap(18, 18, 18).addComponent(this.JRBRemision).addGap(27, 27, 27).addComponent(this.JRBOtro).addContainerGap(-1, 32767)));
        JPI_DestinoLayout.setVerticalGroup(JPI_DestinoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DestinoLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPI_DestinoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBInternacion).addComponent(this.JRBDomicilio).addComponent(this.JRBContraremision).addComponent(this.JRBObservacion).addComponent(this.JRBRemision).addComponent(this.JRBOtro)).addGap(3, 3, 3)));
        GroupLayout JPIConclusionLayout = new GroupLayout(this.JPIConclusion);
        this.JPIConclusion.setLayout(JPIConclusionLayout);
        JPIConclusionLayout.setHorizontalGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConclusionLayout.createSequentialGroup().addContainerGap().addGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIConclusionAtencion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDxConclusion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPI_Destino, -1, -1, 32767)).addContainerGap()));
        JPIConclusionLayout.setVerticalGroup(JPIConclusionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIConclusionLayout.createSequentialGroup().addComponent(this.JPIDxConclusion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIConclusionAtencion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Destino, -2, -1, -2).addGap(3, 3, 3)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPADiagnostico.27
            public void actionPerformed(ActionEvent evt) {
                JPADiagnostico.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JPADiagnostico.28
            public void keyPressed(KeyEvent evt) {
                JPADiagnostico.this.JBTGuardarKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIConclusion, -1, -1, 32767).addComponent(this.JBTGuardar, -1, -1, 32767)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIConclusion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -1, 40, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        if (this.xclase.xjifhistoriaclinica != null) {
            this.xclase.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        } else if (this.xclase.historia_Clinica_v4 != null) {
            this.xclase.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v4);
        } else if (this.xclase.historia_Clinica_v2 != null) {
            this.xclase.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v2);
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA")) {
            if (this.JTFCDxP.getText().startsWith("Z") || this.JTFCDxP.getText().startsWith("R")) {
                JOptionPane.showInternalMessageDialog(this, "Diagnóstico principal no puede ser (Z) o (R)", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFCDxP.setText("");
                this.JTFNCodigoDxP.setText("");
                this.JTFCDxP.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        this.xclase.buscarPatologiaNombre(this.JTFCDxP, this.JTFNCodigoDxP, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1FocusLost(FocusEvent evt) {
        if (this.xclase.xjifhistoriaclinica != null) {
            this.xclase.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        } else if (this.xclase.historia_Clinica_v4 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v4);
        } else if (this.xclase.historia_Clinica_v2 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR1, this.JTFNDxR1, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2FocusLost(FocusEvent evt) {
        if (this.xclase.xjifhistoriaclinica != null) {
            this.xclase.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        } else if (this.xclase.historia_Clinica_v4 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v4);
        } else if (this.xclase.historia_Clinica_v2 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR2, this.JTFNDxR2, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3FocusLost(FocusEvent evt) {
        this.xclase.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 3, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        if (this.xclase.xjifhistoriaclinica != null) {
            this.xclase.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.xjifhistoriaclinica);
        } else if (this.xclase.historia_Clinica_v4 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v4);
        } else if (this.xclase.historia_Clinica_v2 != null) {
            this.xclase.buscarPatologias(this.JTFCDxR3, this.JTFNDxR3, 0, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), this.xclase.historia_Clinica_v2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1MouseClicked(MouseEvent evt) {
        this.xclase.buscarPatologiaNombre(this.JTFCDxR1, this.JTFNDxR1, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2MouseClicked(MouseEvent evt) {
        this.xclase.buscarPatologiaNombre(this.JTFCDxR2, this.JTFNDxR2, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3MouseClicked(MouseEvent evt) {
        this.xclase.buscarPatologiaNombre(this.JTFCDxR3, this.JTFNDxR3, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getIdentificacion().equals("812000317") || (Principal.informacionIps.getIdentificacion().equals("812001579") && this.JTPConclusion.getText().length() < 100)) {
            JOptionPane.showInternalMessageDialog(this, "La observación debe tener mínimo 100 caracteres", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDxKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoDx.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR1KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR1.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR2KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR2.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNDxR3KeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNDxR3.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPConclusionKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPConclusion.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
            this.JBTGuardar.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        if (!this.JBTGuardar.isEnabled() || this.JTFCDxP.getText().isEmpty() || this.JTFNCodigoDxP.getText().isEmpty() || this.JCBTipoDx.getSelectedIndex() == -1) {
            return;
        }
        mAlmacenarBDTmp();
        this.xclase.mActualizarDx_Ingreso(this.JTFCDxP.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDomicilioActionPerformed(ActionEvent evt) {
        this.xDestino = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBInternacionActionPerformed(ActionEvent evt) {
        this.xDestino = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBContraremisionActionPerformed(ActionEvent evt) {
        this.xDestino = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBObservacionActionPerformed(ActionEvent evt) {
        this.xDestino = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRemisionActionPerformed(ActionEvent evt) {
        this.xDestino = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOtroActionPerformed(ActionEvent evt) {
        this.xDestino = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseExited(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorAdded(AncestorEvent evt) {
        mBuscarDatosBd();
    }

    private void mResetForm() {
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JCBTipoDx.setSelectedItem("");
        this.JTFCDxR1.setText("");
        this.JTFNDxR1.setText("");
        this.JTFCDxR2.setText("");
        this.JTFNDxR2.setText("");
        this.JTFCDxR3.setText("");
        this.JTFNDxR3.setText("");
        this.JTPConclusion.setText("");
    }

    public void mGrabarBd() {
        if (this.JBTGuardar.isEnabled()) {
            if (!this.JTFCDxP.getText().isEmpty()) {
                if (!this.JTFNCodigoDxP.getText().isEmpty()) {
                    if (this.JCBTipoDx.getSelectedIndex() != -1) {
                        if (this.xDestino != -1) {
                            if ("812005644".equals(Principal.informacionIps.getIdentificacion()) || "812003851".equals(Principal.informacionIps.getIdentificacion()) || "EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA".equals(Principal.informacionIps.getNombreIps())) {
                                if (validacionRevisionsistemas()) {
                                    mAlmacenarBDTmp();
                                    this.xclase.mActualizarDx_Ingreso(this.JTFCDxP.getText());
                                    this.xclase.mCambiarEstadoHc(2);
                                    this.xclase.mCambiarEstadoOrdenProcedimiento(2);
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Falta registro de revisión por sistemas", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                }
                            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
                                mAlmacenarBDTmp();
                                this.xclase.mActualizarDx_Ingreso(this.JTFCDxP.getText());
                                this.xclase.mCambiarEstadoHc(2);
                                this.xclase.mCambiarEstadoOrdenProcedimiento(2);
                            } else if (!this.JTPConclusion.getText().isEmpty() && this.JTPConclusion.getText() != null) {
                                mAlmacenarBDTmp();
                                this.xclase.mActualizarDx_Ingreso(this.JTFCDxP.getText());
                                this.xclase.mCambiarEstadoHc(2);
                                this.xclase.mCambiarEstadoOrdenProcedimiento(2);
                            } else {
                                JOptionPane.showMessageDialog(this, "Falta la observacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            }
                            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
                            this.nDiagnostico = true;
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un destiono del paciente", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBTipoDx.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar \n un tipo de Dx", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoDx.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El nombre Dx principal no \n puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNCodigoDxP.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El codigo Dx principal no \n puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.requestFocus();
        }
    }

    private boolean validacionExamenFisico() {
        boolean estado = false;
        try {
            String sql = "select h_examenfisico_detalle.Id\nfrom h_examenfisico_detalle\ninner join h_examenfisico on (h_examenfisico.Id=h_examenfisico_detalle.Id_ExamenFisico\u0000\u0000)\nwhere  h_examenfisico.Id_Atencion =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "\nGROUP by h_examenfisico.Id";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.first();
                estado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPADiagnostico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }

    private boolean validacionRevisionsistemas() {
        boolean estado = false;
        try {
            String sql = "SELECT\n    `h_tiposistemas`.`Nbre`\n    , ifnull(`h_detallerevisionsistemas`.`Descripcion`, '')Descripcion   \n    , `h_detallerevisionsistemas`.`Id_TipoSistemas`\n    , `h_detallerevisionsistemas`.`Id_RevisionSistemas`, `h_tiposistemas`.`VDefecto`\n    , `Valor`    , IFNULL(`h_revisionsistemas`.`Observacion`,'') Observacion\n FROM\n     `h_detallerevisionsistemas`\n    INNER JOIN  `h_revisionsistemas` \n        ON (`h_detallerevisionsistemas`.`Id_RevisionSistemas` = `h_revisionsistemas`.`Id`)\n    INNER JOIN  `h_tiposistemas` \n        ON (`h_detallerevisionsistemas`.`Id_TipoSistemas` = `h_tiposistemas`.`Id`)\n    INNER JOIN  `h_gruposistemas` \n        ON (`h_tiposistemas`.`Id_GrupoSistemas` = `h_gruposistemas`.`Id`)\nWHERE (`h_revisionsistemas`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')\ngroup by h_revisionsistemas.Id  ORDER BY `h_tiposistemas`.`Orden` ASC ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.first();
                estado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPADiagnostico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return estado;
    }

    public void mAlmacenarBDTmp() {
        if (this.JBTGuardar.isEnabled()) {
            String sql = "update h_atencion set  Codigo_Dxp='" + this.JTFCDxP.getText() + "', Id_TipoDx='" + this.idtipodx[this.JCBTipoDx.getSelectedIndex()] + "', Codigo_DxR1='" + this.JTFCDxR1.getText() + "', Codigo_DxR2='" + this.JTFCDxR2.getText() + "', Codigo_DxR3='" + this.JTFCDxR3.getText() + "', Conclusion='" + this.JTPConclusion.getText() + "', DestinoP='" + this.xDestino + "', Estado='0', Fecha='" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
            String sql2 = "delete from h_atenciondx where Id_Atencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
            this.xconsultasbd.ejecutarSQL(sql2);
            this.xconsultasbd.cerrarConexionBd();
            if (!this.JTFCDxP.getText().isEmpty()) {
                String sql3 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxP.getText() + "','1')";
                this.xconsultasbd.ejecutarSQL(sql3);
                this.xconsultasbd.cerrarConexionBd();
            }
            if (!this.JTFCDxR1.getText().isEmpty()) {
                String sql4 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR1.getText() + "','2')";
                this.xconsultasbd.ejecutarSQL(sql4);
                this.xconsultasbd.cerrarConexionBd();
            }
            if (!this.JTFCDxR2.getText().isEmpty()) {
                String sql5 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR2.getText() + "','3')";
                this.xconsultasbd.ejecutarSQL(sql5);
                this.xconsultasbd.cerrarConexionBd();
            }
            if (!this.JTFCDxR3.getText().isEmpty()) {
                String sql6 = "insert ignore into h_atenciondx (Id_Atencion, Id_Dx, Orden ) values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCDxR3.getText() + "','4')";
                this.xconsultasbd.ejecutarSQL(sql6);
                this.xconsultasbd.cerrarConexionBd();
            }
        }
    }

    private void mBuscarDatosBd() {
        try {
            String sql = "SELECT h_atencion.Codigo_Dxp, g_patologia.Nbre, h_tipodiagnostico.Nbre, h_atencion.Codigo_DxR1, h_atencion.Codigo_DxR2, h_atencion.Codigo_DxR3, h_atencion.Conclusion, h_atencion.Recomendaciones, h_atencion.TipoGuardado, h_atencion.DestinoP FROM h_atencion INNER JOIN h_tipodiagnostico  ON (h_atencion.Id_TipoDx = h_tipodiagnostico.Id) INNER JOIN g_patologia ON (g_patologia.Id = h_atencion.Codigo_Dxp)  WHERE h_atencion.Id='" + this.x_NAtencion + "'";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JTFCDxP.setText(xrs.getString(1));
                this.JTFNCodigoDxP.setText(xrs.getString(2));
                this.JCBTipoDx.setSelectedItem(xrs.getString(3));
                this.JTFCDxR1.setText(xrs.getString(4));
                this.JTFNDxR1.setText(mBuscarPatologias(xrs.getString(4)));
                this.JTFCDxR2.setText(xrs.getString(5));
                this.JTFNDxR2.setText(mBuscarPatologias(xrs.getString(5)));
                this.JTFCDxR3.setText(xrs.getString(6));
                this.JTFNDxR3.setText(mBuscarPatologias(xrs.getString(6)));
                this.JTPConclusion.setText(xrs.getString(7));
                if (xrs.getInt(9) == 1) {
                    this.JBTGuardar.setEnabled(false);
                } else {
                    this.JBTGuardar.setEnabled(true);
                }
                if (xrs.getInt("DestinoP") == 0) {
                    this.JRBDomicilio.setSelected(true);
                    this.xDestino = 0;
                } else if (xrs.getInt("DestinoP") == 1) {
                    this.JRBInternacion.setSelected(true);
                    this.xDestino = 1;
                } else if (xrs.getInt("DestinoP") == 2) {
                    this.JRBContraremision.setSelected(true);
                    this.xDestino = 2;
                } else if (xrs.getInt("DestinoP") == 3) {
                    this.JRBObservacion.setSelected(true);
                    this.xDestino = 3;
                } else if (xrs.getInt("DestinoP") == 4) {
                    this.JRBRemision.setSelected(true);
                    this.xDestino = 4;
                } else if (xrs.getInt("DestinoP") == 5) {
                    this.JRBOtro.setSelected(true);
                    this.xDestino = 5;
                }
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            } else {
                String sql2 = "SELECT\n    `g_patologia`.`Id`\n    , `g_patologia`.`Nbre`\nFROM\n    `h_triage_diagnostico`\n    INNER JOIN `h_triage` \n        ON (`h_triage_diagnostico`.`Id_Triage` = `h_triage`.`Id`)\n    INNER JOIN `g_patologia` \n        ON (`h_triage_diagnostico`.`Id_Patologia` = `g_patologia`.`Id`)\nWHERE (`h_triage`.`IdIngreso` ='" + this.xIngreso + "')\nORDER BY `h_triage_diagnostico`.`NOrden` ASC, `g_patologia`.`Nbre` ASC LIMIT 4";
                xrs = this.xconsultasbd.traerRs(sql2);
                if (xrs.next()) {
                    xrs.beforeFirst();
                    int n = 0;
                    while (xrs.next()) {
                        if (n == 0) {
                            this.JTFCDxP.setText(xrs.getString("Id"));
                            this.JTFNCodigoDxP.setText(xrs.getString("Nbre"));
                        } else if (n == 1) {
                            this.JTFCDxR1.setText(xrs.getString("Id"));
                            this.JTFNDxR1.setText(xrs.getString("Nbre"));
                        } else if (n == 2) {
                            this.JTFCDxR2.setText(xrs.getString("Id"));
                            this.JTFNDxR2.setText(xrs.getString("Nbre"));
                        } else if (n == 3) {
                            this.JTFCDxR3.setText(xrs.getString("Id"));
                            this.JTFNDxR3.setText(xrs.getString("Nbre"));
                        }
                        n++;
                    }
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAtencion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mBuscarPatologias(String xcodigo) {
        String xnombre = null;
        try {
            ConsultasMySQL xmt = new ConsultasMySQL();
            String sql = "SELECT Id, Nbre FROM  g_patologia where Id='" + xcodigo + "' and Estado=1";
            ResultSet res = xmt.traerRs(sql);
            if (res.next()) {
                xnombre = res.getString(2);
            }
            res.close();
            xmt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPADiagnostico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xnombre;
    }

    private void mGenerarCorreo() {
        if (Principal.informacionIps.getEsFpz().intValue() == 0 && !this.JTFCDxP.getText().isEmpty()) {
            try {
                String sql = "SELECT r_patologiasreporte.Id_Programa FROM r_patologiasreporte INNER JOIN g_tipoentidad  ON (r_patologiasreporte.Id_TipoEntidadR = g_tipoentidad.Id)  WHERE (r_patologiasreporte.Id_Patologia ='" + this.JTFCDxP.getText() + "' AND g_tipoentidad.Es_institucion =3 AND r_patologiasreporte.Estado=1) ";
                ResultSet rs = this.xconsultasbd.traerRs(sql);
                if (rs.next()) {
                    String xsql = "SELECT Id_Programa, Id_Usuario, Estado FROM g_usuarioxprograma WHERE (Id_Programa ='" + rs.getString(1) + "' AND Id_Usuario ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND Estado =0)";
                    ResultSet xrs = this.xconsultasbd.traerRs(xsql);
                    if (!xrs.next()) {
                        String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                        String mensaje = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\ncon codigo de Dx Principal:" + this.JTFCDxP.getText() + " patologia sujeta a revisión por el programa de PYP. \n\nUsuario no registrado en los programas.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                        Email em = new Email();
                        em.Send(xfrom, mensaje, "pyp@fundacionpanzenu.org.co", "PATOLOGIAS PYP");
                    }
                    xrs.close();
                    this.xconsultasbd.cerrarConexionBd();
                }
                rs.close();
                this.xconsultasbd.cerrarConexionBd();
                String sql2 = "SELECT r_patologiasreporte.Id_Programa FROM r_patologiasreporte INNER JOIN g_tipoentidad  ON (r_patologiasreporte.Id_TipoEntidadR = g_tipoentidad.Id)  WHERE (r_patologiasreporte.Id_Patologia ='" + this.JTFCDxP.getText() + "' AND g_tipoentidad.Es_institucion =1 AND g_tipoentidad.Id=4 AND r_patologiasreporte.Estado=1) ";
                ResultSet rs2 = this.xconsultasbd.traerRs(sql2);
                if (rs2.next()) {
                    rs2.first();
                    String xfrom2 = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
                    String mensaje2 = "La atención N° " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + " con N° HC " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + " del paciente: " + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreUsuario() + "\ncon codigo de Dx Principal:" + this.JTFCDxP.getText() + " Es patología de Urticaria; posible evento adverso de tipo farmacológico.\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n" + Principal.informacionGeneralPrincipalDTO.getNombreEspecialidad();
                    Email em2 = new Email();
                    em2.Send(xfrom2, mensaje2, "eventoadverso@fundacionpanzenu.org.co", "PATOLOGIAS DE POSIBLE EVENTO ADVERSO");
                }
                rs2.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPADiagnostico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public boolean mVerificar() {
        boolean estado = false;
        if (!this.JTFCDxP.getText().isEmpty()) {
            if (this.JCBTipoDx.getSelectedIndex() != -1) {
                estado = true;
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de diagnostico", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBTipoDx.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "El Dx Principal no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTFCDxP.requestFocus();
        }
        return estado;
    }

    public boolean mVerificarCerrar() {
        boolean estado = false;
        if (!this.JTFNCodigoDxP.getText().isEmpty() || this.JCBTipoDx.getSelectedIndex() != -1) {
            estado = true;
        }
        return estado;
    }
}
