package Historia;

import Acceso.Principal;
import Odontologia.JIFHistoriaOdontologica;
import PyP.clasePyP;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
import java.util.Date;
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

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAAntecedenteGineco.class */
public class JPAAntecedenteGineco extends JPanel {
    private Metodos metodos;
    private ConsultasMySQL consultas;
    private String sql;
    private String xidatencion;
    public String xidpersona;
    public String xidcitologia;
    public String xGemelar;
    private ResultSet rs;
    private int enfMama;
    private int xtipo;
    private clasePyP clasepyp;
    private clasesHistoriaCE xclasef;
    private String[] lisMetodo;
    public long xidusuario;
    private boolean xencontro;
    private boolean xformacarga;
    private JIFHistoriaOdontologica xjifcho;
    private ButtonGroup JBGPlanifica;
    private ButtonGroup JBGResultadoCitol;
    private ButtonGroup JBGResultadoMamas;
    public JButton JBTGrabarA;
    private JCheckBox JCHEmbarazada;
    private JCheckBox JCHEmbarazada1;
    private JCheckBox JCHRealizado;
    private JComboBox JCUnidadTiempo;
    private JPanel JPIGinecologicos;
    private JPanel JPIObstetricos;
    private JScrollPane JSPDRMamas;
    private JTextArea JTAObservacion;
    private JTextField JTFCiclo;
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
    private JTextField JTFResultadoUltimaCitologia;
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

