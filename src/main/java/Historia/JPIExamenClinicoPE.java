package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPIExamenClinicoPE.class */
public class JPIExamenClinicoPE extends JPanel {
    private String x1alcoholico = "No";
    private String x2rfacial = "No";
    private String x3pupilas = "Normales";
    private String x4cocular = "No";
    private String x5nprotacional = "Negativo";
    private String x6pmovpuntopunto = "Normal";
    private String x7promber = "Normal";
    private String x8ptamden = "Normal";
    private String x9pmpuntatalones = "Normal";
    private String x10embriaguez = "Ninguno";
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private clasesHistoriaCE xclase;
    private String xsql;
    private ButtonGroup JBGAlcoholico;
    private ButtonGroup JBGCOcular;
    private ButtonGroup JBGGEmbriaguez;
    private ButtonGroup JBGNPRotacional;
    private ButtonGroup JBGPMPuntaTalones;
    private ButtonGroup JBGPMPuntoPunto;
    private ButtonGroup JBGPRomberg;
    private ButtonGroup JBGPTamden;
    private ButtonGroup JBGPupilas;
    private ButtonGroup JBGRFacial;
    private JButton JBTGrabar;
    private JLabel JLBNRegistro;
    private JLabel JLBPMPuntaTalones;
    private JLabel JLBPMPuntoPunto;
    private JLabel JLBPRomberg;
    private JLabel JLBPTamden;
    private JPanel JPIAliento;
    private JPanel JPICOcular;
    private JPanel JPIGEmbriaguez;
    private JPanel JPINPRotacional;
    private JPanel JPIPupilas;
    private JPanel JPIRFacial;
    private JRadioButton JRBANo;
    private JRadioButton JRBASi;
    private JRadioButton JRBCONo;
    private JRadioButton JRBCOSi;
    private JRadioButton JRBGEGradoI;
    private JRadioButton JRBGEGradoII;
    private JRadioButton JRBGEGradoIII;
    private JRadioButton JRBGENinguno;
    private JRadioButton JRBNPRNegativo;
    private JRadioButton JRBNPRPositivo;
    private JRadioButton JRBPAnisocoria;
    private JRadioButton JRBPMPPAlterada;
    private JRadioButton JRBPMPPNormal;
    private JRadioButton JRBPMPTAlterada;
    private JRadioButton JRBPMPTNormal;
    private JRadioButton JRBPMidriasis;
    private JRadioButton JRBPMiosis;
    private JRadioButton JRBPNormales;
    private JRadioButton JRBPRAlterada;
    private JRadioButton JRBPRNormal;
    private JRadioButton JRBPTAlterada;
    private JRadioButton JRBPTNormal;
    private JRadioButton JRBRNo;
    private JRadioButton JRBRSi;
    private JScrollPane JSPDEConciencia;
    private JScrollPane JSPDPresentacion;
    private JScrollPane JSPObservacion;
    private JTextArea JTADPresentacion;
    private JTextArea JTAEConciencia;
    private JTextArea JTAObservacion;

    public JPIExamenClinicoPE(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mBuscar();
    }

