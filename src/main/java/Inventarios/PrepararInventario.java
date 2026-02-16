package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/PrepararInventario.class */
public class PrepararInventario extends JInternalFrame {
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private String[] listaBodega;
    private String sql;
    private claseInventario claseInv;
    private JComboBox cboBodega;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JDateChooser txtFecha;
    private JTextField txtInventario;
    private JLabel txtProgreso;
    private JLabel txtProgreso1;

    public PrepararInventario(claseInventario claseI) {
        initComponents();
        this.claseInv = claseI;
        llenarCombo();
        this.txtFecha.setDate(this.metodos.getFechaActual());
    }

    private void copiarDatosSuminisBodegaInv(String IdInventario) {
        this.txtProgreso.setText("Copiando Existencia y Costo de Productos...");
        this.sql = "INSERT INTO i_suministroxbodegainv (Id_SuministroBodega, Id_Inventario, Existencia, Costo, Fecha, UsuarioS) WITH set_datos  AS (\nSELECT i_bodegas.Id AS idBodega\n\t, i_bodegas.Nbre nombreBodega, \n    i_suministro.Id AS idSuministro\n    , i_suministro.CodBarraUnidad\n    , i_suministro.CantidadUnidad\n    , i_suministro.Nbre AS NSuministro\n    , i_suministro.RegistroInvima  \n    , i_suministro.FechaVInvima  \n    , IFNULL(i_suministro.CodigoCUM,'') AS CodigoCUM \n    , IFNULL(i_suministro.CodigoAtc,'') AS CodigoAtc \n   , i_laboratorio.Nbre AS NLaboratorio\n    , i_suministroxlotexbodega.Lote\n    , i_suministroxlotexbodega.FechaVencimiento\n    , i_suministroxlotexbodega.Cantidad\n    ,it.Nbre tipoProducto\n    , ic.Nbre tipoCategoria\n     , i_clasificacion.Nbre AS NClasificacion\n    , ip.Nbre nombrePrincipioActivo\n    , ip2.Nbre nombrePresentacionComercial\n    , ip3.Nbre nombrePresentacionFarmaceutica\n    , IF(i_suministro.Pos=0,'NO POS','POS') AS clasificacion \n    , i_concentracion.Nbre  nombreConcentracion \n    , i_tipoproducto.Id idTipoProducto\n   , i_suministroxlotexbodega.Id idSuministroLoteBodega\n\nFROM\n     i_suministroxbodega\n    INNER JOIN  i_suministro \n        ON (i_suministroxbodega.IdSuministro = i_suministro.Id)\n     INNER JOIN  i_suministroxlotexbodega \n         ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)\n    INNER JOIN  i_laboratorio \n        ON (i_suministro.IdLaboratorio = i_laboratorio.Id)\n    INNER JOIN  i_tipoproducto \n        ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)\n    INNER JOIN  i_bodegas \n        ON (i_suministroxbodega.IdBodega = i_bodegas.Id)        \n    INNER JOIN  i_concentracion \n        ON (i_suministro.idconcentracion = i_concentracion.Id) \n    INNER JOIN i_tipoproducto it  ON (it.Id=i_suministro.IdTipoProducto)   \n    INNER  JOIN i_categoria ic ON (ic.Id=i_suministro.IdCategoria)\n    INNER JOIN i_principioactivo ip ON (ip.Id=i_suministro.IdPrincipioActivo)\n    INNER JOIN i_presentacioncomercial ip2 ON (ip2.Id=i_suministro.IdPresentacionComercial)\n    INNER JOIN i_presentacionfarmaceutica ip3 ON (ip3.Id=i_suministro.IdPresentacionFarmaceutica)\n    INNER JOIN i_clasificacion\n        ON (i_suministro.IdClasificacion= i_clasificacion.Id)\n   WHERE  i_suministroxbodega.IdBodega=   '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "' \n   --  AND i_suministro.Id=1203\n   )\n      ,  set_salida AS (\n\tSELECT\n    i_detallesalida.IdSuministro\n    , i_detallesalida.Lote\n   -- , avg(i_detallesalida.ValorUnitario) as valor\n  -- ,i_detallesalida.ValorUnitario\n    , SUM(i_detallesalida.CantidadDespachada) AS CSalida\nFROM\n     i_detallesalida\n    INNER JOIN  i_salidas \n        ON (i_detallesalida.IdSalida = i_salidas.Id)\nWHERE (i_salidas.FechaSalida <= '" + this.metodos.formatoAMD1.format(this.txtFecha.getDate()) + "' \n    AND i_salidas.IdBodega= '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "' \n    AND i_salidas.Estado=0\n  --    AND i_detallesalida.IdSuministro=1203\n    )\nGROUP BY  i_detallesalida.IdSuministro\n  , i_detallesalida.Lote\n   ) \n      ,  set_entrada AS (\n\tSELECT\n    i_detalleentrada.IdSuministro\t\n    , i_detalleentrada.Lote\n    , SUM(i_detalleentrada.Cantidad) AS CEntrada\n    , i_entradas.IdBodega\n     ,SUM(i_detalleentrada.Cantidad*(i_detalleentrada.ValorUnitario+((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+i_detalleentrada.VFletesO-i_detalleentrada.VDescuento)) Valortotal\n    FROM\n     i_detalleentrada\n    INNER JOIN  i_entradas\n        ON (i_detalleentrada.IdEntrada = i_entradas.Id)\nWHERE (i_entradas.FechaEntrada <=  '" + this.metodos.formatoAMD1.format(this.txtFecha.getDate()) + "' \n    AND i_entradas.IdBodega= '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "' \n    AND i_entradas.Estado=0 \n   --  AND i_detalleentrada.IdSuministro\t=1203\n    )\t\nGROUP BY  i_detalleentrada.IdSuministro\n   , i_detalleentrada.Lote\n   ) \n   , set_entrada_def AS (\nSELECT Idsuministro,\n Lote,\n CEntrada,\n IdBodega,\n (Valortotal/CEntrada) costo_lote ,\n SUM(Valortotal) over (PARTITION BY Idsuministro)/SUM(CEntrada) over (PARTITION BY Idsuministro) valorUnitario\nFROM set_entrada\n)   \n    SELECT \n    i.idSuministroLoteBodega\n    ,'" + IdInventario + "'\n    , SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) Cantidad\n    ,  sum(DISTINCT ROUND(ifnull(e.valorUnitario,0)))valorUnitario\n    , NOW()  \n    , '" + Principal.usuarioSistemaDTO.getLogin() + "' \n     \n  FROM set_datos i\n    LEFT JOIN set_entrada_def e ON (e.IdSuministro=i.idSuministro)  AND (e.Lote=i.Lote)\n  LEFT  JOIN set_salida s ON (s.IdSuministro=i.idSuministro)  AND (s.Lote=i.Lote)\n   where   i.Lote<>'FALTANTE'\n  GROUP BY  i.idSuministroLoteBodega";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.txtProgreso.setText("Productos copiados.");
    }

