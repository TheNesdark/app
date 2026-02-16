package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.corrector.jortho.FileUserDictionary;
import Utilidades.corrector.jortho.SpellChecker;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAtencion.class */
public class JPAAtencion extends JPanel {
    private clasesHistoriaCE xclaseh;
    private int xgr;
    public boolean nAtencion;
    private JButton JBTGuardarTemporal;
    private JButton JBT_Triage;
    private JButton JBT_Triage1;
    private JScrollPane JSPEActual;
    private JScrollPane JSPMotivoConsulta;
    public JTextPane JTPEActual;
    public JTextPane JTPMotivoConsulta;
    public int xverficarg = 1;
    private Metodos metodos = new Metodos();

    public JPAAtencion(clasesHistoriaCE xclaseh) {
        this.xgr = 0;
        initComponents();
        this.xclaseh = xclaseh;
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(this.JTPMotivoConsulta);
        SpellChecker.register(this.JTPEActual);
        this.xgr = 0;
        mBuscarDatosBd();
        this.xgr = 1;
        this.nAtencion = ((this.JTPEActual.getText().isEmpty() || this.JTPEActual.getText() == null) && (this.JTPMotivoConsulta.getText() == null || this.JTPMotivoConsulta.getText().isEmpty())) ? false : true;
        if (!this.JBTGuardarTemporal.isEnabled() || !this.JTPMotivoConsulta.getText().isEmpty()) {
            this.JBT_Triage1.setEnabled(true);
        }
    }

