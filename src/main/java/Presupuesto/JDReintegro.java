package Presupuesto;

import Acceso.Principal;
import General.ClaseImpresionInformes;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.presupuesto.JIFFMovimiento_new;
import com.genoma.plus.jpa.entities.PpMovimiento;
import com.genoma.plus.jpa.service.IPpMovimientoService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDReintegro.class */
public class JDReintegro extends JDialog {
    private Object xLlamador;
    private DefaultTableModel xmodelo;
    private DefaultTableModel modeloHistorico;
    private JIFFMovimiento xJIFFMovimiento;
    private String[] xIdTipDocumento;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private Metodos xmt;
    private String[][] xIdDocumento;
    private int xConsecutivo;
    private String xIdClase;
    private final IPpMovimientoService movimientoService;
    private List<PpMovimiento> listaMovimiento;
    private Long idMovimiento;
    private List<String> listaDatos;
    private JIFFMovimiento_new fFMovimiento_new;
    private JIFCompromisoPresupuestal jIFCompromisoPresupuestal;
    private String idDisponibilidad;
    private String idCompromiso;
    private JButton JBGrabar;
    private JComboBox JCBTipoDocumento;
    private JDateChooser JDFFechaI;
    private JFormattedTextField JFTFValorTotal;
    public JLabel JLCodigoDoc;
    private JPanel JPI_Datos;
    private JPanel JPI_Historico;
    private JPanel JPI_Registro;
    private JScrollPane JSP_Historico;
    private JTable JTDetalle;
    private JTable JTDetalleHistorico;
    private JTextField JTFObservacion;
    private JTabbedPane JTP_Datos;
    private JScrollPane jScrollPane1;

