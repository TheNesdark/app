package com.genoma.plus.controller.gcuenta;

import Acceso.Principal;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.CcDetalleDocumentoc;
import com.genoma.plus.jpa.entities.CcDocumentoc;
import com.genoma.plus.jpa.entities.CcPeriodoContable;
import com.genoma.plus.jpa.entities.CcPuc;
import com.genoma.plus.jpa.entities.CcTipoDocumentoc;
import com.genoma.plus.jpa.entities.EmpresaContConvenioEntity;
import com.genoma.plus.jpa.entities.FFacturaEvento;
import com.genoma.plus.jpa.entities.LiquidacionEntity;
import com.genoma.plus.jpa.service.ICcTipoDocumentocService;
import com.genoma.plus.jpa.service.IEmpresaContConvenioService;
import com.genoma.plus.jpa.service.ILiquidacionService;
import com.genoma.plus.utils.UtilidadesGenericas;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.math.BigInteger;
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
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
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
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/gcuenta/JIFRadicacionMasiva.class */
public class JIFRadicacionMasiva extends JInternalFrame {
    private final Metodos metodo = new Metodos();
    private DefaultTableModel modeloTable;
    private File file;
    private File directorio;
    private final UtilidadesGenericas utilidadesGenericas;
    private List<LiquidacionEntity> listFacturasVenta;
    private List<EmpresaContConvenioEntity> listEmpresaConvenio;
    private List<CcTipoDocumentoc> listTipoDocumento;
    private List<Object[]> listCuentaCobro;
    private final ILiquidacionService liquidacionService;
    private final IEmpresaContConvenioService empresaContConvenioService;
    private final ICcTipoDocumentocService tipoDocumentocService;
    private boolean lleno;
    private ButtonGroup JBG_Filtro;
    private JButton JBTExportar;
    private JButton JBTExportar1;
    private JComboBox JCBTipoC;
    private JComboBox JCB_CuentaCobro;
    private JComboBox JCB_Empresa;
    private JCheckBox JCH_AplicaMC;
    private JDateChooser JDFechaEnt;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaRad;
    private JLabel JLB_NRegistro;
    private JPanel JPITipoSeleccion;
    private JPanel JPI_Consulta;
    private JPanel JPI_DatosContables;
    private JPanel JPI_Utilidades;
    private JRadioButton JRBDeseleccionarTodo;
    private JRadioButton JRBSelecionarTodo;
    private JScrollPane JSPDetalleS;
    private JScrollPane JSPObsRadicacion;
    private JTextPane JTAObsRadicacion;
    public JTable JTDetalleS;
    private JTextField JTFRuta;
    private JTextField JTFRutaSoporteRad;
    private JTabbedPane JTPDatos;

    public JIFRadicacionMasiva() {
        initComponents();
        this.utilidadesGenericas = new UtilidadesGenericas();
        this.liquidacionService = (ILiquidacionService) Principal.contexto.getBean(ILiquidacionService.class);
        this.empresaContConvenioService = (IEmpresaContConvenioService) Principal.contexto.getBean(IEmpresaContConvenioService.class);
        this.tipoDocumentocService = (ICcTipoDocumentocService) Principal.contexto.getBean(ICcTipoDocumentocService.class);
        nuevo();
    }

