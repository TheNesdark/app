package Presupuesto;

import Acceso.Principal;
import Contabilidad.JIFConsultarDatosV;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFFSolicitudPTO.class */
public class JIFFSolicitudPTO extends JInternalFrame {
    public String[][] xidunidadfuncional;
    private JIFConsultarDatosV xjifbuscarorden;
    private long xConsecutivo;
    private String[][] xidtipodoccontable;
    private JComboBox JCBTipoC;
    private JComboBox JCBUnidadF;
    private JDateChooser JDFFechaC;
    private JPanel JPIDatosP;
    private JPanel JPTipoR;
    private JRadioButton JRBBienes;
    private JRadioButton JRBServicios;
    private JTextArea JTAObservacionG;
    private JFormattedTextField JTFFValorPpt;
    private JTextField JTF_NComprobante;
    private ButtonGroup buttonGroup1;
    private JScrollPane jScrollPane1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xIdTipoSolicitud = 0;
    private String xIdDisponibilidad = "";
    private boolean xlleno = false;

    public JIFFSolicitudPTO() {
        initComponents();
        mNuevo();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatosP = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JCBUnidadF = new JComboBox();
        this.JTFFValorPpt = new JFormattedTextField();
        this.JPTipoR = new JPanel();
        this.JRBBienes = new JRadioButton();
        this.JRBServicios = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacionG = new JTextArea();
        this.JCBTipoC = new JComboBox();
        this.JTF_NComprobante = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SOLICITUD PRESUPUESTO");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifSolicitudPTO");
        addInternalFrameListener(new InternalFrameListener() { // from class: Presupuesto.JIFFSolicitudPTO.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFSolicitudPTO.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFSolicitudPTO.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFSolicitudPTO.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JTFFValorPpt.setBorder(BorderFactory.createTitledBorder((Border) null, "Presupuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPpt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorPpt.setHorizontalAlignment(0);
        this.JTFFValorPpt.setText("0");
        this.JTFFValorPpt.setToolTipText("Presupuesto aproximando");
        this.JTFFValorPpt.setFont(new Font("Arial", 1, 12));
        this.JPTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Solicitud", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.buttonGroup1.add(this.JRBBienes);
        this.JRBBienes.setFont(new Font("Arial", 1, 12));
        this.JRBBienes.setSelected(true);
        this.JRBBienes.setText("Bienes");
        this.JRBBienes.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPTO.3
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPTO.this.JRBBienesActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBServicios);
        this.JRBServicios.setFont(new Font("Arial", 1, 12));
        this.JRBServicios.setText("Servicio");
        this.JRBServicios.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPTO.4
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPTO.this.JRBServiciosActionPerformed(evt);
            }
        });
        GroupLayout JPTipoRLayout = new GroupLayout(this.JPTipoR);
        this.JPTipoR.setLayout(JPTipoRLayout);
        JPTipoRLayout.setHorizontalGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRLayout.createSequentialGroup().addComponent(this.JRBBienes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBServicios, -1, 77, 32767).addContainerGap()));
        JPTipoRLayout.setVerticalGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRLayout.createSequentialGroup().addGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBServicios).addComponent(this.JRBBienes)).addContainerGap(-1, 32767)));
        this.JTAObservacionG.setColumns(1);
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionG.setLineWrap(true);
        this.JTAObservacionG.setRows(1);
        this.JTAObservacionG.setToolTipText("Digite la descripción de la solicitud");
        this.JTAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacionG);
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFSolicitudPTO.5
            public void itemStateChanged(ItemEvent evt) {
                JIFFSolicitudPTO.this.JCBTipoCItemStateChanged(evt);
            }
        });
        this.JCBTipoC.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFSolicitudPTO.6
            public void keyPressed(KeyEvent evt) {
                JIFFSolicitudPTO.this.JCBTipoCKeyPressed(evt);
            }
        });
        this.JTF_NComprobante.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setHorizontalAlignment(0);
        this.JTF_NComprobante.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(JPIDatosPLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipoR, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBUnidadF, -2, 308, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFValorPpt, -1, 108, 32767)).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JCBTipoC, -2, 220, -2).addGap(366, 366, 366).addComponent(this.JTF_NComprobante, -1, 117, 32767))).addContainerGap()));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBUnidadF).addComponent(this.JDFFechaC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPTipoR, -2, 50, -2).addComponent(this.JTFFValorPpt)).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoC, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTF_NComprobante, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.jScrollPane1, -2, 205, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosP, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBBienesActionPerformed(ActionEvent evt) {
        this.xIdTipoSolicitud = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBServiciosActionPerformed(ActionEvent evt) {
        this.xIdTipoSolicitud = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoC.getSelectedIndex() != -1) {
            mConcecutivo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoC.transferFocus();
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT MAX(`NConsecutivo`) AS MaximoCons FROM `cc_r_requisicion`\n WHERE (`Id_TipoDoc` ='" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "' \n AND `Estado` =1 AND DATE_FORMAT(cc_r_requisicion.`FechaR`, '%Y')='" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + "')";
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
            this.JTF_NComprobante.setText("" + (Con + 1));
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSolicitudPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    public void mNuevo() {
        this.xlleno = false;
        Principal.mLimpiarDatosP();
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCBUnidadF.removeAllItems();
        String sql = "SELECT cc_unidad_funcional.Id , cc_unidad_funcional.Nbre, g_persona.`Correo`,rh_unidad_funcional.`Id_Persona` FROM cc_unidad_funcional_rrhhuf  INNER JOIN rh_unidad_funcional  ON (cc_unidad_funcional_rrhhuf.Id_UF_RRHH = rh_unidad_funcional.Id) INNER JOIN cc_unidad_funcional  ON (cc_unidad_funcional_rrhhuf.Id_Unidad_Funcional = cc_unidad_funcional.Id) INNER JOIN rh_unidadf_cargo  ON (rh_unidadf_cargo.Id_UnidadF = rh_unidad_funcional.Id) INNER JOIN rh_tipo_persona_cargon  ON (rh_tipo_persona_cargon.Id_unidadf_cargo = rh_unidadf_cargo.Id) INNER JOIN `g_persona`  ON (`rh_unidad_funcional`.`Id_Persona` = `g_persona`.`Id`) WHERE (rh_tipo_persona_cargon.Id ='" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "') GROUP BY cc_unidad_funcional.Id ORDER BY cc_unidad_funcional.Nbre ASC ";
        System.out.println("UF-->" + sql);
        this.xidunidadfuncional = this.xct.llenarComboyLista(sql, this.xidunidadfuncional, this.JCBUnidadF, 4);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JCBTipoC.removeAllItems();
        this.xidtipodoccontable = this.xct.llenarComboyLista("SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1 and EsContable=2) ORDER BY Nbre ASC", this.xidtipodoccontable, this.JCBTipoC, 3);
        this.JCBTipoC.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JRBBienes.setSelected(true);
        this.xIdTipoSolicitud = 0;
        this.JTFFValorPpt.setValue(0);
        this.JTAObservacionG.setText("");
        this.xlleno = true;
    }

    public void mGrabar() {
        if (this.JCBUnidadF.getSelectedIndex() > -1) {
            if (this.JCBTipoC.getSelectedIndex() <= -1) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoC.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFValorPpt.getValue().toString()) > 0.0d) {
                if (!this.JTAObservacionG.getText().isEmpty()) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "insert into cc_r_requisicion (FechaR, `Id_TipoDoc`, `NConsecutivo`, Id_UnidadFC, Id_Persona_cargo, TipoR, IdLider, ObservacionG, VPresupuestado, UsuarioS) Values ('" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "','" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "','" + this.JTF_NComprobante.getText() + "','" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][0] + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "','" + this.xIdTipoSolicitud + "','" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][2] + "','" + this.JTAObservacionG.getText().toUpperCase() + "','" + this.JTFFValorPpt.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            System.out.println("Inserta Sol-->" + sql);
                            Principal.txtNo.setText(this.xct.ejecutarSQLId(sql));
                            Principal.txtEstado.setText("ACTIVA");
                            this.xct.cerrarConexionBd();
                            return;
                        }
                        return;
                    }
                    if (this.xIdDisponibilidad.equals("0")) {
                        int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x2 == 0) {
                            String sql2 = "UPDATE  `cc_r_requisicion`\nSET  `FechaR` = '" + this.xmt.formatoAMD.format(this.JDFFechaC.getDate()) + "',\n  `Id_UnidadFC` = '" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][0] + "',\n  `Id_Persona_cargo` = '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "',\n  `TipoR` = '" + this.xIdTipoSolicitud + "',\n  `ObservacionG` = '" + this.JTAObservacionG.getText().toUpperCase() + "',\n  `VPresupuestado` = '" + this.JTFFValorPpt.getValue() + "',\n  `IdLider` = '" + this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][2] + "',\n  `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\n WHERE `Id` = '" + Principal.txtNo.getText() + "';";
                            System.out.println("Actualiza Sol-->" + sql2);
                            this.xct.ejecutarSQL(sql2);
                            this.xct.cerrarConexionBd();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Esta Solicitud no se puede actualizar,\n tiene la disponibilidad No." + this.xIdDisponibilidad + " asignada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar el Concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTAObservacionG.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El Valor debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFValorPpt.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBUnidadF.requestFocus();
    }

    public void mBuscar() {
        this.xjifbuscarorden = new JIFConsultarDatosV(this);
        Principal.cargarPantalla(this.xjifbuscarorden);
    }

    public void mImprimir() {
        if (!Principal.txtNo.getText().isEmpty()) {
            String[][] mparametros = new String[4][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = Principal.txtNo.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.JRBBienes.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_SolicutudServ", mparametros);
            } else if (this.JRBServicios.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_SolicutudServ", mparametros);
            }
        }
    }

    public void mConsultaSolicitud() {
        String sql = "SELECT\n    `cc_r_requisicion`.`Id`\n    , `cc_r_requisicion`.`FechaR`\n    , `cc_unidad_funcional`.`Nbre` AS UF \n    , `cc_r_requisicion`.`TipoR`\n    , `cc_r_requisicion`.`ObservacionG`\n    , `cc_r_requisicion`.`VPresupuestado`\n    , `cc_r_requisicion`.`IdDisponibilidad`  , `cc_r_requisicion`.`NConsecutivo` , `cc_tipo_documentoc`.`Nbre` AS TipoDoc\nFROM `cc_r_requisicion` INNER JOIN  `cc_unidad_funcional`  ON (`cc_r_requisicion`.`Id_UnidadFC` = `cc_unidad_funcional`.`Id`) INNER JOIN `cc_tipo_documentoc`   ON (`cc_tipo_documentoc`.`Id` = `cc_r_requisicion`.`Id_TipoDoc`)\nWHERE (`cc_r_requisicion`.`Id` ='" + Principal.txtNo.getText() + "');";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JDFFechaC.setDate(xrs.getDate("FechaR"));
                this.xIdDisponibilidad = xrs.getString("IdDisponibilidad");
                this.JCBUnidadF.setSelectedItem(xrs.getString("UF"));
                if (xrs.getString("TipoR").equals("0")) {
                    this.JRBBienes.setSelected(true);
                    this.xIdTipoSolicitud = 0;
                } else {
                    this.JRBServicios.setSelected(true);
                    this.xIdTipoSolicitud = 1;
                }
                this.JTFFValorPpt.setValue(Double.valueOf(xrs.getDouble("VPresupuestado")));
                this.JTAObservacionG.setText(xrs.getString("ObservacionG"));
                this.JCBTipoC.setSelectedItem(xrs.getString("TipoDoc"));
                this.JTF_NComprobante.setText(xrs.getString("NConsecutivo"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSolicitudPTO.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mAnular() {
        if (!Principal.txtNo.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "PP_Solicitud", 26);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    public void mAnular_Registro(String xIdMot, String xObservacion) {
        Principal.xclasePresupuesto.mAnularSolicitud(xIdMot, xObservacion, Principal.txtNo.getText());
        Principal.txtEstado.setText("ANULADO");
    }
}
