package Enfermeria;

import Acceso.Principal;
import General.Anular;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPControlDiabetes.class */
public class JPControlDiabetes extends JPanel {
    private DefaultTableModel xmodelo;
    private Object[] xdato;
    private String[] xIdVia;
    private ButtonGroup JBG;
    private ButtonGroup JBGInsulina;
    private JComboBox JCBVia;
    private JDateChooser JDCFecha;
    private JRadioButton JRBCrist;
    private JRadioButton JRBDest;
    private JRadioButton JRBMult;
    private JRadioButton JRBNoAplica;
    private JRadioButton JRBNph;
    private JRadioButton JRBOtra;
    private JRadioButton JRPost;
    private JRadioButton JRPre;
    private JTable JTDetalle;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFResultado;
    private JTextField JTFResultadoIns;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTObservacion;
    Metodos xmt = new Metodos();
    private String xidatencion = "";
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xTipoM = 0;
    private int xTipoIns = 0;
    private Integer tipoPrandial = 0;

    public JPControlDiabetes(String xNombre) {
        initComponents();
        setName(xNombre);
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        mRealizarCasting(xNombre);
        this.xIdVia = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM `i_viaadministracion` WHERE (`AplicaHC`=1 AND `Estado`=0)", this.xIdVia, this.JCBVia);
        this.JCBVia.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFResultado.setValue(0);
        mBuscar();
    }

