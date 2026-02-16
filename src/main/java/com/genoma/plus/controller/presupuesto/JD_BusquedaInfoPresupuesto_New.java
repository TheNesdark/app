package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import Presupuesto.JIFFMovimientoManual;
import Presupuesto.JIFFSolicitudPresupuestal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.PpRubrosCpc;
import com.genoma.plus.jpa.projection.IPp_SaldoRubro;
import com.genoma.plus.jpa.service.IGEmpresaService;
import com.genoma.plus.jpa.service.IPpMovimientoService;
import com.genoma.plus.jpa.service.IPpRubrosCpcService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JD_BusquedaInfoPresupuesto_New.class */
public class JD_BusquedaInfoPresupuesto_New extends JDialog {
    private final IPpMovimientoService iPpMovimientoService;
    private final IPpRubrosCpcService iPpRubrosCpcService;
    private final IGEmpresaService iGEmpresaService;
    private DefaultTableModel modelo;
    public List<IPp_SaldoRubro> pp_SaldoRubro;
    private JIFFSolicitudPresupuestal jifsolicitudpresupuestal;
    private Metodos metodos;
    private String nombreFiltro;
    private JIFFMovimientoManual jifMovimientoManual;
    private JButton JBTSalir;
    private JPanel JPI_Filtro;
    private JScrollPane JSP_Detalle;
    private JTable JTDetalleNew;
    private JTextField JTFFiltro;

