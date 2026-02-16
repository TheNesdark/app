package com.genoma.plus.controller.inventario;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.TipoProductoDTO;
import com.genoma.plus.jpa.projection.IBodegaDTO;
import com.genoma.plus.jpa.projection.IDetalleGestionCompraInventarioDTO;
import com.genoma.plus.jpa.service.IBodegaDAO;
import com.genoma.plus.jpa.service.ITipoProductoDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIF_GestionInventarioCompras.class */
public class JIF_GestionInventarioCompras extends JInternalFrame {
    private DefaultTableModel modelo;
    private String[][] idBodega;
    private List<TipoProductoDTO> listaIdTipoProducto;
    private List<IDetalleGestionCompraInventarioDTO> gestionCompraInventarioDTOs;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JButton JBTOrdenCompra;
    private JComboBox JCBBodega;
    private JComboBox JCBTipoProducto;
    private JCheckBox JCH_AplicaDivision;
    private JCheckBox JCH_Filtro;
    private JCheckBox JCH_Negativo;
    private JCheckBox JCH_Positivo;
    private JCheckBox JCH_Seleccionar;
    private JCheckBox JCH_Todos;
    private JDateChooser JDFechaC;
    private JDateChooser JDFechaFinal;
    private JDateChooser JDFechaInicial;
    private JLabel JLB_NRegistro;
    private JPanel JPI_InformacionFiltro;
    private JPanel JPI_Utilidades;
    private JPanel JP_FIltroEstado;
    private JPanel JP_FechasConsumo;
    private JScrollPane JSPDetalle;
    private JSpinner JSP_PoliticaC;
    private JSpinner JSP_TiempoR;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JPanel jPanel1;
    private Metodos metodo = new Metodos();
    private final IBodegaDAO bodegaDAO = (IBodegaDAO) Principal.contexto.getBean(IBodegaDAO.class);
    private final ITipoProductoDAO tipoProductoDAO = (ITipoProductoDAO) Principal.contexto.getBean(ITipoProductoDAO.class);
    private Boolean lleno = false;

    @Generated
    public void setMetodo(Metodos metodo) {
        this.metodo = metodo;
    }

    @Generated
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    @Generated
    public void setIdBodega(String[][] idBodega) {
        this.idBodega = idBodega;
    }

    @Generated
    public void setListaIdTipoProducto(List<TipoProductoDTO> listaIdTipoProducto) {
        this.listaIdTipoProducto = listaIdTipoProducto;
    }

    @Generated
    public void setGestionCompraInventarioDTOs(List<IDetalleGestionCompraInventarioDTO> gestionCompraInventarioDTOs) {
        this.gestionCompraInventarioDTOs = gestionCompraInventarioDTOs;
    }

    @Generated
    public void setLleno(Boolean lleno) {
        this.lleno = lleno;
    }

    @Generated
    public void setJBG_Filtro(ButtonGroup JBG_Filtro) {
        this.JBG_Filtro = JBG_Filtro;
    }

    @Generated
    public void setJBTExportar(JButton JBTExportar) {
        this.JBTExportar = JBTExportar;
    }

    @Generated
    public void setJBTOrdenCompra(JButton JBTOrdenCompra) {
        this.JBTOrdenCompra = JBTOrdenCompra;
    }

    @Generated
    public void setJCBBodega(JComboBox JCBBodega) {
        this.JCBBodega = JCBBodega;
    }

    @Generated
    public void setJCBTipoProducto(JComboBox JCBTipoProducto) {
        this.JCBTipoProducto = JCBTipoProducto;
    }

    @Generated
    public void setJCH_AplicaDivision(JCheckBox JCH_AplicaDivision) {
        this.JCH_AplicaDivision = JCH_AplicaDivision;
    }

    @Generated
    public void setJCH_Filtro(JCheckBox JCH_Filtro) {
        this.JCH_Filtro = JCH_Filtro;
    }

    @Generated
    public void setJCH_Negativo(JCheckBox JCH_Negativo) {
        this.JCH_Negativo = JCH_Negativo;
    }

    @Generated
    public void setJCH_Positivo(JCheckBox JCH_Positivo) {
        this.JCH_Positivo = JCH_Positivo;
    }

    @Generated
    public void setJCH_Seleccionar(JCheckBox JCH_Seleccionar) {
        this.JCH_Seleccionar = JCH_Seleccionar;
    }

