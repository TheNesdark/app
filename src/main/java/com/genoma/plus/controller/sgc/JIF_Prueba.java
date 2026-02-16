package com.genoma.plus.controller.sgc;

import Acceso.Principal;
import com.genoma.plus.jpa.entities.Prueba;
import com.genoma.plus.jpa.service.IPruebaService;
import com.genoma.plus.jpa.service.impl.PruebaServiceImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JIF_Prueba.class */
public class JIF_Prueba extends JInternalFrame {
    private Prueba prueba;
    private final IPruebaService iPruebaService;
    private List<Prueba> listPrueba;
    private Object[] datos;
    private DefaultTableModel modelo;
    private JCheckBox JCH_Estado;
    private JPanel JPEncabezado;
    private JScrollPane JSP_Detalle;
    private JTable JTB_Detalle;
    private JTextField JTF_Nombre;

    public JIF_Prueba() {
        initComponents();
        this.iPruebaService = (IPruebaService) Principal.contexto.getBean(PruebaServiceImpl.class);
        search();
    }

    /* JADX WARN: Type inference failed for: r4v17, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPEncabezado = new JPanel();
        this.JTF_Nombre = new JTextField();
        this.JCH_Estado = new JCheckBox();
        this.JSP_Detalle = new JScrollPane();
        this.JTB_Detalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("Prueba");
        setName("jifprueba");
        this.JPEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "ENCABEZADO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTF_Nombre.setFont(new Font("Arial", 1, 12));
        this.JTF_Nombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCH_Estado.setFont(new Font("Arial", 1, 12));
        this.JCH_Estado.setSelected(true);
        this.JCH_Estado.setText("Estado");
        GroupLayout JPEncabezadoLayout = new GroupLayout(this.JPEncabezado);
        this.JPEncabezado.setLayout(JPEncabezadoLayout);
        JPEncabezadoLayout.setHorizontalGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEncabezadoLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JTF_Nombre, -2, 429, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, 32767).addComponent(this.JCH_Estado).addGap(16, 16, 16)));
        JPEncabezadoLayout.setVerticalGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_Estado).addComponent(this.JTF_Nombre, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTB_Detalle.setModel(new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado", "Fecha"}) { // from class: com.genoma.plus.controller.sgc.JIF_Prueba.1
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        });
        this.JTB_Detalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sgc.JIF_Prueba.2
            public void mouseClicked(MouseEvent evt) {
                JIF_Prueba.this.JTB_DetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTB_Detalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPEncabezado, -1, -1, 32767).addComponent(this.JSP_Detalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPEncabezado, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSP_Detalle, -2, 231, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTB_DetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.JTF_Nombre.setText(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 1).toString());
            this.JCH_Estado.setSelected(Boolean.valueOf(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 2).toString()).booleanValue());
        }
    }

    public void save() {
        this.prueba = new Prueba();
        if (!this.JTF_Nombre.getText().isEmpty()) {
            if (this.JTB_Detalle.getSelectedRow() != -1) {
                this.prueba.setId(Integer.valueOf(this.JTB_Detalle.getValueAt(this.JTB_Detalle.getSelectedRow(), 0).toString()));
            }
            this.prueba.setNombre(this.JTF_Nombre.getText());
            this.prueba.setEstado(Boolean.valueOf(this.JCH_Estado.isSelected()));
            this.prueba.setFecha(new Date());
            this.iPruebaService.save(this.prueba);
            search();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Estado", "fecha"}) { // from class: com.genoma.plus.controller.sgc.JIF_Prueba.3
            Class[] types = {Integer.class, String.class, Boolean.class, Date.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.JTB_Detalle.setModel(this.modelo);
        this.JTB_Detalle.setAutoResizeMode(0);
        this.JTB_Detalle.doLayout();
        this.JTB_Detalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTB_Detalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTB_Detalle.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void search() {
        this.listPrueba = new ArrayList();
        this.listPrueba = this.iPruebaService.getListPrueba();
        crearModeloDatos();
        this.listPrueba.forEach(l -> {
            this.modelo.addRow(this.datos);
            this.JTB_Detalle.setValueAt(l.getId(), this.JTB_Detalle.getRowCount() - 1, 0);
            this.JTB_Detalle.setValueAt(l.getNombre(), this.JTB_Detalle.getRowCount() - 1, 1);
            this.JTB_Detalle.setValueAt(l.getEstado(), this.JTB_Detalle.getRowCount() - 1, 2);
            this.JTB_Detalle.setValueAt(l.getFecha(), this.JTB_Detalle.getRowCount() - 1, 3);
        });
    }

    public void nuevo() {
        this.JTF_Nombre.setText("");
        this.JCH_Estado.setSelected(true);
    }
}
