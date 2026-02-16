package Presupuesto;

import Acceso.Principal;
import Contabilidad.JIFConsultarDatosV;
import General.Anular;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.presupuesto.PresupuestoDAOImpl;
import com.genoma.plus.dao.presupuesto.PresupuestoDAO;
import com.genoma.plus.dto.presupuesto.MovimientoDetalleDTO;
import com.genoma.plus.dto.presupuesto.SolicitudDTO;
import com.genoma.plus.dto.presupuesto.SolicitudDetalleDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Presupuesto/JIFFSolicitudPTO_v2.class */
public class JIFFSolicitudPTO_v2 extends JInternalFrame {
    public String[][] xidunidadfuncional;
    private JIFConsultarDatosV xjifbuscarorden;
    private long xConsecutivo;
    private String[][] xidtipodoccontable;
    private String[] xIdRubros;
    public DefaultTableModel xmodelo;
    private Object[] xdatos;
    public PresupuestoDAO presupuestoDAO;
    private JButton JBAdicionar;
    private JButton JBAjusteValor;
    private JComboBox JCBRubros;
    private JComboBox JCBTipoC;
    public JComboBox JCBUnidadF;
    private JDateChooser JDFFechaC;
    private JFormattedTextField JFTFValor;
    private JFormattedTextField JFTFValorSaldoR;
    public JLabel JLB_Registro;
    private JPanel JPIDatosP;
    private JPanel JPTipoR;
    private JRadioButton JRBBienes;
    private JRadioButton JRBServicios;
    public JTextArea JTAObservacionG;
    public JTable JTDetalle;
    private JTextField JTFCodigoRbro;
    public JFormattedTextField JTFFValorPpt;
    private JTextField JTF_NComprobante;
    private ButtonGroup buttonGroup1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private int xIdTipoSolicitud = 0;
    private String xIdDisponibilidad = "";
    private boolean xlleno = false;
    private boolean xllenoRubro = false;
    private int xFila = 0;

    public JIFFSolicitudPTO_v2() {
        initComponents();
        mLlenaCombo();
        AutoCompleteDecorator.decorate(this.JCBRubros);
        springStart();
        mCrearModeloDatosSol();
        mNuevo();
        mHabilitaComponentes();
    }

