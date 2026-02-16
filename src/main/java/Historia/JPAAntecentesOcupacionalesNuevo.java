package Historia;

import Acceso.Principal;
import General.JIFBuscarDatos;
import General.JIFBuscarPatologia;
import Odontologia.JIFHistoriaOdontologica;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import Utilidades.TextAreaEditor;
import Utilidades.TextAreaRenderer;
import com.genoma.plus.jpa.entities.EParteAfectadaEntity;
import com.genoma.plus.jpa.entities.ETipoLesionEntity;
import com.genoma.plus.jpa.entities.GPeligrosEntity;
import com.genoma.plus.jpa.entities.HAccidenteLesionEntity;
import com.genoma.plus.jpa.entities.HAccidentePaAfectadaEntity;
import com.genoma.plus.jpa.entities.HAccidentesTrabajoEntity;
import com.genoma.plus.jpa.entities.HEnfermedadProfesionalEntity;
import com.genoma.plus.jpa.entities.HPeligrosExpuestosDetalle;
import com.genoma.plus.jpa.entities.HPeligrosExpuestosEntity;
import com.genoma.plus.jpa.entities.HUsoElementosPpEntity;
import com.genoma.plus.jpa.projection.EnfermedadLaboralProjection;
import com.genoma.plus.jpa.projection.UsoElementosPpProjection;
import com.genoma.plus.jpa.service.HAccidenteLesionService;
import com.genoma.plus.jpa.service.HAccidentePaAfectadaService;
import com.genoma.plus.jpa.service.HAccidenteTrabajoService;
import com.genoma.plus.jpa.service.HEnfermedadProfesionalService;
import com.genoma.plus.jpa.service.HPeligrosExpuestosDetalleService;
import com.genoma.plus.jpa.service.HPeligrosExpuestosService;
import com.genoma.plus.jpa.service.HUsoElementosPpService;
import com.genoma.plus.jpa.service.ParteAfectadaService;
import com.genoma.plus.jpa.service.PeligrosService;
import com.genoma.plus.jpa.service.TipoLesionService;
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecentesOcupacionalesNuevo.class */
public class JPAAntecentesOcupacionalesNuevo extends JPanel {
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
    public Long xidusuario;
    private String xidatencion;
    private String xsql;
    private HPeligrosExpuestosEntity peligrosEspuestoEnt;
    private HAccidentesTrabajoEntity accidenteTrabajo;
    private HEnfermedadProfesionalEntity enfermedadProfesional;
    private HUsoElementosPpEntity elementosPp;
    private HPeligrosExpuestosDetalle peligrosExpuestosDetalle;
    private HAccidenteLesionEntity accidenteLesionEntity;
    private HAccidentePaAfectadaEntity accidentePaAfectadaEntity;
    private ETipoLesionEntity eTipoLesionEntity;
    private EParteAfectadaEntity afectadaEntity;
    private GPeligrosEntity gPeligrosEntity;
    private JIFHistoriaOdontologica xjifcho;
    private JIFBuscarDatos xjifbuscardatos;
    List<HAccidentesTrabajoEntity> listAccidenteLaboralEntity;
    List<HPeligrosExpuestosDetalle> listPeligrosDetalle;
    List<HPeligrosExpuestosEntity> listPeligrosExpuestos;
    List<EnfermedadLaboralProjection> listEnfermedadLaboral;
    List<UsoElementosPpProjection> listUsoElementos;
    List<GPeligrosEntity> listPeligros;
    List<ETipoLesionEntity> listLesiones;
    List<EParteAfectadaEntity> listParteAfectada;
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
    private JCheckBox JCHEstado;
    private JCheckBox JCHEstado1;
    private JCheckBox JCHEstadoPeligro;
    private JLabel JLBEstado;
    private JLabel JLBEstadoEnfermedad;
    private JLabel JLBEstadoPeligros;
    private JLabel JLBId;
    private JLabel JLBIdEnfermedad;
    private JLabel JLBIdPeligro;
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
    private JScrollPane JSPEIndemnizacion1;
    private JScrollPane JSPEObservacionEP;
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
    private JSpinner jSpinner1;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xidpeligroexpuesto = "0";
    private String xidaccidentetrabajo = "0";
    private String xidenfermedadprofesional = "0";
    private final HPeligrosExpuestosService peligrosExpuestos = (HPeligrosExpuestosService) Principal.contexto.getBean(HPeligrosExpuestosService.class);
    private final HAccidenteTrabajoService accidentesTrabajo = (HAccidenteTrabajoService) Principal.contexto.getBean(HAccidenteTrabajoService.class);
    private final HEnfermedadProfesionalService enfermedadLaboral = (HEnfermedadProfesionalService) Principal.contexto.getBean(HEnfermedadProfesionalService.class);
    private final HUsoElementosPpService usoElementosPp = (HUsoElementosPpService) Principal.contexto.getBean(HUsoElementosPpService.class);
    private final HAccidenteLesionService accidenteLesionService = (HAccidenteLesionService) Principal.contexto.getBean(HAccidenteLesionService.class);
    private final TipoLesionService tipoLesionService = (TipoLesionService) Principal.contexto.getBean(TipoLesionService.class);
    private final ParteAfectadaService parteAfectadaService = (ParteAfectadaService) Principal.contexto.getBean(ParteAfectadaService.class);
    private final PeligrosService peligrosService = (PeligrosService) Principal.contexto.getBean(PeligrosService.class);
    private final HAccidentePaAfectadaService accidentePaAfectadaService = (HAccidentePaAfectadaService) Principal.contexto.getBean(HAccidentePaAfectadaService.class);
    private final HPeligrosExpuestosDetalleService peligrosExpuestosDetalleService = (HPeligrosExpuestosDetalleService) Principal.contexto.getBean(HPeligrosExpuestosDetalleService.class);
    private boolean xelementopp = false;
    private int xbuscardatos = 0;
    private boolean xguardarat = false;
    private boolean xguardarel = false;
    private boolean xguardarUE = false;

