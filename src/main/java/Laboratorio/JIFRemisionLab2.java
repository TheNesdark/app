package Laboratorio;

import Acceso.Principal;
import ParametrizacionN.AutoCompletarComboBox;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcTerceros;
import com.genoma.plus.jpa.entities.GEmpresa;
import com.genoma.plus.jpa.entities.GProcedimientoEmpresaRemision;
import com.genoma.plus.jpa.entities.LDetallerecepcion;
import com.genoma.plus.jpa.entities.LDetalleremision;
import com.genoma.plus.jpa.entities.LRemision;
import com.genoma.plus.jpa.projection.GProcedimientoEmpresaRemisionProjection;
import com.genoma.plus.jpa.service.CcTercerosService;
import com.genoma.plus.jpa.service.IGProcedimientoEmpresaRemisionService;
import com.genoma.plus.jpa.service.ILDetalleRecepcionService;
import com.genoma.plus.jpa.service.ILDetalleRemisionService;
import com.genoma.plus.jpa.service.ILRemisionService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFRemisionLab2.class */
public class JIFRemisionLab2 extends JInternalFrame {
    private DefaultTableModel modelo;
    private DefaultTableModel modeloConsolidado;
    private Object[] datos;
    private Object[] datosConsolidado;
    private JDBuscarRemisiones2 jDBuscarRemisiones;
    private boolean tipog;
    private ButtonGroup JBGSeleccion;
    private JButton JBTExportar;
    public JComboBox JCBProveedor;
    private JCheckBox JCH_Adjunto1;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatos;
    private JRadioButton JRBQuitarSeleccion;
    private JRadioButton JRBSeleccionar;
    private JScrollPane JSPConsolidado;
    private JScrollPane JSPDetalle;
    private JTable JTConsolidado;
    private JTable JTDetalle;
    private JTextField JTFRuta;
    private JTabbedPane JTPInformacion;
    private ConsultasMySQL consulta = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private List<CcTerceros> listaTerceros = new ArrayList();
    private List<GProcedimientoEmpresaRemisionProjection> listaEmpresaRemision = new ArrayList();
    private List<GProcedimientoEmpresaRemision> listaERemision = new ArrayList();
    private List<LDetalleremision> listaDetalleRemision = new ArrayList();
    private List<LRemision> listaRemision = new ArrayList();
    private List<LDetallerecepcion> listaDetalleRecepcion = new ArrayList();
    private final CcTercerosService iCcTercerosService = (CcTercerosService) Principal.contexto.getBean(CcTercerosService.class);
    private final IGProcedimientoEmpresaRemisionService iGProcedimientoEmpresaRemisionService = (IGProcedimientoEmpresaRemisionService) Principal.contexto.getBean(IGProcedimientoEmpresaRemisionService.class);
    private final ILDetalleRemisionService iILDetalleRemisionService = (ILDetalleRemisionService) Principal.contexto.getBean(ILDetalleRemisionService.class);
    private final ILRemisionService iLRemisionService = (ILRemisionService) Principal.contexto.getBean(ILRemisionService.class);
    private final ILDetalleRecepcionService iLDetalleRecepcionService = (ILDetalleRecepcionService) Principal.contexto.getBean(ILDetalleRecepcionService.class);

    public JIFRemisionLab2() {
        initComponents();
        nuevo();
    }

    public void nuevo() {
        cargarComboTercero();
        this.JTFRuta.setText(this.metodos.getDirectorioExportacion() + "Planilla");
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        crearModeloDatos();
        crearModeloDatosConsolidado();
        this.JTPInformacion.setEnabledAt(0, false);
        this.JTPInformacion.setEnabledAt(1, false);
        this.JDFechaI.requestFocus();
        Principal.txtNo.setText("");
    }

    private void cargarComboTercero() {
        this.JCBProveedor.removeAllItems();
        this.listaTerceros.clear();
        autocompletarComboEmpresa();
        this.listaTerceros = this.iCcTercerosService.listarTodosLosTerceros();
        if (this.listaTerceros != null && !this.listaTerceros.isEmpty()) {
            this.listaTerceros.forEach(d -> {
                this.JCBProveedor.addItem(d.getRazonSocial());
                this.JCBProveedor.setSelectedIndex(-1);
            });
        }
        this.JCBProveedor.setSelectedIndex(-1);
    }

