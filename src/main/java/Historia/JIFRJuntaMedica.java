package Historia;

import Acceso.Principal;
import General.BuscarPersona;
import General.Persona;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JIFRJuntaMedica.class */
public class JIFRJuntaMedica extends JInternalFrame {
    private String[] xidespeciliadad;
    private String[] xidprofesional;
    private clasesHistoriaCE xclase;
    public Persona xjppersona;
    private DefaultTableModel xmodelo;
    private DefaultTableModel xmodelo1;
    private DefaultTableModel xmodelo2;
    private Object[] xdatos;
    private boolean xestado;
    private ButtonGroup JBGOpciones;
    private JButton JBTAdicionar;
    private JButton JBTAdicionarA;
    private JComboBox JCBEspecialidad;
    private JComboBox JCBProfesional;
    private JDateChooser JDCFecha;
    private JPanel JPAsistentes;
    private JPanel JPConclusiones;
    private JPanel JPDatosVis;
    private JPanel JPDescripcion;
    private JPanel JPIFDatosUsuario;
    private JScrollPane JSPAsistentes;
    private JScrollPane JSPConclusiones;
    private JScrollPane JSPDConclusion;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPMotivo;
    private JScrollPane JSPResumen;
    private JScrollPane JSPResumenA;
    private JScrollPane JSPResumenH;
    private JTable JTDetalle;
    private JTable JTDetalleA;
    private JTable JTDetalleC;
    private JFormattedTextField JTFFHora;
    private JTabbedPane JTPActa;
    private JTextPane JTPDConclusion;
    private JTabbedPane JTPDatosJunta;
    public JTextPane JTPMotivo;
    private JTextPane JTPResumen;
    private JTextPane JTPResumenA;
    private JTextPane JTPResumenH;
    private int xnfm2 = 0;
    private int xnfm1 = 0;
    private int xcerrado = 0;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodos = new Metodos();
    private boolean xestadog = false;

    public JIFRJuntaMedica(clasesHistoriaCE xclase) {
        this.xestado = false;
        initComponents();
        this.xclase = xclase;
        mCargasPanelUsuario();
        this.JDCFecha.setDate(this.xmetodos.getFechaActual());
        this.JTFFHora.setText(this.xmetodos.formatoH24.format(this.xmetodos.getFechaActual()));
        this.xidespeciliadad = this.xconsultasbd.llenarCombo("SELECT g_especialidad.Id, g_especialidad.Nbre FROM baseserver.profesional1 INNER JOIN baseserver.g_especialidad  ON (profesional1.IdEspecialidad = g_especialidad.Id) WHERE (g_especialidad.Estado =0)  GROUP BY g_especialidad.Id ORDER BY g_especialidad.Nbre ASC ", this.xidespeciliadad, this.JCBEspecialidad);
        this.JCBEspecialidad.setSelectedIndex(-1);
        this.xconsultasbd.cerrarConexionBd();
        mCrearModeloDatos();
        mCrearModeloDatos1();
        mCrearModeloDatos2();
        this.xestado = true;
    }

