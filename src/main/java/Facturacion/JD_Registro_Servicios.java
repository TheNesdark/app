package Facturacion;

import Acceso.Principal;
import Citas.CitaNP;
import Utilidades.CargarCombosVarios;
import Utilidades.ConsultasMySQL;
import Utilidades.CustomPopupMenuListener;
import Utilidades.JTextFieldValidator;
import Utilidades.LlenarCombosGenericos;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GServicioGrupoEntity;
import com.genoma.plus.jpa.entities.GServicioRipsEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/JD_Registro_Servicios.class */
public class JD_Registro_Servicios extends JDialog {
    private JIFLiqServicios xjifliq;
    private CitaNP xCitaNP;
    private JPProcedimientos xjp_procedimiento;
    private Metodos xmt;
    private ConsultasMySQL xct;
    private String[][] xId_Procedimiento;
    private boolean xlleno;
    private String[] xId_CCosto;
    private String[] xId_Finalidad;
    private String xsql;
    private DefaultTableModel xModelo;
    private Object[] xDatos;
    private int x_Nfila;
    private long xId_Orden;
    private String idClaseProcedimiento;
    public List<GServicioGrupoEntity> listGrupoEntitys;
    public List<GServicioRipsEntity> ListripsEntitys;
    private JButton JBT_Adicionar;
    private JButton JBT_Grabar;
    private JButton JBT_Nuevo;
    private JButton JBT_Salir;
    private JComboBox JCBCentroCostoGen;
    private JComboBox JCBFinalidad;
    public JComboBox JCBGrupoSevicio;
    private JComboBox JCBProcedimientos;
    public JComboBox JCBSevicioRips;
    private JLabel JLN_Numero;
    private JPanel JPProcedimientos;
    private JScrollPane JSPDetalle;
    private JSpinner JSPPImpuesto;
    private JTable JTDetalle;
    public JTextFieldValidator JTFFCodigo;
    public JTextFieldValidator JTFF_Cantidad;
    private JFormattedTextField JTFF_TNPlan;
    private JFormattedTextField JTFF_TOrden;
    private JFormattedTextField JTFF_TPlan;
    private JFormattedTextField JTFF_VTotal;
    private JFormattedTextField JTFF_VTotalImpuesto;
    private JFormattedTextField JTFF_VUnitario;

    public JD_Registro_Servicios(Frame parent, boolean modal, JPProcedimientos xjp, String idClaseProcedimiento) {
        super(parent, modal);
        this.xmt = new Metodos();
        this.xct = new ConsultasMySQL();
        this.x_Nfila = 0;
        this.xId_Orden = 0L;
        initComponents();
        this.idClaseProcedimiento = idClaseProcedimiento;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.xjp_procedimiento = xjp;
        mNuevo();
        mCrearTabla();
    }

