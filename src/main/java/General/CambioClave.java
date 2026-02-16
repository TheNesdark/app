package General;

import Acceso.Login;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:General/CambioClave.class */
public class CambioClave extends JDialog {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private String sql;
    private String clave;
    private ResultSet rs;
    private String pas1;
    private String pas2;
    private String xidusuario;
    private Login xjdlogin;
    private int xmodulo;
    private JButton btnAceptar;
    private JButton btnSalir;
    private JPanel jPanel1;
    private JPasswordField txtNewClave;
    private JPasswordField txtNewClaveR;
    private JTextField txtNombre;
    private JTextField txtUsuario;

    public CambioClave(Frame parent, boolean modal, String xidusuario, int xmodulo) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.clave = "";
        initComponents();
        this.xmodulo = xmodulo;
        this.xidusuario = xidusuario;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(parent);
        mBuscarDatosUsuario();
        this.txtNewClave.requestFocus();
    }

    public CambioClave(Frame parent, boolean modal, String xidusuario, int xmodulo, Login xjdlogin) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.clave = "";
        initComponents();
        this.xjdlogin = xjdlogin;
        this.xmodulo = xmodulo;
        this.xidusuario = xidusuario;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(parent);
        mBuscarDatosUsuario();
        this.txtNewClave.requestFocus();
    }

    private void grabar() {
        if (String.valueOf(this.txtNewClave.getPassword()).equals(String.valueOf(this.txtNewClaveR.getPassword()))) {
            if (validarComponentes() == 1) {
                this.sql = "UPDATE g_usuario_sist SET Clave ='" + this.metodos.getEncryptedPassword(String.valueOf(this.txtNewClaveR.getPassword())) + "', FechaUltimoC='" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "' WHERE Id_Persona ='" + this.xidusuario + "'";
                this.consultas.ejecutarSQL(this.sql);
                this.consultas.cerrarConexionBd();
                this.metodos.mostrarMensaje("Clave cambiada");
                if (this.xmodulo == 1) {
                    this.xjdlogin.buscarUsuario();
                    this.xjdlogin.txtPassword.setText(String.valueOf(this.txtNewClaveR.getPassword()));
                }
                dispose();
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "La claves no coincide", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.txtNewClaveR.requestFocus();
    }

    private void mBuscarDatosUsuario() {
        this.clave = "";
        this.sql = "SELECT persona.NUsuario, g_usuario_sist.Clave, g_usuario_sist.Login FROM g_usuario_sist INNER JOIN persona ON (g_usuario_sist.Id_Persona = persona.Id_persona) WHERE (g_usuario_sist.Id_Persona='" + this.xidusuario + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.txtNombre.setText(this.rs.getString(1));
                this.txtUsuario.setText(this.rs.getString(3));
                this.clave = this.rs.getString(2);
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(CambioClave.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mValidarClave() {
        if (!String.valueOf(this.txtNewClave.getPassword()).isEmpty() && this.clave.equals(this.metodos.getEncryptedPassword(String.valueOf(this.txtNewClave.getPassword())))) {
            JOptionPane.showMessageDialog(this, "La clave nueva no puede ser igual a la anterior", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.txtNewClave.setText("");
            this.txtNewClave.requestFocus();
        }
    }

    private void mValidarClaveR() {
        if (!String.valueOf(this.txtNewClaveR.getPassword()).isEmpty() && !String.valueOf(this.txtNewClave.getPassword()).equals(String.valueOf(this.txtNewClaveR.getPassword()))) {
            this.pas1 = String.valueOf(this.txtNewClave.getPassword());
            this.pas2 = String.valueOf(this.txtNewClaveR.getPassword());
            JOptionPane.showMessageDialog(this, "La claves no coincide", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.txtNewClaveR.requestFocus();
        }
    }

    private int validarComponentes() {
        int retorno = 0;
        if (this.txtUsuario.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione el Usuario a quien se cambiará la Clave");
            this.txtUsuario.requestFocus();
        } else if (this.txtNombre.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor seleccione el Usuario a quien se cambiará la Clave");
            this.txtNombre.requestFocus();
        } else if (this.txtNewClave.getPassword().length < 1) {
            this.metodos.mostrarMensaje("Por favor escriba la Nueva Clave de acceso a Genoma");
            this.txtNewClave.requestFocus();
        } else if (this.txtNewClaveR.getPassword().length < 1) {
            this.metodos.mostrarMensaje("Por favor repita la Nueva Clave de acceso a Genoma");
            this.txtNewClaveR.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.txtNombre = new JTextField();
        this.txtNewClaveR = new JPasswordField();
        this.txtNewClave = new JPasswordField();
        this.txtUsuario = new JTextField();
        this.btnSalir = new JButton();
        this.btnAceptar = new JButton();
        setDefaultCloseOperation(2);
        setTitle("CAMBIO DE CLAVE DE ACCESO");
        setMinimumSize(null);
        setModal(true);
        setResizable(false);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DE CUENTA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtNombre.setFont(new Font("Arial", 1, 12));
        this.txtNombre.setHorizontalAlignment(0);
        this.txtNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNombre.setDisabledTextColor(new Color(0, 0, 0));
        this.txtNombre.setEnabled(false);
        this.txtNewClaveR.setFont(new Font("Arial", 1, 12));
        this.txtNewClaveR.setBorder(BorderFactory.createTitledBorder((Border) null, "Repetir Clave", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNewClaveR.addActionListener(new ActionListener() { // from class: General.CambioClave.1
            public void actionPerformed(ActionEvent evt) {
                CambioClave.this.txtNewClaveRActionPerformed(evt);
            }
        });
        this.txtNewClaveR.addFocusListener(new FocusAdapter() { // from class: General.CambioClave.2
            public void focusLost(FocusEvent evt) {
                CambioClave.this.txtNewClaveRFocusLost(evt);
            }
        });
        this.txtNewClave.setFont(new Font("Arial", 1, 12));
        this.txtNewClave.setBorder(BorderFactory.createTitledBorder((Border) null, "Nueva Clave", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNewClave.addActionListener(new ActionListener() { // from class: General.CambioClave.3
            public void actionPerformed(ActionEvent evt) {
                CambioClave.this.txtNewClaveActionPerformed(evt);
            }
        });
        this.txtNewClave.addFocusListener(new FocusAdapter() { // from class: General.CambioClave.4
            public void focusLost(FocusEvent evt) {
                CambioClave.this.txtNewClaveFocusLost(evt);
            }
        });
        this.txtUsuario.setFont(new Font("Arial", 1, 12));
        this.txtUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtNombre).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtNewClave, -2, 218, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtNewClaveR, -1, 209, 32767)).addComponent(this.txtUsuario)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtNombre, -2, -1, -2).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtNewClaveR).addComponent(this.txtNewClave)).addContainerGap()));
        this.btnSalir.setFont(new Font("Arial", 1, 12));
        this.btnSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.btnSalir.setText("Salir");
        this.btnSalir.addActionListener(new ActionListener() { // from class: General.CambioClave.5
            public void actionPerformed(ActionEvent evt) {
                CambioClave.this.btnSalirActionPerformed(evt);
            }
        });
        this.btnAceptar.setFont(new Font("Arial", 1, 12));
        this.btnAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnAceptar.setText("Aceptar");
        this.btnAceptar.addActionListener(new ActionListener() { // from class: General.CambioClave.6
            public void actionPerformed(ActionEvent evt) {
                CambioClave.this.btnAceptarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.btnAceptar, -2, 230, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnSalir, -2, 220, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btnAceptar, -2, 40, -2).addComponent(this.btnSalir, -2, 40, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnAceptarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNewClaveFocusLost(FocusEvent evt) {
        mValidarClave();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNewClaveActionPerformed(ActionEvent evt) {
        this.txtNewClave.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNewClaveRFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNewClaveRActionPerformed(ActionEvent evt) {
        mValidarClaveR();
    }
}
