package Inventarios;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Inventarios/JIFAuditoriasProductos.class */
public class JIFAuditoriasProductos extends JInternalFrame {
    private String xsql;
    private String[] xidbodega;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdato;
    private JButton JBTActualizar;
    private JComboBox JCBBodega;
    private JCheckBox JCHFValor;
    private JPanel JPIFiltro;
    private JScrollPane JSPDetalleP;
    private JSpinner JSPNProductos;
    private JScrollPane JSPProductos;
    private JFormattedTextField JTFFVMaximo;
    private JFormattedTextField JTFFVMinimo;
    private JTable JTPDetalleP;
    private JTable JTPProductos;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xestadoc = 0;

    public JIFAuditoriasProductos(String xnombre) {
        initComponents();
        setName(xnombre);
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v44, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v51, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIFiltro = new JPanel();
        this.JCBBodega = new JComboBox();
        this.JSPNProductos = new JSpinner();
        this.JCHFValor = new JCheckBox();
        this.JTFFVMinimo = new JFormattedTextField();
        this.JTFFVMaximo = new JFormattedTextField();
        this.JSPProductos = new JScrollPane();
        this.JTPProductos = new JTable();
        this.JSPDetalleP = new JScrollPane();
        this.JTPDetalleP = new JTable();
        this.JBTActualizar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("AUDITORIAS ALEATORIAS DE MEDICAMENTOS E INSUMOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifauditoriaaleatoria");
        addInternalFrameListener(new InternalFrameListener() { // from class: Inventarios.JIFAuditoriasProductos.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFAuditoriasProductos.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPNProductos.setFont(new Font("Arial", 1, 12));
        this.JSPNProductos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPNProductos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Items", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHFValor.setFont(new Font("Arial", 1, 12));
        this.JCHFValor.setText("Es por valor?");
        this.JTFFVMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Mínimo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFVMinimo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVMinimo.setHorizontalAlignment(4);
        this.JTFFVMinimo.setFont(new Font("Arial", 1, 12));
        this.JTFFVMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Máximo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFVMaximo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFVMaximo.setHorizontalAlignment(4);
        this.JTFFVMaximo.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBBodega, -2, 277, -2).addGap(18, 18, 18).addComponent(this.JSPNProductos, -2, 91, -2).addGap(18, 18, 18).addComponent(this.JCHFValor).addGap(18, 18, 18).addComponent(this.JTFFVMinimo, -2, 132, -2).addGap(18, 18, 18).addComponent(this.JTFFVMaximo, -2, 132, -2).addContainerGap(44, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBBodega, GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNProductos, -2, 50, -2).addComponent(this.JTFFVMinimo, -2, 50, -2).addComponent(this.JTFFVMaximo, -2, 50, -2)))).addGap(35, 35, 35)).addGroup(GroupLayout.Alignment.TRAILING, JPIFiltroLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCHFValor).addGap(34, 34, 34)));
        this.JSPProductos.setBorder(BorderFactory.createTitledBorder((Border) null, "MEDICAMENTOS / INSUMOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTPProductos.setFont(new Font("Arial", 1, 12));
        this.JTPProductos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPProductos.setRowHeight(25);
        this.JTPProductos.setSelectionBackground(new Color(255, 255, 255));
        this.JTPProductos.setSelectionForeground(new Color(255, 0, 0));
        this.JTPProductos.setSelectionMode(0);
        this.JTPProductos.addMouseListener(new MouseAdapter() { // from class: Inventarios.JIFAuditoriasProductos.2
            public void mouseClicked(MouseEvent evt) {
                JIFAuditoriasProductos.this.JTPProductosMouseClicked(evt);
            }
        });
        this.JSPProductos.setViewportView(this.JTPProductos);
        this.JSPDetalleP.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTPDetalleP.setFont(new Font("Arial", 1, 12));
        this.JTPDetalleP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPDetalleP.setRowHeight(25);
        this.JTPDetalleP.setSelectionBackground(new Color(255, 255, 255));
        this.JTPDetalleP.setSelectionForeground(new Color(255, 0, 0));
        this.JTPDetalleP.setSelectionMode(0);
        this.JSPDetalleP.setViewportView(this.JTPDetalleP);
        this.JBTActualizar.setFont(new Font("Arial", 1, 12));
        this.JBTActualizar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTActualizar.setText("Actualización");
        this.JBTActualizar.addActionListener(new ActionListener() { // from class: Inventarios.JIFAuditoriasProductos.3
            public void actionPerformed(ActionEvent evt) {
                JIFAuditoriasProductos.this.JBTActualizarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFiltro, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JSPDetalleP, -2, 478, -2).addGap(47, 47, 47).addComponent(this.JBTActualizar, -1, -1, 32767)).addComponent(this.JSPProductos)).addContainerGap(16, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFiltro, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPProductos, -1, 251, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalleP, -1, 122, 32767).addComponent(this.JBTActualizar, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPProductosMouseClicked(MouseEvent evt) {
        if (this.JTPProductos.getSelectedRow() != -1) {
            mCargarDatosTablaLotes();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTActualizarActionPerformed(ActionEvent evt) {
        if (this.JTPProductos.getRowCount() >= 1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                for (int y = 0; y < this.JTPProductos.getRowCount(); y++) {
                    this.xsql = "update i_detalleauditoria set `CantidadFisica`='" + this.xmodelo.getValueAt(y, 5) + "', `Explicacion`='" + this.xmodelo.getValueAt(y, 6) + "', `Accion`='" + this.xmodelo.getValueAt(y, 7) + "' where `Id`='" + Principal.txtNo.getText() + "' and `IdSuministroB`='" + this.xmodelo.getValueAt(y, 8) + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
                int y2 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de cerrar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y2 == 0) {
                    this.xsql = "update i_auditoria set EstadoC=1 where Id='" + Principal.txtNo.getText() + "'";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                    mBuscarDatosId(Principal.txtNo.getText());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JCBBodega.removeAllItems();
        this.xsql = "SELECT `i_bodegas`.`Id`, `i_bodegas`.`Nbre` FROM  `i_suministroxbodega` INNER JOIN  `i_suministro`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN  `i_bodegas`  ON (`i_suministroxbodega`.`IdBodega` = `i_bodegas`.`Id`) WHERE (`i_bodegas`.`Estado` =0) GROUP BY `i_bodegas`.`Id` ORDER BY `i_bodegas`.`Nbre` ASC ";
        this.xidbodega = this.xct.llenarCombo(this.xsql, this.xidbodega, this.JCBBodega);
        if (getName().equals("xjifauditoriaaleatoria")) {
            this.JCBBodega.setSelectedItem(Principal.xClaseInventario.getNbreBodega());
        } else {
            this.JCBBodega.setSelectedIndex(-1);
        }
        this.xct.cerrarConexionBd();
        this.xestadoc = 0;
        this.JSPNProductos.setValue(new Integer(0));
        this.JCHFValor.setSelected(false);
        this.JTFFVMinimo.setValue(new Double(0.0d));
        this.JTFFVMaximo.setValue(new Double(0.0d));
        mCrearTablaSuministro();
        mCrearTablaDetalleLote();
        mAccionBtActualizar();
        this.JCBBodega.requestFocus();
    }

    public void mBuscar() {
        JDBuscarInformacion xjdbuscar;
        Object[] botones = {"Auditoria", "Productos", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "BÚSQUEDA", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            if (getName().equals("xjifauditoriaaleatoria")) {
                xjdbuscar = new JDBuscarInformacion(Principal.xClaseInventario.frmPrincipal, true, getName(), this);
            } else {
                xjdbuscar = new JDBuscarInformacion(Principal.xclase.frmPrincipal, true, getName(), this);
            }
            xjdbuscar.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
            xjdbuscar.setVisible(true);
            return;
        }
        if (n == 1 && Principal.txtNo.getText().isEmpty()) {
            mCargarDatosTabla();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaSuministro() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Código Barra", "Nombre", "Cantidad", "V/Unitario", "C/Encontrada", "Observación", "Acción Realizada", "IdSBodega"}) { // from class: Inventarios.JIFAuditoriasProductos.4
            Class[] types = {Integer.class, String.class, String.class, Integer.class, Double.class, Integer.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false, false, true, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPProductos.setModel(this.xmodelo);
        this.JTPProductos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPProductos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPProductos.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTPProductos.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTPProductos.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTPProductos.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTPProductos.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTPProductos.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTPProductos.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTPProductos.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTPProductos.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTPProductos.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDetalleLote() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Lote", "FVencimiento", "Cantidad", "CPendiente"}) { // from class: Inventarios.JIFAuditoriasProductos.5
            Class[] types = {String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPDetalleP.setModel(this.xmodelo1);
        this.JTPDetalleP.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.JTPDetalleP.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTPDetalleP.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTPDetalleP.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearTablaSuministro();
            if (this.JCHFValor.isSelected()) {
                this.xsql = "WITH set_datos  AS (\nSELECT i_bodegas.Id AS idBodega, i_bodegas.Nbre nombreBodega, \n    i_suministro.Id AS idSuministro\n    , i_suministro.CodBarraUnidad\n    , i_suministro.CantidadUnidad\n    , i_suministro.Nbre AS NSuministro\n    , i_suministro.RegistroInvima  \n    , i_suministro.FechaVInvima  \n    , IFNULL(i_suministro.CodigoCUM,'') AS CodigoCUM \n    , IFNULL(i_suministro.CodigoAtc,'') AS CodigoAtc \n   , i_laboratorio.Nbre AS NLaboratorio\n    , i_suministroxlotexbodega.Lote\n    , i_suministroxlotexbodega.FechaVencimiento\n    , i_suministroxlotexbodega.Cantidad\n    , i_suministroxlotexbodega.CPendiente \n    ,it.Nbre tipoProducto\n    , ic.Nbre tipoCategoria\n     , i_clasificacion.Nbre AS NClasificacion\n    , ip.Nbre nombrePrincipioActivo\n    , ip2.Nbre nombrePresentacionComercial\n    , ip3.Nbre nombrePresentacionFarmaceutica\n    , IF(i_suministro.Pos=0,'NO POS','POS') AS clasificacion \n    , i_concentracion.Nbre  nombreConcentracion \n    , i_suministro.CodigoAgrupacion \n   ,i_suministroxbodega.Id idSuministroBodega\n\nFROM\n     i_suministroxbodega\n    INNER JOIN  i_suministro \n        ON (i_suministroxbodega.IdSuministro = i_suministro.Id)\n     INNER JOIN  i_suministroxlotexbodega \n         ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)\n    INNER JOIN  i_laboratorio \n        ON (i_suministro.IdLaboratorio = i_laboratorio.Id)\n    INNER JOIN  i_tipoproducto \n        ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)\n    INNER JOIN  i_bodegas \n        ON (i_suministroxbodega.IdBodega = i_bodegas.Id)        \n    INNER JOIN  i_concentracion \n        ON (i_suministro.idconcentracion = i_concentracion.Id) \n    INNER JOIN i_tipoproducto it  ON (it.Id=i_suministro.IdTipoProducto)   \n    INNER  JOIN i_categoria ic ON (ic.Id=i_suministro.IdCategoria)\n    INNER JOIN i_principioactivo ip ON (ip.Id=i_suministro.IdPrincipioActivo)\n    INNER JOIN i_presentacioncomercial ip2 ON (ip2.Id=i_suministro.IdPresentacionComercial)\n    INNER JOIN i_presentacionfarmaceutica ip3 ON (ip3.Id=i_suministro.IdPresentacionFarmaceutica)\n    INNER JOIN i_clasificacion\n        ON (i_suministro.IdClasificacion= i_clasificacion.Id)\n   WHERE  i_suministroxbodega.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'  \n   --  AND i_suministro.Id=1203\n   )\n      ,  set_salida AS (\n\tSELECT\n    i_detallesalida.IdSuministro\n    , i_detallesalida.Lote\n   -- , avg(i_detallesalida.ValorUnitario) as valor\n  -- ,i_detallesalida.ValorUnitario\n    , SUM(i_detallesalida.CantidadDespachada) AS CSalida\nFROM\n     i_detallesalida\n    INNER JOIN  i_salidas \n        ON (i_detallesalida.IdSalida = i_salidas.Id)\nWHERE (i_salidas.FechaSalida <='" + this.xmt.formatoAMD1.format(this.xmt.getFechaActual()) + "'\n    AND i_salidas.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'\n    AND i_salidas.Estado=0\n  --    AND i_detallesalida.IdSuministro=1203\n    )\nGROUP BY  i_detallesalida.IdSuministro\n  , i_detallesalida.Lote\n   ) \n      ,  set_entrada AS (\n\tSELECT\n    i_detalleentrada.IdSuministro\t\n    , i_detalleentrada.Lote\n    , SUM(i_detalleentrada.Cantidad) AS CEntrada\n    , i_entradas.IdBodega\n     ,SUM(i_detalleentrada.Cantidad*(i_detalleentrada.ValorUnitario+((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+i_detalleentrada.VFletesO-i_detalleentrada.VDescuento)) Valortotal\n    FROM\n     i_detalleentrada\n    INNER JOIN  i_entradas\n        ON (i_detalleentrada.IdEntrada = i_entradas.Id)\nWHERE (i_entradas.FechaEntrada <='" + this.xmt.formatoAMD1.format(this.xmt.getFechaActual()) + "'\n    AND i_entradas.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'\n    AND i_entradas.Estado=0 \n   --  AND i_detalleentrada.IdSuministro\t=1203\n    )\t\nGROUP BY  i_detalleentrada.IdSuministro\n   , i_detalleentrada.Lote\n   ) \n   , set_entrada_def AS (\nSELECT Idsuministro,\n Lote,\n CEntrada,\n IdBodega,\n (Valortotal/CEntrada) costo_lote ,\n SUM(Valortotal) over (PARTITION BY Idsuministro)/SUM(CEntrada) over (PARTITION BY Idsuministro) valorUnitario\nFROM set_entrada\n)   \n    SELECT \n    i.idSuministro\n    ,i.CodBarraUnidad\n    , CONCAT(i.NSuministro ,' ', i.nombrePresentacionComercial,' ', i.NLaboratorio) AS `NombreP` \n    , SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) Cantidad\n    , round(sum(DISTINCT ifnull(e.valorUnitario,0)))valorUnitario     \n    , i.idSuministroBodega\n    ,SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) totalInventario\n  FROM set_datos i\n    LEFT JOIN set_entrada_def e ON (e.IdSuministro=i.idSuministro)  AND (e.Lote=i.Lote)\n  LEFT  JOIN set_salida s ON (s.IdSuministro=i.idSuministro)  AND (s.Lote=i.Lote)\n  GROUP BY i.idSuministro\n    HAVING totalInventario>0 and valorUnitario BETWEEN " + this.JTFFVMinimo.getValue() + " and " + this.JTFFVMaximo.getValue() + "\n  ORDER BY RAND() LIMIT " + this.JSPNProductos.getValue() + "";
            } else {
                this.xsql = "WITH set_datos  AS (\nSELECT i_bodegas.Id AS idBodega, i_bodegas.Nbre nombreBodega, \n    i_suministro.Id AS idSuministro\n    , i_suministro.CodBarraUnidad\n    , i_suministro.CantidadUnidad\n    , i_suministro.Nbre AS NSuministro\n    , i_suministro.RegistroInvima  \n    , i_suministro.FechaVInvima  \n    , IFNULL(i_suministro.CodigoCUM,'') AS CodigoCUM \n    , IFNULL(i_suministro.CodigoAtc,'') AS CodigoAtc \n   , i_laboratorio.Nbre AS NLaboratorio\n    , i_suministroxlotexbodega.Lote\n    , i_suministroxlotexbodega.FechaVencimiento\n    , i_suministroxlotexbodega.Cantidad\n    , i_suministroxlotexbodega.CPendiente \n    ,it.Nbre tipoProducto\n    , ic.Nbre tipoCategoria\n     , i_clasificacion.Nbre AS NClasificacion\n    , ip.Nbre nombrePrincipioActivo\n    , ip2.Nbre nombrePresentacionComercial\n    , ip3.Nbre nombrePresentacionFarmaceutica\n    , IF(i_suministro.Pos=0,'NO POS','POS') AS clasificacion \n    , i_concentracion.Nbre  nombreConcentracion \n    , i_suministro.CodigoAgrupacion \n   ,i_suministroxbodega.Id idSuministroBodega\n\nFROM\n     i_suministroxbodega\n    INNER JOIN  i_suministro \n        ON (i_suministroxbodega.IdSuministro = i_suministro.Id)\n     INNER JOIN  i_suministroxlotexbodega \n         ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)\n    INNER JOIN  i_laboratorio \n        ON (i_suministro.IdLaboratorio = i_laboratorio.Id)\n    INNER JOIN  i_tipoproducto \n        ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)\n    INNER JOIN  i_bodegas \n        ON (i_suministroxbodega.IdBodega = i_bodegas.Id)        \n    INNER JOIN  i_concentracion \n        ON (i_suministro.idconcentracion = i_concentracion.Id) \n    INNER JOIN i_tipoproducto it  ON (it.Id=i_suministro.IdTipoProducto)   \n    INNER  JOIN i_categoria ic ON (ic.Id=i_suministro.IdCategoria)\n    INNER JOIN i_principioactivo ip ON (ip.Id=i_suministro.IdPrincipioActivo)\n    INNER JOIN i_presentacioncomercial ip2 ON (ip2.Id=i_suministro.IdPresentacionComercial)\n    INNER JOIN i_presentacionfarmaceutica ip3 ON (ip3.Id=i_suministro.IdPresentacionFarmaceutica)\n    INNER JOIN i_clasificacion\n        ON (i_suministro.IdClasificacion= i_clasificacion.Id)\n   WHERE  i_suministroxbodega.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'  \n   --  AND i_suministro.Id=1203\n   )\n      ,  set_salida AS (\n\tSELECT\n    i_detallesalida.IdSuministro\n    , i_detallesalida.Lote\n   -- , avg(i_detallesalida.ValorUnitario) as valor\n  -- ,i_detallesalida.ValorUnitario\n    , SUM(i_detallesalida.CantidadDespachada) AS CSalida\nFROM\n     i_detallesalida\n    INNER JOIN  i_salidas \n        ON (i_detallesalida.IdSalida = i_salidas.Id)\nWHERE (i_salidas.FechaSalida <='" + this.xmt.formatoAMD1.format(this.xmt.getFechaActual()) + "'\n    AND i_salidas.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'\n    AND i_salidas.Estado=0\n  --    AND i_detallesalida.IdSuministro=1203\n    )\nGROUP BY  i_detallesalida.IdSuministro\n  , i_detallesalida.Lote\n   ) \n      ,  set_entrada AS (\n\tSELECT\n    i_detalleentrada.IdSuministro\t\n    , i_detalleentrada.Lote\n    , SUM(i_detalleentrada.Cantidad) AS CEntrada\n    , i_entradas.IdBodega\n     ,SUM(i_detalleentrada.Cantidad*(i_detalleentrada.ValorUnitario+((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+i_detalleentrada.VFletesO-i_detalleentrada.VDescuento)) Valortotal\n    FROM\n     i_detalleentrada\n    INNER JOIN  i_entradas\n        ON (i_detalleentrada.IdEntrada = i_entradas.Id)\nWHERE (i_entradas.FechaEntrada <='" + this.xmt.formatoAMD1.format(this.xmt.getFechaActual()) + "'\n    AND i_entradas.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'\n    AND i_entradas.Estado=0 \n   --  AND i_detalleentrada.IdSuministro\t=1203\n    )\t\nGROUP BY  i_detalleentrada.IdSuministro\n   , i_detalleentrada.Lote\n   ) \n   , set_entrada_def AS (\nSELECT Idsuministro,\n Lote,\n CEntrada,\n IdBodega,\n (Valortotal/CEntrada) costo_lote ,\n SUM(Valortotal) over (PARTITION BY Idsuministro)/SUM(CEntrada) over (PARTITION BY Idsuministro) valorUnitario\nFROM set_entrada\n)   \n    SELECT \n    i.idSuministro\n    ,i.CodBarraUnidad\n    , CONCAT(i.NSuministro ,' ', i.nombrePresentacionComercial,' ', i.NLaboratorio) AS `NombreP` \n    , SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) Cantidad\n    , round(sum(DISTINCT ifnull(e.valorUnitario,0)))valorUnitario     \n    , i.idSuministroBodega\n    ,SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) totalInventario\n  FROM set_datos i\n    LEFT JOIN set_entrada_def e ON (e.IdSuministro=i.idSuministro)  AND (e.Lote=i.Lote)\n  LEFT  JOIN set_salida s ON (s.IdSuministro=i.idSuministro)  AND (s.Lote=i.Lote)\n  GROUP BY i.idSuministro\n    HAVING totalInventario>0  \n  ORDER BY RAND() LIMIT " + this.JSPNProductos.getValue() + "";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            this.xmt.mEstablecerTextEditor(this.JTPProductos, 2);
            this.xmt.mEstablecerTextEditor(this.JTPProductos, 6);
            this.xmt.mEstablecerTextEditor(this.JTPProductos, 7);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(5)), n, 4);
                    this.xmodelo.setValueAt(new Integer(0), n, 5);
                    this.xmodelo.setValueAt("", n, 6);
                    this.xmodelo.setValueAt("", n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(6)), n, 8);
                    n++;
                }
                mGrabar();
                mImprimir();
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriasProductos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscarDatosId(String xid) {
        try {
            mCrearTablaSuministro();
            this.xsql = "SELECT `i_auditoria`.`Id`, `i_auditoria`.`FechaAuditoria`, `i_bodegas`.`Nbre`, `i_auditoria`.`VrMinimo`, `i_auditoria`.`VrMaximo`, `i_auditoria`.`Cantidad`, `i_suministroxbodega`.`Id`, `i_suministro`.`CodBarraUnidad` , CONCAT(`i_suministro`.`Nbre`,' ', `i_presentacioncomercial`.`Nbre`,' ', `i_laboratorio`.`Nbre`) AS `NombreP`, `i_detalleauditoria`.`CantidadInventario`, `i_detalleauditoria`.`Valor`, `i_detalleauditoria`.`CantidadFisica`, `i_detalleauditoria`.`Explicacion`, `i_detalleauditoria`.`Accion`, `i_detalleauditoria`.`IdSuministroB`, `i_auditoria`.`EstadoC` FROM `i_detalleauditoria` INNER JOIN  `i_suministroxbodega`  ON (`i_detalleauditoria`.`IdSuministroB` = `i_suministroxbodega`.`Id`) INNER JOIN  `i_auditoria`  ON (`i_detalleauditoria`.`Id` = `i_auditoria`.`Id`) INNER JOIN  `i_suministro`  ON (`i_suministroxbodega`.`IdSuministro` = `i_suministro`.`Id`) INNER JOIN  `i_bodegas`  ON (`i_auditoria`.`IdBodega` = `i_bodegas`.`Id`) INNER JOIN  `i_presentacioncomercial`  ON (`i_suministro`.`IdPresentacionComercial` = `i_presentacioncomercial`.`Id`) INNER JOIN  `i_laboratorio`  ON (`i_suministro`.`IdLaboratorio` = `i_laboratorio`.`Id`) WHERE (`i_auditoria`.`Id` ='" + xid + "') ORDER BY `NombreP` ASC ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            this.xmt.mEstablecerTextEditor(this.JTPProductos, 2);
            this.xmt.mEstablecerTextEditor(this.JTPProductos, 6);
            this.xmt.mEstablecerTextEditor(this.JTPProductos, 7);
            if (xrs.next()) {
                xrs.first();
                Principal.txtNo.setText(xrs.getString(1));
                Principal.txtFecha.setText(xrs.getString(2));
                this.JCBBodega.setSelectedItem(xrs.getString(3));
                this.JTFFVMinimo.setValue(Double.valueOf(xrs.getDouble(4)));
                this.JTFFVMaximo.setValue(Double.valueOf(xrs.getDouble(5)));
                this.JSPNProductos.setValue(Long.valueOf(xrs.getLong(6)));
                this.xestadoc = xrs.getInt(16);
                mAccionBtActualizar();
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdato);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(9), n, 2);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(10)), n, 3);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(11)), n, 4);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(12)), n, 5);
                    this.xmodelo.setValueAt(xrs.getString(13), n, 6);
                    this.xmodelo.setValueAt(xrs.getString(14), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(15)), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriasProductos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosTablaLotes() {
        try {
            mCrearTablaDetalleLote();
            this.xsql = "WITH set_datos  AS (\nSELECT i_bodegas.Id AS idBodega, i_bodegas.Nbre nombreBodega, \n    i_suministro.Id AS idSuministro\n    , i_suministro.CodBarraUnidad\n    , i_suministro.CantidadUnidad\n    , i_suministro.Nbre AS NSuministro\n    , i_suministro.RegistroInvima  \n    , i_suministro.FechaVInvima  \n    , IFNULL(i_suministro.CodigoCUM,'') AS CodigoCUM \n    , IFNULL(i_suministro.CodigoAtc,'') AS CodigoAtc \n   , i_laboratorio.Nbre AS NLaboratorio\n    , i_suministroxlotexbodega.Lote\n    , i_suministroxlotexbodega.FechaVencimiento\n    , i_suministroxlotexbodega.Cantidad\n    , i_suministroxlotexbodega.CPendiente \n    ,it.Nbre tipoProducto\n    , ic.Nbre tipoCategoria\n     , i_clasificacion.Nbre AS NClasificacion\n    , ip.Nbre nombrePrincipioActivo\n    , ip2.Nbre nombrePresentacionComercial\n    , ip3.Nbre nombrePresentacionFarmaceutica\n    , IF(i_suministro.Pos=0,'NO POS','POS') AS clasificacion \n    , i_concentracion.Nbre  nombreConcentracion \n    , i_suministro.CodigoAgrupacion \n   ,i_suministroxbodega.Id idSuministroBodega\n\nFROM\n     i_suministroxbodega\n    INNER JOIN  i_suministro \n        ON (i_suministroxbodega.IdSuministro = i_suministro.Id)\n     INNER JOIN  i_suministroxlotexbodega \n         ON (i_suministroxlotexbodega.Id = i_suministroxbodega.Id)\n    INNER JOIN  i_laboratorio \n        ON (i_suministro.IdLaboratorio = i_laboratorio.Id)\n    INNER JOIN  i_tipoproducto \n        ON (i_suministro.IdTipoProducto = i_tipoproducto.Id)\n    INNER JOIN  i_bodegas \n        ON (i_suministroxbodega.IdBodega = i_bodegas.Id)        \n    INNER JOIN  i_concentracion \n        ON (i_suministro.idconcentracion = i_concentracion.Id) \n    INNER JOIN i_tipoproducto it  ON (it.Id=i_suministro.IdTipoProducto)   \n    INNER  JOIN i_categoria ic ON (ic.Id=i_suministro.IdCategoria)\n    INNER JOIN i_principioactivo ip ON (ip.Id=i_suministro.IdPrincipioActivo)\n    INNER JOIN i_presentacioncomercial ip2 ON (ip2.Id=i_suministro.IdPresentacionComercial)\n    INNER JOIN i_presentacionfarmaceutica ip3 ON (ip3.Id=i_suministro.IdPresentacionFarmaceutica)\n    INNER JOIN i_clasificacion\n        ON (i_suministro.IdClasificacion= i_clasificacion.Id)\n   WHERE  i_suministroxbodega.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'  \n   --  AND i_suministro.Id=1203\n   )\n      ,  set_salida AS (\n\tSELECT\n    i_detallesalida.IdSuministro\n    , i_detallesalida.Lote\n   -- , avg(i_detallesalida.ValorUnitario) as valor\n  -- ,i_detallesalida.ValorUnitario\n    , SUM(i_detallesalida.CantidadDespachada) AS CSalida\nFROM\n     i_detallesalida\n    INNER JOIN  i_salidas \n        ON (i_detallesalida.IdSalida = i_salidas.Id)\nWHERE (i_salidas.FechaSalida <='" + this.xmt.formatoAMD1.format(this.xmt.getFechaActual()) + "'\n    AND i_salidas.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'\n    AND i_salidas.Estado=0\n  --    AND i_detallesalida.IdSuministro=1203\n    )\nGROUP BY  i_detallesalida.IdSuministro\n  , i_detallesalida.Lote\n   ) \n      ,  set_entrada AS (\n\tSELECT\n    i_detalleentrada.IdSuministro\t\n    , i_detalleentrada.Lote\n    , SUM(i_detalleentrada.Cantidad) AS CEntrada\n    , i_entradas.IdBodega\n     ,SUM(i_detalleentrada.Cantidad*(i_detalleentrada.ValorUnitario+((i_detalleentrada.ValorUnitario*i_detalleentrada.Iva)/100)+i_detalleentrada.VFletesO-i_detalleentrada.VDescuento)) Valortotal\n    FROM\n     i_detalleentrada\n    INNER JOIN  i_entradas\n        ON (i_detalleentrada.IdEntrada = i_entradas.Id)\nWHERE (i_entradas.FechaEntrada <='" + this.xmt.formatoAMD1.format(this.xmt.getFechaActual()) + "'\n    AND i_entradas.IdBodega='" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "'\n    AND i_entradas.Estado=0 \n   --  AND i_detalleentrada.IdSuministro\t=1203\n    )\t\nGROUP BY  i_detalleentrada.IdSuministro\n   , i_detalleentrada.Lote\n   ) \n   , set_entrada_def AS (\nSELECT Idsuministro,\n Lote,\n CEntrada,\n IdBodega,\n (Valortotal/CEntrada) costo_lote ,\n SUM(Valortotal) over (PARTITION BY Idsuministro)/SUM(CEntrada) over (PARTITION BY Idsuministro) valorUnitario\nFROM set_entrada\n)   \n    SELECT \n    i.Lote\n    , i.FechaVencimiento\n    , SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) Cantidad\n    , i.CPendiente\n\n    , round(sum(DISTINCT ifnull(e.valorUnitario,0)))valorUnitario     \n    , i.idSuministroBodega\n    ,SUM(IFNULL(e.CEntrada,0)-IFNULL(s.CSalida,0)) totalInventario\n  FROM set_datos i\n    LEFT JOIN set_entrada_def e ON (e.IdSuministro=i.idSuministro)  AND (e.Lote=i.Lote)\n  LEFT  JOIN set_salida s ON (s.IdSuministro=i.idSuministro)  AND (s.Lote=i.Lote)\n  where i.idSuministroBodega ='" + this.xmodelo.getValueAt(this.JTPProductos.getSelectedRow(), 8) + "'\n  GROUP BY i.idSuministro, lote\n  HAVING totalInventario<>0\n  ORDER BY FechaVencimiento asc\n";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdato);
                    this.xmodelo1.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo1.setValueAt(Integer.valueOf(xrs.getInt(3)), n, 2);
                    this.xmodelo1.setValueAt(Integer.valueOf(xrs.getInt(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAuditoriasProductos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabar() {
        if (this.JTPProductos.getRowCount() != -1) {
            this.xsql = "insert into i_auditoria (`FechaAuditoria`, `IdBodega`, `VrMinimo`, `VrMaximo`, `Cantidad`, `Fecha`, `UsuarioS`)  values('" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xidbodega[this.JCBBodega.getSelectedIndex()] + "','" + this.JTFFVMinimo.getValue() + "','" + this.JTFFVMaximo.getValue() + "','" + this.JSPNProductos.getValue() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            Principal.txtNo.setText(this.xct.ejecutarSQLId(this.xsql));
            this.xct.cerrarConexionBd();
            for (int x = 0; x < this.JTPProductos.getRowCount(); x++) {
                this.xsql = "insert into i_detalleauditoria (`Id`, `IdSuministroB`, `CantidadInventario`, `Responsable`, `Cargo`, `Valor`)  values('" + Principal.txtNo.getText() + "','" + this.xmodelo.getValueAt(x, 8) + "','" + this.xmodelo.getValueAt(x, 3) + "','" + Principal.usuarioSistemaDTO.getNombreUsuario() + "','" + Principal.usuarioSistemaDTO.getNombreCargoUsuario() + "','" + this.xmodelo.getValueAt(x, 4) + "')";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
            }
        }
    }

    public void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "Id";
        mparametros[0][1] = Principal.txtNo.getText();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
        if (Principal.informacionIps.getEsFpz().intValue() == 0) {
            if (this.xestadoc == 0) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_InformeAuditoria", mparametros);
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_InformeAuditoria_1", mparametros);
                return;
            }
        }
        this.xmt.GenerarPDF(this.xmt.getRutaRep() + "I_InformeAuditoria", mparametros);
    }

    private void mAccionBtActualizar() {
        if (this.xestadoc == 0) {
            this.JBTActualizar.setEnabled(true);
        } else {
            this.JBTActualizar.setEnabled(false);
        }
    }
}
