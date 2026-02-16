package com.genoma.plus.controller.presupuesto;

import com.genoma.plus.dao.impl.presupuesto.RubrosContraloriaDAOImpl;
import com.genoma.plus.dao.presupuesto.RubrosContraloriaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JDRubrosContraloria.class */
public class JDRubrosContraloria extends JDialog {
    private RubrosContraloriaDAO xContraloriaDAO;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String filtro;
    private JDParametrizacionCGR JDP;
    private JTable JTDetalle;
    private JTextField JTFFIltro;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JDRubrosContraloria(Frame parent, boolean modal, JDParametrizacionCGR JDP) {
        super(parent, modal);
        this.filtro = "";
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        sprintStart();
        mCargarDatos();
        this.JDP = JDP;
    }

    private void sprintStart() {
        this.xContraloriaDAO = (RubrosContraloriaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("RubrosContraloriaDAO");
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.JTFFIltro = new JTextField();
        setDefaultCloseOperation(2);
        setTitle("Rubros Contraloria");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDRubrosContraloria.1
            public void mouseClicked(MouseEvent evt) {
                JDRubrosContraloria.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 566, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 289, -2).addGap(0, 9, 32767)));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFIltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro por nombre o por codigo rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFIltro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDRubrosContraloria.2
            public void keyReleased(KeyEvent evt) {
                JDRubrosContraloria.this.JTFFIltroKeyReleased(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFIltro).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFFIltro, -2, 50, -2).addGap(5, 5, 5)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -2, -1, -2)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFIltroKeyReleased(KeyEvent evt) {
        if (!this.JTFFIltro.getText().isEmpty()) {
            this.filtro = this.JTFFIltro.getText();
            mCargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JDP.JTFRubroContraloria.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            dispose();
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Nombre"}) { // from class: com.genoma.plus.controller.presupuesto.JDRubrosContraloria.3
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(140);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(320);
    }

    private void mCargarDatos() {
        mCrearModelo();
        List<Object[]> listaFiltro = this.xContraloriaDAO.filtroRubrosContraloria(this.filtro);
        for (int x = 0; x < listaFiltro.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 2; j++) {
                this.xmodelo.setValueAt(listaFiltro.get(x)[j], x, j);
            }
        }
    }
}
