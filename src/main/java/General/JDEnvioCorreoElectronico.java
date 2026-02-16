package General;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Enviar_Correo_Electronico;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:General/JDEnvioCorreoElectronico.class */
public class JDEnvioCorreoElectronico extends JDialog {
    private boolean xlleno;
    private String[][] xdservidor;
    private ConsultasMySQL xct;
    private Metodos xmt;
    private String xrautenticacion;
    private String xrseguridad;
    private String xruta;
    private String xcorreou;
    private String xcuerpo;
    private String xasunto;
    private JButton JBTResultadoDefecto2;
    private JButton JBTSalir;
    private JComboBox JCBNServidor;
    private JCheckBox JCHRAutenticacion;
    private JCheckBox JCHRSeguridad;
    private JPasswordField JPFContrasena;
    private JPanel JPIDServidor;
    private JPanel JPIMensaje;
    private JScrollPane JSPCMensaje;
    private JSpinner JSPPuerto;
    private JTextField JTFAsunto;
    private JTextField JTFCC;
    private JTextField JTFPara;
    private JTextField JTFUsuario;
    private JTextPane JTPCMensaje;
    private JTabbedPane JTPDatos;

    public JDEnvioCorreoElectronico(Frame parent, boolean modal, String xid) {
        super(parent, modal);
        this.xlleno = false;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xrautenticacion = "false";
        this.xrseguridad = "false";
        this.xruta = "";
        this.xcorreou = "";
        this.xcuerpo = "";
        this.xasunto = "";
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.JTPDatos.setEnabledAt(1, false);
        mNuevo();
    }