    /* JADX WARN: Type inference failed for: r3v106, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG = new ButtonGroup();
        this.JBGInsulina = new ButtonGroup();
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.JRBDest = new JRadioButton();
        this.JRBMult = new JRadioButton();
        this.JTFResultado = new JFormattedTextField();
        this.jPanel3 = new JPanel();
        this.JRBNph = new JRadioButton();
        this.JRBCrist = new JRadioButton();
        this.JTFResultadoIns = new JTextField();
        this.JCBVia = new JComboBox();
        this.JRBNoAplica = new JRadioButton();
        this.JRBOtra = new JRadioButton();
        this.jScrollPane2 = new JScrollPane();
        this.jTObservacion = new JTextArea();
        this.jPanel5 = new JPanel();
        this.JRPre = new JRadioButton();
        this.JRPost = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setMaximumSize(new Dimension(846, 482));
        setName("jpcontroldiabetes");
        setPreferredSize(new Dimension(846, 482));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setToolTipText("Formato 24 horas (HH:mm:ss)");
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        this.JBG.add(this.JRBDest);
        this.JRBDest.setFont(new Font("Arial", 1, 12));
        this.JRBDest.setSelected(true);
        this.JRBDest.setText("DESTROSTIX");
        this.JRBDest.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlDiabetes.1
            public void actionPerformed(ActionEvent evt) {
                JPControlDiabetes.this.JRBDestActionPerformed(evt);
            }
        });
        this.JBG.add(this.JRBMult);
        this.JRBMult.setFont(new Font("Arial", 1, 12));
        this.JRBMult.setText("MULTISTIX");
        this.JRBMult.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlDiabetes.2
            public void actionPerformed(ActionEvent evt) {
                JPControlDiabetes.this.JRBMultActionPerformed(evt);
            }
        });
        this.JTFResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Pba. en S (mg/dl)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFResultado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.#"))));
        this.JTFResultado.setHorizontalAlignment(4);
        this.JTFResultado.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JRBDest).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBMult).addGap(18, 18, 18).addComponent(this.JTFResultado).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBDest).addComponent(this.JRBMult)).addContainerGap()).addComponent(this.JTFResultado));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "INSULINA", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JBGInsulina.add(this.JRBNph);
        this.JRBNph.setFont(new Font("Arial", 1, 12));
        this.JRBNph.setText("NPH");
        this.JRBNph.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlDiabetes.3
            public void actionPerformed(ActionEvent evt) {
                JPControlDiabetes.this.JRBNphActionPerformed(evt);
            }
        });
        this.JBGInsulina.add(this.JRBCrist);
        this.JRBCrist.setFont(new Font("Arial", 1, 12));
        this.JRBCrist.setText("Cristalina");
        this.JRBCrist.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlDiabetes.4
            public void actionPerformed(ActionEvent evt) {
                JPControlDiabetes.this.JRBCristActionPerformed(evt);
            }
        });
        this.JTFResultadoIns.setFont(new Font("Arial", 1, 12));
        this.JTFResultadoIns.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidades", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBVia.setFont(new Font("Arial", 1, 12));
        this.JCBVia.setBorder(BorderFactory.createTitledBorder((Border) null, "Vía", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGInsulina.add(this.JRBNoAplica);
        this.JRBNoAplica.setFont(new Font("Arial", 1, 12));
        this.JRBNoAplica.setText("No Aplica");
        this.JRBNoAplica.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlDiabetes.5
            public void actionPerformed(ActionEvent evt) {
                JPControlDiabetes.this.JRBNoAplicaActionPerformed(evt);
            }
        });
        this.JBGInsulina.add(this.JRBOtra);
        this.JRBOtra.setFont(new Font("Arial", 1, 12));
        this.JRBOtra.setText("Otra");
        this.JRBOtra.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlDiabetes.6
            public void actionPerformed(ActionEvent evt) {
                JPControlDiabetes.this.JRBOtraActionPerformed(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JRBNph).addGap(4, 4, 4).addComponent(this.JRBCrist).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBOtra).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNoAplica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFResultadoIns, -2, 226, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBVia, 0, 173, 32767).addContainerGap()));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNph).addComponent(this.JRBCrist).addComponent(this.JTFResultadoIns, -2, 39, -2).addComponent(this.JCBVia, -2, -1, -2).addComponent(this.JRBNoAplica).addComponent(this.JRBOtra)).addContainerGap(-1, 32767)));
        this.jTObservacion.setColumns(20);
        this.jTObservacion.setRows(5);
        this.jTObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 51, 255)));
        this.jScrollPane2.setViewportView(this.jTObservacion);
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "PRANDIAL", 0, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.buttonGroup1.add(this.JRPre);
        this.JRPre.setFont(new Font("Arial", 1, 12));
        this.JRPre.setText("PRE");
        this.JRPre.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlDiabetes.7
            public void actionPerformed(ActionEvent evt) {
                JPControlDiabetes.this.JRPreActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRPost);
        this.JRPost.setFont(new Font("Arial", 1, 12));
        this.JRPost.setSelected(true);
        this.JRPost.setText("POST");
        this.JRPost.addActionListener(new ActionListener() { // from class: Enfermeria.JPControlDiabetes.8
            public void actionPerformed(ActionEvent evt) {
                JPControlDiabetes.this.JRPostActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRPre, -2, 88, -2).addComponent(this.JRPost, -2, 88, -2)).addContainerGap(8, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.JRPre, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRPost).addGap(31, 31, 31)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDCFecha, -2, 128, -2).addGap(18, 18, 18).addComponent(this.JTFFHora, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -1, -1, 32767)).addComponent(this.jScrollPane2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -1, -1, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFHora).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.JDCFecha, -1, -1, 32767)).addGap(31, 31, 31).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel5, -2, 64, -2).addComponent(this.jPanel3, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane2, -2, -1, -2)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane1, -2, 207, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDestActionPerformed(ActionEvent evt) {
        this.JTFResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Pba. en S", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xTipoM = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMultActionPerformed(ActionEvent evt) {
        this.JTFResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Pba. en Orina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.xTipoM = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNphActionPerformed(ActionEvent evt) {
        this.xTipoIns = 0;
        this.JCBVia.setSelectedIndex(-1);
        this.JTFResultadoIns.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCristActionPerformed(ActionEvent evt) {
        this.xTipoIns = 1;
        this.JCBVia.setSelectedIndex(-1);
        this.JTFResultadoIns.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoAplicaActionPerformed(ActionEvent evt) {
        this.xTipoIns = -1;
        this.JCBVia.setSelectedItem("NO APLICA");
        this.JTFResultadoIns.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOtraActionPerformed(ActionEvent evt) {
        this.xTipoIns = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRPreActionPerformed(ActionEvent evt) {
        this.tipoPrandial = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRPostActionPerformed(ActionEvent evt) {
        this.tipoPrandial = 1;
    }

    public void mGuardar() {
        if (this.JRBNoAplica.isSelected()) {
            if (this.JCBVia.getSelectedIndex() != -1) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    String sql = "INSERT INTO  `h_orden_control_diabetes`  (  `IdAtencion`, `FechaR`, `Hora`, `TipoMuestra`, `ValorM`, `TipoInsulina`,\n             `ValorIns`, `IdViaAdmin`, `IdProfesional`, `IdEspecialidad`, `UsuarioS`, `Observacion` , `Prandial`)\n VALUES ( '" + this.xidatencion + "', '" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "', '" + this.JTFFHora.getText() + "', '" + this.xTipoM + "',  '" + this.JTFResultado.getValue() + "', '" + this.xTipoIns + "',  '" + this.JTFResultadoIns.getText() + "',\n        '" + this.xIdVia[this.JCBVia.getSelectedIndex()] + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + this.jTObservacion.getText() + "', '" + this.tipoPrandial + "');";
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                    this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                    mBuscar();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la vía de administración", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBVia.requestFocus();
            return;
        }
        if (!this.JTFResultado.getText().equals("0")) {
            if (!this.JTFResultadoIns.getText().isEmpty()) {
                if (this.JCBVia.getSelectedIndex() != -1) {
                    int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x2 == 0) {
                        String sql2 = "INSERT INTO  `h_orden_control_diabetes`  (  `IdAtencion`, `FechaR`, `Hora`, `TipoMuestra`, `ValorM`, `TipoInsulina`,\n             `ValorIns`, `IdViaAdmin`, `IdProfesional`, `IdEspecialidad`, `UsuarioS`, `Observacion` , `Prandial`)\n VALUES ( '" + this.xidatencion + "', '" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "', '" + this.JTFFHora.getText() + "', '" + this.xTipoM + "',  '" + this.JTFResultado.getValue() + "', '" + this.xTipoIns + "',  '" + this.JTFResultadoIns.getText() + "',\n        '" + this.xIdVia[this.JCBVia.getSelectedIndex()] + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + Principal.usuarioSistemaDTO.getLogin() + "', '" + this.jTObservacion.getText() + "', '" + this.tipoPrandial + "');";
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                        this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                        mBuscar();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la vía de administración", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBVia.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar las unidades de Insulina", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFResultadoIns.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "el resultado debe ser diferente de Cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFResultado.requestFocus();
    }

    public void mNuevo() {
        this.JRBDest.setSelected(true);
        this.JTFResultado.setValue(0);
        this.JRBNph.setSelected(true);
        this.JTFResultadoIns.setText("");
        this.JCBVia.setSelectedIndex(-1);
        this.xTipoIns = 0;
        this.xTipoM = 0;
    }

    public void mImprimir() {
        if (!this.xidatencion.equals("")) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "idatencion1";
            mparametros[0][1] = this.xidatencion;
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "Pajonal_H_ControlDiebetes", mparametros);
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "H_ControlDiebetes", mparametros);
            }
        }
    }

    public void mAnular(String xid, String xmotivo) {
        String sql = "UPDATE `h_orden_control_diabetes` SET `Id_MotivoAnulacion`= '" + xid + "', `Fecha_Anulacion`= '" + this.xmt.formatoAMD1.format(this.xmt.getFechaActual()) + "', `Detalle_Anulacion`='" + xmotivo + "', `Usuario_Anulacion`= '" + Principal.usuarioSistemaDTO.getNombreUsuario() + "', `Estado`= 0 WHERE Id='" + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10).toString() + "'";
        this.xct.ejecutarSQL(sql);
        this.xct.cerrarConexionBd();
        mNuevo();
        mBuscar();
    }

    public void mAnular() {
        if (this.JTDetalle.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "jpcontroldiabetes", 3);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un servicio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void mBuscar() {
        try {
            String sql = "SELECT `h_orden_control_diabetes`.`IdAtencion` , `h_orden_control_diabetes`.`FechaR`\n    , `h_orden_control_diabetes`.`Hora` , IF(`h_orden_control_diabetes`.`TipoMuestra`=0,'DESTROSTIX','MULTISTIX') AS TipoMuestra \n    , `h_orden_control_diabetes`.`ValorM` , IF(`h_orden_control_diabetes`.`TipoInsulina`=-1,'NO APLICA',IF(`h_orden_control_diabetes`.`TipoInsulina`=0,'NPH','CRISTALINA')) AS TipoInsulina\n    , `h_orden_control_diabetes`.`ValorIns`  , `i_viaadministracion`.`Nbre`\n    , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`, `h_orden_control_diabetes`.`Id`, `h_orden_control_diabetes`.`Observacion`, CASE  `h_orden_control_diabetes`.`Prandial`\n    \tWHEN 1\n    \t then 'PRE'\n    \tWHEN 0\n    \t then 'POST' \n    \t\tEND AS Prandial\n FROM\n    `h_orden_control_diabetes`\n    INNER JOIN `i_viaadministracion`  ON (`h_orden_control_diabetes`.`IdViaAdmin` = `i_viaadministracion`.`Id`)\n    INNER JOIN `profesional1`  ON (`h_orden_control_diabetes`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`h_orden_control_diabetes`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`)\nWHERE (`h_orden_control_diabetes`.`IdAtencion` ='" + this.xidatencion + "' AND `h_orden_control_diabetes`.Estado=1)";
            mCrearTablaHistorico();
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                int xfila = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(xrs.getString(1), xfila, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), xfila, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), xfila, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), xfila, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), xfila, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), xfila, 5);
                    this.xmodelo.setValueAt(xrs.getString(7), xfila, 6);
                    this.xmodelo.setValueAt(xrs.getString(8), xfila, 7);
                    this.xmodelo.setValueAt(xrs.getString(9), xfila, 8);
                    this.xmodelo.setValueAt(xrs.getString(10), xfila, 9);
                    this.xmodelo.setValueAt(xrs.getString(11), xfila, 10);
                    this.xmodelo.setValueAt(xrs.getString(12), xfila, 11);
                    this.xmodelo.setValueAt(xrs.getString(13), xfila, 12);
                    xfila++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPControlDiabetes.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorico() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "Hora", "Tipo", "Valor", "Insulina", "ResultadoIns", "ViaAdministracion", "Profesional", "Especialidad", "Id", "Observacion", "Prandial"}) { // from class: Enfermeria.JPControlDiabetes.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(60);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(10);
    }

    private void mRealizarCasting(String xnombre) {
        switch (xnombre) {
            case "jifControlDM_Enf":
                this.xidatencion = Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText();
                break;
            case "jifhistoriaclinica":
                this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                break;
            case "jif_historiaclinicav2":
                this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                break;
            case "jif_historiaclinicav4":
                this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                break;
        }
    }
}
