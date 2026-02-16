package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAHExamenFisico.class */
public class JPAHExamenFisico extends JPanel {
    private int xtipo;
    private String nombrehallazgo;
    private clasesHistoriaCE xclase;
    private int xgr;
    private ButtonGroup JBGEstado;
    private JButton JBTGuardar;
    private JPanel JPHExamenFisico;
    private JPanel JPIREstado;
    public JRadioButton JRBEstadoAnormal;
    private JRadioButton JRBEstadoNormal;
    public JRadioButton JRBNoExamina;
    private JScrollPane JSPObservacionExamen;
    private JTextPane JTPHObservacionExamenFisico;
    private int estado = 2;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();

    public JPAHExamenFisico(String nombre, clasesHistoriaCE xclase, int xtipo) {
        this.xgr = 0;
        initComponents();
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.JTPHObservacionExamenFisico);
        this.xclase = xclase;
        this.xtipo = xtipo;
        this.nombrehallazgo = nombre;
        this.xgr = 0;
        mBuscarDatosBd();
        this.xgr = 1;
    }

    private void initComponents() {
        this.JBGEstado = new ButtonGroup();
        this.JPHExamenFisico = new JPanel();
        this.JSPObservacionExamen = new JScrollPane();
        this.JTPHObservacionExamenFisico = new JTextPane();
        this.JPIREstado = new JPanel();
        this.JRBEstadoNormal = new JRadioButton();
        this.JRBEstadoAnormal = new JRadioButton();
        this.JRBNoExamina = new JRadioButton();
        this.JBTGuardar = new JButton();
        setName("jpahexamenfisico");
        this.JPHExamenFisico.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGO EXÁMEN FÍSICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPObservacionExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPHObservacionExamenFisico.setFont(new Font("Arial", 0, 13));
        this.JTPHObservacionExamenFisico.addKeyListener(new KeyAdapter() { // from class: Historia.JPAHExamenFisico.1
            public void keyPressed(KeyEvent evt) {
                JPAHExamenFisico.this.JTPHObservacionExamenFisicoKeyPressed(evt);
            }
        });
        this.JSPObservacionExamen.setViewportView(this.JTPHObservacionExamenFisico);
        this.JPIREstado.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "TIPO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGEstado.add(this.JRBEstadoNormal);
        this.JRBEstadoNormal.setFont(new Font("Arial", 1, 12));
        this.JRBEstadoNormal.setForeground(Color.blue);
        this.JRBEstadoNormal.setText("Normal");
        this.JRBEstadoNormal.addActionListener(new ActionListener() { // from class: Historia.JPAHExamenFisico.2
            public void actionPerformed(ActionEvent evt) {
                JPAHExamenFisico.this.JRBEstadoNormalActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBEstadoAnormal);
        this.JRBEstadoAnormal.setFont(new Font("Arial", 1, 12));
        this.JRBEstadoAnormal.setForeground(Color.blue);
        this.JRBEstadoAnormal.setText("Anormal");
        this.JRBEstadoAnormal.addActionListener(new ActionListener() { // from class: Historia.JPAHExamenFisico.3
            public void actionPerformed(ActionEvent evt) {
                JPAHExamenFisico.this.JRBEstadoAnormalActionPerformed(evt);
            }
        });
        this.JBGEstado.add(this.JRBNoExamina);
        this.JRBNoExamina.setFont(new Font("Arial", 1, 12));
        this.JRBNoExamina.setForeground(Color.blue);
        this.JRBNoExamina.setSelected(true);
        this.JRBNoExamina.setText("Sin Hallazgos");
        this.JRBNoExamina.addActionListener(new ActionListener() { // from class: Historia.JPAHExamenFisico.4
            public void actionPerformed(ActionEvent evt) {
                JPAHExamenFisico.this.JRBNoExaminaActionPerformed(evt);
            }
        });
        GroupLayout JPIREstadoLayout = new GroupLayout(this.JPIREstado);
        this.JPIREstado.setLayout(JPIREstadoLayout);
        JPIREstadoLayout.setHorizontalGroup(JPIREstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIREstadoLayout.createSequentialGroup().addComponent(this.JRBEstadoNormal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEstadoAnormal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNoExamina, -1, -1, 32767).addContainerGap()));
        JPIREstadoLayout.setVerticalGroup(JPIREstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIREstadoLayout.createSequentialGroup().addGroup(JPIREstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEstadoNormal).addComponent(this.JRBEstadoAnormal).addComponent(this.JRBNoExamina, -1, -1, 32767)).addContainerGap(14, 32767)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPAHExamenFisico.5
            public void actionPerformed(ActionEvent evt) {
                JPAHExamenFisico.this.JBTGuardarActionPerformed(evt);
            }
        });
        GroupLayout JPHExamenFisicoLayout = new GroupLayout(this.JPHExamenFisico);
        this.JPHExamenFisico.setLayout(JPHExamenFisicoLayout);
        JPHExamenFisicoLayout.setHorizontalGroup(JPHExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHExamenFisicoLayout.createSequentialGroup().addContainerGap().addGroup(JPHExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHExamenFisicoLayout.createSequentialGroup().addComponent(this.JPIREstado, -2, -1, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPHExamenFisicoLayout.createSequentialGroup().addGroup(JPHExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTGuardar, GroupLayout.Alignment.LEADING, -1, 768, 32767).addComponent(this.JSPObservacionExamen)).addGap(20, 20, 20)))));
        JPHExamenFisicoLayout.setVerticalGroup(JPHExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHExamenFisicoLayout.createSequentialGroup().addComponent(this.JPIREstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPObservacionExamen, -2, 205, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar).addContainerGap(14, 32767)));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPHExamenFisico, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPHExamenFisico, -2, -1, -2).addContainerGap(7, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstadoNormalActionPerformed(ActionEvent evt) {
        this.estado = 0;
        this.JTPHObservacionExamenFisico.setText("CLINICAMENTE NORMAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstadoAnormalActionPerformed(ActionEvent evt) {
        this.estado = 1;
        this.JTPHObservacionExamenFisico.setText((String) null);
        this.JRBEstadoAnormal.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHObservacionExamenFisicoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPHObservacionExamenFisico.transferFocus();
        }
    }

    private void JBTGuardarKeyPressed(KeyEvent evt) {
        mGrabarBd();
    }

    private void formAncestorRemoved(AncestorEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoExaminaActionPerformed(ActionEvent evt) {
        this.estado = 2;
        this.JTPHObservacionExamenFisico.setText("SIN HALLAZGOS");
    }

    private void formMouseExited(MouseEvent evt) {
        mGrabarBd();
    }

    private void formMouseMoved(MouseEvent evt) {
        mGrabarBd();
    }

    private void formFocusLost(FocusEvent evt) {
        mGrabarBd();
    }

    private void formPropertyChange(PropertyChangeEvent evt) {
        if (this.xgr == 1) {
            mGrabarBd();
        }
    }

    private void mBuscarDatosBd() {
        String sql;
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
            try {
                if (this.xtipo == 0) {
                    if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
                        sql = "SELECT h_detalleexamenfisico.Valor, h_detalleexamenfisico.Descripcion, h_tipoexamenfisico.Nbre, h_atencion.TipoGuardado FROM h_detalleexamenfisico INNER JOIN h_examenfisico  ON (h_detalleexamenfisico.Id_ExamenFisico = h_examenfisico.Id) INNER JOIN h_atencion ON (h_examenfisico.Id_Atencion = h_atencion.Id) LEFT JOIN h_tipoexamenfisico  ON (h_detalleexamenfisico.Id_TipoExamenFisico = h_tipoexamenfisico.Id) WHERE (h_examenfisico.Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    } else {
                        sql = "SELECT h_detalleexamenfisico.Valor, h_detalleexamenfisico.Descripcion, h_tipoexamenfisico.Nbre, h_atencion.TipoGuardado FROM h_detalleexamenfisico INNER JOIN h_examenfisico  ON (h_detalleexamenfisico.Id_ExamenFisico = h_examenfisico.Id) INNER JOIN h_atencion ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_tipoexamenfisico  ON (h_detalleexamenfisico.Id_TipoExamenFisico = h_tipoexamenfisico.Id) WHERE (h_tipoexamenfisico.Nbre ='" + this.nombrehallazgo + "' AND h_examenfisico.Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                    }
                } else {
                    sql = "SELECT  `h_detalleexamenfisico_n`.`Valor` , `h_detalleexamenfisico_n`.`Descripcion` , `h_cniveluno`.`Nbre` , `h_atencion`.`TipoGuardado` FROM `h_detalleexamenfisico_n` INNER JOIN  `h_examenfisico`  ON (`h_detalleexamenfisico_n`.`Id_ExamenFisico` = `h_examenfisico`.`Id`) INNER JOIN  `h_cniveluno`  ON (`h_detalleexamenfisico_n`.`Id_hcniveluno` = `h_cniveluno`.`Id`) INNER JOIN  `h_atencion`  ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_cniveluno`.`Nbre` ='" + this.nombrehallazgo + "' AND `h_examenfisico`.`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
                }
                System.out.println(sql);
                ResultSet xrs = this.xconsultasbd.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTPHObservacionExamenFisico.setText(xrs.getString(2));
                    this.estado = xrs.getInt(1);
                    if (xrs.getInt(1) == 0) {
                        this.JRBEstadoNormal.setSelected(true);
                    } else if (xrs.getInt(1) == 1) {
                        this.JRBEstadoAnormal.setSelected(true);
                    } else {
                        this.JRBNoExamina.setSelected(true);
                    }
                    if (xrs.getInt(4) == 0 || xrs.getInt(4) == 2) {
                        this.JTPHObservacionExamenFisico.setEditable(true);
                        this.JRBEstadoAnormal.setEnabled(true);
                        this.JRBEstadoNormal.setEnabled(true);
                    } else if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS")) {
                        this.JTPHObservacionExamenFisico.setEditable(true);
                        this.JRBEstadoAnormal.setEnabled(true);
                        this.JRBEstadoNormal.setEnabled(true);
                        this.JBTGuardar.setEnabled(true);
                    } else {
                        this.JTPHObservacionExamenFisico.setEditable(false);
                        this.JRBEstadoAnormal.setEnabled(false);
                        this.JRBEstadoNormal.setEnabled(false);
                        this.JBTGuardar.setEnabled(false);
                    }
                }
                xrs.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPAHExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mGrabarBd() {
        String sql;
        String sql2;
        String sql3;
        if (this.JBTGuardar.isEnabled() && clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
            try {
                String sql4 = "SELECT Id, Id_Atencion FROM h_examenfisico WHERE (Id_Atencion ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
                ResultSet xrs = this.xconsultasbd.traerRs(sql4);
                if (xrs.next()) {
                    if (this.xtipo == 0) {
                        if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
                            sql = "SELECT h_detalleexamenfisico.Valor, h_detalleexamenfisico.Descripcion, h_tipoexamenfisico.Nbre, h_atencion.TipoGuardado,   h_detalleexamenfisico.`Id_TipoExamenFisico` FROM h_detalleexamenfisico INNER JOIN h_examenfisico  ON (h_detalleexamenfisico.Id_ExamenFisico = h_examenfisico.Id) INNER JOIN h_atencion ON (h_examenfisico.Id_Atencion = h_atencion.Id) LEFT JOIN h_tipoexamenfisico  ON (h_detalleexamenfisico.Id_TipoExamenFisico = h_tipoexamenfisico.Id) WHERE  h_detalleexamenfisico.Id_ExamenFisico ='" + xrs.getString(1) + "'";
                        } else {
                            sql = "SELECT h_detalleexamenfisico.Valor, h_detalleexamenfisico.Descripcion, h_tipoexamenfisico.Nbre, h_atencion.TipoGuardado,   h_detalleexamenfisico.`Id_TipoExamenFisico` FROM h_detalleexamenfisico INNER JOIN h_examenfisico  ON (h_detalleexamenfisico.Id_ExamenFisico = h_examenfisico.Id) INNER JOIN h_atencion ON (h_examenfisico.Id_Atencion = h_atencion.Id) INNER JOIN h_tipoexamenfisico  ON (h_detalleexamenfisico.Id_TipoExamenFisico = h_tipoexamenfisico.Id) WHERE (h_tipoexamenfisico.Nbre ='" + this.nombrehallazgo + "' AND h_detalleexamenfisico.Id_ExamenFisico ='" + xrs.getString(1) + "')";
                        }
                    } else {
                        sql = "SELECT  `h_detalleexamenfisico_n`.`Valor` , `h_detalleexamenfisico_n`.`Descripcion` , `h_cniveluno`.`Nbre` , `h_atencion`.`TipoGuardado`, `h_detalleexamenfisico_n`.`Id_ExamenFisico` , `h_detalleexamenfisico_n`.`Id_hcniveluno` FROM `h_detalleexamenfisico_n` INNER JOIN  `h_examenfisico`  ON (`h_detalleexamenfisico_n`.`Id_ExamenFisico` = `h_examenfisico`.`Id`) INNER JOIN  `h_cniveluno`  ON (`h_detalleexamenfisico_n`.`Id_hcniveluno` = `h_cniveluno`.`Id`) INNER JOIN  `h_atencion`  ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_cniveluno`.`Nbre` ='" + this.nombrehallazgo + "' AND `h_examenfisico`.`Id` ='" + xrs.getString(1) + "') ";
                    }
                    System.out.println("Examen " + sql);
                    ResultSet xrs1 = this.xconsultasbd.traerRs(sql);
                    if (xrs1.next()) {
                        if (this.xtipo == 0) {
                            if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
                                sql3 = "update h_detalleexamenfisico set Valor='" + this.estado + "', Descripcion='" + this.JTPHObservacionExamenFisico.getText() + "' WHERE (h_detalleexamenfisico.Id_ExamenFisico ='" + xrs.getString(1) + "' AND Id_TipoExamenFisico ='" + this.estado + "') ";
                            } else {
                                sql3 = "update h_detalleexamenfisico set Valor='" + this.estado + "', Descripcion='" + this.JTPHObservacionExamenFisico.getText() + "' WHERE (h_detalleexamenfisico.Id_ExamenFisico ='" + xrs.getString(1) + "' AND Id_TipoExamenFisico ='" + xrs1.getString("Id_TipoExamenFisico") + "') ";
                            }
                        } else {
                            sql3 = "update h_detalleexamenfisico_n set Valor='" + this.estado + "', Descripcion='" + this.JTPHObservacionExamenFisico.getText() + "' WHERE (Id_ExamenFisico ='" + xrs.getString(1) + "' AND Id_hcniveluno ='" + xrs1.getString("Id_hcniveluno") + "') ";
                        }
                        System.out.println("Actualiza " + sql3);
                        this.xconsultasbd.ejecutarSQL(sql3);
                        this.xconsultasbd.cerrarConexionBd();
                    } else {
                        if (this.xtipo == 0) {
                            if (Principal.informacionIps.getIdentificacion().equals("901420803")) {
                                sql2 = "insert into h_detalleexamenfisico (Id_ExamenFisico, Id_TipoExamenFisico, Valor, Descripcion) values ('" + xrs.getString(1) + "','" + this.estado + "','" + this.estado + "','" + this.JTPHObservacionExamenFisico.getText() + "')";
                            } else {
                                sql2 = "insert into h_detalleexamenfisico (Id_ExamenFisico, Id_TipoExamenFisico, Valor, Descripcion) values ('" + xrs.getString(1) + "','" + mDevorlverIdSistema() + "','" + this.estado + "','" + this.JTPHObservacionExamenFisico.getText() + "')";
                            }
                        } else {
                            sql2 = "insert into h_detalleexamenfisico_n (Id_ExamenFisico, Id_hcniveluno, Valor, Descripcion) values ('" + xrs.getString(1) + "','" + mDevorlverIdSistema() + "','" + this.estado + "','" + this.JTPHObservacionExamenFisico.getText() + "')";
                        }
                        System.out.println("Inserta " + sql2);
                        this.xconsultasbd.ejecutarSQL(sql2);
                        this.xconsultasbd.cerrarConexionBd();
                    }
                    xrs1.close();
                    this.xconsultasbd.cerrarConexionBd();
                }
                xrs.close();
                this.xconsultasbd.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JPARevisionSistemas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    private String mDevorlverIdSistema() {
        String xvalor;
        if (this.xtipo == 0) {
            xvalor = this.xconsultasbd.traerDato("SELECT Id FROM h_tipoexamenfisico WHERE Nbre='" + this.nombrehallazgo + "'");
        } else {
            xvalor = this.xconsultasbd.traerDato("SELECT  `h_cniveluno`.`Id` FROM  `h_cniveluno` INNER JOIN  `h_chistoria`  ON (`h_cniveluno`.`id_chistoria` = `h_chistoria`.`Id`) WHERE (`h_cniveluno`.`Nbre` ='" + this.nombrehallazgo + "' AND `h_chistoria`.`Nbre` ='Exámen Físico N')");
        }
        this.xconsultasbd.cerrarConexionBd();
        return xvalor;
    }
}
