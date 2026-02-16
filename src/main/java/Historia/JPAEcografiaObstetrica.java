package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAEcografiaObstetrica.class */
public class JPAEcografiaObstetrica extends JPanel {
    private String xnombre;
    private clasesHistoriaCE xclase;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloh;
    private Object[] xdatos;
    String[] xpresentacion;
    private String xecografia;
    private ButtonGroup JBGCircCordon;
    private ButtonGroup JBGDorso;
    private ButtonGroup JBGFeto;
    private ButtonGroup JBGGrado;
    private ButtonGroup JBGMalFetal;
    private ButtonGroup JBGPlacenta;
    private ButtonGroup JBGPosicion;
    private ButtonGroup JBGPresentacion;
    private ButtonGroup JBGSexo;
    private ButtonGroup JBGSituacion;
    private JButton JBTGuardar;
    private JComboBox JCBPresentacion;
    private JDateChooser JDCFUM;
    private JDateChooser JDCFechaParto;
    private JPanel JPBiometria;
    private JPanel JPCircCordon;
    private JPanel JPDorso;
    private JPanel JPEcografia;
    private JPanel JPFeto;
    private JPanel JPGrado;
    private JPanel JPHistorico;
    private JPanel JPIGestacion;
    private JPanel JPMalFetal;
    private JPanel JPPlacenta;
    private JPanel JPPosicion;
    private JPanel JPSexo;
    private JPanel JPSituacion;
    private JRadioButton JRBAnterior;
    private JRadioButton JRBAnterior1;
    private JRadioButton JRBDerecha;
    private JRadioButton JRBFem;
    private JRadioButton JRBGrado1;
    private JRadioButton JRBGrado2;
    private JRadioButton JRBGrado3;
    private JRadioButton JRBGrado4;
    private JRadioButton JRBIzquierda;
    private JRadioButton JRBLateral;
    private JRadioButton JRBLateral1;
    private JRadioButton JRBLongitudinal;
    private JRadioButton JRBMasc;
    private JRadioButton JRBMultiple;
    private JRadioButton JRBNoCC;
    private JRadioButton JRBNoMF;
    private JRadioButton JRBOblicuo;
    private JRadioButton JRBPosterior;
    private JRadioButton JRBPosterior1;
    private JRadioButton JRBPosterior2;
    private JRadioButton JRBPosterior3;
    private JRadioButton JRBSiCC;
    private JRadioButton JRBSiMF;
    private JRadioButton JRBTransverso;
    private JRadioButton JRBUnico;
    private JScrollPane JSPAbatomiaFetal;
    private JScrollPane JSPHistorico;
    private JScrollPane JSP_MovFetal;
    private JScrollPane JSP_MovRespiratorio;
    private JTextArea JTAConclusion;
    private JTextArea JTA_MovFetal;
    private JTextArea JTA_MovRespiratorio;
    private JTable JTAnatomiaF;
    public JTable JTDetalleHistorico;
    private JTextField JTFCantidadFeto;
    private JFormattedTextField JTFFAC;
    private JFormattedTextField JTFFDBP;
    private JFormattedTextField JTFFFCardiaca;
    private JFormattedTextField JTFFFEspesor;
    private JFormattedTextField JTFFFILA;
    private JFormattedTextField JTFFFSGestacion;
    private JFormattedTextField JTFFHC;
    private JFormattedTextField JTFFLF;
    private JFormattedTextField JTFFLcn;
    private JFormattedTextField JTFFPonderado;
    private JFormattedTextField JTFFSG;
    private JFormattedTextField JTFFVV;
    private JFormattedTextField JTFF_PesoFetal;
    private JFormattedTextField JTFF_SGestacion_Eco;
    private JTabbedPane JTPEcografias;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private int estado = 2;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    private int xfeto = 1;
    private int xsituacion = 1;
    private int xposicion = 1;
    private int xdorso = 1;
    private int xplcenta = 1;
    private int xgrado = 1;
    private int xmalformacion = 0;
    private int xcordon = 1;
    private String xsexo = "";

    public JPAEcografiaObstetrica(String nombre, clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        this.xnombre = nombre;
        setName(nombre);
        mCargarCombos();
        mBuscarAnatomiaFetal();
        mCargarDatosTablaHistorico();
    }

