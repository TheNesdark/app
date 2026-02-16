package Odontologia;

import Acceso.Principal;
import General.JIFBuscarPatologia;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.sgc.JDConsentimientoInformado;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
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

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontograma.class */
public class JPOdontograma extends JPanel {
    private Object[] datos;
    private Object[] datosProcedimiento;
    private Object[] datosProcedimientoOtros;
    public DefaultTableModel modelo;
    public DefaultTableModel modeloProcedimiento;
    public DefaultTableModel modeloProcedimientoOtros;
    private JPPaletaConvenciones jifpaletaConvenciones;
    private JPOdontogramaDientes jpodontogramaDientes;
    private JPOdontogramaDientes jpodontogramaDientesProcedimiento;
    private String numeroDientes;
    private String numeroCara;
    private String[] diagnostico;
    private String[] tipoDx;
    private String[][] procedimiento;
    private String[][] procedimientoOtros;
    public String labelDientes;
    public String panelDientes;
    private clasesHistoriaCE claseHistoriaClinica;
    private JIFBuscaProcedimientos buscarProcedimientos;
    private JButton JBFinalizaTratramiento;
    private JButton JBTAdicionar;
    private JButton JBTAdicionarProc;
    private JButton JBTAdicionarProcO;
    private JButton JBTBuscar;
    private JButton JBTBuscarProc;
    private JButton JBTBuscarProcOtros;
    public JComboBox JCBDx;
    public JComboBox JCBOProcedimiento;
    public JComboBox JCBProcedimiento;
    private JComboBox JCBTipoDx;
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
    private JTextArea JTAObservacionDx;
    private JTextArea JTAObservacionProc;
    private JTextArea JTAObservacionProcO;
    public JTable JTDetalleO;
    private JTable JTDetalleProc;
    private JTable JTDetalleProcOtros;
    public JTextField JTFCDxP;
    private JTabbedPane JTPDatos;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    public int tipo = 1;
    private ConsultasMySQL consultasMySql = new ConsultasMySQL();
    private Metodos metodos = new Metodos();
    private long ladoGeneral = 0;
    public long controlFigura = 0;
    private int idDienteGeneral = 0;
    private int numeroFilas = 0;
    private int filasProcedimiento = 0;
    private int filasProcedimientoOtros = 0;

