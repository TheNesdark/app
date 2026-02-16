package Facturacion;

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
import net.sf.dynamicreports.report.builder.component.TextFieldBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.PageOrientation;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: GenomaP.jar:Facturacion/Furips_PA.class */
public class Furips_PA {
    private static final int cellWidth = 10;
    private static final int cellHeight = 10;
    private StyleBuilder textStyle;
    private StyleBuilder centeredStyle;
    private StyleBuilder labelStyle;
    private StyleBuilder cellStyle;
    private StyleBuilder rootStyle;
    private StyleBuilder boldStyle;
    private StyleBuilder fount_roja;
    private StyleBuilder boldCenteredStyle;
    private StyleBuilder bold10CenteredStyle;
    static ResultSetMetaData rsmetadatos;
    private StyleBuilder bold14Style;
    private StyleBuilder styleCamposLabel;
    private ResultSet rsper;
    private String xevento;
    private String xpersona;
    private String xsql;
    private String xidIngreso;
    private String xNRadicacionG;
    private String xnValorG;
    private String xnRG;
    private Metodos xmt = new Metodos();
    private ConsultasMySQL xct = new ConsultasMySQL();
    private String xNumFactura = "";
    private String xnFolio = "";
    private Connection connection = this.xct.establecerConexionBd();

    public Furips_PA(String xevento, String xpersona, String xIngreso, String xNRadicacionG, String xnValorG) {
        this.xevento = "";
        this.xpersona = "";
        this.xidIngreso = "";
        this.xNRadicacionG = "";
        this.xnValorG = "";
        this.xnRG = "";
        this.xevento = xevento;
        this.xpersona = xpersona;
        this.xidIngreso = xIngreso;
        this.xnValorG = xnValorG;
        this.xNRadicacionG = xNRadicacionG;
        if (!xNRadicacionG.equals("")) {
            this.xnRG = "X";
        }
    }