    /* JADX WARN: Type inference failed for: r3v41, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBG_Filtro = new ButtonGroup();
        this.JPI_Consulta = new JPanel();
        this.JCB_Empresa = new JComboBox();
        this.JDFechaF = new JDateChooser();
        this.JDFechaEnt = new JDateChooser();
        this.JDFechaRad = new JDateChooser();
        this.JTFRutaSoporteRad = new JTextField();
        this.JSPObsRadicacion = new JScrollPane();
        this.JTAObsRadicacion = new JTextPane();
        this.JLB_NRegistro = new JLabel();
        this.JCB_CuentaCobro = new JComboBox();
        this.JSPDetalleS = new JScrollPane();
        this.JTDetalleS = new JTable();
        this.JTPDatos = new JTabbedPane();
        this.JPI_DatosContables = new JPanel();
        this.JCBTipoC = new JComboBox();
        this.JCH_AplicaMC = new JCheckBox();
        this.JPITipoSeleccion = new JPanel();
        this.JRBSelecionarTodo = new JRadioButton();
        this.JRBDeseleccionarTodo = new JRadioButton();
        this.JPI_Utilidades = new JPanel();
        this.JTFRuta = new JTextField();
        this.JBTExportar = new JButton();
        this.JBTExportar1 = new JButton();
        setClosable(true);
        setIconifiable(true);
        setTitle("RADICACIÓN MASIVA DE FACTURAS");
        setFont(new Font("Arial", 1, 14));
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("jifradicacionmasivafacturas");
        this.JPI_Consulta.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA CONSULTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCB_Empresa.setFont(new Font("Arial", 1, 12));
        this.JCB_Empresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_Empresa.setName("convenioEmpresaArmada");
        this.JCB_Empresa.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva.1
            public void itemStateChanged(ItemEvent evt) {
                JIFRadicacionMasiva.this.JCB_EmpresaItemStateChanged(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaEnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Entrega", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaEnt.setDateFormatString("dd/MM/yyyy");
        this.JDFechaEnt.setFont(new Font("Arial", 1, 12));
        this.JDFechaRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Radicado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaRad.setDateFormatString("dd/MM/yyyy");
        this.JDFechaRad.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoporteRad.setFont(new Font("Arial", 1, 12));
        this.JTFRutaSoporteRad.setBorder(BorderFactory.createTitledBorder((Border) null, "Ruta Soporte", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRutaSoporteRad.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva.2
            public void mouseClicked(MouseEvent evt) {
                JIFRadicacionMasiva.this.JTFRutaSoporteRadMouseClicked(evt);
            }
        });
        this.JSPObsRadicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTAObsRadicacion.setFont(new Font("Arial", 1, 12));
        this.JSPObsRadicacion.setViewportView(this.JTAObsRadicacion);
        this.JLB_NRegistro.setFont(new Font("Arial", 1, 12));
        this.JLB_NRegistro.setHorizontalAlignment(0);
        this.JLB_NRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "No Registros", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCB_CuentaCobro.setFont(new Font("Arial", 1, 12));
        this.JCB_CuentaCobro.setBorder(BorderFactory.createTitledBorder((Border) null, "Cuenta Cobro", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCB_CuentaCobro.setCursor(new Cursor(0));
        this.JCB_CuentaCobro.setName("cuentaCobro");
        GroupLayout JPI_ConsultaLayout = new GroupLayout(this.JPI_Consulta);
        this.JPI_Consulta.setLayout(JPI_ConsultaLayout);
        JPI_ConsultaLayout.setHorizontalGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_ConsultaLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsultaLayout.createSequentialGroup().addComponent(this.JDFechaF, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, 32767).addComponent(this.JCB_Empresa, -2, 574, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCB_CuentaCobro, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLB_NRegistro, -2, 125, -2)).addGroup(JPI_ConsultaLayout.createSequentialGroup().addComponent(this.JDFechaRad, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JDFechaEnt, -2, 130, -2).addGap(36, 36, 36).addComponent(this.JSPObsRadicacion)).addComponent(this.JTFRutaSoporteRad)).addGap(26, 26, 26)));
        JPI_ConsultaLayout.setVerticalGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ConsultaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_ConsultaLayout.createSequentialGroup().addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCB_Empresa, -2, 52, -2).addComponent(this.JLB_NRegistro, -2, 50, -2).addComponent(this.JCB_CuentaCobro, -2, 52, -2)).addComponent(this.JDFechaF, GroupLayout.Alignment.LEADING, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObsRadicacion, -2, 50, -2)).addGroup(JPI_ConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDFechaRad, -2, 50, -2).addComponent(this.JDFechaEnt, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFRutaSoporteRad, -2, 50, -2).addContainerGap(-1, 32767)));
        this.JSPDetalleS.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JSPDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setFont(new Font("Arial", 1, 12));
        this.JTDetalleS.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleS.setEditingColumn(1);
        this.JTDetalleS.setEditingRow(1);
        this.JTDetalleS.setRowHeight(25);
        this.JTDetalleS.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleS.setSelectionForeground(Color.red);
        this.JSPDetalleS.setViewportView(this.JTDetalleS);
        this.JTPDatos.setForeground(new Color(0, 103, 0));
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.setName("tipoDocumentoC");
        this.JCH_AplicaMC.setFont(new Font("Arial", 1, 12));
        this.JCH_AplicaMC.setText("Aplica?");
        this.JPITipoSeleccion.setBorder(BorderFactory.createTitledBorder((Border) null, "Seleccionar?", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBG_Filtro.add(this.JRBSelecionarTodo);
        this.JRBSelecionarTodo.setFont(new Font("Arial", 1, 12));
        this.JRBSelecionarTodo.setSelected(true);
        this.JRBSelecionarTodo.setText("Todo");
        this.JRBSelecionarTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva.3
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionMasiva.this.JRBSelecionarTodoActionPerformed(evt);
            }
        });
        this.JBG_Filtro.add(this.JRBDeseleccionarTodo);
        this.JRBDeseleccionarTodo.setFont(new Font("Arial", 1, 12));
        this.JRBDeseleccionarTodo.setText("Ninguno");
        this.JRBDeseleccionarTodo.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva.4
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionMasiva.this.JRBDeseleccionarTodoActionPerformed(evt);
            }
        });
        GroupLayout JPITipoSeleccionLayout = new GroupLayout(this.JPITipoSeleccion);
        this.JPITipoSeleccion.setLayout(JPITipoSeleccionLayout);
        JPITipoSeleccionLayout.setHorizontalGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSelecionarTodo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBDeseleccionarTodo).addContainerGap(26, 32767)));
        JPITipoSeleccionLayout.setVerticalGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoSeleccionLayout.createSequentialGroup().addGroup(JPITipoSeleccionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSelecionarTodo).addComponent(this.JRBDeseleccionarTodo)).addGap(0, 0, 32767)));
        GroupLayout JPI_DatosContablesLayout = new GroupLayout(this.JPI_DatosContables);
        this.JPI_DatosContables.setLayout(JPI_DatosContablesLayout);
        JPI_DatosContablesLayout.setHorizontalGroup(JPI_DatosContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosContablesLayout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.JCH_AplicaMC).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoC, -2, 429, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 298, 32767).addComponent(this.JPITipoSeleccion, -2, -1, -2).addGap(15, 15, 15)));
        JPI_DatosContablesLayout.setVerticalGroup(JPI_DatosContablesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosContablesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_DatosContablesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPITipoSeleccion, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPI_DatosContablesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JCH_AplicaMC))).addContainerGap(13, 32767)));
        this.JTPDatos.addTab("INFORMACIÓN CONTABLE", this.JPI_DatosContables);
        this.JTFRuta.setFont(new Font("Arial", 1, 12));
        this.JTFRuta.setText("C:\\Genoma\\plantilla");
        this.JTFRuta.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de archivo a exportar", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFRuta.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva.5
            public void mouseClicked(MouseEvent evt) {
                JIFRadicacionMasiva.this.JTFRutaMouseClicked(evt);
            }
        });
        this.JBTExportar.setFont(new Font("Arial", 1, 12));
        this.JBTExportar.setForeground(Color.red);
        this.JBTExportar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Excel_Icono24x24.png")));
        this.JBTExportar.setText("Exportar");
        this.JBTExportar.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva.6
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionMasiva.this.JBTExportarActionPerformed(evt);
            }
        });
        this.JBTExportar1.setFont(new Font("Arial", 1, 12));
        this.JBTExportar1.setForeground(Color.red);
        this.JBTExportar1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTExportar1.setText("Limpiar");
        this.JBTExportar1.setToolTipText("Limpiar información de radicado");
        this.JBTExportar1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva.7
            public void actionPerformed(ActionEvent evt) {
                JIFRadicacionMasiva.this.JBTExportar1ActionPerformed(evt);
            }
        });
        GroupLayout JPI_UtilidadesLayout = new GroupLayout(this.JPI_Utilidades);
        this.JPI_Utilidades.setLayout(JPI_UtilidadesLayout);
        JPI_UtilidadesLayout.setHorizontalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFRuta, -2, 423, -2).addGap(18, 18, 18).addComponent(this.JBTExportar, -2, 221, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTExportar1, -2, 221, -2).addContainerGap()));
        JPI_UtilidadesLayout.setVerticalGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_UtilidadesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFRuta, -2, 50, -2).addGroup(JPI_UtilidadesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTExportar, -2, 50, -2).addComponent(this.JBTExportar1, -2, 50, -2))).addContainerGap(13, 32767)));
        this.JTPDatos.addTab("UTILIDADES", this.JPI_Utilidades);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Consulta, -2, -1, -2).addComponent(this.JSPDetalleS, -2, 1054, -2).addComponent(this.JTPDatos, -2, 1054, -2)).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Consulta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleS, -1, 309, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos, -2, 115, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFRutaSoporteRadMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            if (this.JTFRutaSoporteRad.getText().isEmpty()) {
                JFileChooser xfilec = new JFileChooser("S:\\FACTURACION\\");
                int xv = xfilec.showOpenDialog(this);
                if (xv == 0) {
                    this.file = xfilec.getSelectedFile();
                    this.JTFRutaSoporteRad.setText(this.file.getAbsolutePath());
                    this.JTFRutaSoporteRad.setText(this.metodo.mTraerUrlBD(this.file.getAbsolutePath()));
                    return;
                }
                return;
            }
            Object[] botones = {"Visualizar", "Cargar", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer?", "SOPORTE", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.metodo.mostrarPdf(this.JTFRutaSoporteRad.getText());
                return;
            }
            JFileChooser xfilec2 = new JFileChooser("S:\\FACTURACION\\");
            int xv2 = xfilec2.showOpenDialog(this);
            if (xv2 == 0) {
                this.file = xfilec2.getSelectedFile();
                this.JTFRutaSoporteRad.setText(this.file.getAbsolutePath());
                this.JTFRutaSoporteRad.setText(this.metodo.mTraerUrlBD(this.file.getAbsolutePath()));
            }
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
                this.JTFRuta.setText(xfile.getAbsolutePath() + this.metodo.getBarra());
                this.JTFRuta.requestFocus();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportarActionPerformed(ActionEvent evt) {
        if (!this.JTFRuta.getText().isEmpty()) {
            if (this.JTDetalleS.getRowCount() > -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de exportar la información", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.metodo.mExportar_Datos_Tabla_Titulo_Formato(this.JTDetalleS, this.metodo.mTraerUrlBD(this.JTFRuta.getText()), getTitle());
                    return;
                }
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un ruta valida", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFRuta.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTExportar1ActionPerformed(ActionEvent evt) {
        for (int i = 0; i < this.JTDetalleS.getRowCount(); i++) {
            this.modeloTable.setValueAt("", i, 4);
            this.modeloTable.setValueAt((Object) null, i, 5);
            this.modeloTable.setValueAt((Object) null, i, 6);
            this.modeloTable.setValueAt("", i, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSelecionarTodoActionPerformed(ActionEvent evt) {
        modificarEstadoenTabla(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDeseleccionarTodoActionPerformed(ActionEvent evt) {
        modificarEstadoenTabla(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCB_EmpresaItemStateChanged(ItemEvent evt) {
        if (this.JCB_Empresa.getSelectedIndex() != -1 && this.lleno) {
            crearModeloHistorico();
            this.JLB_NRegistro.setText("");
            this.listCuentaCobro = new ArrayList();
            this.listCuentaCobro = this.liquidacionService.listaCuentaCobroPorConvenio(this.listEmpresaConvenio.get(this.JCB_Empresa.getSelectedIndex()).getId());
            this.utilidadesGenericas.llenarCombo(this.JCB_CuentaCobro, this.listCuentaCobro);
        }
    }

    public void nuevo() {
        this.lleno = false;
        this.JDFechaF.setDate(this.metodo.getFechaActual());
        this.JDFechaEnt.setDate(this.metodo.getFechaActual());
        this.JDFechaRad.setDate(this.metodo.getFechaActual());
        this.JTFRuta.setText(this.metodo.getDirectorioExportacion() + "Planilla");
        crearModeloHistorico();
        this.listFacturasVenta = new ArrayList();
        this.listEmpresaConvenio = new ArrayList();
        this.listTipoDocumento = new ArrayList();
        this.listTipoDocumento = this.tipoDocumentocService.listaTipoDocumentosPorEstadoOrdernadoNombreAsc(true, true);
        this.listEmpresaConvenio = this.empresaContConvenioService.listaConvenioPorEstadoRadicacion();
        this.utilidadesGenericas.llenarCombo(this.JCB_Empresa, this.listEmpresaConvenio);
        this.utilidadesGenericas.llenarCombo(this.JCBTipoC, this.listTipoDocumento);
        if (Principal.informacionIps.getManejaContabilidad().intValue() == 1) {
            this.JCH_AplicaMC.setSelected(true);
        }
        this.JDFechaF.requestFocus();
        this.lleno = true;
    }

    public void buscar() {
        if (this.JCB_Empresa.getSelectedIndex() != -1) {
            if (this.JCB_CuentaCobro.getSelectedIndex() != -1) {
                crearModeloHistorico();
                this.listFacturasVenta = this.liquidacionService.listaLiquidacionFacturaEventoCuentaCobro(Integer.valueOf(this.JCB_CuentaCobro.getSelectedItem().toString()), this.listEmpresaConvenio.get(this.JCB_Empresa.getSelectedIndex()).getId());
                if (!this.listFacturasVenta.isEmpty()) {
                    this.listFacturasVenta.forEach(e -> {
                        this.modeloTable.addRow((Object[]) null);
                        e.getFFacturaEventoCollection().forEach(f -> {
                            this.modeloTable.setValueAt(true, this.JTDetalleS.getRowCount() - 1, 0);
                            this.modeloTable.setValueAt(f.getPrefijo() + f.getNoFacturaeventoM(), this.JTDetalleS.getRowCount() - 1, 1);
                            this.modeloTable.setValueAt(f.getFechaFacturaevento(), this.JTDetalleS.getRowCount() - 1, 2);
                            this.modeloTable.setValueAt(f.getNRadicado(), this.JTDetalleS.getRowCount() - 1, 4);
                            this.modeloTable.setValueAt(f.getFechaEntrega(), this.JTDetalleS.getRowCount() - 1, 5);
                            this.modeloTable.setValueAt(f.getFechaRadicado(), this.JTDetalleS.getRowCount() - 1, 6);
                            this.modeloTable.setValueAt(f.getObservacionRad(), this.JTDetalleS.getRowCount() - 1, 7);
                            if (f.getNRadicado().isEmpty() || f.getNRadicado() == null) {
                                this.modeloTable.setValueAt(false, this.JTDetalleS.getRowCount() - 1, 11);
                            } else {
                                this.modeloTable.setValueAt(true, this.JTDetalleS.getRowCount() - 1, 11);
                            }
                        });
                        this.modeloTable.setValueAt(e.getIdSubGrupoServicio().getSubgruposervicioEntity().getNbre(), this.JTDetalleS.getRowCount() - 1, 3);
                        this.modeloTable.setValueAt(Double.valueOf(e.getTotalEps()), this.JTDetalleS.getRowCount() - 1, 8);
                        this.modeloTable.setValueAt(e.getIdSubGrupoServicio().getCPucCreditoR(), this.JTDetalleS.getRowCount() - 1, 9);
                        this.modeloTable.setValueAt(e.getIdSubGrupoServicio().getCPucDebitoR(), this.JTDetalleS.getRowCount() - 1, 10);
                    });
                    this.JLB_NRegistro.setText("" + this.listFacturasVenta.size());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una cuenta de cobro", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JCB_CuentaCobro.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un convenio", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
        this.JCB_Empresa.requestFocus();
    }

    private void crearModeloHistorico() {
        this.modeloTable = new DefaultTableModel() { // from class: com.genoma.plus.controller.gcuenta.JIFRadicacionMasiva.8
            Class[] types = {Boolean.class, String.class, Date.class, String.class, String.class, Date.class, Date.class, String.class, Double.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {true, false, false, false, true, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return this.canEdit[colIndex];
            }
        };
        this.modeloTable.addColumn("S");
        this.modeloTable.addColumn("No Factura");
        this.modeloTable.addColumn("Fecha Factura");
        this.modeloTable.addColumn("Servicio");
        this.modeloTable.addColumn("No Radicado");
        this.modeloTable.addColumn("Fecha Entrega");
        this.modeloTable.addColumn("Fecha Radicado");
        this.modeloTable.addColumn("Observacion");
        this.modeloTable.addColumn("Valor");
        this.modeloTable.addColumn("Cuenta_Puc_Credito");
        this.modeloTable.addColumn("Cuenta_Puc_CDebito");
        this.modeloTable.addColumn("Radicada?");
        this.JTDetalleS.setAutoResizeMode(0);
        this.JTDetalleS.doLayout();
        this.JTDetalleS.setModel(this.modeloTable);
        this.JTDetalleS.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleS.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleS.getColumnModel().getColumn(7).setPreferredWidth(500);
        this.JTDetalleS.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(9).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(10).setPreferredWidth(200);
        this.JTDetalleS.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    public void grabar() {
        if (this.JTDetalleS.getRowCount() > 0) {
            if (!this.metodo.mVerificarDatosLLeno(this.JTDetalleS, 3, 0)) {
                int y = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (y == 0) {
                    if (this.JCH_AplicaMC.isSelected()) {
                        if (this.JCBTipoC.getSelectedIndex() != -1) {
                            grabarBaseDatos();
                            return;
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                            this.JCBTipoC.requestFocus();
                            return;
                        }
                    }
                    grabarBaseDatos();
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "No existe información en columna de radicado", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No existe información en la tabla para grabar", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
    }

    private void modificarEstadoenTabla(boolean b) {
        for (int i = 0; i < this.JTDetalleS.getRowCount(); i++) {
            this.modeloTable.setValueAt(Boolean.valueOf(b), i, 0);
        }
    }

    private void grabarBaseDatos() {
        if (this.JTDetalleS.isEditing()) {
            this.JTDetalleS.getCellEditor().stopCellEditing();
        }
        List<CcDocumentoc> documentocs = new ArrayList<>();
        CcPeriodoContable periodoContable = new CcPeriodoContable();
        periodoContable.setId(Long.valueOf(Principal.xclase.getXidperiodoc()));
        for (int i = 0; i < this.JTDetalleS.getRowCount(); i++) {
            System.out.println("" + this.listFacturasVenta.get(i).getFFacturaEventoCollection().size());
            List<FFacturaEvento> f = (List) this.listFacturasVenta.get(i).getFFacturaEventoCollection();
            FFacturaEvento m = f.get(0);
            m.setFechaRadicado(this.JDFechaRad.getDate());
            m.setFechaEntrega(this.JDFechaEnt.getDate());
            m.setObservacionRad(this.JTAObsRadicacion.getText());
            m.setNRadicado(this.JTDetalleS.getValueAt(i, 4).toString());
            m.setIndicador("A");
            List<FFacturaEvento> fn = new ArrayList<>();
            fn.add(m);
            this.listFacturasVenta.get(i).setFFacturaEventoCollection(fn);
            if (!Boolean.valueOf(this.JTDetalleS.getValueAt(i, 11).toString()).booleanValue()) {
                String concepto = "RADICACIÓN FACTURA DE VENTA N° " + this.JTDetalleS.getValueAt(i, 1).toString();
                CcDocumentoc d = new CcDocumentoc();
                List<CcDetalleDocumentoc> listDetalle = new ArrayList<>();
                CcDetalleDocumentoc debito = new CcDetalleDocumentoc();
                CcDetalleDocumentoc credito = new CcDetalleDocumentoc();
                d.setNConsecutivo(BigInteger.ONE);
                d.setAprobadoA(false);
                d.setDescripcion(concepto);
                d.setEjecutado(false);
                d.setEsGlobal(false);
                d.setEstado(true);
                d.setEstadoA(false);
                d.setExportadoC(false);
                d.setFecha(this.metodo.getFechaActual());
                d.setFechaD(this.JDFechaF.getDate());
                d.setGenerarC(false);
                d.setIdCertificado(0);
                d.setIdCierreCaja(0);
                d.setIdConcepto(0);
                d.setIdCuentaCobro(Integer.valueOf(this.JCB_CuentaCobro.getSelectedItem().toString()));
                d.setIdCuentaEmpresa(0);
                d.setIdCuentaEmpresaP(0);
                d.setIdNomina(BigInteger.ZERO);
                d.setIdPeriodoC(periodoContable);
                d.setIdRadicacion(BigInteger.ZERO);
                d.setIdTipoComprobante(this.listTipoDocumento.get(this.JCBTipoC.getSelectedIndex()));
                d.setNCheque("");
                d.setRevisadoC(false);
                d.setTipoPago(-1);
                d.setUsuarioAnulacion("");
                d.setIdAnulado(0);
                d.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                CcPuc cpd = new CcPuc();
                cpd.setId(this.JTDetalleS.getValueAt(i, 10).toString());
                debito.setBase(new Double(0.0d));
                debito.setConcepto(concepto);
                debito.setEstado(1);
                debito.setIdCertificado(0);
                debito.setIdConceptoN(0);
                debito.setIdDocumentoc(d);
                debito.setIdPuc(cpd);
                debito.setIdRadicacion(0);
                debito.setIdTercero(this.listEmpresaConvenio.get(this.JCB_Empresa.getSelectedIndex()).getIdEmpresaCont());
                debito.setNFactura(this.JTDetalleS.getValueAt(i, 1).toString());
                debito.setPRetencion(new Double(0.0d));
                debito.setTipoCPuc(0);
                debito.setVCredito(new Double(0.0d));
                debito.setVDebito(Double.valueOf(this.JTDetalleS.getValueAt(i, 8).toString()));
                listDetalle.add(debito);
                CcPuc cpc = new CcPuc();
                cpc.setId(this.JTDetalleS.getValueAt(i, 9).toString());
                credito.setBase(new Double(0.0d));
                credito.setConcepto(concepto);
                credito.setEstado(1);
                credito.setIdCertificado(0);
                credito.setIdConceptoN(0);
                credito.setIdDocumentoc(d);
                credito.setIdPuc(cpc);
                credito.setIdRadicacion(0);
                credito.setIdTercero(this.listEmpresaConvenio.get(this.JCB_Empresa.getSelectedIndex()).getIdEmpresaCont());
                credito.setNFactura(this.JTDetalleS.getValueAt(i, 1).toString());
                credito.setPRetencion(new Double(0.0d));
                credito.setTipoCPuc(1);
                credito.setVCredito(Double.valueOf(this.JTDetalleS.getValueAt(i, 8).toString()));
                credito.setVDebito(new Double(0.0d));
                listDetalle.add(credito);
                d.setCcDetalleDocumentocCollection(listDetalle);
                documentocs.add(d);
            }
        }
        Integer idTipoDocumento = 0;
        if (this.JCH_AplicaMC.isSelected() && this.JCBTipoC.getSelectedIndex() != -1) {
            idTipoDocumento = this.listTipoDocumento.get(this.JCBTipoC.getSelectedIndex()).getId();
        }
        this.liquidacionService.grabarConDocumentoContable(this.listFacturasVenta, documentocs, idTipoDocumento, Integer.valueOf(this.JCB_CuentaCobro.getSelectedItem().toString()));
    }
}
