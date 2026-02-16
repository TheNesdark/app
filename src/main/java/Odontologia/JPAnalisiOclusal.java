package Odontologia;

import Acceso.Principal;
import Historia.clasesHistoriaCE;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/* JADX INFO: loaded from: GenomaP.jar:Odontologia/JPAnalisiOclusal.class */
public class JPAnalisiOclusal extends JPanel {
    private DefaultTableModel xmodelo2;
    private DefaultTableModel xmodelocombo;
    private Object[] xdato;
    private String[] xidmaloclusion;
    private String[] xidArcoSup;
    private String[] xidArcoInf;
    private String[] xidApiSup;
    private String[] xidApiInf;
    private String[] xidDenticion;
    private String[] xidCurSpee1;
    private String[] xidTrasArcoSup;
    private String[] xidTrasArcoInf;
    private String[] xidLinMedFacial;
    private String[] xidLinMedDentSup;
    private String[] xidLinMedDentInf;
    private String[] xidCruzSupDerecha;
    private String[] xidCruzSupIzquierda;
    private String[] xidMordTijeraDer;
    private String[] xidMordTijeraIzq;
    private String[] xidSobrMordiHor;
    private String[] xidMordiCruzAnt;
    private String[] xidCaniRelDer;
    private String[] xidMolarRelDer;
    private String[] xidCaniRelIzq;
    private String[] xidMolarRelIzq;
    private String[] xidSobMordVertical;
    private String[] xidMordAbiertaAnt;
    private String[] xidMordAbirPostDer;
    private String[] xidMordAbirPostIzq;
    private String[] xidCurvSpee2;
    private String[] xidMesiodital;
    private String[] xidIndiceBolton;
    private ButtonGroup JBGRM;
    private JButton JBGuardar;
    private JComboBox JCBApiInf;
    private JComboBox JCBApiSup;
    private JComboBox JCBArcoInf;
    private JComboBox JCBArcoSup;
    private JComboBox JCBCurvaSpee;
    private JComboBox JCBDenticion;
    private JComboBox JCBMaloclusion;
    private JComboBox JCBMedCruzadaPostDer;
    private JComboBox JCBMedCruzadaPostIzq;
    private JComboBox JCBMordAbiertaAnt;
    private JComboBox JCBMordAbiertaPostDer;
    private JComboBox JCBMordAbiertaPostIzq;
    private JComboBox JCBMordCruzAnterior;
    private JComboBox JCBMordTijeraDer;
    private JComboBox JCBMordTijeraIzq;
    private JComboBox JCBRelDerCanina;
    private JComboBox JCBRelDerMolar;
    private JComboBox JCBRelIzqCanina;
    private JComboBox JCBRelIzqMolar;
    private JComboBox JCBSobreMordHorztal;
    private JComboBox JCBSobreMordVertical;
    private JComboBox JCBTrasInferior;
    private JComboBox JCBTrasSuperior;
    public JDateChooser JDFecha;
    private JFormattedTextField JFTFMMApiInf;
    private JFormattedTextField JFTFMMApiSup;
    private JFormattedTextField JFTFMMCurvaSpee;
    private JFormattedTextField JFTFMMMCPostDer;
    private JFormattedTextField JFTFMMMCPostIzq;
    private JFormattedTextField JFTFMMMordAbiertaAnt;
    private JFormattedTextField JFTFMMMordAbiertaPostDer;
    private JFormattedTextField JFTFMMMordAbiertaPostIzq;
    private JFormattedTextField JFTFMMMordCruzAnterior;
    private JFormattedTextField JFTFMMMordTijeraDer;
    private JFormattedTextField JFTFMMMordTijeraIzq;
    private JFormattedTextField JFTFMMRelDerCanina;
    private JFormattedTextField JFTFMMRelDerMolar;
    private JFormattedTextField JFTFMMRelIzqCanina;
    private JFormattedTextField JFTFMMRelIzqMolar;
    private JFormattedTextField JFTFMMSobrMordHorztal;
    private JFormattedTextField JFTFMMSobreMordVertical;
    private JPanel JPClasificacionAngle;
    private JPanel JPDatos;
    private JPanel JPFormulario;
    private JPanel JPHistorico;
    private JPanel JPMedCruzadaPosterior;
    private JPanel JPMordTijera;
    private JPanel JPMordidaAbiertAnt;
    private JPanel JPPlanoSajital;
    private JPanel JPPlanoTransversal;
    private JPanel JPPlanoVertical;
    private JScrollPane JSPFormulario;
    private JScrollPane JSPHistorico;
    private JScrollPane JSPObservacion;
    private JTextArea JTAObservacion;
    private JTable JTHistorico;
    private JTabbedPane JTPInformacion;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private long xrmolar = 0;
    private long xrcanino = 0;
    private long xconceptoh = 0;
    private long xconceptov = 0;
    private long xrtrasversal = 0;
    ConsultasMySQL xconsulta = new ConsultasMySQL();
    private String xexamen = "";
    Metodos xmt = new Metodos();
    private long xranalisis = 0;
    private long xaplica = 0;
    private String xanaOclusal = "";
    private String xsql = null;

    public JPAnalisiOclusal() {
        initComponents();
        mNuevo();
        mBuscarHistorico();
    }

