package Acceso;

import General.CambioClave;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.UsuarioSistemaDAO;
import com.genoma.plus.dao.impl.general.UsuarioSistemaDAOImpl;
import com.genoma.plus.dto.general.GeneralDTO;
import com.genoma.plus.dto.general.InformacionGeneralPrincipalDTO;
import com.genoma.plus.dto.general.InformacionIpsDTO;
import com.genoma.plus.dto.general.UsuarioSistemaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Acceso/Login.class */
public class Login extends JDialog {
    private String sql;
    private String clave;
    private String titulo;
    private String idPersona;
    private String ips;
    private String xadmin;
    private ResultSet rs;
    private ConsultasMySQL consultas;
    private Metodos metodos;
    private String[] modulos;
    private String[] xidsede;
    private String[][] xId_IPS;
    private boolean xlleno;
    private boolean xlleno1;
    private List<InformacionIpsDTO> informacionIpsDTO;
    private UsuarioSistemaDAO usuarioSistemaDAO;
    private List<UsuarioSistemaDTO> usuarioSistemaDTO;
    private List<GeneralDTO> sedeUsuarioDTO;
    private UsuarioSistemaDTO usuarioSistemaDTO1;
    Properties prop;
    InputStream input;
    private JComboBox JCBIps;
    private JComboBox JCBSede;
    private JLabel JLB_InfoBase;
    private JButton btnsalir;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JLabel lblLicencia;
    private JTextField txtNbre;
    public JPasswordField txtPassword;
    private JTextField txtUsuario;

