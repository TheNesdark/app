package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPTransfuciones.class */
public class JPTransfuciones extends JPanel {
    private String[] xProc;
    public DefaultTableModel xmodeloPro;
    public DefaultTableModel xmodeloMon;
    private String xnombre;
    private Object[] xdatos;
    private JButton JBAdicionar;
    private ButtonGroup JBGPCruzada;
    private ButtonGroup JBGTRanPrevias;
    private ButtonGroup JBGUrgente;
    private JComboBox JCBProcedimientos;
    private JPanel JPMonitoreo;
    private JRadioButton JRBNO1;
    private JRadioButton JRBNO2;
    private JRadioButton JRBNO3;
    private JRadioButton JRBSI1;
    private JRadioButton JRBSI2;
    private JRadioButton JRBSI3;
    private JScrollPane JSPDiagnosticos;
    private JScrollPane JSPMonitoreo;
    private JTextArea JTAMotivo;
    public JTextField JTFCDxP;
    private JFormattedTextField JTFFCantidad;
    private JFormattedTextField JTFFGRDL;
    private JFormattedTextField JTFFHTO1;
    private JFormattedTextField JTFFHTO2;
    public JTextField JTFNCodigoDxP;
    public JTable JTMonitoreo;
    public JTable JTProc;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    public JDateChooser txtFecha;
    public JDateChooser txtFechaUltT;
    public JFormattedTextField txtHora;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private long xPrevia = 0;
    private long xUrgente = 0;
    private long xAutoriza = 0;
    private String xTrasnfusion = "";
    private String xidOrden = "";
    private boolean xlleno = false;
    private int xfilasproc = 0;

