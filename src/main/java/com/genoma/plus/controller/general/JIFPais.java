package com.genoma.plus.controller.general;

import Acceso.Principal;
import com.genoma.plus.dao.general.PaisDAO;
import com.genoma.plus.dao.impl.general.PaisDAOImpl;
import com.genoma.plus.dto.general.PaisDTO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/general/JIFPais.class */
public class JIFPais extends JInternalFrame {
    private int xEstado = 1;
    private DefaultTableModel xmodelo;
    private PaisDAO xPaisDAO;
    private Object[] xDato;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFAbreviatura;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;

    public JIFPais() {
        initComponents();
        springStart();
        mNuevo();
    }

    private void springStart() {
        this.xPaisDAO = (PaisDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("paisDAO");
    }

    public void mNuevo() {
        Principal.txtNo.setText("");
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
        this.JTFAbreviatura.setText("");
        this.JCHEstado.setSelected(true);
        this.xEstado = 1;
        mBuscaDatos();
    }

    public void mGuardar() {
        if (!this.JTFCodigo.getText().equals("")) {
            if (!this.JTFNombre.getText().equals("")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    PaisDTO e = new PaisDTO();
                    if (Principal.txtNo.getText().equals("")) {
                        e.setId(this.JTFCodigo.getText());
                        e.setNombre(this.JTFNombre.getText().toUpperCase());
                        e.setCodigo(this.JTFAbreviatura.getText().toUpperCase());
                        e.setEstado(this.xEstado);
                        this.xPaisDAO.mCreate(e);
                    } else {
                        e.setNombre(this.JTFNombre.getText().toUpperCase());
                        e.setCodigo(this.JTFAbreviatura.getText().toUpperCase());
                        e.setEstado(this.xEstado);
                        e.setId(Principal.txtNo.getText());
                        this.xPaisDAO.mUpdate(e);
                    }
                    mNuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe digitar el Nombre", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe digitar un codigo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFNombre.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Pais", "Abreviatura", "Estado"}) { // from class: com.genoma.plus.controller.general.JIFPais.1
            Class[] types = {String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(50);
    }

    private void mBuscaDatos() {
        mModelo();
        List<PaisDTO> list = this.xPaisDAO.listPais();
        for (int x = 0; x < list.size(); x++) {
            this.xmodelo.addRow(this.xDato);
            this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
            this.xmodelo.setValueAt(list.get(x).getNombre(), x, 1);
            this.xmodelo.setValueAt(list.get(x).getCodigo(), x, 2);
            if (list.get(x).getEstado() == 1) {
                this.xmodelo.setValueAt(true, x, 3);
            } else {
                this.xmodelo.setValueAt(false, x, 3);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v34, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFCodigo = new JTextField();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFAbreviatura = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("PAÍS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifpais");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFPais.2
            public void keyTyped(KeyEvent evt) {
                JIFPais.this.JTFCodigoKeyTyped(evt);
            }
        });
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.general.JIFPais.3
            public void actionPerformed(ActionEvent evt) {
                JIFPais.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFAbreviatura.setFont(new Font("Arial", 1, 12));
        this.JTFAbreviatura.setToolTipText("");
        this.JTFAbreviatura.setBorder(BorderFactory.createTitledBorder((Border) null, "Abreviatura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAbreviatura.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.general.JIFPais.4
            public void keyTyped(KeyEvent evt) {
                JIFPais.this.JTFAbreviaturaKeyTyped(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 121, -2).addGap(18, 18, 18).addComponent(this.JTFNombre, -2, 316, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFAbreviatura, -2, 157, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addContainerGap()));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCodigo, -2, 50, -2).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFAbreviatura, -2, 50, -2)).addComponent(this.JCHEstado)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.general.JIFPais.5
            public void mouseClicked(MouseEvent evt) {
                JIFPais.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalle, GroupLayout.Alignment.LEADING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -1, 415, 32767).addContainerGap()));
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
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JTFAbreviatura.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            if (Boolean.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString()).booleanValue()) {
                this.xEstado = 1;
                this.JCHEstado.setSelected(true);
            } else {
                this.xEstado = 0;
                this.JCHEstado.setSelected(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFAbreviaturaKeyTyped(KeyEvent evt) {
        if (this.JTFAbreviatura.getText().length() == 5) {
            evt.consume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoKeyTyped(KeyEvent evt) {
        if (this.JTFCodigo.getText().length() == 4) {
            evt.consume();
        }
    }
}
