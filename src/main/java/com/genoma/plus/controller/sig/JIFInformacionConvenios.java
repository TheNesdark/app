package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.sig.InformacionConveniosDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFInformacionConvenios.class */
public class JIFInformacionConvenios extends JInternalFrame {
    private InformacionConveniosDAO xInformacionConveniosDAO;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private JButton JBTExportar;
    private JRadioButton JRBActivos;
    private ButtonGroup JRBFiltrar;
    private JRadioButton JRBInactivos;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private int xtipo = 0;

    public JIFInformacionConvenios() {
        initComponents();
        springStart();
        mCargarDatosTabla();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    private void springStart() {
        this.xInformacionConveniosDAO = (InformacionConveniosDAO) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informacionConveniosDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Documento", "Tercero", "Convenio", "CRips", "Manual", "Modo Facturacion", "Tipo de Regimen", "Codigo Procedimiento", "Codigo Suministro", "Metodo Facturacion", "Aplica Redondeo?", "GeneraMovContable?", "Plan", "Estrato", "Servicio", "Estado"}) { // from class: com.genoma.plus.controller.sig.JIFInformacionConvenios.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo1);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xInformacionConveniosDAO.mListadoCompleto(this.xtipo);
        mCreaModeloTabla();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo1.addRow(this.xdatos);
            this.xModelo1.setValueAt(list.get(x)[0], x, 0);
            this.xModelo1.setValueAt(list.get(x)[1], x, 1);
            this.xModelo1.setValueAt(list.get(x)[2], x, 2);
            this.xModelo1.setValueAt(list.get(x)[3], x, 3);
            this.xModelo1.setValueAt(list.get(x)[4], x, 4);
            this.xModelo1.setValueAt(list.get(x)[5], x, 5);
            this.xModelo1.setValueAt(list.get(x)[6], x, 6);
            this.xModelo1.setValueAt(list.get(x)[7], x, 7);
            this.xModelo1.setValueAt(list.get(x)[8], x, 8);
            this.xModelo1.setValueAt(list.get(x)[9], x, 9);
            this.xModelo1.setValueAt(list.get(x)[10], x, 10);
            this.xModelo1.setValueAt(list.get(x)[11], x, 11);
            this.xModelo1.setValueAt(list.get(x)[12], x, 12);
            this.xModelo1.setValueAt(list.get(x)[13], x, 13);
            this.xModelo1.setValueAt(list.get(x)[14], x, 14);
            this.xModelo1.setValueAt(list.get(x)[15], x, 15);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JRBFiltrar = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.jPanel1 = new JPanel();
        this.JRBInactivos = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JRBTodos = new JRadioButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORMACIÓN DE CONVENIOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformacionconvenios");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFInformacionConvenios.2
            public void mouseClicked(MouseEvent evt) {
                JIFInformacionConvenios.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformacionConvenios.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformacionConvenios.this.JBTExportarActionPerformed(evt);
            }
        });
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR:", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JRBFiltrar.add(this.JRBInactivos);
        this.JRBInactivos.setFont(new Font("Arial", 1, 12));
        this.JRBInactivos.setText("Desactivados");
        this.JRBInactivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformacionConvenios.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformacionConvenios.this.JRBInactivosActionPerformed(evt);
            }
        });
        this.JRBFiltrar.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformacionConvenios.5
            public void actionPerformed(ActionEvent evt) {
                JIFInformacionConvenios.this.JRBActivosActionPerformed(evt);
            }
        });
        this.JRBFiltrar.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFInformacionConvenios.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformacionConvenios.this.JRBTodosActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JRBTodos).addGap(28, 28, 28).addComponent(this.JRBActivos).addGap(29, 29, 29).addComponent(this.JRBInactivos).addGap(0, 29, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBActivos).addComponent(this.JRBInactivos)).addContainerGap(12, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 1070, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -2, 225, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 434, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -1, -1, 32767)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar?", "CONFIRMACIÓN", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xtipo = 0;
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        this.xtipo = 1;
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBInactivosActionPerformed(ActionEvent evt) {
        this.xtipo = 2;
        mCargarDatosTabla();
    }
}
