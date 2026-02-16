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

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JDAdiciones.class */
public class JDAdiciones extends JDialog {
    private Object xLlamador;
    private DefaultTableModel xmodelo;
    private DefaultTableModel modeloHistorico;
    private JIFFMovimiento xJIFFMovimiento;
    private JIFFCarguePTOInicial xJIFFCarguePTOInicial;
    private String[] xIdTipDocumento;
    private ConsultasMySQL xct;
    private Object[] xdatos;
    private Metodos xmt;
    private boolean xLleno;
    private int xConsecutivo;
    private String[][] xIdDocumento;
    private final IPpMovimientoService movimientoService;
    private List<PpMovimiento> listaMovimiento;
    private Long idMovimiento;
    private JIFFMovimiento_new fFMovimiento_new;
    private String idCDocumento;
    private List<String[]> listaDatos;
    private String idDisponibilidad;
    private JButton JBGrabar;
    private JComboBox JCBTipoDocumento;
    private JDateChooser JDFFechaI;
    private JFormattedTextField JFTFValorTotal;
    public JLabel JLCodigoDoc;
    private JPanel JPI_Historico;
    private JPanel JPI_Registro;
    private JScrollPane JSP_Historico;
    private JTable JTDetalle;
    private JTable JTDetalleHistorico;
    private JTextField JTFObservacion;
    private JTabbedPane JTP_Datos;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public JDAdiciones(Frame parent, boolean modal, Object xLlamador) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xLleno = false;
        this.xConsecutivo = 0;
        this.listaDatos = new ArrayList();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        initComponents();
        this.movimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        this.listaMovimiento = new ArrayList();
        this.xLlamador = xLlamador;
        System.out.println("---------------- " + this.xLlamador.getClass().getName());
        mCasting(xLlamador);
        setLocationRelativeTo(null);
        mIniciaComponentes();
        mLlenaTabla();
        mTotaliza();
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
    }

    public JDAdiciones(Frame parent, boolean modal, Object xLlamador, String idClaseD, List<String[]> listaDatos, String idDisponibilidad) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xLleno = false;
        this.xConsecutivo = 0;
        this.listaDatos = new ArrayList();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        initComponents();
        this.idDisponibilidad = idDisponibilidad;
        this.listaDatos = listaDatos;
        this.idCDocumento = idClaseD;
        this.movimientoService = (IPpMovimientoService) Principal.contexto.getBean(IPpMovimientoService.class);
        this.listaMovimiento = new ArrayList();
        this.xLlamador = xLlamador;
        System.out.println("---------------- " + this.xLlamador.getClass().getName());
        mCasting(xLlamador);
        setLocationRelativeTo(null);
        mIniciaComponentes();
        mLlenaTabla();
        mTotaliza();
        this.JDFFechaI.setDate(this.xmt.getFechaActual());
    }

    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v63, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTP_Datos = new JTabbedPane();
        this.JPI_Registro = new JPanel();
        this.jPanel1 = new JPanel();
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
        this.JTP_Datos.setForeground(new Color(0, 103, 0));
        this.JTP_Datos.setFont(new Font("Arial", 1, 14));
        this.JPI_Registro.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBTipoDocumento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDocumento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoDocumento.addItemListener(new ItemListener() { // from class: Presupuesto.JDAdiciones.1
            public void itemStateChanged(ItemEvent evt) {
                JDAdiciones.this.JCBTipoDocumentoItemStateChanged(evt);
            }
        });
        this.JLCodigoDoc.setFont(new Font("Tahoma", 1, 14));
        this.JLCodigoDoc.setForeground(Color.red);
        this.JLCodigoDoc.setHorizontalAlignment(0);
        this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "Cód. Documento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaI.setFont(new Font("Arial", 0, 13));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JDFFechaI, -2, 121, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoDocumento, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLCodigoDoc, -2, 125, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDocumento, -2, 50, -2).addComponent(this.JLCodigoDoc, -2, 50, -2).addComponent(this.JDFFechaI, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.jScrollPane1.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalle.setSelectionBackground(Color.white);
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDAdiciones.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDAdiciones.this.JTDetallePropertyChange(evt);
            }
        });
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
        this.JBGrabar.addActionListener(new ActionListener() { // from class: Presupuesto.JDAdiciones.3
            public void actionPerformed(ActionEvent evt) {
                JDAdiciones.this.JBGrabarActionPerformed(evt);
            }
        });
        GroupLayout JPI_RegistroLayout = new GroupLayout(this.JPI_Registro);
        this.JPI_Registro.setLayout(JPI_RegistroLayout);
        JPI_RegistroLayout.setHorizontalGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 594, 32767).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createSequentialGroup().addContainerGap().addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBGrabar, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jScrollPane1).addGroup(GroupLayout.Alignment.TRAILING, JPI_RegistroLayout.createSequentialGroup().addComponent(this.JTFObservacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorTotal, -2, 169, -2))).addContainerGap())));
        JPI_RegistroLayout.setVerticalGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 373, 32767).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_RegistroLayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_RegistroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JFTFValorTotal, -2, 52, -2).addComponent(this.JTFObservacion, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBGrabar, -2, 50, -2).addContainerGap())));
        this.JTP_Datos.addTab("REGISTRO", this.JPI_Registro);
        this.JSP_Historico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(Color.white);
        this.JTDetalleHistorico.setSelectionForeground(Color.red);
        this.JTDetalleHistorico.setSelectionMode(0);
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JDAdiciones.4
            public void mouseClicked(MouseEvent evt) {
                JDAdiciones.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JTDetalleHistorico.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JDAdiciones.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDAdiciones.this.JTDetalleHistoricoPropertyChange(evt);
            }
        });
        this.JSP_Historico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 594, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico).addContainerGap())));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 361, 32767).addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSP_Historico, -1, 349, 32767).addContainerGap())));
        this.JTP_Datos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTP_Datos, -2, 407, -2).addContainerGap(-1, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoDocumentoItemStateChanged(ItemEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGrabarActionPerformed(ActionEvent evt) {
        mGraba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle.getRowCount() > -1 && this.xLleno) {
            mTotaliza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            ClaseImpresionInformes impresionInformes = new ClaseImpresionInformes();
            impresionInformes.imprmirAdicionesReintegroIndividual(this.JTDetalleHistorico.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 0).toString(), this.xmt.formatoMoneda.format(Double.valueOf(this.JTDetalleHistorico.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 4).toString())));
        }
    }

    private void mIniciaComponentes() {
        System.out.println("xllamador ->" + this.xLlamador);
        System.out.println("xllamador -> -----> " + this.xLlamador.getClass().getSimpleName());
        if (this.xLlamador.equals("JIFFMovimiento")) {
            if (this.xJIFFMovimiento.xIdClaseDoc.equals("4")) {
                this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=12 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
                this.xct.cerrarConexionBd();
                this.JCBTipoDocumento.setSelectedIndex(-1);
                setTitle("ADICIONES COMPROMISO No." + Principal.txtNo.getText());
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Compro.", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JLCodigoDoc.setText("" + Principal.txtNo.getText());
                return;
            }
            if (this.xJIFFMovimiento.xIdClaseDoc.equals("9")) {
                this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=10 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
                this.xct.cerrarConexionBd();
                this.JCBTipoDocumento.setSelectedIndex(-1);
                setTitle("ADICIONES DISPONIBILIDAD No." + Principal.txtNo.getText());
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Dispo.", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JLCodigoDoc.setText("" + Principal.txtNo.getText());
                return;
            }
            return;
        }
        if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
            if (this.idCDocumento.equals("4")) {
                this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=12 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
                this.xct.cerrarConexionBd();
                this.JCBTipoDocumento.setSelectedIndex(-1);
                setTitle("ADICIONES COMPROMISO No." + Principal.txtNo.getText());
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Compro.", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JLCodigoDoc.setText("" + Principal.txtNo.getText());
                return;
            }
            if (this.idCDocumento.equals("9")) {
                this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=10 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
                this.xct.cerrarConexionBd();
                this.JCBTipoDocumento.setSelectedIndex(-1);
                setTitle("ADICIONES DISPONIBILIDAD No." + Principal.txtNo.getText());
                this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Dispo.", 0, 0, new Font("Arial", 1, 12), Color.blue));
                this.JLCodigoDoc.setText("" + Principal.txtNo.getText());
                return;
            }
            return;
        }
        if (this.xLlamador.equals("JIFFCarguePTOInicial")) {
            this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=8 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
            this.xct.cerrarConexionBd();
            this.JCBTipoDocumento.setSelectedIndex(-1);
        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFCompromisoPresupuestal")) {
            this.xIdTipDocumento = this.xct.llenarCombo("SELECT `Id`,`Nbre` FROM  `pp_tipo_documentos` WHERE `Id_ClaseDoc`=12 AND `Estado`=1", this.xIdTipDocumento, this.JCBTipoDocumento);
            this.xct.cerrarConexionBd();
            this.JCBTipoDocumento.setSelectedIndex(-1);
            setTitle("ADICIONES COMPROMISO No." + Principal.txtNo.getText());
            this.JLCodigoDoc.setBorder(BorderFactory.createTitledBorder((Border) null, "No. Compro.", 0, 0, new Font("Arial", 1, 12), Color.blue));
            this.JLCodigoDoc.setText(Principal.txtNo.getText());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cod.Rubro", "Nombre Rubro", "Valor", "Adición", "IdTercero"}) { // from class: Presupuesto.JDAdiciones.6
            Class[] types = {String.class, String.class, Double.class, Double.class, String.class};
            boolean[] canEdit = {false, false, false, true, false};

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
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloDatosHistorico() {
        this.modeloHistorico = new DefaultTableModel(new Object[0], new String[]{"id", "fecha", "NoConsecutivo", "Observación", "Valor"}) { // from class: Presupuesto.JDAdiciones.7
            Class[] types = {Long.class, Date.class, String.class, String.class, Double.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleHistorico;
        JTable jTable2 = this.JTDetalle;
        jTable.setAutoResizeMode(0);
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
        if (this.xLlamador.equals("JIFFMovimiento")) {
            for (int i = 0; i < this.xJIFFMovimiento.JTDetalle.getRowCount(); i++) {
                if (this.xJIFFMovimiento.xIdClaseDoc.equals("9")) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(i, 1), i, 0);
                    this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(i, 2), i, 1);
                    this.xmodelo.setValueAt(Double.valueOf((Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(i, 3).toString()).doubleValue() + Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(i, 5).toString()).doubleValue()) - Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(i, 6).toString()).doubleValue()), i, 2);
                    this.xmodelo.setValueAt(0, i, 3);
                    this.xmodelo.setValueAt(Principal.informacionIps.getIdEmpresa(), i, 4);
                } else if (this.xJIFFMovimiento.xIdClaseDoc.equals("4")) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(i, 1), i, 0);
                    this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(i, 2), i, 1);
                    this.xmodelo.setValueAt(Double.valueOf(Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(i, 3).toString()).doubleValue() + Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(i, 10).toString()).doubleValue()), i, 2);
                    this.xmodelo.setValueAt(Double.valueOf(this.xJIFFMovimiento.xmodelo.getValueAt(i, 11).toString()), i, 3);
                    this.xmodelo.setValueAt(this.xJIFFMovimiento.xmodelo.getValueAt(i, 4).toString(), i, 4);
                }
            }
            System.out.println(" numeor " + this.idMovimiento);
            if (this.xJIFFMovimiento.xIdClaseDoc.equals("9")) {
                this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdDisponibilidadIdClaseDocumento(this.idMovimiento, 10);
            } else {
                this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdCompromisoIdClaseDocumento(this.idMovimiento, 12);
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
        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
            for (int i2 = 0; i2 < this.listaDatos.size(); i2++) {
                String[] fila = this.listaDatos.get(i2);
                this.xmodelo.addRow(fila);
                this.xmodelo.setValueAt(fila[0], i2, 0);
                this.xmodelo.setValueAt(fila[1], i2, 1);
                double valor = Double.valueOf(fila[2]).doubleValue();
                double valorA = Double.valueOf(fila[4]).doubleValue();
                double valorR = Double.valueOf(fila[5]).doubleValue();
                this.xmodelo.setValueAt(Double.valueOf((valor + valorA) - valorR), i2, 2);
                this.xmodelo.setValueAt(0, i2, 3);
                this.xmodelo.setValueAt(Principal.informacionIps.getIdEmpresa(), i2, 4);
            }
            if (this.idCDocumento.equals("9")) {
                this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdDisponibilidadIdClaseDocumento(Long.valueOf(this.idDisponibilidad), 10);
            } else {
                this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdCompromisoIdClaseDocumento(Long.valueOf(this.idDisponibilidad), 12);
            }
            crearModeloDatosHistorico();
            if (!this.listaMovimiento.isEmpty() && this.listaMovimiento != null) {
                this.xmt.mEstablecerTextEditor(this.JTDetalleHistorico, 3);
                System.out.println("this.listaMovimiento.size() -> " + this.listaMovimiento.size());
                this.listaMovimiento.forEach(p2 -> {
                    this.modeloHistorico.addRow(this.xdatos);
                    this.modeloHistorico.setValueAt(p2.getId(), this.JTDetalleHistorico.getRowCount() - 1, 0);
                    this.modeloHistorico.setValueAt(p2.getFechaD(), this.JTDetalleHistorico.getRowCount() - 1, 1);
                    this.modeloHistorico.setValueAt(Integer.valueOf(p2.getNoConcecutivo()), this.JTDetalleHistorico.getRowCount() - 1, 2);
                    this.modeloHistorico.setValueAt(p2.getObservacion(), this.JTDetalleHistorico.getRowCount() - 1, 3);
                    double valor2 = p2.getPpDetalleMovimientoCollection().stream().mapToDouble(e -> {
                        return e.getValor();
                    }).sum();
                    this.modeloHistorico.setValueAt(Double.valueOf(valor2), this.JTDetalleHistorico.getRowCount() - 1, 4);
                });
            }
        } else if (this.xLlamador.equals("JIFFCarguePTOInicial")) {
            for (int i3 = 0; i3 < this.xJIFFCarguePTOInicial.JTDetalle.getRowCount(); i3++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(this.xJIFFCarguePTOInicial.xmodelo.getValueAt(i3, 0), i3, 0);
                this.xmodelo.setValueAt(this.xJIFFCarguePTOInicial.xmodelo.getValueAt(i3, 2), i3, 1);
                this.xmodelo.setValueAt(Double.valueOf(this.xJIFFCarguePTOInicial.xmodelo.getValueAt(i3, 3).toString()), i3, 2);
                this.xmodelo.setValueAt(0, i3, 3);
                this.xmodelo.setValueAt(Principal.informacionIps.getIdEmpresa(), i3, 4);
            }
        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFCompromisoPresupuestal")) {
            for (int i4 = 0; i4 < this.listaDatos.size(); i4++) {
                String[] fila2 = this.listaDatos.get(i4);
                this.xmodelo.addRow(fila2);
                this.xmodelo.setValueAt(fila2[0], i4, 0);
                this.xmodelo.setValueAt(fila2[1], i4, 1);
                double valor2 = Double.valueOf(fila2[2]).doubleValue();
                double valorA2 = Double.valueOf(fila2[4]).doubleValue();
                double valorR2 = Double.valueOf(fila2[5]).doubleValue();
                this.xmodelo.setValueAt(Double.valueOf((valor2 + valorA2) - valorR2), i4, 2);
                this.xmodelo.setValueAt(0, i4, 3);
                this.xmodelo.setValueAt(Principal.informacionIps.getIdEmpresa(), i4, 4);
            }
            this.listaMovimiento = this.movimientoService.buscarMovimientoPorIdCompromisoIdClaseDocumento(Long.valueOf(this.idDisponibilidad), 12);
            crearModeloDatosHistorico();
            if (!this.listaMovimiento.isEmpty() && this.listaMovimiento != null) {
                this.xmt.mEstablecerTextEditor(this.JTDetalleHistorico, 3);
                System.out.println("this.listaMovimiento.size() -> " + this.listaMovimiento.size());
                this.listaMovimiento.forEach(p3 -> {
                    this.modeloHistorico.addRow(this.xdatos);
                    this.modeloHistorico.setValueAt(p3.getId(), this.JTDetalleHistorico.getRowCount() - 1, 0);
                    this.modeloHistorico.setValueAt(p3.getFechaD(), this.JTDetalleHistorico.getRowCount() - 1, 1);
                    this.modeloHistorico.setValueAt(Integer.valueOf(p3.getNoConcecutivo()), this.JTDetalleHistorico.getRowCount() - 1, 2);
                    this.modeloHistorico.setValueAt(p3.getObservacion(), this.JTDetalleHistorico.getRowCount() - 1, 3);
                    double valor3 = p3.getPpDetalleMovimientoCollection().stream().mapToDouble(e -> {
                        return e.getValor();
                    }).sum();
                    this.modeloHistorico.setValueAt(Double.valueOf(valor3), this.JTDetalleHistorico.getRowCount() - 1, 4);
                });
            }
        }
        this.xLleno = true;
    }

    private void mTotaliza() {
        double total = 0.0d;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            total = total + Double.valueOf(this.xmodelo.getValueAt(i, 2).toString()).doubleValue() + Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue();
        }
        this.JFTFValorTotal.setValue(Double.valueOf(total));
    }

    private void mGraba() {
        if (this.xmt.mVerificaFecha_PeriodoPresupuesto(this.xmt.formatoAMD.format(this.JDFFechaI.getDate()))) {
            if (this.JCBTipoDocumento.getSelectedIndex() > -1) {
                if (mVerificaSaldoAdicion()) {
                    int n = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        mConcecutivo();
                        if (this.xLlamador.equals("JIFFMovimiento")) {
                            String xidReintegro = "";
                            if (this.xJIFFMovimiento.xIdClaseDoc.equals("9")) {
                                String sql = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`         ,  NoConcecutivo         ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.xJIFFMovimiento.xIdMovDisponibilidad + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                System.out.println("Inserta Encabezado Adicion Disponibilidad-->" + sql);
                                xidReintegro = this.xct.ejecutarSQLId(sql);
                                this.xct.cerrarConexionBd();
                            } else if (this.xJIFFMovimiento.xIdClaseDoc.equals("4")) {
                                String sql2 = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`\t    , `IdCompromiso`     ,  NoConcecutivo     ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.xJIFFMovimiento.xIdMovDisponibilidad + "'\t    , '" + this.xJIFFMovimiento.xMovimiento + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                System.out.println("Inserta Encabezado Adicion Compromiso-->" + sql2);
                                xidReintegro = this.xct.ejecutarSQLId(sql2);
                                this.xct.cerrarConexionBd();
                            }
                            for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                if (Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue() != 0.0d) {
                                    String sql22 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`,idEncabezado)\n VALUES ('" + xidReintegro + "', '" + this.xmodelo.getValueAt(i, 0) + "', '" + this.xmodelo.getValueAt(i, 4) + "', '" + this.xmodelo.getValueAt(i, 3) + "', '" + this.JTFObservacion.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                    System.out.println("Inserta detalle Adicion-->" + sql22);
                                    this.xct.ejecutarSQL(sql22);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            if (this.xJIFFMovimiento.xIdClaseDoc.equals("9")) {
                                this.xJIFFMovimiento.mBuscaMovimiento(Integer.valueOf(this.xJIFFMovimiento.xIdMovDisponibilidad).toString());
                            } else if (this.xJIFFMovimiento.xIdClaseDoc.equals("4")) {
                                this.xJIFFMovimiento.mBuscaMovimiento(this.xJIFFMovimiento.xMovimiento);
                            }
                        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
                            String xidReintegro2 = "";
                            if (this.idCDocumento.equals("9")) {
                                String sql3 = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`         ,  NoConcecutivo         ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + Integer.parseInt(this.idDisponibilidad.toString()) + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                System.out.println("Inserta Encabezado Adicion Disponibilidad-->" + sql3);
                                xidReintegro2 = this.xct.ejecutarSQLId(sql3);
                                this.xct.cerrarConexionBd();
                            } else if (this.idCDocumento.equals("4")) {
                                String sql4 = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`     ,  NoConcecutivo     ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + Integer.parseInt(this.idDisponibilidad) + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                                System.out.println("Inserta Encabezado Adicion Compromiso-->" + sql4);
                                xidReintegro2 = this.xct.ejecutarSQLId(sql4);
                                this.xct.cerrarConexionBd();
                            }
                            for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                                if (Double.valueOf(this.xmodelo.getValueAt(i2, 3).toString()).doubleValue() != 0.0d) {
                                    String sql23 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`,idEncabezado)\n VALUES ('" + xidReintegro2 + "', '" + this.xmodelo.getValueAt(i2, 0) + "', '" + this.xmodelo.getValueAt(i2, 4) + "', '" + this.xmodelo.getValueAt(i2, 3) + "', '" + this.JTFObservacion.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                    System.out.println("Inserta detalle Adicion-->" + sql23);
                                    this.xct.ejecutarSQL(sql23);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        } else if (this.xLlamador.equals("JIFFCarguePTOInicial")) {
                            String sql5 = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`         , NoConcecutivo          ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                            System.out.println("Inserta Encabezado Adicion-->" + sql5);
                            String xidAdicion = this.xct.ejecutarSQLId(sql5);
                            this.xct.cerrarConexionBd();
                            for (int i3 = 0; i3 < this.JTDetalle.getRowCount(); i3++) {
                                if (Double.valueOf(this.xmodelo.getValueAt(i3, 3).toString()).doubleValue() != 0.0d) {
                                    String sql24 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`, idEncabezado)\n VALUES ('" + xidAdicion + "', '" + this.xmodelo.getValueAt(i3, 0) + "', '" + Principal.informacionIps.getIdEmpresa() + "', '" + this.xmodelo.getValueAt(i3, 3) + "', '" + this.JTFObservacion.getText() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                    System.out.println("Inserta detalle Adicion-->" + sql24);
                                    this.xct.ejecutarSQL(sql24);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            this.xJIFFCarguePTOInicial.mBuscaMovimiento(Principal.txtNo.getText());
                        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
                            String sql6 = "INSERT INTO  `pp_movimiento`            (`Id_Periodo`\t    , `Id_TipoDoc`\t    , `FechaD`\t    , `Observacion`\t    , `IdUsuarioR`\t    , `IdDisponibilidad`\t    , `IdCompromiso`     ,  NoConcecutivo     ,  `UsuarioS`) VALUES ('" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "'\t    , '" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "'\t    , '" + this.xmt.formatoAMD.format(this.JDFFechaI.getDate()) + "'\t    , '" + this.JTFObservacion.getText() + "'\t    , '" + Principal.usuarioSistemaDTO.getIdPersonaCargo() + "'\t    , '" + this.xJIFFMovimiento.xIdMovDisponibilidad + "'\t    , '" + this.xJIFFMovimiento.xMovimiento + "'\t    , '" + this.xConsecutivo + "'          ,'" + Principal.usuarioSistemaDTO.getLogin() + "');";
                            System.out.println("Inserta Encabezado Adicion Compromiso-->" + sql6);
                            String idAdicion = this.xct.ejecutarSQLId(sql6);
                            this.xct.cerrarConexionBd();
                            for (int i4 = 0; i4 < this.JTDetalle.getRowCount(); i4++) {
                                if (Double.valueOf(this.xmodelo.getValueAt(i4, 3).toString()).doubleValue() != 0.0d) {
                                    String sql25 = "INSERT INTO  `pp_detalle_movimiento` (`Id_Movimiento`, `Id_Rubro`, `Id_Tercero`, `Valor`,  `Observacion`,idEncabezado)\n VALUES ('" + idAdicion + "', '" + this.xmodelo.getValueAt(i4, 0) + "', '" + this.xmodelo.getValueAt(i4, 4) + "', '" + this.xmodelo.getValueAt(i4, 3) + "', '" + this.JTFObservacion.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' );";
                                    System.out.println("Inserta detalle Adicion-->" + sql25);
                                    this.xct.ejecutarSQL(sql25);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        }
                        dispose();
                        return;
                    }
                    return;
                }
                JOptionPane.showMessageDialog(this, "Debe digitar por lo menos un saldo en el rubro para la Adición", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Tipo de Documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoDocumento.requestFocus();
        }
    }

    private boolean mVerificaSaldoAdicion() {
        boolean saldo = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalle.getRowCount()) {
                break;
            }
            if (Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue() == 0.0d) {
                i++;
            } else {
                saldo = true;
                break;
            }
        }
        return saldo;
    }

    private void mCasting(Object xLlamador) {
        if (xLlamador.getClass().getSimpleName().equals("JIFFMovimiento")) {
            this.xJIFFMovimiento = (JIFFMovimiento) xLlamador;
            this.xLlamador = xLlamador.getClass().getSimpleName();
            this.idMovimiento = Long.valueOf(this.xJIFFMovimiento.xMovimiento);
        } else if (xLlamador.getClass().getSimpleName().equals("xjifMovimientoPPTO_N")) {
            this.fFMovimiento_new = (JIFFMovimiento_new) xLlamador;
            this.xLlamador = xLlamador.getClass().getSimpleName();
            this.idMovimiento = Long.valueOf(this.fFMovimiento_new.xMovimiento);
        } else if (xLlamador.getClass().getSimpleName().equals("JIFFCarguePTOInicial")) {
            this.xJIFFCarguePTOInicial = (JIFFCarguePTOInicial) xLlamador;
            this.xLlamador = xLlamador.getClass().getSimpleName();
        } else if (this.xLlamador.getClass().getSimpleName().equals("JIFFMovimiento_new")) {
            this.fFMovimiento_new = (JIFFMovimiento_new) xLlamador;
        }
    }

    private void mConcecutivo() {
        int Con = 0;
        String sql = "SELECT `pp_tipo_documentos`.`Id_ClaseDoc` , MAX(`pp_movimiento`.`NoConcecutivo`) AS MaximoCons\nFROM `pp_movimiento`\nINNER JOIN  `pp_tipo_documentos`  ON (`pp_movimiento`.`Id_TipoDoc` = `pp_tipo_documentos`.`Id`)\nWHERE (  pp_tipo_documentos.`Id`='" + this.xIdTipDocumento[this.JCBTipoDocumento.getSelectedIndex()] + "');";
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
