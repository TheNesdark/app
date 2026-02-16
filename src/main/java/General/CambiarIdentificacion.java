package General;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:General/CambiarIdentificacion.class */
public class CambiarIdentificacion extends JInternalFrame {
    private String xsql;
    private String[] xidtipodoc;
    private JComboBox JCBNTipoDoc;
    private JPanel JPIDatosN;
    private JPanel JPIDatosUsuario;
    private JTextField JTFNDocumento;
    private JTextField JTFNHistoria;
    private JTextField JTFNNDocumento;
    private JTextField JTFNNHistoria;
    private JTextField JTFNombre;
    private JTextField JTFTipoDoc;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private long xidusuario = 0;

    public CambiarIdentificacion() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        this.JTFNHistoria.setText("");
        this.JTFNDocumento.setText("");
        this.JTFTipoDoc.setText("");
        this.JTFNNHistoria.setText("");
        this.JTFNombre.setText("");
        this.JTFNNHistoria.setText("");
        this.JTFNNDocumento.setText("");
        this.JCBNTipoDoc.removeAllItems();
        this.xidtipodoc = this.xct.llenarCombo("SELECT  `Id` , `Nbre` FROM `g_tipoidentificacion` WHERE (`Estado` =0) ORDER BY `Nbre` ASC", this.xidtipodoc, this.JCBNTipoDoc);
        this.xct.cerrarConexionBd();
        this.JCBNTipoDoc.setSelectedIndex(-1);
        this.xidusuario = 0L;
        this.JTFNHistoria.requestFocus();
    }

    private void mBuscarUsuario() {
        if (!this.JTFNHistoria.getText().isEmpty()) {
            try {
                this.xsql = "SELECT  `persona`.`NoHistoria` , `g_tipoidentificacion`.`Nbre`  , `persona`.`NoDocumento` , `persona`.`NUsuario` , `persona`.`Id_persona` FROM `g_tipoidentificacion` INNER JOIN `persona`  ON (`g_tipoidentificacion`.`Id` = `persona`.`Id_TipoIdentificacion`) WHERE (`persona`.`NoHistoria` ='" + this.JTFNHistoria.getText() + "') ";
                ResultSet xrs = this.xct.traerRs(this.xsql);
                if (xrs.next()) {
                    xrs.first();
                    this.JTFNDocumento.setText(xrs.getString(3));
                    this.JTFTipoDoc.setText(xrs.getString(2));
                    this.JTFNombre.setText(xrs.getString(4));
                    this.xidusuario = xrs.getLong(5);
                    this.JTFNNHistoria.requestFocus();
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Usuario no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    mNuevo();
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(CambiarIdentificacion.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        }
    }

    public void mGrabar() {
        if (this.xidusuario != 0) {
            if (!this.JTFNNHistoria.getText().isEmpty()) {
                if (!this.JTFNNDocumento.getText().isEmpty()) {
                    if (this.JCBNTipoDoc.getSelectedIndex() != -1) {
                        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        if (x == 0) {
                            this.xsql = "update g_usuario set NoHistoria='" + this.JTFNNHistoria.getText() + "' where Id_Persona='" + this.xidusuario + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.xsql = "update g_persona set Id_TipoIdentificacion='" + this.xidtipodoc[this.JCBNTipoDoc.getSelectedIndex()] + "', NoDocumento='" + this.JTFNNDocumento.getText() + "' where Id='" + this.xidusuario + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBNTipoDoc.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Falta nuevo numero de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFNNDocumento.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Falta nuevo numero de historia", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNNHistoria.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe buscar un usuario", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void initComponents() {
        this.JPIDatosUsuario = new JPanel();
        this.JTFNHistoria = new JTextField();
        this.JTFNDocumento = new JTextField();
        this.JTFTipoDoc = new JTextField();
        this.JTFNombre = new JTextField();
        this.JPIDatosN = new JPanel();
        this.JTFNNHistoria = new JTextField();
        this.JTFNNDocumento = new JTextField();
        this.JCBNTipoDoc = new JComboBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CAMBIO DE IDENTIFICACIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("CambiarIdentificacion");
        this.JPIDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS ACTUALES DEL USUARIO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFNHistoria.setFont(new Font("Arial", 1, 12));
        this.JTFNHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Historia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNHistoria.addActionListener(new ActionListener() { // from class: General.CambiarIdentificacion.1
            public void actionPerformed(ActionEvent evt) {
                CambiarIdentificacion.this.JTFNHistoriaActionPerformed(evt);
            }
        });
        this.JTFNHistoria.addFocusListener(new FocusAdapter() { // from class: General.CambiarIdentificacion.2
            public void focusLost(FocusEvent evt) {
                CambiarIdentificacion.this.JTFNHistoriaFocusLost(evt);
            }
        });
        this.JTFNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JTFTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFTipoDoc.setDisabledTextColor(new Color(0, 0, 0));
        this.JTFTipoDoc.setEnabled(false);
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDatosUsuarioLayout = new GroupLayout(this.JPIDatosUsuario);
        this.JPIDatosUsuario.setLayout(JPIDatosUsuarioLayout);
        JPIDatosUsuarioLayout.setHorizontalGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosUsuarioLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFNombre).addGroup(JPIDatosUsuarioLayout.createSequentialGroup().addComponent(this.JTFNHistoria, -2, 256, -2).addGap(18, 18, 18).addComponent(this.JTFNDocumento, -2, 290, -2).addGap(20, 20, 20).addComponent(this.JTFTipoDoc, -2, 280, -2))).addContainerGap(16, 32767)));
        JPIDatosUsuarioLayout.setVerticalGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosUsuarioLayout.createSequentialGroup().addGap(21, 21, 21).addGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNDocumento, -2, 50, -2).addComponent(this.JTFNHistoria, -2, 50, -2)).addComponent(this.JTFTipoDoc, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.JTFNombre, -2, 50, -2).addContainerGap()));
        this.JPIDatosN.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS NUEVOS", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTFNNHistoria.setFont(new Font("Arial", 1, 12));
        this.JTFNNHistoria.setBorder(BorderFactory.createTitledBorder((Border) null, "Historia", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNNDocumento.setFont(new Font("Arial", 1, 12));
        this.JTFNNDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBNTipoDoc.setFont(new Font("Arial", 1, 12));
        this.JCBNTipoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPIDatosNLayout = new GroupLayout(this.JPIDatosN);
        this.JPIDatosN.setLayout(JPIDatosNLayout);
        JPIDatosNLayout.setHorizontalGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.JTFNNHistoria, -2, 270, -2).addGap(10, 10, 10).addComponent(this.JTFNNDocumento, -2, 270, -2).addGap(10, 10, 10).addComponent(this.JCBNTipoDoc, -2, 300, -2).addContainerGap(16, 32767)));
        JPIDatosNLayout.setVerticalGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosNLayout.createSequentialGroup().addGap(11, 11, 11).addGroup(JPIDatosNLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNNHistoria, -2, 50, -2).addComponent(this.JTFNNDocumento, -2, 50, -2).addComponent(this.JCBNTipoDoc, -2, 50, -2)).addContainerGap(13, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosUsuario, -2, -1, -2).addComponent(this.JPIDatosN, -2, -1, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JPIDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosN, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNHistoriaActionPerformed(ActionEvent evt) {
        this.JTFNHistoria.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNHistoriaFocusLost(FocusEvent evt) {
        mBuscarUsuario();
    }
}