    public JD_BusquedaInfoPresupuesto_New(Frame parent, boolean modal, Object jInternalFrame, String nombreFiltro) {
        super(parent, modal);
        this.metodos = new Metodos();
        initComponents();
        casting(jInternalFrame);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.nombreFiltro = nombreFiltro;
        this.iPpMovimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        this.iPpRubrosCpcService = (IPpRubrosCpcService) Principal.contexto.getBean(IPpRubrosCpcService.class);
        this.iGEmpresaService = (IGEmpresaService) Principal.contexto.getBean(IGEmpresaService.class);
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPI_Filtro = new JPanel();
        this.JTFFiltro = new JTextField();
        this.JSP_Detalle = new JScrollPane();
        this.JTDetalleNew = new JTable();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("BUSQUEDA");
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFiltro.setFont(new Font("Arial", 1, 12));
        this.JTFFiltro.setHorizontalAlignment(2);
        this.JTFFiltro.setToolTipText("Digite información de rubro a consultar");
        this.JTFFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código/Nombre de Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto_New.1
            public void keyPressed(KeyEvent evt) {
                JD_BusquedaInfoPresupuesto_New.this.JTFFiltroKeyPressed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltro, -2, 523, -2).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JTFFiltro, -1, 50, 32767).addGap(18, 18, 18)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalleNew.setFont(new Font("Arial", 1, 12));
        this.JTDetalleNew.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleNew.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleNew.setSelectionForeground(Color.red);
        this.JTDetalleNew.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto_New.2
            public void mouseClicked(MouseEvent evt) {
                JD_BusquedaInfoPresupuesto_New.this.JTDetalleNewMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTDetalleNew);
        this.JBTSalir.setFont(new Font("Arial", 1, 13));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto_New.3
            public void actionPerformed(ActionEvent evt) {
                JD_BusquedaInfoPresupuesto_New.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -1, -1, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(205, 32767).addComponent(this.JBTSalir, -2, 415, -2).addGap(204, 204, 204)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Detalle, -1, 812, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 248, 32767).addComponent(this.JBTSalir, -2, 45, -2).addGap(22, 22, 22)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(130, 130, 130).addComponent(this.JSP_Detalle, -2, 227, -2).addContainerGap(83, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10 || evt.getKeyCode() == 9) {
            cargarDatos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleNewMouseClicked(MouseEvent evt) {
        if (this.JTDetalleNew.getSelectedRow() != -1) {
            switch (this.nombreFiltro) {
                case "Rubro":
                    this.jifsolicitudpresupuestal.JTFCodigoRubro.setText(this.JTDetalleNew.getValueAt(this.JTDetalleNew.getSelectedRow(), 0).toString());
                    this.jifsolicitudpresupuestal.JTFNombreRubro.setText(this.JTDetalleNew.getValueAt(this.JTDetalleNew.getSelectedRow(), 1).toString());
                    this.jifsolicitudpresupuestal.cargarInformacionRubro();
                    dispose();
                    break;
                case "CodigoCpc":
                    if (Boolean.valueOf(this.JTDetalleNew.getValueAt(this.JTDetalleNew.getSelectedRow(), 2).toString()).booleanValue()) {
                        this.jifsolicitudpresupuestal.JTFCodigoCPC.setText(this.JTDetalleNew.getValueAt(this.JTDetalleNew.getSelectedRow(), 0).toString());
                        this.jifsolicitudpresupuestal.cargarInformacionCodigoCpc();
                        dispose();
                        break;
                    } else {
                        this.metodos.mostrarMensaje("El seleccionar un codigo de último nivel");
                        break;
                    }
                    break;
                case "CodigoCpcMovManual":
                    if (Boolean.valueOf(this.JTDetalleNew.getValueAt(this.JTDetalleNew.getSelectedRow(), 2).toString()).booleanValue()) {
                        this.jifMovimientoManual.JTFCodigoCPC.setText(this.JTDetalleNew.getValueAt(this.JTDetalleNew.getSelectedRow(), 0).toString());
                        this.jifMovimientoManual.cargarInformacionCodigoCpc();
                        dispose();
                        break;
                    } else {
                        this.metodos.mostrarMensaje("El seleccionar un codigo de último nivel");
                        break;
                    }
                    break;
                case "tercero":
                    this.jifsolicitudpresupuestal.JTFTerceroNDocumento.setText(this.JTDetalleNew.getValueAt(this.JTDetalleNew.getSelectedRow(), 0).toString());
                    this.jifsolicitudpresupuestal.cargarInformacionTercero();
                    dispose();
                    break;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Nombre", "Saldo", "Vigencia"}) { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto_New.4
            Class[] types = {String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleNew.setModel(this.modelo);
        this.JTDetalleNew.getColumnModel().getColumn(0).setPreferredWidth(90);
        this.JTDetalleNew.getColumnModel().getColumn(1).setPreferredWidth(380);
        this.JTDetalleNew.getColumnModel().getColumn(2).setPreferredWidth(90);
        this.JTDetalleNew.getColumnModel().getColumn(3).setPreferredWidth(40);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTercero() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Documento", "Nombre", "estado"}) { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto_New.5
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleNew.setModel(this.modelo);
        this.JTDetalleNew.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleNew.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalleNew.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloRuborCpc() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Codigo", "Nombre", "Ultino Nivel", "Estado"}) { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto_New.6
            Class[] types = {String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleNew.setModel(this.modelo);
        this.JTDetalleNew.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleNew.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalleNew.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleNew.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void cargarDatos() {
        switch (this.nombreFiltro) {
            case "Rubro":
                crearModelo();
                this.pp_SaldoRubro = this.iPpMovimientoService.getListMovimientoConsolidadoRubro(this.JTFFiltro.getText(), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()), "G");
                Object[] dato = null;
                this.metodos.mEstablecerTextEditor(this.JTDetalleNew, 1);
                if (!this.pp_SaldoRubro.isEmpty() || this.pp_SaldoRubro != null) {
                    this.pp_SaldoRubro.forEach(e -> {
                        this.modelo.addRow(dato);
                        this.JTDetalleNew.setValueAt(e.getIdRubro(), this.JTDetalleNew.getRowCount() - 1, 0);
                        this.JTDetalleNew.setValueAt(e.getNombreRubro(), this.JTDetalleNew.getRowCount() - 1, 1);
                        this.JTDetalleNew.setValueAt(e.getValorSaldoDisponible(), this.JTDetalleNew.getRowCount() - 1, 2);
                    });
                    break;
                }
                break;
            case "CodigoCpc":
                crearModeloRuborCpc();
                new ArrayList();
                List<PpRubrosCpc> list = this.iPpRubrosCpcService.getListPpRubrosCpcByNombreOrCodigo(this.JTFFiltro.getText());
                Object[] dato2 = null;
                this.metodos.mEstablecerTextEditor(this.JTDetalleNew, 1);
                if (!list.isEmpty()) {
                    list.forEach(e2 -> {
                        this.modelo.addRow(dato2);
                        this.JTDetalleNew.setValueAt(e2.getCodigo(), this.JTDetalleNew.getRowCount() - 1, 0);
                        this.JTDetalleNew.setValueAt(e2.getNombre(), this.JTDetalleNew.getRowCount() - 1, 1);
                        this.JTDetalleNew.setValueAt(e2.getUltimoNivel(), this.JTDetalleNew.getRowCount() - 1, 2);
                        this.JTDetalleNew.setValueAt(e2.getEstado(), this.JTDetalleNew.getRowCount() - 1, 3);
                    });
                    break;
                }
                break;
            case "CodigoCpcMovManual":
                crearModeloRuborCpc();
                new ArrayList();
                List<PpRubrosCpc> list2 = this.iPpRubrosCpcService.getListPpRubrosCpcByNombreOrCodigo(this.JTFFiltro.getText());
                Object[] dato3 = null;
                this.metodos.mEstablecerTextEditor(this.JTDetalleNew, 1);
                if (!list2.isEmpty()) {
                    list2.forEach(e3 -> {
                        this.modelo.addRow(dato3);
                        this.JTDetalleNew.setValueAt(e3.getCodigo(), this.JTDetalleNew.getRowCount() - 1, 0);
                        this.JTDetalleNew.setValueAt(e3.getNombre(), this.JTDetalleNew.getRowCount() - 1, 1);
                        this.JTDetalleNew.setValueAt(e3.getUltimoNivel(), this.JTDetalleNew.getRowCount() - 1, 2);
                        this.JTDetalleNew.setValueAt(e3.getEstado(), this.JTDetalleNew.getRowCount() - 1, 3);
                    });
                    break;
                }
                break;
            case "tercero":
                crearModeloTercero();
                new ArrayList();
                List<GEmpresa> list3 = this.iGEmpresaService.getLisEmpresaOrderByNombreAsc(this.JTFFiltro.getText());
                Object[] dato4 = null;
                this.metodos.mEstablecerTextEditor(this.JTDetalleNew, 1);
                if (!list3.isEmpty()) {
                    list3.forEach(e4 -> {
                        this.modelo.addRow(dato4);
                        this.JTDetalleNew.setValueAt(e4.getNoidentificacion(), this.JTDetalleNew.getRowCount() - 1, 0);
                        if (e4.getNbre().isEmpty() || e4.getNbre() == null) {
                            this.JTDetalleNew.setValueAt(e4.getApellido1().concat(" ").concat(e4.getApellido2()).concat(" ").concat(e4.getNombre1()).concat(" ").concat(e4.getNombre2()), this.JTDetalleNew.getRowCount() - 1, 1);
                        } else {
                            this.JTDetalleNew.setValueAt(e4.getNbre(), this.JTDetalleNew.getRowCount() - 1, 1);
                        }
                        this.JTDetalleNew.setValueAt(e4.getEstado(), this.JTDetalleNew.getRowCount() - 1, 2);
                    });
                    break;
                }
                break;
        }
    }

    private void casting(Object objetoLlamador) {
        switch (objetoLlamador.getClass().getSimpleName()) {
            case "JIFFSolicitudPresupuestal":
                this.jifsolicitudpresupuestal = (JIFFSolicitudPresupuestal) objetoLlamador;
                setTitle(getTitle() + " " + this.jifsolicitudpresupuestal.getTitle());
                break;
            case "JIFFMovimientoManual":
                this.jifMovimientoManual = (JIFFMovimientoManual) objetoLlamador;
                setTitle(getTitle() + " " + this.jifMovimientoManual.getTitle());
                break;
        }
    }
}
