package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.PpRubros;
import com.genoma.plus.jpa.entities.PpRubrosCentrocostos;
import com.genoma.plus.jpa.entities.PpRubrosCpc;
import com.genoma.plus.jpa.entities.PpRubrosCpcCentrocostoFuntefinanciacion;
import com.genoma.plus.jpa.entities.PpRubrosFuenteFinanciacion;
import com.genoma.plus.jpa.service.IPpRubrosCentrocostosService;
import com.genoma.plus.jpa.service.IPpRubrosCpcCentrocostoFuntefinanciacionService;
import com.genoma.plus.jpa.service.IPpRubrosCpcService;
import com.genoma.plus.jpa.service.IPpRubrosFuenteFinanciacionService;
import com.genoma.plus.jpa.service.IPpRubrosService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JDRubrosCPCCentroCostoFuenteFinanciacion.class */
public class JDRubrosCPCCentroCostoFuenteFinanciacion extends JDialog {
    private DefaultTableModel modelo;
    private Metodos metodos;
    private final IPpRubrosCpcCentrocostoFuntefinanciacionService ppRubrosCpcCentrocostoFuntefinanciacionService;
    private List<PpRubrosCpcCentrocostoFuntefinanciacion> listaRubrosC;
    private final PpRubrosCpcCentrocostoFuntefinanciacion ppRubrosCpcCentrocostoFuntefinanciacion;
    private final PpRubrosCentrocostos centrocostos;
    private final IPpRubrosCentrocostosService centrocostoService;
    private List<PpRubrosCentrocostos> listaCentroCostos;
    private final PpRubros rubros;
    private final IPpRubrosService rubroService;
    private List<PpRubros> listaRubros;
    private final PpRubrosCpc cpc;
    private final IPpRubrosCpcService cpcService;
    private List<PpRubrosCpc> listaCpc;
    private final PpRubrosFuenteFinanciacion fuenteFinanciacion;
    private final IPpRubrosFuenteFinanciacionService fuenteFinanciacionService;
    private List<PpRubrosFuenteFinanciacion> listaFuenteFinanciacion;
    private Object[] datos;
    private Boolean estado;
    private JButton JBT_Grabar;
    private JButton JBT_Salir;
    private JComboBox JCBCPC;
    private JComboBox JCBCentroCosto;
    private JComboBox JCBFuenteFinanciacion;
    private JComboBox JCBRubro;
    private JCheckBox JCHEstado;
    private JScrollPane JSPDetalle;
    private JTable JTDetalle;
    private JPanel jPanel1;

