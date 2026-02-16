package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.UnidadMedidaDAO;
import com.genoma.plus.dao.impl.general.UnidadMedidaDAOImpl;
import com.genoma.plus.dto.general.UnidadMedidaDTO;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFUnidadMedida.class */
public class JIFUnidadMedida extends JInternalFrame {
    private int xEstado = 1;
    private DefaultTableModel xmodelo;
    private UnidadMedidaDAO xUnidadMedidaDAO;
    private Object[] xDato;
    private JCheckBox JCHEstado;
    private JPanel JPInformacion;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFCodigoInvima;
    private JTextField JTFDescripcion;
    private JTextField JTFNombre;

    public JIFUnidadMedida() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xUnidadMedidaDAO = (UnidadMedidaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("unidadMedidaDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFCodigoInvima.setText("");
        this.JTFDescripcion.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 0;
        this.JTFCodigo.setText("");
        mBuscaDatos();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                UnidadMedidaDTO e = new UnidadMedidaDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setNInvima(this.JTFCodigoInvima.getText());
                    e.setDescripcion(this.JTFDescripcion.getText());
                    e.setEstado(this.xEstado);
                    e.setCodigo(Integer.valueOf(this.JTFCodigo.getText()));
                    this.xUnidadMedidaDAO.mCreate(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setNInvima(this.JTFCodigoInvima.getText());
                    e.setDescripcion(this.JTFDescripcion.getText());
                    e.setEstado(this.xEstado);
                    e.setId(Long.valueOf(Principal.txtNo.getText()));
                    e.setCodigo(Integer.valueOf(this.JTFCodigo.getText()));
                    this.xUnidadMedidaDAO.mUpdate(e);
                }
                mNuevo();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar la unidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Unidad", "Descripcion", "Codigo Invima", "Estado", "Codigo"}) { // from class: com.genoma.plus.controller.general.JIFUnidadMedida.1
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(30);
    }

    private void mBuscaDatos() {
        mModelo();
        List<UnidadMedidaDTO> list = this.xUnidadMedidaDAO.mListar();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getDescripcion(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getNInvima(), x, 3);
            if (list.get(x).getEstado() == 0) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
            this.xmodelo.setValueAt(list.get(x).getCodigo(), x, 5);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPInformacion = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFDescripcion = new JTextField();
        this.JTFCodigoInvima = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFCodigo = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("UNIDAD DE MEDIDA");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifunidadmedida");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setForeground(Color.black);
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setToolTipText("");
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFUnidadMedida.2
            public void mouseClicked(MouseEvent evt) {
                JIFUnidadMedida.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFUnidadMedida.3
            public void actionPerformed(ActionEvent evt) {
                JIFUnidadMedida.this.JTFNombreActionPerformed(evt);
            }
        });
        this.JTFDescripcion.setFont(new Font("Arial", 1, 12));
        this.JTFDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripcion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoInvima.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoInvima.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo Invima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFUnidadMedida.4
            public void actionPerformed(ActionEvent evt) {
                JIFUnidadMedida.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFDescripcion).addGroup(JPInformacionLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 158, -2).addGap(18, 18, 18).addComponent(this.JTFCodigoInvima, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JTFCodigo, -2, 130, -2).addGap(33, 33, 33).addComponent(this.JCHEstado).addGap(0, 0, 32767))).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFCodigoInvima, -2, 50, -2).addComponent(this.JTFCodigo, -2, 50, -2))).addGroup(JPInformacionLayout.createSequentialGroup().addGap(21, 21, 21).addComponent(this.JCHEstado))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFDescripcion, -2, 50, -2).addGap(10, 10, 10)));
        this.JTFCodigo.getAccessibleContext().setAccessibleName("Codigo");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPInformacion, -1, -1, 32767).addComponent(this.JSPDetalle, -2, 628, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDetalle, -2, 336, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFDescripcion.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFCodigoInvima.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString())) {
                this.xEstado = 0;
                this.JCHEstado.setSelected(true);
            } else {
                this.xEstado = 1;
                this.JCHEstado.setSelected(false);
            }
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xEstado = 0;
        } else {
            this.xEstado = 1;
        }
    }
}
