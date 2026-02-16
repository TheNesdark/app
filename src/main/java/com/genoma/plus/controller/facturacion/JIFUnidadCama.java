package com.genoma.plus.controller.facturacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.facturacion.UnidadCamaDAO;
import com.genoma.plus.dao.impl.facturacion.UnidadCamaDAOImpl;
import com.genoma.plus.dto.facturacion.UnidadCamaDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/facturacion/JIFUnidadCama.class */
public class JIFUnidadCama extends JInternalFrame {
    private Metodos metodo = new Metodos();
    private DefaultTableModel xmodelo;
    private UnidadCamaDAO unidadCamaDAO;
    Object[] data;
    String[] idTipoAtencion;
    private JComboBox<String> JCBTipoAtencion;
    private JCheckBox JCESHospitalizacion;
    private JCheckBox JCEstado;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JIFUnidadCama() {
        initComponents();
        springStart();
        mNuevo();
        llenarCombo();
    }

    private void springStart() {
        this.unidadCamaDAO = (UnidadCamaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("unidadCamaDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Es Hospitalizacion", "idTipoAtencion", "Tipo Atencion", "Estado"}) { // from class: com.genoma.plus.controller.facturacion.JIFUnidadCama.1
            Class[] types = {Long.class, String.class, Boolean.class, Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    private void llenarCombo() {
        List<Object[]> listaTipoAtenciones = this.unidadCamaDAO.listaTipoAtencion();
        this.idTipoAtencion = new String[listaTipoAtenciones.size()];
        for (int x = 0; x < listaTipoAtenciones.size(); x++) {
            this.idTipoAtencion[x] = listaTipoAtenciones.get(x)[0].toString();
            this.JCBTipoAtencion.addItem(listaTipoAtenciones.get(x)[1].toString());
        }
    }

    private void mCargarDAtos() {
        mCrearModeloDatos();
        List<Object[]> listaUnidadCama = this.unidadCamaDAO.listaUnidadCama();
        for (int x = 0; x < listaUnidadCama.size(); x++) {
            this.xmodelo.addRow(this.data);
            for (int j = 0; j < 6; j++) {
                this.xmodelo.setValueAt(listaUnidadCama.get(x)[j], x, j);
            }
        }
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBTipoAtencion.getSelectedIndex() != -1) {
                UnidadCamaDTO unidadCama = UnidadCamaDTO.builder().nombre(this.JTFNombre.getText()).tipoAtencion(1).esHospitalizacion(this.JCESHospitalizacion.isSelected()).estado(this.JCEstado.isSelected()).usuario(Principal.usuarioSistemaDTO.getLogin()).tipoAtencion(Integer.parseInt(this.idTipoAtencion[this.JCBTipoAtencion.getSelectedIndex()])).build();
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro que quiere guardar la infomación", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.unidadCamaDAO.mCreate(unidadCama);
                    } else {
                        unidadCama.setId(Integer.parseInt(Principal.txtNo.getText()));
                        this.unidadCamaDAO.mUpdate(unidadCama);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            this.metodo.mostrarMensaje("Debe selecionar un tipo de atencion ");
            return;
        }
        this.metodo.mostrarMensaje("El campo nombre no puede estar vacio");
    }

    public void mNuevo() {
        mCargarDAtos();
        this.JTFNombre.setText("");
        this.JCBTipoAtencion.setSelectedIndex(-1);
        this.JCEstado.setSelected(true);
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCBTipoAtencion = new JComboBox<>();
        this.JCEstado = new JCheckBox();
        this.JCESHospitalizacion = new JCheckBox();
        this.jPanel2 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setMaximizable(true);
        setTitle("UNIDAD CAMA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFUnidadCama");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.facturacion.JIFUnidadCama.2
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFUnidadCama.this.formInternalFrameClosing(evt);
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
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo De Atencion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setText("Estado");
        this.JCESHospitalizacion.setFont(new Font("Arial", 1, 12));
        this.JCESHospitalizacion.setText("Es hospitalizacion");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 270, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoAtencion, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCEstado).addComponent(this.JCESHospitalizacion)).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre).addComponent(this.JCBTipoAtencion)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCESHospitalizacion)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.facturacion.JIFUnidadCama.3
            public void mouseClicked(MouseEvent evt) {
                JIFUnidadCama.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 286, 32767));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCESHospitalizacion.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue());
            this.JCBTipoAtencion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }
}