    /* JADX WARN: Type inference failed for: r3v72, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.JPIDatosP = new JPanel();
        this.JDFFechaC = new JDateChooser();
        this.JCBUnidadF = new JComboBox();
        this.JTFFValorPpt = new JFormattedTextField();
        this.JPTipoR = new JPanel();
        this.JRBBienes = new JRadioButton();
        this.JRBServicios = new JRadioButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacionG = new JTextArea();
        this.JCBTipoC = new JComboBox();
        this.JTF_NComprobante = new JTextField();
        this.jPanel2 = new JPanel();
        this.JCBRubros = new JComboBox();
        this.JTFCodigoRbro = new JTextField();
        this.JFTFValor = new JFormattedTextField();
        this.JBAdicionar = new JButton();
        this.JFTFValorSaldoR = new JFormattedTextField();
        this.jScrollPane2 = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBAjusteValor = new JButton();
        this.JLB_Registro = new JLabel();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("SOLICITUD PRESUPUESTO");
        setToolTipText("");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setName("xjifSolicitudPTOv2");
        addInternalFrameListener(new InternalFrameListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.1
            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFFSolicitudPTO_v2.this.formInternalFrameClosing(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }
        });
        this.JPIDatosP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JDFFechaC.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFFechaC.setDateFormatString("dd/MM/yyyy");
        this.JDFFechaC.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadF.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Funcional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadF.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.2
            public void itemStateChanged(ItemEvent evt) {
                JIFFSolicitudPTO_v2.this.JCBUnidadFItemStateChanged(evt);
            }
        });
        this.JTFFValorPpt.setEditable(false);
        this.JTFFValorPpt.setBorder(BorderFactory.createTitledBorder((Border) null, "Presupuesto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFValorPpt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFValorPpt.setHorizontalAlignment(0);
        this.JTFFValorPpt.setText("0");
        this.JTFFValorPpt.setToolTipText("Presupuesto aproximando");
        this.JTFFValorPpt.setFont(new Font("Arial", 1, 12));
        this.JPTipoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Solicitud", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.buttonGroup1.add(this.JRBBienes);
        this.JRBBienes.setFont(new Font("Arial", 1, 12));
        this.JRBBienes.setSelected(true);
        this.JRBBienes.setText("Bienes");
        this.JRBBienes.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.3
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPTO_v2.this.JRBBienesActionPerformed(evt);
            }
        });
        this.buttonGroup1.add(this.JRBServicios);
        this.JRBServicios.setFont(new Font("Arial", 1, 12));
        this.JRBServicios.setText("Servicio");
        this.JRBServicios.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.4
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPTO_v2.this.JRBServiciosActionPerformed(evt);
            }
        });
        GroupLayout JPTipoRLayout = new GroupLayout(this.JPTipoR);
        this.JPTipoR.setLayout(JPTipoRLayout);
        JPTipoRLayout.setHorizontalGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRLayout.createSequentialGroup().addComponent(this.JRBBienes).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBServicios, -1, 99, 32767).addContainerGap()));
        JPTipoRLayout.setVerticalGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPTipoRLayout.createSequentialGroup().addGroup(JPTipoRLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBServicios).addComponent(this.JRBBienes)).addContainerGap(-1, 32767)));
        this.JTAObservacionG.setColumns(1);
        this.JTAObservacionG.setFont(new Font("Arial", 1, 12));
        this.JTAObservacionG.setLineWrap(true);
        this.JTAObservacionG.setRows(1);
        this.JTAObservacionG.setToolTipText("Digite la descripción de la solicitud");
        this.JTAObservacionG.setBorder(BorderFactory.createTitledBorder((Border) null, "Concepto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacionG);
        this.JCBTipoC.setFont(new Font("Arial", 1, 12));
        this.JCBTipoC.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoC.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.5
            public void itemStateChanged(ItemEvent evt) {
                JIFFSolicitudPTO_v2.this.JCBTipoCItemStateChanged(evt);
            }
        });
        this.JCBTipoC.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFSolicitudPTO_v2.6
            public void keyPressed(KeyEvent evt) {
                JIFFSolicitudPTO_v2.this.JCBTipoCKeyPressed(evt);
            }
        });
        this.JTF_NComprobante.setEditable(false);
        this.JTF_NComprobante.setFont(new Font("Arial", 1, 12));
        this.JTF_NComprobante.setForeground(new Color(0, 102, 0));
        this.JTF_NComprobante.setHorizontalAlignment(0);
        this.JTF_NComprobante.setBorder(BorderFactory.createTitledBorder((Border) null, "Consecutivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "RUBROS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JCBRubros.setEditable(true);
        this.JCBRubros.setFont(new Font("Arial", 1, 12));
        this.JCBRubros.setBorder(BorderFactory.createTitledBorder((Border) null, "Rubros", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBRubros.addItemListener(new ItemListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.7
            public void itemStateChanged(ItemEvent evt) {
                JIFFSolicitudPTO_v2.this.JCBRubrosItemStateChanged(evt);
            }
        });
        this.JTFCodigoRbro.setFont(new Font("Arial", 1, 12));
        this.JTFCodigoRbro.setToolTipText("");
        this.JTFCodigoRbro.setBorder(BorderFactory.createTitledBorder((Border) null, "Código", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCodigoRbro.addFocusListener(new FocusAdapter() { // from class: Presupuesto.JIFFSolicitudPTO_v2.8
            public void focusLost(FocusEvent evt) {
                JIFFSolicitudPTO_v2.this.JTFCodigoRbroFocusLost(evt);
            }
        });
        this.JTFCodigoRbro.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.9
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPTO_v2.this.JTFCodigoRbroActionPerformed(evt);
            }
        });
        this.JFTFValor.setBorder(BorderFactory.createTitledBorder((Border) null, "Valor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValor.setHorizontalAlignment(0);
        this.JFTFValor.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.10
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPTO_v2.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.JFTFValorSaldoR.setEditable(false);
        this.JFTFValorSaldoR.setBorder(BorderFactory.createTitledBorder((Border) null, "Saldo", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JFTFValorSaldoR.setForeground(Color.red);
        this.JFTFValorSaldoR.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JFTFValorSaldoR.setHorizontalAlignment(0);
        this.JFTFValorSaldoR.setText("0");
        this.JFTFValorSaldoR.setFont(new Font("Arial", 1, 14));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAdicionar, -1, -1, 32767).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFCodigoRbro, -2, 96, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBRubros, -2, 531, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValor, -2, 126, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFValorSaldoR, -1, 192, 32767))).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(2, 2, 2).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCodigoRbro, -2, 53, -2).addComponent(this.JCBRubros, -2, 52, -2))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFValor, -2, 52, -2).addComponent(this.JFTFValorSaldoR, -2, 52, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar, -2, 39, -2).addGap(5, 5, 5)));
        this.jScrollPane2.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Presupuesto.JIFFSolicitudPTO_v2.11
            public void mouseClicked(MouseEvent evt) {
                JIFFSolicitudPTO_v2.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addPropertyChangeListener(new PropertyChangeListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.12
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFFSolicitudPTO_v2.this.JTDetallePropertyChange(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: Presupuesto.JIFFSolicitudPTO_v2.13
            public void keyPressed(KeyEvent evt) {
                JIFFSolicitudPTO_v2.this.JTDetalleKeyPressed(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTDetalle);
        this.JBAjusteValor.setFont(new Font("Arial", 1, 12));
        this.JBAjusteValor.setIcon(new ImageIcon(getClass().getResource("/Imagenes/tarifas.png")));
        this.JBAjusteValor.setText("Ajuste Valores");
        this.JBAjusteValor.addActionListener(new ActionListener() { // from class: Presupuesto.JIFFSolicitudPTO_v2.14
            public void actionPerformed(ActionEvent evt) {
                JIFFSolicitudPTO_v2.this.JBAjusteValorActionPerformed(evt);
            }
        });
        this.JLB_Registro.setFont(new Font("Arial", 1, 14));
        this.JLB_Registro.setForeground(Color.red);
        this.JLB_Registro.setHorizontalAlignment(0);
        this.JLB_Registro.setBorder(BorderFactory.createTitledBorder((Border) null, "No.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDatosPLayout = new GroupLayout(this.JPIDatosP);
        this.JPIDatosP.setLayout(JPIDatosPLayout);
        JPIDatosPLayout.setHorizontalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addComponent(this.jPanel2, -1, -1, 32767).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JDFFechaC, -2, 109, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPTipoR, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JCBUnidadF, -2, 405, -2)).addComponent(this.JCBTipoC, -2, 220, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, 32767).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFValorPpt).addComponent(this.JTF_NComprobante, -2, 171, -2))).addComponent(this.jScrollPane2).addGroup(JPIDatosPLayout.createSequentialGroup().addComponent(this.JBAjusteValor, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLB_Registro, -2, 123, -2).addContainerGap()))));
        JPIDatosPLayout.setVerticalGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPLayout.createSequentialGroup().addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JDFFechaC, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPTipoR, -2, 50, -2).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFValorPpt).addComponent(this.JCBUnidadF))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoC, -2, 50, -2).addComponent(this.JTF_NComprobante, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 71, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jScrollPane2, -2, 122, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBAjusteValor, -1, 50, 32767).addComponent(this.JLB_Registro, -1, 50, 32767))));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPIDatosP, -1, -1, 32767).addGap(3, 3, 3)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JPIDatosP, -1, -1, 32767).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBUnidadFItemStateChanged(ItemEvent evt) {
    }

    private void springStart() {
        this.presupuestoDAO = (PresupuestoDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("presupuestoDAOImpl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBBienesActionPerformed(ActionEvent evt) {
        this.xIdTipoSolicitud = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBServiciosActionPerformed(ActionEvent evt) {
        this.xIdTipoSolicitud = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoC.getSelectedIndex() != -1 && this.JLB_Registro.getText().isEmpty()) {
            mConcecutivo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBTipoC.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBRubrosItemStateChanged(ItemEvent evt) {
        if (this.xllenoRubro && this.JCBRubros.getSelectedIndex() > -1 && this.xIdRubros != null) {
            this.JTFCodigoRbro.setText(this.xIdRubros[this.JCBRubros.getSelectedIndex()]);
            this.JFTFValorSaldoR.setValue(Double.valueOf(mSaldoRubro(this.xIdRubros[this.JCBRubros.getSelectedIndex()])));
        }
    }

    public double mSaldoRubro(String xidRubro) {
        double valor = 0.0d;
        String sql = "SELECT  \nr.Id\n,r.IdPadre\n,r.Nbre\n,r.TipoRubro\n,Presupuesto_Inicial\n,Adicion_Presupuesto\n,Reduccion_Presupuesto\n,Traslados_Debitos\n,Traslados_Creditos\n,Presupuesto_Definitivo\n,Reconocimiento_Anterior\n,Reconocimiento_Actual\n,Reconocimiento_Total\n,Recaudo_Anterior\n,Recaudo_Actual\n,Recaudo_Total\n,Saldo_por_Ejecutar\n,Saldo_por_Recaudar \n,Certificado_Anterior\n,Certificado_Actual\n,Total_Certificados\n,Compromiso_Anterior\n,Compromiso_Actual\n,Compromiso_Total\n,Obligacion_Anterior\n,Obligacion_Actual\n,Total_Obligaciones\n,Pagos_Anterior\n,Pagos_Actual\n,Total_Pagos\n,Saldo_Disponible\n,Sin_Comprometer\n,Compromisos_por_Pagar\n,Cuentas_por_Pagar\n,Certificado_sin_Comprometer\n\nFROM pp_rubros r\nINNER JOIN \n(SELECT \n Id_R\n ,N_R\n ,TipoRubro\n ,Presupuesto_Inicial\n ,Adicion_Presupuesto\n ,Reduccion_Presupuesto\n ,Traslados_Debitos\n ,Traslados_Creditos\n , (Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) Presupuesto_Definitivo\n  ,Reconocimiento_Anterior\n ,Reconocimiento_Actual\n ,(Reconocimiento_Anterior+Reconocimiento_Actual) Reconocimiento_Total\n ,Recaudo_Anterior\n ,Recaudo_Actual\n ,(Recaudo_Anterior+Recaudo_Actual) Recaudo_Total\n , ((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos) - (Reconocimiento_Anterior+Reconocimiento_Actual)) Saldo_por_Ejecutar\n , ((Reconocimiento_Anterior+Reconocimiento_Actual) - (Recaudo_Anterior+Recaudo_Actual)) Saldo_por_Recaudar \n/*Actualizacion con nuevos clase documentos*/ \n/*Disponibilidad CDP*/\n ,(Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)  AS Certificado_Anterior\n ,(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)  AS Certificado_Actual\n ,((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual)) Total_Certificados\n/*Compromiso RP*/\n ,(Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior) AS Compromiso_Anterior\n ,(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual) AS Compromiso_Actual\n ,((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual)) Compromiso_Total\n /*Obligacion OP*/\n ,(Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior) AS Obligacion_Anterior\n ,(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual) AS Obligacion_Actual\n ,((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual)) Total_Obligaciones\n /*Pagos PP*/\n ,Pagos_Anterior\n ,Pagos_Actual\n ,(Pagos_Anterior+ Pagos_Actual) Total_Pagos\n /*Operaciones...*/\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)- ((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))) Saldo_Disponible\n ,((Presupuesto_Inicial+Adicion_Presupuesto-Reduccion_Presupuesto-Traslados_Debitos+Traslados_Creditos)-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Sin_Comprometer\n ,(((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))-(Pagos_Anterior+ Pagos_Actual)) Compromisos_por_Pagar\n ,(((Obligacion_Anterior+Adicion_Obligacion_Anterior-Reintegro_Obligacion_Anterior)+(Obligacion_Actual +Adicion_Obligacion_Actual-Reintegro_Obligacion_Actual))-(Pagos_Anterior+ Pagos_Actual)) Cuentas_por_Pagar\n ,(((Disponibilidad_Anterior + Adicion_Disponibilidad_Anterior-Reintegro_Disponibilidad_Anterior)+(Disponibilidad_Actual + Adicion_Disponibilidad_Actual - Reintegro_Disponibilidad_Actual))-((Compromiso_Anterior+Adicion_Compromiso_Anterior-Reintegro_Compromiso_Anterior)+(Compromiso_Actual+Adicion_Compromiso_Actual-Reintegro_Compromiso_Actual))) Certificado_sin_Comprometer\nFROM \n(SELECT  \nId_R\n,N_R\n,TipoRubro\n,SUM(IFNULL(Presupuesto_Inicial,0)) Presupuesto_Inicial\n,SUM(IFNULL(Adicion_Presupuesto,0)) Adicion_Presupuesto\n,SUM(IFNULL(Reduccion_Presupuesto,0)) Reduccion_Presupuesto\n,SUM(IFNULL(Traslados_Debitos,0)) Traslados_Debitos\n,SUM(IFNULL(Traslados_Creditos,0)) Traslados_Creditos\n,SUM(IFNULL(Reconocimiento_Anterior,0)) Reconocimiento_Anterior\n,SUM(IFNULL(Reconocimiento_Actual,0)) Reconocimiento_Actual\n,SUM(IFNULL(Recaudo_Anterior,0)) Recaudo_Anterior\n,SUM(IFNULL(Recaudo_Actual,0)) Recaudo_Actual\n,SUM(IFNULL(Disponibilidad_Anterior,0)) Disponibilidad_Anterior\n,SUM(IFNULL(Disponibilidad_Actual,0)) Disponibilidad_Actual\n,SUM(IFNULL(Compromiso_Anterior,0)) Compromiso_Anterior\n,SUM(IFNULL(Compromiso_Actual,0)) Compromiso_Actual\n,SUM(IFNULL(Obligacion_Anterior,0)) Obligacion_Anterior\n,SUM(IFNULL(Obligacion_Actual,0)) Obligacion_Actual\n,SUM(IFNULL(Pagos_Anterior,0)) Pagos_Anterior\n,SUM(IFNULL(Pagos_Actual,0)) Pagos_Actual\n-- -------------------------------------------------------------\n,SUM(IFNULL(Adicion_Disponibilidad_Anterior,0)) Adicion_Disponibilidad_Anterior\n,SUM(IFNULL(Adicion_Disponibilidad_Actual,0)) Adicion_Disponibilidad_Actual\n,SUM(IFNULL(Reintegro_Disponibilidad_Anterior,0)) Reintegro_Disponibilidad_Anterior\n,SUM(IFNULL(Reintegro_Disponibilidad_Actual,0)) Reintegro_Disponibilidad_Actual\n,SUM(IFNULL(Adicion_Compromiso_Anterior,0)) Adicion_Compromiso_Anterior\n,SUM(IFNULL(Adicion_Compromiso_Actual,0)) Adicion_Compromiso_Actual\n,SUM(IFNULL(Reintegro_Compromiso_Anterior,0)) Reintegro_Compromiso_Anterior\n,SUM(IFNULL(Reintegro_Compromiso_Actual,0)) Reintegro_Compromiso_Actual\n,SUM(IFNULL(Adicion_Obligacion_Anterior,0)) Adicion_Obligacion_Anterior\n,SUM(IFNULL(Adicion_Obligacion_Actual,0)) Adicion_Obligacion_Actual\n,SUM(IFNULL(Reintegro_Obligacion_Anterior,0)) Reintegro_Obligacion_Anterior\n,SUM(IFNULL(Reintegro_Obligacion_Actual,0)) Reintegro_Obligacion_Actual\n\nFROM \n(SELECT \nId_R\n,N_R\n,TipoRubro\n,CASE WHEN Id_CD=1 THEN \n   Valor\nEND Presupuesto_Inicial  \n\n,CASE WHEN Id_CD=8  AND Tipo=1 THEN \n   Valor\nEND Adicion_Presupuesto  \n\n,CASE WHEN Id_CD=8  AND Tipo=0 THEN \n   Valor \nEND Reduccion_Presupuesto  \n\n,CASE WHEN Id_CD=7 AND Tipo=0 THEN\n   Valor\n  END Traslados_Debitos \n\n,CASE WHEN Id_CD=7 AND Tipo=1 THEN \n Valor\nEND Traslados_Creditos\n\n\n,CASE WHEN Id_CD=2  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Reconocimiento_Anterior\n\n,CASE WHEN Id_CD=2  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Reconocimiento_Actual\n\n,CASE WHEN Id_CD=3  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Recaudo_Anterior\n\n,CASE WHEN Id_CD=3  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Recaudo_Actual\n\n\n,CASE WHEN Id_CD=9  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Disponibilidad_Anterior\n\n,CASE WHEN Id_CD=9  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Disponibilidad_Actual\n\n,CASE WHEN Id_CD=4  AND Id_Periodo<>Periodo_Act  THEN\n     Valor\n END Compromiso_Anterior\n \n ,CASE WHEN Id_CD=4  AND Id_Periodo=Periodo_Act  THEN\n     Valor\n END Compromiso_Actual\n \n,CASE WHEN Id_CD=5  AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Obligacion_Anterior\n \n,CASE WHEN Id_CD=5  AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Obligacion_Actual \n \n ,CASE WHEN Id_CD=6 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Pagos_Anterior\n \n ,CASE WHEN Id_CD=6 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Pagos_Actual\n -- -------------------------------------------------------\n /*\n10\tAdicion Disponibilidad\n11\tReintegro Disponibilidad\n12\tAdicion Compromiso\n13\tReintegro Compromiso\n14\tAdicion Obligación\n15\tReintegro Obligación\n*/\n ,CASE WHEN Id_CD=10 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=10 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Disponibilidad_Actual\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Anterior\n \n ,CASE WHEN Id_CD=11 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Disponibilidad_Actual\n\n ,CASE WHEN Id_CD=12 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=12 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Adicion_Compromiso_Actual\n\n ,CASE WHEN Id_CD=13 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Compromiso_Anterior\n \n ,CASE WHEN Id_CD=13 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Reintegro_Compromiso_Actual \n    \n ,CASE WHEN Id_CD=14 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Adicion_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=14 AND Id_Periodo=Periodo_Act THEN\n     Valor\n  END Adicion_Obligacion_Actual\n  \n,CASE WHEN Id_CD=15 AND Id_Periodo<>Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Anterior\n \n ,CASE WHEN Id_CD=15 AND Id_Periodo=Periodo_Act THEN\n     Valor\n END Reintegro_Obligacion_Actual\n \n\nFROM \n(SELECT\n      pp_clase_documento.Id Id_CD \n     , pp_clase_documento.Nbre N_CD\n     , pp_rubros.Id Id_R\n     , pp_rubros.Nbre N_R\n     ,pp_rubros.TipoRubro \n    , pp_detalle_movimiento.Tipo\n    , pp_movimiento.Id_Periodo\n    , SUM(pp_detalle_movimiento.Valor) Valor\n    , @Periodo_Act Periodo_Act\n    \nFROM (SELECT @Periodo_Act:='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') p,\n    pp_movimiento\n    INNER JOIN pp_periodo \n        ON (pp_movimiento.Id_Periodo = pp_periodo.Id)\n    INNER JOIN pp_detalle_movimiento \n        ON (pp_detalle_movimiento.Id_Movimiento = pp_movimiento.Id)\n    INNER JOIN pp_tipo_documentos \n        ON (pp_movimiento.Id_TipoDoc = pp_tipo_documentos.Id)\n    INNER JOIN pp_rubros \n        ON (pp_detalle_movimiento.Id_Rubro = pp_rubros.Id) AND (pp_rubros.`idEncabezadoRubro`=pp_detalle_movimiento.`idEncabezado`) \n    INNER JOIN pp_clase_documento \n        ON (pp_tipo_documentos.Id_ClaseDoc = pp_clase_documento.Id)\n    WHERE   pp_periodo.Id IN ( SELECT pant.Id  FROM `pp_periodo` pant, (SELECT Id, FechaI,FechaF FROM `pp_periodo`\n    WHERE Id='" + Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto() + "') pact\n    WHERE (DATE_FORMAT(pant.FechaI,'%Y')=DATE_FORMAT(pact.FechaI,'%Y') AND pant.FechaF<=pact.FechaI)\n    OR pact.Id=pant.id\n         )  \n    AND pp_movimiento.Id_MotivoAnulacion=1  and pp_detalle_movimiento.Estado =1 AND pp_rubros.`Id`='" + xidRubro + "' AND pp_detalle_movimiento.idEncabezado='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "' \n GROUP BY  pp_clase_documento.Id   , pp_clase_documento.Nbre, pp_rubros.Id ,pp_detalle_movimiento.Tipo ,pp_movimiento.Id_Periodo\n ) datos\n ) datos\nGROUP BY Id_R ,N_R,TipoRubro\n) datos ) datos\nON r.Id=datos.Id_R WHERE r.`idEncabezadoRubro`='" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + "';";
        ResultSet xrs = this.xct.traerRs(sql);
        System.out.println("Saldo Disponible-->" + sql);
        try {
            if (xrs.next()) {
                xrs.first();
                valor = xrs.getDouble("Saldo_Disponible");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return valor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroFocusLost(FocusEvent evt) {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
        }
    }

    private void mAdicionaRubro() {
        if (this.JCBRubros.getSelectedIndex() > -1) {
            if (!mVerificaRubroTabla()) {
                if (this.JTFCodigoRbro.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "el Código del rubro no puede estar vacío", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFCodigoRbro.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JFTFValor.getValue().toString()).doubleValue() <= 0.0d) {
                    JOptionPane.showMessageDialog(this, "el valor debe ser mayor que cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JFTFValor.requestFocus();
                    return;
                }
                if (Double.valueOf(this.JFTFValor.getValue().toString()).doubleValue() <= Double.valueOf(this.JFTFValorSaldoR.getValue().toString()).doubleValue()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt("", this.xFila, 0);
                    this.xmodelo.setValueAt(this.xIdRubros[this.JCBRubros.getSelectedIndex()], this.xFila, 1);
                    this.xmodelo.setValueAt(this.JCBRubros.getSelectedItem(), this.xFila, 2);
                    this.xmodelo.setValueAt(this.JFTFValor.getValue(), this.xFila, 3);
                    this.xmodelo.setValueAt(true, this.xFila, 4);
                    this.xFila++;
                    mTotaliza();
                    mLimipia();
                    return;
                }
                JOptionPane.showMessageDialog(this, "el valor debe ser menor al saldo del Rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JFTFValor.requestFocus();
                return;
            }
            JOptionPane.showMessageDialog(this, "Ya existe este rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showMessageDialog(this, "Seleccione un rubro", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBRubros.requestFocus();
    }

    private void mTotaliza() {
        double total = 0.0d;
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            total += Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue();
        }
        this.JTFFValorPpt.setValue(Double.valueOf(total));
    }

    private void mLimipia() {
        this.JTFCodigoRbro.setText("");
        this.JCBRubros.setSelectedIndex(-1);
        this.JFTFValor.setValue(0);
        this.JFTFValorSaldoR.setValue(0);
    }

    private boolean mVerificaRubroTabla() {
        boolean xExiste = false;
        int i = 0;
        while (true) {
            if (i >= this.JTDetalle.getRowCount()) {
                break;
            }
            if (!this.xmodelo.getValueAt(i, 1).toString().equals(this.xIdRubros[this.JCBRubros.getSelectedIndex()])) {
                i++;
            } else {
                xExiste = true;
                break;
            }
        }
        return xExiste;
    }

    private void mHabilitaComponentes() {
        this.JTFCodigoRbro.setText("");
    }

    private void mLlenaCombo() {
        this.JCBRubros.removeAllItems();
        String orden = " ORDER BY `pp_rubros`.`Id` ASC;";
        if (Principal.informacionIps.getIdentificacion().equals("812001219")) {
            orden = " ORDER BY `pp_rubros`.`Nbre` ASC;";
        }
        String sql = "SELECT pp_rubros.Id \n,concat(`pp_rubros`.`Nbre`,' | ',pp_rubros.Id ) AS Rubro \nFROM  `pp_rubros` \nWHERE (pp_rubros.idEncabezadoRubro=" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + " and pp_rubros.UltNivel=1 and pp_rubros.TipoRubro='G') \n" + orden;
        this.xIdRubros = this.xct.llenarCombo(sql, this.xIdRubros, this.JCBRubros);
        System.out.println("xIdRubros-->" + this.xIdRubros);
        this.xllenoRubro = true;
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatosSol() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdDetalle", "CodRubro", "Nombre Rubro", "Valor", "Estado"}) { // from class: Presupuesto.JIFFSolicitudPTO_v2.15
            Class[] types = {String.class, String.class, String.class, Double.class, Boolean.class};
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
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCodigoRbroActionPerformed(ActionEvent evt) {
        if (!this.JTFCodigoRbro.getText().isEmpty()) {
            mVerificarRubro();
        }
    }

    private void mVerificarRubro() {
        String sql = "SELECT  CONCAT(`pp_rubros`.`Nbre`,' | ',pp_rubros.Id ) AS Rubro\nFROM   `pp_rubros` \nWHERE (pp_rubros.Id='" + this.JTFCodigoRbro.getText() + "' AND pp_rubros.IdEncabezadoRubro=" + Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro() + ") \nORDER BY pp_rubros.Id ASC;";
        System.out.println("Entra Sql-->" + sql);
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JCBRubros.setSelectedItem(xrs.getString("Rubro"));
            } else {
                this.JCBRubros.setSelectedIndex(-1);
                this.JTFCodigoRbro.setText("");
                JOptionPane.showMessageDialog(this, "Rubro no existe", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFMovimiento.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        mAdicionaRubro();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetallePropertyChange(PropertyChangeEvent evt) {
        if (this.JTDetalle.getRowCount() != -1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            if (!this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).equals("")) {
                this.presupuestoDAO.actualizarEstadoDetalleSolicitud(Long.valueOf(this.JTDetalle.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString()));
            }
            this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
            this.xFila--;
            mTotaliza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAjusteValorActionPerformed(ActionEvent evt) {
        if (!this.JLB_Registro.getText().isEmpty()) {
            JDAjusteSolicitud x = new JDAjusteSolicitud(null, true, this);
            x.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this, "No hay solicitud cargada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    private void mConcecutivo() {
        String sql;
        int Con = 0;
        if (Principal.informacionIps.getTiposolicitudcdp() == 0) {
            sql = "SELECT MAX(`NConsecutivo`) AS MaximoCons FROM `cc_r_requisicion`\n WHERE (`Id_TipoDoc` ='" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "' \n AND `Estado` =1 AND DATE_FORMAT(cc_r_requisicion.`FechaR`, '%Y')='" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + "')";
        } else {
            sql = "SELECT MAX(`NConsecutivo`) AS MaximoCons FROM pp_solicitud_pto so\nWHERE (so.`idTipoDocumento` ='" + this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0] + "' and so.`Estado` =1 AND DATE_FORMAT(so.`FechaR`, '%Y')=" + this.xmt.formatoANO.format(this.JDFFechaC.getDate()) + ")";
        }
        ConsultasMySQL xct1 = new ConsultasMySQL();
        ResultSet xrs1 = xct1.traerRs(sql);
        try {
            if (xrs1.next()) {
                xrs1.first();
                Con = xrs1.getInt("MaximoCons");
            }
            xrs1.close();
            xct1.cerrarConexionBd();
            this.JTF_NComprobante.setText("" + (Con + 1));
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSolicitudPTO_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        this.xConsecutivo = Con + 1;
    }

    public void mNuevo() {
        this.JTF_NComprobante.setText("");
        this.JLB_Registro.setText("");
        this.JFTFValor.setValue(0);
        this.JTFFValorPpt.setValue(0);
        this.xlleno = false;
        Principal.mLimpiarDatosP();
        this.JDFFechaC.setDate(this.xmt.getFechaActual());
        this.JCBUnidadF.removeAllItems();
        System.out.println("UF-->SELECT cc_unidad_funcional.Id , cc_unidad_funcional.Nbre, '' Correo,0 Id_Persona FROM cc_unidad_funcional   WHERE cc_unidad_funcional.Estado=1");
        this.xidunidadfuncional = this.xct.llenarComboyLista("SELECT cc_unidad_funcional.Id , cc_unidad_funcional.Nbre, '' Correo,0 Id_Persona FROM cc_unidad_funcional   WHERE cc_unidad_funcional.Estado=1", this.xidunidadfuncional, this.JCBUnidadF, 4);
        this.JCBUnidadF.setSelectedIndex(-1);
        this.JCBTipoC.removeAllItems();
        this.xidtipodoccontable = this.xct.llenarComboyLista("SELECT Id, Nbre, NReporte FROM cc_tipo_documentoc WHERE (Estado =1 and EsContable=2) ORDER BY Nbre ASC", this.xidtipodoccontable, this.JCBTipoC, 3);
        this.JCBTipoC.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.JRBBienes.setSelected(true);
        this.xIdTipoSolicitud = 0;
        this.JTFFValorPpt.setValue(0);
        this.JTAObservacionG.setText("");
        this.xlleno = true;
        mCrearModeloDatosSol();
        this.JTFCodigoRbro.setText("");
        this.JCBRubros.setSelectedIndex(-1);
        this.JFTFValor.setValue(0);
        this.JFTFValorSaldoR.setValue(0);
        this.xFila = 0;
    }

    public void mGrabar() {
        if (this.JCBUnidadF.getSelectedIndex() > -1) {
            if (this.JCBTipoC.getSelectedIndex() <= -1) {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de documento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoC.requestFocus();
                return;
            }
            if (Double.parseDouble(this.JTFFValorPpt.getValue().toString()) > 0.0d) {
                if (!this.JTAObservacionG.getText().isEmpty()) {
                    if (this.JTDetalle.getRowCount() > 0) {
                        if (this.JLB_Registro.getText().isEmpty()) {
                            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x == 0) {
                                SolicitudDTO solicitud = new SolicitudDTO();
                                solicitud.setIdUsuarioCargon(Principal.usuarioSistemaDTO.getIdPersonaCargo());
                                solicitud.setIdTipoDocumento(Integer.valueOf(this.xidtipodoccontable[this.JCBTipoC.getSelectedIndex()][0]));
                                solicitud.setFechaR(this.xmt.formatoAMD.format(this.JDFFechaC.getDate()));
                                solicitud.setDescripcion(this.JTAObservacionG.getText());
                                solicitud.setIdMovimiento(0);
                                solicitud.setValor(Double.valueOf(this.JTFFValorPpt.getValue().toString()).doubleValue());
                                solicitud.setTipoSolicitud(this.xIdTipoSolicitud);
                                solicitud.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                                solicitud.setNoConsecutivo(Integer.valueOf(this.JTF_NComprobante.getText()).intValue());
                                solicitud.setIdUnidadFuncional(Integer.valueOf(this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][0]).intValue());
                                solicitud.setIdPeriodo(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdPeriodoPresupuesto()).intValue());
                                String xidSol = this.presupuestoDAO.guardaSolicitud_return_id(solicitud);
                                for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
                                    SolicitudDetalleDTO sd = new SolicitudDetalleDTO();
                                    sd.setIdmovimiento(Integer.valueOf(xidSol).intValue());
                                    sd.setIdEncabezado(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
                                    sd.setIdrubro(this.xmodelo.getValueAt(i, 1).toString());
                                    sd.setValor(Double.valueOf(this.xmodelo.getValueAt(i, 3).toString()).doubleValue());
                                    this.presupuestoDAO.guardaSolicitudDetalle(sd);
                                }
                                this.JLB_Registro.setText(xidSol);
                                return;
                            }
                            return;
                        }
                        List<Object[]> dis = this.presupuestoDAO.getDisponibilidad(Integer.valueOf(this.JLB_Registro.getText()).intValue());
                        System.out.println("dis.size()-->" + dis.size());
                        if (dis.size() > 0) {
                            List<Object[]> com2 = this.presupuestoDAO.getCompromiso(Integer.valueOf(dis.get(0)[0].toString()).intValue());
                            this.presupuestoDAO.actualizarDetalleEncabezadoMovimiento(Long.valueOf(dis.get(0)[0].toString()), this.JTAObservacionG.getText());
                            if (com2.size() > 0) {
                                this.presupuestoDAO.actualizarDetalleEncabezadoMovimiento(Long.valueOf(com2.get(0)[0].toString()), this.JTAObservacionG.getText());
                                List<Object[]> obli = this.presupuestoDAO.getObligacion(Integer.valueOf(com2.get(0)[0].toString()).intValue());
                                if (obli.size() > 0) {
                                    System.out.println("hay obligaciones obli.size()-->" + obli.size());
                                    JOptionPane.showInternalMessageDialog(this, "No puede agregar rubros a la solicitud por que hay obligaciones registradas", "ERROR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    return;
                                }
                                int x2 = JOptionPane.showInternalConfirmDialog(this, "Esta solicitud tiene movimientos presupuesales asociados, esta seguro de Actualizar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                if (x2 == 0) {
                                    this.presupuestoDAO.actualizaAjusteEncabezado(Integer.valueOf(this.JLB_Registro.getText()).intValue(), Double.valueOf(this.JTFFValorPpt.getValue().toString()).doubleValue(), this.JTAObservacionG.getText(), this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][0]);
                                    for (int i2 = 0; i2 < this.JTDetalle.getRowCount(); i2++) {
                                        if (this.xmodelo.getValueAt(i2, 0).toString().isEmpty()) {
                                            SolicitudDetalleDTO sd2 = new SolicitudDetalleDTO();
                                            sd2.setIdmovimiento(Integer.valueOf(this.JLB_Registro.getText()).intValue());
                                            sd2.setIdEncabezado(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
                                            sd2.setIdrubro(this.xmodelo.getValueAt(i2, 1).toString());
                                            sd2.setValor(Double.valueOf(this.xmodelo.getValueAt(i2, 3).toString()).doubleValue());
                                            this.presupuestoDAO.guardaSolicitudDetalle(sd2);
                                            if (dis.size() > 0) {
                                                System.out.println("Guarda detalle disponibilidad");
                                                MovimientoDetalleDTO md = new MovimientoDetalleDTO();
                                                md.setIdEncabezado(Integer.valueOf(dis.get(0)[2].toString()).intValue());
                                                md.setId_Movimiento(Integer.valueOf(dis.get(0)[0].toString()).intValue());
                                                md.setId_Rubro(this.xmodelo.getValueAt(i2, 1).toString());
                                                md.setId_Tercero(Integer.valueOf(dis.get(0)[3].toString()).intValue());
                                                md.setValor(Double.valueOf(this.xmodelo.getValueAt(i2, 3).toString()).doubleValue());
                                                this.presupuestoDAO.guardaDetalleMovimiento(md);
                                            }
                                            if (com2.size() > 0) {
                                                System.out.println("Guarda detalle compromiso");
                                                MovimientoDetalleDTO md2 = new MovimientoDetalleDTO();
                                                md2.setIdEncabezado(Integer.valueOf(com2.get(0)[2].toString()).intValue());
                                                md2.setId_Movimiento(Integer.valueOf(com2.get(0)[0].toString()).intValue());
                                                md2.setId_Rubro(this.xmodelo.getValueAt(i2, 1).toString());
                                                md2.setId_Tercero(Integer.valueOf(com2.get(0)[3].toString()).intValue());
                                                md2.setValor(Double.valueOf(this.xmodelo.getValueAt(i2, 3).toString()).doubleValue());
                                                this.presupuestoDAO.guardaDetalleMovimiento(md2);
                                            }
                                        }
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "Solicitud Actualizada correctamente", "EXITO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    return;
                                }
                                return;
                            }
                            System.out.println("No tiene compromiso");
                            int x3 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar la solicitud?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                            if (x3 == 0) {
                                this.presupuestoDAO.actualizaAjusteEncabezado(Integer.valueOf(this.JLB_Registro.getText()).intValue(), Double.valueOf(this.JTFFValorPpt.getValue().toString()).doubleValue(), this.JTAObservacionG.getText(), this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][0]);
                                for (int i3 = 0; i3 < this.JTDetalle.getRowCount(); i3++) {
                                    if (this.xmodelo.getValueAt(i3, 0).toString().isEmpty()) {
                                        SolicitudDetalleDTO sd3 = new SolicitudDetalleDTO();
                                        sd3.setIdmovimiento(Integer.valueOf(this.JLB_Registro.getText()).intValue());
                                        sd3.setIdEncabezado(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
                                        sd3.setIdrubro(this.xmodelo.getValueAt(i3, 1).toString());
                                        sd3.setValor(Double.valueOf(this.xmodelo.getValueAt(i3, 3).toString()).doubleValue());
                                        this.presupuestoDAO.guardaSolicitudDetalle(sd3);
                                        if (dis.size() > 0) {
                                            System.out.println("Guarda detalle disponibilidad");
                                            MovimientoDetalleDTO md3 = new MovimientoDetalleDTO();
                                            md3.setIdEncabezado(Integer.valueOf(dis.get(0)[2].toString()).intValue());
                                            md3.setId_Movimiento(Integer.valueOf(dis.get(0)[0].toString()).intValue());
                                            md3.setId_Rubro(this.xmodelo.getValueAt(i3, 1).toString());
                                            md3.setId_Tercero(Integer.valueOf(dis.get(0)[3].toString()).intValue());
                                            md3.setValor(Double.valueOf(this.xmodelo.getValueAt(i3, 3).toString()).doubleValue());
                                            this.presupuestoDAO.guardaDetalleMovimiento(md3);
                                        }
                                    }
                                }
                                JOptionPane.showInternalMessageDialog(this, "Solicitud Actualizada correctamente", "EXITO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            return;
                        }
                        System.out.println("No tiene disponibilidad");
                        int x4 = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Actualizar la solicitud?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x4 == 0) {
                            this.presupuestoDAO.actualizaAjusteEncabezado(Integer.valueOf(this.JLB_Registro.getText()).intValue(), Double.valueOf(this.JTFFValorPpt.getValue().toString()).doubleValue(), this.JTAObservacionG.getText(), this.xidunidadfuncional[this.JCBUnidadF.getSelectedIndex()][0]);
                            for (int i4 = 0; i4 < this.JTDetalle.getRowCount(); i4++) {
                                if (this.xmodelo.getValueAt(i4, 0).toString().isEmpty()) {
                                    SolicitudDetalleDTO sd4 = new SolicitudDetalleDTO();
                                    sd4.setIdmovimiento(Integer.valueOf(this.JLB_Registro.getText()).intValue());
                                    sd4.setIdEncabezado(Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
                                    sd4.setIdrubro(this.xmodelo.getValueAt(i4, 1).toString());
                                    sd4.setValor(Double.valueOf(this.xmodelo.getValueAt(i4, 3).toString()).doubleValue());
                                    this.presupuestoDAO.guardaSolicitudDetalle(sd4);
                                }
                            }
                            JOptionPane.showInternalMessageDialog(this, "Solicitud Actualizada correctamente", "EXITO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe agregar rubros a la tabla", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTAObservacionG.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe digitar el Concepto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTAObservacionG.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El Valor debe ser diferente de cero", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFValorPpt.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad funcional", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBUnidadF.requestFocus();
    }

    public void mBuscar() {
        this.xjifbuscarorden = new JIFConsultarDatosV(this);
        Principal.cargarPantalla(this.xjifbuscarorden);
    }

    public void mImprimir() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            String[][] mparametros = new String[5][2];
            mparametros[0][0] = "IdC";
            mparametros[0][1] = this.JLB_Registro.getText();
            mparametros[1][0] = "UsuarioS";
            mparametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
            mparametros[2][0] = "SUBREPORT_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[3][0] = "SUBREPORTFIRMA_DIR";
            mparametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            mparametros[4][0] = "idEncabezadoRubro";
            mparametros[4][1] = Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "PP_SolicutudServ_Rubros", mparametros);
        }
    }

    public void mConsultaSolicitud() {
        String sql = "SELECT\nso.`Id`\n, so.`FechaR`\n, uf.`Nbre` AS UF \n, so.tiposolicitud TipoR\n, so.Descripcion as  ObservacionG\n, so.valor VPresupuestado\n, so.IdMovimiento  IdDisponibilidad  , so.`NConsecutivo` , 'PRESUPUESTO' AS TipoDoc\nFROM pp_solicitud_pto so\nINNER JOIN  `cc_unidad_funcional` uf  ON (so.idunidadfuncional = uf.`Id`) \nWHERE (so.`Id` =" + this.JLB_Registro.getText() + ");";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JDFFechaC.setDate(xrs.getDate("FechaR"));
                this.xIdDisponibilidad = xrs.getString("IdDisponibilidad");
                this.JCBUnidadF.setSelectedItem(xrs.getString("UF"));
                if (xrs.getString("TipoR").equals("0")) {
                    this.JRBBienes.setSelected(true);
                    this.xIdTipoSolicitud = 0;
                } else {
                    this.JRBServicios.setSelected(true);
                    this.xIdTipoSolicitud = 1;
                }
                this.JTFFValorPpt.setValue(Double.valueOf(xrs.getDouble("VPresupuestado")));
                this.JTAObservacionG.setText(xrs.getString("ObservacionG"));
                this.JCBTipoC.setSelectedItem(xrs.getString("TipoDoc"));
                this.JTF_NComprobante.setText(xrs.getString("NConsecutivo"));
                mBuscaRubrosSolicitud(xrs.getInt("id"));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFFSolicitudPTO_v2.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mBuscaRubrosSolicitud(int idSolicitud) {
        mCrearModeloDatosSol();
        this.xFila = 0;
        System.out.println("idSolicitud ---- " + idSolicitud);
        System.out.println("encabezado ---- " + Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()));
        List<Object[]> listSol = this.presupuestoDAO.getListRubrosSolicitud(idSolicitud, Integer.valueOf(Principal.informacionGeneralPrincipalDTO.getIdMaestroRubro()).intValue());
        if (listSol.size() > 0) {
            for (int i = 0; i < listSol.size(); i++) {
                this.xmodelo.addRow(this.xdatos);
                this.xmodelo.setValueAt(listSol.get(i)[4], this.xFila, 0);
                this.xmodelo.setValueAt(listSol.get(i)[0], this.xFila, 1);
                this.xmodelo.setValueAt(listSol.get(i)[1], this.xFila, 2);
                this.xmodelo.setValueAt(listSol.get(i)[2], this.xFila, 3);
                this.xmodelo.setValueAt(true, this.xFila, 4);
                this.xFila++;
            }
        }
        mTotaliza();
    }

    public void mAnular() {
        if (!this.JLB_Registro.getText().isEmpty()) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                Anular frm = new Anular(null, true, "PP_Solicitudv2", 26);
                frm.setLocationRelativeTo(this);
                frm.setVisible(true);
            }
        }
    }

    public void mAnular_Registro(String xIdMot, String xObservacion) {
        Principal.xclasePresupuesto.mAnularSolicitudPTOV2(xIdMot, xObservacion, this.JLB_Registro.getText());
        Principal.txtEstado.setText("ANULADO");
        System.err.println(Principal.txtEstado.getText());
    }
}
