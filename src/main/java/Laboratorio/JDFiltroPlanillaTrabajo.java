package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.LaboratorioDAOImpl;
import com.genoma.plus.dao.laboratorio.LaboratorioDAO;
import com.genoma.plus.jpa.dto.ParametroFiltroPlanillaTrabajoDTO;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JDFiltroPlanillaTrabajo.class */
public class JDFiltroPlanillaTrabajo extends JDialog {
    private ConsultasMySQL xct;
    private Metodos xmt;
    private JIFPlanillaTrabajo xjifplanilla;
    private String frmllamador;
    private String xsql;
    private String xidtiporesultado;
    private String filtroSede;
    private String xtipo;
    private String xcodigopro;
    private String xremitido;
    private String[] xidarea;
    public DefaultTableModel xmodelo1;
    public DefaultTableModel xmodelo2;
    private Object[] xdatos;
    private boolean xestado;
    private ParametroFiltroPlanillaTrabajoDTO FiltroPlanillaTrabajoDTO;
    private int xlprocesamiento;
    private LaboratorioDAO xImplLabotaorio;
    private String[] xIdMunicipio;
    private String[] xidServicios;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroL;
    private JButton JBTGrabar;
    private JButton JBTSalir;
    private JComboBox JCBMunicipio;
    private JComboBox JCBServicios;
    private JCheckBox JCHFiltroMunicipio;
    private JCheckBox JCHFiltroServicios;
    private JCheckBox JCHRemitido;
    private JDateChooser JDFechaF;
    private JDateChooser JDFechaI;
    private JPanel JPIDatosFiltro;
    private JPanel JPIFiltro_LP;
    private JPanel JPIModoFiltro;
    private JRadioButton JRBArea;
    public JRadioButton JRBConsultorio;
    private JRadioButton JRBExamen;
    public JRadioButton JRBLab_Externo;
    public JRadioButton JRBLaboratorio;
    private JRadioButton JRBTodas;
    private JScrollPane JSPDetalleExamen;
    public JTable JTBDetalleExamen;
    private JTextField JTFFiltroNombre;

