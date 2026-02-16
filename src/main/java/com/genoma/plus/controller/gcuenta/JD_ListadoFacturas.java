package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.jpa.gcuenta.GCuentaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JD_ListadoFacturas.class */
public class JD_ListadoFacturas extends JDialog {
    private DefaultTableModel modelo;
    private Object[] datos;
    private String idEmpresaConvenio;
    private GCuentaDAO gcuenta;
    private String idNumeroFacturaOrden;
    private String fechaInicio;
    private String fechaFin;
    private Metodos xmt;
    private int TipoFactura;
    private ButtonGroup JBG_Filtro;
    private JButton JBTCarguesA;
    private JButton JBTCerrar;
    private JCheckBox JCHSeleccionar;
    private JLabel JLB_NRegistros;
    private JPanel JPI_Filtro;
    private JRadioButton JRB_Fecha;
    private JRadioButton JRB_Todos;
    private JScrollPane JSPResultado;
    private JTable JTDetalle;

    @Generated
    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    @Generated
    public void setDatos(Object[] datos) {
        this.datos = datos;
    }

    @Generated
    public void setIdEmpresaConvenio(String idEmpresaConvenio) {
        this.idEmpresaConvenio = idEmpresaConvenio;
    }

    @Generated
    public void setGcuenta(GCuentaDAO gcuenta) {
        this.gcuenta = gcuenta;
    }

    @Generated
    public void setIdNumeroFacturaOrden(String idNumeroFacturaOrden) {
        this.idNumeroFacturaOrden = idNumeroFacturaOrden;
    }

    @Generated
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Generated
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Generated
    public void setXmt(Metodos xmt) {
        this.xmt = xmt;
    }

    @Generated
    public void setTipoFactura(int TipoFactura) {
        this.TipoFactura = TipoFactura;
    }

    @Generated
    public void setJBG_Filtro(ButtonGroup JBG_Filtro) {
        this.JBG_Filtro = JBG_Filtro;
    }

    @Generated
    public void setJBTCarguesA(JButton JBTCarguesA) {
        this.JBTCarguesA = JBTCarguesA;
    }

    @Generated
    public void setJBTCerrar(JButton JBTCerrar) {
        this.JBTCerrar = JBTCerrar;
    }

    @Generated
    public void setJCHSeleccionar(JCheckBox JCHSeleccionar) {
        this.JCHSeleccionar = JCHSeleccionar;
    }

    @Generated
    public void setJLB_NRegistros(JLabel JLB_NRegistros) {
        this.JLB_NRegistros = JLB_NRegistros;
    }

    @Generated
    public void setJPI_Filtro(JPanel JPI_Filtro) {
        this.JPI_Filtro = JPI_Filtro;
    }

    @Generated
    public void setJRB_Fecha(JRadioButton JRB_Fecha) {
        this.JRB_Fecha = JRB_Fecha;
    }

    @Generated
    public void setJRB_Todos(JRadioButton JRB_Todos) {
        this.JRB_Todos = JRB_Todos;
    }

    @Generated
    public void setJSPResultado(JScrollPane JSPResultado) {
        this.JSPResultado = JSPResultado;
    }

    @Generated
    public void setJTDetalle(JTable JTDetalle) {
        this.JTDetalle = JTDetalle;
    }

    @Generated
    public DefaultTableModel getModelo() {
        return this.modelo;
    }

    @Generated
    public Object[] getDatos() {
        return this.datos;
    }

    @Generated
    public String getIdEmpresaConvenio() {
        return this.idEmpresaConvenio;
    }

    @Generated
    public GCuentaDAO getGcuenta() {
        return this.gcuenta;
    }

    @Generated
    public String getIdNumeroFacturaOrden() {
        return this.idNumeroFacturaOrden;
    }

    @Generated
    public String getFechaInicio() {
        return this.fechaInicio;
    }

    @Generated
    public String getFechaFin() {
        return this.fechaFin;
    }

    @Generated
    public Metodos getXmt() {
        return this.xmt;
    }

    @Generated
    public int getTipoFactura() {
        return this.TipoFactura;
    }

