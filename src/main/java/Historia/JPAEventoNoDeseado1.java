package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAEventoNoDeseado1.class */
public class JPAEventoNoDeseado1 extends JPanel {
    private int lleno;
    private String[] xidclaseevento;
    private String[] xidparentesco;
    private String[] xidtipoactividad;
    private String[] xiddetalleactividad;
    private String[] xidparteafecta;
    private String[] xidtipolesion;
    private String[] xidunidadnegocio;
    private String[] xidsupervisor;
    private String[] xidtrabajador;
    private String[][] xidtipoevento;
    private String[][] xidtipoempresa;
    private clasesHistoriaCE xclase;
    private ButtonGroup JBGAlcohol;
    private ButtonGroup JBGEstaTrabajador;
    private ButtonGroup JBGViolencia;
    private JComboBox JCBClaseEvento;
    private JComboBox JCBDetalleTipoActividad;
    public JComboBox JCBNombreTrabajador;
    private JComboBox JCBPCuerpoAfectada;
    private JComboBox JCBParentesco;
    private JComboBox JCBSupervisor;
    private JComboBox JCBTipoActividad;
    private JComboBox JCBTipoEmpresaEvento;
    public JComboBox JCBTipoEvento;
    private JComboBox JCBTipoLesion;
    private JComboBox JCBUnidadNegocio;
    private JDateChooser JDFecha;
    private JLabel JLBActividadEvento;
    private JLabel JLBClaseEvento;
    private JLabel JLBDescripcionPAfectadas;
    private JLabel JLBDescripcionTratamiento;
    private JLabel JLBDetalleEvento;
    private JLabel JLBFechaEvento;
    private JLabel JLBHoraEvento;
    private JLabel JLBNDias;
    private JLabel JLBNEmpresaContr;
    private JLabel JLBNombreTrabajador;
    private JLabel JLBPCuerpoAfectada;
    private JLabel JLBParentesco;
    private JLabel JLBSupervisor;
    private JLabel JLBTipoEmpresaEvento;
    private JLabel JLBTipoEvento;
    private JLabel JLBTipoLesion;
    private JLabel JLBUDetalleTipoActividad;
    private JLabel JLBUTipoActividad;
    private JLabel JLBUnidadNegocio;
    private JPanel JPIDEmpresa;
    private JPanel JPIDParentesco;
    private JPanel JPIDetalleEvento;
    private JPanel JPIDetalleInc;
    private JPanel JPITipoEmpresa;
    private JRadioButton JRBAlcoholNo;
    private JRadioButton JRBAlcoholSi;
    private JRadioButton JRBEstaNo;
    private JRadioButton JRBEstaSi;
    private JRadioButton JRBViolenciaNo;
    private JRadioButton JRBViolenciaSi;
    private JScrollPane JSPActividadEvento;
    private JScrollPane JSPDescripcionPAfectadas;
    private JScrollPane JSPDescripcionTratamiento;
    private JScrollPane JSPDetalleEvento;
    private JSpinner JSPNDias;
    private JScrollPane JSPSitioEvento;
    private JTextField JTFEstado;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFFNEmpresaContr;
    private JTextField JTFN;
    private JTextPane JTPActividadEvento;
    private JTextPane JTPDescripcionPAfectadas;
    private JTextPane JTPDescripcionTratamiento;
    private JTextPane JTPDetalleEventi;
    private JTabbedPane JTPDetalleEvento;
    private JTextPane JTPSitioEvento;
    private JPanel jPanel1;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private SimpleDateFormat xfhora = new SimpleDateFormat("HH:mm:ss");
    private GregorianCalendar xhoy = new GregorianCalendar();
    private int xestrabajando = 0;
    private int xesalcohol = 0;
    private int xesviolencia = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPAEventoNoDeseado1(clasesHistoriaCE xclase) {
        this.lleno = 0;
        initComponents();
        this.xclase = xclase;
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setValue(this.xmetodo.getFechaActual());
        this.xidtipoevento = this.xconsultasbd.llenarComboyLista("SELECT Id, Nbre, EsTrabajador FROM e_tipoevento WHERE (Estado =0)", this.xidtipoevento, this.JCBTipoEvento, 3);
        this.JCBTipoEvento.setSelectedIndex(-1);
        this.xidclaseevento = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM e_claseevento WHERE (Estado =0) ORDER BY Nbre ASC", this.xidclaseevento, this.JCBClaseEvento);
        this.xidtrabajador = this.xconsultasbd.llenarCombo("SELECT g_usuario.Id_persona, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS trabajador FROM g_usuario INNER JOIN g_persona  ON (g_usuario.Id_persona = g_persona.Id) WHERE g_usuario.Estado=0 and g_usuario.Id_TipoAfiliado=1 order by trabajador", this.xidtrabajador, this.JCBNombreTrabajador);
        this.JCBNombreTrabajador.setSelectedIndex(0);
        this.xidtipoempresa = this.xconsultasbd.llenarComboyLista("SELECT Id, Nbre, ExigeNit FROM g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBTipoEmpresaEvento, 3);
        this.JCBTipoEmpresaEvento.setSelectedIndex(-1);
        this.xidparentesco = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_parentesco WHERE Estado=0 ORDER BY Nbre ASC", this.xidparentesco, this.JCBParentesco);
        this.JCBParentesco.setSelectedIndex(-1);
        this.xidtipoactividad = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM e_tipoactividad WHERE (Estado =0)", this.xidtipoactividad, this.JCBTipoActividad);
        this.JCBTipoActividad.setSelectedIndex(-1);
        this.xidparteafecta = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM e_parteafectada WHERE (Estado =0) ORDER BY Nbre ASC", this.xidparteafecta, this.JCBPCuerpoAfectada);
        this.JCBPCuerpoAfectada.setSelectedIndex(-1);
        this.xidtipolesion = this.xconsultasbd.llenarCombo("SELECT  Id , Nbre FROM e_tipolesion WHERE (Estado =0)", this.xidtipolesion, this.JCBTipoLesion);
        this.JCBTipoLesion.setSelectedIndex(-1);
        this.xidunidadnegocio = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM g_tipounidadnegocio where Estado =0 ORDER BY Nbre ASC", this.xidunidadnegocio, this.JCBUnidadNegocio);
        this.JCBUnidadNegocio.setSelectedItem("No Aplica");
        this.xidsupervisor = this.xconsultasbd.llenarCombo("SELECT g_supervisor.Id_Persona, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS supervisor, g_supervisor.Id_TipoEmpresa  FROM g_supervisor INNER JOIN g_persona ON (g_supervisor.Id_Persona = g_persona.Id) ORDER BY supervisor", this.xidsupervisor, this.JCBSupervisor);
        this.JCBSupervisor.setSelectedItem("----");
        this.xconsultasbd.cerrarConexionBd();
        this.lleno = 1;
    }

    private void initComponents() {
        this.JBGAlcohol = new ButtonGroup();
        this.JBGEstaTrabajador = new ButtonGroup();
        this.JBGViolencia = new ButtonGroup();
        this.JPIDetalleEvento = new JPanel();
        this.JTPDetalleEvento = new JTabbedPane();
        this.JPITipoEmpresa = new JPanel();
        this.jPanel1 = new JPanel();
        this.JLBTipoEvento = new JLabel();
        this.JCBTipoEvento = new JComboBox();
        this.JLBClaseEvento = new JLabel();
        this.JCBClaseEvento = new JComboBox();
        this.JLBFechaEvento = new JLabel();
        this.JLBHoraEvento = new JLabel();
        this.JDFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JLBNDias = new JLabel();
        this.JSPNDias = new JSpinner();
        this.JPIDEmpresa = new JPanel();
        this.JLBTipoEmpresaEvento = new JLabel();
        this.JCBTipoEmpresaEvento = new JComboBox();
        this.JLBNEmpresaContr = new JLabel();
        this.JTFFNEmpresaContr = new JFormattedTextField();
        this.JPIDParentesco = new JPanel();
        this.JLBParentesco = new JLabel();
        this.JCBParentesco = new JComboBox();
        this.JLBNombreTrabajador = new JLabel();
        this.JCBNombreTrabajador = new JComboBox();
        this.jPanel4 = new JPanel();
        this.JRBEstaSi = new JRadioButton();
        this.JRBEstaNo = new JRadioButton();
        this.jPanel5 = new JPanel();
        this.JLBUnidadNegocio = new JLabel();
        this.JCBUnidadNegocio = new JComboBox();
        this.JLBSupervisor = new JLabel();
        this.JCBSupervisor = new JComboBox();
        this.jPanel6 = new JPanel();
        this.JLBUTipoActividad = new JLabel();
        this.JCBTipoActividad = new JComboBox();
        this.JLBUDetalleTipoActividad = new JLabel();
        this.JCBDetalleTipoActividad = new JComboBox();
        this.jPanel7 = new JPanel();
        this.JSPSitioEvento = new JScrollPane();
        this.JTPSitioEvento = new JTextPane();
        this.JPIDetalleInc = new JPanel();
        this.JLBPCuerpoAfectada = new JLabel();
        this.JCBPCuerpoAfectada = new JComboBox();
        this.JLBActividadEvento = new JLabel();
        this.JSPActividadEvento = new JScrollPane();
        this.JTPActividadEvento = new JTextPane();
        this.JLBDetalleEvento = new JLabel();
        this.JSPDetalleEvento = new JScrollPane();
        this.JTPDetalleEventi = new JTextPane();
        this.JLBDescripcionPAfectadas = new JLabel();
        this.JSPDescripcionPAfectadas = new JScrollPane();
        this.JTPDescripcionPAfectadas = new JTextPane();
        this.JLBDescripcionTratamiento = new JLabel();
        this.JSPDescripcionTratamiento = new JScrollPane();
        this.JTPDescripcionTratamiento = new JTextPane();
        this.JLBTipoLesion = new JLabel();
        this.JCBTipoLesion = new JComboBox();
        this.jPanel8 = new JPanel();
        this.JRBAlcoholSi = new JRadioButton();
        this.JRBAlcoholNo = new JRadioButton();
        this.jPanel9 = new JPanel();
        this.JRBViolenciaSi = new JRadioButton();
        this.JRBViolenciaNo = new JRadioButton();
        this.JTFN = new JTextField();
        this.JTFEstado = new JTextField();
        setBorder(BorderFactory.createEtchedBorder(0, Color.blue, (Color) null));
        setName("jpaeventonodeseado");
        this.JPIDetalleEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "EVENTO NO DESEADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPDetalleEvento.setForeground(new Color(0, 102, 0));
        this.JTPDetalleEvento.setFont(new Font("Arial", 1, 14));
        this.JPITipoEmpresa.setBorder(BorderFactory.createEtchedBorder(0, Color.white, (Color) null));
        this.JPITipoEmpresa.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "EVENTO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JLBTipoEvento.setFont(new Font("Arial", 1, 12));
        this.JLBTipoEvento.setForeground(Color.blue);
        this.JLBTipoEvento.setHorizontalAlignment(2);
        this.JLBTipoEvento.setText("Tipo");
        this.JCBTipoEvento.setFont(new Font("Arial", 1, 12));
        this.JLBClaseEvento.setFont(new Font("Arial", 1, 12));
        this.JLBClaseEvento.setForeground(Color.blue);
        this.JLBClaseEvento.setHorizontalAlignment(2);
        this.JLBClaseEvento.setText("Clase");
        this.JCBClaseEvento.setFont(new Font("Arial", 1, 12));
        this.JLBFechaEvento.setFont(new Font("Arial", 1, 12));
        this.JLBFechaEvento.setForeground(Color.blue);
        this.JLBFechaEvento.setHorizontalAlignment(0);
        this.JLBFechaEvento.setText("Fecha ");
        this.JLBHoraEvento.setFont(new Font("Arial", 1, 12));
        this.JLBHoraEvento.setForeground(Color.blue);
        this.JLBHoraEvento.setHorizontalAlignment(0);
        this.JLBHoraEvento.setText("Hora(HH-mm AM/PM)");
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm a"))));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JLBNDias.setFont(new Font("Arial", 1, 12));
        this.JLBNDias.setForeground(Color.blue);
        this.JLBNDias.setHorizontalAlignment(0);
        this.JLBNDias.setText("N° Días");
        this.JSPNDias.setFont(new Font("Arial", 1, 12));
        this.JSPNDias.setModel(new SpinnerNumberModel(0, 0, 60, 1));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBTipoEvento, -2, 54, -2).addComponent(this.JCBTipoEvento, -2, 185, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBClaseEvento, -2, 40, -2).addComponent(this.JCBClaseEvento, -2, 219, -2)).addGap(6, 6, 6).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPNDias).addComponent(this.JLBNDias, -1, -1, 32767)).addGap(27, 27, 27).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLBFechaEvento).addGap(81, 81, 81)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JDFecha, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBHoraEvento).addComponent(this.JTFFHora, -2, 71, -2)).addGap(59, 59, 59)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JLBTipoEvento).addComponent(this.JLBClaseEvento)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBTipoEvento, -2, 25, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBClaseEvento, -2, 25, -2).addComponent(this.JSPNDias, -2, 25, -2)))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBFechaEvento).addComponent(this.JLBNDias)).addGap(31, 31, 31))).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JLBHoraEvento).addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JDFecha, -2, 25, -2).addComponent(this.JTFFHora, -1, 26, 32767)))).addContainerGap()));
        this.JPIDEmpresa.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "EMPRESA", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JLBTipoEmpresaEvento.setFont(new Font("Arial", 1, 12));
        this.JLBTipoEmpresaEvento.setForeground(Color.blue);
        this.JLBTipoEmpresaEvento.setHorizontalAlignment(2);
        this.JLBTipoEmpresaEvento.setText("Tipo");
        this.JCBTipoEmpresaEvento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresaEvento.addItemListener(new ItemListener() { // from class: Historia.JPAEventoNoDeseado1.1
            public void itemStateChanged(ItemEvent evt) {
                JPAEventoNoDeseado1.this.JCBTipoEmpresaEventoItemStateChanged(evt);
            }
        });
        this.JLBNEmpresaContr.setFont(new Font("Arial", 1, 12));
        this.JLBNEmpresaContr.setForeground(Color.blue);
        this.JLBNEmpresaContr.setHorizontalAlignment(0);
        this.JLBNEmpresaContr.setText("Nombre Empresa (Solo en caso de ser Contratista o Particular");
        this.JTFFNEmpresaContr.setEditable(false);
        this.JTFFNEmpresaContr.setHorizontalAlignment(11);
        this.JTFFNEmpresaContr.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDEmpresaLayout = new GroupLayout(this.JPIDEmpresa);
        this.JPIDEmpresa.setLayout(JPIDEmpresaLayout);
        JPIDEmpresaLayout.setHorizontalGroup(JPIDEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEmpresaLayout.createSequentialGroup().addContainerGap().addGroup(JPIDEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEmpresaLayout.createSequentialGroup().addComponent(this.JLBTipoEmpresaEvento, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JLBNEmpresaContr).addGap(122, 122, 122)).addGroup(JPIDEmpresaLayout.createSequentialGroup().addComponent(this.JCBTipoEmpresaEvento, -2, 242, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNEmpresaContr).addContainerGap()))));
        JPIDEmpresaLayout.setVerticalGroup(JPIDEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEmpresaLayout.createSequentialGroup().addGroup(JPIDEmpresaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBTipoEmpresaEvento).addComponent(this.JLBNEmpresaContr)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDEmpresaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoEmpresaEvento, -2, 25, -2).addComponent(this.JTFFNEmpresaContr, -2, 25, -2))));
        this.JPIDParentesco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "PARENTESCO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JPIDParentesco.setForeground(new Color(153, 0, 0));
        this.JLBParentesco.setFont(new Font("Arial", 1, 12));
        this.JLBParentesco.setForeground(Color.blue);
        this.JLBParentesco.setHorizontalAlignment(2);
        this.JLBParentesco.setText("Parentesco (Relacion con el Trabajador)");
        this.JCBParentesco.setFont(new Font("Arial", 1, 12));
        this.JCBParentesco.setEnabled(false);
        this.JLBNombreTrabajador.setFont(new Font("Arial", 1, 12));
        this.JLBNombreTrabajador.setForeground(Color.blue);
        this.JLBNombreTrabajador.setHorizontalAlignment(2);
        this.JLBNombreTrabajador.setText("Nombre del trabajador");
        this.JCBNombreTrabajador.setFont(new Font("Arial", 1, 12));
        this.JCBNombreTrabajador.setEnabled(false);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Esta Trabajadondo?", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.jPanel4.setForeground(new Color(0, 0, 102));
        this.JBGEstaTrabajador.add(this.JRBEstaSi);
        this.JRBEstaSi.setFont(new Font("Arial", 1, 12));
        this.JRBEstaSi.setForeground(new Color(0, 0, 255));
        this.JRBEstaSi.setText("Si");
        this.JRBEstaSi.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado1.2
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado1.this.JRBEstaSiActionPerformed(evt);
            }
        });
        this.JBGEstaTrabajador.add(this.JRBEstaNo);
        this.JRBEstaNo.setFont(new Font("Arial", 1, 12));
        this.JRBEstaNo.setForeground(new Color(0, 0, 255));
        this.JRBEstaNo.setSelected(true);
        this.JRBEstaNo.setText("No");
        this.JRBEstaNo.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado1.3
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado1.this.JRBEstaNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBEstaSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEstaNo).addContainerGap(36, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEstaSi).addComponent(this.JRBEstaNo, -2, 23, -2)));
        GroupLayout JPIDParentescoLayout = new GroupLayout(this.JPIDParentesco);
        this.JPIDParentesco.setLayout(JPIDParentescoLayout);
        JPIDParentescoLayout.setHorizontalGroup(JPIDParentescoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDParentescoLayout.createSequentialGroup().addGroup(JPIDParentescoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBParentesco, -2, 242, -2).addComponent(this.JLBParentesco, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDParentescoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNombreTrabajador).addComponent(this.JCBNombreTrabajador, -2, 335, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addContainerGap()));
        JPIDParentescoLayout.setVerticalGroup(JPIDParentescoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDParentescoLayout.createSequentialGroup().addGroup(JPIDParentescoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDParentescoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDParentescoLayout.createSequentialGroup().addGroup(JPIDParentescoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBNombreTrabajador).addComponent(this.JLBParentesco)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBNombreTrabajador, -2, 25, -2)).addComponent(this.JCBParentesco, -2, 25, -2)).addComponent(this.jPanel4, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "UNIDAD DE NEGOCIO", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JLBUnidadNegocio.setFont(new Font("Arial", 1, 12));
        this.JLBUnidadNegocio.setForeground(Color.blue);
        this.JLBUnidadNegocio.setHorizontalAlignment(2);
        this.JLBUnidadNegocio.setText("Unidad Negocio");
        this.JCBUnidadNegocio.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadNegocio.setEnabled(false);
        this.JLBSupervisor.setFont(new Font("Arial", 1, 12));
        this.JLBSupervisor.setForeground(Color.blue);
        this.JLBSupervisor.setHorizontalAlignment(2);
        this.JLBSupervisor.setText("Supervisor");
        this.JCBSupervisor.setFont(new Font("Arial", 1, 12));
        this.JCBSupervisor.setEnabled(false);
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBUnidadNegocio).addComponent(this.JLBSupervisor)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBSupervisor, 0, -1, 32767).addComponent(this.JCBUnidadNegocio, 0, 266, 32767)).addContainerGap(-1, 32767)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBUnidadNegocio).addComponent(this.JCBUnidadNegocio, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBSupervisor).addComponent(this.JCBSupervisor, -2, 25, -2)).addContainerGap()));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(0), "ACTIVIDAD", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JLBUTipoActividad.setFont(new Font("Arial", 1, 12));
        this.JLBUTipoActividad.setForeground(Color.blue);
        this.JLBUTipoActividad.setHorizontalAlignment(2);
        this.JLBUTipoActividad.setText("Tipo Actividad");
        this.JCBTipoActividad.setFont(new Font("Arial", 1, 12));
        this.JCBTipoActividad.addItemListener(new ItemListener() { // from class: Historia.JPAEventoNoDeseado1.4
            public void itemStateChanged(ItemEvent evt) {
                JPAEventoNoDeseado1.this.JCBTipoActividadItemStateChanged(evt);
            }
        });
        this.JLBUDetalleTipoActividad.setFont(new Font("Arial", 1, 12));
        this.JLBUDetalleTipoActividad.setForeground(Color.blue);
        this.JLBUDetalleTipoActividad.setHorizontalAlignment(2);
        this.JLBUDetalleTipoActividad.setText("Detalle Actividad");
        this.JCBDetalleTipoActividad.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBUTipoActividad).addComponent(this.JLBUDetalleTipoActividad)).addGap(4, 4, 4).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoActividad, 0, -1, 32767).addComponent(this.JCBDetalleTipoActividad, 0, -1, 32767)).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBUTipoActividad).addComponent(this.JCBTipoActividad, -2, 25, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JLBUDetalleTipoActividad).addComponent(this.JCBDetalleTipoActividad, -2, 25, -2)).addContainerGap(-1, 32767)));
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DEL INCIDENTE", 0, 0, new Font("Arial", 1, 14), new Color(255, 0, 0)));
        this.JTPSitioEvento.setFont(new Font("Arial", 1, 12));
        this.JSPSitioEvento.setViewportView(this.JTPSitioEvento);
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.JSPSitioEvento).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addComponent(this.JSPSitioEvento, -1, 53, 32767).addContainerGap()));
        GroupLayout JPITipoEmpresaLayout = new GroupLayout(this.JPITipoEmpresa);
        this.JPITipoEmpresa.setLayout(JPITipoEmpresaLayout);
        JPITipoEmpresaLayout.setHorizontalGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoEmpresaLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel7, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPITipoEmpresaLayout.createSequentialGroup().addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, 0, -1, 32767)).addComponent(this.JPIDParentesco, -1, -1, 32767).addComponent(this.JPIDEmpresa, -1, -1, 32767).addComponent(this.jPanel1, -2, 740, -2)).addContainerGap()));
        JPITipoEmpresaLayout.setVerticalGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoEmpresaLayout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDEmpresa, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDParentesco, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel6, -1, -1, 32767).addComponent(this.jPanel5, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel7, -2, -1, -2).addContainerGap(15, 32767)));
        this.JTPDetalleEvento.addTab("DETALLES GENERALES", this.JPITipoEmpresa);
        this.JPIDetalleInc.setBorder(BorderFactory.createEtchedBorder());
        this.JLBPCuerpoAfectada.setFont(new Font("Arial", 1, 12));
        this.JLBPCuerpoAfectada.setForeground(Color.blue);
        this.JLBPCuerpoAfectada.setHorizontalAlignment(2);
        this.JLBPCuerpoAfectada.setText("Parte del cuerpo afectada");
        this.JCBPCuerpoAfectada.setFont(new Font("Arial", 1, 12));
        this.JLBActividadEvento.setFont(new Font("Arial", 1, 12));
        this.JLBActividadEvento.setForeground(Color.blue);
        this.JLBActividadEvento.setHorizontalAlignment(2);
        this.JLBActividadEvento.setText("Actividad  especifica que estaba realizando al momento del evento");
        this.JTPActividadEvento.setFont(new Font("Arial", 1, 12));
        this.JSPActividadEvento.setViewportView(this.JTPActividadEvento);
        this.JLBDetalleEvento.setFont(new Font("Arial", 1, 12));
        this.JLBDetalleEvento.setForeground(Color.blue);
        this.JLBDetalleEvento.setHorizontalAlignment(2);
        this.JLBDetalleEvento.setText("Describa en forma detallada y clara las condiciones en que ocurrio el evento");
        this.JTPDetalleEventi.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleEvento.setViewportView(this.JTPDetalleEventi);
        this.JLBDescripcionPAfectadas.setFont(new Font("Arial", 1, 12));
        this.JLBDescripcionPAfectadas.setForeground(Color.blue);
        this.JLBDescripcionPAfectadas.setHorizontalAlignment(2);
        this.JLBDescripcionPAfectadas.setText("Describa la(s) parte(s) del cuerpo afectada(s) (Tener en cuenta la lateralidad)");
        this.JTPDescripcionPAfectadas.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionPAfectadas.setViewportView(this.JTPDescripcionPAfectadas);
        this.JLBDescripcionTratamiento.setFont(new Font("Arial", 1, 12));
        this.JLBDescripcionTratamiento.setForeground(Color.blue);
        this.JLBDescripcionTratamiento.setHorizontalAlignment(2);
        this.JLBDescripcionTratamiento.setText("Describa el tratamiento medico aplicado");
        this.JTPDescripcionTratamiento.setFont(new Font("Arial", 1, 12));
        this.JSPDescripcionTratamiento.setViewportView(this.JTPDescripcionTratamiento);
        this.JLBTipoLesion.setFont(new Font("Arial", 1, 12));
        this.JLBTipoLesion.setForeground(Color.blue);
        this.JLBTipoLesion.setHorizontalAlignment(2);
        this.JLBTipoLesion.setText("Tipo de Lesion");
        this.JCBTipoLesion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoLesion.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado1.5
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado1.this.JCBTipoLesionActionPerformed(evt);
            }
        });
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "Alcohol Sustituto Psicológico", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGAlcohol.add(this.JRBAlcoholSi);
        this.JRBAlcoholSi.setFont(new Font("Arial", 1, 12));
        this.JRBAlcoholSi.setForeground(new Color(0, 0, 255));
        this.JRBAlcoholSi.setText("Si");
        this.JRBAlcoholSi.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado1.6
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado1.this.JRBAlcoholSiActionPerformed(evt);
            }
        });
        this.JBGAlcohol.add(this.JRBAlcoholNo);
        this.JRBAlcoholNo.setFont(new Font("Arial", 1, 12));
        this.JRBAlcoholNo.setForeground(new Color(0, 0, 255));
        this.JRBAlcoholNo.setSelected(true);
        this.JRBAlcoholNo.setText("No");
        this.JRBAlcoholNo.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado1.7
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado1.this.JRBAlcoholNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBAlcoholSi).addGap(31, 31, 31).addComponent(this.JRBAlcoholNo).addContainerGap(56, 32767)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAlcoholNo).addComponent(this.JRBAlcoholSi)));
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "S. Violencia Intrafamiliar", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGViolencia.add(this.JRBViolenciaSi);
        this.JRBViolenciaSi.setFont(new Font("Arial", 1, 12));
        this.JRBViolenciaSi.setForeground(new Color(0, 0, 255));
        this.JRBViolenciaSi.setText("Si");
        this.JRBViolenciaSi.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado1.8
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado1.this.JRBViolenciaSiActionPerformed(evt);
            }
        });
        this.JBGViolencia.add(this.JRBViolenciaNo);
        this.JRBViolenciaNo.setFont(new Font("Arial", 1, 12));
        this.JRBViolenciaNo.setForeground(new Color(0, 0, 255));
        this.JRBViolenciaNo.setSelected(true);
        this.JRBViolenciaNo.setText("No");
        this.JRBViolenciaNo.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado1.9
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado1.this.JRBViolenciaNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBViolenciaSi).addGap(31, 31, 31).addComponent(this.JRBViolenciaNo).addContainerGap(30, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBViolenciaSi).addComponent(this.JRBViolenciaNo)));
        GroupLayout JPIDetalleIncLayout = new GroupLayout(this.JPIDetalleInc);
        this.JPIDetalleInc.setLayout(JPIDetalleIncLayout);
        JPIDetalleIncLayout.setHorizontalGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleIncLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleIncLayout.createSequentialGroup().addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBActividadEvento, -2, 481, -2).addComponent(this.JLBDescripcionPAfectadas, -2, 491, -2).addComponent(this.JLBDetalleEvento, -2, 481, -2).addComponent(this.JLBTipoLesion, -2, 91, -2)).addContainerGap(-1, 32767)).addGroup(JPIDetalleIncLayout.createSequentialGroup().addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDescripcionPAfectadas, GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleEvento, GroupLayout.Alignment.LEADING).addComponent(this.JSPActividadEvento, GroupLayout.Alignment.LEADING, -2, 686, -2)).addGroup(JPIDetalleIncLayout.createSequentialGroup().addComponent(this.jPanel8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel9, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBPCuerpoAfectada, -1, -1, 32767).addComponent(this.JCBPCuerpoAfectada, 0, -1, 32767))).addComponent(this.JSPDescripcionTratamiento).addComponent(this.JLBDescripcionTratamiento, -2, 491, -2).addComponent(this.JCBTipoLesion, 0, -1, 32767)).addGap(69, 69, 69)))));
        JPIDetalleIncLayout.setVerticalGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleIncLayout.createSequentialGroup().addContainerGap().addComponent(this.JLBActividadEvento).addGap(3, 3, 3).addComponent(this.JSPActividadEvento, -2, 33, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBDetalleEvento).addGap(3, 3, 3).addComponent(this.JSPDetalleEvento, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleIncLayout.createSequentialGroup().addComponent(this.JLBPCuerpoAfectada, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPCuerpoAfectada, -2, 25, -2).addGap(4, 4, 4)).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanel8, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel9, GroupLayout.Alignment.LEADING, -2, -1, -2))).addComponent(this.JLBDescripcionPAfectadas).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDescripcionPAfectadas, -2, 34, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBTipoLesion, -2, 24, -2).addGap(11, 11, 11).addComponent(this.JCBTipoLesion, -2, 25, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBDescripcionTratamiento).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDescripcionTratamiento, -2, 74, -2).addGap(123, 123, 123)));
        this.JTPDetalleEvento.addTab("DESCRIPCIÓN", this.JPIDetalleInc);
        this.JTFN.setEditable(false);
        this.JTFN.setBackground(new Color(0, 102, 102));
        this.JTFN.setFont(new Font("Arial", 1, 18));
        this.JTFN.setForeground(new Color(255, 255, 255));
        this.JTFN.setHorizontalAlignment(0);
        this.JTFN.setBorder((Border) null);
        this.JTFEstado.setEditable(false);
        this.JTFEstado.setBackground(new Color(0, 102, 102));
        this.JTFEstado.setFont(new Font("Arial", 1, 18));
        this.JTFEstado.setForeground(new Color(255, 255, 255));
        this.JTFEstado.setHorizontalAlignment(0);
        this.JTFEstado.setBorder((Border) null);
        GroupLayout JPIDetalleEventoLayout = new GroupLayout(this.JPIDetalleEvento);
        this.JPIDetalleEvento.setLayout(JPIDetalleEventoLayout);
        JPIDetalleEventoLayout.setHorizontalGroup(JPIDetalleEventoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleEventoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleEventoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleEventoLayout.createSequentialGroup().addComponent(this.JTPDetalleEvento, -2, 768, 32767).addContainerGap()).addGroup(JPIDetalleEventoLayout.createSequentialGroup().addComponent(this.JTFN, -2, 103, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 513, 32767).addComponent(this.JTFEstado, -2, 140, -2).addGap(22, 22, 22)))));
        JPIDetalleEventoLayout.setVerticalGroup(JPIDetalleEventoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleEventoLayout.createSequentialGroup().addComponent(this.JTPDetalleEvento, -2, 498, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDetalleEventoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFN, -1, 31, 32767).addComponent(this.JTFEstado, -1, 30, 32767))));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDetalleEvento, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDetalleEvento, -1, -1, 32767).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEmpresaEventoItemStateChanged(ItemEvent evt) {
        if (this.lleno != 0 && this.JCBTipoEmpresaEvento.getSelectedIndex() != -1) {
            if (this.xidtipoempresa[this.JCBTipoEmpresaEvento.getSelectedIndex()][1].equals("1")) {
                this.JCBUnidadNegocio.removeAllItems();
                this.JCBSupervisor.removeAllItems();
                String sql = "SELECT Id, Nbre FROM g_tipounidadnegocio where Id_TipoEmpresa='" + this.xidtipoempresa[this.JCBTipoEmpresaEvento.getSelectedIndex()][0] + "' AND Estado =0 ORDER BY Nbre ASC";
                this.xidunidadnegocio = this.xconsultasbd.llenarCombo(sql, this.xidunidadnegocio, this.JCBUnidadNegocio);
                String sql2 = "SELECT g_supervisor.Id_Persona, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS supervisor, g_supervisor.Id_TipoEmpresa  FROM g_supervisor INNER JOIN g_persona ON (g_supervisor.Id_Persona = g_persona.Id) WHERE (g_supervisor.Id_TipoEmpresa ='" + this.xidtipoempresa[this.JCBTipoEmpresaEvento.getSelectedIndex()][0] + "') ORDER BY supervisor";
                this.xidsupervisor = this.xconsultasbd.llenarCombo(sql2, this.xidsupervisor, this.JCBSupervisor);
                this.JCBUnidadNegocio.setEnabled(true);
                this.JCBSupervisor.setEnabled(true);
                this.JCBParentesco.setEnabled(true);
                this.JCBNombreTrabajador.setEnabled(true);
                this.JTFFNEmpresaContr.setEditable(false);
            } else {
                this.JCBUnidadNegocio.setEnabled(false);
                this.JCBUnidadNegocio.setSelectedItem("No Aplica");
                this.JCBSupervisor.setEnabled(false);
                this.JCBSupervisor.setSelectedIndex(0);
                this.JCBParentesco.setEnabled(false);
                this.JCBParentesco.setSelectedItem("No Aplica");
                this.JCBNombreTrabajador.setEnabled(false);
                this.JCBNombreTrabajador.setSelectedIndex(0);
                this.JTFFNEmpresaContr.setEditable(true);
            }
            this.xconsultasbd.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstaSiActionPerformed(ActionEvent evt) {
        this.xestrabajando = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBEstaNoActionPerformed(ActionEvent evt) {
        this.xestrabajando = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlcoholSiActionPerformed(ActionEvent evt) {
        this.xesalcohol = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAlcoholNoActionPerformed(ActionEvent evt) {
        this.xesalcohol = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBViolenciaSiActionPerformed(ActionEvent evt) {
        this.xesviolencia = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBViolenciaNoActionPerformed(ActionEvent evt) {
        this.xesviolencia = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoActividadItemStateChanged(ItemEvent evt) {
        if (this.lleno == 1 && this.JCBTipoActividad.getSelectedIndex() != -1) {
            this.JCBDetalleTipoActividad.removeAllItems();
            String sql = "SELECT Id, Nbre  FROM e_detalletipoactividad WHERE (Id_TipoActividad ='" + this.xidtipoactividad[this.JCBTipoActividad.getSelectedIndex()] + "' AND Estado =0) ORDER BY Nbre ASC ";
            this.xiddetalleactividad = this.xconsultasbd.llenarCombo(sql, this.xiddetalleactividad, this.JCBDetalleTipoActividad);
            this.JCBDetalleTipoActividad.setSelectedItem("No Aplica");
            this.xconsultasbd.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoLesionActionPerformed(ActionEvent evt) {
    }

    private boolean mValidar() {
        boolean validar = false;
        if (this.JCBTipoEvento.getSelectedIndex() != -1) {
            if (this.JCBClaseEvento.getSelectedIndex() != -1) {
                if (this.JCBTipoEmpresaEvento.getSelectedIndex() != -1) {
                    if (this.JCBPCuerpoAfectada.getSelectedIndex() != -1) {
                        if (this.JCBTipoActividad.getSelectedIndex() != -1) {
                            if (this.JCBDetalleTipoActividad.getSelectedIndex() != -1) {
                                if (this.JCBPCuerpoAfectada.getSelectedIndex() != -1) {
                                    if (!this.JTPActividadEvento.getText().isEmpty()) {
                                        if (!this.JTPDetalleEventi.getText().isEmpty()) {
                                            if (!this.JTPDescripcionPAfectadas.getText().isEmpty()) {
                                                if (!this.JTPDescripcionTratamiento.getText().isEmpty()) {
                                                    if (this.JCBTipoLesion.getSelectedIndex() != -1) {
                                                        validar = true;
                                                    } else {
                                                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de lesión", "VERIFICAR", 0);
                                                        this.JCBTipoLesion.requestFocus();
                                                    }
                                                } else {
                                                    JOptionPane.showInternalMessageDialog(this, "Debe especificar el tratamiento", "VERIFICAR", 0);
                                                    this.JTPDescripcionTratamiento.requestFocus();
                                                }
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "Debe especificar las partes afectadas", "VERIFICAR", 0);
                                                this.JTPDescripcionPAfectadas.requestFocus();
                                            }
                                        } else {
                                            JOptionPane.showInternalMessageDialog(this, "Debe especificar el detalle de la actividada", "VERIFICAR", 0);
                                            this.JTPDetalleEventi.requestFocus();
                                        }
                                    } else {
                                        JOptionPane.showInternalMessageDialog(this, "Debe especificar la actividada", "VERIFICAR", 0);
                                        this.JTPActividadEvento.requestFocus();
                                    }
                                } else {
                                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la parte del cuerpo afectada", "VERIFICAR", 0);
                                    this.JCBPCuerpoAfectada.requestFocus();
                                }
                            } else {
                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el detalle actividad", "VERIFICAR", 0);
                                this.JCBDetalleTipoActividad.requestFocus();
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo actividad", "VERIFICAR", 0);
                            this.JCBTipoActividad.requestFocus();
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo de justificacion", "VERIFICAR", 0);
                        this.JCBPCuerpoAfectada.requestFocus();
                    }
                } else {
                    JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la el tipo de empresa", "VERIFICAR", 0);
                    this.JCBPCuerpoAfectada.requestFocus();
                }
            } else {
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar la clase evento", "VERIFICAR", 0);
                this.JCBClaseEvento.requestFocus();
            }
        } else {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar tipo evento", "VERIFICAR", 0);
            this.JCBTipoEvento.requestFocus();
        }
        return validar;
    }

    public void nuevo() {
        this.JCBTipoEvento.setSelectedIndex(-1);
        this.JCBClaseEvento.setSelectedIndex(-1);
        this.JTFFHora.setText(this.xmetodo.formatoH24A.format(this.xmetodo.getFechaActual()));
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JCBTipoEmpresaEvento.setSelectedIndex(-1);
        this.JCBParentesco.setSelectedItem("No Aplica");
        this.JTFFNEmpresaContr.setText((String) null);
        this.JRBEstaNo.setSelected(true);
        this.xestrabajando = 0;
        this.JCBUnidadNegocio.setSelectedItem("No Aplica");
        this.JCBSupervisor.setSelectedItem("No Aplica");
        this.JCBNombreTrabajador.setSelectedIndex(0);
        this.JCBTipoActividad.setSelectedIndex(-1);
        this.JCBPCuerpoAfectada.setSelectedIndex(-1);
        this.JCBTipoLesion.setSelectedIndex(-1);
        this.JTPSitioEvento.setText((String) null);
        this.JTPActividadEvento.setText((String) null);
        this.JTPDescripcionPAfectadas.setText((String) null);
        this.JTPDescripcionTratamiento.setText((String) null);
        this.JTPDetalleEventi.setText((String) null);
        this.JRBAlcoholNo.setSelected(true);
        this.xesviolencia = 0;
        this.JRBViolenciaNo.setSelected(true);
        this.JTFN.setText((String) null);
        this.JTFEstado.setText((String) null);
        this.xesalcohol = 0;
    }

    public void grabar() {
        if (mValidar()) {
            String sql = "INSERT INTO e_eventonodeseado (Id_Usuario, idatencion, Id_TipoEvento, Id_ClaseEvento, Fecha_Evento, Ndias, HoraDia, Id_TipoEmpresa, NbreEmpresa, Id_TipoParentesco, NombreTrabajador, Sepresento , Id_UnidadNegocio, Id_Supervisor, Id_TipoActividad, Id_DetTipoActividad, Sitio, ActividadEsp, DescActividadEsp, AsocAlcohol, SospViol, Id_ParteCAfectada, DescParteCAfectada , Id_TipoLesion, ManejoMedico, Id_Profesional, Estado, Fecha, UsuarioS) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xidtipoevento[this.JCBTipoEvento.getSelectedIndex()][0] + "','" + this.xidclaseevento[this.JCBClaseEvento.getSelectedIndex()] + "','" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.JSPNDias.getValue() + "','" + this.xmetodo.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.xidtipoempresa[this.JCBTipoEmpresaEvento.getSelectedIndex()][0] + "','" + this.JTFFNEmpresaContr.getText() + "','" + this.xidparentesco[this.JCBParentesco.getSelectedIndex()] + "','" + this.JCBNombreTrabajador.getSelectedItem().toString() + "','" + this.xestrabajando + "','" + this.xidunidadnegocio[this.JCBUnidadNegocio.getSelectedIndex()] + "','" + this.xidsupervisor[this.JCBSupervisor.getSelectedIndex()] + "','" + this.xidtipoactividad[this.JCBTipoActividad.getSelectedIndex()] + "','" + this.xiddetalleactividad[this.JCBDetalleTipoActividad.getSelectedIndex()] + "','" + this.JTPSitioEvento.getText() + "','" + this.JTPActividadEvento.getText() + "','" + this.JTPDetalleEventi.getText() + "','" + this.xesalcohol + "','" + this.xesviolencia + "','" + this.xidparteafecta[this.JCBPCuerpoAfectada.getSelectedIndex()] + "','" + this.JTPDescripcionPAfectadas.getText() + "','" + this.xidtipolesion[this.JCBTipoLesion.getSelectedIndex()] + "','" + this.JTPDescripcionTratamiento.getText() + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
            this.JTFN.setText(this.xconsultasbd.ejecutarSQLId(sql));
            this.xconsultasbd.cerrarConexionBd();
            this.JTFEstado.setText("ACTIVO");
            imprimir();
        }
    }

    public void imprimir() {
        if (!this.JTFN.getText().isEmpty()) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "norden";
            mparametros[0][1] = this.JTFN.getText();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra();
            Object[] botones = {"Impresion", "Vista PDF", "Cerrar"};
            int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "EVENTO NO DESEADO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
            if (n == 0) {
                this.xmetodo.PresentacionImpresora("REventosNoDeseados.jasper", mparametros);
            } else if (n == 1) {
                this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "REventosNoDeseados", mparametros);
            }
        }
    }

    public void mBuscarEvento(String id) {
        try {
            String sql = "SELECT e_tipoevento.Nbre, e_claseevento.Nbre, e_eventonodeseado.Fecha_Evento, e_eventonodeseado.Ndias, e_eventonodeseado.HoraDia, g_tipoempresa.Nbre, e_eventonodeseado.NbreEmpresa, g_parentesco.Nbre, e_eventonodeseado.NombreTrabajador, e_eventonodeseado.Sepresento, g_tipounidadnegocio.Nbre, e_tipoactividad.Nbre , e_detalletipoactividad.Nbre, e_eventonodeseado.Sitio, e_eventonodeseado.ActividadEsp, e_eventonodeseado.DescActividadEsp, e_eventonodeseado.AsocAlcohol, e_eventonodeseado.SospViol, e_parteafectada.Nbre, e_eventonodeseado.DescParteCAfectada, e_tipolesion.Nbre, e_eventonodeseado.ManejoMedico, e_eventonodeseado.Estado, e_eventonodeseado.Id FROM e_eventonodeseado INNER JOIN g_profesional  ON (e_eventonodeseado.Id_Profesional = g_profesional.Id_Persona) INNER JOIN g_persona  ON (g_profesional.Id_Persona = g_persona.Id) INNER JOIN e_claseevento  ON (e_eventonodeseado.Id_ClaseEvento = e_claseevento.Id) INNER JOIN e_tipoevento  ON (e_eventonodeseado.Id_TipoEvento = e_tipoevento.Id) INNER JOIN g_tipoempresa  ON (e_eventonodeseado.Id_TipoEmpresa = g_tipoempresa.Id) INNER JOIN g_parentesco  ON (e_eventonodeseado.Id_TipoParentesco = g_parentesco.Id) INNER JOIN g_tipounidadnegocio   ON (g_tipounidadnegocio.Id = e_eventonodeseado.Id_UnidadNegocio) INNER JOIN e_tipoactividad  ON (e_eventonodeseado.Id_TipoActividad = e_tipoactividad.Id) INNER JOIN e_detalletipoactividad  ON (e_eventonodeseado.Id_DetTipoActividad = e_detalletipoactividad.Id) INNER JOIN e_parteafectada  ON (e_eventonodeseado.Id_ParteCAfectada = e_parteafectada.Id) INNER JOIN e_tipolesion  ON (e_eventonodeseado.Id_TipoLesion = e_tipolesion.Id) WHERE (e_eventonodeseado.Id ='" + id + "') ";
            ResultSet rs = this.xconsultasbd.traerRs(sql);
            if (rs.next()) {
                rs.first();
                this.JTFN.setText(rs.getString(24));
                this.JCBTipoEvento.setSelectedItem(rs.getString(1));
                this.JCBClaseEvento.setSelectedItem(rs.getString(2));
                this.JDFecha.setDate(rs.getDate(3));
                this.JSPNDias.setValue(Integer.valueOf(rs.getInt(4)));
                this.JTFFHora.setText(rs.getString(5));
                this.JCBTipoEmpresaEvento.setSelectedItem(rs.getString(6));
                this.JTFFNEmpresaContr.setText(rs.getString(7));
                this.JCBParentesco.setSelectedItem(rs.getString(8));
                this.JCBNombreTrabajador.setSelectedItem(rs.getString(9));
                if (rs.getInt(10) == 0) {
                    this.JRBEstaNo.setSelected(true);
                } else {
                    this.JRBEstaSi.setSelected(true);
                }
                this.JCBUnidadNegocio.setSelectedItem(rs.getString(11));
                this.JCBTipoActividad.setSelectedItem(rs.getString(12));
                this.JCBDetalleTipoActividad.setSelectedItem(rs.getString(13));
                this.JTPSitioEvento.setText(rs.getString(14));
                this.JTPActividadEvento.setText(rs.getString(15));
                this.JTPDetalleEventi.setText(rs.getString(16));
                if (rs.getInt(17) == 0) {
                    this.JRBAlcoholNo.setSelected(true);
                } else {
                    this.JRBAlcoholSi.setSelected(true);
                }
                if (rs.getInt(18) == 0) {
                    this.JRBViolenciaNo.setSelected(true);
                } else {
                    this.JRBViolenciaSi.setSelected(true);
                }
                this.JCBPCuerpoAfectada.setSelectedItem(rs.getString(19));
                this.JTPDescripcionPAfectadas.setText(rs.getString(20));
                this.JCBTipoLesion.setSelectedItem(rs.getString(21));
                this.JTPDescripcionTratamiento.setText(rs.getString(22));
                if (rs.getInt(23) == 1) {
                    this.JTFEstado.setText("ANULADO");
                } else {
                    this.JTFEstado.setText("ACTIVO");
                }
                this.JTFN.setText(rs.getString(24));
            }
            rs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    public void anular() {
        if (this.JTFN.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this, "No existe N° Evento Activo", "ANULAR EVENTO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        int xver = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Anular ? ", "ANULACIÓN", 0, 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (xver == 0) {
            String sql = "UPDATE e_eventonodeseado SET Estado = 1 WHERE(Id ='" + this.JTFN.getText() + "')";
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
            this.JTFEstado.setText("ANULADA");
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
