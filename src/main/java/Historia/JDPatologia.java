package Historia;

import Acceso.Principal;
import ComprasBS.JIFSolicitudContrato;
import Contabilidad.JIFConsultaInformesTerceros;
import Contabilidad.JIFConsultarCuentasxP;
import Contabilidad.JIFConsultar_LibroAuxiliar_Fecha;
import Contabilidad.JIFConsultar_LibroAuxiliar_RangoCuenta;
import Contabilidad.JIFConsultar_LibroAuxiliar_Terceros;
import Contabilidad.JIFDocContable;
import Contabilidad.JIFGeneracionPagos_Directo;
import Contabilidad.JIFRadicacion;
import Contabilidad.JIFSolicitudReembolsoCM;
import Contabilidad.JIFSolicitudReembolsoCMV2;
import Contabilidad.JIF_Consultar_Movimiento;
import Facturacion.Facturac;
import Laboratorio.TareaOrdenesPendientePorValidar;
import Presupuesto.JIFBuscarDocPresup;
import Presupuesto.JIFFMovimiento;
import Presupuesto.JIFFMovimientoManual;
import Presupuesto.JIFF_InformesCuentasxPagarPTO;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.MetodosGenericos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.genoma.plus.controller.caja.JIFRecibosEgresos;
import com.genoma.plus.controller.comprabs.JIFContratoInformeCgr;
import com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart;
import com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2;
import com.genoma.plus.controller.general.JIFGEmpresaUnificacionUsuario;
import com.genoma.plus.controller.laboratorio.dto.CustomPresenter;
import com.genoma.plus.controller.laboratorio.dto.InfoAlertaTiempoRecepcionesDTO;
import com.genoma.plus.controller.laboratorio.dto.infoAlertaRececion;
import com.genoma.plus.domains.models.domains.general.RecursosMicroserviciosDomain;
import com.genoma.plus.jpa.dto.ParametroFiltroPlanillaTrabajoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.ws.rs.core.Response;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JDPatologia.class */
public class JDPatologia extends JDialog {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloCitas;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private JDOrdenNacidos xJDOrdenNacidos;
    private JDOrdenNacidosNovedad xJDOrdenNacidosNovedad;
    private JIFFMovimiento xJIFFMovimiento;
    private JIFSolicitudContrato xJIFSolicitudContrato;
    private JIFFMovimientoManual xJIFFMovimientoManual;
    private JIFBuscarDocPresup xJIFBuscarDocPresup;
    private JIFRadicacion xJIFRadicacion;
    private JIFF_InformesCuentasxPagarPTO xJIFF_InformesCuentasxPagarPTO;
    private JIFConsultar_LibroAuxiliar_Terceros xJIFConsultar_LibroAuxiliar_Terceros;
    private JIFConsultarCuentasxP xJIFConsultarCuentasxP;
    private JIFConsultarCuentasxPagarContaCart xJIFConsultarCuentasxPagarContaCart;
    private JIF_Consultar_Movimiento xJIF_Consultar_Movimiento;
    private JIFGeneracionPagos_Directo xJIFGeneracionPagos_Directo;
    private JIFContratoInformeCgr xJIFContratoInformeCgr;
    private JIFGEmpresaUnificacionUsuario xJIFGEmpresaUnificacionUsuario;
    private JPI_FormularioAnexo2 formularioAnexo2;
    private JPAEventoECastPacienteGasto jPAEventoECastPacienteGasto;
    private JIFConsultar_LibroAuxiliar_Fecha consultar_LibroAuxiliar_Fecha;
    private JIFRecibosEgresos recibosEgresos;
    private JIFDocContable docContable;
    private JIFSolicitudReembolsoCM jIFSolicitudReembolsoCM;
    private Facturac xFacturacion;
    private Object xLlamador;
    private Metodos xmt;
    private int xFila;
    private int xColumna;
    private int banderaBuscador;
    private String xCampo;
    private String nomf;
    private JIFConsultaInformesTerceros xJIFConsultaInformesTerceros;
    private JIFConsultar_LibroAuxiliar_RangoCuenta xJIFConsultar_LibroAuxiliar_RangoCuenta;
    private JIFSolicitudReembolsoCMV2 jIFSolicitudReembolsoCMV2;
    private Object[] dato;
    private String nombre;
    private long idRecepcion;
    Metodos metodos;
    Principal xjp;
    private ConsultasMySQL xconsultasbd;
    private JCheckBox CheckRecepceion;
    private JButton JBTExportar;
    private JCheckBox JCHEventos;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JTable JTDetalle;
    private JTextField JTFNombre;
    private JTextField JTFRuta;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;

