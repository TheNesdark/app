package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.TipoAtencionDAO;
import com.genoma.plus.dao.impl.facturacion.TipoAtencionDAOImpl;
import com.genoma.plus.dto.facturacion.TipoAtencionDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIFTipoAtencion.class */
public class JIFTipoAtencion extends JInternalFrame {
    private Metodos xmt = new Metodos();
    private DefaultTableModel xmodelo;
    private TipoAtencionDAO tipoAtencionDAO;
    private Object[] xdatos;
    private String[] tipoAmbito;
    private String[] grupoServicio;
    public JComboBox JCBComboGrupoServicio;
    private JComboBox<String> JCBTipoAmbito;
    private JCheckBox JChBHospitalizacion;
    private JCheckBox JChEstado;
    private JSpinner JSpinOrden;
    private JTextField JTFNombre;
    private JTable JTTipoAtencion;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JIFTipoAtencion() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.tipoAtencionDAO = (TipoAtencionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoAtencionDAO");
    }

    /* JADX WARN: Type inference failed for: r3v48, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.JSpinOrden = new JSpinner();
        this.JTFNombre = new JTextField();
        this.JChBHospitalizacion = new JCheckBox();
        this.JCBTipoAmbito = new JComboBox<>();
        this.JChEstado = new JCheckBox();
        this.JCBComboGrupoServicio = new JComboBox();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTTipoAtencion = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE ATENCIÓN");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jIFTipoAtencion");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.facturacion.JIFTipoAtencion.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFTipoAtencion.this.formInternalFrameClosing(evt);
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
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSpinOrden.setFont(new Font("Arial", 1, 12));
        this.JSpinOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSpinOrden.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.facturacion.JIFTipoAtencion.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoAtencion.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JChBHospitalizacion.setFont(new Font("Arial", 1, 12));
        this.JChBHospitalizacion.setForeground(Color.blue);
        this.JChBHospitalizacion.setText("Hospitalización");
        this.JCBTipoAmbito.setFont(new Font("Arial", 1, 12));
        this.JCBTipoAmbito.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "Tipo de Ambito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JChEstado.setFont(new Font("Arial", 1, 12));
        this.JChEstado.setForeground(Color.blue);
        this.JChEstado.setText("Estado");
        this.JCBComboGrupoServicio.setFont(new Font("Arial", 1, 12));
        this.JCBComboGrupoServicio.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "Grupo Servicio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBComboGrupoServicio.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.facturacion.JIFTipoAtencion.3
            public void itemStateChanged(ItemEvent evt) {
                JIFTipoAtencion.this.JCBComboGrupoServicioItemStateChanged(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFNombre).addGap(18, 18, 18).addComponent(this.JCBTipoAmbito, -2, 166, -2)).addComponent(this.JCBComboGrupoServicio, 0, -1, 32767)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSpinOrden, -2, 80, -2).addComponent(this.JChBHospitalizacion).addComponent(this.JChEstado, -2, 111, -2)).addGap(19, 19, 19)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JSpinOrden, -2, 50, -2).addComponent(this.JCBTipoAmbito, -2, 50, -2)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, 32767).addComponent(this.JChBHospitalizacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JChEstado)).addGroup(jPanel2Layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.JCBComboGrupoServicio, -2, 50, -2).addGap(0, 0, 32767)))));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(184, 207, 229)), "HISTÓRICO ", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTTipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JTTipoAtencion.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTTipoAtencion.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFTipoAtencion.4
            public void mouseClicked(MouseEvent evt) {
                JIFTipoAtencion.this.JTTipoAtencionMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTTipoAtencion);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 615, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 140, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jPanel2, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "GenHosp", "Id Tipo Ambito", "Tipo de Ambito", "Estado", "Orden", "Grupo servicio", "Id Grupo Servicio"}) { // from class: com.genoma.plus.controller.facturacion.JIFTipoAtencion.5
            Class[] types = {Integer.class, String.class, Boolean.class, Integer.class, String.class, Boolean.class, Integer.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTTipoAtencion.setModel(this.xmodelo);
        this.JTTipoAtencion.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTTipoAtencion.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTTipoAtencion.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTTipoAtencion.getColumnModel().getColumn(5).setPreferredWidth(70);
        this.JTTipoAtencion.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTTipoAtencion.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTTipoAtencion.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    public void mNuevo() {
        this.JChEstado.setSelected(true);
        this.JChBHospitalizacion.setSelected(false);
        this.JSpinOrden.setValue(0);
        this.JTFNombre.setText("");
        this.JCBTipoAmbito.setSelectedIndex(-1);
        this.JCBComboGrupoServicio.setSelectedIndex(-1);
        Principal.mLimpiarDatosP();
        mCargarDatos();
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<Object[]> ListadoTipoAtencion = this.tipoAtencionDAO.listTipoAtencion();
        for (int x = 0; x < ListadoTipoAtencion.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int y = 0; y < 9; y++) {
                this.xmodelo.setValueAt(ListadoTipoAtencion.get(x)[y], x, y);
            }
        }
        List<Object[]> ListadoTipoAmbito = this.tipoAtencionDAO.listTipoAmbito();
        this.tipoAmbito = new String[ListadoTipoAmbito.size()];
        this.JCBTipoAmbito.removeAllItems();
        for (int z = 0; z < ListadoTipoAmbito.size(); z++) {
            this.JCBTipoAmbito.addItem(ListadoTipoAmbito.get(z)[1].toString());
            this.tipoAmbito[z] = ListadoTipoAmbito.get(z)[0].toString();
        }
        List<Object[]> listadoGrupoServicio = this.tipoAtencionDAO.listGrupoServicio();
        this.grupoServicio = new String[listadoGrupoServicio.size()];
        this.JCBComboGrupoServicio.removeAllItems();
        for (int z2 = 0; z2 < listadoGrupoServicio.size(); z2++) {
            this.JCBComboGrupoServicio.addItem(listadoGrupoServicio.get(z2)[1].toString());
            this.grupoServicio[z2] = listadoGrupoServicio.get(z2)[0].toString();
        }
    }

    public void mGrabar() {
        System.out.println("grabar");
        if (!this.JTFNombre.getText().isEmpty() && this.JCBTipoAmbito.getSelectedIndex() >= 0 && Integer.parseInt(this.JSpinOrden.getValue().toString()) >= 0) {
            TipoAtencionDTO tipoAtencionDTO = new TipoAtencionDTO();
            tipoAtencionDTO.setNombre(this.JTFNombre.getText());
            tipoAtencionDTO.setEstado(this.JChEstado.isSelected());
            tipoAtencionDTO.setGenHosp(this.JChBHospitalizacion.isSelected());
            tipoAtencionDTO.setOrden(Integer.parseInt(this.JSpinOrden.getValue().toString()));
            tipoAtencionDTO.setUsuarioSistema(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
            tipoAtencionDTO.setIdTipoAmbito(Integer.parseInt(this.tipoAmbito[this.JCBTipoAmbito.getSelectedIndex()]));
            System.out.println("Integer.parseInt(this.grupoServicio[this.JCBComboGrupoServicio.getSelectedIndex()]) -> " + Integer.parseInt(this.grupoServicio[this.JCBComboGrupoServicio.getSelectedIndex()]));
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    this.tipoAtencionDAO.addTipoAtencion(tipoAtencionDTO);
                } else {
                    tipoAtencionDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                    this.tipoAtencionDAO.updateTipoAtencion(tipoAtencionDTO);
                }
            }
        } else {
            this.xmt.mostrarMensajeError("Error al guardar");
        }
        mNuevo();
    }

    public void mCambiarItemSeleccionadoComboBox(String[] indices, int indiceTabla) {
        for (int i = 0; i < indices.length; i++) {
            if (indiceTabla == Integer.parseInt(indices[i])) {
                System.out.println("indice de tabla: " + i);
                this.JCBTipoAmbito.setSelectedIndex(i);
                return;
            }
        }
        System.out.println("no pudo cambiar el combobox");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTTipoAtencionMouseClicked(MouseEvent evt) {
        if (this.JTTipoAtencion.getSelectedRow() != -1) {
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTTipoAtencion.getSelectedRow(), 1).toString());
            this.JChBHospitalizacion.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTTipoAtencion.getSelectedRow(), 2)).booleanValue());
            mCambiarItemSeleccionadoComboBox(this.tipoAmbito, Integer.parseInt(this.xmodelo.getValueAt(this.JTTipoAtencion.getSelectedRow(), 3).toString()));
            this.JCBComboGrupoServicio.setSelectedItem(this.xmodelo.getValueAt(this.JTTipoAtencion.getSelectedRow(), 7).toString());
            this.JChEstado.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTTipoAtencion.getSelectedRow(), 5)).booleanValue());
            this.JSpinOrden.setValue(this.xmodelo.getValueAt(this.JTTipoAtencion.getSelectedRow(), 6));
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTTipoAtencion.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBComboGrupoServicioItemStateChanged(ItemEvent evt) {
    }
}