    public JPOdontograma() {
        initComponents();
        mNuevo();
        crearModeloTablaDx();
        crearModeloTablaProcedimiento();
        crearModeloTablaProcedimientoOtros();
        cargarDxProcedimientos();
        verificarTratamiento();
        setBorder(BorderFactory.createTitledBorder((Border) null, "ODONTOGRAMA TRATAMIENTO No. " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + " (" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTipoCita() + ")", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
    }

    /* JADX WARN: Type inference failed for: r3v124, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v65, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JTPDatos = new JTabbedPane();
        this.JPOdontogramaI = new JPanel();
        this.JSPDetalleO = new JScrollPane();
        this.JTDetalleO = new JTable();
        this.JPImOdontograma = new JPanel();
        this.JCBDx = new JComboBox();
        this.JCBTipoDx = new JComboBox();
        this.JBTAdicionar = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacionDx = new JTextArea();
        this.JTFCDxP = new JTextField();
        this.JBTBuscar = new JButton();
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
        setName("jifOdontogramaG");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JSPDetalleO.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE DIANÓSTICOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleO.setFont(new Font("Arial", 1, 12));
        this.JTDetalleO.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleO.setRowHeight(25);
        this.JTDetalleO.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleO.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleO.setSelectionMode(0);
        this.JTDetalleO.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontograma.1
            public void mouseClicked(MouseEvent evt) {
                JPOdontograma.this.JTDetalleOMouseClicked(evt);
            }
        });
        this.JTDetalleO.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontograma.2
            public void keyPressed(KeyEvent evt) {
                JPOdontograma.this.JTDetalleOKeyPressed(evt);
            }
        });
        this.JSPDetalleO.setViewportView(this.JTDetalleO);
        this.JPImOdontograma.setBackground(new Color(255, 255, 255));
        GroupLayout JPImOdontogramaLayout = new GroupLayout(this.JPImOdontograma);
        this.JPImOdontograma.setLayout(JPImOdontogramaLayout);
        JPImOdontogramaLayout.setHorizontalGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 699, 32767));
        JPImOdontogramaLayout.setVerticalGroup(JPImOdontogramaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 364, 32767));
        this.JCBDx.setFont(new Font("Arial", 1, 12));
        this.JCBDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnósticos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCBTipoDx.setFont(new Font("Arial", 1, 12));
        this.JCBTipoDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo DX", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionar.setText("Agregar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontograma.3
            public void actionPerformed(ActionEvent evt) {
                JPOdontograma.this.JBTAdicionarActionPerformed(evt);
            }
        });
        this.JTAObservacionDx.setColumns(1);
        this.JTAObservacionDx.setLineWrap(true);
        this.JTAObservacionDx.setRows(1);
        this.JTAObservacionDx.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane1.setViewportView(this.JTAObservacionDx);
        this.JTFCDxP.setFont(new Font("Arial", 1, 12));
        this.JTFCDxP.setToolTipText("Digite el Código");
        this.JTFCDxP.setBorder(BorderFactory.createTitledBorder((Border) null, "Cie10", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JTFCDxP.addFocusListener(new FocusAdapter() { // from class: Odontologia.JPOdontograma.4
            public void focusLost(FocusEvent evt) {
                JPOdontograma.this.JTFCDxPFocusLost(evt);
            }
        });
        this.JTFCDxP.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontograma.5
            public void keyPressed(KeyEvent evt) {
                JPOdontograma.this.JTFCDxPKeyPressed(evt);
            }
        });
        this.JBTBuscar.setFont(new Font("Arial", 1, 12));
        this.JBTBuscar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTBuscar.setToolTipText("Buscar CIE10");
        this.JBTBuscar.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontograma.6
            public void actionPerformed(ActionEvent evt) {
                JPOdontograma.this.JBTBuscarActionPerformed(evt);
            }
        });
        GroupLayout JPOdontogramaILayout = new GroupLayout(this.JPOdontogramaI);
        this.JPOdontogramaI.setLayout(JPOdontogramaILayout);
        JPOdontogramaILayout.setHorizontalGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPImOdontograma, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JSPDetalleO, GroupLayout.Alignment.TRAILING).addGroup(JPOdontogramaILayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPOdontogramaILayout.createSequentialGroup().addComponent(this.JCBTipoDx, -2, 218, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 301, -2).addGap(18, 18, 18).addComponent(this.JBTAdicionar, -2, 116, -2)).addGroup(JPOdontogramaILayout.createSequentialGroup().addComponent(this.JTFCDxP, -2, 82, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDx, -2, 491, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTBuscar, -2, 48, -2))).addContainerGap(-1, 32767)));
        JPOdontogramaILayout.setVerticalGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaILayout.createSequentialGroup().addComponent(this.JPImOdontograma, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBDx, -2, 42, -2).addComponent(this.JTFCDxP, -2, -1, -2)).addComponent(this.JBTBuscar, -2, 44, -2)).addGap(3, 3, 3).addGroup(JPOdontogramaILayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBTipoDx, -2, 42, -2).addComponent(this.JBTAdicionar, -2, 44, -2).addComponent(this.jScrollPane1, -2, 42, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPDetalleO, -2, 188, -2).addGap(21, 21, 21)));
        this.JTPDatos.addTab("DIAGNÓSTICO", this.JPOdontogramaI);
        this.JPImOdontogramaProc.setBackground(new Color(255, 255, 255));
        GroupLayout JPImOdontogramaProcLayout = new GroupLayout(this.JPImOdontogramaProc);
        this.JPImOdontogramaProc.setLayout(JPImOdontogramaProcLayout);
        JPImOdontogramaProcLayout.setHorizontalGroup(JPImOdontogramaProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 699, 32767));
        JPImOdontogramaProcLayout.setVerticalGroup(JPImOdontogramaProcLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 340, 32767));
        this.JCBProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPDetalleOProc.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE  PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleProc.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProc.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleProc.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProc.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleProc.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontograma.7
            public void keyPressed(KeyEvent evt) {
                JPOdontograma.this.JTDetalleProcKeyPressed(evt);
            }
        });
        this.JSPDetalleOProc.setViewportView(this.JTDetalleProc);
        this.JBTAdicionarProc.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarProc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarProc.setText("Agregar");
        this.JBTAdicionarProc.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontograma.8
            public void actionPerformed(ActionEvent evt) {
                JPOdontograma.this.JBTAdicionarProcActionPerformed(evt);
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
        this.JBFinalizaTratramiento.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontograma.9
            public void actionPerformed(ActionEvent evt) {
                JPOdontograma.this.JBFinalizaTratramientoActionPerformed(evt);
            }
        });
        this.JLEstadoT.setFont(new Font("Arial", 1, 18));
        this.JLEstadoT.setForeground(Color.red);
        this.JLEstadoT.setHorizontalAlignment(0);
        this.JLEstadoT.setBorder(BorderFactory.createEtchedBorder());
        this.JBTBuscarProc.setFont(new Font("Arial", 1, 12));
        this.JBTBuscarProc.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTBuscarProc.setToolTipText("Buscar CIE10");
        this.JBTBuscarProc.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontograma.10
            public void actionPerformed(ActionEvent evt) {
                JPOdontograma.this.JBTBuscarProcActionPerformed(evt);
            }
        });
        GroupLayout JPOdontogramaProcedimietoLayout = new GroupLayout(this.JPOdontogramaProcedimieto);
        this.JPOdontogramaProcedimieto.setLayout(JPOdontogramaProcedimietoLayout);
        JPOdontogramaProcedimietoLayout.setHorizontalGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPImOdontogramaProc, -1, -1, 32767).addGroup(JPOdontogramaProcedimietoLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPDetalleOProc, -1, 684, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPOdontogramaProcedimietoLayout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 355, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTAdicionarProc, -2, 297, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPOdontogramaProcedimietoLayout.createSequentialGroup().addComponent(this.JBFinalizaTratramiento, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLEstadoT, -2, 174, -2).addGap(8, 8, 8)).addGroup(JPOdontogramaProcedimietoLayout.createSequentialGroup().addComponent(this.JCBProcedimiento, 0, -1, 32767).addGap(18, 18, 18).addComponent(this.JBTBuscarProc, -2, 48, -2).addGap(14, 14, 14))).addContainerGap()));
        JPOdontogramaProcedimietoLayout.setVerticalGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOdontogramaProcedimietoLayout.createSequentialGroup().addComponent(this.JPImOdontogramaProc, -2, -1, -2).addGap(2, 2, 2).addGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBProcedimiento, -2, -1, -2).addComponent(this.JBTBuscarProc, -2, 44, -2)).addGap(3, 3, 3).addGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jScrollPane2, -2, 0, 32767).addComponent(this.JBTAdicionarProc, -1, 35, 32767)).addGap(4, 4, 4).addComponent(this.JSPDetalleOProc, -2, 172, -2).addGap(3, 3, 3).addGroup(JPOdontogramaProcedimietoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JBFinalizaTratramiento, -2, 31, -2).addComponent(this.JLEstadoT, -2, 31, -2))));
        this.JTPDatos.addTab("PROCEDIMIENTO", this.JPOdontogramaProcedimieto);
        this.JCBOProcedimiento.setFont(new Font("Arial", 1, 12));
        this.JCBOProcedimiento.setBorder(BorderFactory.createTitledBorder((Border) null, "Procedimientos", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBTBuscarProcOtros.setFont(new Font("Arial", 1, 12));
        this.JBTBuscarProcOtros.setIcon(new ImageIcon(getClass().getResource("/Imagenes/lupa.png")));
        this.JBTBuscarProcOtros.setToolTipText("Buscar CIE10");
        this.JBTBuscarProcOtros.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontograma.11
            public void actionPerformed(ActionEvent evt) {
                JPOdontograma.this.JBTBuscarProcOtrosActionPerformed(evt);
            }
        });
        this.JSPDetalleOProcOtros.setBorder(BorderFactory.createTitledBorder((Border) null, "DETALLE  PROCEDIMIENTOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 0, 255)));
        this.JTDetalleProcOtros.setFont(new Font("Arial", 1, 12));
        this.JTDetalleProcOtros.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTDetalleProcOtros.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleProcOtros.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleProcOtros.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPOdontograma.12
            public void mouseClicked(MouseEvent evt) {
                JPOdontograma.this.JTDetalleProcOtrosMouseClicked(evt);
            }
        });
        this.JTDetalleProcOtros.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPOdontograma.13
            public void keyPressed(KeyEvent evt) {
                JPOdontograma.this.JTDetalleProcOtrosKeyPressed(evt);
            }
        });
        this.JSPDetalleOProcOtros.setViewportView(this.JTDetalleProcOtros);
        this.JBTAdicionarProcO.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarProcO.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTAdicionarProcO.setText("Agregar");
        this.JBTAdicionarProcO.addActionListener(new ActionListener() { // from class: Odontologia.JPOdontograma.14
            public void actionPerformed(ActionEvent evt) {
                JPOdontograma.this.JBTAdicionarProcOActionPerformed(evt);
            }
        });
        this.JTAObservacionProcO.setColumns(1);
        this.JTAObservacionProcO.setLineWrap(true);
        this.JTAObservacionProcO.setRows(1);
        this.JTAObservacionProcO.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.jScrollPane3.setViewportView(this.JTAObservacionProcO);
        GroupLayout JPOtrosLayout = new GroupLayout(this.JPOtros);
        this.JPOtros.setLayout(JPOtrosLayout);
        JPOtrosLayout.setHorizontalGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPOtrosLayout.createSequentialGroup().addGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDetalleOProcOtros).addGroup(GroupLayout.Alignment.LEADING, JPOtrosLayout.createSequentialGroup().addComponent(this.JCBOProcedimiento, 0, 599, 32767).addGap(18, 18, 18).addComponent(this.JBTBuscarProcOtros, -2, 48, -2))).addGap(24, 24, 24)).addGroup(JPOtrosLayout.createSequentialGroup().addComponent(this.jScrollPane3, -2, 355, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionarProcO, -2, 303, -2).addContainerGap(-1, 32767)))));
        JPOtrosLayout.setVerticalGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPOtrosLayout.createSequentialGroup().addContainerGap().addGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JCBOProcedimiento, -2, -1, -2).addComponent(this.JBTBuscarProcOtros, -2, 44, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPOtrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionarProcO, -1, -1, 32767).addGroup(JPOtrosLayout.createSequentialGroup().addComponent(this.jScrollPane3, -2, -1, -2).addGap(0, 41, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleOProcOtros, -2, 189, -2).addGap(344, 344, 344)));
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
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        adicionarTabla();
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
    public void JTFCDxPFocusLost(FocusEvent evt) {
        buscarPatologias(this.JTFCDxP, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFCDxPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            buscarPatologias(this.JTFCDxP, 0);
            this.JTFCDxP.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarActionPerformed(ActionEvent evt) {
        this.JCBDx.removeAllItems();
        ConsultasMySQL consultasMySqlc = new ConsultasMySQL();
        this.diagnostico = consultasMySqlc.llenarCombo("SELECT Id, CONCAT(Id,' ',Nbre) as Nbre FROM g_patologia where Estado=1 ORDER BY Nbre ASC", this.diagnostico, this.JCBDx);
        consultasMySqlc.cerrarConexionBd();
        JIFBuscarPatologia pac = new JIFBuscarPatologia((Frame) null, true, this, "dxodontograma");
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarProcActionPerformed(ActionEvent evt) {
        try {
            this.buscarProcedimientos = new JIFBuscaProcedimientos(this, "procedimietos");
            this.buscarProcedimientos.setVisible(true);
            Principal.PanelPpal.add(this.buscarProcedimientos, JLayeredPane.DEFAULT_LAYER);
            this.buscarProcedimientos.setSelected(true);
        } catch (PropertyVetoException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTBuscarProcOtrosActionPerformed(ActionEvent evt) {
        try {
            this.buscarProcedimientos = new JIFBuscaProcedimientos(this, "procedimientosO");
            this.buscarProcedimientos.setVisible(true);
            Principal.PanelPpal.add(this.buscarProcedimientos, JLayeredPane.DEFAULT_LAYER);
            this.buscarProcedimientos.setSelected(true);
        } catch (PropertyVetoException e) {
        }
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
    public void JTDetalleProcOtrosMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            String ruta = this.metodos.mTraerUrlBD(Principal.informacionIps.getUrlRxOdont() + this.modeloProcedimientoOtros.getValueAt(this.JTDetalleProcOtros.getSelectedRow(), 5).toString() + "\\");
            File folder = new File(ruta);
            System.out.println("Ruta-->" + ruta);
            if (folder.exists()) {
                abrirArchivo();
            } else {
                JOptionPane.showInternalMessageDialog(this, "No existe ninguna Placa con el código " + this.modeloProcedimientoOtros.getValueAt(this.JTDetalleProcOtros.getSelectedRow(), 5).toString(), "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            }
        }
    }

    private void abrirArchivo() {
        try {
            Runtime.getRuntime().exec("C:\\Genoma\\Visor\\mDicom.exe  " + this.metodos.mTraerUrlBD(Principal.informacionIps.getUrlRxOdont() + this.modeloProcedimientoOtros.getValueAt(this.JTDetalleProcOtros.getSelectedRow(), 5).toString() + "\\"));
        } catch (IOException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void buscarPatologias(JTextField codigo, int n) {
        if (!codigo.getText().isEmpty()) {
            ConsultasMySQL consultasMySqlc = new ConsultasMySQL();
            this.JCBDx.removeAllItems();
            this.diagnostico = consultasMySqlc.llenarCombo("SELECT Id, CONCAT(Id,' ',Nbre) as Nbre FROM g_patologia  where Estado=1  ORDER BY Nbre ASC", this.diagnostico, this.JCBDx);
            this.JCBDx.setSelectedIndex(-1);
            consultasMySqlc.cerrarConexionBd();
            try {
                String sql = "SELECT Id, CONCAT(Id,' ',Nbre) as Nbre FROM g_patologia where Id='" + codigo.getText().toUpperCase() + "' and Estado=1";
                ResultSet res = this.consultasMySql.traerRs(sql);
                res.next();
                if (res.getRow() != 0) {
                    this.JCBDx.setSelectedItem(res.getString(2));
                    codigo.setText(codigo.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGÍA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    codigo.setText((String) null);
                    codigo.requestFocus();
                }
                res.close();
                this.consultasMySql.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    private void cargarDxProcedimientos() {
        traerDatosDientesDx();
        cargarDatosProcedimientos();
        traerDatosDientesProcedimientoSombra();
        traerDatosDientesProcedimiento();
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

    private void traerimagen() {
        File file = new File("C:\\Genoma\\OdontogramaInicial.png");
        try {
            ImageIO.write(createImage(this.JPImOdontograma), "png", file);
        } catch (IOException e) {
            System.out.println("Error al guardar archivo.");
        }
    }

    private void mNuevo() {
        cargarPanelConvenciones();
        cargarPanelOdontograma();
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaDx() {
        this.modelo = new DefaultTableModel(new Object[0], new String[]{"IdDiente", "N°Diente", "Cara", "CIE10", "Diagnóstico", "IdTipoDx", "TipoDx", "Proceso", "Observacion", "Estado", "esCavitacional"}) { // from class: Odontologia.JPOdontograma.15
            Class[] types = {Integer.class, Long.class, String.class, String.class, String.class, Long.class, String.class, String.class, String.class, Boolean.class, Integer.class};
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
        this.JTDetalleO.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTDetalleO.getColumnModel().getColumn(2).setPreferredWidth(80);
        this.JTDetalleO.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTDetalleO.getColumnModel().getColumn(4).setPreferredWidth(150);
        this.JTDetalleO.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTDetalleO.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalleO.getColumnModel().getColumn(7).setPreferredWidth(80);
        this.JTDetalleO.getColumnModel().getColumn(8).setPreferredWidth(200);
        this.JTDetalleO.getColumnModel().getColumn(9).setPreferredWidth(80);
        this.JTDetalleO.getColumnModel().getColumn(10).setPreferredWidth(80);
        this.numeroFilas = 0;
    }

    private void adicionarTabla() {
        if (this.jifpaletaConvenciones.procedimientoPaleta.equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una convención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.controlFigura == 1) {
            if (this.JCBDx.getSelectedIndex() != -1) {
                if (this.JCBTipoDx.getSelectedIndex() != -1) {
                    int esCavitacional = -1;
                    if (this.JTDetalleO.getRowCount() > 0) {
                        int x = 0;
                        while (true) {
                            if (x < this.JTDetalleO.getRowCount()) {
                                if (!this.JTDetalleO.getValueAt(x, 1).equals(this.numeroDientes) && this.jifpaletaConvenciones.procedimientoPaleta.equals("Caries")) {
                                    esCavitacional = JOptionPane.showConfirmDialog((Component) null, "Carie seleccionada es cavitacional?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                                    break;
                                } else {
                                    esCavitacional = Integer.valueOf(this.JTDetalleO.getValueAt(x, 10).toString()).intValue();
                                    x++;
                                }
                            } else {
                                break;
                            }
                        }
                    } else if (this.jifpaletaConvenciones.procedimientoPaleta.equals("Caries")) {
                        esCavitacional = JOptionPane.showConfirmDialog((Component) null, "Carie seleccionada es cavitacional?", "CONFIRMACIÓN", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    }
                    this.modelo.addRow(this.datos);
                    this.modelo.setValueAt(Integer.valueOf(this.idDienteGeneral), this.numeroFilas, 0);
                    this.modelo.setValueAt(this.numeroDientes, this.numeroFilas, 1);
                    this.modelo.setValueAt(this.numeroCara, this.numeroFilas, 2);
                    this.modelo.setValueAt(this.diagnostico[this.JCBDx.getSelectedIndex()], this.numeroFilas, 3);
                    this.modelo.setValueAt(this.JCBDx.getSelectedItem(), this.numeroFilas, 4);
                    this.modelo.setValueAt(this.tipoDx[this.JCBTipoDx.getSelectedIndex()], this.numeroFilas, 5);
                    this.modelo.setValueAt(this.JCBTipoDx.getSelectedItem(), this.numeroFilas, 6);
                    this.modelo.setValueAt(this.jifpaletaConvenciones.procedimientoPaleta, this.numeroFilas, 7);
                    this.modelo.setValueAt(this.JTAObservacionDx.getText(), this.numeroFilas, 8);
                    this.modelo.setValueAt(false, this.numeroFilas, 9);
                    this.modelo.setValueAt(Integer.valueOf(esCavitacional), this.numeroFilas, 10);
                    this.numeroFilas++;
                    this.controlFigura = 0L;
                    limpiar();
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un tipo de diagnóstico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JCBTipoDx.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Diagnóstico", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JCBDx.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un Diente", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaProcedimiento() {
        this.modeloProcedimiento = new DefaultTableModel(new Object[0], new String[]{"IdDiente", "N° Diente", "Cara", "Id", "Procedimiento", "Proceso", "Observación", "Realizado"}) { // from class: Odontologia.JPOdontograma.16
            Class[] types = {Integer.class, Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleProc.setModel(this.modeloProcedimiento);
        this.JTDetalleProc.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(1).setPreferredWidth(5);
        this.JTDetalleProc.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalleProc.getColumnModel().getColumn(3).setPreferredWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(3).setMinWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(3).setMaxWidth(0);
        this.JTDetalleProc.getColumnModel().getColumn(4).setPreferredWidth(170);
        this.JTDetalleProc.getColumnModel().getColumn(5).setPreferredWidth(40);
        this.JTDetalleProc.getColumnModel().getColumn(6).setPreferredWidth(80);
        this.JTDetalleProc.getColumnModel().getColumn(7).setPreferredWidth(5);
        this.filasProcedimiento = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void crearModeloTablaProcedimientoOtros() {
        this.modeloProcedimientoOtros = new DefaultTableModel(new Object[0], new String[]{"Id", "Procedimiento", "Observación", "Realizado", "Fecha", "idProcTra"}) { // from class: Odontologia.JPOdontograma.17
            Class[] types = {Integer.class, String.class, String.class, Boolean.class, String.class, String.class};
            boolean[] canEdit = {false, false, true, true, false, false};

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
        this.JTDetalleProcOtros.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.JTDetalleProcOtros.getColumnModel().getColumn(3).setPreferredWidth(3);
        this.JTDetalleProcOtros.getColumnModel().getColumn(4).setPreferredWidth(20);
        this.JTDetalleProcOtros.getColumnModel().getColumn(5).setPreferredWidth(15);
        this.filasProcedimientoOtros = 0;
    }

    private void adicionarTablaProcedimiento() {
        if (this.jifpaletaConvenciones.procedimientoPaleta.equals("")) {
            JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una convención", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            return;
        }
        if (this.controlFigura == 1) {
            if (this.JCBProcedimiento.getSelectedIndex() != -1) {
                if (this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][1].equals("1")) {
                    verificarConsentimientoInformado(this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][0]);
                }
                this.modeloProcedimiento.addRow(this.datosProcedimiento);
                this.modeloProcedimiento.setValueAt(Integer.valueOf(this.idDienteGeneral), this.filasProcedimiento, 0);
                this.modeloProcedimiento.setValueAt(this.numeroDientes, this.filasProcedimiento, 1);
                this.modeloProcedimiento.setValueAt(this.numeroCara, this.filasProcedimiento, 2);
                this.modeloProcedimiento.setValueAt(this.procedimiento[this.JCBProcedimiento.getSelectedIndex()][0], this.filasProcedimiento, 3);
                this.modeloProcedimiento.setValueAt(this.JCBProcedimiento.getSelectedItem(), this.filasProcedimiento, 4);
                this.modeloProcedimiento.setValueAt(this.jifpaletaConvenciones.procedimientoPaleta, this.filasProcedimiento, 5);
                this.modeloProcedimiento.setValueAt(this.JTAObservacionProc.getText(), this.filasProcedimiento, 6);
                this.modeloProcedimiento.setValueAt(false, this.filasProcedimiento, 7);
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

    public void mImprimir() {
    }

    /* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPOdontograma$MiRender.class */
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
        this.jifpaletaConvenciones = new JPPaletaConvenciones(this);
        this.jifpaletaConvenciones.setVisible(false);
        this.JSPPaleta.setVisible(false);
        this.jifpaletaConvenciones.setBounds(1, 1, 165, 680);
        this.JSPPaleta.add(this.jifpaletaConvenciones);
        this.JSPPaleta.setVisible(true);
        this.jifpaletaConvenciones.setVisible(true);
    }

    private void cargarPanelOdontograma() {
        this.jpodontogramaDientes = new JPOdontogramaDientes(this);
        this.jpodontogramaDientes.setVisible(false);
        this.JPImOdontograma.setVisible(false);
        this.jpodontogramaDientes.setBounds(1, 1, 699, 340);
        this.JPImOdontograma.add(this.jpodontogramaDientes);
        this.JPImOdontograma.setVisible(true);
        this.jpodontogramaDientes.setVisible(true);
        this.jpodontogramaDientes.Verde.setVisible(false);
        this.jpodontogramaDientes.Amarillo.setVisible(false);
        this.jpodontogramaDientes.Rojo.setVisible(false);
        this.jpodontogramaDientesProcedimiento = new JPOdontogramaDientes(this);
        this.jpodontogramaDientesProcedimiento.setVisible(false);
        this.JPImOdontogramaProc.setVisible(false);
        this.jpodontogramaDientesProcedimiento.setBounds(1, 1, 699, 340);
        this.JPImOdontogramaProc.add(this.jpodontogramaDientesProcedimiento);
        this.JPImOdontogramaProc.setVisible(true);
        this.jpodontogramaDientesProcedimiento.setVisible(true);
        this.jpodontogramaDientesProcedimiento.Verde.setVisible(false);
        this.jpodontogramaDientesProcedimiento.Amarillo.setVisible(false);
        this.jpodontogramaDientesProcedimiento.Rojo.setVisible(false);
    }

    public void asignarFigura(JPanel panel) {
        if (this.controlFigura != 1) {
            if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 42.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 49.0d) {
                System.out.println("Cara Abajo 2");
                this.ladoGeneral = 6L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombras() || verificarProcesoLado(panel)) {
                        if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrerPanel(panel, "6", this.jifpaletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrerPanel(panel, "6", this.jifpaletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                }
            } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 53.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 62.0d) {
                System.out.println("Cara Abajo 1");
                this.ladoGeneral = 7L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombras() || verificarProcesoLado(panel)) {
                        if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrerPanel(panel, "7", this.jifpaletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrerPanel(panel, "7", this.jifpaletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                }
            } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 30.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 42.0d) {
                System.out.println("x --> " + panel.getMousePosition().x);
                if (panel.getMousePosition().x >= 23 && panel.getMousePosition().x <= 33) {
                    System.out.println("Derecha");
                    this.ladoGeneral = 3L;
                    traerDatosDientes(panel);
                    if (this.JTPDatos.getComponentAt(1).isVisible()) {
                        if (verificarSombras() || verificarProcesoLado(panel)) {
                            if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                                quitarElementoOdontograma(panel);
                            } else {
                                recorrerPanel(panel, "3", this.jifpaletaConvenciones.procedimientoPaleta);
                                this.controlFigura = 1L;
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                        quitarElementoOdontograma(panel);
                    } else {
                        recorrerPanel(panel, "3", this.jifpaletaConvenciones.procedimientoPaleta);
                        this.controlFigura = 1L;
                    }
                } else if (panel.getMousePosition().x >= 16 && panel.getMousePosition().x <= 22) {
                    System.out.println("Centro");
                    this.ladoGeneral = 4L;
                    traerDatosDientes(panel);
                    if (this.JTPDatos.getComponentAt(1).isVisible()) {
                        if (verificarSombras() || verificarProcesoLado(panel)) {
                            if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                                quitarElementoOdontograma(panel);
                            } else {
                                recorrerPanel(panel, "4", this.jifpaletaConvenciones.procedimientoPaleta);
                                this.controlFigura = 1L;
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                        quitarElementoOdontograma(panel);
                    } else {
                        recorrerPanel(panel, "4", this.jifpaletaConvenciones.procedimientoPaleta);
                        this.controlFigura = 1L;
                    }
                } else if (panel.getMousePosition().x >= 0 && panel.getMousePosition().x <= 15) {
                    System.out.println("IZquierda");
                    this.ladoGeneral = 5L;
                    traerDatosDientes(panel);
                    if (this.JTPDatos.getComponentAt(1).isVisible()) {
                        if (verificarSombras() || verificarProcesoLado(panel)) {
                            if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                                quitarElementoOdontograma(panel);
                            } else {
                                recorrerPanel(panel, "5", this.jifpaletaConvenciones.procedimientoPaleta);
                                this.controlFigura = 1L;
                            }
                        } else {
                            JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        }
                    } else if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                        quitarElementoOdontograma(panel);
                    } else {
                        recorrerPanel(panel, "5", this.jifpaletaConvenciones.procedimientoPaleta);
                        this.controlFigura = 1L;
                    }
                }
            } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 24.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 29.0d) {
                System.out.println("Cara Arriba 2 ");
                this.ladoGeneral = 2L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombras() || verificarProcesoLado(panel)) {
                        if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrerPanel(panel, "2", this.jifpaletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrerPanel(panel, "2", this.jifpaletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                }
            } else if (Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() >= 10.0d && Double.valueOf(panel.getMousePosition().distance(panel.getMousePosition().x, 0.0d)).doubleValue() <= 20.0d) {
                System.out.println("Cara Arriba 1 ");
                this.ladoGeneral = 1L;
                traerDatosDientes(panel);
                if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    if (verificarSombras() || verificarProcesoLado(panel)) {
                        if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                            quitarElementoOdontograma(panel);
                        } else {
                            recorrerPanel(panel, "1", this.jifpaletaConvenciones.procedimientoPaleta);
                            this.controlFigura = 1L;
                        }
                    } else {
                        JOptionPane.showInternalMessageDialog(this, "Este lado del diente no tiene ningun DX Asociado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    }
                } else if (this.jifpaletaConvenciones.JTBBorrador.isSelected()) {
                    quitarElementoOdontograma(panel);
                } else {
                    recorrerPanel(panel, "1", this.jifpaletaConvenciones.procedimientoPaleta);
                    this.controlFigura = 1L;
                }
            }
            if (verificarProcesoLado(panel)) {
                System.out.println("Si tiene capa 8...");
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe agregar a la tabla el Diagnóstico para continuar", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBDx.requestFocus();
    }

    private void recorrerPanel(JPanel panel, String lado, String procedimiento) {
        String sql;
        try {
            if (this.jifpaletaConvenciones.completo == 0) {
                sql = "SELECT  `o_odontograma_proceso`.`Id`  , `o_odontograma_proceso`.`Nbre` , `o_odontograma_proceso`.`Tipo`  , `o_odontograma_proceso`.`CGeneral` , `o_odontograma_figuras`.`Ruta` , `o_odontograma_figuras`.`Lado`  FROM `o_odontograma_figuras` INNER JOIN `baseserver`.`o_odontograma_proceso`  ON (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_odontograma_proceso`.`Nbre` ='" + procedimiento + "' AND o_odontograma_figuras.Lado='" + lado + "')";
            } else {
                lado = "8";
                this.ladoGeneral = 8L;
                sql = "SELECT  `o_odontograma_proceso`.`Id`  , `o_odontograma_proceso`.`Nbre` , `o_odontograma_proceso`.`Tipo`  , `o_odontograma_proceso`.`CGeneral` , `o_odontograma_figuras`.`Ruta` , `o_odontograma_figuras`.`Lado`  FROM `o_odontograma_figuras` INNER JOIN `baseserver`.`o_odontograma_proceso`  ON (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_odontograma_proceso`.`Nbre` ='" + procedimiento + "' AND o_odontograma_figuras.Lado='" + lado + "' AND o_odontograma_figuras.`Sombra`=0)";
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
                        JLabel jlabel = panel.getComponent(x);
                        if (jlabel.getName().equals(lado)) {
                            jlabel.setIcon(new ImageIcon(ruta));
                            break;
                        }
                    }
                    x++;
                }
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void quitarElementoOdontograma(JPanel panel) {
        for (int x = 0; x < panel.getComponentCount(); x++) {
            if (panel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                JLabel jlabel = panel.getComponent(x);
                if (jlabel.getName().equals(Long.valueOf(this.ladoGeneral).toString())) {
                    jlabel.setIcon((Icon) null);
                    this.controlFigura = 0L;
                    return;
                }
            }
        }
    }

    public void llenaCombo() {
        String sql;
        if (this.jifpaletaConvenciones.filtroCombo == 0) {
            sql = "SELECT  `o_odontograma_patologia`.`Id_Patología`, CONCAT(`o_odontograma_patologia`.`Id_Patología` ,' ' , `g_patologia`.`Nbre`) AS patologia  FROM `o_odontograma_patologia`  INNER JOIN `o_odontograma_proceso`  ON (`o_odontograma_patologia`.`IdProcesoOdon` = `o_odontograma_proceso`.`Id`) INNER JOIN `g_patologia`   ON (`o_odontograma_patologia`.`Id_Patología` = `g_patologia`.`Id`) WHERE (`o_odontograma_proceso`.`Nbre` ='" + this.jifpaletaConvenciones.procedimientoPaleta + "')";
        } else {
            sql = "SELECT `g_patologia_especialidad`.`IdPatologia` ,concat(`g_patologia_especialidad`.`IdPatologia`,' ', `g_patologia`.`Nbre`) as patologia  FROM `g_patologia_especialidad` INNER JOIN `baseserver`.`g_patologia`   ON (`g_patologia_especialidad`.`IdPatologia` = `g_patologia`.`Id`) WHERE (`g_patologia_especialidad`.`IdEspecialidad` =1024 AND `g_patologia_especialidad`.`Estado` =1)";
        }
        this.JCBDx.removeAllItems();
        this.diagnostico = this.consultasMySql.llenarCombo(sql, this.diagnostico, this.JCBDx);
        this.JCBDx.setSelectedIndex(-1);
        this.consultasMySql.cerrarConexionBd();
        this.JCBTipoDx.removeAllItems();
        this.tipoDx = this.consultasMySql.llenarCombo("SELECT  `Id` , `Nbre` FROM `h_tipodiagnostico`", this.tipoDx, this.JCBTipoDx);
        this.JCBTipoDx.setSelectedIndex(-1);
        this.consultasMySql.cerrarConexionBd();
    }

    public void llenaComboProcedimientos() {
        String sql;
        if (!Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ")) {
            sql = "SELECT  g_procedimiento.`Id` , g_procedimiento.`Nbre`, IF(h_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL, FALSE, IF (`h_procedimientoxconsentimiento`.`Estado` = 1, TRUE , FALSE)) GeneraConsentimiento  FROM `g_procedimiento` LEFT JOIN `h_procedimientoxconsentimiento` ON (h_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)  AND(h_procedimientoxconsentimiento.`Estado`=1) AND (g_procedimiento.`EsOdontologico`=1) group by g_procedimiento.Id ORDER BY g_procedimiento.Nbre";
        } else {
            sql = "SELECT  g_procedimiento.`Id` , g_procedimiento.`Nbre`, IF(g_procedimientoxconsentimiento.`Id_TipoConsentimiento` IS NULL, FALSE, IF (`g_procedimientoxconsentimiento`.`Estado` = 1, TRUE , FALSE)) GeneraConsentimiento  FROM `g_procedimiento` LEFT JOIN `g_procedimientoxconsentimiento` ON (g_procedimientoxconsentimiento.`Id_Procedimiento` = g_procedimiento.`Id`)  AND(g_procedimientoxconsentimiento.`Estado`=1) AND (g_procedimiento.`EsOdontologico`=1) group by g_procedimiento.Id ORDER BY g_procedimiento.Nbre";
        }
        if (this.JTPDatos.getComponentAt(1).isVisible()) {
            this.JCBProcedimiento.removeAllItems();
            this.procedimiento = this.consultasMySql.llenarComboyLista(sql, this.procedimiento, this.JCBProcedimiento, 3);
            this.JCBProcedimiento.setSelectedIndex(-1);
        } else if (this.JTPDatos.getComponentAt(2).isVisible()) {
            this.JCBOProcedimiento.removeAllItems();
            this.procedimientoOtros = this.consultasMySql.llenarComboyLista(sql, this.procedimientoOtros, this.JCBOProcedimiento, 3);
            this.JCBOProcedimiento.setSelectedIndex(-1);
        }
        this.consultasMySql.cerrarConexionBd();
    }

    private void traerDatosDientes(JPanel panel) {
        try {
            if (this.JTPDatos.getComponentAt(1).isVisible() && verificarProcesoLado(panel) && this.jifpaletaConvenciones.completo == 1) {
                this.ladoGeneral = 8L;
            }
            if (this.jifpaletaConvenciones.completo == 1) {
                this.ladoGeneral = 8L;
            }
            String sql = "SELECT  `o_odontograma_diente_cara`.`Id` , `o_odontograma_diente`.`Nbre` AS diente , `o_odontograma_caras`.`Nbre` AS cara FROM `o_odontograma_diente_cara` INNER JOIN `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_caras`   ON (`o_odontograma_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) WHERE (`o_odontograma_diente_cara`.`Lado` ='" + this.ladoGeneral + "'   AND `o_odontograma_diente`.`Nbre` ='" + panel.getName() + "')";
            System.out.println("trae Dato dientes: " + sql);
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                this.idDienteGeneral = resultSet.getInt(1);
                this.numeroDientes = resultSet.getString(2);
                this.numeroCara = resultSet.getString(3);
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void traerDatosDientesDx() {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_dx`.`Proceso`  , `o_odontograma_figuras`.`Ruta` FROM `o_hc_tratamiento_dx` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_tratamiento_dx`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_tratamiento_dx`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND `o_odontograma_figuras`.`Sombra` =0)";
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                while (resultSet.next()) {
                    for (int u = 0; u < this.jpodontogramaDientes.getComponentCount(); u++) {
                        if (this.jpodontogramaDientes.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel jpanel = this.jpodontogramaDientes.getComponent(u);
                            if (jpanel.getName().equals(resultSet.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= jpanel.getComponentCount()) {
                                        break;
                                    }
                                    if (jpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel jlabel = jpanel.getComponent(x);
                                        if (jlabel.getName().equals(resultSet.getString(2))) {
                                            jlabel.setIcon(new ImageIcon(this.metodos.getDirectorioExportacion() + resultSet.getString(4).replace("\\", this.metodos.getBarra())));
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
            this.consultasMySql.cerrarConexionBd();
            cargarDatosDx();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void traerDatosDientesProcedimiento() {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_procedimiento`.`Proceso`  , `o_odontograma_figuras`.`Ruta`  FROM `o_hc_tratamiento_procedimiento` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_tratamiento_procedimiento`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND `o_odontograma_figuras`.`Sombra` =0)";
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                while (resultSet.next()) {
                    for (int u = 0; u < this.jpodontogramaDientesProcedimiento.getComponentCount(); u++) {
                        if (this.jpodontogramaDientesProcedimiento.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel jpanel = this.jpodontogramaDientesProcedimiento.getComponent(u);
                            if (jpanel.getName().equals(resultSet.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= jpanel.getComponentCount()) {
                                        break;
                                    }
                                    if (jpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel jlabel = jpanel.getComponent(x);
                                        if (jlabel.getName().equals(resultSet.getString(2))) {
                                            jlabel.setIcon(new ImageIcon(this.metodos.getDirectorioExportacion() + resultSet.getString(4).replace("\\", this.metodos.getBarra())));
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
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void traerDatosDientesProcedimientoSombra() {
        try {
            String sql = "SELECT `o_odontograma_diente`.`Nbre` as Diente, `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_dx`.`Proceso`  , `o_odontograma_figuras`.`Ruta` FROM `o_hc_tratamiento_dx` INNER JOIN  `o_odontograma_diente_cara`  ON ( `IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_proceso`  ON (`o_hc_tratamiento_dx`.`Proceso` = `o_odontograma_proceso`.`Nbre`) INNER JOIN `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN `o_odontograma_figuras`   ON (`o_odontograma_diente_cara`.`Lado` = `o_odontograma_figuras`.`Lado`) AND (`o_odontograma_figuras`.`IdCatOdontograma` = `o_odontograma_proceso`.`Id`) WHERE (`o_hc_tratamiento_dx`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND `o_odontograma_figuras`.`Sombra` =1)";
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.beforeFirst();
                int n = 0;
                while (resultSet.next()) {
                    for (int u = 0; u < this.jpodontogramaDientesProcedimiento.getComponentCount(); u++) {
                        if (this.jpodontogramaDientesProcedimiento.getComponent(u).getClass().getName().equals("javax.swing.JPanel")) {
                            JPanel jpanel = this.jpodontogramaDientesProcedimiento.getComponent(u);
                            if (jpanel.getName().equals(resultSet.getString(1))) {
                                int x = 0;
                                while (true) {
                                    if (x >= jpanel.getComponentCount()) {
                                        break;
                                    }
                                    if (jpanel.getComponent(x).getClass().getName().equals("javax.swing.JLabel")) {
                                        JLabel jlabel = jpanel.getComponent(x);
                                        if (jlabel.getName().equals(resultSet.getString(2))) {
                                            jlabel.setIcon(new ImageIcon(this.metodos.getDirectorioExportacion() + resultSet.getString(4).replace("\\", this.metodos.getBarra())));
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
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosDx() {
        try {
            crearModeloTablaDx();
            String sql = "SELECT  `o_hc_tratamiento_dx`.`IdDienteCara` , `o_odontograma_diente`.`Nbre` , `o_odontograma_caras`.`Nbre` ,`o_hc_tratamiento_dx`.`Id_Patologia`, `g_patologia`.`Nbre`  , `o_hc_tratamiento_dx`.`Id_TipoDx` , `h_tipodiagnostico`.`Nbre`, `o_hc_tratamiento_dx`.Proceso, o_hc_tratamiento_dx.Observacion, o_hc_tratamiento_dx.Estado, o_hc_tratamiento_dx.esCavitacional  FROM `o_hc_tratamiento_dx` INNER JOIN  `o_odontograma_diente_cara`   ON (`o_hc_tratamiento_dx`.`IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_diente`   ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN  `o_odontograma_caras`   ON (`o_odontograma_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) INNER JOIN  `g_patologia`   ON (`o_hc_tratamiento_dx`.`Id_Patologia` = `g_patologia`.`Id`) INNER JOIN  `h_tipodiagnostico`   ON (`o_hc_tratamiento_dx`.`Id_TipoDx` = `h_tipodiagnostico`.`Id`) WHERE (`o_hc_tratamiento_dx`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "') order by `o_odontograma_diente`.`Nbre` ASC";
            ConsultasMySQL consultasMySql2 = new ConsultasMySQL();
            ResultSet resultSet2 = consultasMySql2.traerRs(sql);
            this.metodos.mEstablecerTextEditor(this.JTDetalleO, 4);
            if (resultSet2.next()) {
                resultSet2.beforeFirst();
                this.numeroFilas = 0;
                while (resultSet2.next()) {
                    this.modelo.addRow(this.datos);
                    this.modelo.setValueAt(Integer.valueOf(resultSet2.getInt(1)), this.numeroFilas, 0);
                    this.modelo.setValueAt(Long.valueOf(resultSet2.getLong(2)), this.numeroFilas, 1);
                    this.modelo.setValueAt(resultSet2.getString(3), this.numeroFilas, 2);
                    this.modelo.setValueAt(resultSet2.getString(4), this.numeroFilas, 3);
                    this.modelo.setValueAt(resultSet2.getString(5), this.numeroFilas, 4);
                    this.modelo.setValueAt(Long.valueOf(resultSet2.getLong(6)), this.numeroFilas, 5);
                    this.modelo.setValueAt(resultSet2.getString(7), this.numeroFilas, 6);
                    this.modelo.setValueAt(resultSet2.getString(8), this.numeroFilas, 7);
                    this.modelo.setValueAt(resultSet2.getString(9), this.numeroFilas, 8);
                    this.modelo.setValueAt(Boolean.valueOf(resultSet2.getBoolean(10)), this.numeroFilas, 9);
                    this.modelo.setValueAt(Integer.valueOf(resultSet2.getInt("esCavitacional")), this.numeroFilas, 10);
                    this.numeroFilas++;
                }
            }
            resultSet2.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosProcedimientos() {
        try {
            crearModeloTablaProcedimiento();
            String sql = "SELECT  `o_hc_tratamiento_procedimiento`.`IdDienteCara` , `o_odontograma_diente`.`Nbre` , `o_odontograma_caras`.`Nbre` , `o_hc_tratamiento_procedimiento`.`IdProcedimiento` , `g_procedimiento`.`Nbre` , `o_hc_tratamiento_procedimiento`.`Proceso` , `o_hc_tratamiento_procedimiento`.`Observacion` , `o_hc_tratamiento_procedimiento`.`Estado` FROM  `o_hc_tratamiento_procedimiento` INNER JOIN `baseserver`.`o_odontograma_diente_cara`  ON (`o_hc_tratamiento_procedimiento`.`IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN  `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) INNER JOIN  `o_odontograma_caras`   ON (`o_odontograma_diente_cara`.`IdCara` = `o_odontograma_caras`.`Id`) INNER JOIN  `g_procedimiento`   ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`) WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "') ORDER BY `o_odontograma_diente`.`Nbre` ASC ";
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
                    this.filasProcedimiento++;
                }
            }
            resultSet2.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void cargarDatosOtrosProcedimientos() {
        try {
            crearModeloTablaProcedimientoOtros();
            String sql = "SELECT  `o_hc_tratamiento_procedimiento`.`IdProcedimiento` , `g_procedimiento`.`Nbre`  , o_hc_tratamiento_procedimiento.Observacion, o_hc_tratamiento_procedimiento.Estado,o_hc_tratamiento_procedimiento.FechaR,`o_hc_tratamiento_procedimiento`.`Id` AS idProcTrata   FROM `o_hc_tratamiento_procedimiento`   INNER JOIN `baseserver`.`g_procedimiento`    ON (`o_hc_tratamiento_procedimiento`.`IdProcedimiento` = `g_procedimiento`.`Id`)   WHERE (`o_hc_tratamiento_procedimiento`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "' AND o_hc_tratamiento_procedimiento.Tipo=1) ORDER BY o_hc_tratamiento_procedimiento.FechaR DESC";
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
                    this.modeloProcedimientoOtros.setValueAt(resultSet2.getString(5), this.filasProcedimientoOtros, 4);
                    this.modeloProcedimientoOtros.setValueAt(resultSet2.getString(6), this.filasProcedimientoOtros, 5);
                    this.filasProcedimientoOtros++;
                }
            }
            resultSet2.close();
            consultasMySql2.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGrabar() {
        if (!verificarTratamiento()) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                if (this.JTPDatos.getComponentAt(0).isVisible()) {
                    for (int y = 0; y < this.JTDetalleO.getRowCount(); y++) {
                        if (!Boolean.valueOf(this.modelo.getValueAt(y, 9).toString()).booleanValue()) {
                            String sql = "insert into o_hc_tratamiento_dx(`Id_Tratamiento` , `IdDienteCara`  , `Id_Patologia` , `Id_TipoDx`, Proceso,Observacion, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.modelo.getValueAt(y, 0) + "','" + this.modelo.getValueAt(y, 3) + "','" + this.modelo.getValueAt(y, 5) + "','" + this.modelo.getValueAt(y, 7) + "','" + this.modelo.getValueAt(y, 8) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            System.out.println("consulta de insercion " + sql);
                            this.consultasMySql.ejecutarSQL(sql);
                            this.consultasMySql.cerrarConexionBd();
                        }
                    }
                    cargarDatosDx();
                    cargarDatosProcedimientos();
                    traerDatosDientesProcedimientoSombra();
                    traerDatosDientesProcedimiento();
                    cargarDatosOtrosProcedimientos();
                } else if (this.JTPDatos.getComponentAt(1).isVisible()) {
                    for (int y2 = 0; y2 < this.JTDetalleProc.getRowCount(); y2++) {
                        if (!Boolean.valueOf(this.modeloProcedimiento.getValueAt(y2, 7).toString()).booleanValue()) {
                            String sql2 = "insert into o_hc_tratamiento_procedimiento (`Id_Tratamiento` , `IdDienteCara`  , `IdProcedimiento` , `Proceso` , `Observacion`, Tipo, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.modeloProcedimiento.getValueAt(y2, 0) + "','" + this.modeloProcedimiento.getValueAt(y2, 3) + "','" + this.modeloProcedimiento.getValueAt(y2, 5) + "','" + this.modeloProcedimiento.getValueAt(y2, 6) + "','1','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            System.out.println("consulta de insercion " + sql2);
                            this.consultasMySql.ejecutarSQL(sql2);
                            if (clasesHistoriaCE.informacionAgendaMedicaDTO.getTipoTratamiento().longValue() == 1) {
                            }
                            this.consultasMySql.cerrarConexionBd();
                        }
                    }
                    cargarDatosDx();
                    cargarDatosProcedimientos();
                    traerDatosDientesProcedimientoSombra();
                    traerDatosDientesProcedimiento();
                    cargarDatosOtrosProcedimientos();
                } else if (this.JTPDatos.getComponentAt(2).isVisible()) {
                    for (int y3 = 0; y3 < this.JTDetalleProcOtros.getRowCount(); y3++) {
                        if (!Boolean.valueOf(this.modeloProcedimientoOtros.getValueAt(y3, 3).toString()).booleanValue()) {
                            String sql3 = "insert into o_hc_tratamiento_procedimiento (`Id_Tratamiento` , `IdProcedimiento` , `Observacion`, Tipo, FechaR, `UsuarioS`) values ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "','" + this.modeloProcedimientoOtros.getValueAt(y3, 0) + "','" + this.modeloProcedimientoOtros.getValueAt(y3, 2) + "','1','" + this.metodos.formatoAMD.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            System.out.println("consulta de insercion otros Proc-->" + sql3);
                            this.consultasMySql.ejecutarSQL(sql3);
                            this.consultasMySql.cerrarConexionBd();
                        }
                    }
                    cargarDatosDx();
                    cargarDatosProcedimientos();
                    traerDatosDientesProcedimientoSombra();
                    traerDatosDientesProcedimiento();
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
        JOptionPane.showInternalMessageDialog(this, " No se puede Guardar la información \n Tratamiento Cerrado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
    }

    public boolean verificarSombras() {
        boolean existe = false;
        String sql = "SELECT `IdDienteCara` FROM `o_hc_tratamiento_dx` WHERE (`IdDienteCara` ='" + this.idDienteGeneral + "' AND `Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "')";
        System.out.println("Este es la verificacion de la sombra:: " + sql);
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                existe = true;
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existe;
    }

    public boolean verificarProcesoLado(JPanel panel) {
        boolean existevalor8 = false;
        String sql = "SELECT `o_odontograma_diente`.`Nbre`   , `o_odontograma_diente_cara`.`Lado` , `o_hc_tratamiento_dx`.`Id_Tratamiento` FROM `o_hc_tratamiento_dx` INNER JOIN `baseserver`.`o_odontograma_diente_cara`  ON (`o_hc_tratamiento_dx`.`IdDienteCara` = `o_odontograma_diente_cara`.`Id`) INNER JOIN `o_odontograma_diente`  ON (`o_odontograma_diente_cara`.`IdDiente` = `o_odontograma_diente`.`Id`) WHERE (`o_odontograma_diente`.`Nbre` ='" + panel.getName() + "'  AND `o_odontograma_diente_cara`.`Lado` =8   AND `o_hc_tratamiento_dx`.`Id_Tratamiento` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "')";
        System.out.println("Este es la verificacion de capa 8:: " + sql);
        try {
            ResultSet resultSet = this.consultasMySql.traerRs(sql);
            if (resultSet.next()) {
                resultSet.first();
                existevalor8 = true;
            }
            resultSet.close();
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return existevalor8;
    }

    private void limpiar() {
        if (this.JTPDatos.getComponentAt(0).isVisible()) {
            this.JCBDx.setSelectedIndex(-1);
            this.JCBTipoDx.setSelectedIndex(-1);
            this.JTAObservacionDx.setText("");
            this.JTFCDxP.setText("");
            return;
        }
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
            this.consultasMySql.cerrarConexionBd();
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
            this.consultasMySql.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPOdontograma.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return cerrado;
    }

    private void verificarConsentimientoInformado(String idProcedimiento) {
        JOptionPane.showInternalMessageDialog(this, "<html><P ALIGN=center> <font face='Arial' color='red' size=4>  <b>Se debe realizar el consentimiento informado al procedimiento seleccionado<b></p><html>", "CONSENTIMIENTO INFORMADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        JDConsentimientoInformado consentimientoInformado = new JDConsentimientoInformado(null, true, clasesHistoriaCE.informacionAgendaMedicaDTO.getIdIngreso().toString(), idProcedimiento, this, Principal.informacionGeneralPrincipalDTO.getIdEspecialidad().toString(), Principal.usuarioSistemaDTO.getIdUsuarioSistema().toString());
        consentimientoInformado.setLocationRelativeTo(this);
        consentimientoInformado.setVisible(true);
    }
}
