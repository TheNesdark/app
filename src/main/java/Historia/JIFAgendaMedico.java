package Historia;

import Acceso.Principal;
import PyP.clasePyP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaMedico.class */
public class JIFAgendaMedico extends JInternalFrame {
    public static int xn;
    public static DefaultTableModel xmodelo;
    public static DefaultTableModel xmodelo1;
    public static Object[] xdato;
    public static String xidpro;
    public static String xidesp;
    private clasesHistoriaCE xclaseHC;
    private clasePyP xclasepyp;
    private ButtonGroup JBGFiltro;
    private ButtonGroup JBGFiltroNp;
    private static JButton JBTAtencionesPendientes;
    private JCheckBox JCHEsAgendado;
    private JDateChooser JDCFechaAgenda;
    private JDateChooser JDCFechaTriage;
    private JPanel JPIFiltro;
    private JPanel JPIFiltroNp;
    private JRadioButton JRBAtendidas;
    private JRadioButton JRBAtendidasNp;
    private JRadioButton JRBPorAtender;
    private JRadioButton JRBPorAtenderNp;
    private JRadioButton JRBSinFact;
    private JRadioButton JRBSinFactNp;
    private JRadioButton JRBTodas;
    private JRadioButton JRBTodasNp;
    private JScrollPane JSPDetalleCitasNoPro;
    private JScrollPane JSPDetalleCitasPro;
    public static JTable JTBProgCitas;
    public static JTable JTBProgCitasNoPro;
    public static int xestado = 0;
    public static int xidt = -1;
    public static int xidtnp = -1;
    public static int xestadonp = 0;
    public static int xtipo = 0;
    public static int xesagendado = 0;
    public static Metodos xmetodo = new Metodos();
    private static TableColumn column = null;
    public static int pos = -1;
    public static int lleno = 0;
    public static String xfechatriage = null;
    public static String xfechaatencion = null;
    Subproceso ct = new Subproceso();
    Thread t = new Thread(this.ct);
    private Metodos xmt = new Metodos();

    public JIFAgendaMedico(String xidpro2, String xidesp2, clasesHistoriaCE xclase) {
        initComponents();
        xidpro = xidpro2;
        xidesp = xidesp2;
        this.xclaseHC = xclase;
        this.JDCFechaTriage.setDate(this.xmt.getFechaActual());
        this.JDCFechaAgenda.setDate(this.xmt.getFechaActual());
        xfechatriage = this.xmt.formatoDMA.format(this.xmt.getFechaActual());
        xfechaatencion = this.xmt.formatoDMA.format(this.xmt.getFechaActual());
        this.t.start();
    }

    public JIFAgendaMedico(String xidpro2, String xidesp2) {
        initComponents();
        xidpro = xidpro2;
        xidesp = xidesp2;
        this.JDCFechaTriage.setDate(this.xmt.getFechaActual());
        this.JDCFechaAgenda.setDate(this.xmt.getFechaActual());
        xfechatriage = this.xmt.formatoDMA.format(this.xmt.getFechaActual());
        xfechaatencion = this.xmt.formatoDMA.format(this.xmt.getFechaActual());
        this.t.start();
    }

    public JIFAgendaMedico(String xidpro2, String xidesp2, clasePyP xclasepyp, int xtipo2) {
        initComponents();
        xtipo = xtipo2;
        this.xclasepyp = xclasepyp;
        xidpro = xidpro2;
        xidesp = xidesp2;
        this.JDCFechaTriage.setDate(this.xmt.getFechaActual());
        this.JDCFechaAgenda.setDate(this.xmt.getFechaActual());
        xfechatriage = this.xmt.formatoDMA.format(this.xmt.getFechaActual());
        xfechaatencion = this.xmt.formatoDMA.format(this.xmt.getFechaActual());
        this.t.start();
    }

    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGFiltro = new ButtonGroup();
        this.JBGFiltroNp = new ButtonGroup();
        this.JSPDetalleCitasPro = new JScrollPane();
        JTBProgCitas = new JTable();
        this.JSPDetalleCitasNoPro = new JScrollPane();
        JTBProgCitasNoPro = new JTable();
        this.JPIFiltro = new JPanel();
        this.JRBTodas = new JRadioButton();
        this.JRBSinFact = new JRadioButton();
        this.JRBPorAtender = new JRadioButton();
        this.JRBAtendidas = new JRadioButton();
        this.JPIFiltroNp = new JPanel();
        this.JRBTodasNp = new JRadioButton();
        this.JRBSinFactNp = new JRadioButton();
        this.JRBPorAtenderNp = new JRadioButton();
        this.JRBAtendidasNp = new JRadioButton();
        this.JDCFechaTriage = new JDateChooser();
        this.JDCFechaAgenda = new JDateChooser();
        JBTAtencionesPendientes = new JButton();
        this.JCHEsAgendado = new JCheckBox();
        setClosable(true);
        setIconifiable(true);
        setTitle("AGENDA");
        setDoubleBuffered(true);
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMinimumSize(null);
        try {
            setSelected(true);
        } catch (PropertyVetoException e1) {
            e1.printStackTrace();
        }
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFAgendaMedico.1
            public void internalFrameActivated(InternalFrameEvent evt) {
                JIFAgendaMedico.this.formInternalFrameActivated(evt);
            }