    /* JADX WARN: Type inference failed for: r3v387, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v67, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFeto = new ButtonGroup();
        this.JBGSituacion = new ButtonGroup();
        this.JBGPosicion = new ButtonGroup();
        this.JBGPresentacion = new ButtonGroup();
        this.JBGDorso = new ButtonGroup();
        this.JBGPlacenta = new ButtonGroup();
        this.JBGGrado = new ButtonGroup();
        this.JBGMalFetal = new ButtonGroup();
        this.JBGCircCordon = new ButtonGroup();
        this.JBGSexo = new ButtonGroup();
        this.JTPEcografias = new JTabbedPane();
        this.JPEcografia = new JPanel();
        this.JBTGuardar = new JButton();
        this.JPBiometria = new JPanel();
        this.JTFFLcn = new JFormattedTextField();
        this.JTFFSG = new JFormattedTextField();
        this.JTFFVV = new JFormattedTextField();
        this.JTFFDBP = new JFormattedTextField();
        this.JTFFHC = new JFormattedTextField();
        this.JTFFAC = new JFormattedTextField();
        this.JTFFLF = new JFormattedTextField();
        this.jScrollPane1 = new JScrollPane();
        this.JTAConclusion = new JTextArea();
        this.JSPAbatomiaFetal = new JScrollPane();
        this.JTAnatomiaF = new JTable();
        this.JPIGestacion = new JPanel();
        this.JDCFUM = new JDateChooser();
        this.JDCFechaParto = new JDateChooser();
        this.JTFFFSGestacion = new JFormattedTextField();
        this.JPFeto = new JPanel();
        this.JRBMultiple = new JRadioButton();
        this.JRBUnico = new JRadioButton();
        this.JTFCantidadFeto = new JTextField();
        this.JPSexo = new JPanel();
        this.JRBMasc = new JRadioButton();
        this.JRBFem = new JRadioButton();
        this.JTFFFCardiaca = new JFormattedTextField();
        this.JTFFPonderado = new JFormattedTextField();
        this.JTFF_SGestacion_Eco = new JFormattedTextField();
        this.JTFF_PesoFetal = new JFormattedTextField();
        this.jPanel1 = new JPanel();
        this.JCBPresentacion = new JComboBox();
        this.JPPosicion = new JPanel();
        this.JRBIzquierda = new JRadioButton();
        this.JRBDerecha = new JRadioButton();
        this.JPDorso = new JPanel();
        this.JRBAnterior = new JRadioButton();
        this.JRBLateral = new JRadioButton();
        this.JRBPosterior = new JRadioButton();
        this.JPSituacion = new JPanel();
        this.JRBTransverso = new JRadioButton();
        this.JRBLongitudinal = new JRadioButton();
        this.JRBOblicuo = new JRadioButton();
        this.JPCircCordon = new JPanel();
        this.JRBSiCC = new JRadioButton();
        this.JRBNoCC = new JRadioButton();
        this.JPMalFetal = new JPanel();
        this.JRBSiMF = new JRadioButton();
        this.JRBNoMF = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.JPPlacenta = new JPanel();
        this.JRBAnterior1 = new JRadioButton();
        this.JRBLateral1 = new JRadioButton();
        this.JRBPosterior1 = new JRadioButton();
        this.JRBPosterior2 = new JRadioButton();
        this.JRBPosterior3 = new JRadioButton();
        this.JPGrado = new JPanel();
        this.JRBGrado2 = new JRadioButton();
        this.JRBGrado1 = new JRadioButton();
        this.JRBGrado3 = new JRadioButton();
        this.JRBGrado4 = new JRadioButton();
        this.JTFFFEspesor = new JFormattedTextField();
        this.JTFFFILA = new JFormattedTextField();
        this.JSP_MovFetal = new JScrollPane();
        this.JTA_MovFetal = new JTextArea();
        this.JSP_MovRespiratorio = new JScrollPane();
        this.JTA_MovRespiratorio = new JTextArea();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalleHistorico = new JTable();
        setName("jpaecografiaobstetrica");
        this.JTPEcografias.setForeground(new Color(255, 0, 0));
        this.JTPEcografias.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.1
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JPBiometria.setBorder(BorderFactory.createTitledBorder((Border) null, "BIOMETRIA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFLcn.setBorder(BorderFactory.createTitledBorder((Border) null, "LCN (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFLcn.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFLcn.setHorizontalAlignment(4);
        this.JTFFLcn.setFont(new Font("Arial", 1, 12));
        this.JTFFLcn.setValue(new Integer(0));
        this.JTFFSG.setBorder(BorderFactory.createTitledBorder((Border) null, "SG (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSG.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFSG.setHorizontalAlignment(4);
        this.JTFFSG.setFont(new Font("Arial", 1, 12));
        this.JTFFSG.setValue(new Integer(0));
        this.JTFFVV.setBorder(BorderFactory.createTitledBorder((Border) null, "VV (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFVV.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFVV.setHorizontalAlignment(4);
        this.JTFFVV.setFont(new Font("Arial", 1, 12));
        this.JTFFVV.setValue(new Integer(0));
        this.JTFFDBP.setBorder(BorderFactory.createTitledBorder((Border) null, "DBP (mm)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFDBP.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFDBP.setHorizontalAlignment(4);
        this.JTFFDBP.setFont(new Font("Arial", 1, 12));
        this.JTFFDBP.setValue(new Integer(0));
        this.JTFFHC.setBorder(BorderFactory.createTitledBorder((Border) null, "HC (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFHC.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFHC.setHorizontalAlignment(4);
        this.JTFFHC.setFont(new Font("Arial", 1, 12));
        this.JTFFHC.setValue(new Integer(0));
        this.JTFFAC.setBorder(BorderFactory.createTitledBorder((Border) null, "AC (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFAC.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFAC.setHorizontalAlignment(4);
        this.JTFFAC.setFont(new Font("Arial", 1, 12));
        this.JTFFAC.setValue(new Integer(0));
        this.JTFFLF.setBorder(BorderFactory.createTitledBorder((Border) null, "LF (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFLF.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFLF.setHorizontalAlignment(4);
        this.JTFFLF.setFont(new Font("Arial", 1, 12));
        this.JTFFLF.setValue(new Integer(0));
        GroupLayout JPBiometriaLayout = new GroupLayout(this.JPBiometria);
        this.JPBiometria.setLayout(JPBiometriaLayout);
        JPBiometriaLayout.setHorizontalGroup(JPBiometriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPBiometriaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFFLcn, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSG, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVV, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFDBP, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHC, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFAC, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFLF, -2, 100, -2).addContainerGap(-1, 32767)));
        JPBiometriaLayout.setVerticalGroup(JPBiometriaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPBiometriaLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPBiometriaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFLcn, -2, -1, -2).addComponent(this.JTFFSG, -2, -1, -2).addComponent(this.JTFFVV, -2, -1, -2).addComponent(this.JTFFDBP, -2, -1, -2).addComponent(this.JTFFHC, -2, -1, -2).addComponent(this.JTFFAC, -2, -1, -2).addComponent(this.JTFFLF, -2, -1, -2)).addContainerGap()));
        this.JTAConclusion.setColumns(1);
        this.JTAConclusion.setFont(new Font("Arial", 1, 12));
        this.JTAConclusion.setRows(1);
        this.JTAConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Conclusión", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAConclusion);
        this.JSPAbatomiaFetal.setBorder(BorderFactory.createTitledBorder((Border) null, "Anatomía Fetal", 2, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAnatomiaF.setFont(new Font("Arial", 1, 12));
        this.JTAnatomiaF.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTAnatomiaF.setRowHeight(22);
        this.JTAnatomiaF.setSelectionBackground(new Color(255, 255, 255));
        this.JTAnatomiaF.setSelectionForeground(new Color(255, 0, 0));
        this.JTAnatomiaF.setSelectionMode(0);
        this.JSPAbatomiaFetal.setViewportView(this.JTAnatomiaF);
        this.JPIGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "GESTACIÒN", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFUM.setBackground(new Color(255, 255, 255));
        this.JDCFUM.setBorder(BorderFactory.createTitledBorder((Border) null, "FUM", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDCFUM.setDateFormatString("dd/MM/yyyy");
        this.JDCFUM.setFont(new Font("Arial", 1, 12));
        this.JDCFUM.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAEcografiaObstetrica.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAEcografiaObstetrica.this.JDCFUMPropertyChange(evt);
            }
        });
        this.JDCFechaParto.setBackground(new Color(255, 255, 255));
        this.JDCFechaParto.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha PP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaParto.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaParto.setFont(new Font("Arial", 1, 12));
        this.JTFFFSGestacion.setBorder(BorderFactory.createTitledBorder((Border) null, "S. Gestacion(FUM)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFSGestacion.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFFFSGestacion.setHorizontalAlignment(4);
        this.JTFFFSGestacion.setToolTipText("Digite el Número de la semana");
        this.JTFFFSGestacion.setFont(new Font("Arial", 1, 12));
        this.JTFFFSGestacion.setValue(new Integer(0));
        this.JPFeto.setBorder(BorderFactory.createTitledBorder((Border) null, "Feto", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGFeto.add(this.JRBMultiple);
        this.JRBMultiple.setFont(new Font("Arial", 1, 12));
        this.JRBMultiple.setText("Mútiple");
        this.JRBMultiple.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.3
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBMultipleActionPerformed(evt);
            }
        });
        this.JBGFeto.add(this.JRBUnico);
        this.JRBUnico.setFont(new Font("Arial", 1, 12));
        this.JRBUnico.setSelected(true);
        this.JRBUnico.setText("Único");
        this.JRBUnico.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.4
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBUnicoActionPerformed(evt);
            }
        });
        this.JTFCantidadFeto.setFont(new Font("Arial", 1, 12));
        this.JTFCantidadFeto.setHorizontalAlignment(0);
        this.JTFCantidadFeto.setText("1");
        this.JTFCantidadFeto.setBorder(BorderFactory.createTitledBorder((Border) null, "Cantidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCantidadFeto.setEnabled(false);
        GroupLayout JPFetoLayout = new GroupLayout(this.JPFeto);
        this.JPFeto.setLayout(JPFetoLayout);
        JPFetoLayout.setHorizontalGroup(JPFetoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPFetoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBUnico).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBMultiple).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFCantidadFeto, -1, 73, 32767).addContainerGap()));
        JPFetoLayout.setVerticalGroup(JPFetoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFetoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBMultiple, -2, 23, -2).addComponent(this.JRBUnico).addComponent(this.JTFCantidadFeto, -2, -1, -2)));
        this.JPSexo.setBorder(BorderFactory.createTitledBorder((Border) null, "Sexo", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JRBMasc.setFont(new Font("Arial", 1, 12));
        this.JRBMasc.setText("M");
        this.JRBMasc.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.5
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBMascActionPerformed(evt);
            }
        });
        this.JBGSexo.add(this.JRBFem);
        this.JRBFem.setFont(new Font("Arial", 1, 12));
        this.JRBFem.setText("F");
        this.JRBFem.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.6
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBFemActionPerformed(evt);
            }
        });
        GroupLayout JPSexoLayout = new GroupLayout(this.JPSexo);
        this.JPSexo.setLayout(JPSexoLayout);
        JPSexoLayout.setHorizontalGroup(JPSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSexoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBMasc).addGap(10, 10, 10).addComponent(this.JRBFem).addContainerGap(-1, 32767)));
        JPSexoLayout.setVerticalGroup(JPSexoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPSexoLayout.createSequentialGroup().addGroup(JPSexoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBMasc, -2, 23, -2).addComponent(this.JRBFem)).addGap(0, 0, 32767)));
        this.JTFFFCardiaca.setBorder(BorderFactory.createTitledBorder((Border) null, "Frec. Cardiaca por min", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFCardiaca.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFFCardiaca.setHorizontalAlignment(4);
        this.JTFFFCardiaca.setFont(new Font("Arial", 1, 12));
        this.JTFFFCardiaca.setValue(new Integer(0));
        this.JTFFPonderado.setBorder(BorderFactory.createTitledBorder((Border) null, "Ponderado Fetal +/- 10 % gr", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPonderado.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFPonderado.setHorizontalAlignment(4);
        this.JTFFPonderado.setFont(new Font("Arial", 1, 12));
        this.JTFFPonderado.setValue(new Integer(0));
        this.JTFF_SGestacion_Eco.setBorder(BorderFactory.createTitledBorder((Border) null, "S. Gestacion(ECO)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_SGestacion_Eco.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFF_SGestacion_Eco.setHorizontalAlignment(4);
        this.JTFF_SGestacion_Eco.setToolTipText("Digite el Número de la semana");
        this.JTFF_SGestacion_Eco.setFont(new Font("Arial", 1, 12));
        this.JTFF_SGestacion_Eco.setValue(new Integer(0));
        this.JTFF_PesoFetal.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso Fetal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_PesoFetal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JTFF_PesoFetal.setHorizontalAlignment(4);
        this.JTFF_PesoFetal.setToolTipText("Peso Fetal");
        this.JTFF_PesoFetal.setFont(new Font("Arial", 1, 12));
        this.JTFF_PesoFetal.setValue(new Integer(0));
        GroupLayout JPIGestacionLayout = new GroupLayout(this.JPIGestacion);
        this.JPIGestacion.setLayout(JPIGestacionLayout);
        JPIGestacionLayout.setHorizontalGroup(JPIGestacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGestacionLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIGestacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIGestacionLayout.createSequentialGroup().addComponent(this.JDCFUM, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JDCFechaParto, -2, -1, -2).addGap(35, 35, 35).addComponent(this.JTFFFSGestacion, -2, 131, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFF_SGestacion_Eco, -2, 131, -2).addGap(29, 29, 29).addComponent(this.JTFF_PesoFetal, -2, 131, -2)).addGroup(JPIGestacionLayout.createSequentialGroup().addComponent(this.JTFFFCardiaca, -2, 153, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFPonderado, -2, 180, -2).addGap(31, 31, 31).addComponent(this.JPFeto, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPSexo, -2, -1, -2))).addGap(20, 20, 20)));
        JPIGestacionLayout.setVerticalGroup(JPIGestacionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIGestacionLayout.createSequentialGroup().addContainerGap().addGroup(JPIGestacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFF_SGestacion_Eco).addComponent(this.JTFF_PesoFetal, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPIGestacionLayout.createSequentialGroup().addGap(0, 2, 32767).addGroup(JPIGestacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFFSGestacion, GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.TRAILING, JPIGestacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDCFUM, -1, -1, 32767).addComponent(this.JDCFechaParto, -1, -1, 32767))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIGestacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPFeto, GroupLayout.Alignment.TRAILING, -2, -1, -2).addGroup(GroupLayout.Alignment.TRAILING, JPIGestacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFPonderado, -1, 50, 32767).addComponent(this.JTFFFCardiaca)).addComponent(this.JPSexo, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addGap(10, 10, 10)));
        this.JDCFUM.getAccessibleContext().setAccessibleName("");
        this.JDCFechaParto.getAccessibleContext().setAccessibleName("");
        this.JTFFFSGestacion.getAccessibleContext().setAccessibleName("");
        this.JTFF_SGestacion_Eco.getAccessibleContext().setAccessibleName("");
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "FETO", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBPresentacion.setFont(new Font("Arial", 1, 12));
        this.JCBPresentacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Presentación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JPPosicion.setBorder(BorderFactory.createTitledBorder((Border) null, "Posición", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGPosicion.add(this.JRBIzquierda);
        this.JRBIzquierda.setFont(new Font("Arial", 1, 12));
        this.JRBIzquierda.setText("Izquierdo");
        this.JRBIzquierda.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.7
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBIzquierdaActionPerformed(evt);
            }
        });
        this.JBGPosicion.add(this.JRBDerecha);
        this.JRBDerecha.setFont(new Font("Arial", 1, 12));
        this.JRBDerecha.setSelected(true);
        this.JRBDerecha.setText("Derecho");
        this.JRBDerecha.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.8
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBDerechaActionPerformed(evt);
            }
        });
        GroupLayout JPPosicionLayout = new GroupLayout(this.JPPosicion);
        this.JPPosicion.setLayout(JPPosicionLayout);
        JPPosicionLayout.setHorizontalGroup(JPPosicionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPosicionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBDerecha).addGap(18, 18, 18).addComponent(this.JRBIzquierda).addContainerGap(-1, 32767)));
        JPPosicionLayout.setVerticalGroup(JPPosicionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPosicionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBIzquierda, -2, 23, -2).addComponent(this.JRBDerecha)));
        this.JPDorso.setBorder(BorderFactory.createTitledBorder((Border) null, "Dorso", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGDorso.add(this.JRBAnterior);
        this.JRBAnterior.setFont(new Font("Arial", 1, 12));
        this.JRBAnterior.setText("Anterior");
        this.JRBAnterior.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.9
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBAnteriorActionPerformed(evt);
            }
        });
        this.JBGDorso.add(this.JRBLateral);
        this.JRBLateral.setFont(new Font("Arial", 1, 12));
        this.JRBLateral.setSelected(true);
        this.JRBLateral.setText("Lateral");
        this.JRBLateral.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.10
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBLateralActionPerformed(evt);
            }
        });
        this.JBGDorso.add(this.JRBPosterior);
        this.JRBPosterior.setFont(new Font("Arial", 1, 12));
        this.JRBPosterior.setText("Posterior");
        this.JRBPosterior.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.11
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBPosteriorActionPerformed(evt);
            }
        });
        GroupLayout JPDorsoLayout = new GroupLayout(this.JPDorso);
        this.JPDorso.setLayout(JPDorsoLayout);
        JPDorsoLayout.setHorizontalGroup(JPDorsoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDorsoLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBLateral).addGap(18, 18, 18).addComponent(this.JRBAnterior).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 16, 32767).addComponent(this.JRBPosterior).addContainerGap()));
        JPDorsoLayout.setVerticalGroup(JPDorsoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDorsoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAnterior, -2, 23, -2).addComponent(this.JRBLateral).addComponent(this.JRBPosterior, -2, 23, -2)));
        this.JPSituacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Situación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGSituacion.add(this.JRBTransverso);
        this.JRBTransverso.setFont(new Font("Arial", 1, 12));
        this.JRBTransverso.setText("Transverso");
        this.JRBTransverso.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.12
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBTransversoActionPerformed(evt);
            }
        });
        this.JBGSituacion.add(this.JRBLongitudinal);
        this.JRBLongitudinal.setFont(new Font("Arial", 1, 12));
        this.JRBLongitudinal.setSelected(true);
        this.JRBLongitudinal.setText("Longitudinal");
        this.JRBLongitudinal.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.13
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBLongitudinalActionPerformed(evt);
            }
        });
        this.JBGSituacion.add(this.JRBOblicuo);
        this.JRBOblicuo.setFont(new Font("Arial", 1, 12));
        this.JRBOblicuo.setText("Oblicuo");
        this.JRBOblicuo.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.14
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBOblicuoActionPerformed(evt);
            }
        });
        GroupLayout JPSituacionLayout = new GroupLayout(this.JPSituacion);
        this.JPSituacion.setLayout(JPSituacionLayout);
        JPSituacionLayout.setHorizontalGroup(JPSituacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSituacionLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBLongitudinal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBTransverso).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBOblicuo).addContainerGap(30, 32767)));
        JPSituacionLayout.setVerticalGroup(JPSituacionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPSituacionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBLongitudinal).addComponent(this.JRBTransverso, -2, 23, -2).addComponent(this.JRBOblicuo, -2, 23, -2)));
        this.JPCircCordon.setBorder(BorderFactory.createTitledBorder((Border) null, "Circulación Cordón", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGCircCordon.add(this.JRBSiCC);
        this.JRBSiCC.setFont(new Font("Arial", 1, 12));
        this.JRBSiCC.setSelected(true);
        this.JRBSiCC.setText("Sí");
        this.JRBSiCC.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.15
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBSiCCActionPerformed(evt);
            }
        });
        this.JBGCircCordon.add(this.JRBNoCC);
        this.JRBNoCC.setFont(new Font("Arial", 1, 12));
        this.JRBNoCC.setText("No");
        this.JRBNoCC.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.16
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBNoCCActionPerformed(evt);
            }
        });
        GroupLayout JPCircCordonLayout = new GroupLayout(this.JPCircCordon);
        this.JPCircCordon.setLayout(JPCircCordonLayout);
        JPCircCordonLayout.setHorizontalGroup(JPCircCordonLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPCircCordonLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JRBSiCC).addGap(18, 18, 18).addComponent(this.JRBNoCC).addContainerGap(21, 32767)));
        JPCircCordonLayout.setVerticalGroup(JPCircCordonLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPCircCordonLayout.createSequentialGroup().addGroup(JPCircCordonLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiCC, -2, 23, -2).addComponent(this.JRBNoCC)).addGap(0, 0, 32767)));
        this.JPMalFetal.setBorder(BorderFactory.createTitledBorder((Border) null, "Malformaciones Fetales", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGMalFetal.add(this.JRBSiMF);
        this.JRBSiMF.setFont(new Font("Arial", 1, 12));
        this.JRBSiMF.setText("Sí");
        this.JRBSiMF.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.17
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBSiMFActionPerformed(evt);
            }
        });
        this.JBGMalFetal.add(this.JRBNoMF);
        this.JRBNoMF.setFont(new Font("Arial", 1, 12));
        this.JRBNoMF.setSelected(true);
        this.JRBNoMF.setText("No");
        this.JRBNoMF.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.18
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBNoMFActionPerformed(evt);
            }
        });
        GroupLayout JPMalFetalLayout = new GroupLayout(this.JPMalFetal);
        this.JPMalFetal.setLayout(JPMalFetalLayout);
        JPMalFetalLayout.setHorizontalGroup(JPMalFetalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMalFetalLayout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JRBSiMF).addGap(18, 18, 18).addComponent(this.JRBNoMF).addContainerGap(29, 32767)));
        JPMalFetalLayout.setVerticalGroup(JPMalFetalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPMalFetalLayout.createSequentialGroup().addGroup(JPMalFetalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSiMF, -2, 23, -2).addComponent(this.JRBNoMF)).addGap(0, 0, 32767)));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBPresentacion, -2, 208, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPPosicion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPDorso, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPSituacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPCircCordon, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPMalFetal, -2, -1, -2))).addContainerGap(-1, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBPresentacion).addComponent(this.JPPosicion, -1, -1, 32767)).addComponent(this.JPDorso, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JPMalFetal, -2, -1, -2).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPCircCordon, -2, -1, -2).addComponent(this.JPSituacion, -2, -1, -2)).addGap(0, 0, 32767)))));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "PLACENTA", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPPlacenta.setBorder(BorderFactory.createTitledBorder((Border) null, "Posición", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGPlacenta.add(this.JRBAnterior1);
        this.JRBAnterior1.setFont(new Font("Arial", 1, 12));
        this.JRBAnterior1.setText("Posterior");
        this.JRBAnterior1.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.19
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBAnterior1ActionPerformed(evt);
            }
        });
        this.JBGPlacenta.add(this.JRBLateral1);
        this.JRBLateral1.setFont(new Font("Arial", 1, 12));
        this.JRBLateral1.setSelected(true);
        this.JRBLateral1.setText("Anterior");
        this.JRBLateral1.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.20
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBLateral1ActionPerformed(evt);
            }
        });
        this.JBGPlacenta.add(this.JRBPosterior1);
        this.JRBPosterior1.setFont(new Font("Arial", 1, 12));
        this.JRBPosterior1.setText("Previa");
        this.JRBPosterior1.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.21
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBPosterior1ActionPerformed(evt);
            }
        });
        this.JBGPlacenta.add(this.JRBPosterior2);
        this.JRBPosterior2.setFont(new Font("Arial", 1, 12));
        this.JRBPosterior2.setText("L.Izquierda");
        this.JRBPosterior2.setToolTipText("Lateral Izquierda");
        this.JRBPosterior2.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.22
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBPosterior2ActionPerformed(evt);
            }
        });
        this.JBGPlacenta.add(this.JRBPosterior3);
        this.JRBPosterior3.setFont(new Font("Arial", 1, 12));
        this.JRBPosterior3.setText("L.Derecha");
        this.JRBPosterior3.setToolTipText("Lateral Izquierda");
        this.JRBPosterior3.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.23
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBPosterior3ActionPerformed(evt);
            }
        });
        GroupLayout JPPlacentaLayout = new GroupLayout(this.JPPlacenta);
        this.JPPlacenta.setLayout(JPPlacentaLayout);
        JPPlacentaLayout.setHorizontalGroup(JPPlacentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlacentaLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBLateral1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBAnterior1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPosterior1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPosterior2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBPosterior3, -1, -1, 32767).addContainerGap()));
        JPPlacentaLayout.setVerticalGroup(JPPlacentaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlacentaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAnterior1, -2, 23, -2).addComponent(this.JRBLateral1).addComponent(this.JRBPosterior1, -2, 23, -2).addComponent(this.JRBPosterior2, -2, 23, -2).addComponent(this.JRBPosterior3, -2, 23, -2)));
        this.JPGrado.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGGrado.add(this.JRBGrado2);
        this.JRBGrado2.setFont(new Font("Arial", 1, 12));
        this.JRBGrado2.setText("II");
        this.JRBGrado2.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.24
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBGrado2ActionPerformed(evt);
            }
        });
        this.JBGGrado.add(this.JRBGrado1);
        this.JRBGrado1.setFont(new Font("Arial", 1, 12));
        this.JRBGrado1.setText("I");
        this.JRBGrado1.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.25
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBGrado1ActionPerformed(evt);
            }
        });
        this.JBGGrado.add(this.JRBGrado3);
        this.JRBGrado3.setFont(new Font("Arial", 1, 12));
        this.JRBGrado3.setText("III");
        this.JRBGrado3.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.26
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBGrado3ActionPerformed(evt);
            }
        });
        this.JBGGrado.add(this.JRBGrado4);
        this.JRBGrado4.setFont(new Font("Arial", 1, 12));
        this.JRBGrado4.setText("0");
        this.JRBGrado4.addActionListener(new ActionListener() { // from class: Historia.JPAEcografiaObstetrica.27
            public void actionPerformed(ActionEvent evt) {
                JPAEcografiaObstetrica.this.JRBGrado4ActionPerformed(evt);
            }
        });
        GroupLayout JPGradoLayout = new GroupLayout(this.JPGrado);
        this.JPGrado.setLayout(JPGradoLayout);
        JPGradoLayout.setHorizontalGroup(JPGradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGradoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBGrado4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBGrado1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBGrado2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBGrado3).addContainerGap()));
        JPGradoLayout.setVerticalGroup(JPGradoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPGradoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBGrado2, -2, 23, -2).addComponent(this.JRBGrado1).addComponent(this.JRBGrado3, -2, 23, -2).addComponent(this.JRBGrado4)));
        this.JTFFFEspesor.setBorder(BorderFactory.createTitledBorder((Border) null, "Espesor (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFEspesor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFFEspesor.setHorizontalAlignment(4);
        this.JTFFFEspesor.setFont(new Font("Arial", 1, 12));
        this.JTFFFEspesor.setValue(new Integer(0));
        this.JTFFFILA.setBorder(BorderFactory.createTitledBorder((Border) null, "ILA (mm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFFILA.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        this.JTFFFILA.setHorizontalAlignment(4);
        this.JTFFFILA.setToolTipText("Liquido Amniotico");
        this.JTFFFILA.setFont(new Font("Arial", 1, 12));
        this.JTFFFILA.setValue(new Integer(0));
        this.JTA_MovFetal.setColumns(1);
        this.JTA_MovFetal.setFont(new Font("Arial", 1, 12));
        this.JTA_MovFetal.setRows(1);
        this.JTA_MovFetal.setBorder(BorderFactory.createTitledBorder((Border) null, "Movimientos Fetales", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSP_MovFetal.setViewportView(this.JTA_MovFetal);
        this.JTA_MovRespiratorio.setColumns(1);
        this.JTA_MovRespiratorio.setFont(new Font("Arial", 1, 12));
        this.JTA_MovRespiratorio.setRows(1);
        this.JTA_MovRespiratorio.setBorder(BorderFactory.createTitledBorder((Border) null, "Movimientos Respiratorios", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSP_MovRespiratorio.setViewportView(this.JTA_MovRespiratorio);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JPPlacenta, -2, 459, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPGrado, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFFEspesor, -2, 100, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.JTFFFILA, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_MovFetal, -2, 263, -2).addGap(18, 18, 18).addComponent(this.JSP_MovRespiratorio, -2, 321, -2))).addContainerGap(-1, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPGrado, -2, -1, -2).addComponent(this.JPPlacenta, -2, -1, -2).addComponent(this.JTFFFEspesor, GroupLayout.Alignment.TRAILING, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFFILA, -2, -1, -2).addComponent(this.JSP_MovFetal, -2, -1, -2).addComponent(this.JSP_MovRespiratorio, -2, -1, -2)).addContainerGap(-1, 32767)));
        GroupLayout JPEcografiaLayout = new GroupLayout(this.JPEcografia);
        this.JPEcografia.setLayout(JPEcografiaLayout);
        JPEcografiaLayout.setHorizontalGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcografiaLayout.createSequentialGroup().addContainerGap().addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcografiaLayout.createSequentialGroup().addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPBiometria, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIGestacion, GroupLayout.Alignment.LEADING, -1, -1, 32767))).addGap(0, 0, 32767)).addGroup(JPEcografiaLayout.createSequentialGroup().addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGuardar, -1, -1, 32767).addGroup(JPEcografiaLayout.createSequentialGroup().addComponent(this.JSPAbatomiaFetal, -2, 362, -2).addGap(18, 18, 18).addComponent(this.jScrollPane1))).addContainerGap()))));
        JPEcografiaLayout.setVerticalGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEcografiaLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIGestacion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, 141, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPBiometria, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 118, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPEcografiaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPAbatomiaFetal, -2, 0, 32767).addComponent(this.jScrollPane1, -2, 62, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar).addContainerGap(12, 32767)));
        this.JTPEcografias.addTab("ECOGRAFÍA", this.JPEcografia);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTDetalleHistorico.setFont(new Font("Arial", 1, 12));
        this.JTDetalleHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleHistorico.addMouseListener(new MouseAdapter() { // from class: Historia.JPAEcografiaObstetrica.28
            public void mouseClicked(MouseEvent evt) {
                JPAEcografiaObstetrica.this.JTDetalleHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalleHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 784, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -2, 289, -2).addContainerGap(338, 32767)));
        this.JTPEcografias.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPEcografias, -2, 809, -2)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPEcografias)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleHistoricoMouseClicked(MouseEvent evt) {
        if (this.JTDetalleHistorico.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            mImprimirH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUnicoActionPerformed(ActionEvent evt) {
        this.JTFCantidadFeto.setText("1");
        this.JTFCantidadFeto.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMultipleActionPerformed(ActionEvent evt) {
        this.JTFCantidadFeto.setEnabled(true);
        this.JTFCantidadFeto.setText("2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLongitudinalActionPerformed(ActionEvent evt) {
        this.xsituacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTransversoActionPerformed(ActionEvent evt) {
        this.xsituacion = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBDerechaActionPerformed(ActionEvent evt) {
        this.xposicion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBIzquierdaActionPerformed(ActionEvent evt) {
        this.xposicion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLateralActionPerformed(ActionEvent evt) {
        this.xdorso = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnteriorActionPerformed(ActionEvent evt) {
        this.xdorso = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPosteriorActionPerformed(ActionEvent evt) {
        this.xdorso = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLateral1ActionPerformed(ActionEvent evt) {
        this.xplcenta = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAnterior1ActionPerformed(ActionEvent evt) {
        this.xplcenta = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPosterior1ActionPerformed(ActionEvent evt) {
        this.xplcenta = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGrado1ActionPerformed(ActionEvent evt) {
        this.xgrado = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGrado2ActionPerformed(ActionEvent evt) {
        this.xgrado = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGrado3ActionPerformed(ActionEvent evt) {
        this.xgrado = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiMFActionPerformed(ActionEvent evt) {
        this.xmalformacion = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoMFActionPerformed(ActionEvent evt) {
        this.xmalformacion = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiCCActionPerformed(ActionEvent evt) {
        this.xcordon = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoCCActionPerformed(ActionEvent evt) {
        this.xcordon = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMascActionPerformed(ActionEvent evt) {
        this.xsexo = "M";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBFemActionPerformed(ActionEvent evt) {
        this.xsexo = "F";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFUMPropertyChange(PropertyChangeEvent evt) {
        mCalcularFPP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBOblicuoActionPerformed(ActionEvent evt) {
        this.xsituacion = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBGrado4ActionPerformed(ActionEvent evt) {
        this.xgrado = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPosterior2ActionPerformed(ActionEvent evt) {
        this.xplcenta = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPosterior3ActionPerformed(ActionEvent evt) {
        this.xplcenta = 5;
    }

    public void mGrabar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "INSERT INTO h_ecog_obstetrica (`Id_Atencion`, `Feto`  , `CantidadFeto`, `Situacion`, `Id_Presentacion`, `Posicion`, `Dorso` , `LCN` , `DBP`, `AC`, `SG`, `HC`, `LF`, `VV`, `PonderadoFetal` , `FreCardiaca`, `Placenta`, `Grado`, `Espesor` , `LiqAtmiotico`, `Malformacion`, `CirCordon`, `Sexo` , `FechaParto`, `FUM`, `Conclusion`,SGestacion, SGestacionEco,`MovFetales`, `MovRespiratorio`, PesoFetal ,`Id_Profesional`, `Id_Especialidad`, `UsuarioS`)values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.JTFCantidadFeto.getText() + "','" + this.JTFCantidadFeto.getText() + "','" + this.xsituacion + "','" + this.xpresentacion[this.JCBPresentacion.getSelectedIndex()] + "','" + this.xposicion + "','" + this.xdorso + "','" + this.JTFFLcn.getValue() + "','" + this.JTFFDBP.getValue() + "','" + this.JTFFAC.getValue() + "','" + this.JTFFSG.getValue() + "','" + this.JTFFHC.getValue() + "','" + this.JTFFLF.getValue() + "','" + this.JTFFVV.getValue() + "','" + this.JTFFPonderado.getValue() + "','" + this.JTFFFCardiaca.getValue() + "','" + this.xplcenta + "','" + this.xgrado + "','" + this.JTFFFEspesor.getValue() + "','" + this.JTFFFILA.getValue() + "','" + this.xmalformacion + "','" + this.xcordon + "','" + this.xsexo + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaParto.getDate()) + "','" + this.xmetodo.formatoAMD.format(this.JDCFUM.getDate()) + "','" + this.JTAConclusion.getText() + "','" + this.JTFFFSGestacion.getValue() + "','" + this.JTFF_SGestacion_Eco.getValue() + "','" + this.JTA_MovFetal.getText() + "','" + this.JTA_MovRespiratorio.getText() + "','" + this.JTFF_PesoFetal.getValue() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.xecografia = this.xconsultasbd.ejecutarSQLId(sql);
            this.xconsultasbd.cerrarConexionBd();
            for (int y = 0; y < this.JTAnatomiaF.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelo.getValueAt(y, 2).toString()).booleanValue()) {
                    String sql2 = "insert into h_ecog_obst_ana_fetal(`Id_Obstetrica`, `Id_Anatomia`, `Observacion`, `UsuarioS`) values ('" + this.xecografia + "','" + this.xmodelo.getValueAt(y, 0) + "','" + this.xmodelo.getValueAt(y, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                    this.xconsultasbd.ejecutarSQL(sql2);
                    this.xconsultasbd.cerrarConexionBd();
                }
            }
            mImprimir();
            this.xclase.mCambiarEstadoHc(1);
            this.xclase.mCambiarEstadoCita();
            this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloAnanomiaFetal() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Parte", "Tiene?", "Observación"}) { // from class: Historia.JPAEcografiaObstetrica.29
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTAnatomiaF.setModel(this.xmodelo);
        this.JTAnatomiaF.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTAnatomiaF.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTAnatomiaF.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTAnatomiaF.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTAnatomiaF.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTAnatomiaF.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    private void mBuscarAnatomiaFetal() {
        try {
            mModeloAnanomiaFetal();
            ResultSet xrs = this.xconsultasbd.traerRs("SELECT `Id` , `Nbre` FROM `h_ecog_anatomia_fetal` WHERE (`Estado` =1)");
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(xrs.getString(1), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(false, n, 2);
                    this.xmodelo.setValueAt("", n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarTipoResultadoD(int xcoluma) {
        JDResultadoDescriptivoSO frmDES = new JDResultadoDescriptivoSO(null, true, this.xnombre, xcoluma, this);
        frmDES.setVisible(true);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodeloh = new DefaultTableModel(new Object[0], new String[]{"Id Atencion", "Fecha", "Profesional", "Id"}) { // from class: Historia.JPAEcografiaObstetrica.30
            Class[] types = {String.class, String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleHistorico.setModel(this.xmodeloh);
        this.JTDetalleHistorico.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTDetalleHistorico.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleHistorico.getColumnModel().getColumn(3).setPreferredWidth(20);
    }

    private void mCargarDatosTablaHistorico() {
        try {
            mCrearModeloHistorico();
            String sql = "SELECT `h_ecog_obstetrica`.`Id_Atencion`, DATE_FORMAT(`h_ecog_obstetrica`.`Fecha`,'%d-%m-%Y' ), `profesional1`.`NProfesional`, `h_ecog_obstetrica`.Id  FROM `h_ecog_obstetrica` INNER JOIN `h_atencion`  ON (`h_ecog_obstetrica`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN `profesional1`  ON (`profesional1`.`Id_Persona` = `h_ecog_obstetrica`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_ecog_obstetrica`.`Id_Especialidad`)  INNER JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) WHERE (`ingreso`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodeloh.addRow(this.xdatos);
                    this.xmodeloh.setValueAt(xrs.getString(1), n, 0);
                    this.xmodeloh.setValueAt(xrs.getString(2), n, 1);
                    this.xmodeloh.setValueAt(xrs.getString(3), n, 2);
                    this.xmodeloh.setValueAt(Long.valueOf(xrs.getLong(4)), n, 3);
                    n++;
                }
                this.xmetodo.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPASaludOcupacional.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mImprimir() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xecografia;
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_Ecografia_Obstetrica", mparametros);
    }

    private void mImprimirH() {
        String[][] mparametros = new String[3][2];
        mparametros[0][0] = "idatencion1";
        mparametros[0][1] = this.xmodeloh.getValueAt(this.JTDetalleHistorico.getSelectedRow(), 3).toString();
        mparametros[1][0] = "SUBREPORT_DIR";
        mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
        mparametros[2][0] = "SUBREPORTFIRMA_DIR";
        mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
        this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_Ecografia_Obstetrica", mparametros);
    }

    private void mCargarCombos() {
        this.JCBPresentacion.removeAllItems();
        this.JDCFechaParto.setDate(this.xmetodo.getFechaActual());
        this.JDCFUM.setDate(this.xmetodo.getFechaActual());
        this.xpresentacion = this.xconsultasbd.llenarCombo("SELECT `Id`, `Nbre` FROM `h_tipoposemb` WHERE (`Estado` =0) ORDER BY Nbre;", this.xpresentacion, this.JCBPresentacion);
        this.JCBPresentacion.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
    }

    private void mCalcularFPP() {
        try {
            String xsql = "SELECT ADDDATE('" + this.xmetodo.formatoAMD.format(this.JDCFUM.getDate()) + "', 280 ), ROUND((DATEDIFF(NOW(), '" + this.xmetodo.formatoAMD.format(this.JDCFUM.getDate()) + "')/7),1)";
            ResultSet xrs = this.xconsultasbd.traerRs(xsql);
            if (xrs.next()) {
                xrs.first();
                this.JDCFechaParto.setDate(xrs.getDate(1));
                this.JTFFFSGestacion.setValue(Double.valueOf(xrs.getDouble(2)));
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAEcografiaObstetrica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
