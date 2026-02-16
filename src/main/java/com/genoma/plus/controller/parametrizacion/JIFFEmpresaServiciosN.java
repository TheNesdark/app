package com.genoma.plus.controller.parametrizacion;

import Acceso.Principal;
import ParametrizacionN.claseParametrizacionN;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.parametrizacion.EmpresaServicioDAOImpl;
import com.genoma.plus.dao.parametrizacion.EmpresaServicioDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import org.jdesktop.jdnc.incubator.jxcombobox.IncompatibleLookAndFeelException;
import org.jdesktop.jdnc.incubator.jxcombobox.JTableComboBox;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFFEmpresaServiciosN.class */
public class JIFFEmpresaServiciosN extends JInternalFrame {
    private DefaultTableModel xmodelo;
    private DefaultTableModel modcombos;
    private Object[] xdatos;
    private JTable tabla_combo;
    JTableComboBox[] xcomboBox;
    private int xMetodoFact;
    private claseParametrizacionN xclase;
    private EmpresaServicioDAO xEmpresaServicioDAO;
    private List<Object[]> list;
    private ButtonGroup JBGTipo;

    /* JADX INFO: renamed from: JBTActualizarAño, reason: contains not printable characters */
    private JButton f23JBTActualizarAo;
    private JRadioButton JRBActivos;
    private JRadioButton JRBInactivos;
    private JRadioButton JRBSinConfigurar;
    private JRadioButton JRBTodos1;
    private JScrollPane JSPDetalle;
    private ButtonGroup buttonGroup1;
    private ConsultasMySQL xconsulta = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    ArrayList editors = new ArrayList();
    private int xestados = 0;
    private int xid = 0;
    private int xAplicaFactor = 1;
    private boolean xestadog = false;
    private boolean xlleno = false;
    private String filtro = "0";

    public JIFFEmpresaServiciosN(claseParametrizacionN xclase, int xMetodoFact) {
        initComponents();
        springStart();
        this.xMetodoFact = xMetodoFact;
        this.xclase = xclase;
        mNuevo();
    }

