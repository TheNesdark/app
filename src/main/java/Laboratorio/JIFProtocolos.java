package Laboratorio;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.JTextFieldValidator;
import Utilidades.Metodos;
import com.genoma.plus.dao.impl.laboratorio.ProtocolosDAOImpl;
import com.genoma.plus.dao.laboratorio.ProtocolosDAO;
import com.genoma.plus.dto.laboratorio.ProtocolosDTO;
import com.genoma.plus.jpa.entities.ProtocolosxRefecenciaDTO;
import com.genoma.plus.jpa.service.ProtocolosxRefecenciaService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
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
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* JADX INFO: loaded from: GenomaP.jar:Laboratorio/JIFProtocolos.class */
public class JIFProtocolos extends JInternalFrame {
    private Object[] xdato;
    private DefaultTableModel xmodelo;
    private DefaultTableModel modeloTabla1;
    private String[] xidprotocolo;
    private String[] xidprocedimiento;
    private String[] xidtiporesultado;
    private String[] xidencabezado;
    private String[] xidtipomuestra;
    private int xesportable;
    private String xsql;
    private Long idProtocoloRango;
    private ProtocolosDAO xProtocolosDAO;
    private ProtocolosxRefecenciaDTO xProtocolosxRefecenciaDTO;
    private JButton BtnAdicionarR;
    private JComboBox JCBEncabezado;
    private JComboBox JCBTipoMuestra;
    private JComboBox JCBTipoResultado;
    private JCheckBox JCHAResultado;
    private JCheckBox JCHAplicaFormula;
    private JCheckBox JCHEstado;
    private JCheckBox JCHFiltro;
    private JCheckBox JCHResultadoU;
    private JCheckBox JChEstado;
    private JTextField JFTNombreRango;
    private JPanel JPIDatos;
    private JPanel JPIDatosBusqueda;
    private JPanel JPIDetalle;
    private JPanel JPIEdad;
    private JPanel JPIFemenino;
    private JPanel JPIFormula;
    private JPanel JPIMasculino;
    private JSpinner JSEdadM;
    private JSpinner JSEedadMx;
    private JScrollPane JSPDetalle;
    private JSpinner JSPMaximo;
    private JSpinner JSPMinimo;
    private JSpinner JSPNOrden;
    private JTabbedPane JTBDatos;
    private JTable JTBDetalle;
    private JTextField JTFAbreviatura;
    private JTextField JTFFMaximo;
    private JTextField JTFFMinimo;
    public JTextFieldValidator JTFF_VCostante;
    private JTextField JTFIdFormula;
    private JTextField JTFMMaximo;
    private JTextField JTFMMinimo;
    private JTextField JTFMaximoF;
    private JTextField JTFMaximoM;
    private JTextField JTFMinimoF;
    private JTextField JTFMinimoM;
    private JTextField JTFNombre;
    private JTextField JTFNombreBusqueda;
    private JTextField JTFUnidad;
    private JTextField JTFV2463;
    private JTextField JTFV4505;
    private JTable JTablaRangoEdad;
    private JTextArea TextComentario;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private final ProtocolosxRefecenciaService xProtocolosxRefecenciaService = (ProtocolosxRefecenciaService) Principal.contexto.getBean(ProtocolosxRefecenciaService.class);
    private ConsultasMySQL xct = new ConsultasMySQL();
    private Metodos xmt = new Metodos();
    private int xestado = 0;
    private int xaresultado = 1;
    private int xtiporesultado = 0;
    private int xaplicaformula = 0;
    private int xesResultadoU = 0;
    private boolean xlleno = false;
    private boolean xlleno1 = false;
    private boolean xestado1 = false;

    public JIFProtocolos() {
        initComponents();
        springStart();
        mNuevo();
    }

    public JIFProtocolos(Long idProtocolo) {
        initComponents();
        springStart();
        mNuevo();
        mCargarDatosTabla(idProtocolo);
    }

    private void springStart() {
        this.xProtocolosDAO = (ProtocolosDAOImpl) new ClassPathXmlApplicationContext(new String[]{"/recursos/applicationContext.xml"}).getBean("protocolosDAO");
    }