    public JDRubrosCPCCentroCostoFuenteFinanciacion(Frame parent, boolean modal) {
        super(parent, modal);
        this.modelo = new DefaultTableModel();
        this.metodos = new Metodos();
        initComponents();
        this.metodos = new Metodos();
        this.ppRubrosCpcCentrocostoFuntefinanciacionService = (IPpRubrosCpcCentrocostoFuntefinanciacionService) Principal.contexto.getBean(IPpRubrosCpcCentrocostoFuntefinanciacionService.class);
        this.listaRubrosC = new ArrayList();
        this.ppRubrosCpcCentrocostoFuntefinanciacion = new PpRubrosCpcCentrocostoFuntefinanciacion();
        this.centrocostos = new PpRubrosCentrocostos();
        this.centrocostoService = (IPpRubrosCentrocostosService) Principal.contexto.getBean(IPpRubrosCentrocostosService.class);
        this.listaCentroCostos = new ArrayList();
        this.rubros = new PpRubros();
        this.rubroService = (IPpRubrosService) Principal.contexto.getBean(IPpRubrosService.class);
        this.listaRubros = new ArrayList();
        this.cpc = new PpRubrosCpc();
        this.cpcService = (IPpRubrosCpcService) Principal.contexto.getBean(IPpRubrosCpcService.class);
        this.listaCpc = new ArrayList();
        this.fuenteFinanciacion = new PpRubrosFuenteFinanciacion();
        this.fuenteFinanciacionService = (IPpRubrosFuenteFinanciacionService) Principal.contexto.getBean(IPpRubrosFuenteFinanciacionService.class);
        this.listaFuenteFinanciacion = new ArrayList();
        this.estado = true;
        cargarCombos();
        cargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JCBRubro = new JComboBox();
        this.JCBCentroCosto = new JComboBox();
        this.JCBFuenteFinanciacion = new JComboBox();
        this.JCBCPC = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JCHEstado = new JCheckBox();
        setDefaultCloseOperation(2);
        setTitle("RUBROS CPC CENTRO COSTO FUNTEFINANCIACION");
        setName("rubroscpccentrocostofuentefinanciacion");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÖN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBRubro.setFont(new Font("Arial", 1, 12));
        this.JCBRubro.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCentroCosto.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCosto.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro Costos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBFuenteFinanciacion.setFont(new Font("Arial", 1, 12));
        this.JCBFuenteFinanciacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Fuente Financiación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCPC.setFont(new Font("Arial", 1, 12));
        this.JCBCPC.setBorder(BorderFactory.createTitledBorder((Border) null, "CPC", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBRubro, -2, 334, -2).addGap(18, 18, 18).addComponent(this.JCBCentroCosto, -2, 334, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBFuenteFinanciacion, -2, 334, -2).addGap(18, 18, 18).addComponent(this.JCBCPC, -2, 334, -2))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(14, 14, 14).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBRubro, -2, 50, -2).addComponent(this.JCBCentroCosto, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBFuenteFinanciacion, -2, 50, -2).addComponent(this.JCBCPC, -2, 50, -2)).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JDRubrosCPCCentroCostoFuenteFinanciacion.1
            public void mouseClicked(MouseEvent evt) {
                JDRubrosCPCCentroCostoFuenteFinanciacion.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDRubrosCPCCentroCostoFuenteFinanciacion.2
            public void actionPerformed(ActionEvent evt) {
                JDRubrosCPCCentroCostoFuenteFinanciacion.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDRubrosCPCCentroCostoFuenteFinanciacion.3
            public void actionPerformed(ActionEvent evt) {
                JDRubrosCPCCentroCostoFuenteFinanciacion.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JDRubrosCPCCentroCostoFuenteFinanciacion.4
            public void actionPerformed(ActionEvent evt) {
                JDRubrosCPCCentroCostoFuenteFinanciacion.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalle)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado)).addGroup(layout.createSequentialGroup().addGap(113, 113, 113).addComponent(this.JBT_Grabar, -2, 253, -2).addGap(90, 90, 90).addComponent(this.JBT_Salir, -2, 246, -2)))).addContainerGap(19, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(132, 132, 132).addComponent(this.JCHEstado))).addGap(18, 18, 18).addComponent(this.JSPDetalle, -2, 227, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            this.JCHEstado.setSelected(Boolean.valueOf(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString()).booleanValue());
            this.JCBCPC.setSelectedItem(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JCBCentroCosto.setSelectedItem(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
            this.JCBFuenteFinanciacion.setSelectedItem(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JCBRubro.setSelectedItem(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            Principal.txtNo.setText(this.modelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        grabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.estado = true;
        } else {
            this.estado = false;
        }
    }

    private void cargarCombos() {
        this.listaCentroCostos = this.centrocostoService.getListPpRubrosCentrocostosOrderByNombreAsc();
        this.listaCentroCostos.forEach(a -> {
            this.JCBCentroCosto.addItem(a.getNombre());
        });
        this.JCBCentroCosto.setSelectedIndex(-1);
        this.listaRubros = this.rubroService.listarRubros();
        this.listaRubros.forEach(a2 -> {
            this.JCBRubro.addItem(a2.getNbre());
        });
        this.JCBRubro.setSelectedIndex(-1);
        this.listaCpc = this.cpcService.getListPpRubrosCpcOrderbyNombreAsc();
        this.listaCpc.forEach(a3 -> {
            this.JCBCPC.addItem(a3.getNombre());
        });
        this.JCBCPC.setSelectedIndex(-1);
        this.listaFuenteFinanciacion = this.fuenteFinanciacionService.getListPpRubrosFuenteFinanciacionOrderByNombreAsc();
        this.listaFuenteFinanciacion.forEach(a4 -> {
            this.JCBFuenteFinanciacion.addItem(a4.getNombre());
        });
        this.JCBFuenteFinanciacion.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelodatos() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Rubro", "CPC", "Centro Costo", "Fuente Financiacion", "Estado", "ID"}) { // from class: ParametrizacionN.JDRubrosCPCCentroCostoFuenteFinanciacion.5
            Class[] types = {String.class, Integer.class, Integer.class, Integer.class, Boolean.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.doLayout();
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(5).setMaxWidth(0);
    }

    private void cargarDatosTabla() {
        crearModelodatos();
        this.listaRubrosC = new ArrayList();
        this.listaRubrosC = this.ppRubrosCpcCentrocostoFuntefinanciacionService.getListPpRubrosCpcCentrocostoFuntefinanciacion();
        this.listaRubrosC.forEach(a -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(a.getIdRubros().getNbre(), this.JTDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(a.getIdRubrosCpc().getNombre(), this.JTDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(a.getIdRubrosCentroCostos().getNombre(), this.JTDetalle.getRowCount() - 1, 2);
            this.modelo.setValueAt(a.getIdRubrosFunteFinanciacion().getNombre(), this.JTDetalle.getRowCount() - 1, 3);
            this.modelo.setValueAt(a.getEstado(), this.JTDetalle.getRowCount() - 1, 4);
            this.modelo.setValueAt(a.getId(), this.JTDetalle.getRowCount() - 1, 5);
        });
    }

    private void grabar() {
        if (this.JCBCPC.getSelectedIndex() != -1) {
            if (this.JCBCentroCosto.getSelectedIndex() != -1) {
                if (this.JCBFuenteFinanciacion.getSelectedIndex() != -1) {
                    if (this.JCBRubro.getSelectedIndex() != -1) {
                        PpRubrosCpcCentrocostoFuntefinanciacion pp = new PpRubrosCpcCentrocostoFuntefinanciacion();
                        if (!Principal.txtNo.getText().isEmpty()) {
                            pp.setId(Long.valueOf(Long.parseLong(Principal.txtNo.getText())));
                        }
                        pp.setIdRubros(this.listaRubros.get(this.JCBRubro.getSelectedIndex()));
                        pp.setIdRubrosCentroCostos(this.listaCentroCostos.get(this.JCBCentroCosto.getSelectedIndex()));
                        pp.setIdRubrosCpc(this.listaCpc.get(this.JCBCPC.getSelectedIndex()));
                        pp.setIdRubrosFunteFinanciacion(this.listaFuenteFinanciacion.get(this.JCBFuenteFinanciacion.getSelectedIndex()));
                        pp.setEstado(this.estado);
                        pp.setFecha(this.metodos.getFechaActual());
                        System.out.println("Principal.getIdUsuarioS()" + Principal.getIdUsuarioS());
                        pp.setUsuarioSistema(Principal.getIdUsuarioS());
                        this.ppRubrosCpcCentrocostoFuntefinanciacionService.save(pp);
                        cargarDatosTabla();
                        nuevo();
                        return;
                    }
                    JOptionPane.showMessageDialog((Component) null, "Seleccione un rubro");
                    return;
                }
                JOptionPane.showMessageDialog((Component) null, "Seleccione una fuente de financiacion");
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "Seleccione un Centro de costos");
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Seleccione un CPC");
    }

    private void nuevo() {
        Principal.txtNo.setText("");
        this.JCBCPC.setSelectedIndex(-1);
        this.JCBFuenteFinanciacion.setSelectedIndex(-1);
        this.JCBRubro.setSelectedIndex(-1);
        this.JCBCentroCosto.setSelectedIndex(-1);
    }
}
