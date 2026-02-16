package Caja;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Caja/Recibos.class */
public class Recibos extends JInternalFrame {
    private DefaultTableModel modelo;
    int radioEvento;
    int radioCapita;
    private String[] listaCC;
    private String[] listaTipoDocumento;
    private String[] listaProfesional;
    private String[] listaingreso;
    private String[][] listaEPS;
    private String[][] listaConceptos;
    private ResultSet rs;
    private long xIdCierre;
    private Object[] dato;
    private String sql;
    private String idRecibo;
    private String[][] xId_Fpago;
    private claseCaja classCaja;
    private JComboBox JCBIngreso;
    private JDateChooser JDFecha;
    private JRadioButton JRBCapita;
    private JRadioButton JRBEvento;
    private JButton btnCargar;
    private JButton btnCargar1;
    private ButtonGroup buttonGroup1;
    private JComboBox cboCC;
    private JComboBox cboConcepto;
    public JComboBox cboEPS;
    private JComboBox cboFormaPago;
    private JComboBox cboTipoDocumento;
    private JTable grid;
    private JTable gridFP;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTabbedPane jTabbedPane1;
    private JFormattedTextField txtCantidad;
    private JFormattedTextField txtDescuento;
    private JTextField txtDocumento;
    public JFormattedTextField txtEstado;
    private JDateChooser txtFecha1raCuota;
    private JSpinner txtNoCuotas;
    public JFormattedTextField txtNoRecibo;
    private JTextArea txtObservacion;
    private JFormattedTextField txtTotal;
    private JFormattedTextField txtTotalRecibo;
    private JFormattedTextField txtValor;
    private JFormattedTextField txtValorRecibo;
    private JFormattedTextField txtValorTotal;
    private JFormattedTextField txtValorUnit;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    int cboLleno = 0;
    private int formaPago = 0;
    private int filaGrid = 0;
    private int xConsultoF = 0;
    private long xidpaciente = 0;
    private long xidingreso = 0;
    private Boolean xlleno = false;
    public JTextFieldValidator txtNoFactura = new JTextFieldValidator();
    private JTextFieldValidator txtPaciente = new JTextFieldValidator();

    public Recibos(claseCaja xclaseCaja) {
        initComponents();
        System.out.println("esta es");
        cargarComponentesDeLib();
        this.classCaja = xclaseCaja;
        setTitle("RECIBOS DE INGRESO DE LA CAJA: " + Principal.clasecaja.getNbreCaja().toUpperCase());
        cargarCombos();
        crearGrid();
        nuevo();
        eventoCapita();
    }

