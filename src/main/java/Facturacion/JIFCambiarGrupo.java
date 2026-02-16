package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JIFCambiarGrupo.class */
public class JIFCambiarGrupo extends JInternalFrame {
    private String[] xidsubgrupo;
    private String[][] xidservicio;
    private int xllenocg;
    private long xidempresa;
    private String idFactura;
    private ButtonGroup JBTipoFact;
    private JComboBox JCBGrupo;
    private JComboBox JCBSubGrupo;
    public JDateChooser JDFechaI;
    private JLabel JLBEstado;
    private JLabel JLBRelacionNumero;
    private JPanel JPIDatos;
    private JPanel JPITipoFactura;
    private JRadioButton JRBCapitacion;
    private JRadioButton JRBEvento;
    private JFormattedTextField JTFFNOrden;
    private int xtipo = 0;
    private long xidliquidacion = 0;
    private long xId_Ingreso = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();

    public JIFCambiarGrupo(String nombre) {
        this.xllenocg = 0;
        initComponents();
        setName(nombre);
        this.xidsubgrupo = this.xct.llenarCombo("SELECT Id_SubgrupoServicio, Nbre FROM  f_subgruposervicio ORDER BY Nbre ASC", this.xidsubgrupo, this.JCBSubGrupo);
        this.JCBSubGrupo.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xllenocg = 1;
    }

