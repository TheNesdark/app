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
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JD_ListadoConvenios.class */
public class JD_ListadoConvenios extends JDialog {
    private DefaultTableModel modelo;
    private Object[] datos;
    private String idEmpresaConvenio;
    private GCuentaDAO gcuenta;
    private Metodos xmt;
    private String idNumeroFacturaOrden;
    private String fechaI;
    private String fechaF;
    private int tipo;
    private JButton JBTCarguesA;
    private JButton JBTCerrar;
    private JCheckBox JCHSeleccionar;
    private JLabel JLB_NRegistros;
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
    public void setXmt(Metodos xmt) {
        this.xmt = xmt;
    }

    @Generated
    public void setIdNumeroFacturaOrden(String idNumeroFacturaOrden) {
        this.idNumeroFacturaOrden = idNumeroFacturaOrden;
    }

    @Generated
    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    @Generated
    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }

    @Generated
    public void setTipo(int tipo) {
        this.tipo = tipo;
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
    public Metodos getXmt() {
        return this.xmt;
    }

    @Generated
    public String getIdNumeroFacturaOrden() {
        return this.idNumeroFacturaOrden;
    }

    @Generated
    public String getFechaI() {
        return this.fechaI;
    }

    @Generated
    public String getFechaF() {
        return this.fechaF;
    }

    @Generated
    public int getTipo() {
        return this.tipo;
    }

    public JD_ListadoConvenios(Frame parent, boolean modal, String fechaI, String fechaF, int tipo) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.idNumeroFacturaOrden = "";
        this.fechaI = "";
        this.fechaF = "";
        initComponents();
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.tipo = tipo;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setIdEmpresaConvenio(this.idEmpresaConvenio);
        springStart();
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPResultado = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTCarguesA = new JButton();
        this.JBTCerrar = new JButton();
        this.JLB_NRegistros = new JLabel();
        this.JCHSeleccionar = new JCheckBox();
        setDefaultCloseOperation(2);
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoConvenios.1
            public void mouseClicked(MouseEvent evt) {
                JD_ListadoConvenios.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTDetalle);
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTCarguesA.setText("Cargar Información");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoConvenios.2
            public void actionPerformed(ActionEvent evt) {
                JD_ListadoConvenios.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JBTCerrar.setFont(new Font("Arial", 1, 14));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoConvenios.3
            public void actionPerformed(ActionEvent evt) {
                JD_ListadoConvenios.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JLB_NRegistros.setFont(new Font("Arial", 1, 18));
        this.JLB_NRegistros.setHorizontalAlignment(0);
        this.JLB_NRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todos?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoConvenios.4
            public void actionPerformed(ActionEvent evt) {
                JD_ListadoConvenios.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado, -1, 748, 32767)).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JLB_NRegistros, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSeleccionar, -2, 173, -2).addGap(54, 54, 54).addComponent(this.JBTCarguesA, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar, -2, 188, -2))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JSPResultado, -1, 334, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCarguesA, -2, 50, -2).addComponent(this.JBTCerrar, -2, 50, -2).addComponent(this.JCHSeleccionar)).addComponent(this.JLB_NRegistros, -2, 51, -2)).addGap(16, 16, 16)));
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
            String idConvenio = "";
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue()) {
                    idConvenio = idConvenio + this.JTDetalle.getValueAt(i, 1).toString() + ",";
                }
            }
            setIdEmpresaConvenio(idConvenio.substring(0, idConvenio.length() - 1));
            System.out.println("" + getIdEmpresaConvenio());
            Principal.xclasegc.xjifgenerarrips.setIdConvenio(getIdEmpresaConvenio());
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
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "IdConvenio", "Convenio", "EsCapitado?"}) { // from class: com.genoma.plus.controller.gcuenta.JD_ListadoConvenios.5
            Class[] types = {Boolean.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
    }

    private void mCargarDatos() {
        List<Object[]> list = this.gcuenta.listConveniosParaRips(this.fechaI, this.fechaF, this.tipo);
        mCreaModelo();
        for (int x = 0; x < list.size(); x++) {
            System.out.println("0-->" + list.get(x)[0] + " 1-->" + list.get(x)[1] + " 2-->" + list.get(x)[2] + " 3-->" + list.get(x)[3]);
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(list.get(x)[0], x, 0);
            this.modelo.setValueAt(list.get(x)[1], x, 1);
            this.modelo.setValueAt(list.get(x)[2], x, 2);
            this.modelo.setValueAt(list.get(x)[3], x, 3);
        }
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
    public JScrollPane getJSPResultado() {
        return this.JSPResultado;
    }

    @Generated
    public JTable getJTDetalle() {
        return this.JTDetalle;
    }
}
