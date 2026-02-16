package Acceso;

import Utilidades.Creguard_XML;
import Utilidades.Validationerror;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Acceso/VentanaConfig.class */
public class VentanaConfig extends JDialog {
    Creguard_XML guar = new Creguard_XML();
    Validationerror valid = new Validationerror();
    private JButton Acept;
    private JTextField BaseDatos;
    private JTextField IP1;
    private JTextField IP2;
    private JTextField IP3;
    private JTextField IP4;
    private JPasswordField Passw;
    private JTextField User;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;

    public VentanaConfig() {
        initComponents();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.BaseDatos = new JTextField();
        this.IP1 = new JTextField();
        this.IP2 = new JTextField();
        this.IP3 = new JTextField();
        this.IP4 = new JTextField();
        this.jLabel4 = new JLabel();
        this.User = new JTextField();
        this.Passw = new JPasswordField();
        this.jLabel5 = new JLabel();
        this.jLabel6 = new JLabel();
        this.Acept = new JButton();
        this.jButton2 = new JButton();
        setDefaultCloseOperation(2);
        setTitle("Configurar Servicio de Base de Datos");
        setCursor(new Cursor(0));
        setResizable(false);
        this.jLabel1.setFont(new Font("Tahoma", 1, 16));
        this.jLabel1.setText("Ingrese Datos De Servidor");
        this.jLabel1.setPreferredSize(new Dimension(223, 14));
        this.jLabel3.setFont(new Font("Tahoma", 1, 16));
        this.jLabel3.setText("De Base de Datos");
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel2.setText("Base de Datos:");
        this.BaseDatos.setToolTipText("Colocar Nombre Dela Base de Datos que el Programa Utiliza, Ej: MiBaseDeDatos");
        this.BaseDatos.addKeyListener(new KeyAdapter() { // from class: Acceso.VentanaConfig.1
            public void keyPressed(KeyEvent evt) {
                VentanaConfig.this.BaseDatosKeyPressed(evt);
            }
        });
        this.IP1.setHorizontalAlignment(0);
        this.IP1.setToolTipText("Ingrese La Direccion IP Ej: 172.200.139.47");
        this.IP1.addKeyListener(new KeyAdapter() { // from class: Acceso.VentanaConfig.2
            public void keyReleased(KeyEvent evt) {
                VentanaConfig.this.IP1KeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                VentanaConfig.this.IP1KeyTyped(evt);
            }
        });
        this.IP2.setColumns(3);
        this.IP2.setHorizontalAlignment(0);
        this.IP2.setToolTipText("Ingrese La Direccion IP Ej: 172.200.139.47");
        this.IP2.addKeyListener(new KeyAdapter() { // from class: Acceso.VentanaConfig.3
            public void keyReleased(KeyEvent evt) {
                VentanaConfig.this.IP2KeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                VentanaConfig.this.IP2KeyTyped(evt);
            }
        });
        this.IP3.setColumns(3);
        this.IP3.setHorizontalAlignment(0);
        this.IP3.setToolTipText("Ingrese La Direccion IP Ej: 172.200.139.47");
        this.IP3.addKeyListener(new KeyAdapter() { // from class: Acceso.VentanaConfig.4
            public void keyReleased(KeyEvent evt) {
                VentanaConfig.this.IP3KeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                VentanaConfig.this.IP3KeyTyped(evt);
            }
        });
        this.IP4.setHorizontalAlignment(0);
        this.IP4.setToolTipText("Ingrese La Direccion IP Ej: 172.200.139.47");
        this.IP4.addKeyListener(new KeyAdapter() { // from class: Acceso.VentanaConfig.5
            public void keyReleased(KeyEvent evt) {
                VentanaConfig.this.IP4KeyReleased(evt);
            }

            public void keyTyped(KeyEvent evt) {
                VentanaConfig.this.IP4KeyTyped(evt);
            }
        });
        this.jLabel4.setText("Dirección IP:");
        this.User.setToolTipText("Digite e nombre de usuario de la base de datos, Ej: user1.");
        this.User.addKeyListener(new KeyAdapter() { // from class: Acceso.VentanaConfig.6
            public void keyPressed(KeyEvent evt) {
                VentanaConfig.this.UserKeyPressed(evt);
            }
        });
        this.Passw.setColumns(10);
        this.Passw.setToolTipText("Contraseña de la base de datos.");
        this.Passw.addKeyListener(new KeyAdapter() { // from class: Acceso.VentanaConfig.7
            public void keyPressed(KeyEvent evt) {
                VentanaConfig.this.PasswKeyPressed(evt);
            }
        });
        this.jLabel5.setText("Usuario BD:");
        this.jLabel6.setText("Contraseña BD:");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap(15, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.IP1, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.IP2, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.IP3, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.IP4, -2, 32, -2)).addComponent(this.BaseDatos, -2, 152, -2))).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.User, -2, 152, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.Passw, -2, 152, -2))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.BaseDatos, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.IP1, -2, -1, -2).addComponent(this.IP2, -2, -1, -2).addComponent(this.IP3, -2, -1, -2).addComponent(this.IP4, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.User, -2, -1, -2).addComponent(this.jLabel5)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.Passw, -2, -1, -2).addComponent(this.jLabel6)).addContainerGap(-1, 32767)));
        this.Acept.setText("Aceptar");
        this.Acept.addActionListener(new ActionListener() { // from class: Acceso.VentanaConfig.8
            public void actionPerformed(ActionEvent evt) {
                VentanaConfig.this.AceptActionPerformed(evt);
            }
        });
        this.jButton2.setText("Cancelar");
        this.jButton2.addActionListener(new ActionListener() { // from class: Acceso.VentanaConfig.9
            public void actionPerformed(ActionEvent evt) {
                VentanaConfig.this.jButton2ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(44, 44, 44).addComponent(this.Acept, -2, 80, -2).addGap(21, 21, 21).addComponent(this.jButton2, -2, 92, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(58, 58, 58).addComponent(this.jLabel3, -2, 150, -2)).addGroup(layout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.jLabel1, -2, -1, -2))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.Acept)).addContainerGap(-1, 32767)));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 291) / 2, (screenSize.height - 264) / 2, 291, 264);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jButton2ActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AceptActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PasswKeyPressed(KeyEvent evt) {
        this.valid.cuentaData2(this.Passw, 15, evt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UserKeyPressed(KeyEvent evt) {
        this.valid.cuentaData2(this.User, 15, evt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP4KeyTyped(KeyEvent evt) {
        this.valid.valEntero(evt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP4KeyReleased(KeyEvent evt) {
        this.valid.valIp(this.IP4, 4, this.IP4, evt, this.IP3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP3KeyTyped(KeyEvent evt) {
        this.valid.valEntero(evt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP3KeyReleased(KeyEvent evt) {
        this.valid.valIp(this.IP3, 3, this.IP4, evt, this.IP2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP2KeyTyped(KeyEvent evt) {
        this.valid.valEntero(evt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP2KeyReleased(KeyEvent evt) {
        this.valid.valIp(this.IP2, 2, this.IP3, evt, this.IP1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP1KeyTyped(KeyEvent evt) {
        this.valid.valEntero(evt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP1KeyReleased(KeyEvent evt) {
        this.valid.valIp(this.IP1, 1, this.IP2, evt, this.IP1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BaseDatosKeyPressed(KeyEvent evt) {
        this.valid.cuentaData2(this.BaseDatos, 15, evt);
    }

    public static void main(String[] args) {
    }
}
