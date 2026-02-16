package Salud_Ocupacional;

import Acceso.Principal;
import ParametrizacionN.JIFFTipoSistemaVigilancia;
import ParametrizacionN.JIFFTipoVigilanciaSistemas;
import ParametrizacionN.JIFGenerico1CheckBox1TextArea;
import ParametrizacionN.JIFGenericoDosCombox1Check;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import com.genoma.plus.controller.historia.JIF_Historia_Clinica_v3;
import com.genoma.plus.controller.parametrizacion.JIFTipoVigilancia;
import com.genoma.plus.controller.salud_ocupacional.JIFFTestRuffier;
import com.genoma.plus.controller.salud_ocupacional.JIFFramingham;
import com.genoma.plus.controller.salud_ocupacional.JIFInformesSo;
import com.genoma.plus.controller.salud_ocupacional.JIFSOAutoReportes;
import com.genoma.plus.controller.salud_ocupacional.JIFSOTipoSegmento;
import com.genoma.plus.controller.salud_ocupacional.JIF_InformeSistemaVigilancia;
import com.genoma.plus.controller.salud_ocupacional.JIF_Reporte_de_seguimiento;
import com.genoma.plus.controller.sgc.JIF_Reportes_PyP_Generico;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/* JADX INFO: loaded from: GenomaP.jar:Salud_Ocupacional/claseSo.class */
public class claseSo {
    private String xsql;
    public JIFPrueba_AyD xjifpayd;
    public Principal xjfp;
    private JIFTest_Fatiga xjiftestfatiga;
    private JIFFInformes xjiffinformes;
    private JIFGestion_ManPower xjifgestionmp;
    private JIFG_Periodicos xjifgestiosep;
    private JIFSegProcedimiento xJIFSegProcedimiento;
    private JIFCMan_Power xjifxcman_power;
    public JIFSeguimiento_SVE xjifseguimientosve;
    private JIFConsultar_Datos_Seguimiento xjifrseguimiento;
    private JIFGenericoDosCombox1Check xJIFGenericoDosCombox1Check;
    private JIFGenerico1CheckBox1TextArea xJIFGenerico1CheckBox1TextArea;
    private JIFFAgenteMedicion xJIFFAgenteMedicion;
    private JIFSOAutoReportes xJIFSOAutoReportes;
    private JIFFramingham xJIFFramingham;
    private JIFFTestRuffier xJIFFTestRuffier;
    private JIFInformesSo xjifInformesSo;
    private JIFSOTipoSegmento xJIFSOTipoSegmento;
    private JIF_Reporte_de_seguimiento xJIF_Reporte_de_seguimiento;
    private JIFTipoVigilancia tipoVigilancia;
    private JIF_Reportes_PyP_Generico pyP_Generico;
    public JIF_Historia_Clinica_v3 historia_Clinica_v3;
    private JIF_InformeSistemaVigilancia informeSistemaVigilancia;
    private JIFFTipoVigilanciaSistemas vigilanciaSistemas;
    private JIFFTipoSistemaVigilancia sistemasVigilancia;
    private JIFDeclaracionSalud declaracionSalud;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    public JIFAgenda xjifagenda = null;

    public claseSo(Principal xjfp) {
        this.xjfp = xjfp;
        mConsultar_Seguimiento_MP();
    }

    public void buscar(String frm) {
        switch (frm) {
            case "xjifaydInf":
                this.xjiffinformes.mBuscar();
                break;
            case "xjiftestfatigaInf":
            case "xjiftestfatigaInf1":
            case "xjif_interpreacionesrx":
            case "CIS20":
                this.xjiffinformes.mBuscar();
                break;
            case "jifinformesistemavigilancia":
                this.informeSistemaVigilancia.buscar();
                break;
            case "xjif_informeSo_SO":
                this.xjifInformesSo.mBuscar();
                break;
            case "xjifgestionep":
                this.xjifgestiosep.mBuscar();
                break;
            case "xjifc_man_power":
                this.xjifxcman_power.mBuscar();
                break;
            case "xjifseguimientosve":
                this.xjifseguimientosve.mBuscar();
                break;
            case "xjifconsultar_seguimientoso":
                this.xjifrseguimiento.mBuscar();
                break;
            case "xjifsoautoreportes":
                this.xJIFSOAutoReportes.mBuscar();
                break;
            case "xjifframingham":
                this.xJIFFramingham.mBuscar();
                break;
            case "xjiftestruffier":
                this.xJIFFTestRuffier.mBuscar();
                break;
            case "jif_Reporte_de_seguimiento":
                this.xJIF_Reporte_de_seguimiento.mBuscar();
                break;
            case "jif_ReportesPyP1":
                this.pyP_Generico.mBuscar();
                break;
            case "jifDeclaracionSalud":
                this.declaracionSalud.buscarIngreso();
                break;
        }
    }