    public JDEnvioCorreoElectronico(Frame parent, boolean modal, String xruta, String xcorreou, String xcuerpo, String xasunto) {
        super(parent, modal);
        this.xlleno = false;
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xrautenticacion = "false";
        this.xrseguridad = "false";
        this.xruta = "";
        this.xcorreou = "";
        this.xcuerpo = "";
        this.xasunto = "";
        initComponents();
        this.JTPDatos.setEnabledAt(1, false);
        this.xruta = xruta;
        this.xcorreou = xcorreou;
        this.xasunto = xasunto;
        this.xcuerpo = xcuerpo;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        mNuevo();
    }

    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPIMensaje = new JPanel();
        this.JTFPara = new JTextField();
        this.JTFCC = new JTextField();
        this.JTFAsunto = new JTextField();
        this.JSPCMensaje = new JScrollPane();
        this.JTPCMensaje = new JTextPane();
        this.JBTResultadoDefecto2 = new JButton("<html><center><b><u>E</u>nviar Resultado</b></html>");
        this.JBTSalir = new JButton();
        this.JPIDServidor = new JPanel();
        this.JCBNServidor = new JComboBox();
        this.JSPPuerto = new JSpinner();
        this.JCHRAutenticacion = new JCheckBox();
        this.JCHRSeguridad = new JCheckBox();
        this.JTFUsuario = new JTextField();
        this.JPFContrasena = new JPasswordField();
        setDefaultCloseOperation(2);
        setTitle("ENVIAR CORREO ELECTRONICO");
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTFPara.setFont(new Font("Arial", 1, 12));
        this.JTFPara.setBorder(BorderFactory.createTitledBorder((Border) null, "Para:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCC.setFont(new Font("Arial", 1, 12));
        this.JTFCC.setBorder(BorderFactory.createTitledBorder((Border) null, "CC:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFAsunto.setFont(new Font("Arial", 1, 12));
        this.JTFAsunto.setBorder(BorderFactory.createTitledBorder((Border) null, "Asunto:", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPCMensaje.setBorder(BorderFactory.createTitledBorder((Border) null, "MENSAJE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPCMensaje.setContentType("text/html");
        this.JTPCMensaje.setFont(new Font("Arial", 1, 12));
        this.JSPCMensaje.setViewportView(this.JTPCMensaje);
        this.JBTResultadoDefecto2.setFont(new Font("Arial", 1, 12));
        this.JBTResultadoDefecto2.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo_2.png")));
        this.JBTResultadoDefecto2.setText("Enviar");
        this.JBTResultadoDefecto2.setToolTipText("");
        this.JBTResultadoDefecto2.addActionListener(new ActionListener() { // from class: General.JDEnvioCorreoElectronico.1
            public void actionPerformed(ActionEvent evt) {
                JDEnvioCorreoElectronico.this.JBTResultadoDefecto2ActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: General.JDEnvioCorreoElectronico.2
            public void actionPerformed(ActionEvent evt) {
                JDEnvioCorreoElectronico.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout JPIMensajeLayout = new GroupLayout(this.JPIMensaje);
        this.JPIMensaje.setLayout(JPIMensajeLayout);
        JPIMensajeLayout.setHorizontalGroup(JPIMensajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMensajeLayout.createSequentialGroup().addGap(20, 20, 20).addGroup(JPIMensajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFAsunto).addGroup(JPIMensajeLayout.createSequentialGroup().addComponent(this.JTFPara, -2, 255, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, 32767).addComponent(this.JTFCC, -2, 255, -2)).addGroup(JPIMensajeLayout.createSequentialGroup().addComponent(this.JBTResultadoDefecto2, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 250, -2)).addComponent(this.JSPCMensaje)).addContainerGap()));
        JPIMensajeLayout.setVerticalGroup(JPIMensajeLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMensajeLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIMensajeLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFPara, -2, -1, -2).addComponent(this.JTFCC, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, 32767).addComponent(this.JTFAsunto, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCMensaje, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIMensajeLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTSalir, -2, 50, -2).addComponent(this.JBTResultadoDefecto2, -2, 50, -2)).addContainerGap()));
        this.JTPDatos.addTab("MENSAJE", this.JPIMensaje);
        this.JCBNServidor.setFont(new Font("Arial", 1, 12));
        this.JCBNServidor.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBNServidor.addItemListener(new ItemListener() { // from class: General.JDEnvioCorreoElectronico.3
            public void itemStateChanged(ItemEvent evt) {
                JDEnvioCorreoElectronico.this.JCBNServidorItemStateChanged(evt);
            }
        });
        this.JSPPuerto.setFont(new Font("Arial", 1, 12));
        this.JSPPuerto.setModel(new SpinnerNumberModel());
        this.JSPPuerto.setBorder(BorderFactory.createTitledBorder((Border) null, "Puerto", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHRAutenticacion.setFont(new Font("Arial", 1, 12));
        this.JCHRAutenticacion.setText("Requiere Autenticación?");
        this.JCHRAutenticacion.addActionListener(new ActionListener() { // from class: General.JDEnvioCorreoElectronico.4
            public void actionPerformed(ActionEvent evt) {
                JDEnvioCorreoElectronico.this.JCHRAutenticacionActionPerformed(evt);
            }
        });
        this.JCHRSeguridad.setFont(new Font("Arial", 1, 12));
        this.JCHRSeguridad.setText("Requiere Seguridad?");
        this.JCHRSeguridad.addActionListener(new ActionListener() { // from class: General.JDEnvioCorreoElectronico.5
            public void actionPerformed(ActionEvent evt) {
                JDEnvioCorreoElectronico.this.JCHRSeguridadActionPerformed(evt);
            }
        });
        this.JTFUsuario.setFont(new Font("Arial", 1, 12));
        this.JTFUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPFContrasena.setFont(new Font("Arial", 1, 12));
        this.JPFContrasena.setBorder(BorderFactory.createTitledBorder((Border) null, "Contraseña", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDServidorLayout = new GroupLayout(this.JPIDServidor);
        this.JPIDServidor.setLayout(JPIDServidorLayout);
        JPIDServidorLayout.setHorizontalGroup(JPIDServidorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDServidorLayout.createSequentialGroup().addContainerGap().addGroup(JPIDServidorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDServidorLayout.createSequentialGroup().addComponent(this.JCBNServidor, -2, 320, -2).addGap(30, 30, 30).addComponent(this.JSPPuerto, -2, 78, -2).addGap(18, 18, 18).addGroup(JPIDServidorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHRAutenticacion).addComponent(this.JCHRSeguridad)).addGap(0, 0, 32767)).addGroup(JPIDServidorLayout.createSequentialGroup().addComponent(this.JTFUsuario, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JPFContrasena, -2, 250, -2))).addContainerGap(-1, 32767)));
        JPIDServidorLayout.setVerticalGroup(JPIDServidorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDServidorLayout.createSequentialGroup().addContainerGap().addGroup(JPIDServidorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDServidorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBNServidor, -2, 50, -2).addComponent(this.JSPPuerto, -2, 50, -2)).addGroup(JPIDServidorLayout.createSequentialGroup().addComponent(this.JCHRAutenticacion).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHRSeguridad))).addGap(30, 30, 30).addGroup(JPIDServidorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUsuario, -2, 50, -2).addComponent(this.JPFContrasena, -2, 50, -2)).addContainerGap(162, 32767)));
        this.JTPDatos.addTab("DATOS SERVIDOR", this.JPIDServidor);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTResultadoDefecto2ActionPerformed(ActionEvent evt) {
        if (!this.JTFUsuario.getText().isEmpty()) {
            if (!this.JTFPara.getText().isEmpty()) {
                if (!this.JTFAsunto.getText().isEmpty()) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de enviar el correo?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        new Enviar_Correo_Electronico(this.JTFUsuario.getText(), this.JTFAsunto.getText(), this.JTPCMensaje.getText(), this.xruta, this.xruta, this.JTFPara.getText(), this.JTFCC.getText());
                        dispose();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe registrar el asunto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPDatos.setSelectedIndex(0);
                this.JTFAsunto.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe registrar el destinatario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPDatos.setSelectedIndex(0);
            this.JTFPara.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRAutenticacionActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRSeguridadActionPerformed(ActionEvent evt) {
        mIniciarCheck();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBNServidorItemStateChanged(ItemEvent evt) {
        if (this.JCBNServidor.getSelectedIndex() != -1 && this.xlleno) {
            if (this.xdservidor[this.JCBNServidor.getSelectedIndex()][2].equals("1")) {
                this.JCHRAutenticacion.setSelected(true);
            } else {
                this.JCHRAutenticacion.setSelected(false);
            }
            if (this.xdservidor[this.JCBNServidor.getSelectedIndex()][3].equals("1")) {
                this.JCHRSeguridad.setSelected(true);
            } else {
                this.JCHRSeguridad.setSelected(false);
            }
            this.JSPPuerto.setValue(new Integer(this.xdservidor[this.JCBNServidor.getSelectedIndex()][4].toString()));
            this.JTFUsuario.setText(this.xdservidor[this.JCBNServidor.getSelectedIndex()][5].toString());
            this.JPFContrasena.setText(this.xdservidor[this.JCBNServidor.getSelectedIndex()][6].toString());
            mIniciarCheck();
        }
    }

    private void mIniciarCheck() {
        if (this.JCHRSeguridad.isSelected()) {
            this.xrseguridad = "true";
        } else {
            this.xrseguridad = "false";
        }
        if (this.JCHRAutenticacion.isSelected()) {
            this.xrautenticacion = "true";
        } else {
            this.xrautenticacion = "false";
        }
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCBNServidor.removeAllItems();
        this.xdservidor = this.xct.llenarComboyLista("SELECT `Id`, `Nbre`, `DServidor`, `RAutenticacion` , `RSeguridad`, Puerto, usuario, contrasena FROM `g_servidores_correo` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xdservidor, this.JCBNServidor, 8);
        if (this.xdservidor.length > 1) {
            this.JCBNServidor.setSelectedIndex(-1);
        } else {
            if (this.xdservidor[this.JCBNServidor.getSelectedIndex()][2].equals("1")) {
                this.JCHRAutenticacion.setSelected(true);
            } else {
                this.JCHRAutenticacion.setSelected(false);
            }
            if (this.xdservidor[this.JCBNServidor.getSelectedIndex()][3].equals("1")) {
                this.JCHRSeguridad.setSelected(true);
            } else {
                this.JCHRSeguridad.setSelected(false);
            }
            this.JTFUsuario.setText(this.xdservidor[this.JCBNServidor.getSelectedIndex()][5].toString());
            this.JPFContrasena.setText(this.xdservidor[this.JCBNServidor.getSelectedIndex()][6].toString());
            this.JSPPuerto.setValue(new Integer(this.xdservidor[this.JCBNServidor.getSelectedIndex()][4].toString()));
            mIniciarCheck();
        }
        this.JTFPara.setText("");
        this.JTFCC.setText("");
        this.JTFAsunto.setText("");
        this.JTPCMensaje.setText("");
        System.err.println("Correo::" + Principal.usuarioSistemaDTO.getCorreoUsuario());
        mIniciarComponentes();
        this.xlleno = true;
    }

    private void mIniciarComponentes() {
        this.JTFAsunto.setText(this.xasunto);
        this.JTFPara.setText(this.xcorreou);
        this.JTPCMensaje.setText(this.xcuerpo);
    }
}
