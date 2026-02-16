package com.genoma.plus.controller.historia;

import Acceso.Principal;
import Historia.ImpresionDocumentosHC;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.dao.general.PatologiaCie10DAO;
import com.genoma.plus.dao.historia.HNotaClinicaDiagnosticoDAO;
import com.genoma.plus.dao.historia.HNotasClinicaDAO;
import com.genoma.plus.dao.historia.HOrdenInterconsultaDAO;
import com.genoma.plus.dao.historia.HSignosVitalesDAO;
import com.genoma.plus.dao.historia.HistoriaDAO;
import com.genoma.plus.dao.impl.general.PatologiaCie10DAOImpl;
import com.genoma.plus.dao.impl.historia.HNotaClinicaDAOImpl;
import com.genoma.plus.dao.impl.historia.HNotaClinicaDiagnosticoDAOImpl;
import com.genoma.plus.dao.impl.historia.HOrdenInterconsultaDAOImpl;
import com.genoma.plus.dao.impl.historia.HSignosVitalesDAOImpl;
import com.genoma.plus.dao.impl.historia.HistoriaDAOImpl;
import com.genoma.plus.dto.gcuenta.GCGenericoDTO;
import com.genoma.plus.dto.general.PatologiaCie10DTO;
import com.genoma.plus.dto.historia.HNotaClinicaDiagnosticoDTO;
import com.genoma.plus.dto.historia.HNotasClinicasDTO;
import com.genoma.plus.dto.historia.HOrdenInterconsultaDTO;
import com.genoma.plus.dto.historia.HSignosVitalesDTO;
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
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:com/genoma/plus/controller/historia/JPA_NotasMedicasN.class */
public class JPA_NotasMedicasN extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodeloH;
    private HistoriaDAO xHistoriaDAO;
    private PatologiaCie10DAO xPatologiaCie10DAO;
    private HNotasClinicaDAO xHNotasClinicaDAO;
    private HSignosVitalesDAO xHSignosVitalesDAO;
    private HNotaClinicaDiagnosticoDAO xHNotaClinicaDiagnosticoDAO;
    private HOrdenInterconsultaDAO xHOrdenInterconsultaDAO;
    private String[][] xIdTipoNota;
    private String[] xIdEspecialidadInterc;
    private String[] xIdTipoNotaFiltro;
    private String xsql;
    private JInternalFrame xjif;
    private long xId_Atencion;
    private long xIdIngreso;
    private String xTipoAtencion;
    private String xId_AtencionEsp;
    private String xFiltro;
    private Object[] xdatos;
    public boolean nEvolucionAsistencial;
    private JButton JBTGuardarTemp;
    private JButton JBTGuardarTemp1;
    private JButton JBT_NotaP;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBH_Nota;
    private JComboBox JCBTipoNota;
    private JCheckBox JCHFiltro;
    private JCheckBox JCH_NCierreHC;
    private JDateChooser JDCFecha;
    private JLabel JLBPBSentado;
    private JLabel JLBPSentado1;
    private JPanel JPDiagnostico;
    private JPanel JPIDFiltro;
    private JPanel JPIPresion;
    private JPanel JPI_ExamenFisico;
    private JPanel JPI_Historico;
    private JPanel JPI_Nota;
    private JPanel JPI_SignosVitales;
    private JSpinner JSOrden;
    private JScrollPane JSPDetalleNotas;
    private JScrollPane JSPDiagnostico;
    private JScrollPane JSPInterpretacionAyudasDx;
    private JScrollPane JSPNotas;
    private JScrollPane JSP_EFEstadoGeneral;
    private JScrollPane JSP_EFHallazgo;
    private JTable JTBDetalle;
    private JTable JTDetalle;
    public JTextField JTFCDxP;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFFPSentadoD;
    private JFormattedTextField JTFFPSentadoS;
    public JTextFieldValidator JTFFPs2;
    public JTextFieldValidator JTFFSFc;
    public JTextFieldValidator JTFFSFr;
    public JTextFieldValidator JTFFSPAM;
    public JTextFieldValidator JTFFSPeso;
    public JTextFieldValidator JTFFSTalla;
    public JTextFieldValidator JTFFTemperatura;
    public JTextField JTFNCodigoDxP;
    public JTextField JTFNNota;
    private JTabbedPane JTPDatos;
    public JTextPane JTPInterpretacionAyudasDx;
    private JTabbedPane JTPMenus;
    public JTextPane JTPNota;
    private JTextPane JTP_EFEstadoGeneral;
    private JTextPane JTP_EFHallazgo;
    private JPanel jPanel1;
    private Metodos xmt = new Metodos();
    private boolean xlleno = false;
    private boolean llenofiltro = false;
    private long xCerrarFac = 0;

    public JPA_NotasMedicasN(JInternalFrame xjif, Long xId_Atencion, String xTipoAtencion, String xId_AtencionEsp, Long xIdIngreso, String xFiltro, String titulo) {
        this.xId_Atencion = 0L;
        this.xIdIngreso = 0L;
        this.nEvolucionAsistencial = false;
        initComponents();
        setBorder(BorderFactory.createTitledBorder((Border) null, titulo, 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        springStart();
        this.xjif = xjif;
        this.xIdIngreso = xIdIngreso.longValue();
        this.xId_Atencion = xId_Atencion.longValue();
        this.xTipoAtencion = xTipoAtencion;
        this.xId_AtencionEsp = xId_AtencionEsp;
        this.xFiltro = xFiltro;
        mNuevo();
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            this.JTPMenus.remove(this.JPI_ExamenFisico);
        }
        System.out.println("this.JTFNNota.getText() -> " + this.JTFNNota.getText());
        if ((!this.JTFNNota.getText().isEmpty() && this.JTFNNota.getText() != null && !this.JTFNNota.getText().equals("0")) || this.JTBDetalle.getRowCount() > 0) {
            this.nEvolucionAsistencial = true;
        } else {
            this.nEvolucionAsistencial = false;
        }
        System.out.println("evolucion assitencial -> " + this.nEvolucionAsistencial);
    }

    /* JADX WARN: Type inference failed for: r3v153, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPI_Nota = new JPanel();
        this.jPanel1 = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JCBTipoNota = new JComboBox();
        this.JCBEspecialidad = new JComboBox();
        this.JCH_NCierreHC = new JCheckBox();
        this.JTPMenus = new JTabbedPane();
        this.JPI_ExamenFisico = new JPanel();
        this.JPI_SignosVitales = new JPanel();
        this.JPIPresion = new JPanel();
        this.JTFFPSentadoS = new JFormattedTextField();
        this.JTFFPSentadoD = new JFormattedTextField();
        this.JLBPBSentado = new JLabel();
        this.JLBPSentado1 = new JLabel();
        this.JTFFSFc = new JTextFieldValidator();
        this.JTFFSFr = new JTextFieldValidator();
        this.JTFFTemperatura = new JTextFieldValidator();
        this.JTFFPs2 = new JTextFieldValidator();
        this.JTFFSTalla = new JTextFieldValidator();
        this.JTFFSPeso = new JTextFieldValidator();
        this.JTFFSPAM = new JTextFieldValidator();
        this.JSP_EFHallazgo = new JScrollPane();
        this.JTP_EFHallazgo = new JTextPane();
        this.JSPInterpretacionAyudasDx = new JScrollPane();
        this.JTPInterpretacionAyudasDx = new JTextPane();
        this.JSPNotas = new JScrollPane();
        this.JTPNota = new JTextPane();
        this.JPDiagnostico = new JPanel();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JSPDiagnostico = new JScrollPane();
        this.JTDetalle = new JTable();
        this.JBTGuardarTemp1 = new JButton();
        this.JSOrden = new JSpinner();
        this.JBTGuardarTemp = new JButton();
        this.JTFNNota = new JTextField();
        this.JBT_NotaP = new JButton();
        this.JSP_EFEstadoGeneral = new JScrollPane();
        this.JTP_EFEstadoGeneral = new JTextPane();
        this.JPI_Historico = new JPanel();
        this.JPIDFiltro = new JPanel();
        this.JCBH_Nota = new JComboBox();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalleNotas = new JScrollPane();
        this.JTBDetalle = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "TITULO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jpi_notas_evoluciones");
        addAncestorListener(new AncestorListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPA_NotasMedicasN.this.formAncestorRemoved(evt);
            }

            public void ancestorMoved(AncestorEvent evt) {
            }
        });
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JDCFecha.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.2
            public void focusLost(FocusEvent evt) {
                JPA_NotasMedicasN.this.JDCFechaFocusLost(evt);
            }
        });
        this.JDCFecha.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPA_NotasMedicasN.this.JDCFechaPropertyChange(evt);
            }
        });
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora (HH:mm:ss)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##:##:##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.4
            public void focusLost(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFHoraFocusLost(evt);
            }
        });
        this.JTFFHora.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPA_NotasMedicasN.this.JTFFHoraPropertyChange(evt);
            }
        });
        this.JCBTipoNota.setFont(new Font("Arial", 1, 12));
        this.JCBTipoNota.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoNota.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.6
            public void itemStateChanged(ItemEvent evt) {
                JPA_NotasMedicasN.this.JCBTipoNotaItemStateChanged(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad (Solo en caso de valoraciones en urgencias)", 1, 0, new Font("Arial", 1, 12), Color.red));
        this.JCH_NCierreHC.setFont(new Font("Arial", 1, 12));
        this.JCH_NCierreHC.setText("Cerrar para facturar?");
        this.JCH_NCierreHC.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.7
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JCH_NCierreHCActionPerformed(evt);
            }
        });
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 545, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCH_NCierreHC, -2, 157, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDCFecha, -2, 123, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, 119, -2).addGap(18, 18, 18).addComponent(this.JCBTipoNota, -2, 544, -2))).addGap(12, 12, 12)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFHora, -2, 50, -2).addComponent(this.JCBTipoNota, -2, 50, -2)).addComponent(this.JDCFecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBEspecialidad, -2, 50, -2).addComponent(this.JCH_NCierreHC)).addGap(12, 12, 12)));
        this.JTPMenus.setForeground(new Color(0, 103, 0));
        this.JTPMenus.setFont(new Font("Arial", 1, 14));
        this.JPI_SignosVitales.setBorder(BorderFactory.createTitledBorder((Border) null, "SIGNOS VITALES", 0, 0, new Font("Arial", 1, 14), Color.red));
        this.JPIPresion.setBorder(BorderFactory.createTitledBorder((Border) null, "PRESIÓN", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JTFFPSentadoS.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoS.setHorizontalAlignment(4);
        this.JTFFPSentadoS.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoS.setName("fechanaciemiento");
        this.JTFFPSentadoS.setValue(new Integer(0));
        this.JTFFPSentadoS.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.8
            public void focusLost(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFPSentadoSFocusLost(evt);
            }
        });
        this.JTFFPSentadoS.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.9
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JTFFPSentadoSActionPerformed(evt);
            }
        });
        this.JTFFPSentadoD.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        this.JTFFPSentadoD.setHorizontalAlignment(4);
        this.JTFFPSentadoD.setFont(new Font("Arial", 1, 12));
        this.JTFFPSentadoD.setName("fechanaciemiento");
        this.JTFFPSentadoD.setValue(new Integer(0));
        this.JTFFPSentadoD.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.10
            public void focusLost(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFPSentadoDFocusLost(evt);
            }
        });
        this.JTFFPSentadoD.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.11
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JTFFPSentadoDActionPerformed(evt);
            }
        });
        this.JLBPBSentado.setFont(new Font("Arial", 1, 18));
        this.JLBPBSentado.setForeground(Color.blue);
        this.JLBPBSentado.setHorizontalAlignment(0);
        this.JLBPBSentado.setText("/");
        this.JLBPSentado1.setFont(new Font("Arial", 1, 12));
        this.JLBPSentado1.setForeground(Color.blue);
        this.JLBPSentado1.setHorizontalAlignment(0);
        this.JLBPSentado1.setText("Sistólica  /  Diastólica");
        GroupLayout JPIPresionLayout = new GroupLayout(this.JPIPresion);
        this.JPIPresion.setLayout(JPIPresionLayout);
        JPIPresionLayout.setHorizontalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addComponent(this.JTFFPSentadoS, -2, 45, -2).addGap(5, 5, 5).addComponent(this.JLBPBSentado).addGap(5, 5, 5).addComponent(this.JTFFPSentadoD, -2, 45, -2)).addComponent(this.JLBPSentado1, -2, 130, -2))));
        JPIPresionLayout.setVerticalGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIPresionLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPIPresionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFPSentadoS, -2, 25, -2).addComponent(this.JLBPBSentado, -2, 23, -2).addComponent(this.JTFFPSentadoD, -2, 25, -2)).addGap(5, 5, 5).addComponent(this.JLBPSentado1)));
        this.JTFFSFc.setBorder(BorderFactory.createTitledBorder((Border) null, "Fc (p/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFc.setHorizontalAlignment(0);
        this.JTFFSFc.setText("0");
        this.JTFFSFc.setToolTipText("Frecuencia Cardiáca");
        this.JTFFSFc.setExprecionRegular("^[0-9]*$");
        this.JTFFSFc.setFocusAccelerator('C');
        this.JTFFSFc.setFont(new Font("Arial", 1, 12));
        this.JTFFSFc.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.12
            public void focusGained(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFSFcFocusGained(evt);
            }

            public void focusLost(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFSFcFocusLost(evt);
            }
        });
        this.JTFFSFc.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.13
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JTFFSFcActionPerformed(evt);
            }
        });
        this.JTFFSFc.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.14
            public void keyTyped(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTFFSFcKeyTyped(evt);
            }

            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTFFSFcKeyPressed(evt);
            }
        });
        this.JTFFSFr.setBorder(BorderFactory.createTitledBorder((Border) null, "Fr (r/m)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSFr.setHorizontalAlignment(0);
        this.JTFFSFr.setText("0");
        this.JTFFSFr.setToolTipText("Frecuencia Respiratoria");
        this.JTFFSFr.setExprecionRegular("^[0-9]*$");
        this.JTFFSFr.setFocusAccelerator('C');
        this.JTFFSFr.setFont(new Font("Arial", 1, 12));
        this.JTFFSFr.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.15
            public void focusGained(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFSFrFocusGained(evt);
            }
        });
        this.JTFFSFr.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.16
            public void keyTyped(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTFFSFrKeyTyped(evt);
            }
        });
        this.JTFFTemperatura.setBorder(BorderFactory.createTitledBorder((Border) null, "T (ªC)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFTemperatura.setHorizontalAlignment(0);
        this.JTFFTemperatura.setText("0");
        this.JTFFTemperatura.setToolTipText("Temperatura");
        this.JTFFTemperatura.setExprecionRegular("^[0-9.]*$");
        this.JTFFTemperatura.setFocusAccelerator('C');
        this.JTFFTemperatura.setFont(new Font("Arial", 1, 12));
        this.JTFFTemperatura.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.17
            public void focusGained(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFTemperaturaFocusGained(evt);
            }
        });
        this.JTFFTemperatura.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.18
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JTFFTemperaturaActionPerformed(evt);
            }
        });
        this.JTFFTemperatura.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.19
            public void keyTyped(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTFFTemperaturaKeyTyped(evt);
            }
        });
        this.JTFFPs2.setBorder(BorderFactory.createTitledBorder((Border) null, "Ps2", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFPs2.setHorizontalAlignment(0);
        this.JTFFPs2.setText("0");
        this.JTFFPs2.setToolTipText("Ps2");
        this.JTFFPs2.setExprecionRegular("^[0-9]*$");
        this.JTFFPs2.setFocusAccelerator('C');
        this.JTFFPs2.setFont(new Font("Arial", 1, 12));
        this.JTFFPs2.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.20
            public void focusGained(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFPs2FocusGained(evt);
            }
        });
        this.JTFFPs2.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.21
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JTFFPs2ActionPerformed(evt);
            }
        });
        this.JTFFPs2.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.22
            public void keyTyped(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTFFPs2KeyTyped(evt);
            }
        });
        this.JTFFSTalla.setBorder(BorderFactory.createTitledBorder((Border) null, "Talla (cm)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSTalla.setHorizontalAlignment(0);
        this.JTFFSTalla.setText("0");
        this.JTFFSTalla.setToolTipText("Talla en Centimetros");
        this.JTFFSTalla.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSTalla.setFocusAccelerator('C');
        this.JTFFSTalla.setFont(new Font("Arial", 1, 12));
        this.JTFFSTalla.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.23
            public void focusGained(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFSTallaFocusGained(evt);
            }
        });
        this.JTFFSTalla.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.24
            public void keyTyped(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTFFSTallaKeyTyped(evt);
            }
        });
        this.JTFFSPeso.setBorder(BorderFactory.createTitledBorder((Border) null, "Peso (Kg)", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPeso.setHorizontalAlignment(0);
        this.JTFFSPeso.setText("0");
        this.JTFFSPeso.setToolTipText("Peso en Kilogramos");
        this.JTFFSPeso.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPeso.setFocusAccelerator('C');
        this.JTFFSPeso.setFont(new Font("Arial", 1, 12));
        this.JTFFSPeso.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.25
            public void focusGained(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFSPesoFocusGained(evt);
            }
        });
        this.JTFFSPAM.setEditable(false);
        this.JTFFSPAM.setBorder(BorderFactory.createTitledBorder((Border) null, "PAM", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFSPAM.setHorizontalAlignment(0);
        this.JTFFSPAM.setText("0");
        this.JTFFSPAM.setToolTipText("Presion Arterial Media");
        this.JTFFSPAM.setExprecionRegular("^[0.0-9]*$");
        this.JTFFSPAM.setFocusAccelerator('C');
        this.JTFFSPAM.setFont(new Font("Arial", 1, 12));
        this.JTFFSPAM.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.26
            public void focusGained(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFFSPAMFocusGained(evt);
            }
        });
        GroupLayout JPI_SignosVitalesLayout = new GroupLayout(this.JPI_SignosVitales);
        this.JPI_SignosVitales.setLayout(JPI_SignosVitalesLayout);
        JPI_SignosVitalesLayout.setHorizontalGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JPIPresion, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSFc, -2, 80, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSFr, -2, 76, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFTemperatura, -2, 80, -2).addGap(10, 10, 10).addComponent(this.JTFFPs2, -2, 80, -2).addGap(10, 10, 10).addComponent(this.JTFFSTalla, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPeso, -2, 90, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFSPAM, -2, 90, -2).addContainerGap(-1, 32767)));
        JPI_SignosVitalesLayout.setVerticalGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_SignosVitalesLayout.createSequentialGroup().addContainerGap().addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFSFc, -2, 50, -2).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFSTalla, -2, 50, -2).addComponent(this.JTFFSPeso, -2, 50, -2).addComponent(this.JTFFSPAM, -2, 50, -2)).addGroup(JPI_SignosVitalesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFTemperatura, -2, 50, -2).addComponent(this.JTFFSFr, -2, 50, -2).addComponent(this.JTFFPs2, -2, 50, -2)).addComponent(this.JPIPresion, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSP_EFHallazgo.setBorder(BorderFactory.createTitledBorder((Border) null, "Hallazgo Positivos", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_EFHallazgo.setFont(new Font("Arial", 1, 12));
        this.JTP_EFHallazgo.setFont(new Font("Arial", 1, 12));
        this.JTP_EFHallazgo.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.27
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTP_EFHallazgoKeyPressed(evt);
            }
        });
        this.JSP_EFHallazgo.setViewportView(this.JTP_EFHallazgo);
        GroupLayout JPI_ExamenFisicoLayout = new GroupLayout(this.JPI_ExamenFisico);
        this.JPI_ExamenFisico.setLayout(JPI_ExamenFisicoLayout);
        JPI_ExamenFisicoLayout.setHorizontalGroup(JPI_ExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExamenFisicoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_ExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPI_SignosVitales, -2, 804, -2).addComponent(this.JSP_EFHallazgo)).addContainerGap(-1, 32767)));
        JPI_ExamenFisicoLayout.setVerticalGroup(JPI_ExamenFisicoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_ExamenFisicoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPI_SignosVitales, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_EFHallazgo, -1, 78, 32767).addContainerGap()));
        this.JTPMenus.addTab("EXAMEN FISICO", this.JPI_ExamenFisico);
        this.JSPInterpretacionAyudasDx.setBorder((Border) null);
        this.JTPInterpretacionAyudasDx.setFont(new Font("Arial", 1, 12));
        this.JTPInterpretacionAyudasDx.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.28
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTPInterpretacionAyudasDxKeyPressed(evt);
            }
        });
        this.JSPInterpretacionAyudasDx.setViewportView(this.JTPInterpretacionAyudasDx);
        this.JTPMenus.addTab("INTERPRETACION AYUDAS DX O TERAPEUTICAS", this.JSPInterpretacionAyudasDx);
        this.JSPNotas.setBorder((Border) null);
        this.JTPNota.setFont(new Font("Arial", 1, 12));
        this.JTPNota.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.29
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTPNotaKeyPressed(evt);
            }
        });
        this.JSPNotas.setViewportView(this.JTPNota);
        this.JTPMenus.addTab("EVOLUCION (ANALISIS Y PLAN A SEGUIR)", this.JSPNotas);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.30
            public void focusLost(FocusEvent evt) {
                JPA_NotasMedicasN.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.31
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Dx Principal", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.32
            public void mouseClicked(MouseEvent evt) {
                JPA_NotasMedicasN.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.33
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(Color.red);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.34
            public void mouseClicked(MouseEvent evt) {
                JPA_NotasMedicasN.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JTDetalle.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.35
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTDetalleKeyPressed(evt);
            }
        });
        this.JSPDiagnostico.setViewportView(this.JTDetalle);
        this.JBTGuardarTemp1.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp1.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemp1.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.36
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JBTGuardarTemp1ActionPerformed(evt);
            }
        });
        this.JSOrden.setFont(new Font("Arial", 1, 12));
        this.JSOrden.setModel(new SpinnerNumberModel(1, 1, (Comparable) null, 1));
        this.JSOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Nº Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPDiagnosticoLayout = new GroupLayout(this.JPDiagnostico);
        this.JPDiagnostico.setLayout(JPDiagnosticoLayout);
        JPDiagnosticoLayout.setHorizontalGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnosticoLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnosticoLayout.createSequentialGroup().addComponent(this.JSPDiagnostico, -2, 812, -2).addGap(0, 0, 32767)).addGroup(JPDiagnosticoLayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 63, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNCodigoDxP, -2, 597, -2).addGap(6, 6, 6).addComponent(this.JSOrden, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTGuardarTemp1, -2, 50, -2).addContainerGap()))));
        JPDiagnosticoLayout.setVerticalGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDiagnosticoLayout.createSequentialGroup().addGap(18, 18, 18).addGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBTGuardarTemp1, -2, 50, -2).addComponent(this.JTFCDxP, -2, 50, -2).addGroup(JPDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNCodigoDxP, -2, 50, -2).addComponent(this.JSOrden, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDiagnostico, -1, 139, 32767).addContainerGap()));
        this.JTPMenus.addTab("DIAGNÓSTICOS", this.JPDiagnostico);
        this.JBTGuardarTemp.setFont(new Font("Arial", 1, 12));
        this.JBTGuardarTemp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardarTemp.setText("Guardar");
        this.JBTGuardarTemp.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.37
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JBTGuardarTempActionPerformed(evt);
            }
        });
        this.JTFNNota.setFont(new Font("Arial", 1, 24));
        this.JTFNNota.setHorizontalAlignment(0);
        this.JTFNNota.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nota", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBT_NotaP.setFont(new Font("Arial", 1, 12));
        this.JBT_NotaP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/HojaLapiz29x27.png")));
        this.JBT_NotaP.setText("Notas Predefinidas");
        this.JBT_NotaP.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.38
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JBT_NotaPActionPerformed(evt);
            }
        });
        this.JBT_NotaP.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.39
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JBT_NotaPKeyPressed(evt);
            }
        });
        this.JSP_EFEstadoGeneral.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado General", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSP_EFEstadoGeneral.setFont(new Font("Arial", 1, 12));
        this.JTP_EFEstadoGeneral.setFont(new Font("Arial", 1, 12));
        this.JTP_EFEstadoGeneral.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.40
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JTP_EFEstadoGeneralKeyPressed(evt);
            }
        });
        this.JSP_EFEstadoGeneral.setViewportView(this.JTP_EFEstadoGeneral);
        GroupLayout JPI_NotaLayout = new GroupLayout(this.JPI_Nota);
        this.JPI_Nota.setLayout(JPI_NotaLayout);
        JPI_NotaLayout.setHorizontalGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPI_NotaLayout.createSequentialGroup().addContainerGap().addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTPMenus, -2, 844, -2).addGroup(GroupLayout.Alignment.LEADING, JPI_NotaLayout.createSequentialGroup().addComponent(this.JBTGuardarTemp, -2, 333, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBT_NotaP, -2, 249, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFNNota, -2, 122, -2).addGap(0, 0, 32767)).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JSP_EFEstadoGeneral, GroupLayout.Alignment.LEADING, -2, 844, -2)).addContainerGap()));
        JPI_NotaLayout.setVerticalGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_NotaLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSP_EFEstadoGeneral, -2, 66, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPMenus, -2, 289, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFNNota, -2, 50, -2).addGroup(JPI_NotaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGuardarTemp, -2, 50, -2).addComponent(this.JBT_NotaP, -2, 48, -2))).addContainerGap(-1, 32767)));
        this.JTPDatos.addTab("NOTA", this.JPI_Nota);
        this.JPI_Historico.setAutoscrolls(true);
        this.JPI_Historico.setName("xjphistoricoa");
        this.JPIDFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JCBH_Nota.setFont(new Font("Arial", 1, 12));
        this.JCBH_Nota.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Nota", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBH_Nota.addItemListener(new ItemListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.41
            public void itemStateChanged(ItemEvent evt) {
                JPA_NotasMedicasN.this.JCBH_NotaItemStateChanged(evt);
            }
        });
        this.JCBH_Nota.addKeyListener(new KeyAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.42
            public void keyPressed(KeyEvent evt) {
                JPA_NotasMedicasN.this.JCBH_NotaKeyPressed(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setText("Aplicar filtro?");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.43
            public void actionPerformed(ActionEvent evt) {
                JPA_NotasMedicasN.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDFiltroLayout = new GroupLayout(this.JPIDFiltro);
        this.JPIDFiltro.setLayout(JPIDFiltroLayout);
        JPIDFiltroLayout.setHorizontalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBH_Nota, -2, 445, -2).addGap(18, 18, 18).addComponent(this.JCHFiltro).addGap(256, 256, 256)));
        JPIDFiltroLayout.setVerticalGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDFiltroLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHFiltro).addComponent(this.JCBH_Nota, -1, -1, -2))));
        this.JSPDetalleNotas.setBorder((Border) null);
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.44
            public void mouseClicked(MouseEvent evt) {
                JPA_NotasMedicasN.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalleNotas.setViewportView(this.JTBDetalle);
        GroupLayout JPI_HistoricoLayout = new GroupLayout(this.JPI_Historico);
        this.JPI_Historico.setLayout(JPI_HistoricoLayout);
        JPI_HistoricoLayout.setHorizontalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDFiltro, -1, -1, 32767).addComponent(this.JSPDetalleNotas, -2, 844, -2)).addContainerGap()));
        JPI_HistoricoLayout.setVerticalGroup(JPI_HistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPI_HistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDFiltro, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleNotas, -2, 487, -2).addContainerGap()));
        this.JTPDatos.addTab("HISTÓRICO", this.JPI_Historico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.JTPDatos, -2, 625, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            System.out.println(this.JTFFHora.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFHoraPropertyChange(PropertyChangeEvent evt) {
        if (this.xlleno) {
            System.out.println(this.JTFFHora.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoNotaItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.xIdTipoNota[this.JCBTipoNota.getSelectedIndex()][4].equals("1")) {
            mLLenarComboInterconsuta();
        } else {
            this.JCBEspecialidad.removeAllItems();
            this.JCBEspecialidad.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCH_NCierreHCActionPerformed(ActionEvent evt) {
        if (this.JCH_NCierreHC.isSelected()) {
            this.xCerrarFac = 1L;
        } else {
            this.xCerrarFac = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPNotaKeyPressed(KeyEvent evt) {
        this.xmt.valiacionCaracterComillaSimpleTextPane(evt, this.JTPNota);
        if (evt.getKeyCode() == 9) {
            this.JTPNota.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPFocusLost(FocusEvent evt) {
        if (!this.JTFCDxP.getText().isEmpty()) {
            mBuscarPatologiaCodigo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPMouseClicked(MouseEvent evt) {
        Principal.clasehistoriace.buscarPatologiaNombre(this.JTFCDxP, this.JTFNCodigoDxP, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNCodigoDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFNCodigoDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1) {
            this.JTFCDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTFNCodigoDxP.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 1).toString());
            this.JSOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 2).toString()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalle.getRowCount() != 0 && this.JTDetalle.getSelectedRow() != -1 && this.JTFNNota.getText().isEmpty()) {
            this.xmodelo.removeRow(this.JTDetalle.getSelectedRow());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTemp1ActionPerformed(ActionEvent evt) {
        if (this.JTFNNota.getText().isEmpty()) {
            if (!this.JTFCDxP.getText().isEmpty() && !this.JTFNCodigoDxP.getText().isEmpty()) {
                Object[] fila = {this.JTFCDxP.getText(), this.JTFNCodigoDxP.getText(), this.JSOrden.getValue()};
                this.xmodelo.addRow(fila);
                this.JTDetalle.setModel(this.xmodelo);
                this.JTFCDxP.setText("");
                this.JTFNCodigoDxP.setText("");
                this.JSOrden.setValue(new Integer(1));
                return;
            }
            JOptionPane.showInternalMessageDialog(this.xjif, "Los campos no pueden estar vacios", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFCDxP.setFocusable(true);
            return;
        }
        JOptionPane.showInternalMessageDialog(this.xjif, "Esta nota ya se encuentra registrada", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarTempActionPerformed(ActionEvent evt) {
        if (Principal.informacionIps.getIdentificacion().equals("812000317") || (Principal.informacionIps.getIdentificacion().equals("812001579") && this.JTPNota.getText().length() < 100)) {
            JOptionPane.showInternalMessageDialog(this, "La evolución debe tener mínimo 100 caracteres", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else {
            mGrabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBT_NotaPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBH_NotaItemStateChanged(ItemEvent evt) {
        if (this.llenofiltro && this.JCBH_Nota.getSelectedIndex() != -1) {
            mCargarDatosHistorico();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBH_NotaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JCBEspecialidad.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        if (this.JCHFiltro.isSelected()) {
            this.llenofiltro = false;
            this.JCBH_Nota.removeAllItems();
            List<GCGenericoDTO> list1 = this.xHNotasClinicaDAO.listarTipoNotasRegistradas(this.xId_Atencion, this.xFiltro);
            this.xIdTipoNotaFiltro = new String[list1.size()];
            for (int x = 0; x < list1.size(); x++) {
                this.xIdTipoNotaFiltro[x] = String.valueOf(list1.get(x).getId());
                this.JCBH_Nota.addItem(list1.get(x).getNombre());
            }
            this.JCBH_Nota.setSelectedIndex(-1);
            this.JCBH_Nota.setEnabled(true);
            this.llenofiltro = true;
            return;
        }
        this.xlleno = false;
        this.JCBH_Nota.removeAllItems();
        this.JCBH_Nota.setEnabled(false);
        mCargarDatosHistorico();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_EFEstadoGeneralKeyPressed(KeyEvent evt) {
        this.xmt.valiacionCaracterComillaSimpleTextPane(evt, this.JTP_EFEstadoGeneral);
        if (evt.getKeyCode() == 9) {
            this.JTP_EFEstadoGeneral.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoS.getText().isEmpty()) {
            calcularPAM(this.JTFFPSentadoS.getText(), this.JTFFPSentadoD.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoSActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoS.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDFocusLost(FocusEvent evt) {
        if (!this.JTFFPSentadoD.getText().isEmpty()) {
            calcularPAM(this.JTFFPSentadoS.getText(), this.JTFFPSentadoD.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPSentadoDActionPerformed(ActionEvent evt) {
        this.JTFFPSentadoD.transferFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusGained(FocusEvent evt) {
        this.JTFFSFc.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcFocusLost(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcActionPerformed(ActionEvent evt) {
        this.JTFFSFr.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFc.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFc.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFcKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrFocusGained(FocusEvent evt) {
        this.JTFFSFr.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSFrKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFr.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSFr.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaFocusGained(FocusEvent evt) {
        this.JTFFTemperatura.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaActionPerformed(ActionEvent evt) {
        this.JTFFPs2.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFTemperaturaKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFTemperatura.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFTemperatura.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2FocusGained(FocusEvent evt) {
        this.JTFFPs2.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2ActionPerformed(ActionEvent evt) {
        this.JTFFSTalla.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPs2KeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPs2.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPs2.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaFocusGained(FocusEvent evt) {
        this.JTFFSTalla.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSTallaKeyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo solo Permite Numeros", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
            return;
        }
        if (c == ' ') {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este Campo no acepta espacios", "VALIDACIÓN", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFSTalla.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPesoFocusGained(FocusEvent evt) {
        this.JTFFSPeso.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTP_EFHallazgoKeyPressed(KeyEvent evt) {
        this.xmt.valiacionCaracterComillaSimpleTextPane(evt, this.JTP_EFHallazgo);
        if (evt.getKeyCode() == 9) {
            this.JTP_EFHallazgo.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPInterpretacionAyudasDxKeyPressed(KeyEvent evt) {
        this.xmt.valiacionCaracterComillaSimpleTextPane(evt, this.JTPInterpretacionAyudasDx);
        if (evt.getKeyCode() == 9) {
            this.JTPInterpretacionAyudasDx.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getRowCount() != -1 && this.JTBDetalle.getSelectedRow() != -1) {
            this.JTFNNota.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            this.JDCFecha.setDate(this.xmt.getPasarTextoaFecha(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString()));
            this.JTFFHora.setValue(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 3));
            this.JCBTipoNota.setSelectedItem(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 1));
            this.JTP_EFEstadoGeneral.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString());
            this.JTPNota.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            this.JTPInterpretacionAyudasDx.setText(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString());
            List<HSignosVitalesDTO> e = this.xHSignosVitalesDAO.listSignosVitalesIdNota(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            if (!e.isEmpty()) {
                this.JTFFPSentadoD.setValue(e.get(0).getTArtSentadoD());
                this.JTFFPSentadoS.setValue(e.get(0).getTArtSentadoS());
                this.JTFFSFc.setText("" + e.get(0).getFrecuenciaCardiaca());
                this.JTFFSFr.setText("" + e.get(0).getFrecuenciaRespiratoria());
                this.JTFFTemperatura.setText("" + e.get(0).getTemperatura());
                this.JTFFPs2.setText("" + e.get(0).getPresionOxigeno());
                this.JTFFSTalla.setText("" + e.get(0).getTalla());
                this.JTFFSPeso.setText("" + e.get(0).getPeso());
                this.JTP_EFHallazgo.setText(e.get(0).getObservacion());
                this.JTFFSPAM.setText("" + e.get(0).getTAMedia());
            }
            List<Object[]> listDiagnosticoNotas = this.xHNotaClinicaDiagnosticoDAO.listDiagnosticoNotaClinica(this.JTBDetalle.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            if (!listDiagnosticoNotas.isEmpty()) {
                mCrearModeloDatos();
                for (int i = 0; i < listDiagnosticoNotas.size(); i++) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(listDiagnosticoNotas.get(i)[0], i, 0);
                    this.xmodelo.setValueAt(listDiagnosticoNotas.get(i)[1], i, 1);
                    this.xmodelo.setValueAt(listDiagnosticoNotas.get(i)[2], i, 2);
                }
            }
            this.JTPDatos.setSelectedIndex(0);
            this.nEvolucionAsistencial = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFSPAMFocusGained(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        if (this.JTFNNota.getText().isEmpty() && this.JCBTipoNota.getSelectedIndex() != -1 && !this.JTPNota.getText().isEmpty() && !this.JTP_EFEstadoGeneral.getText().isEmpty() && !this.JTFFSFc.getText().isEmpty() && Double.parseDouble(this.JTFFSFc.getText().toString()) > 0.0d && !this.JTFFSFr.getText().isEmpty() && Double.parseDouble(this.JTFFSFr.getText().toString()) > 0.0d && !this.JTFFTemperatura.getText().isEmpty() && Double.parseDouble(this.JTFFTemperatura.getText().toString()) >= 0.0d && !this.JTFFPs2.getText().isEmpty() && Double.parseDouble(this.JTFFPs2.getText().toString()) >= 0.0d && !this.JTP_EFHallazgo.getText().isEmpty() && !this.JTPInterpretacionAyudasDx.getText().isEmpty()) {
            mGrabarM();
        }
    }

    private void mValidarPresion(int valor, int xt) {
        if (xt == 0) {
            if (valor > 0 && valor < 100) {
                JOptionPane.showInternalMessageDialog(this, "Presión Sistólica Baja", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                return;
            } else {
                if (valor > 0 && valor > 140) {
                    JOptionPane.showInternalMessageDialog(this, "Presión Sistólica Alta", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
                    return;
                }
                return;
            }
        }
        if (valor > 0 && valor < 60) {
            JOptionPane.showInternalMessageDialog(this, "Presión Diastólica Baja", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        } else if (valor > 0 && valor > 90) {
            JOptionPane.showInternalMessageDialog(this, "Presión Diastólica Alta", "VERIFICAR", 2, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Warning.png"))));
        }
    }

    public void mImprimir() {
        if (!this.JTFNNota.getText().isEmpty() && this.JCBTipoNota.getSelectedIndex() != -1 && !this.xIdTipoNota[this.JCBTipoNota.getSelectedIndex()][4].equals("")) {
            ImpresionDocumentosHC impresionDocumentos = new ImpresionDocumentosHC();
            impresionDocumentos.mImprimirNotasClinciasNuevasIdNota(this.JCBTipoNota.getSelectedItem().toString(), this.xIdTipoNota[this.JCBTipoNota.getSelectedIndex()][4], String.valueOf(this.xId_Atencion), this.JTFNNota.getText());
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Diagnóstico", "Nº Orden"}) { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.45
            Class[] types = {String.class, String.class, Long.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(50);
    }

    public void mNuevo() {
        this.JDCFecha.setDate(this.xmt.getFechaActual());
        this.JTFFHora.setText(this.xmt.formatoH24.format(this.xmt.getFechaActual()));
        this.JTFNNota.setText("");
        this.JTPNota.setText("");
        mCrearModeloDatos();
        mLLenarCombo();
        this.JTP_EFEstadoGeneral.setText("");
        this.JTP_EFHallazgo.setText("");
        this.JCBEspecialidad.removeAllItems();
        this.JTFFPSentadoD.setText("0");
        this.JTFFPSentadoS.setText("0");
        this.JTFFSFc.setText("0");
        this.JTFFSFr.setText("0");
        this.JTFFPs2.setText("0");
        this.JTFFSPeso.setText("0");
        this.JTFFSTalla.setText("0");
        this.JTFFTemperatura.setText("0");
        this.JTFFSPAM.setText("0");
        this.JTPInterpretacionAyudasDx.setText("");
        cargarDatosExamenFisico();
        mCargarDatosHistorico();
        mCargarDiagnosticosDeIngreso();
    }

    private void cargarDatosExamenFisico() {
        try {
            this.xsql = "select he.Talla , he.Peso \nfrom h_examenfisico he \nwhere he.Id_Atencion ='" + this.xId_Atencion + "'";
            ConsultasMySQL xct = new ConsultasMySQL();
            ResultSet xrs = xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    if (xrs.next()) {
                        xrs.first();
                        this.JTFFSPeso.setText("" + xrs.getFloat("Peso"));
                        this.JTFFSTalla.setText("" + xrs.getFloat("Talla"));
                    }
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger logger = Logger.getLogger(JPA_NotasMedicasN.class.getName());
            Level level = Level.ALL;
            logger.log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mLLenarCombo() {
        this.JCBTipoNota.removeAllItems();
        List<Object[]> listTipoNota = this.xHistoriaDAO.listadoTipoNotasporEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), this.xFiltro);
        if (!listTipoNota.isEmpty()) {
            this.xIdTipoNota = new String[listTipoNota.size()][6];
            for (int i = 0; i < listTipoNota.size(); i++) {
                this.xIdTipoNota[i][0] = String.valueOf(listTipoNota.get(i)[0]);
                this.xIdTipoNota[i][1] = String.valueOf(listTipoNota.get(i)[1]);
                this.xIdTipoNota[i][2] = String.valueOf(listTipoNota.get(i)[2]);
                this.xIdTipoNota[i][3] = String.valueOf(listTipoNota.get(i)[3]);
                this.xIdTipoNota[i][4] = String.valueOf(listTipoNota.get(i)[4]);
                this.xIdTipoNota[i][5] = String.valueOf(listTipoNota.get(i)[5]);
                this.JCBTipoNota.addItem(listTipoNota.get(i)[1]);
            }
        }
    }

    private void mLLenarComboInterconsuta() {
        this.JCBEspecialidad.removeAllItems();
        List<Object[]> listEspecialidadInter = this.xHistoriaDAO.listadoTipoNotasporEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), this.xFiltro);
        if (!listEspecialidadInter.isEmpty()) {
            this.xIdEspecialidadInterc = new String[listEspecialidadInter.size()];
            for (int i = 0; i < listEspecialidadInter.size(); i++) {
                this.xIdEspecialidadInterc[i] = String.valueOf(listEspecialidadInter.get(i)[0]);
                this.JCBEspecialidad.addItem(listEspecialidadInter.get(i)[1]);
            }
        }
    }

    private void springStart() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"});
        this.xPatologiaCie10DAO = (PatologiaCie10DAOImpl) classPathXmlApplicationContext.getBean("patologiaCie10DAOImpl");
        this.xHistoriaDAO = (HistoriaDAOImpl) classPathXmlApplicationContext.getBean("historiaDAOImpl");
        this.xHNotasClinicaDAO = (HNotaClinicaDAOImpl) classPathXmlApplicationContext.getBean("hNotaClinicaDAOImpl");
        this.xHSignosVitalesDAO = (HSignosVitalesDAOImpl) classPathXmlApplicationContext.getBean("hSignosVitalesDAOImpl");
        this.xHNotaClinicaDiagnosticoDAO = (HNotaClinicaDiagnosticoDAOImpl) classPathXmlApplicationContext.getBean("hNotaClinicaDiagnosticoDAOImpl");
        this.xHOrdenInterconsultaDAO = (HOrdenInterconsultaDAOImpl) classPathXmlApplicationContext.getBean("hOrdenInterconsultaDAOImpl");
    }

    private void mBuscarPatologiaCodigo() {
        List<PatologiaCie10DTO> listPatologia = this.xPatologiaCie10DAO.listPatologiaFiltrada(this.JTFCDxP.getText(), "0");
        if (!listPatologia.isEmpty()) {
            for (int i = 0; i < listPatologia.size(); i++) {
                this.JTFCDxP.setText("" + listPatologia.get(i).getId());
                this.JTFNCodigoDxP.setText("" + listPatologia.get(i).getNombre());
            }
            if (Principal.clasehistoriace.xjifhistoriaclinica != null) {
                Principal.clasehistoriace.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), Principal.clasehistoriace.xjifhistoriaclinica);
                return;
            } else if (Principal.clasehistoriace.historia_Clinica_v2 != null) {
                Principal.clasehistoriace.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), Principal.clasehistoriace.historia_Clinica_v4);
                return;
            } else {
                if (Principal.clasehistoriace.historia_Clinica_v2 != null) {
                    Principal.clasehistoriace.buscarPatologias(this.JTFCDxP, this.JTFNCodigoDxP, 1, clasesHistoriaCE.informacionAgendaMedicaDTO.getFechaNacimiento(), clasesHistoriaCE.informacionAgendaMedicaDTO.getIdSexo(), Principal.clasehistoriace.historia_Clinica_v2);
                    return;
                }
                return;
            }
        }
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
    }

    private void mGrabar() {
        if (this.JTFNNota.getText().isEmpty()) {
            if (this.JCBTipoNota.getSelectedIndex() != -1) {
                if (!this.JTPNota.getText().isEmpty()) {
                    if (!this.JTP_EFEstadoGeneral.getText().isEmpty()) {
                        if (this.JTFFSFc.getText().isEmpty() && !this.JTFFSFc.getText().isEmpty()) {
                            JOptionPane.showInternalMessageDialog(this, "La Fc no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTPMenus.setSelectedIndex(0);
                            this.JTFFSFc.requestFocus();
                            return;
                        }
                        if (Double.parseDouble(this.JTFFSFc.getText().toString()) >= 0.0d) {
                            if (this.JTFFSFr.getText().isEmpty() && !this.JTFFSFr.getText().isEmpty()) {
                                JOptionPane.showInternalMessageDialog(this, "La Fr no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTPMenus.setSelectedIndex(0);
                                this.JTFFSFr.requestFocus();
                                return;
                            }
                            if (Double.parseDouble(this.JTFFSFr.getText().toString()) >= 0.0d) {
                                if (this.JTFFTemperatura.getText().isEmpty() && !this.JTFFTemperatura.getText().isEmpty()) {
                                    JOptionPane.showInternalMessageDialog(this, "La Temperatura no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTFFTemperatura.requestFocus();
                                    return;
                                }
                                if (Double.parseDouble(this.JTFFTemperatura.getText().toString()) >= 0.0d) {
                                    if (this.JTFFPs2.getText().isEmpty() && !this.JTFFPs2.getText().isEmpty()) {
                                        JOptionPane.showInternalMessageDialog(this, "La Ps2 no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                        this.JTPMenus.setSelectedIndex(0);
                                        this.JTFFPs2.requestFocus();
                                        return;
                                    }
                                    if (Double.parseDouble(this.JTFFPs2.getText().toString()) >= 0.0d) {
                                        if (!this.JTP_EFHallazgo.getText().isEmpty() || this.JTP_EFHallazgo.getText().isEmpty()) {
                                            if (!this.JTPInterpretacionAyudasDx.getText().isEmpty()) {
                                                mGrabarM();
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "El campo interpretacion no debe estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                                this.JTPMenus.setSelectedIndex(0);
                                                this.JTP_EFHallazgo.requestFocus();
                                            }
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "El campo hallazgo no debe estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                            this.JTPMenus.setSelectedIndex(0);
                                            this.JTP_EFHallazgo.requestFocus();
                                        }
                                        this.nEvolucionAsistencial = true;
                                        return;
                                    }
                                    JOptionPane.showInternalMessageDialog(this, "La Ps2 no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                    this.JTPMenus.setSelectedIndex(0);
                                    this.JTFFPs2.requestFocus();
                                    return;
                                }
                                JOptionPane.showInternalMessageDialog(this, "La Temperatura no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                this.JTPMenus.setSelectedIndex(0);
                                this.JTFFTemperatura.requestFocus();
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "La Fr no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JTPMenus.setSelectedIndex(0);
                            this.JTFFSFr.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "La Fc no debe \n  estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTPMenus.setSelectedIndex(0);
                        this.JTFFSFc.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "El campo estado general no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTP_EFEstadoGeneral.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El campo evolucion no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPMenus.setSelectedIndex(2);
                this.JTFNNota.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de nota", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoNota.requestFocus();
            return;
        }
        mActualizar();
    }

    private void mGrabarM() {
        HNotasClinicasDTO n = new HNotasClinicasDTO();
        n.setFechaNota(this.xmt.formatoAMD1.format(this.JDCFecha.getDate()));
        n.setHoraNota(this.JTFFHora.getText());
        n.setIdTipoNota(Integer.valueOf(this.xIdTipoNota[this.JCBTipoNota.getSelectedIndex()][0]));
        n.setDescripcion(this.JTPNota.getText().replaceAll("\n", " "));
        n.setEstado(true);
        n.setFecha(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
        n.setIdAtencion(Long.valueOf(this.xId_Atencion));
        n.setIdEndodoncia(0);
        n.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        n.setIdOrdenF(0L);
        n.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        n.setIdTipoAtencion(Integer.valueOf(this.xTipoAtencion));
        n.setNCierre(false);
        n.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        n.setEstadoGeneral(this.JTP_EFEstadoGeneral.getText().replaceAll("\n", " "));
        n.setInterpretacionAyudaDx(this.JTPInterpretacionAyudasDx.getText().replaceAll("\n", " "));
        Long xIdNota = this.xHNotasClinicaDAO.mCrear(n);
        this.JTFNNota.setText("" + xIdNota);
        this.nEvolucionAsistencial = true;
        HSignosVitalesDTO e = new HSignosVitalesDTO();
        e.setEstado(true);
        e.setFecha(this.xmt.formatoAMD1.format(this.JDCFecha.getDate()));
        e.setHora(this.JTFFHora.getText());
        e.setFrecuenciaCardiaca(Long.valueOf(this.JTFFSFc.getText()));
        e.setFrecuenciaRespiratoria(Long.valueOf(this.JTFFSFr.getText()));
        e.setIdAtencion(Long.valueOf(this.xId_Atencion));
        e.setIdEspecialidad(Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
        e.setIdProfesional(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
        e.setIdNotaClinica(xIdNota);
        e.setImc(new Double(0.0d));
        e.setObservacion(this.JTP_EFHallazgo.getText().replaceAll("\n", " "));
        e.setPeso(Double.valueOf(this.JTFFSPeso.getText()));
        e.setPresionOxigeno(Long.valueOf(this.JTFFPs2.getText()));
        e.setTalla(Double.valueOf(this.JTFFSTalla.getText()));
        e.setTemperatura(Double.valueOf(this.JTFFTemperatura.getText()));
        e.setPAbdominal(new Double(0.0d));
        e.setSCorporal(new Double(0.0d));
        e.setTArtSentadoD(Long.valueOf(this.JTFFPSentadoD.getText()));
        e.setTArtSentadoS(Long.valueOf(this.JTFFPSentadoS.getText()));
        e.setTAMedia(Double.valueOf(this.JTFFSPAM.getText()));
        this.xHSignosVitalesDAO.mCrear(e);
        for (int i = 0; i < this.JTDetalle.getRowCount(); i++) {
            HNotaClinicaDiagnosticoDTO d = new HNotaClinicaDiagnosticoDTO();
            d.setEstado(true);
            d.setFecha(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
            d.setIdNClinica(xIdNota);
            d.setIdPatologia(this.JTDetalle.getValueAt(i, 0).toString());
            d.setIdUsuarioS(Principal.usuarioSistemaDTO.getIdUsuarioSistema());
            d.setNOrden(Integer.valueOf(this.JTDetalle.getValueAt(i, 2).toString()));
            this.xHNotaClinicaDiagnosticoDAO.mCrear(d);
        }
        if (this.JCBEspecialidad.getSelectedIndex() != -1 && this.xIdTipoNota[this.JCBH_Nota.getSelectedIndex()][5].equals("1")) {
            HOrdenInterconsultaDTO h = new HOrdenInterconsultaDTO();
            h.setIdEspecialidad(Long.valueOf(this.xIdEspecialidadInterc[this.JCBEspecialidad.getSelectedIndex()]));
            h.setFecha(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
            h.setIdNota(xIdNota);
            h.setIdRemoto(new Long(0L));
            h.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            this.xHOrdenInterconsultaDAO.mCrear(h);
        }
        this.nEvolucionAsistencial = true;
        System.out.println("nota evolucion -> " + this.nEvolucionAsistencial);
    }

    private void mActualizar() {
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla() {
        this.xmodeloH = new DefaultTableModel(new Object[0], new String[]{"Id", "Tipo Nota", "Fecha", "Hora", "Estado General", "Descripción", "Interpretacion Ayudas Dx", "Especialidad", "Profesional"}) { // from class: com.genoma.plus.controller.historia.JPA_NotasMedicasN.46
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTBDetalle;
        JTable jTable2 = this.JTBDetalle;
        jTable.setAutoResizeMode(0);
        this.JTBDetalle.doLayout();
        this.JTBDetalle.setModel(this.xmodeloH);
        this.JTBDetalle.getColumnModel().getColumn(0).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(300);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(200);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(300);
    }

    private void mCargarDatosHistorico() {
        List<Object[]> list = null;
        if (Principal.claseenfer != null) {
            if (this.JCHFiltro.isSelected()) {
                list = this.xHNotasClinicaDAO.listNotaClinica(Long.valueOf(this.xId_Atencion), this.xFiltro, this.xIdTipoNotaFiltro[this.JCBH_Nota.getSelectedIndex()]);
            } else {
                list = this.xHNotasClinicaDAO.listNotaClinica(Long.valueOf(this.xId_Atencion), this.xFiltro, "");
            }
        } else if (Principal.clasehistoriace != null) {
            if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
                if (this.JCHFiltro.isSelected()) {
                    list = this.xHNotasClinicaDAO.listNotaClinica(Long.valueOf(this.xId_Atencion), this.xFiltro, this.xIdTipoNotaFiltro[this.JCBH_Nota.getSelectedIndex()]);
                } else {
                    list = this.xHNotasClinicaDAO.listNotaClinica(Long.valueOf(this.xId_Atencion));
                }
            } else if (this.JCHFiltro.isSelected()) {
                list = this.xHNotasClinicaDAO.listNotaClinica(Long.valueOf(this.xId_Atencion), this.xFiltro, this.xIdTipoNotaFiltro[this.JCBH_Nota.getSelectedIndex()]);
            } else {
                list = this.xHNotasClinicaDAO.listNotaClinica(Long.valueOf(this.xId_Atencion), this.xFiltro, "");
            }
        }
        mCrearTabla();
        this.xmt.mEstablecerTextEditor(this.JTBDetalle, 3);
        this.xmt.mEstablecerTextEditor(this.JTBDetalle, 4);
        this.xmt.mEstablecerTextEditor(this.JTBDetalle, 5);
        this.xmt.mEstablecerTextEditor(this.JTBDetalle, 6);
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodeloH.addRow(this.xdatos);
                this.xmodeloH.setValueAt(list.get(x)[0], x, 0);
                this.xmodeloH.setValueAt(list.get(x)[1], x, 1);
                this.xmodeloH.setValueAt(list.get(x)[2], x, 2);
                this.xmodeloH.setValueAt(list.get(x)[3], x, 3);
                this.xmodeloH.setValueAt(list.get(x)[4], x, 4);
                this.xmodeloH.setValueAt(list.get(x)[5], x, 5);
                this.xmodeloH.setValueAt(list.get(x)[6], x, 6);
                this.xmodeloH.setValueAt(list.get(x)[10], x, 7);
                this.xmodeloH.setValueAt(list.get(x)[11], x, 8);
            }
        }
    }

    private void calcularPAM(String pad, String pas) {
        if (!pad.isEmpty() && isNumeric(pad) && !pas.isEmpty() && isNumeric(pas)) {
            double pam = ((2 * Integer.valueOf(pad).intValue()) + Integer.valueOf(pas).intValue()) / 3;
            this.JTFFSPAM.setText(pam + "");
        } else {
            this.JTFFSPAM.setText("0");
        }
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Esta Orden No Es Numerica");
            return false;
        }
    }

    private void mCargarDiagnosticosDeIngreso() {
        if (this.JTFNNota.getText().isEmpty()) {
            List<Object[]> listUltimaNota = this.xHNotaClinicaDiagnosticoDAO.listUltimaNotaEspecialista(Long.valueOf(this.xId_Atencion), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad());
            if (!listUltimaNota.isEmpty() && !listUltimaNota.get(0)[0].toString().equals("0")) {
                List<Object[]> listDiagnosticos = this.xHNotaClinicaDiagnosticoDAO.listDiagnosticosEspecialidadAnterior(Long.valueOf(this.xId_Atencion), Principal.informacionGeneralPrincipalDTO.getIdEspecialidad(), listUltimaNota.get(0)[0].toString());
                if (!listDiagnosticos.isEmpty()) {
                    for (int x = 0; x < listDiagnosticos.size(); x++) {
                        llenarCamposDX(listDiagnosticos.get(x)[0].toString(), listDiagnosticos.get(x)[1].toString(), Integer.valueOf(listDiagnosticos.get(x)[2].toString()).intValue());
                    }
                    return;
                }
                List<Object[]> listIngreso = this.xHNotaClinicaDiagnosticoDAO.listDiagnosticosIngreso(Long.valueOf(this.xId_Atencion));
                if (!listIngreso.isEmpty()) {
                    int i = 0;
                    for (int x2 = 0; x2 < 4; x2++) {
                        if (!listIngreso.get(0)[i].toString().isEmpty()) {
                            llenarCamposDX(listIngreso.get(0)[i].toString(), listIngreso.get(0)[i + 1].toString(), 3 - this.JTDetalle.getRowCount());
                        }
                        i += 2;
                    }
                    return;
                }
                return;
            }
            List<Object[]> listIngreso2 = this.xHNotaClinicaDiagnosticoDAO.listDiagnosticosIngreso(Long.valueOf(this.xId_Atencion));
            if (!listIngreso2.isEmpty()) {
                int i2 = 0;
                for (int x3 = 0; x3 < 4; x3++) {
                    if (!listIngreso2.get(0)[i2].toString().isEmpty()) {
                        llenarCamposDX(listIngreso2.get(0)[i2].toString(), listIngreso2.get(0)[i2 + 1].toString(), 3 - this.JTDetalle.getRowCount());
                    }
                    i2 += 2;
                }
            }
        }
    }

    private void llenarCamposDX(String cie10, String nPatologia, int nOrden) {
        this.JTFCDxP.setText(cie10);
        this.JTFNCodigoDxP.setText(nPatologia);
        this.JSOrden.setValue(Integer.valueOf(nOrden));
        JBTGuardarTemp1ActionPerformed(null);
    }
}
