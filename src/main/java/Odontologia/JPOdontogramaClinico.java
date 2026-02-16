package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JDConsentimientoInformado;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontogramaClinico.class */
public class JPOdontogramaClinico extends JPanel {
    private Object[] datos;
    private Object[] datosProcedimiento;
    private Object[] datosProcedimientoOtros;
    public DefaultTableModel modelo;
    public DefaultTableModel modeloProcedimiento;
    public DefaultTableModel modeloProcedimientoOtros;
    private JPPaletaConvenciones paletaConvenciones;
    private JPOdontogramaDientes JPOdontogramaDientes;
    private JPOdontogramaDientes JPOdontogramaDientesProcedimiento;
    private String numeroDiente;
    private String numeroCaras;
    private String[][] procedimiento;
    private String[][] procedimientoOtros;
    public String labelDiente;
    public String panelDiente;
    private JButton JBFinalizaTratramiento;
    private JButton JBTAdicionarProc;
    private JButton JBTAdicionarProcO;
    private JButton JBTBuscarProc;
    private JButton JBTBuscarProcOtros;
    public JComboBox JCBOProcedimiento;
    public JComboBox JCBProcedimiento;
    private JTextField JLDientesSanos;
    private JLabel JLEstadoT;
    private JPanel JPImOdontograma;
    private JPanel JPImOdontogramaProc;
    private JPanel JPOdontogramaI;
    private JPanel JPOdontogramaProcedimieto;
    private JPanel JPOtros;
    private JScrollPane JSPDetalleO;
    private JScrollPane JSPDetalleOProc;
    private JScrollPane JSPDetalleOProcOtros;
    private JPanel JSPPaleta;
    private JTextArea JTAObservacionProc;
    private JTextArea JTAObservacionProcO;
    public JTable JTDetalleO;
    private JTable JTDetalleProc;
    private JTable JTDetalleProcOtros;
    private JTextField JTFCavitacional;
    private JTextField JTFNoCavitacional;
    private JTextField JTFObsturados;
    private JTextField JTFObturados;
    private JTextField JTFPerdidos;
    private JTextField JTFPresentes;
    private JTextField JTFResultadoCOP;
    private JTabbedPane JTPDatos;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    public int tipo = 1;
    private ConsultasMySQL consultasMySql = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private long ladoGeneral = 0;
    public long controlFigura = 0;
    private int dienteGeneral = 0;
    private int numeroFilas = 0;
    private int filasProcedimiento = 0;
    private int filasProcedimientoOtros = 0;

    public JPOdontogramaClinico() {
        initComponents();
        cagarPanelesInicial();
        crearModeloTablaDX();
        crearModeloTablaProcedimiento();
        crearModeloTablaProcedimientoOtros();
        cargarDiagnosticosProcedimientos();
        verificarTratamiento();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ODONTOGRAMA TRATAMIENTO No. " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + " (" + clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta() + ")", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
    }