    public Login(Frame parent, boolean modal, List<InformacionIpsDTO> informacionIpsDTO) {
        super(parent, modal);
        this.clave = "";
        this.titulo = "G@noma Plus";
        this.consultas = new ConsultasMySQL();
        this.metodos = new Metodos();
        this.xlleno = false;
        this.xlleno1 = false;
        this.prop = new Properties();
        this.input = ConsultasMySQL.class.getClassLoader().getResourceAsStream("recursos/jdbc.properties");
        try {
            this.informacionIpsDTO = informacionIpsDTO;
            initComponents();
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/iconogenomaplus.png")));
            mCargarIPS();
            springStart();
            this.lblLicencia.setText("<html><P ALIGN=center>Licencia Autorizada a la " + informacionIpsDTO.get(0).getNombreIps() + "<br>" + this.informacionIpsDTO.get(0).getVersion());
            setTitle(this.titulo + " - " + this.informacionIpsDTO.get(0).getVersion());
            this.txtUsuario.requestFocus();
            this.prop.load(this.input);
            this.JLB_InfoBase.setVisible(false);
            if (informacionIpsDTO.get(0).getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
                if (this.prop.getProperty("jdbc.url").equals("jdbc.url=jdbc:mariadb://192.168.1.94:13306/baseserver")) {
                    this.JLB_InfoBase.setVisible(true);
                    this.JLB_InfoBase.setForeground(Color.orange);
                    this.JLB_InfoBase.setText("<html><P ALIGN=center>Base de Datos de Prueba");
                }
            } else if (this.prop.getProperty("jdbc.url").equals("jdbc:mariadb://192.168.78.4:13306/baseserver") || this.prop.getProperty("jdbc.url").contains("pruebas")) {
                this.JLB_InfoBase.setVisible(true);
                this.JLB_InfoBase.setForeground(Color.orange);
                this.JLB_InfoBase.setText("<html><P ALIGN=center>Base de Datos de Prueba");
            } else if (this.prop.getProperty("jdbc.url").equals("jdbc:mariadb://192.168.78.194:13306/baseserver")) {
                this.JLB_InfoBase.setVisible(true);
                this.JLB_InfoBase.setForeground(Color.orange);
                this.JLB_InfoBase.setText("<html><P ALIGN=center>Base de Datos de Genoma Offline");
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void springStart() {
        this.usuarioSistemaDAO = (UsuarioSistemaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("usuarioSistemaDAOImpl");
    }

    private void cargarSedeUsuarioSistemas(String idPersona) {
        this.xlleno1 = false;
        this.JCBSede.removeAllItems();
        this.sedeUsuarioDTO = this.usuarioSistemaDAO.usuarioSistemaSede(idPersona);
        if (!this.sedeUsuarioDTO.isEmpty()) {
            this.xidsede = new String[this.sedeUsuarioDTO.size()];
            for (int i = 0; i < this.sedeUsuarioDTO.size(); i++) {
                this.xidsede[i] = this.sedeUsuarioDTO.get(i).getId().toString();
                this.JCBSede.addItem(this.sedeUsuarioDTO.get(i).getNombre());
            }
            if (this.xidsede.length > 1) {
                this.JCBSede.setSelectedIndex(-1);
            }
        }
        if (this.xidsede.length > 1) {
            this.JCBSede.setSelectedIndex(-1);
        }
        this.xlleno1 = true;
    }

    public void buscarUsuario() {
        this.usuarioSistemaDAO.desactivarUsuarioSistema(this.txtUsuario.getText());
        this.usuarioSistemaDTO = this.usuarioSistemaDAO.usuarioSistema(this.txtUsuario.getText());
        if (!this.usuarioSistemaDTO.isEmpty()) {
            if (this.usuarioSistemaDTO.get(0).getIdPersonaCargo() != null) {
                this.txtNbre.setText(this.usuarioSistemaDTO.get(0).getNombreUsuario());
                cargarSedeUsuarioSistemas(this.usuarioSistemaDTO.get(0).getIdUsuarioSistema().toString());
                this.usuarioSistemaDTO1 = this.usuarioSistemaDTO.get(0);
                return;
            }
            this.metodos.mostrarMensaje("Solicite configuración del su cargo al administrador del sistemas");
            return;
        }
        this.metodos.mostrarMensaje("Por favor seleccione un Usuario Válido");
        this.txtNbre.setText("");
        this.txtUsuario.setText("");
        this.txtUsuario.requestFocus();
        this.JCBSede.removeAllItems();
    }

    private void cargarModulos() {
        List<Object[]> usuarioModulos = this.usuarioSistemaDAO.usuarioSistemaModulo(this.usuarioSistemaDTO.get(0).getIdUsuarioSistema().toString());
        if (!usuarioModulos.isEmpty()) {
            this.modulos = new String[usuarioModulos.size()];
            for (int i = 0; i < usuarioModulos.size(); i++) {
                this.modulos[i] = usuarioModulos.get(i)[0].toString();
            }
        }
    }

    private void evaluarPassword() {
        if (this.usuarioSistemaDTO1 != null) {
            if (!this.usuarioSistemaDTO1.getClave().trim().equals(this.metodos.getEncryptedPassword(new String(this.txtPassword.getPassword()).trim()).trim())) {
                this.metodos.mostrarMensaje("Contraseña Invalida.\nPor Favor revise.");
                this.txtPassword.requestFocus();
            } else {
                if (!this.usuarioSistemaDTO1.getEstado().booleanValue()) {
                    if (this.JCBSede.getSelectedIndex() != -1) {
                        mCargarFPrincipal();
                        return;
                    } else {
                        this.metodos.mostrarMensaje("Debe seleccionar una sede");
                        this.JCBSede.requestFocus();
                        return;
                    }
                }
                CambioClave frmCambio = new CambioClave(null, true, this.usuarioSistemaDTO1.getIdUsuarioSistema().toString(), 1, this);
                frmCambio.setVisible(true);
            }
        }
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.txtUsuario = new JTextField();
        this.txtPassword = new JPasswordField();
        this.txtNbre = new JTextField();
        this.JCBSede = new JComboBox();
        this.JCBIps = new JComboBox();
        this.jButton1 = new JButton();
        this.lblLicencia = new JLabel();
        this.btnsalir = new JButton();
        this.JLB_InfoBase = new JLabel();
        setDefaultCloseOperation(2);
        setTitle("G@noma Soft");
        setBackground(new Color(204, 204, 255));
        setModal(true);
        setName("Login");
        setUndecorated(true);
        setResizable(false);
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/LOGIN.png")));
        this.jLabel1.setBorder(BorderFactory.createBevelBorder(0));
        this.jLabel1.setDebugGraphicsOptions(-1);
        this.jLabel1.setName("Login");
        this.jLabel1.setVerticalTextPosition(3);
        this.jPanel1.setBackground(new Color(15, 176, 217));
        this.jPanel1.setBorder(BorderFactory.createBevelBorder(0));
        this.txtUsuario.setBackground(new Color(204, 255, 255));
        this.txtUsuario.setFont(new Font("Arial", 1, 14));
        this.txtUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 14)));
        this.txtUsuario.addFocusListener(new FocusAdapter() { // from class: Acceso.Login.1
            public void focusLost(FocusEvent evt) {
                Login.this.txtUsuarioFocusLost(evt);
            }
        });
        this.txtUsuario.addActionListener(new ActionListener() { // from class: Acceso.Login.2
            public void actionPerformed(ActionEvent evt) {
                Login.this.txtUsuarioActionPerformed(evt);
            }
        });
        this.txtUsuario.addKeyListener(new KeyAdapter() { // from class: Acceso.Login.3
            public void keyPressed(KeyEvent evt) {
                Login.this.txtUsuarioKeyPressed(evt);
            }
        });
        this.txtPassword.setBackground(new Color(204, 255, 255));
        this.txtPassword.setFont(new Font("Arial", 1, 14));
        this.txtPassword.setBorder(BorderFactory.createTitledBorder((Border) null, "Contraseña", 0, 0, new Font("Arial", 1, 14)));
        this.txtPassword.setCaretColor(new Color(0, 0, 255));
        this.txtPassword.addFocusListener(new FocusAdapter() { // from class: Acceso.Login.4
            public void focusLost(FocusEvent evt) {
                Login.this.txtPasswordFocusLost(evt);
            }
        });
        this.txtPassword.addKeyListener(new KeyAdapter() { // from class: Acceso.Login.5
            public void keyPressed(KeyEvent evt) {
                Login.this.txtPasswordKeyPressed(evt);
            }
        });
        this.txtNbre.setEditable(false);
        this.txtNbre.setBackground(new Color(204, 255, 255));
        this.txtNbre.setFont(new Font("Arial", 1, 14));
        this.txtNbre.setForeground(new Color(0, 51, 255));
        this.txtNbre.setHorizontalAlignment(0);
        this.txtNbre.setBorder(BorderFactory.createBevelBorder(0));
        this.JCBSede.setBackground(new Color(204, 255, 255));
        this.JCBSede.setFont(new Font("Arial", 1, 13));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "SEDE", 0, 0, new Font("Arial", 1, 14)));
        this.JCBSede.addItemListener(new ItemListener() { // from class: Acceso.Login.6
            public void itemStateChanged(ItemEvent evt) {
                Login.this.JCBSedeItemStateChanged(evt);
            }
        });
        this.JCBIps.setBackground(new Color(204, 255, 255));
        this.JCBIps.setFont(new Font("Arial", 1, 13));
        this.JCBIps.setBorder(BorderFactory.createTitledBorder((Border) null, "IPS", 2, 0, new Font("Arial", 1, 14)));
        this.JCBIps.addItemListener(new ItemListener() { // from class: Acceso.Login.7
            public void itemStateChanged(ItemEvent evt) {
                Login.this.JCBIpsItemStateChanged(evt);
            }
        });
        this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/outline_visibility_black_18dp.png")));
        this.jButton1.setPressedIcon(new ImageIcon(getClass().getResource("/Imagenes/outline_visibility_off_black_18dp.png")));
        this.jButton1.addMouseListener(new MouseAdapter() { // from class: Acceso.Login.8
            public void mousePressed(MouseEvent evt) {
                Login.this.jButton1MousePressed(evt);
            }

            public void mouseReleased(MouseEvent evt) {
                Login.this.jButton1MouseReleased(evt);
            }
        });
        this.jButton1.addActionListener(new ActionListener() { // from class: Acceso.Login.9
            public void actionPerformed(ActionEvent evt) {
                Login.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtUsuario, -2, 173, -2).addGap(79, 79, 79).addComponent(this.txtPassword, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton1, -2, 40, -2).addGap(20, 20, 20)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtNbre, GroupLayout.Alignment.LEADING).addComponent(this.JCBSede, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.JCBIps, 0, -1, 32767)).addContainerGap()))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JCBIps, -2, 50, -2).addGap(12, 12, 12).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtUsuario, -2, 50, -2).addComponent(this.txtPassword, -2, 50, -2).addComponent(this.jButton1, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.txtNbre, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSede, -2, 50, -2).addContainerGap()));
        this.jButton1.setOpaque(false);
        this.jButton1.setContentAreaFilled(false);
        this.jButton1.setBorderPainted(false);
        this.lblLicencia.setBackground(new Color(15, 176, 217));
        this.lblLicencia.setFont(new Font("Arial", 1, 14));
        this.lblLicencia.setForeground(new Color(255, 255, 255));
        this.lblLicencia.setHorizontalAlignment(0);
        this.lblLicencia.setText("<html><P ALIGN=center>Autorización de Licencia");
        this.lblLicencia.setBorder(BorderFactory.createBevelBorder(0));
        this.lblLicencia.setOpaque(true);
        this.btnsalir.setFont(new Font("Arial", 1, 12));
        this.btnsalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnsalir.setMnemonic('C');
        this.btnsalir.setText("Salir");
        this.btnsalir.addActionListener(new ActionListener() { // from class: Acceso.Login.10
            public void actionPerformed(ActionEvent evt) {
                Login.this.btnsalirActionPerformed(evt);
            }
        });
        this.JLB_InfoBase.setFont(new Font("Arial", 1, 14));
        this.JLB_InfoBase.setForeground(Color.red);
        this.JLB_InfoBase.setHorizontalAlignment(0);
        this.JLB_InfoBase.setText("<html><P ALIGN=center>Base de Datos de Producción");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.lblLicencia, -2, 518, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.btnsalir, GroupLayout.Alignment.LEADING, -2, 518, -2)).addComponent(this.JLB_InfoBase, -2, 518, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.btnsalir, -2, 44, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLB_InfoBase, -1, 39, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.lblLicencia, -2, 62, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnsalirActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUsuarioFocusLost(FocusEvent evt) {
        if (!this.txtUsuario.getText().isEmpty()) {
            buscarUsuario();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPasswordFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUsuarioActionPerformed(ActionEvent evt) {
        this.txtPassword.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUsuarioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 40 || evt.getKeyCode() == 10 || evt.getKeyCode() == 38) {
            this.txtPassword.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPasswordKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 40 || evt.getKeyCode() == 10 || evt.getKeyCode() == 38) {
            evaluarPassword();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBIpsItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBIps.getSelectedIndex() > -1) {
            this.lblLicencia.setText("<html><P ALIGN=center>Licencia Autorizada a la " + this.JCBIps.getSelectedItem());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeItemStateChanged(ItemEvent evt) {
        if (this.xlleno1 && this.JCBSede.getSelectedIndex() != -1) {
            evaluarPassword();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1MousePressed(MouseEvent evt) {
        mostrarYOcultarContrasena(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1MouseReleased(MouseEvent evt) {
        mostrarYOcultarContrasena(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton1ActionPerformed(ActionEvent evt) {
    }

    public void mostrarYOcultarContrasena(boolean mostrar) {
        if (mostrar) {
            this.txtPassword.setEchoChar((char) 0);
            this.txtPassword.requestFocus();
        } else {
            this.txtPassword.setEchoChar((char) 8226);
            this.txtPassword.requestFocus();
        }
    }

    public void mCargarFPrincipal() {
        cargarModulos();
        InformacionIpsDTO informacionIps = null;
        GeneralDTO sedeUsuarioSeleccionadaDTO = null;
        InformacionGeneralPrincipalDTO informacionGeneralPrincipalDTO = new InformacionGeneralPrincipalDTO();
        for (int i = 0; i < this.informacionIpsDTO.size(); i++) {
            if (Objects.equals(this.informacionIpsDTO.get(i).getId(), Long.valueOf(this.xId_IPS[this.JCBIps.getSelectedIndex()][0]))) {
                informacionIps = this.informacionIpsDTO.get(i);
            }
        }
        for (int i2 = 0; i2 < this.sedeUsuarioDTO.size(); i2++) {
            if (Objects.equals(this.sedeUsuarioDTO.get(i2).getId(), Long.valueOf(this.xidsede[this.JCBSede.getSelectedIndex()]))) {
                sedeUsuarioSeleccionadaDTO = this.sedeUsuarioDTO.get(i2);
            }
        }
        Principal frame = new Principal(this.modulos, this.usuarioSistemaDTO1, sedeUsuarioSeleccionadaDTO, informacionIps, informacionGeneralPrincipalDTO);
        frame.setVisible(true);
        dispose();
    }

    private void mCargarIPS() {
        if (!this.informacionIpsDTO.isEmpty()) {
            this.xId_IPS = new String[this.informacionIpsDTO.size()][3];
            for (int i = 0; i < this.informacionIpsDTO.size(); i++) {
                this.xId_IPS[i][0] = this.informacionIpsDTO.get(i).getId().toString();
                this.xId_IPS[i][1] = this.informacionIpsDTO.get(i).getNombreIps();
                this.xId_IPS[i][2] = this.informacionIpsDTO.get(i).getIdEmpresa().toString();
                this.JCBIps.addItem(this.informacionIpsDTO.get(i).getNombreIps());
            }
            this.JCBIps.setSelectedIndex(0);
            this.xlleno = true;
        }
    }
}
