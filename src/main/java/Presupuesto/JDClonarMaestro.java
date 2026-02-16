package Presupuesto;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDClonarMaestro.class */
public class JDClonarMaestro extends JDialog {
    private String[] xidMaestroO;
    private String[] xidMaestroD;
    private ConsultasMySQL xct;
    private JButton JBGrabar;
    private JComboBox JCBMaestroDestino;
    private JComboBox JCBMaestroOrigen;
    private JPanel jPanel1;

    public JDClonarMaestro(Frame parent, boolean modal) {
        super(parent, "CLONAR MAESTRO DE RUBROS", modal);
        this.xct = new ConsultasMySQL();
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mIniciaCombos();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBMaestroOrigen = new JComboBox();
        this.JCBMaestroDestino = new JComboBox();
        this.JBGrabar = new JButton();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBMaestroOrigen.setFont(new Font("Arial", 1, 12));
        this.JCBMaestroOrigen.setBorder(BorderFactory.createTitledBorder((Border) null, "Maestro Origen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMaestroDestino.setFont(new Font("Arial", 1, 12));
        this.JCBMaestroDestino.setBorder(BorderFactory.createTitledBorder((Border) null, "Maestro Destino", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBMaestroOrigen, -2, 290, -2).addGap(18, 18, 18).addComponent(this.JCBMaestroDestino, 0, 281, 32767).addGap(19, 19, 19)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBMaestroOrigen).addComponent(this.JCBMaestroDestino)).addContainerGap()));
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Presupuesto.JDClonarMaestro.1
            public void actionPerformed(ActionEvent evt) {
                JDClonarMaestro.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JBGrabar, -1, -1, 32767)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrabar, -2, 45, -2).addGap(5, 5, 5)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void mIniciaCombos() {
        this.xidMaestroO = this.xct.llenarCombo("SELECT id, nombre FROM `pp_rubros_encabezado` WHERE estado=1", this.xidMaestroO, this.JCBMaestroOrigen);
        this.xct.cerrarConexionBd();
        this.JCBMaestroOrigen.setSelectedIndex(-1);
        this.xidMaestroD = this.xct.llenarCombo("SELECT id, nombre FROM `pp_rubros_encabezado` WHERE estado=1", this.xidMaestroD, this.JCBMaestroDestino);
        this.xct.cerrarConexionBd();
        this.JCBMaestroDestino.setSelectedIndex(-1);
    }

    private void mGrabar() {
        if (this.JCBMaestroOrigen.getSelectedIndex() > -1) {
            if (this.JCBMaestroDestino.getSelectedIndex() > -1) {
                if (!this.xidMaestroO[this.JCBMaestroOrigen.getSelectedIndex()].equals(this.xidMaestroD[this.JCBMaestroDestino.getSelectedIndex()])) {
                    if (mVerificaRubrosOrigen()) {
                        if (!mVerificaRubrosDestino()) {
                            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                String sql1 = "INSERT INTO `pp_rubros`\n            (`Id`, idEncabezadoRubro, `Nbre`, `IdPadre`, `TipoRubro`, `UltNivel`, `Aplica_Tercero`, `UsuarioS`)\nSELECT `Id`, '" + this.xidMaestroD[this.JCBMaestroDestino.getSelectedIndex()] + "' , `Nbre`, `IdPadre`, `TipoRubro`, `UltNivel`, `Aplica_Tercero`,'" + Principal.usuarioSistemaDTO.getLogin() + "'\nFROM `pp_rubros` WHERE idEncabezadoRubro='" + this.xidMaestroO[this.JCBMaestroOrigen.getSelectedIndex()] + "'";
                                this.xct.ejecutarSQL(sql1);
                                this.xct.cerrarConexionBd();
                                String sql2 = "INSERT INTO `pp_resoluciones_rubro`\n            (`IdRubro`,\n             `IdResolucion`,\n             `idEncabezadoRubro`,\n             `CodigoAlterno`,`UsuarioS`)\nSELECT `IdRubro`, `IdResolucion`, '" + this.xidMaestroD[this.JCBMaestroDestino.getSelectedIndex()] + "', `CodigoAlterno`,'" + Principal.usuarioSistemaDTO.getLogin() + "' \nFROM `pp_resoluciones_rubro` WHERE  IdResolucion=1 AND idEncabezadoRubro='" + this.xidMaestroO[this.JCBMaestroOrigen.getSelectedIndex()] + "'";
                                this.xct.ejecutarSQL(sql2);
                                this.xct.cerrarConexionBd();
                                String sql3 = "INSERT INTO `pp_rubro_x_tipo_doc`\n            (`IdRubro`,\n             `IdTipoDoc`,\n             `idEncabezadoRubro`,`UsuarioS`)\nSELECT\n  `IdRubro`,\n  `IdTipoDoc`,\n  '" + this.xidMaestroD[this.JCBMaestroDestino.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getLogin() + "'\nFROM `pp_rubro_x_tipo_doc` WHERE idEncabezadoRubro='" + this.xidMaestroO[this.JCBMaestroOrigen.getSelectedIndex()] + "'";
                                this.xct.ejecutarSQL(sql3);
                                this.xct.cerrarConexionBd();
                                JOptionPane.showMessageDialog(this, "El maestro " + this.JCBMaestroOrigen.getSelectedItem() + " fue copiado exitosamente a " + this.JCBMaestroDestino.getSelectedItem(), "ÉXITO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "El maestro " + this.JCBMaestroDestino.getSelectedItem() + " ya tiene rubros asignados", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "El maestro " + this.JCBMaestroOrigen.getSelectedItem() + " debe tener rubros para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showMessageDialog(this, "No puede clonar el maestro en el mismo encabezado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar el Maestro destino", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBMaestroDestino.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar el Maestro origen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBMaestroOrigen.requestFocus();
    }

    private boolean mVerificaRubrosDestino() {
        boolean xExiste = false;
        String sql = "SELECT * FROM `pp_rubros` WHERE `idEncabezadoRubro`='" + this.xidMaestroD[this.JCBMaestroDestino.getSelectedIndex()] + "'";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDClonarMaestro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    private boolean mVerificaRubrosOrigen() {
        boolean xExiste = false;
        String sql = "SELECT * FROM `pp_rubros` WHERE `idEncabezadoRubro`='" + this.xidMaestroO[this.JCBMaestroOrigen.getSelectedIndex()] + "'";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDClonarMaestro.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }
}
