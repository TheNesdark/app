package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPPermisosMedicos.class */
public class JPPermisosMedicos extends JPanel {
    private String[] xidunidad;
    private String[] xidsupervisor;
    private String[] xidespecialidad;
    private String[] xidciudad;
    private String xsql;
    private String[][] xdtipocita;
    private clasesHistoriaCE xclase;
    private ButtonGroup JBGTipoC;
    private ButtonGroup JBGTipoEntidad;
    private ButtonGroup JBGVoBo;
    private JComboBox JCBCiudadCita;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBSupervisor;
    public JComboBox JCBUnidadNegocio;
    private JDateChooser JDCFechaCita;
    private JLabel JLBCual;
    private JLabel JLBN;
    private JLabel JLBObservaciones;
    private JList JLDatosCita;
    private JPanel JPIDPermisos;
    private JPanel JPIDatosCita;
    private JPanel JPITipoConsulta;
    private JPanel JPITipoEntidad;
    private JPanel JPIVoBo;
    private JPanel JPPermisosMedicos;
    public JRadioButton JRBAmbulatoria;
    public JRadioButton JRBEps;
    public JRadioButton JRBMedPrepagada;
    public JRadioButton JRBNo;
    public JRadioButton JRBPrioritaria;
    public JRadioButton JRBSi;
    public JRadioButton JRBUrgente;
    private JScrollPane JSPCual;
    private JScrollPane JSPDatosCita;
    private JScrollPane JSPObservaciones;
    public JTextField JTFEstado;
    public JTextField JTFN;
    private JTextPane JTPCual;
    private JTextPane JTPObservaciones;
    public int xtipoentidad = 1;
    public int xvobo = 0;
    public int xtipoc = 0;
    private DefaultListModel xmodelo = new DefaultListModel();
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPPermisosMedicos(clasesHistoriaCE xclase) {
        initComponents();
        this.xclase = xclase;
        this.xidunidad = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_tipounidadnegocio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidunidad, this.JCBUnidadNegocio);
        this.JCBUnidadNegocio.setSelectedIndex(-1);
        this.xidsupervisor = this.xconsultasbd.llenarCombo("SELECT supervisor.Id_Persona, supervisor.NSupervisor FROM baseserver.g_supervisor INNER JOIN baseserver.supervisor  ON (g_supervisor.Id_Persona = supervisor.Id_Persona) WHERE (g_supervisor.Estado =0)ORDER BY supervisor.NSupervisor ASC", this.xidsupervisor, this.JCBSupervisor);
        this.JCBSupervisor.setSelectedIndex(-1);
        this.xidciudad = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_municipio WHERE (Estado =0) ORDER BY Nbre ASC", this.xidciudad, this.JCBCiudadCita);
        this.JCBCiudadCita.setSelectedIndex(-1);
        this.xidespecialidad = this.xconsultasbd.llenarCombo("SELECT  Id , Nbre FROM g_especialidad WHERE (Estado =0) ORDER BY Nbre ASC", this.xidespecialidad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JDCFechaCita.setDate(this.xmetodo.getFechaActual());
        this.xsql = "SELECT Id, Nbre, EsEspec FROM g_tipocitap WHERE (Estado =0) ORDER BY Nbre ASC";
        ResultSet rs = this.xconsultasbd.traerRs(this.xsql);
        try {
            rs.next();
            if (rs.getRow() != 0) {
                rs.last();
                int xnf = rs.getRow();
                this.xdtipocita = new String[xnf][3];
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    this.xdtipocita[i][0] = rs.getString(1);
                    this.xdtipocita[i][1] = rs.getString(2);
                    this.xdtipocita[i][2] = rs.getString(3);
                    this.xmodelo.addElement(rs.getString(2));
                    i++;
                }
                this.JLDatosCita.setModel(this.xmodelo);
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    private void initComponents() {
        this.JBGTipoEntidad = new ButtonGroup();
        this.JBGVoBo = new ButtonGroup();
        this.JBGTipoC = new ButtonGroup();
        this.JPPermisosMedicos = new JPanel();
        this.JPIDPermisos = new JPanel();
        this.JCBUnidadNegocio = new JComboBox();
        this.JCBSupervisor = new JComboBox();
        this.JCBCiudadCita = new JComboBox();
        this.JDCFechaCita = new JDateChooser();
        this.JPITipoEntidad = new JPanel();
        this.JRBEps = new JRadioButton();
        this.JRBMedPrepagada = new JRadioButton();
        this.JPIVoBo = new JPanel();
        this.JRBSi = new JRadioButton();
        this.JRBNo = new JRadioButton();
        this.JPITipoConsulta = new JPanel();
        this.JRBUrgente = new JRadioButton();
        this.JRBPrioritaria = new JRadioButton();
        this.JRBAmbulatoria = new JRadioButton();
        this.JPIDatosCita = new JPanel();
        this.JSPDatosCita = new JScrollPane();
        this.JLDatosCita = new JList();
        this.JCBEspecialidad = new JComboBox();
        this.JLBCual = new JLabel();
        this.JSPCual = new JScrollPane();
        this.JTPCual = new JTextPane();
        this.JSPObservaciones = new JScrollPane();
        this.JTPObservaciones = new JTextPane();
        this.JLBObservaciones = new JLabel();
        this.JLBN = new JLabel();
        this.JTFN = new JTextField();
        this.JTFEstado = new JTextField();
        setBorder(BorderFactory.createEtchedBorder(Color.blue, (Color) null));
        setName("jppermisos");
        setPreferredSize(new Dimension(815, 558));
        this.JPPermisosMedicos.setBorder(BorderFactory.createTitledBorder((Border) null, "PERMISOS MEDICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JPIDPermisos.setBorder(BorderFactory.createEtchedBorder());
        this.JCBUnidadNegocio.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadNegocio.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad de Negocio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBSupervisor.setFont(new Font("Arial", 1, 12));
        this.JCBSupervisor.setBorder(BorderFactory.createTitledBorder((Border) null, "Supervisor", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBCiudadCita.setFont(new Font("Arial", 1, 12));
        this.JCBCiudadCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Ciudad Cita", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaCita.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Cita", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JDCFechaCita.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaCita.setFont(new Font("Arial", 1, 12));
        this.JPITipoEntidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Entidad", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipoEntidad.add(this.JRBEps);
        this.JRBEps.setFont(new Font("Arial", 1, 12));
        this.JRBEps.setForeground(new Color(0, 0, 255));
        this.JRBEps.setText("Eps");
        this.JRBEps.addActionListener(new ActionListener() { // from class: Historia.JPPermisosMedicos.1
            public void actionPerformed(ActionEvent evt) {
                JPPermisosMedicos.this.JRBEpsActionPerformed(evt);
            }
        });
        this.JBGTipoEntidad.add(this.JRBMedPrepagada);
        this.JRBMedPrepagada.setFont(new Font("Arial", 1, 12));
        this.JRBMedPrepagada.setForeground(new Color(0, 0, 255));
        this.JRBMedPrepagada.setSelected(true);
        this.JRBMedPrepagada.setText("Med Prepagada");
        this.JRBMedPrepagada.addActionListener(new ActionListener() { // from class: Historia.JPPermisosMedicos.2
            public void actionPerformed(ActionEvent evt) {
                JPPermisosMedicos.this.JRBMedPrepagadaActionPerformed(evt);
            }
        });
        GroupLayout JPITipoEntidadLayout = new GroupLayout(this.JPITipoEntidad);
        this.JPITipoEntidad.setLayout(JPITipoEntidadLayout);
        JPITipoEntidadLayout.setHorizontalGroup(JPITipoEntidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoEntidadLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBEps).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBMedPrepagada)));
        JPITipoEntidadLayout.setVerticalGroup(JPITipoEntidadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoEntidadLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEps).addComponent(this.JRBMedPrepagada, -2, 30, -2)));
        this.JPIVoBo.setBorder(BorderFactory.createTitledBorder((Border) null, "VoBo", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGVoBo.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setForeground(new Color(0, 0, 255));
        this.JRBSi.setSelected(true);
        this.JRBSi.setText("Si");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JPPermisosMedicos.3
            public void actionPerformed(ActionEvent evt) {
                JPPermisosMedicos.this.JRBSiActionPerformed(evt);
            }
        });
        this.JBGVoBo.add(this.JRBNo);
        this.JRBNo.setFont(new Font("Arial", 1, 12));
        this.JRBNo.setForeground(new Color(0, 0, 255));
        this.JRBNo.setText("No");
        this.JRBNo.addActionListener(new ActionListener() { // from class: Historia.JPPermisosMedicos.4
            public void actionPerformed(ActionEvent evt) {
                JPPermisosMedicos.this.JRBNoActionPerformed(evt);
            }
        });
        GroupLayout JPIVoBoLayout = new GroupLayout(this.JPIVoBo);
        this.JPIVoBo.setLayout(JPIVoBoLayout);
        JPIVoBoLayout.setHorizontalGroup(JPIVoBoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIVoBoLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNo)));
        JPIVoBoLayout.setVerticalGroup(JPIVoBoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIVoBoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBSi).addComponent(this.JRBNo, -2, 30, -2)));
        this.JPITipoConsulta.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGTipoC.add(this.JRBUrgente);
        this.JRBUrgente.setFont(new Font("Arial", 1, 12));
        this.JRBUrgente.setForeground(new Color(0, 0, 255));
        this.JRBUrgente.setText("Urgente");
        this.JRBUrgente.addActionListener(new ActionListener() { // from class: Historia.JPPermisosMedicos.5
            public void actionPerformed(ActionEvent evt) {
                JPPermisosMedicos.this.JRBUrgenteActionPerformed(evt);
            }
        });
        this.JBGTipoC.add(this.JRBPrioritaria);
        this.JRBPrioritaria.setFont(new Font("Arial", 1, 12));
        this.JRBPrioritaria.setForeground(new Color(0, 0, 255));
        this.JRBPrioritaria.setText("Prioritaria");
        this.JRBPrioritaria.addActionListener(new ActionListener() { // from class: Historia.JPPermisosMedicos.6
            public void actionPerformed(ActionEvent evt) {
                JPPermisosMedicos.this.JRBPrioritariaActionPerformed(evt);
            }
        });
        this.JBGTipoC.add(this.JRBAmbulatoria);
        this.JRBAmbulatoria.setFont(new Font("Arial", 1, 12));
        this.JRBAmbulatoria.setForeground(new Color(0, 0, 255));
        this.JRBAmbulatoria.setSelected(true);
        this.JRBAmbulatoria.setText("Ambulatoria");
        this.JRBAmbulatoria.addActionListener(new ActionListener() { // from class: Historia.JPPermisosMedicos.7
            public void actionPerformed(ActionEvent evt) {
                JPPermisosMedicos.this.JRBAmbulatoriaActionPerformed(evt);
            }
        });
        GroupLayout JPITipoConsultaLayout = new GroupLayout(this.JPITipoConsulta);
        this.JPITipoConsulta.setLayout(JPITipoConsultaLayout);
        JPITipoConsultaLayout.setHorizontalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JRBAmbulatoria).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBUrgente).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPrioritaria).addGap(16, 16, 16)));
        JPITipoConsultaLayout.setVerticalGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAmbulatoria).addComponent(this.JRBUrgente).addComponent(this.JRBPrioritaria, -2, 30, -2)));
        GroupLayout JPIDPermisosLayout = new GroupLayout(this.JPIDPermisos);
        this.JPIDPermisos.setLayout(JPIDPermisosLayout);
        JPIDPermisosLayout.setHorizontalGroup(JPIDPermisosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPermisosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDPermisosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPermisosLayout.createSequentialGroup().addComponent(this.JCBUnidadNegocio, -2, 235, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSupervisor, -2, 302, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBCiudadCita, -2, 182, -2)).addGroup(JPIDPermisosLayout.createSequentialGroup().addComponent(this.JDCFechaCita, -2, 109, -2).addGap(30, 30, 30).addComponent(this.JPITipoEntidad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPITipoConsulta, -2, 263, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIVoBo, -2, -1, -2))).addContainerGap(-1, 32767)));
        JPIDPermisosLayout.setVerticalGroup(JPIDPermisosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPermisosLayout.createSequentialGroup().addGap(14, 14, 14).addGroup(JPIDPermisosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSupervisor, GroupLayout.Alignment.TRAILING).addComponent(this.JCBUnidadNegocio, GroupLayout.Alignment.TRAILING).addComponent(this.JCBCiudadCita)).addGroup(JPIDPermisosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDPermisosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDPermisosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIVoBo, -1, -1, 32767).addComponent(this.JPITipoConsulta, -1, -1, 32767).addComponent(this.JPITipoEntidad, -2, -1, -2)).addGap(25, 25, 25)).addGroup(JPIDPermisosLayout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.JDCFechaCita, -2, -1, -2).addContainerGap(-1, 32767)))));
        this.JPIDatosCita.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "DATOS CITA", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JLDatosCita.setFont(new Font("Arial", 1, 12));
        this.JLDatosCita.addListSelectionListener(new ListSelectionListener() { // from class: Historia.JPPermisosMedicos.8
            public void valueChanged(ListSelectionEvent evt) {
                JPPermisosMedicos.this.JLDatosCitaValueChanged(evt);
            }
        });
        this.JSPDatosCita.setViewportView(this.JLDatosCita);
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBCual.setFont(new Font("Arial", 1, 12));
        this.JLBCual.setForeground(new Color(0, 0, 255));
        this.JLBCual.setText("Cual (en caso de seleccionar otros)");
        this.JTPCual.setFont(new Font("Arial", 1, 12));
        this.JSPCual.setViewportView(this.JTPCual);
        this.JTPObservaciones.setFont(new Font("Arial", 1, 12));
        this.JSPObservaciones.setViewportView(this.JTPObservaciones);
        this.JLBObservaciones.setFont(new Font("Arial", 1, 12));
        this.JLBObservaciones.setForeground(new Color(0, 0, 255));
        this.JLBObservaciones.setText("Observaciones");
        GroupLayout JPIDatosCitaLayout = new GroupLayout(this.JPIDatosCita);
        this.JPIDatosCita.setLayout(JPIDatosCitaLayout);
        JPIDatosCitaLayout.setHorizontalGroup(JPIDatosCitaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCitaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCitaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPObservaciones).addGroup(JPIDatosCitaLayout.createSequentialGroup().addComponent(this.JSPDatosCita, -2, 321, -2).addGap(18, 18, 18).addGroup(JPIDatosCitaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPCual).addComponent(this.JCBEspecialidad, 0, -1, 32767).addComponent(this.JLBCual))).addComponent(this.JLBObservaciones)).addContainerGap()));
        JPIDatosCitaLayout.setVerticalGroup(JPIDatosCitaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCitaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosCitaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosCitaLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBCual).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPCual, -1, 58, 32767)).addComponent(this.JSPDatosCita, GroupLayout.Alignment.TRAILING, -2, 121, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBObservaciones).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPObservaciones, -1, 59, 32767).addContainerGap()));
        this.JLBN.setFont(new Font("Arial", 1, 18));
        this.JLBN.setForeground(Color.blue);
        this.JLBN.setText("N°");
        this.JTFN.setBackground(new Color(0, 51, 51));
        this.JTFN.setFont(new Font("Arial", 1, 18));
        this.JTFN.setForeground(Color.red);
        this.JTFN.setHorizontalAlignment(0);
        this.JTFN.setBorder((Border) null);
        this.JTFEstado.setBackground(new Color(0, 51, 51));
        this.JTFEstado.setFont(new Font("Arial", 1, 18));
        this.JTFEstado.setForeground(Color.red);
        this.JTFEstado.setHorizontalAlignment(0);
        this.JTFEstado.setBorder((Border) null);
        GroupLayout JPPermisosMedicosLayout = new GroupLayout(this.JPPermisosMedicos);
        this.JPPermisosMedicos.setLayout(JPPermisosMedicosLayout);
        JPPermisosMedicosLayout.setHorizontalGroup(JPPermisosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPermisosMedicosLayout.createSequentialGroup().addGroup(JPPermisosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPPermisosMedicosLayout.createSequentialGroup().addGap(271, 271, 271).addComponent(this.JLBN).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFN, -2, 93, -2).addGap(50, 50, 50).addComponent(this.JTFEstado)).addGroup(JPPermisosMedicosLayout.createSequentialGroup().addContainerGap().addGroup(JPPermisosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosCita, -1, -1, 32767).addComponent(this.JPIDPermisos, -1, -1, 32767)))).addContainerGap()));
        JPPermisosMedicosLayout.setVerticalGroup(JPPermisosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPermisosMedicosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDPermisos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JPIDatosCita, -2, -1, -2).addGap(18, 18, 18).addGroup(JPPermisosMedicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFEstado, -1, 27, 32767).addComponent(this.JTFN, -1, 27, 32767).addComponent(this.JLBN)).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPPermisosMedicos, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPPermisosMedicos, -2, -1, -2).addContainerGap(19, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEpsActionPerformed(ActionEvent evt) {
        this.xtipoentidad = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBMedPrepagadaActionPerformed(ActionEvent evt) {
        this.xtipoentidad = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xvobo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNoActionPerformed(ActionEvent evt) {
        this.xvobo = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLDatosCitaValueChanged(ListSelectionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBUrgenteActionPerformed(ActionEvent evt) {
        this.xtipoc = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPrioritariaActionPerformed(ActionEvent evt) {
        this.xtipoc = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAmbulatoriaActionPerformed(ActionEvent evt) {
        this.xtipoc = 0;
    }

    public void grabar() {
        String text;
        if (this.JTFN.getText().isEmpty()) {
            if (this.JCBUnidadNegocio.getSelectedIndex() != -1) {
                if (this.JCBSupervisor.getSelectedIndex() != -1) {
                    if (this.JCBCiudadCita.getSelectedIndex() != -1) {
                        if (this.JCBEspecialidad.getSelectedIndex() != -1) {
                            if (this.JLDatosCita.getSelectedIndex() != -1) {
                                this.xsql = "Insert into baseserver.h_permisosmedicos (Id_Usuario, Id_UnidadNegocio, Id_Supervisor, Id_Municipio, FechaCita, EsEps, EsTipoC,  Id_Especialidad, Observacion_G, Id_Profesional, Estado, Fecha, UsuarioS) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + this.xidunidad[this.JCBUnidadNegocio.getSelectedIndex()] + "','" + this.xidsupervisor[this.JCBSupervisor.getSelectedIndex()] + "','" + this.xidciudad[this.JCBCiudadCita.getSelectedIndex()] + "','" + this.xmetodo.formatoAMD.format(this.JDCFechaCita.getDate()) + "','" + this.xtipoentidad + "','" + this.xtipoc + "','" + this.xidespecialidad[this.JCBEspecialidad.getSelectedIndex()] + "','" + this.JTPObservaciones.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                String id = this.xconsultasbd.ejecutarSQLId(this.xsql);
                                int[] va = this.JLDatosCita.getSelectedIndices();
                                for (int y = 0; y < this.JLDatosCita.getSelectedIndices().length; y++) {
                                    ConsultasMySQL xct = new ConsultasMySQL();
                                    if (this.xdtipocita[new Integer(va[y]).intValue()][2].equals("1")) {
                                        text = this.JTPCual.getText();
                                    } else {
                                        text = "";
                                    }
                                    String xcual = text;
                                    this.xsql = "insert into h_detallepermisos (Id_Permiso, Id_tipoCita, Cual) values ('" + id + "','" + this.xdtipocita[new Integer(va[y]).intValue()][0] + "','" + xcual + "')";
                                    xct.ejecutarSQL(this.xsql);
                                    xct.cerrarConexionBd();
                                }
                                this.JTFN.setText(id);
                                this.JTFEstado.setText("ACTIVO");
                                this.xconsultasbd.cerrarConexionBd();
                                JOptionPane.showInternalMessageDialog(this, "Se guardó con éxito", "CONFIRMAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                                return;
                            }
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar por lo menos un tipo de cita", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                            this.JLDatosCita.requestFocus();
                            return;
                        }
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una especialidad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JCBEspecialidad.requestFocus();
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una ciudad", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JCBCiudadCita.requestFocus();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un supervisor", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBSupervisor.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una unidad de negocio", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBUnidadNegocio.requestFocus();
        }
    }

    public void nuevo() {
        this.JCBUnidadNegocio.setSelectedIndex(-1);
        this.JCBCiudadCita.setSelectedIndex(-1);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.JCBSupervisor.setSelectedIndex(-1);
        this.JDCFechaCita.setDate(this.xmetodo.getFechaActual());
        this.xtipoentidad = 1;
        this.JRBMedPrepagada.setSelected(true);
        this.xvobo = 0;
        this.JRBSi.setSelected(true);
        this.JLDatosCita.setSelectedIndex(0);
        this.JTPCual.setText((String) null);
        this.JTPObservaciones.setText((String) null);
        this.JTFN.setText("");
        this.JTFEstado.setText((String) null);
    }

    public void anular() {
        if (this.JTFN.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "No existe N° permiso Activo", "ANULAR PERMISO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        int xver = JOptionPane.showConfirmDialog(this, "Esta seguro de Anular ? ", "ANULACIÓN", 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (xver == 0) {
            this.xsql = "UPDATE  baseserver.h_permisosmedicos SET Estado = 1 WHERE(Id ='" + this.JTFN.getText() + "')";
            this.xconsultasbd.ejecutarSQL(this.xsql);
            this.xconsultasbd.cerrarConexionBd();
            this.JTFEstado.setText("ANULADO");
        }
    }

    public void imprimir() {
        if (!this.JTFN.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "PERMISOS", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            mparametros[0][0] = "npermiso";
            mparametros[0][1] = this.JTFN.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            if (n == 0) {
                this.xmetodo.PresentacionImpresora(this.xmetodo.getRutaRep() + "RPermisosMedicosN.jasper", mparametros);
            } else if (n == 1) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "RPermisosMedicosN", mparametros);
            }
        }
    }

    public void mBuscarPermiso(String id) {
        try {
            String sql = "SELECT g_tipounidadnegocio.Nbre AS NunidadNeg, supervisor.NSupervisor, g_municipio.Nbre AS NMunicipio, h_permisosmedicos.FechaCita, h_permisosmedicos.EsEps, h_permisosmedicos.EsTipoC, g_especialidad.Nbre, h_permisosmedicos.Observacion_G, h_permisosmedicos.Estado, h_permisosmedicos.Id FROM baseserver.h_permisosmedicos INNER JOIN baseserver.g_municipio  ON (h_permisosmedicos.Id_Municipio = g_municipio.Id) INNER JOIN baseserver.g_profesional  ON (h_permisosmedicos.Id_Profesional = g_profesional.Id_Persona) INNER JOIN baseserver.g_tipounidadnegocio  ON (h_permisosmedicos.Id_UnidadNegocio = g_tipounidadnegocio.Id) INNER JOIN baseserver.g_supervisor  ON (h_permisosmedicos.Id_Supervisor = g_supervisor.Id_Persona) INNER JOIN baseserver.profesional  ON (profesional.Id_Persona = g_profesional.Id_Persona) INNER JOIN baseserver.supervisor  ON (supervisor.Id_Persona = g_supervisor.Id_Persona) INNER JOIN baseserver.g_especialidad  ON (h_permisosmedicos.Id_Especialidad = g_especialidad.Id) WHERE (h_permisosmedicos.Id ='" + id + "') ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            rs.next();
            if (rs.getRow() != 0) {
                this.JCBUnidadNegocio.setSelectedItem(rs.getString(1));
                this.JCBSupervisor.setSelectedItem(rs.getString(2));
                this.JCBCiudadCita.setSelectedItem(rs.getString(3));
                this.JDCFechaCita.setDate(rs.getDate(4));
                this.JCBEspecialidad.setSelectedItem(rs.getString(7));
                this.JTPObservaciones.setText(rs.getString(8));
                if (rs.getInt(5) == 1) {
                    this.JRBMedPrepagada.setSelected(true);
                    this.xtipoentidad = 1;
                } else {
                    this.JRBEps.setSelected(true);
                    this.xtipoentidad = 0;
                }
                if (rs.getInt(6) == 0) {
                    this.JRBAmbulatoria.setSelected(true);
                    this.xtipoc = 0;
                } else if (rs.getInt(11) == 1) {
                    this.JRBUrgente.setSelected(true);
                    this.xtipoc = 1;
                } else {
                    this.JRBPrioritaria.setSelected(true);
                    this.xtipoc = 2;
                }
                if (rs.getInt(9) == 1) {
                    this.JTFEstado.setText("ANULADO");
                } else {
                    this.JTFEstado.setText("ACTIVO");
                }
                this.JTFN.setText(rs.getString(10));
                rs.close();
                this.xconsultasbd.cerrarConexionBd();
            }
        } catch (SQLException e) {
        }
    }

    public void buscar() {
        try {
            Component jIFConsultarInforOtros = new JIFConsultarInforOtros(this.xclase, getName());
            Principal.PanelPpal.add(jIFConsultarInforOtros, JLayeredPane.DEFAULT_LAYER);
            jIFConsultarInforOtros.setVisible(true);
            jIFConsultarInforOtros.setSelected(true);
        } catch (PropertyVetoException e) {
        }
    }
}