    public JDReintegro(Frame parent, boolean modal, Object xLlamador, String xIdClase) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xConsecutivo = 0;
        this.listaDatos = new ArrayList();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.movimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        this.listaMovimiento = new ArrayList();
        this.xLlamador = xLlamador;
        mCasting(xLlamador);
        initComponents();
        if (xIdClase.equals("4")) {
            this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=13 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
        } else {
            this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=11 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
        }
        this.xIdClase = xIdClase;
        this.xct.cerrarConexionBd();
        this.JCBTipoDocumento.setSelectedIndex(-1);
        setLocationRelativeTo(null);
        mLlenaElementos();
        mLlenaTabla();
        mTotaliza();
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
    }

    public JDReintegro(Frame parent, boolean modal, Object xLlamador, String xIdClase, String idDisponibilidad, String idCompromiso) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xConsecutivo = 0;
        this.listaDatos = new ArrayList();
        this.jIFCompromisoPresupuestal = (JIFCompromisoPresupuestal) xLlamador;
        this.idDisponibilidad = idDisponibilidad;
        this.idCompromiso = idCompromiso;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.movimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        this.listaMovimiento = new ArrayList();
        this.xLlamador = xLlamador;
        mCasting(xLlamador);
        initComponents();
        if (xIdClase.equals("4")) {
            this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=13 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
        } else {
            this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=11 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
        }
        this.xIdClase = xIdClase;
        this.xct.cerrarConexionBd();
        this.JCBTipoDocumento.setSelectedIndex(-1);
        setLocationRelativeTo(null);
        mLlenaElementos();
        mLlenaTabla();
        mTotaliza();
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
    }

    public JDReintegro(Frame parent, boolean modal, Object xLlamador, String xIdClase, Long idDisponibilidad, List<String> listaDatos) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xConsecutivo = 0;
        this.listaDatos = new ArrayList();
        this.fFMovimiento_new = (JIFFMovimiento_new) xLlamador;
        this.xLlamador = xLlamador;
        this.listaDatos = listaDatos;
        this.idMovimiento = idDisponibilidad;
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        this.movimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        this.listaMovimiento = new ArrayList();
        mCasting(xLlamador);
        initComponents();
        if (xIdClase.equals("4")) {
            this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=13 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
        } else {
            this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=11 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
        }
        this.xIdClase = xIdClase;
        this.xct.cerrarConexionBd();
        this.JCBTipoDocumento.setSelectedIndex(-1);
        setLocationRelativeTo(null);
        mLlenaElementos();
        mLlenaTablaNuevo();
        mTotaliza();
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r3v27, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v61, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Registro = new JPanel();
        this.JPI_Datos = new JPanel();
        this.JCBTipoDocumento = new JComboBox();
        this.JLCodigoDoc = new JLabel();
        this.JDFFechaI = new JDateChooser();
        this.jScrollPane1 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JTFObservacion = new JTextField();
        this.JFTFValorTotal = new JFormattedTextField();
        this.JBGrabar = new JButton();
        this.JPI_Historico = new JPanel();
        this.JSP_Historico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setDefaultCloseOperation(2);
        setTitle("REINTEGRO AUTOMÁTICO");
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_Datos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JDReintegro.1
            public void itemStateChanged(ItemEvent evt) {
                JDReintegro.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 0, 13));
        GroupLayout JPI_DatosLayout = new GroupLayout(this.JPI_Datos);
        this.JPI_Datos.setLayout(JPI_DatosLayout);
        JPI_DatosLayout.setHorizontalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCodigoDoc, -2, 125, -2).addContainerGap()));
        JPI_DatosLayout.setVerticalGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_DatosLayout.createSequentialGroup().addGroup(JPI_DatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDocumento, -2, 50, -2).addComponent(this.JLCodigoDoc, -2, 50, -2).addComponent(this.JDFFechaI, -2, 50, -2)).addGap(0, 16, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.jScrollPane1.setViewportView(this.JTDetalle);
        this.JTFObservacion.setFont(new Font("Arial", 1, 12));
        this.JTFObservacion.setToolTipText("");
        this.JTFObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValorTotal.setEditable(false);
        this.JFTFValorTotal.setBorder(BorderFactory.createTitledBorder((Border) null, "TOTAL", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorTotal.setForeground(Color.red);
        this.JFTFValorTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorTotal.setHorizontalAlignment(0);
        this.JFTFValorTotal.setText("0");
        this.JFTFValorTotal.setFont(new Font("Arial", 1, 14));
        this.JBGrabar.setFont(new Font("Arial", 1, 14));
        this.JBGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGrabar.setText("Guardar");
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Presupuesto.JDReintegro.2
            public void actionPerformed(ActionEvent evt) {
                JDReintegro.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout JPI_RegistroLayout = new GroupLayout(this.JPI_Registro);
        this.JPI_Registro.setLayout(JPI_RegistroLayout);
        JPI_RegistroLayout.setHorizontalGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPI_Datos, -1, -1, 32767).addComponent(this.jScrollPane1).addGroup(GroupLayout.Alignment.TRAILING, JPI_RegistroLayout.createSequentialGroup().addComponent(this.JTFObservacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorTotal, -2, 169, -2)).addComponent(this.JBGrabar, -1, -1, 32767)).addContainerGap()));
        JPI_RegistroLayout.setVerticalGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_Datos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JFTFValorTotal, -2, 52, -2).addGroup(JPI_RegistroLayout.createSequentialGroup().addComponent(this.JTFObservacion, -2, 51, -2).addGap(1, 1, 1))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBGrabar, -2, 48, -2).addContainerGap(21, 32767)));
        this.JTP_Datos.addTab("REGISTRO", this.JPI_Registro);
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(Color.white);
        this.JTDetalleHistorico.setSelectionForeground(Color.red);
        this.JTDetalleHistorico.setSelectionMode(0);
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDReintegro.3
            public void mouseClicked(MouseEvent evt) {
                JDReintegro.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JTDetalleHistorico.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDReintegro.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDReintegro.this.JTDetalleHistoricoPropertyChange(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 632, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico).addContainerGap())));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 401, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico, -1, 389, 32767).addContainerGap())));
        this.JTP_Datos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
            mGrabaNuevo();
        } else {
            mGraba();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.imprmirAdicionesReintegroIndividual(this.JTDetalleHistorico.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString(), this.xmt.formatoMoneda.format(Double.valueOf(this.JTDetalleHistorico.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 4).toString())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.Rubro", "Nombre Rubro", "Valor", "IdTercero"}) { // from class: Presupuesto.JDReintegro.5
            Class[] types = {String.class, String.class, Double.class, String.class};
            boolean[] canEdit = {false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    private void mCasting(Object xLlamador) {
        if (xLlamador.getClass().getSimpleName().equals("JIFFMovimiento")) {
            this.xJIFFMovimiento = (JIFFMovimiento) xLlamador;
            this.xLlamador = xLlamador.getClass().getSimpleName();
        }
    }

    private void mLlenaElementos() {
        System.out.println("Llamador-->" + this.xLlamador.getClass().getSimpleName());
        if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
            this.JLCodigoDoc.setText("" + this.idMovimiento);
        } else if (this.xLlamador.equals("JIFFMovimiento")) {
            this.JLCodigoDoc.setText("" + this.xJIFFMovimiento.JLCodigoDoc.getText());
            this.idMovimiento = Long.valueOf(this.xJIFFMovimiento.xMovimiento);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosHistorico() {
        this.modeloHistorico = new DefaultTableModel(new Object[0], new String[]{"id", "fecha", "NoConsecutivo", "Observación", "Valor"}) { // from class: Presupuesto.JDReintegro.6
            Class[] types = {Long.class, Date.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setAutoResizeMode(0);
        this.JTDetalleHistorico.doLayout();
        this.JTDetalleHistorico.setModel(this.modeloHistorico);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(300);
        this.JTDetalleHistorico.getColumnModel().getColumn(4).setPreferredWidth(100);
    }

    private void mLlenaTabla() {
        mCrearModeloDatos();
        if (this.xLlamador.getClass().getSimpleName().equals("JIFCompromisoPresupuestal")) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(this.jIFCompromisoPresupuestal.modeloCompromiso.getValueAt(this.jIFCompromisoPresupuestal.JTDetalle.getSelectedRow(), 0).toString(), 0, 0);
            this.xmodelo.setValueAt(this.jIFCompromisoPresupuestal.modeloCompromiso.getValueAt(this.jIFCompromisoPresupuestal.JTDetalle.getSelectedRow(), 1).toString(), 0, 1);
            this.xmodelo.setValueAt(Double.valueOf(this.jIFCompromisoPresupuestal.modeloCompromiso.getValueAt(this.jIFCompromisoPresupuestal.JTDetalle.getSelectedRow(), 4).toString()), 0, 2);
            this.xmodelo.setValueAt(Principal.informacionIps.getIdEmpresa(), 0, 3);
            int i = 0 + 1;
        } else {
            if (this.xJIFFMovimiento.getTitle().equals("DISPONIBILIDAD PRESUPUESTAL")) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 1).toString(), 0, 0);
                this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 2).toString(), 0, 1);
                this.xmodelo.setValueAt(Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 8).toString()), 0, 2);
                this.xmodelo.setValueAt(Principal.informacionIps.getIdEmpresa(), 0, 3);
                int i2 = 0 + 1;
            } else if (Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 11).toString()).doubleValue() > 0.0d) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 1).toString(), 0, 0);
                this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 2).toString(), 0, 1);
                this.xmodelo.setValueAt(Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 11).toString()), 0, 2);
                this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 4).toString(), 0, 3);
                int i3 = 0 + 1;
            } else if (Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 9).toString()).equals(Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 3).toString()))) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 1).toString(), 0, 0);
                this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 2).toString(), 0, 1);
                this.xmodelo.setValueAt(Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 3).toString()), 0, 2);
                this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(this.xJIFFMovimiento.JTDetalle.getSelectedRow(), 4).toString(), 0, 3);
                int i4 = 0 + 1;
            }
            if (this.xJIFFMovimiento.xIdClaseDoc.equals("9")) {
                this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdDisponibilidadIdClaseDocumento(this.idMovimiento, 11);
            } else {
                this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdCompromisoIdClaseDocumento(this.idMovimiento, 13);
            }
        }
        crearModeloDatosHistorico();
        if (!this.listaMovimiento.isEmpty() && this.listaMovimiento != null) {
            this.xmt.mEstablecerTextEditor(this.JTDetalleHistorico, 3);
            this.listaMovimiento.forEach(p -> {
                this.modeloHistorico.addRow(this.xdatos);
                this.modeloHistorico.setValueAt(p.getId(), this.JTDetalleHistorico.getRowCount() - 1, 0);
                this.modeloHistorico.setValueAt(p.getFechaD(), this.JTDetalleHistorico.getRowCount() - 1, 1);
                this.modeloHistorico.setValueAt(Integer.valueOf(p.getNoConcecutivo()), this.JTDetalleHistorico.getRowCount() - 1, 2);
                this.modeloHistorico.setValueAt(p.getObservacion(), this.JTDetalleHistorico.getRowCount() - 1, 3);
                double valor = p.getPpDetalleMovimientoCollection().stream().mapToDouble(e -> {
                    return e.getValor();
                }).sum();
                this.modeloHistorico.setValueAt(Double.valueOf(valor), this.JTDetalleHistorico.getRowCount() - 1, 4);
            });
        }
    }

    private void mLlenaTablaNuevo() {
        mCrearModeloDatos();
        if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
            this.xmodelo.addRow(this.xdatos);
            this.xmodelo.setValueAt(this.listaDatos.get(0), 0, 0);
            this.xmodelo.setValueAt(this.listaDatos.get(1), 0, 1);
            this.xmodelo.setValueAt(Double.valueOf(this.listaDatos.get(7).toString()), 0, 2);
            this.xmodelo.setValueAt(Principal.informacionIps.getIdEmpresa(), 0, 3);
            int i = 0 + 1;
        }
        if (this.xIdClase.equals("9")) {
            this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdDisponibilidadIdClaseDocumento(this.idMovimiento, 11);
        } else {
            this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdCompromisoIdClaseDocumento(this.idMovimiento, 13);
        }
        crearModeloDatosHistorico();
        if (!this.listaMovimiento.isEmpty() && this.listaMovimiento != null) {
            this.xmt.mEstablecerTextEditor(this.JTDetalleHistorico, 3);
            this.listaMovimiento.forEach(p -> {
                this.modeloHistorico.addRow(this.xdatos);
                this.modeloHistorico.setValueAt(p.getId(), this.JTDetalleHistorico.getRowCount() - 1, 0);
                this.modeloHistorico.setValueAt(p.getFechaD(), this.JTDetalleHistorico.getRowCount() - 1, 1);
                this.modeloHistorico.setValueAt(Integer.valueOf(p.getNoConcecutivo()), this.JTDetalleHistorico.getRowCount() - 1, 2);
                this.modeloHistorico.setValueAt(p.getObservacion(), this.JTDetalleHistorico.getRowCount() - 1, 3);
                double valor = p.getPpDetalleMovimientoCollection().stream().mapToDouble(e -> {
                    return e.getValor();
                }).sum();
                this.modeloHistorico.setValueAt(Double.valueOf(valor), this.JTDetalleHistorico.getRowCount() - 1, 4);
            });
        }
    }

    private void mGraba() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.JDFFechaI.getDate()))) {
            if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    mConcecutivo();
                    String sql = "";
                    if (this.xJIFFMovimiento != null) {
                        if (this.xJIFFMovimiento.getTitle().equals("DISPONIBILIDAD PRESUPUESTAL")) {
                            sql = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`         ,  NoConcecutivo         ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.xJIFFMovimiento.xIdMovDisponibilidad + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        } else {
                            sql = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`\t    , `IdCompromiso`         ,  NoConcecutivo         ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.xJIFFMovimiento.xIdMovDisponibilidad + "'\t    , '" + this.xJIFFMovimiento.xMovimiento + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        }
                    } else if (this.jIFCompromisoPresupuestal != null) {
                        sql = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`\t    , `IdCompromiso`         ,  NoConcecutivo         ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.idDisponibilidad + "'\t    , '" + this.idCompromiso + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    }
                    System.out.println("Inserta Encabezado Reintegro-->" + sql);
                    String xidReintegro = this.xct.ejecutarSQLId(sql);
                    this.xct.cerrarConexionBd();
                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                        String sql2 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`,                                          `Id_Rubro`,                                          `Id_Tercero`,                                          `Valor`,                                           `Observacion`,                                            idEncabezado)\n VALUES ('" + xidReintegro + "', '" + this.xmodelo.getValueAt(i, 0) + "', '" + this.xmodelo.getValueAt(i, 3) + "', '" + this.xmodelo.getValueAt(i, 2) + "', '" + this.JTFObservacion.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                        System.out.println("Inserta detalle Reintegro-->" + sql2);
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                    }
                    if (this.xJIFFMovimiento != null) {
                        this.xJIFFMovimiento.mBuscaMovimiento(this.xJIFFMovimiento.xMovimiento);
                    } else {
                        this.jIFCompromisoPresupuestal.buscaMovimientoCompromiso(this.jIFCompromisoPresupuestal.movimiento, this.idDisponibilidad);
                    }
                    dispose();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
        }
    }

    private void mGrabaNuevo() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.JDFFechaI.getDate()))) {
            if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    mConcecutivo();
                    String sql = "";
                    if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
                        sql = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`         ,  NoConcecutivo         ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '18'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.idMovimiento + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    }
                    String xidReintegro = this.xct.ejecutarSQLId(sql);
                    this.xct.cerrarConexionBd();
                    for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                        String sql2 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`,idEncabezado)\n VALUES ('" + xidReintegro + "', '" + this.xmodelo.getValueAt(i, 0) + "', '" + this.xmodelo.getValueAt(i, 3) + "', '" + this.xmodelo.getValueAt(i, 2) + "', '" + this.JTFObservacion.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                        System.out.println("Inserta detalle Reintegro-->" + sql2);
                        this.xct.ejecutarSQL(sql2);
                        this.xct.cerrarConexionBd();
                    }
                    dispose();
                    this.fFMovimiento_new.nuevo();
                    return;
                }
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
        }
    }

    private void mTotaliza() {
        double total = 0.0d;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            total += Double.valueOf(this.xmodelo.getValueAt(i, 2).toString()).doubleValue();
        }
        this.JFTFValorTotal.setValue(Double.valueOf(total));
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = null;
        if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
            sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , MAX(`pp_movimiento`.`NoConcecutivo`) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='11'  AND  pp_tipo_documentos.`Id`=11 and DATE_FORMAT(pp_movimiento.`FechaD`,'%Y')='" + this.xmt.formatoANO.format(this.JDFFechaI.getDate()) + "') group by  `pp_tipo_documentos`.`Id_ClaseDoc` ";
        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento") || this.xLlamador.getClass().getSimpleName().equals("JIFCompromisoPresupuestal")) {
            sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` ,   COALESCE(MAX(`pp_movimiento`.`NoConcecutivo`), 1) AS MaximoCons \nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (`pp_tipo_documentos`.`Id_ClaseDoc` ='11'  OR  pp_tipo_documentos.`Id`='" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "' and DATE_FORMAT(pp_movimiento.`FechaD`,'%Y')='" + this.xmt.formatoANO.format(this.JDFFechaI.getDate()) + "') group by  `pp_tipo_documentos`.`Id_ClaseDoc` ";
        }
        System.out.println("consecutivo -> " + sql);
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }
}