    private void copiarDatosSuminisLoteBodegaInv(String IdInventario) {
        this.txtProgreso.setText("Copiando datos de Cantidades y Lotes de Productos...");
        this.sql = "INSERT INTO i_suministroxlotexbodegainv (Id, Id_Inventario, Lote, FechaVencimiento, Cantidad) WITH set_datos  AS (\nSELECT i_bodegas.Id AS idBodega\n\t, i_bodegas.Nbre nombreBodega, \n    i_suministro.Id AS idSuministro\n    , i_suministro.CodBarraUnidad\n    , i_suministro.CantidadUnidad\n    , i_suministro.Nbre AS NSuministro\n    , i_suministro.RegistroInvima  \n    , i_suministro.FechaVInvima  \n    , IFNULL(i_suministro.CodigoCUM,'') AS CodigoCUM \n    , IFNULL(i_suministro.CodigoAtc,'') AS CodigoAtc \n   , i_laboratorio.Nbre AS NLaboratorio\n    , i_suministroxlotexbodega.Lote\n    , i_suministroxlotexbodega.FechaVencimiento\n    , i_suministroxlotexbodega.Cantidad\n    ,it.Nbre tipoProducto\n    , ic.Nbre tipoCategoria\n     , i_clasificacion.Nbre AS NClasificacion\n    , ip.Nbre nombrePrincipioActivo\n    , ip2.Nbre nombrePresentacionComercial\n    , ip3.Nbre nombrePresentacionFarmaceutica\n    , IF(i_suministro.Pos=0,'NO POS','POS') AS clasificacion \n    , i_concentracion.Nbre  nombreConcentracion \n    , i_tipoproducto.Id idTipoProducto\n   , i_suministroxlotexbodega.Id idSuministroLoteBodega\n\nFROM\n     i_suministroxbodega\n    INNER JOIN  i_suministro \n        ON (i_suministroxbodega.IdSuministro = i_suministro.Id)\n     INNER JOIN  i_suministroxlotexbodega \n         ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)\n    INNER JOIN  i_laboratorio \n        ON (i_suministro.IdLaboratorio = i_laboratorio.Id)\n    INNER JOIN  i_tipoproducto \n        ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)\n    INNER JOIN  i_bodegas \n        ON (i_suministroxbodega.IdBodega = i_bodegas.Id)        \n    INNER JOIN  i_concentracion \n        ON (i_suministro.idconcentracion = i_concentracion.Id) \n    INNER JOIN i_tipoproducto it  ON (it.Id=i_suministro.IdTipoProducto)   \n    INNER  JOIN i_categoria ic ON (ic.Id=i_suministro.IdCategoria)\n    INNER JOIN i_principioactivo ip ON (ip.Id=i_suministro.IdPrincipioActivo)\n    INNER JOIN i_presentacioncomercial ip2 ON (ip2.Id=i_suministro.IdPresentacionComercial)\n    INNER JOIN i_presentacionfarmaceutica ip3 ON (ip3.Id=i_suministro.IdPresentacionFarmaceutica)\n    INNER JOIN i_clasificacion\n        ON (i_suministro.IdClasificacion= i_clasificacion.Id)\n   WHERE  i_suministroxbodega.IdBodega=   '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "' \n   --  AND i_suministro.Id=1203\n   )\n      ,  set_salida AS (\n\tSELECT\n    i_detallesalida.IdSuministro\n    , i_detallesalida.Lote\n   -- , avg(i_detallesalida.ValorUnitario) as valor\n  -- ,i_detallesalida.ValorUnitario\n    , SUM(i_detallesalida.CantidadDespachada) AS CSalida\nFROM\n     i_detallesalida\n    INNER JOIN  i_salidas \n        ON (i_detallesalida.IdSalida = i_salidas.Id)\nWHERE (i_salidas.FechaSalida <= '" + this.metodos.formatoAMD1.format(this.txtFecha.getDate()) + "' \n    AND i_salidas.IdBodega= '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "' \n    AND i_salidas.Estado=0\n  --    AND i_detallesalida.IdSuministro=1203\n    )\nGROUP BY  i_detallesalida.IdSuministro\n  , i_detallesalida.Lote\n   ) \n      ,  set_entrada AS (\n\tSELECT\n    i_detalleentrada.IdSuministro\t\n    , i_detalleentrada.Lote\n    , SUM(i_detalleentrada.Cantidad) AS CEntrada\n    , i_entradas.IdBodega\n     ,SUM(i_detalleentrada.Cantidad*(i_detalleentrada.ValorUnitario+((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+i_detalleentrada.VFletesO-i_detalleentrada.VDescuento)) Valortotal\n    FROM\n     i_detalleentrada\n    INNER JOIN  i_entradas\n        ON (i_detalleentrada.IdEntrada = i_entradas.Id)\nWHERE (i_entradas.FechaEntrada <=  '" + this.metodos.formatoAMD1.format(this.txtFecha.getDate()) + "' \n    AND i_entradas.IdBodega= '" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "' \n    AND i_entradas.Estado=0 \n   --  AND i_detalleentrada.IdSuministro\t=1203\n    )\t\nGROUP BY  i_detalleentrada.IdSuministro\n   , i_detalleentrada.Lote\n   ) \n   , set_entrada_def AS (\nSELECT Idsuministro,\n Lote,\n CEntrada,\n IdBodega,\n (Valortotal/CEntrada) costo_lote ,\n SUM(Valortotal) over (PARTITION BY Idsuministro)/SUM(CEntrada) over (PARTITION BY Idsuministro) valorUnitario\nFROM set_entrada\n)   \n    SELECT \n    i.idSuministroLoteBodega\n    ,'" + IdInventario + "'\n    , i.Lote Lote\n     , i.FechaVencimiento FechaVencimiento\n      , SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) Cantidad\n     \n  FROM set_datos i\n    LEFT JOIN set_entrada_def e ON (e.IdSuministro=i.idSuministro)  AND (e.Lote=i.Lote)\n  LEFT  JOIN set_salida s ON (s.IdSuministro=i.idSuministro)  AND (s.Lote=i.Lote)\n   where   i.Lote<>'FALTANTE'\n  GROUP BY i.idSuministro\n  , Lote";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
    }

