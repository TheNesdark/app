package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.RHTipoCargoDAO;
import com.genoma.plus.dao.impl.general.RHTipoCargoDAOImpl;
import com.genoma.plus.dto.general.RHTipoCargoDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFRHTipoCargo.class */
public class JIFRHTipoCargo extends JInternalFrame {
    private int xEstado = 1;
    private DefaultTableModel xmodelo;
    private RHTipoCargoDAO xRHTipoCargoDAO;
    private Object[] xDato;
    private JCheckBox JCHEstado;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNbreD785;
    private JTextField JTFNombre;
    private JPanel jPanel1;

    public JIFRHTipoCargo() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xRHTipoCargoDAO = (RHTipoCargoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("rHTipoCargoDAO");
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFNbreD785.setText("");
        this.JTFCodigo.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        mBuscaDatos();
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                RHTipoCargoDTO e = new RHTipoCargoDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNbre(this.JTFNombre.getText().toUpperCase());
                    e.setNbreD785(this.JTFNbreD785.getText().toUpperCase());
                    e.setCodigo(this.JTFCodigo.getText().toUpperCase());
                    e.setEstado(this.xEstado);
                    this.xRHTipoCargoDAO.mCreate(e);
                } else {
                    e.setNbre(this.JTFNombre.getText().toUpperCase());
                    e.setNbreD785(this.JTFNbreD785.getText().toUpperCase());
                    e.setCodigo(this.JTFCodigo.getText().toUpperCase());
                    e.setEstado(this.xEstado);
                    e.setId(Long.valueOf(Principal.txtNo.getText()));
                    this.xRHTipoCargoDAO.mUpdate(e);
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
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Nombre D785", "Codigo", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFRHTipoCargo.1
            Class[] types = {Long.class, String.class, String.class, String.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
    }

    private void mBuscaDatos() {
        mModelo();
        List<RHTipoCargoDTO> list = this.xRHTipoCargoDAO.list();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNbre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getNbreD785(), x, 2);
            this.xmodelo.setValueAt(list.get(x).getCodigo(), x, 3);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 4);
            } else {
                this.xmodelo.setValueAt(false, x, 4);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFNbreD785 = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFCodigo = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE CARGO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifrhtipocargo");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFRHTipoCargo.2
            public void mouseClicked(MouseEvent evt) {
                JIFRHTipoCargo.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNbreD785.setFont(new Font("Arial", 1, 12));
        this.JTFNbreD785.setToolTipText("Decreto 785 De La Funcion Publica");
        this.JTFNbreD785.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Para Decreto 785", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFRHTipoCargo.3
            public void actionPerformed(ActionEvent evt) {
                JIFRHTipoCargo.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNbreD785, -1, 466, 32767).addComponent(this.JTFNombre)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigo).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCHEstado).addGap(0, 0, 0))).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JCHEstado)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNbreD785, -2, 50, -2).addComponent(this.JTFCodigo, -2, 50, -2)).addContainerGap(23, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalle, -1, 607, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 270, -2).addGap(10, 10, 10)));
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
            this.JTFNbreD785.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue()) {
                this.JCHEstado.setSelected(true);
                this.xEstado = 1;
            } else {
                this.JCHEstado.setSelected(false);
                this.xEstado = 0;
            }
        }
    }
}
