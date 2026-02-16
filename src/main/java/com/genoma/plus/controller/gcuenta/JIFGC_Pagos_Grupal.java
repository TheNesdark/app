package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.WorkerSQL;
import com.genoma.plus.dao.contabilidad.ContabilidadDAO;
import com.genoma.plus.dao.impl.contabilidad.ContabilidadDAOImpl;
import com.genoma.plus.dao.impl.gcuenta.GCuentaDAOImpl;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.genoma.plus.dao.presupuesto.PresupuestoDAO;
import com.genoma.plus.dto.contabilidad.CTipoDocumentoDTO;
import com.genoma.plus.dto.gcuenta.GCConceptoPagoCarteraDTO;
import com.genoma.plus.dto.gcuenta.GCConsolidadoCarteraDTO;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.gcuenta.GCHistoricoPagoDTO;
import com.genoma.plus.dto.presupuesto.PeriodoDTO;
import com.genoma.plus.dto.presupuesto.TipoDocumentoDTO;
import com.genoma.plus.jpa.gcuenta.GCuentaDAO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFGC_Pagos_Grupal.class */
public class JIFGC_Pagos_Grupal extends JInternalFrame {
    public String[] xidempresa;
    private String[] xIdDocReconocimiento;
    private String[] xIdDocRecaudo;
    private String[] xIdTipoDocC;
    private String[][] xidperiodoppt;
    private String xsql;
    private String xcondicion;
    private Object[] xDato;
    private Object[] xDatoH;
    private File xfile;
    private String[][] xIdConceptoPago;
    private GCuentaDAO gcuenta;
    private PresupuestoDAO presupuesto;
    private ContabilidadDAO contabilidad;
    public DefaultTableModel xModelo;
    public DefaultTableModel xModeloH;
    private WorkerSQL xWorkerSQL;
    private ButtonGroup JBGExportacion;
    private ButtonGroup JBG_Filtro;
    private ButtonGroup JBG_NDoc;
    private JButton JBTExportar;
    private JButton JBT_Contabilidacion;
    private JButton JBT_GTemporalmente;
    public JComboBox JCBConceptoP;
    private JComboBox JCBPeriodo_Ppt;
    private JComboBox JCBTipoDocRecaudo;
    private JComboBox JCBTipoDocReconocimiento;
    public JComboBox JCB_Empresa;
    private JComboBox JCB_TipoDocumentoC;
    private JCheckBox JCHSeleccion;
    private JCheckBox JCH_AplicaMC;
    private JCheckBox JCH_AplicaMP;
    private JCheckBox JCH_AplicaMP_Reconocimiento;
    private JCheckBox JCH_PagoG;
    private JCheckBox JCH_SinFiltro;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JDateChooser JDFechaPago;
    private JPanel JPExportacion;
    private JPanel JPIDatosPago;
    private JPanel JPI_Consulta;
    private JPanel JPI_DContable;
    private JPanel JPI_DPresupuestales;
    private JPanel JPI_Filtro;
    private JPanel JPI_Filtro1;
    private JPanel JPI_Utilidades;
    private JRadioButton JRBCCobro;
    private JRadioButton JRBExportar;
    private JRadioButton JRBF_ConSaldo;
    private JRadioButton JRBF_SinSaldo;
    private JRadioButton JRBF_Todas;
    private JRadioButton JRBFactura;
    private JRadioButton JRBImportar;
    private JScrollPane JSPDetalleS;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObsPago;
    private JTextPane JTAObsPago;
    private JTabbedPane JTBTablas;
    private JTabbedPane JTB_DPago;
    public JTable JTDetalleS;
    private JFormattedTextField JTFFNDoc_Contable;
    private JFormattedTextField JTFFNDoc_Ppt_Rc;
    private JFormattedTextField JTFFNDoc_Ppt_Recaudo;
    private JFormattedTextField JTFFNRegistro;
    private JFormattedTextField JTFFValorDistribucion;
    public JFormattedTextField JTFFValorPagado;
    private JFormattedTextField JTFF_VGAceptada;
    private JFormattedTextField JTFF_VGRecuperable;
    private JFormattedTextField JTFF_VGlosa;
    private JFormattedTextField JTFF_VPagado;
    private JFormattedTextField JTFF_VSaldo;
    private JFormattedTextField JTFF_VServicio;
    private JTextField JTFRuta;
    private JTextField JTFRutaSoportePago;
    public JTextField JTF_DocP;
    private JTable JTHistorico;
    private JTextField JTf_FiltroNFactura;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private int xEsGlobal = 0;
    private ConsultasMySQL xct = new ConsultasMySQL();
    private long nDocumento = 0;