    public void grabar() {
        if (this.cboBodega.getSelectedIndex() < 0) {
            this.metodos.mostrarMensaje("Por favor seleccione una Bodega");
            this.cboBodega.requestFocus();
            return;
        }
        if (this.metodos.getPregunta("Esta seguro de Proceder?") == 0) {
            if (validarExistencia() == 1) {
                this.txtProgreso.setText("Espere mientras se registra la fecha del Inventario.");
                this.sql = "INSERT IGNORE INTO i_inventario (Id_Bodega, Fecha_Inventario, Fecha, UsuarioS) VALUES ('" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "','" + this.metodos.formatoAMD.format(this.txtFecha.getDate()) + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                String IdInventario = this.consultas.ejecutarSQLId(this.sql);
                this.txtInventario.setText(IdInventario);
                this.txtProgreso.setText("Fecha Registrada...");
                copiarDatosSuminisBodegaInv(IdInventario);
                copiarDatosSuminisLoteBodegaInv(IdInventario);
                this.consultas.cerrarConexionBd();
                this.txtProgreso.setText("Proceso Terminado");
                this.metodos.mostrarMensaje("Proceso de copia terminado");
                return;
            }
            this.metodos.mostrarMensaje("Ya Existe un Inventario abierto para la Bodega " + this.cboBodega.getSelectedItem());
        }
    }