            public void internalFrameClosed(InternalFrameEvent evt) {
                JIFAgendaMedico.this.formInternalFrameClosed(evt);
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
                JIFAgendaMedico.this.formInternalFrameIconified(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }
        });
        this.JSPDetalleCitasPro.setBorder(BorderFactory.createTitledBorder((Border) null, "CITAS PROGRAMADAS", 2, 0, new Font("Arial", 1, 16), new Color(0, 102, 0)));
        JTBProgCitas.setFont(new Font("Arial", 1, 12));
        JTBProgCitas.setForeground(new Color(255, 255, 255));
        JTBProgCitas.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        JTBProgCitas.setGridColor(new Color(204, 204, 204));
        JTBProgCitas.setRowHeight(25);
        JTBProgCitas.setSelectionBackground(new Color(255, 255, 255));
        JTBProgCitas.setSelectionForeground(new Color(255, 0, 0));
        JTBProgCitas.setSelectionMode(0);
        JTBProgCitas.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaMedico.2
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaMedico.this.JTBProgCitasMouseClicked(evt);
            }
        });
        this.JSPDetalleCitasPro.setViewportView(JTBProgCitas);
        this.JSPDetalleCitasNoPro.setBorder(BorderFactory.createTitledBorder((Border) null, "NO PROGRAMADAS", 2, 0, new Font("Arial", 1, 16), new Color(0, 103, 0)));
        JTBProgCitasNoPro.setFont(new Font("Arial", 1, 12));
        JTBProgCitasNoPro.setForeground(new Color(0, 0, 102));
        JTBProgCitasNoPro.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        JTBProgCitasNoPro.setRowHeight(25);
        JTBProgCitasNoPro.setSelectionBackground(new Color(255, 255, 255));
        JTBProgCitasNoPro.setSelectionForeground(new Color(255, 0, 0));
        JTBProgCitasNoPro.setSelectionMode(0);
        JTBProgCitasNoPro.addMouseListener(new MouseAdapter() { // from class: Historia.JIFAgendaMedico.3
            public void mouseClicked(MouseEvent evt) {
                JIFAgendaMedico.this.JTBProgCitasNoProMouseClicked(evt);
            }
        });
        this.JSPDetalleCitasNoPro.setViewportView(JTBProgCitasNoPro);
        this.JPIFiltro.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR : ", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JBGFiltro.add(this.JRBTodas);
        this.JRBTodas.setFont(new Font("Arial", 1, 12));
        this.JRBTodas.setForeground(new Color(0, 0, 255));
        this.JRBTodas.setSelected(true);
        this.JRBTodas.setText("Todas");
        this.JRBTodas.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.4
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JRBTodasActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBSinFact);
        this.JRBSinFact.setFont(new Font("Arial", 1, 12));
        this.JRBSinFact.setForeground(new Color(0, 0, 255));
        this.JRBSinFact.setText("Sin Facturar");
        this.JRBSinFact.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.5
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JRBSinFactActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBPorAtender);
        this.JRBPorAtender.setFont(new Font("Arial", 1, 12));
        this.JRBPorAtender.setForeground(new Color(0, 0, 255));
        this.JRBPorAtender.setText("Por Atender");
        this.JRBPorAtender.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.6
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JRBPorAtenderActionPerformed(evt);
            }
        });
        this.JBGFiltro.add(this.JRBAtendidas);
        this.JRBAtendidas.setFont(new Font("Arial", 1, 12));
        this.JRBAtendidas.setForeground(new Color(0, 0, 255));
        this.JRBAtendidas.setText("Atendidas");
        this.JRBAtendidas.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.7
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JRBAtendidasActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroLayout = new GroupLayout(this.JPIFiltro);
        this.JPIFiltro.setLayout(JPIFiltroLayout);
        JPIFiltroLayout.setHorizontalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addComponent(this.JRBTodas).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSinFact).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPorAtender).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAtendidas).addContainerGap(-1, 32767)));
        JPIFiltroLayout.setVerticalGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroLayout.createSequentialGroup().addGroup(JPIFiltroLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodas).addComponent(this.JRBSinFact).addComponent(this.JRBPorAtender).addComponent(this.JRBAtendidas)).addContainerGap(-1, 32767)));
        this.JPIFiltroNp.setBorder(BorderFactory.createTitledBorder((Border) null, "FILTRAR POR:", 0, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JBGFiltroNp.add(this.JRBTodasNp);
        this.JRBTodasNp.setFont(new Font("Arial", 1, 12));
        this.JRBTodasNp.setForeground(new Color(0, 0, 255));
        this.JRBTodasNp.setSelected(true);
        this.JRBTodasNp.setText("Todas");
        this.JRBTodasNp.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.8
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JRBTodasNpActionPerformed(evt);
            }
        });
        this.JBGFiltroNp.add(this.JRBSinFactNp);
        this.JRBSinFactNp.setFont(new Font("Arial", 1, 12));
        this.JRBSinFactNp.setForeground(new Color(0, 0, 255));
        this.JRBSinFactNp.setText("Sin Facturar");
        this.JRBSinFactNp.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.9
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JRBSinFactNpActionPerformed(evt);
            }
        });
        this.JBGFiltroNp.add(this.JRBPorAtenderNp);
        this.JRBPorAtenderNp.setFont(new Font("Arial", 1, 12));
        this.JRBPorAtenderNp.setForeground(new Color(0, 0, 255));
        this.JRBPorAtenderNp.setText("Por Atender");
        this.JRBPorAtenderNp.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.10
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JRBPorAtenderNpActionPerformed(evt);
            }
        });
        this.JBGFiltroNp.add(this.JRBAtendidasNp);
        this.JRBAtendidasNp.setFont(new Font("Arial", 1, 12));
        this.JRBAtendidasNp.setForeground(new Color(0, 0, 255));
        this.JRBAtendidasNp.setText("Atendidas");
        this.JRBAtendidasNp.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.11
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JRBAtendidasNpActionPerformed(evt);
            }
        });
        GroupLayout JPIFiltroNpLayout = new GroupLayout(this.JPIFiltroNp);
        this.JPIFiltroNp.setLayout(JPIFiltroNpLayout);
        JPIFiltroNpLayout.setHorizontalGroup(JPIFiltroNpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNpLayout.createSequentialGroup().addComponent(this.JRBTodasNp).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBSinFactNp).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBPorAtenderNp).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBAtendidasNp).addContainerGap(-1, 32767)));
        JPIFiltroNpLayout.setVerticalGroup(JPIFiltroNpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIFiltroNpLayout.createSequentialGroup().addGroup(JPIFiltroNpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBTodasNp).addComponent(this.JRBSinFactNp).addComponent(this.JRBPorAtenderNp).addComponent(this.JRBAtendidasNp)).addContainerGap(-1, 32767)));
        this.JDCFechaTriage.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Triage", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaTriage.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaTriage.setFont(new Font("Arial", 1, 12));
        this.JDCFechaTriage.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JIFAgendaMedico.12
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgendaMedico.this.JDCFechaTriagePropertyChange(evt);
            }
        });
        this.JDCFechaAgenda.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha Agenda", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFechaAgenda.setDateFormatString("dd/MM/yyyy");
        this.JDCFechaAgenda.setFont(new Font("Arial", 1, 12));
        this.JDCFechaAgenda.addFocusListener(new FocusAdapter() { // from class: Historia.JIFAgendaMedico.13
            public void focusLost(FocusEvent evt) {
                JIFAgendaMedico.this.JDCFechaAgendaFocusLost(evt);
            }
        });
        this.JDCFechaAgenda.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JIFAgendaMedico.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JIFAgendaMedico.this.JDCFechaAgendaPropertyChange(evt);
            }
        });
        JBTAtencionesPendientes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gif.gif")));
        JBTAtencionesPendientes.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.15
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JBTAtencionesPendientesActionPerformed(evt);
            }
        });
        this.JCHEsAgendado.setFont(new Font("Arial", 1, 12));
        this.JCHEsAgendado.setText("Es Agendado?");
        this.JCHEsAgendado.addActionListener(new ActionListener() { // from class: Historia.JIFAgendaMedico.16
            public void actionPerformed(ActionEvent evt) {
                JIFAgendaMedico.this.JCHEsAgendadoActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCHEsAgendado, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(JBTAtencionesPendientes, -2, 182, -2).addGap(260, 260, 260).addComponent(this.JDCFechaTriage, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JPIFiltroNp, -2, -1, -2)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPDetalleCitasNoPro, GroupLayout.Alignment.LEADING, -1, 1141, 32767).addGroup(layout.createSequentialGroup().addComponent(this.JDCFechaAgenda, -2, 143, -2).addGap(18, 18, 18).addComponent(this.JPIFiltro, -2, -1, -2)).addComponent(this.JSPDetalleCitasPro, GroupLayout.Alignment.LEADING))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JSPDetalleCitasPro, -2, 400, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIFiltro, -2, -1, -2).addComponent(this.JDCFechaAgenda, -2, 56, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDetalleCitasNoPro, -2, 215, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPIFiltroNp, -2, -1, -2).addComponent(this.JDCFechaTriage, -2, 56, -2).addComponent(JBTAtencionesPendientes, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.JCHEsAgendado).addGap(12, 12, 12))).addContainerGap(19, 32767)));
        pack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBProgCitasMouseClicked(MouseEvent evt) {
        JTBProgCitas.setCursor(new Cursor(3));
        pos = JTBProgCitas.rowAtPoint(evt.getPoint());
        ConsultasMySQL xmt1 = new ConsultasMySQL();
        if (xmodelo.getValueAt(pos, 11).toString().equals("0")) {
            JOptionPane.showInternalMessageDialog(this, "Usuario sin facturar ", "VERIFICAR ESTADO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        } else if (xmodelo.getValueAt(pos, 11).toString().equals("1")) {
            if (xtipo == 0) {
                mCargarDatosClaseCitasProgramadas();
            } else {
                this.xclasepyp.setXidnhc(xmodelo.getValueAt(pos, 0).toString());
                this.xclasepyp.cargarPantalla("Toma1");
                dispose();
            }
        } else if (xtipo == 0) {
            if (xmodelo.getValueAt(pos, 11).toString().equals("2")) {
                int n = JOptionPane.showInternalConfirmDialog(this, "Usuario en estado de atención \n Desea modificar el estado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                if (n == 0) {
                    String xsql = "update c_citas set Asistida=1 where Id='" + Integer.valueOf(xmodelo.getValueAt(pos, 12).toString()) + "'";
                    xmt1.ejecutarSQL(xsql);
                    xmt1.cerrarConexionBd();
                    mCargarDatosClaseCitasProgramadas();
                }
            } else {
                Object[] botones = {"Cargar HC", "Cerrar"};
                int n2 = JOptionPane.showInternalOptionDialog(this, "Usuario ya Atendido \n\t Desea cargar la HC", "VERIFICAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
                if (n2 == 0) {
                    mCargarDatosClaseCitasProgramadas();
                }
            }
        }
        JTBProgCitas.setCursor(new Cursor(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosed(InternalFrameEvent evt) {
        Subproceso mf = this.ct;
        mf.setActivo(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTBProgCitasNoProMouseClicked(MouseEvent evt) {
        JTBProgCitasNoPro.setCursor(new Cursor(3));
        pos = JTBProgCitasNoPro.rowAtPoint(evt.getPoint());
        ConsultasMySQL xmt1 = new ConsultasMySQL();
        if (xmodelo1.getValueAt(pos, 10).toString().equals("0") || xmodelo1.getValueAt(pos, 10).toString().equals("1")) {
            mCargarDatosClaseCitasNoProgramadas();
            this.xclaseHC.mCambiarEstadoCitaNP();
            return;
        }
        if (xmodelo1.getValueAt(pos, 10).toString().equals("2")) {
            if (JOptionPane.showInternalConfirmDialog(this, "Usuario en estado de atención \n Desea modificar el estado?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png")))) == 0) {
                String xsql = "update c_citasnp set Asistida=0 where Id='" + Integer.valueOf(xmodelo1.getValueAt(pos, 11).toString()) + "'";
                xmt1.ejecutarSQL(xsql);
                xmt1.cerrarConexionBd();
                mCargarDatosClaseCitasNoProgramadas();
                return;
            }
            return;
        }
        Object[] botones = {"Cargar HC", "Triage", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Usuario ya Atendido \n\t Desea cargar la HC", "VERIFICAR", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            mCargarDatosClaseCitasNoProgramadas();
            return;
        }
        if (n == 1) {
            String[][] parametros = new String[4][2];
            parametros[0][0] = "idt";
            parametros[0][1] = xmodelo1.getValueAt(pos, 19).toString();
            parametros[1][0] = "ruta";
            parametros[1][1] = this.xmt.getRutaRep();
            parametros[2][0] = "SUBREPORT_DIR";
            parametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            parametros[3][0] = "SUBREPORTFIRMA_DIR";
            parametros[3][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            this.xmt.GenerarPDF(this.xmt.getRutaRep() + "RTriage", parametros);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasActionPerformed(ActionEvent evt) {
        xidt = -1;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinFactActionPerformed(ActionEvent evt) {
        xidt = 0;
        xestado = 0;
        mCargarDatos();
        this.t = new Thread(this.ct);
        this.t.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorAtenderActionPerformed(ActionEvent evt) {
        xidt = 0;
        xestado = 1;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAtendidasActionPerformed(ActionEvent evt) {
        xidt = 0;
        xestado = 3;
        mCargarDatos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBTodasNpActionPerformed(ActionEvent evt) {
        xidtnp = -1;
        xestadonp = -1;
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSinFactNpActionPerformed(ActionEvent evt) {
        xidtnp = 0;
        xestadonp = 0;
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBPorAtenderNpActionPerformed(ActionEvent evt) {
        xidtnp = 0;
        xestadonp = 1;
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBAtendidasNpActionPerformed(ActionEvent evt) {
        xidtnp = 0;
        xestadonp = 3;
        mCargarDatosCNP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaTriagePropertyChange(PropertyChangeEvent evt) {
        xfechatriage = this.xmt.formatoDMA.format(this.JDCFechaTriage.getDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaAgendaPropertyChange(PropertyChangeEvent evt) {
        xfechaatencion = this.xmt.formatoDMA.format(this.JDCFechaAgenda.getDate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDCFechaAgendaFocusLost(FocusEvent evt) {
        try {
            this.ct.setActivo(false);
            Thread.sleep(500L);
            this.ct.setActivo(true);
            mCargarDatos();
        } catch (InterruptedException ex) {
            Logger.getLogger(JIFAgendaMedico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameActivated(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameIconified(InternalFrameEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAtencionesPendientesActionPerformed(ActionEvent evt) {
        this.xclaseHC.cargarPantalla("Consultar Atenciones Especiales", this.xclaseHC.frmPrincipal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEsAgendadoActionPerformed(ActionEvent evt) {
        if (this.JCHEsAgendado.isSelected()) {
            xesagendado = 1;
        } else {
            xesagendado = 0;
        }
        mCargarDatosCNP();
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaMedico$MiRender.class */
    public static class MiRender extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int cantidad = Integer.valueOf(table.getValueAt(row, 11).toString()).intValue();
            if (cantidad == 0) {
                cell.setBackground(Color.CYAN);
                cell.setForeground(Color.BLACK);
            } else if (cantidad == 1) {
                cell.setBackground(Color.PINK);
                cell.setForeground(Color.BLACK);
            } else if (cantidad == 2) {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            } else {
                cell.setBackground(Color.MAGENTA);
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    /* JADX INFO: loaded from: GenomaP.jar:Historia/JIFAgendaMedico$MiRender1.class */
    public static class MiRender1 extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            int cantidad = Integer.valueOf(table.getValueAt(row, 14).toString()).intValue();
            if (cantidad == 1) {
                cell.setBackground(new Color(186, 22, 99));
                cell.setForeground(Color.WHITE);
            } else if (cantidad == 2) {
                cell.setBackground(Color.ORANGE);
                cell.setForeground(Color.BLACK);
            } else if (cantidad == 3) {
                cell.setBackground(Color.YELLOW);
                cell.setForeground(Color.BLACK);
            } else if (cantidad == 4) {
                cell.setBackground(new Color(57, 107, 52));
                cell.setForeground(Color.WHITE);
            } else {
                cell.setBackground(new Color(204, 204, 204));
                cell.setForeground(Color.BLACK);
            }
            return cell;
        }
    }

    private void mCargarDatosClaseCitasNoProgramadas() {
        JTBProgCitasNoPro.setCursor(new Cursor(3));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(xmodelo1.getValueAt(pos, 0).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(xmodelo1.getValueAt(pos, 1).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(xmodelo1.getValueAt(pos, 2).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(xmodelo1.getValueAt(pos, 3).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(xmodelo1.getValueAt(pos, 4).toString().toUpperCase());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(xmodelo1.getValueAt(pos, 6).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(xmodelo1.getValueAt(pos, 7).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(Long.valueOf(xmodelo1.getValueAt(pos, 13).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(xmodelo1.getValueAt(pos, 9).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(Long.valueOf(xmodelo1.getValueAt(pos, 11).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(0);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(xmodelo1.getValueAt(pos, 8).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(Integer.valueOf(xmodelo1.getValueAt(pos, 18).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(xmodelo1.getValueAt(pos, 21).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(Integer.valueOf(xmodelo1.getValueAt(pos, 22).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(xmodelo1.getValueAt(pos, 23).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(xmodelo1.getValueAt(pos, 24).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(xmodelo1.getValueAt(pos, 25).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(xmodelo1.getValueAt(pos, 26).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(1);
        if (xidesp.equals("382")) {
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(xmodelo1.getValueAt(pos, 17).toString()));
        } else {
            clasesHistoriaCE.informacionAgendaMedicaDTO.setIdPrograma(Integer.valueOf(xmodelo1.getValueAt(pos, 15).toString()));
        }
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoAtencion(1);
        this.xclaseHC.mBuscarAtencionIngreso();
        this.xclaseHC.mActualizarFechaHoraIniciaAtencion();
        this.t = null;
        this.ct.setActivo(false);
        dispose();
        this.xclaseHC.xjifagendamedico = null;
        this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal);
    }

    private void mCargarDatosClaseCitasProgramadas() {
        JTBProgCitas.setCursor(new Cursor(3));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNumeroHistoria(xmodelo.getValueAt(pos, 0).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreUsuario(xmodelo.getValueAt(pos, 1).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEdad(xmodelo.getValueAt(pos, 2).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreSexo(xmodelo.getValueAt(pos, 3).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreTipoConsulta(xmodelo.getValueAt(pos, 4).toString().toUpperCase());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdUsuarioAtendido(Long.valueOf(xmodelo.getValueAt(pos, 7).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdIngreso(Long.valueOf(xmodelo.getValueAt(pos, 8).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoCita(Long.valueOf(xmodelo.getValueAt(pos, 14).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipohc(Integer.valueOf(xmodelo.getValueAt(pos, 10).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdCita(Long.valueOf(xmodelo.getValueAt(pos, 12).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsRemitada(Integer.valueOf(xmodelo.getValueAt(pos, 15).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdClaseCita(Integer.valueOf(xmodelo.getValueAt(pos, 9).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(xmodelo.getValueAt(pos, 16).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsSaludOcupacional(Integer.valueOf(xmodelo.getValueAt(pos, 17).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setEsOdontologica(Integer.valueOf(xmodelo.getValueAt(pos, 19).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTratamiento(Long.valueOf(xmodelo.getValueAt(pos, 20).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setNombreEmpresaCovenio(xmodelo.getValueAt(pos, 21).toString());
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdModalidad(Integer.valueOf(xmodelo.getValueAt(pos, 22).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdEntornoAtencion(Integer.valueOf(xmodelo.getValueAt(pos, 23).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoDiscapacidad(Integer.valueOf(xmodelo.getValueAt(pos, 24).toString()));
        clasesHistoriaCE.informacionAgendaMedicaDTO.setTipoCita(0);
        clasesHistoriaCE.informacionAgendaMedicaDTO.setIdTipoAtencion(0);
        this.xclaseHC.mBuscarAtencionIngreso();
        this.xclaseHC.mActualizarFechaHoraIniciaAtencion();
        if (Long.parseLong(xmodelo.getValueAt(pos, 15).toString()) > 0) {
            String[][] mparametros = new String[3][2];
            mparametros[0][0] = "idremision";
            mparametros[0][1] = xmodelo.getValueAt(pos, 15).toString();
            mparametros[1][0] = "SUBREPORT_DIR";
            mparametros[1][1] = this.xmt.getSO() + this.xmt.getBarra() + "Reportes" + this.xmt.getBarra();
            mparametros[2][0] = "SUBREPORTFIRMA_DIR";
            mparametros[2][1] = this.xmt.getSO() + this.xmt.getBarra() + "Firmas" + this.xmt.getBarra();
            if (this.xclaseHC.mImprimirRemisiones(xmodelo.getValueAt(pos, 15).toString())) {
                xmetodo.GenerarPDF(xmetodo.getRutaRep() + "RRemision", mparametros);
            } else {
                xmetodo.GenerarPDF(xmetodo.getRutaRep() + "RRemisionTO", mparametros);
            }
        }
        this.t = null;
        this.ct.setActivo(false);
        dispose();
        this.xclaseHC.cargarPantalla("Historia", this.xclaseHC.frmPrincipal);
    }

    private static void mCrearTablaDetalle() {
        xmodelo = new DefaultTableModel();
        xmodelo.addColumn("N° Historia");
        xmodelo.addColumn("Usuario");
        xmodelo.addColumn("Edad");
        xmodelo.addColumn("Sexo");
        xmodelo.addColumn("Tipo Consulta");
        xmodelo.addColumn("HoraI");
        xmodelo.addColumn("HoraF");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("Estado");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("");
        xmodelo.addColumn("idModalidad");
        xmodelo.addColumn("idEntornoAtencion");
        xmodelo.addColumn("idTipoDiscapacidad");
        JTBProgCitas.setModel(xmodelo);
        column = JTBProgCitas.getColumnModel().getColumn(0);
        column.setPreferredWidth(60);
        column = JTBProgCitas.getColumnModel().getColumn(1);
        column.setPreferredWidth(300);
        column = JTBProgCitas.getColumnModel().getColumn(2);
        column.setPreferredWidth(30);
        column = JTBProgCitas.getColumnModel().getColumn(3);
        column.setPreferredWidth(30);
        column = JTBProgCitas.getColumnModel().getColumn(4);
        column.setPreferredWidth(150);
        column = JTBProgCitas.getColumnModel().getColumn(5);
        column.setPreferredWidth(50);
        column = JTBProgCitas.getColumnModel().getColumn(6);
        column.setPreferredWidth(50);
        column = JTBProgCitas.getColumnModel().getColumn(7);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(8);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(9);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(10);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(11);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(12);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(13);
        column.setPreferredWidth(40);
        column = JTBProgCitas.getColumnModel().getColumn(14);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(15);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(16);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(17);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(18);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(19);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(20);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(21);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(22);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(23);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitas.getColumnModel().getColumn(24);
        column.setMinWidth(0);
        column.setMaxWidth(0);
    }

    private static void mCrearTablaDetalle1() {
        xmodelo1 = new DefaultTableModel();
        xmodelo1.addColumn("N° Historia");
        xmodelo1.addColumn("Usuario");
        xmodelo1.addColumn("Edad");
        xmodelo1.addColumn("Sexo");
        xmodelo1.addColumn("Tipo Consulta");
        xmodelo1.addColumn("Hora I");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("Estado");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("Motivo Consulta");
        xmodelo1.addColumn(" Observación");
        xmodelo1.addColumn(" ");
        xmodelo1.addColumn(" ");
        xmodelo1.addColumn(" ");
        xmodelo1.addColumn(" ");
        xmodelo1.addColumn(" ");
        xmodelo1.addColumn("");
        xmodelo1.addColumn("");
        xmodelo.addColumn("idModalidad");
        xmodelo.addColumn("idEntornoAtencion");
        xmodelo.addColumn("idTipoDiscapacidad");
        JTBProgCitasNoPro.setModel(xmodelo1);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(0);
        column.setPreferredWidth(50);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(1);
        column.setPreferredWidth(200);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(2);
        column.setPreferredWidth(30);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(3);
        column.setPreferredWidth(30);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(4);
        column.setPreferredWidth(150);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(5);
        column.setPreferredWidth(50);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(6);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(7);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(8);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(9);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(10);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(11);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(12);
        column.setPreferredWidth(50);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(13);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(14);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(15);
        column.setPreferredWidth(100);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(16);
        column.setPreferredWidth(70);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(17);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(18);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(19);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(20);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(21);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(22);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(23);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(24);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(25);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column = JTBProgCitasNoPro.getColumnModel().getColumn(26);
        column.setMinWidth(0);
        column.setMaxWidth(0);
    }

    public static void mCargarDatos() {
        String sql;
        mCrearTablaDetalle();
        ConsultasMySQL xmt = new ConsultasMySQL();
        if (Principal.informacionGeneralPrincipalDTO.getAsignacionCitaAgenda().booleanValue()) {
            if (xidt == -1) {
                if (Principal.informacionIps.getVisualizaAgenda().intValue() == 0) {
                    sql = "SELECT c_citas.Id_Usuario, c_citas.Id_ingreso, c_citas.Id_ClaseCita, c_clasecita.Nbre, c_clasecita.Id_Historia, persona.IdSexo, g_usuario.NoHistoria, persona.NUsuario, c_citas.Asistida, DATE_FORMAT(c_citas.Fecha_Cita,'%d/%m%/%Y') as fecha, DATE_FORMAT(c_citas.HoraInicial,'%h:%i%:%s %p') as horai, DATE_FORMAT(c_citas.HoraFinal,'%h:%i%:%s %p') as horaf, c_citas.Id_MotivoDesistida, c_citas.Id, persona.Edad, persona.NTipoEdad, c_clasecita.Id_TipoCita, c_citas.Remitida, c_clasecita.Id_Programa, c_citas.So, c_clasecita.EsControl, g_especialidad.EsOdontologia, c_citas.Id_TratamientoO, `f_empresacontxconvenio`.`Nbre` , i.idModalidad , i.idEntornoAtencion , i.idTipoDiscapacidad  FROM c_citas INNER JOIN g_usuario  ON (c_citas.Id_Usuario = g_usuario.Id_persona) INNER JOIN persona  ON (persona.Id_persona = g_usuario.Id_persona) INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN g_especialidad ON (c_citas.`Id_Especialidad` = g_especialidad.Id)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  left join ingreso i on (c_citas.Id_ingreso=i.Id) and (i.Estado=0)  WHERE (c_citas.Id_MotivoDesistida =1  AND c_citas.Id_Profesional ='" + xidpro + "' and DATE_FORMAT(c_citas.Fecha_Cita,'%d/%m%/%Y')='" + xfechaatencion + "' ) ORDER BY c_citas.Fecha_Cita ASC, c_citas.HoraInicial ASC ";
                } else {
                    sql = "SELECT c_citas.Id_Usuario, c_citas.Id_ingreso, c_citas.Id_ClaseCita, c_clasecita.Nbre, c_clasecita.Id_Historia, persona.IdSexo, g_usuario.NoHistoria, persona.NUsuario, c_citas.Asistida, DATE_FORMAT(c_citas.Fecha_Cita,'%d/%m%/%Y') as fecha, DATE_FORMAT(c_citas.HoraInicial,'%h:%i%:%s %p') as horai, DATE_FORMAT(c_citas.HoraFinal,'%h:%i%:%s %p') as horaf, c_citas.Id_MotivoDesistida, c_citas.Id, persona.Edad, persona.NTipoEdad, c_clasecita.Id_TipoCita, c_citas.Remitida, c_clasecita.Id_Programa, c_citas.So, c_clasecita.EsControl, g_especialidad.EsOdontologia, c_citas.Id_TratamientoO, `f_empresacontxconvenio`.`Nbre` , i.idModalidad , i.idEntornoAtencion , i.idTipoDiscapacidad  FROM c_citas INNER JOIN g_usuario  ON (c_citas.Id_Usuario = g_usuario.Id_persona) INNER JOIN persona  ON (persona.Id_persona = g_usuario.Id_persona) INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN g_especialidad ON (c_citas.`Id_Especialidad` = g_especialidad.Id)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) left join ingreso i on (c_citas.Id_ingreso=i.Id) and (i.Estado=0)  WHERE (`c_citas`.`Asistida`>0 and c_citas.Id_MotivoDesistida =1  AND c_citas.Id_Profesional ='" + xidpro + "' and DATE_FORMAT(c_citas.Fecha_Cita,'%d/%m%/%Y')='" + xfechaatencion + "' ) ORDER BY c_citas.Fecha_Cita ASC, c_citas.HoraInicial ASC ";
                }
            } else if (Principal.informacionIps.getVisualizaAgenda().intValue() == 0) {
                sql = "SELECT c_citas.Id_Usuario, c_citas.Id_ingreso, c_citas.Id_ClaseCita, c_clasecita.Nbre, c_clasecita.Id_Historia, persona.IdSexo, g_usuario.NoHistoria, persona.NUsuario, c_citas.Asistida, DATE_FORMAT(c_citas.Fecha_Cita,'%d/%m%/%Y') as fecha, DATE_FORMAT(c_citas.HoraInicial,'%h:%i%:%s %p') as horai, DATE_FORMAT(c_citas.HoraFinal,'%h:%i%:%s %p') as horaf, c_citas.Id_MotivoDesistida, c_citas.Id, persona.Edad, persona.NTipoEdad, c_clasecita.Id_TipoCita, c_citas.Remitida, c_clasecita.Id_Programa, c_citas.So, c_clasecita.EsControl, g_especialidad.EsOdontologia, c_citas.Id_TratamientoO, `f_empresacontxconvenio`.`Nbre` , i.idModalidad , i.idEntornoAtencion , i.idTipoDiscapacidad  FROM c_citas INNER JOIN g_usuario  ON (c_citas.Id_Usuario = g_usuario.Id_persona) INNER JOIN persona  ON (persona.Id_persona = g_usuario.Id_persona) INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN g_especialidad ON (c_citas.`Id_Especialidad` = g_especialidad.Id)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  left join ingreso i on (c_citas.Id_ingreso=i.Id) and (i.Estado=0)  WHERE (c_citas.Id_MotivoDesistida =1  AND c_citas.Id_Profesional ='" + xidpro + "' and DATE_FORMAT(c_citas.Fecha_Cita,'%d/%m%/%Y')='" + xfechaatencion + "' and Asistida='" + xestado + "') ORDER BY c_citas.Fecha_Cita ASC, c_citas.HoraInicial ASC ";
            } else {
                sql = "SELECT c_citas.Id_Usuario, c_citas.Id_ingreso, c_citas.Id_ClaseCita, c_clasecita.Nbre, c_clasecita.Id_Historia, persona.IdSexo, g_usuario.NoHistoria, persona.NUsuario, c_citas.Asistida, DATE_FORMAT(c_citas.Fecha_Cita,'%d/%m%/%Y') as fecha, DATE_FORMAT(c_citas.HoraInicial,'%h:%i%:%s %p') as horai, DATE_FORMAT(c_citas.HoraFinal,'%h:%i%:%s %p') as horaf, c_citas.Id_MotivoDesistida, c_citas.Id, persona.Edad, persona.NTipoEdad, c_clasecita.Id_TipoCita, c_citas.Remitida, c_clasecita.Id_Programa, c_citas.So, c_clasecita.EsControl, g_especialidad.EsOdontologia, c_citas.Id_TratamientoO, `f_empresacontxconvenio`.`Nbre` , i.idModalidad , i.idEntornoAtencion , i.idTipoDiscapacidad  FROM c_citas INNER JOIN g_usuario  ON (c_citas.Id_Usuario = g_usuario.Id_persona) INNER JOIN persona  ON (persona.Id_persona = g_usuario.Id_persona) INNER JOIN c_clasecita ON (c_citas.Id_ClaseCita = c_clasecita.Id) INNER JOIN g_especialidad ON (c_citas.`Id_Especialidad` = g_especialidad.Id)  INNER JOIN `f_empresacontxconvenio`  ON (`c_citas`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)  left join ingreso i on (c_citas.Id_ingreso=i.Id) and (i.Estado=0)  WHERE (`c_citas`.`Asistida`>0 and c_citas.Id_MotivoDesistida =1  AND c_citas.Id_Profesional ='" + xidpro + "' and DATE_FORMAT(c_citas.Fecha_Cita,'%d/%m%/%Y')='" + xfechaatencion + "' and Asistida='" + xestado + "') ORDER BY c_citas.Fecha_Cita ASC, c_citas.HoraInicial ASC ";
            }
        } else if (Principal.informacionIps.getVisualizaAgenda().intValue() == 0) {
            sql = "SELECT  `ingreso`.`Id_Usuario` , `ingreso`.`Id` , `c_clasecita`.`Id` , `c_clasecita`.`Nbre` , `c_clasecita`.`Id_Historia` , `persona`.`IdSexo` , `persona`.`NoHistoria` , `persona`.`NUsuario` , IF(`h_atencion`.`InicioAtencion`=0,1,IF(`h_atencion`.`TipoGuardado`=1,3,`h_atencion`.`InicioAtencion`) )  as TipoA , DATE_FORMAT(ingreso.FechaIngreso,'%d/%m%/%Y') AS `FechaA` , DATE_FORMAT(ingreso.HoraIngreso,'%h:%i%:%s %p') AS `HoraI` , DATE_FORMAT(ingreso.HoraIngreso,'%h:%i%:%s %p') AS `HoraF` , `h_atencion`.`InicioAtencion` , 0 AS `IdCita` , `persona`.`Edad` , `persona`.`NTipoEdad` , `c_clasecita`.`Id_TipoCita` , 0 AS `EsRemitido` , `c_clasecita`.`Id_Programa`, 0, c_clasecita.EsControl,0,0, `f_empresacontxconvenio`.`Nbre`, ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM `h_atencion` INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)WHERE (DATE_FORMAT(Fecha_Atencion,'%d/%m%/%Y') ='" + xfechaatencion + "' AND `h_atencion`.`Id_Profesional` ='" + xidpro + "' AND `h_atencion`.`Id_Especialidad` ='" + xidesp + "') ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
        } else {
            sql = "SELECT  `ingreso`.`Id_Usuario` , `ingreso`.`Id` , `c_clasecita`.`Id` , `c_clasecita`.`Nbre` , `c_clasecita`.`Id_Historia` , `persona`.`IdSexo` , `persona`.`NoHistoria` , `persona`.`NUsuario` , IF(`h_atencion`.`InicioAtencion`=0,1,IF(`h_atencion`.`TipoGuardado`=1,3,`h_atencion`.`InicioAtencion`) )  as TipoA , DATE_FORMAT(ingreso.FechaIngreso,'%d/%m%/%Y') AS `FechaA` , DATE_FORMAT(ingreso.HoraIngreso,'%h:%i%:%s %p') AS `HoraI` , DATE_FORMAT(ingreso.HoraIngreso,'%h:%i%:%s %p') AS `HoraF` , `h_atencion`.`InicioAtencion` , 0 AS `IdCita` , `persona`.`Edad` , `persona`.`NTipoEdad` , `c_clasecita`.`Id_TipoCita` , 0 AS `EsRemitido` , `c_clasecita`.`Id_Programa`, 0, c_clasecita.EsControl,0,0, `f_empresacontxconvenio`.`Nbre` , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM `h_atencion` INNER JOIN  `ingreso` ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`) INNER JOIN  `c_clasecita`  ON (`h_atencion`.`Id_ClaseCita` = `c_clasecita`.`Id`) INNER JOIN  `persona`  ON (`persona`.`Id_persona` = `ingreso`.`Id_Usuario`) INNER JOIN  `f_empresacontxconvenio` ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)WHERE (`c_citas`.`Asistida`>0 and DATE_FORMAT(Fecha_Atencion,'%d/%m%/%Y') ='" + xfechaatencion + "' AND `h_atencion`.`Id_Profesional` ='" + xidpro + "' AND `h_atencion`.`Id_Especialidad` ='" + xidesp + "') ORDER BY ingreso.FechaIngreso ASC, ingreso.HoraIngreso ASC ";
        }
        ResultSet rs = xmt.traerRs(sql);
        try {
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    xmodelo.addRow(xdato);
                    xmodelo.setValueAt(rs.getString(7), i, 0);
                    xmodelo.setValueAt(rs.getString(8), i, 1);
                    xmodelo.setValueAt(rs.getString(15) + " " + rs.getString(16), i, 2);
                    xmodelo.setValueAt(rs.getString(6), i, 3);
                    xmodelo.setValueAt(rs.getString(4), i, 4);
                    xmodelo.setValueAt(rs.getString(11), i, 5);
                    xmodelo.setValueAt(rs.getString(12), i, 6);
                    xmodelo.setValueAt(rs.getString(1), i, 7);
                    xmodelo.setValueAt(rs.getString(2), i, 8);
                    xmodelo.setValueAt(rs.getString(3), i, 9);
                    xmodelo.setValueAt(rs.getString(5), i, 10);
                    xmodelo.setValueAt("0", i, 11);
                    xmodelo.setValueAt(rs.getString(9), i, 11);
                    xmodelo.setValueAt(rs.getString(14), i, 12);
                    xmodelo.setValueAt(rs.getString(18), i, 15);
                    xmodelo.setValueAt(rs.getString(19), i, 16);
                    xmodelo.setValueAt(rs.getString(20), i, 17);
                    xmodelo.setValueAt(rs.getString(21), i, 18);
                    xmodelo.setValueAt(rs.getString(22), i, 19);
                    xmodelo.setValueAt(rs.getString(23), i, 20);
                    xmodelo.setValueAt(rs.getString(24), i, 21);
                    xmodelo.setValueAt(Integer.valueOf(rs.getInt("idModalidad")), i, 22);
                    xmodelo.setValueAt(Integer.valueOf(rs.getInt("idEntornoAtencion")), i, 23);
                    xmodelo.setValueAt(Integer.valueOf(rs.getInt("idTipoDiscapacidad")), i, 24);
                    JTBProgCitas.setDefaultRenderer(Object.class, new MiRender());
                    switch (rs.getInt(9)) {
                        case 0:
                            xmodelo.setValueAt("SIN FACTURAR", i, 13);
                            break;
                        case 1:
                            xmodelo.setValueAt("FACTURADA", i, 13);
                            break;
                        case 2:
                            xmodelo.setValueAt("EN ATENCION", i, 13);
                            break;
                        default:
                            xmodelo.setValueAt("ATENDIDA", i, 13);
                            break;
                    }
                    xmodelo.setValueAt(rs.getString(17), i, 14);
                    i++;
                }
            }
            rs.close();
            xmt.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    public static void mCargarDatosCNP() {
        String sql;
        mCrearTablaDetalle1();
        if (xidesp.equals("382")) {
            if (Principal.informacionIps.getEsFpz().intValue() == 0) {
                if (xidtnp == -1) {
                    sql = "SELECT g_usuario.NoHistoria, persona.NUsuario, persona.Edad, persona.NTipoEdad, persona.NSexo, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia, c_citasnp.Asistida, c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, h_triage.Clasificacion , h_triage.MotivoConsulta, h_triage.Observacion, g_profesionalespecial.Id_Especialidad, c_citasnp.Fecha_Cita, c_clasecita.Id_Programa, c_citasnp.So,h_triage.Id , c_clasecita.EsControl, c_citasnp.Id_TratamientoO, g_especialidad.EsOdontologia,  `f_empresacontxconvenio`.`Nbre` , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citasnp INNER JOIN g_usuario ON (c_citasnp.Id_Usuario = g_usuario.Id_persona) INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN persona  ON (persona.Id_persona = g_usuario.Id_persona) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso) INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id) INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = c_citasnp.Id_Profesional) INNER JOIN g_especialidad ON (c_citasnp.`Id_Especialidad` = g_especialidad.Id) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) WHERE (c_citasnp.Id_MotivoDesistida =0 AND g_profesionalespecial.Id_Especialidad ='" + xidesp + "' and  DATE_FORMAT(c_citasnp.Fecha_Cita,'%d/%m%/%Y')='" + xfechatriage + "' and c_citasnp.Id_Anulada=0 and ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and h_triage.Es_Agendado='" + xesagendado + "' and ingreso.Estado=0) GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC";
                } else {
                    sql = "SELECT g_usuario.NoHistoria, persona.NUsuario, persona.Edad, persona.NTipoEdad, persona.NSexo, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia, c_citasnp.Asistida, c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, h_triage.Clasificacion , h_triage.MotivoConsulta, h_triage.Observacion, g_profesionalespecial.Id_Especialidad, c_citasnp.Fecha_Cita, c_clasecita.Id_Programa, c_citasnp.So, c_clasecita.EsControl, c_citasnp.Id_TratamientoO, g_especialidad.EsOdontologia,  `f_empresacontxconvenio`.`Nbre` , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citasnp INNER JOIN g_usuario ON (c_citasnp.Id_Usuario = g_usuario.Id_persona) INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN persona  ON (persona.Id_persona = g_usuario.Id_persona) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso) INNER JOIN h_triage  ON (h_triage.IdIngreso = ingreso.Id) INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = c_citasnp.Id_Profesional) INNER JOIN g_especialidad ON (c_citasnp.`Id_Especialidad` = g_especialidad.Id) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`) WHERE (c_citasnp.Id_MotivoDesistida =0 AND g_profesionalespecial.Id_Especialidad ='" + xidesp + "' and  DATE_FORMAT(c_citasnp.Fecha_Cita,'%d/%m%/%Y')='" + xfechatriage + "'  and c_citasnp.Id_Anulada=0 and Asistida='" + xestadonp + "' and ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' and h_triage.Es_Agendado='" + xesagendado + "' and ingreso.Estado=0 ) GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC";
                }
            } else if (xidtnp == -1) {
                sql = "SELECT g_usuario.NoHistoria, persona.NUsuario, persona.Edad, persona.NTipoEdad, persona.NSexo, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia, c_citasnp.Asistida, c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1 , c_clasecita.Id_Programa , '', g_profesionalespecial.Id_Especialidad, c_citasnp.Fecha_Cita,0, c_citasnp.So, '0', c_clasecita.EsControl, c_citasnp.Id_TratamientoO, g_especialidad.EsOdontologia,  `f_empresacontxconvenio`.`Nbre` , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citasnp INNER JOIN g_usuario ON (c_citasnp.Id_Usuario = g_usuario.Id_persona) INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN persona  ON (persona.Id_persona = g_usuario.Id_persona) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso) INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = c_citasnp.Id_Profesional) INNER JOIN g_especialidad ON (c_citasnp.`Id_Especialidad` = g_especialidad.Id) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)WHERE (c_citasnp.Id_MotivoDesistida =0 AND g_profesionalespecial.Id_Especialidad ='" + xidesp + "' and  DATE_FORMAT(c_citasnp.Fecha_Cita,'%d/%m%/%Y')='" + xfechatriage + "'  and c_citasnp.Id_Anulada=0 and ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC";
            } else {
                sql = "SELECT g_usuario.NoHistoria, persona.NUsuario, persona.Edad, persona.NTipoEdad, persona.NSexo, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia, c_citasnp.Asistida, c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1 , c_clasecita.Id_Programa , '', g_profesionalespecial.Id_Especialidad, c_citasnp.Fecha_Cita,0, c_citasnp.So, '0', c_clasecita.EsControl, c_citasnp.Id_TratamientoO, g_especialidad.EsOdontologia,  `f_empresacontxconvenio`.`Nbre` , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM c_citasnp INNER JOIN g_usuario ON (c_citasnp.Id_Usuario = g_usuario.Id_persona) INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN persona  ON (persona.Id_persona = g_usuario.Id_persona) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso) INNER JOIN g_profesionalespecial  ON (g_profesionalespecial.Id_Profesional = c_citasnp.Id_Profesional) INNER JOIN g_especialidad ON (c_citasnp.`Id_Especialidad` = g_especialidad.Id) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)WHERE (c_citasnp.Id_MotivoDesistida =0 AND g_profesionalespecial.Id_Especialidad ='" + xidesp + "' and  DATE_FORMAT(c_citasnp.Fecha_Cita,'%d/%m%/%Y')='" + xfechatriage + "' and Asistida='" + xestadonp + "' and c_citasnp.Id_Anulada=0 and ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC";
            }
        } else {
            sql = "SELECT g_usuario.NoHistoria, persona.NUsuario, persona.Edad, persona.NTipoEdad, persona.NSexo, c_clasecita.Nbre, DATE_FORMAT(c_citasnp.HoraInicial,'%h:%i%:%s %p'), ingreso.Id_Usuario , ingreso.Id, c_citasnp.Id_ClaseCita, c_clasecita.Id_Historia, c_citasnp.Asistida, c_citasnp.Id, c_citasnp.Id_MotivoDesistida, c_clasecita.Id_TipoCita, 1 , c_clasecita.Id_Programa , '', g_profesionalespecial.Id_Especialidad, c_citasnp.Fecha_Cita ,0, c_citasnp.So, '0', c_clasecita.EsControl, c_citasnp.Id_TratamientoO, g_especialidad.EsOdontologia,  `f_empresacontxconvenio`.`Nbre` , ingreso.idModalidad , ingreso.idEntornoAtencion , ingreso.idTipoDiscapacidad  FROM g_profesionalespecial INNER JOIN c_citasnp  ON (g_profesionalespecial.Id_Profesional = c_citasnp.Id_Profesional) AND (g_profesionalespecial.Id_Especialidad = c_citasnp.Id_Especialidad) INNER JOIN g_especialidad ON (c_citasnp.`Id_Especialidad` = g_especialidad.Id)INNER JOIN persona  ON (persona.Id_persona = c_citasnp.Id_Usuario) INNER JOIN c_clasecita  ON (c_citasnp.Id_ClaseCita = c_clasecita.Id) INNER JOIN ingreso  ON (ingreso.Id = c_citasnp.Id_ingreso) INNER JOIN g_usuario  ON (g_usuario.Id_persona = persona.Id_persona) INNER JOIN `f_empresacontxconvenio`  ON (`c_citasnp`.`Id_EmpresaCont` = `f_empresacontxconvenio`.`Id`)WHERE (c_citasnp.Id_MotivoDesistida =0 AND g_profesionalespecial.Id_Especialidad ='" + xidesp + "' and  DATE_FORMAT(c_citasnp.Fecha_Cita,'%d/%m%/%Y')='" + xfechatriage + "' and c_citasnp.Id_Anulada=0 and ingreso.Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "') GROUP BY ingreso.Id ORDER BY c_citasnp.HoraInicial ASC";
        }
        ConsultasMySQL xmt = new ConsultasMySQL();
        ResultSet rs = xmt.traerRs(sql);
        try {
            rs.next();
            if (rs.getRow() != 0) {
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    xmodelo1.addRow(xdato);
                    xmodelo1.setValueAt(rs.getString(1), i, 0);
                    xmodelo1.setValueAt(rs.getString(2), i, 1);
                    xmodelo1.setValueAt(rs.getString(3) + " " + rs.getString(4), i, 2);
                    xmodelo1.setValueAt(rs.getString(5), i, 3);
                    xmodelo1.setValueAt(rs.getString(6), i, 4);
                    xmodelo1.setValueAt(rs.getString(7), i, 5);
                    xmodelo1.setValueAt(rs.getString(8), i, 6);
                    xmodelo1.setValueAt(rs.getString(9), i, 7);
                    xmodelo1.setValueAt(rs.getString(10), i, 8);
                    xmodelo1.setValueAt(rs.getString(11), i, 9);
                    xmodelo1.setValueAt(rs.getString(12), i, 10);
                    xmodelo1.setValueAt(rs.getString(13), i, 11);
                    xmodelo1.setValueAt(rs.getString(14), i, 12);
                    switch (rs.getInt(12)) {
                        case 0:
                            xmodelo1.setValueAt("SIN FACTURAR", i, 12);
                            break;
                        case 1:
                            xmodelo1.setValueAt("FACTURADA", i, 12);
                            break;
                        case 2:
                            xmodelo1.setValueAt("EN ATENCION", i, 12);
                            break;
                        default:
                            xmodelo1.setValueAt("ATENDIDA", i, 12);
                            break;
                    }
                    xmodelo1.setValueAt(rs.getString(15), i, 13);
                    xmodelo1.setValueAt(rs.getString(16), i, 14);
                    xmodelo1.setValueAt(rs.getString(17), i, 15);
                    xmodelo1.setValueAt(rs.getString(18), i, 16);
                    xmodelo1.setValueAt(rs.getString(19), i, 17);
                    xmodelo1.setValueAt(rs.getString(22), i, 18);
                    xmodelo1.setValueAt(Integer.valueOf(rs.getInt(23)), i, 19);
                    xmodelo1.setValueAt(rs.getString(24), i, 20);
                    xmodelo1.setValueAt(rs.getString(25), i, 21);
                    xmodelo1.setValueAt(rs.getString(26), i, 22);
                    xmodelo1.setValueAt(rs.getString(27), i, 23);
                    xmodelo.setValueAt(Integer.valueOf(rs.getInt("idModalidad")), i, 24);
                    xmodelo.setValueAt(Integer.valueOf(rs.getInt("idEntornoAtencion")), i, 25);
                    xmodelo.setValueAt(Integer.valueOf(rs.getInt("idTipoDiscapacidad")), i, 26);
                    JTBProgCitasNoPro.setDefaultRenderer(Object.class, new MiRender1());
                    i++;
                }
            }
            rs.close();
            xmt.cerrarConexionBd();
        } catch (SQLException e) {
        }
    }

    public static void mEStadoAtenciones() {
        try {
            ConsultasMySQL xmt1 = new ConsultasMySQL();
            String sql = "SELECT Id  FROM h_atencionespeciales WHERE (Id_Profesional ='" + xidpro + "'AND Id_Especialidad ='" + xidesp + "' and Id_Sede='" + Principal.sedeUsuarioSeleccionadaDTO.getId() + "' AND DATE_FORMAT(Fecha_Atencion,'%d/%m/%Y')='" + xfechaatencion + "') ";
            ResultSet rs = xmt1.traerRs(sql);
            if (rs.next()) {
                JBTAtencionesPendientes.setVisible(true);
            } else {
                JBTAtencionesPendientes.setVisible(false);
            }
            rs.close();
            xmt1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFAgendaMedico.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
