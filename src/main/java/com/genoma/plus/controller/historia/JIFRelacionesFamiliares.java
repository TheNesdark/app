package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.historia.RelacionesFamiliaresDAO;
import com.genoma.plus.dao.impl.historia.RelacionesFamiliaresDAOImpl;
import com.genoma.plus.dto.historia.RelacionesFamiliaresDTO;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JIFRelacionesFamiliares.class */
public class JIFRelacionesFamiliares extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Metodos xmt = new Metodos();
    private Object[] xdatos;
    private RelacionesFamiliaresDAO xRelacionesFamiliaresDAO;
    private JCheckBox JCEstado;
    private JSpinner JSTipo;
    private JSpinner JSTipoLinea;
    private JTable JTDetalle;
    private JTextField JTFAbreviatura;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFRelacionesFamiliares() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xRelacionesFamiliaresDAO = (RelacionesFamiliaresDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("RFamiliaresDAO");
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSTipo = new JSpinner();
        this.JSTipoLinea = new JSpinner();
        this.JCEstado = new JCheckBox();
        this.JTFAbreviatura = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Relaciones Familiares");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xJIFRelacionesFamiliares");
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.historia.JIFRelacionesFamiliares.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRelacionesFamiliares.this.formInternalFrameClosing(evt);
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
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Datos", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 0, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSTipo.setFont(new Font("Arial", 1, 12));
        this.JSTipo.setModel(new SpinnerNumberModel(0, 0, 2, 1));
        this.JSTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSTipoLinea.setFont(new Font("Arial", 1, 12));
        this.JSTipoLinea.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Linea", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCEstado.setFont(new Font("Arial", 1, 12));
        this.JCEstado.setForeground(Color.blue);
        this.JCEstado.setText("Estado");
        this.JTFAbreviatura.setBorder(BorderFactory.createTitledBorder((Border) null, "Abreviatura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -2, 156, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAbreviatura).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSTipoLinea, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSTipo, -2, 73, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCEstado)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCEstado).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFAbreviatura, -2, 44, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JSTipo, -2, 50, -2).addComponent(this.JSTipoLinea, -2, 50, -2))).addGap(0, 40, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 0, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JIFRelacionesFamiliares.2
            public void mouseClicked(MouseEvent evt) {
                JIFRelacionesFamiliares.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1, -1, 530, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 311, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFAbreviatura.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JSTipoLinea.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3));
            this.JSTipo.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4));
            this.JCEstado.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5)).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Nombre", "Abreviatura", "Tipo Linea", "tipo", "Estado"}) { // from class: com.genoma.plus.controller.historia.JIFRelacionesFamiliares.3
            Class[] types = {Integer.class, String.class, String.class, Integer.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(90);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(90);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(70);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<RelacionesFamiliaresDTO> listaRFamiliares = this.xRelacionesFamiliaresDAO.listadoRelaciones();
        for (int x = 0; x < listaRFamiliares.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(Integer.valueOf(listaRFamiliares.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(listaRFamiliares.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(listaRFamiliares.get(x).getAbreviatura(), x, 2);
            this.xmodelo.setValueAt(Integer.valueOf(listaRFamiliares.get(x).getTipoLinea()), x, 3);
            this.xmodelo.setValueAt(Integer.valueOf(listaRFamiliares.get(x).getTipo()), x, 4);
            this.xmodelo.setValueAt(Boolean.valueOf(listaRFamiliares.get(x).isEstado()), x, 5);
        }
    }

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JSTipoLinea.setValue(0);
        this.JTFAbreviatura.setText("");
        this.JSTipo.setValue(0);
        this.JCEstado.setSelected(true);
        Principal.mLimpiarDatosP();
        mCargarDatos();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTFAbreviatura.getText().isEmpty()) {
                if (((Integer) this.JSTipoLinea.getValue()).intValue() > -1) {
                    if (!this.xRelacionesFamiliaresDAO.existeAbreviatura(this.JTFAbreviatura.getText())) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            RelacionesFamiliaresDTO xRFamilares = new RelacionesFamiliaresDTO();
                            xRFamilares.setNombre(this.JTFNombre.getText());
                            xRFamilares.setAbreviatura(this.JTFAbreviatura.getText());
                            xRFamilares.setTipoLinea(((Integer) this.JSTipoLinea.getValue()).intValue());
                            xRFamilares.setTipo(((Integer) this.JSTipo.getValue()).intValue());
                            xRFamilares.setEstado(this.JCEstado.isSelected());
                            xRFamilares.setIdUsuario(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                            if (Principal.txtNo.getText().isEmpty()) {
                                this.xRelacionesFamiliaresDAO.mCreate(xRFamilares);
                            } else {
                                xRFamilares.setId(Integer.parseInt(Principal.txtNo.getText()));
                                this.xRelacionesFamiliaresDAO.mUpdate(xRFamilares);
                            }
                            mNuevo();
                            return;
                        }
                        return;
                    }
                    this.xmt.mostrarMensaje("Esta abreviatura ya esta en uso");
                    return;
                }
                this.xmt.mostrarMensaje("El campo Tipo de linea tiene un valor no valido ");
                return;
            }
            this.xmt.mostrarMensaje("El campo Nombre es Obligatorio");
            return;
        }
        this.xmt.mostrarMensaje("El campo Nombre es Obligatorio");
    }
}
