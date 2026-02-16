package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPGestionRiesgo_Dm.class */
public class JPGestionRiesgo_Dm extends JPanel {
    private clasesHistoriaCE xclase;
    private DefaultTableModel xmodelo;
    private Object[] xdatos;
    private String[] xclasificacionR;
    private String[] xidriesgo;
    private String xsql;
    private JButton JBGrafico;
    private JButton JBTGuardar;
    private JComboBox JCBCRiesgo;
    private JComboBox JCBHta_ClasificacionR;
    private JComboBox JCBI_ClasificacionR;
    private JComboBox JCBI_Tipo_Diabetes;
    private JComboBox JCBI_Tipo_Insulina;
    private JComboBox JCBR_ClasificacionEstadio;
    private JCheckBox JCHCobntrolado1;
    private JDateChooser JDDT_Dialisis;
    private JDateChooser JDDT_Predialisis;
    private JDateChooser JDDT_Transplante;
    private JLabel JLGrafico;
    private JLabel JLMeta;
    private JPanel JPICDiabetes;
    private JPanel JPICRiesgo;
    private JPanel JPIDDial_Transplante;
    private JPanel JPIDHta;
    private JPanel JPIDIngreso;
    private JPanel JPIDNFproteccion;
    private JPanel JPIDPyPDiabetes;
    private JPanel JPIGRiesgo;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPHistoricoD;
    private JTable JTBDetalle;
    private JFormattedTextField JTFFVHm;
    private JTable JTHistoricoD;
    private JTabbedPane JTPDatosPyp;
    private int xcontroldm = 0;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xid = "0";

    public JPGestionRiesgo_Dm(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        mNuevo();
        mBuscarresultado();
        mBuscarMeta();
        mBuscarDatos();
    }