    /* JADX WARN: Type inference failed for: r3v121, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v56, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v82, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGOpciones = new ButtonGroup();
        this.JPIFDatosUsuario = new JPanel();
        this.JTPDatosJunta = new JTabbedPane();
        this.JPDatosVis = new JPanel();
        this.JTPActa = new JTabbedPane();
        this.JPDescripcion = new JPanel();
        this.JDCFecha = new JDateChooser();
        this.JTFFHora = new JFormattedTextField();
        this.JSPMotivo = new JScrollPane();
        this.JTPMotivo = new JTextPane();
        this.JSPResumen = new JScrollPane();
        this.JTPResumen = new JTextPane();
        this.JSPResumenA = new JScrollPane();
        this.JTPResumenA = new JTextPane();
        this.JSPResumenH = new JScrollPane();
        this.JTPResumenH = new JTextPane();
        this.JPConclusiones = new JPanel();
        this.JSPDConclusion = new JScrollPane();
        this.JTPDConclusion = new JTextPane();
        this.JSPConclusiones = new JScrollPane();
        this.JTDetalleC = new JTable();
        this.JBTAdicionar = new JButton();
        this.JPAsistentes = new JPanel();
        this.JSPAsistentes = new JScrollPane();
        this.JTDetalleA = new JTable();
        this.JBTAdicionarA = new JButton();
        this.JCBEspecialidad = new JComboBox();
        this.JCBProfesional = new JComboBox();
        this.JSPHistorico = new JScrollPane();
        this.JTDetalle = new JTable();
        setClosable(true);
        setIconifiable(true);
        setTitle("JUNTA MEDICA");
        setFrameIcon(new ImageIcon(getClass().getResource("/Imagenes/genomap.png")));
        setMaximumSize(new Dimension(1050, 807));
        setMinimumSize(new Dimension(1050, 807));
        setName("jifjuntamedica");
        setOpaque(true);
        setPreferredSize(new Dimension(1050, 807));
        addInternalFrameListener(new InternalFrameListener() { // from class: Historia.JIFRJuntaMedica.1
            public void internalFrameClosed(InternalFrameEvent evt) {
            }

            public void internalFrameClosing(InternalFrameEvent evt) {
                JIFRJuntaMedica.this.formInternalFrameClosing(evt);
            }

            public void internalFrameOpened(InternalFrameEvent evt) {
            }

            public void internalFrameActivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeactivated(InternalFrameEvent evt) {
            }

            public void internalFrameDeiconified(InternalFrameEvent evt) {
            }

            public void internalFrameIconified(InternalFrameEvent evt) {
            }
        });
        this.JPIFDatosUsuario.setBorder(BorderFactory.createTitledBorder((Border) null, "INFORMACIÓN DEL USUARIO", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        GroupLayout JPIFDatosUsuarioLayout = new GroupLayout(this.JPIFDatosUsuario);
        this.JPIFDatosUsuario.setLayout(JPIFDatosUsuarioLayout);
        JPIFDatosUsuarioLayout.setHorizontalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 991, 32767));
        JPIFDatosUsuarioLayout.setVerticalGroup(JPIFDatosUsuarioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 167, 32767));
        this.JTPDatosJunta.setForeground(new Color(255, 0, 0));
        this.JTPDatosJunta.setFont(new Font("Arial", 1, 14));
        this.JPDatosVis.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 14), new Color(0, 153, 51)));
        this.JTPActa.setForeground(new Color(0, 103, 0));
        this.JTPActa.setTabPlacement(2);
        this.JTPActa.setFont(new Font("Arial", 1, 14));
        this.JPDescripcion.setBorder(BorderFactory.createEtchedBorder());
        this.JDCFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "FECHA", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDCFecha.setDateFormatString("dd/MM/yyyy");
        this.JDCFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFHora.setBorder(BorderFactory.createTitledBorder((Border) null, "HORA", 0, 0, new Font("Tahoma", 1, 12), Color.blue));
        this.JTFFHora.setHorizontalAlignment(4);
        this.JTFFHora.setFont(new Font("Arial", 1, 12));
        this.JSPMotivo.setBorder(BorderFactory.createTitledBorder((Border) null, "MOTIVO  DE LA JUNTA;  QUE SE DESEA ACLARAR:", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPMotivo.setFont(new Font("Arial", 1, 12));
        this.JTPMotivo.addKeyListener(new KeyAdapter() { // from class: Historia.JIFRJuntaMedica.2
            public void keyPressed(KeyEvent evt) {
                JIFRJuntaMedica.this.JTPMotivoKeyPressed(evt);
            }
        });
        this.JSPMotivo.setViewportView(this.JTPMotivo);
        this.JSPResumen.setBorder(BorderFactory.createTitledBorder((Border) null, "RESUMEN O SÍNTESIS DE LA HISTORIA CLÍNICA; ASPECTOS MÁS RELEVANTES:", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPResumen.setFont(new Font("Arial", 1, 12));
        this.JTPResumen.addKeyListener(new KeyAdapter() { // from class: Historia.JIFRJuntaMedica.3
            public void keyPressed(KeyEvent evt) {
                JIFRJuntaMedica.this.JTPResumenKeyPressed(evt);
            }
        });
        this.JSPResumen.setViewportView(this.JTPResumen);
        this.JSPResumenA.setBorder(BorderFactory.createTitledBorder((Border) null, "RESUMEN DE APOYOS DIAGNÓSTICOS:", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPResumenA.setFont(new Font("Arial", 1, 12));
        this.JTPResumenA.addKeyListener(new KeyAdapter() { // from class: Historia.JIFRJuntaMedica.4
            public void keyPressed(KeyEvent evt) {
                JIFRJuntaMedica.this.JTPResumenAKeyPressed(evt);
            }
        });
        this.JSPResumenA.setViewportView(this.JTPResumenA);
        this.JSPResumenH.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGOS ADICIONALES ENCONTRADOS EN JUNTA MÉDICA:", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPResumenH.setFont(new Font("Arial", 1, 12));
        this.JTPResumenH.addKeyListener(new KeyAdapter() { // from class: Historia.JIFRJuntaMedica.5
            public void keyPressed(KeyEvent evt) {
                JIFRJuntaMedica.this.JTPResumenHKeyPressed(evt);
            }
        });
        this.JSPResumenH.setViewportView(this.JTPResumenH);
        GroupLayout JPDescripcionLayout = new GroupLayout(this.JPDescripcion);
        this.JPDescripcion.setLayout(JPDescripcionLayout);
        JPDescripcionLayout.setHorizontalGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDescripcionLayout.createSequentialGroup().addContainerGap().addGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPResumenH, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPDescripcionLayout.createSequentialGroup().addGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFHora).addComponent(this.JDCFecha, -1, 134, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPMotivo, -2, 701, -2)).addComponent(this.JSPResumenA, GroupLayout.Alignment.LEADING).addComponent(this.JSPResumen, GroupLayout.Alignment.LEADING, -1, 829, 32767)).addContainerGap(-1, 32767)));
        JPDescripcionLayout.setVerticalGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDescripcionLayout.createSequentialGroup().addContainerGap().addGroup(JPDescripcionLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPDescripcionLayout.createSequentialGroup().addComponent(this.JDCFecha, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFHora, -2, -1, -2)).addComponent(this.JSPMotivo, -2, 102, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResumen, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPResumenA, -2, 99, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPResumenH, -2, 99, -2).addContainerGap()));
        this.JTPActa.addTab("DATOS", this.JPDescripcion);
        this.JPConclusiones.setBorder(BorderFactory.createEtchedBorder());
        this.JSPDConclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPDConclusion.setFont(new Font("Arial", 1, 12));
        this.JSPDConclusion.setViewportView(this.JTPDConclusion);
        this.JSPConclusiones.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTDetalleC.setFont(new Font("Arial", 1, 12));
        this.JTDetalleC.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleC.setRowHeight(25);
        this.JTDetalleC.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleC.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleC.setSelectionMode(0);
        this.JTDetalleC.addKeyListener(new KeyAdapter() { // from class: Historia.JIFRJuntaMedica.6
            public void keyPressed(KeyEvent evt) {
                JIFRJuntaMedica.this.JTDetalleCKeyPressed(evt);
            }
        });
        this.JSPConclusiones.setViewportView(this.JTDetalleC);
        this.JBTAdicionar.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.JBTAdicionar.setText("Adicionar");
        this.JBTAdicionar.addActionListener(new ActionListener() { // from class: Historia.JIFRJuntaMedica.7
            public void actionPerformed(ActionEvent evt) {
                JIFRJuntaMedica.this.JBTAdicionarActionPerformed(evt);
            }
        });
        GroupLayout JPConclusionesLayout = new GroupLayout(this.JPConclusiones);
        this.JPConclusiones.setLayout(JPConclusionesLayout);
        JPConclusionesLayout.setHorizontalGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConclusionesLayout.createSequentialGroup().addContainerGap().addGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionar, -1, 810, 32767).addComponent(this.JSPConclusiones, -1, 810, 32767).addComponent(this.JSPDConclusion, -1, 810, 32767)).addContainerGap()));
        JPConclusionesLayout.setVerticalGroup(JPConclusionesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPConclusionesLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPDConclusion, -2, 79, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTAdicionar, -1, -1, 32767).addGap(9, 9, 9).addComponent(this.JSPConclusiones, -2, 326, -2).addGap(57, 57, 57)));
        this.JTPActa.addTab("CONCLUSIONES", this.JPConclusiones);
        this.JPAsistentes.setBorder(BorderFactory.createEtchedBorder());
        this.JSPAsistentes.setBorder(BorderFactory.createTitledBorder((Border) null, "Detalle", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTDetalleA.setFont(new Font("Arial", 1, 12));
        this.JTDetalleA.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalleA.setRowHeight(25);
        this.JTDetalleA.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalleA.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalleA.setSelectionMode(0);
        this.JTDetalleA.addKeyListener(new KeyAdapter() { // from class: Historia.JIFRJuntaMedica.8
            public void keyPressed(KeyEvent evt) {
                JIFRJuntaMedica.this.JTDetalleAKeyPressed(evt);
            }
        });
        this.JSPAsistentes.setViewportView(this.JTDetalleA);
        this.JBTAdicionarA.setFont(new Font("Arial", 1, 12));
        this.JBTAdicionarA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/ok29x27.png")));
        this.JBTAdicionarA.setText("Adicionar");
        this.JBTAdicionarA.addActionListener(new ActionListener() { // from class: Historia.JIFRJuntaMedica.9
            public void actionPerformed(ActionEvent evt) {
                JIFRJuntaMedica.this.JBTAdicionarAActionPerformed(evt);
            }
        });
        this.JCBEspecialidad.setFont(new Font("Arial", 1, 12));
        this.JCBEspecialidad.setBorder(BorderFactory.createTitledBorder((Border) null, "Especialidad", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBEspecialidad.addItemListener(new ItemListener() { // from class: Historia.JIFRJuntaMedica.10
            public void itemStateChanged(ItemEvent evt) {
                JIFRJuntaMedica.this.JCBEspecialidadItemStateChanged(evt);
            }
        });
        this.JCBProfesional.setFont(new Font("Arial", 1, 12));
        this.JCBProfesional.setBorder(BorderFactory.createTitledBorder((Border) null, "Profesional", 2, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPAsistentesLayout = new GroupLayout(this.JPAsistentes);
        this.JPAsistentes.setLayout(JPAsistentesLayout);
        JPAsistentesLayout.setHorizontalGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAsistentesLayout.createSequentialGroup().addContainerGap().addGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTAdicionarA, -1, 810, 32767).addComponent(this.JSPAsistentes, -1, 810, 32767).addGroup(JPAsistentesLayout.createSequentialGroup().addComponent(this.JCBEspecialidad, -2, 292, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCBProfesional, 0, 508, 32767))).addContainerGap()));
        JPAsistentesLayout.setVerticalGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAsistentesLayout.createSequentialGroup().addContainerGap().addGroup(JPAsistentesLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBEspecialidad, -1, 61, 32767).addComponent(this.JCBProfesional, -1, 61, 32767)).addGap(24, 24, 24).addComponent(this.JBTAdicionarA, -1, -1, 32767).addGap(9, 9, 9).addComponent(this.JSPAsistentes, -2, 326, -2).addGap(57, 57, 57)));
        this.JTPActa.addTab("ASISTENTES", this.JPAsistentes);
        GroupLayout JPDatosVisLayout = new GroupLayout(this.JPDatosVis);
        this.JPDatosVis.setLayout(JPDatosVisLayout);
        JPDatosVisLayout.setHorizontalGroup(JPDatosVisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosVisLayout.createSequentialGroup().addContainerGap().addComponent(this.JTPActa, -2, 966, -2).addContainerGap(12, 32767)));
        JPDatosVisLayout.setVerticalGroup(JPDatosVisLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosVisLayout.createSequentialGroup().addComponent(this.JTPActa, -2, 503, -2).addContainerGap(-1, 32767)));
        this.JTPDatosJunta.addTab("ACTA", this.JPDatosVis);
        this.JSPHistorico.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JTDetalle.setFont(new Font("Arial", 1, 12));
        this.JTDetalle.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTDetalle.setRowHeight(25);
        this.JTDetalle.setSelectionBackground(new Color(255, 255, 255));
        this.JTDetalle.setSelectionForeground(new Color(255, 0, 0));
        this.JTDetalle.setSelectionMode(0);
        this.JTDetalle.addMouseListener(new MouseAdapter() { // from class: Historia.JIFRJuntaMedica.11
            public void mouseClicked(MouseEvent evt) {
                JIFRJuntaMedica.this.JTDetalleMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTDetalle);
        this.JTPDatosJunta.addTab("HISTÓRICO", this.JSPHistorico);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -1, -1, 32767).addContainerGap(23, 32767)).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.JTPDatosJunta, -2, 997, -2).addContainerGap(17, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JPIFDatosUsuario, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPDatosJunta, -2, 545, -2).addContainerGap(23, 32767)));
        pack();
    }

    private void txtFechaNacimientoFocusLost(FocusEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formInternalFrameClosing(InternalFrameEvent evt) {
        dispose();
        Principal.mLimpiarDatosP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPMotivoKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPMotivo.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPMotivo.setText(this.JTPMotivo.getText().substring(0, this.JTPMotivo.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleMouseClicked(MouseEvent evt) {
        if (this.JTDetalle.getSelectedRow() != -1 && this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString().equals("false")) {
            Principal.txtNo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString());
            this.JTPMotivo.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 3).toString());
            this.JTPResumen.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 4).toString());
            this.JTPResumenA.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 5).toString());
            this.JTPResumenH.setText(this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 8).toString());
            this.JTPDatosJunta.setSelectedIndex(0);
            this.xestadog = true;
            return;
        }
        if (this.JTDetalle.getSelectedRow() != -1 && this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 6).toString().equals("true")) {
            mImprimir();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPResumenAKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPResumenA.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPResumenA.setText(this.JTPResumenA.getText().substring(0, this.JTPResumenA.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPResumenHKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPResumenH.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPResumenH.setText(this.JTPResumenH.getText().substring(0, this.JTPResumenH.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCBEspecialidadItemStateChanged(ItemEvent evt) {
        if (this.xestado && this.JCBEspecialidad.getSelectedIndex() != -1) {
            this.JCBProfesional.removeAllItems();
            this.xidprofesional = this.xconsultasbd.llenarCombo("SELECT Id_Persona, NProfesional FROM baseserver.profesional1 WHERE (IdEspecialidad ='" + this.xidespeciliadad[this.JCBEspecialidad.getSelectedIndex()] + "') ORDER BY NProfesional ASC", this.xidprofesional, this.JCBProfesional);
            this.JCBProfesional.setSelectedIndex(-1);
            this.xconsultasbd.cerrarConexionBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarActionPerformed(ActionEvent evt) {
        if (!this.JTPDConclusion.getText().isEmpty()) {
            this.xmodelo1.addRow(this.xdatos);
            this.xmodelo1.setValueAt(this.JTPDConclusion.getText(), this.xnfm1, 0);
            this.xnfm1++;
            this.JTPDConclusion.setText("");
            this.JTPDConclusion.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleCKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleC.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmodelo1.removeRow(this.JTDetalleC.getSelectedRow());
                this.xnfm1--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPResumenKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPResumen.transferFocus();
        } else if (evt.getKeyCode() == 222) {
            JOptionPane.showInternalMessageDialog(this, "Caracter(') no valido, \nFavor reemplazarlo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTPResumen.setText(this.JTPResumen.getText().substring(0, this.JTPResumen.getText().length() - 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTAdicionarAActionPerformed(ActionEvent evt) {
        if (this.JCBEspecialidad.getSelectedIndex() != -1 && this.JCBProfesional.getSelectedIndex() != -1) {
            this.xmodelo2.addRow(this.xdatos);
            this.xmodelo2.setValueAt(Long.valueOf(this.xidprofesional[this.JCBProfesional.getSelectedIndex()]), this.xnfm2, 0);
            this.xmodelo2.setValueAt(this.JCBProfesional.getSelectedItem().toString(), this.xnfm2, 1);
            this.xmodelo2.setValueAt(Long.valueOf(this.xidespeciliadad[this.JCBEspecialidad.getSelectedIndex()]), this.xnfm2, 2);
            this.xmodelo2.setValueAt(this.JCBEspecialidad.getSelectedItem().toString(), this.xnfm2, 3);
            this.xnfm2++;
            this.JCBProfesional.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTDetalleAKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTDetalleA.getSelectedRow() != -1) {
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de eliminar la fila", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                this.xmodelo2.removeRow(this.JTDetalleA.getSelectedRow());
                this.xnfm2--;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos() {
        this.xmodelo = new DefaultTableModel(new Object[0], new String[]{"Id", "Fecha", "Hora", "Motivo", "Resumen HC", "Resumen Ayudas Dx", "Estado", "", ""}) { // from class: Historia.JIFRJuntaMedica.12
            Class[] types = {Long.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalle.setModel(this.xmodelo);
        this.JTDetalle.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalle.getColumnModel().getColumn(1).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(2).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(3).setPreferredWidth(200);
        this.JTDetalle.getColumnModel().getColumn(4).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(5).setPreferredWidth(100);
        this.JTDetalle.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTDetalle.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(7).setMaxWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setPreferredWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMinWidth(0);
        this.JTDetalle.getColumnModel().getColumn(8).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos1() {
        this.xmodelo1 = new DefaultTableModel(new Object[0], new String[]{"Conclusión"}) { // from class: Historia.JIFRJuntaMedica.13
            Class[] types = {String.class};
            boolean[] canEdit = {false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleC.setModel(this.xmodelo1);
        this.JTDetalleC.getColumnModel().getColumn(0).setPreferredWidth(500);
        this.xnfm1 = 0;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloDatos2() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"IdP", "Profesional", "IdE", "Especialidad"}) { // from class: Historia.JIFRJuntaMedica.14
            Class[] types = {Long.class, String.class, Long.class, String.class};
            boolean[] canEdit = {false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTDetalleA.setModel(this.xmodelo2);
        this.JTDetalleA.getColumnModel().getColumn(0).setPreferredWidth(10);
        this.JTDetalleA.getColumnModel().getColumn(1).setPreferredWidth(300);
        this.JTDetalleA.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTDetalleA.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.xnfm2 = 0;
    }

    public void mCargarDatosTabla() {
        try {
            mCrearModeloDatos();
            String sql = "SELECT Id, DATE_FORMAT(Fechaj,'%d-%m-%Y'), Hora, Motivo, ResumenHc, ResumenADx, Estado, IF(HallazgosE IS NULL,'',HallazgosE) AS Hallazgo FROM h_rjuntamedica WHERE (Id_Usuario ='" + this.xjppersona.getIdPersona() + "') ORDER BY Fechaj DESC, Hora DESC";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo.addRow(this.xdatos);
                    this.xmodelo.setValueAt(Long.valueOf(xrs.getLong(1)), n, 0);
                    this.xmodelo.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo.setValueAt(xrs.getString(5), n, 4);
                    this.xmodelo.setValueAt(xrs.getString(6), n, 5);
                    this.xmodelo.setValueAt(Boolean.valueOf(xrs.getBoolean(7)), n, 6);
                    this.xmodelo.setValueAt(Integer.valueOf(xrs.getInt(7)), n, 7);
                    this.xmodelo.setValueAt(xrs.getString(8), n, 8);
                    n++;
                }
            }
            xrs.close();
            this.xconsultasbd.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JIFRJuntaMedica.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargasPanelUsuario() {
        this.xjppersona = new Persona(this);
        this.xjppersona.setVisible(true);
        this.JPIFDatosUsuario.setVisible(false);
        this.xjppersona.setBounds(5, 15, 950, 160);
        this.JPIFDatosUsuario.add(this.xjppersona);
        this.JPIFDatosUsuario.setVisible(true);
    }

    public void grabar() {
        if (Principal.txtNo.getText().isEmpty() && mValidarDatosC()) {
            int xc = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (xc == 0) {
                mGuardarDatoCompleto();
                mCargarDatosTabla();
            }
        }
    }

    public void mGuardarDatosIniciales() {
        String sql = "Insert into baseserver.h_rjuntamedica (Fechaj, Hora, Id_Usuario, Motivo, ResumenHC, ResumenADx, HallazgosE, UsuarioS, Fecha) Values('" + this.xmetodos.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + this.xjppersona.getIdPersona() + "','" + this.JTPMotivo.getText() + "','" + this.JTPResumen.getText() + "','" + this.JTPResumenA.getText() + "','" + this.JTPResumenH.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
        Principal.txtNo.setText(this.xconsultasbd.ejecutarSQLId(sql));
        this.xconsultasbd.cerrarConexionBd();
    }

    public void mGuardarDatoCompleto() {
        String sql = "Insert into baseserver.h_rjuntamedica (Fechaj, Hora, Id_Usuario, Motivo, ResumenHC, ResumenADx, HallazgosE, Estado, UsuarioS, Fecha) Values('" + this.xmetodos.formatoAMD.format(this.JDCFecha.getDate()) + "','" + this.JTFFHora.getText() + "','" + this.xjppersona.getIdPersona() + "','" + this.JTPMotivo.getText() + "','" + this.JTPResumen.getText() + "','" + this.JTPResumenA.getText() + "','" + this.JTPResumenH.getText() + "','1','" + Principal.usuarioSistemaDTO.getLogin() + "','" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "')";
        Principal.txtNo.setText(this.xconsultasbd.ejecutarSQLId(sql));
        this.xconsultasbd.cerrarConexionBd();
        mGrabarDetalle();
    }

    public void mActualizarDato() {
        String sql = "Update baseserver.h_rjuntamedica set Fechaj='" + this.xmetodos.formatoAMD.format(this.JDCFecha.getDate()) + "', Hora='" + this.JTFFHora.getText() + "', Motivo='" + this.JTPMotivo.getText() + "', ResumenHC='" + this.JTPResumen.getText() + "', ResumenADx='" + this.JTPResumenA.getText() + "', HallazgosE='" + this.JTPResumenH.getText() + "', Estado='" + this.xcerrado + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', Fecha='" + this.xmetodos.formatoAMDH24.format(this.xmetodos.getFechaActual()) + "' where Id='" + Principal.txtNo.getText() + "'";
        this.xconsultasbd.ejecutarSQL(sql);
        this.xconsultasbd.cerrarConexionBd();
        mGrabarDetalle();
    }

    private void mGrabarDetalle() {
        for (int x = 0; x < this.JTDetalleC.getRowCount(); x++) {
            String sql = "Insert into baseserver.h_rdetalle_conclusion (Id_rjunta, NOrden, DetalleC) Values('" + Principal.txtNo.getText() + "','" + (x + 1) + "','" + this.xmodelo1.getValueAt(x, 0) + "')";
            this.xconsultasbd.ejecutarSQL(sql);
            this.xconsultasbd.cerrarConexionBd();
        }
        for (int y = 0; y < this.JTDetalleA.getRowCount(); y++) {
            String sql2 = "Insert into baseserver.h_rasistentesjunta (Id_rjunta, Id_Profesional, Id_Especialidad) Values('" + Principal.txtNo.getText() + "','" + this.xmodelo2.getValueAt(y, 0) + "','" + this.xmodelo2.getValueAt(y, 2) + "')";
            this.xconsultasbd.ejecutarSQL(sql2);
            this.xconsultasbd.cerrarConexionBd();
        }
        mCargarDatosTabla();
    }

    private void mLimpiarComponentes() {
        Principal.mLimpiarDatosP();
        this.JDCFecha.setDate(this.xmetodos.getFechaActual());
        this.JTFFHora.setText(this.xmetodos.formatoH24.format(this.xmetodos.getFechaActual()));
        this.JTPMotivo.setText("");
        this.JTPDConclusion.setText("");
        this.JTPResumen.setText("");
        this.JTPResumenA.setText("");
        this.JTPResumenH.setText("");
        mCrearModeloDatos();
        mCrearModeloDatos1();
        mCrearModeloDatos2();
        this.xestadog = false;
        this.JDCFecha.requestFocus();
    }

    public void nuevo() {
        Object[] botones = {"Usuario", "Junta", "Cerrar"};
        int n = JOptionPane.showInternalOptionDialog(this, "Que desea hacer", "NUEVO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))), botones, "Cerrar");
        if (n == 0) {
            this.xjppersona.nuevo();
            mLimpiarComponentes();
        } else if (n == 1) {
            mLimpiarComponentes();
        }
    }

    public void buscar() {
        BuscarPersona frmBuscar = new BuscarPersona(null, true, this.xjppersona);
        frmBuscar.setVisible(true);
    }

    private boolean mValidarDatosC() {
        boolean xver = false;
        if (!this.JTPMotivo.getText().isEmpty()) {
            if (this.JTDetalleC.getRowCount() > 0) {
                if (this.JTDetalleA.getRowCount() > 0) {
                    xver = true;
                } else {
                    this.JTPActa.setSelectedIndex(2);
                    JOptionPane.showInternalMessageDialog(this, "Deber registrar asistentes", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                    this.JCBEspecialidad.requestFocus();
                }
            } else {
                this.JTPActa.setSelectedIndex(1);
                JOptionPane.showInternalMessageDialog(this, "Deber registrar conclusión", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
                this.JTPDConclusion.requestFocus();
            }
        } else {
            this.JTPActa.setSelectedIndex(0);
            JOptionPane.showInternalMessageDialog(this, "Motivo no puede ser nula", "VERIFICAR", 0, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Error.png"))));
            this.JTPMotivo.requestFocus();
        }
        return xver;
    }

    public void mImprimir() {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "id";
        parametros[0][1] = this.xmodelo.getValueAt(this.JTDetalle.getSelectedRow(), 0).toString();
        parametros[1][0] = "usuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "H_ActaMedica", parametros);
    }

    public void mImprimir1() {
        String[][] parametros = new String[4][2];
        parametros[0][0] = "id";
        parametros[0][1] = Principal.txtNo.getText();
        parametros[1][0] = "usuario";
        parametros[1][1] = Principal.usuarioSistemaDTO.getLogin();
        parametros[2][0] = "SUBREPORT_DIR";
        parametros[2][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Reportes" + this.xmetodos.getBarra();
        parametros[3][0] = "SUBREPORTFIRMA_DIR";
        parametros[3][1] = this.xmetodos.getSO() + this.xmetodos.getBarra() + "Firmas" + this.xmetodos.getBarra();
        this.xmetodos.GenerarPDF(this.xmetodos.getRutaRep() + "H_ActaMedica", parametros);
    }
}