    private void initComponents() {
        this.JBTipoFact = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JPITipoFactura = new JPanel();
        this.JRBEvento = new JRadioButton();
        this.JRBCapitacion = new JRadioButton();
        this.JTFFNOrden = new JFormattedTextField();
        this.JCBSubGrupo = new JComboBox();
        this.JCBGrupo = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JLBEstado = new JLabel();
        this.JLBRelacionNumero = new JLabel();
        setClosable(true);
        setTitle("CAMBIO DE GRUPO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifcambiardatosliquidacion");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS FACTURA/ORDEN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JPITipoFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Facturación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTipoFact.add(this.JRBEvento);
        this.JRBEvento.setFont(new Font("Arial", 1, 12));
        this.JRBEvento.setText("Evento");
        this.JRBEvento.addActionListener(new ActionListener() { // from class: Facturacion.JIFCambiarGrupo.1
            public void actionPerformed(ActionEvent evt) {
                JIFCambiarGrupo.this.JRBEventoActionPerformed(evt);
            }
        });
        this.JBTipoFact.add(this.JRBCapitacion);
        this.JRBCapitacion.setFont(new Font("Arial", 1, 12));
        this.JRBCapitacion.setSelected(true);
        this.JRBCapitacion.setText("Capitación");
        this.JRBCapitacion.addActionListener(new ActionListener() { // from class: Facturacion.JIFCambiarGrupo.2
            public void actionPerformed(ActionEvent evt) {
                JIFCambiarGrupo.this.JRBCapitacionActionPerformed(evt);
            }
        });
        GroupLayout JPITipoFacturaLayout = new GroupLayout(this.JPITipoFactura);
        this.JPITipoFactura.setLayout(JPITipoFacturaLayout);
        JPITipoFacturaLayout.setHorizontalGroup(JPITipoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoFacturaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBEvento).addGap(18, 18, 18).addComponent(this.JRBCapitacion).addContainerGap(-1, 32767)));
        JPITipoFacturaLayout.setVerticalGroup(JPITipoFacturaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoFacturaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEvento).addComponent(this.JRBCapitacion)));
        this.JTFFNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Número", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNOrden.setHorizontalAlignment(4);
        this.JTFFNOrden.setFont(new Font("Arial", 1, 14));
        this.JTFFNOrden.addFocusListener(new FocusAdapter() { // from class: Facturacion.JIFCambiarGrupo.3
            public void focusLost(FocusEvent evt) {
                JIFCambiarGrupo.this.JTFFNOrdenFocusLost(evt);
            }
        });
        this.JTFFNOrden.addActionListener(new ActionListener() { // from class: Facturacion.JIFCambiarGrupo.4
            public void actionPerformed(ActionEvent evt) {
                JIFCambiarGrupo.this.JTFFNOrdenActionPerformed(evt);
            }
        });
        this.JCBSubGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBSubGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "SubGrupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.setFont(new Font("Arial", 1, 12));
        this.JCBGrupo.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupo.addItemListener(new ItemListener() { // from class: Facturacion.JIFCambiarGrupo.5
            public void itemStateChanged(ItemEvent evt) {
                JIFCambiarGrupo.this.JCBGrupoItemStateChanged(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JLBEstado.setFont(new Font("Arial", 1, 12));
        this.JLBEstado.setForeground(Color.red);
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLBRelacionNumero.setFont(new Font("Arial", 1, 12));
        this.JLBRelacionNumero.setForeground(Color.red);
        this.JLBRelacionNumero.setHorizontalAlignment(0);
        this.JLBRelacionNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Relacion No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPITipoFactura, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFNOrden, -2, 111, -2).addGap(18, 18, 18).addComponent(this.JCBGrupo, 0, -1, 32767)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBSubGrupo, -2, 432, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaI, -2, 116, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEstado, -2, 141, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBRelacionNumero, -2, 141, -2))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFNOrden, GroupLayout.Alignment.LEADING).addComponent(this.JPITipoFactura, GroupLayout.Alignment.LEADING, -2, -1, -2).addComponent(this.JCBGrupo, GroupLayout.Alignment.LEADING, -2, 50, -2)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBSubGrupo, -1, 50, 32767).addComponent(this.JDFechaI, -1, 50, 32767).addComponent(this.JLBEstado, -1, -1, 32767).addComponent(this.JLBRelacionNumero, -1, -1, 32767)).addContainerGap(26, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEventoActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCapitacionActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNOrdenActionPerformed(ActionEvent evt) {
        this.JTFFNOrden.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNOrdenFocusLost(FocusEvent evt) {
        if (!this.JTFFNOrden.getText().isEmpty()) {
            mBuscarOrdenFactura();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoItemStateChanged(ItemEvent evt) {
        if (this.xllenocg == 1 && this.JCBGrupo.getSelectedIndex() != -1) {
            this.JCBSubGrupo.removeAllItems();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            String xsql = "SELECT f_subgrupo_empresa.Id, f_subgruposervicio.Nbre FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id) WHERE (f_subgrupo_empresa.Id_Empresa =" + this.xidempresa + " AND f_subgrupo_empresa.Estado =1 AND f_subgruposervicio.Id_GrupoServicio= '" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "') ORDER BY f_subgruposervicio.Nbre ASC ";
            this.xidsubgrupo = xct1.llenarCombo(xsql, this.xidsubgrupo, this.JCBSubGrupo);
            xct1.cerrarConexionBd();
            if (this.xidservicio[this.JCBGrupo.getSelectedIndex()][1].equals("1")) {
                this.JCBSubGrupo.setEnabled(true);
            } else {
                this.JCBSubGrupo.setEnabled(false);
            }
            this.xllenocg = 1;
        }
    }

    public void mLimpiar() {
    }

    private void mBuscarOrdenFactura() {
        String sql;
        if (!this.JTFFNOrden.getText().isEmpty()) {
            this.xllenocg = 0;
            if (this.xtipo == 0) {
                sql = "SELECT  f_factura_capita.No_FacturaCapita, f_subgruposervicio.Nbre, f_liquidacion.Id, f_gruposervicio.Nbre,  ingreso.Id_EmpresaContxConv, f_factura_capita.Fecha_FacturaCapita, f_liquidacion.Id_Ingreso, IF(`f_factura_capita`.`EstaArmada`=0, 'GENERADA', IF(`f_factura_capita`.`EstaArmada`=1, 'ARMADA', 'PRESENTADA')) Estado, f_factura_capita.`No_FacturaEvento` as numeroRelacion, f_factura_capita.No_FacturaCapita as IdFactura  FROM f_factura_capita  INNER JOIN f_liquidacion  ON (f_factura_capita.Id_Liquidacion = f_liquidacion.Id) INNER JOIN ingreso  ON (ingreso.Id = f_liquidacion.Id_Ingreso)  INNER JOIN f_subgrupo_empresa  ON (f_subgrupo_empresa.Id= f_liquidacion.Id_SubGrupoServicio) AND (f_subgrupo_empresa.Id_Empresa=ingreso.Id_EmpresaContxConv) INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo  = f_subgruposervicio.Id_SubgrupoServicio)  INNER JOIN  f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio)  WHERE (f_factura_capita.No_FacturaCapita ='" + this.JTFFNOrden.getText() + "' AND f_liquidacion.Estado <>1 AND f_factura_capita.Estado <>1)  ";
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                sql = "SELECT  f_factura_evento.No_FacturaEvento_M, f_subgruposervicio.Nbre, f_liquidacion.Id, f_gruposervicio.Nbre, f_liquidacion.IdEmpresaContxConv, f_factura_evento.Fecha_FacturaEvento, f_liquidacion.Id_Ingreso, IF(`f_factura_evento`.`EstaArmada`=0, 'GENERADA', IF(`f_factura_evento`.`EstaArmada`=1, 'ARMADA', 'PRESENTADA')) Estado, f_factura_evento.`No_CuentaCobro`as numeroRelacion, f_factura_evento.No_Facturaevento as IdFactura   FROM f_factura_evento INNER JOIN f_liquidacion   ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_subgrupo_empresa   ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)  INNER JOIN f_subgruposervicio ON (f_subgrupo_empresa.Id_SubGrupo= f_subgruposervicio.Id_SubgrupoServicio)   INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio= f_gruposervicio.Id_GrupoServicio)    WHERE (CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M) ='" + this.JTFFNOrden.getText() + "' AND f_liquidacion.Estado <>1 AND f_factura_evento.Estado <>1) ";
            } else {
                sql = "SELECT  IF(f_factura_evento.Prefijo<>'', CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M), f_factura_evento.No_Facturaevento_M) AS No_FacturaEvento , f_subgruposervicio.Nbre, f_liquidacion.Id, f_gruposervicio.Nbre, f_liquidacion.IdEmpresaContxConv, f_factura_evento.Fecha_FacturaEvento, f_liquidacion.Id_Ingreso, IF(`f_factura_evento`.`EstaArmada`=0, 'GENERADA', IF(`f_factura_evento`.`EstaArmada`=1, 'ARMADA', 'PRESENTADA')) Estado, f_factura_evento.`No_CuentaCobro`as numeroRelacion, f_factura_evento.No_Facturaevento as IdFactura   FROM f_factura_evento INNER JOIN f_liquidacion   ON (f_factura_evento.Id_Liquidacion = f_liquidacion.Id) INNER JOIN f_subgrupo_empresa   ON (f_liquidacion.Id_SubGrupoServicio = f_subgrupo_empresa.Id)  INNER JOIN f_subgruposervicio ON (f_subgrupo_empresa.Id_SubGrupo= f_subgruposervicio.Id_SubgrupoServicio)   INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio= f_gruposervicio.Id_GrupoServicio)   WHERE (CONCAT(f_factura_evento.Prefijo ,'',f_factura_evento.No_Facturaevento_M) ='" + this.JTFFNOrden.getText() + "' AND f_liquidacion.Estado <>1 AND f_factura_evento.Estado <>1) ";
            }
            ResultSet rs = this.xct.traerRs(sql);
            try {
                if (rs.next()) {
                    this.xllenocg = 0;
                    this.JCBSubGrupo.removeAllItems();
                    this.JCBGrupo.removeAllItems();
                    ConsultasMySQL xct1 = new ConsultasMySQL();
                    String sql2 = "SELECT f_gruposervicio.Id_GrupoServicio, f_gruposervicio.Nbre, f_gruposervicio.ConSubGrupo FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id) INNER JOIN f_gruposervicio  ON (f_subgruposervicio.Id_GrupoServicio = f_gruposervicio.Id_GrupoServicio) WHERE (f_subgrupo_empresa.Id_Empresa =" + rs.getString(5) + " AND f_subgrupo_empresa.Estado =1) GROUP BY f_gruposervicio.Id_GrupoServicio ORDER BY f_gruposervicio.Nbre ASC ";
                    this.xidempresa = rs.getLong(5);
                    this.xidservicio = xct1.llenarComboyLista(sql2, this.xidservicio, this.JCBGrupo, 3);
                    this.JCBGrupo.setSelectedItem(rs.getString(4));
                    String xsql = "SELECT f_subgrupo_empresa.Id, f_subgruposervicio.Nbre FROM f_subgrupo_empresa INNER JOIN f_subgruposervicio  ON (f_subgrupo_empresa.Id_SubGrupo = f_subgruposervicio.Id_SubgrupoServicio) INNER JOIN f_empresacontxconvenio  ON (f_subgrupo_empresa.Id_Empresa = f_empresacontxconvenio.Id) WHERE (f_subgrupo_empresa.Id_Empresa =" + this.xidempresa + " AND f_subgrupo_empresa.Estado =1 AND f_subgruposervicio.Id_GrupoServicio= '" + this.xidservicio[this.JCBGrupo.getSelectedIndex()][0] + "') ORDER BY f_subgruposervicio.Nbre ASC ";
                    this.xidsubgrupo = xct1.llenarCombo(xsql, this.xidsubgrupo, this.JCBSubGrupo);
                    xct1.cerrarConexionBd();
                    this.xllenocg = 1;
                    this.JCBSubGrupo.setSelectedItem(rs.getString(2));
                    this.xidliquidacion = rs.getLong(3);
                    this.xId_Ingreso = rs.getLong(7);
                    this.JLBEstado.setText(rs.getString("Estado"));
                    this.JLBRelacionNumero.setText(rs.getString("numeroRelacion"));
                    this.idFactura = rs.getString("IdFactura");
                    this.JDFechaI.setDate(rs.getDate(6));
                } else {
                    JOptionPane.showInternalMessageDialog(this, "N° no existe", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTFFNOrden.requestFocus();
                }
                rs.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException ex) {
                Logger.getLogger(JIFCambiarGrupo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "El N° no puede ser nulo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
        this.xllenocg = 1;
    }

    public void mGrabar() {
        String sql;
        if (this.JCBGrupo.getSelectedIndex() != -1) {
            if (this.JCBSubGrupo.getSelectedIndex() == -1) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un subgrupo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JCBSubGrupo.requestFocus();
                return;
            }
            if (this.xidliquidacion != 0) {
                if (this.xtipo == 0) {
                    String sql2 = "update f_factura_capita set Fecha_FacturaCapita='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' where No_FacturaCapita='" + this.JTFFNOrden.getText() + "'";
                    this.xct.ejecutarSQL(sql2);
                    this.xct.cerrarConexionBd();
                } else {
                    if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
                        sql = "update f_factura_evento set Fecha_FacturaEvento='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' where No_FacturaEvento_M='" + this.JTFFNOrden.getText() + "'";
                    } else {
                        sql = "update f_factura_evento set Fecha_FacturaEvento='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' where No_FacturaEvento_M='" + this.JTFFNOrden.getText() + "'";
                    }
                    this.xct.ejecutarSQL(sql);
                    this.xct.cerrarConexionBd();
                }
                String sql3 = "update f_liquidacion set Id_SubGrupoServicio='" + this.xidsubgrupo[this.JCBSubGrupo.getSelectedIndex()] + "' where id='" + this.xidliquidacion + "'";
                this.xct.ejecutarSQL(sql3);
                this.xct.cerrarConexionBd();
                JOptionPane.showMessageDialog(this, "Registro Modificado", "G@noma Soft", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCBGrupo.requestFocus();
    }

    public void mNuevo() {
        this.JRBCapitacion.setSelected(true);
        this.JTFFNOrden.setText((String) null);
        this.xtipo = 0;
        this.xllenocg = 0;
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JCBSubGrupo.setSelectedIndex(-1);
        this.JCBGrupo.setSelectedIndex(-1);
        this.xllenocg = 1;
    }

    public void mImprimir() {
        if (!this.JTFFNOrden.getText().isEmpty()) {
            if (this.xtipo == 0) {
                Principal.clasefacturacion.imprimir_FacturayOrden(1, this.JTFFNOrden.getText(), String.valueOf(this.xId_Ingreso), Principal.usuarioSistemaDTO.getLogin(), 0, 1, 0);
            } else {
                Principal.clasefacturacion.imprimir_FacturayOrden(1, this.JTFFNOrden.getText(), String.valueOf(this.xId_Ingreso), Principal.usuarioSistemaDTO.getLogin(), 2, 1, 0);
            }
        }
    }
}
