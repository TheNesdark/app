package com.genoma.plus.controller.presupuesto;

import com.genoma.plus.dao.impl.presupuesto.OrigenIngresoDAOImpl;
import com.genoma.plus.dao.presupuesto.OrigenIngresoDAO;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JDGenerico.class */
public class JDGenerico extends JDialog {
    private DefaultTableModel xmodelo;
    private OrigenIngresoDAO xOrigenIngresoDAO;
    private String filtro;
    int id;
    private Object[] xdatos;
    private JDParametrizacionCGR JDP;
    private JTable JTDetalle;
    private JTextField JTFFiltro;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JDGenerico(Frame parent, boolean modal, JDParametrizacionCGR JDP, int id) {
        super(parent, modal);
        this.filtro = "";
        initComponents();
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        sprintStart();
        this.id = id;
        this.JDP = JDP;
        mCargarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.JTFFiltro = new JTextField();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDGenerico.1
            public void mouseClicked(MouseEvent evt) {
                JDGenerico.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 671, 32767));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 270, 32767).addContainerGap()));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro  Por nombre o por codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JDGenerico.2
            public void keyReleased(KeyEvent evt) {
                JDGenerico.this.JTFFiltroKeyReleased(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltro).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTFFiltro, -2, 50, -2).addGap(5, 5, 5)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroKeyReleased(KeyEvent evt) {
        this.filtro = this.JTFFiltro.getText();
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            switch (this.id) {
                case 1:
                    this.JDP.JTFOrigenIngreso.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                    this.JDP.idorigenIngreso = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    break;
                case 2:
                    this.JDP.JTFFinalidadGasto.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                    this.JDP.idFinalidad = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    break;
                default:
                    this.JDP.JTFTipoDestino.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                    this.JDP.idTipoDestino = Integer.parseInt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    break;
            }
            dispose();
        }
    }

    private void sprintStart() {
        this.xOrigenIngresoDAO = (OrigenIngresoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("OrigenIngresoDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModelo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"id", "Codigo", "Nombre"}) { // from class: com.genoma.plus.controller.presupuesto.JDGenerico.3
            Class[] types = {String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(360);
    }

    private void mCargarDatos() {
        String tabla;
        mCrearModelo();
        switch (this.id) {
            case 1:
                tabla = "`pp_origen_ingreso`";
                break;
            case 2:
                tabla = "`pp_finalidad_gasto`";
                break;
            default:
                tabla = "`pp_tipo_destinacion`";
                break;
        }
        List<Object[]> listaFiltro = this.xOrigenIngresoDAO.listaFiltro(this.filtro, tabla);
        for (int x = 0; x < listaFiltro.size(); x++) {
            this.xmodelo.addRow(this.xdatos);
            for (int j = 0; j < 3; j++) {
                this.xmodelo.setValueAt(listaFiltro.get(x)[j], x, j);
            }
        }
    }
}
