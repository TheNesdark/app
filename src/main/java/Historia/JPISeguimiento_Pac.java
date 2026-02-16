package Historia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPISeguimiento_Pac.class */
public class JPISeguimiento_Pac extends JPanel {
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private Object[] xdatos;
    private String xsql;
    private String xidusuario;
    private String xidusariop;
    private String[] xdidtipo;
    private String[] xideps;
    private String[] xidmunicipio;
    private JButton JBTAdicionar;
    private JComboBox JCBDEps;
    private JComboBox JCBD_Municipio;
    private JComboBox JCBD_TipoAtencion;
    private JCheckBox JCHMedicinaPrepagada;
    private JCheckBox JCHPyp;
    private JDateChooser JDD_Fecha;
    private JLabel JLBNSeguimiento;
    private JPanel JPDxAtencion;
    private JPanel JPID_Encabezado;
    private JPanel JPIDatosS;
    private JPanel JPIDiagnostico;
    private JPanel JPIMotivo;
    private JScrollPane JSPD_Antecedente;
    private JScrollPane JSPD_Motivo;
    private JScrollPane JSPDiagnostico;
    private JScrollPane JSPMotivo;
    private JSpinner JSPNDiasSeguimiento;
    private JSpinner JSPOrden;
    private JTextArea JTAD_Antecedente;
    private JTextArea JTAD_Motivo;
    private JTable JTBDiagnostico;
    private JTable JTBM_Detalle;
    public JTextField JTFCDxP;
    private JTextField JTFD_Acompanante;
    private JTextField JTFD_MedicoT;
    private JTextField JTFD_Sitio;
    public JTextField JTFNCodigoDxP;
    private JTabbedPane JTPDatosM;
    private JTabbedPane JTPDatosS;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xidatencion = "0";
    private int n = 1;
    private int xesmp = 0;
    private int xpyp = 0;
    private int xfila = 0;
    private boolean xlleno = false;

    public JPISeguimiento_Pac(String xidusario, String xidusariop, String xidatencion) {
        initComponents();
        this.xidusuario = xidusario;
        this.xidusariop = xidusariop;
        mNuevo();
    }

