package ParametrizacionN;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.PpRubros;
import com.genoma.plus.jpa.entities.PpRubrosCentrocostos;
import com.genoma.plus.jpa.entities.PpRubrosCpc;
import com.genoma.plus.jpa.entities.PpRubrosFuenteFinanciacion;
import com.genoma.plus.jpa.service.IPpRubrosCentrocostosService;
import com.genoma.plus.jpa.service.IPpRubrosCpcService;
import com.genoma.plus.jpa.service.IPpRubrosFuenteFinanciacionService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:ParametrizacionN/JIFGenericoRubros.class */
public class JIFGenericoRubros extends JInternalFrame {
    private Metodos xmetodos = new Metodos();
    private boolean xestado = true;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String xnombre;
    private final PpRubrosCentrocostos centrocostos;
    private final IPpRubrosCentrocostosService centrocostoService;
    private List<PpRubrosCentrocostos> listaCentroCostos;
    private final PpRubros rubros;
    private final IPpRubrosCpcService rubroService;
    private List<PpRubros> listaRubros;
    private final PpRubrosCpc cpc;
    private final IPpRubrosCpcService cpcService;
    private List<PpRubrosCpc> listaCpc;
    private final PpRubrosFuenteFinanciacion fuenteFinanciacion;
    private final IPpRubrosFuenteFinanciacionService fuenteFinanciacionService;
    private List<PpRubrosFuenteFinanciacion> listaFuenteFinanciacion;
    private JCheckBox JCHEstado;
    private JPanel JPIDatos;
    private JScrollPane JSPDetalle;
    private JTextField JTFCodigo;
    private JTextField JTFNombre;
    private JTable JThistorico;

