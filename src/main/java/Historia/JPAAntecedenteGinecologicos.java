package Historia;

import PyP.clasePyP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecedenteGinecologicos.class */
public class JPAAntecedenteGinecologicos extends JPanel {
    private String sql;
    private ResultSet rs;
    private clasePyP clasepyp;
    private ButtonGroup JBGPlanifica;
    private ButtonGroup JBGResultadoCitol;
    private ButtonGroup JBGResultadoMamas;
    private JPanel JPIAntecendesGinecologicos;
    private JPanel JPIFormulaGestacional;
    private JScrollPane JSPDRMamas;
    private JTabbedPane JTPAGinecoObstetricos;
    private JCheckBox btnEnfMama;
    private JButton btnGrabar;
    public JDateChooser cboUltimaAborto;
    private ButtonGroup grpoPlanifica;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel21;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    public JDateChooser txtBiopsia;
    public JDateChooser txtCauterizacion;
    public JDateChooser txtConizacion;
    private JSpinner txtEdadRelaciones;
    public JDateChooser txtHisterectomia;
    private JTextField txtMenarquia;
    private JSpinner txtNoAbortos;
    private JSpinner txtNoCesareas;
    private JSpinner txtNoEmbarazos;
    private JSpinner txtNoEptopicos;
    private JSpinner txtNoMuertos;
    private JSpinner txtNoPartos;
    private JSpinner txtNoVivos;
    public JDateChooser txtRadioterapia;
    private JTextPane txtResultadoMamas;
    private JSpinner txtTiempoPlanifica;
    public JDateChooser txtUltimaEco;
    public JDateChooser txtUltimoEmbarazo;
    public JDateChooser txtUltimoParto;
    private Metodos metodos = new Metodos();
    private ConsultasMySQL consultas = new ConsultasMySQL();
    private int enfMama = 0;
    private int existe = 0;

    public JPAAntecedenteGinecologicos(clasePyP clase) {
        initComponents();
        this.clasepyp = clase;
        cargarAntecedentes();
    }

    public JPAAntecedenteGinecologicos() {
        initComponents();
    }

