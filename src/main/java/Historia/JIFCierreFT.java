package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Email;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFCierreFT.class */
public class JIFCierreFT extends JInternalFrame {
    private String[] xidespecialidad;
    private String[] xidprofesional;
    private JIFHistoriaFT xjifhc;
    private ButtonGroup JBGRetr;
    private ButtonGroup JBPre1;
    private ButtonGroup JBPre2;
    private JButton JBTEnviar;
    public JDateChooser JDCFechaC;
    private JLabel JLBNo;
    private JLabel JLBNo1;
    private JLabel JLBSi;
    private JLabel JLBSi1;
    private JPanel JPDatosRetroalimentacion;
    private JPanel JPDatosSeguimiento;
    private JPanel JPPlanCasero;
    private JRadioButton JRBNo;
    private JRadioButton JRBNoP1;
    private JRadioButton JRBNoP2;
    private JRadioButton JRBSi;
    private JRadioButton JRBSiP1;
    private JRadioButton JRBSiP2;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleR;
    private JTextField JTFEmail;
    private JTextPane JTPDetalle;
    private JTextPane JTPDetalleR;
    private JTextPane JTPP8;
    private JTextPane JTPP9;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private boolean xgrabado = false;
    private int xretro = 0;
    private int xp1 = 0;
    private int xp2 = 0;

    public JIFCierreFT(JIFHistoriaFT xjifhc) {
        initComponents();
        this.xjifhc = xjifhc;
        this.JDCFechaC.setDate(this.xmetodo.getFechaActual());
        this.xconsulta.cerrarConexionBd();
        this.JDCFechaC.requestFocus();
        mBuscarCierre();
    }

