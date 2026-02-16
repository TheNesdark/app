package Historia;

import Acceso.Principal;
import General.JIFBuscarDatos;
import General.JIFBuscarPatologia;
import Odontologia.JIFHistoriaOdontologica;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecentesOcupacionales.class */
public class JPAAntecentesOcupacionales extends JPanel {
    private String[] xidelementospp;
    private DefaultTableModel xmodelohp;
    private DefaultTableModel xmodelop;
    private DefaultTableModel xmodelou;
    private DefaultTableModel xmodeloa;
    private DefaultTableModel xmodeloe;
    private DefaultTableModel xmodelolesion;
    private DefaultTableModel xmodelopafectada;
    private clasesHistoriaCE xclase;
    private Object[] xdato;
    private int xmod;
    public long xidusuario;
    private String xidatencion;
    private String xsql;
    private JIFHistoriaOdontologica xjifcho;
    private JIFBuscarDatos xjifbuscardatos;
    private ButtonGroup JBGElementosPP;
    private ButtonGroup JBGVive;
    private JButton JBTPAdicionarAt;
    private JButton JBTPAdicionarEnfermedad;
    private JButton JBTPAdicionarPeligro;
    private JButton JBTPLimpiarAccidentes;
    private JButton JBTPLimpiarEnfermedad;
    private JButton JBTPLimpiarPeligro;
    private JButton JBTUAdicionarElementoP;
    private JComboBox JCBUElementosPP;
    private JPanel JPAccidentes;
    private JPanel JPElePP;
    private JPanel JPElementosPP;
    private JPanel JPEnfermedadP;
    private JPanel JPIDatosAt;
    private JPanel JPIDatosElementosPP;
    private JPanel JPIDatosEp;
    private JPanel JPIDatosPeligros;
    private JPanel JPPeligros;
    private JRadioButton JRBNO;
    private JRadioButton JRBSi;
    private JScrollPane JSPACausa;
    private JSpinner JSPADiasI;
    private JScrollPane JSPAObservacionAT;
    private JScrollPane JSPASecuelas;
    private JSpinner JSPAno;
    private JScrollPane JSPEIndemnizacion;
    private JScrollPane JSPEObservacionEP;
    private JScrollPane JSPEReubicacion;
    private JScrollPane JSPHistorialA;
    private JScrollPane JSPHistorialEP;
    private JScrollPane JSPHistorialP;
    private JScrollPane JSPHistorialU;
    private JSpinner JSPMes;
    private JScrollPane JSPPExpuestos;
    private JScrollPane JSPPObservacionesPeligro;
    private JScrollPane JSPParteAfectada;
    private JScrollPane JSPTipoLesion;
    private JScrollPane JSPUObservacionesElementoP;
    private JTextField JTFFAEmpresa;
    private JTextField JTFFAFecha;
    public JTextField JTFFCodigoPat;
    private JTextField JTFFEEmpresa;
    private JTextField JTFFEEmpresaArl;
    private JTextField JTFFEEmpresaArlAcciente;
    private JTextField JTFFEFecha;
    private JTextField JTFFESEG;
    public JTextField JTFFNombrePat;
    private JTextField JTFFPCargo;
    private JTextField JTFFPEmpresa;
    private JTextPane JTPACausa;
    private JTextPane JTPAObservacionAT;
    private JTextPane JTPASecuelas;
    private JTabbedPane JTPDatos;
    private JTextPane JTPEIndemnizacion;
    private JTextPane JTPEObservacionEP;
    private JTextPane JTPEReubicacion;
    private JTable JTPHistorialA;
    private JTable JTPHistorialEP;
    private JTable JTPHistorialP;
    private JTable JTPHistorialU;
    private JTable JTPPExpuestos;
    private JTextPane JTPPObservacionesPeligros;
    private JTextPane JTPUObservacionesElementoP;
    private JTable JTParteAfectada;
    private JTable JTTipoLesion;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xidpeligroexpuesto = "0";
    private String xidaccidentetrabajo = "0";
    private String xidenfermedadprofesional = "0";
    private int xelementopp = 0;
    private int xbuscardatos = 0;
    private boolean xguardarat = false;
    private boolean xguardarel = false;
    private boolean xguardarUE = false;

