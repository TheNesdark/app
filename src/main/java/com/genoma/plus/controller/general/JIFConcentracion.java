package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.IConcentracion;
import com.genoma.plus.jpa.service.IConcentracionService;
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
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFConcentracion.class */
public class JIFConcentracion extends JInternalFrame {
    private Object[] xdatos;
    private List<IConcentracion> listaConcentracion;
    private DefaultTableModel xmodelo;
    private JCheckBox JCHEstado;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFConcentracion;
    private JTextField JTFInvima;
    private Metodos xmt = new Metodos();
    private final IConcentracionService xIConcentracionService = (IConcentracionService) Principal.contexto.getBean(IConcentracionService.class);

    public JIFConcentracion() {
        initComponents();
        nuevo();
    }

    public void nuevo() {
        this.JTFConcentracion.setText("");
        this.JTFInvima.setText("");
        this.JCHEstado.setSelected(true);
        mCargarDatosTabla();
    }

    public void grabar() {
        if (!this.JTFConcentracion.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                IConcentracion e = new IConcentracion();
                e.setNbre(this.JTFConcentracion.getText());
                e.setNInvima(this.JTFInvima.getText());
                e.setEstado(Boolean.valueOf(!this.JCHEstado.isSelected()));
                e.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                e.setFecha(this.xmt.getFechaActual());
                if (this.JTDetalle.getSelectedRow() != -1) {
                    e.setId(Integer.valueOf(Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString())));
                }
                this.xIConcentracionService.save(e);
                mCargarDatosTabla();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe digitar el nombre de la concentracion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFConcentracion.requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Concentracíon", "Invima", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFConcentracion.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        this.listaConcentracion = this.xIConcentracionService.listarConcentracion();
        if (!this.listaConcentracion.isEmpty()) {
            for (int i = 0; i < this.listaConcentracion.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.listaConcentracion.get(i).getId(), i, 0);
                this.xmodelo.setValueAt(this.listaConcentracion.get(i).getNbre(), i, 1);
                this.xmodelo.setValueAt(this.listaConcentracion.get(i).getNInvima(), i, 2);
                this.xmodelo.setValueAt(Boolean.valueOf(!this.listaConcentracion.get(i).getEstado().booleanValue()), i, 3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPInformacion = new JPanel();
        this.JTFInvima = new JTextField();
        this.JTFConcentracion = new JTextField();
        this.JCHEstado = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("CONCENTRACÍON");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifconcentracion");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFConcentracion.2
            public void mouseClicked(MouseEvent evt) {
                JIFConcentracion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFInvima.setFont(new Font("Arial", 1, 12));
        this.JTFInvima.setBorder(BorderFactory.createTitledBorder((Border) null, "Invima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFConcentracion.setFont(new Font("Arial", 1, 12));
        this.JTFConcentracion.setBorder(BorderFactory.createTitledBorder((Border) null, "Concentracíon", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFConcentracion.3
            public void actionPerformed(ActionEvent evt) {
                JIFConcentracion.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFConcentracion, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFInvima, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstado).addContainerGap(-1, 32767)));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFConcentracion, -2, 50, -2).addComponent(this.JTFInvima, -2, 50, -2).addComponent(this.JCHEstado)).addGap(10, 10, 10)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JSPDetalle, -2, 599, -2)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDetalle, -2, 304, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFConcentracion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFInvima.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()));
        }
    }
}
