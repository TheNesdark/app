package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import General.JDEnvioCorreoElectronico;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.general.InformacionIpsDAO;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.dao.impl.general.InformacionIpsDAOImpl;
import com.genoma.plus.dto.gcuenta.GCCTmpCartera;
import com.genoma.plus.dto.gcuenta.GCDetalleFacturaDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.gcuenta.Informe_Estado_de_CarteraDTO;
import com.genoma.plus.jpa.gcuenta.GCuentaDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import lombok.Generated;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIF_ConsolidadoCartera.class */
public class JIF_ConsolidadoCartera extends JInternalFrame {
    private DefaultTableModel xModelo;
    private DefaultTableModel xModeloDetalleFactura;
    private DefaultTableModel xModeloConsolidado;
    private GCuentaDAO xGCuenta;
    private Object[] xDato;
    private String[] xIdEmpresa;
    private WorkerSQL xWorkerSQL;
    private InformacionIpsDAO informacionIpsDAO;
    private List<GCCTmpCartera> listadoInformeCartera;
    private List<GCDetalleFacturaDTO> listInformacionDetalleFactura;
    private JButton JBTEnvioCorreo;
    private JButton JBTExportar;
    private JComboBox JCB_Empresa;
    private JCheckBox JCHFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPDatos;
    private JPanel JPI_Filtro;
    private JPanel JPI_FiltroFecha;
    private JPanel JPI_Forma;
    private JPanel JPI_FormaVisualizacion;
    private JPanel JPI_Utilidades;
    private JRadioButton JRBF_ConSaldo;
    private JRadioButton JRBF_SinSaldo;
    private JRadioButton JRBF_Todas;
    private JRadioButton JRB_360;
    private JRadioButton JRB_720;
    private JRadioButton JRB_AgrupadaRegimen;
    private JRadioButton JRB_CuentaCobro;
    private JRadioButton JRB_Factura;
    private ButtonGroup JRB_Filtro;
    private ButtonGroup JRB_FiltroFecha;
    private ButtonGroup JRB_FiltroSaldo;
    private JRadioButton JRB_Normal;
    private ButtonGroup JRB_Visualizacion;
    private JScrollPane JSPConsolidadoC;
    private JScrollPane JSPDetalle;
    private JScrollPane JSPDetalleFac;
    private JTabbedPane JTB_DPago;
    private JTable JTConsolidadoC;
    private JTable JTDetalle;
    private JTable JTDetalleFac;
    private JFormattedTextField JTFF_VGAceptada;
    private JFormattedTextField JTFF_VGRecuperable;
    private JFormattedTextField JTFF_VGlosa;
    private JFormattedTextField JTFF_VPagado;
    private JFormattedTextField JTFF_VSaldo;
    private JFormattedTextField JTFF_VServicio;
    private JTextField JTFRuta;
    private JTabbedPane JTP_Datos;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private String xIdEmpresaS = "";
    private double xValorSericio = 0.0d;
    private double xValorPagado = 0.0d;
    private double xValorGlosa = 0.0d;
    private double xValorGlosaA = 0.0d;
    private double xValorGlosaR = 0.0d;
    private double xValorSaldo = 0.0d;
    private int filtroVisualizacion = 0;
    private Boolean filtroFecha = true;

    @Generated
    public Boolean getFiltroFecha() {
        return this.filtroFecha;
    }

    @Generated
    public void setFiltroFecha(Boolean filtroFecha) {
        this.filtroFecha = filtroFecha;
    }

    public JIF_ConsolidadoCartera() {
        initComponents();
        mNuevo();
        springStart();
    }

