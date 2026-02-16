package Historia;

import Acceso.Principal;
import Odontologia.JIFHistoriaOdontologica;
import PyP.clasePyP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.jpa.entities.GPersona;
import com.genoma.plus.jpa.entities.GUsuario;
import com.genoma.plus.jpa.entities.HAntecedenteginecologico;
import com.genoma.plus.jpa.entities.HTipometplanifica;
import com.genoma.plus.jpa.service.IHAntecedenteginecologicoService;
import com.genoma.plus.jpa.service.IHTipometplanificaService;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecedenteGineco_Nuevo.class */
public class JPAAntecedenteGineco_Nuevo extends JPanel {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private String sql;
    private String xidatencion;
    public String xGemelar;
    public String xidpersona;
    public String xidcitologia;
    private ResultSet rs;
    private int enfMama;
    private int xtipo;
    private clasePyP clasepyp;
    private clasesHistoriaCE xclasef;
    private String[] lisMetodo;
    private boolean nParto;
    public long xidusuario;
    private boolean xencontro;
    private boolean xformacarga;
    private JIFHistoriaOdontologica xjifcho;
    private IHAntecedenteginecologicoService antecedentesGinecologico;
    private final IHTipometplanificaService hTipometplanificaService;
    private HAntecedenteginecologico antecedentesDTO;
    private GUsuario gUsuario;
    List<HTipometplanifica> hTipometplanificas;
    private ButtonGroup JBGPlanifica;
    private ButtonGroup JBGResultadoCitol;
    private ButtonGroup JBGResultadoMamas;
    public JButton JBTGrabarA;
    private JCheckBox JCHEclampsia;
    private JCheckBox JCHEmbarazada;
    private JCheckBox JCHEmbarazada1;
    private JCheckBox JCHMolas;
    private JCheckBox JCHOligohidramnios;
    private JCheckBox JCHPolihidramnios;
    private JCheckBox JCHPreeclampsia;
    private JCheckBox JCHRealizado;
    private JCheckBox JCHRupturaMenbrana;
    private JCheckBox JCHTratamientoInfertilidad;
    private JComboBox JCUnidadTiempo;
    private JPanel JPIGinecologicos;
    private JPanel JPIObstetricos;
    private JScrollPane JSPDRMamas;
    private JTextArea JTAObservacion;
    private JTextField JTFCiclo;
    private JTextField JTFEts;
    private JTextField JTFFechaPParto;
    private JTextField JTFFechaUAborto;
    private JTextField JTFFechaUBiopsia;
    private JTextField JTFFechaUCitologia;
    private JTextField JTFFechaUConizacionCU;
    private JTextField JTFFechaUCuelloU;
    private JTextField JTFFechaUEcografia;
    private JTextField JTFFechaUHisterectomia;
    private JTextField JTFFechaULegrado;
    private JTextField JTFFechaUMestruacion;
    private JTextField JTFFechaUParto;
    private JTextField JTFFechaURadioTerapia;
    public JTextField JTFNRegistro;
    private JTextField JTFSemanaG;
    private JTabbedPane JTPAGinecoObstetricos;
    private JCheckBox btnEnfMama;
    public JDateChooser cboFechaPParto;
    private JComboBox cboMetodo;
    public JDateChooser cboUltimaAborto;
    public JDateChooser cboUltimaCitologia;
    public JDateChooser cboUltimaLegrado;
    public JDateChooser cboUltimaMestruacion;
    private ButtonGroup grpoPlanifica;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    public JDateChooser txtBiopsia;
    public JDateChooser txtCauterizacion;
    public JDateChooser txtConizacion;
    private JSpinner txtEdadRelaciones;
    public JDateChooser txtHisterectomia;
    private JTextField txtMenarquia;
    private JSpinner txtNoAbortos;
    private JSpinner txtNoCesareas;
    private JSpinner txtNoEmbarazos;
    private JSpinner txtNoEptopicos;
    private JSpinner txtNoMuertos;
    private JSpinner txtNoPartos;
    private JSpinner txtNoVivos;
    public JDateChooser txtRadioterapia;
    private JTextPane txtResultadoMamas;
    private JSpinner txtTiempoPlanifica;
    public JDateChooser txtUltimaEco;
    public JDateChooser txtUltimoParto;

