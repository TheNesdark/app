package com.genoma.plus.controller.presupuesto;

import Acceso.Principal;
import Presupuesto.JIFCompromisoPresupuestal;
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

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/presupuesto/JD_BusquedaInfoPresupuesto.class */
public class JD_BusquedaInfoPresupuesto extends JDialog {
    private final IPpMovimientoService iPpMovimientoService;
    private final IPpRubrosCpcService iPpRubrosCpcService;
    private final IGEmpresaService iGEmpresaService;
    private DefaultTableModel modelo;
    public List<IPp_SaldoRubro> pp_SaldoRubro;
    private JIFFMovimiento_new jIFFMovimiento_new;
    private JIFCompromisoPresupuestal jIFCompromisoPresupuestal;
    private Metodos metodos;
    private String nombreFiltro;
    private JButton JBTOk;
    private JButton JBTSalir;
    private JPanel JPI_Filtro;
    private JScrollPane JSP_Detalle;
    private JTable JTDetalle;
    private JTextField JTFFiltro;

    public JD_BusquedaInfoPresupuesto(Frame parent, boolean modal, Object jInternalFrame, String nombreFiltro) {
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
        this.JTDetalle = new JTable();
        this.JBTOk = new JButton();
        this.JBTSalir = new JButton();
        setDefaultCloseOperation(2);
        setTitle("BUSQUEDA");
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFFiltro.setFont(new Font("Arial", 1, 12));
        this.JTFFiltro.setHorizontalAlignment(2);
        this.JTFFiltro.setToolTipText("Digite información de rubro a consultar");
        this.JTFFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código/Nombre de Rubro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFiltro.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto.1
            public void keyPressed(KeyEvent evt) {
                JD_BusquedaInfoPresupuesto.this.JTFFiltroKeyPressed(evt);
            }
        });
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFiltro, -2, 587, -2).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.JTFFiltro, -1, 50, 32767).addGap(18, 18, 18)));
        this.JSP_Detalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto.2
            public void mouseClicked(MouseEvent evt) {
                JD_BusquedaInfoPresupuesto.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSP_Detalle.setViewportView(this.JTDetalle);
        this.JBTOk.setFont(new Font("Arial", 1, 13));
        this.JBTOk.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTOk.setText("Cargar");
        this.JBTOk.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto.3
            public void actionPerformed(ActionEvent evt) {
                JD_BusquedaInfoPresupuesto.this.JBTOkActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 13));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto.4
            public void actionPerformed(ActionEvent evt) {
                JD_BusquedaInfoPresupuesto.this.JBTSalirActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Filtro, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 2, 32767).addComponent(this.JBTOk, -2, 400, -2).addGap(10, 10, 10).addComponent(this.JBTSalir, -2, 400, -2))).addContainerGap()).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Detalle, -1, 812, 32767).addContainerGap())));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(16, 16, 16).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 244, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTOk, -1, -1, 32767).addComponent(this.JBTSalir, -2, 45, -2)).addGap(26, 26, 26)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(130, 130, 130).addComponent(this.JSP_Detalle, -2, 227, -2).addContainerGap(83, 32767))));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTOkActionPerformed(ActionEvent evt) {
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
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            switch (this.nombreFiltro) {
                case "Rubro":
                    this.jIFFMovimiento_new.JTFCodigoRbro.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.jIFFMovimiento_new.cargarInformacionRubro();
                    dispose();
                    break;
                case "CodigoCpc":
                    if (Boolean.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()).booleanValue()) {
                        this.jIFFMovimiento_new.JTFCodigoCPC.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                        this.jIFFMovimiento_new.cargarInformacionCodigoCpc();
                        dispose();
                        break;
                    } else {
                        this.metodos.mostrarMensaje("El seleccionar un codigo de último nivel");
                        break;
                    }
                    break;
                case "tercero":
                    this.jIFFMovimiento_new.JTFTerceroNDocumento.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                    this.jIFFMovimiento_new.cargarInformacionTercero();
                    dispose();
                    break;
                case "tercero_compromiso":
                    this.jIFCompromisoPresupuestal.cargarTercero(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                    dispose();
                    break;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModelo() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"codigo", "Nombre", "Saldo"}) { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto.5
            Class[] types = {String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTercero() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"Documento", "Nombre", "estado"}) { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto.6
            Class[] types = {String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloRuborCpc() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"codigo", "Nombre", "Ultino Nivel", "Estado"}) { // from class: com.genoma.plus.controller.presupuesto.JD_BusquedaInfoPresupuesto.7
            Class[] types = {String.class, String.class, Boolean.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(400);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    private void cargarDatos() {
        switch (this.nombreFiltro) {
            case "Rubro":
                crearModelo();
                this.pp_SaldoRubro = this.iPpMovimientoService.getListMovimientoConsolidadoRubro(this.JTFFiltro.getText(), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()), Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()), "G");
                Object[] dato = null;
                this.metodos.mEstablecerTextEditor(this.JTDetalle, 1);
                if (!this.pp_SaldoRubro.isEmpty() || this.pp_SaldoRubro != null) {
                    this.pp_SaldoRubro.forEach(e -> {
                        this.modelo.addRow(dato);
                        this.JTDetalle.setValueAt(e.getIdRubro(), this.JTDetalle.getRowCount() - 1, 0);
                        this.JTDetalle.setValueAt(e.getNombreRubro(), this.JTDetalle.getRowCount() - 1, 1);
                        this.JTDetalle.setValueAt(e.getValorSaldoDisponible(), this.JTDetalle.getRowCount() - 1, 2);
                    });
                    break;
                }
                break;
            case "CodigoCpc":
                crearModeloRuborCpc();
                new ArrayList();
                List<PpRubrosCpc> list = this.iPpRubrosCpcService.getListPpRubrosCpcByNombreOrCodigo(this.JTFFiltro.getText());
                Object[] dato2 = null;
                this.metodos.mEstablecerTextEditor(this.JTDetalle, 1);
                if (!list.isEmpty()) {
                    list.forEach(e2 -> {
                        this.modelo.addRow(dato2);
                        this.JTDetalle.setValueAt(e2.getCodigo(), this.JTDetalle.getRowCount() - 1, 0);
                        this.JTDetalle.setValueAt(e2.getNombre(), this.JTDetalle.getRowCount() - 1, 1);
                        this.JTDetalle.setValueAt(e2.getUltimoNivel(), this.JTDetalle.getRowCount() - 1, 2);
                        this.JTDetalle.setValueAt(e2.getEstado(), this.JTDetalle.getRowCount() - 1, 3);
                    });
                    break;
                }
                break;
            case "tercero":
                crearModeloTercero();
                new ArrayList();
                List<GEmpresa> list2 = this.iGEmpresaService.getLisEmpresaOrderByNombreAsc(this.JTFFiltro.getText());
                Object[] dato3 = null;
                this.metodos.mEstablecerTextEditor(this.JTDetalle, 1);
                if (!list2.isEmpty()) {
                    list2.forEach(e3 -> {
                        this.modelo.addRow(dato3);
                        this.JTDetalle.setValueAt(e3.getNoidentificacion(), this.JTDetalle.getRowCount() - 1, 0);
                        if (e3.getNbre().isEmpty() || e3.getNbre() == null) {
                            this.JTDetalle.setValueAt(e3.getApellido1().concat(" ").concat(e3.getApellido2()).concat(" ").concat(e3.getNombre1()).concat(" ").concat(e3.getNombre2()), this.JTDetalle.getRowCount() - 1, 1);
                        } else {
                            this.JTDetalle.setValueAt(e3.getNbre(), this.JTDetalle.getRowCount() - 1, 1);
                        }
                        this.JTDetalle.setValueAt(e3.getEstado(), this.JTDetalle.getRowCount() - 1, 2);
                    });
                    break;
                }
                break;
            case "tercero_compromiso":
                crearModeloTercero();
                new ArrayList();
                List<GEmpresa> list3 = this.iGEmpresaService.getLisEmpresaOrderByNombreAsc(this.JTFFiltro.getText());
                Object[] dato4 = null;
                this.metodos.mEstablecerTextEditor(this.JTDetalle, 1);
                if (!list3.isEmpty()) {
                    list3.forEach(e4 -> {
                        this.modelo.addRow(dato4);
                        this.JTDetalle.setValueAt(e4.getNoidentificacion(), this.JTDetalle.getRowCount() - 1, 0);
                        if (e4.getNbre().isEmpty() || e4.getNbre() == null) {
                            this.JTDetalle.setValueAt(e4.getApellido1().concat(" ").concat(e4.getApellido2()).concat(" ").concat(e4.getNombre1()).concat(" ").concat(e4.getNombre2()), this.JTDetalle.getRowCount() - 1, 1);
                        } else {
                            this.JTDetalle.setValueAt(e4.getNbre(), this.JTDetalle.getRowCount() - 1, 1);
                        }
                        this.JTDetalle.setValueAt(e4.getEstado(), this.JTDetalle.getRowCount() - 1, 2);
                    });
                    break;
                }
                break;
        }
    }

    private void casting(Object objetoLlamador) {
        switch (objetoLlamador.getClass().getSimpleName()) {
            case "JIFFMovimiento_new":
                this.jIFFMovimiento_new = (JIFFMovimiento_new) objetoLlamador;
                setTitle(getTitle() + " " + this.jIFFMovimiento_new.getTitle());
                break;
            case "JIFCompromisoPresupuestal":
                this.jIFCompromisoPresupuestal = (JIFCompromisoPresupuestal) objetoLlamador;
                setTitle(getTitle() + " " + this.jIFCompromisoPresupuestal.getTitle());
                break;
        }
    }
}
