package com.genoma.plus.controller.gcuenta;

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
import Historia.JDOrdenNacidos;
import Historia.JDOrdenNacidosNovedad;
import Presupuesto.JIFBuscarDocPresup;
import Presupuesto.JIFFMovimiento;
import Presupuesto.JIFFMovimientoManual;
import Presupuesto.JIFF_InformesCuentasxPagarPTO;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.caja.JIFRecibosEgresos;
import com.genoma.plus.controller.comprabs.JIFContratoInformeCgr;
import com.genoma.plus.controller.contabilidad.JIFConsultarCuentasxPagarContaCart;
import com.genoma.plus.controller.facturacion.JPAEventoECastPacienteGasto;
import com.genoma.plus.controller.facturacion.JPI_FormularioAnexo2;
import com.genoma.plus.controller.general.JIFGEmpresaUnificacionUsuario;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JDRadicacion.class */
public class JDRadicacion extends JDialog {
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
    private String xCampo;
    private String xsql;
    private String idLiquidacion;
    private JIFConsultaInformesTerceros xJIFConsultaInformesTerceros;
    private JIFConsultar_LibroAuxiliar_RangoCuenta xJIFConsultar_LibroAuxiliar_RangoCuenta;
    private JIFSolicitudReembolsoCMV2 jIFSolicitudReembolsoCMV2;
    private Object[] dato;
    private JIFGestinDeFactura deFactura;
    Metodos metodos;
    Principal xjp;
    private ConsultasMySQL xconsultasbd;
    private JButton JBTAdicionar;
    private JButton JBTAdicionar1;
    private JComboBox JCBEProceso;
    private JDateChooser JDFechaEnt;
    private JDateChooser JDFechaRad;
    private JPanel JPICJuridico;
    private JPanel JPI_DatosRad;
    private JPanel JPI_DetalleRad;
    private JRadioButton JRBNo;
    private JRadioButton JRBSi;
    private JScrollPane JSPObsRadicacion;
    private JTextPane JTAObsRadicacion;
    private JTextField JTFNRadi;
    private JTextField JTFRutaSoporteRad;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel1;