    public JPAAntecedenteGineco_Nuevo(clasePyP clase, int xtipo, boolean xcarga) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xidatencion = "0";
        this.xGemelar = "-1";
        this.xidpersona = "0";
        this.xidcitologia = "0";
        this.enfMama = 0;
        this.xencontro = false;
        this.xformacarga = false;
        this.antecedentesGinecologico = (IHAntecedenteginecologicoService) Principal.contexto.getBean(IHAntecedenteginecologicoService.class);
        this.hTipometplanificaService = (IHTipometplanificaService) Principal.contexto.getBean(IHTipometplanificaService.class);
        initComponents();
        this.xtipo = xtipo;
        this.xformacarga = xcarga;
        this.clasepyp = clase;
        mNuevo();
    }

    public JPAAntecedenteGineco_Nuevo(clasesHistoriaCE xclasef, int xtipo) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xidatencion = "0";
        this.xGemelar = "-1";
        this.xidpersona = "0";
        this.xidcitologia = "0";
        this.enfMama = 0;
        this.xencontro = false;
        this.xformacarga = false;
        this.antecedentesGinecologico = (IHAntecedenteginecologicoService) Principal.contexto.getBean(IHAntecedenteginecologicoService.class);
        this.hTipometplanificaService = (IHTipometplanificaService) Principal.contexto.getBean(IHTipometplanificaService.class);
        initComponents();
        this.xtipo = xtipo;
        this.xclasef = xclasef;
        mNuevo();
    }

    public JPAAntecedenteGineco_Nuevo(JIFHistoriaOdontologica xjifcho, int xtipo) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xidatencion = "0";
        this.xGemelar = "-1";
        this.xidpersona = "0";
        this.xidcitologia = "0";
        this.enfMama = 0;
        this.xencontro = false;
        this.xformacarga = false;
        this.antecedentesGinecologico = (IHAntecedenteginecologicoService) Principal.contexto.getBean(IHAntecedenteginecologicoService.class);
        this.hTipometplanificaService = (IHTipometplanificaService) Principal.contexto.getBean(IHTipometplanificaService.class);
        initComponents();
        this.xtipo = xtipo;
        this.xjifcho = xjifcho;
        mNuevo();
    }

    private void cargarAntecedentes() {
        this.JTFNRegistro.setText(this.antecedentesDTO.getId().toString());
        this.txtMenarquia.setText(this.antecedentesDTO.getMenarquia());
        this.JTFFechaUEcografia.setText(this.antecedentesDTO.getFuem());
        this.btnEnfMama.setSelected(this.antecedentesDTO.getEnfMama().booleanValue());
        this.txtResultadoMamas.setText(this.antecedentesDTO.getDescMama());
        this.txtEdadRelaciones.setValue(this.antecedentesDTO.getEdadInicioRel());
        this.txtTiempoPlanifica.setValue(this.antecedentesDTO.getTiempoEnPlanifica());
        this.JCUnidadTiempo.setSelectedItem(this.antecedentesDTO.getUnidadT());
        this.cboMetodo.setSelectedItem(this.antecedentesDTO.getIdMetPlanifica());
        this.JTFCiclo.setText(this.antecedentesDTO.getCiclos());
        this.JTFFechaUCitologia.setText(this.antecedentesDTO.getFuc());
        this.JTFEts.setText(this.antecedentesDTO.getInfeccionesTrasmisionSexual());
        this.JTAObservacion.setText(this.antecedentesDTO.getObservacion());
        this.JTFFechaUCuelloU.setText(this.antecedentesDTO.getCauterizacionCuello());
        this.JTFFechaURadioTerapia.setText(this.antecedentesDTO.getRadioterapiaUtero());
        this.JTFFechaUHisterectomia.setText(this.antecedentesDTO.getHisterectomia());
        this.JTFFechaUConizacionCU.setText(this.antecedentesDTO.getConizacionCuello());
        this.JTFFechaUBiopsia.setText(this.antecedentesDTO.getBiopsia());
        this.txtNoEmbarazos.setValue(this.antecedentesDTO.getNoG());
        this.txtNoAbortos.setValue(this.antecedentesDTO.getNoA());
        this.txtNoPartos.setValue(this.antecedentesDTO.getNoP());
        this.txtNoCesareas.setValue(this.antecedentesDTO.getNoC());
        this.txtNoEptopicos.setValue(this.antecedentesDTO.getNoE());
        this.txtNoMuertos.setValue(this.antecedentesDTO.getNoM());
        this.txtNoVivos.setValue(this.antecedentesDTO.getNoV());
        this.JTFFechaUParto.setText(this.antecedentesDTO.getUltimoParto());
        this.JTFFechaUAborto.setText(this.antecedentesDTO.getUltimoAborto());
        this.JTFFechaUMestruacion.setText(this.antecedentesDTO.getFUMestruacion());
        this.JTFFechaULegrado.setText(this.antecedentesDTO.getLegrado());
        this.JTFFechaPParto.setText(this.antecedentesDTO.getFPParto());
        this.JTFSemanaG.setText(this.antecedentesDTO.getSemanaG());
        this.JCHEmbarazada1.setSelected(this.antecedentesDTO.getGemelar().booleanValue());
        this.JCHMolas.setSelected(this.antecedentesDTO.getMolas().booleanValue());
        this.JCHPolihidramnios.setSelected(this.antecedentesDTO.getPolihidramnios().booleanValue());
        this.JCHOligohidramnios.setSelected(this.antecedentesDTO.getOligohidramnios().booleanValue());
        this.JCHPreeclampsia.setSelected(this.antecedentesDTO.getPreeclampsia().booleanValue());
        this.JCHEclampsia.setSelected(this.antecedentesDTO.getEclampsia().booleanValue());
        this.JCHRupturaMenbrana.setSelected(this.antecedentesDTO.getRupturaPrematuraMembranas().booleanValue());
    }

    public void mGrabar() {
        if (this.JTFNRegistro.getText().isEmpty()) {
            mGrabarAntecedentes();
        } else {
            mGrabarAntecedentes();
        }
    }

    private void mGrabarAntecedentes() {
        if (this.antecedentesDTO == null) {
            this.antecedentesDTO = new HAntecedenteginecologico();
        }
        this.antecedentesDTO.setGUsuario(this.gUsuario);
        this.antecedentesDTO.setIdAtencion(Long.valueOf(this.xidatencion));
        this.antecedentesDTO.setIdCitologia(Integer.valueOf(this.xidcitologia));
        this.antecedentesDTO.setFUMestruacion(this.JTFFechaUMestruacion.getText());
        this.antecedentesDTO.setFuc(this.JTFFechaUCitologia.getText());
        this.antecedentesDTO.setFUMama(this.JTFFechaUEcografia.getText());
        this.antecedentesDTO.setFuem(this.JTFFechaUEcografia.getText());
        this.antecedentesDTO.setEnfMama(Boolean.valueOf(this.btnEnfMama.isSelected()));
        this.antecedentesDTO.setDescMama(this.txtResultadoMamas.getText());
        this.antecedentesDTO.setIdMetPlanifica(this.hTipometplanificas.get(this.cboMetodo.getSelectedIndex()));
        this.antecedentesDTO.setTiempoEnPlanifica(Integer.valueOf(this.txtTiempoPlanifica.getValue().toString()));
        this.antecedentesDTO.setNoG(Integer.valueOf(this.txtNoEmbarazos.getValue().toString()));
        this.antecedentesDTO.setNoP(Integer.valueOf(this.txtNoPartos.getValue().toString()));
        this.antecedentesDTO.setNoC(Integer.valueOf(this.txtNoCesareas.getValue().toString()));
        this.antecedentesDTO.setNoA(Integer.valueOf(this.txtNoAbortos.getValue().toString()));
        this.antecedentesDTO.setUltimoParto(this.JTFFechaUParto.getText());
        this.antecedentesDTO.setUltimoAborto(this.JTFFechaUAborto.getText());
        this.antecedentesDTO.setNoE(Integer.valueOf(this.txtNoEptopicos.getValue().toString()));
        this.antecedentesDTO.setNoM(Integer.valueOf(this.txtNoMuertos.getValue().toString()));
        this.antecedentesDTO.setNoV(Integer.valueOf(this.txtNoVivos.getValue().toString()));
        this.antecedentesDTO.setMenarquia(this.txtMenarquia.getText());
        this.antecedentesDTO.setEdadInicioRel(Integer.valueOf(this.txtEdadRelaciones.getValue().toString()));
        this.antecedentesDTO.setCauterizacionCuello(this.JTFFechaUCuelloU.getText());
        this.antecedentesDTO.setRadioterapiaUtero(this.JTFFechaURadioTerapia.getText());
        this.antecedentesDTO.setHisterectomia(this.JTFFechaUHisterectomia.getText());
        this.antecedentesDTO.setConizacionCuello(this.JTFFechaUConizacionCU.getText());
        this.antecedentesDTO.setBiopsia(this.JTFFechaUBiopsia.getText());
        this.antecedentesDTO.setCiclos(this.JTFCiclo.getText());
        this.antecedentesDTO.setFPParto(this.JTFFechaPParto.getText());
        this.antecedentesDTO.setSemanaG(this.JTFSemanaG.getText());
        this.antecedentesDTO.setGemelar(Boolean.valueOf(this.xGemelar.isEmpty()));
        this.antecedentesDTO.setMolas(Boolean.valueOf(this.JCHMolas.isSelected()));
        this.antecedentesDTO.setPolihidramnios(Boolean.valueOf(this.JCHPolihidramnios.isSelected()));
        this.antecedentesDTO.setOligohidramnios(Boolean.valueOf(this.JCHOligohidramnios.isSelected()));
        this.antecedentesDTO.setPreeclampsia(Boolean.valueOf(this.JCHPreeclampsia.isSelected()));
        this.antecedentesDTO.setRupturaPrematuraMembranas(Boolean.valueOf(this.JCHRupturaMenbrana.isSelected()));
        this.antecedentesDTO.setEclampsia(Boolean.valueOf(this.JCHEclampsia.isSelected()));
        this.antecedentesDTO.setLegrado(this.JTFFechaULegrado.getText());
        this.antecedentesDTO.setFecha(new Date(this.metodos.formatoAMDH24.format(this.metodos.getFechaActual())));
        this.antecedentesDTO.setUsuarioS(Principal.usuarioSistemaDTO.getLogin());
        this.antecedentesDTO.setObservacion(this.JTAObservacion.getText());
        this.antecedentesDTO.setUnidadT(this.JCUnidadTiempo.getSelectedItem().toString().trim());
        this.antecedentesDTO.setInfeccionesTrasmisionSexual(this.JTFEts.getText());
        this.antecedentesDTO = this.antecedentesGinecologico.grabar(this.antecedentesDTO);
        this.JTFNRegistro.setText(this.antecedentesDTO.getId().toString());
        if (this.xtipo == 0) {
            this.clasepyp.frmToma.xllenoantecedentes = true;
        }
        if (this.xtipo == 0) {
            this.clasepyp.frmToma.xllenoantecedentes = true;
        }
    }

    private void mInicilizarDatos() {
        this.gUsuario = new GUsuario();
        if (this.xtipo != 0) {
            if (this.xtipo == 1) {
                GPersona persona = new GPersona();
                clasesHistoriaCE claseshistoriace = this.xclasef;
                persona.setId(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                this.gUsuario.setGPersona(persona);
                clasesHistoriaCE claseshistoriace2 = this.xclasef;
                this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                return;
            }
            if (this.xtipo == 2) {
                if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                    GPersona persona2 = new GPersona();
                    persona2.setId(Long.valueOf(this.xjifcho.xjppersona.getIdPersona()));
                    this.gUsuario.setGPersona(persona2);
                }
                this.xidatencion = "0";
            }
        }
    }

    public void mNuevo() {
        mInicilizarDatos();
        this.antecedentesDTO = new HAntecedenteginecologico();
        System.out.println("" + this.xidatencion);
        this.antecedentesDTO = this.antecedentesGinecologico.buscarPorIdAtencion(Long.valueOf(this.xidatencion));
        this.JTFNRegistro.setText("");
        this.hTipometplanificas = new ArrayList();
        this.hTipometplanificas = this.hTipometplanificaService.listaTipoMetodosPorEstado(false);
        if (!this.hTipometplanificas.isEmpty()) {
            this.hTipometplanificas.forEach(item -> {
                this.cboMetodo.addItem(item.getNbre());
            });
        }
        this.cboMetodo.setSelectedItem("NO PLANIFICA");
        if (this.antecedentesDTO != null && this.antecedentesDTO.getId().longValue() > 0) {
            cargarAntecedentes();
        }
    }

    public String getXidpersona() {
        return this.xidpersona;
    }

    public void setXidpersona(String xidpersona) {
        this.xidpersona = xidpersona;
    }

    public String getXidcitologia() {
        return this.xidcitologia;
    }

    public void setXidcitologia(String xidcitologia) {
        this.xidcitologia = xidcitologia;
    }

    private void initComponents() {
        this.JBGResultadoCitol = new ButtonGroup();
        this.JBGResultadoMamas = new ButtonGroup();
        this.JBGPlanifica = new ButtonGroup();
        this.grpoPlanifica = new ButtonGroup();
        this.JTPAGinecoObstetricos = new JTabbedPane();
        this.JPIGinecologicos = new JPanel();
        this.txtUltimaEco = new JDateChooser();
        this.btnEnfMama = new JCheckBox();
        this.JSPDRMamas = new JScrollPane();
        this.txtResultadoMamas = new JTextPane();
        this.JTFFechaUEcografia = new JTextField();
        this.txtMenarquia = new JTextField();
        this.txtEdadRelaciones = new JSpinner();
        this.txtTiempoPlanifica = new JSpinner();
        this.cboMetodo = new JComboBox();
        this.jPanel3 = new JPanel();
        this.txtCauterizacion = new JDateChooser();
        this.txtRadioterapia = new JDateChooser();
        this.txtHisterectomia = new JDateChooser();
        this.txtConizacion = new JDateChooser();
        this.txtBiopsia = new JDateChooser();
        this.JTFFechaUCuelloU = new JTextField();
        this.JTFFechaURadioTerapia = new JTextField();
        this.JTFFechaUHisterectomia = new JTextField();
        this.JTFFechaUConizacionCU = new JTextField();
        this.JTFFechaUBiopsia = new JTextField();
        this.JTFCiclo = new JTextField();
        this.JTFFechaUCitologia = new JTextField();
        this.cboUltimaCitologia = new JDateChooser();
        this.JCHRealizado = new JCheckBox();
        this.jScrollPane1 = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JCUnidadTiempo = new JComboBox();
        this.JCHTratamientoInfertilidad = new JCheckBox();
        this.JTFEts = new JTextField();
        this.JPIObstetricos = new JPanel();
        this.txtNoEmbarazos = new JSpinner();
        this.txtNoEptopicos = new JSpinner();
        this.txtNoPartos = new JSpinner();
        this.txtNoCesareas = new JSpinner();
        this.txtNoAbortos = new JSpinner();
        this.txtNoMuertos = new JSpinner();
        this.txtNoVivos = new JSpinner();
        this.JTFFechaUParto = new JTextField();
        this.txtUltimoParto = new JDateChooser();
        this.JTFFechaUAborto = new JTextField();
        this.cboUltimaAborto = new JDateChooser();
        this.JTFFechaUMestruacion = new JTextField();
        this.cboUltimaMestruacion = new JDateChooser();
        this.JTFFechaPParto = new JTextField();
        this.cboFechaPParto = new JDateChooser();
        this.JTFSemanaG = new JTextField();
        this.JTFFechaULegrado = new JTextField();
        this.cboUltimaLegrado = new JDateChooser();
        this.JCHEmbarazada = new JCheckBox();
        this.JCHEmbarazada1 = new JCheckBox();
        this.JCHMolas = new JCheckBox();
        this.JCHPolihidramnios = new JCheckBox();
        this.JCHOligohidramnios = new JCheckBox();
        this.JCHEclampsia = new JCheckBox();
        this.JCHPreeclampsia = new JCheckBox();
        this.JCHRupturaMenbrana = new JCheckBox();
        this.JTFNRegistro = new JTextField();
        this.JBTGrabarA = new JButton();
        setName("AntecedenteGineco");
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.1
            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.formAncestorRemoved(evt);
            }
        });
        this.JTPAGinecoObstetricos.setForeground(new Color(0, 103, 0));
        this.JTPAGinecoObstetricos.setFont(new Font("Arial", 1, 14));
        this.txtUltimaEco.setDateFormatString("dd/MM/yyyy");
        this.txtUltimaEco.setFont(new Font("Tahoma", 1, 12));
        this.txtUltimaEco.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimaEco.setName("cboMenarquia");
        this.txtUltimaEco.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.txtUltimaEcoPropertyChange(evt);
            }
        });
        this.btnEnfMama.setFont(new Font("Arial", 1, 12));
        this.btnEnfMama.setForeground(Color.blue);
        this.btnEnfMama.setText("Enf. Mama?");
        this.btnEnfMama.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.3
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.btnEnfMamaActionPerformed(evt);
            }
        });
        this.JSPDRMamas.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción de Enfermedad", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtResultadoMamas.setFont(new Font("Arial", 1, 12));
        this.txtResultadoMamas.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecedenteGineco_Nuevo.4
            public void keyPressed(KeyEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.txtResultadoMamasKeyPressed(evt);
            }
        });
        this.JSPDRMamas.setViewportView(this.txtResultadoMamas);
        this.JTFFechaUEcografia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUEcografia.setHorizontalAlignment(4);
        this.JTFFechaUEcografia.setBorder(BorderFactory.createTitledBorder((Border) null, "FUEcografia Mama", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtMenarquia.setFont(new Font("Arial", 1, 12));
        this.txtMenarquia.setHorizontalAlignment(4);
        this.txtMenarquia.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad Menarquia (Años)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtEdadRelaciones.setFont(new Font("Arial", 1, 12));
        this.txtEdadRelaciones.setBorder(BorderFactory.createTitledBorder((Border) null, "Edad IRelaciones (Años)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtTiempoPlanifica.setFont(new Font("Arial", 1, 12));
        this.txtTiempoPlanifica.setBorder(BorderFactory.createTitledBorder((Border) null, "T.Planificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboMetodo.setFont(new Font("Arial", 1, 12));
        this.cboMetodo.setBorder(BorderFactory.createTitledBorder((Border) null, "Método de Planificación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jPanel3.setBorder(BorderFactory.createTitledBorder((Border) null, "Fechas de Realización de Procedimientos Quirúrgicos", 0, 0, new Font("Arial", 1, 14), new Color(0, 102, 0)));
        this.txtCauterizacion.setDateFormatString("dd/MM/yyyy");
        this.txtCauterizacion.setFont(new Font("Tahoma", 1, 12));
        this.txtCauterizacion.setMaxSelectableDate(new Date(253370786463000L));
        this.txtCauterizacion.setName("cboMenarquia");
        this.txtCauterizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.txtCauterizacionPropertyChange(evt);
            }
        });
        this.txtRadioterapia.setDateFormatString("dd/MM/yyyy");
        this.txtRadioterapia.setFont(new Font("Tahoma", 1, 12));
        this.txtRadioterapia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtRadioterapia.setName("cboMenarquia");
        this.txtRadioterapia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.txtRadioterapiaPropertyChange(evt);
            }
        });
        this.txtHisterectomia.setDateFormatString("dd/MM/yyyy");
        this.txtHisterectomia.setFont(new Font("Tahoma", 1, 12));
        this.txtHisterectomia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtHisterectomia.setName("cboMenarquia");
        this.txtHisterectomia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.txtHisterectomiaPropertyChange(evt);
            }
        });
        this.txtConizacion.setDateFormatString("dd/MM/yyyy");
        this.txtConizacion.setFont(new Font("Tahoma", 1, 12));
        this.txtConizacion.setMaxSelectableDate(new Date(253370786463000L));
        this.txtConizacion.setName("cboMenarquia");
        this.txtConizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.txtConizacionPropertyChange(evt);
            }
        });
        this.txtBiopsia.setDateFormatString("dd/MM/yyyy");
        this.txtBiopsia.setFont(new Font("Tahoma", 1, 12));
        this.txtBiopsia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtBiopsia.setName("cboMenarquia");
        this.txtBiopsia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.txtBiopsiaPropertyChange(evt);
            }
        });
        this.JTFFechaUCuelloU.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUCuelloU.setHorizontalAlignment(4);
        this.JTFFechaUCuelloU.setBorder(BorderFactory.createTitledBorder((Border) null, "Cauterización CU", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaURadioTerapia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaURadioTerapia.setHorizontalAlignment(4);
        this.JTFFechaURadioTerapia.setBorder(BorderFactory.createTitledBorder((Border) null, "Radioterapia Utero", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUHisterectomia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUHisterectomia.setHorizontalAlignment(4);
        this.JTFFechaUHisterectomia.setBorder(BorderFactory.createTitledBorder((Border) null, "Histerectomia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUConizacionCU.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUConizacionCU.setHorizontalAlignment(4);
        this.JTFFechaUConizacionCU.setBorder(BorderFactory.createTitledBorder((Border) null, "Conización CU", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUBiopsia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUBiopsia.setHorizontalAlignment(4);
        this.JTFFechaUBiopsia.setBorder(BorderFactory.createTitledBorder((Border) null, "Última Biopsia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFechaUCuelloU, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCauterizacion, -2, 22, -2).addGap(18, 18, 18).addComponent(this.JTFFechaURadioTerapia, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtRadioterapia, -2, 21, -2).addGap(27, 27, 27).addComponent(this.JTFFechaUHisterectomia, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtHisterectomia, -2, 20, -2).addGap(26, 26, 26).addComponent(this.JTFFechaUConizacionCU, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtConizacion, -2, 20, -2).addGap(18, 18, 18).addComponent(this.JTFFechaUBiopsia, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtBiopsia, -2, 20, -2).addContainerGap(15, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtCauterizacion, -1, -1, 32767).addComponent(this.JTFFechaUCuelloU).addComponent(this.txtRadioterapia, -1, -1, 32767).addComponent(this.JTFFechaURadioTerapia).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFechaUHisterectomia).addComponent(this.JTFFechaUConizacionCU).addComponent(this.JTFFechaUBiopsia).addComponent(this.txtHisterectomia, -1, -1, 32767).addComponent(this.txtConizacion, -1, -1, 32767).addComponent(this.txtBiopsia, -1, -1, 32767)));
        this.JTFCiclo.setFont(new Font("Arial", 1, 12));
        this.JTFCiclo.setHorizontalAlignment(4);
        this.JTFCiclo.setBorder(BorderFactory.createTitledBorder((Border) null, "Ciclos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUCitologia.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUCitologia.setHorizontalAlignment(4);
        this.JTFFechaUCitologia.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Citologia", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaCitologia.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaCitologia.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaCitologia.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaCitologia.setName("cboMenarquia");
        this.cboUltimaCitologia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.10
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.cboUltimaCitologiaPropertyChange(evt);
            }
        });
        this.JCHRealizado.setFont(new Font("Arial", 1, 12));
        this.JCHRealizado.setText("Sin Realizar");
        this.JCHRealizado.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.11
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHRealizadoActionPerformed(evt);
            }
        });
        this.JTAObservacion.setColumns(20);
        this.JTAObservacion.setFont(new Font("Arial", 1, 12));
        this.JTAObservacion.setRows(5);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observacion", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.jScrollPane1.setViewportView(this.JTAObservacion);
        this.JCUnidadTiempo.setFont(new Font("Arial", 1, 12));
        this.JCUnidadTiempo.setModel(new DefaultComboBoxModel(new String[]{"Años", "Meses", "Dias"}));
        this.JCUnidadTiempo.setBorder(BorderFactory.createTitledBorder((Border) null, "Unidad T", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCUnidadTiempo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.12
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCUnidadTiempoActionPerformed(evt);
            }
        });
        this.JCHTratamientoInfertilidad.setFont(new Font("Arial", 1, 12));
        this.JCHTratamientoInfertilidad.setText("Tratamiento Infertilidad");
        this.JCHTratamientoInfertilidad.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.13
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHTratamientoInfertilidadActionPerformed(evt);
            }
        });
        this.JTFEts.setFont(new Font("Arial", 1, 12));
        this.JTFEts.setHorizontalAlignment(4);
        this.JTFEts.setBorder(BorderFactory.createTitledBorder((Border) null, "Enf. Tranmisión Sexual", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIGinecologicosLayout = new GroupLayout(this.JPIGinecologicos);
        this.JPIGinecologicos.setLayout(JPIGinecologicosLayout);
        JPIGinecologicosLayout.setHorizontalGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jScrollPane1).addComponent(this.jPanel3, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, JPIGinecologicosLayout.createSequentialGroup().addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFCiclo).addComponent(this.txtEdadRelaciones, GroupLayout.Alignment.LEADING).addComponent(this.txtMenarquia, GroupLayout.Alignment.LEADING, -1, 193, 32767)).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaCitologia, -2, 22, -2)).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JTFFechaUEcografia, -2, 161, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtUltimaEco, -2, 20, -2)).addGroup(GroupLayout.Alignment.TRAILING, JPIGinecologicosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.txtTiempoPlanifica)))).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.JTFFechaUCitologia, -2, 158, -2))).addGap(18, 18, 18).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHRealizado).addComponent(this.btnEnfMama, -2, 103, -2).addComponent(this.JCUnidadTiempo, -2, -1, -2)).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.cboMetodo, -2, 311, -2)).addGroup(JPIGinecologicosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JSPDRMamas, -2, 311, -2)))).addGroup(JPIGinecologicosLayout.createSequentialGroup().addComponent(this.JCHTratamientoInfertilidad).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEts, -2, 255, -2))))).addContainerGap(-1, 32767)));
        JPIGinecologicosLayout.setVerticalGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addComponent(this.JSPDRMamas, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addComponent(this.cboMetodo, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFEts, -2, 59, -2)).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JTFFechaUEcografia, GroupLayout.Alignment.LEADING, -1, 47, 32767).addComponent(this.txtMenarquia, GroupLayout.Alignment.LEADING)).addComponent(this.txtUltimaEco, -2, 47, -2))).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.btnEnfMama))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtTiempoPlanifica, -2, 51, -2).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtEdadRelaciones, -2, 50, -2).addComponent(this.JCUnidadTiempo, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JTFCiclo, GroupLayout.Alignment.LEADING, -2, 59, -2).addComponent(this.cboUltimaCitologia, GroupLayout.Alignment.LEADING, -2, 59, -2).addComponent(this.JTFFechaUCitologia, GroupLayout.Alignment.LEADING, -2, 59, -2).addGroup(JPIGinecologicosLayout.createSequentialGroup().addComponent(this.JCHRealizado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCHTratamientoInfertilidad))))).addGap(11, 11, 11).addComponent(this.jScrollPane1, -2, 81, -2).addGap(5, 5, 5).addComponent(this.jPanel3, -2, -1, -2)));
        this.JTPAGinecoObstetricos.addTab("GINECOLÓGICOS", this.JPIGinecologicos);
        this.txtNoEmbarazos.setFont(new Font("Arial", 1, 12));
        this.txtNoEmbarazos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoEmbarazos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Embarazo", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoEmbarazos.setMinimumSize(new Dimension(44, 60));
        this.txtNoEmbarazos.setPreferredSize(new Dimension(44, 60));
        this.txtNoEptopicos.setFont(new Font("Arial", 1, 12));
        this.txtNoEptopicos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoEptopicos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Ectopicos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoPartos.setFont(new Font("Arial", 1, 12));
        this.txtNoPartos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoPartos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Partos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoCesareas.setFont(new Font("Arial", 1, 12));
        this.txtNoCesareas.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoCesareas.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Cesareas", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoAbortos.setFont(new Font("Arial", 1, 12));
        this.txtNoAbortos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoAbortos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Abortos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoMuertos.setFont(new Font("Arial", 1, 12));
        this.txtNoMuertos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoMuertos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nac Muertos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtNoVivos.setFont(new Font("Arial", 1, 12));
        this.txtNoVivos.setModel(new SpinnerNumberModel(0, 0, (Comparable) null, 1));
        this.txtNoVivos.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Nac Vivos", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaUParto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUParto.setHorizontalAlignment(4);
        this.JTFFechaUParto.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Parto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.txtUltimoParto.setDateFormatString("dd/MM/yyyy");
        this.txtUltimoParto.setFont(new Font("Tahoma", 1, 12));
        this.txtUltimoParto.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimoParto.setName("cboMenarquia");
        this.txtUltimoParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.txtUltimoPartoPropertyChange(evt);
            }
        });
        this.JTFFechaUAborto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUAborto.setHorizontalAlignment(4);
        this.JTFFechaUAborto.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Aborto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaAborto.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaAborto.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaAborto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaAborto.setName("cboMenarquia");
        this.cboUltimaAborto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.cboUltimaAbortoPropertyChange(evt);
            }
        });
        this.JTFFechaUMestruacion.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUMestruacion.setHorizontalAlignment(4);
        this.JTFFechaUMestruacion.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Mestruación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaMestruacion.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaMestruacion.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaMestruacion.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaMestruacion.setName("cboMenarquia");
        this.cboUltimaMestruacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.cboUltimaMestruacionPropertyChange(evt);
            }
        });
        this.JTFFechaPParto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaPParto.setHorizontalAlignment(4);
        this.JTFFechaPParto.setBorder(BorderFactory.createTitledBorder((Border) null, "FPP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboFechaPParto.setDateFormatString("dd/MM/yyyy");
        this.cboFechaPParto.setFont(new Font("Tahoma", 1, 12));
        this.cboFechaPParto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboFechaPParto.setName("cboMenarquia");
        this.cboFechaPParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.cboFechaPPartoPropertyChange(evt);
            }
        });
        this.JTFSemanaG.setFont(new Font("Arial", 1, 12));
        this.JTFSemanaG.setHorizontalAlignment(4);
        this.JTFSemanaG.setBorder(BorderFactory.createTitledBorder((Border) null, "Semana Gestaciòn", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JTFFechaULegrado.setFont(new Font("Arial", 1, 12));
        this.JTFFechaULegrado.setHorizontalAlignment(4);
        this.JTFFechaULegrado.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Legrado", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaLegrado.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaLegrado.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaLegrado.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaLegrado.setName("cboMenarquia");
        this.cboUltimaLegrado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.18
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.cboUltimaLegradoPropertyChange(evt);
            }
        });
        this.JCHEmbarazada.setFont(new Font("Arial", 1, 12));
        this.JCHEmbarazada.setText("Actualmente esta embarazada?");
        this.JCHEmbarazada.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.19
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHEmbarazadaActionPerformed(evt);
            }
        });
        this.JCHEmbarazada1.setFont(new Font("Arial", 1, 12));
        this.JCHEmbarazada1.setText("Embarazo Gemelar?");
        this.JCHEmbarazada1.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.20
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHEmbarazada1ActionPerformed(evt);
            }
        });
        this.JCHMolas.setFont(new Font("Arial", 1, 12));
        this.JCHMolas.setText("Molas?");
        this.JCHMolas.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.21
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHMolasActionPerformed(evt);
            }
        });
        this.JCHPolihidramnios.setFont(new Font("Arial", 1, 12));
        this.JCHPolihidramnios.setText("Polihidramnios?");
        this.JCHPolihidramnios.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.22
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHPolihidramniosActionPerformed(evt);
            }
        });
        this.JCHOligohidramnios.setFont(new Font("Arial", 1, 12));
        this.JCHOligohidramnios.setText("Oligohidramnios?");
        this.JCHOligohidramnios.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.23
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHOligohidramniosActionPerformed(evt);
            }
        });
        this.JCHEclampsia.setFont(new Font("Arial", 1, 12));
        this.JCHEclampsia.setText("Eclampsia?");
        this.JCHEclampsia.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.24
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHEclampsiaActionPerformed(evt);
            }
        });
        this.JCHPreeclampsia.setFont(new Font("Arial", 1, 12));
        this.JCHPreeclampsia.setText("Preeclampsia?");
        this.JCHPreeclampsia.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.25
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHPreeclampsiaActionPerformed(evt);
            }
        });
        this.JCHRupturaMenbrana.setFont(new Font("Arial", 1, 12));
        this.JCHRupturaMenbrana.setText("Ruptura prematura de menbrana?");
        this.JCHRupturaMenbrana.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.26
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JCHRupturaMenbranaActionPerformed(evt);
            }
        });
        GroupLayout JPIObstetricosLayout = new GroupLayout(this.JPIObstetricos);
        this.JPIObstetricos.setLayout(JPIObstetricosLayout);
        JPIObstetricosLayout.setHorizontalGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addContainerGap().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIObstetricosLayout.createSequentialGroup().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaULegrado, -2, 107, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.cboUltimaLegrado, -2, 23, -2)).addComponent(this.txtNoEmbarazos, -1, -1, 32767).addComponent(this.txtNoMuertos)).addGap(17, 17, 17).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.txtNoAbortos, -2, 136, -2).addGap(18, 18, 18).addComponent(this.txtNoPartos)).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addComponent(this.txtNoVivos, -2, 135, -2).addGap(18, 18, 18).addComponent(this.JTFFechaUParto, -2, 120, -2)).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaPParto, -2, 134, -2).addGap(18, 18, 18).addComponent(this.JTFSemanaG, -2, 120, -2))).addGap(2, 2, 2).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.cboFechaPParto, -2, 20, -2).addComponent(this.txtUltimoParto, -2, 21, -2)))).addGap(24, 24, 24).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.txtNoCesareas, -2, 146, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.txtNoEptopicos, -2, 146, -2)).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaUAborto, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaAborto, -2, 23, -2).addGap(18, 18, 18).addComponent(this.JTFFechaUMestruacion, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaMestruacion, -2, 20, -2)))).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEmbarazada1).addComponent(this.JCHEmbarazada)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHPolihidramnios).addComponent(this.JCHMolas)).addGap(35, 35, 35).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHOligohidramnios).addComponent(this.JCHPreeclampsia)).addGap(35, 35, 35).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHRupturaMenbrana).addComponent(this.JCHEclampsia)))).addContainerGap(47, 32767)));
        JPIObstetricosLayout.setVerticalGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.txtNoEmbarazos, -2, 55, -2).addComponent(this.txtNoAbortos, -2, 56, -2).addComponent(this.txtNoPartos, -2, 56, -2).addComponent(this.txtNoCesareas, -2, 54, -2).addComponent(this.txtNoEptopicos, -2, 56, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaUMestruacion, -2, 56, -2).addComponent(this.txtUltimoParto, -2, 56, -2).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtNoVivos, -2, 54, -2).addComponent(this.txtNoMuertos, -2, 54, -2).addComponent(this.JTFFechaUParto, -2, 56, -2)).addComponent(this.JTFFechaUAborto, -2, 56, -2).addComponent(this.cboUltimaAborto, -2, 56, -2).addComponent(this.cboUltimaMestruacion, -2, 56, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaULegrado, -2, 56, -2).addComponent(this.cboUltimaLegrado, -2, 56, -2).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JTFFechaPParto, -2, 56, -2).addComponent(this.JTFSemanaG, -2, 56, -2)).addComponent(this.cboFechaPParto, -2, 56, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 3, -2).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHOligohidramnios).addComponent(this.JCHMolas)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHPolihidramnios).addComponent(this.JCHPreeclampsia))).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JCHEmbarazada).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHEmbarazada1)))).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addComponent(this.JCHEclampsia).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JCHRupturaMenbrana).addGap(3, 3, 3))).addContainerGap(44, 32767)));
        this.txtNoEmbarazos.getAccessibleContext().setAccessibleName("");
        this.txtNoEptopicos.getAccessibleContext().setAccessibleName("");
        this.txtNoPartos.getAccessibleContext().setAccessibleName("");
        this.txtNoCesareas.getAccessibleContext().setAccessibleName("");
        this.JTPAGinecoObstetricos.addTab("OBSTETRICOS", this.JPIObstetricos);
        this.JTFNRegistro.setFont(new Font("Arial", 1, 24));
        this.JTFNRegistro.setHorizontalAlignment(0);
        this.JTFNRegistro.setBorder(BorderFactory.createTitledBorder((Border) null, "N° Registro", 1, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGrabarA.setFont(new Font("Arial", 1, 14));
        this.JBTGrabarA.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Bueno.png")));
        this.JBTGrabarA.setText("GUARDAR");
        this.JBTGrabarA.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco_Nuevo.27
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco_Nuevo.this.JBTGrabarAActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTPAGinecoObstetricos, -2, 852, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabarA, -2, 731, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNRegistro))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JTPAGinecoObstetricos, -1, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFNRegistro).addComponent(this.JBTGrabarA, -1, -1, 32767)).addGap(5, 5, 5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void formAncestorRemoved(AncestorEvent evt) {
        mGrabar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtBiopsiaPropertyChange(PropertyChangeEvent evt) {
        if (this.txtBiopsia.getDate() != null) {
            this.JTFFechaUBiopsia.setText(this.metodos.formatoDMA.format(this.txtBiopsia.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtConizacionPropertyChange(PropertyChangeEvent evt) {
        if (this.txtConizacion.getDate() != null) {
            this.JTFFechaUConizacionCU.setText(this.metodos.formatoDMA.format(this.txtConizacion.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtHisterectomiaPropertyChange(PropertyChangeEvent evt) {
        if (this.txtHisterectomia.getDate() != null) {
            this.JTFFechaUHisterectomia.setText(this.metodos.formatoDMA.format(this.txtHisterectomia.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtRadioterapiaPropertyChange(PropertyChangeEvent evt) {
        if (this.txtRadioterapia.getDate() != null) {
            this.JTFFechaURadioTerapia.setText(this.metodos.formatoDMA.format(this.txtRadioterapia.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtCauterizacionPropertyChange(PropertyChangeEvent evt) {
        if (this.txtCauterizacion.getDate() != null) {
            this.JTFFechaUCuelloU.setText(this.metodos.formatoDMA.format(this.txtCauterizacion.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtResultadoMamasKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 9) {
            this.txtResultadoMamas.transferFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btnEnfMamaActionPerformed(ActionEvent evt) {
        if (this.btnEnfMama.isSelected()) {
            this.enfMama = 1;
        } else {
            this.enfMama = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUltimaEcoPropertyChange(PropertyChangeEvent evt) {
        if (this.txtUltimaEco.getDate() != null) {
            this.JTFFechaUEcografia.setText(this.metodos.formatoDMA.format(this.txtUltimaEco.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaCitologiaPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaCitologia.getDate() != null) {
            this.JTFFechaUCitologia.setText(this.metodos.formatoDMA.format(this.cboUltimaCitologia.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaMestruacionPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaMestruacion.getDate() != null) {
            this.JTFFechaUMestruacion.setText(this.metodos.formatoAMD.format(this.cboUltimaMestruacion.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaAbortoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaAborto.getDate() != null) {
            this.JTFFechaUAborto.setText(this.metodos.formatoDMA.format(this.cboUltimaAborto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void txtUltimoPartoPropertyChange(PropertyChangeEvent evt) {
        if (this.txtUltimoParto.getDate() != null) {
            this.JTFFechaUParto.setText(this.metodos.formatoDMA.format(this.txtUltimoParto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboFechaPPartoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboFechaPParto.getDate() != null) {
            this.JTFFechaPParto.setText(this.metodos.formatoDMA.format(this.cboFechaPParto.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cboUltimaLegradoPropertyChange(PropertyChangeEvent evt) {
        if (this.cboUltimaLegrado.getDate() != null) {
            this.JTFFechaULegrado.setText(this.metodos.formatoDMA.format(this.cboUltimaLegrado.getDate()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRealizadoActionPerformed(ActionEvent evt) {
        if (this.JCHRealizado.isSelected()) {
            this.JTFFechaUCitologia.setText("SIN REALIZAR");
            this.cboUltimaCitologia.setEnabled(false);
            this.JTFFechaUCitologia.setEditable(false);
        } else {
            this.JTFFechaUCitologia.setText("");
            this.cboUltimaCitologia.setEnabled(true);
            this.JTFFechaUCitologia.setEditable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmbarazadaActionPerformed(ActionEvent evt) {
        if (this.JCHEmbarazada.isSelected()) {
            this.JTFSemanaG.setText("" + this.metodos.mSemanaGestacion(this.JTFFechaUMestruacion.getText()));
            this.JTFFechaPParto.setText("" + getFPP(this.JTFFechaUMestruacion.getText()));
        } else {
            this.JTFSemanaG.setText("0");
            this.JTFFechaPParto.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEmbarazada1ActionPerformed(ActionEvent evt) {
        if (this.JCHEmbarazada1.isSelected()) {
            this.xGemelar = "1";
        } else {
            this.xGemelar = "0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCUnidadTiempoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGrabarAActionPerformed(ActionEvent evt) {
        if (Integer.valueOf(this.txtNoPartos.getValue().toString()).intValue() > 0 && (this.JTFFechaUParto.getText().isEmpty() || this.JTFFechaUParto.getText() == null)) {
            JOptionPane.showMessageDialog((Component) null, "Debe seleccionar la fecha del ultimo parto");
        } else {
            mGrabar();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHTratamientoInfertilidadActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHMolasActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPolihidramniosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHOligohidramniosActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHEclampsiaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHPreeclampsiaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JCHRupturaMenbranaActionPerformed(ActionEvent evt) {
    }

    private Date getFPP(String xFUM) {
        Date xValor = null;
        String sql = "SELECT DATE_SUB(ADDDATE(DATE_ADD(('" + xFUM + "'),INTERVAL 1 YEAR),7),INTERVAL 3 MONTH) AS FPP";
        ConsultasMySQL xctr = new ConsultasMySQL();
        ResultSet xrs = xctr.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                xValor = xrs.getDate("FPP");
            }
            xrs.close();
            xctr.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return xValor;
    }

    private void mStringToDate(JDateChooser xFecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            xFecha.setDate(formato.parse("01/01/1800"));
        } catch (ParseException e) {
        }
    }

    public boolean isXformacarga() {
        return this.xformacarga;
    }

    public void setXformacarga(boolean xformacarga) {
        this.xformacarga = xformacarga;
    }
}
