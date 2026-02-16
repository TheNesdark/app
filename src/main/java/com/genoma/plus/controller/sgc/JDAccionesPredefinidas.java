package com.genoma.plus.controller.sgc;

import Utilidades.Metodos;
import com.genoma.plus.dao.general.TipoConAccionDAO;
import com.genoma.plus.dao.impl.general.TipoConAccionDAOImpl;
import com.genoma.plus.dto.general.TipoConAccionDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sgc/JDAccionesPredefinidas.class */
public class JDAccionesPredefinidas extends JDialog {
    private Metodos xmt;
    private TipoConAccionDAO xTipoConAccionDAO;
    private Object[] xDatos;
    private DefaultTableModel xModelo;
    private JTextPane xjpanel1;
    private JTextArea xjpanel1_A;
    private int xtipo;
    private String xidTRiesgoE;
    private JButton JBT_Cargar;
    private JButton JBT_Salir;
    private JComboBox JCBFiltro;
    private JPanel JPIH_Filtro;
    private JScrollPane JSP_PDetalle;
    private JTable JTB_PDetalle_NPredefinidas;
    private JTextField JTFBNombre;

    public JDAccionesPredefinidas(Frame parent, boolean modal, JTextPane xjpanel1, int xtipo, String xidTRiesgoE) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xtipo = 0;
        initComponents();
        springStart();
        this.xtipo = xtipo;
        this.xjpanel1 = xjpanel1;
        this.xidTRiesgoE = xidTRiesgoE;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        setTitle("ACCIONES PREDEFINIDAS");
        mCargarDatosTabla();
    }

    public JDAccionesPredefinidas(Frame parent, boolean modal, JTextArea xjpanel1, int xtipo) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xtipo = 0;
        initComponents();
        springStart();
        this.xtipo = xtipo;
        this.xjpanel1_A = xjpanel1;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        mCargarDatosTabla();
    }

    private void springStart() {
        this.xTipoConAccionDAO = (TipoConAccionDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("tipoConAccionDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Nombre", "Tipo", "Cargar?"}) { // from class: com.genoma.plus.controller.sgc.JDAccionesPredefinidas.1
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTB_PDetalle_NPredefinidas.setModel(this.xModelo);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(0).setPreferredWidth(500);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(1).setPreferredWidth(70);
        this.JTB_PDetalle_NPredefinidas.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void mCargarDatosTabla() {
        mCrearModelo();
        List<TipoConAccionDTO> list = this.xTipoConAccionDAO.listFiltroAcciones(this.JTFBNombre.getText(), this.JCBFiltro.getSelectedIndex(), this.xidTRiesgoE);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDatos);
            this.xModelo.setValueAt("-" + list.get(x).getNombre(), x, 0);
            this.xModelo.setValueAt(list.get(x).getNTipo(), x, 1);
            this.xModelo.setValueAt(false, x, 2);
        }
    }

    private void mCargarDato() {
        if (this.xmt.mVerificarDatosTablaTrue(this.JTB_PDetalle_NPredefinidas, 2)) {
            String xdato = "";
            for (int x = 0; x < this.JTB_PDetalle_NPredefinidas.getRowCount(); x++) {
                if (Boolean.valueOf(this.xModelo.getValueAt(x, 2).toString()).booleanValue()) {
                    xdato = xdato + this.xModelo.getValueAt(x, 0).toString() + "\n";
                }
            }
            if (this.xtipo == 0) {
                this.xjpanel1.setText(this.xjpanel1.getText() + "\n" + xdato);
            } else {
                this.xjpanel1_A.setText(this.xjpanel1_A.getText() + "\n" + xdato);
            }
            dispose();
            return;
        }
        JOptionPane.showMessageDialog(this, "No se ha selecionado una accion para cargar", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JSP_PDetalle = new JScrollPane();
        this.JTB_PDetalle_NPredefinidas = new JTable();
        this.JPIH_Filtro = new JPanel();
        this.JTFBNombre = new JTextField();
        this.JCBFiltro = new JComboBox();
        this.JBT_Salir = new JButton();
        this.JBT_Cargar = new JButton();
        setDefaultCloseOperation(2);
        this.JSP_PDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTB_PDetalle_NPredefinidas.setFont(new Font("Arial", 1, 12));
        this.JTB_PDetalle_NPredefinidas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTB_PDetalle_NPredefinidas.setRowHeight(25);
        this.JTB_PDetalle_NPredefinidas.setSelectionBackground(new Color(255, 255, 255));
        this.JTB_PDetalle_NPredefinidas.setSelectionForeground(Color.red);
        this.JSP_PDetalle.setViewportView(this.JTB_PDetalle_NPredefinidas);
        this.JPIH_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFBNombre.setFont(new Font("Arial", 1, 12));
        this.JTFBNombre.setToolTipText("");
        this.JTFBNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFBNombre.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDAccionesPredefinidas.2
            public void actionPerformed(ActionEvent evt) {
                JDAccionesPredefinidas.this.JTFBNombreActionPerformed(evt);
            }
        });
        this.JTFBNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JDAccionesPredefinidas.3
            public void keyTyped(KeyEvent evt) {
                JDAccionesPredefinidas.this.JTFBNombreKeyTyped(evt);
            }
        });
        this.JCBFiltro.setFont(new Font("Arial", 1, 12));
        this.JCBFiltro.setModel(new DefaultComboBoxModel(new String[]{"Todos", "Correctivo Inmediato", "Acciones Preventivas"}));
        this.JCBFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar:", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFiltro.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sgc.JDAccionesPredefinidas.4
            public void itemStateChanged(ItemEvent evt) {
                JDAccionesPredefinidas.this.JCBFiltroItemStateChanged(evt);
            }
        });
        GroupLayout JPIH_FiltroLayout = new GroupLayout(this.JPIH_Filtro);
        this.JPIH_Filtro.setLayout(JPIH_FiltroLayout);
        JPIH_FiltroLayout.setHorizontalGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIH_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFBNombre, -2, 633, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBFiltro, 0, -1, 32767)));
        JPIH_FiltroLayout.setVerticalGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIH_FiltroLayout.createSequentialGroup().addGroup(JPIH_FiltroLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBFiltro).addComponent(this.JTFBNombre)).addContainerGap(-1, 32767)));
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDAccionesPredefinidas.5
            public void actionPerformed(ActionEvent evt) {
                JDAccionesPredefinidas.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JBT_Salir.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JDAccionesPredefinidas.6
            public void keyPressed(KeyEvent evt) {
                JDAccionesPredefinidas.this.JBT_SalirKeyPressed(evt);
            }
        });
        this.JBT_Cargar.setFont(new Font("Arial", 1, 12));
        this.JBT_Cargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBT_Cargar.setText("Cargar");
        this.JBT_Cargar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sgc.JDAccionesPredefinidas.7
            public void actionPerformed(ActionEvent evt) {
                JDAccionesPredefinidas.this.JBT_CargarActionPerformed(evt);
            }
        });
        this.JBT_Cargar.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.sgc.JDAccionesPredefinidas.8
            public void keyPressed(KeyEvent evt) {
                JDAccionesPredefinidas.this.JBT_CargarKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSP_PDetalle, -1, 900, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBT_Cargar, -2, 438, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBT_Salir, -1, -1, 32767)).addComponent(this.JPIH_Filtro, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JPIH_Filtro, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_PDetalle, -2, 218, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Cargar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap(14, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFBNombreKeyTyped(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargarActionPerformed(ActionEvent evt) {
        mCargarDato();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_CargarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mCargarDato();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBFiltroItemStateChanged(ItemEvent evt) {
        mCargarDatosTabla();
    }
}