    public JPAAntecedenteGineco(clasePyP clase, int xtipo, boolean xcarga) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xidatencion = "0";
        this.xidpersona = "0";
        this.xidcitologia = "0";
        this.xGemelar = "-1";
        this.enfMama = 0;
        this.xencontro = false;
        this.xformacarga = false;
        initComponents();
        this.xtipo = xtipo;
        this.xformacarga = xcarga;
        this.clasepyp = clase;
        mNuevo();
    }

    public JPAAntecedenteGineco(clasesHistoriaCE xclasef, int xtipo) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xidatencion = "0";
        this.xidpersona = "0";
        this.xidcitologia = "0";
        this.xGemelar = "-1";
        this.enfMama = 0;
        this.xencontro = false;
        this.xformacarga = false;
        initComponents();
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            this.JTFFechaUMestruacion.setEnabled(false);
            this.JTFFechaULegrado.setEnabled(false);
            this.JTFFechaPParto.setEnabled(false);
            this.JTFSemanaG.setEnabled(false);
        }
        this.xtipo = xtipo;
        this.xclasef = xclasef;
        mNuevo();
    }

    public JPAAntecedenteGineco(JIFHistoriaOdontologica xjifcho, int xtipo) {
        this.metodos = new Metodos();
        this.consultas = new ConsultasMySQL();
        this.xidatencion = "0";
        this.xidpersona = "0";
        this.xidcitologia = "0";
        this.xGemelar = "-1";
        this.enfMama = 0;
        this.xencontro = false;
        this.xformacarga = false;
        initComponents();
        this.xtipo = xtipo;
        this.xjifcho = xjifcho;
        mNuevo();
    }

    private void cargarAntecedentes() {
        if (this.xidatencion.equals("0")) {
            mBuscarAntecedenteUsuario();
            return;
        }
        this.sql = "SELECT h_antecedenteginecologico.Menarquia ,h_antecedenteginecologico.FUEM, h_antecedenteginecologico.Enf_Mama , h_antecedenteginecologico.Desc_Mama, h_antecedenteginecologico.FUMama, h_antecedenteginecologico.EdadInicioRel , h_antecedenteginecologico.TiempoEnPlanifica , h_tipometplanifica.Nbre as MPlanificacion, h_antecedenteginecologico.Ciclos, h_antecedenteginecologico.CauterizacionCuello , h_antecedenteginecologico.RadioterapiaUtero, h_antecedenteginecologico.Histerectomia , h_antecedenteginecologico.ConizacionCuello, h_antecedenteginecologico.Biopsia , h_antecedenteginecologico.No_G, h_antecedenteginecologico.No_E, h_antecedenteginecologico.No_P, h_antecedenteginecologico.No_C, h_antecedenteginecologico.No_A , h_antecedenteginecologico.No_M, h_antecedenteginecologico.No_V, h_antecedenteginecologico.UltimoEmbarazo, h_antecedenteginecologico.UltimoParto , h_antecedenteginecologico.UltimoAborto ,h_antecedenteginecologico.FUM, h_antecedenteginecologico.FUC, h_antecedenteginecologico.Id_Atencion, h_antecedenteginecologico.FPParto, h_antecedenteginecologico.SemanaG, h_antecedenteginecologico.Id ,`observacion`,ifnull(`UnidadT`,'Meses') as UnidadT  , ifnull(h_antecedenteginecologico.Desc_FUC, '') as Desc_FUC FROM h_antecedenteginecologico INNER JOIN h_tipometplanifica  ON (h_antecedenteginecologico.Id_MetPlanifica = h_tipometplanifica.Id) WHERE (h_antecedenteginecologico.Id_Usuario ='" + this.xidpersona + "' and h_antecedenteginecologico.Id_Atencion='" + this.xidatencion + "') ORDER BY h_antecedenteginecologico.Id DESC ";
        System.out.println("antecendentes " + this.sql);
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.rs.first();
                this.txtMenarquia.setText(this.rs.getString("Menarquia"));
                this.JTFFechaUEcografia.setText(this.rs.getString("FUEM"));
                if (this.rs.getString("Enf_Mama").equals("1")) {
                    this.enfMama = 1;
                    this.btnEnfMama.setSelected(true);
                } else {
                    this.enfMama = 0;
                    this.btnEnfMama.setSelected(false);
                }
                this.JTFFechaUEcografia.setText(this.rs.getString("FUMama"));
                this.JTFNRegistro.setText(this.rs.getString("Id"));
                this.txtResultadoMamas.setText(this.rs.getString("Desc_Mama"));
                this.txtEdadRelaciones.setValue(Integer.valueOf(this.rs.getInt("EdadInicioRel")));
                this.txtTiempoPlanifica.setValue(Integer.valueOf(this.rs.getInt("TiempoEnPlanifica")));
                this.cboMetodo.setSelectedItem(this.rs.getString("MPlanificacion"));
                this.JTFCiclo.setText(this.rs.getString("Ciclos"));
                this.JTFFechaUCuelloU.setText(this.rs.getString("CauterizacionCuello"));
                this.JTFFechaURadioTerapia.setText(this.rs.getString("RadioterapiaUtero"));
                this.JTFFechaUHisterectomia.setText(this.rs.getString("Histerectomia"));
                this.JTFFechaUConizacionCU.setText(this.rs.getString("ConizacionCuello"));
                this.JTFFechaUBiopsia.setText(this.rs.getString("Biopsia"));
                this.txtNoEmbarazos.setValue(Integer.valueOf(this.rs.getInt("No_G")));
                this.txtNoEptopicos.setValue(Integer.valueOf(this.rs.getInt("No_E")));
                this.txtNoPartos.setValue(Integer.valueOf(this.rs.getInt("No_P")));
                this.txtNoCesareas.setValue(Integer.valueOf(this.rs.getInt("No_C")));
                this.txtNoAbortos.setValue(Integer.valueOf(this.rs.getInt("No_A")));
                this.txtNoMuertos.setValue(Integer.valueOf(this.rs.getInt("No_M")));
                this.txtNoVivos.setValue(Integer.valueOf(this.rs.getInt("No_V")));
                this.JTFFechaUParto.setText(this.rs.getString("UltimoParto"));
                this.JTFFechaUAborto.setText(this.rs.getString("UltimoAborto"));
                this.JTFFechaUMestruacion.setText(this.rs.getString("FUM"));
                this.JTFFechaUCitologia.setText(this.rs.getString("FUC"));
                this.JTFResultadoUltimaCitologia.setText(this.rs.getString("Desc_FUC"));
                this.JTFFechaPParto.setText(this.rs.getString("FPParto"));
                this.JTFSemanaG.setText(this.rs.getString("SemanaG"));
                this.JTAObservacion.setText(this.rs.getString("observacion"));
                this.JCUnidadTiempo.setSelectedItem(this.rs.getString("UnidadT").trim());
                this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
                this.xencontro = true;
            } else {
                mBuscarAntecedenteUsuario();
                this.xencontro = false;
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    public void mGrabar() {
        if (this.JTFNRegistro.getText().isEmpty()) {
            mGrabarAntecedentes();
        } else {
            mActualizarAntecedentes();
        }
        this.metodos.cambiarEstadoValidadoItemHC(getName(), 1, true);
    }

    public void mBuscarAntecedenteUsuario() {
        if (this.xformacarga) {
            this.sql = "SELECT h_antecedenteginecologico.Menarquia ,h_antecedenteginecologico.FUEM, h_antecedenteginecologico.Enf_Mama , h_antecedenteginecologico.Desc_Mama, h_antecedenteginecologico.FUMama, h_antecedenteginecologico.EdadInicioRel , h_antecedenteginecologico.TiempoEnPlanifica , h_tipometplanifica.Nbre as MPlanificacion, h_antecedenteginecologico.Ciclos, h_antecedenteginecologico.CauterizacionCuello , h_antecedenteginecologico.RadioterapiaUtero, h_antecedenteginecologico.Histerectomia , h_antecedenteginecologico.ConizacionCuello, h_antecedenteginecologico.Biopsia , h_antecedenteginecologico.No_G, h_antecedenteginecologico.No_E, h_antecedenteginecologico.No_P, h_antecedenteginecologico.No_C, h_antecedenteginecologico.No_A , h_antecedenteginecologico.No_M, h_antecedenteginecologico.No_V, h_antecedenteginecologico.UltimoEmbarazo, h_antecedenteginecologico.UltimoParto , h_antecedenteginecologico.UltimoAborto, h_antecedenteginecologico.SemanaG ,h_antecedenteginecologico.FUM, h_antecedenteginecologico.FUC, h_antecedenteginecologico.Id_Atencion, h_antecedenteginecologico.Id_Citologia, ifnull(h_antecedenteginecologico.Desc_FUC, '') as Desc_FUC FROM h_antecedenteginecologico INNER JOIN h_tipometplanifica  ON (h_antecedenteginecologico.Id_MetPlanifica = h_tipometplanifica.Id) WHERE (h_antecedenteginecologico.Id_Citologia ='" + Principal.txtNo.getText() + "') ORDER BY h_antecedenteginecologico.Id DESC ";
        } else {
            this.sql = "SELECT h_antecedenteginecologico.Menarquia ,h_antecedenteginecologico.FUEM, h_antecedenteginecologico.Enf_Mama , h_antecedenteginecologico.Desc_Mama, h_antecedenteginecologico.FUMama, h_antecedenteginecologico.EdadInicioRel , h_antecedenteginecologico.TiempoEnPlanifica , h_tipometplanifica.Nbre as MPlanificacion, h_antecedenteginecologico.Ciclos, h_antecedenteginecologico.CauterizacionCuello , h_antecedenteginecologico.RadioterapiaUtero, h_antecedenteginecologico.Histerectomia , h_antecedenteginecologico.ConizacionCuello, h_antecedenteginecologico.Biopsia , h_antecedenteginecologico.No_G, h_antecedenteginecologico.No_E, h_antecedenteginecologico.No_P, h_antecedenteginecologico.No_C, h_antecedenteginecologico.No_A , h_antecedenteginecologico.No_M, h_antecedenteginecologico.No_V, h_antecedenteginecologico.UltimoEmbarazo, h_antecedenteginecologico.UltimoParto , h_antecedenteginecologico.UltimoAborto, h_antecedenteginecologico.SemanaG ,h_antecedenteginecologico.FUM, h_antecedenteginecologico.FUC, h_antecedenteginecologico.Id_Atencion, h_antecedenteginecologico.Id_Citologia, ifnull(h_antecedenteginecologico.Desc_FUC, '') as Desc_FUC FROM h_antecedenteginecologico INNER JOIN h_tipometplanifica  ON (h_antecedenteginecologico.Id_MetPlanifica = h_tipometplanifica.Id) WHERE (h_antecedenteginecologico.Id_Usuario ='" + this.xidpersona + "') ORDER BY h_antecedenteginecologico.Id DESC ";
        }
        this.rs = this.consultas.traerRs(this.sql);
        try {
            if (this.rs.next()) {
                this.rs.first();
                this.txtMenarquia.setText(this.rs.getString("Menarquia"));
                this.JTFFechaUEcografia.setText(this.rs.getString("FUEM"));
                if (this.rs.getString("Enf_Mama").equals("1")) {
                    this.enfMama = 1;
                    this.btnEnfMama.setSelected(true);
                } else {
                    this.enfMama = 0;
                    this.btnEnfMama.setSelected(false);
                }
                this.txtResultadoMamas.setText(this.rs.getString("Desc_Mama"));
                this.txtEdadRelaciones.setValue(Integer.valueOf(this.rs.getInt("EdadInicioRel")));
                this.txtTiempoPlanifica.setValue(Integer.valueOf(this.rs.getInt("TiempoEnPlanifica")));
                this.cboMetodo.setSelectedItem(this.rs.getString("MPlanificacion"));
                this.JTFCiclo.setText(this.rs.getString("Ciclos"));
                this.JTFFechaUCuelloU.setText(this.rs.getString("CauterizacionCuello"));
                this.JTFFechaURadioTerapia.setText(this.rs.getString("RadioterapiaUtero"));
                this.JTFFechaUHisterectomia.setText(this.rs.getString("Histerectomia"));
                this.JTFFechaUConizacionCU.setText(this.rs.getString("ConizacionCuello"));
                this.JTFFechaUBiopsia.setText(this.rs.getString("Biopsia"));
                this.txtNoEmbarazos.setValue(Integer.valueOf(this.rs.getInt("No_G")));
                this.txtNoEptopicos.setValue(Integer.valueOf(this.rs.getInt("No_E")));
                this.txtNoPartos.setValue(Integer.valueOf(this.rs.getInt("No_P")));
                this.txtNoCesareas.setValue(Integer.valueOf(this.rs.getInt("No_C")));
                this.txtNoAbortos.setValue(Integer.valueOf(this.rs.getInt("No_A")));
                this.txtNoMuertos.setValue(Integer.valueOf(this.rs.getInt("No_M")));
                this.txtNoVivos.setValue(Integer.valueOf(this.rs.getInt("No_V")));
                this.JTFFechaUParto.setText(this.rs.getString("UltimoParto"));
                this.JTFFechaUAborto.setText(this.rs.getString("UltimoAborto"));
                this.JTFFechaUMestruacion.setText(this.rs.getString("FUM"));
                this.JTFFechaUCitologia.setText(this.rs.getString("FUC"));
                this.JTFResultadoUltimaCitologia.setText(this.rs.getString("Desc_FUC"));
                this.JTFSemanaG.setText(this.rs.getString("SemanaG"));
                setXidcitologia(this.rs.getString("Id_Citologia"));
            }
            this.rs.close();
            this.consultas.cerrarConexionBd();
        } catch (SQLException ex) {
            this.consultas.mostrarErrorSQL(ex);
        }
    }

    private void mGrabarAntecedentes() {
        this.sql = "Insert into h_antecedenteginecologico (Id_Usuario, Id_Atencion, Id_Citologia, FUM, FUMestruacion, FUC, FUMama, FUEM, Enf_Mama, Desc_Mama, Id_MetPlanifica, TiempoEnPlanifica , No_G, No_P, No_C, No_A, UltimoParto, UltimoAborto, No_E, No_M, No_V, Menarquia, EdadInicioRel, CauterizacionCuello, RadioterapiaUtero, Histerectomia, ConizacionCuello, Biopsia , Ciclos, FPParto, SemanaG,Gemelar, Legrado,   Fecha, UsuarioS , `observacion`,Desc_FUC, `UnidadT` ) Values('" + this.xidpersona + "','" + this.xidatencion + "','" + getXidcitologia() + "','" + this.JTFFechaUMestruacion.getText() + "','" + this.JTFFechaUMestruacion.getText() + "','" + this.JTFFechaUCitologia.getText() + "','" + this.JTFFechaUEcografia.getText() + "','" + this.JTFFechaUEcografia.getText() + "','" + this.enfMama + "','" + this.txtResultadoMamas.getText() + "','" + this.lisMetodo[this.cboMetodo.getSelectedIndex()] + "','" + this.txtTiempoPlanifica.getValue() + "','" + this.txtNoEmbarazos.getValue() + "','" + this.txtNoPartos.getValue() + "','" + this.txtNoCesareas.getValue() + "','" + this.txtNoAbortos.getValue() + "','" + this.JTFFechaUParto.getText() + "','" + this.JTFFechaUAborto.getText() + "','" + this.txtNoEptopicos.getValue() + "','" + this.txtNoMuertos.getValue() + "','" + this.txtNoVivos.getValue() + "','" + this.txtMenarquia.getText() + "','" + this.txtEdadRelaciones.getValue() + "','" + this.JTFFechaUCuelloU.getText() + "','" + this.JTFFechaURadioTerapia.getText() + "','" + this.JTFFechaUHisterectomia.getText() + "','" + this.JTFFechaUConizacionCU.getText() + "','" + this.JTFFechaUBiopsia.getText() + "','" + this.JTFCiclo.getText() + "','" + this.JTFFechaPParto.getText() + "','" + this.JTFSemanaG.getText() + "','" + this.xGemelar + "','" + this.JTFFechaULegrado.getText() + "','" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "','" + Principal.usuarioSistemaDTO.getLogin() + "', '" + this.JTAObservacion.getText() + "', '" + this.JTFResultadoUltimaCitologia.getText() + "','" + this.JCUnidadTiempo.getSelectedItem().toString().trim() + "')";
        this.JTFNRegistro.setText(this.consultas.ejecutarSQLId(this.sql));
        this.consultas.cerrarConexionBd();
        if (this.xtipo == 0) {
            this.clasepyp.frmToma.xllenoantecedentes = true;
        }
    }

    private void mActualizarAntecedentes() {
        this.sql = "Update h_antecedenteginecologico  set FUMestruacion='" + this.JTFFechaUMestruacion.getText() + "', FUM='" + this.JTFFechaUMestruacion.getText() + "', FUC='" + this.JTFFechaUCitologia.getText() + "', FUMama='" + this.JTFFechaUEcografia.getText() + "', FUEM='" + this.enfMama + "', Enf_Mama='" + this.enfMama + "', Desc_Mama='" + this.txtResultadoMamas.getText() + "', Id_MetPlanifica='" + this.lisMetodo[this.cboMetodo.getSelectedIndex()] + "', TiempoEnPlanifica= '" + this.txtTiempoPlanifica.getValue() + "',No_G='" + this.txtNoEmbarazos.getValue() + "', No_P='" + this.txtNoPartos.getValue() + "', No_C='" + this.txtNoCesareas.getValue() + "', No_A='" + this.txtNoAbortos.getValue() + "', UltimoParto='" + this.JTFFechaUParto.getText() + "', UltimoAborto='" + this.JTFFechaUAborto.getText() + "', Legrado='" + this.JTFFechaULegrado.getText() + "', No_E='" + this.txtNoEptopicos.getValue() + "', No_M='" + this.txtNoMuertos.getValue() + "', No_V='" + this.txtNoVivos.getValue() + "', Menarquia='" + this.txtMenarquia.getText() + "', EdadInicioRel='" + this.txtEdadRelaciones.getValue() + "', CauterizacionCuello='" + this.JTFFechaUCuelloU.getText() + "', RadioterapiaUtero='" + this.JTFFechaURadioTerapia.getText() + "', Histerectomia='" + this.JTFFechaUHisterectomia.getText() + "', ConizacionCuello='" + this.JTFFechaUConizacionCU.getText() + "', Biopsia='" + this.JTFFechaUBiopsia.getText() + "', Ciclos='" + this.JTFCiclo.getText() + "', FPParto='" + this.JTFFechaPParto.getText() + "', SemanaG='" + this.JTFSemanaG.getText() + "', Gemelar='" + this.xGemelar + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Desc_FUC ='" + this.JTFResultadoUltimaCitologia.getText() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', Id_Citologia='" + getXidcitologia() + "', `observacion` ='" + this.JTAObservacion.getText() + "', `UnidadT`='" + this.JCUnidadTiempo.getSelectedItem().toString().trim() + "' where Id_Usuario='" + this.xidpersona + "' and Id_Atencion='" + this.xidatencion + "'";
        System.out.println("insertar datos" + this.sql);
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        if (this.xtipo == 0) {
            this.clasepyp.frmToma.xllenoantecedentes = true;
        }
    }

    private void mActualizarAntecedentesCitologia() {
        this.sql = "Update h_antecedenteginecologico  set FUMestruacion='" + this.JTFFechaUMestruacion.getText() + "', FUM='" + this.JTFFechaUMestruacion.getText() + "', FUC='" + this.JTFFechaUCitologia.getText() + "', FUMama='" + this.JTFFechaUEcografia.getText() + "', FUEM='" + this.enfMama + "', Enf_Mama='" + this.enfMama + "', Desc_Mama='" + this.txtResultadoMamas.getText() + "', Id_MetPlanifica='" + this.lisMetodo[this.cboMetodo.getSelectedIndex()] + "', TiempoEnPlanifica= '" + this.txtTiempoPlanifica.getValue() + "',No_G='" + this.txtNoEmbarazos.getValue() + "', No_P='" + this.txtNoPartos.getValue() + "', No_C='" + this.txtNoCesareas.getValue() + "', No_A='" + this.txtNoAbortos.getValue() + "', UltimoParto='" + this.JTFFechaUParto.getText() + "', UltimoAborto='" + this.JTFFechaUAborto.getText() + "', No_E='" + this.txtNoEptopicos.getValue() + "', No_M='" + this.txtNoMuertos.getValue() + "', No_V='" + this.txtNoVivos.getValue() + "', Menarquia='" + this.txtMenarquia.getText() + "', EdadInicioRel='" + this.txtEdadRelaciones.getValue() + "', CauterizacionCuello='" + this.JTFFechaUCuelloU.getText() + "', RadioterapiaUtero='" + this.JTFFechaURadioTerapia.getText() + "', Histerectomia='" + this.JTFFechaUHisterectomia.getText() + "', ConizacionCuello='" + this.JTFFechaUConizacionCU.getText() + "', Biopsia='" + this.JTFFechaUBiopsia.getText() + "', Ciclos='" + this.JTFCiclo.getText() + "', Fecha ='" + this.metodos.formatoAMDH24.format(this.metodos.getFechaActual()) + "', Desc_FUC ='" + this.JTFResultadoUltimaCitologia.getText() + "', UsuarioS='" + Principal.usuarioSistemaDTO.getLogin() + "', `observacion`= '" + this.JTAObservacion.getText() + "', `UnidadT`='" + this.JCUnidadTiempo.getSelectedItem().toString().trim() + "' where Id_Usuario='" + this.xidpersona + "' and Id_Citologia='" + getXidcitologia() + "'";
        this.consultas.ejecutarSQL(this.sql);
        this.consultas.cerrarConexionBd();
        this.metodos.mostrarMensaje("Antacedentes Grabados");
        if (this.xtipo == 0) {
            this.clasepyp.frmToma.xllenoantecedentes = true;
        }
    }

    private void mInicilizarDatos() {
        switch (this.xtipo) {
            case 1:
                clasesHistoriaCE claseshistoriace = this.xclasef;
                this.xidpersona = String.valueOf(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido());
                clasesHistoriaCE claseshistoriace2 = this.xclasef;
                this.xidatencion = clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion();
                break;
            case 2:
                if (!this.xjifcho.xjppersona.getIdPersona().equals("0")) {
                    this.xidusuario = Long.valueOf(this.xjifcho.xjppersona.getIdPersona()).longValue();
                }
                this.xidatencion = "0";
                break;
        }
    }

    public void mNuevo() {
        this.JTFNRegistro.setText("");
        this.lisMetodo = this.consultas.llenarCombo("SELECT Id, Nbre FROM h_tipometplanifica WHERE (Estado =0) ORDER BY Nbre ASC", this.lisMetodo, this.cboMetodo);
        this.cboMetodo.setSelectedItem("NO PLANIFICA");
        this.consultas.cerrarConexionBd();
        mInicilizarDatos();
        cargarAntecedentes();
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
        this.JTFResultadoUltimaCitologia = new JTextField();
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
        this.JTFNRegistro = new JTextField();
        this.JBTGrabarA = new JButton();
        setName("AntecedenteGineco");
        addAncestorListener(new AncestorListener() { // from class: Historia.JPAAntecedenteGineco.1
            public void ancestorAdded(AncestorEvent evt) {
            }

            public void ancestorMoved(AncestorEvent evt) {
            }

            public void ancestorRemoved(AncestorEvent evt) {
                JPAAntecedenteGineco.this.formAncestorRemoved(evt);
            }
        });
        this.JTPAGinecoObstetricos.setForeground(new Color(0, 103, 0));
        this.JTPAGinecoObstetricos.setFont(new Font("Arial", 1, 14));
        this.txtUltimaEco.setDateFormatString("dd/MM/yyyy");
        this.txtUltimaEco.setFont(new Font("Tahoma", 1, 12));
        this.txtUltimaEco.setMaxSelectableDate(new Date(253370786463000L));
        this.txtUltimaEco.setName("cboMenarquia");
        this.txtUltimaEco.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.2
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.txtUltimaEcoPropertyChange(evt);
            }
        });
        this.btnEnfMama.setFont(new Font("Arial", 1, 12));
        this.btnEnfMama.setForeground(Color.blue);
        this.btnEnfMama.setText("Enf. Mama?");
        this.btnEnfMama.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco.3
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco.this.btnEnfMamaActionPerformed(evt);
            }
        });
        this.JSPDRMamas.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción de Enfermedad", 1, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.txtResultadoMamas.setFont(new Font("Arial", 1, 12));
        this.txtResultadoMamas.addKeyListener(new KeyAdapter() { // from class: Historia.JPAAntecedenteGineco.4
            public void keyPressed(KeyEvent evt) {
                JPAAntecedenteGineco.this.txtResultadoMamasKeyPressed(evt);
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
        this.txtCauterizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.5
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.txtCauterizacionPropertyChange(evt);
            }
        });
        this.txtRadioterapia.setDateFormatString("dd/MM/yyyy");
        this.txtRadioterapia.setFont(new Font("Tahoma", 1, 12));
        this.txtRadioterapia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtRadioterapia.setName("cboMenarquia");
        this.txtRadioterapia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.6
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.txtRadioterapiaPropertyChange(evt);
            }
        });
        this.txtHisterectomia.setDateFormatString("dd/MM/yyyy");
        this.txtHisterectomia.setFont(new Font("Tahoma", 1, 12));
        this.txtHisterectomia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtHisterectomia.setName("cboMenarquia");
        this.txtHisterectomia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.7
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.txtHisterectomiaPropertyChange(evt);
            }
        });
        this.txtConizacion.setDateFormatString("dd/MM/yyyy");
        this.txtConizacion.setFont(new Font("Tahoma", 1, 12));
        this.txtConizacion.setMaxSelectableDate(new Date(253370786463000L));
        this.txtConizacion.setName("cboMenarquia");
        this.txtConizacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.8
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.txtConizacionPropertyChange(evt);
            }
        });
        this.txtBiopsia.setDateFormatString("dd/MM/yyyy");
        this.txtBiopsia.setFont(new Font("Tahoma", 1, 12));
        this.txtBiopsia.setMaxSelectableDate(new Date(253370786463000L));
        this.txtBiopsia.setName("cboMenarquia");
        this.txtBiopsia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.9
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.txtBiopsiaPropertyChange(evt);
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
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.JTFFechaUCuelloU, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtCauterizacion, -2, 22, -2).addGap(12, 12, 12).addComponent(this.JTFFechaURadioTerapia, -2, 130, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtRadioterapia, -2, 21, -2).addGap(41, 41, 41).addComponent(this.JTFFechaUHisterectomia, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtHisterectomia, -2, 20, -2).addGap(18, 18, 18).addComponent(this.JTFFechaUConizacionCU, -2, 110, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtConizacion, -2, 20, -2).addGap(12, 12, 12).addComponent(this.JTFFechaUBiopsia, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtBiopsia, -2, 20, -2).addContainerGap(48, 32767)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaUBiopsia, -2, 35, -2).addComponent(this.txtConizacion, -2, 35, -2).addComponent(this.JTFFechaUConizacionCU, -2, 35, -2).addComponent(this.JTFFechaUCuelloU).addComponent(this.txtHisterectomia, -2, 35, -2).addComponent(this.JTFFechaUHisterectomia, -2, 35, -2).addComponent(this.txtRadioterapia, -1, -1, 32767).addComponent(this.JTFFechaURadioTerapia, -1, -1, -2).addComponent(this.txtBiopsia, -2, 35, -2).addComponent(this.txtCauterizacion, -2, 35, -2));
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
        this.cboUltimaCitologia.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.10
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.cboUltimaCitologiaPropertyChange(evt);
            }
        });
        this.JCHRealizado.setFont(new Font("Arial", 1, 12));
        this.JCHRealizado.setText("Sin Realizar");
        this.JCHRealizado.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco.11
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco.this.JCHRealizadoActionPerformed(evt);
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
        this.JCUnidadTiempo.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco.12
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco.this.JCUnidadTiempoActionPerformed(evt);
            }
        });
        this.JTFResultadoUltimaCitologia.setFont(new Font("Arial", 1, 12));
        this.JTFResultadoUltimaCitologia.setHorizontalAlignment(4);
        this.JTFResultadoUltimaCitologia.setBorder(BorderFactory.createTitledBorder((Border) null, "Resultado (Última citología)", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPIGinecologicosLayout = new GroupLayout(this.JPIGinecologicos);
        this.JPIGinecologicos.setLayout(JPIGinecologicosLayout);
        JPIGinecologicosLayout.setHorizontalGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPIGinecologicosLayout.createSequentialGroup().addComponent(this.txtMenarquia, -2, 193, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFechaUEcografia, -2, 135, -2)).addGroup(JPIGinecologicosLayout.createSequentialGroup().addComponent(this.txtEdadRelaciones, -2, 201, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtTiempoPlanifica, -2, 127, -2))).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.txtUltimaEco, -2, 20, -2).addGap(18, 18, 18).addComponent(this.btnEnfMama, -2, 97, -2).addGap(16, 16, 16).addComponent(this.JSPDRMamas, -2, 311, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, JPIGinecologicosLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(this.JCUnidadTiempo, -2, -1, -2).addGap(396, 396, 396)))).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -2, -1, -2).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, JPIGinecologicosLayout.createSequentialGroup().addComponent(this.JTFCiclo, -2, 201, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFFechaUCitologia, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaCitologia, -2, 22, -2).addGap(14, 14, 14).addComponent(this.JCHRealizado).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JTFResultadoUltimaCitologia)).addGroup(GroupLayout.Alignment.LEADING, JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.cboMetodo, -2, 357, -2).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -2, 808, -2)))).addGap(5, 5, 5)))));
        JPIGinecologicosLayout.setVerticalGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JSPDRMamas, GroupLayout.Alignment.LEADING, -2, 60, -2).addGroup(GroupLayout.Alignment.LEADING, JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtMenarquia, GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaUEcografia, GroupLayout.Alignment.LEADING).addComponent(this.txtUltimaEco, GroupLayout.Alignment.LEADING, -2, 35, -2).addComponent(this.btnEnfMama))).addGap(5, 5, 5).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtEdadRelaciones, -2, -1, -2).addComponent(this.txtTiempoPlanifica, -2, -1, -2).addComponent(this.JCUnidadTiempo, -2, 50, -2).addComponent(this.cboMetodo, -2, 50, -2)).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(5, 5, 5).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFCiclo, -2, 59, -2).addComponent(this.cboUltimaCitologia, -2, 59, -2).addComponent(this.JTFFechaUCitologia, -2, 59, -2))).addGroup(JPIGinecologicosLayout.createSequentialGroup().addGap(4, 4, 4).addGroup(JPIGinecologicosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCHRealizado).addComponent(this.JTFResultadoUltimaCitologia, -2, 59, -2)))).addGap(5, 5, 5).addComponent(this.jScrollPane1, -2, 81, -2).addGap(5, 5, 5).addComponent(this.jPanel3, -2, -1, -2)));
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
        this.txtUltimoParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.13
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.txtUltimoPartoPropertyChange(evt);
            }
        });
        this.JTFFechaUAborto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUAborto.setHorizontalAlignment(4);
        this.JTFFechaUAborto.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Aborto", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaAborto.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaAborto.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaAborto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaAborto.setName("cboMenarquia");
        this.cboUltimaAborto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.14
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.cboUltimaAbortoPropertyChange(evt);
            }
        });
        this.JTFFechaUMestruacion.setFont(new Font("Arial", 1, 12));
        this.JTFFechaUMestruacion.setHorizontalAlignment(4);
        this.JTFFechaUMestruacion.setBorder(BorderFactory.createTitledBorder((Border) null, "FU Mestruación", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboUltimaMestruacion.setDateFormatString("dd/MM/yyyy");
        this.cboUltimaMestruacion.setFont(new Font("Tahoma", 1, 12));
        this.cboUltimaMestruacion.setMaxSelectableDate(new Date(253370786463000L));
        this.cboUltimaMestruacion.setName("cboMenarquia");
        this.cboUltimaMestruacion.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.15
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.cboUltimaMestruacionPropertyChange(evt);
            }
        });
        this.JTFFechaPParto.setFont(new Font("Arial", 1, 12));
        this.JTFFechaPParto.setHorizontalAlignment(4);
        this.JTFFechaPParto.setBorder(BorderFactory.createTitledBorder((Border) null, "FPP", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.cboFechaPParto.setDateFormatString("dd/MM/yyyy");
        this.cboFechaPParto.setFont(new Font("Tahoma", 1, 12));
        this.cboFechaPParto.setMaxSelectableDate(new Date(253370786463000L));
        this.cboFechaPParto.setName("cboMenarquia");
        this.cboFechaPParto.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.16
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.cboFechaPPartoPropertyChange(evt);
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
        this.cboUltimaLegrado.addPropertyChangeListener(new PropertyChangeListener() { // from class: Historia.JPAAntecedenteGineco.17
            @Override // java.beans.PropertyChangeListener
            public void propertyChange(PropertyChangeEvent evt) {
                JPAAntecedenteGineco.this.cboUltimaLegradoPropertyChange(evt);
            }
        });
        this.JCHEmbarazada.setFont(new Font("Arial", 1, 12));
        this.JCHEmbarazada.setText("Actualmente esta embarazada?");
        this.JCHEmbarazada.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco.18
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco.this.JCHEmbarazadaActionPerformed(evt);
            }
        });
        this.JCHEmbarazada1.setFont(new Font("Arial", 1, 12));
        this.JCHEmbarazada1.setText("Embarazo Gemelar?");
        this.JCHEmbarazada1.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco.19
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco.this.JCHEmbarazada1ActionPerformed(evt);
            }
        });
        GroupLayout JPIObstetricosLayout = new GroupLayout(this.JPIObstetricos);
        this.JPIObstetricos.setLayout(JPIObstetricosLayout);
        JPIObstetricosLayout.setHorizontalGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addContainerGap().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.txtNoEmbarazos, -1, -1, 32767).addComponent(this.txtNoMuertos, -2, 119, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.txtNoAbortos, -2, 128, -2).addComponent(this.txtNoVivos, -2, 127, -2)).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPIObstetricosLayout.createSequentialGroup().addGap(38, 38, 38).addComponent(this.txtNoPartos, -2, 128, -2).addGap(24, 24, 24).addComponent(this.txtNoCesareas, -2, 146, -2).addGap(25, 25, 25).addComponent(this.txtNoEptopicos, -2, 146, -2)).addGroup(JPIObstetricosLayout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.JTFFechaUParto, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.txtUltimoParto, -2, 21, -2).addGap(24, 24, 24).addComponent(this.JTFFechaUAborto, -2, 120, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaAborto, -2, 23, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFFechaUMestruacion, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaMestruacion, -2, 20, -2)))).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JTFFechaULegrado, -2, 119, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboUltimaLegrado, -2, 23, -2).addGap(18, 18, 18).addComponent(this.JTFFechaPParto, -2, 139, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.cboFechaPParto, -2, 20, -2).addGap(18, 18, 18).addComponent(this.JTFSemanaG, -2, 139, -2).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCHEmbarazada).addComponent(this.JCHEmbarazada1)))).addGap(84, 84, 84)));
        JPIObstetricosLayout.setVerticalGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPIObstetricosLayout.createSequentialGroup().addGap(29, 29, 29).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE, false).addComponent(this.txtNoEmbarazos, -2, 55, -2).addComponent(this.txtNoAbortos, -2, 56, -2).addComponent(this.txtNoPartos, -2, 56, -2).addComponent(this.txtNoCesareas, -2, 54, -2).addComponent(this.txtNoEptopicos, -2, 56, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTFFechaUMestruacion, -2, 56, -2).addComponent(this.txtUltimoParto, -2, 56, -2).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.txtNoVivos, -2, 54, -2).addComponent(this.txtNoMuertos, -2, 54, -2).addComponent(this.JTFFechaUParto, -2, 56, -2)).addComponent(this.JTFFechaUAborto, -2, 56, -2).addComponent(this.cboUltimaAborto, -2, 56, -2).addComponent(this.cboUltimaMestruacion, -2, 56, -2)).addGap(18, 18, 18).addGroup(JPIObstetricosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JTFFechaULegrado, -2, 56, -2).addComponent(this.cboUltimaLegrado, -2, 56, -2).addComponent(this.JTFFechaPParto, -2, 56, -2).addComponent(this.cboFechaPParto, -2, 56, -2).addComponent(this.JTFSemanaG, -2, 56, -2).addGroup(JPIObstetricosLayout.createSequentialGroup().addComponent(this.JCHEmbarazada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.JCHEmbarazada1))).addContainerGap(105, 32767)));
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
        this.JBTGrabarA.addActionListener(new ActionListener() { // from class: Historia.JPAAntecedenteGineco.20
            public void actionPerformed(ActionEvent evt) {
                JPAAntecedenteGineco.this.JBTGrabarAActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(5, 5, 5).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JTPAGinecoObstetricos, -2, 869, -2).addGroup(layout.createSequentialGroup().addComponent(this.JBTGrabarA, -2, 731, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTFNRegistro, -2, 120, -2))).addContainerGap(-1, 32767)));
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
            if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
                this.JTFFechaUMestruacion.setEnabled(true);
                this.JTFFechaULegrado.setEnabled(true);
                this.JTFFechaPParto.setEnabled(true);
                this.JTFSemanaG.setEnabled(true);
                return;
            }
            return;
        }
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S")) {
            this.JTFFechaUMestruacion.setEnabled(false);
            this.JTFFechaULegrado.setEnabled(false);
            this.JTFFechaPParto.setEnabled(false);
            this.JTFSemanaG.setEnabled(false);
        }
        this.JTFSemanaG.setText("0");
        this.JTFFechaPParto.setText("");
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
        if (Principal.informacionIps.getNombreIps().equals("OROSALUD CAUCASIA IPS S.A.S") || Principal.informacionIps.getNombreIps().equals("MINEROS S.A") || Principal.informacionIps.getNombreIps().equals("NEGOCIOS AGROFORESTALES S.A.S") || Principal.informacionIps.getNombreIps().equals("OPERADORA MINERA S.A.S") || Principal.informacionIps.getNombreIps().equals("FUNDACION MINERO S.A") || Principal.informacionIps.getNombreIps().equals("MINEROS ALUVIAL S.A.S")) {
            if (!this.JCHEmbarazada.isSelected()) {
                if (Integer.parseInt(this.txtNoEmbarazos.getValue().toString()) >= 0 && this.JTFFechaULegrado.getText().isEmpty() && this.JTFFechaPParto.getText().isEmpty() && this.JTFSemanaG.getText().isEmpty()) {
                    mGrabar();
                    return;
                }
                return;
            }
            if (Integer.parseInt(this.txtNoEmbarazos.getValue().toString()) >= 0) {
                if (!this.JTFFechaUMestruacion.getText().isEmpty() && this.JTFFechaUMestruacion.getText() != null) {
                    if (!this.JTFFechaPParto.getText().isEmpty() && this.JTFFechaPParto.getText() != null) {
                        if (!this.JTFSemanaG.getText().isEmpty() && this.JTFSemanaG.getText() != null) {
                            mGrabar();
                            return;
                        }
                        JOptionPane.showMessageDialog(this, "Por favor ingrese las semanas de gestación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                        this.JTFSemanaG.requestFocus();
                        this.JTPAGinecoObstetricos.setSelectedIndex(1);
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Por favor ingrese la fecha probable de parto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFFechaPParto.requestFocus();
                    this.JTPAGinecoObstetricos.setSelectedIndex(1);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Por favor ingrese la fecha de la ultima menstruación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFechaUMestruacion.requestFocus();
                this.JTPAGinecoObstetricos.setSelectedIndex(1);
                return;
            }
            return;
        }
        if (Integer.parseInt(this.txtNoEmbarazos.getValue().toString()) > 0) {
            if (!this.JTFFechaUMestruacion.getText().isEmpty() && this.JTFFechaUMestruacion.getText() != null) {
                if (!this.JTFFechaPParto.getText().isEmpty() && this.JTFFechaPParto.getText() != null) {
                    if (!this.JTFSemanaG.getText().isEmpty() && this.JTFSemanaG.getText() != null) {
                        mGrabar();
                        return;
                    }
                    JOptionPane.showMessageDialog(this, "Por favor ingrese las semanas de gestación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                    this.JTFSemanaG.requestFocus();
                    this.JTPAGinecoObstetricos.setSelectedIndex(1);
                    return;
                }
                JOptionPane.showMessageDialog(this, "Por favor ingrese la fecha probable de parto", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
                this.JTFFechaPParto.requestFocus();
                this.JTPAGinecoObstetricos.setSelectedIndex(1);
                return;
            }
            JOptionPane.showMessageDialog(this, "Por favor ingrese la fecha de la ultima menstruación", "VERIFICAR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Information.png"))));
            this.JTFFechaUMestruacion.requestFocus();
            this.JTPAGinecoObstetricos.setSelectedIndex(1);
        }
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
