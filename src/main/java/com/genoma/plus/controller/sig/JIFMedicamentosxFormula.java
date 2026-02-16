package com.genoma.plus.controller.sig;

import Utilidades.Metodos;
import com.genoma.plus.dao.impl.sig.MedicamentosxFormulaDAOImpl;
import com.genoma.plus.dao.sig.MedicamentosxFormulaDAO;
import com.genoma.plus.dto.sig.GenericoComboDTO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/sig/JIFMedicamentosxFormula.class */
public class JIFMedicamentosxFormula extends JInternalFrame {
    private MedicamentosxFormulaDAO xMedicamentosxFormulaDAO;
    private DefaultTableModel xModelo1;
    private Object[] xdatos;
    private String[] xidTipoFormula;
    private ButtonGroup JBGEstados;
    private JButton JBTExportar;
    private JComboBox<String> JCBTipoFormula;
    private JRadioButton JRBActivos;
    private JRadioButton JRBInactivos;
    private JRadioButton JRBTodos;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private String xtipo = "0,1";
    private Boolean xlleno = false;

    public JIFMedicamentosxFormula() {
        initComponents();
        springStart();
        mLlenarCombo();
    }

    private void springStart() {
        this.xMedicamentosxFormulaDAO = (MedicamentosxFormulaDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("medicamentosxFormulaDAO");
    }

    private void mLlenarCombo() {
        this.xlleno = false;
        this.JCBTipoFormula.removeAllItems();
        List<GenericoComboDTO> list = this.xMedicamentosxFormulaDAO.mListarTipoFormula();
        this.xidTipoFormula = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xidTipoFormula[x] = String.valueOf(list.get(x).getId());
            this.JCBTipoFormula.addItem(list.get(x).getNombre());
            System.out.println("Consulta " + list.get(x).getId());
            System.out.println("" + list.get(x).getNombre());
        }
        this.JCBTipoFormula.setSelectedIndex(-1);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModeloTabla() {
        this.xModelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Suministro", "Principio Activo", "Presentacion Farmaceutica", "Presentacion Comercial", "Laboratorio", "Estado"}) { // from class: com.genoma.plus.controller.sig.JIFMedicamentosxFormula.1
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
    }

    private void mCargarDatosTabla() {
        if (this.JRBTodos.isSelected()) {
            this.xtipo = "0,1";
        } else if (this.JRBActivos.isSelected()) {
            this.xtipo = "1";
        } else {
            this.xtipo = "0";
        }
        List<Object[]> list = this.xMedicamentosxFormulaDAO.mListarMedicamentos(this.xidTipoFormula[this.JCBTipoFormula.getSelectedIndex()], this.xtipo);
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
        }
    }

    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGEstados = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.JCBTipoFormula = new JComboBox<>();
        this.jPanel2 = new JPanel();
        this.JRBInactivos = new JRadioButton();
        this.JRBActivos = new JRadioButton();
        this.JRBTodos = new JRadioButton();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("MEDICAMENTOS POR TIPO DE FORMULA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACION", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBTipoFormula.setFont(new Font("Arial", 1, 12));
        this.JCBTipoFormula.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Formula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoFormula.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.sig.JIFMedicamentosxFormula.2
            public void itemStateChanged(ItemEvent evt) {
                JIFMedicamentosxFormula.this.JCBTipoFormulaItemStateChanged(evt);
            }
        });
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR:", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGEstados.add(this.JRBInactivos);
        this.JRBInactivos.setFont(new Font("Arial", 1, 12));
        this.JRBInactivos.setText("Inactivos");
        this.JRBInactivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFMedicamentosxFormula.3
            public void actionPerformed(ActionEvent evt) {
                JIFMedicamentosxFormula.this.JRBInactivosActionPerformed(evt);
            }
        });
        this.JBGEstados.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFMedicamentosxFormula.4
            public void actionPerformed(ActionEvent evt) {
                JIFMedicamentosxFormula.this.JRBActivosActionPerformed(evt);
            }
        });
        this.JBGEstados.add(this.JRBTodos);
        this.JRBTodos.setFont(new Font("Arial", 1, 12));
        this.JRBTodos.setSelected(true);
        this.JRBTodos.setText("Todos");
        this.JRBTodos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFMedicamentosxFormula.5
            public void actionPerformed(ActionEvent evt) {
                JIFMedicamentosxFormula.this.JRBTodosActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBTodos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBActivos).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBInactivos)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos).addComponent(this.JRBActivos).addComponent(this.JRBInactivos)).addGap(0, 1, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoFormula, -2, 283, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoFormula, -2, 50, -2).addComponent(this.jPanel2, -2, -1, -2)).addGap(10, 10, 10)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.sig.JIFMedicamentosxFormula.6
            public void mouseClicked(MouseEvent evt) {
                JIFMedicamentosxFormula.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.sig.JIFMedicamentosxFormula.7
            public void actionPerformed(ActionEvent evt) {
                JIFMedicamentosxFormula.this.JBTExportarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 672, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTExportar, -1, 200, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 317, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JBTExportar, -1, -1, 32767)).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.xmt.getDirectorioExportacion());
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
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle() + ": " + this.JCBTipoFormula.getSelectedItem().toString().toUpperCase());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoFormulaItemStateChanged(ItemEvent evt) {
        if (this.xlleno.booleanValue() && this.JCBTipoFormula.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBInactivosActionPerformed(ActionEvent evt) {
        if (this.xlleno.booleanValue() && this.JCBTipoFormula.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        if (this.xlleno.booleanValue() && this.JCBTipoFormula.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodosActionPerformed(ActionEvent evt) {
        if (this.xlleno.booleanValue() && this.JCBTipoFormula.getSelectedIndex() != -1) {
            mCargarDatosTabla();
        }
    }
}
