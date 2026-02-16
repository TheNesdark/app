package com.genoma.plus.controller.laboratorio;

import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/laboratorio/JDAdicionarProcedimeinto.class */
public class JDAdicionarProcedimeinto extends JDialog {
    private DefaultTableModel modeloFiltro;
    Metodos metodos;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private TableRowSorter<DefaultTableModel> sorter;
    private String fechaInicial;
    private String fechaFinal;
    List<String> idProcedimientoSeleccionadas;
    private Runnable callback;
    private JButton JBotonCargar;
    private JTextField JTFNombre;
    private JTable JTable;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;

    public JDAdicionarProcedimeinto(Frame parent, boolean modal, String fechaInicial, String fechaFinal, Runnable callback) {
        super(parent, modal);
        this.metodos = new Metodos();
        this.xct = new ConsultasMySQL();
        this.idProcedimientoSeleccionadas = new ArrayList();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        nuevo();
        configurarFiltro();
    }

    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel2 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.jPanel3 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.JTable = new JTable();
        this.JBotonCargar = new JButton();
        this.jPanel2.setBorder(BorderFactory.createTitledBorder(""));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 586, 32767));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 271, 32767));
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Procedimiento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.laboratorio.JDAdicionarProcedimeinto.1
            public void keyPressed(KeyEvent evt) {
                JDAdicionarProcedimeinto.this.JTFNombreKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JDAdicionarProcedimeinto.this.JTFNombreKeyReleased(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombre, -1, 636, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 49, -2).addGap(10, 10, 10)));
        this.jPanel3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.jScrollPane1.setViewportView(this.JTable);
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jScrollPane1).addGap(10, 10, 10)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jScrollPane1, -2, 379, -2).addGap(10, 10, 10)));
        this.JBotonCargar.setFont(new Font("Arial", 1, 14));
        this.JBotonCargar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBotonCargar.setText("Cargar ?");
        this.JBotonCargar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.laboratorio.JDAdicionarProcedimeinto.2
            public void actionPerformed(ActionEvent evt) {
                JDAdicionarProcedimeinto.this.JBotonCargarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBotonCargar).addGap(0, 12, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jPanel1, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.JBotonCargar, -2, 75, -2))).addGap(5, 5, 5).addComponent(this.jPanel3, -2, -1, -2).addContainerGap(15, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
        filtrar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBotonCargarActionPerformed(ActionEvent evt) {
        cargar();
        System.out.println("Procedimientos seleccionados: " + this.idProcedimientoSeleccionadas);
        dispose();
    }

    private void configurarFiltro() {
        this.sorter = new TableRowSorter<>(this.modeloFiltro);
        this.JTable.setRowSorter(this.sorter);
        this.JTFNombre.getDocument().addDocumentListener(new DocumentListener() { // from class: com.genoma.plus.controller.laboratorio.JDAdicionarProcedimeinto.3
            public void insertUpdate(DocumentEvent e) {
                JDAdicionarProcedimeinto.this.filtrar();
            }

            public void removeUpdate(DocumentEvent e) {
                JDAdicionarProcedimeinto.this.filtrar();
            }

            public void changedUpdate(DocumentEvent e) {
                JDAdicionarProcedimeinto.this.filtrar();
            }
        });
    }

    private void nuevo() {
        this.JTFNombre.setText("");
        modeloDetalleFiltro();
        buscar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void filtrar() {
        String text = this.JTFNombre.getText().trim();
        if (text.isEmpty()) {
            this.sorter.setRowFilter((RowFilter) null);
            return;
        }
        RowFilter<DefaultTableModel, Object> filter1 = RowFilter.regexFilter("(?i)" + text, new int[]{0});
        RowFilter<DefaultTableModel, Object> filter2 = RowFilter.regexFilter("(?i)" + text, new int[]{1});
        this.sorter.setRowFilter(RowFilter.orFilter(Arrays.asList(filter1, filter2)));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void modeloDetalleFiltro() {
        this.modeloFiltro = new DefaultTableModel(new Object[0], new String[]{"CUPS", "PROCEDIMEINTO", "CARGAR ?"}) { // from class: com.genoma.plus.controller.laboratorio.JDAdicionarProcedimeinto.4
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTable.setModel(this.modeloFiltro);
        this.JTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    private void buscar() {
        this.modeloFiltro.setRowCount(0);
        String sql = "SELECT `g_procedimiento`.`Id` as idProcedimeintento  , `g_procedimiento`.`Nbre` as nombreProcedieminto\nFROM `l_detallerecepcion` \nINNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas`  ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`) \nINNER JOIN  `l_recepcion`   ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `f_ordenes` ON (`f_ordenes`.`Id`=`l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON (`ingreso`.`Id`= `f_ordenes`.`Id_Ingreso`)\nWHERE ( \nDATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') >='" + this.fechaInicial + "' \nAND  DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y-%m-%d') <='" + this.fechaFinal + "' \nAND `l_recepcion`.`Estado`=0 \nand `g_procedimiento`.`EsRemitido`=0\nand l_areas.`Id`=7\n)\nGROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC";
        System.out.println(sql);
        ResultSet xrs = this.xct.traerRs(sql);
        while (xrs.next()) {
            try {
                this.modeloFiltro.addRow(new Object[]{xrs.getString("idProcedimeintento"), xrs.getString("nombreProcedieminto"), false});
            } catch (SQLException ex) {
                Logger.getLogger(JDAdicionarProcedimeinto.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                return;
            }
        }
        xrs.close();
        this.xct.cerrarConexionBd();
    }

    private void cargar() {
        boolean seleccionValida = false;
        for (int i = 0; i < this.JTable.getRowCount(); i++) {
            Boolean cargar = (Boolean) this.JTable.getValueAt(i, 2);
            if (cargar != null && cargar.booleanValue()) {
                String idProcedimeinto = (String) this.JTable.getValueAt(i, 0);
                this.idProcedimientoSeleccionadas.add(idProcedimeinto);
                seleccionValida = true;
            }
        }
        if (!seleccionValida) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un procedimiento para cargar.", "Error", 0);
            return;
        }
        if (this.callback != null) {
            this.callback.run();
        }
        dispose();
    }

    public List<String> getIdProcedimientoSeleccionadas() {
        return this.idProcedimientoSeleccionadas;
    }
}