    public JD_ListadoFacturas(Frame parent, boolean modal, String idEmpresaConvenio, String fechaInicio, String fechaFin, int TipoFactura) {
        super(parent, modal);
        this.idNumeroFacturaOrden = "";
        this.xmt = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setIdEmpresaConvenio(idEmpresaConvenio);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setTipoFactura(TipoFactura);
        springStart();
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JSPResultado = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTCarguesA = new JButton();
        this.JBTCerrar = new JButton();
        this.JLB_NRegistros = new JLabel();
        this.JCHSeleccionar = new JCheckBox();
        this.JPI_Filtro = new JPanel();
        this.JRB_Todos = new JRadioButton();
        this.JRB_Fecha = new JRadioButton();
        setDefaultCloseOperation(2);
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoFacturas.1
            public void mouseClicked(MouseEvent evt) {
                JD_ListadoFacturas.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTDetalle);
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCarguesA.setText("Cargar Información");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoFacturas.2
            public void actionPerformed(ActionEvent evt) {
                JD_ListadoFacturas.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JBTCerrar.setFont(new Font("Arial", 1, 14));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoFacturas.3
            public void actionPerformed(ActionEvent evt) {
                JD_ListadoFacturas.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JLB_NRegistros.setFont(new Font("Arial", 1, 18));
        this.JLB_NRegistros.setHorizontalAlignment(0);
        this.JLB_NRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todos?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoFacturas.4
            public void actionPerformed(ActionEvent evt) {
                JD_ListadoFacturas.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBG_Filtro.add(this.JRB_Todos);
        this.JRB_Todos.setFont(new Font("Arial", 1, 12));
        this.JRB_Todos.setSelected(true);
        this.JRB_Todos.setText("Todo");
        this.JRB_Todos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoFacturas.5
            public void actionPerformed(ActionEvent evt) {
                JD_ListadoFacturas.this.JRB_TodosActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRB_Fecha);
        this.JRB_Fecha.setFont(new Font("Arial", 1, 12));
        this.JRB_Fecha.setText("Fecha");
        this.JRB_Fecha.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoFacturas.6
            public void actionPerformed(ActionEvent evt) {
                JD_ListadoFacturas.this.JRB_FechaActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Todos).addGap(18, 18, 18).addComponent(this.JRB_Fecha).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Todos).addComponent(this.JRB_Fecha)).addGap(0, 0, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.JCHSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTCarguesA, -2, 217, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar, -2, 222, -2)).addComponent(this.JSPResultado, GroupLayout.Alignment.LEADING, -1, 737, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_NRegistros, -2, 132, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_Filtro, -1, -1, 32767).addComponent(this.JLB_NRegistros, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -2, 261, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCarguesA, -2, 50, -2).addComponent(this.JBTCerrar, -2, 50, -2).addComponent(this.JCHSeleccionar)).addGap(16, 16, 16)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            int numeroRegistros = 0;
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue()) {
                    numeroRegistros++;
                }
            }
            this.JLB_NRegistros.setText("" + numeroRegistros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCarguesAActionPerformed(ActionEvent evt) {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalle, 0)) {
            String idOrdenFactura = "";
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue()) {
                    idOrdenFactura = idOrdenFactura + "'" + this.JTDetalle.getValueAt(i, 1).toString() + "',";
                }
            }
            setIdNumeroFacturaOrden(idOrdenFactura.substring(0, idOrdenFactura.length() - 1));
            Principal.xclasegc.xjifgenerarrips.JCBNFactura.setSelectedIndex(-1);
            Principal.xclasegc.xjifgenerarrips.setIdNumeroFactura(getIdNumeroFacturaOrden());
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccionar.isSelected()) {
            SeleccionarRegistrosTabla(true);
        } else {
            SeleccionarRegistrosTabla(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_TodosActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FechaActionPerformed(ActionEvent evt) {
        mCargarDatos();
    }

    private void SeleccionarRegistrosTabla(boolean estado) {
        int numeroRegistros = 0;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            this.JTDetalle.setValueAt(Boolean.valueOf(estado), i, 0);
            if (estado) {
                numeroRegistros++;
            }
        }
        this.JLB_NRegistros.setText("" + numeroRegistros);
    }

    private void springStart() {
        this.gcuenta = (GCuentaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("gCuentaDAOImpl");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "No. Factura/Orden", "Fecha", "Servicio", "Valor"}) { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoFacturas.7
            Class[] types = {Boolean.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void mCargarDatos() {
        List<Object[]> list;
        if (this.JRB_Todos.isSelected()) {
            list = this.gcuenta.listFacturaOrdenParaRips(getIdEmpresaConvenio(), getTipoFactura());
        } else {
            list = this.gcuenta.listFacturaOrdenParaRips(getIdEmpresaConvenio(), getFechaInicio(), getFechaFin(), getTipoFactura());
        }
        mCreaModelo();
        for (int x = 0; x < list.size(); x++) {
            System.out.println("0-->" + list.get(x)[0] + " 1-->" + list.get(x)[1] + " 2-->" + list.get(x)[2] + " 3-->" + list.get(x)[3]);
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(list.get(x)[0], x, 0);
            this.modelo.setValueAt(list.get(x)[1], x, 1);
            this.modelo.setValueAt(list.get(x)[2], x, 2);
            this.modelo.setValueAt(list.get(x)[3], x, 3);
            this.modelo.setValueAt(list.get(x)[4], x, 4);
        }
    }

    @Generated
    public ButtonGroup getJBG_Filtro() {
        return this.JBG_Filtro;
    }

    @Generated
    public JButton getJBTCarguesA() {
        return this.JBTCarguesA;
    }

    @Generated
    public JButton getJBTCerrar() {
        return this.JBTCerrar;
    }

    @Generated
    public JCheckBox getJCHSeleccionar() {
        return this.JCHSeleccionar;
    }

    @Generated
    public JLabel getJLB_NRegistros() {
        return this.JLB_NRegistros;
    }

    @Generated
    public JPanel getJPI_Filtro() {
        return this.JPI_Filtro;
    }

    @Generated
    public JRadioButton getJRB_Fecha() {
        return this.JRB_Fecha;
    }

    @Generated
    public JRadioButton getJRB_Todos() {
        return this.JRB_Todos;
    }

    @Generated
    public JScrollPane getJSPResultado() {
        return this.JSPResultado;
    }

    @Generated
    public JTable getJTDetalle() {
        return this.JTDetalle;
    }
}