    private void initComponents() {
        this.JBGAlcoholico = new ButtonGroup();
        this.JBGRFacial = new ButtonGroup();
        this.JBGPupilas = new ButtonGroup();
        this.JBGCOcular = new ButtonGroup();
        this.JBGNPRotacional = new ButtonGroup();
        this.JBGPMPuntoPunto = new ButtonGroup();
        this.JBGPRomberg = new ButtonGroup();
        this.JBGPTamden = new ButtonGroup();
        this.JBGPMPuntaTalones = new ButtonGroup();
        this.JBGGEmbriaguez = new ButtonGroup();
        this.JSPDPresentacion = new JScrollPane();
        this.JTADPresentacion = new JTextArea();
        this.JSPDEConciencia = new JScrollPane();
        this.JTAEConciencia = new JTextArea();
        this.JPIAliento = new JPanel();
        this.JRBASi = new JRadioButton();
        this.JRBANo = new JRadioButton();
        this.JPIRFacial = new JPanel();
        this.JRBRSi = new JRadioButton();
        this.JRBRNo = new JRadioButton();
        this.JPIPupilas = new JPanel();
        this.JRBPNormales = new JRadioButton();
        this.JRBPMiosis = new JRadioButton();
        this.JRBPMidriasis = new JRadioButton();
        this.JRBPAnisocoria = new JRadioButton();
        this.JPICOcular = new JPanel();
        this.JRBCOSi = new JRadioButton();
        this.JRBCONo = new JRadioButton();
        this.JPINPRotacional = new JPanel();
        this.JRBNPRPositivo = new JRadioButton();
        this.JRBNPRNegativo = new JRadioButton();
        this.JLBPMPuntoPunto = new JLabel();
        this.JRBPMPPNormal = new JRadioButton();
        this.JRBPMPPAlterada = new JRadioButton();
        this.JLBPRomberg = new JLabel();
        this.JRBPRNormal = new JRadioButton();
        this.JRBPRAlterada = new JRadioButton();
        this.JLBPTamden = new JLabel();
        this.JRBPTNormal = new JRadioButton();
        this.JRBPTAlterada = new JRadioButton();
        this.JLBPMPuntaTalones = new JLabel();
        this.JRBPMPTNormal = new JRadioButton();
        this.JRBPMPTAlterada = new JRadioButton();
        this.JPIGEmbriaguez = new JPanel();
        this.JRBGENinguno = new JRadioButton();
        this.JRBGEGradoI = new JRadioButton();
        this.JRBGEGradoII = new JRadioButton();
        this.JRBGEGradoIII = new JRadioButton();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JBTGrabar = new JButton();
        this.JLBNRegistro = new JLabel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "EXAMEN CLÍNICO PRUEBA DE EMBRIAGUEZ", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpiexamenclinicope");
        this.JTADPresentacion.setColumns(1);
        this.JTADPresentacion.setFont(new Font("Arial", 1, 12));
        this.JTADPresentacion.setLineWrap(true);
        this.JTADPresentacion.setRows(1);
        this.JTADPresentacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación, porte, actitud", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPDPresentacion.setViewportView(this.JTADPresentacion);
        this.JTAEConciencia.setColumns(1);
        this.JTAEConciencia.setFont(new Font("Arial", 1, 12));
        this.JTAEConciencia.setLineWrap(true);
        this.JTAEConciencia.setRows(1);
        this.JTAEConciencia.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado de conciencia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPDEConciencia.setViewportView(this.JTAEConciencia);
        this.JPIAliento.setBorder(BorderFactory.createTitledBorder((Border) null, "Aliento alcohólico", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGAlcoholico.add(this.JRBASi);
        this.JRBASi.setFont(new Font("Arial", 1, 12));
        this.JRBASi.setText("Si");
        this.JRBASi.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.1
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBASiActionPerformed(evt);
            }
        });
        this.JBGAlcoholico.add(this.JRBANo);
        this.JRBANo.setFont(new Font("Arial", 1, 12));
        this.JRBANo.setSelected(true);
        this.JRBANo.setText("No");
        this.JRBANo.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.2
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBANoActionPerformed(evt);
            }
        });
        GroupLayout JPIAlientoLayout = new GroupLayout(this.JPIAliento);
        this.JPIAliento.setLayout(JPIAlientoLayout);
        JPIAlientoLayout.setHorizontalGroup(JPIAlientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAlientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBASi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addComponent(this.JRBANo).addGap(23, 23, 23)));
        JPIAlientoLayout.setVerticalGroup(JPIAlientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIAlientoLayout.createSequentialGroup().addContainerGap().addGroup(JPIAlientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBASi).addComponent(this.JRBANo)).addContainerGap(-1, 32767)));
        this.JPIRFacial.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubicudez Facial", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGRFacial.add(this.JRBRSi);
        this.JRBRSi.setFont(new Font("Arial", 1, 12));
        this.JRBRSi.setText("Si");
        this.JRBRSi.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.3
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBRSiActionPerformed(evt);
            }
        });
        this.JBGRFacial.add(this.JRBRNo);
        this.JRBRNo.setFont(new Font("Arial", 1, 12));
        this.JRBRNo.setSelected(true);
        this.JRBRNo.setText("No");
        this.JRBRNo.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.4
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBRNoActionPerformed(evt);
            }
        });
        GroupLayout JPIRFacialLayout = new GroupLayout(this.JPIRFacial);
        this.JPIRFacial.setLayout(JPIRFacialLayout);
        JPIRFacialLayout.setHorizontalGroup(JPIRFacialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRFacialLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBRSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addComponent(this.JRBRNo).addGap(23, 23, 23)));
        JPIRFacialLayout.setVerticalGroup(JPIRFacialLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIRFacialLayout.createSequentialGroup().addContainerGap().addGroup(JPIRFacialLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBRSi).addComponent(this.JRBRNo)).addContainerGap(-1, 32767)));
        this.JPIPupilas.setBorder(BorderFactory.createTitledBorder((Border) null, "Pupilas", 1, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGPupilas.add(this.JRBPNormales);
        this.JRBPNormales.setFont(new Font("Arial", 1, 12));
        this.JRBPNormales.setSelected(true);
        this.JRBPNormales.setText("Normales");
        this.JRBPNormales.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.5
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPNormalesActionPerformed(evt);
            }
        });
        this.JBGPupilas.add(this.JRBPMiosis);
        this.JRBPMiosis.setFont(new Font("Arial", 1, 12));
        this.JRBPMiosis.setText("Miosis");
        this.JRBPMiosis.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.6
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPMiosisActionPerformed(evt);
            }
        });
        this.JBGPupilas.add(this.JRBPMidriasis);
        this.JRBPMidriasis.setFont(new Font("Arial", 1, 12));
        this.JRBPMidriasis.setText("Midriasis");
        this.JRBPMidriasis.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.7
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPMidriasisActionPerformed(evt);
            }
        });
        this.JBGPupilas.add(this.JRBPAnisocoria);
        this.JRBPAnisocoria.setFont(new Font("Arial", 1, 12));
        this.JRBPAnisocoria.setText("Anisocoria");
        this.JRBPAnisocoria.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.8
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPAnisocoriaActionPerformed(evt);
            }
        });
        GroupLayout JPIPupilasLayout = new GroupLayout(this.JPIPupilas);
        this.JPIPupilas.setLayout(JPIPupilasLayout);
        JPIPupilasLayout.setHorizontalGroup(JPIPupilasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPupilasLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBPNormales).addGap(57, 57, 57).addComponent(this.JRBPMiosis).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBPMidriasis).addGap(59, 59, 59).addComponent(this.JRBPAnisocoria).addGap(15, 15, 15)));
        JPIPupilasLayout.setVerticalGroup(JPIPupilasLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPupilasLayout.createSequentialGroup().addContainerGap().addGroup(JPIPupilasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBPNormales).addComponent(this.JRBPMiosis).addComponent(this.JRBPMidriasis).addComponent(this.JRBPAnisocoria)).addContainerGap(-1, 32767)));
        this.JPICOcular.setBorder(BorderFactory.createTitledBorder((Border) null, "Convergencia Ocular", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGCOcular.add(this.JRBCOSi);
        this.JRBCOSi.setFont(new Font("Arial", 1, 12));
        this.JRBCOSi.setText("Si");
        this.JRBCOSi.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.9
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBCOSiActionPerformed(evt);
            }
        });
        this.JBGCOcular.add(this.JRBCONo);
        this.JRBCONo.setFont(new Font("Arial", 1, 12));
        this.JRBCONo.setSelected(true);
        this.JRBCONo.setText("No");
        this.JRBCONo.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.10
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBCONoActionPerformed(evt);
            }
        });
        GroupLayout JPICOcularLayout = new GroupLayout(this.JPICOcular);
        this.JPICOcular.setLayout(JPICOcularLayout);
        JPICOcularLayout.setHorizontalGroup(JPICOcularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICOcularLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBCOSi).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addComponent(this.JRBCONo).addGap(23, 23, 23)));
        JPICOcularLayout.setVerticalGroup(JPICOcularLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICOcularLayout.createSequentialGroup().addContainerGap().addGroup(JPICOcularLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBCOSi).addComponent(this.JRBCONo)).addContainerGap(-1, 32767)));
        this.JPINPRotacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Nistagmus PosRotacional", 1, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGNPRotacional.add(this.JRBNPRPositivo);
        this.JRBNPRPositivo.setFont(new Font("Arial", 1, 12));
        this.JRBNPRPositivo.setText("Positivo");
        this.JRBNPRPositivo.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.11
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBNPRPositivoActionPerformed(evt);
            }
        });
        this.JBGNPRotacional.add(this.JRBNPRNegativo);
        this.JRBNPRNegativo.setFont(new Font("Arial", 1, 12));
        this.JRBNPRNegativo.setSelected(true);
        this.JRBNPRNegativo.setText("Negativo");
        this.JRBNPRNegativo.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.12
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBNPRNegativoActionPerformed(evt);
            }
        });
        GroupLayout JPINPRotacionalLayout = new GroupLayout(this.JPINPRotacional);
        this.JPINPRotacional.setLayout(JPINPRotacionalLayout);
        JPINPRotacionalLayout.setHorizontalGroup(JPINPRotacionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINPRotacionalLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNPRPositivo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNPRNegativo).addContainerGap(17, 32767)));
        JPINPRotacionalLayout.setVerticalGroup(JPINPRotacionalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPINPRotacionalLayout.createSequentialGroup().addContainerGap().addGroup(JPINPRotacionalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNPRPositivo).addComponent(this.JRBNPRNegativo)).addContainerGap(-1, 32767)));
        this.JLBPMPuntoPunto.setFont(new Font("Arial", 1, 12));
        this.JLBPMPuntoPunto.setForeground(new Color(255, 0, 0));
        this.JLBPMPuntoPunto.setText("Prueba de movimiento punto a punto  (dedo-nariz; dedo-dedo)  :");
        this.JBGPMPuntoPunto.add(this.JRBPMPPNormal);
        this.JRBPMPPNormal.setFont(new Font("Arial", 1, 12));
        this.JRBPMPPNormal.setSelected(true);
        this.JRBPMPPNormal.setText("Normal");
        this.JRBPMPPNormal.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.13
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPMPPNormalActionPerformed(evt);
            }
        });
        this.JBGPMPuntoPunto.add(this.JRBPMPPAlterada);
        this.JRBPMPPAlterada.setFont(new Font("Arial", 1, 12));
        this.JRBPMPPAlterada.setText("Alterada");
        this.JRBPMPPAlterada.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.14
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPMPPAlteradaActionPerformed(evt);
            }
        });
        this.JLBPRomberg.setFont(new Font("Arial", 1, 12));
        this.JLBPRomberg.setForeground(new Color(255, 0, 0));
        this.JLBPRomberg.setText("Prueba de Romberg");
        this.JBGPRomberg.add(this.JRBPRNormal);
        this.JRBPRNormal.setFont(new Font("Arial", 1, 12));
        this.JRBPRNormal.setSelected(true);
        this.JRBPRNormal.setText("Normal");
        this.JRBPRNormal.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.15
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPRNormalActionPerformed(evt);
            }
        });
        this.JBGPRomberg.add(this.JRBPRAlterada);
        this.JRBPRAlterada.setFont(new Font("Arial", 1, 12));
        this.JRBPRAlterada.setText("Alterada");
        this.JRBPRAlterada.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.16
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPRAlteradaActionPerformed(evt);
            }
        });
        this.JLBPTamden.setFont(new Font("Arial", 1, 12));
        this.JLBPTamden.setForeground(new Color(255, 0, 0));
        this.JLBPTamden.setText("Prueba de marcha en Tamden (punta - talón)");
        this.JBGPTamden.add(this.JRBPTNormal);
        this.JRBPTNormal.setFont(new Font("Arial", 1, 12));
        this.JRBPTNormal.setSelected(true);
        this.JRBPTNormal.setText("Normal");
        this.JRBPTNormal.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.17
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPTNormalActionPerformed(evt);
            }
        });
        this.JBGPTamden.add(this.JRBPTAlterada);
        this.JRBPTAlterada.setFont(new Font("Arial", 1, 12));
        this.JRBPTAlterada.setText("Alterada");
        this.JRBPTAlterada.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.18
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPTAlteradaActionPerformed(evt);
            }
        });
        this.JLBPMPuntaTalones.setFont(new Font("Arial", 1, 12));
        this.JLBPMPuntaTalones.setForeground(new Color(255, 0, 0));
        this.JLBPMPuntaTalones.setText("Prueba de marcha en punta de pies o en talones");
        this.JBGPMPuntaTalones.add(this.JRBPMPTNormal);
        this.JRBPMPTNormal.setFont(new Font("Arial", 1, 12));
        this.JRBPMPTNormal.setSelected(true);
        this.JRBPMPTNormal.setText("Normal");
        this.JRBPMPTNormal.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.19
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPMPTNormalActionPerformed(evt);
            }
        });
        this.JBGPMPuntaTalones.add(this.JRBPMPTAlterada);
        this.JRBPMPTAlterada.setFont(new Font("Arial", 1, 12));
        this.JRBPMPTAlterada.setText("Alterada");
        this.JRBPMPTAlterada.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.20
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBPMPTAlteradaActionPerformed(evt);
            }
        });
        this.JPIGEmbriaguez.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado de embriaguez clínica", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGGEmbriaguez.add(this.JRBGENinguno);
        this.JRBGENinguno.setFont(new Font("Arial", 1, 12));
        this.JRBGENinguno.setSelected(true);
        this.JRBGENinguno.setText("Ninguno");
        this.JRBGENinguno.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.21
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBGENingunoActionPerformed(evt);
            }
        });
        this.JBGGEmbriaguez.add(this.JRBGEGradoI);
        this.JRBGEGradoI.setFont(new Font("Arial", 1, 12));
        this.JRBGEGradoI.setText("Grado I");
        this.JRBGEGradoI.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.22
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBGEGradoIActionPerformed(evt);
            }
        });
        this.JBGGEmbriaguez.add(this.JRBGEGradoII);
        this.JRBGEGradoII.setFont(new Font("Arial", 1, 12));
        this.JRBGEGradoII.setText("Grado II");
        this.JRBGEGradoII.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.23
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBGEGradoIIActionPerformed(evt);
            }
        });
        this.JBGGEmbriaguez.add(this.JRBGEGradoIII);
        this.JRBGEGradoIII.setFont(new Font("Arial", 1, 12));
        this.JRBGEGradoIII.setText("Grado III");
        this.JRBGEGradoIII.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.24
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JRBGEGradoIIIActionPerformed(evt);
            }
        });
        GroupLayout JPIGEmbriaguezLayout = new GroupLayout(this.JPIGEmbriaguez);
        this.JPIGEmbriaguez.setLayout(JPIGEmbriaguezLayout);
        JPIGEmbriaguezLayout.setHorizontalGroup(JPIGEmbriaguezLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGEmbriaguezLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBGENinguno).addGap(20, 20, 20).addComponent(this.JRBGEGradoI).addGap(18, 18, 18).addComponent(this.JRBGEGradoII).addGap(18, 18, 18).addComponent(this.JRBGEGradoIII).addContainerGap(-1, 32767)));
        JPIGEmbriaguezLayout.setVerticalGroup(JPIGEmbriaguezLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGEmbriaguezLayout.createSequentialGroup().addContainerGap().addGroup(JPIGEmbriaguezLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBGENinguno).addComponent(this.JRBGEGradoI).addComponent(this.JRBGEGradoII).addComponent(this.JRBGEGradoIII)).addContainerGap(17, 32767)));
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Historia.JPIExamenClinicoPE.25
            public void actionPerformed(ActionEvent evt) {
                JPIExamenClinicoPE.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JLBNRegistro.setFont(new Font("Arial", 1, 18));
        this.JLBNRegistro.setForeground(new Color(255, 0, 0));
        this.JLBNRegistro.setHorizontalAlignment(0);
        this.JLBNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 2, 0, new Font("Arial", 1, 14), Color.blue));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JSPDPresentacion, -2, 397, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDEConciencia, -2, 397, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JPIAliento, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIRFacial, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIPupilas, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIGEmbriaguez, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JLBPMPuntaTalones).addGap(26, 26, 26).addComponent(this.JRBPMPTNormal))).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.JRBPMPTAlterada).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservacion)))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JLBPMPuntoPunto).addGap(26, 26, 26).addComponent(this.JRBPMPPNormal).addGap(28, 28, 28).addComponent(this.JRBPMPPAlterada)).addGroup(layout.createSequentialGroup().addComponent(this.JPICOcular, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPINPRotacional, -2, -1, -2)).addGroup(layout.createSequentialGroup().addComponent(this.JLBPRomberg).addGap(26, 26, 26).addComponent(this.JRBPRNormal).addGap(28, 28, 28).addComponent(this.JRBPRAlterada)).addGroup(layout.createSequentialGroup().addComponent(this.JLBPTamden).addGap(26, 26, 26).addComponent(this.JRBPTNormal).addGap(28, 28, 28).addComponent(this.JRBPTAlterada)).addComponent(this.JBTGrabar, -2, 644, -2)).addGap(24, 24, 24).addComponent(this.JLBNRegistro, -1, -1, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDEConciencia, -2, 61, -2).addComponent(this.JSPDPresentacion, -2, 61, -2)).addGap(21, 21, 21).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIAliento, -1, -1, 32767).addComponent(this.JPIRFacial, -1, -1, 32767).addComponent(this.JPIPupilas, -1, -1, 32767)).addGap(27, 27, 27).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPICOcular, -2, -1, -2).addComponent(this.JPINPRotacional, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPMPuntoPunto).addComponent(this.JRBPMPPNormal).addComponent(this.JRBPMPPAlterada)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPRomberg).addComponent(this.JRBPRNormal).addComponent(this.JRBPRAlterada)).addGap(26, 26, 26).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPTamden).addComponent(this.JRBPTNormal).addComponent(this.JRBPTAlterada)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBPMPuntaTalones).addComponent(this.JRBPMPTNormal).addComponent(this.JRBPMPTAlterada)).addGap(18, 18, 18).addComponent(this.JPIGEmbriaguez, -2, -1, -2)).addComponent(this.JSPObservacion, -2, 61, -2)).addGap(43, 43, 43).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNRegistro, -1, -1, 32767).addComponent(this.JBTGrabar, -1, 70, 32767)).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBASiActionPerformed(ActionEvent evt) {
        this.x1alcoholico = "Si";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBANoActionPerformed(ActionEvent evt) {
        this.x1alcoholico = "No";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRSiActionPerformed(ActionEvent evt) {
        this.x2rfacial = "Si";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBRNoActionPerformed(ActionEvent evt) {
        this.x2rfacial = "No";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPNormalesActionPerformed(ActionEvent evt) {
        this.x3pupilas = this.JRBPNormales.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPMiosisActionPerformed(ActionEvent evt) {
        this.x3pupilas = this.JRBPMiosis.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPMidriasisActionPerformed(ActionEvent evt) {
        this.x3pupilas = this.JRBPMidriasis.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPAnisocoriaActionPerformed(ActionEvent evt) {
        this.x3pupilas = this.JRBPAnisocoria.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCOSiActionPerformed(ActionEvent evt) {
        this.x4cocular = this.JRBCOSi.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCONoActionPerformed(ActionEvent evt) {
        this.x4cocular = this.JRBCONo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNPRPositivoActionPerformed(ActionEvent evt) {
        this.x5nprotacional = this.JRBNPRPositivo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNPRNegativoActionPerformed(ActionEvent evt) {
        this.x5nprotacional = this.JRBNPRNegativo.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPMPPAlteradaActionPerformed(ActionEvent evt) {
        this.x6pmovpuntopunto = this.JRBPMPPAlterada.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPMPPNormalActionPerformed(ActionEvent evt) {
        this.x6pmovpuntopunto = this.JRBPMPPNormal.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPRNormalActionPerformed(ActionEvent evt) {
        this.x7promber = this.JRBPMPPAlterada.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPRAlteradaActionPerformed(ActionEvent evt) {
        this.x7promber = this.JRBPRAlterada.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPTNormalActionPerformed(ActionEvent evt) {
        this.x8ptamden = this.JRBPTNormal.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPTAlteradaActionPerformed(ActionEvent evt) {
        this.x8ptamden = this.JRBPTAlterada.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPMPTNormalActionPerformed(ActionEvent evt) {
        this.x9pmpuntatalones = this.JRBPMPTNormal.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPMPTAlteradaActionPerformed(ActionEvent evt) {
        this.x9pmpuntatalones = this.JRBPMPTAlterada.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGENingunoActionPerformed(ActionEvent evt) {
        this.x10embriaguez = this.JRBGENinguno.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGEGradoIActionPerformed(ActionEvent evt) {
        this.x10embriaguez = this.JRBGEGradoI.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGEGradoIIActionPerformed(ActionEvent evt) {
        this.x10embriaguez = this.JRBGEGradoII.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGEGradoIIIActionPerformed(ActionEvent evt) {
        this.x10embriaguez = this.JRBGEGradoIII.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    public void mGrabar() {
        if (this.JLBNRegistro.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "insert into h_so_examen_prueba_embriaguez (`Id_Atencion`, `DPresentacion`, `EConciencia`, `Aliento`, `RFacial`, `Pupilas`, `COcular`, `NPosRotacional`, `PMovimientoPP`, `PRomber`, `PMTamden`, `PMPuntaPT`, `GEmbriaguez`, `Observaciones`, `UsuarioS` ) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTADPresentacion.getText() + "','" + this.JTAEConciencia.getText() + "','" + this.x1alcoholico + "','" + this.x2rfacial + "','" + this.x3pupilas + "','" + this.x4cocular + "','" + this.x5nprotacional + "','" + this.x6pmovpuntopunto + "','" + this.x7promber + "','" + this.x8ptamden + "','" + this.x9pmpuntatalones + "','" + this.x10embriaguez + "','" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.JLBNRegistro.setText(this.xct.ejecutarSQLId(this.xsql));
                this.xct.cerrarConexionBd();
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
        }
    }

    private void mBuscar() {
        try {
            this.xsql = "SELECT `Id` , `DPresentacion`, `EConciencia`, `Aliento`, `RFacial`, `Pupilas`, `COcular`, `NPosRotacional`, `PMovimientoPP`, `PRomber`, `PMTamden`, `PMPuntaPT`, `GEmbriaguez`, `Observaciones` FROM  `h_so_examen_prueba_embriaguez` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `Estado` =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JLBNRegistro.setText(xrs.getString(1));
                this.JTADPresentacion.setText(xrs.getString(2));
                this.JTAEConciencia.setText(xrs.getString(3));
                if (xrs.getString(4).equals("Si")) {
                    this.JRBASi.setSelected(true);
                } else {
                    this.JRBANo.setSelected(true);
                }
                if (xrs.getString(5).equals("Si")) {
                    this.JRBRSi.setSelected(true);
                } else {
                    this.JRBRNo.setSelected(true);
                }
                if (xrs.getString(6).equals("Normales")) {
                    this.JRBPNormales.setSelected(true);
                } else if (xrs.getString(6).equals("Miosis")) {
                    this.JRBPMiosis.setSelected(true);
                } else if (xrs.getString(6).equals("Midriasis")) {
                    this.JRBPMidriasis.setSelected(true);
                } else if (xrs.getString(6).equals("Anisocoria")) {
                    this.JRBPAnisocoria.setSelected(true);
                }
                if (xrs.getString(7).equals("Si")) {
                    this.JRBCOSi.setSelected(true);
                } else {
                    this.JRBCONo.setSelected(true);
                }
                if (xrs.getString(8).equals("Positivo")) {
                    this.JRBNPRPositivo.setSelected(true);
                } else {
                    this.JRBNPRNegativo.setSelected(true);
                }
                if (xrs.getString(9).equals("Normal")) {
                    this.JRBPMPPNormal.setSelected(true);
                } else {
                    this.JRBPMPPAlterada.setSelected(true);
                }
                if (xrs.getString(10).equals("Normal")) {
                    this.JRBPRNormal.setSelected(true);
                } else {
                    this.JRBPRAlterada.setSelected(true);
                }
                if (xrs.getString(11).equals("Normal")) {
                    this.JRBPTNormal.setSelected(true);
                } else {
                    this.JRBPTAlterada.setSelected(true);
                }
                if (xrs.getString(12).equals("Normal")) {
                    this.JRBPMPTNormal.setSelected(true);
                } else {
                    this.JRBPMPTAlterada.setSelected(true);
                }
                if (xrs.getString(13).equals("Ninguno")) {
                    this.JRBGENinguno.setSelected(true);
                } else if (xrs.getString(13).equals("Grado I") || xrs.getString(13).equals("Grado II") || xrs.getString(13).equals("Grado III")) {
                    this.JRBGEGradoII.setSelected(true);
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
            this.JBTGrabar.setEnabled(false);
        } catch (SQLException ex) {
            Logger.getLogger(JPIExamenClinicoPE.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