    public JasperReportBuilder build() {
        this.xmt.mEliminarArchivo(new File(this.xmt.getRutaRep() + "furipsPA.pdf"));
        JasperPdfExporterBuilder pdfExporter = DynamicReports.export.pdfExporter(this.xmt.getRutaRep() + "furipsPA.pdf");
        JasperReportBuilder report = DynamicReports.report();
        new Templates_1();
        try {
            Statement persona = this.connection.createStatement();
            Statement evento = this.connection.createStatement();
            Statement factura = this.connection.createStatement();
            Statement accidente = this.connection.createStatement();
            this.rootStyle = DynamicReports.stl.style().setPadding(2);
            this.boldStyle = DynamicReports.stl.style(this.rootStyle).bold();
            this.boldCenteredStyle = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP);
            this.fount_roja = DynamicReports.stl.style(this.boldStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.TOP).setFontSize(7).setForegroundColor(Color.RED);
            this.bold10CenteredStyle = DynamicReports.stl.style(this.boldCenteredStyle).setFontSize(8);
            this.textStyle = DynamicReports.stl.style().setFontSize(8).setPadding(2);
            this.centeredStyle = DynamicReports.stl.style(this.textStyle).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            this.labelStyle = DynamicReports.stl.style(this.textStyle).setHorizontalAlignment(HorizontalAlignment.LEFT).bold();
            this.cellStyle = DynamicReports.stl.style(this.textStyle).setBorder(DynamicReports.stl.pen1Point()).setAlignment(HorizontalAlignment.CENTER, VerticalAlignment.MIDDLE);
            StyleBuilder styleEncabezados = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBackgroundColor(new Color(204, 255, 204)).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder styleCuadroBlanco = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(DynamicReports.stl.pen1Point());
            StyleBuilder styleCuadroBlanco2 = DynamicReports.stl.style(this.bold14Style).setFontSize(8).setHorizontalAlignment(HorizontalAlignment.JUSTIFIED).setBorder(DynamicReports.stl.pen1Point());
            this.styleCamposLabel = DynamicReports.stl.style(this.bold14Style).setFontSize(10).bold().setHorizontalAlignment(HorizontalAlignment.LEFT).setBorder(DynamicReports.stl.pen1Point());
            ResultSet xrs = evento.executeQuery("SELECT `a_tipoevento`.`idReporte` AS Evento,`a_eventoecat`.`Direccion` , DATE_FORMAT(`a_eventoecat`.`Fechaeventoecat`,'%d%m%Y') AS Fechaeventoecat , DATE_FORMAT(`a_eventoecat`.`Horaeventoecat`,'%H%i')AS Horaeventoecat  , UPPER(`g_departamento`.`Nbre`) AS Dpto ,`g_departamento`.`Id` AS CodDpto , `g_municipio`.`Nbre` AS Mpio , SUBSTRING(`g_municipio`.`Id`,3,5) AS CodMpio,`a_eventoecat`.`Zona` , `a_eventoecat`.`Descripcion`, `g_ips`.`Nbre` AS RSocial , `g_ips`.`CodigoOrganismo`  , CONCAT(`g_ips`.`Identificacion`,`g_ips`.`DigitoVerificacion`) AS Nit FROM g_ips,`a_eventoecat`   INNER JOIN `a_tipoevento`  ON (`a_eventoecat`.`Id_tipoevento` = `a_tipoevento`.`Id`)   INNER JOIN `g_municipio`   ON (`a_eventoecat`.`Id_Munucipio` = `g_municipio`.`Id`)  INNER JOIN `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)  WHERE (`a_eventoecat`.`Id` ='" + this.xevento + "')");
            xrs.first();
            this.rsper = persona.executeQuery("SELECT `g_persona`.`Apellido1` , `g_persona`.`Apellido2`  , `g_persona`.`Nombre1`  , `g_persona`.`Nombre2` , `g_persona`.`Id_TipoIdentificacion`  , `g_persona`.`NoDocumento` , DATE_FORMAT(`g_persona`.`FechaNac`,'%d%m%Y')AS FechaNac  , `g_persona`.`Id_Sexo`  , `g_persona`.`Direccion` , UPPER(`g_departamento`.`Nbre`) AS Dpto , `g_departamento`.`Id` AS CodDpto  , if(`g_persona`.`Telefono`='',`g_persona`.`Movil`,`g_persona`.`Telefono`) as Telefono , `g_municipio`.`Nbre` AS Mpio , SUBSTRING(`g_municipio`.`Id`,3,5) AS CodMpio , `a_eventoecat_paciente`.`Id_condvictima`  , `a_eventoecat_paciente`.`Id_Persona`  FROM `a_eventoecat_paciente`  INNER JOIN  `g_persona`  ON (`a_eventoecat_paciente`.`Id_Persona` = `g_persona`.`Id`)  INNER JOIN  `g_municipio`  ON (`g_persona`.`Id_Municipio` = `g_municipio`.`Id`)  INNER JOIN `g_departamento`  ON (`g_municipio`.`Id_Dpto` = `g_departamento`.`Id`)   WHERE (`a_eventoecat_paciente`.`Id_Ingreso` =" + this.xidIngreso + ") GROUP BY `a_eventoecat_paciente`.`Id_Persona`");
            this.rsper.first();
            this.xsql = "SELECT  `a_estadoasegveh`.`Id` AS `EstadoSeg`  , `a_marcavehiculo`.`Nbre` AS `marcaveh`  , `a_accidentetransito`.`Placa1Veh`                             , `a_tipovehiculo`.`Id` AS `tipoveh`  , `a_aseguradora`.`Codigo` AS `aseguradora`  , `a_accidentetransito`.`NoPoliza`                             ,if((a_accidentetransito.Id_estadoasegveh=3 or a_accidentetransito.Id_estadoasegveh=2 or a_accidentetransito.Id_estadoasegveh=5 or a_accidentetransito.Id_estadoasegveh=6),'', DATE_FORMAT(`a_accidentetransito`.`FechaInicPol`,'%d%m%Y'))AS FechaInicPol , if((a_accidentetransito.Id_estadoasegveh=3 or a_accidentetransito.Id_estadoasegveh=2 or a_accidentetransito.Id_estadoasegveh=5 or a_accidentetransito.Id_estadoasegveh=6),'',DATE_FORMAT(`a_accidentetransito`.`FechaFinPol`,'%d%m%Y')) AS FechaFinPol  , `a_accidentetransito`.`IntAutoridad`                            , `a_accidentetransito`.`Placa2Veh`  , if(`g_tipoidentificacion_Prop2`.`Nbre` is null,'',`g_tipoidentificacion_Prop2`.`Nbre`) AS `tdocprop2` , `a_accidentetransito`.`NoDocProp2`                            , `a_accidentetransito`.`Placa3Veh`  , if(`g_tipoidentificacion_Prop3`.`Nbre` is null,'',`g_tipoidentificacion_Prop3`.`Nbre`) AS `tdocprop3`  , `a_accidentetransito`.`NoDocProp3`                            , if(`g_tipoidentificacion_Prop`.`Id` is null,'',`g_tipoidentificacion_Prop`.`Id`) AS `tdocPROP`  , `a_accidentetransito`.`NodocumProp` , UPPER(`a_accidentetransito`.`Apellido1Prop`) AS Apellido1Prop                             , UPPER(`a_accidentetransito`.`Apellido2Prop`) AS Apellido2Prop  , UPPER(`a_accidentetransito`.`Nombre1Prop`) AS Nombre1Prop  , UPPER(`a_accidentetransito`.`Nombre2Prop`) AS Nombre2Prop  , `a_accidentetransito`.`DireccionProp`                            , `a_accidentetransito`.`TelefonoProp`  , if(`g_departamento`.`Nbre` is null,'',UPPER(`g_departamento`.`Nbre`)) AS `dptoPROP`,if(`g_departamento`.`Id` is null,'',`g_departamento`.`Id`) AS `CoddptoPROP` , if(`g_municipio`.`Nbre` is null,'',`g_municipio`.`Nbre`) AS `mpioPROP`,if(`g_municipio`.`Id` is null,'',SUBSTRING(`g_municipio`.`Id`,3,5))  AS `CodmpioPROP`                             , UPPER(`a_accidentetransito`.`Apellido1Cond`) AS Apellido1Cond , UPPER(`a_accidentetransito`.`Apellido2Cond`) AS Apellido2Cond , UPPER(`a_accidentetransito`.`Nombre1Cond`) AS Nombre1Cond , UPPER(`a_accidentetransito`.`Nombre2Cond`) AS Nombre2Cond                             , if(`g_tipoidentificacion_Cond`.`Nbre` is null,'',`g_tipoidentificacion_Cond`.`Nbre`) AS `tdocCond`  , `a_accidentetransito`.`NodocumCond`  , `a_accidentetransito`.`DireccionCond`                            , if(`g_departamento_Cond`.`Nbre` is null,'', UPPER(`g_departamento_Cond`.`Nbre`)) AS `dptoCond` , if(`g_municipio_Cond`.`Nbre` is null,'',`g_municipio_Cond`.`Nbre`) AS `mpioCond` , `a_accidentetransito`.`TelefonoCond`  FROM  `a_accidentetransito`  INNER JOIN  `a_estadoasegveh`   ON (`a_accidentetransito`.`Id_estadoasegveh` = `a_estadoasegveh`.`Id`)  INNER JOIN  `a_marcavehiculo`  ON (`a_accidentetransito`.`Id_marcavehiculo` = `a_marcavehiculo`.`Id`) INNER JOIN  `a_tipovehiculo`  ON (`a_accidentetransito`.`Id_tipovehiculo` = `a_tipovehiculo`.`Id`) INNER JOIN  `a_aseguradora`   ON (`a_accidentetransito`.`Id_aseguradora` = `a_aseguradora`.`Id`) LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop2` ON (`a_accidentetransito`.`TipodocProp2` = `g_tipoidentificacion_Prop2`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop`  ON (`a_accidentetransito`.`Id_tipodocProp` = `g_tipoidentificacion_Prop`.`Id`)  LEFT JOIN  `g_departamento`  ON (`a_accidentetransito`.`DepartProp` = `g_departamento`.`Id`)  LEFT JOIN  `g_municipio`  ON (`a_accidentetransito`.`MunicProp` = `g_municipio`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Cond`  ON (`a_accidentetransito`.`tipodocCond` = `g_tipoidentificacion_Cond`.`Id`)  LEFT JOIN  `g_departamento` AS `g_departamento_Cond`  ON (`a_accidentetransito`.`DepartCond` = `g_departamento_Cond`.`Id`)  LEFT JOIN  `g_municipio` AS `g_municipio_Cond`  ON (`a_accidentetransito`.`MunicCond` = `g_municipio_Cond`.`Id`)  LEFT JOIN  `g_tipoidentificacion` AS `g_tipoidentificacion_Prop3`  ON (`a_accidentetransito`.`TipodocProp3` = `g_tipoidentificacion_Prop3`.`Id`)  WHERE (`a_accidentetransito`.`Id_eventoecat` ='" + this.xevento + "')";
            ResultSet xrsaccidente = accidente.executeQuery(this.xsql);
            xrsaccidente.first();
            ResultSet xrsFactura = factura.executeQuery("SELECT `f_liquidacion`.`Id`, \n IF(cc_resolucion_dian.trasmision = 0,IF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento,CONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento)),\nIF(f_factura_evento.Prefijo = '',f_factura_evento.No_FacturaEvento_M,\nCONCAT(f_factura_evento.Prefijo,f_factura_evento.No_FacturaEvento_M))) AS `No_FacturaEvento` , \n `f_factura_evento`.`Prefijo` , `f_liquidacion`.`TotalEps` , if(f_liquidacion.NFolios=0, '',f_liquidacion.NFolios) NFolios \n FROM `a_eventoecat_paciente` LEFT JOIN `f_liquidacion`   ON (`a_eventoecat_paciente`.`Id_Ingreso` = `f_liquidacion`.`Id_Ingreso`)\n LEFT JOIN `f_factura_evento`  ON (`f_factura_evento`.`Id_Liquidacion` = `f_liquidacion`.`Id`) \n  LEFT JOIN cc_resolucion_dian ON (cc_resolucion_dian.Id = f_factura_evento.idResolucionDian)\n  WHERE (`a_eventoecat_paciente`.`Id_Ingreso` =" + this.xidIngreso + "  AND `f_liquidacion`.`Estado` =0) GROUP BY `f_liquidacion`.`Id`");
            if (xrsFactura.next()) {
                xrsFactura.first();
                this.xNumFactura = xrsFactura.getString("No_FacturaEvento");
                this.xnFolio = xrsFactura.getString("NFolios");
            }
            report.setTemplate(Templates_1.reportTemplate).setPageFormat(612, 1030, PageOrientation.PORTRAIT).setTextStyle(this.textStyle).title(new ComponentBuilder[]{DynamicReports.cmp.image(this.xmt.getRutaRep() + "Encabezado_Furips.png").setFixedDimension(592, 60), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Fecha Radicación", 8), emptyCell(1), textCell("DDMMAAAA", 8), emptyCell(1)}).add(new ComponentBuilder[]{label("RG", 2), emptyCell(0), textCell(this.xnRG, 1), emptyCell(4)}).add(new ComponentBuilder[]{label("No. Radicado", 6), DynamicReports.cmp.text(" \n").setStyle(styleEncabezados)}).newRow(3).add(new ComponentBuilder[]{label("No. Radicado Anterior (Respuesta\n a glosa, marcar x en RG)", 15), DynamicReports.cmp.text(this.xNRadicacionG + " \n").setStyle(styleCuadroBlanco), emptyCell(5)}).add(new ComponentBuilder[]{label("Nro Factura / Cuenta de cobro", 12), DynamicReports.cmp.text(this.xNumFactura + " \n").setStyle(styleCuadroBlanco)}), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("I. DATOS DE LA INSTITUCIÓN PRESTADORA DE SERVICIOS DE SALUD").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Razón Social ", 10), emptyCell(1), labelP(xrs.getString("RSocial"), 48)}).newRow(4).add(new ComponentBuilder[]{label("Código de Habilitación", 11)}).add(new ComponentBuilder[]{textCell(xrs.getString("CodigoOrganismo"), 12), emptyCell(17)}).add(new ComponentBuilder[]{label("NIT", 3)}).add(new ComponentBuilder[]{textCell(xrs.getString("Nit"), 16)}), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("II. DATOS DE LA VICTIMA DEL EVENTO CATASTRÓFICO O ACCIDENTE DE TRANSITO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP(this.rsper.getString("Apellido1"), 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(this.rsper.getString("Apellido2"), 25)}).newRow(1).add(new ComponentBuilder[]{emptyCell(10), label("1er Apellido", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Apellido", 11)}).newRow(1).add(new ComponentBuilder[]{labelP(this.rsper.getString("Nombre1"), 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(this.rsper.getString("Nombre2"), 25)}).newRow(1).add(new ComponentBuilder[]{emptyCell(10), label("1er Nombre", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Nombre", 11)}).newRow(2).add(new ComponentBuilder[]{TipoDocumento(this.rsper.getString("Id_TipoIdentificacion")), emptyCell(4)}).add(new ComponentBuilder[]{label("No. Documento", 8), emptyCell(2), textCell(this.rsper.getString("NoDocumento"), 16)}).newRow(1).add(new ComponentBuilder[]{label("Fecha de Nacimiento", 9), emptyCell(1), textCell(this.rsper.getString("FechaNac"), 8)}).add(new ComponentBuilder[]{emptyCell(10), Genero(this.rsper.getString("Id_Sexo")), emptyCell(4)}).newRow(2).add(new ComponentBuilder[]{label("Dirección Residencia", 9), emptyCell(1), textCell(this.rsper.getString("Direccion"), 40)}).newRow(1).add(new ComponentBuilder[]{label("Departamento", 9), emptyCell(1), textCell(this.rsper.getString("Dpto"), 16)}).add(new ComponentBuilder[]{emptyCell(5), label("Cod.", 3), emptyCell(1), textCell(this.rsper.getString("CodDpto"), 2)}).add(new ComponentBuilder[]{emptyCell(6), label("Telefono", 5), emptyCell(1), textCell(this.rsper.getString("Telefono"), 10)}).newRow(1).add(new ComponentBuilder[]{label("Municipio", 9), emptyCell(1), textCell(this.rsper.getString("Mpio"), 18)}).add(new ComponentBuilder[]{emptyCell(3), label("Cod.", 3), emptyCell(1), textCell(this.rsper.getString("CodMpio"), 3)}).newRow(1).add(new ComponentBuilder[]{CondicionVict(this.rsper.getString("Id_condvictima")), emptyCell(4)}), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("III. DATOS DEL SITIO DONDE OCURRIÓ EL EVENTO CATASTRÓFICO O EL ACCIDENTE DE TRANSITO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{TipoEvento(xrs.getString("Evento"))}).newRow(2).add(new ComponentBuilder[]{TipoEventoN(xrs.getString("Evento"))}).newRow(2).add(new ComponentBuilder[]{TipoEventoT(xrs.getString("Evento"))}).newRow(1).add(new ComponentBuilder[]{label("Otros", 3), emptyCell(1), textCell("", 1), emptyCell(1)}).add(new ComponentBuilder[]{label("Cual?", 3), emptyCell(1), textCell("", 19)}).newRow(1).add(new ComponentBuilder[]{label("Dirección de la ocurrencia", 12), emptyCell(1), textCell(xrs.getString("Direccion"), 40)}).newRow(2).add(new ComponentBuilder[]{label("Fecha Evento/Accidente", 12), emptyCell(1), textCell(xrs.getString("Fechaeventoecat"), 8), emptyCell(8)}).add(new ComponentBuilder[]{label("Hora", 6), emptyCell(1), textCell(xrs.getString("Horaeventoecat"), 4)}).newRow(2).add(new ComponentBuilder[]{label("Departamento", 8), emptyCell(1), textCell(xrs.getString("Dpto"), 16), emptyCell(4)}).add(new ComponentBuilder[]{label("Cod.", 4), emptyCell(1), textCell(xrs.getString("CodDpto"), 2)}).newRow(2).add(new ComponentBuilder[]{label("Municipio", 8), emptyCell(1), textCell(xrs.getString("Mpio"), 18), emptyCell(2)}).add(new ComponentBuilder[]{label("Cod.", 4), emptyCell(1), textCell(xrs.getString("CodMpio"), 3)}).add(new ComponentBuilder[]{emptyCell(3), Zona(xrs.getString("Zona"))}).newRow(3).add(new ComponentBuilder[]{label("Descripción Breve del Evento Catastrófico o Accidente de Transito", 40)}).newRow(2).add(new ComponentBuilder[]{label("Enuncie las principales caracteristicas del evento / accidente:", 24)}).newRow(2).add(new ComponentBuilder[]{DynamicReports.cmp.text(xrs.getString("Descripcion")).setStyle(styleCuadroBlanco2)}).newRow(), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("IV. DATOS DEL VEHICULO DEL ACCIDENTE DE TRANSITO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{EstadoSeguro(xrsaccidente.getString("EstadoSeg"))}).newRow(2).add(new ComponentBuilder[]{label("Marca", 4), labelP(xrsaccidente.getString("marcaveh"), 30), emptyCell(4)}).add(new ComponentBuilder[]{label("Placa:", 5), textCell(xrsaccidente.getString("Placa1Veh"), 6)}).newRow(1).add(new ComponentBuilder[]{TipServicio(xrsaccidente.getString("tipoveh"))}).newRow(1).add(new ComponentBuilder[]{label("Código de la Aseguradora", 15), textCell(xrsaccidente.getString("aseguradora"), 6)}).newRow(1).add(new ComponentBuilder[]{label("No. de la Póliza", 8), textCell(xrsaccidente.getString("NoPoliza"), 20), emptyCell(10)}).add(new ComponentBuilder[]{IntervAutoridad(xrsaccidente.getString("IntAutoridad"))}).newRow(1).add(new ComponentBuilder[]{label("Vigencia  Desde", 8), textCell(xrsaccidente.getString("FechaInicPol"), 8), emptyCell(1)}).add(new ComponentBuilder[]{label("Hasta", 4), textCell(xrsaccidente.getString("FechaFinPol"), 8), emptyCell(9)}).add(new ComponentBuilder[]{label("Cobro Excedente Póliza", 10), emptyCell(2), label("Si", 2), textCell("", 1), emptyCell(1), label("No", 2), textCell("X", 1)}).newRow(), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.text("V. DATOS DEL PROPIETARIO DEL VEHÍCULO").setStyle(styleEncabezados), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{labelP(xrsaccidente.getString("Apellido1Prop"), 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(xrsaccidente.getString("Apellido2Prop"), 25)}).newRow(1).add(new ComponentBuilder[]{emptyCell(10), label("1er Apellido ó Razón Social", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Apellido", 11)}).newRow(1).add(new ComponentBuilder[]{labelP(xrsaccidente.getString("Nombre1Prop"), 25), emptyCell(9)}).add(new ComponentBuilder[]{labelP(xrsaccidente.getString("Nombre2Prop"), 25)}).newRow(1).add(new ComponentBuilder[]{emptyCell(10), label("1er Nombre", 11)}).add(new ComponentBuilder[]{emptyCell(23), label("2do Nombre", 11)}).newRow(1).add(new ComponentBuilder[]{TipoDocumentoProp(xrsaccidente.getString("tdocPROP")), emptyCell(4)}).add(new ComponentBuilder[]{label("No. Documento", 8), emptyCell(2), textCell(xrsaccidente.getString("NodocumProp"), 16)}).newRow(1).add(new ComponentBuilder[]{label("Dirección Residencia", 9), emptyCell(1), textCell(xrsaccidente.getString("DireccionProp"), 40)}).newRow(1).add(new ComponentBuilder[]{label("Departamento", 9), emptyCell(1), textCell(xrsaccidente.getString("dptoPROP"), 16)}).add(new ComponentBuilder[]{emptyCell(5), label("Cod.", 3), emptyCell(1), textCell(xrsaccidente.getString("CoddptoPROP"), 2)}).add(new ComponentBuilder[]{emptyCell(5), label("Telefono", 5), emptyCell(1), textCell(xrsaccidente.getString("TelefonoProp"), 11)}).newRow(1).add(new ComponentBuilder[]{label("Municipio", 9), emptyCell(1), textCell(xrsaccidente.getString("mpioPROP"), 18)}).add(new ComponentBuilder[]{emptyCell(3), label("Cod.", 3), emptyCell(1), textCell(xrsaccidente.getString("CodmpioPROP"), 3)}).newRow(), DynamicReports.cmp.verticalGap(2), DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{emptyCell(50), label("N° Folios", 5), textCell(this.xnFolio, 4)}).newRow(1)});
            try {
                report.toPdf(pdfExporter);
            } catch (DRException e) {
                Logger.getLogger(Furips_PA.class.getName()).log(Level.SEVERE, (String) null, e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Furips_PA.class.getName()).log(Level.SEVERE, (String) null, (Throwable) ex);
        }
        return report;
    }

    private HorizontalListBuilder Genero(String xGenero) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Sexo", 3)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xGenero.equals("M") ? "X" : "", 1);
        componentBuilderArr[1] = label("M", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
        componentBuilderArr2[0] = textCell(xGenero.equals("F") ? "X" : "", 1);
        componentBuilderArr2[1] = label("F", 3, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd2.add(componentBuilderArr2);
        return list;
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
        componentBuilderArr3[0] = textCell(xtipoDoc.equals("TI") ? "X" : "", 1);
        componentBuilderArr3[1] = label("TI", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[2];
        componentBuilderArr4[0] = textCell(xtipoDoc.equals("RC") ? "X" : "", 1);
        componentBuilderArr4[1] = label("RC", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoDoc.equals("AS") ? "X" : "", 1);
        componentBuilderArr5[1] = label("AS", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd6 = horizontalListBuilderAdd5.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[2];
        componentBuilderArr6[0] = textCell(xtipoDoc.equals("MS") ? "X" : "", 1);
        componentBuilderArr6[1] = label("MS", 2, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd6.add(componentBuilderArr6);
        return list;
    }

    private HorizontalListBuilder TipoDocumentoProp(String xtipoDoc) {
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
        componentBuilderArr4[0] = textCell(xtipoDoc.equals("NI") ? "X" : "", 1);
        componentBuilderArr4[1] = label("NI", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[2];
        componentBuilderArr5[0] = textCell(xtipoDoc.equals("TI") ? "X" : "", 1);
        componentBuilderArr5[1] = label("TI", 2, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd6 = horizontalListBuilderAdd5.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[2];
        componentBuilderArr6[0] = textCell(xtipoDoc.equals("RC") ? "X" : "", 1);
        componentBuilderArr6[1] = label("RC", 2, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd6.add(componentBuilderArr6);
        return list;
    }

    private HorizontalListBuilder CondicionVict(String xCond) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Condición del Accidentado:", 11)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[2];
        componentBuilderArr[0] = textCell(xCond.equals("1") ? "X" : "", 1);
        componentBuilderArr[1] = label("Conductor", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[2];
        componentBuilderArr2[0] = textCell(xCond.equals("2") ? "X" : "", 1);
        componentBuilderArr2[1] = label("Peatón", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[2];
        componentBuilderArr3[0] = textCell(xCond.equals("3") ? "X" : "", 1);
        componentBuilderArr3[1] = label("Ocupante", 10, this.textStyle);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[2];
        componentBuilderArr4[0] = textCell(xCond.equals("4") ? "X" : "", 1);
        componentBuilderArr4[1] = label("Ciclista", 10, this.textStyle);
        HorizontalListBuilder list = horizontalListBuilderAdd4.add(componentBuilderArr4);
        return list;
    }

    private HorizontalListBuilder TipoEvento(String xTEvento) {
        HorizontalListBuilder horizontalListBuilderNewRow = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Naturaleza del Evento:", 11)}).newRow(3);
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = emptyCell(10);
        componentBuilderArr[1] = label("Accidente de Tránsito", 9, this.textStyle);
        componentBuilderArr[2] = textCell(xTEvento.equals("01") ? "X" : "", 1);
        HorizontalListBuilder list = horizontalListBuilderNewRow.add(componentBuilderArr);
        return list;
    }

    private HorizontalListBuilder TipoEventoN(String xTEvento) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Naturales:", 6)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = emptyCell(4);
        componentBuilderArr[1] = label("Sismo", 9, this.textStyle);
        componentBuilderArr[2] = textCell(xTEvento.equals("02") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = emptyCell(1);
        componentBuilderArr2[1] = label("Maremoto", 9, this.textStyle);
        componentBuilderArr2[2] = textCell(xTEvento.equals("03") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[3];
        componentBuilderArr3[0] = emptyCell(1);
        componentBuilderArr3[1] = label("Erupciones Volcánicas", 9, this.textStyle);
        componentBuilderArr3[2] = textCell(xTEvento.equals("04") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[3];
        componentBuilderArr4[0] = emptyCell(1);
        componentBuilderArr4[1] = label("Huracán", 9, this.textStyle);
        componentBuilderArr4[2] = textCell(xTEvento.equals("16") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderNewRow = horizontalListBuilderAdd4.add(componentBuilderArr4).newRow(3);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[3];
        componentBuilderArr5[0] = emptyCell(10);
        componentBuilderArr5[1] = label("Inundaciones", 9, this.textStyle);
        componentBuilderArr5[2] = textCell(xTEvento.equals("06") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderNewRow.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[3];
        componentBuilderArr6[0] = emptyCell(1);
        componentBuilderArr6[1] = label("Avalancha", 9, this.textStyle);
        componentBuilderArr6[2] = textCell(xTEvento.equals("07") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd6 = horizontalListBuilderAdd5.add(componentBuilderArr6);
        ComponentBuilder[] componentBuilderArr7 = new ComponentBuilder[3];
        componentBuilderArr7[0] = emptyCell(1);
        componentBuilderArr7[1] = label("Deslizamiento de Tierra", 9, this.textStyle);
        componentBuilderArr7[2] = textCell(xTEvento.equals("05") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd7 = horizontalListBuilderAdd6.add(componentBuilderArr7);
        ComponentBuilder[] componentBuilderArr8 = new ComponentBuilder[3];
        componentBuilderArr8[0] = emptyCell(1);
        componentBuilderArr8[1] = label("Incendio Natural", 9, this.textStyle);
        componentBuilderArr8[2] = textCell(xTEvento.equals("08") ? "X" : "", 1);
        HorizontalListBuilder list = horizontalListBuilderAdd7.add(componentBuilderArr8);
        return list;
    }

    private HorizontalListBuilder TipoEventoT(String xTEvento) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Terroristas:", 6)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = emptyCell(4);
        componentBuilderArr[1] = label("Explosión", 9, this.textStyle);
        componentBuilderArr[2] = textCell(xTEvento.equals("09") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = emptyCell(1);
        componentBuilderArr2[1] = label("Masacre", 9, this.textStyle);
        componentBuilderArr2[2] = textCell(xTEvento.equals("13") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[3];
        componentBuilderArr3[0] = emptyCell(1);
        componentBuilderArr3[1] = label("Mina Antipersonal", 9, this.textStyle);
        componentBuilderArr3[2] = textCell(xTEvento.equals("15") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[3];
        componentBuilderArr4[0] = emptyCell(1);
        componentBuilderArr4[1] = label("Combate", 9, this.textStyle);
        componentBuilderArr4[2] = textCell(xTEvento.equals("11") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderNewRow = horizontalListBuilderAdd4.add(componentBuilderArr4).newRow(3);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[3];
        componentBuilderArr5[0] = emptyCell(10);
        componentBuilderArr5[1] = label("Incendio", 9, this.textStyle);
        componentBuilderArr5[2] = textCell(xTEvento.equals("11") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderNewRow.add(componentBuilderArr5);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[3];
        componentBuilderArr6[0] = emptyCell(1);
        componentBuilderArr6[1] = label("Ataques a Municipios", 9, this.textStyle);
        componentBuilderArr6[2] = textCell(xTEvento.equals("11") ? "X" : "", 1);
        HorizontalListBuilder list = horizontalListBuilderAdd5.add(componentBuilderArr6);
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

    private HorizontalListBuilder EstadoSeguro(String xEstSeg) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Estado de Aseguramiento:", 11)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = emptyCell(1);
        componentBuilderArr[1] = label("Asegurado", 5, this.textStyle);
        componentBuilderArr[2] = textCell(xEstSeg.equals("1") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = emptyCell(1);
        componentBuilderArr2[1] = label("No Asegurado", 7, this.textStyle);
        componentBuilderArr2[2] = textCell(xEstSeg.equals("2") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[3];
        componentBuilderArr3[0] = emptyCell(1);
        componentBuilderArr3[1] = label("Vehiculo Fantasma", 8, this.textStyle);
        componentBuilderArr3[2] = textCell(xEstSeg.equals("3") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[3];
        componentBuilderArr4[0] = emptyCell(1);
        componentBuilderArr4[1] = label("Póliza Falsa", 7, this.textStyle);
        componentBuilderArr4[2] = textCell(xEstSeg.equals("4") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[3];
        componentBuilderArr5[0] = emptyCell(1);
        componentBuilderArr5[1] = label("Vehículo en fuga", 8, this.textStyle);
        componentBuilderArr5[2] = textCell(xEstSeg.equals("5") ? "X" : "", 1);
        HorizontalListBuilder list = horizontalListBuilderAdd5.add(componentBuilderArr5);
        return list;
    }

    private HorizontalListBuilder TipServicio(String xServ) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Tipo de Servicio:", 7)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = emptyCell(1);
        componentBuilderArr[1] = label("Particular", 5, this.textStyle);
        componentBuilderArr[2] = textCell(xServ.equals("3") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = emptyCell(1);
        componentBuilderArr2[1] = label("Público", 5, this.textStyle);
        componentBuilderArr2[2] = textCell(xServ.equals("4") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd3 = horizontalListBuilderAdd2.add(componentBuilderArr2);
        ComponentBuilder[] componentBuilderArr3 = new ComponentBuilder[3];
        componentBuilderArr3[0] = emptyCell(1);
        componentBuilderArr3[1] = label("Oficial", 5, this.textStyle);
        componentBuilderArr3[2] = textCell(xServ.equals("5") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd4 = horizontalListBuilderAdd3.add(componentBuilderArr3);
        ComponentBuilder[] componentBuilderArr4 = new ComponentBuilder[3];
        componentBuilderArr4[0] = emptyCell(1);
        componentBuilderArr4[1] = label("Vehículo de emergencia", 10, this.textStyle);
        componentBuilderArr4[2] = textCell(xServ.equals("6") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd5 = horizontalListBuilderAdd4.add(componentBuilderArr4);
        ComponentBuilder[] componentBuilderArr5 = new ComponentBuilder[3];
        componentBuilderArr5[0] = emptyCell(1);
        componentBuilderArr5[1] = label("Vehículo de servicio diplomático o consular", 16, this.textStyle);
        componentBuilderArr5[2] = textCell(xServ.equals("7") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderNewRow = horizontalListBuilderAdd5.add(componentBuilderArr5).newRow(3);
        ComponentBuilder[] componentBuilderArr6 = new ComponentBuilder[3];
        componentBuilderArr6[0] = emptyCell(8);
        componentBuilderArr6[1] = label("Vehículo de transporte masivo", 13, this.textStyle);
        componentBuilderArr6[2] = textCell(xServ.equals("8") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd6 = horizontalListBuilderNewRow.add(componentBuilderArr6);
        ComponentBuilder[] componentBuilderArr7 = new ComponentBuilder[3];
        componentBuilderArr7[0] = emptyCell(1);
        componentBuilderArr7[1] = label("Vehículo escolar", 8, this.textStyle);
        componentBuilderArr7[2] = textCell(xServ.equals("9") ? "X" : "", 1);
        HorizontalListBuilder list = horizontalListBuilderAdd6.add(componentBuilderArr7);
        return list;
    }

    private HorizontalListBuilder IntervAutoridad(String xrespuesta) {
        HorizontalListBuilder horizontalListBuilderAdd = DynamicReports.cmp.horizontalList().add(new ComponentBuilder[]{label("Intervención de autoridad", 11)});
        ComponentBuilder[] componentBuilderArr = new ComponentBuilder[3];
        componentBuilderArr[0] = emptyCell(1);
        componentBuilderArr[1] = label("Si", 2, this.textStyle);
        componentBuilderArr[2] = textCell(xrespuesta.equals("1") ? "X" : "", 1);
        HorizontalListBuilder horizontalListBuilderAdd2 = horizontalListBuilderAdd.add(componentBuilderArr);
        ComponentBuilder[] componentBuilderArr2 = new ComponentBuilder[3];
        componentBuilderArr2[0] = emptyCell(1);
        componentBuilderArr2[1] = label("No", 2, this.textStyle);
        componentBuilderArr2[2] = textCell(xrespuesta.equals("0") ? "X" : "", 1);
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
}
