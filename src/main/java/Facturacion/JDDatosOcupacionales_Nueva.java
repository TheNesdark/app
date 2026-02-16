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
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JDDatosOcupacionales_Nueva.class */
public class JDDatosOcupacionales_Nueva extends JDialog {
    private String[] xidtipoexamen;
    private String[] xidcargo;
    private String[] xidempresa;
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String xsql;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JComboBox JCBEmpresaC;
    private JComboBox JCBTipoExamen;
    private JPanel JPIDatos;
    private JFormattedTextField JTFFArp;
    private JFormattedTextField JTFFCargo;
    private JFormattedTextField JTFFEps;
    private JFormattedTextField JTFFNId;

    public JDDatosOcupacionales_Nueva(Frame parent, boolean modal) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        Principal.txtNo.setText(Principal.clasefacturacion.frmFacturac.frmIngreso.getIdIngreso());
        setLocationRelativeTo(Principal.clasefacturacion.frmFacturac);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mNuevo();
        mBuscar();
    }

    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBTipoExamen = new JComboBox();
        this.JTFFCargo = new JFormattedTextField();
        this.JTFFEps = new JFormattedTextField();
        this.JTFFArp = new JFormattedTextField();
        this.JCBEmpresaC = new JComboBox();
        this.JTFFNId = new JFormattedTextField();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("DATOS OCUPACIONALES");
        setFont(new Font("Arial", 1, 12));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA ATENCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoExamen.setFont(new Font("Arial", 1, 12));
        this.JCBTipoExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Exámen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCargo.setHorizontalAlignment(2);
        this.JTFFCargo.setFont(new Font("Arial", 1, 12));
        this.JTFFEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Eps", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEps.setHorizontalAlignment(2);
        this.JTFFEps.setFont(new Font("Arial", 1, 12));
        this.JTFFArp.setBorder(BorderFactory.createTitledBorder((Border) null, "Arl", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFArp.setHorizontalAlignment(2);
        this.JTFFArp.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresaC.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa en Misión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNId.setEditable(false);
        this.JTFFNId.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNId.setForeground(Color.red);
        this.JTFFNId.setHorizontalAlignment(0);
        this.JTFFNId.setFont(new Font("Arial", 1, 18));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEmpresaC, 0, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoExamen, -2, 191, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFCargo).addGap(12, 12, 12).addComponent(this.JTFFNId, -2, 129, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFEps, -2, 332, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFArp))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoExamen, -2, 50, -2).addComponent(this.JTFFNId, -2, 50, -2).addComponent(this.JTFFCargo, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFEps, -2, 50, -2).addComponent(this.JTFFArp, -2, 50, -2)).addGap(18, 18, 18).addComponent(this.JCBEmpresaC, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Facturacion.JDDatosOcupacionales_Nueva.1
            public void actionPerformed(ActionEvent evt) {
                JDDatosOcupacionales_Nueva.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Facturacion.JDDatosOcupacionales_Nueva.2
            public void actionPerformed(ActionEvent evt) {
                JDDatosOcupacionales_Nueva.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 351, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTSalir, -2, 351, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -2, 55, -2).addComponent(this.JBTSalir, -2, 55, -2)).addGap(33, 33, 33)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (this.JCBTipoExamen.getSelectedIndex() != -1) {
            if (!this.JTFFCargo.getText().isEmpty()) {
                if (this.JTFFNId.getText().isEmpty()) {
                    Principal.clasefacturacion.frmFacturac.frmOrdenes.setXidclasecita(this.xidtipoexamen[this.JCBTipoExamen.getSelectedIndex()]);
                    Principal.clasefacturacion.frmFacturac.frmIngreso.mGrabarAtencion();
                    this.xsql = "insert into h_so_datos_ocupacionales (Id_Atencion ,  cargo , empresaMision, Eps , Arp , UsuarioS) values ('" + Principal.clasefacturacion.frmFacturac.frmIngreso.getXidatencion() + "','" + this.JTFFCargo.getText() + "','" + this.JCBEmpresaC.getSelectedItem() + "','" + this.JTFFEps.getText() + "','" + this.JTFFArp.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JTFFNId.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                } else {
                    this.xsql = "update h_so_datos_ocupacionales set cargo='" + this.JTFFCargo.getText() + "', empresaMision='" + this.JCBEmpresaC.getSelectedItem() + "', Eps='" + this.JTFFEps.getText() + "', Arp='" + this.JTFFArp.getText() + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.JTFFNId.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "update h_atencion set Id_ClaseCita='" + this.xidtipoexamen[this.JCBTipoExamen.getSelectedIndex()] + "', Id_Especialidad='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdEspecialidad() + "', Id_Profesional='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdProfesional() + "' where Id_Ingreso='" + Principal.txtNo.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "update ingreso set  Id_Especialidad='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdEspecialidad() + "', Id_Profesional='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdProfesional() + "' where Id='" + Principal.txtNo.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cargo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFCargo.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de exámen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoExamen.requestFocus();
    }

    private void mNuevo() {
        this.xsql = "SELECT Id, Nbre FROM c_clasecita WHERE (Id_Especialidad ='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdEspecialidad() + "' AND Estado =0) ORDER BY Nbre ASC, Id_Especialidad ASC";
        this.xidtipoexamen = this.xct.llenarCombo(this.xsql, this.xidtipoexamen, this.JCBTipoExamen);
        this.JCBTipoExamen.setSelectedIndex(-1);
        this.xsql = "select fem.id , fem.nombre \nfrom f_empresacontxconvenio_mision fem \nwhere fem.idEmpresaConvenio ='" + Principal.clasefacturacion.frmFacturac.frmIngreso.listConvenio.get(Principal.clasefacturacion.frmFacturac.frmIngreso.cboEmpresa.getSelectedIndex()).getId() + "'\norder by fem.nombre asc";
        this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresaC);
        if (this.xidempresa.length < 1) {
            this.JCBEmpresaC.setSelectedItem(Principal.clasefacturacion.frmFacturac.frmIngreso.cboEmpresa.getSelectedItem());
        }
        this.xct.cerrarConexionBd();
        this.JTFFEps.setText("");
        this.JTFFArp.setText("");
        this.JCBTipoExamen.requestFocus();
    }

    private void mBuscar() {
        this.xsql = "SELECT  `h_so_datos_ocupacionales`.`Id` , `h_so_datos_ocupacionales`.`cargo` , h_so_datos_ocupacionales.empresaMision , `c_clasecita`.`Nbre` , `h_so_datos_ocupacionales`.`Eps` , `h_so_datos_ocupacionales`.`Arp` FROM `h_so_datos_ocupacionales` INNER JOIN  `h_atencion`  ON (`h_so_datos_ocupacionales`.`Id_Atencion` = `h_atencion`.`Id`)  INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`h_atencion`.`Id_Ingreso` ='" + Principal.txtNo.getText() + "') ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTFFNId.setText(xrs.getString(1));
                this.JTFFCargo.setText(xrs.getString(2));
                this.JCBEmpresaC.setSelectedItem(xrs.getString(3));
                this.JCBTipoExamen.setSelectedItem(xrs.getString(4));
                this.JTFFArp.setText(xrs.getString(6));
                this.JTFFEps.setText(xrs.getString(5));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDDatosOcupacionales_Nueva.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
