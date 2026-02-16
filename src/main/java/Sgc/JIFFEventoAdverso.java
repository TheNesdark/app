package Sgc;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Sgc/JIFFEventoAdverso.class */
public class JIFFEventoAdverso extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private ButtonGroup JBG1;
    private ButtonGroup JBG2;
    private JDateChooser JDHta_FechaIngreso;
    private JLabel JLArea;
    private JLabel JLLider;
    private JLabel JLPersonaReporta;
    private JRadioButton JRBNO1;
    private JRadioButton JRBNO2;
    private JRadioButton JRBNO3;
    private JRadioButton JRBSI1;
    private JRadioButton JRBSI2;
    private JTextField JTFLugar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    public JFormattedTextField txtHora;

    public JIFFEventoAdverso() {
        initComponents();
        mIniciaComponentes();
    }

    private void initComponents() {
        this.JBG1 = new ButtonGroup();
        this.JBG2 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JDHta_FechaIngreso = new JDateChooser();
        this.txtHora = new JFormattedTextField();
        this.JLArea = new JLabel();
        this.JTFLugar = new JTextField();
        this.JLPersonaReporta = new JLabel();
        this.JLLider = new JLabel();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea1 = new JTextArea();
        this.JRBSI1 = new JRadioButton();
        this.JRBNO1 = new JRadioButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.JRBSI2 = new JRadioButton();
        this.JRBNO2 = new JRadioButton();
        this.JRBNO3 = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REPORTE DE EVENTOS ADVERSOS PARA EL PACIENTE");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "NOTIFICACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDHta_FechaIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDHta_FechaIngreso.setDateFormatString("dd/MM/yyyy");
        this.JDHta_FechaIngreso.setFont(new Font("Arial", 1, 12));
        this.JDHta_FechaIngreso.setMaxSelectableDate(new Date(253370786508000L));
        this.JDHta_FechaIngreso.setMinSelectableDate(new Date(-62135747892000L));
        this.JDHta_FechaIngreso.addPropertyChangeListener(new PropertyChangeListener() { // from class: Sgc.JIFFEventoAdverso.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFEventoAdverso.this.JDHta_FechaIngresoPropertyChange(evt);
            }
        });
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Sgc.JIFFEventoAdverso.2
            public void keyPressed(KeyEvent evt) {
                JIFFEventoAdverso.this.txtHoraKeyPressed(evt);
            }
        });
        this.JLArea.setFont(new Font("Arial", 1, 12));
        this.JLArea.setBorder(BorderFactory.createTitledBorder((Border) null, "Área o dependencia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFLugar.setFont(new Font("Arial", 1, 12));
        this.JTFLugar.setBorder(BorderFactory.createTitledBorder((Border) null, "Lugar donde se presenta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLPersonaReporta.setFont(new Font("Arial", 1, 12));
        this.JLPersonaReporta.setBorder(BorderFactory.createTitledBorder((Border) null, "Persona  que reporta", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLLider.setFont(new Font("Arial", 1, 12));
        this.JLLider.setBorder(BorderFactory.createTitledBorder((Border) null, "Líder responsable", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JDHta_FechaIngreso, -2, 102, -2).addGap(5, 5, 5).addComponent(this.txtHora, -2, 95, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLArea, -2, 298, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFLugar).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JLPersonaReporta, -2, 341, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLLider, -2, 341, -2).addContainerGap(121, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDHta_FechaIngreso, -1, 51, 32767).addComponent(this.txtHora).addComponent(this.JLArea, -1, -1, 32767).addComponent(this.JTFLugar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLLider, -2, 45, -2).addGap(0, 0, 32767)).addComponent(this.JLPersonaReporta, -1, -1, 32767)).addContainerGap()));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.jTextArea1.setColumns(1);
        this.jTextArea1.setFont(new Font("Arial", 1, 12));
        this.jTextArea1.setLineWrap(true);
        this.jTextArea1.setRows(1);
        this.jTextArea1.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción del Evento Adverso sucedido: (Quién, Qué, Cómo, Cuándo)    ", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.jTextArea1);
        this.JBG1.add(this.JRBSI1);
        this.JRBSI1.setFont(new Font("Arial", 1, 12));
        this.JRBSI1.setText("Sí");
        this.JRBSI1.setToolTipText("");
        this.JBG1.add(this.JRBNO1);
        this.JRBNO1.setFont(new Font("Arial", 1, 12));
        this.JRBNO1.setSelected(true);
        this.JRBNO1.setText("No");
        this.JRBNO1.setToolTipText("");
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Está el evento identificado en el panorama de riesgos del servicio?");
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Tiene el riesgo identificado la acción preventiva adecuada?");
        this.JBG2.add(this.JRBSI2);
        this.JRBSI2.setFont(new Font("Arial", 1, 12));
        this.JRBSI2.setText("Sí");
        this.JRBSI2.setToolTipText("");
        this.JBG2.add(this.JRBNO2);
        this.JRBNO2.setFont(new Font("Arial", 1, 12));
        this.JRBNO2.setText("No");
        this.JRBNO2.setToolTipText("");
        this.JBG2.add(this.JRBNO3);
        this.JRBNO3.setFont(new Font("Arial", 1, 12));
        this.JRBNO3.setSelected(true);
        this.JRBNO3.setText("No Aplica");
        this.JRBNO3.setToolTipText("");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(10, 10, 10).addComponent(this.JRBSI1).addGap(10, 10, 10).addComponent(this.JRBNO1)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSI2).addGap(10, 10, 10).addComponent(this.JRBNO2).addGap(18, 18, 18).addComponent(this.JRBNO3))).addGap(0, 0, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSI1).addComponent(this.JRBNO1).addComponent(this.jLabel1)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSI2).addComponent(this.JRBNO2).addComponent(this.JRBNO3)).addComponent(this.jLabel2))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDHta_FechaIngresoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    private void mIniciaComponentes() {
        this.JDHta_FechaIngreso.setDate(this.xmt.getFechaActual());
        this.txtHora.setValue(this.xmt.getFechaActual());
        this.JLPersonaReporta.setText(Principal.usuarioSistemaDTO.getNombreUsuario());
    }
}