    private void initComponents() {
        this.JTPDatosS = new JTabbedPane();
        this.JPIDatosS = new JPanel();
        this.JPID_Encabezado = new JPanel();
        this.JDD_Fecha = new JDateChooser();
        this.JCBD_TipoAtencion = new JComboBox();
        this.JTFD_Sitio = new JTextField();
        this.JTFD_Acompanante = new JTextField();
        this.JSPD_Antecedente = new JScrollPane();
        this.JTAD_Antecedente = new JTextArea();
        this.JSPD_Motivo = new JScrollPane();
        this.JTAD_Motivo = new JTextArea();
        this.JTFD_MedicoT = new JTextField();
        this.JLBNSeguimiento = new JLabel();
        this.JCBDEps = new JComboBox();
        this.JCBD_Municipio = new JComboBox();
        this.JCHMedicinaPrepagada = new JCheckBox();
        this.JCHPyp = new JCheckBox();
        this.JSPNDiasSeguimiento = new JSpinner();
        this.JTPDatosM = new JTabbedPane();
        this.JPIDiagnostico = new JPanel();
        this.JPDxAtencion = new JPanel();
        this.JSPDiagnostico = new JScrollPane();
        this.JTBDiagnostico = new JTable();
        this.JTFCDxP = new JTextField();
        this.JTFNCodigoDxP = new JTextField();
        this.JSPOrden = new JSpinner();
        this.JBTAdicionar = new JButton();
        this.JPIMotivo = new JPanel();
        this.JSPMotivo = new JScrollPane();
        this.JTBM_Detalle = new JTable();
        setBorder(BorderFactory.createTitledBorder((Border) null, "SEGUIMIENTO A PACIENTES", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjpseguimientopac");
        this.JTPDatosS.setForeground(new Color(255, 0, 0));
        this.JTPDatosS.setFont(new Font("Arial", 1, 14));
        this.JPID_Encabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "ENCABEZADO ATENCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDD_Fecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDD_Fecha.setToolTipText("Fecha");
        this.JDD_Fecha.setDateFormatString("dd/MM/yyyy");
        this.JDD_Fecha.setFont(new Font("Arial", 1, 12));
        this.JCBD_TipoAtencion.setFont(new Font("Arial", 1, 12));
        this.JCBD_TipoAtencion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Atención", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBD_TipoAtencion.addItemListener(new ItemListener() { // from class: Historia.JPISeguimiento_Pac.1
            public void itemStateChanged(ItemEvent evt) {
                JPISeguimiento_Pac.this.JCBD_TipoAtencionItemStateChanged(evt);
            }
        });
        this.JTFD_Sitio.setFont(new Font("Arial", 1, 12));
        this.JTFD_Sitio.setBorder(BorderFactory.createTitledBorder((Border) null, "Sitio de Atención", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFD_Acompanante.setFont(new Font("Arial", 1, 12));
        this.JTFD_Acompanante.setBorder(BorderFactory.createTitledBorder((Border) null, "Acompañante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPD_Antecedente.setBorder(BorderFactory.createTitledBorder((Border) null, "Antecedentes", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAD_Antecedente.setColumns(1);
        this.JTAD_Antecedente.setFont(new Font("Arial", 1, 12));
        this.JTAD_Antecedente.setRows(1);
        this.JTAD_Antecedente.setTabSize(1);
        this.JSPD_Antecedente.setViewportView(this.JTAD_Antecedente);
        this.JSPD_Motivo.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTAD_Motivo.setColumns(1);
        this.JTAD_Motivo.setFont(new Font("Arial", 1, 12));
        this.JTAD_Motivo.setRows(1);
        this.JTAD_Motivo.setTabSize(1);
        this.JSPD_Motivo.setViewportView(this.JTAD_Motivo);
        this.JTFD_MedicoT.setFont(new Font("Arial", 1, 12));
        this.JTFD_MedicoT.setBorder(BorderFactory.createTitledBorder((Border) null, "Médico Tratante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBNSeguimiento.setFont(new Font("Arial", 1, 18));
        this.JLBNSeguimiento.setHorizontalAlignment(0);
        this.JLBNSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "N°", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDEps.setFont(new Font("Arial", 1, 12));
        this.JCBDEps.setBorder(BorderFactory.createTitledBorder((Border) null, "Eps", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBD_Municipio.setFont(new Font("Arial", 1, 12));
        this.JCBD_Municipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHMedicinaPrepagada.setFont(new Font("Arial", 1, 12));
        this.JCHMedicinaPrepagada.setText("Medicina Prepagada?");
        this.JCHMedicinaPrepagada.addActionListener(new ActionListener() { // from class: Historia.JPISeguimiento_Pac.2
            public void actionPerformed(ActionEvent evt) {
                JPISeguimiento_Pac.this.JCHMedicinaPrepagadaActionPerformed(evt);
            }
        });
        this.JCHPyp.setFont(new Font("Arial", 1, 12));
        this.JCHPyp.setText("Es PyP?");
        this.JCHPyp.addActionListener(new ActionListener() { // from class: Historia.JPISeguimiento_Pac.3
            public void actionPerformed(ActionEvent evt) {
                JPISeguimiento_Pac.this.JCHPypActionPerformed(evt);
            }
        });
        this.JSPNDiasSeguimiento.setFont(new Font("Arial", 1, 12));
        this.JSPNDiasSeguimiento.setModel(new SpinnerNumberModel(1, 1, 30, 1));
        this.JSPNDiasSeguimiento.setToolTipText("Números de días para seguimiento");
        this.JSPNDiasSeguimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Días", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPID_EncabezadoLayout = new GroupLayout(this.JPID_Encabezado);
        this.JPID_Encabezado.setLayout(JPID_EncabezadoLayout);
        JPID_EncabezadoLayout.setHorizontalGroup(JPID_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_EncabezadoLayout.createSequentialGroup().addContainerGap().addGroup(JPID_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_EncabezadoLayout.createSequentialGroup().addComponent(this.JDD_Fecha, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBD_TipoAtencion, -2, 160, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBDEps, -2, 236, -2).addGap(18, 18, 18).addComponent(this.JCBD_Municipio, 0, -1, 32767)).addGroup(JPID_EncabezadoLayout.createSequentialGroup().addComponent(this.JSPD_Antecedente, -2, 257, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPD_Motivo, -2, 174, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPNDiasSeguimiento).addGap(18, 18, 18).addComponent(this.JCHPyp).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBNSeguimiento, -2, 102, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPID_EncabezadoLayout.createSequentialGroup().addComponent(this.JCHMedicinaPrepagada).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFD_Acompanante, -2, 201, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFD_MedicoT).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFD_Sitio, -2, 163, -2))).addContainerGap()));
        JPID_EncabezadoLayout.setVerticalGroup(JPID_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPID_EncabezadoLayout.createSequentialGroup().addGroup(JPID_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPID_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBD_TipoAtencion, -2, -1, -2).addComponent(this.JCBDEps, -2, -1, -2).addComponent(this.JCBD_Municipio, -2, -1, -2)).addComponent(this.JDD_Fecha, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPID_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFD_Acompanante, -2, -1, -2).addComponent(this.JTFD_MedicoT, -2, -1, -2).addComponent(this.JTFD_Sitio, -2, -1, -2).addComponent(this.JCHMedicinaPrepagada)).addGap(17, 17, 17).addGroup(JPID_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPID_EncabezadoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPD_Antecedente, -1, 61, 32767).addComponent(this.JSPD_Motivo).addComponent(this.JLBNSeguimiento, -1, -1, 32767)).addComponent(this.JCHPyp).addComponent(this.JSPNDiasSeguimiento, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JTPDatosM.setForeground(new Color(0, 103, 0));
        this.JTPDatosM.setFont(new Font("Arial", 1, 14));
        this.JSPDiagnostico.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTBDiagnostico.setFont(new Font("Arial", 1, 12));
        this.JTBDiagnostico.setRowHeight(25);
        this.JTBDiagnostico.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDiagnostico.setSelectionForeground(new Color(255, 0, 0));
        this.JSPDiagnostico.setViewportView(this.JTBDiagnostico);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Historia.JPISeguimiento_Pac.4
            public void focusLost(FocusEvent evt) {
                JPISeguimiento_Pac.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPISeguimiento_Pac.5
            public void keyPressed(KeyEvent evt) {
                JPISeguimiento_Pac.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JTFNCodigoDxP.setFont(new Font("Arial", 1, 12));
        this.JTFNCodigoDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Dx", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFNCodigoDxP.addMouseListener(new MouseAdapter() { // from class: Historia.JPISeguimiento_Pac.6
            public void mouseClicked(MouseEvent evt) {
                JPISeguimiento_Pac.this.JTFNCodigoDxPMouseClicked(evt);
            }
        });
        this.JTFNCodigoDxP.addKeyListener(new KeyAdapter() { // from class: Historia.JPISeguimiento_Pac.7
            public void keyPressed(KeyEvent evt) {
                JPISeguimiento_Pac.this.JTFNCodigoDxPKeyPressed(evt);
            }
        });
        this.JSPOrden.setFont(new Font("Arial", 1, 12));
        this.JSPOrden.setModel(new SpinnerNumberModel(1, 1, 5, 1));
        this.JSPOrden.setToolTipText("Orden de diagnóstico");
        this.JSPOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JPISeguimiento_Pac.8
            public void actionPerformed(ActionEvent evt) {
                JPISeguimiento_Pac.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPDxAtencionLayout = new GroupLayout(this.JPDxAtencion);
        this.JPDxAtencion.setLayout(JPDxAtencionLayout);
        JPDxAtencionLayout.setHorizontalGroup(JPDxAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDxAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFCDxP, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNCodigoDxP, -2, 445, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPOrden, -2, 67, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTAdicionar).addContainerGap(20, 32767)).addGroup(JPDxAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDxAtencionLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDiagnostico, -1, 731, 32767).addContainerGap())));
        JPDxAtencionLayout.setVerticalGroup(JPDxAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDxAtencionLayout.createSequentialGroup().addContainerGap().addGroup(JPDxAtencionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTAdicionar, -2, 42, -2).addGroup(JPDxAtencionLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFCDxP, -2, -1, -2).addComponent(this.JTFNCodigoDxP, -2, 41, -2).addComponent(this.JSPOrden, -2, -1, -2))).addContainerGap(115, 32767)).addGroup(JPDxAtencionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPDxAtencionLayout.createSequentialGroup().addContainerGap(57, 32767).addComponent(this.JSPDiagnostico, -2, 100, -2).addContainerGap())));
        GroupLayout JPIDiagnosticoLayout = new GroupLayout(this.JPIDiagnostico);
        this.JPIDiagnostico.setLayout(JPIDiagnosticoLayout);
        JPIDiagnosticoLayout.setHorizontalGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addGap(0, 0, 32767).addComponent(this.JPDxAtencion, -2, -1, -2).addGap(0, 0, 32767)));
        JPIDiagnosticoLayout.setVerticalGroup(JPIDiagnosticoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDiagnosticoLayout.createSequentialGroup().addContainerGap().addComponent(this.JPDxAtencion, -1, -1, 32767)));
        this.JTPDatosM.addTab("DIAGNÓSTICO ATENCIÓN", this.JPIDiagnostico);
        this.JSPMotivo.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTBM_Detalle.setFont(new Font("Arial", 1, 12));
        this.JTBM_Detalle.setRowHeight(25);
        this.JTBM_Detalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBM_Detalle.setSelectionForeground(new Color(255, 0, 0));
        this.JSPMotivo.setViewportView(this.JTBM_Detalle);
        GroupLayout JPIMotivoLayout = new GroupLayout(this.JPIMotivo);
        this.JPIMotivo.setLayout(JPIMotivoLayout);
        JPIMotivoLayout.setHorizontalGroup(JPIMotivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMotivoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPMotivo, -1, 731, 32767).addContainerGap()));
        JPIMotivoLayout.setVerticalGroup(JPIMotivoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMotivoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPMotivo, -1, 157, 32767).addContainerGap()));
        this.JTPDatosM.addTab("DIAGNÓSTICO PYP", this.JPIMotivo);
        GroupLayout JPIDatosSLayout = new GroupLayout(this.JPIDatosS);
        this.JPIDatosS.setLayout(JPIDatosSLayout);
        JPIDatosSLayout.setHorizontalGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosM, -2, 0, 32767).addComponent(this.JPID_Encabezado, -1, -1, 32767)).addContainerGap()));
        JPIDatosSLayout.setVerticalGroup(JPIDatosSLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosSLayout.createSequentialGroup().addContainerGap().addComponent(this.JPID_Encabezado, -2, 207, -2).addGap(18, 18, 18).addComponent(this.JTPDatosM, -2, 210, -2).addContainerGap()));
        this.JTPDatosS.addTab("DATOS", this.JPIDatosS);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatosS, -1, 781, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatosS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBD_TipoAtencionItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBD_TipoAtencion.getSelectedIndex() != -1) {
            mCargarDatosTablaI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMedicinaPrepagadaActionPerformed(ActionEvent evt) {
        if (this.JCHMedicinaPrepagada.isSelected()) {
            this.xesmp = 1;
        } else {
            this.xesmp = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPypActionPerformed(ActionEvent evt) {
        if (this.JCHPyp.isSelected()) {
            this.xpyp = 1;
        } else {
            this.xpyp = 0;
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
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JTFCDxP.getText().isEmpty()) {
            if (!this.JTFNCodigoDxP.getText().isEmpty()) {
                this.xmodelo1.addRow(this.xdatos);
                this.xmodelo1.setValueAt(this.JTFCDxP.getText(), this.xfila, 0);
                this.xmodelo1.setValueAt(this.JTFNCodigoDxP.getText(), this.xfila, 1);
                this.xmodelo1.setValueAt(this.JSPOrden.getValue(), this.xfila, 2);
                this.xfila++;
                this.JTFCDxP.setText("");
                this.JTFNCodigoDxP.setText("");
                this.JSPOrden.setValue(Integer.valueOf(this.n + 1));
                this.n++;
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "El campo Nombre no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFNCodigoDxP.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El campo Cie10 no puede estar en blanco", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFCDxP.requestFocus();
    }

    public void mNuevo() {
        this.xlleno = false;
        this.JCBD_TipoAtencion.removeAllItems();
        this.JCBDEps.removeAllItems();
        this.JCBD_Municipio.removeAllItems();
        this.xdidtipo = this.xct.llenarCombo("SELECT `Id`, `Nbre` FROM `g_tipoatencion` ORDER BY `Nbre` ASC", this.xdidtipo, this.JCBD_TipoAtencion);
        this.JCBD_TipoAtencion.setSelectedIndex(-1);
        this.xideps = this.xct.llenarCombo("SELECT `Id`, `RazonSocialCompleta` FROM `cc_terceros` WHERE (`EsEps` =1) ORDER BY `RazonSocialCompleta` ASC", this.xideps, this.JCBDEps);
        this.JCBDEps.setSelectedIndex(-1);
        this.xidmunicipio = this.xct.llenarCombo("SELECT `Id`, `NMunicipio` FROM  `g_municipio_departamento` ORDER BY `NMunicipio` ASC", this.xidmunicipio, this.JCBD_Municipio);
        this.JCBD_Municipio.setSelectedIndex(-1);
        this.JDD_Fecha.setDate(this.xmt.getFechaActual());
        this.JSPNDiasSeguimiento.setValue(new Integer(0));
        this.JCHMedicinaPrepagada.setSelected(false);
        this.JCHPyp.setSelected(false);
        this.JTFD_Acompanante.setText("");
        this.JTFD_MedicoT.setText("");
        this.JTFD_Sitio.setText("");
        this.JTAD_Antecedente.setText("");
        this.JTAD_Motivo.setText("");
        this.JLBNSeguimiento.setText("");
        this.JTFCDxP.setText("");
        this.JTFNCodigoDxP.setText("");
        this.JSPOrden.setValue(new Integer(1));
        mCrearTabla_Motivo();
        mCrearTablaDx();
        this.xct.cerrarConexionBd();
        this.xlleno = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTabla_Motivo() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Motivo", "Observación", "Aplica?", "NVariable"}) { // from class: Historia.JPISeguimiento_Pac.9
            Class[] types = {Long.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBM_Detalle.setModel(this.xmodelo);
        this.JTBM_Detalle.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBM_Detalle.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBM_Detalle.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBM_Detalle.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTBM_Detalle.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTBM_Detalle.getColumnModel().getColumn(3).setPreferredWidth(10);
        this.JTBM_Detalle.getColumnModel().getColumn(4).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaDx() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Cie10", "Patologia", "Orden"}) { // from class: Historia.JPISeguimiento_Pac.10
            Class[] types = {String.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDiagnostico.setModel(this.xmodelo1);
        this.JTBDiagnostico.getColumnModel().getColumn(0).setPreferredWidth(5);
        this.JTBDiagnostico.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTBDiagnostico.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatosTablaI() {
        try {
            mCrearTabla_Motivo();
            if (this.JLBNSeguimiento.getText().isEmpty()) {
                this.xsql = "SELECT `Id`, `Nbre`, '',false,`Variable` FROM `h_tipo_seguimiento_motivo` WHERE (`Tipo` ='" + this.xdidtipo[this.JCBD_TipoAtencion.getSelectedIndex()] + "') ORDER BY `Nbre` ASC ";
            } else {
                this.xsql = "SELECT `h_tipo_seguimiento_motivo`.`Id` , `h_tipo_seguimiento_motivo`.`Nbre` , `h_seguimientopac_motivo`.`Observacion` , TRUE , `h_tipo_seguimiento_motivo`.`Variable` FROM  `h_seguimientopac_motivo` INNER JOIN `h_seguimientospac`  ON (`h_seguimientopac_motivo`.`Id_SeguimientoPac` = `h_seguimientospac`.`Id`) INNER JOIN `h_tipo_seguimiento_motivo`  ON (`h_seguimientopac_motivo`.`Id_Tipo_Seguimiento` = `h_tipo_seguimiento_motivo`.`Id`) WHERE (`h_seguimientopac_motivo`.`Estado` =1 AND `h_seguimientospac`.`Id` ='" + this.JLBNSeguimiento.getText() + "') ORDER BY `h_tipo_seguimiento_motivo`.`Nbre` ASC ";
            }
            ResultSet rs = this.xct.traerRs(this.xsql);
            Throwable th = null;
            try {
                try {
                    rs.next();
                    if (rs.getRow() != 0) {
                        rs.beforeFirst();
                        int i = 0;
                        while (rs.next()) {
                            this.xmodelo.addRow(this.xdatos);
                            this.xmodelo.setValueAt(Long.valueOf(rs.getLong(1)), i, 0);
                            this.xmodelo.setValueAt(rs.getString(2), i, 1);
                            this.xmodelo.setValueAt(rs.getString(3), i, 2);
                            this.xmodelo.setValueAt(Boolean.valueOf(rs.getBoolean(4)), i, 3);
                            this.xmodelo.setValueAt(rs.getString(5), i, 4);
                            i++;
                        }
                    }
                    if (rs != null) {
                        if (0 != 0) {
                            try {
                                rs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            rs.close();
                        }
                    }
                    this.xct.cerrarConexionBd();
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                throw th3;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JPISeguimiento_Pac.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (this.JLBNSeguimiento.getText().isEmpty()) {
            if (this.JCBD_TipoAtencion.getSelectedIndex() != -1) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    this.xsql = "INSERT INTO `h_seguimientospac` (`Id_Usuario`,`FechaInicio`,`Id_TipoSeguimiento`,`Id_Empresa`,`Id_Municipio`,`EsMp`,`Nbre_Sitio`,`NAcompanante`,`Antecedente`,`Medico_Tratante`,`Id_Especialidad_A`,`Id_Profesional_A`,`PPrograma`,`DescripcionInicial`,`NDias_Seguimiento`,`UsuarioS`)VALUES ('" + this.xidusuario + "','" + this.xmt.formatoAMD.format(this.JDD_Fecha.getDate()) + "','" + this.xdidtipo[this.JCBD_TipoAtencion.getSelectedIndex()] + "','" + this.xideps[this.JCBDEps.getSelectedIndex()] + "','" + this.xidmunicipio[this.JCBD_Municipio.getSelectedIndex()] + "','" + this.xesmp + "','" + this.JTFD_Sitio.getText() + "','" + this.JTFD_Acompanante.getText() + "','" + this.JTAD_Antecedente.getText() + "','" + this.JTFD_MedicoT.getText() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + this.xpyp + "','" + this.JTAD_Motivo.getText() + "','" + this.JSPNDiasSeguimiento.getValue() + "','" + Principal.usuarioSistemaDTO.getLogin() + "');";
                    this.JLBNSeguimiento.setText(this.xct.ejecutarSQLId(this.xsql));
                    this.xct.cerrarConexionBd();
                    for (int x = 0; x < this.JTBM_Detalle.getRowCount(); x++) {
                        if (Boolean.valueOf(this.xmodelo.getValueAt(x, 3).toString()).booleanValue()) {
                            this.xsql = "insert into h_seguimientopac_motivo(`Id_SeguimientoPac`, `Id_Tipo_Seguimiento`, `Observacion`) values('" + this.JLBNSeguimiento.getText() + "','" + this.xmodelo.getValueAt(x, 0) + "','" + this.xmodelo.getValueAt(x, 2) + "')";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            this.xsql = "update g_usuarioxprograma set " + this.xmodelo.getValueAt(x, 4).toString() + "='" + this.xmt.formatoAMD.format(this.JDD_Fecha.getDate()) + "' where Id='" + this.xidusariop + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    for (int x2 = 0; x2 < this.JTBDiagnostico.getRowCount(); x2++) {
                        this.xsql = "INSERT INTO `h_seguimientopac_dx`(`Id_SeguimientoPac`,`Id_Patologia`,`Orden`,`UsuarioS`)\nVALUES ('" + this.JLBNSeguimiento.getText() + "',        '" + this.xmodelo1.getValueAt(x2, 0) + "',        '" + this.xmodelo1.getValueAt(x2, 2) + "',        '" + Principal.usuarioSistemaDTO.getLogin() + "');";
                        this.xct.ejecutarSQL(this.xsql);
                        this.xct.cerrarConexionBd();
                        if (this.xmodelo1.getValueAt(x2, 2).equals("1")) {
                            this.xsql = "UPDATE g_usuarioxprograma SET FechaHospitalizion='" + this.xmt.formatoAMD.format(this.JDD_Fecha.getDate()) + "' , DxHospitalizacion='" + this.xmodelo1.getValueAt(x2, 0) + " " + this.xmodelo1.getValueAt(x2, 1) + "' where Id='" + this.xidusariop + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                    }
                    return;
                }
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de atención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBD_TipoAtencion.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Registro ya grabado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    private void buscarPatologias(JTextField codigo, JTextField nombrep, int n) {
        if (!codigo.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "'";
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
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, codigo, nombrep, "seguimientopac", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }
}
