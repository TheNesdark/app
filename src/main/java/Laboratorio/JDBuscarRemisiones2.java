package Laboratorio;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcTerceros;
import com.genoma.plus.jpa.entities.LRemision;
import com.genoma.plus.jpa.projection.GProcedimientoEmpresaRemisionProjection;
import com.genoma.plus.jpa.service.CcTercerosService;
import com.genoma.plus.jpa.service.IGProcedimientoEmpresaRemisionService;
import com.genoma.plus.jpa.service.ILRemisionService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JDBuscarRemisiones2.class */
public class JDBuscarRemisiones2 extends JDialog {
    private List<GProcedimientoEmpresaRemisionProjection> listaEmpresaRemision;
    private final IGProcedimientoEmpresaRemisionService igpers;
    private CcTerceros terceros;
    private LRemision lRemision;
    private final ILRemisionService ilrs;
    private final CcTercerosService cts;
    private List<LRemision> listaRemision;
    private List<CcTerceros> listaTerceros;
    private Metodos metodos;
    private String sql;
    private String IdPersona;
    private String pantalla;
    private Object[] dato;
    private DefaultTableModel modelo;
    private int fila;
    private ResultadoManual frmRM;
    private JIFRemisionLab2 xjfrem;
    private JTable grid;
    private JLabel jLabel2;
    private JScrollPane jScrollPane1;

    public JDBuscarRemisiones2(Frame parent, boolean modal, JIFRemisionLab2 xjfrem) {
        super(parent, modal);
        this.metodos = new Metodos();
        initComponents();
        this.listaEmpresaRemision = new ArrayList();
        this.igpers = (IGProcedimientoEmpresaRemisionService) Principal.contexto.getBean(IGProcedimientoEmpresaRemisionService.class);
        this.ilrs = (ILRemisionService) Principal.contexto.getBean(ILRemisionService.class);
        this.cts = (CcTercerosService) Principal.contexto.getBean(CcTercerosService.class);
        this.listaTerceros = new ArrayList();
        this.listaRemision = new ArrayList();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjfrem = xjfrem;
        setLocationRelativeTo(null);
        crearGrid();
        cargarGrid();
    }

    private void crearGrid() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"No.", "Fecha", "Empresa", "Estado"}) { // from class: Laboratorio.JDBuscarRemisiones2.1
            Class[] types = {Long.class, String.class, String.class, Boolean.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        this.grid.setModel(this.modelo);
        this.grid.getColumnModel().getColumn(0).setPreferredWidth(30);
        this.grid.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.grid.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.grid.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.fila = 0;
    }

    private void cargarGrid() {
        this.listaEmpresaRemision = this.igpers.listarNat3();
        this.listaEmpresaRemision.forEach(e -> {
            this.modelo.addRow(this.dato);
            this.modelo.setValueAt(e.getId(), this.grid.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getFecha(), this.grid.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getRazonSocialCompleta(), this.grid.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getEstado(), this.grid.getRowCount() - 1, 3);
        });
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.grid = new JTable();
        this.jLabel2 = new JLabel();
        setDefaultCloseOperation(2);
        setName("BuscarResultado");
        this.grid.setFont(new Font("Arial", 1, 12));
        this.grid.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.grid.setColumnSelectionAllowed(true);
        this.grid.setRowHeight(25);
        this.grid.setSelectionBackground(new Color(255, 255, 255));
        this.grid.setSelectionForeground(new Color(255, 0, 0));
        this.grid.setSelectionMode(0);
        this.grid.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JDBuscarRemisiones2.2
            public void mouseClicked(MouseEvent evt) {
                JDBuscarRemisiones2.this.gridMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.grid);
        this.jLabel2.setFont(new Font("Arial", 1, 14));
        this.jLabel2.setForeground(new Color(0, 102, 0));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("BUSCAR RESULTADO");
        this.jLabel2.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 829, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, -1, 809, 32767).addComponent(this.jScrollPane1, -1, 809, 32767)).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 341, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2, -2, 31, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 282, -2).addContainerGap(-1, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gridMouseClicked(MouseEvent evt) {
        if (this.grid.getSelectedRow() != -1) {
            int idRemision = Integer.parseInt(this.modelo.getValueAt(this.grid.getSelectedRow(), 0).toString());
            this.listaEmpresaRemision = this.igpers.listarNat4(Integer.valueOf(idRemision));
            dispose();
        }
    }
}
