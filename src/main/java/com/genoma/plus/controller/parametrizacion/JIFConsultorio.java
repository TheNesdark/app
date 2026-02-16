package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.parametrizacion.ConsultorioDAOImpl;
import com.genoma.plus.dao.parametrizacion.ConsultorioDAO;
import com.genoma.plus.dto.parametrizacion.ConsultorioDTO;
import com.genoma.plus.jpa.entities.GSedes;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFConsultorio.class */
public class JIFConsultorio extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] claseConsultorio;
    private Metodos xmetodos = new Metodos();
    private ConsultorioDAO consultorioDAO;
    private List<GSedes> listSede;
    private JComboBox JCBClaseConsultorio;
    private JComboBox JCBSede;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTextField JTFObservacion;
    private JTextField JTFUbicacion;

    public JIFConsultorio() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.consultorioDAO = (ConsultorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("consultorioDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFObservacion.setText("");
        this.JTFUbicacion.setText("");
        this.JCBSede.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
        LlenarCombosGenericos<GSedes> combosGenericos = new LlenarCombosGenericos<>();
        this.listSede = combosGenericos.getListComboLleno("sedeServicio");
        this.JCBSede.removeAllItems();
        this.listSede.forEach(e -> {
            this.JCBSede.addItem(e.getNbre());
        });
        List<Object[]> listadoClaseConsultorio = this.consultorioDAO.listClaseConsultorios();
        this.claseConsultorio = new String[listadoClaseConsultorio.size()];
        this.JCBClaseConsultorio.removeAllItems();
        for (int z = 0; z < listadoClaseConsultorio.size(); z++) {
            this.JCBClaseConsultorio.addItem(listadoClaseConsultorio.get(z)[1].toString());
            this.claseConsultorio[z] = listadoClaseConsultorio.get(z)[0].toString();
        }
        mCargarDatosTabla();
        this.JTFNombre.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBClaseConsultorio.getSelectedIndex() != -1) {
                if (this.JCBSede.getSelectedIndex() != -1) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (Principal.txtNo.getText().isEmpty()) {
                            ConsultorioDTO consultorioDTO = new ConsultorioDTO();
                            consultorioDTO.setNbre(this.JTFNombre.getText().toUpperCase());
                            if (this.JTFUbicacion.getText().isEmpty()) {
                                consultorioDTO.setUbicacion("");
                            } else {
                                consultorioDTO.setUbicacion(this.JTFUbicacion.getText());
                            }
                            consultorioDTO.setId_ClaseCons(Integer.parseInt(this.claseConsultorio[this.JCBSede.getSelectedIndex()]));
                            if (this.JTFObservacion.getText().isEmpty()) {
                                consultorioDTO.setObservacion("");
                            } else {
                                consultorioDTO.setObservacion(this.JTFObservacion.getText());
                            }
                            if (this.JCHEstado.isSelected()) {
                                consultorioDTO.setEstado(0);
                            } else {
                                consultorioDTO.setEstado(1);
                            }
                            consultorioDTO.setFecha(this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()));
                            consultorioDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                            consultorioDTO.setIdSede(this.listSede.get(this.JCBSede.getSelectedIndex()).getId());
                            this.consultorioDAO.addConsultorio(consultorioDTO);
                        } else {
                            ConsultorioDTO consultorioDTO2 = new ConsultorioDTO();
                            consultorioDTO2.setNbre(this.JTFNombre.getText().toUpperCase());
                            if (this.JTFUbicacion.getText().isEmpty()) {
                                consultorioDTO2.setUbicacion("");
                            } else {
                                consultorioDTO2.setUbicacion(this.JTFUbicacion.getText());
                            }
                            consultorioDTO2.setUbicacion(this.JTFUbicacion.getText());
                            consultorioDTO2.setId_ClaseCons(Integer.parseInt(this.claseConsultorio[this.JCBSede.getSelectedIndex()]));
                            if (this.JTFObservacion.getText().isEmpty()) {
                                consultorioDTO2.setObservacion("");
                            } else {
                                consultorioDTO2.setObservacion(this.JTFObservacion.getText());
                            }
                            if (this.JCHEstado.isSelected()) {
                                consultorioDTO2.setEstado(0);
                            } else {
                                consultorioDTO2.setEstado(1);
                            }
                            consultorioDTO2.setFecha(this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()));
                            consultorioDTO2.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                            consultorioDTO2.setIdSede(this.listSede.get(this.JCBSede.getSelectedIndex()).getId());
                            consultorioDTO2.setId(Integer.parseInt(Principal.txtNo.getText()));
                            this.consultorioDAO.updateConsultorio(consultorioDTO2);
                        }
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una sede", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBSede.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la clase de consultorio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBClaseConsultorio.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNombre.requestFocus();
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: com.genoma.plus.controller.parametrizacion.JIFConsultorio.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        String[] xencabezado = {"Id", "Clase Consultorio", "Consultorio", "Ubicacion", "Observación", "Estado", "sede"};
        mCrearModeloDatos(xencabezado);
        List<Object[]> listadoConsultorios = this.consultorioDAO.listConsultorios();
        for (int x = 0; x < listadoConsultorios.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int y = 0; y < 7; y++) {
                this.xmodelo.setValueAt(listadoConsultorios.get(x)[y], x, y);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v35, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCBClaseConsultorio = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JTFUbicacion = new JTextField();
        this.JCBSede = new JComboBox();
        this.JTFObservacion = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSULTORIO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFConsultorio");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClaseConsultorio.setFont(new Font("Arial", 1, 12));
        this.JCBClaseConsultorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase Consultorio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFConsultorio.2
            public void actionPerformed(ActionEvent evt) {
                JIFConsultorio.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFUbicacion.setFont(new Font("Arial", 1, 12));
        this.JTFUbicacion.setToolTipText("");
        this.JTFUbicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFObservacion.setFont(new Font("Arial", 1, 12));
        this.JTFObservacion.setToolTipText("");
        this.JTFObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFObservacion).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre, -1, 317, 32767).addComponent(this.JTFUbicacion)).addGap(28, 28, 28).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBClaseConsultorio, 0, 378, 32767).addComponent(this.JCBSede, 0, -1, 32767)).addGap(2, 2, 2).addComponent(this.JCHEstado))).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JTFNombre, -2, 50, -2)).addComponent(this.JCBClaseConsultorio)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.JCBSede, -2, 50, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFUbicacion, -2, 50, -2))).addGap(18, 18, 18).addComponent(this.JTFObservacion, -2, 50, -2).addGap(18, 18, 18)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFConsultorio.3
            public void mouseClicked(MouseEvent evt) {
                JIFConsultorio.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 241, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JCBClaseConsultorio.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFUbicacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFUbicacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue());
            this.JCBSede.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
        }
    }
}
