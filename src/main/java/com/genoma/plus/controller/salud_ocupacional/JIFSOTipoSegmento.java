package com.genoma.plus.controller.salud_ocupacional;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.salud_ocupacional.SOTipoSegmentoDAOImpl;
import com.genoma.plus.dao.salud_ocupacional.SOTipoSegmentoDAO;
import com.genoma.plus.dto.salud_ocupacional.SOTipoSegmentoDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/salud_ocupacional/JIFSOTipoSegmento.class */
public class JIFSOTipoSegmento extends JInternalFrame {
    private Metodos xmetodos = new Metodos();
    private int xestado = 1;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private File xfile;
    private SOTipoSegmentoDAO xSOTipoSegmentoDAO;
    private String[] xidEmpresa;
    private JComboBox<String> JCBEmpresa;
    private JComboBox<String> JCBTipo;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JSpinner JSNTrabajadores;
    private JScrollPane JSPDetalle;
    private JTextArea JTADescripcion;
    private JTable JTDetalle;
    private JTextField JTFCargoAsociado;
    private JTextField JTFNombre;
    private JTextField JTFSede;
    private JTextField JTFTipodeSeg;
    private JTextField JTFUnidad;
    private JScrollPane jScrollPane1;

    public JIFSOTipoSegmento() {
        initComponents();
        springStart();
        mCargarDatosTabla();
        LLenarCombo();
    }