    public JPAAntecentesOcupacionales(clasesHistoriaCE xclase, int xmod) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mNuevo();
    }

    public JPAAntecentesOcupacionales(JIFHistoriaOdontologica xjifcho, int xmod) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xjifcho = xjifcho;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v113, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v118, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v156, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v232, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v272, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v74, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGVive = new ButtonGroup();
        this.JBGElementosPP = new ButtonGroup();
        this.JTPDatos = new JTabbedPane();
        this.JPPeligros = new JPanel();
        this.JPIDatosPeligros = new JPanel();
        this.JTFFPEmpresa = new JTextField();
        this.JTFFPCargo = new JTextField();
        this.JSPPObservacionesPeligro = new JScrollPane();
        this.JTPPObservacionesPeligros = new JTextPane();
        this.JSPPExpuestos = new JScrollPane();
        this.JTPPExpuestos = new JTable();
        this.JBTPAdicionarPeligro = new JButton();
        this.JSPAno = new JSpinner();
        this.JSPMes = new JSpinner();
        this.JPElePP = new JPanel();
        this.JRBNO = new JRadioButton();
        this.JRBSi = new JRadioButton();
        this.JBTPLimpiarPeligro = new JButton();
        this.JSPHistorialP = new JScrollPane();
        this.JTPHistorialP = new JTable();
        this.JPAccidentes = new JPanel();
        this.JPIDatosAt = new JPanel();
        this.JTFFAEmpresa = new JTextField();
        this.JTFFAFecha = new JTextField();
        this.JSPACausa = new JScrollPane();
        this.JTPACausa = new JTextPane();
        this.JSPADiasI = new JSpinner();
        this.JSPASecuelas = new JScrollPane();
        this.JTPASecuelas = new JTextPane();
        this.JSPAObservacionAT = new JScrollPane();
        this.JTPAObservacionAT = new JTextPane();
        this.JBTPAdicionarAt = new JButton();
        this.JSPTipoLesion = new JScrollPane();
        this.JTTipoLesion = new JTable();
        this.JSPParteAfectada = new JScrollPane();
        this.JTParteAfectada = new JTable();
        this.JBTPLimpiarAccidentes = new JButton();
        this.JTFFEEmpresaArlAcciente = new JTextField();
        this.JSPHistorialA = new JScrollPane();
        this.JTPHistorialA = new JTable();
        this.JPEnfermedadP = new JPanel();
        this.JPIDatosEp = new JPanel();
        this.JTFFEEmpresa = new JTextField();
        this.JTFFEFecha = new JTextField();
        this.JSPEIndemnizacion = new JScrollPane();
        this.JTPEIndemnizacion = new JTextPane();
        this.JSPEReubicacion = new JScrollPane();
        this.JTPEReubicacion = new JTextPane();
        this.JSPEObservacionEP = new JScrollPane();
        this.JTPEObservacionEP = new JTextPane();
        this.JBTPAdicionarEnfermedad = new JButton();
        this.JTFFCodigoPat = new JTextField();
        this.JTFFNombrePat = new JTextField();
        this.JTFFEEmpresaArl = new JTextField();
        this.JTFFESEG = new JTextField();
        this.JBTPLimpiarEnfermedad = new JButton();
        this.JSPHistorialEP = new JScrollPane();
        this.JTPHistorialEP = new JTable();
        this.JPElementosPP = new JPanel();
        this.JPIDatosElementosPP = new JPanel();
        this.JCBUElementosPP = new JComboBox();
        this.JSPUObservacionesElementoP = new JScrollPane();
        this.JTPUObservacionesElementoP = new JTextPane();
        this.JBTUAdicionarElementoP = new JButton();
        this.JSPHistorialU = new JScrollPane();
        this.JTPHistorialU = new JTable();
        setMaximumSize(null);
        setName("jifantecedentesocupacionales");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTPDatos.setInheritsPopupMenu(true);
        this.JPIDatosPeligros.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFPEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFFPEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPEmpresa.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.1
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFPEmpresaMouseClicked(evt);
            }
        });
        this.JTFFPEmpresa.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.2
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFPEmpresaKeyPressed(evt);
            }
        });
        this.JTFFPCargo.setFont(new Font("Arial", 1, 12));
        this.JTFFPCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPCargo.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.3
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFPCargoMouseClicked(evt);
            }
        });
        this.JSPPObservacionesPeligro.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPPObservacionesPeligros.setFont(new Font("Arial", 1, 12));
        this.JTPPObservacionesPeligros.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.4
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JTPPObservacionesPeligrosKeyPressed(evt);
            }
        });
        this.JSPPObservacionesPeligro.setViewportView(this.JTPPObservacionesPeligros);
        this.JSPPExpuestos.setBorder(BorderFactory.createTitledBorder((Border) null, "Peligros", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPPExpuestos.setFont(new Font("Arial", 1, 12));
        this.JTPPExpuestos.setFont(new Font("Arial", 1, 12));
        this.JTPPExpuestos.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPPExpuestos.setSelectionBackground(new Color(255, 255, 255));
        this.JTPPExpuestos.setSelectionForeground(Color.red);
        this.JTPPExpuestos.setSelectionMode(0);
        this.JSPPExpuestos.setViewportView(this.JTPPExpuestos);
        this.JBTPAdicionarPeligro.setFont(new Font("Arial", 1, 14));
        this.JBTPAdicionarPeligro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTPAdicionarPeligro.setToolTipText("Grabar");
        this.JBTPAdicionarPeligro.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.5
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPAdicionarPeligroActionPerformed(evt);
            }
        });
        this.JBTPAdicionarPeligro.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.6
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPAdicionarPeligroKeyPressed(evt);
            }
        });
        this.JSPAno.setFont(new Font("Arial", 1, 12));
        this.JSPAno.setBorder(BorderFactory.createTitledBorder((Border) null, "Año", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPMes.setFont(new Font("Arial", 1, 12));
        this.JSPMes.setBorder(BorderFactory.createTitledBorder((Border) null, "Mes", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JPElePP.setBorder(BorderFactory.createTitledBorder((Border) null, "ElementosPP", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JBGElementosPP.add(this.JRBNO);
        this.JRBNO.setFont(new Font("Arial", 1, 12));
        this.JRBNO.setSelected(true);
        this.JRBNO.setText("No");
        this.JRBNO.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.7
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JRBNOActionPerformed(evt);
            }
        });
        this.JBGElementosPP.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Sí");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.8
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JRBSiActionPerformed(evt);
            }
        });
        GroupLayout JPElePPLayout = new GroupLayout(this.JPElePP);
        this.JPElePP.setLayout(JPElePPLayout);
        JPElePPLayout.setHorizontalGroup(JPElePPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPElePPLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JRBNO).addContainerGap(-1, 32767)));
        JPElePPLayout.setVerticalGroup(JPElePPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElePPLayout.createSequentialGroup().addGroup(JPElePPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNO).addComponent(this.JRBSi)).addGap(0, 0, 32767)));
        this.JBTPLimpiarPeligro.setFont(new Font("Arial", 1, 14));
        this.JBTPLimpiarPeligro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTPLimpiarPeligro.setToolTipText("Limpiar Campos");
        this.JBTPLimpiarPeligro.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.9
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPLimpiarPeligroActionPerformed(evt);
            }
        });
        this.JBTPLimpiarPeligro.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.10
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPLimpiarPeligroKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosPeligrosLayout = new GroupLayout(this.JPIDatosPeligros);
        this.JPIDatosPeligros.setLayout(JPIDatosPeligrosLayout);
        JPIDatosPeligrosLayout.setHorizontalGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addComponent(this.JTFFPEmpresa, -2, 304, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAno, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPMes, -2, 60, -2)).addComponent(this.JSPPExpuestos, -2, 438, -2)).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosPeligrosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFPCargo)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosPeligrosLayout.createSequentialGroup().addGap(15, 15, 15).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPeligrosLayout.createSequentialGroup().addComponent(this.JPElePP, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPAdicionarPeligro, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPLimpiarPeligro, -2, 61, -2).addContainerGap()).addComponent(this.JSPPObservacionesPeligro, -1, 322, 32767))))));
        JPIDatosPeligrosLayout.setVerticalGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFPEmpresa, -2, 50, -2).addComponent(this.JTFFPCargo, -2, 50, -2).addComponent(this.JSPAno, -2, -1, -2).addComponent(this.JSPMes, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addComponent(this.JSPPObservacionesPeligro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPElePP, -1, -1, 32767).addComponent(this.JBTPAdicionarPeligro, -1, -1, 32767).addComponent(this.JBTPLimpiarPeligro, -1, -1, 32767))).addComponent(this.JSPPExpuestos, -2, 98, -2)).addContainerGap(-1, 32767)));
        this.JSPHistorialP.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPHistorialP.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialP.setRowHeight(25);
        this.JTPHistorialP.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialP.setSelectionForeground(Color.red);
        this.JTPHistorialP.setSelectionMode(0);
        this.JTPHistorialP.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.11
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTPHistorialPMouseClicked(evt);
            }
        });
        this.JTPHistorialP.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.12
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JTPHistorialPKeyPressed(evt);
            }
        });
        this.JSPHistorialP.setViewportView(this.JTPHistorialP);
        GroupLayout JPPeligrosLayout = new GroupLayout(this.JPPeligros);
        this.JPPeligros.setLayout(JPPeligrosLayout);
        JPPeligrosLayout.setHorizontalGroup(JPPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPPeligrosLayout.createSequentialGroup().addContainerGap().addGroup(JPPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosPeligros, -1, -1, 32767).addComponent(this.JSPHistorialP)).addContainerGap()));
        JPPeligrosLayout.setVerticalGroup(JPPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPeligrosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosPeligros, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorialP, -1, 213, 32767).addContainerGap()));
        this.JTPDatos.addTab("PELIGROS", this.JPPeligros);
        this.JPIDatosAt.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFAEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFFAEmpresa.setAutoscrolls(false);
        this.JTFFAEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFAEmpresa.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.13
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFAEmpresaMouseClicked(evt);
            }
        });
        this.JTFFAFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFAFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPACausa.setBorder(BorderFactory.createTitledBorder((Border) null, "Causa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPACausa.setFont(new Font("Arial", 1, 12));
        this.JSPACausa.setViewportView(this.JTPACausa);
        this.JSPADiasI.setFont(new Font("Arial", 1, 12));
        this.JSPADiasI.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias Incap.", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JSPASecuelas.setBorder(BorderFactory.createTitledBorder((Border) null, "Secuelas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPASecuelas.setFont(new Font("Arial", 1, 12));
        this.JTPASecuelas.setFont(new Font("Arial", 1, 12));
        this.JSPASecuelas.setViewportView(this.JTPASecuelas);
        this.JSPAObservacionAT.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPAObservacionAT.setFont(new Font("Arial", 1, 12));
        this.JTPAObservacionAT.setFont(new Font("Arial", 1, 12));
        this.JSPAObservacionAT.setViewportView(this.JTPAObservacionAT);
        this.JBTPAdicionarAt.setFont(new Font("Arial", 1, 14));
        this.JBTPAdicionarAt.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTPAdicionarAt.setToolTipText("Grabar");
        this.JBTPAdicionarAt.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.14
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPAdicionarAtActionPerformed(evt);
            }
        });
        this.JSPTipoLesion.setBorder(BorderFactory.createTitledBorder((Border) null, "Tipo de Lesión", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPTipoLesion.setFont(new Font("Arial", 1, 12));
        this.JTTipoLesion.setFont(new Font("Arial", 1, 10));
        this.JTTipoLesion.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPTipoLesion.setViewportView(this.JTTipoLesion);
        this.JSPParteAfectada.setBorder(BorderFactory.createTitledBorder((Border) null, "Parte Afectada", 2, 0, new Font("Arial", 1, 14), Color.blue));
        this.JSPParteAfectada.setFont(new Font("Arial", 1, 12));
        this.JTParteAfectada.setFont(new Font("Arial", 1, 10));
        this.JTParteAfectada.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JSPParteAfectada.setViewportView(this.JTParteAfectada);
        this.JBTPLimpiarAccidentes.setFont(new Font("Arial", 1, 14));
        this.JBTPLimpiarAccidentes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTPLimpiarAccidentes.setToolTipText("Limpiar Campos");
        this.JBTPLimpiarAccidentes.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.15
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPLimpiarAccidentesActionPerformed(evt);
            }
        });
        this.JBTPLimpiarAccidentes.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.16
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPLimpiarAccidentesKeyPressed(evt);
            }
        });
        this.JTFFEEmpresaArlAcciente.setFont(new Font("Arial", 1, 12));
        this.JTFFEEmpresaArlAcciente.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEEmpresaArlAcciente.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.17
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFEEmpresaArlAccienteMouseClicked(evt);
            }
        });
        GroupLayout JPIDatosAtLayout = new GroupLayout(this.JPIDatosAt);
        this.JPIDatosAt.setLayout(JPIDatosAtLayout);
        JPIDatosAtLayout.setHorizontalGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addComponent(this.JSPADiasI, -2, 91, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPASecuelas, -2, 214, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAObservacionAT, -2, 275, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPAdicionarAt, -2, 104, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPLimpiarAccidentes, -2, 61, -2)).addGroup(JPIDatosAtLayout.createSequentialGroup().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFEEmpresaArlAcciente, GroupLayout.Alignment.LEADING, -2, 368, -2).addComponent(this.JSPTipoLesion, GroupLayout.Alignment.LEADING, -2, 368, -2).addComponent(this.JTFFAEmpresa, GroupLayout.Alignment.LEADING, -2, 368, -2)).addGap(12, 12, 12).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosAtLayout.createSequentialGroup().addComponent(this.JTFFAFecha, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPACausa, -2, 281, -2)).addComponent(this.JSPParteAfectada, -2, 389, -2)))).addContainerGap()));
        JPIDatosAtLayout.setVerticalGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFAEmpresa, -2, 50, -2).addComponent(this.JTFFAFecha, -2, 50, -2)).addComponent(this.JSPACausa, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFEEmpresaArlAcciente, -2, 50, -2).addGap(5, 5, 5).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPParteAfectada, -2, 110, -2).addComponent(this.JSPTipoLesion, -2, 0, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.JSPADiasI, -2, -1, -2)).addComponent(this.JBTPLimpiarAccidentes, -2, 50, -2).addComponent(this.JBTPAdicionarAt, -2, 50, -2).addComponent(this.JSPAObservacionAT, -2, 50, -2).addComponent(this.JSPASecuelas, -2, 50, -2)).addContainerGap(-1, 32767)));
        this.JSPHistorialA.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPHistorialA.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialA.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialA.setRowHeight(25);
        this.JTPHistorialA.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialA.setSelectionForeground(Color.red);
        this.JTPHistorialA.setSelectionMode(0);
        this.JTPHistorialA.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.18
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTPHistorialAMouseClicked(evt);
            }
        });
        this.JTPHistorialA.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.19
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JTPHistorialAKeyPressed(evt);
            }
        });
        this.JSPHistorialA.setViewportView(this.JTPHistorialA);
        GroupLayout JPAccidentesLayout = new GroupLayout(this.JPAccidentes);
        this.JPAccidentes.setLayout(JPAccidentesLayout);
        JPAccidentesLayout.setHorizontalGroup(JPAccidentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAccidentesLayout.createSequentialGroup().addContainerGap().addGroup(JPAccidentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPIDatosAt, -1, -1, 32767).addComponent(this.JSPHistorialA)).addContainerGap()));
        JPAccidentesLayout.setVerticalGroup(JPAccidentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAccidentesLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPIDatosAt, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorialA, -2, 94, -2).addGap(3, 3, 3)));
        this.JTPDatos.addTab("ACCIDENTES TRABAJO", this.JPAccidentes);
        this.JPIDatosEp.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFEEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFFEEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEEmpresa.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.20
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFEEmpresaMouseClicked(evt);
            }
        });
        this.JTFFEFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFEFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEIndemnizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Indemnización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEIndemnizacion.setFont(new Font("Arial", 1, 12));
        this.JSPEIndemnizacion.setViewportView(this.JTPEIndemnizacion);
        this.JSPEReubicacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Reubicación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEReubicacion.setFont(new Font("Arial", 1, 12));
        this.JSPEReubicacion.setViewportView(this.JTPEReubicacion);
        this.JSPEObservacionEP.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEObservacionEP.setFont(new Font("Arial", 1, 12));
        this.JSPEObservacionEP.setViewportView(this.JTPEObservacionEP);
        this.JBTPAdicionarEnfermedad.setFont(new Font("Arial", 1, 14));
        this.JBTPAdicionarEnfermedad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTPAdicionarEnfermedad.setToolTipText("Grabar");
        this.JBTPAdicionarEnfermedad.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.21
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPAdicionarEnfermedadActionPerformed(evt);
            }
        });
        this.JTFFCodigoPat.setFont(new Font("Arial", 1, 12));
        this.JTFFCodigoPat.setBorder(BorderFactory.createTitledBorder((Border) null, "CIE10", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoPat.addFocusListener(new FocusAdapter() { // from class: Historia.JPAAntecentesOcupacionales.22
            public void focusLost(FocusEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFCodigoPatFocusLost(evt);
            }
        });
        this.JTFFCodigoPat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.23
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFCodigoPatKeyPressed(evt);
            }
        });
        this.JTFFNombrePat.setFont(new Font("Arial", 1, 12));
        this.JTFFNombrePat.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNombrePat.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.24
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFNombrePatMouseClicked(evt);
            }
        });
        this.JTFFNombrePat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.25
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFNombrePatKeyPressed(evt);
            }
        });
        this.JTFFEEmpresaArl.setFont(new Font("Arial", 1, 12));
        this.JTFFEEmpresaArl.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEEmpresaArl.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.26
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFEEmpresaArlMouseClicked(evt);
            }
        });
        this.JTFFESEG.setFont(new Font("Arial", 1, 12));
        this.JTFFESEG.setBorder(BorderFactory.createTitledBorder((Border) null, "SEG", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFESEG.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.27
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTFFESEGMouseClicked(evt);
            }
        });
        this.JBTPLimpiarEnfermedad.setFont(new Font("Arial", 1, 14));
        this.JBTPLimpiarEnfermedad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTPLimpiarEnfermedad.setToolTipText("Limpiar Campos");
        this.JBTPLimpiarEnfermedad.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.28
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPLimpiarEnfermedadActionPerformed(evt);
            }
        });
        this.JBTPLimpiarEnfermedad.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.29
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JBTPLimpiarEnfermedadKeyPressed(evt);
            }
        });
        GroupLayout JPIDatosEpLayout = new GroupLayout(this.JPIDatosEp);
        this.JPIDatosEp.setLayout(JPIDatosEpLayout);
        JPIDatosEpLayout.setHorizontalGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createSequentialGroup().addComponent(this.JTFFEEmpresa, -2, 359, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFEFecha, -2, 102, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEIndemnizacion)).addGroup(JPIDatosEpLayout.createSequentialGroup().addComponent(this.JSPEReubicacion, -2, 191, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEObservacionEP, -2, 275, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFEEmpresaArl)).addGroup(JPIDatosEpLayout.createSequentialGroup().addComponent(this.JTFFESEG, -2, 176, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFCodigoPat, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFNombrePat, -2, 319, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTPAdicionarEnfermedad, -2, 84, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPLimpiarEnfermedad, -2, 61, -2))).addContainerGap()));
        JPIDatosEpLayout.setVerticalGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createSequentialGroup().addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFEEmpresa, -2, 50, -2).addComponent(this.JTFFEFecha, -2, 50, -2)).addComponent(this.JSPEIndemnizacion, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFEEmpresaArl, -1, 50, 32767).addComponent(this.JSPEObservacionEP).addComponent(this.JSPEReubicacion)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createSequentialGroup().addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCodigoPat, -2, 50, -2).addComponent(this.JTFFNombrePat, -2, 50, -2).addComponent(this.JTFFESEG)).addGap(0, 2, 32767)).addComponent(this.JBTPAdicionarEnfermedad, -1, -1, 32767).addComponent(this.JBTPLimpiarEnfermedad, -1, -1, 32767)).addContainerGap()));
        this.JSPHistorialEP.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPHistorialEP.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialEP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialEP.setRowHeight(25);
        this.JTPHistorialEP.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialEP.setSelectionForeground(Color.red);
        this.JTPHistorialEP.setSelectionMode(0);
        this.JTPHistorialEP.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionales.30
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionales.this.JTPHistorialEPMouseClicked(evt);
            }
        });
        this.JTPHistorialEP.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.31
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JTPHistorialEPKeyPressed(evt);
            }
        });
        this.JSPHistorialEP.setViewportView(this.JTPHistorialEP);
        GroupLayout JPEnfermedadPLayout = new GroupLayout(this.JPEnfermedadP);
        this.JPEnfermedadP.setLayout(JPEnfermedadPLayout);
        JPEnfermedadPLayout.setHorizontalGroup(JPEnfermedadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEnfermedadPLayout.createSequentialGroup().addContainerGap().addGroup(JPEnfermedadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPHistorialEP, GroupLayout.Alignment.TRAILING).addComponent(this.JPIDatosEp, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        JPEnfermedadPLayout.setVerticalGroup(JPEnfermedadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEnfermedadPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosEp, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorialEP, -1, 203, 32767).addContainerGap()));
        this.JTPDatos.addTab("ENFERMEDAD LABORAL", this.JPEnfermedadP);
        this.JPIDatosElementosPP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBUElementosPP.setFont(new Font("Arial", 1, 12));
        this.JCBUElementosPP.setBorder(BorderFactory.createTitledBorder((Border) null, "Elemento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPUObservacionesElementoP.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPUObservacionesElementoP.setFont(new Font("Arial", 1, 12));
        this.JSPUObservacionesElementoP.setViewportView(this.JTPUObservacionesElementoP);
        this.JBTUAdicionarElementoP.setFont(new Font("Arial", 1, 14));
        this.JBTUAdicionarElementoP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTUAdicionarElementoP.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionales.32
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionales.this.JBTUAdicionarElementoPActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosElementosPPLayout = new GroupLayout(this.JPIDatosElementosPP);
        this.JPIDatosElementosPP.setLayout(JPIDatosElementosPPLayout);
        JPIDatosElementosPPLayout.setHorizontalGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBUElementosPP, -2, 386, -2).addGap(18, 18, 18).addComponent(this.JSPUObservacionesElementoP, -1, 292, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTUAdicionarElementoP).addContainerGap()));
        JPIDatosElementosPPLayout.setVerticalGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTUAdicionarElementoP, -2, 43, -2).addComponent(this.JSPUObservacionesElementoP, -2, -1, -2).addComponent(this.JCBUElementosPP, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPHistorialU.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPHistorialU.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialU.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialU.setRowHeight(25);
        this.JTPHistorialU.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialU.setSelectionForeground(Color.red);
        this.JTPHistorialU.setSelectionMode(0);
        this.JTPHistorialU.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionales.33
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionales.this.JTPHistorialUKeyPressed(evt);
            }
        });
        this.JSPHistorialU.setViewportView(this.JTPHistorialU);
        GroupLayout JPElementosPPLayout = new GroupLayout(this.JPElementosPP);
        this.JPElementosPP.setLayout(JPElementosPPLayout);
        JPElementosPPLayout.setHorizontalGroup(JPElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPElementosPPLayout.createSequentialGroup().addContainerGap().addGroup(JPElementosPPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPHistorialU, GroupLayout.Alignment.LEADING, -1, 791, 32767).addComponent(this.JPIDatosElementosPP, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
        JPElementosPPLayout.setVerticalGroup(JPElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElementosPPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosElementosPP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorialU, -1, 324, 32767).addContainerGap()));
        this.JTPDatos.addTab("USO ELEMENTOS PP", this.JPElementosPP);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, -1, -2).addGap(8, 8, 8)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPPObservacionesPeligrosKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.JTPPObservacionesPeligros.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPAdicionarPeligroKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mGrabarBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPEmpresaMouseClicked(MouseEvent evt) {
        if (this.xidpeligroexpuesto.equals("0")) {
            try {
                this.xjifbuscardatos = new JIFBuscarDatos(this.JTFFPEmpresa, "empresa_peligro");
                this.xjifbuscardatos.setVisible(true);
                Principal.PanelPpal.add(this.xjifbuscardatos, JLayeredPane.DEFAULT_LAYER);
                this.xjifbuscardatos.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPEmpresaKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFPEmpresa.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPAdicionarPeligroActionPerformed(ActionEvent evt) {
        if (this.xidpeligroexpuesto.equals("0")) {
            if (!this.JTFFPEmpresa.getText().isEmpty()) {
                if (!this.JTFFPCargo.getText().isEmpty()) {
                    if (this.xmt.mVerificarDatosTablaTrue(this.JTPPExpuestos, 2)) {
                        int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            this.xsql = "insert into h_so_peligros_expuesto(Id_Usuario, Id_Atencion, Empresa, Ano, Mes, ElementosPP,Cargo, Observacion, UsuarioS) values ('" + this.xidusuario + "','" + this.xidatencion + "','" + this.JTFFPEmpresa.getText().toUpperCase() + "','" + this.JSPAno.getValue() + "','" + this.JSPMes.getValue() + "','" + this.xelementopp + "','" + this.JTFFPCargo.getText().toUpperCase() + "','" + this.JTPPObservacionesPeligros.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xidpeligroexpuesto = this.xct.ejecutarSQLId(this.xsql);
                            this.xct.cerrarConexionBd();
                            for (int y = 0; y < this.JTPPExpuestos.getRowCount(); y++) {
                                if (Boolean.valueOf(this.xmodelop.getValueAt(y, 2).toString()).booleanValue()) {
                                    this.xsql = "insert into h_so_peligros_expuesto_detalle(Id_So_Peligros, Id_Peligro, Observacion) values ('" + this.xidpeligroexpuesto + "','" + this.xmodelop.getValueAt(y, 0) + "','" + this.xmodelop.getValueAt(y, 3) + "')";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            mLimpiarPeligros();
                            mCargarHistorialPeligro();
                            return;
                        }
                        return;
                    }
                    JOptionPane.showInternalMessageDialog(this, "no existe peligro seleccionado", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "El cargo no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFPCargo.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La empresa no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFPEmpresa.requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFPCargoMouseClicked(MouseEvent evt) {
        if (this.xidpeligroexpuesto.equals("0")) {
            try {
                this.xjifbuscardatos = new JIFBuscarDatos(this.JTFFPCargo, "cargo_peligro");
                this.xjifbuscardatos.setVisible(true);
                Principal.PanelPpal.add(this.xjifbuscardatos, JLayeredPane.DEFAULT_LAYER);
                this.xjifbuscardatos.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTUAdicionarElementoPActionPerformed(ActionEvent evt) {
        if (this.JCBUElementosPP.getSelectedIndex() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.xsql = "insert ignore into h_so_uso_elementos_pp(Id_Usuario , Id_Atencion , Id_ElementoPp ,Observacion , UsuarioS) values('" + this.xidusuario + "','" + this.xidatencion + "','" + this.xidelementospp[this.JCBUElementosPP.getSelectedIndex()] + "','" + this.JTPUObservacionesElementoP.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xct.ejecutarSQL(this.xsql);
                this.xct.cerrarConexionBd();
                this.JCBUElementosPP.setSelectedIndex(-1);
                this.JTPUObservacionesElementoP.setText("");
                mBuscarUElementosPPDatosBd();
                this.JCBUElementosPP.requestFocus();
                return;
            }
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "Debe seleccionar un elemento de PP", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JCBUElementosPP.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFAEmpresaMouseClicked(MouseEvent evt) {
        if (this.xidaccidentetrabajo.equals("0")) {
            try {
                this.xjifbuscardatos = new JIFBuscarDatos(this.JTFFAEmpresa, "empresa_accidentet");
                this.xjifbuscardatos.setVisible(true);
                Principal.PanelPpal.add(this.xjifbuscardatos, JLayeredPane.DEFAULT_LAYER);
                this.xjifbuscardatos.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPAdicionarAtActionPerformed(ActionEvent evt) {
        if (!this.JTFFAEmpresa.getText().isEmpty()) {
            if (!this.JTFFAFecha.getText().isEmpty()) {
                if (!this.JTPACausa.getText().isEmpty()) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        if (this.xidaccidentetrabajo.equals("0")) {
                            this.xsql = "insert into h_so_accidentes_trabajo(Id_Atencion, Id_Usuario,  Empresa,  Fecha_AT, Causa , DIncapacidad, Secuelas, Observacion,EmpresaArl, UsuarioS) values ('" + this.xidatencion + "','" + this.xidusuario + "','" + this.JTFFAEmpresa.getText().toUpperCase() + "','" + this.JTFFAFecha.getText() + "','" + this.JTPACausa.getText().toUpperCase() + "','" + this.JSPADiasI.getValue() + "','" + this.JTPASecuelas.getText().toUpperCase() + "','" + this.JTPAObservacionAT.getText().toUpperCase() + "','" + this.JTFFEEmpresaArlAcciente.getText().toUpperCase() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xidaccidentetrabajo = this.xct.ejecutarSQLId(this.xsql);
                            this.xct.cerrarConexionBd();
                            for (int y = 0; y < this.JTTipoLesion.getRowCount(); y++) {
                                if (Boolean.valueOf(this.xmodelolesion.getValueAt(y, 2).toString()).booleanValue()) {
                                    this.xsql = "insert into h_so_accidente_lesion(`Id_AccidenteTra`  , `Id_TipoLesion` , `Observacion` ,  `UsuarioS`) values ('" + this.xidaccidentetrabajo + "','" + this.xmodelolesion.getValueAt(y, 0) + "','" + this.xmodelolesion.getValueAt(y, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            for (int y2 = 0; y2 < this.JTParteAfectada.getRowCount(); y2++) {
                                if (Boolean.valueOf(this.xmodelopafectada.getValueAt(y2, 2).toString()).booleanValue()) {
                                    this.xsql = "insert into h_so_accidente_pafectada(`Id_AccidenteTra`  , `Id_PAfectada`, `Observacion` ,  `UsuarioS`) values ('" + this.xidaccidentetrabajo + "','" + this.xmodelopafectada.getValueAt(y2, 0) + "','" + this.xmodelopafectada.getValueAt(y2, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        } else {
                            this.xsql = "UPDATE\n  `baseserver`.`h_so_accidentes_trabajo`\nSET\n  `Empresa` = '" + this.JTFFAEmpresa.getText().toUpperCase() + "',\n  `Fecha_AT` = '" + this.JTFFAFecha.getText() + "',\n  `Causa` = '" + this.JTPACausa.getText().toUpperCase() + "',\n  `DIncapacidad` = '" + this.JSPADiasI.getValue() + "',\n  `Secuelas` = '" + this.JTPASecuelas.getText().toUpperCase() + "',\n  `Observacion` = '" + this.JTPAObservacionAT.getText().toUpperCase() + "',\n  `EmpresaArl` = '" + this.JTFFEEmpresaArlAcciente.getText().toUpperCase() + "',\n  `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE `Id` = '" + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString() + "'";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                            for (int y3 = 0; y3 < this.JTTipoLesion.getRowCount(); y3++) {
                                if (this.xmodelolesion.getValueAt(y3, 4).toString().equals("0") || this.xmodelolesion.getValueAt(y3, 4).toString().equals("1")) {
                                    int estado = Boolean.valueOf(this.xmodelolesion.getValueAt(y3, 2).toString()).booleanValue() ? 1 : 0;
                                    this.xsql = "UPDATE\n  `baseserver`.`h_so_accidente_lesion`\nSET\n  `Observacion` = '" + this.xmodelolesion.getValueAt(y3, 3) + "',\n  `Estado` = '" + estado + "',\n  `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE `Id_AccidenteTra` = " + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString() + "\n  AND `Id_TipoLesion` = " + this.xmodelolesion.getValueAt(y3, 0) + "";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                } else if (Boolean.valueOf(this.xmodelolesion.getValueAt(y3, 2).toString()).booleanValue() && this.xmodelolesion.getValueAt(y3, 4).toString().equals("-1")) {
                                    this.xsql = "insert into h_so_accidente_lesion(`Id_AccidenteTra`  , `Id_TipoLesion` , `Observacion` ,  `UsuarioS`) values ('" + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString() + "','" + this.xmodelolesion.getValueAt(y3, 0) + "','" + this.xmodelolesion.getValueAt(y3, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                            for (int y4 = 0; y4 < this.JTParteAfectada.getRowCount(); y4++) {
                                if (this.xmodelopafectada.getValueAt(y4, 4).toString().equals("0") || this.xmodelopafectada.getValueAt(y4, 4).toString().equals("1")) {
                                    int estado2 = Boolean.valueOf(this.xmodelopafectada.getValueAt(y4, 2).toString()).booleanValue() ? 1 : 0;
                                    this.xsql = "UPDATE\n  `baseserver`.`h_so_accidente_pafectada`\nSET\n  `Observacion` = '" + this.xmodelopafectada.getValueAt(y4, 3) + "',\n  `Estado` = '" + estado2 + "',\n  `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE `Id_AccidenteTra` = " + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString() + "\n  AND `Id_PAfectada` = " + this.xmodelopafectada.getValueAt(y4, 0) + "";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                } else if (Boolean.valueOf(this.xmodelopafectada.getValueAt(y4, 2).toString()).booleanValue() && this.xmodelopafectada.getValueAt(y4, 4).toString().equals("-1")) {
                                    this.xsql = "insert into h_so_accidente_pafectada(`Id_AccidenteTra`  , `Id_PAfectada`, `Observacion` ,  `UsuarioS`) values ('" + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString() + "','" + this.xmodelopafectada.getValueAt(y4, 0) + "','" + this.xmodelopafectada.getValueAt(y4, 3) + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                                    this.xct.ejecutarSQL(this.xsql);
                                    this.xct.cerrarConexionBd();
                                }
                            }
                        }
                        mLimpiarAccidentes();
                        mCargarHistorialAccidenteTrabajo();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "La causa no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTPACausa.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La fecha no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFAFecha.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La empresa no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFAEmpresa.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFEEmpresaMouseClicked(MouseEvent evt) {
        if (this.xidenfermedadprofesional.equals("0")) {
            try {
                this.xjifbuscardatos = new JIFBuscarDatos(this.JTFFEEmpresa, "empresa_enfermedadp");
                this.xjifbuscardatos.setVisible(true);
                Principal.PanelPpal.add(this.xjifbuscardatos, JLayeredPane.DEFAULT_LAYER);
                this.xjifbuscardatos.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPAdicionarEnfermedadActionPerformed(ActionEvent evt) {
        if (!this.JTFFEEmpresa.getText().isEmpty()) {
            if (!this.JTFFEFecha.getText().isEmpty()) {
                if (!this.JTFFCodigoPat.getText().isEmpty()) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        if (this.xidenfermedadprofesional.equals("0")) {
                            this.xsql = "insert into h_so_enfermedad_profesional( Id_Atencion, Id_Usuario, Empresa, FechaEP, Id_Patologia, Idemnizacion, Reubicacion, Observacion,EmpresaArl,SEG, UsuarioS ) values ('" + this.xidatencion + "','" + this.xidusuario + "','" + this.JTFFEEmpresa.getText().toUpperCase() + "','" + this.JTFFEFecha.getText() + "','" + this.JTFFCodigoPat.getText() + "','" + this.JTPEIndemnizacion.getText().toUpperCase() + "','" + this.JTPEReubicacion.getText().toUpperCase() + "','" + this.JTPEObservacionEP.getText().toUpperCase() + "','" + this.JTFFEEmpresaArl.getText().toUpperCase() + "','" + this.JTFFESEG.getText().toUpperCase() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                            this.xidenfermedadprofesional = this.xct.ejecutarSQLId(this.xsql);
                            this.xct.cerrarConexionBd();
                        } else {
                            this.xsql = "UPDATE\n  `baseserver`.`h_so_enfermedad_profesional`\nSET\n  `Empresa` = '" + this.JTFFEEmpresa.getText().toUpperCase() + "',\n  `FechaEP` = '" + this.JTFFEFecha.getText() + "',\n  `Id_Patologia` = '" + this.JTFFCodigoPat.getText() + "',\n  `Idemnizacion` = '" + this.JTPEIndemnizacion.getText().toUpperCase() + "',\n  `Reubicacion` = '" + this.JTPEReubicacion.getText().toUpperCase() + "',\n  `Observacion` = '" + this.JTPEObservacionEP.getText().toUpperCase() + "',\n  `EmpresaArl` = '" + this.JTFFEEmpresaArl.getText().toUpperCase() + "',\n  `SEG` = '" + this.JTFFESEG.getText().toUpperCase() + "',\n  `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'\nWHERE `Id` = " + this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 0).toString() + "";
                            this.xct.ejecutarSQL(this.xsql);
                            this.xct.cerrarConexionBd();
                        }
                        mLimpiarEnfermedades();
                        mCargarHistorialEnfemedadProfesional();
                        return;
                    }
                    return;
                }
                JOptionPane.showInternalMessageDialog(this, "Código de patologia no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFCodigoPat.requestFocus();
                return;
            }
            JOptionPane.showInternalMessageDialog(this, "La fecha no puede ser nulo", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFEFecha.requestFocus();
            return;
        }
        JOptionPane.showInternalMessageDialog(this, "La empresa no puede ser nula", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
        this.JTFFEEmpresa.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoPatFocusLost(FocusEvent evt) {
        mBuscarPatologia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFCodigoPatKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            mBuscarPatologia();
            this.JTFFCodigoPat.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNombrePatMouseClicked(MouseEvent evt) {
        JIFBuscarPatologia pac = new JIFBuscarPatologia(null, true, this.JTFFCodigoPat, this.JTFFNombrePat, "antecedentesocupacionales", 0);
        pac.setVisible(true);
        pac.setLocationRelativeTo(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFNombrePatKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.JTFFNombrePat.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBSiActionPerformed(ActionEvent evt) {
        this.xelementopp = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOActionPerformed(ActionEvent evt) {
        this.xelementopp = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialPMouseClicked(MouseEvent evt) {
        if (this.JTPHistorialP.getRowCount() > -1 && evt.getClickCount() == 2) {
            mBuscarPeligrosDatosBd();
            this.JBTPAdicionarPeligro.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFEEmpresaArlMouseClicked(MouseEvent evt) {
        if (this.xidenfermedadprofesional.equals("0")) {
            try {
                this.xjifbuscardatos = new JIFBuscarDatos(this.JTFFEEmpresaArl, "empresa_arl");
                this.xjifbuscardatos.setVisible(true);
                Principal.PanelPpal.add(this.xjifbuscardatos, JLayeredPane.DEFAULT_LAYER);
                this.xjifbuscardatos.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialEPMouseClicked(MouseEvent evt) {
        if (this.JTPHistorialEP.getRowCount() > -1 && evt.getClickCount() == 2) {
            mBuscarEnfermedadProfesionalDatosBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFESEGMouseClicked(MouseEvent evt) {
        if (this.xidenfermedadprofesional.equals("0")) {
            try {
                this.xjifbuscardatos = new JIFBuscarDatos(this.JTFFESEG, "datos_seg");
                this.xjifbuscardatos.setVisible(true);
                Principal.PanelPpal.add(this.xjifbuscardatos, JLayeredPane.DEFAULT_LAYER);
                this.xjifbuscardatos.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialAMouseClicked(MouseEvent evt) {
        if (this.JTPHistorialA.getRowCount() > -1 && evt.getClickCount() == 2) {
            this.xbuscardatos = 1;
            mBuscarDatosAccidenteBd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPLimpiarPeligroActionPerformed(ActionEvent evt) {
        mLimpiarPeligros();
    }

    private void mLimpiarPeligros() {
        this.xidpeligroexpuesto = "0";
        this.JTFFPEmpresa.setText("");
        this.JSPAno.setValue(0);
        this.JSPMes.setValue(0);
        this.JTFFPCargo.setText("");
        this.JTPPObservacionesPeligros.setText("");
        mBuscarPeligros();
        this.JBTPAdicionarPeligro.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPLimpiarPeligroKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPLimpiarAccidentesActionPerformed(ActionEvent evt) {
        mLimpiarAccidentes();
    }

    private void mLimpiarAccidentes() {
        this.xidaccidentetrabajo = "0";
        this.xbuscardatos = 0;
        this.JTFFAEmpresa.setText("");
        this.JTFFAFecha.setText("");
        this.JTPACausa.setText("");
        this.JSPADiasI.setValue(0);
        this.JTPASecuelas.setText("");
        this.JTPAObservacionAT.setText("");
        this.JTFFEEmpresaArlAcciente.setText("");
        mBuscarLesion();
        mBuscarPAfectada();
        this.JBTPAdicionarAt.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPLimpiarAccidentesKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPLimpiarEnfermedadActionPerformed(ActionEvent evt) {
        mLimpiarEnfermedades();
    }

    private void mLimpiarEnfermedades() {
        this.xguardarel = false;
        this.xidenfermedadprofesional = "0";
        this.JTFFEEmpresa.setText("");
        this.JTFFEFecha.setText("");
        this.JTPEIndemnizacion.setText("");
        this.JTPEReubicacion.setText("");
        this.JTPEObservacionEP.setText("");
        this.JTFFEEmpresaArl.setText("");
        this.JTFFESEG.setText("");
        this.JTFFCodigoPat.setText("");
        this.JTFFNombrePat.setText("");
        this.JBTPAdicionarEnfermedad.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPLimpiarEnfermedadKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTFFEEmpresaArlAccienteMouseClicked(MouseEvent evt) {
        if (this.xidaccidentetrabajo.equals("0")) {
            try {
                this.xjifbuscardatos = new JIFBuscarDatos(this.JTFFEEmpresaArlAcciente, "arl_accidentet");
                this.xjifbuscardatos.setVisible(true);
                Principal.PanelPpal.add(this.xjifbuscardatos, JLayeredPane.DEFAULT_LAYER);
                this.xjifbuscardatos.setSelected(true);
            } catch (PropertyVetoException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTPHistorialP.getRowCount() != 0 && this.JTPHistorialP.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "update h_so_peligros_expuesto set Estado=0 where Id='" + this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 0).toString() + "'";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                String sql2 = "update h_so_peligros_expuesto_detalle set Estado=0 where Id_So_Peligros='" + this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 0).toString() + "' ";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
                mLimpiarPeligros();
                mCargarHistorialPeligro();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialAKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTPHistorialA.getRowCount() != 0 && this.JTPHistorialA.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "update h_so_accidentes_trabajo set Estado=0 where Id='" + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString() + "' ";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                String sql2 = "update h_so_accidente_lesion set Estado=0 where Id_AccidenteTra='" + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString() + "' ";
                this.xct.ejecutarSQL(sql2);
                this.xct.cerrarConexionBd();
                String sql3 = "update h_so_accidente_pafectada set Estado=0 where Id_AccidenteTra='" + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString() + "' ";
                this.xct.ejecutarSQL(sql3);
                this.xct.cerrarConexionBd();
                mLimpiarAccidentes();
                mCargarHistorialAccidenteTrabajo();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialEPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTPHistorialEP.getRowCount() != 0 && this.JTPHistorialEP.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "update h_so_enfermedad_profesional set Estado=0 where Id='" + this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 0).toString() + "' ";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                mLimpiarEnfermedades();
                mCargarHistorialEnfemedadProfesional();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialUKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTPHistorialU.getRowCount() != 0 && this.JTPHistorialU.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                String sql = "update h_so_uso_elementos_pp set Estado=0 where Id='" + this.xmodelou.getValueAt(this.JTPHistorialU.getSelectedRow(), 0).toString() + "' ";
                this.xct.ejecutarSQL(sql);
                this.xct.cerrarConexionBd();
                this.JCBUElementosPP.setSelectedIndex(-1);
                this.JTPUObservacionesElementoP.setText("");
                mBuscarUElementosPPDatosBd();
                this.JCBUElementosPP.requestFocus();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaPeligros() {
        this.xmodelop = new DefaultTableModel(new Object[0], new String[]{"Id", "Peligro", "Expuesto?", "Observación"}) { // from class: Historia.JPAAntecentesOcupacionales.34
            Class[] types = {Integer.class, String.class, Boolean.class, String.class};
            boolean[] canEdit = {false, false, true, true};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPPExpuestos.setModel(this.xmodelop);
        this.JTPPExpuestos.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPPExpuestos.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPPExpuestos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPPExpuestos.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTPPExpuestos.getColumnModel().getColumn(2).setPreferredWidth(50);
        this.JTPPExpuestos.getColumnModel().getColumn(3).setPreferredWidth(80);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaUelementosPP() {
        this.xmodelou = new DefaultTableModel(new Object[0], new String[]{"Id", "Elemento PP", "Observación"}) { // from class: Historia.JPAAntecentesOcupacionales.35
            Class[] types = {Integer.class, String.class, String.class};
            boolean[] canEdit = {false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPHistorialU.setModel(this.xmodelou);
        this.JTPHistorialU.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPHistorialU.getColumnModel().getColumn(1).setPreferredWidth(100);
        this.JTPHistorialU.getColumnModel().getColumn(2).setPreferredWidth(150);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaAccidenteTrabajo() {
        this.xmodeloa = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Fecha", "Causa", "Días Incap", "Secuelas", "Observación", "ARL"}) { // from class: Historia.JPAAntecentesOcupacionales.36
            Class[] types = {Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPHistorialA.setModel(this.xmodeloa);
        this.JTPHistorialA.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPHistorialA.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPHistorialA.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPHistorialA.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTPHistorialA.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTPHistorialA.getColumnModel().getColumn(3).setPreferredWidth(30);
        this.JTPHistorialA.getColumnModel().getColumn(4).setPreferredWidth(10);
        this.JTPHistorialA.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTPHistorialA.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTPHistorialA.getColumnModel().getColumn(7).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaEnfermedadP() {
        this.xmodeloe = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Fecha", "Cie10", "Patología", "Idemnización", "Reubicación", "ARL", "SEG", "Observación"}) { // from class: Historia.JPAAntecentesOcupacionales.37
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPHistorialEP.setModel(this.xmodeloe);
        this.JTPHistorialEP.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPHistorialEP.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPHistorialEP.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPHistorialEP.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTPHistorialEP.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTPHistorialEP.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTPHistorialEP.getColumnModel().getColumn(4).setPreferredWidth(80);
        this.JTPHistorialEP.getColumnModel().getColumn(5).setPreferredWidth(30);
        this.JTPHistorialEP.getColumnModel().getColumn(6).setPreferredWidth(30);
        this.JTPHistorialEP.getColumnModel().getColumn(7).setPreferredWidth(30);
        this.JTPHistorialEP.getColumnModel().getColumn(8).setPreferredWidth(20);
        this.JTPHistorialEP.getColumnModel().getColumn(9).setPreferredWidth(30);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorialPeligro() {
        this.xmodelohp = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Tiempo", "Cargo", "ElementoPP", "Observación", "Atención"}) { // from class: Historia.JPAAntecentesOcupacionales.38
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTPHistorialP.setModel(this.xmodelohp);
        this.JTPHistorialP.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(1).setPreferredWidth(80);
        this.JTPHistorialP.getColumnModel().getColumn(2).setPreferredWidth(10);
        this.JTPHistorialP.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTPHistorialP.getColumnModel().getColumn(3).setPreferredWidth(50);
        this.JTPHistorialP.getColumnModel().getColumn(4).setPreferredWidth(15);
        this.JTPHistorialP.getColumnModel().getColumn(5).setPreferredWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(5).setMinWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(5).setMaxWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(6).setPreferredWidth(15);
    }

    private void mBuscarPeligros() {
        try {
            mCrearTablaPeligros();
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs("SELECT  `Id` , `Nbre` FROM `g_so_peligros` WHERE (`Estado` =1) ORDER BY `Nbre` ASC");
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodelop.addRow(this.xdato);
                    this.xmodelop.setValueAt(rs1.getString(1), x, 0);
                    this.xmodelop.setValueAt(rs1.getString(2), x, 1);
                    this.xmodelop.setValueAt(false, x, 2);
                    this.xmodelop.setValueAt("", x, 3);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarPeligrosDatosBd() {
        try {
            String sql = "SELECT  `h_so_peligros_expuesto_detalle`.`Id_Peligro`,`h_so_peligros_expuesto`.`Empresa`  , `h_so_peligros_expuesto`.`Ano`, `h_so_peligros_expuesto`.`Mes`, `h_so_peligros_expuesto`.`Cargo`  , `h_so_peligros_expuesto`.`Observacion` ,`h_so_peligros_expuesto`.`ElementosPP`, `h_so_peligros_expuesto_detalle`.`Id_Peligro`,`g_so_peligros`.`Nbre`, `h_so_peligros_expuesto_detalle`.`Observacion`  FROM `h_so_peligros_expuesto_detalle` INNER JOIN `baseserver`.`h_so_peligros_expuesto` ON (`h_so_peligros_expuesto_detalle`.`Id_So_Peligros` = `h_so_peligros_expuesto`.`Id`) INNER JOIN `baseserver`.`g_so_peligros`  ON (`h_so_peligros_expuesto_detalle`.`Id_Peligro` = `g_so_peligros`.`Id`) WHERE (h_so_peligros_expuesto.Id='" + this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 0) + "' AND h_so_peligros_expuesto.Estado=1)";
            mCrearTablaPeligros();
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.first();
                this.xidpeligroexpuesto = rs.getString(1);
                this.JTFFPEmpresa.setText(rs.getString(2));
                this.JSPAno.setValue(Long.valueOf(rs.getLong(3)));
                this.JSPMes.setValue(Long.valueOf(rs.getLong(4)));
                this.JTFFPCargo.setText(rs.getString(5));
                this.JTPPObservacionesPeligros.setText(rs.getString(6));
                if (rs.getString(7).equals("0")) {
                    this.JRBNO.setSelected(true);
                } else {
                    this.JRBSi.setSelected(true);
                }
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelop.addRow(this.xdato);
                    this.xmodelop.setValueAt(rs.getString(8), x, 0);
                    this.xmodelop.setValueAt(rs.getString(9), x, 1);
                    this.xmodelop.setValueAt(true, x, 2);
                    this.xmodelop.setValueAt(rs.getString(10), x, 3);
                    x++;
                }
            } else {
                this.xidpeligroexpuesto = "0";
                this.JTFFPEmpresa.setText("");
                this.JSPAno.setValue(0);
                this.JSPMes.setValue(0);
                this.JTFFPCargo.setText("");
                this.JTPPObservacionesPeligros.setText("");
                this.JRBNO.setSelected(true);
                ConsultasMySQL xct1 = new ConsultasMySQL();
                ResultSet rs1 = xct1.traerRs("SELECT  `Id` , `Nbre` FROM `g_so_peligros` WHERE (`Estado` =1) ORDER BY `Nbre` ASC");
                if (rs1.next()) {
                    rs1.beforeFirst();
                    int x2 = 0;
                    while (rs1.next()) {
                        this.xmodelop.addRow(this.xdato);
                        this.xmodelop.setValueAt(rs1.getString(1), x2, 0);
                        this.xmodelop.setValueAt(rs1.getString(2), x2, 1);
                        this.xmodelop.setValueAt(false, x2, 2);
                        this.xmodelop.setValueAt("", x2, 3);
                        x2++;
                    }
                }
                rs1.close();
                xct1.cerrarConexionBd();
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesFamiliares.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarEnfermedadProfesionalDatosBd() {
        try {
            String sql = "SELECT `h_so_enfermedad_profesional`.`Id`, `h_so_enfermedad_profesional`.`Empresa`, `h_so_enfermedad_profesional`.`FechaEP`, `h_so_enfermedad_profesional`.`Id_Patologia` , `g_patologia`.`Nbre` , `h_so_enfermedad_profesional`.`Idemnizacion` , `h_so_enfermedad_profesional`.`Reubicacion` , `h_so_enfermedad_profesional`.`EmpresaArl`,`h_so_enfermedad_profesional`.`SEG`,`h_so_enfermedad_profesional`.`Observacion` FROM `h_so_enfermedad_profesional` INNER JOIN  `g_patologia`  ON (`h_so_enfermedad_profesional`.`Id_Patologia` = `g_patologia`.`Id`) WHERE (`h_so_enfermedad_profesional`.`Id`='" + this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 0) + "') ";
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.first();
                this.xidenfermedadprofesional = rs.getString(1);
                this.JTFFEEmpresa.setText(rs.getString(2));
                this.JTFFEFecha.setText(rs.getString(3));
                this.JTFFCodigoPat.setText(rs.getString(4));
                this.JTFFNombrePat.setText(rs.getString(5));
                this.JTPEIndemnizacion.setText(rs.getString(6));
                this.JTPEReubicacion.setText(rs.getString(7));
                this.JTFFEEmpresaArl.setText(rs.getString(8));
                this.JTFFESEG.setText(rs.getString(9));
                this.JTPEObservacionEP.setText(rs.getString(10));
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesFamiliares.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarUElementosPPDatosBd() {
        try {
            String sql = "SELECT  `h_so_uso_elementos_pp`.`Id_ElementoPp` , `g_so_elementospp`.`Nbre` , `h_so_uso_elementos_pp`.`Observacion` FROM `h_so_uso_elementos_pp` INNER JOIN  `g_so_elementospp`  ON (`h_so_uso_elementos_pp`.`Id_ElementoPp` = `g_so_elementospp`.`Id`) WHERE (`h_so_uso_elementos_pp`.`Id_Usuario` ='" + this.xidusuario + "' AND `h_so_uso_elementos_pp`.`Estado`=1) ORDER BY `g_so_elementospp`.`Nbre` ASC ";
            mCrearTablaUelementosPP();
            ResultSet rs = this.xct.traerRs(sql);
            if (rs.next()) {
                rs.beforeFirst();
                int x = 0;
                while (rs.next()) {
                    this.xmodelou.addRow(this.xdato);
                    this.xmodelou.setValueAt(rs.getString(1), x, 0);
                    this.xmodelou.setValueAt(rs.getString(2), x, 1);
                    this.xmodelou.setValueAt(rs.getString(3), x, 2);
                    x++;
                }
            }
            rs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesFamiliares.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarHistorialAccidenteTrabajo() {
        try {
            mCrearTablaAccidenteTrabajo();
            this.xsql = "SELECT  `Id` , `Empresa` , `Fecha_AT` , `Causa` , `DIncapacidad` , `Secuelas`, `Observacion` ,EmpresaArl FROM `h_so_accidentes_trabajo` WHERE (`Id_Usuario` ='" + this.xidusuario + "' AND Estado=1) ORDER BY `Fecha_AT` DESC ";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(this.xsql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodeloa.addRow(this.xdato);
                    this.xmodeloa.setValueAt(Long.valueOf(rs1.getLong(1)), x, 0);
                    this.xmodeloa.setValueAt(rs1.getString(2), x, 1);
                    this.xmodeloa.setValueAt(rs1.getString(3), x, 2);
                    this.xmodeloa.setValueAt(rs1.getString(4), x, 3);
                    this.xmodeloa.setValueAt(Long.valueOf(rs1.getLong(5)), x, 4);
                    this.xmodeloa.setValueAt(rs1.getString(6), x, 5);
                    this.xmodeloa.setValueAt(rs1.getString(7), x, 6);
                    this.xmodeloa.setValueAt(rs1.getString(8), x, 7);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarHistorialEnfemedadProfesional() {
        try {
            mCrearTablaEnfermedadP();
            this.xsql = "SELECT `h_so_enfermedad_profesional`.`Id`, `h_so_enfermedad_profesional`.`Empresa`, `h_so_enfermedad_profesional`.`FechaEP`, `h_so_enfermedad_profesional`.`Id_Patologia` , `g_patologia`.`Nbre` , `h_so_enfermedad_profesional`.`Idemnizacion` , `h_so_enfermedad_profesional`.`Reubicacion` , `h_so_enfermedad_profesional`.`EmpresaArl`,`h_so_enfermedad_profesional`.`SEG`,`h_so_enfermedad_profesional`.`Observacion` FROM `h_so_enfermedad_profesional` INNER JOIN  `g_patologia`  ON (`h_so_enfermedad_profesional`.`Id_Patologia` = `g_patologia`.`Id`) WHERE (`h_so_enfermedad_profesional`.`Id_Usuario` ='" + this.xidusuario + "' AND `h_so_enfermedad_profesional`.`Estado`=1) ";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(this.xsql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodeloe.addRow(this.xdato);
                    this.xmodeloe.setValueAt(Long.valueOf(rs1.getLong(1)), x, 0);
                    this.xmodeloe.setValueAt(rs1.getString(2), x, 1);
                    this.xmodeloe.setValueAt(rs1.getString(3), x, 2);
                    this.xmodeloe.setValueAt(rs1.getString(4), x, 3);
                    this.xmodeloe.setValueAt(rs1.getString(5), x, 4);
                    this.xmodeloe.setValueAt(rs1.getString(6), x, 5);
                    this.xmodeloe.setValueAt(rs1.getString(7), x, 6);
                    this.xmodeloe.setValueAt(rs1.getString(8), x, 7);
                    this.xmodeloe.setValueAt(rs1.getString(9), x, 8);
                    this.xmodeloe.setValueAt(rs1.getString(10), x, 9);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mCargarHistorialPeligro() {
        try {
            mCrearTablaHistorialPeligro();
            this.xsql = "SELECT `h_so_peligros_expuesto`.`Id` , `h_so_peligros_expuesto`.`Empresa` , CONCAT(`h_so_peligros_expuesto`.`Ano`,' Año(s) ' , `h_so_peligros_expuesto`.`Mes`,' Mes(es)') AS tiempo , `h_so_peligros_expuesto`.`Cargo` ,IF(`h_so_peligros_expuesto`.`ElementosPP`=1,'Sí','No') , `h_so_peligros_expuesto`.`Observacion`,`h_so_peligros_expuesto`.`Id_Atencion`  FROM `h_so_peligros_expuesto`   WHERE (`h_so_peligros_expuesto`.`Id_Usuario` ='" + this.xidusuario + "' AND `h_so_peligros_expuesto`.`Estado`=1) ORDER BY `h_so_peligros_expuesto`.`Empresa` ASC";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(this.xsql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodelohp.addRow(this.xdato);
                    this.xmodelohp.setValueAt(rs1.getString(1), x, 0);
                    this.xmodelohp.setValueAt(rs1.getString(2), x, 1);
                    this.xmodelohp.setValueAt(rs1.getString(3), x, 2);
                    this.xmodelohp.setValueAt(rs1.getString(4), x, 3);
                    this.xmodelohp.setValueAt(rs1.getString(5), x, 4);
                    this.xmodelohp.setValueAt(rs1.getString(6), x, 5);
                    this.xmodelohp.setValueAt(rs1.getString(7), x, 6);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mGrabarBd() {
    }

    public void mNuevo() {
        if (this.xmod == 0) {
            this.xidusuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido().longValue();
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        } else {
            if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                this.xidusuario = Long.valueOf(this.xjifcho.xjppersona.getIdPersona()).longValue();
            }
            this.xidatencion = "0";
        }
        this.JCBUElementosPP.removeAllItems();
        this.xidelementospp = this.xct.llenarCombo("SELECT Id, Nbre FROM g_so_elementospp WHERE ( Estado  =1) ORDER BY  Nbre  ASC", this.xidelementospp, this.JCBUElementosPP);
        this.JCBUElementosPP.setSelectedIndex(-1);
        this.xct.cerrarConexionBd();
        this.xidaccidentetrabajo = "0";
        this.JTFFAEmpresa.setText("");
        this.JTFFAFecha.setText("");
        this.JTPACausa.setText("");
        this.JTPASecuelas.setText("");
        this.JTPAObservacionAT.setText("");
        this.JSPADiasI.setValue(new Integer(0));
        this.xidenfermedadprofesional = "0";
        this.JTFFEEmpresa.setText("");
        this.JTFFEFecha.setText("");
        this.JTPEIndemnizacion.setText("");
        this.JTPEReubicacion.setText("");
        this.JTPEObservacionEP.setText("");
        this.JTFFCodigoPat.setText("");
        this.JTFFNombrePat.setText("");
        this.JTFFEEmpresaArlAcciente.setText("");
        mBuscarUElementosPPDatosBd();
        mBuscarPeligros();
        mCargarHistorialPeligro();
        mCargarHistorialAccidenteTrabajo();
        mCargarHistorialEnfemedadProfesional();
        mBuscarLesion();
        mBuscarPAfectada();
        this.JTPDatos.removeTabAt(3);
    }

    private void mBuscarPatologia() {
        if (!this.JTFFCodigoPat.getText().isEmpty()) {
            try {
                String sql = "SELECT Id, Nbre FROM g_patologia where Id='" + this.JTFFCodigoPat.getText().toUpperCase() + "'";
                ResultSet res = this.xct.traerRs(sql);
                if (res.next()) {
                    this.JTFFNombrePat.setText(res.getString(2));
                    this.JTFFCodigoPat.setText(this.JTFFCodigoPat.getText().toUpperCase());
                } else {
                    JOptionPane.showMessageDialog(this, "Codigo no existe", "BUSCAR PATOLOGÍA", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFNombrePat.setText((String) null);
                    this.JTFFCodigoPat.setText((String) null);
                    this.JTFFCodigoPat.requestFocus();
                }
                res.close();
                this.xct.cerrarConexionBd();
            } catch (SQLException e) {
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaLesion() {
        this.xmodelolesion = new DefaultTableModel(new Object[0], new String[]{"Id", "Lesión", "Realizada", "Observación", "Estado"}) { // from class: Historia.JPAAntecentesOcupacionales.39
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTTipoLesion.setModel(this.xmodelolesion);
        this.JTTipoLesion.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTTipoLesion.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTTipoLesion.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTTipoLesion.getColumnModel().getColumn(1).setPreferredWidth(155);
        this.JTTipoLesion.getColumnModel().getColumn(2).setPreferredWidth(45);
        this.JTTipoLesion.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTTipoLesion.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTTipoLesion.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTTipoLesion.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaPAfectada() {
        this.xmodelopafectada = new DefaultTableModel(new Object[0], new String[]{"Id", "Parte", "Afectada?", "Observación", "Estado"}) { // from class: Historia.JPAAntecentesOcupacionales.40
            Class[] types = {Integer.class, String.class, Boolean.class, String.class, Integer.class};
            boolean[] canEdit = {false, false, true, true, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTParteAfectada.setModel(this.xmodelopafectada);
        this.JTParteAfectada.getColumnModel().getColumn(0).setPreferredWidth(0);
        this.JTParteAfectada.getColumnModel().getColumn(0).setMinWidth(0);
        this.JTParteAfectada.getColumnModel().getColumn(0).setMaxWidth(0);
        this.JTParteAfectada.getColumnModel().getColumn(1).setPreferredWidth(180);
        this.JTParteAfectada.getColumnModel().getColumn(2).setPreferredWidth(35);
        this.JTParteAfectada.getColumnModel().getColumn(3).setPreferredWidth(80);
        this.JTParteAfectada.getColumnModel().getColumn(4).setPreferredWidth(0);
        this.JTParteAfectada.getColumnModel().getColumn(4).setMinWidth(0);
        this.JTParteAfectada.getColumnModel().getColumn(4).setMaxWidth(0);
    }

    private void mBuscarLesion() {
        try {
            mCrearTablaLesion();
            if (this.xbuscardatos == 0) {
                this.xsql = "SELECT `Id`, `Nbre`, -1 estado FROM `e_tipolesion` WHERE (`Estado` =0) ORDER BY Nbre ASC ";
            } else {
                this.xsql = "SELECT\n  e_tipolesion.`Id`,\n  `e_tipolesion`.`Nbre`,\n   IFNULL(`h_so_accidente_lesion`.`Observacion`,'') AS Observacion,\n   IFNULL(`h_so_accidente_lesion`.estado, 0) seleccion,\n   IFNULL(`h_so_accidente_lesion`.estado,-1) estado\nFROM\n  `e_tipolesion`\n  LEFT JOIN `h_so_accidente_lesion`\n    ON (`h_so_accidente_lesion`.`Id_TipoLesion` = `e_tipolesion`.`Id`) AND (h_so_accidente_lesion.`Id_AccidenteTra` = " + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0) + ")\n   WHERE  `e_tipolesion`.`Estado`=0\n    ORDER BY estado DESC,`e_tipolesion`.`Nbre`ASC";
            }
            ConsultasMySQL xct1 = new ConsultasMySQL();
            TableColumnModel cmodel = this.JTTipoLesion.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(1).setCellEditor(textEditor);
            ResultSet rs1 = xct1.traerRs(this.xsql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodelolesion.addRow(this.xdato);
                    this.xmodelolesion.setValueAt(rs1.getString(1), x, 0);
                    this.xmodelolesion.setValueAt(rs1.getString(2), x, 1);
                    if (this.xbuscardatos == 0) {
                        this.xmodelolesion.setValueAt(false, x, 2);
                        this.xmodelolesion.setValueAt("", x, 3);
                    } else {
                        this.xmodelolesion.setValueAt(Boolean.valueOf(rs1.getBoolean("seleccion")), x, 2);
                        this.xmodelolesion.setValueAt(rs1.getString(3), x, 3);
                    }
                    this.xmodelolesion.setValueAt(Integer.valueOf(rs1.getInt("estado")), x, 4);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarPAfectada() {
        try {
            mCrearTablaPAfectada();
            if (this.xbuscardatos == 0) {
                this.xsql = "SELECT  `Id`, `Nbre`, -1 estado FROM `e_parteafectada` WHERE (`Estado` =0) ORDER BY Nbre";
            } else {
                this.xsql = "SELECT\n  e_parteafectada.`Id`,\n  `e_parteafectada`.`Nbre`,\n  IFNULL(`h_so_accidente_pafectada`.`Observacion`,'') Observacion,\n  IFNULL(`h_so_accidente_pafectada`.estado, 0) seleccion,\n  IFNULL(`h_so_accidente_pafectada`.estado,-1) estado\nFROM\n  e_parteafectada\n  LEFT JOIN `baseserver`.`h_so_accidente_pafectada`\n    ON (`h_so_accidente_pafectada`.`Id_PAfectada` = `e_parteafectada`.`Id`) AND (h_so_accidente_pafectada.`Id_AccidenteTra` = " + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0) + ")\nWHERE `e_parteafectada`.`Estado` = 0\nORDER BY estado DESC, `e_parteafectada`.`Nbre` ASC";
            }
            ConsultasMySQL xct1 = new ConsultasMySQL();
            TableColumnModel cmodel = this.JTParteAfectada.getColumnModel();
            TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
            cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
            TextAreaEditor textEditor = new TextAreaEditor();
            cmodel.getColumn(1).setCellEditor(textEditor);
            ResultSet rs1 = xct1.traerRs(this.xsql);
            if (rs1.next()) {
                rs1.beforeFirst();
                int x = 0;
                while (rs1.next()) {
                    this.xmodelopafectada.addRow(this.xdato);
                    this.xmodelopafectada.setValueAt(rs1.getString(1), x, 0);
                    this.xmodelopafectada.setValueAt(rs1.getString(2), x, 1);
                    if (this.xbuscardatos == 0) {
                        this.xmodelopafectada.setValueAt(false, x, 2);
                        this.xmodelopafectada.setValueAt("", x, 3);
                    } else {
                        this.xmodelopafectada.setValueAt(Boolean.valueOf(rs1.getBoolean("seleccion")), x, 2);
                        this.xmodelopafectada.setValueAt(rs1.getString(3), x, 3);
                    }
                    this.xmodelopafectada.setValueAt(Integer.valueOf(rs1.getInt("estado")), x, 4);
                    x++;
                }
            }
            rs1.close();
            xct1.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mBuscarDatosAccidenteBd() {
        try {
            String sql = "SELECT `Empresa`  , `Fecha_AT` , `Causa`, `DIncapacidad` , `Secuelas`, `Observacion`, EmpresaArl FROM `h_so_accidentes_trabajo` WHERE (`Id` ='" + this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0) + "')";
            ConsultasMySQL xct1 = new ConsultasMySQL();
            ResultSet rs1 = xct1.traerRs(sql);
            if (rs1.next()) {
                rs1.first();
                this.xidaccidentetrabajo = "1";
                this.JTFFAEmpresa.setText(rs1.getString(1));
                this.JTFFAFecha.setText(rs1.getString(2));
                this.JTPACausa.setText(rs1.getString(3));
                this.JSPADiasI.setValue(Long.valueOf(rs1.getLong(4)));
                this.JTPASecuelas.setText(rs1.getString(5));
                this.JTPAObservacionAT.setText(rs1.getString(6));
                this.JTFFEEmpresaArlAcciente.setText(rs1.getString(7));
            }
            rs1.close();
            xct1.cerrarConexionBd();
            mBuscarLesion();
            mBuscarPAfectada();
        } catch (SQLException ex) {
            Logger.getLogger(JPAAntecentesOcupacionales.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