    /* JADX WARN: Type inference failed for: r3v53, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v57, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JRB_Filtro = new ButtonGroup();
        this.JRB_Visualizacion = new ButtonGroup();
        this.JRB_FiltroFecha = new ButtonGroup();
        this.JRB_FiltroSaldo = new ButtonGroup();
        this.JPDatos = new JPanel();
        this.JPI_FiltroFecha = new JPanel();
        this.JRB_Factura = new JRadioButton();
        this.JRB_CuentaCobro = new JRadioButton();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCB_Empresa = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JTP_Datos = new JTabbedPane();
        this.JSPDetalle = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JSPDetalleFac = new JScrollPane();
        this.JTDetalleFac = new JTable();
        this.JSPConsolidadoC = new JScrollPane();
        this.JTConsolidadoC = new JTable();
        this.JTB_DPago = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JTFF_VServicio = new JFormattedTextField();
        this.JTFF_VPagado = new JFormattedTextField();
        this.JTFF_VGlosa = new JFormattedTextField();
        this.JTFF_VGAceptada = new JFormattedTextField();
        this.JTFF_VGRecuperable = new JFormattedTextField();
        this.JTFF_VSaldo = new JFormattedTextField();
        this.JPI_Filtro = new JPanel();
        this.JRBF_Todas = new JRadioButton();
        this.JRBF_ConSaldo = new JRadioButton();
        this.JRBF_SinSaldo = new JRadioButton();
        this.JPI_Utilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JPI_Forma = new JPanel();
        this.JRB_360 = new JRadioButton();
        this.JRB_720 = new JRadioButton();
        this.JPI_FormaVisualizacion = new JPanel();
        this.JRB_Normal = new JRadioButton();
        this.JRB_AgrupadaRegimen = new JRadioButton();
        this.JBTEnvioCorreo = new JButton("<html><center><b><u>E</u>nviar Resultado</b></html>");
        setClosable(true);
        setIconifiable(true);
        setTitle("CONSOLIDADO DE CARTERA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifconsolidadoCartera");
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPDatos.setPreferredSize(new Dimension(1330, 92));
        this.JPI_FiltroFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Filtro en Fecha", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JRB_FiltroFecha.add(this.JRB_Factura);
        this.JRB_Factura.setFont(new Font("Arial", 1, 12));
        this.JRB_Factura.setForeground(Color.blue);
        this.JRB_Factura.setSelected(true);
        this.JRB_Factura.setText("Factura");
        this.JRB_Factura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.1
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JRB_FacturaActionPerformed(evt);
            }
        });
        this.JRB_FiltroFecha.add(this.JRB_CuentaCobro);
        this.JRB_CuentaCobro.setFont(new Font("Arial", 1, 12));
        this.JRB_CuentaCobro.setForeground(Color.blue);
        this.JRB_CuentaCobro.setText("Cuenta Cobro");
        this.JRB_CuentaCobro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.2
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JRB_CuentaCobroActionPerformed(evt);
            }
        });
        GroupLayout JPI_FiltroFechaLayout = new GroupLayout(this.JPI_FiltroFecha);
        this.JPI_FiltroFecha.setLayout(JPI_FiltroFechaLayout);
        JPI_FiltroFechaLayout.setHorizontalGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroFechaLayout.createSequentialGroup().addComponent(this.JRB_Factura).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRB_CuentaCobro).addContainerGap(-1, 32767)));
        JPI_FiltroFechaLayout.setVerticalGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroFechaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_FiltroFechaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Factura).addComponent(this.JRB_CuentaCobro)).addContainerGap(15, 32767)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JCB_Empresa.setFont(new Font("Arial", 1, 12));
        this.JCB_Empresa.setToolTipText("");
        this.JCB_Empresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Empresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.3
            public void itemStateChanged(ItemEvent evt) {
                JIF_ConsolidadoCartera.this.JCB_EmpresaItemStateChanged(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setForeground(Color.blue);
        this.JCHFiltro.setText("Aplicar Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.4
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_FiltroFecha, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaI, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JDFechaF, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCB_Empresa, -2, 502, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltro).addContainerGap(-1, 32767)));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDatosLayout.createSequentialGroup().addGap(0, 5, 32767).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, 56, -2).addComponent(this.JDFechaI, -2, 56, -2)).addGroup(JPDatosLayout.createSequentialGroup().addGap(3, 3, 3).addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCHFiltro).addComponent(this.JCB_Empresa, -2, 50, -2))))).addComponent(this.JPI_FiltroFecha, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap(9, 32767)));
        this.JTP_Datos.setForeground(Color.red);
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalle.setBorder((Border) null);
        this.JSPDetalle.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JSPDetalle.setViewportView(this.JTDetalle);
        this.JTP_Datos.addTab("CONSOLIDADO POR CONVENIO", this.JSPDetalle);
        this.JSPDetalleFac.setBorder((Border) null);
        this.JSPDetalleFac.setPreferredSize(new Dimension(1330, 426));
        this.JTDetalleFac.setFont(new Font("Arial", 1, 12));
        this.JTDetalleFac.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleFac.setSelectionBackground(Color.white);
        this.JTDetalleFac.setSelectionForeground(Color.red);
        this.JSPDetalleFac.setViewportView(this.JTDetalleFac);
        this.JTP_Datos.addTab("DETALLE POR FACTURA", this.JSPDetalleFac);
        this.JSPConsolidadoC.setBorder((Border) null);
        this.JSPConsolidadoC.setPreferredSize(new Dimension(1330, 426));
        this.JTConsolidadoC.setFont(new Font("Arial", 1, 12));
        this.JTConsolidadoC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTConsolidadoC.setSelectionBackground(Color.white);
        this.JTConsolidadoC.setSelectionForeground(Color.red);
        this.JSPConsolidadoC.setViewportView(this.JTConsolidadoC);
        this.JTP_Datos.addTab("CONSOLIDADO", this.JSPConsolidadoC);
        this.JTB_DPago.setForeground(new Color(0, 103, 0));
        this.JTB_DPago.setFont(new Font("Arial", 1, 14));
        this.JTFF_VServicio.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Servicio", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VServicio.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_VServicio.setHorizontalAlignment(4);
        this.JTFF_VServicio.setFont(new Font("Arial", 1, 14));
        this.JTFF_VServicio.setValue(new Long(0L));
        this.JTFF_VPagado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Pagado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VPagado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_VPagado.setHorizontalAlignment(4);
        this.JTFF_VPagado.setFont(new Font("Arial", 1, 14));
        this.JTFF_VPagado.setValue(new Long(0L));
        this.JTFF_VGlosa.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Glosa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VGlosa.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_VGlosa.setHorizontalAlignment(4);
        this.JTFF_VGlosa.setFont(new Font("Arial", 1, 14));
        this.JTFF_VGlosa.setValue(new Long(0L));
        this.JTFF_VGlosa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.5
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JTFF_VGlosaActionPerformed(evt);
            }
        });
        this.JTFF_VGAceptada.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor GAceptada", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VGAceptada.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_VGAceptada.setHorizontalAlignment(4);
        this.JTFF_VGAceptada.setFont(new Font("Arial", 1, 14));
        this.JTFF_VGAceptada.setValue(new Long(0L));
        this.JTFF_VGRecuperable.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor GRecuperable", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VGRecuperable.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_VGRecuperable.setHorizontalAlignment(4);
        this.JTFF_VGRecuperable.setFont(new Font("Arial", 1, 14));
        this.JTFF_VGRecuperable.setValue(new Long(0L));
        this.JTFF_VSaldo.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Saldo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VSaldo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFF_VSaldo.setHorizontalAlignment(4);
        this.JTFF_VSaldo.setFont(new Font("Arial", 1, 14));
        this.JTFF_VSaldo.setValue(new Long(0L));
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JRB_FiltroSaldo.add(this.JRBF_Todas);
        this.JRBF_Todas.setFont(new Font("Arial", 1, 12));
        this.JRBF_Todas.setText("Todas");
        this.JRBF_Todas.setToolTipText("");
        this.JRBF_Todas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.6
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JRBF_TodasActionPerformed(evt);
            }
        });
        this.JRB_FiltroSaldo.add(this.JRBF_ConSaldo);
        this.JRBF_ConSaldo.setFont(new Font("Arial", 1, 12));
        this.JRBF_ConSaldo.setSelected(true);
        this.JRBF_ConSaldo.setText("Con Saldo");
        this.JRBF_ConSaldo.setToolTipText("");
        this.JRB_FiltroSaldo.add(this.JRBF_SinSaldo);
        this.JRBF_SinSaldo.setFont(new Font("Arial", 1, 12));
        this.JRBF_SinSaldo.setText("Sin Saldo");
        this.JRBF_SinSaldo.setToolTipText("");
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBF_Todas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBF_ConSaldo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBF_SinSaldo).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBF_Todas).addComponent(this.JRBF_ConSaldo).addComponent(this.JRBF_SinSaldo)).addGap(0, 0, 32767)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFF_VServicio, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_VPagado, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_VGlosa, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_VGAceptada, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_VGRecuperable, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_VSaldo, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Filtro, -2, -1, -2).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(13, 13, 13).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFF_VServicio, -2, 50, -2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFF_VPagado, -2, 50, -2).addComponent(this.JTFF_VGlosa, -2, 50, -2).addComponent(this.JTFF_VGAceptada, -2, 50, -2).addComponent(this.JTFF_VGRecuperable, -2, 50, -2).addComponent(this.JTFF_VSaldo, -2, 50, -2)))).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Filtro, -2, -1, -2))).addContainerGap()));
        this.JTB_DPago.addTab("TOTALES", this.jPanel2);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.7
            public void mouseClicked(MouseEvent evt) {
                JIF_ConsolidadoCartera.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.8
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JPI_Forma.setBorder(BorderFactory.createTitledBorder((Border) null, "FORMA", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JRB_Filtro.add(this.JRB_360);
        this.JRB_360.setFont(new Font("Arial", 1, 12));
        this.JRB_360.setText("360");
        this.JRB_360.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.9
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JRB_360ActionPerformed(evt);
            }
        });
        this.JRB_Filtro.add(this.JRB_720);
        this.JRB_720.setFont(new Font("Arial", 1, 12));
        this.JRB_720.setText("720");
        this.JRB_720.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.10
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JRB_720ActionPerformed(evt);
            }
        });
        GroupLayout JPI_FormaLayout = new GroupLayout(this.JPI_Forma);
        this.JPI_Forma.setLayout(JPI_FormaLayout);
        JPI_FormaLayout.setHorizontalGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_360).addGap(18, 18, 18).addComponent(this.JRB_720).addContainerGap(-1, 32767)));
        JPI_FormaLayout.setVerticalGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaLayout.createSequentialGroup().addGroup(JPI_FormaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_360).addComponent(this.JRB_720)).addGap(0, 0, 32767)));
        this.JPI_FormaVisualizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "VISUALIZACION", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JRB_Visualizacion.add(this.JRB_Normal);
        this.JRB_Normal.setFont(new Font("Arial", 1, 12));
        this.JRB_Normal.setSelected(true);
        this.JRB_Normal.setText("Normal");
        this.JRB_Normal.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.11
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JRB_NormalActionPerformed(evt);
            }
        });
        this.JRB_Visualizacion.add(this.JRB_AgrupadaRegimen);
        this.JRB_AgrupadaRegimen.setFont(new Font("Arial", 1, 12));
        this.JRB_AgrupadaRegimen.setText("Agrupada Régimen");
        this.JRB_AgrupadaRegimen.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.12
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JRB_AgrupadaRegimenActionPerformed(evt);
            }
        });
        GroupLayout JPI_FormaVisualizacionLayout = new GroupLayout(this.JPI_FormaVisualizacion);
        this.JPI_FormaVisualizacion.setLayout(JPI_FormaVisualizacionLayout);
        JPI_FormaVisualizacionLayout.setHorizontalGroup(JPI_FormaVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaVisualizacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRB_Normal).addGap(18, 18, 18).addComponent(this.JRB_AgrupadaRegimen).addContainerGap(-1, 32767)));
        JPI_FormaVisualizacionLayout.setVerticalGroup(JPI_FormaVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FormaVisualizacionLayout.createSequentialGroup().addGroup(JPI_FormaVisualizacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRB_Normal).addComponent(this.JRB_AgrupadaRegimen)).addGap(0, 0, 32767)));
        this.JBTEnvioCorreo.setFont(new Font("Arial", 1, 12));
        this.JBTEnvioCorreo.setIcon(new ImageIcon(getClass().getResource("/Imagenes/correo_2.png")));
        this.JBTEnvioCorreo.setText("Enviar estado cartera");
        this.JBTEnvioCorreo.setToolTipText("");
        this.JBTEnvioCorreo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.13
            public void actionPerformed(ActionEvent evt) {
                JIF_ConsolidadoCartera.this.JBTEnvioCorreoActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 322, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 178, -2).addGap(24, 24, 24).addComponent(this.JPI_Forma, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPI_FormaVisualizacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, 32767).addComponent(this.JBTEnvioCorreo, -2, 201, -2)));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_UtilidadesLayout.createSequentialGroup().addContainerGap(16, 32767).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTEnvioCorreo, -2, 50, -2).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTExportar, -2, 50, -2).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFRuta, -1, 50, 32767).addComponent(this.JPI_FormaVisualizacion, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JPI_Forma, GroupLayout.Alignment.TRAILING, -1, -1, 32767)))).addGap(15, 15, 15)));
        this.JTB_DPago.addTab("UTILIDADES Y/O EXPORTAR", this.JPI_Utilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTB_DPago, GroupLayout.Alignment.TRAILING).addComponent(this.JPDatos, -1, 1178, 32767).addComponent(this.JTP_Datos, -2, 0, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, 94, -2).addGap(10, 10, 10).addComponent(this.JTP_Datos, -2, 420, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTB_DPago, -2, 114, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_VGlosaActionPerformed(ActionEvent evt) {
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
        if (!this.JTFRuta.getText().isEmpty()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la información", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.JTP_Datos.getSelectedIndex() == 0) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalle, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                } else if (this.JTP_Datos.getSelectedIndex() == 1) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleFac, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                } else if (this.JTP_Datos.getSelectedIndex() == 2) {
                    this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTConsolidadoC, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            List<GCGenericoDTO> list = this.xGCuenta.listadoEmpresaCartera(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
            if (list.size() > 0) {
                this.xIdEmpresa = new String[list.size()];
                for (int x = 0; x < list.size(); x++) {
                    this.xIdEmpresa[x] = String.valueOf(list.get(x).getId());
                    this.JCB_Empresa.addItem(list.get(x).getNombre());
                }
                this.xIdEmpresaS = this.xIdEmpresa[this.JCB_Empresa.getSelectedIndex()];
                return;
            }
            return;
        }
        this.xIdEmpresaS = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EmpresaItemStateChanged(ItemEvent evt) {
        if (this.JCB_Empresa.getSelectedIndex() != -1 && this.JCHFiltro.isSelected()) {
            this.xIdEmpresaS = this.xIdEmpresa[this.JCB_Empresa.getSelectedIndex()];
        } else {
            this.xIdEmpresaS = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_360ActionPerformed(ActionEvent evt) {
        mCrearModeloConsolidadoC_360();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_720ActionPerformed(ActionEvent evt) {
        mCrearModeloConsolidadoC_720();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_NormalActionPerformed(ActionEvent evt) {
        this.filtroVisualizacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_AgrupadaRegimenActionPerformed(ActionEvent evt) {
        this.filtroVisualizacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_FacturaActionPerformed(ActionEvent evt) {
        setFiltroFecha(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRB_CuentaCobroActionPerformed(ActionEvent evt) {
        setFiltroFecha(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBF_TodasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTEnvioCorreoActionPerformed(ActionEvent evt) {
        if (this.JTP_Datos.getSelectedIndex() == 1) {
            if (this.JTDetalleFac.getRowCount() > 0) {
                imprimirDetalle(false);
                String cuerpo = "Adjunto Archivo";
                if (Principal.informacionIps.getIdentificacion().equals("900304530")) {
                    cuerpo = "<p>Buenas,<br /><br />Cordial saludo,<br /><br />Adjunto estado de cartera a la fecha, si dichas facturas ya est&aacute;n canceladas hacer caso omiso y compartir soportes de pago al correo <strong>cartera@bienestarsalud.com.co</strong> Quedo atenta a cualquier inquietud.<br /><br /><br /><strong>&Aacute;rea de cartera</strong><br /><strong>3041083306</strong></p>";
                }
                JDEnvioCorreoElectronico xifenviocorreo = new JDEnvioCorreoElectronico(null, true, "GC_Cartera_Estado_Facturas.pdf", this.JTDetalleFac.getValueAt(0, 27).toString(), cuerpo, "Estado de Cartera");
                xifenviocorreo.setVisible(true);
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe búsqueda activa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xGCuenta = (GCuentaDAOImpl) classPathXmlApplicationContext.getBean("gCuentaDAOImpl");
        this.informacionIpsDAO = (InformacionIpsDAOImpl) classPathXmlApplicationContext.getBean("informacionIpsDAOImpl");
    }

    private void mCrearModeloConsolidadoCartera() {
        this.xModelo = new DefaultTableModel((Object[][]) null, new String[]{"Nit", "Tercero", "IdConvenio", "Empresa Convenio", "Total Servicio", "Total Descuento", "Total C/Moderadora", "Total Copago", "V/Total", "V/Glosa", "V/Aceptado", "V/Recuperable", "v/Pagado", "Saldo", "Regimen"}) { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.14
            Class[] types = {String.class, String.class, Long.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setAutoResizeMode(0);
        this.JTDetalle.doLayout();
        this.JTDetalle.setModel(this.xModelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(250);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(13).setPreferredWidth(120);
        this.JTDetalle.getColumnModel().getColumn(14).setPreferredWidth(250);
    }

    private void mCrearModeloConsolidadoC_360() {
        this.xModeloConsolidado = new DefaultTableModel((Object[][]) null, new String[]{"Nit", "Tercero", "Por Radicar", "En Proceso", "1_30", "31_60", "61_90", "91_180", "181_360", "361 en Adelante", "TOTAL", "Regimen"}) { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.15
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTConsolidadoC;
        JTable jTable2 = this.JTConsolidadoC;
        jTable.setAutoResizeMode(0);
        this.JTConsolidadoC.doLayout();
        this.JTConsolidadoC.setModel(this.xModeloConsolidado);
        this.JTConsolidadoC.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTConsolidadoC.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTConsolidadoC.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(11).setPreferredWidth(200);
    }

    private void mCrearModeloConsolidadoC_720() {
        this.xModeloConsolidado = new DefaultTableModel((Object[][]) null, new String[]{"Nit", "Tercero", "Por Radicar", "En Proceso", "1_30", "31_60", "61_90", "91_180", "181_360", "361_720", "720 en Adelante", "TOTAL", "Regimen"}) { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.16
            Class[] types = {String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTConsolidadoC;
        JTable jTable2 = this.JTConsolidadoC;
        jTable.setAutoResizeMode(0);
        this.JTConsolidadoC.doLayout();
        this.JTConsolidadoC.setModel(this.xModeloConsolidado);
        this.JTConsolidadoC.getColumnModel().getColumn(0).setPreferredWidth(80);
        this.JTConsolidadoC.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTConsolidadoC.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTConsolidadoC.getColumnModel().getColumn(12).setPreferredWidth(200);
    }

    private void mCrearModeloDetalleFactura() {
        this.xModeloDetalleFactura = new DefaultTableModel((Object[][]) null, new String[]{"Nit", "Empresa", "Convenio", "Fecha", "N° Factura", "Servicio", "Total Servicio", "Total Descuento", "Total C/Moderadora", "Total Copago", "V/Total", "V/Glosa", "V/Aceptado", "V/Recuperable", "V/Pagado", "Saldo", "Radicado", "N° Radicado", "FEntrega", "FRadicado", "FUPago", "NDiasC", "NCuentaCobro", "UrlRadicado", "EtapaProceso", "Regimen", "PeriodoContable", "Correo"}) { // from class: com.genoma.plus.controller.gcuenta.JIF_ConsolidadoCartera.17
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleFac.setAutoResizeMode(0);
        this.JTDetalleFac.doLayout();
        this.JTDetalleFac.setModel(this.xModeloDetalleFactura);
        this.JTDetalleFac.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleFac.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleFac.getColumnModel().getColumn(2).setPreferredWidth(300);
        this.JTDetalleFac.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleFac.getColumnModel().getColumn(4).setPreferredWidth(300);
        this.JTDetalleFac.getColumnModel().getColumn(5).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(6).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(7).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(8).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(9).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(11).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(12).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(13).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(14).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(15).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(16).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(17).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(18).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(19).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(20).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(21).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(22).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(23).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(24).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(25).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(26).setPreferredWidth(120);
        this.JTDetalleFac.getColumnModel().getColumn(27).setPreferredWidth(120);
    }

    private void mCargarConsolidado() {
        List<Object[]> list = this.xGCuenta.listadoConsolidadoCartera(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdEmpresaS, getFiltroFecha());
        mCrearModeloConsolidadoCartera();
        this.xValorSericio = 0.0d;
        this.xValorPagado = 0.0d;
        this.xValorGlosa = 0.0d;
        this.xValorGlosaA = 0.0d;
        this.xValorGlosaR = 0.0d;
        this.xValorSaldo = 0.0d;
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 1);
        this.xmt.mEstablecerTextEditor(this.JTDetalle, 3);
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            for (int y = 0; y < this.JTDetalle.getColumnCount(); y++) {
                this.xModelo.setValueAt(list.get(x)[y], x, y);
            }
            this.xValorSericio += Double.valueOf(list.get(x)[4].toString()).doubleValue();
            this.xValorPagado += Double.valueOf(list.get(x)[12].toString()).doubleValue();
            this.xValorGlosa += Double.valueOf(list.get(x)[9].toString()).doubleValue();
            this.xValorGlosaA += Double.valueOf(list.get(x)[10].toString()).doubleValue();
            this.xValorGlosaR += Double.valueOf(list.get(x)[11].toString()).doubleValue();
            this.xValorSaldo += Double.valueOf(list.get(x)[13].toString()).doubleValue();
        }
        this.JTFF_VServicio.setValue(Double.valueOf(this.xValorSericio));
        this.JTFF_VPagado.setValue(Double.valueOf(this.xValorPagado));
        this.JTFF_VGlosa.setValue(Double.valueOf(this.xValorGlosa));
        this.JTFF_VGAceptada.setValue(Double.valueOf(this.xValorGlosaA));
        this.JTFF_VGRecuperable.setValue(Double.valueOf(this.xValorGlosaR));
        this.JTFF_VSaldo.setValue(Double.valueOf(this.xValorSaldo));
    }

    private void mCargarDetalleFactura() {
        int condicionSaldo;
        if (this.JRBF_Todas.isSelected()) {
            condicionSaldo = 0;
        } else if (this.JRBF_ConSaldo.isSelected()) {
            condicionSaldo = 1;
        } else {
            condicionSaldo = 2;
        }
        List<Object[]> list = this.xGCuenta.listadoDetalleFacturaCartera(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdEmpresaS, getFiltroFecha(), condicionSaldo);
        this.listInformacionDetalleFactura = new ArrayList();
        mCrearModeloDetalleFactura();
        this.xValorSericio = 0.0d;
        this.xValorPagado = 0.0d;
        this.xValorGlosa = 0.0d;
        this.xValorGlosaA = 0.0d;
        this.xValorGlosaR = 0.0d;
        this.xValorSaldo = 0.0d;
        this.xmt.mEstablecerTextEditor(this.JTDetalleFac, 1);
        this.xmt.mEstablecerTextEditor(this.JTDetalleFac, 2);
        for (int x = 0; x < list.size(); x++) {
            GCDetalleFacturaDTO dTO = GCDetalleFacturaDTO.builder().diasCartera(Integer.valueOf(list.get(x)[21].toString())).fechaFactura(list.get(x)[3].toString()).nombreServicio(list.get(x)[5].toString()).numeroFactura(list.get(x)[4].toString()).totalAceptado(Double.valueOf(list.get(x)[12].toString())).totalFactura(Double.valueOf(list.get(x)[10].toString())).totalGlosa(Double.valueOf(list.get(x)[11].toString())).totalPagado(Double.valueOf(list.get(x)[14].toString())).totalSaldo(Double.valueOf(list.get(x)[15].toString())).build();
            this.listInformacionDetalleFactura.add(dTO);
            this.xModeloDetalleFactura.addRow(this.xDato);
            for (int y = 0; y < this.JTDetalleFac.getColumnCount(); y++) {
                this.xModeloDetalleFactura.setValueAt(list.get(x)[y], x, y);
            }
            this.xValorSericio += Double.valueOf(list.get(x)[6].toString()).doubleValue();
            this.xValorPagado += Double.valueOf(list.get(x)[14].toString()).doubleValue();
            this.xValorGlosa += Double.valueOf(list.get(x)[11].toString()).doubleValue();
            this.xValorGlosaA += Double.valueOf(list.get(x)[12].toString()).doubleValue();
            this.xValorGlosaR += Double.valueOf(list.get(x)[13].toString()).doubleValue();
            this.xValorSaldo += Double.valueOf(list.get(x)[15].toString()).doubleValue();
        }
        this.JTFF_VServicio.setValue(Double.valueOf(this.xValorSericio));
        this.JTFF_VPagado.setValue(Double.valueOf(this.xValorPagado));
        this.JTFF_VGlosa.setValue(Double.valueOf(this.xValorGlosa));
        this.JTFF_VGAceptada.setValue(Double.valueOf(this.xValorGlosaA));
        this.JTFF_VGRecuperable.setValue(Double.valueOf(this.xValorGlosaR));
        this.JTFF_VSaldo.setValue(Double.valueOf(this.xValorSaldo));
    }

    private void mCargarConsolidadoCartera() {
        this.xGCuenta.listadoConsolidadoCarteraTmp(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xIdEmpresaS, getFiltroFecha());
        this.listadoInformeCartera = this.xGCuenta.listadoConsolidadoCarteraC(Integer.valueOf(this.filtroVisualizacion));
        if (this.JRB_360.isSelected()) {
            mCrearModeloConsolidadoC_360();
        } else {
            mCrearModeloConsolidadoC_720();
        }
        double xValor1 = 0.0d;
        double xValor2 = 0.0d;
        double xValor3 = 0.0d;
        double xValor4 = 0.0d;
        double xValor5 = 0.0d;
        double xValor6 = 0.0d;
        double xValor7 = 0.0d;
        double xValor8 = 0.0d;
        double xValor9 = 0.0d;
        double xValor10 = 0.0d;
        double xValor11 = 0.0d;
        int xNFila = 0;
        this.xmt.mEstablecerTextEditor(this.JTConsolidadoC, 1);
        for (int x = 0; x < this.listadoInformeCartera.size(); x++) {
            this.xModeloConsolidado.addRow(this.xDato);
            this.xModeloConsolidado.setValueAt(this.listadoInformeCartera.get(x).getIdTercero(), x, 0);
            this.xModeloConsolidado.setValueAt(this.listadoInformeCartera.get(x).getNombreEmpresa(), x, 1);
            this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValorPorRadicar()), x, 2);
            this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValorEnProceso()), x, 3);
            this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValor1_30Dias()), x, 4);
            this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValor31_60Dias()), x, 5);
            this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValor61_90Dias()), x, 6);
            this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValor91_180Dias()), x, 7);
            this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValor181_360Dias()), x, 8);
            if (this.JRB_360.isSelected()) {
                this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValor360Dias_Adelante()), x, 9);
                this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValorTotal()), x, 10);
                this.xModeloConsolidado.setValueAt(this.listadoInformeCartera.get(x).getNombreRegimen(), x, 11);
            } else {
                this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValor361_720Dias()), x, 9);
                this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValor720Dias_Adelante()), x, 10);
                this.xModeloConsolidado.setValueAt(Double.valueOf(this.listadoInformeCartera.get(x).getValorTotal()), x, 11);
                this.xModeloConsolidado.setValueAt(this.listadoInformeCartera.get(x).getNombreRegimen(), x, 12);
            }
            xValor1 += this.listadoInformeCartera.get(x).getValorPorRadicar();
            xValor2 += this.listadoInformeCartera.get(x).getValorEnProceso();
            xValor3 += this.listadoInformeCartera.get(x).getValor1_30Dias();
            xValor4 += this.listadoInformeCartera.get(x).getValor31_60Dias();
            xValor5 += this.listadoInformeCartera.get(x).getValor61_90Dias();
            xValor6 += this.listadoInformeCartera.get(x).getValor91_180Dias();
            xValor7 += this.listadoInformeCartera.get(x).getValor181_360Dias();
            xValor8 += this.listadoInformeCartera.get(x).getValor361_720Dias();
            xValor9 += this.listadoInformeCartera.get(x).getValor360Dias_Adelante();
            xValor10 += this.listadoInformeCartera.get(x).getValor720Dias_Adelante();
            xValor11 += this.listadoInformeCartera.get(x).getValorTotal();
            xNFila++;
        }
        if (this.JTConsolidadoC.getRowCount() != -1) {
            this.xModeloConsolidado.addRow(this.xDato);
            this.xModeloConsolidado.setValueAt(0, xNFila, 0);
            this.xModeloConsolidado.setValueAt("TOTAL", xNFila, 1);
            this.xModeloConsolidado.setValueAt(Double.valueOf(xValor1), xNFila, 2);
            this.xModeloConsolidado.setValueAt(Double.valueOf(xValor2), xNFila, 3);
            this.xModeloConsolidado.setValueAt(Double.valueOf(xValor3), xNFila, 4);
            this.xModeloConsolidado.setValueAt(Double.valueOf(xValor4), xNFila, 5);
            this.xModeloConsolidado.setValueAt(Double.valueOf(xValor5), xNFila, 6);
            this.xModeloConsolidado.setValueAt(Double.valueOf(xValor6), xNFila, 7);
            this.xModeloConsolidado.setValueAt(Double.valueOf(xValor7), xNFila, 8);
            if (this.JRB_360.isSelected()) {
                this.xModeloConsolidado.setValueAt(Double.valueOf(xValor9), xNFila, 9);
                this.xModeloConsolidado.setValueAt(Double.valueOf(xValor11), xNFila, 10);
            } else {
                this.xModeloConsolidado.setValueAt(Double.valueOf(xValor9), xNFila, 9);
                this.xModeloConsolidado.setValueAt(Double.valueOf(xValor10), xNFila, 10);
                this.xModeloConsolidado.setValueAt(Double.valueOf(xValor11), xNFila, 11);
            }
        }
    }

    public void mBuscar() {
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando la Informacion...", this);
        this.xWorkerSQL.execute();
    }

    public void mBuscarD() {
        switch (this.JTP_Datos.getSelectedIndex()) {
            case 0:
                mCargarConsolidado();
                break;
            case 1:
                mCargarDetalleFactura();
                break;
            case 2:
                mCargarConsolidadoCartera();
                break;
        }
    }

    public void mImprimir() {
        if (this.JTP_Datos.getSelectedIndex() == 2) {
            if (this.JTConsolidadoC.getRowCount() != -1) {
                mImprimirD(true);
            }
        } else if (this.JTP_Datos.getSelectedIndex() == 1 && this.JTDetalleFac.getRowCount() != -1) {
            mImprimirD(true);
        }
    }

    private void imprimirDetalle(Boolean visualizar) {
        Informe_Estado_de_CarteraDTO informe_Estado_de_CarteraDTO = new Informe_Estado_de_CarteraDTO();
        informe_Estado_de_CarteraDTO.setTituloReporte("INFORME DE CARTERA");
        informe_Estado_de_CarteraDTO.setInformacionIps(this.informacionIpsDAO.informacionIps());
        informe_Estado_de_CarteraDTO.setInformacionDetalleCartera(this.listadoInformeCartera);
        informe_Estado_de_CarteraDTO.setInformacionDetalleFactura(this.listInformacionDetalleFactura);
        informe_Estado_de_CarteraDTO.setRutaSubReportes(this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra());
        informe_Estado_de_CarteraDTO.setFechaCorte(this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        if (this.JCB_Empresa.getSelectedIndex() != -1) {
            informe_Estado_de_CarteraDTO.setNombreEmpresa(this.JCB_Empresa.getSelectedItem().toString());
        }
        informe_Estado_de_CarteraDTO.setUsuarioGeneradorInforme(Principal.usuarioSistemaDTO.getNombreUsuario());
        if (this.JTP_Datos.getSelectedIndex() == 2) {
            if (this.JRB_360.isSelected()) {
                if (this.JRB_Normal.isSelected()) {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "GC_Cartera_por_EdadesDTO", informe_Estado_de_CarteraDTO, "GC_Cartera_por_EdadesDTO", visualizar.booleanValue());
                    return;
                } else {
                    this.xmt.GenerarPDF(this.xmt.getRutaRep() + "GC_Cartera_por_Edades_AgrupadoRegimenDTO", informe_Estado_de_CarteraDTO, "GC_Cartera_por_Edades_AgrupadoRegimenDTO", visualizar.booleanValue());
                    return;
                }
            }
            if (this.JRB_Normal.isSelected()) {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "GC_Cartera_por_Edades_720DTO", informe_Estado_de_CarteraDTO, "GC_Cartera_por_Edades_720DTO", visualizar.booleanValue());
                return;
            } else {
                this.xmt.GenerarPDF(this.xmt.getRutaRep() + "GC_Cartera_por_Edades_AgrupadoRegimen_720DTO", informe_Estado_de_CarteraDTO, "GC_Cartera_por_Edades_AgrupadoRegimen_720DTO", visualizar.booleanValue());
                return;
            }
        }
        if (this.JTP_Datos.getSelectedIndex() == 1) {
            informe_Estado_de_CarteraDTO.setTituloReporte("ESTADO DE CARTERA");
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "GC_Cartera_Estado_Facturas", informe_Estado_de_CarteraDTO, "GC_Cartera_Estado_Facturas", visualizar.booleanValue());
        }
    }

    private void mImprimirD(Boolean visualizar) {
        imprimirDetalle(visualizar);
    }

    public void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        mCrearModeloConsolidadoCartera();
        mCrearModeloDetalleFactura();
        mCrearModeloConsolidadoC_360();
        this.JCB_Empresa.removeAllItems();
        this.JRB_360.setSelected(true);
        this.filtroVisualizacion = 0;
        this.JRB_Normal.setSelected(true);
        this.xValorSericio = 0.0d;
        this.xValorPagado = 0.0d;
        this.xValorGlosa = 0.0d;
        this.xValorGlosaA = 0.0d;
        this.xValorGlosaR = 0.0d;
        this.xValorSaldo = 0.0d;
        this.JTFF_VServicio.setValue(Double.valueOf(this.xValorSericio));
        this.JTFF_VPagado.setValue(Double.valueOf(this.xValorPagado));
        this.JTFF_VGlosa.setValue(Double.valueOf(this.xValorGlosa));
        this.JTFF_VGAceptada.setValue(Double.valueOf(this.xValorGlosaA));
        this.JTFF_VGRecuperable.setValue(Double.valueOf(this.xValorGlosaR));
        this.JTFF_VSaldo.setValue(Double.valueOf(this.xValorSaldo));
    }

    private void mCargarSetDatosCartera() {
        this.xGCuenta.cargarSetDatosCartera(this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xmt.formatoAMD1.format(this.JDFechaF.getDate());
    }
}
