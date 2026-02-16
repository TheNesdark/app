package Facturacion;

import Acceso.Principal;
import Utilidades.ConsultasMySQL;
import Utilidades.Metodos;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.jasper.builder.export.JasperPdfExporterBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.component.ComponentBuilder;
import net.sf.dynamicreports.report.builder.component.FillerBuilder;
import net.sf.dynamicreports.report.builder.component.HorizontalListBuilder;
import net.sf.dynamicreports.report.builder.component.ImageBuilder;
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.ComponentPositionType;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.ImageScale;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Furips_PB_V2023.class */
public class Furips_PB_V2023 {
    private static final int cellWidth = 10;
    private static final int cellHeight = 10;
    private StyleBuilder textStyle;
    private StyleBuilder centeredStyle;
    private StyleBuilder labelStyle;
    private StyleBuilder cellStyle;
    private StyleBuilder rootStyle;
    private StyleBuilder boldStyle;
    private StyleBuilder boldCenteredStyle;
    private StyleBuilder bold10CenteredStyle;
    private ImageBuilder image;
    static ResultSetMetaData rsmetadatos;
    private StyleBuilder bold14Style;
    private StyleBuilder styleCamposLabel;
    private String xidPersonaEvento;
    private String xidEvento;
    private String xidIngreso;
    private String xTraslado;
    private HorizontalListBuilder Remision;
    private String xNRadicacionG;
    private String xnValorG;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xFechaEgreso = "";
    private String xHoraEgreso = "";
    private String xDxEgreso = "";
    private String xDxEgreso2 = "";
    private String xDxEgreso3 = "";
    private String xDxPIngreso = "";
    private String confirmar = "SI";
    private String xApellido1 = "";
    private String xApellido2 = "";
    private String xNombre1 = "";
    private String xNombre2 = "";
    private String xTipoDoc = "";
    private String xNoDocumento = "";
    private String xRegMedico = "";
    private String xTotalEPS = "0";
    private String xTotalFosyga = "";
    private String xTotalTraslado = "0";
    private String xnFolio = "";
    private String urFirma = "";
    private Connection connection = this.xct.establecerConexionBd();

    public Furips_PB_V2023(String xidPersonaEvento, String xidEvento, String xidIngreso, String xNRadicacionG, String xnValorG, String xTraslado) {
        this.xidPersonaEvento = "";
        this.xidEvento = "";
        this.xidIngreso = "";
        this.xTraslado = "0";
        this.xNRadicacionG = "";
        this.xnValorG = "";
        this.xidPersonaEvento = xidPersonaEvento;
        this.xidEvento = xidEvento;
        this.xidIngreso = xidIngreso;
        this.xnValorG = xnValorG;
        this.xNRadicacionG = xNRadicacionG;
        this.xTraslado = xTraslado;
    }