    /* JADX WARN: Type inference failed for: r3v145, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v81, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPOdontogramaI = new JPanel();
        this.JSPDetalleO = new JScrollPane();
        this.JTDetalleO = new JTable();
        this.JPImOdontograma = new JPanel();
        this.jPanel1 = new JPanel();
        this.JLDientesSanos = new JTextField();
        this.JTFPerdidos = new JTextField();
        this.JTFPresentes = new JTextField();
        this.JTFResultadoCOP = new JTextField();
        this.JTFCavitacional = new JTextField();
        this.JTFNoCavitacional = new JTextField();
        this.JTFObsturados = new JTextField();
        this.JPOdontogramaProcedimieto = new JPanel();
        this.JPImOdontogramaProc = new JPanel();
        this.JCBProcedimiento = new JComboBox();
        this.JSPDetalleOProc = new JScrollPane();
        this.JTDetalleProc = new JTable();
        this.JBTAdicionarProc = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.JTAObservacionProc = new JTextArea();
        this.JBFinalizaTratramiento = new JButton();
        this.JLEstadoT = new JLabel();
        this.JBTBuscarProc = new JButton();
        this.JTFObturados = new JTextField();
        this.JPOtros = new JPanel();
        this.JCBOProcedimiento = new JComboBox();
        this.JBTBuscarProcOtros = new JButton();
        this.JSPDetalleOProcOtros = new JScrollPane();
        this.JTDetalleProcOtros = new JTable();
        this.JBTAdicionarProcO = new JButton();
        this.jScrollPane3 = new JScrollPane();
        this.JTAObservacionProcO = new JTextArea();
        this.JSPPaleta = new JPanel();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ODONTOGRAMA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("jifOdontogramaClinico");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleO.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DIANÓSTICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleO.setFont(new Font("Arial", 1, 12));
        this.JTDetalleO.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleO.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleO.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleO.setSelectionMode(0);
        this.JTDetalleO.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontogramaClinico.1
            public void mouseClicked(MouseEvent evt) {
                JPOdontogramaClinico.this.JTDetalleOMouseClicked(evt);
            }
        });
        this.JTDetalleO.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontogramaClinico.2
            public void keyPressed(KeyEvent evt) {
                JPOdontogramaClinico.this.JTDetalleOKeyPressed(evt);
            }
        });
        this.JSPDetalleO.setViewportView(this.JTDetalleO);
        this.JPImOdontograma.setBackground(new Color(255, 255, 255));
        this.JPImOdontograma.addInputMethodListener(new InputMethodListener() { // from class: Odontologia.JPOdontogramaClinico.3
            public void caretPositionChanged(InputMethodEvent evt) {
                JPOdontogramaClinico.this.JPImOdontogramaCaretPositionChanged(evt);
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
            }
        });
        GroupLayout JPImOdontogramaLayout = new GroupLayout(this.JPImOdontograma);
        this.JPImOdontograma.setLayout(JPImOdontogramaLayout);
        JPImOdontogramaLayout.setHorizontalGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPImOdontogramaLayout.setVerticalGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 377, 32767));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN COP", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JLDientesSanos.setFont(new Font("Arial", 1, 15));
        this.JLDientesSanos.setHorizontalAlignment(0);
        this.JLDientesSanos.setText("0");
        this.JLDientesSanos.setBorder(BorderFactory.createTitledBorder((Border) null, "Dientes Sanos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JLDientesSanos.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.4
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JLDientesSanosActionPerformed(evt);
            }
        });
        this.JTFPerdidos.setFont(new Font("Arial", 1, 15));
        this.JTFPerdidos.setHorizontalAlignment(0);
        this.JTFPerdidos.setText("0");
        this.JTFPerdidos.setToolTipText("Perdidos por caries");
        this.JTFPerdidos.setBorder(BorderFactory.createTitledBorder((Border) null, "Dientes Perdidos Por Caries", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPerdidos.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.5
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JTFPerdidosActionPerformed(evt);
            }
        });
        this.JTFPresentes.setFont(new Font("Arial", 1, 15));
        this.JTFPresentes.setHorizontalAlignment(0);
        this.JTFPresentes.setText("0");
        this.JTFPresentes.setToolTipText("Total de dientes presentes");
        this.JTFPresentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Dientes Presentes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFPresentes.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.6
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JTFPresentesActionPerformed(evt);
            }
        });
        this.JTFResultadoCOP.setFont(new Font("Arial", 1, 15));
        this.JTFResultadoCOP.setHorizontalAlignment(0);
        this.JTFResultadoCOP.setText("0");
        this.JTFResultadoCOP.setToolTipText("Resultado COP-D/CEO-D");
        this.JTFResultadoCOP.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado COP-D/CEO-D", 0, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFResultadoCOP.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.7
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JTFResultadoCOPActionPerformed(evt);
            }
        });
        this.JTFCavitacional.setFont(new Font("Arial", 1, 15));
        this.JTFCavitacional.setHorizontalAlignment(0);
        this.JTFCavitacional.setText("0");
        this.JTFCavitacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Caries Cavitacional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFCavitacional.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.8
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JTFCavitacionalActionPerformed(evt);
            }
        });
        this.JTFNoCavitacional.setFont(new Font("Arial", 1, 15));
        this.JTFNoCavitacional.setHorizontalAlignment(0);
        this.JTFNoCavitacional.setText("0");
        this.JTFNoCavitacional.setBorder(BorderFactory.createTitledBorder((Border) null, "Caries No Cavitacional", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNoCavitacional.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.9
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JTFNoCavitacionalActionPerformed(evt);
            }
        });
        this.JTFObsturados.setFont(new Font("Arial", 1, 15));
        this.JTFObsturados.setHorizontalAlignment(0);
        this.JTFObsturados.setText("0");
        this.JTFObsturados.setBorder(BorderFactory.createTitledBorder((Border) null, "Obsturados Por Caries", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JTFPerdidos, -2, 179, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFObsturados, -1, 148, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFPresentes, -2, 131, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.JLDientesSanos, -2, 155, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFCavitacional).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNoCavitacional, -2, 149, -2))).addGap(18, 18, 18).addComponent(this.JTFResultadoCOP, -2, 148, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNoCavitacional, -1, 50, 32767).addComponent(this.JTFCavitacional).addComponent(this.JLDientesSanos)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFObsturados, -2, 50, -2).addComponent(this.JTFPerdidos).addComponent(this.JTFPresentes)).addContainerGap()).addGroup(jPanel1Layout.createSequentialGroup().addGap(24, 24, 24).addComponent(this.JTFResultadoCOP, -2, 62, -2).addContainerGap(-1, 32767)));
        GroupLayout JPOdontogramaILayout = new GroupLayout(this.JPOdontogramaI);
        this.JPOdontogramaI.setLayout(JPOdontogramaILayout);
        JPOdontogramaILayout.setHorizontalGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaILayout.createSequentialGroup().addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPImOdontograma, -1, -1, 32767).addGroup(JPOdontogramaILayout.createSequentialGroup().addComponent(this.JSPDetalleO, -2, 694, -2).addGap(0, 8, 32767))).addContainerGap()).addGroup(JPOdontogramaILayout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
        JPOdontogramaILayout.setVerticalGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaILayout.createSequentialGroup().addComponent(this.JPImOdontograma, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addGap(2, 2, 2).addComponent(this.JSPDetalleO, -2, 185, -2).addGap(14, 14, 14)));
        this.JTPDatos.addTab("DIAGNÓSTICO", this.JPOdontogramaI);
        this.JPImOdontogramaProc.setBackground(new Color(255, 255, 255));
        GroupLayout JPImOdontogramaProcLayout = new GroupLayout(this.JPImOdontogramaProc);
        this.JPImOdontogramaProc.setLayout(JPImOdontogramaProcLayout);
        JPImOdontogramaProcLayout.setHorizontalGroup(JPImOdontogramaProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
        JPImOdontogramaProcLayout.setVerticalGroup(JPImOdontogramaProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 340, 32767));
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPDetalleOProc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE  PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleProc.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProc.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleProc.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProc.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleProc.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontogramaClinico.10
            public void keyPressed(KeyEvent evt) {
                JPOdontogramaClinico.this.JTDetalleProcKeyPressed(evt);
            }
        });
        this.JSPDetalleOProc.setViewportView(this.JTDetalleProc);
        this.JBTAdicionarProc.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarProc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarProc.setText("Agregar");
        this.JBTAdicionarProc.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.11
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JBTAdicionarProcActionPerformed(evt);
            }
        });
        this.JTAObservacionProc.setColumns(1);
        this.JTAObservacionProc.setLineWrap(true);
        this.JTAObservacionProc.setRows(1);
        this.JTAObservacionProc.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane2.setViewportView(this.JTAObservacionProc);
        this.JBFinalizaTratramiento.setFont(new Font("Arial", 1, 12));
        this.JBFinalizaTratramiento.setIcon(new ImageIcon(getClass().getResource("/Imagenes/meta.png")));
        this.JBFinalizaTratramiento.setText("Finalizar Tratamiento");
        this.JBFinalizaTratramiento.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.12
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JBFinalizaTratramientoActionPerformed(evt);
            }
        });
        this.JLEstadoT.setFont(new Font("Arial", 1, 18));
        this.JLEstadoT.setForeground(Color.red);
        this.JLEstadoT.setHorizontalAlignment(0);
        this.JLEstadoT.setBorder(BorderFactory.createEtchedBorder());
        this.JBTBuscarProc.setFont(new Font("Arial", 1, 12));
        this.JBTBuscarProc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTBuscarProc.setToolTipText("Buscar Procedimientos");
        this.JBTBuscarProc.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.13
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JBTBuscarProcActionPerformed(evt);
            }
        });
        this.JTFObturados.setFont(new Font("Arial", 1, 15));
        this.JTFObturados.setHorizontalAlignment(0);
        this.JTFObturados.setBorder(BorderFactory.createTitledBorder((Border) null, "Obturados por caries", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFObturados.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.14
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JTFObturadosActionPerformed(evt);
            }
        });
        GroupLayout JPOdontogramaProcedimietoLayout = new GroupLayout(this.JPOdontogramaProcedimieto);
        this.JPOdontogramaProcedimieto.setLayout(JPOdontogramaProcedimietoLayout);
        JPOdontogramaProcedimietoLayout.setHorizontalGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPImOdontogramaProc, -1, -1, 32767).addGroup(JPOdontogramaProcedimietoLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPOdontogramaProcedimietoLayout.createSequentialGroup().addComponent(this.JTFObturados, -2, 150, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBFinalizaTratramiento, -2, 341, -2).addGap(4, 4, 4).addComponent(this.JLEstadoT, -2, 174, -2).addContainerGap(28, 32767)).addGroup(JPOdontogramaProcedimietoLayout.createSequentialGroup().addComponent(this.JCBProcedimiento, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JBTBuscarProc, -2, 48, -2).addGap(14, 14, 14)).addGroup(GroupLayout.Alignment.TRAILING, JPOdontogramaProcedimietoLayout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 355, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionarProc, -2, 297, -2).addContainerGap()))).addGroup(JPOdontogramaProcedimietoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleOProc)));
        JPOdontogramaProcedimietoLayout.setVerticalGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaProcedimietoLayout.createSequentialGroup().addComponent(this.JPImOdontogramaProc, -2, -1, -2).addGap(2, 2, 2).addGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBProcedimiento, -2, -1, -2).addComponent(this.JBTBuscarProc, -2, 44, -2)).addGap(3, 3, 3).addGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane2, -2, 0, 32767).addComponent(this.JBTAdicionarProc, -1, 35, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleOProc, -2, 148, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFObturados, -1, 48, 32767).addComponent(this.JBFinalizaTratramiento, -1, -1, 32767).addComponent(this.JLEstadoT, -1, -1, 32767)).addContainerGap()));
        this.JTPDatos.addTab("PROCEDIMIENTO", this.JPOdontogramaProcedimieto);
        this.JCBOProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBOProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBTBuscarProcOtros.setFont(new Font("Arial", 1, 12));
        this.JBTBuscarProcOtros.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTBuscarProcOtros.setToolTipText("Buscar CIE10");
        this.JBTBuscarProcOtros.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.15
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JBTBuscarProcOtrosActionPerformed(evt);
            }
        });
        this.JSPDetalleOProcOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE  PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleProcOtros.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProcOtros.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleProcOtros.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProcOtros.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleProcOtros.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontogramaClinico.16
            public void keyPressed(KeyEvent evt) {
                JPOdontogramaClinico.this.JTDetalleProcOtrosKeyPressed(evt);
            }
        });
        this.JSPDetalleOProcOtros.setViewportView(this.JTDetalleProcOtros);
        this.JBTAdicionarProcO.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarProcO.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarProcO.setText("Agregar");
        this.JBTAdicionarProcO.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontogramaClinico.17
            public void actionPerformed(ActionEvent evt) {
                JPOdontogramaClinico.this.JBTAdicionarProcOActionPerformed(evt);
            }
        });
        this.JTAObservacionProcO.setColumns(1);
        this.JTAObservacionProcO.setLineWrap(true);
        this.JTAObservacionProcO.setRows(1);
        this.JTAObservacionProcO.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setViewportView(this.JTAObservacionProcO);
        GroupLayout JPOtrosLayout = new GroupLayout(this.JPOtros);
        this.JPOtros.setLayout(JPOtrosLayout);
        JPOtrosLayout.setHorizontalGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPOtrosLayout.createSequentialGroup().addGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleOProcOtros).addGroup(GroupLayout.Alignment.LEADING, JPOtrosLayout.createSequentialGroup().addComponent(this.JCBOProcedimiento, 0, 606, 32767).addGap(18, 18, 18).addComponent(this.JBTBuscarProcOtros, -2, 48, -2))).addGap(24, 24, 24)).addGroup(JPOtrosLayout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 355, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarProcO, -2, 303, -2).addContainerGap(-1, 32767)))));
        JPOtrosLayout.setVerticalGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBOProcedimiento, -2, -1, -2).addComponent(this.JBTBuscarProcOtros, -2, 44, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionarProcO, -1, -1, 32767).addGroup(JPOtrosLayout.createSequentialGroup().addComponent(this.jScrollPane3, -2, -1, -2).addGap(0, 85, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleOProcOtros, -2, 189, -2).addGap(344, 344, 344)));
        this.JTPDatos.addTab("OTROS", this.JPOtros);
        this.JSPPaleta.setMinimumSize(new Dimension(100, 600));
        this.JSPPaleta.setPreferredSize(new Dimension(165, 600));
        GroupLayout JSPPaletaLayout = new GroupLayout(this.JSPPaleta);
        this.JSPPaleta.setLayout(JSPPaletaLayout);
        JSPPaletaLayout.setHorizontalGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 165, 32767));
        JSPPaletaLayout.setVerticalGroup(JSPPaletaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 655, 32767));
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.JSPPaleta, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatos)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPDatos).addGroup(layout.createSequentialGroup().addComponent(this.JSPPaleta, -2, 655, -2).addGap(0, 0, 32767)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleOKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGrid();
        }
    }

    public void eliminarFilaGrid() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar la fila seleccionada?") == 0) {
            this.modelo.removeRow(this.JTDetalleO.getSelectedRow());
            this.numeroFilas--;
            this.metodos.mostrarMensaje("Registro Eliminado");
        }
    }

    public void eliminarFilaGridProcedimiento() {
        if (this.metodos.getPregunta("Esta seguro de Eliminar la fila seleccionada?") == 0) {
            this.modeloProcedimiento.removeRow(this.JTDetalleProc.getSelectedRow());
            this.filasProcedimiento--;
            this.metodos.mostrarMensaje("Registro Eliminado");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleOMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarProcActionPerformed(ActionEvent evt) {
        adicionarTablaProcedimiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBFinalizaTratramientoActionPerformed(ActionEvent evt) {
        finalizarTratamiento();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleProcKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127) {
            eliminarFilaGridProcedimiento();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarProcActionPerformed(ActionEvent evt) {
        JDProcedimientosOdont x = new JDProcedimientosOdont(Principal.clasehistoriace.frmPrincipal, true, this, "procedimientos");
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarProcOtrosActionPerformed(ActionEvent evt) {
        JDProcedimientosOdont x = new JDProcedimientosOdont(Principal.clasehistoriace.frmPrincipal, true, this, "otros");
        x.setVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleProcOtrosKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarProcOActionPerformed(ActionEvent evt) {
        if (this.JCBOProcedimiento.getSelectedIndex() != -1) {
            if (this.procedimientoOtros[this.JCBOProcedimiento.getSelectedIndex()][1].equals("1")) {
                verificarConsentimientoInformado(this.procedimientoOtros[this.JCBOProcedimiento.getSelectedIndex()][0]);
            }
            this.modeloProcedimientoOtros.addRow(this.datosProcedimientoOtros);
            this.modeloProcedimientoOtros.setValueAt(this.procedimientoOtros[this.JCBOProcedimiento.getSelectedIndex()][0], this.filasProcedimientoOtros, 0);
            this.modeloProcedimientoOtros.setValueAt(this.JCBOProcedimiento.getSelectedItem(), this.filasProcedimientoOtros, 1);
            this.modeloProcedimientoOtros.setValueAt(this.JTAObservacionProcO.getText(), this.filasProcedimientoOtros, 2);
            this.modeloProcedimientoOtros.setValueAt(false, this.filasProcedimientoOtros, 3);
            this.filasProcedimientoOtros++;
            this.JCBOProcedimiento.setSelectedIndex(-1);
            this.JTAObservacionProcO.setText("");
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBOProcedimiento.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCavitacionalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNoCavitacionalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFObturadosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPerdidosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFPresentesActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JLDientesSanosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFResultadoCOPActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JPImOdontogramaCaretPositionChanged(InputMethodEvent evt) {
    }

    private void verificarConsentimientoInformado(String idProcedimiento) {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Se debe realizar el consentimiento informado al procedimiento seleccionado<b></p><html>", "CONSENTIMIENTO INFORMADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        JDConsentimientoInformado consentimientoInformado = new JDConsentimientoInformado(null, true, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString(), idProcedimiento, this, Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
        consentimientoInformado.setLocationRelativeTo(this);
        consentimientoInformado.setVisible(true);
    }

    private void cagarPanelesInicial() {
        mNuevo();
        crearModeloTablaDX();
        crearModeloTablaProcedimiento();
        crearModeloTablaProcedimientoOtros();
        cargarDiagnosticosProcedimientos();
        verificarTratamiento();
    }

    private void cargarDiagnosticosProcedimientos() {
        cargarDatosDx();
        traerDatosDientesDx();
        cargarDatosProcedimiento();
        traerDatosDientesProcSombra();
        traerDatosDientesProc();
        cargarDatosOtrosProcedimientos();
    }

    public BufferedImage createImage(JPanel panel) {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, 1);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        return bi;
    }

    private void mNuevo() {
        cargarPanelConvenciones();
        cargarPanelOdontograma();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaDX() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"IdDiente", "N°Diente", "Cara", "CIE10", "Diagnóstico", "IdTipoDx", "TipoDx", "Proceso", "Observacion", "Guardado?", "id"}) { // from class: Odontologia.JPOdontogramaClinico.18
            Class[] types = {Integer.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, true, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleO;
        JTable jTable2 = this.JTDetalleO;
        jTable.setAutoResizeMode(0);
        this.JTDetalleO.doLayout();
        this.JTDetalleO.setModel(this.modelo);
        this.JTDetalleO.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.JTDetalleO.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTDetalleO.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTDetalleO.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleO.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleO.getColumnModel().getColumn(7).setPreferredWidth(150);
        this.JTDetalleO.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalleO.getColumnModel().getColumn(9).setPreferredWidth(50);
        this.JTDetalleO.getColumnModel().getColumn(10).setPreferredWidth(50);
        this.numeroFilas = 0;
    }

    private void adicionarTablaDx() {
        if (this.paletaConvenciones.procedimientoPaleta.equals("") && this.paletaConvenciones.procedimientoPaleta == null) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una convención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.controlFigura == 1) {
            this.modelo.addRow(this.datos);
            this.modelo.setValueAt(Integer.valueOf(this.dienteGeneral), this.numeroFilas, 0);
            this.modelo.setValueAt(this.numeroDiente, this.numeroFilas, 1);
            this.modelo.setValueAt(this.numeroCaras, this.numeroFilas, 2);
            this.modelo.setValueAt("", this.numeroFilas, 3);
            this.modelo.setValueAt("", this.numeroFilas, 4);
            this.modelo.setValueAt("", this.numeroFilas, 5);
            this.modelo.setValueAt("", this.numeroFilas, 6);
            this.modelo.setValueAt(this.paletaConvenciones.procedimientoPaleta, this.numeroFilas, 7);
            this.modelo.setValueAt("", this.numeroFilas, 8);
            this.modelo.setValueAt(false, this.numeroFilas, 9);
            this.numeroFilas++;
            this.controlFigura = 0L;
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Diente", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaProcedimiento() {
        this.modeloProcedimiento = new DefaultTableModel(new Object[0], new String[]{"IdDiente", "N° Diente", "Cara", "Id", "Procedimiento", "Proceso", "Observación", "Realizado", "Fecha", "esObturacionCarie", "esPerdidoCarie"}) { // from class: Odontologia.JPOdontogramaClinico.19
            Class[] types = {Integer.class, Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, Integer.class, Integer.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTDetalleProc;
        JTable jTable2 = this.JTDetalleProc;
        jTable.setAutoResizeMode(0);
        this.JTDetalleProc.doLayout();
        this.JTDetalleProc.setModel(this.modeloProcedimiento);
        this.JTDetalleProc.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleProc.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(4).setPreferredWidth(200);
        this.JTDetalleProc.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(9).setPreferredWidth(100);
        this.JTDetalleProc.getColumnModel().getColumn(10).setPreferredWidth(100);
        this.filasProcedimiento = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaProcedimientoOtros() {
        this.modeloProcedimientoOtros = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Observación", "Realizado"}) { // from class: Odontologia.JPOdontogramaClinico.20
            Class[] types = {Integer.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleProcOtros.setModel(this.modeloProcedimientoOtros);
        this.JTDetalleProcOtros.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleProcOtros.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleProcOtros.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleProcOtros.getColumnModel().getColumn(1).setPreferredWidth(150);
        this.JTDetalleProcOtros.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.JTDetalleProcOtros.getColumnModel().getColumn(3).setPreferredWidth(3);
        this.filasProcedimientoOtros = 0;
    }

    private void adicionarTablaProcedimiento() {
        if (this.paletaConvenciones.procedimientoPaleta.equals("") && this.paletaConvenciones.procedimientoPaleta == null) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una convención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.controlFigura == 1) {
            if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                System.err.println("ggggg" + this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][0]);
                System.err.println("ggggg" + this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][1]);
                System.err.println("ggggg" + this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][2]);
                if (this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][1].equals("1")) {
                    verificarConsentimientoInformado(this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][0]);
                }
                int esPerdidoCarie = -1;
                int esObturadoCarie = -1;
                if (this.paletaConvenciones.procedimientoPaleta.equals("Amalgama Desadaptada") || this.paletaConvenciones.procedimientoPaleta.equals("Amalgama Buena") || this.paletaConvenciones.procedimientoPaleta.equals("Ionomero Bueno") || this.paletaConvenciones.procedimientoPaleta.equals("Ionomero Desadaptado") || this.paletaConvenciones.procedimientoPaleta.equals("Ionomero Indicado") || this.paletaConvenciones.procedimientoPaleta.equals("Resina Buena") || this.paletaConvenciones.procedimientoPaleta.equals("Resina Desadaptada") || this.paletaConvenciones.procedimientoPaleta.equals("Resina Indicada")) {
                    esObturadoCarie = this.JTDetalleO.getRowCount() > 0 ? this.JTDetalleO.getValueAt(this.JTDetalleO.getRowCount() - 1, 1).toString().equals(this.numeroDiente) ? Integer.valueOf(this.JTDetalleO.getValueAt(this.JTDetalleO.getRowCount() - 1, 5).toString()).intValue() : JOptionPane.showConfirmDialog((Component) null, "Es obturación por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0 : this.JTDetalleO.getValueAt(this.JTDetalleO.getRowCount() - 1, 1).toString().equals(this.numeroDiente) ? Integer.valueOf(this.JTDetalleO.getValueAt(this.JTDetalleO.getRowCount() - 1, 5).toString()).intValue() : JOptionPane.showConfirmDialog((Component) null, "Es obturación por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
                } else if (this.paletaConvenciones.procedimientoPaleta.equals("Extracciones - Diente Ausente Clinicamente") || this.paletaConvenciones.procedimientoPaleta.equals("Extraccion Indicada")) {
                    if (this.JTDetalleO.getRowCount() > 0) {
                        esPerdidoCarie = this.JTDetalleO.getValueAt(this.JTDetalleO.getRowCount() - 1, 1).toString().equals(this.numeroDiente) ? Integer.valueOf(this.JTDetalleO.getValueAt(this.JTDetalleO.getRowCount() - 1, 5).toString()).intValue() : JOptionPane.showConfirmDialog((Component) null, "Es perdida por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
                    } else if (this.paletaConvenciones.procedimientoPaleta.equals("Extracciones - Diente Ausente Clinicamente") || this.paletaConvenciones.procedimientoPaleta.equals("Extraccion Indicada")) {
                        esPerdidoCarie = JOptionPane.showConfirmDialog((Component) null, "Es perdida por caries?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0 ? 1 : 0;
                    }
                }
                this.modeloProcedimiento.addRow(this.datosProcedimiento);
                this.modeloProcedimiento.setValueAt(Integer.valueOf(this.dienteGeneral), this.filasProcedimiento, 0);
                this.modeloProcedimiento.setValueAt(this.numeroDiente, this.filasProcedimiento, 1);
                this.modeloProcedimiento.setValueAt(this.numeroCaras, this.filasProcedimiento, 2);
                this.modeloProcedimiento.setValueAt(this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][0], this.filasProcedimiento, 3);
                this.modeloProcedimiento.setValueAt(this.JCBProcedimiento.getSelectedItem(), this.filasProcedimiento, 4);
                this.modeloProcedimiento.setValueAt(this.paletaConvenciones.procedimientoPaleta, this.filasProcedimiento, 5);
                this.modeloProcedimiento.setValueAt(this.JTAObservacionProc.getText(), this.filasProcedimiento, 6);
                this.modeloProcedimiento.setValueAt(false, this.filasProcedimiento, 7);
                this.modeloProcedimiento.setValueAt(Integer.valueOf(esObturadoCarie), this.filasProcedimiento, 9);
                this.modeloProcedimiento.setValueAt(Integer.valueOf(esPerdidoCarie), this.filasProcedimiento, 10);
                this.filasProcedimiento++;
                this.controlFigura = 0L;
                limpiar();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un procedimiento", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBProcedimiento.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Diente", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontogramaClinico$MiRender.class */
    public class MiRender extends DefaultTableCellRenderer {
        public MiRender() {
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (Long.valueOf(table.getValueAt(row, 5).toString()).longValue() == 0) {
                cell.setBackground(new Color(255, 102, 0));
            } else {
                cell.setBackground(new Color(133, 218, 160));
            }
            return cell;
        }
    }

