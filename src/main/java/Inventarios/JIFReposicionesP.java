package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFReposicionesP.class */
public class JIFReposicionesP extends JInternalFrame {
    private String[] xidproveedores;
    private String[] xidlaboratorio;
    private String[] xidbodega;
    private String[] xidcaterogia;
    private String xidlab = null;
    private boolean xlleno = false;
    private JComboBox JCBBodega;
    private JComboBox JCBBodega1;
    private JComboBox JCBLaboratorio;
    private JComboBox JCBProveedor;
    private JCheckBox JCHFiltro;
    private JButton btnInforme;
    private JPanel jPanel2;

    public JIFReposicionesP() {
        initComponents();
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.xidproveedores = xmt.llenarCombo("SELECT cc_terceros.Id, cc_terceros.RazonSocialCompleta FROM i_reposiciones INNER JOIN i_proveedores ON (i_reposiciones.Id_Proveedores = i_proveedores.Id_Empresa) INNER JOIN cc_terceros  ON (i_proveedores.Id_Empresa = cc_terceros.Id)  GROUP BY cc_terceros.Id  ORDER BY cc_terceros.RazonSocialCompleta ASC ", this.xidproveedores, this.JCBProveedor);
        xmt.cerrarConexionBd();
        this.JCBProveedor.setSelectedIndex(-1);
        this.xidbodega = xmt.llenarCombo("SELECT Id, Nbre FROM i_bodegas WHERE (Estado =0) ORDER BY Nbre ASC", this.xidbodega, this.JCBBodega);
        xmt.cerrarConexionBd();
        this.JCBBodega.setSelectedIndex(-1);
        this.xidcaterogia = xmt.llenarCombo("SELECT Id, Nbre FROM i_categoria WHERE (Estado =0) ORDER BY Nbre ASC", this.xidcaterogia, this.JCBBodega1);
        this.JCBBodega1.setSelectedIndex(-1);
        xmt.cerrarConexionBd();
    }

    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.JCBProveedor = new JComboBox();
        this.JCBLaboratorio = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JCBBodega = new JComboBox();
        this.JCBBodega1 = new JComboBox();
        this.btnInforme = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("REPOSICIONES");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setRequestFocusEnabled(false);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "REPOSICIONES A PROVEEDORES", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBProveedor.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "PROVEEDOR", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBProveedor.addItemListener(new ItemListener() { // from class: Inventarios.JIFReposicionesP.1
            public void itemStateChanged(ItemEvent evt) {
                JIFReposicionesP.this.JCBProveedorItemStateChanged(evt);
            }
        });
        this.JCBLaboratorio.setFont(new Font("Arial", 1, 12));
        this.JCBLaboratorio.setBorder(BorderFactory.createTitledBorder((Border) null, "LABORATORIO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBLaboratorio.setEnabled(false);
        this.JCBLaboratorio.addItemListener(new ItemListener() { // from class: Inventarios.JIFReposicionesP.2
            public void itemStateChanged(ItemEvent evt) {
                JIFReposicionesP.this.JCBLaboratorioItemStateChanged(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Tahoma", 1, 12));
        this.JCHFiltro.setText("Filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Inventarios.JIFReposicionesP.3
            public void actionPerformed(ActionEvent evt) {
                JIFReposicionesP.this.JCHFiltroActionPerformed(evt);
            }
        });
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "BODEGA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBodega.addItemListener(new ItemListener() { // from class: Inventarios.JIFReposicionesP.4
            public void itemStateChanged(ItemEvent evt) {
                JIFReposicionesP.this.JCBBodegaItemStateChanged(evt);
            }
        });
        this.JCBBodega1.setFont(new Font("Arial", 1, 12));
        this.JCBBodega1.setBorder(BorderFactory.createTitledBorder((Border) null, "CATEGORIA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBodega1.addItemListener(new ItemListener() { // from class: Inventarios.JIFReposicionesP.5
            public void itemStateChanged(ItemEvent evt) {
                JIFReposicionesP.this.JCBBodega1ItemStateChanged(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBBodega, 0, 222, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProveedor, -2, 475, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JCBLaboratorio, -2, 380, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBBodega1, 0, 252, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(24, 24, 24).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBProveedor, -2, 48, -2).addComponent(this.JCBBodega, -2, 50, -2)).addGap(27, 27, 27).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBLaboratorio, -2, 56, -2).addComponent(this.JCHFiltro).addComponent(this.JCBBodega1, -2, 50, -2)).addContainerGap(34, 32767)));
        this.btnInforme.setFont(new Font("Arial", 1, 12));
        this.btnInforme.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.btnInforme.setText("Generar Informe");
        this.btnInforme.addActionListener(new ActionListener() { // from class: Inventarios.JIFReposicionesP.6
            public void actionPerformed(ActionEvent evt) {
                JIFReposicionesP.this.btnInformeActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.btnInforme, GroupLayout.Alignment.LEADING, -1, 743, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.btnInforme, -2, 50, -2).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnInformeActionPerformed(ActionEvent evt) {
        mReporte();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            if (this.JCBProveedor.getSelectedIndex() != -1) {
                this.JCBLaboratorio.setEnabled(true);
                this.JCBLaboratorio.requestFocus();
                mCargarComboLab();
                return;
            }
            return;
        }
        this.JCBLaboratorio.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBLaboratorioItemStateChanged(ItemEvent evt) {
        if (this.JCBLaboratorio.getSelectedIndex() != -1 && this.xlleno) {
            this.xidlab = this.xidlaboratorio[this.JCBLaboratorio.getSelectedIndex()];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProveedorItemStateChanged(ItemEvent evt) {
        if (this.JCBProveedor.getSelectedIndex() != -1 && this.xlleno) {
            mCargarComboLab();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBodegaItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBodega1ItemStateChanged(ItemEvent evt) {
    }

    private void mExportar(String xsql) {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            try {
                WritableWorkbook workbook = Workbook.createWorkbook(new File("c:\\plantilla.xls"));
                WritableSheet sheet = workbook.createSheet("plantilla", 0);
                sheet.addCell(new Label(0, 1, "Id"));
                sheet.addCell(new Label(1, 1, "NProducto"));
                sheet.addCell(new Label(2, 1, "PComercial"));
                sheet.addCell(new Label(3, 1, "Laboratorio"));
                sheet.addCell(new Label(4, 1, "Existencia"));
                sheet.addCell(new Label(5, 1, "PReposicion"));
                sheet.addCell(new Label(6, 1, "Minimo"));
                sheet.addCell(new Label(7, 1, "CComprar"));
                sheet.addCell(new Label(8, 1, "VUnitario"));
                sheet.addCell(new Label(9, 1, "VIva"));
                sheet.addCell(new Label(10, 1, "Vtotal"));
                ConsultasMySQL xt2 = new ConsultasMySQL();
                ResultSet rs = xt2.traerRs(xsql);
                if (rs.next()) {
                    rs.beforeFirst();
                    int x = 2;
                    while (rs.next()) {
                        sheet.addCell(new Number(0, x, rs.getLong(1)));
                        sheet.addCell(new Label(1, x, rs.getString(2)));
                        sheet.addCell(new Label(2, x, rs.getString(3)));
                        sheet.addCell(new Label(3, x, rs.getString(4)));
                        sheet.addCell(new Number(4, x, rs.getLong(8)));
                        sheet.addCell(new Number(5, x, rs.getLong(6)));
                        sheet.addCell(new Number(6, x, rs.getLong(7)));
                        sheet.addCell(new Number(7, x, rs.getDouble(10)));
                        sheet.addCell(new Number(8, x, rs.getDouble(11)));
                        sheet.addCell(new Number(9, x, rs.getDouble(13)));
                        sheet.addCell(new Number(10, x, rs.getDouble(14)));
                        x++;
                    }
                }
                rs.close();
                xt2.cerrarConexionBd();
                new SimpleDateFormat("yyyy/MM/dd");
                workbook.write();
                workbook.close();
            } catch (WriteException e) {
                Logger.getLogger(JIFReposicionesP.class.getName()).log(Level.SEVERE, (String) null, e);
            } catch (IOException ex) {
                Logger.getLogger(JIFReposicionesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
            } catch (SQLException ex2) {
                Logger.getLogger(JIFReposicionesP.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex2);
            }
        }
    }

    private void mReporte() {
        Metodos metodos = new Metodos();
        if (this.JCBBodega.getSelectedIndex() != -1) {
            if (this.JCBProveedor.getSelectedIndex() != -1) {
                mCrearVista1();
                mCrearVista2();
                String[][] parametros = new String[5][2];
                parametros[0][0] = "IdProv";
                parametros[0][1] = this.xidproveedores[this.JCBProveedor.getSelectedIndex()];
                parametros[1][0] = "NProveedor";
                parametros[1][1] = this.JCBProveedor.getSelectedItem().toString();
                parametros[2][0] = "IdLab";
                parametros[2][1] = this.xidlab;
                parametros[3][0] = "SUBREPORT_DIR";
                parametros[3][1] = metodos.getSO() + metodos.getBarra() + "Reportes" + metodos.getBarra();
                parametros[4][0] = "SUBREPORTFIRMA_DIR";
                parametros[4][1] = metodos.getSO() + metodos.getBarra() + "Firmas" + metodos.getBarra();
                if (!this.JCHFiltro.isSelected()) {
                    String xsql = "SELECT i_reposiciones.Id_Suministro, i_suministro.Nbre AS NProducto, i_presentacioncomercial.Nbre AS NPComercial,  i_laboratorio.Nbre AS NLaboratorio, i_suministro.Iva   , i_reposiciones.PReposicion, i_reposiciones.Minimo , i_suministrototalunidades.Cant , (i_reposiciones.Minimo-i_suministrototalunidades.Cant) AS Dif, (i_reposiciones.Minimo-i_suministrototalunidades.Cant) AS CComprar, i_reposiciones.Valor AS VUnitario, ((i_reposiciones.Minimo-i_suministrototalunidades.Cant)*i_reposiciones.Valor) AS VTotalSIva , ROUND((((i_reposiciones.Minimo-i_suministrototalunidades.Cant)*i_reposiciones.Valor)*i_suministro.Iva)/100) AS VIva, ROUND(((i_reposiciones.Minimo-i_suministrototalunidades.Cant)*i_reposiciones.Valor)+((((i_reposiciones.Minimo-i_suministrototalunidades.Cant)*i_reposiciones.Valor)*i_suministro.Iva)/100)) AS VTotalCIva  FROM i_reposiciones INNER JOIN i_suministro  ON (i_reposiciones.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)  INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministrototalunidades  ON (i_reposiciones.Id_Suministro = i_suministrototalunidades.CodigoAgrupacion)  WHERE ((i_reposiciones.Minimo-i_suministrototalunidades.Cant)>0) AND (i_suministrototalunidades.Cant<=i_reposiciones.PReposicion) AND Id_Proveedores='" + this.xidproveedores[this.JCBProveedor.getSelectedIndex()] + "' and i_suministro.IdCategoria='" + this.xidcaterogia[this.JCBBodega1.getSelectedIndex()] + "' AND i_reposiciones.p= 1 AND i_reposiciones.Valor<>0 ORDER BY i_laboratorio.Nbre ASC,  i_suministro.Nbre ASC  ";
                    metodos.GenerarPDF(metodos.getRutaRep() + "I_ListadoProductosReponerProveedores", parametros);
                    mExportar(xsql);
                    return;
                } else {
                    String xsql2 = "SELECT i_reposiciones.Id_Suministro, i_suministro.Nbre AS NProducto, i_presentacioncomercial.Nbre AS NPComercial,  i_laboratorio.Nbre AS NLaboratorio, i_suministro.Iva   , i_reposiciones.PReposicion, i_reposiciones.Minimo , i_suministrototalunidades.Cant , (i_reposiciones.Minimo-i_suministrototalunidades.Cant) AS Dif, (i_reposiciones.Minimo-i_suministrototalunidades.Cant) AS CComprar, i_reposiciones.Valor AS VUnitario, ((i_reposiciones.Minimo-i_suministrototalunidades.Cant)*i_reposiciones.Valor) AS VTotalSIva , ROUND((((i_reposiciones.Minimo-i_suministrototalunidades.Cant)*i_reposiciones.Valor)*i_suministro.Iva)/100) AS VIva, ROUND(((i_reposiciones.Minimo-i_suministrototalunidades.Cant)*i_reposiciones.Valor)+((((i_reposiciones.Minimo-i_suministrototalunidades.Cant)*i_reposiciones.Valor)*i_suministro.Iva)/100)) AS VTotalCIva  FROM i_reposiciones INNER JOIN i_suministro  ON (i_reposiciones.Id_Suministro = i_suministro.Id) INNER JOIN i_presentacioncomercial  ON (i_suministro.IdPresentacionComercial = i_presentacioncomercial.Id)  INNER JOIN i_laboratorio ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN i_suministrototalunidades  ON (i_reposiciones.Id_Suministro = i_suministrototalunidades.CodigoAgrupacion)  WHERE ((i_reposiciones.Minimo-i_suministrototalunidades.Cant)>0) AND (i_suministrototalunidades.Cant<=i_reposiciones.PReposicion) AND Id_Proveedores='" + this.xidproveedores[this.JCBProveedor.getSelectedIndex()] + "' AND i_suministro.IdLaboratorio='" + this.xidlaboratorio[this.JCBLaboratorio.getSelectedIndex()] + "' and i_suministro.IdCategoria='" + this.xidcaterogia[this.JCBBodega1.getSelectedIndex()] + "'  AND i_reposiciones.p= 1 AND i_reposiciones.Valor<>0 ORDER BY i_laboratorio.Nbre ASC,  i_suministro.Nbre ASC  ";
                    metodos.GenerarPDF(metodos.getRutaRep() + "I_ListadoProductosReponerProveedoresxLaboratorio", parametros);
                    mExportar(xsql2);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un proveedor", "VERIFICAR", 0);
            this.JCBProveedor.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 0);
        this.JCBBodega.requestFocus();
    }

    private void mCargarComboLab() {
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.JCBLaboratorio.removeAllItems();
        String xsql = " SELECT i_laboratorio.Id, i_laboratorio.Nbre  FROM i_reposiciones INNER JOIN i_suministro  ON (i_reposiciones.Id_Suministro = i_suministro.Id)  INNER JOIN i_laboratorio  ON (i_suministro.IdLaboratorio = i_laboratorio.Id)  WHERE (i_reposiciones.Id_Proveedores ='" + this.xidproveedores[this.JCBProveedor.getSelectedIndex()] + "')  GROUP BY i_laboratorio.Id ORDER BY i_laboratorio.Nbre ASC ";
        this.xidlaboratorio = xmt.llenarCombo(xsql, this.xidlaboratorio, this.JCBLaboratorio);
        this.JCBLaboratorio.setSelectedIndex(-1);
        xmt.cerrarConexionBd();
        this.xlleno = true;
    }

    private void mCrearVista2() {
        ConsultasMySQL xmt = new ConsultasMySQL();
        xmt.ejecutarSQL("DROP VIEW IF EXISTS i_suministrototalunidades  ");
        xmt.cerrarConexionBd();
        String sqlw = "CREATE VIEW i_suministrototalunidades AS SELECT r_suministroxunidades.CodigoAgrupacion AS CodigoAgrupacion, ROUND((r_suministroxunidades.Total / i_suministro.CantidadUnidad),0) AS Cant FROM (i_suministro JOIN r_suministroxunidades ON ((i_suministro.Id = r_suministroxunidades.CodigoAgrupacion))) ";
        xmt.ejecutarSQL(sqlw);
        xmt.cerrarConexionBd();
    }

    private void mCrearVista1() {
        ConsultasMySQL xmt = new ConsultasMySQL();
        xmt.ejecutarSQL("DROP VIEW IF EXISTS r_suministroxunidades  ");
        xmt.cerrarConexionBd();
        String sql = "SELECT i_suministro.CodigoAgrupacion AS CodigoAgrupacion,i_suministro.CantidadUnidad   AS CantidadUnidad, ROUND(SUM(i_suministroxlotexbodega.Cantidad),0) AS Total FROM ((i_suministroxbodega JOIN i_suministro ON ((i_suministroxbodega.IdSuministro = i_suministro.Id))) JOIN i_suministroxlotexbodega ON ((i_suministroxlotexbodega.Id = i_suministroxbodega.Id))) WHERE (i_suministroxbodega.IdBodega ='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "') GROUP BY i_suministro.CodigoAgrupacion ORDER BY i_suministro.CodigoAgrupacion ";
        String sqlw = "CREATE VIEW r_suministroxunidades AS " + sql;
        xmt.ejecutarSQL(sqlw);
        xmt.cerrarConexionBd();
    }
}