    @Generated
    public void setJCH_Todos(JCheckBox JCH_Todos) {
        this.JCH_Todos = JCH_Todos;
    }

    @Generated
    public void setJDFechaC(JDateChooser JDFechaC) {
        this.JDFechaC = JDFechaC;
    }

    @Generated
    public void setJDFechaFinal(JDateChooser JDFechaFinal) {
        this.JDFechaFinal = JDFechaFinal;
    }

    @Generated
    public void setJDFechaInicial(JDateChooser JDFechaInicial) {
        this.JDFechaInicial = JDFechaInicial;
    }

    @Generated
    public void setJLB_NRegistro(JLabel JLB_NRegistro) {
        this.JLB_NRegistro = JLB_NRegistro;
    }

    @Generated
    public void setJPI_InformacionFiltro(JPanel JPI_InformacionFiltro) {
        this.JPI_InformacionFiltro = JPI_InformacionFiltro;
    }

    @Generated
    public void setJPI_Utilidades(JPanel JPI_Utilidades) {
        this.JPI_Utilidades = JPI_Utilidades;
    }

    @Generated
    public void setJP_FIltroEstado(JPanel JP_FIltroEstado) {
        this.JP_FIltroEstado = JP_FIltroEstado;
    }

    @Generated
    public void setJP_FechasConsumo(JPanel JP_FechasConsumo) {
        this.JP_FechasConsumo = JP_FechasConsumo;
    }

    @Generated
    public void setJSPDetalle(JScrollPane JSPDetalle) {
        this.JSPDetalle = JSPDetalle;
    }

    @Generated
    public void setJSP_PoliticaC(JSpinner JSP_PoliticaC) {
        this.JSP_PoliticaC = JSP_PoliticaC;
    }

    @Generated
    public void setJSP_TiempoR(JSpinner JSP_TiempoR) {
        this.JSP_TiempoR = JSP_TiempoR;
    }

    @Generated
    public void setJTDetalle(JTable JTDetalle) {
        this.JTDetalle = JTDetalle;
    }

    @Generated
    public void setJTFRuta(JTextField JTFRuta) {
        this.JTFRuta = JTFRuta;
    }

    @Generated
    public void setJCheckBox1(JCheckBox jCheckBox1) {
        this.jCheckBox1 = jCheckBox1;
    }

    @Generated
    public void setJCheckBox2(JCheckBox jCheckBox2) {
        this.jCheckBox2 = jCheckBox2;
    }

    @Generated
    public void setJCheckBox3(JCheckBox jCheckBox3) {
        this.jCheckBox3 = jCheckBox3;
    }

    @Generated
    public void setJCheckBox4(JCheckBox jCheckBox4) {
        this.jCheckBox4 = jCheckBox4;
    }

    @Generated
    public void setJPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    @Generated
    public Metodos getMetodo() {
        return this.metodo;
    }

    @Generated
    public DefaultTableModel getModelo() {
        return this.modelo;
    }

    @Generated
    public IBodegaDAO getBodegaDAO() {
        return this.bodegaDAO;
    }

    @Generated
    public ITipoProductoDAO getTipoProductoDAO() {
        return this.tipoProductoDAO;
    }

    @Generated
    public String[][] getIdBodega() {
        return this.idBodega;
    }

    @Generated
    public List<TipoProductoDTO> getListaIdTipoProducto() {
        return this.listaIdTipoProducto;
    }

    @Generated
    public List<IDetalleGestionCompraInventarioDTO> getGestionCompraInventarioDTOs() {
        return this.gestionCompraInventarioDTOs;
    }

    @Generated
    public Boolean getLleno() {
        return this.lleno;
    }