    private void cargarComponentesDeLib() {
        this.txtNoFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Factura", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtNoFactura.setText("0");
        this.txtNoFactura.setExprecionRegular("^[A-Z0-9]*$");
        this.txtNoFactura.setFont(new Font("Arial", 1, 12));
        this.txtNoFactura.addFocusListener(new FocusAdapter() { // from class: Caja.Recibos.1
            public void focusGained(FocusEvent evt) {
                Recibos.this.txtNoFacturaFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Recibos.this.txtNoFacturaFocusLost(evt);
            }
        });
        this.txtNoFactura.addActionListener(new ActionListener() { // from class: Caja.Recibos.2
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.txtNoFacturaActionPerformed(evt);
            }
        });
        this.jPanel3.add(this.txtNoFactura, new AbsoluteConstraints(10, 30, 110, 40));
        this.txtPaciente.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtPaciente.setFont(new Font("Arial", 1, 12));
        this.txtPaciente.addFocusListener(new FocusAdapter() { // from class: Caja.Recibos.3
            public void focusGained(FocusEvent evt) {
                Recibos.this.txtPacienteFocusGained(evt);
            }
        });
        this.jPanel3.add(this.txtPaciente, new AbsoluteConstraints(420, 20, 300, 50));
    }

    public void anular() {
        if (this.xIdCierre == 0) {
            Anular frm = new Anular(null, true, "Caja", 12);
            frm.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "Recibo con cierre No. " + this.xIdCierre + " activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void activarFormaPago(int op) {
        if (op == 0) {
            this.formaPago = 0;
            this.cboFormaPago.setEnabled(false);
            this.txtValor.setEnabled(false);
            this.txtNoCuotas.setEnabled(false);
            this.txtFecha1raCuota.setEnabled(false);
            this.gridFP.setEnabled(false);
            return;
        }
        this.formaPago = 1;
        this.cboFormaPago.setEnabled(true);
        this.txtValor.setEnabled(true);
        this.txtNoCuotas.setEnabled(true);
        this.txtFecha1raCuota.setEnabled(true);
        this.gridFP.setEnabled(true);
    }

    public void buscar() {
        Buscar dialog = new Buscar(null, false, this, this.classCaja);
        dialog.setVisible(true);
    }

    public void buscarFactura() {
        this.xConsultoF = 0;
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
            System.out.println("es labvy");
            System.out.println("evento -> " + this.radioEvento);
            System.out.println("capita -> " + this.radioCapita);
            if (this.radioEvento == 1) {
                System.out.println("es evento");
                this.sql = "with liquidacion as (\nSELECT g_tipoidentificacion.Nbre as tipoIdentificacion  \n, gp.NoDocumento  as NoDocumento\n, concat(gp.Apellido1 , ' ', gp.Apellido2, ' ', gp.Nombre1 , ' ', gp.Nombre2)  as NUsuario, \nIF( g_empresacont.`Id_TipoEmprCont`=6,(f_liquidacion.`TotalServicio`-f_liquidacion.`TotalDescuento`), (f_liquidacion.TotalPaciente+f_liquidacion.CuotaModeradora+f_liquidacion.Copago)) AS total\n-- , profesional1.NProfesional\n, f_centrocosto.Nbre as centroCosto\n, ingreso.Id as Ingreso\n, gp.Id as Id_persona , f_empresacontxconvenio.Nbre empresaConvenio\nFROM f_liquidacion \nINNER JOIN ingreso ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`) \nINNER JOIN `g_empresacont` ON (f_empresacontxconvenio.`Id_EmpresaCont` = g_empresacont.`Id_empresa`)\nINNER JOIN g_persona gp ON (gp.Id  = ingreso.Id_Usuario) \n-- INNER JOIN profesional1 ON (profesional1.Id_Persona = ingreso.Id_Profesional) AND (profesional1.IdEspecialidad = ingreso.Id_Especialidad)\nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)\nINNER JOIN f_centrocosto ON (f_ordenes.Id_CentroCosto = f_centrocosto.Id) \n INNER JOIN g_tipoidentificacion ON (gp.Id_TipoIdentificacion = g_tipoidentificacion.Id) \nleft JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)  AND f_factura_capita.Estado=0\nleft JOIN f_factura_evento ffe ON (ffe.Id_Liquidacion = f_liquidacion.Id)  AND ffe.Estado=0\nWHERE ((if(ffe.Prefijo ='', ffe.No_FacturaEvento_M, concat(ffe.Prefijo,'',ffe.No_FacturaEvento_M)) ='" + this.txtNoFactura.getText() + "')\nAND f_liquidacion.Estado=0 )\n),  \n\n recibo as (\n\tSELECT \n\tkr.Id_Ingreso , sum(ki.Cantidad*ki.VrUnitario) valor\n\tfrom k_recibos kr \n\tinner join k_itemrecibos ki  on (kr.Id=ki.Id_Recibo)\n\twhere kr.Estado =0\n\tgroup by kr.Id_Ingreso\n)\n\nSELECT liquidacion.tipoIdentificacion  \n, liquidacion.NoDocumento\n, liquidacion.NUsuario\n, (liquidacion.total-ifnull(recibo.valor,0)) valorPagar\n, liquidacion.centroCosto\n, liquidacion.Ingreso\n,liquidacion.Id_persona \n, recibo.valor, liquidacion.empresaConvenio\nfrom liquidacion\nleft join recibo on (recibo.Id_Ingreso=liquidacion.Ingreso)\n-- HAVING valorPagar<>0";
            } else if (this.radioCapita == 1) {
                System.out.println("es capita");
                this.sql = "with liquidacion as (\nSELECT g_tipoidentificacion.Nbre as tipoIdentificacion  \n, gp.NoDocumento  as NoDocumento\n, concat(gp.Apellido1 , ' ', gp.Apellido2, ' ', gp.Nombre1 , ' ', gp.Nombre2)  as NUsuario, \nIF( g_empresacont.`Id_TipoEmprCont`=6,(f_liquidacion.`TotalServicio`-f_liquidacion.`TotalDescuento`), (f_liquidacion.TotalPaciente+f_liquidacion.CuotaModeradora+f_liquidacion.Copago)) AS total\n-- , profesional1.NProfesional\n, f_centrocosto.Nbre as centroCosto\n, ingreso.Id as Ingreso\n, gp.Id as Id_persona , f_empresacontxconvenio.Nbre empresaConvenio\nFROM f_liquidacion \nINNER JOIN ingreso ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`) \nINNER JOIN `g_empresacont` ON (f_empresacontxconvenio.`Id_EmpresaCont` = g_empresacont.`Id_empresa`)\nINNER JOIN g_persona gp ON (gp.Id  = ingreso.Id_Usuario) \n-- INNER JOIN profesional1 ON (profesional1.Id_Persona = ingreso.Id_Profesional) AND (profesional1.IdEspecialidad = ingreso.Id_Especialidad)\nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)\nINNER JOIN f_centrocosto ON (f_ordenes.Id_CentroCosto = f_centrocosto.Id) \n INNER JOIN g_tipoidentificacion ON (gp.Id_TipoIdentificacion = g_tipoidentificacion.Id) \nleft JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)  AND f_factura_capita.Estado=0\nleft JOIN f_factura_evento ffe ON (ffe.Id_Liquidacion = f_liquidacion.Id)  AND ffe.Estado=0\nWHERE ((f_factura_capita.No_FacturaCapita='" + this.txtNoFactura.getText() + "' or if(ffe.Prefijo ='', ffe.No_FacturaEvento_M, concat(ffe.Prefijo,'',ffe.No_FacturaEvento_M)) ='" + this.txtNoFactura.getText() + "')\nAND f_liquidacion.Estado=0 )\n),  \n\n recibo as (\n\tSELECT \n\tkr.Id_Ingreso , sum(ki.Cantidad*ki.VrUnitario) valor\n\tfrom k_recibos kr \n\tinner join k_itemrecibos ki  on (kr.Id=ki.Id_Recibo)\n\twhere kr.Estado =0\n\tgroup by kr.Id_Ingreso\n)\n\nSELECT liquidacion.tipoIdentificacion  \n, liquidacion.NoDocumento\n, liquidacion.NUsuario\n, (liquidacion.total-ifnull(recibo.valor,0)) valorPagar\n, liquidacion.centroCosto\n, liquidacion.Ingreso\n,liquidacion.Id_persona \n, recibo.valor, liquidacion.empresaConvenio\nfrom liquidacion\nleft join recibo on (recibo.Id_Ingreso=liquidacion.Ingreso)\n-- HAVING valorPagar<>0";
            }
        } else {
            this.sql = "with liquidacion as (\nSELECT g_tipoidentificacion.Nbre as tipoIdentificacion  \n, gp.NoDocumento  as NoDocumento\n, concat(gp.Apellido1 , ' ', gp.Apellido2, ' ', gp.Nombre1 , ' ', gp.Nombre2)  as NUsuario, \nIF( g_empresacont.`Id_TipoEmprCont`=6,(f_liquidacion.`TotalServicio`-f_liquidacion.`TotalDescuento`), (f_liquidacion.TotalPaciente+f_liquidacion.CuotaModeradora+f_liquidacion.Copago)) AS total\n-- , profesional1.NProfesional\n, f_centrocosto.Nbre as centroCosto\n, ingreso.Id as Ingreso\n, gp.Id as Id_persona , f_empresacontxconvenio.Nbre empresaConvenio\nFROM f_liquidacion \nINNER JOIN ingreso ON (f_liquidacion.Id_Ingreso = ingreso.Id) \nINNER JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`) \nINNER JOIN `g_empresacont` ON (f_empresacontxconvenio.`Id_EmpresaCont` = g_empresacont.`Id_empresa`)\nINNER JOIN g_persona gp ON (gp.Id  = ingreso.Id_Usuario) \n-- INNER JOIN profesional1 ON (profesional1.Id_Persona = ingreso.Id_Profesional) AND (profesional1.IdEspecialidad = ingreso.Id_Especialidad)\nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id)\nINNER JOIN f_centrocosto ON (f_ordenes.Id_CentroCosto = f_centrocosto.Id) \n INNER JOIN g_tipoidentificacion ON (gp.Id_TipoIdentificacion = g_tipoidentificacion.Id) \nleft JOIN f_factura_capita ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id)  AND f_factura_capita.Estado=0\nleft JOIN f_factura_evento ffe ON (ffe.Id_Liquidacion = f_liquidacion.Id)  AND ffe.Estado=0\nWHERE ((f_factura_capita.No_FacturaCapita='" + this.txtNoFactura.getText() + "' or if(ffe.Prefijo ='', ffe.No_FacturaEvento_M, concat(ffe.Prefijo,'',ffe.No_FacturaEvento_M)) ='" + this.txtNoFactura.getText() + "')\nAND f_liquidacion.Estado=0 )\n),  \n\n recibo as (\n\tSELECT \n\tkr.Id_Ingreso , sum(ki.Cantidad*ki.VrUnitario) valor\n\tfrom k_recibos kr \n\tinner join k_itemrecibos ki  on (kr.Id=ki.Id_Recibo)\n\twhere kr.Estado =0\n\tgroup by kr.Id_Ingreso\n)\n\nSELECT liquidacion.tipoIdentificacion  \n, liquidacion.NoDocumento\n, liquidacion.NUsuario\n, (liquidacion.total-ifnull(recibo.valor,0)) valorPagar\n, liquidacion.centroCosto\n, liquidacion.Ingreso\n,liquidacion.Id_persona \n, recibo.valor, liquidacion.empresaConvenio\nfrom liquidacion\nleft join recibo on (recibo.Id_Ingreso=liquidacion.Ingreso)\n-- HAVING valorPagar<>0";
        }
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.cboTipoDocumento.setSelectedItem(this.rs.getString("tipoIdentificacion"));
                this.txtDocumento.setText(this.rs.getString("NoDocumento"));
                this.txtPaciente.setText(this.rs.getString("NUsuario"));
                this.cboCC.setSelectedItem(this.rs.getString("centroCosto"));
                this.xidingreso = this.rs.getLong("Ingreso");
                this.xidpaciente = this.rs.getLong("Id_persona");
                this.cboCC.setSelectedItem(this.rs.getString("centroCosto"));
                this.cboEPS.setSelectedItem(this.rs.getString("empresaConvenio"));
                if (this.rs.getDouble("valorPagar") == 0.0d) {
                    JOptionPane.showInternalMessageDialog(this, "Factura sin saldo pendiente", "CONSULTAR DATOS", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nuevo();
                } else {
                    this.txtValorUnit.setValue(Double.valueOf(this.rs.getDouble("valorPagar")));
                    this.txtValorTotal.setValue(Double.valueOf(this.rs.getDouble("valorPagar")));
                }
                this.xConsultoF = 1;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
            this.xlleno = false;
            this.JCBIngreso.removeAllItems();
            this.listaingreso = this.consultas.llenarCombo("SELECT `f_factura_evento`.`No_FacturaEvento`, CONCAT(`ingreso`.`Id`,' - ', `ingreso`.`FechaIngreso`) AS Ingreso  \nFROM `f_liquidacion` \nINNER JOIN `ingreso` ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`)\nINNER JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`) \nINNER JOIN `g_empresacont` ON (f_empresacontxconvenio.`Id_EmpresaCont` = g_empresacont.`Id_empresa`)\nINNER JOIN w_persona ON (w_persona.Id_persona = ingreso.Id_Usuario)\nINNER JOIN profesional1 ON (profesional1.Id_Persona = ingreso.Id_Profesional) AND (profesional1.IdEspecialidad = ingreso.Id_Especialidad) \nINNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \nINNER JOIN f_centrocosto ON (f_ordenes.Id_CentroCosto = f_centrocosto.Id)\nINNER JOIN g_tipoidentificacion ON (w_persona.Id_TipoIdentificacion = g_tipoidentificacion.Id) \nINNER JOIN `f_factura_evento` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) \nWHERE (`ingreso`.`Id_Usuario`  ='" + this.xidpaciente + "'  AND `ingreso`.`Estado` =0) ORDER BY `ingreso`.`Id` DESC", this.listaingreso, this.JCBIngreso);
            this.JCBIngreso.setSelectedIndex(-1);
            this.consultas.cerrarConexionBd();
            this.xlleno = true;
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void mBuscarDatosFacturaA(int xvalor, String xtipo) {
        this.sql = "SELECT `f_centrocosto`.`Nbre` as CCosto  , `k_conceptos`.`Nbre` as Concepto, SUM(`k_itemrecibos`.`VrUnitario`) as Valor FROM `k_itemrecibos` INNER JOIN  `k_recibos`  ON (`k_itemrecibos`.`Id_Recibo` = `k_recibos`.`Id`) INNER JOIN `k_conceptos`  ON (`k_itemrecibos`.`Id_Concepto` = `k_conceptos`.`Id`) INNER JOIN `f_centrocosto` ON (`k_recibos`.`Id_CentroCosto` = `f_centrocosto`.`Id`) WHERE (`k_recibos`.`NoFactura` ='" + this.txtNoFactura.getText() + "' AND `k_recibos`.`Estado` =0 AND `k_recibos`.`Tipo` ='" + xtipo + "') GROUP BY `k_recibos`.`NoFactura` ";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(this.sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.cboCC.setSelectedItem(xrs.getString("CCosto"));
                this.cboConcepto.setSelectedItem(xrs.getString("Concepto"));
                xrs.beforeFirst();
                double xvalorr = 0.0d;
                while (xrs.next()) {
                    xvalorr += xrs.getDouble("Valor");
                }
                if (((double) xvalor) - xvalorr == 0.0d) {
                    JOptionPane.showInternalMessageDialog(this, "Factura sin saldo pendiente", "CONSULTAR DATOS", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                } else {
                    this.txtValorUnit.setValue(Double.valueOf(((double) xvalor) - xvalorr));
                    this.txtValorTotal.setValue(Double.valueOf(((double) xvalor) - xvalorr));
                }
            } else {
                this.txtValorUnit.setValue(Integer.valueOf(xvalor));
                this.txtValorTotal.setValue(Integer.valueOf(xvalor));
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Recibos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void buscarPaciente(String Tipo, String Doc) {
        try {
            this.sql = "SELECT NUsuario, w_persona.Id_Persona FROM w_persona INNER JOIN g_tipoidentificacion ON (w_persona.Id_TipoIdentificacion = g_tipoidentificacion.Id) WHERE (g_tipoidentificacion.Nbre ='" + Tipo + "' AND w_persona.NoDocumento ='" + Doc + "')";
            ResultSet xrs = this.consultas.traerRs(this.sql);
            if (xrs.next()) {
                xrs.first();
                this.txtPaciente.setText(xrs.getString("NUsuario"));
                this.xidpaciente = xrs.getLong("Id_Persona");
            }
            xrs.close();
            this.consultas.cerrarConexionBd();
            this.xlleno = false;
            this.JCBIngreso.removeAllItems();
            String sql = "SELECT if(ffc.No_FacturaCapita is null, `f_factura_evento`.`No_FacturaEvento_M`,ffc.No_FacturaCapita ) numeroFacturaNota , CONCAT(`ingreso`.`Id`,' - ', `ingreso`.`FechaIngreso`) AS Ingreso  \nFROM `ingreso`\nINNER JOIN `f_liquidacion`  ON (`f_liquidacion`.`Id_Ingreso` = `ingreso`.`Id`) and (f_liquidacion.Estado=0)\nINNER JOIN `f_empresacontxconvenio` ON (f_empresacontxconvenio.`Id` = ingreso.`Id_EmpresaContxConv`) \n-- INNER JOIN `g_empresacont` ON (f_empresacontxconvenio.`Id_EmpresaCont` = g_empresacont.`Id_empresa`)\n-- INNER JOIN w_persona ON (w_persona.Id_persona = ingreso.Id_Usuario)\n-- INNER JOIN profesional1 ON (profesional1.Id_Persona = ingreso.Id_Profesional) AND (profesional1.IdEspecialidad = ingreso.Id_Especialidad) \n-- INNER JOIN f_ordenes ON (f_ordenes.Id_Ingreso = ingreso.Id) \n-- INNER JOIN f_centrocosto ON (f_ordenes.Id_CentroCosto = f_centrocosto.Id)\n-- INNER JOIN g_tipoidentificacion ON (w_persona.Id_TipoIdentificacion = g_tipoidentificacion.Id) \nleft JOIN `f_factura_evento` ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) and (f_factura_evento.Estado=0)\nleft join f_factura_capita ffc on (ffc.Id_Liquidacion=f_liquidacion.Id) and (ffc.Estado=0)\nWHERE (`ingreso`.`Id_Usuario`  ='" + this.xidpaciente + "'  AND `ingreso`.`Estado` =0) ORDER BY `ingreso`.`Id` DESC";
            this.listaingreso = this.consultas.llenarCombo(sql, this.listaingreso, this.JCBIngreso);
            this.JCBIngreso.setSelectedIndex(-1);
            this.consultas.cerrarConexionBd();
            this.xlleno = true;
        } catch (SQLException ex) {
            Logger.getLogger(Recibos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarGrid() {
        if (this.cboConcepto.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione un Concepto de pago");
            this.cboConcepto.requestFocus();
            return;
        }
        if (Integer.parseInt(this.txtCantidad.getValue().toString()) < 1) {
            this.metodos.mostrarMensaje("Por favor coloque la Cantidad");
            this.txtCantidad.requestFocus();
            return;
        }
        if (this.txtValorUnit.getText().isEmpty() || this.txtValorUnit.getText().equals("0")) {
            this.metodos.mostrarMensaje("Por favor coloque un Valor Unitario");
            this.txtValorUnit.requestFocus();
            return;
        }
        if (verificarConcepto(this.listaConceptos[this.cboConcepto.getSelectedIndex()][0].toString()) == 0) {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(this.listaConceptos[this.cboConcepto.getSelectedIndex()][0], this.filaGrid, 0);
            this.modelo.setValueAt(this.cboConcepto.getSelectedItem(), this.filaGrid, 1);
            this.modelo.setValueAt(this.txtCantidad.getValue(), this.filaGrid, 2);
            this.modelo.setValueAt(this.txtValorUnit.getValue(), this.filaGrid, 3);
            this.modelo.setValueAt(Double.valueOf(Double.valueOf(this.txtCantidad.getValue().toString()).doubleValue() * Double.valueOf(this.txtValorUnit.getValue().toString()).doubleValue()), this.filaGrid, 4);
            setTotalizar();
            this.cboConcepto.setSelectedIndex(-1);
            this.txtCantidad.setText("1");
            this.txtValorUnit.setText("");
            this.txtValorTotal.setValue(0);
            this.filaGrid++;
            return;
        }
        this.metodos.mostrarMensaje("Este Concepto ya se Encuentra Adicionado");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearGrid() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Concepto", "Cantidad", "Vr. Unitario", "Vr. Total"}) { // from class: Caja.Recibos.4
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(800);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.grid.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.filaGrid = 0;
    }

    private void cargarCombos() {
        this.cboCC.removeAllItems();
        this.listaCC = this.consultas.llenarCombo("SELECT `Id` , `Nbre`  FROM `f_centrocosto` WHERE (`Estado` =0) ORDER BY `Nbre` ASC", this.listaCC, this.cboCC);
        this.cboCC.setSelectedIndex(-1);
        this.listaEPS = this.consultas.llenarComboyLista("SELECT Id, Nbre, EsCapitado FROM f_empresacontxconvenio WHERE Estado = 0 ORDER BY Nbre ASC", this.listaEPS, this.cboEPS, 3);
        this.xId_Fpago = this.consultas.llenarComboyLista("SELECT  `Id` , `Nbre` , `DatosA`, CDebito FROM `k_formapago` WHERE (`Estado` =1) ORDER BY `Orden` ASC, `Nbre` ASC", this.xId_Fpago, this.cboFormaPago, 4);
        this.listaConceptos = this.consultas.llenarComboyLista("SELECT  `k_conceptos`.`Id` , `k_conceptos`.`Nbre` , `k_conceptos`.`Valor`\nFROM `k_cajaxconceptos` INNER JOIN `k_conceptos`   ON (`k_cajaxconceptos`.`Id_Concepto` = `k_conceptos`.`Id`)\nWHERE (`k_cajaxconceptos`.`Id_Caja` ='" + this.classCaja.getIdCaja() + "' AND `k_cajaxconceptos`.`Estado` =1 AND `k_conceptos`.`Tipo`=0)", this.listaConceptos, this.cboConcepto, 3);
        this.listaTipoDocumento = this.consultas.llenarCombo("SELECT Id, Nbre FROM g_tipoidentificacion WHERE Estado = 0 ORDER BY Nbre ASC", this.listaTipoDocumento, this.cboTipoDocumento);
        this.cboLleno = 1;
        this.consultas.cerrarConexionBd();
    }

    public void grabar() {
        if (this.txtNoRecibo.getText().isEmpty()) {
            if (validarCampos() == 1) {
                this.txtNoRecibo.setText(this.classCaja.getUltimoNoRecibo());
                this.idRecibo = grabarRecibo();
                grabarDetalle(this.idRecibo);
                grabarFormaPago(this.idRecibo);
                this.classCaja.imprimirRecibo(this.idRecibo, getValorRecibo(), String.valueOf(this.classCaja.getIdCaja()), this);
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Recibo ya grabado", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private String grabarRecibo() {
        String Factura;
        if (this.txtNoFactura.getText() == null || this.txtNoFactura.getText().equals("")) {
            Factura = "0";
        } else {
            Factura = this.txtNoFactura.getText();
        }
        this.sql = "INSERT INTO k_recibos (Id_Caja, NoRecibo, Fecha_Recibo, NoFactura, Tipo, Id_CentroCosto, Descuento, Observacion, `Id_FPago`,Id_EmpresaContxConv, Id_TipoDocumento, Id_Paciente, Identificacion, Nbre_Paciente, Id_Ingreso, Fecha, UsuarioS, Id_UsuarioS) VALUES ('" + this.classCaja.getIdCaja() + "','" + this.classCaja.getUltimoNoRecibo() + "','" + this.metodos.formatoAMD.format(this.JDFecha.getDate()) + " " + this.metodos.formatoH24.format(this.metodos.getFechaActual()) + "','" + Factura + "','" + this.listaEPS[this.cboEPS.getSelectedIndex()][1] + "','" + this.listaCC[this.cboCC.getSelectedIndex()] + "','" + this.txtDescuento.getValue() + "','" + this.txtObservacion.getText() + "','" + this.xId_Fpago[this.cboFormaPago.getSelectedIndex()][0] + "','" + this.listaEPS[this.cboEPS.getSelectedIndex()][0] + "','" + this.listaTipoDocumento[this.cboTipoDocumento.getSelectedIndex()] + "','" + this.xidpaciente + "','" + this.txtDocumento.getText() + "','" + this.txtPaciente.getText().toUpperCase() + "','" + this.xidingreso + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "')";
        this.idRecibo = this.consultas.ejecutarSQLId(this.sql);
        this.consultas.cerrarConexionBd();
        return this.idRecibo;
    }

    private void grabarDetalle(String idRecibo) {
        for (int f = 0; f < this.grid.getRowCount(); f++) {
            this.sql = "INSERT INTO k_itemrecibos (Id_Recibo, Id_Concepto, Cantidad, VrUnitario) VALUES ('" + idRecibo + "','" + this.grid.getValueAt(f, 0) + "','" + this.grid.getValueAt(f, 2) + "','" + this.grid.getValueAt(f, 3) + "')";
            this.consultas.ejecutarSQL(this.sql);
            this.consultas.cerrarConexionBd();
        }
    }

    private void grabarFormaPago(String idRecibo) {
        this.sql = "INSERT INTO k_itemformapago (Id_Recibo, Id_FormaPago, Id_Banco, NoDocumento, Valor) VALUES ('" + idRecibo + "','1','1','0','" + this.txtValorRecibo.getValue() + "')";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    private void cargarDetalleRecibo(String idRecibo) {
        this.sql = "SELECT k_conceptos.Id, k_conceptos.Nbre, k_itemrecibos.Cantidad, k_itemrecibos.VrUnitario FROM k_itemrecibos INNER JOIN k_conceptos ON (k_itemrecibos.Id_Concepto = k_conceptos.Id) WHERE (k_itemrecibos.Id_Recibo ='" + idRecibo + "')";
        this.rs = this.consultas.traerRs(this.sql);
        while (this.rs.next()) {
            try {
                this.modelo.addRow(this.dato);
                this.modelo.setValueAt(this.rs.getString(1), this.filaGrid, 0);
                this.modelo.setValueAt(this.rs.getString(2), this.filaGrid, 1);
                this.modelo.setValueAt(Integer.valueOf(this.rs.getInt(3)), this.filaGrid, 2);
                this.modelo.setValueAt(Double.valueOf(this.rs.getDouble(4)), this.filaGrid, 3);
                this.modelo.setValueAt(Double.valueOf(((double) this.rs.getInt(3)) * this.rs.getDouble(4)), this.filaGrid, 4);
                this.txtTotal.setValue(Integer.valueOf(Integer.parseInt(this.txtTotal.getValue().toString()) + (this.rs.getInt(3) * this.rs.getInt(4))));
                this.txtTotalRecibo.setValue(Double.valueOf(Double.valueOf(this.txtTotal.getValue().toString()).doubleValue() - ((double) Integer.parseInt(this.txtDescuento.getValue().toString()))));
                this.txtValorRecibo.setValue(this.txtTotalRecibo.getValue());
                this.filaGrid++;
            } catch (SQLException ex) {
                this.consultas.mostrarErrorSQL(ex);
                return;
            }
        }
        this.rs.close();
        this.consultas.cerrarConexionBd();
    }

    public void cargarRecibo(int boton, String IdRecibo, String Fecha) {
        this.idRecibo = IdRecibo;
        this.sql = "SELECT k_recibos.Id, k_recibos.NoRecibo, k_recibos.Fecha_Recibo, k_recibos.NoFactura, f_centrocosto.Nbre, k_recibos.Descuento, k_recibos.Observacion, f_empresacontxconvenio.Nbre, g_tipoidentificacion.Nbre, k_recibos.Identificacion, k_recibos.Nbre_Paciente, k_recibos.Estado, k_recibos.Id_Profesional, `k_recibos`.`Id_cierre` FROM k_recibos INNER JOIN f_centrocosto ON (k_recibos.Id_CentroCosto = f_centrocosto.Id) INNER JOIN f_empresacontxconvenio ON (k_recibos.Id_EmpresaContxConv = f_empresacontxconvenio.Id) INNER JOIN g_tipoidentificacion ON (k_recibos.Id_TipoDocumento = g_tipoidentificacion.Id) WHERE (k_recibos.Id='" + IdRecibo + "')";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.last()) {
                nuevo();
                this.idRecibo = this.rs.getString(1);
                this.xIdCierre = this.rs.getLong("Id_cierre");
                this.txtNoRecibo.setText(this.rs.getString(2));
                this.JDFecha.setDate(this.rs.getDate(3));
                this.txtNoFactura.setText(this.rs.getString(4));
                this.cboCC.setSelectedItem(this.rs.getString(5));
                this.txtDescuento.setValue(Integer.valueOf(this.rs.getInt(6)));
                this.txtObservacion.setText(this.rs.getString(7));
                this.cboEPS.setSelectedItem(this.rs.getString(8));
                this.cboTipoDocumento.setSelectedItem(this.rs.getString(9));
                this.txtDocumento.setText(this.rs.getString(10));
                this.txtPaciente.setText(this.rs.getString(11));
                if (this.rs.getInt(12) == 0) {
                    this.txtEstado.setText("Activo");
                    this.txtEstado.setDisabledTextColor(new Color(204, 255, 255));
                } else {
                    this.txtEstado.setText("!!!ANULADO!!!");
                    this.txtEstado.setDisabledTextColor(new Color(204, 0, 0));
                }
                crearGrid();
                cargarDetalleRecibo(this.idRecibo);
            } else {
                this.metodos.mostrarMensaje("No se encontró el Recibo solicitado");
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public String getIdRecibo() {
        return this.idRecibo;
    }

    public String getValorRecibo() {
        return this.txtValorRecibo.getValue().toString();
    }

    public void imprimir() {
        this.classCaja.imprimirRecibo(this.idRecibo, getValorRecibo(), String.valueOf(this.classCaja.getIdCaja()), this);
    }

    public void nuevo() {
        this.JDFecha.setDate(this.metodos.getFechaActual());
        this.cboCC.setSelectedIndex(-1);
        this.cboEPS.setSelectedIndex(-1);
        this.txtNoRecibo.setText("");
        this.txtNoFactura.setText("0");
        this.cboTipoDocumento.setSelectedIndex(-1);
        this.txtDocumento.setText("");
        this.txtPaciente.setText("");
        this.txtValorRecibo.setValue(0);
        this.txtEstado.setText("Activo");
        this.txtEstado.setDisabledTextColor(new Color(0, 0, 102));
        this.cboConcepto.setSelectedIndex(-1);
        this.txtCantidad.setValue(1);
        this.txtValorUnit.setValue(0);
        this.txtValorTotal.setValue(0);
        this.txtTotal.setValue(0);
        this.txtDescuento.setValue(0);
        this.txtTotalRecibo.setValue(0);
        this.xidpaciente = 0L;
        this.xidingreso = 0L;
        this.xConsultoF = 0;
        this.txtObservacion.setText("");
        this.idRecibo = "0";
        this.JRBCapita.setSelected(false);
        this.JRBEvento.setSelected(false);
        this.JCBIngreso.removeAllItems();
        crearGrid();
        this.cboCC.requestFocus();
    }

    private void setTotalizar() {
        double xvalor = 0.0d;
        for (int x = 0; x < this.grid.getRowCount(); x++) {
            xvalor += Double.valueOf(this.modelo.getValueAt(x, 4).toString()).doubleValue();
        }
        this.txtTotal.setValue(Double.valueOf(xvalor));
        this.txtTotalRecibo.setValue(Double.valueOf(xvalor - Double.valueOf(this.txtDescuento.getText()).doubleValue()));
        this.txtValorRecibo.setValue(this.txtTotalRecibo.getValue());
    }

    private void setValorTotal() {
        if (!this.txtCantidad.getText().isEmpty() && !this.txtValorUnit.getText().isEmpty()) {
            double xvalor = Double.valueOf(this.txtCantidad.getValue().toString()).doubleValue() * Double.valueOf(this.txtValorUnit.getValue().toString()).doubleValue();
            this.txtValorTotal.setValue(Double.valueOf(xvalor));
        }
    }

    private int validarCampos() {
        int retorno = 0;
        if (this.cboCC.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Centro de Costo");
            this.cboCC.requestFocus();
        } else if (this.cboEPS.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione la EPS o Empresa por la cual se realiza el Recibo");
            this.cboEPS.requestFocus();
        } else if (!this.txtNoFactura.isTextoValido()) {
            this.metodos.mostrarMensaje("Por favor digite el No. de Factura Adecuadamente");
            this.txtNoFactura.requestFocus();
        } else if (this.cboTipoDocumento.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione el Tipo de Documento de Identificación");
            this.cboTipoDocumento.requestFocus();
        } else if (this.txtDocumento.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite el Documento de Identidad del usuario");
            this.txtDocumento.requestFocus();
        } else if (this.txtPaciente.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor digite el Nombre de la Persona a quien se le presta el Servicio");
            this.txtPaciente.requestFocus();
        } else if (this.grid.getRowCount() < 1) {
            this.metodos.mostrarMensaje("Por favor selecione por lo menos un Concepto a Cancelar");
        } else if (Integer.parseInt(this.txtDescuento.getValue().toString()) > 0 && this.txtObservacion.getText().isEmpty()) {
            this.metodos.mostrarMensaje("Por favor agregue una Observación que justifique el Descuento");
            this.txtObservacion.requestFocus();
        } else {
            retorno = 1;
        }
        return retorno;
    }

    private int verificarConcepto(String Id) {
        int retorno = 0;
        if (this.filaGrid > 0) {
            for (int i = 0; retorno == 0 && i < this.filaGrid; i++) {
                if (Id.equals(this.modelo.getValueAt(i, 0).toString())) {
                    retorno = 1;
                }
            }
        }
        return retorno;
    }

    /* JADX WARN: Type inference failed for: r3v118, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v84, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.cboCC = new JComboBox();
        this.cboEPS = new JComboBox();
        this.JDFecha = new JDateChooser();
        this.JRBEvento = new JRadioButton();
        this.JRBCapita = new JRadioButton();
        this.txtNoRecibo = new JFormattedTextField();
        this.jPanel3 = new JPanel();
        this.txtDocumento = new JTextField();
        this.cboTipoDocumento = new JComboBox();
        this.JCBIngreso = new JComboBox();
        this.txtEstado = new JFormattedTextField();
        this.txtValorRecibo = new JFormattedTextField();
        this.jTabbedPane1 = new JTabbedPane();
        this.jPanel5 = new JPanel();
        this.cboConcepto = new JComboBox();
        this.txtValorUnit = new JFormattedTextField();
        this.txtValorTotal = new JFormattedTextField();
        this.btnCargar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.txtCantidad = new JFormattedTextField();
        this.jPanel6 = new JPanel();
        this.cboFormaPago = new JComboBox();
        this.txtValor = new JFormattedTextField();
        this.txtNoCuotas = new JSpinner();
        this.txtFecha1raCuota = new JDateChooser();
        this.jScrollPane2 = new JScrollPane();
        this.gridFP = new JTable();
        this.jPanel2 = new JPanel();
        this.jRadioButton1 = new JRadioButton();
        this.jRadioButton2 = new JRadioButton();
        this.jScrollPane3 = new JScrollPane();
        this.txtObservacion = new JTextArea();
        this.jPanel4 = new JPanel();
        this.txtTotal = new JFormattedTextField();
        this.txtDescuento = new JFormattedTextField();
        this.txtTotalRecibo = new JFormattedTextField();
        this.btnCargar1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("RECIBOS DE INGRESOS");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(new Dimension(1126, 597));
        setName("Recibos");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS DEL MOVIMIENTO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.cboCC.setFont(new Font("Arial", 1, 12));
        this.cboCC.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEPS.setFont(new Font("Arial", 1, 12));
        this.cboEPS.setBorder(BorderFactory.createTitledBorder((Border) null, "EPS o Empresa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboEPS.addActionListener(new ActionListener() { // from class: Caja.Recibos.5
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.cboEPSActionPerformed(evt);
            }
        });
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.buttonGroup1.add(this.JRBEvento);
        this.JRBEvento.setText("Evento");
        this.buttonGroup1.add(this.JRBCapita);
        this.JRBCapita.setText("Capita");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFecha, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.cboCC, -2, 220, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBEvento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBCapita)).addComponent(this.cboEPS, -2, 476, -2)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(7, 7, 7).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.cboCC, -2, -1, -2).addComponent(this.cboEPS, -2, -1, -2))).addComponent(this.JDFecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEvento).addComponent(this.JRBCapita)).addContainerGap()));
        this.txtNoRecibo.setEditable(false);
        this.txtNoRecibo.setBackground(new Color(255, 255, 204));
        this.txtNoRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "Número de Recibo", 0, 0, new Font("Segoe UI", 0, 12), new Color(0, 0, 102)));
        this.txtNoRecibo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtNoRecibo.setHorizontalAlignment(4);
        this.txtNoRecibo.setDisabledTextColor(new Color(102, 0, 102));
        this.txtNoRecibo.setEnabled(false);
        this.txtNoRecibo.setFont(new Font("Arial", 1, 22));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL USUARIO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel3.setLayout(new AbsoluteLayout());
        this.txtDocumento.setFont(new Font("Arial", 1, 12));
        this.txtDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtDocumento.addFocusListener(new FocusAdapter() { // from class: Caja.Recibos.6
            public void focusGained(FocusEvent evt) {
                Recibos.this.txtDocumentoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Recibos.this.txtDocumentoFocusLost(evt);
            }
        });
        this.txtDocumento.addKeyListener(new KeyAdapter() { // from class: Caja.Recibos.7
            public void keyPressed(KeyEvent evt) {
                Recibos.this.txtDocumentoKeyPressed(evt);
            }
        });
        this.jPanel3.add(this.txtDocumento, new AbsoluteConstraints(290, 20, 120, 50));
        this.cboTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.cboTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel3.add(this.cboTipoDocumento, new AbsoluteConstraints(130, 20, 150, 50));
        this.JCBIngreso.setFont(new Font("Arial", 1, 12));
        this.JCBIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "Ingresos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBIngreso.addItemListener(new ItemListener() { // from class: Caja.Recibos.8
            public void itemStateChanged(ItemEvent evt) {
                Recibos.this.JCBIngresoItemStateChanged(evt);
            }
        });
        this.jPanel3.add(this.JCBIngreso, new AbsoluteConstraints(730, 20, 150, 50));
        this.txtEstado.setBackground(new Color(255, 255, 204));
        this.txtEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Segoe UI", 0, 12), new Color(0, 0, 102)));
        this.txtEstado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.txtEstado.setHorizontalAlignment(0);
        this.txtEstado.setText("Activo");
        this.txtEstado.setDisabledTextColor(new Color(102, 0, 102));
        this.txtEstado.setEnabled(false);
        this.txtEstado.setFont(new Font("Arial", 1, 18));
        this.txtValorRecibo.setBackground(new Color(255, 255, 204));
        this.txtValorRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor $", 0, 0, new Font("Segoe UI", 0, 12), new Color(0, 0, 102)));
        this.txtValorRecibo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorRecibo.setHorizontalAlignment(4);
        this.txtValorRecibo.setDisabledTextColor(new Color(102, 0, 102));
        this.txtValorRecibo.setEnabled(false);
        this.txtValorRecibo.setFont(new Font("Arial", 1, 22));
        this.txtValorRecibo.setValue(new Integer(0));
        this.jTabbedPane1.setForeground(new Color(0, 102, 0));
        this.jTabbedPane1.setFont(new Font("Arial", 1, 14));
        this.cboConcepto.setFont(new Font("Arial", 1, 12));
        this.cboConcepto.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboConcepto.addItemListener(new ItemListener() { // from class: Caja.Recibos.9
            public void itemStateChanged(ItemEvent evt) {
                Recibos.this.cboConceptoItemStateChanged(evt);
            }
        });
        this.txtValorUnit.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Unitario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorUnit.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorUnit.setHorizontalAlignment(4);
        this.txtValorUnit.setText("0");
        this.txtValorUnit.setFont(new Font("Arial", 1, 12));
        this.txtValorUnit.addFocusListener(new FocusAdapter() { // from class: Caja.Recibos.10
            public void focusGained(FocusEvent evt) {
                Recibos.this.txtValorUnitFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Recibos.this.txtValorUnitFocusLost(evt);
            }
        });
        this.txtValorUnit.addActionListener(new ActionListener() { // from class: Caja.Recibos.11
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.txtValorUnitActionPerformed(evt);
            }
        });
        this.txtValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValorTotal.setHorizontalAlignment(4);
        this.txtValorTotal.setText("0");
        this.txtValorTotal.setDisabledTextColor(new Color(0, 0, 153));
        this.txtValorTotal.setEnabled(false);
        this.txtValorTotal.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setFont(new Font("Arial", 1, 12));
        this.btnCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.btnCargar.setText("Cargar");
        this.btnCargar.addActionListener(new ActionListener() { // from class: Caja.Recibos.12
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.btnCargarActionPerformed(evt);
            }
        });
        this.btnCargar.addKeyListener(new KeyAdapter() { // from class: Caja.Recibos.13
            public void keyPressed(KeyEvent evt) {
                Recibos.this.btnCargarKeyPressed(evt);
            }
        });
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addKeyListener(new KeyAdapter() { // from class: Caja.Recibos.14
            public void keyPressed(KeyEvent evt) {
                Recibos.this.gridKeyPressed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.txtCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtCantidad.setHorizontalAlignment(4);
        this.txtCantidad.setFont(new Font("Arial", 1, 12));
        this.txtCantidad.addFocusListener(new FocusAdapter() { // from class: Caja.Recibos.15
            public void focusGained(FocusEvent evt) {
                Recibos.this.txtCantidadFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Recibos.this.txtCantidadFocusLost(evt);
            }
        });
        this.txtCantidad.addActionListener(new ActionListener() { // from class: Caja.Recibos.16
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.txtCantidadActionPerformed(evt);
            }
        });
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.cboConcepto, -2, 583, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCantidad, -2, 90, -2).addGap(10, 10, 10).addComponent(this.txtValorUnit, -2, 100, -2).addGap(10, 10, 10).addComponent(this.txtValorTotal, -2, 100, -2).addGap(18, 18, 18).addComponent(this.btnCargar, -1, -1, 32767)).addComponent(this.jScrollPane1, -2, 1060, -2)).addGap(5, 5, 5)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboConcepto, -2, 50, -2).addComponent(this.txtCantidad, -2, 50, -2).addComponent(this.txtValorUnit, -2, 50, -2).addComponent(this.txtValorTotal, -2, 50, -2)).addComponent(this.btnCargar, -2, 52, -2)).addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 129, -2).addContainerGap(-1, 32767)));
        this.jTabbedPane1.addTab("DATOS DEL SERVICIO", this.jPanel5);
        this.cboFormaPago.setFont(new Font("Arial", 1, 12));
        this.cboFormaPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.cboFormaPago.setEnabled(false);
        this.txtValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtValor.setHorizontalAlignment(4);
        this.txtValor.setEnabled(false);
        this.txtValor.setFont(new Font("Arial", 1, 12));
        this.txtNoCuotas.setFont(new Font("Arial", 1, 12));
        this.txtNoCuotas.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Cuotas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoCuotas.setEnabled(false);
        this.txtFecha1raCuota.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha 1ra Cuota", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha1raCuota.setEnabled(false);
        this.txtFecha1raCuota.setFont(new Font("Arial", 1, 12));
        this.gridFP.setFont(new Font("Arial", 1, 12));
        this.gridFP.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.jScrollPane2.setViewportView(this.gridFP);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Forma de Pago", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jRadioButton1.setFont(new Font("Arial", 1, 12));
        this.jRadioButton1.setSelected(true);
        this.jRadioButton1.setText("Efectivo");
        this.jRadioButton1.addActionListener(new ActionListener() { // from class: Caja.Recibos.17
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.jRadioButton1ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jRadioButton1);
        this.jRadioButton2.setFont(new Font("Arial", 1, 12));
        this.jRadioButton2.setText("Otro");
        this.jRadioButton2.addActionListener(new ActionListener() { // from class: Caja.Recibos.18
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.jRadioButton2ActionPerformed(evt);
            }
        });
        this.jPanel2.add(this.jRadioButton2);
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jPanel2, -2, 160, -2).addGap(30, 30, 30).addComponent(this.cboFormaPago, -2, 300, -2).addGap(10, 10, 10).addComponent(this.txtValor, -2, 120, -2).addGap(10, 10, 10).addComponent(this.txtNoCuotas, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtFecha1raCuota, -2, 130, -2)).addComponent(this.jScrollPane2, -2, 860, -2))));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, 60, -2).addGroup(jPanel6Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.cboFormaPago, -2, 50, -2)).addGroup(jPanel6Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.txtValor, -2, 50, -2)).addGroup(jPanel6Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtFecha1raCuota, -2, 50, -2).addComponent(this.txtNoCuotas, -2, 50, -2)))).addGap(10, 10, 10).addComponent(this.jScrollPane2, -2, 110, -2)));
        this.jTabbedPane1.addTab("FORMA DE PAGO", this.jPanel6);
        this.jScrollPane3.setBorder(BorderFactory.createTitledBorder((Border) null, "Observaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtObservacion.setColumns(20);
        this.txtObservacion.setFont(new Font("Arial", 1, 12));
        this.txtObservacion.setRows(5);
        this.txtObservacion.setBorder((Border) null);
        this.jScrollPane3.setViewportView(this.txtObservacion);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel4.setLayout(new AbsoluteLayout());
        this.txtTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotal.setHorizontalAlignment(4);
        this.txtTotal.setDisabledTextColor(new Color(0, 0, 153));
        this.txtTotal.setEnabled(false);
        this.txtTotal.setFont(new Font("Arial", 1, 14));
        this.txtTotal.setValue(new Integer(0));
        this.jPanel4.add(this.txtTotal, new AbsoluteConstraints(10, 30, 160, 60));
        this.txtDescuento.setBorder(BorderFactory.createTitledBorder((Border) null, "Descuento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtDescuento.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtDescuento.setHorizontalAlignment(4);
        this.txtDescuento.setFont(new Font("Arial", 1, 14));
        this.txtDescuento.setValue(new Integer(0));
        this.txtDescuento.addActionListener(new ActionListener() { // from class: Caja.Recibos.19
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.txtDescuentoActionPerformed(evt);
            }
        });
        this.txtDescuento.addFocusListener(new FocusAdapter() { // from class: Caja.Recibos.20
            public void focusGained(FocusEvent evt) {
                Recibos.this.txtDescuentoFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                Recibos.this.txtDescuentoFocusLost(evt);
            }
        });
        this.jPanel4.add(this.txtDescuento, new AbsoluteConstraints(180, 30, 150, 60));
        this.txtTotalRecibo.setBorder(BorderFactory.createTitledBorder((Border) null, "Total a Pagar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTotalRecibo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(NumberFormat.getIntegerInstance())));
        this.txtTotalRecibo.setHorizontalAlignment(4);
        this.txtTotalRecibo.setDisabledTextColor(new Color(0, 0, 153));
        this.txtTotalRecibo.setEnabled(false);
        this.txtTotalRecibo.setFont(new Font("Arial", 1, 14));
        this.txtTotalRecibo.setValue(new Integer(0));
        this.jPanel4.add(this.txtTotalRecibo, new AbsoluteConstraints(340, 30, 150, 60));
        this.btnCargar1.setFont(new Font("Arial", 1, 12));
        this.btnCargar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Facturacion29x27.png")));
        this.btnCargar1.setText("Deuda por Usuario");
        this.btnCargar1.addActionListener(new ActionListener() { // from class: Caja.Recibos.21
            public void actionPerformed(ActionEvent evt) {
                Recibos.this.btnCargar1ActionPerformed(evt);
            }
        });
        this.btnCargar1.addKeyListener(new KeyAdapter() { // from class: Caja.Recibos.22
            public void keyPressed(KeyEvent evt) {
                Recibos.this.btnCargar1KeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 587, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel4, -2, 500, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel3, -1, 889, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtNoRecibo, -1, 180, 32767).addComponent(this.txtValorRecibo, -1, 180, 32767).addComponent(this.txtEstado, -1, 180, 32767).addComponent(this.btnCargar1, -1, -1, 32767))))).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.txtNoRecibo, -2, 50, -2).addGap(0, 0, 0).addComponent(this.txtValorRecibo, -2, 50, -2).addGap(0, 0, 0).addComponent(this.txtEstado, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btnCargar1, -2, 52, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jPanel3, -2, 80, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -2, 250, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -2, 100, -2).addComponent(this.jPanel4, -2, 100, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton1ActionPerformed(ActionEvent evt) {
        activarFormaPago(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRadioButton2ActionPerformed(ActionEvent evt) {
        activarFormaPago(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarActionPerformed(ActionEvent evt) {
        cargarGrid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorUnitFocusLost(FocusEvent evt) {
        setValorTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadFocusLost(FocusEvent evt) {
        setValorTotal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Caja.Recibos.23
            @Override // java.lang.Runnable
            public void run() {
                Recibos.this.txtCantidad.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorUnitFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Caja.Recibos.24
            @Override // java.lang.Runnable
            public void run() {
                Recibos.this.txtValorUnit.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDocumentoFocusLost(FocusEvent evt) {
        if (this.cboTipoDocumento.getSelectedIndex() != -1) {
            buscarPaciente(this.cboTipoDocumento.getSelectedItem().toString(), this.txtDocumento.getText());
            if (this.xidpaciente != 0) {
                Principal.clasegeneral.activarFormularioConsolidadoPagoPendiente(Long.valueOf(this.xidpaciente), this);
                return;
            }
            return;
        }
        this.metodos.mostrarMensaje("Debe seleccionar tipo el tipo de documento");
        this.cboTipoDocumento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDocumentoFocusGained(FocusEvent evt) {
        this.txtDocumento.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtValorUnitActionPerformed(ActionEvent evt) {
        this.btnCargar.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCantidadActionPerformed(ActionEvent evt) {
        this.txtValorUnit.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoFocusLost(FocusEvent evt) {
        if (Double.valueOf(this.txtDescuento.getValue().toString()).doubleValue() > Double.valueOf(this.txtTotal.getValue().toString()).doubleValue()) {
            this.metodos.mostrarMensaje("El Descuento no puede ser mayor al Valor Total del Recibo");
            this.txtDescuento.requestFocus();
        } else {
            this.txtTotalRecibo.setValue(Double.valueOf(Double.valueOf(this.txtTotal.getValue().toString()).doubleValue() - Double.valueOf(this.txtDescuento.getValue().toString()).doubleValue()));
            this.txtValorRecibo.setValue(this.txtTotalRecibo.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoFocusGained(FocusEvent evt) {
        SwingUtilities.invokeLater(new Runnable() { // from class: Caja.Recibos.25
            @Override // java.lang.Runnable
            public void run() {
                Recibos.this.txtDescuento.selectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDescuentoActionPerformed(ActionEvent evt) {
        this.txtObservacion.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtPacienteFocusGained(FocusEvent evt) {
        this.txtPaciente.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoFacturaFocusGained(FocusEvent evt) {
        this.txtNoFactura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoFacturaFocusLost(FocusEvent evt) {
        if (this.txtNoFactura.isTextoValido()) {
            if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
                if (this.JRBCapita.isSelected()) {
                    this.radioCapita = 1;
                    buscarFactura();
                    return;
                } else if (this.JRBEvento.isSelected()) {
                    this.radioEvento = 1;
                    buscarFactura();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Seleccione evento o capita");
                    return;
                }
            }
            buscarFactura();
            return;
        }
        this.txtNoFactura.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtNoFacturaActionPerformed(ActionEvent evt) {
        this.txtNoFactura.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboConceptoItemStateChanged(ItemEvent evt) {
        if (this.cboLleno == 1 && this.cboConcepto.getSelectedIndex() != -1 && this.xConsultoF == 0) {
            this.txtValorUnit.setValue(Double.valueOf(this.listaConceptos[this.cboConcepto.getSelectedIndex()][1]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            cargarGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBIngresoItemStateChanged(ItemEvent evt) {
        if (this.xlleno.booleanValue() && this.JCBIngreso.getSelectedIndex() != -1) {
            this.txtNoFactura.setText(this.listaingreso[this.JCBIngreso.getSelectedIndex()]);
            txtNoFacturaFocusLost(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtDocumentoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPaciente(this.cboTipoDocumento.getSelectedItem().toString(), this.txtDocumento.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargar1ActionPerformed(ActionEvent evt) {
        if (this.xidpaciente != 0) {
            Principal.clasegeneral.activarFormularioConsolidadoPagoPendiente(Long.valueOf(this.xidpaciente), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnCargar1KeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboEPSActionPerformed(ActionEvent evt) {
        int value = this.cboEPS.getSelectedIndex();
        System.out.println("indice -> " + value);
    }

    private void eventoCapita() {
        if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLÍNICO LABVY S.A.S")) {
            this.JRBCapita.setVisible(true);
            this.JRBEvento.setVisible(true);
        } else {
            this.JRBCapita.setVisible(false);
            this.JRBEvento.setVisible(false);
        }
    }
}
