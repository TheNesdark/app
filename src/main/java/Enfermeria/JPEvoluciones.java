package Enfermeria;

import Acceso.Principal;
import Historia.JPORemisiones;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
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
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Enfermeria/JPEvoluciones.class */
public class JPEvoluciones extends JPanel {
    private String xsql;
    private String xnAtencion;
    private String[] xidespecialidad;
    private String[] xidtiponota;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBTipoNota;
    private JCheckBox JCHFiltro;
    private JDateChooser JDCFecha;
    private JPanel JPIDFiltro;
    private JScrollPane JSPHistoricoA;
    private JScrollPane JSPNota;
    private JTextArea JTANota;
    private JFormattedTextField JTFFHora;
    public JTextField JTFNNota;
    private JTextPane JTPHistoricoA;
    private JPanel jPanel1;
    private JTabbedPane jTabbedPane1;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;

    public JPEvoluciones(String xnAtencion) {
        initComponents();
        this.xnAtencion = xnAtencion;
        mNuevo();
        mConsultarHistorico();
        this.JTPHistoricoA.requestFocus();
    }

    private void initComponents() {
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel1 = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBTipoNota = new JComboBox();
        this.JTFNNota = new JTextField();
        this.JSPNota = new JScrollPane();
        this.JTANota = new JTextArea();
        this.JPIDFiltro = new JPanel();
        this.JCBEspecialidad = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JSPHistoricoA = new JScrollPane();
        this.JTPHistoricoA = new JTextPane();
        setAutoscrolls(true);
        setName("xjpevolucion");
        this.jTabbedPane1.setForeground(new Color(0, 103, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
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
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNNota.setEditable(false);
        this.JTFNNota.setFont(new Font("Arial", 1, 24));
        this.JTFNNota.setHorizontalAlignment(0);
        this.JTFNNota.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNNota.setFocusable(false);
        this.JSPNota.setBorder(BorderFactory.createTitledBorder((Border) null, "NOTA CLÍNICA", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTANota.setColumns(20);
        this.JTANota.setFont(new Font("Arial", 1, 12));
        this.JTANota.setLineWrap(true);
        this.JTANota.setRows(1);
        this.JTANota.setTabSize(1);
        this.JTANota.setBorder((Border) null);
        this.JTANota.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JPEvoluciones.1
            public void keyPressed(KeyEvent evt) {
                JPEvoluciones.this.JTANotaKeyPressed(evt);
            }
        });
        this.JSPNota.setViewportView(this.JTANota);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPNota).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDCFecha, -2, 128, -2).addGap(18, 18, 18).addComponent(this.JTFFHora, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoNota, -2, 376, -2).addGap(18, 18, 18).addComponent(this.JTFNNota, -2, 155, -2).addGap(0, 0, 32767))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoNota, -1, 50, 32767).addComponent(this.JTFNNota, -2, 50, -2)).addComponent(this.JDCFecha, GroupLayout.Alignment.LEADING, -1, 53, 32767).addComponent(this.JTFFHora, GroupLayout.Alignment.LEADING, -1, 53, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPNota, -1, 343, 32767).addContainerGap()));
        this.jTabbedPane1.addTab("EVOLUCIÓN", this.jPanel1);
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Enfermeria.JPEvoluciones.2
            public void itemStateChanged(ItemEvent evt) {
                JPEvoluciones.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBEspecialidad.addKeyListener(new KeyAdapter() { // from class: Enfermeria.JPEvoluciones.3
            public void keyPressed(KeyEvent evt) {
                JPEvoluciones.this.JCBEspecialidadKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Aplicar filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Enfermeria.JPEvoluciones.4
            public void actionPerformed(ActionEvent evt) {
                JPEvoluciones.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JSPHistoricoA.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTPHistoricoA.setEditable(false);
        this.JTPHistoricoA.setContentType("text/html");
        this.JTPHistoricoA.setFont(new Font("Arial", 1, 12));
        this.JTPHistoricoA.setCursor(new Cursor(0));
        this.JSPHistoricoA.setViewportView(this.JTPHistoricoA);
        GroupLayout JPIDFiltroLayout = new GroupLayout(this.JPIDFiltro);
        this.JPIDFiltro.setLayout(JPIDFiltroLayout);
        JPIDFiltroLayout.setHorizontalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistoricoA, -2, 797, -2).addGroup(JPIDFiltroLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 445, -2).addGap(42, 42, 42).addComponent(this.JCHFiltro))).addContainerGap(14, 32767)));
        JPIDFiltroLayout.setVerticalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -1, 50, 32767).addComponent(this.JCHFiltro)).addGap(18, 18, 18).addComponent(this.JSPHistoricoA, -2, 407, -2).addGap(0, 0, 32767)));
        this.jTabbedPane1.addTab("HISTÓRICO", this.JPIDFiltro);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -2, 460, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBEspecialidad.getSelectedIndex() != -1) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBEspecialidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTANotaKeyPressed(KeyEvent evt) {
        this.xmt.valiacionCaracterComillaSimpleTextArea(evt, this.JTANota);
    }

    public void mGrabar() {
        if (this.JTFNNota.getText().isEmpty()) {
            if (!this.JTANota.getText().isEmpty()) {
                if (this.JTFNNota.getText().isEmpty()) {
                    if (this.JCBTipoNota.getSelectedIndex() != -1) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            String sql = "insert into  h_notasclinicas (Id_Atencion, Id_Tipo_Atencion, FechaNota, HoraNota, Id_TipoNota, Descripcion, Id_Profesional, Id_Especialidad,Fecha, UsuarioS) values ('" + Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText() + "','" + Principal.claseenfer.xjifhc_uhh.xId_TipoAtencion + "','" + this.xmt.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + this.xidtiponota[this.JCBTipoNota.getSelectedIndex()] + "','" + this.JTANota.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.JTFNNota.setText(this.xct.ejecutarSQLId(sql));
                            this.xct.cerrarConexionBd();
                            mConsultarHistorico();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBTipoNota.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe tener una atencion activa ", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNNota.requestFocus();
        }
    }

    private void mBuscar() {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                mConsultarHistorico();
                return;
            }
            return;
        }
        mConsultarHistorico();
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JTFNNota.setText("");
        this.JTANota.setText("");
        this.JCBTipoNota.removeAllItems();
        this.xsql = "SELECT `h_tiponota`.`Id` , `h_tiponota`.`Nbre` FROM `h_tiponota_especialidad` INNER JOIN  `h_tiponota`  ON (`h_tiponota_especialidad`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_tiponota_especialidad`.`Id_Especialidad` ='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "' AND `h_tiponota_especialidad`.`Estado` =1) ORDER BY `h_tiponota`.`Nbre` ASC ";
        this.xidtiponota = this.xct.llenarCombo(this.xsql, this.xidtiponota, this.JCBTipoNota);
        this.JCBTipoNota.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        mLLenarCombo();
    }

    private void mLLenarCombo() {
        ConsultasMySQL xct4 = new ConsultasMySQL();
        this.xlleno = true;
        this.JCBEspecialidad.removeAllItems();
        this.xsql = "SELECT  `profesional1`.`IdEspecialidad`  , `profesional1`.`Especialidad` FROM `profesional1` INNER JOIN  `h_notasclinicas`   ON (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) WHERE (`h_notasclinicas`.`Id_Atencion` ='" + Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText() + "' AND `h_notasclinicas`.`Estado` =1) GROUP BY `profesional1`.`IdEspecialidad` ORDER BY `profesional1`.`Especialidad` ASC ";
        this.xidespecialidad = xct4.llenarCombo(this.xsql, this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        xct4.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mConsultarHistorico() {
        try {
            if (this.JCHFiltro.isSelected()) {
                this.xsql = "SELECT `h_notasclinicas`.`FechaNota` , `h_notasclinicas`.`HoraNota` , `h_tiponota`.`Nbre` , `h_notasclinicas`.`Descripcion`  , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` FROM `profesional1`  INNER JOIN  `h_notasclinicas`  ON (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) INNER JOIN  `h_tiponota`   ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_notasclinicas`.`Id_Atencion` ='" + Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText() + "' AND `h_notasclinicas`.`Estado` =1 AND `h_notasclinicas`.`Id_Especialidad` ='" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY `h_notasclinicas`.`FechaNota` DESC, `h_notasclinicas`.`HoraNota` DESC ";
            } else {
                this.xsql = "SELECT `h_notasclinicas`.`FechaNota` , `h_notasclinicas`.`HoraNota` , `h_tiponota`.`Nbre` , `h_notasclinicas`.`Descripcion`  , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` FROM `profesional1`  INNER JOIN  `h_notasclinicas`  ON (`profesional1`.`IdEspecialidad` = `h_notasclinicas`.`Id_Especialidad`) AND (`profesional1`.`Id_Persona` = `h_notasclinicas`.`Id_Profesional`) INNER JOIN  `h_tiponota`   ON (`h_notasclinicas`.`Id_TipoNota` = `h_tiponota`.`Id`) WHERE (`h_notasclinicas`.`Id_Atencion` ='" + Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText() + "' AND `h_notasclinicas`.`Estado` =1) ORDER BY `h_notasclinicas`.`FechaNota` DESC, `h_notasclinicas`.`HoraNota` DESC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            String xparte3 = "";
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    String xparte1 = "<font face='Arial' color='red' size=4>" + xrs.getString(1) + "  -  " + xrs.getString(2) + " - " + xrs.getString(3) + "</font><br>";
                    String xparte2 = "<font face='Arial' color='red' size=4>" + xrs.getString(5) + "  -  " + xrs.getString(6) + "</font><br>";
                    xparte3 = xparte3 + " " + xparte1 + " " + xparte2 + " " + xrs.getString(4) + "<br>--------------------------------------------------------------------------------------<br>";
                }
            }
            this.JTPHistoricoA.setText(xparte3);
            this.JTPHistoricoA.setCaretPosition(0);
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPORemisiones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
