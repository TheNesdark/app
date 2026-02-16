package Inventarios;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFReposicionesBd.class */
public class JIFReposicionesBd extends JInternalFrame {
    private String[] xidbodega;
    private String xtitulo;
    private String xestado = "1";
    private Metodos metodos = new Metodos();
    private JComboBox JCBBodega;
    private JButton btnInforme;
    private JPanel jPanel2;

    public JIFReposicionesBd() {
        initComponents();
        ConsultasMySQL xmt = new ConsultasMySQL();
        this.xidbodega = xmt.llenarCombo("SELECT i_bodegas.Id , i_bodegas.Nbre FROM i_reposicionesbodegas INNER JOIN i_bodegas  ON (i_reposicionesbodegas.Id_Bodegas = i_bodegas.Id) GROUP BY i_bodegas.Id ORDER BY i_bodegas.Nbre ASC", this.xidbodega, this.JCBBodega);
        xmt.cerrarConexionBd();
    }

    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.JCBBodega = new JComboBox();
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
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "REPOSICIONES A BODEGAS ALTERNAS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "BOEDEGA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.btnInforme.setFont(new Font("Arial", 1, 12));
        this.btnInforme.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Informes.png")));
        this.btnInforme.setText("Generar Informe");
        this.btnInforme.addActionListener(new ActionListener() { // from class: Inventarios.JIFReposicionesBd.1
            public void actionPerformed(ActionEvent evt) {
                JIFReposicionesBd.this.btnInformeActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBBodega, 0, 663, 32767).addComponent(this.btnInforme, GroupLayout.Alignment.TRAILING, -1, 663, 32767)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBBodega, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 43, 32767).addComponent(this.btnInforme, -2, 50, -2).addGap(32, 32, 32)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnInformeActionPerformed(ActionEvent evt) {
        mGenerar();
    }

    private void mGenerar() {
        ConsultasMySQL xmt = new ConsultasMySQL();
        String sql = "WITH set_datos  AS (\nSELECT i_bodegas.Id AS idBodega\n\t, i_bodegas.Nbre nombreBodega, \n    i_suministro.Id AS idSuministro\n    , i_suministro.CodBarraUnidad\n    , i_suministro.CantidadUnidad\n    , i_suministro.CodigoAgrupacion  \n    , i_suministro.Nbre AS NSuministro\n    , i_suministro.RegistroInvima  \n    , i_suministro.FechaVInvima  \n    , IFNULL(i_suministro.CodigoCUM,'') AS CodigoCUM \n    , IFNULL(i_suministro.CodigoAtc,'') AS CodigoAtc \n   , i_laboratorio.Nbre AS NLaboratorio\n    , i_suministroxlotexbodega.Lote\n    , i_suministroxlotexbodega.FechaVencimiento\n    , i_suministroxlotexbodega.Cantidad\n    ,it.Nbre tipoProducto\n    , ic.Nbre tipoCategoria\n     , i_clasificacion.Nbre AS NClasificacion\n    , ip.Nbre nombrePrincipioActivo\n    , ip2.Nbre nombrePresentacionComercial\n    , ip3.Nbre nombrePresentacionFarmaceutica\n    , IF(i_suministro.Pos=0,'NO POS','POS') AS clasificacion \n    , i_concentracion.Nbre  nombreConcentracion \n    , i_tipoproducto.Id idTipoProducto\n   , i_suministroxlotexbodega.Id idSuministroLoteBodega\nFROM\n     i_suministroxbodega\n    INNER JOIN  i_suministro \n        ON (i_suministroxbodega.IdSuministro = i_suministro.Id)\n     INNER JOIN  i_suministroxlotexbodega \n         ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)\n    INNER JOIN  i_laboratorio \n        ON (i_suministro.IdLaboratorio = i_laboratorio.Id)\n    INNER JOIN  i_tipoproducto \n        ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)\n    INNER JOIN  i_bodegas \n        ON (i_suministroxbodega.IdBodega = i_bodegas.Id)        \n    INNER JOIN  i_concentracion \n        ON (i_suministro.idconcentracion = i_concentracion.Id) \n    INNER JOIN i_tipoproducto it  ON (it.Id=i_suministro.IdTipoProducto)   \n    INNER  JOIN i_categoria ic ON (ic.Id=i_suministro.IdCategoria)\n    INNER JOIN i_principioactivo ip ON (ip.Id=i_suministro.IdPrincipioActivo)\n    INNER JOIN i_presentacioncomercial ip2 ON (ip2.Id=i_suministro.IdPresentacionComercial)\n    INNER JOIN i_presentacionfarmaceutica ip3 ON (ip3.Id=i_suministro.IdPresentacionFarmaceutica)\n    INNER JOIN i_clasificacion\n        ON (i_suministro.IdClasificacion= i_clasificacion.Id)\n   WHERE  i_suministroxbodega.IdBodega=   '" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' \n   --  AND i_suministro.Id=1203\n   )\n      ,  set_salida AS (\n\tSELECT\n    i_detallesalida.IdSuministro\n    , i_detallesalida.Lote\n   -- , avg(i_detallesalida.ValorUnitario) as valor\n  -- ,i_detallesalida.ValorUnitario\n    , SUM(i_detallesalida.CantidadDespachada) AS CSalida\nFROM\n     i_detallesalida\n    INNER JOIN  i_salidas \n        ON (i_detallesalida.IdSalida = i_salidas.Id)\nWHERE (i_salidas.FechaSalida <= '" + this.metodos.formatoAMD1.format(this.metodos.getFechaActual()) + "' \n    AND i_salidas.IdBodega= '" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' \n    AND i_salidas.Estado=0\n  --    AND i_detallesalida.IdSuministro=1203\n    )\nGROUP BY  i_detallesalida.IdSuministro\n  , i_detallesalida.Lote\n   ) \n      ,  set_entrada AS (\n\tSELECT\n    i_detalleentrada.IdSuministro\t\n    , i_detalleentrada.Lote\n    , SUM(i_detalleentrada.Cantidad) AS CEntrada\n    , i_entradas.IdBodega\n     ,SUM(i_detalleentrada.Cantidad*(i_detalleentrada.ValorUnitario+((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+i_detalleentrada.VFletesO-i_detalleentrada.VDescuento)) Valortotal\n    FROM\n     i_detalleentrada\n    INNER JOIN  i_entradas\n        ON (i_detalleentrada.IdEntrada = i_entradas.Id)\nWHERE (i_entradas.FechaEntrada <= '" + this.metodos.formatoAMD1.format(this.metodos.getFechaActual()) + "' \n    AND i_entradas.IdBodega= '" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "' \n    AND i_entradas.Estado=0 \n   --  AND i_detalleentrada.IdSuministro\t=1203\n    )\t\nGROUP BY  i_detalleentrada.IdSuministro\n   , i_detalleentrada.Lote\n   ) \n   , set_entrada_def AS (\nSELECT Idsuministro,\n Lote,\n CEntrada,\n IdBodega,\n (Valortotal/CEntrada) costo_lote ,\n SUM(Valortotal) over (PARTITION BY Idsuministro)/SUM(CEntrada) over (PARTITION BY Idsuministro) valorUnitario\nFROM set_entrada\n)   \n    SELECT \n    i.CodigoAgrupacion\n    , SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) Cantidad\n    ,  sum(DISTINCT ROUND(ifnull(e.valorUnitario,0)))valorUnitario\n    , NOW()  \n   \n       FROM set_datos i\n    LEFT JOIN set_entrada_def e ON (e.IdSuministro=i.idSuministro)  AND (e.Lote=i.Lote)\n  LEFT  JOIN set_salida s ON (s.IdSuministro=i.idSuministro)  AND (s.Lote=i.Lote)\n   where   i.Lote<>'FALTANTE'\n  GROUP BY  i.CodigoAgrupacion";
        ResultSet rs = xmt.traerRs(sql);
        try {
            if (rs.next()) {
                rs.beforeFirst();
                ConsultasMySQL xmt1 = new ConsultasMySQL();
                while (rs.next()) {
                    String sql1 = "update i_reposicionesbodegas set Existencia='" + rs.getInt(2) + "' where Id_Suministro='" + rs.getInt(1) + "' and Id_Bodegas='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'";
                    xmt1.ejecutarSQL(sql1);
                    xmt1.cerrarConexionBd();
                }
                mReporte();
            }
            rs.close();
            xmt.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFReposicionesBd.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mReporte() {
        Metodos metodos = new Metodos();
        if (this.JCBBodega.getSelectedIndex() != -1) {
            String[][] parametros = new String[4][2];
            parametros[0][0] = "IdBodega";
            parametros[0][1] = this.xidbodega[this.JCBBodega.getSelectedIndex()];
            parametros[1][0] = "nbreBodega";
            parametros[1][1] = this.JCBBodega.getSelectedItem().toString();
            parametros[2][0] = "SUBREPORT_DIR";
            parametros[2][1] = metodos.getSO() + metodos.getBarra() + "Reportes" + metodos.getBarra();
            parametros[3][0] = "SUBREPORTFIRMA_DIR";
            parametros[3][1] = metodos.getSO() + metodos.getBarra() + "Firmas" + metodos.getBarra();
            metodos.GenerarPDF(metodos.getRutaRep() + "I_ListadoProductosReponer", parametros);
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una bodega", "VERIFICAR", 0);
        this.JCBBodega.requestFocus();
    }
}
