package Historia;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.genoma.plus.dto.historia.colposcopia.ColposcopiaDetalleDTO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/* JADX INFO: loaded from: GenomaP.jar:Historia/JPAColposcopia.class */
public class JPAColposcopia extends JPanel {
    private String xnombre;
    private String nombreItems;
    private clasesHistoriaCE xclase;
    public DefaultTableModel xmodelo;
    public DefaultTableModel xmodeloh;
    private Object[] xdatos;
    private JButton Imprimir;
    private JButton JBTGuardar;
    private JLabel JLBNumero;
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup10;
    private ButtonGroup buttonGroup11;
    private ButtonGroup buttonGroup12;
    private ButtonGroup buttonGroup13;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;
    private ButtonGroup buttonGroup4;
    private ButtonGroup buttonGroup5;
    private ButtonGroup buttonGroup6;
    private ButtonGroup buttonGroup7;
    private ButtonGroup buttonGroup8;
    private ButtonGroup buttonGroup9;
    private JRadioButton evGenAdecuada;
    private JRadioButton evGenInadecuada;
    private JCheckBox jChAperturasGlandulares;
    private JCheckBox jChAperturasGlandularesConBordesGruesos;
    private JCheckBox jChAtrofica;
    private JCheckBox jChBordeInterno;
    private JCheckBox jChBordeIrregular;
    private JCheckBox jChCarcinomaInvasivo;
    private JCheckBox jChEpitelioAcetoblancoDenso;
    private JCheckBox jChEpitelioAcetoblancoTenue;
    private JCheckBox jChErosion;
    private JCheckBox jChImprDiagnosticaotra;
    private JCheckBox jChInflamatoria;
    private JCheckBox jChInvacionOtros;
    private JCheckBox jChLesionExofitica;
    private JCheckBox jChLeucoplasia;
    private JCheckBox jChLieDeAltoGrado;
    private JCheckBox jChLieDeBajoGrado;
    private JCheckBox jChMosaicoFino;
    private JCheckBox jChMosaicoGrueso;
    private JCheckBox jChNecrosis;
    private JCheckBox jChNormal;
    private JCheckBox jChPunteadoFino;
    private JCheckBox jChPunteadoGrueso;
    private JCheckBox jChQuistesNaboth;
    private JCheckBox jChSignoDeLaCresta;
    private JCheckBox jChSugestivaDeVph;
    private JCheckBox jChSuperficieIrregular;
    private JCheckBox jChTumorNodular;
    private JCheckBox jChVasosAtipicos;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel10;
    private JPanel jPanel11;
    private JPanel jPanel12;
    private JPanel jPanel13;
    private JPanel jPanel14;
    private JPanel jPanel15;
    private JPanel jPanel16;
    private JPanel jPanel17;
    private JPanel jPanel18;
    private JPanel jPanel19;
    private JPanel jPanel2;
    private JPanel jPanel20;
    private JPanel jPanel21;
    private JPanel jPanel22;
    private JPanel jPanel23;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JPanel jPanel8;
    private JPanel jPanel9;
    private JRadioButton jRBiopsiaNO;
    private JRadioButton jRBiopsiaSI;
    private JRadioButton jRCompVisible;
    private JRadioButton jREnLaZonaDeTransformacion;
    private JRadioButton jREpitelioColumnarEctopico;
    private JRadioButton jREpitelioColumnarNormal;
    private JRadioButton jREpitelioEscamosoOriginalAtrofico;
    private JRadioButton jREpitelioEscamosoOriginalMaduro;
    private JRadioButton jRFueraDeLaZonaDeTransformacion;
    private JRadioButton jRNoVisible;
    private JRadioButton jRParcVisible;
    private JRadioButton jRSchillerNegativo;
    private JRadioButton jRSchillerPositivo;
    private JRadioButton jRTipo1;
    private JRadioButton jRTipo2;
    private JRadioButton jRTipo3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JTextArea jTBiopsiaDescripcion;
    private JTextField jTDiagnosticoUltimaCit;
    private JTextField jTFechaUltimaCitologia;
    private JTextField jTInmunosupresion;
    private JTextArea jTOtrosHallazgos;
    private JTextField jTVih;
    private ConsultasMySQL xconsultasbd = new ConsultasMySQL();
    private Metodos xmetodo = new Metodos();
    ObjectMapper objectMapper = new ObjectMapper();

    public JPAColposcopia() {
        initComponents();
    }