    public JDRadicacion(Frame parent, boolean modal, Object xLlamador, String Nradicado, Date fechaEntrega, Date FechaRa, String ruta, String Observacion, Integer juridico, String etapa, String idLiquidacion) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xsql = "";
        this.idLiquidacion = "";
        this.deFactura = new JIFGestinDeFactura();
        this.metodos = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
        initComponents();
        this.buttonGroup1.add(this.JRBNo);
        this.buttonGroup1.add(this.JRBSi);
        this.idLiquidacion = idLiquidacion;
        cargarComponetes(Nradicado, fechaEntrega, FechaRa, ruta, Observacion, juridico, etapa);
        System.out.println(etapa);
    }

    public JDRadicacion(Frame parent, boolean modal, Object xLlamador, int xFila) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xsql = "";
        this.idLiquidacion = "";
        this.deFactura = new JIFGestinDeFactura();
        this.metodos = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
    }

    public JDRadicacion(Frame parent, boolean modal, Object xLlamador, String campo) {
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xsql = "";
        this.idLiquidacion = "";
        this.deFactura = new JIFGestinDeFactura();
        this.metodos = new Metodos();
        this.xconsultasbd = new ConsultasMySQL();
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPI_DetalleRad = new JPanel();
        this.JPI_DatosRad = new JPanel();
        this.JPICJuridico = new JPanel();
        this.JRBNo = new JRadioButton();
        this.JRBSi = new JRadioButton();
        this.JCBEProceso = new JComboBox();
        this.JBTAdicionar1 = new JButton();
        this.jPanel1 = new JPanel();
        this.JTFNRadi = new JTextField();
        this.JTFRutaSoporteRad = new JTextField();
        this.JBTAdicionar = new JButton();
        this.JSPObsRadicacion = new JScrollPane();
        this.JTAObsRadicacion = new JTextPane();
        this.JDFechaRad = new JDateChooser();
        this.JDFechaEnt = new JDateChooser();
        setDefaultCloseOperation(2);
        this.JPI_DetalleRad.setBorder(BorderFactory.createTitledBorder((Border) null, "RADICACION", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPI_DatosRad.setBorder(BorderFactory.createTitledBorder((Border) null, "ACTUALIZAR INFORMACIÓN ESTADO DE CUENTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPICJuridico.setBorder(BorderFactory.createTitledBorder((Border) null, "Cobro Jurídico", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setSelected(true);
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDRadicacion.1
            public void actionPerformed(ActionEvent evt) {
                JDRadicacion.this.JRBNoActionPerformed(evt);
            }
        });
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDRadicacion.2
            public void actionPerformed(ActionEvent evt) {
                JDRadicacion.this.JRBSiActionPerformed(evt);
            }
        });
        GroupLayout JPICJuridicoLayout = new GroupLayout(this.JPICJuridico);
        this.JPICJuridico.setLayout(JPICJuridicoLayout);
        JPICJuridicoLayout.setHorizontalGroup(JPICJuridicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICJuridicoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBNo, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JRBSi).addGap(20, 20, 20)));
        JPICJuridicoLayout.setVerticalGroup(JPICJuridicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICJuridicoLayout.createSequentialGroup().addContainerGap().addGroup(JPICJuridicoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNo).addComponent(this.JRBSi)).addGap(13, 13, 13)));
        this.JCBEProceso.setFont(new Font("Arial", 1, 12));
        this.JCBEProceso.setBorder(BorderFactory.createTitledBorder((Border) null, "Etapa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTAdicionar1.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar1.setText("Actualizar");
        this.JBTAdicionar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDRadicacion.3
            public void actionPerformed(ActionEvent evt) {
                JDRadicacion.this.JBTAdicionar1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_DatosRadLayout = new GroupLayout(this.JPI_DatosRad);
        this.JPI_DatosRad.setLayout(JPI_DatosRadLayout);
        JPI_DatosRadLayout.setHorizontalGroup(JPI_DatosRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRadLayout.createSequentialGroup().addContainerGap().addComponent(this.JPICJuridico, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBEProceso, -2, 453, -2).addGap(165, 165, 165).addComponent(this.JBTAdicionar1, -2, 185, -2).addContainerGap()));
        JPI_DatosRadLayout.setVerticalGroup(JPI_DatosRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosRadLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosRadLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_DatosRadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEProceso, -2, 50, -2).addComponent(this.JBTAdicionar1, -2, 47, -2)).addComponent(this.JPICJuridico, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.jPanel1.setBorder(BorderFactory.createEtchedBorder());
        this.JTFNRadi.setFont(new Font("Arial", 1, 12));
        this.JTFNRadi.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaSoporteRad.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoporteRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaSoporteRad.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JDRadicacion.4
            public void mouseClicked(MouseEvent evt) {
                JDRadicacion.this.JTFRutaSoporteRadMouseClicked(evt);
            }
        });
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Grabar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JDRadicacion.5
            public void actionPerformed(ActionEvent evt) {
                JDRadicacion.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JSPObsRadicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsRadicacion.setFont(new Font("Arial", 1, 12));
        this.JSPObsRadicacion.setViewportView(this.JTAObsRadicacion);
        this.JDFechaRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Radicado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaRad.setDateFormatString("dd/MM/yyyy");
        this.JDFechaRad.setFont(new Font("Arial", 1, 12));
        this.JDFechaEnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Entrega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEnt.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEnt.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPObsRadicacion, -2, 682, -2).addGap(103, 103, 103)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(140, 140, 140).addComponent(this.JDFechaEnt, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaRad, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addComponent(this.JBTAdicionar, -2, 159, -2).addGap(28, 28, 28)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFNRadi, -2, 125, -2).addGap(254, 254, 254).addComponent(this.JTFRutaSoporteRad, -2, 304, -2).addGap(289, 289, 289))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JBTAdicionar, -2, 144, -2).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaEnt, -2, 50, -2).addComponent(this.JDFechaRad, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPObsRadicacion, -2, 62, -2))).addContainerGap()).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFNRadi, -2, 50, -2).addComponent(this.JTFRutaSoporteRad, -2, 50, -2)).addContainerGap(84, 32767))));
        GroupLayout JPI_DetalleRadLayout = new GroupLayout(this.JPI_DetalleRad);
        this.JPI_DetalleRad.setLayout(JPI_DetalleRadLayout);
        JPI_DetalleRadLayout.setHorizontalGroup(JPI_DetalleRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRadLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DetalleRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -2, 975, -2).addComponent(this.JPI_DatosRad, -2, -1, -2)).addContainerGap(-1, 32767)));
        JPI_DetalleRadLayout.setVerticalGroup(JPI_DetalleRadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DetalleRadLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addGap(129, 129, 129).addComponent(this.JPI_DatosRad, -2, -1, -2).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 1009, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_DetalleRad, -2, -1, -2).addContainerGap(-1, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 426, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPI_DetalleRad, -1, -1, 32767).addContainerGap())));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionar1ActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoporteRadMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JTFNRadi.getText().isEmpty()) {
            int y = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (y == 0) {
                this.xsql = "update f_factura_evento set NRadicado='" + this.JTFNRadi.getText() + "', FechaEntrega='" + this.xmt.formatoAMD.format(this.JDFechaEnt.getDate()) + "', FechaRadicado='" + this.xmt.formatoAMD.format(this.JDFechaRad.getDate()) + "', ObservacionRad ='" + this.JTAObsRadicacion.getText() + "', UrlRadicado ='" + this.JTFRutaSoporteRad.getText() + "', FechaReporte ='" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "' where Id_Liquidacion=" + this.idLiquidacion + "";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                return;
            }
            return;
        }
        JOptionPane.showInputDialog(this, "En N° de Radicación debe ser nulo", "VERIFICAR", 1);
        this.JTFNRadi.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
    }

    private void cargarComponetes(String Nradicado, Date fechaEntrega, Date FechaRa, String ruta, String Observacion, Integer juridico, String etapa) {
        this.JTFNRadi.setText(Nradicado);
        this.JDFechaEnt.setDate(fechaEntrega);
        this.JDFechaRad.setDate(FechaRa);
        this.JTFRutaSoporteRad.setText(ruta);
        this.JTAObsRadicacion.setText(Observacion);
        if (juridico.intValue() == 0) {
            this.JRBNo.setSelected(true);
        } else {
            this.JRBSi.setSelected(true);
        }
        this.JCBEProceso.addItem(etapa);
    }

    private void mCasting(Object xLlamador) {
        if (xLlamador.getClass().getSimpleName().equals("JDOrdenNacidos")) {
            this.xJDOrdenNacidos = (JDOrdenNacidos) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JDOrdenNacidosNovedad")) {
            this.xJDOrdenNacidosNovedad = (JDOrdenNacidosNovedad) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("Principal")) {
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFFMovimiento")) {
            this.xJIFFMovimiento = (JIFFMovimiento) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFSolicitudContrato")) {
            this.xJIFSolicitudContrato = (JIFSolicitudContrato) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFFMovimientoManual")) {
            this.xJIFFMovimientoManual = (JIFFMovimientoManual) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFBuscarDocPresup")) {
            this.xJIFBuscarDocPresup = (JIFBuscarDocPresup) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFRadicacion")) {
            this.xJIFRadicacion = (JIFRadicacion) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFF_InformesCuentasxPagarPTO")) {
            this.xJIFF_InformesCuentasxPagarPTO = (JIFF_InformesCuentasxPagarPTO) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_Terceros")) {
            this.xJIFConsultar_LibroAuxiliar_Terceros = (JIFConsultar_LibroAuxiliar_Terceros) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFConsultarCuentasxP")) {
            this.xJIFConsultarCuentasxP = (JIFConsultarCuentasxP) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFConsultarCuentasxPagarContaCart")) {
            this.xJIFConsultarCuentasxPagarContaCart = (JIFConsultarCuentasxPagarContaCart) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIF_Consultar_Movimiento")) {
            this.xJIF_Consultar_Movimiento = (JIF_Consultar_Movimiento) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFGeneracionPagos_Directo")) {
            this.xJIFGeneracionPagos_Directo = (JIFGeneracionPagos_Directo) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFContratoInformeCgr")) {
            this.xJIFContratoInformeCgr = (JIFContratoInformeCgr) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JPI_FormularioAnexo2")) {
            this.formularioAnexo2 = (JPI_FormularioAnexo2) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_Fecha")) {
            this.consultar_LibroAuxiliar_Fecha = (JIFConsultar_LibroAuxiliar_Fecha) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFRecibosEgresos")) {
            this.recibosEgresos = (JIFRecibosEgresos) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFDocContable")) {
            this.docContable = (JIFDocContable) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JPAEventoECastPacienteGasto")) {
            this.jPAEventoECastPacienteGasto = (JPAEventoECastPacienteGasto) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFSolicitudReembolsoCM")) {
            this.jIFSolicitudReembolsoCM = (JIFSolicitudReembolsoCM) xLlamador;
            this.xLlamador = xLlamador;
            return;
        }
        if (xLlamador.getClass().getSimpleName().equals("JIFConsultaInformesTerceros")) {
            this.xJIFConsultaInformesTerceros = (JIFConsultaInformesTerceros) xLlamador;
            this.xLlamador = xLlamador;
        } else if (xLlamador.getClass().getSimpleName().equals("JIFConsultar_LibroAuxiliar_RangoCuenta")) {
            this.xJIFConsultar_LibroAuxiliar_RangoCuenta = (JIFConsultar_LibroAuxiliar_RangoCuenta) xLlamador;
            this.xLlamador = xLlamador;
        } else if (xLlamador.getClass().getSimpleName().equals("JIFSolicitudReembolsoCMV2")) {
            this.jIFSolicitudReembolsoCMV2 = (JIFSolicitudReembolsoCMV2) xLlamador;
            this.xLlamador = xLlamador;
        }
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

    private void mCrearModeloDatos() {
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JDRadicacion$MiRender2.class */
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