    public JDFiltroPlanillaTrabajo(Frame parent, boolean modal, claseLab xclase) {
        super(parent, modal);
        this.xct = new ConsultasMySQL();
        this.xmt = new Metodos();
        this.xidtiporesultado = "0";
        this.filtroSede = "";
        this.xtipo = "0";
        this.xcodigopro = "";
        this.xremitido = "0";
        this.xestado = false;
        this.FiltroPlanillaTrabajoDTO = new ParametroFiltroPlanillaTrabajoDTO();
        this.xlprocesamiento = 0;
        initComponents();
        springStart();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/genomap.png")));
        if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO")) {
            setLocation(20, 20);
        } else {
            setLocationRelativeTo(null);
        }
        if (Principal.informacionIps.getAplicaFiltroSedePlanillaLaboratorio().booleanValue()) {
            this.filtroSede = "AND ingreso.Id_Sede=" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "\n";
        }
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v42, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroL = new ButtonGroup();
        this.JBTGrabar = new JButton();
        this.JBTSalir = new JButton();
        this.JPIDatosFiltro = new JPanel();
        this.JDFechaI = new JDateChooser();
        this.JDFechaF = new JDateChooser();
        this.JPIModoFiltro = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBArea = new JRadioButton();
        this.JRBExamen = new JRadioButton();
        this.JSPDetalleExamen = new JScrollPane();
        this.JTBDetalleExamen = new JTable();
        this.JTFFiltroNombre = new JTextField();
        this.JCHRemitido = new JCheckBox();
        this.JCBMunicipio = new JComboBox();
        this.JCHFiltroMunicipio = new JCheckBox();
        this.JCBServicios = new JComboBox();
        this.JCHFiltroServicios = new JCheckBox();
        this.JPIFiltro_LP = new JPanel();
        this.JRBLab_Externo = new JRadioButton();
        this.JRBLaboratorio = new JRadioButton();
        this.JRBConsultorio = new JRadioButton();
        setDefaultCloseOperation(2);
        setTitle("TIPO DE RESULTADO");
        setName("CapturarResultado");
        this.JBTGrabar.setFont(new Font("Arial", 1, 12));
        this.JBTGrabar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGrabar.setText("Cargar");
        this.JBTGrabar.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.1
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JBTGrabarActionPerformed(evt);
            }
        });
        this.JBTSalir.setFont(new Font("Arial", 1, 12));
        this.JBTSalir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Salir29x27.png")));
        this.JBTSalir.setText("Salir");
        this.JBTSalir.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.2
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JBTSalirActionPerformed(evt);
            }
        });
        this.JPIDatosFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS PARA FILTRO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JDFechaI.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Inicial", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaI.setDateFormatString("dd/MM/yyyy");
        this.JDFechaI.setFont(new Font("Arial", 1, 12));
        this.JDFechaI.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.3
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDFiltroPlanillaTrabajo.this.JDFechaIPropertyChange(evt);
            }
        });
        this.JDFechaF.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Final", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFechaF.setDateFormatString("dd/MM/yyyy");
        this.JDFechaF.setFont(new Font("Arial", 1, 12));
        this.JDFechaF.addPropertyChangeListener(new PropertyChangeListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.4
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JDFiltroPlanillaTrabajo.this.JDFechaFPropertyChange(evt);
            }
        });
        this.JPIModoFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "Modo de Búsqueda", 2, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGFiltro.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setSelected(true);
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.5
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBArea);
        this.JRBArea.setFont(new Font("Arial", 1, 12));
        this.JRBArea.setText("Area");
        this.JRBArea.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.6
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JRBAreaActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBExamen);
        this.JRBExamen.setFont(new Font("Arial", 1, 12));
        this.JRBExamen.setText("Exámen");
        this.JRBExamen.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.7
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JRBExamenActionPerformed(evt);
            }
        });
        GroupLayout JPIModoFiltroLayout = new GroupLayout(this.JPIModoFiltro);
        this.JPIModoFiltro.setLayout(JPIModoFiltroLayout);
        JPIModoFiltroLayout.setHorizontalGroup(JPIModoFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIModoFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBTodas).addGap(18, 18, 18).addComponent(this.JRBArea).addGap(18, 18, 18).addComponent(this.JRBExamen).addContainerGap(-1, 32767)));
        JPIModoFiltroLayout.setVerticalGroup(JPIModoFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIModoFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIModoFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas).addComponent(this.JRBArea).addComponent(this.JRBExamen, -2, 24, -2)).addGap(18, 18, 18)));
        this.JSPDetalleExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalleExamen.setFont(new Font("Arial", 1, 12));
        this.JTBDetalleExamen.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTBDetalleExamen.setRowHeight(25);
        this.JTBDetalleExamen.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalleExamen.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalleExamen.setSelectionMode(0);
        this.JTBDetalleExamen.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.8
            public void mouseClicked(MouseEvent evt) {
                JDFiltroPlanillaTrabajo.this.JTBDetalleExamenMouseClicked(evt);
            }
        });
        this.JTBDetalleExamen.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.9
            public void keyPressed(KeyEvent evt) {
                JDFiltroPlanillaTrabajo.this.JTBDetalleExamenKeyPressed(evt);
            }
        });
        this.JSPDetalleExamen.setViewportView(this.JTBDetalleExamen);
        this.JTFFiltroNombre.setFont(new Font("Arial", 1, 12));
        this.JTFFiltroNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtro Nombre Procedimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFFiltroNombre.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.10
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JTFFiltroNombreActionPerformed(evt);
            }
        });
        this.JTFFiltroNombre.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.11
            public void keyPressed(KeyEvent evt) {
                JDFiltroPlanillaTrabajo.this.JTFFiltroNombreKeyPressed(evt);
            }
        });
        this.JCHRemitido.setFont(new Font("Arial", 1, 12));
        this.JCHRemitido.setText("Remitido?");
        this.JCHRemitido.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.12
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JCHRemitidoActionPerformed(evt);
            }
        });
        this.JCBMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCBMunicipio.setBorder(BorderFactory.createTitledBorder((Border) null, "Municipio", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBMunicipio.addItemListener(new ItemListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.13
            public void itemStateChanged(ItemEvent evt) {
                JDFiltroPlanillaTrabajo.this.JCBMunicipioItemStateChanged(evt);
            }
        });
        this.JCHFiltroMunicipio.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroMunicipio.setText("Filtro Municipio?");
        this.JCHFiltroMunicipio.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.14
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JCHFiltroMunicipioActionPerformed(evt);
            }
        });
        this.JCBServicios.setFont(new Font("Arial", 1, 12));
        this.JCBServicios.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Atencion y/o Servicios", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBServicios.addItemListener(new ItemListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.15
            public void itemStateChanged(ItemEvent evt) {
                JDFiltroPlanillaTrabajo.this.JCBServiciosItemStateChanged(evt);
            }
        });
        this.JCHFiltroServicios.setFont(new Font("Arial", 1, 12));
        this.JCHFiltroServicios.setText("Filtro Servicio?");
        this.JCHFiltroServicios.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.16
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JCHFiltroServiciosActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosFiltroLayout = new GroupLayout(this.JPIDatosFiltro);
        this.JPIDatosFiltro.setLayout(JPIDatosFiltroLayout);
        JPIDatosFiltroLayout.setHorizontalGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addGap(10, 10, 10).addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleExamen, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addComponent(this.JDFechaI, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JDFechaF, -2, 120, -2).addGap(18, 18, 18).addComponent(this.JPIModoFiltro, -2, -1, -2).addGap(6, 6, 6).addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHRemitido).addComponent(this.JCHFiltroMunicipio).addComponent(this.JCHFiltroServicios))).addComponent(this.JTFFiltroNombre, -2, 626, -2)).addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCBMunicipio, -2, 276, -2)).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBServicios, -2, 276, -2))).addGap(10, 10, 10)))));
        JPIDatosFiltroLayout.setVerticalGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBMunicipio, -2, 50, -2)).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIModoFiltro, -2, -1, -2).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFechaF, -1, 62, 32767).addComponent(this.JDFechaI, -1, -1, 32767))).addGroup(JPIDatosFiltroLayout.createSequentialGroup().addComponent(this.JCHRemitido).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHFiltroMunicipio).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHFiltroServicios))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFiltroNombre, -2, 50, -2).addComponent(this.JCBServicios, -2, 50, -2)))).addGap(16, 16, 16).addComponent(this.JSPDetalleExamen, -1, 331, 32767).addContainerGap()));
        this.JPIFiltro_LP.setBorder(BorderFactory.createTitledBorder((Border) null, "LUGAR DE PROCESAMIENTO", 0, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.JBGFiltroL.add(this.JRBLab_Externo);
        this.JRBLab_Externo.setFont(new Font("Arial", 1, 12));
        this.JRBLab_Externo.setForeground(Color.blue);
        this.JRBLab_Externo.setText("Lab_Externo");
        this.JRBLab_Externo.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.17
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JRBLab_ExternoActionPerformed(evt);
            }
        });
        this.JBGFiltroL.add(this.JRBLaboratorio);
        this.JRBLaboratorio.setFont(new Font("Arial", 1, 12));
        this.JRBLaboratorio.setForeground(Color.blue);
        this.JRBLaboratorio.setSelected(true);
        this.JRBLaboratorio.setText("Laboratorio");
        this.JRBLaboratorio.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.18
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JRBLaboratorioActionPerformed(evt);
            }
        });
        this.JBGFiltroL.add(this.JRBConsultorio);
        this.JRBConsultorio.setFont(new Font("Arial", 1, 12));
        this.JRBConsultorio.setForeground(Color.blue);
        this.JRBConsultorio.setText("Consultorio");
        this.JRBConsultorio.addActionListener(new ActionListener() { // from class: Laboratorio.JDFiltroPlanillaTrabajo.19
            public void actionPerformed(ActionEvent evt) {
                JDFiltroPlanillaTrabajo.this.JRBConsultorioActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltro_LPLayout = new GroupLayout(this.JPIFiltro_LP);
        this.JPIFiltro_LP.setLayout(JPIFiltro_LPLayout);
        JPIFiltro_LPLayout.setHorizontalGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro_LPLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBLaboratorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBConsultorio).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBLab_Externo).addContainerGap(-1, 32767)));
        JPIFiltro_LPLayout.setVerticalGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltro_LPLayout.createSequentialGroup().addGroup(JPIFiltro_LPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBLaboratorio).addComponent(this.JRBConsultorio).addComponent(this.JRBLab_Externo)).addContainerGap(-1, 32767)));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JPIDatosFiltro, -2, -1, -2).addGroup(layout.createSequentialGroup().addComponent(this.JPIFiltro_LP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTGrabar, -2, 280, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTSalir, -2, 280, -2))).addGap(10, 10, 10)));
        layout.linkSize(0, new Component[]{this.JBTGrabar, this.JBTSalir});
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPIDatosFiltro, -1, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIFiltro_LP, -2, -1, -2)).addGroup(layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTSalir, -2, 60, -2).addComponent(this.JBTGrabar, -2, 60, -2)))).addGap(14, 14, 14)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTSalirActionPerformed(ActionEvent evt) {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaIPropertyChange(PropertyChangeEvent evt) {
        if (this.xestado) {
            this.FiltroPlanillaTrabajoDTO.setFechaInicial(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
            mCargarDatosModelo();
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaFPropertyChange(PropertyChangeEvent evt) {
        if (this.xestado) {
            this.FiltroPlanillaTrabajoDTO.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
            mCargarDatosModelo();
            mLlenarCombo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarActionPerformed(ActionEvent evt) {
        if (this.JRBTodas.isSelected()) {
            Principal.claselab.cargarPantalla("Planilla Trabajo", this.FiltroPlanillaTrabajoDTO, this.xlprocesamiento);
            dispose();
            return;
        }
        if (this.JRBArea.isSelected()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTBDetalleExamen, 2)) {
                this.xcodigopro = "";
                for (int x = 0; x < this.JTBDetalleExamen.getRowCount(); x++) {
                    if (Boolean.valueOf(this.xmodelo1.getValueAt(x, 2).toString()).booleanValue()) {
                        this.xcodigopro += "," + this.xmodelo1.getValueAt(x, 0).toString();
                    }
                }
                this.FiltroPlanillaTrabajoDTO.setProcedimientoarea(this.xcodigopro.substring(1, this.xcodigopro.length()));
                Principal.claselab.cargarPantalla("Planilla Trabajo", this.FiltroPlanillaTrabajoDTO, this.xlprocesamiento);
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un exámen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.JRBExamen.isSelected()) {
            if (this.xmt.mVerificarDatosTablaTrue(this.JTBDetalleExamen, 3)) {
                this.xcodigopro = "";
                for (int x2 = 0; x2 < this.JTBDetalleExamen.getRowCount(); x2++) {
                    if (Boolean.valueOf(this.xmodelo1.getValueAt(x2, 3).toString()).booleanValue()) {
                        this.xcodigopro += "," + this.xmodelo1.getValueAt(x2, 0).toString();
                    }
                }
                this.FiltroPlanillaTrabajoDTO.setProcedimientoarea(this.xcodigopro.substring(1, this.xcodigopro.length()));
                Principal.claselab.cargarPantalla("Planilla Trabajo", this.FiltroPlanillaTrabajoDTO, this.xlprocesamiento);
                dispose();
                return;
            }
            JOptionPane.showMessageDialog(this, "Debe seleccionar un exámen", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        this.xtipo = "0";
        this.FiltroPlanillaTrabajoDTO.setFiltro(this.xtipo);
        mIniciar_Componentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAreaActionPerformed(ActionEvent evt) {
        this.xtipo = "1";
        this.FiltroPlanillaTrabajoDTO.setFiltro(this.xtipo);
        this.JRBArea.requestFocus();
        mIniciar_Componentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBExamenActionPerformed(ActionEvent evt) {
        this.xtipo = "2";
        this.FiltroPlanillaTrabajoDTO.setFiltro(this.xtipo);
        this.JTFFiltroNombre.requestFocus();
        mIniciar_Componentes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRemitidoActionPerformed(ActionEvent evt) {
        if (this.JCHRemitido.isSelected()) {
            this.xremitido = "1";
            this.FiltroPlanillaTrabajoDTO.setEsRemitido(this.xremitido);
        } else {
            this.xremitido = "0";
            this.FiltroPlanillaTrabajoDTO.setEsRemitido(this.xremitido);
        }
        mCargarDatosModelo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroNombreKeyPressed(KeyEvent evt) {
        if (this.xtipo.equals("0") || this.xtipo.equals("2")) {
            mCargarDatosModelo();
        } else {
            mCargarDatosModelo_Area();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleExamenMouseClicked(MouseEvent evt) {
        if (this.JTBDetalleExamen.getSelectedRow() != -1 && this.JTBDetalleExamen.getSelectedColumn() == 1) {
            mSeleccionarProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleExamenKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 32 && this.JTBDetalleExamen.getSelectedColumn() == 1 && this.JTBDetalleExamen.getSelectedRow() != -1) {
            mSeleccionarProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLab_ExternoActionPerformed(ActionEvent evt) {
        this.xlprocesamiento = 2;
        this.FiltroPlanillaTrabajoDTO.setLugarProcesamiento(this.xlprocesamiento + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBLaboratorioActionPerformed(ActionEvent evt) {
        this.xlprocesamiento = 0;
        this.FiltroPlanillaTrabajoDTO.setLugarProcesamiento(this.xlprocesamiento + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBConsultorioActionPerformed(ActionEvent evt) {
        this.xlprocesamiento = 1;
        this.FiltroPlanillaTrabajoDTO.setLugarProcesamiento(this.xlprocesamiento + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFiltroNombreActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroMunicipioActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroMunicipio.isSelected()) {
            this.FiltroPlanillaTrabajoDTO.setAplicaFiltroMunicipio("1");
        } else {
            this.FiltroPlanillaTrabajoDTO.setAplicaFiltroMunicipio("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBMunicipioItemStateChanged(ItemEvent evt) {
        if (this.JCBMunicipio.getSelectedIndex() != -1 && this.xestado) {
            this.FiltroPlanillaTrabajoDTO.setMunicipio(this.xIdMunicipio[this.JCBMunicipio.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBServiciosItemStateChanged(ItemEvent evt) {
        if (this.JCBServicios.getSelectedIndex() != -1 && this.xestado) {
            this.FiltroPlanillaTrabajoDTO.setServicio(this.xidServicios[this.JCBServicios.getSelectedIndex()]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroServiciosActionPerformed(ActionEvent evt) {
        if (this.JCHFiltroServicios.isSelected()) {
            this.FiltroPlanillaTrabajoDTO.setAplicaFiltroServicio("1");
        } else {
            this.FiltroPlanillaTrabajoDTO.setAplicaFiltroServicio("0");
        }
    }

    private void mSeleccionarProcedimiento() {
        if (this.xtipo.equals("0") || this.xtipo.equals("2")) {
            if (this.JTBDetalleExamen.getRowCount() != -1 && this.JTBDetalleExamen.getSelectedRow() != -1) {
                if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleExamen.getSelectedRow(), 3).toString()).booleanValue()) {
                    this.xmodelo1.setValueAt(false, this.JTBDetalleExamen.getSelectedRow(), 3);
                    return;
                } else {
                    this.xmodelo1.setValueAt(true, this.JTBDetalleExamen.getSelectedRow(), 3);
                    return;
                }
            }
            return;
        }
        if (this.JTBDetalleExamen.getRowCount() != -1 && this.JTBDetalleExamen.getSelectedRow() != -1) {
            if (Boolean.valueOf(this.xmodelo1.getValueAt(this.JTBDetalleExamen.getSelectedRow(), 2).toString()).booleanValue()) {
                this.xmodelo1.setValueAt(false, this.JTBDetalleExamen.getSelectedRow(), 2);
            } else {
                this.xmodelo1.setValueAt(true, this.JTBDetalleExamen.getSelectedRow(), 2);
            }
        }
    }

    private void mIniciar_Componentes() {
        if (this.xtipo.equals("0") || this.xtipo.equals("2")) {
            this.JTFFiltroNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtrar por nombre de procedimiento", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
            this.JSPDetalleExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "EXÁMEN", 2, 0, new Font("Arial", 1, 14), Color.red));
            mCargarDatosModelo();
        } else {
            this.JTFFiltroNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Filtrar por nombre de aréa", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
            this.JSPDetalleExamen.setBorder(BorderFactory.createTitledBorder((Border) null, "ARÉA", 2, 0, new Font("Arial", 1, 14), Color.red));
            mCargarDatosModelo_Area();
        }
    }

    private void springStart() {
        this.xImplLabotaorio = (LaboratorioDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("laboratorioDAOImpl");
    }

    private void mNuevo() {
        this.JDFechaI.setDate(this.xmt.getFechaActual());
        this.JDFechaF.setDate(this.xmt.getFechaActual());
        this.xremitido = "0";
        this.JRBTodas.setSelected(true);
        this.FiltroPlanillaTrabajoDTO.setFiltro(this.xtipo);
        this.FiltroPlanillaTrabajoDTO.setFechaInicial(this.xmt.formatoAMD.format(this.JDFechaI.getDate()));
        this.FiltroPlanillaTrabajoDTO.setFechaFinal(this.xmt.formatoAMD.format(this.JDFechaF.getDate()));
        this.FiltroPlanillaTrabajoDTO.setEsRemitido(this.xremitido);
        this.FiltroPlanillaTrabajoDTO.setLugarProcesamiento("0");
        this.FiltroPlanillaTrabajoDTO.setMunicipio("0");
        this.FiltroPlanillaTrabajoDTO.setAplicaFiltroMunicipio("0");
        this.FiltroPlanillaTrabajoDTO.setAplicaFiltroServicio("0");
        this.FiltroPlanillaTrabajoDTO.setServicio("0");
        mCargarDatosModelo();
        mLlenarCombo();
        this.xestado = true;
    }

    private void mLlenarCombo() {
        this.xestado = false;
        this.JCBMunicipio.removeAllItems();
        List<Object[]> list = this.xImplLabotaorio.listRecepcionesMunicipio(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xIdMunicipio = new String[list.size()];
        for (int x = 0; x < list.size(); x++) {
            this.xIdMunicipio[x] = list.get(x)[0].toString();
            this.JCBMunicipio.addItem(list.get(x)[1].toString());
        }
        if (this.xIdMunicipio.length > 1) {
            this.JCBMunicipio.setSelectedIndex(-1);
        }
        this.JCBServicios.removeAllItems();
        List<Object[]> listservicios = this.xImplLabotaorio.listRecepcionesServicios(this.xmt.formatoAMD1.format(this.JDFechaI.getDate()), this.xmt.formatoAMD1.format(this.JDFechaF.getDate()));
        this.xidServicios = new String[listservicios.size()];
        for (int x2 = 0; x2 < listservicios.size(); x2++) {
            this.xidServicios[x2] = listservicios.get(x2)[0].toString();
            this.JCBServicios.addItem(listservicios.get(x2)[1].toString());
        }
        if (this.xidServicios.length > 1) {
            this.JCBServicios.setSelectedIndex(-1);
        }
        this.xestado = true;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Abre.", "Cargar"}) { // from class: Laboratorio.JDFiltroPlanillaTrabajo.20
            Class[] types = {Long.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleExamen.setModel(this.xmodelo1);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalleExamen.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTBDetalleExamen.getColumnModel().getColumn(3).setPreferredWidth(10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDetalle_Area() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "Cargar"}) { // from class: Laboratorio.JDFiltroPlanillaTrabajo.21
            Class[] types = {Long.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTBDetalleExamen.setModel(this.xmodelo1);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTBDetalleExamen.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.JTBDetalleExamen.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    private void mCargarDatosModelo() {
        try {
            if (this.JTFFiltroNombre.getText().isEmpty()) {
                this.xsql = "SELECT `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, `g_procedimiento`.`Ref` FROM `l_detallerecepcion` INNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas`  ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`) INNER JOIN  `l_recepcion`   ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `f_ordenes` ON (`f_ordenes`.`Id`=`l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON (`ingreso`.`Id`= `f_ordenes`.`Id_Ingreso`)\nWHERE ( DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_recepcion.LProcesamiento='" + this.xlprocesamiento + "' AND `l_recepcion`.`Estado`=0 and `g_procedimiento`.`EsRemitido`='" + this.xremitido + "'\n" + this.filtroSede + ")\nGROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
            } else {
                this.xsql = "SELECT `g_procedimiento`.`Id` , `g_procedimiento`.`Nbre`, `g_procedimiento`.`Ref` FROM `l_detallerecepcion` INNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas`  ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`) INNER JOIN  `l_recepcion`   ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `f_ordenes` ON (`f_ordenes`.`Id`=`l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON (`ingreso`.`Id`= `f_ordenes`.`Id_Ingreso`)\nWHERE ( DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_recepcion.LProcesamiento='" + this.xlprocesamiento + "' AND `l_recepcion`.`Estado`=0 and `g_procedimiento`.`EsRemitido`='" + this.xremitido + "' and `g_procedimiento`.`Nbre` like'" + this.JTFFiltroNombre.getText() + "%'\n" + this.filtroSede + ")\nGROUP BY `g_procedimiento`.`Id` ORDER BY `g_procedimiento`.`Nbre` ASC ";
            }
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearModeloDetalle();
            if (xrs.next()) {
                int x = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(xrs.getString(3), x, 2);
                    this.xmodelo1.setValueAt(false, x, 3);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDFiltroPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarDatosModelo_Area() {
        try {
            if (this.JTFFiltroNombre.getText().isEmpty()) {
                this.xsql = "SELECT l_areas.`Id`, l_areas.`Nbre`   FROM `l_detallerecepcion` INNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas`  ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`) INNER JOIN  `l_recepcion`   ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `f_ordenes` ON (`f_ordenes`.`Id`=`l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON (`ingreso`.`Id`= `f_ordenes`.`Id_Ingreso`)\nWHERE ( DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_recepcion.LProcesamiento='" + this.xlprocesamiento + "' AND `l_recepcion`.`Estado`=0 and `g_procedimiento`.`EsRemitido`='" + this.xremitido + "'\n" + this.filtroSede + ")\nGROUP BY  l_areas.`Id` ORDER BY  l_areas.`Nbre` ASC ";
            } else {
                this.xsql = "SELECT l_areas.`Id`, l_areas.`Nbre`  FROM `l_detallerecepcion` INNER JOIN  `g_procedimiento`  ON (`l_detallerecepcion`.`Id_Procedim` = `g_procedimiento`.`Id`)\nINNER JOIN  `l_areas`  ON (`l_areas`.`Id` = `g_procedimiento`.`Id_Area`) INNER JOIN  `l_recepcion`   ON (`l_detallerecepcion`.`Id_Recepcion` = `l_recepcion`.`Id`)\nINNER JOIN `f_ordenes` ON (`f_ordenes`.`Id`=`l_recepcion`.`Id_OrdenFacturac`)\nINNER JOIN ingreso ON (`ingreso`.`Id`= `f_ordenes`.`Id_Ingreso`)\nWHERE ( DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') >='" + this.xmt.formatoAMD.format(this.JDFechaI.getDate()) + "' AND  DATE_FORMAT(`l_recepcion`.`FechaRecep`, '%Y/%m/%d') <='" + this.xmt.formatoAMD.format(this.JDFechaF.getDate()) + "' AND l_recepcion.LProcesamiento='" + this.xlprocesamiento + "' AND `l_recepcion`.`Estado`=0 and `g_procedimiento`.`EsRemitido`='" + this.xremitido + "' and `g_procedimiento`.`Nbre` like'" + this.JTFFiltroNombre.getText() + "%'\n" + this.filtroSede + ")\nGROUP BY  l_areas.`Id` ORDER BY  l_areas.`Nbre` ASC ";
            }
            ResultSet xrs = this.xct.traerRs(this.xsql);
            mCrearModeloDetalle_Area();
            if (xrs.next()) {
                int x = 0;
                xrs.beforeFirst();
                while (xrs.next()) {
                    this.xmodelo1.addRow(this.xdatos);
                    this.xmodelo1.setValueAt(xrs.getString(1), x, 0);
                    this.xmodelo1.setValueAt(xrs.getString(2), x, 1);
                    this.xmodelo1.setValueAt(false, x, 2);
                    x++;
                }
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JDFiltroPlanillaTrabajo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
