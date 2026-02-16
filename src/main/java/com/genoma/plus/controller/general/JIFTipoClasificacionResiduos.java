package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoClasificacionResiduosDAO;
import com.genoma.plus.dao.impl.general.TipoClasificacionResiduosDAOImpl;
import com.genoma.plus.dto.general.TipoClasificacionResiduosDTO;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoClasificacionResiduos.class */
public class JIFTipoClasificacionResiduos extends JInternalFrame {
    private int xEstado = 1;
    private DefaultTableModel xmodelo;
    private TipoClasificacionResiduosDAO xTipoClasificacionResiduosDAO;
    private Object[] xDato;
    private JCheckBox JCHEstado;
    private JPanel JPinformacion;
    private JScrollPane JSPDetalle;
    private JSpinner JSPOrden;
    private JTable JTDetalle;
    private JTextField JTFClasificacion;
    private JTextField JTFEncabezado;
    private JTextField JTFNombre;

    public JIFTipoClasificacionResiduos() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoClasificacionResiduosDAO = (TipoClasificacionResiduosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoClasificacionResiduosDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFEncabezado.setText("");
        this.JTFClasificacion.setText("");
        this.JSPOrden.setValue(0);
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        mBuscaDatos();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoClasificacionResiduosDTO e = new TipoClasificacionResiduosDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setEncabezado(this.JTFEncabezado.getText());
                    e.setClasificacion(this.JTFClasificacion.getText().toUpperCase());
                    e.setOrden(Integer.valueOf(this.JSPOrden.getValue().toString()).intValue());
                    e.setEstado(this.xEstado);
                    this.xTipoClasificacionResiduosDAO.mCreate(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setEncabezado(this.JTFEncabezado.getText());
                    e.setClasificacion(this.JTFClasificacion.getText().toUpperCase());
                    e.setOrden(Integer.valueOf(this.JSPOrden.getValue().toString()).intValue());
                    e.setEstado(this.xEstado);
                    e.setId(Long.valueOf(Principal.txtNo.getText()));
                    this.xTipoClasificacionResiduosDAO.mUpdate(e);
                }
                mBuscaDatos();
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar el Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Encabezado", "Clasificacion", "Orden", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFTipoClasificacionResiduos.1
            Class[] types = {Long.class, String.class, String.class, String.class, Integer.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
    }

    private void mBuscaDatos() {
        mModelo();
        List<TipoClasificacionResiduosDTO> list = this.xTipoClasificacionResiduosDAO.listClasificacionResiduos();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getEncabezado(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getClasificacion(), x, 3);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getOrden()), x, 4);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 5);
            } else {
                this.xmodelo.setValueAt(false, x, 5);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v43, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPinformacion = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFClasificacion = new JTextField();
        this.JTFEncabezado = new JTextField();
        this.JSPOrden = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE CLASIFICACION DE RESIDUOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipoclasificacionresiduos");
        this.JPinformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFClasificacion.setFont(new Font("Arial", 1, 12));
        this.JTFClasificacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFEncabezado.setFont(new Font("Arial", 1, 12));
        this.JTFEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoClasificacionResiduos.2
            public void actionPerformed(ActionEvent evt) {
                JIFTipoClasificacionResiduos.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPinformacionLayout = new GroupLayout(this.JPinformacion);
        this.JPinformacion.setLayout(JPinformacionLayout);
        JPinformacionLayout.setHorizontalGroup(JPinformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPinformacionLayout.createSequentialGroup().addGroup(JPinformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNombre, -1, 504, 32767).addComponent(this.JTFEncabezado).addComponent(this.JTFClasificacion)).addGap(11, 11, 11).addGroup(JPinformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPinformacionLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(10, 10, 10)).addGroup(JPinformacionLayout.createSequentialGroup().addComponent(this.JSPOrden, -2, 117, -2).addGap(10, 10, 10))).addContainerGap(-1, 32767)));
        JPinformacionLayout.setVerticalGroup(JPinformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPinformacionLayout.createSequentialGroup().addGroup(JPinformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JSPOrden, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPinformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFEncabezado, -2, 50, -2).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFClasificacion, -2, 50, -2).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoClasificacionResiduos.3
            public void mouseClicked(MouseEvent evt) {
                JIFTipoClasificacionResiduos.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, -2, 654, -2).addComponent(this.JPinformacion, -1, -1, -2)).addGap(10, 10, 10)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPinformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 338, -2).addGap(10, 10, 10)));
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFEncabezado.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFClasificacion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JSPOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()));
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xEstado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.xEstado = 0;
            }
        }
    }
}