    public JPTransfuciones(String xnombre) {
        initComponents();
        this.xnombre = xnombre;
        this.txtFecha.setDate(this.xmt.getFechaActual());
        this.txtFechaUltT.setDate(this.xmt.getFechaActual());
        this.txtHora.setValue(this.xmt.getFechaActual());
        mIniciarComp();
        this.JTFFHTO1.setValue(0);
        this.JTFFHTO2.setValue(0);
        this.JTFFGRDL.setValue(0);
        mCreaModelodx();
        if (this.xnombre.equals("xTransfusionHC")) {
            mBuscarTrasfusion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
        } else {
            mBuscarTrasfusion(Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText());
            mBuscaMonitoreo();
        }
        this.JCBProcedimientos.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() { // from class: Historia.JPTransfuciones.1
            public void keyReleased(KeyEvent evt) {
                String cadenaEscrita = JPTransfuciones.this.JCBProcedimientos.getEditor().getItem().toString();
                if ((evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90) || ((evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105) || evt.getKeyCode() == 8)) {
                    JPTransfuciones.this.mLlenaCombo(cadenaEscrita);
                    if (JPTransfuciones.this.JCBProcedimientos.getItemCount() > 0) {
                        JPTransfuciones.this.JCBProcedimientos.getEditor().setItem(cadenaEscrita);
                        JPTransfuciones.this.JCBProcedimientos.showPopup();
                    } else {
                        JPTransfuciones.this.JCBProcedimientos.addItem(cadenaEscrita);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mLlenaCombo(String nombre) {
        this.JCBProcedimientos.removeAllItems();
        String sql = "SELECT `Id` , CONCAT(Id,' | ',`Nbre`) as Nbre FROM `g_procedimiento` WHERE (`Id_TipoConceptoAgrup` =10 AND Nbre LIKE'%" + nombre + "%') ORDER BY Nbre ASC";
        this.xProc = this.xct.llenarCombo(sql, this.xProc, this.JCBProcedimientos);
        this.xct.cerrarConexionBd();
    }

    /* JADX WARN: Type inference failed for: r3v100, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v91, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGTRanPrevias = new ButtonGroup();
        this.JBGUrgente = new ButtonGroup();
        this.JBGPCruzada = new ButtonGroup();
        this.jPanel1 = new JPanel();
        this.txtFecha = new JDateChooser();
        this.txtHora = new JFormattedTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAMotivo = new JTextArea();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.jLabel1 = new JLabel();
        this.JRBSI1 = new JRadioButton();
        this.JRBNO1 = new JRadioButton();
        this.txtFechaUltT = new JDateChooser();
        this.jLabel2 = new JLabel();
        this.JRBSI2 = new JRadioButton();
        this.JRBNO2 = new JRadioButton();
        this.jLabel3 = new JLabel();
        this.JRBSI3 = new JRadioButton();
        this.JRBNO3 = new JRadioButton();
        this.JTFFHTO1 = new JFormattedTextField();
        this.JTFFGRDL = new JFormattedTextField();
        this.JTFFHTO2 = new JFormattedTextField();
        this.jPanel2 = new JPanel();
        this.JTFFCantidad = new JFormattedTextField();
        this.JBAdicionar = new JButton();
        this.JCBProcedimientos = new JComboBox();
        this.JSPDiagnosticos = new JScrollPane();
        this.JTProc = new JTable();
        this.JPMonitoreo = new JPanel();
        this.JSPMonitoreo = new JScrollPane();
        this.JTMonitoreo = new JTable();
        setName("transfusiones");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.txtFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFecha.setDateFormatString("dd/MM/yyyy");
        this.txtFecha.setFont(new Font("Tahoma", 1, 12));
        this.txtFecha.addKeyListener(new KeyAdapter() { // from class: Historia.JPTransfuciones.2
            public void keyPressed(KeyEvent evt) {
                JPTransfuciones.this.txtFechaKeyPressed(evt);
            }
        });
        this.txtHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("hh:mm:ss a"))));
        this.txtHora.setFont(new Font("Tahoma", 1, 12));
        this.txtHora.addKeyListener(new KeyAdapter() { // from class: Historia.JPTransfuciones.3
            public void keyPressed(KeyEvent evt) {
                JPTransfuciones.this.txtHoraKeyPressed(evt);
            }
        });
        this.JTAMotivo.setColumns(1);
        this.JTAMotivo.setFont(new Font("Arial", 0, 13));
        this.JTAMotivo.setLineWrap(true);
        this.JTAMotivo.setRows(1);
        this.JTAMotivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Motivo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAMotivo);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addActionListener(new ActionListener() { // from class: Historia.JPTransfuciones.4
            public void actionPerformed(ActionEvent evt) {
                JPTransfuciones.this.JTFCDxPActionPerformed(evt);
            }
        });
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPTransfuciones.5
            public void focusLost(FocusEvent evt) {
                JPTransfuciones.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPTransfuciones.6
            public void keyPressed(KeyEvent evt) {
                JPTransfuciones.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnóstico", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPTransfuciones.7
            public void mouseClicked(MouseEvent evt) {
                JPTransfuciones.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPTransfuciones.8
            public void keyPressed(KeyEvent evt) {
                JPTransfuciones.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Transfusiones previas:");
        this.JBGTRanPrevias.add(this.JRBSI1);
        this.JRBSI1.setFont(new Font("Arial", 1, 12));
        this.JRBSI1.setText("SI");
        this.JRBSI1.addActionListener(new ActionListener() { // from class: Historia.JPTransfuciones.9
            public void actionPerformed(ActionEvent evt) {
                JPTransfuciones.this.JRBSI1ActionPerformed(evt);
            }
        });
        this.JBGTRanPrevias.add(this.JRBNO1);
        this.JRBNO1.setFont(new Font("Arial", 1, 12));
        this.JRBNO1.setSelected(true);
        this.JRBNO1.setText("NO");
        this.JRBNO1.addActionListener(new ActionListener() { // from class: Historia.JPTransfuciones.10
            public void actionPerformed(ActionEvent evt) {
                JPTransfuciones.this.JRBNO1ActionPerformed(evt);
            }
        });
        this.txtFechaUltT.setBorder(BorderFactory.createTitledBorder((Border) null, "Ult. Transfusión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtFechaUltT.setToolTipText("Ultima Transfusión");
        this.txtFechaUltT.setDateFormatString("dd/MM/yyyy");
        this.txtFechaUltT.setFont(new Font("Tahoma", 1, 12));
        this.txtFechaUltT.addKeyListener(new KeyAdapter() { // from class: Historia.JPTransfuciones.11
            public void keyPressed(KeyEvent evt) {
                JPTransfuciones.this.txtFechaUltTKeyPressed(evt);
            }
        });
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Solicitud urgente:");
        this.JBGUrgente.add(this.JRBSI2);
        this.JRBSI2.setFont(new Font("Arial", 1, 12));
        this.JRBSI2.setText("SI");
        this.JRBSI2.addActionListener(new ActionListener() { // from class: Historia.JPTransfuciones.12
            public void actionPerformed(ActionEvent evt) {
                JPTransfuciones.this.JRBSI2ActionPerformed(evt);
            }
        });
        this.JBGUrgente.add(this.JRBNO2);
        this.JRBNO2.setFont(new Font("Arial", 1, 12));
        this.JRBNO2.setSelected(true);
        this.JRBNO2.setText("NO");
        this.JRBNO2.addActionListener(new ActionListener() { // from class: Historia.JPTransfuciones.13
            public void actionPerformed(ActionEvent evt) {
                JPTransfuciones.this.JRBNO2ActionPerformed(evt);
            }
        });
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Autorizo sin prueba cruzada:");
        this.JBGPCruzada.add(this.JRBSI3);
        this.JRBSI3.setFont(new Font("Arial", 1, 12));
        this.JRBSI3.setText("SI");
        this.JRBSI3.addActionListener(new ActionListener() { // from class: Historia.JPTransfuciones.14
            public void actionPerformed(ActionEvent evt) {
                JPTransfuciones.this.JRBSI3ActionPerformed(evt);
            }
        });
        this.JBGPCruzada.add(this.JRBNO3);
        this.JRBNO3.setFont(new Font("Arial", 1, 12));
        this.JRBNO3.setSelected(true);
        this.JRBNO3.setText("NO");
        this.JRBNO3.addActionListener(new ActionListener() { // from class: Historia.JPTransfuciones.15
            public void actionPerformed(ActionEvent evt) {
                JPTransfuciones.this.JRBNO3ActionPerformed(evt);
            }
        });
        this.JTFFHTO1.setBorder(BorderFactory.createTitledBorder((Border) null, "HTO", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHTO1.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.##"))));
        this.JTFFHTO1.setHorizontalAlignment(0);
        this.JTFFHTO1.setFont(new Font("Arial", 1, 12));
        this.JTFFGRDL.setBorder(BorderFactory.createTitledBorder((Border) null, "gr/dl", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFGRDL.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.##"))));
        this.JTFFGRDL.setHorizontalAlignment(0);
        this.JTFFGRDL.setFont(new Font("Arial", 1, 12));
        this.JTFFHTO2.setBorder(BorderFactory.createTitledBorder((Border) null, "HTO %", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHTO2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.##"))));
        this.JTFFHTO2.setHorizontalAlignment(0);
        this.JTFFHTO2.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtFecha, -2, 130, -2).addGap(10, 10, 10).addComponent(this.txtHora, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCDxP, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSI1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNO1).addGap(5, 5, 5).addComponent(this.txtFechaUltT, -2, 130, -2).addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSI2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNO2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSI3).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNO3))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, 32767).addComponent(this.JTFFHTO1, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFGRDL, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHTO2, -2, 70, -2)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtFecha, -2, 45, 32767).addGroup(jPanel1Layout.createSequentialGroup().addGap(3, 3, 3).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtHora, -2, 40, -2).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, -1, -2)))).addGap(5, 5, 5).addComponent(this.jScrollPane1, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtFechaUltT, -2, -1, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.JRBSI1).addComponent(this.JRBNO1))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.JRBSI2).addComponent(this.JRBNO2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.JRBSI3).addComponent(this.JRBNO3))).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHTO1, -2, 44, -2).addComponent(this.JTFFGRDL, -2, 44, -2).addComponent(this.JTFFHTO2, -2, 44, -2)).addGap(3, 3, 3)))));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "SOLICITUD DE UNIDADES", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Cant.", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCantidad.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFCantidad.setHorizontalAlignment(0);
        this.JTFFCantidad.setText("1");
        this.JTFFCantidad.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBAdicionar.setText("Adicionar");
        this.JBAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPTransfuciones.16
            public void actionPerformed(ActionEvent evt) {
                JPTransfuciones.this.JBAdicionarActionPerformed(evt);
            }
        });
        this.JCBProcedimientos.setEditable(true);
        this.JCBProcedimientos.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimientos.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBProcedimientos, 0, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCantidad, -2, 57, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBAdicionar, -2, 138, -2).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBAdicionar, -2, 44, -2).addComponent(this.JTFFCantidad, -2, 44, -2)).addComponent(this.JCBProcedimientos, GroupLayout.Alignment.TRAILING, -2, 46, -2));
        this.JSPDiagnosticos.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTProc.setFont(new Font("Arial", 1, 12));
        this.JTProc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTProc.setSelectionBackground(new Color(255, 255, 255));
        this.JTProc.setSelectionForeground(new Color(255, 0, 0));
        this.JTProc.addMouseListener(new MouseAdapter() { // from class: Historia.JPTransfuciones.17
            public void mouseClicked(MouseEvent evt) {
                JPTransfuciones.this.JTProcMouseClicked(evt);
            }
        });
        this.JTProc.addKeyListener(new KeyAdapter() { // from class: Historia.JPTransfuciones.18
            public void keyPressed(KeyEvent evt) {
                JPTransfuciones.this.JTProcKeyPressed(evt);
            }
        });
        this.JSPDiagnosticos.setViewportView(this.JTProc);
        this.JPMonitoreo.setBorder(BorderFactory.createTitledBorder((Border) null, "MONITOREO", 2, 0, new Font("Arial", 1, 12), new Color(0, 102, 0)));
        this.JSPMonitoreo.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTMonitoreo.setFont(new Font("Arial", 1, 12));
        this.JTMonitoreo.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTMonitoreo.setSelectionBackground(new Color(255, 255, 255));
        this.JTMonitoreo.setSelectionForeground(new Color(255, 0, 0));
        this.JTMonitoreo.addKeyListener(new KeyAdapter() { // from class: Historia.JPTransfuciones.19
            public void keyPressed(KeyEvent evt) {
                JPTransfuciones.this.JTMonitoreoKeyPressed(evt);
            }
        });
        this.JSPMonitoreo.setViewportView(this.JTMonitoreo);
        GroupLayout JPMonitoreoLayout = new GroupLayout(this.JPMonitoreo);
        this.JPMonitoreo.setLayout(JPMonitoreoLayout);
        JPMonitoreoLayout.setHorizontalGroup(JPMonitoreoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPMonitoreoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPMonitoreo)));
        JPMonitoreoLayout.setVerticalGroup(JPMonitoreoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMonitoreo, -1, 159, 32767));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(3, 3, 3).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JPMonitoreo, -1, -1, 32767).addContainerGap()).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDiagnosticos).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addGap(3, 3, 3)))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.jPanel1, -2, -1, -2).addGap(3, 3, 3).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDiagnosticos, -2, 133, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPMonitoreo, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHoraKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.txtHora.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 0);
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        mBuscarPatologiaN(this.JTFCDxP, this.JTFNCodigoDxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtFechaUltTKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSI1ActionPerformed(ActionEvent evt) {
        this.xPrevia = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNO1ActionPerformed(ActionEvent evt) {
        this.xPrevia = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSI2ActionPerformed(ActionEvent evt) {
        this.xUrgente = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNO2ActionPerformed(ActionEvent evt) {
        this.xUrgente = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSI3ActionPerformed(ActionEvent evt) {
        this.xAutoriza = 1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNO3ActionPerformed(ActionEvent evt) {
        this.xAutoriza = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBAdicionarActionPerformed(ActionEvent evt) {
        mAdicionarPTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProcKeyPressed(KeyEvent evt) {
        if (this.xnombre.equals("xTransfusionHC") && evt.getKeyCode() == 127) {
            mEliminarFilaGrid();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTMonitoreoKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTProcMouseClicked(MouseEvent evt) {
        int columna = this.JTProc.columnAtPoint(evt.getPoint());
        int fila = this.JTProc.rowAtPoint(evt.getPoint());
        if (this.JTProc.getModel().getColumnClass(columna).equals(JButton.class) && Long.valueOf(this.xmodeloPro.getValueAt(this.JTProc.getSelectedRow(), 10).toString()).longValue() == 0 && this.JTProc.getSelectedRow() == fila) {
            JDTrasfusiones xJDTrasfusiones = new JDTrasfusiones(null, true, this);
            xJDTrasfusiones.setVisible(true);
        } else if (this.JTProc.getModel().getColumnClass(columna).equals(JButton.class) && Long.valueOf(this.xmodeloPro.getValueAt(this.JTProc.getSelectedRow(), 10).toString()).longValue() == 1 && this.JTProc.getSelectedRow() == fila) {
            JDTrasfusionesMonitoreo xJDTrasfusionesMonitoreo = new JDTrasfusionesMonitoreo(null, true, this, this.xmodeloPro.getValueAt(this.JTProc.getSelectedRow(), 0).toString(), this.xmodeloPro.getValueAt(this.JTProc.getSelectedRow(), 5).toString());
            xJDTrasfusionesMonitoreo.setVisible(true);
        }
    }

    public void mEliminarFilaGrid() {
        if (this.xmt.getPregunta("Esta seguro de Eliminar el procedimiento?") == 0) {
            this.xmodeloPro.removeRow(this.JTProc.getSelectedRow());
            this.xfilasproc--;
            this.xmt.mostrarMensaje("Procedimiento Eliminado");
        }
    }

    private void mAdicionarPTabla() {
        if (this.JCBProcedimientos.getSelectedIndex() != -1) {
            if (!this.JTFFCantidad.getText().equals("")) {
                for (int i = 0; i < Integer.parseInt(this.JTFFCantidad.getText().toString()); i++) {
                    this.xmodeloPro.addRow(this.xdatos);
                    this.xmodeloPro.setValueAt("", this.xfilasproc, 0);
                    this.xmodeloPro.setValueAt("", this.xfilasproc, 1);
                    this.xmodeloPro.setValueAt(this.xProc[this.JCBProcedimientos.getSelectedIndex()], this.xfilasproc, 2);
                    this.xmodeloPro.setValueAt(this.JCBProcedimientos.getSelectedItem(), this.xfilasproc, 3);
                    this.xmodeloPro.setValueAt("1", this.xfilasproc, 4);
                    this.xmodeloPro.setValueAt("", this.xfilasproc, 5);
                    this.xmodeloPro.setValueAt("", this.xfilasproc, 6);
                    this.xmodeloPro.setValueAt("", this.xfilasproc, 7);
                    this.xmodeloPro.setValueAt("", this.xfilasproc, 8);
                    this.xmodeloPro.setValueAt(false, this.xfilasproc, 9);
                    this.xfilasproc++;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Digite una cantidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFCantidad.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Seleccione un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFCantidad.requestFocus();
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "' and Estado=1";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGÍA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void mBuscarPatologiaN(JTextField codigo, JTextField nombrep) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "transfusiones", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    public void mGuardar() {
        if (this.xnombre.equals("xTransfusionHC")) {
            if (!mVerificaTrans()) {
                if (!this.JTFCDxP.getText().isEmpty()) {
                    if (this.JTProc.getRowCount() > 0) {
                        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar la información?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (n == 0) {
                            mGuardaOrden();
                            mGuardaEncabezado();
                            mGuardaDetalleM();
                            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe adicionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe selccionar el Diagnóstico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFCDxP.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Esta atención ya posee una Orden registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        mGuardaAplicacion();
    }

    private void mGuardaEncabezado() {
        String sql = "INSERT INTO  `h_ordenes_transfusiones` (IdOrden,`IdAtencion`, `IdUsuario`,  `idProfesional`, `IdEspecialidad`, `FechaR`, `Hora`, `Dx`, `TPrevia`, `UTransfusion`, `SUrgente`,  `Autorizacion`, `Motivo`,  `UsuarioS`,HTO,GRDL,HTOPorc)  VALUES ('" + this.xidOrden + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + this.xmt.formatoAMD.format(this.txtFecha.getDate()) + "', '" + this.xmt.formatoH24.format(this.txtHora.getValue()) + "', '" + this.JTFCDxP.getText() + "', '" + this.xPrevia + "', '" + this.xmt.formatoAMD.format(this.txtFechaUltT.getDate()) + "', '" + this.xUrgente + "',  '" + this.xAutoriza + "', '" + this.JTAMotivo.getText() + "',  '" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.JTFFHTO1.getValue() + "','" + this.JTFFGRDL.getValue() + "','" + this.JTFFHTO2.getValue() + "')";
        this.xTrasnfusion = this.xct.ejecutarSQLId(sql);
        this.xct.cerrarConexionBd();
    }

    private void mGuardaDetalleM() {
        for (int i = 0; i < this.JTProc.getRowCount(); i++) {
            String sql = "INSERT INTO `h_ordenes_transfusiones_detalle` (`IdTrasfusion`,`IdProcedimiento`,`Cantidad`) VALUES('" + this.xTrasnfusion + "','" + this.xmodeloPro.getValueAt(i, 2) + "','" + this.xmodeloPro.getValueAt(i, 4) + "')";
            this.xct.ejecutarSQL(sql);
            this.xct.cerrarConexionBd();
            String sql2 = "insert into h_itemordenesproced(Id_HOrdenes, Id_Procedimiento, IdtipofinProc, Cantidad, Descripcion, Fecha, UsuarioS)  values('" + this.xidOrden + "','" + this.xmodeloPro.getValueAt(i, 2) + "',3," + this.xmodeloPro.getValueAt(i, 4) + ",'" + this.JTAMotivo.getText() + "','" + this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xct.ejecutarSQL(sql2);
            this.xct.cerrarConexionBd();
        }
    }

    private void mGuardaOrden() {
        String sql = "INSERT INTO `h_ordenes` (`Id_Atencion`,`Id_TipoServicio`,`IdTipoFormula` , Id_TipoA,`Id_Profesional`,`Id_Especialidad`,`FechaOrden`,`Fecha`,`UsuarioS`) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','16','0','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoAtencion() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
        this.xidOrden = this.xct.ejecutarSQLId(sql);
        this.xct.cerrarConexionBd();
    }

    private void mGuardaAplicacion() {
        if (mVerificaGuardado()) {
            if (!mComprobacion()) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar la información?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    for (int i = 0; i < this.JTProc.getRowCount(); i++) {
                        if (Boolean.valueOf(this.xmodeloPro.getValueAt(i, 9).toString()).booleanValue() && Long.valueOf(this.xmodeloPro.getValueAt(i, 10).toString()).longValue() != 1) {
                            String sql = "UPDATE `h_ordenes_transfusiones_detalle` SET `Codigo`='" + this.xmodeloPro.getValueAt(i, 1) + "' ,`NoBolsa`='" + this.xmodeloPro.getValueAt(i, 5) + "',`SCalidad`='" + this.xmodeloPro.getValueAt(i, 6) + "',`PCruzada`='" + this.xmodeloPro.getValueAt(i, 7) + "',`Hora`='" + this.xmodeloPro.getValueAt(i, 8) + "',`Estado`='1', Aplicada='1', IdProfesional='" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', IdEspecialidad='" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "'  WHERE `Id`='" + this.xmodeloPro.getValueAt(i, 0) + "'";
                            this.xct.ejecutarSQL(sql);
                            this.xct.cerrarConexionBd();
                            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
                        }
                    }
                    mBuscarTrasfusion(Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText());
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Falta completar Información", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "No tiene información pendiete por Grabar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private boolean mComprobacion() {
        boolean xcomp = false;
        for (int i = 0; i < this.JTProc.getRowCount(); i++) {
            if (Boolean.valueOf(this.xmodeloPro.getValueAt(i, 9).toString()).booleanValue()) {
                if (this.xmodeloPro.getValueAt(i, 1).toString().equals("") || this.xmodeloPro.getValueAt(i, 5).toString().equals("") || this.xmodeloPro.getValueAt(i, 6).toString().equals("") || this.xmodeloPro.getValueAt(i, 7).toString().equals("") || this.xmodeloPro.getValueAt(i, 8).toString().equals("")) {
                    xcomp = true;
                    break;
                }
                xcomp = false;
            }
        }
        return xcomp;
    }

    private boolean mVerificaGuardado() {
        boolean xcomp = false;
        int i = 0;
        while (true) {
            if (i >= this.JTProc.getRowCount()) {
                break;
            }
            if (this.xmodeloPro.getValueAt(i, 10).toString().equals("0")) {
                xcomp = true;
                break;
            }
            xcomp = false;
            i++;
        }
        return xcomp;
    }

    private void buscarProcedimiento(JTextField codigo, JTextField nombrep) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_procedimiento where Id='" + codigo.getText().toUpperCase() + "'";
                ResultSet res = this.xct.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    nombrep.setText(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PROCEDIMIENTO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    nombrep.setText((String) null);
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCreaModelodx() {
        this.xmodeloPro = new DefaultTableModel(new Object[0], new String[]{"Id", "Codigo", "CUP", "Hemocomponente", "Cant.", "No.Bolsa", "SelloCalidad", "PruebaCruzada", "Hora", "Relizado", "Aplicada", "Acción"}) { // from class: Historia.JPTransfuciones.20
            Class[] types = {Integer.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, String.class, Boolean.class, Long.class, JButton.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTProc.setDefaultRenderer(JButton.class, new TableCellRenderer() { // from class: Historia.JPTransfuciones.21
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                return (Component) objeto;
            }
        });
        this.JTProc.setModel(this.xmodeloPro);
        this.JTProc.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTProc.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTProc.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTProc.getColumnModel().getColumn(1).setPreferredWidth(18);
        this.JTProc.getColumnModel().getColumn(2).setPreferredWidth(8);
        this.JTProc.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTProc.getColumnModel().getColumn(4).setPreferredWidth(3);
        this.JTProc.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTProc.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTProc.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.JTProc.getColumnModel().getColumn(8).setPreferredWidth(11);
        this.JTProc.getColumnModel().getColumn(9).setPreferredWidth(5);
        this.JTProc.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTProc.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTProc.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTProc.getColumnModel().getColumn(11).setPreferredWidth(60);
        if (this.xnombre.equals("xTransfusionHC")) {
            this.JTProc.getColumnModel().getColumn(1).setMinWidth(0);
            this.JTProc.getColumnModel().getColumn(1).setMaxWidth(0);
            this.JTProc.getColumnModel().getColumn(5).setMinWidth(0);
            this.JTProc.getColumnModel().getColumn(5).setMaxWidth(0);
            this.JTProc.getColumnModel().getColumn(6).setMinWidth(0);
            this.JTProc.getColumnModel().getColumn(6).setMaxWidth(0);
            this.JTProc.getColumnModel().getColumn(7).setMinWidth(0);
            this.JTProc.getColumnModel().getColumn(7).setMaxWidth(0);
            this.JTProc.getColumnModel().getColumn(8).setMinWidth(0);
            this.JTProc.getColumnModel().getColumn(8).setMaxWidth(0);
            this.JTProc.getColumnModel().getColumn(9).setMinWidth(0);
            this.JTProc.getColumnModel().getColumn(9).setMaxWidth(0);
            this.JTProc.getColumnModel().getColumn(11).setMinWidth(0);
            this.JTProc.getColumnModel().getColumn(11).setMaxWidth(0);
        }
    }

    private void mIniciarComp() {
        if (!this.xnombre.equals("xTransfusionHC")) {
            this.jPanel2.setVisible(false);
        }
        if (this.xnombre.equals("xTransfusionHC")) {
            this.JPMonitoreo.setVisible(false);
        }
    }

    private void mBuscarTrasfusion(String xIdAtencion) {
        String sql = "SELECT `h_ordenes_transfusiones_detalle`.`Id`  ,h_ordenes_transfusiones_detalle.`Codigo`, `h_ordenes_transfusiones_detalle`.`IdProcedimiento` , `g_procedimiento`.`Nbre`     , `h_ordenes_transfusiones_detalle`.`Cantidad` , `h_ordenes_transfusiones_detalle`.`NoBolsa` , `h_ordenes_transfusiones_detalle`.`SCalidad`     , `h_ordenes_transfusiones_detalle`.`PCruzada` , IF(`h_ordenes_transfusiones_detalle`.`Hora` IS NULL,'',`h_ordenes_transfusiones_detalle`.`Hora`)AS HoraD  , `h_ordenes_transfusiones_detalle`.`Estado`, h_ordenes_transfusiones_detalle.Aplicada     , `h_ordenes_transfusiones`.`FechaR` , `h_ordenes_transfusiones`.`Hora` , `h_ordenes_transfusiones`.`Dx` , `h_ordenes_transfusiones`.`Motivo`     , `h_ordenes_transfusiones`.`TPrevia` , `h_ordenes_transfusiones`.`UTransfusion` , `h_ordenes_transfusiones`.`SUrgente` , `h_ordenes_transfusiones`.`Autorizacion`     , `h_ordenes_transfusiones`.`HTO` , `h_ordenes_transfusiones`.`GRDL` , `h_ordenes_transfusiones`.`HTOPorc` FROM `h_ordenes_transfusiones_detalle`   INNER JOIN `baseserver`.`g_procedimiento`  ON (`h_ordenes_transfusiones_detalle`.`IdProcedimiento` = `g_procedimiento`.`Id`) INNER JOIN `baseserver`.`h_ordenes_transfusiones` ON (`h_ordenes_transfusiones_detalle`.`IdTrasfusion` = `h_ordenes_transfusiones`.`Id`) WHERE (`h_ordenes_transfusiones`.`IdAtencion` ='" + xIdAtencion + "' AND h_ordenes_transfusiones.`Estado`=1);";
        ResultSet xrs = this.xct.traerRs(sql);
        mCreaModelodx();
        try {
            if (xrs.next()) {
                xrs.first();
                this.txtFecha.setDate(xrs.getDate("FechaR"));
                this.txtHora.setText(xrs.getString("Hora"));
                this.JTFCDxP.setText(xrs.getString("Dx"));
                mBuscaDX(xrs.getString("Dx"));
                this.JTAMotivo.setText(xrs.getString("Motivo"));
                if (xrs.getLong("TPrevia") == 1) {
                    this.JRBSI1.setSelected(true);
                } else {
                    this.JRBNO1.setSelected(true);
                }
                this.txtFechaUltT.setDate(xrs.getDate("UTransfusion"));
                if (xrs.getLong("SUrgente") == 1) {
                    this.JRBSI2.setSelected(true);
                } else {
                    this.JRBNO2.setSelected(true);
                }
                if (xrs.getLong("Autorizacion") == 1) {
                    this.JRBSI3.setSelected(true);
                } else {
                    this.JRBNO3.setSelected(true);
                }
                this.JTFFHTO1.setValue(Double.valueOf(xrs.getDouble("HTO")));
                this.JTFFGRDL.setValue(Double.valueOf(xrs.getDouble("GRDL")));
                this.JTFFHTO2.setValue(Double.valueOf(xrs.getDouble("HTOPorc")));
                int n = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodeloPro.addRow(this.xdatos);
                    this.xmodeloPro.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloPro.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloPro.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloPro.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloPro.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloPro.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloPro.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloPro.setValueAt(xrs.getString(8), n, 7);
                    this.xmodeloPro.setValueAt(xrs.getString(9), n, 8);
                    this.xmodeloPro.setValueAt(Boolean.valueOf(xrs.getBoolean(10)), n, 9);
                    this.JTProc.setDefaultRenderer(Object.class, new MiRender());
                    this.xmodeloPro.setValueAt(Long.valueOf(xrs.getLong(11)), n, 10);
                    if (Long.valueOf(this.xmodeloPro.getValueAt(n, 10).toString()).longValue() == 1) {
                        this.xmodeloPro.setValueAt(new JButton("Monitorear"), n, 11);
                    } else {
                        this.xmodeloPro.setValueAt(new JButton("Aplicar"), n, 11);
                    }
                    n++;
                }
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTransfuciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscaDX(String x) {
        String sql = "SELECT  `Id` , `Nbre` FROM `g_patologia` WHERE (`Id` ='" + x + "');";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                String dx = xrs.getString("Nbre");
                this.JTFNCodigoDxP.setText(dx);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTransfuciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JPTransfuciones$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            long xestado = Long.valueOf(table.getValueAt(row, 10).toString()).longValue();
            if (xestado == 1) {
                cell.setBackground(new Color(70, 87, 240));
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(Color.WHITE);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloMonitoreo() {
        this.xmodeloMon = new DefaultTableModel(new Object[0], new String[]{"No.Bolsa", "Momento", "Fecha", "Hora", "T/A", "Pulso", "RAdversa", "Observación"}) { // from class: Historia.JPTransfuciones.22
            Class[] types = {String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTMonitoreo.setModel(this.xmodeloMon);
        this.JTMonitoreo.getColumnModel().getColumn(0).setPreferredWidth(15);
        this.JTMonitoreo.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTMonitoreo.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTMonitoreo.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTMonitoreo.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTMonitoreo.getColumnModel().getColumn(5).setPreferredWidth(10);
        this.JTMonitoreo.getColumnModel().getColumn(6).setPreferredWidth(8);
        this.JTMonitoreo.getColumnModel().getColumn(7).setPreferredWidth(50);
    }

    public void mBuscaMonitoreo() {
        String sql = "SELECT   `h_ordenes_transfusiones_detalle`.`NoBolsa`, `h_ordenes_transfusiones_monitoreo`.`Momento`, DATE_FORMAT(`h_ordenes_transfusiones_monitoreo`.`FechaR`,'%d-%m-%Y') as FechaR  , `h_ordenes_transfusiones_monitoreo`.`Hora`       , `h_ordenes_transfusiones_monitoreo`.`T_A` , `h_ordenes_transfusiones_monitoreo`.`Pulso` , `h_ordenes_transfusiones_monitoreo`.`RAdversa`     , `h_ordenes_transfusiones_monitoreo`.`Observacion`   FROM `h_ordenes_transfusiones_monitoreo`  INNER JOIN `baseserver`.`h_ordenes_transfusiones_detalle`   ON (`h_ordenes_transfusiones_monitoreo`.`IdBolsa` = `h_ordenes_transfusiones_detalle`.`Id`)     INNER JOIN `baseserver`.`h_ordenes_transfusiones`   ON (`h_ordenes_transfusiones_detalle`.`IdTrasfusion` = `h_ordenes_transfusiones`.`Id`)  WHERE (`h_ordenes_transfusiones_monitoreo`.`Estado` =1 AND `h_ordenes_transfusiones`.`IdAtencion` ='" + Principal.claseenfer.xjifhc_uhh.JLBNAatencion.getText() + "')  GROUP BY `h_ordenes_transfusiones_monitoreo`.`Momento`, `h_ordenes_transfusiones_monitoreo`.`IdBolsa`  ORDER BY `h_ordenes_transfusiones_monitoreo`.`IdBolsa` ASC, `h_ordenes_transfusiones_monitoreo`.`Hora` ASC ";
        mModeloMonitoreo();
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloMon.addRow(this.xdatos);
                    this.xmodeloMon.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloMon.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloMon.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloMon.setValueAt(xrs.getString(4), n, 3);
                    this.xmodeloMon.setValueAt(xrs.getString(5), n, 4);
                    this.xmodeloMon.setValueAt(xrs.getString(6), n, 5);
                    this.xmodeloMon.setValueAt(xrs.getString(7), n, 6);
                    this.xmodeloMon.setValueAt(xrs.getString(8), n, 7);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTransfuciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private boolean mVerificaTrans() {
        boolean xExiste = false;
        String sql = "SELECT  `Id` FROM  `h_ordenes_transfusiones` WHERE IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND Estado=1;";
        ResultSet xrs = this.xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xExiste = true;
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPTransfuciones.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xExiste;
    }

    public void mAnular() {
        if (this.xnombre.equals("xTransfusionHC")) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Anular?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "UPDATE h_ordenes_transfusiones SET Estado=0 WHERE IdAtencion='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "'";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                Principal.clasehistoriace.xjifhistoriaclinica.xJPTransfuciones = new JPTransfuciones("xTransfusionHC");
                Principal.clasehistoriace.xjifhistoriaclinica.mMostrarPanel1(Principal.clasehistoriace.xjifhistoriaclinica.xJPTransfuciones);
            }
        }
    }
}