    public JPAColposcopia(String nombre, clasesHistoriaCE xclase, String nombreItems) {
        initComponents();
        this.xclase = xclase;
        this.nombreItems = nombreItems;
        setBorder(BorderFactory.createTitledBorder((Border) null, clasesHistoriaCE.informacionAgendaMedicaDTO.getNombreTipoConsulta(), 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.xnombre = nombre;
        setName(nombre);
        recuperarColposcopiaAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
    }

    public ColposcopiaDetalleDTO recuperarColposcopiaAtencion(String idAtencion) {
        ResultSet xrs;
        Throwable th;
        String sql = "select  *from h_colposcopia hcp\nwhere hcp.idAtencion ='" + idAtencion + "'\nORDER BY hcp.id ASC\nLIMIT 1;";
        try {
            xrs = this.xconsultasbd.traerRs(sql);
            th = null;
        } catch (Exception e) {
            this.xconsultasbd.cerrarConexionBd();
            System.out.println("ERROR, " + e.getMessage());
        }
        try {
            try {
                if (!xrs.first()) {
                    if (xrs != null) {
                        if (0 != 0) {
                            try {
                                xrs.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            xrs.close();
                        }
                    }
                    this.xconsultasbd.cerrarConexionBd();
                    return null;
                }
                String jsonString = xrs.getString(5);
                ColposcopiaDetalleDTO detalleDto = (ColposcopiaDetalleDTO) this.objectMapper.readValue(jsonString.replace("\n", "\\n").replace("\r", "\\r"), ColposcopiaDetalleDTO.class);
                if (detalleDto != null) {
                    voidSetearValoresPantalla(detalleDto, xrs.getString(1));
                }
                this.xconsultasbd.cerrarConexionBd();
                if (xrs != null) {
                    if (0 != 0) {
                        try {
                            xrs.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    } else {
                        xrs.close();
                    }
                }
                return detalleDto;
                this.xconsultasbd.cerrarConexionBd();
                return null;
            } finally {
            }
        } finally {
        }
        this.xconsultasbd.cerrarConexionBd();
        System.out.println("ERROR, " + e.getMessage());
    }

    public void voidSetearValoresPantalla(ColposcopiaDetalleDTO detalle, String idColposcopiaActual) {
        this.jTVih.setText(detalle.getVih());
        this.jTInmunosupresion.setText(detalle.getInmunosupresion());
        this.jTFechaUltimaCitologia.setText(detalle.getFechaUltCitologia());
        this.jTDiagnosticoUltimaCit.setText(detalle.getDiagnosticoUltCitologia());
        this.evGenAdecuada.setSelected(detalle.getAdecuada().booleanValue());
        this.evGenInadecuada.setSelected(detalle.getInadecuada().booleanValue());
        this.jRCompVisible.setSelected(detalle.getCompVisible().booleanValue());
        this.jRParcVisible.setSelected(detalle.getParcVisible().booleanValue());
        this.jRNoVisible.setSelected(detalle.getNoVisible().booleanValue());
        this.jRTipo1.setSelected(Objects.equals(detalle.getTipo(), "1"));
        this.jRTipo2.setSelected(Objects.equals(detalle.getTipo(), "2"));
        this.jRTipo3.setSelected(Objects.equals(detalle.getTipo(), "3"));
        this.jREpitelioEscamosoOriginalMaduro.setSelected(detalle.getEpitelioEscamosoOriginalMaduro().booleanValue());
        this.jREpitelioEscamosoOriginalAtrofico.setSelected(detalle.getEpitelioEscamosoOriginalAtrofico().booleanValue());
        this.jREpitelioColumnarNormal.setSelected(detalle.getEpitelioColumnarNormal().booleanValue());
        this.jREpitelioColumnarEctopico.setSelected(detalle.getEpitelioColumnarEctopico().booleanValue());
        this.jChQuistesNaboth.setSelected(detalle.getQuistesNaboth().booleanValue());
        this.jChAperturasGlandulares.setSelected(detalle.getAperturasGlandulares().booleanValue());
        this.jChEpitelioAcetoblancoTenue.setSelected(detalle.getEpitelioAcetoblancoTenue().booleanValue());
        this.jChBordeIrregular.setSelected(detalle.getBordeIrregular().booleanValue());
        this.jChPunteadoFino.setSelected(detalle.getPunteadoFino().booleanValue());
        this.jChMosaicoFino.setSelected(detalle.getMosaicoFino().booleanValue());
        this.jChEpitelioAcetoblancoDenso.setSelected(detalle.getEpitelioAcetoblancoDenso().booleanValue());
        this.jChSignoDeLaCresta.setSelected(detalle.getSignoDeLaCresta().booleanValue());
        this.jChMosaicoGrueso.setSelected(detalle.getMosaicoGrueso().booleanValue());
        this.jChBordeInterno.setSelected(detalle.getBordeInterno().booleanValue());
        this.jChPunteadoGrueso.setSelected(detalle.getPunteadoGrueso().booleanValue());
        this.jChAperturasGlandularesConBordesGruesos.setSelected(detalle.getAperturasGlandularesConBordesGruesos().booleanValue());
        this.jChLeucoplasia.setSelected(detalle.getLeucoplasia().booleanValue());
        this.jChErosion.setSelected(detalle.getErosion().booleanValue());
        this.jRSchillerPositivo.setSelected(Boolean.TRUE.equals(detalle.getSchiller()));
        this.jRSchillerNegativo.setSelected(Boolean.FALSE.equals(detalle.getSchiller()));
        this.jREnLaZonaDeTransformacion.setSelected(detalle.getEnLaZonaDeTransformacion().booleanValue());
        this.jRFueraDeLaZonaDeTransformacion.setSelected(detalle.getFueraDeLaZonaDeTransformacion().booleanValue());
        this.jChVasosAtipicos.setSelected(detalle.getVasosAtipicos().booleanValue());
        this.jChNecrosis.setSelected(detalle.getNecrosis().booleanValue());
        this.jChSuperficieIrregular.setSelected(detalle.getSuperficieIrregular().booleanValue());
        this.jChTumorNodular.setSelected(detalle.getTumorNodular().booleanValue());
        this.jChLesionExofitica.setSelected(detalle.getLesionExofitica().booleanValue());
        this.jChInvacionOtros.setSelected(detalle.getInvacionOtros().booleanValue());
        this.jChNormal.setSelected(detalle.getNormal().booleanValue());
        this.jChLieDeBajoGrado.setSelected(detalle.getLieDeBajoGrado().booleanValue());
        this.jChInflamatoria.setSelected(detalle.getInflamatoria().booleanValue());
        this.jChLieDeAltoGrado.setSelected(detalle.getLieDeAltoGrado().booleanValue());
        this.jChAtrofica.setSelected(detalle.getAtrofica().booleanValue());
        this.jChCarcinomaInvasivo.setSelected(detalle.getCarcinomaInvasivo().booleanValue());
        this.jChSugestivaDeVph.setSelected(detalle.getSugestivaDeVph().booleanValue());
        this.jChImprDiagnosticaotra.setSelected(detalle.getImprDiagnosticaotra().booleanValue());
        this.jTOtrosHallazgos.setText(detalle.getOtrosHallazgos());
        this.jRBiopsiaSI.setSelected(Boolean.TRUE.equals(detalle.getBiopsia()));
        this.jRBiopsiaNO.setSelected(Boolean.FALSE.equals(detalle.getBiopsia()));
        this.jTBiopsiaDescripcion.setText(detalle.getDescripcion());
        this.JLBNumero.setText(idColposcopiaActual);
    }

    public void grabarColposcopia() {
        ColposcopiaDetalleDTO detalle = new ColposcopiaDetalleDTO();
        detalle.setVih(this.jTVih.getText());
        detalle.setInmunosupresion(this.jTInmunosupresion.getText());
        detalle.setFechaUltCitologia(this.jTFechaUltimaCitologia.getText());
        detalle.setDiagnosticoUltCitologia(this.jTDiagnosticoUltimaCit.getText());
        detalle.setAdecuada(Boolean.valueOf(this.evGenAdecuada.isSelected()));
        detalle.setInadecuada(Boolean.valueOf(this.evGenInadecuada.isSelected()));
        detalle.setCompVisible(Boolean.valueOf(this.jRCompVisible.isSelected()));
        detalle.setParcVisible(Boolean.valueOf(this.jRParcVisible.isSelected()));
        detalle.setNoVisible(Boolean.valueOf(this.jRNoVisible.isSelected()));
        if (this.jRTipo1.isSelected()) {
            detalle.setTipo("1");
        }
        if (this.jRTipo2.isSelected()) {
            detalle.setTipo("2");
        }
        if (this.jRTipo3.isSelected()) {
            detalle.setTipo("3");
        }
        detalle.setEpitelioEscamosoOriginalMaduro(Boolean.valueOf(this.jREpitelioEscamosoOriginalMaduro.isSelected()));
        detalle.setEpitelioEscamosoOriginalAtrofico(Boolean.valueOf(this.jREpitelioEscamosoOriginalAtrofico.isSelected()));
        detalle.setEpitelioColumnarNormal(Boolean.valueOf(this.jREpitelioColumnarNormal.isSelected()));
        detalle.setEpitelioColumnarEctopico(Boolean.valueOf(this.jREpitelioColumnarEctopico.isSelected()));
        detalle.setQuistesNaboth(Boolean.valueOf(this.jChQuistesNaboth.isSelected()));
        detalle.setAperturasGlandulares(Boolean.valueOf(this.jChAperturasGlandulares.isSelected()));
        detalle.setEpitelioAcetoblancoTenue(Boolean.valueOf(this.jChEpitelioAcetoblancoTenue.isSelected()));
        detalle.setBordeIrregular(Boolean.valueOf(this.jChBordeIrregular.isSelected()));
        detalle.setPunteadoFino(Boolean.valueOf(this.jChPunteadoFino.isSelected()));
        detalle.setMosaicoFino(Boolean.valueOf(this.jChMosaicoFino.isSelected()));
        detalle.setEpitelioAcetoblancoDenso(Boolean.valueOf(this.jChEpitelioAcetoblancoDenso.isSelected()));
        detalle.setSignoDeLaCresta(Boolean.valueOf(this.jChSignoDeLaCresta.isSelected()));
        detalle.setMosaicoGrueso(Boolean.valueOf(this.jChMosaicoGrueso.isSelected()));
        detalle.setBordeInterno(Boolean.valueOf(this.jChBordeInterno.isSelected()));
        detalle.setPunteadoGrueso(Boolean.valueOf(this.jChPunteadoGrueso.isSelected()));
        detalle.setAperturasGlandularesConBordesGruesos(Boolean.valueOf(this.jChAperturasGlandularesConBordesGruesos.isSelected()));
        detalle.setLeucoplasia(Boolean.valueOf(this.jChLeucoplasia.isSelected()));
        detalle.setErosion(Boolean.valueOf(this.jChErosion.isSelected()));
        if (this.jRSchillerPositivo.isSelected()) {
            detalle.setSchiller(Boolean.TRUE);
        } else {
            detalle.setSchiller(Boolean.FALSE);
        }
        detalle.setEnLaZonaDeTransformacion(Boolean.valueOf(this.jREnLaZonaDeTransformacion.isSelected()));
        detalle.setFueraDeLaZonaDeTransformacion(Boolean.valueOf(this.jRFueraDeLaZonaDeTransformacion.isSelected()));
        detalle.setVasosAtipicos(Boolean.valueOf(this.jChVasosAtipicos.isSelected()));
        detalle.setNecrosis(Boolean.valueOf(this.jChNecrosis.isSelected()));
        detalle.setSuperficieIrregular(Boolean.valueOf(this.jChSuperficieIrregular.isSelected()));
        detalle.setTumorNodular(Boolean.valueOf(this.jChTumorNodular.isSelected()));
        detalle.setLesionExofitica(Boolean.valueOf(this.jChLesionExofitica.isSelected()));
        detalle.setInvacionOtros(Boolean.valueOf(this.jChInvacionOtros.isSelected()));
        detalle.setNormal(Boolean.valueOf(this.jChNormal.isSelected()));
        detalle.setLieDeBajoGrado(Boolean.valueOf(this.jChLieDeBajoGrado.isSelected()));
        detalle.setInflamatoria(Boolean.valueOf(this.jChInflamatoria.isSelected()));
        detalle.setLieDeAltoGrado(Boolean.valueOf(this.jChLieDeAltoGrado.isSelected()));
        detalle.setAtrofica(Boolean.valueOf(this.jChAtrofica.isSelected()));
        detalle.setCarcinomaInvasivo(Boolean.valueOf(this.jChCarcinomaInvasivo.isSelected()));
        detalle.setSugestivaDeVph(Boolean.valueOf(this.jChSugestivaDeVph.isSelected()));
        detalle.setImprDiagnosticaotra(Boolean.valueOf(this.jChImprDiagnosticaotra.isSelected()));
        detalle.setOtrosHallazgos(this.jTOtrosHallazgos.getText());
        if (this.jRBiopsiaSI.isSelected()) {
            detalle.setBiopsia(Boolean.TRUE);
        }
        if (this.jRBiopsiaNO.isSelected()) {
            detalle.setBiopsia(Boolean.FALSE);
        }
        detalle.setDescripcion(this.jTBiopsiaDescripcion.getText());
        try {
            String detalleJson = this.objectMapper.writeValueAsString(detalle);
            int n = JOptionPane.showInternalConfirmDialog(this, "Esta seguro de grabar?", "CONFIRMAR", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            if (n == 0) {
                String idRegistro = this.JLBNumero.getText();
                if (idRegistro == null || idRegistro.trim().isEmpty()) {
                    String sql = "INSERT INTO baseserver.h_colposcopia (idAtencion, fechaR, idProfesional,idEspecialidad, detalle, created_at, updated_at) VALUES (" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + ", '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', '" + detalleJson + "', current_timestamp(), current_timestamp());";
                    String nuevoId = this.xconsultasbd.ejecutarSQLId(sql);
                    this.JLBNumero.setText(nuevoId);
                    JOptionPane.showMessageDialog(this, "Registro grabado", "SUCCESS", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                } else {
                    String sql2 = "UPDATE baseserver.h_colposcopia SET idAtencion = " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + ", fechaR = '" + this.xmetodo.formatoAMD.format(this.xmetodo.getFechaActual()) + "', idProfesional = '" + Principal.usuarioSistemaDTO.getIdUsuarioSistema() + "', idEspecialidad = '" + Principal.informacionGeneralPrincipalDTO.getIdEspecialidad() + "', detalle = '" + detalleJson + "', updated_at = current_timestamp() WHERE id = " + idRegistro;
                    this.xconsultasbd.ejecutarSQL(sql2);
                    JOptionPane.showMessageDialog(this, "Registro actualizado", "SUCCESS", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                }
                this.xconsultasbd.cerrarConexionBd();
            }
            System.out.println("vamo aqui");
        } catch (Exception e) {
            JOptionPane.showInternalConfirmDialog(this, e.getMessage(), "Error", 0, 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
        }
    }

    public void mImprimir(ColposcopiaDetalleDTO detalle) {
        if (detalle == null) {
            JOptionPane.showMessageDialog(this, "No se ha encontrado un detalle para imprimir", "ERROR", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            return;
        }
        try {
            String sql = "SELECT CONCAT('G',ha.No_G,'P',ha.No_P,'C',ha.No_C,'A',ha.No_A) paridad\n,ha.EdadInicioRel as irs FROM h_antecedenteginecologico ha \nwhere ha.Id_Atencion =" + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "";
            ResultSet xrs = this.xconsultasbd.traerRs(sql);
            if (xrs.first()) {
                detalle.setParidad(xrs.getString(1));
                detalle.setIrs(xrs.getString(2));
            }
            this.xconsultasbd.cerrarConexionBd();
        } catch (Exception e) {
            System.out.println("Error recuperando datos de citologia:: " + e.getMessage());
        }
        try {
            String sql2 = "SELECT GROUP_CONCAT(\n    CASE \n        WHEN ha.Orden = 1 THEN CONCAT('Dx Principal: ', ha.Id_Dx ,' ', gp.Nbre)\n        ELSE CONCAT('- ',ha.Id_Dx,' ' , gp.Nbre)\n    END \n    ORDER BY ha.Orden ASC SEPARATOR '\\n'\n) AS diagnosticos\nFROM h_atenciondx ha\nINNER JOIN g_patologia gp ON gp.Id = ha.Id_Dx\nWHERE ha.Id_Atencion = " + clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion() + "";
            ResultSet xrs2 = this.xconsultasbd.traerRs(sql2);
            if (xrs2.first()) {
                detalle.setDxCitologia(xrs2.getString(1));
            }
            this.xconsultasbd.cerrarConexionBd();
        } catch (Exception e2) {
            System.out.println("Error recuperando los dx:: " + e2.getMessage());
        }
        if (!this.JLBNumero.getText().isEmpty()) {
            Map<String, Object> parametros = new HashMap<>();
            System.out.println("" + this.nombreItems);
            parametros.put("idatencion1", clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion());
            parametros.put("SUBREPORT_DIR", this.xmetodo.getSO() + this.xmetodo.getBarra() + "Reportes" + this.xmetodo.getBarra());
            parametros.put("SUBREPORTFIRMA_DIR", this.xmetodo.getSO() + this.xmetodo.getBarra() + "Firmas" + this.xmetodo.getBarra());
            parametros.put("data", this.xmetodo.convertirObjetoAMap(detalle));
            this.xmetodo.GenerarPDF(this.xmetodo.getRutaRep() + "H_ReporteColposcopia", parametros, "");
        }
    }

    private void initComponents() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup2 = new ButtonGroup();
        this.buttonGroup3 = new ButtonGroup();
        this.buttonGroup4 = new ButtonGroup();
        this.buttonGroup5 = new ButtonGroup();
        this.buttonGroup6 = new ButtonGroup();
        this.buttonGroup7 = new ButtonGroup();
        this.buttonGroup8 = new ButtonGroup();
        this.buttonGroup9 = new ButtonGroup();
        this.buttonGroup10 = new ButtonGroup();
        this.buttonGroup11 = new ButtonGroup();
        this.buttonGroup12 = new ButtonGroup();
        this.buttonGroup13 = new ButtonGroup();
        this.Imprimir = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.jPanel1 = new JPanel();
        this.jPanel7 = new JPanel();
        this.jPanel8 = new JPanel();
        this.evGenAdecuada = new JRadioButton();
        this.evGenInadecuada = new JRadioButton();
        this.jPanel9 = new JPanel();
        this.jRTipo1 = new JRadioButton();
        this.jRTipo2 = new JRadioButton();
        this.jRTipo3 = new JRadioButton();
        this.jPanel13 = new JPanel();
        this.jRCompVisible = new JRadioButton();
        this.jRParcVisible = new JRadioButton();
        this.jRNoVisible = new JRadioButton();
        this.jPanel2 = new JPanel();
        this.jPanel11 = new JPanel();
        this.jREpitelioEscamosoOriginalAtrofico = new JRadioButton();
        this.jREpitelioEscamosoOriginalMaduro = new JRadioButton();
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.jREpitelioColumnarNormal = new JRadioButton();
        this.jREpitelioColumnarEctopico = new JRadioButton();
        this.jPanel12 = new JPanel();
        this.jChAperturasGlandulares = new JCheckBox();
        this.jChQuistesNaboth = new JCheckBox();
        this.jPanel4 = new JPanel();
        this.jPanel15 = new JPanel();
        this.jChEpitelioAcetoblancoDenso = new JCheckBox();
        this.jChSignoDeLaCresta = new JCheckBox();
        this.jChBordeInterno = new JCheckBox();
        this.jChPunteadoGrueso = new JCheckBox();
        this.jChAperturasGlandularesConBordesGruesos = new JCheckBox();
        this.jChMosaicoGrueso = new JCheckBox();
        this.jPanel16 = new JPanel();
        this.jChEpitelioAcetoblancoTenue = new JCheckBox();
        this.jChBordeIrregular = new JCheckBox();
        this.jChPunteadoFino = new JCheckBox();
        this.jChMosaicoFino = new JCheckBox();
        this.jPanel6 = new JPanel();
        this.jPanel19 = new JPanel();
        this.jChLeucoplasia = new JCheckBox();
        this.jChErosion = new JCheckBox();
        this.jPanel20 = new JPanel();
        this.jRSchillerNegativo = new JRadioButton();
        this.jRSchillerPositivo = new JRadioButton();
        this.jPanel21 = new JPanel();
        this.jRFueraDeLaZonaDeTransformacion = new JRadioButton();
        this.jREnLaZonaDeTransformacion = new JRadioButton();
        this.jPanel5 = new JPanel();
        this.jPanel18 = new JPanel();
        this.jChVasosAtipicos = new JCheckBox();
        this.jChNecrosis = new JCheckBox();
        this.jChSuperficieIrregular = new JCheckBox();
        this.jChTumorNodular = new JCheckBox();
        this.jChLesionExofitica = new JCheckBox();
        this.jChInvacionOtros = new JCheckBox();
        this.jPanel14 = new JPanel();
        this.jPanel22 = new JPanel();
        this.jChNormal = new JCheckBox();
        this.jChLieDeBajoGrado = new JCheckBox();
        this.jChInflamatoria = new JCheckBox();
        this.jChLieDeAltoGrado = new JCheckBox();
        this.jChAtrofica = new JCheckBox();
        this.jChCarcinomaInvasivo = new JCheckBox();
        this.jChSugestivaDeVph = new JCheckBox();
        this.jChImprDiagnosticaotra = new JCheckBox();
        this.jScrollPane2 = new JScrollPane();
        this.jTOtrosHallazgos = new JTextArea();
        this.jPanel17 = new JPanel();
        this.jPanel23 = new JPanel();
        this.jRBiopsiaSI = new JRadioButton();
        this.jRBiopsiaNO = new JRadioButton();
        this.jLabel3 = new JLabel();
        this.jScrollPane3 = new JScrollPane();
        this.jTBiopsiaDescripcion = new JTextArea();
        this.jPanel10 = new JPanel();
        this.jTFechaUltimaCitologia = new JTextField();
        this.jTVih = new JTextField();
        this.jTInmunosupresion = new JTextField();
        this.jTDiagnosticoUltimaCit = new JTextField();
        this.JLBNumero = new JLabel();
        this.JBTGuardar = new JButton();
        setBorder(BorderFactory.createTitledBorder((Border) null, "COLPOSCOPIA", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        setName("xjifcolposcopia");
        setPreferredSize(new Dimension(811, 476));
        this.Imprimir.setFont(new Font("Arial", 1, 14));
        this.Imprimir.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Imprimir.png")));
        this.Imprimir.setText("imprimir");
        this.Imprimir.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.1
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.ImprimirActionPerformed(evt);
            }
        });
        this.Imprimir.addKeyListener(new KeyAdapter() { // from class: Historia.JPAColposcopia.2
            public void keyPressed(KeyEvent evt) {
                JPAColposcopia.this.ImprimirKeyPressed(evt);
            }
        });
        this.jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 51)));
        this.jPanel1.setBackground(new Color(255, 255, 255));
        this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 255)));
        this.jPanel7.setBackground(new Color(255, 255, 255));
        this.jPanel7.setBorder(BorderFactory.createTitledBorder((Border) null, "EVALUCIÓN GENERAL", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel8.setBackground(new Color(255, 255, 255));
        this.jPanel8.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.evGenAdecuada.setBackground(new Color(255, 255, 255));
        this.buttonGroup1.add(this.evGenAdecuada);
        this.evGenAdecuada.setText("ADECUADA");
        this.evGenInadecuada.setBackground(new Color(255, 255, 255));
        this.buttonGroup1.add(this.evGenInadecuada);
        this.evGenInadecuada.setText("INADECUADA");
        this.evGenInadecuada.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.3
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.evGenInadecuadaActionPerformed(evt);
            }
        });
        GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
        this.jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.evGenAdecuada).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.evGenInadecuada).addContainerGap(-1, 32767)));
        jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.evGenAdecuada).addComponent(this.evGenInadecuada)));
        this.jPanel9.setBackground(new Color(255, 255, 255));
        this.jPanel9.setBorder(BorderFactory.createTitledBorder((Border) null, "Zona de transformación", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jRTipo1.setBackground(new Color(255, 255, 255));
        this.buttonGroup3.add(this.jRTipo1);
        this.jRTipo1.setText("Tipo 1");
        this.jRTipo2.setBackground(new Color(255, 255, 255));
        this.buttonGroup3.add(this.jRTipo2);
        this.jRTipo2.setText("Tipo 2");
        this.jRTipo3.setBackground(new Color(255, 255, 255));
        this.buttonGroup3.add(this.jRTipo3);
        this.jRTipo3.setText("Tipo 3");
        GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
        this.jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createSequentialGroup().addContainerGap().addComponent(this.jRTipo1).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRTipo2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRTipo3).addContainerGap(755, 32767)));
        jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRTipo1).addComponent(this.jRTipo2).addComponent(this.jRTipo3)));
        this.jPanel13.setBackground(new Color(255, 255, 255));
        this.jPanel13.setBorder(BorderFactory.createTitledBorder((Border) null, "Unión escamocolumnar", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jRCompVisible.setBackground(new Color(255, 255, 255));
        this.buttonGroup2.add(this.jRCompVisible);
        this.jRCompVisible.setText("Completamente visible");
        this.jRParcVisible.setBackground(new Color(255, 255, 255));
        this.buttonGroup2.add(this.jRParcVisible);
        this.jRParcVisible.setText("Parcialmente Visible");
        this.jRNoVisible.setBackground(new Color(255, 255, 255));
        this.buttonGroup2.add(this.jRNoVisible);
        this.jRNoVisible.setText("No Visible");
        GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
        this.jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addComponent(this.jRCompVisible, -2, 145, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRParcVisible).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRNoVisible).addContainerGap(-1, 32767)));
        jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRCompVisible).addComponent(this.jRParcVisible).addComponent(this.jRNoVisible)));
        GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
        this.jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel8, -1, -1, 32767).addComponent(this.jPanel9, -1, -1, 32767).addComponent(this.jPanel13, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel8, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel13, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel9, -2, -1, -2).addContainerGap(-1, 32767)));
        this.jPanel2.setBackground(new Color(255, 255, 255));
        this.jPanel2.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGOS COLPOSCOPICOS NORMALES", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel11.setBackground(new Color(255, 255, 255));
        this.jPanel11.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jREpitelioEscamosoOriginalAtrofico.setBackground(new Color(255, 255, 255));
        this.buttonGroup4.add(this.jREpitelioEscamosoOriginalAtrofico);
        this.jREpitelioEscamosoOriginalAtrofico.setText("Atrófico");
        this.jREpitelioEscamosoOriginalAtrofico.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.4
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jREpitelioEscamosoOriginalAtroficoActionPerformed(evt);
            }
        });
        this.jREpitelioEscamosoOriginalMaduro.setBackground(new Color(255, 255, 255));
        this.buttonGroup4.add(this.jREpitelioEscamosoOriginalMaduro);
        this.jREpitelioEscamosoOriginalMaduro.setText("Maduro");
        this.jREpitelioEscamosoOriginalMaduro.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.5
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jREpitelioEscamosoOriginalMaduroActionPerformed(evt);
            }
        });
        this.jLabel1.setBackground(new Color(255, 255, 255));
        this.jLabel1.setFont(new Font("Arial", 1, 12));
        this.jLabel1.setText("Epitelio escamoso original: ");
        this.jLabel2.setBackground(new Color(255, 255, 255));
        this.jLabel2.setFont(new Font("Arial", 1, 12));
        this.jLabel2.setText("Epitelio columnar: ");
        this.jREpitelioColumnarNormal.setBackground(new Color(255, 255, 255));
        this.buttonGroup5.add(this.jREpitelioColumnarNormal);
        this.jREpitelioColumnarNormal.setText("Normal");
        this.jREpitelioColumnarNormal.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.6
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jREpitelioColumnarNormalActionPerformed(evt);
            }
        });
        this.jREpitelioColumnarEctopico.setBackground(new Color(255, 255, 255));
        this.buttonGroup5.add(this.jREpitelioColumnarEctopico);
        this.jREpitelioColumnarEctopico.setText("Ectópico");
        this.jREpitelioColumnarEctopico.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.7
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jREpitelioColumnarEctopicoActionPerformed(evt);
            }
        });
        GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
        this.jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jREpitelioEscamosoOriginalMaduro).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jREpitelioEscamosoOriginalAtrofico).addGap(18, 18, 18).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jREpitelioColumnarNormal).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jREpitelioColumnarEctopico).addContainerGap(-1, 32767)));
        jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jREpitelioColumnarEctopico).addComponent(this.jREpitelioColumnarNormal).addComponent(this.jLabel2)).addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jREpitelioEscamosoOriginalAtrofico).addComponent(this.jREpitelioEscamosoOriginalMaduro).addComponent(this.jLabel1))).addContainerGap(-1, 32767)));
        this.jPanel12.setBackground(new Color(255, 255, 255));
        this.jPanel12.setBorder(BorderFactory.createTitledBorder((Border) null, "Epitelio escamoso metaplásico:", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jChAperturasGlandulares.setBackground(new Color(255, 255, 255));
        this.jChAperturasGlandulares.setText("Aperturas glandulares");
        this.jChQuistesNaboth.setBackground(new Color(255, 255, 255));
        this.jChQuistesNaboth.setText(" Quistes de Naboth");
        GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
        this.jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addComponent(this.jChQuistesNaboth).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChAperturasGlandulares).addContainerGap(-1, 32767)));
        jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jChAperturasGlandulares).addComponent(this.jChQuistesNaboth)));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel11, -1, -1, 32767).addComponent(this.jPanel12, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel11, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel12, -2, -1, -2)));
        this.jPanel4.setBackground(new Color(255, 255, 255));
        this.jPanel4.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGOS COLPOSCOPICOS ANORMALES", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel15.setBackground(new Color(255, 255, 255));
        this.jPanel15.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado 2 (mayor)", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jChEpitelioAcetoblancoDenso.setBackground(new Color(255, 255, 255));
        this.jChEpitelioAcetoblancoDenso.setText("Epitelio acetoblanco denso");
        this.jChSignoDeLaCresta.setBackground(new Color(255, 255, 255));
        this.jChSignoDeLaCresta.setText("Signo de la cresta");
        this.jChSignoDeLaCresta.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.8
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jChSignoDeLaCrestaActionPerformed(evt);
            }
        });
        this.jChBordeInterno.setBackground(new Color(255, 255, 255));
        this.jChBordeInterno.setText("Borde interno");
        this.jChPunteadoGrueso.setBackground(new Color(255, 255, 255));
        this.jChPunteadoGrueso.setText("Punteado grueso");
        this.jChAperturasGlandularesConBordesGruesos.setBackground(new Color(255, 255, 255));
        this.jChAperturasGlandularesConBordesGruesos.setText("Aperturas glandulares con bordes gruesos");
        this.jChMosaicoGrueso.setBackground(new Color(255, 255, 255));
        this.jChMosaicoGrueso.setText("Mosaico grueso");
        GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
        this.jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addComponent(this.jChEpitelioAcetoblancoDenso).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jChSignoDeLaCresta).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChMosaicoGrueso)).addGroup(jPanel15Layout.createSequentialGroup().addComponent(this.jChBordeInterno).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChPunteadoGrueso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChAperturasGlandularesConBordesGruesos))).addContainerGap(-1, 32767)));
        jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jChEpitelioAcetoblancoDenso).addComponent(this.jChSignoDeLaCresta).addComponent(this.jChMosaicoGrueso)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jChBordeInterno).addComponent(this.jChPunteadoGrueso).addComponent(this.jChAperturasGlandularesConBordesGruesos)).addContainerGap(-1, 32767)));
        this.jPanel16.setBackground(new Color(255, 255, 255));
        this.jPanel16.setBorder(BorderFactory.createTitledBorder((Border) null, "Grado 1 (menor)", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jChEpitelioAcetoblancoTenue.setBackground(new Color(255, 255, 255));
        this.jChEpitelioAcetoblancoTenue.setText("Epitelio acetoblanco tenue");
        this.jChBordeIrregular.setBackground(new Color(255, 255, 255));
        this.jChBordeIrregular.setText("Borde irregular");
        this.jChPunteadoFino.setBackground(new Color(255, 255, 255));
        this.jChPunteadoFino.setText("Punteado fino");
        this.jChMosaicoFino.setBackground(new Color(255, 255, 255));
        this.jChMosaicoFino.setText("Mosaico fino");
        GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
        this.jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addContainerGap().addComponent(this.jChEpitelioAcetoblancoTenue).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jChBordeIrregular).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChPunteadoFino).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChMosaicoFino).addContainerGap(-1, 32767)));
        jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jChEpitelioAcetoblancoTenue).addComponent(this.jChBordeIrregular).addComponent(this.jChPunteadoFino).addComponent(this.jChMosaicoFino)).addGap(0, 6, 32767)));
        GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
        this.jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel16, -1, -1, 32767).addComponent(this.jPanel15, -1, -1, 32767)).addContainerGap()));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.jPanel16, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel15, -2, 67, -2).addContainerGap(-1, 32767)));
        this.jPanel6.setBackground(new Color(255, 255, 255));
        this.jPanel6.setBorder(BorderFactory.createTitledBorder((Border) null, "HALLAZGOS COLPOSCOPICOS ANORMALES NO ESPECÍFICOS", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel19.setBackground(new Color(255, 255, 255));
        this.jPanel19.setBorder(BorderFactory.createTitledBorder((Border) null, "", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jChLeucoplasia.setBackground(new Color(255, 255, 255));
        this.jChLeucoplasia.setText("Leucoplasia");
        this.jChLeucoplasia.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.9
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jChLeucoplasiaActionPerformed(evt);
            }
        });
        this.jChErosion.setBackground(new Color(255, 255, 255));
        this.jChErosion.setText("Erosión");
        this.jChErosion.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.10
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jChErosionActionPerformed(evt);
            }
        });
        GroupLayout jPanel19Layout = new GroupLayout(this.jPanel19);
        this.jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup().addGap(14, 14, 14).addComponent(this.jChLeucoplasia).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChErosion).addContainerGap(-1, 32767)));
        jPanel19Layout.setVerticalGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel19Layout.createSequentialGroup().addContainerGap().addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jChLeucoplasia).addComponent(this.jChErosion)).addContainerGap(-1, 32767)));
        this.jPanel20.setBackground(new Color(255, 255, 255));
        this.jPanel20.setBorder(BorderFactory.createTitledBorder((Border) null, "Test de Schiller", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jRSchillerNegativo.setBackground(new Color(255, 255, 255));
        this.buttonGroup10.add(this.jRSchillerNegativo);
        this.jRSchillerNegativo.setText("Negativo");
        this.jRSchillerNegativo.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.11
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jRSchillerNegativoActionPerformed(evt);
            }
        });
        this.jRSchillerPositivo.setBackground(new Color(255, 255, 255));
        this.buttonGroup10.add(this.jRSchillerPositivo);
        this.jRSchillerPositivo.setText("Positivo");
        this.jRSchillerPositivo.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.12
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jRSchillerPositivoActionPerformed(evt);
            }
        });
        GroupLayout jPanel20Layout = new GroupLayout(this.jPanel20);
        this.jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel20Layout.createSequentialGroup().addContainerGap().addComponent(this.jRSchillerPositivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRSchillerNegativo).addContainerGap(-1, 32767)));
        jPanel20Layout.setVerticalGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel20Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRSchillerNegativo).addComponent(this.jRSchillerPositivo))));
        this.jPanel21.setBackground(new Color(255, 255, 255));
        this.jPanel21.setBorder(BorderFactory.createTitledBorder((Border) null, "Ubicación de la lesión ", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jRFueraDeLaZonaDeTransformacion.setBackground(new Color(255, 255, 255));
        this.buttonGroup11.add(this.jRFueraDeLaZonaDeTransformacion);
        this.jRFueraDeLaZonaDeTransformacion.setText("Fuera de la zona de transformación ");
        this.jRFueraDeLaZonaDeTransformacion.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.13
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jRFueraDeLaZonaDeTransformacionActionPerformed(evt);
            }
        });
        this.jREnLaZonaDeTransformacion.setBackground(new Color(255, 255, 255));
        this.buttonGroup11.add(this.jREnLaZonaDeTransformacion);
        this.jREnLaZonaDeTransformacion.setText("En la zona de transformación: ");
        this.jREnLaZonaDeTransformacion.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.14
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jREnLaZonaDeTransformacionActionPerformed(evt);
            }
        });
        GroupLayout jPanel21Layout = new GroupLayout(this.jPanel21);
        this.jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel21Layout.createSequentialGroup().addContainerGap().addComponent(this.jREnLaZonaDeTransformacion).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRFueraDeLaZonaDeTransformacion).addContainerGap(-1, 32767)));
        jPanel21Layout.setVerticalGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRFueraDeLaZonaDeTransformacion).addComponent(this.jREnLaZonaDeTransformacion))));
        GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
        this.jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel20, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel21, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel19, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addComponent(this.jPanel19, -2, 32, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel20, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jPanel21, -2, -1, -2).addContainerGap()));
        this.jPanel5.setBackground(new Color(255, 255, 255));
        this.jPanel5.setBorder(BorderFactory.createTitledBorder((Border) null, "SOSPECHA DE INVASIÓN", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel18.setBackground(new Color(255, 255, 255));
        this.jPanel18.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.jChVasosAtipicos.setBackground(new Color(255, 255, 255));
        this.jChVasosAtipicos.setText("Vasos atípicos");
        this.jChNecrosis.setBackground(new Color(255, 255, 255));
        this.jChNecrosis.setText("Necrosis");
        this.jChSuperficieIrregular.setBackground(new Color(255, 255, 255));
        this.jChSuperficieIrregular.setText("Superficie irregular");
        this.jChTumorNodular.setBackground(new Color(255, 255, 255));
        this.jChTumorNodular.setText("Tumor nodular");
        this.jChTumorNodular.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.15
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jChTumorNodularActionPerformed(evt);
            }
        });
        this.jChLesionExofitica.setBackground(new Color(255, 255, 255));
        this.jChLesionExofitica.setText("Lesión exofítica");
        this.jChInvacionOtros.setBackground(new Color(255, 255, 255));
        this.jChInvacionOtros.setText("Otra");
        GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
        this.jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addContainerGap().addComponent(this.jChVasosAtipicos).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChNecrosis).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChSuperficieIrregular).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChTumorNodular).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChLesionExofitica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChInvacionOtros).addContainerGap(-1, 32767)));
        jPanel18Layout.setVerticalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addContainerGap().addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jChVasosAtipicos).addComponent(this.jChNecrosis).addComponent(this.jChSuperficieIrregular).addComponent(this.jChTumorNodular).addComponent(this.jChLesionExofitica).addComponent(this.jChInvacionOtros)).addContainerGap(-1, 32767)));
        GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
        this.jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel18, -1, -1, 32767).addContainerGap()));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel18, -2, -1, -2));
        this.jPanel14.setBackground(new Color(255, 255, 255));
        this.jPanel14.setBorder(BorderFactory.createTitledBorder((Border) null, "IMPRESIÓN DIAGNÓSTICA", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel22.setBackground(new Color(255, 255, 255));
        this.jPanel22.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.jChNormal.setBackground(new Color(255, 255, 255));
        this.jChNormal.setText("Normal");
        this.jChLieDeBajoGrado.setBackground(new Color(255, 255, 255));
        this.jChLieDeBajoGrado.setText("LIE de bajo grado");
        this.jChInflamatoria.setBackground(new Color(255, 255, 255));
        this.jChInflamatoria.setText("Inflamatoria");
        this.jChLieDeAltoGrado.setBackground(new Color(255, 255, 255));
        this.jChLieDeAltoGrado.setText("LIE de alto grado");
        this.jChAtrofica.setBackground(new Color(255, 255, 255));
        this.jChAtrofica.setText("Atrófica ");
        this.jChCarcinomaInvasivo.setBackground(new Color(255, 255, 255));
        this.jChCarcinomaInvasivo.setText("Carcinoma invasivo");
        this.jChSugestivaDeVph.setBackground(new Color(255, 255, 255));
        this.jChSugestivaDeVph.setText("Sugestiva de VPH");
        this.jChImprDiagnosticaotra.setBackground(new Color(255, 255, 255));
        this.jChImprDiagnosticaotra.setText("Otra");
        GroupLayout jPanel22Layout = new GroupLayout(this.jPanel22);
        this.jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel22Layout.createSequentialGroup().addContainerGap().addComponent(this.jChNormal).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jChLieDeBajoGrado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChInflamatoria).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChLieDeAltoGrado).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChAtrofica).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChCarcinomaInvasivo).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChSugestivaDeVph).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jChImprDiagnosticaotra).addContainerGap(-1, 32767)));
        jPanel22Layout.setVerticalGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel22Layout.createSequentialGroup().addContainerGap().addGroup(jPanel22Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jChNormal).addComponent(this.jChLieDeBajoGrado).addComponent(this.jChInflamatoria).addComponent(this.jChLieDeAltoGrado).addComponent(this.jChAtrofica).addComponent(this.jChCarcinomaInvasivo).addComponent(this.jChSugestivaDeVph).addComponent(this.jChImprDiagnosticaotra)).addContainerGap(16, 32767)));
        this.jTOtrosHallazgos.setColumns(20);
        this.jTOtrosHallazgos.setRows(5);
        this.jTOtrosHallazgos.setBorder(BorderFactory.createTitledBorder((Border) null, "Otros hallazgos", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jScrollPane2.setViewportView(this.jTOtrosHallazgos);
        GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
        this.jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel22, -1, -1, 32767)).addComponent(this.jScrollPane2)).addContainerGap()));
        jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addComponent(this.jPanel22, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 57, -2).addContainerGap()));
        this.jPanel17.setBackground(new Color(255, 255, 255));
        this.jPanel17.setBorder(BorderFactory.createTitledBorder((Border) null, "CONDUCTA", 2, 0, new Font("Arial", 1, 12), new Color(0, 103, 0)));
        this.jPanel23.setBackground(new Color(255, 255, 255));
        this.jPanel23.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204)));
        this.jRBiopsiaSI.setBackground(new Color(255, 255, 255));
        this.buttonGroup13.add(this.jRBiopsiaSI);
        this.jRBiopsiaSI.setText("SI");
        this.jRBiopsiaSI.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.16
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jRBiopsiaSIActionPerformed(evt);
            }
        });
        this.jRBiopsiaNO.setBackground(new Color(255, 255, 255));
        this.buttonGroup13.add(this.jRBiopsiaNO);
        this.jRBiopsiaNO.setText("NO");
        this.jRBiopsiaNO.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.17
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.jRBiopsiaNOActionPerformed(evt);
            }
        });
        this.jLabel3.setBackground(new Color(255, 255, 255));
        this.jLabel3.setFont(new Font("Arial", 1, 12));
        this.jLabel3.setText("Biopsia: ");
        GroupLayout jPanel23Layout = new GroupLayout(this.jPanel23);
        this.jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel23Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBiopsiaSI).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jRBiopsiaNO).addContainerGap(-1, 32767)));
        jPanel23Layout.setVerticalGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel23Layout.createSequentialGroup().addContainerGap().addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRBiopsiaNO).addComponent(this.jRBiopsiaSI).addComponent(this.jLabel3)).addContainerGap(7, 32767)));
        this.jTBiopsiaDescripcion.setColumns(20);
        this.jTBiopsiaDescripcion.setRows(5);
        this.jTBiopsiaDescripcion.setBorder(BorderFactory.createTitledBorder((Border) null, "Descripción", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jScrollPane3.setViewportView(this.jTBiopsiaDescripcion);
        GroupLayout jPanel17Layout = new GroupLayout(this.jPanel17);
        this.jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel23, -1, -1, 32767)).addComponent(this.jScrollPane3)).addContainerGap()));
        jPanel17Layout.setVerticalGroup(jPanel17Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel17Layout.createSequentialGroup().addComponent(this.jPanel23, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 57, -2).addContainerGap()));
        this.jPanel10.setBackground(new Color(255, 255, 255));
        this.jPanel10.setBorder(BorderFactory.createTitledBorder((Border) null, "DESCRIPCIÓN", 2, 0, new Font("Arial", 1, 14), new Color(0, 103, 0)));
        this.jTFechaUltimaCitologia.setBorder(BorderFactory.createTitledBorder((Border) null, "Fecha y lugar última citología", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jTVih.setText("NO");
        this.jTVih.setBorder(BorderFactory.createTitledBorder((Border) null, "VIH", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jTInmunosupresion.setText("NO");
        this.jTInmunosupresion.setBorder(BorderFactory.createTitledBorder((Border) null, "Inmunosupresión", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        this.jTDiagnosticoUltimaCit.setBorder(BorderFactory.createTitledBorder((Border) null, "Diagnostico", 0, 0, new Font("Arial", 1, 12), new Color(51, 102, 255)));
        GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
        this.jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jTVih, -2, 113, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTInmunosupresion, -2, 136, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFechaUltimaCitologia, -2, 256, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTDiagnosticoUltimaCit).addContainerGap()));
        jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addContainerGap(19, 32767).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTVih, -2, -1, -2).addComponent(this.jTInmunosupresion, -2, -1, -2).addComponent(this.jTFechaUltimaCitologia, -2, -1, -2).addComponent(this.jTDiagnosticoUltimaCit, -2, -1, -2)).addContainerGap()));
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel17, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel10, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel7, -1, -1, 32767).addComponent(this.jPanel14, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel6, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addContainerGap()))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel10, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel7, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel14, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel17, -2, -1, -2).addContainerGap(145, 32767)));
        this.jScrollPane1.setViewportView(this.jPanel1);
        this.JLBNumero.setFont(new Font("Arial", 1, 18));
        this.JLBNumero.setForeground(new Color(255, 0, 0));
        this.JLBNumero.setHorizontalAlignment(0);
        this.JLBNumero.setBorder(BorderFactory.createTitledBorder((Border) null, "Id Colposcopia", 2, 0, new Font("Arial", 1, 12), Color.blue));
        this.JBTGuardar.setFont(new Font("Arial", 1, 14));
        this.JBTGuardar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Ok.png")));
        this.JBTGuardar.setText("Guardar");
        this.JBTGuardar.addActionListener(new ActionListener() { // from class: Historia.JPAColposcopia.18
            public void actionPerformed(ActionEvent evt) {
                JPAColposcopia.this.JBTGuardarActionPerformed(evt);
            }
        });
        this.JBTGuardar.addKeyListener(new KeyAdapter() { // from class: Historia.JPAColposcopia.19
            public void keyPressed(KeyEvent evt) {
                JPAColposcopia.this.JBTGuardarKeyPressed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.JBTGuardar, -2, 495, -2).addGap(18, 18, 18).addComponent(this.Imprimir, -2, 257, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.JLBNumero, -2, 141, -2)).addComponent(this.jScrollPane1, -2, 1011, -2)).addGap(0, 0, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 406, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.JLBNumero, -1, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.JBTGuardar, -1, -1, 32767).addComponent(this.Imprimir, -1, -1, 32767)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ImprimirKeyPressed(KeyEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ImprimirActionPerformed(ActionEvent evt) {
        mImprimir(recuperarColposcopiaAtencion(clasesHistoriaCE.informacionAgendaMedicaDTO.getIdAtencion()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jREnLaZonaDeTransformacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRFueraDeLaZonaDeTransformacionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRSchillerPositivoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRSchillerNegativoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jChErosionActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jChLeucoplasiaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jChTumorNodularActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jChSignoDeLaCrestaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jREpitelioColumnarEctopicoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jREpitelioColumnarNormalActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jREpitelioEscamosoOriginalMaduroActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jREpitelioEscamosoOriginalAtroficoActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evGenInadecuadaActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRBiopsiaSIActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jRBiopsiaNOActionPerformed(ActionEvent evt) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarActionPerformed(ActionEvent evt) {
        grabarColposcopia();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JBTGuardarKeyPressed(KeyEvent evt) {
    }
}