    /* JADX WARN: Type inference failed for: r3v152, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JPIDetalle = new JPanel();
        this.JPIDatosBusqueda = new JPanel();
        this.JTFNombreBusqueda = new JTextField();
        this.JCHFiltro = new JCheckBox();
        this.JSPDetalle = new JScrollPane();
        this.JTBDetalle = new JTable();
        this.JTBDatos = new JTabbedPane();
        this.JPIDatos = new JPanel();
        this.JTFNombre = new JTextField();
        this.JTFUnidad = new JTextField();
        this.JTFAbreviatura = new JTextField();
        this.JPIMasculino = new JPanel();
        this.JTFMMinimo = new JTextField();
        this.JTFMMaximo = new JTextField();
        this.JPIFemenino = new JPanel();
        this.JTFFMinimo = new JTextField();
        this.JTFFMaximo = new JTextField();
        this.JPIEdad = new JPanel();
        this.JSPMinimo = new JSpinner();
        this.JSPMaximo = new JSpinner();
        this.JSPNOrden = new JSpinner();
        this.JCHEstado = new JCheckBox();
        this.JCHAResultado = new JCheckBox();
        this.JCBTipoResultado = new JComboBox();
        this.JCHAplicaFormula = new JCheckBox();
        this.JCBEncabezado = new JComboBox();
        this.JTFIdFormula = new JTextField();
        this.JCBTipoMuestra = new JComboBox();
        this.JTFF_VCostante = new JTextFieldValidator();
        this.JTFV4505 = new JTextField();
        this.JTFV2463 = new JTextField();
        this.JCHResultadoU = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.TextComentario = new JTextArea();
        this.JPIFormula = new JPanel();
        this.jPanel2 = new JPanel();
        this.jScrollPane2 = new JScrollPane();
        this.JTablaRangoEdad = new JTable();
        this.BtnAdicionarR = new JButton();
        this.jPanel3 = new JPanel();
        this.jPanel1 = new JPanel();
        this.JSEdadM = new JSpinner();
        this.JSEedadMx = new JSpinner();
        this.JChEstado = new JCheckBox();
        this.jPanel4 = new JPanel();
        this.JTFMinimoM = new JTextField();
        this.JTFMaximoM = new JTextField();
        this.jPanel5 = new JPanel();
        this.JTFMinimoF = new JTextField();
        this.JTFMaximoF = new JTextField();
        this.JFTNombreRango = new JTextField();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("PROTOCOLO");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(null);
        setMinimumSize(null);
        setName("Protocolos");
        addInternalFrameListener(new InternalFrameListener() { // from class: Laboratorio.JIFProtocolos.1
            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFProtocolos.this.formInternalFrameClosing(evt);
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JPIDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JPIDatosBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Búsqueda Filtrada", 0, 0, new Font("Arial", 1, 13), Color.red));
        this.JTFNombreBusqueda.setFont(new Font("Arial", 1, 12));
        this.JTFNombreBusqueda.setToolTipText("");
        this.JTFNombreBusqueda.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFNombreBusqueda.addKeyListener(new KeyAdapter() { // from class: Laboratorio.JIFProtocolos.2
            public void keyTyped(KeyEvent evt) {
                JIFProtocolos.this.JTFNombreBusquedaKeyTyped(evt);
            }
        });
        this.JCHFiltro.setFont(new Font("Arial", 1, 12));
        this.JCHFiltro.setSelected(true);
        this.JCHFiltro.setText("Filtro");
        this.JCHFiltro.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocolos.3
            public void actionPerformed(ActionEvent evt) {
                JIFProtocolos.this.JCHFiltroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosBusquedaLayout = new GroupLayout(this.JPIDatosBusqueda);
        this.JPIDatosBusqueda.setLayout(JPIDatosBusquedaLayout);
        JPIDatosBusquedaLayout.setHorizontalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosBusquedaLayout.createSequentialGroup().addContainerGap().addComponent(this.JTFNombreBusqueda).addGap(18, 18, 18).addComponent(this.JCHFiltro).addContainerGap()));
        JPIDatosBusquedaLayout.setVerticalGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosBusquedaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFNombreBusqueda, -2, -1, -2).addComponent(this.JCHFiltro)));
        this.JSPDetalle.setBorder(BorderFactory.createTitledBorder((Border) null, "RESULTADO", 2, 0, new Font("Arial", 1, 14), Color.red));
        this.JTBDetalle.setFont(new Font("Arial", 1, 12));
        this.JTBDetalle.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTBDetalle.setRowHeight(25);
        this.JTBDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTBDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTBDetalle.setSelectionMode(0);
        this.JTBDetalle.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFProtocolos.4
            public void mouseClicked(MouseEvent evt) {
                JIFProtocolos.this.JTBDetalleMouseClicked(evt);
            }
        });
        this.JSPDetalle.setViewportView(this.JTBDetalle);
        GroupLayout JPIDetalleLayout = new GroupLayout(this.JPIDetalle);
        this.JPIDetalle.setLayout(JPIDetalleLayout);
        JPIDetalleLayout.setHorizontalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap().addGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosBusqueda, -1, -1, 32767).addComponent(this.JSPDetalle)).addContainerGap()));
        JPIDetalleLayout.setVerticalGroup(JPIDetalleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDetalleLayout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JPIDatosBusqueda, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalle, -2, 120, -2).addContainerGap()));
        this.JTBDatos.setForeground(new Color(0, 103, 0));
        this.JTBDatos.setFont(new Font("Arial", 1, 14));
        this.JTFNombre.setFont(new Font("Arial", 1, 12));
        this.JTFNombre.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFUnidad.setFont(new Font("Arial", 1, 12));
        this.JTFUnidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFAbreviatura.setFont(new Font("Arial", 1, 12));
        this.JTFAbreviatura.setBorder(BorderFactory.createTitledBorder((Border) null, "Abreviatura", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPIMasculino.setBorder(BorderFactory.createTitledBorder((Border) null, "Masculino", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFMMinimo.setFont(new Font("Arial", 1, 12));
        this.JTFMMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFMMaximo.setFont(new Font("Arial", 1, 12));
        this.JTFMMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIMasculinoLayout = new GroupLayout(this.JPIMasculino);
        this.JPIMasculino.setLayout(JPIMasculinoLayout);
        JPIMasculinoLayout.setHorizontalGroup(JPIMasculinoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIMasculinoLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTFMMinimo, -2, 70, -2).addGap(10, 10, 10).addComponent(this.JTFMMaximo, -2, 70, -2)));
        JPIMasculinoLayout.setVerticalGroup(JPIMasculinoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFMMinimo, -2, -1, -2).addComponent(this.JTFMMaximo, -2, -1, -2));
        this.JPIFemenino.setBorder(BorderFactory.createTitledBorder((Border) null, "Femenino", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFFMinimo.setFont(new Font("Arial", 1, 12));
        this.JTFFMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Mínimo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFMaximo.setFont(new Font("Arial", 1, 12));
        this.JTFFMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIFemeninoLayout = new GroupLayout(this.JPIFemenino);
        this.JPIFemenino.setLayout(JPIFemeninoLayout);
        JPIFemeninoLayout.setHorizontalGroup(JPIFemeninoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFemeninoLayout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.JTFFMinimo, -2, 70, -2).addGap(10, 10, 10).addComponent(this.JTFFMaximo, -2, 70, -2)));
        JPIFemeninoLayout.setVerticalGroup(JPIFemeninoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFMinimo, -2, -1, -2).addComponent(this.JTFFMaximo, -2, -1, -2));
        this.JPIEdad.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JSPMinimo.setFont(new Font("Arial", 1, 12));
        this.JSPMinimo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPMinimo.setBorder(BorderFactory.createTitledBorder((Border) null, "Mínima", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMaximo.setFont(new Font("Arial", 1, 12));
        this.JSPMaximo.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.JSPMaximo.setBorder(BorderFactory.createTitledBorder((Border) null, "Máximo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIEdadLayout = new GroupLayout(this.JPIEdad);
        this.JPIEdad.setLayout(JPIEdadLayout);
        JPIEdadLayout.setHorizontalGroup(JPIEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIEdadLayout.createSequentialGroup().addGap(2, 2, 2).addComponent(this.JSPMinimo, -2, 80, -2).addGap(20, 20, 20).addComponent(this.JSPMaximo, -2, 80, -2).addContainerGap(23, 32767)));
        JPIEdadLayout.setVerticalGroup(JPIEdadLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPMinimo, -2, 50, -2).addComponent(this.JSPMaximo, -2, 50, -2));
        this.JSPNOrden.setFont(new Font("Arial", 1, 12));
        this.JSPNOrden.setBorder(BorderFactory.createTitledBorder((Border) null, "Orden", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHEstado.setFont(new Font("Arial", 1, 12));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.setText("Estado");
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocolos.5
            public void actionPerformed(ActionEvent evt) {
                JIFProtocolos.this.JCHEstadoActionPerformed(evt);
            }
        });
        this.JCHAResultado.setFont(new Font("Arial", 1, 12));
        this.JCHAResultado.setSelected(true);
        this.JCHAResultado.setText("Aplica Resultado");
        this.JCHAResultado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocolos.6
            public void actionPerformed(ActionEvent evt) {
                JIFProtocolos.this.JCHAResultadoActionPerformed(evt);
            }
        });
        this.JCBTipoResultado.setFont(new Font("Arial", 1, 12));
        this.JCBTipoResultado.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Resultado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoResultado.addItemListener(new ItemListener() { // from class: Laboratorio.JIFProtocolos.7
            public void itemStateChanged(ItemEvent evt) {
                JIFProtocolos.this.JCBTipoResultadoItemStateChanged(evt);
            }
        });
        this.JCHAplicaFormula.setFont(new Font("Arial", 1, 12));
        this.JCHAplicaFormula.setSelected(true);
        this.JCHAplicaFormula.setText("Aplica Formula");
        this.JCHAplicaFormula.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocolos.8
            public void actionPerformed(ActionEvent evt) {
                JIFProtocolos.this.JCHAplicaFormulaActionPerformed(evt);
            }
        });
        this.JCBEncabezado.setFont(new Font("Arial", 1, 12));
        this.JCBEncabezado.setBorder(BorderFactory.createTitledBorder((Border) null, "Encabezado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFIdFormula.setFont(new Font("Arial", 1, 12));
        this.JTFIdFormula.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Formula", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTipoMuestra.setFont(new Font("Arial", 1, 12));
        this.JCBTipoMuestra.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo Muestra", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFF_VCostante.setBorder(BorderFactory.createTitledBorder((Border) null, "Costante", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFF_VCostante.setHorizontalAlignment(0);
        this.JTFF_VCostante.setText("0");
        this.JTFF_VCostante.setToolTipText("Valor costante para realizar calculo en formulas");
        this.JTFF_VCostante.setExprecionRegular("^[0.0-9]*$");
        this.JTFF_VCostante.setFocusAccelerator('C');
        this.JTFF_VCostante.setFont(new Font("Arial", 1, 12));
        this.JTFV4505.setFont(new Font("Arial", 1, 12));
        this.JTFV4505.setBorder(BorderFactory.createTitledBorder((Border) null, "V.4505", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFV2463.setFont(new Font("Arial", 1, 12));
        this.JTFV2463.setBorder(BorderFactory.createTitledBorder((Border) null, "V.2463", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCHResultadoU.setFont(new Font("Arial", 1, 12));
        this.JCHResultadoU.setText("Resultado Unificado?");
        this.JCHResultadoU.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocolos.9
            public void actionPerformed(ActionEvent evt) {
                JIFProtocolos.this.JCHResultadoUActionPerformed(evt);
            }
        });
        this.TextComentario.setColumns(20);
        this.TextComentario.setFont(new Font("Arial", 1, 12));
        this.TextComentario.setRows(5);
        this.TextComentario.setBorder(BorderFactory.createTitledBorder((Border) null, "Comentario", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.TextComentario);
        GroupLayout JPIDatosLayout = new GroupLayout(this.JPIDatos);
        this.JPIDatos.setLayout(JPIDatosLayout);
        JPIDatosLayout.setHorizontalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPIMasculino, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JPIFemenino, -2, -1, -2)).addComponent(this.JTFNombre)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFUnidad, -2, 110, -2).addGap(10, 10, 10).addComponent(this.JTFAbreviatura, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBTipoResultado, -2, 227, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JPIEdad, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JSPNOrden, -2, 89, -2).addGap(18, 18, 18).addComponent(this.JTFIdFormula, -2, 113, -2)).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFF_VCostante, -2, 90, -2).addGap(18, 18, 18).addComponent(this.JTFV4505, -2, 112, -2))))).addGap(45, 45, 45)).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JCBEncabezado, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JCBTipoMuestra, -2, 242, -2).addGap(330, 330, 330)).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFV2463, -2, 112, -2).addGap(18, 18, 18).addComponent(this.JCHAResultado).addGap(18, 18, 18).addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHAplicaFormula).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHResultadoU)).addComponent(this.jScrollPane1, -2, 806, -2)).addContainerGap(-1, 32767)))));
        JPIDatosLayout.setVerticalGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addComponent(this.JTFNombre, -2, 50, -2).addGap(14, 14, 14).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIFemenino, -1, -1, 32767).addComponent(this.JPIMasculino, -1, -1, 32767))).addGroup(JPIDatosLayout.createSequentialGroup().addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFUnidad).addComponent(this.JCBTipoResultado, -2, 50, -2).addComponent(this.JTFAbreviatura, GroupLayout.Alignment.TRAILING, -2, 50, -2)).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createSequentialGroup().addGap(27, 27, 27).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JSPNOrden, -2, 48, -2).addComponent(this.JTFIdFormula, -2, 50, -2))).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPIEdad, -2, -1, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEncabezado, -2, 50, -2).addComponent(this.JCBTipoMuestra, -2, 50, -2).addComponent(this.JTFF_VCostante, -2, 50, -2).addComponent(this.JTFV4505, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHAResultado).addComponent(this.JCHEstado).addComponent(this.JCHAplicaFormula).addComponent(this.JCHResultadoU)).addComponent(this.JTFV2463, -2, 51, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 92, 32767).addContainerGap()));
        this.JTBDatos.addTab("DATOS", this.JPIDatos);
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTablaRangoEdad.setFont(new Font("Arial", 1, 12));
        this.JTablaRangoEdad.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTablaRangoEdad.addMouseListener(new MouseAdapter() { // from class: Laboratorio.JIFProtocolos.10
            public void mouseClicked(MouseEvent evt) {
                JIFProtocolos.this.JTablaRangoEdadMouseClicked(evt);
            }
        });
        this.jScrollPane2.setViewportView(this.JTablaRangoEdad);
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jScrollPane2).addGap(1, 1, 1)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.jScrollPane2, -2, 123, -2).addContainerGap(-1, 32767)));
        this.BtnAdicionarR.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.BtnAdicionarR.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocolos.11
            public void actionPerformed(ActionEvent evt) {
                JIFProtocolos.this.BtnAdicionarRActionPerformed(evt);
            }
        });
        this.jPanel3.setBorder(BorderFactory.createTitledBorder(""));
        this.jPanel1.setBorder(BorderFactory.createTitledBorder((Border) null, "EDAD EN DIAS", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JSEdadM.setFont(new Font("Arial", 1, 12));
        this.JSEdadM.setModel(new SpinnerNumberModel());
        this.JSEdadM.setBorder(BorderFactory.createTitledBorder((Border) null, "Minima", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSEedadMx.setFont(new Font("Arial", 1, 12));
        this.JSEedadMx.setModel(new SpinnerNumberModel());
        this.JSEedadMx.setBorder(BorderFactory.createTitledBorder((Border) null, "Maxima", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.JSEdadM, -1, 100, 32767).addGap(18, 18, 18).addComponent(this.JSEedadMx, -2, 95, -2).addContainerGap()));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSEedadMx).addComponent(this.JSEdadM)).addContainerGap(8, 32767)));
        this.JChEstado.setFont(new Font("Arial", 1, 13));
        this.JChEstado.setSelected(true);
        this.JChEstado.setText("Estado");
        this.JChEstado.addActionListener(new ActionListener() { // from class: Laboratorio.JIFProtocolos.12
            public void actionPerformed(ActionEvent evt) {
                JIFProtocolos.this.JChEstadoActionPerformed(evt);
            }
        });
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "MASULINO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFMinimoM.setFont(new Font("Arial", 1, 12));
        this.JTFMinimoM.setBorder(BorderFactory.createTitledBorder((Border) null, "Minimo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFMaximoM.setFont(new Font("Arial", 1, 12));
        this.JTFMaximoM.setBorder(BorderFactory.createTitledBorder((Border) null, "Maximo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JTFMinimoM, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFMaximoM, -1, 80, 32767).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFMinimoM, -1, 44, 32767).addComponent(this.JTFMaximoM)).addContainerGap(-1, 32767)));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "FEMENINO", 2, 0, new Font("Arial", 1, 12), Color.red));
        this.JTFMinimoF.setFont(new Font("Arial", 1, 12));
        this.JTFMinimoF.setBorder(BorderFactory.createTitledBorder((Border) null, "Minimo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFMaximoF.setFont(new Font("Arial", 1, 12));
        this.JTFMaximoF.setBorder(BorderFactory.createTitledBorder((Border) null, "Maximo", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFMinimoF, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFMaximoF, -2, 78, -2).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGap(5, 5, 5).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFMinimoF, -1, 44, 32767).addComponent(this.JTFMaximoF))));
        this.JFTNombreRango.setFont(new Font("Arial", 1, 12));
        this.JFTNombreRango.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JFTNombreRango, -2, 627, -2).addContainerGap(-1, 32767)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, 32767).addComponent(this.jPanel4, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel5, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JChEstado).addGap(48, 48, 48)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JFTNombreRango).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -2, -1, -2).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel4, -2, 70, -2).addComponent(this.jPanel5, -2, -1, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.JChEstado).addGap(27, 27, 27)))).addGap(22, 22, 22)));
        GroupLayout JPIFormulaLayout = new GroupLayout(this.JPIFormula);
        this.JPIFormula.setLayout(JPIFormulaLayout);
        JPIFormulaLayout.setHorizontalGroup(JPIFormulaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormulaLayout.createSequentialGroup().addContainerGap().addGroup(JPIFormulaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.BtnAdicionarR, -1, -1, 32767).addComponent(this.jPanel3, -1, -1, 32767)).addContainerGap()));
        JPIFormulaLayout.setVerticalGroup(JPIFormulaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFormulaLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jPanel3, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.BtnAdicionarR, -2, 37, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, 140, -2).addContainerGap()));
        this.JTBDatos.addTab("VALORES DE REFERENCIA POR EDAD", this.JPIFormula);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTBDatos, -2, 862, -2).addComponent(this.JPIDetalle, -1, -1, 32767)).addGap(5, 5, 5)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTBDatos, -2, 398, -2).addGap(5, 5, 5).addComponent(this.JPIDetalle, -2, -1, -2).addContainerGap()));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        if (this.JCHEstado.isSelected()) {
            this.xestado = 0;
        } else {
            this.xestado = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHFiltroActionPerformed(ActionEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFNombreBusquedaKeyTyped(KeyEvent evt) {
        mCargarDatosTabla();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBDetalleMouseClicked(MouseEvent evt) {
        if (this.JTBDetalle.getSelectedRow() != -1) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 0).toString());
            this.JTFNombre.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 1).toString());
            this.JTFMMinimo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 2).toString());
            this.JTFMMaximo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 3).toString());
            this.JTFFMinimo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 4).toString());
            this.JTFFMaximo.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 5).toString());
            this.JSPMinimo.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 6).toString()));
            this.JSPMaximo.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 7).toString()));
            this.JTFUnidad.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 8).toString());
            this.JTFAbreviatura.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 9).toString());
            this.JSPNOrden.setValue(Integer.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 10).toString()));
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 11).toString()).booleanValue());
            this.JCHAResultado.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 12).toString()).booleanValue());
            if (this.JCHEstado.isSelected()) {
                this.xestado = 0;
            } else {
                this.xestado = 1;
            }
            if (this.JCHAResultado.isSelected()) {
                this.xaresultado = 1;
            } else {
                this.xaresultado = 0;
            }
            mBuscarTipoResultado(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 13).toString());
            this.JCHAplicaFormula.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 14).toString()).booleanValue());
            if (this.JCHAplicaFormula.isSelected()) {
                this.xaplicaformula = 1;
            } else {
                this.xaplicaformula = 0;
            }
            this.JCBEncabezado.setSelectedItem(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 15).toString());
            this.JTFIdFormula.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 16).toString());
            this.JCBTipoResultado.setSelectedItem(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 17).toString());
            this.JCBTipoMuestra.setSelectedItem(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 18).toString());
            this.JTFF_VCostante.setText("" + Double.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 19).toString()));
            this.JTFV4505.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 20).toString());
            this.JTFV2463.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 21).toString());
            this.JCHResultadoU.setSelected(Boolean.valueOf(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 22).toString()).booleanValue());
            if (this.JCHResultadoU.isSelected()) {
                this.xesResultadoU = 1;
            } else {
                this.xesResultadoU = 0;
            }
            if (this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 23).toString().equals("")) {
                this.TextComentario.setText(" ");
            } else {
                this.TextComentario.setText(this.xmodelo.getValueAt(this.JTBDetalle.getSelectedRow(), 23).toString());
            }
            mCargaProtocolosxRangos();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAResultadoActionPerformed(ActionEvent evt) {
        if (this.JCHAResultado.isSelected()) {
            this.xaresultado = 1;
        } else {
            this.xaresultado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBTipoResultadoItemStateChanged(ItemEvent evt) {
        if (this.xlleno && this.JCBTipoResultado.getSelectedIndex() != -1) {
            this.xtiporesultado = Integer.valueOf(this.xidtiporesultado[this.JCBTipoResultado.getSelectedIndex()]).intValue();
        } else {
            this.xtiporesultado = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHAplicaFormulaActionPerformed(ActionEvent evt) {
        if (this.JCHAplicaFormula.isSelected()) {
            this.xaplicaformula = 1;
        } else {
            this.xaplicaformula = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHResultadoUActionPerformed(ActionEvent evt) {
        if (this.JCHResultadoU.isSelected()) {
            this.xesResultadoU = 1;
        } else {
            this.xesResultadoU = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BtnAdicionarRActionPerformed(ActionEvent evt) {
        if (this.idProtocoloRango.equals(0)) {
            ProtocolosxRefecenciaDTO registro = ProtocolosxRefecenciaDTO.builder().idProtocolo(Long.valueOf(Principal.txtNo.getText())).nombre(this.JFTNombreRango.getText()).edadI(Integer.valueOf(this.JSEdadM.getValue().toString())).edadM(Integer.valueOf(this.JSEedadMx.getValue().toString())).vrMinM(this.JTFMinimoM.getText()).vrMaxM(this.JTFMaximoM.getText()).vrMinF(this.JTFMinimoF.getText()).vrMaxF(this.JTFMaximoF.getText()).estado(Boolean.valueOf(this.xestado1)).fecha(this.xmt.getFechaActual()).usuarioS(Principal.usuarioSistemaDTO.getLogin()).build();
            Long ProtocolosxRefecenciaService = this.xProtocolosxRefecenciaService.crearRegistro(registro);
            System.err.println("" + ProtocolosxRefecenciaService);
            mCargaProtocolosxRangos();
            return;
        }
        ProtocolosxRefecenciaDTO registro2 = ProtocolosxRefecenciaDTO.builder().id(this.idProtocoloRango).idProtocolo(Long.valueOf(Principal.txtNo.getText())).nombre(this.JFTNombreRango.getText()).edadI(Integer.valueOf(this.JSEdadM.getValue().toString())).edadM(Integer.valueOf(this.JSEedadMx.getValue().toString())).vrMinM(this.JTFMinimoM.getText()).vrMaxM(this.JTFMaximoM.getText()).vrMinF(this.JTFMinimoF.getText()).vrMaxF(this.JTFMaximoF.getText()).estado(Boolean.valueOf(this.xestado1)).build();
        Long ProtocolosxRefecenciaService2 = this.xProtocolosxRefecenciaService.crearRegistro(registro2);
        System.err.println("" + ProtocolosxRefecenciaService2);
        mCargaProtocolosxRangos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JChEstadoActionPerformed(ActionEvent evt) {
        if (this.JChEstado.isSelected()) {
            this.xestado1 = true;
        } else {
            this.xestado1 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTablaRangoEdadMouseClicked(MouseEvent evt) {
        this.idProtocoloRango = Long.valueOf(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 0).toString());
        this.JFTNombreRango.setText(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 2).toString());
        this.JSEdadM.setValue(Integer.valueOf(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 3).toString()));
        this.JSEedadMx.setValue(Integer.valueOf(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 4).toString()));
        this.JTFMinimoM.setText(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 5).toString());
        this.JTFMaximoM.setText(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 6).toString());
        this.JTFMinimoF.setText(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 7).toString());
        this.JTFMaximoF.setText(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 8).toString());
        this.JChEstado.setSelected(Boolean.valueOf(this.modeloTabla1.getValueAt(this.JTablaRangoEdad.getSelectedRow(), 9).toString()).booleanValue());
        if (this.JChEstado.isSelected()) {
            this.xestado1 = true;
        } else {
            this.xestado1 = false;
        }
    }

    public void mGrabar() {
        if (!this.JTFNombre.getText().isEmpty()) {
            if (this.JCBTipoResultado.getSelectedIndex() != -1) {
                if (this.JCBEncabezado.getSelectedIndex() != -1) {
                    int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        ProtocolosDTO e = new ProtocolosDTO();
                        e.setNbre(this.JTFNombre.getText());
                        e.setVrMinM(this.JTFMMinimo.getText());
                        e.setVrMaxM(this.JTFMMaximo.getText());
                        e.setVrMinF(this.JTFFMinimo.getText());
                        e.setVrMaxF(this.JTFFMaximo.getText());
                        e.setEdadIni(Integer.valueOf(this.JSPMinimo.getValue().toString()).intValue());
                        e.setEdadFin(Integer.valueOf(this.JSPMaximo.getValue().toString()).intValue());
                        e.setUnidad(this.JTFUnidad.getText());
                        e.setAbreviatura(this.JTFAbreviatura.getText());
                        e.setOrden(Integer.valueOf(this.JSPNOrden.getValue().toString()).intValue());
                        e.setEstado(this.xestado);
                        e.setAResultado(this.xaresultado);
                        e.setIdTipoResultado(this.xidtiporesultado[this.JCBTipoResultado.getSelectedIndex()]);
                        e.setAplicaFormula(this.xaplicaformula);
                        e.setIdSql(this.JTFIdFormula.getText());
                        e.setIdTEncabezado(this.xidencabezado[this.JCBEncabezado.getSelectedIndex()]);
                        e.setIdTipoMuestra(this.xidtipomuestra[this.JCBTipoMuestra.getSelectedIndex()]);
                        e.setExportable(this.xesportable);
                        e.setVCostante(Double.valueOf(this.JTFF_VCostante.getText()).doubleValue());
                        e.setV4505(this.JTFV4505.getText().toUpperCase());
                        e.setV2463(this.JTFV2463.getText().toUpperCase());
                        e.setResultadoUnificado(this.xesResultadoU);
                        e.setFecha(this.xmt.formatoAMDH24.format(this.xmt.getFechaActual()));
                        e.setComentario(this.TextComentario.getText());
                        if (!Principal.txtNo.getText().isEmpty()) {
                            e.setId(Long.valueOf(Principal.txtNo.getText()));
                            this.xProtocolosDAO.mUpdate(e);
                        } else {
                            String xIdProtocolo = this.xProtocolosDAO.mcreate_return_id(e);
                            Principal.txtNo.setText(xIdProtocolo);
                        }
                        mCargarDatosTabla();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un encabezado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBEncabezado.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de resultado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBTipoResultado.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "El nombre no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFNombre.requestFocus();
    }

    public void mNuevo() {
        Principal.mLimpiarDatosP();
        this.JTFNombre.setText("");
        this.JTFUnidad.setText("");
        this.JTFAbreviatura.setText("");
        this.JTFFMaximo.setText("");
        this.JTFFMinimo.setText("");
        this.JTFMMaximo.setText("");
        this.JTFMMinimo.setText("");
        this.JTFMinimoM.setText("");
        this.JTFMaximoM.setText("");
        this.JTFMinimoF.setText("");
        this.JTFMaximoF.setText("");
        this.JTFV4505.setText("");
        this.JTFV2463.setText("");
        this.JTFIdFormula.setText("0");
        this.JTFF_VCostante.setText("0");
        this.TextComentario.setText("");
        this.JSPMaximo.setValue(new Integer(120));
        this.JSPMinimo.setValue(new Integer(0));
        this.JSPNOrden.setValue(new Integer(0));
        this.JSEdadM.setValue(new Integer(0));
        this.JSEedadMx.setValue(new Integer(0));
        this.JCHEstado.setSelected(true);
        this.JCHResultadoU.setSelected(false);
        this.xesResultadoU = 0;
        this.xestado = 0;
        this.xaresultado = 1;
        this.xtiporesultado = 0;
        this.xaplicaformula = 0;
        this.JCHAplicaFormula.setSelected(false);
        mCargarDatosTabla();
        crearTablaProtocolosxRangos();
        this.JTFNombreBusqueda.setText("");
        this.JCHFiltro.setSelected(true);
        this.JCHAResultado.setSelected(true);
        this.JCBTipoResultado.removeAllItems();
        this.xidtiporesultado = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `l_tiporesultado` WHERE (`Vandera` =1 AND `Estado` =0) ORDER BY `Nbre` ASC", this.xidtiporesultado, this.JCBTipoResultado);
        this.JCBTipoResultado.setSelectedItem("-");
        this.xct.cerrarConexionBd();
        this.xidtipomuestra = this.xct.llenarCombo("SELECT Id, Nbre FROM l_tipomuestra WHERE (Estado =1) ORDER BY Nbre ASC", this.xidtipomuestra, this.JCBTipoMuestra);
        this.JCBTipoMuestra.setSelectedItem("NO APLICA");
        this.xct.cerrarConexionBd();
        this.JCBEncabezado.removeAllItems();
        this.xidencabezado = this.xct.llenarCombo("SELECT `Id` , `Nbre` FROM `l_tipo_encabezado` WHERE (`Estado` =1) ORDER BY `Nbre` ASC", this.xidencabezado, this.JCBEncabezado);
        this.JCBEncabezado.setSelectedItem("NO APLICA");
        this.xlleno = true;
        this.xestado1 = true;
        this.xct.cerrarConexionBd();
        this.JChEstado.setSelected(true);
        this.idProtocoloRango = 0L;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Nombre", "V/MinM", "V/MaxM", "V/MinF", "V/MaxF", "EdadI", "EdadF", "Unidad", "Abrev.", "N° Orden", "Estado", "AResultado", "ResultadoP", "AplicaF", "Encabezado", "Formula", "TipoResultado", "NTipoMuestra", "VCostante", "V4505", "V2463", "ResultadoUnificado", "Comentario"}) { // from class: Laboratorio.JIFProtocolos.13
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Long.class, Long.class, String.class, String.class, Long.class, Boolean.class, Boolean.class, Long.class, Boolean.class, String.class, String.class, String.class, String.class, Double.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTBDetalle.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTBDetalle.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(3).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(5).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(6).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(7).setPreferredWidth(20);
        this.JTBDetalle.getColumnModel().getColumn(8).setPreferredWidth(40);
        this.JTBDetalle.getColumnModel().getColumn(9).setPreferredWidth(40);
        this.JTBDetalle.getColumnModel().getColumn(10).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(10).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(11).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setPreferredWidth(10);
        this.JTBDetalle.getColumnModel().getColumn(12).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(12).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(13).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(14).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(15).setPreferredWidth(30);
        this.JTBDetalle.getColumnModel().getColumn(16).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(16).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(17).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(18).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setMinWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(19).setMaxWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(20).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(21).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(22).setPreferredWidth(0);
        this.JTBDetalle.getColumnModel().getColumn(23).setPreferredWidth(0);
    }

    private void mCargarDatosTabla() {
        mCrearModeloDatos();
        List<ProtocolosDTO> list = this.xProtocolosDAO.listProtocolos(this.JCHFiltro.isSelected(), this.JTFNombreBusqueda.getText());
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size(); x++) {
                this.xmodelo.addRow(this.xdato);
                this.xmodelo.setValueAt(list.get(x).getId(), x, 0);
                this.xmodelo.setValueAt(list.get(x).getNbre(), x, 1);
                this.xmodelo.setValueAt(list.get(x).getVrMinM(), x, 2);
                this.xmodelo.setValueAt(list.get(x).getVrMaxM(), x, 3);
                this.xmodelo.setValueAt(list.get(x).getVrMinF(), x, 4);
                this.xmodelo.setValueAt(list.get(x).getVrMaxF(), x, 5);
                this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getEdadIni()), x, 6);
                this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getEdadFin()), x, 7);
                this.xmodelo.setValueAt(list.get(x).getUnidad(), x, 8);
                this.xmodelo.setValueAt(list.get(x).getAbreviatura(), x, 9);
                this.xmodelo.setValueAt(Integer.valueOf(list.get(x).getOrden()), x, 10);
                if (list.get(x).getEstado() == 0) {
                    this.xmodelo.setValueAt(true, x, 11);
                } else {
                    this.xmodelo.setValueAt(false, x, 11);
                }
                if (list.get(x).getAResultado() == 1) {
                    this.xmodelo.setValueAt(true, x, 12);
                } else {
                    this.xmodelo.setValueAt(false, x, 12);
                }
                this.xmodelo.setValueAt(list.get(x).getId(), x, 13);
                if (list.get(x).getAplicaFormula() == 1) {
                    this.xmodelo.setValueAt(true, x, 14);
                } else {
                    this.xmodelo.setValueAt(false, x, 14);
                }
                this.xmodelo.setValueAt(list.get(x).getIdTEncabezado(), x, 15);
                this.xmodelo.setValueAt(list.get(x).getIdSql(), x, 16);
                this.xmodelo.setValueAt(list.get(x).getIdTipoResultado(), x, 17);
                this.xmodelo.setValueAt(list.get(x).getIdTipoMuestra(), x, 18);
                this.xmodelo.setValueAt(Double.valueOf(list.get(x).getVCostante()), x, 19);
                this.xmodelo.setValueAt(list.get(x).getV4505(), x, 20);
                this.xmodelo.setValueAt(list.get(x).getV2463(), x, 21);
                if (list.get(x).getResultadoUnificado() == 1) {
                    this.xmodelo.setValueAt(true, x, 22);
                } else {
                    this.xmodelo.setValueAt(false, x, 22);
                }
                this.xmodelo.setValueAt(list.get(x).getComentario(), x, 23);
            }
        }
    }

    private void mCargarDatosTabla(Long idProtocolo) {
        mCrearModeloDatos();
        try {
            ProtocolosDTO protocolosDTO = (ProtocolosDTO) Optional.ofNullable(this.xProtocolosDAO.findById(idProtocolo)).orElseThrow(() -> {
                return new IllegalArgumentException("Protocolo no encontrado");
            });
            Principal.txtNo.setText((String) Optional.ofNullable(protocolosDTO.getId()).map((v0) -> {
                return v0.toString();
            }).orElse(""));
            this.JTFNombre.setText((String) Optional.ofNullable(protocolosDTO.getNbre()).orElse(""));
            this.JTFMMinimo.setText((String) Optional.ofNullable(protocolosDTO.getVrMinM()).orElse(""));
            this.JTFMMaximo.setText((String) Optional.ofNullable(protocolosDTO.getVrMaxM()).orElse(""));
            this.JTFFMinimo.setText((String) Optional.ofNullable(protocolosDTO.getVrMinF()).orElse(""));
            this.JTFFMaximo.setText((String) Optional.ofNullable(protocolosDTO.getVrMaxF()).orElse(""));
            this.JSPMinimo.setValue(Optional.ofNullable(Integer.valueOf(protocolosDTO.getEdadIni())).orElse(0));
            this.JSPMaximo.setValue(Optional.ofNullable(Integer.valueOf(protocolosDTO.getEdadFin())).orElse(0));
            this.JTFUnidad.setText((String) Optional.ofNullable(protocolosDTO.getUnidad()).orElse(""));
            this.JTFAbreviatura.setText((String) Optional.ofNullable(protocolosDTO.getAbreviatura()).orElse(""));
            this.JSPNOrden.setValue(Optional.ofNullable(Integer.valueOf(protocolosDTO.getOrden())).orElse(0));
            this.xestado = protocolosDTO.getEstado() == 0 ? 0 : 1;
            this.JCHEstado.setSelected(this.xestado == 0);
            this.xaresultado = protocolosDTO.getAResultado() == 1 ? 1 : 0;
            this.JCHAResultado.setSelected(this.xaresultado == 1);
            mBuscarTipoResultado(protocolosDTO.getIdTipoResultado());
            this.xaplicaformula = protocolosDTO.getAplicaFormula() == 1 ? 1 : 0;
            this.JCHAplicaFormula.setSelected(this.xaplicaformula == 1);
            this.JCBEncabezado.setSelectedItem(protocolosDTO.getIdTEncabezado());
            this.JTFIdFormula.setText((String) Optional.ofNullable(protocolosDTO.getIdSql()).orElse(""));
            this.JCBTipoResultado.setSelectedItem(protocolosDTO.getIdTipoResultado());
            this.JCBTipoMuestra.setSelectedItem(protocolosDTO.getIdTipoMuestra());
            this.JTFF_VCostante.setText((String) Optional.ofNullable(Double.valueOf(protocolosDTO.getVCostante())).map((v0) -> {
                return String.valueOf(v0);
            }).orElse(""));
            this.JTFV4505.setText((String) Optional.ofNullable(protocolosDTO.getV4505()).orElse(""));
            this.JTFV2463.setText((String) Optional.ofNullable(protocolosDTO.getV2463()).map((v0) -> {
                return v0.toString();
            }).orElse(""));
            this.xesResultadoU = protocolosDTO.getResultadoUnificado() == 1 ? 1 : 0;
            this.JCHResultadoU.setSelected(this.xesResultadoU == 1);
            this.TextComentario.setText((String) Optional.ofNullable(protocolosDTO.getComentario()).orElse(" "));
            mCargaProtocolosxRangos();
        } catch (Exception e) {
            System.err.println("Error al cargar los datos del protocolo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void mBuscarTipoResultado(String xid) {
        try {
            ConsultasMySQL xct1 = new ConsultasMySQL();
            this.xsql = "SELECT `Nbre` FROM `l_tiporesultado` WHERE (`Id` ='" + xid + "') ";
            ResultSet xrs = xct1.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.first();
                this.JCBTipoResultado.setSelectedItem(xrs.getString(1));
            } else {
                this.JCBTipoResultado.setSelectedIndex(-1);
                this.xtiporesultado = 0;
            }
            xrs.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFProtocolos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargaProtocolosxRangos() {
        List<ProtocolosxRefecenciaDTO> listadoOrdenesS = this.xProtocolosxRefecenciaService.consultarProtocoloRango(Long.valueOf(Principal.txtNo.getText()));
        int numero = 0;
        this.jScrollPane2.remove(this.JTablaRangoEdad);
        this.jScrollPane2.setViewportView((Component) null);
        this.jScrollPane2.repaint();
        if (listadoOrdenesS.size() != -1) {
            this.xmt.mEstablecerTextEditor(this.JTablaRangoEdad, 3);
            this.xmt.mEstablecerTextEditor(this.JTablaRangoEdad, 5);
            for (int i = 0; i < listadoOrdenesS.size(); i++) {
                this.modeloTabla1.addRow(this.xdato);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getId(), i, 0);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getIdProtocolo(), i, 1);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getNombre(), i, 2);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getEdadI(), i, 3);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getEdadM(), i, 4);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getVrMinM(), i, 5);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getVrMaxM(), i, 6);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getVrMinF(), i, 7);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getVrMaxF(), i, 8);
                this.modeloTabla1.setValueAt(listadoOrdenesS.get(i).getEstado(), i, 9);
                numero++;
            }
            this.modeloTabla1.setRowCount(listadoOrdenesS.size());
            this.modeloTabla1.fireTableDataChanged();
        }
        this.jScrollPane2.setViewportView(this.JTablaRangoEdad);
        this.jScrollPane2.repaint();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearTablaProtocolosxRangos() {
        this.modeloTabla1 = new DefaultTableModel(new Object[0], new String[]{"id", "idprotocolo", "Nombre", "EdadI", "EdadM", "VrMinM", "getVrMaxM", "VrMinM", "getVrMaxF", "Estado"}) { // from class: Laboratorio.JIFProtocolos.14
            Class[] types = {Long.class, Long.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        JTable jTable = this.JTablaRangoEdad;
        JTable jTable2 = this.JTablaRangoEdad;
        jTable.setAutoResizeMode(0);
        this.JTablaRangoEdad.doLayout();
        this.JTablaRangoEdad.setModel(this.modeloTabla1);
        this.JTablaRangoEdad.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTablaRangoEdad.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTablaRangoEdad.getColumnModel().getColumn(2).setPreferredWidth(150);
        this.JTablaRangoEdad.getColumnModel().getColumn(3).setPreferredWidth(100);
        this.JTablaRangoEdad.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTablaRangoEdad.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTablaRangoEdad.getColumnModel().getColumn(6).setPreferredWidth(100);
        this.JTablaRangoEdad.getColumnModel().getColumn(7).setPreferredWidth(100);
        this.JTablaRangoEdad.getColumnModel().getColumn(8).setPreferredWidth(100);
        this.JTablaRangoEdad.getColumnModel().getColumn(9).setPreferredWidth(50);
    }
}