    public void cargarPantalla(String frm) {
        switch (frm) {
            case "Agenda_So":
                switch (Principal.informacionIps.getNombreIps()) {
                    case "IPS SU SALUD INTEGRAL CIA LTDA":
                    case "IPS SU SALUD INTEGRAL S.A.S":
                        int x = JOptionPane.showConfirmDialog(this.xjfp, "Desea establecer filtro por profesional?", "APLICACIÓN FILTRO", 0, 3, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
                        if (x == 0) {
                            this.xjifagenda = new JIFAgenda(Principal.clasehistoriace, 1);
                        } else {
                            this.xjifagenda = new JIFAgenda(Principal.clasehistoriace, 0);
                        }
                        Principal.cargarPantalla(this.xjifagenda);
                        break;
                    case "BIEN ESTAR SALUD BS S.A.S.":
                        if (this.historia_Clinica_v3 != null) {
                            this.historia_Clinica_v3.dispose();
                        }
                        this.historia_Clinica_v3 = new JIF_Historia_Clinica_v3();
                        Principal.cargarPantalla(this.historia_Clinica_v3);
                        break;
                    default:
                        this.xjifagenda = new JIFAgenda(Principal.clasehistoriace, 0);
                        Principal.cargarPantalla(this.xjifagenda);
                        break;
                }
                break;
            case "Informe Sistema Vigilancia":
                this.informeSistemaVigilancia = new JIF_InformeSistemaVigilancia();
                Principal.cargarPantalla(this.informeSistemaVigilancia);
                break;
            case "Información Riesgo Cardiovascular":
                this.xjifInformesSo = new JIFInformesSo("Información Riesgo Cardiovascular", "xjif_informeSo_SO");
                Principal.cargarPantalla(this.xjifInformesSo);
                break;
            case "RSeguimiento":
                this.xjifrseguimiento = new JIFConsultar_Datos_Seguimiento();
                Principal.cargarPantalla(this.xjifrseguimiento);
                break;
            case "GestionEP":
                this.xjifgestiosep = new JIFG_Periodicos();
                Principal.cargarPantalla(this.xjifgestiosep);
                break;
            case "GestionMP":
                this.xjifgestionmp = new JIFGestion_ManPower();
                Principal.cargarPantalla(this.xjifgestionmp);
                break;
            case "ClasificacionFR":
                this.xjifxcman_power = new JIFCMan_Power();
                Principal.cargarPantalla(this.xjifxcman_power);
                break;
            case "Prueba AyD":
                this.xjifpayd = new JIFPrueba_AyD("xjifpuebaayd");
                Principal.cargarPantalla(this.xjifpayd);
                break;
            case "Test Fatiga":
                this.xjiftestfatiga = new JIFTest_Fatiga("xjiftestfatiga");
                Principal.cargarPantalla(this.xjiftestfatiga);
                break;
            case "AyD por Fecha":
                this.xjiffinformes = new JIFFInformes("xjifaydInf", "Informe AyD");
                Principal.cargarPantalla(this.xjiffinformes);
                break;
            case "Test de Fatiga por Fecha":
                this.xjiffinformes = new JIFFInformes("xjiftestfatigaInf", "Informe Test de Fatiga");
                Principal.cargarPantalla(this.xjiffinformes);
                break;
            case "Atenciones So":
                this.xjiffinformes = new JIFFInformes("xjiftestfatigaInf1", "Atenciones Salud Ocupacional");
                Principal.cargarPantalla(this.xjiffinformes);
                break;
            case "SEGxProcedimiento":
                this.xJIFSegProcedimiento = new JIFSegProcedimiento();
                Principal.cargarPantalla(this.xJIFSegProcedimiento);
                break;
            case "SeguimientoP":
                this.xjifseguimientosve = new JIFSeguimiento_SVE();
                Principal.cargarPantalla(this.xjifseguimientosve);
                break;
            case "Interpretaciones Estudios Radiológicos":
                this.xjiffinformes = new JIFFInformes("xjif_interpreacionesrx", "Interpretaciones Estudios Radiológicos");
                Principal.cargarPantalla(this.xjiffinformes);
                break;
            case "SEGxAgente":
                this.xJIFGenericoDosCombox1Check = new JIFGenericoDosCombox1Check("jifso_tipoAgentes", "SEGMENTO x AGENTE");
                Principal.cargarPantalla(this.xJIFGenericoDosCombox1Check);
                break;
            case "TipoSEG":
                this.xJIFSOTipoSegmento = new JIFSOTipoSegmento();
                Principal.cargarPantalla(this.xJIFSOTipoSegmento);
                break;
            case "ValorxSEG":
                this.xJIFFAgenteMedicion = new JIFFAgenteMedicion();
                Principal.cargarPantalla(this.xJIFFAgenteMedicion);
                break;
            case "Informe de Autoreportes":
                this.xJIFSOAutoReportes = new JIFSOAutoReportes();
                Principal.cargarPantalla(this.xJIFSOAutoReportes);
                break;
            case "Informe Framingham":
                this.xJIFFramingham = new JIFFramingham();
                Principal.cargarPantalla(this.xJIFFramingham);
                break;
            case "Informe Test de Ruffier":
                this.xJIFFTestRuffier = new JIFFTestRuffier();
                Principal.cargarPantalla(this.xJIFFTestRuffier);
                break;
            case "Informe CIS20":
                this.xjiffinformes = new JIFFInformes("CIS20", "Informe CIS20");
                Principal.cargarPantalla(this.xjiffinformes);
                break;
            case "Examenes periodicos seguimiento detalles":
                this.xJIF_Reporte_de_seguimiento = new JIF_Reporte_de_seguimiento();
                Principal.cargarPantalla(this.xJIF_Reporte_de_seguimiento);
                break;
            case "TipoSistemaVigilancia":
                this.tipoVigilancia = new JIFTipoVigilancia();
                Principal.cargarPantalla(this.tipoVigilancia);
                break;
            case "Informes Generales SO":
                this.pyP_Generico = new JIF_Reportes_PyP_Generico(33, "INFORMES GENERALES", "jif_ReportesPyP1");
                Principal.cargarPantalla(this.pyP_Generico);
                break;
            case "Declaracion de antecendes":
                this.declaracionSalud = new JIFDeclaracionSalud();
                Principal.cargarPantalla(this.declaracionSalud);
                break;
        }
    }

    public void grabar(String frm) {
        switch (frm) {
            case "xjifpuebaayd":
                this.xjifpayd.mGrabar();
                break;
            case "xjiftestfatiga":
                this.xjiftestfatiga.mGrabar();
                break;
            case "xjifgestionmanp":
                this.xjifgestionmp.mGrabar();
                break;
            case "jifso_tipoAgentes":
                this.xJIFGenericoDosCombox1Check.mGrabar();
                break;
            case "jifSEG":
                this.xJIFGenerico1CheckBox1TextArea.mGrabar();
                break;
            case "xjifMedicionSEG":
                this.xJIFFAgenteMedicion.mGuardar();
                break;
            case "xjifsegprocedimiento":
                this.xJIFSegProcedimiento.mGuardar();
                break;
            case "JIFSOTipoSegmento":
                this.xJIFSOTipoSegmento.mGrabar();
                break;
            case "jif_TipoSistemasVigilancia":
                this.tipoVigilancia.grabar();
                break;
            case "jifftiposistemavigilancia":
                this.sistemasVigilancia.grabar();
                break;
            case "jifftipovigilanciasistema":
                this.vigilanciaSistemas.grabar();
                break;
        }
    }

    public void nuevo(String frm) {
        switch (frm) {
            case "xjifpuebaayd":
                this.xjifpayd.mNuevo();
                break;
            case "xjif_informeSo_SO":
                this.xjifInformesSo.mNuevo();
                break;
            case "jifinformesistemavigilancia":
                this.informeSistemaVigilancia.nuevo();
                break;
            case "xjiftestfatiga":
                this.xjiftestfatiga.mNuevo();
                break;
            case "xjifgestionmanp":
                this.xjifgestionmp.mNuevo();
                break;
            case "xjifseguimientosve":
                this.xjifseguimientosve.mNuevo();
                break;
            case "xjifconsultar_seguimientoso":
                this.xjifrseguimiento.mNuevo();
                break;
            case "jifso_tipoAgentes":
                this.xJIFGenericoDosCombox1Check.mNuevo();
                break;
            case "jifSEG":
                this.xJIFGenerico1CheckBox1TextArea.mNuevo();
                break;
            case "xjifMedicionSEG":
                this.xJIFFAgenteMedicion.mNuevo();
                break;
            case "xjifsegprocedimiento":
                this.xJIFSegProcedimiento.mNuevo();
                break;
            case "xjifsoautoreportes":
                this.xJIFSOAutoReportes.mNuevo();
                break;
            case "xjifframingham":
                this.xJIFFramingham.mNuevo();
                break;
            case "xjiftestruffier":
                this.xJIFFTestRuffier.mNuevo();
                break;
            case "JIFSOTipoSegmento":
                this.xJIFSOTipoSegmento.mNuevo();
                break;
            case "jif_Reporte_de_seguimiento":
                this.xJIF_Reporte_de_seguimiento.mNuevo();
                break;
            case "jif_TipoSistemasVigilancia":
                this.tipoVigilancia.nuevo();
                break;
            case "jifftiposistemavigilancia":
                this.sistemasVigilancia.grabar();
                break;
            case "jifftipovigilanciasistema":
                this.vigilanciaSistemas.grabar();
                break;
        }
    }

    public void anular(String frm) {
    }

    public void mImprimir(String frm) {
        if (frm.equals("xjiftestfatiga")) {
            this.xjiftestfatiga.mImprimir();
        }
    }

    public void mConsultar_Seguimiento_MP() {
        this.xsql = "SELECT `so_tipo_vigilancia`.`Id`, `so_tipo_vigilancia`.`Nbre`, COUNT(`so_tipo_vigilancia`.`Id`) AS Cantidad\n FROM    `so_manporwer_encabezado`\nINNER JOIN `so_manporwer_detalle`   ON (`so_manporwer_detalle`.`Id_mampower` = `so_manporwer_encabezado`.`Id`) \nINNER JOIN `so_manpower_seguimiento` ON (`so_manporwer_detalle`.`Id`= `so_manpower_seguimiento`.`Id_Manpower_Detalle`)  \nINNER JOIN `so_manpower_seguimiento_detalle`    ON (`so_manpower_seguimiento_detalle`.`Id_Mp_Seguimiento` = `so_manpower_seguimiento`.`Id`) \nINNER JOIN  `so_tipo_vigilancia`  ON (`so_manpower_seguimiento_detalle`.`Id_Tipo_Vigilancia` = `so_tipo_vigilancia`.`Id`) \nINNER JOIN  `cc_periodo_financiero` ON (`cc_periodo_financiero`.`Id` = `so_manporwer_encabezado`.`Id_Periodo`) \nWHERE (so_manporwer_encabezado.`Activa`=1 AND cc_periodo_financiero.`Estado`=1 and `so_manpower_seguimiento_detalle`.`Estado` =1 AND IF(`so_manpower_seguimiento_detalle`.`FechaCierre` IS NOT NULL,1, IF(`so_manpower_seguimiento_detalle`.`FechaUS` IS NULL, 2,IF( DATEDIFF(ADDDATE(`so_manpower_seguimiento_detalle`.`FechaUS`, INTERVAL `so_manpower_seguimiento_detalle`.`NDiasS` DAY), NOW())<=0,3,  4)))IN(2,3)) GROUP BY  `so_tipo_vigilancia`.`Id`\nORDER BY `so_tipo_vigilancia`.`Nbre` ASC ";
        try {
            System.out.println(this.xsql);
            ResultSet xrs = this.xct.traerRs(this.xsql);
            if (xrs.next()) {
                xrs.beforeFirst();
                String xdoc = "";
                int xc = 0;
                while (xrs.next()) {
                    xdoc = xdoc + "<html><P ALIGN=left><font color=#FF0000> " + xrs.getString(2) + "  N° " + xrs.getString(3) + "</font> <P>";
                    xc++;
                }
                JOptionPane.showMessageDialog(this.xjfp, xdoc, "PENDIENTE " + xc + " SVE POR SEGUIMIENTO", 1, new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/Question.png"))));
            }
            xrs.close();
            this.xct.cerrarConexionBd();
        } catch (SQLException ex) {
            Logger.getLogger(claseSo.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
    }

    private void mActualizar_Restricciones() {
        this.xsql = "delete from so_tmp_datos ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert into so_tmp_datos (Id_Atencion, Restriccion ) SELECT `h_so_concepto_laboral`.`Id_Atencion` , GROUP_CONCAT(`so_tipo_restriccion`.`Nbre` ,' ',IF(`h_so_concepto_laboral_restricciones`.`Tipo`=1,' TIPO : PERMANENTE','TIPO : TEMPORAL'),' ', IF(`h_so_concepto_laboral_restricciones`.`NDias`=0,' ', CONCAT('N NDIAS : ',`h_so_concepto_laboral_restricciones`.`NDias`)) ,' ',IF(`h_so_concepto_laboral_restricciones`.`Observacion`='', '', CONCAT('OBSERVACIÓN : ',`h_so_concepto_laboral_restricciones`.`Observacion`)) SEPARATOR '\n' ) AS `NTipo` FROM  `h_so_concepto_laboral_restricciones` INNER JOIN `h_so_concepto_laboral`  ON (`h_so_concepto_laboral_restricciones`.`Id_Concepto_Lab` = `h_so_concepto_laboral`.`Id`) INNER JOIN `so_tipo_restriccion`  ON (`h_so_concepto_laboral_restricciones`.`Id_Tipo_Restriccion` = `so_tipo_restriccion`.`Id`) WHERE (`h_so_concepto_laboral_restricciones`.`Estado` =1) GROUP BY `h_so_concepto_laboral`.`Id_Atencion`";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update so_manporwer_detalle, so_tmp_datos set so_manporwer_detalle.Restricciones=so_tmp_datos.Restriccion where so_manporwer_detalle.Id_Atencion=so_tmp_datos.Id_Atencion and so_manporwer_detalle.Restricciones is null ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    public void mActualizar_HConcepto() {
        this.xsql = "delete from so_tmp_datos ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "insert ignore into so_tmp_datos (Id_Atencion, Restriccion ) SELECT  `h_so_concepto_laboral`.`Id_UsuarioA` , GROUP_CONCAT( CONCAT( `h_atencion`.`Fecha_Atencion`, ' - ', `so_tipo_concepto`.`Nbre`, IF(`h_so_concepto_laboral`.`Observacion` ='', '', CONCAT(' - OBSERVACIÓN : ',  `h_so_concepto_laboral`.`Observacion`))) SEPARATOR '\n')  AS RM FROM  `h_so_concepto_laboral` INNER JOIN  `h_atencion`  ON (`h_so_concepto_laboral`.`Id_Atencion` = `h_atencion`.`Id`) INNER JOIN  `so_tipo_concepto`  ON (`h_so_concepto_laboral`.`Id_TipoC` = `so_tipo_concepto`.`Id`) WHERE (`h_so_concepto_laboral`.`Estado` =1) GROUP BY `h_so_concepto_laboral`.`Id_UsuarioA` ORDER BY `h_atencion`.`Fecha_Atencion` DESC ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
        this.xsql = "update so_manporwer_detalle, so_tmp_datos set so_manporwer_detalle.HConcepto=so_tmp_datos.Restriccion where so_manporwer_detalle.Id_Persona=so_tmp_datos.Id_Atencion ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }

    public void actualizarEstadoAtencion(Long idOrden, Long idProcedimiento, Integer estado) {
        this.xsql = "update f_itemordenesproced  set f_itemordenesproced.EsRecepcionado =" + estado + "\nwhere f_itemordenesproced.Id_Ordenes =" + idOrden + " and f_itemordenesproced.Id_Procedimiento=" + idProcedimiento + " ";
        this.xct.ejecutarSQL(this.xsql);
        this.xct.cerrarConexionBd();
    }
}