    /* JADX WARN: Type inference failed for: r3v70, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPProcedimientos = new JPanel();
        this.JCBProcedimientos = new JComboBox();
        this.JTFFCodigo = new JTextFieldValidator();
        this.JCBFinalidad = new JComboBox();
        this.JCBCentroCostoGen = new JComboBox();
        this.JTFF_Cantidad = new JTextFieldValidator();
        this.JTFF_VUnitario = new JFormattedTextField();
        this.JTFF_VTotal = new JFormattedTextField();
        this.JBT_Adicionar = new JButton();
        this.JTFF_VTotalImpuesto = new JFormattedTextField();
        this.JSPPImpuesto = new JSpinner();
        this.JCBGrupoSevicio = new JComboBox();
        this.JCBSevicioRips = new JComboBox();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBT_Grabar = new JButton();
        this.JBT_Salir = new JButton();
        this.JLN_Numero = new JLabel();
        this.JTFF_TOrden = new JFormattedTextField();
        this.JTFF_TNPlan = new JFormattedTextField();
        this.JTFF_TPlan = new JFormattedTextField();
        this.JBT_Nuevo = new JButton();
        setDefaultCloseOperation(2);
        this.JPProcedimientos.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBProcedimientos.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimientos.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos / Medicamento / Dispositivos Médicos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBProcedimientos.addItemListener(new ItemListener() { // from class: Facturacion.JD_Registro_Servicios.1
            public void itemStateChanged(ItemEvent evt) {
                JD_Registro_Servicios.this.JCBProcedimientosItemStateChanged(evt);
            }
        });
        this.JCBProcedimientos.addKeyListener(new KeyAdapter() { // from class: Facturacion.JD_Registro_Servicios.2
            public void keyPressed(KeyEvent evt) {
                JD_Registro_Servicios.this.JCBProcedimientosKeyPressed(evt);
            }
        });
        this.JTFFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigo.setHorizontalAlignment(0);
        this.JTFFCodigo.setExprecionRegular("^[a-zA-Z0-9]*$");
        this.JTFFCodigo.setFont(new Font("Arial", 1, 12));
        this.JTFFCodigo.addFocusListener(new FocusAdapter() { // from class: Facturacion.JD_Registro_Servicios.3
            public void focusLost(FocusEvent evt) {
                JD_Registro_Servicios.this.JTFFCodigoFocusLost(evt);
            }
        });
        this.JTFFCodigo.addActionListener(new ActionListener() { // from class: Facturacion.JD_Registro_Servicios.4
            public void actionPerformed(ActionEvent evt) {
                JD_Registro_Servicios.this.JTFFCodigoActionPerformed(evt);
            }
        });
        this.JTFFCodigo.addKeyListener(new KeyAdapter() { // from class: Facturacion.JD_Registro_Servicios.5
            public void keyPressed(KeyEvent evt) {
                JD_Registro_Servicios.this.JTFFCodigoKeyPressed(evt);
            }
        });
        this.JCBFinalidad.setFont(new Font("Arial", 1, 12));
        this.JCBFinalidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Finalidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBCentroCostoGen.setFont(new Font("Arial", 1, 12));
        this.JCBCentroCostoGen.setBorder(BorderFactory.createTitledBorder((Border) null, "Centro de Costo General", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_Cantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_Cantidad.setHorizontalAlignment(0);
        this.JTFF_Cantidad.setText("1");
        this.JTFF_Cantidad.setExprecionRegular("^[0-9]*$");
        this.JTFF_Cantidad.setFont(new Font("Arial", 1, 12));
        this.JTFF_Cantidad.addFocusListener(new FocusAdapter() { // from class: Facturacion.JD_Registro_Servicios.6
            public void focusGained(FocusEvent evt) {
                JD_Registro_Servicios.this.JTFF_CantidadFocusGained(evt);
            }
        });
        this.JTFF_Cantidad.addActionListener(new ActionListener() { // from class: Facturacion.JD_Registro_Servicios.7
            public void actionPerformed(ActionEvent evt) {
                JD_Registro_Servicios.this.JTFF_CantidadActionPerformed(evt);
            }
        });
        this.JTFF_Cantidad.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JD_Registro_Servicios.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JD_Registro_Servicios.this.JTFF_CantidadPropertyChange(evt);
            }
        });
        this.JTFF_Cantidad.addKeyListener(new KeyAdapter() { // from class: Facturacion.JD_Registro_Servicios.9
            public void keyPressed(KeyEvent evt) {
                JD_Registro_Servicios.this.JTFF_CantidadKeyPressed(evt);
            }
        });
        this.JTFF_VUnitario.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Unitario", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VUnitario.setForeground(Color.red);
        this.JTFF_VUnitario.setHorizontalAlignment(4);
        this.JTFF_VUnitario.setText("0");
        this.JTFF_VUnitario.setFont(new Font("Arial", 1, 12));
        this.JTFF_VUnitario.addActionListener(new ActionListener() { // from class: Facturacion.JD_Registro_Servicios.10
            public void actionPerformed(ActionEvent evt) {
                JD_Registro_Servicios.this.JTFF_VUnitarioActionPerformed(evt);
            }
        });
        this.JTFF_VUnitario.addKeyListener(new KeyAdapter() { // from class: Facturacion.JD_Registro_Servicios.11
            public void keyPressed(KeyEvent evt) {
                JD_Registro_Servicios.this.JTFF_VUnitarioKeyPressed(evt);
            }
        });
        this.JTFF_VTotal.setEditable(false);
        this.JTFF_VTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Total", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VTotal.setForeground(Color.red);
        this.JTFF_VTotal.setHorizontalAlignment(4);
        this.JTFF_VTotal.setText("0");
        this.JTFF_VTotal.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setFont(new Font("Arial", 1, 12));
        this.JBT_Adicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBT_Adicionar.setText("Adicionar");
        this.JBT_Adicionar.setName("JBAdicionaPProcedimiento");
        this.JBT_Adicionar.addActionListener(new ActionListener() { // from class: Facturacion.JD_Registro_Servicios.12
            public void actionPerformed(ActionEvent evt) {
                JD_Registro_Servicios.this.JBT_AdicionarActionPerformed(evt);
            }
        });
        this.JBT_Adicionar.addKeyListener(new KeyAdapter() { // from class: Facturacion.JD_Registro_Servicios.13
            public void keyPressed(KeyEvent evt) {
                JD_Registro_Servicios.this.JBT_AdicionarKeyPressed(evt);
            }
        });
        this.JTFF_VTotalImpuesto.setEditable(false);
        this.JTFF_VTotalImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "Vr. Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VTotalImpuesto.setForeground(Color.red);
        this.JTFF_VTotalImpuesto.setHorizontalAlignment(4);
        this.JTFF_VTotalImpuesto.setText("0");
        this.JTFF_VTotalImpuesto.setFont(new Font("Arial", 1, 12));
        this.JSPPImpuesto.setFont(new Font("Arial", 1, 12));
        this.JSPPImpuesto.setModel(new SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(100.0f), Float.valueOf(0.1f)));
        this.JSPPImpuesto.setBorder(BorderFactory.createTitledBorder((Border) null, "% Impuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPPImpuesto.addChangeListener(new ChangeListener() { // from class: Facturacion.JD_Registro_Servicios.14
            public void stateChanged(ChangeEvent evt) {
                JD_Registro_Servicios.this.JSPPImpuestoStateChanged(evt);
            }
        });
        this.JSPPImpuesto.addFocusListener(new FocusAdapter() { // from class: Facturacion.JD_Registro_Servicios.15
            public void focusLost(FocusEvent evt) {
                JD_Registro_Servicios.this.JSPPImpuestoFocusLost(evt);
            }
        });
        this.JSPPImpuesto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Facturacion.JD_Registro_Servicios.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JD_Registro_Servicios.this.JSPPImpuestoPropertyChange(evt);
            }
        });
        this.JCBGrupoSevicio.setFont(new Font("Arial", 1, 12));
        this.JCBGrupoSevicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Grupo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBGrupoSevicio.setName("grupoServicio");
        this.JCBGrupoSevicio.addItemListener(new ItemListener() { // from class: Facturacion.JD_Registro_Servicios.17
            public void itemStateChanged(ItemEvent evt) {
                JD_Registro_Servicios.this.JCBGrupoSevicioItemStateChanged(evt);
            }
        });
        this.JCBSevicioRips.setFont(new Font("Arial", 1, 12));
        this.JCBSevicioRips.setBorder(BorderFactory.createTitledBorder((Border) null, "Servicio Rips", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSevicioRips.setName("servicioRips");
        GroupLayout JPProcedimientosLayout = new GroupLayout(this.JPProcedimientos);
        this.JPProcedimientos.setLayout(JPProcedimientosLayout);
        JPProcedimientosLayout.setHorizontalGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createSequentialGroup().addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPProcedimientosLayout.createSequentialGroup().addComponent(this.JTFFCodigo, -2, 88, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBProcedimientos, -2, 467, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_Cantidad, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPPImpuesto, -2, 92, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_VUnitario)).addGroup(JPProcedimientosLayout.createSequentialGroup().addComponent(this.JCBCentroCostoGen, -2, 311, -2).addGap(12, 12, 12).addComponent(this.JCBFinalidad, -2, 304, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_VTotalImpuesto, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_VTotal, -2, 92, -2))).addContainerGap(-1, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPProcedimientosLayout.createSequentialGroup().addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBT_Adicionar, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPProcedimientosLayout.createSequentialGroup().addComponent(this.JCBGrupoSevicio, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBSevicioRips, -2, 490, -2))).addGap(49, 49, 49)))));
        JPProcedimientosLayout.setVerticalGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createSequentialGroup().addContainerGap().addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_Cantidad, -2, 50, -2).addComponent(this.JTFF_VUnitario, -2, 50, -2)).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCodigo, -2, 50, -2).addComponent(this.JCBProcedimientos, -2, 50, -2))).addComponent(this.JSPPImpuesto, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_VTotalImpuesto, -2, 50, -2).addComponent(this.JTFF_VTotal, -2, 50, -2)).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBCentroCostoGen, -2, 50, -2).addComponent(this.JCBFinalidad, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPProcedimientosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBGrupoSevicio, -2, 50, -2).addComponent(this.JCBSevicioRips, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767).addComponent(this.JBT_Adicionar).addContainerGap()));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Facturacion.JD_Registro_Servicios.18
            public void keyPressed(KeyEvent evt) {
                JD_Registro_Servicios.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JBT_Grabar.setFont(new Font("Arial", 1, 12));
        this.JBT_Grabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_Grabar.setMnemonic('G');
        this.JBT_Grabar.setText("Grabar");
        this.JBT_Grabar.setName("JBAdicionaPProcedimiento");
        this.JBT_Grabar.addActionListener(new ActionListener() { // from class: Facturacion.JD_Registro_Servicios.19
            public void actionPerformed(ActionEvent evt) {
                JD_Registro_Servicios.this.JBT_GrabarActionPerformed(evt);
            }
        });
        this.JBT_Grabar.addKeyListener(new KeyAdapter() { // from class: Facturacion.JD_Registro_Servicios.20
            public void keyPressed(KeyEvent evt) {
                JD_Registro_Servicios.this.JBT_GrabarKeyPressed(evt);
            }
        });
        this.JBT_Salir.setFont(new Font("Arial", 1, 12));
        this.JBT_Salir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBT_Salir.setMnemonic('S');
        this.JBT_Salir.setText("Salir");
        this.JBT_Salir.setName("JBAdicionaPProcedimiento");
        this.JBT_Salir.addActionListener(new ActionListener() { // from class: Facturacion.JD_Registro_Servicios.21
            public void actionPerformed(ActionEvent evt) {
                JD_Registro_Servicios.this.JBT_SalirActionPerformed(evt);
            }
        });
        this.JLN_Numero.setFont(new Font("Arial", 1, 14));
        this.JLN_Numero.setHorizontalAlignment(0);
        this.JLN_Numero.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Orden", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFF_TOrden.setEditable(false);
        this.JTFF_TOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TOrden.setForeground(Color.red);
        this.JTFF_TOrden.setHorizontalAlignment(4);
        this.JTFF_TOrden.setText("0");
        this.JTFF_TOrden.setFont(new Font("Arial", 1, 12));
        this.JTFF_TNPlan.setEditable(false);
        this.JTFF_TNPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Total No Plan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TNPlan.setForeground(Color.red);
        this.JTFF_TNPlan.setHorizontalAlignment(4);
        this.JTFF_TNPlan.setText("0");
        this.JTFF_TNPlan.setToolTipText("Valor no cubierto por el plan");
        this.JTFF_TNPlan.setFont(new Font("Arial", 1, 12));
        this.JTFF_TPlan.setEditable(false);
        this.JTFF_TPlan.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Plan", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_TPlan.setForeground(Color.red);
        this.JTFF_TPlan.setHorizontalAlignment(4);
        this.JTFF_TPlan.setText("0");
        this.JTFF_TPlan.setToolTipText("Valor cubierto por el plan");
        this.JTFF_TPlan.setFont(new Font("Arial", 1, 12));
        this.JBT_Nuevo.setFont(new Font("Arial", 1, 12));
        this.JBT_Nuevo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Nuevo.png")));
        this.JBT_Nuevo.setMnemonic('N');
        this.JBT_Nuevo.setText("Nuevo");
        this.JBT_Nuevo.setName("JBAdicionaPProcedimiento");
        this.JBT_Nuevo.addActionListener(new ActionListener() { // from class: Facturacion.JD_Registro_Servicios.22
            public void actionPerformed(ActionEvent evt) {
                JD_Registro_Servicios.this.JBT_NuevoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JLN_Numero, -2, 150, -2).addGap(205, 205, 205).addComponent(this.JTFF_TOrden, -2, 150, -2).addGap(34, 34, 34).addComponent(this.JTFF_TNPlan, -2, 150, -2).addGap(18, 18, 18).addComponent(this.JTFF_TPlan, -2, 150, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JBT_Nuevo, -2, 250, -2).addGap(49, 49, 49).addComponent(this.JBT_Grabar, -2, 250, -2).addGap(58, 58, 58).addComponent(this.JBT_Salir, -2, 250, -2))).addComponent(this.JPProcedimientos, -1, -1, -2).addComponent(this.JSPDetalle)).addGap(7, 7, 7)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPProcedimientos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 164, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLN_Numero, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_TOrden, -2, 50, -2).addComponent(this.JTFF_TPlan, -2, 50, -2).addComponent(this.JTFF_TNPlan, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBT_Grabar, -2, 50, -2).addComponent(this.JBT_Nuevo, -2, 50, -2).addComponent(this.JBT_Salir, -2, 50, -2)).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientosItemStateChanged(ItemEvent evt) {
        if (this.JCBProcedimientos.getSelectedIndex() != -1 && this.xlleno) {
            this.JTFFCodigo.setText(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][1]);
            this.JTFF_VUnitario.setValue(Double.valueOf(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][2]));
            this.JSPPImpuesto.setValue(Float.valueOf(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][6]));
            this.JCBFinalidad.setSelectedItem(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][3]);
            if (this.idClaseProcedimiento.equals("2") || this.idClaseProcedimiento.equals("4")) {
                cargarValoresPorDefecto();
            } else {
                this.JCBGrupoSevicio.setSelectedItem("Apoyo diagnóstico y complementación  terapéutica");
                this.JCBSevicioRips.setSelectedItem("SERVICIO FARMACEUTICO");
            }
            mCalcularValorT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_CantidadPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno && !this.JTFF_Cantidad.getText().isEmpty() && Integer.valueOf(this.JTFF_Cantidad.getText()).intValue() > 0) {
            mCalcularValorT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_CantidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_SalirActionPerformed(ActionEvent evt) {
        this.xjp_procedimiento.mCargarDatosTabla(String.valueOf(this.xjp_procedimiento.getXidingreso()));
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarActionPerformed(ActionEvent evt) {
        mAdicionar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBProcedimientosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBProcedimientos.transferFocus();
            this.JTFFCodigo.selectAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_CantidadKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 18 || evt.getKeyCode() == 10) {
            mCalcularValorT();
            this.JBT_Adicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_AdicionarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mAdicionar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoFocusLost(FocusEvent evt) {
        mBuscar_Codigo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoActionPerformed(ActionEvent evt) {
        mBuscar_Codigo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_CantidadFocusGained(FocusEvent evt) {
        this.JTFF_Cantidad.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getSelectedRow() != -1 && this.xId_Orden == 0) {
            this.xModelo.removeRow(this.JTDetalle.getSelectedRow());
            this.x_Nfila--;
            mCalcular_Valores();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NuevoActionPerformed(ActionEvent evt) {
        mNuevo();
        mCrearTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GrabarKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_VUnitarioKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 18 || evt.getKeyCode() == 10) {
            mCalcularValorT();
            this.JBT_Adicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_VUnitarioActionPerformed(ActionEvent evt) {
        if (!this.JTFF_Cantidad.getText().isEmpty() && Integer.valueOf(this.JTFF_Cantidad.getText()).intValue() > 0) {
            mCalcularValorT();
            this.JBT_Adicionar.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPImpuestoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPImpuestoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPPImpuestoStateChanged(ChangeEvent evt) {
        if (!this.JTFF_Cantidad.getText().isEmpty() && Integer.valueOf(this.JTFF_Cantidad.getText()).intValue() > 0) {
            mCalcularValorT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBGrupoSevicioItemStateChanged(ItemEvent evt) {
        if (this.xlleno) {
            this.JCBSevicioRips.removeAllItems();
            this.ListripsEntitys = new ArrayList();
            LlenarCombosGenericos<GServicioRipsEntity> combosGenericos = new LlenarCombosGenericos<>();
            this.ListripsEntitys = combosGenericos.getListComboLlenoParametro(this.JCBSevicioRips.getName(), this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()));
            this.ListripsEntitys.forEach(e -> {
                this.JCBSevicioRips.addItem(e.getNombre());
            });
            this.JCBSevicioRips.addPopupMenuListener(new CustomPopupMenuListener(true, false));
            if (!this.listGrupoEntitys.isEmpty()) {
            }
        }
    }

    private void cargarValoresPorDefecto() {
        CargarCombosVarios cargarCombosVarios = new CargarCombosVarios();
        cargarCombosVarios.cargarComboTableFinalidadPorProcedimiento(this.JCBFinalidad, Long.valueOf(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][0]));
        cargarCombosVarios.cargarComboBoxServicioGrupoProcedimiento(this.JCBGrupoSevicio, this.JCBSevicioRips, Long.valueOf(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][0]));
    }

    public void mCasting(JInternalFrame xGenerico) {
        if (xGenerico.getName().equals("jifLiqServicios")) {
            this.xjifliq = (JIFLiqServicios) xGenerico;
        } else if (xGenerico.getName().equals("CitaNP")) {
            this.xCitaNP = (CitaNP) xGenerico;
        }
    }

    private void mPaquete(String idProcPadre) {
        try {
            switch (this.xjp_procedimiento.getxMetodoFact()) {
                case 0:
                    this.xsql = "SELECT \t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            f_tarifaprocedimiento.CodCUPS, \n            IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo) AS Valor,\n                    f_tipofinprocedimiento.Id AS IdFinalidad , \n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto,  \n\t\t\t   g_servicios_rips.`id` AS idServicioRips, \n\t\t\t   g_servicios_rips.`nombre` AS nombreRips,\n\t\t\t   g_grupo_servicio.`id` AS idGrupoServicio,\n\t\t\t   g_grupo_servicio.`nombre` AS nombreGrupoServicio            FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN h_procedimientoxprelacionado ON g_procedimiento.Id=h_procedimientoxprelacionado.Id_Procedimiento \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t   INNER JOIN g_procedimiento_gserviciorips ON (g_procedimiento_gserviciorips.`idProcedimiento` = g_procedimiento.Id)\n\t\t   INNER JOIN g_servicios_rips              ON (g_procedimiento_gserviciorips.`idServicioRips` = g_servicios_rips.`id`)\n\t\t   INNER JOIN g_grupo_servicio              ON (g_grupo_servicio.`id` = g_servicios_rips.`idGrupoServicio`)            WHERE (f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "'  \n           AND h_procedimientoxprelacionado.`Estado`=1  AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "'\n            AND g_procedimiento.Estado=0 AND h_procedimientoxprelacionado.Id_ProcedimientoR='" + idProcPadre + "' ) \n    group by  f_tarifaprocedimiento.Id_Procedimiento         ORDER BY NProcedimiento ASC; ";
                    break;
                case 1:
                    this.xsql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            f_tarifaprocedimiento.CodCUPS, \n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\tEND) AS Valor,\t\n                    f_tipofinprocedimiento.Id AS IdFinalidad , \n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto,  \n\t\t\t   g_servicios_rips.`id` AS idServicioRips, \n\t\t\t   g_servicios_rips.`nombre` AS nombreRips,\n\t\t\t   g_grupo_servicio.`id` AS idGrupoServicio,\n\t\t\t   g_grupo_servicio.`nombre` AS nombreGrupoServicio\t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN h_procedimientoxprelacionado ON g_procedimiento.Id=h_procedimientoxprelacionado.Id_Procedimiento \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n\t\t    INNER JOIN g_procedimiento_gserviciorips ON (g_procedimiento_gserviciorips.`idProcedimiento` = g_procedimiento.Id)\n\t\t    INNER JOIN g_servicios_rips              ON (g_procedimiento_gserviciorips.`idServicioRips` = g_servicios_rips.`id`)\n\t\t    INNER JOIN g_grupo_servicio              ON (g_grupo_servicio.`id` = g_servicios_rips.`idGrupoServicio`)            WHERE f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "' \n           AND h_procedimientoxprelacionado.`Estado`=1 AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "'\n            AND g_procedimiento.Estado=0 AND h_procedimientoxprelacionado.Id_ProcedimientoR='" + idProcPadre + "' \n    group by  f_tarifaprocedimiento.Id_Procedimiento         ORDER BY NProcedimiento ASC;";
                    break;
                default:
                    this.xsql = " SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            f_tarifaprocedimiento.CodCUPS, \n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN (f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))\t\t\t\n\t\t\t\tWHEN 2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)))\n\t\t\t\tWHEN -1 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1)\n\t\t\t\tWHEN -2 THEN ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))\n\t\t\t\tWHEN 2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))))\n\t\t\t\tWHEN -1 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1)\n\t\t\t\tWHEN -2 THEN  ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n                    f_tipofinprocedimiento.Id AS IdFinalidad , \n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto,  \n\t\t\t   g_servicios_rips.`id` AS idServicioRips, \n\t\t\t   g_servicios_rips.`nombre` AS nombreRips,\n\t\t\t   g_grupo_servicio.`id` AS idGrupoServicio,\n\t\t\t   g_grupo_servicio.`nombre` AS nombreGrupoServicio\t\t \n\t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n            INNER JOIN h_procedimientoxprelacionado ON g_procedimiento.Id=h_procedimientoxprelacionado.Id_Procedimiento \n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t        INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n \t\t    INNER JOIN g_procedimiento_gserviciorips ON (g_procedimiento_gserviciorips.`idProcedimiento` = g_procedimiento.Id)\n\t\t    INNER JOIN g_servicios_rips              ON (g_procedimiento_gserviciorips.`idServicioRips` = g_servicios_rips.`id`)\n\t\t    INNER JOIN g_grupo_servicio              ON (g_grupo_servicio.`id` = g_servicios_rips.`idGrupoServicio`)\t\t    WHERE f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "' \n\t\t\tAND h_procedimientoxprelacionado.`Estado`=1    AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "' \n\t\t\t    AND g_procedimiento.Estado=0 AND h_procedimientoxprelacionado.Id_ProcedimientoR='" + idProcPadre + "'\n\tgroup by  f_tarifaprocedimiento.Id_Procedimiento \t       ORDER BY NProcedimiento ASC; ";
                    break;
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            while (xrs.next()) {
                try {
                    try {
                        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
                        this.xModelo.addRow(this.xDatos);
                        this.xModelo.setValueAt(xrs.getString("Id"), this.x_Nfila, 0);
                        this.xModelo.setValueAt(xrs.getString("NProcedimiento"), this.x_Nfila, 1);
                        this.xModelo.setValueAt(xrs.getString("IdFinalidad"), this.x_Nfila, 2);
                        this.xModelo.setValueAt(xrs.getString("NFinalidad"), this.x_Nfila, 3);
                        this.xModelo.setValueAt("1", this.x_Nfila, 4);
                        this.xModelo.setValueAt(Double.valueOf(xrs.getDouble("porcentajeImpuesto")), this.x_Nfila, 5);
                        this.xModelo.setValueAt(Double.valueOf((xrs.getDouble("porcentajeImpuesto") * xrs.getDouble("Valor")) / 100.0d), this.x_Nfila, 6);
                        this.xModelo.setValueAt(Double.valueOf(xrs.getDouble("Valor")), this.x_Nfila, 7);
                        this.xModelo.setValueAt(Double.valueOf(((xrs.getDouble("porcentajeImpuesto") * xrs.getDouble("Valor")) / 100.0d) + xrs.getDouble("Valor")), this.x_Nfila, 8);
                        this.xModelo.setValueAt(this.xId_CCosto[this.JCBCentroCostoGen.getSelectedIndex()], this.x_Nfila, 9);
                        this.xModelo.setValueAt(true, this.x_Nfila, 10);
                        this.xModelo.setValueAt(xrs.getString("Id_TipoPlan"), this.x_Nfila, 11);
                        if (this.idClaseProcedimiento.equals("2") || this.idClaseProcedimiento.equals("4")) {
                            this.xModelo.setValueAt("", this.x_Nfila, 12);
                        } else {
                            this.xModelo.setValueAt(this.xjp_procedimiento.xjpencabezado.txtNoPrescripcionMiPres.getText(), this.x_Nfila, 12);
                        }
                        this.xModelo.setValueAt("", this.x_Nfila, 13);
                        this.xModelo.setValueAt(xrs.getString("idGrupoServicio"), this.x_Nfila, 14);
                        this.xModelo.setValueAt(xrs.getString("nombreGrupoServicio"), this.x_Nfila, 15);
                        this.xModelo.setValueAt(xrs.getString("idServicioRips"), this.x_Nfila, 16);
                        this.xModelo.setValueAt(xrs.getString("nombreRips"), this.x_Nfila, 17);
                        this.x_Nfila++;
                        mCalcular_Valores();
                    } finally {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th2;
                }
            }
            if (xrs != null) {
                if (0 != 0) {
                    try {
                        xrs.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                } else {
                    xrs.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JD_Registro_Servicios.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mAdicionar() {
        if (this.JCBProcedimientos.getSelectedIndex() != -1) {
            if (this.JCBFinalidad.getSelectedIndex() != -1) {
                if (this.JCBCentroCostoGen.getSelectedIndex() != -1) {
                    if (this.JCBSevicioRips.getSelectedIndex() != -1) {
                        if (this.JCBGrupoSevicio.getSelectedIndex() != -1) {
                            if (!this.xmt.mVerificarDatosDoblesTabla(this.JTDetalle, 0, this.JTFFCodigo.getText())) {
                                if (this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][5].equals("1") && !this.xjp_procedimiento.xjpencabezado.getxIdServicio().equals("7")) {
                                    mPaquete(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][0]);
                                    return;
                                }
                                this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
                                this.xModelo.addRow(this.xDatos);
                                this.xModelo.setValueAt(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][0], this.x_Nfila, 0);
                                this.xModelo.setValueAt(this.JCBProcedimientos.getSelectedItem(), this.x_Nfila, 1);
                                this.xModelo.setValueAt(this.xId_Finalidad[this.JCBFinalidad.getSelectedIndex()], this.x_Nfila, 2);
                                this.xModelo.setValueAt(this.JCBFinalidad.getSelectedItem(), this.x_Nfila, 3);
                                this.xModelo.setValueAt(this.JTFF_Cantidad.getText(), this.x_Nfila, 4);
                                if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
                                    this.xModelo.setValueAt(this.JSPPImpuesto.getValue(), this.x_Nfila, 5);
                                } else {
                                    this.xModelo.setValueAt(new Integer(0), this.x_Nfila, 5);
                                }
                                this.xModelo.setValueAt(this.JTFF_VTotalImpuesto.getValue(), this.x_Nfila, 6);
                                this.xModelo.setValueAt(this.JTFF_VUnitario.getValue(), this.x_Nfila, 7);
                                this.xModelo.setValueAt(this.JTFF_VTotal.getValue(), this.x_Nfila, 8);
                                this.xModelo.setValueAt(this.xId_CCosto[this.JCBCentroCostoGen.getSelectedIndex()], this.x_Nfila, 9);
                                this.xModelo.setValueAt(true, this.x_Nfila, 10);
                                this.xModelo.setValueAt(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][4], this.x_Nfila, 11);
                                this.xModelo.setValueAt(this.xjp_procedimiento.xjpencabezado.txtNoPrescripcionMiPres.getText() == null ? " " : this.xjp_procedimiento.xjpencabezado.txtNoPrescripcionMiPres.getText(), this.x_Nfila, 12);
                                this.xModelo.setValueAt(" ", this.x_Nfila, 13);
                                this.xModelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getId(), this.x_Nfila, 14);
                                this.xModelo.setValueAt(this.listGrupoEntitys.get(this.JCBGrupoSevicio.getSelectedIndex()).getNombre(), this.x_Nfila, 15);
                                this.xModelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getId(), this.x_Nfila, 16);
                                this.xModelo.setValueAt(this.ListripsEntitys.get(this.JCBSevicioRips.getSelectedIndex()).getNombre(), this.x_Nfila, 17);
                                this.x_Nfila++;
                                mCalcular_Valores();
                                if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                                    mActualizar_Tarifas();
                                }
                                mNuevo();
                                return;
                            }
                            JOptionPane.showMessageDialog(this, "Procedimiento ya se encuentra agregado", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un grupo", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                        this.JCBGrupoSevicio.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un items servicio rips", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBSevicioRips.requestFocus();
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe seleccionar un centro costo", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBCentroCostoGen.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar una finalidad", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBFinalidad.requestFocus();
            return;
        }
        JOptionPane.showMessageDialog(this, "Debe seleccionar un procedimiento", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBProcedimientos.requestFocus();
    }

    private void mCalcularValorT() {
        if (this.JCBProcedimientos.getSelectedIndex() != -1 && !this.JTFF_Cantidad.getText().isEmpty() && Integer.parseInt(this.JTFF_Cantidad.getText()) > 0) {
            if (Principal.informacionIps.getFiltroSeguimientoFactura().booleanValue()) {
                this.JTFF_VTotalImpuesto.setValue(Double.valueOf(((Double.valueOf(this.JTFF_VUnitario.getValue().toString()).doubleValue() * Double.valueOf(this.JSPPImpuesto.getValue().toString()).doubleValue()) / 100.0d) * ((double) Integer.parseInt(this.JTFF_Cantidad.getText()))));
            } else {
                this.JTFF_VTotalImpuesto.setValue(Double.valueOf(0.0d));
            }
            this.JTFF_VTotal.setValue(Double.valueOf((Double.valueOf(this.JTFF_VUnitario.getValue().toString()).doubleValue() * ((double) Integer.valueOf(this.JTFF_Cantidad.getText()).intValue())) + Double.parseDouble(this.JTFF_VTotalImpuesto.getValue().toString())));
        }
    }

    private void mActualizar_Tarifas() {
        if (Double.parseDouble(this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][2]) == 0.0d) {
            int x = JOptionPane.showConfirmDialog(this, "Desea actualizar la tarifa?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                if (!this.idClaseProcedimiento.equals("2") || !this.idClaseProcedimiento.equals("4")) {
                    this.xsql = "update f_tarifasuministro set Valor=" + Double.valueOf(this.JTFF_VUnitario.getValue().toString()) + " WHERE (`Id_suministro` ='" + this.xId_Procedimiento[this.JCBProcedimientos.getSelectedIndex()][0] + "' AND `Id_manual` ='" + this.xjp_procedimiento.getxIdManual() + "')";
                    this.xct.ejecutarSQL(this.xsql);
                    this.xct.cerrarConexionBd();
                }
            }
        }
    }

    private void mNuevo() {
        this.xlleno = false;
        this.JTFFCodigo.setText("");
        this.JLN_Numero.setText("");
        this.JCBCentroCostoGen.removeAllItems();
        this.xsql = "SELECT  `Id` , `Nbre` FROM  `f_centrocosto` WHERE (`Estado` =0) ORDER BY `Nbre` ASC ";
        this.xId_CCosto = this.xct.llenarCombo(this.xsql, this.xId_CCosto, this.JCBCentroCostoGen);
        this.JCBCentroCostoGen.setSelectedIndex(-1);
        this.JCBFinalidad.removeAllItems();
        this.xsql = "SELECT `Id` , `Nbre` FROM `f_tipofinprocedimiento` ORDER BY `Nbre` ASC ";
        this.xId_Finalidad = this.xct.llenarCombo(this.xsql, this.xId_Finalidad, this.JCBFinalidad);
        this.JCBFinalidad.setSelectedItem("No aplica");
        this.JCBProcedimientos.removeAllItems();
        this.xjp_procedimiento.mInicar_Variables_Ingreso(String.valueOf(this.xjp_procedimiento.getXidingreso()));
        if (this.idClaseProcedimiento.equals("2") || this.idClaseProcedimiento.equals("4")) {
            if (this.xjp_procedimiento.xFiltroProc.equals("0")) {
                switch (this.xjp_procedimiento.getxMetodoFact()) {
                    case 0:
                        this.xsql = "SELECT \t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            g_procedimiento.C_Homologado, \n           IF(f_procedempresaconvenio.Valor=0, IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo),f_procedempresaconvenio.Valor)  AS Valor,\n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n            FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n            WHERE (f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "'  \n            AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "'\n            AND g_procedimiento.Estado=0) \n            ORDER BY NProcedimiento ASC; ";
                        break;
                    case 1:
                        this.xsql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            g_procedimiento.C_Homologado, \n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor=0, ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor,\t\n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n\t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0)\n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n            WHERE f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "' \n            AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "'\n            AND g_procedimiento.Estado=0\n            ORDER BY NProcedimiento ASC;";
                        break;
                    default:
                        this.xsql = " SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            g_procedimiento.C_Homologado, \n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor=0,(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(f_procedempresaconvenio.Valor=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(f_procedempresaconvenio.Valor=0,(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(f_procedempresaconvenio.Valor=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(f_procedempresaconvenio.Valor=0, ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n\t\t \n\t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t        INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n\t\t    INNER JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n\t\t\tAND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0)\t\n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n\t\t    WHERE f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "' \n\t\t\t    AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "' \n\t\t\t    AND g_procedimiento.Estado=0\n\t\t       ORDER BY NProcedimiento ASC; ";
                        break;
                }
            } else {
                switch (this.xjp_procedimiento.getxMetodoFact()) {
                    case 0:
                        this.xsql = "SELECT \t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            g_procedimiento.C_Homologado, \n            IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,IF(f_empresacontxconvenio.CualValor=0, f_tarifaprocedimiento.VrMinimo,f_tarifaprocedimiento.VrMaximo),f_procedempresaconvenio.Valor) AS Valor,\n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n            FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) \n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            WHERE (f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "'  \n            AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "'\n            AND g_procedimiento.Estado=0) \n            ORDER BY NProcedimiento ASC; ";
                        break;
                    case 1:
                        this.xsql = "SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            g_procedimiento.C_Homologado, \n\t    IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND,\n\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\tEND) AS Valor,\t\n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n             \n\t    FROM f_tarifaprocedimiento \n            INNER JOIN g_procedimiento ON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id) \n            INNER JOIN f_empresacontxconvenio ON (f_empresacontxconvenio.Id_Manual = f_tarifaprocedimiento.Id_Manual) \n            INNER JOIN f_tipoplan ON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id) \n            INNER JOIN f_tipoprocedimiento ON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id) \n\t\t\t   INNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n            INNER JOIN f_tiposervtipoproced ON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id)\n            INNER JOIN f_servicioempresaconv \n            ON (f_servicioempresaconv.Id_EmpresaConvenio=f_empresacontxconvenio.Id) \n             AND (f_tiposervtipoproced.`Idtiposervicio`= f_servicioempresaconv.`Id_TipoServicio`)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n            WHERE f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "' \n            AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "'\n            AND g_procedimiento.Estado=0\n            ORDER BY NProcedimiento ASC;";
                        break;
                    default:
                        this.xsql = " SELECT  \t\t\n            f_tarifaprocedimiento.Id_Procedimiento AS Id, \n            g_procedimiento.Nbre AS NProcedimiento,\n            g_procedimiento.C_Homologado, \n            IF(f_empresacontxconvenio.CualValor=0, \n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMinimo+((f_tarifaprocedimiento.VrMinimo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMinimo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND,\n\t\tCASE (f_manual.AplicaFactor)\n\t\t   WHEN 0 THEN\n\t\t\tCASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\tEND\n\t\t   WHEN 1 THEN\n\t\t\tIF(f_servicioempresaconv.AplicaFactor=0,\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),f_procedempresaconvenio.Valor)\t\t\t\n\t\t\t\tWHEN 2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((f_tarifaprocedimiento.VrMaximo+((f_tarifaprocedimiento.VrMaximo*f_servicioempresaconv.Incr_Decrem)/100)),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END,\t\n\t\t\t     CASE (f_empresacontxconvenio.Redondeo)\n\t\t\t\tWHEN 0 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,(ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN 2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100)))),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -1 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-1),f_procedempresaconvenio.Valor)\n\t\t\t\tWHEN -2 THEN  IF(IFNULL(f_procedempresaconvenio.Valor, 0)=0,ROUND((ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)+\n\t\t\t\t\t\t     (ROUND((f_tarifaprocedimiento.FactorMaximo * g_historico_salario_minimo.VSDiario),-2)*(f_servicioempresaconv.Incr_Decrem/100))),-2),f_procedempresaconvenio.Valor)\n\t\t\t     END)\t\n\t\tEND\n\t\t) AS Valor,\n\t\t\t   f_tipofinprocedimiento.Nbre AS NFinalidad ,  \n\t\t\t   f_tarifaprocedimiento.Id_TipoPlan, g_procedimiento.Paquete, g_procedimiento.porcentajeImpuesto  \n\t\t \n\t    FROM\n\t\t    f_tarifaprocedimiento\n\t\t    INNER JOIN g_procedimiento \n\t\t\tON (f_tarifaprocedimiento.Id_Procedimiento = g_procedimiento.Id)\n\t\t    INNER JOIN f_tipoplan \n\t\t\tON (f_tarifaprocedimiento.Id_TipoPlan = f_tipoplan.Id)\n\t\t    INNER JOIN f_manual \n\t\t\tON (f_tarifaprocedimiento.Id_Manual = f_manual.Id)\n\t\t    INNER JOIN f_tipoprocedimiento \n\t\t\tON (g_procedimiento.Id_tipoprocedimiento = f_tipoprocedimiento.Id)\n\t\t\tINNER JOIN f_tipofinprocedimiento  ON (g_procedimiento.Id_TipoFinProced = f_tipofinprocedimiento.Id)  \n\t\t    INNER JOIN f_servicioempresaconv \n\t\t\tON (f_servicioempresaconv.Id_Manual_n = f_manual.Id)\n\t\t    INNER JOIN f_empresacontxconvenio \n\t\t\tON (f_servicioempresaconv.Id_EmpresaConvenio = f_empresacontxconvenio.Id)\n\t\t    INNER JOIN f_tiposervtipoproced \n\t\t\tON (f_tiposervtipoproced.Idtipoprocedimiento = f_tipoprocedimiento.Id) AND (f_servicioempresaconv.Id_TipoServicio = f_tiposervtipoproced.Idtiposervicio)\n\t\t    LEFT JOIN g_historico_salario_minimo \n\t\t\tON (f_servicioempresaconv.Anno = g_historico_salario_minimo.Ano)\n            LEFT JOIN f_procedempresaconvenio ON (f_procedempresaconvenio.Id_Procedimiento = g_procedimiento.Id) \n            AND (f_procedempresaconvenio.Id_EmpresacontxConv = f_empresacontxconvenio.Id) and (f_procedempresaconvenio.Estado=0) \n\t\t    WHERE f_empresacontxconvenio.Id ='" + this.xjp_procedimiento.getXidempresa() + "' \n\t\t\t    AND f_tiposervtipoproced.Idtiposervicio='" + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + "' \n\t\t\t    AND g_procedimiento.Estado=0\n\t\t       ORDER BY NProcedimiento ASC; ";
                        break;
                }
            }
        } else if (Principal.informacionIps.getAplicaNombreGenerico().booleanValue()) {
            this.xsql = " SELECT i_suministro.Id,  IF(`i_principioactivo`.`Nbre`='NO APLICA' ,`i_suministro`.`Nbre`,CONCAT(`i_principioactivo`.`Nbre`, ' ', `i_concentracion`.`Nbre`, ' ', `i_formafarmaceutica`.`Nbre` , ' ',  i_presentacioncomercial.`Nbre`)) AS NProducto,\n\t\t    `i_suministro`.`CodBarraUnidad` , IF(IFNULL(f_servicioempresaconv.`Incr_Decrem`,0) = 0, ROUND(f_tarifasuministro.Valor), ROUND((f_tarifasuministro.Valor)+ ((f_tarifasuministro.Valor*(f_servicioempresaconv.`Incr_Decrem`/100)))) )  AS Valor , 'No Aplica' AS `FProcedimiento` , `f_tarifasuministro`.`Id_TipoPlan` , `i_suministro`.`Escobrable`,`i_suministro`.`Iva` \n                    FROM i_suministro INNER JOIN i_concentracion \n                    ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacionfarmaceutica \n                    ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio  \n                    ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN f_tarifasuministro \n                    ON (f_tarifasuministro.Id_suministro = i_suministro.Id) INNER JOIN i_tipoproducto \n                    ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN f_empresacontxconvenio \n                    ON (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \n                     INNER JOIN `i_principioactivo`  ON (`i_principioactivo`.`Id` = `i_suministro`.`IdPrincipioActivo`)  \n        INNER JOIN  `i_formafarmaceutica`  ON (`i_presentacionfarmaceutica`.`IdFormaFarmaceutica` = `i_formafarmaceutica`.`Id`)\n          INNER JOIN  `i_presentacioncomercial`    ON (`i_presentacioncomercial`.`Id` = `i_suministro`.`IdPresentacionComercial`)\n   LEFT JOIN `f_servicioempresaconv` ON (f_servicioempresaconv.`Id_EmpresaConvenio`= f_empresacontxconvenio.Id) AND (f_servicioempresaconv.`Id_TipoServicio`=7)\n   \n                    WHERE (i_suministro.EstaActivo =1 AND f_empresacontxconvenio.Id = " + this.xjp_procedimiento.getXidempresa() + " ) ORDER BY NProducto";
        } else {
            this.xsql = "SELECT i_suministro.Id, CONCAT(i_suministro.Nbre,' ',i_concentracion.Nbre,' ',i_presentacionfarmaceutica.Nbre,' ', i_laboratorio.Nbre) AS NProducto,\n\t\t    `i_suministro`.`CodBarraUnidad` , IF(IFNULL(f_servicioempresaconv.`Incr_Decrem`,0) = 0, ROUND(f_tarifasuministro.Valor), ROUND((f_tarifasuministro.Valor)+ ((f_tarifasuministro.Valor*(f_servicioempresaconv.`Incr_Decrem`/100)))) )  AS Valor , 'No Aplica' AS `FProcedimiento` , `f_tarifasuministro`.`Id_TipoPlan` , `i_suministro`.`Escobrable`,`i_suministro`.`Iva` \n                    FROM i_suministro INNER JOIN i_concentracion \n                    ON (i_suministro.IdConcentracion = i_concentracion.Id) INNER JOIN i_presentacionfarmaceutica \n                    ON (i_suministro.IdPresentacionFarmaceutica = i_presentacionfarmaceutica.Id) INNER JOIN i_laboratorio  \n                    ON (i_suministro.IdLaboratorio = i_laboratorio.Id) INNER JOIN f_tarifasuministro \n                    ON (f_tarifasuministro.Id_suministro = i_suministro.Id) INNER JOIN i_tipoproducto \n                    ON (i_suministro.IdTipoProducto = i_tipoproducto.Id) INNER JOIN f_empresacontxconvenio \n                    ON (f_tarifasuministro.Id_manual = f_empresacontxconvenio.Id_Manual) \n   LEFT JOIN `f_servicioempresaconv` ON (f_servicioempresaconv.`Id_EmpresaConvenio`= f_empresacontxconvenio.Id) AND (f_servicioempresaconv.`Id_TipoServicio`=7)\n   \n                    WHERE (i_suministro.EstaActivo =1 AND f_empresacontxconvenio.Id = " + this.xjp_procedimiento.getXidempresa() + " ) ORDER BY NProducto;";
        }
        System.out.println("Probando: " + this.xsql);
        this.xId_Procedimiento = this.xct.llenarComboyLista(this.xsql, this.xId_Procedimiento, this.JCBProcedimientos, 8);
        this.JCBProcedimientos.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        this.JCBProcedimientos.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JTFF_Cantidad.setText("1");
        this.JSPPImpuesto.setValue(Float.valueOf(0.0f));
        this.JTFF_VUnitario.setValue(Double.valueOf(0.0d));
        this.JTFF_VTotalImpuesto.setValue(Double.valueOf(0.0d));
        this.JTFF_VTotal.setValue(Double.valueOf(0.0d));
        this.JCBCentroCostoGen.setSelectedItem(this.xjp_procedimiento.xjpencabezado.JCBCentroCosto.getSelectedItem());
        this.JCBGrupoSevicio.removeAllItems();
        LlenarCombosGenericos<GServicioGrupoEntity> combosGenericos = new LlenarCombosGenericos<>();
        this.listGrupoEntitys = combosGenericos.getListComboLleno(this.JCBGrupoSevicio.getName());
        this.listGrupoEntitys.forEach(e -> {
            this.JCBGrupoSevicio.addItem(e.getNombre());
        });
        if (!this.listGrupoEntitys.isEmpty()) {
            this.JCBGrupoSevicio.setSelectedIndex(-1);
            this.JCBGrupoSevicio.addPopupMenuListener(new CustomPopupMenuListener(true, false));
        }
        this.xlleno = true;
        this.JTFFCodigo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xModelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento / Suministro", "Id_Finalidad", "NFinalidad", "Cant.", "% Impuesto", "V/Impuesto", "V/Unitario", "V/Total", "Id_CentroCosto", "Cobrable", "Plan", "No. Prescripcion Mipres", "No. Entrega Mipres", "Código Grupo", "Nombre Grupo", "Código Servicio Rips", "Nombre Servicio Rips"}) { // from class: Facturacion.JD_Registro_Servicios.23
            Class[] types = {Long.class, String.class, Long.class, String.class, Long.class, Double.class, Double.class, Double.class, Double.class, Long.class, Boolean.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, true, false, true, true, false, false, false, false};

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
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(2).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(17).setPreferredWidth(100);
        this.x_Nfila = 0;
    }

    private void mCalcular_Valores() {
        double xvalor1 = 0.0d;
        double xvalor2 = 0.0d;
        for (int x = 0; x < this.JTDetalle.getRowCount(); x++) {
            if (this.xjp_procedimiento.getxIdTipoPlan().equals(this.xModelo.getValueAt(x, 11).toString())) {
                xvalor1 += Double.valueOf(this.xModelo.getValueAt(x, 8).toString()).doubleValue();
            } else {
                xvalor2 += Double.valueOf(this.xModelo.getValueAt(x, 8).toString()).doubleValue();
            }
        }
        this.JTFF_TOrden.setValue(Double.valueOf(xvalor1 + xvalor2));
        this.JTFF_TPlan.setValue(Double.valueOf(xvalor1));
        this.JTFF_TNPlan.setValue(Double.valueOf(xvalor2));
    }

    private void mBuscar_Codigo() {
        System.out.println("ENTRO");
        if (!this.JTFFCodigo.getText().isEmpty()) {
            System.out.println("TAÑAO:" + this.xId_Procedimiento.length);
            for (int i = 0; i < this.xId_Procedimiento.length; i++) {
                System.out.println("" + this.xId_Procedimiento[i][0]);
                System.out.println("" + this.xId_Procedimiento[i][1]);
                if (this.JTFFCodigo.getText().equals(this.xId_Procedimiento[i][0]) || this.JTFFCodigo.getText().equals(this.xId_Procedimiento[i][1])) {
                    this.JCBProcedimientos.setSelectedIndex(i);
                }
            }
            this.JTFF_Cantidad.requestFocus();
        }
    }

    private void mGrabar() {
        if (this.JLN_Numero.getText().isEmpty()) {
            if (this.JTDetalle.getRowCount() != -1) {
                int x = JOptionPane.showConfirmDialog(this, "Desea grabar la orden?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    this.xsql = "INSERT INTO f_ordenes (Id_Ingreso,Id_TipoServicio,FechaOrden,HoraOrden,Id_Profesional,Id_Especialidad,Id_CentroCosto,TotalOrdenes,TotalEPS,TotalPaciente, LProcesamiento,  Observacion,Fecha,UsuarioS) values(" + this.xjp_procedimiento.getXidingreso() + "," + this.xjp_procedimiento.xjpencabezado.getxIdServicio() + ",'" + this.xmt.formatoAMD.format(this.xjp_procedimiento.JDFFechaR.getDate()) + "','" + this.xmt.formatoH24.format(this.xmt.getFechaActualPC()) + "','" + this.xjp_procedimiento.xjpencabezado.xidprofesional[this.xjp_procedimiento.xjpencabezado.JCBProfesional.getSelectedIndex()] + "','" + this.xjp_procedimiento.xjpencabezado.xidespecialidad[this.xjp_procedimiento.xjpencabezado.JCBEspecialidad.getSelectedIndex()] + "','" + this.xjp_procedimiento.xjpencabezado.xidcentrocosto[this.xjp_procedimiento.xjpencabezado.JCBCentroCosto.getSelectedIndex()] + "','" + this.JTFF_TOrden.getValue() + "','" + this.JTFF_TPlan.getValue() + "','" + this.JTFF_TNPlan.getValue() + "',-1,'" + this.xjp_procedimiento.xjpencabezado.JTAObservacion.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.JLN_Numero.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int y = 0; y < this.JTDetalle.getRowCount(); y++) {
                        int xCobrable = 0;
                        if (Boolean.parseBoolean(this.xModelo.getValueAt(y, 10).toString())) {
                            xCobrable = 1;
                        }
                        if (this.idClaseProcedimiento.equals("2") || this.idClaseProcedimiento.equals("4")) {
                            this.xsql = "INSERT INTO f_itemordenesproced (Id_Ordenes,Id_Procedimiento,Id_TipofinProc,Cantidad,ValorUnitario,Id_CentroCosto,`EsCobrable`, `Plan`, porcentajeImpuesto, valorImpuesto, idModalidadAtencion, idServicioRips,  idMipres, Fecha,UsuarioS) values('" + this.JLN_Numero.getText() + "'," + this.xModelo.getValueAt(y, 0) + "," + this.xModelo.getValueAt(y, 2) + "," + this.xModelo.getValueAt(y, 4) + "," + this.xModelo.getValueAt(y, 7) + "," + this.xId_CCosto[this.JCBCentroCostoGen.getSelectedIndex()] + ",1," + this.xModelo.getValueAt(y, 11) + "," + this.xModelo.getValueAt(y, 5) + "," + this.xModelo.getValueAt(y, 6) + "," + this.xjp_procedimiento.xjifliq.getIdModalidadAtencion() + "," + this.xModelo.getValueAt(y, 16) + ",'" + this.xModelo.getValueAt(y, 12) + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        } else {
                            this.xsql = "INSERT INTO f_itemordenessum (`Id_Ordenes` , `Id_Suministro`  , `Cantidad` , `ValorUnit` , `EsCobrable`, porcentajeImpuesto, valorImpuesto, idPrescripcionMipres, idEntregaMipres , idModalidadAtencion, idServicioRips, Fecha, `UsuarioS`) values('" + this.JLN_Numero.getText() + "'," + this.xModelo.getValueAt(y, 0) + "," + this.xModelo.getValueAt(y, 4) + "," + this.xModelo.getValueAt(y, 7) + "," + xCobrable + "," + this.xModelo.getValueAt(y, 5) + "," + this.xModelo.getValueAt(y, 6) + ",'" + this.xModelo.getValueAt(y, 12) + "','" + this.xModelo.getValueAt(y, 13) + "'," + this.xjp_procedimiento.xjifliq.getIdModalidadAtencion() + "," + this.xModelo.getValueAt(y, 16) + ",'" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                        }
                        System.out.println("Items  " + this.xsql);
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                    }
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Orden ya grabada", "VALIDAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }
}