    public JIFGC_Pagos_Grupal() {
        initComponents();
        springStart();
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v300, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v307, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JBG_NDoc = new ButtonGroup();
        this.JBGExportacion = new ButtonGroup();
        this.JPI_Consulta = new JPanel();
        this.JCB_Empresa = new JComboBox();
        this.JPI_Filtro = new JPanel();
        this.JRBF_Todas = new JRadioButton();
        this.JRBF_ConSaldo = new JRadioButton();
        this.JRBF_SinSaldo = new JRadioButton();
        this.JCH_PagoG = new JCheckBox();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JCH_SinFiltro = new JCheckBox();
        this.JTB_DPago = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.JTFF_VServicio = new JFormattedTextField();
        this.JTFF_VPagado = new JFormattedTextField();
        this.JTFF_VGlosa = new JFormattedTextField();
        this.JTFF_VGAceptada = new JFormattedTextField();
        this.JTFF_VGRecuperable = new JFormattedTextField();
        this.JTFF_VSaldo = new JFormattedTextField();
        this.JTf_FiltroNFactura = new JTextField();
        this.JPI_Filtro1 = new JPanel();
        this.JRBFactura = new JRadioButton();
        this.JRBCCobro = new JRadioButton();
        this.JCHSeleccion = new JCheckBox();
        this.JPIDatosPago = new JPanel();
        this.JDFechaPago = new JDateChooser();
        this.JTFFValorPagado = new JFormattedTextField();
        this.JSPObsPago = new JScrollPane();
        this.JTAObsPago = new JTextPane();
        this.JTFRutaSoportePago = new JTextField();
        this.JCBConceptoP = new JComboBox();
        this.JTFFValorDistribucion = new JFormattedTextField();
        this.JTF_DocP = new JTextField();
        this.JTFFNRegistro = new JFormattedTextField();
        this.JPI_DContable = new JPanel();
        this.JCB_TipoDocumentoC = new JComboBox();
        this.JTFFNDoc_Contable = new JFormattedTextField();
        this.JCH_AplicaMC = new JCheckBox();
        this.JBT_Contabilidacion = new JButton();
        this.JPI_DPresupuestales = new JPanel();
        this.JCBPeriodo_Ppt = new JComboBox();
        this.JCBTipoDocReconocimiento = new JComboBox();
        this.JTFFNDoc_Ppt_Rc = new JFormattedTextField();
        this.JCBTipoDocRecaudo = new JComboBox();
        this.JTFFNDoc_Ppt_Recaudo = new JFormattedTextField();
        this.JCH_AplicaMP = new JCheckBox();
        this.JCH_AplicaMP_Reconocimiento = new JCheckBox();
        this.JPI_Utilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JBT_GTemporalmente = new JButton();
        this.JPExportacion = new JPanel();
        this.JRBExportar = new JRadioButton();
        this.JRBImportar = new JRadioButton();
        this.jPanel1 = new JPanel();
        this.jCheckBox1 = new JCheckBox();
        this.jCheckBox2 = new JCheckBox();
        this.JTBTablas = new JTabbedPane();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("GESTIÓN DE PAGOS");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifgestion_pagos");
        this.JPI_Consulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCB_Empresa.setFont(new Font("Arial", 1, 12));
        this.JCB_Empresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Empresa.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.1
            public void mouseClicked(MouseEvent evt) {
                JIFGC_Pagos_Grupal.this.JCB_EmpresaMouseClicked(evt);
            }
        });
        this.JCB_Empresa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.2
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JCB_EmpresaActionPerformed(evt);
            }
        });
        this.JPI_Filtro.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Filtro.add(this.JRBF_Todas);
        this.JRBF_Todas.setFont(new Font("Arial", 1, 12));
        this.JRBF_Todas.setSelected(true);
        this.JRBF_Todas.setText("Todas");
        this.JRBF_Todas.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.3
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JRBF_TodasActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRBF_ConSaldo);
        this.JRBF_ConSaldo.setFont(new Font("Arial", 1, 12));
        this.JRBF_ConSaldo.setText("Con Saldo");
        this.JBG_Filtro.add(this.JRBF_SinSaldo);
        this.JRBF_SinSaldo.setFont(new Font("Arial", 1, 12));
        this.JRBF_SinSaldo.setText("Sin Saldo");
        GroupLayout JPI_FiltroLayout = new GroupLayout(this.JPI_Filtro);
        this.JPI_Filtro.setLayout(JPI_FiltroLayout);
        JPI_FiltroLayout.setHorizontalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBF_Todas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBF_ConSaldo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBF_SinSaldo).addContainerGap(-1, 32767)));
        JPI_FiltroLayout.setVerticalGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_FiltroLayout.createSequentialGroup().addGroup(JPI_FiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBF_Todas).addComponent(this.JRBF_ConSaldo).addComponent(this.JRBF_SinSaldo)).addGap(0, 0, 32767)));
        this.JCH_PagoG.setFont(new Font("Arial", 1, 12));
        this.JCH_PagoG.setForeground(Color.red);
        this.JCH_PagoG.setText("Pago global?");
        this.JCH_PagoG.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.4
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JCH_PagoGActionPerformed(evt);
            }
        });
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGC_Pagos_Grupal.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGC_Pagos_Grupal.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JCH_SinFiltro.setFont(new Font("Arial", 1, 12));
        this.JCH_SinFiltro.setText("Sin Filtro Empresa");
        this.JCH_SinFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.7
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JCH_SinFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPI_ConsultaLayout = new GroupLayout(this.JPI_Consulta);
        this.JPI_Consulta.setLayout(JPI_ConsultaLayout);
        JPI_ConsultaLayout.setHorizontalGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsultaLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFechaI, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 115, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCB_Empresa, -2, 449, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Filtro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCH_PagoG).addComponent(this.JCH_SinFiltro)).addGap(87, 87, 87)));
        JPI_ConsultaLayout.setVerticalGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsultaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaF, -2, 50, -2).addComponent(this.JDFechaI, -2, 50, -2)).addComponent(this.JCB_Empresa).addGroup(GroupLayout.Alignment.LEADING, JPI_ConsultaLayout.createSequentialGroup().addComponent(this.JCH_SinFiltro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCH_PagoG)).addComponent(this.JPI_Filtro, GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap(-1, 32767)));
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
        this.JTFF_VGlosa.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.8
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JTFF_VGlosaActionPerformed(evt);
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
        this.JTf_FiltroNFactura.setFont(new Font("Arial", 1, 12));
        this.JTf_FiltroNFactura.setHorizontalAlignment(0);
        this.JTf_FiltroNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTf_FiltroNFactura.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.9
            public void keyPressed(KeyEvent evt) {
                JIFGC_Pagos_Grupal.this.JTf_FiltroNFacturaKeyPressed(evt);
            }
        });
        this.JPI_Filtro1.setBorder(BorderFactory.createTitledBorder((Border) null, "Buscar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_NDoc.add(this.JRBFactura);
        this.JRBFactura.setFont(new Font("Arial", 1, 12));
        this.JRBFactura.setSelected(true);
        this.JRBFactura.setText("Factura");
        this.JRBFactura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.10
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JRBFacturaActionPerformed(evt);
            }
        });
        this.JBG_NDoc.add(this.JRBCCobro);
        this.JRBCCobro.setFont(new Font("Arial", 1, 12));
        this.JRBCCobro.setText("Cuenta de Cobro");
        this.JRBCCobro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.11
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JRBCCobroActionPerformed(evt);
            }
        });
        GroupLayout JPI_Filtro1Layout = new GroupLayout(this.JPI_Filtro1);
        this.JPI_Filtro1.setLayout(JPI_Filtro1Layout);
        JPI_Filtro1Layout.setHorizontalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBFactura).addGap(18, 18, 18).addComponent(this.JRBCCobro).addContainerGap(-1, 32767)));
        JPI_Filtro1Layout.setVerticalGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_Filtro1Layout.createSequentialGroup().addGroup(JPI_Filtro1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBFactura).addComponent(this.JRBCCobro)).addGap(0, 0, 32767)));
        this.JCHSeleccion.setFont(new Font("Arial", 1, 12));
        this.JCHSeleccion.setForeground(Color.blue);
        this.JCHSeleccion.setText("Seleccionar Todo");
        this.JCHSeleccion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.12
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JCHSeleccionActionPerformed(evt);
            }
        });
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFF_VServicio, -2, 147, -2).addGap(12, 12, 12).addComponent(this.JTFF_VPagado, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_VGlosa, -2, 147, -2).addGap(18, 18, 18).addComponent(this.JTFF_VGAceptada, -2, 147, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFF_VGRecuperable, -2, 147, -2).addGap(18, 18, 18).addComponent(this.JTFF_VSaldo, -2, 147, -2).addGap(61, 61, 61).addComponent(this.JTf_FiltroNFactura, -1, 130, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JCHSeleccion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPI_Filtro1, -2, -1, -2))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.JPI_Filtro1, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCHSeleccion))).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFF_VPagado, GroupLayout.Alignment.LEADING, -1, 62, 32767).addComponent(this.JTFF_VServicio, GroupLayout.Alignment.LEADING).addComponent(this.JTFF_VGlosa, GroupLayout.Alignment.LEADING).addComponent(this.JTFF_VGAceptada, GroupLayout.Alignment.LEADING).addComponent(this.JTFF_VGRecuperable, GroupLayout.Alignment.LEADING).addComponent(this.JTFF_VSaldo, GroupLayout.Alignment.LEADING).addComponent(this.JTf_FiltroNFactura, GroupLayout.Alignment.LEADING)).addContainerGap()));
        this.JTB_DPago.addTab("TOTALES", this.jPanel2);
        this.JDFechaPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaPago.setDateFormatString("dd/MM/yyyy");
        this.JDFechaPago.setFont(new Font("Arial", 1, 12));
        this.JTFFValorPagado.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor Pagado", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPagado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorPagado.setHorizontalAlignment(4);
        this.JTFFValorPagado.setFont(new Font("Arial", 1, 14));
        this.JTFFValorPagado.setValue(new Long(0L));
        this.JSPObsPago.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPObsPago.setFont(new Font("Arial", 1, 12));
        this.JTAObsPago.setFont(new Font("Arial", 1, 12));
        this.JSPObsPago.setViewportView(this.JTAObsPago);
        this.JTFRutaSoportePago.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoportePago.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaSoportePago.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.13
            public void mouseClicked(MouseEvent evt) {
                JIFGC_Pagos_Grupal.this.JTFRutaSoportePagoMouseClicked(evt);
            }
        });
        this.JCBConceptoP.setFont(new Font("Arial", 1, 12));
        this.JCBConceptoP.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorDistribucion.setBorder(BorderFactory.createTitledBorder((Border) null, "Total Distribución", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorDistribucion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        this.JTFFValorDistribucion.setHorizontalAlignment(4);
        this.JTFFValorDistribucion.setFont(new Font("Arial", 1, 14));
        this.JTFFValorDistribucion.setValue(new Long(0L));
        this.JTF_DocP.setFont(new Font("Arial", 1, 14));
        this.JTF_DocP.setHorizontalAlignment(0);
        this.JTF_DocP.setToolTipText("Número de documento contable del pago global");
        this.JTF_DocP.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Documento", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTF_DocP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.14
            public void mouseClicked(MouseEvent evt) {
                JIFGC_Pagos_Grupal.this.JTF_DocPMouseClicked(evt);
            }
        });
        this.JTF_DocP.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.15
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JTF_DocPActionPerformed(evt);
            }
        });
        this.JTFFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registros", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNRegistro.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFNRegistro.setHorizontalAlignment(4);
        this.JTFFNRegistro.setToolTipText("Numero de Registros Seleccionados");
        this.JTFFNRegistro.setFont(new Font("Arial", 1, 14));
        this.JTFFNRegistro.setValue(new Long(0L));
        GroupLayout JPIDatosPagoLayout = new GroupLayout(this.JPIDatosPago);
        this.JPIDatosPago.setLayout(JPIDatosPagoLayout);
        JPIDatosPagoLayout.setHorizontalGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPagoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPagoLayout.createSequentialGroup().addComponent(this.JDFechaPago, -2, 132, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBConceptoP, -2, 521, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addComponent(this.JTFFNRegistro, -2, 96, -2).addGap(18, 18, 18).addComponent(this.JTFFValorPagado, -2, 147, -2).addGap(28, 28, 28).addComponent(this.JTFFValorDistribucion, -2, 147, -2)).addGroup(JPIDatosPagoLayout.createSequentialGroup().addComponent(this.JTFRutaSoportePago, -1, 539, 32767).addGap(21, 21, 21).addComponent(this.JSPObsPago, -2, 429, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTF_DocP, -2, 146, -2))).addContainerGap()));
        JPIDatosPagoLayout.setVerticalGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPagoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JDFechaPago, -1, 56, 32767).addGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorPagado, -1, 50, 32767).addComponent(this.JCBConceptoP, -1, 50, 32767).addComponent(this.JTFFNRegistro, -1, 52, 32767)).addComponent(this.JTFFValorDistribucion, -1, 56, 32767)).addGap(8, 8, 8).addGroup(JPIDatosPagoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRutaSoportePago, -1, 59, 32767).addComponent(this.JSPObsPago, -1, 59, 32767).addComponent(this.JTF_DocP, GroupLayout.Alignment.TRAILING, -1, 59, 32767)).addContainerGap()));
        this.JTB_DPago.addTab("DATOS PAGO", this.JPIDatosPago);
        this.JCB_TipoDocumentoC.setFont(new Font("Arial", 1, 12));
        this.JCB_TipoDocumentoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_TipoDocumentoC.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.16
            public void itemStateChanged(ItemEvent evt) {
                JIFGC_Pagos_Grupal.this.JCB_TipoDocumentoCItemStateChanged(evt);
            }
        });
        this.JTFFNDoc_Contable.setEditable(false);
        this.JTFFNDoc_Contable.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Contable.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Contable.setHorizontalAlignment(0);
        this.JTFFNDoc_Contable.setFont(new Font("Arial", 1, 18));
        this.JCH_AplicaMC.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMC.setText("Aplica?");
        this.JBT_Contabilidacion.setFont(new Font("Arial", 1, 12));
        this.JBT_Contabilidacion.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Contabilidad29x27.png")));
        this.JBT_Contabilidacion.setText("Contabilización");
        this.JBT_Contabilidacion.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.17
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JBT_ContabilidacionActionPerformed(evt);
            }
        });
        GroupLayout JPI_DContableLayout = new GroupLayout(this.JPI_DContable);
        this.JPI_DContable.setLayout(JPI_DContableLayout);
        JPI_DContableLayout.setHorizontalGroup(JPI_DContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DContableLayout.createSequentialGroup().addContainerGap().addComponent(this.JCH_AplicaMC).addGap(68, 68, 68).addComponent(this.JCB_TipoDocumentoC, 0, 546, 32767).addGap(34, 34, 34).addComponent(this.JTFFNDoc_Contable, -2, 140, -2).addGap(65, 65, 65).addComponent(this.JBT_Contabilidacion, -2, 217, -2).addGap(18, 18, 18)));
        JPI_DContableLayout.setVerticalGroup(JPI_DContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DContableLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_DContableLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DContableLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JBT_Contabilidacion, -1, -1, 32767)).addGroup(JPI_DContableLayout.createSequentialGroup().addGroup(JPI_DContableLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCH_AplicaMC).addComponent(this.JCB_TipoDocumentoC, -2, 50, -2).addComponent(this.JTFFNDoc_Contable, -2, -1, -2)).addGap(0, 65, 32767))).addContainerGap()));
        this.JTB_DPago.addTab("DATO CONTABLE", this.JPI_DContable);
        this.JPI_DPresupuestales.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESUPUESTO", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBPeriodo_Ppt.setFont(new Font("Arial", 1, 12));
        this.JCBPeriodo_Ppt.setBorder(BorderFactory.createTitledBorder((Border) null, "Período", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocReconocimiento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocReconocimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento (Reconocimiento)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt_Rc.setEditable(false);
        this.JTFFNDoc_Ppt_Rc.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt_Rc.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Ppt_Rc.setHorizontalAlignment(0);
        this.JTFFNDoc_Ppt_Rc.setFont(new Font("Arial", 1, 18));
        this.JCBTipoDocRecaudo.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocRecaudo.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento (Recaudo)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt_Recaudo.setEditable(false);
        this.JTFFNDoc_Ppt_Recaudo.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNDoc_Ppt_Recaudo.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFNDoc_Ppt_Recaudo.setHorizontalAlignment(0);
        this.JTFFNDoc_Ppt_Recaudo.setFont(new Font("Arial", 1, 18));
        this.JCH_AplicaMP.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMP.setText("Aplica?");
        this.JCH_AplicaMP_Reconocimiento.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMP_Reconocimiento.setText("Aplica Reconocimiento?");
        GroupLayout JPI_DPresupuestalesLayout = new GroupLayout(this.JPI_DPresupuestales);
        this.JPI_DPresupuestales.setLayout(JPI_DPresupuestalesLayout);
        JPI_DPresupuestalesLayout.setHorizontalGroup(JPI_DPresupuestalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DPresupuestalesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DPresupuestalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBPeriodo_Ppt, -2, 238, -2).addComponent(this.JCH_AplicaMP)).addGap(18, 18, 18).addGroup(JPI_DPresupuestalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBTipoDocRecaudo, 0, 480, 32767).addComponent(this.JCBTipoDocReconocimiento, 0, -1, 32767)).addGap(26, 26, 26).addComponent(this.JCH_AplicaMP_Reconocimiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, 32767).addGroup(JPI_DPresupuestalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFNDoc_Ppt_Rc, -2, 140, -2).addComponent(this.JTFFNDoc_Ppt_Recaudo, -2, 140, -2)).addGap(21, 21, 21)));
        JPI_DPresupuestalesLayout.setVerticalGroup(JPI_DPresupuestalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DPresupuestalesLayout.createSequentialGroup().addGroup(JPI_DPresupuestalesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoDocReconocimiento, -2, 50, -2).addComponent(this.JCH_AplicaMP_Reconocimiento)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, 32767).addGroup(JPI_DPresupuestalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoDocRecaudo, -2, 50, -2).addComponent(this.JCBPeriodo_Ppt, -2, 50, -2))).addGroup(JPI_DPresupuestalesLayout.createSequentialGroup().addComponent(this.JCH_AplicaMP).addGap(0, 0, 32767)).addGroup(GroupLayout.Alignment.TRAILING, JPI_DPresupuestalesLayout.createSequentialGroup().addComponent(this.JTFFNDoc_Ppt_Recaudo, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, 32767).addComponent(this.JTFFNDoc_Ppt_Rc, -2, -1, -2)));
        this.JTB_DPago.addTab("DATOS PRESUPUESTALES", this.JPI_DPresupuestales);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.18
            public void mouseClicked(MouseEvent evt) {
                JIFGC_Pagos_Grupal.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.19
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBT_GTemporalmente.setFont(new Font("Arial", 1, 12));
        this.JBT_GTemporalmente.setForeground(Color.red);
        this.JBT_GTemporalmente.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.JBT_GTemporalmente.setText("Grabar selección temporal");
        this.JBT_GTemporalmente.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.20
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JBT_GTemporalmenteActionPerformed(evt);
            }
        });
        this.JPExportacion.setBorder(BorderFactory.createTitledBorder((Border) null, "TIPO DE EXCEL", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JBGExportacion.add(this.JRBExportar);
        this.JRBExportar.setFont(new Font("Arial", 1, 12));
        this.JRBExportar.setSelected(true);
        this.JRBExportar.setText("Exportar");
        this.JRBExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.21
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JRBExportarActionPerformed(evt);
            }
        });
        this.JBGExportacion.add(this.JRBImportar);
        this.JRBImportar.setFont(new Font("Arial", 1, 12));
        this.JRBImportar.setText("Importar");
        this.JRBImportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.22
            public void actionPerformed(ActionEvent evt) {
                JIFGC_Pagos_Grupal.this.JRBImportarActionPerformed(evt);
            }
        });
        GroupLayout JPExportacionLayout = new GroupLayout(this.JPExportacion);
        this.JPExportacion.setLayout(JPExportacionLayout);
        JPExportacionLayout.setHorizontalGroup(JPExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBExportar).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JRBImportar).addContainerGap()));
        JPExportacionLayout.setVerticalGroup(JPExportacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPExportacionLayout.createSequentialGroup().addGroup(JPExportacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBExportar).addComponent(this.JRBImportar)).addGap(10, 10, 10)));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "Convención colores tabla", 0, 0, new Font("Arial", 1, 12)));
        this.jPanel1.setOpaque(false);
        this.jCheckBox1.setBackground(Color.red);
        this.jCheckBox1.setFont(new Font("Arial", 1, 12));
        this.jCheckBox1.setText("Con saldo negativo");
        this.jCheckBox1.setOpaque(true);
        this.jCheckBox2.setBackground(new Color(177, 251, 177));
        this.jCheckBox2.setFont(new Font("Arial", 1, 12));
        this.jCheckBox2.setText("Radicada");
        this.jCheckBox2.setOpaque(true);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jCheckBox1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCheckBox2).addContainerGap(14, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCheckBox1).addComponent(this.jCheckBox2)).addContainerGap(-1, 32767)));
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addComponent(this.JTFRuta, -2, 407, -2).addGap(30, 30, 30).addComponent(this.JBTExportar, -2, 178, -2).addGap(55, 55, 55).addComponent(this.JPExportacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBT_GTemporalmente, -2, 226, -2).addGap(49, 49, 49)))));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_UtilidadesLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPExportacion, -2, 50, -2).addComponent(this.JTFRuta, -2, 50, -2).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JBT_GTemporalmente, -2, 50, -2))).addGap(37, 37, 37)));
        this.JTB_DPago.addTab("UTILIDADES Y/O EXPORTAR", this.JPI_Utilidades);
        this.JTBTablas.setForeground(Color.red);
        this.JTBTablas.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleS.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setForeground(new Color(0, 0, 204));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleS.setEditingColumn(1);
        this.JTDetalleS.setEditingRow(1);
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JTDetalleS.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.23
            public void mouseClicked(MouseEvent evt) {
                JIFGC_Pagos_Grupal.this.JTDetalleSMouseClicked(evt);
            }
        });
        this.JTDetalleS.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.24
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFGC_Pagos_Grupal.this.JTDetalleSPropertyChange(evt);
            }
        });
        this.JTDetalleS.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.25
            public void keyPressed(KeyEvent evt) {
                JIFGC_Pagos_Grupal.this.JTDetalleSKeyPressed(evt);
            }
        });
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JTBTablas.addTab("DETALLE", this.JSPDetalleS);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTHistorico.setSelectionBackground(Color.white);
        this.JTHistorico.setSelectionForeground(Color.red);
        this.JSPHistorico.setViewportView(this.JTHistorico);
        this.JTBTablas.addTab("DETALLE DE PAGOS", this.JSPHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTB_DPago, -2, 0, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTBTablas, GroupLayout.Alignment.LEADING).addComponent(this.JPI_Consulta, -2, 1166, -2)).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Consulta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTBTablas, -1, 317, 32767).addGap(48, 48, 48).addComponent(this.JTB_DPago, -2, 181, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoportePagoMouseClicked(MouseEvent evt) {
        JFileChooser xfilec = new JFileChooser("S:\\FACTURACION\\");
        int xv = xfilec.showOpenDialog(this);
        if (xv == 0) {
            this.xfile = xfilec.getSelectedFile();
            System.out.println(this.xfile.getAbsolutePath());
            this.JTFRutaSoportePago.setText(this.xfile.getAbsolutePath());
            this.JTFRutaSoportePago.setText(this.xmt.mTraerUrlBD(this.xfile.getAbsolutePath()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSKeyPressed(KeyEvent evt) {
        System.out.println(evt.getKeyCode());
        if (evt.getKeyCode() == 10 && this.JTDetalleS.getRowCount() != -1 && this.JTDetalleS.getSelectedRow() != -1 && this.JTDetalleS.getSelectedColumn() == 21) {
            if (Double.valueOf(this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 21).toString()).doubleValue() > 0.0d) {
                this.xModelo.setValueAt(true, this.JTDetalleS.getSelectedRow(), 22);
            }
            mCalcularDistribucion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSMouseClicked(MouseEvent evt) {
        if (this.JTDetalleS.getRowCount() != -1 && this.JTDetalleS.getSelectedRow() != -1) {
            if (this.JTDetalleS.getSelectedColumn() == 22) {
                if (Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 8).toString()).booleanValue()) {
                    if (Boolean.valueOf(this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 22).toString()).booleanValue()) {
                        this.xModelo.setValueAt(this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 16), this.JTDetalleS.getSelectedRow(), 21);
                        this.xModelo.setValueAt(true, this.JTDetalleS.getSelectedRow(), 22);
                    } else {
                        this.xModelo.setValueAt(new Double(0.0d), this.JTDetalleS.getSelectedRow(), 21);
                        this.xModelo.setValueAt(false, this.JTDetalleS.getSelectedRow(), 22);
                    }
                    mCalcularDistribucion();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Factura no se encuentra radicada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.xModelo.setValueAt(new Double(0.0d), this.JTDetalleS.getSelectedRow(), 21);
                this.xModelo.setValueAt(false, this.JTDetalleS.getSelectedRow(), 22);
                return;
            }
            if (this.JTDetalleS.getSelectedColumn() == 1 && evt.getClickCount() == 2) {
                mCargarDatosHistorico(this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 20).toString());
                this.JTBTablas.setSelectedIndex(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JRBExportar.isSelected()) {
                JFileChooser xfilec = new JFileChooser(this.JTFRuta.getText());
                xfilec.setFileSelectionMode(1);
                int xv = xfilec.showOpenDialog(this);
                if (xv == 0) {
                    File xfile = xfilec.getSelectedFile();
                    this.JTFRuta.setText(xfile.getAbsolutePath() + this.xmt.getBarra());
                    this.JTFRuta.requestFocus();
                    return;
                }
                return;
            }
            if (this.JRBImportar.isSelected()) {
                JFileChooser xfilec2 = new JFileChooser(this.JTFRuta.getText());
                FileNameExtensionFilter excel = new FileNameExtensionFilter("Excel (XLSX)", new String[]{"xlsx"});
                xfilec2.addChoosableFileFilter(excel);
                int r = xfilec2.showOpenDialog(this);
                if (r == 0) {
                    xfilec2.showOpenDialog(this);
                    this.xfile = xfilec2.getSelectedFile();
                    System.out.println(this.xfile.getAbsolutePath());
                    this.JTFRuta.setText(this.xfile.getAbsolutePath());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalleS.getRowCount() > 0) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la información", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    if (this.JRBExportar.isSelected()) {
                        this.xmt.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleS, this.xmt.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                        return;
                    } else {
                        if (this.JRBImportar.isSelected()) {
                            Importar();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFF_VGlosaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_PagoGActionPerformed(ActionEvent evt) {
        if (this.JCH_PagoG.isSelected()) {
            this.xEsGlobal = 1;
            return;
        }
        this.xEsGlobal = 0;
        for (int i = 0; i < this.JTDetalleS.getRowCount(); i++) {
            if (Double.valueOf(this.xModelo.getValueAt(i, 21).toString()).doubleValue() > Double.valueOf(this.xModelo.getValueAt(i, 16).toString()).doubleValue()) {
                this.xModelo.setValueAt(0, i, 21);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTf_FiltroNFacturaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mBuscar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_DocPMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JCB_Empresa.getSelectedIndex() != -1) {
                JD_Consulta_PagosGlobales_Pendientes xjd = new JD_Consulta_PagosGlobales_Pendientes(Principal.xclasegc.xjifprincipal, true, this.xidempresa[this.JCB_Empresa.getSelectedIndex()]);
                xjd.setLocation((this.xmt.getAnchoPantalla() / 2) / 2, (this.xmt.getAltoPantalla() / 2) / 2);
                xjd.setVisible(true);
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                this.JCB_Empresa.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTF_DocPActionPerformed(ActionEvent evt) {
        mConsultarIdDocPagoGlobal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_TipoDocumentoCItemStateChanged(ItemEvent evt) {
        if (this.JCB_TipoDocumentoC.getSelectedIndex() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_ContabilidacionActionPerformed(ActionEvent evt) {
        if (this.JTDetalleS.getRowCount() == -1 || !this.xmt.mVerificarDatosTablaTrue(this.JTDetalleS, 22)) {
            JOptionPane.showInternalMessageDialog(this, "Falta seleccion de datos y/o tabla sin información", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        if (Double.valueOf(this.JTFFValorPagado.getValue().toString()).doubleValue() != 0.0d) {
            if (Objects.equals(Double.valueOf(this.JTFFValorDistribucion.getValue().toString()), Double.valueOf(this.JTFFValorPagado.getValue().toString()))) {
                if (Principal.xclase.mValidarFechasDoc(this.JDFechaPago.getDate())) {
                    Principal.xclase.cargarPantalla("Documento Contable", this);
                    Principal.xclase.xjifdoccontable.JDFFechaC.setDate(this.JDFechaPago.getDate());
                    Principal.xclase.xjifdoccontable.JCBTipoC.setSelectedItem(this.JCB_TipoDocumentoC.getSelectedItem());
                    return;
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JTB_DPago.setSelectedIndex(1);
                    this.JDFechaPago.requestFocus();
                    return;
                }
            }
            JOptionPane.showInternalMessageDialog(this, "El valor distribuido es menor al valor pagado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Falta registro de valor pagado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTB_DPago.setSelectedIndex(1);
        this.JTFFValorPagado.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFacturaActionPerformed(ActionEvent evt) {
        this.JTf_FiltroNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Factura", 0, 0, new Font("Arial", 1, 12), Color.red));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBCCobroActionPerformed(ActionEvent evt) {
        this.JTf_FiltroNFactura.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cuenta de Cobro", 0, 0, new Font("Arial", 1, 12), Color.red));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_SinFiltroActionPerformed(ActionEvent evt) {
        if (this.JCH_SinFiltro.isSelected()) {
            this.JCB_Empresa.setEnabled(false);
        } else {
            this.JCB_Empresa.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_GTemporalmenteActionPerformed(ActionEvent evt) {
        if (this.JTDetalleS.getSelectedRow() != -1 && this.xmt.mVerificarDatosTablaTrue(this.JTDetalleS, 22)) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.gcuenta.deleteIdLiquidacionTmp();
                for (int y = 0; y < this.JTDetalleS.getRowCount(); y++) {
                    if (Boolean.valueOf(this.xModelo.getValueAt(y, 22).toString()).booleanValue()) {
                        this.gcuenta.addLiquidacion_STemporal(Long.valueOf(this.xModelo.getValueAt(y, 20).toString()), String.valueOf(Principal.usuarioSistemaDTO.getIdPersonaCargo()), Double.valueOf(this.xModelo.getValueAt(y, 21).toString()));
                    }
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe factura seleccionada", "VERIFICACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHSeleccionActionPerformed(ActionEvent evt) {
        if (this.JCHSeleccion.isSelected()) {
            this.JCHSeleccion.setText("Quitar Selección");
            mRecorrerTabla();
        } else {
            this.JCHSeleccion.setText("Seleccionar Todo");
            mRecorrerTabla();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBExportarActionPerformed(ActionEvent evt) {
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Exportar");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBImportarActionPerformed(ActionEvent evt) {
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/actualizar.png")));
        this.JBTExportar.setText("Importar");
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a importar", 0, 0, new Font("Arial", 1, 12), Color.blue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBF_TodasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleSPropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalleS.getRowCount() > 0) {
            if (!this.JCH_PagoG.isSelected()) {
                for (int i = 0; i < this.JTDetalleS.getRowCount(); i++) {
                    if (Double.valueOf(this.xModelo.getValueAt(i, 21).toString()).doubleValue() > Double.valueOf(this.xModelo.getValueAt(i, 16).toString()).doubleValue()) {
                        this.xModelo.setValueAt(0, i, 21);
                    }
                }
            }
            mCalcularDistribucion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EmpresaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EmpresaMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JDEmpresasCartera jDEmpresa = new JDEmpresasCartera(null, false, this);
            jDEmpresa.setVisible(true);
        }
    }

    private void mRecorrerTabla() {
        if (this.JTDetalleS.getRowCount() > 0) {
            for (int i = 0; i < this.JTDetalleS.getRowCount(); i++) {
                if (this.JCHSeleccion.isSelected()) {
                    this.xModelo.setValueAt(this.xModelo.getValueAt(i, 16), i, 21);
                    this.xModelo.setValueAt(true, i, 22);
                } else {
                    this.xModelo.setValueAt(new Double(0.0d), i, 21);
                    this.xModelo.setValueAt(false, i, 22);
                }
            }
            mCalcularDistribucion();
        }
    }

    private void mLlenarCombo() {
        this.JCB_Empresa.removeAllItems();
        List<GCGenericoDTO> list3 = this.gcuenta.listEmpresasCartera();
        this.xidempresa = new String[list3.size()];
        for (int x = 0; x < list3.size(); x++) {
            this.xidempresa[x] = String.valueOf(list3.get(x).getId());
            this.JCB_Empresa.addItem(list3.get(x).getNombre());
            System.out.println("Consulta " + list3.get(x).getId());
            System.out.println("" + list3.get(x).getNombre());
        }
        this.JCBPeriodo_Ppt.removeAllItems();
        List<PeriodoDTO> list2 = this.presupuesto.listPeriodoPptActivos();
        this.xidperiodoppt = new String[list2.size()][2];
        for (int x2 = 0; x2 < list2.size(); x2++) {
            this.xidperiodoppt[x2][0] = String.valueOf(list2.get(x2).getId());
            this.xidperiodoppt[x2][1] = String.valueOf(list2.get(x2).getIdEncabezado());
            this.JCBPeriodo_Ppt.addItem(list2.get(x2).getNombre());
        }
        this.JCBConceptoP.removeAllItems();
        List<GCConceptoPagoCarteraDTO> list1 = this.gcuenta.listConceptoPagoActivosCartera();
        this.xIdConceptoPago = new String[list1.size()][2];
        for (int x3 = 0; x3 < list1.size(); x3++) {
            this.xIdConceptoPago[x3][0] = String.valueOf(list1.get(x3).getId());
            this.xIdConceptoPago[x3][1] = String.valueOf(list1.get(x3).getFPago());
            this.JCBConceptoP.addItem(list1.get(x3).getNombre());
        }
        this.JCBTipoDocReconocimiento.removeAllItems();
        List<TipoDocumentoDTO> list = this.presupuesto.lisTipoDocumentoId(2);
        this.xIdDocReconocimiento = new String[list.size()];
        for (int x4 = 0; x4 < list.size(); x4++) {
            this.xIdDocReconocimiento[x4] = String.valueOf(list.get(x4).getId());
            this.JCBTipoDocReconocimiento.addItem(list.get(x4).getNombre());
        }
        this.JCBTipoDocRecaudo.removeAllItems();
        List<TipoDocumentoDTO> list4 = this.presupuesto.lisTipoDocumentoId(3);
        this.xIdDocRecaudo = new String[list4.size()];
        for (int x5 = 0; x5 < list4.size(); x5++) {
            this.xIdDocRecaudo[x5] = String.valueOf(list4.get(x5).getId());
            this.JCBTipoDocRecaudo.addItem(list4.get(x5).getNombre());
        }
        this.JCB_TipoDocumentoC.removeAllItems();
        List<CTipoDocumentoDTO> listC = this.contabilidad.listTipoDocContable();
        this.xIdTipoDocC = new String[listC.size()];
        for (int x6 = 0; x6 < listC.size(); x6++) {
            this.xIdTipoDocC[x6] = String.valueOf(listC.get(x6).getId());
            this.JCB_TipoDocumentoC.addItem(listC.get(x6).getNombre());
        }
    }

    private void mConsultarIdDocPagoGlobal() {
        if (this.JCB_Empresa.getSelectedIndex() != -1) {
            if (!this.JTF_DocP.getText().equals("")) {
                List<Object[]> list = this.gcuenta.listDocumentosPagoGlobales(this.xidempresa[this.JCB_Empresa.getSelectedIndex()], this.JTF_DocP.getText());
                if (list.size() > 0) {
                    this.JTFFValorPagado.setValue(list.get(0)[3]);
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una empresa", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JCB_Empresa.requestFocus();
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.gcuenta = (GCuentaDAOImpl) classPathXmlApplicationContext.getBean("gCuentaDAOImpl");
        this.presupuesto = (PresupuestoDAOImpl) classPathXmlApplicationContext.getBean("presupuestoDAOImpl");
        this.contabilidad = (ContabilidadDAOImpl) classPathXmlApplicationContext.getBean("contabilidadDAOImpl");
    }

    private void mCrearModeloDatos() {
        this.xModelo = new DefaultTableModel() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.26
            Class[] types = {String.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, Double.class, Double.class, Double.class, Double.class, Double.class, Double.class, Boolean.class, String.class, String.class, Long.class, Double.class, Boolean.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, false, true, true, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xModelo.addColumn("FFactura");
        this.xModelo.addColumn("Nº Factura");
        this.xModelo.addColumn("NServicio");
        this.xModelo.addColumn("TServicio");
        this.xModelo.addColumn("TDescuento");
        this.xModelo.addColumn("Copago");
        this.xModelo.addColumn("CModeradora");
        this.xModelo.addColumn("TotalF");
        this.xModelo.addColumn("Radicado");
        this.xModelo.addColumn("NRadicado");
        this.xModelo.addColumn("FRadicado");
        this.xModelo.addColumn("TPagado");
        this.xModelo.addColumn("VGlosa");
        this.xModelo.addColumn("VGAceptada");
        this.xModelo.addColumn("VGRecuperable");
        this.xModelo.addColumn("Valor");
        this.xModelo.addColumn("Saldo");
        this.xModelo.addColumn("P");
        this.xModelo.addColumn("Credito");
        this.xModelo.addColumn("Debito");
        this.xModelo.addColumn("Id_liquidacion");
        this.xModelo.addColumn("VPagado");
        this.xModelo.addColumn("A");
        this.xModelo.addColumn("Id_Rubro");
        this.xModelo.addColumn("Cuenta de Cobro");
        this.xModelo.addColumn("Empresa");
        this.xModelo.addColumn("Convenio");
        this.xModelo.addColumn("contorlValor");
        JTable jTable = this.JTDetalleS;
        JTable jTable2 = this.JTDetalleS;
        jTable.setAutoResizeMode(0);
        this.JTDetalleS.doLayout();
        this.JTDetalleS.setModel(this.xModelo);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(4).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(8).setPreferredWidth(50);
        this.JTDetalleS.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalleS.getColumnModel().getColumn(10).setPreferredWidth(120);
        this.JTDetalleS.getColumnModel().getColumn(11).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(12).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(13).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(14).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(15).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(16).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(18).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(19).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(20).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(20).setMaxWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(21).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(22).setPreferredWidth(5);
        this.JTDetalleS.getColumnModel().getColumn(23).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(24).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(25).setPreferredWidth(300);
        this.JTDetalleS.getColumnModel().getColumn(26).setPreferredWidth(300);
        this.JTDetalleS.getColumnModel().getColumn(27).setPreferredWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(27).setMinWidth(0);
        this.JTDetalleS.getColumnModel().getColumn(27).setMaxWidth(0);
        this.JTDetalleS.setModel(this.xModelo);
    }

    private void mCrearModeloHistorico() {
        this.xModeloH = new DefaultTableModel() { // from class: com.genoma.plus.controller.gcuenta.JIFGC_Pagos_Grupal.27
            Class[] types = {Long.class, String.class, Long.class, String.class, String.class, Double.class, String.class, Long.class, Long.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.xModeloH.addColumn("Id");
        this.xModeloH.addColumn("Periodo");
        this.xModeloH.addColumn("Nº Liquidacion");
        this.xModeloH.addColumn("Concepto");
        this.xModeloH.addColumn("Fecha Abono");
        this.xModeloH.addColumn("Valor");
        this.xModeloH.addColumn("Observacion");
        this.xModeloH.addColumn("DocContable");
        this.xModeloH.addColumn("DocPresupuesto");
        this.xModeloH.addColumn("Estado");
        JTable jTable = this.JTHistorico;
        JTable jTable2 = this.JTHistorico;
        jTable.setAutoResizeMode(0);
        this.JTHistorico.doLayout();
        this.JTHistorico.setModel(this.xModeloH);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTHistorico.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTHistorico.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTHistorico.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTHistorico.setModel(this.xModeloH);
    }

    public void mCargarDatosHistorico(String xid) {
        if (this.JTDetalleS.getSelectedRow() != -1) {
            List<GCHistoricoPagoDTO> list = this.gcuenta.listHistoricoPago(xid);
            double xsuma = 0.0d;
            mCrearModeloHistorico();
            for (int x = 0; x < list.size(); x++) {
                this.xModeloH.addRow(this.xDatoH);
                this.xModeloH.setValueAt(list.get(x).getId(), x, 0);
                this.xModeloH.setValueAt(list.get(x).getPeriodo(), x, 1);
                this.xModeloH.setValueAt(list.get(x).getIdLiquidacion(), x, 2);
                this.xModeloH.setValueAt(list.get(x).getConcepto(), x, 3);
                this.xModeloH.setValueAt(list.get(x).getFechaAbono(), x, 4);
                this.xModeloH.setValueAt(list.get(x).getValor(), x, 5);
                this.xModeloH.setValueAt(list.get(x).getObservacion(), x, 6);
                this.xModeloH.setValueAt(list.get(x).getDocContable(), x, 7);
                this.xModeloH.setValueAt(list.get(x).getDocPresupuesto(), x, 8);
                if (list.get(x).getEstado() == 1) {
                    this.xModeloH.setValueAt(true, x, 9);
                } else {
                    this.xModeloH.setValueAt(false, x, 9);
                }
                xsuma += list.get(x).getValor().doubleValue();
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro en el detalle", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
    }

    public void mNuevo() {
        this.JDFechaPago.setDate(this.xmt.getFechaActual());
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.JTFRuta.setText(this.xmt.getDirectorioExportacion() + "Planilla");
        this.JTFFValorPagado.setValue(new Double(0.0d));
        this.JTAObsPago.setText("");
        this.nDocumento = 0L;
        this.JRBF_Todas.setSelected(true);
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCH_AplicaMC.setSelected(true);
        }
        if (Principal.informacionIps.getManejaPresupuesto().intValue() == 1) {
            this.JCH_AplicaMP.setSelected(true);
        }
        if (Principal.informacionIps.getIdentificacion().equals("891982129")) {
            this.JCH_AplicaMP_Reconocimiento.setSelected(false);
            this.JCH_AplicaMP_Reconocimiento.setVisible(false);
            this.JCBTipoDocReconocimiento.setVisible(false);
            this.JTFFNDoc_Ppt_Rc.setVisible(false);
        } else {
            this.JCH_AplicaMP_Reconocimiento.setSelected(false);
        }
        mLlenarCombo();
        mCrearModeloDatos();
        mCrearModeloHistorico();
    }

    public void mBuscar() {
        if (this.JRBFactura.isSelected()) {
            this.xcondicion = " IF(f_factura_evento.Prefijo='',f_factura_evento.`No_FacturaEvento_M` ,CONCAT(f_factura_evento.Prefijo,'',f_factura_evento.`No_FacturaEvento_M`)) LIKE'%" + this.JTf_FiltroNFactura.getText() + "%'";
        } else {
            this.xcondicion = " `f_factura_evento`.`No_CuentaCobro`='" + this.JTf_FiltroNFactura.getText() + "'";
        }
        this.xWorkerSQL = null;
        this.xWorkerSQL = new WorkerSQL("Cargando Información...", this);
        this.xWorkerSQL.execute();
    }

    public void mCargarTablaDetalle() {
        List<GCConsolidadoCarteraDTO> list = new ArrayList<>();
        this.nDocumento = 0L;
        if (!this.JTf_FiltroNFactura.getText().isEmpty()) {
            if (this.JRBF_Todas.isSelected() && !this.JCH_SinFiltro.isSelected()) {
                if (this.JCB_Empresa.getSelectedIndex() != -1) {
                    list = this.gcuenta.listConsolidadoCarteraNFactura(this.xidempresa[this.JCB_Empresa.getSelectedIndex()], 0, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.JTf_FiltroNFactura.getText(), this.xcondicion);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCB_Empresa.requestFocus();
                }
            } else if (this.JRBF_ConSaldo.isSelected() && !this.JCH_SinFiltro.isSelected()) {
                if (this.JCB_Empresa.getSelectedIndex() != -1) {
                    list = this.gcuenta.listConsolidadoCarteraNFactura(this.xidempresa[this.JCB_Empresa.getSelectedIndex()], 1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.JTf_FiltroNFactura.getText(), this.xcondicion);
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tercero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    this.JCB_Empresa.requestFocus();
                }
            } else {
                list = this.JCH_SinFiltro.isSelected() ? this.JRBF_Todas.isSelected() ? this.gcuenta.listConsolidadoCarteraSinEmpresaPorFactura(0, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xcondicion) : this.JRBF_ConSaldo.isSelected() ? this.gcuenta.listConsolidadoCarteraSinEmpresaPorFactura(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xcondicion) : this.gcuenta.listConsolidadoCarteraSinEmpresaPorFactura(2, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.xcondicion) : this.gcuenta.listConsolidadoCarteraNFactura(this.xidempresa[this.JCB_Empresa.getSelectedIndex()], 2, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()), this.JTf_FiltroNFactura.getText(), this.xcondicion);
            }
        } else {
            list = this.JCH_SinFiltro.isSelected() ? this.JRBF_Todas.isSelected() ? this.gcuenta.listConsolidadoCarteraSinEmpresa(0, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate())) : this.JRBF_ConSaldo.isSelected() ? this.gcuenta.listConsolidadoCarteraSinEmpresa(1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate())) : this.gcuenta.listConsolidadoCarteraSinEmpresa(2, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate())) : this.JRBF_Todas.isSelected() ? this.gcuenta.listConsolidadoCartera(this.xidempresa[this.JCB_Empresa.getSelectedIndex()], 0, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate())) : this.JRBF_ConSaldo.isSelected() ? this.gcuenta.listConsolidadoCartera(this.xidempresa[this.JCB_Empresa.getSelectedIndex()], 1, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate())) : this.gcuenta.listConsolidadoCartera(this.xidempresa[this.JCB_Empresa.getSelectedIndex()], 2, this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        }
        double xv1 = 0.0d;
        double xv2 = 0.0d;
        double xv3 = 0.0d;
        double xv4 = 0.0d;
        double xv5 = 0.0d;
        double xv6 = 0.0d;
        mCrearModeloDatos();
        for (int x = 0; x < list.size(); x++) {
            this.xModelo.addRow(this.xDato);
            this.xModelo.setValueAt(list.get(x).getFFactura(), x, 0);
            this.xModelo.setValueAt(list.get(x).getNFactura(), x, 1);
            this.xModelo.setValueAt(list.get(x).getNServicio(), x, 2);
            this.xModelo.setValueAt(list.get(x).getTServicio(), x, 3);
            this.xModelo.setValueAt(list.get(x).getTDescuento(), x, 4);
            this.xModelo.setValueAt(list.get(x).getTCopago(), x, 5);
            this.xModelo.setValueAt(list.get(x).getTCModeradora(), x, 6);
            this.xModelo.setValueAt(list.get(x).getTFactura(), x, 7);
            this.xModelo.setValueAt(list.get(x).getEsRadicado(), x, 8);
            this.xModelo.setValueAt(list.get(x).getNRadicado(), x, 9);
            this.xModelo.setValueAt(list.get(x).getFRadicado(), x, 10);
            this.xModelo.setValueAt(list.get(x).getVPagado(), x, 11);
            this.xModelo.setValueAt(list.get(x).getVGlosa(), x, 12);
            this.xModelo.setValueAt(list.get(x).getVGAceptada(), x, 13);
            this.xModelo.setValueAt(list.get(x).getVGRecuperable(), x, 14);
            this.xModelo.setValueAt(list.get(x).getVNValor(), x, 15);
            this.xModelo.setValueAt(list.get(x).getVSaldo(), x, 16);
            this.xModelo.setValueAt(list.get(x).getEsPagado(), x, 17);
            this.xModelo.setValueAt(list.get(x).getCPucCredito(), x, 18);
            this.xModelo.setValueAt(list.get(x).getCPucDebito(), x, 19);
            this.xModelo.setValueAt(list.get(x).getIdLiquidacion(), x, 20);
            this.JTDetalleS.setDefaultRenderer(Object.class, new MiRender());
            this.xModelo.setValueAt(list.get(x).getVValorCTemporal(), x, 21);
            this.xModelo.setValueAt(list.get(x).getGrabadoTemporal(), x, 22);
            this.xModelo.setValueAt(list.get(x).getPIdRubro(), x, 23);
            this.xModelo.setValueAt(list.get(x).getCCobro(), x, 24);
            this.xModelo.setValueAt(list.get(x).getEmpresa(), x, 25);
            this.xModelo.setValueAt(list.get(x).getConvenio(), x, 26);
            this.xModelo.setValueAt(list.get(x).getControlSaldo(), x, 27);
            xv1 += list.get(x).getTServicio().doubleValue();
            xv2 += list.get(x).getVPagado().doubleValue();
            xv3 += list.get(x).getVGlosa().doubleValue();
            xv4 += list.get(x).getVGAceptada().doubleValue();
            xv5 += list.get(x).getVGRecuperable().doubleValue();
            xv6 += list.get(x).getVSaldo().doubleValue();
        }
        this.JTFF_VServicio.setValue(Double.valueOf(xv1));
        this.JTFF_VPagado.setValue(Double.valueOf(xv2));
        this.JTFF_VGlosa.setValue(Double.valueOf(xv3));
        this.JTFF_VGAceptada.setValue(Double.valueOf(xv4));
        this.JTFF_VGRecuperable.setValue(Double.valueOf(xv5));
        this.JTFF_VSaldo.setValue(Double.valueOf(xv6));
        mCalcularDistribucion();
    }

    public void mAnular() {
        if (this.JTBTablas.getSelectedIndex() == 1 && this.JTHistorico.getSelectedRow() != -1) {
            if (Integer.valueOf(this.xModeloH.getValueAt(this.JTHistorico.getSelectedRow(), 7).toString()).intValue() == 0) {
                int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (x == 0) {
                    Anular frm = new Anular(null, true, "GESTIÓN DE PAGOS", 9);
                    frm.setVisible(true);
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No se puede anular;\nFactura con documento contable activo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    public void mAnular(String idMotivoAnulacion, String xMotivo) {
        if (this.JTBTablas.getSelectedIndex() == 1) {
            GCHistoricoPagoDTO e = new GCHistoricoPagoDTO();
            e.setIdAnulado(idMotivoAnulacion);
            e.setMotivoAnulacion(xMotivo);
            e.setFechaAnulado(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
            e.setUsuarioAnulado(Principal.usuarioSistemaDTO.getNombreUsuario());
            e.setEstado(0);
            e.setId(Long.valueOf(this.xModeloH.getValueAt(this.JTHistorico.getSelectedRow(), 0).toString()));
            this.gcuenta.deletePagos(e);
            mCargarDatosHistorico(this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 20).toString());
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFGC_Pagos_Grupal$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Boolean.valueOf(table.getValueAt(row, 27).toString()).booleanValue()) {
                cell.setBackground(Color.RED);
                cell.setForeground(Color.BLACK);
            } else if (Boolean.valueOf(table.getValueAt(row, 8).toString()).booleanValue()) {
                cell.setBackground(new Color(177, 251, 177));
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    public void mCalcularDistribucion() {
        if (this.JTDetalleS.getRowCount() != -1) {
            double xvalor = 0.0d;
            long xNregistro = 0;
            for (int x = 0; x < this.JTDetalleS.getRowCount(); x++) {
                if (Boolean.valueOf(this.xModelo.getValueAt(x, 22).toString()).booleanValue()) {
                    xvalor += Double.valueOf(this.xModelo.getValueAt(x, 21).toString()).doubleValue();
                    xNregistro++;
                }
            }
            this.JTFFNRegistro.setValue(Long.valueOf(xNregistro));
            this.JTFFValorDistribucion.setValue(Double.valueOf(xvalor));
        }
    }

    private void mCambiarEstadoPGlobal() {
        if (!this.JTF_DocP.getText().isEmpty()) {
            this.contabilidad.updateEstadoGlobal_DocContable(this.JTF_DocP.getText());
        }
    }

    public void mGrabar() {
        if (this.JCH_PagoG.isSelected()) {
            if (this.JTDetalleS.getSelectedRow() != -1) {
                if (Objects.equals(Double.valueOf(this.JTFFValorDistribucion.getValue().toString()), Double.valueOf(this.JTFFValorPagado.getValue().toString()))) {
                    if (this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                        if (Principal.xclase.mValidarFechasDoc(this.JDFechaPago.getDate())) {
                            mGrabarD(0);
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JDFechaPago.requestFocus();
                            return;
                        }
                    }
                    if (this.JCH_AplicaMC.isSelected() && !this.JCH_AplicaMP.isSelected()) {
                        if (Principal.xclase.mValidarFechasDoc(this.JDFechaPago.getDate())) {
                            mGrabarD(0);
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JDFechaPago.requestFocus();
                            return;
                        }
                    }
                    if (!this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                        if (Principal.xclase.mValidarFechasDoc(this.JDFechaPago.getDate())) {
                            mGrabarD(0);
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JDFechaPago.requestFocus();
                            return;
                        }
                    }
                    mGrabarD(0);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El valor distribuido es menor al valor pagado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un registro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        if (this.JCBConceptoP.getSelectedIndex() != -1) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTDetalleS, 22)) {
                System.out.println("" + Double.valueOf(this.JTFFValorPagado.getValue().toString()));
                System.out.println("" + Double.valueOf(this.JTFFValorDistribucion.getValue().toString()));
                if (Objects.equals(Double.valueOf(this.JTFFValorDistribucion.getValue().toString()), Double.valueOf(this.JTFFValorPagado.getValue().toString()))) {
                    if (this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                        if (Principal.xclase.mValidarFechasDoc(this.JDFechaPago.getDate())) {
                            mGrabarD(1);
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JDFechaPago.requestFocus();
                            return;
                        }
                    }
                    if (this.JCH_AplicaMC.isSelected() && !this.JCH_AplicaMP.isSelected()) {
                        if (Principal.xclase.mValidarFechasDoc(this.JDFechaPago.getDate())) {
                            mGrabarD(1);
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JDFechaPago.requestFocus();
                            return;
                        }
                    }
                    if (!this.JCH_AplicaMC.isSelected() && this.JCH_AplicaMP.isSelected()) {
                        if (Principal.xclase.mValidarFechasDoc(this.JDFechaPago.getDate())) {
                            mGrabarD(1);
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Fecha fuera del periodo contable", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JDFechaPago.requestFocus();
                            return;
                        }
                    }
                    mGrabarD(1);
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El valor distribuido es menor al valor pagado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una factura", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar concepto de pago", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        this.JTB_DPago.setSelectedIndex(0);
        this.JCBConceptoP.requestFocus();
    }

    private void mGrabarD(int xForma) {
        if (xForma == 0) {
            if (JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                if (this.JCH_AplicaMC.isSelected() && this.nDocumento == 0) {
                    long NConsecutivo = this.contabilidad.mConsultarConsecutivo(this.xIdTipoDocC[this.JCB_TipoDocumentoC.getSelectedIndex()]).longValue();
                    long nDocumento = this.contabilidad.addDocContableEncabezado(this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), this.xIdTipoDocC[this.JCB_TipoDocumentoC.getSelectedIndex()], Long.valueOf(Principal.xclase.getXidperiodoc()), this.JTAObsPago.getText(), Integer.valueOf(this.xEsGlobal), Long.valueOf(NConsecutivo)).longValue();
                    this.contabilidad.addDocContableDetalle(Long.valueOf(nDocumento), this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 18).toString(), 1, Long.valueOf(this.xidempresa[this.JCB_Empresa.getSelectedIndex()]), "0", "0", new Double(0.0d), Double.valueOf(this.JTFFValorPagado.getValue().toString()), this.JTAObsPago.getText());
                    if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                        this.contabilidad.addDocContableDetalle(Long.valueOf(nDocumento), this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 19).toString(), 0, Principal.informacionIps.getIdEmpresa(), "0", "0", Double.valueOf(Double.valueOf(this.JTFFValorPagado.getValue().toString()).doubleValue() - mGrabar_CuentaImpuesto(Double.valueOf(this.JTFFValorPagado.getValue().toString()), this.JTDetalleS.getSelectedRow(), Long.valueOf(nDocumento))), new Double(0.0d), this.JTAObsPago.getText());
                    } else {
                        this.contabilidad.addDocContableDetalle(Long.valueOf(nDocumento), this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 19).toString(), 0, Long.valueOf(this.xidempresa[this.JCB_Empresa.getSelectedIndex()]), "0", "0", Double.valueOf(Double.valueOf(this.JTFFValorPagado.getValue().toString()).doubleValue() - mGrabar_CuentaImpuesto(Double.valueOf(this.JTFFValorPagado.getValue().toString()), this.JTDetalleS.getSelectedRow(), Long.valueOf(nDocumento))), new Double(0.0d), this.JTAObsPago.getText());
                    }
                }
                if (this.JCH_AplicaMP.isSelected()) {
                    if (this.JCH_AplicaMP_Reconocimiento.isSelected()) {
                        long nDocumentosP = this.presupuesto.addMovimientoPpt(Long.valueOf(this.xidperiodoppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0]), this.xIdDocReconocimiento[this.JCBTipoDocReconocimiento.getSelectedIndex()], this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), this.JTAObsPago.getText(), this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 1).toString(), Integer.valueOf(this.xEsGlobal)).longValue();
                        this.presupuesto.addMovimientoDetallePpt(Long.valueOf(nDocumentosP), this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 23).toString(), this.xidperiodoppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1], this.xidempresa[this.JCB_Empresa.getSelectedIndex()], Double.valueOf(this.JTFFValorPagado.getValue().toString()), this.JTAObsPago.getText());
                    }
                    long nDocumentosP1 = this.presupuesto.addMovimientoPpt(Long.valueOf(this.xidperiodoppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0]), this.xIdDocRecaudo[this.JCBTipoDocRecaudo.getSelectedIndex()], this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), this.JTAObsPago.getText(), "0", Integer.valueOf(this.xEsGlobal)).longValue();
                    this.presupuesto.addMovimientoDetallePpt(Long.valueOf(nDocumentosP1), this.xModelo.getValueAt(this.JTDetalleS.getSelectedRow(), 23).toString(), this.xidperiodoppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1], this.xidempresa[this.JCB_Empresa.getSelectedIndex()], Double.valueOf(this.JTFFValorPagado.getValue().toString()), this.JTAObsPago.getText());
                }
                mCambiarEstadoPGlobal();
                mBuscar();
                return;
            }
            return;
        }
        int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar", "CONFIRMAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (x == 0) {
            for (int y = 0; y < this.JTDetalleS.getRowCount(); y++) {
                long nDocumentosP12 = 0;
                if (Boolean.valueOf(this.xModelo.getValueAt(y, 22).toString()).booleanValue()) {
                    long idPago = this.gcuenta.addPagoFactura(String.valueOf(Principal.xclase.getXidperiodoc()), this.xModelo.getValueAt(y, 20).toString(), this.xIdConceptoPago[this.JCBConceptoP.getSelectedIndex()][0], this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), Double.valueOf(this.xModelo.getValueAt(y, 21).toString()).doubleValue(), this.JTFRutaSoportePago.getText(), this.JTAObsPago.getText()).longValue();
                    this.gcuenta.updateDLiquidacionPago(this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), Long.valueOf(this.xModelo.getValueAt(y, 20).toString()));
                    this.gcuenta.updateEstadoFacturaPago("A", this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), Long.valueOf(this.xModelo.getValueAt(y, 20).toString()));
                    if (this.JCH_AplicaMC.isSelected() && this.nDocumento == 0) {
                        long NConsecutivo2 = this.contabilidad.mConsultarConsecutivo(this.xIdTipoDocC[this.JCB_TipoDocumentoC.getSelectedIndex()]).longValue();
                        this.nDocumento = this.contabilidad.addDocContableEncabezado(this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), this.xIdTipoDocC[this.JCB_TipoDocumentoC.getSelectedIndex()], Long.valueOf(Principal.xclase.getXidperiodoc()), this.JTAObsPago.getText(), Integer.valueOf(this.xEsGlobal), Long.valueOf(NConsecutivo2)).longValue();
                        this.contabilidad.addDocContableDetalle(Long.valueOf(this.nDocumento), this.xModelo.getValueAt(y, 18).toString(), 1, Long.valueOf(this.xidempresa[this.JCB_Empresa.getSelectedIndex()]), "0", this.xModelo.getValueAt(y, 1).toString(), new Double(0.0d), Double.valueOf(this.xModelo.getValueAt(y, 21).toString()), this.JTAObsPago.getText());
                        this.contabilidad.addDocContableDetalle(Long.valueOf(this.nDocumento), this.xModelo.getValueAt(y, 19).toString(), 0, Long.valueOf(this.xidempresa[this.JCB_Empresa.getSelectedIndex()]), "0", this.xModelo.getValueAt(y, 1).toString(), Double.valueOf(Double.valueOf(this.xModelo.getValueAt(y, 21).toString()).doubleValue() - mGrabar_CuentaImpuesto(Double.valueOf(this.xModelo.getValueAt(y, 21).toString()), x, Long.valueOf(this.nDocumento))), new Double(0.0d), this.JTAObsPago.getText());
                    }
                    if (this.JCH_AplicaMP.isSelected()) {
                        if (this.JCH_AplicaMP_Reconocimiento.isSelected()) {
                            long nDocumentosP2 = this.presupuesto.addMovimientoPpt(Long.valueOf(this.xidperiodoppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0]), this.xIdDocReconocimiento[this.JCBTipoDocReconocimiento.getSelectedIndex()], this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), this.JTAObsPago.getText(), this.xModelo.getValueAt(y, 1).toString(), Integer.valueOf(this.xEsGlobal)).longValue();
                            this.presupuesto.addMovimientoDetallePpt(Long.valueOf(nDocumentosP2), this.xModelo.getValueAt(y, 23).toString(), this.xidperiodoppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1], this.xidempresa[this.JCB_Empresa.getSelectedIndex()], Double.valueOf(this.xModelo.getValueAt(y, 21).toString()), this.JTAObsPago.getText());
                        }
                        nDocumentosP12 = this.presupuesto.addMovimientoPpt(Long.valueOf(this.xidperiodoppt[this.JCBPeriodo_Ppt.getSelectedIndex()][0]), this.xIdDocRecaudo[this.JCBTipoDocRecaudo.getSelectedIndex()], this.xmt.formatoAMD.format(this.JDFechaPago.getDate()), this.JTAObsPago.getText(), this.xModelo.getValueAt(y, 1).toString(), Integer.valueOf(this.xEsGlobal)).longValue();
                        this.presupuesto.addMovimientoDetallePpt(Long.valueOf(nDocumentosP12), this.xModelo.getValueAt(y, 23).toString(), this.xidperiodoppt[this.JCBPeriodo_Ppt.getSelectedIndex()][1], this.xidempresa[this.JCB_Empresa.getSelectedIndex()], Double.valueOf(this.xModelo.getValueAt(y, 21).toString()), this.JTAObsPago.getText());
                    }
                    this.gcuenta.updateDContablePresupuestalFacturaPago(Long.valueOf(this.nDocumento), Long.valueOf(nDocumentosP12), Long.valueOf(idPago));
                    this.gcuenta.deleteIdLiquidacionTmp(Long.valueOf(this.xModelo.getValueAt(y, 20).toString()));
                }
            }
            mCambiarEstadoPGlobal();
            mBuscar();
        }
    }

    public long getNDocumento() {
        return this.nDocumento;
    }

    public void setnDocumento(long nDocumento) {
        this.nDocumento = nDocumento;
    }

    private double mGrabar_CuentaImpuesto(Double xvalor, int xfila, Long xDocumento) {
        double xvalorr = 0.0d;
        try {
            String xsql = "SELECT `cc_valorxtipo_impuesto`.`Id_Puc`  , `cc_puc`.`Tipo`  , `cc_puc`.`PBaseR`, ((" + xvalor + "*`cc_puc`.`PBaseR`)/100) VP\nFROM `cc_impuestoxempresa` INNER JOIN `cc_valorxtipo_impuesto`  ON (`cc_impuestoxempresa`.`Id_Impuesto` = `cc_valorxtipo_impuesto`.`Id`)\nINNER JOIN `cc_puc`  ON (`cc_valorxtipo_impuesto`.`Id_Puc` = `cc_puc`.`Id`)\nWHERE (cc_impuestoxempresa.`Filtro` IN(-1,1) and `cc_impuestoxempresa`.`Id_Empresa` ='" + this.xidempresa[this.JCB_Empresa.getSelectedIndex()] + "' AND `cc_impuestoxempresa`.`Estado` =1)";
            System.out.println("" + xsql);
            ResultSet xrs = this.xct.traerRs(xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.contabilidad.addDocContableDetalle(xDocumento, xrs.getString("Id_Puc"), 0, Long.valueOf(this.xidempresa[this.JCB_Empresa.getSelectedIndex()]), "0", this.xModelo.getValueAt(xfila, 1).toString(), Double.valueOf(xrs.getDouble("VP")), new Double(0.0d), this.JTAObsPago.getText());
                    xvalorr += xrs.getDouble("VP");
                }
                xrs.close();
                this.xct.cerrarConexionBd();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JIFGC_Pagos_Grupal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xvalorr;
    }

    public void Importar() {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTFRuta.getText().toLowerCase().contains("xlsx")) {
                try {
                    mImportarXLSX();
                    return;
                } catch (IOException ex) {
                    Logger.getLogger(JIFGC_Pagos_Grupal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "La Extencion del Documento es Invalida", "Validación", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        }
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0150: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('fis' java.io.FileInputStream)]) A[TRY_LEAVE], block:B:43:0x0150 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0155: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:45:0x0155 */
    private void mImportarXLSX() throws IOException {
        ArrayList<String> facturaList = new ArrayList<>();
        ArrayList<Double> valorPagarList = new ArrayList<>();
        ArrayList<Double> valorCancelarList = new ArrayList<>();
        try {
            try {
                FileInputStream fis = new FileInputStream(new File(this.JTFRuta.getText()));
                Throwable th = null;
                XSSFWorkbook xSSFWorkbook = new XSSFWorkbook(fis);
                Throwable th2 = null;
                try {
                    try {
                        Sheet sheet = xSSFWorkbook.getSheetAt(0);
                        for (Row row : sheet) {
                            Cell cellNFactura = row.getCell(0);
                            Cell cellValorPagar = row.getCell(1);
                            Cell cellValorCancelar = row.getCell(3);
                            String factura = cellNFactura.getStringCellValue();
                            double valorPagar = cellValorPagar.getNumericCellValue();
                            double valorCancelar = cellValorCancelar.getNumericCellValue();
                            facturaList.add(factura);
                            valorPagarList.add(Double.valueOf(valorPagar));
                            valorCancelarList.add(Double.valueOf(valorCancelar));
                        }
                        if (xSSFWorkbook != null) {
                            if (0 != 0) {
                                try {
                                    xSSFWorkbook.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            } else {
                                xSSFWorkbook.close();
                            }
                        }
                        if (fis != null) {
                            if (0 != 0) {
                                try {
                                    fis.close();
                                } catch (Throwable th4) {
                                    th.addSuppressed(th4);
                                }
                            } else {
                                fis.close();
                            }
                        }
                    } catch (Throwable th5) {
                        if (xSSFWorkbook != null) {
                            if (th2 != null) {
                                try {
                                    xSSFWorkbook.close();
                                } catch (Throwable th6) {
                                    th2.addSuppressed(th6);
                                }
                            } else {
                                xSSFWorkbook.close();
                            }
                        }
                        throw th5;
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.JTDetalleS.getRowCount() > 0) {
            for (int i = 0; i < this.JTDetalleS.getRowCount(); i++) {
                String nFacturaModelo = String.valueOf(this.xModelo.getValueAt(i, 1));
                double valorModelo = Double.parseDouble(this.xModelo.getValueAt(i, 16).toString());
                for (int j = 0; j < facturaList.size(); j++) {
                    String nFactura = facturaList.get(j);
                    double valorPagar2 = valorCancelarList.get(j).doubleValue();
                    if (nFacturaModelo.equals(nFactura)) {
                        if (Double.valueOf(valorPagar2).doubleValue() <= valorModelo) {
                            this.xModelo.setValueAt(Double.valueOf(valorPagar2), i, 21);
                            this.xModelo.setValueAt(false, i, 27);
                        } else {
                            this.xModelo.setValueAt(Double.valueOf(valorPagar2), i, 21);
                            this.xModelo.setValueAt(true, i, 27);
                        }
                        this.xModelo.setValueAt(true, i, 22);
                    }
                }
            }
        }
        mCalcularDistribucion();
    }
}