    /* JADX WARN: Type inference failed for: r3v52, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTADescripcion = new JTextArea();
        this.JCBEmpresa = new JComboBox<>();
        this.JTFUnidad = new JTextField();
        this.JTFCargoAsociado = new JTextField();
        this.JSNTrabajadores = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.JTFSede = new JTextField();
        this.JTFTipodeSeg = new JTextField();
        this.JCBTipo = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("Tipo Segmento");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("JIFSOTipoSegmento");
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOTipoSegmento.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFSOTipoSegmento.this.formInternalFrameClosing(evt);
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
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTADescripcion.setColumns(1);
        this.JTADescripcion.setFont(new Font("Arial", 1, 13));
        this.JTADescripcion.setLineWrap(true);
        this.JTADescripcion.setRows(1);
        this.JTADescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTADescripcion.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOTipoSegmento.2
            public void mouseClicked(MouseEvent evt) {
                JIFSOTipoSegmento.this.JTADescripcionMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTADescripcion);
        this.JCBEmpresa.setFont(new Font("Arial", 1, 12));
        this.JCBEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUnidad.setFont(new Font("Arial", 1, 12));
        this.JTFUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCargoAsociado.setFont(new Font("Arial", 1, 12));
        this.JTFCargoAsociado.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo Asociado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSNTrabajadores.setFont(new Font("Arial", 1, 12));
        this.JSNTrabajadores.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSNTrabajadores.setBorder(BorderFactory.createTitledBorder((Border) null, "NTrabajadores", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setForeground(Color.blue);
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOTipoSegmento.3
            public void actionPerformed(ActionEvent evt) {
                JIFSOTipoSegmento.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFSede.setFont(new Font("Arial", 1, 12));
        this.JTFSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFTipodeSeg.setFont(new Font("Arial", 1, 12));
        this.JTFTipodeSeg.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de segmento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipo.setFont(new Font("Arial", 1, 12));
        this.JCBTipo.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Normal", "Especial"}));
        this.JCBTipo.setSelectedIndex(-1);
        this.JCBTipo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEmpresa, -2, 201, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipo, -2, 128, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSNTrabajadores, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addGap(10, 10, 10)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 447, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFTipodeSeg)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFUnidad, -2, 196, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFSede).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCargoAsociado, -2, 247, -2)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEmpresa, -2, 50, -2).addComponent(this.JTFNombre, -2, 49, -2).addComponent(this.JSNTrabajadores, -2, 50, -2).addComponent(this.JCBTipo, -2, 50, -2)).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(9, 9, 9).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFUnidad, -2, 50, -2).addComponent(this.JTFSede, -2, 50, -2))).addGroup(JPIDatosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCargoAsociado, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFTipodeSeg).addComponent(this.jScrollPane1, -1, 65, 32767)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOTipoSegmento.4
            public void mouseClicked(MouseEvent evt) {
                JIFSOTipoSegmento.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPIDatos, -1, -1, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle).addGap(11, 11, 11)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 306, -2).addContainerGap()));
        pack();
    }

    private void springStart() {
        this.xSOTipoSegmentoDAO = (SOTipoSegmentoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("xTipoSegmentoDAO");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTADescripcion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBEmpresa.setSelectedIndex(idSelecionCombo(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            switch (this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()) {
                case "No Aplica":
                    this.JCBTipo.setSelectedIndex(0);
                    break;
                case "Normal":
                    this.JCBTipo.setSelectedIndex(1);
                    break;
                case "Especial":
                    this.JCBTipo.setSelectedIndex(2);
                    break;
            }
            this.JTFUnidad.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString());
            this.JTFCargoAsociado.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 7).toString());
            this.JTFSede.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JTFTipodeSeg.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 9).toString());
            this.JSNTrabajadores.setValue(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 10));
            this.JCHEstado.setSelected(((Boolean) this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 11)).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTADescripcionMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTADescripcion.setText("");
        this.JTFCargoAsociado.setText("");
        this.JTFSede.setText("");
        this.JTFTipodeSeg.setText("");
        this.JTFUnidad.setText("");
        this.JSNTrabajadores.setValue(0);
        this.JCBEmpresa.setSelectedIndex(-1);
        this.JCBTipo.setSelectedIndex(-1);
        this.JCHEstado.setSelected(true);
    }

    private int idSelecionCombo(String xvalor) {
        int pos = 0;
        for (int x = 0; x < this.xidEmpresa.length; x++) {
            if (xvalor.equals(this.xidEmpresa[x])) {
                pos = x;
            }
        }
        return pos;
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (!this.JTADescripcion.getText().isEmpty()) {
                if (this.JCBEmpresa.getSelectedIndex() != -1) {
                    if (this.JCBTipo.getSelectedIndex() != -1) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            SOTipoSegmentoDTO SoTSegDTO = new SOTipoSegmentoDTO();
                            SoTSegDTO.setNombre(this.JTFNombre.getText());
                            SoTSegDTO.setDescripcion(this.JTADescripcion.getText());
                            SoTSegDTO.setTipo(this.JCBTipo.getSelectedIndex() - 1);
                            SoTSegDTO.setIdTipoEmpresa(this.xidEmpresa[this.JCBEmpresa.getSelectedIndex()]);
                            SoTSegDTO.setUnidad(this.JTFUnidad.getText());
                            SoTSegDTO.setCargoAsociado(this.JTFCargoAsociado.getText());
                            SoTSegDTO.setSede(this.JTFSede.getText());
                            SoTSegDTO.setTiposeg(this.JTFTipodeSeg.getText());
                            SoTSegDTO.setNumTrabajadores(((Integer) this.JSNTrabajadores.getValue()).intValue());
                            SoTSegDTO.setEstado(this.JCHEstado.isSelected());
                            SoTSegDTO.setUsuario(Principal.usuarioSistemaDTO.getLogin());
                            if (Principal.txtNo.getText().isEmpty()) {
                                this.xSOTipoSegmentoDAO.mCreate(SoTSegDTO);
                            } else {
                                SoTSegDTO.setId(Integer.parseInt(Principal.txtNo.getText()));
                                this.xSOTipoSegmentoDAO.mUpdate(SoTSegDTO);
                            }
                            mCargarDatosTabla();
                            mNuevo();
                            return;
                        }
                        this.xmetodos.mostrarMensaje("Por favor selecione un tipo de empresa");
                        return;
                    }
                    return;
                }
                this.xmetodos.mostrarMensaje("Porfavor selecione un tipo de empresa");
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo Descripcion no puede estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTADescripcion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede estar vacio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Descripción", "EsEspecial?", "idTipoEmpresa", "TipoEmpresa", "Unidad", "Cargo Asociado", "sede", "tipoSeg", "NTrabajadores", "Estado"}) { // from class: com.genoma.plus.controller.salud_ocupacional.JIFSOTipoSegmento.5
            Class[] types = {Long.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class, Integer.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(70);
    }

    private void LLenarCombo() {
        List<Object[]> listado = this.xSOTipoSegmentoDAO.listaCombo("SELECT `Id`,`Nbre` FROM `g_tipoempresa`");
        this.xidEmpresa = new String[listado.size()];
        for (int x = 0; x < listado.size(); x++) {
            this.xidEmpresa[x] = listado.get(x)[0].toString();
            this.JCBEmpresa.addItem(listado.get(x)[1].toString());
        }
    }

    private void mCargarDatosTabla() {
        List<Object[]> listaTsegmentos = this.xSOTipoSegmentoDAO.listaTSegmentos();
        mCrearModeloDatos();
        for (int x = 0; x < listaTsegmentos.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 12; j++) {
                if (j == 3) {
                    switch (((Integer) listaTsegmentos.get(x)[j]).intValue()) {
                        case -1:
                            this.xmodelo.setValueAt("No Aplica", x, j);
                            break;
                        case 0:
                            this.xmodelo.setValueAt("Normal", x, j);
                            break;
                        case 1:
                            this.xmodelo.setValueAt("Especial", x, j);
                            break;
                    }
                } else {
                    this.xmodelo.setValueAt(listaTsegmentos.get(x)[j], x, j);
                }
            }
        }
    }
}
