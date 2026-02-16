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

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JDDatosOcupacionales.class */
public class JDDatosOcupacionales extends JDialog {
    private String[] xidtipoexamen;
    private String[] xidcargo;
    private String[] xidempresa;
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String xsql;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JComboBox JCBCargo;
    private JComboBox JCBEmpresaC;
    private JComboBox JCBTipoExamen;
    private JPanel JPIDatos;
    private JFormattedTextField JTFFArp;
    private JFormattedTextField JTFFEps;
    private JFormattedTextField JTFFNId;

    public JDDatosOcupacionales(Frame parent, boolean modal) {
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
        this.JCBCargo = new JComboBox();
        this.JTFFEps = new JFormattedTextField();
        this.JTFFArp = new JFormattedTextField();
        this.JTFFNId = new JFormattedTextField();
        this.JCBEmpresaC = new JComboBox();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("DATOS OCUPACIONALES");
        setFont(new Font("Arial", 1, 12));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA ATENCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoExamen.setFont(new Font("Arial", 1, 12));
        this.JCBTipoExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Exámen", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCargo.setFont(new Font("Arial", 1, 12));
        this.JCBCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo a Desempeñar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Eps Anterior", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEps.setHorizontalAlignment(2);
        this.JTFFEps.setFont(new Font("Arial", 1, 12));
        this.JTFFArp.setBorder(BorderFactory.createTitledBorder((Border) null, "Arp Anterior", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFArp.setHorizontalAlignment(2);
        this.JTFFArp.setFont(new Font("Arial", 1, 12));
        this.JTFFNId.setEditable(false);
        this.JTFFNId.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNId.setForeground(Color.red);
        this.JTFFNId.setHorizontalAlignment(0);
        this.JTFFNId.setFont(new Font("Arial", 1, 18));
        this.JCBEmpresaC.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBEmpresaC, 0, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBTipoExamen, -2, 191, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBCargo, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNId, -2, 129, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFFEps, -2, 332, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFArp))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoExamen, -2, -1, -2).addComponent(this.JTFFNId, -2, -1, -2).addComponent(this.JCBCargo, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFEps, -2, -1, -2).addComponent(this.JTFFArp, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.JCBEmpresaC, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Facturacion.JDDatosOcupacionales.1
            public void actionPerformed(ActionEvent evt) {
                JDDatosOcupacionales.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Facturacion.JDDatosOcupacionales.2
            public void actionPerformed(ActionEvent evt) {
                JDDatosOcupacionales.this.JBTSalirActionPerformed(evt);
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
            if (this.JCBCargo.getSelectedIndex() != -1) {
                if (this.JTFFNId.getText().isEmpty()) {
                    Principal.clasefacturacion.frmFacturac.frmOrdenes.setXidclasecita(this.xidtipoexamen[this.JCBTipoExamen.getSelectedIndex()]);
                    Principal.clasefacturacion.frmFacturac.frmIngreso.mGrabarAtencion();
                    this.xsql = "insert into h_so_datos_ocupacionales (Id_Atencion ,  IdCargo , Id_EmpresaContxConv, Eps , Arp , UsuarioS) values ('" + Principal.clasefacturacion.frmFacturac.frmIngreso.getXidatencion() + "','" + this.xidcargo[this.JCBCargo.getSelectedIndex()] + "','" + this.xidempresa[this.JCBEmpresaC.getSelectedIndex()] + "','" + this.JTFFEps.getText() + "','" + this.JTFFArp.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JTFFNId.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                } else {
                    this.xsql = "update h_so_datos_ocupacionales set IdCargo='" + this.xidcargo[this.JCBCargo.getSelectedIndex()] + "', Id_EmpresaContxConv='" + this.xidempresa[this.JCBEmpresaC.getSelectedIndex()] + "', Eps='" + this.JTFFEps.getText() + "', Arp='" + this.JTFFArp.getText() + "', Fecha='" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "' where Id='" + this.JTFFNId.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "update h_atencion set Id_ClaseCita='" + this.xidtipoexamen[this.JCBTipoExamen.getSelectedIndex()] + "', Id_Especialidad='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdEspecialidad() + "', Id_Profesional='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdProfesional() + "' where Id_Ingreso='" + Principal.txtNo.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    this.xsql = "update ingreso set  Id_Especialidad='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdEspecialidad() + "', Id_Profesional='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdProfesional() + "' where Id='" + Principal.txtNo.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
                mImprimir();
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cargo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBCargo.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de exámen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBTipoExamen.requestFocus();
    }

    private void mImprimir() {
        String[][] mparametros = new String[4][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = this.JTFFNId.getText();
        mparametros[1][0] = "UsuarioS";
        mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        mparametros[2][0] = "SUBREPORT_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[3][0] = "SUBREPORTFIRMA_DIR";
        mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getNombreIps().equals("ASC EN SALUD TOTAL SAS")) {
            Principal.clasefacturacion.mImprimir("Facturac");
            return;
        }
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_Autorizacion_examen", mparametros);
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_FichaClinicaOcupacional", mparametros);
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_Informe_Resultado", mparametros);
        if (this.xidtipoexamen[this.JCBTipoExamen.getSelectedIndex()].equals("181")) {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_AptitudMedicaEgreso", mparametros);
        } else {
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "so_aptitud_medica", mparametros);
        }
    }

    private void mNuevo() {
        this.xsql = "SELECT Id, Nbre FROM c_clasecita WHERE (Id_Especialidad ='" + Principal.clasefacturacion.frmFacturac.frmIngreso.getIdEspecialidad() + "' AND Estado =0) ORDER BY Nbre ASC, Id_Especialidad ASC";
        this.xidtipoexamen = this.xct.llenarCombo(this.xsql, this.xidtipoexamen, this.JCBTipoExamen);
        this.JCBTipoExamen.setSelectedIndex(-1);
        this.xidcargo = this.xct.llenarCombo("SELECT Id ,  Nbre FROM g_cargos WHERE (Estado =1) ORDER BY Nbre ASC", this.xidcargo, this.JCBCargo);
        this.JCBCargo.setSelectedIndex(-1);
        this.xsql = "SELECT f_empresacontxconvenio.Id AS Id, f_empresacontxconvenio.Nbre AS Empresa_Contratante, f_empresacontxconvenio.Id_Manual, f_empresacontxconvenio.EsCapitado, f_empresacontxconvenio.CualValor, g_empresacont.Id_TipoPlan, f_empresacontxconvenio.FiltroProcxEmp, f_empresacontxconvenio.ValidacionUsuario, f_empresacontxconvenio.ValidarDatos, f_empresacontxconvenio.Descuento FROM f_empresacontxconvenio INNER JOIN g_empresacont ON (f_empresacontxconvenio.Id_EmpresaCont = g_empresacont.Id_empresa)  INNER JOIN g_contratos  ON (g_contratos.Id_EmpresaContConvenio  = f_empresacontxconvenio.Id) WHERE (f_empresacontxconvenio.Estado =0)  GROUP BY f_empresacontxconvenio.Id ORDER BY f_empresacontxconvenio.Nbre ASC  ";
        this.xidempresa = this.xct.llenarCombo(this.xsql, this.xidempresa, this.JCBEmpresaC);
        this.JCBEmpresaC.setSelectedItem(Principal.clasefacturacion.frmFacturac.frmIngreso.cboEmpresa.getSelectedItem());
        this.xct.cerrarConexionBd();
        this.JTFFEps.setText("");
        this.JTFFArp.setText("");
        this.JCBTipoExamen.requestFocus();
    }

    private void mBuscar() {
        this.xsql = "SELECT  `h_so_datos_ocupacionales`.`Id` , `g_cargos`.`Nbre` , `f_empresacontxconvenio`.`Nbre` , `c_clasecita`.`Nbre` , `h_so_datos_ocupacionales`.`Eps` , `h_so_datos_ocupacionales`.`Arp` FROM `h_so_datos_ocupacionales` INNER JOIN  `h_atencion`  ON (`h_so_datos_ocupacionales`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `f_empresacontxconvenio`  ON (`h_so_datos_ocupacionales`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`) INNER JOIN  `g_cargos` ON (`h_so_datos_ocupacionales`.`IdCargo` = `g_cargos`.`Id`) INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) WHERE (`h_atencion`.`Id_Ingreso` ='" + Principal.txtNo.getText() + "') ";
        ResultSet xrs = this.xct.traerRs(this.xsql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTFFNId.setText(xrs.getString(1));
                this.JCBCargo.setSelectedItem(xrs.getString(2));
                this.JCBEmpresaC.setSelectedItem(xrs.getString(3));
                this.JCBTipoExamen.setSelectedItem(xrs.getString(4));
                this.JTFFArp.setText(xrs.getString(6));
                this.JTFFEps.setText(xrs.getString(5));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDDatosOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
