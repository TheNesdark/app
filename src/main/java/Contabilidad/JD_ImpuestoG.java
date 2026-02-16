package Contabilidad;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcDetalleCuentacobrom;
import com.genoma.plus.jpa.entities.CcDetalleCuentacobromImpuesto;
import com.genoma.plus.jpa.entities.CcTipoImpuesto;
import com.genoma.plus.jpa.entities.MCcFacturaInternaDetalle;
import com.genoma.plus.jpa.entities.MCcFacturaInternaDetalleImpuestos;
import com.genoma.plus.jpa.projection.IimpuestoProjection;
import com.genoma.plus.jpa.service.ImpuestoService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JD_ImpuestoG.class */
public class JD_ImpuestoG extends JDialog {
    private DefaultTableModel modelo;
    private Metodos xmt;
    public List<IimpuestoProjection> iimpuestos;
    private ImpuestoService impuestoService;
    private Object[] dato;
    private Integer xIdTercero;
    public List<MCcFacturaInternaDetalleImpuestos> LccFacturaInternaDetalleImpuestoses;
    public List<CcDetalleCuentacobromImpuesto> ccDetalleCuentacobromImpuestos;
    private final MCcFacturaInternaDetalle facturaInternaDetalle;
    private Double valorBase;
    private Double valor;
    private boolean lleno;
    private String xllamador;
    private CcDetalleCuentacobrom ccDetalleCuentacobrom;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JPanel JPI_EEncabezado;
    private JScrollPane JSPDetalle;
    private JTable JTResultado;
    private ButtonGroup buttonGroup1;