    public JIF_GestionInventarioCompras() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v69, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_InformacionFiltro = new JPanel();
        this.JDFechaC = new JDateChooser();
        this.JCBBodega = new JComboBox();
        this.JSP_TiempoR = new JSpinner();
        this.JSP_PoliticaC = new JSpinner();
        this.JP_FechasConsumo = new JPanel();
        this.JDFechaInicial = new JDateChooser();
        this.JDFechaFinal = new JDateChooser();
        this.JP_FIltroEstado = new JPanel();
        this.JCH_Todos = new JCheckBox();
        this.JCH_Positivo = new JCheckBox();
        this.JCH_Negativo = new JCheckBox();
        this.JCH_Seleccionar = new JCheckBox();
        this.JCBTipoProducto = new JComboBox();
        this.JCH_Filtro = new JCheckBox();
        this.JCH_AplicaDivision = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPI_Utilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JBTOrdenCompra = new JButton();
        this.JLB_NRegistro = new JLabel();
        this.jPanel1 = new JPanel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.jCheckBox3 = new JCheckBox();
        this.jCheckBox4 = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE INVENTARIO (COMPRAS)");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_gestion_inventario");
        this.JPI_InformacionFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN PARA FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JDFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Corte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setFont(new Font("Arial", 1, 12));
        this.JCBBodega.setBorder(BorderFactory.createTitledBorder((Border) null, "Bodega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBBodega.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras.1
            public void itemStateChanged(ItemEvent evt) {
                JIF_GestionInventarioCompras.this.JCBBodegaItemStateChanged(evt);
            }
        });
        this.JSP_TiempoR.setFont(new Font("Arial", 1, 12));
        this.JSP_TiempoR.setModel(new SpinnerNumberModel());
        this.JSP_TiempoR.setToolTipText("Tiempo de Reposición en Días");
        this.JSP_TiempoR.setBorder(BorderFactory.createTitledBorder((Border) null, "TiempoR(Días)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_PoliticaC.setFont(new Font("Arial", 1, 12));
        this.JSP_PoliticaC.setModel(new SpinnerNumberModel());
        this.JSP_PoliticaC.setToolTipText("Politica de Compras en Días");
        this.JSP_PoliticaC.setBorder(BorderFactory.createTitledBorder((Border) null, "PoliticaC(Días)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JP_FechasConsumo.setBorder(BorderFactory.createTitledBorder((Border) null, "Fechas para consultar consumo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JDFechaInicial.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaInicial.setDateFormatString("dd/MM/yyyy");
        this.JDFechaInicial.setFont(new Font("Arial", 1, 12));
        this.JDFechaFinal.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaFinal.setDateFormatString("dd/MM/yyyy");
        this.JDFechaFinal.setFont(new Font("Arial", 1, 12));
        GroupLayout JP_FechasConsumoLayout = new GroupLayout(this.JP_FechasConsumo);
        this.JP_FechasConsumo.setLayout(JP_FechasConsumoLayout);
        JP_FechasConsumoLayout.setHorizontalGroup(JP_FechasConsumoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FechasConsumoLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaInicial, -2, 136, -2).addGap(18, 18, 18).addComponent(this.JDFechaFinal, -2, 136, -2).addContainerGap(-1, 32767)));
        JP_FechasConsumoLayout.setVerticalGroup(JP_FechasConsumoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FechasConsumoLayout.createSequentialGroup().addContainerGap().addGroup(JP_FechasConsumoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaFinal, -2, 50, -2).addComponent(this.JDFechaInicial, -2, 50, -2)).addContainerGap(8, 32767)));
        this.JP_FIltroEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro cantidad a pedir", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBG_Filtro.add(this.JCH_Todos);
        this.JCH_Todos.setFont(new Font("Arial", 1, 12));
        this.JCH_Todos.setSelected(true);
        this.JCH_Todos.setText("Todos");
        this.JBG_Filtro.add(this.JCH_Positivo);
        this.JCH_Positivo.setFont(new Font("Arial", 1, 12));
        this.JCH_Positivo.setText("Positivos");
        this.JBG_Filtro.add(this.JCH_Negativo);
        this.JCH_Negativo.setFont(new Font("Arial", 1, 12));
        this.JCH_Negativo.setText("Negativo");
        GroupLayout JP_FIltroEstadoLayout = new GroupLayout(this.JP_FIltroEstado);
        this.JP_FIltroEstado.setLayout(JP_FIltroEstadoLayout);
        JP_FIltroEstadoLayout.setHorizontalGroup(JP_FIltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FIltroEstadoLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_Todos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Positivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Negativo).addContainerGap(-1, 32767)));
        JP_FIltroEstadoLayout.setVerticalGroup(JP_FIltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JP_FIltroEstadoLayout.createSequentialGroup().addContainerGap().addGroup(JP_FIltroEstadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCH_Todos).addComponent(this.JCH_Positivo).addComponent(this.JCH_Negativo)).addContainerGap(8, 32767)));
        this.JCH_Seleccionar.setFont(new Font("Arial", 1, 12));
        this.JCH_Seleccionar.setText("Seleccionar/quitar");
        this.JCH_Seleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras.2
            public void actionPerformed(ActionEvent evt) {
                JIF_GestionInventarioCompras.this.JCH_SeleccionarActionPerformed(evt);
            }
        });
        this.JCBTipoProducto.setFont(new Font("Arial", 1, 12));
        this.JCBTipoProducto.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Producto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Filtro.setFont(new Font("Arial", 1, 12));
        this.JCH_Filtro.setText("Filtro");
        this.JCH_AplicaDivision.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaDivision.setText("Aplica división U/E");
        this.JCH_AplicaDivision.setToolTipText("Aplica división por unidad de empaque y  redondeo");
        this.JCH_AplicaDivision.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras.3
            public void actionPerformed(ActionEvent evt) {
                JIF_GestionInventarioCompras.this.JCH_AplicaDivisionActionPerformed(evt);
            }
        });
        GroupLayout JPI_InformacionFiltroLayout = new GroupLayout(this.JPI_InformacionFiltro);
        this.JPI_InformacionFiltro.setLayout(JPI_InformacionFiltroLayout);
        JPI_InformacionFiltroLayout.setHorizontalGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addComponent(this.JDFechaC, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBBodega, -2, 353, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoProducto, -2, 254, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCH_Filtro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.JSP_TiempoR, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JSP_PoliticaC, -2, 109, -2)).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addComponent(this.JP_FechasConsumo, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JP_FIltroEstado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_Seleccionar, GroupLayout.Alignment.TRAILING).addComponent(this.JCH_AplicaDivision, GroupLayout.Alignment.TRAILING)))).addGap(29, 29, 29)));
        JPI_InformacionFiltroLayout.setVerticalGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBBodega, -2, 50, -2).addComponent(this.JSP_TiempoR, -2, 50, -2).addComponent(this.JSP_PoliticaC, -2, 50, -2).addComponent(this.JCBTipoProducto, -2, 50, -2)).addComponent(this.JDFechaC, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_InformacionFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JP_FIltroEstado, GroupLayout.Alignment.TRAILING, -2, -1, -2).addComponent(this.JP_FechasConsumo, GroupLayout.Alignment.TRAILING, -2, -1, -2))).addGroup(JPI_InformacionFiltroLayout.createSequentialGroup().addGap(41, 41, 41).addComponent(this.JCH_Filtro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_AplicaDivision).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_Seleccionar))).addContainerGap(16, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras.4
            public void mouseClicked(MouseEvent evt) {
                JIF_GestionInventarioCompras.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPI_Utilidades.setBorder(BorderFactory.createTitledBorder((Border) null, "UTILIDADES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras.5
            public void mouseClicked(MouseEvent evt) {
                JIF_GestionInventarioCompras.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras.6
            public void actionPerformed(ActionEvent evt) {
                JIF_GestionInventarioCompras.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBTOrdenCompra.setFont(new Font("Arial", 1, 12));
        this.JBTOrdenCompra.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Compras29x27.png")));
        this.JBTOrdenCompra.setText("<html><P ALIGN=center>Generar Orden de Compra");
        this.JBTOrdenCompra.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras.7
            public void actionPerformed(ActionEvent evt) {
                JIF_GestionInventarioCompras.this.JBTOrdenCompraActionPerformed(evt);
            }
        });
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 14));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Convensiones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jCheckBox1.setBackground(new Color(255, 255, 255));
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setText("Con existencia");
        this.jCheckBox1.setOpaque(true);
        this.jCheckBox2.setBackground(Color.yellow);
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setText("Por debajo del punto");
        this.jCheckBox2.setOpaque(true);
        this.jCheckBox3.setBackground(Color.green);
        this.jCheckBox3.setFont(new Font("Arial", 1, 12));
        this.jCheckBox3.setText("Por debajo del máximo");
        this.jCheckBox3.setOpaque(true);
        this.jCheckBox4.setBackground(Color.red);
        this.jCheckBox4.setFont(new Font("Arial", 1, 12));
        this.jCheckBox4.setText("Sin existencia");
        this.jCheckBox4.setOpaque(true);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jCheckBox1, -1, -1, 32767).addComponent(this.jCheckBox4, -1, -1, 32767)).addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jCheckBox3, -1, -1, 32767).addComponent(this.jCheckBox2, -1, -1, 32767)).addContainerGap(11, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox3).addComponent(this.jCheckBox4)).addContainerGap(-1, 32767)));
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 322, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTOrdenCompra, -2, 134, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_NRegistro, -2, 138, -2).addGap(12, 12, 12)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta).addComponent(this.JBTExportar, -1, -1, 32767).addComponent(this.JBTOrdenCompra, -2, 50, -2)).addComponent(this.JLB_NRegistro, -2, 50, -2).addComponent(this.jPanel1, -2, -1, -2)).addGap(0, 14, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Utilidades, -1, -1, 32767).addComponent(this.JPI_InformacionFiltro, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_InformacionFiltro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 301, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Utilidades, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBBodegaItemStateChanged(ItemEvent evt) {
        if (this.JCBBodega.getSelectedIndex() != -1 && getLleno().booleanValue()) {
            this.JSP_TiempoR.setValue(Integer.valueOf(this.idBodega[this.JCBBodega.getSelectedIndex()][2]));
            this.JSP_PoliticaC.setValue(Integer.valueOf(this.idBodega[this.JCBBodega.getSelectedIndex()][3]));
            llenarComboTipoProducto();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + getMetodo().getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                getMetodo().mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SeleccionarActionPerformed(ActionEvent evt) {
        seleccionarDeseleccionar(Boolean.valueOf(this.JCH_Seleccionar.isSelected()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOrdenCompraActionPerformed(ActionEvent evt) {
        Principal.xClaseInventario.cargarPantalla("jifcompras3", this.JTDetalle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.JTDetalle.getSelectedColumn() == 6) {
            System.out.println("" + this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_AplicaDivisionActionPerformed(ActionEvent evt) {
    }

    private void seleccionarDeseleccionar(Boolean estado) {
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            this.modelo.setValueAt(estado, i, 6);
        }
    }

    private void nuevo() {
        setLleno(false);
        this.JDFechaC.setDate(getMetodo().getFechaActual());
        this.JDFechaInicial.setDate(getMetodo().getFechaActual());
        this.JDFechaFinal.setDate(getMetodo().getFechaActual());
        this.JSP_PoliticaC.setValue(new Integer(0));
        this.JSP_TiempoR.setValue(new Integer(0));
        this.JTFRuta.setText(getMetodo().getDirectorioExportacion() + "Planilla");
        llenarCombo();
        setLleno(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void creaModeloTabla() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre Suministro", "Principio Activo", "Laboratorio", "Presentación Farmaceutica", "Tipo Producto", "Seleccionar", "CantidadPedir", "MesesConsumo", "Cantidad", "C/Salidas", "C/Entradas", "Existencia", "C/PromedioMensual", "factorReposición", "Mínimo", "Punto Reposición", "Máximo", "UnidadEmpaque", "% Iva", "Estado Reposición"}) { // from class: com.genoma.plus.controller.inventario.JIF_GestionInventarioCompras.8
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Double.class, Integer.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Integer.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(20).setPreferredWidth(200);
    }

    private void llenarCombo() {
        this.JCBBodega.removeAllItems();
        List<IBodegaDTO> list = getBodegaDAO().listadoBodega();
        this.idBodega = new String[list.size()][4];
        for (int x = 0; x < list.size(); x++) {
            this.idBodega[x][0] = String.valueOf(list.get(x).getId());
            this.idBodega[x][1] = String.valueOf(list.get(x).getNombre());
            this.idBodega[x][2] = String.valueOf(list.get(x).getTiempoReposicion());
            this.idBodega[x][3] = String.valueOf(list.get(x).getPoliticaCompras());
            this.JCBBodega.addItem(list.get(x).getNombre());
        }
        this.JCBBodega.setSelectedIndex(-1);
    }

    private void llenarComboTipoProducto() {
        this.JCBTipoProducto.removeAllItems();
        this.listaIdTipoProducto = getTipoProductoDAO().listadoTipoProductoSuministro(Integer.valueOf(this.idBodega[this.JCBBodega.getSelectedIndex()][0]));
        for (int x = 0; x < this.listaIdTipoProducto.size(); x++) {
            this.JCBTipoProducto.addItem(this.listaIdTipoProducto.get(x).getNombre());
        }
        this.JCBTipoProducto.setSelectedIndex(-1);
    }

    private void cargarDatos() {
        creaModeloTabla();
        if (this.JCH_Filtro.isSelected()) {
            if (this.JCBTipoProducto.getSelectedIndex() != -1 && this.JCBBodega.getSelectedIndex() != -1) {
                this.gestionCompraInventarioDTOs = getBodegaDAO().listadoDetalleGestionCompraIventarioIdTipoProducto(getMetodo().formatoAMD1.format(this.JDFechaInicial.getDate()), getMetodo().formatoAMD1.format(this.JDFechaFinal.getDate()), getMetodo().formatoAMD1.format(this.JDFechaC.getDate()), Integer.valueOf(getIdBodega()[this.JCBBodega.getSelectedIndex()][0]), Integer.valueOf(this.JSP_TiempoR.getValue().toString()), Integer.valueOf(this.JSP_PoliticaC.getValue().toString()), Integer.valueOf(this.listaIdTipoProducto.get(this.JCBTipoProducto.getSelectedIndex()).getId().toString()), Boolean.valueOf(this.JCH_AplicaDivision.isSelected()));
                cargarDatosTable();
                return;
            }
            return;
        }
        if (this.JCBBodega.getSelectedIndex() != -1) {
            this.gestionCompraInventarioDTOs = getBodegaDAO().listadoDetalleGestionCompraIventario(getMetodo().formatoAMD1.format(this.JDFechaInicial.getDate()), getMetodo().formatoAMD1.format(this.JDFechaFinal.getDate()), getMetodo().formatoAMD1.format(this.JDFechaC.getDate()), Integer.valueOf(getIdBodega()[this.JCBBodega.getSelectedIndex()][0]), Integer.valueOf(this.JSP_TiempoR.getValue().toString()), Integer.valueOf(this.JSP_PoliticaC.getValue().toString()), Boolean.valueOf(this.JCH_AplicaDivision.isSelected()));
            cargarDatosTable();
        }
    }

    private void cargarDatosTable() {
        if (!getGestionCompraInventarioDTOs().isEmpty()) {
            int fila = 0;
            for (IDetalleGestionCompraInventarioDTO next : this.gestionCompraInventarioDTOs) {
                if (this.JCH_Todos.isSelected()) {
                    this.modelo.addRow((Object[]) null);
                    this.modelo.setValueAt(next.getId(), fila, 0);
                    this.modelo.setValueAt(next.getSuministro(), fila, 1);
                    this.modelo.setValueAt(next.getPrincipioActivo(), fila, 2);
                    this.modelo.setValueAt(next.getLaboratorio(), fila, 3);
                    this.modelo.setValueAt(next.getPresentacionFarmaceutica(), fila, 4);
                    this.modelo.setValueAt(next.getTipoProducto(), fila, 5);
                    this.modelo.setValueAt(false, fila, 6);
                    this.modelo.setValueAt(next.getCantidadPedir(), fila, 7);
                    this.modelo.setValueAt(next.getNumeroMeses(), fila, 8);
                    this.modelo.setValueAt(next.getConsumo(), fila, 9);
                    this.modelo.setValueAt(next.getSalidaCorte(), fila, 10);
                    this.modelo.setValueAt(next.getEntradaCorte(), fila, 11);
                    this.modelo.setValueAt(next.getExistenciaActual(), fila, 12);
                    this.modelo.setValueAt(next.getConsumoPromedioMensual(), fila, 13);
                    this.modelo.setValueAt(next.getFactorTiempoReposicion(), fila, 14);
                    this.modelo.setValueAt(next.getNivelMinimo(), fila, 15);
                    this.modelo.setValueAt(next.getPuntoReposicion(), fila, 16);
                    this.modelo.setValueAt(next.getNivelMaximo(), fila, 17);
                    this.modelo.setValueAt(next.getUnidadEmpaque(), fila, 18);
                    this.modelo.setValueAt(next.getIva(), fila, 19);
                    if (next.getCantidadPedir().doubleValue() <= 0.0d) {
                        this.modelo.setValueAt("CON EXISTENCIA", fila, 20);
                    } else if (next.getCantidadPedir().doubleValue() > 0.0d && next.getCantidadPedir().doubleValue() <= next.getPuntoReposicion().doubleValue()) {
                        this.modelo.setValueAt("POR DEBAJO DEL PUNTO", fila, 20);
                    } else if (next.getCantidadPedir().doubleValue() > 0.0d && next.getCantidadPedir().doubleValue() <= next.getNivelMaximo().doubleValue()) {
                        this.modelo.setValueAt("POR DEBAJO MAXIMO", fila, 20);
                    } else {
                        this.modelo.setValueAt("SIN EXISTENCIA", fila, 20);
                    }
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    fila++;
                } else if (this.JCH_Positivo.isSelected()) {
                    if (next.getCantidadPedir().doubleValue() > 0.0d) {
                        this.modelo.addRow((Object[]) null);
                        this.modelo.setValueAt(next.getId(), fila, 0);
                        this.modelo.setValueAt(next.getSuministro(), fila, 1);
                        this.modelo.setValueAt(next.getPrincipioActivo(), fila, 2);
                        this.modelo.setValueAt(next.getLaboratorio(), fila, 3);
                        this.modelo.setValueAt(next.getPresentacionFarmaceutica(), fila, 4);
                        this.modelo.setValueAt(next.getTipoProducto(), fila, 5);
                        this.modelo.setValueAt(false, fila, 6);
                        this.modelo.setValueAt(next.getCantidadPedir(), fila, 7);
                        this.modelo.setValueAt(next.getNumeroMeses(), fila, 8);
                        this.modelo.setValueAt(next.getConsumo(), fila, 9);
                        this.modelo.setValueAt(next.getSalidaCorte(), fila, 10);
                        this.modelo.setValueAt(next.getEntradaCorte(), fila, 11);
                        this.modelo.setValueAt(next.getExistenciaActual(), fila, 12);
                        this.modelo.setValueAt(next.getConsumoPromedioMensual(), fila, 13);
                        this.modelo.setValueAt(next.getFactorTiempoReposicion(), fila, 14);
                        this.modelo.setValueAt(next.getNivelMinimo(), fila, 15);
                        this.modelo.setValueAt(next.getPuntoReposicion(), fila, 16);
                        this.modelo.setValueAt(next.getNivelMaximo(), fila, 17);
                        this.modelo.setValueAt(next.getUnidadEmpaque(), fila, 18);
                        this.modelo.setValueAt(next.getIva(), fila, 19);
                        if (next.getCantidadPedir().doubleValue() <= 0.0d) {
                            this.modelo.setValueAt("CON EXISTENCIA", fila, 20);
                        } else if (next.getCantidadPedir().doubleValue() > 0.0d && next.getCantidadPedir().doubleValue() <= next.getPuntoReposicion().doubleValue()) {
                            this.modelo.setValueAt("POR DEBAJO DEL PUNTO", fila, 20);
                        } else if (next.getCantidadPedir().doubleValue() > 0.0d && next.getCantidadPedir().doubleValue() <= next.getNivelMaximo().doubleValue()) {
                            this.modelo.setValueAt("POR DEBAJO MAXIMO", fila, 20);
                        } else {
                            this.modelo.setValueAt("SIN EXISTENCIA", fila, 20);
                        }
                        this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                        fila++;
                    }
                } else if (next.getCantidadPedir().doubleValue() < 0.0d) {
                    this.modelo.addRow((Object[]) null);
                    this.modelo.setValueAt(next.getId(), fila, 0);
                    this.modelo.setValueAt(next.getSuministro(), fila, 1);
                    this.modelo.setValueAt(next.getPrincipioActivo(), fila, 2);
                    this.modelo.setValueAt(next.getLaboratorio(), fila, 3);
                    this.modelo.setValueAt(next.getPresentacionFarmaceutica(), fila, 4);
                    this.modelo.setValueAt(next.getTipoProducto(), fila, 5);
                    this.modelo.setValueAt(false, fila, 6);
                    this.modelo.setValueAt(next.getCantidadPedir(), fila, 7);
                    this.modelo.setValueAt(next.getNumeroMeses(), fila, 8);
                    this.modelo.setValueAt(next.getConsumo(), fila, 9);
                    this.modelo.setValueAt(next.getSalidaCorte(), fila, 10);
                    this.modelo.setValueAt(next.getEntradaCorte(), fila, 11);
                    this.modelo.setValueAt(next.getExistenciaActual(), fila, 12);
                    this.modelo.setValueAt(next.getConsumoPromedioMensual(), fila, 13);
                    this.modelo.setValueAt(next.getFactorTiempoReposicion(), fila, 14);
                    this.modelo.setValueAt(next.getNivelMinimo(), fila, 15);
                    this.modelo.setValueAt(next.getPuntoReposicion(), fila, 16);
                    this.modelo.setValueAt(next.getNivelMaximo(), fila, 17);
                    this.modelo.setValueAt(next.getUnidadEmpaque(), fila, 18);
                    this.modelo.setValueAt(next.getIva(), fila, 19);
                    if (next.getCantidadPedir().doubleValue() <= 0.0d) {
                        this.modelo.setValueAt("CON EXISTENCIA", fila, 20);
                    } else if (next.getCantidadPedir().doubleValue() > 0.0d && next.getCantidadPedir().doubleValue() <= next.getPuntoReposicion().doubleValue()) {
                        this.modelo.setValueAt("POR DEBAJO DEL PUNTO", fila, 20);
                    } else if (next.getCantidadPedir().doubleValue() > 0.0d && next.getCantidadPedir().doubleValue() <= next.getNivelMaximo().doubleValue()) {
                        this.modelo.setValueAt("POR DEBAJO MAXIMO", fila, 20);
                    } else {
                        this.modelo.setValueAt("SIN EXISTENCIA", fila, 20);
                    }
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender());
                    fila++;
                }
            }
            this.JLB_NRegistro.setText("" + fila);
        }
    }

    public void buscar() {
        cargarDatos();
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/inventario/JIF_GestionInventarioCompras$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 20).toString().equals("SIN EXISTENCIA")) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else if (table.getValueAt(row, 20).toString().equals("POR DEBAJO DEL PUNTO")) {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            } else if (table.getValueAt(row, 20).toString().equals("POR DEBAJO MAXIMO")) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    @Generated
    public ButtonGroup getJBG_Filtro() {
        return this.JBG_Filtro;
    }

    @Generated
    public JButton getJBTExportar() {
        return this.JBTExportar;
    }

    @Generated
    public JButton getJBTOrdenCompra() {
        return this.JBTOrdenCompra;
    }

    @Generated
    public JComboBox getJCBBodega() {
        return this.JCBBodega;
    }

    @Generated
    public JComboBox getJCBTipoProducto() {
        return this.JCBTipoProducto;
    }

    @Generated
    public JCheckBox getJCH_AplicaDivision() {
        return this.JCH_AplicaDivision;
    }

    @Generated
    public JCheckBox getJCH_Filtro() {
        return this.JCH_Filtro;
    }

    @Generated
    public JCheckBox getJCH_Negativo() {
        return this.JCH_Negativo;
    }

    @Generated
    public JCheckBox getJCH_Positivo() {
        return this.JCH_Positivo;
    }

    @Generated
    public JCheckBox getJCH_Seleccionar() {
        return this.JCH_Seleccionar;
    }

    @Generated
    public JCheckBox getJCH_Todos() {
        return this.JCH_Todos;
    }

    @Generated
    public JDateChooser getJDFechaC() {
        return this.JDFechaC;
    }

    @Generated
    public JDateChooser getJDFechaFinal() {
        return this.JDFechaFinal;
    }

    @Generated
    public JDateChooser getJDFechaInicial() {
        return this.JDFechaInicial;
    }

    @Generated
    public JLabel getJLB_NRegistro() {
        return this.JLB_NRegistro;
    }

    @Generated
    public JPanel getJPI_InformacionFiltro() {
        return this.JPI_InformacionFiltro;
    }

    @Generated
    public JPanel getJPI_Utilidades() {
        return this.JPI_Utilidades;
    }

    @Generated
    public JPanel getJP_FIltroEstado() {
        return this.JP_FIltroEstado;
    }

    @Generated
    public JPanel getJP_FechasConsumo() {
        return this.JP_FechasConsumo;
    }

    @Generated
    public JScrollPane getJSPDetalle() {
        return this.JSPDetalle;
    }

    @Generated
    public JSpinner getJSP_PoliticaC() {
        return this.JSP_PoliticaC;
    }

    @Generated
    public JSpinner getJSP_TiempoR() {
        return this.JSP_TiempoR;
    }

    @Generated
    public JTable getJTDetalle() {
        return this.JTDetalle;
    }

    @Generated
    public JTextField getJTFRuta() {
        return this.JTFRuta;
    }

    @Generated
    public JCheckBox getJCheckBox1() {
        return this.jCheckBox1;
    }

    @Generated
    public JCheckBox getJCheckBox2() {
        return this.jCheckBox2;
    }

    @Generated
    public JCheckBox getJCheckBox3() {
        return this.jCheckBox3;
    }

    @Generated
    public JCheckBox getJCheckBox4() {
        return this.jCheckBox4;
    }

    @Generated
    public JPanel getJPanel1() {
        return this.jPanel1;
    }
}