    private void initComponents() {
        this.JSPMotivoConsulta = new JScrollPane();
        this.JTPMotivoConsulta = new JTextPane();
        this.JBTGuardarTemporal = new JButton();
        this.JSPEActual = new JScrollPane();
        this.JTPEActual = new JTextPane();
        this.JBT_Triage = new JButton();
        this.JBT_Triage1 = new JButton();
        setCursor(new Cursor(0));
        setName("atencion");
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAAtencion.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAAtencion.this.formAncestorRemoved(evt);
            }
        });
        addMouseListener(new MouseAdapter() { // from class: Historia.JPAAtencion.2
            public void mouseExited(MouseEvent evt) {
                JPAAtencion.this.formMouseExited(evt);
            }
        });
        addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAtencion.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAtencion.this.formPropertyChange(evt);
            }
        });
        addKeyListener(new KeyAdapter() { // from class: Historia.JPAAtencion.4
            public void keyReleased(KeyEvent evt) {
                JPAAtencion.this.formKeyReleased(evt);
            }
        });
        this.JSPMotivoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "MOTIVO CONSULTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPMotivoConsulta.setForeground(UIManager.getDefaults().getColor("textHighlight"));
        this.JTPMotivoConsulta.setFont(new Font("Arial", 1, 12));
        this.JTPMotivoConsulta.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAtencion.5
            public void keyTyped(KeyEvent evt) {
                JPAAtencion.this.JTPMotivoConsultaKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JPAAtencion.this.JTPMotivoConsultaKeyPressed(evt);
            }
        });
        this.JSPMotivoConsulta.setViewportView(this.JTPMotivoConsulta);
        this.JBTGuardarTemporal.setFont(new Font("Arial", 1, 14));
        this.JBTGuardarTemporal.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemporal.setText("Guardar");
        this.JBTGuardarTemporal.addActionListener(new ActionListener() { // from class: Historia.JPAAtencion.6
            public void actionPerformed(ActionEvent evt) {
                JPAAtencion.this.JBTGuardarTemporalActionPerformed(evt);
            }
        });
        this.JBTGuardarTemporal.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAtencion.7
            public void keyPressed(KeyEvent evt) {
                JPAAtencion.this.JBTGuardarTemporalKeyPressed(evt);
            }
        });
        this.JSPEActual.setBorder(BorderFactory.createTitledBorder((Border) null, "ENFERMEDAD ACTUAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPEActual.setForeground(UIManager.getDefaults().getColor("textHighlight"));
        this.JTPEActual.setFont(new Font("Arial", 1, 12));
        this.JTPEActual.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAtencion.8
            public void keyPressed(KeyEvent evt) {
                JPAAtencion.this.JTPEActualKeyPressed(evt);
            }
        });
        this.JSPEActual.setViewportView(this.JTPEActual);
        this.JBT_Triage.setFont(new Font("Arial", 1, 12));
        this.JBT_Triage.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBT_Triage.setText("Traer Datos Triage");
        this.JBT_Triage.addActionListener(new ActionListener() { // from class: Historia.JPAAtencion.9
            public void actionPerformed(ActionEvent evt) {
                JPAAtencion.this.JBT_TriageActionPerformed(evt);
            }
        });
        this.JBT_Triage1.setFont(new Font("Arial", 1, 12));
        this.JBT_Triage1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Flecha_Arriba.png")));
        this.JBT_Triage1.setText("...");
        this.JBT_Triage1.setToolTipText("Desbloquear motivo de consulta y cambio de profesional");
        this.JBT_Triage1.setEnabled(false);
        this.JBT_Triage1.addActionListener(new ActionListener() { // from class: Historia.JPAAtencion.10
            public void actionPerformed(ActionEvent evt) {
                JPAAtencion.this.JBT_Triage1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPEActual).addComponent(this.JSPMotivoConsulta, GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.JBTGuardarTemporal, -2, 472, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Triage).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, 32767).addComponent(this.JBT_Triage1, -2, 82, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(7, 7, 7).addComponent(this.JSPMotivoConsulta, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPEActual, -2, 300, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGuardarTemporal, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Triage, -2, 50, -2).addComponent(this.JBT_Triage1, -2, 50, -2))).addContainerGap(18, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemporalActionPerformed(ActionEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPMotivoConsultaKeyPressed(KeyEvent evt) {
        this.metodos.valiacionCaracterComillaSimpleTextPane(evt, this.JTPMotivoConsulta);
        if (evt.getKeyCode() == 9) {
            this.JTPMotivoConsulta.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemporalKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        if (!this.JTPMotivoConsulta.getText().isEmpty() && !this.JTPEActual.getText().isEmpty()) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPEActualKeyPressed(KeyEvent evt) {
        this.metodos.valiacionCaracterComillaSimpleTextPane(evt, this.JTPEActual);
        if (evt.getKeyCode() == 9) {
            this.JTPEActual.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formMouseExited(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formPropertyChange(PropertyChangeEvent evt) {
        if (this.xgr == 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formKeyReleased(KeyEvent evt) {
        mGrabarBd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_TriageActionPerformed(ActionEvent evt) {
        mCargarTriage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPMotivoConsultaKeyTyped(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_Triage1ActionPerformed(ActionEvent evt) {
        if (!this.JBTGuardarTemporal.isEnabled() || !this.JTPMotivoConsulta.getText().isEmpty()) {
            ConsultasMySQL xct = new ConsultasMySQL();
            String sql = "update h_atencion  set  Id_Profesional=" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + " ,TipoGuardado=0,  Id_Especialidad=" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + " where  Id=" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "";
            System.out.println("" + sql);
            xct.ejecutarSQL(sql);
            xct.cerrarConexionBd();
            mBuscarDatosBd();
        }
    }

    /* JADX WARN: Finally extract failed */
    private void mCargarTriage() {
        try {
            String sql = "SELECT `MotivoConsulta` FROM  `h_triage` WHERE (`Estado` =0 AND `IdIngreso` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "') ";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(sql);
            Throwable th = null;
            try {
                if (xrs.next()) {
                    xrs.first();
                    this.JTPMotivoConsulta.setText(xrs.getString("MotivoConsulta"));
                } else {
                    this.JTPEActual.setText(xrs.getString("MotivoConsulta"));
                }
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        xrs.close();
                    }
                }
                xct.cerrarConexionBd();
            } catch (Throwable th3) {
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        xrs.close();
                    }
                }
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPAAtencion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabarBd() {
        String sql;
        String sql2;
        if (this.JBTGuardarTemporal.isEnabled()) {
            if (!this.JTPMotivoConsulta.getText().isEmpty()) {
                if (!this.JTPEActual.getText().isEmpty()) {
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") && this.JTPEActual.getText().length() >= 20) {
                        Metodos xmt = new Metodos();
                        ConsultasMySQL xct = new ConsultasMySQL();
                        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
                            if (!clasesHistoriaCE.informacionAgendaMedicaDTO.getEnfermedadActual().equals("") && !clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta().equals("")) {
                                sql2 = "update h_atencion set Motivo_Atencion='" + this.JTPMotivoConsulta.getText() + "' , EActual='" + this.JTPEActual.getText() + "' where  Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'";
                            } else {
                                sql2 = "update h_atencion set Motivo_Atencion='" + this.JTPMotivoConsulta.getText() + "' , EActual='" + this.JTPEActual.getText() + "' , Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' , Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' where  Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'";
                            }
                            xct.ejecutarSQL(sql2);
                            xct.cerrarConexionBd();
                            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                        } else {
                            String sql3 = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, EActual, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdClaseCita() + "','" + xmt.formatoAMD.format(xmt.getFechaActual()) + "','" + xmt.formatoH24.format(xmt.getFechaActual()) + "',''','','1','','','','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + xmt.formatoAMDH24.format(xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            xct.ejecutarSQLId(sql3);
                        }
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setMotivoConsulta(this.JTPMotivoConsulta.getText());
                        clasesHistoriaCE.informacionAgendaMedicaDTO.setEnfermedadActual(this.JTPEActual.getText());
                        mBuscarDatosBd();
                        xct.cerrarConexionBd();
                        if (!this.JTPMotivoConsulta.getText().isEmpty() && !this.JTPEActual.getText().isEmpty()) {
                            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                        } else {
                            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, false);
                        }
                        this.nAtencion = true;
                        return;
                    }
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") && this.JTPEActual.getText().length() < 20) {
                        JOptionPane.showInternalMessageDialog(this, "La enfermedad actual debe tener minimo 20 caracteres", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    Metodos xmt2 = new Metodos();
                    ConsultasMySQL xct2 = new ConsultasMySQL();
                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null) {
                        if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DEL PRADO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getEnfermedadActual().equals("") || clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta().equals("")) {
                                sql = "update h_atencion set Motivo_Atencion='" + this.JTPMotivoConsulta.getText() + "', EActual='" + this.JTPEActual.getText() + "' , Id_Profesional=" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + " , Id_Especialidad=" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + ",   h_atencion.`TipoGuardado`=2 where  Id=" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "";
                            } else if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoGuardado().intValue() == 0) {
                                sql = "update h_atencion set Motivo_Atencion='" + this.JTPMotivoConsulta.getText() + "', EActual='" + this.JTPEActual.getText() + "' where  Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'  AND Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'";
                            } else {
                                sql = "update h_atencion set Motivo_Atencion='" + this.JTPMotivoConsulta.getText() + "', EActual='" + this.JTPEActual.getText() + "' where  Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'";
                            }
                        } else if (!clasesHistoriaCE.informacionAgendaMedicaDTO.getEnfermedadActual().equals("") && !clasesHistoriaCE.informacionAgendaMedicaDTO.getMotivoConsulta().equals("")) {
                            sql = "update h_atencion set Motivo_Atencion='" + this.JTPMotivoConsulta.getText() + "' , EActual='" + this.JTPEActual.getText() + "' where  Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' AND Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'";
                        } else {
                            sql = "update h_atencion set Motivo_Atencion='" + this.JTPMotivoConsulta.getText() + "' , EActual='" + this.JTPEActual.getText() + "' , Id_Profesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' , Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' where  Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Id_Especialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "'";
                        }
                        xct2.ejecutarSQL(sql);
                        xct2.cerrarConexionBd();
                        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    } else {
                        String sql4 = "INSERT INTO h_atencion (Id_Ingreso, Id_ClaseCita, Fecha_Atencion, Hora_Atencion, Motivo_Atencion, EActual, Codigo_Dxp, Id_TipoDx, Codigo_DxR1, Codigo_DxR2, Codigo_DxR3, Conclusion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ( '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdClaseCita() + "','" + xmt2.formatoAMD.format(xmt2.getFechaActual()) + "','" + xmt2.formatoH24.format(xmt2.getFechaActual()) + "',''','','1','','','','','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + xmt2.formatoAMDH24.format(xmt2.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        xct2.ejecutarSQLId(sql4);
                    }
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setMotivoConsulta(this.JTPMotivoConsulta.getText());
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEnfermedadActual(this.JTPEActual.getText());
                    xct2.cerrarConexionBd();
                    if (!this.JTPMotivoConsulta.getText().isEmpty() && !this.JTPEActual.getText().isEmpty()) {
                        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    } else {
                        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, false);
                    }
                    this.nAtencion = true;
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La enfermedad actual no puede estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPEActual.setFocusable(true);
                this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, false);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El motivo de la consulta no puede estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPMotivoConsulta.setFocusable(true);
            this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, false);
        }
    }

    private void mBuscarDatosBd() {
        ConsultasMySQL xct = new ConsultasMySQL();
        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() != null || !clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion().isEmpty()) {
            try {
                String sql = "SELECT IF(`h_atencion`.`Motivo_Atencion`='',`c_clasecita`.`Nbre`, ifnull(`h_atencion`.`Motivo_Atencion`, '')) AS `MotivoC` , `h_atencion`.`TipoGuardado`, ifnull(`h_atencion`.EActual, '')EActual, `c_clasecita`.`Nbre` NClaseCita FROM `h_atencion` INNER JOIN `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`h_atencion`.`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "') ";
                ResultSet xrs = xct.traerRs(sql);
                if (xrs.next()) {
                    xrs.first();
                    if (Principal.informacionIps.getNombreIps().equals("BIENESTAR ACTIVA IPS") && xrs.getString(1).equals(xrs.getString("NClaseCita"))) {
                        this.JTPMotivoConsulta.setText("");
                    } else {
                        this.JTPMotivoConsulta.setText(xrs.getString(1));
                    }
                    this.JTPEActual.setText(xrs.getString(3));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setMotivoConsulta(xrs.getString(1));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setEnfermedadActual(xrs.getString(3));
                    clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoGuardado(Integer.valueOf(xrs.getInt(2)));
                    if (!xrs.getString(1).equals("") && !xrs.getString(3).equals("") && !xrs.getString(3).equals(null)) {
                        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    } else {
                        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, false);
                    }
                    if (xrs.getInt(2) == 0 || xrs.getInt(2) == 2) {
                        this.JTPMotivoConsulta.setEnabled(true);
                        this.JTPEActual.setEnabled(true);
                        this.JBTGuardarTemporal.setEnabled(true);
                    } else {
                        this.JTPMotivoConsulta.setEnabled(false);
                        this.JBTGuardarTemporal.setEnabled(false);
                        this.JTPEActual.setEnabled(false);
                    }
                }
                xrs.close();
                xct.cerrarConexionBd();
                return;
            } catch (SQLException ex) {
                Logger.getLogger(JPAAtencion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        if (Principal.informacionIps.getEsFpz().intValue() == 0 && Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().equals("690")) {
            this.JTPMotivoConsulta.setText(clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta());
        }
    }
}