    public JasperReportBuilder build() {
        ResultSet rsper;
        String xsql;
        String xsql2;
        String xsql3;
        ResultSet xrsFTraslado;
        this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "furipsPB_v2023.pdf"));
        JasperPdfExporterBuilder pdfExporter = DynamicReports.export.pdfExporter(this.xmt.getRutaRep() + "furipsPB_v2023.pdf");
        JasperReportBuilder report = DynamicReports.report();
        new Templates_1();
        try {
            Statement persona = this.connection.createStatement();
            Statement accidente = this.connection.createStatement();
            Statement AtencionIngreso = this.connection.createStatement();
            Statement AtencionEgreso = this.connection.createStatement();
            Statement factura = this.connection.createStatement();
            Statement traslado = this.connection.createStatement();
            Statement xProc = this.connection.createStatement();
            this.rootStyle = DynamicReports.stl.style().setPadding(2);
            this.boldStyle = DynamicReports.stl.style(this.rootStyle).bold();
            this.boldCenteredStyle = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP);
            this.bold10CenteredStyle = DynamicReports.stl.style(this.boldCenteredStyle).setFontSize(8);
            this.textStyle = DynamicReports.stl.style().setFontSize(8).setPadding(2);
            this.centeredStyle = DynamicReports.stl.style(this.textStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            this.labelStyle = DynamicReports.stl.style(this.textStyle).setFontSize(7).setHorizontalAlignment(HorizontalAlignment.LEFT).bold();
            this.cellStyle = DynamicReports.stl.style(this.textStyle).setBorder(DynamicReports.stl.pen1Point()).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            StyleBuilder styleEncabezados = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder styleCuadroBlanco = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder styleCuadroBlancoIzq = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder styleCuadroBlanco2 = DynamicReports.stl.style(this.bold14Style).setFontSize(8).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder columnStyle = DynamicReports.stl.style(Templates_1.columnStyle).setBorder(DynamicReports.stl.pen1Point());
            DynamicReports.stl.style(columnStyle).bold();
            DynamicReports.stl.style(Templates_1.boldStyle).setHorizontalAlignment(HorizontalAlignment.RIGHT);
            this.styleCamposLabel = DynamicReports.stl.style(this.bold14Style).setFontSize(9).bold().setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU DIVINO NIÑO") || Principal.informacionIps.getNombreIps().equals("FUNDACIÓN PANZENÚ") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CENTRO DE SALUD COTORRA") || Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getIdentificacion().equals("812005644") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JORGE DE AYAPEL") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                rsper = persona.executeQuery("SELECT  IF(`a_transp_mov`.`Placa` IS NULL, '', `a_transp_mov`.`Placa`) AS `Placa` , IF(`a_transp_mov`.`SitioEvento` IS NULL, '',`a_transp_mov`.`SitioEvento`) AS SitioEvento   , IF(`a_transp_mov`.`FinRecorrido` IS NULL,'',`a_transp_mov`.`FinRecorrido`) AS FinRecorrido , IF(`a_transp_mov`.`ZonaRecogeVict` IS NULL,'',`a_transp_mov`.`ZonaRecogeVict`) AS ZonaRecogeVict  ,IF( `a_transp_mov`.`Id_TipoServAmb` IS NULL, '' , `a_transp_mov`.`Id_TipoServAmb`) AS  Id_TipoServAmb, IF(`g_ips`.`Gerente` IS NULL,'',`g_ips`.`Gerente`) AS Administrador, IF(`g_ips`.`UrlFG` IS NULL,'',`g_ips`.`UrlFG`) AS  UrlFA  FROM g_ips, `a_transp_mov` RIGHT JOIN  `a_eventoecat_paciente`     ON (`a_transp_mov`.`Id_eventoecat_persona` = `a_eventoecat_paciente`.`Id`)  WHERE (`a_eventoecat_paciente`.`Id` ='" + this.xidPersonaEvento + "');");
                rsper.first();
            } else {
                rsper = persona.executeQuery("SELECT  IF(`a_transp_mov`.`Placa` IS NULL, '', `a_transp_mov`.`Placa`) AS `Placa` , IF(`a_transp_mov`.`SitioEvento` IS NULL, '',`a_transp_mov`.`SitioEvento`) AS SitioEvento   , IF(`a_transp_mov`.`FinRecorrido` IS NULL,'',`a_transp_mov`.`FinRecorrido`) AS FinRecorrido , IF(`a_transp_mov`.`ZonaRecogeVict` IS NULL,'',`a_transp_mov`.`ZonaRecogeVict`) AS ZonaRecogeVict  ,IF( `a_transp_mov`.`Id_TipoServAmb` IS NULL, '' , `a_transp_mov`.`Id_TipoServAmb`) AS  Id_TipoServAmb, IF(`g_ips`.`Administrador` IS NULL,'',`g_ips`.`Administrador`) AS Administrador, IF(`g_ips`.`UrlFA` IS NULL,'',`g_ips`.`UrlFA`) AS  UrlFA  FROM g_ips, `a_transp_mov` RIGHT JOIN  `a_eventoecat_paciente`     ON (`a_transp_mov`.`Id_eventoecat_persona` = `a_eventoecat_paciente`.`Id`)  WHERE (`a_eventoecat_paciente`.`Id` ='" + this.xidPersonaEvento + "');");
                rsper.first();
            }
            String xsql4 = "SELECT  `a_estadoasegveh`.`Id` AS `EstadoSeg`  , `a_marcavehiculo`.`Nbre` AS `marcaveh`  , `a_accidentetransito`.`Placa1Veh`   \n, `a_tipovehiculo`.`Id` AS `tipoveh`  , `a_aseguradora`.`Codigo` AS `aseguradora`  , `a_accidentetransito`.`NoPoliza`   \n, DATE_FORMAT(`a_accidentetransito`.`FechaInicPol`,'%d%m%Y')AS FechaInicPol , DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%d%m%Y') AS FechaFinPol  , `a_accidentetransito`.`IntAutoridad`  \n , `a_accidentetransito`.`Placa2Veh`  , IF(`g_tipoidentificacion_Prop2`.`Nbre` IS NULL,'',`g_tipoidentificacion_Prop2`.`Nbre`) AS `tdocprop2` , `a_accidentetransito`.`NoDocProp2`  \n, `a_accidentetransito`.`Placa3Veh`  , IF(`g_tipoidentificacion_Prop3`.`Nbre` IS NULL,'',`g_tipoidentificacion_Prop3`.`Nbre`) AS `tdocprop3`  , `a_accidentetransito`.`NoDocProp3`  \n, IF(`g_tipoidentificacion_Prop`.`Id` IS NULL,'', `g_tipoidentificacion_Prop`.`Id`) AS `tdocPROP`  , `a_accidentetransito`.`NodocumProp` , `a_accidentetransito`.`Apellido1Prop`  \n, `a_accidentetransito`.`Apellido2Prop`  , `a_accidentetransito`.`Nombre1Prop`  , `a_accidentetransito`.`Nombre2Prop`  , `a_accidentetransito`.`DireccionProp`  \n, `a_accidentetransito`.`TelefonoProp`  , IF(`g_departamento`.`Nbre` IS NULL,'',`g_departamento`.`Nbre`) AS `dptoPROP`,IF(`g_departamento`.`Id` IS NULL,'',`g_departamento`.`Id`) AS `CoddptoPROP` , IF(`g_municipio`.`Nbre` IS NULL,'',`g_municipio`.`Nbre`) AS `mpioPROP`,IF(`g_municipio`.`Id` IS NULL,'',`g_municipio`.`Id`) AS `CodmpioPROP`   \n, UPPER(`a_accidentetransito`.`Apellido1Cond`) AS Apellido1Cond, UPPER(`a_accidentetransito`.`Apellido2Cond`) AS Apellido2Cond , UPPER(`a_accidentetransito`.`Nombre1Cond`) AS Nombre1Cond, UPPER(`a_accidentetransito`.`Nombre2Cond`) AS Nombre2Cond  \n, IF(`g_tipoidentificacion_Cond`.`Id` IS NULL, '',`g_tipoidentificacion_Cond`.`Id`) AS `tdocCond`  , `a_accidentetransito`.`NodocumCond`  , `a_accidentetransito`.`DireccionCond`  \n, IF(`g_departamento_Cond`.`Nbre` IS NULL,'',UPPER(`g_departamento_Cond`.`Nbre`)) AS `dptoCond`,IF(`g_departamento_Cond`.`Id` IS NULL,'',`g_departamento_Cond`.`Id`) AS `CoddptoCond` , IF(`g_municipio_Cond`.`Nbre` IS NULL,'',`g_municipio_Cond`.`Nbre`) AS `mpioCond`, IF(`g_municipio_Cond`.`Id` IS NULL,'',SUBSTRING(`g_municipio_Cond`.`Id`,3,5)) AS `CodmpioCond`, `a_accidentetransito`.`TelefonoCond`, a_estadoasegveh.MPoliza   FROM  `a_accidentetransito`  INNER JOIN  `a_estadoasegveh`   ON (`a_accidentetransito`.`Id_estadoasegveh` = `a_estadoasegveh`.`Id`)  INNER JOIN  `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) INNER JOIN  `a_tipovehiculo`  ON (`a_accidentetransito`.`Id_tipovehiculo` = `a_tipovehiculo`.`Id`) INNER JOIN  `a_aseguradora`   ON (`a_accidentetransito`.`Id_aseguradora` = `a_aseguradora`.`Id`) LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop2` ON (`a_accidentetransito`.`TipodocProp2` = `g_tipoidentificacion_Prop2`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop`  ON (`a_accidentetransito`.`Id_tipodocProp` = `g_tipoidentificacion_Prop`.`Id`)  LEFT JOIN  `g_departamento`  ON (`a_accidentetransito`.`DepartProp` = `g_departamento`.`Id`)  LEFT JOIN  `g_municipio`  ON (`a_accidentetransito`.`MunicProp` = `g_municipio`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Cond`  ON (`a_accidentetransito`.`tipodocCond` = `g_tipoidentificacion_Cond`.`Id`)  LEFT JOIN  `g_departamento` AS `g_departamento_Cond`  ON (`a_accidentetransito`.`DepartCond` = `g_departamento_Cond`.`Id`)  LEFT JOIN  `g_municipio` AS `g_municipio_Cond`  ON (`a_accidentetransito`.`MunicCond` = `g_municipio_Cond`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop3`  ON (`a_accidentetransito`.`TipodocProp3` = `g_tipoidentificacion_Prop3`.`Id`)  WHERE (`a_accidentetransito`.`Id_eventoecat` ='" + this.xidEvento + "')";
            ResultSet xrsaccidente = accidente.executeQuery(xsql4);
            xrsaccidente.first();
            if (Principal.informacionIps.getIdentificacion().equals("812003851")) {
                xsql = "SELECT if(h_atencion.Fecha_Atencion is null, IF(`ingreso`.`FechaIngreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d%m%Y')),DATE_FORMAT(h_atencion.Fecha_Atencion,'%d%m%Y'))  AS FechaIngreso , DATE_FORMAT(`ingreso`.`HoraIngreso`,'%H%i') AS HoraIngreso , IF(ingreso_orden_salida.`FechaS` IS NULL, if(ingreso.HEgreso_H is null, IF(`ingreso`.`FechaIngreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d%m%Y')), DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d%m%Y')), DATE_FORMAT(ingreso_orden_salida.`FechaS`,'%d%m%Y'))  AS FechaEgreso  , IF(`h_atencion`.`Codigo_Dxp` IS NULL,'',`h_atencion`.`Codigo_Dxp`) AS Codigo_Dxp, IF(`h_atencion`.`Codigo_DxR1`IS NULL , '', `h_atencion`.`Codigo_DxR1`) AS Codigo_DxR1 , IF(`h_atencion`.`Codigo_DxR2` IS NULL, '', `h_atencion`.`Codigo_DxR2`) AS Codigo_DxR2,IF(`h_atencion`.`Codigo_DxR3` IS NULL, '', `h_atencion`.`Codigo_DxR3`) AS Codigo_DxR3  , IF(`profesional1`.`Apellido1` IS NULL,'' ,`profesional1`.`Apellido1`) AS  Apellido1 , IF(`profesional1`.`Apellido2` IS NULL ,'', `profesional1`.`Apellido2`) AS Apellido2  , IF(`profesional1`.`Nombre1` IS NULL, '', `profesional1`.`Nombre1`) AS Nombre1  , IF(`profesional1`.`Nombre2` IS NULL ,'', `profesional1`.`Nombre2`) AS Nombre2  , IF(`profesional1`.`Id_TipoIdentificacion` IS NULL ,'',`profesional1`.`Id_TipoIdentificacion`) AS Id_TipoIdentificacion  , IF(`profesional1`.`NoDocumento` IS NULL, '',`profesional1`.`NoDocumento`) AS NoDocumento , IF(`profesional1`.`Tarjeta` IS NULL,'',`profesional1`.`Tarjeta`) AS Tarjeta , IF(ingreso.Id_TipoAtencion IS NULL,'',ingreso.Id_TipoAtencion)AS Id_TipoAtencion, ingreso.DxIngreso, IF(ingreso_orden_salida.`FechaS` IS NULL,if(ingreso.HEgreso_H is null, if(h_atencion.Hora_Atencion is null, TIME_FORMAT(ADDTIME(`ingreso`.`HoraIngreso`,'00:30:00'),'%H%i'),TIME_FORMAT(ADDTIME(h_atencion.Hora_Atencion,'00:30:00'),'%H%i')) , TIME_FORMAT(ingreso.HEgreso_H,'%H%i')),TIME_FORMAT(ingreso_orden_salida.`HoraS`,'%H%i')) AS HoraSumada  FROM  `a_eventoecat_paciente` RIGHT JOIN `h_atencion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `h_atencion`.`Id_Ingreso`)  RIGHT JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  LEFT JOIN `profesional1`   ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`)  LEFT JOIN `ingreso_orden_salida` ON (ingreso_orden_salida.`Id_Ingreso`=`ingreso`.`Id`)  AND (ingreso_orden_salida.`Estado`=1)    WHERE (ingreso.`Id` ='" + this.xidIngreso + "')";
            } else {
                xsql = "SELECT if(h_atencion.Fecha_Atencion is null, IF(`ingreso`.`FechaIngreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d%m%Y')),DATE_FORMAT(h_atencion.Fecha_Atencion,'%d%m%Y'))  AS FechaIngreso , if(h_atencion.Hora_Atencion is null, IF(`ingreso`.`HoraIngreso` IS NULL ,'',DATE_FORMAT(`ingreso`.`HoraIngreso`,'%H%i')), DATE_FORMAT(h_atencion.Hora_Atencion,'%H%i')) AS HoraIngreso , IF(ingreso_orden_salida.`FechaS` IS NULL, if(ingreso.HEgreso_H is null, IF(`ingreso`.`FechaIngreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d%m%Y')), DATE_FORMAT(`ingreso`.`FEgreso_H`,'%d%m%Y')), DATE_FORMAT(ingreso_orden_salida.`FechaS`,'%d%m%Y'))  AS FechaEgreso  , IF(`h_atencion`.`Codigo_Dxp` IS NULL,'',`h_atencion`.`Codigo_Dxp`) AS Codigo_Dxp, IF(`h_atencion`.`Codigo_DxR1`IS NULL , '', `h_atencion`.`Codigo_DxR1`) AS Codigo_DxR1 , IF(`h_atencion`.`Codigo_DxR2` IS NULL, '', `h_atencion`.`Codigo_DxR2`) AS Codigo_DxR2,IF(`h_atencion`.`Codigo_DxR3` IS NULL, '', `h_atencion`.`Codigo_DxR3`) AS Codigo_DxR3  , IF(`profesional1`.`Apellido1` IS NULL,'' ,`profesional1`.`Apellido1`) AS  Apellido1 , IF(`profesional1`.`Apellido2` IS NULL ,'', `profesional1`.`Apellido2`) AS Apellido2  , IF(`profesional1`.`Nombre1` IS NULL, '', `profesional1`.`Nombre1`) AS Nombre1  , IF(`profesional1`.`Nombre2` IS NULL ,'', `profesional1`.`Nombre2`) AS Nombre2  , IF(`profesional1`.`Id_TipoIdentificacion` IS NULL ,'',`profesional1`.`Id_TipoIdentificacion`) AS Id_TipoIdentificacion  , IF(`profesional1`.`NoDocumento` IS NULL, '',`profesional1`.`NoDocumento`) AS NoDocumento , IF(`profesional1`.`Tarjeta` IS NULL,'',`profesional1`.`Tarjeta`) AS Tarjeta , IF(ingreso.Id_TipoAtencion IS NULL,'',ingreso.Id_TipoAtencion)AS Id_TipoAtencion, ingreso.DxIngreso, IF(ingreso_orden_salida.`FechaS` IS NULL,if(ingreso.HEgreso_H is null, if(h_atencion.Hora_Atencion is null, TIME_FORMAT(ADDTIME(`ingreso`.`HoraIngreso`,'00:30:00'),'%H%i'),TIME_FORMAT(ADDTIME(h_atencion.Hora_Atencion,'00:30:00'),'%H%i')) , TIME_FORMAT(ingreso.HEgreso_H,'%H%i')),TIME_FORMAT(ingreso_orden_salida.`HoraS`,'%H%i')) AS HoraSumada  FROM  `a_eventoecat_paciente` RIGHT JOIN `h_atencion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `h_atencion`.`Id_Ingreso`)  RIGHT JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  LEFT JOIN `profesional1`   ON (`profesional1`.`Id_Persona` = `h_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_atencion`.`Id_Especialidad`)  LEFT JOIN `ingreso_orden_salida` ON (ingreso_orden_salida.`Id_Ingreso`=`ingreso`.`Id`)  AND (ingreso_orden_salida.`Estado`=1)    WHERE (ingreso.`Id` ='" + this.xidIngreso + "')";
            }
            System.out.println("Ingreso " + xsql);
            ResultSet xrsAtencionI = AtencionIngreso.executeQuery(xsql);
            xrsAtencionI.first();
            if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                xsql2 = "SELECT  IF(ingreso_orden_salida.`FechaS` IS NULL, IF(`h_egreso_atencion`.`FechaSO` IS NULL,'',DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d%m%Y')), DATE_FORMAT(ingreso_orden_salida.`FechaS`,'%d%m%Y'))  AS FechaSO,IF(ingreso_orden_salida.`FechaS` IS NULL, IF(`h_egreso_atencion`.`HoraSO` IS NULL,'',DATE_FORMAT(`h_egreso_atencion`.`HoraSO`,'%H%i')),TIME_FORMAT(ingreso_orden_salida.`HoraS`,'%H%i'))AS HoraSO,IF(`h_egreso_atencion`.`DxP` IS NULL,'',`h_egreso_atencion`.`DxP`) AS DxP, IF(`h_egreso_atencion`.`DxR1` IS NULL,'',`h_egreso_atencion`.`DxR1`) AS DxR1  , IF(`h_egreso_atencion`.`DxR2` IS NULL,'',`h_egreso_atencion`.`DxR2`) AS DxR2 , IF(`h_egreso_atencion`.`DxR3` IS NULL,'',`h_egreso_atencion`.`DxR3`) AS DxR3, IF(`g_ips`.`Gerente` IS NULL,'',`g_ips`.`Gerente`) AS Administrador, IF(`g_ips`.`UrlFG` IS NULL,'',`g_ips`.`UrlFG`) AS  UrlFA  , IF(`profesional1`.`Apellido1` IS NULL,'' ,`profesional1`.`Apellido1`) AS  Apellido1 , IF(`profesional1`.`Apellido2` IS NULL ,'', `profesional1`.`Apellido2`) AS Apellido2  , IF(`profesional1`.`Nombre1` IS NULL, '', `profesional1`.`Nombre1`) AS Nombre1  , IF(`profesional1`.`Nombre2` IS NULL ,'', `profesional1`.`Nombre2`) AS Nombre2  , IF(`profesional1`.`Id_TipoIdentificacion` IS NULL ,'',`profesional1`.`Id_TipoIdentificacion`) AS Id_TipoIdentificacion  , IF(`profesional1`.`NoDocumento` IS NULL, '',`profesional1`.`NoDocumento`) AS NoDocumento , IF(`profesional1`.`Tarjeta` IS NULL,'',`profesional1`.`Tarjeta`) AS Tarjeta  FROM g_ips, `a_eventoecat_paciente` LEFT JOIN  `h_egreso_atencion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `h_egreso_atencion`.`Id_Ingreso`) AND (`h_egreso_atencion`.Id_Tipo='" + xrsAtencionI.getString("Id_TipoAtencion") + "') AND (h_egreso_atencion.`Estado`=1)  LEFT JOIN `profesional1`   ON (`profesional1`.`Id_Persona` = `h_egreso_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_egreso_atencion`.`Id_Especialidad`) LEFT JOIN ingreso_orden_salida   ON (`ingreso_orden_salida`.`Id_Ingreso` = `a_eventoecat_paciente`.`Id_Ingreso`)  WHERE ( `a_eventoecat_paciente`.`Id_Ingreso` ='" + this.xidIngreso + "')";
            } else if (Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL LOCAL DE MONTELIBANO") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO HOSPITAL SAN JOSE DE TIERRALTA") || Principal.informacionIps.getNombreIps().equals("EMPRESA SOCIAL DEL ESTADO CAMU CHIMA")) {
                xsql2 = "SELECT IF(ingreso.`Id_TipoAtencion`=1, DATE_FORMAT(ingreso.`FechaIngreso`,'%d%m%Y') , IF(ingreso_orden_salida.`FechaS` IS NULL, IF(`h_egreso_atencion`.`FechaSO` IS NULL,'',DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d%m%Y')), \nDATE_FORMAT(ingreso_orden_salida.`FechaS`,'%d%m%Y')))  AS FechaSO,\nIF(ingreso.`Id_TipoAtencion`=1, TIME_FORMAT(ADDTIME(`ingreso`.`HoraIngreso`,'00:30:00'),'%H%i')  , IF(ingreso_orden_salida.`FechaS` IS NULL, IF(`h_egreso_atencion`.`HoraSO` IS NULL,'',DATE_FORMAT(`h_egreso_atencion`.`HoraSO`,'%H%i')),TIME_FORMAT(ingreso_orden_salida.`HoraS`,'%H%i')))AS HoraSO,\nIF(ingreso.`Id_TipoAtencion`=1,IF( (ingreso.`DxIngreso`='' || ingreso.`DxIngreso`='0000'), IFNULL(h_atencion.`Codigo_Dxp`, ''), ingreso.`DxIngreso`),  IF(`h_egreso_atencion`.`DxP` IS NULL,'',`h_egreso_atencion`.`DxP`)) AS DxP\n, IF(ingreso.`Id_TipoAtencion`=1,IF( (ingreso.`DxIngreso`='' || ingreso.`DxIngreso`='0000'), IFNULL(h_atencion.`Codigo_DxR1`, ''), ''), IF(`h_egreso_atencion`.`DxR1` IS NULL,'',`h_egreso_atencion`.`DxR1`)) AS DxR1  \n, IF(ingreso.`Id_TipoAtencion`=1,IF( (ingreso.`DxIngreso`='' || ingreso.`DxIngreso`='0000'), IFNULL(h_atencion.`Codigo_DxR2`, ''), ''), IF(`h_egreso_atencion`.`DxR2` IS NULL,'',`h_egreso_atencion`.`DxR2`)) AS DxR2 \n, IF(ingreso.`Id_TipoAtencion`=1,IF( (ingreso.`DxIngreso`='' || ingreso.`DxIngreso`='0000'), IFNULL(h_atencion.`Codigo_DxR3`, ''), ''), IF(`h_egreso_atencion`.`DxR3` IS NULL,'',`h_egreso_atencion`.`DxR3`)) AS DxR3\n, IF(`g_ips`.`Gerente` IS NULL,'',`g_ips`.`Gerente`) AS Administrador, IF(`g_ips`.`UrlFG` IS NULL,'',`g_ips`.`UrlFG`) AS  UrlFA  \n, IF(ingreso.`Id_TipoAtencion`=1,profesionalA.Apellido1, IF(`profesional1`.`Apellido1` IS NULL,'' ,`profesional1`.`Apellido1`)) AS  Apellido1 \n, IF(ingreso.`Id_TipoAtencion`=1,profesionalA.Apellido2, IF(`profesional1`.`Apellido2` IS NULL ,'', `profesional1`.`Apellido2`)) AS Apellido2  \n, IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`Nombre1`, IF(`profesional1`.`Nombre1` IS NULL, '', `profesional1`.`Nombre1`)) AS Nombre1  ,\n IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`Nombre2`,IF(`profesional1`.`Nombre2` IS NULL ,'', `profesional1`.`Nombre2`)) AS Nombre2  \n , IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`Id_TipoIdentificacion`, IF(`profesional1`.`Id_TipoIdentificacion` IS NULL ,'',`profesional1`.`Id_TipoIdentificacion`)) AS Id_TipoIdentificacion  \n ,  IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`NoDocumento`, IF(`profesional1`.`NoDocumento` IS NULL, '',`profesional1`.`NoDocumento`)) AS NoDocumento \n , IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`Tarjeta`, IF(`profesional1`.`Tarjeta` IS NULL,'',`profesional1`.`Tarjeta`)) AS Tarjeta  \nFROM g_ips, `a_eventoecat_paciente` \nINNER JOIN ingreso ON (ingreso.`Id`=a_eventoecat_paciente.`Id_Ingreso`)\nINNER JOIN profesional1  profesionalA ON (`profesionalA`.`Id_Persona` = `ingreso`.`Id_Profesional`) AND (`profesionalA`.`IdEspecialidad` = `ingreso`.`Id_Especialidad`) \nLEFT  JOIN `h_atencion` ON (ingreso.`Id`=h_atencion.`Id_Ingreso`) LEFT JOIN  `h_egreso_atencion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `h_egreso_atencion`.`Id_Ingreso`)   AND (`h_egreso_atencion`.Id_Tipo='" + xrsAtencionI.getString("Id_TipoAtencion") + "') AND (h_egreso_atencion.`Estado`=1) \nLEFT JOIN `profesional1`   ON (`profesional1`.`Id_Persona` = `h_egreso_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_egreso_atencion`.`Id_Especialidad`) \nLEFT JOIN ingreso_orden_salida   ON (`ingreso_orden_salida`.`Id_Ingreso` = `a_eventoecat_paciente`.`Id_Ingreso`)  \n WHERE (`a_eventoecat_paciente`.`Id_Ingreso` ='" + this.xidIngreso + "')";
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S") || Principal.informacionIps.getNombreIps().equals("E.S.E. HOSPITAL SAN JUAN DE DIOS - Segovia")) {
                xsql2 = "SELECT IF(ingreso.`Id_TipoAtencion`=1, DATE_FORMAT(ingreso.`FechaIngreso`,'%d%m%Y') , IF(ingreso_orden_salida.`FechaS` IS NULL, IF(`h_egreso_atencion`.`FechaSO` IS NULL,'',DATE_FORMAT(`h_egreso_atencion`.`FechaSO`,'%d%m%Y')), \nDATE_FORMAT(ingreso_orden_salida.`FechaS`,'%d%m%Y')))  AS FechaSO,\nIF(ingreso.`Id_TipoAtencion`=1, IF(h_atencion.`Hora_Atencion` IS NULL, TIME_FORMAT(ADDTIME(`ingreso`.`HoraIngreso`,'00:30:00'),'%H%i'),TIME_FORMAT(ADDTIME(`h_atencion`.`Hora_Atencion`,'00:30:00'),'%H%i')), IF(ingreso_orden_salida.`FechaS` IS NULL, IF(`h_egreso_atencion`.`HoraSO` IS NULL,'',DATE_FORMAT(`h_egreso_atencion`.`HoraSO`,'%H%i')),TIME_FORMAT(ingreso_orden_salida.`HoraS`,'%H%i')))AS HoraSO,\nIF(ingreso.`Id_TipoAtencion`=1,IF( (ingreso.`DxIngreso`='' || ingreso.`DxIngreso`='0000'), IFNULL(h_atencion.`Codigo_Dxp`, ''), ingreso.`DxIngreso`),  IF(`h_egreso_atencion`.`DxP` IS NULL,'',`h_egreso_atencion`.`DxP`)) AS DxP\n, IF(ingreso.`Id_TipoAtencion`=1,IF( (ingreso.`DxIngreso`='' || ingreso.`DxIngreso`='0000'), IFNULL(h_atencion.`Codigo_DxR1`, ''), ''), IF(`h_egreso_atencion`.`DxR1` IS NULL,'',`h_egreso_atencion`.`DxR1`)) AS DxR1  \n, IF(ingreso.`Id_TipoAtencion`=1,IF( (ingreso.`DxIngreso`='' || ingreso.`DxIngreso`='0000'), IFNULL(h_atencion.`Codigo_DxR2`, ''), ''), IF(`h_egreso_atencion`.`DxR2` IS NULL,'',`h_egreso_atencion`.`DxR2`)) AS DxR2 \n, IF(ingreso.`Id_TipoAtencion`=1,IF( (ingreso.`DxIngreso`='' || ingreso.`DxIngreso`='0000'), IFNULL(h_atencion.`Codigo_DxR3`, ''), ''), IF(`h_egreso_atencion`.`DxR3` IS NULL,'',`h_egreso_atencion`.`DxR3`)) AS DxR3\n, IF(`g_ips`.`Gerente` IS NULL,'',`g_ips`.`Gerente`) AS Administrador, IF(`g_ips`.`UrlFG` IS NULL,'',`g_ips`.`UrlFG`) AS  UrlFA  \n, IF(ingreso.`Id_TipoAtencion`=1,profesionalA.Apellido1, IF(`profesional1`.`Apellido1` IS NULL,'' ,`profesional1`.`Apellido1`)) AS  Apellido1 \n, IF(ingreso.`Id_TipoAtencion`=1,profesionalA.Apellido2, IF(`profesional1`.`Apellido2` IS NULL ,'', `profesional1`.`Apellido2`)) AS Apellido2  \n, IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`Nombre1`, IF(`profesional1`.`Nombre1` IS NULL, '', `profesional1`.`Nombre1`)) AS Nombre1  ,\n IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`Nombre2`,IF(`profesional1`.`Nombre2` IS NULL ,'', `profesional1`.`Nombre2`)) AS Nombre2  \n , IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`Id_TipoIdentificacion`, IF(`profesional1`.`Id_TipoIdentificacion` IS NULL ,'',`profesional1`.`Id_TipoIdentificacion`)) AS Id_TipoIdentificacion  \n ,  IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`NoDocumento`, IF(`profesional1`.`NoDocumento` IS NULL, '',`profesional1`.`NoDocumento`)) AS NoDocumento \n , IF(ingreso.`Id_TipoAtencion`=1,`profesionalA`.`Tarjeta`, IF(`profesional1`.`Tarjeta` IS NULL,'',`profesional1`.`Tarjeta`)) AS Tarjeta  \nFROM g_ips, `a_eventoecat_paciente` \nINNER JOIN ingreso ON (ingreso.`Id`=a_eventoecat_paciente.`Id_Ingreso`)\nINNER JOIN profesional1  profesionalA ON (`profesionalA`.`Id_Persona` = `ingreso`.`Id_Profesional`) AND (`profesionalA`.`IdEspecialidad` = `ingreso`.`Id_Especialidad`) \nLEFT  JOIN `h_atencion` ON (ingreso.`Id`=h_atencion.`Id_Ingreso`) LEFT JOIN  `h_egreso_atencion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `h_egreso_atencion`.`Id_Ingreso`)   AND (`h_egreso_atencion`.Id_Tipo='" + xrsAtencionI.getString("Id_TipoAtencion") + "') AND (h_egreso_atencion.`Estado`=1) \nLEFT JOIN `profesional1`   ON (`profesional1`.`Id_Persona` = `h_egreso_atencion`.`Id_Profesional`) AND (`profesional1`.`IdEspecialidad` = `h_egreso_atencion`.`Id_Especialidad`) \nLEFT JOIN ingreso_orden_salida   ON (`ingreso_orden_salida`.`Id_Ingreso` = `a_eventoecat_paciente`.`Id_Ingreso`)  \n WHERE (`a_eventoecat_paciente`.`Id_Ingreso` =" + this.xidIngreso + ")";
            } else if (xrsAtencionI.getString("Id_TipoAtencion").equals("1")) {
                xsql2 = "SELECT  \n    IF(h_atencion.Fecha_Atencion IS NULL, \n       IF(ingreso.FechaIngreso IS NULL, '', DATE_FORMAT(ingreso.FechaIngreso,'%d%m%Y')), \n       DATE_FORMAT(h_atencion.Fecha_Atencion,'%d%m%Y')\n    ) AS FechaSO, \n    IF(h_atencion.Hora_Atencion IS NULL, \n       IF(ingreso.HoraIngreso IS NULL, '', DATE_FORMAT(ingreso.HoraIngreso,'%H%i')), \n       DATE_FORMAT(h_atencion.Hora_Atencion,'%H%i')\n    ) AS HoraSO, \n    IF(h_atencion.Codigo_Dxp IS NULL, ingreso.`DxIngreso`,IF(h_atencion.Codigo_Dxp ='',ingreso.`DxIngreso`,h_atencion.Codigo_Dxp)) AS DxP, \n    IF(h_atencion.Codigo_DxR1 IS NULL, '', h_atencion.Codigo_DxR1) AS DxR1, \n    IF(h_atencion.Codigo_DxR2 IS NULL, '', h_atencion.Codigo_DxR2) AS DxR2, \n    IF(h_atencion.Codigo_DxR3 IS NULL, '', h_atencion.Codigo_DxR3) AS DxR3, \n    IF(profesional1.Apellido1 IS NULL, '', profesional1.Apellido1) AS Apellido1, \n    IF(profesional1.Apellido2 IS NULL, '', profesional1.Apellido2) AS Apellido2, \n    IF(profesional1.Nombre1 IS NULL, '', profesional1.Nombre1) AS Nombre1, \n    IF(profesional1.Nombre2 IS NULL, '', profesional1.Nombre2) AS Nombre2, \n    IF(profesional1.Id_TipoIdentificacion IS NULL, '', profesional1.Id_TipoIdentificacion) AS Id_TipoIdentificacion, \n    IF(profesional1.NoDocumento IS NULL, '', profesional1.NoDocumento) AS NoDocumento, \n    IF(profesional1.Tarjeta IS NULL, '', profesional1.Tarjeta) AS Tarjeta,\n    IF(g_ips.Administrador IS NULL, '', g_ips.Administrador) AS Administrador, \n    IF(g_ips.UrlFA IS NULL, '', g_ips.UrlFA) AS UrlFA \nFROM \n    g_ips, \n    a_eventoecat_paciente\nINNER JOIN ingreso \n    ON a_eventoecat_paciente.Id_Ingreso = ingreso.Id\nINNER JOIN h_atencion \n    ON ingreso.Id = h_atencion.Id_Ingreso\nLEFT JOIN profesional1 \n    ON profesional1.Id_Persona = ingreso.Id_Profesional \n    AND profesional1.IdEspecialidad = ingreso.Id_Especialidad\nLEFT JOIN ingreso_orden_salida \n    ON ingreso_orden_salida.Id_Ingreso = a_eventoecat_paciente.Id_Ingreso\nWHERE \n    a_eventoecat_paciente.Id_Ingreso ='" + this.xidIngreso + "';";
            } else {
                xsql2 = "SELECT  IF(ingreso_orden_salida.FechaS IS NULL, IF(h_egreso_atencion.FechaSO IS NULL,'',DATE_FORMAT(h_egreso_atencion.FechaSO,'%d%m%Y')), DATE_FORMAT(ingreso_orden_salida.FechaS,'%d%m%Y'))  AS FechaSO,IF(ingreso_orden_salida.FechaS IS NULL, IF(h_egreso_atencion.HoraSO IS NULL,'',DATE_FORMAT(h_egreso_atencion.HoraSO,'%H%i')),TIME_FORMAT(ingreso_orden_salida.HoraS,'%H%i'))AS HoraSO,IF(h_egreso_atencion.DxP IS NULL,'',h_egreso_atencion.DxP) AS DxP, IF(h_egreso_atencion.DxR1 IS NULL,'',h_egreso_atencion.DxR1) AS DxR1  , IF(h_egreso_atencion.DxR2 IS NULL,'',h_egreso_atencion.DxR2) AS DxR2 , IF(h_egreso_atencion.DxR3 IS NULL,'',h_egreso_atencion.DxR3) AS DxR3, IF(g_ips.Administrador IS NULL,'',g_ips.Administrador) AS Administrador, IF(g_ips.UrlFA IS NULL,'',g_ips.UrlFA) AS  UrlFA  , IF(profesional1.Apellido1 IS NULL,'' ,profesional1.Apellido1) AS  Apellido1 , IF(profesional1.Apellido2 IS NULL ,'', profesional1.Apellido2) AS Apellido2  , IF(profesional1.Nombre1 IS NULL, '', profesional1.Nombre1) AS Nombre1  , IF(profesional1.Nombre2 IS NULL ,'', profesional1.Nombre2) AS Nombre2  , IF(profesional1.Id_TipoIdentificacion IS NULL ,'',profesional1.Id_TipoIdentificacion) AS Id_TipoIdentificacion  , IF(profesional1.NoDocumento IS NULL, '',profesional1.NoDocumento) AS NoDocumento , IF(profesional1.Tarjeta IS NULL,'',profesional1.Tarjeta) AS Tarjeta  FROM g_ips, a_eventoecat_paciente LEFT JOIN  h_egreso_atencion   ON (a_eventoecat_paciente.Id_Ingreso = h_egreso_atencion.Id_Ingreso) AND (h_egreso_atencion.Id_Tipo='" + xrsAtencionI.getString("Id_TipoAtencion") + "') AND (h_egreso_atencion.Estado=1)   LEFT JOIN profesional1   ON (profesional1.Id_Persona = h_egreso_atencion.Id_Profesional) AND (profesional1.IdEspecialidad = h_egreso_atencion.Id_Especialidad) LEFT JOIN ingreso_orden_salida ON (ingreso_orden_salida.Id_Ingreso = a_eventoecat_paciente.Id_Ingreso)  WHERE ( a_eventoecat_paciente.Id_Ingreso ='" + this.xidIngreso + "'\n-- AND h_egreso_atencion.Estado=1\n )";
            }
            System.out.println(xsql2);
            ResultSet xrsAtencionE = AtencionEgreso.executeQuery(xsql2);
            xrsAtencionE.first();
            String xsql5 = "SELECT `f_liquidacion`.`Id` , \n IF(`f_factura_evento`.`Prefijo`='',`f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`))AS `No_FacturaEvento` , \n `f_factura_evento`.`Prefijo` ,`f_liquidacion`.`TotalEps` , `a_accidentetransito`.`Id_estadoasegveh`, if(f_liquidacion.NFolios=0, '',f_liquidacion.NFolios) NFolios  \n FROM `a_eventoecat_paciente` INNER JOIN  `a_eventoecat`   ON (`a_eventoecat_paciente`.`Id_Eventoecat` = `a_eventoecat`.`Id`)  INNER JOIN `a_accidentetransito`   ON (`a_accidentetransito`.`Id_eventoecat` = `a_eventoecat`.`Id`)  LEFT JOIN `f_liquidacion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `f_liquidacion`.`Id_Ingreso`)\n    LEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)\n    WHERE (`a_eventoecat_paciente`.`Id_Ingreso` ='" + this.xidIngreso + "'  AND `f_liquidacion`.`Estado` =0) GROUP BY `f_liquidacion`.`Id`";
            System.out.println("De la factura " + xsql5);
            ResultSet xrsFactura = factura.executeQuery(xsql5);
            if (xrsFactura.next()) {
                xrsFactura.first();
                this.xTotalEPS = xrsFactura.getString("TotalEps");
                this.xnFolio = xrsFactura.getString("NFolios");
                System.out.println("Estado : " + xrsaccidente.getInt("MPoliza"));
                if (xrsaccidente.getInt("MPoliza") != 1) {
                    this.xTotalFosyga = xrsFactura.getString("TotalEps");
                } else {
                    this.xTotalFosyga = "0";
                }
            }
            if (Principal.informacionIps.getIdentificacion().equals("812005644")) {
                xsql3 = "SELECT `f_liquidacion`.`Id` ,   IF(`f_factura_evento`.`Prefijo`='',`f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`))AS `No_FacturaEvento` ,    `f_factura_evento`.`Prefijo` ,`f_liquidacion`.`TotalEps`, ((f_itemordenesproced.`ValorUnitario` * f_itemordenesproced.`Cantidad`)+f_itemordenesproced.valorImpuesto) AS ValorTraslado FROM `a_eventoecat_paciente` LEFT JOIN `f_liquidacion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `f_liquidacion`.`Id_Ingreso`)   LEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  LEFT JOIN ingreso ON (a_eventoecat_paciente.`Id_Ingreso`=ingreso.`Id`) LEFT JOIN `f_ordenes` ON (ingreso.`Id`=f_ordenes.`Id_Ingreso`) LEFT JOIN `f_itemordenesproced` ON (f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`) LEFT JOIN `g_procedimiento` ON (f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`) WHERE (`a_eventoecat_paciente`.`Id_Ingreso` ='" + this.xidIngreso + "'  AND `f_ordenes`.`Estado`=0 AND g_procedimiento.`Id_tipoprocedimiento`=14  and g_procedimiento.`Id`in(9394025))  GROUP BY `f_liquidacion`.`Id`";
                xrsFTraslado = traslado.executeQuery(xsql3);
            } else if (Principal.informacionIps.getNombreIps().equals("CLINICA PAJONAL S.A.S")) {
                xsql3 = "SELECT `f_liquidacion`.`Id` ,   IF(`f_factura_evento`.`Prefijo`='',`f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`))AS `No_FacturaEvento` ,    `f_factura_evento`.`Prefijo` ,`f_liquidacion`.`TotalEps`, ((f_itemordenesproced.`ValorUnitario` * f_itemordenesproced.`Cantidad`)+f_itemordenesproced.valorImpuesto) AS ValorTraslado FROM `a_eventoecat_paciente` LEFT JOIN `f_liquidacion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `f_liquidacion`.`Id_Ingreso`)   LEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  LEFT JOIN ingreso ON (a_eventoecat_paciente.`Id_Ingreso`=ingreso.`Id`) LEFT JOIN `f_ordenes` ON (ingreso.`Id`=f_ordenes.`Id_Ingreso`) LEFT JOIN `f_itemordenesproced` ON (f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`) LEFT JOIN `g_procedimiento` ON (f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`) WHERE (`a_eventoecat_paciente`.`Id_Ingreso` ='" + this.xidIngreso + "'  AND `f_ordenes`.`Estado`=0 AND g_procedimiento.`Id_tipoprocedimiento`=14 AND `g_procedimiento`.`esTrasladoPrimario`=1 )  GROUP BY `f_liquidacion`.`Id`";
                xrsFTraslado = traslado.executeQuery(xsql3);
            } else if (Principal.informacionIps.getNombreIps().equals("CAMI SAS")) {
                xsql3 = "SELECT `f_liquidacion`.`Id` ,   IF(`f_factura_evento`.`Prefijo`='',`f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`))AS `No_FacturaEvento` ,    \n`f_factura_evento`.`Prefijo` ,(`f_liquidacion`.`TotalEps` + ((f_itemordenesproced.`ValorUnitario` * f_itemordenesproced.`Cantidad`)+f_itemordenesproced.valorImpuesto)) AS ValorTraslado \nFROM `a_eventoecat_paciente` \nLEFT JOIN `f_liquidacion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `f_liquidacion`.`Id_Ingreso`)   \nLEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  \nLEFT JOIN ingreso ON (a_eventoecat_paciente.`Id_Ingreso`=ingreso.`Id`) \nLEFT JOIN `f_ordenes` ON (ingreso.`Id`=f_ordenes.`Id_Ingreso`) \nLEFT JOIN `f_itemordenesproced` ON (f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`) \nLEFT JOIN `g_procedimiento` ON (f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`) \nWHERE (`a_eventoecat_paciente`.`Id_Ingreso` ='" + this.xidIngreso + "'   \nAND `f_ordenes`.`Estado`=0 AND g_procedimiento.`Id_tipoprocedimiento`=14 AND g_procedimiento.`esTrasladoPrimario`=1 )  \nGROUP BY `f_liquidacion`.`Id`";
                xrsFTraslado = traslado.executeQuery(xsql3);
            } else if (Principal.informacionIps.getIdentificacion().equals("812000317") || Principal.informacionIps.getIdentificacion().equals("812001579")) {
                xsql3 = "SELECT\n\tf_liquidacion.Id ,\n\tIF(f_factura_evento.Prefijo = '', f_factura_evento.No_FacturaEvento_M, CONCAT(f_factura_evento.Prefijo, f_factura_evento.No_FacturaEvento_M))AS No_FacturaEvento ,\n\tf_factura_evento.Prefijo,\n\tf_liquidacion.TotalEps,\n\tIF(g_procedimiento.esTrasladoPrimario = 0, ((f_itemordenesproced.ValorUnitario * f_itemordenesproced.Cantidad) + f_itemordenesproced.valorImpuesto),0) AS ValorTraslado\nFROM\n\ta_eventoecat_paciente\nLEFT JOIN f_liquidacion ON\n\t(a_eventoecat_paciente.Id_Ingreso = f_liquidacion.Id_Ingreso)\nLEFT JOIN f_factura_evento ON\n\t(f_factura_evento.Id_Liquidacion = f_liquidacion.Id)\nLEFT JOIN ingreso ON\n\t(a_eventoecat_paciente.Id_Ingreso = ingreso.Id)\nLEFT JOIN f_ordenes ON\n\t(ingreso.Id = f_ordenes.Id_Ingreso)\nLEFT JOIN f_itemordenesproced ON\n\t(f_ordenes.Id = f_itemordenesproced.Id_Ordenes)\nLEFT JOIN g_procedimiento ON\n\t(f_itemordenesproced.Id_Procedimiento = g_procedimiento.Id)\nWHERE\n\t(a_eventoecat_paciente.Id_Ingreso = '" + this.xidIngreso + "'\n\t\tAND f_ordenes.Estado = 0\n\t\tAND g_procedimiento.Id_tipoprocedimiento = 14)\nGROUP BY\n\tf_liquidacion.Id";
                xrsFTraslado = traslado.executeQuery(xsql3);
            } else {
                xsql3 = "SELECT `f_liquidacion`.`Id` ,   IF(`f_factura_evento`.`Prefijo`='',`f_factura_evento`.`No_FacturaEvento_M`,CONCAT(`f_factura_evento`.`Prefijo`,`f_factura_evento`.`No_FacturaEvento_M`))AS `No_FacturaEvento` ,    `f_factura_evento`.`Prefijo` ,`f_liquidacion`.`TotalEps`, ((f_itemordenesproced.`ValorUnitario` * f_itemordenesproced.`Cantidad`)+f_itemordenesproced.valorImpuesto) AS ValorTraslado FROM `a_eventoecat_paciente` LEFT JOIN `f_liquidacion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `f_liquidacion`.`Id_Ingreso`)   LEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`)  LEFT JOIN ingreso ON (a_eventoecat_paciente.`Id_Ingreso`=ingreso.`Id`) LEFT JOIN `f_ordenes` ON (ingreso.`Id`=f_ordenes.`Id_Ingreso`) LEFT JOIN `f_itemordenesproced` ON (f_ordenes.`Id`=f_itemordenesproced.`Id_Ordenes`) LEFT JOIN `g_procedimiento` ON (f_itemordenesproced.`Id_Procedimiento`=g_procedimiento.`Id`) WHERE (`a_eventoecat_paciente`.`Id_Ingreso` ='" + this.xidIngreso + "'  AND `f_ordenes`.`Estado`=0 AND g_procedimiento.`Id_tipoprocedimiento`=14 AND g_procedimiento.`esTrasladoPrimario`=1)  GROUP BY `f_liquidacion`.`Id`";
                xrsFTraslado = traslado.executeQuery(xsql3);
            }
            System.out.println("Traslado : " + xsql3);
            if (xrsFTraslado.next()) {
                xrsFTraslado.first();
                this.xTotalTraslado = xrsFTraslado.getString("ValorTraslado");
            }
            ResultSet xrsRemisionPac = traslado.executeQuery("SELECT\n     IF(ingreso_orden_salida.`FechaS` IS NULL,DATE_FORMAT(`h_remisiones`.`FechaA`,'%d%m%Y'),DATE_FORMAT(ingreso_orden_salida.`FechaS`,'%d%m%Y')) FechaR\n    , IF(ingreso_orden_salida.`HoraS` IS NULL,TIME_FORMAT(`h_remisiones`.`HoraA`,'%H%i'), TIME_FORMAT(ingreso_orden_salida.`HoraS`,'%H%i')) HoraR\n    , `g_ips`.`Nbre` AS NombreEmpresa\n    , `g_ips`.`CodigoOrganismo`\n    , `profesional1`.`NProfesional`\n    , `profesional1`.`Especialidad`,  DATE_FORMAT(IFNULL(h_remisiones.FechaA,`h_remisiones`.`Fecha`),'%d%m%Y') FechaA \n    ,  TIME_FORMAT(IFNULL(h_remisiones.HoraA, `h_remisiones`.`Hora`),'%H%i')  HoraT,\n     h_remisiones.NInstitucion, h_remisiones.MedicosRecibe, h_remisiones.ProfesionPR, h_remisiones.CHabilitacion , h_remisiones.PlacaAmbulancia \nFROM\n     `h_remisiones`\n    INNER JOIN  `h_atencion` \n        ON (`h_remisiones`.`Id_Atencion` = `h_atencion`.`Id`)\n    INNER JOIN  `ingreso` \n        ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)\n    INNER JOIN  `f_empresacontxconvenio` \n        ON (`ingreso`.`Id_EmpresaContxConv` = `f_empresacontxconvenio`.`Id`)\n    INNER JOIN  `g_ips` \n        ON (`f_empresacontxconvenio`.`Id_GIps` = `g_ips`.`Id`)\n    INNER JOIN  `profesional1` \n        ON (`profesional1`.`IdEspecialidad` = `h_remisiones`.`Id_EspecialidadR`) AND (`profesional1`.`Id_Persona` = `h_remisiones`.`Id_Profesional`)\n LEFT JOIN `ingreso_orden_salida` ON (`ingreso_orden_salida`.`Id_Ingreso` = `h_atencion`.`Id_Ingreso`) \nWHERE (`h_atencion`.`Id_Ingreso` ='" + this.xidIngreso + "' AND h_remisiones.Tipo=1 AND h_remisiones.Estado=0);");
            if (xrsRemisionPac != null) {
                if (xrsRemisionPac.next()) {
                    xrsRemisionPac.first();
                    this.Remision = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo Referencia:", 10), emptyCell(2), label("Remisión", 5), emptyCell(1), textCell("X", 1), emptyCell(4), label("Orden de Servicio", 8), emptyCell(1), textCell("", 1)}).newRow(2).add(new ComponentBuilder[]{label("Fecha de Remisión", 9), emptyCell(1), textCell(xrsRemisionPac.getString("FechaR"), 8), emptyCell(3), label("a las", 3), emptyCell(1), textCell(xrsRemisionPac.getString("HoraR"), 4)}).newRow(2).add(new ComponentBuilder[]{label("Prestador que remite", 9), emptyCell(1), DynamicReports.cmp.text(xrsRemisionPac.getString("NombreEmpresa")).setStyle(styleCuadroBlancoIzq)}).newRow(3).add(new ComponentBuilder[]{label("Código de Inscripción:", 10), textCell(xrsRemisionPac.getString("CodigoOrganismo"), 12)}).newRow(3).add(new ComponentBuilder[]{label("Profesional que remite", 10), DynamicReports.cmp.text(xrsRemisionPac.getString("NProfesional")).setStyle(styleCuadroBlancoIzq), emptyCell(4), label("Cargo", 3), emptyCell(1), DynamicReports.cmp.text(xrsRemisionPac.getString("Especialidad")).setStyle(styleCuadroBlancoIzq)}).newRow(5).add(new ComponentBuilder[]{label("Fecha de Aceptación", 9), emptyCell(1), textCell(xrsRemisionPac.getString("FechaA"), 8), emptyCell(3), label("a las", 3), emptyCell(1), textCell(xrsRemisionPac.getString("HoraT"), 4)}).newRow(2).add(new ComponentBuilder[]{label("Prestador que Recibe:", 9), emptyCell(1), DynamicReports.cmp.text(xrsRemisionPac.getString("NInstitucion")).setStyle(styleCuadroBlancoIzq)}).newRow(3).add(new ComponentBuilder[]{label("Código de Inscripción:", 10), DynamicReports.cmp.text(xrsRemisionPac.getString("CHabilitacion")).setStyle(styleCuadroBlancoIzq)}).add(new ComponentBuilder[]{emptyCell(5), label("Placa Ambulacian:", 8), DynamicReports.cmp.text(xrsRemisionPac.getString("PlacaAmbulancia")).setStyle(styleCuadroBlancoIzq)}).newRow(1).add(new ComponentBuilder[]{label("Profesional que recibe", 10), DynamicReports.cmp.text(xrsRemisionPac.getString("MedicosRecibe")).setStyle(styleCuadroBlancoIzq), emptyCell(4), label("Cargo", 3), emptyCell(1), DynamicReports.cmp.text(xrsRemisionPac.getString("ProfesionPR")).setStyle(styleCuadroBlancoIzq)}).newRow(5);
                } else {
                    this.Remision = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo Referencia:", 10), emptyCell(2), label("Remisión", 5), emptyCell(1), textCell("", 1), emptyCell(4), label("Orden de Servicio", 8), emptyCell(1), textCell("", 1)}).newRow(2).add(new ComponentBuilder[]{label("Fecha de Remisión", 9), emptyCell(1), textCell("DDMMAAAA", 8), emptyCell(3), label("a las", 3), emptyCell(1), textCell("HHMM", 4)}).newRow(2).add(new ComponentBuilder[]{label("Prestador que remite", 9), emptyCell(1), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlancoIzq)}).newRow(3).add(new ComponentBuilder[]{label("Código de Inscripción:", 10), textCell(" ", 12)}).newRow(3).add(new ComponentBuilder[]{label("Profesional que remite", 10), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlancoIzq), emptyCell(4), label("Cargo", 3), emptyCell(1), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlancoIzq)}).newRow(5).add(new ComponentBuilder[]{label("Fecha de Aceptación", 9), emptyCell(1), textCell("DDMMAAAA", 8), emptyCell(3), label("a las", 3), emptyCell(1), textCell("HHMM", 4)}).newRow(2).add(new ComponentBuilder[]{label("Prestador que Recibe:", 9), emptyCell(1), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlancoIzq)}).newRow(3).add(new ComponentBuilder[]{label("Código de Inscripción:", 10), textCell(" ", 12)}).add(new ComponentBuilder[]{emptyCell(5), label("Placa Ambulacia:", 8), textCell(" ", 6)}).newRow(3).add(new ComponentBuilder[]{label("Profesional que recibe", 10), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlancoIzq), emptyCell(4), label("Cargo", 3), emptyCell(1), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlancoIzq)}).newRow(5);
                }
            } else {
                this.Remision = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo Referencia:", 10), emptyCell(2), label("Remisión", 5), emptyCell(1), textCell("", 1), emptyCell(4), label("Orden de Servicio", 8), emptyCell(1), textCell("", 1)}).newRow(2).add(new ComponentBuilder[]{label("Fecha de Remisión", 9), emptyCell(1), textCell("DDMMAAAA", 8), emptyCell(3), label("a las", 3), emptyCell(1), textCell("HHMM", 4)}).newRow(2).add(new ComponentBuilder[]{label("Prestador que remite", 9), emptyCell(1), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlanco)}).newRow(3).add(new ComponentBuilder[]{label("Código de Inscripción:", 10), textCell(" ", 12)}).newRow(3).add(new ComponentBuilder[]{label("Profesional que remite", 10), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlanco), emptyCell(4), label("Cargo", 3), emptyCell(1), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlanco)}).newRow(5).add(new ComponentBuilder[]{label("Fecha de Aceptación", 9), emptyCell(1), textCell("DDMMAAAA", 8), emptyCell(3), label("a las", 3), emptyCell(1), textCell("HHMM", 4)}).newRow(2).add(new ComponentBuilder[]{label("Prestador que Recibe:", 9), emptyCell(1), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlanco)}).newRow(3).add(new ComponentBuilder[]{label("Código de Inscripción:", 10), textCell(" ", 12)}).add(new ComponentBuilder[]{emptyCell(5), label("Placa Ambulacia:", 8), textCell(" ", 6)}).newRow(3).add(new ComponentBuilder[]{label("Profesional que recibe", 10), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlanco), emptyCell(4), label("Cargo", 3), emptyCell(1), DynamicReports.cmp.text(" ").setStyle(styleCuadroBlanco)}).newRow(5);
            }
            ComponentBuilder componentBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP(xrsaccidente.getString("Apellido1Cond"), 25), emptyCell(5)}).add(new ComponentBuilder[]{labelP(xrsaccidente.getString("Apellido2Cond"), 25)}).newRow(2).add(new ComponentBuilder[]{emptyCell(10), label("1er Apellido", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Apellido", 11)}).newRow(2).add(new ComponentBuilder[]{labelP(xrsaccidente.getString("Nombre1Cond"), 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(xrsaccidente.getString("Nombre2Cond"), 25)}).newRow(2).add(new ComponentBuilder[]{emptyCell(10), label("1er Nombre", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Nombre", 11)}).newRow(2).add(new ComponentBuilder[]{TipoDocumento(xrsaccidente.getString("tdocCond")), emptyCell(4)}).newRow(1).add(new ComponentBuilder[]{label("No. Documento", 8), emptyCell(2), textCell(xrsaccidente.getString("NodocumCond"), 16)}).newRow(1).add(new ComponentBuilder[]{label("Dirección Residencia", 9), emptyCell(1), textCell(xrsaccidente.getString("DireccionCond"), 40)}).newRow(2).add(new ComponentBuilder[]{label("Departamento", 9), emptyCell(1), textCell(xrsaccidente.getString("dptoCond"), 16)}).add(new ComponentBuilder[]{emptyCell(5), label("Cod.", 3), emptyCell(1), textCell(xrsaccidente.getString("CoddptoCond"), 2)}).add(new ComponentBuilder[]{emptyCell(6), label("Telefono", 5), emptyCell(1), textCell(xrsaccidente.getString("TelefonoCond"), 10)}).newRow(2).add(new ComponentBuilder[]{label("Municipio", 9), emptyCell(1), textCell(xrsaccidente.getString("mpioCond"), 18)}).add(new ComponentBuilder[]{emptyCell(3), label("Cod.", 3), emptyCell(1), textCell(xrsaccidente.getString("CodmpioCond"), 3)}).newRow();
            ComponentBuilder componentBuilderNewRow2 = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Diligenciar únicamente para el transporte desde el sitio del evento hasta la primera IPS (trasnporte primario) y cuando se realiza en ambulancias de la misma IPS.", 58)}).newRow(2).add(new ComponentBuilder[]{label("Datos de Vehículo", 10), emptyCell(2), label("Placa No.", 4), emptyCell(2), textCell(rsper.getString("Placa"), 6)}).newRow(2).add(new ComponentBuilder[]{label("Transporto la víctima desde", 12), emptyCell(1), DynamicReports.cmp.text(rsper.getString("SitioEvento")).setStyle(styleCuadroBlanco), emptyCell(2), label("Hasta", 5), DynamicReports.cmp.text(rsper.getString("FinRecorrido")).setStyle(styleCuadroBlanco)}).newRow(4).add(new ComponentBuilder[]{Transporte(rsper.getString("Id_TipoServAmb"))}).add(new ComponentBuilder[]{emptyCell(3), Zona(rsper.getString("ZonaRecogeVict"))}).newRow(3);
            if (xrsAtencionI.getString("Id_TipoAtencion").equals("1")) {
                if (xrsAtencionI.getString("DxIngreso").equals("0000")) {
                    this.xApellido1 = xrsAtencionE.getString("Apellido1");
                    this.xApellido2 = xrsAtencionE.getString("Apellido2");
                    this.xNombre1 = xrsAtencionE.getString("Nombre1");
                    this.xNombre2 = xrsAtencionE.getString("Nombre2");
                    this.xTipoDoc = xrsAtencionE.getString("Id_TipoIdentificacion");
                    this.xNoDocumento = xrsAtencionE.getString("NoDocumento");
                    this.xRegMedico = xrsAtencionE.getString("Tarjeta");
                    this.xFechaEgreso = xrsAtencionE.getString("FechaSO");
                    this.xHoraEgreso = xrsAtencionE.getString("HoraSO");
                    this.xDxEgreso = xrsAtencionE.getString("DxP");
                    this.xDxEgreso2 = xrsAtencionE.getString("DxR1");
                    this.xDxEgreso3 = xrsAtencionE.getString("DxR2");
                } else {
                    ResultSet xrsProcedimiento = xProc.executeQuery("SELECT IF(`ingreso`.`FechaIngreso` IS NULL, '', DATE_FORMAT(`ingreso`.`FechaIngreso`,'%d%m%Y')) AS FechaIngreso , IF(`ingreso`.`HoraIngreso` IS NULL ,'',DATE_FORMAT(`ingreso`.`HoraIngreso`,'%H%i')) AS HoraIngreso  , IF(`h_atencion`.`Codigo_Dxp` IS NULL,'',`h_atencion`.`Codigo_Dxp`) AS Codigo_Dxp, IF(`h_atencion`.`Codigo_DxR1`IS NULL , '', `h_atencion`.`Codigo_DxR1`) AS Codigo_DxR1 , IF(`h_atencion`.`Codigo_DxR2` IS NULL, '', `h_atencion`.`Codigo_DxR2`) AS Codigo_DxR2,IF(`h_atencion`.`Codigo_DxR3` IS NULL, '', `h_atencion`.`Codigo_DxR3`) AS Codigo_DxR3  , IF(`profesional1`.`Apellido1` IS NULL,'' ,`profesional1`.`Apellido1`) AS  Apellido1 , IF(`profesional1`.`Apellido2` IS NULL ,'', `profesional1`.`Apellido2`) AS Apellido2  , IF(`profesional1`.`Nombre1` IS NULL, '', `profesional1`.`Nombre1`) AS Nombre1  , IF(`profesional1`.`Nombre2` IS NULL ,'', `profesional1`.`Nombre2`) AS Nombre2  , IF(`profesional1`.`Id_TipoIdentificacion` IS NULL ,'',`profesional1`.`Id_TipoIdentificacion`) AS Id_TipoIdentificacion  , IF(`profesional1`.`NoDocumento` IS NULL, '',`profesional1`.`NoDocumento`) AS NoDocumento , IF(`profesional1`.`Tarjeta` IS NULL,'',`profesional1`.`Tarjeta`) AS Tarjeta , IF(ingreso.Id_TipoAtencion IS NULL,'',ingreso.Id_TipoAtencion)AS Id_TipoAtencion, ingreso.DxIngreso  FROM  `a_eventoecat_paciente` RIGHT JOIN `h_atencion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `h_atencion`.`Id_Ingreso`)  RIGHT JOIN `ingreso`  ON (`h_atencion`.`Id_Ingreso` = `ingreso`.`Id`)  LEFT JOIN `profesional1`   ON (`profesional1`.`Id_Persona` = ingreso.`Id_Profesional`)  WHERE (ingreso.`Id` ='" + this.xidIngreso + "')");
                    xrsProcedimiento.first();
                    this.xDxPIngreso = xrsAtencionI.getString("DxIngreso");
                    this.xApellido1 = xrsAtencionE.getString("Apellido1");
                    this.xApellido2 = xrsAtencionE.getString("Apellido2");
                    this.xNombre1 = xrsAtencionE.getString("Nombre1");
                    this.xNombre2 = xrsAtencionE.getString("Nombre2");
                    this.xTipoDoc = xrsAtencionE.getString("Id_TipoIdentificacion");
                    this.xNoDocumento = xrsAtencionE.getString("NoDocumento");
                    this.xRegMedico = xrsAtencionE.getString("Tarjeta");
                    this.xFechaEgreso = xrsAtencionE.getString("FechaSO");
                    this.xHoraEgreso = xrsAtencionE.getString("HoraSO");
                    this.xDxEgreso = xrsAtencionE.getString("DxP");
                    this.xDxEgreso2 = xrsAtencionE.getString("DxR1");
                    this.xDxEgreso3 = xrsAtencionE.getString("DxR2");
                }
            } else if (xrsAtencionI.getString("Id_TipoAtencion").equals("3") || xrsAtencionI.getString("Id_TipoAtencion").equals("2") || xrsAtencionI.getString("Id_TipoAtencion").equals("4") || xrsAtencionI.getString("Id_TipoAtencion").equals("5") || xrsAtencionI.getString("Id_TipoAtencion").equals("6") || xrsAtencionI.getString("Id_TipoAtencion").equals("7") || xrsAtencionI.getString("Id_TipoAtencion").equals("8") || xrsAtencionI.getString("Id_TipoAtencion").equals("9") || xrsAtencionI.getString("Id_TipoAtencion").equals("10")) {
                this.xApellido1 = xrsAtencionE.getString("Apellido1");
                this.xApellido2 = xrsAtencionE.getString("Apellido2");
                this.xNombre1 = xrsAtencionE.getString("Nombre1");
                this.xNombre2 = xrsAtencionE.getString("Nombre2");
                this.xTipoDoc = xrsAtencionE.getString("Id_TipoIdentificacion");
                this.xNoDocumento = xrsAtencionE.getString("NoDocumento");
                this.xRegMedico = xrsAtencionE.getString("Tarjeta");
                this.xFechaEgreso = xrsAtencionE.getString("FechaSO");
                this.xHoraEgreso = xrsAtencionE.getString("HoraSO");
                this.xDxEgreso = xrsAtencionE.getString("DxP");
                this.xDxEgreso2 = xrsAtencionE.getString("DxR1");
                this.xDxEgreso3 = xrsAtencionE.getString("DxR2");
                this.xDxPIngreso = xrsAtencionI.getString("Codigo_Dxp");
            }
            ComponentBuilder componentBuilderNewRow3 = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Fecha de ingreso", 9), emptyCell(1), textCell(xrsAtencionI.getString("FechaIngreso"), 8), emptyCell(2), label("a las", 3), emptyCell(1), textCell(xrsAtencionI.getString("HoraIngreso"), 4), emptyCell(2)}).add(new ComponentBuilder[]{label("Fecha de Egreso", 9), emptyCell(1), textCell(this.xFechaEgreso, 8), emptyCell(2), label("a las", 3), emptyCell(1), textCell(this.xHoraEgreso, 4)}).newRow(2).add(new ComponentBuilder[]{label("Código Diagnóstico principal de Ingreso", 16), textCell(this.xDxPIngreso, 4), emptyCell(4), label("Código Diagnóstico principal de Egreso", 18), textCell(this.xDxEgreso, 4)}).newRow(3).add(new ComponentBuilder[]{label("Otro Código Diagnóstico de ingreso", 16), textCell(xrsAtencionI.getString("Codigo_DxR1"), 4), emptyCell(4), label("Otro código Diagnóstico principal de Egreso", 18), textCell(this.xDxEgreso2, 4)}).newRow(3).add(new ComponentBuilder[]{label("Otro Código Diagnóstico de ingreso", 16), textCell(xrsAtencionI.getString("Codigo_DxR2"), 4), emptyCell(4), label("Otro código Diagnóstico principal de Egreso", 18), textCell(this.xDxEgreso3, 4)}).newRow(3);
            ComponentBuilder componentBuilderNewRow4 = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP(this.xApellido1, 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(this.xApellido2, 25)}).newRow(2).add(new ComponentBuilder[]{emptyCell(4), label("1er Apellido del Médico o Profesional tratante", 18)}).add(new ComponentBuilder[]{emptyCell(15), label("2do Apellido del Médico o Profesional tratante", 18)}).newRow(2).add(new ComponentBuilder[]{labelP(this.xNombre1, 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(this.xNombre2, 25)}).newRow(2).add(new ComponentBuilder[]{emptyCell(4), label("1er Nombre del Médico o Profesional tratante", 18)}).add(new ComponentBuilder[]{emptyCell(15), label("2do Nombre del Médico o Profesional tratante", 18)}).newRow(2).add(new ComponentBuilder[]{TipoDocumentoAtencion(this.xTipoDoc), emptyCell(3)}).newRow(1).add(new ComponentBuilder[]{label("No. Documento", 9), textCell(this.xNoDocumento, 16)}).newRow(2).add(new ComponentBuilder[]{label("Número de Registro Médico", 17), textCell(this.xRegMedico, 16)}).newRow(2);
            String xtotal = "0";
            String xtotaltrasporte = "0";
            String xtotal1 = "0";
            String xtotal2 = "0";
            if (Double.parseDouble(this.xTotalEPS) - Double.parseDouble(this.xTotalTraslado) > 0.0d) {
                if (xrsaccidente.getInt("MPoliza") == 1) {
                    xtotal = String.valueOf(this.xmt.formatoMoneda1.format(Double.parseDouble(this.xTotalEPS) - Double.parseDouble(this.xTotalTraslado)));
                    xtotal1 = "0";
                    xtotal2 = "0";
                } else if (Principal.informacionIps.getNombreIps().equals("CAMI SAS")) {
                    xtotal = String.valueOf(this.xmt.formatoMoneda1.format(Double.parseDouble(this.xTotalEPS) - Double.parseDouble(this.xTotalTraslado)));
                    xtotal1 = String.valueOf(this.xmt.formatoMoneda1.format(Double.parseDouble(this.xTotalEPS) - Double.parseDouble(this.xTotalTraslado)));
                } else {
                    xtotal1 = String.valueOf(this.xmt.formatoMoneda1.format(Double.parseDouble(this.xTotalEPS) - Double.parseDouble(this.xTotalTraslado)));
                }
            }
            if (Double.parseDouble(this.xTotalTraslado) > 0.0d) {
                if (xrsaccidente.getInt("MPoliza") == 1) {
                    xtotaltrasporte = String.valueOf(this.xmt.formatoMoneda1.format(Double.parseDouble(this.xTotalTraslado)));
                    xtotal2 = "0";
                } else {
                    xtotal2 = String.valueOf(this.xmt.formatoMoneda1.format(Double.parseDouble(this.xTotalTraslado)));
                    xtotaltrasporte = String.valueOf(this.xmt.formatoMoneda1.format(Double.parseDouble(this.xTotalTraslado)));
                }
                System.out.println("Traslado : " + xtotal2);
            }
            String RutaFirma = this.xmt.mRutaSoporte("SUBREPORTFIRMA_DIR");
            if (!RutaFirma.isEmpty()) {
                this.urFirma = RutaFirma + rsper.getString("UrlFA");
                System.out.println("firma" + this.urFirma);
                this.image = DynamicReports.cmp.image(this.urFirma).setImageScale(ImageScale.FILL_FRAME).setFixedDimension(100, 60);
            } else {
                this.urFirma = this.xmt.getDirectorioExportacion() + "Firmas" + this.xmt.getBarra() + rsper.getString("UrlFA");
                this.image = DynamicReports.cmp.image(this.urFirma).setImageScale(ImageScale.FILL_FRAME).setFixedDimension(100, 60);
            }
            ComponentBuilder componentBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(30), DynamicReports.cmp.text("VALOR TOTAL FACTURADO").setStyle(styleCuadroBlanco2), DynamicReports.cmp.text("VALOR RECLAMADO AL FOSYGA").setStyle(styleCuadroBlanco2)}).newRow().add(new ComponentBuilder[]{labelP("GASTOS MEDICO QUIRURGICOS", 30), DynamicReports.cmp.text(xtotal).setStyle(styleCuadroBlanco2), DynamicReports.cmp.text(xtotal1).setStyle(styleCuadroBlanco2)}).newRow().add(new ComponentBuilder[]{labelP("GASTOS DE TRANSPORTE Y MOVILIZACION DE LA VICTIMA", 30), DynamicReports.cmp.text(xtotaltrasporte).setStyle(styleCuadroBlanco2), DynamicReports.cmp.text(xtotal2).setStyle(styleCuadroBlanco2)}).newRow(5).add(new ComponentBuilder[]{DynamicReports.cmp.text("El total facturado y reclamado descrito en este numeral se debe detallar y hacer descripcion de las actividades, procedimientos, medicamentos, insumos, suministros y materiales, dentro del anexo técnico numero 2.")});
            HorizontalListBuilder horizontalListBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{DynamicReports.cmp.text("Como representante legal o Gerente de la Institución Prestadora de Servicios de Salud, declaró bajo la gravedad de juramento que toda la información contenida en este formulario es cierta y podrá se verificada  por la Dirección General de Financiamiento del Ministerio de la Protección Social , por el Administrador Fiduciario del Fondo de Solidaridad y Garantía Fosyga, por la Superintendencia Nacional de Salud o la  Contraloría General de la República con la IPS y las aseguradoras, de no ser así, acepto todas las consecuencias legales que produzca esta situación.")}).newRow(1);
            ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
            componentBuilderArr[0] = emptyCell(26);
            componentBuilderArr[1] = textCell(this.confirmar.equals("SI") ? "X" : "", 1);
            componentBuilderArr[2] = label("SI", 2, this.textStyle);
            HorizontalListBuilder horizontalListBuilderAdd = horizontalListBuilderNewRow.add(componentBuilderArr);
            ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
            componentBuilderArr2[0] = textCell(this.confirmar.equals("NO") ? "X" : "", 1);
            componentBuilderArr2[1] = label("NO", 2, this.textStyle);
            report.setTemplate(Templates_1.reportTemplate).setPageFormat(612, 1030, PageOrientation.PORTRAIT).setTextStyle(this.textStyle).title(new ComponentBuilder[]{DynamicReports.cmp.image(this.xmt.getRutaRep() + "Encabezado_Furips.png").setFixedDimension(592, 60), DynamicReports.cmp.text("VIII. DATOS DEL CONDUCTOR DEL VEHÍCULO INVOLUCRADO EN EL ACCIDENTE DE TRANSITO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(3), componentBuilderNewRow, DynamicReports.cmp.verticalGap(3), DynamicReports.cmp.text("IX. DATOS DE REMISION").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(3), this.Remision, DynamicReports.cmp.verticalGap(3), DynamicReports.cmp.text("X. AMPARO DE TRANSPORTE Y MOVILIZACION DE LA VICTIMA").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(3), componentBuilderNewRow2, DynamicReports.cmp.verticalGap(3), DynamicReports.cmp.text("XI. CERTIFICACION DE LA ATENCIÓN MEDICA DELA VICTIMA COMO PRUEBA DEL ACCIDENTE O EVENTO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(3), componentBuilderNewRow3, DynamicReports.cmp.verticalGap(3), DynamicReports.cmp.text("XII. DATOS DEL MÉDICO O PROFESIONAL TRATANTE").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(3), componentBuilderNewRow4, DynamicReports.cmp.verticalGap(3), DynamicReports.cmp.text("XIII. AMPAROS QUE RECLAMA").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(12), componentBuilderAdd, DynamicReports.cmp.verticalGap(3), DynamicReports.cmp.text("XIV. DECLARACION DE LA INSTITUCION PRESTADORA DE SERVICIOS DE SALUD.").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(6), horizontalListBuilderAdd.add(componentBuilderArr2).newRow(1).add(new ComponentBuilder[]{DynamicReports.cmp.xyList().add(0, 50, label(rsper.getString("Administrador").toUpperCase(), 20)).add(380, 0, this.image).setPositionType(ComponentPositionType.FLOAT)}).newRow(3).add(new ComponentBuilder[]{DynamicReports.cmp.horizontalList().setBaseStyle(DynamicReports.stl.style().setTopBorder(DynamicReports.stl.pen1Point()).setLeftPadding(230)), emptyCell(8)}).add(new ComponentBuilder[]{DynamicReports.cmp.horizontalList().setBaseStyle(DynamicReports.stl.style().setTopBorder(DynamicReports.stl.pen1Point()).setLeftPadding(230))}).newRow().add(new ComponentBuilder[]{DynamicReports.cmp.text("NOMBRE"), emptyCell(2), DynamicReports.cmp.text("FIRMA DEL REPRESENTANTE LEGAL, GERENTE O SU DELEGADO")}), DynamicReports.cmp.verticalGap(3)});
            try {
                report.toPdf(pdfExporter);
            } catch (DRException e) {
                Logger.getLogger(Furips_PB_V2023.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Furips_PB_V2023.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return report;
    }

    private HorizontalListBuilder TipoDocumento(String xtipoDoc) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Documento", 11)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xtipoDoc.equals("CC") ? "X" : "", 1);
        componentBuilderArr[1] = label("CC", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
        componentBuilderArr2[0] = textCell(xtipoDoc.equals("CE") ? "X" : "", 1);
        componentBuilderArr2[1] = label("CE", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[2];
        componentBuilderArr3[0] = textCell(xtipoDoc.equals("PA") ? "X" : "", 1);
        componentBuilderArr3[1] = label("PA", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[2];
        componentBuilderArr4[0] = textCell(xtipoDoc.equals("RC") ? "X" : "", 1);
        componentBuilderArr4[1] = label("RC", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoDoc.equals("TI") ? "X" : "", 1);
        componentBuilderArr5[1] = label("TI", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd6 = horizontalListBuilderAdd5.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[2];
        componentBuilderArr6[0] = textCell(xtipoDoc.equals("AS") ? "X" : "", 1);
        componentBuilderArr6[1] = label("AS", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd7 = horizontalListBuilderAdd6.add(componentBuilderArr6);
        ComponentBuilder[] componentBuilderArr7 = new ComponentBuilder[2];
        componentBuilderArr7[0] = textCell(xtipoDoc.equals("MS") ? "X" : "", 1);
        componentBuilderArr7[1] = label("MS", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd8 = horizontalListBuilderAdd7.add(componentBuilderArr7);
        ComponentBuilder[] componentBuilderArr8 = new ComponentBuilder[2];
        componentBuilderArr8[0] = textCell(xtipoDoc.equals("PT") ? "X" : "", 1);
        componentBuilderArr8[1] = label("PT", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd9 = horizontalListBuilderAdd8.add(componentBuilderArr8);
        ComponentBuilder[] componentBuilderArr9 = new ComponentBuilder[2];
        componentBuilderArr9[0] = textCell(xtipoDoc.equals("PE") ? "X" : "", 1);
        componentBuilderArr9[1] = label("PE", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd10 = horizontalListBuilderAdd9.add(componentBuilderArr9);
        ComponentBuilder[] componentBuilderArr10 = new ComponentBuilder[2];
        componentBuilderArr10[0] = textCell(xtipoDoc.equals("SC") ? "X" : "", 1);
        componentBuilderArr10[1] = label("SC", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd11 = horizontalListBuilderAdd10.add(componentBuilderArr10);
        ComponentBuilder[] componentBuilderArr11 = new ComponentBuilder[2];
        componentBuilderArr11[0] = textCell(xtipoDoc.equals("CD") ? "X" : "", 1);
        componentBuilderArr11[1] = label("CD", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd12 = horizontalListBuilderAdd11.add(componentBuilderArr11);
        ComponentBuilder[] componentBuilderArr12 = new ComponentBuilder[2];
        componentBuilderArr12[0] = textCell(xtipoDoc.equals("DE") ? "X" : "", 1);
        componentBuilderArr12[1] = label("DE", 2, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd12.add(componentBuilderArr12);
        return list;
    }

    private HorizontalListBuilder TipoDocumentoAtencion(String xtipoDoc) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Documento", 11)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xtipoDoc.equals("CC") ? "X" : "", 1);
        componentBuilderArr[1] = label("CC", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
        componentBuilderArr2[0] = textCell(xtipoDoc.equals("CE") ? "X" : "", 1);
        componentBuilderArr2[1] = label("CE", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[2];
        componentBuilderArr3[0] = textCell(xtipoDoc.equals("PA") ? "X" : "", 1);
        componentBuilderArr3[1] = label("PA", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[2];
        componentBuilderArr4[0] = textCell(xtipoDoc.equals("PT") ? "X" : "", 1);
        componentBuilderArr4[1] = label("PT", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoDoc.equals("PE") ? "X" : "", 1);
        componentBuilderArr5[1] = label("PE", 2, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd5.add(componentBuilderArr5);
        return list;
    }

    private HorizontalListBuilder Transporte(String xtrasp) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Transporte", 13)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[4];
        componentBuilderArr[0] = label("Ambulancia Básica", 8, this.textStyle);
        componentBuilderArr[1] = emptyCell(1);
        componentBuilderArr[2] = textCell(xtrasp.equals("1") ? "X" : "", 1);
        componentBuilderArr[3] = emptyCell(2);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = label("Ambulancia Medicalizada", 10, this.textStyle);
        componentBuilderArr2[1] = emptyCell(1);
        componentBuilderArr2[2] = textCell(xtrasp.equals("2") ? "X" : "", 1);
        HorizontalListBuilder list = horizontalListBuilderAdd2.add(componentBuilderArr2);
        return list;
    }

    private HorizontalListBuilder Zona(String xTEvento) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Zona", 3)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xTEvento.equals("U") ? "X" : "", 1);
        componentBuilderArr[1] = label("U", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
        componentBuilderArr2[0] = textCell(xTEvento.equals("R") ? "X" : "", 1);
        componentBuilderArr2[1] = label("R", 2, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd2.add(componentBuilderArr2);
        return list;
    }

    private FillerBuilder emptyCell(int size) {
        return DynamicReports.cmp.gap(10 * size, 10);
    }

    private HorizontalListBuilder textCell(String text, int size) {
        HorizontalListBuilder list = DynamicReports.cmp.horizontalList();
        String cellText = StringUtils.rightPad(text, size);
        for (char character : StringUtils.left(cellText, size).toCharArray()) {
            list.add(new ComponentBuilder[]{(TextFieldBuilder) DynamicReports.cmp.text(String.valueOf(character)).setStyle(this.cellStyle).setFixedDimension(10, 10)});
        }
        return list;
    }

    private TextFieldBuilder<String> label(String text, int size) {
        return label(text, size, this.labelStyle);
    }

    private TextFieldBuilder<String> label(String text, int size, StyleBuilder style) {
        TextFieldBuilder<String> label = DynamicReports.cmp.text(text).setFixedWidth(Integer.valueOf(10 * size));
        if (style != null) {
            label.setStyle(style);
        }
        return label;
    }

    private TextFieldBuilder<String> labelP(String text, int size) {
        return label(text, size, this.styleCamposLabel);
    }

    public String getUrFirma() {
        return this.urFirma;
    }

    public void setUrFirma(String urFirma) {
        this.urFirma = urFirma;
    }
}