    private void cargarAntecedentes() {
        this.sql = "SELECT FUMestruacion, FUC, Res_FUC, Desc_FUC, FUEM, Enf_Mama, Desc_Mama, Id_MetPlanifica, TiempoEnPlanifica, No_G, No_P, No_C, No_A, UltimoEmbarazo, UltimoParto, UltimoAborto, No_E, No_M, No_V, Menarquia, EdadInicioRel, CauterizacionCuello, RadioterapiaUtero, Histerectomia, ConizacionCuello, Biopsia FROM h_antecedenteginecologico WHERE (Id_Usuario ='" + this.clasepyp.frmToma.frmPersona.getIdPersona() + "' order by Id desc)";
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.rs.first();
                if (this.rs.getString("Menarquia") != null) {
                    this.txtMenarquia.setText(this.rs.getString("Menarquia"));
                }
                this.txtEdadRelaciones.setValue(Integer.valueOf(this.rs.getInt("EdadInicioRel")));
                if (this.rs.getDate("FUEM") != null) {
                    this.txtUltimaEco.setDate(this.rs.getDate("FUEM"));
                }
                this.txtResultadoMamas.setText(this.rs.getString("Desc_Mama"));
                if (this.rs.getString("Enf_Mama").equals("1")) {
                    this.enfMama = 1;
                    this.btnEnfMama.setSelected(true);
                } else {
                    this.enfMama = 0;
                    this.btnEnfMama.setSelected(false);
                }
                this.txtTiempoPlanifica.setValue(Integer.valueOf(this.rs.getInt("TiempoEnPlanifica")));
                this.txtNoEmbarazos.setValue(Integer.valueOf(this.rs.getInt("No_G")));
                this.txtNoEptopicos.setValue(Integer.valueOf(this.rs.getInt("No_E")));
                this.txtNoPartos.setValue(Integer.valueOf(this.rs.getInt("No_P")));
                this.txtNoCesareas.setValue(Integer.valueOf(this.rs.getInt("No_C")));
                this.txtNoAbortos.setValue(Integer.valueOf(this.rs.getInt("No_A")));
                this.txtNoMuertos.setValue(Integer.valueOf(this.rs.getInt("No_M")));
                this.txtNoVivos.setValue(Integer.valueOf(this.rs.getInt("No_V")));
                if (this.rs.getDate("UltimoEmbarazo") != null) {
                    this.txtUltimoEmbarazo.setDate(this.rs.getDate("UltimoEmbarazo"));
                }
                if (this.rs.getDate("UltimoParto") != null) {
                    this.txtUltimoParto.setDate(this.rs.getDate("UltimoParto"));
                }
                if (this.rs.getDate("UltimoAborto") != null) {
                    this.cboUltimaAborto.setDate(this.rs.getDate("UltimoAborto"));
                }
                if (this.rs.getDate("CauterizacionCuello") != null) {
                    this.txtCauterizacion.setDate(this.rs.getDate("CauterizacionCuello"));
                }
                if (this.rs.getDate("RadioterapiaUtero") != null) {
                    this.txtRadioterapia.setDate(this.rs.getDate("RadioterapiaUtero"));
                }
                if (this.rs.getDate("Histerectomia") != null) {
                    this.txtHisterectomia.setDate(this.rs.getDate("Histerectomia"));
                }
                if (this.rs.getDate("ConizacionCuello") != null) {
                    this.txtConizacion.setDate(this.rs.getDate("ConizacionCuello"));
                }
                if (this.rs.getDate("Biopsia") != null) {
                    this.txtBiopsia.setDate(this.rs.getDate("Biopsia"));
                }
                this.existe = 1;
            } else {
                this.existe = 0;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void grabar() {
    }

    private int validarDatos() {
        return 0;
    }

    private void initComponents() {
        this.JBGResultadoCitol = new ButtonGroup();
        this.JBGResultadoMamas = new ButtonGroup();
        this.JBGPlanifica = new ButtonGroup();
        this.grpoPlanifica = new ButtonGroup();
        this.JPIAntecendesGinecologicos = new JPanel();
        this.JPIFormulaGestacional = new JPanel();
        this.jLabel6 = new JLabel();
        this.txtNoEmbarazos = new JSpinner();
        this.txtNoPartos = new JSpinner();
        this.jLabel7 = new JLabel();
        this.txtNoCesareas = new JSpinner();
        this.jLabel8 = new JLabel();
        this.txtNoAbortos = new JSpinner();
        this.jLabel9 = new JLabel();
        this.jLabel10 = new JLabel();
        this.txtUltimoParto = new JDateChooser();
        this.txtNoEptopicos = new JSpinner();
        this.jLabel12 = new JLabel();
        this.txtNoMuertos = new JSpinner();
        this.txtNoVivos = new JSpinner();
        this.jLabel13 = new JLabel();
        this.jLabel18 = new JLabel();
        this.jLabel11 = new JLabel();
        this.txtUltimoEmbarazo = new JDateChooser();
        this.cboUltimaAborto = new JDateChooser();
        this.jLabel19 = new JLabel();
        this.jPanel3 = new JPanel();
        this.jLabel14 = new JLabel();
        this.txtCauterizacion = new JDateChooser();
        this.jLabel15 = new JLabel();
        this.txtRadioterapia = new JDateChooser();
        this.jLabel16 = new JLabel();
        this.txtHisterectomia = new JDateChooser();
        this.jLabel17 = new JLabel();
        this.txtConizacion = new JDateChooser();
        this.jLabel21 = new JLabel();
        this.txtBiopsia = new JDateChooser();
        this.btnGrabar = new JButton();
        this.JTPAGinecoObstetricos = new JTabbedPane();
        this.jPanel2 = new JPanel();
        this.txtMenarquia = new JTextField();
        this.txtEdadRelaciones = new JSpinner();
        this.txtTiempoPlanifica = new JSpinner();
        this.jPanel1 = new JPanel();
        this.txtUltimaEco = new JDateChooser();
        this.btnEnfMama = new JCheckBox();
        this.JSPDRMamas = new JScrollPane();
        this.txtResultadoMamas = new JTextPane();
        setMinimumSize(new Dimension(861, 531));
        setName("AntecedenteGineco");
        setPreferredSize(new Dimension(861, 531));
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAAntecedenteGinecologicos.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAAntecedenteGinecologicos.this.formAncestorRemoved(evt);
            }
        });
        this.JPIAntecendesGinecologicos.setBorder(BorderFactory.createTitledBorder((Border) null, "ANTECEDENTES GINECO-OBSTRETICOS", 1, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIAntecendesGinecologicos.setLayout(new AbsoluteLayout());
        this.JPIFormulaGestacional.setBorder(BorderFactory.createTitledBorder((Border) null, "EMBARAZO.ABORTOS,PARTOS Y CESAREAS", 1, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JPIFormulaGestacional.setLayout(new AbsoluteLayout());
        this.jLabel6.setFont(new Font("Arial", 1, 12));
        this.jLabel6.setForeground(new Color(0, 0, 255));
        this.jLabel6.setText("No Embarazos");
        this.JPIFormulaGestacional.add(this.jLabel6, new AbsoluteConstraints(10, 20, 110, 20));
        this.txtNoEmbarazos.setFont(new Font("Arial", 1, 12));
        this.txtNoEmbarazos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JPIFormulaGestacional.add(this.txtNoEmbarazos, new AbsoluteConstraints(10, 40, 70, 30));
        this.txtNoPartos.setFont(new Font("Arial", 1, 12));
        this.txtNoPartos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JPIFormulaGestacional.add(this.txtNoPartos, new AbsoluteConstraints(270, 40, 70, 30));
        this.jLabel7.setFont(new Font("Arial", 1, 12));
        this.jLabel7.setForeground(new Color(0, 0, 255));
        this.jLabel7.setText("No Partos");
        this.JPIFormulaGestacional.add(this.jLabel7, new AbsoluteConstraints(270, 20, 90, 20));
        this.txtNoCesareas.setFont(new Font("Arial", 1, 12));
        this.txtNoCesareas.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JPIFormulaGestacional.add(this.txtNoCesareas, new AbsoluteConstraints(380, 40, 70, 30));
        this.jLabel8.setFont(new Font("Arial", 1, 12));
        this.jLabel8.setForeground(new Color(0, 0, 255));
        this.jLabel8.setText("No Cesareas");
        this.JPIFormulaGestacional.add(this.jLabel8, new AbsoluteConstraints(380, 20, 90, 20));
        this.txtNoAbortos.setFont(new Font("Arial", 1, 12));
        this.txtNoAbortos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JPIFormulaGestacional.add(this.txtNoAbortos, new AbsoluteConstraints(490, 40, 70, 30));
        this.jLabel9.setFont(new Font("Arial", 1, 12));
        this.jLabel9.setForeground(new Color(0, 0, 255));
        this.jLabel9.setText("No Abortos");
        this.JPIFormulaGestacional.add(this.jLabel9, new AbsoluteConstraints(490, 20, 70, 20));
        this.jLabel10.setFont(new Font("Arial", 1, 12));
        this.jLabel10.setForeground(new Color(0, 0, 255));
        this.jLabel10.setText("Fecha Ultimo Parto");
        this.JPIFormulaGestacional.add(this.jLabel10, new AbsoluteConstraints(270, 90, 180, -1));
        this.txtUltimoParto.setDateFormatString("dd/MM/yyyy");
        this.txtUltimoParto.setFont(new Font("Arial", 1, 12));
        this.txtUltimoParto.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimoParto.setName("cboMenarquia");
        this.txtUltimoParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.txtUltimoPartoPropertyChange(evt);
            }
        });
        this.JPIFormulaGestacional.add(this.txtUltimoParto, new AbsoluteConstraints(270, 110, 180, 30));
        this.txtNoEptopicos.setFont(new Font("Arial", 1, 12));
        this.txtNoEptopicos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JPIFormulaGestacional.add(this.txtNoEptopicos, new AbsoluteConstraints(120, 40, 70, 30));
        this.jLabel12.setFont(new Font("Arial", 1, 12));
        this.jLabel12.setForeground(new Color(0, 0, 255));
        this.jLabel12.setText("No Nacidos Muertos");
        this.JPIFormulaGestacional.add(this.jLabel12, new AbsoluteConstraints(580, 20, 110, 20));
        this.txtNoMuertos.setFont(new Font("Arial", 1, 12));
        this.txtNoMuertos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JPIFormulaGestacional.add(this.txtNoMuertos, new AbsoluteConstraints(580, 40, 70, 30));
        this.txtNoVivos.setFont(new Font("Arial", 1, 12));
        this.txtNoVivos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JPIFormulaGestacional.add(this.txtNoVivos, new AbsoluteConstraints(700, 40, 70, 30));
        this.jLabel13.setFont(new Font("Arial", 1, 12));
        this.jLabel13.setForeground(new Color(0, 0, 255));
        this.jLabel13.setText("No Nacidos Vivos");
        this.JPIFormulaGestacional.add(this.jLabel13, new AbsoluteConstraints(700, 20, 100, 20));
        this.jLabel18.setFont(new Font("Arial", 1, 12));
        this.jLabel18.setForeground(new Color(0, 0, 255));
        this.jLabel18.setText("No Embarazos Eptopicos");
        this.JPIFormulaGestacional.add(this.jLabel18, new AbsoluteConstraints(120, 20, 150, 20));
        this.jLabel11.setFont(new Font("Arial", 1, 12));
        this.jLabel11.setForeground(new Color(0, 0, 255));
        this.jLabel11.setText("Fecha Ultimo Embarazo");
        this.JPIFormulaGestacional.add(this.jLabel11, new AbsoluteConstraints(10, 90, 180, 20));
        this.txtUltimoEmbarazo.setToolTipText("Fecha de la primera mestruación");
        this.txtUltimoEmbarazo.setDateFormatString("dd/MM/yyyy");
        this.txtUltimoEmbarazo.setFont(new Font("Arial", 1, 12));
        this.txtUltimoEmbarazo.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimoEmbarazo.setName("cboMenarquia");
        this.txtUltimoEmbarazo.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.txtUltimoEmbarazoPropertyChange(evt);
            }
        });
        this.JPIFormulaGestacional.add(this.txtUltimoEmbarazo, new AbsoluteConstraints(10, 110, 180, 30));
        this.cboUltimaAborto.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaAborto.setFont(new Font("Arial", 1, 12));
        this.cboUltimaAborto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaAborto.setName("cboMenarquia");
        this.cboUltimaAborto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.cboUltimaAbortoPropertyChange(evt);
            }
        });
        this.JPIFormulaGestacional.add(this.cboUltimaAborto, new AbsoluteConstraints(490, 110, 160, 30));
        this.jLabel19.setFont(new Font("Arial", 1, 12));
        this.jLabel19.setForeground(new Color(0, 0, 255));
        this.jLabel19.setText("Fecha Ultimo Aborto");
        this.JPIFormulaGestacional.add(this.jLabel19, new AbsoluteConstraints(490, 90, 160, -1));
        this.JPIAntecendesGinecologicos.add(this.JPIFormulaGestacional, new AbsoluteConstraints(10, 50, 810, 150));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Fechas de Realización de Procedimientos Quirúrgicos", 0, 0, new Font("Tahoma", 1, 11), new Color(0, 102, 102)));
        this.jPanel3.setLayout(new AbsoluteLayout());
        this.jLabel14.setFont(new Font("Arial", 1, 12));
        this.jLabel14.setForeground(new Color(0, 0, 255));
        this.jLabel14.setText("Cauterización Cuello Uterino");
        this.jPanel3.add(this.jLabel14, new AbsoluteConstraints(10, 20, 180, -1));
        this.txtCauterizacion.setDateFormatString("dd/MM/yyyy");
        this.txtCauterizacion.setFont(new Font("Arial", 1, 12));
        this.txtCauterizacion.setMaxSelectableDate(new Date(253370786463000L));
        this.txtCauterizacion.setName("cboMenarquia");
        this.txtCauterizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.txtCauterizacionPropertyChange(evt);
            }
        });
        this.jPanel3.add(this.txtCauterizacion, new AbsoluteConstraints(10, 40, 130, 30));
        this.jLabel15.setFont(new Font("Arial", 1, 12));
        this.jLabel15.setForeground(new Color(0, 0, 255));
        this.jLabel15.setText("Radioterapia en Utero");
        this.jPanel3.add(this.jLabel15, new AbsoluteConstraints(190, 20, 150, -1));
        this.txtRadioterapia.setDateFormatString("dd/MM/yyyy");
        this.txtRadioterapia.setFont(new Font("Arial", 1, 12));
        this.txtRadioterapia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtRadioterapia.setName("cboMenarquia");
        this.txtRadioterapia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.txtRadioterapiaPropertyChange(evt);
            }
        });
        this.jPanel3.add(this.txtRadioterapia, new AbsoluteConstraints(190, 40, 130, 30));
        this.jLabel16.setFont(new Font("Arial", 1, 12));
        this.jLabel16.setForeground(new Color(0, 0, 255));
        this.jLabel16.setText("Histerectomia");
        this.jPanel3.add(this.jLabel16, new AbsoluteConstraints(340, 20, 130, -1));
        this.txtHisterectomia.setDateFormatString("dd/MM/yyyy");
        this.txtHisterectomia.setFont(new Font("Arial", 1, 12));
        this.txtHisterectomia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtHisterectomia.setName("cboMenarquia");
        this.txtHisterectomia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.txtHisterectomiaPropertyChange(evt);
            }
        });
        this.jPanel3.add(this.txtHisterectomia, new AbsoluteConstraints(340, 40, 130, 30));
        this.jLabel17.setFont(new Font("Arial", 1, 12));
        this.jLabel17.setForeground(new Color(0, 0, 255));
        this.jLabel17.setText("Conización del Cuello Uterino");
        this.jPanel3.add(this.jLabel17, new AbsoluteConstraints(480, 20, 180, -1));
        this.txtConizacion.setDateFormatString("dd/MM/yyyy");
        this.txtConizacion.setFont(new Font("Arial", 1, 12));
        this.txtConizacion.setMaxSelectableDate(new Date(253370786463000L));
        this.txtConizacion.setName("cboMenarquia");
        this.txtConizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.txtConizacionPropertyChange(evt);
            }
        });
        this.jPanel3.add(this.txtConizacion, new AbsoluteConstraints(480, 40, 130, 30));
        this.jLabel21.setFont(new Font("Arial", 1, 12));
        this.jLabel21.setForeground(new Color(0, 0, 255));
        this.jLabel21.setText("Ultima Biopsia");
        this.jPanel3.add(this.jLabel21, new AbsoluteConstraints(660, 20, 130, -1));
        this.txtBiopsia.setDateFormatString("dd/MM/yyyy");
        this.txtBiopsia.setFont(new Font("Arial", 1, 12));
        this.txtBiopsia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtBiopsia.setName("cboMenarquia");
        this.txtBiopsia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.txtBiopsiaPropertyChange(evt);
            }
        });
        this.jPanel3.add(this.txtBiopsia, new AbsoluteConstraints(660, 40, 130, 30));
        this.JPIAntecendesGinecologicos.add(this.jPanel3, new AbsoluteConstraints(10, 200, 810, 90));
        this.btnGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Grabar29x27.png")));
        this.btnGrabar.setText("Grabar");
        this.btnGrabar.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGinecologicos.10
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGinecologicos.this.btnGrabarActionPerformed(evt);
            }
        });
        this.JPIAntecendesGinecologicos.add(this.btnGrabar, new AbsoluteConstraints(550, 290, 260, 40));
        this.JTPAGinecoObstetricos.setForeground(new Color(0, 103, 0));
        this.JTPAGinecoObstetricos.setFont(new Font("Arial", 1, 14));
        this.txtMenarquia.setFont(new Font("Arial", 1, 12));
        this.txtMenarquia.setHorizontalAlignment(4);
        this.txtMenarquia.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Menarquia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtEdadRelaciones.setFont(new Font("Arial", 1, 12));
        this.txtEdadRelaciones.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtEdadRelaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad IRelaciones", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTiempoPlanifica.setFont(new Font("Arial", 1, 12));
        this.txtTiempoPlanifica.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtTiempoPlanifica.setBorder(BorderFactory.createTitledBorder((Border) null, "Tiempo de Planificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "ENFERMEDAD MAMARIA", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.txtUltimaEco.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Ecografias", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtUltimaEco.setDateFormatString("dd/MM/yyyy");
        this.txtUltimaEco.setFont(new Font("Arial", 1, 12));
        this.txtUltimaEco.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimaEco.setName("cboMenarquia");
        this.txtUltimaEco.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGinecologicos.11
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGinecologicos.this.txtUltimaEcoPropertyChange(evt);
            }
        });
        this.btnEnfMama.setFont(new Font("Arial", 1, 12));
        this.btnEnfMama.setForeground(Color.blue);
        this.btnEnfMama.setText("Enf Mamaria?");
        this.btnEnfMama.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGinecologicos.12
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGinecologicos.this.btnEnfMamaActionPerformed(evt);
            }
        });
        this.JSPDRMamas.setBorder(BorderFactory.createTitledBorder((Border) null, "DRESCIPCIÓN ENFERMEDAD", 1, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.txtResultadoMamas.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecedenteGinecologicos.13
            public void keyPressed(KeyEvent evt) {
                JPAAntecedenteGinecologicos.this.txtResultadoMamasKeyPressed(evt);
            }
        });
        this.JSPDRMamas.setViewportView(this.txtResultadoMamas);
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(10, 10, 10).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDRMamas, -1, 255, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.txtUltimaEco, -2, 130, -2).addGap(10, 10, 10).addComponent(this.btnEnfMama).addContainerGap(12, 32767)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtUltimaEco, -2, 50, -2).addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.btnEnfMama))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDRMamas, -2, 64, -2).addContainerGap()));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.txtTiempoPlanifica, GroupLayout.Alignment.LEADING, -1, 138, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtMenarquia, GroupLayout.Alignment.LEADING).addComponent(this.txtEdadRelaciones, GroupLayout.Alignment.LEADING, -1, 134, 32767))).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addGap(402, 402, 402)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel1, 0, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent(this.txtMenarquia, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtEdadRelaciones, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtTiempoPlanifica, -2, -1, -2))).addContainerGap(-1, 32767)));
        this.JTPAGinecoObstetricos.addTab("GINECOLÓGICOS", this.jPanel2);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addContainerGap().addComponent(this.JTPAGinecoObstetricos)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGap(30, 30, 30).addComponent(this.JPIAntecendesGinecologicos, -2, 830, -2))).addGap(1, 1, 1)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPAGinecoObstetricos, -2, 205, -2).addGap(29, 29, 29).addComponent(this.JPIAntecendesGinecologicos, -2, 339, -2)));
        this.JTPAGinecoObstetricos.getAccessibleContext().setAccessibleName("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtResultadoMamasKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.txtResultadoMamas.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUltimaEcoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUltimoPartoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCauterizacionPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtRadioterapiaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHisterectomiaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtConizacionPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEnfMamaActionPerformed(ActionEvent evt) {
        if (this.btnEnfMama.isSelected()) {
            this.enfMama = 1;
        } else {
            this.enfMama = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUltimoEmbarazoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaAbortoPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtBiopsiaPropertyChange(PropertyChangeEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnGrabarActionPerformed(ActionEvent evt) {
        grabar();
    }
}