    /* JADX WARN: Type inference failed for: r3v125, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIGRiesgo = new JPanel();
        this.JTPDatosPyp = new JTabbedPane();
        this.JPICRiesgo = new JPanel();
        this.JPIDIngreso = new JPanel();
        this.JCBI_ClasificacionR = new JComboBox();
        this.JCBI_Tipo_Diabetes = new JComboBox();
        this.JCBI_Tipo_Insulina = new JComboBox();
        this.JPIDHta = new JPanel();
        this.JCBHta_ClasificacionR = new JComboBox();
        this.JPIDNFproteccion = new JPanel();
        this.JCBR_ClasificacionEstadio = new JComboBox();
        this.JPIDDial_Transplante = new JPanel();
        this.JDDT_Predialisis = new JDateChooser();
        this.JDDT_Dialisis = new JDateChooser();
        this.JDDT_Transplante = new JDateChooser();
        this.JBTGuardar = new JButton();
        this.JSPHistorico = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JCBCRiesgo = new JComboBox();
        this.JPIDPyPDiabetes = new JPanel();
        this.JPICDiabetes = new JPanel();
        this.JTFFVHm = new JFormattedTextField();
        this.JCHCobntrolado1 = new JCheckBox();
        this.JLMeta = new JLabel();
        this.JSPHistoricoD = new JScrollPane();
        this.JTHistoricoD = new JTable();
        this.JBGrafico = new JButton();
        this.JLGrafico = new JLabel();
        setName("jpgestionriesgo_dm");
        this.JPIGRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "GESTIÓN DEL RIESGO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIGRiesgo.setForeground(new Color(0, 103, 0));
        this.JPIGRiesgo.setFont(new Font("Arial", 1, 14));
        this.JTPDatosPyp.setForeground(new Color(255, 0, 0));
        this.JTPDatosPyp.setFont(new Font("Arial", 1, 12));
        this.JPIDIngreso.setBorder(BorderFactory.createTitledBorder((Border) null, "DIABETES", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBI_ClasificacionR.setFont(new Font("Arial", 1, 12));
        this.JCBI_ClasificacionR.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBI_Tipo_Diabetes.setFont(new Font("Arial", 1, 12));
        this.JCBI_Tipo_Diabetes.setModel(new DefaultComboBoxModel(new String[]{" ", "Tipo I", "Tipo II", "Tipo II -  Insulinorequiriente"}));
        this.JCBI_Tipo_Diabetes.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Diabetes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBI_Tipo_Insulina.setFont(new Font("Arial", 1, 12));
        this.JCBI_Tipo_Insulina.setModel(new DefaultComboBoxModel(new String[]{"No Aplica", "Análoga", "Convencional"}));
        this.JCBI_Tipo_Insulina.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Insulina", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDIngresoLayout = new GroupLayout(this.JPIDIngreso);
        this.JPIDIngreso.setLayout(JPIDIngresoLayout);
        JPIDIngresoLayout.setHorizontalGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDIngresoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBI_Tipo_Insulina, 0, -1, 32767).addGroup(JPIDIngresoLayout.createSequentialGroup().addComponent(this.JCBI_ClasificacionR, -2, 160, -2).addGap(18, 18, 18).addComponent(this.JCBI_Tipo_Diabetes, -2, 145, -2))).addContainerGap(-1, 32767)));
        JPIDIngresoLayout.setVerticalGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDIngresoLayout.createSequentialGroup().addGroup(JPIDIngresoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBI_Tipo_Diabetes, -2, 51, -2).addComponent(this.JCBI_ClasificacionR, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBI_Tipo_Insulina, -2, 51, -2).addContainerGap(-1, 32767)));
        this.JPIDHta.setBorder(BorderFactory.createTitledBorder((Border) null, "HIPERTENSIÓN", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBHta_ClasificacionR.setFont(new Font("Arial", 1, 12));
        this.JCBHta_ClasificacionR.setModel(new DefaultComboBoxModel(new String[]{" ", "Bajo", "Moderado", "Alto"}));
        this.JCBHta_ClasificacionR.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Riesgo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDHtaLayout = new GroupLayout(this.JPIDHta);
        this.JPIDHta.setLayout(JPIDHtaLayout);
        JPIDHtaLayout.setHorizontalGroup(JPIDHtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDHtaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBHta_ClasificacionR, -2, 159, -2).addContainerGap()));
        JPIDHtaLayout.setVerticalGroup(JPIDHtaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBHta_ClasificacionR, -2, 51, -2));
        this.JPIDNFproteccion.setBorder(BorderFactory.createTitledBorder((Border) null, "ESTADIO ACTUAL DE NEFROPROTECCIÓN", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JCBR_ClasificacionEstadio.setFont(new Font("Arial", 1, 12));
        this.JCBR_ClasificacionEstadio.setModel(new DefaultComboBoxModel(new String[]{" ", "Estadío 1", "Estadío 2", "Estadío 3", "Estadío 4", "Estadío 5"}));
        this.JCBR_ClasificacionEstadio.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Estadío", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIDNFproteccionLayout = new GroupLayout(this.JPIDNFproteccion);
        this.JPIDNFproteccion.setLayout(JPIDNFproteccionLayout);
        JPIDNFproteccionLayout.setHorizontalGroup(JPIDNFproteccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDNFproteccionLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JCBR_ClasificacionEstadio, -2, 221, -2).addContainerGap()));
        JPIDNFproteccionLayout.setVerticalGroup(JPIDNFproteccionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBR_ClasificacionEstadio, -2, 50, -2));
        this.JPIDDial_Transplante.setBorder(BorderFactory.createTitledBorder((Border) null, "PROGRAMA DE DIALISIS O TRANSPLANTE", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JDDT_Predialisis.setBorder(BorderFactory.createTitledBorder((Border) null, "Prediálisis", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDDT_Predialisis.setToolTipText("Fecha Prediálisis");
        this.JDDT_Predialisis.setDateFormatString("dd/MM/yyyy");
        this.JDDT_Predialisis.setFont(new Font("Arial", 1, 12));
        this.JDDT_Dialisis.setBorder(BorderFactory.createTitledBorder((Border) null, "Diálisis", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDDT_Dialisis.setToolTipText("Fecha Diálisis");
        this.JDDT_Dialisis.setDateFormatString("dd/MM/yyyy");
        this.JDDT_Dialisis.setFont(new Font("Arial", 1, 12));
        this.JDDT_Transplante.setBorder(BorderFactory.createTitledBorder((Border) null, "Transplante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDDT_Transplante.setToolTipText("Fecha Transplante");
        this.JDDT_Transplante.setDateFormatString("dd/MM/yyyy");
        this.JDDT_Transplante.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDDial_TransplanteLayout = new GroupLayout(this.JPIDDial_Transplante);
        this.JPIDDial_Transplante.setLayout(JPIDDial_TransplanteLayout);
        JPIDDial_TransplanteLayout.setHorizontalGroup(JPIDDial_TransplanteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDial_TransplanteLayout.createSequentialGroup().addContainerGap().addComponent(this.JDDT_Predialisis, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDDT_Dialisis, -2, 110, -2).addGap(18, 18, 18).addComponent(this.JDDT_Transplante, -2, 110, -2).addContainerGap(-1, 32767)));
        JPIDDial_TransplanteLayout.setVerticalGroup(JPIDDial_TransplanteLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDDial_TransplanteLayout.createSequentialGroup().addContainerGap().addGroup(JPIDDial_TransplanteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JDDT_Predialisis, -2, 50, -2).addComponent(this.JDDT_Dialisis, -2, 50, -2).addComponent(this.JDDT_Transplante, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JBTGuardar.setFont(new Font("Arial", 1, 12));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPGestionRiesgo_Dm.1
            public void actionPerformed(ActionEvent evt) {
                JPGestionRiesgo_Dm.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPHistorico.setViewportView(this.JTBDetalle);
        this.JCBCRiesgo.setFont(new Font("Arial", 1, 12));
        this.JCBCRiesgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación Riesgo Cardiovascular", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPICRiesgoLayout = new GroupLayout(this.JPICRiesgo);
        this.JPICRiesgo.setLayout(JPICRiesgoLayout);
        JPICRiesgoLayout.setHorizontalGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICRiesgoLayout.createSequentialGroup().addContainerGap().addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTGuardar, -1, -1, 32767).addGroup(JPICRiesgoLayout.createSequentialGroup().addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDIngreso, -2, -1, -2).addComponent(this.JPIDDial_Transplante, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDNFproteccion, -2, -1, -2).addComponent(this.JPIDHta, -2, -1, -2).addComponent(this.JCBCRiesgo, -2, 273, -2)).addGap(0, 77, 32767)).addComponent(this.JSPHistorico)).addContainerGap()));
        JPICRiesgoLayout.setVerticalGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICRiesgoLayout.createSequentialGroup().addContainerGap().addGroup(JPICRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPICRiesgoLayout.createSequentialGroup().addComponent(this.JPIDIngreso, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDDial_Transplante, -2, -1, -2)).addGroup(JPICRiesgoLayout.createSequentialGroup().addComponent(this.JPIDHta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDNFproteccion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCBCRiesgo, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorico, -1, 114, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardar, -2, 41, -2).addContainerGap()));
        this.JTPDatosPyp.addTab("CLASIFICACIÓN DE RIESGO", this.JPICRiesgo);
        this.JPICDiabetes.setBorder(BorderFactory.createTitledBorder((Border) null, "% Hb Glicosilada", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFVHm.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFVHm.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter()));
        this.JTFFVHm.setHorizontalAlignment(4);
        this.JTFFVHm.setFont(new Font("Arial", 1, 12));
        this.JTFFVHm.setName("fechanaciemiento");
        this.JTFFVHm.setValue(new Integer(0));
        this.JTFFVHm.addFocusListener(new FocusAdapter() { // from class: Historia.JPGestionRiesgo_Dm.2
            public void focusLost(FocusEvent evt) {
                JPGestionRiesgo_Dm.this.JTFFVHmFocusLost(evt);
            }
        });
        this.JTFFVHm.addKeyListener(new KeyAdapter() { // from class: Historia.JPGestionRiesgo_Dm.3
            public void keyPressed(KeyEvent evt) {
                JPGestionRiesgo_Dm.this.JTFFVHmKeyPressed(evt);
            }
        });
        this.JCHCobntrolado1.setFont(new Font("Arial", 1, 12));
        this.JCHCobntrolado1.setSelected(true);
        this.JCHCobntrolado1.setText("Controlado?");
        this.JCHCobntrolado1.addActionListener(new ActionListener() { // from class: Historia.JPGestionRiesgo_Dm.4
            public void actionPerformed(ActionEvent evt) {
                JPGestionRiesgo_Dm.this.JCHCobntrolado1ActionPerformed(evt);
            }
        });
        this.JLMeta.setBorder(BorderFactory.createTitledBorder((Border) null, "Meta", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPICDiabetesLayout = new GroupLayout(this.JPICDiabetes);
        this.JPICDiabetes.setLayout(JPICDiabetesLayout);
        JPICDiabetesLayout.setHorizontalGroup(JPICDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDiabetesLayout.createSequentialGroup().addContainerGap().addGroup(JPICDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDiabetesLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLMeta, -1, -1, 32767).addComponent(this.JTFFVHm, -1, 92, 32767)).addComponent(this.JCHCobntrolado1)).addContainerGap(-1, 32767)));
        JPICDiabetesLayout.setVerticalGroup(JPICDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPICDiabetesLayout.createSequentialGroup().addComponent(this.JLMeta, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFVHm, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHCobntrolado1).addContainerGap(-1, 32767)));
        this.JSPHistoricoD.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTÓRICO", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTHistoricoD.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPHistoricoD.setViewportView(this.JTHistoricoD);
        this.JBGrafico.setFont(new Font("Arial", 1, 12));
        this.JBGrafico.setText("Ver Gráfico");
        this.JBGrafico.addActionListener(new ActionListener() { // from class: Historia.JPGestionRiesgo_Dm.5
            public void actionPerformed(ActionEvent evt) {
                JPGestionRiesgo_Dm.this.JBGraficoActionPerformed(evt);
            }
        });
        this.JLGrafico.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout JPIDPyPDiabetesLayout = new GroupLayout(this.JPIDPyPDiabetes);
        this.JPIDPyPDiabetes.setLayout(JPIDPyPDiabetesLayout);
        JPIDPyPDiabetesLayout.setHorizontalGroup(JPIDPyPDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPyPDiabetesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDPyPDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPyPDiabetesLayout.createSequentialGroup().addComponent(this.JPICDiabetes, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistoricoD, -2, 291, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLGrafico, -1, 321, 32767)).addGroup(JPIDPyPDiabetesLayout.createSequentialGroup().addComponent(this.JBGrafico).addGap(0, 0, 32767))).addContainerGap()));
        JPIDPyPDiabetesLayout.setVerticalGroup(JPIDPyPDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPyPDiabetesLayout.createSequentialGroup().addContainerGap().addGroup(JPIDPyPDiabetesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLGrafico, -1, -1, 32767).addComponent(this.JSPHistoricoD, GroupLayout.Alignment.TRAILING, -2, 0, 32767).addComponent(this.JPICDiabetes, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBGrafico).addContainerGap(251, 32767)));
        this.JTPDatosPyp.addTab("PROGRAMA DE DIABETES", this.JPIDPyPDiabetes);
        GroupLayout JPIGRiesgoLayout = new GroupLayout(this.JPIGRiesgo);
        this.JPIGRiesgo.setLayout(JPIGRiesgoLayout);
        JPIGRiesgoLayout.setHorizontalGroup(JPIGRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGRiesgoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosPyp)));
        JPIGRiesgoLayout.setVerticalGroup(JPIGRiesgoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGRiesgoLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosPyp).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIGRiesgo, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIGRiesgo, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVHmFocusLost(FocusEvent evt) {
        if (this.JTFFVHm.getText().isEmpty()) {
            return;
        }
        if (Double.parseDouble(this.JTFFVHm.getText().replace(',', '.')) <= 7.5d) {
            this.JCHCobntrolado1.setSelected(true);
            this.xcontroldm = 0;
        } else {
            this.JCHCobntrolado1.setSelected(false);
            this.xcontroldm = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFVHmKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFVHm.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHCobntrolado1ActionPerformed(ActionEvent evt) {
        if (this.JCHCobntrolado1.isSelected()) {
            this.xcontroldm = 0;
        } else {
            this.xcontroldm = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGraficoActionPerformed(ActionEvent evt) {
        mGenerarGrafico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        mGrabar();
    }

    private void mNuevo() {
        this.JCBI_ClasificacionR.removeAllItems();
        this.JCBCRiesgo.removeAllItems();
        this.xclasificacionR = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =5  AND `Estado` =1) ORDER BY Nbre", this.xclasificacionR, this.JCBI_ClasificacionR);
        this.JCBI_ClasificacionR.setSelectedIndex(-1);
        this.xidriesgo = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `h_tipo_riesgo` WHERE (`Tipo` =1) ORDER BY `Nbre` ASC", this.xidriesgo, this.JCBCRiesgo);
        this.JCBCRiesgo.setSelectedItem("SIN DETERMINAR");
        this.xct.cerrarConexionBd();
        mCargarDatosTabla();
    }

    public void mGrabar() {
        if (this.xid.equals("0")) {
            this.xsql = "insert into `p_clasificacion_riesgo`(`Id_Usuario`,`Id_UsuarioP`, `Id_Atencion`, `FechaC`, `CRiesgoC`, `Hta_CRiesgo`, `Dm_CRiesgo`, `Dm_Tipo`, `Dm_TipoInsulina`, `NF_Estadio`, `NF_FPreDialisis`, `NF_FDialisis`, `NF_FTransplante`, `Id_Profesional`, `Id_Especialidad`)  values('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xmt.formatoAMD.format(this.xmt.getFechaActual()) + "','" + this.JCBCRiesgo.getSelectedItem() + "','" + this.JCBHta_ClasificacionR.getSelectedItem() + "','" + this.JCBI_ClasificacionR.getSelectedItem() + "','" + this.JCBI_Tipo_Diabetes.getSelectedItem() + "','" + this.JCBI_Tipo_Insulina.getSelectedItem() + "','" + this.JCBR_ClasificacionEstadio.getSelectedItem() + "' ," + mDatoFecha_Valor(this.JDDT_Predialisis) + " ," + mDatoFecha_Valor(this.JDDT_Dialisis) + " ," + mDatoFecha_Valor(this.JDDT_Transplante) + " ,'" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "' ,'" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "')";
            this.xid = this.xct.ejecutarSQLId(this.xsql);
            this.xct.cerrarConexionBd();
            this.xsql = "update g_usuarioxprograma set U_CRiesgo_Hta='" + this.JCBHta_ClasificacionR.getSelectedItem() + "',ClasifRiesgoDiab='" + this.JCBCRiesgo.getSelectedItem() + "',U_CRiesgo='" + this.JCBI_ClasificacionR.getSelectedItem() + "',U_TipoDiabetes='" + this.JCBI_Tipo_Diabetes.getSelectedItem() + "',U_TipoInsulina='" + this.JCBI_Tipo_Insulina.getSelectedItem() + "',U_Estadio_NFP='" + this.JCBR_ClasificacionEstadio.getSelectedItem() + "',NF_FPreDialisis=" + mDatoFecha_Valor(this.JDDT_Predialisis) + ",NF_FDialisis=" + mDatoFecha_Valor(this.JDDT_Dialisis) + ",NF_FTranspante=" + mDatoFecha_Valor(this.JDDT_Transplante) + " where Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioPrograma() + "'";
            this.xct.ejecutarSQL(this.xsql);
            this.xct.cerrarConexionBd();
            mCargarDatosTabla();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "id_Atención", "Fecha", "Riesgo Hta", "Riesgo Dm", "Tipo Dm", "Tipo Insulina", "C/Estadío", "F/Prediálisis", "F/Diálisis", "F/Transplante", "Profesional"}) { // from class: Historia.JPGestionRiesgo_Dm.6
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalle.setModel(this.xmodelo);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(15);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(50);
    }

    private void mCargarDatosTabla() {
        try {
            mCrearTabla();
            this.xsql = "SELECT `p_clasificacion_riesgo`.`Id`,`p_clasificacion_riesgo`.`Id_Atencion`, `p_clasificacion_riesgo`.`FechaC`, `p_clasificacion_riesgo`.`Hta_CRiesgo` , `p_clasificacion_riesgo`.`Dm_CRiesgo` , `p_clasificacion_riesgo`.`Dm_Tipo` , `p_clasificacion_riesgo`.`Dm_TipoInsulina` , `p_clasificacion_riesgo`.`NF_Estadio` , `p_clasificacion_riesgo`.`NF_FPreDialisis` , `p_clasificacion_riesgo`.`NF_FDialisis` , `p_clasificacion_riesgo`.`NF_FTransplante` , `profesional1`.`Especialidad` , `profesional1`.`NProfesional` FROM  `profesional1` INNER JOIN `p_clasificacion_riesgo`  ON (`profesional1`.`Id_Persona` = `p_clasificacion_riesgo`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `p_clasificacion_riesgo`.`Id_Especialidad`) WHERE (`p_clasificacion_riesgo`.`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `p_clasificacion_riesgo`.`Estado` =1) ORDER BY `p_clasificacion_riesgo`.`FechaC` DESC ";
            ResultSet rs = this.xct.traerRs(this.xsql);
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                    this.xmodelo.setValueAt(Long.valueOf(rs.getLong(2)), i, 1);
                    this.xmodelo.setValueAt(rs.getString(3), i, 2);
                    this.xmodelo.setValueAt(rs.getString(4), i, 3);
                    this.xmodelo.setValueAt(rs.getString(5), i, 4);
                    this.xmodelo.setValueAt(rs.getString(6), i, 5);
                    this.xmodelo.setValueAt(rs.getString(7), i, 6);
                    this.xmodelo.setValueAt(rs.getString(8), i, 7);
                    this.xmodelo.setValueAt(rs.getString(9), i, 8);
                    this.xmodelo.setValueAt(rs.getString(10), i, 9);
                    this.xmodelo.setValueAt(rs.getString(11), i, 10);
                    this.xmodelo.setValueAt(rs.getString(12), i, 11);
                    i++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPANotas.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private String mDatoFecha(JDateChooser xcomp, String xvariable) {
        String xv;
        if (xcomp.getDate() != null) {
            xv = xvariable + "='" + this.xmt.formatoAMD.format(xcomp.getDate()) + "'";
        } else {
            xv = xvariable + "=" + ((Object) null) + "";
        }
        return xv;
    }

    private String mDatoFecha_Valor(JDateChooser xcomp) {
        String xv;
        if (xcomp.getDate() != null) {
            xv = "'" + this.xmt.formatoAMD.format(xcomp.getDate()) + "'";
        } else {
            xv = null;
        }
        return xv;
    }

    private void mBuscarDatos() {
        try {
            this.xsql = "SELECT `Hta_CRiesgo`, `Dm_CRiesgo`, `Dm_Tipo`, `Dm_TipoInsulina`, `NF_Estadio`, `NF_FPreDialisis`, `NF_FDialisis`, `NF_FTransplante`, `Id` FROM  `p_clasificacion_riesgo` WHERE (`Id_Atencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "' AND `Estado` =1) ";
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCBHta_ClasificacionR.setSelectedItem(xrs.getString(1));
                this.JCBI_ClasificacionR.setSelectedItem(xrs.getString(2));
                this.JCBI_Tipo_Diabetes.setSelectedItem(xrs.getString(3));
                this.JCBI_Tipo_Insulina.setSelectedItem(xrs.getString(4));
                this.JCBR_ClasificacionEstadio.setSelectedItem(xrs.getString(5));
                this.JDDT_Predialisis.setDate(xrs.getDate(6));
                this.JDDT_Dialisis.setDate(xrs.getDate(7));
                this.JDDT_Transplante.setDate(xrs.getDate(8));
                this.xid = xrs.getString(9);
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionRiesgo_Dm.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarMeta() {
        try {
            this.JTFFVHm.setValue(0);
            String sql = "SELECT `MetaHbA1C` FROM `g_usuarioxprograma` WHERE (`Id_Usuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.first();
                this.JLMeta.setText(xrs.getString(1));
            } else {
                this.JLMeta.setText("0");
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPGestionRiesgo_Dm.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarresultado() {
        try {
            mModeloHistoricoD();
            String sql = "SELECT  `h_examenfisico`.`Id_Atencion`, `h_atencion`.`Fecha_Atencion`, `h_examenfisico`.`ValorGlicemia`, `h_examenfisico`.`MetaHb` FROM `h_examenfisico` INNER JOIN `h_atencion` ON (`h_examenfisico`.`Id_Atencion` = `h_atencion`.`Id`) WHERE (`h_examenfisico`.`Id_Usuario_Programa` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
            ResultSet xrs = this.xct.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(3)), n, 2);
                    this.xmodelo.setValueAt(Double.valueOf(xrs.getDouble(4)), n, 3);
                    n++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAExamenFisico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mModeloHistoricoD() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"IdAtencion", "Fecha", "Resultado", "Meta"}) { // from class: Historia.JPGestionRiesgo_Dm.7
            Class[] types = {Integer.class, String.class, Double.class, Double.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistoricoD.setModel(this.xmodelo);
        this.JTHistoricoD.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTHistoricoD.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTHistoricoD.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTHistoricoD.getColumnModel().getColumn(1).setPreferredWidth(10);
        this.JTHistoricoD.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTHistoricoD.getColumnModel().getColumn(3).setPreferredWidth(30);
    }

    public void mGenerarGrafico() {
        XYDataset xydataset = xyDataset();
        JFreeChart jfreechart = ChartFactory.createXYLineChart("Gráfico Hb A1C", "Valores", "Meta", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.BLACK);
        xyplot.setRangeGridlinePaint(Color.BLACK);
        XYLineAndShapeRenderer xylineandshaperenderer = xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        BufferedImage bufferedImage = jfreechart.createBufferedImage(311, 219);
        this.JLGrafico.setIcon(new ImageIcon(bufferedImage));
    }

    private XYDataset xyDataset() {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        for (int i = 0; i < this.JTHistoricoD.getRowCount(); i++) {
            XYSeries series1 = new XYSeries(this.JTHistoricoD.getValueAt(i, 1).toString());
            for (int x = 2; x < 3; x++) {
                series1.add(Integer.parseInt(this.JTHistoricoD.getColumnName(x).toString()), Integer.parseInt(this.JTHistoricoD.getValueAt(i, x).toString()));
            }
            xyseriescollection.addSeries(series1);
        }
        return xyseriescollection;
    }
}