    private void cargarPanelConvenciones() {
        this.paletaConvenciones = new JPPaletaConvenciones(this);
        this.paletaConvenciones.setVisible(false);
        this.JSPPaleta.setVisible(false);
        this.paletaConvenciones.setBounds(1, 1, 165, 680);
        this.JSPPaleta.add(this.paletaConvenciones);
        this.JSPPaleta.setVisible(true);
        this.paletaConvenciones.setVisible(true);
    }

    private void cargarPanelOdontograma() {
        this.JPOdontogramaDientes = new JPOdontogramaDientes(this);
        this.JPOdontogramaDientes.setVisible(false);
        this.JPImOdontograma.setVisible(false);
        this.JPOdontogramaDientes.setBounds(1, 1, 699, 340);
        this.JPImOdontograma.add(this.JPOdontogramaDientes);
        this.JPImOdontograma.setVisible(true);
        this.JPOdontogramaDientes.setVisible(true);
        this.JPOdontogramaDientesProcedimiento = new JPOdontogramaDientes(this);
        this.JPOdontogramaDientesProcedimiento.setVisible(false);
        this.JPImOdontogramaProc.setVisible(false);
        this.JPOdontogramaDientesProcedimiento.setBounds(1, 1, 699, 340);
        this.JPImOdontogramaProc.add(this.JPOdontogramaDientesProcedimiento);
        this.JPImOdontogramaProc.setVisible(true);
        this.JPOdontogramaDientesProcedimiento.setVisible(true);
        this.JPOdontogramaDientesProcedimiento.Verde.setVisible(false);
        this.JPOdontogramaDientesProcedimiento.Amarillo.setVisible(false);
        this.JPOdontogramaDientesProcedimiento.Rojo.setVisible(false);
    }

