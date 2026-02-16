package com.genoma.plus.controller.laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.TipoResultadoDTO;
import com.genoma.plus.jpa.projection.ITipoResultado;
import com.genoma.plus.jpa.repository.ITipoResultadoDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JIFTipoResultado.class */
public class JIFTipoResultado extends JInternalFrame {
    private Object[] xdatos;
    private List<ITipoResultado> listaTipoResultados;
    private DefaultTableModel xmodelo;
    private JComboBox<String> JCBTipoResultado;
    private JCheckBox JCHAlerta;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private Metodos xmt = new Metodos();
    private final ITipoResultadoDAO xITipoResultadoDAO = (ITipoResultadoDAO) Principal.contexto.getBean(ITipoResultadoDAO.class);
    int xestado = 0;
    int xestado1 = 0;
    int xestado2 = 1;

    public JIFTipoResultado() {
        initComponents();
        mNuevo();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JCBTipoResultado.setSelectedIndex(-1);
        this.JCHAlerta.setText("Alerta?");
        this.JCHEstado.setText("Estado?");
        this.xestado = 1;
        this.xestado1 = 0;
        this.xestado2 = 0;
        this.JCHAlerta.setSelected(false);
        this.JCHEstado.setSelected(true);
        this.JTFNombre.requestFocus();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBTipoResultado.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    TipoResultadoDTO e = new TipoResultadoDTO();
                    e.setNbre(this.JTFNombre.getText());
                    e.setVandera(Integer.valueOf(this.JCBTipoResultado.getSelectedIndex()));
                    e.setGeneraAlerta(Boolean.valueOf(!this.JCHAlerta.isSelected()));
                    e.setEstado(Boolean.valueOf(!this.JCHEstado.isSelected()));
                    e.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    if (Principal.txtNo.getText().isEmpty()) {
                        this.xITipoResultadoDAO.grabar(e);
                    } else {
                        e.setId(Long.valueOf(Principal.txtNo.getText()));
                        this.xITipoResultadoDAO.grabar(e);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de resultado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoResultado.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Resultado", "Alerta", "Estado"}) { // from class: com.genoma.plus.controller.laboratorio.JIFTipoResultado.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(340);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    private void mCargarDatosTabla() {
        mCrearModeloDatos();
        this.listaTipoResultados = this.xITipoResultadoDAO.consultarTiposDeResultados();
        if (!this.listaTipoResultados.isEmpty()) {
            for (int i = 0; i < this.listaTipoResultados.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listaTipoResultados.get(i).getId(), i, 0);
                this.xmodelo.setValueAt(this.listaTipoResultados.get(i).getNbre(), i, 1);
                this.xmodelo.setValueAt(this.listaTipoResultados.get(i).getResultado(), i, 2);
                this.xmodelo.setValueAt(Boolean.valueOf(!this.listaTipoResultados.get(i).getGeneraAlerta().booleanValue()), i, 3);
                this.xmodelo.setValueAt(Boolean.valueOf(!this.listaTipoResultados.get(i).getEstado().booleanValue()), i, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHAlerta = new JCheckBox();
        this.JCHEstado = new JCheckBox();
        this.JCBTipoResultado = new JComboBox<>();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE RESULTADO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftiporesultado");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHAlerta.setFont(new Font("Arial", 1, 12));
        this.JCHAlerta.setSelected(true);
        this.JCHAlerta.setText("Alerta?");
        this.JCHAlerta.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFTipoResultado.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoResultado.this.JCHAlertaActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JIFTipoResultado.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoResultado.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCBTipoResultado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoResultado.setModel(new DefaultComboBoxModel(new String[]{"NUMÉRICO", "SELECTIVO", "DESCRIPTIVO"}));
        this.JCBTipoResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -1, 406, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoResultado, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado).addComponent(this.JCHAlerta)).addGap(18, 18, 18)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHAlerta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCBTipoResultado, -2, 50, -2))).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.laboratorio.JIFTipoResultado.4
            public void mouseClicked(MouseEvent evt) {
                JIFTipoResultado.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 311, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAlertaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBTipoResultado.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHAlerta.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
        }
    }
}
