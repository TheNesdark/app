package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.TipoVigilanciaDTO;
import com.genoma.plus.jpa.service.ITipoVigilanciaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFTipoVigilancia.class */
public class JIFTipoVigilancia extends JInternalFrame {
    private DefaultTableModel modelo;
    private Object[] dato;
    private TipoVigilanciaDTO tipoVigilanciaDTO;
    private List<TipoVigilanciaDTO> tipoVigilanciaDTOs;
    private JCheckBox JCKBEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JSpinner JSP_Dias;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private Metodos metodo = new Metodos();
    private final ITipoVigilanciaService tipoVigilanciaService = (ITipoVigilanciaService) Principal.contexto.getBean(ITipoVigilanciaService.class);
    private Long id = 0L;

    public JIFTipoVigilancia() {
        initComponents();
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCKBEstado = new JCheckBox();
        this.JTFNombre = new JTextField();
        this.JSP_Dias = new JSpinner();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO SISTEMA DE VIGILANCIA ");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jif_TipoSistemasVigilancia");
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
        this.JSP_Dias.setFont(new Font("Arial", 1, 12));
        this.JSP_Dias.setModel(new SpinnerNumberModel());
        this.JSP_Dias.setToolTipText("Número de días para seguimiento");
        this.JSP_Dias.setBorder(BorderFactory.createTitledBorder((Border) null, "Días", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 424, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSP_Dias, -2, 80, -2).addGap(33, 33, 33).addComponent(this.JCKBEstado).addGap(50, 50, 50)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNombre, -2, 47, -2).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCKBEstado).addComponent(this.JSP_Dias, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFTipoVigilancia.1
            public void mouseClicked(MouseEvent evt) {
                JIFTipoVigilancia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JSPDetalle, -2, 748, -2)).addComponent(this.JPIDatos, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 245, 32767).addContainerGap()));
        getAccessibleContext().setAccessibleName("jifTipoDieta");
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2 && this.JTDetalle.getRowCount() > 0) {
            this.tipoVigilanciaDTO = this.tipoVigilanciaDTOs.get(this.JTDetalle.getSelectedRow());
            this.JTFNombre.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCKBEstado.setSelected(Boolean.valueOf(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JSP_Dias.setValue(Integer.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
        }
    }

    public void nuevo() {
        this.tipoVigilanciaDTO = new TipoVigilanciaDTO();
        this.tipoVigilanciaDTOs = new ArrayList();
        cargarDatosTabla();
        this.JTFNombre.setText("");
        this.JSP_Dias.setValue(0);
        this.JCKBEstado.setSelected(true);
    }

    public void grabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            this.tipoVigilanciaDTO.setNombre(this.JTFNombre.getText());
            this.tipoVigilanciaDTO.setDiasSeguimiento(Integer.valueOf(this.JSP_Dias.getValue().toString()));
            this.tipoVigilanciaDTO.setEstado(Boolean.valueOf(this.JCKBEstado.isSelected()));
            this.tipoVigilanciaDTO.setFecha(this.metodo.getFechaActual());
            this.tipoVigilanciaDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            this.tipoVigilanciaService.crear(this.tipoVigilanciaDTO);
            nuevo();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDato() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"id", "nombre", "días", "estado", "fecha"}) { // from class: com.genoma.plus.controller.parametrizacion.JIFTipoVigilancia.2
            Class[] types = {Long.class, String.class, Integer.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void cargarDatosTabla() {
        this.tipoVigilanciaDTOs = this.tipoVigilanciaService.listaTipoVigilancia();
        crearModeloDato();
        for (int i = 0; i < this.tipoVigilanciaDTOs.size(); i++) {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(this.tipoVigilanciaDTOs.get(i).getId(), i, 0);
            this.modelo.setValueAt(this.tipoVigilanciaDTOs.get(i).getNombre(), i, 1);
            this.modelo.setValueAt(this.tipoVigilanciaDTOs.get(i).getDiasSeguimiento(), i, 2);
            this.modelo.setValueAt(this.tipoVigilanciaDTOs.get(i).getEstado(), i, 3);
            this.modelo.setValueAt(this.metodo.formatoDMAH24.format(this.tipoVigilanciaDTOs.get(i).getFecha()), i, 4);
        }
    }
}
