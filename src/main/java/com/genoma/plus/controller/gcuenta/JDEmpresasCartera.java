package com.genoma.plus.controller.gcuenta;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.jpa.gcuenta.GCuentaDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JDEmpresasCartera.class */
public class JDEmpresasCartera extends JDialog {
    private JIFGC_Pagos_Grupal xIFGC_Pagos_Grupal;
    private DefaultTableModel xmodelo;
    private Metodos xmt;
    private Object[] xdato;
    private GCuentaDAO gcuenta;
    private JScrollPane JSPResultado;
    private JTextField JTFNombre;
    private JTable JTResultado;
    private JPanel jPanel1;

    public JDEmpresasCartera(Frame parent, boolean modal, JIFGC_Pagos_Grupal xIFGC_Pagos_Grupal) {
        super(parent, modal);
        this.xmt = new Metodos();
        initComponents();
        this.xIFGC_Pagos_Grupal = xIFGC_Pagos_Grupal;
        springStart();
        mBuscarDatos();
    }

    private void springStart() {
        this.gcuenta = (GCuentaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("gCuentaDAOImpl");
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.JSPResultado = new JScrollPane();
        this.JTResultado = new JTable();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDEmpresasCartera.1
            public void keyReleased(KeyEvent evt) {
                JDEmpresasCartera.this.JTFNombreKeyReleased(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -1, 678, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNombre, -2, -1, -2));
        this.JSPResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setRowHeight(25);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDEmpresasCartera.2
            public void mouseClicked(MouseEvent evt) {
                JDEmpresasCartera.this.JTResultadoMouseClicked(evt);
            }
        });
        this.JSPResultado.setViewportView(this.JTResultado);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPResultado).addComponent(this.jPanel1, -1, -1, 32767)).addGap(27, 27, 27)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResultado, -1, 229, 32767).addGap(7, 7, 7)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        mBuscarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoMouseClicked(MouseEvent evt) {
        if (this.JTResultado.getSelectedRow() != -1) {
            this.xIFGC_Pagos_Grupal.JCB_Empresa.setSelectedItem(this.JTResultado.getValueAt(this.JTResultado.getSelectedRow(), 1).toString());
            dispose();
        }
    }

    private void mBuscarDatos() {
        mCrearModeloDatos();
        List<GCGenericoDTO> list3 = this.gcuenta.listaEmpresasCarteraF(this.JTFNombre.getText());
        for (int x = 0; x < list3.size(); x++) {
            this.xmodelo.addRow(this.xdato);
            this.xmodelo.setValueAt(Long.valueOf(list3.get(x).getId()), x, 0);
            this.xmodelo.setValueAt(list3.get(x).getNombre(), x, 1);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre"}) { // from class: com.genoma.plus.controller.gcuenta.JDEmpresasCartera.3
            Class[] types = {Long.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.xmodelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(600);
    }
}
