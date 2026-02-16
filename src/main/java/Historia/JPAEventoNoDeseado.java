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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAEventoNoDeseado.class */
public class JPAEventoNoDeseado extends JPanel {
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
    private JComboBox JCBPCuerpoAfectada;
    private JComboBox JCBSupervisor;
    private JComboBox JCBTipoActividad;
    private JComboBox JCBTipoEmpresaEvento;
    public JComboBox JCBTipoEvento;
    private JComboBox JCBTipoLesion;
    private JComboBox JCBUnidadNegocio;
    private JDateChooser JDFecha;
    private JPanel JPIDEmpresa;
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
    private JScrollPane JSPDetalleEvento;
    private JScrollPane JSPSitioEvento;
    private JTextField JTFEstado;
    private JFormattedTextField JTFFHora;
    private JFormattedTextField JTFFNEmpresaContr;
    private JTextField JTFN;
    private JTextPane JTPActividadEvento;
    private JTextPane JTPDetalleEventi;
    private JTabbedPane JTPDetalleEvento;
    private JTextPane JTPSitioEvento;
    private JPanel jPanel1;
    private JPanel jPanel4;
    private JPanel jPanel6;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private SimpleDateFormat xfhora = new SimpleDateFormat("HH:mm:ss");
    private GregorianCalendar xhoy = new GregorianCalendar();
    private int xestrabajando = 0;
    private int xesalcohol = 0;
    private int xesviolencia = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();

