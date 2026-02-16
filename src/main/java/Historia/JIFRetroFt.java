package Historia;

import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFRetroFt.class */
public class JIFRetroFt extends JInternalFrame {
    private String[] xidespecialidad;
    private String[] xidprofesional;
    private boolean xllenado;
    private JIFHistoriaFT xjifhc;
    private ButtonGroup JBGRetr;
    private JButton JBTEnviar;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    public JDateChooser JDCFecha;
    private JLabel JLBTitulo;
    private JPanel JPDatosRetroalimentacion;
    private JPanel JPDatosSeguimiento;
    private JPanel JPPlanCasero;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPDetalleR;
    private JTextField JTFEmail;
    private JTextPane JTPDetalleR;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xretro = 0;

    public JIFRetroFt(JIFHistoriaFT xjifhc) {
        this.xllenado = false;
        initComponents();
        this.xjifhc = xjifhc;
        this.JDCFecha.setDate(this.xmetodo.getFechaActual());
        this.xidespecialidad = this.xconsulta.llenarCombo("SELECT Id, Nbre FROM baseserver.g_especialidad WHERE (Estado =0 and Id=1) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.xidprofesional = this.xconsulta.llenarCombo("SELECT profesional1.Id_Persona, profesional1.NProfesional FROM baseserver.g_profesional INNER JOIN baseserver.profesional1  ON (g_profesional.Id_Persona = profesional1.Id_Persona) WHERE (profesional1.IdEspecialidad =1  AND g_profesional.Estado =0) ORDER BY profesional1.NProfesional ASC ", this.xidprofesional, this.JCBProfesional);
        this.JCBProfesional.setSelectedIndex(-1);
        this.xconsulta.cerrarConexionBd();
        this.JDCFecha.requestFocus();
        this.xllenado = true;
        this.JTFEmail.setText(this.xjifhc.xidprofesional[this.xjifhc.JCBProfesional.getSelectedIndex()][1]);
    }

    private void initComponents() {
        this.JBGRetr = new ButtonGroup();
        this.JLBTitulo = new JLabel();
        this.JPDatosSeguimiento = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JPDatosRetroalimentacion = new JPanel();
        this.JSPDetalleR = new JScrollPane();
        this.JTPDetalleR = new JTextPane();
        this.JPPlanCasero = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JTFEmail = new JTextField();
        this.JBTEnviar = new JButton();
        setClosable(true);
        setTitle("FISIOTERAPIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifretroalimentacion");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JLBTitulo.setBackground(new Color(0, 0, 102));
        this.JLBTitulo.setFont(new Font("Arial", 1, 24));
        this.JLBTitulo.setForeground(new Color(255, 255, 255));
        this.JLBTitulo.setHorizontalAlignment(0);
        this.JLBTitulo.setText("RECOMENDACIONES");
        this.JLBTitulo.setOpaque(true);
        this.JPDatosSeguimiento.setBorder(BorderFactory.createEtchedBorder());
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JIFRetroFt.1
            public void itemStateChanged(ItemEvent evt) {
                JIFRetroFt.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDatosSeguimientoLayout = new GroupLayout(this.JPDatosSeguimiento);
        this.JPDatosSeguimiento.setLayout(JPDatosSeguimientoLayout);
        JPDatosSeguimientoLayout.setHorizontalGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFecha, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEspecialidad, -2, 361, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProfesional, 0, 418, 32767).addContainerGap()));
        JPDatosSeguimientoLayout.setVerticalGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFecha, -1, 52, 32767).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -1, 52, 32767).addComponent(this.JCBProfesional, -1, 52, 32767))).addContainerGap()));
        this.JPDatosRetroalimentacion.setBorder(BorderFactory.createEtchedBorder());
        this.JSPDetalleR.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTPDetalleR.setEditable(false);
        this.JTPDetalleR.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleR.setViewportView(this.JTPDetalleR);
        this.JPPlanCasero.setBorder(BorderFactory.createTitledBorder((Border) null, "RETROALIMENTACIÓN?", 0, 0, new Font("Arial", 1, 12), new Color(0, 153, 0)));
        this.JBGRetr.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setForeground(new Color(0, 0, 255));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JIFRetroFt.2
            public void actionPerformed(ActionEvent evt) {
                JIFRetroFt.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGRetr.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setForeground(new Color(0, 0, 255));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JIFRetroFt.3
            public void actionPerformed(ActionEvent evt) {
                JIFRetroFt.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPPlanCaseroLayout = new GroupLayout(this.JPPlanCasero);
        this.JPPlanCasero.setLayout(JPPlanCaseroLayout);
        JPPlanCaseroLayout.setHorizontalGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCaseroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(42, 32767)));
        JPPlanCaseroLayout.setVerticalGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)));
        this.JTFEmail.setFont(new Font("Arial", 1, 12));
        this.JTFEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTEnviar.setFont(new Font("Arial", 1, 12));
        this.JBTEnviar.setText("Enviar");
        this.JBTEnviar.addActionListener(new ActionListener() { // from class: Historia.JIFRetroFt.4
            public void actionPerformed(ActionEvent evt) {
                JIFRetroFt.this.JBTEnviarActionPerformed(evt);
            }
        });
        GroupLayout JPDatosRetroalimentacionLayout = new GroupLayout(this.JPDatosRetroalimentacion);
        this.JPDatosRetroalimentacion.setLayout(JPDatosRetroalimentacionLayout);
        JPDatosRetroalimentacionLayout.setHorizontalGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosRetroalimentacionLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleR, -1, 926, 32767).addGroup(JPDatosRetroalimentacionLayout.createSequentialGroup().addComponent(this.JPPlanCasero, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEmail, -1, 625, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTEnviar, -2, 129, -2))).addContainerGap()));
        JPDatosRetroalimentacionLayout.setVerticalGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosRetroalimentacionLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPPlanCasero, -2, -1, -2).addComponent(this.JBTEnviar, -2, 40, -2).addComponent(this.JTFEmail, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleR, -2, 136, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatosSeguimiento, -1, -1, 32767).addComponent(this.JLBTitulo, GroupLayout.Alignment.TRAILING, -1, 950, 32767).addComponent(this.JPDatosRetroalimentacion, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLBTitulo, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPDatosSeguimiento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPDatosRetroalimentacion, -2, -1, -2).addContainerGap(17, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xllenado && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            String xsql = "SELECT profesional1.Id_Persona, profesional1.NProfesional FROM baseserver.g_profesional INNER JOIN baseserver.profesional1  ON (g_profesional.Id_Persona = profesional1.Id_Persona) WHERE (profesional1.IdEspecialidad ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "'  AND g_profesional.Estado =0) ORDER BY profesional1.NProfesional ASC ";
            this.xidprofesional = this.xconsulta.llenarCombo(xsql, this.xidprofesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
            this.xconsulta.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnviarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Desea enviar recomendación?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String recomendacion = "No se recomienda ninguna acción adicional";
            if (this.xretro == 1) {
                recomendacion = this.JTPDetalleR.getText();
            }
            String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
            String mensaje = "El Usuario " + this.xjifhc.xjppersona.getNombre1() + " " + this.xjifhc.xjppersona.getNombre2() + " " + this.xjifhc.xjppersona.getApellido1() + " " + this.xjifhc.xjppersona.getApellido2() + "\n\n Recomendacion : \n\n" + recomendacion + "\n\n\n\n" + this.JCBProfesional.getSelectedItem().toString() + "\n" + this.JCBEspecialidad.getSelectedItem().toString();
            Email em = new Email();
            em.Send(xfrom, mensaje, this.JTFEmail.getText(), "Restroalimentación");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xretro = 1;
        this.JTFEmail.setEditable(true);
        this.JBTEnviar.setEnabled(true);
        this.JTPDetalleR.setEditable(true);
        this.JTFEmail.setText(this.xjifhc.xidprofesional[this.xjifhc.JCBProfesional.getSelectedIndex()][1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xretro = 0;
        this.JTFEmail.setEditable(false);
        this.JTPDetalleR.setEditable(false);
        this.JBTEnviar.setEnabled(false);
    }
}