    public void asignarFigura(JPanel panel, JLabel label) {
        if (this.controlFigura != 1) {
            if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 42.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 49.0d) {
                this.ladoGeneral = 6L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombra() || verificarProcedimientoLado(panel)) {
                        if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrePanel(panel, "6", this.paletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrePanel(panel, "6", this.paletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                    adicionarTablaDx();
                }
            } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 53.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 62.0d) {
                this.ladoGeneral = 7L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombra() || verificarProcedimientoLado(panel)) {
                        if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrePanel(panel, "7", this.paletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrePanel(panel, "7", this.paletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                    adicionarTablaDx();
                }
            } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() < 30.0d || Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() > 42.0d) {
                if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 24.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 29.0d) {
                    this.ladoGeneral = 2L;
                    traerDatosDientes(panel);
                    if (this.JTPDatos.getComponentAt(1).isVisible()) {
                        if (verificarSombra() || verificarProcedimientoLado(panel)) {
                            if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                                quitarElementoOdontograma(panel);
                            } else {
                                recorrePanel(panel, "2", this.paletaConvenciones.procedimientoPaleta);
                                this.controlFigura = 1L;
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                        quitarElementoOdontograma(panel);
                    } else {
                        recorrePanel(panel, "2", this.paletaConvenciones.procedimientoPaleta);
                        this.controlFigura = 1L;
                        adicionarTablaDx();
                    }
                } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 10.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 20.0d) {
                    this.ladoGeneral = 1L;
                    traerDatosDientes(panel);
                    if (this.JTPDatos.getComponentAt(1).isVisible()) {
                        if (verificarSombra() || verificarProcedimientoLado(panel)) {
                            if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                                quitarElementoOdontograma(panel);
                            } else {
                                recorrePanel(panel, "1", this.paletaConvenciones.procedimientoPaleta);
                                this.controlFigura = 1L;
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                        quitarElementoOdontograma(panel);
                    } else {
                        recorrePanel(panel, "1", this.paletaConvenciones.procedimientoPaleta);
                        this.controlFigura = 1L;
                        adicionarTablaDx();
                    }
                }
            } else if (panel.getMousePosition().x >= 23 && panel.getMousePosition().x <= 33) {
                this.ladoGeneral = 3L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombra() || verificarProcedimientoLado(panel)) {
                        if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrePanel(panel, "3", this.paletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrePanel(panel, "3", this.paletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                    adicionarTablaDx();
                }
            } else if (panel.getMousePosition().x >= 16 && panel.getMousePosition().x <= 22) {
                this.ladoGeneral = 4L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombra() || verificarProcedimientoLado(panel)) {
                        if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrePanel(panel, "4", this.paletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrePanel(panel, "4", this.paletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                    adicionarTablaDx();
                }
            } else if (panel.getMousePosition().x >= 0 && panel.getMousePosition().x <= 15) {
                this.ladoGeneral = 5L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombra() || verificarProcedimientoLado(panel)) {
                        if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrePanel(panel, "5", this.paletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.paletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrePanel(panel, "5", this.paletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                    adicionarTablaDx();
                }
            }
            pintaNumero(label);
            if (verificarProcedimientoLado(panel)) {
                System.out.println("Si tiene capa 8...");
            }
        }
    }

    public void pintaNumero(JLabel label) {
        if (this.JTPDatos.getSelectedIndex() == 0) {
            int lleno = 0;
            int vacio = 0;
            for (int i = 0; i < this.JTDetalleO.getRowCount(); i++) {
                if (this.modelo.getValueAt(i, 1).toString().equals(label.getText())) {
                    if (this.modelo.getValueAt(i, 3).toString().equals("")) {
                        vacio++;
                    } else {
                        lleno++;
                    }
                }
            }
            if (vacio == 0 && lleno > 0) {
                label.setBackground(new Color(0, 175, 8));
                label.setForeground(Color.WHITE);
            } else if (vacio > 0 && lleno > 0) {
                label.setBackground(new Color(249, 220, 32));
                label.setForeground(Color.BLACK);
            } else if (vacio > 0 && lleno == 0) {
                label.setBackground(Color.RED);
                label.setForeground(Color.WHITE);
            }
            label.setOpaque(true);
        }
    }

    private void recorrePanel(JPanel panel, String lado, String procedimiento) {
        String sql;
        try {
            if (this.paletaConvenciones.completo == 0) {
                sql = "SELECT  `o_odontograma_proceso`.`Id`  , `o_odontograma_proceso`.`Nbre` , `o_odontograma_proceso`.`Tipo`  , `o_odontograma_proceso`.`CGeneral` , `o_odontograma_figuras`.`Ruta` , `o_odontograma_figuras`.`Lado`  FROM `o_odontograma_figuras` INNER JOIN `o_odontograma_proceso`  ON (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_odontograma_proceso`.`Nbre` ='" + procedimiento + "' AND o_odontograma_figuras.Lado='" + lado + "')";
            } else {
                lado = "8";
                this.ladoGeneral = 8L;
                sql = "SELECT  `o_odontograma_proceso`.`Id`  , `o_odontograma_proceso`.`Nbre` , `o_odontograma_proceso`.`Tipo`  , `o_odontograma_proceso`.`CGeneral` , `o_odontograma_figuras`.`Ruta` , `o_odontograma_figuras`.`Lado`  FROM `o_odontograma_figuras` INNER JOIN `o_odontograma_proceso`  ON (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_odontograma_proceso`.`Nbre` ='" + procedimiento + "' AND o_odontograma_figuras.Lado='" + lado + "' AND o_odontograma_figuras.`Sombra`=0)";
            }
            System.out.println("datos que entran " + panel + "-" + lado + "-" + procedimiento + "sql: " + sql);
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                String ruta = this.metodos.getDirectorioExportacion() + resultSet.getString("Ruta").replace("\\", this.metodos.getBarra());
                int x = 0;
                while (true) {
                    if (x >= panel.getComponentCount()) {
                        break;
                    }
                    if (panel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                        JLabel label = panel.getComponent(x);
                        if (label.getName().equals(lado)) {
                            label.setIcon(new ImageIcon(ruta));
                            break;
                        }
                    }
                    x++;
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void quitarElementoOdontograma(JPanel panel) {
        for (int x = 0; x < panel.getComponentCount(); x++) {
            if (panel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                JLabel label = panel.getComponent(x);
                if (label.getName().equals(Long.valueOf(this.ladoGeneral).toString())) {
                    label.setIcon((Icon) null);
                    this.controlFigura = 0L;
                    return;
                }
            }
        }
    }

    public void llenaCombo() {
        if (this.paletaConvenciones.filtroCombo == 0) {
            String str = "SELECT  `o_odontograma_patologia`.`Id_Patología`, CONCAT(`o_odontograma_patologia`.`Id_Patología` ,' ' , `g_patologia`.`Nbre`) AS patologia  FROM `o_odontograma_patologia`  INNER JOIN `o_odontograma_proceso`  ON (`o_odontograma_patologia`.`IdProcesoOdon` = `o_odontograma_proceso`.`Id`) INNER JOIN `g_patologia`   ON (`o_odontograma_patologia`.`Id_Patología` = `g_patologia`.`Id`) WHERE (`o_odontograma_proceso`.`Nbre` ='" + this.paletaConvenciones.procedimientoPaleta + "')";
        }
    }

    public void llenaComboProcedimientos() {
        if (this.JTPDatos.getComponentAt(1).isVisible()) {
            this.JCBProcedimiento.removeAllItems();
            this.procedimiento = this.consultasMySql.llenarComboyLista("SELECT  g_procedimiento.`Id` , g_procedimiento.`Nbre`, IF(g_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL, FALSE, IF (`g_procedimientoxconsentimiento`.`Estado` = 1, TRUE , FALSE)) GeneraConsentimiento, esObturacion  FROM `g_procedimiento` LEFT JOIN `g_procedimientoxconsentimiento` ON (g_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)  AND(g_procedimientoxconsentimiento.`Estado`=1) AND (g_procedimiento.`EsOdontologico`=1) group by g_procedimiento.Id ORDER BY g_procedimiento.Nbre", this.procedimiento, this.JCBProcedimiento, 4);
            this.JCBProcedimiento.setSelectedIndex(-1);
        } else if (this.JTPDatos.getComponentAt(2).isVisible()) {
            this.JCBOProcedimiento.removeAllItems();
            this.procedimientoOtros = this.consultasMySql.llenarComboyLista("SELECT  g_procedimiento.`Id` , g_procedimiento.`Nbre`, IF(g_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL, FALSE, IF (`g_procedimientoxconsentimiento`.`Estado` = 1, TRUE , FALSE)) GeneraConsentimiento, esObturacion  FROM `g_procedimiento` LEFT JOIN `g_procedimientoxconsentimiento` ON (g_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)  AND(g_procedimientoxconsentimiento.`Estado`=1) AND (g_procedimiento.`EsOdontologico`=1) group by g_procedimiento.Id ORDER BY g_procedimiento.Nbre", this.procedimientoOtros, this.JCBOProcedimiento, 4);
            this.JCBOProcedimiento.setSelectedIndex(-1);
        }
    }

    private void traerDatosDientes(JPanel panel) {
        try {
            if (this.JTPDatos.getComponentAt(1).isVisible() && verificarProcedimientoLado(panel) && this.paletaConvenciones.completo == 1) {
                this.ladoGeneral = 8L;
            }
            if (this.paletaConvenciones.completo == 1) {
                this.ladoGeneral = 8L;
            }
            String sql = "SELECT  `o_odontograma_diente_cara`.`Id` , `o_odontograma_diente`.`Nbre` AS diente , `o_odontograma_caras`.`Nbre` AS cara FROM `o_odontograma_diente_cara` INNER JOIN `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_caras`   ON (`o_odontograma_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) WHERE (`o_odontograma_diente_cara`.`Lado` ='" + this.ladoGeneral + "'   AND `o_odontograma_diente`.`Nbre` ='" + panel.getName() + "')";
            System.out.println("trae Dato dientes: " + sql);
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                this.dienteGeneral = resultSet.getInt(1);
                this.numeroDiente = resultSet.getString(2);
                this.numeroCaras = resultSet.getString(3);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void traerDatosDientesDx() {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_dx`.`Proceso`  , `o_odontograma_figuras`.`Ruta` FROM `o_hc_tratamiento_dx` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_tratamiento_dx`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_tratamiento_dx`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND `o_odontograma_figuras`.`Sombra` =0  AND o_hc_tratamiento_dx.Estado=1)";
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                String var = "";
                while (resultSet.next()) {
                    for (int u = 0; u < this.JPOdontogramaDientes.getComponentCount(); u++) {
                        if (this.JPOdontogramaDientes.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel jpanel = this.JPOdontogramaDientes.getComponent(u);
                            if (jpanel.getName().equals(resultSet.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= jpanel.getComponentCount()) {
                                        break;
                                    }
                                    if (jpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel label = jpanel.getComponent(x);
                                        if (label.getName().equals(resultSet.getString(2))) {
                                            label.setIcon(new ImageIcon(this.metodos.getDirectorioExportacion() + resultSet.getString(4).replace("\\", this.metodos.getBarra())));
                                            var = jpanel.getName();
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                        if (!var.equals("") && this.JPOdontogramaDientes.getComponent(u).getClass().getName().equals("javax.swing.JLabel")) {
                            JLabel label2 = (JLabel) this.JPOdontogramaDientes.getComponent(u);
                            System.out.println("Label-->" + label2.getText() + " Panel-->" + var);
                            if (label2.getText().equals(var)) {
                                pintaNumero(label2);
                                var = "";
                            }
                        }
                    }
                    n++;
                }
            }
            resultSet.close();
            cargarDatosDx();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void traerDatosDientesProc() {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_procedimiento`.`Proceso`  , `o_odontograma_figuras`.`Ruta`  FROM `o_hc_tratamiento_procedimiento` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_tratamiento_procedimiento`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND `o_odontograma_figuras`.`Sombra` =0 AND o_hc_tratamiento_procedimiento.Estado=1)";
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                while (resultSet.next()) {
                    for (int u = 0; u < this.JPOdontogramaDientesProcedimiento.getComponentCount(); u++) {
                        if (this.JPOdontogramaDientesProcedimiento.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel jpanel = this.JPOdontogramaDientesProcedimiento.getComponent(u);
                            if (jpanel.getName().equals(resultSet.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= jpanel.getComponentCount()) {
                                        break;
                                    }
                                    if (jpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel label = jpanel.getComponent(x);
                                        if (label.getName().equals(resultSet.getString(2))) {
                                            label.setIcon(new ImageIcon(this.metodos.getDirectorioExportacion() + resultSet.getString(4).replace("\\", this.metodos.getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void traerDatosDientesProcSombra() {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_dx`.`Proceso`  , `o_odontograma_figuras`.`Ruta` FROM `o_hc_tratamiento_dx` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_tratamiento_dx`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_tratamiento_dx`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND `o_odontograma_figuras`.`Sombra` =1 AND (o_hc_tratamiento_dx.Id_Patologia IS NOT NULL OR o_hc_tratamiento_dx.Id_Patologia<>'') AND o_hc_tratamiento_dx.Estado=1)";
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                while (resultSet.next()) {
                    for (int u = 0; u < this.JPOdontogramaDientesProcedimiento.getComponentCount(); u++) {
                        if (this.JPOdontogramaDientesProcedimiento.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel jpanel = this.JPOdontogramaDientesProcedimiento.getComponent(u);
                            if (jpanel.getName().equals(resultSet.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= jpanel.getComponentCount()) {
                                        break;
                                    }
                                    if (jpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel label = jpanel.getComponent(x);
                                        if (label.getName().equals(resultSet.getString(2))) {
                                            label.setIcon(new ImageIcon(this.metodos.getDirectorioExportacion() + resultSet.getString(4).replace("\\", this.metodos.getBarra())));
                                            break;
                                        }
                                    }
                                    x++;
                                }
                            }
                        }
                    }
                    n++;
                }
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosDx() {
        String sql;
        try {
            crearModeloTablaDX();
            if (Principal.informacionIps.getNombreIps().equals("VALLE DEL SOL IPS S.A.S.") || Principal.informacionIps.getIdentificacion().equals("901119117")) {
                sql = "WITH maestra AS\n(\nSELECT\n\to_hc_tratamiento_dx.IdDienteCara,\n\to_odontograma_diente.Nbre,\n\to_odontograma_caras.Nbre nombreCara,\n\tIF(\n    o_hc_tratamiento_dx.Id_Patologia IS NULL,\n\t'',\n\to_hc_tratamiento_dx.Id_Patologia\n  ) AS Id_Patologia,\n\tIF(\n    g_patologia.Nbre IS NULL,\n\t'',\n\tg_patologia.Nbre\n  ) AS Patologia,\n\tIF(\n    o_hc_tratamiento_dx.Id_TipoDx IS NULL,\n\t'',\n\to_hc_tratamiento_dx.Id_TipoDx\n  ) AS Id_TipoDx,\n\tIF(\n    h_tipodiagnostico.Nbre IS NULL,\n\t'',\n\th_tipodiagnostico.Nbre\n  ) AS TipoDXNombre,\n\to_hc_tratamiento_dx.Proceso,\n\to_hc_tratamiento_dx.Observacion,\n\to_hc_tratamiento_dx.Estado,\n\to_hc_tratamiento_dx.Id,\n\to_hc_tratamiento_dx.esCavitacional,\n\to_hc_tratamiento_dx.esObturadoCarie,\n\to_hc_tratamiento_dx.esPerdidaCarie,\n\to_odontograma_diente.Id idDiente,\n\to_hc_tratamiento_dx.Id_Tratamiento,\n\toht.dientesSanos,\n\toht.cariesNoCavitacional,\n\toht.cariesCavitacional,\n\toht.obturadosPorCaries,\n\toht.perdidosPorCaries,\n\toht.totalDientesPresentes\nFROM\n\to_hc_tratamiento_dx\nINNER JOIN o_odontograma_diente_cara\n    ON\n\t(\n      o_hc_tratamiento_dx.IdDienteCara = o_odontograma_diente_cara.Id\n    )\nINNER JOIN o_odontograma_diente\n    ON\n\t(\n      o_odontograma_diente_cara.IdDiente = o_odontograma_diente.Id\n    )\nINNER JOIN o_odontograma_caras\n    ON\n\t(\n      o_odontograma_diente_cara.IdCara = o_odontograma_caras.Id\n    )\nINNER JOIN o_hc_tratamiento oht\n    ON\n\t(\n      oht.Id = o_hc_tratamiento_dx.Id_Tratamiento\n    )\nLEFT JOIN g_patologia\n    ON\n\t(\n      o_hc_tratamiento_dx.Id_Patologia = g_patologia.Id\n    )\nLEFT JOIN h_tipodiagnostico\n    ON\n\t(\n      o_hc_tratamiento_dx.Id_TipoDx = h_tipodiagnostico.Id\n    )\nWHERE\n\t(\n    o_hc_tratamiento_dx.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n\t\tAND o_hc_tratamiento_dx.Estado = 1\n  )\nGROUP BY\n\to_odontograma_diente.Nbre\nORDER BY\n\to_odontograma_diente.Nbre ASC),\ndetalleDientesSanos AS\n(\nSELECT\n\tCOUNT(d.Nbre) cantidadDientesSanos\nFROM\n\tmaestra d\nWHERE\n\td.Proceso IN ('Diente - Sano', 'Abrasion', 'Rotaciones y Migraciones')),\ntotalDientes AS\n(\nSELECT\n\tCOUNT(d.Nbre) totalDientesMarcados\nFROM\n\tmaestra d\nwhere\n\td.Proceso <> 'Diente - Semi-Incluido'\n and d.Proceso <> 'Diente - Incluido')\n  ,\ntotalDientesTratamiento AS\n(\nSELECT\n\tCOUNT(DISTINCT ood.Nbre) dienteTratamento\nFROM\n\to_hc_odontograma_inicial_proc ohoip\nINNER JOIN o_odontograma_diente_cara oodc\n    ON\n\t(oodc.Id = ohoip.IdDienteCara)\nINNER JOIN o_odontograma_diente ood\n    ON\n\t(oodc.IdDiente = ood.Id)\nLEFT JOIN maestra m\n    ON\n\t(m.Nbre = ood.Nbre)\nWHERE\n\tohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n\tAND m.Nbre IS NULL),\nperdidosPorCariesDx AS\n(\nSELECT\n\tDISTINCT\n  d.idDiente,\n\tCOUNT(d.idDiente) cantidad\nFROM\n\tmaestra d\nWHERE\n\td.esPerdidaCarie = 1),\nperdidosPorCariesProcedimiento AS\n(\nSELECT\n\tCOUNT(DISTINCT ood.Nbre) cantidad\nFROM\n\to_hc_odontograma_inicial_proc ohoip\nINNER JOIN o_odontograma_diente_cara oodc\n    ON\n\t(oodc.Id = ohoip.IdDienteCara)\nINNER JOIN o_odontograma_diente ood\n    ON\n\t(oodc.IdDiente = ood.Id)\nWHERE\n\tohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n\tAND ohoip.esPerdidaCarie = 1),\nperdidosPorCariesProcedimientoClinico AS\n(\nSELECT\n\tCOUNT(DISTINCT ood.Nbre) cantidad\nFROM\n\to_hc_tratamiento_procedimiento ohoip\nINNER JOIN o_odontograma_diente_cara oodc\n    ON\n\t(oodc.Id = ohoip.IdDienteCara)\nINNER JOIN o_odontograma_diente ood\n    ON\n\t(oodc.IdDiente = ood.Id)\nWHERE\n\t(\n    ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n\t\tAND ohoip.esPerdidaCarie = 1\n  )),\ndetalleCavitacional AS\n(\nSELECT\n\tDISTINCT\n  d.idDiente,\n\tIF(d.esCavitacional = 0,\n\t1,\n\t0) noCavitacional,\n\tIF(d.esCavitacional = 1,\n\t1,\n\t0) cavitacional,\n\td.esCavitacional\nFROM\n\tmaestra d\nWHERE\n\td.esCavitacional <> - 1),\ndetalleCavitacion AS\n(\nSELECT\n\tSUM(m.noCavitacional) noCavitacional,\n\tSUM(m.cavitacional) cavitacional\nFROM\n\tdetalleCavitacional m),\ndetalleObturadosCaries AS\n(\nSELECT\n\tDISTINCT\n  d.idDiente,\n\tCOUNT(d.idDiente) cantidad\nFROM\n\tmaestra d\nWHERE\n\td.esObturadoCarie = 1),\ndetalleObturadosCariesProcedimiento AS\n(\nSELECT\n\tCOUNT(DISTINCT ood.Nbre) cantidad\nFROM\n\to_hc_odontograma_inicial_proc ohoip\nINNER JOIN o_odontograma_diente_cara oodc\n    ON\n\t(oodc.Id = ohoip.IdDienteCara)\nINNER JOIN o_odontograma_diente ood\n    ON\n\t(oodc.IdDiente = ood.Id)\nWHERE\n\tohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n\tAND ohoip.esObturadoCarie = 1),\ndetalleObturadosCariesProcedimientoClinico AS\n(\nSELECT\n\tCOUNT(DISTINCT ood.Nbre) cantidad\nFROM\n\to_hc_tratamiento_procedimiento ohoip\nINNER JOIN o_odontograma_diente_cara oodc\n    ON\n\t(oodc.Id = ohoip.IdDienteCara)\nINNER JOIN o_odontograma_diente ood\n    ON\n\t(oodc.IdDiente = ood.Id)\nWHERE\n\t(\n    ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n\t\tAND ohoip.esObturadoCarie = 1\n  )),\ndientesPerdidos AS\n(\nSELECT\n\tCOUNT(d.Nbre) DientesPerdidos\nFROM\n\tmaestra d\nWHERE\n\td.Proceso IN (\n    'Extraccion Indicada',\n    'Extracciones - Diente Ausente Clinicamente',\n    'Extracciones - Diente Perdido por Trauma',\n    'Extraccion De Diente',\n    'Extracciones - Zona Desdentada Remplazada',\n    'Resto Radicular'  ))\nSELECT\n\tm2.IdDienteCara,\n\tm2.Nbre,\n\tm2.nombreCara,\n\tm2.Id_Patologia,\n\tm2.Patologia,\n\tm2.Id_TipoDx,\n\tm2.TipoDXNombre,\n\tm2.Proceso,\n\tm2.Observacion,\n\tm2.Id,\n\tm2.esCavitacional,\n\tm2.idDiente,\n\tm2.Id_Tratamiento,\n\tIF(\n    (\n      m2.cariesNoCavitacional IS NULL\n\t\tOR m2.cariesNoCavitacional = 0\n    ),\n\tIFNULL(d.noCavitacional, 0),\n\tm2.cariesNoCavitacional\n  ) noCavitacional,\n\tIF(\n    (\n      m2.cariesCavitacional IS NULL\n\t\tOR m2.cariesCavitacional = 0\n    ),\n\tIFNULL(d.cavitacional, 0),\n\tm2.cariesCavitacional\n  ) cavitacional,\n\tIF(\n    (\n      m2.dientesSanos IS NULL\n\t\tOR m2.dientesSanos = 0\n    ),\n\tIFNULL(s.cantidadDientesSanos, 0),\n\ts.cantidadDientesSanos\n  ) cantidadDientesSanos,\n\tIF(\n    (p.cantidad IS NULL\n\t\tOR p.cantidad = 0),\n\t0,\n\tp.cantidad\n  ) + IFNULL(pdx.cantidad, 0) + IFNULL(pdc.cantidad, 0) cantidadPerdidos,\n\tIF(\n    m2.totalDientesPresentes IS NULL\n\t\tOR m2.totalDientesPresentes = 0,\n\t\t(\n      (\n        IFNULL(t.dienteTratamento, 0) + IFNULL(m.totalDientesMarcados, 0) - IFNULL(dp.DientesPerdidos, 0)\n      ) - IFNULL(p.cantidad, 0)\n    ),\n\t\tm2.totalDientesPresentes\n  ) cantidadDientesPresentes,\n\tIF(\n    (\n      m2.obturadosPorCaries IS NULL\n\t\tOR m2.obturadosPorCaries = 0\n    ),\n\t(\n      IFNULL(pc.cantidad, 0) + IFNULL(opcp.cantidad, 0) + IFNULL(opcc.cantidad, 0)\n    ),\n\tm2.obturadosPorCaries\n  ) obturadosPorCaries,\n\t(\n    IF(\n      (\n        m2.cariesNoCavitacional IS NULL\n\t\tOR m2.cariesNoCavitacional = 0\n      ),\n\tIFNULL(d.noCavitacional, 0),\n\tm2.cariesNoCavitacional\n    ) + IF(\n      (\n        m2.cariesCavitacional IS NULL\n\t\tOR m2.cariesCavitacional = 0\n      ),\n\tIFNULL(d.cavitacional, 0),\n\tm2.cariesCavitacional\n    ) + IF(\n      (p.cantidad IS NULL\n\t\tOR p.cantidad = 0),\n\t0,\n\tp.cantidad\n    ) + IFNULL(pdx.cantidad, 0) + IFNULL(pdc.cantidad, 0) + IF(\n      (\n        m2.obturadosPorCaries IS NULL\n\t\tOR m2.obturadosPorCaries = 0\n      ),\n\t(\n        IFNULL(pc.cantidad, 0) + IFNULL(opcp.cantidad, 0) + IFNULL(opcc.cantidad, 0)\n      ),\n\tm2.obturadosPorCaries\n    )\n  ) totalCop\nFROM\n\tmaestra m2,\n\tdetalleDientesSanos s,\n\ttotalDientes m,\n\tdientesPerdidos dp,\n\ttotalDientesTratamiento t,\n\tdetalleCavitacion d,\n\tperdidosPorCariesProcedimiento p,\n\tperdidosPorCariesDx pdx,\n\tperdidosPorCariesProcedimientoClinico pdc,\n\tdetalleObturadosCaries pc,\n\tdetalleObturadosCariesProcedimiento opcp,\n\tdetalleObturadosCariesProcedimientoClinico opcc";
            } else {
                sql = "WITH maestra AS\n(SELECT\n  o_hc_tratamiento_dx.IdDienteCara,\n  o_odontograma_diente.Nbre,\n  o_odontograma_caras.Nbre nombreCara,\n  IF(\n    o_hc_tratamiento_dx.Id_Patologia IS NULL,\n    '',\n    o_hc_tratamiento_dx.Id_Patologia\n  ) AS Id_Patologia,\n  IF(\n    g_patologia.Nbre IS NULL,\n    '',\n    g_patologia.Nbre\n  ) AS Patologia,\n  IF(\n    o_hc_tratamiento_dx.Id_TipoDx IS NULL,\n    '',\n    o_hc_tratamiento_dx.Id_TipoDx\n  ) AS Id_TipoDx,\n  IF(\n    h_tipodiagnostico.Nbre IS NULL,\n    '',\n    h_tipodiagnostico.Nbre\n  ) AS TipoDXNombre,\n  o_hc_tratamiento_dx.Proceso,\n  o_hc_tratamiento_dx.Observacion,\n  o_hc_tratamiento_dx.Estado,\n  o_hc_tratamiento_dx.Id,\n  o_hc_tratamiento_dx.esCavitacional,\n  o_hc_tratamiento_dx.esObturadoCarie,\n  o_hc_tratamiento_dx.esPerdidaCarie,\n  o_odontograma_diente.Id idDiente,\n  o_hc_tratamiento_dx.Id_Tratamiento,\n  oht.dientesSanos,\n  oht.cariesNoCavitacional,\n  oht.cariesCavitacional,\n  oht.obturadosPorCaries,\n  oht.perdidosPorCaries,\n  oht.totalDientesPresentes\nFROM\n  o_hc_tratamiento_dx\n  INNER JOIN o_odontograma_diente_cara\n    ON (\n      o_hc_tratamiento_dx.IdDienteCara = o_odontograma_diente_cara.Id\n    )\n  INNER JOIN o_odontograma_diente\n    ON (\n      o_odontograma_diente_cara.IdDiente = o_odontograma_diente.Id\n    )\n  INNER JOIN o_odontograma_caras\n    ON (\n      o_odontograma_diente_cara.IdCara = o_odontograma_caras.Id\n    )\n  INNER JOIN o_hc_tratamiento oht\n    ON (\n      oht.Id = o_hc_tratamiento_dx.Id_Tratamiento\n    )\n  LEFT JOIN g_patologia\n    ON (\n      o_hc_tratamiento_dx.Id_Patologia = g_patologia.Id\n    )\n  LEFT JOIN h_tipodiagnostico\n    ON (\n      o_hc_tratamiento_dx.Id_TipoDx = h_tipodiagnostico.Id\n    )\nWHERE (\n    o_hc_tratamiento_dx.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n    AND o_hc_tratamiento_dx.Estado = 1\n  )\nGROUP BY o_odontograma_diente.Nbre\nORDER BY o_odontograma_diente.Nbre ASC),\ndetalleDientesSanos AS\n(SELECT\n  COUNT(d.Nbre) cantidadDientesSanos\nFROM\n  maestra d\nWHERE d.Proceso IN ('Diente - Sano', 'Abrasion')\n  AND d.Nbre NOT IN ('18', '28', '38', '48')),\ntotalDientes AS\n(SELECT\n  COUNT(d.Nbre) totalDientesMarcados\nFROM\n  maestra d\nWHERE d.Nbre NOT IN ('18', '28', '38', '48')),\ntotalDientesTratamiento AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) dienteTratamento\nFROM\n  o_hc_odontograma_inicial_proc ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id)\n  LEFT JOIN maestra m\n    ON (m.Nbre = ood.Nbre)\nWHERE ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n  AND ood.Nbre NOT IN ('18', '28', '38', '48')\n  AND m.Nbre IS NULL),\nperdidosPorCariesDx AS\n(SELECT DISTINCT\n  d.idDiente,\n  COUNT(d.idDiente) cantidad\nFROM\n  maestra d\nWHERE d.esPerdidaCarie = 1\n  AND d.Nbre NOT IN ('18', '28', '38', '48')),\nperdidosPorCariesProcedimiento AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) cantidad\nFROM\n  o_hc_odontograma_inicial_proc ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id)\nWHERE ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n  AND ood.Nbre NOT IN ('18', '28', '38', '48')\n  AND ohoip.esPerdidaCarie = 1),\nperdidosPorCariesProcedimientoClinico AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) cantidad\nFROM\n  o_hc_tratamiento_procedimiento ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id)\nWHERE (\n    ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n    AND ood.Nbre NOT IN ('18', '28', '38', '48')\n    AND ohoip.esPerdidaCarie = 1\n  )),\ndetalleCavitacional AS\n(SELECT DISTINCT\n  d.idDiente,\n  IF(d.esCavitacional = 0, 1, 0) noCavitacional,\n  IF(d.esCavitacional = 1, 1, 0) cavitacional,\n  d.esCavitacional\nFROM\n  maestra d\nWHERE d.esCavitacional <> - 1\n  AND d.Nbre NOT IN ('18', '28', '38', '48')),\ndetalleCavitacion AS\n(SELECT\n  SUM(m.noCavitacional) noCavitacional,\n  SUM(m.cavitacional) cavitacional\nFROM\n  detalleCavitacional m),\ndetalleObturadosCaries AS\n(SELECT DISTINCT\n  d.idDiente,\n  COUNT(d.idDiente) cantidad\nFROM\n  maestra d\nWHERE d.esObturadoCarie = 1\n  AND d.Nbre NOT IN ('18', '28', '38', '48')),\ndetalleObturadosCariesProcedimiento AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) cantidad\nFROM\n  o_hc_odontograma_inicial_proc ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id)\nWHERE ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n  AND ood.Nbre NOT IN ('18', '28', '38', '48')\n  AND ohoip.esObturadoCarie = 1),\ndetalleObturadosCariesProcedimientoClinico AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) cantidad\nFROM\n  o_hc_tratamiento_procedimiento ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id)\nWHERE (\n    ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'\n    AND ood.Nbre NOT IN ('18', '28', '38', '48')\n    AND ohoip.esObturadoCarie = 1\n  )),\ndientesPerdidos AS\n(SELECT\n  COUNT(d.Nbre) DientesPerdidos\nFROM\n  maestra d\nWHERE d.Proceso IN (\n    'Extraccion Indicada',\n    'Extracciones - Diente Ausente Clinicamente',\n    'Extracciones - Diente Perdido por Trauma',\n    'Extraccion De Diente',\n    'Extracciones - Zona Desdentada Remplazada',\n    'Resto Radicular'  )\n  AND d.Nbre NOT IN ('18', '28', '38', '48'))\nSELECT\n  m2.IdDienteCara,\n  m2.Nbre,\n  m2.nombreCara,\n  m2.Id_Patologia,\n  m2.Patologia,\n  m2.Id_TipoDx,\n  m2.TipoDXNombre,\n  m2.Proceso,\n  m2.Observacion,\n  m2.Id,\n  m2.esCavitacional,\n  m2.idDiente,\n  m2.Id_Tratamiento,\n  IF(\n    (\n      m2.cariesNoCavitacional IS NULL\n      OR m2.cariesNoCavitacional = 0\n    ),\n    IFNULL(d.noCavitacional, 0),\n    m2.cariesNoCavitacional\n  ) noCavitacional,\n  IF(\n    (\n      m2.cariesCavitacional IS NULL\n      OR m2.cariesCavitacional = 0\n    ),\n    IFNULL(d.cavitacional, 0),\n    m2.cariesCavitacional\n  ) cavitacional,\n  IF(\n    (\n      m2.dientesSanos IS NULL\n      OR m2.dientesSanos = 0\n    ),\n    IFNULL(s.cantidadDientesSanos, 0),\n    s.cantidadDientesSanos\n  ) cantidadDientesSanos,\n  IF(\n    (p.cantidad IS NULL\n      OR p.cantidad = 0),\n    0,\n    p.cantidad\n  ) + IFNULL(pdx.cantidad, 0) + IFNULL(pdc.cantidad, 0) cantidadPerdidos,\n  IF(\n    m2.totalDientesPresentes IS NULL\n    OR m2.totalDientesPresentes = 0,\n    (\n      (\n        IFNULL(t.dienteTratamento, 0) + IFNULL(m.totalDientesMarcados, 0) - IFNULL(dp.DientesPerdidos, 0)\n      ) - IFNULL(p.cantidad, 0)\n    ),\n    m2.totalDientesPresentes\n  ) cantidadDientesPresentes,\n  IF(\n    (\n      m2.obturadosPorCaries IS NULL\n      OR m2.obturadosPorCaries = 0\n    ),\n    (\n      IFNULL(pc.cantidad, 0) + IFNULL(opcp.cantidad, 0) + IFNULL(opcc.cantidad, 0)\n    ),\n    m2.obturadosPorCaries\n  ) obturadosPorCaries,\n  (\n    IF(\n      (\n        m2.cariesNoCavitacional IS NULL\n        OR m2.cariesNoCavitacional = 0\n      ),\n      IFNULL(d.noCavitacional, 0),\n      m2.cariesNoCavitacional\n    ) + IF(\n      (\n        m2.cariesCavitacional IS NULL\n        OR m2.cariesCavitacional = 0\n      ),\n      IFNULL(d.cavitacional, 0),\n      m2.cariesCavitacional\n    ) + IF(\n      (p.cantidad IS NULL\n        OR p.cantidad = 0),\n      0,\n      p.cantidad\n    ) + IFNULL(pdx.cantidad, 0) + IFNULL(pdc.cantidad, 0) + IF(\n      (\n        m2.obturadosPorCaries IS NULL\n        OR m2.obturadosPorCaries = 0\n      ),\n      (\n        IFNULL(pc.cantidad, 0) + IFNULL(opcp.cantidad, 0) + IFNULL(opcc.cantidad, 0)\n      ),\n      m2.obturadosPorCaries\n    )\n  ) totalCop\nFROM\n  maestra m2,\n  detalleDientesSanos s,\n  totalDientes m,\n  dientesPerdidos dp,\n  totalDientesTratamiento t,\n  detalleCavitacion d,\n  perdidosPorCariesProcedimiento p,\n  perdidosPorCariesDx pdx,\n  perdidosPorCariesProcedimientoClinico pdc,\n  detalleObturadosCaries pc,\n  detalleObturadosCariesProcedimiento opcp,\n  detalleObturadosCariesProcedimientoClinico opcc";
            }
            System.out.println("CONSULTA DE ODONTOLOGIA: \n" + sql);
            ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
            ResultSet consultaOdontogramaDientes = consultasMySql2.traerRs(sql);
            this.metodos.mEstablecerTextEditor(this.JTDetalleO, 4);
            if (consultaOdontogramaDientes.next()) {
                consultaOdontogramaDientes.first();
                this.JTFCavitacional.setText(consultaOdontogramaDientes.getString("cavitacional"));
                this.JTFNoCavitacional.setText(consultaOdontogramaDientes.getString("noCavitacional"));
                this.JTFPerdidos.setText(consultaOdontogramaDientes.getString("cantidadPerdidos"));
                this.JLDientesSanos.setText(consultaOdontogramaDientes.getString("cantidadDientesSanos"));
                this.JTFPresentes.setText(consultaOdontogramaDientes.getString("cantidadDientesPresentes"));
                this.JTFObturados.setText(consultaOdontogramaDientes.getString("obturadosPorCaries"));
                this.JTFObsturados.setText(consultaOdontogramaDientes.getString("obturadosPorCaries"));
                this.JTFResultadoCOP.setText(consultaOdontogramaDientes.getString("totalCop"));
                consultaOdontogramaDientes.beforeFirst();
                this.numeroFilas = 0;
            }
            cargarDatosTablaDx();
            consultaOdontogramaDientes.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosTablaDx() {
        try {
            crearModeloTablaDX();
            String sql = "WITH maestra AS\n(SELECT\n  o_hc_tratamiento_dx.IdDienteCara,\n  o_odontograma_diente.Nbre,\n  o_odontograma_caras.Nbre nombreCara,\n  IF(\n    o_hc_tratamiento_dx.Id_Patologia IS NULL,\n    '',\n    o_hc_tratamiento_dx.Id_Patologia\n  ) AS Id_Patologia,\n  IF(\n    g_patologia.Nbre IS NULL,\n    '',\n    g_patologia.Nbre\n  ) AS Patologia,\n  IF(\n    o_hc_tratamiento_dx.Id_TipoDx IS NULL,\n    '',\n    o_hc_tratamiento_dx.Id_TipoDx\n  ) AS Id_TipoDx,\n  IF(\n    h_tipodiagnostico.Nbre IS NULL,\n    '',\n    h_tipodiagnostico.Nbre\n  ) AS TipoDXNombre,\n  o_hc_tratamiento_dx.Proceso,\n  o_hc_tratamiento_dx.Observacion,\n  o_hc_tratamiento_dx.Estado,\n  o_hc_tratamiento_dx.Id,\n  o_hc_tratamiento_dx.esCavitacional,\n  o_hc_tratamiento_dx.esObturadoCarie,\n  o_hc_tratamiento_dx.esPerdidaCarie,\n  o_odontograma_diente.Id idDiente,\n  o_hc_tratamiento_dx.Id_Tratamiento,\n  oht.dientesSanos,\n  oht.cariesNoCavitacional,\n  oht.cariesCavitacional,\n  oht.obturadosPorCaries,\n  oht.perdidosPorCaries,\n  oht.totalDientesPresentes\nFROM\n  o_hc_tratamiento_dx\n  INNER JOIN o_odontograma_diente_cara\n    ON (\n      o_hc_tratamiento_dx.IdDienteCara = o_odontograma_diente_cara.Id\n    )\n  INNER JOIN o_odontograma_diente\n    ON (\n      o_odontograma_diente_cara.IdDiente = o_odontograma_diente.Id\n    )\n  INNER JOIN o_odontograma_caras\n    ON (\n      o_odontograma_diente_cara.IdCara = o_odontograma_caras.Id\n    )\n  INNER JOIN o_hc_tratamiento oht\n    ON (\n      oht.Id = o_hc_tratamiento_dx.Id_Tratamiento\n    )\n  LEFT JOIN g_patologia\n    ON (\n      o_hc_tratamiento_dx.Id_Patologia = g_patologia.Id\n    )\n  LEFT JOIN h_tipodiagnostico\n    ON (\n      o_hc_tratamiento_dx.Id_TipoDx = h_tipodiagnostico.Id\n    )\nWHERE (\n    o_hc_tratamiento_dx.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'    AND o_hc_tratamiento_dx.Estado = 1\n  )\nORDER BY o_odontograma_diente.Nbre ASC),\ndetalleDientesSanos AS\n(SELECT\n  COUNT(d.Nbre) cantidadDientesSanos\nFROM\n  maestra d\nWHERE d.Proceso = 'Diente - Sano' OR d.Proceso = 'Abrasion'\n  AND d.Nbre NOT IN ('18', '28', '38', '48')),\ntotalDientes AS\n(SELECT\n  COUNT(d.Nbre) totalDientesMarcados\nFROM\n  maestra d\nWHERE d.Nbre NOT IN ('18', '28', '38', '48') -- group by d.Nbre\n),\ntotalDientesTratamiento AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) dienteTratamento\nFROM\n  o_hc_odontograma_inicial_proc ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id)\n  LEFT JOIN maestra m\n    ON (m.Nbre = ood.Nbre)\nWHERE ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'  AND ood.Nbre NOT IN ('18', '28', '38', '48')\n  AND m.Nbre IS NULL),\nperdidosPorCariesDx AS\n(SELECT DISTINCT\n  d.idDiente,\n  COUNT(d.idDiente) cantidad\nFROM\n  maestra d\nWHERE d.esPerdidaCarie = 1\n  AND d.Nbre NOT IN ('18', '28', '38', '48')),\nperdidosPorCariesProcedimiento AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) cantidad\nFROM\n  o_hc_odontograma_inicial_proc ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id) --  LEFT JOIN maestra m ON (m.Nbre=ood.Nbre)\n WHERE ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'  AND ood.Nbre NOT IN ('18', '28', '38', '48')\n  AND ohoip.esPerdidaCarie = 1),\nperdidosPorCariesProcedimientoClinico AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) cantidad\nFROM\n  o_hc_tratamiento_procedimiento ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id) -- LEFT JOIN maestra m ON (m.Nbre=ood.Nbre)\n WHERE (\n    ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'    AND ood.Nbre NOT IN ('18', '28', '38', '48')\n    AND ohoip.esPerdidaCarie = 1\n  )),\ndetalleCavitacional AS\n(SELECT DISTINCT\n  d.idDiente,\n  IF(d.esCavitacional = 0, 1, 0) noCavitacional,\n  IF(d.esCavitacional = 1, 1, 0) cavitacional,\n  d.esCavitacional\nFROM\n  maestra d\nWHERE d.esCavitacional <> - 1\n  AND d.Nbre NOT IN ('18', '28', '38', '48')),\ndetalleCavitacion AS\n(SELECT\n  SUM(m.noCavitacional) noCavitacional,\n  SUM(m.cavitacional) cavitacional\nFROM\n  detalleCavitacional m),\ndetalleObturadosCaries AS\n(SELECT DISTINCT\n  d.idDiente,\n  COUNT(d.idDiente) cantidad\nFROM\n  maestra d\nWHERE d.esObturadoCarie = 1\n  AND d.Nbre NOT IN ('18', '28', '38', '48')),\ndetalleObturadosCariesProcedimiento AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) cantidad\nFROM\n  o_hc_odontograma_inicial_proc ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id) --  LEFT JOIN maestra m ON (m.Nbre=ood.Nbre)\n WHERE ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'  AND ood.Nbre NOT IN ('18', '28', '38', '48')\n  AND ohoip.esObturadoCarie = 1),\ndetalleObturadosCariesProcedimientoClinico AS\n(SELECT\n  COUNT(DISTINCT ood.Nbre) cantidad\nFROM\n  o_hc_tratamiento_procedimiento ohoip\n  INNER JOIN o_odontograma_diente_cara oodc\n    ON (oodc.Id = ohoip.IdDienteCara)\n  INNER JOIN o_odontograma_diente ood\n    ON (oodc.IdDiente = ood.Id) -- LEFT JOIN maestra m ON (m.Nbre=ood.Nbre)\n WHERE (\n    ohoip.Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'    AND ood.Nbre NOT IN ('18', '28', '38', '48')\n    AND ohoip.esObturadoCarie = 1\n  ))\nSELECT\n  m2.IdDienteCara,\n  m2.Nbre,\n  m2.nombreCara,\n  m2.Id_Patologia,\n  m2.Patologia,\n  m2.Id_TipoDx,\n  m2.TipoDXNombre,\n  m2.Proceso,\n  m2.Observacion,\n  m2.Id,\n  m2.esCavitacional,\n  m2.idDiente,\n  m2.Id_Tratamiento,\n  IF(\n    (\n      m2.cariesNoCavitacional IS NULL\n      OR m2.cariesNoCavitacional = 0\n    ),\n    IFNULL(d.noCavitacional, 0),\n    m2.cariesNoCavitacional\n  ) noCavitacional,\n  IF(\n    (\n      m2.cariesCavitacional IS NULL\n      OR m2.cariesCavitacional = 0\n    ),\n    IFNULL(d.cavitacional, 0),\n    m2.cariesCavitacional\n  ) cavitacional,\n  IF(\n    (\n      m2.dientesSanos IS NULL\n      OR m2.dientesSanos = 0\n    ),\n    IFNULL(s.cantidadDientesSanos, 0),\n    m2.dientesSanos\n  ) cantidadDientesSanos,\n  IF(\n    (p.cantidad IS NULL\n      OR p.cantidad = 0),\n    0,\n    p.cantidad\n  ) + IFNULL(pdx.cantidad, 0) + IFNULL(pdc.cantidad, 0) cantidadPerdidos,\n  IF(\n    m2.totalDientesPresentes IS NULL\n    OR m2.totalDientesPresentes = 0,\n    (\n      (\n        IFNULL(t.dienteTratamento, 0) + IFNULL(m.totalDientesMarcados, 0)\n      ) - IFNULL(p.cantidad, 0)\n    ),\n    m2.totalDientesPresentes\n  ) cantidadDientesPresentes,\n  IF(\n    (\n      m2.obturadosPorCaries IS NULL\n      OR m2.obturadosPorCaries = 0\n    ),\n    (\n      IFNULL(pc.cantidad, 0) + IFNULL(opcp.cantidad, 0) + IFNULL(opcc.cantidad, 0)\n    ),\n    m2.obturadosPorCaries\n  ) obturadosPorCaries,\n  (\n    IF(\n      (\n        m2.cariesNoCavitacional IS NULL\n        OR m2.cariesNoCavitacional = 0\n      ),\n      IFNULL(d.noCavitacional, 0),\n      m2.cariesNoCavitacional\n    ) + IF(\n      (\n        m2.cariesCavitacional IS NULL\n        OR m2.cariesCavitacional = 0\n      ),\n      IFNULL(d.cavitacional, 0),\n      m2.cariesCavitacional\n    ) + IF(\n      (p.cantidad IS NULL\n        OR p.cantidad = 0),\n      0,\n      p.cantidad\n    ) + IFNULL(pdx.cantidad, 0) + IFNULL(pdc.cantidad, 0) + IF(\n      (\n        m2.obturadosPorCaries IS NULL\n        OR m2.obturadosPorCaries = 0\n      ),\n      (\n        IFNULL(pc.cantidad, 0) + IFNULL(opcp.cantidad, 0) + IFNULL(opcc.cantidad, 0)\n      ),\n      m2.obturadosPorCaries\n    )\n  ) totalCop\nFROM\n  maestra m2,\n  detalleDientesSanos s,\n  totalDientes m,\n  totalDientesTratamiento t,\n  detalleCavitacion d,\n  perdidosPorCariesProcedimiento p,\n  perdidosPorCariesDx pdx,\n  perdidosPorCariesProcedimientoClinico pdc,\n  detalleObturadosCaries pc,\n  detalleObturadosCariesProcedimiento opcp,\n  detalleObturadosCariesProcedimientoClinico opcc";
            ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
            ResultSet consultaOdontogramaDientes = consultasMySql2.traerRs(sql);
            this.metodos.mEstablecerTextEditor(this.JTDetalleO, 4);
            if (consultaOdontogramaDientes.next()) {
                consultaOdontogramaDientes.first();
                consultaOdontogramaDientes.beforeFirst();
                this.numeroFilas = 0;
                while (consultaOdontogramaDientes.next()) {
                    this.modelo.addRow(this.datos);
                    this.modelo.setValueAt(Integer.valueOf(consultaOdontogramaDientes.getInt(1)), this.numeroFilas, 0);
                    this.modelo.setValueAt(Long.valueOf(consultaOdontogramaDientes.getLong(2)), this.numeroFilas, 1);
                    this.modelo.setValueAt(consultaOdontogramaDientes.getString(3), this.numeroFilas, 2);
                    this.modelo.setValueAt(consultaOdontogramaDientes.getString(4), this.numeroFilas, 3);
                    this.modelo.setValueAt(consultaOdontogramaDientes.getString(5), this.numeroFilas, 4);
                    this.modelo.setValueAt(consultaOdontogramaDientes.getString(6), this.numeroFilas, 5);
                    this.modelo.setValueAt(consultaOdontogramaDientes.getString(7), this.numeroFilas, 6);
                    this.modelo.setValueAt(consultaOdontogramaDientes.getString(8), this.numeroFilas, 7);
                    this.modelo.setValueAt(consultaOdontogramaDientes.getString(9), this.numeroFilas, 8);
                    this.modelo.setValueAt(Boolean.valueOf(consultaOdontogramaDientes.getBoolean(10)), this.numeroFilas, 9);
                    this.modelo.setValueAt(consultaOdontogramaDientes.getString("Id"), this.numeroFilas, 10);
                    this.numeroFilas++;
                }
            }
            consultaOdontogramaDientes.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void anular() {
        if (this.JTDetalleO.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular el registro seleccionado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String sql = "update o_hc_tratamiento_dx set Estado=0 where Id=" + this.JTDetalleO.getValueAt(this.JTDetalleO.getSelectedRow(), 10) + "";
                this.consultasMySql.ejecutaSQLUpdate(sql);
                Principal.clasehistoriace.xjifhistoriaclinica.JPIDetalleAtencion.removeAll();
                Principal.clasehistoriace.xjifhistoriaclinica.mCargarPanelHC();
            }
        }
    }

    private void cargarDatosProcedimiento() {
        try {
            crearModeloTablaProcedimiento();
            String sql = "SELECT  `o_hc_tratamiento_procedimiento`.`IdDienteCara` , `o_odontograma_diente`.`Nbre` , `o_odontograma_caras`.`Nbre` , `o_hc_tratamiento_procedimiento`.`IdProcedimiento` , `g_procedimiento`.`Nbre` , `o_hc_tratamiento_procedimiento`.`Proceso` , `o_hc_tratamiento_procedimiento`.`Observacion` , `o_hc_tratamiento_procedimiento`.`Estado`,  DATE_FORMAT(o_hc_tratamiento_procedimiento.`FechaR`,'%d-%m-%Y') Fecha, o_hc_tratamiento_procedimiento.esObturadoCarie, o_hc_tratamiento_procedimiento.esPerdidaCarie  FROM  `o_hc_tratamiento_procedimiento` INNER JOIN `o_odontograma_diente_cara`  ON (`o_hc_tratamiento_procedimiento`.`IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN  `o_odontograma_caras`   ON (`o_odontograma_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) INNER JOIN  `g_procedimiento`   ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`) WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND o_hc_tratamiento_procedimiento.Estado=1) ORDER BY `o_odontograma_diente`.`Nbre` ASC ";
            ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
            ResultSet resultSet2 = consultasMySql2.traerRs(sql);
            this.metodos.mEstablecerTextEditor(this.JTDetalleProc, 4);
            if (resultSet2.next()) {
                resultSet2.beforeFirst();
                this.filasProcedimiento = 0;
                while (resultSet2.next()) {
                    this.modeloProcedimiento.addRow(this.datosProcedimiento);
                    this.modeloProcedimiento.setValueAt(Integer.valueOf(resultSet2.getInt(1)), this.filasProcedimiento, 0);
                    this.modeloProcedimiento.setValueAt(Long.valueOf(resultSet2.getLong(2)), this.filasProcedimiento, 1);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString(3), this.filasProcedimiento, 2);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString(4), this.filasProcedimiento, 3);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString(5), this.filasProcedimiento, 4);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString(6), this.filasProcedimiento, 5);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString(7), this.filasProcedimiento, 6);
                    this.modeloProcedimiento.setValueAt(Boolean.valueOf(resultSet2.getBoolean(8)), this.filasProcedimiento, 7);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString("Fecha"), this.filasProcedimiento, 8);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString("esObturadoCarie"), this.filasProcedimiento, 9);
                    this.modeloProcedimiento.setValueAt(resultSet2.getString("esPerdidaCarie"), this.filasProcedimiento, 10);
                    this.filasProcedimiento++;
                }
            }
            resultSet2.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosOtrosProcedimientos() {
        try {
            crearModeloTablaProcedimientoOtros();
            String sql = "SELECT  `o_hc_tratamiento_procedimiento`.`IdProcedimiento` , `g_procedimiento`.`Nbre`  , o_hc_tratamiento_procedimiento.Observacion, o_hc_tratamiento_procedimiento.Estado  FROM `o_hc_tratamiento_procedimiento`   INNER JOIN `g_procedimiento`    ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`)   WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND o_hc_tratamiento_procedimiento.Tipo=1 AND o_hc_tratamiento_procedimiento.Estado=1) ORDER BY `g_procedimiento`.`Nbre`";
            ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
            ResultSet resultSet2 = consultasMySql2.traerRs(sql);
            this.metodos.mEstablecerTextEditor(this.JTDetalleProcOtros, 1);
            if (resultSet2.next()) {
                resultSet2.beforeFirst();
                this.filasProcedimientoOtros = 0;
                while (resultSet2.next()) {
                    this.modeloProcedimientoOtros.addRow(this.datosProcedimientoOtros);
                    this.modeloProcedimientoOtros.setValueAt(Integer.valueOf(resultSet2.getInt(1)), this.filasProcedimientoOtros, 0);
                    this.modeloProcedimientoOtros.setValueAt(resultSet2.getString(2), this.filasProcedimientoOtros, 1);
                    this.modeloProcedimientoOtros.setValueAt(resultSet2.getString(3), this.filasProcedimientoOtros, 2);
                    this.modeloProcedimientoOtros.setValueAt(Boolean.valueOf(resultSet2.getBoolean(4)), this.filasProcedimientoOtros, 3);
                    this.filasProcedimientoOtros++;
                }
            }
            resultSet2.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (!verificarTratamiento()) {
            if (!this.JTFPerdidos.getText().isEmpty()) {
                if (!this.JTFPresentes.getText().isEmpty()) {
                    int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (n == 0) {
                        if (this.JTPDatos.getComponentAt(0).isVisible()) {
                            String sql = "UPDATE o_hc_tratamiento\nSET  dientesSanos='" + this.JLDientesSanos.getText() + "', cariesNoCavitacional='" + this.JTFNoCavitacional.getText() + "', cariesCavitacional='" + this.JTFCavitacional.getText() + "', perdidosPorCaries='" + this.JTFPerdidos.getText() + "', totalDientesPresentes='" + this.JTFPresentes.getText() + "'\nWHERE Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "';";
                            System.out.println("consulta de Actulizacione de COP--> " + sql);
                            this.consultasMySql.ejecutarSQL(sql);
                            for (int y = 0; y < this.JTDetalleO.getRowCount(); y++) {
                                if (!Boolean.valueOf(this.modelo.getValueAt(y, 9).toString()).booleanValue() && this.modelo.getValueAt(y, 3).toString().equals("")) {
                                    String sql2 = "insert into o_hc_tratamiento_dx(`Id_Tratamiento` , `IdDienteCara` , Proceso,Observacion, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.modelo.getValueAt(y, 0) + "','" + this.modelo.getValueAt(y, 7) + "','" + this.modelo.getValueAt(y, 8) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    System.out.println("consulta de insercion " + sql2);
                                    this.consultasMySql.ejecutarSQL(sql2);
                                } else if (!Boolean.valueOf(this.modelo.getValueAt(y, 9).toString()).booleanValue() && !this.modelo.getValueAt(y, 3).toString().equals("")) {
                                    String sql3 = "insert into o_hc_tratamiento_dx(`Id_Tratamiento` , `IdDienteCara`  , `Id_Patologia` , `Id_TipoDx`, `fechaDiagnostico`, Proceso,Observacion, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.modelo.getValueAt(y, 0) + "','" + this.modelo.getValueAt(y, 3) + "','" + this.modelo.getValueAt(y, 5) + "', NOW(),'" + this.modelo.getValueAt(y, 7) + "','" + this.modelo.getValueAt(y, 8) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    System.out.println("consulta de insercion " + sql3);
                                    this.consultasMySql.ejecutarSQL(sql3);
                                } else if (Boolean.valueOf(this.modelo.getValueAt(y, 9).toString()).booleanValue() && !this.modelo.getValueAt(y, 3).toString().equals("")) {
                                    String sql4 = "UPDATE  `o_hc_tratamiento_dx` SET `Id_Patologia` = '" + this.modelo.getValueAt(y, 3) + "', `Id_TipoDx` = '" + this.modelo.getValueAt(y, 5) + "', fechaDiagnostico= NOW(), `Observacion` = '" + this.modelo.getValueAt(y, 8) + "', `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'  WHERE Id_Tratamiento = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND Estado=1 AND IdDienteCara='" + this.modelo.getValueAt(y, 0) + "';";
                                    System.out.println("consulta de Actulizacione de DX--> " + sql4);
                                    this.consultasMySql.ejecutarSQL(sql4);
                                }
                            }
                            cargarDatosDx();
                            cargarDatosProcedimiento();
                            traerDatosDientesProcSombra();
                            traerDatosDientesProc();
                            cargarDatosOtrosProcedimientos();
                        } else if (this.JTPDatos.getComponentAt(1).isVisible()) {
                            String sql5 = "UPDATE o_hc_tratamiento\nSET  obturadosPorCaries='" + this.JTFObturados.getText() + "'\nWHERE Id='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "';";
                            System.out.println("consulta de Actulizacione de COP--> " + sql5);
                            this.consultasMySql.ejecutarSQL(sql5);
                            for (int y2 = 0; y2 < this.JTDetalleProc.getRowCount(); y2++) {
                                if (!Boolean.valueOf(this.modeloProcedimiento.getValueAt(y2, 7).toString()).booleanValue()) {
                                    String sql6 = "insert into o_hc_tratamiento_procedimiento (`Id_Tratamiento` , `IdDienteCara`  , `IdProcedimiento` , `Proceso` , `Observacion`, Tipo,FechaR,idcita, esObturadoCarie, esPerdidaCarie,  `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.modeloProcedimiento.getValueAt(y2, 0) + "','" + this.modeloProcedimiento.getValueAt(y2, 3) + "','" + this.modeloProcedimiento.getValueAt(y2, 5) + "','" + this.modeloProcedimiento.getValueAt(y2, 6) + "','1','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita() + "','" + this.modeloProcedimiento.getValueAt(y2, 9) + "','" + this.modeloProcedimiento.getValueAt(y2, 10) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    System.out.println("consulta de insercion " + sql6);
                                    this.consultasMySql.ejecutarSQL(sql6);
                                    if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoTratamiento().longValue() == 1) {
                                    }
                                }
                            }
                            cargarDatosDx();
                            cargarDatosProcedimiento();
                            traerDatosDientesProcSombra();
                            traerDatosDientesProc();
                            cargarDatosOtrosProcedimientos();
                        } else if (this.JTPDatos.getComponentAt(2).isVisible()) {
                            for (int y3 = 0; y3 < this.JTDetalleProcOtros.getRowCount(); y3++) {
                                if (!Boolean.valueOf(this.modeloProcedimientoOtros.getValueAt(y3, 3).toString()).booleanValue()) {
                                    String sql7 = "insert into o_hc_tratamiento_procedimiento (`Id_Tratamiento` , `IdProcedimiento` , `Observacion`, Tipo,FechaR,idcita, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.modeloProcedimientoOtros.getValueAt(y3, 0) + "','" + this.modeloProcedimientoOtros.getValueAt(y3, 2) + "','1','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdCita() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    System.out.println("consulta de insercion " + sql7);
                                    this.consultasMySql.ejecutarSQL(sql7);
                                }
                            }
                            cargarDatosDx();
                            cargarDatosProcedimiento();
                            traerDatosDientesProcSombra();
                            traerDatosDientesProc();
                            cargarDatosOtrosProcedimientos();
                        }
                        if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoTratamiento().longValue() == 1) {
                            Principal.clasehistoriace.mCambiarEstadoHc(1);
                            Principal.clasehistoriace.mCambiarEstadoCita();
                            return;
                        }
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Por favor verifique el COP, total dientes presentes", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Por favor verifique el COP, Indicador Perdidos por caries", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        JOptionPane.showInternalMessageDialog(this, " No se puede Guardar la información \n Tratamiento Cerrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public boolean verificarSombra() {
        boolean existe = false;
        String sql = "SELECT `IdDienteCara` FROM `o_hc_tratamiento_dx` WHERE (`IdDienteCara` ='" + this.dienteGeneral + "' AND `Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND (Id_Patologia IS NOT NULL OR Id_Patologia<>'') AND Estado=1)";
        System.out.println("Este es la verificacion de la sombra:: " + sql);
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                existe = true;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existe;
    }

    public boolean verificarProcedimientoLado(JPanel panel) {
        boolean existevalor8 = false;
        String sql = "SELECT `o_odontograma_diente`.`Nbre`   , `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_dx`.`Id_Tratamiento` FROM `o_hc_tratamiento_dx` INNER JOIN `o_odontograma_diente_cara`  ON (`o_hc_tratamiento_dx`.`IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) WHERE (`o_odontograma_diente`.`Nbre` ='" + panel.getName() + "'  AND `o_odontograma_diente_cara`.`Lado` =8   AND `o_hc_tratamiento_dx`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "')";
        System.out.println("Este es la verificacion de capa 8: " + sql);
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                existevalor8 = true;
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existevalor8;
    }

    private void limpiar() {
        this.JCBProcedimiento.setSelectedIndex(-1);
        this.JTAObservacionProc.setText("");
    }

    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == 17) {
            System.out.println("Presionó Control");
        }
        System.out.println("Presionó " + evt.getKeyCode());
    }

    private void finalizarTratamiento() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de Finalizar el tratamiento?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            String sql = "UPDATE `o_hc_tratamiento`SET `FPFin`='" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "' , `Estado`=0 WHERE  `Id`= '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "'";
            System.out.println("consulta de insercion " + sql);
            this.consultasMySql.ejecutarSQL(sql);
            verificarTratamiento();
        }
    }

    private boolean verificarTratamiento() {
        boolean cerrado = false;
        String sql = "SELECT `Id` , `FPFin`  , `Estado` FROM `o_hc_tratamiento` WHERE (`Id` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "')";
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                if (resultSet.getLong(3) == 0) {
                    cerrado = true;
                }
            }
            if (!cerrado) {
                this.JLEstadoT.setText("ACTIVO");
                this.JBFinalizaTratramiento.setEnabled(true);
            } else {
                this.JLEstadoT.setText("CERRADO");
                this.JBFinalizaTratramiento.setEnabled(false);
            }
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontogramaClinico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return cerrado;
    }

    public void labelDiente(JLabel xlabel, JPanel jpanel) {
        System.out.println("Diente No--> " + xlabel.getText());
        if (labelDienteP(jpanel)) {
            JDPatologiasOdont pat = new JDPatologiasOdont(Principal.clasehistoriace.frmPrincipal, true, this, xlabel.getText(), xlabel);
            pat.setVisible(true);
        }
    }

    private boolean labelDienteP(JPanel xPane) {
        boolean existe = false;
        int x = 0;
        while (true) {
            if (x >= xPane.getComponentCount()) {
                break;
            }
            if (xPane.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                JLabel label = xPane.getComponent(x);
                if (!label.getName().equals("0") && label.getIcon() != null && Integer.valueOf(label.getName()).intValue() >= 1 && Integer.valueOf(label.getName()).intValue() <= 8) {
                    existe = true;
                    break;
                }
            }
            x++;
        }
        return existe;
    }
}