    public JPAEventoNoDeseado(clasesHistoriaCE xclase) {
        this.lleno = 0;
        initComponents();
        this.xclase = xclase;
        this.JDFecha.setDate(this.xmetodo.getFechaActual());
        this.JTFFHora.setValue(this.xmetodo.getFechaActual());
        this.xidtipoevento = this.xconsultasbd.llenarComboyLista("SELECT Id, Nbre, EsTrabajador FROM e_tipoevento WHERE (Estado =0)", this.xidtipoevento, this.JCBTipoEvento, 3);
        this.JCBTipoEvento.setSelectedIndex(-1);
        this.xidclaseevento = this.xconsultasbd.llenarCombo("SELECT Id, Nbre FROM e_claseevento WHERE (Estado =0) ORDER BY Nbre ASC", this.xidclaseevento, this.JCBClaseEvento);
        this.xidtipoempresa = this.xconsultasbd.llenarComboyLista("SELECT Id, Nbre, ExigeNit FROM g_tipoempresa WHERE (Estado =0) ORDER BY Nbre ASC", this.xidtipoempresa, this.JCBTipoEmpresaEvento, 3);
        this.JCBTipoEmpresaEvento.setSelectedIndex(-1);
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
        this.JCBTipoEvento = new JComboBox();
        this.JCBClaseEvento = new JComboBox();
        this.JDFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JPIDEmpresa = new JPanel();
        this.JCBTipoEmpresaEvento = new JComboBox();
        this.JTFFNEmpresaContr = new JFormattedTextField();
        this.jPanel6 = new JPanel();
        this.JCBTipoActividad = new JComboBox();
        this.JCBDetalleTipoActividad = new JComboBox();
        this.JCBUnidadNegocio = new JComboBox();
        this.JCBSupervisor = new JComboBox();
        this.JPIDetalleInc = new JPanel();
        this.JCBPCuerpoAfectada = new JComboBox();
        this.JSPActividadEvento = new JScrollPane();
        this.JTPActividadEvento = new JTextPane();
        this.JSPDetalleEvento = new JScrollPane();
        this.JTPDetalleEventi = new JTextPane();
        this.JCBTipoLesion = new JComboBox();
        this.jPanel8 = new JPanel();
        this.JRBAlcoholSi = new JRadioButton();
        this.JRBAlcoholNo = new JRadioButton();
        this.jPanel9 = new JPanel();
        this.JRBViolenciaSi = new JRadioButton();
        this.JRBViolenciaNo = new JRadioButton();
        this.JSPSitioEvento = new JScrollPane();
        this.JTPSitioEvento = new JTextPane();
        this.jPanel4 = new JPanel();
        this.JRBEstaSi = new JRadioButton();
        this.JRBEstaNo = new JRadioButton();
        this.JTFN = new JTextField();
        this.JTFEstado = new JTextField();
        setName("jpaeventonodeseado");
        this.JPIDetalleEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "EVENTO NO DESEADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTPDetalleEvento.setForeground(new Color(0, 103, 0));
        this.JTPDetalleEvento.setFont(new Font("Arial", 1, 14));
        this.JPITipoEmpresa.setBorder(BorderFactory.createEtchedBorder());
        this.JPITipoEmpresa.setFont(new Font("Arial", 1, 14));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "EVENTO", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBTipoEvento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBClaseEvento.setFont(new Font("Arial", 1, 12));
        this.JCBClaseEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Clase", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "Hora(HH-mm AM/PM)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFHora.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(new SimpleDateFormat("HH:mm a"))));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoEvento, -2, 185, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBClaseEvento, -2, 219, -2).addGap(18, 18, 18).addComponent(this.JDFecha, -1, 127, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFHora, -2, 148, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFHora, -1, 52, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBTipoEvento, GroupLayout.Alignment.LEADING).addComponent(this.JDFecha, GroupLayout.Alignment.LEADING, -1, 45, 32767)).addComponent(this.JCBClaseEvento, -1, 52, 32767)).addContainerGap()));
        this.JPIDEmpresa.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "EMPRESA", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBTipoEmpresaEvento.setFont(new Font("Arial", 1, 12));
        this.JCBTipoEmpresaEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoEmpresaEvento.addItemListener(new ItemListener() { // from class: Historia.JPAEventoNoDeseado.1
            public void itemStateChanged(ItemEvent evt) {
                JPAEventoNoDeseado.this.JCBTipoEmpresaEventoItemStateChanged(evt);
            }
        });
        this.JTFFNEmpresaContr.setEditable(false);
        this.JTFFNEmpresaContr.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Empresa (Solo en caso de ser Contratista o Particular", 0, 0, new Font("Arial", 1, 12), Color.blue));
        try {
            this.JTFFNEmpresaContr.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        this.JTFFNEmpresaContr.setHorizontalAlignment(11);
        this.JTFFNEmpresaContr.setFont(new Font("Arial", 1, 12));
        GroupLayout JPIDEmpresaLayout = new GroupLayout(this.JPIDEmpresa);
        this.JPIDEmpresa.setLayout(JPIDEmpresaLayout);
        JPIDEmpresaLayout.setHorizontalGroup(JPIDEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDEmpresaLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoEmpresaEvento, -2, 242, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNEmpresaContr, -1, 465, 32767).addContainerGap()));
        JPIDEmpresaLayout.setVerticalGroup(JPIDEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDEmpresaLayout.createSequentialGroup().addGroup(JPIDEmpresaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTipoEmpresaEvento, -2, 46, -2).addComponent(this.JTFFNEmpresaContr, -2, 46, -2)).addContainerGap(-1, 32767)));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "ACTIVIDAD", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JCBTipoActividad.setFont(new Font("Arial", 1, 12));
        this.JCBTipoActividad.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoActividad.addItemListener(new ItemListener() { // from class: Historia.JPAEventoNoDeseado.2
            public void itemStateChanged(ItemEvent evt) {
                JPAEventoNoDeseado.this.JCBTipoActividadItemStateChanged(evt);
            }
        });
        this.JCBDetalleTipoActividad.setFont(new Font("Arial", 1, 12));
        this.JCBDetalleTipoActividad.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.JCBTipoActividad, -2, 236, -2).addGap(18, 18, 18).addComponent(this.JCBDetalleTipoActividad, 0, 459, 32767).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBDetalleTipoActividad, GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoActividad, GroupLayout.Alignment.LEADING, -2, 47, -2)).addContainerGap()));
        this.JCBUnidadNegocio.setFont(new Font("Arial", 1, 12));
        this.JCBUnidadNegocio.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad Negocio", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBUnidadNegocio.setEnabled(false);
        this.JCBSupervisor.setFont(new Font("Arial", 1, 12));
        this.JCBSupervisor.setBorder(BorderFactory.createTitledBorder((Border) null, "Supervisor", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBSupervisor.setEnabled(false);
        GroupLayout JPITipoEmpresaLayout = new GroupLayout(this.JPITipoEmpresa);
        this.JPITipoEmpresa.setLayout(JPITipoEmpresaLayout);
        JPITipoEmpresaLayout.setHorizontalGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoEmpresaLayout.createSequentialGroup().addContainerGap().addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel6, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.JPIDEmpresa, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPITipoEmpresaLayout.createSequentialGroup().addComponent(this.JCBUnidadNegocio, -2, 359, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBSupervisor, 0, 380, 32767))).addContainerGap()));
        JPITipoEmpresaLayout.setVerticalGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPITipoEmpresaLayout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPIDEmpresa, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPITipoEmpresaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBUnidadNegocio, -2, -1, -2).addComponent(this.JCBSupervisor, -1, 50, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel6, -2, -1, -2).addGap(67, 67, 67)));
        this.JTPDetalleEvento.addTab("DETALLES GENERALES", this.JPITipoEmpresa);
        this.JPIDetalleInc.setBorder(BorderFactory.createEtchedBorder());
        this.JCBPCuerpoAfectada.setFont(new Font("Arial", 1, 12));
        this.JCBPCuerpoAfectada.setBorder(BorderFactory.createTitledBorder((Border) null, "Parte del Cuerpo Afectada", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPActividadEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Actividad  especifica que estaba realizando al momento del evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPActividadEvento.setFont(new Font("Arial", 1, 12));
        this.JSPActividadEvento.setViewportView(this.JTPActividadEvento);
        this.JSPDetalleEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Describa en forma detallada y clara las condiciones en que ocurrio el evento", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDetalleEventi.setFont(new Font("Arial", 1, 12));
        this.JSPDetalleEvento.setViewportView(this.JTPDetalleEventi);
        this.JCBTipoLesion.setFont(new Font("Arial", 1, 12));
        this.JCBTipoLesion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Lesión", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoLesion.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado.3
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado.this.JCBTipoLesionActionPerformed(evt);
            }
        });
        this.jPanel8.setBorder(BorderFactory.createTitledBorder((Border) null, "Alcohol Sustituto Psicológico", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JBGAlcohol.add(this.JRBAlcoholSi);
        this.JRBAlcoholSi.setFont(new Font("Arial", 1, 12));
        this.JRBAlcoholSi.setForeground(Color.blue);
        this.JRBAlcoholSi.setText("Si");
        this.JRBAlcoholSi.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado.4
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado.this.JRBAlcoholSiActionPerformed(evt);
            }
        });
        this.JBGAlcohol.add(this.JRBAlcoholNo);
        this.JRBAlcoholNo.setFont(new Font("Arial", 1, 12));
        this.JRBAlcoholNo.setForeground(Color.blue);
        this.JRBAlcoholNo.setSelected(true);
        this.JRBAlcoholNo.setText("No");
        this.JRBAlcoholNo.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado.5
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado.this.JRBAlcoholNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBAlcoholSi).addGap(31, 31, 31).addComponent(this.JRBAlcoholNo).addContainerGap(61, 32767)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBAlcoholNo).addComponent(this.JRBAlcoholSi)));
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "S. Violencia Intrafamiliar", 0, 0, new Font("Arial", 1, 12), new Color(255, 0, 0)));
        this.JBGViolencia.add(this.JRBViolenciaSi);
        this.JRBViolenciaSi.setFont(new Font("Arial", 1, 12));
        this.JRBViolenciaSi.setForeground(Color.blue);
        this.JRBViolenciaSi.setText("Si");
        this.JRBViolenciaSi.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado.6
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado.this.JRBViolenciaSiActionPerformed(evt);
            }
        });
        this.JBGViolencia.add(this.JRBViolenciaNo);
        this.JRBViolenciaNo.setFont(new Font("Arial", 1, 12));
        this.JRBViolenciaNo.setForeground(Color.blue);
        this.JRBViolenciaNo.setSelected(true);
        this.JRBViolenciaNo.setText("No");
        this.JRBViolenciaNo.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado.7
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado.this.JRBViolenciaNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBViolenciaSi).addGap(31, 31, 31).addComponent(this.JRBViolenciaNo).addContainerGap(31, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBViolenciaSi).addComponent(this.JRBViolenciaNo)));
        this.JSPSitioEvento.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle del Incidente", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPSitioEvento.setFont(new Font("Arial", 1, 12));
        this.JSPSitioEvento.setViewportView(this.JTPSitioEvento);
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "Esta Trabajadondo?", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.jPanel4.setForeground(new Color(0, 0, 102));
        this.JBGEstaTrabajador.add(this.JRBEstaSi);
        this.JRBEstaSi.setFont(new Font("Arial", 1, 12));
        this.JRBEstaSi.setForeground(Color.blue);
        this.JRBEstaSi.setText("Si");
        this.JRBEstaSi.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado.8
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado.this.JRBEstaSiActionPerformed(evt);
            }
        });
        this.JBGEstaTrabajador.add(this.JRBEstaNo);
        this.JRBEstaNo.setFont(new Font("Arial", 1, 12));
        this.JRBEstaNo.setForeground(Color.blue);
        this.JRBEstaNo.setSelected(true);
        this.JRBEstaNo.setText("No");
        this.JRBEstaNo.addActionListener(new ActionListener() { // from class: Historia.JPAEventoNoDeseado.9
            public void actionPerformed(ActionEvent evt) {
                JPAEventoNoDeseado.this.JRBEstaNoActionPerformed(evt);
            }
        });
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.JRBEstaSi).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBEstaNo).addContainerGap(41, 32767)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBEstaSi).addComponent(this.JRBEstaNo, -2, 23, -2)));
        GroupLayout JPIDetalleIncLayout = new GroupLayout(this.JPIDetalleInc);
        this.JPIDetalleInc.setLayout(JPIDetalleIncLayout);
        JPIDetalleIncLayout.setHorizontalGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleIncLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPSitioEvento, -1, 745, 32767).addComponent(this.JSPDetalleEvento, -1, 745, 32767).addComponent(this.JSPActividadEvento, GroupLayout.Alignment.TRAILING, -1, 745, 32767).addGroup(JPIDetalleIncLayout.createSequentialGroup().addComponent(this.jPanel8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel9, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel4, -2, -1, -2).addGap(0, 0, 32767)).addComponent(this.JCBTipoLesion, 0, 745, 32767).addComponent(this.JCBPCuerpoAfectada, 0, 745, 32767)).addContainerGap()));
        JPIDetalleIncLayout.setVerticalGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleIncLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPSitioEvento, -2, 69, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPActividadEvento, -2, 64, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleEvento, -2, 62, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDetalleIncLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel9, -2, -1, -2).addComponent(this.jPanel8, -2, -1, -2).addComponent(this.jPanel4, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBPCuerpoAfectada, -2, 49, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBTipoLesion, -2, 46, -2).addContainerGap(21, 32767)));
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
        JPIDetalleEventoLayout.setHorizontalGroup(JPIDetalleEventoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleEventoLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleEventoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDetalleEvento).addGroup(GroupLayout.Alignment.TRAILING, JPIDetalleEventoLayout.createSequentialGroup().addComponent(this.JTFN, -2, 143, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JTFEstado, -2, 140, -2))).addContainerGap()));
        JPIDetalleEventoLayout.setVerticalGroup(JPIDetalleEventoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleEventoLayout.createSequentialGroup().addComponent(this.JTPDetalleEvento, -2, 439, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDetalleEventoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFN, -1, 33, 32767).addComponent(this.JTFEstado, -1, 33, 32767)).addContainerGap()));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDetalleEvento, -1, -1, 32767).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIDetalleEvento, -2, -1, -2).addContainerGap(-1, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoEmpresaEventoItemStateChanged(ItemEvent evt) {
        if (this.lleno != 0 && this.JCBTipoEmpresaEvento.getSelectedIndex() != -1) {
            ConsultasMySQL xct = new ConsultasMySQL();
            if (this.xidtipoempresa[this.JCBTipoEmpresaEvento.getSelectedIndex()][1].equals("1")) {
                this.JCBUnidadNegocio.removeAllItems();
                this.JCBSupervisor.removeAllItems();
                String sql = "SELECT Id, Nbre FROM g_tipounidadnegocio where Id_TipoEmpresa='" + this.xidtipoempresa[this.JCBTipoEmpresaEvento.getSelectedIndex()][0] + "' AND Estado =0 ORDER BY Nbre ASC";
                this.xidunidadnegocio = xct.llenarCombo(sql, this.xidunidadnegocio, this.JCBUnidadNegocio);
                String sql2 = "SELECT g_supervisor.Id_Persona, CONCAT(g_persona.Apellido1,' ',g_persona.Apellido2,' ',g_persona.Nombre1,' ',g_persona.Nombre2) AS supervisor, g_supervisor.Id_TipoEmpresa  FROM g_supervisor INNER JOIN g_persona ON (g_supervisor.Id_Persona = g_persona.Id) WHERE (g_supervisor.Id_TipoEmpresa ='" + this.xidtipoempresa[this.JCBTipoEmpresaEvento.getSelectedIndex()][0] + "') ORDER BY supervisor";
                this.xidsupervisor = xct.llenarCombo(sql2, this.xidsupervisor, this.JCBSupervisor);
                this.JCBUnidadNegocio.setEnabled(true);
                this.JCBSupervisor.setEnabled(true);
                this.JTFFNEmpresaContr.setEditable(false);
                xct.cerrarConexionBd();
                return;
            }
            this.JCBUnidadNegocio.setEnabled(false);
            this.JCBUnidadNegocio.setSelectedItem("No Aplica");
            this.JCBSupervisor.setEnabled(false);
            this.JCBSupervisor.setSelectedIndex(0);
            this.JTFFNEmpresaContr.setEditable(true);
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
            ConsultasMySQL xct = new ConsultasMySQL();
            this.JCBDetalleTipoActividad.removeAllItems();
            String sql = "SELECT Id, Nbre  FROM e_detalletipoactividad WHERE (Id_TipoActividad ='" + this.xidtipoactividad[this.JCBTipoActividad.getSelectedIndex()] + "' AND Estado =0) ORDER BY Nbre ASC ";
            this.xiddetalleactividad = xct.llenarCombo(sql, this.xiddetalleactividad, this.JCBDetalleTipoActividad);
            this.JCBDetalleTipoActividad.setSelectedItem("No Aplica");
            xct.cerrarConexionBd();
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
                                            if (this.JCBTipoLesion.getSelectedIndex() != -1) {
                                                validar = true;
                                            } else {
                                                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar el tipo de lesión", "VERIFICAR", 0);
                                                this.JCBTipoLesion.requestFocus();
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
        this.JTFFNEmpresaContr.setText((String) null);
        this.JRBEstaNo.setSelected(true);
        this.xestrabajando = 0;
        this.JCBUnidadNegocio.setSelectedItem("No Aplica");
        this.JCBSupervisor.setSelectedItem("No Aplica");
        this.JCBTipoActividad.setSelectedIndex(-1);
        this.JCBPCuerpoAfectada.setSelectedIndex(-1);
        this.JCBTipoLesion.setSelectedIndex(-1);
        this.JTPSitioEvento.setText((String) null);
        this.JTPActividadEvento.setText((String) null);
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
            String sql = "INSERT INTO e_eventonodeseado (Id_Usuario, idatencion, Id_TipoEvento, Id_ClaseEvento, Fecha_Evento, HoraDia, Id_TipoEmpresa, NbreEmpresa, Sepresento , Id_UnidadNegocio, Id_Supervisor, Id_TipoActividad, Id_DetTipoActividad, Sitio, ActividadEsp, DescActividadEsp, AsocAlcohol, SospViol, Id_ParteCAfectada , Id_TipoLesion, Id_Profesional, Id_Especialidad, Estado, Fecha, UsuarioS) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "','" + this.xidtipoevento[this.JCBTipoEvento.getSelectedIndex()][0] + "','" + this.xidclaseevento[this.JCBClaseEvento.getSelectedIndex()] + "','" + this.xmetodo.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.xmetodo.formatoH24.format(this.JTFFHora.getValue()) + "','" + this.xidtipoempresa[this.JCBTipoEmpresaEvento.getSelectedIndex()][0] + "','" + this.JTFFNEmpresaContr.getText() + "','" + this.xestrabajando + "','" + this.xidunidadnegocio[this.JCBUnidadNegocio.getSelectedIndex()] + "','" + this.xidsupervisor[this.JCBSupervisor.getSelectedIndex()] + "','" + this.xidtipoactividad[this.JCBTipoActividad.getSelectedIndex()] + "','" + this.xiddetalleactividad[this.JCBDetalleTipoActividad.getSelectedIndex()] + "','" + this.JTPSitioEvento.getText() + "','" + this.JTPActividadEvento.getText() + "','" + this.JTPDetalleEventi.getText() + "','" + this.xesalcohol + "','" + this.xesviolencia + "','" + this.xidparteafecta[this.JCBPCuerpoAfectada.getSelectedIndex()] + "','" + this.xidtipolesion[this.JCBTipoLesion.getSelectedIndex()] + "','" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "','" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "','0','" + this.xmetodo.formatoAMDH24.format(this.xmetodo.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
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

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x01d1: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r7 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY] A[D('rs' java.sql.ResultSet)]) A[TRY_LEAVE], block:B:33:0x01d1 */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x01d5: MOVE (r0 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:35:0x01d5 */
    public void mBuscarEvento(String id) {
        try {
            try {
                String sql = "SELECT e_tipoevento.Nbre AS TipoEvento, e_claseevento.Nbre AS ClaseEvento, e_eventonodeseado.Fecha_Evento, e_eventonodeseado.HoraDia, g_tipoempresa.Nbre AS TipoEmpresa , e_eventonodeseado.NbreEmpresa AS NEmpresa , g_tipounidadnegocio.Nbre AS NUnidadNegocio, w_persona.NUsuario AS Supervisor, e_tipoactividad.Nbre AS NActividad, e_detalletipoactividad.Nbre AS DActividad , e_eventonodeseado.Sitio, e_eventonodeseado.ActividadEsp, e_eventonodeseado.DescActividadEsp, e_eventonodeseado.AsocAlcohol, e_eventonodeseado.SospViol, e_parteafectada.Nbre AS PAfectada, e_tipolesion.Nbre AS TipoLesion , e_eventonodeseado.Sepresento , e_eventonodeseado.Id , e_eventonodeseado.Estado , e_eventonodeseado.Id_Usuario FROM  e_eventonodeseado INNER JOIN e_tipoevento  ON (e_eventonodeseado.Id_TipoEvento = e_tipoevento.Id) INNER JOIN e_claseevento  ON (e_eventonodeseado.Id_ClaseEvento = e_claseevento.Id) INNER JOIN g_tipoempresa  ON (e_eventonodeseado.Id_TipoEmpresa = g_tipoempresa.Id) INNER JOIN g_tipounidadnegocio  ON (g_tipounidadnegocio.Id = e_eventonodeseado.Id_UnidadNegocio) INNER JOIN g_supervisor  ON (e_eventonodeseado.Id_Supervisor = g_supervisor.Id_Persona) INNER JOIN w_persona  ON (w_persona.Id_persona = g_supervisor.Id_Persona) INNER JOIN e_tipoactividad  ON (e_eventonodeseado.Id_TipoActividad = e_tipoactividad.Id) INNER JOIN e_detalletipoactividad  ON (e_detalletipoactividad.Id_TipoActividad = e_tipoactividad.Id) AND (e_eventonodeseado.Id_DetTipoActividad = e_detalletipoactividad.Id) INNER JOIN e_tipolesion  ON (e_eventonodeseado.Id_TipoLesion = e_tipolesion.Id) INNER JOIN e_parteafectada  ON (e_eventonodeseado.Id_ParteCAfectada = e_parteafectada.Id) WHERE (e_eventonodeseado.Id ='" + id + "') ";
                ResultSet rs = this.xconsultasbd.traerRs(sql);
                Throwable th = null;
                if (rs.next()) {
                    rs.first();
                    this.JTFN.setText(rs.getString(19));
                    this.JCBTipoEvento.setSelectedItem(rs.getString(1));
                    this.JCBClaseEvento.setSelectedItem(rs.getString(2));
                    this.JDFecha.setDate(rs.getDate(3));
                    this.JTFFHora.setText(rs.getString(4));
                    this.JCBTipoEmpresaEvento.setSelectedItem(rs.getString(5));
                    this.JTFFNEmpresaContr.setText(rs.getString(6));
                    if (rs.getInt(18) == 0) {
                        this.JRBEstaNo.setSelected(true);
                    } else {
                        this.JRBEstaSi.setSelected(true);
                    }
                    this.JCBUnidadNegocio.setSelectedItem(rs.getString(7));
                    this.JCBSupervisor.setSelectedItem(rs.getString(8));
                    this.JCBTipoActividad.setSelectedItem(rs.getString(9));
                    this.JCBDetalleTipoActividad.setSelectedItem(rs.getString(10));
                    this.JTPSitioEvento.setText(rs.getString(11));
                    this.JTPActividadEvento.setText(rs.getString(12));
                    this.JTPDetalleEventi.setText(rs.getString(13));
                    if (rs.getInt(14) == 0) {
                        this.JRBAlcoholNo.setSelected(true);
                    } else {
                        this.JRBAlcoholSi.setSelected(true);
                    }
                    if (rs.getInt(15) == 0) {
                        this.JRBViolenciaNo.setSelected(true);
                    } else {
                        this.JRBViolenciaSi.setSelected(true);
                    }
                    this.JCBPCuerpoAfectada.setSelectedItem(rs.getString(16));
                    this.JCBTipoLesion.setSelectedItem(rs.getString(17));
                    if (rs.getInt(20) == 1) {
                        this.JTFEstado.setText("ANULADO");
                    } else {
                        this.JTFEstado.setText("ACTIVO");
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
                this.xconsultasbd.cerrarConexionBd();
            } finally {
            }
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
