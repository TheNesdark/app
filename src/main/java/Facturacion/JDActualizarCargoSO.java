package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JDActualizarCargoSO.class */
public class JDActualizarCargoSO extends JDialog {
    public Metodos metodos;
    private ConsultasMySQL ConsultasMysql;
    private String idIngreso;
    private String noDocumento;
    private String cargo;
    private String idCargoNuevo;
    public String[] listaCargo;
    public String[] listCargo;
    private JButton JBTAceptar;
    public JComboBox JCBCargo;
    private JCheckBox JCBEsNuevo;
    private JLabel JLInformacion;
    private JTextField JTFCargo;
    private JPanel jPanel1;

    public JDActualizarCargoSO(Frame parent, boolean modal, String idIngreso, String noDocumento, String cargo) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.ConsultasMysql = new ConsultasMySQL();
        initComponents();
        setTitle("ACTUALIZAR CARGO");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setLocationRelativeTo(null);
        this.idIngreso = idIngreso;
        this.noDocumento = noDocumento;
        this.cargo = cargo;
        this.JLInformacion.setText(this.noDocumento + " - " + cargo);
        nuevo();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFCargo = new JTextField();
        this.JLInformacion = new JLabel();
        this.JCBCargo = new JComboBox();
        this.JCBEsNuevo = new JCheckBox();
        this.JBTAceptar = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Información", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCargo.setFont(new Font("Arial", 1, 12));
        this.JTFCargo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Nuevo Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCargo.addKeyListener(new KeyAdapter() { // from class: Facturacion.JDActualizarCargoSO.1
            public void keyReleased(KeyEvent evt) {
                JDActualizarCargoSO.this.JTFCargoKeyReleased(evt);
            }
        });
        this.JCBCargo.setFont(new Font("Arial", 1, 12));
        this.JCBCargo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(41, 43, 45)), "Cargo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCargo.addMouseListener(new MouseAdapter() { // from class: Facturacion.JDActualizarCargoSO.2
            public void mouseClicked(MouseEvent evt) {
                JDActualizarCargoSO.this.JCBCargoMouseClicked(evt);
            }
        });
        this.JCBCargo.addActionListener(new ActionListener() { // from class: Facturacion.JDActualizarCargoSO.3
            public void actionPerformed(ActionEvent evt) {
                JDActualizarCargoSO.this.JCBCargoActionPerformed(evt);
            }
        });
        this.JCBEsNuevo.setText("Nuevo");
        this.JCBEsNuevo.addActionListener(new ActionListener() { // from class: Facturacion.JDActualizarCargoSO.4
            public void actionPerformed(ActionEvent evt) {
                JDActualizarCargoSO.this.JCBEsNuevoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLInformacion, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBCargo, -2, 218, -2).addGap(18, 18, 18).addComponent(this.JTFCargo, -2, 241, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEsNuevo).addGap(0, 0, 32767)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLInformacion, -2, 35, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCargo, -2, -1, -2).addComponent(this.JTFCargo, -2, -1, -2).addComponent(this.JCBEsNuevo)).addContainerGap(-1, 32767)));
        this.JBTAceptar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTAceptar.setText("ACEPTAR");
        this.JBTAceptar.addActionListener(new ActionListener() { // from class: Facturacion.JDActualizarCargoSO.5
            public void actionPerformed(ActionEvent evt) {
                JDActualizarCargoSO.this.JBTAceptarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(160, 160, 160).addComponent(this.JBTAceptar, -2, 177, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2))).addContainerGap(42, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAceptar, -2, 45, -2).addContainerGap(-1, 32767)));
        this.jPanel1.getAccessibleContext().setAccessibleName("ACTUALIZAR");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAceptarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCargoKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCargoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBCargoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEsNuevoActionPerformed(ActionEvent evt) {
    }

    private void grabar() {
        String cargo;
        if (this.JCBEsNuevo.isSelected()) {
            cargo = this.JTFCargo.getText();
            crearCargo();
        } else {
            cargo = this.JCBCargo.getSelectedItem().toString();
            this.idCargoNuevo = this.listaCargo[this.JCBCargo.getSelectedIndex()];
        }
        try {
            String sqlUsuario = "UPDATE `baseserver`.`g_usuario` SET `Id_Cargo` = '" + this.idCargoNuevo + "' WHERE NoHistoria = '" + this.noDocumento + "'";
            this.ConsultasMysql.ejecutarSQL(sqlUsuario);
            String sqlIngreso = "UPDATE `ingreso` SET `SO_Cargo` = '" + cargo.toUpperCase() + "' WHERE `Id` = '" + this.idIngreso + "'; ";
            this.ConsultasMysql.ejecutarSQL(sqlIngreso);
            this.ConsultasMysql.cerrarConexionBd();
            JOptionPane.showMessageDialog(this, "Cargo actualizado correctamente", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void nuevo() {
        this.listaCargo = this.ConsultasMysql.llenarCombo("SELECT `Id`, `Nbre` FROM `g_cargos` WHERE (`Estado` =1) ORDER BY Nbre ASC", this.listaCargo, this.JCBCargo);
    }

    private String crearCargo() {
        String sql = "INSERT INTO `baseserver`.`g_cargos` (\n  `Nbre`,\n  `Estado`,\n  `Fecha`,\n  `UsuarioS`\n)\nVALUES\n  (\n    \n    '" + this.JTFCargo.getText().toUpperCase() + "',\n    '1',\n    '" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "',\n    '" + Principal.usuarioSistemaDTO.getLogin() + "'\n  );";
        this.idCargoNuevo = this.ConsultasMysql.ejecutarSQLId(sql);
        this.ConsultasMysql.cerrarConexionBd();
        return this.idCargoNuevo;
    }
}