    private void springStart() {
        this.xEmpresaServicioDAO = (EmpresaServicioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("empresaServicioDAO");
    }

    private void initComponents() {
        this.JBGTipo = new ButtonGroup();
        this.buttonGroup1 = new ButtonGroup();
        this.JSPDetalle = new JScrollPane();
        this.f23JBTActualizarAo = new JButton();
        this.JRBActivos = new JRadioButton();
        this.JRBTodos1 = new JRadioButton();
        this.JRBInactivos = new JRadioButton();
        this.JRBSinConfigurar = new JRadioButton();
        setClosable(true);
        setTitle("SERVICIO POR EMPRESA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifempresaserviciosN");
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.f23JBTActualizarAo.setFont(new Font("Arial", 1, 12));
        this.f23JBTActualizarAo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.f23JBTActualizarAo.setText("Actualizar Año");
        this.f23JBTActualizarAo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.1
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaServiciosN.this.m77JBTActualizarAoActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBActivos);
        this.JRBActivos.setFont(new Font("Arial", 1, 12));
        this.JRBActivos.setSelected(true);
        this.JRBActivos.setText("Activos");
        this.JRBActivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.2
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaServiciosN.this.JRBActivosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBTodos1);
        this.JRBTodos1.setFont(new Font("Arial", 1, 12));
        this.JRBTodos1.setText("Todos");
        this.JRBTodos1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.3
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaServiciosN.this.JRBTodos1ActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBInactivos);
        this.JRBInactivos.setFont(new Font("Arial", 1, 12));
        this.JRBInactivos.setText("Inactivo");
        this.JRBInactivos.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.4
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaServiciosN.this.JRBInactivosActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBSinConfigurar);
        this.JRBSinConfigurar.setFont(new Font("Arial", 1, 12));
        this.JRBSinConfigurar.setText("Sin Configurar");
        this.JRBSinConfigurar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.5
            public void actionPerformed(ActionEvent evt) {
                JIFFEmpresaServiciosN.this.JRBSinConfigurarActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalle, -1, 848, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JRBTodos1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBActivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBInactivos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBSinConfigurar)).addComponent(this.f23JBTActualizarAo, -2, 600, -2)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodos1).addComponent(this.JRBActivos).addComponent(this.JRBInactivos).addComponent(this.JRBSinConfigurar)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 341, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.f23JBTActualizarAo, -2, 44, -2).addGap(10, 10, 10)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: JBTActualizarAñoActionPerformed, reason: contains not printable characters */
    public void m77JBTActualizarAoActionPerformed(ActionEvent evt) {
        if (this.tabla_combo.getRowCount() > 0) {
            String anno = this.xmetodos.formatoANO.format(this.xmetodos.getFechaActual());
            for (int x = 0; x < this.tabla_combo.getRowCount(); x++) {
                if (this.xmodelo.getValueAt(x, 9).toString().equals("ACTIVO")) {
                    this.xmodelo.setValueAt(anno, x, 4);
                }
            }
        }
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodos1ActionPerformed(ActionEvent evt) {
        this.filtro = "-1,0,1";
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBActivosActionPerformed(ActionEvent evt) {
        this.filtro = "0";
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBInactivosActionPerformed(ActionEvent evt) {
        this.filtro = "1";
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinConfigurarActionPerformed(ActionEvent evt) {
        this.filtro = "-1";
        mCargarDatosTabla();
    }

    private JTableComboBox mLlenaComboModelo1(int xFila) {
        try {
            this.xcomboBox[xFila] = new JTableComboBox();
            this.xcomboBox[xFila].setName("combo" + xFila);
            ConsultasMySQL xct1 = new ConsultasMySQL();
            xct1.llenarComboTabla("SELECT Id, Nbre, AplicaFactor FROM f_manual WHERE (Estado =0) ORDER BY Nbre ASC", this.xcomboBox[xFila], this.modcombos, 1);
            xct1.cerrarConexionBd();
            this.xlleno = true;
        } catch (IncompatibleLookAndFeelException e) {
        }
        return this.xcomboBox[xFila];
    }

    public void mNuevo() {
        mCargarDatosTabla();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mGrabar() {
        /*
            Method dump skipped, instruction units count: 701
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.mGrabar():void");
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdServicio", "Servicio", "Manual", "Incremento", "Año", "Descuento", "No. Copias", "Aplica Factor", "Estado", "grabado", "idManual", "BloqueoFactor"}) { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.6
            Class[] types = {Long.class, String.class, JTableComboBox[].class, JSpinner.class, JSpinner.class, JSpinner.class, JSpinner.class, Boolean.class, Boolean.class, String.class, Long.class, Integer.class};
            boolean[] canEdit = {false, false, true, true, true, true, true, true, true, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.tabla_combo = new JTable(this.xmodelo) { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.7
            public TableCellEditor getCellEditor(int row, int column) {
                int modelColumn = convertColumnIndexToModel(column);
                if (modelColumn == 2 && row < JIFFEmpresaServiciosN.this.tabla_combo.getRowCount()) {
                    return (TableCellEditor) JIFFEmpresaServiciosN.this.editors.get(row);
                }
                return super.getCellEditor(row, column);
            }
        };
        TableColumn column = this.tabla_combo.getColumnModel().getColumn(3);
        column.setCellEditor(new SpinnerEditor(3));
        TableColumn column2 = this.tabla_combo.getColumnModel().getColumn(4);
        column2.setCellEditor(new SpinnerEditor(4));
        TableColumn column3 = this.tabla_combo.getColumnModel().getColumn(5);
        column3.setCellEditor(new SpinnerEditor(5));
        TableColumn column4 = this.tabla_combo.getColumnModel().getColumn(6);
        column4.setCellEditor(new SpinnerEditor(6));
        this.tabla_combo.setFont(new Font("Arial", 1, 12));
        this.tabla_combo.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(1).setPreferredWidth(120);
        this.tabla_combo.getColumnModel().getColumn(2).setPreferredWidth(120);
        this.tabla_combo.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.tabla_combo.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.tabla_combo.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.tabla_combo.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.tabla_combo.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.tabla_combo.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.tabla_combo.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.tabla_combo.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(10).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(10).setMaxWidth(0);
        this.tabla_combo.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.tabla_combo.getColumnModel().getColumn(11).setMinWidth(0);
        this.tabla_combo.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JSPDetalle.getViewport().add(this.tabla_combo);
        setEventoMouseClicked(this.tabla_combo);
    }

    private void mCargarDatosTabla() {
        this.editors = new ArrayList();
        this.list = null;
        if (Principal.informacionIps.getNombreIps().equals("BIEN ESTAR SALUD BS S.A.S.")) {
            this.list = this.xEmpresaServicioDAO.listarEmpresaServicio(Long.valueOf(this.xclase.xjifempresaBienestar.xidempresacont), this.filtro);
        } else {
            this.list = this.xEmpresaServicioDAO.listarEmpresaServicio(Long.valueOf(this.xclase.xjifempresa.xidempresacont), this.filtro);
        }
        mCrearModeloDatos();
        if (this.list.size() > 0) {
            this.xcomboBox = new JTableComboBox[this.list.size()];
            for (int x = 0; x < this.list.size(); x++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.list.get(x)[0], x, 0);
                this.xmodelo.setValueAt(this.list.get(x)[1], x, 1);
                this.xmodelo.setValueAt(this.list.get(x)[2], x, 2);
                this.xmodelo.setValueAt(this.list.get(x)[3], x, 3);
                this.xmodelo.setValueAt(this.list.get(x)[4], x, 4);
                this.xmodelo.setValueAt(this.list.get(x)[5], x, 5);
                this.xmodelo.setValueAt(this.list.get(x)[6], x, 6);
                if (Boolean.valueOf(this.list.get(x)[7].toString()).booleanValue()) {
                    this.xmodelo.setValueAt(true, x, 7);
                } else {
                    this.xmodelo.setValueAt(false, x, 7);
                }
                if (!Boolean.valueOf(this.list.get(x)[8].toString()).booleanValue()) {
                    this.xmodelo.setValueAt(true, x, 8);
                } else {
                    this.xmodelo.setValueAt(false, x, 8);
                }
                this.xmodelo.setValueAt(this.list.get(x)[9], x, 9);
                this.xmodelo.setValueAt(this.list.get(x)[10], x, 10);
                this.xmodelo.setValueAt(this.list.get(x)[11], x, 11);
                DefaultCellEditor defaultCellEditor = new DefaultCellEditor(mLlenaComboModelo1(x));
                this.editors.add(defaultCellEditor);
                this.xcomboBox[x].addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.8
                    public void itemStateChanged(ItemEvent e) {
                        System.out.println("item seleccionado-->" + e.getItem());
                        if (JIFFEmpresaServiciosN.this.tabla_combo.getSelectedRow() == -1) {
                            JIFFEmpresaServiciosN.this.tabla_combo.setRowSelectionInterval(0, 0);
                        }
                        JIFFEmpresaServiciosN.this.mCambiaElementoCombo();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mCambiaElementoCombo() {
        if (this.xcomboBox[this.tabla_combo.getSelectedRow()].getSelectedIndex() != -1 && this.xlleno) {
            this.xmodelo.setValueAt(Long.valueOf(this.xcomboBox[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 0).toString()), this.tabla_combo.getSelectedRow(), 10);
            if (this.xcomboBox[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 2).toString().equals("true")) {
                this.xmodelo.setValueAt(1, this.tabla_combo.getSelectedRow(), 11);
            } else {
                this.xmodelo.setValueAt(false, this.tabla_combo.getSelectedRow(), 7);
                this.xmodelo.setValueAt(0, this.tabla_combo.getSelectedRow(), 11);
            }
            System.out.println("ID Manual: " + this.xcomboBox[this.tabla_combo.getSelectedRow()].getPopupTable().getValueAt(this.xcomboBox[this.tabla_combo.getSelectedRow()].getSelectedIndex(), 0));
            return;
        }
        System.out.println("Entro al modelo---- :(");
    }

    private void setEventoMouseClicked(JTable tbl) {
        tbl.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.parametrizacion.JIFFEmpresaServiciosN.9
            public void mouseClicked(MouseEvent e) {
                JIFFEmpresaServiciosN.this.JTDetalleMouseClicked(e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.tabla_combo.getSelectedRow() > -1) {
            mCambiaElementoCombo();
            if (this.xmodelo.getValueAt(this.tabla_combo.getSelectedRow(), 11).toString().equals("0")) {
                this.xmodelo.setValueAt(false, this.tabla_combo.getSelectedRow(), 7);
            }
            System.out.println("Se seleccionó la fila-->" + this.tabla_combo.getSelectedRow());
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/parametrizacion/JIFFEmpresaServiciosN$SpinnerEditor.class */
    class SpinnerEditor extends DefaultCellEditor {
        private JSpinner spinner;

        public SpinnerEditor(int pos) {
            super(new JTextField());
            if (pos == 3) {
                this.spinner = new JSpinner(new SpinnerNumberModel(0.0d, -100.0d, 100.0d, 0.01d));
            } else if (pos == 5) {
                this.spinner = new JSpinner(new SpinnerNumberModel(0.0d, 0.0d, 100.0d, 0.01d));
            } else if (pos == 6 || pos == 4) {
                this.spinner = new JSpinner(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
            }
            this.spinner.setBorder((Border) null);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.spinner.setValue(value);
            return this.spinner;
        }

        public Object getCellEditorValue() {
            return this.spinner.getValue();
        }
    }
}
