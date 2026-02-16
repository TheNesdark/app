package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.SedeResolucionDianDTO;
import com.genoma.plus.jpa.projection.ICargarCombo;
import com.genoma.plus.jpa.projection.ISedeResolucionDian;
import com.genoma.plus.jpa.service.ISedeResolucionDianDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JDSedeResolucionDian.class */
public class JDSedeResolucionDian extends JDialog {
    private final ISedeResolucionDianDAO dao;
    private List<ICargarCombo> sede;
    private List<ICargarCombo> resolucion;
    private SedeResolucionDianDTO dto;
    private Metodos xmt;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private Integer idResolucionDian;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JComboBox<String> JCBSede;
    private JCheckBox JCKEstado;
    private JLabel JLBResolucionDian;
    private JLabel JLB_Titulo;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDSedeResolucionDian(Frame parent, boolean modal) {
        super(parent, modal);
        this.dao = (ISedeResolucionDianDAO) Principal.contexto.getBean(ISedeResolucionDianDAO.class);
        this.xmt = new Metodos();
        initComponents();
        setLocationRelativeTo(null);
        mCargarCombo();
        mCargarTabla();
    }

    private void mCargarCombo() {
        this.sede = this.dao.cargarComboSede();
        this.JCBSede.removeAllItems();
        for (int i = 0; i < this.sede.size(); i++) {
            this.JCBSede.addItem(this.sede.get(i).getNombre());
        }
        this.JCBSede.setSelectedIndex(-1);
        this.resolucion = this.dao.cargarComboResolucion();
        this.JLBResolucionDian.setText(this.resolucion.get(0).getNombre());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "IdSede", "Sede", "IdResolucionDian", "Descripcion", "Prefijo", "FechaInicio", "FechaFinal", "Estado", "Usuario"}) { // from class: com.genoma.plus.controller.parametrizacion.JDSedeResolucionDian.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
        JTable jTable = this.JTDetalle;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
    }

    private void mCargarTabla() {
        List<ISedeResolucionDian> lis = this.dao.cargarSedeResolucionDian();
        mCrearModelo();
        for (int i = 0; i < lis.size(); i++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(lis.get(i).getId(), i, 0);
            this.xmodelo.setValueAt(lis.get(i).getIdSede(), i, 1);
            this.xmodelo.setValueAt(lis.get(i).getSede(), i, 2);
            this.xmodelo.setValueAt(lis.get(i).getIdResolucionDian(), i, 3);
            this.xmodelo.setValueAt(lis.get(i).getDescripcion(), i, 4);
            this.xmodelo.setValueAt(lis.get(i).getPrefijo(), i, 5);
            this.xmodelo.setValueAt(lis.get(i).getFechaInicio(), i, 6);
            this.xmodelo.setValueAt(lis.get(i).getFechaFinal(), i, 7);
            this.xmodelo.setValueAt(lis.get(i).getEstado(), i, 8);
            this.xmodelo.setValueAt(lis.get(i).getUsuario(), i, 9);
        }
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JLB_Titulo = new JLabel();
        this.jPanel1 = new JPanel();
        this.JCBSede = new JComboBox<>();
        this.JCKEstado = new JCheckBox();
        this.JLBResolucionDian = new JLabel();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setDefaultCloseOperation(2);
        setResizable(false);
        this.JLB_Titulo.setBackground(new Color(0, 51, 153));
        this.JLB_Titulo.setFont(new Font("Arial", 1, 14));
        this.JLB_Titulo.setForeground(new Color(204, 255, 204));
        this.JLB_Titulo.setHorizontalAlignment(0);
        this.JLB_Titulo.setText("SEDE RESOLUCIÓN DIAN");
        this.JLB_Titulo.setBorder(BorderFactory.createBevelBorder(0));
        this.JLB_Titulo.setOpaque(true);
        this.jPanel1.setBorder(new SoftBevelBorder(0));
        this.JCBSede.setFont(new Font("Arial", 1, 12));
        this.JCBSede.setBorder(BorderFactory.createTitledBorder((Border) null, "Sede", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSede.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDSedeResolucionDian.2
            public void actionPerformed(ActionEvent evt) {
                JDSedeResolucionDian.this.JCBSedeActionPerformed(evt);
            }
        });
        this.JCKEstado.setSelected(true);
        this.JCKEstado.setText("Estado");
        this.JCKEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDSedeResolucionDian.3
            public void actionPerformed(ActionEvent evt) {
                JDSedeResolucionDian.this.JCKEstadoActionPerformed(evt);
            }
        });
        this.JLBResolucionDian.setFont(new Font("Arial", 1, 12));
        this.JLBResolucionDian.setHorizontalAlignment(0);
        this.JLBResolucionDian.setText("new");
        this.JLBResolucionDian.setBorder(BorderFactory.createTitledBorder(""));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBSede, -2, 394, -2).addGap(18, 18, 18).addComponent(this.JCKEstado).addGap(0, 9, 32767)).addComponent(this.JLBResolucionDian, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JLBResolucionDian, -1, 51, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBSede, -2, 57, -2).addComponent(this.JCKEstado)).addContainerGap()));
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("OK");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDSedeResolucionDian.4
            public void actionPerformed(ActionEvent evt) {
                JDSedeResolucionDian.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("SALIR");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JDSedeResolucionDian.5
            public void actionPerformed(ActionEvent evt) {
                JDSedeResolucionDian.this.JBTSalirActionPerformed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JDSedeResolucionDian.6
            public void mouseClicked(MouseEvent evt) {
                JDSedeResolucionDian.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLB_Titulo, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 190, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 190, -2)).addComponent(this.jScrollPane1)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JLB_Titulo, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 150, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGrabar, -2, 41, -2).addComponent(this.JBTSalir)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBSedeActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCKEstadoActionPerformed(ActionEvent evt) {
        this.JCKEstado.setSelected(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (this.JCBSede.getSelectedIndex() != -1) {
            Boolean grabar = true;
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Integer.parseInt(this.xmodelo.getValueAt(i, 1).toString()) == this.sede.get(this.JCBSede.getSelectedIndex()).getId().longValue()) {
                    grabar = false;
                }
            }
            if (grabar.booleanValue()) {
                int confirmar = JOptionPane.showConfirmDialog(this, "¿Seguro que quiere guardar?", "CONFIRMAR", 0, 3);
                if (confirmar == 0) {
                    this.dto = new SedeResolucionDianDTO();
                    this.dto.setId_Sede(Integer.valueOf(Integer.parseInt(this.sede.get(this.JCBSede.getSelectedIndex()).getId().toString())));
                    this.dto.setId_CC_ResolucionD(Integer.valueOf(Integer.parseInt(this.resolucion.get(0).getId().toString())));
                    this.dto.setEstado(Boolean.valueOf(this.JCKEstado.isSelected()));
                    this.dto.setFecha(this.xmt.getFechaActual());
                    this.dto.setId_UsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
                    this.dao.grabar(this.dto);
                    this.JCBSede.setSelectedIndex(-1);
                    mCargarTabla();
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar una sede", "VERIFICAR", 1);
        this.JCBSede.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedColumn() == 8) {
        }
    }
}