    private void autocompletarComboEmpresa() {
        new AutoCompletarComboBox(this.JCBProveedor);
    }

    public void grabar() {
        if (!this.JTPInformacion.isEnabledAt(0) && this.JTPInformacion.isEnabledAt(1)) {
            if (this.JTDetalle.getRowCount() != 0) {
                if (this.metodos.mVerificarDatosTablaTrue(this.JTDetalle, 0)) {
                    LRemision lr = new LRemision();
                    GEmpresa gEmpresa = new GEmpresa();
                    gEmpresa.setId(Long.valueOf(this.listaTerceros.get(this.JCBProveedor.getSelectedIndex()).getId().intValue()));
                    lr.setIdEmpresa(gEmpresa);
                    lr.setFechaRem(this.metodos.convertToLocalDateViaInstant(this.metodos.getFechaActual()));
                    lr.setFecha(this.metodos.getFechaActual().toInstant());
                    lr.setEstado(0);
                    lr.setUsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
                    LRemision lr2 = this.iLRemisionService.grabar(lr);
                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                        if (Boolean.valueOf(this.JTDetalle.getValueAt(i, 0).toString()).booleanValue()) {
                            LDetalleremision detalleRemision = new LDetalleremision();
                            LDetallerecepcion lDetallerecepcion = this.iLDetalleRecepcionService.findByIdRecepcion_IdAndIdProcedim_Id(Long.valueOf(this.JTDetalle.getValueAt(i, 1).toString()), Long.valueOf(this.JTDetalle.getValueAt(i, 5).toString()));
                            detalleRemision.setIdRemision(lr2);
                            detalleRemision.setIdRecepcion(lDetallerecepcion.getIdRecepcion());
                            detalleRemision.setIdProcedimiento(lDetallerecepcion.getIdProcedim());
                            this.listaDetalleRemision.add(detalleRemision);
                            lDetallerecepcion.setIdRemision(Integer.valueOf(lr2.getId().intValue()));
                            this.listaDetalleRecepcion.add(lDetallerecepcion);
                        }
                    }
                    if (!this.listaDetalleRemision.isEmpty()) {
                        this.iILDetalleRemisionService.grabarTodo(this.listaDetalleRemision);
                        this.iLDetalleRecepcionService.saveAll(this.listaDetalleRecepcion);
                        JOptionPane.showMessageDialog((Component) null, "Datos Guardados");
                    }
                    crearModeloDatosConsolidado();
                    cargarDatosTabla();
                    return;
                }
                JOptionPane.showMessageDialog((Component) null, "No Se Ha Seleccionado Ningun Registro Para Remitir");
                return;
            }
            JOptionPane.showMessageDialog((Component) null, "No Se Encontraron Registros");
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Esta Opcion Esta Habilitada Solo Al Buscar Por Procedimientos");
    }

    public void buscar() {
        Object[] botones = {"Procedimiento", "Remisiones", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "BUSCAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        switch (n) {
            case 0:
                if (this.JCBProveedor != null) {
                    this.JTPInformacion.setEnabledAt(0, false);
                    this.JTPInformacion.setEnabledAt(1, true);
                    this.JTPInformacion.setSelectedIndex(1);
                    crearModeloDatosConsolidado();
                    cargarDatosTabla();
                    this.tipog = false;
                }
                break;
            case 1:
                this.tipog = true;
                this.JTPInformacion.setEnabledAt(0, true);
                this.JTPInformacion.setEnabledAt(1, true);
                this.JTPInformacion.setSelectedIndex(0);
                cargarDatosTablaConsolidado();
                crearModeloDatos();
                break;
            default:
                dispose();
                break;
        }
    }

