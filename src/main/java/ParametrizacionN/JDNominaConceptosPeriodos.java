package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.RhNominaConceptoPeriodo;
import com.genoma.plus.jpa.entities.RhNominaConceptos;
import com.genoma.plus.jpa.entities.RhNominaPeriodo;
import com.genoma.plus.jpa.service.IRhNominaConceptosPeriodoService;
import com.genoma.plus.jpa.service.IRhNominaPeriodoService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDNominaConceptosPeriodos.class */
public class JDNominaConceptosPeriodos extends JDialog {
    private DefaultTableModel modelo;
    private Metodos metodos;
    private final IRhNominaPeriodoService iRhNominaPeriodoService;
    private List<RhNominaPeriodo> listaRhNominaPeriodo;
    private Object[] datos;
    private final RhNominaConceptos nominaConceptos;
    private final IRhNominaConceptosPeriodoService iRhNominaConceptosPeriodoService;
    private JButton JBGrabar;
    private JButton JBSalir;
    private JCheckBox JCHBSeleccionarTodo;
    private JTable JTable;
    private JScrollPane jScrollPane1;

    public JDNominaConceptosPeriodos(Frame parent, boolean modal, Integer idConceptos) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.metodos = new Metodos();
        this.iRhNominaPeriodoService = (IRhNominaPeriodoService) Principal.contexto.getBean(IRhNominaPeriodoService.class);
        this.iRhNominaConceptosPeriodoService = (IRhNominaConceptosPeriodoService) Principal.contexto.getBean(IRhNominaConceptosPeriodoService.class);
        this.listaRhNominaPeriodo = new ArrayList();
        this.nominaConceptos = new RhNominaConceptos();
        this.nominaConceptos.setId(idConceptos);
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.JTable = new JTable();
        this.JBGrabar = new JButton();
        this.JBSalir = new JButton();
        this.JCHBSeleccionarTodo = new JCheckBox();
        setDefaultCloseOperation(2);
        setTitle("PERIODOS");
        setFont(new Font("Arial", 1, 12));
        this.JTable.setFont(new Font("Arial", 1, 12));
        this.JTable.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTable.setRowHeight(25);
        this.JTable.setSelectionBackground(new Color(255, 255, 255));
        this.JTable.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTable);
        this.JBGrabar.setFont(new Font("Arial", 1, 12));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBGrabar.setText("Grabar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDNominaConceptosPeriodos.1
            public void actionPerformed(ActionEvent evt) {
                JDNominaConceptosPeriodos.this.JBGrabarActionPerformed(evt);
            }
        });
        this.JBSalir.setFont(new Font("Arial", 1, 12));
        this.JBSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBSalir.setText("Salir");
        this.JBSalir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDNominaConceptosPeriodos.2
            public void actionPerformed(ActionEvent evt) {
                JDNominaConceptosPeriodos.this.JBSalirActionPerformed(evt);
            }
        });
        this.JCHBSeleccionarTodo.setFont(new Font("Arial", 1, 12));
        this.JCHBSeleccionarTodo.setText("Seleccionar todo");
        this.JCHBSeleccionarTodo.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDNominaConceptosPeriodos.3
            public void actionPerformed(ActionEvent evt) {
                JDNominaConceptosPeriodos.this.JCHBSeleccionarTodoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 551, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JBGrabar, -2, 250, -2).addGap(48, 48, 48).addComponent(this.JBSalir, -2, 250, -2).addGap(0, 0, 32767))).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCHBSeleccionarTodo).addGap(23, 23, 23)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.jScrollPane1, -2, 256, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHBSeleccionarTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBGrabar, -2, 50, -2).addComponent(this.JBSalir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHBSeleccionarTodoActionPerformed(ActionEvent evt) {
        seleccionar(this.JCHBSeleccionarTodo.isSelected());
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"ID PERIODO", "NOMBRE", "APLICA"}) { // from class: ParametrizacionN.JDNominaConceptosPeriodos.4
            Class[] types = {Integer.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTable.setModel(this.modelo);
        this.JTable.doLayout();
        this.JTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTable.getColumnModel().getColumn(2).setPreferredWidth(20);
    }

    private void cargarDatosTabla() {
        crearModeloDatos();
        this.listaRhNominaPeriodo = this.iRhNominaPeriodoService.listaPeriodo();
        this.listaRhNominaPeriodo.forEach(e -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(e.getId(), this.JTable.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getNbre(), this.JTable.getRowCount() - 1, 1);
            this.modelo.setValueAt(false, this.JTable.getRowCount() - 1, 2);
        });
    }

    private void grabar() {
        List<RhNominaConceptoPeriodo> listaRhNominaConceptosPeriodo = new ArrayList<>();
        for (int i = 0; i < this.JTable.getRowCount(); i++) {
            if (Boolean.valueOf(this.JTable.getValueAt(i, 2).toString()).booleanValue()) {
                RhNominaConceptoPeriodo rh = new RhNominaConceptoPeriodo();
                rh.setRhNominaConceptos(this.nominaConceptos);
                rh.setRhNominaPeriodo(this.listaRhNominaPeriodo.get(i));
                listaRhNominaConceptosPeriodo.add(rh);
            }
        }
        if (!listaRhNominaConceptosPeriodo.isEmpty()) {
            this.iRhNominaConceptosPeriodoService.grabar(listaRhNominaConceptosPeriodo);
        }
        JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
    }

    public void seleccionar(boolean estado) {
        for (int i = 0; i < this.JTable.getRowCount(); i++) {
            this.JTable.setValueAt(Boolean.valueOf(estado), i, 2);
        }
    }
}
