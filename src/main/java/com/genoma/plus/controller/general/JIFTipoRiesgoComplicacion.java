package com.genoma.plus.controller.general;

import Acceso.Principal;
import Utilidades.CustomPopupMenuListener;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.TipoRiesgoComplicacionDAO;
import com.genoma.plus.dao.impl.general.TipoRiesgoComplicacionDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.TipoRiesgoComplicacionDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoRiesgoComplicacion.class */
public class JIFTipoRiesgoComplicacion extends JInternalFrame {
    private String[] xidClasificacion;
    private DefaultTableModel xmodelo;
    private Object[] xDato;
    private TipoRiesgoComplicacionDAO xTipoRiesgoComplicacionDAO;
    private JComboBox<String> JCBClasificacion;
    private JCheckBox JCHEstado;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPNombre;
    private JTextArea JTANombre;
    private JTable JTDetalle;
    private JPanel jPanel1;
    private int xEstado = 1;
    private Metodos xmt = new Metodos();

    public JIFTipoRiesgoComplicacion() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoRiesgoComplicacionDAO = (TipoRiesgoComplicacionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoRiesgoComplicacionDAO");
    }

    private void mLLenaCombo() {
        this.JCBClasificacion.removeAllItems();
        List<GCGenericoDTO> list1 = this.xTipoRiesgoComplicacionDAO.listClasificacioTipoRiesgoComplicacion();
        this.xidClasificacion = new String[list1.size()];
        for (int x = 0; x < list1.size(); x++) {
            this.xidClasificacion[x] = String.valueOf(list1.get(x).getId());
            this.JCBClasificacion.addItem(list1.get(x).getNombre());
        }
        this.JCBClasificacion.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBClasificacion.setSelectedIndex(-1);
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTANombre.setText("");
        mLLenaCombo();
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        mCargarDatosTabla();
    }

    public void mGuardar() {
        if (!this.JTANombre.getText().equals("")) {
            if (this.JCBClasificacion.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    TipoRiesgoComplicacionDTO e = new TipoRiesgoComplicacionDTO();
                    if (Principal.txtNo.getText().equals("")) {
                        e.setNombre(this.JTANombre.getText());
                        e.setIdTipoClasificacion(this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()]);
                        e.setEstado(this.xEstado);
                        this.xTipoRiesgoComplicacionDAO.mCreatetipoRiesgoComplicacion(e);
                    } else {
                        e.setNombre(this.JTANombre.getText());
                        e.setIdTipoClasificacion(this.xidClasificacion[this.JCBClasificacion.getSelectedIndex()]);
                        e.setEstado(this.xEstado);
                        e.setId(Long.valueOf(Principal.txtNo.getText()).longValue());
                        this.xTipoRiesgoComplicacionDAO.mUpdatetipoRiesgoComplicacion(e);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una clasificacion", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JCBClasificacion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTANombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Clasificacion", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFTipoRiesgoComplicacion.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    private void mCargarDatosTabla() {
        mCrearModeloTabla();
        List<TipoRiesgoComplicacionDTO> list = this.xTipoRiesgoComplicacionDAO.listTipoRiesgoComplicacion(this.JTANombre.getText());
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Long.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getIdTipoClasificacion(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JCBClasificacion = new JComboBox<>();
        this.JCHEstado = new JCheckBox();
        this.JSPNombre = new JScrollPane();
        this.JTANombre = new JTextArea();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO RIESGO DE COMPLICACION");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftiporiesgocomplicacion");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoRiesgoComplicacion.2
            public void mouseClicked(MouseEvent evt) {
                JIFTipoRiesgoComplicacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBClasificacion.setFont(new Font("Arial", 1, 12));
        this.JCBClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Clasificacion de Complicacion de Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoRiesgoComplicacion.3
            public void actionPerformed(ActionEvent evt) {
                JIFTipoRiesgoComplicacion.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JSPNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTANombre.setColumns(20);
        this.JTANombre.setFont(new Font("Arial", 1, 12));
        this.JTANombre.setRows(5);
        this.JTANombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoRiesgoComplicacion.4
            public void keyPressed(KeyEvent evt) {
                JIFTipoRiesgoComplicacion.this.JTANombreKeyPressed(evt);
            }
        });
        this.JSPNombre.setViewportView(this.JTANombre);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPNombre).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBClasificacion, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JSPNombre, -2, 89, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHEstado).addComponent(this.JCBClasificacion, -2, 50, -2)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 640, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 348, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 1;
        } else {
            this.xEstado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTANombreKeyPressed(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTANombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBClasificacion.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.xEstado = 1;
                this.JCHEstado.setSelected(true);
            } else {
                this.xEstado = 0;
                this.JCHEstado.setSelected(false);
            }
        }
    }
}