    private void mNuevo() {
        this.JDFecha.setDate(this.xmt.getFechaActual());
        mCargarCombosParametros();
        this.JFTFMMApiSup.setValue(0);
        this.JFTFMMApiInf.setValue(0);
        this.JFTFMMCurvaSpee.setValue(0);
        this.JFTFMMMCPostDer.setValue(0);
        this.JFTFMMMCPostIzq.setValue(0);
        this.JFTFMMMordTijeraDer.setValue(0);
        this.JFTFMMMordTijeraIzq.setValue(0);
        this.JFTFMMSobrMordHorztal.setValue(0);
        this.JFTFMMMordCruzAnterior.setValue(0);
        this.JFTFMMRelDerCanina.setValue(0);
        this.JFTFMMRelDerMolar.setValue(0);
        this.JFTFMMRelIzqCanina.setValue(0);
        this.JFTFMMRelIzqMolar.setValue(0);
        this.JFTFMMSobreMordVertical.setValue(0);
        this.JFTFMMMordAbiertaAnt.setValue(0);
        this.JFTFMMMordAbiertaPostDer.setValue(0);
        this.JFTFMMMordAbiertaPostIzq.setValue(0);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[], java.lang.Object[][]] */
    private void mCrearModeloHistorico() {
        this.xmodelo2 = new DefaultTableModel(new Object[0], new String[]{"Id", "IdAtencion", "Fecha", "Profesional", "Especialidad"}) { // from class: Odontologia.JPAnalisiOclusal.1
            Class[] types = {Integer.class, String.class, String.class, String.class, String.class};
            boolean[] canEdit = {false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        };
        this.JTHistorico.setModel(this.xmodelo2);
        this.JTHistorico.getColumnModel().getColumn(0).setPreferredWidth(2);
        this.JTHistorico.getColumnModel().getColumn(1).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(2).setPreferredWidth(20);
        this.JTHistorico.getColumnModel().getColumn(3).setPreferredWidth(150);
        this.JTHistorico.getColumnModel().getColumn(4).setPreferredWidth(150);
    }

    private void mBuscarHistorico() {
        mCrearModeloHistorico();
        String sql = "SELECT `o_analisis_oclusal`.`Id` , `o_analisis_oclusal`.`IdAtencion` , `o_analisis_oclusal`.`FechaR`  , `profesional1`.`NProfesional` , `profesional1`.`Especialidad`  FROM `o_analisis_oclusal`  INNER JOIN  `profesional1`   ON (`o_analisis_oclusal`.`IdProfesional` = `profesional1`.`Id_Persona`) AND (`o_analisis_oclusal`.`IdEspecialidad` = `profesional1`.`IdEspecialidad`) WHERE (`o_analisis_oclusal`.`IdUsuario` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "')";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.beforeFirst();
                int n = 0;
                while (xrs.next()) {
                    this.xmodelo2.addRow(this.xdato);
                    this.xmodelo2.setValueAt(Integer.valueOf(xrs.getInt(1)), n, 0);
                    this.xmodelo2.setValueAt(xrs.getString(2), n, 1);
                    this.xmodelo2.setValueAt(xrs.getString(3), n, 2);
                    this.xmodelo2.setValueAt(xrs.getString(4), n, 3);
                    this.xmodelo2.setValueAt(xrs.getString(5), n, 4);
                    n++;
                }
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    public void mGuardar() {
        int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        if (n == 0) {
            if (this.xanaOclusal.equals("")) {
                String sql = "INSERT INTO `o_analisis_oclusal` ( `IdTratamiento`, `IdAtencion`, `IdUsuario`, `IdProfesional`, `IdEspecialidad`, FechaR, `Maloclusion`,  `ArcoSuperior`, `ArcoInferior`, `ApiSuperior`, `ApiSuperiormm`, `ApiInferior`, `ApiInferiormm`, `Denticion`, `CurvaSpee`, `Speemm`, `DTArcoSup`, `DTArcoInf`, `MCPDerecha`, `MCPDerechamm`, `MCPIzquierda`, `MCPIzquierdamm`, `MTijDerecha`, `MTijDermm`, `MTijIzquierda`, `MTijIzqmm`, `PlaSHoriz`, `PlaSHorizmm`, `PlaSVert`,  `PlaSVertmm`, `RelDerCanina`, `RelDerCaninamm`, `RelDerMolar`, `RelDerMolarmm`, `RelIzqCanina`, `RelIzqCaninamm`, `RelIzqMolar`, `RelIzqMolarmm`, `SobreMVert`, `SobreMVertPorc`, `MordAbieAnte`,  `MordAbieAntePorc`, `MordAbPostDer`, `MordAbPostDermm`, `MordAbPostIzq`, `MordAbPostIzqmm`,  `Observaciones`,UsuarioS) VALUES ('" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdTratamiento() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "', '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "',  '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "',  '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + this.xmt.formatoAMD.format(this.JDFecha.getDate()) + "','" + this.JCBMaloclusion.getSelectedItem() + "',  '" + this.JCBArcoSup.getSelectedItem() + "', '" + this.JCBArcoInf.getSelectedItem() + "', '" + this.JCBApiSup.getSelectedItem() + "', '" + this.JFTFMMApiSup.getValue() + "', '" + this.JCBApiInf.getSelectedItem() + "', '" + this.JFTFMMApiInf.getValue() + "', '" + this.JCBDenticion.getSelectedItem() + "', '" + this.JCBCurvaSpee.getSelectedItem() + "', '" + this.JFTFMMCurvaSpee.getValue() + "', '" + this.JCBTrasSuperior.getSelectedItem() + "', '" + this.JCBTrasInferior.getSelectedItem() + "', '" + this.JCBMedCruzadaPostDer.getSelectedItem() + "', '" + this.JFTFMMMCPostDer.getValue() + "', '" + this.JCBMedCruzadaPostIzq.getSelectedItem() + "', '" + this.JFTFMMMCPostIzq.getValue() + "', '" + this.JCBMordTijeraDer.getSelectedItem() + "', '" + this.JFTFMMMordTijeraDer.getValue() + "', '" + this.JCBMordTijeraIzq.getSelectedItem() + "', '" + this.JFTFMMMordTijeraIzq.getValue() + "', '" + this.JCBSobreMordHorztal.getSelectedItem() + "', '" + this.JFTFMMSobrMordHorztal.getValue() + "', '" + this.JCBMordCruzAnterior.getSelectedItem() + "', '" + this.JFTFMMMordCruzAnterior.getValue() + "', '" + this.JCBRelDerCanina.getSelectedItem() + "',  '" + this.JFTFMMRelDerCanina.getValue() + "', '" + this.JCBRelDerMolar.getSelectedItem() + "', '" + this.JFTFMMRelDerMolar.getValue() + "', '" + this.JCBRelIzqCanina.getSelectedItem() + "', '" + this.JFTFMMRelIzqCanina.getValue() + "',  '" + this.JCBRelIzqMolar.getSelectedItem() + "', '" + this.JFTFMMRelIzqMolar.getValue() + "',  '" + this.JCBSobreMordVertical.getSelectedItem() + "', '" + this.JFTFMMSobreMordVertical.getValue() + "', '" + this.JCBMordAbiertaAnt.getSelectedItem() + "', '" + this.JFTFMMMordAbiertaAnt.getValue() + "', '" + this.JCBMordAbiertaPostDer.getSelectedItem() + "', '" + this.JFTFMMMordAbiertaPostDer.getValue() + "', '" + this.JCBMordAbiertaPostIzq.getSelectedItem() + "', '" + this.JFTFMMMordAbiertaPostIzq.getValue() + "', '" + this.JTAObservacion.getText() + "','" + Principal.usuarioSistemaDTO.getLogin() + "')";
                this.xanaOclusal = this.xconsulta.ejecutarSQLId(sql);
            } else {
                String sql2 = "UPDATE `o_analisis_oclusal` SET `Maloclusion` = '" + this.JCBMaloclusion.getSelectedItem() + "',  `ArcoSuperior` = '" + this.JCBArcoSup.getSelectedItem() + "',  `ArcoInferior` = '" + this.JCBArcoInf.getSelectedItem() + "',  `ApiSuperior` = '" + this.JCBApiSup.getSelectedItem() + "',  `ApiSuperiormm` = '" + this.JFTFMMApiSup.getValue() + "',  `ApiInferior` = '" + this.JCBApiInf.getSelectedItem() + "',  `ApiInferiormm` = '" + this.JFTFMMApiInf.getValue() + "',  `Denticion` = '" + this.JCBDenticion.getSelectedItem() + "',  `CurvaSpee` = '" + this.JCBCurvaSpee.getSelectedItem() + "',  `Speemm` = '" + this.JFTFMMCurvaSpee.getValue() + "',  `DTArcoSup` = '" + this.JCBTrasSuperior.getSelectedItem() + "',  `DTArcoInf` = '" + this.JCBTrasInferior.getSelectedItem() + "',  `MCPDerecha` = '" + this.JCBMedCruzadaPostDer.getSelectedItem() + "',  `MCPDerechamm` = '" + this.JFTFMMMCPostDer.getValue() + "',  `MCPIzquierda` = '" + this.JCBMedCruzadaPostIzq.getSelectedItem() + "',  `MCPIzquierdamm` = '" + this.JFTFMMMCPostIzq.getValue() + "',  `MTijDerecha` = '" + this.JCBMordTijeraDer.getSelectedItem() + "',  `MTijDermm` = '" + this.JFTFMMMordTijeraDer.getValue() + "',  `MTijIzquierda` = '" + this.JCBMordTijeraIzq.getSelectedItem() + "',  `MTijIzqmm` = '" + this.JFTFMMMordTijeraIzq.getValue() + "',  `PlaSHoriz` = '" + this.JCBSobreMordHorztal.getSelectedItem() + "',  `PlaSHorizmm` = '" + this.JFTFMMSobrMordHorztal.getValue() + "',  `PlaSVert` = '" + this.JCBMordCruzAnterior.getSelectedItem() + "',  `PlaSVertmm` = '" + this.JFTFMMMordCruzAnterior.getValue() + "',  `RelDerCanina` = '" + this.JCBRelDerCanina.getSelectedItem() + "',  `RelDerCaninamm` = '" + this.JFTFMMRelDerCanina.getValue() + "',  `RelDerMolar` = '" + this.JCBRelDerMolar.getSelectedItem() + "',  `RelDerMolarmm` = '" + this.JFTFMMRelDerMolar.getValue() + "',  `RelIzqCanina` = '" + this.JCBRelIzqCanina.getSelectedItem() + "',  `RelIzqCaninamm` = '" + this.JFTFMMRelIzqCanina.getValue() + "',  `RelIzqMolar` = '" + this.JCBRelIzqMolar.getSelectedItem() + "',  `RelIzqMolarmm` = '" + this.JFTFMMRelIzqMolar.getValue() + "',  `SobreMVert` = '" + this.JCBSobreMordVertical.getSelectedItem() + "',  `SobreMVertPorc` = '" + this.JFTFMMSobreMordVertical.getValue() + "',  `MordAbieAnte` = '" + this.JCBMordAbiertaAnt.getSelectedItem() + "',  `MordAbieAntePorc` = '" + this.JFTFMMMordAbiertaAnt.getValue() + "',  `MordAbPostDer` = '" + this.JCBMordAbiertaPostDer.getSelectedItem() + "',  `MordAbPostDermm` = '" + this.JFTFMMMordAbiertaPostDer.getValue() + "',  `MordAbPostIzq` = '" + this.JCBMordAbiertaPostIzq.getSelectedItem() + "',  `MordAbPostIzqmm` = '" + this.JFTFMMMordAbiertaPostIzq.getValue() + "',  `Observaciones` = '" + this.JTAObservacion.getText() + "',  `UsuarioS` = '" + Principal.usuarioSistemaDTO.getLogin() + "'WHERE `Id` = '" + this.xanaOclusal + "'";
                this.xconsulta.ejecutarSQL(sql2);
            }
            this.xconsulta.cerrarConexionBd();
            this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            mBuscarHistorico();
        }
    }

    private String[] mllenarCombos(String xv, JComboBox xcombo) {
        this.xsql = "SELECT o_tipo_contenido_descripcion.Id, o_tipo_parametros.Nbre FROM o_tipo_descripcionxparametro INNER JOIN o_tipo_contenido_descripcion   ON (o_tipo_descripcionxparametro.Id_cdescipcion = o_tipo_contenido_descripcion.Id) INNER JOIN o_tipo_parametros  ON (o_tipo_descripcionxparametro.Id_TipoParametro = o_tipo_parametros.Id)  WHERE (o_tipo_contenido_descripcion.Id ='" + xv + "' AND o_tipo_descripcionxparametro.Estado =1) ORDER BY o_tipo_parametros.Nbre ASC, o_tipo_descripcionxparametro.NOrden ASC ";
        String[] xvalor = this.xconsulta.llenarCombo(this.xsql, null, xcombo);
        this.xconsulta.cerrarConexionBd();
        return xvalor;
    }

    private void mCargarCombosParametros() {
        this.xidmaloclusion = mllenarCombos("222", this.JCBMaloclusion);
        this.JCBMaloclusion.setSelectedIndex(-1);
        this.xidArcoSup = mllenarCombos("223", this.JCBArcoSup);
        this.JCBArcoSup.setSelectedIndex(-1);
        this.xidArcoInf = mllenarCombos("224", this.JCBArcoInf);
        this.JCBArcoInf.setSelectedIndex(-1);
        this.xidApiSup = mllenarCombos("88", this.JCBApiSup);
        this.JCBApiSup.setSelectedIndex(-1);
        this.xidApiInf = mllenarCombos("89", this.JCBApiInf);
        this.JCBApiInf.setSelectedIndex(-1);
        this.xidDenticion = mllenarCombos("90", this.JCBDenticion);
        this.JCBDenticion.setSelectedIndex(-1);
        this.xidCurSpee1 = mllenarCombos("225", this.JCBCurvaSpee);
        this.JCBCurvaSpee.setSelectedIndex(-1);
        this.xidTrasArcoSup = mllenarCombos("226", this.JCBTrasSuperior);
        this.JCBTrasSuperior.setSelectedIndex(-1);
        this.xidTrasArcoInf = mllenarCombos("227", this.JCBTrasInferior);
        this.JCBTrasInferior.setSelectedIndex(-1);
        this.xidCruzSupDerecha = mllenarCombos("91", this.JCBMedCruzadaPostDer);
        this.JCBMedCruzadaPostDer.setSelectedIndex(-1);
        this.xidCruzSupIzquierda = mllenarCombos("231", this.JCBMedCruzadaPostIzq);
        this.JCBMedCruzadaPostIzq.setSelectedIndex(-1);
        this.xidMordTijeraDer = mllenarCombos("92", this.JCBMordTijeraDer);
        this.JCBMordTijeraDer.setSelectedIndex(-1);
        this.xidMordTijeraIzq = mllenarCombos("232", this.JCBMordTijeraIzq);
        this.JCBMordTijeraIzq.setSelectedIndex(-1);
        this.xidSobrMordiHor = mllenarCombos("93", this.JCBSobreMordHorztal);
        this.JCBSobreMordHorztal.setSelectedIndex(-1);
        this.xidMordiCruzAnt = mllenarCombos("233", this.JCBMordCruzAnterior);
        this.JCBMordCruzAnterior.setSelectedIndex(-1);
        this.xidCaniRelDer = mllenarCombos("234", this.JCBRelDerCanina);
        this.JCBRelDerCanina.setSelectedIndex(-1);
        this.xidMolarRelDer = mllenarCombos("235", this.JCBRelDerMolar);
        this.JCBRelDerMolar.setSelectedIndex(-1);
        this.xidCaniRelDer = mllenarCombos("234", this.JCBRelIzqCanina);
        this.JCBRelIzqCanina.setSelectedIndex(-1);
        this.xidMolarRelDer = mllenarCombos("235", this.JCBRelIzqMolar);
        this.JCBRelIzqMolar.setSelectedIndex(-1);
        this.xidSobMordVertical = mllenarCombos("95", this.JCBSobreMordVertical);
        this.JCBSobreMordVertical.setSelectedIndex(-1);
        this.xidMordAbiertaAnt = mllenarCombos("96", this.JCBMordAbiertaAnt);
        this.JCBMordAbiertaAnt.setSelectedIndex(-1);
        this.xidMordAbirPostDer = mllenarCombos("97", this.JCBMordAbiertaPostDer);
        this.JCBMordAbiertaPostDer.setSelectedIndex(-1);
        this.xidMordAbirPostIzq = mllenarCombos("94", this.JCBMordAbiertaPostIzq);
        this.JCBMordAbiertaPostIzq.setSelectedIndex(-1);
    }

    /* JADX WARN: Type inference failed for: r3v298, types: [java.lang.Object[], java.lang.Object[][]] */
    private void initComponents() {
        this.JBGRM = new ButtonGroup();
        this.JBGuardar = new JButton();
        this.JPDatos = new JPanel();
        this.JDFecha = new JDateChooser();
        this.JSPObservacion = new JScrollPane();
        this.JTAObservacion = new JTextArea();
        this.JTPInformacion = new JTabbedPane();
        this.JSPFormulario = new JScrollPane();
        this.JPFormulario = new JPanel();
        this.JCBMaloclusion = new JComboBox();
        this.JCBArcoSup = new JComboBox();
        this.JFTFMMApiSup = new JFormattedTextField();
        this.JCBArcoInf = new JComboBox();
        this.JFTFMMApiInf = new JFormattedTextField();
        this.JCBApiSup = new JComboBox();
        this.JCBApiInf = new JComboBox();
        this.JCBDenticion = new JComboBox();
        this.JCBCurvaSpee = new JComboBox();
        this.JFTFMMCurvaSpee = new JFormattedTextField();
        this.JPPlanoTransversal = new JPanel();
        this.JCBTrasSuperior = new JComboBox();
        this.JCBTrasInferior = new JComboBox();
        this.JPMedCruzadaPosterior = new JPanel();
        this.JCBMedCruzadaPostDer = new JComboBox();
        this.JCBMedCruzadaPostIzq = new JComboBox();
        this.JFTFMMMCPostDer = new JFormattedTextField();
        this.JFTFMMMCPostIzq = new JFormattedTextField();
        this.JPMordTijera = new JPanel();
        this.JCBMordTijeraDer = new JComboBox();
        this.JCBMordTijeraIzq = new JComboBox();
        this.JFTFMMMordTijeraDer = new JFormattedTextField();
        this.JFTFMMMordTijeraIzq = new JFormattedTextField();
        this.JPPlanoSajital = new JPanel();
        this.JCBSobreMordHorztal = new JComboBox();
        this.JCBMordCruzAnterior = new JComboBox();
        this.JFTFMMSobrMordHorztal = new JFormattedTextField();
        this.JFTFMMMordCruzAnterior = new JFormattedTextField();
        this.JPClasificacionAngle = new JPanel();
        this.jLabel1 = new JLabel();
        this.JCBRelDerCanina = new JComboBox();
        this.JFTFMMRelDerCanina = new JFormattedTextField();
        this.JCBRelDerMolar = new JComboBox();
        this.JFTFMMRelDerMolar = new JFormattedTextField();
        this.jLabel2 = new JLabel();
        this.jLabel3 = new JLabel();
        this.jLabel4 = new JLabel();
        this.JCBRelIzqCanina = new JComboBox();
        this.JFTFMMRelIzqCanina = new JFormattedTextField();
        this.JCBRelIzqMolar = new JComboBox();
        this.JFTFMMRelIzqMolar = new JFormattedTextField();
        this.JPPlanoVertical = new JPanel();
        this.JCBSobreMordVertical = new JComboBox();
        this.JCBMordAbiertaAnt = new JComboBox();
        this.JFTFMMSobreMordVertical = new JFormattedTextField();
        this.JFTFMMMordAbiertaAnt = new JFormattedTextField();
        this.JPMordidaAbiertAnt = new JPanel();
        this.JCBMordAbiertaPostDer = new JComboBox();
        this.JFTFMMMordAbiertaPostDer = new JFormattedTextField();
        this.JCBMordAbiertaPostIzq = new JComboBox();
        this.JFTFMMMordAbiertaPostIzq = new JFormattedTextField();
        this.JPHistorico = new JPanel();
        this.JSPHistorico = new JScrollPane();
        this.JTHistorico = new JTable();
        setName("jpanalisisoclusal");
        this.JBGuardar.setFont(new Font("Arial", 1, 12));
        this.JBGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBGuardar.setText("Guardar");
        this.JBGuardar.addActionListener(new ActionListener() { // from class: Odontologia.JPAnalisiOclusal.2
            public void actionPerformed(ActionEvent evt) {
                JPAnalisiOclusal.this.JBGuardarActionPerformed(evt);
            }
        });
        this.JPDatos.setBorder(BorderFactory.createTitledBorder((Border) null, "DATOS", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.JDFecha.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JDFecha.setDateFormatString("dd/MM/yyyy");
        this.JDFecha.setFont(new Font("Tahoma", 1, 12));
        this.JDFecha.addKeyListener(new KeyAdapter() { // from class: Odontologia.JPAnalisiOclusal.3
            public void keyPressed(KeyEvent evt) {
                JPAnalisiOclusal.this.JDFechaKeyPressed(evt);
            }
        });
        this.JTAObservacion.setColumns(1);
        this.JTAObservacion.setFont(new Font("Arial", 0, 12));
        this.JTAObservacion.setLineWrap(true);
        this.JTAObservacion.setRows(1);
        this.JTAObservacion.setBorder(BorderFactory.createTitledBorder((Border) null, "Observación", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JSPObservacion.setViewportView(this.JTAObservacion);
        GroupLayout JPDatosLayout = new GroupLayout(this.JPDatos);
        this.JPDatos.setLayout(JPDatosLayout);
        JPDatosLayout.setHorizontalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addContainerGap().addComponent(this.JDFecha, -2, 130, -2).addGap(18, 18, 18).addComponent(this.JSPObservacion).addContainerGap()));
        JPDatosLayout.setVerticalGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPDatosLayout.createSequentialGroup().addGroup(JPDatosLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JDFecha, -1, 50, 32767).addComponent(this.JSPObservacion)).addContainerGap(-1, 32767)));
        this.JTPInformacion.setForeground(new Color(0, 107, 0));
        this.JTPInformacion.setFont(new Font("Arial", 1, 14));
        this.JSPFormulario.setBorder(BorderFactory.createTitledBorder((Border) null, "", 2, 0, new Font("Arial", 1, 14), new Color(0, 107, 0)));
        this.JSPFormulario.setHorizontalScrollBarPolicy(31);
        this.JSPFormulario.setAlignmentY(0.2f);
        this.JCBMaloclusion.setFont(new Font("Arial", 1, 12));
        this.JCBMaloclusion.setBorder(BorderFactory.createTitledBorder((Border) null, "Influencia de la Maloclusión en la Personalidad", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBArcoSup.setFont(new Font("Arial", 1, 12));
        this.JCBArcoSup.setBorder(BorderFactory.createTitledBorder((Border) null, "Arco Superior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMApiSup.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMApiSup.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMApiSup.setHorizontalAlignment(4);
        this.JFTFMMApiSup.setFont(new Font("Arial", 1, 12));
        this.JCBArcoInf.setFont(new Font("Arial", 1, 12));
        this.JCBArcoInf.setBorder(BorderFactory.createTitledBorder((Border) null, "Arco Inferior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMApiInf.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMApiInf.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMApiInf.setHorizontalAlignment(4);
        this.JFTFMMApiInf.setFont(new Font("Arial", 1, 12));
        this.JCBApiSup.setFont(new Font("Arial", 1, 12));
        this.JCBApiSup.setBorder(BorderFactory.createTitledBorder((Border) null, "Apiñamiento Superior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBApiInf.setFont(new Font("Arial", 1, 12));
        this.JCBApiInf.setBorder(BorderFactory.createTitledBorder((Border) null, "Apiñamiento Inferior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBDenticion.setFont(new Font("Arial", 1, 12));
        this.JCBDenticion.setBorder(BorderFactory.createTitledBorder((Border) null, "Dentición", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBCurvaSpee.setFont(new Font("Arial", 1, 12));
        this.JCBCurvaSpee.setBorder(BorderFactory.createTitledBorder((Border) null, "Curva Spee", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMCurvaSpee.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMCurvaSpee.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMCurvaSpee.setHorizontalAlignment(4);
        this.JFTFMMCurvaSpee.setFont(new Font("Arial", 1, 12));
        this.JPPlanoTransversal.setBorder(BorderFactory.createTitledBorder((Border) null, "Plano Trasnversal", 0, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JCBTrasSuperior.setFont(new Font("Arial", 1, 12));
        this.JCBTrasSuperior.setBorder(BorderFactory.createTitledBorder((Border) null, "Desarrollo trasversal Arco Superior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBTrasInferior.setFont(new Font("Arial", 1, 12));
        this.JCBTrasInferior.setBorder(BorderFactory.createTitledBorder((Border) null, "Desarrollo trasversal Arco Inferior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        GroupLayout JPPlanoTransversalLayout = new GroupLayout(this.JPPlanoTransversal);
        this.JPPlanoTransversal.setLayout(JPPlanoTransversalLayout);
        JPPlanoTransversalLayout.setHorizontalGroup(JPPlanoTransversalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanoTransversalLayout.createSequentialGroup().addComponent(this.JCBTrasSuperior, -2, 312, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addComponent(this.JCBTrasInferior, -2, 301, -2).addContainerGap()));
        JPPlanoTransversalLayout.setVerticalGroup(JPPlanoTransversalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanoTransversalLayout.createSequentialGroup().addGroup(JPPlanoTransversalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBTrasInferior, -2, 50, -2).addComponent(this.JCBTrasSuperior, -2, 50, -2)).addGap(3, 3, 3)));
        this.JPMedCruzadaPosterior.setBorder(BorderFactory.createTitledBorder((Border) null, "Mordida Cruzada Posterior", 0, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JCBMedCruzadaPostDer.setFont(new Font("Arial", 1, 12));
        this.JCBMedCruzadaPostDer.setBorder(BorderFactory.createTitledBorder((Border) null, "Derecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMedCruzadaPostIzq.setFont(new Font("Arial", 1, 12));
        this.JCBMedCruzadaPostIzq.setBorder(BorderFactory.createTitledBorder((Border) null, "Izquierda", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMMCPostDer.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMMCPostDer.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMMCPostDer.setHorizontalAlignment(4);
        this.JFTFMMMCPostDer.setFont(new Font("Arial", 1, 12));
        this.JFTFMMMCPostIzq.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMMCPostIzq.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMMCPostIzq.setHorizontalAlignment(4);
        this.JFTFMMMCPostIzq.setFont(new Font("Arial", 1, 12));
        GroupLayout JPMedCruzadaPosteriorLayout = new GroupLayout(this.JPMedCruzadaPosterior);
        this.JPMedCruzadaPosterior.setLayout(JPMedCruzadaPosteriorLayout);
        JPMedCruzadaPosteriorLayout.setHorizontalGroup(JPMedCruzadaPosteriorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMedCruzadaPosteriorLayout.createSequentialGroup().addComponent(this.JCBMedCruzadaPostDer, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMMCPostDer).addGap(35, 35, 35).addComponent(this.JCBMedCruzadaPostIzq, -2, 240, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFMMMCPostIzq).addGap(5, 5, 5)));
        JPMedCruzadaPosteriorLayout.setVerticalGroup(JPMedCruzadaPosteriorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMedCruzadaPosteriorLayout.createSequentialGroup().addGroup(JPMedCruzadaPosteriorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMedCruzadaPostDer, -2, 50, -2).addComponent(this.JFTFMMMCPostDer, -2, 50, -2).addGroup(JPMedCruzadaPosteriorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFMMMCPostIzq, -2, 50, -2).addComponent(this.JCBMedCruzadaPostIzq, -2, 50, -2))).addGap(5, 5, 5)));
        this.JPMordTijera.setBorder(BorderFactory.createTitledBorder((Border) null, "Mordida en Tijera", 0, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JCBMordTijeraDer.setFont(new Font("Arial", 1, 12));
        this.JCBMordTijeraDer.setBorder(BorderFactory.createTitledBorder((Border) null, "Derecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMordTijeraIzq.setFont(new Font("Arial", 1, 12));
        this.JCBMordTijeraIzq.setBorder(BorderFactory.createTitledBorder((Border) null, "Izquierda", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMMordTijeraDer.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMMordTijeraDer.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMMordTijeraDer.setHorizontalAlignment(4);
        this.JFTFMMMordTijeraDer.setFont(new Font("Arial", 1, 12));
        this.JFTFMMMordTijeraIzq.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMMordTijeraIzq.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMMordTijeraIzq.setHorizontalAlignment(4);
        this.JFTFMMMordTijeraIzq.setFont(new Font("Arial", 1, 12));
        GroupLayout JPMordTijeraLayout = new GroupLayout(this.JPMordTijera);
        this.JPMordTijera.setLayout(JPMordTijeraLayout);
        JPMordTijeraLayout.setHorizontalGroup(JPMordTijeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMordTijeraLayout.createSequentialGroup().addComponent(this.JCBMordTijeraDer, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMMordTijeraDer, -1, 98, 32767).addGap(35, 35, 35).addComponent(this.JCBMordTijeraIzq, -2, 240, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFMMMordTijeraIzq, -1, 98, 32767).addGap(5, 5, 5)));
        JPMordTijeraLayout.setVerticalGroup(JPMordTijeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMordTijeraLayout.createSequentialGroup().addGroup(JPMordTijeraLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMordTijeraDer, -2, 50, -2).addComponent(this.JFTFMMMordTijeraDer, -2, 50, -2).addGroup(JPMordTijeraLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFMMMordTijeraIzq, -2, 50, -2).addComponent(this.JCBMordTijeraIzq, -2, 50, -2))).addGap(5, 5, 5)));
        this.JPPlanoSajital.setBorder(BorderFactory.createTitledBorder((Border) null, "Plano Sagital", 0, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JCBSobreMordHorztal.setFont(new Font("Arial", 1, 12));
        this.JCBSobreMordHorztal.setBorder(BorderFactory.createTitledBorder((Border) null, "Sobremordida Horizontal", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMordCruzAnterior.setFont(new Font("Arial", 1, 12));
        this.JCBMordCruzAnterior.setBorder(BorderFactory.createTitledBorder((Border) null, "Mordida Cruzada Anterior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMSobrMordHorztal.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMSobrMordHorztal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMSobrMordHorztal.setHorizontalAlignment(4);
        this.JFTFMMSobrMordHorztal.setFont(new Font("Arial", 1, 12));
        this.JFTFMMMordCruzAnterior.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMMordCruzAnterior.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMMordCruzAnterior.setHorizontalAlignment(4);
        this.JFTFMMMordCruzAnterior.setFont(new Font("Arial", 1, 12));
        this.JPClasificacionAngle.setBorder(BorderFactory.createTitledBorder((Border) null, "Clasificación de Angle", 2, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setForeground(new Color(0, 0, 255));
        this.jLabel1.setText("Relación Derecha");
        this.JCBRelDerCanina.setFont(new Font("Arial", 1, 12));
        this.JCBRelDerCanina.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMRelDerCanina.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMRelDerCanina.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMRelDerCanina.setHorizontalAlignment(4);
        this.JFTFMMRelDerCanina.setFont(new Font("Arial", 1, 12));
        this.JCBRelDerMolar.setFont(new Font("Arial", 1, 12));
        this.JCBRelDerMolar.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMRelDerMolar.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMRelDerMolar.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMRelDerMolar.setHorizontalAlignment(4);
        this.JFTFMMRelDerMolar.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setForeground(new Color(0, 0, 255));
        this.jLabel2.setHorizontalAlignment(0);
        this.jLabel2.setText("CANINA");
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setForeground(new Color(0, 0, 255));
        this.jLabel3.setHorizontalAlignment(0);
        this.jLabel3.setText("MOLAR");
        this.jLabel4.setFont(new Font("Arial", 1, 12));
        this.jLabel4.setForeground(new Color(0, 0, 255));
        this.jLabel4.setText("Relación Izquierda");
        this.JCBRelIzqCanina.setFont(new Font("Arial", 1, 12));
        this.JCBRelIzqCanina.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMRelIzqCanina.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMRelIzqCanina.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMRelIzqCanina.setHorizontalAlignment(4);
        this.JFTFMMRelIzqCanina.setFont(new Font("Arial", 1, 12));
        this.JCBRelIzqMolar.setFont(new Font("Arial", 1, 12));
        this.JCBRelIzqMolar.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMRelIzqMolar.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMRelIzqMolar.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMRelIzqMolar.setHorizontalAlignment(4);
        this.JFTFMMRelIzqMolar.setFont(new Font("Arial", 1, 12));
        GroupLayout JPClasificacionAngleLayout = new GroupLayout(this.JPClasificacionAngle);
        this.JPClasificacionAngle.setLayout(JPClasificacionAngleLayout);
        JPClasificacionAngleLayout.setHorizontalGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addContainerGap().addGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 100, -2).addComponent(this.jLabel4, -2, 110, -2)).addGap(18, 18, 18).addGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addGap(59, 59, 59).addComponent(this.jLabel2, -2, 100, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel3, -2, 100, -2).addGap(58, 58, 58)).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, JPClasificacionAngleLayout.createSequentialGroup().addComponent(this.JCBRelIzqCanina, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMRelIzqCanina, -1, 95, 32767)).addGroup(GroupLayout.Alignment.LEADING, JPClasificacionAngleLayout.createSequentialGroup().addComponent(this.JCBRelDerCanina, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMRelDerCanina))).addGap(54, 54, 54).addGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addComponent(this.JCBRelDerMolar, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMRelDerMolar, -1, 96, 32767)).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addComponent(this.JCBRelIzqMolar, -2, 129, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMRelIzqMolar))))).addGap(37, 37, 37)));
        JPClasificacionAngleLayout.setVerticalGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addGap(4, 4, 4).addComponent(this.jLabel2)).addComponent(this.jLabel3)).addGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addGap(6, 6, 6).addGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFMMRelDerMolar, -2, 50, -2).addComponent(this.JCBRelDerMolar, -2, 50, -2).addComponent(this.JFTFMMRelDerCanina, -2, 50, -2).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jLabel1)).addComponent(this.JCBRelDerCanina, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPClasificacionAngleLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFMMRelIzqMolar, -2, 50, -2).addComponent(this.JCBRelIzqMolar, -2, 50, -2).addComponent(this.JFTFMMRelIzqCanina, -2, 50, -2).addComponent(this.JCBRelIzqCanina, -2, 50, -2))).addGroup(JPClasificacionAngleLayout.createSequentialGroup().addGap(76, 76, 76).addComponent(this.jLabel4))).addGap(10, 10, 10)));
        GroupLayout JPPlanoSajitalLayout = new GroupLayout(this.JPPlanoSajital);
        this.JPPlanoSajital.setLayout(JPPlanoSajitalLayout);
        JPPlanoSajitalLayout.setHorizontalGroup(JPPlanoSajitalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, JPPlanoSajitalLayout.createSequentialGroup().addGroup(JPPlanoSajitalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.JPClasificacionAngle, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(JPPlanoSajitalLayout.createSequentialGroup().addComponent(this.JCBSobreMordHorztal, -2, 220, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMSobrMordHorztal).addGap(35, 35, 35).addComponent(this.JCBMordCruzAnterior, -2, 240, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFMMMordCruzAnterior))).addContainerGap()));
        JPPlanoSajitalLayout.setVerticalGroup(JPPlanoSajitalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanoSajitalLayout.createSequentialGroup().addGroup(JPPlanoSajitalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSobreMordHorztal, -2, 50, -2).addComponent(this.JFTFMMSobrMordHorztal, -2, 50, -2).addGroup(JPPlanoSajitalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFMMMordCruzAnterior, -2, 50, -2).addComponent(this.JCBMordCruzAnterior, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPClasificacionAngle, -2, -1, -2)));
        this.JPPlanoVertical.setBorder(BorderFactory.createTitledBorder((Border) null, "Plano Vertical", 0, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JCBSobreMordVertical.setFont(new Font("Arial", 1, 12));
        this.JCBSobreMordVertical.setBorder(BorderFactory.createTitledBorder((Border) null, "Sobre Mordida Vertical", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JCBMordAbiertaAnt.setFont(new Font("Arial", 1, 12));
        this.JCBMordAbiertaAnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Mordida Abierta Anterior", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMSobreMordVertical.setBorder(BorderFactory.createTitledBorder((Border) null, "%", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMSobreMordVertical.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMSobreMordVertical.setHorizontalAlignment(4);
        this.JFTFMMSobreMordVertical.setFont(new Font("Arial", 1, 12));
        this.JFTFMMMordAbiertaAnt.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMMordAbiertaAnt.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMMordAbiertaAnt.setHorizontalAlignment(4);
        this.JFTFMMMordAbiertaAnt.setFont(new Font("Arial", 1, 12));
        this.JPMordidaAbiertAnt.setBorder(BorderFactory.createTitledBorder((Border) null, "Mordida Abierta Posterior", 0, 0, new Font("Arial", 1, 12), new Color(0, 107, 0)));
        this.JCBMordAbiertaPostDer.setFont(new Font("Arial", 1, 12));
        this.JCBMordAbiertaPostDer.setBorder(BorderFactory.createTitledBorder((Border) null, "Derecha", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMMordAbiertaPostDer.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMMordAbiertaPostDer.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMMordAbiertaPostDer.setHorizontalAlignment(4);
        this.JFTFMMMordAbiertaPostDer.setFont(new Font("Arial", 1, 12));
        this.JCBMordAbiertaPostIzq.setFont(new Font("Arial", 1, 12));
        this.JCBMordAbiertaPostIzq.setBorder(BorderFactory.createTitledBorder((Border) null, "Izquierda", 0, 0, new Font("Arial", 1, 12), Color.blue));
        this.JFTFMMMordAbiertaPostIzq.setBorder(BorderFactory.createTitledBorder((Border) null, "mm", 0, 0, new Font("Arial", 1, 12), new Color(0, 0, 255)));
        this.JFTFMMMordAbiertaPostIzq.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        this.JFTFMMMordAbiertaPostIzq.setHorizontalAlignment(4);
        this.JFTFMMMordAbiertaPostIzq.setFont(new Font("Arial", 1, 12));
        GroupLayout JPMordidaAbiertAntLayout = new GroupLayout(this.JPMordidaAbiertAnt);
        this.JPMordidaAbiertAnt.setLayout(JPMordidaAbiertAntLayout);
        JPMordidaAbiertAntLayout.setHorizontalGroup(JPMordidaAbiertAntLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMordidaAbiertAntLayout.createSequentialGroup().addGap(3, 3, 3).addComponent(this.JCBMordAbiertaPostDer, -2, 208, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMMordAbiertaPostDer, -1, 92, 32767).addGap(49, 49, 49).addComponent(this.JCBMordAbiertaPostIzq, -2, 208, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JFTFMMMordAbiertaPostIzq, -1, 92, 32767).addGap(26, 26, 26)));
        JPMordidaAbiertAntLayout.setVerticalGroup(JPMordidaAbiertAntLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPMordidaAbiertAntLayout.createSequentialGroup().addGroup(JPMordidaAbiertAntLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBMordAbiertaPostDer, -2, 50, -2).addComponent(this.JFTFMMMordAbiertaPostDer, -2, 50, -2).addComponent(this.JCBMordAbiertaPostIzq, -2, 50, -2).addComponent(this.JFTFMMMordAbiertaPostIzq, -2, 50, -2)).addGap(5, 5, 5)));
        GroupLayout JPPlanoVerticalLayout = new GroupLayout(this.JPPlanoVertical);
        this.JPPlanoVertical.setLayout(JPPlanoVerticalLayout);
        JPPlanoVerticalLayout.setHorizontalGroup(JPPlanoVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanoVerticalLayout.createSequentialGroup().addGroup(JPPlanoVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanoVerticalLayout.createSequentialGroup().addGroup(JPPlanoVerticalLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBMordAbiertaAnt, 0, -1, 32767).addComponent(this.JCBSobreMordVertical, 0, 220, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPPlanoVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JFTFMMSobreMordVertical, -1, 94, 32767).addComponent(this.JFTFMMMordAbiertaAnt)).addGap(0, 0, 32767)).addComponent(this.JPMordidaAbiertAnt, -1, -1, 32767)).addContainerGap()));
        JPPlanoVerticalLayout.setVerticalGroup(JPPlanoVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPPlanoVerticalLayout.createSequentialGroup().addGroup(JPPlanoVerticalLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBSobreMordVertical, -2, 50, -2).addComponent(this.JFTFMMSobreMordVertical, -2, 50, -2)).addGap(5, 5, 5).addGroup(JPPlanoVerticalLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JFTFMMMordAbiertaAnt, -2, 50, -2).addComponent(this.JCBMordAbiertaAnt, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPMordidaAbiertAnt, -2, -1, -2)));
        GroupLayout JPFormularioLayout = new GroupLayout(this.JPFormulario);
        this.JPFormulario.setLayout(JPFormularioLayout);
        JPFormularioLayout.setHorizontalGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormularioLayout.createSequentialGroup().addContainerGap().addGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPPlanoVertical, -2, -1, -2).addComponent(this.JPPlanoSajital, -2, -1, -2).addGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JPMedCruzadaPosterior, -1, -1, 32767).addComponent(this.JPMordTijera, -2, -1, -2)).addComponent(this.JPPlanoTransversal, -2, -1, -2).addGroup(JPFormularioLayout.createSequentialGroup().addGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.JCBMaloclusion, 0, -1, 32767).addComponent(this.JCBArcoSup, -2, 318, -2)).addGap(18, 18, 18).addComponent(this.JCBArcoInf, -2, 318, -2)).addGroup(JPFormularioLayout.createSequentialGroup().addGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.JCBDenticion, GroupLayout.Alignment.LEADING, 0, -1, 32767).addGroup(JPFormularioLayout.createSequentialGroup().addComponent(this.JCBApiSup, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFMMApiSup, -2, 84, -2))).addGap(18, 18, 18).addComponent(this.JCBApiInf, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFMMApiInf, -2, 84, -2)).addGroup(JPFormularioLayout.createSequentialGroup().addComponent(this.JCBCurvaSpee, -2, 224, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.JFTFMMCurvaSpee, -2, 84, -2))).addGap(0, 96, 32767)));
        JPFormularioLayout.setVerticalGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPFormularioLayout.createSequentialGroup().addContainerGap().addComponent(this.JCBMaloclusion, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JCBArcoSup, -2, 50, -2).addComponent(this.JCBArcoInf, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JFTFMMApiInf, -2, 50, -2).addComponent(this.JCBApiInf, -2, 50, -2).addGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(JPFormularioLayout.createSequentialGroup().addGap(1, 1, 1).addComponent(this.JFTFMMApiSup)).addComponent(this.JCBApiSup, -2, 50, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JCBDenticion, -2, 50, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(JPFormularioLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JCBCurvaSpee, -2, 50, -2).addComponent(this.JFTFMMCurvaSpee, -2, 50, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPlanoTransversal, -2, -1, -2).addGap(5, 5, 5).addComponent(this.JPMedCruzadaPosterior, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPMordTijera, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPlanoSajital, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JPPlanoVertical, -2, -1, -2).addContainerGap(-1, 32767)));
        this.JSPFormulario.setViewportView(this.JPFormulario);
        this.JTPInformacion.addTab("ANÁLISIS OCLUSAL", this.JSPFormulario);
        this.JTHistorico.setFont(new Font("Arial", 1, 12));
        this.JTHistorico.setModel(new DefaultTableModel((Object[][]) new Object[]{new Object[0], new Object[0], new Object[0], new Object[0]}, new String[0]));
        this.JTHistorico.setSelectionBackground(new Color(255, 255, 255));
        this.JTHistorico.setSelectionForeground(new Color(255, 0, 0));
        this.JTHistorico.addMouseListener(new MouseAdapter() { // from class: Odontologia.JPAnalisiOclusal.4
            public void mouseClicked(MouseEvent evt) {
                JPAnalisiOclusal.this.JTHistoricoMouseClicked(evt);
            }
        });
        this.JSPHistorico.setViewportView(this.JTHistorico);
        GroupLayout JPHistoricoLayout = new GroupLayout(this.JPHistorico);
        this.JPHistorico.setLayout(JPHistoricoLayout);
        JPHistoricoLayout.setHorizontalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 814, 32767).addContainerGap()));
        JPHistoricoLayout.setVerticalGroup(JPHistoricoLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(JPHistoricoLayout.createSequentialGroup().addContainerGap().addComponent(this.JSPHistorico, -1, 459, 32767).addContainerGap()));
        this.JTPInformacion.addTab("HISTÓRICO", this.JPHistorico);
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JPDatos, -1, -1, 32767).addComponent(this.JBGuardar, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.JTPInformacion)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.JPDatos, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JTPInformacion, -2, 512, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, 32767).addComponent(this.JBGuardar, -2, 34, -2).addContainerGap()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBGuardarActionPerformed(ActionEvent evt) {
        mGuardar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JDFechaKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JTHistoricoMouseClicked(MouseEvent evt) {
        mVerificaAnalisisAtencion();
    }

    private void mBuscarDatosBD(int xid) {
        String sql = "SELECT `FechaR`, `Maloclusion`, `ArcoSuperior`, `ArcoInferior`, `ApiSuperior`,  `ApiSuperiormm`, `ApiInferior`,  `ApiInferiormm`, `Denticion`, `CurvaSpee`, `Speemm`, `DTArcoSup`, `DTArcoInf`, `LMFacial`, `LMDSupe`, `LMDSupemm`, `LMDInfe`, `LMDInfemm`, `MCPDerecha`, `MCPDerechamm`, `MCPIzquierda`, `MCPIzquierdamm`, `MTijDerecha`, `MTijDermm`, `MTijIzquierda`, `MTijIzqmm`, `PlaSHoriz`, `PlaSHorizmm`, `PlaSVert`, `PlaSVertmm`, `RelDerCanina`, `RelDerCaninamm`, `RelDerMolar`, `RelDerMolarmm`, `RelIzqCanina`, `RelIzqCaninamm`, `RelIzqMolar`, `RelIzqMolarmm`, `SobreMVert`, `SobreMVertPorc`, `MordAbieAnte`,  `MordAbieAntePorc`, `MordAbPostDer`, `MordAbPostDermm`, `MordAbPostIzq`, `MordAbPostIzqmm`, `DteAus`, `DteImp`, `DteIncl`, `DteErup`, `Migraciones`, `Inclinaciones`, `Rotacion`, `Diastemas`, `Aplica`, `ESRequerido`, `ESDisponible`, `ESDiferencia`, `ESDiamSup`, `ESArcInci`, `EIRequerido`, `EIDisponible`, `EIDiferencia`,  `CurvaSpeecbo`, `CurvaSpeecbomm`, `MitadAnchoMD`, `DiaMD32`, `DiaMD31`, `DiaMD41`, `DiaMD42`, `DiaMDTot_1`, `Tot_1_Div2`, `Val_10_5`, `Val33`, `DiaMD12`, `DiaMD11`, `DiaMD21`, `DiaMD22`, `DiaMDTot_2`, `Tot_2_Div2`, `Val_11`, `Val_13_14`, `IndiceBolton`, `Sum_sup`, `Sum_Inf`, `Sum_tabla`, `ExcMax`, `ExcMand`, `DefMax`, `DefMand`, `Observaciones` FROM `o_analisis_oclusal` WHERE (Id='" + xid + "')";
        ResultSet xrs = this.xconsulta.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                this.JTAObservacion.setText(xrs.getString("Observaciones"));
                this.JFTFMMMordAbiertaPostIzq.setValue(Double.valueOf(xrs.getDouble("MordAbPostIzqmm")));
                this.JCBMordAbiertaPostIzq.setSelectedItem(xrs.getString("MordAbPostIzq"));
                this.JFTFMMMordAbiertaPostDer.setValue(Double.valueOf(xrs.getDouble("MordAbPostDermm")));
                this.JCBMordAbiertaPostDer.setSelectedItem(xrs.getString("MordAbPostDer"));
                this.JFTFMMMordAbiertaAnt.setValue(Double.valueOf(xrs.getDouble("MordAbieAntePorc")));
                this.JCBMordAbiertaAnt.setSelectedItem(xrs.getString("MordAbieAnte"));
                this.JFTFMMSobreMordVertical.setValue(Double.valueOf(xrs.getDouble("SobreMVertPorc")));
                this.JCBSobreMordVertical.setSelectedItem(xrs.getString("SobreMVert"));
                this.JFTFMMRelIzqMolar.setValue(Double.valueOf(xrs.getDouble("RelIzqMolarmm")));
                this.JCBRelIzqMolar.setSelectedItem(xrs.getString("RelIzqMolar"));
                this.JFTFMMRelIzqCanina.setValue(Double.valueOf(xrs.getDouble("RelIzqCaninamm")));
                this.JCBRelIzqCanina.setSelectedItem(xrs.getString("RelIzqCanina"));
                this.JFTFMMRelDerMolar.setValue(Double.valueOf(xrs.getDouble("RelDerMolarmm")));
                this.JCBRelDerMolar.setSelectedItem(xrs.getString("RelDerMolar"));
                this.JFTFMMRelDerCanina.setValue(Double.valueOf(xrs.getDouble("RelDerCaninamm")));
                this.JCBRelDerCanina.setSelectedItem(xrs.getString("RelDerCanina"));
                this.JFTFMMMordCruzAnterior.setValue(Double.valueOf(xrs.getDouble("PlaSVertmm")));
                this.JCBMordCruzAnterior.setSelectedItem(xrs.getString("PlaSVert"));
                this.JFTFMMSobrMordHorztal.setValue(Double.valueOf(xrs.getDouble("PlaSHorizmm")));
                this.JCBSobreMordHorztal.setSelectedItem(xrs.getString("PlaSHoriz"));
                this.JFTFMMMordTijeraIzq.setValue(Double.valueOf(xrs.getDouble("MTijIzqmm")));
                this.JCBMordTijeraIzq.setSelectedItem(xrs.getString("MTijIzquierda"));
                this.JFTFMMMordTijeraDer.setValue(Double.valueOf(xrs.getDouble("MTijDermm")));
                this.JCBMordTijeraDer.setSelectedItem(xrs.getString("MTijDerecha"));
                this.JFTFMMMCPostIzq.setValue(Double.valueOf(xrs.getDouble("MCPIzquierdamm")));
                this.JCBMedCruzadaPostIzq.setSelectedItem(xrs.getString("MCPIzquierda"));
                this.JFTFMMMCPostDer.setValue(Double.valueOf(xrs.getDouble("MCPDerechamm")));
                this.JCBMedCruzadaPostDer.setSelectedItem(xrs.getString("MCPDerecha"));
                this.JCBTrasInferior.setSelectedItem(xrs.getString("DTArcoInf"));
                this.JCBTrasSuperior.setSelectedItem(xrs.getString("DTArcoSup"));
                this.JFTFMMCurvaSpee.setValue(Double.valueOf(xrs.getDouble("Speemm")));
                this.JCBCurvaSpee.setSelectedItem(xrs.getString("CurvaSpee"));
                this.JCBDenticion.setSelectedItem(xrs.getString("Denticion"));
                this.JDFecha.setDate(xrs.getDate("FechaR"));
                this.JCBMaloclusion.setSelectedItem(xrs.getString("Maloclusion"));
                this.JCBArcoSup.setSelectedItem(xrs.getString("ArcoSuperior"));
                this.JCBArcoInf.setSelectedItem(xrs.getString("ArcoInferior"));
                this.JCBApiSup.setSelectedItem(xrs.getString("ApiSuperior"));
                this.JFTFMMApiSup.setValue(Double.valueOf(xrs.getDouble("ApiSuperiormm")));
                this.JCBApiInf.setSelectedItem(xrs.getString("ApiInferior"));
                this.JFTFMMApiInf.setValue(Double.valueOf(xrs.getDouble("ApiInferiormm")));
            }
            xrs.close();
            this.xconsulta.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mVerificaAnalisisAtencion() {
        String sql = "SELECT `Id`  , `IdAtencion` FROM `o_analisis_oclusal` WHERE (`IdUsuario` = '" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdUsuarioAtendido() + "' AND `IdAtencion` ='" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "')";
        ConsultasMySQL xct = new ConsultasMySQL();
        ResultSet xrs = xct.traerRs(sql);
        try {
            if (xrs.next()) {
                xrs.first();
                mBuscarDatosBD(xrs.getInt("Id"));
                this.xanaOclusal = xrs.getString("Id");
                this.JTPInformacion.setSelectedIndex(0);
                this.xmt.cambiarEstadoValidadoItemHC(getName(), 1, true);
            }
            xrs.close();
            xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(JPAnalisiOclusal.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }
}
