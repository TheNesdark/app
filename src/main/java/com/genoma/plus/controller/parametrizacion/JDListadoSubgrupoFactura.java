package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.parametrizacion.listadosubgrupofacturaDAOImpl;
import com.genoma.plus.dao.parametrizacion.listadosubgrupofacturaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import lombok.Generated;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JDListadoSubgrupoFactura.class */
public class JDListadoSubgrupoFactura extends JDialog {
    private DefaultTableModel modelo;
    private Object[] datos;
    private String idEmpresaConvenio;
    private listadosubgrupofacturaDAO listadosubgrupofacturaDAO;
    private Metodos xmt;
    private Long idConvenio;
    private int tipo;
    private JButton JBTCarguesA;
    private JButton JBTCerrar;
    private JCheckBox JCHSeleccionar;
    private JLabel JLB_NRegistros;
    private JScrollPane JSPResultado;
    private JTable JTDetalle;
    private JTextField JTFBuscar;

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
    public void setListadosubgrupofacturaDAO(listadosubgrupofacturaDAO listadosubgrupofacturaDAO) {
        this.listadosubgrupofacturaDAO = listadosubgrupofacturaDAO;
    }

    @Generated
    public void setXmt(Metodos xmt) {
        this.xmt = xmt;
    }

    @Generated
    public void setIdConvenio(Long idConvenio) {
        this.idConvenio = idConvenio;
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
    public void setJTFBuscar(JTextField JTFBuscar) {
        this.JTFBuscar = JTFBuscar;
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
    public listadosubgrupofacturaDAO getListadosubgrupofacturaDAO() {
        return this.listadosubgrupofacturaDAO;
    }

    @Generated
    public Metodos getXmt() {
        return this.xmt;
    }

    @Generated
    public Long getIdConvenio() {
        return this.idConvenio;
    }

    @Generated
    public int getTipo() {
        return this.tipo;
    }

    public JDListadoSubgrupoFactura(Frame parent, boolean modal, Long idConvenio) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        this.idConvenio = idConvenio;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
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
        this.JTFBuscar = new JTextField();
        setDefaultCloseOperation(2);
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setEditingColumn(1);
        this.JTDetalle.setEditingRow(1);
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JDListadoSubgrupoFactura.1
            public void mouseClicked(MouseEvent evt) {
                JDListadoSubgrupoFactura.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTDetalle);
        this.JBTCarguesA.setFont(new Font("Arial", 1, 12));
        this.JBTCarguesA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTCarguesA.setText("Grabar");
        this.JBTCarguesA.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDListadoSubgrupoFactura.2
            public void actionPerformed(ActionEvent evt) {
                JDListadoSubgrupoFactura.this.JBTCarguesAActionPerformed(evt);
            }
        });
        this.JBTCerrar.setFont(new Font("Arial", 1, 14));
        this.JBTCerrar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTCerrar.setText("Cerrar");
        this.JBTCerrar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDListadoSubgrupoFactura.3
            public void actionPerformed(ActionEvent evt) {
                JDListadoSubgrupoFactura.this.JBTCerrarActionPerformed(evt);
            }
        });
        this.JLB_NRegistros.setFont(new Font("Arial", 1, 18));
        this.JLB_NRegistros.setHorizontalAlignment(0);
        this.JLB_NRegistros.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Registros", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCHSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccionar.setText("Seleccionar Todos?");
        this.JCHSeleccionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDListadoSubgrupoFactura.4
            public void actionPerformed(ActionEvent evt) {
                JDListadoSubgrupoFactura.this.JCHSeleccionarActionPerformed(evt);
            }
        });
        this.JTFBuscar.setFont(new Font("Arial", 1, 12));
        this.JTFBuscar.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBuscar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JDListadoSubgrupoFactura.5
            public void keyPressed(KeyEvent evt) {
                JDListadoSubgrupoFactura.this.JTFBuscarKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPResultado, -1, 863, 32767)).addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JLB_NRegistros, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHSeleccionar, -2, 173, -2).addGap(54, 54, 54).addComponent(this.JBTCarguesA, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTCerrar, -2, 188, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTFBuscar))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTFBuscar, -2, 44, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -1, 413, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTCarguesA, -2, 50, -2).addComponent(this.JBTCerrar, -2, 50, -2).addComponent(this.JCHSeleccionar)).addComponent(this.JLB_NRegistros, -2, 51, -2)).addGap(16, 16, 16)));
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
        if (!this.JLB_NRegistros.getText().isEmpty() || this.JLB_NRegistros.getText() != "0") {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                    if (Boolean.valueOf(this.modelo.getValueAt(i, 0).toString()).booleanValue()) {
                        this.listadosubgrupofacturaDAO.crear(Long.valueOf(this.modelo.getValueAt(i, 3).toString()), this.idConvenio);
                    }
                }
                mCargarDatos();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar al menos un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTCerrarActionPerformed(ActionEvent evt) {
        Principal.claseparametrizacionn.nuevo("jifsubgrupofacempresa");
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
    public void JTFBuscarKeyPressed(KeyEvent evt) {
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
        this.listadosubgrupofacturaDAO = (listadosubgrupofacturaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("listadosubgrupofacturaDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Seleccionar", "IdServicio", "Servicio", "idSubGrupo", "SubGrupo", "Estado", "Grabado"}) { // from class: com.genoma.plus.controller.parametrizacion.JDListadoSubgrupoFactura.6
            Class[] types = {Boolean.class, Long.class, String.class, Long.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

    private void mCargarDatos() {
        List<Object[]> list = this.listadosubgrupofacturaDAO.listadosubgrupofacturaempresaDAO(this.idConvenio, this.JTFBuscar.getText(), 0);
        mCreaModelo();
        for (int x = 0; x < list.size(); x++) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(list.get(x)[0], x, 0);
            this.modelo.setValueAt(list.get(x)[1], x, 1);
            this.modelo.setValueAt(list.get(x)[2], x, 2);
            this.modelo.setValueAt(list.get(x)[3], x, 3);
            this.modelo.setValueAt(list.get(x)[4], x, 4);
            if (Integer.valueOf(list.get(x)[5].toString()).intValue() == 1) {
                this.modelo.setValueAt(true, x, 5);
            } else {
                this.modelo.setValueAt(false, x, 5);
            }
            if (Integer.valueOf(list.get(x)[6].toString()).intValue() == 1) {
                this.modelo.setValueAt(true, x, 6);
            } else {
                this.modelo.setValueAt(false, x, 6);
            }
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

    @Generated
    public JTextField getJTFBuscar() {
        return this.JTFBuscar;
    }
}