    private void initComponents() {
        this.JBGRetr = new ButtonGroup();
        this.JBPre1 = new ButtonGroup();
        this.JBPre2 = new ButtonGroup();
        this.JPDatosSeguimiento = new JPanel();
        this.JDCFechaC = new JDateChooser();
        this.JSPDetalle = new JScrollPane();
        this.JTPDetalle = new JTextPane();
        this.JTPP8 = new JTextPane();
        this.JTPP9 = new JTextPane();
        this.JLBSi = new JLabel();
        this.JLBNo = new JLabel();
        this.JRBSiP1 = new JRadioButton();
        this.JRBNoP1 = new JRadioButton();
        this.JRBSiP2 = new JRadioButton();
        this.JRBNoP2 = new JRadioButton();
        this.JLBSi1 = new JLabel();
        this.JLBNo1 = new JLabel();
        this.JPDatosRetroalimentacion = new JPanel();
        this.JSPDetalleR = new JScrollPane();
        this.JTPDetalleR = new JTextPane();
        this.JPPlanCasero = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JTFEmail = new JTextField();
        this.JBTEnviar = new JButton();
        setClosable(true);
        setTitle("CIERRE HISTORIA CLÍNICA FISIOTERAPIA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcierreft");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPDatosSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CIERRE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatosSeguimiento.setForeground(new Color(0, 103, 0));
        this.JDCFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaC.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTPDetalle.setFont(new Font("Arial", 1, 12));
        this.JSPDetalle.setViewportView(this.JTPDetalle);
        this.JTPP8.setEditable(false);
        this.JTPP8.setBorder((Border) null);
        this.JTPP8.setFont(new Font("Arial", 1, 12));
        this.JTPP8.setForeground(Color.blue);
        this.JTPP8.setText("El paciente concluyó el Num. de citas ordenadas por el Médico?");
        this.JTPP8.setOpaque(false);
        this.JTPP9.setEditable(false);
        this.JTPP9.setBorder((Border) null);
        this.JTPP9.setFont(new Font("Arial", 1, 12));
        this.JTPP9.setForeground(Color.blue);
        this.JTPP9.setText("Fué eficaz el tratamiento de Fisioterapia?");
        this.JTPP9.setOpaque(false);
        this.JLBSi.setFont(new Font("Arial", 1, 12));
        this.JLBSi.setForeground(Color.red);
        this.JLBSi.setHorizontalAlignment(0);
        this.JLBSi.setText("SI");
        this.JLBNo.setFont(new Font("Arial", 1, 12));
        this.JLBNo.setForeground(Color.red);
        this.JLBNo.setHorizontalAlignment(0);
        this.JLBNo.setText("NO");
        this.JBPre1.add(this.JRBSiP1);
        this.JRBSiP1.addActionListener(new ActionListener() { // from class: Historia.JIFCierreFT.1
            public void actionPerformed(ActionEvent evt) {
                JIFCierreFT.this.JRBSiP1ActionPerformed(evt);
            }
        });
        this.JBPre1.add(this.JRBNoP1);
        this.JRBNoP1.setSelected(true);
        this.JRBNoP1.addActionListener(new ActionListener() { // from class: Historia.JIFCierreFT.2
            public void actionPerformed(ActionEvent evt) {
                JIFCierreFT.this.JRBNoP1ActionPerformed(evt);
            }
        });
        this.JBPre2.add(this.JRBSiP2);
        this.JRBSiP2.addActionListener(new ActionListener() { // from class: Historia.JIFCierreFT.3
            public void actionPerformed(ActionEvent evt) {
                JIFCierreFT.this.JRBSiP2ActionPerformed(evt);
            }
        });
        this.JBPre2.add(this.JRBNoP2);
        this.JRBNoP2.setSelected(true);
        this.JRBNoP2.addActionListener(new ActionListener() { // from class: Historia.JIFCierreFT.4
            public void actionPerformed(ActionEvent evt) {
                JIFCierreFT.this.JRBNoP2ActionPerformed(evt);
            }
        });
        this.JLBSi1.setFont(new Font("Arial", 1, 12));
        this.JLBSi1.setForeground(Color.red);
        this.JLBSi1.setHorizontalAlignment(0);
        this.JLBSi1.setText("SI");
        this.JLBNo1.setFont(new Font("Arial", 1, 12));
        this.JLBNo1.setForeground(Color.red);
        this.JLBNo1.setHorizontalAlignment(0);
        this.JLBNo1.setText("NO");
        GroupLayout JPDatosSeguimientoLayout = new GroupLayout(this.JPDatosSeguimiento);
        this.JPDatosSeguimiento.setLayout(JPDatosSeguimientoLayout);
        JPDatosSeguimientoLayout.setHorizontalGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addContainerGap().addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDCFechaC, -2, 131, -2).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addComponent(this.JTPP8, -2, 368, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBSi, -2, 21, -2).addComponent(this.JRBSiP1)).addGap(18, 18, 18).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNoP1, GroupLayout.Alignment.TRAILING).addComponent(this.JLBNo, GroupLayout.Alignment.TRAILING)).addGap(28, 28, 28).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addComponent(this.JTPP9, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSiP2)).addComponent(this.JLBSi1, -2, 21, -2)).addGap(18, 18, 18).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBNoP2, GroupLayout.Alignment.TRAILING).addComponent(this.JLBNo1, GroupLayout.Alignment.TRAILING)))).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPDatosSeguimientoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JSPDetalle, -2, 740, -2).addGap(240, 240, 240)));
        JPDatosSeguimientoLayout.setVerticalGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDCFechaC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 96, -2).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JTPP8, -2, -1, -2)).addGroup(JPDatosSeguimientoLayout.createSequentialGroup().addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBSi).addComponent(this.JLBNo).addComponent(this.JLBSi1).addComponent(this.JLBNo1)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPP9, -2, -1, -2).addGroup(JPDatosSeguimientoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBSiP1).addComponent(this.JRBNoP1)).addComponent(this.JRBSiP2).addComponent(this.JRBNoP2)))).addContainerGap()));
        this.JPDatosRetroalimentacion.setBorder(BorderFactory.createTitledBorder((Border) null, "ENVÍO DE CORREO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalleR.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 13), Color.blue));
        this.JTPDetalleR.setEditable(false);
        this.JTPDetalleR.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleR.setViewportView(this.JTPDetalleR);
        this.JPPlanCasero.setBorder(BorderFactory.createTitledBorder((Border) null, "Retroalimentación?", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JBGRetr.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setForeground(new Color(0, 0, 255));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JIFCierreFT.5
            public void actionPerformed(ActionEvent evt) {
                JIFCierreFT.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGRetr.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setForeground(new Color(0, 0, 255));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JIFCierreFT.6
            public void actionPerformed(ActionEvent evt) {
                JIFCierreFT.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPPlanCaseroLayout = new GroupLayout(this.JPPlanCasero);
        this.JPPlanCasero.setLayout(JPPlanCaseroLayout);
        JPPlanCaseroLayout.setHorizontalGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCaseroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi).addGap(18, 18, 18).addComponent(this.JRBNo).addContainerGap(41, 32767)));
        JPPlanCaseroLayout.setVerticalGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanCaseroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo)));
        this.JTFEmail.setFont(new Font("Arial", 1, 12));
        this.JTFEmail.setBorder(BorderFactory.createTitledBorder((Border) null, "Email", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTEnviar.setFont(new Font("Arial", 1, 12));
        this.JBTEnviar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo_2.png")));
        this.JBTEnviar.setText("Enviar");
        this.JBTEnviar.addActionListener(new ActionListener() { // from class: Historia.JIFCierreFT.7
            public void actionPerformed(ActionEvent evt) {
                JIFCierreFT.this.JBTEnviarActionPerformed(evt);
            }
        });
        GroupLayout JPDatosRetroalimentacionLayout = new GroupLayout(this.JPDatosRetroalimentacion);
        this.JPDatosRetroalimentacion.setLayout(JPDatosRetroalimentacionLayout);
        JPDatosRetroalimentacionLayout.setHorizontalGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosRetroalimentacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPDatosRetroalimentacionLayout.createSequentialGroup().addComponent(this.JPPlanCasero, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEmail, -2, 444, -2)).addComponent(this.JSPDetalleR)).addGap(18, 18, 18).addComponent(this.JBTEnviar, -2, 129, -2).addGap(232, 232, 232)));
        JPDatosRetroalimentacionLayout.setVerticalGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosRetroalimentacionLayout.createSequentialGroup().addContainerGap(14, 32767).addGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTEnviar, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPDatosRetroalimentacionLayout.createSequentialGroup().addGroup(JPDatosRetroalimentacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFEmail, -2, -1, -2).addComponent(this.JPPlanCasero, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleR, -2, 102, -2))).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPDatosRetroalimentacion, GroupLayout.Alignment.LEADING, -2, 0, 32767).addGroup(layout.createSequentialGroup().addGap(0, 14, 32767).addComponent(this.JPDatosSeguimiento, -2, 779, -2))).addGap(233, 233, 233)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatosSeguimiento, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPDatosRetroalimentacion, -2, -1, -2).addContainerGap(24, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnviarActionPerformed(ActionEvent evt) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Desea enviar cierre de historia?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String recomendacion = "No se recomienda ninguna acción adicional";
            if (this.xretro == 1) {
                recomendacion = this.JTPDetalleR.getText();
            }
            String xfrom = System.getProperty("user.name") + "@fundacionpanzenu.org.co";
            String mensaje = "El Usuario " + this.xjifhc.xjppersona.getNombre1() + " " + this.xjifhc.xjppersona.getNombre2() + " " + this.xjifhc.xjppersona.getApellido1() + " " + this.xjifhc.xjppersona.getApellido2() + " ha finalizado las sesiones de fisioterpias ordenadas en su tratamiento.\n\nResumen de Atención \n" + this.JTPDetalle.getText() + "\n\nRetroalimentación \n" + recomendacion + "\n\n\n\n" + Principal.usuarioSistemaDTO.getNombreUsuario() + "\n";
            Email em = new Email();
            em.Send(xfrom, mensaje, this.JTFEmail.getText(), "Resumen de atención de fisioterapia");
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

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP1ActionPerformed(ActionEvent evt) {
        this.xp1 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP1ActionPerformed(ActionEvent evt) {
        this.xp1 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiP2ActionPerformed(ActionEvent evt) {
        this.xp2 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoP2ActionPerformed(ActionEvent evt) {
        this.xp2 = 0;
    }

    public void grabar() {
        if (!this.xgrabado) {
            if (!this.JTPDetalle.getText().isEmpty()) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    String sql = "Update h_atencionf set Estado=0, FechaCierre='" + this.xmetodo.formatoAMD.format(this.JDCFechaC.getDate()) + "', ObservacionCierre='" + this.JTPDetalle.getText() + "', Retro='" + this.xretro + "', DetalleRetro='" + this.JTPDetalleR.getText() + "', Id_ProfesionalC='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', Id_EspecialidadC='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "',  num_terapia='" + this.xp1 + "',  eficaz='" + this.xp2 + "' where Id='" + Principal.txtNo.getText() + "'";
                    Principal.txtEstado.setText("CERRADA");
                    this.xconsulta.ejecutarSQL(sql);
                    this.xconsulta.cerrarConexionBd();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La descripción no puede estar en blanco", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPDetalle.requestFocus();
        }
    }

    private void mBuscarCierre() {
        String sql = "SELECT h_atencionf.FechaCierre , h_atencionf.ObservacionCierre , profesional1.Especialidad , profesional1.NProfesional, h_atencionf.num_terapia, h_atencionf.eficaz  FROM baseserver.profesional1 INNER JOIN baseserver.h_atencionf ON (profesional1.IdEspecialidad = h_atencionf.Id_EspecialidadC) AND (profesional1.Id_Persona = h_atencionf.Id_ProfesionalC)  WHERE (h_atencionf.Id ='" + Principal.txtNo.getText() + "' and h_atencionf.Estado=0)";
        ResultSet rs = this.xconsulta.traerRs(sql);
        try {
            if (rs.next()) {
                this.JDCFechaC.setDate(rs.getDate(1));
                this.JTPDetalle.setText(rs.getString(2));
                if (rs.getInt(5) == 1) {
                    this.JRBSiP1.setSelected(true);
                } else {
                    this.JRBNoP1.setSelected(true);
                }
                if (rs.getInt(6) == 1) {
                    this.JRBSiP2.setSelected(true);
                } else {
                    this.JRBNoP2.setSelected(true);
                }
                mDesactivar();
                this.xgrabado = true;
            }
            rs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFCierreFT.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mDesactivar() {
        this.JDCFechaC.setEnabled(false);
        this.JTPDetalle.setEditable(false);
    }
}
