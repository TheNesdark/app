package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.parametrizacion.ProcedimientoPorCentroDeCostoDAOImpl;
import com.genoma.plus.dao.parametrizacion.ProcedimientoPorCentroDeCostoDAO;
import com.genoma.plus.dto.parametrizacion.ProcedimientoPorCentroDeCostoDTO;
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
import javax.swing.JButton;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFProcedimientoPorCentroDeCosto.class */
public class JIFProcedimientoPorCentroDeCosto extends JInternalFrame {
    private Metodos xmetodos = new Metodos();
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] centroDeCosto;
    private ProcedimientoPorCentroDeCostoDAO procedimientoPorCentroDeCostoDAO;
    private JButton JBGuardar;
    private JComboBox JCBCentroCosto;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    public JTable JTDetalle;
    private JTextField JTFCCredito;
    private JTextField JTFCDebito;

    public JIFProcedimientoPorCentroDeCosto() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.procedimientoPorCentroDeCostoDAO = (ProcedimientoPorCentroDeCostoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("procedimientoPorCentroDeCostoDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: com.genoma.plus.controller.parametrizacion.JIFProcedimientoPorCentroDeCosto.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(1);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        String[] xencabezado = {"Id Procedimiento", "Procedimiento", "Id Centro Costo", "Centro Costo", "Cuenta Debito", "Cuenta Credito", "Estado"};
        mCrearModeloDatos(xencabezado);
        List<Object[]> ListadoProcedimientoPorCentroDeCosto = this.procedimientoPorCentroDeCostoDAO.listProcedimientoPorCentroCosto(Principal.txtNo.getText());
        for (int x = 0; x < ListadoProcedimientoPorCentroDeCosto.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int y = 0; y < 7; y++) {
                this.xmodelo.setValueAt(ListadoProcedimientoPorCentroDeCosto.get(x)[y], x, y);
            }
        }
        List<Object[]> ListadoCentroDeCosto = this.procedimientoPorCentroDeCostoDAO.listCentroDeCosto();
        this.centroDeCosto = new String[ListadoCentroDeCosto.size()];
        this.JCBCentroCosto.removeAllItems();
        for (int z = 0; z < ListadoCentroDeCosto.size(); z++) {
            this.JCBCentroCosto.addItem(ListadoCentroDeCosto.get(z)[1].toString());
            this.centroDeCosto[z] = ListadoCentroDeCosto.get(z)[0].toString();
            System.out.println("lista [0]: " + ListadoCentroDeCosto.get(z)[0] + "lista [1]: " + ListadoCentroDeCosto.get(z)[1]);
        }
    }

    public void mNuevo() {
        this.JCHEstado.setSelected(true);
        this.JTFCDebito.setText("");
        this.JTFCCredito.setText("");
        this.JCBCentroCosto.setSelectedIndex(-1);
        mCargarDatosTabla();
    }

    public void mGrabar() {
        System.out.println("grabar");
        System.out.println("CB index" + this.JCBCentroCosto.getSelectedIndex() + " " + this.JCBCentroCosto.getSelectedItem().toString());
        if (this.JCBCentroCosto.getSelectedIndex() >= 0) {
            ProcedimientoPorCentroDeCostoDTO procedimientoPorCentroDeCostoDTO = new ProcedimientoPorCentroDeCostoDTO();
            procedimientoPorCentroDeCostoDTO.setCDebito(this.JTFCDebito.getText());
            procedimientoPorCentroDeCostoDTO.setCCredito(this.JTFCCredito.getText());
            procedimientoPorCentroDeCostoDTO.setEstado(this.JCHEstado.isSelected());
            procedimientoPorCentroDeCostoDTO.setUsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
            procedimientoPorCentroDeCostoDTO.setId_CentroCosto(Integer.parseInt(this.centroDeCosto[this.JCBCentroCosto.getSelectedIndex()]));
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (Principal.txtNo.getText().isEmpty()) {
                    this.procedimientoPorCentroDeCostoDAO.addProcedimientoPorCentroCosto(procedimientoPorCentroDeCostoDTO);
                    System.out.println("addProcedimiento   vacio \n");
                } else {
                    procedimientoPorCentroDeCostoDTO.setId_Procedimiento(Integer.parseInt(Principal.txtNo.getText()));
                    List<Object[]> ListadoProcedimientoEnCentroCosto = this.procedimientoPorCentroDeCostoDAO.listProcedimientoEnCentroCosto(Integer.toString(procedimientoPorCentroDeCostoDTO.getId_Procedimiento()), Integer.toString(procedimientoPorCentroDeCostoDTO.getId_CentroCosto()));
                    int registrosConsulta = ListadoProcedimientoEnCentroCosto.size();
                    if (registrosConsulta == 0) {
                        System.out.println("No existe, guardando nuevo");
                        this.procedimientoPorCentroDeCostoDAO.addProcedimientoPorCentroCosto(procedimientoPorCentroDeCostoDTO);
                    } else if (registrosConsulta == 1) {
                        System.out.println("Existe un registro, Actualizando");
                        this.procedimientoPorCentroDeCostoDAO.updateProcedimientoPorCentroCosto(procedimientoPorCentroDeCostoDTO);
                    } else {
                        System.out.println("Registros repetidos, error al guardar");
                    }
                    System.out.println("addProcedimiento   lleno \n");
                }
            }
        } else {
            this.xmetodos.mostrarMensajeError("Error al guardar");
        }
        mNuevo();
    }

    public void mCambiarItemSeleccionadoComboBox(String[] indices, int indiceTabla) {
        for (int i = 0; i < indices.length; i++) {
            if (indiceTabla == Integer.parseInt(indices[i])) {
                System.out.println("indice de tabla: " + i);
                this.JCBCentroCosto.setSelectedIndex(i);
                return;
            }
        }
        System.out.println("no pudo cambiar el combobox");
    }

    /* JADX WARN: Type inference failed for: r3v37, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JCBCentroCosto = new JComboBox();
        this.JCHEstado = new JCheckBox();
        this.JTFCDebito = new JTextField();
        this.JTFCCredito = new JTextField();
        this.JBGuardar = new JButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PROCEDIMIENTO POR CENTRO DE COSTO");
        setFont(new Font("Arial", 1, 12));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFProcedimientoPorCentroDeCosto.2
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoPorCentroDeCosto.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFCDebito.setFont(new Font("Arial", 1, 12));
        this.JTFCDebito.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Debito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCCredito.setFont(new Font("Arial", 1, 12));
        this.JTFCCredito.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Credito", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFProcedimientoPorCentroDeCosto.3
            public void actionPerformed(ActionEvent evt) {
                JIFProcedimientoPorCentroDeCosto.this.JBGuardarActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCentroCosto, 0, -1, 32767).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFCDebito, -2, 200, -2).addGap(18, 18, 18).addComponent(this.JTFCCredito, -2, 200, -2).addGap(0, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado, -2, 100, -2).addComponent(this.JBGuardar)).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCentroCosto, -2, 50, -2).addComponent(this.JCHEstado, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDebito, -2, 50, -2).addComponent(this.JTFCCredito, -2, 50, -2).addComponent(this.JBGuardar, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFProcedimientoPorCentroDeCosto.4
            public void mouseClicked(MouseEvent evt) {
                JIFProcedimientoPorCentroDeCosto.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING, -1, 583, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 218, -2).addGap(22, 22, 22)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JCBCentroCosto.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTFCDebito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTFCCredito.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString()).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }
}