    public JD_ImpuestoG(Frame parent, boolean modal, Integer idEmpresa, MCcFacturaInternaDetalle facturaDEtalle, Double valorBase, String llamador, CcDetalleCuentacobrom cdc) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xIdTercero = 0;
        this.LccFacturaInternaDetalleImpuestoses = new ArrayList();
        this.ccDetalleCuentacobromImpuestos = new ArrayList();
        this.valorBase = Double.valueOf(0.0d);
        this.valor = Double.valueOf(0.0d);
        this.lleno = false;
        this.xllamador = "";
        this.ccDetalleCuentacobrom = new CcDetalleCuentacobrom();
        initComponents();
        this.facturaInternaDetalle = facturaDEtalle;
        this.xIdTercero = idEmpresa;
        this.impuestoService = (ImpuestoService) Principal.contexto.getBean(ImpuestoService.class);
        this.valorBase = valorBase;
        this.xllamador = llamador;
        this.iimpuestos = new ArrayList();
        this.ccDetalleCuentacobrom = cdc;
        llenarDatosTabla();
        this.lleno = true;
    }

    private void noConstructor(boolean visible) {
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPI_EEncabezado = new JPanel();
        this.JSPDetalle = new JScrollPane();
        this.JTResultado = new JTable();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("IMPUESTOS");
        this.JPI_EEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTResultado.setBorder(BorderFactory.createBevelBorder(0));
        this.JTResultado.setFont(new Font("Arial", 1, 12));
        this.JTResultado.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTResultado.setEditingColumn(1);
        this.JTResultado.setEditingRow(1);
        this.JTResultado.setSelectionBackground(new Color(255, 255, 255));
        this.JTResultado.setSelectionForeground(Color.red);
        this.JTResultado.setSelectionMode(0);
        this.JTResultado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Contabilidad.JD_ImpuestoG.1
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JD_ImpuestoG.this.JTResultadoPropertyChange(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTResultado);
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBTGrabar.setText("Grabar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Contabilidad.JD_ImpuestoG.2
            public void actionPerformed(ActionEvent evt) {
                JD_ImpuestoG.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Contabilidad.JD_ImpuestoG.3
            public void actionPerformed(ActionEvent evt) {
                JD_ImpuestoG.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout JPI_EEncabezadoLayout = new GroupLayout(this.JPI_EEncabezado);
        this.JPI_EEncabezado.setLayout(JPI_EEncabezadoLayout);
        JPI_EEncabezadoLayout.setHorizontalGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPDetalle, -2, 806, -2).addGroup(GroupLayout.Alignment.TRAILING, JPI_EEncabezadoLayout.createSequentialGroup().addComponent(this.JBTGrabar, -2, 277, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 264, -2))).addContainerGap(16, 32767)));
        JPI_EEncabezadoLayout.setVerticalGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_EEncabezadoLayout.createSequentialGroup().addContainerGap(17, 32767).addComponent(this.JSPDetalle, -2, 201, -2).addGap(18, 18, 18).addGroup(JPI_EEncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTSalir, -1, 50, 32767).addComponent(this.JBTGrabar, -1, -1, 32767)).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_EEncabezado, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_EEncabezado, -2, -1, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        try {
            if ("facturaInterna".equals(this.xllamador)) {
                for (int i = 0; i < this.JTResultado.getRowCount(); i++) {
                    if (this.modelo.getValueAt(i, 5).equals(true)) {
                        MCcFacturaInternaDetalleImpuestos impuestos = new MCcFacturaInternaDetalleImpuestos();
                        CcTipoImpuesto tipoImpuesto = new CcTipoImpuesto();
                        tipoImpuesto.setId(Integer.valueOf(this.JTResultado.getValueAt(i, 0).toString()));
                        impuestos.setBase(Double.valueOf(this.JTResultado.getValueAt(i, 3).toString()));
                        impuestos.setValor(Double.valueOf(this.JTResultado.getValueAt(i, 4).toString()));
                        impuestos.setPorcentaje(Double.valueOf(this.JTResultado.getValueAt(i, 2).toString()));
                        impuestos.setIdTipoImpuesto(tipoImpuesto);
                        impuestos.setIdFacturaDetalle(this.facturaInternaDetalle);
                        System.out.println("el tipo de impuesto " + impuestos.getIdTipoImpuesto());
                        this.LccFacturaInternaDetalleImpuestoses.add(impuestos);
                        System.out.println("el impuesto: " + impuestos.toString());
                    }
                }
                this.facturaInternaDetalle.setMCcFacturaInternaDetalleImpuestosCollection(this.LccFacturaInternaDetalleImpuestoses);
                dispose();
            } else if ("cuentaCobro".equals(this.xllamador)) {
                for (int i2 = 0; i2 < this.JTResultado.getRowCount(); i2++) {
                    if (this.modelo.getValueAt(i2, 5).equals(true)) {
                        CcDetalleCuentacobromImpuesto impuesto = new CcDetalleCuentacobromImpuesto();
                        CcTipoImpuesto impuesto1 = new CcTipoImpuesto();
                        impuesto1.setId(Integer.valueOf(this.JTResultado.getValueAt(i2, 0).toString()));
                        impuesto.setBase(Double.valueOf(this.JTResultado.getValueAt(i2, 3).toString()));
                        impuesto.setValor(Double.valueOf(this.JTResultado.getValueAt(i2, 4).toString()));
                        impuesto.setPorcentaje(Double.valueOf(this.JTResultado.getValueAt(i2, 2).toString()));
                        impuesto.setIdTipoImpuesto(impuesto1);
                        impuesto.setIdCuentaDetalleD(this.ccDetalleCuentacobrom);
                        System.out.println("el tipo de impuesto " + impuesto.getIdTipoImpuesto());
                        this.ccDetalleCuentacobromImpuestos.add(impuesto);
                        System.out.println("el impuesto: " + impuesto.toString());
                    }
                }
                this.ccDetalleCuentacobrom.setMCcFacturaInternaDetalleCollection(this.ccDetalleCuentacobromImpuestos);
                dispose();
            }
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    public void llenarDatosImpuesto() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTResultadoPropertyChange(PropertyChangeEvent evt) {
        if (this.lleno) {
            calcular();
        }
    }

    private void crearTabla() {
        this.modelo = new DefaultTableModel((Object[][]) null, new String[]{"idTipoImpuesto", "nombreImpuesto", "%Impuesto", "Base", "Valor", "Seleccionar"}) { // from class: Contabilidad.JD_ImpuestoG.4
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTResultado.setAutoResizeMode(0);
        this.JTResultado.doLayout();
        this.JTResultado.setModel(this.modelo);
        this.JTResultado.getColumnModel().getColumn(0).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTResultado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTResultado.getColumnModel().getColumn(5).setPreferredWidth(100);
    }

    public void llenarDatosTabla() {
        System.out.println("el id del tercero en el 3 es: " + this.xIdTercero);
        crearTabla();
        this.iimpuestos = this.impuestoService.listarIMpuestos(this.xIdTercero);
        if (this.iimpuestos != null && !this.iimpuestos.isEmpty()) {
            this.iimpuestos.forEach(detalle -> {
                this.modelo.addRow(this.dato);
                this.JTResultado.setValueAt(detalle.getIdTipoImpuesto(), this.JTResultado.getRowCount() - 1, 0);
                this.JTResultado.setValueAt(detalle.getNombreImpuesto(), this.JTResultado.getRowCount() - 1, 1);
                this.JTResultado.setValueAt(detalle.getPorcentajeImpuesto(), this.JTResultado.getRowCount() - 1, 2);
                this.JTResultado.setValueAt(this.valorBase, this.JTResultado.getRowCount() - 1, 3);
                this.valor = Double.valueOf((this.valorBase.doubleValue() * detalle.getPorcentajeImpuesto().doubleValue()) / 100.0d);
                this.JTResultado.setValueAt(this.valor, this.JTResultado.getRowCount() - 1, 4);
                this.JTResultado.setValueAt(false, this.JTResultado.getRowCount() - 1, 5);
            });
        }
    }

    private void calcular() {
        for (int x = 0; x < this.JTResultado.getRowCount(); x++) {
            this.JTResultado.setValueAt(Double.valueOf((Double.valueOf(this.JTResultado.getValueAt(x, 3).toString()).doubleValue() * Double.valueOf(this.JTResultado.getValueAt(x, 2).toString()).doubleValue()) / 100.0d), x, 4);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Contabilidad/JD_ImpuestoG$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (table.getValueAt(row, 8) == null || table.getValueAt(row, 8).toString().equals("")) {
                cell.setBackground(Color.white);
                cell.setForeground(Color.BLACK);
            } else if (table.getValueAt(row, 8) == null || table.getValueAt(row, 8).toString().equals("SUCCESS")) {
                cell.setBackground(Color.GREEN);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