    public void anular() {
        if (!Principal.txtNo.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                System.out.println(Principal.txtNo.getText());
                try {
                    this.listaRemision = this.iLRemisionService.listarLRemision();
                    this.listaRemision.forEach(e -> {
                        if (e.getId().toString().equals(Principal.txtNo.getText())) {
                            System.out.println("id remision" + e.getId());
                            e.setEstado(1);
                            this.listaRemision.add(e);
                            this.iLRemisionService.grabar(e);
                        }
                    });
                } catch (Exception e2) {
                    System.out.println("Error");
                }
                JOptionPane.showMessageDialog((Component) null, "Remision anulada");
            }
        }
    }

    public void imprimir() {
        if (this.JTDetalle.getRowCount() != 0) {
            String idDetalleRemisiones = "";
            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                if (Boolean.valueOf(this.modelo.getValueAt(i, 0).toString()).booleanValue() && !this.modelo.getValueAt(i, 1).toString().equals("0")) {
                    idDetalleRemisiones = idDetalleRemisiones + this.modelo.getValueAt(i, 1).toString() + ",";
                }
            }
            if (!idDetalleRemisiones.isEmpty()) {
                String idDetalleRemisiones2 = idDetalleRemisiones.substring(0, idDetalleRemisiones.length() - 1);
                String[][] parametros = new String[3][2];
                parametros[0][0] = "id";
                parametros[0][1] = idDetalleRemisiones2;
                parametros[1][0] = "SUBREPORT_DIR";
                parametros[1][1] = this.metodos.getSO() + this.metodos.getBarra() + "Reportes" + this.metodos.getBarra();
                parametros[2][0] = "SUBREPORTFIRMA_DIR";
                parametros[2][1] = this.metodos.getSO() + this.metodos.getBarra() + "Firmas" + this.metodos.getBarra();
                if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                    System.out.println("imprime2");
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_PlanillaRemisionIndividual", parametros);
                    return;
                } else {
                    System.out.println("imprime3");
                    this.metodos.GenerarPDF(this.metodos.getRutaRep() + "L_PlanillaRemisionIndividual1", parametros);
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "No se encontraron registros del detalle seleccionados o que posean un Id de Remision", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void crearModeloDatosConsolidado() {
        this.modeloConsolidado = new DefaultTableModel((Object[][]) null, new String[]{"Seleccionar", "No.", "Fecha", "Empresa", "Estado"}) { // from class: Laboratorio.JIFRemisionLab2.1
            Class[] types = {Boolean.class, Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTConsolidado;
        JTable jTable2 = this.JTConsolidado;
        jTable.setAutoResizeMode(0);
        this.JTConsolidado.doLayout();
        this.JTConsolidado.setModel(this.modeloConsolidado);
        this.JTConsolidado.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTConsolidado.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTConsolidado.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTConsolidado.getColumnModel().getColumn(3).setPreferredWidth(500);
        this.JTConsolidado.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    private void cargarDatosTablaConsolidado() {
        crearModeloDatosConsolidado();
        this.listaRemision = this.iLRemisionService.listarRemisiones(0);
        this.listaRemision.forEach(e -> {
            this.modeloConsolidado.addRow(this.datosConsolidado);
            this.modeloConsolidado.setValueAt(false, this.JTConsolidado.getRowCount() - 1, 0);
            this.modeloConsolidado.setValueAt(e.getId(), this.JTConsolidado.getRowCount() - 1, 1);
            this.modeloConsolidado.setValueAt(this.metodos.formatoAMD1.format(Date.from(e.getFecha())), this.JTConsolidado.getRowCount() - 1, 2);
            this.modeloConsolidado.setValueAt(e.getIdEmpresa().getNbre(), this.JTConsolidado.getRowCount() - 1, 3);
            this.modeloConsolidado.setValueAt(Boolean.valueOf(!e.getEstado().equals(1)), this.JTConsolidado.getRowCount() - 1, 4);
        });
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatos() {
        String[] encabezado;
        if (!this.JTPInformacion.isEnabledAt(0) && this.JTPInformacion.isEnabledAt(1)) {
            encabezado = new String[]{"Remitir?", "idRecepcion", "Fecha Recepción", "Documento", "Usuario", "CUP", "Exámen"};
        } else {
            encabezado = new String[]{"Remitir?", "IdDetalleRemision", "Fecha Recepción", "Documento", "Usuario", "CUP", "Exámen"};
        }
        this.modelo = new DefaultTableModel(new Object[0], encabezado) { // from class: Laboratorio.JIFRemisionLab2.2
            Class[] types = {Boolean.class, Long.class, String.class, String.class, String.class, Integer.class, String.class};
            boolean[] canEdit = {true, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.modelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(300);
    }

    private void cargarDatosTabla() {
        crearModeloDatos();
        if (Principal.informacionIps.getNombreIps().equals("CLINICA SANTA CLARA SAS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JUAN DE DIOS")) {
            this.listaEmpresaRemision = this.iGProcedimientoEmpresaRemisionService.listarNat5(this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()));
        } else {
            this.listaEmpresaRemision = this.iGProcedimientoEmpresaRemisionService.listarNat(this.metodos.formatoAMD1.format(this.JDFechaI.getDate()), this.metodos.formatoAMD1.format(this.JDFechaF.getDate()), this.listaTerceros.get(this.JCBProveedor.getSelectedIndex()).getId());
        }
        this.listaEmpresaRemision.forEach(e -> {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(true, this.JTDetalle.getRowCount() - 1, 0);
            this.modelo.setValueAt(e.getId(), this.JTDetalle.getRowCount() - 1, 1);
            this.modelo.setValueAt(e.getFechaRecep(), this.JTDetalle.getRowCount() - 1, 2);
            this.modelo.setValueAt(e.getDocumento(), this.JTDetalle.getRowCount() - 1, 3);
            this.modelo.setValueAt(e.getNUsuario(), this.JTDetalle.getRowCount() - 1, 4);
            this.modelo.setValueAt(e.getIdProcedimiento(), this.JTDetalle.getRowCount() - 1, 5);
            this.modelo.setValueAt(e.getNbre(), this.JTDetalle.getRowCount() - 1, 6);
        });
    }

    public void cargarDatosTablaRemision(List<Integer> idRemision) {
        crearModeloDatos();
        if (!idRemision.isEmpty()) {
            this.listaEmpresaRemision = this.iGProcedimientoEmpresaRemisionService.listarNat2(idRemision);
            this.listaEmpresaRemision.forEach(e -> {
                this.modelo.addRow(this.datos);
                this.modelo.setValueAt(true, this.JTDetalle.getRowCount() - 1, 0);
                this.modelo.setValueAt(e.getIdDetalleRemision(), this.JTDetalle.getRowCount() - 1, 1);
                this.modelo.setValueAt(e.getFechaRecep(), this.JTDetalle.getRowCount() - 1, 2);
                this.modelo.setValueAt(e.getDocumento(), this.JTDetalle.getRowCount() - 1, 3);
                this.modelo.setValueAt(e.getNUsuario(), this.JTDetalle.getRowCount() - 1, 4);
                this.modelo.setValueAt(e.getIdProcedimiento(), this.JTDetalle.getRowCount() - 1, 5);
                this.modelo.setValueAt(e.getNbre(), this.JTDetalle.getRowCount() - 1, 6);
            });
        }
    }

    public void quitarPonerSeleccion(JTable tabla, DefaultTableModel modelo) {
        if (tabla.getRowCount() != 0) {
            for (int x = 0; x < tabla.getRowCount(); x++) {
                if (this.JRBSeleccionar.isSelected()) {
                    modelo.setValueAt(true, x, 0);
                } else {
                    modelo.setValueAt(false, x, 0);
                }
            }
        }
    }

    private void verificarRemisionesSeleccionadas() {
        if (this.JTConsolidado.getRowCount() != 0) {
            List<Integer> listaIdRemisiones = new ArrayList<>();
            for (int i = 0; i < this.JTConsolidado.getRowCount(); i++) {
                if (Boolean.valueOf(this.modeloConsolidado.getValueAt(i, 0).toString()).booleanValue()) {
                    listaIdRemisiones.add(Integer.valueOf(this.modeloConsolidado.getValueAt(i, 1).toString()));
                }
            }
            cargarDatosTablaRemision(listaIdRemisiones);
        }
    }

    /* JADX WARN: Type inference failed for: r3v46, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v50, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGSeleccion = new ButtonGroup();
        this.JPIDatos = new JPanel();
        this.JCBProveedor = new JComboBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JRBSeleccionar = new JRadioButton();
        this.JRBQuitarSeleccion = new JRadioButton();
        this.JBTExportar = new JButton();
        this.JTFRuta = new JTextField();
        this.JTPInformacion = new JTabbedPane();
        this.JSPConsolidado = new JScrollPane();
        this.JTConsolidado = new JTable();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JCH_Adjunto1 = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("REMISIÓN DE EXÁMENES 2");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1099, 662));
        setMinimumSize(new Dimension(1099, 662));
        setName("jifremision2");
        setPreferredSize(new Dimension(1099, 662));
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        this.JPIDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBProveedor.setEditable(true);
        this.JCBProveedor.setFont(new Font("Arial", 1, 12));
        this.JCBProveedor.setBorder(BorderFactory.createTitledBorder((Border) null, "Tercero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JBGSeleccion.add(this.JRBSeleccionar);
        this.JRBSeleccionar.setFont(new Font("Arial", 1, 12));
        this.JRBSeleccionar.setSelected(true);
        this.JRBSeleccionar.setText("Seleccionar Todo");
        this.JRBSeleccionar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRemisionLab2.3
            public void actionPerformed(ActionEvent evt) {
                JIFRemisionLab2.this.JRBSeleccionarActionPerformed(evt);
            }
        });
        this.JBGSeleccion.add(this.JRBQuitarSeleccion);
        this.JRBQuitarSeleccion.setFont(new Font("Arial", 1, 12));
        this.JRBQuitarSeleccion.setText("Quitar Selección");
        this.JRBQuitarSeleccion.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRemisionLab2.4
            public void actionPerformed(ActionEvent evt) {
                JIFRemisionLab2.this.JRBQuitarSeleccionActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 140, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProveedor, 0, -1, 32767).addGap(18, 18, 18).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JRBQuitarSeleccion).addComponent(this.JRBSeleccionar)).addGap(35, 35, 35)));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaI, -2, 50, -2).addComponent(this.JDFechaF, -2, 50, -2))).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JRBSeleccionar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBQuitarSeleccion)).addComponent(this.JCBProveedor, -2, 50, -2)))).addGap(10, 10, 10)));
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Laboratorio.JIFRemisionLab2.5
            public void actionPerformed(ActionEvent evt) {
                JIFRemisionLab2.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPInformacion.setForeground(Color.red);
        this.JTPInformacion.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setFont(new Font("Arial", 1, 12));
        this.JTConsolidado.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTConsolidado.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFRemisionLab2.6
            public void mouseClicked(MouseEvent evt) {
                JIFRemisionLab2.this.JTConsolidadoMouseClicked(evt);
            }
        });
        this.JSPConsolidado.setViewportView(this.JTConsolidado);
        this.JTPInformacion.addTab("CONSOLIDADO", this.JSPConsolidado);
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTPInformacion.addTab("DETALLE", this.JSPDetalle);
        this.JCH_Adjunto1.setBackground(Color.green);
        this.JCH_Adjunto1.setFont(new Font("Arial", 1, 12));
        this.JCH_Adjunto1.setText("Adjunto?");
        this.JCH_Adjunto1.setOpaque(true);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JTFRuta, -2, 404, -2).addGap(38, 38, 38).addComponent(this.JBTExportar, -2, 279, -2).addGap(157, 157, 157).addComponent(this.JCH_Adjunto1).addGap(10, 129, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatos, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JTPInformacion)).addContainerGap()))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPInformacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JCH_Adjunto1))).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSeleccionarActionPerformed(ActionEvent evt) {
        if (this.JTPInformacion.getSelectedIndex() == 0) {
            quitarPonerSeleccion(this.JTConsolidado, this.modeloConsolidado);
            verificarRemisionesSeleccionadas();
        } else {
            quitarPonerSeleccion(this.JTDetalle, this.modelo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBQuitarSeleccionActionPerformed(ActionEvent evt) {
        if (this.JTPInformacion.getSelectedIndex() == 0) {
            quitarPonerSeleccion(this.JTConsolidado, this.modeloConsolidado);
            verificarRemisionesSeleccionadas();
        } else {
            quitarPonerSeleccion(this.JTDetalle, this.modelo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
            this.metodos.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTConsolidadoMouseClicked(MouseEvent evt) {
        if (this.JTConsolidado.getSelectedRow() != -1 && this.JTConsolidado.getSelectedColumn() == 0) {
            verificarRemisionesSeleccionadas();
        }
    }
}