    public JIFGenericoRubros(String xnombre, String xnombref) {
        initComponents();
        setName(xnombref);
        setTitle(xnombre.toUpperCase());
        this.xnombre = xnombref;
        this.centrocostos = new PpRubrosCentrocostos();
        this.centrocostoService = (IPpRubrosCentrocostosService) Principal.contexto.getBean(IPpRubrosCentrocostosService.class);
        this.listaCentroCostos = new ArrayList();
        this.rubros = new PpRubros();
        this.rubroService = (IPpRubrosCpcService) Principal.contexto.getBean(IPpRubrosCpcService.class);
        this.listaRubros = new ArrayList();
        this.cpc = new PpRubrosCpc();
        this.cpcService = (IPpRubrosCpcService) Principal.contexto.getBean(IPpRubrosCpcService.class);
        this.listaCpc = new ArrayList();
        this.fuenteFinanciacion = new PpRubrosFuenteFinanciacion();
        this.fuenteFinanciacionService = (IPpRubrosFuenteFinanciacionService) Principal.contexto.getBean(IPpRubrosFuenteFinanciacionService.class);
        this.listaFuenteFinanciacion = new ArrayList();
        mCargarDatosTabla();
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JCHEstado = new JCheckBox();
        this.JTFCodigo = new JTextField();
        this.JSPDetalle = new JScrollPane();
        this.JThistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GENERICO RUBROS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgenericorubros");
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 13));
        this.JTFNombre.setToolTipText("");
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: ParametrizacionN.JIFGenericoRubros.1
            public void actionPerformed(ActionEvent evt) {
                JIFGenericoRubros.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JTFCodigo.setFont(new Font("Arial", 1, 13));
        this.JTFCodigo.setToolTipText("");
        this.JTFCodigo.setBorder(BorderFactory.createTitledBorder((Border) null, "Codigo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCodigo, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFNombre, -2, 456, -2).addGap(18, 18, 18).addComponent(this.JCHEstado).addGap(120, 120, 120)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEstado, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombre, -2, 50, -2).addComponent(this.JTFCodigo, -2, 50, -2))).addContainerGap(21, 32767)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORICO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JThistorico.setFont(new Font("Arial", 1, 12));
        this.JThistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JThistorico.setRowHeight(25);
        this.JThistorico.addMouseListener(new MouseAdapter() { // from class: ParametrizacionN.JIFGenericoRubros.2
            public void mouseClicked(MouseEvent evt) {
                JIFGenericoRubros.this.JThistoricoMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JThistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatos, -2, 692, 32767).addComponent(this.JSPDetalle)).addGap(0, 9, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPDetalle, -2, 236, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = true;
        } else {
            this.xestado = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JThistoricoMouseClicked(MouseEvent evt) {
        if (this.JThistorico.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JThistorico.getSelectedRow(), 0).toString());
            this.JTFCodigo.setText(this.xmodelo.getValueAt(this.JThistorico.getSelectedRow(), 1).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JThistorico.getSelectedRow(), 2).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JThistorico.getSelectedRow(), 3).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = true;
            } else {
                this.xestado = false;
            }
        }
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFCodigo.setText("");
        this.JCHEstado.setSelected(true);
        this.xestado = true;
        this.JTFCodigo.requestFocus();
    }

    public void mGrabar() {
        if (!this.JTFCodigo.getText().isEmpty()) {
            if (!this.JTFNombre.getText().isEmpty()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "Verificar", 0, 3);
                if (n == 0) {
                    System.out.println("xnombre -> " + this.xnombre);
                    if (this.xnombre.equals("Rubros CPC")) {
                        PpRubrosCpc cpc = new PpRubrosCpc();
                        if (!Principal.txtNo.getText().isEmpty()) {
                            cpc.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                            cpc.setUsuarioSistemaActualizacion(Principal.getIdUsuarioS());
                            cpc.setFechaActualizacion(this.xmetodos.getFechaActual());
                        } else {
                            cpc.setUsuarioSistema(Principal.getIdUsuarioS());
                            cpc.setFechaCreacion(this.xmetodos.getFechaActual());
                        }
                        cpc.setCodigo(this.JTFCodigo.getText());
                        cpc.setNombre(this.JTFNombre.getText());
                        cpc.setEstado(Boolean.valueOf(this.xestado));
                        this.cpcService.save(cpc);
                    } else if (this.xnombre.equals("Rubros Fuente Financiacion")) {
                        PpRubrosFuenteFinanciacion ff = new PpRubrosFuenteFinanciacion();
                        if (!Principal.txtNo.getText().isEmpty()) {
                            ff.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                            ff.setUsuarioSistemaActualizacion(Principal.getIdUsuarioS());
                            ff.setFechaActualizacion(this.xmetodos.getFechaActual());
                        } else {
                            ff.setUsuarioSistema(Principal.getIdUsuarioS());
                            ff.setFechaCreacion(this.xmetodos.getFechaActual());
                        }
                        ff.setCodigo(this.JTFCodigo.getText());
                        ff.setNombre(this.JTFNombre.getText());
                        ff.setEstado(Boolean.valueOf(this.xestado));
                        this.fuenteFinanciacionService.save(ff);
                    } else if (this.xnombre.equals("Rubros Centro de Costos")) {
                        PpRubrosCentrocostos cc = new PpRubrosCentrocostos();
                        if (!Principal.txtNo.getText().isEmpty()) {
                            cc.setId(Integer.valueOf(Integer.parseInt(Principal.txtNo.getText())));
                            cc.setUsuarioSistemaActualizacion(Principal.getIdUsuarioS());
                            cc.setFechaActualizacion(this.xmetodos.getFechaActual());
                        } else {
                            cc.setUsuarioSistema(Principal.getIdUsuarioS());
                            cc.setFechaCreacion(this.xmetodos.getFechaActual());
                        }
                        cc.setCodigo(this.JTFCodigo.getText());
                        cc.setNombre(this.JTFNombre.getText());
                        cc.setEstado(Boolean.valueOf(this.xestado));
                        this.centrocostoService.save(cc);
                    }
                    mCargarDatosTabla();
                    nuevo();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El Nombre no puede ser nulo", "Verificar", 1);
            this.JTFNombre.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El codigo no puede ser nulo", "Verificar", 1);
        this.JTFCodigo.requestFocus();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos(String[] xcabecera) {
        this.xmodelo = new DefaultTableModel(new Object[0], xcabecera) { // from class: ParametrizacionN.JIFGenericoRubros.3
            Class[] types = {Integer.class, String.class, String.class, Boolean.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JThistorico.setModel(this.xmodelo);
        this.JThistorico.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JThistorico.getColumnModel().getColumn(0).setMinWidth(0);
        this.JThistorico.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JThistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JThistorico.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JThistorico.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JThistorico.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JThistorico.getColumnModel().getColumn(4).setMinWidth(0);
        this.JThistorico.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JThistorico.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JThistorico.getColumnModel().getColumn(5).setMinWidth(0);
        this.JThistorico.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JThistorico.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JThistorico.getColumnModel().getColumn(6).setMinWidth(0);
        this.JThistorico.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JThistorico.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JThistorico.getColumnModel().getColumn(7).setMinWidth(0);
        this.JThistorico.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mCargarDatosTabla() {
        String[] xencabezado = null;
        if (getName().equals("Rubros Centro de Costos") || getName().equals("Rubros Fuente Financiacion") || getName().equals("Rubros CPC")) {
            xencabezado = new String[]{"Id", "Codigo", "Nombre", "Estado", "Usuario Sistema", "Fecha de creacion", "Usuario Actualizacion", "Fecha de actualizacion"};
        }
        mCrearModeloDatos(xencabezado);
        System.out.println("xnombre -> " + this.xnombre);
        new PpRubrosCpc();
        if (this.xnombre.equals("Rubros CPC")) {
            this.listaCpc = this.cpcService.getListPpRubrosCpcOrderbyNombreAsc();
            this.listaCpc.forEach(a -> {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(a.getId(), this.JThistorico.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(a.getCodigo(), this.JThistorico.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(a.getNombre(), this.JThistorico.getRowCount() - 1, 2);
                this.xmodelo.setValueAt(a.getEstado(), this.JThistorico.getRowCount() - 1, 3);
                this.xmodelo.setValueAt(a.getUsuarioSistema(), this.JThistorico.getRowCount() - 1, 4);
                this.xmodelo.setValueAt(a.getFechaCreacion(), this.JThistorico.getRowCount() - 1, 5);
                this.xmodelo.setValueAt(a.getUsuarioSistemaActualizacion(), this.JThistorico.getRowCount() - 1, 6);
                this.xmodelo.setValueAt(a.getFechaActualizacion(), this.JThistorico.getRowCount() - 1, 7);
            });
        } else if (this.xnombre.equals("Rubros Fuente Financiacion")) {
            this.listaFuenteFinanciacion = this.fuenteFinanciacionService.getListPpRubrosFuenteFinanciacionOrderByNombreAsc();
            this.listaFuenteFinanciacion.forEach(a2 -> {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(a2.getId(), this.JThistorico.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(a2.getCodigo(), this.JThistorico.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(a2.getNombre(), this.JThistorico.getRowCount() - 1, 2);
                this.xmodelo.setValueAt(a2.getEstado(), this.JThistorico.getRowCount() - 1, 3);
                this.xmodelo.setValueAt(a2.getUsuarioSistema(), this.JThistorico.getRowCount() - 1, 4);
                this.xmodelo.setValueAt(a2.getFechaCreacion(), this.JThistorico.getRowCount() - 1, 5);
                this.xmodelo.setValueAt(a2.getUsuarioSistemaActualizacion(), this.JThistorico.getRowCount() - 1, 6);
                this.xmodelo.setValueAt(a2.getFechaActualizacion(), this.JThistorico.getRowCount() - 1, 7);
            });
        } else if (this.xnombre.equals("Rubros Centro de Costos")) {
            this.listaCentroCostos = this.centrocostoService.getListPpRubrosCentrocostosOrderByNombreAsc();
            this.listaCentroCostos.forEach(a3 -> {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(a3.getId(), this.JThistorico.getRowCount() - 1, 0);
                this.xmodelo.setValueAt(a3.getCodigo(), this.JThistorico.getRowCount() - 1, 1);
                this.xmodelo.setValueAt(a3.getNombre(), this.JThistorico.getRowCount() - 1, 2);
                this.xmodelo.setValueAt(a3.getEstado(), this.JThistorico.getRowCount() - 1, 3);
                this.xmodelo.setValueAt(a3.getUsuarioSistema(), this.JThistorico.getRowCount() - 1, 4);
                this.xmodelo.setValueAt(a3.getFechaCreacion(), this.JThistorico.getRowCount() - 1, 5);
                this.xmodelo.setValueAt(a3.getUsuarioSistemaActualizacion(), this.JThistorico.getRowCount() - 1, 6);
                this.xmodelo.setValueAt(a3.getFechaActualizacion(), this.JThistorico.getRowCount() - 1, 7);
            });
        }
    }

    private void nuevo() {
        Principal.txtNo.setText("");
        this.JTFCodigo.setText("");
        this.JTFNombre.setText("");
    }
}