    private void llenarCombo() {
        this.listaBodega = this.consultas.llenarCombo("SELECT Id, Nbre FROM i_bodegas ORDER BY Nbre ASC", this.listaBodega, this.cboBodega);
        this.consultas.cerrarConexionBd();
    }

    public void nuevo() {
        this.txtFecha.setDate(this.metodos.getFechaActual());
        this.cboBodega.setSelectedIndex(-1);
        this.txtProgreso.setText("");
    }

    private int validarExistencia() {
        int op = 0;
        this.sql = "SELECT Fecha_Inventario FROM i_inventario WHERE (Fecha_Cierre ='0000-00-00 00:00:00' AND Id_Bodega ='" + this.listaBodega[this.cboBodega.getSelectedIndex()] + "')";
        String dato = this.consultas.traerDato(this.sql);
        this.consultas.cerrarConexionBd();
        if (dato.isEmpty()) {
            op = 1;
        }
        return op;
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.cboBodega = new JComboBox();
        this.txtFecha = new JDateChooser();
        this.txtProgreso = new JLabel();
        this.txtProgreso1 = new JLabel();
        this.txtInventario = new JTextField();
        this.jLabel1 = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INVENTARIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(960, 379));
        setMinimumSize(new Dimension(960, 379));
        setName("PrepararInventario");
        setPreferredSize(new Dimension(960, 379));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.setName("");
        this.jPanel1.setLayout((LayoutManager) null);
        this.cboBodega.setFont(new Font("Arial", 1, 12));
        this.cboBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.cboBodega);
        this.cboBodega.setBounds(210, 48, 460, 50);
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha del Inventario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.txtFecha.setFont(new Font("Arial", 1, 12));
        this.jPanel1.add(this.txtFecha);
        this.txtFecha.setBounds(20, 48, 160, 50);
        this.txtProgreso.setFont(new Font("Arial", 1, 12));
        this.txtProgreso.setBorder(BorderFactory.createEtchedBorder());
        this.jPanel1.add(this.txtProgreso);
        this.txtProgreso.setBounds(20, 230, 900, 50);
        this.txtProgreso1.setBackground((Color) null);
        this.txtProgreso1.setFont(new Font("Arial", 1, 14));
        this.txtProgreso1.setForeground(new Color(255, 0, 51));
        this.txtProgreso1.setHorizontalAlignment(0);
        this.txtProgreso1.setText("Este módulo le permite pasar los datos del Inventario actual a las tablas en las cuales se realizará el Inventario.");
        this.txtProgreso1.setBorder(BorderFactory.createEtchedBorder());
        this.txtProgreso1.setOpaque(true);
        this.jPanel1.add(this.txtProgreso1);
        this.txtProgreso1.setBounds(20, 150, 900, 50);
        this.txtInventario.setBackground((Color) null);
        this.txtInventario.setFont(new Font("Arial", 1, 20));
        this.txtInventario.setHorizontalAlignment(0);
        this.txtInventario.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Inventario", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jPanel1.add(this.txtInventario);
        this.txtInventario.setBounds(690, 40, 230, 60);
        this.jLabel1.setBackground((Color) null);
        this.jLabel1.setFont(new Font("Arial", 1, 14));
        this.jLabel1.setForeground(new Color(0, 102, 0));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("PREPARACION DE INVENTARIO");
        this.jLabel1.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -1, 944, 32767).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jPanel1, -1, 930, 32767).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, 293, -2).addContainerGap(17, 32767)));
        pack();
    }
}
