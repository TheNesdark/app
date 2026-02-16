package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.TipoTuboDAO;
import com.genoma.plus.dao.impl.general.TipoTuboDAOImpl;
import com.genoma.plus.dto.general.TipoTuboDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFTipoTubo.class */
public class JIFTipoTubo extends JInternalFrame {
    private int xEstado = 1;
    private DefaultTableModel xmodelo;
    private TipoTuboDAO xTipoTuboDAO;
    private Object[] xDato;
    private JCheckBox JCHEstado;
    private JTable JTDetalle;
    private JTextField JTFAbreviatura;
    private JTextField JTFNombre;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JIFTipoTubo() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xTipoTuboDAO = (TipoTuboDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoTuboDAO");
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFAbreviatura = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("TIPO DE TUBO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjiftipotubo");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 13));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAbreviatura.setFont(new Font("Arial", 1, 13));
        this.JTFAbreviatura.setToolTipText("");
        this.JTFAbreviatura.setBorder(BorderFactory.createTitledBorder((Border) null, "Abreviatura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFTipoTubo.1
            public void actionPerformed(ActionEvent evt) {
                JIFTipoTubo.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 312, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAbreviatura, -2, 125, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 49, -2).addComponent(this.JTFAbreviatura, -2, 49, -2)).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstado)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFTipoTubo.2
            public void mouseClicked(MouseEvent evt) {
                JIFTipoTubo.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 209, -2).addContainerGap(-1, 32767)));
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
        Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
        this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
        this.JTFAbreviatura.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
        if (Boolean.parseBoolean(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString())) {
            this.xEstado = 1;
            this.JCHEstado.setSelected(true);
        } else {
            this.xEstado = 0;
            this.JCHEstado.setSelected(false);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Abreviatura", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFTipoTubo.3
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mBuscaDatos() {
        mModelo();
        List<TipoTuboDTO> list = this.xTipoTuboDAO.mListar();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getAbreviatura(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    public void mGuardar() {
        if (!this.JTFNombre.getText().equals("")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                TipoTuboDTO e = new TipoTuboDTO();
                if (Principal.txtNo.getText().equals("")) {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setAbreviatura(this.JTFAbreviatura.getText().toUpperCase());
                    e.setEstado(this.xEstado);
                    this.xTipoTuboDAO.mCreate(e);
                } else {
                    e.setNombre(this.JTFNombre.getText().toUpperCase());
                    e.setAbreviatura(this.JTFAbreviatura.getText().toUpperCase());
                    e.setEstado(this.xEstado);
                    e.setId(Integer.valueOf(Principal.txtNo.getText()).intValue());
                    this.xTipoTuboDAO.mUpdate(e);
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

    public void mNuevo() {
        this.JTFNombre.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        this.JTFAbreviatura.setText("");
        Principal.mLimpiarDatosP();
        mBuscaDatos();
    }
}
