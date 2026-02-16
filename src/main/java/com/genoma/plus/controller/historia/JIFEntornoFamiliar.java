package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.EntornoFamiliarDAO;
import com.genoma.plus.dao.impl.historia.EntornoFamiliarDAOImpl;
import com.genoma.plus.dto.historia.EntornoFamiliarDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIFEntornoFamiliar.class */
public class JIFEntornoFamiliar extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Metodos xmt = new Metodos();
    private Object[] xdatos;
    private EntornoFamiliarDAO xEntornoF;
    private JCheckBox JCEstado;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JPanel jPanel1;

    public JIFEntornoFamiliar() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xEntornoF = (EntornoFamiliarDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("EntornoFamiliarDAO");
    }

    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Entorno Familiar");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xEntornoFamiliar");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.historia.JIFEntornoFamiliar.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFEntornoFamiliar.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setForeground(Color.blue);
        this.JCEstado.setText("Estado");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(34, 34, 34).addComponent(this.JTFNombre, -2, 303, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCEstado).addContainerGap(36, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCEstado).addComponent(this.JTFNombre, -2, 50, -2)).addContainerGap(31, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIFEntornoFamiliar.2
            public void mouseClicked(MouseEvent evt) {
                JIFEntornoFamiliar.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JSPDetalle, -2, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -1, 208, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCEstado.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2)).booleanValue());
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "Estado"}) { // from class: com.genoma.plus.controller.historia.JIFEntornoFamiliar.3
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(70);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<EntornoFamiliarDTO> listadoE = this.xEntornoF.listadoEntorno();
        for (int x = 0; x < listadoE.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(Integer.valueOf(listadoE.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(listadoE.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(Boolean.valueOf(listadoE.get(x).isEstado()), x, 2);
        }
    }

    public void mNuevo() {
        this.JCEstado.setSelected(true);
        this.JTFNombre.setText("");
        Principal.mLimpiarDatosP();
        mCargarDatos();
    }

    public void mGrabar() {
        System.out.println("graba");
        if (!this.JTFNombre.getText().isEmpty()) {
            EntornoFamiliarDTO xEntornof = new EntornoFamiliarDTO();
            xEntornof.setNombre(this.JTFNombre.getText());
            xEntornof.setEstado(this.JCEstado.isSelected());
            xEntornof.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    this.xEntornoF.mCrear(xEntornof);
                } else {
                    xEntornof.setId(Integer.parseInt(Principal.txtNo.getText()));
                    this.xEntornoF.mUpdate(xEntornof);
                }
            }
        }
        mNuevo();
    }
}