    public JPAAntecentesOcupacionalesNuevo(clasesHistoriaCE xclase, int xmod) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xclase = xclase;
        mNuevo();
    }

    public JPAAntecentesOcupacionalesNuevo(JIFHistoriaOdontologica xjifcho, int xmod) {
        this.xmod = -1;
        initComponents();
        this.xmod = xmod;
        this.xjifcho = xjifcho;
        mNuevo();
    }

    /* JADX WARN: Type inference failed for: r3v118, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v123, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v155, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v245, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v285, types: [java.lang.Object[], java.lang.Object[][]] */
    /* JADX WARN: Type inference failed for: r3v70, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGVive = new ButtonGroup();
        this.JBGElementosPP = new ButtonGroup();
        this.jSpinner1 = new JSpinner();
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
        this.JLBEstadoPeligros = new JLabel();
        this.JCHEstadoPeligro = new JCheckBox();
        this.JSPHistorialP = new JScrollPane();
        this.JTPHistorialP = new JTable();
        this.JLBIdPeligro = new JLabel();
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
        this.JLBId = new JLabel();
        this.JLBEstado = new JLabel();
        this.JCHEstado = new JCheckBox();
        this.JSPHistorialA = new JScrollPane();
        this.JTPHistorialA = new JTable();
        this.JPEnfermedadP = new JPanel();
        this.JPIDatosEp = new JPanel();
        this.JTFFEEmpresa = new JTextField();
        this.JTFFEFecha = new JTextField();
        this.JSPEIndemnizacion = new JScrollPane();
        this.JTPEReubicacion = new JTextPane();
        this.JSPEObservacionEP = new JScrollPane();
        this.JTPEObservacionEP = new JTextPane();
        this.JBTPAdicionarEnfermedad = new JButton();
        this.JTFFCodigoPat = new JTextField();
        this.JTFFNombrePat = new JTextField();
        this.JTFFEEmpresaArl = new JTextField();
        this.JTFFESEG = new JTextField();
        this.JBTPLimpiarEnfermedad = new JButton();
        this.JCHEstado1 = new JCheckBox();
        this.JLBEstadoEnfermedad = new JLabel();
        this.JLBIdEnfermedad = new JLabel();
        this.JSPEIndemnizacion1 = new JScrollPane();
        this.JTPEIndemnizacion = new JTextPane();
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
        setName("jifantecedentesocupacionalesNuevo");
        this.JTPDatos.setForeground(Color.red);
        this.JTPDatos.setFont(new Font("Arial", 1, 14));
        this.JTPDatos.setInheritsPopupMenu(true);
        this.JPIDatosPeligros.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFPEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFFPEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPEmpresa.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.1
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFPEmpresaMouseClicked(evt);
            }
        });
        this.JTFFPEmpresa.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.2
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFPEmpresaKeyPressed(evt);
            }
        });
        this.JTFFPCargo.setFont(new Font("Arial", 1, 12));
        this.JTFFPCargo.setBorder(BorderFactory.createTitledBorder((Border) null, "Cargo", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFPCargo.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.3
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFPCargoMouseClicked(evt);
            }
        });
        this.JSPPObservacionesPeligro.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPPObservacionesPeligros.setFont(new Font("Arial", 1, 12));
        this.JTPPObservacionesPeligros.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.4
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTPPObservacionesPeligrosKeyPressed(evt);
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
        this.JBTPAdicionarPeligro.setFont(new Font("Arial", 1, 12));
        this.JBTPAdicionarPeligro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTPAdicionarPeligro.setText("Grabar");
        this.JBTPAdicionarPeligro.setToolTipText("Grabar");
        this.JBTPAdicionarPeligro.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.5
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPAdicionarPeligroActionPerformed(evt);
            }
        });
        this.JBTPAdicionarPeligro.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.6
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPAdicionarPeligroKeyPressed(evt);
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
        this.JRBNO.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.7
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JRBNOActionPerformed(evt);
            }
        });
        this.JBGElementosPP.add(this.JRBSi);
        this.JRBSi.setFont(new Font("Arial", 1, 12));
        this.JRBSi.setText("Sí");
        this.JRBSi.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.8
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JRBSiActionPerformed(evt);
            }
        });
        GroupLayout JPElePPLayout = new GroupLayout(this.JPElePP);
        this.JPElePP.setLayout(JPElePPLayout);
        JPElePPLayout.setHorizontalGroup(JPElePPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPElePPLayout.createSequentialGroup().addContainerGap().addComponent(this.JRBSi, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JRBNO).addContainerGap(-1, 32767)));
        JPElePPLayout.setVerticalGroup(JPElePPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElePPLayout.createSequentialGroup().addGroup(JPElePPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JRBNO).addComponent(this.JRBSi)).addGap(0, 0, 32767)));
        this.JBTPLimpiarPeligro.setFont(new Font("Arial", 1, 12));
        this.JBTPLimpiarPeligro.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTPLimpiarPeligro.setText("Limpiar");
        this.JBTPLimpiarPeligro.setToolTipText("Limpiar Campos");
        this.JBTPLimpiarPeligro.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.9
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPLimpiarPeligroActionPerformed(evt);
            }
        });
        this.JBTPLimpiarPeligro.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.10
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPLimpiarPeligroKeyPressed(evt);
            }
        });
        this.JLBEstadoPeligros.setBackground(new Color(255, 255, 255));
        this.JLBEstadoPeligros.setFont(new Font("Arial", 1, 18));
        this.JLBEstadoPeligros.setForeground(new Color(255, 0, 0));
        this.JLBEstadoPeligros.setHorizontalAlignment(0);
        this.JLBEstadoPeligros.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHEstadoPeligro.setSelected(true);
        this.JCHEstadoPeligro.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.11
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JCHEstadoPeligroActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosPeligrosLayout = new GroupLayout(this.JPIDatosPeligros);
        this.JPIDatosPeligros.setLayout(JPIDatosPeligrosLayout);
        JPIDatosPeligrosLayout.setHorizontalGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosPeligrosLayout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addComponent(this.JTFFPEmpresa, -2, 275, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAno, -2, 60, -2).addGap(4, 4, 4).addComponent(this.JSPMes, -2, 60, -2)).addComponent(this.JSPPExpuestos, -2, 0, 32767)).addGap(12, 12, 12).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addComponent(this.JTFFPCargo, -2, 258, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHEstadoPeligro, -2, 22, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEstadoPeligros, -2, 91, -2)).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JSPPObservacionesPeligro, GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.LEADING, JPIDatosPeligrosLayout.createSequentialGroup().addComponent(this.JPElePP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPAdicionarPeligro, -2, 109, -2).addGap(18, 18, 18).addComponent(this.JBTPLimpiarPeligro, -2, 105, -2)))).addGap(40, 40, 40)));
        JPIDatosPeligrosLayout.setVerticalGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFPEmpresa, -2, 50, -2).addComponent(this.JSPAno, -2, -1, -2).addComponent(this.JSPMes, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPPExpuestos, -2, 98, -2).addGap(25, 25, 25)).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFPCargo, -1, 50, 32767).addComponent(this.JLBEstadoPeligros, -1, -1, 32767)).addGroup(JPIDatosPeligrosLayout.createSequentialGroup().addGap(19, 19, 19).addComponent(this.JCHEstadoPeligro))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JSPPObservacionesPeligro, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPElePP, -2, -1, -2).addGroup(JPIDatosPeligrosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTPLimpiarPeligro, -2, 49, -2).addComponent(this.JBTPAdicionarPeligro, -2, 49, -2))).addContainerGap(-1, 32767)))));
        this.JSPHistorialP.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPHistorialP.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialP.setRowHeight(25);
        this.JTPHistorialP.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialP.setSelectionForeground(Color.red);
        this.JTPHistorialP.setSelectionMode(0);
        this.JTPHistorialP.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.12
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTPHistorialPMouseClicked(evt);
            }
        });
        this.JTPHistorialP.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.13
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTPHistorialPKeyPressed(evt);
            }
        });
        this.JSPHistorialP.setViewportView(this.JTPHistorialP);
        this.JLBIdPeligro.setBackground(new Color(255, 255, 255));
        this.JLBIdPeligro.setFont(new Font("Arial", 1, 18));
        this.JLBIdPeligro.setForeground(new Color(255, 0, 0));
        this.JLBIdPeligro.setHorizontalAlignment(0);
        this.JLBIdPeligro.setBorder(BorderFactory.createTitledBorder((Border) null, "ID", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        GroupLayout JPPeligrosLayout = new GroupLayout(this.JPPeligros);
        this.JPPeligros.setLayout(JPPeligrosLayout);
        JPPeligrosLayout.setHorizontalGroup(JPPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPeligrosLayout.createSequentialGroup().addContainerGap().addGroup(JPPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBIdPeligro, -2, 111, -2).addComponent(this.JSPHistorialP).addComponent(this.JPIDatosPeligros, -2, 817, 32767)).addContainerGap(-1, 32767)));
        JPPeligrosLayout.setVerticalGroup(JPPeligrosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPeligrosLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosPeligros, -2, -1, -2).addGap(18, 18, 18).addComponent(this.JSPHistorialP, -2, 186, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBIdPeligro, -1, 54, 32767).addGap(14, 14, 14)));
        this.JTPDatos.addTab("PELIGROS", this.JPPeligros);
        this.JPIDatosAt.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFAEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFFAEmpresa.setAutoscrolls(false);
        this.JTFFAEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFAEmpresa.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.14
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFAEmpresaMouseClicked(evt);
            }
        });
        this.JTFFAFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFAFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPACausa.setBorder(BorderFactory.createTitledBorder((Border) null, "Causa", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPACausa.setFont(new Font("Arial", 1, 12));
        this.JSPACausa.setViewportView(this.JTPACausa);
        this.JSPADiasI.setFont(new Font("Arial", 1, 12));
        this.JSPADiasI.setModel(new SpinnerNumberModel());
        this.JSPADiasI.setBorder(BorderFactory.createTitledBorder((Border) null, "Dias Incap.", 2, 0, new Font("Arial", 1, 11), Color.blue));
        this.JSPASecuelas.setBorder(BorderFactory.createTitledBorder((Border) null, "Secuelas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPASecuelas.setFont(new Font("Arial", 1, 12));
        this.JTPASecuelas.setFont(new Font("Arial", 1, 12));
        this.JSPASecuelas.setViewportView(this.JTPASecuelas);
        this.JSPAObservacionAT.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPAObservacionAT.setFont(new Font("Arial", 1, 12));
        this.JTPAObservacionAT.setFont(new Font("Arial", 1, 12));
        this.JSPAObservacionAT.setViewportView(this.JTPAObservacionAT);
        this.JBTPAdicionarAt.setFont(new Font("Arial", 1, 12));
        this.JBTPAdicionarAt.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTPAdicionarAt.setText("Grabar");
        this.JBTPAdicionarAt.setToolTipText("Grabar");
        this.JBTPAdicionarAt.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.15
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPAdicionarAtActionPerformed(evt);
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
        this.JBTPLimpiarAccidentes.setFont(new Font("Arial", 1, 12));
        this.JBTPLimpiarAccidentes.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTPLimpiarAccidentes.setText("Limpiar");
        this.JBTPLimpiarAccidentes.setToolTipText("Limpiar Campos");
        this.JBTPLimpiarAccidentes.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.16
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPLimpiarAccidentesActionPerformed(evt);
            }
        });
        this.JBTPLimpiarAccidentes.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.17
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPLimpiarAccidentesKeyPressed(evt);
            }
        });
        this.JTFFEEmpresaArlAcciente.setFont(new Font("Arial", 1, 12));
        this.JTFFEEmpresaArlAcciente.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEEmpresaArlAcciente.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.18
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFEEmpresaArlAccienteMouseClicked(evt);
            }
        });
        this.JLBId.setBackground(new Color(255, 255, 255));
        this.JLBId.setFont(new Font("Arial", 1, 18));
        this.JLBId.setForeground(new Color(255, 0, 0));
        this.JLBId.setHorizontalAlignment(0);
        this.JLBId.setBorder(BorderFactory.createTitledBorder((Border) null, "ID", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBEstado.setBackground(new Color(255, 255, 255));
        this.JLBEstado.setFont(new Font("Arial", 1, 18));
        this.JLBEstado.setForeground(new Color(255, 0, 0));
        this.JLBEstado.setHorizontalAlignment(0);
        this.JLBEstado.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JCHEstado.setSelected(true);
        this.JCHEstado.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.19
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JCHEstadoActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosAtLayout = new GroupLayout(this.JPIDatosAt);
        this.JPIDatosAt.setLayout(JPIDatosAtLayout);
        JPIDatosAtLayout.setHorizontalGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addComponent(this.JSPADiasI, -2, 87, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPASecuelas, -2, 214, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPAObservacionAT, -2, 251, -2).addGap(0, 227, 32767)).addGroup(JPIDatosAtLayout.createSequentialGroup().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFAEmpresa, GroupLayout.Alignment.LEADING).addComponent(this.JTFFEEmpresaArlAcciente, GroupLayout.Alignment.LEADING).addComponent(this.JSPTipoLesion, GroupLayout.Alignment.LEADING, -1, 397, 32767)).addGap(18, 18, 18).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosAtLayout.createSequentialGroup().addComponent(this.JTFFAFecha).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEstado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEstado, -2, 114, -2).addGap(18, 18, 18).addComponent(this.JLBId, -2, 111, -2)).addComponent(this.JSPACausa, GroupLayout.Alignment.TRAILING).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosAtLayout.createSequentialGroup().addComponent(this.JBTPAdicionarAt).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTPLimpiarAccidentes, -1, -1, 32767)).addComponent(this.JSPParteAfectada, -2, 359, -2))))).addContainerGap()));
        JPIDatosAtLayout.setVerticalGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIDatosAtLayout.createSequentialGroup().addGap(0, 0, 32767).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JBTPLimpiarAccidentes, -2, 41, -2).addComponent(this.JBTPAdicionarAt, -2, 41, -2))).addGroup(JPIDatosAtLayout.createSequentialGroup().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosAtLayout.createSequentialGroup().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JLBEstado, GroupLayout.Alignment.TRAILING, -1, 50, 32767).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosAtLayout.createSequentialGroup().addComponent(this.JCHEstado).addGap(10, 10, 10)).addComponent(this.JLBId, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPACausa, -2, 50, -2).addGap(5, 5, 5).addComponent(this.JSPParteAfectada, -2, 110, -2)).addGroup(JPIDatosAtLayout.createSequentialGroup().addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFAEmpresa, -2, 50, -2).addComponent(this.JTFFAFecha, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFEEmpresaArlAcciente, -2, 50, -2).addGap(5, 5, 5).addComponent(this.JSPTipoLesion, -2, 0, 32767))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIDatosAtLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JSPADiasI, -2, -1, -2).addComponent(this.JSPAObservacionAT, -2, 50, -2).addComponent(this.JSPASecuelas, -2, 50, -2)))).addContainerGap(7, 32767)));
        this.JSPHistorialA.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JSPHistorialA.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.20
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JSPHistorialAMouseClicked(evt);
            }
        });
        this.JTPHistorialA.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialA.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialA.setRowHeight(25);
        this.JTPHistorialA.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialA.setSelectionForeground(Color.red);
        this.JTPHistorialA.setSelectionMode(0);
        this.JTPHistorialA.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.21
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTPHistorialAMouseClicked(evt);
            }
        });
        this.JSPHistorialA.setViewportView(this.JTPHistorialA);
        GroupLayout JPAccidentesLayout = new GroupLayout(this.JPAccidentes);
        this.JPAccidentes.setLayout(JPAccidentesLayout);
        JPAccidentesLayout.setHorizontalGroup(JPAccidentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAccidentesLayout.createSequentialGroup().addContainerGap().addGroup(JPAccidentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JSPHistorialA).addComponent(this.JPIDatosAt, -1, -1, 32767)).addContainerGap(-1, 32767)));
        JPAccidentesLayout.setVerticalGroup(JPAccidentesLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPAccidentesLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JPIDatosAt, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorialA, -1, 168, 32767).addContainerGap()));
        this.JTPDatos.addTab("ACCIDENTES TRABAJO", this.JPAccidentes);
        this.JPIDatosEp.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JTFFEEmpresa.setFont(new Font("Arial", 1, 12));
        this.JTFFEEmpresa.setBorder(BorderFactory.createTitledBorder((Border) null, "Empresa", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEEmpresa.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.22
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFEEmpresaMouseClicked(evt);
            }
        });
        this.JTFFEFecha.setFont(new Font("Arial", 1, 12));
        this.JTFFEFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPEIndemnizacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Reubicacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEReubicacion.setFont(new Font("Arial", 1, 12));
        this.JSPEIndemnizacion.setViewportView(this.JTPEReubicacion);
        this.JSPEObservacionEP.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEObservacionEP.setFont(new Font("Arial", 1, 12));
        this.JSPEObservacionEP.setViewportView(this.JTPEObservacionEP);
        this.JBTPAdicionarEnfermedad.setFont(new Font("Arial", 1, 12));
        this.JBTPAdicionarEnfermedad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTPAdicionarEnfermedad.setText("Grabar");
        this.JBTPAdicionarEnfermedad.setToolTipText("Grabar");
        this.JBTPAdicionarEnfermedad.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.23
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPAdicionarEnfermedadActionPerformed(evt);
            }
        });
        this.JTFFCodigoPat.setFont(new Font("Arial", 1, 12));
        this.JTFFCodigoPat.setBorder(BorderFactory.createTitledBorder((Border) null, "CIE10", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFCodigoPat.addFocusListener(new FocusAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.24
            public void focusLost(FocusEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFCodigoPatFocusLost(evt);
            }
        });
        this.JTFFCodigoPat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.25
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFCodigoPatKeyPressed(evt);
            }
        });
        this.JTFFNombrePat.setFont(new Font("Arial", 1, 12));
        this.JTFFNombrePat.setBorder(BorderFactory.createTitledBorder((Border) null, "Nombre Patología", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFNombrePat.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.26
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFNombrePatMouseClicked(evt);
            }
        });
        this.JTFFNombrePat.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.27
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFNombrePatKeyPressed(evt);
            }
        });
        this.JTFFEEmpresaArl.setFont(new Font("Arial", 1, 12));
        this.JTFFEEmpresaArl.setBorder(BorderFactory.createTitledBorder((Border) null, "ARL", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFEEmpresaArl.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.28
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFEEmpresaArlMouseClicked(evt);
            }
        });
        this.JTFFESEG.setFont(new Font("Arial", 1, 12));
        this.JTFFESEG.setBorder(BorderFactory.createTitledBorder((Border) null, "SEG", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFESEG.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.29
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTFFESEGMouseClicked(evt);
            }
        });
        this.JBTPLimpiarEnfermedad.setFont(new Font("Arial", 1, 12));
        this.JBTPLimpiarEnfermedad.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Limpiar.png")));
        this.JBTPLimpiarEnfermedad.setText("Limpiar");
        this.JBTPLimpiarEnfermedad.setToolTipText("Limpiar Campos");
        this.JBTPLimpiarEnfermedad.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.30
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPLimpiarEnfermedadActionPerformed(evt);
            }
        });
        this.JBTPLimpiarEnfermedad.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.31
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTPLimpiarEnfermedadKeyPressed(evt);
            }
        });
        this.JCHEstado1.setSelected(true);
        this.JCHEstado1.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.32
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JCHEstado1ActionPerformed(evt);
            }
        });
        this.JLBEstadoEnfermedad.setBackground(new Color(255, 255, 255));
        this.JLBEstadoEnfermedad.setFont(new Font("Arial", 1, 18));
        this.JLBEstadoEnfermedad.setForeground(new Color(255, 0, 0));
        this.JLBEstadoEnfermedad.setHorizontalAlignment(0);
        this.JLBEstadoEnfermedad.setBorder(BorderFactory.createTitledBorder((Border) null, "Estado", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JLBIdEnfermedad.setBackground(new Color(255, 255, 255));
        this.JLBIdEnfermedad.setFont(new Font("Arial", 1, 18));
        this.JLBIdEnfermedad.setForeground(new Color(255, 0, 0));
        this.JLBIdEnfermedad.setHorizontalAlignment(0);
        this.JLBIdEnfermedad.setBorder(BorderFactory.createTitledBorder((Border) null, "ID", 1, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPEIndemnizacion1.setBorder(BorderFactory.createTitledBorder((Border) null, "Indemnización", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPEIndemnizacion.setFont(new Font("Arial", 1, 12));
        this.JSPEIndemnizacion1.setViewportView(this.JTPEIndemnizacion);
        GroupLayout JPIDatosEpLayout = new GroupLayout(this.JPIDatosEp);
        this.JPIDatosEp.setLayout(JPIDatosEpLayout);
        JPIDatosEpLayout.setHorizontalGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createSequentialGroup().addContainerGap().addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createSequentialGroup().addComponent(this.JTFFEEmpresa, -2, 394, -2).addGap(18, 18, 18).addComponent(this.JTFFEFecha, -2, 102, -2).addGap(18, 18, 18).addComponent(this.JCHEstado1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBEstadoEnfermedad, -2, 114, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JLBIdEnfermedad, -2, 95, -2)).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIDatosEpLayout.createSequentialGroup().addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIDatosEpLayout.createSequentialGroup().addComponent(this.JTFFCodigoPat, -2, 87, -2).addGap(18, 18, 18).addComponent(this.JTFFNombrePat)).addComponent(this.JTFFEEmpresaArl, -2, 523, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JBTPAdicionarEnfermedad, -2, 112, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JBTPLimpiarEnfermedad)).addGroup(GroupLayout.Alignment.LEADING, JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFFESEG, -2, 251, -2).addGroup(GroupLayout.Alignment.LEADING, JPIDatosEpLayout.createSequentialGroup().addComponent(this.JSPEIndemnizacion1, -2, 267, -2).addGap(18, 18, 18).addComponent(this.JSPEIndemnizacion, -2, 238, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JSPEObservacionEP, -2, 251, -2))))).addContainerGap(-1, 32767)));
        JPIDatosEpLayout.setVerticalGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createSequentialGroup().addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFEFecha, GroupLayout.Alignment.TRAILING, -2, 50, -2).addComponent(this.JTFFEEmpresa, -2, 50, -2)).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JLBIdEnfermedad, -1, -1, 32767).addComponent(this.JLBEstadoEnfermedad, GroupLayout.Alignment.LEADING, -2, 50, -2)).addGroup(JPIDatosEpLayout.createSequentialGroup().addContainerGap().addComponent(this.JCHEstado1))).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPEIndemnizacion, -2, 49, -2).addComponent(this.JSPEObservacionEP, -2, 50, -2).addComponent(this.JSPEIndemnizacion1, -2, 49, -2)).addGap(18, 18, 18).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFEEmpresaArl, -2, 50, -2).addComponent(this.JTFFESEG, -2, 46, -2)).addGap(18, 18, 18).addGroup(JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFCodigoPat, -2, 50, -2).addComponent(this.JTFFNombrePat, -2, 50, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIDatosEpLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTPAdicionarEnfermedad, -2, 44, -2).addComponent(this.JBTPLimpiarEnfermedad, -2, 44, -2))).addContainerGap(39, 32767)));
        this.JSPHistorialEP.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPHistorialEP.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialEP.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialEP.setRowHeight(25);
        this.JTPHistorialEP.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialEP.setSelectionForeground(Color.red);
        this.JTPHistorialEP.setSelectionMode(0);
        this.JTPHistorialEP.addMouseListener(new MouseAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.33
            public void mouseClicked(MouseEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTPHistorialEPMouseClicked(evt);
            }
        });
        this.JSPHistorialEP.setViewportView(this.JTPHistorialEP);
        GroupLayout JPEnfermedadPLayout = new GroupLayout(this.JPEnfermedadP);
        this.JPEnfermedadP.setLayout(JPEnfermedadPLayout);
        JPEnfermedadPLayout.setHorizontalGroup(JPEnfermedadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEnfermedadPLayout.createSequentialGroup().addContainerGap().addGroup(JPEnfermedadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatosEp, -1, -1, 32767).addComponent(this.JSPHistorialEP)).addContainerGap(10, 32767)));
        JPEnfermedadPLayout.setVerticalGroup(JPEnfermedadPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPEnfermedadPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosEp, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.JSPHistorialEP, -2, 152, -2).addContainerGap()));
        this.JTPDatos.addTab("ENFERMEDAD LABORAL", this.JPEnfermedadP);
        this.JPIDatosElementosPP.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.JCBUElementosPP.setFont(new Font("Arial", 1, 12));
        this.JCBUElementosPP.setBorder(BorderFactory.createTitledBorder((Border) null, "Elemento", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JSPUObservacionesElementoP.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTPUObservacionesElementoP.setFont(new Font("Arial", 1, 12));
        this.JSPUObservacionesElementoP.setViewportView(this.JTPUObservacionesElementoP);
        this.JBTUAdicionarElementoP.setFont(new Font("Arial", 1, 14));
        this.JBTUAdicionarElementoP.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTUAdicionarElementoP.addActionListener(new ActionListener() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.34
            public void actionPerformed(ActionEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JBTUAdicionarElementoPActionPerformed(evt);
            }
        });
        GroupLayout JPIDatosElementosPPLayout = new GroupLayout(this.JPIDatosElementosPP);
        this.JPIDatosElementosPP.setLayout(JPIDatosElementosPPLayout);
        JPIDatosElementosPPLayout.setHorizontalGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBUElementosPP, -2, 386, -2).addGap(18, 18, 18).addComponent(this.JSPUObservacionesElementoP, -1, 354, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JBTUAdicionarElementoP).addContainerGap()));
        JPIDatosElementosPPLayout.setVerticalGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIDatosElementosPPLayout.createSequentialGroup().addGroup(JPIDatosElementosPPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JBTUAdicionarElementoP, -2, 43, -2).addComponent(this.JSPUObservacionesElementoP, -2, -1, -2).addComponent(this.JCBUElementosPP, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.JSPHistorialU.setBorder(BorderFactory.createTitledBorder((Border) null, "HISTORIAL", 2, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.JTPHistorialU.setFont(new Font("Arial", 1, 12));
        this.JTPHistorialU.setModel(new DefaultTableModel((Object[][]) new Object[0], new String[0]));
        this.JTPHistorialU.setRowHeight(25);
        this.JTPHistorialU.setSelectionBackground(new Color(255, 255, 255));
        this.JTPHistorialU.setSelectionForeground(Color.red);
        this.JTPHistorialU.setSelectionMode(0);
        this.JTPHistorialU.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecentesOcupacionalesNuevo.35
            public void keyPressed(KeyEvent evt) {
                JPAAntecentesOcupacionalesNuevo.this.JTPHistorialUKeyPressed(evt);
            }
        });
        this.JSPHistorialU.setViewportView(this.JTPHistorialU);
        GroupLayout JPElementosPPLayout = new GroupLayout(this.JPElementosPP);
        this.JPElementosPP.setLayout(JPElementosPPLayout);
        JPElementosPPLayout.setHorizontalGroup(JPElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElementosPPLayout.createSequentialGroup().addContainerGap().addGroup(JPElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPIDatosElementosPP, -1, -1, 32767).addComponent(this.JSPHistorialU)).addContainerGap(-1, 32767)));
        JPElementosPPLayout.setVerticalGroup(JPElementosPPLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPElementosPPLayout.createSequentialGroup().addContainerGap().addComponent(this.JPIDatosElementosPP, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPHistorialU, -1, 396, 32767).addContainerGap()));
        this.JTPDatos.addTab("USO ELEMENTOS PP", this.JPElementosPP);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.JTPDatos, -2, 848, -2).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JTPDatos, -2, -1, -2).addContainerGap(-1, 32767)));
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

    private void mGrabarPeligros() {
        if ("".equals(this.JLBIdPeligro.getText()) && !this.listPeligrosExpuestos.isEmpty()) {
            this.peligrosEspuestoEnt.setIdUsuario(this.xidusuario);
            this.peligrosEspuestoEnt.setIdAtencion(Long.valueOf(this.xidatencion));
            this.peligrosEspuestoEnt.setEmpresa(this.JTFFPEmpresa.getText().toUpperCase());
            this.peligrosEspuestoEnt.setAno(Integer.valueOf(this.JSPAno.getValue().toString()));
            this.peligrosEspuestoEnt.setMes(Integer.valueOf(this.JSPMes.getValue().toString()));
            this.peligrosEspuestoEnt.setElementosPP(Boolean.valueOf(this.xelementopp));
            this.peligrosEspuestoEnt.setCargo(this.JTFFPCargo.getText().toUpperCase());
            this.peligrosEspuestoEnt.setObservacion(this.JTPPObservacionesPeligros.getText());
            this.peligrosEspuestoEnt.setEstado(Boolean.valueOf(this.JCHEstadoPeligro.isSelected()));
            this.peligrosEspuestoEnt.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            List<HPeligrosExpuestosDetalle> listPeligrosExpuestos = new ArrayList<>();
            for (int y = 0; y < this.JTPPExpuestos.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelop.getValueAt(y, 2).toString()).booleanValue()) {
                    this.peligrosExpuestosDetalle = new HPeligrosExpuestosDetalle();
                    this.gPeligrosEntity = new GPeligrosEntity();
                    this.gPeligrosEntity.setId(Long.valueOf(this.xmodelop.getValueAt(y, 0).toString()));
                    this.peligrosExpuestosDetalle.setId_So_Peligros(this.peligrosEspuestoEnt);
                    this.peligrosExpuestosDetalle.setId_Peligro(this.gPeligrosEntity);
                    this.peligrosExpuestosDetalle.setObservacion(this.xmodelop.getValueAt(y, 3).toString());
                    this.peligrosExpuestosDetalle.setEstado(true);
                    this.peligrosExpuestosDetalle.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    listPeligrosExpuestos.add(this.peligrosExpuestosDetalle);
                }
            }
            this.peligrosEspuestoEnt.setHPeligrosExpuestosEntities(listPeligrosExpuestos);
            this.peligrosEspuestoEnt = this.peligrosExpuestos.grabar(this.peligrosEspuestoEnt);
            return;
        }
        this.peligrosEspuestoEnt.setIdUsuario(this.xidusuario);
        this.peligrosEspuestoEnt.setIdAtencion(Long.valueOf(this.xidatencion));
        this.peligrosEspuestoEnt.setEmpresa(this.JTFFPEmpresa.getText().toUpperCase());
        this.peligrosEspuestoEnt.setAno(Integer.valueOf(this.JSPAno.getValue().toString()));
        this.peligrosEspuestoEnt.setMes(Integer.valueOf(this.JSPMes.getValue().toString()));
        this.peligrosEspuestoEnt.setElementosPP(Boolean.valueOf(this.xelementopp));
        this.peligrosEspuestoEnt.setCargo(this.JTFFPCargo.getText().toUpperCase());
        this.peligrosEspuestoEnt.setObservacion(this.JTPPObservacionesPeligros.getText());
        this.peligrosEspuestoEnt.setEstado(Boolean.valueOf(this.JCHEstadoPeligro.isSelected()));
        this.peligrosEspuestoEnt.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.peligrosEspuestoEnt = this.peligrosExpuestos.grabar(this.peligrosEspuestoEnt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPAdicionarPeligroActionPerformed(ActionEvent evt) {
        if (this.peligrosEspuestoEnt == null) {
            this.peligrosEspuestoEnt = new HPeligrosExpuestosEntity();
        }
        if (this.peligrosExpuestosDetalle == null) {
            this.peligrosExpuestosDetalle = new HPeligrosExpuestosDetalle();
        }
        if (this.xidpeligroexpuesto.equals("0")) {
            if (!this.JTFFPEmpresa.getText().isEmpty()) {
                if (!this.JTFFPCargo.getText().isEmpty()) {
                    if (this.xmt.mVerificarDatosTablaTrue(this.JTPPExpuestos, 2)) {
                        int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0 && "".equals(this.JLBIdPeligro.getText())) {
                            mGrabarPeligros();
                            this.JLBIdPeligro.setText(this.peligrosEspuestoEnt.getId().toString());
                            this.JLBEstadoPeligros.setText("ACTIVO");
                            mCargarHistorialPeligro();
                            return;
                        }
                        this.peligrosEspuestoEnt.setId(Long.valueOf(this.JLBIdPeligro.getText()));
                        mGrabarPeligros();
                        mCargarHistorialPeligro();
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
        if (this.elementosPp == null) {
            this.elementosPp = new HUsoElementosPpEntity();
        }
        if (this.JCBUElementosPP.getSelectedIndex() != -1) {
            int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                this.elementosPp.setIdUsuario(this.xidusuario);
                this.elementosPp.setIdAtencion(Long.valueOf(this.xidatencion));
                this.elementosPp.setIdElementoPp(Long.valueOf(this.xidelementospp[this.JCBUElementosPP.getSelectedIndex()]));
                this.elementosPp.setObservacion(this.JTPUObservacionesElementoP.getText());
                this.elementosPp.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                this.elementosPp = this.usoElementosPp.grabar(this.elementosPp);
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

    private void mGrabarAccidenteTrabajo() {
        if ("".equals(this.JLBId.getText())) {
            this.accidenteTrabajo.setIdAtencion(Long.valueOf(this.xidatencion));
            this.accidenteTrabajo.setIdUsuario(this.xidusuario);
            this.accidenteTrabajo.setEmpresa(this.JTFFAEmpresa.getText().toUpperCase());
            this.accidenteTrabajo.setFechaAT(this.JTFFAFecha.getText());
            this.accidenteTrabajo.setCausa(this.JTPACausa.getText().toUpperCase());
            this.accidenteTrabajo.setDIncapacidad(Integer.valueOf(this.JSPADiasI.getValue().toString()));
            this.accidenteTrabajo.setSecuelas(this.JTPASecuelas.getText().toUpperCase());
            this.accidenteTrabajo.setObservacion(this.JTPAObservacionAT.getText().toUpperCase());
            this.accidenteTrabajo.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
            this.accidenteTrabajo.setEmpresaArl(this.JTFFEEmpresaArlAcciente.getText().toUpperCase());
            this.accidenteTrabajo.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
            List<HAccidenteLesionEntity> listLesion = new ArrayList<>();
            List<HAccidentePaAfectadaEntity> listParteAfectada = new ArrayList<>();
            for (int y = 0; y < this.JTTipoLesion.getRowCount(); y++) {
                if (Boolean.valueOf(this.xmodelolesion.getValueAt(y, 2).toString()).booleanValue()) {
                    this.eTipoLesionEntity = new ETipoLesionEntity();
                    this.eTipoLesionEntity.setId(Long.valueOf(this.xmodelolesion.getValueAt(y, 0).toString()));
                    this.accidenteLesionEntity = new HAccidenteLesionEntity();
                    this.accidenteLesionEntity.setId_AccidenteTra(this.accidenteTrabajo);
                    this.accidenteLesionEntity.setIdTipoLesion(this.eTipoLesionEntity);
                    this.accidenteLesionEntity.setObservacion(this.xmodelolesion.getValueAt(y, 3).toString());
                    this.accidenteLesionEntity.setEstado(true);
                    this.accidenteLesionEntity.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    listLesion.add(this.accidenteLesionEntity);
                }
            }
            for (int y2 = 0; y2 < this.JTParteAfectada.getRowCount(); y2++) {
                if (Boolean.valueOf(this.xmodelopafectada.getValueAt(y2, 2).toString()).booleanValue()) {
                    this.accidentePaAfectadaEntity = new HAccidentePaAfectadaEntity();
                    this.afectadaEntity = new EParteAfectadaEntity();
                    this.afectadaEntity.setId(Long.valueOf(this.xmodelopafectada.getValueAt(y2, 0).toString()));
                    this.accidentePaAfectadaEntity.setId_AccidenteTraParteAfectada(this.accidenteTrabajo);
                    this.accidentePaAfectadaEntity.setId_PAfectada(this.afectadaEntity);
                    this.accidentePaAfectadaEntity.setObservacion(this.xmodelopafectada.getValueAt(y2, 3).toString());
                    this.accidentePaAfectadaEntity.setEstado(true);
                    this.accidentePaAfectadaEntity.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
                    listParteAfectada.add(this.accidentePaAfectadaEntity);
                }
            }
            this.accidenteTrabajo.setHAccidenteLesionEntities(listLesion);
            this.accidenteTrabajo.setHAccidentePaAfectadaEntities(listParteAfectada);
            this.accidenteTrabajo = this.accidentesTrabajo.grabar(this.accidenteTrabajo);
            return;
        }
        this.accidenteTrabajo.setIdAtencion(Long.valueOf(this.xidatencion));
        this.accidenteTrabajo.setIdUsuario(this.xidusuario);
        this.accidenteTrabajo.setEmpresa(this.JTFFAEmpresa.getText().toUpperCase());
        this.accidenteTrabajo.setFechaAT(this.JTFFAFecha.getText());
        this.accidenteTrabajo.setCausa(this.JTPACausa.getText().toUpperCase());
        this.accidenteTrabajo.setDIncapacidad(Integer.valueOf(this.JSPADiasI.getValue().toString()));
        this.accidenteTrabajo.setSecuelas(this.JTPASecuelas.getText().toUpperCase());
        this.accidenteTrabajo.setObservacion(this.JTPAObservacionAT.getText().toUpperCase());
        this.accidenteTrabajo.setEstado(Boolean.valueOf(this.JCHEstado.isSelected()));
        this.accidenteTrabajo.setEmpresaArl(this.JTFFEEmpresaArlAcciente.getText().toUpperCase());
        this.accidenteTrabajo.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.accidenteTrabajo = this.accidentesTrabajo.grabar(this.accidenteTrabajo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPAdicionarAtActionPerformed(ActionEvent evt) {
        if (this.accidenteTrabajo == null || this.accidenteLesionEntity == null || this.accidentePaAfectadaEntity == null) {
            this.accidenteTrabajo = new HAccidentesTrabajoEntity();
            this.accidenteLesionEntity = new HAccidenteLesionEntity();
            this.accidentePaAfectadaEntity = new HAccidentePaAfectadaEntity();
        }
        if (!this.JTFFAEmpresa.getText().isEmpty()) {
            if (!this.JTFFAFecha.getText().isEmpty()) {
                if (!this.JTPACausa.getText().isEmpty()) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        if ("".equals(this.JLBId.getText())) {
                            mGrabarAccidenteTrabajo();
                            this.JLBEstado.setText("ACTIVO");
                            this.JLBId.setText(this.accidenteTrabajo.getId().toString());
                            mCargarHistorialAccidenteTrabajo();
                            return;
                        }
                        this.accidenteTrabajo.setId(Long.valueOf(this.JLBId.getText()));
                        mGrabarAccidenteTrabajo();
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

    private void mGrabarEnfermedadProfesional() {
        this.enfermedadProfesional.setIdAtencion(Long.valueOf(this.xidatencion));
        this.enfermedadProfesional.setIdUsuario(this.xidusuario);
        this.enfermedadProfesional.setEmpresa(this.JTFFEEmpresa.getText().toUpperCase());
        this.enfermedadProfesional.setFechaEp(this.JTFFEFecha.getText());
        this.enfermedadProfesional.setIdPatologia(this.JTFFCodigoPat.getText());
        this.enfermedadProfesional.setIdemnizacion(this.JTPEIndemnizacion.getText().toUpperCase());
        this.enfermedadProfesional.setReubicacion(this.JTPEReubicacion.getText().toUpperCase());
        this.enfermedadProfesional.setObservacion(this.JTPEObservacionEP.getText().toUpperCase());
        this.enfermedadProfesional.setEmpresaArl(this.JTFFEEmpresaArl.getText().toUpperCase());
        this.enfermedadProfesional.setSeg(this.JTFFESEG.getText().toUpperCase());
        this.enfermedadProfesional.setEstado(Boolean.valueOf(this.JCHEstado1.isSelected()));
        this.enfermedadProfesional.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.enfermedadProfesional = this.enfermedadLaboral.grabar(this.enfermedadProfesional);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTPAdicionarEnfermedadActionPerformed(ActionEvent evt) {
        if (this.enfermedadProfesional == null) {
            this.enfermedadProfesional = new HEnfermedadProfesionalEntity();
        }
        if (!this.JTFFEEmpresa.getText().isEmpty()) {
            if (!this.JTFFEFecha.getText().isEmpty()) {
                if (!this.JTFFCodigoPat.getText().isEmpty()) {
                    int x = JOptionPane.showConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                    if (x == 0) {
                        if ("".equals(this.JLBIdEnfermedad.getText())) {
                            mGrabarEnfermedadProfesional();
                            this.JLBIdEnfermedad.setText(this.enfermedadProfesional.getId().toString());
                            this.JLBEstadoEnfermedad.setText("ACTIVO");
                            mCargarHistorialEnfemedadProfesional();
                            return;
                        }
                        this.enfermedadProfesional.setId(Long.valueOf(this.JLBIdEnfermedad.getText()));
                        mGrabarEnfermedadProfesional();
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
        this.xelementopp = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JRBNOActionPerformed(ActionEvent evt) {
        this.xelementopp = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialPMouseClicked(MouseEvent evt) {
        mBuscarPeligrosDatosBd();
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
        mBuscarEnfermedadProfesionalDatosBd();
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
        mBuscarDatosAccidenteBd();
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
        this.peligrosEspuestoEnt = new HPeligrosExpuestosEntity();
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
        this.JLBId.setText("");
        this.JLBEstado.setText("");
        this.accidenteTrabajo = new HAccidentesTrabajoEntity();
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
        this.JTPEReubicacion.setText("");
        this.JTPEObservacionEP.setText("");
        this.JTFFEEmpresaArl.setText("");
        this.JTFFESEG.setText("");
        this.JTFFCodigoPat.setText("");
        this.JTFFNombrePat.setText("");
        this.JBTPAdicionarEnfermedad.setEnabled(true);
        this.JLBEstadoEnfermedad.setText("");
        this.JLBIdEnfermedad.setText("");
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
    public void JTPHistorialUKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JSPHistorialAMouseClicked(MouseEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoActionPerformed(ActionEvent evt) {
        estado();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstado1ActionPerformed(ActionEvent evt) {
        estad2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEstadoPeligroActionPerformed(ActionEvent evt) {
        estad3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTPHistorialPKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 127 && this.JTPHistorialP.getRowCount() != 0 && this.JTPHistorialP.getSelectedRow() != -1) {
            int x = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de anular?", "CONFIRMACION", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (x == 0) {
                HPeligrosExpuestosEntity expuestosEntity = this.listPeligrosExpuestos.get(this.JTPHistorialP.getSelectedRow());
                expuestosEntity.setEstado(false);
                this.peligrosExpuestos.grabar(expuestosEntity);
                mCargarHistorialPeligro();
            }
        }
    }

    private void estad2() {
        if (this.JCHEstado1.isSelected()) {
            this.JLBEstadoEnfermedad.setText("ACTIVO");
        } else {
            this.JLBEstadoEnfermedad.setText("INACTIVO");
        }
    }

    private void estad3() {
        if (this.JCHEstadoPeligro.isSelected()) {
            this.JLBEstadoPeligros.setText("ACTIVO");
        } else {
            this.JLBEstadoPeligros.setText("INACTIVO");
        }
    }

    public void estado() {
        if (this.JCHEstado.isSelected()) {
            this.JLBEstado.setText("ACTIVO");
        } else {
            this.JLBEstado.setText("INACTIVO");
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaPeligros() {
        this.xmodelop = new DefaultTableModel(new Object[0], new String[]{"Id", "Peligro", "Expuesto?", "Observación"}) { // from class: Historia.JPAAntecentesOcupacionalesNuevo.36
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
        this.xmodelou = new DefaultTableModel(new Object[0], new String[]{"Id", "Elemento PP", "Observación"}) { // from class: Historia.JPAAntecentesOcupacionalesNuevo.37
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
        this.xmodeloa = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Fecha", "Causa", "Días Incap", "Secuelas", "Observación", "ARL", "Estado"}) { // from class: Historia.JPAAntecentesOcupacionalesNuevo.38
            Class[] types = {Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false};

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
        this.JTPHistorialA.getColumnModel().getColumn(8).setPreferredWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaEnfermedadP() {
        this.xmodeloe = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Fecha", "Cie10", "Patología", "Idemnización", "Reubicación", "ARL", "SEG", "Observación", "Estado"}) { // from class: Historia.JPAAntecentesOcupacionalesNuevo.39
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false, false, false, false};

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
        this.JTPHistorialEP.getColumnModel().getColumn(10).setPreferredWidth(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearTablaHistorialPeligro() {
        this.xmodelohp = new DefaultTableModel(new Object[0], new String[]{"Id", "Empresa", "Tiempo", "Cargo", "ElementoPP", "Observación", "Atención", "Estado"}) { // from class: Historia.JPAAntecentesOcupacionalesNuevo.40
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.class};
            boolean[] canEdit = {false, false, false, false, false, false, false, false};

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
        this.JTPHistorialP.getColumnModel().getColumn(5).setPreferredWidth(80);
        this.JTPHistorialP.getColumnModel().getColumn(6).setPreferredWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(6).setMinWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(6).setMaxWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(7).setPreferredWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(7).setMinWidth(0);
        this.JTPHistorialP.getColumnModel().getColumn(7).setMaxWidth(0);
    }

    private void mBuscarPeligros() {
        mCrearTablaPeligros();
        this.listPeligros = this.peligrosService.listarPeligros();
        if (!this.listPeligros.isEmpty()) {
            for (int i = 0; i < this.listPeligros.size(); i++) {
                this.xmodelop.addRow(this.xdato);
                this.xmodelop.setValueAt(this.listPeligros.get(i).getId(), i, 0);
                this.xmodelop.setValueAt(this.listPeligros.get(i).getNbre(), i, 1);
                this.xmodelop.setValueAt(false, i, 2);
                this.xmodelop.setValueAt("", i, 3);
            }
        }
    }

    private void mBuscarPeligrosDatosBd() {
        if (this.JTPHistorialP.getSelectedRow() != -1) {
            this.JLBIdPeligro.setText(this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 0).toString());
            this.JTFFPEmpresa.setText(this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 1).toString());
            this.JSPAno.setValue(this.listPeligrosExpuestos.get(this.JTPHistorialP.getSelectedRow()).getAno());
            this.JSPMes.setValue(this.listPeligrosExpuestos.get(this.JTPHistorialP.getSelectedRow()).getMes());
            this.JTFFPCargo.setText(this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 3).toString());
            if ("Sí".equals(this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 4).toString())) {
                this.JRBSi.setSelected(true);
            } else {
                this.JRBNO.setSelected(true);
            }
            this.JTPPObservacionesPeligros.setText(this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 5).toString());
            this.JCHEstadoPeligro.setSelected(Boolean.valueOf(this.xmodelohp.getValueAt(this.JTPHistorialP.getSelectedRow(), 7).toString()).booleanValue());
            estad3();
            this.listPeligrosExpuestos.get(this.JTPHistorialP.getSelectedRow()).getHPeligrosExpuestosEntities().forEach(e -> {
                this.xmodelop.addRow(this.xdato);
                this.xmodelop.setValueAt(e.getId_So_Peligros(), this.JTPPExpuestos.getRowCount() - 1, 0);
                this.xmodelop.setValueAt(e.getId_Peligro().getNbre(), this.JTPPExpuestos.getRowCount() - 1, 1);
                this.xmodelop.setValueAt(true, this.JTPPExpuestos.getRowCount() - 1, 2);
                this.xmodelop.setValueAt(e.getObservacion(), this.JTPPExpuestos.getRowCount() - 1, 3);
            });
        }
    }

    private void mBuscarEnfermedadProfesionalDatosBd() {
        if (this.JTPHistorialEP.getSelectedRow() != -1) {
            this.JLBIdEnfermedad.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 0).toString());
            this.JTFFEEmpresa.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 1).toString());
            this.JTFFEFecha.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 2).toString());
            this.JTFFCodigoPat.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 3).toString());
            this.JTFFNombrePat.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 4).toString());
            this.JTPEIndemnizacion.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 5).toString());
            this.JTPEReubicacion.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 6).toString());
            this.JTFFEEmpresaArl.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 7).toString());
            this.JTFFESEG.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 8).toString());
            this.JTPEObservacionEP.setText(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 9).toString());
            this.JCHEstado1.setSelected(Boolean.valueOf(this.xmodeloe.getValueAt(this.JTPHistorialEP.getSelectedRow(), 10).toString()).booleanValue());
            estad2();
        }
    }

    private void mBuscarUElementosPPDatosBd() {
        mCrearTablaUelementosPP();
        this.listUsoElementos = this.usoElementosPp.listarUsoElementosP(this.xidusuario);
        if (!this.listUsoElementos.isEmpty()) {
            for (int i = 0; i < this.listUsoElementos.size(); i++) {
                this.xmodelou.addRow(this.xdato);
                this.xmodelou.setValueAt(this.listUsoElementos.get(i).getIdElementoPp(), i, 0);
                this.xmodelou.setValueAt(this.listUsoElementos.get(i).getNbre(), i, 1);
                this.xmodelou.setValueAt(this.listUsoElementos.get(i).getObservacion(), i, 2);
            }
        }
    }

    private void mCargarHistorialAccidenteTrabajo() {
        mCrearTablaAccidenteTrabajo();
        this.listAccidenteLaboralEntity = this.accidentesTrabajo.listarAccidentesLaboralesEntidad(this.xidusuario);
        if (!this.listAccidenteLaboralEntity.isEmpty()) {
            for (int i = 0; i < this.listAccidenteLaboralEntity.size(); i++) {
                this.xmodeloa.addRow(this.xdato);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getId(), i, 0);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getEmpresa(), i, 1);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getFechaAT(), i, 2);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getCausa(), i, 3);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getDIncapacidad(), i, 4);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getSecuelas(), i, 5);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getObservacion(), i, 6);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getEmpresaArl(), i, 7);
                this.xmodeloa.setValueAt(this.listAccidenteLaboralEntity.get(i).getEstado(), i, 8);
            }
        }
    }

    private void mCargarHistorialEnfemedadProfesional() {
        mCrearTablaEnfermedadP();
        this.listEnfermedadLaboral = this.enfermedadLaboral.listarEnfermedadLaboral(this.xidusuario);
        if (!this.listEnfermedadLaboral.isEmpty()) {
            for (int i = 0; i < this.listEnfermedadLaboral.size(); i++) {
                this.xmodeloe.addRow(this.xdato);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getId(), i, 0);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getEmpresa(), i, 1);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getFechaEP(), i, 2);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getIdPatologia(), i, 3);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getNbre(), i, 4);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getIdemnizacion(), i, 5);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getReubicacion(), i, 6);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getEmpresaArl(), i, 7);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getSeg(), i, 8);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getObservacion(), i, 9);
                this.xmodeloe.setValueAt(this.listEnfermedadLaboral.get(i).getEstado(), i, 10);
            }
        }
    }

    private void mCargarHistorialPeligro() {
        mCrearTablaHistorialPeligro();
        this.listPeligrosExpuestos = this.peligrosExpuestos.listarPerligrosExpuestos(this.xidusuario);
        if (!this.listPeligrosExpuestos.isEmpty()) {
            for (int i = 0; i < this.listPeligrosExpuestos.size(); i++) {
                this.xmodelohp.addRow(this.xdato);
                this.xmodelohp.setValueAt(this.listPeligrosExpuestos.get(i).getId(), i, 0);
                this.xmodelohp.setValueAt(this.listPeligrosExpuestos.get(i).getEmpresa(), i, 1);
                this.xmodelohp.setValueAt(this.listPeligrosExpuestos.get(i).getAno() + " Año(s)  " + this.listPeligrosExpuestos.get(i).getMes() + " Mes(es)", i, 2);
                this.xmodelohp.setValueAt(this.listPeligrosExpuestos.get(i).getCargo(), i, 3);
                if (this.listPeligrosExpuestos.get(i).getElementosPP().booleanValue()) {
                    this.xmodelohp.setValueAt("Sí", i, 4);
                } else {
                    this.xmodelohp.setValueAt("No", i, 4);
                }
                this.xmodelohp.setValueAt(this.listPeligrosExpuestos.get(i).getObservacion(), i, 5);
                this.xmodelohp.setValueAt(this.listPeligrosExpuestos.get(i).getIdAtencion(), i, 6);
                this.xmodelohp.setValueAt(this.listPeligrosExpuestos.get(i).getEstado(), i, 7);
            }
        }
    }

    private void mGrabarBd() {
    }

    public void mNuevo() {
        if (this.xmod == 0) {
            this.xidusuario = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido();
            this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
        } else {
            if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                this.xidusuario = Long.valueOf(this.xjifcho.xjppersona.getIdPersona());
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
        this.xmodelolesion = new DefaultTableModel(new Object[0], new String[]{"Id", "Lesión", "Realizada", "Observación", "Estado"}) { // from class: Historia.JPAAntecentesOcupacionalesNuevo.41
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
        this.xmodelopafectada = new DefaultTableModel(new Object[0], new String[]{"Id", "Parte", "Afectada?", "Observación", "Estado"}) { // from class: Historia.JPAAntecentesOcupacionalesNuevo.42
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
        mCrearTablaLesion();
        TableColumnModel cmodel = this.JTTipoLesion.getColumnModel();
        TextAreaRenderer textAreaRenderer = new TextAreaRenderer();
        cmodel.getColumn(1).setCellRenderer(textAreaRenderer);
        TextAreaEditor textEditor = new TextAreaEditor();
        cmodel.getColumn(1).setCellEditor(textEditor);
        this.listLesiones = this.tipoLesionService.listarLesionesEntidad();
        if (!this.listLesiones.isEmpty()) {
            for (int i = 0; i < this.listLesiones.size(); i++) {
                this.xmodelolesion.addRow(this.xdato);
                this.xmodelolesion.setValueAt(this.listLesiones.get(i).getId(), i, 0);
                this.xmodelolesion.setValueAt(this.listLesiones.get(i).getNbre(), i, 1);
                this.xmodelolesion.setValueAt(false, i, 2);
                this.xmodelolesion.setValueAt("", i, 3);
                this.xmodelolesion.setValueAt(this.listLesiones.get(i).getEstado(), i, 4);
            }
        }
    }

    private void mBuscarPAfectada() {
        mCrearTablaPAfectada();
        this.listParteAfectada = this.parteAfectadaService.listarParteAfectada();
        if (!this.listParteAfectada.isEmpty()) {
            for (int i = 0; i < this.listParteAfectada.size(); i++) {
                this.xmodelopafectada.addRow(this.xdato);
                this.xmodelopafectada.setValueAt(this.listParteAfectada.get(i).getId(), i, 0);
                this.xmodelopafectada.setValueAt(this.listParteAfectada.get(i).getNbre(), i, 1);
                this.xmodelopafectada.setValueAt(false, i, 2);
                this.xmodelopafectada.setValueAt("", i, 3);
                this.xmodelopafectada.setValueAt(this.listParteAfectada.get(i).getEstado(), i, 4);
            }
        }
    }

    private void mBuscarDatosAccidenteBd() {
        if (this.JTPHistorialA.getSelectedRow() != -1) {
            this.JLBId.setText(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 0).toString());
            this.JTFFAEmpresa.setText(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 1).toString());
            this.JTFFAFecha.setText(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 2).toString());
            this.JTPACausa.setText(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 3).toString());
            this.JSPADiasI.setValue(Integer.valueOf(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 4).toString()));
            this.JTPASecuelas.setText(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 5).toString());
            this.JTPAObservacionAT.setText(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 6).toString());
            this.JTFFEEmpresaArlAcciente.setText(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 7).toString());
            this.JCHEstado.setSelected(Boolean.valueOf(this.xmodeloa.getValueAt(this.JTPHistorialA.getSelectedRow(), 8).toString()).booleanValue());
            estado();
            mCrearTablaLesion();
            this.listAccidenteLaboralEntity.get(this.JTPHistorialA.getSelectedRow()).getHAccidenteLesionEntities().forEach(e -> {
                this.xmodelolesion.addRow(this.xdato);
                this.xmodelolesion.setValueAt(e.getId_AccidenteTra(), this.JTTipoLesion.getRowCount() - 1, 0);
                this.xmodelolesion.setValueAt(e.getIdTipoLesion().getNbre(), this.JTTipoLesion.getRowCount() - 1, 1);
                this.xmodelolesion.setValueAt(true, this.JTTipoLesion.getRowCount() - 1, 2);
                this.xmodelolesion.setValueAt(e.getObservacion(), this.JTTipoLesion.getRowCount() - 1, 3);
            });
            mCrearTablaPAfectada();
            this.listAccidenteLaboralEntity.get(this.JTPHistorialA.getSelectedRow()).getHAccidentePaAfectadaEntities().forEach(i -> {
                this.xmodelopafectada.addRow(this.xdato);
                this.xmodelopafectada.setValueAt(i.getId_AccidenteTraParteAfectada(), this.JTParteAfectada.getRowCount() - 1, 0);
                this.xmodelopafectada.setValueAt(i.getId_PAfectada().getNbre(), this.JTParteAfectada.getRowCount() - 1, 1);
                this.xmodelopafectada.setValueAt(true, this.JTParteAfectada.getRowCount() - 1, 2);
                this.xmodelopafectada.setValueAt(i.getObservacion(), this.JTParteAfectada.getRowCount() - 1, 3);
            });
        }
    }
}
