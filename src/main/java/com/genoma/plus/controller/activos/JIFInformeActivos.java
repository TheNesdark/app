package com.genoma.plus.controller.activos;

import Utilidades.Metodos;
import com.genoma.plus.dao.activos.InformesActivosDAO;
import com.genoma.plus.dao.impl.activos.InformesActivosDAOImpl;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/activos/JIFInformeActivos.class */
public class JIFInformeActivos extends JInternalFrame {
    private InformesActivosDAO xInformesActivosDAO;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private ButtonGroup JBGFiltro;
    private JButton JBTExportar;
    private JPanel JPFiltros;
    private JPanel JPInformacion;
    private JRadioButton JRBActivos;
    private JRadioButton JRBInactivos;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private Metodos xmt = new Metodos();
    private String xtipo = "0,1";

    public JIFInformeActivos() {
        initComponents();
        springStart();
        mCargarDatosTabla();
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
    }

    private void springStart() {
        this.xInformesActivosDAO = (InformesActivosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("informesActivosDAO");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Categoria", "Ubicacion", "Nombre", "Marca", "Modelo", "Referencia", "Nombre Contable", "Fecha Contable", "Valor Compra", "Estado", "EstadoA", "Observacion"}) { // from class: com.genoma.plus.controller.activos.JIFInformeActivos.1
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(300);
    }

    private void mCargarDatosTabla() {
        List<Object[]> list = this.xInformesActivosDAO.mListadoInformeActivos(this.xtipo);
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
            if (((Integer) list.get(x)[11]).intValue() == 1) {
                this.xModelo1.setValueAt(true, x, 11);
            } else {
                this.xModelo1.setValueAt(false, x, 11);
            }
            this.xModelo1.setValueAt(list.get(x)[12], x, 12);
            this.xModelo1.setValueAt(list.get(x)[13], x, 13);
        }
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JPInformacion = new JPanel();
        this.JPFiltros = new JPanel();
        this.JRBInactivos = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JRBTodos = new JRadioButton();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("INFORME DE ACTIVOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifinformeactivos");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JPInformacion.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPFiltros.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR:", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGFiltro.add(this.JRBInactivos);
        this.JRBInactivos.setFont(new Font("Arial", 1, 12));
        this.JRBInactivos.setText("Desactivados");
        this.JRBInactivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.activos.JIFInformeActivos.2
            public void actionPerformed(ActionEvent evt) {
                JIFInformeActivos.this.JRBInactivosActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.activos.JIFInformeActivos.3
            public void actionPerformed(ActionEvent evt) {
                JIFInformeActivos.this.JRBActivosActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.activos.JIFInformeActivos.4
            public void actionPerformed(ActionEvent evt) {
                JIFInformeActivos.this.JRBTodosActionPerformed(evt);
            }
        });
        GroupLayout JPFiltrosLayout = new GroupLayout(this.JPFiltros);
        this.JPFiltros.setLayout(JPFiltrosLayout);
        JPFiltrosLayout.setHorizontalGroup(JPFiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltrosLayout.createSequentialGroup().addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBActivos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBInactivos).addContainerGap()));
        JPFiltrosLayout.setVerticalGroup(JPFiltrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFiltrosLayout.createSequentialGroup().addContainerGap().addGroup(JPFiltrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBActivos).addComponent(this.JRBInactivos)).addContainerGap(12, 32767)));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.activos.JIFInformeActivos.5
            public void mouseClicked(MouseEvent evt) {
                JIFInformeActivos.this.JTFRutaMouseClicked(evt);
            }

            public void mouseEntered(MouseEvent evt) {
                JIFInformeActivos.this.JTFRutaMouseEntered(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.activos.JIFInformeActivos.6
            public void actionPerformed(ActionEvent evt) {
                JIFInformeActivos.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout JPInformacionLayout = new GroupLayout(this.JPInformacion);
        this.JPInformacion.setLayout(JPInformacionLayout);
        JPInformacionLayout.setHorizontalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPFiltros, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFRuta, -2, 319, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTExportar, -1, 159, 32767).addContainerGap()));
        JPInformacionLayout.setVerticalGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPInformacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JPFiltros, -2, -1, -2)).addGroup(JPInformacionLayout.createSequentialGroup().addGap(24, 24, 24).addGroup(JPInformacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2)))).addContainerGap(20, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle).addComponent(this.JPInformacion, -1, -1, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 442, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBInactivosActionPerformed(ActionEvent evt) {
        this.xtipo = "0";
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        this.xtipo = "1";
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        this.xtipo = "0,1";
        mCargarDatosTabla();
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
    public void JTFRutaMouseEntered(MouseEvent evt) {
    }
}
