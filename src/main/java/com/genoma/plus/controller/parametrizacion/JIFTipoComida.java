package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.TipoComidaDTO;
import com.genoma.plus.jpa.service.ITipoComidaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFTipoComida.class */
public class JIFTipoComida extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private TipoComidaDTO xTipoComidaDTO;
    private JCheckBox JCKBEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private Metodos xmetodos = new Metodos();
    private final ITipoComidaDAO xITipoComidaDAO = (ITipoComidaDAO) Principal.contexto.getBean(ITipoComidaDAO.class);
    private Long id = 0L;

    public JIFTipoComida() {
        initComponents();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v20, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCKBEstado = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE COMIDA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifTipoComida");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCKBEstado.setFont(new Font("Arial", 1, 12));
        this.JCKBEstado.setSelected(true);
        this.JCKBEstado.setText("Estado");
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 424, -2).addGap(26, 26, 26).addComponent(this.JCKBEstado).addContainerGap(-1, 32767)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCKBEstado).addGap(0, 0, 32767)).addComponent(this.JTFNombre, -1, 47, 32767)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFTipoComida.1
            public void mouseClicked(MouseEvent evt) {
                JIFTipoComida.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JSPDetalle, -2, 748, -2)).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 244, 32767).addContainerGap()));
        getAccessibleContext().setAccessibleName("jifTipoComida");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getRowCount() > 0) {
            this.id = Long.valueOf(Long.parseLong(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCKBEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
        }
    }

    public void mNuevo() {
        mCargarDatosTabla();
        this.id = 0L;
        this.JTFNombre.setText("");
        this.JCKBEstado.setSelected(true);
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCKBEstado.isSelected()) {
            }
            this.xTipoComidaDTO = new TipoComidaDTO();
            if (this.JTDetalle.getSelectedRow() >= 0) {
                this.xTipoComidaDTO.setId(this.id);
            }
            this.xTipoComidaDTO.setNombre(this.JTFNombre.getText().trim());
            this.xTipoComidaDTO.setEstado(Boolean.valueOf(this.JCKBEstado.isSelected()));
            this.xTipoComidaDTO.setFecha(this.xmetodos.getFechaActual());
            this.xITipoComidaDAO.grabar(this.xTipoComidaDTO);
            mNuevo();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un lider", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "estado", "fecha"}) { // from class: com.genoma.plus.controller.parametrizacion.JIFTipoComida.2
            Class[] types = {Long.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        List<TipoComidaDTO> tabla = this.xITipoComidaDAO.consultarTipoComida();
        mCrearModeloDatos();
        for (int i = 0; i < tabla.size(); i++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(tabla.get(i).getId(), i, 0);
            this.xmodelo.setValueAt(tabla.get(i).getNombre(), i, 1);
            this.xmodelo.setValueAt(tabla.get(i).getEstado(), i, 2);
            this.xmodelo.setValueAt(this.xmetodos.formatoDMAH24.format(tabla.get(i).getFecha()), i, 3);
        }
    }
}