    public JDPatologia(Frame parent, boolean modal, Object xLlamador) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.banderaBuscador = 0;
        this.nombre = "";
        this.metodos = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        initComponents();
        mCasting(xLlamador);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        switch (xLlamador.getClass().getSimpleName()) {
            case "JDOrdenNacidos":
                setTitle("BÚSQUEDA DE PATOLOGÍA");
                break;
            case "Principal":
                setTitle("LÍQUIDACIONES PENDIENTES");
                this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JCHEventos.setVisible(true);
                mBuscaUsuarios();
                break;
            case "JDOrdenNacidosNovedad":
                setTitle("BÚSQUEDA DE PATOLOGÍA");
                break;
            case "JIFFMovimiento":
            case "JIFSolicitudContrato":
            case "JIFFMovimientoManual":
            case "JIFRadicacion":
            case "JIFF_InformesCuentasxPagarPTO":
            case "JIFConsultar_LibroAuxiliar_Terceros":
            case "JIFConsultarCuentasxP":
            case "JIFConsultarCuentasxPagarContaCart":
            case "JIF_Consultar_Movimiento":
            case "JIFContratoInformeCgr":
            case "JPI_FormularioAnexo2":
            case "JIFConsultar_LibroAuxiliar_Fecha":
            case "JIFRecibosEgresos":
            case "JIFDocContable":
            case "JPAEventoECastPacienteGasto":
            case "JIFSolicitudReembolsoCM":
            case "JIFConsultaInformesTerceros":
            case "JIFConsultar_LibroAuxiliar_RangoCuenta":
            case "JIFSolicitudReembolsoCMV2":
                setTitle("BÚSQUEDA DE TERCEROS");
                this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Tercero ó Número de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
                break;
        }
        setLocationRelativeTo(null);
    }

    public JDPatologia(Frame parent, boolean modal, Object xLlamador, int xFila) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.banderaBuscador = 0;
        this.nombre = "";
        this.metodos = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        initComponents();
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        this.xFila = xFila;
        mCasting(xLlamador);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        switch (xLlamador.getClass().getSimpleName()) {
            case "JDOrdenNacidos":
                setTitle("BÚSQUEDA DE PATOLOGÍA");
                break;
            case "Principal":
                setTitle("LÍQUIDACIONES PENDIENTES");
                this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
                mBuscaUsuarios();
                break;
            case "JDOrdenNacidosNovedad":
                setTitle("BÚSQUEDA DE PATOLOGÍA");
                break;
            case "JIFGeneracionPagos_Directo":
                setTitle("BÚSQUEDA DE TERCEROS");
                this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Tercero ó Número de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
                break;
        }
        setLocationRelativeTo(null);
    }

    public JDPatologia(Frame parent, boolean modal, Object xLlamador, String campo) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.banderaBuscador = 0;
        this.nombre = "";
        this.metodos = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        initComponents();
        this.JDFechaI.setDate(this.metodos.getFechaActual());
        this.JDFechaF.setDate(this.metodos.getFechaActual());
        this.xLlamador = xLlamador;
        mCasting(xLlamador);
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.nomf = xLlamador.getClass().getSimpleName().trim();
        if (xLlamador.getClass().getSimpleName().equals("JIFGEmpresaUnificacionUsuario")) {
            this.xCampo = campo;
            setTitle("BÚSQUEDA DE TERCEROS");
            this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Tercero ó Número de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("Principal")) {
            if (campo.equals("7")) {
                setTitle("CITAS PENDIENTES POR FACTURAR");
                this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JCHEventos.setVisible(true);
                cargarCitasPorFactuarar(false);
            }
            if (campo.equals("24")) {
                System.err.println("llamador " + this.xLlamador);
                setTitle("RECEPCIONES PENDIENTES POR VALIDAR");
                this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre de Usuario", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JCHEventos.setVisible(true);
                this.banderaBuscador = 1;
                cargarInfoRecepciones();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.JTFNombre = new JTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.jPanel2 = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JCHEventos = new JCheckBox();
        this.JPDatos = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.CheckRecepceion = new JCheckBox();
        setDefaultCloseOperation(2);
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "BÚSQUEDA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombre.addKeyListener(new KeyAdapter() { // from class: Historia.JDPatologia.1
            public void keyPressed(KeyEvent evt) {
                JDPatologia.this.JTFNombreKeyPressed(evt);
            }

            public void keyReleased(KeyEvent evt) {
                JDPatologia.this.JTFNombreKeyReleased(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -1, 472, 32767).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFNombre, -2, 49, -2).addGap(10, 10, 10)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JDPatologia.2
            public void mouseClicked(MouseEvent evt) {
                JDPatologia.this.JTDetalleMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA EXPORTAR", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: Historia.JDPatologia.3
            public void mouseClicked(MouseEvent evt) {
                JDPatologia.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: Historia.JDPatologia.4
            public void actionPerformed(ActionEvent evt) {
                JDPatologia.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JCHEventos.setBackground(new Color(177, 251, 177));
        this.JCHEventos.setFont(new Font("Arial", 1, 12));
        this.JCHEventos.setText("Eventos");
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 382, -2).addGap(42, 42, 42).addComponent(this.JBTExportar, -2, 198, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEventos).addContainerGap(213, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFRuta, -2, 50, -2).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JCHEventos)));
        this.JCHEventos.setVisible(false);
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JDPatologia.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDPatologia.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JDPatologia.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDPatologia.this.JDFechaFPropertyChange(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(this.JDFechaI, -2, 136, -2).addGap(0, 0, 0).addComponent(this.JDFechaF, -2, 136, -2).addContainerGap(23, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFechaI, -2, 56, -2).addComponent(this.JDFechaF, -2, 56, -2)).addGap(0, 0, 0)));
        this.CheckRecepceion.setText("Recepcion?");
        this.CheckRecepceion.addActionListener(new ActionListener() { // from class: Historia.JDPatologia.7
            public void actionPerformed(ActionEvent evt) {
                JDPatologia.this.CheckRecepceionActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPDatos, -2, 305, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.CheckRecepceion, -2, 122, -2))).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(8, 8, 8).addComponent(this.JPDatos, -2, 80, -2)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGap(39, 39, 39).addComponent(this.CheckRecepceion))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 276, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
        pack();
    }

    private void mCasting(Object xLlamador) {
        switch (xLlamador.getClass().getSimpleName()) {
            case "JDOrdenNacidos":
                this.xJDOrdenNacidos = (JDOrdenNacidos) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JDOrdenNacidosNovedad":
                this.xJDOrdenNacidosNovedad = (JDOrdenNacidosNovedad) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "Principal":
                this.xLlamador = xLlamador;
                break;
            case "JIFFMovimiento":
                this.xJIFFMovimiento = (JIFFMovimiento) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFSolicitudContrato":
                this.xJIFSolicitudContrato = (JIFSolicitudContrato) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFFMovimientoManual":
                this.xJIFFMovimientoManual = (JIFFMovimientoManual) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFBuscarDocPresup":
                this.xJIFBuscarDocPresup = (JIFBuscarDocPresup) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFRadicacion":
                this.xJIFRadicacion = (JIFRadicacion) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFF_InformesCuentasxPagarPTO":
                this.xJIFF_InformesCuentasxPagarPTO = (JIFF_InformesCuentasxPagarPTO) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFConsultar_LibroAuxiliar_Terceros":
                this.xJIFConsultar_LibroAuxiliar_Terceros = (JIFConsultar_LibroAuxiliar_Terceros) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFConsultarCuentasxP":
                this.xJIFConsultarCuentasxP = (JIFConsultarCuentasxP) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFConsultarCuentasxPagarContaCart":
                this.xJIFConsultarCuentasxPagarContaCart = (JIFConsultarCuentasxPagarContaCart) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIF_Consultar_Movimiento":
                this.xJIF_Consultar_Movimiento = (JIF_Consultar_Movimiento) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFGeneracionPagos_Directo":
                this.xJIFGeneracionPagos_Directo = (JIFGeneracionPagos_Directo) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFContratoInformeCgr":
                this.xJIFContratoInformeCgr = (JIFContratoInformeCgr) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JPI_FormularioAnexo2":
                this.formularioAnexo2 = (JPI_FormularioAnexo2) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFConsultar_LibroAuxiliar_Fecha":
                this.consultar_LibroAuxiliar_Fecha = (JIFConsultar_LibroAuxiliar_Fecha) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFRecibosEgresos":
                this.recibosEgresos = (JIFRecibosEgresos) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFDocContable":
                this.docContable = (JIFDocContable) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JPAEventoECastPacienteGasto":
                this.jPAEventoECastPacienteGasto = (JPAEventoECastPacienteGasto) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFSolicitudReembolsoCM":
                this.jIFSolicitudReembolsoCM = (JIFSolicitudReembolsoCM) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFConsultaInformesTerceros":
                this.xJIFConsultaInformesTerceros = (JIFConsultaInformesTerceros) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFConsultar_LibroAuxiliar_RangoCuenta":
                this.xJIFConsultar_LibroAuxiliar_RangoCuenta = (JIFConsultar_LibroAuxiliar_RangoCuenta) xLlamador;
                this.xLlamador = xLlamador;
                break;
            case "JIFSolicitudReembolsoCMV2":
                this.jIFSolicitudReembolsoCMV2 = (JIFSolicitudReembolsoCMV2) xLlamador;
                this.xLlamador = xLlamador;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyReleased(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            if (this.xLlamador.getClass().getSimpleName().equals("JDOrdenNacidos")) {
                this.xJDOrdenNacidos.JTFDx.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.xJDOrdenNacidos.JTFPatologia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JDOrdenNacidosNovedad")) {
                this.xJDOrdenNacidosNovedad.JTFDx.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.xJDOrdenNacidosNovedad.JTFPatologia.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("Principal") && Principal.clasefacturacion != null) {
                if (null == Principal.informacionGeneralPrincipalDTO.getIdModulo()) {
                    if (!mVerificaPantalla()) {
                        Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "Citas");
                    } else {
                        try {
                            Principal.PanelPpal.removeAll();
                            Principal.clasescita.frmCita.setSelected(true);
                        } catch (PropertyVetoException e) {
                            Logger.getLogger(JDPatologia.class.getName()).log(Level.SEVERE, (String) null, e);
                        }
                    }
                    Principal.clasescita.frmCita.mNuevo2();
                    Principal.clasescita.frmCita.frmPersona.txtHistoria.setText(this.xmodeloCitas.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                    Principal.clasescita.frmCita.frmPersona.buscar(2);
                    dispose();
                } else {
                    switch (Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue()) {
                        case 5:
                            if (!mVerificaPantalla()) {
                                Principal.clasefacturacion.cargarPantalla("Facturación");
                            } else {
                                try {
                                    Principal.PanelPpal.removeAll();
                                    Principal.clasefacturacion.xjiliqServicio.setSelected(true);
                                } catch (PropertyVetoException e2) {
                                    Logger.getLogger(JDPatologia.class.getName()).log(Level.SEVERE, (String) null, e2);
                                }
                            }
                            Principal.clasefacturacion.xjiliqServicio.mNuevo();
                            Principal.clasefacturacion.xjiliqServicio.xjppersona.txtHistoria.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
                            Principal.clasefacturacion.xjiliqServicio.xjppersona.buscar(2);
                            Principal.clasefacturacion.xjiliqServicio.JLB_NIngreso.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                            Principal.clasefacturacion.xjiliqServicio.mInicar_Variables_Ingreso(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
                            break;
                        case 24:
                            ParametroFiltroPlanillaTrabajoDTO FiltroPlanillaTrabajoDTO = new ParametroFiltroPlanillaTrabajoDTO();
                            FiltroPlanillaTrabajoDTO.setAplicaFiltroMunicipio("0");
                            FiltroPlanillaTrabajoDTO.setAplicaFiltroServicio("0");
                            FiltroPlanillaTrabajoDTO.setEsRemitido("0");
                            FiltroPlanillaTrabajoDTO.setFechaInicial(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().substring(0, 10));
                            FiltroPlanillaTrabajoDTO.setFechaFinal(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString().substring(0, 10));
                            FiltroPlanillaTrabajoDTO.setProcedimientoarea(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                            FiltroPlanillaTrabajoDTO.setFiltro("0");
                            System.out.println("" + FiltroPlanillaTrabajoDTO.getFechaInicial());
                            Principal.claselab.cargarPantalla("Planilla Trabajo", FiltroPlanillaTrabajoDTO, 0);
                            Principal.claselab.xjifplanillatrajano.JTF_NRecepcion.setText(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                            Principal.claselab.xjifplanillatrajano.mCargarRecepcion();
                            break;
                        default:
                            if (!mVerificaPantalla()) {
                                Principal.clasescita.cargarPantalla(Principal.clasescita.frmPrincipal, "Citas");
                            } else {
                                try {
                                    Principal.PanelPpal.removeAll();
                                    Principal.clasescita.frmCita.setSelected(true);
                                } catch (PropertyVetoException e3) {
                                    Logger.getLogger(JDPatologia.class.getName()).log(Level.SEVERE, (String) null, e3);
                                }
                            }
                            Principal.clasescita.frmCita.mNuevo2();
                            Principal.clasescita.frmCita.frmPersona.txtHistoria.setText(this.xmodeloCitas.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                            Principal.clasescita.frmCita.frmPersona.buscar(2);
                            dispose();
                            break;
                    }
                }
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento")) {
                this.xJIFFMovimiento.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 4);
                this.xJIFFMovimiento.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString(), this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 5);
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFSolicitudContrato")) {
                this.xJIFSolicitudContrato.JCBTercero.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimientoManual")) {
                this.xJIFFMovimientoManual.JLNoDoc.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.xJIFFMovimientoManual.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.xJIFFMovimientoManual.xIdTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFBuscarDocPresup")) {
                this.xJIFBuscarDocPresup.JTFNit.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.xJIFBuscarDocPresup.JTFTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.xJIFBuscarDocPresup.mFiltroTercero();
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFRadicacion")) {
                this.xJIFRadicacion.JCBEmpresa.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFF_InformesCuentasxPagarPTO")) {
                this.xJIFF_InformesCuentasxPagarPTO.setXidTercero(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.xJIFF_InformesCuentasxPagarPTO.JLDocumento.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.xJIFF_InformesCuentasxPagarPTO.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_Terceros")) {
                this.xJIFConsultar_LibroAuxiliar_Terceros.xidTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                this.xJIFConsultar_LibroAuxiliar_Terceros.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFConsultarCuentasxP")) {
                this.xJIFConsultarCuentasxP.xidTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                this.xJIFConsultarCuentasxP.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFConsultarCuentasxPagarContaCart")) {
                this.xJIFConsultarCuentasxPagarContaCart.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIF_Consultar_Movimiento")) {
                this.xJIF_Consultar_Movimiento.xidTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                this.xJIF_Consultar_Movimiento.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFGeneracionPagos_Directo")) {
                this.xJIFGeneracionPagos_Directo.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString(), this.xFila, 24);
                this.xJIFGeneracionPagos_Directo.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString() + " " + this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString(), this.xFila, 25);
                this.xJIFGeneracionPagos_Directo.xmodelo.setValueAt(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString(), this.xFila, 26);
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFContratoInformeCgr")) {
                this.xJIFContratoInformeCgr.xIdTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                this.xJIFContratoInformeCgr.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFGEmpresaUnificacionUsuario") && this.xCampo.equals("1")) {
                this.xJIFGEmpresaUnificacionUsuario.JTF_ONHistoria.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.xJIFGEmpresaUnificacionUsuario.JTF_ONId_Persona.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.xJIFGEmpresaUnificacionUsuario.JTF_ONUsuario.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFGEmpresaUnificacionUsuario") && this.xCampo.equals("2")) {
                this.xJIFGEmpresaUnificacionUsuario.JTF_ANHistoria.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString());
                this.xJIFGEmpresaUnificacionUsuario.JTF_ANId_Persona.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.xJIFGEmpresaUnificacionUsuario.JTF_ANUsuario.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JPI_FormularioAnexo2")) {
                this.formularioAnexo2.JTF_Remitido_Nombre_Prestador.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.formularioAnexo2.JTF_Remitido_CodigoPrestador.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_Fecha")) {
                this.consultar_LibroAuxiliar_Fecha.setIdTercero(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
                this.consultar_LibroAuxiliar_Fecha.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFRecibosEgresos")) {
                this.recibosEgresos.JCBTercero.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFDocContable")) {
                this.docContable.JCBTercero.setSelectedItem(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JPAEventoECastPacienteGasto")) {
                this.jPAEventoECastPacienteGasto.JTFEmpresa.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFSolicitudReembolsoCM")) {
                this.jIFSolicitudReembolsoCM.JTFFTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.jIFSolicitudReembolsoCM.idTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFConsultaInformesTerceros")) {
                String[] split = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString().split("-");
                this.xJIFConsultaInformesTerceros.JTFNit.setText(split[0]);
                this.xJIFConsultaInformesTerceros.JLBTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.xJIFConsultaInformesTerceros.idTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_RangoCuenta")) {
                this.xJIFConsultar_LibroAuxiliar_RangoCuenta.JLTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.xJIFConsultar_LibroAuxiliar_RangoCuenta.idTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
                this.xJIFConsultar_LibroAuxiliar_RangoCuenta.JCBFiltroPorTercero.setSelected(true);
                this.xJIFConsultar_LibroAuxiliar_RangoCuenta.mValidarFiltro();
            } else if (this.xLlamador.getClass().getSimpleName().equals("JIFSolicitudReembolsoCMV2")) {
                this.jIFSolicitudReembolsoCMV2.JTFFTercero.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
                this.jIFSolicitudReembolsoCMV2.idTercero = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
            }
            dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
            xfilec.setFileSelectionMode(1);
            int xv = xfilec.showOpenDialog(this);
            if (xv == 0) {
                File xfile = xfilec.getSelectedFile();
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (this.JTDetalle.getRowCount() > 0) {
            int n = JOptionPane.showConfirmDialog(this, "Esta seguro de exportar la infomación", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.JTFRuta.getText(), getTitle());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreKeyPressed(KeyEvent evt) {
        try {
            if (!this.JTFNombre.getText().isEmpty()) {
                if (this.banderaBuscador != 0) {
                    cargarInfoRecepciones();
                } else {
                    switch (this.xLlamador.getClass().getSimpleName()) {
                        case "JDOrdenNacidos":
                        case "JDOrdenNacidosNovedad":
                            mCrearModeloDatos();
                            String sql = "SELECT Id, Nbre FROM g_patologia WHERE  (Nbre like '%" + this.JTFNombre.getText() + "%' and Estado=1) ORDER BY Nbre ASC";
                            ResultSet res = this.xct.traerRs(sql);
                            this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
                            if (res.next()) {
                                int n = 0;
                                res.beforeFirst();
                                while (res.next()) {
                                    this.xmodelo.addRow(this.xdatos);
                                    this.xmodelo.setValueAt(res.getString(1), n, 0);
                                    this.xmodelo.setValueAt(res.getString(2), n, 1);
                                    n++;
                                }
                            }
                            res.close();
                            this.xct.cerrarConexionBd();
                            break;
                        case "Principal":
                            if (Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 5) {
                                mBuscaUsuarios();
                                break;
                            } else {
                                cargarCitasPorFactuarar(true);
                                break;
                            }
                            break;
                        case "JIFFMovimiento":
                        case "JIFSolicitudContrato":
                        case "JIFFMovimientoManual":
                        case "JIFBuscarDocPresup":
                        case "JIFRadicacion":
                        case "JIFF_InformesCuentasxPagarPTO":
                        case "JIFConsultarCuentasxPagarContaCart":
                        case "JIFConsultar_LibroAuxiliar_Terceros":
                        case "JIFConsultarCuentasxP":
                        case "JIF_Consultar_Movimiento":
                        case "JIFGeneracionPagos_Directo":
                        case "JIFContratoInformeCgr":
                        case "JIFGEmpresaUnificacionUsuario":
                        case "JPI_FormularioAnexo2":
                        case "JIFConsultar_LibroAuxiliar_Fecha":
                        case "JIFRecibosEgresos":
                        case "JIFDocContable":
                        case "JPAEventoECastPacienteGasto":
                        case "JIFSolicitudReembolsoCM":
                        case "JIFConsultaInformesTerceros":
                        case "JIFConsultar_LibroAuxiliar_RangoCuenta":
                        case "JIFSolicitudReembolsoCMV2":
                            mBuscarTerceros();
                            break;
                        case "Facturación":
                            mBuscaUsuarios();
                            break;
                    }
                }
            } else if (this.banderaBuscador != 0) {
                cargarInfoRecepciones();
            } else {
                switch (this.xLlamador.getClass().getSimpleName()) {
                    case "Facturación":
                        mBuscaUsuarios();
                        break;
                    case "Principal":
                        if (Principal.informacionGeneralPrincipalDTO.getIdModulo().intValue() == 5) {
                            mBuscaUsuarios();
                            break;
                        } else {
                            cargarCitasPorFactuarar(true);
                            break;
                        }
                        break;
                    case "JPI_FormularioAnexo2":
                        mBuscarTerceros();
                        break;
                    case "Laboratorio":
                        cargarInfoRecepciones();
                        break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CheckRecepceionActionPerformed(ActionEvent evt) {
    }

    private boolean mVerificaPantalla() {
        boolean xExiste = false;
        for (int x = 0; x < Principal.PanelPpal.getComponentCount(); x++) {
            if (Principal.PanelPpal.getComponent(x).getClass().getSimpleName().equals("Facturac") || Principal.PanelPpal.getComponent(x).getClass().getSimpleName().equals("Citas")) {
                xExiste = true;
            }
        }
        return xExiste;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"CIE10", "Nombre"}) { // from class: Historia.JDPatologia.8
            Class[] types = {String.class, String.class};
            boolean[] canEdit = {false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(450);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosTercero() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "TipoDoc", "Documento", "Nombre", "Código Habilitación"}) { // from class: Historia.JDPatologia.9
            Class[] types = {String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(450);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosLiquidacion() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"FechaIngreso", "No.Historia", "Usuario", "TipoAtencion", "Entidad", "FechaE", "HoraE", "Evento", "Id_Ingreso", "HoraI"}) { // from class: Historia.JDPatologia.10
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosLiquidacionCt() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"FechaIngreso", "No.Historia", "Usuario", "TipoAtencion", "Entidad", "FechaE", "HoraE", "Evento", "Id_Ingreso", "HoraI", "Usuario del Sistema"}) { // from class: Historia.JDPatologia.11
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, Long.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(40);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(50);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosCitas() {
        this.xmodeloCitas = new DefaultTableModel(new Object[0], new String[]{"Id Persona", "Tipo Identificacion", "Documento", "Usuario", "Fecha Cita", "Hora Cita", "Especialdiad", "Profecional", "Consultorio", "Sede", "Minutos ATencion"}) { // from class: Historia.JDPatologia.12
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTDetalle.setModel(this.xmodeloCitas);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(100);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloRecepcionesPorValidar() {
        this.xmodeloCitas = new DefaultTableModel(new Object[0], new String[]{"No. Recepcion", "Documento", "Usuario", "sexo", "Procedimiento", "Fecha Rcepcion", "Tiempo"}) { // from class: Historia.JDPatologia.13
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, LocalDateTime.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xmodeloCitas);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(100);
    }

    private void cargarInfoRecepciones() {
        this.idRecepcion = 0L;
        crearModeloRecepcionesPorValidar();
        Metodos metodos = new Metodos();
        MetodosGenericos<infoAlertaRececion> metodosGenericos = new MetodosGenericos<>();
        new ArrayList();
        if (this.CheckRecepceion.isSelected()) {
            String inputText = this.JTFNombre.getText();
            if (!inputText.isEmpty()) {
                this.idRecepcion = Long.parseLong(inputText);
            }
        } else {
            this.nombre = this.JTFNombre.getText();
        }
        RecursosMicroserviciosDomain microserviciosDomain = metodos.getParametrosEncriptados("24", "TareaOrdenesPendientePorValidar");
        infoAlertaRececion date = infoAlertaRececion.builder().fechaRecepcion(this.metodos.formatoAMD1.format(this.JDFechaI.getDate())).fechaRecepcionFinal(this.metodos.formatoAMD1.format(this.JDFechaF.getDate())).nombreUsuario(this.nombre).documento(this.nombre).idRecepcion(Long.valueOf(this.idRecepcion)).diferenciaTiempo("").sexo("").procedimiento("").build();
        String fullUrl = microserviciosDomain.getUrlRecurso() + "/" + metodosGenericos.getParametrosEncryptado(date);
        System.out.println("fullurlSql --- " + fullUrl);
        Response response = metodos.getResteasyClient().target(fullUrl).request().get();
        int statusCode = response.getStatus();
        if (statusCode == 200) {
            try {
                new CustomPresenter();
                CustomPresenter presenter = (CustomPresenter) metodos.getMapper().readValue((String) response.readEntity(String.class), CustomPresenter.class);
                List<InfoAlertaTiempoRecepcionesDTO> recepcionesDTOs = (List) metodos.getMapper().readValue(metodos.getMapper().writeValueAsString(presenter.getData()), new TypeReference<List<InfoAlertaTiempoRecepcionesDTO>>() { // from class: Historia.JDPatologia.14
                });
                recepcionesDTOs.forEach(e -> {
                    this.xmodeloCitas.addRow(this.dato);
                    this.JTDetalle.setValueAt(e.getIdRecepcion(), this.JTDetalle.getRowCount() - 1, 0);
                    this.JTDetalle.setValueAt(e.getDocumento(), this.JTDetalle.getRowCount() - 1, 1);
                    this.JTDetalle.setValueAt(e.getNombreUsuario(), this.JTDetalle.getRowCount() - 1, 2);
                    this.JTDetalle.setValueAt(e.getSexo(), this.JTDetalle.getRowCount() - 1, 3);
                    this.JTDetalle.setValueAt(e.getProcedimiento(), this.JTDetalle.getRowCount() - 1, 4);
                    this.JTDetalle.setValueAt(e.getFechaRecepcion(), this.JTDetalle.getRowCount() - 1, 5);
                    this.JTDetalle.setValueAt(e.getDiferenciaTiempo(), this.JTDetalle.getRowCount() - 1, 6);
                });
            } catch (JsonProcessingException e2) {
                Logger.getLogger(TareaOrdenesPendientePorValidar.class.getName()).log(Level.SEVERE, (String) null, e2);
            }
        }
    }

    private void cargarCitasPorFactuarar(Boolean filtro) {
        try {
            mCrearModeloDatosCitas();
            String sql = "SELECT \ngp.Id idPersona\n, gt.Nbre  tipoIdentificacion\n, gp.NoDocumento documento\n, concat(gp.Apellido1 ,' ', gp.Apellido2,' ',gp.Nombre1, ' ', gp.Nombre2 ) usuario \n, cc.Fecha_Cita fechaCita\n, cc.HoraInicial  horaCita\n, ge.Nbre  especialidad \n, concat(gp2.Apellido1 ,' ', gp2.Apellido2,' ',gp2.Nombre1, ' ', gp2.Nombre2 ) profesional\n, cc2.Nbre consultorio\n, gs.Nbre sede\n, TIMESTAMPDIFF(MINUTE  ,now(), concat(cc.Fecha_Cita ,' ', cc.HoraInicial )) minutosAtencion \nFROM c_citas cc \ninner join g_persona gp on (gp.Id=cc.Id_Usuario)\ninner join g_especialidad ge on (ge.Id=cc.Id_Especialidad)\ninner join g_persona gp2 on (gp2.Id=cc.Id_Profesional)\ninner join c_consultorio cc2 on (cc2.Id=cc.Id_Consultorio)\ninner join g_sedes gs on (gs.Id=cc.Id_Sede) inner join g_tipoidentificacion gt on (gt.Id=gp.Id_TipoIdentificacion)\nwhere cc.Fecha_Cita ='" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "'\nand cc.Asistida =0\nand cc.Id_Sede=" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "\n  HAVING minutosAtencion BETWEEN  0 and 15 and usuario like '%" + this.JTFNombre.getText() + "%'";
            System.out.println("salud " + sql);
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
                while (xrs.next()) {
                    this.xmodeloCitas.addRow(this.dato);
                    this.xmodeloCitas.setValueAt(Long.valueOf(xrs.getLong("idPersona")), n, 0);
                    this.xmodeloCitas.setValueAt(xrs.getString("tipoIdentificacion"), n, 1);
                    this.xmodeloCitas.setValueAt(xrs.getString("documento"), n, 2);
                    this.xmodeloCitas.setValueAt(xrs.getString("usuario"), n, 3);
                    this.xmodeloCitas.setValueAt(xrs.getString("fechaCita"), n, 4);
                    this.xmodeloCitas.setValueAt(xrs.getString("horaCita"), n, 5);
                    this.xmodeloCitas.setValueAt(xrs.getString("especialidad"), n, 6);
                    this.xmodeloCitas.setValueAt(xrs.getString("profesional"), n, 7);
                    this.xmodeloCitas.setValueAt(xrs.getString("consultorio"), n, 8);
                    this.xmodeloCitas.setValueAt(xrs.getString("sede"), n, 9);
                    this.xmodeloCitas.setValueAt(Integer.valueOf(xrs.getInt("minutosAtencion")), n, 10);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionHC.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarTerceros() {
        String sql = "SELECT `Id` , `Id_TipoIdentificacion`,IF(`Id_TipoIdentificacion`='NI',CONCAT(No_identificacion,'-',`Dig_Verificacion`),`No_identificacion`) AS  No_identificacion,\nIF(`Id_TipoIdentificacion`='NI', `Nbre`,CONCAT(`Apellido1`,' ',`Apellido2`,' ',`Nombre1`,' ',`Nombre2`)) AS Empresa, CHabilitacion \nFROM `g_empresa` WHERE (Estado=1 AND CONCAT(IF(`Id_TipoIdentificacion`='NI', `Nbre`,CONCAT(`Apellido1`,' ',`Apellido2`,' ',`Nombre1`,' ',`Nombre2`)), IF(`Id_TipoIdentificacion`='NI',CONCAT(No_identificacion,'-',`Dig_Verificacion`),`No_identificacion`)) LIKE '%" + this.JTFNombre.getText() + "%') ORDER BY Empresa ASC";
        mCrearModeloDatosTercero();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("Id"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("Id_TipoIdentificacion"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("No_identificacion"), n, 2);
                    this.xmodelo.setValueAt(xrs.getString("Empresa"), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("CHabilitacion"), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDPatologia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaUsuarios() {
        String sql;
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
            mCrearModeloDatosLiquidacionCt();
        } else {
            mCrearModeloDatosLiquidacion();
        }
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            if (this.JTFNombre.getText().isEmpty()) {
                sql = "SELECT     ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n  IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n h_atencion.Codigo_Dxp  ,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\n IF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE ,IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \nFROM ingreso     \nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id   \n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n\tAND h_egreso_atencion.Estado =1 \nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)     \nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id)  \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nWHERE   h_atencion.Codigo_Dxp<>'' \n and IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1)=0\tAND h_egreso_atencion.`Id_Destino`<>3 AND h_egreso_atencion.FechaSO IS NOT NULL \n\tAND ingreso.Id_TipoAtencion IN(2,3) \n\tAND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 \n AND ingreso.FechaIngreso>='2015-10-01'  \n ORDER BY FechaE DESC, HoraE DESC";
                System.out.println("consulta 1--> " + sql);
            } else {
                sql = "SELECT     ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n  IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n h_atencion.Codigo_Dxp  ,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\n IF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE ,IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \nFROM ingreso     \nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id   \n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n\tAND h_egreso_atencion.Estado =1 \nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)     \nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id)  \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nWHERE   h_atencion.Codigo_Dxp<>'' \n and IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1)=0\tAND h_egreso_atencion.`Id_Destino`<>3 AND h_egreso_atencion.FechaSO IS NOT NULL \n\tAND ingreso.Id_TipoAtencion IN(2,3) \n\tAND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 \n AND ingreso.FechaIngreso>='2015-10-01' and (CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2)like '" + this.JTFNombre.getText() + "%' or g_usuario.NoHistoria like '" + this.JTFNombre.getText() + "%' ) \n ORDER BY FechaE DESC, HoraE DESC";
                System.out.println("consulta 2--> " + sql);
            }
        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA OFTALMOLOGICA DAJUD SAS") || Principal.informacionIps.getNombreIps().equals("COD-OPTICA UT") || Principal.informacionIps.getNombreIps().equals("JAIME CESAR DAJUD FERNANDEZ")) {
            if (!this.JTFNombre.getText().isEmpty()) {
                sql = "SELECT     ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n  IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n h_atencion.Codigo_Dxp  ,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\n IF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE ,IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa FROM ingreso     \nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id   \n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n\tAND h_egreso_atencion.Estado =1 \nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)     \nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id)  \nINNER JOIN`q_agendacx` ON (q_agendacx.`Id_Ingreso`= ingreso.Id)  \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nWHERE  CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) LIKE '" + this.JTFNombre.getText() + "%'  and f_empresacontxconvenio.Id_GIps='" + Principal.informacionIps.getId() + "' and IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1)=0 and  h_atencion.Codigo_Dxp<>''  AND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 ORDER BY FechaE DESC, HoraE DESC";
                System.out.println("consulta 3--> " + sql);
            } else {
                sql = "SELECT     ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n  IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n h_atencion.Codigo_Dxp  ,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\n IF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE,IFNULL(h_triage.`Clasificacion`, 0) triage ,IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa FROM ingreso     \nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id   \n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n\tAND h_egreso_atencion.Estado =1 \nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)     \nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id)  \nINNER JOIN`q_agendacx` ON (q_agendacx.`Id_Ingreso`= ingreso.Id) LEFT JOIN `h_triage` ON (h_triage.`IdIngreso`= ingreso.Id) AND (h_triage.`Estado`=0) \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nWHERE   h_atencion.Codigo_Dxp<>'' and IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1)=0  and f_empresacontxconvenio.Id_GIps='" + Principal.informacionIps.getId() + "'  AND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 HAVING triage<4 ORDER BY FechaE DESC, HoraE DESC";
                System.out.println("consulta 4--> " + sql);
            }
        } else if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
            if (this.JTFNombre.getText().isEmpty()) {
                sql = "SELECT     ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n  IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n h_atencion.Codigo_Dxp  ,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\n IF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE , IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \nFROM ingreso     \nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id   \n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n\tAND h_egreso_atencion.Estado =1 \nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)     \nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id)  \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nWHERE   h_atencion.Codigo_Dxp<>'' \n\tAND h_egreso_atencion.`Id_Destino`<>3 AND h_egreso_atencion.FechaSO IS NOT NULL \n\tAND ingreso.Id_TipoAtencion IN(2,3) \n and IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1)=0\tAND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 \n AND ingreso.FechaIngreso>='2017-06-01'  \n ORDER BY FechaE DESC, HoraE DESC";
                System.out.println("consulta 5--> " + sql);
            } else {
                sql = "SELECT     ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n  IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n h_atencion.Codigo_Dxp  ,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\n IF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE,IFNULL(h_triage.`Clasificacion`, 0) triage , IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \nFROM ingreso     \nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id   \n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n\tAND h_egreso_atencion.Estado =1 \nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)     \nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id)  LEFT JOIN `h_triage` ON (h_triage.`IdIngreso`= ingreso.Id) AND (h_triage.`Estado`=0) \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nWHERE   h_atencion.Codigo_Dxp<>'' \n\tAND h_egreso_atencion.`Id_Destino`<>3 AND h_egreso_atencion.FechaSO IS NOT NULL \n\tAND ingreso.Id_TipoAtencion >1 \n \tAND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 \n AND ingreso.FechaIngreso>='2017-04-05' and (CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2)like '%" + this.JTFNombre.getText() + "%' or g_usuario.NoHistoria like '" + this.JTFNombre.getText() + "%' ) \n HAVING triage<4  and estadoSalidaAdministrativa=0 ORDER BY FechaE DESC, HoraE DESC";
                System.out.println("consulta 6--> " + sql);
            }
        } else if (Principal.informacionIps.getNombreIps().equals("CLINICA LAURELES PSIQUIATRAS ASOCIADOS I.P.S. S.A.S.") || Principal.informacionIps.getNombreIps().equals("UNION TEMPORAL CLINICA LAURELES")) {
            sql = "SELECT ingreso.Id,\ningreso.FechaIngreso,\ningreso.Id_TipoAtencion,\ningreso.Egreso,\ningreso.Egreso_H,\ng_usuario.NoHistoria,\ng_tipoatencion.Nbre AS TipoAtencion ,\n IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\nCONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\nh_atencion.Codigo_Dxp  ,\nf_empresacontxconvenio.Nbre AS Empresa,\nf_empresacontxconvenio.EsCapitado,\n IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\nIF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE,IFNULL(h_triage.`Clasificacion`, 0) triage , \n IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \n FROM ingreso\n INNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \n INNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\n LEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \n LEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id\n AND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n AND h_egreso_atencion.Estado =1 \n INNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)\n INNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \n INNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id) LEFT JOIN `h_triage` ON (h_triage.`IdIngreso`= ingreso.Id) AND (h_triage.`Estado`=0) \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \n WHERE h_atencion.Codigo_Dxp<>'' \n AND h_egreso_atencion.FechaSO IS NOT NULL \n-- AND h_egreso_atencion.`Id_Destino`<>3 \t\n AND ingreso.Id_TipoAtencion>1 \n AND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 \n -- AND (Egreso=1 OR Egreso_H=1) \n AND (CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2)LIKE '%" + this.JTFNombre.getText() + "%' OR g_usuario.NoHistoria LIKE '%" + this.JTFNombre.getText() + "%' ) \nHAVING triage<4 and estadoSalidaAdministrativa=0 ORDER BY FechaE DESC, HoraE DESC";
            System.out.println("consulta 7--> " + sql);
        } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") && this.JTFNombre.getText().isEmpty()) {
            System.out.println("entra al condicional de cotorra");
            sql = "SELECT ingreso.Id,\ningreso.FechaIngreso,\ningreso.Id_TipoAtencion,\ningreso.Egreso,\ningreso.Egreso_H,\ng_usuario.NoHistoria,\ng_tipoatencion.Nbre AS TipoAtencion,\nIF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\nCONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\nh_atencion.Codigo_Dxp,\nf_empresacontxconvenio.Nbre AS Empresa,\nf_empresacontxconvenio.EsCapitado,\nIF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\nIF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE,IFNULL(h_triage.`Clasificacion`, 0) triage, \nIF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa,\nCONCAT(`personaIngresa`.`Apellido1`,' ',personaIngresa.`Apellido2`,' ', personaIngresa.`Nombre1`,' ',personaIngresa.`Nombre2`) AS UsuarioSistema\nFROM ingreso\nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona)\nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id\n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion\n\tAND h_egreso_atencion.Estado =1\nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)\nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)\nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id) LEFT JOIN `h_triage` ON (h_triage.`IdIngreso`= ingreso.Id) AND (h_triage.`Estado`=0)\nLEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1)\nINNER JOIN `g_usuario_sist` ON (`g_usuario_sist`.`Login` = `ingreso`.`UsuarioS`)\nINNER JOIN `g_persona` AS personaIngresa ON (`personaIngresa`.`Id` = `g_usuario_sist`.`Id_Persona`)\nWHERE   h_atencion.Codigo_Dxp<>''\n\tAND h_egreso_atencion.FechaSO IS NOT NULL\nAND h_egreso_atencion.`Id_Destino`<>3 AND ingreso.Id_TipoAtencion>1\n\tAND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0\nHAVING triage<4 AND estadoSalidaAdministrativa=0 ORDER BY FechaE DESC, HoraE DESC";
            System.out.println("consulta cotorra--> " + sql);
        } else if (Principal.informacionIps.getNombreIps().equals("LABORATORIO CLINICO VIVIAN RAMIREZ I.P.S. S.A.") || Principal.informacionIps.getNombreIps().equals("BIOMED VIDA IPS S.A.S")) {
            if (this.JTFNombre.getText().isEmpty()) {
                sql = "SELECT\n ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n ingreso.`DxIngreso`,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n ingreso.`FechaIngreso` as FechaE ,\n 0 , \nIF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI,IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraE, \nIF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \nFROM\n`g_usuario`\nINNER JOIN `g_persona`ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN `ingreso` ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)\nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nleft JOIN `f_liquidacion`    ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\nwhere  f_empresacontxconvenio.`Id` IN(49,8,100,119) and ingreso.`FechaIngreso`>='2023-08-24' and `f_liquidacion`.`Id_Ingreso` is null ;";
                System.out.println("consulta 10--> " + sql);
            } else {
                sql = "SELECT\n ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n ingreso.`DxIngreso`,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n ingreso.`FechaIngreso` as FechaE ,\n 0 , \nIF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI,IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraE, \nIF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \nFROM\n`g_usuario`\nINNER JOIN `g_persona`ON (`g_usuario`.`Id_persona` = `g_persona`.`Id`)\nINNER JOIN `ingreso` ON (`ingreso`.`Id_Usuario` = `g_persona`.`Id`)\nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nleft JOIN `f_liquidacion`    ON (`ingreso`.`Id` = `f_liquidacion`.`Id_Ingreso`)\nwhere  f_empresacontxconvenio.`Id` IN(49,8,100,119) and ingreso.`FechaIngreso`>='2023-08-24' and `f_liquidacion`.`Id_Ingreso` is null ;";
                System.out.println("consulta 11 ------> " + sql);
            }
        } else if (this.JTFNombre.getText().isEmpty()) {
            sql = "SELECT     ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n  IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n h_atencion.Codigo_Dxp  ,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n  IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\n IF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE,IFNULL(h_triage.`Clasificacion`, 0) triage, IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \nFROM ingreso     \nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id   \n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n\tAND h_egreso_atencion.Estado =1 \nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)     \nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id) LEFT JOIN `h_triage` ON (h_triage.`IdIngreso`= ingreso.Id) AND (h_triage.`Estado`=0) \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nWHERE   h_atencion.Codigo_Dxp<>'' \n\tAND h_egreso_atencion.FechaSO IS NOT NULL \n AND h_egreso_atencion.`Id_Destino`<>3 \tAND ingreso.Id_TipoAtencion>1 \n\tAND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 \n HAVING triage<4 and estadoSalidaAdministrativa=0 ORDER BY FechaE DESC, HoraE DESC";
            System.out.println("consulta 8--> " + sql);
        } else {
            sql = "SELECT     ingreso.Id     ,\n ingreso.FechaIngreso     ,\n ingreso.Id_TipoAtencion     ,\n ingreso.Egreso     ,\n ingreso.Egreso_H     ,\n g_usuario.NoHistoria     ,\n g_tipoatencion.Nbre AS TipoAtencion      ,\n  IF(f_liquidacion.Id IS NULL, 0,f_liquidacion.Id)  AS NID,\n CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS NombreUusario,\n h_atencion.Codigo_Dxp  ,\n f_empresacontxconvenio.Nbre AS Empresa,\n f_empresacontxconvenio.EsCapitado,\n  IF(h_egreso_atencion.FechaSO IS NULL, '',h_egreso_atencion.FechaSO)  AS FechaE,\n IF(h_egreso_atencion.HoraSO IS NULL, '',h_egreso_atencion.HoraSO)  AS HoraE,IFNULL(h_triage.`Clasificacion`, 0) triage , IF(ingreso.`HoraIngreso` IS NULL,'', ingreso.`HoraIngreso`) AS HoraI, IF( `ingreso_salida_administrativa`.`estado` IS  NULL, 0, 1) estadoSalidaAdministrativa \nFROM ingreso     \nINNER JOIN  g_usuario  ON (ingreso.Id_Usuario = g_usuario.Id_persona) \nINNER JOIN  f_empresacontxconvenio  ON (ingreso.Id_EmpresaContxConv = f_empresacontxconvenio.Id)\nLEFT JOIN f_liquidacion  ON f_liquidacion.Id_Ingreso= ingreso.Id AND f_liquidacion.Estado=0  \nLEFT JOIN h_egreso_atencion ON  h_egreso_atencion.Id_Ingreso =ingreso.Id   \n\tAND h_egreso_atencion.Id_Tipo =ingreso.Id_TipoAtencion \n\tAND h_egreso_atencion.Estado =1 \nINNER JOIN  g_tipoatencion  ON (ingreso.Id_TipoAtencion = g_tipoatencion.Id)     \nINNER JOIN g_persona ON (g_usuario.Id_persona= g_persona.Id)  \nINNER JOIN h_atencion ON (h_atencion.Id_Ingreso= ingreso.Id) LEFT JOIN `h_triage` ON (h_triage.`IdIngreso`= ingreso.Id) AND (h_triage.`Estado`=0) \n LEFT JOIN  `ingreso_salida_administrativa` ON (`ingreso_salida_administrativa`.`idIngreso` = `ingreso`.`Id`) AND(`ingreso_salida_administrativa`.`estado`=1) \nWHERE   h_atencion.Codigo_Dxp<>'' \n\tAND h_egreso_atencion.FechaSO IS NOT NULL \n AND h_egreso_atencion.`Id_Destino`<>3 \tAND ingreso.Id_TipoAtencion>1 \n\tAND f_liquidacion.Id IS NULL  AND ingreso.`Estado`=0 \nand (CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2)like '" + this.JTFNombre.getText() + "%' or g_usuario.NoHistoria like '" + this.JTFNombre.getText() + "%' ) \n HAVING triage<4 and estadoSalidaAdministrativa=0 ORDER BY FechaE DESC, HoraE DESC";
            System.out.println("consulta 9 ------> " + sql);
        }
        System.out.println(sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 2);
                this.xmt.mEstablecerTextEditor(this.JTDetalle, 4);
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString("FechaIngreso"), n, 0);
                    this.xmodelo.setValueAt(xrs.getString("NoHistoria"), n, 1);
                    this.xmodelo.setValueAt(xrs.getString("NombreUusario"), n, 2);
                    this.xmodelo.setValueAt(xrs.getString("TipoAtencion"), n, 3);
                    this.xmodelo.setValueAt(xrs.getString("Empresa"), n, 4);
                    this.xmodelo.setValueAt(xrs.getString("FechaE"), n, 5);
                    this.xmodelo.setValueAt(xrs.getString("HoraE"), n, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt("EsCapitado")), n, 7);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong("Id")), n, 8);
                    this.xmodelo.setValueAt(xrs.getString("HoraI"), n, 9);
                    if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA")) {
                        this.xmodelo.setValueAt(xrs.getString("UsuarioSistema"), n, 10);
                    }
                    this.JTDetalle.setDefaultRenderer(Object.class, new MiRender2());
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDPatologia.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JDPatologia$MiRender2.class */
    public static class MiRender2 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Integer.valueOf(table.getValueAt(row, 7).toString()).intValue() == 2) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }
}
